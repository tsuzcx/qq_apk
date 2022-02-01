package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.vip.LhHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class NotificationActivity$36
  implements Runnable
{
  NotificationActivity$36(NotificationActivity paramNotificationActivity) {}
  
  public void run()
  {
    int i = NotificationActivity.access$1400(this.this$0).c();
    QLog.e("LhHelper", 1, "handleLhExpire userStatus = " + i);
    if (i == 1) {
      NotificationActivity.access$1500(this.this$0).sendEmptyMessage(1);
    }
    do
    {
      return;
      if (i == 2)
      {
        NotificationActivity.access$1500(this.this$0).sendEmptyMessage(2);
        return;
      }
    } while (i != 3);
    NotificationActivity.access$1500(this.this$0).sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.36
 * JD-Core Version:    0.7.0.1
 */