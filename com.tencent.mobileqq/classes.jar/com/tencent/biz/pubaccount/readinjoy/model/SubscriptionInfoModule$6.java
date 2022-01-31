package com.tencent.biz.pubaccount.readinjoy.model;

import ajlb;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import phd;
import syb;

public class SubscriptionInfoModule$6
  implements Runnable
{
  public SubscriptionInfoModule$6(phd paramphd, String paramString) {}
  
  public void run()
  {
    int i = syb.b((QQAppInterface)this.this$0.a, this.a);
    ajlb.b((QQAppInterface)this.this$0.a, this.a, i);
    ((QQAppInterface)this.this$0.a).a().c(this.a, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.6
 * JD-Core Version:    0.7.0.1
 */