package com.tencent.biz.pubaccount.readinjoy.model;

import aldk;
import android.content.Context;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import pyn;
import twi;
import tzo;

public class SubscriptionInfoModule$5
  implements Runnable
{
  public SubscriptionInfoModule$5(pyn parampyn, String paramString, Context paramContext) {}
  
  public void run()
  {
    twi.a().a(this.jdField_a_of_type_JavaLangString, (QQAppInterface)this.this$0.a, this.jdField_a_of_type_AndroidContentContext, pyn.a(this.this$0));
    int i = tzo.b((QQAppInterface)this.this$0.a, this.jdField_a_of_type_JavaLangString);
    aldk.b((QQAppInterface)this.this$0.a, this.jdField_a_of_type_JavaLangString, i);
    ((QQAppInterface)this.this$0.a).a().c(this.jdField_a_of_type_JavaLangString, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.5
 * JD-Core Version:    0.7.0.1
 */