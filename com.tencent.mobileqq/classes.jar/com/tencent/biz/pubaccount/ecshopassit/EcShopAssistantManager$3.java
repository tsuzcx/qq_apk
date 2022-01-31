package com.tencent.biz.pubaccount.ecshopassit;

import awbw;
import awbx;
import com.tencent.mobileqq.app.QQAppInterface;
import ntw;

public class EcShopAssistantManager$3
  implements Runnable
{
  public EcShopAssistantManager$3(ntw paramntw, String paramString) {}
  
  public void run()
  {
    awbw localawbw = this.this$0.a.getEntityManagerFactory().createEntityManager();
    if (ntw.a(this.this$0, localawbw, this.a)) {
      ntw.a(this.this$0, this.a);
    }
    localawbw.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.3
 * JD-Core Version:    0.7.0.1
 */