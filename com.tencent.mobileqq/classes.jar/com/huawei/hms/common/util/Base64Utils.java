package com.huawei.hms.common.util;

import android.util.Base64;
import com.huawei.hms.support.log.HMSLog;

public final class Base64Utils
{
  private static final int FLAG_DEFAULT = 0;
  private static final int FLAG_URL = 10;
  private static final int FLAG_URL_NOPADDING = 11;
  private static final String TAG = "Base64Utils";
  
  public static byte[] decode(String paramString)
  {
    if (paramString != null) {
      try
      {
        paramString = Base64.decode(paramString, 0);
        return paramString;
      }
      catch (IllegalArgumentException paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decode failed : ");
        localStringBuilder.append(paramString.getMessage());
        HMSLog.e("Base64Utils", localStringBuilder.toString());
      }
    }
    return new byte[0];
  }
  
  public static byte[] decodeUrlSafe(String paramString)
  {
    if (paramString != null) {
      try
      {
        paramString = Base64.decode(paramString, 10);
        return paramString;
      }
      catch (IllegalArgumentException paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decodeUrlSafe failed : ");
        localStringBuilder.append(paramString.getMessage());
        HMSLog.e("Base64Utils", localStringBuilder.toString());
      }
    }
    return new byte[0];
  }
  
  public static byte[] decodeUrlSafeNoPadding(String paramString)
  {
    if (paramString != null) {
      try
      {
        paramString = Base64.decode(paramString, 11);
        return paramString;
      }
      catch (IllegalArgumentException paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decodeUrlSafeNoPadding failed : ");
        localStringBuilder.append(paramString.getMessage());
        HMSLog.e("Base64Utils", localStringBuilder.toString());
      }
    }
    return new byte[0];
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return Base64.encodeToString(paramArrayOfByte, 0);
    }
    return null;
  }
  
  public static String encodeUrlSafe(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return Base64.encodeToString(paramArrayOfByte, 10);
    }
    return null;
  }
  
  public static String encodeUrlSafeNoPadding(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return Base64.encodeToString(paramArrayOfByte, 11);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.util.Base64Utils
 * JD-Core Version:    0.7.0.1
 */