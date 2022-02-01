package com.tencent.biz.pubaccount.weishi_new;

import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

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
      paramState = new StringBuilder();
      paramState.append("onLayoutChildren exception: ");
      paramState.append(paramRecycler.getLocalizedMessage());
      WSLog.d("WSStaggeredGridLayoutManager", paramState.toString());
    }
  }
  
  public void scrollToPosition(int paramInt)
  {
    try
    {
      super.scrollToPosition(paramInt);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scrollToPosition exception: ");
      localStringBuilder.append(localException.getLocalizedMessage());
      WSLog.d("WSStaggeredGridLayoutManager", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSStaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */