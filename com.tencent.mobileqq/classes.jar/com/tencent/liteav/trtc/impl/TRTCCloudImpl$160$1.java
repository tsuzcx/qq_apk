package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;

class TRTCCloudImpl$160$1
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$160$1(TRTCCloudImpl.160 param160) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    if (paramUserInfo.mainRender.render != null) {
      paramUserInfo.mainRender.render.resetPeriodFeelingStatistics();
    }
    if (paramUserInfo.subRender.render != null) {
      paramUserInfo.subRender.render.resetPeriodFeelingStatistics();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.160.1
 * JD-Core Version:    0.7.0.1
 */