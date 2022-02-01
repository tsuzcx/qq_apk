package com.tencent.mobileqq.activity.specialcare;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushForSpecialCareDialog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQSpecialFriendSettingActivity$1
  implements View.OnClickListener
{
  QQSpecialFriendSettingActivity$1(QQSpecialFriendSettingActivity paramQQSpecialFriendSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (QQAppInterface.isNotificationEnabled() == 0)
    {
      localObject = this.a;
      localObject = new MsgNotifyPushForSpecialCareDialog((Context)localObject, ((QQSpecialFriendSettingActivity)localObject).app, QQSpecialFriendSettingActivity.a(this.a));
      ((MsgNotifyPushForSpecialCareDialog)localObject).setOnDismissListener(new QQSpecialFriendSettingActivity.1.1(this, (MsgNotifyPushForSpecialCareDialog)localObject));
      ((MsgNotifyPushForSpecialCareDialog)localObject).show();
      ReportController.b(null, "dc00898", "", "", "0X8009ACB", "0X8009ACB", 0, 0, "", "", "", "");
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialFriendSettingActivity", 2, "finish all setings");
      }
      if (NetworkUtil.isNetworkAvailable(this.a))
      {
        boolean bool1 = QQSpecialFriendSettingActivity.b(this.a).a();
        boolean bool2 = QQSpecialFriendSettingActivity.c(this.a).a();
        localObject = QQSpecialFriendSettingActivity.e(this.a);
        String str = QQSpecialFriendSettingActivity.a(this.a);
        int i = QQSpecialFriendSettingActivity.d(this.a);
        ((FriendListHandler)localObject).setSpecialCareSwitchesOfAPerson(str, new int[] { 2, 3 }, new boolean[] { bool1, bool2 }, new String[] { String.valueOf(i), null });
        localObject = this.a.a.obtainMessage(8193);
        ((Message)localObject).obj = this.a.getString(2131897331);
        this.a.a.sendMessage((Message)localObject);
        if ((bool1) && (bool2)) {
          localObject = "0";
        } else {
          localObject = "1";
        }
        ReportController.b(null, "CliOper", "", "", "0X80050E2", "0X80050E2", 0, 0, (String)localObject, "", "", "");
      }
      else
      {
        localObject = this.a.a.obtainMessage(8195);
        ((Message)localObject).arg1 = 0;
        ((Message)localObject).arg2 = 2131889169;
        this.a.a.sendMessage((Message)localObject);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity.1
 * JD-Core Version:    0.7.0.1
 */