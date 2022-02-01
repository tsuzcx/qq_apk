package com.tencent.mobileqq.ark;

import appb;

public class ArkMediaPlayer$2
  implements Runnable
{
  public ArkMediaPlayer$2(appb paramappb) {}
  
  public void run()
  {
    if (appb.a(this.this$0)) {
      return;
    }
    appb.a(this.this$0, true);
    if (appb.a(this.this$0) == appb.b(this.this$0)) {
      this.this$0.Play();
    }
    for (;;)
    {
      appb.a(this.this$0, appb.f(this.this$0));
      return;
      if (appb.a(this.this$0) == appb.c(this.this$0)) {
        this.this$0.Stop();
      } else if (appb.a(this.this$0) == appb.d(this.this$0)) {
        this.this$0.Resume();
      } else if (appb.a(this.this$0) == appb.e(this.this$0)) {
        this.this$0.Pause();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkMediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */