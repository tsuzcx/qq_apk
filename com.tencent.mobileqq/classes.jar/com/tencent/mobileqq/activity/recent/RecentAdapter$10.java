package com.tencent.mobileqq.activity.recent;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.DeleteRecordDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class RecentAdapter$10
  implements ActionSheet.OnButtonClickListener
{
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      RecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData, this.jdField_a_of_type_JavaLangString, this.b);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A361", "0X800A361", 0, 0, "1", "", this.b, "");
    }
    else if (paramInt == 1)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin(), this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserType(), new RecentAdapter.10.1(this), 1);
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserType() == 3000)
        {
          paramView = new DeleteRecordDialog(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
          paramView.a(new RecentAdapter.10.2(this));
          paramView.a(1);
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserType() == 1)
        {
          paramView = new DeleteRecordDialog(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
          paramView.a(new RecentAdapter.10.3(this));
          paramView.a(1);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A362", "0X800A362", 0, 0, "1", "", this.b, "");
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentAdapter.10
 * JD-Core Version:    0.7.0.1
 */