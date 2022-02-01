package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloud.TRTCViewMargin;

public class TRTCRoomInfo$UserInfo
{
  public TRTCCloud.TRTCViewMargin debugMargin = new TRTCCloud.TRTCViewMargin(0.0F, 0.0F, 0.1F, 0.0F);
  public TRTCRoomInfo.RenderInfo mainRender = new TRTCRoomInfo.RenderInfo();
  public boolean muteAudioInSpeaker = false;
  public int streamState;
  public int streamType = 2;
  public TRTCRoomInfo.RenderInfo subRender = new TRTCRoomInfo.RenderInfo();
  public int terminalType;
  public long tinyID;
  public String userID;
  
  public TRTCRoomInfo$UserInfo(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    this.tinyID = paramLong;
    this.userID = paramString;
    this.terminalType = paramInt1;
    this.streamState = paramInt2;
    this.mainRender.tinyID = paramLong;
    this.subRender.tinyID = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserInfo
 * JD-Core Version:    0.7.0.1
 */