package com.tencent.biz.pubaccount.ecshopassit;

import aukp;
import aukq;
import com.tencent.mobileqq.app.QQAppInterface;
import nqn;

public class EcShopAssistantManager$3
  implements Runnable
{
  public EcShopAssistantManager$3(nqn paramnqn, String paramString) {}
  
  public void run()
  {
    aukp localaukp = this.this$0.a.getEntityManagerFactory().createEntityManager();
    if (nqn.a(this.this$0, localaukp, this.a)) {
      nqn.a(this.this$0, this.a);
    }
    localaukp.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.3
 * JD-Core Version:    0.7.0.1
 */