package com.tencent.biz.qqstory.storyHome;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class QQStoryBaseActivity$4
  implements Animation.AnimationListener
{
  QQStoryBaseActivity$4(QQStoryBaseActivity paramQQStoryBaseActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.mMaskImageView != null)
    {
      this.a.mMaskImageView.clearAnimation();
      ((ViewGroup)((ViewGroup)this.a.findViewById(16908290)).getChildAt(0)).removeView(this.a.mMaskImageView);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity.4
 * JD-Core Version:    0.7.0.1
 */