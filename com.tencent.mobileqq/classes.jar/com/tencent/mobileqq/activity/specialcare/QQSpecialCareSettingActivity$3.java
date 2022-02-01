package com.tencent.mobileqq.activity.specialcare;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushForSpecialCareDialog;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;

class QQSpecialCareSettingActivity$3
  implements DialogInterface.OnDismissListener
{
  QQSpecialCareSettingActivity$3(QQSpecialCareSettingActivity paramQQSpecialCareSettingActivity, boolean paramBoolean, MsgNotifyPushForSpecialCareDialog paramMsgNotifyPushForSpecialCareDialog) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (NetworkUtil.isNetworkAvailable(this.c))
    {
      paramDialogInterface = QQSpecialCareSettingActivity.e(this.c);
      str = QQSpecialCareSettingActivity.d(this.c);
      boolean bool = this.a;
      paramDialogInterface.setSpecialCareSwitch(1, new String[] { str }, new boolean[] { bool });
      paramDialogInterface = this.c.a.obtainMessage(8193);
      this.c.a.sendMessage(paramDialogInterface);
    }
    else
    {
      paramDialogInterface = this.c.a.obtainMessage(8195);
      paramDialogInterface.arg1 = 0;
      paramDialogInterface.arg2 = 2131889169;
      this.c.a.sendMessage(paramDialogInterface);
      paramDialogInterface = this.c;
      paramDialogInterface.a(QQSpecialCareSettingActivity.f(paramDialogInterface), true ^ QQSpecialCareSettingActivity.f(this.c).a());
    }
    String str = this.c.app.getCurrentAccountUin();
    if (this.a) {
      paramDialogInterface = "SwitchOn";
    } else {
      paramDialogInterface = "SwitchOff";
    }
    VasWebviewUtil.a(str, "Care", paramDialogInterface, Integer.toString(QQSpecialCareSettingActivity.g(this.c)), 1, 0, 0, null, null, null);
    this.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity.3
 * JD-Core Version:    0.7.0.1
 */