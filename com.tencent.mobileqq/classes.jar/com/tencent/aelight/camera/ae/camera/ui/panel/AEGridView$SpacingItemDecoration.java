package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

class AEGridView$SpacingItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int b;
  private int c;
  
  public AEGridView$SpacingItemDecoration(AEGridView paramAEGridView, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.top = this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEGridView.SpacingItemDecoration
 * JD-Core Version:    0.7.0.1
 */