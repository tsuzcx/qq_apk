package com.tencent.av.utils;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.QavImageHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ImageResUtil
{
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
    paramQQAppInterface = (EarlyDownloadManager)paramQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.ImageResUtil
 * JD-Core Version:    0.7.0.1
 */