package com.tencent.image_picker.imagepicker.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;

public class a
  extends RecyclerView.ItemDecoration
{
  private int a;
  private int b;
  private boolean c;
  
  public a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramBoolean;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    int j = this.a;
    int k = i % j;
    if (this.c)
    {
      m = this.b;
      paramRect.left = (m - k * m / j);
      paramRect.right = ((k + 1) * m / j);
      if (i < j) {
        paramRect.top = m;
      }
      paramRect.bottom = this.b;
      return;
    }
    int m = this.b;
    paramRect.left = (k * m / j);
    paramRect.right = (m - (k + 1) * m / j);
    if (i >= j) {
      paramRect.top = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image_picker.imagepicker.view.a
 * JD-Core Version:    0.7.0.1
 */