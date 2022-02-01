package com.tencent.hippy.qq.update.sign;

public class Base64Util
{
  private static final char[] encodeTable = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final char last2byte = (char)Integer.parseInt("00000011", 2);
  private static final char last4byte = (char)Integer.parseInt("00001111", 2);
  private static final char last6byte = (char)Integer.parseInt("00111111", 2);
  private static final char lead2byte;
  private static final char lead4byte;
  private static final char lead6byte = (char)Integer.parseInt("11111100", 2);
  
  static
  {
    lead4byte = (char)Integer.parseInt("11110000", 2);
    lead2byte = (char)Integer.parseInt("11000000", 2);
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    int k = 0;
    StringBuilder localStringBuilder = new StringBuilder((int)(paramArrayOfByte.length * 1.34D) + 3);
    int i = 0;
    int j = 0;
    while (k < paramArrayOfByte.length)
    {
      j %= 8;
      int m = i;
      if (j < 8)
      {
        i = m;
        switch (j)
        {
        default: 
          i = m;
        }
        for (;;)
        {
          localStringBuilder.append(encodeTable[i]);
          j += 6;
          m = i;
          break;
          i = (char)((char)(paramArrayOfByte[k] & lead6byte) >>> '\002');
          continue;
          i = (char)(paramArrayOfByte[k] & last6byte);
          continue;
          m = (char)((char)(paramArrayOfByte[k] & last4byte) << '\002');
          i = m;
          if (k + 1 < paramArrayOfByte.length)
          {
            i = (char)(m | (paramArrayOfByte[(k + 1)] & lead2byte) >>> 6);
            continue;
            m = (char)((char)(paramArrayOfByte[k] & last2byte) << '\004');
            i = m;
            if (k + 1 < paramArrayOfByte.length) {
              i = (char)(m | (paramArrayOfByte[(k + 1)] & lead4byte) >>> 4);
            }
          }
        }
      }
      k += 1;
      i = m;
    }
    if (localStringBuilder.length() % 4 != 0)
    {
      i = 4 - localStringBuilder.length() % 4;
      while (i > 0)
      {
        localStringBuilder.append("=");
        i -= 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.update.sign.Base64Util
 * JD-Core Version:    0.7.0.1
 */