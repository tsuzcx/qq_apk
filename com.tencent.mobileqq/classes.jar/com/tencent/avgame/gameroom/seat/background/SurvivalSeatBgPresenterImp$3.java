package com.tencent.avgame.gameroom.seat.background;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import java.util.List;

class SurvivalSeatBgPresenterImp$3
  implements Animator.AnimatorListener
{
  SurvivalSeatBgPresenterImp$3(SurvivalSeatBgPresenterImp paramSurvivalSeatBgPresenterImp) {}
  
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
 * Qualified Name:     com.tencent.avgame.gameroom.seat.background.SurvivalSeatBgPresenterImp.3
 * JD-Core Version:    0.7.0.1
 */