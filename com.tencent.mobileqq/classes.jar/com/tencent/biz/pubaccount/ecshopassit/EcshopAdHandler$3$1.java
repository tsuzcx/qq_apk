package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import onx;
import onz;
import ooa;

public class EcshopAdHandler$3$1
  implements Runnable
{
  public EcshopAdHandler$3$1(onz paramonz, Object paramObject) {}
  
  public void run()
  {
    ChatMessage localChatMessage = (ChatMessage)this.a;
    onx localonx = (onx)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER);
    ooa localooa = new ooa();
    localooa.a = 10;
    localonx.a(onx.a(localooa, localChatMessage), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.3.1
 * JD-Core Version:    0.7.0.1
 */