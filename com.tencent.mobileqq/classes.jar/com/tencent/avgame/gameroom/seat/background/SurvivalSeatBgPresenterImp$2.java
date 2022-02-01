package com.tencent.avgame.gameroom.seat.background;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import java.util.List;

class SurvivalSeatBgPresenterImp$2
  implements Animator.AnimatorListener
{
  SurvivalSeatBgPresenterImp$2(SurvivalSeatBgPresenterImp paramSurvivalSeatBgPresenterImp, Animator.AnimatorListener paramAnimatorListener) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener != null) {
      this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener.onAnimationCancel(paramAnimator);
    }
    SurvivalSeatBgPresenterImp.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgPresenterImp).remove(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener != null) {
      this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener.onAnimationEnd(paramAnimator);
    }
    SurvivalSeatBgPresenterImp.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgPresenterImp).remove(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener != null) {
      this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener.onAnimationRepeat(paramAnimator);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener != null) {
      this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener.onAnimationStart(paramAnimator);
    }
    SurvivalSeatBgPresenterImp.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgPresenterImp).add(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.background.SurvivalSeatBgPresenterImp.2
 * JD-Core Version:    0.7.0.1
 */