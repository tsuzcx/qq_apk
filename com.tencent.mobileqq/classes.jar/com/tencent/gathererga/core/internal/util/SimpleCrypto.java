package com.tencent.gathererga.core.internal.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class SimpleCrypto
{
  private static final String a = new String(new byte[] { 65, 69, 83 });
  
  public static String a(String paramString1, String paramString2)
  {
    return StrUtil.a(a(paramString1.getBytes(), paramString2.getBytes()));
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1 = new SecretKeySpec(paramArrayOfByte1, a);
    Cipher localCipher = Cipher.getInstance(a);
    localCipher.init(1, paramArrayOfByte1);
    return localCipher.doFinal(paramArrayOfByte2);
  }
  
  public static String b(String paramString1, String paramString2)
  {
    return new String(b(paramString1.getBytes(), StrUtil.a(paramString2)));
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1 = new SecretKeySpec(paramArrayOfByte1, a);
    Cipher localCipher = Cipher.getInstance(a);
    localCipher.init(2, paramArrayOfByte1);
    return localCipher.doFinal(paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.util.SimpleCrypto
 * JD-Core Version:    0.7.0.1
 */