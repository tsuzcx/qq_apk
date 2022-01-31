package com.tencent.biz.pubaccount.readinjoy.weaknet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import srq;

public final class ReadInJoyPTSCostHelper$1
  implements Runnable
{
  public void run()
  {
    synchronized ()
    {
      Iterator localIterator = new ArrayList(srq.a()).iterator();
      if (localIterator.hasNext()) {
        srq.a((String)localIterator.next());
      }
    }
    srq.a().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.weaknet.ReadInJoyPTSCostHelper.1
 * JD-Core Version:    0.7.0.1
 */