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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EnterRoomInfo:[roomId=");
    localStringBuilder.append(this.roomId);
    localStringBuilder.append(";source=");
    localStringBuilder.append(this.source);
    localStringBuilder.append(";programId=");
    localStringBuilder.append(this.programId);
    localStringBuilder.append(";machine=");
    localStringBuilder.append(this.machine);
    localStringBuilder.append(";roomType=");
    localStringBuilder.append(this.roomType);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo
 * JD-Core Version:    0.7.0.1
 */