package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJInvokeHandler;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class ReadInJoyProteusFamilyListViewGroup$1
  implements AbsListView.OnScrollListener
{
  ReadInJoyProteusFamilyListViewGroup$1(ReadInJoyProteusFamilyListViewGroup paramReadInJoyProteusFamilyListViewGroup) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.a.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.a.a.a(paramAbsListView, paramInt);
    if ((RIJQQAppInterfaceUtil.a()) && (paramInt != 0)) {
      DropFrameMonitor.a().a("proteus_family_feeds");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyProteusFamilyListViewGroup.1
 * JD-Core Version:    0.7.0.1
 */