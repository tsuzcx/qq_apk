package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountManageActivity$13
  implements View.OnClickListener
{
  AccountManageActivity$13(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = null;
      if ((paramView.getTag() instanceof String)) {
        localObject = String.valueOf(paramView.getTag());
      }
      if ("0X8004001".equals(localObject))
      {
        ReportController.b(this.a.app, "CliOper", "", "", "0X8004002", "0X8004002", 0, 0, "", "", "", "");
        localObject = new Intent(this.a, SubAccountUgActivity.class);
        ((Intent)localObject).putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
        this.a.startActivity((Intent)localObject);
      }
      else if ("0X8004456".equals(localObject))
      {
        ReportController.b(this.a.app, "CliOper", "", "", "0X8004457", "0X8004457", 0, 0, "", "", "", "");
        localObject = new Intent(this.a, SubAccountBindActivity.class);
        ((Intent)localObject).putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
        this.a.startActivity((Intent)localObject);
        DBUtils.a().a(this.a.app.getCurrentAccountUin(), true);
        continue;
        localObject = new Intent();
        ((Intent)localObject).setClass(paramView.getContext(), AssociatedAccountActivity.class);
        ((Intent)localObject).putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
        paramView.getContext().startActivity((Intent)localObject);
        ReportController.b(this.a.app, "CliOper", "", "", "0X8004039", "0X8004039", 0, 0, "", "", "", "");
        ReportController.b(this.a.app, "dc00898", "", "", "0X800AC39", "0X800AC39", 0, 0, "", "", "", "");
        ReportController.a(this.a.app, "0X800B838");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.13
 * JD-Core Version:    0.7.0.1
 */