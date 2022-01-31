package com.tencent.mobileqq.activity.aio.rebuild;

import aedo;
import android.os.Bundle;
import android.os.Message;
import mqq.os.MqqHandler;

public class FriendChatPie$9
  implements Runnable
{
  public FriendChatPie$9(aedo paramaedo) {}
  
  public void run()
  {
    Message localMessage = aedo.c(this.this$0).obtainMessage(42);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showRedDot", false);
    localMessage.setData(localBundle);
    aedo.d(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.9
 * JD-Core Version:    0.7.0.1
 */