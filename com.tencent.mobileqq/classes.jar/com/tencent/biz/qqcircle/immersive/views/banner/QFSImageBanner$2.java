package com.tencent.biz.qqcircle.immersive.views.banner;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.viewpager2.widget.ViewPager2;

class QFSImageBanner$2
  implements ValueAnimator.AnimatorUpdateListener
{
  QFSImageBanner$2(QFSImageBanner paramQFSImageBanner) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (QFSImageBanner.d(this.a) == null) {
      return;
    }
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    float f = i - QFSImageBanner.e(this.a);
    QFSImageBanner.d(this.a).fakeDragBy(-f);
    QFSImageBanner.c(this.a, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.2
 * JD-Core Version:    0.7.0.1
 */