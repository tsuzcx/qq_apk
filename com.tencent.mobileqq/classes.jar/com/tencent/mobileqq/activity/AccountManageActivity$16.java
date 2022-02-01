package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class AccountManageActivity$16
  implements View.OnClickListener
{
  AccountManageActivity$16(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "add account");
    }
    if (AccountManageActivity.h(this.a)) {
      if ((this.a.e != null) && (this.a.e.size() - 1 >= 8))
      {
        QQToast.makeText(this.a, 2131891426, 0).show();
      }
      else
      {
        AccountManageActivity.b(this.a, ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).isAnyAccountBind(this.a.app));
        Intent localIntent = new Intent();
        localIntent.setPackage(this.a.getPackageName());
        localIntent.setClass(this.a, AddAccountActivity.class);
        QLog.d("AccountManageActivity", 2, "onAddAccountClick AccountManageActivity-addAccountFrom1 ");
        localIntent.putExtra("fromWhereExactly", 1);
        this.a.startActivityForResult(localIntent, 1000);
        ((ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class)).doSomethingBeforeAddAccount(this.a.app, this.a);
        ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_acc_add", 0, 0, "", "", "", "");
        ReportController.a(this.a.app, "0X800B837");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.16
 * JD-Core Version:    0.7.0.1
 */