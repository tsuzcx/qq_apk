package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.data.ChatMessage;

class EcshopAdHandler$3$1
  implements Runnable
{
  EcshopAdHandler$3$1(EcshopAdHandler.3 param3, Object paramObject) {}
  
  public void run()
  {
    ChatMessage localChatMessage = (ChatMessage)this.a;
    EcshopAdHandler localEcshopAdHandler = (EcshopAdHandler)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER);
    EcshopAdHandler.ReportInfo localReportInfo = new EcshopAdHandler.ReportInfo();
    localReportInfo.a = 10;
    localEcshopAdHandler.a(EcshopAdHandler.a(localReportInfo, localChatMessage), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.3.1
 * JD-Core Version:    0.7.0.1
 */