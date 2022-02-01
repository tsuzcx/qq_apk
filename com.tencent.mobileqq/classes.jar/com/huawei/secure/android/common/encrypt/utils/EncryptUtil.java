package com.huawei.secure.android.common.encrypt.utils;

import android.util.Base64;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class EncryptUtil
{
  private static final String P = "RSA";
  private static final int Q = 256;
  private static final String TAG = "EncryptUtil";
  
  public static byte[] generateSecureRandom(int paramInt)
  {
    try
    {
      SecureRandom localSecureRandom = new SecureRandom();
      byte[] arrayOfByte = new byte[paramInt];
      localSecureRandom.nextBytes(arrayOfByte);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      b.f("EncryptUtil", "generate secure random error" + localException.getMessage());
    }
    return new byte[0];
  }
  
  public static String generateSecureRandomStr(int paramInt)
  {
    return HexUtil.byteArray2HexStr(generateSecureRandom(paramInt));
  }
  
  public static PrivateKey getPrivateKey(String paramString)
  {
    try
    {
      paramString = Base64.decode(paramString, 0);
      return null;
    }
    catch (IllegalArgumentException paramString)
    {
      try
      {
        paramString = new PKCS8EncodedKeySpec(paramString);
        paramString = KeyFactory.getInstance("RSA").generatePrivate(paramString);
        return paramString;
      }
      catch (GeneralSecurityException paramString)
      {
        b.f("EncryptUtil", "load Key Exception:" + paramString.getMessage());
      }
      paramString = paramString;
      b.f("EncryptUtil", "base64 decode IllegalArgumentException");
      return null;
    }
    catch (Exception paramString)
    {
      b.f("EncryptUtil", "base64 decode Exception" + paramString.getMessage());
      return null;
    }
  }
  
  public static RSAPublicKey getPublicKey(String paramString)
  {
    try
    {
      paramString = Base64.decode(paramString, 0);
      return null;
    }
    catch (IllegalArgumentException paramString)
    {
      try
      {
        paramString = (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(paramString));
        return paramString;
      }
      catch (GeneralSecurityException paramString)
      {
        b.f("EncryptUtil", "load Key Exception:" + paramString.getMessage());
      }
      paramString = paramString;
      b.f("EncryptUtil", "base64 decode IllegalArgumentException");
      return null;
    }
    catch (Exception paramString)
    {
      b.f("EncryptUtil", "base64 decode Exception" + paramString.getMessage());
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.utils.EncryptUtil
 * JD-Core Version:    0.7.0.1
 */