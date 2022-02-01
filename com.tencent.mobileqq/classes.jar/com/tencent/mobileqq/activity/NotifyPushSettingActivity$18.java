package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

class NotifyPushSettingActivity$18
  implements CompoundButton.OnCheckedChangeListener
{
  NotifyPushSettingActivity$18(NotifyPushSettingActivity paramNotifyPushSettingActivity, CardHandler paramCardHandler) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity.getApplicationContext())) && (NotifyPushSettingActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity)))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.e(paramBoolean);
    }
    else
    {
      NotifyPushSettingActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity, false);
      NotifyPushSettingActivity.i(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity).setChecked(NotifyPushSettingActivity.i(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity).a() ^ true);
      NotifyPushSettingActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity, true);
      NotifyPushSettingActivity localNotifyPushSettingActivity = this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity;
      QQToast.a(localNotifyPushSettingActivity, localNotifyPushSettingActivity.app.getApplication().getString(2131694709), 0).b(5);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity.18
 * JD-Core Version:    0.7.0.1
 */