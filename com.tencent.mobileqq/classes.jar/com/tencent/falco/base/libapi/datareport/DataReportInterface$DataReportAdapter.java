package com.tencent.falco.base.libapi.datareport;

import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;

public abstract interface DataReportInterface$DataReportAdapter
{
  public abstract int getAnchorClientType();
  
  public abstract String getAnchorExplicitId();
  
  public abstract String getAnchorId();
  
  public abstract AppGeneralInfoService getAppInfo();
  
  public abstract String getAppKey();
  
  public abstract String getAppVersion();
  
  public abstract String getChannelId();
  
  public abstract HostProxyInterface getHostProxy();
  
  public abstract LogInterface getLog();
  
  public abstract LoginServiceInterface getLoginInfo();
  
  public abstract String getProgramId();
  
  public abstract String getRoomId();
  
  public abstract String getRoomMode();
  
  public abstract int getRoomType();
  
  public abstract String getStartLiveProgramId();
  
  public abstract String getStartLiveRoomId();
  
  public abstract boolean isInRoom();
  
  public abstract boolean isOutRoomHasRoomInfo();
  
  public abstract boolean isRoomAccessorNull();
  
  public abstract boolean isUserHostBeacon();
  
  public abstract void onGetBeaconImei(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.datareport.DataReportInterface.DataReportAdapter
 * JD-Core Version:    0.7.0.1
 */