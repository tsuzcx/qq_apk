package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.studymode.AlphabeticFontHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GeneralSettingActivity$13
  implements CompoundButton.OnCheckedChangeListener
{
  GeneralSettingActivity$13(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, new Object[] { "mKidModeChatPINYINSwitch click, isChecked=", Boolean.valueOf(paramBoolean) });
    }
    GeneralSettingActivity.a(this.a).a(paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.13
 * JD-Core Version:    0.7.0.1
 */