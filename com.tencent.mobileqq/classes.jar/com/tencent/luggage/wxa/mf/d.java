package com.tencent.luggage.wxa.mf;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class d
{
  private static final byte[] a = { 18, 52, 86, 120, -112, -85, -51, -17 };
  private static String b = null;
  
  public static String a()
  {
    try
    {
      if (b == null) {
        b = b();
      }
      String str = b;
      return str;
    }
    finally {}
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() >= 8))
    {
      if ((paramString2 != null) && (!paramString2.isEmpty())) {
        try
        {
          long l = System.currentTimeMillis();
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("start encode milles time = ");
          ((StringBuilder)localObject).append(l);
          b.a(3, "SecretUtils", ((StringBuilder)localObject).toString());
          paramString1 = new DESKeySpec(paramString1.getBytes());
          paramString1 = SecretKeyFactory.getInstance("DES").generateSecret(paramString1);
          localObject = Cipher.getInstance("DES/CBC/PKCS5Padding");
          ((Cipher)localObject).init(1, paramString1, new IvParameterSpec(a));
          paramString1 = a.a(((Cipher)localObject).doFinal(paramString2.getBytes()));
          paramString2 = new StringBuilder();
          paramString2.append("end encode milles time = ");
          paramString2.append(System.currentTimeMillis() - l);
          b.a(3, "SecretUtils", paramString2.toString());
          return paramString1;
        }
        catch (Exception paramString1)
        {
          paramString2 = new StringBuilder();
          paramString2.append("encode des error");
          paramString2.append(b.a(paramString1));
          b.a(6, "SecretUtils", paramString2.toString());
          throw paramString1;
        }
      }
      return null;
    }
    throw new Exception("secret key is not available");
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      int i = -1;
      if ((paramString1.hashCode() == 99346) && (paramString1.equals("des"))) {
        i = 0;
      }
      if (i == 0) {
        return a(paramString2, paramString3);
      }
    }
    return null;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      a(localStringBuffer, paramArrayOfByte[i]);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static void a(StringBuffer paramStringBuffer, byte paramByte)
  {
    paramStringBuffer.append("0123456789ABCDEF".charAt(paramByte >> 4 & 0xF));
    paramStringBuffer.append("0123456789ABCDEF".charAt(paramByte & 0xF));
  }
  
  public static String b()
  {
    try
    {
      Object localObject = SecureRandom.getInstance("SHA1PRNG");
      byte[] arrayOfByte = new byte[20];
      ((SecureRandom)localObject).nextBytes(arrayOfByte);
      localObject = a(arrayOfByte);
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mf.d
 * JD-Core Version:    0.7.0.1
 */