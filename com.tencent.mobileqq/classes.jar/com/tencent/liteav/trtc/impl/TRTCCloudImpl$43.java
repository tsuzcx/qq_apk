package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.d;

class TRTCCloudImpl$43
  implements Runnable
{
  TRTCCloudImpl$43(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("vrotation setLocalViewRotation ");
    localStringBuilder.append(this.val$rotation);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    this.this$0.mRoomInfo.localRenderRotation = (this.val$rotation * 90);
    this.this$0.mCaptureAndEnc.g(this.val$rotation * 90);
    TRTCCloudImpl.access$100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.43
 * JD-Core Version:    0.7.0.1
 */