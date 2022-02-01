package com.tencent.ark;

import java.util.TimerTask;

class ArkVsync$TimerVsync$1
  extends TimerTask
{
  ArkVsync$TimerVsync$1(ArkVsync.TimerVsync paramTimerVsync) {}
  
  public void run()
  {
    if (this.this$0.mCallbacking) {
      return;
    }
    this.this$0.mCallbacking = true;
    this.this$0.run();
    this.this$0.mCallbacking = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkVsync.TimerVsync.1
 * JD-Core Version:    0.7.0.1
 */