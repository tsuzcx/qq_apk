package com.tencent.avgame.gameroom.seat;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class TalkingEffectLayout$1
  implements Animator.AnimatorListener
{
  TalkingEffectLayout$1(TalkingEffectLayout paramTalkingEffectLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (TalkingEffectLayout.a(this.a) != null) {
      TalkingEffectLayout.a(this.a).onAnimationCancel(paramAnimator);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (TalkingEffectLayout.a(this.a) != null) {
      TalkingEffectLayout.a(this.a).onAnimationEnd(paramAnimator);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (TalkingEffectLayout.a(this.a) != null) {
      TalkingEffectLayout.a(this.a).onAnimationRepeat(paramAnimator);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (TalkingEffectLayout.a(this.a) != null) {
      TalkingEffectLayout.a(this.a).onAnimationStart(paramAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.TalkingEffectLayout.1
 * JD-Core Version:    0.7.0.1
 */