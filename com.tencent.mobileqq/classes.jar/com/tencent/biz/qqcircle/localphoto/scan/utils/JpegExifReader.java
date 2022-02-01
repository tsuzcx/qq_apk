package com.tencent.biz.qqcircle.localphoto.scan.utils;

import java.io.IOException;
import java.io.InputStream;

public class JpegExifReader
{
  private static boolean a = true;
  private static final byte[] b = { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8 };
  
  public static int a(String paramString)
  {
    int i = b(paramString);
    if (i != 3)
    {
      if (i != 6)
      {
        if (i != 8) {
          return 0;
        }
        return 270;
      }
      return 90;
    }
    return 180;
  }
  
  private static int a(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i;
    if (paramBoolean) {
      i = paramArrayOfByte[0] << 8 & 0xFF00;
    }
    for (int j = paramArrayOfByte[1];; j = paramArrayOfByte[0])
    {
      return i | j & 0xFF;
      i = paramArrayOfByte[1] << 8 & 0xFF00;
    }
  }
  
  private static long a(InputStream paramInputStream, long paramLong)
  {
    long l1 = paramLong;
    while (l1 > 0L)
    {
      long l2 = paramInputStream.skip(l1);
      if (l2 > 0L) {
        l1 -= l2;
      } else if (l2 == 0L)
      {
        if (paramInputStream.read() != -1) {
          l1 -= 1L;
        }
      }
      else {
        throw new IOException("skip() return a negative value.");
      }
    }
    return paramLong - l1;
  }
  
  /* Error */
  public static int b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 52	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 8
    //   5: getstatic 54	com/tencent/biz/qqcircle/localphoto/scan/utils/JpegExifReader:a	Z
    //   8: istore 14
    //   10: aconst_null
    //   11: astore 15
    //   13: aconst_null
    //   14: astore 18
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 14
    //   20: ifne +41 -> 61
    //   23: new 56	android/media/ExifInterface
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 57	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   31: astore_0
    //   32: goto +15 -> 47
    //   35: astore_0
    //   36: ldc 59
    //   38: iconst_1
    //   39: ldc 61
    //   41: aload_0
    //   42: invokestatic 67	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   45: aconst_null
    //   46: astore_0
    //   47: aload_0
    //   48: ifnonnull +5 -> 53
    //   51: iconst_0
    //   52: ireturn
    //   53: aload_0
    //   54: ldc 69
    //   56: iconst_1
    //   57: invokevirtual 73	android/media/ExifInterface:getAttributeInt	(Ljava/lang/String;I)I
    //   60: ireturn
    //   61: new 75	java/io/BufferedInputStream
    //   64: dup
    //   65: new 77	java/io/FileInputStream
    //   68: dup
    //   69: aload_0
    //   70: invokespecial 78	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   73: sipush 512
    //   76: invokespecial 81	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   79: astore 16
    //   81: iconst_2
    //   82: newarray byte
    //   84: astore 19
    //   86: aload 16
    //   88: aload 19
    //   90: iconst_0
    //   91: iconst_2
    //   92: invokevirtual 84	java/io/BufferedInputStream:read	([BII)I
    //   95: istore_1
    //   96: iload_1
    //   97: iconst_2
    //   98: if_icmpne +36 -> 134
    //   101: aload 19
    //   103: iconst_0
    //   104: baload
    //   105: sipush 255
    //   108: iand
    //   109: sipush 255
    //   112: if_icmpne +22 -> 134
    //   115: aload 19
    //   117: iconst_1
    //   118: baload
    //   119: sipush 255
    //   122: iand
    //   123: sipush 216
    //   126: if_icmpne +8 -> 134
    //   129: iconst_1
    //   130: istore_1
    //   131: goto +5 -> 136
    //   134: iconst_0
    //   135: istore_1
    //   136: iload_1
    //   137: ifeq +1361 -> 1498
    //   140: iconst_4
    //   141: newarray byte
    //   143: astore 20
    //   145: ldc 86
    //   147: astore 15
    //   149: iconst_2
    //   150: istore_2
    //   151: iconst_1
    //   152: istore 5
    //   154: iload_2
    //   155: istore_1
    //   156: aload 16
    //   158: invokevirtual 87	java/io/BufferedInputStream:read	()I
    //   161: sipush 255
    //   164: iand
    //   165: i2b
    //   166: istore 6
    //   168: iload_2
    //   169: iconst_1
    //   170: iadd
    //   171: istore_2
    //   172: iload_2
    //   173: istore_1
    //   174: aload 16
    //   176: invokevirtual 87	java/io/BufferedInputStream:read	()I
    //   179: istore 4
    //   181: iload 4
    //   183: sipush 255
    //   186: iand
    //   187: i2b
    //   188: istore 7
    //   190: iload 7
    //   192: bipush 218
    //   194: if_icmpne +15 -> 209
    //   197: ldc 89
    //   199: astore 15
    //   201: iload_2
    //   202: istore_1
    //   203: iload 5
    //   205: istore_2
    //   206: goto +1300 -> 1506
    //   209: iload_2
    //   210: iconst_1
    //   211: iadd
    //   212: istore 4
    //   214: iload 4
    //   216: istore_1
    //   217: aload 16
    //   219: aload 19
    //   221: iload_3
    //   222: iconst_2
    //   223: invokevirtual 84	java/io/BufferedInputStream:read	([BII)I
    //   226: istore_2
    //   227: iload_2
    //   228: iconst_2
    //   229: if_icmpeq +19 -> 248
    //   232: ldc 91
    //   234: astore 15
    //   236: iload 5
    //   238: istore_2
    //   239: iload 4
    //   241: istore_1
    //   242: goto +1264 -> 1506
    //   245: goto +1333 -> 1578
    //   248: iload 4
    //   250: iconst_2
    //   251: iadd
    //   252: istore_2
    //   253: aload 19
    //   255: iload_3
    //   256: baload
    //   257: istore_1
    //   258: aload 19
    //   260: iconst_1
    //   261: baload
    //   262: sipush 255
    //   265: iand
    //   266: iload_1
    //   267: bipush 8
    //   269: ishl
    //   270: ldc 26
    //   272: iand
    //   273: ior
    //   274: iconst_2
    //   275: isub
    //   276: istore 4
    //   278: iload 6
    //   280: iconst_m1
    //   281: if_icmpne +38 -> 319
    //   284: iload 7
    //   286: bipush 224
    //   288: if_icmpne +31 -> 319
    //   291: iload 4
    //   293: i2l
    //   294: lstore 10
    //   296: iload_2
    //   297: istore_1
    //   298: aload 16
    //   300: lload 10
    //   302: invokestatic 93	com/tencent/biz/qqcircle/localphoto/scan/utils/JpegExifReader:a	(Ljava/io/InputStream;J)J
    //   305: lload 10
    //   307: lcmp
    //   308: ifne +1426 -> 1734
    //   311: iload_2
    //   312: iload 4
    //   314: iadd
    //   315: istore_2
    //   316: goto +1415 -> 1731
    //   319: iload 6
    //   321: iconst_m1
    //   322: if_icmpne +1419 -> 1741
    //   325: iload 7
    //   327: bipush 225
    //   329: if_icmpeq +1412 -> 1741
    //   332: iload 7
    //   334: bipush 225
    //   336: if_icmple +165 -> 501
    //   339: iload 7
    //   341: bipush 239
    //   343: if_icmpge +158 -> 501
    //   346: iload 4
    //   348: i2l
    //   349: lstore 10
    //   351: iload_2
    //   352: istore_1
    //   353: aload 16
    //   355: lload 10
    //   357: invokestatic 93	com/tencent/biz/qqcircle/localphoto/scan/utils/JpegExifReader:a	(Ljava/io/InputStream;J)J
    //   360: lstore 12
    //   362: lload 12
    //   364: lload 10
    //   366: lcmp
    //   367: ifne +77 -> 444
    //   370: iload_2
    //   371: istore_1
    //   372: new 95	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   379: astore 17
    //   381: iload_2
    //   382: istore_1
    //   383: aload 17
    //   385: aload 15
    //   387: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: iload_2
    //   392: istore_1
    //   393: aload 17
    //   395: ldc 102
    //   397: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: iload_2
    //   402: istore_1
    //   403: aload 17
    //   405: iload 7
    //   407: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: iload_2
    //   412: istore_1
    //   413: aload 17
    //   415: ldc 107
    //   417: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: iload_2
    //   422: istore_1
    //   423: aload 17
    //   425: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: astore 17
    //   430: iload_2
    //   431: iload 4
    //   433: iadd
    //   434: istore_2
    //   435: iconst_0
    //   436: istore_3
    //   437: aload 17
    //   439: astore 15
    //   441: goto +1290 -> 1731
    //   444: iload_2
    //   445: istore_1
    //   446: new 95	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   453: astore 17
    //   455: iload_2
    //   456: istore_1
    //   457: aload 17
    //   459: ldc 102
    //   461: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: iload_2
    //   466: istore_1
    //   467: aload 17
    //   469: iload 7
    //   471: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: iload_2
    //   476: istore_1
    //   477: aload 17
    //   479: ldc 113
    //   481: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: iload_2
    //   486: istore_1
    //   487: aload 17
    //   489: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: astore 17
    //   494: aload 17
    //   496: astore 15
    //   498: goto +964 -> 1462
    //   501: iload_2
    //   502: istore_1
    //   503: new 95	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   510: astore 17
    //   512: iload_2
    //   513: istore_1
    //   514: aload 17
    //   516: ldc 115
    //   518: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: pop
    //   522: iload_2
    //   523: istore_1
    //   524: aload 17
    //   526: iload 7
    //   528: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: iload_2
    //   533: istore_1
    //   534: aload 17
    //   536: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: astore 17
    //   541: aload 17
    //   543: astore 15
    //   545: goto +917 -> 1462
    //   548: iload_2
    //   549: istore_1
    //   550: aload 16
    //   552: aload 20
    //   554: iconst_0
    //   555: iconst_4
    //   556: invokevirtual 84	java/io/BufferedInputStream:read	([BII)I
    //   559: iconst_4
    //   560: if_icmpeq +10 -> 570
    //   563: ldc 117
    //   565: astore 15
    //   567: goto +895 -> 1462
    //   570: iload_2
    //   571: istore_1
    //   572: ldc 119
    //   574: new 121	java/lang/String
    //   577: dup
    //   578: aload 20
    //   580: invokespecial 124	java/lang/String:<init>	([B)V
    //   583: invokevirtual 128	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   586: ifne +10 -> 596
    //   589: ldc 130
    //   591: astore 15
    //   593: goto +869 -> 1462
    //   596: iload_2
    //   597: istore_1
    //   598: aload 16
    //   600: ldc2_w 131
    //   603: invokevirtual 133	java/io/BufferedInputStream:skip	(J)J
    //   606: ldc2_w 131
    //   609: lcmp
    //   610: ifeq +10 -> 620
    //   613: ldc 135
    //   615: astore 15
    //   617: goto +845 -> 1462
    //   620: iload_2
    //   621: iconst_2
    //   622: iadd
    //   623: istore_2
    //   624: iload_2
    //   625: istore_1
    //   626: aload 16
    //   628: aload 19
    //   630: iconst_0
    //   631: iconst_2
    //   632: invokevirtual 84	java/io/BufferedInputStream:read	([BII)I
    //   635: iconst_2
    //   636: if_icmpeq +10 -> 646
    //   639: ldc 137
    //   641: astore 15
    //   643: goto +1114 -> 1757
    //   646: iload_2
    //   647: iconst_2
    //   648: iadd
    //   649: istore_2
    //   650: iload_2
    //   651: istore_1
    //   652: new 121	java/lang/String
    //   655: dup
    //   656: aload 19
    //   658: invokespecial 124	java/lang/String:<init>	([B)V
    //   661: astore 17
    //   663: iload_2
    //   664: istore_1
    //   665: ldc 139
    //   667: aload 17
    //   669: invokevirtual 128	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   672: ifeq +9 -> 681
    //   675: iconst_1
    //   676: istore 14
    //   678: goto +18 -> 696
    //   681: iload_2
    //   682: istore_1
    //   683: ldc 141
    //   685: aload 17
    //   687: invokevirtual 128	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   690: ifeq +706 -> 1396
    //   693: iconst_0
    //   694: istore 14
    //   696: iload_2
    //   697: istore_1
    //   698: aload 16
    //   700: ldc2_w 131
    //   703: invokestatic 93	com/tencent/biz/qqcircle/localphoto/scan/utils/JpegExifReader:a	(Ljava/io/InputStream;J)J
    //   706: ldc2_w 131
    //   709: lcmp
    //   710: ifeq +10 -> 720
    //   713: ldc 143
    //   715: astore 15
    //   717: goto +1040 -> 1757
    //   720: iload_2
    //   721: istore_1
    //   722: aload 16
    //   724: aload 20
    //   726: iconst_0
    //   727: iconst_4
    //   728: invokevirtual 84	java/io/BufferedInputStream:read	([BII)I
    //   731: iconst_4
    //   732: if_icmpeq +10 -> 742
    //   735: ldc 145
    //   737: astore 15
    //   739: goto +1018 -> 1757
    //   742: iload_2
    //   743: bipush 6
    //   745: iadd
    //   746: istore_2
    //   747: iload_2
    //   748: istore_1
    //   749: aload 15
    //   751: astore 18
    //   753: iload 14
    //   755: aload 20
    //   757: invokestatic 148	com/tencent/biz/qqcircle/localphoto/scan/utils/JpegExifReader:d	(Z[B)I
    //   760: bipush 8
    //   762: isub
    //   763: istore_3
    //   764: iload_3
    //   765: ifle +35 -> 800
    //   768: iload_3
    //   769: i2l
    //   770: lstore 10
    //   772: iload_2
    //   773: istore_1
    //   774: aload 15
    //   776: astore 18
    //   778: aload 16
    //   780: lload 10
    //   782: invokestatic 93	com/tencent/biz/qqcircle/localphoto/scan/utils/JpegExifReader:a	(Ljava/io/InputStream;J)J
    //   785: lload 10
    //   787: lcmp
    //   788: ifeq +12 -> 800
    //   791: ldc 150
    //   793: astore 15
    //   795: iload_2
    //   796: istore_1
    //   797: goto +965 -> 1762
    //   800: iload_2
    //   801: istore_1
    //   802: aload 15
    //   804: astore 18
    //   806: aload 16
    //   808: aload 19
    //   810: iconst_0
    //   811: iconst_2
    //   812: invokevirtual 84	java/io/BufferedInputStream:read	([BII)I
    //   815: iconst_2
    //   816: if_icmpeq +12 -> 828
    //   819: ldc 152
    //   821: astore 15
    //   823: iload_2
    //   824: istore_1
    //   825: goto +937 -> 1762
    //   828: iload_2
    //   829: iload_3
    //   830: iconst_2
    //   831: iadd
    //   832: iadd
    //   833: istore_2
    //   834: iload_2
    //   835: istore_1
    //   836: aload 15
    //   838: astore 18
    //   840: iload 14
    //   842: aload 19
    //   844: invokestatic 154	com/tencent/biz/qqcircle/localphoto/scan/utils/JpegExifReader:a	(Z[B)I
    //   847: istore 4
    //   849: iconst_0
    //   850: istore_3
    //   851: iload_3
    //   852: iload 4
    //   854: if_icmpge +514 -> 1368
    //   857: iload_2
    //   858: istore_1
    //   859: aload 16
    //   861: aload 19
    //   863: iconst_0
    //   864: iconst_2
    //   865: invokevirtual 84	java/io/BufferedInputStream:read	([BII)I
    //   868: iconst_2
    //   869: if_icmpeq +10 -> 879
    //   872: ldc 156
    //   874: astore 15
    //   876: goto +881 -> 1757
    //   879: iload_2
    //   880: iconst_2
    //   881: iadd
    //   882: istore_2
    //   883: iload_2
    //   884: istore_1
    //   885: iload 14
    //   887: aload 19
    //   889: invokestatic 154	com/tencent/biz/qqcircle/localphoto/scan/utils/JpegExifReader:a	(Z[B)I
    //   892: sipush 274
    //   895: if_icmpne +437 -> 1332
    //   898: iload_2
    //   899: istore_1
    //   900: aload 16
    //   902: aload 19
    //   904: iconst_0
    //   905: iconst_2
    //   906: invokevirtual 84	java/io/BufferedInputStream:read	([BII)I
    //   909: iconst_2
    //   910: if_icmpeq +10 -> 920
    //   913: ldc 158
    //   915: astore 15
    //   917: goto +840 -> 1757
    //   920: iload_2
    //   921: iconst_2
    //   922: iadd
    //   923: istore_2
    //   924: iload_2
    //   925: istore_1
    //   926: aload 15
    //   928: astore 18
    //   930: iload 14
    //   932: aload 19
    //   934: invokestatic 154	com/tencent/biz/qqcircle/localphoto/scan/utils/JpegExifReader:a	(Z[B)I
    //   937: istore_3
    //   938: iload_2
    //   939: istore_1
    //   940: aload 15
    //   942: astore 18
    //   944: aload 16
    //   946: aload 20
    //   948: iconst_0
    //   949: iconst_4
    //   950: invokevirtual 84	java/io/BufferedInputStream:read	([BII)I
    //   953: iconst_4
    //   954: if_icmpeq +12 -> 966
    //   957: ldc 160
    //   959: astore 15
    //   961: iload_2
    //   962: istore_1
    //   963: goto +799 -> 1762
    //   966: iload_2
    //   967: iconst_4
    //   968: iadd
    //   969: istore_2
    //   970: iload_2
    //   971: istore_1
    //   972: aload 15
    //   974: astore 18
    //   976: iload 14
    //   978: aload 20
    //   980: invokestatic 148	com/tencent/biz/qqcircle/localphoto/scan/utils/JpegExifReader:d	(Z[B)I
    //   983: getstatic 17	com/tencent/biz/qqcircle/localphoto/scan/utils/JpegExifReader:b	[B
    //   986: iload_3
    //   987: baload
    //   988: imul
    //   989: istore 4
    //   991: iload 4
    //   993: iconst_4
    //   994: if_icmple +89 -> 1083
    //   997: iload_2
    //   998: istore_1
    //   999: aload 15
    //   1001: astore 18
    //   1003: new 95	java/lang/StringBuilder
    //   1006: dup
    //   1007: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1010: astore 17
    //   1012: iload_2
    //   1013: istore_1
    //   1014: aload 15
    //   1016: astore 18
    //   1018: aload 17
    //   1020: ldc 162
    //   1022: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: pop
    //   1026: iload_2
    //   1027: istore_1
    //   1028: aload 15
    //   1030: astore 18
    //   1032: aload 17
    //   1034: iload_3
    //   1035: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1038: pop
    //   1039: iload_2
    //   1040: istore_1
    //   1041: aload 15
    //   1043: astore 18
    //   1045: aload 17
    //   1047: ldc 164
    //   1049: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: pop
    //   1053: iload_2
    //   1054: istore_1
    //   1055: aload 15
    //   1057: astore 18
    //   1059: aload 17
    //   1061: iload 4
    //   1063: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1066: pop
    //   1067: iload_2
    //   1068: istore_1
    //   1069: aload 15
    //   1071: astore 18
    //   1073: aload 17
    //   1075: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1078: astore 15
    //   1080: goto +288 -> 1368
    //   1083: iload_2
    //   1084: istore_1
    //   1085: aload 15
    //   1087: astore 18
    //   1089: aload 16
    //   1091: aload 20
    //   1093: iconst_0
    //   1094: iconst_4
    //   1095: invokevirtual 84	java/io/BufferedInputStream:read	([BII)I
    //   1098: iconst_4
    //   1099: if_icmpeq +12 -> 1111
    //   1102: ldc 166
    //   1104: astore 15
    //   1106: iload_2
    //   1107: istore_1
    //   1108: goto +654 -> 1762
    //   1111: iload_2
    //   1112: iconst_4
    //   1113: iadd
    //   1114: istore_2
    //   1115: iload_3
    //   1116: iconst_3
    //   1117: if_icmpeq +144 -> 1261
    //   1120: iload_3
    //   1121: iconst_4
    //   1122: if_icmpeq +119 -> 1241
    //   1125: iload_3
    //   1126: bipush 6
    //   1128: if_icmpeq +637 -> 1765
    //   1131: iload_3
    //   1132: bipush 8
    //   1134: if_icmpeq +88 -> 1222
    //   1137: iload_3
    //   1138: bipush 9
    //   1140: if_icmpeq +63 -> 1203
    //   1143: iload_2
    //   1144: istore_1
    //   1145: aload 15
    //   1147: astore 18
    //   1149: new 95	java/lang/StringBuilder
    //   1152: dup
    //   1153: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1156: astore 17
    //   1158: iload_2
    //   1159: istore_1
    //   1160: aload 15
    //   1162: astore 18
    //   1164: aload 17
    //   1166: ldc 168
    //   1168: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1171: pop
    //   1172: iload_2
    //   1173: istore_1
    //   1174: aload 15
    //   1176: astore 18
    //   1178: aload 17
    //   1180: iload_3
    //   1181: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1184: pop
    //   1185: iload_2
    //   1186: istore_1
    //   1187: aload 15
    //   1189: astore 18
    //   1191: aload 17
    //   1193: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1196: astore 15
    //   1198: iconst_1
    //   1199: istore_1
    //   1200: goto +77 -> 1277
    //   1203: iload_2
    //   1204: istore_1
    //   1205: aload 15
    //   1207: astore 18
    //   1209: iload 14
    //   1211: aload 20
    //   1213: invokestatic 148	com/tencent/biz/qqcircle/localphoto/scan/utils/JpegExifReader:d	(Z[B)I
    //   1216: istore_3
    //   1217: iload_3
    //   1218: istore_1
    //   1219: goto +58 -> 1277
    //   1222: iload_2
    //   1223: istore_1
    //   1224: aload 15
    //   1226: astore 18
    //   1228: iload 14
    //   1230: aload 20
    //   1232: invokestatic 171	com/tencent/biz/qqcircle/localphoto/scan/utils/JpegExifReader:b	(Z[B)S
    //   1235: istore_3
    //   1236: iload_3
    //   1237: istore_1
    //   1238: goto +39 -> 1277
    //   1241: iload_2
    //   1242: istore_1
    //   1243: aload 15
    //   1245: astore 18
    //   1247: iload 14
    //   1249: aload 20
    //   1251: invokestatic 175	com/tencent/biz/qqcircle/localphoto/scan/utils/JpegExifReader:c	(Z[B)J
    //   1254: l2i
    //   1255: istore_3
    //   1256: iload_3
    //   1257: istore_1
    //   1258: goto +19 -> 1277
    //   1261: iload_2
    //   1262: istore_1
    //   1263: aload 15
    //   1265: astore 18
    //   1267: iload 14
    //   1269: aload 20
    //   1271: invokestatic 154	com/tencent/biz/qqcircle/localphoto/scan/utils/JpegExifReader:a	(Z[B)I
    //   1274: istore_3
    //   1275: iload_3
    //   1276: istore_1
    //   1277: invokestatic 179	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1280: ifeq +38 -> 1318
    //   1283: new 95	java/lang/StringBuilder
    //   1286: dup
    //   1287: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1290: astore 17
    //   1292: aload 17
    //   1294: ldc 181
    //   1296: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: pop
    //   1300: aload 17
    //   1302: iload_1
    //   1303: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1306: pop
    //   1307: ldc 59
    //   1309: iconst_4
    //   1310: aload 17
    //   1312: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1315: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1318: iload_2
    //   1319: istore_3
    //   1320: iload_1
    //   1321: istore_2
    //   1322: iload_3
    //   1323: istore_1
    //   1324: goto +182 -> 1506
    //   1327: astore 17
    //   1329: goto -1084 -> 245
    //   1332: iload_2
    //   1333: istore_1
    //   1334: aload 16
    //   1336: ldc2_w 185
    //   1339: invokestatic 93	com/tencent/biz/qqcircle/localphoto/scan/utils/JpegExifReader:a	(Ljava/io/InputStream;J)J
    //   1342: ldc2_w 185
    //   1345: lcmp
    //   1346: ifeq +10 -> 1356
    //   1349: ldc 188
    //   1351: astore 15
    //   1353: goto +404 -> 1757
    //   1356: iload_2
    //   1357: bipush 10
    //   1359: iadd
    //   1360: istore_2
    //   1361: iload_3
    //   1362: iconst_1
    //   1363: iadd
    //   1364: istore_3
    //   1365: goto -514 -> 851
    //   1368: iload_2
    //   1369: istore_1
    //   1370: aload 15
    //   1372: astore 18
    //   1374: ldc 59
    //   1376: iconst_4
    //   1377: ldc 190
    //   1379: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1382: iload_2
    //   1383: istore_1
    //   1384: goto +378 -> 1762
    //   1387: astore 17
    //   1389: aload 18
    //   1391: astore 15
    //   1393: goto +78 -> 1471
    //   1396: iload_2
    //   1397: istore_1
    //   1398: new 95	java/lang/StringBuilder
    //   1401: dup
    //   1402: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1405: astore 18
    //   1407: iload_2
    //   1408: istore_1
    //   1409: aload 18
    //   1411: ldc 192
    //   1413: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1416: pop
    //   1417: iload_2
    //   1418: istore_1
    //   1419: aload 18
    //   1421: aload 17
    //   1423: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1426: pop
    //   1427: iload_2
    //   1428: istore_1
    //   1429: aload 18
    //   1431: ldc 194
    //   1433: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: pop
    //   1437: iload_2
    //   1438: istore_1
    //   1439: aload 18
    //   1441: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1444: astore 17
    //   1446: aload 17
    //   1448: astore 15
    //   1450: goto +307 -> 1757
    //   1453: astore 17
    //   1455: goto +16 -> 1471
    //   1458: ldc 196
    //   1460: astore 15
    //   1462: iload_2
    //   1463: istore_1
    //   1464: iconst_1
    //   1465: istore_2
    //   1466: goto +40 -> 1506
    //   1469: astore 17
    //   1471: iload_1
    //   1472: istore_2
    //   1473: goto +7 -> 1480
    //   1476: astore 17
    //   1478: iload_1
    //   1479: istore_2
    //   1480: iconst_1
    //   1481: istore_1
    //   1482: goto +96 -> 1578
    //   1485: astore 17
    //   1487: ldc 86
    //   1489: astore 15
    //   1491: iconst_1
    //   1492: istore_1
    //   1493: iconst_2
    //   1494: istore_2
    //   1495: goto +83 -> 1578
    //   1498: ldc 86
    //   1500: astore 15
    //   1502: iconst_1
    //   1503: istore_2
    //   1504: iconst_2
    //   1505: istore_1
    //   1506: aload 16
    //   1508: invokevirtual 199	java/io/BufferedInputStream:close	()V
    //   1511: iload_2
    //   1512: istore_3
    //   1513: iload_1
    //   1514: istore 4
    //   1516: aload 15
    //   1518: astore 17
    //   1520: goto +112 -> 1632
    //   1523: astore 16
    //   1525: iload_2
    //   1526: istore_3
    //   1527: ldc 59
    //   1529: iconst_1
    //   1530: ldc 86
    //   1532: aload 16
    //   1534: invokestatic 67	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1537: iload_1
    //   1538: istore 4
    //   1540: aload 15
    //   1542: astore 17
    //   1544: goto +88 -> 1632
    //   1547: astore_0
    //   1548: goto +150 -> 1698
    //   1551: astore 17
    //   1553: goto +17 -> 1570
    //   1556: astore_0
    //   1557: aload 18
    //   1559: astore 16
    //   1561: goto +137 -> 1698
    //   1564: astore 17
    //   1566: aload 15
    //   1568: astore 16
    //   1570: ldc 86
    //   1572: astore 15
    //   1574: iconst_1
    //   1575: istore_1
    //   1576: iconst_0
    //   1577: istore_2
    //   1578: aload 16
    //   1580: astore 18
    //   1582: ldc 59
    //   1584: iconst_1
    //   1585: ldc 86
    //   1587: aload 17
    //   1589: invokestatic 67	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1592: iload_1
    //   1593: istore_3
    //   1594: iload_2
    //   1595: istore 4
    //   1597: aload 15
    //   1599: astore 17
    //   1601: aload 16
    //   1603: ifnull +29 -> 1632
    //   1606: aload 16
    //   1608: invokevirtual 199	java/io/BufferedInputStream:close	()V
    //   1611: iload_1
    //   1612: istore_3
    //   1613: iload_2
    //   1614: istore 4
    //   1616: aload 15
    //   1618: astore 17
    //   1620: goto +12 -> 1632
    //   1623: astore 16
    //   1625: iload_1
    //   1626: istore_3
    //   1627: iload_2
    //   1628: istore_1
    //   1629: goto -102 -> 1527
    //   1632: invokestatic 179	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1635: ifeq +61 -> 1696
    //   1638: invokestatic 52	android/os/SystemClock:uptimeMillis	()J
    //   1641: lstore 10
    //   1643: ldc 59
    //   1645: iconst_4
    //   1646: getstatic 205	java/util/Locale:CHINESE	Ljava/util/Locale;
    //   1649: ldc 207
    //   1651: iconst_5
    //   1652: anewarray 4	java/lang/Object
    //   1655: dup
    //   1656: iconst_0
    //   1657: iload_3
    //   1658: invokestatic 213	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1661: aastore
    //   1662: dup
    //   1663: iconst_1
    //   1664: iload 4
    //   1666: invokestatic 213	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1669: aastore
    //   1670: dup
    //   1671: iconst_2
    //   1672: lload 10
    //   1674: lload 8
    //   1676: lsub
    //   1677: invokestatic 218	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1680: aastore
    //   1681: dup
    //   1682: iconst_3
    //   1683: aload_0
    //   1684: aastore
    //   1685: dup
    //   1686: iconst_4
    //   1687: aload 17
    //   1689: aastore
    //   1690: invokestatic 222	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1693: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1696: iload_3
    //   1697: ireturn
    //   1698: aload 16
    //   1700: ifnull +23 -> 1723
    //   1703: aload 16
    //   1705: invokevirtual 199	java/io/BufferedInputStream:close	()V
    //   1708: goto +15 -> 1723
    //   1711: astore 15
    //   1713: ldc 59
    //   1715: iconst_1
    //   1716: ldc 86
    //   1718: aload 15
    //   1720: invokestatic 67	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1723: goto +5 -> 1728
    //   1726: aload_0
    //   1727: athrow
    //   1728: goto -2 -> 1726
    //   1731: goto -1580 -> 151
    //   1734: ldc 224
    //   1736: astore 15
    //   1738: goto -276 -> 1462
    //   1741: iload 6
    //   1743: iconst_m1
    //   1744: if_icmpne -286 -> 1458
    //   1747: iload 7
    //   1749: bipush 225
    //   1751: if_icmpeq -1203 -> 548
    //   1754: goto -296 -> 1458
    //   1757: iload_2
    //   1758: istore_1
    //   1759: goto -295 -> 1464
    //   1762: goto -298 -> 1464
    //   1765: aload 20
    //   1767: iconst_0
    //   1768: baload
    //   1769: istore_1
    //   1770: goto -493 -> 1277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1773	0	paramString	String
    //   95	1675	1	i	int
    //   150	1608	2	j	int
    //   17	1680	3	k	int
    //   179	1486	4	m	int
    //   152	85	5	n	int
    //   166	1579	6	i1	int
    //   188	1564	7	i2	int
    //   3	1672	8	l1	long
    //   294	1379	10	l2	long
    //   360	3	12	l3	long
    //   8	1260	14	bool	boolean
    //   11	1606	15	localObject1	Object
    //   1711	8	15	localIOException1	IOException
    //   1736	1	15	str1	String
    //   79	1428	16	localBufferedInputStream	java.io.BufferedInputStream
    //   1523	10	16	localIOException2	IOException
    //   1559	48	16	localObject2	Object
    //   1623	81	16	localIOException3	IOException
    //   379	932	17	localObject3	Object
    //   1327	1	17	localThrowable1	java.lang.Throwable
    //   1387	35	17	localThrowable2	java.lang.Throwable
    //   1444	3	17	str2	String
    //   1453	1	17	localThrowable3	java.lang.Throwable
    //   1469	1	17	localThrowable4	java.lang.Throwable
    //   1476	1	17	localThrowable5	java.lang.Throwable
    //   1485	1	17	localThrowable6	java.lang.Throwable
    //   1518	25	17	localObject4	Object
    //   1551	1	17	localThrowable7	java.lang.Throwable
    //   1564	24	17	localThrowable8	java.lang.Throwable
    //   1599	89	17	localObject5	Object
    //   14	1567	18	localObject6	Object
    //   84	849	19	arrayOfByte1	byte[]
    //   143	1623	20	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   23	32	35	java/io/IOException
    //   1277	1318	1327	java/lang/Throwable
    //   753	764	1387	java/lang/Throwable
    //   778	791	1387	java/lang/Throwable
    //   806	819	1387	java/lang/Throwable
    //   840	849	1387	java/lang/Throwable
    //   930	938	1387	java/lang/Throwable
    //   944	957	1387	java/lang/Throwable
    //   976	991	1387	java/lang/Throwable
    //   1003	1012	1387	java/lang/Throwable
    //   1018	1026	1387	java/lang/Throwable
    //   1032	1039	1387	java/lang/Throwable
    //   1045	1053	1387	java/lang/Throwable
    //   1059	1067	1387	java/lang/Throwable
    //   1073	1080	1387	java/lang/Throwable
    //   1089	1102	1387	java/lang/Throwable
    //   1149	1158	1387	java/lang/Throwable
    //   1164	1172	1387	java/lang/Throwable
    //   1178	1185	1387	java/lang/Throwable
    //   1191	1198	1387	java/lang/Throwable
    //   1209	1217	1387	java/lang/Throwable
    //   1228	1236	1387	java/lang/Throwable
    //   1247	1256	1387	java/lang/Throwable
    //   1267	1275	1387	java/lang/Throwable
    //   1374	1382	1387	java/lang/Throwable
    //   626	639	1453	java/lang/Throwable
    //   652	663	1453	java/lang/Throwable
    //   665	675	1453	java/lang/Throwable
    //   683	693	1453	java/lang/Throwable
    //   698	713	1453	java/lang/Throwable
    //   722	735	1453	java/lang/Throwable
    //   859	872	1453	java/lang/Throwable
    //   885	898	1453	java/lang/Throwable
    //   900	913	1453	java/lang/Throwable
    //   1334	1349	1453	java/lang/Throwable
    //   1398	1407	1453	java/lang/Throwable
    //   1409	1417	1453	java/lang/Throwable
    //   1419	1427	1453	java/lang/Throwable
    //   1429	1437	1453	java/lang/Throwable
    //   1439	1446	1453	java/lang/Throwable
    //   217	227	1469	java/lang/Throwable
    //   298	311	1469	java/lang/Throwable
    //   353	362	1469	java/lang/Throwable
    //   372	381	1469	java/lang/Throwable
    //   383	391	1469	java/lang/Throwable
    //   393	401	1469	java/lang/Throwable
    //   403	411	1469	java/lang/Throwable
    //   413	421	1469	java/lang/Throwable
    //   423	430	1469	java/lang/Throwable
    //   446	455	1469	java/lang/Throwable
    //   457	465	1469	java/lang/Throwable
    //   467	475	1469	java/lang/Throwable
    //   477	485	1469	java/lang/Throwable
    //   487	494	1469	java/lang/Throwable
    //   503	512	1469	java/lang/Throwable
    //   514	522	1469	java/lang/Throwable
    //   524	532	1469	java/lang/Throwable
    //   534	541	1469	java/lang/Throwable
    //   550	563	1469	java/lang/Throwable
    //   572	589	1469	java/lang/Throwable
    //   598	613	1469	java/lang/Throwable
    //   156	168	1476	java/lang/Throwable
    //   174	181	1476	java/lang/Throwable
    //   140	145	1485	java/lang/Throwable
    //   1506	1511	1523	java/io/IOException
    //   81	96	1547	finally
    //   140	145	1547	finally
    //   156	168	1547	finally
    //   174	181	1547	finally
    //   217	227	1547	finally
    //   298	311	1547	finally
    //   353	362	1547	finally
    //   372	381	1547	finally
    //   383	391	1547	finally
    //   393	401	1547	finally
    //   403	411	1547	finally
    //   413	421	1547	finally
    //   423	430	1547	finally
    //   446	455	1547	finally
    //   457	465	1547	finally
    //   467	475	1547	finally
    //   477	485	1547	finally
    //   487	494	1547	finally
    //   503	512	1547	finally
    //   514	522	1547	finally
    //   524	532	1547	finally
    //   534	541	1547	finally
    //   550	563	1547	finally
    //   572	589	1547	finally
    //   598	613	1547	finally
    //   626	639	1547	finally
    //   652	663	1547	finally
    //   665	675	1547	finally
    //   683	693	1547	finally
    //   698	713	1547	finally
    //   722	735	1547	finally
    //   753	764	1547	finally
    //   778	791	1547	finally
    //   806	819	1547	finally
    //   840	849	1547	finally
    //   859	872	1547	finally
    //   885	898	1547	finally
    //   900	913	1547	finally
    //   930	938	1547	finally
    //   944	957	1547	finally
    //   976	991	1547	finally
    //   1003	1012	1547	finally
    //   1018	1026	1547	finally
    //   1032	1039	1547	finally
    //   1045	1053	1547	finally
    //   1059	1067	1547	finally
    //   1073	1080	1547	finally
    //   1089	1102	1547	finally
    //   1149	1158	1547	finally
    //   1164	1172	1547	finally
    //   1178	1185	1547	finally
    //   1191	1198	1547	finally
    //   1209	1217	1547	finally
    //   1228	1236	1547	finally
    //   1247	1256	1547	finally
    //   1267	1275	1547	finally
    //   1277	1318	1547	finally
    //   1334	1349	1547	finally
    //   1374	1382	1547	finally
    //   1398	1407	1547	finally
    //   1409	1417	1547	finally
    //   1419	1427	1547	finally
    //   1429	1437	1547	finally
    //   1439	1446	1547	finally
    //   81	96	1551	java/lang/Throwable
    //   61	81	1556	finally
    //   1582	1592	1556	finally
    //   61	81	1564	java/lang/Throwable
    //   1606	1611	1623	java/io/IOException
    //   1703	1708	1711	java/io/IOException
  }
  
  private static short b(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i;
    if (paramBoolean) {
      i = paramArrayOfByte[0] & 0xFF00;
    }
    for (int j = paramArrayOfByte[1];; j = paramArrayOfByte[0])
    {
      return (short)(i | j & 0xFF);
      i = paramArrayOfByte[1] & 0xFF00;
    }
  }
  
  private static long c(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    long l;
    if (paramBoolean) {
      l = paramArrayOfByte[0] << 24 & 0xFF000000 | 0xFF0000 & paramArrayOfByte[1] << 16 | 0xFF00 & paramArrayOfByte[2] << 8;
    }
    for (int i = paramArrayOfByte[3];; i = paramArrayOfByte[0])
    {
      return l | i & 0xFF;
      l = paramArrayOfByte[3] << 24 & 0xFF000000 | 0xFF0000 & paramArrayOfByte[2] << 16 | 0xFF00 & paramArrayOfByte[1] << 8;
    }
  }
  
  private static int d(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i;
    if (paramBoolean) {
      i = paramArrayOfByte[0] << 24 & 0xFF000000 | paramArrayOfByte[1] << 16 & 0xFF0000 | paramArrayOfByte[2] << 8 & 0xFF00;
    }
    for (int j = paramArrayOfByte[3];; j = paramArrayOfByte[0])
    {
      return i | j & 0xFF;
      i = paramArrayOfByte[3] << 24 & 0xFF000000 | 0xFF0000 & paramArrayOfByte[2] << 16 | 0xFF00 & paramArrayOfByte[1] << 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.utils.JpegExifReader
 * JD-Core Version:    0.7.0.1
 */