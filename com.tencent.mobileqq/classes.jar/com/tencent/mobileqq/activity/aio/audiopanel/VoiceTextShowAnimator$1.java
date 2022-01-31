package com.tencent.mobileqq.activity.aio.audiopanel;

import adco;
import adcp;
import java.util.TimerTask;

public class VoiceTextShowAnimator$1
  extends TimerTask
{
  public VoiceTextShowAnimator$1(adco paramadco) {}
  
  public void run()
  {
    int i = adco.a(this.this$0) / 3;
    adco.a(this.this$0, adco.a()[(i % 3)]);
    if (adco.a(this.this$0) != null) {
      adco.a(this.this$0).h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextShowAnimator.1
 * JD-Core Version:    0.7.0.1
 */