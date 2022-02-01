package com.tencent.biz.pubaccount.weishi_new;

import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class WSStaggeredGridLayoutManager
  extends StaggeredGridLayoutManager
{
  public WSStaggeredGridLayoutManager(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    try
    {
      super.onLayoutChildren(paramRecycler, paramState);
      return;
    }
    catch (Exception paramRecycler)
    {
      WSLog.d("WSStaggeredGridLayoutManager", "onLayoutChildren exception: " + paramRecycler.getLocalizedMessage());
    }
  }
  
  public void scrollToPosition(int paramInt)
  {
    try
    {
      super.scrollToPosition(paramInt);
      EventCollector.getInstance().onRecyclerViewScrollToPosition(this);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        WSLog.d("WSStaggeredGridLayoutManager", "scrollToPosition exception: " + localException.getLocalizedMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSStaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */