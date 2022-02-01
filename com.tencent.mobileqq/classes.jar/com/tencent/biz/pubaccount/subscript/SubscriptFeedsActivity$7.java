package com.tencent.biz.pubaccount.subscript;

import aoan;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import uqx;

class SubscriptFeedsActivity$7
  implements Runnable
{
  SubscriptFeedsActivity$7(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void run()
  {
    ((aoan)this.this$0.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a();
    uqx.a().c(this.this$0.app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.7
 * JD-Core Version:    0.7.0.1
 */