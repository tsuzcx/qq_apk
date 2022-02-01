package com.tencent.biz.richframework.network.util;

public class StringUtils
{
  public static String byte2HexString(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      if (Integer.toHexString(paramArrayOfByte[i] & 0xFF).length() == 1)
      {
        localStringBuffer.append("0");
        localStringBuffer.append(Integer.toHexString(paramArrayOfByte[i] & 0xFF));
      }
      else
      {
        localStringBuffer.append(Integer.toHexString(paramArrayOfByte[i] & 0xFF));
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String formatSize(long paramLong)
  {
    Object localObject2 = new StringBuilder();
    Object localObject1 = "";
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramLong);
    localObject2 = ((StringBuilder)localObject2).toString();
    if ((paramLong >= 0L) && (paramLong < 1024L))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("B");
      return ((StringBuilder)localObject1).toString();
    }
    if ((paramLong >= 1024L) && (paramLong < 1048576L))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Long.toString(paramLong / 1024L));
      ((StringBuilder)localObject1).append("KB");
      return ((StringBuilder)localObject1).toString();
    }
    if ((paramLong >= 1048576L) && (paramLong < 1073741824L))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Long.toString(paramLong / 1048576L));
      ((StringBuilder)localObject1).append("MB");
      return ((StringBuilder)localObject1).toString();
    }
    if (paramLong >= 1073741824L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Long.toString(paramLong / 1073741824L));
      ((StringBuilder)localObject1).append("GB");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    return localObject1;
  }
  
  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.util.StringUtils
 * JD-Core Version:    0.7.0.1
 */