package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import nqx;
import nqz;
import nra;

public class EcshopAdHandler$3$1
  implements Runnable
{
  public EcshopAdHandler$3$1(nqz paramnqz, Object paramObject) {}
  
  public void run()
  {
    ChatMessage localChatMessage = (ChatMessage)this.a;
    nqx localnqx = (nqx)this.this$0.a.getBusinessHandler(139);
    nra localnra = new nra();
    localnra.a = 10;
    localnqx.a(nqx.a(localnra, localChatMessage), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.3.1
 * JD-Core Version:    0.7.0.1
 */