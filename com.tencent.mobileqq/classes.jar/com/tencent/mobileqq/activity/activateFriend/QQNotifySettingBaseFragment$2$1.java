package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import Wallet.AcsSubNoticeRsp;
import android.os.Bundle;
import android.widget.CheckBox;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.ipc.IComIPCUtils;
import com.tencent.mobileqq.reminder.api.IQQReminderCalendarService;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.FakeUrl;
import cooperation.qzone.mobilereport.MobileReportManager;

class QQNotifySettingBaseFragment$2$1
  implements Runnable
{
  QQNotifySettingBaseFragment$2$1(QQNotifySettingBaseFragment.2 param2, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject1 = (AcsSubNoticeRsp)this.jdField_a_of_type_AndroidOsBundle.getSerializable("rsp");
    if (localObject1 == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment.b(3, "system error");
      return;
    }
    int i = ((AcsSubNoticeRsp)localObject1).ret_code;
    String str = ((AcsSubNoticeRsp)localObject1).err_str;
    Object localObject2 = QQNotifySettingBaseFragment.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQReminderServlet.sendSubscribeReminder retCode: ");
    localStringBuilder.append(i);
    localStringBuilder.append(" msg: ");
    localStringBuilder.append(str);
    QLog.i((String)localObject2, 1, localStringBuilder.toString());
    if (i != 0)
    {
      if ((i == 2) && (QQNotifySettingBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment) != null)) {
        QQNotifySettingBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment).onFakePros("", ((AcsSubNoticeRsp)localObject1).err_str, new QQNotifySettingBaseFragment.2.1.1(this));
      }
    }
    else
    {
      localObject1 = ((AcsSubNoticeRsp)localObject1).msg;
      localObject2 = QQNotifySettingBaseFragment.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQReminderServlet.sendSubscribeReminder subscribe succ acsMsg: ");
      localStringBuilder.append(localObject1);
      QLog.i((String)localObject2, 1, localStringBuilder.toString());
      if ((localObject1 != null) && (DateUtil.a(((AcsMsg)localObject1).notice_time * 1000L))) {
        QQNotifySettingBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment).saveReminderMsg((AcsMsg)localObject1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment.a != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment.a.setClickable(false);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment.a.isChecked()) {
          ((IQQReminderCalendarService)this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQReminderCalendarService.class, "")).setCalendarAlarm(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment.getQBaseActivity(), QQNotifySettingBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment));
        }
      }
      boolean bool = NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment.getBaseActivity());
      localObject1 = QQNotifySettingBaseFragment.a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("QQReminderServlet.sendSubscribeReminder isNerSupport: ");
      ((StringBuilder)localObject2).append(bool);
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      if (bool) {
        if (QQNotifySettingBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment) != null)
        {
          localObject1 = (ActivateFriendsManager)QQNotifySettingBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment).getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
          if (localObject1 != null)
          {
            bool = ((ActivateFriendsManager)localObject1).b(true);
            localObject2 = QQNotifySettingBaseFragment.a();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("QQReminderServlet.sendSubscribeReminder prepare open notify switch isOpened: ");
            localStringBuilder.append(bool);
            QLog.i((String)localObject2, 1, localStringBuilder.toString());
            if (!bool)
            {
              QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder setQQReminderSwitch");
              ((ActivateFriendsManager)localObject1).a(true, true);
            }
          }
        }
        else
        {
          bool = ((IComIPCUtils)QRoute.api(IComIPCUtils.class)).isQQReminderOpen();
          localObject1 = QQNotifySettingBaseFragment.a();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("QQReminderServlet.sendSubscribeReminder prepare open notify switch isOpened: ");
          ((StringBuilder)localObject2).append(bool);
          QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
          if (!bool)
          {
            QLog.i(QQNotifySettingBaseFragment.a(), 1, "QQReminderServlet.sendSubscribeReminder setQQReminderSwitch");
            ((IComIPCUtils)QRoute.api(IComIPCUtils.class)).setQQReminderSwitch(true);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(QQNotifySettingBaseFragment.a(), 2, "do report: QQnotice.set.add");
      }
      ReportController.b(null, "P_CliOper", "QQnotice", "", "", "QQnotice.set.add", 0, 0, "", "", QQNotifySettingBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment), QQNotifySettingBaseFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment));
      MobileReportManager.getInstance().reportActionOfNotice("qqremind", "1", "2", 102, QQNotifySettingBaseFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment), "15", 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment$2.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment.b(i, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment.2.1
 * JD-Core Version:    0.7.0.1
 */