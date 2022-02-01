package com.tencent.mobileqq.activity.home;

import android.os.Message;
import mqq.os.MqqHandler;

final class Conversation$42
  implements Runnable
{
  Conversation$42(MqqHandler paramMqqHandler) {}
  
  public void run()
  {
    this.a.removeMessages(1134065);
    Message localMessage = this.a.obtainMessage(1134065);
    localMessage.arg1 = 0;
    this.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.42
 * JD-Core Version:    0.7.0.1
 */