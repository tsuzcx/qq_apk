package com.tencent.biz.pubaccount.readinjoy.model;

import alik;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import qhx;
import uuc;

public class SubscriptionInfoModule$6
  implements Runnable
{
  public SubscriptionInfoModule$6(qhx paramqhx, String paramString) {}
  
  public void run()
  {
    int i = uuc.b((QQAppInterface)this.this$0.a, this.a);
    alik.b((QQAppInterface)this.this$0.a, this.a, i);
    ((QQAppInterface)this.this$0.a).getMessageFacade().setReaded(this.a, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.6
 * JD-Core Version:    0.7.0.1
 */