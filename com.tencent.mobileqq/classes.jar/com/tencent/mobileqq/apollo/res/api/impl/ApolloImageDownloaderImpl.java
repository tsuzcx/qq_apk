package com.tencent.mobileqq.apollo.res.api.impl;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.apollo.model.ApolloDrawableExtraInfo;
import com.tencent.mobileqq.apollo.res.api.IApolloImageDownloader;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;

public class ApolloImageDownloaderImpl
  extends AbsDownloader
  implements IApolloImageDownloader
{
  private static final String TAG = "[cmshow]ApolloImageDownloader";
  
  public static boolean preloadUrlImage(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/");
    ((StringBuilder)localObject).append(paramString.substring(paramString.lastIndexOf("/") + 1));
    localObject = ((StringBuilder)localObject).toString();
    if (new File((String)localObject).exists()) {
      return true;
    }
    paramString = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(true, (String)localObject, null, paramString, true);
    if (paramString != null) {
      paramString.startDownload();
    }
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramFile != null) && ((paramDownloadParams.mExtraInfo instanceof ApolloDrawableExtraInfo)))
    {
      if (((ApolloDrawableExtraInfo)paramDownloadParams.mExtraInfo).mDrawableType == ApolloConstant.g) {
        try
        {
          Bitmap localBitmap = SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath());
          localBitmap = ImageUtil.a(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          return localBitmap;
        }
        catch (Throwable localThrowable)
        {
          QLog.e("[cmshow]ApolloImageDownloader", 1, localThrowable.getMessage());
        }
      }
      return super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
    }
    return super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramURLDrawableHandler != null) {
      paramURLDrawableHandler.onFileDownloadStarted();
    }
    if (!(paramDownloadParams.mExtraInfo instanceof ApolloDrawableExtraInfo))
    {
      if (paramURLDrawableHandler != null) {
        paramURLDrawableHandler.onFileDownloadFailed(0);
      }
      return null;
    }
    paramOutputStream = (ApolloDrawableExtraInfo)paramDownloadParams.mExtraInfo;
    paramDownloadParams = paramOutputStream.mLocalPath;
    paramOutputStream = paramOutputStream.mDownloadUrl;
    paramDownloadParams = new File(paramDownloadParams);
    if (paramDownloadParams.exists())
    {
      if (paramURLDrawableHandler != null) {
        paramURLDrawableHandler.onFileDownloadSucceed(paramDownloadParams.length());
      }
      if (QLog.isColorLevel())
      {
        paramURLDrawableHandler = new StringBuilder();
        paramURLDrawableHandler.append("downloadImage file exsit url->");
        paramURLDrawableHandler.append(paramOutputStream);
        QLog.d("[cmshow]ApolloImageDownloader", 2, paramURLDrawableHandler.toString());
      }
      return paramDownloadParams;
    }
    paramDownloadParams.getParentFile().mkdirs();
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.sApplication))
    {
      if (paramURLDrawableHandler != null) {
        paramURLDrawableHandler.onFileDownloadFailed(0);
      }
      return null;
    }
    DownloadTask localDownloadTask = new DownloadTask(paramOutputStream, paramDownloadParams);
    localDownloadTask.b = 1;
    localDownloadTask.p = false;
    localDownloadTask.q = true;
    localDownloadTask.r = true;
    int i = DownloaderFactory.a(localDownloadTask, null);
    if (i == 0)
    {
      if (paramURLDrawableHandler != null) {
        paramURLDrawableHandler.onFileDownloadSucceed(paramDownloadParams.length());
      }
      if (QLog.isColorLevel())
      {
        paramURLDrawableHandler = new StringBuilder();
        paramURLDrawableHandler.append("url->");
        paramURLDrawableHandler.append(paramOutputStream);
        paramURLDrawableHandler.append(" result->0");
        QLog.d("[cmshow]ApolloImageDownloader", 2, paramURLDrawableHandler.toString());
      }
      return paramDownloadParams;
    }
    if (QLog.isColorLevel())
    {
      paramDownloadParams = new StringBuilder();
      paramDownloadParams.append("url->");
      paramDownloadParams.append(paramOutputStream);
      paramDownloadParams.append(" result->");
      paramDownloadParams.append(i);
      QLog.d("[cmshow]ApolloImageDownloader", 2, paramDownloadParams.toString());
    }
    if (paramURLDrawableHandler != null) {
      paramURLDrawableHandler.onFileDownloadFailed(0);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloImageDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */