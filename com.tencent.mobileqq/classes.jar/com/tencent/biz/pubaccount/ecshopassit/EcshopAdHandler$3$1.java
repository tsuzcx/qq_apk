package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import oer;
import oet;
import oeu;

public class EcshopAdHandler$3$1
  implements Runnable
{
  public EcshopAdHandler$3$1(oet paramoet, Object paramObject) {}
  
  public void run()
  {
    ChatMessage localChatMessage = (ChatMessage)this.a;
    oer localoer = (oer)this.this$0.a.getBusinessHandler(139);
    oeu localoeu = new oeu();
    localoeu.a = 10;
    localoer.a(oer.a(localoeu, localChatMessage), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.3.1
 * JD-Core Version:    0.7.0.1
 */