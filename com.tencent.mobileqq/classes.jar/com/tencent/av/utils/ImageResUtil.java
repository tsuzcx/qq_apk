package com.tencent.av.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.QavImageHandler;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ImageResUtil
{
  public static Bitmap a(AppInterface paramAppInterface, String paramString)
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        str = a() + MD5.toMD5(paramString) + ".png";
        if (!FileUtil.a(str))
        {
          boolean bool = HttpDownloadUtil.a(paramAppInterface, paramString, new File(str));
          if (QLog.isColorLevel()) {
            QLog.d("ImageUtil", 2, "[ImageResUtil] download bitmap from url=" + paramString + ", path=" + str + ", ret=" + bool);
          }
          bool = FileUtil.a(str);
          paramAppInterface = localObject;
          if (!bool) {}
        }
      }
      catch (Exception paramAppInterface)
      {
        String str;
        return null;
      }
      catch (OutOfMemoryError paramAppInterface) {}
      try
      {
        paramAppInterface = BitmapFactory.decodeFile(str);
        return paramAppInterface;
      }
      catch (OutOfMemoryError paramAppInterface)
      {
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ImageUtil", 2, "[ImageResUtil] already exited: " + str);
      }
    }
    return null;
  }
  
  public static String a()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ImageUtil", 2, "[image download] getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/qav/image_download/";
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ImageUtil", 2, "[image early] trigger early download");
    }
    paramQQAppInterface = (EarlyDownloadManager)paramQQAppInterface.getManager(76);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (QavImageHandler)paramQQAppInterface.a("qq.android.qav.image2");
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(false);
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    return new File(b(), paramString).exists();
  }
  
  public static String b()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ImageUtil", 2, "[image early] getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/qav/image_early/";
  }
  
  public static String c()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ImageUtil", 2, "[video early] getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/qav/video_early/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.utils.ImageResUtil
 * JD-Core Version:    0.7.0.1
 */