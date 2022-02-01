package com.tencent.mobileqq.activity.aio.voicetextpanel.anim;

import aimx;
import aimy;
import java.util.TimerTask;

public class VoiceTextShowAnimator$1
  extends TimerTask
{
  public VoiceTextShowAnimator$1(aimx paramaimx) {}
  
  public void run()
  {
    int i = aimx.a(this.this$0) / aimx.a().length;
    int j = aimx.a().length;
    aimx.a(this.this$0, aimx.a()[(i % j)]);
    if (aimx.a(this.this$0) != null) {
      aimx.a(this.this$0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.anim.VoiceTextShowAnimator.1
 * JD-Core Version:    0.7.0.1
 */