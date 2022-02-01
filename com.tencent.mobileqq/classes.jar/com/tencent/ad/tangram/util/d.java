package com.tencent.ad.tangram.util;

import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import java.security.MessageDigest;

public final class d
{
  private static final String TAG = "AdMessageDigestUtil";
  
  private static byte[] digest(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      paramString = MessageDigest.getInstance(paramString).digest(paramArrayOfByte);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AdLog.e("AdMessageDigestUtil", "digest", paramString);
    }
    return null;
  }
  
  public static String md5(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      try
      {
        paramString1 = md5(paramString1.getBytes(paramString2));
        paramString2 = AdHexUtil.bytes2HexString(paramString1);
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString1 = paramString2;
          if (paramString2.length() == 32) {}
        }
        else
        {
          AdLog.e("AdMessageDigestUtil", "md5 error");
          return null;
        }
      }
      catch (Throwable paramString1)
      {
        AdLog.e("AdMessageDigestUtil", "md5", paramString1);
      }
    }
    return null;
  }
  
  public static byte[] md5(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      paramArrayOfByte = null;
    }
    byte[] arrayOfByte;
    do
    {
      return paramArrayOfByte;
      arrayOfByte = digest("md5", paramArrayOfByte);
      if (arrayOfByte == null) {
        break;
      }
      paramArrayOfByte = arrayOfByte;
    } while (arrayOfByte.length == 16);
    AdLog.e("AdMessageDigestUtil", "md5 error");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.util.d
 * JD-Core Version:    0.7.0.1
 */