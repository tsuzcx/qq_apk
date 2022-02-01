package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class ComponentSocialOperation$1
  implements Animation.AnimationListener
{
  ComponentSocialOperation$1(ComponentSocialOperation paramComponentSocialOperation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.post(new ComponentSocialOperation.1.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation.1
 * JD-Core Version:    0.7.0.1
 */