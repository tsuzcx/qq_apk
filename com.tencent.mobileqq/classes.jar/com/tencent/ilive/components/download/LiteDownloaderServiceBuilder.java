package com.tencent.ilive.components.download;

import com.tencent.falco.base.downloader.DownLoaderComponent;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class LiteDownloaderServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    DownLoaderComponent localDownLoaderComponent = new DownLoaderComponent();
    localDownLoaderComponent.init(new LiteDownloaderServiceBuilder.1(this, paramServiceAccessor));
    return localDownLoaderComponent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.components.download.LiteDownloaderServiceBuilder
 * JD-Core Version:    0.7.0.1
 */