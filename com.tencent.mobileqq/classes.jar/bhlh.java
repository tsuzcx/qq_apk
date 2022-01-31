import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class bhlh
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
    //   12: invokestatic 15	bhlh:a	(Ljava/lang/String;)Ljava/security/PublicKey;
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
    //   169: invokestatic 47	bhlg:a	(Ljava/lang/String;)Ljava/util/Map;
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
    //   349: if_icmplt +545 -> 894
    //   352: iload 4
    //   354: sipush 256
    //   357: if_icmple +6 -> 363
    //   360: goto +534 -> 894
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
    //   466: astore 9
    //   468: aconst_null
    //   469: astore_1
    //   470: bipush 40
    //   472: istore_2
    //   473: aload 9
    //   475: astore 8
    //   477: aload 12
    //   479: ldc 108
    //   481: invokevirtual 112	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   484: aload 13
    //   486: aload 11
    //   488: invokestatic 115	bhlh:a	([B[BLjava/security/PublicKey;)Z
    //   491: ifne +10 -> 501
    //   494: sipush 137
    //   497: istore_2
    //   498: goto -260 -> 238
    //   501: bipush 41
    //   503: istore 4
    //   505: aload 9
    //   507: astore 8
    //   509: iload 4
    //   511: istore_2
    //   512: new 69	java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   519: astore 11
    //   521: iconst_0
    //   522: istore_3
    //   523: aload 9
    //   525: astore 8
    //   527: iload 4
    //   529: istore_2
    //   530: iload_3
    //   531: aload 12
    //   533: invokevirtual 118	java/lang/String:length	()I
    //   536: if_icmpge +33 -> 569
    //   539: aload 9
    //   541: astore 8
    //   543: iload 4
    //   545: istore_2
    //   546: aload 11
    //   548: aload 12
    //   550: iload_3
    //   551: invokevirtual 122	java/lang/String:charAt	(I)C
    //   554: iload 5
    //   556: ixor
    //   557: i2c
    //   558: invokevirtual 125	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   561: pop
    //   562: iload_3
    //   563: iconst_1
    //   564: iadd
    //   565: istore_3
    //   566: goto -43 -> 523
    //   569: aload 9
    //   571: astore 8
    //   573: iload 4
    //   575: istore_2
    //   576: aload 11
    //   578: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: ldc 127
    //   583: invokevirtual 131	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   586: astore 11
    //   588: aload 9
    //   590: astore 8
    //   592: iload 4
    //   594: istore_2
    //   595: aload 11
    //   597: arraylength
    //   598: iload 6
    //   600: if_icmpeq +10 -> 610
    //   603: sipush 135
    //   606: istore_2
    //   607: goto -369 -> 238
    //   610: bipush 42
    //   612: istore 5
    //   614: aload 9
    //   616: astore 8
    //   618: iload 5
    //   620: istore_2
    //   621: aload 11
    //   623: arraylength
    //   624: istore 6
    //   626: iconst_0
    //   627: istore_3
    //   628: iload_3
    //   629: iload 6
    //   631: if_icmpge +95 -> 726
    //   634: aload 9
    //   636: astore 8
    //   638: iload 5
    //   640: istore_2
    //   641: aload 11
    //   643: iload_3
    //   644: aaload
    //   645: ldc 133
    //   647: invokevirtual 131	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   650: astore 12
    //   652: aload 9
    //   654: astore 8
    //   656: iload 5
    //   658: istore_2
    //   659: aload 12
    //   661: arraylength
    //   662: iconst_2
    //   663: if_icmpeq +6 -> 669
    //   666: goto +235 -> 901
    //   669: aload 9
    //   671: astore 8
    //   673: iload 5
    //   675: istore_2
    //   676: aload 10
    //   678: aload 12
    //   680: iconst_0
    //   681: aaload
    //   682: aload 12
    //   684: iconst_1
    //   685: aaload
    //   686: invokestatic 136	bhlg:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)I
    //   689: istore 4
    //   691: iload 4
    //   693: ifeq +208 -> 901
    //   696: iconst_0
    //   697: ifeq +11 -> 708
    //   700: new 17	java/lang/NullPointerException
    //   703: dup
    //   704: invokespecial 21	java/lang/NullPointerException:<init>	()V
    //   707: athrow
    //   708: iload 4
    //   710: istore_2
    //   711: aload_0
    //   712: ifnull -662 -> 50
    //   715: aload_0
    //   716: invokevirtual 60	java/util/jar/JarFile:close	()V
    //   719: iload 4
    //   721: ireturn
    //   722: astore_0
    //   723: iload 4
    //   725: ireturn
    //   726: iconst_0
    //   727: istore_2
    //   728: goto -490 -> 238
    //   731: astore_0
    //   732: aload 9
    //   734: astore_1
    //   735: aload_0
    //   736: invokevirtual 139	java/lang/Throwable:printStackTrace	()V
    //   739: aload 8
    //   741: ifnull +8 -> 749
    //   744: aload 8
    //   746: invokevirtual 59	java/io/DataInputStream:close	()V
    //   749: iload_2
    //   750: istore_3
    //   751: aload_1
    //   752: ifnull -494 -> 258
    //   755: aload_1
    //   756: invokevirtual 60	java/util/jar/JarFile:close	()V
    //   759: iload_2
    //   760: istore_3
    //   761: goto -503 -> 258
    //   764: astore_0
    //   765: iload_2
    //   766: istore_3
    //   767: goto -509 -> 258
    //   770: astore_1
    //   771: aconst_null
    //   772: astore 9
    //   774: aconst_null
    //   775: astore_0
    //   776: aload_0
    //   777: ifnull +7 -> 784
    //   780: aload_0
    //   781: invokevirtual 59	java/io/DataInputStream:close	()V
    //   784: aload 9
    //   786: ifnull +8 -> 794
    //   789: aload 9
    //   791: invokevirtual 60	java/util/jar/JarFile:close	()V
    //   794: aload_1
    //   795: athrow
    //   796: astore_0
    //   797: goto -3 -> 794
    //   800: astore_1
    //   801: aconst_null
    //   802: astore 8
    //   804: aload_0
    //   805: astore 9
    //   807: aload 8
    //   809: astore_0
    //   810: goto -34 -> 776
    //   813: astore_1
    //   814: aload_0
    //   815: astore 9
    //   817: aload 8
    //   819: astore_0
    //   820: goto -44 -> 776
    //   823: astore 10
    //   825: aload_1
    //   826: astore 9
    //   828: aload 8
    //   830: astore_0
    //   831: aload 10
    //   833: astore_1
    //   834: goto -58 -> 776
    //   837: astore_0
    //   838: bipush 34
    //   840: istore_2
    //   841: aload 9
    //   843: astore_1
    //   844: goto -109 -> 735
    //   847: astore 9
    //   849: aload_0
    //   850: astore_1
    //   851: aload 9
    //   853: astore_0
    //   854: goto -119 -> 735
    //   857: astore 9
    //   859: aload_1
    //   860: astore 8
    //   862: aload_0
    //   863: astore_1
    //   864: aload 9
    //   866: astore_0
    //   867: goto -132 -> 735
    //   870: astore 9
    //   872: aconst_null
    //   873: astore 8
    //   875: aload_0
    //   876: astore_1
    //   877: aload 9
    //   879: astore_0
    //   880: goto -145 -> 735
    //   883: astore_0
    //   884: iload_2
    //   885: istore_3
    //   886: goto -628 -> 258
    //   889: astore_0
    //   890: sipush 129
    //   893: ireturn
    //   894: sipush 133
    //   897: istore_2
    //   898: goto -660 -> 238
    //   901: iload_3
    //   902: iconst_1
    //   903: iadd
    //   904: istore_3
    //   905: goto -277 -> 628
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	908	0	paramString1	String
    //   0	908	1	paramString2	String
    //   9	889	2	i	int
    //   7	898	3	j	int
    //   342	382	4	k	int
    //   393	281	5	m	int
    //   404	228	6	n	int
    //   67	65	7	bool	boolean
    //   1	873	8	localObject1	Object
    //   4	838	9	str	String
    //   847	5	9	localThrowable1	java.lang.Throwable
    //   857	8	9	localThrowable2	java.lang.Throwable
    //   870	8	9	localThrowable3	java.lang.Throwable
    //   115	562	10	localObject2	Object
    //   823	9	10	localObject3	Object
    //   15	627	11	localObject4	Object
    //   428	255	12	localObject5	Object
    //   442	43	13	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   81	89	101	java/io/IOException
    //   93	101	101	java/io/IOException
    //   142	150	162	java/io/IOException
    //   154	162	162	java/io/IOException
    //   187	195	207	java/io/IOException
    //   199	207	207	java/io/IOException
    //   700	708	722	java/io/IOException
    //   715	719	722	java/io/IOException
    //   10	17	731	java/lang/Throwable
    //   58	69	731	java/lang/Throwable
    //   107	117	731	java/lang/Throwable
    //   124	131	731	java/lang/Throwable
    //   168	174	731	java/lang/Throwable
    //   744	749	764	java/io/IOException
    //   755	759	764	java/io/IOException
    //   10	17	770	finally
    //   58	69	770	finally
    //   107	117	770	finally
    //   124	131	770	finally
    //   168	174	770	finally
    //   215	224	770	finally
    //   780	784	796	java/io/IOException
    //   789	794	796	java/io/IOException
    //   224	230	800	finally
    //   296	309	800	finally
    //   317	326	813	finally
    //   338	344	813	finally
    //   368	377	813	finally
    //   389	395	813	finally
    //   400	406	813	finally
    //   424	430	813	finally
    //   438	444	813	finally
    //   449	456	813	finally
    //   461	465	813	finally
    //   477	494	813	finally
    //   512	521	813	finally
    //   530	539	813	finally
    //   546	562	813	finally
    //   576	588	813	finally
    //   595	603	813	finally
    //   621	626	813	finally
    //   641	652	813	finally
    //   659	666	813	finally
    //   676	691	813	finally
    //   735	739	823	finally
    //   215	224	837	java/lang/Throwable
    //   224	230	847	java/lang/Throwable
    //   296	309	847	java/lang/Throwable
    //   317	326	857	java/lang/Throwable
    //   338	344	857	java/lang/Throwable
    //   368	377	857	java/lang/Throwable
    //   389	395	857	java/lang/Throwable
    //   400	406	857	java/lang/Throwable
    //   424	430	857	java/lang/Throwable
    //   438	444	857	java/lang/Throwable
    //   449	456	857	java/lang/Throwable
    //   461	465	857	java/lang/Throwable
    //   477	494	870	java/lang/Throwable
    //   512	521	870	java/lang/Throwable
    //   530	539	870	java/lang/Throwable
    //   546	562	870	java/lang/Throwable
    //   576	588	870	java/lang/Throwable
    //   595	603	870	java/lang/Throwable
    //   621	626	870	java/lang/Throwable
    //   641	652	870	java/lang/Throwable
    //   659	666	870	java/lang/Throwable
    //   676	691	870	java/lang/Throwable
    //   242	246	883	java/io/IOException
    //   252	256	883	java/io/IOException
    //   30	38	889	java/io/IOException
    //   42	50	889	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhlh
 * JD-Core Version:    0.7.0.1
 */