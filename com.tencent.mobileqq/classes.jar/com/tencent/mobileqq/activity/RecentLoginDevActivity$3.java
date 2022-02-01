package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

class RecentLoginDevActivity$3
  implements ActionSheet.OnButtonClickListener
{
  RecentLoginDevActivity$3(RecentLoginDevActivity paramRecentLoginDevActivity, String paramString, ArrayList paramArrayList, int paramInt) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity;
        QQToast.a(paramView, paramView.getString(2131692183), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity.getTitleBarHeight());
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.RecentLoginDevActivity", 2, "OnClick begin to delHistoryDev");
        }
        if (EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity.app, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int)) {
          RecentLoginDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity);
        } else if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.RecentLoginDevActivity", 2, "showDelDevActionSheet.OnClick delHistoryDev failed");
        }
      }
    }
    if ((RecentLoginDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity) != null) && (RecentLoginDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity).isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity.isFinishing()))
    {
      RecentLoginDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity).dismiss();
      RecentLoginDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity).cancel();
      RecentLoginDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecentLoginDevActivity.3
 * JD-Core Version:    0.7.0.1
 */