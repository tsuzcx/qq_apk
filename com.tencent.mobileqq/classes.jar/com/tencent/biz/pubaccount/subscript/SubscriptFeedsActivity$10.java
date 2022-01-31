package com.tencent.biz.pubaccount.subscript;

import java.util.Iterator;
import java.util.List;
import sda;

class SubscriptFeedsActivity$10
  implements Runnable
{
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      sda localsda = (sda)localIterator.next();
      if (localsda.b > 0) {
        localsda.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.10
 * JD-Core Version:    0.7.0.1
 */