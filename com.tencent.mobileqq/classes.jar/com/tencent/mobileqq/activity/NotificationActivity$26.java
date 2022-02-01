package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class NotificationActivity$26
  implements DialogInterface.OnClickListener
{
  NotificationActivity$26(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    NotificationActivity.access$1200(this.a, "0X800B654");
    ReportController.a(this.a.getAppRuntime(), "dc00898", "", "", "0X800AA17", "0X800AA17", 0, 0, "", "", NotificationActivity.access$1300(this.a), "");
    paramDialogInterface = this.a.getIntent();
    if (paramDialogInterface != null) {
      if (paramDialogInterface.getBooleanExtra("keyFromLoginView", false))
      {
        ReportController.a(this.a.getAppRuntime(), "dc00898", "", "", "0X800B293", "0X800B293", 0, 0, "", "", NotificationActivity.access$300(this.a), "");
      }
      else if (paramDialogInterface.getBooleanExtra("keyFromAddAccount", false))
      {
        ReportController.a(this.a.getAppRuntime(), "dc00898", "", "", "0X800B295", "0X800B295", 0, 0, "", "", NotificationActivity.access$300(this.a), "");
        paramInt = 2119;
        break label160;
      }
    }
    paramInt = 2098;
    label160:
    if (MiniAppSecurityUtil.checkMiniAppForLogin(NotificationActivity.access$800(this.a)))
    {
      paramDialogInterface = (IMiniAppService)QRoute.api(IMiniAppService.class);
      NotificationActivity localNotificationActivity = this.a;
      paramDialogInterface.startMiniApp(localNotificationActivity, NotificationActivity.access$800(localNotificationActivity), paramInt, null);
    }
    else
    {
      QLog.e("NotificationActivity", 1, "MiniAppLauncher.startMiniApp error: fake app!");
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.26
 * JD-Core Version:    0.7.0.1
 */