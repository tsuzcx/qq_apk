package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.g;

class TRTCCloudImpl$28
  implements Runnable
{
  TRTCCloudImpl$28(TRTCCloudImpl paramTRTCCloudImpl, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("muteLocalVideo ");
    localStringBuilder.append(this.val$mute);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.this$0.mConfig.A);
    ((TRTCCloudImpl)localObject).apiLog(localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.format("muteLocalVideo mute:%b", new Object[] { Boolean.valueOf(this.val$mute) }));
    ((StringBuilder)localObject).append(" self:");
    ((StringBuilder)localObject).append(this.this$0.hashCode());
    Monitor.a(1, ((StringBuilder)localObject).toString(), "", 0);
    long l;
    if (this.val$mute) {
      l = 1L;
    } else {
      l = 0L;
    }
    TXCEventRecorderProxy.a("18446744073709551615", 4006, l, -1L, "", 2);
    localObject = this.this$0;
    ((TRTCCloudImpl)localObject).muteLocalVideo(this.val$mute, (TRTCCloudImpl)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.28
 * JD-Core Version:    0.7.0.1
 */