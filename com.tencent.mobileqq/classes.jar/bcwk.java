import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class bcwk
{
  private static String a = "";
  private static String b = bcwi.a(bcwi.v);
  
  static
  {
    a = bcwi.a(bcwi.u);
    b = "TXVA";
  }
  
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
    //   10: getstatic 13	bcwk:a	Ljava/lang/String;
    //   13: invokestatic 38	bcwk:a	(Ljava/lang/String;)Ljava/security/PublicKey;
    //   16: astore 11
    //   18: aload 11
    //   20: ifnonnull +33 -> 53
    //   23: sipush 129
    //   26: istore_2
    //   27: iconst_0
    //   28: ifeq +11 -> 39
    //   31: new 40	java/lang/NullPointerException
    //   34: dup
    //   35: invokespecial 43	java/lang/NullPointerException:<init>	()V
    //   38: athrow
    //   39: iconst_0
    //   40: ifeq +11 -> 51
    //   43: new 40	java/lang/NullPointerException
    //   46: dup
    //   47: invokespecial 43	java/lang/NullPointerException:<init>	()V
    //   50: athrow
    //   51: iload_2
    //   52: ireturn
    //   53: aload_0
    //   54: ifnull +21 -> 75
    //   57: iload_3
    //   58: istore_2
    //   59: ldc 11
    //   61: aload_0
    //   62: invokevirtual 49	java/lang/String:trim	()Ljava/lang/String;
    //   65: invokevirtual 53	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   68: istore 7
    //   70: iload 7
    //   72: ifeq +34 -> 106
    //   75: bipush 17
    //   77: istore_2
    //   78: iconst_0
    //   79: ifeq +11 -> 90
    //   82: new 40	java/lang/NullPointerException
    //   85: dup
    //   86: invokespecial 43	java/lang/NullPointerException:<init>	()V
    //   89: athrow
    //   90: iconst_0
    //   91: ifeq -40 -> 51
    //   94: new 40	java/lang/NullPointerException
    //   97: dup
    //   98: invokespecial 43	java/lang/NullPointerException:<init>	()V
    //   101: athrow
    //   102: astore_0
    //   103: bipush 17
    //   105: ireturn
    //   106: iload_3
    //   107: istore_2
    //   108: new 55	java/io/File
    //   111: dup
    //   112: aload_0
    //   113: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   116: astore 10
    //   118: aload 10
    //   120: ifnull +17 -> 137
    //   123: iload_3
    //   124: istore_2
    //   125: aload 10
    //   127: invokevirtual 62	java/io/File:exists	()Z
    //   130: istore 7
    //   132: iload 7
    //   134: ifne +32 -> 166
    //   137: iconst_3
    //   138: istore_2
    //   139: iconst_0
    //   140: ifeq +11 -> 151
    //   143: new 40	java/lang/NullPointerException
    //   146: dup
    //   147: invokespecial 43	java/lang/NullPointerException:<init>	()V
    //   150: athrow
    //   151: iconst_0
    //   152: ifeq -101 -> 51
    //   155: new 40	java/lang/NullPointerException
    //   158: dup
    //   159: invokespecial 43	java/lang/NullPointerException:<init>	()V
    //   162: athrow
    //   163: astore_0
    //   164: iconst_3
    //   165: ireturn
    //   166: bipush 33
    //   168: istore_2
    //   169: aload_0
    //   170: invokestatic 67	bcwj:a	(Ljava/lang/String;)Ljava/util/Map;
    //   173: astore 10
    //   175: aload 10
    //   177: ifnonnull +36 -> 213
    //   180: sipush 142
    //   183: istore_2
    //   184: iconst_0
    //   185: ifeq +11 -> 196
    //   188: new 40	java/lang/NullPointerException
    //   191: dup
    //   192: invokespecial 43	java/lang/NullPointerException:<init>	()V
    //   195: athrow
    //   196: iconst_0
    //   197: ifeq -146 -> 51
    //   200: new 40	java/lang/NullPointerException
    //   203: dup
    //   204: invokespecial 43	java/lang/NullPointerException:<init>	()V
    //   207: athrow
    //   208: astore_0
    //   209: sipush 142
    //   212: ireturn
    //   213: bipush 34
    //   215: istore_2
    //   216: new 69	java/util/jar/JarFile
    //   219: dup
    //   220: aload_0
    //   221: invokespecial 70	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   224: astore_0
    //   225: aload_0
    //   226: aload_1
    //   227: invokevirtual 74	java/util/jar/JarFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   230: astore_1
    //   231: aload_1
    //   232: ifnonnull +63 -> 295
    //   235: iconst_5
    //   236: istore_2
    //   237: aconst_null
    //   238: astore_1
    //   239: aload_1
    //   240: ifnull +7 -> 247
    //   243: aload_1
    //   244: invokevirtual 79	java/io/DataInputStream:close	()V
    //   247: iload_2
    //   248: istore_3
    //   249: aload_0
    //   250: ifnull +9 -> 259
    //   253: aload_0
    //   254: invokevirtual 80	java/util/jar/JarFile:close	()V
    //   257: iload_2
    //   258: istore_3
    //   259: iload_3
    //   260: istore_2
    //   261: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq -213 -> 51
    //   267: getstatic 26	bcwk:b	Ljava/lang/String;
    //   270: iconst_2
    //   271: new 87	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   278: ldc 90
    //   280: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: iload_3
    //   284: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   287: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: iload_3
    //   294: ireturn
    //   295: bipush 36
    //   297: istore_2
    //   298: new 76	java/io/DataInputStream
    //   301: dup
    //   302: aload_0
    //   303: aload_1
    //   304: invokevirtual 108	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   307: invokespecial 111	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   310: astore_1
    //   311: bipush 37
    //   313: istore_3
    //   314: aload_1
    //   315: astore 8
    //   317: iload_3
    //   318: istore_2
    //   319: aload_1
    //   320: invokevirtual 115	java/io/DataInputStream:readInt	()I
    //   323: ldc 116
    //   325: if_icmpeq +10 -> 335
    //   328: sipush 132
    //   331: istore_2
    //   332: goto -93 -> 239
    //   335: aload_1
    //   336: astore 8
    //   338: iload_3
    //   339: istore_2
    //   340: aload_1
    //   341: invokevirtual 115	java/io/DataInputStream:readInt	()I
    //   344: istore 4
    //   346: iload 4
    //   348: sipush 128
    //   351: if_icmplt +544 -> 895
    //   354: iload 4
    //   356: sipush 256
    //   359: if_icmple +6 -> 365
    //   362: goto +533 -> 895
    //   365: aload_1
    //   366: astore 8
    //   368: iload_3
    //   369: istore_2
    //   370: aload_1
    //   371: invokevirtual 115	java/io/DataInputStream:readInt	()I
    //   374: ldc 117
    //   376: if_icmpeq +10 -> 386
    //   379: sipush 134
    //   382: istore_2
    //   383: goto -144 -> 239
    //   386: aload_1
    //   387: astore 8
    //   389: iload_3
    //   390: istore_2
    //   391: aload_1
    //   392: invokevirtual 115	java/io/DataInputStream:readInt	()I
    //   395: istore 5
    //   397: aload_1
    //   398: astore 8
    //   400: iload_3
    //   401: istore_2
    //   402: aload_1
    //   403: invokevirtual 115	java/io/DataInputStream:readInt	()I
    //   406: istore 6
    //   408: iload 6
    //   410: ifgt +10 -> 420
    //   413: sipush 135
    //   416: istore_2
    //   417: goto -178 -> 239
    //   420: bipush 38
    //   422: istore_2
    //   423: aload_1
    //   424: astore 8
    //   426: aload_1
    //   427: invokevirtual 120	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   430: astore 12
    //   432: bipush 39
    //   434: istore_3
    //   435: aload_1
    //   436: astore 8
    //   438: iload_3
    //   439: istore_2
    //   440: iload 4
    //   442: newarray byte
    //   444: astore 13
    //   446: aload_1
    //   447: astore 8
    //   449: iload_3
    //   450: istore_2
    //   451: aload_1
    //   452: aload 13
    //   454: invokevirtual 124	java/io/DataInputStream:read	([B)I
    //   457: pop
    //   458: aload_1
    //   459: astore 8
    //   461: iload_3
    //   462: istore_2
    //   463: aload_1
    //   464: invokevirtual 79	java/io/DataInputStream:close	()V
    //   467: aconst_null
    //   468: astore_1
    //   469: aconst_null
    //   470: astore 9
    //   472: bipush 40
    //   474: istore_2
    //   475: aload_1
    //   476: astore 8
    //   478: aload 12
    //   480: ldc 126
    //   482: invokevirtual 130	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   485: aload 13
    //   487: aload 11
    //   489: invokestatic 133	bcwk:a	([B[BLjava/security/PublicKey;)Z
    //   492: ifne +13 -> 505
    //   495: sipush 137
    //   498: istore_2
    //   499: aload 9
    //   501: astore_1
    //   502: goto -263 -> 239
    //   505: bipush 41
    //   507: istore 4
    //   509: aload_1
    //   510: astore 8
    //   512: iload 4
    //   514: istore_2
    //   515: new 87	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   522: astore 11
    //   524: iconst_0
    //   525: istore_3
    //   526: aload_1
    //   527: astore 8
    //   529: iload 4
    //   531: istore_2
    //   532: iload_3
    //   533: aload 12
    //   535: invokevirtual 136	java/lang/String:length	()I
    //   538: if_icmpge +32 -> 570
    //   541: aload_1
    //   542: astore 8
    //   544: iload 4
    //   546: istore_2
    //   547: aload 11
    //   549: aload 12
    //   551: iload_3
    //   552: invokevirtual 140	java/lang/String:charAt	(I)C
    //   555: iload 5
    //   557: ixor
    //   558: i2c
    //   559: invokevirtual 143	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: iload_3
    //   564: iconst_1
    //   565: iadd
    //   566: istore_3
    //   567: goto -41 -> 526
    //   570: aload_1
    //   571: astore 8
    //   573: iload 4
    //   575: istore_2
    //   576: aload 11
    //   578: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: ldc 145
    //   583: invokevirtual 149	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   586: astore 11
    //   588: aload_1
    //   589: astore 8
    //   591: iload 4
    //   593: istore_2
    //   594: aload 11
    //   596: arraylength
    //   597: iload 6
    //   599: if_icmpeq +13 -> 612
    //   602: sipush 135
    //   605: istore_2
    //   606: aload 9
    //   608: astore_1
    //   609: goto -370 -> 239
    //   612: bipush 42
    //   614: istore 5
    //   616: aload_1
    //   617: astore 8
    //   619: iload 5
    //   621: istore_2
    //   622: aload 11
    //   624: arraylength
    //   625: istore 6
    //   627: iconst_0
    //   628: istore_3
    //   629: iload_3
    //   630: iload 6
    //   632: if_icmpge +92 -> 724
    //   635: aload_1
    //   636: astore 8
    //   638: iload 5
    //   640: istore_2
    //   641: aload 11
    //   643: iload_3
    //   644: aaload
    //   645: ldc 151
    //   647: invokevirtual 149	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   650: astore 12
    //   652: aload_1
    //   653: astore 8
    //   655: iload 5
    //   657: istore_2
    //   658: aload 12
    //   660: arraylength
    //   661: iconst_2
    //   662: if_icmpeq +6 -> 668
    //   665: goto +237 -> 902
    //   668: aload_1
    //   669: astore 8
    //   671: iload 5
    //   673: istore_2
    //   674: aload 10
    //   676: aload 12
    //   678: iconst_0
    //   679: aaload
    //   680: aload 12
    //   682: iconst_1
    //   683: aaload
    //   684: invokestatic 154	bcwj:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)I
    //   687: istore 4
    //   689: iload 4
    //   691: ifeq +211 -> 902
    //   694: iconst_0
    //   695: ifeq +11 -> 706
    //   698: new 40	java/lang/NullPointerException
    //   701: dup
    //   702: invokespecial 43	java/lang/NullPointerException:<init>	()V
    //   705: athrow
    //   706: iload 4
    //   708: istore_2
    //   709: aload_0
    //   710: ifnull -659 -> 51
    //   713: aload_0
    //   714: invokevirtual 80	java/util/jar/JarFile:close	()V
    //   717: iload 4
    //   719: ireturn
    //   720: astore_0
    //   721: iload 4
    //   723: ireturn
    //   724: iconst_0
    //   725: istore_2
    //   726: aload 9
    //   728: astore_1
    //   729: goto -490 -> 239
    //   732: astore_0
    //   733: aload 9
    //   735: astore_1
    //   736: aload_0
    //   737: invokevirtual 157	java/lang/Throwable:printStackTrace	()V
    //   740: aload 8
    //   742: ifnull +8 -> 750
    //   745: aload 8
    //   747: invokevirtual 79	java/io/DataInputStream:close	()V
    //   750: iload_2
    //   751: istore_3
    //   752: aload_1
    //   753: ifnull -494 -> 259
    //   756: aload_1
    //   757: invokevirtual 80	java/util/jar/JarFile:close	()V
    //   760: iload_2
    //   761: istore_3
    //   762: goto -503 -> 259
    //   765: astore_0
    //   766: iload_2
    //   767: istore_3
    //   768: goto -509 -> 259
    //   771: astore_1
    //   772: aconst_null
    //   773: astore 9
    //   775: aconst_null
    //   776: astore_0
    //   777: aload_0
    //   778: ifnull +7 -> 785
    //   781: aload_0
    //   782: invokevirtual 79	java/io/DataInputStream:close	()V
    //   785: aload 9
    //   787: ifnull +8 -> 795
    //   790: aload 9
    //   792: invokevirtual 80	java/util/jar/JarFile:close	()V
    //   795: aload_1
    //   796: athrow
    //   797: astore_0
    //   798: goto -3 -> 795
    //   801: astore_1
    //   802: aconst_null
    //   803: astore 8
    //   805: aload_0
    //   806: astore 9
    //   808: aload 8
    //   810: astore_0
    //   811: goto -34 -> 777
    //   814: astore_1
    //   815: aload_0
    //   816: astore 9
    //   818: aload 8
    //   820: astore_0
    //   821: goto -44 -> 777
    //   824: astore 10
    //   826: aload_1
    //   827: astore 9
    //   829: aload 8
    //   831: astore_0
    //   832: aload 10
    //   834: astore_1
    //   835: goto -58 -> 777
    //   838: astore_0
    //   839: bipush 34
    //   841: istore_2
    //   842: aload 9
    //   844: astore_1
    //   845: goto -109 -> 736
    //   848: astore 9
    //   850: aload_0
    //   851: astore_1
    //   852: aload 9
    //   854: astore_0
    //   855: goto -119 -> 736
    //   858: astore 9
    //   860: aload_1
    //   861: astore 8
    //   863: aload_0
    //   864: astore_1
    //   865: aload 9
    //   867: astore_0
    //   868: goto -132 -> 736
    //   871: astore 9
    //   873: aconst_null
    //   874: astore 8
    //   876: aload_0
    //   877: astore_1
    //   878: aload 9
    //   880: astore_0
    //   881: goto -145 -> 736
    //   884: astore_0
    //   885: iload_2
    //   886: istore_3
    //   887: goto -628 -> 259
    //   890: astore_0
    //   891: sipush 129
    //   894: ireturn
    //   895: sipush 133
    //   898: istore_2
    //   899: goto -660 -> 239
    //   902: iload_3
    //   903: iconst_1
    //   904: iadd
    //   905: istore_3
    //   906: goto -277 -> 629
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	909	0	paramString1	String
    //   0	909	1	paramString2	String
    //   9	890	2	i	int
    //   7	899	3	j	int
    //   344	378	4	k	int
    //   395	277	5	m	int
    //   406	227	6	n	int
    //   68	65	7	bool	boolean
    //   1	874	8	str1	String
    //   4	839	9	str2	String
    //   848	5	9	localThrowable1	java.lang.Throwable
    //   858	8	9	localThrowable2	java.lang.Throwable
    //   871	8	9	localThrowable3	java.lang.Throwable
    //   116	559	10	localObject1	Object
    //   824	9	10	localObject2	Object
    //   16	626	11	localObject3	Object
    //   430	251	12	localObject4	Object
    //   444	42	13	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   82	90	102	java/io/IOException
    //   94	102	102	java/io/IOException
    //   143	151	163	java/io/IOException
    //   155	163	163	java/io/IOException
    //   188	196	208	java/io/IOException
    //   200	208	208	java/io/IOException
    //   698	706	720	java/io/IOException
    //   713	717	720	java/io/IOException
    //   10	18	732	java/lang/Throwable
    //   59	70	732	java/lang/Throwable
    //   108	118	732	java/lang/Throwable
    //   125	132	732	java/lang/Throwable
    //   169	175	732	java/lang/Throwable
    //   745	750	765	java/io/IOException
    //   756	760	765	java/io/IOException
    //   10	18	771	finally
    //   59	70	771	finally
    //   108	118	771	finally
    //   125	132	771	finally
    //   169	175	771	finally
    //   216	225	771	finally
    //   781	785	797	java/io/IOException
    //   790	795	797	java/io/IOException
    //   225	231	801	finally
    //   298	311	801	finally
    //   319	328	814	finally
    //   340	346	814	finally
    //   370	379	814	finally
    //   391	397	814	finally
    //   402	408	814	finally
    //   426	432	814	finally
    //   440	446	814	finally
    //   451	458	814	finally
    //   463	467	814	finally
    //   478	495	814	finally
    //   515	524	814	finally
    //   532	541	814	finally
    //   547	563	814	finally
    //   576	588	814	finally
    //   594	602	814	finally
    //   622	627	814	finally
    //   641	652	814	finally
    //   658	665	814	finally
    //   674	689	814	finally
    //   736	740	824	finally
    //   216	225	838	java/lang/Throwable
    //   225	231	848	java/lang/Throwable
    //   298	311	848	java/lang/Throwable
    //   319	328	858	java/lang/Throwable
    //   340	346	858	java/lang/Throwable
    //   370	379	858	java/lang/Throwable
    //   391	397	858	java/lang/Throwable
    //   402	408	858	java/lang/Throwable
    //   426	432	858	java/lang/Throwable
    //   440	446	858	java/lang/Throwable
    //   451	458	858	java/lang/Throwable
    //   463	467	858	java/lang/Throwable
    //   478	495	871	java/lang/Throwable
    //   515	524	871	java/lang/Throwable
    //   532	541	871	java/lang/Throwable
    //   547	563	871	java/lang/Throwable
    //   576	588	871	java/lang/Throwable
    //   594	602	871	java/lang/Throwable
    //   622	627	871	java/lang/Throwable
    //   641	652	871	java/lang/Throwable
    //   658	665	871	java/lang/Throwable
    //   674	689	871	java/lang/Throwable
    //   243	247	884	java/io/IOException
    //   253	257	884	java/io/IOException
    //   31	39	890	java/io/IOException
    //   43	51	890	java/io/IOException
  }
  
  private static PublicKey a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = a;
    }
    paramString = new X509EncodedKeySpec(Base64.decode(str, 0));
    try
    {
      paramString = KeyFactory.getInstance(bcwj.a).generatePublic(paramString);
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
      Signature localSignature = Signature.getInstance(bcwj.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcwk
 * JD-Core Version:    0.7.0.1
 */