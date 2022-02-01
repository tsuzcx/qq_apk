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
    if (NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialFriendSettingActivity$1.a))
    {
      boolean bool1 = QQSpecialFriendSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialFriendSettingActivity$1.a).a();
      boolean bool2 = QQSpecialFriendSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialFriendSettingActivity$1.a).a();
      paramDialogInterface = QQSpecialFriendSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialFriendSettingActivity$1.a);
      String str = QQSpecialFriendSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialFriendSettingActivity$1.a);
      int i = QQSpecialFriendSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialFriendSettingActivity$1.a);
      paramDialogInterface.setSpecialCareSwitchesOfAPerson(str, new int[] { 2, 3 }, new boolean[] { bool1, bool2 }, new String[] { String.valueOf(i), null });
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialFriendSettingActivity$1.a.a.obtainMessage(8193);
      paramDialogInterface.obj = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialFriendSettingActivity$1.a.getString(2131699210);
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialFriendSettingActivity$1.a.a.sendMessage(paramDialogInterface);
      if ((bool1) && (bool2))
      {
        paramDialogInterface = "0";
        ReportController.b(null, "CliOper", "", "", "0X80050E2", "0X80050E2", 0, 0, paramDialogInterface, "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMsgnotifyMsgNotifyPushForSpecialCareDialog.a();
      return;
      paramDialogInterface = "1";
      break;
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialFriendSettingActivity$1.a.a.obtainMessage(8195);
      paramDialogInterface.arg1 = 0;
      paramDialogInterface.arg2 = 2131692257;
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialFriendSettingActivity$1.a.a.sendMessage(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity.1.1
 * JD-Core Version:    0.7.0.1
 */