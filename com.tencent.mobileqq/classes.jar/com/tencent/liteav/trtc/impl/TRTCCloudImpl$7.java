package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.a.b;

class TRTCCloudImpl$7
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$7(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    this.this$0.stopRemoteRender(paramUserInfo);
    TXCAudioEngine.getInstance().stopRemoteAudio(String.valueOf(paramUserInfo.tinyID));
    if (paramUserInfo.mainRender.render != null) {
      paramUserInfo.mainRender.render.setVideoFrameListener(null, b.a);
    }
    if (paramUserInfo.subRender.render != null) {
      paramUserInfo.subRender.render.setVideoFrameListener(null, b.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.7
 * JD-Core Version:    0.7.0.1
 */