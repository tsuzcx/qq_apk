package com.tencent.livesdk.servicefactory.builder.avplayer;

import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerPreloadAdapter;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerPreloadAdapter.AVPreloadListener;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface.AVPreloadResultListener;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface.AVPreloadScenes;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;

class AVPlayerServiceBuilder$3
  implements AVPlayerPreloadAdapter
{
  AVPlayerPreloadAdapter.AVPreloadListener a;
  String b;
  AVPreloadServiceInterface.AVPreloadResultListener c = new AVPlayerServiceBuilder.3.1(this);
  
  AVPlayerServiceBuilder$3(AVPlayerServiceBuilder paramAVPlayerServiceBuilder, AVPlayerBuilderServiceInterface paramAVPlayerBuilderServiceInterface, AVPreloadServiceInterface paramAVPreloadServiceInterface) {}
  
  public void a(AVPlayerPreloadAdapter.AVPreloadListener paramAVPreloadListener)
  {
    this.e.b(this.c);
  }
  
  public void a(String paramString)
  {
    if (this.d.isUseLocalServerPreload())
    {
      this.e.a(AVPreloadServiceInterface.AVPreloadScenes.SWITCH_ROOM);
      this.e.a(paramString);
    }
  }
  
  public void a(String paramString, AVPlayerPreloadAdapter.AVPreloadListener paramAVPreloadListener)
  {
    this.b = paramString;
    this.a = paramAVPreloadListener;
    if (this.d.isUseLocalServerPreload()) {
      this.e.a(this.c);
    }
  }
  
  public void b(String paramString)
  {
    if (this.d.isUseLocalServerPreload()) {
      this.e.b(paramString);
    }
  }
  
  public void c(String paramString)
  {
    if (this.d.isUseLocalServerPreload()) {
      this.e.c(paramString);
    }
  }
  
  public void d(String paramString)
  {
    if (this.d.isUseLocalServerPreload()) {
      this.e.d(paramString);
    }
  }
  
  public String e(String paramString)
  {
    String str = paramString;
    if (this.d.isUseLocalServerPreload()) {
      str = this.e.g(paramString);
    }
    return str;
  }
  
  public String f(String paramString)
  {
    return this.e.h(paramString);
  }
  
  public void g(String paramString)
  {
    if (this.d.isUseLocalServerPreload()) {
      this.e.e(paramString);
    }
  }
  
  public AVPreloadTaskInterface h(String paramString)
  {
    if (this.d.isUseLocalServerPreload()) {
      return this.e.j(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.avplayer.AVPlayerServiceBuilder.3
 * JD-Core Version:    0.7.0.1
 */