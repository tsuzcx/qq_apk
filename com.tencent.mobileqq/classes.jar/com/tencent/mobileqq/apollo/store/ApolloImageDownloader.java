package com.tencent.mobileqq.apollo.store;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class ApolloImageDownloader
  extends AbsDownloader
{
  public static int a;
  public static int b = 2;
  public static int c = 3;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public static URLDrawable a(String paramString1, URLDrawable.URLDrawableOptions paramURLDrawableOptions, String paramString2)
  {
    return a(false, paramString1, paramURLDrawableOptions, paramString2);
  }
  
  public static URLDrawable a(String paramString1, URLDrawable.URLDrawableOptions paramURLDrawableOptions, String paramString2, boolean paramBoolean)
  {
    return a(false, paramString1, paramURLDrawableOptions, paramString2, paramBoolean);
  }
  
  public static URLDrawable a(boolean paramBoolean, String paramString1, URLDrawable.URLDrawableOptions paramURLDrawableOptions, String paramString2)
  {
    return a(paramBoolean, paramString1, paramURLDrawableOptions, paramString2, false);
  }
  
  public static URLDrawable a(boolean paramBoolean1, String paramString1, URLDrawable.URLDrawableOptions paramURLDrawableOptions, String paramString2, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (!paramBoolean1) {}
    for (String str = ApolloConstant.g + "boxcard/" + paramString1;; str = paramString1)
    {
      File localFile = new File(str);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = paramURLDrawableOptions;
      if (paramURLDrawableOptions == null)
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mExtraInfo = null;
      }
      if (localURLDrawableOptions.mLoadingDrawable == null) {
        localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.a;
      }
      if (localURLDrawableOptions.mFailedDrawable == null) {
        localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.a;
      }
      if (localURLDrawableOptions.mExtraInfo == null) {
        localURLDrawableOptions.mExtraInfo = new ApolloImageDownloader.ApolloDrawableExtraInfo();
      }
      paramBoolean1 = paramBoolean2;
      if ((localURLDrawableOptions.mExtraInfo instanceof ApolloImageDownloader.ApolloDrawableExtraInfo))
      {
        paramURLDrawableOptions = (ApolloImageDownloader.ApolloDrawableExtraInfo)localURLDrawableOptions.mExtraInfo;
        if (!TextUtils.isEmpty(str)) {
          paramURLDrawableOptions.jdField_a_of_type_JavaLangString = str;
        }
        if (!TextUtils.isEmpty(paramString2)) {
          paramURLDrawableOptions.jdField_b_of_type_JavaLangString = paramString2;
        }
        if (paramURLDrawableOptions.jdField_a_of_type_Int != jdField_a_of_type_Int)
        {
          paramBoolean1 = paramBoolean2;
          if (!paramURLDrawableOptions.jdField_b_of_type_Boolean) {}
        }
        else
        {
          paramBoolean1 = true;
        }
      }
      if ((!paramBoolean1) && (localFile.exists()))
      {
        paramURLDrawableOptions = URLDrawable.getDrawable(localFile, localURLDrawableOptions);
        paramString1 = paramURLDrawableOptions;
        if (QLog.isColorLevel())
        {
          QLog.d("ApolloImageDownloader", 2, "getDrawable file exsit path->" + str + ",url:" + paramString2);
          paramString1 = paramURLDrawableOptions;
        }
      }
      for (;;)
      {
        return paramString1;
        try
        {
          paramString1 = URLDrawable.getDrawable(new URL("apollo_image", "", paramString1), localURLDrawableOptions);
        }
        catch (Exception paramString1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloImageDownloader", 2, paramString1.getMessage());
          }
          paramString1 = null;
        }
      }
    }
  }
  
  public static final String a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3) {
      return "http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_" + paramInt2 + "/task_detail.gif";
    }
    return "http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_item_" + paramInt2 + "/task_detail.png";
  }
  
  public static final String a(String paramString)
  {
    return "http://cmshow.gtimg.cn/client/img/" + paramString;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramURLDrawableHandler != null) {
      paramURLDrawableHandler.onFileDownloadStarted();
    }
    if ((paramDownloadParams.mExtraInfo != null) && ((paramDownloadParams.mExtraInfo instanceof ApolloImageDownloader.ApolloDrawableExtraInfo)))
    {
      paramOutputStream = (ApolloImageDownloader.ApolloDrawableExtraInfo)paramDownloadParams.mExtraInfo;
      paramDownloadParams = paramOutputStream.jdField_a_of_type_JavaLangString;
      paramOutputStream = paramOutputStream.jdField_b_of_type_JavaLangString;
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
        localDownloadTask.n = false;
        localDownloadTask.o = true;
        localDownloadTask.p = true;
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
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    Bitmap localBitmap = null;
    ApolloImageDownloader.ApolloDrawableExtraInfo localApolloDrawableExtraInfo;
    if ((paramFile != null) && (paramDownloadParams.mExtraInfo != null) && ((paramDownloadParams.mExtraInfo instanceof ApolloImageDownloader.ApolloDrawableExtraInfo)))
    {
      localApolloDrawableExtraInfo = (ApolloImageDownloader.ApolloDrawableExtraInfo)paramDownloadParams.mExtraInfo;
      if (localApolloDrawableExtraInfo.jdField_a_of_type_Int != jdField_a_of_type_Int) {
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
      } while (localApolloDrawableExtraInfo.jdField_a_of_type_Int != b);
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
            if (localApolloDrawableExtraInfo.jdField_a_of_type_Boolean)
            {
              i = 2130845866;
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
            int i = 2130845702;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloImageDownloader
 * JD-Core Version:    0.7.0.1
 */