package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingActivity$35
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingActivity$35(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      AssistantSettingActivity.a(this.a, 2131692257, 1);
      this.a.f.setOnCheckedChangeListener(null);
      FormSwitchItem localFormSwitchItem = this.a.f;
      if (!paramCompoundButton.isChecked()) {
        bool = true;
      }
      localFormSwitchItem.setChecked(bool);
      this.a.f.setOnCheckedChangeListener(this);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      ((C2CShortcutBarManager)this.a.app.getManager(QQManagerFactory.C2C_SHORTCUT_BAR_MANAGER)).a(paramBoolean);
      ReportController.b(this.a.app, "dc00898", "", "", "0X800B333", "0X800B333", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.35
 * JD-Core Version:    0.7.0.1
 */