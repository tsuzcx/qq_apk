package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.qphone.base.util.QLog;
import qvi;

class RecommendFeedsDiandianEntranceManager$3
  implements Runnable
{
  RecommendFeedsDiandianEntranceManager$3(RecommendFeedsDiandianEntranceManager paramRecommendFeedsDiandianEntranceManager, qvi paramqvi) {}
  
  public void run()
  {
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "onAccountChange | refreshEntranceView curEntryInfo " + RecommendFeedsDiandianEntranceManager.a());
    this.a.b(RecommendFeedsDiandianEntranceManager.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager.3
 * JD-Core Version:    0.7.0.1
 */