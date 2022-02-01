package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.d;

class TRTCCloudImpl$37
  implements Runnable
{
  TRTCCloudImpl$37(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("vrotation setLocalViewRotation ");
    localStringBuilder.append(this.val$rotation);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    this.this$0.mRoomInfo.localRenderRotation = (this.val$rotation * 90);
    this.this$0.mCaptureAndEnc.g(this.val$rotation * 90);
    TRTCCloudImpl.access$2100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.37
 * JD-Core Version:    0.7.0.1
 */