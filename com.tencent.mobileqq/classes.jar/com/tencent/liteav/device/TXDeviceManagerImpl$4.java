package com.tencent.liteav.device;

import com.tencent.liteav.d;

class TXDeviceManagerImpl$4
  implements Runnable
{
  TXDeviceManagerImpl$4(TXDeviceManagerImpl paramTXDeviceManagerImpl, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    TXDeviceManagerImpl localTXDeviceManagerImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCameraFocusPosition x:");
    localStringBuilder.append(this.val$x);
    localStringBuilder.append("y:");
    localStringBuilder.append(this.val$y);
    localTXDeviceManagerImpl.apiLog(localStringBuilder.toString());
    this.this$0.mCaptureAndEnc.b(this.val$x, this.val$y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.device.TXDeviceManagerImpl.4
 * JD-Core Version:    0.7.0.1
 */