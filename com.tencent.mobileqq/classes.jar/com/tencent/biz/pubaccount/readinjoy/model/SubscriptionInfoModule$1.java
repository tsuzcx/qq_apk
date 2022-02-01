package com.tencent.biz.pubaccount.readinjoy.model;

import anrs;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import pyn;
import twi;

public class SubscriptionInfoModule$1
  implements Runnable
{
  public SubscriptionInfoModule$1(pyn parampyn) {}
  
  public void run()
  {
    ((anrs)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(56)).a();
    twi localtwi = twi.a();
    localtwi.c((QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (localtwi.a((QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
      localtwi.a(this.this$0.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, (QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.1
 * JD-Core Version:    0.7.0.1
 */