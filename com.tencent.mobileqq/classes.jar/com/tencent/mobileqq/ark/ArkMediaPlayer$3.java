package com.tencent.mobileqq.ark;

import aqcr;

public class ArkMediaPlayer$3
  implements Runnable
{
  public ArkMediaPlayer$3(aqcr paramaqcr) {}
  
  public void run()
  {
    aqcr.a(this.this$0, false);
    if (this.this$0.Pause()) {
      aqcr.a(this.this$0, aqcr.d(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkMediaPlayer.3
 * JD-Core Version:    0.7.0.1
 */