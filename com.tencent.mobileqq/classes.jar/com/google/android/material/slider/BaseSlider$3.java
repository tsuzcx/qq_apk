package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.tooltip.TooltipDrawable;
import java.util.Iterator;
import java.util.List;

class BaseSlider$3
  extends AnimatorListenerAdapter
{
  BaseSlider$3(BaseSlider paramBaseSlider) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    paramAnimator = BaseSlider.a(this.a).iterator();
    while (paramAnimator.hasNext())
    {
      TooltipDrawable localTooltipDrawable = (TooltipDrawable)paramAnimator.next();
      ViewUtils.b(this.a).b(localTooltipDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.slider.BaseSlider.3
 * JD-Core Version:    0.7.0.1
 */