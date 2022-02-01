package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;

class TRTCCloudImpl$125
  implements Runnable
{
  TRTCCloudImpl$125(TRTCCloudImpl paramTRTCCloudImpl, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.val$err == 0)
    {
      localTRTCCloudImpl = this.this$0;
      localTRTCCloudImpl.mRoomState = 2;
      localTRTCCloudImpl.mRoomInfo.networkStatus = 3;
      if (this.this$0.mRoomInfo.muteLocalVideo)
      {
        localTRTCCloudImpl = this.this$0;
        TRTCCloudImpl.access$4100(localTRTCCloudImpl, 2, localTRTCCloudImpl.mRoomInfo.muteLocalVideo);
      }
      if (this.this$0.mRoomInfo.muteLocalAudio)
      {
        localTRTCCloudImpl = this.this$0;
        TRTCCloudImpl.access$4100(localTRTCCloudImpl, 1, localTRTCCloudImpl.mRoomInfo.muteLocalAudio);
      }
      localTRTCCloudImpl = this.this$0;
      TRTCCloudImpl.access$7600(localTRTCCloudImpl, localTRTCCloudImpl.mRoomInfo.getUserId(), 0, "Enter room success");
      return;
    }
    this.this$0.exitRoomInternal(false, "enter room failed");
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    String str = localTRTCCloudImpl.mRoomInfo.getUserId();
    int i = this.val$err;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Enter room fail ");
    localStringBuilder.append(this.val$errMsg);
    TRTCCloudImpl.access$7600(localTRTCCloudImpl, str, i, localStringBuilder.toString());
    i = this.val$err;
    switch (i)
    {
    default: 
      return;
    }
    TXCKeyPointReportProxy.b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.125
 * JD-Core Version:    0.7.0.1
 */