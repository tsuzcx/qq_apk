package com.tencent.aelight.camera.ae.play;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

class AEPlayShowPageView$2
  extends RecyclerView.ItemDecoration
{
  AEPlayShowPageView$2(AEPlayShowPageView paramAEPlayShowPageView, AEPlayShowGridAdapter.SizeInfo paramSizeInfo) {}
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (AEPlayShowPageView.access$000(this.this$0) != 1)
    {
      paramRect.left = this.val$sizeInfo.itemHorizontalPadding;
      paramRect.right = this.val$sizeInfo.itemHorizontalPadding;
      paramRect.top = this.val$sizeInfo.itemVerticalPadding;
      paramRect.bottom = this.val$sizeInfo.itemVerticalPadding;
      return;
    }
    paramRect.bottom = this.val$sizeInfo.itemVerticalPadding;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEPlayShowPageView.2
 * JD-Core Version:    0.7.0.1
 */