package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.Monitor;
import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$150$2
  implements Runnable
{
  TRTCCloudImpl$150$2(TRTCCloudImpl.150 param150, TRTCCloudListener paramTRTCCloudListener, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = this.val$listener;
    if (localObject != null) {
      ((TRTCCloudListener)localObject).onUserAudioAvailable(this.this$1.val$userID, this.val$audioAvailable);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.format("onUserAudioAvailable userID:%s, bAvailable:%b", new Object[] { this.this$1.val$userID, Boolean.valueOf(this.val$audioAvailable) }));
    ((StringBuilder)localObject).append(" self:");
    ((StringBuilder)localObject).append(this.this$1.this$0.hashCode());
    Monitor.a(2, ((StringBuilder)localObject).toString(), "", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.150.2
 * JD-Core Version:    0.7.0.1
 */