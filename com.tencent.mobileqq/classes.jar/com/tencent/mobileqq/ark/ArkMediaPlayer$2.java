package com.tencent.mobileqq.ark;

import altt;

public class ArkMediaPlayer$2
  implements Runnable
{
  public ArkMediaPlayer$2(altt paramaltt) {}
  
  public void run()
  {
    if (altt.a(this.this$0)) {
      return;
    }
    altt.a(this.this$0, true);
    if (altt.a(this.this$0) == altt.b(this.this$0)) {
      this.this$0.Play();
    }
    for (;;)
    {
      altt.a(this.this$0, altt.f(this.this$0));
      return;
      if (altt.a(this.this$0) == altt.c(this.this$0)) {
        this.this$0.Stop();
      } else if (altt.a(this.this$0) == altt.d(this.this$0)) {
        this.this$0.Resume();
      } else if (altt.a(this.this$0) == altt.e(this.this$0)) {
        this.this$0.Pause();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkMediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */