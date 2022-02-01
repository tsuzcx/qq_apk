package com.tencent.biz.richframework.part.block.base;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView.Recycler;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.qphone.base.util.QLog;

public class SafeStaggeredGridLayoutManager
  extends StaggeredGridLayoutManager
{
  public SafeStaggeredGridLayoutManager(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public SafeStaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
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
        QLog.e("SafeStaggeredGridLayoutManager", 4, paramRecycler, new Object[0]);
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
      QLog.e("SafeStaggeredGridLayoutManager", 4, paramRecycler, new Object[0]);
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
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */