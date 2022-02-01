package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

class InterestLabelInfoModule$1
  implements Runnable
{
  InterestLabelInfoModule$1(InterestLabelInfoModule paramInterestLabelInfoModule) {}
  
  public void run()
  {
    List localList = this.this$0.a.query(InterestLabelInfo.class, true, null, null, null, null, null, null);
    this.this$0.a(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule.1
 * JD-Core Version:    0.7.0.1
 */