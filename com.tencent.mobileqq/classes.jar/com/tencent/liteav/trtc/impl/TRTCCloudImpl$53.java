package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.Monitor;

class TRTCCloudImpl$53
  implements Runnable
{
  TRTCCloudImpl$53(TRTCCloudImpl paramTRTCCloudImpl, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("muteAllRemoteAudio ");
    localStringBuilder.append(this.val$mute);
    ((TRTCCloudImpl)localObject).apiLog(localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.format("muteAllRemoteAudio mute:%b", new Object[] { Boolean.valueOf(this.val$mute) }));
    ((StringBuilder)localObject).append(" self:");
    ((StringBuilder)localObject).append(this.this$0.hashCode());
    Monitor.a(1, ((StringBuilder)localObject).toString(), "", 0);
    this.this$0.mRoomInfo.muteRemoteAudio = this.val$mute;
    this.this$0.mRoomInfo.forEachUser(new TRTCCloudImpl.53.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.53
 * JD-Core Version:    0.7.0.1
 */