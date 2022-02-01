package com.tencent.mobileqq.activity.aio.voicetextpanel.anim;

import java.util.TimerTask;

class VoiceTextShowAnimator$1
  extends TimerTask
{
  VoiceTextShowAnimator$1(VoiceTextShowAnimator paramVoiceTextShowAnimator) {}
  
  public void run()
  {
    int i = VoiceTextShowAnimator.a(this.this$0) / VoiceTextShowAnimator.a().length;
    int j = VoiceTextShowAnimator.a().length;
    VoiceTextShowAnimator.a(this.this$0, VoiceTextShowAnimator.a()[(i % j)]);
    if (VoiceTextShowAnimator.a(this.this$0) != null) {
      VoiceTextShowAnimator.a(this.this$0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.anim.VoiceTextShowAnimator.1
 * JD-Core Version:    0.7.0.1
 */