package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyRefreshOptimizeUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.PrefetchListener;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyBaseListView$1
  implements PrefetchListener
{
  ReadInJoyBaseListView$1(ReadInJoyBaseListView paramReadInJoyBaseListView) {}
  
  public void a()
  {
    if (ReadInJoyRefreshOptimizeUtil.a(ReadInJoyRefreshOptimizeUtil.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseListView", 2, new Object[] { "preloadOptimize switch ON, mCurrentStatus = ", Integer.valueOf(this.a.c) });
      }
      if ((this.a.c == 0) && ((!ReadinjoyReportUtils.a(this.a.d)) || (!this.a.b)))
      {
        this.a.a(4);
        QLog.d("ReadInJoyBaseListView", 2, "preloadOptimize switch ON, loadingMore()");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseListView", 2, new Object[] { "preloadOptimize switch OFF, mCurrentStatus = ", Integer.valueOf(this.a.c) });
      }
    } while ((ReadinjoyReportUtils.a(this.a.d)) && ((this.a.c != 0) || (this.a.b)));
    this.a.a(4);
    QLog.d("ReadInJoyBaseListView", 2, "preloadOptimize switch OFF, loadingMore()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView.1
 * JD-Core Version:    0.7.0.1
 */