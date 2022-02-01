package com.tencent.ilivesdk.startliveservice_interface.model;

import java.util.Arrays;
import java.util.List;

public class LiveApplyRoomInfo
{
  public String defaultRoomName;
  public byte[] freeFlowSig;
  public int goodsNum;
  public String goodsUrl;
  public boolean isFreeFlow = false;
  public boolean isGift;
  public String programId;
  public long roomId;
  public String roomLogo;
  public String roomLogo_16_9;
  public String roomLogo_3_4;
  public String roomName;
  public String roomPrepareNotify;
  public int roomType;
  public List<RoomTagElement> tags;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("roominfo is [roomid= ");
    localStringBuilder.append(this.roomId);
    localStringBuilder.append(";roomName=");
    localStringBuilder.append(this.roomName);
    localStringBuilder.append(";roomLogo=");
    localStringBuilder.append(this.roomLogo);
    localStringBuilder.append(";roomType=");
    localStringBuilder.append(this.roomType);
    localStringBuilder.append(";goodsUrl=");
    localStringBuilder.append(this.goodsUrl);
    localStringBuilder.append(";programId=");
    localStringBuilder.append(this.programId);
    localStringBuilder.append(";isGift=");
    localStringBuilder.append(this.isGift);
    localStringBuilder.append(";mIsFreeFlow=");
    localStringBuilder.append(this.isFreeFlow);
    localStringBuilder.append(";mFreeFlowSig=");
    localStringBuilder.append(Arrays.toString(this.freeFlowSig));
    localStringBuilder.append(";defaultRoomName=");
    localStringBuilder.append(this.defaultRoomName);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.startliveservice_interface.model.LiveApplyRoomInfo
 * JD-Core Version:    0.7.0.1
 */