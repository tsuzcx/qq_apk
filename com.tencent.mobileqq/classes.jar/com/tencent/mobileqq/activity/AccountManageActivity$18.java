package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountManageActivity$18
  implements View.OnClickListener
{
  AccountManageActivity$18(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    View localView = (View)paramView.getParent();
    if ((localView != null) && (localView.getTag() != null))
    {
      int i = ((Integer)localView.getTag()).intValue();
      if ((i != 0) || (AccountManageActivity.h(this.a)))
      {
        this.a.a(i);
        ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_acc_edit_delete", 0, 0, "", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.18
 * JD-Core Version:    0.7.0.1
 */