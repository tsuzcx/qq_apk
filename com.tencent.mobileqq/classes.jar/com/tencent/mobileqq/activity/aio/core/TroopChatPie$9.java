package com.tencent.mobileqq.activity.aio.core;

import GROUP.MessageRemindRsp;
import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;

class TroopChatPie$9
  extends SVIPObserver
{
  TroopChatPie$9(TroopChatPie paramTroopChatPie) {}
  
  public void onGetBigTroopExpiredInfo(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof MessageRemindRsp)))
    {
      paramObject = (MessageRemindRsp)paramObject;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("vip_pretty.");
        ((StringBuilder)localObject1).append(this.a.b);
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("SVIPObserver.onGetBigTroopExpiredInfo, troopUin: ");
        ((StringBuilder)localObject2).append(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        ((StringBuilder)localObject2).append(" iFreezedType=");
        ((StringBuilder)localObject2).append(paramObject.iFreezedType);
        ((StringBuilder)localObject2).append(" iLhGroupExpiredTime=");
        ((StringBuilder)localObject2).append(paramObject.iLhGroupExpiredTime);
        ((StringBuilder)localObject2).append(" iGroupType=");
        ((StringBuilder)localObject2).append(paramObject.iGroupType);
        QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramObject);
      Object localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      Object localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      Context localContext = this.a.jdField_a_of_type_AndroidContentContext;
      TroopChatPie localTroopChatPie = this.a;
      TroopManager.a(paramObject, (QQAppInterface)localObject1, (String)localObject2, localContext, localTroopChatPie, localTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager);
      return;
    }
    paramObject = new StringBuilder();
    paramObject.append("vip_pretty.");
    paramObject.append(this.a.b);
    QLog.e(paramObject.toString(), 2, String.format("SVIPObserver.onGetBigTroopExpiredInfo, troopUin: %s, isSuccess: false", new Object[] { this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.9
 * JD-Core Version:    0.7.0.1
 */