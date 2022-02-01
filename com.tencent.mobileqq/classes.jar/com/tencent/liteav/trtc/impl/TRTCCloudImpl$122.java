package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudDef.TRTCTranscodingConfig;

class TRTCCloudImpl$122
  implements Runnable
{
  TRTCCloudImpl$122(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloudDef.TRTCTranscodingConfig paramTRTCTranscodingConfig) {}
  
  public void run()
  {
    Object localObject1 = this.this$0;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("setMixTranscodingConfig ");
    ((StringBuilder)localObject2).append(this.val$config);
    ((TRTCCloudImpl)localObject1).apiOnlineLog(((StringBuilder)localObject2).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.122
 * JD-Core Version:    0.7.0.1
 */