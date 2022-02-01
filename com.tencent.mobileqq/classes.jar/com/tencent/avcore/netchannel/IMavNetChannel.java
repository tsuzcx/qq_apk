package com.tencent.avcore.netchannel;

public abstract interface IMavNetChannel
{
  public abstract void sendGetGatewayMsg();
  
  public abstract void sendMultiVideoMsg(long paramLong1, long paramLong2, byte[] paramArrayOfByte);
  
  public abstract void setNetCallback(IMavNetCallback paramIMavNetCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.netchannel.IMavNetChannel
 * JD-Core Version:    0.7.0.1
 */