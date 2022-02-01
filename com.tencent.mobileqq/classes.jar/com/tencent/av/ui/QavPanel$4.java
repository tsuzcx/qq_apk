package com.tencent.av.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ClipDrawable;
import com.tencent.av.utils.QavMicroPhoneAnimatorHolder;
import com.tencent.av.utils.QavMuteButtonForeGroundDrawable;

class QavPanel$4
  implements ValueAnimator.AnimatorUpdateListener
{
  QavPanel$4(QavPanel paramQavPanel) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (QavPanel.f(this.a))
    {
      if (this.a.K != null) {
        this.a.K.setLevel(i);
      }
      if (QavPanel.g(this.a))
      {
        QavPanel.h(this.a).a(i);
        QavPanel.c(this.a).b(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel.4
 * JD-Core Version:    0.7.0.1
 */