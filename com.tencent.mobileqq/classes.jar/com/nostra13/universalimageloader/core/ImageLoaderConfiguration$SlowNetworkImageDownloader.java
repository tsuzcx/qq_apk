package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.assist.FlushedInputStream;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.InputStream;

class ImageLoaderConfiguration$SlowNetworkImageDownloader
  implements ImageDownloader
{
  private final ImageDownloader wrappedDownloader;
  
  public ImageLoaderConfiguration$SlowNetworkImageDownloader(ImageDownloader paramImageDownloader)
  {
    this.wrappedDownloader = paramImageDownloader;
  }
  
  public InputStream getStream(String paramString, Object paramObject)
  {
    paramObject = this.wrappedDownloader.getStream(paramString, paramObject);
    int i = ImageLoaderConfiguration.1.$SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.ofUri(paramString).ordinal()];
    if ((i != 1) && (i != 2)) {
      return paramObject;
    }
    return new FlushedInputStream(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.ImageLoaderConfiguration.SlowNetworkImageDownloader
 * JD-Core Version:    0.7.0.1
 */