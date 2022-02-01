package com.tencent.mobileqq.activity.aio.core;

import GROUP.MessageRemindRsp;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;

class TroopChatPie$11
  extends SVIPObserver
{
  TroopChatPie$11(TroopChatPie paramTroopChatPie) {}
  
  public void onGetBigTroopExpiredInfo(boolean paramBoolean, MessageRemindRsp paramMessageRemindRsp)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("vip_pretty." + this.a.b, 2, "SVIPObserver.onGetBigTroopExpiredInfo, troopUin: " + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a + " iFreezedType=" + paramMessageRemindRsp.iFreezedType + " iLhGroupExpiredTime=" + paramMessageRemindRsp.iLhGroupExpiredTime + " iGroupType=" + paramMessageRemindRsp.iGroupType);
      }
      ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramMessageRemindRsp);
      TroopManager.a(paramMessageRemindRsp, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_AndroidContentContext, this.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager);
      return;
    }
    QLog.e("vip_pretty." + this.a.b, 2, String.format("SVIPObserver.onGetBigTroopExpiredInfo, troopUin: %s, isSuccess: false", new Object[] { this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.11
 * JD-Core Version:    0.7.0.1
 */