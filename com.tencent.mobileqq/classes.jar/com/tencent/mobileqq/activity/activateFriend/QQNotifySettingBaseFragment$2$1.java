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
    Object localObject1 = (AcsSubNoticeRsp)this.a.getSerializable("rsp");
    if (localObject1 == null)
    {
      this.b.b.b(3, "system error");
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
      if ((i == 2) && (QQNotifySettingBaseFragment.h(this.b.b) != null)) {
        QQNotifySettingBaseFragment.h(this.b.b).onFakePros("", ((AcsSubNoticeRsp)localObject1).err_str, new QQNotifySettingBaseFragment.2.1.1(this));
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
        QQNotifySettingBaseFragment.c(this.b.b).saveReminderMsg((AcsMsg)localObject1);
      }
      if (this.b.b.f != null)
      {
        this.b.b.f.setClickable(false);
        if (this.b.b.f.isChecked()) {
          ((IQQReminderCalendarService)this.b.a.getRuntimeService(IQQReminderCalendarService.class, "")).setCalendarAlarm(this.b.b.getQBaseActivity(), QQNotifySettingBaseFragment.d(this.b.b));
        }
      }
      boolean bool = NetworkUtil.isNetSupport(this.b.b.getBaseActivity());
      localObject1 = QQNotifySettingBaseFragment.a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("QQReminderServlet.sendSubscribeReminder isNerSupport: ");
      ((StringBuilder)localObject2).append(bool);
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      if (bool) {
        if (QQNotifySettingBaseFragment.e(this.b.b) != null)
        {
          localObject1 = (ActivateFriendsManager)QQNotifySettingBaseFragment.e(this.b.b).getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
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
      ReportController.b(null, "P_CliOper", "QQnotice", "", "", "QQnotice.set.add", 0, 0, "", "", QQNotifySettingBaseFragment.f(this.b.b), QQNotifySettingBaseFragment.g(this.b.b));
      MobileReportManager.getInstance().reportActionOfNotice("qqremind", "1", "2", 102, QQNotifySettingBaseFragment.g(this.b.b), "15", 1);
    }
    this.b.b.b(i, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment.2.1
 * JD-Core Version:    0.7.0.1
 */