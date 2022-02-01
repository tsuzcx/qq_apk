package com.tencent.av.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.av.utils.QavMuteButtonForeGroundDrawable;

class QavPanel$6
  implements ValueAnimator.AnimatorUpdateListener
{
  QavPanel$6(QavPanel paramQavPanel, int[] paramArrayOfInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    int j;
    if (i >= 0)
    {
      paramValueAnimator = this.a;
      if (i <= paramValueAnimator[0])
      {
        j = paramValueAnimator[0];
        i = (int)(i * 255 * 1.0F / j);
        QavPanel.c(this.b).setAlpha(i);
        QavPanel.c(this.b).a(true);
        return;
      }
    }
    paramValueAnimator = this.a;
    if ((i > paramValueAnimator[0]) && (i <= paramValueAnimator[1]))
    {
      QavPanel.c(this.b).a(true);
      QavPanel.c(this.b).setAlpha(255);
      return;
    }
    paramValueAnimator = this.a;
    if ((i > paramValueAnimator[1]) && (i <= paramValueAnimator[2]))
    {
      j = paramValueAnimator[2];
      int k = paramValueAnimator[1];
      i = (int)((paramValueAnimator[2] - i) * 255 * 1.0F / (j - k));
      QavPanel.c(this.b).setAlpha(i);
      QavPanel.c(this.b).a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel.6
 * JD-Core Version:    0.7.0.1
 */