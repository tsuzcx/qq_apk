package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import java.util.Iterator;
import java.util.List;

class InterestLabelInfoModule$3
  implements Runnable
{
  InterestLabelInfoModule$3(InterestLabelInfoModule paramInterestLabelInfoModule, List paramList) {}
  
  public void run()
  {
    InterestLabelInfoModule.a(this.this$0).clear();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      InterestLabelInfo localInterestLabelInfo = (InterestLabelInfo)localIterator.next();
      InterestLabelInfoModule.a(this.this$0).add(localInterestLabelInfo);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(InterestLabelInfoModule.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule.3
 * JD-Core Version:    0.7.0.1
 */