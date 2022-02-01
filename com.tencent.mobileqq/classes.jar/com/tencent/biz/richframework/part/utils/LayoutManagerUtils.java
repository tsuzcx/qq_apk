package com.tencent.biz.richframework.part.utils;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class LayoutManagerUtils
{
  public static int a(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView != null) {
      try
      {
        if ((paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
          return ((LinearLayoutManager)paramRecyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
        }
        if ((paramRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager))
        {
          int i = paramRecyclerView.getLayoutManager().getColumnCountForAccessibility(null, null);
          int[] arrayOfInt = new int[i];
          ((StaggeredGridLayoutManager)paramRecyclerView.getLayoutManager()).findLastCompletelyVisibleItemPositions(arrayOfInt);
          i = arrayOfInt[(i - 1)];
          if (arrayOfInt.length == 2) {
            i = Math.max(arrayOfInt[0], arrayOfInt[1]);
          }
          return i;
        }
      }
      catch (Exception paramRecyclerView)
      {
        paramRecyclerView.printStackTrace();
      }
    }
    return -1;
  }
  
  public static int b(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView != null) {
      try
      {
        if ((paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
          return ((LinearLayoutManager)paramRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        }
        if ((paramRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager))
        {
          int i = paramRecyclerView.getLayoutManager().getColumnCountForAccessibility(null, null);
          int[] arrayOfInt = new int[i];
          ((StaggeredGridLayoutManager)paramRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPositions(arrayOfInt);
          i = arrayOfInt[(i - 1)];
          if (arrayOfInt.length == 2) {
            if (arrayOfInt[1] >= arrayOfInt[0]) {
              i = arrayOfInt[0];
            } else {
              i = arrayOfInt[1];
            }
          }
          return i;
        }
      }
      catch (Exception paramRecyclerView)
      {
        paramRecyclerView.printStackTrace();
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.utils.LayoutManagerUtils
 * JD-Core Version:    0.7.0.1
 */