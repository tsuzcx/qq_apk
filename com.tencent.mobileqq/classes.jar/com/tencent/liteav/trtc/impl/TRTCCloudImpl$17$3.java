package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.audio.a;
import com.tencent.liteav.basic.b.b;

class TRTCCloudImpl$17$3
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$17$3(TRTCCloudImpl.17 param17) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    this.this$1.this$0.stopRemoteRender(paramUserInfo);
    a.a().a(String.valueOf(paramUserInfo.tinyID), this.this$1.this$0.hashCode());
    if (paramUserInfo.mainRender.render != null) {
      paramUserInfo.mainRender.render.setVideoFrameListener(null, b.a);
    }
    if (paramUserInfo.subRender.render != null) {
      paramUserInfo.subRender.render.setVideoFrameListener(null, b.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.17.3
 * JD-Core Version:    0.7.0.1
 */