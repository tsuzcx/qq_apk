package com.tencent.TMG.sdk;

public class AVRoomMulti$ChangeRoomInfo$Builder
{
  long authBits = -1L;
  byte[] authBuffer = null;
  int relationId;
  
  public AVRoomMulti$ChangeRoomInfo$Builder(int paramInt)
  {
    this.relationId = paramInt;
  }
  
  public Builder auth(long paramLong, byte[] paramArrayOfByte)
  {
    this.authBits = paramLong;
    this.authBuffer = paramArrayOfByte;
    return this;
  }
  
  public AVRoomMulti.ChangeRoomInfo build()
  {
    return new AVRoomMulti.ChangeRoomInfo(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVRoomMulti.ChangeRoomInfo.Builder
 * JD-Core Version:    0.7.0.1
 */