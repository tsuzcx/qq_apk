package com.tencent.mm.ui.widget.listview;

import android.view.animation.Interpolator;

class PullDownListView$WorkspaceOvershootInterpolator
  implements Interpolator
{
  private float a = 1.3F;
  
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    float f = this.a;
    f = paramFloat * paramFloat * ((f + 1.0F) * paramFloat + f) + 1.0F;
    paramFloat = f;
    if (f > 1.0F) {
      paramFloat = 1.0F;
    }
    return paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.PullDownListView.WorkspaceOvershootInterpolator
 * JD-Core Version:    0.7.0.1
 */