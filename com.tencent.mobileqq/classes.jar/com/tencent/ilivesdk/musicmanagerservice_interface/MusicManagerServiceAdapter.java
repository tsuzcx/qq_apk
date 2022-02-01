package com.tencent.ilivesdk.musicmanagerservice_interface;

import com.tencent.falco.base.libapi.downloader.DownLoaderInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.base.libapi.music.MusicDubInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;

public abstract interface MusicManagerServiceAdapter
{
  public abstract AppGeneralInfoService getAppGeneralInfoService();
  
  public abstract DownLoaderInterface getDownloader();
  
  public abstract HttpInterface getHttp();
  
  public abstract LogInterface getLogger();
  
  public abstract LoginServiceInterface getLoginService();
  
  public abstract MusicDubInterface getMusicService();
  
  public abstract ToastInterface getToast();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.musicmanagerservice_interface.MusicManagerServiceAdapter
 * JD-Core Version:    0.7.0.1
 */