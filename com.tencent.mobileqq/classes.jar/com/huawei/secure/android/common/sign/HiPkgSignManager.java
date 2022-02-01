package com.huawei.secure.android.common.sign;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.secure.android.common.util.LogsUtil;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NoSuchAlgorithmException");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      Log.e("HiPkgSignManager", localStringBuilder.toString());
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
    while (i < j)
    {
      if ((paramArrayOfByte[i] & 0xFF) < 16)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("0");
        localStringBuilder.append(Integer.toHexString(paramArrayOfByte[i] & 0xFF));
        localStringBuffer.append(localStringBuilder.toString());
      }
      else
      {
        localStringBuffer.append(Integer.toHexString(paramArrayOfByte[i] & 0xFF));
      }
      i += 1;
    }
    return localStringBuffer.toString().toUpperCase(Locale.ENGLISH);
  }
  
  public static boolean doCheckArchiveApk(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    boolean bool3 = TextUtils.isEmpty(paramString2);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString1))
      {
        bool1 = bool2;
        if (paramContext != null)
        {
          if (TextUtils.isEmpty(paramString3)) {
            return false;
          }
          String str = getUnInstalledAppHash(paramContext, paramString2);
          paramContext = getUnInstalledAPPPackageName(paramContext, paramString2);
          bool1 = bool2;
          if (paramString1.equalsIgnoreCase(str))
          {
            bool1 = bool2;
            if (paramString3.equals(paramContext)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean doCheckInstalled(Context paramContext, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)) && (paramContext != null)) {
      return paramString1.equals(getInstalledAppHash(paramContext, paramString2));
    }
    return false;
  }
  
  public static byte[] getInstalledAPPSignature(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
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
      catch (Exception paramContext)
      {
        paramString = new StringBuilder();
        paramString.append("Exception : ");
        paramString.append(paramContext.getMessage());
        LogsUtil.e("HiPkgSignManager", paramString.toString(), true);
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        paramString = new StringBuilder();
        paramString.append("PackageManager.NameNotFoundException : ");
        paramString.append(paramContext.getMessage());
        LogsUtil.e("HiPkgSignManager", paramString.toString(), true);
      }
      return new byte[0];
    }
    Log.e("HiPkgSignManager", "packageName is null or context is null");
    return new byte[0];
  }
  
  public static String getInstalledAppHash(Context paramContext, String paramString)
  {
    paramContext = getInstalledAPPSignature(paramContext, paramString);
    if ((paramContext != null) && (paramContext.length > 0)) {
      return a(paramContext);
    }
    return "";
  }
  
  public static String getUnInstalledAPPPackageName(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      try
      {
        paramContext = paramContext.getPackageManager();
        if (paramContext != null)
        {
          paramContext = paramContext.getPackageArchiveInfo(paramString, 64);
          if (paramContext != null)
          {
            paramContext = paramContext.packageName;
            return paramContext;
          }
        }
      }
      catch (Exception paramContext)
      {
        paramString = new StringBuilder();
        paramString.append("getUnInstalledAPPSignature exception : ");
        paramString.append(paramContext.getMessage());
        Log.e("HiPkgSignManager", paramString.toString());
      }
      return "";
    }
    Log.e("HiPkgSignManager", "archiveFilePath is null or context is null");
    return "";
  }
  
  public static byte[] getUnInstalledAPPSignature(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      try
      {
        paramContext = paramContext.getPackageManager();
        if (paramContext != null)
        {
          paramContext = paramContext.getPackageArchiveInfo(paramString, 64);
          if (paramContext != null) {
            return paramContext.signatures[0].toByteArray();
          }
          Log.e("HiPkgSignManager", "PackageInfo is null ");
        }
      }
      catch (Exception paramContext)
      {
        paramString = new StringBuilder();
        paramString.append("Exception : ");
        paramString.append(paramContext.getMessage());
        LogsUtil.e("HiPkgSignManager", paramString.toString(), true);
      }
      return new byte[0];
    }
    Log.e("HiPkgSignManager", "archiveFilePath is null or context is null");
    return new byte[0];
  }
  
  public static String getUnInstalledAppHash(Context paramContext, String paramString)
  {
    paramContext = getUnInstalledAPPSignature(paramContext, paramString);
    if ((paramContext != null) && (paramContext.length > 0)) {
      return a(paramContext);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.sign.HiPkgSignManager
 * JD-Core Version:    0.7.0.1
 */