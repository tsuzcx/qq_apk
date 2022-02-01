package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AssociatedAccountActivity$9
  implements ActionSheet.OnButtonClickListener
{
  AssociatedAccountActivity$9(AssociatedAccountActivity paramAssociatedAccountActivity, boolean paramBoolean, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    int i = paramInt;
    if (!this.a) {
      i = paramInt + 1;
    }
    this.b.cancel();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        AssociatedAccountActivity.access$1600(this.c);
        ReportController.b(this.c.app, "CliOper", "", "", "0X8007145", "0X8007145", 0, 0, "", "", "", "");
        return;
      }
      AssociatedAccountActivity.access$1500(this.c);
      ReportController.b(this.c.app, "CliOper", "", "", "0X8007148", "0X8007148", 0, 0, "", "", "", "");
      return;
    }
    QLog.d("AssociatedAccountActivity", 2, "addAssociatedAccount onClick");
    AssociatedAccountActivity.access$1302(this.c, 2);
    AssociatedAccountActivity.access$1400(this.c);
    ReportController.b(this.c.app, "CliOper", "", "", "0X8007149", "0X8007149", 0, 0, "", "", "", "");
    ReportController.b(this.c.app, "dc00898", "", "", "0X800BDE2", "0X800BDE2", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.9
 * JD-Core Version:    0.7.0.1
 */