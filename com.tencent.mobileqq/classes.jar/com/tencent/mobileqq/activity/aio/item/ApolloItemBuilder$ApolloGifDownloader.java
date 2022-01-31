package com.tencent.mobileqq.activity.aio.item;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import java.io.File;
import java.io.OutputStream;

public class ApolloItemBuilder$ApolloGifDownloader
  extends AbsDownloader
{
  public static final String a(int paramInt)
  {
    return ApolloConstant.c + paramInt + "/panelGif.gif";
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramURLDrawableHandler != null) {
      paramURLDrawableHandler.onFileDownloadStarted();
    }
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof Integer)))
    {
      paramDownloadParams = (Integer)paramDownloadParams.tag;
      paramOutputStream = new File(a(paramDownloadParams.intValue()));
      if (paramOutputStream.exists())
      {
        if (paramURLDrawableHandler != null) {
          paramURLDrawableHandler.onFileDownloadSucceed(paramOutputStream.length());
        }
        return paramOutputStream;
      }
      paramOutputStream.getParentFile().mkdirs();
      if ((BaseApplicationImpl.sApplication != null) && (!NetworkUtil.g(BaseApplicationImpl.sApplication)) && (paramURLDrawableHandler != null)) {
        paramURLDrawableHandler.onFileDownloadFailed(0);
      }
      paramDownloadParams = new DownloadTask("http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_" + paramDownloadParams + "/preview.gif", paramOutputStream);
      paramDownloadParams.b = 1;
      paramDownloadParams.n = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.ApolloGifDownloader
 * JD-Core Version:    0.7.0.1
 */