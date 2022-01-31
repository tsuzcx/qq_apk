package com.tencent.image;

import com.tencent.qphone.base.util.QLog;
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
    if (paramBoolean) {
      return (short)(paramArrayOfByte[0] & 0xFF00 | paramArrayOfByte[1] & 0xFF);
    }
    return (short)(paramArrayOfByte[1] & 0xFF00 | paramArrayOfByte[0] & 0xFF);
  }
  
  private static int getInt32(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (paramBoolean) {
      return paramArrayOfByte[0] << 24 & 0xFF000000 | paramArrayOfByte[1] << 16 & 0xFF0000 | paramArrayOfByte[2] << 8 & 0xFF00 | paramArrayOfByte[3] & 0xFF;
    }
    return paramArrayOfByte[3] << 24 & 0xFF000000 | paramArrayOfByte[2] << 16 & 0xFF0000 | paramArrayOfByte[1] << 8 & 0xFF00 | paramArrayOfByte[0] & 0xFF;
  }
  
  public static int getRotationDegree(String paramString)
  {
    switch (readOrientation(paramString))
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 6: 
      return 90;
    case 3: 
      return 180;
    }
    return 270;
  }
  
  private static int getUnsignedInt16(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (paramBoolean) {
      return paramArrayOfByte[0] << 8 & 0xFF00 | paramArrayOfByte[1] & 0xFF;
    }
    return paramArrayOfByte[1] << 8 & 0xFF00 | paramArrayOfByte[0] & 0xFF;
  }
  
  private static long getUnsignedInt32(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (paramBoolean) {
      return paramArrayOfByte[0] << 24 & 0xFF000000 | paramArrayOfByte[1] << 16 & 0xFF0000 | paramArrayOfByte[2] << 8 & 0xFF00 | paramArrayOfByte[3] & 0xFF;
    }
    return paramArrayOfByte[3] << 24 & 0xFF000000 | paramArrayOfByte[2] << 16 & 0xFF0000 | paramArrayOfByte[1] << 8 & 0xFF00 | paramArrayOfByte[0] & 0xFF;
  }
  
  private static long getValue(int paramInt, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    switch (paramInt)
    {
    case 5: 
    case 7: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("JpegExifReader", 2, "get value format code: " + paramInt);
      }
      return 0L;
    case 3: 
      return getUnsignedInt16(paramBoolean, paramArrayOfByte);
    case 4: 
      return getUnsignedInt32(paramBoolean, paramArrayOfByte);
    case 6: 
      return paramArrayOfByte[0];
    case 8: 
      return getInt16(paramBoolean, paramArrayOfByte);
    }
    return getInt32(paramBoolean, paramArrayOfByte);
  }
  
  public static void initJpegExifReader(JpegExifReader.JpegExifReaderInterface paramJpegExifReaderInterface)
  {
    jpegExifReaderInterface = paramJpegExifReaderInterface;
  }
  
  /* Error */
  public static boolean isCrashJpeg(String paramString)
  {
    // Byte code:
    //   0: getstatic 139	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 24
    //   5: if_icmplt +9 -> 14
    //   8: iconst_0
    //   9: istore 8
    //   11: iload 8
    //   13: ireturn
    //   14: invokestatic 145	android/os/SystemClock:uptimeMillis	()J
    //   17: lstore 10
    //   19: iconst_0
    //   20: istore 9
    //   22: iconst_0
    //   23: istore 8
    //   25: aconst_null
    //   26: astore 14
    //   28: iconst_0
    //   29: istore_3
    //   30: new 147	java/io/BufferedInputStream
    //   33: dup
    //   34: new 149	java/io/FileInputStream
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 152	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   42: sipush 1024
    //   45: invokespecial 155	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   48: astore 15
    //   50: iconst_0
    //   51: istore_2
    //   52: iload_3
    //   53: istore_1
    //   54: iconst_2
    //   55: newarray byte
    //   57: astore 14
    //   59: iload_3
    //   60: istore_1
    //   61: aload 15
    //   63: aload 14
    //   65: iconst_0
    //   66: iconst_2
    //   67: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   70: iconst_2
    //   71: if_icmpne +33 -> 104
    //   74: aload 14
    //   76: iconst_0
    //   77: baload
    //   78: sipush 255
    //   81: iand
    //   82: sipush 255
    //   85: if_icmpne +198 -> 283
    //   88: aload 14
    //   90: iconst_1
    //   91: baload
    //   92: sipush 255
    //   95: iand
    //   96: sipush 216
    //   99: if_icmpne +184 -> 283
    //   102: iconst_1
    //   103: istore_2
    //   104: iconst_2
    //   105: istore 4
    //   107: iload 4
    //   109: istore_3
    //   110: iload_2
    //   111: ifeq +1452 -> 1563
    //   114: iload 4
    //   116: istore_1
    //   117: iconst_4
    //   118: newarray byte
    //   120: astore 16
    //   122: iload 4
    //   124: istore_1
    //   125: aload 15
    //   127: invokevirtual 162	java/io/BufferedInputStream:read	()I
    //   130: sipush 255
    //   133: iand
    //   134: i2b
    //   135: istore_3
    //   136: iload 4
    //   138: iconst_1
    //   139: iadd
    //   140: istore_2
    //   141: iload_2
    //   142: istore_1
    //   143: aload 15
    //   145: invokevirtual 162	java/io/BufferedInputStream:read	()I
    //   148: sipush 255
    //   151: iand
    //   152: i2b
    //   153: istore 4
    //   155: iload 4
    //   157: bipush 218
    //   159: if_icmpne +129 -> 288
    //   162: ldc 164
    //   164: astore 14
    //   166: iload_2
    //   167: istore_1
    //   168: aload 14
    //   170: astore 16
    //   172: iload_1
    //   173: istore_2
    //   174: iload 8
    //   176: istore 7
    //   178: aload 15
    //   180: ifnull +18 -> 198
    //   183: aload 15
    //   185: invokevirtual 167	java/io/BufferedInputStream:close	()V
    //   188: iload 8
    //   190: istore 7
    //   192: iload_1
    //   193: istore_2
    //   194: aload 14
    //   196: astore 16
    //   198: invokestatic 145	android/os/SystemClock:uptimeMillis	()J
    //   201: lstore 12
    //   203: iload 7
    //   205: istore 8
    //   207: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq -199 -> 11
    //   213: ldc 41
    //   215: iconst_2
    //   216: new 98	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   223: ldc 169
    //   225: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: iload 7
    //   230: invokevirtual 172	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   233: ldc 174
    //   235: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: iload_2
    //   239: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   242: ldc 176
    //   244: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: lload 12
    //   249: lload 10
    //   251: lsub
    //   252: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   255: ldc 181
    //   257: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_0
    //   261: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: ldc 183
    //   266: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 16
    //   271: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: iload 7
    //   282: ireturn
    //   283: iconst_0
    //   284: istore_2
    //   285: goto -181 -> 104
    //   288: iload_2
    //   289: iconst_1
    //   290: iadd
    //   291: istore_2
    //   292: iload_2
    //   293: istore_1
    //   294: aload 15
    //   296: aload 14
    //   298: iconst_0
    //   299: iconst_2
    //   300: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   303: iconst_2
    //   304: if_icmpeq +12 -> 316
    //   307: ldc 188
    //   309: astore 14
    //   311: iload_2
    //   312: istore_1
    //   313: goto -145 -> 168
    //   316: iload_2
    //   317: iconst_2
    //   318: iadd
    //   319: istore_2
    //   320: aload 14
    //   322: iconst_0
    //   323: baload
    //   324: bipush 8
    //   326: ishl
    //   327: ldc 68
    //   329: iand
    //   330: aload 14
    //   332: iconst_1
    //   333: baload
    //   334: sipush 255
    //   337: iand
    //   338: ior
    //   339: iconst_2
    //   340: isub
    //   341: istore 5
    //   343: iload_3
    //   344: iconst_m1
    //   345: if_icmpne +1237 -> 1582
    //   348: iload 4
    //   350: bipush 224
    //   352: if_icmpne +1230 -> 1582
    //   355: iload_2
    //   356: istore_1
    //   357: aload 15
    //   359: iload 5
    //   361: i2l
    //   362: invokestatic 192	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   365: iload 5
    //   367: i2l
    //   368: lcmp
    //   369: ifne +1203 -> 1572
    //   372: iload_2
    //   373: iload 5
    //   375: iadd
    //   376: istore 4
    //   378: goto -256 -> 122
    //   381: iload_2
    //   382: istore_1
    //   383: aload 15
    //   385: aload 16
    //   387: iconst_0
    //   388: iconst_4
    //   389: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   392: iconst_4
    //   393: if_icmpeq +12 -> 405
    //   396: ldc 194
    //   398: astore 14
    //   400: iload_2
    //   401: istore_1
    //   402: goto -234 -> 168
    //   405: iload_2
    //   406: iconst_4
    //   407: iadd
    //   408: istore_2
    //   409: iload_2
    //   410: istore_1
    //   411: ldc 22
    //   413: new 196	java/lang/String
    //   416: dup
    //   417: aload 16
    //   419: invokespecial 199	java/lang/String:<init>	([B)V
    //   422: invokevirtual 202	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   425: ifne +12 -> 437
    //   428: ldc 204
    //   430: astore 14
    //   432: iload_2
    //   433: istore_1
    //   434: goto -266 -> 168
    //   437: iload_2
    //   438: istore_1
    //   439: aload 15
    //   441: ldc2_w 205
    //   444: invokevirtual 209	java/io/BufferedInputStream:skip	(J)J
    //   447: ldc2_w 205
    //   450: lcmp
    //   451: ifeq +12 -> 463
    //   454: ldc 211
    //   456: astore 14
    //   458: iload_2
    //   459: istore_1
    //   460: goto -292 -> 168
    //   463: iload_2
    //   464: iconst_2
    //   465: iadd
    //   466: istore_3
    //   467: iload_3
    //   468: istore_1
    //   469: aload 15
    //   471: aload 14
    //   473: iconst_0
    //   474: iconst_2
    //   475: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   478: iconst_2
    //   479: if_icmpeq +12 -> 491
    //   482: ldc 213
    //   484: astore 14
    //   486: iload_3
    //   487: istore_1
    //   488: goto -320 -> 168
    //   491: iload_3
    //   492: iconst_2
    //   493: iadd
    //   494: istore_2
    //   495: iload_2
    //   496: istore_1
    //   497: new 196	java/lang/String
    //   500: dup
    //   501: aload 14
    //   503: invokespecial 199	java/lang/String:<init>	([B)V
    //   506: astore 17
    //   508: iload_2
    //   509: istore_1
    //   510: ldc 8
    //   512: aload 17
    //   514: invokevirtual 202	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   517: ifeq +32 -> 549
    //   520: iconst_1
    //   521: istore 7
    //   523: iload_2
    //   524: istore_1
    //   525: aload 15
    //   527: ldc2_w 205
    //   530: invokestatic 192	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   533: ldc2_w 205
    //   536: lcmp
    //   537: ifeq +64 -> 601
    //   540: ldc 215
    //   542: astore 14
    //   544: iload_2
    //   545: istore_1
    //   546: goto -378 -> 168
    //   549: iload_2
    //   550: istore_1
    //   551: ldc 29
    //   553: aload 17
    //   555: invokevirtual 202	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   558: ifeq +9 -> 567
    //   561: iconst_0
    //   562: istore 7
    //   564: goto -41 -> 523
    //   567: iload_2
    //   568: istore_1
    //   569: new 98	java/lang/StringBuilder
    //   572: dup
    //   573: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   576: ldc 217
    //   578: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: aload 17
    //   583: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: ldc 219
    //   588: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: astore 14
    //   596: iload_2
    //   597: istore_1
    //   598: goto -430 -> 168
    //   601: iload_2
    //   602: istore_1
    //   603: aload 15
    //   605: aload 16
    //   607: iconst_0
    //   608: iconst_4
    //   609: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   612: iconst_4
    //   613: if_icmpeq +12 -> 625
    //   616: ldc 221
    //   618: astore 14
    //   620: iload_2
    //   621: istore_1
    //   622: goto -454 -> 168
    //   625: iload_2
    //   626: bipush 6
    //   628: iadd
    //   629: istore_2
    //   630: iload_2
    //   631: istore_1
    //   632: iload 7
    //   634: aload 16
    //   636: invokestatic 124	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   639: bipush 8
    //   641: isub
    //   642: istore 4
    //   644: iload 4
    //   646: ifle +29 -> 675
    //   649: iload_2
    //   650: istore_1
    //   651: aload 15
    //   653: iload 4
    //   655: i2l
    //   656: invokestatic 192	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   659: iload 4
    //   661: i2l
    //   662: lcmp
    //   663: ifeq +12 -> 675
    //   666: ldc 223
    //   668: astore 14
    //   670: iload_2
    //   671: istore_1
    //   672: goto -504 -> 168
    //   675: iload_2
    //   676: istore_1
    //   677: aload 15
    //   679: aload 14
    //   681: iconst_0
    //   682: iconst_2
    //   683: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   686: iconst_2
    //   687: if_icmpeq +12 -> 699
    //   690: ldc 225
    //   692: astore 14
    //   694: iload_2
    //   695: istore_1
    //   696: goto -528 -> 168
    //   699: iload_2
    //   700: iload 4
    //   702: iconst_2
    //   703: iadd
    //   704: iadd
    //   705: istore_2
    //   706: iload_2
    //   707: istore_1
    //   708: iload 7
    //   710: aload 14
    //   712: invokestatic 118	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   715: istore 5
    //   717: iconst_0
    //   718: istore 4
    //   720: iload 4
    //   722: iload 5
    //   724: if_icmpge +580 -> 1304
    //   727: iload_2
    //   728: istore_1
    //   729: aload 15
    //   731: aload 14
    //   733: iconst_0
    //   734: iconst_2
    //   735: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   738: iconst_2
    //   739: if_icmpeq +12 -> 751
    //   742: ldc 227
    //   744: astore 14
    //   746: iload_2
    //   747: istore_1
    //   748: goto -580 -> 168
    //   751: iload_2
    //   752: iconst_2
    //   753: iadd
    //   754: istore_2
    //   755: iload_2
    //   756: istore_1
    //   757: iload 7
    //   759: aload 14
    //   761: invokestatic 118	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   764: ldc 38
    //   766: if_icmpne +511 -> 1277
    //   769: iload_2
    //   770: istore_1
    //   771: aload 15
    //   773: aload 14
    //   775: iconst_0
    //   776: iconst_2
    //   777: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   780: iconst_2
    //   781: if_icmpeq +12 -> 793
    //   784: ldc 229
    //   786: astore 14
    //   788: iload_2
    //   789: istore_1
    //   790: goto -622 -> 168
    //   793: iload_2
    //   794: iconst_2
    //   795: iadd
    //   796: istore_2
    //   797: iload_2
    //   798: istore_1
    //   799: iload 7
    //   801: aload 14
    //   803: invokestatic 118	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   806: istore 4
    //   808: iload_2
    //   809: istore_1
    //   810: aload 15
    //   812: aload 16
    //   814: iconst_0
    //   815: iconst_4
    //   816: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   819: iconst_4
    //   820: if_icmpeq +12 -> 832
    //   823: ldc 231
    //   825: astore 14
    //   827: iload_2
    //   828: istore_1
    //   829: goto -661 -> 168
    //   832: iload_2
    //   833: iconst_4
    //   834: iadd
    //   835: istore_2
    //   836: iload_2
    //   837: istore_1
    //   838: iload 7
    //   840: aload 16
    //   842: invokestatic 124	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   845: pop
    //   846: iload_2
    //   847: istore_1
    //   848: getstatic 61	com/tencent/image/JpegExifReader:BYTES_PER_FORMAT	[B
    //   851: iload 4
    //   853: baload
    //   854: istore 5
    //   856: iload_2
    //   857: istore_1
    //   858: aload 15
    //   860: aload 16
    //   862: iconst_0
    //   863: iconst_4
    //   864: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   867: iconst_4
    //   868: if_icmpeq +12 -> 880
    //   871: ldc 233
    //   873: astore 14
    //   875: iload_2
    //   876: istore_1
    //   877: goto -709 -> 168
    //   880: iload_2
    //   881: iconst_4
    //   882: iadd
    //   883: istore_2
    //   884: iload_2
    //   885: istore_1
    //   886: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   889: ifeq +31 -> 920
    //   892: iload_2
    //   893: istore_1
    //   894: ldc 41
    //   896: iconst_2
    //   897: new 98	java/lang/StringBuilder
    //   900: dup
    //   901: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   904: ldc 235
    //   906: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: iload 4
    //   911: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   914: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   917: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   920: iload_2
    //   921: istore_1
    //   922: iload 4
    //   924: iload 7
    //   926: aload 16
    //   928: invokestatic 237	com/tencent/image/JpegExifReader:getValue	(IZ[B)J
    //   931: iload_3
    //   932: i2l
    //   933: ladd
    //   934: iload_2
    //   935: i2l
    //   936: lsub
    //   937: lstore 12
    //   939: iload_2
    //   940: istore_1
    //   941: aload 15
    //   943: lload 12
    //   945: invokestatic 192	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   948: lload 12
    //   950: lcmp
    //   951: ifeq +12 -> 963
    //   954: ldc 239
    //   956: astore 14
    //   958: iload_2
    //   959: istore_1
    //   960: goto -792 -> 168
    //   963: iload_2
    //   964: istore_1
    //   965: aload 15
    //   967: aload 14
    //   969: iconst_0
    //   970: iconst_2
    //   971: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   974: iconst_2
    //   975: if_icmpeq +12 -> 987
    //   978: ldc 241
    //   980: astore 14
    //   982: iload_2
    //   983: istore_1
    //   984: goto -816 -> 168
    //   987: iload_2
    //   988: iconst_2
    //   989: iadd
    //   990: istore_2
    //   991: iload_2
    //   992: istore_1
    //   993: iload 7
    //   995: aload 14
    //   997: invokestatic 118	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1000: istore 4
    //   1002: iconst_0
    //   1003: istore_3
    //   1004: iload_3
    //   1005: iload 4
    //   1007: if_icmpge +240 -> 1247
    //   1010: iload_2
    //   1011: istore_1
    //   1012: aload 15
    //   1014: aload 14
    //   1016: iconst_0
    //   1017: iconst_2
    //   1018: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   1021: iconst_2
    //   1022: if_icmpeq +12 -> 1034
    //   1025: ldc 243
    //   1027: astore 14
    //   1029: iload_2
    //   1030: istore_1
    //   1031: goto -863 -> 168
    //   1034: iload_2
    //   1035: iconst_2
    //   1036: iadd
    //   1037: istore_2
    //   1038: iload_2
    //   1039: istore_1
    //   1040: iload 7
    //   1042: aload 14
    //   1044: invokestatic 118	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1047: ldc 24
    //   1049: if_icmpne +171 -> 1220
    //   1052: iload_2
    //   1053: istore_1
    //   1054: aload 15
    //   1056: aload 14
    //   1058: iconst_0
    //   1059: iconst_2
    //   1060: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   1063: iconst_2
    //   1064: if_icmpeq +12 -> 1076
    //   1067: ldc 245
    //   1069: astore 14
    //   1071: iload_2
    //   1072: istore_1
    //   1073: goto -905 -> 168
    //   1076: iload_2
    //   1077: iconst_2
    //   1078: iadd
    //   1079: istore_2
    //   1080: iload_2
    //   1081: istore_1
    //   1082: iload 7
    //   1084: aload 14
    //   1086: invokestatic 118	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1089: istore 5
    //   1091: iload_2
    //   1092: istore_1
    //   1093: aload 15
    //   1095: aload 16
    //   1097: iconst_0
    //   1098: iconst_4
    //   1099: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   1102: iconst_4
    //   1103: if_icmpeq +12 -> 1115
    //   1106: ldc 247
    //   1108: astore 14
    //   1110: iload_2
    //   1111: istore_1
    //   1112: goto -944 -> 168
    //   1115: iload_2
    //   1116: iconst_4
    //   1117: iadd
    //   1118: istore_2
    //   1119: iload_2
    //   1120: istore_1
    //   1121: iload 7
    //   1123: aload 16
    //   1125: invokestatic 124	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   1128: pop
    //   1129: iload_2
    //   1130: istore_1
    //   1131: getstatic 61	com/tencent/image/JpegExifReader:BYTES_PER_FORMAT	[B
    //   1134: iload 5
    //   1136: baload
    //   1137: istore 6
    //   1139: iload_2
    //   1140: istore_1
    //   1141: aload 15
    //   1143: aload 16
    //   1145: iconst_0
    //   1146: iconst_4
    //   1147: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   1150: iconst_4
    //   1151: if_icmpeq +12 -> 1163
    //   1154: ldc 249
    //   1156: astore 14
    //   1158: iload_2
    //   1159: istore_1
    //   1160: goto -992 -> 168
    //   1163: iload_2
    //   1164: iconst_4
    //   1165: iadd
    //   1166: istore_2
    //   1167: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1170: ifeq +29 -> 1199
    //   1173: ldc 41
    //   1175: iconst_2
    //   1176: new 98	java/lang/StringBuilder
    //   1179: dup
    //   1180: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1183: ldc 251
    //   1185: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1188: iload 5
    //   1190: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1193: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1196: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1199: iload_2
    //   1200: istore_1
    //   1201: iload 5
    //   1203: bipush 12
    //   1205: if_icmpne +404 -> 1609
    //   1208: iconst_1
    //   1209: istore 8
    //   1211: iload_2
    //   1212: istore_1
    //   1213: ldc 253
    //   1215: astore 14
    //   1217: goto -1049 -> 168
    //   1220: iload_2
    //   1221: istore_1
    //   1222: aload 15
    //   1224: ldc2_w 254
    //   1227: invokestatic 192	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1230: ldc2_w 254
    //   1233: lcmp
    //   1234: ifeq +370 -> 1604
    //   1237: ldc_w 257
    //   1240: astore 14
    //   1242: iload_2
    //   1243: istore_1
    //   1244: goto -1076 -> 168
    //   1247: iload_2
    //   1248: istore_1
    //   1249: iload_2
    //   1250: istore_3
    //   1251: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1254: ifeq +309 -> 1563
    //   1257: iload_2
    //   1258: istore_1
    //   1259: ldc 41
    //   1261: iconst_2
    //   1262: ldc_w 259
    //   1265: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1268: ldc 253
    //   1270: astore 14
    //   1272: iload_2
    //   1273: istore_1
    //   1274: goto -1106 -> 168
    //   1277: iload_2
    //   1278: istore_1
    //   1279: aload 15
    //   1281: ldc2_w 254
    //   1284: invokestatic 192	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1287: ldc2_w 254
    //   1290: lcmp
    //   1291: ifeq +327 -> 1618
    //   1294: ldc_w 257
    //   1297: astore 14
    //   1299: iload_2
    //   1300: istore_1
    //   1301: goto -1133 -> 168
    //   1304: iload_2
    //   1305: istore_1
    //   1306: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1309: ifeq +245 -> 1554
    //   1312: iload_2
    //   1313: istore_1
    //   1314: ldc 41
    //   1316: iconst_2
    //   1317: ldc_w 261
    //   1320: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1323: ldc 253
    //   1325: astore 14
    //   1327: iload_2
    //   1328: istore_1
    //   1329: goto -1161 -> 168
    //   1332: astore 15
    //   1334: aload 14
    //   1336: astore 16
    //   1338: iload_1
    //   1339: istore_2
    //   1340: iload 8
    //   1342: istore 7
    //   1344: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1347: ifeq -1149 -> 198
    //   1350: ldc 41
    //   1352: iconst_2
    //   1353: ldc 253
    //   1355: aload 15
    //   1357: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1360: aload 14
    //   1362: astore 16
    //   1364: iload_1
    //   1365: istore_2
    //   1366: iload 8
    //   1368: istore 7
    //   1370: goto -1172 -> 198
    //   1373: astore 15
    //   1375: iconst_0
    //   1376: istore_1
    //   1377: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1380: ifeq +13 -> 1393
    //   1383: ldc 41
    //   1385: iconst_2
    //   1386: ldc 253
    //   1388: aload 15
    //   1390: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1393: aload 14
    //   1395: ifnull +146 -> 1541
    //   1398: aload 14
    //   1400: invokevirtual 167	java/io/BufferedInputStream:close	()V
    //   1403: ldc 253
    //   1405: astore 16
    //   1407: iload_1
    //   1408: istore_2
    //   1409: iload 9
    //   1411: istore 7
    //   1413: goto -1215 -> 198
    //   1416: astore 14
    //   1418: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1421: ifeq +13 -> 1434
    //   1424: ldc 41
    //   1426: iconst_2
    //   1427: ldc 253
    //   1429: aload 14
    //   1431: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1434: ldc 253
    //   1436: astore 16
    //   1438: iload_1
    //   1439: istore_2
    //   1440: iload 9
    //   1442: istore 7
    //   1444: goto -1246 -> 198
    //   1447: astore_0
    //   1448: aconst_null
    //   1449: astore 15
    //   1451: aload 15
    //   1453: ifnull +8 -> 1461
    //   1456: aload 15
    //   1458: invokevirtual 167	java/io/BufferedInputStream:close	()V
    //   1461: aload_0
    //   1462: athrow
    //   1463: astore 14
    //   1465: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1468: ifeq -7 -> 1461
    //   1471: ldc 41
    //   1473: iconst_2
    //   1474: ldc 253
    //   1476: aload 14
    //   1478: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1481: goto -20 -> 1461
    //   1484: astore_0
    //   1485: goto -34 -> 1451
    //   1488: astore_0
    //   1489: aload 14
    //   1491: astore 15
    //   1493: goto -42 -> 1451
    //   1496: astore 16
    //   1498: aload 15
    //   1500: astore 14
    //   1502: aload 16
    //   1504: astore 15
    //   1506: goto -129 -> 1377
    //   1509: astore 14
    //   1511: aload 15
    //   1513: astore 16
    //   1515: aload 14
    //   1517: astore 15
    //   1519: aload 16
    //   1521: astore 14
    //   1523: goto -146 -> 1377
    //   1526: astore 16
    //   1528: aload 15
    //   1530: astore 14
    //   1532: iload_2
    //   1533: istore_1
    //   1534: aload 16
    //   1536: astore 15
    //   1538: goto -161 -> 1377
    //   1541: ldc 253
    //   1543: astore 16
    //   1545: iload_1
    //   1546: istore_2
    //   1547: iload 9
    //   1549: istore 7
    //   1551: goto -1353 -> 198
    //   1554: ldc 253
    //   1556: astore 14
    //   1558: iload_2
    //   1559: istore_1
    //   1560: goto -1392 -> 168
    //   1563: ldc 253
    //   1565: astore 14
    //   1567: iload_3
    //   1568: istore_1
    //   1569: goto -1401 -> 168
    //   1572: ldc_w 266
    //   1575: astore 14
    //   1577: iload_2
    //   1578: istore_1
    //   1579: goto -1411 -> 168
    //   1582: iload_3
    //   1583: iconst_m1
    //   1584: if_icmpne +10 -> 1594
    //   1587: iload 4
    //   1589: bipush 225
    //   1591: if_icmpeq -1210 -> 381
    //   1594: ldc_w 268
    //   1597: astore 14
    //   1599: iload_2
    //   1600: istore_1
    //   1601: goto -1433 -> 168
    //   1604: iload_2
    //   1605: bipush 10
    //   1607: iadd
    //   1608: istore_1
    //   1609: iload_3
    //   1610: iconst_1
    //   1611: iadd
    //   1612: istore_3
    //   1613: iload_1
    //   1614: istore_2
    //   1615: goto -611 -> 1004
    //   1618: iload_2
    //   1619: bipush 10
    //   1621: iadd
    //   1622: istore_2
    //   1623: iload 4
    //   1625: iconst_1
    //   1626: iadd
    //   1627: istore 4
    //   1629: goto -909 -> 720
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1632	0	paramString	String
    //   53	1561	1	i	int
    //   51	1572	2	j	int
    //   29	1584	3	k	int
    //   105	1523	4	m	int
    //   341	865	5	n	int
    //   1137	1	6	i1	int
    //   176	1374	7	bool1	boolean
    //   9	1358	8	bool2	boolean
    //   20	1528	9	bool3	boolean
    //   17	233	10	l1	long
    //   201	748	12	l2	long
    //   26	1373	14	localObject1	Object
    //   1416	14	14	localIOException1	IOException
    //   1463	27	14	localIOException2	IOException
    //   1500	1	14	localObject2	Object
    //   1509	7	14	localThrowable1	java.lang.Throwable
    //   1521	77	14	localObject3	Object
    //   48	1232	15	localBufferedInputStream	java.io.BufferedInputStream
    //   1332	24	15	localIOException3	IOException
    //   1373	16	15	localThrowable2	java.lang.Throwable
    //   1449	88	15	localObject4	Object
    //   120	1317	16	localObject5	Object
    //   1496	7	16	localThrowable3	java.lang.Throwable
    //   1513	7	16	localObject6	Object
    //   1526	9	16	localThrowable4	java.lang.Throwable
    //   1543	1	16	str1	String
    //   506	76	17	str2	String
    // Exception table:
    //   from	to	target	type
    //   183	188	1332	java/io/IOException
    //   30	50	1373	java/lang/Throwable
    //   1398	1403	1416	java/io/IOException
    //   30	50	1447	finally
    //   1456	1461	1463	java/io/IOException
    //   54	59	1484	finally
    //   61	74	1484	finally
    //   117	122	1484	finally
    //   125	136	1484	finally
    //   143	155	1484	finally
    //   294	307	1484	finally
    //   357	372	1484	finally
    //   383	396	1484	finally
    //   411	428	1484	finally
    //   439	454	1484	finally
    //   469	482	1484	finally
    //   497	508	1484	finally
    //   510	520	1484	finally
    //   525	540	1484	finally
    //   551	561	1484	finally
    //   569	596	1484	finally
    //   603	616	1484	finally
    //   632	644	1484	finally
    //   651	666	1484	finally
    //   677	690	1484	finally
    //   708	717	1484	finally
    //   729	742	1484	finally
    //   757	769	1484	finally
    //   771	784	1484	finally
    //   799	808	1484	finally
    //   810	823	1484	finally
    //   838	846	1484	finally
    //   848	856	1484	finally
    //   858	871	1484	finally
    //   886	892	1484	finally
    //   894	920	1484	finally
    //   922	939	1484	finally
    //   941	954	1484	finally
    //   965	978	1484	finally
    //   993	1002	1484	finally
    //   1012	1025	1484	finally
    //   1040	1052	1484	finally
    //   1054	1067	1484	finally
    //   1082	1091	1484	finally
    //   1093	1106	1484	finally
    //   1121	1129	1484	finally
    //   1131	1139	1484	finally
    //   1141	1154	1484	finally
    //   1167	1199	1484	finally
    //   1222	1237	1484	finally
    //   1251	1257	1484	finally
    //   1259	1268	1484	finally
    //   1279	1294	1484	finally
    //   1306	1312	1484	finally
    //   1314	1323	1484	finally
    //   1377	1393	1488	finally
    //   54	59	1496	java/lang/Throwable
    //   61	74	1496	java/lang/Throwable
    //   117	122	1496	java/lang/Throwable
    //   125	136	1496	java/lang/Throwable
    //   143	155	1496	java/lang/Throwable
    //   294	307	1496	java/lang/Throwable
    //   357	372	1496	java/lang/Throwable
    //   383	396	1496	java/lang/Throwable
    //   411	428	1496	java/lang/Throwable
    //   439	454	1496	java/lang/Throwable
    //   469	482	1496	java/lang/Throwable
    //   993	1002	1496	java/lang/Throwable
    //   1012	1025	1496	java/lang/Throwable
    //   1040	1052	1496	java/lang/Throwable
    //   1054	1067	1496	java/lang/Throwable
    //   1082	1091	1496	java/lang/Throwable
    //   1093	1106	1496	java/lang/Throwable
    //   1121	1129	1496	java/lang/Throwable
    //   1131	1139	1496	java/lang/Throwable
    //   1141	1154	1496	java/lang/Throwable
    //   1222	1237	1496	java/lang/Throwable
    //   1251	1257	1496	java/lang/Throwable
    //   1259	1268	1496	java/lang/Throwable
    //   497	508	1509	java/lang/Throwable
    //   510	520	1509	java/lang/Throwable
    //   525	540	1509	java/lang/Throwable
    //   551	561	1509	java/lang/Throwable
    //   569	596	1509	java/lang/Throwable
    //   603	616	1509	java/lang/Throwable
    //   632	644	1509	java/lang/Throwable
    //   651	666	1509	java/lang/Throwable
    //   677	690	1509	java/lang/Throwable
    //   708	717	1509	java/lang/Throwable
    //   729	742	1509	java/lang/Throwable
    //   757	769	1509	java/lang/Throwable
    //   771	784	1509	java/lang/Throwable
    //   799	808	1509	java/lang/Throwable
    //   810	823	1509	java/lang/Throwable
    //   838	846	1509	java/lang/Throwable
    //   848	856	1509	java/lang/Throwable
    //   858	871	1509	java/lang/Throwable
    //   886	892	1509	java/lang/Throwable
    //   894	920	1509	java/lang/Throwable
    //   922	939	1509	java/lang/Throwable
    //   941	954	1509	java/lang/Throwable
    //   965	978	1509	java/lang/Throwable
    //   1279	1294	1509	java/lang/Throwable
    //   1306	1312	1509	java/lang/Throwable
    //   1314	1323	1509	java/lang/Throwable
    //   1167	1199	1526	java/lang/Throwable
  }
  
  /* Error */
  public static int readOrientation(String paramString)
  {
    // Byte code:
    //   0: invokestatic 145	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 6
    //   5: getstatic 54	com/tencent/image/JpegExifReader:sIsReadDpc	Z
    //   8: ifne +24 -> 32
    //   11: getstatic 128	com/tencent/image/JpegExifReader:jpegExifReaderInterface	Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;
    //   14: ifnull +18 -> 32
    //   17: getstatic 128	com/tencent/image/JpegExifReader:jpegExifReaderInterface	Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;
    //   20: invokeinterface 273 1 0
    //   25: putstatic 52	com/tencent/image/JpegExifReader:sIsEnable	Z
    //   28: iconst_1
    //   29: putstatic 54	com/tencent/image/JpegExifReader:sIsReadDpc	Z
    //   32: getstatic 52	com/tencent/image/JpegExifReader:sIsEnable	Z
    //   35: ifne +51 -> 86
    //   38: new 275	android/media/ExifInterface
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 276	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   46: astore_0
    //   47: aload_0
    //   48: ifnonnull +29 -> 77
    //   51: iconst_0
    //   52: istore_3
    //   53: iload_3
    //   54: ireturn
    //   55: astore_0
    //   56: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +13 -> 72
    //   62: ldc 41
    //   64: iconst_2
    //   65: ldc_w 278
    //   68: aload_0
    //   69: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   72: aconst_null
    //   73: astore_0
    //   74: goto -27 -> 47
    //   77: aload_0
    //   78: ldc_w 280
    //   81: iconst_1
    //   82: invokevirtual 284	android/media/ExifInterface:getAttributeInt	(Ljava/lang/String;I)I
    //   85: ireturn
    //   86: aconst_null
    //   87: astore 10
    //   89: iconst_0
    //   90: istore_3
    //   91: ldc 253
    //   93: astore 9
    //   95: new 147	java/io/BufferedInputStream
    //   98: dup
    //   99: new 149	java/io/FileInputStream
    //   102: dup
    //   103: aload_0
    //   104: invokespecial 152	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   107: sipush 512
    //   110: invokespecial 155	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   113: astore 12
    //   115: iconst_0
    //   116: istore_2
    //   117: aload 9
    //   119: astore 11
    //   121: iload_3
    //   122: istore_1
    //   123: iconst_2
    //   124: newarray byte
    //   126: astore 14
    //   128: aload 9
    //   130: astore 11
    //   132: iload_3
    //   133: istore_1
    //   134: aload 12
    //   136: aload 14
    //   138: iconst_0
    //   139: iconst_2
    //   140: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   143: iconst_2
    //   144: if_icmpne +33 -> 177
    //   147: aload 14
    //   149: iconst_0
    //   150: baload
    //   151: sipush 255
    //   154: iand
    //   155: sipush 255
    //   158: if_icmpne +231 -> 389
    //   161: aload 14
    //   163: iconst_1
    //   164: baload
    //   165: sipush 255
    //   168: iand
    //   169: sipush 216
    //   172: if_icmpne +217 -> 389
    //   175: iconst_1
    //   176: istore_2
    //   177: iconst_2
    //   178: istore_3
    //   179: aload 9
    //   181: astore 13
    //   183: iload_3
    //   184: istore 4
    //   186: iload_2
    //   187: ifeq +1567 -> 1754
    //   190: aload 9
    //   192: astore 11
    //   194: iload_3
    //   195: istore_1
    //   196: iconst_4
    //   197: newarray byte
    //   199: astore 13
    //   201: iload_3
    //   202: istore_2
    //   203: aload 9
    //   205: astore 11
    //   207: iload_2
    //   208: istore_1
    //   209: aload 12
    //   211: invokevirtual 162	java/io/BufferedInputStream:read	()I
    //   214: sipush 255
    //   217: iand
    //   218: i2b
    //   219: istore_3
    //   220: iload_2
    //   221: iconst_1
    //   222: iadd
    //   223: istore_2
    //   224: aload 9
    //   226: astore 11
    //   228: iload_2
    //   229: istore_1
    //   230: aload 12
    //   232: invokevirtual 162	java/io/BufferedInputStream:read	()I
    //   235: sipush 255
    //   238: iand
    //   239: i2b
    //   240: istore 4
    //   242: iload 4
    //   244: bipush 218
    //   246: if_icmpne +148 -> 394
    //   249: ldc 164
    //   251: astore 9
    //   253: iload_2
    //   254: istore_1
    //   255: iconst_1
    //   256: istore_2
    //   257: aload 9
    //   259: astore 11
    //   261: iload_1
    //   262: istore 4
    //   264: iload_2
    //   265: istore_3
    //   266: aload 12
    //   268: ifnull +1474 -> 1742
    //   271: aload 12
    //   273: invokevirtual 167	java/io/BufferedInputStream:close	()V
    //   276: iload_1
    //   277: istore_3
    //   278: iload_2
    //   279: istore_1
    //   280: iload_3
    //   281: istore_2
    //   282: invokestatic 145	android/os/SystemClock:uptimeMillis	()J
    //   285: lload 6
    //   287: lsub
    //   288: lstore 6
    //   290: getstatic 128	com/tencent/image/JpegExifReader:jpegExifReaderInterface	Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;
    //   293: ifnull +21 -> 314
    //   296: getstatic 128	com/tencent/image/JpegExifReader:jpegExifReaderInterface	Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;
    //   299: aconst_null
    //   300: ldc 34
    //   302: iconst_1
    //   303: lload 6
    //   305: iload_2
    //   306: i2l
    //   307: aconst_null
    //   308: aconst_null
    //   309: invokeinterface 288 10 0
    //   314: iload_1
    //   315: istore_3
    //   316: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq -266 -> 53
    //   322: ldc 41
    //   324: iconst_2
    //   325: new 98	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   332: ldc_w 290
    //   335: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: iload_1
    //   339: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: ldc 174
    //   344: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: iload_2
    //   348: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   351: ldc 176
    //   353: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: lload 6
    //   358: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   361: ldc 181
    //   363: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_0
    //   367: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: ldc_w 292
    //   373: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: aload 9
    //   378: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   387: iload_1
    //   388: ireturn
    //   389: iconst_0
    //   390: istore_2
    //   391: goto -214 -> 177
    //   394: iload_2
    //   395: iconst_1
    //   396: iadd
    //   397: istore_2
    //   398: aload 9
    //   400: astore 11
    //   402: iload_2
    //   403: istore_1
    //   404: aload 12
    //   406: aload 14
    //   408: iconst_0
    //   409: iconst_2
    //   410: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   413: iconst_2
    //   414: if_icmpeq +14 -> 428
    //   417: ldc 188
    //   419: astore 9
    //   421: iload_2
    //   422: istore_1
    //   423: iconst_1
    //   424: istore_2
    //   425: goto -168 -> 257
    //   428: iload_2
    //   429: iconst_2
    //   430: iadd
    //   431: istore_2
    //   432: aload 14
    //   434: iconst_0
    //   435: baload
    //   436: bipush 8
    //   438: ishl
    //   439: ldc 68
    //   441: iand
    //   442: aload 14
    //   444: iconst_1
    //   445: baload
    //   446: sipush 255
    //   449: iand
    //   450: ior
    //   451: iconst_2
    //   452: isub
    //   453: istore 5
    //   455: iload_3
    //   456: iconst_m1
    //   457: if_icmpne +39 -> 496
    //   460: iload 4
    //   462: bipush 224
    //   464: if_icmpne +32 -> 496
    //   467: aload 9
    //   469: astore 11
    //   471: iload_2
    //   472: istore_1
    //   473: aload 12
    //   475: iload 5
    //   477: i2l
    //   478: invokestatic 192	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   481: iload 5
    //   483: i2l
    //   484: lcmp
    //   485: ifne +1290 -> 1775
    //   488: iload_2
    //   489: iload 5
    //   491: iadd
    //   492: istore_2
    //   493: goto -290 -> 203
    //   496: iload_3
    //   497: iconst_m1
    //   498: if_icmpne +1289 -> 1787
    //   501: iload 4
    //   503: bipush 225
    //   505: if_icmpeq +1282 -> 1787
    //   508: iload 4
    //   510: bipush 225
    //   512: if_icmple +121 -> 633
    //   515: iload 4
    //   517: bipush 239
    //   519: if_icmpge +114 -> 633
    //   522: aload 9
    //   524: astore 11
    //   526: iload_2
    //   527: istore_1
    //   528: aload 12
    //   530: iload 5
    //   532: i2l
    //   533: invokestatic 192	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   536: iload 5
    //   538: i2l
    //   539: lcmp
    //   540: ifne +51 -> 591
    //   543: aload 9
    //   545: astore 11
    //   547: iload_2
    //   548: istore_1
    //   549: new 98	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   556: aload 9
    //   558: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: ldc_w 294
    //   564: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: iload 4
    //   569: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   572: ldc_w 296
    //   575: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: astore 9
    //   583: iload_2
    //   584: iload 5
    //   586: iadd
    //   587: istore_2
    //   588: goto -385 -> 203
    //   591: aload 9
    //   593: astore 11
    //   595: iload_2
    //   596: istore_1
    //   597: new 98	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   604: ldc_w 294
    //   607: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: iload 4
    //   612: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   615: ldc_w 298
    //   618: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: astore 9
    //   626: iload_2
    //   627: istore_1
    //   628: iconst_1
    //   629: istore_2
    //   630: goto -373 -> 257
    //   633: aload 9
    //   635: astore 11
    //   637: iload_2
    //   638: istore_1
    //   639: new 98	java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   646: ldc_w 300
    //   649: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: iload 4
    //   654: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   657: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   660: astore 9
    //   662: iload_2
    //   663: istore_1
    //   664: iconst_1
    //   665: istore_2
    //   666: goto -409 -> 257
    //   669: aload 9
    //   671: astore 11
    //   673: iload_2
    //   674: istore_1
    //   675: aload 12
    //   677: aload 13
    //   679: iconst_0
    //   680: iconst_4
    //   681: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   684: iconst_4
    //   685: if_icmpeq +14 -> 699
    //   688: ldc 194
    //   690: astore 9
    //   692: iload_2
    //   693: istore_1
    //   694: iconst_1
    //   695: istore_2
    //   696: goto -439 -> 257
    //   699: aload 9
    //   701: astore 11
    //   703: iload_2
    //   704: istore_1
    //   705: ldc 22
    //   707: new 196	java/lang/String
    //   710: dup
    //   711: aload 13
    //   713: invokespecial 199	java/lang/String:<init>	([B)V
    //   716: invokevirtual 202	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   719: ifne +14 -> 733
    //   722: ldc 204
    //   724: astore 9
    //   726: iload_2
    //   727: istore_1
    //   728: iconst_1
    //   729: istore_2
    //   730: goto -473 -> 257
    //   733: aload 9
    //   735: astore 11
    //   737: iload_2
    //   738: istore_1
    //   739: aload 12
    //   741: ldc2_w 205
    //   744: invokevirtual 209	java/io/BufferedInputStream:skip	(J)J
    //   747: ldc2_w 205
    //   750: lcmp
    //   751: ifeq +14 -> 765
    //   754: ldc 211
    //   756: astore 9
    //   758: iload_2
    //   759: istore_1
    //   760: iconst_1
    //   761: istore_2
    //   762: goto -505 -> 257
    //   765: iload_2
    //   766: iconst_2
    //   767: iadd
    //   768: istore_2
    //   769: aload 9
    //   771: astore 11
    //   773: iload_2
    //   774: istore_1
    //   775: aload 12
    //   777: aload 14
    //   779: iconst_0
    //   780: iconst_2
    //   781: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   784: iconst_2
    //   785: if_icmpeq +14 -> 799
    //   788: ldc 213
    //   790: astore 9
    //   792: iload_2
    //   793: istore_1
    //   794: iconst_1
    //   795: istore_2
    //   796: goto -539 -> 257
    //   799: iload_2
    //   800: iconst_2
    //   801: iadd
    //   802: istore_2
    //   803: aload 9
    //   805: astore 11
    //   807: iload_2
    //   808: istore_1
    //   809: new 196	java/lang/String
    //   812: dup
    //   813: aload 14
    //   815: invokespecial 199	java/lang/String:<init>	([B)V
    //   818: astore 10
    //   820: aload 9
    //   822: astore 11
    //   824: iload_2
    //   825: istore_1
    //   826: ldc 8
    //   828: aload 10
    //   830: invokevirtual 202	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   833: ifeq +38 -> 871
    //   836: iconst_1
    //   837: istore 8
    //   839: aload 9
    //   841: astore 11
    //   843: iload_2
    //   844: istore_1
    //   845: aload 12
    //   847: ldc2_w 205
    //   850: invokestatic 192	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   853: ldc2_w 205
    //   856: lcmp
    //   857: ifeq +76 -> 933
    //   860: ldc 215
    //   862: astore 9
    //   864: iload_2
    //   865: istore_1
    //   866: iconst_1
    //   867: istore_2
    //   868: goto -611 -> 257
    //   871: aload 9
    //   873: astore 11
    //   875: iload_2
    //   876: istore_1
    //   877: ldc 29
    //   879: aload 10
    //   881: invokevirtual 202	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   884: ifeq +9 -> 893
    //   887: iconst_0
    //   888: istore 8
    //   890: goto -51 -> 839
    //   893: aload 9
    //   895: astore 11
    //   897: iload_2
    //   898: istore_1
    //   899: new 98	java/lang/StringBuilder
    //   902: dup
    //   903: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   906: ldc 217
    //   908: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: aload 10
    //   913: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: ldc 219
    //   918: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   924: astore 9
    //   926: iload_2
    //   927: istore_1
    //   928: iconst_1
    //   929: istore_2
    //   930: goto -673 -> 257
    //   933: aload 9
    //   935: astore 11
    //   937: iload_2
    //   938: istore_1
    //   939: aload 12
    //   941: aload 13
    //   943: iconst_0
    //   944: iconst_4
    //   945: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   948: iconst_4
    //   949: if_icmpeq +14 -> 963
    //   952: ldc 221
    //   954: astore 9
    //   956: iload_2
    //   957: istore_1
    //   958: iconst_1
    //   959: istore_2
    //   960: goto -703 -> 257
    //   963: iload_2
    //   964: bipush 6
    //   966: iadd
    //   967: istore_2
    //   968: aload 9
    //   970: astore 11
    //   972: iload_2
    //   973: istore_1
    //   974: iload 8
    //   976: aload 13
    //   978: invokestatic 124	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   981: bipush 8
    //   983: isub
    //   984: istore_3
    //   985: iload_3
    //   986: ifle +33 -> 1019
    //   989: aload 9
    //   991: astore 11
    //   993: iload_2
    //   994: istore_1
    //   995: aload 12
    //   997: iload_3
    //   998: i2l
    //   999: invokestatic 192	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1002: iload_3
    //   1003: i2l
    //   1004: lcmp
    //   1005: ifeq +14 -> 1019
    //   1008: ldc 223
    //   1010: astore 9
    //   1012: iload_2
    //   1013: istore_1
    //   1014: iconst_1
    //   1015: istore_2
    //   1016: goto -759 -> 257
    //   1019: aload 9
    //   1021: astore 11
    //   1023: iload_2
    //   1024: istore_1
    //   1025: aload 12
    //   1027: aload 14
    //   1029: iconst_0
    //   1030: iconst_2
    //   1031: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   1034: iconst_2
    //   1035: if_icmpeq +14 -> 1049
    //   1038: ldc 225
    //   1040: astore 9
    //   1042: iload_2
    //   1043: istore_1
    //   1044: iconst_1
    //   1045: istore_2
    //   1046: goto -789 -> 257
    //   1049: iload_2
    //   1050: iload_3
    //   1051: iconst_2
    //   1052: iadd
    //   1053: iadd
    //   1054: istore_2
    //   1055: aload 9
    //   1057: astore 11
    //   1059: iload_2
    //   1060: istore_1
    //   1061: iload 8
    //   1063: aload 14
    //   1065: invokestatic 118	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1068: istore 5
    //   1070: iconst_0
    //   1071: istore 4
    //   1073: aload 9
    //   1075: astore 10
    //   1077: iload_2
    //   1078: istore_3
    //   1079: iload 4
    //   1081: iload 5
    //   1083: if_icmpge +206 -> 1289
    //   1086: aload 9
    //   1088: astore 11
    //   1090: iload_2
    //   1091: istore_1
    //   1092: aload 12
    //   1094: aload 14
    //   1096: iconst_0
    //   1097: iconst_2
    //   1098: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   1101: iconst_2
    //   1102: if_icmpeq +15 -> 1117
    //   1105: ldc_w 302
    //   1108: astore 9
    //   1110: iload_2
    //   1111: istore_1
    //   1112: iconst_1
    //   1113: istore_2
    //   1114: goto -857 -> 257
    //   1117: iload_2
    //   1118: iconst_2
    //   1119: iadd
    //   1120: istore_2
    //   1121: aload 9
    //   1123: astore 11
    //   1125: iload_2
    //   1126: istore_1
    //   1127: iload 8
    //   1129: aload 14
    //   1131: invokestatic 118	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1134: sipush 274
    //   1137: if_icmpne +377 -> 1514
    //   1140: aload 9
    //   1142: astore 11
    //   1144: iload_2
    //   1145: istore_1
    //   1146: aload 12
    //   1148: aload 14
    //   1150: iconst_0
    //   1151: iconst_2
    //   1152: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   1155: iconst_2
    //   1156: if_icmpeq +15 -> 1171
    //   1159: ldc_w 304
    //   1162: astore 9
    //   1164: iload_2
    //   1165: istore_1
    //   1166: iconst_1
    //   1167: istore_2
    //   1168: goto -911 -> 257
    //   1171: iload_2
    //   1172: iconst_2
    //   1173: iadd
    //   1174: istore_2
    //   1175: aload 9
    //   1177: astore 11
    //   1179: iload_2
    //   1180: istore_1
    //   1181: iload 8
    //   1183: aload 14
    //   1185: invokestatic 118	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1188: istore 4
    //   1190: aload 9
    //   1192: astore 11
    //   1194: iload_2
    //   1195: istore_1
    //   1196: aload 12
    //   1198: aload 13
    //   1200: iconst_0
    //   1201: iconst_4
    //   1202: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   1205: iconst_4
    //   1206: if_icmpeq +14 -> 1220
    //   1209: ldc 231
    //   1211: astore 9
    //   1213: iload_2
    //   1214: istore_1
    //   1215: iconst_1
    //   1216: istore_2
    //   1217: goto -960 -> 257
    //   1220: iload_2
    //   1221: iconst_4
    //   1222: iadd
    //   1223: istore_3
    //   1224: aload 9
    //   1226: astore 11
    //   1228: iload_3
    //   1229: istore_1
    //   1230: iload 8
    //   1232: aload 13
    //   1234: invokestatic 124	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   1237: getstatic 61	com/tencent/image/JpegExifReader:BYTES_PER_FORMAT	[B
    //   1240: iload 4
    //   1242: baload
    //   1243: imul
    //   1244: istore_2
    //   1245: iload_2
    //   1246: iconst_4
    //   1247: if_icmple +87 -> 1334
    //   1250: aload 9
    //   1252: astore 11
    //   1254: iload_3
    //   1255: istore_1
    //   1256: new 98	java/lang/StringBuilder
    //   1259: dup
    //   1260: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1263: ldc_w 306
    //   1266: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1269: iload 4
    //   1271: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1274: ldc_w 308
    //   1277: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: iload_2
    //   1281: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1284: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1287: astore 10
    //   1289: aload 10
    //   1291: astore 11
    //   1293: iload_3
    //   1294: istore_1
    //   1295: aload 10
    //   1297: astore 13
    //   1299: iload_3
    //   1300: istore 4
    //   1302: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1305: ifeq +449 -> 1754
    //   1308: aload 10
    //   1310: astore 11
    //   1312: iload_3
    //   1313: istore_1
    //   1314: ldc 41
    //   1316: iconst_2
    //   1317: ldc_w 261
    //   1320: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1323: aload 10
    //   1325: astore 9
    //   1327: iload_3
    //   1328: istore_1
    //   1329: iconst_1
    //   1330: istore_2
    //   1331: goto -1074 -> 257
    //   1334: aload 9
    //   1336: astore 11
    //   1338: iload_3
    //   1339: istore_1
    //   1340: aload 12
    //   1342: aload 13
    //   1344: iconst_0
    //   1345: iconst_4
    //   1346: invokevirtual 159	java/io/BufferedInputStream:read	([BII)I
    //   1349: iconst_4
    //   1350: if_icmpeq +461 -> 1811
    //   1353: ldc_w 310
    //   1356: astore 9
    //   1358: iload_3
    //   1359: istore_1
    //   1360: iconst_1
    //   1361: istore_2
    //   1362: goto -1105 -> 257
    //   1365: aload 9
    //   1367: astore 11
    //   1369: iload_2
    //   1370: istore_1
    //   1371: new 98	java/lang/StringBuilder
    //   1374: dup
    //   1375: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1378: ldc_w 312
    //   1381: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1384: iload 4
    //   1386: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1389: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1392: astore 9
    //   1394: iconst_1
    //   1395: istore_1
    //   1396: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1399: ifeq +367 -> 1766
    //   1402: ldc 41
    //   1404: iconst_2
    //   1405: new 98	java/lang/StringBuilder
    //   1408: dup
    //   1409: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1412: ldc_w 314
    //   1415: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1418: iload_1
    //   1419: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1422: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1425: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1428: iload_1
    //   1429: istore_3
    //   1430: iload_2
    //   1431: istore_1
    //   1432: iload_3
    //   1433: istore_2
    //   1434: goto -1177 -> 257
    //   1437: aload 9
    //   1439: astore 11
    //   1441: iload_2
    //   1442: istore_1
    //   1443: iload 8
    //   1445: aload 13
    //   1447: invokestatic 118	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1450: istore_3
    //   1451: iload_3
    //   1452: istore_1
    //   1453: goto -57 -> 1396
    //   1456: aload 9
    //   1458: astore 11
    //   1460: iload_2
    //   1461: istore_1
    //   1462: iload 8
    //   1464: aload 13
    //   1466: invokestatic 120	com/tencent/image/JpegExifReader:getUnsignedInt32	(Z[B)J
    //   1469: l2i
    //   1470: istore_3
    //   1471: iload_3
    //   1472: istore_1
    //   1473: goto -77 -> 1396
    //   1476: aload 9
    //   1478: astore 11
    //   1480: iload_2
    //   1481: istore_1
    //   1482: iload 8
    //   1484: aload 13
    //   1486: invokestatic 122	com/tencent/image/JpegExifReader:getInt16	(Z[B)S
    //   1489: istore_3
    //   1490: iload_3
    //   1491: istore_1
    //   1492: goto -96 -> 1396
    //   1495: aload 9
    //   1497: astore 11
    //   1499: iload_2
    //   1500: istore_1
    //   1501: iload 8
    //   1503: aload 13
    //   1505: invokestatic 124	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   1508: istore_3
    //   1509: iload_3
    //   1510: istore_1
    //   1511: goto -115 -> 1396
    //   1514: aload 9
    //   1516: astore 11
    //   1518: iload_2
    //   1519: istore_1
    //   1520: aload 12
    //   1522: ldc2_w 254
    //   1525: invokestatic 192	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1528: ldc2_w 254
    //   1531: lcmp
    //   1532: ifeq +15 -> 1547
    //   1535: ldc_w 257
    //   1538: astore 9
    //   1540: iload_2
    //   1541: istore_1
    //   1542: iconst_1
    //   1543: istore_2
    //   1544: goto -1287 -> 257
    //   1547: iload_2
    //   1548: bipush 10
    //   1550: iadd
    //   1551: istore_2
    //   1552: iload 4
    //   1554: iconst_1
    //   1555: iadd
    //   1556: istore 4
    //   1558: goto -485 -> 1073
    //   1561: astore 10
    //   1563: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1566: ifeq +13 -> 1579
    //   1569: ldc 41
    //   1571: iconst_2
    //   1572: ldc 253
    //   1574: aload 10
    //   1576: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1579: iload_2
    //   1580: istore_3
    //   1581: iload_1
    //   1582: istore_2
    //   1583: iload_3
    //   1584: istore_1
    //   1585: goto -1303 -> 282
    //   1588: astore 11
    //   1590: ldc 253
    //   1592: astore 9
    //   1594: iconst_0
    //   1595: istore_2
    //   1596: iconst_1
    //   1597: istore_1
    //   1598: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1601: ifeq +13 -> 1614
    //   1604: ldc 41
    //   1606: iconst_2
    //   1607: ldc 253
    //   1609: aload 11
    //   1611: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1614: aload 9
    //   1616: astore 11
    //   1618: iload_2
    //   1619: istore 4
    //   1621: iload_1
    //   1622: istore_3
    //   1623: aload 10
    //   1625: ifnull +117 -> 1742
    //   1628: aload 10
    //   1630: invokevirtual 167	java/io/BufferedInputStream:close	()V
    //   1633: goto -1351 -> 282
    //   1636: astore 10
    //   1638: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1641: ifeq +13 -> 1654
    //   1644: ldc 41
    //   1646: iconst_2
    //   1647: ldc 253
    //   1649: aload 10
    //   1651: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1654: goto -1372 -> 282
    //   1657: astore_0
    //   1658: aconst_null
    //   1659: astore 12
    //   1661: aload 12
    //   1663: ifnull +8 -> 1671
    //   1666: aload 12
    //   1668: invokevirtual 167	java/io/BufferedInputStream:close	()V
    //   1671: aload_0
    //   1672: athrow
    //   1673: astore 9
    //   1675: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1678: ifeq -7 -> 1671
    //   1681: ldc 41
    //   1683: iconst_2
    //   1684: ldc 253
    //   1686: aload 9
    //   1688: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1691: goto -20 -> 1671
    //   1694: astore_0
    //   1695: goto -34 -> 1661
    //   1698: astore_0
    //   1699: aload 10
    //   1701: astore 12
    //   1703: goto -42 -> 1661
    //   1706: astore 9
    //   1708: aload 12
    //   1710: astore 10
    //   1712: aload 9
    //   1714: astore 12
    //   1716: aload 11
    //   1718: astore 9
    //   1720: iconst_1
    //   1721: istore_3
    //   1722: iload_1
    //   1723: istore_2
    //   1724: iload_3
    //   1725: istore_1
    //   1726: aload 12
    //   1728: astore 11
    //   1730: goto -132 -> 1598
    //   1733: astore 11
    //   1735: aload 12
    //   1737: astore 10
    //   1739: goto -141 -> 1598
    //   1742: aload 11
    //   1744: astore 9
    //   1746: iload 4
    //   1748: istore_2
    //   1749: iload_3
    //   1750: istore_1
    //   1751: goto -1469 -> 282
    //   1754: aload 13
    //   1756: astore 9
    //   1758: iload 4
    //   1760: istore_1
    //   1761: iconst_1
    //   1762: istore_2
    //   1763: goto -1506 -> 257
    //   1766: iload_1
    //   1767: istore_3
    //   1768: iload_2
    //   1769: istore_1
    //   1770: iload_3
    //   1771: istore_2
    //   1772: goto -1515 -> 257
    //   1775: ldc_w 266
    //   1778: astore 9
    //   1780: iload_2
    //   1781: istore_1
    //   1782: iconst_1
    //   1783: istore_2
    //   1784: goto -1527 -> 257
    //   1787: iload_3
    //   1788: iconst_m1
    //   1789: if_icmpne +10 -> 1799
    //   1792: iload 4
    //   1794: bipush 225
    //   1796: if_icmpeq -1127 -> 669
    //   1799: ldc_w 268
    //   1802: astore 9
    //   1804: iload_2
    //   1805: istore_1
    //   1806: iconst_1
    //   1807: istore_2
    //   1808: goto -1551 -> 257
    //   1811: iload_3
    //   1812: iconst_4
    //   1813: iadd
    //   1814: istore_2
    //   1815: iload 4
    //   1817: tableswitch	default:+43 -> 1860, 3:+-380->1437, 4:+-361->1456, 5:+-452->1365, 6:+46->1863, 7:+-452->1365, 8:+-341->1476, 9:+-322->1495
    //   1861: impdep1
    //   1862: sipush 6413
    //   1865: iconst_0
    //   1866: baload
    //   1867: istore_1
    //   1868: goto -472 -> 1396
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1871	0	paramString	String
    //   122	1746	1	i	int
    //   116	1699	2	j	int
    //   52	1762	3	k	int
    //   184	1632	4	m	int
    //   453	631	5	n	int
    //   3	354	6	l	long
    //   837	665	8	bool	boolean
    //   93	1522	9	localObject1	Object
    //   1673	14	9	localIOException1	IOException
    //   1706	7	9	localThrowable1	java.lang.Throwable
    //   1718	85	9	localObject2	Object
    //   87	1237	10	localObject3	Object
    //   1561	68	10	localIOException2	IOException
    //   1636	64	10	localIOException3	IOException
    //   1710	28	10	localObject4	Object
    //   119	1398	11	localObject5	Object
    //   1588	22	11	localThrowable2	java.lang.Throwable
    //   1616	113	11	localObject6	Object
    //   1733	10	11	localThrowable3	java.lang.Throwable
    //   113	1623	12	localObject7	Object
    //   181	1683	13	localObject8	Object
    //   126	1058	14	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   38	47	55	java/io/IOException
    //   271	276	1561	java/io/IOException
    //   95	115	1588	java/lang/Throwable
    //   1628	1633	1636	java/io/IOException
    //   95	115	1657	finally
    //   1666	1671	1673	java/io/IOException
    //   123	128	1694	finally
    //   134	147	1694	finally
    //   196	201	1694	finally
    //   209	220	1694	finally
    //   230	242	1694	finally
    //   404	417	1694	finally
    //   473	488	1694	finally
    //   528	543	1694	finally
    //   549	583	1694	finally
    //   597	626	1694	finally
    //   639	662	1694	finally
    //   675	688	1694	finally
    //   705	722	1694	finally
    //   739	754	1694	finally
    //   775	788	1694	finally
    //   809	820	1694	finally
    //   826	836	1694	finally
    //   845	860	1694	finally
    //   877	887	1694	finally
    //   899	926	1694	finally
    //   939	952	1694	finally
    //   974	985	1694	finally
    //   995	1008	1694	finally
    //   1025	1038	1694	finally
    //   1061	1070	1694	finally
    //   1092	1105	1694	finally
    //   1127	1140	1694	finally
    //   1146	1159	1694	finally
    //   1181	1190	1694	finally
    //   1196	1209	1694	finally
    //   1230	1245	1694	finally
    //   1256	1289	1694	finally
    //   1302	1308	1694	finally
    //   1314	1323	1694	finally
    //   1340	1353	1694	finally
    //   1371	1394	1694	finally
    //   1396	1428	1694	finally
    //   1443	1451	1694	finally
    //   1462	1471	1694	finally
    //   1482	1490	1694	finally
    //   1501	1509	1694	finally
    //   1520	1535	1694	finally
    //   1598	1614	1698	finally
    //   123	128	1706	java/lang/Throwable
    //   134	147	1706	java/lang/Throwable
    //   196	201	1706	java/lang/Throwable
    //   209	220	1706	java/lang/Throwable
    //   230	242	1706	java/lang/Throwable
    //   404	417	1706	java/lang/Throwable
    //   473	488	1706	java/lang/Throwable
    //   528	543	1706	java/lang/Throwable
    //   549	583	1706	java/lang/Throwable
    //   597	626	1706	java/lang/Throwable
    //   639	662	1706	java/lang/Throwable
    //   675	688	1706	java/lang/Throwable
    //   705	722	1706	java/lang/Throwable
    //   739	754	1706	java/lang/Throwable
    //   775	788	1706	java/lang/Throwable
    //   809	820	1706	java/lang/Throwable
    //   826	836	1706	java/lang/Throwable
    //   845	860	1706	java/lang/Throwable
    //   877	887	1706	java/lang/Throwable
    //   899	926	1706	java/lang/Throwable
    //   939	952	1706	java/lang/Throwable
    //   974	985	1706	java/lang/Throwable
    //   995	1008	1706	java/lang/Throwable
    //   1025	1038	1706	java/lang/Throwable
    //   1061	1070	1706	java/lang/Throwable
    //   1092	1105	1706	java/lang/Throwable
    //   1127	1140	1706	java/lang/Throwable
    //   1146	1159	1706	java/lang/Throwable
    //   1181	1190	1706	java/lang/Throwable
    //   1196	1209	1706	java/lang/Throwable
    //   1230	1245	1706	java/lang/Throwable
    //   1256	1289	1706	java/lang/Throwable
    //   1302	1308	1706	java/lang/Throwable
    //   1314	1323	1706	java/lang/Throwable
    //   1340	1353	1706	java/lang/Throwable
    //   1371	1394	1706	java/lang/Throwable
    //   1443	1451	1706	java/lang/Throwable
    //   1462	1471	1706	java/lang/Throwable
    //   1482	1490	1706	java/lang/Throwable
    //   1501	1509	1706	java/lang/Throwable
    //   1520	1535	1706	java/lang/Throwable
    //   1396	1428	1733	java/lang/Throwable
  }
  
  private static long skip(InputStream paramInputStream, long paramLong)
  {
    long l1 = paramLong;
    for (;;)
    {
      if (l1 > 0L)
      {
        long l2 = paramInputStream.skip(l1);
        if (l2 > 0L)
        {
          l1 -= l2;
          continue;
        }
        if (l2 != 0L) {
          break;
        }
        if (paramInputStream.read() != -1) {}
      }
      else
      {
        return paramLong - l1;
      }
      l1 -= 1L;
    }
    throw new IOException("skip() return a negative value.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.JpegExifReader
 * JD-Core Version:    0.7.0.1
 */