package com.tencent.mars.comm;

import android.os.PowerManager.WakeLock;

class WakerLock$1
  implements Runnable
{
  WakerLock$1(WakerLock paramWakerLock) {}
  
  public void run()
  {
    if (WakerLock.access$000(this.this$0).isHeld())
    {
      this.this$0.unLock();
      if (WakerLock.access$100(this.this$0) != null) {
        WakerLock.access$100(this.this$0).autoUnlockCallback();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.comm.WakerLock.1
 * JD-Core Version:    0.7.0.1
 */