package com.tencent.mobileqq.activity.aio.zhitu;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

public class ZhituPanelView$ZhituOnScrollListener
  extends RecyclerView.OnScrollListener
{
  public boolean a = false;
  
  public ZhituPanelView$ZhituOnScrollListener(ZhituPanelView paramZhituPanelView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      GridLayoutManager localGridLayoutManager = (GridLayoutManager)paramRecyclerView.getLayoutManager();
      if ((localGridLayoutManager.findLastCompletelyVisibleItemPosition() + 1 == localGridLayoutManager.getItemCount()) && (this.a)) {
        ((ZhituPanelView.ZhituPanelAdapter)paramRecyclerView.getAdapter()).a();
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    boolean bool;
    if (paramInt2 > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.a = bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView.ZhituOnScrollListener
 * JD-Core Version:    0.7.0.1
 */