package com.huawei.hms.common.util;

import android.util.Base64;
import com.huawei.hms.support.log.HMSLog;

public final class a
{
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return Base64.encodeToString(paramArrayOfByte, 10);
    }
    return null;
  }
  
  public static byte[] a(String paramString)
  {
    byte[] arrayOfByte2 = new byte[0];
    byte[] arrayOfByte1 = arrayOfByte2;
    if (paramString != null) {}
    try
    {
      arrayOfByte1 = Base64.decode(paramString, 10);
      return arrayOfByte1;
    }
    catch (IllegalArgumentException paramString)
    {
      HMSLog.e("Base64Utils", "decodeUrlSafe failed : " + paramString.getMessage());
    }
    return arrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.common.util.a
 * JD-Core Version:    0.7.0.1
 */