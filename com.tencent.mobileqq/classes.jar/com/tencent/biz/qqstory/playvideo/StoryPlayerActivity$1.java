package com.tencent.biz.qqstory.playvideo;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationUtils;

class StoryPlayerActivity$1
  implements ViewTreeObserver.OnPreDrawListener
{
  StoryPlayerActivity$1(StoryPlayerActivity paramStoryPlayerActivity, View paramView) {}
  
  public boolean onPreDraw()
  {
    AnimationUtils.b((ViewGroup)this.b.a(), this.b.d, new StoryPlayerActivity.1.1(this));
    this.a.getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerActivity.1
 * JD-Core Version:    0.7.0.1
 */