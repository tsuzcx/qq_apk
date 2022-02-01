package com.tencent.avgame.gameroom.stage.base;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class BaseStageView$5$1
  extends D8SafeAnimatorListener
{
  BaseStageView$5$1(BaseStageView.5 param5) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a.removeView(this.a.a.b);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.base.BaseStageView.5.1
 * JD-Core Version:    0.7.0.1
 */