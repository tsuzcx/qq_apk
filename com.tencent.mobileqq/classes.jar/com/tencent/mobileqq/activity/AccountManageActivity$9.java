package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class AccountManageActivity$9
  implements View.OnClickListener
{
  AccountManageActivity$9(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    AccountManageActivity.a(this.a).show();
    if (AccountManageActivity.a(this.a))
    {
      ReportController.a(this.a.app, "0X800B7D8");
      ReportController.a(this.a.app, "0X800B7D9");
    }
    AccountManageActivity.a(this.a, false);
    ReportController.a(this.a.app, "0X800B83B");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.9
 * JD-Core Version:    0.7.0.1
 */