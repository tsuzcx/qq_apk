package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.Monitor;

class TRTCCloudImpl$22
  implements Runnable
{
  TRTCCloudImpl$22(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    this.this$0.apiLog("stopAllRemoteView");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopAllRemoteView self:");
    localStringBuilder.append(this.this$0.hashCode());
    Monitor.a(1, localStringBuilder.toString(), "", 0);
    this.this$0.mRoomInfo.forEachUser(new TRTCCloudImpl.22.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.22
 * JD-Core Version:    0.7.0.1
 */