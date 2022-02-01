package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.d;

class TRTCCloudImpl$43
  implements Runnable
{
  TRTCCloudImpl$43(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    TRTCCloudImpl.access$4302(this.this$0, this.val$mode);
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLocalViewMirror ");
    localStringBuilder.append(this.val$mode);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    this.this$0.mCaptureAndEnc.b(this.val$mode);
    TRTCCloudImpl.access$2100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.43
 * JD-Core Version:    0.7.0.1
 */