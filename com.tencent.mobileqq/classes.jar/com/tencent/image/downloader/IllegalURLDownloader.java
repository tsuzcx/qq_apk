package com.tencent.image.downloader;

import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import java.io.File;

public class IllegalURLDownloader
  extends ProtocolDownloader.Adapter
{
  public static final String ILLEGAL_URL = "illegalurl";
  
  public boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    return true;
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.downloader.IllegalURLDownloader
 * JD-Core Version:    0.7.0.1
 */