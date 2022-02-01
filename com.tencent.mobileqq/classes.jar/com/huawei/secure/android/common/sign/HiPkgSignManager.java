package com.huawei.secure.android.common.sign;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class HiPkgSignManager
{
  private static final String TAG = "HiPkgSignManager";
  
  private static String a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = b(MessageDigest.getInstance("SHA-256").digest(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      Log.e("HiPkgSignManager", "NoSuchAlgorithmException" + paramArrayOfByte.getMessage());
    }
    return "";
  }
  
  private static String b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    int j = paramArrayOfByte.length;
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < j)
    {
      if ((paramArrayOfByte[i] & 0xFF) < 16) {
        localStringBuffer.append("0" + Integer.toHexString(paramArrayOfByte[i] & 0xFF));
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append(Integer.toHexString(paramArrayOfByte[i] & 0xFF));
      }
    }
    return localStringBuffer.toString().toUpperCase(Locale.ENGLISH);
  }
  
  public static boolean doCheckArchiveApk(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (paramContext == null)) {}
    do
    {
      return false;
      paramString3 = paramContext.getPackageName();
      paramContext = getUnInstalledAppHash(paramContext, paramString2);
    } while ((TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramContext)) || (!paramString1.equals(paramContext.toUpperCase(Locale.ENGLISH))));
    return true;
  }
  
  public static boolean doCheckInstalled(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (paramContext == null)) {
      return false;
    }
    return paramString1.equals(getInstalledAppHash(paramContext, paramString2));
  }
  
  public static byte[] getInstalledAPPSignature(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      Log.e("HiPkgSignManager", "packageName is null or context is null");
      return new byte[0];
    }
    try
    {
      paramContext = paramContext.getPackageManager();
      if (paramContext != null)
      {
        paramContext = paramContext.getPackageInfo(paramString, 64);
        if (paramContext != null)
        {
          paramContext = paramContext.signatures[0].toByteArray();
          return paramContext;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.e("HiPkgSignManager", "PackageManager.NameNotFoundException : " + paramContext.getMessage());
    }
    return new byte[0];
  }
  
  public static String getInstalledAppHash(Context paramContext, String paramString)
  {
    String str = "";
    paramString = getInstalledAPPSignature(paramContext, paramString);
    paramContext = str;
    if (paramString != null)
    {
      paramContext = str;
      if (paramString.length > 0) {
        paramContext = a(paramString);
      }
    }
    return paramContext;
  }
  
  public static byte[] getUnInstalledAPPSignature(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      Log.e("HiPkgSignManager", "archiveFilePath is null or context is null");
      return new byte[0];
    }
    try
    {
      paramContext = paramContext.getPackageManager();
      if (paramContext != null)
      {
        paramContext = paramContext.getPackageArchiveInfo(paramString, 64);
        if (paramContext != null)
        {
          paramContext = paramContext.signatures[0].toByteArray();
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      Log.e("HiPkgSignManager", "getUnInstalledAPPSignature exception : " + paramContext.getMessage());
    }
    return new byte[0];
  }
  
  public static String getUnInstalledAppHash(Context paramContext, String paramString)
  {
    String str = "";
    paramString = getUnInstalledAPPSignature(paramContext, paramString);
    paramContext = str;
    if (paramString != null)
    {
      paramContext = str;
      if (paramString.length > 0) {
        paramContext = a(paramString);
      }
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.sign.HiPkgSignManager
 * JD-Core Version:    0.7.0.1
 */