package com.tencent.livesdk.servicefactory.builder.chatmessage;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.ilivesdk.messagefilterserviceinterface.MessageFilterServiceInterface;
import com.tencent.ilivesdk.messageservice_interface.MessageServiceAdapter;
import com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class ChatMessageServiceBuilder$1
  implements MessageServiceAdapter
{
  ChatMessageServiceBuilder$1(ChatMessageServiceBuilder paramChatMessageServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public PushReceiver createPushReceiver()
  {
    return ((RoomPushServiceInterface)this.val$serviceManager.getService(RoomPushServiceInterface.class)).createRoomPushReceiver();
  }
  
  public long getAccountUin()
  {
    LoginInfo localLoginInfo = ((LoginServiceInterface)this.val$serviceManager.getService(LoginServiceInterface.class)).getLoginInfo();
    if (localLoginInfo != null) {
      return localLoginInfo.uid;
    }
    return 0L;
  }
  
  public long getAnchorUin()
  {
    LiveInfo localLiveInfo = ((RoomServiceInterface)this.val$serviceManager.getService(RoomServiceInterface.class)).getLiveInfo();
    if (localLiveInfo != null) {
      return localLiveInfo.anchorInfo.uid;
    }
    return 0L;
  }
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.val$serviceManager.getService(ChannelInterface.class);
  }
  
  public DataReportInterface getDataReport()
  {
    return (DataReportInterface)this.val$serviceManager.getService(DataReportInterface.class);
  }
  
  public HostProxyInterface getHostProxyInterface()
  {
    return (HostProxyInterface)this.val$serviceManager.getService(HostProxyInterface.class);
  }
  
  public HttpInterface getHttp()
  {
    return (HttpInterface)this.val$serviceManager.getService(HttpInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
  
  public MessageFilterServiceInterface getMessageFilterService()
  {
    return (MessageFilterServiceInterface)this.val$serviceManager.getService(MessageFilterServiceInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.chatmessage.ChatMessageServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */