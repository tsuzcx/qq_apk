package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.rtmp.ui.TXCloudVideoView;

class TRTCCloudImpl$21
  implements Runnable
{
  TRTCCloudImpl$21(TRTCCloudImpl paramTRTCCloudImpl, String paramString) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.mRoomInfo.getUser(this.val$userId);
    if (localObject1 == null)
    {
      localObject1 = this.this$0;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("stopRemoteRender user is not exist ");
      ((StringBuilder)localObject2).append(this.val$userId);
      ((TRTCCloudImpl)localObject1).apiLog(((StringBuilder)localObject2).toString());
      return;
    }
    this.this$0.apiOnlineLog(String.format("stopRemoteView userID:%s tinyID:%d streamType:%d", new Object[] { this.val$userId, Long.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), Integer.valueOf(((TRTCRoomInfo.UserInfo)localObject1).streamType) }));
    TXCEventRecorderProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 4015, 0L, -1L, "", 0);
    TRTCCloudImpl.access$3100(this.this$0, (TRTCRoomInfo.UserInfo)localObject1, Boolean.valueOf(false));
    Object localObject2 = ((TRTCRoomInfo.UserInfo)localObject1).mainRender.view;
    this.this$0.runOnMainThread(new TRTCCloudImpl.21.1(this, (TXCloudVideoView)localObject2, (TRTCRoomInfo.UserInfo)localObject1));
    ((TRTCRoomInfo.UserInfo)localObject1).mainRender.view = null;
    ((TRTCRoomInfo.UserInfo)localObject1).mainRender.startRenderView = Boolean.valueOf(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.21
 * JD-Core Version:    0.7.0.1
 */