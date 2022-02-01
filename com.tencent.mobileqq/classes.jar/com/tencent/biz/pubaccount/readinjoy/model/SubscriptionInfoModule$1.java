package com.tencent.biz.pubaccount.readinjoy.model;

import aody;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import pqx;
import twk;

public class SubscriptionInfoModule$1
  implements Runnable
{
  public SubscriptionInfoModule$1(pqx parampqx) {}
  
  public void run()
  {
    ((aody)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(56)).a();
    twk localtwk = twk.a();
    localtwk.c((QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (localtwk.a((QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
      localtwk.a(this.this$0.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, (QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.1
 * JD-Core Version:    0.7.0.1
 */