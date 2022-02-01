package com.tencent.mobileqq.activity.pendant;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class AvatarPendantActivity$9
  extends D8SafeAnimatorListener
{
  AvatarPendantActivity$9(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.e = AvatarPendantActivity.c;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.e = AvatarPendantActivity.a;
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.e = AvatarPendantActivity.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.9
 * JD-Core Version:    0.7.0.1
 */