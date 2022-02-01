package com.tencent.mobileqq.activity.aio.voicetextpanel.ui;

import android.animation.Animator;
import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextScrollerListener;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class VoiceTextEditScrollerView$2
  extends D8SafeAnimatorListener
{
  VoiceTextEditScrollerView$2(VoiceTextEditScrollerView paramVoiceTextEditScrollerView, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (VoiceTextEditScrollerView.a(this.b) != null)
    {
      if (this.a == 0)
      {
        VoiceTextEditScrollerView.a(this.b).c();
        return;
      }
      VoiceTextEditScrollerView.a(this.b).b();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextEditScrollerView.2
 * JD-Core Version:    0.7.0.1
 */