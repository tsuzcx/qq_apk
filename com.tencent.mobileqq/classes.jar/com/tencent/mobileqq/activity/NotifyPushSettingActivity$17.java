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

class NotifyPushSettingActivity$17
  implements CompoundButton.OnCheckedChangeListener
{
  NotifyPushSettingActivity$17(NotifyPushSettingActivity paramNotifyPushSettingActivity, CardHandler paramCardHandler) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity.getApplicationContext())) && (NotifyPushSettingActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity)))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.d(paramBoolean);
    }
    else
    {
      NotifyPushSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity, false);
      NotifyPushSettingActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity).setChecked(NotifyPushSettingActivity.h(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity).a() ^ true);
      NotifyPushSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity, true);
      NotifyPushSettingActivity localNotifyPushSettingActivity = this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity;
      QQToast.a(localNotifyPushSettingActivity, localNotifyPushSettingActivity.app.getApplication().getString(2131694709), 0).b(5);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity.17
 * JD-Core Version:    0.7.0.1
 */