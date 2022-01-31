import java.io.InputStream;
import java.io.OutputStream;

public class axjp
{
  public static final String a = ajed.aW + "emojiindex";
  public static final String b = ajed.aW + "emojis";
  
  public static final int a(InputStream paramInputStream)
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      j |= paramInputStream.read() << i * 8;
      i += 1;
    }
    return j;
  }
  
  public static final int a(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    if (i < 4)
    {
      int k = paramArrayOfByte[i];
      if (k >= 0) {}
      for (;;)
      {
        j |= k << i * 8;
        i += 1;
        break;
        k += 256;
      }
    }
    return j;
  }
  
  public static final void a(OutputStream paramOutputStream, int paramInt)
  {
    int i = 0;
    while (i < 4)
    {
      paramOutputStream.write(paramInt >> i * 8 & 0xFF);
      i += 1;
    }
  }
  
  /* Error */
  public static boolean a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 64	java/io/File:exists	()Z
    //   4: ifne +19 -> 23
    //   7: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +11 -> 21
    //   13: ldc 71
    //   15: iconst_2
    //   16: ldc 73
    //   18: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: iconst_0
    //   22: ireturn
    //   23: new 60	java/io/File
    //   26: dup
    //   27: getstatic 19	ajed:aW	Ljava/lang/String;
    //   30: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore 5
    //   35: aload 5
    //   37: invokevirtual 64	java/io/File:exists	()Z
    //   40: ifne +9 -> 49
    //   43: aload 5
    //   45: invokevirtual 83	java/io/File:mkdirs	()Z
    //   48: pop
    //   49: invokestatic 89	android/os/SystemClock:uptimeMillis	()J
    //   52: lstore_3
    //   53: aconst_null
    //   54: astore 9
    //   56: aconst_null
    //   57: astore 7
    //   59: aconst_null
    //   60: astore 10
    //   62: aconst_null
    //   63: astore 8
    //   65: new 91	com/tencent/commonsdk/zip/QZipInputStream
    //   68: dup
    //   69: new 93	java/io/BufferedInputStream
    //   72: dup
    //   73: new 95	java/io/FileInputStream
    //   76: dup
    //   77: aload_0
    //   78: invokespecial 98	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   81: invokespecial 101	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   84: invokespecial 102	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   87: astore 6
    //   89: new 104	java/io/BufferedOutputStream
    //   92: dup
    //   93: new 106	java/io/FileOutputStream
    //   96: dup
    //   97: getstatic 35	axjp:b	Ljava/lang/String;
    //   100: invokespecial 107	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   103: invokespecial 110	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   106: astore 5
    //   108: aload 10
    //   110: astore 7
    //   112: new 112	java/util/HashMap
    //   115: dup
    //   116: aload_0
    //   117: invokevirtual 115	java/io/File:length	()J
    //   120: l2i
    //   121: sipush 1024
    //   124: idiv
    //   125: invokespecial 117	java/util/HashMap:<init>	(I)V
    //   128: astore 12
    //   130: aload 10
    //   132: astore 7
    //   134: invokestatic 123	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   137: sipush 512
    //   140: invokevirtual 127	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   143: astore_0
    //   144: iconst_0
    //   145: istore_1
    //   146: aload_0
    //   147: astore 7
    //   149: aload 6
    //   151: invokevirtual 131	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   154: astore 10
    //   156: aload 10
    //   158: ifnull +159 -> 317
    //   161: aload_0
    //   162: astore 7
    //   164: aload 10
    //   166: invokevirtual 136	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   169: astore 9
    //   171: aload 9
    //   173: astore 8
    //   175: aload_0
    //   176: astore 7
    //   178: aload 9
    //   180: ldc 138
    //   182: invokevirtual 144	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   185: ifeq +25 -> 210
    //   188: aload_0
    //   189: astore 7
    //   191: aload 9
    //   193: aload 9
    //   195: bipush 47
    //   197: invokevirtual 148	java/lang/String:lastIndexOf	(I)I
    //   200: iconst_1
    //   201: iadd
    //   202: invokevirtual 152	java/lang/String:substring	(I)Ljava/lang/String;
    //   205: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   208: astore 8
    //   210: aload 8
    //   212: ifnull -66 -> 146
    //   215: aload_0
    //   216: astore 7
    //   218: aload 8
    //   220: ldc 157
    //   222: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   225: ifne -79 -> 146
    //   228: aload_0
    //   229: astore 7
    //   231: aload 12
    //   233: aload 8
    //   235: iload_1
    //   236: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   239: invokeinterface 173 3 0
    //   244: pop
    //   245: aload_0
    //   246: astore 7
    //   248: aload 10
    //   250: invokevirtual 176	java/util/zip/ZipEntry:getSize	()J
    //   253: l2i
    //   254: istore_2
    //   255: iload_2
    //   256: iconst_1
    //   257: if_icmplt -111 -> 146
    //   260: aload_0
    //   261: astore 7
    //   263: aload 5
    //   265: iload_2
    //   266: invokestatic 178	axjp:a	(Ljava/io/OutputStream;I)V
    //   269: iload_1
    //   270: iconst_4
    //   271: iadd
    //   272: istore_1
    //   273: aload_0
    //   274: astore 7
    //   276: aload 6
    //   278: aload_0
    //   279: invokevirtual 180	com/tencent/commonsdk/zip/QZipInputStream:read	([B)I
    //   282: istore_2
    //   283: iload_2
    //   284: iconst_m1
    //   285: if_icmpeq +21 -> 306
    //   288: aload_0
    //   289: astore 7
    //   291: aload 5
    //   293: aload_0
    //   294: iconst_0
    //   295: iload_2
    //   296: invokevirtual 183	java/io/BufferedOutputStream:write	([BII)V
    //   299: iload_1
    //   300: iload_2
    //   301: iadd
    //   302: istore_1
    //   303: goto -30 -> 273
    //   306: aload_0
    //   307: astore 7
    //   309: aload 5
    //   311: invokevirtual 186	java/io/BufferedOutputStream:flush	()V
    //   314: goto -168 -> 146
    //   317: aload_0
    //   318: astore 7
    //   320: invokestatic 123	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   323: aload_0
    //   324: invokevirtual 190	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   327: aconst_null
    //   328: astore 8
    //   330: aconst_null
    //   331: astore 11
    //   333: aconst_null
    //   334: astore 7
    //   336: aload 5
    //   338: invokevirtual 193	java/io/BufferedOutputStream:close	()V
    //   341: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq +11 -> 355
    //   347: ldc 71
    //   349: iconst_2
    //   350: ldc 195
    //   352: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: new 104	java/io/BufferedOutputStream
    //   358: dup
    //   359: new 106	java/io/FileOutputStream
    //   362: dup
    //   363: getstatic 31	axjp:a	Ljava/lang/String;
    //   366: invokespecial 107	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   369: invokespecial 110	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   372: astore_0
    //   373: aload 11
    //   375: astore 10
    //   377: aload_0
    //   378: astore 9
    //   380: aload 6
    //   382: astore 8
    //   384: aload 12
    //   386: invokeinterface 199 1 0
    //   391: invokeinterface 205 1 0
    //   396: astore 5
    //   398: aload 11
    //   400: astore 10
    //   402: aload_0
    //   403: astore 9
    //   405: aload 6
    //   407: astore 8
    //   409: aload 5
    //   411: invokeinterface 210 1 0
    //   416: ifeq +581 -> 997
    //   419: aload 11
    //   421: astore 10
    //   423: aload_0
    //   424: astore 9
    //   426: aload 6
    //   428: astore 8
    //   430: aload 5
    //   432: invokeinterface 214 1 0
    //   437: checkcast 140	java/lang/String
    //   440: astore 13
    //   442: aload 11
    //   444: astore 10
    //   446: aload_0
    //   447: astore 9
    //   449: aload 6
    //   451: astore 8
    //   453: aload 13
    //   455: ldc 216
    //   457: invokevirtual 144	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   460: ifne +237 -> 697
    //   463: aload 11
    //   465: astore 10
    //   467: aload_0
    //   468: astore 9
    //   470: aload 6
    //   472: astore 8
    //   474: aload 13
    //   476: iconst_2
    //   477: aload 13
    //   479: invokevirtual 218	java/lang/String:length	()I
    //   482: iconst_4
    //   483: isub
    //   484: invokevirtual 221	java/lang/String:substring	(II)Ljava/lang/String;
    //   487: astore 14
    //   489: aload 11
    //   491: astore 10
    //   493: aload_0
    //   494: astore 9
    //   496: aload 6
    //   498: astore 8
    //   500: aload 12
    //   502: aload 13
    //   504: invokeinterface 225 2 0
    //   509: checkcast 163	java/lang/Integer
    //   512: invokevirtual 228	java/lang/Integer:intValue	()I
    //   515: istore_1
    //   516: aload 11
    //   518: astore 10
    //   520: aload_0
    //   521: astore 9
    //   523: aload 6
    //   525: astore 8
    //   527: aload 14
    //   529: bipush 16
    //   531: invokestatic 232	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   534: istore_2
    //   535: aload 11
    //   537: astore 10
    //   539: aload_0
    //   540: astore 9
    //   542: aload 6
    //   544: astore 8
    //   546: aload_0
    //   547: iconst_1
    //   548: invokevirtual 233	java/io/BufferedOutputStream:write	(I)V
    //   551: aload 11
    //   553: astore 10
    //   555: aload_0
    //   556: astore 9
    //   558: aload 6
    //   560: astore 8
    //   562: aload_0
    //   563: iload_2
    //   564: invokestatic 178	axjp:a	(Ljava/io/OutputStream;I)V
    //   567: aload 11
    //   569: astore 10
    //   571: aload_0
    //   572: astore 9
    //   574: aload 6
    //   576: astore 8
    //   578: aload_0
    //   579: iload_1
    //   580: invokestatic 178	axjp:a	(Ljava/io/OutputStream;I)V
    //   583: goto -185 -> 398
    //   586: astore 14
    //   588: aload 11
    //   590: astore 10
    //   592: aload_0
    //   593: astore 9
    //   595: aload 6
    //   597: astore 8
    //   599: ldc 71
    //   601: iconst_1
    //   602: invokestatic 238	aciy:a	()Ljava/lang/StringBuilder;
    //   605: ldc 240
    //   607: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: aload 13
    //   612: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   618: aload 14
    //   620: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   623: goto -225 -> 398
    //   626: astore 8
    //   628: aconst_null
    //   629: astore 5
    //   631: aload_0
    //   632: astore 7
    //   634: aload 6
    //   636: astore_0
    //   637: aload 8
    //   639: astore 6
    //   641: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   644: ifeq +13 -> 657
    //   647: ldc 71
    //   649: iconst_2
    //   650: ldc 246
    //   652: aload 6
    //   654: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   657: aload_0
    //   658: ifnull +7 -> 665
    //   661: aload_0
    //   662: invokevirtual 247	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   665: aload 7
    //   667: ifnull +8 -> 675
    //   670: aload 7
    //   672: invokevirtual 193	java/io/BufferedOutputStream:close	()V
    //   675: aload 5
    //   677: ifnull -656 -> 21
    //   680: invokestatic 123	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   683: aload 5
    //   685: invokevirtual 190	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   688: iconst_0
    //   689: ireturn
    //   690: astore_0
    //   691: aload_0
    //   692: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   695: iconst_0
    //   696: ireturn
    //   697: aload 11
    //   699: astore 10
    //   701: aload_0
    //   702: astore 9
    //   704: aload 6
    //   706: astore 8
    //   708: aload 13
    //   710: iconst_0
    //   711: aload 13
    //   713: invokevirtual 218	java/lang/String:length	()I
    //   716: iconst_4
    //   717: isub
    //   718: invokevirtual 221	java/lang/String:substring	(II)Ljava/lang/String;
    //   721: ldc 216
    //   723: invokevirtual 254	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   726: astore 14
    //   728: aload 11
    //   730: astore 10
    //   732: aload_0
    //   733: astore 9
    //   735: aload 6
    //   737: astore 8
    //   739: aload 12
    //   741: aload 13
    //   743: invokeinterface 225 2 0
    //   748: checkcast 163	java/lang/Integer
    //   751: invokevirtual 228	java/lang/Integer:intValue	()I
    //   754: istore_2
    //   755: aload 14
    //   757: ifnull -359 -> 398
    //   760: aload 11
    //   762: astore 10
    //   764: aload_0
    //   765: astore 9
    //   767: aload 6
    //   769: astore 8
    //   771: aload 14
    //   773: arraylength
    //   774: newarray int
    //   776: astore 15
    //   778: iconst_0
    //   779: istore_1
    //   780: aload 11
    //   782: astore 10
    //   784: aload_0
    //   785: astore 9
    //   787: aload 6
    //   789: astore 8
    //   791: iload_1
    //   792: aload 14
    //   794: arraylength
    //   795: if_icmpge +38 -> 833
    //   798: aload 11
    //   800: astore 10
    //   802: aload_0
    //   803: astore 9
    //   805: aload 6
    //   807: astore 8
    //   809: aload 15
    //   811: iload_1
    //   812: aload 14
    //   814: iload_1
    //   815: aaload
    //   816: iconst_2
    //   817: invokevirtual 152	java/lang/String:substring	(I)Ljava/lang/String;
    //   820: bipush 16
    //   822: invokestatic 232	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   825: iastore
    //   826: iload_1
    //   827: iconst_1
    //   828: iadd
    //   829: istore_1
    //   830: goto -50 -> 780
    //   833: aload 11
    //   835: astore 10
    //   837: aload_0
    //   838: astore 9
    //   840: aload 6
    //   842: astore 8
    //   844: aload_0
    //   845: aload 14
    //   847: arraylength
    //   848: invokevirtual 233	java/io/BufferedOutputStream:write	(I)V
    //   851: iconst_0
    //   852: istore_1
    //   853: aload 11
    //   855: astore 10
    //   857: aload_0
    //   858: astore 9
    //   860: aload 6
    //   862: astore 8
    //   864: iload_1
    //   865: aload 15
    //   867: arraylength
    //   868: if_icmpge +29 -> 897
    //   871: aload 11
    //   873: astore 10
    //   875: aload_0
    //   876: astore 9
    //   878: aload 6
    //   880: astore 8
    //   882: aload_0
    //   883: aload 15
    //   885: iload_1
    //   886: iaload
    //   887: invokestatic 178	axjp:a	(Ljava/io/OutputStream;I)V
    //   890: iload_1
    //   891: iconst_1
    //   892: iadd
    //   893: istore_1
    //   894: goto -41 -> 853
    //   897: aload 11
    //   899: astore 10
    //   901: aload_0
    //   902: astore 9
    //   904: aload 6
    //   906: astore 8
    //   908: aload_0
    //   909: iload_2
    //   910: invokestatic 178	axjp:a	(Ljava/io/OutputStream;I)V
    //   913: goto -515 -> 398
    //   916: astore 5
    //   918: aload 7
    //   920: astore 10
    //   922: aload_0
    //   923: astore 9
    //   925: aload 6
    //   927: astore 8
    //   929: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   932: ifeq +25 -> 957
    //   935: aload 7
    //   937: astore 10
    //   939: aload_0
    //   940: astore 9
    //   942: aload 6
    //   944: astore 8
    //   946: ldc 71
    //   948: iconst_2
    //   949: ldc_w 256
    //   952: aload 5
    //   954: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   957: aload 6
    //   959: ifnull +8 -> 967
    //   962: aload 6
    //   964: invokevirtual 247	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   967: aload_0
    //   968: ifnull +7 -> 975
    //   971: aload_0
    //   972: invokevirtual 193	java/io/BufferedOutputStream:close	()V
    //   975: aload 7
    //   977: ifnull -956 -> 21
    //   980: invokestatic 123	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   983: aload 7
    //   985: invokevirtual 190	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   988: iconst_0
    //   989: ireturn
    //   990: astore_0
    //   991: aload_0
    //   992: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   995: iconst_0
    //   996: ireturn
    //   997: aload 11
    //   999: astore 10
    //   1001: aload_0
    //   1002: astore 9
    //   1004: aload 6
    //   1006: astore 8
    //   1008: aload_0
    //   1009: invokevirtual 186	java/io/BufferedOutputStream:flush	()V
    //   1012: aload 11
    //   1014: astore 10
    //   1016: aload_0
    //   1017: astore 9
    //   1019: aload 6
    //   1021: astore 8
    //   1023: invokestatic 262	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1026: astore 12
    //   1028: aload 11
    //   1030: astore 10
    //   1032: aload_0
    //   1033: astore 9
    //   1035: aload 6
    //   1037: astore 8
    //   1039: getstatic 268	android/os/Build$VERSION:SDK_INT	I
    //   1042: bipush 24
    //   1044: if_icmplt +342 -> 1386
    //   1047: aload 11
    //   1049: astore 10
    //   1051: aload_0
    //   1052: astore 9
    //   1054: aload 6
    //   1056: astore 8
    //   1058: aload 12
    //   1060: invokestatic 274	android/preference/PreferenceManager:getDefaultSharedPreferencesName	(Landroid/content/Context;)Ljava/lang/String;
    //   1063: astore 5
    //   1065: aload 11
    //   1067: astore 10
    //   1069: aload_0
    //   1070: astore 9
    //   1072: aload 6
    //   1074: astore 8
    //   1076: aload 12
    //   1078: aload 5
    //   1080: iconst_4
    //   1081: invokevirtual 280	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1084: invokeinterface 286 1 0
    //   1089: ldc_w 288
    //   1092: iconst_1
    //   1093: invokeinterface 294 3 0
    //   1098: invokeinterface 297 1 0
    //   1103: pop
    //   1104: aload 11
    //   1106: astore 10
    //   1108: aload_0
    //   1109: astore 9
    //   1111: aload 6
    //   1113: astore 8
    //   1115: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1118: ifeq +23 -> 1141
    //   1121: aload 11
    //   1123: astore 10
    //   1125: aload_0
    //   1126: astore 9
    //   1128: aload 6
    //   1130: astore 8
    //   1132: ldc 71
    //   1134: iconst_2
    //   1135: ldc_w 299
    //   1138: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1141: aload 11
    //   1143: astore 10
    //   1145: aload_0
    //   1146: astore 9
    //   1148: aload 6
    //   1150: astore 8
    //   1152: new 60	java/io/File
    //   1155: dup
    //   1156: getstatic 31	axjp:a	Ljava/lang/String;
    //   1159: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   1162: astore 5
    //   1164: aload 11
    //   1166: astore 10
    //   1168: aload_0
    //   1169: astore 9
    //   1171: aload 6
    //   1173: astore 8
    //   1175: new 60	java/io/File
    //   1178: dup
    //   1179: getstatic 35	axjp:b	Ljava/lang/String;
    //   1182: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   1185: astore 12
    //   1187: aload 11
    //   1189: astore 10
    //   1191: aload_0
    //   1192: astore 9
    //   1194: aload 6
    //   1196: astore 8
    //   1198: aload 5
    //   1200: invokevirtual 64	java/io/File:exists	()Z
    //   1203: ifeq +40 -> 1243
    //   1206: aload 11
    //   1208: astore 10
    //   1210: aload_0
    //   1211: astore 9
    //   1213: aload 6
    //   1215: astore 8
    //   1217: aload 12
    //   1219: invokevirtual 64	java/io/File:exists	()Z
    //   1222: ifeq +21 -> 1243
    //   1225: aload 11
    //   1227: astore 10
    //   1229: aload_0
    //   1230: astore 9
    //   1232: aload 6
    //   1234: astore 8
    //   1236: aload 5
    //   1238: aload 12
    //   1240: invokestatic 304	axjs:a	(Ljava/io/File;Ljava/io/File;)V
    //   1243: aload 11
    //   1245: astore 10
    //   1247: aload_0
    //   1248: astore 9
    //   1250: aload 6
    //   1252: astore 8
    //   1254: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1257: ifeq +62 -> 1319
    //   1260: aload 11
    //   1262: astore 10
    //   1264: aload_0
    //   1265: astore 9
    //   1267: aload 6
    //   1269: astore 8
    //   1271: ldc 71
    //   1273: iconst_2
    //   1274: new 11	java/lang/StringBuilder
    //   1277: dup
    //   1278: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   1281: ldc_w 306
    //   1284: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1287: getstatic 309	axjs:jdField_a_of_type_AndroidUtilSparseIntArray	Landroid/util/SparseIntArray;
    //   1290: invokevirtual 314	android/util/SparseIntArray:size	()I
    //   1293: invokevirtual 317	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1296: ldc_w 319
    //   1299: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: getstatic 322	axjs:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   1305: invokeinterface 323 1 0
    //   1310: invokevirtual 317	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1313: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1316: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1319: aload 6
    //   1321: ifnull +8 -> 1329
    //   1324: aload 6
    //   1326: invokevirtual 247	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   1329: aload_0
    //   1330: ifnull +7 -> 1337
    //   1333: aload_0
    //   1334: invokevirtual 193	java/io/BufferedOutputStream:close	()V
    //   1337: iconst_0
    //   1338: ifeq +10 -> 1348
    //   1341: invokestatic 123	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   1344: aconst_null
    //   1345: invokevirtual 190	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   1348: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1351: ifeq +33 -> 1384
    //   1354: ldc 71
    //   1356: iconst_2
    //   1357: new 11	java/lang/StringBuilder
    //   1360: dup
    //   1361: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   1364: ldc_w 325
    //   1367: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1370: invokestatic 89	android/os/SystemClock:uptimeMillis	()J
    //   1373: lload_3
    //   1374: lsub
    //   1375: invokevirtual 328	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1378: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1381: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1384: iconst_1
    //   1385: ireturn
    //   1386: aload 11
    //   1388: astore 10
    //   1390: aload_0
    //   1391: astore 9
    //   1393: aload 6
    //   1395: astore 8
    //   1397: new 11	java/lang/StringBuilder
    //   1400: dup
    //   1401: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   1404: aload 12
    //   1406: invokevirtual 331	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1409: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1412: ldc_w 333
    //   1415: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1418: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1421: astore 5
    //   1423: goto -358 -> 1065
    //   1426: astore_0
    //   1427: aload_0
    //   1428: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   1431: goto -83 -> 1348
    //   1434: astore_0
    //   1435: aconst_null
    //   1436: astore 7
    //   1438: aconst_null
    //   1439: astore 6
    //   1441: aconst_null
    //   1442: astore 5
    //   1444: aload 6
    //   1446: ifnull +8 -> 1454
    //   1449: aload 6
    //   1451: invokevirtual 247	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   1454: aload 7
    //   1456: ifnull +8 -> 1464
    //   1459: aload 7
    //   1461: invokevirtual 193	java/io/BufferedOutputStream:close	()V
    //   1464: aload 5
    //   1466: ifnull +11 -> 1477
    //   1469: invokestatic 123	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   1472: aload 5
    //   1474: invokevirtual 190	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   1477: aload_0
    //   1478: athrow
    //   1479: astore 5
    //   1481: aload 5
    //   1483: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   1486: goto -9 -> 1477
    //   1489: astore_0
    //   1490: aconst_null
    //   1491: astore 7
    //   1493: aconst_null
    //   1494: astore 5
    //   1496: goto -52 -> 1444
    //   1499: astore_0
    //   1500: aconst_null
    //   1501: astore 8
    //   1503: aload 5
    //   1505: astore 7
    //   1507: aload 8
    //   1509: astore 5
    //   1511: goto -67 -> 1444
    //   1514: astore 9
    //   1516: aload_0
    //   1517: astore 7
    //   1519: aload 5
    //   1521: astore 8
    //   1523: aload 9
    //   1525: astore_0
    //   1526: aload 7
    //   1528: astore 5
    //   1530: aload 8
    //   1532: astore 7
    //   1534: goto -90 -> 1444
    //   1537: astore_0
    //   1538: aload 5
    //   1540: astore 7
    //   1542: aload 8
    //   1544: astore 5
    //   1546: goto -102 -> 1444
    //   1549: astore_0
    //   1550: aload 10
    //   1552: astore 5
    //   1554: aload 9
    //   1556: astore 7
    //   1558: aload 8
    //   1560: astore 6
    //   1562: goto -118 -> 1444
    //   1565: astore 8
    //   1567: aload_0
    //   1568: astore 6
    //   1570: aload 8
    //   1572: astore_0
    //   1573: goto -129 -> 1444
    //   1576: astore 5
    //   1578: aconst_null
    //   1579: astore_0
    //   1580: aconst_null
    //   1581: astore 6
    //   1583: aconst_null
    //   1584: astore 7
    //   1586: goto -668 -> 918
    //   1589: astore 5
    //   1591: aconst_null
    //   1592: astore_0
    //   1593: aconst_null
    //   1594: astore 7
    //   1596: goto -678 -> 918
    //   1599: astore 8
    //   1601: aconst_null
    //   1602: astore 7
    //   1604: aload 5
    //   1606: astore_0
    //   1607: aload 8
    //   1609: astore 5
    //   1611: goto -693 -> 918
    //   1614: astore 7
    //   1616: aload 5
    //   1618: astore 8
    //   1620: aload 7
    //   1622: astore 5
    //   1624: aload_0
    //   1625: astore 7
    //   1627: aload 8
    //   1629: astore_0
    //   1630: goto -712 -> 918
    //   1633: astore 8
    //   1635: aload 5
    //   1637: astore_0
    //   1638: aload 8
    //   1640: astore 5
    //   1642: goto -724 -> 918
    //   1645: astore 6
    //   1647: aload 8
    //   1649: astore 5
    //   1651: aload 9
    //   1653: astore_0
    //   1654: goto -1013 -> 641
    //   1657: astore 5
    //   1659: aload 6
    //   1661: astore_0
    //   1662: aload 5
    //   1664: astore 6
    //   1666: aload 8
    //   1668: astore 5
    //   1670: goto -1029 -> 641
    //   1673: astore 9
    //   1675: aload 5
    //   1677: astore_0
    //   1678: aload 6
    //   1680: astore 8
    //   1682: aload 9
    //   1684: astore 6
    //   1686: aload 7
    //   1688: astore 5
    //   1690: aload_0
    //   1691: astore 7
    //   1693: aload 8
    //   1695: astore_0
    //   1696: goto -1055 -> 641
    //   1699: astore 9
    //   1701: aconst_null
    //   1702: astore 8
    //   1704: aload 5
    //   1706: astore 7
    //   1708: aload 6
    //   1710: astore_0
    //   1711: aload 9
    //   1713: astore 6
    //   1715: aload 8
    //   1717: astore 5
    //   1719: goto -1078 -> 641
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1722	0	paramFile	java.io.File
    //   145	749	1	i	int
    //   254	656	2	j	int
    //   52	1322	3	l	long
    //   33	651	5	localObject1	Object
    //   916	37	5	localIOException1	java.io.IOException
    //   1063	410	5	localObject2	Object
    //   1479	3	5	localIOException2	java.io.IOException
    //   1494	59	5	localObject3	Object
    //   1576	1	5	localIOException3	java.io.IOException
    //   1589	16	5	localIOException4	java.io.IOException
    //   1609	41	5	localObject4	Object
    //   1657	6	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   1668	50	5	localObject5	Object
    //   87	1495	6	localObject6	Object
    //   1645	15	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   1664	50	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   57	1546	7	localObject7	Object
    //   1614	7	7	localIOException5	java.io.IOException
    //   1625	82	7	localObject8	Object
    //   63	535	8	localObject9	Object
    //   626	12	8	localFileNotFoundException4	java.io.FileNotFoundException
    //   706	853	8	localObject10	Object
    //   1565	6	8	localObject11	Object
    //   1599	9	8	localIOException6	java.io.IOException
    //   1618	10	8	localObject12	Object
    //   1633	34	8	localIOException7	java.io.IOException
    //   1680	36	8	localObject13	Object
    //   54	1338	9	localObject14	Object
    //   1514	138	9	localObject15	Object
    //   1673	10	9	localFileNotFoundException5	java.io.FileNotFoundException
    //   1699	13	9	localFileNotFoundException6	java.io.FileNotFoundException
    //   60	1491	10	localObject16	Object
    //   331	1056	11	localObject17	Object
    //   128	1277	12	localObject18	Object
    //   440	302	13	str1	String
    //   487	41	14	str2	String
    //   586	33	14	localException	java.lang.Exception
    //   726	120	14	arrayOfString	String[]
    //   776	108	15	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   453	463	586	java/lang/Exception
    //   474	489	586	java/lang/Exception
    //   500	516	586	java/lang/Exception
    //   527	535	586	java/lang/Exception
    //   546	551	586	java/lang/Exception
    //   562	567	586	java/lang/Exception
    //   578	583	586	java/lang/Exception
    //   708	728	586	java/lang/Exception
    //   739	755	586	java/lang/Exception
    //   771	778	586	java/lang/Exception
    //   791	798	586	java/lang/Exception
    //   809	826	586	java/lang/Exception
    //   844	851	586	java/lang/Exception
    //   864	871	586	java/lang/Exception
    //   882	890	586	java/lang/Exception
    //   908	913	586	java/lang/Exception
    //   384	398	626	java/io/FileNotFoundException
    //   409	419	626	java/io/FileNotFoundException
    //   430	442	626	java/io/FileNotFoundException
    //   453	463	626	java/io/FileNotFoundException
    //   474	489	626	java/io/FileNotFoundException
    //   500	516	626	java/io/FileNotFoundException
    //   527	535	626	java/io/FileNotFoundException
    //   546	551	626	java/io/FileNotFoundException
    //   562	567	626	java/io/FileNotFoundException
    //   578	583	626	java/io/FileNotFoundException
    //   599	623	626	java/io/FileNotFoundException
    //   708	728	626	java/io/FileNotFoundException
    //   739	755	626	java/io/FileNotFoundException
    //   771	778	626	java/io/FileNotFoundException
    //   791	798	626	java/io/FileNotFoundException
    //   809	826	626	java/io/FileNotFoundException
    //   844	851	626	java/io/FileNotFoundException
    //   864	871	626	java/io/FileNotFoundException
    //   882	890	626	java/io/FileNotFoundException
    //   908	913	626	java/io/FileNotFoundException
    //   1008	1012	626	java/io/FileNotFoundException
    //   1023	1028	626	java/io/FileNotFoundException
    //   1039	1047	626	java/io/FileNotFoundException
    //   1058	1065	626	java/io/FileNotFoundException
    //   1076	1104	626	java/io/FileNotFoundException
    //   1115	1121	626	java/io/FileNotFoundException
    //   1132	1141	626	java/io/FileNotFoundException
    //   1152	1164	626	java/io/FileNotFoundException
    //   1175	1187	626	java/io/FileNotFoundException
    //   1198	1206	626	java/io/FileNotFoundException
    //   1217	1225	626	java/io/FileNotFoundException
    //   1236	1243	626	java/io/FileNotFoundException
    //   1254	1260	626	java/io/FileNotFoundException
    //   1271	1319	626	java/io/FileNotFoundException
    //   1397	1423	626	java/io/FileNotFoundException
    //   661	665	690	java/io/IOException
    //   670	675	690	java/io/IOException
    //   680	688	690	java/io/IOException
    //   384	398	916	java/io/IOException
    //   409	419	916	java/io/IOException
    //   430	442	916	java/io/IOException
    //   453	463	916	java/io/IOException
    //   474	489	916	java/io/IOException
    //   500	516	916	java/io/IOException
    //   527	535	916	java/io/IOException
    //   546	551	916	java/io/IOException
    //   562	567	916	java/io/IOException
    //   578	583	916	java/io/IOException
    //   599	623	916	java/io/IOException
    //   708	728	916	java/io/IOException
    //   739	755	916	java/io/IOException
    //   771	778	916	java/io/IOException
    //   791	798	916	java/io/IOException
    //   809	826	916	java/io/IOException
    //   844	851	916	java/io/IOException
    //   864	871	916	java/io/IOException
    //   882	890	916	java/io/IOException
    //   908	913	916	java/io/IOException
    //   1008	1012	916	java/io/IOException
    //   1023	1028	916	java/io/IOException
    //   1039	1047	916	java/io/IOException
    //   1058	1065	916	java/io/IOException
    //   1076	1104	916	java/io/IOException
    //   1115	1121	916	java/io/IOException
    //   1132	1141	916	java/io/IOException
    //   1152	1164	916	java/io/IOException
    //   1175	1187	916	java/io/IOException
    //   1198	1206	916	java/io/IOException
    //   1217	1225	916	java/io/IOException
    //   1236	1243	916	java/io/IOException
    //   1254	1260	916	java/io/IOException
    //   1271	1319	916	java/io/IOException
    //   1397	1423	916	java/io/IOException
    //   962	967	990	java/io/IOException
    //   971	975	990	java/io/IOException
    //   980	988	990	java/io/IOException
    //   1324	1329	1426	java/io/IOException
    //   1333	1337	1426	java/io/IOException
    //   1341	1348	1426	java/io/IOException
    //   65	89	1434	finally
    //   1449	1454	1479	java/io/IOException
    //   1459	1464	1479	java/io/IOException
    //   1469	1477	1479	java/io/IOException
    //   89	108	1489	finally
    //   112	130	1499	finally
    //   134	144	1499	finally
    //   149	156	1514	finally
    //   164	171	1514	finally
    //   178	188	1514	finally
    //   191	210	1514	finally
    //   218	228	1514	finally
    //   231	245	1514	finally
    //   248	255	1514	finally
    //   263	269	1514	finally
    //   276	283	1514	finally
    //   291	299	1514	finally
    //   309	314	1514	finally
    //   320	327	1514	finally
    //   336	355	1537	finally
    //   355	373	1537	finally
    //   384	398	1549	finally
    //   409	419	1549	finally
    //   430	442	1549	finally
    //   453	463	1549	finally
    //   474	489	1549	finally
    //   500	516	1549	finally
    //   527	535	1549	finally
    //   546	551	1549	finally
    //   562	567	1549	finally
    //   578	583	1549	finally
    //   599	623	1549	finally
    //   708	728	1549	finally
    //   739	755	1549	finally
    //   771	778	1549	finally
    //   791	798	1549	finally
    //   809	826	1549	finally
    //   844	851	1549	finally
    //   864	871	1549	finally
    //   882	890	1549	finally
    //   908	913	1549	finally
    //   929	935	1549	finally
    //   946	957	1549	finally
    //   1008	1012	1549	finally
    //   1023	1028	1549	finally
    //   1039	1047	1549	finally
    //   1058	1065	1549	finally
    //   1076	1104	1549	finally
    //   1115	1121	1549	finally
    //   1132	1141	1549	finally
    //   1152	1164	1549	finally
    //   1175	1187	1549	finally
    //   1198	1206	1549	finally
    //   1217	1225	1549	finally
    //   1236	1243	1549	finally
    //   1254	1260	1549	finally
    //   1271	1319	1549	finally
    //   1397	1423	1549	finally
    //   641	657	1565	finally
    //   65	89	1576	java/io/IOException
    //   89	108	1589	java/io/IOException
    //   112	130	1599	java/io/IOException
    //   134	144	1599	java/io/IOException
    //   149	156	1614	java/io/IOException
    //   164	171	1614	java/io/IOException
    //   178	188	1614	java/io/IOException
    //   191	210	1614	java/io/IOException
    //   218	228	1614	java/io/IOException
    //   231	245	1614	java/io/IOException
    //   248	255	1614	java/io/IOException
    //   263	269	1614	java/io/IOException
    //   276	283	1614	java/io/IOException
    //   291	299	1614	java/io/IOException
    //   309	314	1614	java/io/IOException
    //   320	327	1614	java/io/IOException
    //   336	355	1633	java/io/IOException
    //   355	373	1633	java/io/IOException
    //   65	89	1645	java/io/FileNotFoundException
    //   89	108	1657	java/io/FileNotFoundException
    //   112	130	1673	java/io/FileNotFoundException
    //   134	144	1673	java/io/FileNotFoundException
    //   149	156	1673	java/io/FileNotFoundException
    //   164	171	1673	java/io/FileNotFoundException
    //   178	188	1673	java/io/FileNotFoundException
    //   191	210	1673	java/io/FileNotFoundException
    //   218	228	1673	java/io/FileNotFoundException
    //   231	245	1673	java/io/FileNotFoundException
    //   248	255	1673	java/io/FileNotFoundException
    //   263	269	1673	java/io/FileNotFoundException
    //   276	283	1673	java/io/FileNotFoundException
    //   291	299	1673	java/io/FileNotFoundException
    //   309	314	1673	java/io/FileNotFoundException
    //   320	327	1673	java/io/FileNotFoundException
    //   336	355	1699	java/io/FileNotFoundException
    //   355	373	1699	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axjp
 * JD-Core Version:    0.7.0.1
 */