package com.tencent.mobileqq.activity.home;

import bcec;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class Conversation$26
  implements Runnable
{
  Conversation$26(Conversation paramConversation) {}
  
  public void run()
  {
    int i = bcec.a();
    try
    {
      MqqHandler localMqqHandler = this.this$0.a;
      if ((i >= 0) && (localMqqHandler != null))
      {
        localMqqHandler.removeMessages(1134061);
        localMqqHandler.sendEmptyMessageDelayed(1134061, i * 1000L);
      }
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        QLog.e("Q.recent", 1, localNullPointerException, new Object[0]);
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.26
 * JD-Core Version:    0.7.0.1
 */