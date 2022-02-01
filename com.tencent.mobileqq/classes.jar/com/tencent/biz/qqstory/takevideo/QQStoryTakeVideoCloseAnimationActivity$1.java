package com.tencent.biz.qqstory.takevideo;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class QQStoryTakeVideoCloseAnimationActivity$1
  implements Animator.AnimatorListener
{
  QQStoryTakeVideoCloseAnimationActivity$1(QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.finish();
    this.a.overridePendingTransition(0, 2130772045);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.finish();
    this.a.overridePendingTransition(0, 2130772045);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity.1
 * JD-Core Version:    0.7.0.1
 */