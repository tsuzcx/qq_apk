import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class bfak
{
  private static String a = "";
  private static String b = bfai.a(bfai.v);
  
  static
  {
    a = bfai.a(bfai.u);
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
    //   10: getstatic 13	bfak:a	Ljava/lang/String;
    //   13: invokestatic 38	bfak:a	(Ljava/lang/String;)Ljava/security/PublicKey;
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
    //   170: invokestatic 67	bfaj:a	(Ljava/lang/String;)Ljava/util/Map;
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
    //   267: getstatic 26	bfak:b	Ljava/lang/String;
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
    //   351: if_icmplt +545 -> 896
    //   354: iload 4
    //   356: sipush 256
    //   359: if_icmple +6 -> 365
    //   362: goto +534 -> 896
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
    //   468: astore 9
    //   470: aconst_null
    //   471: astore_1
    //   472: bipush 40
    //   474: istore_2
    //   475: aload 9
    //   477: astore 8
    //   479: aload 12
    //   481: ldc 126
    //   483: invokevirtual 130	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   486: aload 13
    //   488: aload 11
    //   490: invokestatic 133	bfak:a	([B[BLjava/security/PublicKey;)Z
    //   493: ifne +10 -> 503
    //   496: sipush 137
    //   499: istore_2
    //   500: goto -261 -> 239
    //   503: bipush 41
    //   505: istore 4
    //   507: aload 9
    //   509: astore 8
    //   511: iload 4
    //   513: istore_2
    //   514: new 87	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   521: astore 11
    //   523: iconst_0
    //   524: istore_3
    //   525: aload 9
    //   527: astore 8
    //   529: iload 4
    //   531: istore_2
    //   532: iload_3
    //   533: aload 12
    //   535: invokevirtual 136	java/lang/String:length	()I
    //   538: if_icmpge +33 -> 571
    //   541: aload 9
    //   543: astore 8
    //   545: iload 4
    //   547: istore_2
    //   548: aload 11
    //   550: aload 12
    //   552: iload_3
    //   553: invokevirtual 140	java/lang/String:charAt	(I)C
    //   556: iload 5
    //   558: ixor
    //   559: i2c
    //   560: invokevirtual 143	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: iload_3
    //   565: iconst_1
    //   566: iadd
    //   567: istore_3
    //   568: goto -43 -> 525
    //   571: aload 9
    //   573: astore 8
    //   575: iload 4
    //   577: istore_2
    //   578: aload 11
    //   580: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: ldc 145
    //   585: invokevirtual 149	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   588: astore 12
    //   590: aload 9
    //   592: astore 8
    //   594: iload 4
    //   596: istore_2
    //   597: aload 12
    //   599: arraylength
    //   600: iload 6
    //   602: if_icmpeq +10 -> 612
    //   605: sipush 135
    //   608: istore_2
    //   609: goto -370 -> 239
    //   612: bipush 42
    //   614: istore 5
    //   616: aload 9
    //   618: astore 8
    //   620: iload 5
    //   622: istore_2
    //   623: aload 12
    //   625: arraylength
    //   626: istore 6
    //   628: iconst_0
    //   629: istore_3
    //   630: iload_3
    //   631: iload 6
    //   633: if_icmpge +95 -> 728
    //   636: aload 9
    //   638: astore 8
    //   640: iload 5
    //   642: istore_2
    //   643: aload 12
    //   645: iload_3
    //   646: aaload
    //   647: ldc 151
    //   649: invokevirtual 149	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   652: astore 11
    //   654: aload 9
    //   656: astore 8
    //   658: iload 5
    //   660: istore_2
    //   661: aload 11
    //   663: arraylength
    //   664: iconst_2
    //   665: if_icmpeq +6 -> 671
    //   668: goto +235 -> 903
    //   671: aload 9
    //   673: astore 8
    //   675: iload 5
    //   677: istore_2
    //   678: aload 10
    //   680: aload 11
    //   682: iconst_0
    //   683: aaload
    //   684: aload 11
    //   686: iconst_1
    //   687: aaload
    //   688: invokestatic 154	bfaj:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)I
    //   691: istore 4
    //   693: iload 4
    //   695: ifeq +208 -> 903
    //   698: iconst_0
    //   699: ifeq +11 -> 710
    //   702: new 40	java/lang/NullPointerException
    //   705: dup
    //   706: invokespecial 43	java/lang/NullPointerException:<init>	()V
    //   709: athrow
    //   710: iload 4
    //   712: istore_2
    //   713: aload_0
    //   714: ifnull -663 -> 51
    //   717: aload_0
    //   718: invokevirtual 80	java/util/jar/JarFile:close	()V
    //   721: iload 4
    //   723: ireturn
    //   724: astore_0
    //   725: iload 4
    //   727: ireturn
    //   728: iconst_0
    //   729: istore_2
    //   730: goto -491 -> 239
    //   733: astore_0
    //   734: aload 9
    //   736: astore_1
    //   737: aload_0
    //   738: invokevirtual 157	java/lang/Throwable:printStackTrace	()V
    //   741: aload 8
    //   743: ifnull +8 -> 751
    //   746: aload 8
    //   748: invokevirtual 79	java/io/DataInputStream:close	()V
    //   751: iload_2
    //   752: istore_3
    //   753: aload_1
    //   754: ifnull -495 -> 259
    //   757: aload_1
    //   758: invokevirtual 80	java/util/jar/JarFile:close	()V
    //   761: iload_2
    //   762: istore_3
    //   763: goto -504 -> 259
    //   766: astore_0
    //   767: iload_2
    //   768: istore_3
    //   769: goto -510 -> 259
    //   772: astore_1
    //   773: aconst_null
    //   774: astore 9
    //   776: aconst_null
    //   777: astore_0
    //   778: aload_0
    //   779: ifnull +7 -> 786
    //   782: aload_0
    //   783: invokevirtual 79	java/io/DataInputStream:close	()V
    //   786: aload 9
    //   788: ifnull +8 -> 796
    //   791: aload 9
    //   793: invokevirtual 80	java/util/jar/JarFile:close	()V
    //   796: aload_1
    //   797: athrow
    //   798: astore_0
    //   799: goto -3 -> 796
    //   802: astore_1
    //   803: aconst_null
    //   804: astore 8
    //   806: aload_0
    //   807: astore 9
    //   809: aload 8
    //   811: astore_0
    //   812: goto -34 -> 778
    //   815: astore_1
    //   816: aload_0
    //   817: astore 9
    //   819: aload 8
    //   821: astore_0
    //   822: goto -44 -> 778
    //   825: astore 10
    //   827: aload_1
    //   828: astore 9
    //   830: aload 8
    //   832: astore_0
    //   833: aload 10
    //   835: astore_1
    //   836: goto -58 -> 778
    //   839: astore_0
    //   840: bipush 34
    //   842: istore_2
    //   843: aload 9
    //   845: astore_1
    //   846: goto -109 -> 737
    //   849: astore 9
    //   851: aload_0
    //   852: astore_1
    //   853: aload 9
    //   855: astore_0
    //   856: goto -119 -> 737
    //   859: astore 9
    //   861: aload_1
    //   862: astore 8
    //   864: aload_0
    //   865: astore_1
    //   866: aload 9
    //   868: astore_0
    //   869: goto -132 -> 737
    //   872: astore 9
    //   874: aconst_null
    //   875: astore 8
    //   877: aload_0
    //   878: astore_1
    //   879: aload 9
    //   881: astore_0
    //   882: goto -145 -> 737
    //   885: astore_0
    //   886: iload_2
    //   887: istore_3
    //   888: goto -629 -> 259
    //   891: astore_0
    //   892: sipush 129
    //   895: ireturn
    //   896: sipush 133
    //   899: istore_2
    //   900: goto -661 -> 239
    //   903: iload_3
    //   904: iconst_1
    //   905: iadd
    //   906: istore_3
    //   907: goto -277 -> 630
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	910	0	paramString1	String
    //   0	910	1	paramString2	String
    //   9	891	2	i	int
    //   7	900	3	j	int
    //   344	382	4	k	int
    //   395	281	5	m	int
    //   406	228	6	n	int
    //   68	65	7	bool	boolean
    //   1	875	8	localObject1	Object
    //   4	840	9	str	String
    //   849	5	9	localThrowable1	java.lang.Throwable
    //   859	8	9	localThrowable2	java.lang.Throwable
    //   872	8	9	localThrowable3	java.lang.Throwable
    //   116	563	10	localObject2	Object
    //   825	9	10	localObject3	Object
    //   16	669	11	localObject4	Object
    //   430	214	12	localObject5	Object
    //   444	43	13	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   82	90	102	java/io/IOException
    //   94	102	102	java/io/IOException
    //   143	151	163	java/io/IOException
    //   155	163	163	java/io/IOException
    //   188	196	208	java/io/IOException
    //   200	208	208	java/io/IOException
    //   702	710	724	java/io/IOException
    //   717	721	724	java/io/IOException
    //   10	18	733	java/lang/Throwable
    //   59	70	733	java/lang/Throwable
    //   108	118	733	java/lang/Throwable
    //   125	132	733	java/lang/Throwable
    //   169	175	733	java/lang/Throwable
    //   746	751	766	java/io/IOException
    //   757	761	766	java/io/IOException
    //   10	18	772	finally
    //   59	70	772	finally
    //   108	118	772	finally
    //   125	132	772	finally
    //   169	175	772	finally
    //   216	225	772	finally
    //   782	786	798	java/io/IOException
    //   791	796	798	java/io/IOException
    //   225	231	802	finally
    //   298	311	802	finally
    //   319	328	815	finally
    //   340	346	815	finally
    //   370	379	815	finally
    //   391	397	815	finally
    //   402	408	815	finally
    //   426	432	815	finally
    //   440	446	815	finally
    //   451	458	815	finally
    //   463	467	815	finally
    //   479	496	815	finally
    //   514	523	815	finally
    //   532	541	815	finally
    //   548	564	815	finally
    //   578	590	815	finally
    //   597	605	815	finally
    //   623	628	815	finally
    //   643	654	815	finally
    //   661	668	815	finally
    //   678	693	815	finally
    //   737	741	825	finally
    //   216	225	839	java/lang/Throwable
    //   225	231	849	java/lang/Throwable
    //   298	311	849	java/lang/Throwable
    //   319	328	859	java/lang/Throwable
    //   340	346	859	java/lang/Throwable
    //   370	379	859	java/lang/Throwable
    //   391	397	859	java/lang/Throwable
    //   402	408	859	java/lang/Throwable
    //   426	432	859	java/lang/Throwable
    //   440	446	859	java/lang/Throwable
    //   451	458	859	java/lang/Throwable
    //   463	467	859	java/lang/Throwable
    //   479	496	872	java/lang/Throwable
    //   514	523	872	java/lang/Throwable
    //   532	541	872	java/lang/Throwable
    //   548	564	872	java/lang/Throwable
    //   578	590	872	java/lang/Throwable
    //   597	605	872	java/lang/Throwable
    //   623	628	872	java/lang/Throwable
    //   643	654	872	java/lang/Throwable
    //   661	668	872	java/lang/Throwable
    //   678	693	872	java/lang/Throwable
    //   243	247	885	java/io/IOException
    //   253	257	885	java/io/IOException
    //   31	39	891	java/io/IOException
    //   43	51	891	java/io/IOException
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
      paramString = KeyFactory.getInstance(bfaj.a).generatePublic(paramString);
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
      Signature localSignature = Signature.getInstance(bfaj.b);
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
 * Qualified Name:     bfak
 * JD-Core Version:    0.7.0.1
 */