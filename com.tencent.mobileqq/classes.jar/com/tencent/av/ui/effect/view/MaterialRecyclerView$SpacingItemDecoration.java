package com.tencent.av.ui.effect.view;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;

class MaterialRecyclerView$SpacingItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int a;
  private int b;
  
  public MaterialRecyclerView$SpacingItemDecoration(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public void getItemOffsets(@NonNull Rect paramRect, @NonNull View paramView, @NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.State paramState)
  {
    paramRect.top = this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.view.MaterialRecyclerView.SpacingItemDecoration
 * JD-Core Version:    0.7.0.1
 */