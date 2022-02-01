package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.hotchat.api.IHotChatHandler;
import com.tencent.mobileqq.qroute.QRoute;

class HotChatPie$8
  implements Runnable
{
  HotChatPie$8(HotChatPie paramHotChatPie) {}
  
  public void run()
  {
    ((IHotChatHandler)this.this$0.d.getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName())).getGlobalAdmin(this.this$0.d.getLongAccountUin(), this.this$0.ah.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.8
 * JD-Core Version:    0.7.0.1
 */