package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;

class IndicatorViewController$1
  extends AnimatorListenerAdapter
{
  IndicatorViewController$1(IndicatorViewController paramIndicatorViewController, int paramInt1, TextView paramTextView1, int paramInt2, TextView paramTextView2) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    IndicatorViewController.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController, this.jdField_a_of_type_Int);
    IndicatorViewController.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController, null);
    paramAnimator = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramAnimator != null)
    {
      paramAnimator.setVisibility(4);
      if ((this.jdField_b_of_type_Int == 1) && (IndicatorViewController.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController) != null)) {
        IndicatorViewController.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldIndicatorViewController).setText(null);
      }
    }
    paramAnimator = this.jdField_b_of_type_AndroidWidgetTextView;
    if (paramAnimator != null)
    {
      paramAnimator.setTranslationY(0.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(1.0F);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = this.jdField_b_of_type_AndroidWidgetTextView;
    if (paramAnimator != null) {
      paramAnimator.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.IndicatorViewController.1
 * JD-Core Version:    0.7.0.1
 */