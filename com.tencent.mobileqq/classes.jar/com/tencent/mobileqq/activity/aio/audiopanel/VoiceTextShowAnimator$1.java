package com.tencent.mobileqq.activity.aio.audiopanel;

import adcl;
import adcm;
import java.util.TimerTask;

public class VoiceTextShowAnimator$1
  extends TimerTask
{
  public VoiceTextShowAnimator$1(adcl paramadcl) {}
  
  public void run()
  {
    int i = adcl.a(this.this$0) / 3;
    adcl.a(this.this$0, adcl.a()[(i % 3)]);
    if (adcl.a(this.this$0) != null) {
      adcl.a(this.this$0).h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextShowAnimator.1
 * JD-Core Version:    0.7.0.1
 */