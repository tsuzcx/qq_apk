package com.tencent.hippy.qq.update.sign;

import java.util.Random;

public class HippySign
{
  public static boolean empty(String paramString)
  {
    return (paramString == null) || (paramString.trim().equals("")) || (paramString.trim().equals("null"));
  }
  
  public static String getSign(String paramString1, String paramString2)
  {
    if (empty(paramString2)) {}
    do
    {
      return null;
      long l = System.currentTimeMillis() / 1000L;
      int i = Math.abs(new Random().nextInt());
      paramString1 = "a=" + paramString1 + "&t=" + l + "&r=" + i;
      paramString2 = hashHmac(paramString1, paramString2);
    } while (paramString2 == null);
    byte[] arrayOfByte = new byte[paramString2.length + paramString1.getBytes().length];
    System.arraycopy(paramString2, 0, arrayOfByte, 0, paramString2.length);
    System.arraycopy(paramString1.getBytes(), 0, arrayOfByte, paramString2.length, paramString1.getBytes().length);
    return Base64Util.encode(arrayOfByte);
  }
  
  private static byte[] hashHmac(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = HMACSHA1.getSignature(paramString1, paramString2);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.update.sign.HippySign
 * JD-Core Version:    0.7.0.1
 */