package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.security.FrozenNotifyDlgHelper;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.ReportController;

class NotificationActivity$30
  implements DialogInterface.OnClickListener
{
  NotificationActivity$30(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NotificationActivity.access$1400(this.a))
    {
      FrozenNotifyDlgHelper.a().a(this.a);
      NotificationActivity.access$1200(this.a, "0X800B655");
      return;
    }
    ReportController.a(this.a.getAppRuntime(), "dc00898", "", NotificationActivity.access$1000(this.a), "0X800AA31", "0X800AA31", 0, 0, "", "", "", NotificationActivity.access$300(this.a));
    paramDialogInterface = new Intent();
    RouteUtils.a(this.a, paramDialogInterface.putExtra("url", "https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027"), "/base/browser");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.30
 * JD-Core Version:    0.7.0.1
 */