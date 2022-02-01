package com.tencent.avcore.netchannel;

public abstract interface IMavNetCallback
{
  public static final int EM_PROTO_CHANNEL_GA_ACK = 2;
  public static final int EM_PROTO_CHANNEL_GA_MSG = 1;
  public static final int EM_PROTO_CHANNEL_GA_OFFLINE = 3;
  
  public abstract void receiveGatewayMsg(String paramString, int paramInt);
  
  public abstract int receiveMultiVideoMsg(int paramInt, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.netchannel.IMavNetCallback
 * JD-Core Version:    0.7.0.1
 */