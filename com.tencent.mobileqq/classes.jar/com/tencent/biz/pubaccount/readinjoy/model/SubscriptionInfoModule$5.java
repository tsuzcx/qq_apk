package com.tencent.biz.pubaccount.readinjoy.model;

import alik;
import android.content.Context;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import qhx;
import uqx;
import uuc;

public class SubscriptionInfoModule$5
  implements Runnable
{
  public SubscriptionInfoModule$5(qhx paramqhx, String paramString, Context paramContext) {}
  
  public void run()
  {
    uqx.a().a(this.jdField_a_of_type_JavaLangString, (QQAppInterface)this.this$0.a, this.jdField_a_of_type_AndroidContentContext, qhx.a(this.this$0));
    int i = uuc.b((QQAppInterface)this.this$0.a, this.jdField_a_of_type_JavaLangString);
    alik.b((QQAppInterface)this.this$0.a, this.jdField_a_of_type_JavaLangString, i);
    ((QQAppInterface)this.this$0.a).getMessageFacade().setReaded(this.jdField_a_of_type_JavaLangString, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.5
 * JD-Core Version:    0.7.0.1
 */