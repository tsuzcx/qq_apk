package com.tencent.aelight.camera.ae.biz.circle.helper;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;

public class PicItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int a;
  
  public PicItemDecoration(int paramInt)
  {
    this.a = ViewUtils.dpToPx(paramInt);
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    int i = paramRecyclerView.getLayoutManager().getItemCount();
    int j = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
    int k = this.a;
    paramRect.left = k;
    if (j == i - 1) {
      paramRect.right = k;
    }
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.onDraw(paramCanvas, paramRecyclerView, paramState);
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.onDrawOver(paramCanvas, paramRecyclerView, paramState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.helper.PicItemDecoration
 * JD-Core Version:    0.7.0.1
 */