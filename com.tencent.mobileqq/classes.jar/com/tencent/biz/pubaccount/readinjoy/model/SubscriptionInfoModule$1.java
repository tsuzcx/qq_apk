package com.tencent.biz.pubaccount.readinjoy.model;

import aoan;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import qhx;
import uqx;

public class SubscriptionInfoModule$1
  implements Runnable
{
  public SubscriptionInfoModule$1(qhx paramqhx) {}
  
  public void run()
  {
    ((aoan)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a();
    uqx localuqx = uqx.a();
    localuqx.c((QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (localuqx.a((QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
      localuqx.a(this.this$0.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, (QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.1
 * JD-Core Version:    0.7.0.1
 */