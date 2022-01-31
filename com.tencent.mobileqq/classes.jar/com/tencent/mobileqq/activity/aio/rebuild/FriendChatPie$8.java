package com.tencent.mobileqq.activity.aio.rebuild;

import agps;
import android.os.Bundle;
import android.os.Message;
import mqq.os.MqqHandler;

public class FriendChatPie$8
  implements Runnable
{
  public FriendChatPie$8(agps paramagps) {}
  
  public void run()
  {
    Message localMessage = agps.c(this.this$0).obtainMessage(42);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showRedDot", false);
    localMessage.setData(localBundle);
    agps.d(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.8
 * JD-Core Version:    0.7.0.1
 */