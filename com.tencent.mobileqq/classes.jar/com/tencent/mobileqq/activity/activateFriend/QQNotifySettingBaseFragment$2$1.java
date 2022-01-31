package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import Wallet.AcsSubNoticeRsp;
import ache;
import achk;
import achl;
import acic;
import agwb;
import ajvm;
import android.os.Bundle;
import awqx;
import badq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.FakeUrl;

public class QQNotifySettingBaseFragment$2$1
  implements Runnable
{
  public QQNotifySettingBaseFragment$2$1(achk paramachk, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject = (AcsSubNoticeRsp)this.jdField_a_of_type_AndroidOsBundle.getSerializable("rsp");
    if (localObject == null)
    {
      this.jdField_a_of_type_Achk.a.b(3, "system error");
      return;
    }
    int i = ((AcsSubNoticeRsp)localObject).ret_code;
    String str = ((AcsSubNoticeRsp)localObject).err_str;
    QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder retCode: " + i + " msg: " + str);
    switch (i)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Achk.a.b(i, str);
      return;
      localObject = ((AcsSubNoticeRsp)localObject).msg;
      QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder subscribe succ acsMsg: " + localObject);
      if ((localObject != null) && (ache.a(((AcsMsg)localObject).notice_time * 1000L))) {
        QQNotifySettingBaseFragment.a(this.jdField_a_of_type_Achk.a).a((AcsMsg)localObject);
      }
      boolean bool = badq.d(this.jdField_a_of_type_Achk.a.getActivity());
      QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder isNerSupport: " + bool);
      if (bool)
      {
        if (QQNotifySettingBaseFragment.a(this.jdField_a_of_type_Achk.a) == null) {
          break label383;
        }
        localObject = (ajvm)QQNotifySettingBaseFragment.a(this.jdField_a_of_type_Achk.a).getManager(85);
        if (localObject != null)
        {
          bool = ((ajvm)localObject).b(true);
          QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder prepare open notify switch isOpened: " + bool);
          if (!bool)
          {
            QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder setQQReminderSwitch");
            ((ajvm)localObject).a(true, true);
          }
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(QQNotifySettingBaseFragment.a(), 2, "do report: QQnotice.set.add");
        }
        awqx.b(null, "P_CliOper", "QQnotice", "", "", "QQnotice.set.add", 0, 0, "", "", QQNotifySettingBaseFragment.a(this.jdField_a_of_type_Achk.a), QQNotifySettingBaseFragment.b(this.jdField_a_of_type_Achk.a));
        break;
        label383:
        bool = agwb.a();
        QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder prepare open notify switch isOpened: " + bool);
        if (!bool)
        {
          QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder setQQReminderSwitch");
          agwb.a(true);
        }
      }
      if (QQNotifySettingBaseFragment.a(this.jdField_a_of_type_Achk.a) != null) {
        QQNotifySettingBaseFragment.a(this.jdField_a_of_type_Achk.a).onFakePros("", ((AcsSubNoticeRsp)localObject).err_str, new achl(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment.2.1
 * JD-Core Version:    0.7.0.1
 */