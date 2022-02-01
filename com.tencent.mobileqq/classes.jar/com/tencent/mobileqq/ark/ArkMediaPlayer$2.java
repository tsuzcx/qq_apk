package com.tencent.mobileqq.ark;

import aqcr;

public class ArkMediaPlayer$2
  implements Runnable
{
  public ArkMediaPlayer$2(aqcr paramaqcr) {}
  
  public void run()
  {
    if (aqcr.a(this.this$0)) {
      return;
    }
    aqcr.a(this.this$0, true);
    if (aqcr.a(this.this$0) == aqcr.b(this.this$0)) {
      this.this$0.Play();
    }
    for (;;)
    {
      aqcr.a(this.this$0, aqcr.f(this.this$0));
      return;
      if (aqcr.a(this.this$0) == aqcr.c(this.this$0)) {
        this.this$0.Stop();
      } else if (aqcr.a(this.this$0) == aqcr.d(this.this$0)) {
        this.this$0.Resume();
      } else if (aqcr.a(this.this$0) == aqcr.e(this.this$0)) {
        this.this$0.Pause();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkMediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */