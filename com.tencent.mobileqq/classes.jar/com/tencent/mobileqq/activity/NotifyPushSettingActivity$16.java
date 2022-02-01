package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

class NotifyPushSettingActivity$16
  implements CompoundButton.OnCheckedChangeListener
{
  NotifyPushSettingActivity$16(NotifyPushSettingActivity paramNotifyPushSettingActivity, CardHandler paramCardHandler) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.d) {
      NotifyPushSettingActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity).setContentDescription("PC离线时自动启动QQ手机版");
    }
    QQAppInterface localQQAppInterface;
    int i;
    if (!NotifyPushSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity))
    {
      if (paramBoolean) {
        ReportController.b(null, "CliOper", "", "", "0X8004972", "0X8004972", 0, 1, "", "", "", "");
      }
    }
    else
    {
      if ((!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity.getApplicationContext())) || (!NotifyPushSettingActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity))) {
        break label193;
      }
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity.app;
      if (!paramBoolean) {
        break label181;
      }
      i = 1;
      label94:
      if (!paramBoolean) {
        break label186;
      }
    }
    label181:
    label186:
    for (Object localObject = "1";; localObject = "0")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "PC_active", 0, i, (String)localObject, "", "", "");
      if (!NotifyPushSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity)) {
        this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b(paramBoolean);
      }
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      ReportController.b(null, "CliOper", "", "", "0X8004972", "0X8004972", 0, 0, "", "", "", "");
      break;
      i = 0;
      break label94;
    }
    label193:
    NotifyPushSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity, false);
    localObject = NotifyPushSettingActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity);
    if (!NotifyPushSettingActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity).a()) {}
    for (boolean bool = true;; bool = false)
    {
      ((FormSwitchItem)localObject).setChecked(bool);
      NotifyPushSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity, true);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity, this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity.app.getApplication().getString(2131694730), 0).b(5);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity.16
 * JD-Core Version:    0.7.0.1
 */