package com.huawei.hms.stats;

import android.text.TextUtils;
import android.util.Pair;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class d
  implements i
{
  private static final Charset a = Charset.forName("UTF-8");
  
  private Pair<byte[], byte[]> a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 32)) {
      return new Pair(new byte[0], new byte[0]);
    }
    String str = paramString.substring(0, 32);
    paramString = paramString.substring(32);
    return new Pair(g.a(str), g.a(paramString));
  }
  
  private String a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte2 == null) || (paramString == null) || (paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0)) {
      return "";
    }
    return a(paramArrayOfByte1, g.a(b(paramString, paramArrayOfByte1, paramArrayOfByte2)));
  }
  
  private String a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramString;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return g.a(paramArrayOfByte).concat(str);
  }
  
  private String a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if ((paramArrayOfByte1.length == 0) || (paramArrayOfByte2.length == 0) || (paramArrayOfByte3.length == 0))
    {
      af.c("Aes", "decrypt: parameter exception");
      return "";
    }
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(2, new SecretKeySpec(paramArrayOfByte1, "AES"), new IvParameterSpec(paramArrayOfByte2));
      paramArrayOfByte1 = new String(localCipher.doFinal(paramArrayOfByte3), a);
      return paramArrayOfByte1;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte1)
    {
      af.c("Aes", "aesDecrypt(): getInstance - No such algorithm,transformation");
      return "";
    }
    catch (InvalidKeyException paramArrayOfByte1)
    {
      for (;;)
      {
        af.c("Aes", "aesDecrypt(): init - Invalid key!");
      }
    }
    catch (InvalidAlgorithmParameterException paramArrayOfByte1)
    {
      for (;;)
      {
        af.c("Aes", "aesDecrypt(): init - Invalid algorithm parameters !");
      }
    }
    catch (NoSuchPaddingException paramArrayOfByte1)
    {
      for (;;)
      {
        af.c("Aes", "aesDecrypt():  No such filling parameters ");
      }
    }
    catch (BadPaddingException paramArrayOfByte1)
    {
      for (;;)
      {
        af.c("Aes", "aesDecrypt(): False filling parameters!");
      }
    }
    catch (IllegalBlockSizeException paramArrayOfByte1)
    {
      for (;;)
      {
        af.c("Aes", "aesDecrypt(): doFinal - The provided block is not filled with");
      }
    }
  }
  
  private byte[] b(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0)) {
      return new byte[0];
    }
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(1, new SecretKeySpec(g.a(paramString), "AES"), new IvParameterSpec(paramArrayOfByte1));
      paramString = localCipher.doFinal(paramArrayOfByte2);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      af.c("Aes", "aesEncrypt(): getInstance - No such algorithm,transformation");
      return new byte[0];
    }
    catch (InvalidKeyException paramString)
    {
      af.c("Aes", "aesEncrypt(): init - Invalid key!");
      return new byte[0];
    }
    catch (InvalidAlgorithmParameterException paramString)
    {
      af.c("Aes", "aesEncrypt(): init - Invalid algorithm parameters !");
      return new byte[0];
    }
    catch (NoSuchPaddingException paramString)
    {
      af.c("Aes", "aesEncrypt(): No such filling parameters ");
      return new byte[0];
    }
    catch (BadPaddingException paramString)
    {
      af.c("Aes", "aesEncrypt(): False filling parameters!");
      return new byte[0];
    }
    catch (IllegalBlockSizeException paramString)
    {
      af.c("Aes", "aesEncrypt(): doFinal - The provided block is not filled with");
    }
    return new byte[0];
  }
  
  public String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)))
    {
      af.c("Aes", "decrypt: content or key is empty");
      return "";
    }
    paramString1 = g.a(paramString1);
    paramString2 = a(paramString2);
    return a(paramString1, (byte[])paramString2.first, (byte[])paramString2.second);
  }
  
  public String a(String paramString, byte[] paramArrayOfByte)
  {
    return a(paramString, g.a(), paramArrayOfByte);
  }
  
  public String b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = a(paramString1, paramString2.getBytes("UTF-8"));
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      af.b("Aes", "Unsupported Encoding Exception : utf-8");
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.d
 * JD-Core Version:    0.7.0.1
 */