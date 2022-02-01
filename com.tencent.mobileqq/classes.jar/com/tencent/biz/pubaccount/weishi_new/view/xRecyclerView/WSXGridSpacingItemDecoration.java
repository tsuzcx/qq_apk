package com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;

public class WSXGridSpacingItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int a;
  private int b;
  
  public WSXGridSpacingItemDecoration(int paramInt1, int paramInt2)
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
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView.WSXGridSpacingItemDecoration
 * JD-Core Version:    0.7.0.1
 */