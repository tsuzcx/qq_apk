package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class StoryDownloadView$5
  extends AnimatorListenerAdapter
{
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a) {
      new Handler().postDelayed(new StoryDownloadView.5.1(this), 1200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryDownloadView.5
 * JD-Core Version:    0.7.0.1
 */