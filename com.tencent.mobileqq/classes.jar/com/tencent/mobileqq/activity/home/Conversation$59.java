package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.statistics.ReportController;

class Conversation$59
  implements Runnable
{
  Conversation$59(Conversation paramConversation, Object paramObject) {}
  
  public void run()
  {
    if ((this.a instanceof String)) {}
    for (;;)
    {
      try
      {
        i = Integer.parseInt((String)this.a);
        ReportController.b(this.this$0.a, "dc00898", "", "", "0X80087C2", "0X80087C2", i, 0, "1", "", "", "");
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.59
 * JD-Core Version:    0.7.0.1
 */