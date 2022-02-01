package com.tencent.livesdk.servicefactory.builder.musicmanager;

import com.tencent.falco.base.libapi.downloader.DownLoaderInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.base.libapi.music.MusicDubInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.ilivesdk.musicmanagerservice_interface.MusicManagerServiceAdapter;
import com.tencent.ilivesdk.musicservice_interface.MusicServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class MusicManagerBuilder$1
  implements MusicManagerServiceAdapter
{
  MusicManagerBuilder$1(MusicManagerBuilder paramMusicManagerBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public AppGeneralInfoService getAppGeneralInfoService()
  {
    return (AppGeneralInfoService)this.val$serviceManager.getService(AppGeneralInfoService.class);
  }
  
  public DownLoaderInterface getDownloader()
  {
    return (DownLoaderInterface)this.val$serviceManager.getService(DownLoaderInterface.class);
  }
  
  public HttpInterface getHttp()
  {
    return (HttpInterface)this.val$serviceManager.getService(HttpInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
  
  public LoginServiceInterface getLoginService()
  {
    return (LoginServiceInterface)this.val$serviceManager.getService(LoginServiceInterface.class);
  }
  
  public MusicDubInterface getMusicService()
  {
    return (MusicDubInterface)this.val$serviceManager.getService(MusicServiceInterface.class);
  }
  
  public ToastInterface getToast()
  {
    return (ToastInterface)this.val$serviceManager.getService(ToastInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.musicmanager.MusicManagerBuilder.1
 * JD-Core Version:    0.7.0.1
 */