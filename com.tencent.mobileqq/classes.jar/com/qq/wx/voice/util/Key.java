package com.qq.wx.voice.util;

public class Key
{
  public static final int AUTHKEYLEN = 48;
  private static String a;
  private static byte[] b = new byte[16];
  
  public static int convertChar(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    char c = 'a';
    if ((paramChar >= 'a') && (paramChar <= 'f')) {}
    do
    {
      return paramChar - c + 10;
      c = 'A';
    } while ((paramChar >= 'A') && (paramChar <= 'F'));
    return -1;
  }
  
  public static int convertKey(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      if (paramString.length() % 2 != 0) {
        return 0;
      }
      int i = 0;
      for (;;)
      {
        if (i >= paramString.length()) {
          return 0;
        }
        int j = convertChar(paramString.charAt(i));
        int k = convertChar(paramString.charAt(i + 1));
        if ((j < 0) || (k < 0)) {
          break;
        }
        paramArrayOfByte[(i / 2)] = ((byte)((j << 4) + k));
        i += 2;
      }
      return -1;
    }
    return 0;
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
    if ((paramString != null) && (paramString.length() == 48))
    {
      a = paramString.substring(0, 16);
      return convertKey(paramString.substring(16), b);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.util.Key
 * JD-Core Version:    0.7.0.1
 */