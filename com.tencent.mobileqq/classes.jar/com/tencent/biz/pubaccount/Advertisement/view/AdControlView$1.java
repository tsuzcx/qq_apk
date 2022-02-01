package com.tencent.biz.pubaccount.Advertisement.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class AdControlView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  AdControlView$1(AdControlView paramAdControlView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = new StringBuilder();
    paramValueAnimator.append("alpha:");
    paramValueAnimator.append(f);
    QLog.d("Ron", 2, paramValueAnimator.toString());
    AdControlView.a(this.a).setAlpha(f);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.AdControlView.1
 * JD-Core Version:    0.7.0.1
 */