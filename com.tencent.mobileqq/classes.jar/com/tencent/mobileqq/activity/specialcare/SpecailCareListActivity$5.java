package com.tencent.mobileqq.activity.specialcare;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.notification.NotifyIdManager;

class SpecailCareListActivity$5
  implements CompoundButton.OnCheckedChangeListener
{
  SpecailCareListActivity$5(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == SpecailCareListActivity.a(this.a).a())
    {
      SettingCloneUtil.writeValue(this.a, SpecailCareListActivity.a(this.a), this.a.getString(2131717233), "qqsetting_special_care_bar", paramBoolean);
      SpecailCareListActivity.a(this.a).c(paramBoolean);
      NotifyIdManager.a(paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.i("SpecailCareListActivity", 2, "onCheckedChanged: invoked. care bar  isChecked: " + paramBoolean);
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.5
 * JD-Core Version:    0.7.0.1
 */