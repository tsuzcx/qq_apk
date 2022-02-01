package com.tencent.biz.videostory.entrancewidget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;

class VSEntranceWidget$3
  implements Animation.AnimationListener
{
  VSEntranceWidget$3(VSEntranceWidget paramVSEntranceWidget) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (VSEntranceWidget.a(this.a) != null) {
      VSEntranceWidget.a(this.a).setVisibility(4);
    }
    if (VSEntranceWidget.a(this.a) != null) {
      VSEntranceWidget.a(this.a).setAlpha(1.0F);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.entrancewidget.VSEntranceWidget.3
 * JD-Core Version:    0.7.0.1
 */