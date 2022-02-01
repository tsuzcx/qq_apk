package com.tencent.gathererga.ad.internal;

import android.text.TextUtils;
import com.tencent.gathererga.core.internal.util.GLog;
import java.security.MessageDigest;

final class AdMessageDigestUtil
{
  public static String a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      try
      {
        paramString1 = a(paramString1.getBytes(paramString2));
        paramString1 = AdHexUtil.a(paramString1);
        if ((!TextUtils.isEmpty(paramString1)) && (paramString1.length() == 32)) {
          return paramString1;
        }
        GLog.d("md5 error");
        return null;
      }
      catch (Throwable paramString1)
      {
        GLog.b("md5", paramString1);
      }
    }
    return null;
  }
  
  private static byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      paramString = MessageDigest.getInstance(paramString).digest(paramArrayOfByte);
      return paramString;
    }
    catch (Throwable paramString)
    {
      GLog.b("digest", paramString);
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        return null;
      }
      paramArrayOfByte = a("md5", paramArrayOfByte);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length == 16)) {
        return paramArrayOfByte;
      }
      GLog.d("md5 error");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.ad.internal.AdMessageDigestUtil
 * JD-Core Version:    0.7.0.1
 */