package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.Monitor;

class TRTCCloudImpl$9
  implements Runnable
{
  TRTCCloudImpl$9(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    this.this$0.apiLog("DisconnectOtherRoom");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DisconnectOtherRoom self:");
    ((StringBuilder)localObject).append(this.this$0.hashCode());
    Monitor.a(1, ((StringBuilder)localObject).toString(), "", 0);
    localObject = this.this$0;
    TRTCCloudImpl.access$1800((TRTCCloudImpl)localObject, ((TRTCCloudImpl)localObject).mNativeRtcContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.9
 * JD-Core Version:    0.7.0.1
 */