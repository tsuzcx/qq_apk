package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudDef.TRTCNetworkQosParam;

class TRTCCloudImpl$39
  implements Runnable
{
  TRTCCloudImpl$39(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloudDef.TRTCNetworkQosParam paramTRTCNetworkQosParam) {}
  
  public void run()
  {
    if (this.val$param != null)
    {
      this.this$0.apiLog("setNetworkQosParam");
      TRTCCloudImpl.access$702(this.this$0, this.val$param.preference);
      TRTCCloudImpl.access$602(this.this$0, this.val$param.controlMode);
      TRTCCloudImpl localTRTCCloudImpl = this.this$0;
      TRTCCloudImpl.access$800(localTRTCCloudImpl, TRTCCloudImpl.access$600(localTRTCCloudImpl), TRTCCloudImpl.access$700(this.this$0));
      return;
    }
    this.this$0.apiLog("setNetworkQosParam param is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.39
 * JD-Core Version:    0.7.0.1
 */