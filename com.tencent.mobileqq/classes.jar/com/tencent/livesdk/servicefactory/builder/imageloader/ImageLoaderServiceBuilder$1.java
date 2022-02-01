package com.tencent.livesdk.servicefactory.builder.imageloader;

import com.tencent.falco.base.libapi.imageloader.ImageOnLoadingLogListener;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class ImageLoaderServiceBuilder$1
  implements ImageOnLoadingLogListener
{
  ImageLoaderServiceBuilder$1(ImageLoaderServiceBuilder paramImageLoaderServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public void onLoadingCancelled(String paramString)
  {
    ((LogInterface)this.val$serviceManager.getService(LogInterface.class)).e("ImageLoaderServiceBuild", "onLoadingCancelled url = " + paramString, new Object[0]);
  }
  
  public void onLoadingComplete(String paramString) {}
  
  public void onLoadingFailed(String paramString1, String paramString2)
  {
    ((LogInterface)this.val$serviceManager.getService(LogInterface.class)).e("ImageLoaderServiceBuild", "onLoadingFailed url = " + paramString1 + ", failReason = " + paramString2, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.imageloader.ImageLoaderServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */