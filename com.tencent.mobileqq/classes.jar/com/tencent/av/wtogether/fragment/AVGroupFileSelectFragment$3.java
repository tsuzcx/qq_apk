package com.tencent.av.wtogether.fragment;

import android.app.Dialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class AVGroupFileSelectFragment$3
  implements Animation.AnimationListener
{
  AVGroupFileSelectFragment$3(AVGroupFileSelectFragment paramAVGroupFileSelectFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AVGroupFileSelectFragment.a(this.a).show();
    AVGroupFileSelectFragment.a(this.a).setAnimation(null);
    AVGroupFileSelectFragment.a(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.fragment.AVGroupFileSelectFragment.3
 * JD-Core Version:    0.7.0.1
 */