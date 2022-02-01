package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;

class TRTCCloudImpl$158$1
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$158$1(TRTCCloudImpl.158 param158) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    if (paramUserInfo.mainRender.render != null) {
      TRTCCloudImpl.access$8300(this.this$1.this$0, paramUserInfo.mainRender.render, paramUserInfo.mainRender.render.getConfig());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.158.1
 * JD-Core Version:    0.7.0.1
 */