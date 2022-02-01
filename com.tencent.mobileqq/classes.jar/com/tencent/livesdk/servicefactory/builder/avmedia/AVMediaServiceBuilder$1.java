package com.tencent.livesdk.servicefactory.builder.avmedia;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.downloader.DownLoaderInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.base.libapi.network.NetworkStateInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.ilivesdk.avmediaservice_interface.AVMediaServiceAdapter;
import com.tencent.ilivesdk.beautyfilterservice_interface.BeautyFilterServiceInterface;
import com.tencent.ilivesdk.liveconfigservice_interface.LiveConfigServiceInterface;
import com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.ServiceAccessorMgr;
import org.json.JSONObject;

class AVMediaServiceBuilder$1
  implements AVMediaServiceAdapter
{
  AVMediaServiceBuilder$1(AVMediaServiceBuilder paramAVMediaServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public PushReceiver createPushReceiver()
  {
    return ((RoomPushServiceInterface)ServiceAccessorMgr.getInstance().getRoomAccessor().getService(RoomPushServiceInterface.class)).createRoomPushReceiver();
  }
  
  public String getAVConfig()
  {
    JSONObject localJSONObject = ((LiveConfigServiceInterface)this.val$serviceAccessor.getService(LiveConfigServiceInterface.class)).getJson("video_config");
    if (localJSONObject == null) {
      return "";
    }
    return localJSONObject.toString();
  }
  
  public LoginServiceInterface getAccount()
  {
    return (LoginServiceInterface)this.val$serviceAccessor.getService(LoginServiceInterface.class);
  }
  
  public AppGeneralInfoService getAppInfo()
  {
    return (AppGeneralInfoService)this.val$serviceAccessor.getService(AppGeneralInfoService.class);
  }
  
  public BeautyFilterServiceInterface getBeautyFilterService()
  {
    return (BeautyFilterServiceInterface)this.val$serviceAccessor.getService(BeautyFilterServiceInterface.class);
  }
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.val$serviceAccessor.getService(ChannelInterface.class);
  }
  
  public int getContentType()
  {
    return 0;
  }
  
  public DataReportInterface getDataReporter()
  {
    return (DataReportInterface)this.val$serviceAccessor.getService(DataReportInterface.class);
  }
  
  public DownLoaderInterface getDownLoader()
  {
    return (DownLoaderInterface)this.val$serviceAccessor.getService(DownLoaderInterface.class);
  }
  
  public HttpInterface getHttp()
  {
    return (HttpInterface)this.val$serviceAccessor.getService(HttpInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceAccessor.getService(LogInterface.class);
  }
  
  public NetworkStateInterface getNetWorkState()
  {
    return (NetworkStateInterface)this.val$serviceAccessor.getService(NetworkStateInterface.class);
  }
  
  public String getResolution()
  {
    String str2 = ((LiveConfigServiceInterface)this.val$serviceAccessor.getService(LiveConfigServiceInterface.class)).getString("anchor_resolution", "");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public int getShield()
  {
    return 0;
  }
  
  public ToastInterface getToast()
  {
    return (ToastInterface)this.val$serviceAccessor.getService(ToastInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.avmedia.AVMediaServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */