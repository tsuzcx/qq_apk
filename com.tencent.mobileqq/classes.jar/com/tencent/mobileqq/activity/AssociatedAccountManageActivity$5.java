package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssociatedAccountManageActivity$5
  implements View.OnClickListener
{
  AssociatedAccountManageActivity$5(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    View localView = (View)paramView.getParent();
    if ((localView != null) && (localView.getTag() != null))
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8007146", "0X8007146", 0, 0, "", "", "", "");
      if ((localView.getTag() instanceof SubAccountInfo)) {
        this.a.showUnbindMenuDialog((SubAccountInfo)localView.getTag());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.5
 * JD-Core Version:    0.7.0.1
 */