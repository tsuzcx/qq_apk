package com.tencent.liteav.basic.license;

import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;

public class h
{
  public static final byte[] a = "#PART#".getBytes();
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte2 = new PKCS8EncodedKeySpec(paramArrayOfByte2);
    paramArrayOfByte2 = KeyFactory.getInstance("RSA").generatePrivate(paramArrayOfByte2);
    Cipher localCipher = Cipher.getInstance("RSA/None/PKCS1Padding");
    localCipher.init(2, paramArrayOfByte2);
    return localCipher.doFinal(paramArrayOfByte1);
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i4 = a.length;
    if (i4 <= 0) {
      return a(paramArrayOfByte1, paramArrayOfByte2);
    }
    int i5 = paramArrayOfByte1.length;
    ArrayList localArrayList = new ArrayList(1024);
    int i3 = 0;
    int i = 0;
    int j = 0;
    while (i < i5)
    {
      int n = paramArrayOfByte1[i];
      byte[] arrayOfByte;
      int k;
      int m;
      if (i == i5 - 1)
      {
        arrayOfByte = new byte[i5 - j];
        System.arraycopy(paramArrayOfByte1, j, arrayOfByte, 0, arrayOfByte.length);
        arrayOfByte = a(arrayOfByte, paramArrayOfByte2);
        k = arrayOfByte.length;
        j = 0;
        while (j < k)
        {
          localArrayList.add(Byte.valueOf(arrayOfByte[j]));
          j += 1;
        }
        m = i + i4;
        k = m - 1;
      }
      else
      {
        k = i;
        m = j;
        if (n == a[0]) {
          if (i4 > 1)
          {
            k = i;
            m = j;
            if (i + i4 < i5)
            {
              int i2 = 1;
              int i1 = 0;
              for (;;)
              {
                k = i;
                m = j;
                n = i1;
                if (i2 >= i4) {
                  break;
                }
                if (a[i2] != paramArrayOfByte1[(i + i2)])
                {
                  k = i;
                  m = j;
                  n = i1;
                  break;
                }
                if (i2 == i4 - 1) {
                  i1 = 1;
                }
                i2 += 1;
              }
            }
          }
          else
          {
            n = 1;
            k = i;
            m = j;
            break label260;
          }
        }
      }
      n = 0;
      label260:
      i = k;
      j = m;
      if (n != 0)
      {
        arrayOfByte = new byte[k - m];
        System.arraycopy(paramArrayOfByte1, m, arrayOfByte, 0, arrayOfByte.length);
        arrayOfByte = a(arrayOfByte, paramArrayOfByte2);
        j = arrayOfByte.length;
        i = 0;
        while (i < j)
        {
          localArrayList.add(Byte.valueOf(arrayOfByte[i]));
          i += 1;
        }
        i = k + i4;
        j = i;
        i -= 1;
      }
      i += 1;
    }
    paramArrayOfByte1 = new byte[localArrayList.size()];
    paramArrayOfByte2 = localArrayList.iterator();
    i = i3;
    while (paramArrayOfByte2.hasNext())
    {
      paramArrayOfByte1[i] = ((Byte)paramArrayOfByte2.next()).byteValue();
      i += 1;
    }
    return paramArrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.license.h
 * JD-Core Version:    0.7.0.1
 */