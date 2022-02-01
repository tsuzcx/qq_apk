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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StartLiveInfo{roomId=");
    localStringBuilder.append(this.roomId);
    localStringBuilder.append(", programId='");
    localStringBuilder.append(this.programId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", roomName='");
    localStringBuilder.append(this.roomName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", roomLogo='");
    localStringBuilder.append(this.roomLogo);
    localStringBuilder.append('\'');
    localStringBuilder.append(", roomLogoTime=");
    localStringBuilder.append(this.roomLogoTime);
    localStringBuilder.append(", roomLogo_16_9='");
    localStringBuilder.append(this.roomLogo_16_9);
    localStringBuilder.append('\'');
    localStringBuilder.append(", roomLogo_16_9_Time=");
    localStringBuilder.append(this.roomLogo_16_9_Time);
    localStringBuilder.append(", roomLogo_3_4='");
    localStringBuilder.append(this.roomLogo_3_4);
    localStringBuilder.append('\'');
    localStringBuilder.append(", roomLogo_3_4_Time=");
    localStringBuilder.append(this.roomLogo_3_4_Time);
    localStringBuilder.append(", lng='");
    localStringBuilder.append(this.lng);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lat='");
    localStringBuilder.append(this.lat);
    localStringBuilder.append('\'');
    localStringBuilder.append(", city='");
    localStringBuilder.append(this.city);
    localStringBuilder.append('\'');
    localStringBuilder.append(", phoneModel='");
    localStringBuilder.append(this.phoneModel);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isOpenGift=");
    localStringBuilder.append(this.isOpenGift);
    localStringBuilder.append(", tags=");
    localStringBuilder.append(this.tags);
    localStringBuilder.append(", source='");
    localStringBuilder.append(this.source);
    localStringBuilder.append('\'');
    localStringBuilder.append(", logoEdited=");
    localStringBuilder.append(this.logoEdited);
    localStringBuilder.append(", machine='");
    localStringBuilder.append(this.machine);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.startliveservice_interface.model.StartLiveInfo
 * JD-Core Version:    0.7.0.1
 */