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
  private int jdField_a_of_type_Int = UIUtils.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView.getContext(), 15.0F);
  private int b = UIUtils.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView.getContext(), 28.5F);
  
  DoodleColorAndModeView$1(DoodleColorAndModeView paramDoodleColorAndModeView) {}
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    if (i > 0) {
      paramRect.left = this.jdField_a_of_type_Int;
    }
    if ((i == 1) && (DoodleColorAndModeView.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView))) {
      paramRect.left = this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView.1
 * JD-Core Version:    0.7.0.1
 */