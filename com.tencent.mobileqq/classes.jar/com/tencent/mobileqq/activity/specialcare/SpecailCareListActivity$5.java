package com.tencent.mobileqq.activity.specialcare;

import android.content.Context;
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
      Object localObject = this.a;
      SettingCloneUtil.writeValue((Context)localObject, SpecailCareListActivity.a((SpecailCareListActivity)localObject), this.a.getString(2131716892), "qqsetting_special_care_bar", paramBoolean);
      SpecailCareListActivity.a(this.a).c(paramBoolean);
      NotifyIdManager.a(paramBoolean);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onCheckedChanged: invoked. care bar  isChecked: ");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.i("SpecailCareListActivity", 2, ((StringBuilder)localObject).toString());
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.5
 * JD-Core Version:    0.7.0.1
 */