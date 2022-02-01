package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$174
  implements Runnable
{
  TRTCCloudImpl$174(TRTCCloudImpl paramTRTCCloudImpl, int paramInt, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTranscodingUpdated err:");
    localStringBuilder.append(this.val$code);
    localStringBuilder.append(", msg:");
    localStringBuilder.append(this.val$msg);
    ((TRTCCloudImpl)localObject).apiOnlineLog(localStringBuilder.toString());
    localObject = this.this$0.mTRTCListener;
    if (localObject != null) {
      ((TRTCCloudListener)localObject).onSetMixTranscodingConfig(this.val$code, this.val$msg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.174
 * JD-Core Version:    0.7.0.1
 */