package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import Wallet.AcsSubNoticeRsp;
import aeiz;
import aejf;
import aejg;
import aejx;
import aizx;
import ambl;
import android.os.Bundle;
import azmj;
import bdee;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.FakeUrl;

public class QQNotifySettingBaseFragment$2$1
  implements Runnable
{
  public QQNotifySettingBaseFragment$2$1(aejf paramaejf, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject = (AcsSubNoticeRsp)this.jdField_a_of_type_AndroidOsBundle.getSerializable("rsp");
    if (localObject == null)
    {
      this.jdField_a_of_type_Aejf.a.b(3, "system error");
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
      this.jdField_a_of_type_Aejf.a.b(i, str);
      return;
      localObject = ((AcsSubNoticeRsp)localObject).msg;
      QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder subscribe succ acsMsg: " + localObject);
      if ((localObject != null) && (aeiz.a(((AcsMsg)localObject).notice_time * 1000L))) {
        QQNotifySettingBaseFragment.a(this.jdField_a_of_type_Aejf.a).a((AcsMsg)localObject);
      }
      boolean bool = bdee.d(this.jdField_a_of_type_Aejf.a.getActivity());
      QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder isNerSupport: " + bool);
      if (bool)
      {
        if (QQNotifySettingBaseFragment.a(this.jdField_a_of_type_Aejf.a) == null) {
          break label383;
        }
        localObject = (ambl)QQNotifySettingBaseFragment.a(this.jdField_a_of_type_Aejf.a).getManager(85);
        if (localObject != null)
        {
          bool = ((ambl)localObject).b(true);
          QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder prepare open notify switch isOpened: " + bool);
          if (!bool)
          {
            QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder setQQReminderSwitch");
            ((ambl)localObject).a(true, true);
          }
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(QQNotifySettingBaseFragment.a(), 2, "do report: QQnotice.set.add");
        }
        azmj.b(null, "P_CliOper", "QQnotice", "", "", "QQnotice.set.add", 0, 0, "", "", QQNotifySettingBaseFragment.a(this.jdField_a_of_type_Aejf.a), QQNotifySettingBaseFragment.b(this.jdField_a_of_type_Aejf.a));
        break;
        label383:
        bool = aizx.a();
        QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder prepare open notify switch isOpened: " + bool);
        if (!bool)
        {
          QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder setQQReminderSwitch");
          aizx.a(true);
        }
      }
      if (QQNotifySettingBaseFragment.a(this.jdField_a_of_type_Aejf.a) != null) {
        QQNotifySettingBaseFragment.a(this.jdField_a_of_type_Aejf.a).onFakePros("", ((AcsSubNoticeRsp)localObject).err_str, new aejg(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment.2.1
 * JD-Core Version:    0.7.0.1
 */