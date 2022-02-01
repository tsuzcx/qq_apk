package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.d;

class TRTCCloudImpl$49
  implements Runnable
{
  TRTCCloudImpl$49(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    TRTCCloudImpl.access$5102(this.this$0, this.val$mode);
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLocalViewMirror ");
    localStringBuilder.append(this.val$mode);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    this.this$0.mCaptureAndEnc.b(this.val$mode);
    TRTCCloudImpl.access$100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.49
 * JD-Core Version:    0.7.0.1
 */