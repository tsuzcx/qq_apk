package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.newfriend.CloneFriendPushHelper;
import com.tencent.mobileqq.statistics.ReportController;

class FriendChatPie$15
  implements Runnable
{
  FriendChatPie$15(FriendChatPie paramFriendChatPie) {}
  
  public void run()
  {
    if (CloneFriendPushHelper.b(this.this$0.d, this.this$0.ah.b))
    {
      FriendChatPie.b(this.this$0, true);
      CloneFriendPushHelper.a(this.this$0.d, this.this$0.ah.b);
      ReportController.b(this.this$0.d, "CliOper", "", "", "0X8008072", "0X8008072", 0, 0, "", "", "", "");
      return;
    }
    FriendChatPie.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.15
 * JD-Core Version:    0.7.0.1
 */