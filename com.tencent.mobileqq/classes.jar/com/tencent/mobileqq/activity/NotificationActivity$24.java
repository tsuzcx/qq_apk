package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.security.FrozenNotifyDlgHelper;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class NotificationActivity$24
  implements DialogInterface.OnClickListener
{
  NotificationActivity$24(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FrozenNotifyDlgHelper.a().a(this.a.app, NotificationActivity.access$500(this.a), 1, NotificationActivity.access$200(this.a));
    if (NotificationActivity.access$600(this.a)) {
      if (MiniAppSecurityUtil.checkMiniAppForLogin(NotificationActivity.access$700(this.a))) {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.a, NotificationActivity.access$700(this.a), NotificationActivity.access$800(this.a), null);
      }
    }
    for (;;)
    {
      this.a.finish();
      return;
      QLog.e("NotificationActivity", 1, "MiniAppLauncher.startMiniApp error: fake app!");
      continue;
      paramDialogInterface = FrozenNotifyDlgHelper.a().a(NotificationActivity.access$700(this.a), NotificationActivity.access$900(this.a), NotificationActivity.access$1000(this.a));
      Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      this.a.startActivity(localIntent.putExtra("url", paramDialogInterface));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.24
 * JD-Core Version:    0.7.0.1
 */