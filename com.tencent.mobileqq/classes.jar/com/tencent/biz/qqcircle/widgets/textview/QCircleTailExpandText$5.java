package com.tencent.biz.qqcircle.widgets.textview;

import android.animation.Animator;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.widget.QCircleD8SafeAnimatorListener;

class QCircleTailExpandText$5
  extends QCircleD8SafeAnimatorListener
{
  QCircleTailExpandText$5(QCircleTailExpandText paramQCircleTailExpandText, SpannableStringBuilder paramSpannableStringBuilder) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.b.setText(this.a);
    paramAnimator = this.b;
    paramAnimator.setHeight(QCircleTailExpandText.d(paramAnimator));
    QCircleTailExpandText.b(this.b, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    QCircleTailExpandText.b(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.textview.QCircleTailExpandText.5
 * JD-Core Version:    0.7.0.1
 */