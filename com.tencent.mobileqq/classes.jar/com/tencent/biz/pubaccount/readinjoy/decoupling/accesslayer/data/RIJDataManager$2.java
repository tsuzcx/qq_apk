package com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data;

import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.image.RIJPreloadImage;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class RIJDataManager$2
  implements AbsListView.OnScrollListener
{
  RIJDataManager$2(RIJDataManager paramRIJDataManager) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return;
    }
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.a.a().a();
    this.a.a().a().a(paramAbsListView.getFirstVisiblePosition(), paramAbsListView.getLastVisiblePosition(), localReadInJoyBaseAdapter);
    this.a.a().a().b(paramAbsListView.getFirstVisiblePosition(), paramAbsListView.getLastVisiblePosition(), localReadInJoyBaseAdapter);
    this.a.a().a().c(paramAbsListView.getFirstVisiblePosition(), paramAbsListView.getLastVisiblePosition(), localReadInJoyBaseAdapter);
    this.a.a().a().d(paramAbsListView.getFirstVisiblePosition(), paramAbsListView.getLastVisiblePosition(), localReadInJoyBaseAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.2
 * JD-Core Version:    0.7.0.1
 */