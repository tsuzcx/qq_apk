package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class ApolloBattleGameViewBinder$GridSpaceingItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int b;
  private int c;
  private int d;
  private int e;
  
  public ApolloBattleGameViewBinder$GridSpaceingItemDecoration(ApolloBattleGameViewBinder paramApolloBattleGameViewBinder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
  }
  
  public void getItemOffsets(@NonNull Rect paramRect, @NonNull View paramView, @NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    if (i < this.b) {
      paramRect.top = this.e;
    }
    paramRect.bottom = this.c;
    int j = this.b;
    if (i % j == j - 1)
    {
      paramRect.right = 0;
      return;
    }
    paramRect.right = this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloBattleGameViewBinder.GridSpaceingItemDecoration
 * JD-Core Version:    0.7.0.1
 */