package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;

class TRTCCloudImpl$179$1
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$179$1(TRTCCloudImpl.179 param179) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    paramString = paramUserInfo.mainRender.render;
    if (paramString != null) {
      paramString.enableLimitDecCache(TRTCCloudImpl.access$10200(this.this$1.this$0).enableHWVUI);
    }
    paramString = paramUserInfo.subRender.render;
    if (paramString != null) {
      paramString.enableLimitDecCache(TRTCCloudImpl.access$10200(this.this$1.this$0).enableHWVUI);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.179.1
 * JD-Core Version:    0.7.0.1
 */