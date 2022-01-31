package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import java.util.Iterator;
import java.util.List;
import osj;
import pav;

public class InterestLabelInfoModule$3
  implements Runnable
{
  public InterestLabelInfoModule$3(pav parampav, List paramList) {}
  
  public void run()
  {
    pav.a(this.this$0).clear();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      InterestLabelInfo localInterestLabelInfo = (InterestLabelInfo)localIterator.next();
      pav.a(this.this$0).add(localInterestLabelInfo);
    }
    osj.a().a(pav.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule.3
 * JD-Core Version:    0.7.0.1
 */