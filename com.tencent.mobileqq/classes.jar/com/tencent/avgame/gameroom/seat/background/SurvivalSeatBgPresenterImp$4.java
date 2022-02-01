package com.tencent.avgame.gameroom.seat.background;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import java.util.List;

class SurvivalSeatBgPresenterImp$4
  implements Animator.AnimatorListener
{
  SurvivalSeatBgPresenterImp$4(SurvivalSeatBgPresenterImp paramSurvivalSeatBgPresenterImp) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    SurvivalSeatBgPresenterImp.a(this.a).remove(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SurvivalSeatBgPresenterImp.a(this.a).remove(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    SurvivalSeatBgPresenterImp.a(this.a).add(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.background.SurvivalSeatBgPresenterImp.4
 * JD-Core Version:    0.7.0.1
 */