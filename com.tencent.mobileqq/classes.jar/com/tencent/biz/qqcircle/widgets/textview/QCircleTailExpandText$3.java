package com.tencent.biz.qqcircle.widgets.textview;

import android.animation.Animator;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.widget.QCircleD8SafeAnimatorListener;

class QCircleTailExpandText$3
  extends QCircleD8SafeAnimatorListener
{
  QCircleTailExpandText$3(QCircleTailExpandText paramQCircleTailExpandText, SpannableStringBuilder paramSpannableStringBuilder) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.b;
    paramAnimator.setHeight(QCircleTailExpandText.c(paramAnimator));
    QCircleTailExpandText.b(this.b, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    QCircleTailExpandText.b(this.b, true);
    this.b.setText(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.textview.QCircleTailExpandText.3
 * JD-Core Version:    0.7.0.1
 */