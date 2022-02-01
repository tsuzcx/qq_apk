package com.tencent.biz.pubaccount.readinjoy.model;

import amxz;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import pwr;
import uda;

public class SubscriptionInfoModule$1
  implements Runnable
{
  public SubscriptionInfoModule$1(pwr parampwr) {}
  
  public void run()
  {
    ((amxz)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(56)).a();
    uda localuda = uda.a();
    localuda.c((QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (localuda.a((QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
      localuda.a(this.this$0.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, (QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.1
 * JD-Core Version:    0.7.0.1
 */