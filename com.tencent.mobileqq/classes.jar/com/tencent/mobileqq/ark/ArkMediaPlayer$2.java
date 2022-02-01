package com.tencent.mobileqq.ark;

import apzg;

public class ArkMediaPlayer$2
  implements Runnable
{
  public ArkMediaPlayer$2(apzg paramapzg) {}
  
  public void run()
  {
    if (apzg.a(this.this$0)) {
      return;
    }
    apzg.a(this.this$0, true);
    if (apzg.a(this.this$0) == apzg.b(this.this$0)) {
      this.this$0.Play();
    }
    for (;;)
    {
      apzg.a(this.this$0, apzg.f(this.this$0));
      return;
      if (apzg.a(this.this$0) == apzg.c(this.this$0)) {
        this.this$0.Stop();
      } else if (apzg.a(this.this$0) == apzg.d(this.this$0)) {
        this.this$0.Resume();
      } else if (apzg.a(this.this$0) == apzg.e(this.this$0)) {
        this.this$0.Pause();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkMediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */