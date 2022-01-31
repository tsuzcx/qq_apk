package com.tencent.mobileqq.activity.aio.helper;

import adjq;
import balp;
import balq;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class TroopNotificationAIOHelper$1
  implements Runnable
{
  public TroopNotificationAIOHelper$1(adjq paramadjq) {}
  
  public void run()
  {
    if (adjq.a(this.this$0) == null) {}
    balp localbalp;
    do
    {
      do
      {
        return;
      } while (adjq.a(this.this$0).a == null);
      localbalp = balq.a(adjq.a(this.this$0).a, adjq.a(this.this$0).a());
    } while ((localbalp == null) || (localbalp.a != 0));
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationAIOHelper", 2, "handleTroopNotificationOnResume, readTroopNotification.");
    }
    balq.d(adjq.a(this.this$0).a, adjq.a(this.this$0).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.1
 * JD-Core Version:    0.7.0.1
 */