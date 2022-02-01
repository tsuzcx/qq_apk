package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$105$2
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$105$2(TRTCCloudImpl.105 param105) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    paramString = paramUserInfo.mainRender.view;
    paramUserInfo = paramUserInfo.subRender.view;
    if ((paramString != null) || (paramUserInfo != null)) {
      this.this$1.this$0.runOnMainThread(new TRTCCloudImpl.105.2.1(this, paramString, paramUserInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.105.2
 * JD-Core Version:    0.7.0.1
 */