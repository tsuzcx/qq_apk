package com.tencent.ilivesdk.roomservice_interface.model;

import android.os.Bundle;

public class EnterRoomInfo
{
  public int bootModulesIndex;
  public byte[] coverBitmapBytes;
  public Bundle extData;
  public boolean isLiteSdk;
  public String machine;
  public String preVideoUrl;
  public String programId;
  public long roomId;
  public int roomType;
  public String source;
  public String[] videoFormat;
  public String videoId;
  public int videoType;
  
  public String toString()
  {
    return "EnterRoomInfo:[roomId=" + this.roomId + ";source=" + this.source + ";programId=" + this.programId + ";machine=" + this.machine + ";roomType=" + this.roomType + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo
 * JD-Core Version:    0.7.0.1
 */