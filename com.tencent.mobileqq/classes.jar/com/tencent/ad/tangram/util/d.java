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
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      try
      {
        paramString1 = md5(paramString1.getBytes(paramString2));
        paramString1 = AdHexUtil.bytes2HexString(paramString1);
        if ((!TextUtils.isEmpty(paramString1)) && (paramString1.length() == 32)) {
          return paramString1;
        }
        AdLog.e("AdMessageDigestUtil", "md5 error");
        return null;
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
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        return null;
      }
      paramArrayOfByte = digest("md5", paramArrayOfByte);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length == 16)) {
        return paramArrayOfByte;
      }
      AdLog.e("AdMessageDigestUtil", "md5 error");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.d
 * JD-Core Version:    0.7.0.1
 */