package com.tencent.mm.ui.widget;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class MMSwitchBtn$SlideAnimation
  extends Animation
{
  int a = 0;
  float b = 0.0F;
  long c = 0L;
  
  private MMSwitchBtn$SlideAnimation(MMSwitchBtn paramMMSwitchBtn)
  {
    setInterpolator(new AccelerateDecelerateInterpolator());
    setAnimationListener(new MMSwitchBtn.SlideAnimation.1(this, paramMMSwitchBtn));
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (this.a == 0) {
      MMSwitchBtn.c(this.d).left = (this.b - paramFloat * (float)this.c);
    } else {
      MMSwitchBtn.c(this.d).left = (this.b + paramFloat * (float)this.c);
    }
    MMSwitchBtn.d(this.d);
    this.d.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMSwitchBtn.SlideAnimation
 * JD-Core Version:    0.7.0.1
 */