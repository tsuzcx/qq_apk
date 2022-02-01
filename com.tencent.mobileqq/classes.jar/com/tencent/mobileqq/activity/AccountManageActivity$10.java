package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountManageActivity$10
  implements View.OnClickListener
{
  AccountManageActivity$10(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i != 2131446545)
    {
      if (i == 2131446550)
      {
        localObject = null;
        if ((paramView.getTag() instanceof String)) {
          localObject = String.valueOf(paramView.getTag());
        }
        if ("0X8004001".equals(localObject))
        {
          ReportController.b(this.a.app, "CliOper", "", "", "0X8004002", "0X8004002", 0, 0, "", "", "", "");
          localObject = new Intent();
          ((Intent)localObject).putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
          ((Intent)localObject).putExtra("fromWhereExactly", 3);
          RouteUtils.a(this.a, (Intent)localObject, "/base/subAccount/ug");
        }
        else if ("0X8004456".equals(localObject))
        {
          ReportController.b(this.a.app, "CliOper", "", "", "0X8004457", "0X8004457", 0, 0, "", "", "", "");
          localObject = new Intent();
          ((Intent)localObject).putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
          ((Intent)localObject).putExtra("fromWhereExactly", 3);
          RouteUtils.a(this.a, (Intent)localObject, "/base/subAccount/bind");
          DBUtils.a().a(this.a.app.getCurrentAccountUin(), true);
        }
        QLog.d("AccountManageActivity", 2, "subAccountClickListener AccountManageActivity-bannerClick");
        ReportController.b(this.a.app, "dc00898", "", "", "0X800BDF2", "0X800BDF2", 0, 0, "", "", "", "");
      }
    }
    else
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
      ((Intent)localObject).putExtra("fromWhereExactly", 4);
      RouteUtils.a(paramView.getContext(), (Intent)localObject, "/base/activity/associatedAccount");
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004039", "0X8004039", 0, 0, "", "", "", "");
      ReportController.b(this.a.app, "dc00898", "", "", "0X800AC39", "0X800AC39", 0, 0, "", "", "", "");
      ReportController.a(this.a.app, "0X800B838");
      QLog.d("AccountManageActivity", 2, "subAccountClickListener AccountManageActivity-bindQQClick");
      ReportController.b(this.a.app, "dc00898", "", "", "0X800B838", "0X800B838", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.10
 * JD-Core Version:    0.7.0.1
 */