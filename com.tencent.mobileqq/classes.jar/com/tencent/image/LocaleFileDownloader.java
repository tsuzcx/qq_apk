package com.tencent.image;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class LocaleFileDownloader
  extends ProtocolDownloader.Adapter
{
  public File getFile(DownloadParams paramDownloadParams)
  {
    paramDownloadParams = paramDownloadParams.url;
    try
    {
      File localFile1 = new File(paramDownloadParams.toURI().getPath());
      return localFile1;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      try
      {
        File localFile2 = new File(paramDownloadParams.toString().replaceFirst("file:", ""));
        return localFile2;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("URLDrawable_", 2, "LocaleFileDownloader getFile error url:" + paramDownloadParams, localException);
        }
        return null;
      }
    }
    catch (NullPointerException paramDownloadParams)
    {
      paramDownloadParams.printStackTrace();
    }
    return null;
  }
  
  public boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    paramDownloadParams = getFile(paramDownloadParams);
    return (paramDownloadParams != null) && (paramDownloadParams.exists());
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = getFile(paramDownloadParams);
    if ((paramURLDrawableHandler != null) && (paramURLDrawableHandler.exists())) {
      return paramURLDrawableHandler;
    }
    throw new IOException("File not Found. url: " + paramDownloadParams.url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.LocaleFileDownloader
 * JD-Core Version:    0.7.0.1
 */