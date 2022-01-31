package com.tencent.mobileqq.ark;

import anov;

public class ArkMediaPlayer$2
  implements Runnable
{
  public ArkMediaPlayer$2(anov paramanov) {}
  
  public void run()
  {
    if (anov.a(this.this$0)) {
      return;
    }
    anov.a(this.this$0, true);
    if (anov.a(this.this$0) == anov.b(this.this$0)) {
      this.this$0.Play();
    }
    for (;;)
    {
      anov.a(this.this$0, anov.f(this.this$0));
      return;
      if (anov.a(this.this$0) == anov.c(this.this$0)) {
        this.this$0.Stop();
      } else if (anov.a(this.this$0) == anov.d(this.this$0)) {
        this.this$0.Resume();
      } else if (anov.a(this.this$0) == anov.e(this.this$0)) {
        this.this$0.Pause();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkMediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */