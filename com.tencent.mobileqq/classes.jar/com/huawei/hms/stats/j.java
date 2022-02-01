package com.huawei.hms.stats;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class j
  implements i
{
  private PublicKey a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new X509EncodedKeySpec(paramArrayOfByte);
    return KeyFactory.getInstance("RSA").generatePublic(paramArrayOfByte);
  }
  
  private byte[] a(byte[] paramArrayOfByte, PublicKey paramPublicKey)
  {
    if (paramPublicKey == null) {}
    try
    {
      throw new UnsupportedEncodingException("The loaded public key is null");
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      af.c("Rsa", "rsaEncrypt(): getBytes - Unsupported coding format!");
      return new byte[0];
      Cipher localCipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
      localCipher.init(1, paramPublicKey);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      for (;;)
      {
        af.c("Rsa", "rsaEncrypt(): getInstance - No such algorithm,transformation");
      }
    }
    catch (InvalidKeyException paramArrayOfByte)
    {
      for (;;)
      {
        af.c("Rsa", "rsaEncrypt(): init - Invalid key!");
      }
    }
    catch (NoSuchPaddingException paramArrayOfByte)
    {
      for (;;)
      {
        af.c("Rsa", "rsaEncrypt():  No such filling parameters ");
      }
    }
    catch (BadPaddingException paramArrayOfByte)
    {
      for (;;)
      {
        af.c("Rsa", "rsaEncrypt():False filling parameters!");
      }
    }
    catch (IllegalBlockSizeException paramArrayOfByte)
    {
      for (;;)
      {
        af.c("Rsa", "rsaEncrypt(): doFinal - The provided block is not filled with");
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    af.b("Rsa", "No RSA decryption method");
    return "";
  }
  
  public String a(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      af.c("Rsa", "encrypt: content is empty or null");
      return "";
    }
    try
    {
      paramString = g.a(a(paramArrayOfByte, a(g.a(paramString))));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      af.c("Rsa", "encrypt(): getInstance - No such algorithm,transformation");
      return "";
    }
    catch (InvalidKeySpecException paramString)
    {
      for (;;)
      {
        af.c("Rsa", "encrypt(): Invalid key specification");
      }
    }
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
      af.b("Rsa", "Unsupported encoding exception,utf-8");
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.j
 * JD-Core Version:    0.7.0.1
 */