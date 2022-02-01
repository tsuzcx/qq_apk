package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCAudioEngine;

class TRTCCloudImpl$54
  implements Runnable
{
  TRTCCloudImpl$54(TRTCCloudImpl paramTRTCCloudImpl, int paramInt, String paramString) {}
  
  public void run()
  {
    int j = this.val$volume;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    j = i;
    if (i > 100) {
      j = 100;
    }
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRemoteAudioVolume: userId = ");
    localStringBuilder.append(this.val$userId);
    localStringBuilder.append(" volume = ");
    localStringBuilder.append(j);
    ((TRTCCloudImpl)localObject).apiLog(localStringBuilder.toString());
    localObject = this.this$0.mRoomInfo.getUser(this.val$userId);
    if (localObject != null) {
      TXCAudioEngine.getInstance().setRemotePlayoutVolume(String.valueOf(((TRTCRoomInfo.UserInfo)localObject).tinyID), j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.54
 * JD-Core Version:    0.7.0.1
 */