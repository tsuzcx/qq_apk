package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import ofx;

public class EcShopAssistantManager$3
  implements Runnable
{
  public EcShopAssistantManager$3(ofx paramofx, String paramString) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.this$0.a.getEntityManagerFactory().createEntityManager();
    if (ofx.a(this.this$0, localEntityManager, this.a)) {
      ofx.a(this.this$0, this.a);
    }
    localEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.3
 * JD-Core Version:    0.7.0.1
 */