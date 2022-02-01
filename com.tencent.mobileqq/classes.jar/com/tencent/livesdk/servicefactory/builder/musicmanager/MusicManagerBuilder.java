package com.tencent.livesdk.servicefactory.builder.musicmanager;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.musicmanagerservice.MusicManagerService;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class MusicManagerBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    MusicManagerService localMusicManagerService = new MusicManagerService();
    localMusicManagerService.init(new MusicManagerBuilder.1(this, paramServiceAccessor));
    return localMusicManagerService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.musicmanager.MusicManagerBuilder
 * JD-Core Version:    0.7.0.1
 */