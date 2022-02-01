package com.huawei.secure.android.common.encrypt.keystore.rsa;

import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStore.Entry;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
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
  private static final String TAG = RSASignKS.class.getSimpleName();
  private static final String i = "";
  
  /* Error */
  @RequiresApi(api=23)
  private static java.security.KeyPair a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: invokestatic 48	com/huawei/secure/android/common/encrypt/keystore/rsa/RSASignKS:g	(Ljava/lang/String;)Z
    //   9: ifeq +18 -> 27
    //   12: getstatic 29	com/huawei/secure/android/common/encrypt/keystore/rsa/RSASignKS:TAG	Ljava/lang/String;
    //   15: ldc 50
    //   17: invokestatic 56	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_2
    //   21: astore_0
    //   22: ldc 2
    //   24: monitorexit
    //   25: aload_0
    //   26: areturn
    //   27: ldc 58
    //   29: ldc 8
    //   31: invokestatic 64	java/security/KeyPairGenerator:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljava/security/KeyPairGenerator;
    //   34: astore_3
    //   35: iload_1
    //   36: ifne +63 -> 99
    //   39: aload_3
    //   40: new 66	android/security/keystore/KeyGenParameterSpec$Builder
    //   43: dup
    //   44: aload_0
    //   45: bipush 12
    //   47: invokespecial 69	android/security/keystore/KeyGenParameterSpec$Builder:<init>	(Ljava/lang/String;I)V
    //   50: iconst_2
    //   51: anewarray 71	java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: ldc 73
    //   58: aastore
    //   59: dup
    //   60: iconst_1
    //   61: ldc 75
    //   63: aastore
    //   64: invokevirtual 79	android/security/keystore/KeyGenParameterSpec$Builder:setDigests	([Ljava/lang/String;)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   67: iconst_1
    //   68: anewarray 71	java/lang/String
    //   71: dup
    //   72: iconst_0
    //   73: ldc 81
    //   75: aastore
    //   76: invokevirtual 84	android/security/keystore/KeyGenParameterSpec$Builder:setSignaturePaddings	([Ljava/lang/String;)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   79: sipush 2048
    //   82: invokevirtual 88	android/security/keystore/KeyGenParameterSpec$Builder:setKeySize	(I)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   85: invokevirtual 92	android/security/keystore/KeyGenParameterSpec$Builder:build	()Landroid/security/keystore/KeyGenParameterSpec;
    //   88: invokevirtual 96	java/security/KeyPairGenerator:initialize	(Ljava/security/spec/AlgorithmParameterSpec;)V
    //   91: aload_3
    //   92: invokevirtual 100	java/security/KeyPairGenerator:generateKeyPair	()Ljava/security/KeyPair;
    //   95: astore_0
    //   96: goto -74 -> 22
    //   99: aload_3
    //   100: new 66	android/security/keystore/KeyGenParameterSpec$Builder
    //   103: dup
    //   104: aload_0
    //   105: bipush 12
    //   107: invokespecial 69	android/security/keystore/KeyGenParameterSpec$Builder:<init>	(Ljava/lang/String;I)V
    //   110: iconst_2
    //   111: anewarray 71	java/lang/String
    //   114: dup
    //   115: iconst_0
    //   116: ldc 73
    //   118: aastore
    //   119: dup
    //   120: iconst_1
    //   121: ldc 75
    //   123: aastore
    //   124: invokevirtual 79	android/security/keystore/KeyGenParameterSpec$Builder:setDigests	([Ljava/lang/String;)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   127: iconst_1
    //   128: anewarray 71	java/lang/String
    //   131: dup
    //   132: iconst_0
    //   133: ldc 81
    //   135: aastore
    //   136: invokevirtual 84	android/security/keystore/KeyGenParameterSpec$Builder:setSignaturePaddings	([Ljava/lang/String;)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   139: sipush 3072
    //   142: invokevirtual 88	android/security/keystore/KeyGenParameterSpec$Builder:setKeySize	(I)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   145: invokevirtual 92	android/security/keystore/KeyGenParameterSpec$Builder:build	()Landroid/security/keystore/KeyGenParameterSpec;
    //   148: invokevirtual 96	java/security/KeyPairGenerator:initialize	(Ljava/security/spec/AlgorithmParameterSpec;)V
    //   151: goto -60 -> 91
    //   154: astore_0
    //   155: getstatic 29	com/huawei/secure/android/common/encrypt/keystore/rsa/RSASignKS:TAG	Ljava/lang/String;
    //   158: new 102	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   165: ldc 105
    //   167: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload_0
    //   171: invokevirtual 112	java/security/NoSuchAlgorithmException:getMessage	()Ljava/lang/String;
    //   174: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 56	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: aload_2
    //   184: astore_0
    //   185: goto -163 -> 22
    //   188: astore_0
    //   189: ldc 2
    //   191: monitorexit
    //   192: aload_0
    //   193: athrow
    //   194: astore_0
    //   195: getstatic 29	com/huawei/secure/android/common/encrypt/keystore/rsa/RSASignKS:TAG	Ljava/lang/String;
    //   198: new 102	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   205: ldc 117
    //   207: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_0
    //   211: invokevirtual 118	java/security/NoSuchProviderException:getMessage	()Ljava/lang/String;
    //   214: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 56	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload_2
    //   224: astore_0
    //   225: goto -203 -> 22
    //   228: astore_0
    //   229: getstatic 29	com/huawei/secure/android/common/encrypt/keystore/rsa/RSASignKS:TAG	Ljava/lang/String;
    //   232: new 102	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   239: ldc 120
    //   241: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_0
    //   245: invokevirtual 121	java/security/InvalidAlgorithmParameterException:getMessage	()Ljava/lang/String;
    //   248: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 56	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload_2
    //   258: astore_0
    //   259: goto -237 -> 22
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	paramString	String
    //   0	262	1	paramBoolean	boolean
    //   1	257	2	localObject	Object
    //   34	66	3	localKeyPairGenerator	java.security.KeyPairGenerator
    // Exception table:
    //   from	to	target	type
    //   27	35	154	java/security/NoSuchAlgorithmException
    //   39	91	154	java/security/NoSuchAlgorithmException
    //   91	96	154	java/security/NoSuchAlgorithmException
    //   99	151	154	java/security/NoSuchAlgorithmException
    //   5	20	188	finally
    //   27	35	188	finally
    //   39	91	188	finally
    //   91	96	188	finally
    //   99	151	188	finally
    //   155	183	188	finally
    //   195	223	188	finally
    //   229	257	188	finally
    //   27	35	194	java/security/NoSuchProviderException
    //   39	91	194	java/security/NoSuchProviderException
    //   91	96	194	java/security/NoSuchProviderException
    //   99	151	194	java/security/NoSuchProviderException
    //   27	35	228	java/security/InvalidAlgorithmParameterException
    //   39	91	228	java/security/InvalidAlgorithmParameterException
    //   91	96	228	java/security/InvalidAlgorithmParameterException
    //   99	151	228	java/security/InvalidAlgorithmParameterException
  }
  
  @RequiresApi(api=23)
  private static boolean a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    b.d(TAG, "r ks v si begin ");
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfByte1 == null) || (paramArrayOfByte2 == null))
    {
      b.f(TAG, "alias or content or sign value is null");
      return false;
    }
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
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;)
      {
        b.f(TAG, "NoSuchAlgorithmException: " + paramString.getMessage());
        paramBoolean = false;
      }
    }
    catch (SignatureException paramString)
    {
      for (;;)
      {
        b.f(TAG, "SignatureException: " + paramString.getMessage());
        paramBoolean = false;
      }
    }
    catch (InvalidKeyException paramString)
    {
      for (;;)
      {
        b.f(TAG, "InvalidKeyException: " + paramString.getMessage());
        paramBoolean = false;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        b.f(TAG, "Exception: " + paramString.getMessage());
        paramBoolean = false;
      }
    }
  }
  
  @RequiresApi(api=23)
  private static byte[] b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    b.d(TAG, "r ks si begin ");
    byte[] arrayOfByte = new byte[0];
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfByte == null))
    {
      b.f(TAG, "alias or content is null");
      return arrayOfByte;
    }
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
      Signature localSignature = Signature.getInstance("SHA256withRSA/PSS");
      localSignature.initSign(((KeyStore.PrivateKeyEntry)paramString).getPrivateKey());
      localSignature.update(paramArrayOfByte);
      paramString = localSignature.sign();
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      b.f(TAG, "NoSuchAlgorithmException: " + paramString.getMessage());
      return arrayOfByte;
    }
    catch (SignatureException paramString)
    {
      for (;;)
      {
        b.f(TAG, "SignatureException: " + paramString.getMessage());
      }
    }
    catch (InvalidKeyException paramString)
    {
      for (;;)
      {
        b.f(TAG, "InvalidKeyException: " + paramString.getMessage());
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        b.f(TAG, "Exception: " + paramString.getMessage());
      }
    }
  }
  
  @RequiresApi(api=23)
  private static KeyStore.Entry c(String paramString, boolean paramBoolean)
  {
    if (!g(paramString)) {
      a(paramString, paramBoolean);
    }
    try
    {
      KeyStore localKeyStore = KeyStore.getInstance("AndroidKeyStore");
      localKeyStore.load(null);
      paramString = localKeyStore.getEntry(paramString, null);
      return paramString;
    }
    catch (KeyStoreException paramString)
    {
      b.f(TAG, "KeyStoreException: " + paramString.getMessage());
      return null;
    }
    catch (CertificateException paramString)
    {
      b.f(TAG, "CertificateException: " + paramString.getMessage());
      return null;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      b.f(TAG, "NoSuchAlgorithmException: " + paramString.getMessage());
      return null;
    }
    catch (IOException paramString)
    {
      b.f(TAG, "IOException: " + paramString.getMessage());
      return null;
    }
    catch (UnrecoverableEntryException paramString)
    {
      b.f(TAG, "UnrecoverableEntryException: " + paramString.getMessage());
    }
    return null;
  }
  
  private static boolean g(String paramString)
  {
    boolean bool = false;
    try
    {
      KeyStore localKeyStore = KeyStore.getInstance("AndroidKeyStore");
      localKeyStore.load(null);
      paramString = localKeyStore.getKey(paramString, null);
      if (paramString != null) {
        bool = true;
      }
      return bool;
    }
    catch (KeyStoreException paramString)
    {
      b.f(TAG, "KeyStoreException: " + paramString.getMessage());
      return false;
    }
    catch (CertificateException paramString)
    {
      b.f(TAG, "CertificateException: " + paramString.getMessage());
      return false;
    }
    catch (UnrecoverableKeyException paramString)
    {
      b.f(TAG, "UnrecoverableKeyException: " + paramString.getMessage());
      return false;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      b.f(TAG, "NoSuchAlgorithmException: " + paramString.getMessage());
      return false;
    }
    catch (IOException paramString)
    {
      b.f(TAG, "IOException: " + paramString.getMessage());
    }
    return false;
  }
  
  public static boolean isBuildVersionHigherThan22()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  @Deprecated
  @RequiresApi(api=23)
  public static String sign(String paramString1, String paramString2)
  {
    b.d(TAG, "r ks si begin ");
    try
    {
      paramString1 = Base64.encodeToString(sign(paramString1, paramString2.getBytes("UTF-8")), 0);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      Log.e(TAG, "sign UnsupportedEncodingException : " + paramString1.getMessage());
    }
    return "";
  }
  
  @Deprecated
  @RequiresApi(api=23)
  public static byte[] sign(String paramString, byte[] paramArrayOfByte)
  {
    return b(paramString, paramArrayOfByte, false);
  }
  
  @RequiresApi(api=23)
  public static String signNew(String paramString1, String paramString2)
  {
    b.d(TAG, "r ks si begin ");
    try
    {
      paramString1 = Base64.encodeToString(signNew(paramString1, paramString2.getBytes("UTF-8")), 0);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      Log.e(TAG, "sign UnsupportedEncodingException : " + paramString1.getMessage());
    }
    return "";
  }
  
  @RequiresApi(api=23)
  public static byte[] signNew(String paramString, byte[] paramArrayOfByte)
  {
    return b(paramString, paramArrayOfByte, true);
  }
  
  @Deprecated
  @RequiresApi(api=23)
  public static boolean verifySign(String paramString1, String paramString2, String paramString3)
  {
    b.d(TAG, "r ks v si begin ");
    try
    {
      boolean bool = verifySign(paramString1, paramString2.getBytes("UTF-8"), Base64.decode(paramString3, 0));
      return bool;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      Log.e(TAG, "verifySign UnsupportedEncodingException: " + paramString1.getMessage());
      return false;
    }
    catch (Exception paramString1)
    {
      b.f(TAG, "base64 decode Exception" + paramString1.getMessage());
    }
    return false;
  }
  
  @Deprecated
  @RequiresApi(api=23)
  public static boolean verifySign(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return a(paramString, paramArrayOfByte1, paramArrayOfByte2, false);
  }
  
  @RequiresApi(api=23)
  public static boolean verifySignNew(String paramString1, String paramString2, String paramString3)
  {
    b.d(TAG, "r ks v si begin ");
    try
    {
      boolean bool = verifySignNew(paramString1, paramString2.getBytes("UTF-8"), Base64.decode(paramString3, 0));
      return bool;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      Log.e(TAG, "verifySign UnsupportedEncodingException: " + paramString1.getMessage());
      return false;
    }
    catch (Exception paramString1)
    {
      b.f(TAG, "base64 decode Exception" + paramString1.getMessage());
    }
    return false;
  }
  
  @RequiresApi(api=23)
  public static boolean verifySignNew(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return a(paramString, paramArrayOfByte1, paramArrayOfByte2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.keystore.rsa.RSASignKS
 * JD-Core Version:    0.7.0.1
 */