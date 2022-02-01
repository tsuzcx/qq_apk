package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;

class TRTCCloudImpl$173
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$173(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    if ((paramUserInfo.mainRender.render != null) && (paramUserInfo.mainRender.render.isRendering())) {
      paramUserInfo.mainRender.render.updateLoadInfo();
    }
    if ((paramUserInfo.subRender.render != null) && (paramUserInfo.subRender.render.isRendering())) {
      paramUserInfo.subRender.render.updateLoadInfo();
    }
    if (this.this$0.mDebugType != 0)
    {
      this.this$0.checkRemoteDashBoard(paramUserInfo.mainRender.view, paramUserInfo.mainRender.render, paramUserInfo);
      this.this$0.checkRemoteDashBoard(paramUserInfo.subRender.view, paramUserInfo.subRender.render, paramUserInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.173
 * JD-Core Version:    0.7.0.1
 */