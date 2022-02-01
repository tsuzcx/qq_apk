package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;

class DoodleColorAndModeView$ColorVH
  extends RecyclerView.ViewHolder
{
  private int jdField_a_of_type_Int;
  private GradientDrawable jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ImageView b;
  
  private DoodleColorAndModeView$ColorVH(DoodleColorAndModeView paramDoodleColorAndModeView, int paramInt, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369393));
      this.b = ((ImageView)paramView.findViewById(2131369490));
      this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = ((GradientDrawable)paramView.getContext().getResources().getDrawable(2130837730));
      paramView.setOnClickListener(new DoodleColorAndModeView.ColorVH.1(this, paramDoodleColorAndModeView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView.ColorVH
 * JD-Core Version:    0.7.0.1
 */