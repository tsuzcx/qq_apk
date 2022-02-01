package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.rtmp.ui.TXCloudVideoView;

class TRTCCloudImpl$17
  implements Runnable
{
  TRTCCloudImpl$17(TRTCCloudImpl paramTRTCCloudImpl, String paramString) {}
  
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
    this.this$0.apiLog(String.format("stopRemoteView userID:%s tinyID:%d streamType:%d", new Object[] { this.val$userId, Long.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), Integer.valueOf(((TRTCRoomInfo.UserInfo)localObject1).streamType) }));
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(String.format("stopRemoteView userID:%s", new Object[] { this.val$userId }));
    ((StringBuilder)localObject2).append(" self:");
    ((StringBuilder)localObject2).append(this.this$0.hashCode());
    Monitor.a(1, ((StringBuilder)localObject2).toString(), "", 0);
    TXCEventRecorderProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 4015, 0L, -1L, "", 0);
    TRTCCloudImpl.access$2800(this.this$0, (TRTCRoomInfo.UserInfo)localObject1, Boolean.valueOf(false));
    localObject2 = ((TRTCRoomInfo.UserInfo)localObject1).mainRender.view;
    this.this$0.runOnMainThread(new TRTCCloudImpl.17.1(this, (TXCloudVideoView)localObject2));
    ((TRTCRoomInfo.UserInfo)localObject1).mainRender.view = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.17
 * JD-Core Version:    0.7.0.1
 */