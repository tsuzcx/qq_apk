package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import Wallet.AcsSubNoticeRsp;
import afmj;
import afms;
import afmt;
import afno;
import albn;
import android.os.Bundle;
import aohe;
import bdla;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.FakeUrl;
import cooperation.qzone.mobilereport.MobileReportManager;

public class QQNotifySettingBaseFragment$2$1
  implements Runnable
{
  public QQNotifySettingBaseFragment$2$1(afms paramafms, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject = (AcsSubNoticeRsp)this.jdField_a_of_type_AndroidOsBundle.getSerializable("rsp");
    if (localObject == null)
    {
      this.jdField_a_of_type_Afms.a.b(3, "system error");
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
      this.jdField_a_of_type_Afms.a.b(i, str);
      return;
      localObject = ((AcsSubNoticeRsp)localObject).msg;
      QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder subscribe succ acsMsg: " + localObject);
      if ((localObject != null) && (afmj.a(((AcsMsg)localObject).notice_time * 1000L))) {
        QQNotifySettingBaseFragment.a(this.jdField_a_of_type_Afms.a).a((AcsMsg)localObject);
      }
      boolean bool = NetworkUtil.isNetSupport(this.jdField_a_of_type_Afms.a.getActivity());
      QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder isNerSupport: " + bool);
      if (bool)
      {
        if (QQNotifySettingBaseFragment.a(this.jdField_a_of_type_Afms.a) == null) {
          break label411;
        }
        localObject = (aohe)QQNotifySettingBaseFragment.a(this.jdField_a_of_type_Afms.a).getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
        if (localObject != null)
        {
          bool = ((aohe)localObject).b(true);
          QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder prepare open notify switch isOpened: " + bool);
          if (!bool)
          {
            QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder setQQReminderSwitch");
            ((aohe)localObject).a(true, true);
          }
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(QQNotifySettingBaseFragment.a(), 2, "do report: QQnotice.set.add");
        }
        bdla.b(null, "P_CliOper", "QQnotice", "", "", "QQnotice.set.add", 0, 0, "", "", QQNotifySettingBaseFragment.a(this.jdField_a_of_type_Afms.a), QQNotifySettingBaseFragment.b(this.jdField_a_of_type_Afms.a));
        MobileReportManager.getInstance().reportActionOfNotice("qqremind", "1", "2", 102, QQNotifySettingBaseFragment.b(this.jdField_a_of_type_Afms.a), "15", 1);
        break;
        label411:
        bool = albn.a();
        QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder prepare open notify switch isOpened: " + bool);
        if (!bool)
        {
          QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder setQQReminderSwitch");
          albn.a(true);
        }
      }
      if (QQNotifySettingBaseFragment.a(this.jdField_a_of_type_Afms.a) != null) {
        QQNotifySettingBaseFragment.a(this.jdField_a_of_type_Afms.a).onFakePros("", ((AcsSubNoticeRsp)localObject).err_str, new afmt(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment.2.1
 * JD-Core Version:    0.7.0.1
 */