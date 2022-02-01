package com.tencent.mobileqq.apollo.debug;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;

class CmGameDebugView$3
  implements Animation.AnimationListener
{
  CmGameDebugView$3(CmGameDebugView paramCmGameDebugView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    CmGameDebugView.a(this.a).setVisibility(8);
    CmGameDebugView.b(this.a).setVisibility(8);
    CmGameDebugView.a(this.a).clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.CmGameDebugView.3
 * JD-Core Version:    0.7.0.1
 */