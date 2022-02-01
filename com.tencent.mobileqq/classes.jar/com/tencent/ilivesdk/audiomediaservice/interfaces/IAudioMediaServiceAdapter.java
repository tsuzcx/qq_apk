package com.tencent.ilivesdk.audiomediaservice.interfaces;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;

public abstract interface IAudioMediaServiceAdapter
{
  public abstract ChannelInterface a();
  
  public abstract <T> void a(Class<T> paramClass, String paramString, ClassLoaderCallback paramClassLoaderCallback);
  
  public abstract LoginServiceInterface b();
  
  public abstract LogInterface c();
  
  public abstract AppGeneralInfoService d();
  
  public abstract HttpInterface e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaServiceAdapter
 * JD-Core Version:    0.7.0.1
 */