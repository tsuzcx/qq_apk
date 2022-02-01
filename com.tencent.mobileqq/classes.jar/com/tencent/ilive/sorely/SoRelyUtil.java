package com.tencent.ilive.sorely;

import android.content.Context;
import com.tencent.falco.base.libapi.downloader.DownLoaderInterface;
import com.tencent.livesdk.servicefactory.ServiceFactory;

public class SoRelyUtil
{
  private static DownLoaderInterface downloader;
  
  public static DownLoaderInterface getDownloader(Context paramContext)
  {
    DownLoaderInterface localDownLoaderInterface = downloader;
    if (localDownLoaderInterface != null) {
      return localDownLoaderInterface;
    }
    localDownLoaderInterface = (DownLoaderInterface)ServiceFactory.createService(paramContext, DownLoaderInterface.class);
    localDownLoaderInterface.init(new SoRelyUtil.1(paramContext));
    localDownLoaderInterface.onCreate(paramContext);
    downloader = localDownLoaderInterface;
    return localDownLoaderInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.sorely.SoRelyUtil
 * JD-Core Version:    0.7.0.1
 */