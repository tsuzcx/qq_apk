package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.d;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoFrameListener;

class TRTCCloudImpl$90
  implements Runnable
{
  TRTCCloudImpl$90(TRTCCloudImpl paramTRTCCloudImpl, int paramInt1, int paramInt2, TRTCCloudListener.TRTCVideoFrameListener paramTRTCVideoFrameListener) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    int i = this.val$pixelFormat;
    boolean bool = false;
    ((TRTCCloudImpl)localObject).apiLog("setLocalVideoPreprocessListener pixelFormat: %d, bufferType: %d, listener: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.val$bufferType), this.val$listener });
    TRTCCloudImpl.access$7800(this.this$0).setListener(this.val$pixelFormat, this.val$bufferType, this.val$listener);
    localObject = this.this$0.mCaptureAndEnc;
    if (this.val$listener == null) {
      bool = true;
    }
    ((d)localObject).b(bool);
    this.this$0.mCaptureAndEnc.a(TRTCCloudImpl.access$7800(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.90
 * JD-Core Version:    0.7.0.1
 */