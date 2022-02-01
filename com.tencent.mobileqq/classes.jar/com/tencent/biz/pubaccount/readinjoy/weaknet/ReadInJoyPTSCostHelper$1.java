package com.tencent.biz.pubaccount.readinjoy.weaknet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uda;

public final class ReadInJoyPTSCostHelper$1
  implements Runnable
{
  public void run()
  {
    synchronized ()
    {
      Iterator localIterator = new ArrayList(uda.a()).iterator();
      if (localIterator.hasNext()) {
        uda.a((String)localIterator.next());
      }
    }
    uda.a().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.weaknet.ReadInJoyPTSCostHelper.1
 * JD-Core Version:    0.7.0.1
 */