package com.tencent.mobileqq.activity.aio.core;

import afiw;
import aidr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class FriendChatPie$19
  implements Runnable
{
  public FriendChatPie$19(afiw paramafiw) {}
  
  public void run()
  {
    if (aidr.a(this.this$0.app, this.this$0.sessionInfo.curFriendUin))
    {
      afiw.b(this.this$0, true);
      aidr.a(this.this$0.app, this.this$0.sessionInfo.curFriendUin);
      this.this$0.app.reportClickEvent("CliOper", "", "", "0X8008072", "0X8008072", 0, 0, "", "", "", "");
      return;
    }
    afiw.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.19
 * JD-Core Version:    0.7.0.1
 */