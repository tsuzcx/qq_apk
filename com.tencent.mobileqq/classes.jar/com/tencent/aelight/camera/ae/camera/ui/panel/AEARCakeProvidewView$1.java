package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

class AEARCakeProvidewView$1
  extends RecyclerView.ItemDecoration
{
  AEARCakeProvidewView$1(AEARCakeProvidewView paramAEARCakeProvidewView) {}
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (paramRecyclerView.getChildLayoutPosition(paramView) != 0) {
      paramRect.left = 24;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeProvidewView.1
 * JD-Core Version:    0.7.0.1
 */