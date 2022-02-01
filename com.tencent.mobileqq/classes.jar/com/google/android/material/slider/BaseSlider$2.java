package com.google.android.material.slider;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.core.view.ViewCompat;
import com.google.android.material.tooltip.TooltipDrawable;
import java.util.Iterator;
import java.util.List;

class BaseSlider$2
  implements ValueAnimator.AnimatorUpdateListener
{
  BaseSlider$2(BaseSlider paramBaseSlider) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = BaseSlider.a(this.a).iterator();
    while (paramValueAnimator.hasNext()) {
      ((TooltipDrawable)paramValueAnimator.next()).a(f);
    }
    ViewCompat.postInvalidateOnAnimation(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.slider.BaseSlider.2
 * JD-Core Version:    0.7.0.1
 */