package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;

class TRTCCloudImpl$142$1
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$142$1(TRTCCloudImpl.142 param142) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    if (paramUserInfo.mainRender.render != null) {
      paramUserInfo.mainRender.render.setBlockInterval(this.this$1.val$videoBlockThreshold);
    }
    if (paramUserInfo.subRender.render != null) {
      paramUserInfo.subRender.render.setBlockInterval(this.this$1.val$videoBlockThreshold);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.142.1
 * JD-Core Version:    0.7.0.1
 */