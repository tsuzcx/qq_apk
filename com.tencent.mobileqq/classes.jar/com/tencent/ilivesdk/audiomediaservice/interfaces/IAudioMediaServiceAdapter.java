package com.tencent.ilivesdk.audiomediaservice.interfaces;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;

public abstract interface IAudioMediaServiceAdapter
{
  public abstract ChannelInterface a();
  
  public abstract AppGeneralInfoService a();
  
  public abstract HttpInterface a();
  
  public abstract LogInterface a();
  
  public abstract LoginServiceInterface a();
  
  public abstract <T> void a(Class<T> paramClass, String paramString, ClassLoaderCallback paramClassLoaderCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaServiceAdapter
 * JD-Core Version:    0.7.0.1
 */