package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.qroute.QRoute;

class HotChatPie$7
  implements Runnable
{
  HotChatPie$7(HotChatPie paramHotChatPie) {}
  
  public void run()
  {
    int i = this.this$0.bR.state;
    IHotChatApi localIHotChatApi = (IHotChatApi)QRoute.api(IHotChatApi.class);
    localIHotChatApi.delHotChatRecentUserNotNotifyUi(this.this$0.d, this.this$0.ah.b, i);
    localIHotChatApi.invokeRecentUserChangedToConversation(this.this$0.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.7
 * JD-Core Version:    0.7.0.1
 */