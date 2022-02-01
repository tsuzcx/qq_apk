package com.tencent.biz.qqstory.playvideo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class StoryPlayerActivity$3
  extends AnimatorListenerAdapter
{
  StoryPlayerActivity$3(StoryPlayerActivity paramStoryPlayerActivity) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    StoryPlayerActivity.a(this.a);
    StoryPlayerActivity.a(this.a, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerActivity.3
 * JD-Core Version:    0.7.0.1
 */