package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.module.Monitor;

class TRTCCloudImpl$55
  implements Runnable
{
  TRTCCloudImpl$55(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("setSystemVolumeType type:%d,  auto(0),media(1),VOIP(2)", new Object[] { Integer.valueOf(this.val$type) }));
    localStringBuilder.append(" self:");
    localStringBuilder.append(this.this$0.hashCode());
    Monitor.a(1, localStringBuilder.toString(), "", 0);
    int i = this.val$type;
    if ((i == 0) || (1 == i) || (2 == i))
    {
      TXCAudioEngine.getInstance();
      TXCAudioEngine.setSystemVolumeType(this.val$type);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.55
 * JD-Core Version:    0.7.0.1
 */