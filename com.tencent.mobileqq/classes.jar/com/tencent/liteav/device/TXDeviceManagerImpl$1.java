package com.tencent.liteav.device;

import com.tencent.liteav.d;

class TXDeviceManagerImpl$1
  implements Runnable
{
  TXDeviceManagerImpl$1(TXDeviceManagerImpl paramTXDeviceManagerImpl, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.val$oldFrontCamera != this.val$frontCamera)
    {
      this.this$0.mCaptureAndEnc.l();
      if (TXDeviceManagerImpl.access$000(this.this$0) != null) {
        TXDeviceManagerImpl.access$000(this.this$0).onSwitchCamera(this.val$frontCamera);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.device.TXDeviceManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */