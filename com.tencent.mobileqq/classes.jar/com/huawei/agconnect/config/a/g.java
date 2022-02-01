package com.huawei.agconnect.config.a;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class g
{
  public static SecretKey a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    if ((paramArrayOfByte1.length == 16) && (paramArrayOfByte2.length == 16) && (paramArrayOfByte3.length == 16))
    {
      paramArrayOfByte1 = e.a(a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3));
      return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(paramArrayOfByte1.toCharArray(), paramArrayOfByte4, 5000, 128)).getEncoded(), "AES");
    }
    throw new IllegalArgumentException("invalid data for generating the key.");
  }
  
  private static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        if (paramInt < 0) {
          paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] << -paramInt));
        } else {
          paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] >> paramInt));
        }
        i += 1;
      }
      return paramArrayOfByte;
    }
    paramArrayOfByte = new NullPointerException("bytes must not be null.");
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      if (paramArrayOfByte1.length == paramArrayOfByte2.length)
      {
        byte[] arrayOfByte = new byte[paramArrayOfByte1.length];
        int i = 0;
        while (i < paramArrayOfByte1.length)
        {
          arrayOfByte[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
          i += 1;
        }
        return arrayOfByte;
      }
      throw new IllegalArgumentException("left and right must be the same length.");
    }
    paramArrayOfByte1 = new NullPointerException("left or right must not be null.");
    for (;;)
    {
      throw paramArrayOfByte1;
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    return a(a(a(a(paramArrayOfByte1, -4), paramArrayOfByte2), 6), paramArrayOfByte3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.agconnect.config.a.g
 * JD-Core Version:    0.7.0.1
 */