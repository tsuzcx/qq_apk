package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$26
  implements Runnable
{
  TRTCCloudImpl$26(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    this.this$0.apiOnlineLog("stopAllRemoteView");
    this.this$0.mRoomInfo.forEachUser(new TRTCCloudImpl.26.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.26
 * JD-Core Version:    0.7.0.1
 */