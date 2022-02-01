package com.tencent.biz.pubaccount.readinjoy.model;

import aldk;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import pyn;
import tzo;

public class SubscriptionInfoModule$6
  implements Runnable
{
  public SubscriptionInfoModule$6(pyn parampyn, String paramString) {}
  
  public void run()
  {
    int i = tzo.b((QQAppInterface)this.this$0.a, this.a);
    aldk.b((QQAppInterface)this.this$0.a, this.a, i);
    ((QQAppInterface)this.this$0.a).a().c(this.a, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.6
 * JD-Core Version:    0.7.0.1
 */