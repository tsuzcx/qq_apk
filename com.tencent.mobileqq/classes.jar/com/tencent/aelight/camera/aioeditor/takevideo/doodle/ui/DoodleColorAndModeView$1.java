package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.tencent.biz.qqstory.utils.UIUtils;

class DoodleColorAndModeView$1
  extends RecyclerView.ItemDecoration
{
  private int b = UIUtils.a(this.a.getContext(), 15.0F);
  private int c = UIUtils.a(this.a.getContext(), 28.5F);
  
  DoodleColorAndModeView$1(DoodleColorAndModeView paramDoodleColorAndModeView) {}
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    if (i > 0) {
      paramRect.left = this.b;
    }
    if ((i == 1) && (DoodleColorAndModeView.a(this.a))) {
      paramRect.left = this.c;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView.1
 * JD-Core Version:    0.7.0.1
 */