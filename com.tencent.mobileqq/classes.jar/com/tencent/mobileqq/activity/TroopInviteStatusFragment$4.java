package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils.TroopPrivilegeCallback;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;

class TroopInviteStatusFragment$4
  implements TroopNotificationUtils.TroopPrivilegeCallback
{
  TroopInviteStatusFragment$4(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  public void a(String paramString, structmsg.StructMsg paramStructMsg, int paramInt)
  {
    long l = paramInt;
    int i;
    if ((TroopInfo.hasPayPrivilege(l, 128)) && (TroopInfo.hasPayPrivilege(l, 512))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (QLog.isColorLevel())
      {
        paramStructMsg = new StringBuilder();
        paramStructMsg.append("onTroopPrivilege payTroop, rspTroopUin: ");
        paramStructMsg.append(paramString);
        paramStructMsg.append(", privilegeFlag = ");
        paramStructMsg.append(paramInt);
        QLog.d("TroopInviteStatusFragment", 2, paramStructMsg.toString());
      }
      TroopNotificationUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString, "");
      TroopNotificationUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramStructMsg = new StringBuilder();
        paramStructMsg.append("onTroopPrivilege normalTroop, rspTroopUin: ");
        paramStructMsg.append(paramString);
        paramStructMsg.append(", privilegeFlag = ");
        paramStructMsg.append(paramInt);
        paramStructMsg.append(", sendSystemMsgAction-----");
        QLog.d("TroopInviteStatusFragment", 2, paramStructMsg.toString());
      }
      TroopInviteStatusFragment.a(this.a, 2);
    }
  }
  
  public void a(String paramString1, structmsg.StructMsg paramStructMsg, int paramInt1, int paramInt2, String paramString2)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (QLog.isColorLevel())
    {
      paramStructMsg = new StringBuilder();
      paramStructMsg.append("NotificationView onTroopPrivilege network! error rspTroopUin = ");
      paramStructMsg.append(paramString1);
      QLog.e("TroopInviteStatusFragment", 2, paramStructMsg.toString());
    }
    paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if (paramInt1 == 72) {
      paramInt1 = 2131689981;
    } else {
      paramInt1 = 2131689980;
    }
    QQToast.a(paramString1, paramInt1, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInviteStatusFragment.4
 * JD-Core Version:    0.7.0.1
 */