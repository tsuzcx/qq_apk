package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ArkFullScreenAppActivity$8
  implements ActionSheet.OnButtonClickListener
{
  ArkFullScreenAppActivity$8(ArkFullScreenAppActivity paramArkFullScreenAppActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (ArkFullScreenAppActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity) != null)
    {
      ArkAppDataReport.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity.app, "FullScreenClickOper", ArkFullScreenAppActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity).a, null, ArkAppDataReport.d, 0, 0);
      ArkAppDataReport.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity.app, ArkFullScreenAppActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity).a, "FullScreenShareOper", 0, 0, 0L, 0L, 0L, "", "");
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("share click:");
      if (ArkFullScreenAppActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity) != null) {
        break label147;
      }
    }
    label147:
    for (paramView = "none";; paramView = ArkFullScreenAppActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity).a)
    {
      QLog.d("ArkFullScreenAppActivity", 2, paramView);
      ArkAppCenter.a().post(ArkFullScreenAppActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity).a, new ArkFullScreenAppActivity.8.1(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ArkFullScreenAppActivity.8
 * JD-Core Version:    0.7.0.1
 */