package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.Monitor;

class TRTCCloudImpl$10
  implements Runnable
{
  TRTCCloudImpl$10(TRTCCloudImpl paramTRTCCloudImpl, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    ((TRTCCloudImpl)localObject).mRecvMode = 0;
    if ((this.val$autoRecvAudio) && (this.val$autoRecvVideo)) {
      ((TRTCCloudImpl)localObject).mRecvMode = 1;
    } else if (this.val$autoRecvAudio) {
      this.this$0.mRecvMode = 2;
    } else if (this.val$autoRecvVideo) {
      this.this$0.mRecvMode = 3;
    } else {
      this.this$0.mRecvMode = 4;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.format("setDefaultStreamRecvMode audio:%b, video:%b", new Object[] { Boolean.valueOf(this.val$autoRecvAudio), Boolean.valueOf(this.val$autoRecvVideo) }));
    ((StringBuilder)localObject).append(" self:");
    ((StringBuilder)localObject).append(this.this$0.hashCode());
    localObject = ((StringBuilder)localObject).toString();
    this.this$0.apiLog((String)localObject);
    Monitor.a(1, (String)localObject, "", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.10
 * JD-Core Version:    0.7.0.1
 */