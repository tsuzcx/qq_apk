package com.tencent.mobileqq.activity.specialcare;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushForSpecialCareDialog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

class QQSpecialFriendSettingActivity$1$1
  implements DialogInterface.OnDismissListener
{
  QQSpecialFriendSettingActivity$1$1(QQSpecialFriendSettingActivity.1 param1, MsgNotifyPushForSpecialCareDialog paramMsgNotifyPushForSpecialCareDialog) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "finish all settings when dialog dismiss");
    }
    if (NetworkUtil.isNetworkAvailable(this.b.a))
    {
      boolean bool1 = QQSpecialFriendSettingActivity.b(this.b.a).a();
      boolean bool2 = QQSpecialFriendSettingActivity.c(this.b.a).a();
      paramDialogInterface = QQSpecialFriendSettingActivity.e(this.b.a);
      String str = QQSpecialFriendSettingActivity.a(this.b.a);
      int i = QQSpecialFriendSettingActivity.d(this.b.a);
      paramDialogInterface.setSpecialCareSwitchesOfAPerson(str, new int[] { 2, 3 }, new boolean[] { bool1, bool2 }, new String[] { String.valueOf(i), null });
      paramDialogInterface = this.b.a.a.obtainMessage(8193);
      paramDialogInterface.obj = this.b.a.getString(2131897331);
      this.b.a.a.sendMessage(paramDialogInterface);
      if ((bool1) && (bool2)) {
        paramDialogInterface = "0";
      } else {
        paramDialogInterface = "1";
      }
      ReportController.b(null, "CliOper", "", "", "0X80050E2", "0X80050E2", 0, 0, paramDialogInterface, "", "", "");
    }
    else
    {
      paramDialogInterface = this.b.a.a.obtainMessage(8195);
      paramDialogInterface.arg1 = 0;
      paramDialogInterface.arg2 = 2131889169;
      this.b.a.a.sendMessage(paramDialogInterface);
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity.1.1
 * JD-Core Version:    0.7.0.1
 */