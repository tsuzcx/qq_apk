package com.huawei.hms.push;

import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;

public class c
{
  public static byte[] a(Bundle paramBundle, String paramString)
  {
    try
    {
      paramString = paramBundle.getByteArray(paramString);
      paramBundle = paramString;
      if (paramString == null) {
        paramBundle = new byte[0];
      }
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      paramString = new StringBuilder();
      paramString.append("getByteArray exception");
      paramString.append(paramBundle.getMessage());
      HMSLog.i("BundleUtil", paramString.toString());
    }
    return new byte[0];
  }
  
  public static String b(Bundle paramBundle, String paramString)
  {
    try
    {
      paramBundle = paramBundle.getString(paramString);
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      paramString = new StringBuilder();
      paramString.append("getString exception");
      paramString.append(paramBundle.getMessage());
      HMSLog.i("BundleUtil", paramString.toString());
    }
    return null;
  }
  
  public static String c(Bundle paramBundle, String paramString)
  {
    try
    {
      paramBundle = paramBundle.getString(paramString);
      if (paramBundle == null) {
        return "";
      }
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      paramString = new StringBuilder();
      paramString.append("getString exception");
      paramString.append(paramBundle.getMessage());
      HMSLog.i("BundleUtil", paramString.toString());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.c
 * JD-Core Version:    0.7.0.1
 */