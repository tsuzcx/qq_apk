package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;

class TRTCCloudImpl$149$1
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$149$1(TRTCCloudImpl.149 param149) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    if ((this.this$1.val$stream != 1) && (this.this$1.val$tinyID == paramUserInfo.tinyID))
    {
      paramString = this.this$1.this$0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRequestDownStream ");
      localStringBuilder.append(paramUserInfo.tinyID);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramUserInfo.userID);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.this$1.val$stream);
      paramString.apiLog(localStringBuilder.toString());
      if (this.this$1.val$stream == 7)
      {
        if ((paramUserInfo.subRender.render != null) && (paramUserInfo.subRender.render.getStreamType() != this.this$1.val$stream))
        {
          paramUserInfo.subRender.render.stopVideo();
          paramUserInfo.subRender.render.setStreamType(this.this$1.val$stream);
          paramUserInfo.subRender.render.startVideo();
        }
      }
      else if ((paramUserInfo.mainRender.render != null) && (paramUserInfo.mainRender.render.getStreamType() != this.this$1.val$stream))
      {
        paramUserInfo.mainRender.render.stopVideo();
        paramUserInfo.mainRender.render.setStreamType(this.this$1.val$stream);
        paramUserInfo.mainRender.render.startVideo();
        TXCKeyPointReportProxy.a(String.valueOf(paramUserInfo.tinyID), 40038, 0L, this.this$1.val$stream);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.149.1
 * JD-Core Version:    0.7.0.1
 */