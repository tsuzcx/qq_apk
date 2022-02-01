package com.tencent.image;

import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
import java.io.IOException;
import java.io.InputStream;

public class JpegExifReader
{
  private static final String BIG_ENDIAN_BYTE_ORDER = "MM";
  private static final byte[] BYTES_PER_FORMAT = { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8 };
  private static final int DIRECTORY_LENGTH = 12;
  private static final byte E0 = -32;
  private static final byte E1 = -31;
  private static final byte E15 = -17;
  private static final String EXIF = "EXIF";
  private static final int EXPOSURE_TIME_TAG = 33434;
  private static final byte FF = -1;
  private static final String LITTLE_ENDIAN_BYTE_ORDER = "II";
  private static final int ORIENTATION_TAG = 274;
  private static final String REPORT_ACTION = "actReadJpegOrientation";
  private static final byte SEGMENTS_END = -38;
  private static final int SUB_IFD_OFFSET_TAG = 34665;
  private static final String TAG = "JpegExifReader";
  private static final int TIFF_HEADER_OFFSET = 6;
  public static JpegExifReader.JpegExifReaderInterface jpegExifReaderInterface;
  private static boolean sIsEnable = true;
  private static boolean sIsReadDpc = false;
  
  private static short getInt16(boolean paramBoolean, byte[] paramArrayOfByte)
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
  
  private static int getInt32(boolean paramBoolean, byte[] paramArrayOfByte)
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
  
  public static int getRotationDegree(String paramString)
  {
    int i = readOrientation(paramString);
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
  
  private static int getUnsignedInt16(boolean paramBoolean, byte[] paramArrayOfByte)
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
  
  private static long getUnsignedInt32(boolean paramBoolean, byte[] paramArrayOfByte)
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
  
  private static long getValue(int paramInt, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (paramInt != 3)
    {
      if (paramInt != 4)
      {
        if (paramInt != 6)
        {
          if (paramInt != 8)
          {
            if (paramInt != 9)
            {
              if (URLDrawable.depImp.mLog.isColorLevel())
              {
                paramArrayOfByte = URLDrawable.depImp.mLog;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("get value format code: ");
                localStringBuilder.append(paramInt);
                paramArrayOfByte.e("JpegExifReader", 2, localStringBuilder.toString());
              }
              return 0L;
            }
            paramInt = getInt32(paramBoolean, paramArrayOfByte);
          }
          else
          {
            paramInt = getInt16(paramBoolean, paramArrayOfByte);
          }
        }
        else {
          paramInt = paramArrayOfByte[0];
        }
      }
      else {
        return getUnsignedInt32(paramBoolean, paramArrayOfByte);
      }
    }
    else {
      paramInt = getUnsignedInt16(paramBoolean, paramArrayOfByte);
    }
    return paramInt;
  }
  
  public static void initJpegExifReader(JpegExifReader.JpegExifReaderInterface paramJpegExifReaderInterface)
  {
    jpegExifReaderInterface = paramJpegExifReaderInterface;
  }
  
  /* Error */
  public static boolean isCrashJpeg(String paramString)
  {
    // Byte code:
    //   0: ldc 148
    //   2: astore 16
    //   4: getstatic 153	android/os/Build$VERSION:SDK_INT	I
    //   7: istore_1
    //   8: iconst_0
    //   9: istore 8
    //   11: iload_1
    //   12: bipush 24
    //   14: if_icmplt +5 -> 19
    //   17: iconst_0
    //   18: ireturn
    //   19: invokestatic 159	android/os/SystemClock:uptimeMillis	()J
    //   22: lstore 9
    //   24: aconst_null
    //   25: astore 13
    //   27: aconst_null
    //   28: astore 15
    //   30: new 161	java/io/BufferedInputStream
    //   33: dup
    //   34: new 163	java/io/FileInputStream
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 166	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   42: sipush 1024
    //   45: invokespecial 169	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   48: astore 14
    //   50: iconst_2
    //   51: newarray byte
    //   53: astore 15
    //   55: aload 14
    //   57: aload 15
    //   59: iconst_0
    //   60: iconst_2
    //   61: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   64: iconst_2
    //   65: if_icmpne +38 -> 103
    //   68: aload 15
    //   70: iconst_0
    //   71: baload
    //   72: sipush 255
    //   75: iand
    //   76: sipush 255
    //   79: if_icmpne +24 -> 103
    //   82: aload 15
    //   84: iconst_1
    //   85: baload
    //   86: istore_1
    //   87: iload_1
    //   88: sipush 255
    //   91: iand
    //   92: sipush 216
    //   95: if_icmpne +8 -> 103
    //   98: iconst_1
    //   99: istore_1
    //   100: goto +5 -> 105
    //   103: iconst_0
    //   104: istore_1
    //   105: ldc 175
    //   107: astore 13
    //   109: iload_1
    //   110: ifeq +1300 -> 1410
    //   113: iconst_4
    //   114: newarray byte
    //   116: astore 17
    //   118: iconst_2
    //   119: istore_2
    //   120: iload_2
    //   121: istore_1
    //   122: aload 14
    //   124: invokevirtual 178	java/io/BufferedInputStream:read	()I
    //   127: sipush 255
    //   130: iand
    //   131: i2b
    //   132: istore_3
    //   133: iload_2
    //   134: iconst_1
    //   135: iadd
    //   136: istore_2
    //   137: iload_2
    //   138: istore_1
    //   139: aload 14
    //   141: invokevirtual 178	java/io/BufferedInputStream:read	()I
    //   144: sipush 255
    //   147: iand
    //   148: i2b
    //   149: istore 4
    //   151: iload 4
    //   153: bipush 218
    //   155: if_icmpne +16 -> 171
    //   158: ldc 180
    //   160: astore 13
    //   162: iload_2
    //   163: istore_1
    //   164: iload 8
    //   166: istore 7
    //   168: goto +1251 -> 1419
    //   171: iload_2
    //   172: iconst_1
    //   173: iadd
    //   174: istore_1
    //   175: iload_1
    //   176: istore_2
    //   177: aload 14
    //   179: aload 15
    //   181: iconst_0
    //   182: iconst_2
    //   183: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   186: iconst_2
    //   187: if_icmpeq +10 -> 197
    //   190: ldc 182
    //   192: astore 13
    //   194: goto +1588 -> 1782
    //   197: iload_1
    //   198: iconst_2
    //   199: iadd
    //   200: istore_1
    //   201: aload 15
    //   203: iconst_0
    //   204: baload
    //   205: istore_2
    //   206: aload 15
    //   208: iconst_1
    //   209: baload
    //   210: sipush 255
    //   213: iand
    //   214: iload_2
    //   215: bipush 8
    //   217: ishl
    //   218: ldc 68
    //   220: iand
    //   221: ior
    //   222: iconst_2
    //   223: isub
    //   224: istore 5
    //   226: iload_3
    //   227: iconst_m1
    //   228: if_icmpne +1569 -> 1797
    //   231: iload 4
    //   233: bipush 224
    //   235: if_icmpne +1562 -> 1797
    //   238: iload 5
    //   240: i2l
    //   241: lstore 11
    //   243: iload_1
    //   244: istore_2
    //   245: aload 14
    //   247: lload 11
    //   249: invokestatic 186	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   252: lload 11
    //   254: lcmp
    //   255: ifne +1534 -> 1789
    //   258: iload_1
    //   259: iload 5
    //   261: iadd
    //   262: istore_2
    //   263: goto -143 -> 120
    //   266: iload_1
    //   267: istore_2
    //   268: aload 14
    //   270: aload 17
    //   272: iconst_0
    //   273: iconst_4
    //   274: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   277: iconst_4
    //   278: if_icmpeq +10 -> 288
    //   281: ldc 188
    //   283: astore 13
    //   285: goto +1497 -> 1782
    //   288: iload_1
    //   289: iconst_4
    //   290: iadd
    //   291: istore_2
    //   292: iload_2
    //   293: istore_1
    //   294: ldc 22
    //   296: new 190	java/lang/String
    //   299: dup
    //   300: aload 17
    //   302: invokespecial 193	java/lang/String:<init>	([B)V
    //   305: invokevirtual 196	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   308: ifne +12 -> 320
    //   311: ldc 198
    //   313: astore 13
    //   315: iload_2
    //   316: istore_1
    //   317: goto +1495 -> 1812
    //   320: iload_2
    //   321: istore_1
    //   322: aload 14
    //   324: ldc2_w 199
    //   327: invokevirtual 203	java/io/BufferedInputStream:skip	(J)J
    //   330: ldc2_w 199
    //   333: lcmp
    //   334: ifeq +12 -> 346
    //   337: ldc 205
    //   339: astore 13
    //   341: iload_2
    //   342: istore_1
    //   343: goto +1469 -> 1812
    //   346: iload_2
    //   347: iconst_2
    //   348: iadd
    //   349: istore_3
    //   350: iload_3
    //   351: istore_1
    //   352: aload 14
    //   354: aload 15
    //   356: iconst_0
    //   357: iconst_2
    //   358: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   361: iconst_2
    //   362: if_icmpeq +12 -> 374
    //   365: ldc 207
    //   367: astore 13
    //   369: iload_3
    //   370: istore_1
    //   371: goto +1441 -> 1812
    //   374: iload_3
    //   375: iconst_2
    //   376: iadd
    //   377: istore_1
    //   378: iload_1
    //   379: istore_2
    //   380: new 190	java/lang/String
    //   383: dup
    //   384: aload 15
    //   386: invokespecial 193	java/lang/String:<init>	([B)V
    //   389: astore 18
    //   391: iload_1
    //   392: istore_2
    //   393: ldc 8
    //   395: aload 18
    //   397: invokevirtual 196	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   400: ifeq +9 -> 409
    //   403: iconst_1
    //   404: istore 7
    //   406: goto +18 -> 424
    //   409: iload_1
    //   410: istore_2
    //   411: ldc 29
    //   413: aload 18
    //   415: invokevirtual 196	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   418: ifeq +856 -> 1274
    //   421: iconst_0
    //   422: istore 7
    //   424: iload_1
    //   425: istore_2
    //   426: aload 14
    //   428: ldc2_w 199
    //   431: invokestatic 186	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   434: ldc2_w 199
    //   437: lcmp
    //   438: ifeq +10 -> 448
    //   441: ldc 209
    //   443: astore 13
    //   445: goto +1374 -> 1819
    //   448: iload_1
    //   449: istore_2
    //   450: aload 14
    //   452: aload 17
    //   454: iconst_0
    //   455: iconst_4
    //   456: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   459: iconst_4
    //   460: if_icmpeq +10 -> 470
    //   463: ldc 211
    //   465: astore 13
    //   467: goto +1352 -> 1819
    //   470: iload_1
    //   471: bipush 6
    //   473: iadd
    //   474: istore_1
    //   475: iload_1
    //   476: istore_2
    //   477: iload 7
    //   479: aload 17
    //   481: invokestatic 130	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   484: istore 4
    //   486: iload 4
    //   488: bipush 8
    //   490: isub
    //   491: istore 4
    //   493: iload 4
    //   495: ifle +1334 -> 1829
    //   498: iload 4
    //   500: i2l
    //   501: lstore 11
    //   503: iload_1
    //   504: istore_2
    //   505: aload 14
    //   507: lload 11
    //   509: invokestatic 186	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   512: lload 11
    //   514: lcmp
    //   515: ifeq +1311 -> 1826
    //   518: ldc 213
    //   520: astore 13
    //   522: goto +22 -> 544
    //   525: iload_1
    //   526: istore_2
    //   527: aload 14
    //   529: aload 15
    //   531: iconst_0
    //   532: iconst_2
    //   533: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   536: iconst_2
    //   537: if_icmpeq +10 -> 547
    //   540: ldc 215
    //   542: astore 13
    //   544: goto +817 -> 1361
    //   547: iload_1
    //   548: iload 4
    //   550: iconst_2
    //   551: iadd
    //   552: iadd
    //   553: istore_2
    //   554: iload_2
    //   555: istore_1
    //   556: iload 7
    //   558: aload 15
    //   560: invokestatic 136	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   563: istore 5
    //   565: iload_2
    //   566: istore_1
    //   567: iconst_0
    //   568: istore 4
    //   570: iload 4
    //   572: iload 5
    //   574: if_icmpge +663 -> 1237
    //   577: iload_1
    //   578: istore_2
    //   579: aload 14
    //   581: aload 15
    //   583: iconst_0
    //   584: iconst_2
    //   585: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   588: iconst_2
    //   589: if_icmpeq +10 -> 599
    //   592: ldc 217
    //   594: astore 13
    //   596: goto -52 -> 544
    //   599: iload_1
    //   600: iconst_2
    //   601: iadd
    //   602: istore_1
    //   603: iload 7
    //   605: aload 15
    //   607: invokestatic 136	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   610: istore_2
    //   611: iload_2
    //   612: ldc 38
    //   614: if_icmpne +582 -> 1196
    //   617: aload 14
    //   619: aload 15
    //   621: iconst_0
    //   622: iconst_2
    //   623: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   626: iconst_2
    //   627: if_icmpeq +10 -> 637
    //   630: ldc 219
    //   632: astore 13
    //   634: goto +581 -> 1215
    //   637: iload_1
    //   638: iconst_2
    //   639: iadd
    //   640: istore_2
    //   641: iload_2
    //   642: istore_1
    //   643: iload 7
    //   645: aload 15
    //   647: invokestatic 136	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   650: istore 4
    //   652: iload_2
    //   653: istore_1
    //   654: aload 14
    //   656: aload 17
    //   658: iconst_0
    //   659: iconst_4
    //   660: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   663: iconst_4
    //   664: if_icmpeq +12 -> 676
    //   667: ldc 221
    //   669: astore 13
    //   671: iload_2
    //   672: istore_1
    //   673: goto +1159 -> 1832
    //   676: iload_2
    //   677: iconst_4
    //   678: iadd
    //   679: istore_2
    //   680: iload_2
    //   681: istore_1
    //   682: iload 7
    //   684: aload 17
    //   686: invokestatic 130	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   689: pop
    //   690: iload_2
    //   691: istore_1
    //   692: getstatic 57	com/tencent/image/JpegExifReader:BYTES_PER_FORMAT	[B
    //   695: iload 4
    //   697: baload
    //   698: istore 5
    //   700: iload_2
    //   701: istore_1
    //   702: aload 14
    //   704: aload 17
    //   706: iconst_0
    //   707: iconst_4
    //   708: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   711: iconst_4
    //   712: if_icmpeq +12 -> 724
    //   715: ldc 223
    //   717: astore 13
    //   719: iload_2
    //   720: istore_1
    //   721: goto +1111 -> 1832
    //   724: iload_2
    //   725: iconst_4
    //   726: iadd
    //   727: istore_2
    //   728: iload_2
    //   729: istore_1
    //   730: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   733: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   736: invokeinterface 108 1 0
    //   741: ifeq +61 -> 802
    //   744: iload_2
    //   745: istore_1
    //   746: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   749: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   752: astore 18
    //   754: iload_2
    //   755: istore_1
    //   756: new 110	java/lang/StringBuilder
    //   759: dup
    //   760: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   763: astore 19
    //   765: iload_2
    //   766: istore_1
    //   767: aload 19
    //   769: ldc 225
    //   771: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: pop
    //   775: iload_2
    //   776: istore_1
    //   777: aload 19
    //   779: iload 4
    //   781: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   784: pop
    //   785: iload_2
    //   786: istore_1
    //   787: aload 18
    //   789: ldc 41
    //   791: iconst_2
    //   792: aload 19
    //   794: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   797: invokeinterface 228 4 0
    //   802: iload_2
    //   803: istore_1
    //   804: iload 4
    //   806: iload 7
    //   808: aload 17
    //   810: invokestatic 230	com/tencent/image/JpegExifReader:getValue	(IZ[B)J
    //   813: iload_3
    //   814: i2l
    //   815: ladd
    //   816: iload_2
    //   817: i2l
    //   818: lsub
    //   819: lstore 11
    //   821: iload_2
    //   822: istore_1
    //   823: aload 14
    //   825: lload 11
    //   827: invokestatic 186	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   830: lload 11
    //   832: lcmp
    //   833: ifeq +12 -> 845
    //   836: ldc 232
    //   838: astore 13
    //   840: iload_2
    //   841: istore_1
    //   842: goto +990 -> 1832
    //   845: iload_2
    //   846: istore_1
    //   847: aload 14
    //   849: aload 15
    //   851: iconst_0
    //   852: iconst_2
    //   853: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   856: iconst_2
    //   857: if_icmpeq +12 -> 869
    //   860: ldc 234
    //   862: astore 13
    //   864: iload_2
    //   865: istore_1
    //   866: goto +966 -> 1832
    //   869: iload_2
    //   870: iconst_2
    //   871: iadd
    //   872: istore_2
    //   873: iload_2
    //   874: istore_1
    //   875: iload 7
    //   877: aload 15
    //   879: invokestatic 136	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   882: istore 4
    //   884: iconst_0
    //   885: istore_3
    //   886: iload_3
    //   887: iload 4
    //   889: if_icmpge +259 -> 1148
    //   892: iload_2
    //   893: istore_1
    //   894: aload 14
    //   896: aload 15
    //   898: iconst_0
    //   899: iconst_2
    //   900: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   903: iconst_2
    //   904: if_icmpeq +12 -> 916
    //   907: ldc 236
    //   909: astore 13
    //   911: iload_2
    //   912: istore_1
    //   913: goto +922 -> 1835
    //   916: iload_2
    //   917: iconst_2
    //   918: iadd
    //   919: istore_2
    //   920: iload_2
    //   921: istore_1
    //   922: iload 7
    //   924: aload 15
    //   926: invokestatic 136	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   929: ldc 24
    //   931: if_icmpne +195 -> 1126
    //   934: iload_2
    //   935: istore_1
    //   936: aload 14
    //   938: aload 15
    //   940: iconst_0
    //   941: iconst_2
    //   942: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   945: iconst_2
    //   946: if_icmpeq +12 -> 958
    //   949: ldc 238
    //   951: astore 13
    //   953: iload_2
    //   954: istore_1
    //   955: goto +880 -> 1835
    //   958: iload_2
    //   959: iconst_2
    //   960: iadd
    //   961: istore_2
    //   962: iload_2
    //   963: istore_1
    //   964: iload 7
    //   966: aload 15
    //   968: invokestatic 136	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   971: istore 5
    //   973: iload_2
    //   974: istore_1
    //   975: aload 14
    //   977: aload 17
    //   979: iconst_0
    //   980: iconst_4
    //   981: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   984: iconst_4
    //   985: if_icmpeq +12 -> 997
    //   988: ldc 240
    //   990: astore 13
    //   992: iload_2
    //   993: istore_1
    //   994: goto +841 -> 1835
    //   997: iload_2
    //   998: iconst_4
    //   999: iadd
    //   1000: istore_2
    //   1001: iload_2
    //   1002: istore_1
    //   1003: iload 7
    //   1005: aload 17
    //   1007: invokestatic 130	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   1010: pop
    //   1011: iload_2
    //   1012: istore_1
    //   1013: getstatic 57	com/tencent/image/JpegExifReader:BYTES_PER_FORMAT	[B
    //   1016: iload 5
    //   1018: baload
    //   1019: istore 6
    //   1021: iload_2
    //   1022: istore_1
    //   1023: aload 14
    //   1025: aload 17
    //   1027: iconst_0
    //   1028: iconst_4
    //   1029: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   1032: iconst_4
    //   1033: if_icmpeq +12 -> 1045
    //   1036: ldc 242
    //   1038: astore 13
    //   1040: iload_2
    //   1041: istore_1
    //   1042: goto +793 -> 1835
    //   1045: iload_2
    //   1046: iconst_4
    //   1047: iadd
    //   1048: istore_2
    //   1049: iload_2
    //   1050: istore_1
    //   1051: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1054: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1057: invokeinterface 108 1 0
    //   1062: ifeq +776 -> 1838
    //   1065: iload_2
    //   1066: istore_1
    //   1067: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1070: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1073: astore 18
    //   1075: iload_2
    //   1076: istore_1
    //   1077: new 110	java/lang/StringBuilder
    //   1080: dup
    //   1081: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1084: astore 19
    //   1086: iload_2
    //   1087: istore_1
    //   1088: aload 19
    //   1090: ldc 244
    //   1092: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: pop
    //   1096: iload_2
    //   1097: istore_1
    //   1098: aload 19
    //   1100: iload 5
    //   1102: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1105: pop
    //   1106: iload_2
    //   1107: istore_1
    //   1108: aload 18
    //   1110: ldc 41
    //   1112: iconst_2
    //   1113: aload 19
    //   1115: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1118: invokeinterface 228 4 0
    //   1123: goto +715 -> 1838
    //   1126: iload_2
    //   1127: istore_1
    //   1128: aload 14
    //   1130: ldc2_w 245
    //   1133: invokestatic 186	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1136: ldc2_w 245
    //   1139: lcmp
    //   1140: ifeq +719 -> 1859
    //   1143: iload_2
    //   1144: istore_1
    //   1145: goto +216 -> 1361
    //   1148: iload_2
    //   1149: istore_1
    //   1150: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1153: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1156: invokeinterface 108 1 0
    //   1161: ifeq +21 -> 1182
    //   1164: iload_2
    //   1165: istore_1
    //   1166: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1169: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1172: ldc 41
    //   1174: iconst_2
    //   1175: ldc 248
    //   1177: invokeinterface 228 4 0
    //   1182: ldc 148
    //   1184: astore 13
    //   1186: iload_2
    //   1187: istore_1
    //   1188: goto +173 -> 1361
    //   1191: astore 13
    //   1193: goto +148 -> 1341
    //   1196: aload 14
    //   1198: ldc2_w 245
    //   1201: invokestatic 186	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1204: lstore 11
    //   1206: lload 11
    //   1208: ldc2_w 245
    //   1211: lcmp
    //   1212: ifeq +6 -> 1218
    //   1215: goto +146 -> 1361
    //   1218: iload_1
    //   1219: bipush 10
    //   1221: iadd
    //   1222: istore_1
    //   1223: iload 4
    //   1225: iconst_1
    //   1226: iadd
    //   1227: istore 4
    //   1229: goto -659 -> 570
    //   1232: astore 13
    //   1234: goto +107 -> 1341
    //   1237: iload_1
    //   1238: istore_2
    //   1239: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1242: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1245: invokeinterface 108 1 0
    //   1250: ifeq +623 -> 1873
    //   1253: iload_1
    //   1254: istore_2
    //   1255: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1258: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1261: ldc 41
    //   1263: iconst_2
    //   1264: ldc 250
    //   1266: invokeinterface 228 4 0
    //   1271: goto +602 -> 1873
    //   1274: iload_1
    //   1275: istore_2
    //   1276: new 110	java/lang/StringBuilder
    //   1279: dup
    //   1280: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1283: astore 13
    //   1285: iload_1
    //   1286: istore_2
    //   1287: aload 13
    //   1289: ldc 252
    //   1291: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1294: pop
    //   1295: iload_1
    //   1296: istore_2
    //   1297: aload 13
    //   1299: aload 18
    //   1301: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1304: pop
    //   1305: iload_1
    //   1306: istore_2
    //   1307: aload 13
    //   1309: ldc 254
    //   1311: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: pop
    //   1315: iload_1
    //   1316: istore_2
    //   1317: aload 13
    //   1319: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1322: astore 13
    //   1324: goto -780 -> 544
    //   1327: astore 13
    //   1329: goto +5 -> 1334
    //   1332: astore 13
    //   1334: iload_2
    //   1335: istore_1
    //   1336: goto +5 -> 1341
    //   1339: astore 13
    //   1341: aload 14
    //   1343: astore 15
    //   1345: aload 13
    //   1347: astore 14
    //   1349: aload 15
    //   1351: astore 13
    //   1353: goto +140 -> 1493
    //   1356: ldc_w 256
    //   1359: astore 13
    //   1361: iconst_0
    //   1362: istore 7
    //   1364: goto +55 -> 1419
    //   1367: astore 15
    //   1369: aload 14
    //   1371: astore 13
    //   1373: iload_2
    //   1374: istore_1
    //   1375: aload 15
    //   1377: astore 14
    //   1379: goto +114 -> 1493
    //   1382: astore 15
    //   1384: aload 14
    //   1386: astore 13
    //   1388: aload 15
    //   1390: astore 14
    //   1392: goto +101 -> 1493
    //   1395: astore 15
    //   1397: aload 14
    //   1399: astore 13
    //   1401: iconst_2
    //   1402: istore_1
    //   1403: aload 15
    //   1405: astore 14
    //   1407: goto +86 -> 1493
    //   1410: ldc 148
    //   1412: astore 13
    //   1414: iconst_0
    //   1415: istore 7
    //   1417: iconst_2
    //   1418: istore_1
    //   1419: aload 14
    //   1421: invokevirtual 259	java/io/BufferedInputStream:close	()V
    //   1424: goto +37 -> 1461
    //   1427: astore 14
    //   1429: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1432: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1435: invokeinterface 108 1 0
    //   1440: ifeq +21 -> 1461
    //   1443: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1446: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1449: ldc 41
    //   1451: iconst_2
    //   1452: ldc 148
    //   1454: aload 14
    //   1456: invokeinterface 262 5 0
    //   1461: goto +126 -> 1587
    //   1464: astore_0
    //   1465: goto +262 -> 1727
    //   1468: astore 15
    //   1470: aload 14
    //   1472: astore 13
    //   1474: aload 15
    //   1476: astore 14
    //   1478: goto +13 -> 1491
    //   1481: astore_0
    //   1482: aload 15
    //   1484: astore 14
    //   1486: goto +241 -> 1727
    //   1489: astore 14
    //   1491: iconst_0
    //   1492: istore_1
    //   1493: aload 13
    //   1495: astore 15
    //   1497: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1500: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1503: invokeinterface 108 1 0
    //   1508: ifeq +25 -> 1533
    //   1511: aload 13
    //   1513: astore 15
    //   1515: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1518: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1521: ldc 41
    //   1523: iconst_2
    //   1524: ldc 148
    //   1526: aload 14
    //   1528: invokeinterface 262 5 0
    //   1533: aload 13
    //   1535: ifnull +45 -> 1580
    //   1538: aload 13
    //   1540: invokevirtual 259	java/io/BufferedInputStream:close	()V
    //   1543: goto +37 -> 1580
    //   1546: astore 13
    //   1548: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1551: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1554: invokeinterface 108 1 0
    //   1559: ifeq +21 -> 1580
    //   1562: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1565: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1568: ldc 41
    //   1570: iconst_2
    //   1571: ldc 148
    //   1573: aload 13
    //   1575: invokeinterface 262 5 0
    //   1580: iconst_0
    //   1581: istore 7
    //   1583: aload 16
    //   1585: astore 13
    //   1587: invokestatic 159	android/os/SystemClock:uptimeMillis	()J
    //   1590: lstore 11
    //   1592: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1595: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1598: invokeinterface 108 1 0
    //   1603: ifeq +121 -> 1724
    //   1606: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1609: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1612: astore 14
    //   1614: new 110	java/lang/StringBuilder
    //   1617: dup
    //   1618: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1621: astore 15
    //   1623: aload 15
    //   1625: ldc_w 264
    //   1628: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1631: pop
    //   1632: aload 15
    //   1634: iload 7
    //   1636: invokevirtual 267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1639: pop
    //   1640: aload 15
    //   1642: ldc_w 269
    //   1645: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1648: pop
    //   1649: aload 15
    //   1651: iload_1
    //   1652: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1655: pop
    //   1656: aload 15
    //   1658: ldc_w 271
    //   1661: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1664: pop
    //   1665: aload 15
    //   1667: lload 11
    //   1669: lload 9
    //   1671: lsub
    //   1672: invokevirtual 274	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1675: pop
    //   1676: aload 15
    //   1678: ldc_w 276
    //   1681: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1684: pop
    //   1685: aload 15
    //   1687: aload_0
    //   1688: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1691: pop
    //   1692: aload 15
    //   1694: ldc_w 278
    //   1697: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1700: pop
    //   1701: aload 15
    //   1703: aload 13
    //   1705: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1708: pop
    //   1709: aload 14
    //   1711: ldc 41
    //   1713: iconst_2
    //   1714: aload 15
    //   1716: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1719: invokeinterface 228 4 0
    //   1724: iload 7
    //   1726: ireturn
    //   1727: aload 14
    //   1729: ifnull +45 -> 1774
    //   1732: aload 14
    //   1734: invokevirtual 259	java/io/BufferedInputStream:close	()V
    //   1737: goto +37 -> 1774
    //   1740: astore 13
    //   1742: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1745: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1748: invokeinterface 108 1 0
    //   1753: ifeq +21 -> 1774
    //   1756: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1759: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1762: ldc 41
    //   1764: iconst_2
    //   1765: ldc 148
    //   1767: aload 13
    //   1769: invokeinterface 262 5 0
    //   1774: goto +5 -> 1779
    //   1777: aload_0
    //   1778: athrow
    //   1779: goto -2 -> 1777
    //   1782: iload 8
    //   1784: istore 7
    //   1786: goto -367 -> 1419
    //   1789: ldc_w 280
    //   1792: astore 13
    //   1794: goto -12 -> 1782
    //   1797: iload_3
    //   1798: iconst_m1
    //   1799: if_icmpne -443 -> 1356
    //   1802: iload 4
    //   1804: bipush 225
    //   1806: if_icmpeq -1540 -> 266
    //   1809: goto -453 -> 1356
    //   1812: iload 8
    //   1814: istore 7
    //   1816: goto -397 -> 1419
    //   1819: iload 8
    //   1821: istore 7
    //   1823: goto -404 -> 1419
    //   1826: goto -1301 -> 525
    //   1829: goto -1304 -> 525
    //   1832: goto -471 -> 1361
    //   1835: goto -474 -> 1361
    //   1838: iload_2
    //   1839: istore_1
    //   1840: iload 5
    //   1842: bipush 12
    //   1844: if_icmpne +20 -> 1864
    //   1847: ldc 148
    //   1849: astore 13
    //   1851: iconst_1
    //   1852: istore 7
    //   1854: iload_2
    //   1855: istore_1
    //   1856: goto -437 -> 1419
    //   1859: iload_2
    //   1860: bipush 10
    //   1862: iadd
    //   1863: istore_1
    //   1864: iload_3
    //   1865: iconst_1
    //   1866: iadd
    //   1867: istore_3
    //   1868: iload_1
    //   1869: istore_2
    //   1870: goto -984 -> 886
    //   1873: ldc 148
    //   1875: astore 13
    //   1877: goto -1333 -> 544
    //   1880: astore 13
    //   1882: goto -541 -> 1341
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1885	0	paramString	String
    //   7	1862	1	i	int
    //   119	1751	2	j	int
    //   132	1736	3	k	int
    //   149	1658	4	m	int
    //   224	1621	5	n	int
    //   1019	1	6	i1	int
    //   166	1687	7	bool1	boolean
    //   9	1811	8	bool2	boolean
    //   22	1648	9	l1	long
    //   241	1427	11	l2	long
    //   25	1160	13	str1	String
    //   1191	1	13	localThrowable1	java.lang.Throwable
    //   1232	1	13	localThrowable2	java.lang.Throwable
    //   1283	40	13	localObject1	Object
    //   1327	1	13	localThrowable3	java.lang.Throwable
    //   1332	1	13	localThrowable4	java.lang.Throwable
    //   1339	7	13	localThrowable5	java.lang.Throwable
    //   1351	188	13	localObject2	Object
    //   1546	28	13	localIOException1	IOException
    //   1585	119	13	str2	String
    //   1740	28	13	localIOException2	IOException
    //   1792	84	13	str3	String
    //   1880	1	13	localThrowable6	java.lang.Throwable
    //   48	1372	14	localObject3	Object
    //   1427	44	14	localIOException3	IOException
    //   1476	9	14	localThrowable7	java.lang.Throwable
    //   1489	38	14	localThrowable8	java.lang.Throwable
    //   1612	121	14	localILog	ILog
    //   28	1322	15	localObject4	Object
    //   1367	9	15	localThrowable9	java.lang.Throwable
    //   1382	7	15	localThrowable10	java.lang.Throwable
    //   1395	9	15	localThrowable11	java.lang.Throwable
    //   1468	15	15	localThrowable12	java.lang.Throwable
    //   1495	220	15	localObject5	Object
    //   2	1582	16	str4	String
    //   116	910	17	arrayOfByte	byte[]
    //   389	911	18	localObject6	Object
    //   763	351	19	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   894	907	1191	java/lang/Throwable
    //   922	934	1191	java/lang/Throwable
    //   936	949	1191	java/lang/Throwable
    //   964	973	1191	java/lang/Throwable
    //   975	988	1191	java/lang/Throwable
    //   1003	1011	1191	java/lang/Throwable
    //   1013	1021	1191	java/lang/Throwable
    //   1023	1036	1191	java/lang/Throwable
    //   1051	1065	1191	java/lang/Throwable
    //   1067	1075	1191	java/lang/Throwable
    //   1077	1086	1191	java/lang/Throwable
    //   1088	1096	1191	java/lang/Throwable
    //   1098	1106	1191	java/lang/Throwable
    //   1108	1123	1191	java/lang/Throwable
    //   1128	1143	1191	java/lang/Throwable
    //   1150	1164	1191	java/lang/Throwable
    //   1166	1182	1191	java/lang/Throwable
    //   603	611	1232	java/lang/Throwable
    //   617	630	1232	java/lang/Throwable
    //   1196	1206	1232	java/lang/Throwable
    //   505	518	1327	java/lang/Throwable
    //   527	540	1327	java/lang/Throwable
    //   579	592	1327	java/lang/Throwable
    //   1239	1253	1327	java/lang/Throwable
    //   1255	1271	1327	java/lang/Throwable
    //   1276	1285	1327	java/lang/Throwable
    //   1287	1295	1327	java/lang/Throwable
    //   1297	1305	1327	java/lang/Throwable
    //   1307	1315	1327	java/lang/Throwable
    //   1317	1324	1327	java/lang/Throwable
    //   380	391	1332	java/lang/Throwable
    //   393	403	1332	java/lang/Throwable
    //   411	421	1332	java/lang/Throwable
    //   426	441	1332	java/lang/Throwable
    //   450	463	1332	java/lang/Throwable
    //   477	486	1332	java/lang/Throwable
    //   294	311	1339	java/lang/Throwable
    //   322	337	1339	java/lang/Throwable
    //   352	365	1339	java/lang/Throwable
    //   177	190	1367	java/lang/Throwable
    //   245	258	1367	java/lang/Throwable
    //   268	281	1367	java/lang/Throwable
    //   122	133	1382	java/lang/Throwable
    //   139	151	1382	java/lang/Throwable
    //   113	118	1395	java/lang/Throwable
    //   1419	1424	1427	java/io/IOException
    //   50	68	1464	finally
    //   113	118	1464	finally
    //   122	133	1464	finally
    //   139	151	1464	finally
    //   177	190	1464	finally
    //   245	258	1464	finally
    //   268	281	1464	finally
    //   294	311	1464	finally
    //   322	337	1464	finally
    //   352	365	1464	finally
    //   380	391	1464	finally
    //   393	403	1464	finally
    //   411	421	1464	finally
    //   426	441	1464	finally
    //   450	463	1464	finally
    //   477	486	1464	finally
    //   505	518	1464	finally
    //   527	540	1464	finally
    //   556	565	1464	finally
    //   579	592	1464	finally
    //   603	611	1464	finally
    //   617	630	1464	finally
    //   643	652	1464	finally
    //   654	667	1464	finally
    //   682	690	1464	finally
    //   692	700	1464	finally
    //   702	715	1464	finally
    //   730	744	1464	finally
    //   746	754	1464	finally
    //   756	765	1464	finally
    //   767	775	1464	finally
    //   777	785	1464	finally
    //   787	802	1464	finally
    //   804	821	1464	finally
    //   823	836	1464	finally
    //   847	860	1464	finally
    //   875	884	1464	finally
    //   894	907	1464	finally
    //   922	934	1464	finally
    //   936	949	1464	finally
    //   964	973	1464	finally
    //   975	988	1464	finally
    //   1003	1011	1464	finally
    //   1013	1021	1464	finally
    //   1023	1036	1464	finally
    //   1051	1065	1464	finally
    //   1067	1075	1464	finally
    //   1077	1086	1464	finally
    //   1088	1096	1464	finally
    //   1098	1106	1464	finally
    //   1108	1123	1464	finally
    //   1128	1143	1464	finally
    //   1150	1164	1464	finally
    //   1166	1182	1464	finally
    //   1196	1206	1464	finally
    //   1239	1253	1464	finally
    //   1255	1271	1464	finally
    //   1276	1285	1464	finally
    //   1287	1295	1464	finally
    //   1297	1305	1464	finally
    //   1307	1315	1464	finally
    //   1317	1324	1464	finally
    //   50	68	1468	java/lang/Throwable
    //   30	50	1481	finally
    //   1497	1511	1481	finally
    //   1515	1533	1481	finally
    //   30	50	1489	java/lang/Throwable
    //   1538	1543	1546	java/io/IOException
    //   1732	1737	1740	java/io/IOException
    //   556	565	1880	java/lang/Throwable
    //   643	652	1880	java/lang/Throwable
    //   654	667	1880	java/lang/Throwable
    //   682	690	1880	java/lang/Throwable
    //   692	700	1880	java/lang/Throwable
    //   702	715	1880	java/lang/Throwable
    //   730	744	1880	java/lang/Throwable
    //   746	754	1880	java/lang/Throwable
    //   756	765	1880	java/lang/Throwable
    //   767	775	1880	java/lang/Throwable
    //   777	785	1880	java/lang/Throwable
    //   787	802	1880	java/lang/Throwable
    //   804	821	1880	java/lang/Throwable
    //   823	836	1880	java/lang/Throwable
    //   847	860	1880	java/lang/Throwable
    //   875	884	1880	java/lang/Throwable
  }
  
  /* Error */
  public static int readOrientation(String paramString)
  {
    // Byte code:
    //   0: invokestatic 159	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 6
    //   5: getstatic 61	com/tencent/image/JpegExifReader:sIsReadDpc	Z
    //   8: ifne +27 -> 35
    //   11: getstatic 140	com/tencent/image/JpegExifReader:jpegExifReaderInterface	Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;
    //   14: astore 13
    //   16: aload 13
    //   18: ifnull +17 -> 35
    //   21: aload 13
    //   23: invokeinterface 285 1 0
    //   28: putstatic 59	com/tencent/image/JpegExifReader:sIsEnable	Z
    //   31: iconst_1
    //   32: putstatic 61	com/tencent/image/JpegExifReader:sIsReadDpc	Z
    //   35: getstatic 59	com/tencent/image/JpegExifReader:sIsEnable	Z
    //   38: istore 12
    //   40: aconst_null
    //   41: astore 16
    //   43: aconst_null
    //   44: astore 14
    //   46: iload 12
    //   48: ifne +65 -> 113
    //   51: new 287	android/media/ExifInterface
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 288	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   59: astore_0
    //   60: goto +38 -> 98
    //   63: astore_0
    //   64: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   67: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   70: invokeinterface 108 1 0
    //   75: ifeq +21 -> 96
    //   78: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   81: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   84: ldc 41
    //   86: iconst_2
    //   87: ldc_w 290
    //   90: aload_0
    //   91: invokeinterface 262 5 0
    //   96: aconst_null
    //   97: astore_0
    //   98: aload_0
    //   99: ifnonnull +5 -> 104
    //   102: iconst_0
    //   103: ireturn
    //   104: aload_0
    //   105: ldc_w 292
    //   108: iconst_1
    //   109: invokevirtual 296	android/media/ExifInterface:getAttributeInt	(Ljava/lang/String;I)I
    //   112: ireturn
    //   113: new 161	java/io/BufferedInputStream
    //   116: dup
    //   117: new 163	java/io/FileInputStream
    //   120: dup
    //   121: aload_0
    //   122: invokespecial 166	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   125: sipush 512
    //   128: invokespecial 169	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   131: astore 15
    //   133: iconst_2
    //   134: newarray byte
    //   136: astore 17
    //   138: aload 15
    //   140: aload 17
    //   142: iconst_0
    //   143: iconst_2
    //   144: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   147: istore_1
    //   148: iload_1
    //   149: iconst_2
    //   150: if_icmpne +36 -> 186
    //   153: aload 17
    //   155: iconst_0
    //   156: baload
    //   157: sipush 255
    //   160: iand
    //   161: sipush 255
    //   164: if_icmpne +22 -> 186
    //   167: aload 17
    //   169: iconst_1
    //   170: baload
    //   171: sipush 255
    //   174: iand
    //   175: sipush 216
    //   178: if_icmpne +8 -> 186
    //   181: iconst_1
    //   182: istore_1
    //   183: goto +5 -> 188
    //   186: iconst_0
    //   187: istore_1
    //   188: iload_1
    //   189: ifeq +1397 -> 1586
    //   192: iconst_4
    //   193: newarray byte
    //   195: astore 18
    //   197: ldc 148
    //   199: astore 13
    //   201: iconst_2
    //   202: istore_2
    //   203: iload_2
    //   204: istore_1
    //   205: aload 15
    //   207: invokevirtual 178	java/io/BufferedInputStream:read	()I
    //   210: sipush 255
    //   213: iand
    //   214: i2b
    //   215: istore_3
    //   216: iload_2
    //   217: iconst_1
    //   218: iadd
    //   219: istore_2
    //   220: iload_2
    //   221: istore_1
    //   222: aload 15
    //   224: invokevirtual 178	java/io/BufferedInputStream:read	()I
    //   227: sipush 255
    //   230: iand
    //   231: i2b
    //   232: istore 4
    //   234: iload 4
    //   236: bipush 218
    //   238: if_icmpne +12 -> 250
    //   241: ldc 180
    //   243: astore 13
    //   245: iload_2
    //   246: istore_1
    //   247: goto +1345 -> 1592
    //   250: iload_2
    //   251: iconst_1
    //   252: iadd
    //   253: istore_1
    //   254: iload_1
    //   255: istore_2
    //   256: aload 15
    //   258: aload 17
    //   260: iconst_0
    //   261: iconst_2
    //   262: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   265: iconst_2
    //   266: if_icmpeq +10 -> 276
    //   269: ldc 182
    //   271: astore 13
    //   273: goto +1788 -> 2061
    //   276: iload_1
    //   277: iconst_2
    //   278: iadd
    //   279: istore_1
    //   280: aload 17
    //   282: iconst_0
    //   283: baload
    //   284: istore_2
    //   285: aload 17
    //   287: iconst_1
    //   288: baload
    //   289: sipush 255
    //   292: iand
    //   293: iload_2
    //   294: bipush 8
    //   296: ishl
    //   297: ldc 68
    //   299: iand
    //   300: ior
    //   301: iconst_2
    //   302: isub
    //   303: istore 5
    //   305: iload_3
    //   306: iconst_m1
    //   307: if_icmpne +46 -> 353
    //   310: iload 4
    //   312: bipush 224
    //   314: if_icmpne +39 -> 353
    //   317: iload 5
    //   319: i2l
    //   320: lstore 8
    //   322: iload_1
    //   323: istore_2
    //   324: aload 15
    //   326: lload 8
    //   328: invokestatic 186	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   331: lload 8
    //   333: lcmp
    //   334: ifne +11 -> 345
    //   337: iload_1
    //   338: iload 5
    //   340: iadd
    //   341: istore_2
    //   342: goto +1722 -> 2064
    //   345: ldc_w 280
    //   348: astore 13
    //   350: goto +1711 -> 2061
    //   353: iload_3
    //   354: iconst_m1
    //   355: if_icmpne +1712 -> 2067
    //   358: iload 4
    //   360: bipush 225
    //   362: if_icmpeq +1705 -> 2067
    //   365: iload 4
    //   367: bipush 225
    //   369: if_icmple +143 -> 512
    //   372: iload 4
    //   374: bipush 239
    //   376: if_icmpge +136 -> 512
    //   379: iload 5
    //   381: i2l
    //   382: lstore 8
    //   384: aload 15
    //   386: lload 8
    //   388: invokestatic 186	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   391: lstore 10
    //   393: lload 10
    //   395: lload 8
    //   397: lcmp
    //   398: ifne +65 -> 463
    //   401: new 110	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   408: astore 14
    //   410: aload 14
    //   412: aload 13
    //   414: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload 14
    //   420: ldc_w 298
    //   423: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload 14
    //   429: iload 4
    //   431: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: aload 14
    //   437: ldc_w 300
    //   440: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload 14
    //   446: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: astore 14
    //   451: iload_1
    //   452: iload 5
    //   454: iadd
    //   455: istore_2
    //   456: aload 14
    //   458: astore 13
    //   460: goto +1604 -> 2064
    //   463: new 110	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   470: astore 14
    //   472: aload 14
    //   474: ldc_w 298
    //   477: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload 14
    //   483: iload 4
    //   485: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: aload 14
    //   491: ldc_w 302
    //   494: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload 14
    //   500: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: astore 14
    //   505: aload 14
    //   507: astore 13
    //   509: goto +1030 -> 1539
    //   512: new 110	java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   519: astore 14
    //   521: aload 14
    //   523: ldc_w 304
    //   526: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload 14
    //   532: iload 4
    //   534: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload 14
    //   540: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: astore 14
    //   545: aload 14
    //   547: astore 13
    //   549: goto +990 -> 1539
    //   552: aload 15
    //   554: aload 18
    //   556: iconst_0
    //   557: iconst_4
    //   558: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   561: iconst_4
    //   562: if_icmpeq +10 -> 572
    //   565: ldc 188
    //   567: astore 13
    //   569: goto +970 -> 1539
    //   572: ldc 22
    //   574: new 190	java/lang/String
    //   577: dup
    //   578: aload 18
    //   580: invokespecial 193	java/lang/String:<init>	([B)V
    //   583: invokevirtual 196	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   586: ifne +10 -> 596
    //   589: ldc 198
    //   591: astore 13
    //   593: goto +946 -> 1539
    //   596: aload 15
    //   598: ldc2_w 199
    //   601: invokevirtual 203	java/io/BufferedInputStream:skip	(J)J
    //   604: ldc2_w 199
    //   607: lcmp
    //   608: ifeq +10 -> 618
    //   611: ldc 205
    //   613: astore 13
    //   615: goto +924 -> 1539
    //   618: iload_1
    //   619: iconst_2
    //   620: iadd
    //   621: istore_1
    //   622: iload_1
    //   623: istore_2
    //   624: aload 15
    //   626: aload 17
    //   628: iconst_0
    //   629: iconst_2
    //   630: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   633: iconst_2
    //   634: if_icmpeq +10 -> 644
    //   637: ldc 207
    //   639: astore 13
    //   641: goto +1445 -> 2086
    //   644: iload_1
    //   645: iconst_2
    //   646: iadd
    //   647: istore_1
    //   648: iload_1
    //   649: istore_2
    //   650: new 190	java/lang/String
    //   653: dup
    //   654: aload 17
    //   656: invokespecial 193	java/lang/String:<init>	([B)V
    //   659: astore 14
    //   661: iload_1
    //   662: istore_2
    //   663: ldc 8
    //   665: aload 14
    //   667: invokevirtual 196	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   670: ifeq +9 -> 679
    //   673: iconst_1
    //   674: istore 12
    //   676: goto +18 -> 694
    //   679: iload_1
    //   680: istore_2
    //   681: ldc 29
    //   683: aload 14
    //   685: invokevirtual 196	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   688: ifeq +782 -> 1470
    //   691: iconst_0
    //   692: istore 12
    //   694: iload_1
    //   695: istore_2
    //   696: aload 15
    //   698: ldc2_w 199
    //   701: invokestatic 186	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   704: ldc2_w 199
    //   707: lcmp
    //   708: ifeq +10 -> 718
    //   711: ldc 209
    //   713: astore 13
    //   715: goto +1371 -> 2086
    //   718: iload_1
    //   719: istore_2
    //   720: aload 15
    //   722: aload 18
    //   724: iconst_0
    //   725: iconst_4
    //   726: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   729: iconst_4
    //   730: if_icmpeq +10 -> 740
    //   733: ldc 211
    //   735: astore 13
    //   737: goto +1349 -> 2086
    //   740: iload_1
    //   741: bipush 6
    //   743: iadd
    //   744: istore_2
    //   745: iload_2
    //   746: istore_1
    //   747: iload 12
    //   749: aload 18
    //   751: invokestatic 130	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   754: bipush 8
    //   756: isub
    //   757: istore_3
    //   758: iload_3
    //   759: ifle +29 -> 788
    //   762: iload_3
    //   763: i2l
    //   764: lstore 6
    //   766: iload_2
    //   767: istore_1
    //   768: aload 15
    //   770: lload 6
    //   772: invokestatic 186	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   775: lload 6
    //   777: lcmp
    //   778: ifeq +10 -> 788
    //   781: ldc 213
    //   783: astore 13
    //   785: goto +1308 -> 2093
    //   788: iload_2
    //   789: istore_1
    //   790: aload 15
    //   792: aload 17
    //   794: iconst_0
    //   795: iconst_2
    //   796: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   799: iconst_2
    //   800: if_icmpeq +10 -> 810
    //   803: ldc 215
    //   805: astore 13
    //   807: goto +1286 -> 2093
    //   810: iload_2
    //   811: iload_3
    //   812: iconst_2
    //   813: iadd
    //   814: iadd
    //   815: istore_2
    //   816: iload_2
    //   817: istore_1
    //   818: iload 12
    //   820: aload 17
    //   822: invokestatic 136	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   825: istore 4
    //   827: iload_2
    //   828: istore_1
    //   829: iconst_0
    //   830: istore_3
    //   831: iload_3
    //   832: iload 4
    //   834: if_icmpge +1297 -> 2131
    //   837: iload_1
    //   838: istore_2
    //   839: aload 15
    //   841: aload 17
    //   843: iconst_0
    //   844: iconst_2
    //   845: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   848: iconst_2
    //   849: if_icmpeq +11 -> 860
    //   852: ldc_w 306
    //   855: astore 13
    //   857: goto +1229 -> 2086
    //   860: iload_1
    //   861: iconst_2
    //   862: iadd
    //   863: istore_2
    //   864: iload_2
    //   865: istore_1
    //   866: aload 13
    //   868: astore 16
    //   870: iload 12
    //   872: aload 17
    //   874: invokestatic 136	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   877: sipush 274
    //   880: if_icmpne +479 -> 1359
    //   883: iload_2
    //   884: istore_1
    //   885: aload 13
    //   887: astore 16
    //   889: aload 15
    //   891: aload 17
    //   893: iconst_0
    //   894: iconst_2
    //   895: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   898: iconst_2
    //   899: if_icmpeq +13 -> 912
    //   902: ldc_w 308
    //   905: astore 13
    //   907: iload_2
    //   908: istore_1
    //   909: goto +1201 -> 2110
    //   912: iload_2
    //   913: iconst_2
    //   914: iadd
    //   915: istore_2
    //   916: iload_2
    //   917: istore_1
    //   918: aload 13
    //   920: astore 16
    //   922: iload 12
    //   924: aload 17
    //   926: invokestatic 136	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   929: istore_3
    //   930: iload_2
    //   931: istore_1
    //   932: aload 13
    //   934: astore 16
    //   936: aload 15
    //   938: aload 18
    //   940: iconst_0
    //   941: iconst_4
    //   942: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   945: iconst_4
    //   946: if_icmpeq +12 -> 958
    //   949: ldc 221
    //   951: astore 13
    //   953: iload_2
    //   954: istore_1
    //   955: goto +1155 -> 2110
    //   958: iload_2
    //   959: iconst_4
    //   960: iadd
    //   961: istore_2
    //   962: iload_2
    //   963: istore_1
    //   964: aload 13
    //   966: astore 16
    //   968: iload 12
    //   970: aload 18
    //   972: invokestatic 130	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   975: getstatic 57	com/tencent/image/JpegExifReader:BYTES_PER_FORMAT	[B
    //   978: iload_3
    //   979: baload
    //   980: imul
    //   981: istore 4
    //   983: iload 4
    //   985: iconst_4
    //   986: if_icmple +91 -> 1077
    //   989: iload_2
    //   990: istore_1
    //   991: aload 13
    //   993: astore 16
    //   995: new 110	java/lang/StringBuilder
    //   998: dup
    //   999: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1002: astore 14
    //   1004: iload_2
    //   1005: istore_1
    //   1006: aload 13
    //   1008: astore 16
    //   1010: aload 14
    //   1012: ldc_w 310
    //   1015: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: pop
    //   1019: iload_2
    //   1020: istore_1
    //   1021: aload 13
    //   1023: astore 16
    //   1025: aload 14
    //   1027: iload_3
    //   1028: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1031: pop
    //   1032: iload_2
    //   1033: istore_1
    //   1034: aload 13
    //   1036: astore 16
    //   1038: aload 14
    //   1040: ldc_w 312
    //   1043: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: pop
    //   1047: iload_2
    //   1048: istore_1
    //   1049: aload 13
    //   1051: astore 16
    //   1053: aload 14
    //   1055: iload 4
    //   1057: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1060: pop
    //   1061: iload_2
    //   1062: istore_1
    //   1063: aload 13
    //   1065: astore 16
    //   1067: aload 14
    //   1069: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1072: astore 13
    //   1074: goto +315 -> 1389
    //   1077: iload_2
    //   1078: istore_1
    //   1079: aload 13
    //   1081: astore 16
    //   1083: aload 15
    //   1085: aload 18
    //   1087: iconst_0
    //   1088: iconst_4
    //   1089: invokevirtual 173	java/io/BufferedInputStream:read	([BII)I
    //   1092: iconst_4
    //   1093: if_icmpeq +13 -> 1106
    //   1096: ldc_w 314
    //   1099: astore 13
    //   1101: iload_2
    //   1102: istore_1
    //   1103: goto +1007 -> 2110
    //   1106: iload_2
    //   1107: iconst_4
    //   1108: iadd
    //   1109: istore_2
    //   1110: iload_3
    //   1111: iconst_3
    //   1112: if_icmpeq +145 -> 1257
    //   1115: iload_3
    //   1116: iconst_4
    //   1117: if_icmpeq +120 -> 1237
    //   1120: iload_3
    //   1121: bipush 6
    //   1123: if_icmpeq +979 -> 2102
    //   1126: iload_3
    //   1127: bipush 8
    //   1129: if_icmpeq +89 -> 1218
    //   1132: iload_3
    //   1133: bipush 9
    //   1135: if_icmpeq +64 -> 1199
    //   1138: iload_2
    //   1139: istore_1
    //   1140: aload 13
    //   1142: astore 16
    //   1144: new 110	java/lang/StringBuilder
    //   1147: dup
    //   1148: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1151: astore 14
    //   1153: iload_2
    //   1154: istore_1
    //   1155: aload 13
    //   1157: astore 16
    //   1159: aload 14
    //   1161: ldc_w 316
    //   1164: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1167: pop
    //   1168: iload_2
    //   1169: istore_1
    //   1170: aload 13
    //   1172: astore 16
    //   1174: aload 14
    //   1176: iload_3
    //   1177: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1180: pop
    //   1181: iload_2
    //   1182: istore_1
    //   1183: aload 13
    //   1185: astore 16
    //   1187: aload 14
    //   1189: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1192: astore 13
    //   1194: iconst_1
    //   1195: istore_1
    //   1196: goto +77 -> 1273
    //   1199: iload_2
    //   1200: istore_1
    //   1201: aload 13
    //   1203: astore 16
    //   1205: iload 12
    //   1207: aload 18
    //   1209: invokestatic 130	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   1212: istore_3
    //   1213: iload_3
    //   1214: istore_1
    //   1215: goto +58 -> 1273
    //   1218: iload_2
    //   1219: istore_1
    //   1220: aload 13
    //   1222: astore 16
    //   1224: iload 12
    //   1226: aload 18
    //   1228: invokestatic 132	com/tencent/image/JpegExifReader:getInt16	(Z[B)S
    //   1231: istore_3
    //   1232: iload_3
    //   1233: istore_1
    //   1234: goto +39 -> 1273
    //   1237: iload_2
    //   1238: istore_1
    //   1239: aload 13
    //   1241: astore 16
    //   1243: iload 12
    //   1245: aload 18
    //   1247: invokestatic 134	com/tencent/image/JpegExifReader:getUnsignedInt32	(Z[B)J
    //   1250: l2i
    //   1251: istore_3
    //   1252: iload_3
    //   1253: istore_1
    //   1254: goto +19 -> 1273
    //   1257: iload_2
    //   1258: istore_1
    //   1259: aload 13
    //   1261: astore 16
    //   1263: iload 12
    //   1265: aload 18
    //   1267: invokestatic 136	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1270: istore_3
    //   1271: iload_3
    //   1272: istore_1
    //   1273: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1276: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1279: invokeinterface 108 1 0
    //   1284: ifeq +51 -> 1335
    //   1287: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1290: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1293: astore 14
    //   1295: new 110	java/lang/StringBuilder
    //   1298: dup
    //   1299: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1302: astore 16
    //   1304: aload 16
    //   1306: ldc_w 318
    //   1309: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: pop
    //   1313: aload 16
    //   1315: iload_1
    //   1316: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1319: pop
    //   1320: aload 14
    //   1322: ldc 41
    //   1324: iconst_2
    //   1325: aload 16
    //   1327: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1330: invokeinterface 228 4 0
    //   1335: iload_1
    //   1336: istore_3
    //   1337: iload_2
    //   1338: istore_1
    //   1339: iload_3
    //   1340: istore_2
    //   1341: lload 8
    //   1343: lstore 6
    //   1345: goto +249 -> 1594
    //   1348: astore 16
    //   1350: iload_1
    //   1351: istore_3
    //   1352: iload_2
    //   1353: istore_1
    //   1354: iload_3
    //   1355: istore_2
    //   1356: goto +340 -> 1696
    //   1359: iload_2
    //   1360: istore_1
    //   1361: aload 13
    //   1363: astore 16
    //   1365: aload 15
    //   1367: ldc2_w 245
    //   1370: invokestatic 186	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1373: ldc2_w 245
    //   1376: lcmp
    //   1377: ifeq +742 -> 2119
    //   1380: ldc 175
    //   1382: astore 13
    //   1384: iload_2
    //   1385: istore_1
    //   1386: goto +724 -> 2110
    //   1389: iload_2
    //   1390: istore_3
    //   1391: aload 13
    //   1393: astore 14
    //   1395: iload_2
    //   1396: istore_1
    //   1397: aload 13
    //   1399: astore 16
    //   1401: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1404: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1407: invokeinterface 108 1 0
    //   1412: ifeq +31 -> 1443
    //   1415: iload_2
    //   1416: istore_1
    //   1417: aload 13
    //   1419: astore 16
    //   1421: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1424: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1427: ldc 41
    //   1429: iconst_2
    //   1430: ldc 250
    //   1432: invokeinterface 228 4 0
    //   1437: aload 13
    //   1439: astore 14
    //   1441: iload_2
    //   1442: istore_3
    //   1443: iload_3
    //   1444: istore_1
    //   1445: aload 14
    //   1447: astore 13
    //   1449: lload 8
    //   1451: lstore 6
    //   1453: goto +139 -> 1592
    //   1456: astore 14
    //   1458: aload 16
    //   1460: astore 13
    //   1462: goto +205 -> 1667
    //   1465: astore 14
    //   1467: goto +200 -> 1667
    //   1470: iload_1
    //   1471: istore_2
    //   1472: new 110	java/lang/StringBuilder
    //   1475: dup
    //   1476: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1479: astore 16
    //   1481: iload_1
    //   1482: istore_2
    //   1483: aload 16
    //   1485: ldc 252
    //   1487: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: pop
    //   1491: iload_1
    //   1492: istore_2
    //   1493: aload 16
    //   1495: aload 14
    //   1497: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1500: pop
    //   1501: iload_1
    //   1502: istore_2
    //   1503: aload 16
    //   1505: ldc 254
    //   1507: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1510: pop
    //   1511: iload_1
    //   1512: istore_2
    //   1513: aload 16
    //   1515: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1518: astore 14
    //   1520: aload 14
    //   1522: astore 13
    //   1524: goto +562 -> 2086
    //   1527: astore 14
    //   1529: iload_2
    //   1530: istore_1
    //   1531: goto +136 -> 1667
    //   1534: ldc_w 256
    //   1537: astore 13
    //   1539: goto +53 -> 1592
    //   1542: astore 14
    //   1544: lload 6
    //   1546: lstore 8
    //   1548: goto +119 -> 1667
    //   1551: astore 14
    //   1553: iload_2
    //   1554: istore_1
    //   1555: lload 6
    //   1557: lstore 8
    //   1559: goto +108 -> 1667
    //   1562: astore 14
    //   1564: lload 6
    //   1566: lstore 8
    //   1568: goto +122 -> 1690
    //   1571: astore 14
    //   1573: ldc 148
    //   1575: astore 13
    //   1577: iconst_2
    //   1578: istore_1
    //   1579: lload 6
    //   1581: lstore 8
    //   1583: goto +107 -> 1690
    //   1586: ldc 148
    //   1588: astore 13
    //   1590: iconst_2
    //   1591: istore_1
    //   1592: iconst_1
    //   1593: istore_2
    //   1594: aload 15
    //   1596: invokevirtual 259	java/io/BufferedInputStream:close	()V
    //   1599: iload_1
    //   1600: istore 4
    //   1602: aload 13
    //   1604: astore 14
    //   1606: iload_2
    //   1607: istore_3
    //   1608: lload 6
    //   1610: lstore 10
    //   1612: goto +227 -> 1839
    //   1615: astore 15
    //   1617: iload_1
    //   1618: istore 4
    //   1620: aload 13
    //   1622: astore 14
    //   1624: iload_2
    //   1625: istore_3
    //   1626: lload 6
    //   1628: lstore 10
    //   1630: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1633: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1636: invokeinterface 108 1 0
    //   1641: ifeq +198 -> 1839
    //   1644: goto +164 -> 1808
    //   1647: astore_0
    //   1648: aload 15
    //   1650: astore 14
    //   1652: goto +354 -> 2006
    //   1655: astore 14
    //   1657: iconst_0
    //   1658: istore_1
    //   1659: ldc 148
    //   1661: astore 13
    //   1663: lload 6
    //   1665: lstore 8
    //   1667: goto +23 -> 1690
    //   1670: astore_0
    //   1671: goto +335 -> 2006
    //   1674: astore 14
    //   1676: iconst_0
    //   1677: istore_1
    //   1678: ldc 148
    //   1680: astore 13
    //   1682: lload 6
    //   1684: lstore 8
    //   1686: aload 16
    //   1688: astore 15
    //   1690: iconst_1
    //   1691: istore_2
    //   1692: aload 14
    //   1694: astore 16
    //   1696: aload 15
    //   1698: astore 14
    //   1700: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1703: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1706: invokeinterface 108 1 0
    //   1711: ifeq +25 -> 1736
    //   1714: aload 15
    //   1716: astore 14
    //   1718: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1721: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1724: ldc 41
    //   1726: iconst_2
    //   1727: ldc 148
    //   1729: aload 16
    //   1731: invokeinterface 262 5 0
    //   1736: iload_1
    //   1737: istore 4
    //   1739: aload 13
    //   1741: astore 14
    //   1743: iload_2
    //   1744: istore_3
    //   1745: lload 8
    //   1747: lstore 10
    //   1749: aload 15
    //   1751: ifnull +88 -> 1839
    //   1754: aload 15
    //   1756: invokevirtual 259	java/io/BufferedInputStream:close	()V
    //   1759: iload_1
    //   1760: istore 4
    //   1762: aload 13
    //   1764: astore 14
    //   1766: iload_2
    //   1767: istore_3
    //   1768: lload 8
    //   1770: lstore 10
    //   1772: goto +67 -> 1839
    //   1775: astore 15
    //   1777: iload_1
    //   1778: istore 4
    //   1780: aload 13
    //   1782: astore 14
    //   1784: iload_2
    //   1785: istore_3
    //   1786: lload 8
    //   1788: lstore 10
    //   1790: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1793: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1796: invokeinterface 108 1 0
    //   1801: ifeq +38 -> 1839
    //   1804: lload 8
    //   1806: lstore 6
    //   1808: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1811: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1814: ldc 41
    //   1816: iconst_2
    //   1817: ldc 148
    //   1819: aload 15
    //   1821: invokeinterface 262 5 0
    //   1826: lload 6
    //   1828: lstore 10
    //   1830: iload_2
    //   1831: istore_3
    //   1832: aload 13
    //   1834: astore 14
    //   1836: iload_1
    //   1837: istore 4
    //   1839: invokestatic 159	android/os/SystemClock:uptimeMillis	()J
    //   1842: lload 10
    //   1844: lsub
    //   1845: lstore 6
    //   1847: getstatic 140	com/tencent/image/JpegExifReader:jpegExifReaderInterface	Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;
    //   1850: astore 13
    //   1852: aload 13
    //   1854: ifnull +21 -> 1875
    //   1857: aload 13
    //   1859: aconst_null
    //   1860: ldc 34
    //   1862: iconst_1
    //   1863: lload 6
    //   1865: iload 4
    //   1867: i2l
    //   1868: aconst_null
    //   1869: aconst_null
    //   1870: invokeinterface 322 10 0
    //   1875: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1878: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1881: invokeinterface 108 1 0
    //   1886: ifeq +118 -> 2004
    //   1889: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1892: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1895: astore 13
    //   1897: new 110	java/lang/StringBuilder
    //   1900: dup
    //   1901: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1904: astore 15
    //   1906: aload 15
    //   1908: ldc_w 324
    //   1911: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1914: pop
    //   1915: aload 15
    //   1917: iload_3
    //   1918: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1921: pop
    //   1922: aload 15
    //   1924: ldc_w 269
    //   1927: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1930: pop
    //   1931: aload 15
    //   1933: iload 4
    //   1935: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1938: pop
    //   1939: aload 15
    //   1941: ldc_w 271
    //   1944: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1947: pop
    //   1948: aload 15
    //   1950: lload 6
    //   1952: invokevirtual 274	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1955: pop
    //   1956: aload 15
    //   1958: ldc_w 276
    //   1961: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1964: pop
    //   1965: aload 15
    //   1967: aload_0
    //   1968: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1971: pop
    //   1972: aload 15
    //   1974: ldc_w 326
    //   1977: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1980: pop
    //   1981: aload 15
    //   1983: aload 14
    //   1985: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1988: pop
    //   1989: aload 13
    //   1991: ldc 41
    //   1993: iconst_2
    //   1994: aload 15
    //   1996: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1999: invokeinterface 228 4 0
    //   2004: iload_3
    //   2005: ireturn
    //   2006: aload 14
    //   2008: ifnull +45 -> 2053
    //   2011: aload 14
    //   2013: invokevirtual 259	java/io/BufferedInputStream:close	()V
    //   2016: goto +37 -> 2053
    //   2019: astore 13
    //   2021: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   2024: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   2027: invokeinterface 108 1 0
    //   2032: ifeq +21 -> 2053
    //   2035: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   2038: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   2041: ldc 41
    //   2043: iconst_2
    //   2044: ldc 148
    //   2046: aload 13
    //   2048: invokeinterface 262 5 0
    //   2053: goto +5 -> 2058
    //   2056: aload_0
    //   2057: athrow
    //   2058: goto -2 -> 2056
    //   2061: goto -469 -> 1592
    //   2064: goto -1861 -> 203
    //   2067: lload 6
    //   2069: lstore 8
    //   2071: iload_3
    //   2072: iconst_m1
    //   2073: if_icmpne -539 -> 1534
    //   2076: iload 4
    //   2078: bipush 225
    //   2080: if_icmpeq -1528 -> 552
    //   2083: goto -549 -> 1534
    //   2086: lload 8
    //   2088: lstore 6
    //   2090: goto -498 -> 1592
    //   2093: iload_2
    //   2094: istore_1
    //   2095: lload 8
    //   2097: lstore 6
    //   2099: goto -507 -> 1592
    //   2102: aload 18
    //   2104: iconst_0
    //   2105: baload
    //   2106: istore_1
    //   2107: goto -834 -> 1273
    //   2110: iload_1
    //   2111: istore_3
    //   2112: aload 13
    //   2114: astore 14
    //   2116: goto -673 -> 1443
    //   2119: iload_2
    //   2120: bipush 10
    //   2122: iadd
    //   2123: istore_1
    //   2124: iload_3
    //   2125: iconst_1
    //   2126: iadd
    //   2127: istore_3
    //   2128: goto -1297 -> 831
    //   2131: iload_1
    //   2132: istore_2
    //   2133: goto -744 -> 1389
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2136	0	paramString	String
    //   147	1985	1	i	int
    //   202	1931	2	j	int
    //   215	1913	3	k	int
    //   232	1849	4	m	int
    //   303	152	5	n	int
    //   3	2095	6	l1	long
    //   320	1776	8	l2	long
    //   391	1452	10	l3	long
    //   38	1226	12	bool	boolean
    //   14	1976	13	localObject1	Object
    //   2019	94	13	localIOException1	IOException
    //   44	1402	14	localObject2	Object
    //   1456	1	14	localThrowable1	java.lang.Throwable
    //   1465	31	14	localThrowable2	java.lang.Throwable
    //   1518	3	14	str	String
    //   1527	1	14	localThrowable3	java.lang.Throwable
    //   1542	1	14	localThrowable4	java.lang.Throwable
    //   1551	1	14	localThrowable5	java.lang.Throwable
    //   1562	1	14	localThrowable6	java.lang.Throwable
    //   1571	1	14	localThrowable7	java.lang.Throwable
    //   1604	47	14	localObject3	Object
    //   1655	1	14	localThrowable8	java.lang.Throwable
    //   1674	19	14	localThrowable9	java.lang.Throwable
    //   1698	417	14	localObject4	Object
    //   131	1464	15	localBufferedInputStream	java.io.BufferedInputStream
    //   1615	34	15	localIOException2	IOException
    //   1688	67	15	localObject5	Object
    //   1775	45	15	localIOException3	IOException
    //   1904	91	15	localStringBuilder	StringBuilder
    //   41	1285	16	localObject6	Object
    //   1348	1	16	localThrowable10	java.lang.Throwable
    //   1363	367	16	localObject7	Object
    //   136	789	17	arrayOfByte1	byte[]
    //   195	1908	18	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   51	60	63	java/io/IOException
    //   1273	1335	1348	java/lang/Throwable
    //   870	883	1456	java/lang/Throwable
    //   889	902	1456	java/lang/Throwable
    //   922	930	1456	java/lang/Throwable
    //   936	949	1456	java/lang/Throwable
    //   968	983	1456	java/lang/Throwable
    //   995	1004	1456	java/lang/Throwable
    //   1010	1019	1456	java/lang/Throwable
    //   1025	1032	1456	java/lang/Throwable
    //   1038	1047	1456	java/lang/Throwable
    //   1053	1061	1456	java/lang/Throwable
    //   1067	1074	1456	java/lang/Throwable
    //   1083	1096	1456	java/lang/Throwable
    //   1144	1153	1456	java/lang/Throwable
    //   1159	1168	1456	java/lang/Throwable
    //   1174	1181	1456	java/lang/Throwable
    //   1187	1194	1456	java/lang/Throwable
    //   1205	1213	1456	java/lang/Throwable
    //   1224	1232	1456	java/lang/Throwable
    //   1243	1252	1456	java/lang/Throwable
    //   1263	1271	1456	java/lang/Throwable
    //   1365	1380	1456	java/lang/Throwable
    //   1401	1415	1456	java/lang/Throwable
    //   1421	1437	1456	java/lang/Throwable
    //   747	758	1465	java/lang/Throwable
    //   768	781	1465	java/lang/Throwable
    //   790	803	1465	java/lang/Throwable
    //   818	827	1465	java/lang/Throwable
    //   624	637	1527	java/lang/Throwable
    //   650	661	1527	java/lang/Throwable
    //   663	673	1527	java/lang/Throwable
    //   681	691	1527	java/lang/Throwable
    //   696	711	1527	java/lang/Throwable
    //   720	733	1527	java/lang/Throwable
    //   839	852	1527	java/lang/Throwable
    //   1472	1481	1527	java/lang/Throwable
    //   1483	1491	1527	java/lang/Throwable
    //   1493	1501	1527	java/lang/Throwable
    //   1503	1511	1527	java/lang/Throwable
    //   1513	1520	1527	java/lang/Throwable
    //   384	393	1542	java/lang/Throwable
    //   401	451	1542	java/lang/Throwable
    //   463	505	1542	java/lang/Throwable
    //   512	545	1542	java/lang/Throwable
    //   552	565	1542	java/lang/Throwable
    //   572	589	1542	java/lang/Throwable
    //   596	611	1542	java/lang/Throwable
    //   256	269	1551	java/lang/Throwable
    //   324	337	1551	java/lang/Throwable
    //   205	216	1562	java/lang/Throwable
    //   222	234	1562	java/lang/Throwable
    //   192	197	1571	java/lang/Throwable
    //   1594	1599	1615	java/io/IOException
    //   133	148	1647	finally
    //   192	197	1647	finally
    //   205	216	1647	finally
    //   222	234	1647	finally
    //   256	269	1647	finally
    //   324	337	1647	finally
    //   384	393	1647	finally
    //   401	451	1647	finally
    //   463	505	1647	finally
    //   512	545	1647	finally
    //   552	565	1647	finally
    //   572	589	1647	finally
    //   596	611	1647	finally
    //   624	637	1647	finally
    //   650	661	1647	finally
    //   663	673	1647	finally
    //   681	691	1647	finally
    //   696	711	1647	finally
    //   720	733	1647	finally
    //   747	758	1647	finally
    //   768	781	1647	finally
    //   790	803	1647	finally
    //   818	827	1647	finally
    //   839	852	1647	finally
    //   870	883	1647	finally
    //   889	902	1647	finally
    //   922	930	1647	finally
    //   936	949	1647	finally
    //   968	983	1647	finally
    //   995	1004	1647	finally
    //   1010	1019	1647	finally
    //   1025	1032	1647	finally
    //   1038	1047	1647	finally
    //   1053	1061	1647	finally
    //   1067	1074	1647	finally
    //   1083	1096	1647	finally
    //   1144	1153	1647	finally
    //   1159	1168	1647	finally
    //   1174	1181	1647	finally
    //   1187	1194	1647	finally
    //   1205	1213	1647	finally
    //   1224	1232	1647	finally
    //   1243	1252	1647	finally
    //   1263	1271	1647	finally
    //   1273	1335	1647	finally
    //   1365	1380	1647	finally
    //   1401	1415	1647	finally
    //   1421	1437	1647	finally
    //   1472	1481	1647	finally
    //   1483	1491	1647	finally
    //   1493	1501	1647	finally
    //   1503	1511	1647	finally
    //   1513	1520	1647	finally
    //   133	148	1655	java/lang/Throwable
    //   113	133	1670	finally
    //   1700	1714	1670	finally
    //   1718	1736	1670	finally
    //   113	133	1674	java/lang/Throwable
    //   1754	1759	1775	java/io/IOException
    //   2011	2016	2019	java/io/IOException
  }
  
  private static long skip(InputStream paramInputStream, long paramLong)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.JpegExifReader
 * JD-Core Version:    0.7.0.1
 */