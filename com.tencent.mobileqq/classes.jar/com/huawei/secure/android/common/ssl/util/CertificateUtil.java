package com.huawei.secure.android.common.ssl.util;

public final class CertificateUtil
{
  private static final String a = "CertificateUtil";
  
  /* Error */
  public static java.security.cert.X509Certificate getHwCbgRootCA(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 25
    //   4: invokestatic 31	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   7: astore 4
    //   9: aload_0
    //   10: invokevirtual 37	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   13: ldc 39
    //   15: invokevirtual 45	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   18: astore_1
    //   19: aload_1
    //   20: astore_2
    //   21: aload_1
    //   22: invokevirtual 50	java/io/InputStream:reset	()V
    //   25: aload_1
    //   26: astore_2
    //   27: aload 4
    //   29: aload_1
    //   30: ldc 52
    //   32: invokevirtual 58	java/lang/String:toCharArray	()[C
    //   35: invokevirtual 62	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   38: aload_1
    //   39: astore_2
    //   40: aload 4
    //   42: ldc 64
    //   44: invokevirtual 68	java/security/KeyStore:getCertificate	(Ljava/lang/String;)Ljava/security/cert/Certificate;
    //   47: checkcast 70	java/security/cert/X509Certificate
    //   50: astore_0
    //   51: goto +90 -> 141
    //   54: astore_0
    //   55: goto +39 -> 94
    //   58: astore_0
    //   59: goto +35 -> 94
    //   62: astore_0
    //   63: goto +31 -> 94
    //   66: astore_0
    //   67: goto +27 -> 94
    //   70: astore_0
    //   71: aconst_null
    //   72: astore_2
    //   73: goto +75 -> 148
    //   76: astore_0
    //   77: aconst_null
    //   78: astore_1
    //   79: goto +15 -> 94
    //   82: astore_0
    //   83: goto -6 -> 77
    //   86: astore_0
    //   87: goto -10 -> 77
    //   90: astore_0
    //   91: goto -14 -> 77
    //   94: aload_1
    //   95: astore_2
    //   96: new 72	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   103: astore 4
    //   105: aload_1
    //   106: astore_2
    //   107: aload 4
    //   109: ldc 75
    //   111: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_1
    //   116: astore_2
    //   117: aload 4
    //   119: aload_0
    //   120: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload_1
    //   128: astore_2
    //   129: ldc 8
    //   131: aload 4
    //   133: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 94	com/huawei/secure/android/common/ssl/util/g:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_3
    //   140: astore_0
    //   141: aload_1
    //   142: invokestatic 99	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/InputStream;)V
    //   145: aload_0
    //   146: areturn
    //   147: astore_0
    //   148: aload_2
    //   149: invokestatic 99	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/InputStream;)V
    //   152: goto +5 -> 157
    //   155: aload_0
    //   156: athrow
    //   157: goto -2 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	paramContext	android.content.Context
    //   18	124	1	localInputStream1	java.io.InputStream
    //   20	129	2	localInputStream2	java.io.InputStream
    //   1	139	3	localObject1	Object
    //   7	125	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   21	25	54	java/security/NoSuchAlgorithmException
    //   27	38	54	java/security/NoSuchAlgorithmException
    //   40	51	54	java/security/NoSuchAlgorithmException
    //   21	25	58	java/io/IOException
    //   27	38	58	java/io/IOException
    //   40	51	58	java/io/IOException
    //   21	25	62	java/security/cert/CertificateException
    //   27	38	62	java/security/cert/CertificateException
    //   40	51	62	java/security/cert/CertificateException
    //   21	25	66	java/security/KeyStoreException
    //   27	38	66	java/security/KeyStoreException
    //   40	51	66	java/security/KeyStoreException
    //   2	19	70	finally
    //   2	19	76	java/security/NoSuchAlgorithmException
    //   2	19	82	java/io/IOException
    //   2	19	86	java/security/cert/CertificateException
    //   2	19	90	java/security/KeyStoreException
    //   21	25	147	finally
    //   27	38	147	finally
    //   40	51	147	finally
    //   96	105	147	finally
    //   107	115	147	finally
    //   117	127	147	finally
    //   129	139	147	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.util.CertificateUtil
 * JD-Core Version:    0.7.0.1
 */