package com.huawei.secure.android.common;

import android.content.Context;

@Deprecated
public abstract class HiPkgSignManager
{
  @Deprecated
  public static boolean doCheckArchiveApk(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return com.huawei.secure.android.common.sign.HiPkgSignManager.doCheckArchiveApk(paramContext, paramString1, paramString2, paramString3);
  }
  
  @Deprecated
  public static boolean doCheckInstalled(Context paramContext, String paramString1, String paramString2)
  {
    return com.huawei.secure.android.common.sign.HiPkgSignManager.doCheckInstalled(paramContext, paramString1, paramString2);
  }
  
  @Deprecated
  public static byte[] getInstalledAPPSignature(Context paramContext, String paramString)
  {
    return com.huawei.secure.android.common.sign.HiPkgSignManager.getInstalledAPPSignature(paramContext, paramString);
  }
  
  @Deprecated
  public static String getInstalledAppHash(Context paramContext, String paramString)
  {
    return com.huawei.secure.android.common.sign.HiPkgSignManager.getInstalledAppHash(paramContext, paramString);
  }
  
  @Deprecated
  public static byte[] getUnInstalledAPPSignature(Context paramContext, String paramString)
  {
    return com.huawei.secure.android.common.sign.HiPkgSignManager.getUnInstalledAPPSignature(paramContext, paramString);
  }
  
  @Deprecated
  public static String getUnInstalledAppHash(Context paramContext, String paramString)
  {
    return com.huawei.secure.android.common.sign.HiPkgSignManager.getUnInstalledAppHash(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.HiPkgSignManager
 * JD-Core Version:    0.7.0.1
 */