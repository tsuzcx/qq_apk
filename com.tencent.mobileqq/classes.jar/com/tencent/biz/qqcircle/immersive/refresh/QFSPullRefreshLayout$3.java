package com.tencent.biz.qqcircle.immersive.refresh;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class QFSPullRefreshLayout$3
  implements ValueAnimator.AnimatorUpdateListener
{
  QFSPullRefreshLayout$3(QFSPullRefreshLayout paramQFSPullRefreshLayout, View[] paramArrayOfView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.a;
    int j = paramValueAnimator.length;
    int i = 0;
    while (i < j)
    {
      paramValueAnimator[i].setTranslationY(f1);
      i += 1;
    }
    float f2 = -f1 / QFSPullRefreshLayout.c(this.b);
    f1 = f2;
    if (f2 > 1.0F) {
      f1 = 1.0F;
    }
    if ((QFSPullRefreshLayout.d(this.b) != null) && (QFSPullRefreshLayout.e(this.b) == 1)) {
      QFSPullRefreshLayout.d(this.b).a(this.b, f1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout.3
 * JD-Core Version:    0.7.0.1
 */