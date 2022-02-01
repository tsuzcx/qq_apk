package com.tencent.mobileqq.activity.specialcare;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushForSpecialCareDialog;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;

class QQSpecialCareSettingActivity$3
  implements DialogInterface.OnDismissListener
{
  QQSpecialCareSettingActivity$3(QQSpecialCareSettingActivity paramQQSpecialCareSettingActivity, boolean paramBoolean, MsgNotifyPushForSpecialCareDialog paramMsgNotifyPushForSpecialCareDialog) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    Object localObject;
    boolean bool;
    if (NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialCareSettingActivity))
    {
      paramDialogInterface = QQSpecialCareSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialCareSettingActivity);
      localObject = QQSpecialCareSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialCareSettingActivity);
      bool = this.jdField_a_of_type_Boolean;
      paramDialogInterface.setSpecialCareSwitch(1, new String[] { localObject }, new boolean[] { bool });
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialCareSettingActivity.a.obtainMessage(8193);
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialCareSettingActivity.a.sendMessage(paramDialogInterface);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialCareSettingActivity.app.getCurrentAccountUin();
      if (!this.jdField_a_of_type_Boolean) {
        break label208;
      }
    }
    label208:
    for (paramDialogInterface = "SwitchOn";; paramDialogInterface = "SwitchOff")
    {
      VasWebviewUtil.reportCommercialDrainage((String)localObject, "Care", paramDialogInterface, Integer.toString(QQSpecialCareSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialCareSettingActivity)), 1, 0, 0, null, null, null);
      this.jdField_a_of_type_ComTencentMobileqqAppMsgnotifyMsgNotifyPushForSpecialCareDialog.a();
      return;
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialCareSettingActivity.a.obtainMessage(8195);
      paramDialogInterface.arg1 = 0;
      paramDialogInterface.arg2 = 2131692257;
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialCareSettingActivity.a.sendMessage(paramDialogInterface);
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialCareSettingActivity;
      localObject = QQSpecialCareSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialCareSettingActivity);
      if (!QQSpecialCareSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQQSpecialCareSettingActivity).a()) {}
      for (bool = true;; bool = false)
      {
        paramDialogInterface.a((FormSwitchItem)localObject, bool);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity.3
 * JD-Core Version:    0.7.0.1
 */