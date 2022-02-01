package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;

class TroopInviteStatusFragment$2
  implements Runnable
{
  TroopInviteStatusFragment$2(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  public void run()
  {
    ((ITroopMngHandler)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER)).a(this.this$0.jdField_a_of_type_JavaLangString, this.this$0.c, this.this$0.jdField_a_of_type_Long);
    TroopManager localTroopManager = (TroopManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager != null)
    {
      TroopInviteStatusFragment localTroopInviteStatusFragment = this.this$0;
      localTroopInviteStatusFragment.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = localTroopManager.b(localTroopInviteStatusFragment.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInviteStatusFragment.2
 * JD-Core Version:    0.7.0.1
 */