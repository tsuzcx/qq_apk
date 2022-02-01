package com.tencent.ilivesdk.startliveservice_interface.model;

import java.util.List;

public class StartLiveInfo
{
  public String city = "";
  public boolean isOpenGift;
  public String lat = "";
  public String lng = "";
  public boolean logoEdited = false;
  public String machine;
  public String phoneModel;
  public String programId;
  public long roomId;
  public String roomLogo = "";
  public long roomLogoTime;
  public String roomLogo_16_9;
  public long roomLogo_16_9_Time;
  public String roomLogo_3_4;
  public long roomLogo_3_4_Time;
  public String roomName;
  public String source;
  public List<RoomTagElement> tags;
  
  public String toString()
  {
    return "StartLiveInfo{roomId=" + this.roomId + ", programId='" + this.programId + '\'' + ", roomName='" + this.roomName + '\'' + ", roomLogo='" + this.roomLogo + '\'' + ", roomLogoTime=" + this.roomLogoTime + ", roomLogo_16_9='" + this.roomLogo_16_9 + '\'' + ", roomLogo_16_9_Time=" + this.roomLogo_16_9_Time + ", roomLogo_3_4='" + this.roomLogo_3_4 + '\'' + ", roomLogo_3_4_Time=" + this.roomLogo_3_4_Time + ", lng='" + this.lng + '\'' + ", lat='" + this.lat + '\'' + ", city='" + this.city + '\'' + ", phoneModel='" + this.phoneModel + '\'' + ", isOpenGift=" + this.isOpenGift + ", tags=" + this.tags + ", source='" + this.source + '\'' + ", logoEdited=" + this.logoEdited + ", machine='" + this.machine + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.startliveservice_interface.model.StartLiveInfo
 * JD-Core Version:    0.7.0.1
 */