package com.tencent.liteav.device;

import com.tencent.liteav.d;

class TXDeviceManagerImpl$2
  implements Runnable
{
  TXDeviceManagerImpl$2(TXDeviceManagerImpl paramTXDeviceManagerImpl, float paramFloat) {}
  
  public void run()
  {
    TXDeviceManagerImpl localTXDeviceManagerImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCameraZoomRatio ");
    localStringBuilder.append(this.val$zoomRatio);
    localTXDeviceManagerImpl.apiLog(localStringBuilder.toString());
    this.this$0.mCaptureAndEnc.i((int)this.val$zoomRatio);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.device.TXDeviceManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */