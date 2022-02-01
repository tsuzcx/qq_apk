package com.huawei.secure.android.common.encrypt.keystore.aes;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;

public class AesGcmKS
{
  private static final String C = "AndroidKeyStore";
  private static final int F = 256;
  private static final String TAG = "AesGcmKS";
  private static final String i = "";
  private static final String l = "AES/GCM/NoPadding";
  private static final int n = 12;
  
  public static String decrypt(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      try
      {
        paramString1 = new String(decrypt(paramString1, HexUtil.hexStr2ByteArray(paramString2)), "UTF-8");
        return paramString1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString2 = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decrypt: UnsupportedEncodingException : ");
        localStringBuilder.append(paramString1.getMessage());
        b.f(paramString2, localStringBuilder.toString());
        return "";
      }
    }
    b.f(TAG, "alias or encrypt content is null");
    return "";
  }
  
  public static byte[] decrypt(String paramString, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[0];
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte != null))
    {
      if (!isBuildVersionHigherThan22())
      {
        b.f(TAG, "sdk version is too low");
        return arrayOfByte;
      }
      if (paramArrayOfByte.length <= 12)
      {
        b.f(TAG, "Decrypt source data is invalid.");
        return arrayOfByte;
      }
      paramString = e(paramString);
      if (paramString == null)
      {
        b.f(TAG, "Decrypt secret key is null");
        return arrayOfByte;
      }
      Object localObject = Arrays.copyOf(paramArrayOfByte, 12);
      try
      {
        Cipher localCipher = Cipher.getInstance("AES/GCM/NoPadding");
        localCipher.init(2, paramString, new GCMParameterSpec(128, (byte[])localObject));
        paramString = localCipher.doFinal(paramArrayOfByte, 12, paramArrayOfByte.length - 12);
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
        ((StringBuilder)localObject).append("BadPaddingException : ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        b.f(paramArrayOfByte, ((StringBuilder)localObject).toString());
        return arrayOfByte;
      }
      catch (IllegalBlockSizeException paramString)
      {
        paramArrayOfByte = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("IllegalBlockSizeException : ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        b.f(paramArrayOfByte, ((StringBuilder)localObject).toString());
        return arrayOfByte;
      }
      catch (InvalidAlgorithmParameterException paramString)
      {
        paramArrayOfByte = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("InvalidAlgorithmParameterException : ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        b.f(paramArrayOfByte, ((StringBuilder)localObject).toString());
        return arrayOfByte;
      }
      catch (InvalidKeyException paramString)
      {
        paramArrayOfByte = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("InvalidKeyException : ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        b.f(paramArrayOfByte, ((StringBuilder)localObject).toString());
        return arrayOfByte;
      }
      catch (NoSuchPaddingException paramString)
      {
        paramArrayOfByte = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("NoSuchPaddingException : ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        b.f(paramArrayOfByte, ((StringBuilder)localObject).toString());
        return arrayOfByte;
      }
      catch (NoSuchAlgorithmException paramString)
      {
        paramArrayOfByte = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("NoSuchAlgorithmException : ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        b.f(paramArrayOfByte, ((StringBuilder)localObject).toString());
        return arrayOfByte;
      }
    }
    b.f(TAG, "alias or encrypt content is null");
    return arrayOfByte;
  }
  
  /* Error */
  private static javax.crypto.SecretKey e(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aconst_null
    //   4: astore_1
    //   5: ldc 8
    //   7: invokestatic 169	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   10: astore_2
    //   11: aload_2
    //   12: aconst_null
    //   13: invokevirtual 173	java/security/KeyStore:load	(Ljava/security/KeyStore$LoadStoreParameter;)V
    //   16: aload_2
    //   17: aload_0
    //   18: aconst_null
    //   19: invokevirtual 177	java/security/KeyStore:getKey	(Ljava/lang/String;[C)Ljava/security/Key;
    //   22: astore_2
    //   23: aload_2
    //   24: ifnull +18 -> 42
    //   27: aload_2
    //   28: instanceof 179
    //   31: ifeq +11 -> 42
    //   34: aload_2
    //   35: checkcast 179	javax/crypto/SecretKey
    //   38: astore_0
    //   39: goto +402 -> 441
    //   42: ldc 181
    //   44: ldc 8
    //   46: invokestatic 186	javax/crypto/KeyGenerator:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljavax/crypto/KeyGenerator;
    //   49: astore_2
    //   50: aload_2
    //   51: new 188	android/security/keystore/KeyGenParameterSpec$Builder
    //   54: dup
    //   55: aload_0
    //   56: iconst_3
    //   57: invokespecial 191	android/security/keystore/KeyGenParameterSpec$Builder:<init>	(Ljava/lang/String;I)V
    //   60: iconst_1
    //   61: anewarray 40	java/lang/String
    //   64: dup
    //   65: iconst_0
    //   66: ldc 193
    //   68: aastore
    //   69: invokevirtual 197	android/security/keystore/KeyGenParameterSpec$Builder:setBlockModes	([Ljava/lang/String;)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   72: iconst_1
    //   73: anewarray 40	java/lang/String
    //   76: dup
    //   77: iconst_0
    //   78: ldc 199
    //   80: aastore
    //   81: invokevirtual 202	android/security/keystore/KeyGenParameterSpec$Builder:setEncryptionPaddings	([Ljava/lang/String;)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   84: sipush 256
    //   87: invokevirtual 206	android/security/keystore/KeyGenParameterSpec$Builder:setKeySize	(I)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   90: invokevirtual 210	android/security/keystore/KeyGenParameterSpec$Builder:build	()Landroid/security/keystore/KeyGenParameterSpec;
    //   93: invokevirtual 213	javax/crypto/KeyGenerator:init	(Ljava/security/spec/AlgorithmParameterSpec;)V
    //   96: aload_2
    //   97: invokevirtual 217	javax/crypto/KeyGenerator:generateKey	()Ljavax/crypto/SecretKey;
    //   100: astore_0
    //   101: goto +340 -> 441
    //   104: astore_0
    //   105: goto +341 -> 446
    //   108: astore_0
    //   109: getstatic 56	com/huawei/secure/android/common/encrypt/keystore/aes/AesGcmKS:TAG	Ljava/lang/String;
    //   112: astore_2
    //   113: new 58	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   120: astore_3
    //   121: aload_3
    //   122: ldc 135
    //   124: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_3
    //   129: aload_0
    //   130: invokevirtual 136	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   133: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload_2
    //   138: aload_3
    //   139: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 78	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload_1
    //   146: astore_0
    //   147: goto +294 -> 441
    //   150: astore_0
    //   151: getstatic 56	com/huawei/secure/android/common/encrypt/keystore/aes/AesGcmKS:TAG	Ljava/lang/String;
    //   154: astore_2
    //   155: new 58	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   162: astore_3
    //   163: aload_3
    //   164: ldc 219
    //   166: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_3
    //   171: aload_0
    //   172: invokevirtual 220	java/security/NoSuchProviderException:getMessage	()Ljava/lang/String;
    //   175: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_2
    //   180: aload_3
    //   181: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 78	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload_1
    //   188: astore_0
    //   189: goto +252 -> 441
    //   192: astore_0
    //   193: getstatic 56	com/huawei/secure/android/common/encrypt/keystore/aes/AesGcmKS:TAG	Ljava/lang/String;
    //   196: astore_2
    //   197: new 58	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   204: astore_3
    //   205: aload_3
    //   206: ldc 144
    //   208: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_3
    //   213: aload_0
    //   214: invokevirtual 145	java/security/InvalidAlgorithmParameterException:getMessage	()Ljava/lang/String;
    //   217: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload_2
    //   222: aload_3
    //   223: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 78	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload_1
    //   230: astore_0
    //   231: goto +210 -> 441
    //   234: astore_0
    //   235: getstatic 56	com/huawei/secure/android/common/encrypt/keystore/aes/AesGcmKS:TAG	Ljava/lang/String;
    //   238: astore_2
    //   239: new 58	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   246: astore_3
    //   247: aload_3
    //   248: ldc 222
    //   250: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_3
    //   255: aload_0
    //   256: invokevirtual 223	java/security/UnrecoverableKeyException:getMessage	()Ljava/lang/String;
    //   259: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload_2
    //   264: aload_3
    //   265: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 78	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload_1
    //   272: astore_0
    //   273: goto +168 -> 441
    //   276: astore_0
    //   277: getstatic 56	com/huawei/secure/android/common/encrypt/keystore/aes/AesGcmKS:TAG	Ljava/lang/String;
    //   280: astore_2
    //   281: new 58	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   288: astore_3
    //   289: aload_3
    //   290: ldc 153
    //   292: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload_3
    //   297: aload_0
    //   298: invokevirtual 154	java/security/NoSuchAlgorithmException:getMessage	()Ljava/lang/String;
    //   301: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload_2
    //   306: aload_3
    //   307: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 78	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   313: aload_1
    //   314: astore_0
    //   315: goto +126 -> 441
    //   318: astore_0
    //   319: getstatic 56	com/huawei/secure/android/common/encrypt/keystore/aes/AesGcmKS:TAG	Ljava/lang/String;
    //   322: astore_2
    //   323: new 58	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   330: astore_3
    //   331: aload_3
    //   332: ldc 225
    //   334: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload_3
    //   339: aload_0
    //   340: invokevirtual 226	java/security/cert/CertificateException:getMessage	()Ljava/lang/String;
    //   343: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload_2
    //   348: aload_3
    //   349: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 78	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   355: aload_1
    //   356: astore_0
    //   357: goto +84 -> 441
    //   360: astore_0
    //   361: getstatic 56	com/huawei/secure/android/common/encrypt/keystore/aes/AesGcmKS:TAG	Ljava/lang/String;
    //   364: astore_2
    //   365: new 58	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   372: astore_3
    //   373: aload_3
    //   374: ldc 228
    //   376: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload_3
    //   381: aload_0
    //   382: invokevirtual 229	java/io/IOException:getMessage	()Ljava/lang/String;
    //   385: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload_2
    //   390: aload_3
    //   391: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokestatic 78	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   397: aload_1
    //   398: astore_0
    //   399: goto +42 -> 441
    //   402: astore_0
    //   403: getstatic 56	com/huawei/secure/android/common/encrypt/keystore/aes/AesGcmKS:TAG	Ljava/lang/String;
    //   406: astore_2
    //   407: new 58	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   414: astore_3
    //   415: aload_3
    //   416: ldc 231
    //   418: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload_3
    //   423: aload_0
    //   424: invokevirtual 232	java/security/KeyStoreException:getMessage	()Ljava/lang/String;
    //   427: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload_2
    //   432: aload_3
    //   433: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokestatic 78	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: aload_1
    //   440: astore_0
    //   441: ldc 2
    //   443: monitorexit
    //   444: aload_0
    //   445: areturn
    //   446: ldc 2
    //   448: monitorexit
    //   449: aload_0
    //   450: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	451	0	paramString	String
    //   4	436	1	localObject1	Object
    //   10	422	2	localObject2	Object
    //   120	313	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   5	23	104	finally
    //   27	39	104	finally
    //   42	101	104	finally
    //   109	145	104	finally
    //   151	187	104	finally
    //   193	229	104	finally
    //   235	271	104	finally
    //   277	313	104	finally
    //   319	355	104	finally
    //   361	397	104	finally
    //   403	439	104	finally
    //   5	23	108	java/lang/Exception
    //   27	39	108	java/lang/Exception
    //   42	101	108	java/lang/Exception
    //   5	23	150	java/security/NoSuchProviderException
    //   27	39	150	java/security/NoSuchProviderException
    //   42	101	150	java/security/NoSuchProviderException
    //   5	23	192	java/security/InvalidAlgorithmParameterException
    //   27	39	192	java/security/InvalidAlgorithmParameterException
    //   42	101	192	java/security/InvalidAlgorithmParameterException
    //   5	23	234	java/security/UnrecoverableKeyException
    //   27	39	234	java/security/UnrecoverableKeyException
    //   42	101	234	java/security/UnrecoverableKeyException
    //   5	23	276	java/security/NoSuchAlgorithmException
    //   27	39	276	java/security/NoSuchAlgorithmException
    //   42	101	276	java/security/NoSuchAlgorithmException
    //   5	23	318	java/security/cert/CertificateException
    //   27	39	318	java/security/cert/CertificateException
    //   42	101	318	java/security/cert/CertificateException
    //   5	23	360	java/io/IOException
    //   27	39	360	java/io/IOException
    //   42	101	360	java/io/IOException
    //   5	23	402	java/security/KeyStoreException
    //   27	39	402	java/security/KeyStoreException
    //   42	101	402	java/security/KeyStoreException
  }
  
  public static String encrypt(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      try
      {
        paramString1 = HexUtil.byteArray2HexStr(encrypt(paramString1, paramString2.getBytes("UTF-8")));
        return paramString1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString2 = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("encrypt: UnsupportedEncodingException : ");
        localStringBuilder.append(paramString1.getMessage());
        b.f(paramString2, localStringBuilder.toString());
        return "";
      }
    }
    b.f(TAG, "alias or encrypt content is null");
    return "";
  }
  
  public static byte[] encrypt(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject1 = new byte[0];
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte != null))
    {
      if (!isBuildVersionHigherThan22())
      {
        b.f(TAG, "sdk version is too low");
        return localObject1;
      }
      Object localObject2 = localObject1;
      Object localObject3 = localObject1;
      Object localObject4 = localObject1;
      Object localObject5 = localObject1;
      Object localObject6 = localObject1;
      Object localObject7 = localObject1;
      try
      {
        Object localObject8 = Cipher.getInstance("AES/GCM/NoPadding");
        localObject2 = localObject1;
        localObject3 = localObject1;
        localObject4 = localObject1;
        localObject5 = localObject1;
        localObject6 = localObject1;
        localObject7 = localObject1;
        paramString = e(paramString);
        if (paramString == null)
        {
          localObject2 = localObject1;
          localObject3 = localObject1;
          localObject4 = localObject1;
          localObject5 = localObject1;
          localObject6 = localObject1;
          localObject7 = localObject1;
          b.f(TAG, "Encrypt secret key is null");
          return localObject1;
        }
        localObject2 = localObject1;
        localObject3 = localObject1;
        localObject4 = localObject1;
        localObject5 = localObject1;
        localObject6 = localObject1;
        localObject7 = localObject1;
        ((Cipher)localObject8).init(1, paramString);
        localObject2 = localObject1;
        localObject3 = localObject1;
        localObject4 = localObject1;
        localObject5 = localObject1;
        localObject6 = localObject1;
        localObject7 = localObject1;
        paramArrayOfByte = ((Cipher)localObject8).doFinal(paramArrayOfByte);
        localObject2 = localObject1;
        localObject3 = localObject1;
        localObject4 = localObject1;
        localObject5 = localObject1;
        localObject6 = localObject1;
        localObject7 = localObject1;
        localObject8 = ((Cipher)localObject8).getIV();
        if (localObject8 != null)
        {
          localObject2 = localObject1;
          localObject3 = localObject1;
          localObject4 = localObject1;
          localObject5 = localObject1;
          localObject6 = localObject1;
          localObject7 = localObject1;
          if (localObject8.length == 12)
          {
            localObject2 = localObject1;
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            localObject7 = localObject1;
            paramString = Arrays.copyOf((byte[])localObject8, localObject8.length + paramArrayOfByte.length);
            localObject2 = paramString;
            localObject3 = paramString;
            localObject4 = paramString;
            localObject5 = paramString;
            localObject6 = paramString;
            localObject7 = paramString;
            System.arraycopy(paramArrayOfByte, 0, paramString, localObject8.length, paramArrayOfByte.length);
            return paramString;
          }
        }
        localObject2 = localObject1;
        localObject3 = localObject1;
        localObject4 = localObject1;
        localObject5 = localObject1;
        localObject6 = localObject1;
        localObject7 = localObject1;
        b.f(TAG, "IV is invalid.");
        return localObject1;
      }
      catch (Exception paramString)
      {
        paramArrayOfByte = TAG;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Exception: ");
        ((StringBuilder)localObject1).append(paramString.getMessage());
        b.f(paramArrayOfByte, ((StringBuilder)localObject1).toString());
        return localObject2;
      }
      catch (InvalidKeyException paramString)
      {
        paramArrayOfByte = TAG;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("InvalidKeyException : ");
        ((StringBuilder)localObject1).append(paramString.getMessage());
        b.f(paramArrayOfByte, ((StringBuilder)localObject1).toString());
        return localObject3;
      }
      catch (IllegalBlockSizeException paramString)
      {
        paramArrayOfByte = TAG;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("IllegalBlockSizeException : ");
        ((StringBuilder)localObject1).append(paramString.getMessage());
        b.f(paramArrayOfByte, ((StringBuilder)localObject1).toString());
        return localObject4;
      }
      catch (BadPaddingException paramString)
      {
        paramArrayOfByte = TAG;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("BadPaddingException : ");
        ((StringBuilder)localObject1).append(paramString.getMessage());
        b.f(paramArrayOfByte, ((StringBuilder)localObject1).toString());
        return localObject5;
      }
      catch (NoSuchPaddingException paramString)
      {
        paramArrayOfByte = TAG;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("NoSuchPaddingException : ");
        ((StringBuilder)localObject1).append(paramString.getMessage());
        b.f(paramArrayOfByte, ((StringBuilder)localObject1).toString());
        return localObject6;
      }
      catch (NoSuchAlgorithmException paramString)
      {
        paramArrayOfByte = TAG;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("NoSuchAlgorithmException : ");
        ((StringBuilder)localObject1).append(paramString.getMessage());
        b.f(paramArrayOfByte, ((StringBuilder)localObject1).toString());
        return localObject7;
      }
    }
    b.f(TAG, "alias or encrypt content is null");
    return localObject1;
  }
  
  private static boolean isBuildVersionHigherThan22()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS
 * JD-Core Version:    0.7.0.1
 */