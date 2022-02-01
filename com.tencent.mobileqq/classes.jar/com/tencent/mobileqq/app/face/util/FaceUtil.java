package com.tencent.mobileqq.app.face.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import mqq.app.AppRuntime;

public class FaceUtil
{
  public static final String a;
  private static String b = null;
  private static boolean c = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("portrait/");
    a = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return Math.min(1080, Math.min(paramInt1, paramInt2) - 10);
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("temp");
    localStringBuilder.append("/");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("_portrait.tmp");
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("mobileQQ", 0).edit().putBoolean("save_qqhead_to_app_storage", paramBoolean).commit();
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    try
    {
      URL localURL = new URL("profile_img_thumb", null, ((IQQAvatarDataService)paramAppRuntime.getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePath(false, paramString));
      ((IQQAvatarDataService)paramAppRuntime.getRuntimeService(IQQAvatarDataService.class, "")).removeBitmapFromCache(localURL.toString());
      localURL = new URL("profile_img_big", null, b(paramString));
      ((IQQAvatarDataService)paramAppRuntime.getRuntimeService(IQQAvatarDataService.class, "")).removeBitmapFromCache(localURL.toString());
      paramString = new URL("profile_img_big_fhd", null, c(paramString));
      ((IQQAvatarDataService)paramAppRuntime.getRuntimeService(IQQAvatarDataService.class, "")).removeBitmapFromCache(paramString.toString());
      return;
    }
    catch (Exception paramAppRuntime)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FaceUtil", 2, "", paramAppRuntime);
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getSharedPreferences("mobileQQ", 0).getBoolean("save_qqhead_to_app_storage", false);
  }
  
  public static boolean a(String paramString)
  {
    paramString = b(paramString);
    try
    {
      paramString = new File(paramString);
      if (paramString.exists())
      {
        boolean bool = paramString.delete();
        return bool;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceUtil", 2, paramString.toString());
      }
    }
    return false;
  }
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = MD5.toMD5(MD5.toMD5(MD5.toMD5(paramString)));
    localStringBuilder.append(a);
    localStringBuilder.append("HDAvatar");
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".jpg");
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static boolean b()
  {
    return c;
  }
  
  public static String c()
  {
    return b;
  }
  
  public static String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = MD5.toMD5(MD5.toMD5(MD5.toMD5(paramString)));
    localStringBuilder.append(a);
    localStringBuilder.append("FHDAvatar");
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".jpg");
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FaceUtil", 2, "initAvatarUploadState");
    }
    c = false;
    b = null;
  }
  
  public static boolean d(String paramString)
  {
    paramString = c(paramString);
    try
    {
      paramString = new File(paramString);
      if (paramString.exists())
      {
        boolean bool = paramString.delete();
        return bool;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("clearFHDAvatar ");
        localStringBuilder.append(paramString.toString());
        QLog.d("FaceUtil", 2, localStringBuilder.toString());
      }
    }
    return false;
  }
  
  public static void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FaceUtil", 2, String.format("setTempAvatarFilePath filePath=%s", new Object[] { paramString }));
    }
    if (TextUtils.isEmpty(paramString))
    {
      c = false;
      return;
    }
    b = paramString;
    c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.util.FaceUtil
 * JD-Core Version:    0.7.0.1
 */