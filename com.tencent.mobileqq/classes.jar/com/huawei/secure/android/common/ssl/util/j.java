package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.security.cert.X509Certificate;

public class j
{
  private static final String b = "X509CertificateUtil";
  public static final String c = "hmsrootcas.bks";
  public static final String d = "";
  public static final String e = "bks";
  public static final String f = "052root";
  private static final String g = "hmsincas.bks";
  private static final String h = "huawei cbg application integration ca";
  private Context a;
  
  public j(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public X509Certificate a()
  {
    return a("hmsincas.bks", "huawei cbg application integration ca");
  }
  
  /* Error */
  public X509Certificate a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 17
    //   2: invokestatic 54	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   5: astore 4
    //   7: aload_0
    //   8: getfield 35	com/huawei/secure/android/common/ssl/util/j:a	Landroid/content/Context;
    //   11: invokevirtual 60	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   14: aload_1
    //   15: invokevirtual 66	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   18: astore_1
    //   19: aload_1
    //   20: astore_3
    //   21: aload_1
    //   22: invokevirtual 71	java/io/InputStream:reset	()V
    //   25: aload_1
    //   26: astore_3
    //   27: aload 4
    //   29: aload_1
    //   30: ldc 14
    //   32: invokevirtual 77	java/lang/String:toCharArray	()[C
    //   35: invokevirtual 81	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   38: aload_1
    //   39: astore_3
    //   40: aload 4
    //   42: aload_2
    //   43: invokevirtual 85	java/security/KeyStore:getCertificate	(Ljava/lang/String;)Ljava/security/cert/Certificate;
    //   46: checkcast 87	java/security/cert/X509Certificate
    //   49: astore_2
    //   50: aload_2
    //   51: astore_3
    //   52: goto +108 -> 160
    //   55: astore_3
    //   56: aload_1
    //   57: astore_2
    //   58: aload_3
    //   59: astore_1
    //   60: goto +51 -> 111
    //   63: astore_3
    //   64: aload_1
    //   65: astore_2
    //   66: aload_3
    //   67: astore_1
    //   68: goto +43 -> 111
    //   71: astore_3
    //   72: aload_1
    //   73: astore_2
    //   74: aload_3
    //   75: astore_1
    //   76: goto +35 -> 111
    //   79: astore_3
    //   80: aload_1
    //   81: astore_2
    //   82: aload_3
    //   83: astore_1
    //   84: goto +27 -> 111
    //   87: astore_1
    //   88: aconst_null
    //   89: astore_3
    //   90: goto +77 -> 167
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_2
    //   96: goto +15 -> 111
    //   99: astore_1
    //   100: goto -6 -> 94
    //   103: astore_1
    //   104: goto -10 -> 94
    //   107: astore_1
    //   108: goto -14 -> 94
    //   111: aload_2
    //   112: astore_3
    //   113: new 89	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   120: astore 4
    //   122: aload_2
    //   123: astore_3
    //   124: aload 4
    //   126: ldc 92
    //   128: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload_2
    //   133: astore_3
    //   134: aload 4
    //   136: aload_1
    //   137: invokevirtual 102	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   140: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload_2
    //   145: astore_3
    //   146: ldc 8
    //   148: aload 4
    //   150: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 110	com/huawei/secure/android/common/ssl/util/g:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aconst_null
    //   157: astore_3
    //   158: aload_2
    //   159: astore_1
    //   160: aload_1
    //   161: invokestatic 115	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/InputStream;)V
    //   164: aload_3
    //   165: areturn
    //   166: astore_1
    //   167: aload_3
    //   168: invokestatic 115	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/InputStream;)V
    //   171: goto +5 -> 176
    //   174: aload_1
    //   175: athrow
    //   176: goto -2 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	j
    //   0	179	1	paramString1	String
    //   0	179	2	paramString2	String
    //   20	32	3	str1	String
    //   55	4	3	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   63	4	3	localIOException	java.io.IOException
    //   71	4	3	localCertificateException	java.security.cert.CertificateException
    //   79	4	3	localKeyStoreException	java.security.KeyStoreException
    //   89	79	3	str2	String
    //   5	144	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	25	55	java/security/NoSuchAlgorithmException
    //   27	38	55	java/security/NoSuchAlgorithmException
    //   40	50	55	java/security/NoSuchAlgorithmException
    //   21	25	63	java/io/IOException
    //   27	38	63	java/io/IOException
    //   40	50	63	java/io/IOException
    //   21	25	71	java/security/cert/CertificateException
    //   27	38	71	java/security/cert/CertificateException
    //   40	50	71	java/security/cert/CertificateException
    //   21	25	79	java/security/KeyStoreException
    //   27	38	79	java/security/KeyStoreException
    //   40	50	79	java/security/KeyStoreException
    //   0	19	87	finally
    //   0	19	93	java/security/NoSuchAlgorithmException
    //   0	19	99	java/io/IOException
    //   0	19	103	java/security/cert/CertificateException
    //   0	19	107	java/security/KeyStoreException
    //   21	25	166	finally
    //   27	38	166	finally
    //   40	50	166	finally
    //   113	122	166	finally
    //   124	132	166	finally
    //   134	144	166	finally
    //   146	156	166	finally
  }
  
  public X509Certificate b()
  {
    return a("hmsrootcas.bks", "052root");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.util.j
 * JD-Core Version:    0.7.0.1
 */