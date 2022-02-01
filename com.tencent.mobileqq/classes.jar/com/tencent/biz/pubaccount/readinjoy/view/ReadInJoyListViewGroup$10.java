package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyListViewGroup$10
  extends ReadInJoyObserver
{
  ReadInJoyListViewGroup$10(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void f(String paramString)
  {
    boolean bool = StudyModeManager.a();
    if (bool) {
      this.a.a.b(true, 3, false);
    }
    QLog.d("ReadInJoyListViewGroup", 1, "onRefreshArticles! isLearnModelNow=" + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.10
 * JD-Core Version:    0.7.0.1
 */