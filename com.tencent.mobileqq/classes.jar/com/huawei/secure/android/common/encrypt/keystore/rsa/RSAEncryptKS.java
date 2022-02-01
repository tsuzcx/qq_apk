package com.huawei.secure.android.common.encrypt.keystore.rsa;

import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
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
  private static final String TAG = RSAEncryptKS.class.getSimpleName();
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
    //   6: invokestatic 50	com/huawei/secure/android/common/encrypt/keystore/rsa/RSAEncryptKS:g	(Ljava/lang/String;)Z
    //   9: ifeq +18 -> 27
    //   12: getstatic 29	com/huawei/secure/android/common/encrypt/keystore/rsa/RSAEncryptKS:TAG	Ljava/lang/String;
    //   15: ldc 52
    //   17: invokestatic 58	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_2
    //   21: astore_0
    //   22: ldc 2
    //   24: monitorexit
    //   25: aload_0
    //   26: areturn
    //   27: getstatic 29	com/huawei/secure/android/common/encrypt/keystore/rsa/RSAEncryptKS:TAG	Ljava/lang/String;
    //   30: ldc 60
    //   32: invokestatic 63	com/huawei/secure/android/common/encrypt/utils/b:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: ldc 65
    //   37: ldc 8
    //   39: invokestatic 71	java/security/KeyPairGenerator:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljava/security/KeyPairGenerator;
    //   42: astore_3
    //   43: iload_1
    //   44: ifne +62 -> 106
    //   47: aload_3
    //   48: new 73	android/security/keystore/KeyGenParameterSpec$Builder
    //   51: dup
    //   52: aload_0
    //   53: iconst_2
    //   54: invokespecial 76	android/security/keystore/KeyGenParameterSpec$Builder:<init>	(Ljava/lang/String;I)V
    //   57: iconst_2
    //   58: anewarray 78	java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: ldc 80
    //   65: aastore
    //   66: dup
    //   67: iconst_1
    //   68: ldc 82
    //   70: aastore
    //   71: invokevirtual 86	android/security/keystore/KeyGenParameterSpec$Builder:setDigests	([Ljava/lang/String;)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   74: iconst_1
    //   75: anewarray 78	java/lang/String
    //   78: dup
    //   79: iconst_0
    //   80: ldc 88
    //   82: aastore
    //   83: invokevirtual 91	android/security/keystore/KeyGenParameterSpec$Builder:setEncryptionPaddings	([Ljava/lang/String;)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   86: sipush 2048
    //   89: invokevirtual 95	android/security/keystore/KeyGenParameterSpec$Builder:setKeySize	(I)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   92: invokevirtual 99	android/security/keystore/KeyGenParameterSpec$Builder:build	()Landroid/security/keystore/KeyGenParameterSpec;
    //   95: invokevirtual 103	java/security/KeyPairGenerator:initialize	(Ljava/security/spec/AlgorithmParameterSpec;)V
    //   98: aload_3
    //   99: invokevirtual 107	java/security/KeyPairGenerator:generateKeyPair	()Ljava/security/KeyPair;
    //   102: astore_0
    //   103: goto -81 -> 22
    //   106: aload_3
    //   107: new 73	android/security/keystore/KeyGenParameterSpec$Builder
    //   110: dup
    //   111: aload_0
    //   112: iconst_2
    //   113: invokespecial 76	android/security/keystore/KeyGenParameterSpec$Builder:<init>	(Ljava/lang/String;I)V
    //   116: iconst_2
    //   117: anewarray 78	java/lang/String
    //   120: dup
    //   121: iconst_0
    //   122: ldc 80
    //   124: aastore
    //   125: dup
    //   126: iconst_1
    //   127: ldc 82
    //   129: aastore
    //   130: invokevirtual 86	android/security/keystore/KeyGenParameterSpec$Builder:setDigests	([Ljava/lang/String;)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   133: iconst_1
    //   134: anewarray 78	java/lang/String
    //   137: dup
    //   138: iconst_0
    //   139: ldc 88
    //   141: aastore
    //   142: invokevirtual 91	android/security/keystore/KeyGenParameterSpec$Builder:setEncryptionPaddings	([Ljava/lang/String;)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   145: sipush 3072
    //   148: invokevirtual 95	android/security/keystore/KeyGenParameterSpec$Builder:setKeySize	(I)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   151: invokevirtual 99	android/security/keystore/KeyGenParameterSpec$Builder:build	()Landroid/security/keystore/KeyGenParameterSpec;
    //   154: invokevirtual 103	java/security/KeyPairGenerator:initialize	(Ljava/security/spec/AlgorithmParameterSpec;)V
    //   157: goto -59 -> 98
    //   160: astore_0
    //   161: getstatic 29	com/huawei/secure/android/common/encrypt/keystore/rsa/RSAEncryptKS:TAG	Ljava/lang/String;
    //   164: new 109	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   171: ldc 112
    //   173: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_0
    //   177: invokevirtual 119	java/security/NoSuchAlgorithmException:getMessage	()Ljava/lang/String;
    //   180: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 58	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload_2
    //   190: astore_0
    //   191: goto -169 -> 22
    //   194: astore_0
    //   195: ldc 2
    //   197: monitorexit
    //   198: aload_0
    //   199: athrow
    //   200: astore_0
    //   201: getstatic 29	com/huawei/secure/android/common/encrypt/keystore/rsa/RSAEncryptKS:TAG	Ljava/lang/String;
    //   204: new 109	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   211: ldc 124
    //   213: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_0
    //   217: invokevirtual 125	java/security/NoSuchProviderException:getMessage	()Ljava/lang/String;
    //   220: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 58	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload_2
    //   230: astore_0
    //   231: goto -209 -> 22
    //   234: astore_0
    //   235: getstatic 29	com/huawei/secure/android/common/encrypt/keystore/rsa/RSAEncryptKS:TAG	Ljava/lang/String;
    //   238: new 109	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   245: ldc 127
    //   247: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload_0
    //   251: invokevirtual 128	java/security/InvalidAlgorithmParameterException:getMessage	()Ljava/lang/String;
    //   254: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 58	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload_2
    //   264: astore_0
    //   265: goto -243 -> 22
    //   268: astore_0
    //   269: getstatic 29	com/huawei/secure/android/common/encrypt/keystore/rsa/RSAEncryptKS:TAG	Ljava/lang/String;
    //   272: new 109	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   279: ldc 130
    //   281: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload_0
    //   285: invokevirtual 131	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   288: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 58	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: aload_2
    //   298: astore_0
    //   299: goto -277 -> 22
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	paramString	String
    //   0	302	1	paramBoolean	boolean
    //   1	297	2	localObject	Object
    //   42	65	3	localKeyPairGenerator	java.security.KeyPairGenerator
    // Exception table:
    //   from	to	target	type
    //   35	43	160	java/security/NoSuchAlgorithmException
    //   47	98	160	java/security/NoSuchAlgorithmException
    //   98	103	160	java/security/NoSuchAlgorithmException
    //   106	157	160	java/security/NoSuchAlgorithmException
    //   5	20	194	finally
    //   27	35	194	finally
    //   35	43	194	finally
    //   47	98	194	finally
    //   98	103	194	finally
    //   106	157	194	finally
    //   161	189	194	finally
    //   201	229	194	finally
    //   235	263	194	finally
    //   269	297	194	finally
    //   35	43	200	java/security/NoSuchProviderException
    //   47	98	200	java/security/NoSuchProviderException
    //   98	103	200	java/security/NoSuchProviderException
    //   106	157	200	java/security/NoSuchProviderException
    //   35	43	234	java/security/InvalidAlgorithmParameterException
    //   47	98	234	java/security/InvalidAlgorithmParameterException
    //   98	103	234	java/security/InvalidAlgorithmParameterException
    //   106	157	234	java/security/InvalidAlgorithmParameterException
    //   35	43	268	java/lang/Exception
    //   47	98	268	java/lang/Exception
    //   98	103	268	java/lang/Exception
    //   106	157	268	java/lang/Exception
  }
  
  @RequiresApi(api=23)
  private static byte[] a(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    b.d(TAG, "r ks en begin 2");
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
    paramString = b(paramString, paramBoolean);
    if (paramString == null)
    {
      b.f(TAG, "Public key is null");
      return arrayOfByte;
    }
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
      localCipher.init(1, paramString, new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
      paramString = localCipher.doFinal(paramArrayOfByte);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      b.f(TAG, "NoSuchAlgorithmException: " + paramString.getMessage());
      return arrayOfByte;
    }
    catch (NoSuchPaddingException paramString)
    {
      b.f(TAG, "NoSuchPaddingException: " + paramString.getMessage());
      return arrayOfByte;
    }
    catch (InvalidKeyException paramString)
    {
      b.f(TAG, "InvalidKeyException: " + paramString.getMessage());
      return arrayOfByte;
    }
    catch (InvalidAlgorithmParameterException paramString)
    {
      b.f(TAG, "InvalidAlgorithmParameterException: " + paramString.getMessage());
      return arrayOfByte;
    }
    catch (IllegalBlockSizeException paramString)
    {
      b.f(TAG, "IllegalBlockSizeException: " + paramString.getMessage());
      return arrayOfByte;
    }
    catch (BadPaddingException paramString)
    {
      b.f(TAG, "BadPaddingException: " + paramString.getMessage());
      return arrayOfByte;
    }
    catch (Exception paramString)
    {
      b.f(TAG, "Exception: " + paramString.getMessage());
    }
    return arrayOfByte;
  }
  
  @RequiresApi(api=23)
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
  @RequiresApi(api=23)
  public static String decrpyt(String paramString1, String paramString2)
  {
    b.d(TAG, "r ks de begin 1");
    try
    {
      paramString1 = new String(decrpyt(paramString1, Base64.decode(paramString2, 0)), "UTF-8");
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      b.f(TAG, "UnsupportedEncodingException: " + paramString1.getMessage());
      return "";
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        b.f(TAG, "Exception: " + paramString1.getMessage());
      }
    }
  }
  
  @Deprecated
  @RequiresApi(api=23)
  public static byte[] decrpyt(String paramString, byte[] paramArrayOfByte)
  {
    b.d(TAG, "r ks de begin 2");
    byte[] arrayOfByte = new byte[0];
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfByte == null))
    {
      b.f(TAG, "alias or encrypted content is null");
      return arrayOfByte;
    }
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
      Cipher localCipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
      localCipher.init(2, paramString, new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
      paramString = localCipher.doFinal(paramArrayOfByte);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      b.f(TAG, "NoSuchAlgorithmException: " + paramString.getMessage());
      return arrayOfByte;
    }
    catch (NoSuchPaddingException paramString)
    {
      b.f(TAG, "NoSuchPaddingException: " + paramString.getMessage());
      return arrayOfByte;
    }
    catch (InvalidKeyException paramString)
    {
      b.f(TAG, "InvalidKeyException: " + paramString.getMessage());
      return arrayOfByte;
    }
    catch (InvalidAlgorithmParameterException paramString)
    {
      b.f(TAG, "InvalidAlgorithmParameterException: " + paramString.getMessage());
      return arrayOfByte;
    }
    catch (IllegalBlockSizeException paramString)
    {
      b.f(TAG, "IllegalBlockSizeException: " + paramString.getMessage());
      return arrayOfByte;
    }
    catch (BadPaddingException paramString)
    {
      b.f(TAG, "BadPaddingException: " + paramString.getMessage());
      return arrayOfByte;
    }
    catch (Exception paramString)
    {
      b.f(TAG, "Exception: " + paramString.getMessage());
    }
    return arrayOfByte;
  }
  
  @RequiresApi(api=23)
  public static String decrpytNew(String paramString1, String paramString2)
  {
    b.d(TAG, "r ks de begin 1");
    try
    {
      paramString1 = new String(decrpytNew(paramString1, Base64.decode(paramString2, 0)), "UTF-8");
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      b.f(TAG, "UnsupportedEncodingException: " + paramString1.getMessage());
      return "";
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        b.f(TAG, "Exception: " + paramString1.getMessage());
      }
    }
  }
  
  @RequiresApi(api=23)
  public static byte[] decrpytNew(String paramString, byte[] paramArrayOfByte)
  {
    return decrpyt(paramString, paramArrayOfByte);
  }
  
  @Deprecated
  @RequiresApi(api=23)
  public static String encrypt(String paramString1, String paramString2)
  {
    b.d(TAG, "r ks en begin 1");
    if (!TextUtils.isEmpty(paramString2)) {
      try
      {
        paramString1 = Base64.encodeToString(encrypt(paramString1, paramString2.getBytes("UTF-8")), 0);
        return paramString1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        b.f(TAG, "UnsupportedEncodingException: " + paramString1.getMessage());
      }
    }
    return "";
  }
  
  @Deprecated
  @RequiresApi(api=23)
  public static byte[] encrypt(String paramString, byte[] paramArrayOfByte)
  {
    return a(paramString, paramArrayOfByte, false);
  }
  
  @RequiresApi(api=23)
  public static String encryptNew(String paramString1, String paramString2)
  {
    b.d(TAG, "r ks en begin 1");
    if (!TextUtils.isEmpty(paramString2)) {
      try
      {
        paramString1 = Base64.encodeToString(encryptNew(paramString1, paramString2.getBytes("UTF-8")), 0);
        return paramString1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        b.f(TAG, "UnsupportedEncodingException: " + paramString1.getMessage());
      }
    }
    return "";
  }
  
  @RequiresApi(api=23)
  public static byte[] encryptNew(String paramString, byte[] paramArrayOfByte)
  {
    return a(paramString, paramArrayOfByte, true);
  }
  
  private static Certificate f(String paramString)
  {
    try
    {
      KeyStore localKeyStore = KeyStore.getInstance("AndroidKeyStore");
      localKeyStore.load(null);
      paramString = localKeyStore.getCertificate(paramString);
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
    catch (Exception paramString)
    {
      b.f(TAG, "Exception: " + paramString.getMessage());
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
      return false;
    }
    catch (Exception paramString)
    {
      b.f(TAG, "Exception: " + paramString.getMessage());
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
      KeyStore localKeyStore = KeyStore.getInstance("AndroidKeyStore");
      localKeyStore.load(null);
      paramString = (PrivateKey)localKeyStore.getKey(paramString, null);
      return paramString;
    }
    catch (KeyStoreException paramString)
    {
      for (;;)
      {
        b.f(TAG, "KeyStoreException: " + paramString.getMessage());
        paramString = null;
      }
    }
    catch (CertificateException paramString)
    {
      for (;;)
      {
        b.f(TAG, "CertificateException: " + paramString.getMessage());
        paramString = null;
      }
    }
    catch (UnrecoverableKeyException paramString)
    {
      for (;;)
      {
        b.f(TAG, "UnrecoverableKeyException: " + paramString.getMessage());
        paramString = null;
      }
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;)
      {
        b.f(TAG, "NoSuchAlgorithmException: " + paramString.getMessage());
        paramString = null;
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        b.f(TAG, "IOException: " + paramString.getMessage());
        paramString = null;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        b.f(TAG, "Exception: " + paramString.getMessage());
        paramString = null;
      }
    }
  }
  
  private static boolean isBuildVersionHigherThan22()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.keystore.rsa.RSAEncryptKS
 * JD-Core Version:    0.7.0.1
 */