package com.tencent.mobileqq.activity;

import aoep;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;

class TroopInviteStatusFragment$2
  implements Runnable
{
  TroopInviteStatusFragment$2(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  public void run()
  {
    ((aoep)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.this$0.jdField_a_of_type_JavaLangString, this.this$0.c, this.this$0.jdField_a_of_type_Long);
    TroopManager localTroopManager = (TroopManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = localTroopManager.b(this.this$0.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInviteStatusFragment.2
 * JD-Core Version:    0.7.0.1
 */