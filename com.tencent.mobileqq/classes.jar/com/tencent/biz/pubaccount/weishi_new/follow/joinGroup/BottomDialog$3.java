package com.tencent.biz.pubaccount.weishi_new.follow.joinGroup;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class BottomDialog$3
  implements Animation.AnimationListener
{
  BottomDialog$3(BottomDialog paramBottomDialog) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    BottomDialog.a(this.a, false);
    BottomDialog.a(this.a).post(new BottomDialog.3.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    BottomDialog.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.BottomDialog.3
 * JD-Core Version:    0.7.0.1
 */