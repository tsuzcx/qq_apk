package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.Monitor;
import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$153
  implements Runnable
{
  TRTCCloudImpl$153(TRTCCloudImpl paramTRTCCloudImpl, int paramInt, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStopPublishing ");
    localStringBuilder.append(this.val$code);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.val$msg);
    ((TRTCCloudImpl)localObject).apiLog(localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.format("onStopPublishing err:%d, msg:%s", new Object[] { Integer.valueOf(this.val$code), this.val$msg }));
    ((StringBuilder)localObject).append(" self:");
    ((StringBuilder)localObject).append(this.this$0.hashCode());
    Monitor.a(1, ((StringBuilder)localObject).toString(), "", 0);
    localObject = this.this$0.mTRTCListener;
    if (localObject != null) {
      ((TRTCCloudListener)localObject).onStopPublishing(this.val$code, this.val$msg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.153
 * JD-Core Version:    0.7.0.1
 */