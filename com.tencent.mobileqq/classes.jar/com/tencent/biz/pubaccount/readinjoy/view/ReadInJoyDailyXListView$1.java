package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.PrefetchListener;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyDailyXListView$1
  implements PrefetchListener
{
  ReadInJoyDailyXListView$1(ReadInJoyDailyXListView paramReadInJoyDailyXListView) {}
  
  public void a()
  {
    if (ReadInJoyDailyXListView.a(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDailyXListView", 2, new Object[] { "preloadOptimize switch ON, mCurrentStatus = ", this.a.c + " mNoMoreData : " + this.a.b });
      }
      if ((this.a.c == 0) && ((!ReadinjoyReportUtils.a(this.a.d)) || (!this.a.b)))
      {
        this.a.a(4);
        QLog.d("ReadInJoyDailyXListView", 2, "preloadOptimize switch ON, loadingMore()");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDailyXListView.1
 * JD-Core Version:    0.7.0.1
 */