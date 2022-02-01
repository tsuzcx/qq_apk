package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import com.tencent.mobileqq.theme.DarkModeManager.ActionResult;

class GeneralSettingActivity$16$1
  implements DarkModeManager.ActionResult
{
  GeneralSettingActivity$16$1(GeneralSettingActivity.16 param16, CompoundButton paramCompoundButton, boolean paramBoolean, int paramInt) {}
  
  public void onCancel()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityGeneralSettingActivity$16.a.a(this.jdField_a_of_type_AndroidWidgetCompoundButton, false);
  }
  
  public void onConfirm()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityGeneralSettingActivity$16.a.b();
    GeneralSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGeneralSettingActivity$16.a, this.jdField_a_of_type_AndroidWidgetCompoundButton, true, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.16.1
 * JD-Core Version:    0.7.0.1
 */