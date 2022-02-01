package com.tencent.biz.videostory.entrancewidget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class VSEntranceWidget$2
  implements Animation.AnimationListener
{
  VSEntranceWidget$2(VSEntranceWidget paramVSEntranceWidget) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (VSEntranceWidget.a(this.a) != null)
    {
      VSEntranceWidget.a(this.a).clearAnimation();
      VSEntranceWidget.a(this.a).startAnimation(VSEntranceWidget.b(this.a));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.entrancewidget.VSEntranceWidget.2
 * JD-Core Version:    0.7.0.1
 */