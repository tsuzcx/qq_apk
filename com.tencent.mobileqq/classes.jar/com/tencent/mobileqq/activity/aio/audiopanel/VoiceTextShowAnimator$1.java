package com.tencent.mobileqq.activity.aio.audiopanel;

import aeun;
import aeuo;
import java.util.TimerTask;

public class VoiceTextShowAnimator$1
  extends TimerTask
{
  public VoiceTextShowAnimator$1(aeun paramaeun) {}
  
  public void run()
  {
    int i = aeun.a(this.this$0) / 3;
    aeun.a(this.this$0, aeun.a()[(i % 3)]);
    if (aeun.a(this.this$0) != null) {
      aeun.a(this.this$0).h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextShowAnimator.1
 * JD-Core Version:    0.7.0.1
 */