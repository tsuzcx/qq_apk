package com.tencent.mobileqq.ar.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;

class ViewfinderView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ViewfinderView$1(ViewfinderView paramViewfinderView, Rect paramRect) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ViewfinderView.a(this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView.postInvalidate(this.jdField_a_of_type_AndroidGraphicsRect.left - 6, this.jdField_a_of_type_AndroidGraphicsRect.top - 6, this.jdField_a_of_type_AndroidGraphicsRect.right + 6, this.jdField_a_of_type_AndroidGraphicsRect.bottom + 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ViewfinderView.1
 * JD-Core Version:    0.7.0.1
 */