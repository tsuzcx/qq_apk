package com.tencent.mobileqq.activity.aio.audiopanel;

import agfo;
import agfp;
import java.util.TimerTask;

public class VoiceTextShowAnimator$1
  extends TimerTask
{
  public VoiceTextShowAnimator$1(agfo paramagfo) {}
  
  public void run()
  {
    int i = agfo.a(this.this$0) / 3;
    agfo.a(this.this$0, agfo.a()[(i % 3)]);
    if (agfo.a(this.this$0) != null) {
      agfo.a(this.this$0).h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextShowAnimator.1
 * JD-Core Version:    0.7.0.1
 */