package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.d;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener;

class TRTCCloudImpl$81
  implements Runnable
{
  TRTCCloudImpl$81(TRTCCloudImpl paramTRTCCloudImpl, int paramInt1, int paramInt2, TRTCCloudListener.TRTCVideoRenderListener paramTRTCVideoRenderListener) {}
  
  public void run()
  {
    this.this$0.apiLog(String.format("setLocalVideoRenderListener pixelFormat:%d bufferType:%d", new Object[] { Integer.valueOf(this.val$pixelFormat), Integer.valueOf(this.val$bufferType) }));
    this.this$0.mRoomInfo.localPixelFormat = this.val$pixelFormat;
    this.this$0.mRoomInfo.localBufferType = this.val$bufferType;
    TRTCRoomInfo localTRTCRoomInfo = this.this$0.mRoomInfo;
    TRTCCloudListener.TRTCVideoRenderListener localTRTCVideoRenderListener = this.val$listener;
    localTRTCRoomInfo.localListener = localTRTCVideoRenderListener;
    if (localTRTCVideoRenderListener == null)
    {
      this.this$0.mCaptureAndEnc.a(null, this.val$pixelFormat);
      return;
    }
    this.this$0.mCaptureAndEnc.a(this.this$0, this.val$pixelFormat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.81
 * JD-Core Version:    0.7.0.1
 */