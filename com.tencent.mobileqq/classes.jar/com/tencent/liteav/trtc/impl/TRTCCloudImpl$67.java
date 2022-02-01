package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.d;
import com.tencent.trtc.TRTCCloudDef.TRTCLocalRecordingParams;

class TRTCCloudImpl$67
  implements Runnable
{
  TRTCCloudImpl$67(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloudDef.TRTCLocalRecordingParams paramTRTCLocalRecordingParams) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startLocalRecording params: ");
    localStringBuilder.append(this.val$params);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    localTRTCCloudImpl = this.this$0;
    TRTCCloudImpl.access$5600(localTRTCCloudImpl, localTRTCCloudImpl.mNativeRtcContext, this.val$params);
    this.this$0.mCaptureAndEnc.k(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.67
 * JD-Core Version:    0.7.0.1
 */