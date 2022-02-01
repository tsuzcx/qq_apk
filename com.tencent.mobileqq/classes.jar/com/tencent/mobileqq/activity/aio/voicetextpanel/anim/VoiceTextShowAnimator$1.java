package com.tencent.mobileqq.activity.aio.voicetextpanel.anim;

import aixn;
import aixo;
import java.util.TimerTask;

public class VoiceTextShowAnimator$1
  extends TimerTask
{
  public VoiceTextShowAnimator$1(aixn paramaixn) {}
  
  public void run()
  {
    int i = aixn.a(this.this$0) / aixn.a().length;
    int j = aixn.a().length;
    aixn.a(this.this$0, aixn.a()[(i % j)]);
    if (aixn.a(this.this$0) != null) {
      aixn.a(this.this$0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.anim.VoiceTextShowAnimator.1
 * JD-Core Version:    0.7.0.1
 */