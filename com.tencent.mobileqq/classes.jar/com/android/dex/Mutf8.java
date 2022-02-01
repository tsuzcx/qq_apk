package com.android.dex;

import com.android.dex.util.ByteInput;
import java.io.UTFDataFormatException;

public final class Mutf8
{
  private static long countBytes(String paramString, boolean paramBoolean)
  {
    int j = paramString.length();
    long l = 0L;
    int i = 0;
    while (i < j)
    {
      int k = paramString.charAt(i);
      if ((k != 0) && (k <= 127)) {
        l += 1L;
      }
      while ((paramBoolean) && (l > 65535L))
      {
        throw new UTFDataFormatException("String more than 65535 UTF bytes long");
        if (k <= 2047) {
          l += 2L;
        } else {
          l += 3L;
        }
      }
      i += 1;
    }
    return l;
  }
  
  public static String decode(ByteInput paramByteInput, char[] paramArrayOfChar)
  {
    int j = 0;
    for (;;)
    {
      int i = (char)(paramByteInput.readByte() & 0xFF);
      if (i == 0) {
        return new String(paramArrayOfChar, 0, j);
      }
      paramArrayOfChar[j] = i;
      if (i < 128)
      {
        j += 1;
      }
      else
      {
        int k;
        if ((i & 0xE0) == 192)
        {
          k = paramByteInput.readByte() & 0xFF;
          if ((k & 0xC0) != 128) {
            throw new UTFDataFormatException("bad second byte");
          }
          paramArrayOfChar[j] = ((char)((i & 0x1F) << 6 | k & 0x3F));
          j += 1;
        }
        else
        {
          if ((i & 0xF0) != 224) {
            break;
          }
          k = paramByteInput.readByte() & 0xFF;
          int m = paramByteInput.readByte() & 0xFF;
          if (((k & 0xC0) != 128) || ((m & 0xC0) != 128)) {
            throw new UTFDataFormatException("bad second or third byte");
          }
          paramArrayOfChar[j] = ((char)((i & 0xF) << 12 | (k & 0x3F) << 6 | m & 0x3F));
          j += 1;
        }
      }
    }
    throw new UTFDataFormatException("bad byte");
  }
  
  public static void encode(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    int k = paramString.length();
    int i = 0;
    if (i < k)
    {
      int m = paramString.charAt(i);
      int j;
      if ((m != 0) && (m <= 127))
      {
        j = paramInt + 1;
        paramArrayOfByte[paramInt] = ((byte)m);
        paramInt = j;
      }
      for (;;)
      {
        i += 1;
        break;
        if (m <= 2047)
        {
          j = paramInt + 1;
          paramArrayOfByte[paramInt] = ((byte)(m >> 6 & 0x1F | 0xC0));
          paramInt = j + 1;
          paramArrayOfByte[j] = ((byte)(m & 0x3F | 0x80));
        }
        else
        {
          j = paramInt + 1;
          paramArrayOfByte[paramInt] = ((byte)(m >> 12 & 0xF | 0xE0));
          int n = j + 1;
          paramArrayOfByte[j] = ((byte)(m >> 6 & 0x3F | 0x80));
          paramInt = n + 1;
          paramArrayOfByte[n] = ((byte)(m & 0x3F | 0x80));
        }
      }
    }
  }
  
  public static byte[] encode(String paramString)
  {
    byte[] arrayOfByte = new byte[(int)countBytes(paramString, true)];
    encode(arrayOfByte, 0, paramString);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.Mutf8
 * JD-Core Version:    0.7.0.1
 */