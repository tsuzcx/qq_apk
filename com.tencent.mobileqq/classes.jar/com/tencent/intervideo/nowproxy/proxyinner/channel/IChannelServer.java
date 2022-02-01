package com.tencent.intervideo.nowproxy.proxyinner.channel;

import android.os.IInterface;

public abstract interface IChannelServer
  extends IInterface
{
  public abstract void a(int paramInt, ToService paramToService);
  
  public abstract void a(IChannelClient paramIChannelClient);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.proxyinner.channel.IChannelServer
 * JD-Core Version:    0.7.0.1
 */