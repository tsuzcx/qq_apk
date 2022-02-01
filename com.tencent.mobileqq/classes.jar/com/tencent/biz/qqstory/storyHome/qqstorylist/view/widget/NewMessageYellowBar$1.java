package com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class NewMessageYellowBar$1
  implements Animation.AnimationListener
{
  NewMessageYellowBar$1(NewMessageYellowBar paramNewMessageYellowBar) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.a.setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.NewMessageYellowBar.1
 * JD-Core Version:    0.7.0.1
 */