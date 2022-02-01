package com.tencent.TMG.sdk;

public class AVRoomMulti$AVCustomData
{
  byte[] data;
  boolean isAutoPushed;
  
  private AVRoomMulti$AVCustomData() {}
  
  public AVRoomMulti$AVCustomData(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    this.data = paramArrayOfByte;
    this.isAutoPushed = paramBoolean;
  }
  
  public byte[] getData()
  {
    return this.data;
  }
  
  public boolean getIsAutoPushed()
  {
    return this.isAutoPushed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVRoomMulti.AVCustomData
 * JD-Core Version:    0.7.0.1
 */