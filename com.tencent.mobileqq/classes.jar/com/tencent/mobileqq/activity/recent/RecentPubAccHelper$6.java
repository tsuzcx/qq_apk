package com.tencent.mobileqq.activity.recent;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class RecentPubAccHelper$6
  implements ActionSheet.OnButtonClickListener
{
  RecentPubAccHelper$6(RecentPubAccHelper paramRecentPubAccHelper, QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (RecentPubAccHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentPubAccHelper)) {
      return;
    }
    RecentPubAccHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentPubAccHelper, true);
    if (paramInt == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin(), "0X800991E", "0X800991E", 0, 0, "", "", "", "");
      RecentPubAccHelper.c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentPubAccHelper, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentPubAccHelper.6
 * JD-Core Version:    0.7.0.1
 */