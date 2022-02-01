package com.tencent.biz.pubaccount.subscript;

import java.io.Serializable;
import java.util.ArrayList;

class SubscriptFeedsActivity$14$3
  implements Runnable
{
  SubscriptFeedsActivity$14$3(SubscriptFeedsActivity.14 param14, Serializable paramSerializable) {}
  
  public void run()
  {
    if ((this.a != null) && (SubscriptFeedsActivity.f(this.b.a) != null))
    {
      SubscriptFeedsActivity.b(this.b.a, (ArrayList)this.a);
      SubscriptFeedsActivity.f(this.b.a).b(SubscriptFeedsActivity.h(this.b.a));
      Object localObject = SubscriptFeedsActivity.f(this.b.a);
      boolean bool = true;
      ((SubscriptFeedsAdapter)localObject).g = true;
      localObject = this.b.a;
      if (SubscriptFeedsActivity.f(this.b.a).f != 1) {
        bool = false;
      }
      SubscriptFeedsActivity.a((SubscriptFeedsActivity)localObject, false, false, bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.14.3
 * JD-Core Version:    0.7.0.1
 */