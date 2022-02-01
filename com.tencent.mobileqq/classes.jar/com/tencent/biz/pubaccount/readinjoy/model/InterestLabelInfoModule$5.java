package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class InterestLabelInfoModule$5
  implements Runnable
{
  InterestLabelInfoModule$5(InterestLabelInfoModule paramInterestLabelInfoModule, List paramList) {}
  
  public void run()
  {
    if ((this.a != null) && (!this.a.isEmpty()))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        InterestLabelInfo localInterestLabelInfo = (InterestLabelInfo)localIterator.next();
        InterestLabelInfoModule.a(this.this$0).put(Integer.valueOf(localInterestLabelInfo.mInterestLabelID), localInterestLabelInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule.5
 * JD-Core Version:    0.7.0.1
 */