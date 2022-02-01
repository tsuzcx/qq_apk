package com.tencent.avcore.netchannel;

public abstract interface IDavNetCallback
{
  public abstract void receiveGatewayMsg(String paramString, int paramInt);
  
  public abstract byte receiveSharpVideoAck(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public abstract byte receiveSharpVideoCall(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.netchannel.IDavNetCallback
 * JD-Core Version:    0.7.0.1
 */