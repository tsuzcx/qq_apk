package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.qqsec.api.FrozenKickUtils;
import com.tencent.mobileqq.qqsec.api.ISecControllerInterface;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class NotificationActivity$7
  implements DialogInterface.OnClickListener
{
  NotificationActivity$7(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.a(null, "dc00898", "", "", "0X800B430", "0X800B430", 0, 0, "", "", "", "");
    this.a.getAppRuntime().logout(true);
    FrozenKickUtils.a(this.a.getAppRuntime().getApp(), this.a.getAppRuntime().getCurrentAccountUin(), false);
    paramDialogInterface = NotificationActivity.access$100().b((BaseQQAppInterface)this.a.getAppRuntime());
    if ((paramDialogInterface != null) && (paramDialogInterface.size() > 0))
    {
      paramDialogInterface = paramDialogInterface.iterator();
      while (paramDialogInterface.hasNext())
      {
        String str = (String)paramDialogInterface.next();
        if (!PhoneNumLoginImpl.a().a(this.a.getAppRuntime(), str))
        {
          this.a.getAppRuntime().updateSubAccountLogin(str, false);
          this.a.getAppRuntime().getApplication().refreAccountList();
        }
      }
    }
    paramDialogInterface = new Intent().addFlags(67108864);
    RouteUtils.a(this.a, paramDialogInterface, "/base/login");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.7
 * JD-Core Version:    0.7.0.1
 */