package com.tencent.biz.pubaccount.readinjoy.model;

import ahpd;
import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import pbr;
import sdc;
import sgg;

public class SubscriptionInfoModule$5
  implements Runnable
{
  public SubscriptionInfoModule$5(pbr parampbr, String paramString, Context paramContext) {}
  
  public void run()
  {
    sdc.a().a(this.jdField_a_of_type_JavaLangString, (QQAppInterface)this.this$0.a, this.jdField_a_of_type_AndroidContentContext, pbr.a(this.this$0));
    int i = sgg.b((QQAppInterface)this.this$0.a, this.jdField_a_of_type_JavaLangString);
    ahpd.b((QQAppInterface)this.this$0.a, this.jdField_a_of_type_JavaLangString, i);
    ((QQAppInterface)this.this$0.a).a().c(this.jdField_a_of_type_JavaLangString, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.5
 * JD-Core Version:    0.7.0.1
 */