package com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;

class XRecyclerView$2
  extends RecyclerView.OnScrollListener
{
  XRecyclerView$2(XRecyclerView paramXRecyclerView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((paramInt == 0) && (XRecyclerView.c(this.a) == 2)) {
      this.a.rebound();
    }
    int j = paramRecyclerView.getChildCount();
    boolean bool = paramRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager;
    int i = 0;
    if (bool)
    {
      paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView.getLayoutManager();
      i = paramRecyclerView.getItemCount();
      paramRecyclerView = paramRecyclerView.findFirstVisibleItemPositions(null);
      int k = XRecyclerView.d(this.a).getProLoaderCount();
      if (i - j <= paramRecyclerView[0] + k) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("XRecyclerView", 2, new Object[] { "totalItemCount=%d, firstVisibleItem=%d, visibleThreshold=%d, isCloseToTheEnd=%b", Integer.valueOf(i), Integer.valueOf(paramRecyclerView[0]), Integer.valueOf(k), Boolean.valueOf(bool) });
      }
      if (bool) {
        XRecyclerView.d(this.a).setLoadMore(true);
      }
    }
    else if ((paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
    {
      paramRecyclerView = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
      if (paramRecyclerView.getItemCount() - j <= paramRecyclerView.findFirstVisibleItemPosition() + XRecyclerView.d(this.a).getProLoaderCount()) {
        i = 1;
      }
      if (i != 0) {
        XRecyclerView.d(this.a).setLoadMore(true);
      }
    }
    XRecyclerView.c(this.a, paramInt);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    paramRecyclerView = this.a;
    XRecyclerView.a(paramRecyclerView, XRecyclerView.a(paramRecyclerView) + paramInt1);
    paramRecyclerView = this.a;
    XRecyclerView.b(paramRecyclerView, XRecyclerView.b(paramRecyclerView) + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView.XRecyclerView.2
 * JD-Core Version:    0.7.0.1
 */