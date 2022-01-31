package com.tencent.biz.pubaccount.ecshopassit;

import aukn;
import auko;
import com.tencent.mobileqq.app.QQAppInterface;
import nqq;

public class EcShopAssistantManager$3
  implements Runnable
{
  public EcShopAssistantManager$3(nqq paramnqq, String paramString) {}
  
  public void run()
  {
    aukn localaukn = this.this$0.a.getEntityManagerFactory().createEntityManager();
    if (nqq.a(this.this$0, localaukn, this.a)) {
      nqq.a(this.this$0, this.a);
    }
    localaukn.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.3
 * JD-Core Version:    0.7.0.1
 */