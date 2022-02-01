package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;
import java.util.HashMap;

class TRTCCloudImpl$91$1
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$91$1(TRTCCloudImpl.91 param91) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    if (paramString.equalsIgnoreCase(this.this$1.val$userId))
    {
      TRTCCloudImpl.RenderListenerAdapter localRenderListenerAdapter = (TRTCCloudImpl.RenderListenerAdapter)this.this$1.this$0.mRenderListenerMap.get(this.this$1.val$userId);
      if (localRenderListenerAdapter != null) {
        localRenderListenerAdapter.strTinyID = String.valueOf(paramUserInfo.tinyID);
      }
      if (this.this$1.val$listener != null) {
        paramString = this.this$1.this$0;
      } else {
        paramString = null;
      }
      if (paramUserInfo.mainRender.render != null) {
        paramUserInfo.mainRender.render.setVideoFrameListener(paramString, TRTCCloudImpl.access$8000(this.this$1.this$0, localRenderListenerAdapter.pixelFormat));
      }
      if (paramUserInfo.subRender.render != null) {
        paramUserInfo.subRender.render.setVideoFrameListener(paramString, TRTCCloudImpl.access$8000(this.this$1.this$0, localRenderListenerAdapter.pixelFormat));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.91.1
 * JD-Core Version:    0.7.0.1
 */