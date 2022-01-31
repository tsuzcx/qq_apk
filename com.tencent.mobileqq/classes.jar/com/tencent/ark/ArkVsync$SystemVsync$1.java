package com.tencent.ark;

import android.view.Choreographer;

class ArkVsync$SystemVsync$1
  implements Runnable
{
  ArkVsync$SystemVsync$1(ArkVsync.SystemVsync paramSystemVsync) {}
  
  public void run()
  {
    if (this.this$0.mChoreographer == null) {
      this.this$0.mChoreographer = Choreographer.getInstance();
    }
    this.this$0.mChoreographer.postFrameCallback(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ark.ArkVsync.SystemVsync.1
 * JD-Core Version:    0.7.0.1
 */