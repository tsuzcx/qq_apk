package com.tencent.falco.base.libapi.channel;

public abstract interface ChannelCallback
{
  public abstract void onError(boolean paramBoolean, int paramInt, String paramString);
  
  public abstract void onRecv(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.channel.ChannelCallback
 * JD-Core Version:    0.7.0.1
 */