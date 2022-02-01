package com.tencent.ilive.components.download;

import com.tencent.falco.base.libapi.downloader.DownLoaderInterface.DownLoaderComponentAdapter;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class LiteDownloaderServiceBuilder$1
  implements DownLoaderInterface.DownLoaderComponentAdapter
{
  LiteDownloaderServiceBuilder$1(LiteDownloaderServiceBuilder paramLiteDownloaderServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public int getAppId()
  {
    return 3128;
  }
  
  public LogInterface getLog()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
  
  public boolean isLite()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.components.download.LiteDownloaderServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */