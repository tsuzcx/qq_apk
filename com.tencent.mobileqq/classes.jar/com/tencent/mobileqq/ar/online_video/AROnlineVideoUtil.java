package com.tencent.mobileqq.ar.online_video;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.util.Pair;
import java.io.File;

public class AROnlineVideoUtil
{
  public static volatile ISPlayerPreDownloader a;
  
  public static Pair<Long, String> a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseFileSize, str=");
      localStringBuilder.append(paramString);
      QLog.d("AROnlineVideoUtil", 2, localStringBuilder.toString());
    }
    boolean bool = TextUtils.isEmpty(paramString);
    StringBuilder localStringBuilder = null;
    if (bool) {
      return null;
    }
    String[] arrayOfString = paramString.split("\\|");
    paramString = localStringBuilder;
    if (arrayOfString != null)
    {
      if (arrayOfString.length != 2) {
        return null;
      }
      long l;
      try
      {
        l = Long.parseLong(arrayOfString[0]);
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          paramString.printStackTrace();
        }
        l = -1L;
      }
      if (l == -1L) {
        return null;
      }
      paramString = new Pair(Long.valueOf(l), arrayOfString[1]);
    }
    return paramString;
  }
  
  private static String a()
  {
    if (SystemUtil.a())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_PATH);
      localStringBuilder.append("iar");
      localStringBuilder.append(File.separator);
      return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("iar");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = MD5Utils.toMD5(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a());
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("AROnlineVideoUtil", 2, "getStorageDir, Exception");
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static void a()
  {
    if (a != null)
    {
      a.destory();
      a = null;
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    int i = NetworkUtil.getNetworkType(BaseApplication.getContext());
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("preload, isWifi=");
      paramContext.append(bool);
      QLog.d("AROnlineVideoUtil", 2, paramContext.toString());
    }
  }
  
  public static void a(Context paramContext, ArVideoResourceInfo paramArVideoResourceInfo)
  {
    if ((paramArVideoResourceInfo != null) && (!TextUtils.isEmpty(paramArVideoResourceInfo.jdField_d_of_type_JavaLangString)))
    {
      if (paramArVideoResourceInfo.jdField_d_of_type_Int != 4) {
        return;
      }
      int i = NetworkUtil.getNetworkType(BaseApplication.getContext());
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("preload for multi, isWifi=");
        paramContext.append(bool);
        QLog.d("AROnlineVideoUtil", 2, paramContext.toString());
      }
      if (!bool) {
        return;
      }
      if (a == null) {
        a = SuperPlayerFactory.createPreDownloader(BaseApplicationImpl.getApplication(), 108);
      }
      if (!TextUtils.isEmpty(paramArVideoResourceInfo.jdField_d_of_type_JavaLangString))
      {
        paramContext = paramArVideoResourceInfo.jdField_d_of_type_JavaLangString;
        String str = a(paramContext);
        bool = a(str);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("preload for multi, url=");
          localStringBuilder.append(paramContext);
          localStringBuilder.append(", videoPath=");
          localStringBuilder.append(str);
          localStringBuilder.append(", isCached=");
          localStringBuilder.append(bool);
          QLog.d("AROnlineVideoUtil", 2, localStringBuilder.toString());
        }
        paramContext = SuperPlayerFactory.createVideoInfoForUrl(paramContext, 101, MD5Utils.toMD5(paramContext));
        if (paramArVideoResourceInfo.a > 4L) {
          a.startPreDownload(paramContext, paramArVideoResourceInfo.a / 4L);
        }
      }
    }
  }
  
  private static boolean a(String paramString)
  {
    paramString = new File(paramString);
    return (paramString.exists()) && (paramString.length() > 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.online_video.AROnlineVideoUtil
 * JD-Core Version:    0.7.0.1
 */