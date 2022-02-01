package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopNotifyAndRecommendView$8$3$1
  implements Runnable
{
  TroopNotifyAndRecommendView$8$3$1(TroopNotifyAndRecommendView.8.3 param3, structmsg.StructMsg paramStructMsg, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
    {
      int i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
      if (((i == 2) || (i == 3)) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8$3.b == 1))
      {
        String str1 = "" + this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get();
        String str2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8$3.a.a.a.getMsgHandler().c(str1, str2);
      }
    }
    if (this.jdField_a_of_type_Long != 0L) {}
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8$3.a.a.a != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8$3.a.a.a.getMessageFacade().a(AppConstants.TROOP_SYSTEM_MSG_UIN, 0, this.jdField_a_of_type_Long, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.toByteArray());
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.i("TroopNotifyAndRecommendView", 2, "onSendSystemMsgActionFin Exception!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.8.3.1
 * JD-Core Version:    0.7.0.1
 */