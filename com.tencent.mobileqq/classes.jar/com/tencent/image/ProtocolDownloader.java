package com.tencent.image;

import java.io.File;
import java.net.URL;

public abstract interface ProtocolDownloader
{
  public abstract Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler);
  
  public abstract JobQueue getQueue(URL paramURL);
  
  public abstract boolean gifHasDifferentState();
  
  public abstract boolean hasDiskFile(DownloadParams paramDownloadParams);
  
  public abstract File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.ProtocolDownloader
 * JD-Core Version:    0.7.0.1
 */