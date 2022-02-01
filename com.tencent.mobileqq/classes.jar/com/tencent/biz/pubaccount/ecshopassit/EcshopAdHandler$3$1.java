package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import odh;
import odj;
import odk;

public class EcshopAdHandler$3$1
  implements Runnable
{
  public EcshopAdHandler$3$1(odj paramodj, Object paramObject) {}
  
  public void run()
  {
    ChatMessage localChatMessage = (ChatMessage)this.a;
    odh localodh = (odh)this.this$0.a.getBusinessHandler(139);
    odk localodk = new odk();
    localodk.a = 10;
    localodh.a(odh.a(localodk, localChatMessage), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.3.1
 * JD-Core Version:    0.7.0.1
 */