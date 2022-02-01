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
    if (this.a.mActionSheet == null)
    {
      QQMapActivity localQQMapActivity = this.a;
      localQQMapActivity.mActionSheet = ((ActionSheet)ActionSheetHelper.a(localQQMapActivity, null));
      this.a.mActionSheet.addButton(2131698104);
      this.a.mActionSheet.addButton(2131692184);
      this.a.mActionSheet.addCancelButton(2131690728);
      this.a.mActionSheet.setOnButtonClickListener(new QQMapActivity.7.1(this));
    }
    if (!this.a.mActionSheet.isShowing()) {
      this.a.mActionSheet.show();
    }
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_menu", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity.7
 * JD-Core Version:    0.7.0.1
 */