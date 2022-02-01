package com.tencent.ilive.audiencepages.room.bizmodule;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.ilive.audiencepages.room.events.PlayerCatonEvent;
import com.tencent.ilive.audiencepages.room.events.PlayerStateEvent;
import com.tencent.ilive.audiencepages.room.events.PlayerStateEvent.PlayerState;
import com.tencent.ilive.audiencepages.room.events.PlayerStateMessageEvent;
import com.tencent.ilive.audiencepages.room.events.ShowAnchorStateEvent;
import com.tencent.ilive.audiencepages.room.events.ShowAnchorStateEvent.AnchorState;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.base.event.ModuleEventInterface;
import com.tencent.ilive.pages.room.events.LiveStateEvent;
import com.tencent.ilive.pages.room.events.LiveStateEvent.LiveState;
import com.tencent.ilive.pages.room.events.PlayOverEvent;
import com.tencent.ilive.pages.room.events.PlayOverEvent.Source;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.ilivesdk.avplayerservice_interface.PlayerStatusListener;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveWatchMediaInfo;
import com.tencent.livesdk.roomengine.RoomEnginLogic;
import com.tencent.livesdk.roomengine.RoomEngine;

class AVPreloadPlayerModule$DefaultPlayerStatusListener
  implements PlayerStatusListener
{
  AVPreloadPlayerModule$DefaultPlayerStatusListener(AVPreloadPlayerModule paramAVPreloadPlayerModule) {}
  
  void a()
  {
    AVPreloadPlayerModule.j(this.a);
  }
  
  public void onError(int paramInt, String paramString)
  {
    LogInterface localLogInterface = this.a.getLog();
    String str = AVPreloadPlayerModule.b(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("error code:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg:");
    localStringBuilder.append(paramString);
    localLogInterface.e(str, localStringBuilder.toString(), new Object[0]);
    if (this.a.getEvent() != null)
    {
      paramString = new PlayerStateEvent(PlayerStateEvent.PlayerState.PLAY_ERROR);
      paramString.errCode = paramInt;
      this.a.getEvent().post(paramString);
    }
    if (!AVPreloadPlayerModule.e(this.a)) {
      AVPreloadPlayerModule.a(this.a, paramInt);
    }
  }
  
  public void onFirstFrameCome()
  {
    this.a.getLog().i(AVPreloadPlayerModule.b(this.a), "Player -- onFirstFrameCome", new Object[0]);
    AVPreloadPlayerModule.d(this.a);
  }
  
  public void onNetworkAnomaly()
  {
    if (this.a.getEvent() != null) {
      this.a.getEvent().post(new LiveStateEvent(LiveStateEvent.LiveState.NETWORK_ANOMALY));
    }
  }
  
  public void onNetworkChanged(int paramInt)
  {
    if (paramInt == 100)
    {
      this.a.getLog().i(AVPreloadPlayerModule.b(this.a), "netWork closed.", new Object[0]);
      if ((AVPreloadPlayerModule.a(this.a).isPlaying()) && (!AVPreloadPlayerModule.a(this.a).isPaused()))
      {
        AVPreloadPlayerModule.a(this.a).stopPlay();
        AVPreloadPlayerModule.a(this.a).resetPlayer();
      }
      AVPreloadPlayerModule.h(this.a).showToast("当前没有网络连接", 1);
      return;
    }
    LogInterface localLogInterface = this.a.getLog();
    String str = AVPreloadPlayerModule.b(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("netWork restore type = ");
    localStringBuilder.append(paramInt);
    localLogInterface.i(str, localStringBuilder.toString(), new Object[0]);
    a();
  }
  
  public void onPlayCaton()
  {
    if (AVPreloadPlayerModule.g(this.a))
    {
      this.a.getEvent().post(new PlayerCatonEvent());
      return;
    }
    AVPreloadPlayerModule.h(this.a).showToast("主播网络异常", 0);
  }
  
  public void onPlayCatonRecover() {}
  
  public void onPlayCompleted()
  {
    if (this.a.getEvent() != null) {
      this.a.getEvent().post(new PlayerStateEvent(PlayerStateEvent.PlayerState.PLAY_COMPLETED));
    }
  }
  
  public void onPlayPause(long paramLong)
  {
    if ((AVPreloadPlayerModule.f(this.a) != null) && (((RoomServiceInterface)AVPreloadPlayerModule.f(this.a).getService(RoomServiceInterface.class)).getLiveInfo() != null) && (((RoomServiceInterface)AVPreloadPlayerModule.f(this.a).getService(RoomServiceInterface.class)).getLiveInfo().anchorInfo != null) && (((RoomServiceInterface)AVPreloadPlayerModule.f(this.a).getService(RoomServiceInterface.class)).getLiveInfo().anchorInfo.uid != paramLong))
    {
      this.a.getEvent().post(new ShowAnchorStateEvent(ShowAnchorStateEvent.AnchorState.PAUSE, paramLong));
      return;
    }
    this.a.getEvent().post(new ShowAnchorStateEvent(ShowAnchorStateEvent.AnchorState.PAUSE, paramLong));
    PlayerStateMessageEvent localPlayerStateMessageEvent = new PlayerStateMessageEvent();
    localPlayerStateMessageEvent.msginfo = "主播暂时离开，马上回来，不要走开哦！";
    this.a.getEvent().post(localPlayerStateMessageEvent);
    AVPreloadPlayerModule.a(this.a).stopPlay();
    AVPreloadPlayerModule.a(this.a).resetPlayer();
    AVPreloadPlayerModule.d(this.a, false);
  }
  
  public void onPlayResume(long paramLong)
  {
    if ((AVPreloadPlayerModule.f(this.a) != null) && (((RoomServiceInterface)AVPreloadPlayerModule.f(this.a).getService(RoomServiceInterface.class)).getLiveInfo() != null) && (((RoomServiceInterface)AVPreloadPlayerModule.f(this.a).getService(RoomServiceInterface.class)).getLiveInfo().anchorInfo != null) && (((RoomServiceInterface)AVPreloadPlayerModule.f(this.a).getService(RoomServiceInterface.class)).getLiveInfo().anchorInfo.uid != paramLong))
    {
      this.a.getEvent().post(new ShowAnchorStateEvent(ShowAnchorStateEvent.AnchorState.RECOVER, paramLong));
      return;
    }
    this.a.getEvent().post(new ShowAnchorStateEvent(ShowAnchorStateEvent.AnchorState.RECOVER, paramLong));
    Object localObject = new PlayerStateMessageEvent();
    ((PlayerStateMessageEvent)localObject).msginfo = "主播回来了，精彩马上继续！";
    this.a.getEvent().post((ModuleEventInterface)localObject);
    localObject = AVPreloadPlayerModule.f(this.a).getEnginLogic().getLiveInfo().watchMediaInfo;
    if (AVPreloadPlayerModule.i(this.a))
    {
      AVPreloadPlayerModule.a(this.a).stopPlay();
      AVPreloadPlayerModule.a(this.a).resetPlayer();
    }
    AVPreloadPlayerModule.d(this.a, false);
    AVPreloadPlayerModule.a(this.a, (LiveWatchMediaInfo)localObject);
  }
  
  public void onPreloadFirstFrame(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    if ((!AVPreloadPlayerModule.l(this.a)) && (paramAVPreloadTaskInterface.x() != null))
    {
      AVPreloadPlayerModule.a(this.a, paramAVPreloadTaskInterface);
      AVPreloadPlayerModule.f(this.a, true);
    }
  }
  
  public void onPushPlayOver()
  {
    if (this.a.getEvent() != null) {
      this.a.getEvent().post(new PlayOverEvent("", PlayOverEvent.Source.AUDIENCE_PUSH));
    }
  }
  
  public void onReadyCompleted()
  {
    this.a.getLog().i(AVPreloadPlayerModule.b(this.a), "Player -- onReadyCompleted", new Object[0]);
    this.a.getLog().i("AudienceTime", "Player -- onReadyCompleted", new Object[0]);
    if (AVPreloadPlayerModule.c(this.a))
    {
      this.a.getLog().e(AVPreloadPlayerModule.b(this.a), "Player -- onReadyCompleted but isPageExit", new Object[0]);
      return;
    }
    AVPreloadPlayerModule.a(this.a, AVPreloadPlayerModule.StartPlayType.READY_PLAY);
    if (this.a.getEvent() != null) {
      this.a.getEvent().post(new PlayerStateEvent(PlayerStateEvent.PlayerState.PREPARE_READY));
    }
  }
  
  public void onStartBuffer()
  {
    if (this.a.getEvent() != null) {
      this.a.getEvent().post(new LiveStateEvent(LiveStateEvent.LiveState.START_BUFFER_INNER));
    }
  }
  
  public void onStopBuffer()
  {
    if (this.a.getEvent() != null) {
      this.a.getEvent().post(new PlayerStateEvent(PlayerStateEvent.PlayerState.STOP_BUFFER));
    }
  }
  
  public void onSurfaceCreated()
  {
    this.a.getLog().i(AVPreloadPlayerModule.b(this.a), "Player -- onSurfaceCreated", new Object[0]);
    this.a.getLog().i("AudienceTime", "Player -- onSurfaceCreated", new Object[0]);
    if (AVPreloadPlayerModule.c(this.a))
    {
      this.a.getLog().e(AVPreloadPlayerModule.b(this.a), "Player -- onSurfaceCreated but isPageExit", new Object[0]);
      return;
    }
    if (!AVPreloadPlayerModule.k(this.a)) {
      AVPreloadPlayerModule.a(this.a, AVPreloadPlayerModule.StartPlayType.SURFACE_CREATE);
    }
    AVPreloadPlayerModule.e(this.a, true);
  }
  
  public void onSurfaceDestroyed() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.AVPreloadPlayerModule.DefaultPlayerStatusListener
 * JD-Core Version:    0.7.0.1
 */