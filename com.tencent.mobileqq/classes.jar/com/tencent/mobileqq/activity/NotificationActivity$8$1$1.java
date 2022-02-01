package com.tencent.mobileqq.activity;

class NotificationActivity$8$1$1
  implements Runnable
{
  NotificationActivity$8$1$1(NotificationActivity.8.1 param1) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(1500L);
      this.a.a.a.exitApp();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.8.1.1
 * JD-Core Version:    0.7.0.1
 */