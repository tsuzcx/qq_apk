package com.qq.wx.voice.util;

public class Key
{
  public static final int AUTHKEYLEN = 48;
  private static String a = null;
  private static byte[] b = new byte[16];
  
  public static int convertChar(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    if ((paramChar >= 'a') && (paramChar <= 'f')) {
      return paramChar - 'a' + 10;
    }
    if ((paramChar >= 'A') && (paramChar <= 'F')) {
      return paramChar - 'A' + 10;
    }
    return -1;
  }
  
  public static int convertKey(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramString == null) || (paramString.length() <= 0) || (paramString.length() % 2 != 0)) {}
    for (;;)
    {
      return 0;
      int i = 0;
      while (i < paramString.length())
      {
        int j = convertChar(paramString.charAt(i));
        int k = convertChar(paramString.charAt(i + 1));
        if ((j < 0) || (k < 0)) {
          return -1;
        }
        paramArrayOfByte[(i / 2)] = ((byte)((j << 4) + k));
        i += 2;
      }
    }
  }
  
  public static String getAppID()
  {
    return a;
  }
  
  public static int getAppidlen()
  {
    return 16;
  }
  
  public static byte[] getKey()
  {
    return b;
  }
  
  public static int parseKey(String paramString)
  {
    if ((paramString == null) || (paramString.length() != 48)) {
      return -1;
    }
    a = paramString.substring(0, 16);
    return convertKey(paramString.substring(16), b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.qq.wx.voice.util.Key
 * JD-Core Version:    0.7.0.1
 */