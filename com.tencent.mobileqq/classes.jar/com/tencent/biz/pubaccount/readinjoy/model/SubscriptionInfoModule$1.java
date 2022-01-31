package com.tencent.biz.pubaccount.readinjoy.model;

import ajoy;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import oqs;
import rqn;

public class SubscriptionInfoModule$1
  implements Runnable
{
  public SubscriptionInfoModule$1(oqs paramoqs) {}
  
  public void run()
  {
    ((ajoy)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(56)).a();
    rqn localrqn = rqn.a();
    localrqn.c((QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (localrqn.a((QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
      localrqn.a(this.this$0.jdField_a_of_type_Atmp, (QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.1
 * JD-Core Version:    0.7.0.1
 */