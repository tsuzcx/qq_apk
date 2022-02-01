package com.tencent.image;

import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
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
    URL localURL = paramDownloadParams.url;
    try
    {
      paramDownloadParams = new File(localURL.toURI().getPath());
      return paramDownloadParams;
    }
    catch (NullPointerException paramDownloadParams)
    {
      for (;;)
      {
        paramDownloadParams.printStackTrace();
        return null;
        try
        {
          paramDownloadParams = new File(localURL.toString().replaceFirst("file:", ""));
        }
        catch (Exception paramDownloadParams)
        {
          if (URLDrawable.depImp.mLog.isColorLevel())
          {
            ILog localILog = URLDrawable.depImp.mLog;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("LocaleFileDownloader getFile error url:");
            localStringBuilder.append(localURL);
            localILog.e("URLDrawable_", 2, localStringBuilder.toString(), paramDownloadParams);
          }
          return null;
        }
      }
    }
    catch (URISyntaxException paramDownloadParams)
    {
      label29:
      break label29;
    }
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
    paramURLDrawableHandler = new StringBuilder();
    paramURLDrawableHandler.append("File not Found. url: ");
    paramURLDrawableHandler.append(paramDownloadParams.url);
    throw new IOException(paramURLDrawableHandler.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.LocaleFileDownloader
 * JD-Core Version:    0.7.0.1
 */