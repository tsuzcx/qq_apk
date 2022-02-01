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
    LogInterface localLogInterface = (LogInterface)this.val$serviceManager.getService(LogInterface.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadingCancelled url = ");
    localStringBuilder.append(paramString);
    localLogInterface.e("ImageLoaderServiceBuild", localStringBuilder.toString(), new Object[0]);
  }
  
  public void onLoadingComplete(String paramString) {}
  
  public void onLoadingFailed(String paramString1, String paramString2)
  {
    LogInterface localLogInterface = (LogInterface)this.val$serviceManager.getService(LogInterface.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadingFailed url = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", failReason = ");
    localStringBuilder.append(paramString2);
    localLogInterface.e("ImageLoaderServiceBuild", localStringBuilder.toString(), new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.imageloader.ImageLoaderServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */