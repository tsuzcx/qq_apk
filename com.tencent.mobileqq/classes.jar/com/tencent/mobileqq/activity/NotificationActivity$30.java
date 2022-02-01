package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqconnect.wtlogin.LoginHelper;

class NotificationActivity$30
  implements DialogInterface.OnClickListener
{
  NotificationActivity$30(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NotificationActivity.access$1300(this.a))
    {
      LoginHelper.a(this.a);
      NotificationActivity.access$1100(this.a, "0X800B655");
      return;
    }
    ReportController.a(this.a.app, "dc00898", "", NotificationActivity.access$900(this.a), "0X800AA31", "0X800AA31", 0, 0, "", "", "", NotificationActivity.access$200(this.a));
    paramDialogInterface = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    this.a.startActivity(paramDialogInterface.putExtra("url", "https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027"));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.30
 * JD-Core Version:    0.7.0.1
 */