package com.tencent.biz.qqstory.view.xrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper;

class XRecyclerView$1
  extends RecyclerView.OnScrollListener
{
  XRecyclerView$1(XRecyclerView paramXRecyclerView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    paramInt = paramRecyclerView.getChildCount();
    if ((paramRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager))
    {
      paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView.getLayoutManager();
      int i = paramRecyclerView.getItemCount();
      int[] arrayOfInt = paramRecyclerView.findFirstVisibleItemPositions(null);
      int j = paramRecyclerView.getSpanCount();
      if (i - paramInt <= arrayOfInt[0] + j * 3) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        XRecyclerView.a(this.a).b(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.xrecyclerview.XRecyclerView.1
 * JD-Core Version:    0.7.0.1
 */