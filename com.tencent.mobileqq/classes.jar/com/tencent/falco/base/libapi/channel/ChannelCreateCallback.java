package com.tencent.falco.base.libapi.channel;

public abstract interface ChannelCreateCallback
{
  public abstract void onFail(int paramInt, String paramString);
  
  public abstract void onSucceed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.channel.ChannelCreateCallback
 * JD-Core Version:    0.7.0.1
 */