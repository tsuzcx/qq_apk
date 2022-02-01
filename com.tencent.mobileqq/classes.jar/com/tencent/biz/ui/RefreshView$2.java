package com.tencent.biz.ui;

import android.view.View;
import com.tencent.mobileqq.widget.IPullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

class RefreshView$2
  implements OverScrollViewListener
{
  RefreshView$2(RefreshView paramRefreshView) {}
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.d == 2)
    {
      this.a.c.f();
      return;
    }
    this.a.c.c(0L);
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.d != 2) {
      this.a.c.b(0L);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.d != 2)
    {
      RefreshView.a(this.a, false);
      paramView = this.a;
      paramView.a(RefreshView.a(paramView));
      this.a.c.a(0L);
      paramView = this.a;
      paramView.d = 2;
      RefreshView.b(paramView);
    }
    return false;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.ui.RefreshView.2
 * JD-Core Version:    0.7.0.1
 */