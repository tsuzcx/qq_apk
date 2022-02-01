package com.tencent.ilive.uicomponent.luxurygiftcomponent.anim;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;

public class GiftAnimator
{
  public void run(View paramView, PointF paramPointF1, PointF paramPointF2)
  {
    if (paramView == null) {
      return;
    }
    PointEvaluator localPointEvaluator = new PointEvaluator();
    localPointEvaluator.init(paramPointF1, paramPointF2);
    paramPointF1 = ValueAnimator.ofObject(localPointEvaluator, new Object[] { paramPointF1, paramPointF2 });
    paramPointF1.setDuration(300L);
    paramPointF1.addUpdateListener(new GiftAnimator.1(this, paramView));
    paramPointF1.addListener(new GiftAnimator.2(this, paramView));
    paramPointF1.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.anim.GiftAnimator
 * JD-Core Version:    0.7.0.1
 */