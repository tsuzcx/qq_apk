package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AssociatedAccountActivity$9
  implements ActionSheet.OnButtonClickListener
{
  AssociatedAccountActivity$9(AssociatedAccountActivity paramAssociatedAccountActivity, boolean paramBoolean, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = paramInt;
    if (!this.jdField_a_of_type_Boolean) {
      i = paramInt + 1;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        AssociatedAccountActivity.access$1400(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.app, "CliOper", "", "", "0X8007145", "0X8007145", 0, 0, "", "", "", "");
        return;
      }
      AssociatedAccountActivity.access$1500(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.app, "CliOper", "", "", "0X8007148", "0X8007148", 0, 0, "", "", "", "");
      return;
    }
    AssociatedAccountActivity.access$1300(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.app, "CliOper", "", "", "0X8007149", "0X8007149", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.9
 * JD-Core Version:    0.7.0.1
 */