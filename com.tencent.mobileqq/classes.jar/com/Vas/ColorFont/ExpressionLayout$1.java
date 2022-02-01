package com.Vas.ColorFont;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.ETTextView.TextAnimationListener;

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
      this.a.e = 0;
      this.a.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation = false;
      ExpressionLayout.a(this.a).invalidate();
      if (ExpressionLayout.a(this.a).mAnimationListener != null) {
        ExpressionLayout.a(this.a).mAnimationListener.a(ExpressionLayout.a(this.a).mMessage, this.a.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId);
      }
    }
    while (i <= this.a.e) {
      return;
    }
    this.a.e = i;
    ExpressionLayout.a(this.a).invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.Vas.ColorFont.ExpressionLayout.1
 * JD-Core Version:    0.7.0.1
 */