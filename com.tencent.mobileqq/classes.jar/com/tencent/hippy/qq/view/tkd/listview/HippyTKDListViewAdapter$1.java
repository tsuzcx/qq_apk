package com.tencent.hippy.qq.view.tkd.listview;

import com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener;

class HippyTKDListViewAdapter$1
  implements RecyclerView.OnListScrollListener
{
  HippyTKDListViewAdapter$1(HippyTKDListViewAdapter paramHippyTKDListViewAdapter) {}
  
  public void onDragEnd() {}
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    if (l - HippyTKDListViewAdapter.access$000(this.this$0) >= this.this$0.mScrollForReportThrottle)
    {
      HippyTKDListViewAdapter.access$002(this.this$0, l);
      this.this$0.checkScrollForReport();
    }
    this.this$0.checkOnScrollEvent();
  }
  
  public void onScrollEnd()
  {
    this.this$0.checkScrollForReport();
    this.this$0.checkOnScrollEvent();
  }
  
  public void onStartDrag() {}
  
  public void onStartFling() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.1
 * JD-Core Version:    0.7.0.1
 */