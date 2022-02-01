package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.Monitor;

class TRTCCloudImpl$11
  implements Runnable
{
  TRTCCloudImpl$11(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("switchRole:");
    localStringBuilder.append(this.val$role);
    ((TRTCCloudImpl)localObject).apiLog(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    if (this.val$role == 20) {
      localObject = "Anchor";
    } else {
      localObject = "Audience";
    }
    localStringBuilder.append(String.format("switchRole:%s", new Object[] { localObject }));
    localStringBuilder.append(" self:");
    localStringBuilder.append(this.this$0.hashCode());
    Monitor.a(1, localStringBuilder.toString(), "", 0);
    localObject = this.this$0;
    ((TRTCCloudImpl)localObject).mTargetRole = this.val$role;
    TRTCCloudImpl.access$1900((TRTCCloudImpl)localObject, ((TRTCCloudImpl)localObject).mNativeRtcContext, this.val$role);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.11
 * JD-Core Version:    0.7.0.1
 */