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
  private static boolean a;
  private static String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "portrait/");
    b = null;
    jdField_a_of_type_Boolean = false;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return Math.min(1080, Math.min(paramInt1, paramInt2) - 10);
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString).append("temp").append("/").append(System.currentTimeMillis()).append("_portrait.tmp");
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = MD5.toMD5(MD5.toMD5(MD5.toMD5(paramString)));
    localStringBuilder.append(jdField_a_of_type_JavaLangString).append("HDAvatar").append("/").append(paramString).append(".jpg");
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FaceUtil", 2, "initAvatarUploadState");
    }
    jdField_a_of_type_Boolean = false;
    b = null;
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("mobileQQ", 0).edit().putBoolean("save_qqhead_to_app_storage", paramBoolean).commit();
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FaceUtil", 2, String.format("setTempAvatarFilePath filePath=%s", new Object[] { paramString }));
    }
    if (TextUtils.isEmpty(paramString))
    {
      jdField_a_of_type_Boolean = false;
      return;
    }
    b = paramString;
    jdField_a_of_type_Boolean = true;
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    try
    {
      URL localURL = new URL("profile_img_thumb", null, ((IQQAvatarDataService)paramAppRuntime.getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePath(false, paramString));
      ((IQQAvatarDataService)paramAppRuntime.getRuntimeService(IQQAvatarDataService.class, "")).removeBitmapFromCache(localURL.toString());
      localURL = new URL("profile_img_big", null, a(paramString));
      ((IQQAvatarDataService)paramAppRuntime.getRuntimeService(IQQAvatarDataService.class, "")).removeBitmapFromCache(localURL.toString());
      paramString = new URL("profile_img_big_fhd", null, b(paramString));
      ((IQQAvatarDataService)paramAppRuntime.getRuntimeService(IQQAvatarDataService.class, "")).removeBitmapFromCache(paramString.toString());
      return;
    }
    catch (Exception paramAppRuntime)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("FaceUtil", 2, "", paramAppRuntime);
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getSharedPreferences("mobileQQ", 0).getBoolean("save_qqhead_to_app_storage", false);
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    paramString = a(paramString);
    try
    {
      paramString = new File(paramString);
      bool1 = bool2;
      if (paramString.exists()) {
        bool1 = paramString.delete();
      }
    }
    catch (Exception paramString)
    {
      do
      {
        boolean bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("FaceUtil", 2, paramString.toString());
    }
    return bool1;
    return false;
  }
  
  public static String b()
  {
    return b;
  }
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = MD5.toMD5(MD5.toMD5(MD5.toMD5(paramString)));
    localStringBuilder.append(jdField_a_of_type_JavaLangString).append("FHDAvatar").append("/").append(paramString).append(".jpg");
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static boolean b(String paramString)
  {
    boolean bool2 = false;
    paramString = b(paramString);
    try
    {
      paramString = new File(paramString);
      bool1 = bool2;
      if (paramString.exists()) {
        bool1 = paramString.delete();
      }
    }
    catch (Exception paramString)
    {
      do
      {
        boolean bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("FaceUtil", 2, "clearFHDAvatar " + paramString.toString());
    }
    return bool1;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.util.FaceUtil
 * JD-Core Version:    0.7.0.1
 */