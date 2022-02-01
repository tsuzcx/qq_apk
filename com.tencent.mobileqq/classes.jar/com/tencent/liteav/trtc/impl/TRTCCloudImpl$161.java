package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$161
  implements Runnable
{
  TRTCCloudImpl$161(TRTCCloudImpl paramTRTCCloudImpl, TRTCVideoServerConfig paramTRTCVideoServerConfig) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRecvVideoServerConfig ");
    localStringBuilder.append(this.val$videoConfig);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    TRTCCloudImpl.access$8502(this.this$0, this.val$videoConfig);
    TRTCVideoServerConfig.saveToSharedPreferences(this.this$0.mContext, this.val$videoConfig);
    this.this$0.mRoomInfo.forEachUser(new TRTCCloudImpl.161.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.161
 * JD-Core Version:    0.7.0.1
 */