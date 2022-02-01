package com.tencent.biz.richframework.part.block.base;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView.Recycler;
import androidx.recyclerview.widget.RecyclerView.State;
import com.tencent.biz.richframework.delegate.impl.RFApplication;

public class SafeGridLayoutManager
  extends GridLayoutManager
{
  public SafeGridLayoutManager(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (RFApplication.isDebug()) {
      try
      {
        super.onLayoutChildren(paramRecycler, paramState);
        return;
      }
      catch (IndexOutOfBoundsException paramRecycler)
      {
        paramRecycler.printStackTrace();
        return;
      }
    }
    try
    {
      super.onLayoutChildren(paramRecycler, paramState);
      return;
    }
    catch (Exception paramRecycler)
    {
      paramRecycler.printStackTrace();
    }
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (RFApplication.isDebug()) {
      try
      {
        paramInt = super.scrollVerticallyBy(paramInt, paramRecycler, paramState);
        return paramInt;
      }
      catch (IndexOutOfBoundsException paramRecycler)
      {
        paramRecycler.printStackTrace();
        return 0;
      }
    }
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
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */