package com.huawei.secure.android.common.util;

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
  private static final String TAG = EncryptUtil.class.getSimpleName();
  private static final String h = "RSA";
  
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
      LogsUtil.e(TAG, "generate secure random error" + localException.getMessage(), true);
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
        LogsUtil.e(TAG, "load Key Exception:" + paramString.getMessage(), true);
      }
      paramString = paramString;
      LogsUtil.e(TAG, "base64 decode IllegalArgumentException", true);
      return null;
    }
    catch (Exception paramString)
    {
      LogsUtil.e(TAG, "base64 decode Exception", true);
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
        LogsUtil.e(TAG, "load Key Exception:" + paramString.getMessage(), true);
      }
      paramString = paramString;
      LogsUtil.e(TAG, "base64 decode IllegalArgumentException", true);
      return null;
    }
    catch (Exception paramString)
    {
      LogsUtil.e(TAG, "base64 decode Exception", true);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.util.EncryptUtil
 * JD-Core Version:    0.7.0.1
 */