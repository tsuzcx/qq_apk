package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class h$2
  implements ValueAnimator.AnimatorUpdateListener
{
  h$2(h paramh) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (h.a(this.a) != null) {
      h.a(this.a).setBackgroundColor(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.h.2
 * JD-Core Version:    0.7.0.1
 */