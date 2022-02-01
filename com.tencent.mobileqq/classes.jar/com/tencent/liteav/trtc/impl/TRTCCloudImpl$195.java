package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.trtc.TRTCStatistics;
import java.util.ArrayList;

class TRTCCloudImpl$195
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$195(TRTCCloudImpl paramTRTCCloudImpl, TRTCStatistics paramTRTCStatistics, ArrayList paramArrayList) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    if (paramUserInfo.mainRender.render != null) {
      TRTCCloudImpl.access$11000(this.this$0, paramUserInfo.mainRender.render, paramUserInfo, this.val$statistics, this.val$remoteQualityArray);
    }
    if ((paramUserInfo.subRender.render != null) && (paramUserInfo.subRender.render.isRendering())) {
      TRTCCloudImpl.access$11000(this.this$0, paramUserInfo.subRender.render, paramUserInfo, this.val$statistics, this.val$remoteQualityArray);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.195
 * JD-Core Version:    0.7.0.1
 */