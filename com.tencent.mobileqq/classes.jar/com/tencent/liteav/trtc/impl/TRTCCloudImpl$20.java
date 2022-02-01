package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.rtmp.ui.TXCloudVideoView;

class TRTCCloudImpl$20
  implements Runnable
{
  TRTCCloudImpl$20(TRTCCloudImpl paramTRTCCloudImpl, String paramString, TXCloudVideoView paramTXCloudVideoView) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.mRoomInfo.getUser(this.val$userId);
    Object localObject2 = Boolean.valueOf(true);
    if (localObject1 == null)
    {
      localObject1 = TRTCCloudImpl.access$2600(this.this$0, this.val$userId);
      ((TRTCRoomInfo.UserInfo)localObject1).mainRender.view = this.val$view;
      ((TRTCRoomInfo.UserInfo)localObject1).mainRender.startRenderView = ((Boolean)localObject2);
      this.this$0.mRoomInfo.addUserInfo(this.val$userId, (TRTCRoomInfo.UserInfo)localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(String.format("Remote-startRemoteView userID:%s (save view before user enter)", new Object[] { this.val$userId }));
      ((StringBuilder)localObject1).append(" self:");
      ((StringBuilder)localObject1).append(this.this$0.hashCode());
      localObject1 = ((StringBuilder)localObject1).toString();
      this.this$0.apiOnlineLog((String)localObject1);
      return;
    }
    Object localObject3 = this.val$view;
    if ((localObject3 != null) && (localObject3.equals(((TRTCRoomInfo.UserInfo)localObject1).mainRender.view)))
    {
      localObject1 = this.this$0;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startRemoteView user view is the same, ignore ");
      ((StringBuilder)localObject2).append(this.val$userId);
      ((TRTCCloudImpl)localObject1).apiLog(((StringBuilder)localObject2).toString());
      return;
    }
    int i;
    if (((TRTCRoomInfo.UserInfo)localObject1).mainRender.view != null) {
      i = 1;
    } else {
      i = 0;
    }
    ((TRTCRoomInfo.UserInfo)localObject1).mainRender.view = this.val$view;
    ((TRTCRoomInfo.UserInfo)localObject1).mainRender.startRenderView = ((Boolean)localObject2);
    if (((TRTCRoomInfo.UserInfo)localObject1).mainRender.tinyID == 0L)
    {
      localObject1 = this.this$0;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startRemoteView user tinyID is 0, ignore ");
      ((StringBuilder)localObject2).append(this.val$userId);
      ((TRTCCloudImpl)localObject1).apiLog(((StringBuilder)localObject2).toString());
      return;
    }
    this.this$0.setRenderView(this.val$userId, ((TRTCRoomInfo.UserInfo)localObject1).mainRender, this.val$view, ((TRTCRoomInfo.UserInfo)localObject1).debugMargin);
    localObject2 = new StringBuilder();
    localObject3 = this.val$userId;
    long l = ((TRTCRoomInfo.UserInfo)localObject1).tinyID;
    int k = ((TRTCRoomInfo.UserInfo)localObject1).streamType;
    TXCloudVideoView localTXCloudVideoView = this.val$view;
    if (localTXCloudVideoView != null) {
      j = localTXCloudVideoView.hashCode();
    } else {
      j = 0;
    }
    ((StringBuilder)localObject2).append(String.format("Remote-startRemoteView userID:%s tinyID:%d streamType:%d view:%d", new Object[] { localObject3, Long.valueOf(l), Integer.valueOf(k), Integer.valueOf(j) }));
    ((StringBuilder)localObject2).append(" self:");
    ((StringBuilder)localObject2).append(this.this$0.hashCode());
    localObject2 = ((StringBuilder)localObject2).toString();
    this.this$0.apiOnlineLog((String)localObject2);
    localObject2 = this.this$0;
    l = ((TRTCRoomInfo.UserInfo)localObject1).tinyID;
    int j = ((TRTCRoomInfo.UserInfo)localObject1).streamType;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("Start watching ");
    ((StringBuilder)localObject3).append(this.val$userId);
    TRTCCloudImpl.access$2700((TRTCCloudImpl)localObject2, String.valueOf(l), j, 0, ((StringBuilder)localObject3).toString());
    if ((i == 0) || (!((TRTCRoomInfo.UserInfo)localObject1).mainRender.render.isRendering())) {
      TRTCCloudImpl.access$2800(this.this$0, ((TRTCRoomInfo.UserInfo)localObject1).mainRender.render, ((TRTCRoomInfo.UserInfo)localObject1).streamType);
    }
    if (((TRTCRoomInfo.UserInfo)localObject1).mainRender.muteVideo == TRTCRoomInfo.TRTCRemoteMuteState.MUTE)
    {
      localObject2 = this.this$0;
      TRTCCloudImpl.access$2900((TRTCCloudImpl)localObject2, ((TRTCCloudImpl)localObject2).mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject1).tinyID, ((TRTCRoomInfo.UserInfo)localObject1).streamType, true);
    }
    else
    {
      localObject2 = this.this$0;
      TRTCCloudImpl.access$3000((TRTCCloudImpl)localObject2, ((TRTCCloudImpl)localObject2).mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject1).tinyID, ((TRTCRoomInfo.UserInfo)localObject1).streamType, true);
      TXCKeyPointReportProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 40021, 0L, ((TRTCRoomInfo.UserInfo)localObject1).streamType);
    }
    TXCEventRecorderProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 4015, 1L, -1L, "", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.20
 * JD-Core Version:    0.7.0.1
 */