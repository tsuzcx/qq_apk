package com.tencent.mobileqq.activity;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class SimpleUIChoiceView$SpacesItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int b;
  
  public SimpleUIChoiceView$SpacesItemDecoration(SimpleUIChoiceView paramSimpleUIChoiceView, int paramInt)
  {
    this.b = paramInt;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = this.b;
    paramRect.right = i;
    paramRect.bottom = i;
    paramRect.left = i;
    if (paramRecyclerView.getChildPosition(paramView) != 0) {
      paramRect.right = this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SimpleUIChoiceView.SpacesItemDecoration
 * JD-Core Version:    0.7.0.1
 */