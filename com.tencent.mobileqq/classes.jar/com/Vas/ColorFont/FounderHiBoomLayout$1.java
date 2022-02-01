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
    if (i >= this.a.i[0])
    {
      this.a.a.cancel();
      this.a.e = 0;
      FounderHiBoomLayout.a(this.a).a = FounderHiBoomLayout.a(this.a).d();
      FounderHiBoomLayout.a(this.a).requestLayout();
      FounderHiBoomLayout.a(this.a).invalidate();
    }
    while (i <= this.a.e) {
      return;
    }
    this.a.e = i;
    FounderHiBoomLayout.a(this.a).invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.Vas.ColorFont.FounderHiBoomLayout.1
 * JD-Core Version:    0.7.0.1
 */