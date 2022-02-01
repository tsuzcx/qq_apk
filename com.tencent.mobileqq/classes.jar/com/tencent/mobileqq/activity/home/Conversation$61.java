package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.statistics.ReportController;

class Conversation$61
  implements Runnable
{
  Conversation$61(Conversation paramConversation, Object paramObject) {}
  
  public void run()
  {
    Object localObject = this.a;
    int i;
    if ((localObject instanceof String)) {
      try
      {
        i = Integer.parseInt((String)localObject);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    } else {
      i = 0;
    }
    ReportController.b(this.this$0.aF, "dc00898", "", "", "0X80087C2", "0X80087C2", i, 0, "1", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.61
 * JD-Core Version:    0.7.0.1
 */