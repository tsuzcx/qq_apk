package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GeneralSettingActivity$8
  implements CompoundButton.OnCheckedChangeListener
{
  GeneralSettingActivity$8(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    DarkModeManager.a(paramBoolean);
    if (paramBoolean) {
      DarkModeManager.a(new GeneralSettingActivity.ThemeCallback(this.a.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView, this.a.jdField_a_of_type_AndroidViewView));
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.8
 * JD-Core Version:    0.7.0.1
 */