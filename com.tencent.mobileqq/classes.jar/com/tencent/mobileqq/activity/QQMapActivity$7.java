package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

class QQMapActivity$7
  implements View.OnClickListener
{
  QQMapActivity$7(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a == null)
    {
      this.a.a = ((ActionSheet)ActionSheetHelper.a(this.a, null));
      this.a.a.addButton(2131698097);
      this.a.a.addButton(2131692258);
      this.a.a.addCancelButton(2131690800);
      this.a.a.setOnButtonClickListener(new QQMapActivity.7.1(this));
    }
    if (!this.a.a.isShowing()) {
      this.a.a.show();
    }
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_menu", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity.7
 * JD-Core Version:    0.7.0.1
 */