package com.tencent.ilive.sorely;

import android.content.Context;
import com.tencent.falco.base.libapi.downloader.DownLoaderInterface;
import com.tencent.livesdk.servicefactory.ServiceFactory;

public class SoRelyUtil
{
  private static DownLoaderInterface downloader = null;
  
  public static DownLoaderInterface getDownloader(Context paramContext)
  {
    if (downloader != null) {
      return downloader;
    }
    DownLoaderInterface localDownLoaderInterface = (DownLoaderInterface)ServiceFactory.createService(paramContext, DownLoaderInterface.class);
    localDownLoaderInterface.init(new SoRelyUtil.1(paramContext));
    localDownLoaderInterface.onCreate(paramContext);
    downloader = localDownLoaderInterface;
    return localDownLoaderInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.sorely.SoRelyUtil
 * JD-Core Version:    0.7.0.1
 */