package com.tencent.mobileqq.ar.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class QRScanEntryView$12
  extends AnimatorListenerAdapter
{
  QRScanEntryView$12(QRScanEntryView paramQRScanEntryView, View paramView, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.jdField_a_of_type_AndroidViewView;
    if (paramAnimator != null)
    {
      paramAnimator.setAlpha(1.0F);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      }
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = this.jdField_a_of_type_AndroidViewView;
    if ((paramAnimator != null) && (this.jdField_a_of_type_Boolean)) {
      paramAnimator.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.12
 * JD-Core Version:    0.7.0.1
 */