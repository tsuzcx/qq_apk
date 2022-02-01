package com.tencent.av.wtogether.fragment;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class AVGroupFileSelectFragment$4
  implements Animation.AnimationListener
{
  AVGroupFileSelectFragment$4(AVGroupFileSelectFragment paramAVGroupFileSelectFragment, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AVGroupFileSelectFragment.e(this.b).setAnimation(null);
    AVGroupFileSelectFragment.e(this.b).offsetTopAndBottom(this.a);
    AVGroupFileSelectFragment.e(this.b).requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.fragment.AVGroupFileSelectFragment.4
 * JD-Core Version:    0.7.0.1
 */