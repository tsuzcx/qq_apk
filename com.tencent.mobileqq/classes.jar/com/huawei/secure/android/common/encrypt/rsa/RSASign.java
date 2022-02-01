package com.huawei.secure.android.common.encrypt.rsa;

import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.keystore.rsa.RSASignKS;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;

public abstract class RSASign
{
  private static final String CHARSET = "UTF-8";
  private static final String L = "SHA256WithRSA/PSS";
  private static final String TAG = RSASign.class.getSimpleName();
  private static final String i = "";
  private static final String s = "SHA256WithRSA";
  
  private static String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      b.f(TAG, "sign content or key is null");
      return "";
    }
    paramString2 = EncryptUtil.getPrivateKey(paramString2);
    if (paramBoolean) {
      return newSign(paramString1, paramString2);
    }
    return sign(paramString1, paramString2);
  }
  
  private static String a(String paramString, PrivateKey paramPrivateKey, boolean paramBoolean)
  {
    try
    {
      paramString = Base64.encodeToString(sign(paramString.getBytes("UTF-8"), paramPrivateKey, paramBoolean), 0);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      b.f(TAG, "sign UnsupportedEncodingException: " + paramString.getMessage());
    }
    return "";
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString2)))
    {
      b.f(TAG, "content or public key or sign value is null");
      return false;
    }
    paramString3 = EncryptUtil.getPublicKey(paramString3);
    if (paramBoolean) {
      return newVerifySign(paramString1, paramString2, paramString3);
    }
    return verifySign(paramString1, paramString2, paramString3);
  }
  
  private static boolean a(String paramString1, String paramString2, PublicKey paramPublicKey, boolean paramBoolean)
  {
    try
    {
      paramBoolean = verifySign(paramString1.getBytes("UTF-8"), Base64.decode(paramString2, 0), paramPublicKey, paramBoolean);
      return paramBoolean;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      b.f(TAG, "verifySign UnsupportedEncodingException: " + paramString1.getMessage());
      return false;
    }
    catch (Exception paramString1)
    {
      b.f(TAG, "base64 decode Exception : " + paramString1.getMessage());
    }
    return false;
  }
  
  @RequiresApi(api=23)
  public static String newSign(String paramString1, String paramString2)
  {
    if (!RSASignKS.isBuildVersionHigherThan22())
    {
      b.f(TAG, "sdk version is too low");
      return "";
    }
    return a(paramString1, paramString2, true);
  }
  
  @RequiresApi(api=23)
  public static String newSign(String paramString, PrivateKey paramPrivateKey)
  {
    if (!RSASignKS.isBuildVersionHigherThan22())
    {
      b.f(TAG, "sdk version is too low");
      return "";
    }
    return a(paramString, paramPrivateKey, true);
  }
  
  @RequiresApi(api=23)
  public static boolean newVerifySign(String paramString1, String paramString2, String paramString3)
  {
    if (!RSASignKS.isBuildVersionHigherThan22())
    {
      b.f(TAG, "sdk version is too low");
      return false;
    }
    return a(paramString1, paramString2, paramString3, true);
  }
  
  @RequiresApi(api=23)
  public static boolean newVerifySign(String paramString1, String paramString2, PublicKey paramPublicKey)
  {
    if (!RSASignKS.isBuildVersionHigherThan22())
    {
      b.f(TAG, "sdk version is too low");
      return false;
    }
    return a(paramString1, paramString2, paramPublicKey, true);
  }
  
  @Deprecated
  public static String sign(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, false);
  }
  
  @Deprecated
  public static String sign(String paramString, PrivateKey paramPrivateKey)
  {
    return a(paramString, paramPrivateKey, false);
  }
  
  public static byte[] sign(byte[] paramArrayOfByte, PrivateKey paramPrivateKey, boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[0];
    if ((paramArrayOfByte == null) || (paramPrivateKey == null) || (!RSAEncrypt.isPrivateKeyLengthRight((RSAPrivateKey)paramPrivateKey)))
    {
      b.f(TAG, "content or privateKey is null , or length is too short");
      return arrayOfByte;
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localSignature = Signature.getInstance("SHA256WithRSA/PSS");
        localSignature.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
        localSignature.initSign(paramPrivateKey);
        localSignature.update(paramArrayOfByte);
        return localSignature.sign();
      }
      catch (NoSuchAlgorithmException paramArrayOfByte)
      {
        Signature localSignature;
        b.f(TAG, "sign NoSuchAlgorithmException: " + paramArrayOfByte.getMessage());
        return arrayOfByte;
      }
      catch (InvalidKeyException paramArrayOfByte)
      {
        b.f(TAG, "sign InvalidKeyException: " + paramArrayOfByte.getMessage());
        return arrayOfByte;
      }
      catch (SignatureException paramArrayOfByte)
      {
        b.f(TAG, "sign SignatureException: " + paramArrayOfByte.getMessage());
        return arrayOfByte;
      }
      catch (InvalidAlgorithmParameterException paramArrayOfByte)
      {
        b.f(TAG, "sign InvalidAlgorithmParameterException: " + paramArrayOfByte.getMessage());
        return arrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        b.f(TAG, "sign Exception: " + paramArrayOfByte.getMessage());
      }
      localSignature = Signature.getInstance("SHA256WithRSA");
    }
    return arrayOfByte;
  }
  
  @Deprecated
  public static boolean verifySign(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, paramString3, false);
  }
  
  @Deprecated
  public static boolean verifySign(String paramString1, String paramString2, PublicKey paramPublicKey)
  {
    return a(paramString1, paramString2, paramPublicKey, false);
  }
  
  public static boolean verifySign(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PublicKey paramPublicKey, boolean paramBoolean)
  {
    if ((paramArrayOfByte1 == null) || (paramPublicKey == null) || (paramArrayOfByte2 == null) || (!RSAEncrypt.isPublicKeyLengthRight((RSAPublicKey)paramPublicKey)))
    {
      b.f(TAG, "content or publicKey is null , or length is too short");
      return false;
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localSignature = Signature.getInstance("SHA256WithRSA/PSS");
        localSignature.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
        localSignature.initVerify(paramPublicKey);
        localSignature.update(paramArrayOfByte1);
        return localSignature.verify(paramArrayOfByte2);
      }
      catch (GeneralSecurityException paramArrayOfByte1)
      {
        Signature localSignature;
        b.f(TAG, "check sign exception: " + paramArrayOfByte1.getMessage());
        return false;
      }
      catch (Exception paramArrayOfByte1)
      {
        b.f(TAG, "exception : " + paramArrayOfByte1.getMessage());
        continue;
      }
      localSignature = Signature.getInstance("SHA256WithRSA");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.rsa.RSASign
 * JD-Core Version:    0.7.0.1
 */