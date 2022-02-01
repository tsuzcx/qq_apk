package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;

class TRTCCloudImpl$40
  implements Runnable
{
  TRTCCloudImpl$40(TRTCCloudImpl paramTRTCCloudImpl, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = this.this$0.mRoomInfo.getUser(this.val$userId);
    if (localObject == null) {
      return;
    }
    int i = this.val$streamType;
    if ((i != 0) && (i != 1)) {
      localObject = ((TRTCRoomInfo.UserInfo)localObject).subRender.render;
    } else {
      localObject = ((TRTCRoomInfo.UserInfo)localObject).mainRender.render;
    }
    if (localObject == null) {
      return;
    }
    i = this.val$mirrorType;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      ((TXCRenderAndDec)localObject).setRenderMirrorType(2);
      return;
    }
    ((TXCRenderAndDec)localObject).setRenderMirrorType(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.40
 * JD-Core Version:    0.7.0.1
 */