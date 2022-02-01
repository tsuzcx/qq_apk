package com.rookery.translate.model;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils
{
  static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  @TargetApi(8)
  public static File a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      return paramContext.getExternalCacheDir();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/Android/data/");
    localStringBuilder.append(paramContext.getPackageName());
    localStringBuilder.append("/cache/");
    paramContext = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append(paramContext);
    return new File(localStringBuilder.toString());
  }
  
  public static String a(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = a(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      break label42;
    }
    catch (UnsupportedEncodingException paramString)
    {
      break label34;
    }
    catch (Throwable paramString)
    {
      label26:
      label34:
      label42:
      break label26;
    }
    throw new AssertionError();
    throw new AssertionError();
    throw new AssertionError();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("{@}");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("[@]");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("[id:]");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    char[] arrayOfChar1 = new char[paramArrayOfByte.length * 2];
    int k = paramArrayOfByte.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      int n = j + 1;
      char[] arrayOfChar2 = a;
      arrayOfChar1[j] = arrayOfChar2[(m >>> 4 & 0xF)];
      j = n + 1;
      arrayOfChar1[n] = arrayOfChar2[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar1);
  }
  
  @TargetApi(9)
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return Environment.isExternalStorageRemovable();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.translate.model.Utils
 * JD-Core Version:    0.7.0.1
 */