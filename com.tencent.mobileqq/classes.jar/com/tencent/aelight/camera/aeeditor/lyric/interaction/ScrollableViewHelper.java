package com.tencent.aelight.camera.aeeditor.lyric.interaction;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

public class ScrollableViewHelper
{
  public int a(View paramView, boolean paramBoolean)
  {
    int j = 0;
    if (paramView == null) {
      return 0;
    }
    if ((paramView instanceof ScrollView))
    {
      if (paramBoolean) {
        return paramView.getScrollY();
      }
      paramView = (ScrollView)paramView;
      return paramView.getChildAt(0).getBottom() - (paramView.getHeight() + paramView.getScrollY());
    }
    Object localObject;
    if ((paramView instanceof ListView))
    {
      localObject = (ListView)paramView;
      if (((ListView)localObject).getChildCount() > 0)
      {
        if (((ListView)localObject).getAdapter() == null) {
          return 0;
        }
        if (paramBoolean)
        {
          paramView = ((ListView)localObject).getChildAt(0);
          return ((ListView)localObject).getFirstVisiblePosition() * paramView.getHeight() - paramView.getTop();
        }
        paramView = ((ListView)localObject).getChildAt(((ListView)localObject).getChildCount() - 1);
        return (((ListView)localObject).getAdapter().getCount() - ((ListView)localObject).getLastVisiblePosition() - 1) * paramView.getHeight() + paramView.getBottom() - ((ListView)localObject).getBottom();
      }
    }
    int i = j;
    if ((paramView instanceof RecyclerView))
    {
      paramView = (RecyclerView)paramView;
      i = j;
      if (paramView.getChildCount() > 0)
      {
        localObject = paramView.getLayoutManager();
        if (paramView.getAdapter() == null) {
          return 0;
        }
        if (paramBoolean)
        {
          localView = paramView.getChildAt(0);
          return paramView.getChildLayoutPosition(localView) * ((RecyclerView.LayoutManager)localObject).getDecoratedMeasuredHeight(localView) - ((RecyclerView.LayoutManager)localObject).getDecoratedTop(localView);
        }
        View localView = paramView.getChildAt(paramView.getChildCount() - 1);
        i = (paramView.getAdapter().getItemCount() - 1) * ((RecyclerView.LayoutManager)localObject).getDecoratedMeasuredHeight(localView) + ((RecyclerView.LayoutManager)localObject).getDecoratedBottom(localView) - paramView.getBottom();
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.interaction.ScrollableViewHelper
 * JD-Core Version:    0.7.0.1
 */