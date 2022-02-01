package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.vip.LhHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class NotificationActivity$39
  implements Runnable
{
  NotificationActivity$39(NotificationActivity paramNotificationActivity) {}
  
  public void run()
  {
    boolean bool = NotificationActivity.access$1400(this.this$0).a();
    QLog.e("LhHelper", 1, "receiveLhCard result = " + bool);
    if (bool)
    {
      if (NotificationActivity.access$1400(this.this$0).b())
      {
        NotificationActivity.access$1500(this.this$0).sendEmptyMessage(5);
        return;
      }
      NotificationActivity.access$1500(this.this$0).sendEmptyMessage(6);
      return;
    }
    NotificationActivity.access$1500(this.this$0).sendEmptyMessage(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.39
 * JD-Core Version:    0.7.0.1
 */