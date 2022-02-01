package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class PhoneUnityChangeActivity$1
  implements ActionSheet.OnButtonClickListener
{
  PhoneUnityChangeActivity$1(PhoneUnityChangeActivity paramPhoneUnityChangeActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      paramView = this.a;
      paramView.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(paramView, 230, HardCodeUtil.a(2131708045), HardCodeUtil.a(2131708035), HardCodeUtil.a(2131708023), HardCodeUtil.a(2131708026), new PhoneUnityChangeActivity.1.1(this), new PhoneUnityChangeActivity.1.2(this));
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (!this.a.isFinishing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityChangeActivity.1
 * JD-Core Version:    0.7.0.1
 */