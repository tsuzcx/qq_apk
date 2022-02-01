package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class AccountManageActivity$19
  implements View.OnClickListener
{
  AccountManageActivity$19(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "add account");
    }
    if (!AccountManageActivity.b(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.a.a != null) && (this.a.a.size() - 1 >= 8))
      {
        QQToast.a(this.a, 2131693892, 0).a();
      }
      else
      {
        AccountManageActivity.b(this.a, SubAccountControll.a(this.a.app));
        Intent localIntent = new Intent();
        localIntent.setPackage(this.a.getPackageName());
        localIntent.setClass(this.a, AddAccountActivity.class);
        this.a.startActivityForResult(localIntent, 1000);
        this.a.overridePendingTransition(2130771999, 2130771992);
        SubAccountAssistantForward.b(this.a.app, this.a);
        ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_acc_add", 0, 0, "", "", "", "");
        ReportController.a(this.a.app, "0X800B837");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.19
 * JD-Core Version:    0.7.0.1
 */