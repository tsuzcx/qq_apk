package com.tencent.avcore.netchannel;

public abstract interface IDavNetChannel
{
  public abstract void sendGetGatewayMsg();
  
  public abstract void sendGetVideoConfig(byte[] paramArrayOfByte);
  
  public abstract void sendSharpVideoMsg(long paramLong, byte[] paramArrayOfByte);
  
  public abstract void setNetCallback(IDavNetCallback paramIDavNetCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.netchannel.IDavNetChannel
 * JD-Core Version:    0.7.0.1
 */