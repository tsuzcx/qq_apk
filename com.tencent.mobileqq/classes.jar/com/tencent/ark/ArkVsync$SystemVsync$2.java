package com.tencent.ark;

import android.view.Choreographer;

class ArkVsync$SystemVsync$2
  implements Runnable
{
  ArkVsync$SystemVsync$2(ArkVsync.SystemVsync paramSystemVsync) {}
  
  public void run()
  {
    if (this.this$0.mChoreographer != null)
    {
      this.this$0.mChoreographer.removeFrameCallback(this.this$0);
      ArkVsync.SystemVsync localSystemVsync = this.this$0;
      localSystemVsync.mChoreographer = null;
      localSystemVsync.mVsync = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkVsync.SystemVsync.2
 * JD-Core Version:    0.7.0.1
 */