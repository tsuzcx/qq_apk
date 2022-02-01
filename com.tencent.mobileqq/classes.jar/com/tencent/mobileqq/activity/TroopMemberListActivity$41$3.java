package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class TroopMemberListActivity$41$3
  implements Runnable
{
  TroopMemberListActivity$41$3(TroopMemberListActivity.41 param41, List paramList) {}
  
  public void run()
  {
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$41.a.app.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = ((TroopManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$41.a.b);
    if (localTroopInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.size())
    {
      if (i == 1)
      {
        Object localObject2 = (oidb_0x899.memberlist)this.jdField_a_of_type_JavaUtilList.get(0);
        if ((localObject2 == null) || (!((oidb_0x899.memberlist)localObject2).uint64_member_uin.has())) {
          break;
        }
        localObject2 = String.valueOf(((oidb_0x899.memberlist)localObject2).uint64_member_uin.get());
        if ((localObject2 != null) && (!"".equals(((String)localObject2).trim()))) {
          localTroopInfo.troopowneruin = ((String)localObject2).trim();
        }
      }
      ((TroopManager)localObject1).b(localTroopInfo);
      localObject1 = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$41.a.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if (localObject1 == null) {
        break;
      }
      try
      {
        ((TroopHandler)localObject1).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$41.a.b), 0L, 2, 0, 0);
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("TroopMemberListActivityget_troop_member", 2, localException.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.41.3
 * JD-Core Version:    0.7.0.1
 */