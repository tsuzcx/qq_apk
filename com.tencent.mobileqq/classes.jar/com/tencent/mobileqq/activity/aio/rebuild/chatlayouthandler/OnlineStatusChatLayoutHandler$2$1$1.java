package com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.relation.api.IFriendHandlerTempService;
import mqq.app.AppRuntime;

class OnlineStatusChatLayoutHandler$2$1$1
  implements Runnable
{
  OnlineStatusChatLayoutHandler$2$1$1(OnlineStatusChatLayoutHandler.2.1 param1) {}
  
  public void run()
  {
    ((IFriendHandlerTempService)this.a.b.getRuntimeService(IFriendHandlerTempService.class, "")).getOnlineInfo(this.a.c.a.selfuin, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.OnlineStatusChatLayoutHandler.2.1.1
 * JD-Core Version:    0.7.0.1
 */