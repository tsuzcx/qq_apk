package com.tencent.biz.pubaccount.subscript;

import java.util.Iterator;
import java.util.List;
import sdd;

class SubscriptFeedsActivity$10
  implements Runnable
{
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      sdd localsdd = (sdd)localIterator.next();
      if (localsdd.b > 0) {
        localsdd.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.10
 * JD-Core Version:    0.7.0.1
 */