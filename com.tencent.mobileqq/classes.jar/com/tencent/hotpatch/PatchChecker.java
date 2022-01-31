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
    //   27: aload_0
    //   28: invokestatic 50	com/tencent/hotpatch/utils/PatchCommonUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokespecial 53	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   34: astore 4
    //   36: aload 4
    //   38: astore 5
    //   40: aload 4
    //   42: invokevirtual 57	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   45: astore 7
    //   47: sipush 301
    //   50: istore_1
    //   51: aload 4
    //   53: astore 5
    //   55: aload 7
    //   57: invokeinterface 63 1 0
    //   62: ifeq +573 -> 635
    //   65: aload 4
    //   67: astore 5
    //   69: aload 7
    //   71: invokeinterface 67 1 0
    //   76: checkcast 69	java/util/jar/JarEntry
    //   79: astore 8
    //   81: iload_1
    //   82: istore_2
    //   83: aload 4
    //   85: astore 5
    //   87: aload 8
    //   89: invokevirtual 72	java/util/jar/JarEntry:isDirectory	()Z
    //   92: ifne +191 -> 283
    //   95: iload_1
    //   96: istore_2
    //   97: aload 4
    //   99: astore 5
    //   101: aload 8
    //   103: invokevirtual 76	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   106: ldc 78
    //   108: invokevirtual 84	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   111: ifne +172 -> 283
    //   114: aload 4
    //   116: astore 5
    //   118: aload 4
    //   120: aload 8
    //   122: invokestatic 87	com/tencent/hotpatch/PatchChecker:a	(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;)[Ljava/security/cert/Certificate;
    //   125: astore 9
    //   127: iload_1
    //   128: istore_2
    //   129: aload 9
    //   131: ifnull +152 -> 283
    //   134: iload_1
    //   135: istore_2
    //   136: aload 4
    //   138: astore 5
    //   140: aload 9
    //   142: arraylength
    //   143: iconst_1
    //   144: if_icmpne +139 -> 283
    //   147: aload 4
    //   149: astore 5
    //   151: new 89	android/content/pm/Signature
    //   154: dup
    //   155: aload 9
    //   157: iconst_0
    //   158: aaload
    //   159: invokevirtual 95	java/security/cert/Certificate:getEncoded	()[B
    //   162: invokespecial 98	android/content/pm/Signature:<init>	([B)V
    //   165: aload 6
    //   167: invokevirtual 102	android/content/pm/Signature:equals	(Ljava/lang/Object;)Z
    //   170: ifeq +106 -> 276
    //   173: sipush 300
    //   176: istore_1
    //   177: aload 4
    //   179: astore 5
    //   181: ldc 104
    //   183: iconst_1
    //   184: new 106	java/lang/StringBuilder
    //   187: dup
    //   188: ldc 108
    //   190: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   193: aload 8
    //   195: invokevirtual 76	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   198: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc 115
    //   203: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: iload_1
    //   207: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   210: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: iload_1
    //   217: istore_2
    //   218: sipush 300
    //   221: iload_1
    //   222: if_icmpeq +61 -> 283
    //   225: iload_1
    //   226: istore_2
    //   227: iload_2
    //   228: istore_1
    //   229: aload 4
    //   231: ifnull +10 -> 241
    //   234: aload 4
    //   236: invokevirtual 130	java/util/jar/JarFile:close	()V
    //   239: iload_2
    //   240: istore_1
    //   241: getstatic 25	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   244: astore 4
    //   246: iload_1
    //   247: sipush 300
    //   250: if_icmpne +341 -> 591
    //   253: iconst_1
    //   254: istore_3
    //   255: aload 4
    //   257: aload_0
    //   258: iload_3
    //   259: invokestatic 135	com/tencent/hotpatch/utils/PatchSharedPreUtil:a	(Landroid/content/Context;Ljava/lang/String;Z)V
    //   262: getstatic 25	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   265: ldc 137
    //   267: ldc 139
    //   269: iload_1
    //   270: aload_0
    //   271: invokestatic 144	com/tencent/hotpatch/utils/PatchReporter:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   274: iload_1
    //   275: ireturn
    //   276: sipush 301
    //   279: istore_1
    //   280: goto -103 -> 177
    //   283: iload_2
    //   284: istore_1
    //   285: goto -234 -> 51
    //   288: astore 4
    //   290: aload 4
    //   292: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   295: iload_2
    //   296: istore_1
    //   297: goto -56 -> 241
    //   300: astore 6
    //   302: aload 5
    //   304: astore 4
    //   306: aload 6
    //   308: astore 5
    //   310: ldc 104
    //   312: iconst_1
    //   313: new 106	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   320: ldc 150
    //   322: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload 5
    //   327: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   336: aload 4
    //   338: ifnull +290 -> 628
    //   341: aload 4
    //   343: invokevirtual 130	java/util/jar/JarFile:close	()V
    //   346: sipush 302
    //   349: istore_1
    //   350: goto -109 -> 241
    //   353: astore 4
    //   355: aload 4
    //   357: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   360: sipush 302
    //   363: istore_1
    //   364: goto -123 -> 241
    //   367: astore 6
    //   369: aconst_null
    //   370: astore 4
    //   372: aload 4
    //   374: astore 5
    //   376: ldc 104
    //   378: iconst_1
    //   379: new 106	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   386: ldc 155
    //   388: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload 6
    //   393: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   396: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   402: aload 4
    //   404: ifnull +224 -> 628
    //   407: aload 4
    //   409: invokevirtual 130	java/util/jar/JarFile:close	()V
    //   412: sipush 302
    //   415: istore_1
    //   416: goto -175 -> 241
    //   419: astore 4
    //   421: aload 4
    //   423: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   426: sipush 302
    //   429: istore_1
    //   430: goto -189 -> 241
    //   433: astore 6
    //   435: aconst_null
    //   436: astore 4
    //   438: aload 4
    //   440: astore 5
    //   442: ldc 104
    //   444: iconst_1
    //   445: new 106	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   452: ldc 157
    //   454: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload 6
    //   459: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   462: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   468: aload 4
    //   470: ifnull +158 -> 628
    //   473: aload 4
    //   475: invokevirtual 130	java/util/jar/JarFile:close	()V
    //   478: sipush 302
    //   481: istore_1
    //   482: goto -241 -> 241
    //   485: astore 4
    //   487: aload 4
    //   489: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   492: sipush 302
    //   495: istore_1
    //   496: goto -255 -> 241
    //   499: astore 6
    //   501: aconst_null
    //   502: astore 4
    //   504: aload 4
    //   506: astore 5
    //   508: ldc 104
    //   510: iconst_1
    //   511: new 106	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   518: ldc 159
    //   520: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: aload 6
    //   525: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   528: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   534: aload 4
    //   536: ifnull +92 -> 628
    //   539: aload 4
    //   541: invokevirtual 130	java/util/jar/JarFile:close	()V
    //   544: sipush 302
    //   547: istore_1
    //   548: goto -307 -> 241
    //   551: astore 4
    //   553: aload 4
    //   555: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   558: sipush 302
    //   561: istore_1
    //   562: goto -321 -> 241
    //   565: astore_0
    //   566: aconst_null
    //   567: astore 5
    //   569: aload 5
    //   571: ifnull +8 -> 579
    //   574: aload 5
    //   576: invokevirtual 130	java/util/jar/JarFile:close	()V
    //   579: aload_0
    //   580: athrow
    //   581: astore 4
    //   583: aload 4
    //   585: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   588: goto -9 -> 579
    //   591: iconst_0
    //   592: istore_3
    //   593: goto -338 -> 255
    //   596: astore_0
    //   597: goto -28 -> 569
    //   600: astore_0
    //   601: aload 4
    //   603: astore 5
    //   605: goto -36 -> 569
    //   608: astore 6
    //   610: goto -106 -> 504
    //   613: astore 6
    //   615: goto -177 -> 438
    //   618: astore 6
    //   620: goto -248 -> 372
    //   623: astore 5
    //   625: goto -315 -> 310
    //   628: sipush 302
    //   631: istore_1
    //   632: goto -391 -> 241
    //   635: iload_1
    //   636: istore_2
    //   637: goto -410 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	640	0	paramString	String
    //   50	586	1	i	int
    //   82	555	2	j	int
    //   254	339	3	bool	boolean
    //   34	222	4	localObject1	Object
    //   288	3	4	localIOException1	java.io.IOException
    //   304	38	4	localObject2	Object
    //   353	3	4	localIOException2	java.io.IOException
    //   370	38	4	localObject3	Object
    //   419	3	4	localIOException3	java.io.IOException
    //   436	38	4	localObject4	Object
    //   485	3	4	localIOException4	java.io.IOException
    //   502	38	4	localObject5	Object
    //   551	3	4	localIOException5	java.io.IOException
    //   581	21	4	localIOException6	java.io.IOException
    //   1	603	5	localObject6	Object
    //   623	1	5	localCertificateEncodingException1	java.security.cert.CertificateEncodingException
    //   21	145	6	localSignature	android.content.pm.Signature
    //   300	7	6	localCertificateEncodingException2	java.security.cert.CertificateEncodingException
    //   367	25	6	localIOException7	java.io.IOException
    //   433	25	6	localNameNotFoundException1	android.content.pm.PackageManager.NameNotFoundException
    //   499	25	6	localThrowable1	java.lang.Throwable
    //   608	1	6	localThrowable2	java.lang.Throwable
    //   613	1	6	localNameNotFoundException2	android.content.pm.PackageManager.NameNotFoundException
    //   618	1	6	localIOException8	java.io.IOException
    //   45	25	7	localEnumeration	java.util.Enumeration
    //   79	115	8	localJarEntry	java.util.jar.JarEntry
    //   125	31	9	arrayOfCertificate	java.security.cert.Certificate[]
    // Exception table:
    //   from	to	target	type
    //   234	239	288	java/io/IOException
    //   3	36	300	java/security/cert/CertificateEncodingException
    //   341	346	353	java/io/IOException
    //   3	36	367	java/io/IOException
    //   407	412	419	java/io/IOException
    //   3	36	433	android/content/pm/PackageManager$NameNotFoundException
    //   473	478	485	java/io/IOException
    //   3	36	499	java/lang/Throwable
    //   539	544	551	java/io/IOException
    //   3	36	565	finally
    //   574	579	581	java/io/IOException
    //   40	47	596	finally
    //   55	65	596	finally
    //   69	81	596	finally
    //   87	95	596	finally
    //   101	114	596	finally
    //   118	127	596	finally
    //   140	147	596	finally
    //   151	173	596	finally
    //   181	216	596	finally
    //   376	402	596	finally
    //   442	468	596	finally
    //   508	534	596	finally
    //   310	336	600	finally
    //   40	47	608	java/lang/Throwable
    //   55	65	608	java/lang/Throwable
    //   69	81	608	java/lang/Throwable
    //   87	95	608	java/lang/Throwable
    //   101	114	608	java/lang/Throwable
    //   118	127	608	java/lang/Throwable
    //   140	147	608	java/lang/Throwable
    //   151	173	608	java/lang/Throwable
    //   181	216	608	java/lang/Throwable
    //   40	47	613	android/content/pm/PackageManager$NameNotFoundException
    //   55	65	613	android/content/pm/PackageManager$NameNotFoundException
    //   69	81	613	android/content/pm/PackageManager$NameNotFoundException
    //   87	95	613	android/content/pm/PackageManager$NameNotFoundException
    //   101	114	613	android/content/pm/PackageManager$NameNotFoundException
    //   118	127	613	android/content/pm/PackageManager$NameNotFoundException
    //   140	147	613	android/content/pm/PackageManager$NameNotFoundException
    //   151	173	613	android/content/pm/PackageManager$NameNotFoundException
    //   181	216	613	android/content/pm/PackageManager$NameNotFoundException
    //   40	47	618	java/io/IOException
    //   55	65	618	java/io/IOException
    //   69	81	618	java/io/IOException
    //   87	95	618	java/io/IOException
    //   101	114	618	java/io/IOException
    //   118	127	618	java/io/IOException
    //   140	147	618	java/io/IOException
    //   151	173	618	java/io/IOException
    //   181	216	618	java/io/IOException
    //   40	47	623	java/security/cert/CertificateEncodingException
    //   55	65	623	java/security/cert/CertificateEncodingException
    //   69	81	623	java/security/cert/CertificateEncodingException
    //   87	95	623	java/security/cert/CertificateEncodingException
    //   101	114	623	java/security/cert/CertificateEncodingException
    //   118	127	623	java/security/cert/CertificateEncodingException
    //   140	147	623	java/security/cert/CertificateEncodingException
    //   151	173	623	java/security/cert/CertificateEncodingException
    //   181	216	623	java/security/cert/CertificateEncodingException
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
    //   75: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   78: aload_0
    //   79: areturn
    //   80: astore_1
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_2
    //   84: astore_0
    //   85: ldc 104
    //   87: iconst_1
    //   88: new 106	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   95: ldc 189
    //   97: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_1
    //   101: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   124: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   127: aconst_null
    //   128: areturn
    //   129: astore_1
    //   130: aconst_null
    //   131: astore_2
    //   132: aload_2
    //   133: astore_0
    //   134: ldc 104
    //   136: iconst_1
    //   137: new 106	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   144: ldc 191
    //   146: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_1
    //   150: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   173: invokevirtual 147	java/io/IOException:printStackTrace	()V
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
    //   193: invokevirtual 147	java/io/IOException:printStackTrace	()V
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