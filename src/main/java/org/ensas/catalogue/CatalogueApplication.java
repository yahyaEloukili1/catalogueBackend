package org.ensas.catalogue;

import org.ensas.catalogue.dao.ProduitRepository;
import org.ensas.catalogue.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CatalogueApplication implements CommandLineRunner {

	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(CatalogueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Produit.class);
		produitRepository.save(new Produit(null,"ordinateur",10000,4));
		produitRepository.save(new Produit(null,"imprimente",3000,2));
		produitRepository.save(new Produit(null,"Samsung",7000,5));
		
		produitRepository.findAll().forEach(p->{
			System.out.println(p);
		});
	}

}
