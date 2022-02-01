package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class ChatHistoryTroopMemberFragment$41$1
  implements Runnable
{
  ChatHistoryTroopMemberFragment$41$1(ChatHistoryTroopMemberFragment.41 param41, List paramList) {}
  
  public void run()
  {
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$41.a.b.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = ((TroopManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$41.a.c);
    if (localTroopInfo == null) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilList;
    int i;
    if (localObject2 == null) {
      i = 0;
    } else {
      i = ((List)localObject2).size();
    }
    if (i == 1)
    {
      localObject2 = (oidb_0x899.memberlist)this.jdField_a_of_type_JavaUtilList.get(0);
      if (localObject2 != null)
      {
        if (!((oidb_0x899.memberlist)localObject2).uint64_member_uin.has()) {
          return;
        }
        localObject2 = String.valueOf(((oidb_0x899.memberlist)localObject2).uint64_member_uin.get());
        if ((localObject2 != null) && (!"".equals(((String)localObject2).trim()))) {
          localTroopInfo.troopowneruin = ((String)localObject2).trim();
        }
      }
      else
      {
        return;
      }
    }
    ((TroopManager)localObject1).b(localTroopInfo);
    localObject1 = (ITroopMemberListHandler)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$41.a.b.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
    if (localObject1 != null) {
      try
      {
        ((ITroopMemberListHandler)localObject1).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$41.a.c), 0L, 2, 0, 0);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.history.BaseFragment", 2, localException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.41.1
 * JD-Core Version:    0.7.0.1
 */