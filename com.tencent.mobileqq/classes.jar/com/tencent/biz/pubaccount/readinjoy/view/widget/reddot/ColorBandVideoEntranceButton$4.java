package com.tencent.biz.pubaccount.readinjoy.view.widget.reddot;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class ColorBandVideoEntranceButton$4
  extends AnimatorListenerAdapter
{
  ColorBandVideoEntranceButton$4(ColorBandVideoEntranceButton paramColorBandVideoEntranceButton) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.a();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ThreadManager.getUIHandler().postDelayed(new ColorBandVideoEntranceButton.4.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton.4
 * JD-Core Version:    0.7.0.1
 */