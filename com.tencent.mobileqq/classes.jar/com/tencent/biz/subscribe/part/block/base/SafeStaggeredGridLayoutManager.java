package com.tencent.biz.subscribe.part.block.base;

import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class SafeStaggeredGridLayoutManager
  extends StaggeredGridLayoutManager
{
  public SafeStaggeredGridLayoutManager(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public int getPosition(View paramView)
  {
    try
    {
      int i = super.getPosition(paramView);
      return i;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
    return -1;
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
      paramRecycler.printStackTrace();
      QLog.e("SafeStaggeredGridLayoutManager", 4, paramRecycler, new Object[0]);
    }
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    try
    {
      paramInt = super.scrollVerticallyBy(paramInt, paramRecycler, paramState);
      return paramInt;
    }
    catch (Exception paramRecycler)
    {
      paramRecycler.printStackTrace();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.base.SafeStaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */