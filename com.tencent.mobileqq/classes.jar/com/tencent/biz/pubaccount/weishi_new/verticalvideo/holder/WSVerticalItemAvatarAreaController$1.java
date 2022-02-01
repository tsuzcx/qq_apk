package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

class WSVerticalItemAvatarAreaController$1
  implements Animator.AnimatorListener
{
  WSVerticalItemAvatarAreaController$1(WSVerticalItemAvatarAreaController paramWSVerticalItemAvatarAreaController) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    WSVerticalItemAvatarAreaController.a(this.a).removeAnimatorListener(this);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    WSVerticalItemAvatarAreaController.a(this.a).setVisibility(8);
    WSVerticalItemAvatarAreaController.a(this.a).removeAnimatorListener(this);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemAvatarAreaController.1
 * JD-Core Version:    0.7.0.1
 */