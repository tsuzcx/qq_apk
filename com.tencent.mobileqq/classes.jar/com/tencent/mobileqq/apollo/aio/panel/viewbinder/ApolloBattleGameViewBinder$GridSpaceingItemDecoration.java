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
  private int jdField_a_of_type_Int;
  private int b;
  private int c;
  private int d;
  
  public ApolloBattleGameViewBinder$GridSpaceingItemDecoration(ApolloBattleGameViewBinder paramApolloBattleGameViewBinder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  public void getItemOffsets(@NonNull Rect paramRect, @NonNull View paramView, @NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    if (i < this.jdField_a_of_type_Int) {
      paramRect.top = this.d;
    }
    paramRect.bottom = this.b;
    int j = this.jdField_a_of_type_Int;
    if (i % j == j - 1)
    {
      paramRect.right = 0;
      return;
    }
    paramRect.right = this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloBattleGameViewBinder.GridSpaceingItemDecoration
 * JD-Core Version:    0.7.0.1
 */