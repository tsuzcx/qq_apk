package com.tencent.liteav.basic.d;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;

public final class a
{
  private static String a = "RSA";
  
  public static PrivateKey a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new PKCS8EncodedKeySpec(paramArrayOfByte);
    return KeyFactory.getInstance(a).generatePrivate(paramArrayOfByte);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, PrivateKey paramPrivateKey)
  {
    Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    localCipher.init(2, paramPrivateKey);
    int j = paramArrayOfByte.length;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    for (;;)
    {
      int k = j - i;
      if (k <= 0) {
        break;
      }
      if (k >= localCipher.getBlockSize()) {
        paramPrivateKey = localCipher.doFinal(paramArrayOfByte, i, localCipher.getBlockSize());
      } else {
        paramPrivateKey = localCipher.doFinal(paramArrayOfByte, i, k);
      }
      localByteArrayOutputStream.write(paramPrivateKey);
      i += localCipher.getBlockSize();
    }
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.d.a
 * JD-Core Version:    0.7.0.1
 */