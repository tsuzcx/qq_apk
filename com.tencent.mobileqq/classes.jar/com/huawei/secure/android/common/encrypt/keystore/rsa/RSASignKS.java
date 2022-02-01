package com.huawei.secure.android.common.encrypt.keystore.rsa;

import android.os.Build.VERSION;
import android.security.keystore.KeyGenParameterSpec.Builder;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStore.Entry;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

public abstract class RSASignKS
{
  private static final String C = "AndroidKeyStore";
  private static final int H = 2048;
  private static final int I = 3072;
  private static final String J = "SHA256withRSA/PSS";
  private static final String TAG = "RSASignKS";
  private static final String i = "";
  
  private static KeyPair a(String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = g(paramString);
      Object localObject1 = null;
      if (bool)
      {
        b.f(TAG, "Key pair exits");
        return null;
      }
      try
      {
        localObject2 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
        if (!paramBoolean) {
          ((KeyPairGenerator)localObject2).initialize(new KeyGenParameterSpec.Builder(paramString, 12).setDigests(new String[] { "SHA-256", "SHA-512" }).setSignaturePaddings(new String[] { "PSS" }).setKeySize(2048).build());
        } else {
          ((KeyPairGenerator)localObject2).initialize(new KeyGenParameterSpec.Builder(paramString, 12).setDigests(new String[] { "SHA-256", "SHA-512" }).setSignaturePaddings(new String[] { "PSS" }).setKeySize(3072).build());
        }
        paramString = ((KeyPairGenerator)localObject2).generateKeyPair();
      }
      catch (InvalidAlgorithmParameterException paramString)
      {
        localObject2 = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("InvalidAlgorithmParameterException: ");
        localStringBuilder.append(paramString.getMessage());
        b.f((String)localObject2, localStringBuilder.toString());
        paramString = localObject1;
      }
      catch (NoSuchProviderException paramString)
      {
        localObject2 = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("NoSuchProviderException: ");
        localStringBuilder.append(paramString.getMessage());
        b.f((String)localObject2, localStringBuilder.toString());
        paramString = localObject1;
      }
      catch (NoSuchAlgorithmException paramString)
      {
        Object localObject2 = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("NoSuchAlgorithmException: ");
        localStringBuilder.append(paramString.getMessage());
        b.f((String)localObject2, localStringBuilder.toString());
        paramString = localObject1;
      }
      return paramString;
    }
    finally {}
  }
  
  private static boolean a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      if (!isBuildVersionHigherThan22())
      {
        b.f(TAG, "sdk version is too low");
        return false;
      }
      paramString = c(paramString, paramBoolean);
      if (!(paramString instanceof KeyStore.PrivateKeyEntry))
      {
        b.f(TAG, "Not an instance of a PrivateKeyEntry");
        return false;
      }
      try
      {
        Signature localSignature = Signature.getInstance("SHA256withRSA/PSS");
        localSignature.initVerify(((KeyStore.PrivateKeyEntry)paramString).getCertificate());
        localSignature.update(paramArrayOfByte1);
        paramBoolean = localSignature.verify(paramArrayOfByte2);
        return paramBoolean;
      }
      catch (Exception paramString)
      {
        paramArrayOfByte1 = TAG;
        paramArrayOfByte2 = new StringBuilder();
        paramArrayOfByte2.append("Exception: ");
        paramArrayOfByte2.append(paramString.getMessage());
        b.f(paramArrayOfByte1, paramArrayOfByte2.toString());
        return false;
      }
      catch (InvalidKeyException paramString)
      {
        paramArrayOfByte1 = TAG;
        paramArrayOfByte2 = new StringBuilder();
        paramArrayOfByte2.append("InvalidKeyException: ");
        paramArrayOfByte2.append(paramString.getMessage());
        b.f(paramArrayOfByte1, paramArrayOfByte2.toString());
        return false;
      }
      catch (SignatureException paramString)
      {
        paramArrayOfByte1 = TAG;
        paramArrayOfByte2 = new StringBuilder();
        paramArrayOfByte2.append("SignatureException: ");
        paramArrayOfByte2.append(paramString.getMessage());
        b.f(paramArrayOfByte1, paramArrayOfByte2.toString());
        return false;
      }
      catch (NoSuchAlgorithmException paramString)
      {
        paramArrayOfByte1 = TAG;
        paramArrayOfByte2 = new StringBuilder();
        paramArrayOfByte2.append("NoSuchAlgorithmException: ");
        paramArrayOfByte2.append(paramString.getMessage());
        b.f(paramArrayOfByte1, paramArrayOfByte2.toString());
        return false;
      }
    }
    b.f(TAG, "alias or content or sign value is null");
    return false;
  }
  
  private static byte[] b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[0];
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte != null))
    {
      if (!isBuildVersionHigherThan22())
      {
        b.f(TAG, "sdk version is too low");
        return arrayOfByte;
      }
      paramString = c(paramString, paramBoolean);
      if (!(paramString instanceof KeyStore.PrivateKeyEntry))
      {
        b.f(TAG, "Not an instance of a PrivateKeyEntry");
        return arrayOfByte;
      }
      try
      {
        localObject = Signature.getInstance("SHA256withRSA/PSS");
        ((Signature)localObject).initSign(((KeyStore.PrivateKeyEntry)paramString).getPrivateKey());
        ((Signature)localObject).update(paramArrayOfByte);
        paramString = ((Signature)localObject).sign();
        return paramString;
      }
      catch (Exception paramString)
      {
        paramArrayOfByte = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Exception: ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        b.f(paramArrayOfByte, ((StringBuilder)localObject).toString());
        return arrayOfByte;
      }
      catch (InvalidKeyException paramString)
      {
        paramArrayOfByte = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("InvalidKeyException: ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        b.f(paramArrayOfByte, ((StringBuilder)localObject).toString());
        return arrayOfByte;
      }
      catch (SignatureException paramString)
      {
        paramArrayOfByte = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SignatureException: ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        b.f(paramArrayOfByte, ((StringBuilder)localObject).toString());
        return arrayOfByte;
      }
      catch (NoSuchAlgorithmException paramString)
      {
        paramArrayOfByte = TAG;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("NoSuchAlgorithmException: ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        b.f(paramArrayOfByte, ((StringBuilder)localObject).toString());
        return arrayOfByte;
      }
    }
    b.f(TAG, "alias or content is null");
    return arrayOfByte;
  }
  
  private static KeyStore.Entry c(String paramString, boolean paramBoolean)
  {
    if (!g(paramString)) {
      a(paramString, paramBoolean);
    }
    try
    {
      localObject = KeyStore.getInstance("AndroidKeyStore");
      ((KeyStore)localObject).load(null);
      paramString = ((KeyStore)localObject).getEntry(paramString, null);
      return paramString;
    }
    catch (UnrecoverableEntryException paramString)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("UnrecoverableEntryException: ");
      localStringBuilder.append(paramString.getMessage());
      b.f((String)localObject, localStringBuilder.toString());
      return null;
    }
    catch (IOException paramString)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("IOException: ");
      localStringBuilder.append(paramString.getMessage());
      b.f((String)localObject, localStringBuilder.toString());
      return null;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("NoSuchAlgorithmException: ");
      localStringBuilder.append(paramString.getMessage());
      b.f((String)localObject, localStringBuilder.toString());
      return null;
    }
    catch (CertificateException paramString)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("CertificateException: ");
      localStringBuilder.append(paramString.getMessage());
      b.f((String)localObject, localStringBuilder.toString());
      return null;
    }
    catch (KeyStoreException paramString)
    {
      Object localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("KeyStoreException: ");
      localStringBuilder.append(paramString.getMessage());
      b.f((String)localObject, localStringBuilder.toString());
    }
    return null;
  }
  
  private static boolean g(String paramString)
  {
    boolean bool = false;
    try
    {
      localObject = KeyStore.getInstance("AndroidKeyStore");
      ((KeyStore)localObject).load(null);
      paramString = ((KeyStore)localObject).getKey(paramString, null);
      if (paramString != null) {
        bool = true;
      }
      return bool;
    }
    catch (IOException paramString)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("IOException: ");
      localStringBuilder.append(paramString.getMessage());
      b.f((String)localObject, localStringBuilder.toString());
      return false;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("NoSuchAlgorithmException: ");
      localStringBuilder.append(paramString.getMessage());
      b.f((String)localObject, localStringBuilder.toString());
      return false;
    }
    catch (UnrecoverableKeyException paramString)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("UnrecoverableKeyException: ");
      localStringBuilder.append(paramString.getMessage());
      b.f((String)localObject, localStringBuilder.toString());
      return false;
    }
    catch (CertificateException paramString)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("CertificateException: ");
      localStringBuilder.append(paramString.getMessage());
      b.f((String)localObject, localStringBuilder.toString());
      return false;
    }
    catch (KeyStoreException paramString)
    {
      Object localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("KeyStoreException: ");
      localStringBuilder.append(paramString.getMessage());
      b.f((String)localObject, localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean isBuildVersionHigherThan22()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  @Deprecated
  public static String sign(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = Base64.encodeToString(sign(paramString1, paramString2.getBytes("UTF-8")), 0);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sign UnsupportedEncodingException : ");
      localStringBuilder.append(paramString1.getMessage());
      Log.e(paramString2, localStringBuilder.toString());
    }
    return "";
  }
  
  @Deprecated
  public static byte[] sign(String paramString, byte[] paramArrayOfByte)
  {
    return b(paramString, paramArrayOfByte, false);
  }
  
  public static String signNew(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = Base64.encodeToString(signNew(paramString1, paramString2.getBytes("UTF-8")), 0);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sign UnsupportedEncodingException : ");
      localStringBuilder.append(paramString1.getMessage());
      Log.e(paramString2, localStringBuilder.toString());
    }
    return "";
  }
  
  public static byte[] signNew(String paramString, byte[] paramArrayOfByte)
  {
    return b(paramString, paramArrayOfByte, true);
  }
  
  @Deprecated
  public static boolean verifySign(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      boolean bool = verifySign(paramString1, paramString2.getBytes("UTF-8"), Base64.decode(paramString3, 0));
      return bool;
    }
    catch (Exception paramString1)
    {
      paramString2 = TAG;
      paramString3 = new StringBuilder();
      paramString3.append("base64 decode Exception");
      paramString3.append(paramString1.getMessage());
      b.f(paramString2, paramString3.toString());
      return false;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString2 = TAG;
      paramString3 = new StringBuilder();
      paramString3.append("verifySign UnsupportedEncodingException: ");
      paramString3.append(paramString1.getMessage());
      Log.e(paramString2, paramString3.toString());
    }
    return false;
  }
  
  @Deprecated
  public static boolean verifySign(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return a(paramString, paramArrayOfByte1, paramArrayOfByte2, false);
  }
  
  public static boolean verifySignNew(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      boolean bool = verifySignNew(paramString1, paramString2.getBytes("UTF-8"), Base64.decode(paramString3, 0));
      return bool;
    }
    catch (Exception paramString1)
    {
      paramString2 = TAG;
      paramString3 = new StringBuilder();
      paramString3.append("base64 decode Exception");
      paramString3.append(paramString1.getMessage());
      b.f(paramString2, paramString3.toString());
      return false;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString2 = TAG;
      paramString3 = new StringBuilder();
      paramString3.append("verifySign UnsupportedEncodingException: ");
      paramString3.append(paramString1.getMessage());
      Log.e(paramString2, paramString3.toString());
    }
    return false;
  }
  
  public static boolean verifySignNew(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return a(paramString, paramArrayOfByte1, paramArrayOfByte2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.keystore.rsa.RSASignKS
 * JD-Core Version:    0.7.0.1
 */