package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$114$2
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$114$2(TRTCCloudImpl.114 param114) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    paramString = paramUserInfo.mainRender.view;
    paramUserInfo = paramUserInfo.subRender.view;
    if ((paramString != null) || (paramUserInfo != null)) {
      this.this$1.this$0.runOnMainThread(new TRTCCloudImpl.114.2.1(this, paramString, paramUserInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.114.2
 * JD-Core Version:    0.7.0.1
 */