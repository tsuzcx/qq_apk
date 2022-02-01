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
      paramString1 = paramString1.getBytes("UTF-8");
      boolean bool = TextUtils.isEmpty(paramString2);
      if (bool) {
        paramString2 = "SHA-256";
      }
      paramString2 = MessageDigest.getInstance(paramString2);
      paramString2.update(paramString1);
      paramString1 = HEX.encodeHexString(paramString2.digest(), false);
      return paramString1;
    }
    catch (NoSuchAlgorithmException paramString1)
    {
      break label49;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      label40:
      label49:
      break label40;
    }
    HMSLog.e("SHACoder", "trans failed .");
    return null;
    HMSLog.e("SHACoder", "encrypt failed .");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.opendevice.r
 * JD-Core Version:    0.7.0.1
 */