package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager.PhoneUnityData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class PhoneUnityBindInfoActivity$8
  implements ActionSheet.OnButtonClickListener
{
  PhoneUnityBindInfoActivity$8(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = paramView.getContext();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.getString(2131692257), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.getTitleBarHeight());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.app, "dc00898", "", "", "0X800B323", "0X800B323", 0, 0, "", "", "", "");
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      PhoneUnityBindInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, 2131719050, 0L, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.jdField_a_of_type_Int = 2;
      PhoneUnityBindInfoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, true);
      if (PhoneUnityBindInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity).jdField_c_of_type_Boolean)
      {
        QLog.i("PhoneUnityBindInfoActivity", 1, "phone_unity_info, unBindContactsMobile");
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.g();
        if (!PhoneUnityBindInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity).jdField_a_of_type_Boolean) {
          break label229;
        }
        QLog.i("PhoneUnityBindInfoActivity", 1, "phone_unity_info, unbindPhoneNumLoginOnPhoneUnity");
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.d();
      }
      for (;;)
      {
        PhoneUnityBindInfoActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.jdField_a_of_type_Boolean = false;
        break;
        PhoneUnityBindInfoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.a(false);
        break label165;
        PhoneUnityBindInfoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.b(false);
      }
    case 1: 
      label165:
      label229:
      if (!NetworkUtil.d(paramView))
      {
        PhoneUnityBindInfoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, 2131694510);
        return;
      }
      PhoneUnityBindInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, 2);
      PhoneUnityBindInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, PhoneUnityBindInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity).jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.app, "dc00898", "", "", "0X800B325", "0X800B325", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity.8
 * JD-Core Version:    0.7.0.1
 */