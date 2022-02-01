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
    if (i >= this.a.i[0])
    {
      this.a.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      paramValueAnimator = this.a;
      paramValueAnimator.e = 0;
      paramValueAnimator.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation = false;
      this.a.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.setIsFounderAnimating(false);
      this.a.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.invalidate();
      this.a.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.onAnimationEnd(this.a.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId);
      return;
    }
    if (i > this.a.e)
    {
      paramValueAnimator = this.a;
      paramValueAnimator.e = i;
      paramValueAnimator.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.FounderColorLayout.1
 * JD-Core Version:    0.7.0.1
 */