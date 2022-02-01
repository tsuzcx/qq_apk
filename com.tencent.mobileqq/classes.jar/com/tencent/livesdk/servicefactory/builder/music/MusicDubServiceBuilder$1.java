package com.tencent.livesdk.servicefactory.builder.music;

import com.tencent.falco.base.libapi.downloader.DownLoaderInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.musicservice_interface.MusicDubAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class MusicDubServiceBuilder$1
  implements MusicDubAdapter
{
  MusicDubServiceBuilder$1(MusicDubServiceBuilder paramMusicDubServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public DownLoaderInterface getDownLoader()
  {
    return (DownLoaderInterface)this.val$serviceManager.getService(DownLoaderInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.music.MusicDubServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */