package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountManageActivity$14
  implements View.OnClickListener
{
  AccountManageActivity$14(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.b != null) && (this.a.b.isShowing())) {
      this.a.b.dismiss();
    }
    ReportController.b(this.a.app, "CliOper", "", "", "0X800433B", "0X800433B", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.14
 * JD-Core Version:    0.7.0.1
 */