package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$48
  implements Runnable
{
  TRTCCloudImpl$48(TRTCCloudImpl paramTRTCCloudImpl, String paramString, int paramInt) {}
  
  public void run()
  {
    TRTCRoomInfo.UserInfo localUserInfo = this.this$0.mRoomInfo.getUser(this.val$userId);
    if (localUserInfo == null) {
      return;
    }
    int i;
    if (this.val$type == 1) {
      i = 3;
    } else {
      i = 2;
    }
    if (localUserInfo.streamType == i) {
      return;
    }
    localUserInfo.streamType = i;
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRemoteVideoStreamType ");
    localStringBuilder.append(this.val$userId);
    localStringBuilder.append(", ");
    localStringBuilder.append(i);
    localStringBuilder.append(", ");
    localStringBuilder.append(localUserInfo.tinyID);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    localTRTCCloudImpl = this.this$0;
    TRTCCloudImpl.access$2600(localTRTCCloudImpl, localTRTCCloudImpl.mNativeRtcContext, localUserInfo.tinyID, i, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.48
 * JD-Core Version:    0.7.0.1
 */