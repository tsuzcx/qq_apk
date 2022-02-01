package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.security.FrozenNotifyDlgHelper;
import com.tencent.mobileqq.app.utils.RouteUtils;
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
    FrozenNotifyDlgHelper.a().a((BaseQQAppInterface)this.a.getAppRuntime(), NotificationActivity.access$600(this.a), 1, NotificationActivity.access$300(this.a));
    Object localObject;
    if (NotificationActivity.access$700(this.a))
    {
      if (MiniAppSecurityUtil.checkMiniAppForLogin(NotificationActivity.access$800(this.a)))
      {
        paramDialogInterface = (IMiniAppService)QRoute.api(IMiniAppService.class);
        localObject = this.a;
        paramDialogInterface.startMiniApp((Context)localObject, NotificationActivity.access$800((NotificationActivity)localObject), NotificationActivity.access$900(this.a), null);
      }
      else
      {
        QLog.e("NotificationActivity", 1, "MiniAppLauncher.startMiniApp error: fake app!");
      }
    }
    else
    {
      paramDialogInterface = FrozenNotifyDlgHelper.a().a(NotificationActivity.access$800(this.a), NotificationActivity.access$1000(this.a), NotificationActivity.access$1100(this.a));
      localObject = new Intent();
      RouteUtils.a(this.a, ((Intent)localObject).putExtra("url", paramDialogInterface), "/base/browser");
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.24
 * JD-Core Version:    0.7.0.1
 */