package com.tencent.biz.pubaccount.readinjoy.viola;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class CommonSuspensionGestureLayout$11
  implements Animation.AnimationListener
{
  CommonSuspensionGestureLayout$11(CommonSuspensionGestureLayout paramCommonSuspensionGestureLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    CommonSuspensionGestureLayout.c(this.a).setLayerType(0, null);
    CommonSuspensionGestureLayout.a(this.a).c();
    CommonSuspensionGestureLayout.a(this.a).a();
    CommonSuspensionGestureLayout.b(this.a);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    CommonSuspensionGestureLayout.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout.11
 * JD-Core Version:    0.7.0.1
 */