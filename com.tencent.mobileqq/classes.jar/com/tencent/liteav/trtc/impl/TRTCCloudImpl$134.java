package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.o;
import com.tencent.trtc.TRTCCloudListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class TRTCCloudImpl$134
  implements Runnable
{
  TRTCCloudImpl$134(TRTCCloudImpl paramTRTCCloudImpl, WeakReference paramWeakReference, String paramString, long paramLong, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.this$0.mRoomState == 0)
    {
      this.this$0.apiLog("ignore onAVMemberEnter when out room.");
      return;
    }
    if ((TRTCCloudImpl)this.val$weakSelf.get() == null) {
      return;
    }
    Object localObject2 = this.this$0.mRoomInfo.getUser(this.val$userID);
    if (localObject2 != null)
    {
      localObject1 = this.this$0;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(" user ");
      ((StringBuilder)localObject3).append(this.val$userID);
      ((StringBuilder)localObject3).append("enter room when user is in room ");
      ((StringBuilder)localObject3).append(this.val$tinyID);
      ((TRTCCloudImpl)localObject1).apiLog(((StringBuilder)localObject3).toString());
    }
    Object localObject3 = String.valueOf(this.val$tinyID);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = TRTCCloudImpl.access$2300(this.this$0, this.val$userID);
    }
    TXCAudioEngine.getInstance().setRemoteAudioStreamEventListener((String)localObject3, this.this$0);
    if (this.this$0.mAudioFrameListener != null) {
      TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener((String)localObject3, this.this$0);
    }
    TXCAudioEngine.getInstance().startRemoteAudio((String)localObject3, true);
    TXCAudioEngine.getInstance().muteRemoteAudio((String)localObject3, ((TRTCRoomInfo.UserInfo)localObject1).mainRender.muteAudio);
    TXCAudioEngine.getInstance().muteRemoteAudioInSpeaker((String)localObject3, ((TRTCRoomInfo.UserInfo)localObject1).muteAudioInSpeaker);
    if (((TRTCRoomInfo.UserInfo)localObject1).mainRender.muteAudio)
    {
      localObject2 = this.this$0;
      TRTCCloudImpl.access$2700((TRTCCloudImpl)localObject2, ((TRTCCloudImpl)localObject2).mNativeRtcContext, this.val$tinyID, 1, true);
    }
    localObject2 = this.this$0;
    localObject2 = TRTCCloudImpl.access$7900((TRTCCloudImpl)localObject2, this.val$tinyID, ((TRTCCloudImpl)localObject2).mPriorStreamType);
    TRTCCloudImpl.RenderListenerAdapter localRenderListenerAdapter = (TRTCCloudImpl.RenderListenerAdapter)this.this$0.mRenderListenerMap.get(this.val$userID);
    if (localRenderListenerAdapter != null)
    {
      localRenderListenerAdapter.strTinyID = ((String)localObject3);
      if (localRenderListenerAdapter.listener != null)
      {
        localObject3 = this.this$0;
        ((TXCRenderAndDec)localObject2).setVideoFrameListener((o)localObject3, TRTCCloudImpl.access$6400((TRTCCloudImpl)localObject3, localRenderListenerAdapter.pixelFormat));
      }
    }
    ((TRTCRoomInfo.UserInfo)localObject1).tinyID = this.val$tinyID;
    ((TRTCRoomInfo.UserInfo)localObject1).userID = this.val$userID;
    ((TRTCRoomInfo.UserInfo)localObject1).terminalType = this.val$terminalType;
    ((TRTCRoomInfo.UserInfo)localObject1).streamState = this.val$videoState;
    ((TRTCRoomInfo.UserInfo)localObject1).mainRender.render = ((TXCRenderAndDec)localObject2);
    ((TRTCRoomInfo.UserInfo)localObject1).mainRender.tinyID = this.val$tinyID;
    ((TRTCRoomInfo.UserInfo)localObject1).streamType = this.this$0.mPriorStreamType;
    long l;
    if (((TRTCRoomInfo.UserInfo)localObject1).mainRender.view != null)
    {
      this.this$0.setRenderView(this.val$userID, ((TRTCRoomInfo.UserInfo)localObject1).mainRender, ((TRTCRoomInfo.UserInfo)localObject1).mainRender.view, ((TRTCRoomInfo.UserInfo)localObject1).debugMargin);
      this.this$0.apiLog(String.format("startRemoteView when user enter userID:%s tinyID:%d streamType:%d", new Object[] { this.val$userID, Long.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), Integer.valueOf(((TRTCRoomInfo.UserInfo)localObject1).streamType) }));
      localObject2 = this.this$0;
      l = ((TRTCRoomInfo.UserInfo)localObject1).tinyID;
      int i = ((TRTCRoomInfo.UserInfo)localObject1).streamType;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Start watching ");
      ((StringBuilder)localObject3).append(this.val$userID);
      TRTCCloudImpl.access$2400((TRTCCloudImpl)localObject2, String.valueOf(l), i, 0, ((StringBuilder)localObject3).toString());
      TRTCCloudImpl.access$2500(this.this$0, ((TRTCRoomInfo.UserInfo)localObject1).mainRender.render, ((TRTCRoomInfo.UserInfo)localObject1).streamType);
      TXCKeyPointReportProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 40021, 0L, ((TRTCRoomInfo.UserInfo)localObject1).streamType);
      if (!((TRTCRoomInfo.UserInfo)localObject1).mainRender.muteVideo)
      {
        localObject2 = this.this$0;
        TRTCCloudImpl.access$2600((TRTCCloudImpl)localObject2, ((TRTCCloudImpl)localObject2).mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject1).tinyID, ((TRTCRoomInfo.UserInfo)localObject1).streamType, true);
      }
      else
      {
        localObject2 = this.this$0;
        TRTCCloudImpl.access$2700((TRTCCloudImpl)localObject2, ((TRTCCloudImpl)localObject2).mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject1).tinyID, ((TRTCRoomInfo.UserInfo)localObject1).streamType, true);
      }
    }
    localObject2 = TRTCCloudImpl.access$7900(this.this$0, this.val$tinyID, 7);
    ((TRTCRoomInfo.UserInfo)localObject1).subRender.render = ((TXCRenderAndDec)localObject2);
    ((TRTCRoomInfo.UserInfo)localObject1).subRender.tinyID = this.val$tinyID;
    ((TRTCRoomInfo.UserInfo)localObject1).subRender.muteVideo = this.this$0.mRoomInfo.muteRemoteVideo;
    if (((TRTCRoomInfo.UserInfo)localObject1).subRender.view != null)
    {
      this.this$0.setRenderView(this.val$userID, ((TRTCRoomInfo.UserInfo)localObject1).subRender, ((TRTCRoomInfo.UserInfo)localObject1).subRender.view, ((TRTCRoomInfo.UserInfo)localObject1).debugMargin);
      this.this$0.apiLog(String.format("onUserScreenAvailable when user enter userID:%s tinyID:%d streamType:%d", new Object[] { this.val$userID, Long.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), Integer.valueOf(7) }));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(String.format("startRemoteSubStreamView userID:%s", new Object[] { this.val$userID }));
      ((StringBuilder)localObject2).append(" self:");
      ((StringBuilder)localObject2).append(this.this$0.hashCode());
      Monitor.a(1, ((StringBuilder)localObject2).toString(), "", 0);
      localObject2 = this.this$0;
      l = ((TRTCRoomInfo.UserInfo)localObject1).tinyID;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Start watching ");
      ((StringBuilder)localObject3).append(this.val$userID);
      TRTCCloudImpl.access$2400((TRTCCloudImpl)localObject2, String.valueOf(l), 7, 0, ((StringBuilder)localObject3).toString());
      TRTCCloudImpl.access$2500(this.this$0, ((TRTCRoomInfo.UserInfo)localObject1).subRender.render, 7);
      TXCKeyPointReportProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 40021, 0L, 7);
      if (!((TRTCRoomInfo.UserInfo)localObject1).subRender.muteVideo)
      {
        localObject2 = this.this$0;
        TRTCCloudImpl.access$2600((TRTCCloudImpl)localObject2, ((TRTCCloudImpl)localObject2).mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject1).tinyID, 7, true);
      }
    }
    this.this$0.mRoomInfo.addUserInfo(this.val$userID, (TRTCRoomInfo.UserInfo)localObject1);
    localObject1 = this.this$0;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onAVMemberEnter ");
    ((StringBuilder)localObject2).append(this.val$tinyID);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(this.val$userID);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(this.val$videoState);
    ((TRTCCloudImpl)localObject1).apiLog(((StringBuilder)localObject2).toString());
    localObject1 = this.this$0.mTRTCListener;
    this.this$0.runOnListenerThread(new TRTCCloudImpl.134.1(this, (TRTCCloudListener)localObject1));
    boolean bool;
    if ((TRTCRoomInfo.hasAudio(this.val$videoState)) && (!TRTCRoomInfo.isMuteAudio(this.val$videoState))) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      this.this$0.runOnListenerThread(new TRTCCloudImpl.134.2(this, (TRTCCloudListener)localObject1, bool));
      localObject2 = this.this$0;
      TRTCCloudImpl.access$8000((TRTCCloudImpl)localObject2, ((TRTCCloudImpl)localObject2).mRoomInfo.getUserId(), 0, String.format("[%s]audio Available[true]", new Object[] { this.val$userID }));
    }
    if (((TRTCRoomInfo.hasMainVideo(this.val$videoState)) || (TRTCRoomInfo.hasSmallVideo(this.val$videoState))) && (!TRTCRoomInfo.isMuteMainVideo(this.val$videoState))) {
      bool = true;
    } else {
      bool = false;
    }
    if ((bool) && (this.this$0.mRoomInfo.hasRecvFirstIFrame(this.val$tinyID)))
    {
      this.this$0.runOnListenerThread(new TRTCCloudImpl.134.3(this, bool, (TRTCCloudListener)localObject1));
      localObject2 = this.this$0;
      TRTCCloudImpl.access$8000((TRTCCloudImpl)localObject2, ((TRTCCloudImpl)localObject2).mRoomInfo.getUserId(), 0, String.format("[%s]video Available[true]", new Object[] { this.val$userID }));
    }
    if ((TRTCRoomInfo.hasSubVideo(this.val$videoState)) && (!TRTCRoomInfo.isMuteSubVideo(this.val$videoState))) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      this.this$0.runOnListenerThread(new TRTCCloudImpl.134.4(this, (TRTCCloudListener)localObject1, bool));
      localObject1 = this.this$0;
      TRTCCloudImpl.access$8000((TRTCCloudImpl)localObject1, ((TRTCCloudImpl)localObject1).mRoomInfo.getUserId(), 0, String.format("[%s]subvideo Available[true]", new Object[] { this.val$userID }));
    }
    localObject1 = this.this$0;
    TRTCCloudImpl.access$7600((TRTCCloudImpl)localObject1, ((TRTCCloudImpl)localObject1).mRoomInfo.getUserId(), 0, String.format("[%s]enter room", new Object[] { this.val$userID }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.134
 * JD-Core Version:    0.7.0.1
 */