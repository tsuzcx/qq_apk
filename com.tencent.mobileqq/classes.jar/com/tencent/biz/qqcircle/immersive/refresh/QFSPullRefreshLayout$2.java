package com.tencent.biz.qqcircle.immersive.refresh;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class QFSPullRefreshLayout$2
  extends AnimatorListenerAdapter
{
  QFSPullRefreshLayout$2(QFSPullRefreshLayout paramQFSPullRefreshLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    QFSPullRefreshLayout.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout.2
 * JD-Core Version:    0.7.0.1
 */