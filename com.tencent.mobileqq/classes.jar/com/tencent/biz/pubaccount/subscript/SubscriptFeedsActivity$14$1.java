package com.tencent.biz.pubaccount.subscript;

import com.tencent.widget.SwipListView;
import java.util.List;

class SubscriptFeedsActivity$14$1
  implements Runnable
{
  SubscriptFeedsActivity$14$1(SubscriptFeedsActivity.14 param14, List paramList) {}
  
  public void run()
  {
    int i;
    if (SubscriptFeedsActivity.d(this.b.a) != null) {
      i = SubscriptFeedsActivity.d(this.b.a).size();
    } else {
      i = 0;
    }
    List localList = this.a;
    int j;
    if (localList != null) {
      j = localList.size();
    } else {
      j = 0;
    }
    SubscriptFeedsActivity.a(this.b.a, this.a);
    if ((SubscriptFeedsActivity.e(this.b.a)) && (i != j))
    {
      if (this.b.a.a.j == 2) {
        SubscriptFeedsActivity.g(this.b.a).setSelectionFromBottom(SubscriptFeedsActivity.f(this.b.a).getCount() - 1, 0);
      }
      SubscriptFeedsActivity.b(this.b.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.14.1
 * JD-Core Version:    0.7.0.1
 */