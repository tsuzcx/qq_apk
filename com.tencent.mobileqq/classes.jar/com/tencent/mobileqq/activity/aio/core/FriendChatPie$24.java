package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;

class FriendChatPie$24
  implements Runnable
{
  FriendChatPie$24(FriendChatPie paramFriendChatPie) {}
  
  public void run()
  {
    ((IOnlineStatusService)this.this$0.d.getRuntimeService(IOnlineStatusService.class, "")).getOlympicMedalEventReq(true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.24
 * JD-Core Version:    0.7.0.1
 */