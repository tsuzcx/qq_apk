package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class NotificationActivity$18
  implements DialogInterface.OnClickListener
{
  NotificationActivity$18(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      ReportController.b(null, "P_CliOper", "Safe_StartAppCheck", "", "DIALOG_PACKAGE_INVALID", "LeftButton", 0, 0, "", "", "", "");
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.18
 * JD-Core Version:    0.7.0.1
 */