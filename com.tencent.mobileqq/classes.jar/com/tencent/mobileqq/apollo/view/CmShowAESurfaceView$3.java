package com.tencent.mobileqq.apollo.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class CmShowAESurfaceView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  int a = 0;
  
  CmShowAESurfaceView$3(CmShowAESurfaceView paramCmShowAESurfaceView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (this.a > i)
    {
      paramValueAnimator = this.b;
      CmShowAESurfaceView.a(paramValueAnimator, CmShowAESurfaceView.b(paramValueAnimator) + CmShowAESurfaceView.c(this.b));
      this.b.requestRender();
    }
    this.a = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.CmShowAESurfaceView.3
 * JD-Core Version:    0.7.0.1
 */