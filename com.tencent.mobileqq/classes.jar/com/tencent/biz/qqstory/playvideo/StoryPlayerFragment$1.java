package com.tencent.biz.qqstory.playvideo;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationUtils;

class StoryPlayerFragment$1
  implements ViewTreeObserver.OnPreDrawListener
{
  StoryPlayerFragment$1(StoryPlayerFragment paramStoryPlayerFragment, View paramView) {}
  
  public boolean onPreDraw()
  {
    AnimationUtils.b((ViewGroup)this.b.a(), this.b.b, new StoryPlayerFragment.1.1(this));
    this.a.getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerFragment.1
 * JD-Core Version:    0.7.0.1
 */