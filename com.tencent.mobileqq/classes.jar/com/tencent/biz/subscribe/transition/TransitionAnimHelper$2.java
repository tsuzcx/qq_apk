package com.tencent.biz.subscribe.transition;

import android.animation.Animator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class TransitionAnimHelper$2
  extends D8SafeAnimatorListener
{
  TransitionAnimHelper$2(TransitionAnimHelper paramTransitionAnimHelper, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = (FrameLayout.LayoutParams)TransitionAnimHelper.b(this.jdField_a_of_type_ComTencentBizSubscribeTransitionTransitionAnimHelper).getLayoutParams();
    paramAnimator.height = this.jdField_a_of_type_Int;
    paramAnimator.width = this.b;
    paramAnimator.setMargins(this.c, this.d, 0, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.transition.TransitionAnimHelper.2
 * JD-Core Version:    0.7.0.1
 */