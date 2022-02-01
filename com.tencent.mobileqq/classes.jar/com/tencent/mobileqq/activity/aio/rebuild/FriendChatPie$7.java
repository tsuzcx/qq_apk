package com.tencent.mobileqq.activity.aio.rebuild;

import aijm;
import android.os.Bundle;
import android.os.Message;
import mqq.os.MqqHandler;

public class FriendChatPie$7
  implements Runnable
{
  public FriendChatPie$7(aijm paramaijm) {}
  
  public void run()
  {
    Message localMessage = aijm.c(this.this$0).obtainMessage(42);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showRedDot", false);
    localMessage.setData(localBundle);
    aijm.d(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.7
 * JD-Core Version:    0.7.0.1
 */