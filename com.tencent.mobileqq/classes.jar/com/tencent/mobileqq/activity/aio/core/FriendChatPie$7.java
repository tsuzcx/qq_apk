package com.tencent.mobileqq.activity.aio.core;

import android.os.Bundle;
import android.os.Message;
import mqq.os.MqqHandler;

class FriendChatPie$7
  implements Runnable
{
  FriendChatPie$7(FriendChatPie paramFriendChatPie) {}
  
  public void run()
  {
    Message localMessage = this.this$0.a.obtainMessage(42);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showRedDot", false);
    localMessage.setData(localBundle);
    this.this$0.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.7
 * JD-Core Version:    0.7.0.1
 */