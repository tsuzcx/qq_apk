package com.tencent.biz.richframework.network.util;

public class StringUtils
{
  public static String byte2HexString(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      if (Integer.toHexString(paramArrayOfByte[i] & 0xFF).length() == 1) {
        localStringBuffer.append("0").append(Integer.toHexString(paramArrayOfByte[i] & 0xFF));
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append(Integer.toHexString(paramArrayOfByte[i] & 0xFF));
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String formatSize(long paramLong)
  {
    String str2 = "" + paramLong;
    String str1 = "";
    if ((paramLong >= 0L) && (paramLong < 1024L)) {
      str1 = str2 + "B";
    }
    do
    {
      return str1;
      if ((paramLong >= 1024L) && (paramLong < 1048576L)) {
        return Long.toString(paramLong / 1024L) + "KB";
      }
      if ((paramLong >= 1048576L) && (paramLong < 1073741824L)) {
        return Long.toString(paramLong / 1048576L) + "MB";
      }
    } while (paramLong < 1073741824L);
    return Long.toString(paramLong / 1073741824L) + "GB";
  }
  
  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.network.util.StringUtils
 * JD-Core Version:    0.7.0.1
 */