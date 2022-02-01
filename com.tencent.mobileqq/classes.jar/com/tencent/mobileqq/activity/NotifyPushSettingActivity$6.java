package com.tencent.mobileqq.activity;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.notification.NotifyIdManager;

class NotifyPushSettingActivity$6
  implements CompoundButton.OnCheckedChangeListener
{
  NotifyPushSettingActivity$6(NotifyPushSettingActivity paramNotifyPushSettingActivity, CardHandler paramCardHandler) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity;
    SettingCloneUtil.writeValue((Context)localObject, ((NotifyPushSettingActivity)localObject).a, this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity.getString(2131716892), "qqsetting_special_care_bar", paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.c(paramBoolean);
    NotifyIdManager.a(paramBoolean);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCheckedChanged: invoked. care bar  isChecked: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("IphoneTitleBarActivity", 2, ((StringBuilder)localObject).toString());
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity.6
 * JD-Core Version:    0.7.0.1
 */