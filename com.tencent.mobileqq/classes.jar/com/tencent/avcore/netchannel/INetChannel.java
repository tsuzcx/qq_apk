package com.tencent.avcore.netchannel;

public abstract interface INetChannel
{
  public abstract void sendGetGatewayMsg();
  
  public abstract void sendGetVideoConfig(byte[] paramArrayOfByte);
  
  public abstract void sendLogReportMsg(long paramLong, byte[] paramArrayOfByte);
  
  public abstract void sendMultiVideoMsg(long paramLong1, long paramLong2, byte[] paramArrayOfByte);
  
  public abstract void sendSharpVideoMsg(long paramLong, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.netchannel.INetChannel
 * JD-Core Version:    0.7.0.1
 */