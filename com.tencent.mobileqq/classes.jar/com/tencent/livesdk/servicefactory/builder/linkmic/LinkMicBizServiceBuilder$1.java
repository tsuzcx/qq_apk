package com.tencent.livesdk.servicefactory.builder.linkmic;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.ilivesdk.linkmicbizserviceinterface.LinkMicBizServiceAdapter;
import com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class LinkMicBizServiceBuilder$1
  implements LinkMicBizServiceAdapter
{
  LinkMicBizServiceBuilder$1(LinkMicBizServiceBuilder paramLinkMicBizServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public PushReceiver createPushReceiver()
  {
    return ((RoomPushServiceInterface)this.val$serviceManager.getService(RoomPushServiceInterface.class)).createRoomPushReceiver();
  }
  
  public long getAnchorUid()
  {
    if (((RoomServiceInterface)this.val$serviceManager.getService(RoomServiceInterface.class)).getLiveInfo() != null) {
      return ((RoomServiceInterface)this.val$serviceManager.getService(RoomServiceInterface.class)).getLiveInfo().anchorInfo.uid;
    }
    return 0L;
  }
  
  public AppGeneralInfoService getAppInfo()
  {
    return (AppGeneralInfoService)this.val$serviceManager.getService(AppGeneralInfoService.class);
  }
  
  public ChannelInterface getChannelInterface()
  {
    return (ChannelInterface)this.val$serviceManager.getService(ChannelInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
  
  public LoginServiceInterface getLoginInterface()
  {
    return (LoginServiceInterface)this.val$serviceManager.getService(LoginServiceInterface.class);
  }
  
  public long getSelfRoomId()
  {
    if (((RoomServiceInterface)this.val$serviceManager.getService(RoomServiceInterface.class)).getLiveInfo() != null) {
      return ((RoomServiceInterface)this.val$serviceManager.getService(RoomServiceInterface.class)).getLiveInfo().roomInfo.roomId;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.linkmic.LinkMicBizServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */