package com.tencent.component.network.module.common.dns;

import java.text.DecimalFormat;

public class ByteBase
{
  private static final DecimalFormat byteFormat = new DecimalFormat();
  
  public static String byteString(byte[] paramArrayOfByte, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramInt)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      if ((j > 32) && (j < 127))
      {
        if ((j != 34) && (j != 40) && (j != 41) && (j != 46) && (j != 59) && (j != 92) && (j != 64) && (j != 36))
        {
          localStringBuffer.append((char)j);
        }
        else
        {
          localStringBuffer.append('\\');
          localStringBuffer.append((char)j);
        }
      }
      else
      {
        localStringBuffer.append('\\');
        localStringBuffer.append(byteFormat.format(j));
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.ByteBase
 * JD-Core Version:    0.7.0.1
 */