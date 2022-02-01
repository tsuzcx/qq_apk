package com.tencent.avgame.gameroom.seat.background;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import java.util.List;

class SurvivalSeatBgPresenterImp$1
  extends D8SafeAnimatorListener
{
  SurvivalSeatBgPresenterImp$1(SurvivalSeatBgPresenterImp paramSurvivalSeatBgPresenterImp, Animator.AnimatorListener paramAnimatorListener, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    Animator.AnimatorListener localAnimatorListener = this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationCancel(paramAnimator);
    }
    SurvivalSeatBgPresenterImp.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgPresenterImp).remove(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    Animator.AnimatorListener localAnimatorListener = this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationEnd(paramAnimator);
    }
    SurvivalSeatBgPresenterImp.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgPresenterImp).remove(paramAnimator);
    if (SurvivalSeatBgPresenterImp.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgPresenterImp)) {
      SurvivalSeatBgPresenterImp.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgPresenterImp, this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    Animator.AnimatorListener localAnimatorListener = this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationRepeat(paramAnimator);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    Animator.AnimatorListener localAnimatorListener = this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationStart(paramAnimator);
    }
    SurvivalSeatBgPresenterImp.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgPresenterImp).add(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.background.SurvivalSeatBgPresenterImp.1
 * JD-Core Version:    0.7.0.1
 */