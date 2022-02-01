package com.tencent.mobileqq.activity.aio.core;

import agab;
import android.os.Bundle;
import android.os.Message;
import mqq.os.MqqHandler;

public class FriendChatPie$7
  implements Runnable
{
  public FriendChatPie$7(agab paramagab) {}
  
  public void run()
  {
    Message localMessage = this.this$0.uiHandler.obtainMessage(42);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showRedDot", false);
    localMessage.setData(localBundle);
    this.this$0.uiHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.7
 * JD-Core Version:    0.7.0.1
 */