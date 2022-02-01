package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;

class DoodleColorAndModeView$ColorListAdapter
  extends RecyclerView.Adapter<DoodleColorAndModeView.ColorVH>
{
  private DoodleColorAndModeView$ColorListAdapter(DoodleColorAndModeView paramDoodleColorAndModeView) {}
  
  public DoodleColorAndModeView.ColorVH a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0)
    {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624063, paramViewGroup, false);
    }
    else if (paramInt == 1)
    {
      paramViewGroup = new DoodleSelectModeView(this.a.getContext(), DoodleColorAndModeView.b(this.a));
      ((DoodleSelectModeView)paramViewGroup).setSelectModeListener(new DoodleColorAndModeView.ColorListAdapter.1(this));
    }
    else
    {
      paramViewGroup = null;
    }
    return new DoodleColorAndModeView.ColorVH(this.a, paramInt, paramViewGroup, null);
  }
  
  public void a(DoodleColorAndModeView.ColorVH paramColorVH, int paramInt)
  {
    if (getItemViewType(paramInt) == 1) {
      return;
    }
    int j = DoodleColorAndModeView.d(this.a);
    int i = 0;
    if (paramInt < j)
    {
      DoodleColorAndModeView.ColorVH.a(paramColorVH).setBackgroundResource(2130837820);
      paramInt = DoodleColorAndModeView.e(this.a) ^ true;
    }
    else
    {
      paramInt = ((Integer)DoodleColorAndModeView.f(this.a).get(paramInt - DoodleColorAndModeView.d(this.a))).intValue();
      DoodleColorAndModeView.ColorVH.b(paramColorVH).mutate();
      DoodleColorAndModeView.ColorVH.b(paramColorVH).setColor(paramInt);
      DoodleColorAndModeView.ColorVH.a(paramColorVH).setBackgroundDrawable(DoodleColorAndModeView.ColorVH.b(paramColorVH));
      if ((DoodleColorAndModeView.e(this.a)) && (paramInt == DoodleColorAndModeView.g(this.a))) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
    ImageView localImageView = DoodleColorAndModeView.ColorVH.c(paramColorVH);
    if (paramInt != 0) {
      paramInt = i;
    } else {
      paramInt = 8;
    }
    localImageView.setVisibility(paramInt);
    paramColorVH = paramColorVH.itemView;
    float f;
    if (DoodleColorAndModeView.h(this.a)) {
      f = 0.4F;
    } else {
      f = 1.0F;
    }
    paramColorVH.setAlpha(f);
  }
  
  public int getItemCount()
  {
    return DoodleColorAndModeView.f(this.a).size() + DoodleColorAndModeView.d(this.a);
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) && (DoodleColorAndModeView.a(this.a))) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView.ColorListAdapter
 * JD-Core Version:    0.7.0.1
 */