import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public class anlt
  implements X509TrustManager
{
  X509TrustManager a;
  
  /* Error */
  anlt()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 14	java/lang/Object:<init>	()V
    //   4: ldc 16
    //   6: invokestatic 22	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   9: astore 5
    //   11: iconst_0
    //   12: anewarray 24	javax/net/ssl/TrustManager
    //   15: astore_2
    //   16: aload 5
    //   18: ifnull +222 -> 240
    //   21: new 26	java/io/FileInputStream
    //   24: dup
    //   25: ldc 28
    //   27: invokespecial 31	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   30: astore 4
    //   32: aload 4
    //   34: astore_3
    //   35: aload 5
    //   37: aload 4
    //   39: ldc 33
    //   41: invokevirtual 39	java/lang/String:toCharArray	()[C
    //   44: invokevirtual 43	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   47: aload 4
    //   49: astore_3
    //   50: ldc 45
    //   52: ldc 47
    //   54: invokestatic 52	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   57: astore 6
    //   59: aload 4
    //   61: astore_3
    //   62: aload 6
    //   64: aload 5
    //   66: invokevirtual 56	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   69: aload 4
    //   71: astore_3
    //   72: aload 6
    //   74: invokevirtual 60	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   77: astore 5
    //   79: aload 5
    //   81: astore_2
    //   82: aload 4
    //   84: astore_3
    //   85: aload 4
    //   87: invokevirtual 63	java/io/FileInputStream:close	()V
    //   90: aload_2
    //   91: astore_3
    //   92: aload 4
    //   94: ifnull +10 -> 104
    //   97: aload 4
    //   99: invokevirtual 63	java/io/FileInputStream:close	()V
    //   102: aload_2
    //   103: astore_3
    //   104: iconst_0
    //   105: istore_1
    //   106: iload_1
    //   107: aload_3
    //   108: arraylength
    //   109: if_icmpge +187 -> 296
    //   112: aload_3
    //   113: iload_1
    //   114: aaload
    //   115: instanceof 6
    //   118: ifeq +171 -> 289
    //   121: aload_0
    //   122: aload_3
    //   123: iload_1
    //   124: aaload
    //   125: checkcast 6	javax/net/ssl/X509TrustManager
    //   128: putfield 65	anlt:a	Ljavax/net/ssl/X509TrustManager;
    //   131: return
    //   132: astore_2
    //   133: ldc 67
    //   135: iconst_1
    //   136: new 69	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   143: ldc 72
    //   145: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_2
    //   149: invokevirtual 80	java/lang/Exception:toString	()Ljava/lang/String;
    //   152: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: aconst_null
    //   162: astore 5
    //   164: goto -153 -> 11
    //   167: astore 5
    //   169: aconst_null
    //   170: astore 4
    //   172: aload 4
    //   174: astore_3
    //   175: ldc 67
    //   177: iconst_1
    //   178: new 69	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   185: ldc 89
    //   187: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload 5
    //   192: invokevirtual 80	java/lang/Exception:toString	()Ljava/lang/String;
    //   195: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload_2
    //   205: astore_3
    //   206: aload 4
    //   208: ifnull -104 -> 104
    //   211: aload 4
    //   213: invokevirtual 63	java/io/FileInputStream:close	()V
    //   216: aload_2
    //   217: astore_3
    //   218: goto -114 -> 104
    //   221: astore_3
    //   222: aload_2
    //   223: astore_3
    //   224: goto -120 -> 104
    //   227: astore_2
    //   228: aconst_null
    //   229: astore_3
    //   230: aload_3
    //   231: ifnull +7 -> 238
    //   234: aload_3
    //   235: invokevirtual 63	java/io/FileInputStream:close	()V
    //   238: aload_2
    //   239: athrow
    //   240: invokestatic 92	javax/net/ssl/TrustManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
    //   243: invokestatic 95	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   246: astore_2
    //   247: aload_2
    //   248: aconst_null
    //   249: checkcast 18	java/security/KeyStore
    //   252: invokevirtual 56	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   255: aload_2
    //   256: invokevirtual 60	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   259: astore_3
    //   260: ldc 67
    //   262: iconst_1
    //   263: new 69	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   270: ldc 97
    //   272: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_3
    //   276: arraylength
    //   277: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   280: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: goto -182 -> 104
    //   289: iload_1
    //   290: iconst_1
    //   291: iadd
    //   292: istore_1
    //   293: goto -187 -> 106
    //   296: ldc 67
    //   298: iconst_1
    //   299: ldc 102
    //   301: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   304: new 12	java/lang/Exception
    //   307: dup
    //   308: ldc 104
    //   310: invokespecial 105	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   313: athrow
    //   314: astore_3
    //   315: aload_2
    //   316: astore_3
    //   317: goto -213 -> 104
    //   320: astore_3
    //   321: goto -83 -> 238
    //   324: astore_2
    //   325: goto -95 -> 230
    //   328: astore 5
    //   330: goto -158 -> 172
    //   333: astore 5
    //   335: goto -163 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	this	anlt
    //   105	188	1	i	int
    //   15	88	2	localObject1	Object
    //   132	91	2	localException1	java.lang.Exception
    //   227	12	2	localObject2	Object
    //   246	70	2	localTrustManagerFactory1	javax.net.ssl.TrustManagerFactory
    //   324	1	2	localObject3	Object
    //   34	184	3	localObject4	Object
    //   221	1	3	localException2	java.lang.Exception
    //   223	53	3	localObject5	Object
    //   314	1	3	localException3	java.lang.Exception
    //   316	1	3	localTrustManagerFactory2	javax.net.ssl.TrustManagerFactory
    //   320	1	3	localException4	java.lang.Exception
    //   30	182	4	localFileInputStream	java.io.FileInputStream
    //   9	154	5	localObject6	Object
    //   167	24	5	localException5	java.lang.Exception
    //   328	1	5	localException6	java.lang.Exception
    //   333	1	5	localException7	java.lang.Exception
    //   57	16	6	localTrustManagerFactory3	javax.net.ssl.TrustManagerFactory
    // Exception table:
    //   from	to	target	type
    //   4	11	132	java/lang/Exception
    //   21	32	167	java/lang/Exception
    //   211	216	221	java/lang/Exception
    //   21	32	227	finally
    //   97	102	314	java/lang/Exception
    //   234	238	320	java/lang/Exception
    //   35	47	324	finally
    //   50	59	324	finally
    //   62	69	324	finally
    //   72	79	324	finally
    //   85	90	324	finally
    //   175	204	324	finally
    //   35	47	328	java/lang/Exception
    //   50	59	328	java/lang/Exception
    //   62	69	328	java/lang/Exception
    //   72	79	328	java/lang/Exception
    //   85	90	333	java/lang/Exception
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    this.a.checkClientTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return this.a.getAcceptedIssuers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anlt
 * JD-Core Version:    0.7.0.1
 */