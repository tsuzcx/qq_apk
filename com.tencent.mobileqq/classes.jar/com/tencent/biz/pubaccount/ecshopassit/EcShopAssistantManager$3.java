package com.tencent.biz.pubaccount.ecshopassit;

import atmp;
import atmq;
import com.tencent.mobileqq.app.QQAppInterface;
import nfp;

public class EcShopAssistantManager$3
  implements Runnable
{
  public EcShopAssistantManager$3(nfp paramnfp, String paramString) {}
  
  public void run()
  {
    atmp localatmp = this.this$0.a.getEntityManagerFactory().createEntityManager();
    if (nfp.a(this.this$0, localatmp, this.a)) {
      nfp.a(this.this$0, this.a);
    }
    localatmp.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.3
 * JD-Core Version:    0.7.0.1
 */