package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager.PhoneUnityData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class PhoneUnityBindInfoActivity$9
  implements ActionSheet.OnButtonClickListener
{
  PhoneUnityBindInfoActivity$9(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = paramView.getContext();
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.mCloseThisActivity = true;
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.finish();
        return;
      }
      if (!NetworkUtil.isNetSupport(paramView))
      {
        PhoneUnityBindInfoActivity.access$1700(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, 2131694475);
        return;
      }
      PhoneUnityBindInfoActivity.access$002(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, 2);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity;
      PhoneUnityBindInfoActivity.access$1800(paramView, PhoneUnityBindInfoActivity.access$800(paramView).jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.app, "dc00898", "", "", "0X800B325", "0X800B325", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.mCloseThisActivity = false;
      return;
    }
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity;
      QQToast.a(paramView, paramView.getString(2131692183), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.getTitleBarHeight());
    }
    else
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      PhoneUnityBindInfoActivity.access$1600(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, 2131718766, 0L, true);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity;
      paramView.mUnBindedNum = 2;
      PhoneUnityBindInfoActivity.access$1002(paramView, true);
      if (PhoneUnityBindInfoActivity.access$800(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity).jdField_c_of_type_Boolean)
      {
        QLog.i("PhoneUnityBindInfoActivity", 1, "phone_unity_info, unBindContactsMobile");
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.unBindContactsMobile();
      }
      else
      {
        PhoneUnityBindInfoActivity.access$900(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.resetContactSwitch(false);
      }
      if (PhoneUnityBindInfoActivity.access$800(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity).a)
      {
        QLog.i("PhoneUnityBindInfoActivity", 1, "phone_unity_info, unbindPhoneNumLoginOnPhoneUnity");
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.unbindPhoneNumLoginOnPhoneUnity();
      }
      else
      {
        PhoneUnityBindInfoActivity.access$900(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.resetLoginSwitch(false);
      }
      PhoneUnityBindInfoActivity.access$1200(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.mCloseThisActivity = false;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.app, "dc00898", "", "", "0X800B323", "0X800B323", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity.9
 * JD-Core Version:    0.7.0.1
 */