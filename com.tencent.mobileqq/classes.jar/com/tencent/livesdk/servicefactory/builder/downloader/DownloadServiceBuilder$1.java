package com.tencent.livesdk.servicefactory.builder.downloader;

import com.tencent.falco.base.libapi.downloader.DownLoaderInterface.DownLoaderComponentAdapter;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class DownloadServiceBuilder$1
  implements DownLoaderInterface.DownLoaderComponentAdapter
{
  DownloadServiceBuilder$1(DownloadServiceBuilder paramDownloadServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
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
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.downloader.DownloadServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */