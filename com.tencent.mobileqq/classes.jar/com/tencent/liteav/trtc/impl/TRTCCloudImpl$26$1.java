package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$26$1
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$26$1(TRTCCloudImpl.26 param26) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    TRTCCloudImpl.access$3100(this.this$1.this$0, paramUserInfo, Boolean.valueOf(true));
    TRTCCloudImpl.access$3200(this.this$1.this$0, paramUserInfo);
    paramUserInfo.mainRender.view = null;
    paramString = paramUserInfo.mainRender;
    Boolean localBoolean = Boolean.valueOf(false);
    paramString.startRenderView = localBoolean;
    paramUserInfo.subRender.view = null;
    paramUserInfo.subRender.startRenderView = localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.26.1
 * JD-Core Version:    0.7.0.1
 */