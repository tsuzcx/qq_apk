package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$5
  implements Runnable
{
  TRTCCloudImpl$5(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloudListener paramTRTCCloudListener) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setListener ");
    localStringBuilder.append(this.val$listener);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    this.this$0.mTRTCListener = this.val$listener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.5
 * JD-Core Version:    0.7.0.1
 */