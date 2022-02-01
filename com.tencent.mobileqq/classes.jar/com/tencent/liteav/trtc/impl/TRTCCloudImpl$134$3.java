package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$134$3
  implements Runnable
{
  TRTCCloudImpl$134$3(TRTCCloudImpl.134 param134, boolean paramBoolean, TRTCCloudListener paramTRTCCloudListener) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notify onUserVideoAvailable:");
    ((StringBuilder)localObject).append(this.this$1.val$tinyID);
    ((StringBuilder)localObject).append(" [");
    ((StringBuilder)localObject).append(this.val$mainVideoAvailable);
    ((StringBuilder)localObject).append("] by bit state. self:");
    ((StringBuilder)localObject).append(this.this$1.this$0.hashCode());
    TXCLog.i("TRTCCloudImpl", ((StringBuilder)localObject).toString());
    localObject = this.val$listener;
    if (localObject != null) {
      ((TRTCCloudListener)localObject).onUserVideoAvailable(this.this$1.val$userID, this.val$mainVideoAvailable);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.format("onUserVideoAvailable userID:%s, bAvailable:%b", new Object[] { this.this$1.val$userID, Boolean.valueOf(this.val$mainVideoAvailable) }));
    ((StringBuilder)localObject).append(" self:");
    ((StringBuilder)localObject).append(this.this$1.this$0.hashCode());
    Monitor.a(2, ((StringBuilder)localObject).toString(), "", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.134.3
 * JD-Core Version:    0.7.0.1
 */