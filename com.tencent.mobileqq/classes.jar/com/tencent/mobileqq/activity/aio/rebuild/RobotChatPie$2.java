package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Bundle;
import android.os.Message;
import mqq.os.MqqHandler;

class RobotChatPie$2
  implements Runnable
{
  RobotChatPie$2(RobotChatPie paramRobotChatPie) {}
  
  public void run()
  {
    Message localMessage = RobotChatPie.a(this.this$0).obtainMessage(42);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showRedDot", false);
    localMessage.setData(localBundle);
    RobotChatPie.b(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie.2
 * JD-Core Version:    0.7.0.1
 */