package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.av.utils.AVUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.message.newmsg.NewMsgNotificationManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotifyPushSettingActivity$10
  implements CompoundButton.OnCheckedChangeListener
{
  NotifyPushSettingActivity$10(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, new Object[] { "avCallOnCheckedChangeListener::onCheckedChanged: invoked. ", " isChecked: ", Boolean.valueOf(paramBoolean) });
    }
    if (!NotifyPushSettingActivity.a(this.a).c())
    {
      NotifyPushSettingActivity.a(this.a).a(this.a);
      NotifyPushSettingActivity.a(this.a).setOnCheckedChangeListener(null);
      FormSwitchItem localFormSwitchItem = NotifyPushSettingActivity.a(this.a);
      if (!NotifyPushSettingActivity.a(this.a).a()) {
        bool = true;
      }
      localFormSwitchItem.setChecked(bool);
      NotifyPushSettingActivity.a(this.a).setOnCheckedChangeListener(this.a.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      AVUtil.a(this.a.app.getCurrentAccountUin(), paramBoolean);
      if (!paramBoolean) {
        ReportController.b(this.a.app, "dc00898", "", "", "0X800A33D", "0X800A33D", 0, 0, "", "", "", "");
      }
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "isChecked[" + paramBoolean + "]");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity.10
 * JD-Core Version:    0.7.0.1
 */