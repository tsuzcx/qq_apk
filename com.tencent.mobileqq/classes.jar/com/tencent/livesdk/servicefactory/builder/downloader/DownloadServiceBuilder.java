package com.tencent.livesdk.servicefactory.builder.downloader;

import com.tencent.falco.base.downloader.DownLoaderComponent;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class DownloadServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    DownLoaderComponent localDownLoaderComponent = new DownLoaderComponent();
    localDownLoaderComponent.init(new DownloadServiceBuilder.1(this, paramServiceAccessor));
    return localDownLoaderComponent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.downloader.DownloadServiceBuilder
 * JD-Core Version:    0.7.0.1
 */