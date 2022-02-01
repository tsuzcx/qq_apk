package com.huawei.secure.android.common.encrypt.keystore.rsa;

import android.os.Build.VERSION;
import android.security.keystore.KeyGenParameterSpec.Builder;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource.PSpecified;

public abstract class RSAEncryptKS
{
  private static final String C = "AndroidKeyStore";
  private static final String G = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
  private static final int H = 2048;
  private static final int I = 3072;
  private static final String TAG = "RSAEncryptKS";
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
      b.d(TAG, "generate key pair.");
      try
      {
        localObject2 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
        if (!paramBoolean) {
          ((KeyPairGenerator)localObject2).initialize(new KeyGenParameterSpec.Builder(paramString, 2).setDigests(new String[] { "SHA-256", "SHA-512" }).setEncryptionPaddings(new String[] { "OAEPPadding" }).setKeySize(2048).build());
        } else {
          ((KeyPairGenerator)localObject2).initialize(new KeyGenParameterSpec.Builder(paramString, 2).setDigests(new String[] { "SHA-256", "SHA-512" }).setEncryptionPaddings(new String[] { "OAEPPadding" }).setKeySize(3072).build());
        }
        paramString = ((KeyPairGenerator)localObject2).generateKeyPair();
      }
      catch (Exception paramString)
      {
        localObject2 = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Exception: ");
        localStringBuilder.append(paramString.getMessage());
        b.f((String)localObject2, localStringBuilder.toString());
        paramString = localObject1;
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
  
  private static byte[] a(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[0];
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte != null))
    {
      if (!isBuildVersionHigherThan22())
      {
        b.f(TAG, "sdk version is too low");
        return arrayOfByte;
      }
      paramString = b(paramString, paramBoolean);
      if (paramString == null)
      {
        b.f(TAG, "Public key is null");
        return arrayOfByte;
      }
      try
      {
        localObject = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        ((Cipher)localObject).init(1, paramString, new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
        paramString = ((Cipher)localObject).doFinal(paramArrayOfByte);
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
      catch (BadPaddingException paramString)
      {
        paramArrayOfByte = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("BadPaddingException: ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        b.f(paramArrayOfByte, ((StringBuilder)localObject).toString());
        return arrayOfByte;
      }
      catch (IllegalBlockSizeException paramString)
      {
        paramArrayOfByte = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("IllegalBlockSizeException: ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        b.f(paramArrayOfByte, ((StringBuilder)localObject).toString());
        return arrayOfByte;
      }
      catch (InvalidAlgorithmParameterException paramString)
      {
        paramArrayOfByte = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("InvalidAlgorithmParameterException: ");
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
      catch (NoSuchPaddingException paramString)
      {
        paramArrayOfByte = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("NoSuchPaddingException: ");
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
  
  private static PublicKey b(String paramString, boolean paramBoolean)
  {
    if (!g(paramString)) {
      a(paramString, paramBoolean);
    }
    paramString = f(paramString);
    if (paramString != null) {
      return paramString.getPublicKey();
    }
    return null;
  }
  
  @Deprecated
  public static String decrpyt(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new String(decrpyt(paramString1, Base64.decode(paramString2, 0)), "UTF-8");
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString2 = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception: ");
      localStringBuilder.append(paramString1.getMessage());
      b.f(paramString2, localStringBuilder.toString());
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UnsupportedEncodingException: ");
      localStringBuilder.append(paramString1.getMessage());
      b.f(paramString2, localStringBuilder.toString());
    }
    return "";
  }
  
  @Deprecated
  public static byte[] decrpyt(String paramString, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[0];
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte != null))
    {
      if (!isBuildVersionHigherThan22())
      {
        b.f(TAG, "sdk version is too low");
        return arrayOfByte;
      }
      paramString = getPrivateKey(paramString);
      if (paramString == null)
      {
        b.f(TAG, "Private key is null");
        return arrayOfByte;
      }
      try
      {
        localObject = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        ((Cipher)localObject).init(2, paramString, new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
        paramString = ((Cipher)localObject).doFinal(paramArrayOfByte);
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
      catch (BadPaddingException paramString)
      {
        paramArrayOfByte = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("BadPaddingException: ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        b.f(paramArrayOfByte, ((StringBuilder)localObject).toString());
        return arrayOfByte;
      }
      catch (IllegalBlockSizeException paramString)
      {
        paramArrayOfByte = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("IllegalBlockSizeException: ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        b.f(paramArrayOfByte, ((StringBuilder)localObject).toString());
        return arrayOfByte;
      }
      catch (InvalidAlgorithmParameterException paramString)
      {
        paramArrayOfByte = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("InvalidAlgorithmParameterException: ");
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
      catch (NoSuchPaddingException paramString)
      {
        paramArrayOfByte = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("NoSuchPaddingException: ");
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
    b.f(TAG, "alias or encrypted content is null");
    return arrayOfByte;
  }
  
  public static String decrpytNew(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new String(decrpytNew(paramString1, Base64.decode(paramString2, 0)), "UTF-8");
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString2 = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception: ");
      localStringBuilder.append(paramString1.getMessage());
      b.f(paramString2, localStringBuilder.toString());
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UnsupportedEncodingException: ");
      localStringBuilder.append(paramString1.getMessage());
      b.f(paramString2, localStringBuilder.toString());
    }
    return "";
  }
  
  public static byte[] decrpytNew(String paramString, byte[] paramArrayOfByte)
  {
    return decrpyt(paramString, paramArrayOfByte);
  }
  
  @Deprecated
  public static String encrypt(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      try
      {
        paramString1 = Base64.encodeToString(encrypt(paramString1, paramString2.getBytes("UTF-8")), 0);
        return paramString1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString2 = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("UnsupportedEncodingException: ");
        localStringBuilder.append(paramString1.getMessage());
        b.f(paramString2, localStringBuilder.toString());
      }
    }
    return "";
  }
  
  @Deprecated
  public static byte[] encrypt(String paramString, byte[] paramArrayOfByte)
  {
    return a(paramString, paramArrayOfByte, false);
  }
  
  public static String encryptNew(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      try
      {
        paramString1 = Base64.encodeToString(encryptNew(paramString1, paramString2.getBytes("UTF-8")), 0);
        return paramString1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString2 = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("UnsupportedEncodingException: ");
        localStringBuilder.append(paramString1.getMessage());
        b.f(paramString2, localStringBuilder.toString());
      }
    }
    return "";
  }
  
  public static byte[] encryptNew(String paramString, byte[] paramArrayOfByte)
  {
    return a(paramString, paramArrayOfByte, true);
  }
  
  private static Certificate f(String paramString)
  {
    try
    {
      localObject = KeyStore.getInstance("AndroidKeyStore");
      ((KeyStore)localObject).load(null);
      paramString = ((KeyStore)localObject).getCertificate(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception: ");
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
    catch (Exception paramString)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception: ");
      localStringBuilder.append(paramString.getMessage());
      b.f((String)localObject, localStringBuilder.toString());
      return false;
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
  
  private static PrivateKey getPrivateKey(String paramString)
  {
    if (!g(paramString)) {
      return null;
    }
    try
    {
      localObject = KeyStore.getInstance("AndroidKeyStore");
      ((KeyStore)localObject).load(null);
      paramString = (PrivateKey)((KeyStore)localObject).getKey(paramString, null);
      return paramString;
    }
    catch (Exception paramString)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception: ");
      localStringBuilder.append(paramString.getMessage());
      b.f((String)localObject, localStringBuilder.toString());
    }
    catch (IOException paramString)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("IOException: ");
      localStringBuilder.append(paramString.getMessage());
      b.f((String)localObject, localStringBuilder.toString());
    }
    catch (NoSuchAlgorithmException paramString)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("NoSuchAlgorithmException: ");
      localStringBuilder.append(paramString.getMessage());
      b.f((String)localObject, localStringBuilder.toString());
    }
    catch (UnrecoverableKeyException paramString)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("UnrecoverableKeyException: ");
      localStringBuilder.append(paramString.getMessage());
      b.f((String)localObject, localStringBuilder.toString());
    }
    catch (CertificateException paramString)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("CertificateException: ");
      localStringBuilder.append(paramString.getMessage());
      b.f((String)localObject, localStringBuilder.toString());
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
  
  private static boolean isBuildVersionHigherThan22()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.keystore.rsa.RSAEncryptKS
 * JD-Core Version:    0.7.0.1
 */