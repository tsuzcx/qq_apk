package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.Monitor;

class TRTCCloudImpl$8
  implements Runnable
{
  TRTCCloudImpl$8(TRTCCloudImpl paramTRTCCloudImpl, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ConnectOtherRoom ");
    localStringBuilder.append(this.val$param);
    ((TRTCCloudImpl)localObject).apiLog(localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.format("ConnectOtherRoom param:%s", new Object[] { this.val$param }));
    ((StringBuilder)localObject).append(" self:");
    ((StringBuilder)localObject).append(this.this$0.hashCode());
    Monitor.a(1, ((StringBuilder)localObject).toString(), "", 0);
    localObject = this.this$0;
    TRTCCloudImpl.access$1700((TRTCCloudImpl)localObject, ((TRTCCloudImpl)localObject).mNativeRtcContext, this.val$param);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.8
 * JD-Core Version:    0.7.0.1
 */