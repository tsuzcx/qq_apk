package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.security.cert.X509Certificate;

public class j
{
  private static final String TAG = "X509CertificateUtil";
  private static final String an = "052root";
  private static final String ao = "hmsincas.bks";
  private static final String ap = "huawei cbg application integration ca";
  private static final String b = "bks";
  private static final String k = "hmsrootcas.bks";
  private static final String l = "";
  private Context u;
  
  public j(Context paramContext)
  {
    this.u = paramContext;
  }
  
  /* Error */
  public X509Certificate f(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 20
    //   2: invokestatic 52	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   5: astore 5
    //   7: aload_0
    //   8: getfield 35	com/huawei/secure/android/common/ssl/util/j:u	Landroid/content/Context;
    //   11: invokevirtual 58	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   14: aload_1
    //   15: invokevirtual 64	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   18: astore_3
    //   19: aload_3
    //   20: astore 4
    //   22: aload_3
    //   23: invokevirtual 69	java/io/InputStream:reset	()V
    //   26: aload_3
    //   27: astore 4
    //   29: aload 5
    //   31: aload_3
    //   32: ldc 26
    //   34: invokevirtual 75	java/lang/String:toCharArray	()[C
    //   37: invokevirtual 79	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   40: aload_3
    //   41: astore 4
    //   43: aload 5
    //   45: aload_2
    //   46: invokevirtual 83	java/security/KeyStore:getCertificate	(Ljava/lang/String;)Ljava/security/cert/Certificate;
    //   49: checkcast 85	java/security/cert/X509Certificate
    //   52: astore_1
    //   53: aload_3
    //   54: invokestatic 91	com/huawei/secure/android/common/ssl/util/f:c	(Ljava/io/InputStream;)V
    //   57: aload_1
    //   58: areturn
    //   59: astore_1
    //   60: aconst_null
    //   61: astore_2
    //   62: aload_2
    //   63: astore 4
    //   65: ldc 8
    //   67: new 93	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   74: ldc 96
    //   76: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_1
    //   80: invokevirtual 106	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   83: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 115	com/huawei/secure/android/common/ssl/util/g:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_2
    //   93: invokestatic 91	com/huawei/secure/android/common/ssl/util/f:c	(Ljava/io/InputStream;)V
    //   96: aconst_null
    //   97: areturn
    //   98: astore_1
    //   99: aconst_null
    //   100: astore 4
    //   102: aload 4
    //   104: invokestatic 91	com/huawei/secure/android/common/ssl/util/f:c	(Ljava/io/InputStream;)V
    //   107: aload_1
    //   108: athrow
    //   109: astore_1
    //   110: goto -8 -> 102
    //   113: astore_1
    //   114: aload_3
    //   115: astore_2
    //   116: goto -54 -> 62
    //   119: astore_1
    //   120: aconst_null
    //   121: astore_2
    //   122: goto -60 -> 62
    //   125: astore_1
    //   126: aload_3
    //   127: astore_2
    //   128: goto -66 -> 62
    //   131: astore_1
    //   132: aconst_null
    //   133: astore_2
    //   134: goto -72 -> 62
    //   137: astore_1
    //   138: aload_3
    //   139: astore_2
    //   140: goto -78 -> 62
    //   143: astore_1
    //   144: aconst_null
    //   145: astore_2
    //   146: goto -84 -> 62
    //   149: astore_1
    //   150: aload_3
    //   151: astore_2
    //   152: goto -90 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	j
    //   0	155	1	paramString1	String
    //   0	155	2	paramString2	String
    //   18	133	3	localInputStream	java.io.InputStream
    //   20	83	4	localObject	Object
    //   5	39	5	localKeyStore	java.security.KeyStore
    // Exception table:
    //   from	to	target	type
    //   0	19	59	java/security/KeyStoreException
    //   0	19	98	finally
    //   22	26	109	finally
    //   29	40	109	finally
    //   43	53	109	finally
    //   65	92	109	finally
    //   22	26	113	java/security/KeyStoreException
    //   29	40	113	java/security/KeyStoreException
    //   43	53	113	java/security/KeyStoreException
    //   0	19	119	java/security/NoSuchAlgorithmException
    //   22	26	125	java/security/NoSuchAlgorithmException
    //   29	40	125	java/security/NoSuchAlgorithmException
    //   43	53	125	java/security/NoSuchAlgorithmException
    //   0	19	131	java/security/cert/CertificateException
    //   22	26	137	java/security/cert/CertificateException
    //   29	40	137	java/security/cert/CertificateException
    //   43	53	137	java/security/cert/CertificateException
    //   0	19	143	java/io/IOException
    //   22	26	149	java/io/IOException
    //   29	40	149	java/io/IOException
    //   43	53	149	java/io/IOException
  }
  
  public X509Certificate l()
  {
    return f("hmsrootcas.bks", "052root");
  }
  
  public X509Certificate m()
  {
    return f("hmsincas.bks", "huawei cbg application integration ca");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.util.j
 * JD-Core Version:    0.7.0.1
 */