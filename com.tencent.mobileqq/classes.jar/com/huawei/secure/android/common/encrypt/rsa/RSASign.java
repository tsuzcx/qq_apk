package com.huawei.secure.android.common.encrypt.rsa;

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
  private static final String TAG = "RSASign";
  private static final String i = "";
  private static final String s = "SHA256WithRSA";
  
  private static String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString2 = EncryptUtil.getPrivateKey(paramString2);
      if (paramBoolean) {
        return newSign(paramString1, paramString2);
      }
      return sign(paramString1, paramString2);
    }
    b.f(TAG, "sign content or key is null");
    return "";
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
      paramPrivateKey = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sign UnsupportedEncodingException: ");
      localStringBuilder.append(paramString.getMessage());
      b.f(paramPrivateKey, localStringBuilder.toString());
    }
    return "";
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString3 = EncryptUtil.getPublicKey(paramString3);
      if (paramBoolean) {
        return newVerifySign(paramString1, paramString2, paramString3);
      }
      return verifySign(paramString1, paramString2, paramString3);
    }
    b.f(TAG, "content or public key or sign value is null");
    return false;
  }
  
  private static boolean a(String paramString1, String paramString2, PublicKey paramPublicKey, boolean paramBoolean)
  {
    try
    {
      paramBoolean = verifySign(paramString1.getBytes("UTF-8"), Base64.decode(paramString2, 0), paramPublicKey, paramBoolean);
      return paramBoolean;
    }
    catch (Exception paramString1)
    {
      paramString2 = TAG;
      paramPublicKey = new StringBuilder();
      paramPublicKey.append("base64 decode Exception : ");
      paramPublicKey.append(paramString1.getMessage());
      b.f(paramString2, paramPublicKey.toString());
      return false;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString2 = TAG;
      paramPublicKey = new StringBuilder();
      paramPublicKey.append("verifySign UnsupportedEncodingException: ");
      paramPublicKey.append(paramString1.getMessage());
      b.f(paramString2, paramPublicKey.toString());
    }
    return false;
  }
  
  public static String newSign(String paramString1, String paramString2)
  {
    if (!RSASignKS.isBuildVersionHigherThan22())
    {
      b.f(TAG, "sdk version is too low");
      return "";
    }
    return a(paramString1, paramString2, true);
  }
  
  public static String newSign(String paramString, PrivateKey paramPrivateKey)
  {
    if (!RSASignKS.isBuildVersionHigherThan22())
    {
      b.f(TAG, "sdk version is too low");
      return "";
    }
    return a(paramString, paramPrivateKey, true);
  }
  
  public static boolean newVerifySign(String paramString1, String paramString2, String paramString3)
  {
    if (!RSASignKS.isBuildVersionHigherThan22())
    {
      b.f(TAG, "sdk version is too low");
      return false;
    }
    return a(paramString1, paramString2, paramString3, true);
  }
  
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
    if ((paramArrayOfByte != null) && (paramPrivateKey != null) && (RSAEncrypt.isPrivateKeyLengthRight((RSAPrivateKey)paramPrivateKey)))
    {
      if (paramBoolean) {}
      try
      {
        localObject = Signature.getInstance("SHA256WithRSA/PSS");
        ((Signature)localObject).setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
        break label66;
        localObject = Signature.getInstance("SHA256WithRSA");
        label66:
        ((Signature)localObject).initSign(paramPrivateKey);
        ((Signature)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((Signature)localObject).sign();
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        paramPrivateKey = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sign Exception: ");
        ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
        b.f(paramPrivateKey, ((StringBuilder)localObject).toString());
        return arrayOfByte;
      }
      catch (InvalidAlgorithmParameterException paramArrayOfByte)
      {
        paramPrivateKey = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sign InvalidAlgorithmParameterException: ");
        ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
        b.f(paramPrivateKey, ((StringBuilder)localObject).toString());
        return arrayOfByte;
      }
      catch (SignatureException paramArrayOfByte)
      {
        paramPrivateKey = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sign SignatureException: ");
        ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
        b.f(paramPrivateKey, ((StringBuilder)localObject).toString());
        return arrayOfByte;
      }
      catch (InvalidKeyException paramArrayOfByte)
      {
        paramPrivateKey = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sign InvalidKeyException: ");
        ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
        b.f(paramPrivateKey, ((StringBuilder)localObject).toString());
        return arrayOfByte;
      }
      catch (NoSuchAlgorithmException paramArrayOfByte)
      {
        paramPrivateKey = TAG;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sign NoSuchAlgorithmException: ");
        ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
        b.f(paramPrivateKey, ((StringBuilder)localObject).toString());
        return arrayOfByte;
      }
    }
    b.f(TAG, "content or privateKey is null , or length is too short");
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
    if ((paramArrayOfByte1 != null) && (paramPublicKey != null) && (paramArrayOfByte2 != null) && (RSAEncrypt.isPublicKeyLengthRight((RSAPublicKey)paramPublicKey)))
    {
      if (paramBoolean) {}
      try
      {
        Signature localSignature = Signature.getInstance("SHA256WithRSA/PSS");
        localSignature.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
        break label68;
        localSignature = Signature.getInstance("SHA256WithRSA");
        label68:
        localSignature.initVerify(paramPublicKey);
        localSignature.update(paramArrayOfByte1);
        paramBoolean = localSignature.verify(paramArrayOfByte2);
        return paramBoolean;
      }
      catch (Exception paramArrayOfByte1)
      {
        paramArrayOfByte2 = TAG;
        paramPublicKey = new StringBuilder();
        paramPublicKey.append("exception : ");
        paramPublicKey.append(paramArrayOfByte1.getMessage());
        b.f(paramArrayOfByte2, paramPublicKey.toString());
        return false;
      }
      catch (GeneralSecurityException paramArrayOfByte1)
      {
        paramArrayOfByte2 = TAG;
        paramPublicKey = new StringBuilder();
        paramPublicKey.append("check sign exception: ");
        paramPublicKey.append(paramArrayOfByte1.getMessage());
        b.f(paramArrayOfByte2, paramPublicKey.toString());
        return false;
      }
    }
    b.f(TAG, "content or publicKey is null , or length is too short");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.rsa.RSASign
 * JD-Core Version:    0.7.0.1
 */