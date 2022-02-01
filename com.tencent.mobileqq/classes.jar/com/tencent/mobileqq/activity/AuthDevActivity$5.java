package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.app.identity.ISafeApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

class AuthDevActivity$5
  implements ActionSheet.OnButtonClickListener
{
  AuthDevActivity$5(AuthDevActivity paramAuthDevActivity, String paramString, ArrayList paramArrayList, int paramInt, boolean paramBoolean, long paramLong) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity;
        QQToast.a(paramView, paramView.getString(2131692183), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.getTitleBarHeight());
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "OnClick.begin to delAuthDev");
        }
        ReportController.b(AuthDevActivity.access$1600(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity), "CliOper", "", "", "My_eq_lock", "My_eq_lock_delete", 0, 0, "", "", "", "");
        if (AuthDevActivity.access$1300(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).delAuthDev(AuthDevActivity.access$1700(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Long)) {
          AuthDevActivity.access$1400(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity);
        } else if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "OnClick.delAuthDev fail");
        }
      }
    }
    if ((AuthDevActivity.access$1800(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity) != null) && (AuthDevActivity.access$1800(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.isFinishing()))
    {
      AuthDevActivity.access$1800(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).dismiss();
      AuthDevActivity.access$1800(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).cancel();
      AuthDevActivity.access$1802(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity.5
 * JD-Core Version:    0.7.0.1
 */