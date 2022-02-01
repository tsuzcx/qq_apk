package com.tencent.biz.pubaccount.readinjoy.model;

import akms;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import pwr;
import ugf;

public class SubscriptionInfoModule$6
  implements Runnable
{
  public SubscriptionInfoModule$6(pwr parampwr, String paramString) {}
  
  public void run()
  {
    int i = ugf.b((QQAppInterface)this.this$0.a, this.a);
    akms.b((QQAppInterface)this.this$0.a, this.a, i);
    ((QQAppInterface)this.this$0.a).getMessageFacade().setReaded(this.a, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.6
 * JD-Core Version:    0.7.0.1
 */