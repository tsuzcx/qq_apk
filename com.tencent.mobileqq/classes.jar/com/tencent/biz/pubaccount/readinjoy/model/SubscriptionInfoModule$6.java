package com.tencent.biz.pubaccount.readinjoy.model;

import ahpf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import pbu;
import sgj;

public class SubscriptionInfoModule$6
  implements Runnable
{
  public SubscriptionInfoModule$6(pbu parampbu, String paramString) {}
  
  public void run()
  {
    int i = sgj.b((QQAppInterface)this.this$0.a, this.a);
    ahpf.b((QQAppInterface)this.this$0.a, this.a, i);
    ((QQAppInterface)this.this$0.a).a().c(this.a, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.6
 * JD-Core Version:    0.7.0.1
 */