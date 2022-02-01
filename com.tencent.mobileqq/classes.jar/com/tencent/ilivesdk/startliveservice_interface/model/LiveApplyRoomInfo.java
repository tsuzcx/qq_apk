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
    return "roominfo is [roomid= " + this.roomId + ";roomName=" + this.roomName + ";roomLogo=" + this.roomLogo + ";roomType=" + this.roomType + ";goodsUrl=" + this.goodsUrl + ";programId=" + this.programId + ";isGift=" + this.isGift + ";mIsFreeFlow=" + this.isFreeFlow + ";mFreeFlowSig=" + Arrays.toString(this.freeFlowSig) + ";defaultRoomName=" + this.defaultRoomName + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.startliveservice_interface.model.LiveApplyRoomInfo
 * JD-Core Version:    0.7.0.1
 */