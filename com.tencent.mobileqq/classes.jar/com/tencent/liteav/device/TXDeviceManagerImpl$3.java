package com.tencent.liteav.device;

import com.tencent.liteav.d;
import com.tencent.liteav.g;

class TXDeviceManagerImpl$3
  implements Runnable
{
  TXDeviceManagerImpl$3(TXDeviceManagerImpl paramTXDeviceManagerImpl, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableCameraAutoFocus ");
    localStringBuilder.append(this.val$enabled);
    ((TXDeviceManagerImpl)localObject).apiLog(localStringBuilder.toString());
    localObject = this.this$0.mCaptureAndEnc.c();
    ((g)localObject).L = (this.val$enabled ^ true);
    this.this$0.mCaptureAndEnc.a((g)localObject);
    if (TXDeviceManagerImpl.access$000(this.this$0) != null) {
      TXDeviceManagerImpl.access$000(this.this$0).onSwitchAutoFocus(this.val$enabled);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.device.TXDeviceManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */