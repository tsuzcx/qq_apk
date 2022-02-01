package com.Vas.ColorFont;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.hiboom.HiBoomTextView;

class FounderHiBoomLayout$1
  implements ValueAnimator.AnimatorUpdateListener
{
  FounderHiBoomLayout$1(FounderHiBoomLayout paramFounderHiBoomLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i >= this.a.p[0])
    {
      this.a.r.cancel();
      paramValueAnimator = this.a;
      paramValueAnimator.s = 0;
      FounderHiBoomLayout.a(paramValueAnimator).e = FounderHiBoomLayout.a(this.a).i();
      FounderHiBoomLayout.a(this.a).requestLayout();
      FounderHiBoomLayout.a(this.a).invalidate();
      return;
    }
    if (i > this.a.s)
    {
      paramValueAnimator = this.a;
      paramValueAnimator.s = i;
      FounderHiBoomLayout.a(paramValueAnimator).invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.FounderHiBoomLayout.1
 * JD-Core Version:    0.7.0.1
 */