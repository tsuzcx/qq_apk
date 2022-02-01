package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

class NotificationActivity$7
  implements DialogInterface.OnClickListener
{
  NotificationActivity$7(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = null;
    ReportController.a(null, "dc00898", "", "", "0X800B430", "0X800B430", 0, 0, "", "", "", "");
    this.a.app.logout(true);
    SharedPreUtils.a(this.a.app.getApp(), this.a.app.getCurrentAccountUin(), false);
    Object localObject = (SubAccountManager)this.a.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    if (localObject != null) {
      paramDialogInterface = ((SubAccountManager)localObject).a();
    }
    if ((paramDialogInterface != null) && (paramDialogInterface.size() > 0))
    {
      paramDialogInterface = paramDialogInterface.iterator();
      while (paramDialogInterface.hasNext())
      {
        localObject = (String)paramDialogInterface.next();
        if (!PhoneNumLoginImpl.a().a(this.a.app, (String)localObject))
        {
          this.a.app.updateSubAccountLogin((String)localObject, false);
          this.a.app.getApplication().refreAccountList();
        }
      }
    }
    paramDialogInterface = new Intent().addFlags(67108864);
    RouteUtils.a(this.a, paramDialogInterface, "/base/login");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.7
 * JD-Core Version:    0.7.0.1
 */