package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;

class TRTCCloudImpl$50
  implements Runnable
{
  TRTCCloudImpl$50(TRTCCloudImpl paramTRTCCloudImpl, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("muteLocalAudio ");
    localStringBuilder.append(this.val$mute);
    ((TRTCCloudImpl)localObject).apiLog(localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.format("muteLocalAudio mute:%b", new Object[] { Boolean.valueOf(this.val$mute) }));
    ((StringBuilder)localObject).append(" self:");
    ((StringBuilder)localObject).append(this.this$0.hashCode());
    Monitor.a(1, ((StringBuilder)localObject).toString(), "", 0);
    localObject = this.this$0;
    ((TRTCCloudImpl)localObject).muteLocalAudio(this.val$mute, (TRTCCloudImpl)localObject);
    if (this.val$mute)
    {
      TXCEventRecorderProxy.a("18446744073709551615", 3001, 1L, -1L, "", 0);
      return;
    }
    TXCEventRecorderProxy.a("18446744073709551615", 3001, 3L, -1L, "", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.50
 * JD-Core Version:    0.7.0.1
 */