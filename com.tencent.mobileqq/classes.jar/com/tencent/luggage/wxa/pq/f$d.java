package com.tencent.luggage.wxa.pq;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class f$d
  implements AbsListView.OnScrollListener
{
  private f$d(f paramf) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((f.a(this.a) != null) && (f.e(this.a) != null) && (f.f(this.a) != null) && (f.a(this.a) != null))
    {
      if ((f.a(this.a).getLastVisiblePosition() == f.f(this.a).getCount() - 1) && (f.a(this.a).getChildAt(f.a(this.a).getChildCount() - 1) != null) && (f.a(this.a).getChildAt(f.a(this.a).getChildCount() - 1).getBottom() <= f.a(this.a).getHeight()))
      {
        f.e(this.a).setVisibility(8);
        return;
      }
      f.e(this.a).setVisibility(0);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    if ((paramInt == 1) && (!this.a.h()) && (f.b(this.a).getContentView() != null))
    {
      f.d(this.a).b(f.c(this.a));
      f.c(this.a).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pq.f.d
 * JD-Core Version:    0.7.0.1
 */