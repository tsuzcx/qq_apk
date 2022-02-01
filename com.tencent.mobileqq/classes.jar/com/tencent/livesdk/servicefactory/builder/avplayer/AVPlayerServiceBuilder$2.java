package com.tencent.livesdk.servicefactory.builder.avplayer;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.base.libapi.network.NetworkStateInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.ilivesdk.avmediaservice_interface.AVMediaServiceInterface;
import com.tencent.ilivesdk.avmediaservice_interface.MediaPlayerInterface;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceAdapter;
import com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class AVPlayerServiceBuilder$2
  implements AVPlayerServiceAdapter
{
  AVPlayerServiceBuilder$2(AVPlayerServiceBuilder paramAVPlayerServiceBuilder, ServiceAccessor paramServiceAccessor, RoomServiceInterface paramRoomServiceInterface) {}
  
  public PushReceiver createPushReceiver()
  {
    return ((RoomPushServiceInterface)this.val$serviceManager.getService(RoomPushServiceInterface.class)).createRoomPushReceiver();
  }
  
  public AVMediaServiceInterface getAVMediaService()
  {
    return (AVMediaServiceInterface)this.val$serviceManager.getService(AVMediaServiceInterface.class);
  }
  
  public LoginServiceInterface getAccount()
  {
    return (LoginServiceInterface)this.val$serviceManager.getService(LoginServiceInterface.class);
  }
  
  public long getAnchorUin()
  {
    if (this.val$roomServiceInterface.getLiveInfo() == null) {
      return 0L;
    }
    return this.val$roomServiceInterface.getLiveInfo().anchorInfo.uid;
  }
  
  public AppGeneralInfoService getAppInfo()
  {
    return (AppGeneralInfoService)this.val$serviceManager.getService(AppGeneralInfoService.class);
  }
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.val$serviceManager.getService(ChannelInterface.class);
  }
  
  public HttpInterface getHttp()
  {
    return (HttpInterface)this.val$serviceManager.getService(HttpInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
  
  public MediaPlayerInterface getMediaPlayerInterface()
  {
    return (MediaPlayerInterface)this.val$serviceManager.getService(MediaPlayerInterface.class);
  }
  
  public NetworkStateInterface getNetWorkState()
  {
    return (NetworkStateInterface)this.val$serviceManager.getService(NetworkStateInterface.class);
  }
  
  public String getNickName()
  {
    if (this.val$roomServiceInterface.getLiveInfo() == null) {
      return "";
    }
    return this.val$roomServiceInterface.getLiveInfo().anchorInfo.nickName;
  }
  
  public long getRoomId()
  {
    if (this.val$roomServiceInterface.getLiveInfo() == null) {
      return 0L;
    }
    return this.val$roomServiceInterface.getLiveInfo().roomInfo.roomId;
  }
  
  public int getRoomType()
  {
    if (this.val$roomServiceInterface.getLiveInfo() == null) {
      return 0;
    }
    return this.val$roomServiceInterface.getLiveInfo().roomInfo.roomType;
  }
  
  public ToastInterface getToast()
  {
    return (ToastInterface)this.val$serviceManager.getService(ToastInterface.class);
  }
  
  public boolean isHoldPlayerLog()
  {
    return ((AppGeneralInfoService)this.val$serviceManager.getService(AppGeneralInfoService.class)).isHoldPlayerLog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.avplayer.AVPlayerServiceBuilder.2
 * JD-Core Version:    0.7.0.1
 */