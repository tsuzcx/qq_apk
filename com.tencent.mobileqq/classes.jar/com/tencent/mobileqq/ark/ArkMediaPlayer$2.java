package com.tencent.mobileqq.ark;

import ankm;

public class ArkMediaPlayer$2
  implements Runnable
{
  public ArkMediaPlayer$2(ankm paramankm) {}
  
  public void run()
  {
    if (ankm.a(this.this$0)) {
      return;
    }
    ankm.a(this.this$0, true);
    if (ankm.a(this.this$0) == ankm.b(this.this$0)) {
      this.this$0.Play();
    }
    for (;;)
    {
      ankm.a(this.this$0, ankm.f(this.this$0));
      return;
      if (ankm.a(this.this$0) == ankm.c(this.this$0)) {
        this.this$0.Stop();
      } else if (ankm.a(this.this$0) == ankm.d(this.this$0)) {
        this.this$0.Resume();
      } else if (ankm.a(this.this$0) == ankm.e(this.this$0)) {
        this.this$0.Pause();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkMediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */