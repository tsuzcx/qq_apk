package com.tencent.mm.plugin.appbrand.appstorage;

import java.nio.charset.StandardCharsets;

public class MD5JNI
{
  private static final byte[] a = "0123456789abcdef".getBytes(StandardCharsets.US_ASCII);
  
  public static String a(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      String[] arrayOfString = new String[1];
      getMD5String(paramString, arrayOfString);
      return arrayOfString[0];
    }
    return null;
  }
  
  public static native int getMD5String(String paramString, String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.MD5JNI
 * JD-Core Version:    0.7.0.1
 */