package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudDef.TRTCNetworkQosParam;

class TRTCCloudImpl$34
  implements Runnable
{
  TRTCCloudImpl$34(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloudDef.TRTCNetworkQosParam paramTRTCNetworkQosParam) {}
  
  public void run()
  {
    if (this.val$param != null)
    {
      this.this$0.apiLog("setNetworkQosParam");
      TRTCCloudImpl.access$402(this.this$0, this.val$param.preference);
      TRTCCloudImpl.access$302(this.this$0, this.val$param.controlMode);
      TRTCCloudImpl localTRTCCloudImpl = this.this$0;
      TRTCCloudImpl.access$500(localTRTCCloudImpl, TRTCCloudImpl.access$300(localTRTCCloudImpl), TRTCCloudImpl.access$400(this.this$0));
      return;
    }
    this.this$0.apiLog("setNetworkQosParam param is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.34
 * JD-Core Version:    0.7.0.1
 */