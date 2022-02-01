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
  private int b;
  private GradientDrawable c;
  private ImageView d;
  private ImageView e;
  
  private DoodleColorAndModeView$ColorVH(DoodleColorAndModeView paramDoodleColorAndModeView, int paramInt, View paramView)
  {
    super(paramView);
    this.b = paramInt;
    if (paramInt == 0)
    {
      this.d = ((ImageView)paramView.findViewById(2131436426));
      this.e = ((ImageView)paramView.findViewById(2131436561));
      this.c = ((GradientDrawable)paramView.getContext().getResources().getDrawable(2130837754));
      paramView.setOnClickListener(new DoodleColorAndModeView.ColorVH.1(this, paramDoodleColorAndModeView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView.ColorVH
 * JD-Core Version:    0.7.0.1
 */