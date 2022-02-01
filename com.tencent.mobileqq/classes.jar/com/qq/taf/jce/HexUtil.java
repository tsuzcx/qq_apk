package com.qq.taf.jce;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class HexUtil
{
  private static final char[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public static final byte[] emptybytes = new byte[0];
  
  public static String byte2HexStr(byte paramByte)
  {
    char[] arrayOfChar = digits;
    int i = arrayOfChar[(paramByte & 0xF)];
    return new String(new char[] { arrayOfChar[((byte)(paramByte >>> 4) & 0xF)], i });
  }
  
  public static String bytes2HexStr(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      char[] arrayOfChar1 = new char[paramArrayOfByte.length * 2];
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        int j = paramArrayOfByte[i];
        int k = i * 2;
        char[] arrayOfChar2 = digits;
        arrayOfChar1[(k + 1)] = arrayOfChar2[(j & 0xF)];
        arrayOfChar1[(k + 0)] = arrayOfChar2[((byte)(j >>> 4) & 0xF)];
        i += 1;
      }
      return new String(arrayOfChar1);
    }
    return null;
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
  
  public static byte hexStr2Byte(String paramString)
  {
    if ((paramString != null) && (paramString.length() == 1)) {
      return char2Byte(paramString.charAt(0));
    }
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
    return emptybytes;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = "Hello WebSocket World?".getBytes("gbk");
      System.out.println(bytes2HexStr(paramArrayOfString));
      return;
    }
    catch (UnsupportedEncodingException paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.taf.jce.HexUtil
 * JD-Core Version:    0.7.0.1
 */