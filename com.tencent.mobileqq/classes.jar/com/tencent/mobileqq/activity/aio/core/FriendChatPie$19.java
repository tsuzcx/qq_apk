package com.tencent.mobileqq.activity.aio.core;

import agab;
import aiyq;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class FriendChatPie$19
  implements Runnable
{
  public FriendChatPie$19(agab paramagab) {}
  
  public void run()
  {
    if (aiyq.a(this.this$0.app, this.this$0.sessionInfo.curFriendUin))
    {
      agab.b(this.this$0, true);
      aiyq.a(this.this$0.app, this.this$0.sessionInfo.curFriendUin);
      this.this$0.app.reportClickEvent("CliOper", "", "", "0X8008072", "0X8008072", 0, 0, "", "", "", "");
      return;
    }
    agab.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.19
 * JD-Core Version:    0.7.0.1
 */