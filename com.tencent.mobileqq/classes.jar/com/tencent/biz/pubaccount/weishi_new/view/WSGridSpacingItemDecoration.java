package com.tencent.biz.pubaccount.weishi_new.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class WSGridSpacingItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int a;
  private int b;
  
  public WSGridSpacingItemDecoration(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int j = paramRecyclerView.getChildAdapterPosition(paramView);
    if (j < 0) {
      return;
    }
    int i = this.a;
    j %= i;
    int k = this.b;
    paramRect.left = (j * k / i);
    paramRect.right = (k - (j + 1) * k / i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSGridSpacingItemDecoration
 * JD-Core Version:    0.7.0.1
 */