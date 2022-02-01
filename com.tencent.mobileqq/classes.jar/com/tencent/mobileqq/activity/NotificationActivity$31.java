package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class NotificationActivity$31
  implements DialogInterface.OnClickListener
{
  NotificationActivity$31(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    NotificationActivity.access$1200(this.a, "0X800B657");
    ReportController.a(this.a.getAppRuntime(), "dc00898", "", NotificationActivity.access$1000(this.a), "0X800AA32", "0X800AA32", 0, 0, "", "", "", NotificationActivity.access$300(this.a));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.31
 * JD-Core Version:    0.7.0.1
 */