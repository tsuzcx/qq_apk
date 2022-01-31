package com.tencent.mobileqq.ark;

import altu;

public class ArkMediaPlayer$2
  implements Runnable
{
  public ArkMediaPlayer$2(altu paramaltu) {}
  
  public void run()
  {
    if (altu.a(this.this$0)) {
      return;
    }
    altu.a(this.this$0, true);
    if (altu.a(this.this$0) == altu.b(this.this$0)) {
      this.this$0.Play();
    }
    for (;;)
    {
      altu.a(this.this$0, altu.f(this.this$0));
      return;
      if (altu.a(this.this$0) == altu.c(this.this$0)) {
        this.this$0.Stop();
      } else if (altu.a(this.this$0) == altu.d(this.this$0)) {
        this.this$0.Resume();
      } else if (altu.a(this.this$0) == altu.e(this.this$0)) {
        this.this$0.Pause();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkMediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */