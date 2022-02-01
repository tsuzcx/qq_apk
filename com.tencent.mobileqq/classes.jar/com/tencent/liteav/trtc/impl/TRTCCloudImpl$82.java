package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener;
import java.util.HashMap;

class TRTCCloudImpl$82
  implements Runnable
{
  TRTCCloudImpl$82(TRTCCloudImpl paramTRTCCloudImpl, String paramString, int paramInt1, int paramInt2, TRTCCloudListener.TRTCVideoRenderListener paramTRTCVideoRenderListener) {}
  
  public void run()
  {
    this.this$0.apiLog(String.format("setRemoteVideoRenderListener userid:%s pixelFormat:%d bufferType:%d", new Object[] { this.val$userId, Integer.valueOf(this.val$pixelFormat), Integer.valueOf(this.val$bufferType) }));
    if (this.val$listener == null)
    {
      this.this$0.mRenderListenerMap.remove(this.val$userId);
    }
    else
    {
      TRTCCloudImpl.RenderListenerAdapter localRenderListenerAdapter = new TRTCCloudImpl.RenderListenerAdapter();
      localRenderListenerAdapter.bufferType = this.val$bufferType;
      localRenderListenerAdapter.pixelFormat = this.val$pixelFormat;
      localRenderListenerAdapter.listener = this.val$listener;
      this.this$0.mRenderListenerMap.put(this.val$userId, localRenderListenerAdapter);
      TRTCCloudImpl.access$6302(this.this$0, true);
    }
    this.this$0.mRoomInfo.forEachUser(new TRTCCloudImpl.82.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.82
 * JD-Core Version:    0.7.0.1
 */