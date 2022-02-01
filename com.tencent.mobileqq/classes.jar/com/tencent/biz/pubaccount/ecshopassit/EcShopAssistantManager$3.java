package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;

class EcShopAssistantManager$3
  implements Runnable
{
  EcShopAssistantManager$3(EcShopAssistantManager paramEcShopAssistantManager, String paramString) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.this$0.c.getEntityManagerFactory().createEntityManager();
    if (EcShopAssistantManager.a(this.this$0, localEntityManager, this.a)) {
      EcShopAssistantManager.a(this.this$0, this.a);
    }
    localEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.3
 * JD-Core Version:    0.7.0.1
 */