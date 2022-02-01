package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("share click:");
      if (ArkFullScreenAppActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity) == null) {
        paramView = "none";
      } else {
        paramView = ArkFullScreenAppActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity).a;
      }
      localStringBuilder.append(paramView);
      QLog.d("ArkFullScreenAppActivity", 2, localStringBuilder.toString());
    }
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(ArkFullScreenAppActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity).a, new ArkFullScreenAppActivity.8.1(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ArkFullScreenAppActivity.8
 * JD-Core Version:    0.7.0.1
 */