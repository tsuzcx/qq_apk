package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.settings.message.ReportClickEventHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GeneralSettingActivity$8
  implements CompoundButton.OnCheckedChangeListener
{
  GeneralSettingActivity$8(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ReportClickEventHelper.a(this.a.app, "0X800B873", paramBoolean);
    GeneralSettingActivity localGeneralSettingActivity = this.a;
    SettingCloneUtil.writeValue(localGeneralSettingActivity, null, localGeneralSettingActivity.getString(2131916372), "qqsetting_notify_icon_key", paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.8
 * JD-Core Version:    0.7.0.1
 */