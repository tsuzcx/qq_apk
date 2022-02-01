package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import oge;
import ogg;
import ogh;

public class EcshopAdHandler$3$1
  implements Runnable
{
  public EcshopAdHandler$3$1(ogg paramogg, Object paramObject) {}
  
  public void run()
  {
    ChatMessage localChatMessage = (ChatMessage)this.a;
    oge localoge = (oge)this.this$0.a.getBusinessHandler(139);
    ogh localogh = new ogh();
    localogh.a = 10;
    localoge.a(oge.a(localogh, localChatMessage), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.3.1
 * JD-Core Version:    0.7.0.1
 */