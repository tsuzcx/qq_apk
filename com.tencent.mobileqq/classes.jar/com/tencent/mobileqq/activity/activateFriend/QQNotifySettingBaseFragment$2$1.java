package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import Wallet.AcsSubNoticeRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.utils.ComIPCUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IFakeUrl;
import cooperation.qzone.mobilereport.MobileReportManager;

class QQNotifySettingBaseFragment$2$1
  implements Runnable
{
  QQNotifySettingBaseFragment$2$1(QQNotifySettingBaseFragment.2 param2, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject = (AcsSubNoticeRsp)this.jdField_a_of_type_AndroidOsBundle.getSerializable("rsp");
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.a.b(3, "system error");
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
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.a.b(i, str);
      return;
      localObject = ((AcsSubNoticeRsp)localObject).msg;
      QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder subscribe succ acsMsg: " + localObject);
      if ((localObject != null) && (DateUtil.a(((AcsMsg)localObject).notice_time * 1000L))) {
        QQNotifySettingBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.a).saveReminderMsg((AcsMsg)localObject);
      }
      boolean bool = NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.a.getActivity());
      QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder isNerSupport: " + bool);
      if (bool)
      {
        if (QQNotifySettingBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.a) == null) {
          break label413;
        }
        localObject = (ActivateFriendsManager)QQNotifySettingBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.a).getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
        if (localObject != null)
        {
          bool = ((ActivateFriendsManager)localObject).b(true);
          QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder prepare open notify switch isOpened: " + bool);
          if (!bool)
          {
            QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder setQQReminderSwitch");
            ((ActivateFriendsManager)localObject).a(true, true);
          }
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(QQNotifySettingBaseFragment.a(), 2, "do report: QQnotice.set.add");
        }
        ReportController.b(null, "P_CliOper", "QQnotice", "", "", "QQnotice.set.add", 0, 0, "", "", QQNotifySettingBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.a), QQNotifySettingBaseFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.a));
        MobileReportManager.getInstance().reportActionOfNotice("qqremind", "1", "2", 102, QQNotifySettingBaseFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.a), "15", 1);
        break;
        label413:
        bool = ComIPCUtils.a();
        QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder prepare open notify switch isOpened: " + bool);
        if (!bool)
        {
          QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder setQQReminderSwitch");
          ComIPCUtils.a(true);
        }
      }
      if (QQNotifySettingBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.a) != null) {
        QQNotifySettingBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.a).onFakePros("", ((AcsSubNoticeRsp)localObject).err_str, new QQNotifySettingBaseFragment.2.1.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment.2.1
 * JD-Core Version:    0.7.0.1
 */