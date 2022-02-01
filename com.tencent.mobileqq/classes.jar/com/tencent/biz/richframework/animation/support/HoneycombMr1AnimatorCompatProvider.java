package com.tencent.biz.richframework.animation.support;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;

public class HoneycombMr1AnimatorCompatProvider
  implements AnimatorProvider
{
  private TimeInterpolator a;
  
  public void a(View paramView)
  {
    if (this.a == null) {
      this.a = new ValueAnimator().getInterpolator();
    }
    paramView.animate().setInterpolator(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.support.HoneycombMr1AnimatorCompatProvider
 * JD-Core Version:    0.7.0.1
 */