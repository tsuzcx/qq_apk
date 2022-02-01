package com.tencent.biz.qqcircle.publish.view;

import android.database.DataSetObserver;

class HorizontalListView$HorizontalAdapterDataObserver
  extends DataSetObserver
{
  HorizontalListView$HorizontalAdapterDataObserver(HorizontalListView paramHorizontalListView) {}
  
  public void onChanged()
  {
    HorizontalListView localHorizontalListView = this.a;
    localHorizontalListView.g = true;
    HorizontalListView.a(localHorizontalListView, false);
    HorizontalListView.a(this.a);
    this.a.invalidate();
    this.a.requestLayout();
  }
  
  public void onInvalidated()
  {
    HorizontalListView.a(this.a, false);
    HorizontalListView.a(this.a);
    this.a.b(true);
    this.a.invalidate();
    this.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.view.HorizontalListView.HorizontalAdapterDataObserver
 * JD-Core Version:    0.7.0.1
 */