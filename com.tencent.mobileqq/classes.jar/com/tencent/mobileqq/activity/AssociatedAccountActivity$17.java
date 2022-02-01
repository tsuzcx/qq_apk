package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AssociatedAccountActivity$17
  implements ActionSheet.OnButtonClickListener
{
  AssociatedAccountActivity$17(AssociatedAccountActivity paramAssociatedAccountActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.getString(2131690931));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.app, "dc00898", "", "", "0X800AC3E", "0X800AC3E", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.17
 * JD-Core Version:    0.7.0.1
 */