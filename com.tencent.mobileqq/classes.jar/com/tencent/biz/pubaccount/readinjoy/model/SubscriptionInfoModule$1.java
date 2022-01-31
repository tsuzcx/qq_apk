package com.tencent.biz.pubaccount.readinjoy.model;

import akdh;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import pbr;
import sdc;

public class SubscriptionInfoModule$1
  implements Runnable
{
  public SubscriptionInfoModule$1(pbr parampbr) {}
  
  public void run()
  {
    ((akdh)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(56)).a();
    sdc localsdc = sdc.a();
    localsdc.c((QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (localsdc.a((QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
      localsdc.a(this.this$0.jdField_a_of_type_Aukp, (QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.1
 * JD-Core Version:    0.7.0.1
 */