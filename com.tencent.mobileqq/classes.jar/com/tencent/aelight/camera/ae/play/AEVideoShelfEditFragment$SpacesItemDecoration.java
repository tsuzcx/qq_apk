package com.tencent.aelight.camera.ae.play;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;

public class AEVideoShelfEditFragment$SpacesItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int space;
  
  public AEVideoShelfEditFragment$SpacesItemDecoration(AEVideoShelfEditFragment paramAEVideoShelfEditFragment, int paramInt)
  {
    this.space = paramInt;
  }
  
  public void getItemOffsets(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
  {
    super.getItemOffsets(paramRect, paramInt, paramRecyclerView);
    if (paramInt == 0) {
      paramRect.left = this.space;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.SpacesItemDecoration
 * JD-Core Version:    0.7.0.1
 */