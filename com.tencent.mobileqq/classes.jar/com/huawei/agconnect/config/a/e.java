package com.huawei.agconnect.config.a;

public class e
{
  private static final char[] a = "0123456789ABCDEF".toCharArray();
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      localStringBuilder.append(a[(k >> 4 & 0xF)]);
      localStringBuilder.append(a[(k & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static byte[] a(String paramString)
  {
    return a(paramString.toCharArray());
  }
  
  private static byte[] a(char[] paramArrayOfChar)
  {
    if ((paramArrayOfChar.length & 0x1) == 0)
    {
      byte[] arrayOfByte = new byte[paramArrayOfChar.length >> 1];
      int j = 0;
      int i = 0;
      while (j < paramArrayOfChar.length)
      {
        int k = Character.digit(paramArrayOfChar[j], 16);
        if (k != -1)
        {
          j += 1;
          int m = Character.digit(paramArrayOfChar[j], 16);
          if (m != -1)
          {
            j += 1;
            arrayOfByte[i] = ((byte)((k << 4 | m) & 0xFF));
            i += 1;
          }
          else
          {
            paramArrayOfChar = new StringBuilder();
            paramArrayOfChar.append("Illegal hexadecimal character at index ");
            paramArrayOfChar.append(j);
            throw new IllegalArgumentException(paramArrayOfChar.toString());
          }
        }
        else
        {
          paramArrayOfChar = new StringBuilder();
          paramArrayOfChar.append("Illegal hexadecimal character at index ");
          paramArrayOfChar.append(j);
          throw new IllegalArgumentException(paramArrayOfChar.toString());
        }
      }
      return arrayOfByte;
    }
    paramArrayOfChar = new IllegalArgumentException("Odd number of characters.");
    for (;;)
    {
      throw paramArrayOfChar;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.config.a.e
 * JD-Core Version:    0.7.0.1
 */