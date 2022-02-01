package com.tencent.livesdk.servicefactory.builder.music;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.musicservice.MusicDubService;
import com.tencent.ilivesdk.musicservice_interface.MusicServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class MusicDubServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    MusicDubService localMusicDubService = new MusicDubService();
    localMusicDubService.setMusicDubAdapter(new MusicDubServiceBuilder.1(this, paramServiceAccessor));
    return localMusicDubService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.music.MusicDubServiceBuilder
 * JD-Core Version:    0.7.0.1
 */