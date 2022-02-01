package com.tencent.image;

import java.io.File;

public class QQLiveDownloader
  extends ProtocolDownloader.Adapter
{
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new QQLiveImage(paramDownloadParams.urlStr, paramDownloadParams.mExtraInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.QQLiveDownloader
 * JD-Core Version:    0.7.0.1
 */