package com.tencent.biz.richframework.part.block;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;

public class BlockContainer$MergeItemDecorationDelegate
  extends RecyclerView.ItemDecoration
{
  public BlockContainer$MergeItemDecorationDelegate(BlockContainer paramBlockContainer, BlockMerger paramBlockMerger) {}
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    int i = paramRecyclerView.getChildLayoutPosition(paramView);
    if ((this.a.b != null) && (this.a.b.a(i) != null)) {
      this.a.b.a(i).getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    }
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.onDraw(paramCanvas, paramRecyclerView, paramState);
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((this.a.b != null) && (this.a.b.a(i) != null))
      {
        View localView = paramRecyclerView.getChildAt(i);
        this.a.b.a(i).onDrawItemDecoration(paramCanvas, paramRecyclerView, localView, paramState);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.BlockContainer.MergeItemDecorationDelegate
 * JD-Core Version:    0.7.0.1
 */