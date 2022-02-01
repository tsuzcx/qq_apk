package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.module.Monitor;

class TRTCCloudImpl$49
  implements Runnable
{
  TRTCCloudImpl$49(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAudioRoute ");
    localStringBuilder.append(this.val$route);
    ((TRTCCloudImpl)localObject).apiLog(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    if (this.val$route == 0) {
      localObject = "Speaker";
    } else {
      localObject = "Earpiece";
    }
    localStringBuilder.append(String.format("setAudioRoute route:%s", new Object[] { localObject }));
    localStringBuilder.append(" self:");
    localStringBuilder.append(this.this$0.hashCode());
    Monitor.a(1, localStringBuilder.toString(), "", 0);
    TXCAudioEngine.setAudioRoute(this.val$route);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.49
 * JD-Core Version:    0.7.0.1
 */