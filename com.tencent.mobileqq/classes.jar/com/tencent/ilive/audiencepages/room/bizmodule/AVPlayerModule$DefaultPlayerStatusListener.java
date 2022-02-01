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
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.events.LiveStateEvent;
import com.tencent.ilive.pages.room.events.LiveStateEvent.LiveState;
import com.tencent.ilive.pages.room.events.PlayOverEvent;
import com.tencent.ilive.pages.room.events.PlayOverEvent.Source;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.ilivesdk.avplayerservice_interface.PlayerStatusListener;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveWatchMediaInfo;
import com.tencent.livesdk.roomengine.RoomEnginLogic;
import com.tencent.livesdk.roomengine.RoomEngine;

class AVPlayerModule$DefaultPlayerStatusListener
  implements PlayerStatusListener
{
  AVPlayerModule$DefaultPlayerStatusListener(AVPlayerModule paramAVPlayerModule) {}
  
  public void onError(int paramInt, String paramString)
  {
    this.this$0.getLog().e(AVPlayerModule.access$400(this.this$0), "error code:" + paramInt + " msg:" + paramString, new Object[0]);
    if (this.this$0.getEvent() != null)
    {
      paramString = new PlayerStateEvent(PlayerStateEvent.PlayerState.PLAY_ERROR);
      paramString.errCode = paramInt;
      this.this$0.getEvent().post(paramString);
    }
    if (!AVPlayerModule.access$200(this.this$0)) {
      AVPlayerModule.access$900(this.this$0, paramInt);
    }
  }
  
  public void onFirstFrameCome()
  {
    this.this$0.getLog().i(AVPlayerModule.access$400(this.this$0), "Player -- onFirstFrameCome", new Object[0]);
    AVPlayerModule.access$800(this.this$0);
  }
  
  public void onNetworkAnomaly()
  {
    if (this.this$0.getEvent() != null) {
      this.this$0.getEvent().post(new LiveStateEvent(LiveStateEvent.LiveState.NETWORK_ANOMALY));
    }
  }
  
  public void onNetworkChanged(int paramInt)
  {
    if (paramInt == 100)
    {
      this.this$0.getLog().i(AVPlayerModule.access$400(this.this$0), "netWork closed.", new Object[0]);
      if ((AVPlayerModule.access$000(this.this$0).isPlaying()) && (!AVPlayerModule.access$000(this.this$0).isPaused()))
      {
        AVPlayerModule.access$000(this.this$0).stopPlay();
        AVPlayerModule.access$000(this.this$0).resetPlayer();
      }
      AVPlayerModule.access$1100(this.this$0).showToast("当前没有网络连接", 1);
    }
    for (;;)
    {
      return;
      this.this$0.getLog().i(AVPlayerModule.access$400(this.this$0), "netWork restore type = " + paramInt, new Object[0]);
      Object localObject2 = null;
      Object localObject1;
      if ((AVPlayerModule.access$1000(this.this$0) != null) && (AVPlayerModule.access$1000(this.this$0).getEnginLogic() != null) && (AVPlayerModule.access$1000(this.this$0).getEnginLogic().getLiveInfo() != null)) {
        localObject1 = AVPlayerModule.access$1000(this.this$0).getEnginLogic().getLiveInfo().watchMediaInfo;
      }
      while (localObject1 != null)
      {
        AVPlayerModule.access$1300(this.this$0, (LiveWatchMediaInfo)localObject1);
        return;
        localObject1 = localObject2;
        if (AVPlayerModule.access$1400(this.this$0) != null)
        {
          localObject1 = localObject2;
          if (AVPlayerModule.access$1500(this.this$0).getEnterRoomInfo() != null)
          {
            localObject1 = new LiveWatchMediaInfo();
            ((LiveWatchMediaInfo)localObject1).first_play_url = AVPlayerModule.access$1600(this.this$0).getEnterRoomInfo().preVideoUrl;
          }
        }
      }
    }
  }
  
  public void onPlayCaton()
  {
    if (AVPlayerModule.access$300(this.this$0))
    {
      this.this$0.getEvent().post(new PlayerCatonEvent());
      return;
    }
    AVPlayerModule.access$1100(this.this$0).showToast("主播网络异常", 0);
  }
  
  public void onPlayCatonRecover() {}
  
  public void onPlayCompleted()
  {
    if (this.this$0.getEvent() != null) {
      this.this$0.getEvent().post(new PlayerStateEvent(PlayerStateEvent.PlayerState.PLAY_COMPLETED));
    }
  }
  
  public void onPlayPause(long paramLong)
  {
    if ((AVPlayerModule.access$1000(this.this$0) != null) && (((RoomServiceInterface)AVPlayerModule.access$1000(this.this$0).getService(RoomServiceInterface.class)).getLiveInfo() != null) && (((RoomServiceInterface)AVPlayerModule.access$1000(this.this$0).getService(RoomServiceInterface.class)).getLiveInfo().anchorInfo != null) && (((RoomServiceInterface)AVPlayerModule.access$1000(this.this$0).getService(RoomServiceInterface.class)).getLiveInfo().anchorInfo.uid != paramLong))
    {
      this.this$0.getEvent().post(new ShowAnchorStateEvent(ShowAnchorStateEvent.AnchorState.PAUSE, paramLong));
      return;
    }
    this.this$0.getEvent().post(new ShowAnchorStateEvent(ShowAnchorStateEvent.AnchorState.PAUSE, paramLong));
    new PlayerStateMessageEvent().msginfo = "主播暂时离开，马上回来，不要走开哦！";
    this.this$0.getEvent().post(new PlayerStateMessageEvent());
  }
  
  public void onPlayResume(long paramLong)
  {
    if ((AVPlayerModule.access$1000(this.this$0) != null) && (((RoomServiceInterface)AVPlayerModule.access$1000(this.this$0).getService(RoomServiceInterface.class)).getLiveInfo() != null) && (((RoomServiceInterface)AVPlayerModule.access$1000(this.this$0).getService(RoomServiceInterface.class)).getLiveInfo().anchorInfo != null) && (((RoomServiceInterface)AVPlayerModule.access$1000(this.this$0).getService(RoomServiceInterface.class)).getLiveInfo().anchorInfo.uid != paramLong))
    {
      this.this$0.getEvent().post(new ShowAnchorStateEvent(ShowAnchorStateEvent.AnchorState.RECOVER, paramLong));
      return;
    }
    this.this$0.getEvent().post(new ShowAnchorStateEvent(ShowAnchorStateEvent.AnchorState.RECOVER, paramLong));
    new PlayerStateMessageEvent().msginfo = "主播回来了，精彩马上继续！";
    this.this$0.getEvent().post(new PlayerStateMessageEvent());
    LiveWatchMediaInfo localLiveWatchMediaInfo = AVPlayerModule.access$1000(this.this$0).getEnginLogic().getLiveInfo().watchMediaInfo;
    if (AVPlayerModule.access$1200(this.this$0))
    {
      AVPlayerModule.access$000(this.this$0).stopPlay();
      AVPlayerModule.access$000(this.this$0).resetPlayer();
    }
    AVPlayerModule.access$1202(this.this$0, false);
    AVPlayerModule.access$1300(this.this$0, localLiveWatchMediaInfo);
  }
  
  public void onPreloadFirstFrame(AVPreloadTaskInterface paramAVPreloadTaskInterface) {}
  
  public void onPushPlayOver()
  {
    if (this.this$0.getEvent() != null) {
      this.this$0.getEvent().post(new PlayOverEvent("", PlayOverEvent.Source.AUDIENCE_PUSH));
    }
  }
  
  public void onReadyCompleted()
  {
    this.this$0.getLog().i(AVPlayerModule.access$400(this.this$0), "Player -- onReadyCompleted", new Object[0]);
    this.this$0.getLog().i("AudienceTime", "Player -- onReadyCompleted", new Object[0]);
    if (AVPlayerModule.access$600(this.this$0)) {
      this.this$0.getLog().e(AVPlayerModule.access$400(this.this$0), "Player -- onReadyCompleted but isPageExit", new Object[0]);
    }
    do
    {
      return;
      AVPlayerModule.access$700(this.this$0, AVPlayerModule.StartPlayType.READY_PLAY);
    } while (this.this$0.getEvent() == null);
    this.this$0.getEvent().post(new PlayerStateEvent(PlayerStateEvent.PlayerState.PREPARE_READY));
  }
  
  public void onStartBuffer()
  {
    if (this.this$0.getEvent() != null) {
      this.this$0.getEvent().post(new LiveStateEvent(LiveStateEvent.LiveState.START_BUFFER_INNER));
    }
  }
  
  public void onStopBuffer()
  {
    if (this.this$0.getEvent() != null) {
      this.this$0.getEvent().post(new PlayerStateEvent(PlayerStateEvent.PlayerState.STOP_BUFFER));
    }
  }
  
  public void onSurfaceCreated()
  {
    this.this$0.getLog().i(AVPlayerModule.access$400(this.this$0), "Player -- onSurfaceCreated", new Object[0]);
    this.this$0.getLog().i("AudienceTime", "Player -- onSurfaceCreated", new Object[0]);
    if (AVPlayerModule.access$600(this.this$0))
    {
      this.this$0.getLog().e(AVPlayerModule.access$400(this.this$0), "Player -- onSurfaceCreated but isPageExit", new Object[0]);
      return;
    }
    if (!AVPlayerModule.access$1700(this.this$0)) {
      AVPlayerModule.access$700(this.this$0, AVPlayerModule.StartPlayType.SURFACE_CREATE);
    }
    AVPlayerModule.access$1702(this.this$0, true);
  }
  
  public void onSurfaceDestroyed() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.AVPlayerModule.DefaultPlayerStatusListener
 * JD-Core Version:    0.7.0.1
 */