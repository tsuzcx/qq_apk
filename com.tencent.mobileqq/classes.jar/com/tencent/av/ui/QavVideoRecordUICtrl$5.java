package com.tencent.av.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

class QavVideoRecordUICtrl$5
  implements ValueAnimator.AnimatorUpdateListener
{
  QavVideoRecordUICtrl$5(QavVideoRecordUICtrl paramQavVideoRecordUICtrl) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator.getAnimatedFraction();
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    float f;
    if (i <= 220)
    {
      f = i / 220.0F;
      QavVideoRecordUICtrl.a(this.a).setAlpha(f);
    }
    if (i <= 160)
    {
      f = i / 100.0F;
      QavVideoRecordUICtrl.a(this.a).setAlpha(f);
    }
    if (QavVideoRecordUICtrl.a(this.a) != null) {
      QavVideoRecordUICtrl.a(this.a).requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavVideoRecordUICtrl.5
 * JD-Core Version:    0.7.0.1
 */