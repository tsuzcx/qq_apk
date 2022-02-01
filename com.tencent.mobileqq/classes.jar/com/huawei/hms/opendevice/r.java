package com.huawei.hms.opendevice;

import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HEX;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class r
{
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      byte[] arrayOfByte = paramString1.getBytes("UTF-8");
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = "SHA-256";
      }
      paramString1 = MessageDigest.getInstance(paramString1);
      paramString1.update(arrayOfByte);
      paramString1 = HEX.encodeHexString(paramString1.digest(), false);
      return paramString1;
    }
    catch (NoSuchAlgorithmException paramString1)
    {
      HMSLog.e("SHACoder", "encrypt failed .");
      return null;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      HMSLog.e("SHACoder", "trans failed .");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.opendevice.r
 * JD-Core Version:    0.7.0.1
 */