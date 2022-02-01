package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$22$1
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$22$1(TRTCCloudImpl.22 param22) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    TRTCCloudImpl.access$2800(this.this$1.this$0, paramUserInfo, Boolean.valueOf(true));
    TRTCCloudImpl.access$2900(this.this$1.this$0, paramUserInfo);
    paramUserInfo.mainRender.view = null;
    paramUserInfo.subRender.view = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.22.1
 * JD-Core Version:    0.7.0.1
 */