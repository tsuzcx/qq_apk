import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class bfjw
{
  /* Error */
  public static int a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: iconst_1
    //   7: istore_3
    //   8: iload_3
    //   9: istore_2
    //   10: ldc 12
    //   12: invokestatic 15	bfjw:a	(Ljava/lang/String;)Ljava/security/PublicKey;
    //   15: astore 11
    //   17: aload 11
    //   19: ifnonnull +33 -> 52
    //   22: sipush 129
    //   25: istore_2
    //   26: iconst_0
    //   27: ifeq +11 -> 38
    //   30: new 17	java/lang/NullPointerException
    //   33: dup
    //   34: invokespecial 21	java/lang/NullPointerException:<init>	()V
    //   37: athrow
    //   38: iconst_0
    //   39: ifeq +11 -> 50
    //   42: new 17	java/lang/NullPointerException
    //   45: dup
    //   46: invokespecial 21	java/lang/NullPointerException:<init>	()V
    //   49: athrow
    //   50: iload_2
    //   51: ireturn
    //   52: aload_0
    //   53: ifnull +21 -> 74
    //   56: iload_3
    //   57: istore_2
    //   58: ldc 23
    //   60: aload_0
    //   61: invokevirtual 29	java/lang/String:trim	()Ljava/lang/String;
    //   64: invokevirtual 33	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: istore 7
    //   69: iload 7
    //   71: ifeq +34 -> 105
    //   74: bipush 17
    //   76: istore_2
    //   77: iconst_0
    //   78: ifeq +11 -> 89
    //   81: new 17	java/lang/NullPointerException
    //   84: dup
    //   85: invokespecial 21	java/lang/NullPointerException:<init>	()V
    //   88: athrow
    //   89: iconst_0
    //   90: ifeq -40 -> 50
    //   93: new 17	java/lang/NullPointerException
    //   96: dup
    //   97: invokespecial 21	java/lang/NullPointerException:<init>	()V
    //   100: athrow
    //   101: astore_0
    //   102: bipush 17
    //   104: ireturn
    //   105: iload_3
    //   106: istore_2
    //   107: new 35	java/io/File
    //   110: dup
    //   111: aload_0
    //   112: invokespecial 38	java/io/File:<init>	(Ljava/lang/String;)V
    //   115: astore 10
    //   117: aload 10
    //   119: ifnull +17 -> 136
    //   122: iload_3
    //   123: istore_2
    //   124: aload 10
    //   126: invokevirtual 42	java/io/File:exists	()Z
    //   129: istore 7
    //   131: iload 7
    //   133: ifne +32 -> 165
    //   136: iconst_3
    //   137: istore_2
    //   138: iconst_0
    //   139: ifeq +11 -> 150
    //   142: new 17	java/lang/NullPointerException
    //   145: dup
    //   146: invokespecial 21	java/lang/NullPointerException:<init>	()V
    //   149: athrow
    //   150: iconst_0
    //   151: ifeq -101 -> 50
    //   154: new 17	java/lang/NullPointerException
    //   157: dup
    //   158: invokespecial 21	java/lang/NullPointerException:<init>	()V
    //   161: athrow
    //   162: astore_0
    //   163: iconst_3
    //   164: ireturn
    //   165: bipush 33
    //   167: istore_2
    //   168: aload_0
    //   169: invokestatic 47	bfjv:a	(Ljava/lang/String;)Ljava/util/Map;
    //   172: astore 10
    //   174: aload 10
    //   176: ifnonnull +36 -> 212
    //   179: sipush 142
    //   182: istore_2
    //   183: iconst_0
    //   184: ifeq +11 -> 195
    //   187: new 17	java/lang/NullPointerException
    //   190: dup
    //   191: invokespecial 21	java/lang/NullPointerException:<init>	()V
    //   194: athrow
    //   195: iconst_0
    //   196: ifeq -146 -> 50
    //   199: new 17	java/lang/NullPointerException
    //   202: dup
    //   203: invokespecial 21	java/lang/NullPointerException:<init>	()V
    //   206: athrow
    //   207: astore_0
    //   208: sipush 142
    //   211: ireturn
    //   212: bipush 34
    //   214: istore_2
    //   215: new 49	java/util/jar/JarFile
    //   218: dup
    //   219: aload_0
    //   220: invokespecial 50	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   223: astore_0
    //   224: aload_0
    //   225: aload_1
    //   226: invokevirtual 54	java/util/jar/JarFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   229: astore_1
    //   230: aload_1
    //   231: ifnonnull +62 -> 293
    //   234: iconst_5
    //   235: istore_2
    //   236: aconst_null
    //   237: astore_1
    //   238: aload_1
    //   239: ifnull +7 -> 246
    //   242: aload_1
    //   243: invokevirtual 59	java/io/DataInputStream:close	()V
    //   246: iload_2
    //   247: istore_3
    //   248: aload_0
    //   249: ifnull +9 -> 258
    //   252: aload_0
    //   253: invokevirtual 60	java/util/jar/JarFile:close	()V
    //   256: iload_2
    //   257: istore_3
    //   258: iload_3
    //   259: istore_2
    //   260: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq -213 -> 50
    //   266: ldc 67
    //   268: iconst_2
    //   269: new 69	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   276: ldc 72
    //   278: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: iload_3
    //   282: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   285: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: iload_3
    //   292: ireturn
    //   293: bipush 36
    //   295: istore_2
    //   296: new 56	java/io/DataInputStream
    //   299: dup
    //   300: aload_0
    //   301: aload_1
    //   302: invokevirtual 90	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   305: invokespecial 93	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   308: astore_1
    //   309: bipush 37
    //   311: istore_3
    //   312: aload_1
    //   313: astore 8
    //   315: iload_3
    //   316: istore_2
    //   317: aload_1
    //   318: invokevirtual 97	java/io/DataInputStream:readInt	()I
    //   321: ldc 98
    //   323: if_icmpeq +10 -> 333
    //   326: sipush 132
    //   329: istore_2
    //   330: goto -92 -> 238
    //   333: aload_1
    //   334: astore 8
    //   336: iload_3
    //   337: istore_2
    //   338: aload_1
    //   339: invokevirtual 97	java/io/DataInputStream:readInt	()I
    //   342: istore 4
    //   344: iload 4
    //   346: sipush 128
    //   349: if_icmplt +544 -> 893
    //   352: iload 4
    //   354: sipush 256
    //   357: if_icmple +6 -> 363
    //   360: goto +533 -> 893
    //   363: aload_1
    //   364: astore 8
    //   366: iload_3
    //   367: istore_2
    //   368: aload_1
    //   369: invokevirtual 97	java/io/DataInputStream:readInt	()I
    //   372: ldc 99
    //   374: if_icmpeq +10 -> 384
    //   377: sipush 134
    //   380: istore_2
    //   381: goto -143 -> 238
    //   384: aload_1
    //   385: astore 8
    //   387: iload_3
    //   388: istore_2
    //   389: aload_1
    //   390: invokevirtual 97	java/io/DataInputStream:readInt	()I
    //   393: istore 5
    //   395: aload_1
    //   396: astore 8
    //   398: iload_3
    //   399: istore_2
    //   400: aload_1
    //   401: invokevirtual 97	java/io/DataInputStream:readInt	()I
    //   404: istore 6
    //   406: iload 6
    //   408: ifgt +10 -> 418
    //   411: sipush 135
    //   414: istore_2
    //   415: goto -177 -> 238
    //   418: bipush 38
    //   420: istore_2
    //   421: aload_1
    //   422: astore 8
    //   424: aload_1
    //   425: invokevirtual 102	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   428: astore 12
    //   430: bipush 39
    //   432: istore_3
    //   433: aload_1
    //   434: astore 8
    //   436: iload_3
    //   437: istore_2
    //   438: iload 4
    //   440: newarray byte
    //   442: astore 13
    //   444: aload_1
    //   445: astore 8
    //   447: iload_3
    //   448: istore_2
    //   449: aload_1
    //   450: aload 13
    //   452: invokevirtual 106	java/io/DataInputStream:read	([B)I
    //   455: pop
    //   456: aload_1
    //   457: astore 8
    //   459: iload_3
    //   460: istore_2
    //   461: aload_1
    //   462: invokevirtual 59	java/io/DataInputStream:close	()V
    //   465: aconst_null
    //   466: astore_1
    //   467: aconst_null
    //   468: astore 9
    //   470: bipush 40
    //   472: istore_2
    //   473: aload_1
    //   474: astore 8
    //   476: aload 12
    //   478: ldc 108
    //   480: invokevirtual 112	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   483: aload 13
    //   485: aload 11
    //   487: invokestatic 115	bfjw:a	([B[BLjava/security/PublicKey;)Z
    //   490: ifne +13 -> 503
    //   493: sipush 137
    //   496: istore_2
    //   497: aload 9
    //   499: astore_1
    //   500: goto -262 -> 238
    //   503: bipush 41
    //   505: istore 4
    //   507: aload_1
    //   508: astore 8
    //   510: iload 4
    //   512: istore_2
    //   513: new 69	java/lang/StringBuilder
    //   516: dup
    //   517: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   520: astore 11
    //   522: iconst_0
    //   523: istore_3
    //   524: aload_1
    //   525: astore 8
    //   527: iload 4
    //   529: istore_2
    //   530: iload_3
    //   531: aload 12
    //   533: invokevirtual 118	java/lang/String:length	()I
    //   536: if_icmpge +32 -> 568
    //   539: aload_1
    //   540: astore 8
    //   542: iload 4
    //   544: istore_2
    //   545: aload 11
    //   547: aload 12
    //   549: iload_3
    //   550: invokevirtual 122	java/lang/String:charAt	(I)C
    //   553: iload 5
    //   555: ixor
    //   556: i2c
    //   557: invokevirtual 125	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: iload_3
    //   562: iconst_1
    //   563: iadd
    //   564: istore_3
    //   565: goto -41 -> 524
    //   568: aload_1
    //   569: astore 8
    //   571: iload 4
    //   573: istore_2
    //   574: aload 11
    //   576: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: ldc 127
    //   581: invokevirtual 131	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   584: astore 12
    //   586: aload_1
    //   587: astore 8
    //   589: iload 4
    //   591: istore_2
    //   592: aload 12
    //   594: arraylength
    //   595: iload 6
    //   597: if_icmpeq +13 -> 610
    //   600: sipush 135
    //   603: istore_2
    //   604: aload 9
    //   606: astore_1
    //   607: goto -369 -> 238
    //   610: bipush 42
    //   612: istore 5
    //   614: aload_1
    //   615: astore 8
    //   617: iload 5
    //   619: istore_2
    //   620: aload 12
    //   622: arraylength
    //   623: istore 6
    //   625: iconst_0
    //   626: istore_3
    //   627: iload_3
    //   628: iload 6
    //   630: if_icmpge +92 -> 722
    //   633: aload_1
    //   634: astore 8
    //   636: iload 5
    //   638: istore_2
    //   639: aload 12
    //   641: iload_3
    //   642: aaload
    //   643: ldc 133
    //   645: invokevirtual 131	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   648: astore 11
    //   650: aload_1
    //   651: astore 8
    //   653: iload 5
    //   655: istore_2
    //   656: aload 11
    //   658: arraylength
    //   659: iconst_2
    //   660: if_icmpeq +6 -> 666
    //   663: goto +237 -> 900
    //   666: aload_1
    //   667: astore 8
    //   669: iload 5
    //   671: istore_2
    //   672: aload 10
    //   674: aload 11
    //   676: iconst_0
    //   677: aaload
    //   678: aload 11
    //   680: iconst_1
    //   681: aaload
    //   682: invokestatic 136	bfjv:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)I
    //   685: istore 4
    //   687: iload 4
    //   689: ifeq +211 -> 900
    //   692: iconst_0
    //   693: ifeq +11 -> 704
    //   696: new 17	java/lang/NullPointerException
    //   699: dup
    //   700: invokespecial 21	java/lang/NullPointerException:<init>	()V
    //   703: athrow
    //   704: iload 4
    //   706: istore_2
    //   707: aload_0
    //   708: ifnull -658 -> 50
    //   711: aload_0
    //   712: invokevirtual 60	java/util/jar/JarFile:close	()V
    //   715: iload 4
    //   717: ireturn
    //   718: astore_0
    //   719: iload 4
    //   721: ireturn
    //   722: iconst_0
    //   723: istore_2
    //   724: aload 9
    //   726: astore_1
    //   727: goto -489 -> 238
    //   730: astore_0
    //   731: aload 9
    //   733: astore_1
    //   734: aload_0
    //   735: invokevirtual 139	java/lang/Throwable:printStackTrace	()V
    //   738: aload 8
    //   740: ifnull +8 -> 748
    //   743: aload 8
    //   745: invokevirtual 59	java/io/DataInputStream:close	()V
    //   748: iload_2
    //   749: istore_3
    //   750: aload_1
    //   751: ifnull -493 -> 258
    //   754: aload_1
    //   755: invokevirtual 60	java/util/jar/JarFile:close	()V
    //   758: iload_2
    //   759: istore_3
    //   760: goto -502 -> 258
    //   763: astore_0
    //   764: iload_2
    //   765: istore_3
    //   766: goto -508 -> 258
    //   769: astore_1
    //   770: aconst_null
    //   771: astore 9
    //   773: aconst_null
    //   774: astore_0
    //   775: aload_0
    //   776: ifnull +7 -> 783
    //   779: aload_0
    //   780: invokevirtual 59	java/io/DataInputStream:close	()V
    //   783: aload 9
    //   785: ifnull +8 -> 793
    //   788: aload 9
    //   790: invokevirtual 60	java/util/jar/JarFile:close	()V
    //   793: aload_1
    //   794: athrow
    //   795: astore_0
    //   796: goto -3 -> 793
    //   799: astore_1
    //   800: aconst_null
    //   801: astore 8
    //   803: aload_0
    //   804: astore 9
    //   806: aload 8
    //   808: astore_0
    //   809: goto -34 -> 775
    //   812: astore_1
    //   813: aload_0
    //   814: astore 9
    //   816: aload 8
    //   818: astore_0
    //   819: goto -44 -> 775
    //   822: astore 10
    //   824: aload_1
    //   825: astore 9
    //   827: aload 8
    //   829: astore_0
    //   830: aload 10
    //   832: astore_1
    //   833: goto -58 -> 775
    //   836: astore_0
    //   837: bipush 34
    //   839: istore_2
    //   840: aload 9
    //   842: astore_1
    //   843: goto -109 -> 734
    //   846: astore 9
    //   848: aload_0
    //   849: astore_1
    //   850: aload 9
    //   852: astore_0
    //   853: goto -119 -> 734
    //   856: astore 9
    //   858: aload_1
    //   859: astore 8
    //   861: aload_0
    //   862: astore_1
    //   863: aload 9
    //   865: astore_0
    //   866: goto -132 -> 734
    //   869: astore 9
    //   871: aconst_null
    //   872: astore 8
    //   874: aload_0
    //   875: astore_1
    //   876: aload 9
    //   878: astore_0
    //   879: goto -145 -> 734
    //   882: astore_0
    //   883: iload_2
    //   884: istore_3
    //   885: goto -627 -> 258
    //   888: astore_0
    //   889: sipush 129
    //   892: ireturn
    //   893: sipush 133
    //   896: istore_2
    //   897: goto -659 -> 238
    //   900: iload_3
    //   901: iconst_1
    //   902: iadd
    //   903: istore_3
    //   904: goto -277 -> 627
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	907	0	paramString1	String
    //   0	907	1	paramString2	String
    //   9	888	2	i	int
    //   7	897	3	j	int
    //   342	378	4	k	int
    //   393	277	5	m	int
    //   404	227	6	n	int
    //   67	65	7	bool	boolean
    //   1	872	8	str1	String
    //   4	837	9	str2	String
    //   846	5	9	localThrowable1	java.lang.Throwable
    //   856	8	9	localThrowable2	java.lang.Throwable
    //   869	8	9	localThrowable3	java.lang.Throwable
    //   115	558	10	localObject1	Object
    //   822	9	10	localObject2	Object
    //   15	664	11	localObject3	Object
    //   428	212	12	localObject4	Object
    //   442	42	13	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   81	89	101	java/io/IOException
    //   93	101	101	java/io/IOException
    //   142	150	162	java/io/IOException
    //   154	162	162	java/io/IOException
    //   187	195	207	java/io/IOException
    //   199	207	207	java/io/IOException
    //   696	704	718	java/io/IOException
    //   711	715	718	java/io/IOException
    //   10	17	730	java/lang/Throwable
    //   58	69	730	java/lang/Throwable
    //   107	117	730	java/lang/Throwable
    //   124	131	730	java/lang/Throwable
    //   168	174	730	java/lang/Throwable
    //   743	748	763	java/io/IOException
    //   754	758	763	java/io/IOException
    //   10	17	769	finally
    //   58	69	769	finally
    //   107	117	769	finally
    //   124	131	769	finally
    //   168	174	769	finally
    //   215	224	769	finally
    //   779	783	795	java/io/IOException
    //   788	793	795	java/io/IOException
    //   224	230	799	finally
    //   296	309	799	finally
    //   317	326	812	finally
    //   338	344	812	finally
    //   368	377	812	finally
    //   389	395	812	finally
    //   400	406	812	finally
    //   424	430	812	finally
    //   438	444	812	finally
    //   449	456	812	finally
    //   461	465	812	finally
    //   476	493	812	finally
    //   513	522	812	finally
    //   530	539	812	finally
    //   545	561	812	finally
    //   574	586	812	finally
    //   592	600	812	finally
    //   620	625	812	finally
    //   639	650	812	finally
    //   656	663	812	finally
    //   672	687	812	finally
    //   734	738	822	finally
    //   215	224	836	java/lang/Throwable
    //   224	230	846	java/lang/Throwable
    //   296	309	846	java/lang/Throwable
    //   317	326	856	java/lang/Throwable
    //   338	344	856	java/lang/Throwable
    //   368	377	856	java/lang/Throwable
    //   389	395	856	java/lang/Throwable
    //   400	406	856	java/lang/Throwable
    //   424	430	856	java/lang/Throwable
    //   438	444	856	java/lang/Throwable
    //   449	456	856	java/lang/Throwable
    //   461	465	856	java/lang/Throwable
    //   476	493	869	java/lang/Throwable
    //   513	522	869	java/lang/Throwable
    //   530	539	869	java/lang/Throwable
    //   545	561	869	java/lang/Throwable
    //   574	586	869	java/lang/Throwable
    //   592	600	869	java/lang/Throwable
    //   620	625	869	java/lang/Throwable
    //   639	650	869	java/lang/Throwable
    //   656	663	869	java/lang/Throwable
    //   672	687	869	java/lang/Throwable
    //   242	246	882	java/io/IOException
    //   252	256	882	java/io/IOException
    //   30	38	888	java/io/IOException
    //   42	50	888	java/io/IOException
  }
  
  private static PublicKey a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCOEXXbretliROuhm/THXQOZ33e1bIvgPNnGFqrmALpZFXZ51u1CWJMBNXBX0us9jBHUlWSn5Pmz+kPLe7VHh1PrmzrSTxBH6dJq3iRclhyDFTc6txsOm92p/yaSwOaK/OP50YzAYcBT3lhjhQ5mvTUSzFN3gZLfr89sjuix+40dwIDAQAB";
    }
    paramString = new X509EncodedKeySpec(Base64.decode(str, 0));
    try
    {
      paramString = KeyFactory.getInstance("RSA").generatePublic(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PublicKey paramPublicKey)
  {
    try
    {
      Signature localSignature = Signature.getInstance("MD5withRSA");
      localSignature.initVerify(paramPublicKey);
      localSignature.update(paramArrayOfByte1);
      boolean bool = localSignature.verify(paramArrayOfByte2);
      return bool;
    }
    catch (Exception paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bfjw
 * JD-Core Version:    0.7.0.1
 */