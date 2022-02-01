package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import java.util.Iterator;
import java.util.List;

class TroopChatPie$1
  implements Runnable
{
  TroopChatPie$1(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    TroopManager localTroopManager = (TroopManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject = localTroopManager.b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    long l;
    TroopMemberInfo localTroopMemberInfo;
    if (localObject != null)
    {
      l = NetConnInfoCenter.getServerTime();
      localObject = ((List)localObject).iterator();
      l += 2592000L;
      if (((Iterator)localObject).hasNext())
      {
        localTroopMemberInfo = (TroopMemberInfo)((Iterator)localObject).next();
        if ((localTroopMemberInfo.mUniqueTitleExpire > 0) && (localTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() < 259200L) && (!localTroopManager.b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localTroopMemberInfo.memberuin)))
        {
          ((TroopTipsMsgMgr)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER)).a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.this$0.a(localTroopMemberInfo), NetConnInfoCenter.getServerTime(), localTroopMemberInfo.mUniqueTitleExpire, 0, 1);
          localTroopManager.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localTroopMemberInfo.memberuin, true);
          ReportController.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_manage", "", "grp_aio", "exp_expire", 0, 0, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
        }
      }
    }
    for (;;)
    {
      break;
      if ((localTroopMemberInfo.mUniqueTitleExpire != 0) && (localTroopMemberInfo.mUniqueTitleExpire != -1) && (localTroopMemberInfo.mUniqueTitleExpire < l))
      {
        l = localTroopMemberInfo.mUniqueTitleExpire;
        continue;
        localTroopManager.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, l);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.1
 * JD-Core Version:    0.7.0.1
 */