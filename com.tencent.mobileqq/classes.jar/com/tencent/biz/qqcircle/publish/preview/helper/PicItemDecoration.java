package com.tencent.biz.qqcircle.publish.preview.helper;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.State;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;

public class PicItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int a;
  
  public PicItemDecoration(int paramInt)
  {
    this.a = ImmersiveUtils.a(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.preview.helper.PicItemDecoration
 * JD-Core Version:    0.7.0.1
 */