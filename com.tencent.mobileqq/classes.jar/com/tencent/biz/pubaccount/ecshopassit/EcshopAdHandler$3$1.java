package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import nqu;
import nqw;
import nqx;

public class EcshopAdHandler$3$1
  implements Runnable
{
  public EcshopAdHandler$3$1(nqw paramnqw, Object paramObject) {}
  
  public void run()
  {
    ChatMessage localChatMessage = (ChatMessage)this.a;
    nqu localnqu = (nqu)this.this$0.a.getBusinessHandler(139);
    nqx localnqx = new nqx();
    localnqx.a = 10;
    localnqu.a(nqu.a(localnqx, localChatMessage), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.3.1
 * JD-Core Version:    0.7.0.1
 */