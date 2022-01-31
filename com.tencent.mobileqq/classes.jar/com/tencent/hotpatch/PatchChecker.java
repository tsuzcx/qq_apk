package com.tencent.hotpatch;

public class PatchChecker
{
  /* Error */
  private static int a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: getstatic 25	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   6: invokevirtual 29	com/tencent/common/app/BaseApplicationImpl:getPackageManager	()Landroid/content/pm/PackageManager;
    //   9: ldc 31
    //   11: bipush 64
    //   13: invokevirtual 37	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   16: getfield 43	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   19: iconst_0
    //   20: aaload
    //   21: astore 6
    //   23: new 45	java/util/jar/JarFile
    //   26: dup
    //   27: ldc 47
    //   29: aload_0
    //   30: invokestatic 52	com/tencent/hotpatch/utils/PatchCommonUtil:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   33: invokespecial 55	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   36: astore 4
    //   38: aload 4
    //   40: astore 5
    //   42: aload 4
    //   44: invokevirtual 59	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   47: astore 7
    //   49: sipush 301
    //   52: istore_1
    //   53: aload 4
    //   55: astore 5
    //   57: aload 7
    //   59: invokeinterface 65 1 0
    //   64: ifeq +573 -> 637
    //   67: aload 4
    //   69: astore 5
    //   71: aload 7
    //   73: invokeinterface 69 1 0
    //   78: checkcast 71	java/util/jar/JarEntry
    //   81: astore 8
    //   83: iload_1
    //   84: istore_2
    //   85: aload 4
    //   87: astore 5
    //   89: aload 8
    //   91: invokevirtual 74	java/util/jar/JarEntry:isDirectory	()Z
    //   94: ifne +191 -> 285
    //   97: iload_1
    //   98: istore_2
    //   99: aload 4
    //   101: astore 5
    //   103: aload 8
    //   105: invokevirtual 78	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   108: ldc 80
    //   110: invokevirtual 86	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   113: ifne +172 -> 285
    //   116: aload 4
    //   118: astore 5
    //   120: aload 4
    //   122: aload 8
    //   124: invokestatic 89	com/tencent/hotpatch/PatchChecker:a	(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;)[Ljava/security/cert/Certificate;
    //   127: astore 9
    //   129: iload_1
    //   130: istore_2
    //   131: aload 9
    //   133: ifnull +152 -> 285
    //   136: iload_1
    //   137: istore_2
    //   138: aload 4
    //   140: astore 5
    //   142: aload 9
    //   144: arraylength
    //   145: iconst_1
    //   146: if_icmpne +139 -> 285
    //   149: aload 4
    //   151: astore 5
    //   153: new 91	android/content/pm/Signature
    //   156: dup
    //   157: aload 9
    //   159: iconst_0
    //   160: aaload
    //   161: invokevirtual 97	java/security/cert/Certificate:getEncoded	()[B
    //   164: invokespecial 100	android/content/pm/Signature:<init>	([B)V
    //   167: aload 6
    //   169: invokevirtual 104	android/content/pm/Signature:equals	(Ljava/lang/Object;)Z
    //   172: ifeq +106 -> 278
    //   175: sipush 300
    //   178: istore_1
    //   179: aload 4
    //   181: astore 5
    //   183: ldc 106
    //   185: iconst_1
    //   186: new 108	java/lang/StringBuilder
    //   189: dup
    //   190: ldc 110
    //   192: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   195: aload 8
    //   197: invokevirtual 78	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   200: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: ldc 117
    //   205: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: iload_1
    //   209: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   212: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: iload_1
    //   219: istore_2
    //   220: sipush 300
    //   223: iload_1
    //   224: if_icmpeq +61 -> 285
    //   227: iload_1
    //   228: istore_2
    //   229: iload_2
    //   230: istore_1
    //   231: aload 4
    //   233: ifnull +10 -> 243
    //   236: aload 4
    //   238: invokevirtual 132	java/util/jar/JarFile:close	()V
    //   241: iload_2
    //   242: istore_1
    //   243: getstatic 25	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   246: astore 4
    //   248: iload_1
    //   249: sipush 300
    //   252: if_icmpne +341 -> 593
    //   255: iconst_1
    //   256: istore_3
    //   257: aload 4
    //   259: aload_0
    //   260: iload_3
    //   261: invokestatic 137	com/tencent/hotpatch/utils/PatchSharedPreUtil:a	(Landroid/content/Context;Ljava/lang/String;Z)V
    //   264: getstatic 25	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   267: ldc 139
    //   269: ldc 141
    //   271: iload_1
    //   272: aload_0
    //   273: invokestatic 146	com/tencent/hotpatch/utils/PatchReporter:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   276: iload_1
    //   277: ireturn
    //   278: sipush 301
    //   281: istore_1
    //   282: goto -103 -> 179
    //   285: iload_2
    //   286: istore_1
    //   287: goto -234 -> 53
    //   290: astore 4
    //   292: aload 4
    //   294: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   297: iload_2
    //   298: istore_1
    //   299: goto -56 -> 243
    //   302: astore 6
    //   304: aload 5
    //   306: astore 4
    //   308: aload 6
    //   310: astore 5
    //   312: ldc 106
    //   314: iconst_1
    //   315: new 108	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   322: ldc 152
    //   324: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload 5
    //   329: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: aload 4
    //   340: ifnull +290 -> 630
    //   343: aload 4
    //   345: invokevirtual 132	java/util/jar/JarFile:close	()V
    //   348: sipush 302
    //   351: istore_1
    //   352: goto -109 -> 243
    //   355: astore 4
    //   357: aload 4
    //   359: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   362: sipush 302
    //   365: istore_1
    //   366: goto -123 -> 243
    //   369: astore 6
    //   371: aconst_null
    //   372: astore 4
    //   374: aload 4
    //   376: astore 5
    //   378: ldc 106
    //   380: iconst_1
    //   381: new 108	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   388: ldc 157
    //   390: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload 6
    //   395: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   404: aload 4
    //   406: ifnull +224 -> 630
    //   409: aload 4
    //   411: invokevirtual 132	java/util/jar/JarFile:close	()V
    //   414: sipush 302
    //   417: istore_1
    //   418: goto -175 -> 243
    //   421: astore 4
    //   423: aload 4
    //   425: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   428: sipush 302
    //   431: istore_1
    //   432: goto -189 -> 243
    //   435: astore 6
    //   437: aconst_null
    //   438: astore 4
    //   440: aload 4
    //   442: astore 5
    //   444: ldc 106
    //   446: iconst_1
    //   447: new 108	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   454: ldc 159
    //   456: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload 6
    //   461: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   470: aload 4
    //   472: ifnull +158 -> 630
    //   475: aload 4
    //   477: invokevirtual 132	java/util/jar/JarFile:close	()V
    //   480: sipush 302
    //   483: istore_1
    //   484: goto -241 -> 243
    //   487: astore 4
    //   489: aload 4
    //   491: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   494: sipush 302
    //   497: istore_1
    //   498: goto -255 -> 243
    //   501: astore 6
    //   503: aconst_null
    //   504: astore 4
    //   506: aload 4
    //   508: astore 5
    //   510: ldc 106
    //   512: iconst_1
    //   513: new 108	java/lang/StringBuilder
    //   516: dup
    //   517: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   520: ldc 161
    //   522: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: aload 6
    //   527: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   530: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   536: aload 4
    //   538: ifnull +92 -> 630
    //   541: aload 4
    //   543: invokevirtual 132	java/util/jar/JarFile:close	()V
    //   546: sipush 302
    //   549: istore_1
    //   550: goto -307 -> 243
    //   553: astore 4
    //   555: aload 4
    //   557: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   560: sipush 302
    //   563: istore_1
    //   564: goto -321 -> 243
    //   567: astore_0
    //   568: aconst_null
    //   569: astore 5
    //   571: aload 5
    //   573: ifnull +8 -> 581
    //   576: aload 5
    //   578: invokevirtual 132	java/util/jar/JarFile:close	()V
    //   581: aload_0
    //   582: athrow
    //   583: astore 4
    //   585: aload 4
    //   587: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   590: goto -9 -> 581
    //   593: iconst_0
    //   594: istore_3
    //   595: goto -338 -> 257
    //   598: astore_0
    //   599: goto -28 -> 571
    //   602: astore_0
    //   603: aload 4
    //   605: astore 5
    //   607: goto -36 -> 571
    //   610: astore 6
    //   612: goto -106 -> 506
    //   615: astore 6
    //   617: goto -177 -> 440
    //   620: astore 6
    //   622: goto -248 -> 374
    //   625: astore 5
    //   627: goto -315 -> 312
    //   630: sipush 302
    //   633: istore_1
    //   634: goto -391 -> 243
    //   637: iload_1
    //   638: istore_2
    //   639: goto -410 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	642	0	paramString	String
    //   52	586	1	i	int
    //   84	555	2	j	int
    //   256	339	3	bool	boolean
    //   36	222	4	localObject1	Object
    //   290	3	4	localIOException1	java.io.IOException
    //   306	38	4	localObject2	Object
    //   355	3	4	localIOException2	java.io.IOException
    //   372	38	4	localObject3	Object
    //   421	3	4	localIOException3	java.io.IOException
    //   438	38	4	localObject4	Object
    //   487	3	4	localIOException4	java.io.IOException
    //   504	38	4	localObject5	Object
    //   553	3	4	localIOException5	java.io.IOException
    //   583	21	4	localIOException6	java.io.IOException
    //   1	605	5	localObject6	Object
    //   625	1	5	localCertificateEncodingException1	java.security.cert.CertificateEncodingException
    //   21	147	6	localSignature	android.content.pm.Signature
    //   302	7	6	localCertificateEncodingException2	java.security.cert.CertificateEncodingException
    //   369	25	6	localIOException7	java.io.IOException
    //   435	25	6	localNameNotFoundException1	android.content.pm.PackageManager.NameNotFoundException
    //   501	25	6	localThrowable1	java.lang.Throwable
    //   610	1	6	localThrowable2	java.lang.Throwable
    //   615	1	6	localNameNotFoundException2	android.content.pm.PackageManager.NameNotFoundException
    //   620	1	6	localIOException8	java.io.IOException
    //   47	25	7	localEnumeration	java.util.Enumeration
    //   81	115	8	localJarEntry	java.util.jar.JarEntry
    //   127	31	9	arrayOfCertificate	java.security.cert.Certificate[]
    // Exception table:
    //   from	to	target	type
    //   236	241	290	java/io/IOException
    //   3	38	302	java/security/cert/CertificateEncodingException
    //   343	348	355	java/io/IOException
    //   3	38	369	java/io/IOException
    //   409	414	421	java/io/IOException
    //   3	38	435	android/content/pm/PackageManager$NameNotFoundException
    //   475	480	487	java/io/IOException
    //   3	38	501	java/lang/Throwable
    //   541	546	553	java/io/IOException
    //   3	38	567	finally
    //   576	581	583	java/io/IOException
    //   42	49	598	finally
    //   57	67	598	finally
    //   71	83	598	finally
    //   89	97	598	finally
    //   103	116	598	finally
    //   120	129	598	finally
    //   142	149	598	finally
    //   153	175	598	finally
    //   183	218	598	finally
    //   378	404	598	finally
    //   444	470	598	finally
    //   510	536	598	finally
    //   312	338	602	finally
    //   42	49	610	java/lang/Throwable
    //   57	67	610	java/lang/Throwable
    //   71	83	610	java/lang/Throwable
    //   89	97	610	java/lang/Throwable
    //   103	116	610	java/lang/Throwable
    //   120	129	610	java/lang/Throwable
    //   142	149	610	java/lang/Throwable
    //   153	175	610	java/lang/Throwable
    //   183	218	610	java/lang/Throwable
    //   42	49	615	android/content/pm/PackageManager$NameNotFoundException
    //   57	67	615	android/content/pm/PackageManager$NameNotFoundException
    //   71	83	615	android/content/pm/PackageManager$NameNotFoundException
    //   89	97	615	android/content/pm/PackageManager$NameNotFoundException
    //   103	116	615	android/content/pm/PackageManager$NameNotFoundException
    //   120	129	615	android/content/pm/PackageManager$NameNotFoundException
    //   142	149	615	android/content/pm/PackageManager$NameNotFoundException
    //   153	175	615	android/content/pm/PackageManager$NameNotFoundException
    //   183	218	615	android/content/pm/PackageManager$NameNotFoundException
    //   42	49	620	java/io/IOException
    //   57	67	620	java/io/IOException
    //   71	83	620	java/io/IOException
    //   89	97	620	java/io/IOException
    //   103	116	620	java/io/IOException
    //   120	129	620	java/io/IOException
    //   142	149	620	java/io/IOException
    //   153	175	620	java/io/IOException
    //   183	218	620	java/io/IOException
    //   42	49	625	java/security/cert/CertificateEncodingException
    //   57	67	625	java/security/cert/CertificateEncodingException
    //   71	83	625	java/security/cert/CertificateEncodingException
    //   89	97	625	java/security/cert/CertificateEncodingException
    //   103	116	625	java/security/cert/CertificateEncodingException
    //   120	129	625	java/security/cert/CertificateEncodingException
    //   142	149	625	java/security/cert/CertificateEncodingException
    //   153	175	625	java/security/cert/CertificateEncodingException
    //   183	218	625	java/security/cert/CertificateEncodingException
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ("dex".equals(paramString1))
    {
      bool1 = bool2;
      if (300 == a(paramString2)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  /* Error */
  private static java.security.cert.Certificate[] a(java.util.jar.JarFile paramJarFile, java.util.jar.JarEntry paramJarEntry)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 169	java/io/BufferedInputStream
    //   8: dup
    //   9: aload_0
    //   10: aload_1
    //   11: invokevirtual 173	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   14: invokespecial 176	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: aload_2
    //   19: astore_0
    //   20: sipush 4096
    //   23: newarray byte
    //   25: astore 5
    //   27: aload_2
    //   28: astore_0
    //   29: aload_2
    //   30: aload 5
    //   32: iconst_0
    //   33: aload 5
    //   35: arraylength
    //   36: invokevirtual 182	java/io/InputStream:read	([BII)I
    //   39: iconst_m1
    //   40: if_icmpne -13 -> 27
    //   43: aload 4
    //   45: astore_0
    //   46: aload_1
    //   47: ifnull +12 -> 59
    //   50: aload_2
    //   51: astore_0
    //   52: aload_1
    //   53: invokevirtual 186	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   56: astore_1
    //   57: aload_1
    //   58: astore_0
    //   59: aload_0
    //   60: astore_1
    //   61: aload_2
    //   62: ifnull +9 -> 71
    //   65: aload_2
    //   66: invokevirtual 187	java/io/InputStream:close	()V
    //   69: aload_0
    //   70: astore_1
    //   71: aload_1
    //   72: areturn
    //   73: astore_1
    //   74: aload_1
    //   75: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   78: aload_0
    //   79: areturn
    //   80: astore_1
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_2
    //   84: astore_0
    //   85: ldc 106
    //   87: iconst_1
    //   88: new 108	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   95: ldc 189
    //   97: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_1
    //   101: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aload_3
    //   111: astore_1
    //   112: aload_2
    //   113: ifnull -42 -> 71
    //   116: aload_2
    //   117: invokevirtual 187	java/io/InputStream:close	()V
    //   120: aconst_null
    //   121: areturn
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   127: aconst_null
    //   128: areturn
    //   129: astore_1
    //   130: aconst_null
    //   131: astore_2
    //   132: aload_2
    //   133: astore_0
    //   134: ldc 106
    //   136: iconst_1
    //   137: new 108	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   144: ldc 191
    //   146: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_1
    //   150: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload_3
    //   160: astore_1
    //   161: aload_2
    //   162: ifnull -91 -> 71
    //   165: aload_2
    //   166: invokevirtual 187	java/io/InputStream:close	()V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_0
    //   172: aload_0
    //   173: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   176: aconst_null
    //   177: areturn
    //   178: astore_1
    //   179: aconst_null
    //   180: astore_0
    //   181: aload_0
    //   182: ifnull +7 -> 189
    //   185: aload_0
    //   186: invokevirtual 187	java/io/InputStream:close	()V
    //   189: aload_1
    //   190: athrow
    //   191: astore_0
    //   192: aload_0
    //   193: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   196: goto -7 -> 189
    //   199: astore_1
    //   200: goto -19 -> 181
    //   203: astore_1
    //   204: goto -72 -> 132
    //   207: astore_1
    //   208: goto -125 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramJarFile	java.util.jar.JarFile
    //   0	211	1	paramJarEntry	java.util.jar.JarEntry
    //   17	149	2	localBufferedInputStream	java.io.BufferedInputStream
    //   1	159	3	localObject1	Object
    //   3	41	4	localObject2	Object
    //   25	9	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   65	69	73	java/io/IOException
    //   5	18	80	java/io/IOException
    //   116	120	122	java/io/IOException
    //   5	18	129	java/lang/RuntimeException
    //   165	169	171	java/io/IOException
    //   5	18	178	finally
    //   185	189	191	java/io/IOException
    //   20	27	199	finally
    //   29	43	199	finally
    //   52	57	199	finally
    //   85	110	199	finally
    //   134	159	199	finally
    //   20	27	203	java/lang/RuntimeException
    //   29	43	203	java/lang/RuntimeException
    //   52	57	203	java/lang/RuntimeException
    //   20	27	207	java/io/IOException
    //   29	43	207	java/io/IOException
    //   52	57	207	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.hotpatch.PatchChecker
 * JD-Core Version:    0.7.0.1
 */