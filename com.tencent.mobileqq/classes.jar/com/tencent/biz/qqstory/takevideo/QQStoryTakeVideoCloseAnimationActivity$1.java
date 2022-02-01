package com.tencent.biz.qqstory.takevideo;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class QQStoryTakeVideoCloseAnimationActivity$1
  extends D8SafeAnimatorListener
{
  QQStoryTakeVideoCloseAnimationActivity$1(QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.finish();
    this.a.overridePendingTransition(0, 2130772092);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.finish();
    this.a.overridePendingTransition(0, 2130772092);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity.1
 * JD-Core Version:    0.7.0.1
 */