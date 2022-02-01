package com.tencent.falco.base.libapi.login;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.web.WebInterface;

public abstract interface LoginServiceAdapter
{
  public abstract ChannelInterface getChannel();
  
  public abstract int getClientType();
  
  public abstract DataReportInterface getDataReportInterface();
  
  public abstract String getDeviceID();
  
  public abstract HostProxyInterface getHostProxyInterface();
  
  public abstract HttpInterface getHttp();
  
  public abstract LogInterface getLog();
  
  public abstract int getVersionCode();
  
  public abstract WebInterface getWebInterface();
  
  public abstract boolean isTestEnv();
  
  public abstract boolean loginByWns();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.login.LoginServiceAdapter
 * JD-Core Version:    0.7.0.1
 */