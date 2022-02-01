package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountManageActivity$13
  implements View.OnClickListener
{
  AccountManageActivity$13(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i != 2131378045)
    {
      if (i == 2131378050)
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
          RouteUtils.a(this.a, (Intent)localObject, "/base/subAccount/ug");
        }
        else if ("0X8004456".equals(localObject))
        {
          ReportController.b(this.a.app, "CliOper", "", "", "0X8004457", "0X8004457", 0, 0, "", "", "", "");
          localObject = new Intent();
          ((Intent)localObject).putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
          RouteUtils.a(this.a, (Intent)localObject, "/base/subAccount/bind");
          DBUtils.a().a(this.a.app.getCurrentAccountUin(), true);
        }
      }
    }
    else
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
      RouteUtils.a(paramView.getContext(), (Intent)localObject, "/base/activity/associatedAccount");
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004039", "0X8004039", 0, 0, "", "", "", "");
      ReportController.b(this.a.app, "dc00898", "", "", "0X800AC39", "0X800AC39", 0, 0, "", "", "", "");
      ReportController.a(this.a.app, "0X800B838");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.13
 * JD-Core Version:    0.7.0.1
 */