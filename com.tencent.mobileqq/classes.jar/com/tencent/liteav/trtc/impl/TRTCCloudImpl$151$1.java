package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$151$1
  implements Runnable
{
  TRTCCloudImpl$151$1(TRTCCloudImpl.151 param151, String paramString) {}
  
  public void run()
  {
    TRTCCloudListener localTRTCCloudListener = this.this$1.this$0.mTRTCListener;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notify onUserVideoAvailable:");
    localStringBuilder.append(this.this$1.val$tinyId);
    localStringBuilder.append(" [true] by IDR. self:");
    localStringBuilder.append(this.this$1.this$0.hashCode());
    TXCLog.i("TRTCCloudImpl", localStringBuilder.toString());
    if (localTRTCCloudListener != null)
    {
      localTRTCCloudListener.onUserVideoAvailable(this.val$userId, true);
      TRTCCloudImpl.access$8000(this.this$1.this$0, this.this$1.this$0.mRoomInfo.getUserId(), 0, String.format("[%s]video Available[%b]", new Object[] { this.val$userId, Boolean.valueOf(true) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.151.1
 * JD-Core Version:    0.7.0.1
 */