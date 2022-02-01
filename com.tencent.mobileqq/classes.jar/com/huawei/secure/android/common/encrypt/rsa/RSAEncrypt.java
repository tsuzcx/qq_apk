package com.huawei.secure.android.common.encrypt.rsa;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

public abstract class RSAEncrypt
{
  private static final String CHARSET = "UTF-8";
  private static final int H = 2048;
  private static final String K = "RSA";
  private static final String TAG = "RSAEncrypt";
  private static final String i = "";
  private static final String s = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
  
  public static String decrypt(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      b.f("RSAEncrypt", "content or private key is null");
      return "";
    }
    return decrypt(paramString1, EncryptUtil.getPrivateKey(paramString2));
  }
  
  public static String decrypt(String paramString, PrivateKey paramPrivateKey)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramPrivateKey == null) || (!isPrivateKeyLengthRight((RSAPrivateKey)paramPrivateKey)))
    {
      b.f("RSAEncrypt", "content or privateKey is null , or length is too short");
      return "";
    }
    try
    {
      paramString = new String(decrypt(Base64.decode(paramString, 0), paramPrivateKey), "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      b.f("RSAEncrypt", "RSA decrypt exception : " + paramString.getMessage());
      return "";
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        b.f("RSAEncrypt", "exception : " + paramString.getMessage());
      }
    }
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte, PrivateKey paramPrivateKey)
  {
    byte[] arrayOfByte = new byte[0];
    if ((paramArrayOfByte == null) || (paramPrivateKey == null) || (!isPrivateKeyLengthRight((RSAPrivateKey)paramPrivateKey)))
    {
      b.f("RSAEncrypt", "content or privateKey is null , or length is too short");
      return arrayOfByte;
    }
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
      localCipher.init(2, paramPrivateKey);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (GeneralSecurityException paramArrayOfByte)
    {
      b.f("RSAEncrypt", "RSA decrypt exception : " + paramArrayOfByte.getMessage());
    }
    return arrayOfByte;
  }
  
  public static String encrypt(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      b.f("RSAEncrypt", "content or public key is null");
      return "";
    }
    return encrypt(paramString1, EncryptUtil.getPublicKey(paramString2));
  }
  
  public static String encrypt(String paramString, PublicKey paramPublicKey)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramPublicKey == null) || (!isPublicKeyLengthRight((RSAPublicKey)paramPublicKey)))
    {
      b.f("RSAEncrypt", "content or PublicKey is null , or length is too short");
      return "";
    }
    try
    {
      paramString = Base64.encodeToString(encrypt(paramString.getBytes("UTF-8"), paramPublicKey), 0);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      b.f("RSAEncrypt", "encrypt: UnsupportedEncodingException");
      return "";
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        b.f("RSAEncrypt", "exception : " + paramString.getMessage());
      }
    }
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte, PublicKey paramPublicKey)
  {
    byte[] arrayOfByte = new byte[0];
    if ((paramArrayOfByte == null) || (paramPublicKey == null) || (!isPublicKeyLengthRight((RSAPublicKey)paramPublicKey)))
    {
      b.f("RSAEncrypt", "content or PublicKey is null , or length is too short");
      return arrayOfByte;
    }
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
      localCipher.init(1, paramPublicKey);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (GeneralSecurityException paramArrayOfByte)
    {
      b.f("RSAEncrypt", "RSA encrypt exception : " + paramArrayOfByte.getMessage());
    }
    return arrayOfByte;
  }
  
  public static Map<String, Key> generateRSAKeyPair(int paramInt)
  {
    HashMap localHashMap = new HashMap(2);
    if (paramInt < 2048)
    {
      b.f("RSAEncrypt", "generateRSAKeyPair: key length is too short");
      return localHashMap;
    }
    Object localObject1 = new SecureRandom();
    Object localObject2 = KeyPairGenerator.getInstance("RSA");
    ((KeyPairGenerator)localObject2).initialize(paramInt, (SecureRandom)localObject1);
    localObject2 = ((KeyPairGenerator)localObject2).generateKeyPair();
    localObject1 = ((KeyPair)localObject2).getPublic();
    localObject2 = ((KeyPair)localObject2).getPrivate();
    localHashMap.put("publicKey", localObject1);
    localHashMap.put("privateKey", localObject2);
    return localHashMap;
  }
  
  public static boolean isPrivateKeyLengthRight(RSAPrivateKey paramRSAPrivateKey)
  {
    if (paramRSAPrivateKey == null) {}
    while (paramRSAPrivateKey.getModulus().bitLength() < 2048) {
      return false;
    }
    return true;
  }
  
  public static boolean isPublicKeyLengthRight(RSAPublicKey paramRSAPublicKey)
  {
    if (paramRSAPublicKey == null) {}
    while (paramRSAPublicKey.getModulus().bitLength() < 2048) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.rsa.RSAEncrypt
 * JD-Core Version:    0.7.0.1
 */