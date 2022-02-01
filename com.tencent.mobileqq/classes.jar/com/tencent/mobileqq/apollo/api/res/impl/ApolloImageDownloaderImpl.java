package com.tencent.mobileqq.apollo.api.res.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.apollo.api.model.ApolloDrawableExtraInfo;
import com.tencent.mobileqq.apollo.api.res.IApolloImageDownloader;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
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
  private static final String TAG = "ApolloImageDownloader";
  
  public static boolean preloadUrlImage(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    }
    String str;
    do
    {
      return bool;
      str = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/" + paramString.substring(paramString.lastIndexOf("/") + 1);
    } while (new File(str).exists());
    paramString = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(true, str, null, paramString, true);
    if (paramString != null) {
      paramString.startDownload();
    }
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    Bitmap localBitmap = null;
    ApolloDrawableExtraInfo localApolloDrawableExtraInfo;
    if ((paramFile != null) && (paramDownloadParams.mExtraInfo != null) && ((paramDownloadParams.mExtraInfo instanceof ApolloDrawableExtraInfo)))
    {
      localApolloDrawableExtraInfo = (ApolloDrawableExtraInfo)paramDownloadParams.mExtraInfo;
      if (localApolloDrawableExtraInfo.mDrawableType != ApolloConstant.h) {
        break label102;
      }
    }
    for (;;)
    {
      try
      {
        localBitmap = SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath());
        localBitmap = ImageUtil.a(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        paramFile = localBitmap;
        return paramFile;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloImageDownloader", 2, localThrowable.getMessage());
        }
      }
      label102:
      do
      {
        return super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
      } while (localApolloDrawableExtraInfo.mDrawableType != ApolloConstant.i);
      if (paramFile.exists())
      {
        paramURLDrawableHandler = new BitmapFactory.Options();
        paramURLDrawableHandler.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramFile.getPath(), paramURLDrawableHandler);
        paramURLDrawableHandler.inSampleSize = ImageUtil.a(paramURLDrawableHandler, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight);
        paramURLDrawableHandler.inJustDecodeBounds = false;
        paramURLDrawableHandler.inPreferredConfig = Bitmap.Config.RGB_565;
        try
        {
          paramFile = BitmapFactory.decodeFile(paramFile.getPath(), paramURLDrawableHandler);
          if (paramFile != null) {
            if (localApolloDrawableExtraInfo.isSend)
            {
              i = 2130850408;
              paramDownloadParams = ImageUtil.a(paramFile, i, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, true);
              paramFile = paramDownloadParams;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("ApolloImageDownloader", 2, "ApolloItemBuilder decodeFile bgBitmap:" + paramDownloadParams);
              return paramDownloadParams;
            }
          }
        }
        catch (OutOfMemoryError paramFile)
        {
          for (;;)
          {
            QLog.e("ApolloImageDownloader", 1, "decode server pic oom!!");
            System.gc();
            paramFile = localThrowable;
            continue;
            int i = 2130850232;
          }
          paramDownloadParams = paramFile;
        }
      }
    }
    for (;;)
    {
      paramFile = paramDownloadParams;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloImageDownloader", 2, "ApolloItemBuilder decodeFile bgBitmap:" + paramDownloadParams);
      return paramDownloadParams;
      paramDownloadParams = null;
    }
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramURLDrawableHandler != null) {
      paramURLDrawableHandler.onFileDownloadStarted();
    }
    if ((paramDownloadParams.mExtraInfo != null) && ((paramDownloadParams.mExtraInfo instanceof ApolloDrawableExtraInfo)))
    {
      paramOutputStream = (ApolloDrawableExtraInfo)paramDownloadParams.mExtraInfo;
      paramDownloadParams = paramOutputStream.mLocalPath;
      paramOutputStream = paramOutputStream.mDownloadUrl;
      paramDownloadParams = new File(paramDownloadParams);
      if (paramDownloadParams.exists())
      {
        if (paramURLDrawableHandler != null) {
          paramURLDrawableHandler.onFileDownloadSucceed(paramDownloadParams.length());
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloImageDownloader", 2, "downloadImage file exsit url->" + paramOutputStream);
        }
      }
      int i;
      do
      {
        return paramDownloadParams;
        paramDownloadParams.getParentFile().mkdirs();
        if ((BaseApplicationImpl.sApplication != null) && (!NetworkUtil.g(BaseApplicationImpl.sApplication)) && (paramURLDrawableHandler != null)) {
          paramURLDrawableHandler.onFileDownloadFailed(0);
        }
        DownloadTask localDownloadTask = new DownloadTask(paramOutputStream, paramDownloadParams);
        localDownloadTask.b = 1;
        localDownloadTask.p = false;
        localDownloadTask.q = true;
        localDownloadTask.r = true;
        i = DownloaderFactory.a(localDownloadTask, null);
        if (i != 0) {
          break;
        }
        if (paramURLDrawableHandler != null) {
          paramURLDrawableHandler.onFileDownloadSucceed(paramDownloadParams.length());
        }
      } while (!QLog.isColorLevel());
      QLog.d("ApolloImageDownloader", 2, "url->" + paramOutputStream + " result->0");
      return paramDownloadParams;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloImageDownloader", 2, "url->" + paramOutputStream + " result->" + i);
      }
    }
    if (paramURLDrawableHandler != null) {
      paramURLDrawableHandler.onFileDownloadFailed(0);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.ApolloImageDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */