package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.InputStream;

class ImageLoaderConfiguration$NetworkDeniedImageDownloader
  implements ImageDownloader
{
  private final ImageDownloader wrappedDownloader;
  
  public ImageLoaderConfiguration$NetworkDeniedImageDownloader(ImageDownloader paramImageDownloader)
  {
    this.wrappedDownloader = paramImageDownloader;
  }
  
  public InputStream getStream(String paramString, Object paramObject)
  {
    int i = ImageLoaderConfiguration.1.$SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.ofUri(paramString).ordinal()];
    if ((i != 1) && (i != 2)) {
      return this.wrappedDownloader.getStream(paramString, paramObject);
    }
    throw new IllegalStateException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.ImageLoaderConfiguration.NetworkDeniedImageDownloader
 * JD-Core Version:    0.7.0.1
 */