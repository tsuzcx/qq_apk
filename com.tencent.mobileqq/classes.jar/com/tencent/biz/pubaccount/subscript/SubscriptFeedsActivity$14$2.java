package com.tencent.biz.pubaccount.subscript;

class SubscriptFeedsActivity$14$2
  implements Runnable
{
  SubscriptFeedsActivity$14$2(SubscriptFeedsActivity.14 param14) {}
  
  public void run()
  {
    Object localObject = SubscriptFeedsActivity.a(this.a.a);
    boolean bool = true;
    ((SubscriptFeedsAdapter)localObject).b = true;
    localObject = this.a.a;
    if (SubscriptFeedsActivity.a(this.a.a).g != 1) {
      bool = false;
    }
    SubscriptFeedsActivity.a((SubscriptFeedsActivity)localObject, false, bool, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.14.2
 * JD-Core Version:    0.7.0.1
 */