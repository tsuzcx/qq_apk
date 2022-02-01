package com.tencent.mobileqq.apollo.res.api.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.apollo.res.api.IApolloGifDownloader;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import java.io.File;
import java.io.OutputStream;

public class ApolloGifDownloaderImpl
  extends AbsDownloader
  implements IApolloGifDownloader
{
  public static final String getApolloGifFilePath(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("/panelGif.gif");
    return localStringBuilder.toString();
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramURLDrawableHandler != null) {
      paramURLDrawableHandler.onFileDownloadStarted();
    }
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof Integer)))
    {
      paramDownloadParams = (Integer)paramDownloadParams.tag;
      paramOutputStream = new File(getApolloGifFilePath(paramDownloadParams.intValue()));
      if (paramOutputStream.exists())
      {
        if (paramURLDrawableHandler != null) {
          paramURLDrawableHandler.onFileDownloadSucceed(paramOutputStream.length());
        }
        return paramOutputStream;
      }
      paramOutputStream.getParentFile().mkdirs();
      if ((BaseApplicationImpl.sApplication != null) && (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.sApplication)) && (paramURLDrawableHandler != null)) {
        paramURLDrawableHandler.onFileDownloadFailed(0);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_");
      localStringBuilder.append(paramDownloadParams);
      localStringBuilder.append("/preview.gif");
      paramDownloadParams = new DownloadTask(localStringBuilder.toString(), paramOutputStream);
      paramDownloadParams.b = 1;
      paramDownloadParams.p = false;
      if (DownloaderFactory.a(paramDownloadParams, null) == 0)
      {
        if (paramURLDrawableHandler != null) {
          paramURLDrawableHandler.onFileDownloadSucceed(paramOutputStream.length());
        }
        return paramOutputStream;
      }
    }
    if (paramURLDrawableHandler != null) {
      paramURLDrawableHandler.onFileDownloadFailed(0);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloGifDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */