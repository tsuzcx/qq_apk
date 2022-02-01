package com.tencent.falco.base.libapi.channel.helper;

import com.tencent.falco.base.libapi.channel.ChannelCallback;

public abstract interface CsTask
{
  public abstract CsTask callback(ChannelCallback paramChannelCallback);
  
  public abstract CsTask cancel();
  
  public abstract CsTask cmd(int paramInt1, int paramInt2);
  
  public abstract CsTask retryOnError(int paramInt);
  
  public abstract CsTask send(byte[] paramArrayOfByte);
  
  public abstract CsTask timeout(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.channel.helper.CsTask
 * JD-Core Version:    0.7.0.1
 */