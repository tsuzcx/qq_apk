package com.tencent.biz.qqcircle.publish.util;

import com.tencent.qphone.base.util.QLog;

public class HexUtil
{
  public static final byte[] a = new byte[0];
  private static final char[] b = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static byte a(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9'))
    {
      paramChar -= '0';
      return (byte)paramChar;
    }
    char c = 'a';
    if ((paramChar >= 'a') && (paramChar <= 'f')) {}
    do
    {
      paramChar = paramChar - c + 10;
      break;
      c = 'A';
    } while ((paramChar >= 'A') && (paramChar <= 'F'));
    return 0;
  }
  
  public static byte[] a(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      Object localObject = new byte[paramString.length() / 2];
      int i = 0;
      try
      {
        while (i < localObject.length)
        {
          int j = i * 2;
          char c1 = paramString.charAt(j);
          char c2 = paramString.charAt(j + 1);
          localObject[i] = ((byte)(a(c1) * 16 + a(c2)));
          i += 1;
        }
        return localObject;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" === hexStr2Bytes error === ");
          ((StringBuilder)localObject).append(paramString.toString());
          QLog.d("HexUtil", 2, ((StringBuilder)localObject).toString());
        }
        return a;
      }
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.util.HexUtil
 * JD-Core Version:    0.7.0.1
 */