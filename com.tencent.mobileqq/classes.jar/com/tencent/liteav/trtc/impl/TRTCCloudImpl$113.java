package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.Monitor;
import com.tencent.trtc.TRTCCloudDef.TRTCTranscodingConfig;

class TRTCCloudImpl$113
  implements Runnable
{
  TRTCCloudImpl$113(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloudDef.TRTCTranscodingConfig paramTRTCTranscodingConfig) {}
  
  public void run()
  {
    Object localObject1 = this.this$0;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("setMixTranscodingConfig ");
    ((StringBuilder)localObject2).append(this.val$config);
    ((TRTCCloudImpl)localObject1).apiLog(((StringBuilder)localObject2).toString());
    if (this.val$config == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("cancelLiveMixTranscoding self:");
      ((StringBuilder)localObject1).append(this.this$0.hashCode());
      Monitor.a(1, ((StringBuilder)localObject1).toString(), "", 0);
    }
    localObject1 = this.val$config;
    if (localObject1 != null)
    {
      localObject1 = new TRTCTranscodingConfigInner((TRTCCloudDef.TRTCTranscodingConfig)localObject1);
      localObject2 = this.this$0;
      ((TRTCCloudImpl)localObject2).nativeSetMixTranscodingConfig(((TRTCCloudImpl)localObject2).mNativeRtcContext, (TRTCTranscodingConfigInner)localObject1);
      return;
    }
    localObject1 = this.this$0;
    ((TRTCCloudImpl)localObject1).nativeSetMixTranscodingConfig(((TRTCCloudImpl)localObject1).mNativeRtcContext, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.113
 * JD-Core Version:    0.7.0.1
 */