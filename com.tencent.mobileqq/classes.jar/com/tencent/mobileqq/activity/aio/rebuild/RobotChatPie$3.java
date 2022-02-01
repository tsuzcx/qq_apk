package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Bundle;
import android.os.Message;
import mqq.os.MqqHandler;

class RobotChatPie$3
  implements Runnable
{
  RobotChatPie$3(RobotChatPie paramRobotChatPie) {}
  
  public void run()
  {
    Message localMessage = RobotChatPie.a(this.this$0).obtainMessage(42);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showRedDot", false);
    localMessage.setData(localBundle);
    RobotChatPie.b(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie.3
 * JD-Core Version:    0.7.0.1
 */