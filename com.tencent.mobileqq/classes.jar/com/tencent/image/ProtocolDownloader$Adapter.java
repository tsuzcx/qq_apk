package com.tencent.image;

import java.io.File;
import java.net.URL;

public abstract class ProtocolDownloader$Adapter
  implements ProtocolDownloader
{
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return null;
  }
  
  public JobQueue getQueue(URL paramURL)
  {
    return null;
  }
  
  public boolean gifHasDifferentState()
  {
    return false;
  }
  
  public boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    return false;
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.ProtocolDownloader.Adapter
 * JD-Core Version:    0.7.0.1
 */