package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;

class AccountManageActivity$15
  implements View.OnClickListener
{
  AccountManageActivity$15(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004038", "0X8004038", 0, 0, String.valueOf(this.a.e.size()), "", "", "");
    if (AccountManageActivity.h(this.a))
    {
      AccountManageActivity.b(this.a, ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).isAnyAccountBind(this.a.app));
      Object localObject1 = paramView.getTag();
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Switch_Account", 2, "switch a non-existing account");
        }
      }
      else
      {
        int i = ((Integer)localObject1).intValue();
        localObject1 = (SimpleAccount)this.a.e.get(i);
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("switch uin:");
          ((StringBuilder)localObject2).append(((SimpleAccount)localObject1).getUin());
          QLog.d("Switch_Account", 2, ((StringBuilder)localObject2).toString());
        }
        if ((localObject1 != null) && (!((SimpleAccount)localObject1).getUin().equals(this.a.app.getCurrentAccountUin())))
        {
          ReportController.b(this.a.app, "CliOper", "", "", "0X8009C05", "0X8009C05", 0, 0, "", "", "", "");
          this.a.f();
          localObject2 = this.a;
          ((AccountManageActivity)localObject2).m = ((SimpleAccount)localObject1);
          AccountManageActivity.c((AccountManageActivity)localObject2, true);
          AccountManageActivity.d(this.a, true);
          ReportController.b(this.a.app, "dc00898", "", "", "0X800AC38", "0X800AC38", 0, 0, "", "", "", "");
          this.a.app.switchAccount((SimpleAccount)localObject1, null);
          ((ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class)).doSomethingAfterSwitchAccount(this.a.app, this.a);
          boolean bool = ((ISubAccountService)this.a.app.getRuntimeService(ISubAccountService.class, "")).isSubAccountUin(((SimpleAccount)localObject1).getUin());
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onSelectAccountClick AccountManageActivity-changeAccountClick");
          ((StringBuilder)localObject1).append(bool);
          QLog.d("AccountManageActivity", 2, ((StringBuilder)localObject1).toString());
          localObject2 = this.a.app;
          if (bool) {
            localObject1 = "1";
          } else {
            localObject1 = "2";
          }
          ReportController.b((AppRuntime)localObject2, "dc00898", "", "", "0X800BDF0", "0X800BDF0", 0, 0, (String)localObject1, "", "", "");
        }
        AlbumUtil.b();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.15
 * JD-Core Version:    0.7.0.1
 */