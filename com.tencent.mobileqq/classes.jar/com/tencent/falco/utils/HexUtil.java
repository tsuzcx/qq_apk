package com.tencent.falco.utils;

public class HexUtil
{
  public static String bytesToHexString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static byte char2Byte(char paramChar)
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
  
  public static byte[] hexStr2Bytes(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      byte[] arrayOfByte = new byte[paramString.length() / 2];
      int i = 0;
      while (i < arrayOfByte.length)
      {
        int j = i * 2;
        char c1 = paramString.charAt(j);
        char c2 = paramString.charAt(j + 1);
        arrayOfByte[i] = ((byte)(char2Byte(c1) * 16 + char2Byte(c2)));
        i += 1;
      }
      return arrayOfByte;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.utils.HexUtil
 * JD-Core Version:    0.7.0.1
 */