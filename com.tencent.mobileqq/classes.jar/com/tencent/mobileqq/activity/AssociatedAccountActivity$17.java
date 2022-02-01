package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AssociatedAccountActivity$17
  implements ActionSheet.OnButtonClickListener
{
  AssociatedAccountActivity$17(AssociatedAccountActivity paramAssociatedAccountActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    this.a.cancel();
    paramView = this.b;
    paramView.handleCleanAllMessage(paramView.app, this.b.getString(2131887796));
    ReportController.b(this.b.app, "dc00898", "", "", "0X800AC3E", "0X800AC3E", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.17
 * JD-Core Version:    0.7.0.1
 */