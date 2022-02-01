package com.tencent.livesdk.servicefactory.builder.datareport;

import android.text.TextUtils;
import com.tencent.falco.base.libapi.datareport.DataReportInterface.DataReportAdapter;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.hostproxy.HostReportInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.ilivesdk.startliveservice_interface.StartLiveServiceInterface;
import com.tencent.ilivesdk.startliveservice_interface.model.LiveApplyRoomInfo;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.ServiceAccessorMgr;

class DataReportServiceBuilder$1
  implements DataReportInterface.DataReportAdapter
{
  DataReportServiceBuilder$1(DataReportServiceBuilder paramDataReportServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public int getAnchorClientType()
  {
    RoomServiceInterface localRoomServiceInterface = (RoomServiceInterface)ServiceAccessorMgr.getInstance().getRoomAccessor().getService(RoomServiceInterface.class);
    if ((localRoomServiceInterface.getLiveInfo() != null) && (localRoomServiceInterface.getLiveInfo().anchorInfo != null)) {
      return localRoomServiceInterface.getLiveInfo().anchorInfo.initialClientType;
    }
    return 0;
  }
  
  public String getAnchorExplicitId()
  {
    RoomServiceInterface localRoomServiceInterface = (RoomServiceInterface)ServiceAccessorMgr.getInstance().getRoomAccessor().getService(RoomServiceInterface.class);
    if ((localRoomServiceInterface.getLiveInfo() != null) && (localRoomServiceInterface.getLiveInfo().anchorInfo != null)) {
      return String.valueOf(localRoomServiceInterface.getLiveInfo().anchorInfo.explicitId);
    }
    return "";
  }
  
  public String getAnchorId()
  {
    RoomServiceInterface localRoomServiceInterface = (RoomServiceInterface)ServiceAccessorMgr.getInstance().getRoomAccessor().getService(RoomServiceInterface.class);
    if ((localRoomServiceInterface.getLiveInfo() != null) && (localRoomServiceInterface.getLiveInfo().anchorInfo != null)) {
      return String.valueOf(localRoomServiceInterface.getLiveInfo().anchorInfo.uid);
    }
    return "";
  }
  
  public AppGeneralInfoService getAppInfo()
  {
    return (AppGeneralInfoService)this.val$serviceManager.getService(AppGeneralInfoService.class);
  }
  
  public String getAppKey()
  {
    boolean bool = false;
    if ((this.this$0.mHostProxyInterface.getReportInterface() != null) && (this.this$0.mHostProxyInterface.getReportInterface().isBeaconRealTimeDebug())) {}
    for (int i = 1;; i = 0)
    {
      AppGeneralInfoService localAppGeneralInfoService = (AppGeneralInfoService)this.val$serviceManager.getService(AppGeneralInfoService.class);
      if (localAppGeneralInfoService != null) {
        bool = localAppGeneralInfoService.isLiteSdk();
      }
      if (i == 0) {
        break;
      }
      return "LOGDEBUGKEY00001";
    }
    if (bool) {
      return "00000MEVUX3CBYO1";
    }
    return "000005YECQ3C2LO8";
  }
  
  public String getAppVersion()
  {
    AppGeneralInfoService localAppGeneralInfoService = (AppGeneralInfoService)this.val$serviceManager.getService(AppGeneralInfoService.class);
    if (localAppGeneralInfoService != null) {
      return localAppGeneralInfoService.getVersionName();
    }
    return "";
  }
  
  public String getChannelId()
  {
    AppGeneralInfoService localAppGeneralInfoService = (AppGeneralInfoService)this.val$serviceManager.getService(AppGeneralInfoService.class);
    if (localAppGeneralInfoService != null) {
      return localAppGeneralInfoService.getChannelID();
    }
    return "";
  }
  
  public HostProxyInterface getHostProxy()
  {
    return (HostProxyInterface)this.val$serviceManager.getService(HostProxyInterface.class);
  }
  
  public LogInterface getLog()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
  
  public LoginServiceInterface getLoginInfo()
  {
    return (LoginServiceInterface)ServiceAccessorMgr.getInstance().getUserAccessor().getService(LoginServiceInterface.class);
  }
  
  public String getProgramId()
  {
    RoomServiceInterface localRoomServiceInterface = (RoomServiceInterface)ServiceAccessorMgr.getInstance().getRoomAccessor().getService(RoomServiceInterface.class);
    if ((localRoomServiceInterface.getLiveInfo() != null) && (localRoomServiceInterface.getLiveInfo().roomInfo != null)) {
      return String.valueOf(localRoomServiceInterface.getLiveInfo().roomInfo.programId);
    }
    return "";
  }
  
  public String getRoomId()
  {
    RoomServiceInterface localRoomServiceInterface = (RoomServiceInterface)ServiceAccessorMgr.getInstance().getRoomAccessor().getService(RoomServiceInterface.class);
    if ((localRoomServiceInterface.getLiveInfo() != null) && (localRoomServiceInterface.getLiveInfo().roomInfo != null)) {
      return String.valueOf(localRoomServiceInterface.getLiveInfo().roomInfo.roomId);
    }
    return "";
  }
  
  public String getRoomMode()
  {
    return "0";
  }
  
  public int getRoomType()
  {
    RoomServiceInterface localRoomServiceInterface = (RoomServiceInterface)ServiceAccessorMgr.getInstance().getRoomAccessor().getService(RoomServiceInterface.class);
    if ((localRoomServiceInterface.getLiveInfo() != null) && (localRoomServiceInterface.getLiveInfo().roomInfo != null)) {
      return localRoomServiceInterface.getLiveInfo().roomInfo.roomType;
    }
    return 0;
  }
  
  public String getStartLiveProgramId()
  {
    StartLiveServiceInterface localStartLiveServiceInterface = (StartLiveServiceInterface)ServiceAccessorMgr.getInstance().getUserAccessor().getService(StartLiveServiceInterface.class);
    if (localStartLiveServiceInterface.getLiveApplyRoomInfo() != null) {
      return String.valueOf(localStartLiveServiceInterface.getLiveApplyRoomInfo().programId);
    }
    return null;
  }
  
  public String getStartLiveRoomId()
  {
    StartLiveServiceInterface localStartLiveServiceInterface = (StartLiveServiceInterface)ServiceAccessorMgr.getInstance().getUserAccessor().getService(StartLiveServiceInterface.class);
    if (localStartLiveServiceInterface.getLiveApplyRoomInfo() != null) {
      return String.valueOf(localStartLiveServiceInterface.getLiveApplyRoomInfo().roomId);
    }
    return null;
  }
  
  public boolean isInRoom()
  {
    return (ServiceAccessorMgr.getInstance().getRoomAccessor() != null) && (ServiceAccessorMgr.getInstance().getRoomAccessor().getService(RoomServiceInterface.class) != null) && (((RoomServiceInterface)ServiceAccessorMgr.getInstance().getRoomAccessor().getService(RoomServiceInterface.class)).getLiveInfo() != null);
  }
  
  public boolean isOutRoomHasRoomInfo()
  {
    return (ServiceAccessorMgr.getInstance().getUserAccessor() != null) && (ServiceAccessorMgr.getInstance().getUserAccessor().getService(StartLiveServiceInterface.class) != null) && (((StartLiveServiceInterface)ServiceAccessorMgr.getInstance().getUserAccessor().getService(StartLiveServiceInterface.class)).getLiveApplyRoomInfo() != null);
  }
  
  public boolean isRoomAccessorNull()
  {
    return ServiceAccessorMgr.getInstance().getRoomAccessor() == null;
  }
  
  public boolean isUserHostBeacon()
  {
    String str = ((HostProxyInterface)this.val$serviceManager.getService(HostProxyInterface.class)).isUserHostBeacon();
    if (TextUtils.isEmpty(str)) {
      throw new RuntimeException("isUserHostBeacon should not be null");
    }
    if ((!str.equals("1")) && (!str.equals("0"))) {
      throw new RuntimeException("isUserHostBeacon should be in 0 and 1");
    }
    return str.equals("1");
  }
  
  public void onGetBeaconImei(String paramString)
  {
    AppGeneralInfoService localAppGeneralInfoService = (AppGeneralInfoService)this.val$serviceManager.getService(AppGeneralInfoService.class);
    if (localAppGeneralInfoService != null) {
      localAppGeneralInfoService.setDeviceId(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.datareport.DataReportServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */