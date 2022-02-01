package com.tencent.mobileqq.ark;

import aowc;

public class ArkMediaPlayer$2
  implements Runnable
{
  public ArkMediaPlayer$2(aowc paramaowc) {}
  
  public void run()
  {
    if (aowc.a(this.this$0)) {
      return;
    }
    aowc.a(this.this$0, true);
    if (aowc.a(this.this$0) == aowc.b(this.this$0)) {
      this.this$0.Play();
    }
    for (;;)
    {
      aowc.a(this.this$0, aowc.f(this.this$0));
      return;
      if (aowc.a(this.this$0) == aowc.c(this.this$0)) {
        this.this$0.Stop();
      } else if (aowc.a(this.this$0) == aowc.d(this.this$0)) {
        this.this$0.Resume();
      } else if (aowc.a(this.this$0) == aowc.e(this.this$0)) {
        this.this$0.Pause();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkMediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */