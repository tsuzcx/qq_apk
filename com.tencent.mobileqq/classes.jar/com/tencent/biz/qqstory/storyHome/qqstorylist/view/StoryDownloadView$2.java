package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class StoryDownloadView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.p = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryDownloadView.2
 * JD-Core Version:    0.7.0.1
 */