package com.tencent.mobileqq.activity.aio.audiopanel;

import aezc;
import aezd;
import java.util.TimerTask;

public class VoiceTextShowAnimator$1
  extends TimerTask
{
  public VoiceTextShowAnimator$1(aezc paramaezc) {}
  
  public void run()
  {
    int i = aezc.a(this.this$0) / 3;
    aezc.a(this.this$0, aezc.a()[(i % 3)]);
    if (aezc.a(this.this$0) != null) {
      aezc.a(this.this$0).h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextShowAnimator.1
 * JD-Core Version:    0.7.0.1
 */