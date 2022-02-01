package com.tencent.biz.qqcircle.publish.preview.itemtouchhelper;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract interface ItemTouchUIUtil
{
  public abstract void a(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean);
  
  public abstract void a(View paramView);
  
  public abstract void b(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean);
  
  public abstract void b(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.preview.itemtouchhelper.ItemTouchUIUtil
 * JD-Core Version:    0.7.0.1
 */