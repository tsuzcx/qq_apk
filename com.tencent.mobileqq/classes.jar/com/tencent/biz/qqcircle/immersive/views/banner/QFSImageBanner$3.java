package com.tencent.biz.qqcircle.immersive.views.banner;

import android.animation.Animator;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.widget.QCircleD8SafeAnimatorListener;

class QFSImageBanner$3
  extends QCircleD8SafeAnimatorListener
{
  QFSImageBanner$3(QFSImageBanner paramQFSImageBanner) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    QFSImageBanner.d(this.a).endFakeDrag();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    QFSImageBanner.d(this.a).beginFakeDrag();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.3
 * JD-Core Version:    0.7.0.1
 */