package com.Vas.ColorFont;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.etrump.mixlayout.ETFont;
import com.tencent.mobileqq.vas.font.api.IETextView;

class ExpressionLayout$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ExpressionLayout$1(ExpressionLayout paramExpressionLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i >= this.a.i[0])
    {
      this.a.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      paramValueAnimator = this.a;
      paramValueAnimator.e = 0;
      paramValueAnimator.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation = false;
      ExpressionLayout.a(this.a).invalidate();
      ExpressionLayout.a(this.a).onAnimationEnd(this.a.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId);
      return;
    }
    if (i > this.a.e)
    {
      paramValueAnimator = this.a;
      paramValueAnimator.e = i;
      ExpressionLayout.a(paramValueAnimator).invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.ExpressionLayout.1
 * JD-Core Version:    0.7.0.1
 */