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
  private static final String TAG = "EncryptUtil";
  private static final String h = "RSA";
  
  @Deprecated
  public static byte[] generateSecureRandom(int paramInt)
  {
    try
    {
      SecureRandom localSecureRandom = new SecureRandom();
      localObject = new byte[paramInt];
      localSecureRandom.nextBytes((byte[])localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      Object localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generate secure random error");
      localStringBuilder.append(localException.getMessage());
      LogsUtil.e((String)localObject, localStringBuilder.toString(), true);
    }
    return new byte[0];
  }
  
  @Deprecated
  public static String generateSecureRandomStr(int paramInt)
  {
    return HexUtil.byteArray2HexStr(generateSecureRandom(paramInt));
  }
  
  @Deprecated
  public static PrivateKey getPrivateKey(String paramString)
  {
    try
    {
      paramString = Base64.decode(paramString, 0);
      try
      {
        paramString = new PKCS8EncodedKeySpec(paramString);
        paramString = KeyFactory.getInstance("RSA").generatePrivate(paramString);
        return paramString;
      }
      catch (GeneralSecurityException paramString)
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("load Key Exception:");
        localStringBuilder.append(paramString.getMessage());
        LogsUtil.e(str, localStringBuilder.toString(), true);
        return null;
      }
    }
    catch (IllegalArgumentException paramString)
    {
      break label78;
    }
    catch (Exception paramString)
    {
      label67:
      label78:
      break label67;
    }
    LogsUtil.e(TAG, "base64 decode Exception", true);
    return null;
    LogsUtil.e(TAG, "base64 decode IllegalArgumentException", true);
    return null;
  }
  
  @Deprecated
  public static RSAPublicKey getPublicKey(String paramString)
  {
    try
    {
      paramString = Base64.decode(paramString, 0);
      try
      {
        paramString = (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(paramString));
        return paramString;
      }
      catch (GeneralSecurityException paramString)
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("load Key Exception:");
        localStringBuilder.append(paramString.getMessage());
        LogsUtil.e(str, localStringBuilder.toString(), true);
        return null;
      }
    }
    catch (IllegalArgumentException paramString)
    {
      break label79;
    }
    catch (Exception paramString)
    {
      label68:
      label79:
      break label68;
    }
    LogsUtil.e(TAG, "base64 decode Exception", true);
    return null;
    LogsUtil.e(TAG, "base64 decode IllegalArgumentException", true);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.util.EncryptUtil
 * JD-Core Version:    0.7.0.1
 */