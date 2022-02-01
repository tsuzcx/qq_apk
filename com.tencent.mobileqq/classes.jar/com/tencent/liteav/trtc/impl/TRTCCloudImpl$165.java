package com.tencent.liteav.trtc.impl;

import android.os.Bundle;

class TRTCCloudImpl$165
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$165(TRTCCloudImpl paramTRTCCloudImpl, String paramString, int paramInt, Bundle paramBundle) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    if (this.val$tinyID.equalsIgnoreCase(String.valueOf(paramUserInfo.tinyID))) {
      this.this$0.notifyEvent(paramUserInfo.userID, this.val$event, this.val$param);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.165
 * JD-Core Version:    0.7.0.1
 */