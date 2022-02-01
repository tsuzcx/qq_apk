package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.rtmp.ui.TXCloudVideoView;

class TRTCCloudImpl$22
  implements Runnable
{
  TRTCCloudImpl$22(TRTCCloudImpl paramTRTCCloudImpl, String paramString, TXCloudVideoView paramTXCloudVideoView) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.mRoomInfo.getUser(this.val$userId);
    Object localObject2 = Boolean.valueOf(true);
    if (localObject1 == null)
    {
      localObject1 = this.this$0;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("startRemoteSubStreamView user is not exist save view");
      ((StringBuilder)localObject3).append(this.val$userId);
      ((TRTCCloudImpl)localObject1).apiLog(((StringBuilder)localObject3).toString());
      localObject1 = TRTCCloudImpl.access$2600(this.this$0, this.val$userId);
      ((TRTCRoomInfo.UserInfo)localObject1).subRender.view = this.val$view;
      ((TRTCRoomInfo.UserInfo)localObject1).subRender.startRenderView = ((Boolean)localObject2);
      this.this$0.mRoomInfo.addUserInfo(this.val$userId, (TRTCRoomInfo.UserInfo)localObject1);
      return;
    }
    Object localObject3 = this.val$view;
    if ((localObject3 != null) && (localObject3.equals(((TRTCRoomInfo.UserInfo)localObject1).subRender.view)))
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
    ((TRTCRoomInfo.UserInfo)localObject1).subRender.startRenderView = ((Boolean)localObject2);
    if (((TRTCRoomInfo.UserInfo)localObject1).subRender.tinyID == 0L)
    {
      localObject1 = this.this$0;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startRemoteSubStreamView user tinyID is 0, ignore ");
      ((StringBuilder)localObject2).append(this.val$userId);
      ((TRTCCloudImpl)localObject1).apiLog(((StringBuilder)localObject2).toString());
      return;
    }
    TXCEventRecorderProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 4015, 1L, -1L, "", 7);
    this.this$0.setRenderView(this.val$userId, ((TRTCRoomInfo.UserInfo)localObject1).subRender, this.val$view, ((TRTCRoomInfo.UserInfo)localObject1).debugMargin);
    localObject2 = this.this$0;
    localObject3 = this.val$userId;
    long l = ((TRTCRoomInfo.UserInfo)localObject1).tinyID;
    TXCloudVideoView localTXCloudVideoView = this.val$view;
    int j;
    if (localTXCloudVideoView != null) {
      j = localTXCloudVideoView.hashCode();
    } else {
      j = 0;
    }
    ((TRTCCloudImpl)localObject2).apiOnlineLog(String.format("startRemoteSubStreamView userID:%s tinyID:%d streamType:%d view:%d", new Object[] { localObject3, Long.valueOf(l), Integer.valueOf(7), Integer.valueOf(j) }));
    localObject2 = this.this$0;
    l = ((TRTCRoomInfo.UserInfo)localObject1).tinyID;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("Start watching ");
    ((StringBuilder)localObject3).append(this.val$userId);
    TRTCCloudImpl.access$2700((TRTCCloudImpl)localObject2, String.valueOf(l), 7, 0, ((StringBuilder)localObject3).toString());
    if ((i == 0) || (!((TRTCRoomInfo.UserInfo)localObject1).subRender.render.isRendering())) {
      TRTCCloudImpl.access$2800(this.this$0, ((TRTCRoomInfo.UserInfo)localObject1).subRender.render, 7);
    }
    if (((TRTCRoomInfo.UserInfo)localObject1).subRender.muteVideo == TRTCRoomInfo.TRTCRemoteMuteState.MUTE)
    {
      localObject2 = this.this$0;
      TRTCCloudImpl.access$2900((TRTCCloudImpl)localObject2, ((TRTCCloudImpl)localObject2).mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject1).tinyID, 7, true);
      return;
    }
    localObject2 = this.this$0;
    TRTCCloudImpl.access$3000((TRTCCloudImpl)localObject2, ((TRTCCloudImpl)localObject2).mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject1).tinyID, 7, true);
    TXCKeyPointReportProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 40021, 0L, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.22
 * JD-Core Version:    0.7.0.1
 */