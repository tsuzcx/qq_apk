package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.rtmp.ui.TXCloudVideoView;

class TRTCCloudImpl$18
  implements Runnable
{
  TRTCCloudImpl$18(TRTCCloudImpl paramTRTCCloudImpl, String paramString, TXCloudVideoView paramTXCloudVideoView) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.mRoomInfo.getUser(this.val$userId);
    if (localObject1 == null)
    {
      localObject1 = this.this$0;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startRemoteSubStreamView user is not exist save view");
      ((StringBuilder)localObject2).append(this.val$userId);
      ((TRTCCloudImpl)localObject1).apiLog(((StringBuilder)localObject2).toString());
      localObject1 = TRTCCloudImpl.access$2300(this.this$0, this.val$userId);
      ((TRTCRoomInfo.UserInfo)localObject1).subRender.view = this.val$view;
      this.this$0.mRoomInfo.addUserInfo(this.val$userId, (TRTCRoomInfo.UserInfo)localObject1);
      return;
    }
    Object localObject2 = this.val$view;
    if ((localObject2 != null) && (localObject2.equals(((TRTCRoomInfo.UserInfo)localObject1).subRender.view)))
    {
      localObject1 = this.this$0;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startRemoteSubStreamView user view is the same, ignore ");
      ((StringBuilder)localObject2).append(this.val$userId);
      ((TRTCCloudImpl)localObject1).apiLog(((StringBuilder)localObject2).toString());
      return;
    }
    int i;
    if (((TRTCRoomInfo.UserInfo)localObject1).subRender.view != null) {
      i = 1;
    } else {
      i = 0;
    }
    ((TRTCRoomInfo.UserInfo)localObject1).subRender.view = this.val$view;
    if (((TRTCRoomInfo.UserInfo)localObject1).subRender.tinyID == 0L)
    {
      localObject1 = this.this$0;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startRemoteSubStreamView user tinyID is 0, ignore ");
      ((StringBuilder)localObject2).append(this.val$userId);
      ((TRTCCloudImpl)localObject1).apiLog(((StringBuilder)localObject2).toString());
      return;
    }
    this.this$0.setRenderView(this.val$userId, ((TRTCRoomInfo.UserInfo)localObject1).subRender, this.val$view, ((TRTCRoomInfo.UserInfo)localObject1).debugMargin);
    localObject2 = this.this$0;
    Object localObject3 = this.val$userId;
    long l = ((TRTCRoomInfo.UserInfo)localObject1).tinyID;
    TXCloudVideoView localTXCloudVideoView = this.val$view;
    int j;
    if (localTXCloudVideoView != null) {
      j = localTXCloudVideoView.hashCode();
    } else {
      j = 0;
    }
    ((TRTCCloudImpl)localObject2).apiLog(String.format("startRemoteSubStreamView userID:%s tinyID:%d streamType:%d view:%d", new Object[] { localObject3, Long.valueOf(l), Integer.valueOf(7), Integer.valueOf(j) }));
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(String.format("startRemoteSubStreamView userID:%s", new Object[] { this.val$userId }));
    ((StringBuilder)localObject2).append(" self:");
    ((StringBuilder)localObject2).append(this.this$0.hashCode());
    Monitor.a(1, ((StringBuilder)localObject2).toString(), "", 0);
    localObject2 = this.this$0;
    l = ((TRTCRoomInfo.UserInfo)localObject1).tinyID;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("Start watching ");
    ((StringBuilder)localObject3).append(this.val$userId);
    TRTCCloudImpl.access$2400((TRTCCloudImpl)localObject2, String.valueOf(l), 7, 0, ((StringBuilder)localObject3).toString());
    TXCKeyPointReportProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 40021, 0L, 7);
    if ((i == 0) || (!((TRTCRoomInfo.UserInfo)localObject1).subRender.render.isRendering())) {
      TRTCCloudImpl.access$2500(this.this$0, ((TRTCRoomInfo.UserInfo)localObject1).subRender.render, 7);
    }
    if (!((TRTCRoomInfo.UserInfo)localObject1).subRender.muteVideo)
    {
      localObject2 = this.this$0;
      TRTCCloudImpl.access$2600((TRTCCloudImpl)localObject2, ((TRTCCloudImpl)localObject2).mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject1).tinyID, 7, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.18
 * JD-Core Version:    0.7.0.1
 */