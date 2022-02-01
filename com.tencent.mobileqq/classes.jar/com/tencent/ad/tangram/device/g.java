package com.tencent.ad.tangram.device;

import android.text.TextUtils;
import com.tencent.ad.tangram.util.d;

public final class g
{
  public static String getAndroidIdMD5Digest(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = d.md5(paramString, "UTF-8");
      if (!TextUtils.isEmpty(paramString))
      {
        String str = paramString.toLowerCase();
        paramString = str;
        if (!TextUtils.isEmpty(str)) {
          return paramString;
        }
      }
    }
    paramString = null;
    return paramString;
  }
  
  public static String getDeviceIdMD5Digest(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.toLowerCase();
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = d.md5(paramString, "UTF-8");
        if (!TextUtils.isEmpty(paramString))
        {
          String str = paramString.toLowerCase();
          paramString = str;
          if (!TextUtils.isEmpty(str)) {
            return paramString;
          }
        }
      }
    }
    paramString = null;
    return paramString;
  }
  
  public static String getMacAddressMD5Digest(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.replaceAll(":", "");
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.toUpperCase();
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = d.md5(paramString, "UTF-8");
          if (!TextUtils.isEmpty(paramString))
          {
            String str = paramString.toLowerCase();
            paramString = str;
            if (!TextUtils.isEmpty(str)) {
              return paramString;
            }
          }
        }
      }
    }
    paramString = null;
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.device.g
 * JD-Core Version:    0.7.0.1
 */