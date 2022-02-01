package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$182
  implements Runnable
{
  TRTCCloudImpl$182(TRTCCloudImpl paramTRTCCloudImpl, long paramLong, String paramString) {}
  
  public void run()
  {
    if (this.this$0.mTRTCListener != null) {
      this.this$0.mTRTCListener.onLocalRecording(this.val$duration, this.val$storagePath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.182
 * JD-Core Version:    0.7.0.1
 */