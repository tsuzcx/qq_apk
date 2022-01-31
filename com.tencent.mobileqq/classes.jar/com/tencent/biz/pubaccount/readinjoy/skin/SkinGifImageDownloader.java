package com.tencent.biz.pubaccount.readinjoy.skin;

import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.transfile.AbsDownloader;
import java.io.File;
import java.io.OutputStream;
import maz;

public class SkinGifImageDownloader
  extends AbsDownloader
{
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams = paramDownloadParams.urlStr;
    if (paramDownloadParams.startsWith("readinjoy_skin_gif://")) {
      paramOutputStream = paramDownloadParams.replace("readinjoy_skin_gif://", "");
    }
    for (;;)
    {
      paramOutputStream = new File(paramOutputStream);
      if (!paramOutputStream.exists()) {
        break;
      }
      return paramOutputStream;
      paramOutputStream = paramDownloadParams;
      if (paramDownloadParams.startsWith("readinjoy_skin_gif:")) {
        paramOutputStream = paramDownloadParams.replace("readinjoy_skin_gif:", "");
      }
    }
    return null;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new maz(this, paramFile, false, false, 0, 0, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.SkinGifImageDownloader
 * JD-Core Version:    0.7.0.1
 */