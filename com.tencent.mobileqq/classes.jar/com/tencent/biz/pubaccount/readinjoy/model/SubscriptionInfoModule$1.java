package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class SubscriptionInfoModule$1
  implements Runnable
{
  SubscriptionInfoModule$1(SubscriptionInfoModule paramSubscriptionInfoModule) {}
  
  public void run()
  {
    ((PublicAccountDataManager)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a();
    TroopBarAssistantManager localTroopBarAssistantManager = TroopBarAssistantManager.a();
    localTroopBarAssistantManager.c((QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (localTroopBarAssistantManager.a((QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
      localTroopBarAssistantManager.a(this.this$0.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, (QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.1
 * JD-Core Version:    0.7.0.1
 */