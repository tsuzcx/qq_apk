package com.tencent.mobileqq.activity.aio.audiopanel;

import acrv;
import acrw;
import java.util.TimerTask;

public class VoiceTextShowAnimator$1
  extends TimerTask
{
  public VoiceTextShowAnimator$1(acrv paramacrv) {}
  
  public void run()
  {
    int i = acrv.a(this.this$0) / 3;
    acrv.a(this.this$0, acrv.a()[(i % 3)]);
    if (acrv.a(this.this$0) != null) {
      acrv.a(this.this$0).h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextShowAnimator.1
 * JD-Core Version:    0.7.0.1
 */