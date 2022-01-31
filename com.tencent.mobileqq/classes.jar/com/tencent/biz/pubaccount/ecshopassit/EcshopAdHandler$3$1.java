package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import nud;
import nuf;
import nug;

public class EcshopAdHandler$3$1
  implements Runnable
{
  public EcshopAdHandler$3$1(nuf paramnuf, Object paramObject) {}
  
  public void run()
  {
    ChatMessage localChatMessage = (ChatMessage)this.a;
    nud localnud = (nud)this.this$0.a.getBusinessHandler(139);
    nug localnug = new nug();
    localnug.a = 10;
    localnud.a(nud.a(localnug, localChatMessage), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.3.1
 * JD-Core Version:    0.7.0.1
 */