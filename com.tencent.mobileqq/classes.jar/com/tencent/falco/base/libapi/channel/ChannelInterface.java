package com.tencent.falco.base.libapi.channel;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.libapi.channel.helper.CsTask;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.login.LoginInfo;

public abstract interface ChannelInterface
  extends ServiceBaseInterface
{
  public abstract void create(ChannelCreateCallback paramChannelCreateCallback);
  
  public abstract CsTask createCsTask();
  
  public abstract PushReceiver createPushReceiver();
  
  public abstract void send(int paramInt1, int paramInt2, byte[] paramArrayOfByte, ChannelCallback paramChannelCallback);
  
  public abstract void sendWithCmd(int paramInt1, int paramInt2, byte[] paramArrayOfByte, ChannelCallback paramChannelCallback);
  
  public abstract void sendWithNewWay(String paramString, byte[] paramArrayOfByte, int paramInt, ChannelCallback paramChannelCallback);
  
  @Deprecated
  public abstract void sendWithOldWay(String paramString, byte[] paramArrayOfByte, ChannelCallback paramChannelCallback);
  
  public abstract void sendWithPrefix(String paramString1, String paramString2, byte[] paramArrayOfByte, ChannelCallback paramChannelCallback);
  
  public abstract void sendWithTRpc(String paramString1, String paramString2, byte[] paramArrayOfByte, ChannelCallback paramChannelCallback);
  
  public abstract void sendWithTRpc(String paramString, byte[] paramArrayOfByte, ChannelCallback paramChannelCallback);
  
  public abstract void setAuthTicket(String paramString1, String paramString2);
  
  public abstract void setLoginInfo(LoginInfo paramLoginInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.channel.ChannelInterface
 * JD-Core Version:    0.7.0.1
 */