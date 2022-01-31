package com.tencent.mobileqq.activity;

import axqy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

final class NotifyPushSettingActivity$21
  implements Runnable
{
  NotifyPushSettingActivity$21(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    int j = 1;
    if (QLog.isDevelopLevel()) {
      QLog.i("ReportController", 4, "reportSettingStatusDaily run");
    }
    HashMap localHashMap = new HashMap();
    int i;
    label44:
    label69:
    label75:
    label100:
    label106:
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d() == 1)
    {
      i = 1;
      if (i == 0) {
        break label483;
      }
      i = 1;
      localHashMap.put("Clk_notice_shake", Integer.valueOf(i));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b() != 1) {
        break label488;
      }
      i = 1;
      if (i == 0) {
        break label493;
      }
      i = 1;
      localHashMap.put("Clk_notice_grpshake", Integer.valueOf(i));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() != 1) {
        break label498;
      }
      i = 1;
      if (i == 0) {
        break label503;
      }
      i = 1;
      localHashMap.put("Clk_notice_sound", Integer.valueOf(i));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != 1) {
        break label508;
      }
      i = 1;
      label131:
      if (i == 0) {
        break label513;
      }
      i = 1;
      label137:
      localHashMap.put("Clk_notice_gupsound", Integer.valueOf(i));
      if (!FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
        break label518;
      }
      i = 1;
      label164:
      localHashMap.put("Clk_night_mode", Integer.valueOf(i));
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()) {
        break label523;
      }
      i = 1;
      label188:
      localHashMap.put("Clk_hide_text", Integer.valueOf(i));
      if (!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718862), "qqsetting_notify_blncontrol_key", true)) {
        break label528;
      }
      i = 1;
      label234:
      localHashMap.put("Led_blinking", Integer.valueOf(i));
      if (!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718636), "qqsetting_receivemsg_whenexit_key", true)) {
        break label533;
      }
      i = 1;
      label280:
      localHashMap.put("Logout_msg", Integer.valueOf(i));
      if (!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718858), "qqsetting_notify_myfeedpush_key", true)) {
        break label538;
      }
      i = j;
      label326:
      localHashMap.put("Clk_about_me", Integer.valueOf(i));
      localObject = localHashMap.keySet();
      try
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliStatus", "", "", "Setting_tab", str2, 0, 0, String.valueOf(localHashMap.get(str2)), "", "", "");
        }
        boolean bool;
        str1 = "1";
      }
      catch (Exception localException)
      {
        bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_pcactive_key", false);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!bool) {}
      }
    }
    for (;;)
    {
      axqy.b((QQAppInterface)localObject, "CliStatus", "", "", "0X8004971", "0X8004971", 0, 0, str1, "", "", "");
      return;
      i = 0;
      break;
      label483:
      i = 0;
      break label44;
      label488:
      i = 0;
      break label69;
      label493:
      i = 0;
      break label75;
      label498:
      i = 0;
      break label100;
      label503:
      i = 0;
      break label106;
      label508:
      i = 0;
      break label131;
      label513:
      i = 0;
      break label137;
      label518:
      i = 0;
      break label164;
      label523:
      i = 0;
      break label188;
      label528:
      i = 0;
      break label234;
      label533:
      i = 0;
      break label280;
      label538:
      i = 0;
      break label326;
      String str1 = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity.21
 * JD-Core Version:    0.7.0.1
 */