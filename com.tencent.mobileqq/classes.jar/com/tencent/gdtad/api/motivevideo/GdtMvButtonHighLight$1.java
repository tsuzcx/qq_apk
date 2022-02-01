package com.tencent.gdtad.api.motivevideo;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.Button;

class GdtMvButtonHighLight$1
  implements ValueAnimator.AnimatorUpdateListener
{
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    GdtMvButtonHighLight localGdtMvButtonHighLight = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight;
    float f = this.jdField_a_of_type_Int;
    GdtMvButtonHighLight.a(localGdtMvButtonHighLight, (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * f));
    if (this.jdField_a_of_type_AndroidWidgetButton != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setAlpha(1.0F - Math.abs(((Float)paramValueAnimator.getAnimatedValue()).floatValue()));
    }
    GdtMvButtonHighLight.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight, true);
    if (GdtMvButtonHighLight.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight) <= -this.jdField_a_of_type_Int) {
      GdtMvButtonHighLight.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight, false);
    }
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvButtonHighLight.1
 * JD-Core Version:    0.7.0.1
 */