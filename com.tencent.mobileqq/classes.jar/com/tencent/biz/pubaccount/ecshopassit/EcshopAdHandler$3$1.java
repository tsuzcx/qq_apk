package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import nfw;
import nfy;
import nfz;

public class EcshopAdHandler$3$1
  implements Runnable
{
  public EcshopAdHandler$3$1(nfy paramnfy, Object paramObject) {}
  
  public void run()
  {
    ChatMessage localChatMessage = (ChatMessage)this.a;
    nfw localnfw = (nfw)this.this$0.a.getBusinessHandler(139);
    nfz localnfz = new nfz();
    localnfz.a = 10;
    localnfw.a(nfw.a(localnfz, localChatMessage), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.3.1
 * JD-Core Version:    0.7.0.1
 */