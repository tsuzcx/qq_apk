package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$180
  implements Runnable
{
  TRTCCloudImpl$180(TRTCCloudImpl paramTRTCCloudImpl, int paramInt, String paramString) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLocalRecordBegin ");
    localStringBuilder.append(this.val$errCode);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.val$storagePath);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    if (this.this$0.mTRTCListener != null) {
      this.this$0.mTRTCListener.onLocalRecordBegin(this.val$errCode, this.val$storagePath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.180
 * JD-Core Version:    0.7.0.1
 */