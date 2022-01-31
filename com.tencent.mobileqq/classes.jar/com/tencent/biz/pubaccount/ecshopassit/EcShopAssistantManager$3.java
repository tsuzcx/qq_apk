package com.tencent.biz.pubaccount.ecshopassit;

import awgf;
import awgg;
import com.tencent.mobileqq.app.QQAppInterface;
import ntw;

public class EcShopAssistantManager$3
  implements Runnable
{
  public EcShopAssistantManager$3(ntw paramntw, String paramString) {}
  
  public void run()
  {
    awgf localawgf = this.this$0.a.getEntityManagerFactory().createEntityManager();
    if (ntw.a(this.this$0, localawgf, this.a)) {
      ntw.a(this.this$0, this.a);
    }
    localawgf.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.3
 * JD-Core Version:    0.7.0.1
 */