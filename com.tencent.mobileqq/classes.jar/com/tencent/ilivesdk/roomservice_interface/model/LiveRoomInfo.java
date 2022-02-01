package com.tencent.ilivesdk.roomservice_interface.model;

import java.util.Arrays;

public class LiveRoomInfo
{
  public String enterRoomSystemNotice;
  public byte[] freeFlowSig;
  public int giftFlag;
  public int goodsFlag;
  public int goodsNum;
  public String goodsUrl;
  public boolean isFreeFlow = false;
  public boolean isGift;
  public boolean isWXPub;
  public int mRoomGameType;
  public int mTencentLiveShield;
  public String programId;
  public int programStartTs;
  public long roomId;
  public String roomLogo;
  public String roomName;
  public int roomType;
  public String wxMiniProgramUserName;
  
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
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo
 * JD-Core Version:    0.7.0.1
 */