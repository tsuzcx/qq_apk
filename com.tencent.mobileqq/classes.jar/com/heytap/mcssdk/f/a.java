package com.heytap.mcssdk.f;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class a
{
  private static String a()
  {
    byte[] arrayOfByte = a(a("com.nearme.mcs"));
    if (arrayOfByte != null) {
      return new String(arrayOfByte, Charset.forName("UTF-8"));
    }
    return "";
  }
  
  public static byte[] a(String paramString)
  {
    if (paramString == null) {
      return new byte[0];
    }
    try
    {
      paramString = paramString.getBytes("UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      label17:
      break label17;
    }
    return new byte[0];
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    int j;
    if (paramArrayOfByte.length % 2 == 0) {
      j = paramArrayOfByte.length;
    } else {
      j = paramArrayOfByte.length - 1;
    }
    int k = 0;
    while (k < j)
    {
      int i = paramArrayOfByte[k];
      int m = k + 1;
      paramArrayOfByte[k] = paramArrayOfByte[m];
      paramArrayOfByte[m] = i;
      k += 2;
    }
    return paramArrayOfByte;
  }
  
  public static String b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = b.a(paramString, a());
        return paramString;
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("desDecrypt-");
        localStringBuilder.append(paramString.getMessage());
        c.b(localStringBuilder.toString());
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.mcssdk.f.a
 * JD-Core Version:    0.7.0.1
 */