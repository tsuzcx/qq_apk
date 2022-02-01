package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.ReportController;

class AccountManageActivity$22
  implements DialogInterface.OnClickListener
{
  AccountManageActivity$22(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
    RouteUtils.a(this.a, paramDialogInterface, "/base/subAccount/bind");
    ReportController.b(this.a.app, "CliOper", "", "", "0X80040A6", "0X80040A6", 0, 0, "", "", "", "");
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.22
 * JD-Core Version:    0.7.0.1
 */