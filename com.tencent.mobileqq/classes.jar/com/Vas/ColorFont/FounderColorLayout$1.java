package com.Vas.ColorFont;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.etrump.mixlayout.ETFont;
import com.tencent.mobileqq.vas.font.api.IETextView;

class FounderColorLayout$1
  implements ValueAnimator.AnimatorUpdateListener
{
  FounderColorLayout$1(FounderColorLayout paramFounderColorLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i >= this.a.p[0])
    {
      this.a.r.cancel();
      paramValueAnimator = this.a;
      paramValueAnimator.s = 0;
      paramValueAnimator.q.mShouldDisplayAnimation = false;
      this.a.b.setIsFounderAnimating(false);
      this.a.b.invalidate();
      this.a.b.onAnimationEnd(this.a.q.mFontId);
      return;
    }
    if (i > this.a.s)
    {
      paramValueAnimator = this.a;
      paramValueAnimator.s = i;
      paramValueAnimator.b.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.FounderColorLayout.1
 * JD-Core Version:    0.7.0.1
 */