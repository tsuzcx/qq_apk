package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class AccountManageActivity$24
  implements DialogInterface.OnClickListener
{
  AccountManageActivity$24(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("AccountManageActivity", 1, "switchFail, to LoginActivity");
    ReportController.a(null, "dc00898", "", "", "0X800B430", "0X800B430", 0, 0, "", "", "", "");
    paramDialogInterface = new Intent();
    paramDialogInterface.setPackage(this.a.getPackageName());
    paramDialogInterface.putExtra("is_change_account", true);
    paramDialogInterface.putExtra("login_from_account_change", true);
    if (this.a.a != null) {
      paramDialogInterface.putExtra("uin", this.a.a.getUin());
    }
    paramDialogInterface.putExtra("befault_uin", this.a.app.getCurrentAccountUin());
    RouteUtils.a(this.a, paramDialogInterface, "/base/login", 9876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.24
 * JD-Core Version:    0.7.0.1
 */