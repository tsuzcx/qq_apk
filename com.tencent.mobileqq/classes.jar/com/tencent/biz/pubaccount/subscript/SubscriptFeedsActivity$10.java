package com.tencent.biz.pubaccount.subscript;

import java.util.Iterator;
import java.util.List;
import uqv;

class SubscriptFeedsActivity$10
  implements Runnable
{
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      uqv localuqv = (uqv)localIterator.next();
      if (localuqv.b > 0) {
        localuqv.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.10
 * JD-Core Version:    0.7.0.1
 */