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
    NotificationActivity.access$1100(this.a, "0X800B657");
    ReportController.a(this.a.app, "dc00898", "", NotificationActivity.access$900(this.a), "0X800AA32", "0X800AA32", 0, 0, "", "", "", NotificationActivity.access$200(this.a));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.31
 * JD-Core Version:    0.7.0.1
 */