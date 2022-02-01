package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopNotifyAndRecommendView$17
  implements TroopNotificationUtils.TroopPrivilegeCallback
{
  TroopNotifyAndRecommendView$17(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void a(String paramString, structmsg.StructMsg paramStructMsg, int paramInt)
  {
    int i;
    if ((TroopInfo.hasPayPrivilege(paramInt, 128)) && (TroopInfo.hasPayPrivilege(paramInt, 512)))
    {
      i = 1;
      if (i == 0) {
        break label157;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 2, "onTroopPrivilege payTroop, rspTroopUin: " + paramString + ", privilegeFlag = " + paramInt);
      }
      TroopNotificationUtils.a(this.a.jdField_a_of_type_AndroidContentContext, paramString, "");
      TroopNotificationUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "pay_troop", "", "", "");
    }
    label157:
    do
    {
      return;
      i = 0;
      break;
      paramStructMsg = TroopNotificationUtils.a(paramString);
      if (paramStructMsg == null) {
        break label295;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 2, "onTroopPrivilege normalTroop, rspTroopUin: " + paramString + ", privilegeFlag = " + paramInt + ", sendSystemMsgAction-----");
      }
      TroopNotifyAndRecommendView.a(this.a, 1, (structmsg.StructMsg)paramStructMsg.get());
    } while (paramStructMsg.msg.group_msg_type.get() != 2);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "agree_invite", 0, 0, paramString, "", "0", "0");
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "normal_troop", "", "", "");
    return;
    label295:
    if (QLog.isColorLevel()) {
      QLog.e("TroopNotifyAndRecommendView", 2, "NotificationView onTroopPrivilege cache error--------------");
    }
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "normal_troop_error", "", "", "");
  }
  
  public void a(String paramString1, structmsg.StructMsg paramStructMsg, int paramInt1, int paramInt2, String paramString2)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopNotifyAndRecommendView", 2, "NotificationView onTroopPrivilege network! error rspTroopUin = " + paramString1);
    }
    paramString1 = this.a.jdField_a_of_type_AndroidContentContext;
    if (paramInt1 == 72) {}
    for (paramInt1 = 2131690065;; paramInt1 = 2131690064)
    {
      QQToast.a(paramString1, paramInt1, 1).a();
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "err", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.17
 * JD-Core Version:    0.7.0.1
 */