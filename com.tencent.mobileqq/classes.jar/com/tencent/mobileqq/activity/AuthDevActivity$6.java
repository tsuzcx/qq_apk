package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

class AuthDevActivity$6
  implements ActionSheet.OnButtonClickListener
{
  AuthDevActivity$6(AuthDevActivity paramAuthDevActivity, String paramString, ArrayList paramArrayList, int paramInt, boolean paramBoolean, long paramLong) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((AuthDevActivity.access$1300(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity) != null) && (AuthDevActivity.access$1300(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.isFinishing()))
      {
        AuthDevActivity.access$1300(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).dismiss();
        AuthDevActivity.access$1300(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).cancel();
        AuthDevActivity.access$1302(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity, null);
      }
      return;
      if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.getString(2131692257), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.getTitleBarHeight());
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "OnClick.begin to delAuthDev");
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_delete", 0, 0, "", "", "", "");
        if (EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.app, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Long)) {
          AuthDevActivity.access$1100(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity);
        } else if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "OnClick.delAuthDev fail");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity.6
 * JD-Core Version:    0.7.0.1
 */