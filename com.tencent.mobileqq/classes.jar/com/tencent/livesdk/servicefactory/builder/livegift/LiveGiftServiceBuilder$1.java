package com.tencent.livesdk.servicefactory.builder.livegift;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.downloader.DownLoaderInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceAdapter;
import com.tencent.ilivesdk.liveconfigservice_interface.LiveConfigServiceInterface;
import com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import org.json.JSONObject;

class LiveGiftServiceBuilder$1
  implements GiftServiceAdapter
{
  LiveGiftServiceBuilder$1(LiveGiftServiceBuilder paramLiveGiftServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public PushReceiver createPushReceiver()
  {
    return ((RoomPushServiceInterface)this.val$serviceManager.getService(RoomPushServiceInterface.class)).createRoomPushReceiver();
  }
  
  public long getAccountUin()
  {
    return ((LoginServiceInterface)this.val$serviceManager.getService(LoginServiceInterface.class)).getLoginInfo().uid;
  }
  
  public AppGeneralInfoService getAppInfo()
  {
    return (AppGeneralInfoService)this.val$serviceManager.getService(AppGeneralInfoService.class);
  }
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.val$serviceManager.getService(ChannelInterface.class);
  }
  
  public DataReportInterface getDataReport()
  {
    return (DataReportInterface)this.val$serviceManager.getService(DataReportInterface.class);
  }
  
  public DownLoaderInterface getDownLoader()
  {
    return (DownLoaderInterface)this.val$serviceManager.getService(DownLoaderInterface.class);
  }
  
  public HttpInterface getHttp()
  {
    return (HttpInterface)this.val$serviceManager.getService(HttpInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
  
  public LoginServiceInterface getLoginService()
  {
    return (LoginServiceInterface)this.val$serviceManager.getService(LoginServiceInterface.class);
  }
  
  public long getRoomId()
  {
    LiveInfo localLiveInfo = ((RoomServiceInterface)this.val$serviceManager.getService(RoomServiceInterface.class)).getLiveInfo();
    if ((localLiveInfo != null) && (localLiveInfo.roomInfo != null)) {
      return localLiveInfo.roomInfo.roomId;
    }
    return 0L;
  }
  
  public ToastInterface getToastInterface()
  {
    return (ToastInterface)this.val$serviceManager.getService(ToastInterface.class);
  }
  
  public JSONObject updateGiftLogoFormatKey()
  {
    return ((LiveConfigServiceInterface)this.val$serviceManager.getService(LiveConfigServiceInterface.class)).getJson("common_urls");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.livegift.LiveGiftServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */