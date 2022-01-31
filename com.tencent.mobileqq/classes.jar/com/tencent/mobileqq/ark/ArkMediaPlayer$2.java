package com.tencent.mobileqq.ark;

import alfg;

public class ArkMediaPlayer$2
  implements Runnable
{
  public ArkMediaPlayer$2(alfg paramalfg) {}
  
  public void run()
  {
    if (alfg.a(this.this$0)) {
      return;
    }
    alfg.a(this.this$0, true);
    if (alfg.a(this.this$0) == alfg.b(this.this$0)) {
      this.this$0.Play();
    }
    for (;;)
    {
      alfg.a(this.this$0, alfg.f(this.this$0));
      return;
      if (alfg.a(this.this$0) == alfg.c(this.this$0)) {
        this.this$0.Stop();
      } else if (alfg.a(this.this$0) == alfg.d(this.this$0)) {
        this.this$0.Resume();
      } else if (alfg.a(this.this$0) == alfg.e(this.this$0)) {
        this.this$0.Pause();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkMediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */