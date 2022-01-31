package com.tencent.TMG.sdk;

public class AVRoomMulti$ChangeRoomInfo
{
  long authBits;
  byte[] authBuffer;
  int relationId;
  
  public AVRoomMulti$ChangeRoomInfo(AVRoomMulti.ChangeRoomInfo.Builder paramBuilder)
  {
    this.relationId = paramBuilder.relationId;
    this.authBits = paramBuilder.authBits;
    this.authBuffer = paramBuilder.authBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVRoomMulti.ChangeRoomInfo
 * JD-Core Version:    0.7.0.1
 */