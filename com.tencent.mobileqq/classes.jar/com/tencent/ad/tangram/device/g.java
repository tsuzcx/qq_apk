package com.tencent.ad.tangram.device;

import android.text.TextUtils;
import com.tencent.ad.tangram.util.d;

public final class g
{
  public static String getAndroidIdMD5Digest(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      paramString = null;
      String str;
      do
      {
        return paramString;
        paramString = d.md5(paramString, "UTF-8");
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        str = paramString.toLowerCase();
        paramString = str;
      } while (!TextUtils.isEmpty(str));
    }
  }
  
  public static String getDeviceIdMD5Digest(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      paramString = null;
      String str;
      do
      {
        return paramString;
        paramString = paramString.toLowerCase();
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        paramString = d.md5(paramString, "UTF-8");
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        str = paramString.toLowerCase();
        paramString = str;
      } while (!TextUtils.isEmpty(str));
    }
  }
  
  public static String getMacAddressMD5Digest(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      paramString = null;
      String str;
      do
      {
        return paramString;
        paramString = paramString.replaceAll(":", "");
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        paramString = paramString.toUpperCase();
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        paramString = d.md5(paramString, "UTF-8");
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        str = paramString.toLowerCase();
        paramString = str;
      } while (!TextUtils.isEmpty(str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.device.g
 * JD-Core Version:    0.7.0.1
 */