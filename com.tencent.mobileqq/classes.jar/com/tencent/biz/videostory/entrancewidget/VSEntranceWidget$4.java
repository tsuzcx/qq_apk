package com.tencent.biz.videostory.entrancewidget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class VSEntranceWidget$4
  implements Animation.AnimationListener
{
  VSEntranceWidget$4(VSEntranceWidget paramVSEntranceWidget) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (VSEntranceWidget.b(this.a) != null) {
      VSEntranceWidget.b(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.entrancewidget.VSEntranceWidget.4
 * JD-Core Version:    0.7.0.1
 */