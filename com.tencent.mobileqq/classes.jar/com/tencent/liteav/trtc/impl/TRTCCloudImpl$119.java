package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioFrame;
import com.tencent.trtc.TRTCCloudListener.TRTCAudioFrameListener;

class TRTCCloudImpl$119
  implements Runnable
{
  TRTCCloudImpl$119(TRTCCloudImpl paramTRTCCloudImpl, byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    TRTCCloudListener.TRTCAudioFrameListener localTRTCAudioFrameListener = this.this$0.mAudioFrameListener;
    if (localTRTCAudioFrameListener != null)
    {
      Object localObject = new TRTCCloudDef.TRTCAudioFrame();
      ((TRTCCloudDef.TRTCAudioFrame)localObject).data = this.val$data;
      ((TRTCCloudDef.TRTCAudioFrame)localObject).timestamp = this.val$timestamp;
      ((TRTCCloudDef.TRTCAudioFrame)localObject).sampleRate = this.val$sampleRate;
      ((TRTCCloudDef.TRTCAudioFrame)localObject).channel = this.val$channels;
      try
      {
        long l = Long.valueOf(this.val$id).longValue();
        localTRTCAudioFrameListener.onRemoteUserAudioFrame((TRTCCloudDef.TRTCAudioFrame)localObject, this.this$0.mRoomInfo.getUserIdByTinyId(l));
        return;
      }
      catch (Exception localException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPlayAudioFrame failed.");
        ((StringBuilder)localObject).append(localException.getMessage());
        TXCLog.e("TRTCCloudImpl", ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.119
 * JD-Core Version:    0.7.0.1
 */