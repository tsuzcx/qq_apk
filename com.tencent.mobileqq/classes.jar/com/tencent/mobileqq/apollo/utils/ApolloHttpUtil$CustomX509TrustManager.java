package com.tencent.mobileqq.apollo.utils;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public class ApolloHttpUtil$CustomX509TrustManager
  implements X509TrustManager
{
  X509TrustManager a;
  
  /* Error */
  ApolloHttpUtil$CustomX509TrustManager()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 14	java/lang/Object:<init>	()V
    //   4: ldc 16
    //   6: invokestatic 22	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   9: astore 5
    //   11: goto +45 -> 56
    //   14: astore_3
    //   15: new 24	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   22: astore 4
    //   24: aload 4
    //   26: ldc 27
    //   28: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 4
    //   34: aload_3
    //   35: invokevirtual 35	java/lang/Exception:toString	()Ljava/lang/String;
    //   38: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: ldc 37
    //   44: iconst_1
    //   45: aload 4
    //   47: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 44	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aconst_null
    //   54: astore 5
    //   56: iconst_0
    //   57: istore_2
    //   58: iconst_0
    //   59: anewarray 46	javax/net/ssl/TrustManager
    //   62: astore 7
    //   64: aload 5
    //   66: ifnull +249 -> 315
    //   69: new 48	java/io/FileInputStream
    //   72: dup
    //   73: ldc 50
    //   75: invokespecial 53	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   78: astore 6
    //   80: aload 7
    //   82: astore_3
    //   83: aload 6
    //   85: astore 4
    //   87: aload 5
    //   89: aload 6
    //   91: ldc 55
    //   93: invokevirtual 61	java/lang/String:toCharArray	()[C
    //   96: invokevirtual 65	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   99: aload 7
    //   101: astore_3
    //   102: aload 6
    //   104: astore 4
    //   106: ldc 67
    //   108: ldc 69
    //   110: invokestatic 74	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   113: astore 8
    //   115: aload 7
    //   117: astore_3
    //   118: aload 6
    //   120: astore 4
    //   122: aload 8
    //   124: aload 5
    //   126: invokevirtual 78	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   129: aload 7
    //   131: astore_3
    //   132: aload 6
    //   134: astore 4
    //   136: aload 8
    //   138: invokevirtual 82	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   141: astore 5
    //   143: aload 5
    //   145: astore_3
    //   146: aload 6
    //   148: astore 4
    //   150: aload 6
    //   152: invokevirtual 85	java/io/FileInputStream:close	()V
    //   155: aload 5
    //   157: astore 4
    //   159: aload 6
    //   161: invokevirtual 85	java/io/FileInputStream:close	()V
    //   164: iload_2
    //   165: istore_1
    //   166: aload 5
    //   168: astore 4
    //   170: goto +201 -> 371
    //   173: astore_3
    //   174: aload_3
    //   175: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   178: iload_2
    //   179: istore_1
    //   180: goto +191 -> 371
    //   183: astore 7
    //   185: aload 6
    //   187: astore 5
    //   189: goto +22 -> 211
    //   192: astore_3
    //   193: aconst_null
    //   194: astore 4
    //   196: goto +97 -> 293
    //   199: astore 4
    //   201: aconst_null
    //   202: astore 5
    //   204: aload 7
    //   206: astore_3
    //   207: aload 4
    //   209: astore 7
    //   211: aload 5
    //   213: astore 4
    //   215: new 24	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   222: astore 6
    //   224: aload 5
    //   226: astore 4
    //   228: aload 6
    //   230: ldc 90
    //   232: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload 5
    //   238: astore 4
    //   240: aload 6
    //   242: aload 7
    //   244: invokevirtual 35	java/lang/Exception:toString	()Ljava/lang/String;
    //   247: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 5
    //   253: astore 4
    //   255: ldc 37
    //   257: iconst_1
    //   258: aload 6
    //   260: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 44	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: iload_2
    //   267: istore_1
    //   268: aload_3
    //   269: astore 4
    //   271: aload 5
    //   273: ifnull +98 -> 371
    //   276: aload_3
    //   277: astore 4
    //   279: aload 5
    //   281: invokevirtual 85	java/io/FileInputStream:close	()V
    //   284: iload_2
    //   285: istore_1
    //   286: aload_3
    //   287: astore 4
    //   289: goto +82 -> 371
    //   292: astore_3
    //   293: aload 4
    //   295: ifnull +18 -> 313
    //   298: aload 4
    //   300: invokevirtual 85	java/io/FileInputStream:close	()V
    //   303: goto +10 -> 313
    //   306: astore 4
    //   308: aload 4
    //   310: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   313: aload_3
    //   314: athrow
    //   315: invokestatic 93	javax/net/ssl/TrustManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
    //   318: invokestatic 96	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   321: astore_3
    //   322: aload_3
    //   323: aconst_null
    //   324: checkcast 18	java/security/KeyStore
    //   327: invokevirtual 78	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   330: aload_3
    //   331: invokevirtual 82	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   334: astore 4
    //   336: new 24	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   343: astore_3
    //   344: aload_3
    //   345: ldc 98
    //   347: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload_3
    //   352: aload 4
    //   354: arraylength
    //   355: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: ldc 37
    //   361: iconst_1
    //   362: aload_3
    //   363: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokestatic 44	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: iload_2
    //   370: istore_1
    //   371: iload_1
    //   372: aload 4
    //   374: arraylength
    //   375: if_icmpge +32 -> 407
    //   378: aload 4
    //   380: iload_1
    //   381: aaload
    //   382: instanceof 6
    //   385: ifeq +15 -> 400
    //   388: aload_0
    //   389: aload 4
    //   391: iload_1
    //   392: aaload
    //   393: checkcast 6	javax/net/ssl/X509TrustManager
    //   396: putfield 103	com/tencent/mobileqq/apollo/utils/ApolloHttpUtil$CustomX509TrustManager:a	Ljavax/net/ssl/X509TrustManager;
    //   399: return
    //   400: iload_1
    //   401: iconst_1
    //   402: iadd
    //   403: istore_1
    //   404: goto -33 -> 371
    //   407: ldc 37
    //   409: iconst_1
    //   410: ldc 105
    //   412: invokestatic 44	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   415: new 12	java/lang/Exception
    //   418: dup
    //   419: ldc 107
    //   421: invokespecial 108	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   424: astore_3
    //   425: goto +5 -> 430
    //   428: aload_3
    //   429: athrow
    //   430: goto -2 -> 428
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	433	0	this	CustomX509TrustManager
    //   165	239	1	i	int
    //   57	313	2	j	int
    //   14	21	3	localException1	java.lang.Exception
    //   82	64	3	localObject1	Object
    //   173	2	3	localException2	java.lang.Exception
    //   192	1	3	localObject2	Object
    //   206	81	3	localObject3	Object
    //   292	22	3	localObject4	Object
    //   321	108	3	localObject5	Object
    //   22	173	4	localObject6	Object
    //   199	9	4	localException3	java.lang.Exception
    //   213	86	4	localObject7	Object
    //   306	3	4	localException4	java.lang.Exception
    //   334	56	4	arrayOfTrustManager1	javax.net.ssl.TrustManager[]
    //   9	271	5	localObject8	Object
    //   78	181	6	localObject9	Object
    //   62	68	7	arrayOfTrustManager2	javax.net.ssl.TrustManager[]
    //   183	22	7	localException5	java.lang.Exception
    //   209	34	7	localException6	java.lang.Exception
    //   113	24	8	localTrustManagerFactory	javax.net.ssl.TrustManagerFactory
    // Exception table:
    //   from	to	target	type
    //   4	11	14	java/lang/Exception
    //   159	164	173	java/lang/Exception
    //   279	284	173	java/lang/Exception
    //   87	99	183	java/lang/Exception
    //   106	115	183	java/lang/Exception
    //   122	129	183	java/lang/Exception
    //   136	143	183	java/lang/Exception
    //   150	155	183	java/lang/Exception
    //   69	80	192	finally
    //   69	80	199	java/lang/Exception
    //   87	99	292	finally
    //   106	115	292	finally
    //   122	129	292	finally
    //   136	143	292	finally
    //   150	155	292	finally
    //   215	224	292	finally
    //   228	236	292	finally
    //   240	251	292	finally
    //   255	266	292	finally
    //   298	303	306	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloHttpUtil.CustomX509TrustManager
 * JD-Core Version:    0.7.0.1
 */