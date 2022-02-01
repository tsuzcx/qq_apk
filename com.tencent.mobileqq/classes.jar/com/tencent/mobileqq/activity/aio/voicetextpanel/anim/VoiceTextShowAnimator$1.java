package com.tencent.mobileqq.activity.aio.voicetextpanel.anim;

import ahry;
import ahrz;
import java.util.TimerTask;

public class VoiceTextShowAnimator$1
  extends TimerTask
{
  public VoiceTextShowAnimator$1(ahry paramahry) {}
  
  public void run()
  {
    int i = ahry.a(this.this$0) / ahry.a().length;
    int j = ahry.a().length;
    ahry.a(this.this$0, ahry.a()[(i % j)]);
    if (ahry.a(this.this$0) != null) {
      ahry.a(this.this$0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.anim.VoiceTextShowAnimator.1
 * JD-Core Version:    0.7.0.1
 */