package com.tencent.biz.pubaccount.readinjoy.weaknet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class ReadInJoyPTSCostHelper$1
  implements Runnable
{
  public void run()
  {
    synchronized ()
    {
      Iterator localIterator = new ArrayList(ReadInJoyPTSCostHelper.a()).iterator();
      if (localIterator.hasNext()) {
        ReadInJoyPTSCostHelper.a((String)localIterator.next());
      }
    }
    ReadInJoyPTSCostHelper.a().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.weaknet.ReadInJoyPTSCostHelper.1
 * JD-Core Version:    0.7.0.1
 */