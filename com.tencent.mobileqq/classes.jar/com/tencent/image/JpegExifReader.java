package com.tencent.image;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

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
  public static JpegExifReaderInterface jpegExifReaderInterface;
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
    throws Exception
  {
    if (paramBoolean) {
      return paramArrayOfByte[0] << 24 & 0xFF000000 | paramArrayOfByte[1] << 16 & 0xFF0000 | paramArrayOfByte[2] << 8 & 0xFF00 | paramArrayOfByte[3] & 0xFF;
    }
    return paramArrayOfByte[3] << 24 & 0xFF000000 | paramArrayOfByte[2] << 16 & 0xFF0000 | paramArrayOfByte[1] << 8 & 0xFF00 | paramArrayOfByte[0] & 0xFF;
  }
  
  private static long getValue(int paramInt, boolean paramBoolean, byte[] paramArrayOfByte)
    throws Exception
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
  
  public static void initJpegExifReader(JpegExifReaderInterface paramJpegExifReaderInterface)
  {
    jpegExifReaderInterface = paramJpegExifReaderInterface;
  }
  
  /* Error */
  public static boolean isCrashJpeg(String paramString)
  {
    // Byte code:
    //   0: getstatic 145	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 24
    //   5: if_icmplt +9 -> 14
    //   8: iconst_0
    //   9: istore 8
    //   11: iload 8
    //   13: ireturn
    //   14: invokestatic 151	android/os/SystemClock:uptimeMillis	()J
    //   17: lstore 10
    //   19: iconst_0
    //   20: istore 8
    //   22: iconst_0
    //   23: istore 9
    //   25: aconst_null
    //   26: astore 14
    //   28: aconst_null
    //   29: astore 17
    //   31: iconst_0
    //   32: istore_1
    //   33: iconst_0
    //   34: istore_2
    //   35: ldc 153
    //   37: astore 16
    //   39: new 155	java/io/BufferedInputStream
    //   42: dup
    //   43: new 157	java/io/FileInputStream
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 160	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   51: sipush 1024
    //   54: invokespecial 163	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   57: astore 15
    //   59: iconst_0
    //   60: istore_3
    //   61: iload_2
    //   62: istore_1
    //   63: iconst_2
    //   64: newarray byte
    //   66: astore 17
    //   68: iload_2
    //   69: istore_1
    //   70: aload 15
    //   72: aload 17
    //   74: iconst_0
    //   75: iconst_2
    //   76: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   79: iconst_2
    //   80: if_icmpne +33 -> 113
    //   83: aload 17
    //   85: iconst_0
    //   86: baload
    //   87: sipush 255
    //   90: iand
    //   91: sipush 255
    //   94: if_icmpne +190 -> 284
    //   97: aload 17
    //   99: iconst_1
    //   100: baload
    //   101: sipush 255
    //   104: iand
    //   105: sipush 216
    //   108: if_icmpne +176 -> 284
    //   111: iconst_1
    //   112: istore_3
    //   113: iconst_0
    //   114: iconst_2
    //   115: iadd
    //   116: istore 4
    //   118: aload 16
    //   120: astore 14
    //   122: iload 9
    //   124: istore 7
    //   126: iload 4
    //   128: istore_2
    //   129: iload_3
    //   130: ifeq +59 -> 189
    //   133: iload 4
    //   135: istore_1
    //   136: iconst_4
    //   137: newarray byte
    //   139: astore 14
    //   141: iload 4
    //   143: istore_1
    //   144: aload 15
    //   146: invokevirtual 170	java/io/BufferedInputStream:read	()I
    //   149: sipush 255
    //   152: iand
    //   153: i2b
    //   154: istore_3
    //   155: iload 4
    //   157: iconst_1
    //   158: iadd
    //   159: istore_2
    //   160: iload_2
    //   161: istore_1
    //   162: aload 15
    //   164: invokevirtual 170	java/io/BufferedInputStream:read	()I
    //   167: sipush 255
    //   170: iand
    //   171: i2b
    //   172: istore 4
    //   174: iload 4
    //   176: bipush 218
    //   178: if_icmpne +111 -> 289
    //   181: ldc 172
    //   183: astore 14
    //   185: iload 9
    //   187: istore 7
    //   189: aload 15
    //   191: ifnull +1407 -> 1598
    //   194: aload 15
    //   196: invokevirtual 175	java/io/BufferedInputStream:close	()V
    //   199: invokestatic 151	android/os/SystemClock:uptimeMillis	()J
    //   202: lstore 12
    //   204: iload 7
    //   206: istore 8
    //   208: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq -200 -> 11
    //   214: ldc 44
    //   216: iconst_2
    //   217: new 104	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   224: ldc 177
    //   226: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: iload 7
    //   231: invokevirtual 180	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   234: ldc 182
    //   236: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: iload_2
    //   240: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   243: ldc 184
    //   245: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: lload 12
    //   250: lload 10
    //   252: lsub
    //   253: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   256: ldc 189
    //   258: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_0
    //   262: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc 191
    //   267: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload 14
    //   272: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: iload 7
    //   283: ireturn
    //   284: iconst_0
    //   285: istore_3
    //   286: goto -173 -> 113
    //   289: iload_2
    //   290: iconst_1
    //   291: iadd
    //   292: istore_2
    //   293: iload_2
    //   294: istore_1
    //   295: aload 15
    //   297: aload 17
    //   299: iconst_0
    //   300: iconst_2
    //   301: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   304: iconst_2
    //   305: if_icmpeq +14 -> 319
    //   308: ldc 196
    //   310: astore 14
    //   312: iload 9
    //   314: istore 7
    //   316: goto -127 -> 189
    //   319: iload_2
    //   320: iconst_2
    //   321: iadd
    //   322: istore_2
    //   323: aload 17
    //   325: iconst_0
    //   326: baload
    //   327: bipush 8
    //   329: ishl
    //   330: ldc 71
    //   332: iand
    //   333: aload 17
    //   335: iconst_1
    //   336: baload
    //   337: sipush 255
    //   340: iand
    //   341: ior
    //   342: iconst_2
    //   343: isub
    //   344: istore 5
    //   346: iload_3
    //   347: iconst_m1
    //   348: if_icmpne +1265 -> 1613
    //   351: iload 4
    //   353: bipush 224
    //   355: if_icmpne +1258 -> 1613
    //   358: iload_2
    //   359: istore_1
    //   360: aload 15
    //   362: iload 5
    //   364: i2l
    //   365: invokestatic 200	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   368: iload 5
    //   370: i2l
    //   371: lcmp
    //   372: ifne +1229 -> 1601
    //   375: iload_2
    //   376: iload 5
    //   378: iadd
    //   379: istore 4
    //   381: goto -240 -> 141
    //   384: iload_2
    //   385: istore_1
    //   386: aload 15
    //   388: aload 14
    //   390: iconst_0
    //   391: iconst_4
    //   392: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   395: iconst_4
    //   396: if_icmpeq +14 -> 410
    //   399: ldc 202
    //   401: astore 14
    //   403: iload 9
    //   405: istore 7
    //   407: goto -218 -> 189
    //   410: iload_2
    //   411: iconst_4
    //   412: iadd
    //   413: istore_2
    //   414: iload_2
    //   415: istore_1
    //   416: ldc 25
    //   418: new 204	java/lang/String
    //   421: dup
    //   422: aload 14
    //   424: invokespecial 207	java/lang/String:<init>	([B)V
    //   427: invokevirtual 210	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   430: ifne +14 -> 444
    //   433: ldc 212
    //   435: astore 14
    //   437: iload 9
    //   439: istore 7
    //   441: goto -252 -> 189
    //   444: iload_2
    //   445: istore_1
    //   446: aload 15
    //   448: ldc2_w 213
    //   451: invokevirtual 217	java/io/BufferedInputStream:skip	(J)J
    //   454: ldc2_w 213
    //   457: lcmp
    //   458: ifeq +14 -> 472
    //   461: ldc 219
    //   463: astore 14
    //   465: iload 9
    //   467: istore 7
    //   469: goto -280 -> 189
    //   472: iload_2
    //   473: iconst_2
    //   474: iadd
    //   475: istore_2
    //   476: iload_2
    //   477: istore_1
    //   478: aload 15
    //   480: aload 17
    //   482: iconst_0
    //   483: iconst_2
    //   484: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   487: iconst_2
    //   488: if_icmpeq +14 -> 502
    //   491: ldc 221
    //   493: astore 14
    //   495: iload 9
    //   497: istore 7
    //   499: goto -310 -> 189
    //   502: iload_2
    //   503: iconst_2
    //   504: iadd
    //   505: istore_3
    //   506: iload_3
    //   507: istore_1
    //   508: new 204	java/lang/String
    //   511: dup
    //   512: aload 17
    //   514: invokespecial 207	java/lang/String:<init>	([B)V
    //   517: astore 18
    //   519: iload_3
    //   520: istore_1
    //   521: ldc 11
    //   523: aload 18
    //   525: invokevirtual 210	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   528: ifeq +36 -> 564
    //   531: iconst_1
    //   532: istore 7
    //   534: iload_3
    //   535: istore_1
    //   536: aload 15
    //   538: ldc2_w 213
    //   541: invokestatic 200	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   544: ldc2_w 213
    //   547: lcmp
    //   548: ifeq +72 -> 620
    //   551: ldc 223
    //   553: astore 14
    //   555: iload 9
    //   557: istore 7
    //   559: iload_3
    //   560: istore_2
    //   561: goto -372 -> 189
    //   564: iload_3
    //   565: istore_1
    //   566: ldc 32
    //   568: aload 18
    //   570: invokevirtual 210	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   573: ifeq +9 -> 582
    //   576: iconst_0
    //   577: istore 7
    //   579: goto -45 -> 534
    //   582: iload_3
    //   583: istore_1
    //   584: new 104	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   591: ldc 225
    //   593: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload 18
    //   598: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: ldc 227
    //   603: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: astore 14
    //   611: iload 9
    //   613: istore 7
    //   615: iload_3
    //   616: istore_2
    //   617: goto -428 -> 189
    //   620: iload_3
    //   621: istore_1
    //   622: aload 15
    //   624: aload 14
    //   626: iconst_0
    //   627: iconst_4
    //   628: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   631: iconst_4
    //   632: if_icmpeq +16 -> 648
    //   635: ldc 229
    //   637: astore 14
    //   639: iload 9
    //   641: istore 7
    //   643: iload_3
    //   644: istore_2
    //   645: goto -456 -> 189
    //   648: iload_3
    //   649: bipush 6
    //   651: iadd
    //   652: istore_3
    //   653: iload_3
    //   654: istore_1
    //   655: iload 7
    //   657: aload 14
    //   659: invokestatic 130	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   662: bipush 8
    //   664: isub
    //   665: istore 4
    //   667: iload 4
    //   669: ifle +33 -> 702
    //   672: iload_3
    //   673: istore_1
    //   674: aload 15
    //   676: iload 4
    //   678: i2l
    //   679: invokestatic 200	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   682: iload 4
    //   684: i2l
    //   685: lcmp
    //   686: ifeq +16 -> 702
    //   689: ldc 231
    //   691: astore 14
    //   693: iload 9
    //   695: istore 7
    //   697: iload_3
    //   698: istore_2
    //   699: goto -510 -> 189
    //   702: iload_3
    //   703: istore_1
    //   704: aload 15
    //   706: aload 17
    //   708: iconst_0
    //   709: iconst_2
    //   710: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   713: iconst_2
    //   714: if_icmpeq +16 -> 730
    //   717: ldc 233
    //   719: astore 14
    //   721: iload 9
    //   723: istore 7
    //   725: iload_3
    //   726: istore_2
    //   727: goto -538 -> 189
    //   730: iload_3
    //   731: iload 4
    //   733: iconst_2
    //   734: iadd
    //   735: iadd
    //   736: istore_3
    //   737: iload_3
    //   738: istore_1
    //   739: iload 7
    //   741: aload 17
    //   743: invokestatic 124	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   746: istore 5
    //   748: iconst_0
    //   749: istore 4
    //   751: iload 4
    //   753: iload 5
    //   755: if_icmpge +725 -> 1480
    //   758: iload_3
    //   759: istore_1
    //   760: aload 15
    //   762: aload 17
    //   764: iconst_0
    //   765: iconst_2
    //   766: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   769: iconst_2
    //   770: if_icmpeq +16 -> 786
    //   773: ldc 235
    //   775: astore 14
    //   777: iload 9
    //   779: istore 7
    //   781: iload_3
    //   782: istore_2
    //   783: goto -594 -> 189
    //   786: iload_3
    //   787: iconst_2
    //   788: iadd
    //   789: istore_3
    //   790: iload_3
    //   791: istore_1
    //   792: iload 7
    //   794: aload 17
    //   796: invokestatic 124	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   799: ldc 41
    //   801: if_icmpne +648 -> 1449
    //   804: iload_3
    //   805: istore_1
    //   806: aload 15
    //   808: aload 17
    //   810: iconst_0
    //   811: iconst_2
    //   812: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   815: iconst_2
    //   816: if_icmpeq +16 -> 832
    //   819: ldc 237
    //   821: astore 14
    //   823: iload 9
    //   825: istore 7
    //   827: iload_3
    //   828: istore_2
    //   829: goto -640 -> 189
    //   832: iload_3
    //   833: iconst_2
    //   834: iadd
    //   835: istore_3
    //   836: iload_3
    //   837: istore_1
    //   838: iload 7
    //   840: aload 17
    //   842: invokestatic 124	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   845: istore 4
    //   847: iload_3
    //   848: istore_1
    //   849: aload 15
    //   851: aload 14
    //   853: iconst_0
    //   854: iconst_4
    //   855: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   858: iconst_4
    //   859: if_icmpeq +16 -> 875
    //   862: ldc 239
    //   864: astore 14
    //   866: iload 9
    //   868: istore 7
    //   870: iload_3
    //   871: istore_2
    //   872: goto -683 -> 189
    //   875: iload_3
    //   876: iconst_4
    //   877: iadd
    //   878: istore_3
    //   879: iload_3
    //   880: istore_1
    //   881: iload 7
    //   883: aload 14
    //   885: invokestatic 130	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   888: pop
    //   889: iload_3
    //   890: istore_1
    //   891: getstatic 64	com/tencent/image/JpegExifReader:BYTES_PER_FORMAT	[B
    //   894: iload 4
    //   896: baload
    //   897: istore 5
    //   899: iload_3
    //   900: istore_1
    //   901: aload 15
    //   903: aload 14
    //   905: iconst_0
    //   906: iconst_4
    //   907: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   910: iconst_4
    //   911: if_icmpeq +16 -> 927
    //   914: ldc 241
    //   916: astore 14
    //   918: iload 9
    //   920: istore 7
    //   922: iload_3
    //   923: istore_2
    //   924: goto -735 -> 189
    //   927: iload_3
    //   928: iconst_4
    //   929: iadd
    //   930: istore_3
    //   931: iload_3
    //   932: istore_1
    //   933: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   936: ifeq +31 -> 967
    //   939: iload_3
    //   940: istore_1
    //   941: ldc 44
    //   943: iconst_2
    //   944: new 104	java/lang/StringBuilder
    //   947: dup
    //   948: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   951: ldc 243
    //   953: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: iload 4
    //   958: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   961: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   964: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   967: iload_3
    //   968: istore_1
    //   969: iload 4
    //   971: iload 7
    //   973: aload 14
    //   975: invokestatic 245	com/tencent/image/JpegExifReader:getValue	(IZ[B)J
    //   978: lstore 12
    //   980: iload_2
    //   981: i2l
    //   982: lload 12
    //   984: ladd
    //   985: iload_3
    //   986: i2l
    //   987: lsub
    //   988: lstore 12
    //   990: iload_3
    //   991: istore_1
    //   992: aload 15
    //   994: lload 12
    //   996: invokestatic 200	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   999: lload 12
    //   1001: lcmp
    //   1002: ifeq +16 -> 1018
    //   1005: ldc 247
    //   1007: astore 14
    //   1009: iload 9
    //   1011: istore 7
    //   1013: iload_3
    //   1014: istore_2
    //   1015: goto -826 -> 189
    //   1018: iload_3
    //   1019: istore_1
    //   1020: aload 15
    //   1022: aload 17
    //   1024: iconst_0
    //   1025: iconst_2
    //   1026: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   1029: iconst_2
    //   1030: if_icmpeq +16 -> 1046
    //   1033: ldc 249
    //   1035: astore 14
    //   1037: iload 9
    //   1039: istore 7
    //   1041: iload_3
    //   1042: istore_2
    //   1043: goto -854 -> 189
    //   1046: iload_3
    //   1047: iconst_2
    //   1048: iadd
    //   1049: istore_3
    //   1050: iload_3
    //   1051: istore_1
    //   1052: iload 7
    //   1054: aload 17
    //   1056: invokestatic 124	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1059: istore 5
    //   1061: iconst_0
    //   1062: istore 4
    //   1064: iload 4
    //   1066: iload 5
    //   1068: if_icmpge +239 -> 1307
    //   1071: iload_3
    //   1072: istore_1
    //   1073: aload 15
    //   1075: aload 17
    //   1077: iconst_0
    //   1078: iconst_2
    //   1079: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   1082: iconst_2
    //   1083: if_icmpeq +16 -> 1099
    //   1086: ldc 251
    //   1088: astore 14
    //   1090: iload 9
    //   1092: istore 7
    //   1094: iload_3
    //   1095: istore_2
    //   1096: goto -907 -> 189
    //   1099: iload_3
    //   1100: iconst_2
    //   1101: iadd
    //   1102: istore_2
    //   1103: iload_2
    //   1104: istore_1
    //   1105: iload 7
    //   1107: aload 17
    //   1109: invokestatic 124	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1112: ldc 27
    //   1114: if_icmpne +164 -> 1278
    //   1117: iload_2
    //   1118: istore_1
    //   1119: aload 15
    //   1121: aload 17
    //   1123: iconst_0
    //   1124: iconst_2
    //   1125: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   1128: iconst_2
    //   1129: if_icmpeq +14 -> 1143
    //   1132: ldc 253
    //   1134: astore 14
    //   1136: iload 9
    //   1138: istore 7
    //   1140: goto -951 -> 189
    //   1143: iload_2
    //   1144: iconst_2
    //   1145: iadd
    //   1146: istore_2
    //   1147: iload_2
    //   1148: istore_1
    //   1149: iload 7
    //   1151: aload 17
    //   1153: invokestatic 124	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1156: istore 6
    //   1158: iload_2
    //   1159: istore_1
    //   1160: aload 15
    //   1162: aload 14
    //   1164: iconst_0
    //   1165: iconst_4
    //   1166: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   1169: iconst_4
    //   1170: if_icmpeq +14 -> 1184
    //   1173: ldc 255
    //   1175: astore 14
    //   1177: iload 9
    //   1179: istore 7
    //   1181: goto -992 -> 189
    //   1184: iload_2
    //   1185: iconst_4
    //   1186: iadd
    //   1187: istore_2
    //   1188: iload_2
    //   1189: istore_1
    //   1190: iload 7
    //   1192: aload 14
    //   1194: invokestatic 130	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   1197: pop
    //   1198: iload_2
    //   1199: istore_1
    //   1200: getstatic 64	com/tencent/image/JpegExifReader:BYTES_PER_FORMAT	[B
    //   1203: iload 6
    //   1205: baload
    //   1206: istore_3
    //   1207: iload_2
    //   1208: istore_1
    //   1209: aload 15
    //   1211: aload 14
    //   1213: iconst_0
    //   1214: iconst_4
    //   1215: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   1218: iconst_4
    //   1219: if_icmpeq +15 -> 1234
    //   1222: ldc_w 257
    //   1225: astore 14
    //   1227: iload 9
    //   1229: istore 7
    //   1231: goto -1042 -> 189
    //   1234: iload_2
    //   1235: iconst_4
    //   1236: iadd
    //   1237: istore_2
    //   1238: iload_2
    //   1239: istore_1
    //   1240: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1243: ifeq +394 -> 1637
    //   1246: iload_2
    //   1247: istore_1
    //   1248: ldc 44
    //   1250: iconst_2
    //   1251: new 104	java/lang/StringBuilder
    //   1254: dup
    //   1255: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1258: ldc_w 259
    //   1261: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: iload 6
    //   1266: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1269: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1272: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1275: goto +362 -> 1637
    //   1278: iload_2
    //   1279: istore_1
    //   1280: aload 15
    //   1282: ldc2_w 260
    //   1285: invokestatic 200	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1288: ldc2_w 260
    //   1291: lcmp
    //   1292: ifeq +364 -> 1656
    //   1295: ldc_w 263
    //   1298: astore 14
    //   1300: iload 9
    //   1302: istore 7
    //   1304: goto -1115 -> 189
    //   1307: aload 16
    //   1309: astore 14
    //   1311: iload 9
    //   1313: istore 7
    //   1315: iload_3
    //   1316: istore_2
    //   1317: iload_3
    //   1318: istore_1
    //   1319: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1322: ifeq -1133 -> 189
    //   1325: iload_3
    //   1326: istore_1
    //   1327: ldc 44
    //   1329: iconst_2
    //   1330: ldc_w 265
    //   1333: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1336: aload 16
    //   1338: astore 14
    //   1340: iload 9
    //   1342: istore 7
    //   1344: iload_3
    //   1345: istore_2
    //   1346: goto -1157 -> 189
    //   1349: astore 17
    //   1351: aload 15
    //   1353: astore 14
    //   1355: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1358: ifeq +17 -> 1375
    //   1361: aload 15
    //   1363: astore 14
    //   1365: ldc 44
    //   1367: iconst_2
    //   1368: ldc 153
    //   1370: aload 17
    //   1372: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1375: aload 16
    //   1377: astore 14
    //   1379: iload 8
    //   1381: istore 7
    //   1383: iload_1
    //   1384: istore_2
    //   1385: aload 15
    //   1387: ifnull -1188 -> 199
    //   1390: aload 15
    //   1392: invokevirtual 175	java/io/BufferedInputStream:close	()V
    //   1395: aload 16
    //   1397: astore 14
    //   1399: iload 8
    //   1401: istore 7
    //   1403: iload_1
    //   1404: istore_2
    //   1405: goto -1206 -> 199
    //   1408: astore 15
    //   1410: aload 16
    //   1412: astore 14
    //   1414: iload 8
    //   1416: istore 7
    //   1418: iload_1
    //   1419: istore_2
    //   1420: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1423: ifeq -1224 -> 199
    //   1426: ldc 44
    //   1428: iconst_2
    //   1429: ldc 153
    //   1431: aload 15
    //   1433: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1436: aload 16
    //   1438: astore 14
    //   1440: iload 8
    //   1442: istore 7
    //   1444: iload_1
    //   1445: istore_2
    //   1446: goto -1247 -> 199
    //   1449: iload_3
    //   1450: istore_1
    //   1451: aload 15
    //   1453: ldc2_w 260
    //   1456: invokestatic 200	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1459: ldc2_w 260
    //   1462: lcmp
    //   1463: ifeq +207 -> 1670
    //   1466: ldc_w 263
    //   1469: astore 14
    //   1471: iload 9
    //   1473: istore 7
    //   1475: iload_3
    //   1476: istore_2
    //   1477: goto -1288 -> 189
    //   1480: aload 16
    //   1482: astore 14
    //   1484: iload 9
    //   1486: istore 7
    //   1488: iload_3
    //   1489: istore_2
    //   1490: iload_3
    //   1491: istore_1
    //   1492: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1495: ifeq -1306 -> 189
    //   1498: iload_3
    //   1499: istore_1
    //   1500: ldc 44
    //   1502: iconst_2
    //   1503: ldc_w 270
    //   1506: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1509: aload 16
    //   1511: astore 14
    //   1513: iload 9
    //   1515: istore 7
    //   1517: iload_3
    //   1518: istore_2
    //   1519: goto -1330 -> 189
    //   1522: astore_0
    //   1523: aload 15
    //   1525: astore 14
    //   1527: aload 14
    //   1529: ifnull +8 -> 1537
    //   1532: aload 14
    //   1534: invokevirtual 175	java/io/BufferedInputStream:close	()V
    //   1537: aload_0
    //   1538: athrow
    //   1539: astore 15
    //   1541: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1544: ifeq +13 -> 1557
    //   1547: ldc 44
    //   1549: iconst_2
    //   1550: ldc 153
    //   1552: aload 15
    //   1554: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1557: goto -1358 -> 199
    //   1560: astore 14
    //   1562: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1565: ifeq -28 -> 1537
    //   1568: ldc 44
    //   1570: iconst_2
    //   1571: ldc 153
    //   1573: aload 14
    //   1575: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1578: goto -41 -> 1537
    //   1581: astore_0
    //   1582: goto -55 -> 1527
    //   1585: astore 14
    //   1587: aload 17
    //   1589: astore 15
    //   1591: aload 14
    //   1593: astore 17
    //   1595: goto -244 -> 1351
    //   1598: goto -1399 -> 199
    //   1601: ldc_w 272
    //   1604: astore 14
    //   1606: iload 9
    //   1608: istore 7
    //   1610: goto -1421 -> 189
    //   1613: iload_3
    //   1614: iconst_m1
    //   1615: if_icmpne +10 -> 1625
    //   1618: iload 4
    //   1620: bipush 225
    //   1622: if_icmpeq -1238 -> 384
    //   1625: ldc_w 274
    //   1628: astore 14
    //   1630: iload 9
    //   1632: istore 7
    //   1634: goto -1445 -> 189
    //   1637: iload_2
    //   1638: istore_3
    //   1639: iload 6
    //   1641: bipush 12
    //   1643: if_icmpne +18 -> 1661
    //   1646: iconst_1
    //   1647: istore 7
    //   1649: aload 16
    //   1651: astore 14
    //   1653: goto -1464 -> 189
    //   1656: iload_2
    //   1657: bipush 10
    //   1659: iadd
    //   1660: istore_3
    //   1661: iload 4
    //   1663: iconst_1
    //   1664: iadd
    //   1665: istore 4
    //   1667: goto -603 -> 1064
    //   1670: iload_3
    //   1671: bipush 10
    //   1673: iadd
    //   1674: istore_3
    //   1675: iload 4
    //   1677: iconst_1
    //   1678: iadd
    //   1679: istore 4
    //   1681: goto -930 -> 751
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1684	0	paramString	String
    //   32	1468	1	i	int
    //   34	1626	2	j	int
    //   60	1615	3	k	int
    //   116	1564	4	m	int
    //   344	725	5	n	int
    //   1156	488	6	i1	int
    //   124	1524	7	bool1	boolean
    //   9	1432	8	bool2	boolean
    //   23	1608	9	bool3	boolean
    //   17	234	10	l1	long
    //   202	798	12	l2	long
    //   26	1507	14	localObject1	Object
    //   1560	14	14	localIOException1	IOException
    //   1585	7	14	localThrowable1	java.lang.Throwable
    //   1604	48	14	localObject2	Object
    //   57	1334	15	localBufferedInputStream	java.io.BufferedInputStream
    //   1408	116	15	localIOException2	IOException
    //   1539	14	15	localIOException3	IOException
    //   1589	1	15	localThrowable2	java.lang.Throwable
    //   37	1613	16	str1	String
    //   29	1123	17	arrayOfByte	byte[]
    //   1349	239	17	localThrowable3	java.lang.Throwable
    //   1593	1	17	localThrowable4	java.lang.Throwable
    //   517	80	18	str2	String
    // Exception table:
    //   from	to	target	type
    //   63	68	1349	java/lang/Throwable
    //   70	83	1349	java/lang/Throwable
    //   136	141	1349	java/lang/Throwable
    //   144	155	1349	java/lang/Throwable
    //   162	174	1349	java/lang/Throwable
    //   295	308	1349	java/lang/Throwable
    //   360	375	1349	java/lang/Throwable
    //   386	399	1349	java/lang/Throwable
    //   416	433	1349	java/lang/Throwable
    //   446	461	1349	java/lang/Throwable
    //   478	491	1349	java/lang/Throwable
    //   508	519	1349	java/lang/Throwable
    //   521	531	1349	java/lang/Throwable
    //   536	551	1349	java/lang/Throwable
    //   566	576	1349	java/lang/Throwable
    //   584	611	1349	java/lang/Throwable
    //   622	635	1349	java/lang/Throwable
    //   655	667	1349	java/lang/Throwable
    //   674	689	1349	java/lang/Throwable
    //   704	717	1349	java/lang/Throwable
    //   739	748	1349	java/lang/Throwable
    //   760	773	1349	java/lang/Throwable
    //   792	804	1349	java/lang/Throwable
    //   806	819	1349	java/lang/Throwable
    //   838	847	1349	java/lang/Throwable
    //   849	862	1349	java/lang/Throwable
    //   881	889	1349	java/lang/Throwable
    //   891	899	1349	java/lang/Throwable
    //   901	914	1349	java/lang/Throwable
    //   933	939	1349	java/lang/Throwable
    //   941	967	1349	java/lang/Throwable
    //   969	980	1349	java/lang/Throwable
    //   992	1005	1349	java/lang/Throwable
    //   1020	1033	1349	java/lang/Throwable
    //   1052	1061	1349	java/lang/Throwable
    //   1073	1086	1349	java/lang/Throwable
    //   1105	1117	1349	java/lang/Throwable
    //   1119	1132	1349	java/lang/Throwable
    //   1149	1158	1349	java/lang/Throwable
    //   1160	1173	1349	java/lang/Throwable
    //   1190	1198	1349	java/lang/Throwable
    //   1200	1207	1349	java/lang/Throwable
    //   1209	1222	1349	java/lang/Throwable
    //   1240	1246	1349	java/lang/Throwable
    //   1248	1275	1349	java/lang/Throwable
    //   1280	1295	1349	java/lang/Throwable
    //   1319	1325	1349	java/lang/Throwable
    //   1327	1336	1349	java/lang/Throwable
    //   1451	1466	1349	java/lang/Throwable
    //   1492	1498	1349	java/lang/Throwable
    //   1500	1509	1349	java/lang/Throwable
    //   1390	1395	1408	java/io/IOException
    //   63	68	1522	finally
    //   70	83	1522	finally
    //   136	141	1522	finally
    //   144	155	1522	finally
    //   162	174	1522	finally
    //   295	308	1522	finally
    //   360	375	1522	finally
    //   386	399	1522	finally
    //   416	433	1522	finally
    //   446	461	1522	finally
    //   478	491	1522	finally
    //   508	519	1522	finally
    //   521	531	1522	finally
    //   536	551	1522	finally
    //   566	576	1522	finally
    //   584	611	1522	finally
    //   622	635	1522	finally
    //   655	667	1522	finally
    //   674	689	1522	finally
    //   704	717	1522	finally
    //   739	748	1522	finally
    //   760	773	1522	finally
    //   792	804	1522	finally
    //   806	819	1522	finally
    //   838	847	1522	finally
    //   849	862	1522	finally
    //   881	889	1522	finally
    //   891	899	1522	finally
    //   901	914	1522	finally
    //   933	939	1522	finally
    //   941	967	1522	finally
    //   969	980	1522	finally
    //   992	1005	1522	finally
    //   1020	1033	1522	finally
    //   1052	1061	1522	finally
    //   1073	1086	1522	finally
    //   1105	1117	1522	finally
    //   1119	1132	1522	finally
    //   1149	1158	1522	finally
    //   1160	1173	1522	finally
    //   1190	1198	1522	finally
    //   1200	1207	1522	finally
    //   1209	1222	1522	finally
    //   1240	1246	1522	finally
    //   1248	1275	1522	finally
    //   1280	1295	1522	finally
    //   1319	1325	1522	finally
    //   1327	1336	1522	finally
    //   1451	1466	1522	finally
    //   1492	1498	1522	finally
    //   1500	1509	1522	finally
    //   194	199	1539	java/io/IOException
    //   1532	1537	1560	java/io/IOException
    //   39	59	1581	finally
    //   1355	1361	1581	finally
    //   1365	1375	1581	finally
    //   39	59	1585	java/lang/Throwable
  }
  
  /* Error */
  public static int readOrientation(String paramString)
  {
    // Byte code:
    //   0: invokestatic 151	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 10
    //   5: iconst_1
    //   6: istore 7
    //   8: iconst_1
    //   9: istore 4
    //   11: iconst_1
    //   12: istore 8
    //   14: iconst_1
    //   15: istore 9
    //   17: getstatic 57	com/tencent/image/JpegExifReader:sIsReadDpc	Z
    //   20: ifne +24 -> 44
    //   23: getstatic 134	com/tencent/image/JpegExifReader:jpegExifReaderInterface	Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;
    //   26: ifnull +18 -> 44
    //   29: getstatic 134	com/tencent/image/JpegExifReader:jpegExifReaderInterface	Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;
    //   32: invokeinterface 277 1 0
    //   37: putstatic 55	com/tencent/image/JpegExifReader:sIsEnable	Z
    //   40: iconst_1
    //   41: putstatic 57	com/tencent/image/JpegExifReader:sIsReadDpc	Z
    //   44: getstatic 55	com/tencent/image/JpegExifReader:sIsEnable	Z
    //   47: ifne +58 -> 105
    //   50: aconst_null
    //   51: astore 13
    //   53: new 279	android/media/ExifInterface
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 280	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   61: astore_0
    //   62: aload_0
    //   63: ifnonnull +33 -> 96
    //   66: iconst_0
    //   67: ireturn
    //   68: astore 14
    //   70: aload 13
    //   72: astore_0
    //   73: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq -14 -> 62
    //   79: ldc 44
    //   81: iconst_2
    //   82: ldc_w 282
    //   85: aload 14
    //   87: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   90: aload 13
    //   92: astore_0
    //   93: goto -31 -> 62
    //   96: aload_0
    //   97: ldc_w 284
    //   100: iconst_1
    //   101: invokevirtual 288	android/media/ExifInterface:getAttributeInt	(Ljava/lang/String;I)I
    //   104: ireturn
    //   105: aconst_null
    //   106: astore 13
    //   108: aconst_null
    //   109: astore 14
    //   111: iconst_0
    //   112: istore_1
    //   113: iconst_0
    //   114: istore_2
    //   115: ldc 153
    //   117: astore 15
    //   119: new 155	java/io/BufferedInputStream
    //   122: dup
    //   123: new 157	java/io/FileInputStream
    //   126: dup
    //   127: aload_0
    //   128: invokespecial 160	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   131: sipush 512
    //   134: invokespecial 163	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   137: astore 16
    //   139: iconst_0
    //   140: istore_3
    //   141: aload 15
    //   143: astore 14
    //   145: iload_2
    //   146: istore_1
    //   147: iload 7
    //   149: istore 4
    //   151: iconst_2
    //   152: newarray byte
    //   154: astore 17
    //   156: aload 15
    //   158: astore 14
    //   160: iload_2
    //   161: istore_1
    //   162: iload 7
    //   164: istore 4
    //   166: aload 16
    //   168: aload 17
    //   170: iconst_0
    //   171: iconst_2
    //   172: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   175: iconst_2
    //   176: if_icmpne +33 -> 209
    //   179: aload 17
    //   181: iconst_0
    //   182: baload
    //   183: sipush 255
    //   186: iand
    //   187: sipush 255
    //   190: if_icmpne +241 -> 431
    //   193: aload 17
    //   195: iconst_1
    //   196: baload
    //   197: sipush 255
    //   200: iand
    //   201: sipush 216
    //   204: if_icmpne +227 -> 431
    //   207: iconst_1
    //   208: istore_3
    //   209: iconst_0
    //   210: iconst_2
    //   211: iadd
    //   212: istore 6
    //   214: aload 15
    //   216: astore 13
    //   218: iload 6
    //   220: istore_2
    //   221: iload 9
    //   223: istore 5
    //   225: iload_3
    //   226: ifeq +88 -> 314
    //   229: aload 15
    //   231: astore 14
    //   233: iload 6
    //   235: istore_1
    //   236: iload 7
    //   238: istore 4
    //   240: iconst_4
    //   241: newarray byte
    //   243: astore 18
    //   245: iload 6
    //   247: istore_2
    //   248: aload 15
    //   250: astore 13
    //   252: aload 13
    //   254: astore 14
    //   256: iload_2
    //   257: istore_1
    //   258: iload 7
    //   260: istore 4
    //   262: aload 16
    //   264: invokevirtual 170	java/io/BufferedInputStream:read	()I
    //   267: sipush 255
    //   270: iand
    //   271: i2b
    //   272: istore_3
    //   273: iload_2
    //   274: iconst_1
    //   275: iadd
    //   276: istore_2
    //   277: aload 13
    //   279: astore 14
    //   281: iload_2
    //   282: istore_1
    //   283: iload 7
    //   285: istore 4
    //   287: aload 16
    //   289: invokevirtual 170	java/io/BufferedInputStream:read	()I
    //   292: sipush 255
    //   295: iand
    //   296: i2b
    //   297: istore 5
    //   299: iload 5
    //   301: bipush 218
    //   303: if_icmpne +133 -> 436
    //   306: ldc 172
    //   308: astore 13
    //   310: iload 9
    //   312: istore 5
    //   314: aload 16
    //   316: ifnull +1665 -> 1981
    //   319: aload 16
    //   321: invokevirtual 175	java/io/BufferedInputStream:close	()V
    //   324: invokestatic 151	android/os/SystemClock:uptimeMillis	()J
    //   327: lload 10
    //   329: lsub
    //   330: lstore 10
    //   332: getstatic 134	com/tencent/image/JpegExifReader:jpegExifReaderInterface	Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;
    //   335: ifnull +21 -> 356
    //   338: getstatic 134	com/tencent/image/JpegExifReader:jpegExifReaderInterface	Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;
    //   341: aconst_null
    //   342: ldc 37
    //   344: iconst_1
    //   345: lload 10
    //   347: iload_2
    //   348: i2l
    //   349: aconst_null
    //   350: aconst_null
    //   351: invokeinterface 292 10 0
    //   356: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq +69 -> 428
    //   362: ldc 44
    //   364: iconst_2
    //   365: new 104	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   372: ldc_w 294
    //   375: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: iload 5
    //   380: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   383: ldc 182
    //   385: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: iload_2
    //   389: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   392: ldc 184
    //   394: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: lload 10
    //   399: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   402: ldc 189
    //   404: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload_0
    //   408: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: ldc_w 296
    //   414: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload 13
    //   419: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   428: iload 5
    //   430: ireturn
    //   431: iconst_0
    //   432: istore_3
    //   433: goto -224 -> 209
    //   436: iload_2
    //   437: iconst_1
    //   438: iadd
    //   439: istore_2
    //   440: aload 13
    //   442: astore 14
    //   444: iload_2
    //   445: istore_1
    //   446: iload 7
    //   448: istore 4
    //   450: aload 16
    //   452: aload 17
    //   454: iconst_0
    //   455: iconst_2
    //   456: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   459: iconst_2
    //   460: if_icmpeq +14 -> 474
    //   463: ldc 196
    //   465: astore 13
    //   467: iload 9
    //   469: istore 5
    //   471: goto -157 -> 314
    //   474: iload_2
    //   475: iconst_2
    //   476: iadd
    //   477: istore_2
    //   478: aload 17
    //   480: iconst_0
    //   481: baload
    //   482: bipush 8
    //   484: ishl
    //   485: ldc 71
    //   487: iand
    //   488: aload 17
    //   490: iconst_1
    //   491: baload
    //   492: sipush 255
    //   495: iand
    //   496: ior
    //   497: iconst_2
    //   498: isub
    //   499: istore 6
    //   501: iload_3
    //   502: iconst_m1
    //   503: if_icmpne +43 -> 546
    //   506: iload 5
    //   508: bipush 224
    //   510: if_icmpne +36 -> 546
    //   513: aload 13
    //   515: astore 14
    //   517: iload_2
    //   518: istore_1
    //   519: iload 7
    //   521: istore 4
    //   523: aload 16
    //   525: iload 6
    //   527: i2l
    //   528: invokestatic 200	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   531: iload 6
    //   533: i2l
    //   534: lcmp
    //   535: ifne +1449 -> 1984
    //   538: iload_2
    //   539: iload 6
    //   541: iadd
    //   542: istore_2
    //   543: goto -291 -> 252
    //   546: iload_3
    //   547: iconst_m1
    //   548: if_icmpne +1448 -> 1996
    //   551: iload 5
    //   553: bipush 225
    //   555: if_icmpeq +1441 -> 1996
    //   558: iload 5
    //   560: bipush 225
    //   562: if_icmple +133 -> 695
    //   565: iload 5
    //   567: bipush 239
    //   569: if_icmpge +126 -> 695
    //   572: aload 13
    //   574: astore 14
    //   576: iload_2
    //   577: istore_1
    //   578: iload 7
    //   580: istore 4
    //   582: aload 16
    //   584: iload 6
    //   586: i2l
    //   587: invokestatic 200	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   590: iload 6
    //   592: i2l
    //   593: lcmp
    //   594: ifne +55 -> 649
    //   597: aload 13
    //   599: astore 14
    //   601: iload_2
    //   602: istore_1
    //   603: iload 7
    //   605: istore 4
    //   607: new 104	java/lang/StringBuilder
    //   610: dup
    //   611: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   614: aload 13
    //   616: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: ldc_w 298
    //   622: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: iload 5
    //   627: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   630: ldc_w 300
    //   633: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   639: astore 13
    //   641: iload_2
    //   642: iload 6
    //   644: iadd
    //   645: istore_2
    //   646: goto -394 -> 252
    //   649: aload 13
    //   651: astore 14
    //   653: iload_2
    //   654: istore_1
    //   655: iload 7
    //   657: istore 4
    //   659: new 104	java/lang/StringBuilder
    //   662: dup
    //   663: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   666: ldc_w 298
    //   669: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: iload 5
    //   674: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   677: ldc_w 302
    //   680: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   686: astore 13
    //   688: iload 9
    //   690: istore 5
    //   692: goto -378 -> 314
    //   695: aload 13
    //   697: astore 14
    //   699: iload_2
    //   700: istore_1
    //   701: iload 7
    //   703: istore 4
    //   705: new 104	java/lang/StringBuilder
    //   708: dup
    //   709: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   712: ldc_w 304
    //   715: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: iload 5
    //   720: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   723: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   726: astore 13
    //   728: iload 9
    //   730: istore 5
    //   732: goto -418 -> 314
    //   735: aload 13
    //   737: astore 14
    //   739: iload_2
    //   740: istore_1
    //   741: iload 7
    //   743: istore 4
    //   745: aload 16
    //   747: aload 18
    //   749: iconst_0
    //   750: iconst_4
    //   751: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   754: iconst_4
    //   755: if_icmpeq +14 -> 769
    //   758: ldc 202
    //   760: astore 13
    //   762: iload 9
    //   764: istore 5
    //   766: goto -452 -> 314
    //   769: aload 13
    //   771: astore 14
    //   773: iload_2
    //   774: istore_1
    //   775: iload 7
    //   777: istore 4
    //   779: ldc 25
    //   781: new 204	java/lang/String
    //   784: dup
    //   785: aload 18
    //   787: invokespecial 207	java/lang/String:<init>	([B)V
    //   790: invokevirtual 210	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   793: ifne +14 -> 807
    //   796: ldc 212
    //   798: astore 13
    //   800: iload 9
    //   802: istore 5
    //   804: goto -490 -> 314
    //   807: aload 13
    //   809: astore 14
    //   811: iload_2
    //   812: istore_1
    //   813: iload 7
    //   815: istore 4
    //   817: aload 16
    //   819: ldc2_w 213
    //   822: invokevirtual 217	java/io/BufferedInputStream:skip	(J)J
    //   825: ldc2_w 213
    //   828: lcmp
    //   829: ifeq +14 -> 843
    //   832: ldc 219
    //   834: astore 13
    //   836: iload 9
    //   838: istore 5
    //   840: goto -526 -> 314
    //   843: iload_2
    //   844: iconst_2
    //   845: iadd
    //   846: istore_2
    //   847: aload 13
    //   849: astore 14
    //   851: iload_2
    //   852: istore_1
    //   853: iload 7
    //   855: istore 4
    //   857: aload 16
    //   859: aload 17
    //   861: iconst_0
    //   862: iconst_2
    //   863: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   866: iconst_2
    //   867: if_icmpeq +14 -> 881
    //   870: ldc 221
    //   872: astore 13
    //   874: iload 9
    //   876: istore 5
    //   878: goto -564 -> 314
    //   881: iload_2
    //   882: iconst_2
    //   883: iadd
    //   884: istore_2
    //   885: aload 13
    //   887: astore 14
    //   889: iload_2
    //   890: istore_1
    //   891: iload 7
    //   893: istore 4
    //   895: new 204	java/lang/String
    //   898: dup
    //   899: aload 17
    //   901: invokespecial 207	java/lang/String:<init>	([B)V
    //   904: astore 15
    //   906: aload 13
    //   908: astore 14
    //   910: iload_2
    //   911: istore_1
    //   912: iload 7
    //   914: istore 4
    //   916: ldc 11
    //   918: aload 15
    //   920: invokevirtual 210	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   923: ifeq +42 -> 965
    //   926: iconst_1
    //   927: istore 12
    //   929: aload 13
    //   931: astore 14
    //   933: iload_2
    //   934: istore_1
    //   935: iload 7
    //   937: istore 4
    //   939: aload 16
    //   941: ldc2_w 213
    //   944: invokestatic 200	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   947: ldc2_w 213
    //   950: lcmp
    //   951: ifeq +84 -> 1035
    //   954: ldc 223
    //   956: astore 13
    //   958: iload 9
    //   960: istore 5
    //   962: goto -648 -> 314
    //   965: aload 13
    //   967: astore 14
    //   969: iload_2
    //   970: istore_1
    //   971: iload 7
    //   973: istore 4
    //   975: ldc 32
    //   977: aload 15
    //   979: invokevirtual 210	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   982: ifeq +9 -> 991
    //   985: iconst_0
    //   986: istore 12
    //   988: goto -59 -> 929
    //   991: aload 13
    //   993: astore 14
    //   995: iload_2
    //   996: istore_1
    //   997: iload 7
    //   999: istore 4
    //   1001: new 104	java/lang/StringBuilder
    //   1004: dup
    //   1005: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1008: ldc 225
    //   1010: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1013: aload 15
    //   1015: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: ldc 227
    //   1020: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1026: astore 13
    //   1028: iload 9
    //   1030: istore 5
    //   1032: goto -718 -> 314
    //   1035: aload 13
    //   1037: astore 14
    //   1039: iload_2
    //   1040: istore_1
    //   1041: iload 7
    //   1043: istore 4
    //   1045: aload 16
    //   1047: aload 18
    //   1049: iconst_0
    //   1050: iconst_4
    //   1051: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   1054: iconst_4
    //   1055: if_icmpeq +14 -> 1069
    //   1058: ldc 229
    //   1060: astore 13
    //   1062: iload 9
    //   1064: istore 5
    //   1066: goto -752 -> 314
    //   1069: iload_2
    //   1070: bipush 6
    //   1072: iadd
    //   1073: istore_2
    //   1074: aload 13
    //   1076: astore 14
    //   1078: iload_2
    //   1079: istore_1
    //   1080: iload 7
    //   1082: istore 4
    //   1084: iload 12
    //   1086: aload 18
    //   1088: invokestatic 130	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   1091: bipush 8
    //   1093: isub
    //   1094: istore_3
    //   1095: iload_3
    //   1096: ifle +37 -> 1133
    //   1099: aload 13
    //   1101: astore 14
    //   1103: iload_2
    //   1104: istore_1
    //   1105: iload 7
    //   1107: istore 4
    //   1109: aload 16
    //   1111: iload_3
    //   1112: i2l
    //   1113: invokestatic 200	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1116: iload_3
    //   1117: i2l
    //   1118: lcmp
    //   1119: ifeq +14 -> 1133
    //   1122: ldc 231
    //   1124: astore 13
    //   1126: iload 9
    //   1128: istore 5
    //   1130: goto -816 -> 314
    //   1133: aload 13
    //   1135: astore 14
    //   1137: iload_2
    //   1138: istore_1
    //   1139: iload 7
    //   1141: istore 4
    //   1143: aload 16
    //   1145: aload 17
    //   1147: iconst_0
    //   1148: iconst_2
    //   1149: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   1152: iconst_2
    //   1153: if_icmpeq +14 -> 1167
    //   1156: ldc 233
    //   1158: astore 13
    //   1160: iload 9
    //   1162: istore 5
    //   1164: goto -850 -> 314
    //   1167: iload_2
    //   1168: iload_3
    //   1169: iconst_2
    //   1170: iadd
    //   1171: iadd
    //   1172: istore_2
    //   1173: aload 13
    //   1175: astore 14
    //   1177: iload_2
    //   1178: istore_1
    //   1179: iload 7
    //   1181: istore 4
    //   1183: iload 12
    //   1185: aload 17
    //   1187: invokestatic 124	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1190: istore 6
    //   1192: iconst_0
    //   1193: istore 5
    //   1195: aload 13
    //   1197: astore 15
    //   1199: iload_2
    //   1200: istore_3
    //   1201: iload 5
    //   1203: iload 6
    //   1205: if_icmpge +236 -> 1441
    //   1208: aload 13
    //   1210: astore 14
    //   1212: iload_2
    //   1213: istore_1
    //   1214: iload 7
    //   1216: istore 4
    //   1218: aload 16
    //   1220: aload 17
    //   1222: iconst_0
    //   1223: iconst_2
    //   1224: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   1227: iconst_2
    //   1228: if_icmpeq +15 -> 1243
    //   1231: ldc_w 306
    //   1234: astore 13
    //   1236: iload 9
    //   1238: istore 5
    //   1240: goto -926 -> 314
    //   1243: iload_2
    //   1244: iconst_2
    //   1245: iadd
    //   1246: istore_2
    //   1247: aload 13
    //   1249: astore 14
    //   1251: iload_2
    //   1252: istore_1
    //   1253: iload 7
    //   1255: istore 4
    //   1257: iload 12
    //   1259: aload 17
    //   1261: invokestatic 124	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1264: sipush 274
    //   1267: if_icmpne +600 -> 1867
    //   1270: aload 13
    //   1272: astore 14
    //   1274: iload_2
    //   1275: istore_1
    //   1276: iload 7
    //   1278: istore 4
    //   1280: aload 16
    //   1282: aload 17
    //   1284: iconst_0
    //   1285: iconst_2
    //   1286: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   1289: iconst_2
    //   1290: if_icmpeq +15 -> 1305
    //   1293: ldc_w 308
    //   1296: astore 13
    //   1298: iload 9
    //   1300: istore 5
    //   1302: goto -988 -> 314
    //   1305: iload_2
    //   1306: iconst_2
    //   1307: iadd
    //   1308: istore_2
    //   1309: aload 13
    //   1311: astore 14
    //   1313: iload_2
    //   1314: istore_1
    //   1315: iload 7
    //   1317: istore 4
    //   1319: iload 12
    //   1321: aload 17
    //   1323: invokestatic 124	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1326: istore_3
    //   1327: aload 13
    //   1329: astore 14
    //   1331: iload_2
    //   1332: istore_1
    //   1333: iload 7
    //   1335: istore 4
    //   1337: aload 16
    //   1339: aload 18
    //   1341: iconst_0
    //   1342: iconst_4
    //   1343: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   1346: iconst_4
    //   1347: if_icmpeq +14 -> 1361
    //   1350: ldc 239
    //   1352: astore 13
    //   1354: iload 9
    //   1356: istore 5
    //   1358: goto -1044 -> 314
    //   1361: iload_2
    //   1362: iconst_4
    //   1363: iadd
    //   1364: istore_2
    //   1365: aload 13
    //   1367: astore 14
    //   1369: iload_2
    //   1370: istore_1
    //   1371: iload 7
    //   1373: istore 4
    //   1375: iload 12
    //   1377: aload 18
    //   1379: invokestatic 130	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   1382: getstatic 64	com/tencent/image/JpegExifReader:BYTES_PER_FORMAT	[B
    //   1385: iload_3
    //   1386: baload
    //   1387: imul
    //   1388: istore 5
    //   1390: iload 5
    //   1392: iconst_4
    //   1393: if_icmple +206 -> 1599
    //   1396: aload 13
    //   1398: astore 14
    //   1400: iload_2
    //   1401: istore_1
    //   1402: iload 7
    //   1404: istore 4
    //   1406: new 104	java/lang/StringBuilder
    //   1409: dup
    //   1410: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1413: ldc_w 310
    //   1416: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1419: iload_3
    //   1420: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1423: ldc_w 312
    //   1426: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1429: iload 5
    //   1431: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1434: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1437: astore 15
    //   1439: iload_2
    //   1440: istore_3
    //   1441: aload 15
    //   1443: astore 13
    //   1445: iload_3
    //   1446: istore_2
    //   1447: iload 9
    //   1449: istore 5
    //   1451: aload 15
    //   1453: astore 14
    //   1455: iload_3
    //   1456: istore_1
    //   1457: iload 7
    //   1459: istore 4
    //   1461: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1464: ifeq -1150 -> 314
    //   1467: aload 15
    //   1469: astore 14
    //   1471: iload_3
    //   1472: istore_1
    //   1473: iload 7
    //   1475: istore 4
    //   1477: ldc 44
    //   1479: iconst_2
    //   1480: ldc_w 270
    //   1483: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1486: aload 15
    //   1488: astore 13
    //   1490: iload_3
    //   1491: istore_2
    //   1492: iload 9
    //   1494: istore 5
    //   1496: goto -1182 -> 314
    //   1499: astore 15
    //   1501: aload 16
    //   1503: astore 13
    //   1505: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1508: ifeq +17 -> 1525
    //   1511: aload 16
    //   1513: astore 13
    //   1515: ldc 44
    //   1517: iconst_2
    //   1518: ldc 153
    //   1520: aload 15
    //   1522: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1525: aload 14
    //   1527: astore 13
    //   1529: iload_1
    //   1530: istore_2
    //   1531: iload 4
    //   1533: istore 5
    //   1535: aload 16
    //   1537: ifnull -1213 -> 324
    //   1540: aload 16
    //   1542: invokevirtual 175	java/io/BufferedInputStream:close	()V
    //   1545: aload 14
    //   1547: astore 13
    //   1549: iload_1
    //   1550: istore_2
    //   1551: iload 4
    //   1553: istore 5
    //   1555: goto -1231 -> 324
    //   1558: astore 15
    //   1560: aload 14
    //   1562: astore 13
    //   1564: iload_1
    //   1565: istore_2
    //   1566: iload 4
    //   1568: istore 5
    //   1570: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1573: ifeq -1249 -> 324
    //   1576: ldc 44
    //   1578: iconst_2
    //   1579: ldc 153
    //   1581: aload 15
    //   1583: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1586: aload 14
    //   1588: astore 13
    //   1590: iload_1
    //   1591: istore_2
    //   1592: iload 4
    //   1594: istore 5
    //   1596: goto -1272 -> 324
    //   1599: aload 13
    //   1601: astore 14
    //   1603: iload_2
    //   1604: istore_1
    //   1605: iload 7
    //   1607: istore 4
    //   1609: aload 16
    //   1611: aload 18
    //   1613: iconst_0
    //   1614: iconst_4
    //   1615: invokevirtual 167	java/io/BufferedInputStream:read	([BII)I
    //   1618: iconst_4
    //   1619: if_icmpeq +401 -> 2020
    //   1622: ldc_w 314
    //   1625: astore 13
    //   1627: iload 9
    //   1629: istore 5
    //   1631: goto -1317 -> 314
    //   1634: aload 13
    //   1636: astore 14
    //   1638: iload 6
    //   1640: istore_1
    //   1641: iload 7
    //   1643: istore 4
    //   1645: new 104	java/lang/StringBuilder
    //   1648: dup
    //   1649: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1652: ldc_w 316
    //   1655: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1658: iload_3
    //   1659: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1662: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1665: astore 15
    //   1667: iload 8
    //   1669: istore_3
    //   1670: aload 15
    //   1672: astore 13
    //   1674: iload 6
    //   1676: istore_2
    //   1677: iload_3
    //   1678: istore 5
    //   1680: aload 15
    //   1682: astore 14
    //   1684: iload 6
    //   1686: istore_1
    //   1687: iload_3
    //   1688: istore 4
    //   1690: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1693: ifeq -1379 -> 314
    //   1696: aload 15
    //   1698: astore 14
    //   1700: iload 6
    //   1702: istore_1
    //   1703: iload_3
    //   1704: istore 4
    //   1706: ldc 44
    //   1708: iconst_2
    //   1709: new 104	java/lang/StringBuilder
    //   1712: dup
    //   1713: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1716: ldc_w 318
    //   1719: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1722: iload_3
    //   1723: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1726: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1729: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1732: aload 15
    //   1734: astore 13
    //   1736: iload 6
    //   1738: istore_2
    //   1739: iload_3
    //   1740: istore 5
    //   1742: goto -1428 -> 314
    //   1745: astore_0
    //   1746: aload 16
    //   1748: astore 13
    //   1750: aload 13
    //   1752: ifnull +8 -> 1760
    //   1755: aload 13
    //   1757: invokevirtual 175	java/io/BufferedInputStream:close	()V
    //   1760: aload_0
    //   1761: athrow
    //   1762: aload 13
    //   1764: astore 14
    //   1766: iload 6
    //   1768: istore_1
    //   1769: iload 7
    //   1771: istore 4
    //   1773: iload 12
    //   1775: aload 18
    //   1777: invokestatic 124	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1780: istore_3
    //   1781: aload 13
    //   1783: astore 15
    //   1785: goto -115 -> 1670
    //   1788: aload 13
    //   1790: astore 14
    //   1792: iload 6
    //   1794: istore_1
    //   1795: iload 7
    //   1797: istore 4
    //   1799: iload 12
    //   1801: aload 18
    //   1803: invokestatic 126	com/tencent/image/JpegExifReader:getUnsignedInt32	(Z[B)J
    //   1806: l2i
    //   1807: istore_3
    //   1808: aload 13
    //   1810: astore 15
    //   1812: goto -142 -> 1670
    //   1815: aload 13
    //   1817: astore 14
    //   1819: iload 6
    //   1821: istore_1
    //   1822: iload 7
    //   1824: istore 4
    //   1826: iload 12
    //   1828: aload 18
    //   1830: invokestatic 128	com/tencent/image/JpegExifReader:getInt16	(Z[B)S
    //   1833: istore_3
    //   1834: aload 13
    //   1836: astore 15
    //   1838: goto -168 -> 1670
    //   1841: aload 13
    //   1843: astore 14
    //   1845: iload 6
    //   1847: istore_1
    //   1848: iload 7
    //   1850: istore 4
    //   1852: iload 12
    //   1854: aload 18
    //   1856: invokestatic 130	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   1859: istore_3
    //   1860: aload 13
    //   1862: astore 15
    //   1864: goto -194 -> 1670
    //   1867: aload 13
    //   1869: astore 14
    //   1871: iload_2
    //   1872: istore_1
    //   1873: iload 7
    //   1875: istore 4
    //   1877: aload 16
    //   1879: ldc2_w 260
    //   1882: invokestatic 200	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1885: ldc2_w 260
    //   1888: lcmp
    //   1889: ifeq +15 -> 1904
    //   1892: ldc_w 263
    //   1895: astore 13
    //   1897: iload 9
    //   1899: istore 5
    //   1901: goto -1587 -> 314
    //   1904: iload_2
    //   1905: bipush 10
    //   1907: iadd
    //   1908: istore_2
    //   1909: iload 5
    //   1911: iconst_1
    //   1912: iadd
    //   1913: istore 5
    //   1915: goto -720 -> 1195
    //   1918: astore 14
    //   1920: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1923: ifeq +13 -> 1936
    //   1926: ldc 44
    //   1928: iconst_2
    //   1929: ldc 153
    //   1931: aload 14
    //   1933: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1936: goto -1612 -> 324
    //   1939: astore 13
    //   1941: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1944: ifeq -184 -> 1760
    //   1947: ldc 44
    //   1949: iconst_2
    //   1950: ldc 153
    //   1952: aload 13
    //   1954: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1957: goto -197 -> 1760
    //   1960: astore_0
    //   1961: goto -211 -> 1750
    //   1964: astore 13
    //   1966: aload 14
    //   1968: astore 16
    //   1970: aload 15
    //   1972: astore 14
    //   1974: aload 13
    //   1976: astore 15
    //   1978: goto -477 -> 1501
    //   1981: goto -1657 -> 324
    //   1984: ldc_w 272
    //   1987: astore 13
    //   1989: iload 9
    //   1991: istore 5
    //   1993: goto -1679 -> 314
    //   1996: iload_3
    //   1997: iconst_m1
    //   1998: if_icmpne +10 -> 2008
    //   2001: iload 5
    //   2003: bipush 225
    //   2005: if_icmpeq -1270 -> 735
    //   2008: ldc_w 274
    //   2011: astore 13
    //   2013: iload 9
    //   2015: istore 5
    //   2017: goto -1703 -> 314
    //   2020: iload_2
    //   2021: iconst_4
    //   2022: iadd
    //   2023: istore 6
    //   2025: iload_3
    //   2026: tableswitch	default:+42 -> 2068, 3:+-264->1762, 4:+-238->1788, 5:+-392->1634, 6:+45->2071, 7:+-392->1634, 8:+-211->1815, 9:+-185->1841
    //   2069: impdep1
    //   2070: astore_3
    //   2071: aload 18
    //   2073: iconst_0
    //   2074: baload
    //   2075: istore_3
    //   2076: aload 13
    //   2078: astore 15
    //   2080: goto -410 -> 1670
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2083	0	paramString	String
    //   112	1761	1	i	int
    //   114	1909	2	j	int
    //   140	1936	3	k	int
    //   9	1867	4	m	int
    //   223	1793	5	n	int
    //   212	1812	6	i1	int
    //   6	1868	7	i2	int
    //   12	1656	8	i3	int
    //   15	1999	9	i4	int
    //   3	395	10	l	long
    //   927	926	12	bool	boolean
    //   51	1845	13	localObject1	Object
    //   1939	14	13	localIOException1	IOException
    //   1964	11	13	localThrowable1	java.lang.Throwable
    //   1987	90	13	str	String
    //   68	18	14	localIOException2	IOException
    //   109	1761	14	localObject2	Object
    //   1918	49	14	localIOException3	IOException
    //   1972	1	14	localObject3	Object
    //   117	1370	15	localObject4	Object
    //   1499	22	15	localThrowable2	java.lang.Throwable
    //   1558	24	15	localIOException4	IOException
    //   1665	414	15	localObject5	Object
    //   137	1832	16	localObject6	Object
    //   154	1168	17	arrayOfByte1	byte[]
    //   243	1829	18	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   53	62	68	java/io/IOException
    //   151	156	1499	java/lang/Throwable
    //   166	179	1499	java/lang/Throwable
    //   240	245	1499	java/lang/Throwable
    //   262	273	1499	java/lang/Throwable
    //   287	299	1499	java/lang/Throwable
    //   450	463	1499	java/lang/Throwable
    //   523	538	1499	java/lang/Throwable
    //   582	597	1499	java/lang/Throwable
    //   607	641	1499	java/lang/Throwable
    //   659	688	1499	java/lang/Throwable
    //   705	728	1499	java/lang/Throwable
    //   745	758	1499	java/lang/Throwable
    //   779	796	1499	java/lang/Throwable
    //   817	832	1499	java/lang/Throwable
    //   857	870	1499	java/lang/Throwable
    //   895	906	1499	java/lang/Throwable
    //   916	926	1499	java/lang/Throwable
    //   939	954	1499	java/lang/Throwable
    //   975	985	1499	java/lang/Throwable
    //   1001	1028	1499	java/lang/Throwable
    //   1045	1058	1499	java/lang/Throwable
    //   1084	1095	1499	java/lang/Throwable
    //   1109	1122	1499	java/lang/Throwable
    //   1143	1156	1499	java/lang/Throwable
    //   1183	1192	1499	java/lang/Throwable
    //   1218	1231	1499	java/lang/Throwable
    //   1257	1270	1499	java/lang/Throwable
    //   1280	1293	1499	java/lang/Throwable
    //   1319	1327	1499	java/lang/Throwable
    //   1337	1350	1499	java/lang/Throwable
    //   1375	1390	1499	java/lang/Throwable
    //   1406	1439	1499	java/lang/Throwable
    //   1461	1467	1499	java/lang/Throwable
    //   1477	1486	1499	java/lang/Throwable
    //   1609	1622	1499	java/lang/Throwable
    //   1645	1667	1499	java/lang/Throwable
    //   1690	1696	1499	java/lang/Throwable
    //   1706	1732	1499	java/lang/Throwable
    //   1773	1781	1499	java/lang/Throwable
    //   1799	1808	1499	java/lang/Throwable
    //   1826	1834	1499	java/lang/Throwable
    //   1852	1860	1499	java/lang/Throwable
    //   1877	1892	1499	java/lang/Throwable
    //   1540	1545	1558	java/io/IOException
    //   151	156	1745	finally
    //   166	179	1745	finally
    //   240	245	1745	finally
    //   262	273	1745	finally
    //   287	299	1745	finally
    //   450	463	1745	finally
    //   523	538	1745	finally
    //   582	597	1745	finally
    //   607	641	1745	finally
    //   659	688	1745	finally
    //   705	728	1745	finally
    //   745	758	1745	finally
    //   779	796	1745	finally
    //   817	832	1745	finally
    //   857	870	1745	finally
    //   895	906	1745	finally
    //   916	926	1745	finally
    //   939	954	1745	finally
    //   975	985	1745	finally
    //   1001	1028	1745	finally
    //   1045	1058	1745	finally
    //   1084	1095	1745	finally
    //   1109	1122	1745	finally
    //   1143	1156	1745	finally
    //   1183	1192	1745	finally
    //   1218	1231	1745	finally
    //   1257	1270	1745	finally
    //   1280	1293	1745	finally
    //   1319	1327	1745	finally
    //   1337	1350	1745	finally
    //   1375	1390	1745	finally
    //   1406	1439	1745	finally
    //   1461	1467	1745	finally
    //   1477	1486	1745	finally
    //   1609	1622	1745	finally
    //   1645	1667	1745	finally
    //   1690	1696	1745	finally
    //   1706	1732	1745	finally
    //   1773	1781	1745	finally
    //   1799	1808	1745	finally
    //   1826	1834	1745	finally
    //   1852	1860	1745	finally
    //   1877	1892	1745	finally
    //   319	324	1918	java/io/IOException
    //   1755	1760	1939	java/io/IOException
    //   119	139	1960	finally
    //   1505	1511	1960	finally
    //   1515	1525	1960	finally
    //   119	139	1964	java/lang/Throwable
  }
  
  private static long skip(InputStream paramInputStream, long paramLong)
    throws IOException
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
  
  public static abstract interface JpegExifReaderInterface
  {
    public abstract void doReport(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3);
    
    public abstract boolean readEnableFromDPC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.JpegExifReader
 * JD-Core Version:    0.7.0.1
 */