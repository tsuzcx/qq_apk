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
    return "roominfo is [roomid= " + this.roomId + ";roomName=" + this.roomName + ";roomLogo=" + this.roomLogo + ";roomType=" + this.roomType + ";goodsUrl=" + this.goodsUrl + ";programId=" + this.programId + ";isGift=" + this.isGift + ";mIsFreeFlow=" + this.isFreeFlow + ";mFreeFlowSig=" + Arrays.toString(this.freeFlowSig) + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo
 * JD-Core Version:    0.7.0.1
 */