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
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.e("JpegExifReader", 2, "get value format code: " + paramInt);
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
    //   0: getstatic 151	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 24
    //   5: if_icmplt +9 -> 14
    //   8: iconst_0
    //   9: istore 8
    //   11: iload 8
    //   13: ireturn
    //   14: invokestatic 157	android/os/SystemClock:uptimeMillis	()J
    //   17: lstore 10
    //   19: iconst_0
    //   20: istore 9
    //   22: iconst_0
    //   23: istore 8
    //   25: aconst_null
    //   26: astore 14
    //   28: iconst_0
    //   29: istore_3
    //   30: new 159	java/io/BufferedInputStream
    //   33: dup
    //   34: new 161	java/io/FileInputStream
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 164	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   42: sipush 1024
    //   45: invokespecial 167	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
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
    //   67: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   70: iconst_2
    //   71: if_icmpne +33 -> 104
    //   74: aload 14
    //   76: iconst_0
    //   77: baload
    //   78: sipush 255
    //   81: iand
    //   82: sipush 255
    //   85: if_icmpne +214 -> 299
    //   88: aload 14
    //   90: iconst_1
    //   91: baload
    //   92: sipush 255
    //   95: iand
    //   96: sipush 216
    //   99: if_icmpne +200 -> 299
    //   102: iconst_1
    //   103: istore_2
    //   104: iconst_2
    //   105: istore 4
    //   107: iload 4
    //   109: istore_3
    //   110: iload_2
    //   111: ifeq +1611 -> 1722
    //   114: iload 4
    //   116: istore_1
    //   117: iconst_4
    //   118: newarray byte
    //   120: astore 16
    //   122: iload 4
    //   124: istore_1
    //   125: aload 15
    //   127: invokevirtual 174	java/io/BufferedInputStream:read	()I
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
    //   145: invokevirtual 174	java/io/BufferedInputStream:read	()I
    //   148: sipush 255
    //   151: iand
    //   152: i2b
    //   153: istore 4
    //   155: iload 4
    //   157: bipush 218
    //   159: if_icmpne +145 -> 304
    //   162: ldc 176
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
    //   185: invokevirtual 179	java/io/BufferedInputStream:close	()V
    //   188: iload 8
    //   190: istore 7
    //   192: iload_1
    //   193: istore_2
    //   194: aload 14
    //   196: astore 16
    //   198: invokestatic 157	android/os/SystemClock:uptimeMillis	()J
    //   201: lstore 12
    //   203: iload 7
    //   205: istore 8
    //   207: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   210: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   213: invokeinterface 108 1 0
    //   218: ifeq -207 -> 11
    //   221: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   224: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   227: ldc 41
    //   229: iconst_2
    //   230: new 110	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   237: ldc 181
    //   239: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: iload 7
    //   244: invokevirtual 184	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   247: ldc 186
    //   249: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: iload_2
    //   253: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   256: ldc 188
    //   258: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: lload 12
    //   263: lload 10
    //   265: lsub
    //   266: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   269: ldc 193
    //   271: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload_0
    //   275: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc 195
    //   280: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload 16
    //   285: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokeinterface 198 4 0
    //   296: iload 7
    //   298: ireturn
    //   299: iconst_0
    //   300: istore_2
    //   301: goto -197 -> 104
    //   304: iload_2
    //   305: iconst_1
    //   306: iadd
    //   307: istore_2
    //   308: iload_2
    //   309: istore_1
    //   310: aload 15
    //   312: aload 14
    //   314: iconst_0
    //   315: iconst_2
    //   316: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   319: iconst_2
    //   320: if_icmpeq +12 -> 332
    //   323: ldc 200
    //   325: astore 14
    //   327: iload_2
    //   328: istore_1
    //   329: goto -161 -> 168
    //   332: iload_2
    //   333: iconst_2
    //   334: iadd
    //   335: istore_2
    //   336: aload 14
    //   338: iconst_0
    //   339: baload
    //   340: bipush 8
    //   342: ishl
    //   343: ldc 68
    //   345: iand
    //   346: aload 14
    //   348: iconst_1
    //   349: baload
    //   350: sipush 255
    //   353: iand
    //   354: ior
    //   355: iconst_2
    //   356: isub
    //   357: istore 5
    //   359: iload_3
    //   360: iconst_m1
    //   361: if_icmpne +1381 -> 1742
    //   364: iload 4
    //   366: bipush 224
    //   368: if_icmpne +1374 -> 1742
    //   371: iload_2
    //   372: istore_1
    //   373: aload 15
    //   375: iload 5
    //   377: i2l
    //   378: invokestatic 204	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   381: iload 5
    //   383: i2l
    //   384: lcmp
    //   385: ifne +1347 -> 1732
    //   388: iload_2
    //   389: iload 5
    //   391: iadd
    //   392: istore 4
    //   394: goto -272 -> 122
    //   397: iload_2
    //   398: istore_1
    //   399: aload 15
    //   401: aload 16
    //   403: iconst_0
    //   404: iconst_4
    //   405: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   408: iconst_4
    //   409: if_icmpeq +12 -> 421
    //   412: ldc 206
    //   414: astore 14
    //   416: iload_2
    //   417: istore_1
    //   418: goto -250 -> 168
    //   421: iload_2
    //   422: iconst_4
    //   423: iadd
    //   424: istore_2
    //   425: iload_2
    //   426: istore_1
    //   427: ldc 22
    //   429: new 208	java/lang/String
    //   432: dup
    //   433: aload 16
    //   435: invokespecial 211	java/lang/String:<init>	([B)V
    //   438: invokevirtual 214	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   441: ifne +12 -> 453
    //   444: ldc 216
    //   446: astore 14
    //   448: iload_2
    //   449: istore_1
    //   450: goto -282 -> 168
    //   453: iload_2
    //   454: istore_1
    //   455: aload 15
    //   457: ldc2_w 217
    //   460: invokevirtual 221	java/io/BufferedInputStream:skip	(J)J
    //   463: ldc2_w 217
    //   466: lcmp
    //   467: ifeq +12 -> 479
    //   470: ldc 223
    //   472: astore 14
    //   474: iload_2
    //   475: istore_1
    //   476: goto -308 -> 168
    //   479: iload_2
    //   480: iconst_2
    //   481: iadd
    //   482: istore_3
    //   483: iload_3
    //   484: istore_1
    //   485: aload 15
    //   487: aload 14
    //   489: iconst_0
    //   490: iconst_2
    //   491: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   494: iconst_2
    //   495: if_icmpeq +12 -> 507
    //   498: ldc 225
    //   500: astore 14
    //   502: iload_3
    //   503: istore_1
    //   504: goto -336 -> 168
    //   507: iload_3
    //   508: iconst_2
    //   509: iadd
    //   510: istore_2
    //   511: iload_2
    //   512: istore_1
    //   513: new 208	java/lang/String
    //   516: dup
    //   517: aload 14
    //   519: invokespecial 211	java/lang/String:<init>	([B)V
    //   522: astore 17
    //   524: iload_2
    //   525: istore_1
    //   526: ldc 8
    //   528: aload 17
    //   530: invokevirtual 214	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   533: ifeq +32 -> 565
    //   536: iconst_1
    //   537: istore 7
    //   539: iload_2
    //   540: istore_1
    //   541: aload 15
    //   543: ldc2_w 217
    //   546: invokestatic 204	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   549: ldc2_w 217
    //   552: lcmp
    //   553: ifeq +64 -> 617
    //   556: ldc 227
    //   558: astore 14
    //   560: iload_2
    //   561: istore_1
    //   562: goto -394 -> 168
    //   565: iload_2
    //   566: istore_1
    //   567: ldc 29
    //   569: aload 17
    //   571: invokevirtual 214	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   574: ifeq +9 -> 583
    //   577: iconst_0
    //   578: istore 7
    //   580: goto -41 -> 539
    //   583: iload_2
    //   584: istore_1
    //   585: new 110	java/lang/StringBuilder
    //   588: dup
    //   589: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   592: ldc 229
    //   594: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: aload 17
    //   599: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: ldc 231
    //   604: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: astore 14
    //   612: iload_2
    //   613: istore_1
    //   614: goto -446 -> 168
    //   617: iload_2
    //   618: istore_1
    //   619: aload 15
    //   621: aload 16
    //   623: iconst_0
    //   624: iconst_4
    //   625: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   628: iconst_4
    //   629: if_icmpeq +12 -> 641
    //   632: ldc 233
    //   634: astore 14
    //   636: iload_2
    //   637: istore_1
    //   638: goto -470 -> 168
    //   641: iload_2
    //   642: bipush 6
    //   644: iadd
    //   645: istore_2
    //   646: iload_2
    //   647: istore_1
    //   648: iload 7
    //   650: aload 16
    //   652: invokestatic 136	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   655: bipush 8
    //   657: isub
    //   658: istore 4
    //   660: iload 4
    //   662: ifle +29 -> 691
    //   665: iload_2
    //   666: istore_1
    //   667: aload 15
    //   669: iload 4
    //   671: i2l
    //   672: invokestatic 204	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   675: iload 4
    //   677: i2l
    //   678: lcmp
    //   679: ifeq +12 -> 691
    //   682: ldc 235
    //   684: astore 14
    //   686: iload_2
    //   687: istore_1
    //   688: goto -520 -> 168
    //   691: iload_2
    //   692: istore_1
    //   693: aload 15
    //   695: aload 14
    //   697: iconst_0
    //   698: iconst_2
    //   699: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   702: iconst_2
    //   703: if_icmpeq +12 -> 715
    //   706: ldc 237
    //   708: astore 14
    //   710: iload_2
    //   711: istore_1
    //   712: goto -544 -> 168
    //   715: iload_2
    //   716: iload 4
    //   718: iconst_2
    //   719: iadd
    //   720: iadd
    //   721: istore_2
    //   722: iload_2
    //   723: istore_1
    //   724: iload 7
    //   726: aload 14
    //   728: invokestatic 130	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   731: istore 5
    //   733: iconst_0
    //   734: istore 4
    //   736: iload 4
    //   738: iload 5
    //   740: if_icmpge +634 -> 1374
    //   743: iload_2
    //   744: istore_1
    //   745: aload 15
    //   747: aload 14
    //   749: iconst_0
    //   750: iconst_2
    //   751: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   754: iconst_2
    //   755: if_icmpeq +12 -> 767
    //   758: ldc 239
    //   760: astore 14
    //   762: iload_2
    //   763: istore_1
    //   764: goto -596 -> 168
    //   767: iload_2
    //   768: iconst_2
    //   769: iadd
    //   770: istore_2
    //   771: iload_2
    //   772: istore_1
    //   773: iload 7
    //   775: aload 14
    //   777: invokestatic 130	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   780: ldc 38
    //   782: if_icmpne +565 -> 1347
    //   785: iload_2
    //   786: istore_1
    //   787: aload 15
    //   789: aload 14
    //   791: iconst_0
    //   792: iconst_2
    //   793: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   796: iconst_2
    //   797: if_icmpeq +12 -> 809
    //   800: ldc 241
    //   802: astore 14
    //   804: iload_2
    //   805: istore_1
    //   806: goto -638 -> 168
    //   809: iload_2
    //   810: iconst_2
    //   811: iadd
    //   812: istore_2
    //   813: iload_2
    //   814: istore_1
    //   815: iload 7
    //   817: aload 14
    //   819: invokestatic 130	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   822: istore 4
    //   824: iload_2
    //   825: istore_1
    //   826: aload 15
    //   828: aload 16
    //   830: iconst_0
    //   831: iconst_4
    //   832: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   835: iconst_4
    //   836: if_icmpeq +12 -> 848
    //   839: ldc 243
    //   841: astore 14
    //   843: iload_2
    //   844: istore_1
    //   845: goto -677 -> 168
    //   848: iload_2
    //   849: iconst_4
    //   850: iadd
    //   851: istore_2
    //   852: iload_2
    //   853: istore_1
    //   854: iload 7
    //   856: aload 16
    //   858: invokestatic 136	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   861: pop
    //   862: iload_2
    //   863: istore_1
    //   864: getstatic 57	com/tencent/image/JpegExifReader:BYTES_PER_FORMAT	[B
    //   867: iload 4
    //   869: baload
    //   870: istore 5
    //   872: iload_2
    //   873: istore_1
    //   874: aload 15
    //   876: aload 16
    //   878: iconst_0
    //   879: iconst_4
    //   880: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   883: iconst_4
    //   884: if_icmpeq +12 -> 896
    //   887: ldc 245
    //   889: astore 14
    //   891: iload_2
    //   892: istore_1
    //   893: goto -725 -> 168
    //   896: iload_2
    //   897: iconst_4
    //   898: iadd
    //   899: istore_2
    //   900: iload_2
    //   901: istore_1
    //   902: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   905: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   908: invokeinterface 108 1 0
    //   913: ifeq +39 -> 952
    //   916: iload_2
    //   917: istore_1
    //   918: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   921: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   924: ldc 41
    //   926: iconst_2
    //   927: new 110	java/lang/StringBuilder
    //   930: dup
    //   931: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   934: ldc 247
    //   936: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: iload 4
    //   941: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   944: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   947: invokeinterface 198 4 0
    //   952: iload_2
    //   953: istore_1
    //   954: iload 4
    //   956: iload 7
    //   958: aload 16
    //   960: invokestatic 249	com/tencent/image/JpegExifReader:getValue	(IZ[B)J
    //   963: iload_3
    //   964: i2l
    //   965: ladd
    //   966: iload_2
    //   967: i2l
    //   968: lsub
    //   969: lstore 12
    //   971: iload_2
    //   972: istore_1
    //   973: aload 15
    //   975: lload 12
    //   977: invokestatic 204	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   980: lload 12
    //   982: lcmp
    //   983: ifeq +12 -> 995
    //   986: ldc 251
    //   988: astore 14
    //   990: iload_2
    //   991: istore_1
    //   992: goto -824 -> 168
    //   995: iload_2
    //   996: istore_1
    //   997: aload 15
    //   999: aload 14
    //   1001: iconst_0
    //   1002: iconst_2
    //   1003: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   1006: iconst_2
    //   1007: if_icmpeq +12 -> 1019
    //   1010: ldc 253
    //   1012: astore 14
    //   1014: iload_2
    //   1015: istore_1
    //   1016: goto -848 -> 168
    //   1019: iload_2
    //   1020: iconst_2
    //   1021: iadd
    //   1022: istore_2
    //   1023: iload_2
    //   1024: istore_1
    //   1025: iload 7
    //   1027: aload 14
    //   1029: invokestatic 130	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1032: istore 4
    //   1034: iconst_0
    //   1035: istore_3
    //   1036: iload_3
    //   1037: iload 4
    //   1039: if_icmpge +261 -> 1300
    //   1042: iload_2
    //   1043: istore_1
    //   1044: aload 15
    //   1046: aload 14
    //   1048: iconst_0
    //   1049: iconst_2
    //   1050: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   1053: iconst_2
    //   1054: if_icmpeq +12 -> 1066
    //   1057: ldc 255
    //   1059: astore 14
    //   1061: iload_2
    //   1062: istore_1
    //   1063: goto -895 -> 168
    //   1066: iload_2
    //   1067: iconst_2
    //   1068: iadd
    //   1069: istore_2
    //   1070: iload_2
    //   1071: istore_1
    //   1072: iload 7
    //   1074: aload 14
    //   1076: invokestatic 130	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1079: ldc 24
    //   1081: if_icmpne +192 -> 1273
    //   1084: iload_2
    //   1085: istore_1
    //   1086: aload 15
    //   1088: aload 14
    //   1090: iconst_0
    //   1091: iconst_2
    //   1092: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   1095: iconst_2
    //   1096: if_icmpeq +13 -> 1109
    //   1099: ldc_w 257
    //   1102: astore 14
    //   1104: iload_2
    //   1105: istore_1
    //   1106: goto -938 -> 168
    //   1109: iload_2
    //   1110: iconst_2
    //   1111: iadd
    //   1112: istore_2
    //   1113: iload_2
    //   1114: istore_1
    //   1115: iload 7
    //   1117: aload 14
    //   1119: invokestatic 130	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1122: istore 5
    //   1124: iload_2
    //   1125: istore_1
    //   1126: aload 15
    //   1128: aload 16
    //   1130: iconst_0
    //   1131: iconst_4
    //   1132: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   1135: iconst_4
    //   1136: if_icmpeq +13 -> 1149
    //   1139: ldc_w 259
    //   1142: astore 14
    //   1144: iload_2
    //   1145: istore_1
    //   1146: goto -978 -> 168
    //   1149: iload_2
    //   1150: iconst_4
    //   1151: iadd
    //   1152: istore_2
    //   1153: iload_2
    //   1154: istore_1
    //   1155: iload 7
    //   1157: aload 16
    //   1159: invokestatic 136	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   1162: pop
    //   1163: iload_2
    //   1164: istore_1
    //   1165: getstatic 57	com/tencent/image/JpegExifReader:BYTES_PER_FORMAT	[B
    //   1168: iload 5
    //   1170: baload
    //   1171: istore 6
    //   1173: iload_2
    //   1174: istore_1
    //   1175: aload 15
    //   1177: aload 16
    //   1179: iconst_0
    //   1180: iconst_4
    //   1181: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   1184: iconst_4
    //   1185: if_icmpeq +13 -> 1198
    //   1188: ldc_w 261
    //   1191: astore 14
    //   1193: iload_2
    //   1194: istore_1
    //   1195: goto -1027 -> 168
    //   1198: iload_2
    //   1199: iconst_4
    //   1200: iadd
    //   1201: istore_2
    //   1202: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1205: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1208: invokeinterface 108 1 0
    //   1213: ifeq +38 -> 1251
    //   1216: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1219: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1222: ldc 41
    //   1224: iconst_2
    //   1225: new 110	java/lang/StringBuilder
    //   1228: dup
    //   1229: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1232: ldc_w 263
    //   1235: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1238: iload 5
    //   1240: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1243: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1246: invokeinterface 198 4 0
    //   1251: iload_2
    //   1252: istore_1
    //   1253: iload 5
    //   1255: bipush 12
    //   1257: if_icmpne +512 -> 1769
    //   1260: iconst_1
    //   1261: istore 8
    //   1263: iload_2
    //   1264: istore_1
    //   1265: ldc_w 265
    //   1268: astore 14
    //   1270: goto -1102 -> 168
    //   1273: iload_2
    //   1274: istore_1
    //   1275: aload 15
    //   1277: ldc2_w 266
    //   1280: invokestatic 204	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1283: ldc2_w 266
    //   1286: lcmp
    //   1287: ifeq +477 -> 1764
    //   1290: ldc_w 269
    //   1293: astore 14
    //   1295: iload_2
    //   1296: istore_1
    //   1297: goto -1129 -> 168
    //   1300: iload_2
    //   1301: istore_1
    //   1302: iload_2
    //   1303: istore_3
    //   1304: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1307: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1310: invokeinterface 108 1 0
    //   1315: ifeq +407 -> 1722
    //   1318: iload_2
    //   1319: istore_1
    //   1320: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1323: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1326: ldc 41
    //   1328: iconst_2
    //   1329: ldc_w 271
    //   1332: invokeinterface 198 4 0
    //   1337: ldc_w 265
    //   1340: astore 14
    //   1342: iload_2
    //   1343: istore_1
    //   1344: goto -1176 -> 168
    //   1347: iload_2
    //   1348: istore_1
    //   1349: aload 15
    //   1351: ldc2_w 266
    //   1354: invokestatic 204	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1357: ldc2_w 266
    //   1360: lcmp
    //   1361: ifeq +417 -> 1778
    //   1364: ldc_w 269
    //   1367: astore 14
    //   1369: iload_2
    //   1370: istore_1
    //   1371: goto -1203 -> 168
    //   1374: iload_2
    //   1375: istore_1
    //   1376: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1379: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1382: invokeinterface 108 1 0
    //   1387: ifeq +325 -> 1712
    //   1390: iload_2
    //   1391: istore_1
    //   1392: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1395: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1398: ldc 41
    //   1400: iconst_2
    //   1401: ldc_w 273
    //   1404: invokeinterface 198 4 0
    //   1409: ldc_w 265
    //   1412: astore 14
    //   1414: iload_2
    //   1415: istore_1
    //   1416: goto -1248 -> 168
    //   1419: astore 15
    //   1421: aload 14
    //   1423: astore 16
    //   1425: iload_1
    //   1426: istore_2
    //   1427: iload 8
    //   1429: istore 7
    //   1431: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1434: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1437: invokeinterface 108 1 0
    //   1442: ifeq -1244 -> 198
    //   1445: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1448: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1451: ldc 41
    //   1453: iconst_2
    //   1454: ldc_w 265
    //   1457: aload 15
    //   1459: invokeinterface 276 5 0
    //   1464: aload 14
    //   1466: astore 16
    //   1468: iload_1
    //   1469: istore_2
    //   1470: iload 8
    //   1472: istore 7
    //   1474: goto -1276 -> 198
    //   1477: astore 15
    //   1479: iconst_0
    //   1480: istore_1
    //   1481: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1484: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1487: invokeinterface 108 1 0
    //   1492: ifeq +22 -> 1514
    //   1495: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1498: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1501: ldc 41
    //   1503: iconst_2
    //   1504: ldc_w 265
    //   1507: aload 15
    //   1509: invokeinterface 276 5 0
    //   1514: aload 14
    //   1516: ifnull +182 -> 1698
    //   1519: aload 14
    //   1521: invokevirtual 179	java/io/BufferedInputStream:close	()V
    //   1524: ldc_w 265
    //   1527: astore 16
    //   1529: iload_1
    //   1530: istore_2
    //   1531: iload 9
    //   1533: istore 7
    //   1535: goto -1337 -> 198
    //   1538: astore 14
    //   1540: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1543: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1546: invokeinterface 108 1 0
    //   1551: ifeq +22 -> 1573
    //   1554: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1557: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1560: ldc 41
    //   1562: iconst_2
    //   1563: ldc_w 265
    //   1566: aload 14
    //   1568: invokeinterface 276 5 0
    //   1573: ldc_w 265
    //   1576: astore 16
    //   1578: iload_1
    //   1579: istore_2
    //   1580: iload 9
    //   1582: istore 7
    //   1584: goto -1386 -> 198
    //   1587: astore_0
    //   1588: aconst_null
    //   1589: astore 15
    //   1591: aload 15
    //   1593: ifnull +8 -> 1601
    //   1596: aload 15
    //   1598: invokevirtual 179	java/io/BufferedInputStream:close	()V
    //   1601: aload_0
    //   1602: athrow
    //   1603: astore 14
    //   1605: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1608: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1611: invokeinterface 108 1 0
    //   1616: ifeq -15 -> 1601
    //   1619: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1622: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1625: ldc 41
    //   1627: iconst_2
    //   1628: ldc_w 265
    //   1631: aload 14
    //   1633: invokeinterface 276 5 0
    //   1638: goto -37 -> 1601
    //   1641: astore_0
    //   1642: goto -51 -> 1591
    //   1645: astore_0
    //   1646: aload 14
    //   1648: astore 15
    //   1650: goto -59 -> 1591
    //   1653: astore 16
    //   1655: aload 15
    //   1657: astore 14
    //   1659: aload 16
    //   1661: astore 15
    //   1663: goto -182 -> 1481
    //   1666: astore 14
    //   1668: aload 15
    //   1670: astore 16
    //   1672: aload 14
    //   1674: astore 15
    //   1676: aload 16
    //   1678: astore 14
    //   1680: goto -199 -> 1481
    //   1683: astore 16
    //   1685: aload 15
    //   1687: astore 14
    //   1689: iload_2
    //   1690: istore_1
    //   1691: aload 16
    //   1693: astore 15
    //   1695: goto -214 -> 1481
    //   1698: ldc_w 265
    //   1701: astore 16
    //   1703: iload_1
    //   1704: istore_2
    //   1705: iload 9
    //   1707: istore 7
    //   1709: goto -1511 -> 198
    //   1712: ldc_w 265
    //   1715: astore 14
    //   1717: iload_2
    //   1718: istore_1
    //   1719: goto -1551 -> 168
    //   1722: ldc_w 265
    //   1725: astore 14
    //   1727: iload_3
    //   1728: istore_1
    //   1729: goto -1561 -> 168
    //   1732: ldc_w 278
    //   1735: astore 14
    //   1737: iload_2
    //   1738: istore_1
    //   1739: goto -1571 -> 168
    //   1742: iload_3
    //   1743: iconst_m1
    //   1744: if_icmpne +10 -> 1754
    //   1747: iload 4
    //   1749: bipush 225
    //   1751: if_icmpeq -1354 -> 397
    //   1754: ldc_w 280
    //   1757: astore 14
    //   1759: iload_2
    //   1760: istore_1
    //   1761: goto -1593 -> 168
    //   1764: iload_2
    //   1765: bipush 10
    //   1767: iadd
    //   1768: istore_1
    //   1769: iload_3
    //   1770: iconst_1
    //   1771: iadd
    //   1772: istore_3
    //   1773: iload_1
    //   1774: istore_2
    //   1775: goto -739 -> 1036
    //   1778: iload_2
    //   1779: bipush 10
    //   1781: iadd
    //   1782: istore_2
    //   1783: iload 4
    //   1785: iconst_1
    //   1786: iadd
    //   1787: istore 4
    //   1789: goto -1053 -> 736
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1792	0	paramString	String
    //   53	1721	1	i	int
    //   51	1732	2	j	int
    //   29	1744	3	k	int
    //   105	1683	4	m	int
    //   357	901	5	n	int
    //   1171	1	6	i1	int
    //   176	1532	7	bool1	boolean
    //   9	1462	8	bool2	boolean
    //   20	1686	9	bool3	boolean
    //   17	247	10	l1	long
    //   201	780	12	l2	long
    //   26	1494	14	localObject1	Object
    //   1538	29	14	localIOException1	IOException
    //   1603	44	14	localIOException2	IOException
    //   1657	1	14	localObject2	Object
    //   1666	7	14	localThrowable1	java.lang.Throwable
    //   1678	80	14	localObject3	Object
    //   48	1302	15	localBufferedInputStream	java.io.BufferedInputStream
    //   1419	39	15	localIOException3	IOException
    //   1477	31	15	localThrowable2	java.lang.Throwable
    //   1589	105	15	localObject4	Object
    //   120	1457	16	localObject5	Object
    //   1653	7	16	localThrowable3	java.lang.Throwable
    //   1670	7	16	localObject6	Object
    //   1683	9	16	localThrowable4	java.lang.Throwable
    //   1701	1	16	str1	String
    //   522	76	17	str2	String
    // Exception table:
    //   from	to	target	type
    //   183	188	1419	java/io/IOException
    //   30	50	1477	java/lang/Throwable
    //   1519	1524	1538	java/io/IOException
    //   30	50	1587	finally
    //   1596	1601	1603	java/io/IOException
    //   54	59	1641	finally
    //   61	74	1641	finally
    //   117	122	1641	finally
    //   125	136	1641	finally
    //   143	155	1641	finally
    //   310	323	1641	finally
    //   373	388	1641	finally
    //   399	412	1641	finally
    //   427	444	1641	finally
    //   455	470	1641	finally
    //   485	498	1641	finally
    //   513	524	1641	finally
    //   526	536	1641	finally
    //   541	556	1641	finally
    //   567	577	1641	finally
    //   585	612	1641	finally
    //   619	632	1641	finally
    //   648	660	1641	finally
    //   667	682	1641	finally
    //   693	706	1641	finally
    //   724	733	1641	finally
    //   745	758	1641	finally
    //   773	785	1641	finally
    //   787	800	1641	finally
    //   815	824	1641	finally
    //   826	839	1641	finally
    //   854	862	1641	finally
    //   864	872	1641	finally
    //   874	887	1641	finally
    //   902	916	1641	finally
    //   918	952	1641	finally
    //   954	971	1641	finally
    //   973	986	1641	finally
    //   997	1010	1641	finally
    //   1025	1034	1641	finally
    //   1044	1057	1641	finally
    //   1072	1084	1641	finally
    //   1086	1099	1641	finally
    //   1115	1124	1641	finally
    //   1126	1139	1641	finally
    //   1155	1163	1641	finally
    //   1165	1173	1641	finally
    //   1175	1188	1641	finally
    //   1202	1251	1641	finally
    //   1275	1290	1641	finally
    //   1304	1318	1641	finally
    //   1320	1337	1641	finally
    //   1349	1364	1641	finally
    //   1376	1390	1641	finally
    //   1392	1409	1641	finally
    //   1481	1514	1645	finally
    //   54	59	1653	java/lang/Throwable
    //   61	74	1653	java/lang/Throwable
    //   117	122	1653	java/lang/Throwable
    //   125	136	1653	java/lang/Throwable
    //   143	155	1653	java/lang/Throwable
    //   310	323	1653	java/lang/Throwable
    //   373	388	1653	java/lang/Throwable
    //   399	412	1653	java/lang/Throwable
    //   427	444	1653	java/lang/Throwable
    //   455	470	1653	java/lang/Throwable
    //   485	498	1653	java/lang/Throwable
    //   1025	1034	1653	java/lang/Throwable
    //   1044	1057	1653	java/lang/Throwable
    //   1072	1084	1653	java/lang/Throwable
    //   1086	1099	1653	java/lang/Throwable
    //   1115	1124	1653	java/lang/Throwable
    //   1126	1139	1653	java/lang/Throwable
    //   1155	1163	1653	java/lang/Throwable
    //   1165	1173	1653	java/lang/Throwable
    //   1175	1188	1653	java/lang/Throwable
    //   1275	1290	1653	java/lang/Throwable
    //   1304	1318	1653	java/lang/Throwable
    //   1320	1337	1653	java/lang/Throwable
    //   513	524	1666	java/lang/Throwable
    //   526	536	1666	java/lang/Throwable
    //   541	556	1666	java/lang/Throwable
    //   567	577	1666	java/lang/Throwable
    //   585	612	1666	java/lang/Throwable
    //   619	632	1666	java/lang/Throwable
    //   648	660	1666	java/lang/Throwable
    //   667	682	1666	java/lang/Throwable
    //   693	706	1666	java/lang/Throwable
    //   724	733	1666	java/lang/Throwable
    //   745	758	1666	java/lang/Throwable
    //   773	785	1666	java/lang/Throwable
    //   787	800	1666	java/lang/Throwable
    //   815	824	1666	java/lang/Throwable
    //   826	839	1666	java/lang/Throwable
    //   854	862	1666	java/lang/Throwable
    //   864	872	1666	java/lang/Throwable
    //   874	887	1666	java/lang/Throwable
    //   902	916	1666	java/lang/Throwable
    //   918	952	1666	java/lang/Throwable
    //   954	971	1666	java/lang/Throwable
    //   973	986	1666	java/lang/Throwable
    //   997	1010	1666	java/lang/Throwable
    //   1349	1364	1666	java/lang/Throwable
    //   1376	1390	1666	java/lang/Throwable
    //   1392	1409	1666	java/lang/Throwable
    //   1202	1251	1683	java/lang/Throwable
  }
  
  /* Error */
  public static int readOrientation(String paramString)
  {
    // Byte code:
    //   0: invokestatic 157	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 6
    //   5: getstatic 61	com/tencent/image/JpegExifReader:sIsReadDpc	Z
    //   8: ifne +24 -> 32
    //   11: getstatic 140	com/tencent/image/JpegExifReader:jpegExifReaderInterface	Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;
    //   14: ifnull +18 -> 32
    //   17: getstatic 140	com/tencent/image/JpegExifReader:jpegExifReaderInterface	Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;
    //   20: invokeinterface 285 1 0
    //   25: putstatic 59	com/tencent/image/JpegExifReader:sIsEnable	Z
    //   28: iconst_1
    //   29: putstatic 61	com/tencent/image/JpegExifReader:sIsReadDpc	Z
    //   32: getstatic 59	com/tencent/image/JpegExifReader:sIsEnable	Z
    //   35: ifne +67 -> 102
    //   38: new 287	android/media/ExifInterface
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 288	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   46: astore_0
    //   47: aload_0
    //   48: ifnonnull +45 -> 93
    //   51: iconst_0
    //   52: istore_3
    //   53: iload_3
    //   54: ireturn
    //   55: astore_0
    //   56: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   59: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   62: invokeinterface 108 1 0
    //   67: ifeq +21 -> 88
    //   70: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   73: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   76: ldc 41
    //   78: iconst_2
    //   79: ldc_w 290
    //   82: aload_0
    //   83: invokeinterface 276 5 0
    //   88: aconst_null
    //   89: astore_0
    //   90: goto -43 -> 47
    //   93: aload_0
    //   94: ldc_w 292
    //   97: iconst_1
    //   98: invokevirtual 296	android/media/ExifInterface:getAttributeInt	(Ljava/lang/String;I)I
    //   101: ireturn
    //   102: aconst_null
    //   103: astore 10
    //   105: iconst_0
    //   106: istore_3
    //   107: ldc_w 265
    //   110: astore 9
    //   112: new 159	java/io/BufferedInputStream
    //   115: dup
    //   116: new 161	java/io/FileInputStream
    //   119: dup
    //   120: aload_0
    //   121: invokespecial 164	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   124: sipush 512
    //   127: invokespecial 167	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   130: astore 12
    //   132: iconst_0
    //   133: istore_2
    //   134: aload 9
    //   136: astore 11
    //   138: iload_3
    //   139: istore_1
    //   140: iconst_2
    //   141: newarray byte
    //   143: astore 14
    //   145: aload 9
    //   147: astore 11
    //   149: iload_3
    //   150: istore_1
    //   151: aload 12
    //   153: aload 14
    //   155: iconst_0
    //   156: iconst_2
    //   157: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   160: iconst_2
    //   161: if_icmpne +33 -> 194
    //   164: aload 14
    //   166: iconst_0
    //   167: baload
    //   168: sipush 255
    //   171: iand
    //   172: sipush 255
    //   175: if_icmpne +247 -> 422
    //   178: aload 14
    //   180: iconst_1
    //   181: baload
    //   182: sipush 255
    //   185: iand
    //   186: sipush 216
    //   189: if_icmpne +233 -> 422
    //   192: iconst_1
    //   193: istore_2
    //   194: iconst_2
    //   195: istore_3
    //   196: aload 9
    //   198: astore 13
    //   200: iload_3
    //   201: istore 4
    //   203: iload_2
    //   204: ifeq +1684 -> 1888
    //   207: aload 9
    //   209: astore 11
    //   211: iload_3
    //   212: istore_1
    //   213: iconst_4
    //   214: newarray byte
    //   216: astore 13
    //   218: iload_3
    //   219: istore_2
    //   220: aload 9
    //   222: astore 11
    //   224: iload_2
    //   225: istore_1
    //   226: aload 12
    //   228: invokevirtual 174	java/io/BufferedInputStream:read	()I
    //   231: sipush 255
    //   234: iand
    //   235: i2b
    //   236: istore_3
    //   237: iload_2
    //   238: iconst_1
    //   239: iadd
    //   240: istore_2
    //   241: aload 9
    //   243: astore 11
    //   245: iload_2
    //   246: istore_1
    //   247: aload 12
    //   249: invokevirtual 174	java/io/BufferedInputStream:read	()I
    //   252: sipush 255
    //   255: iand
    //   256: i2b
    //   257: istore 4
    //   259: iload 4
    //   261: bipush 218
    //   263: if_icmpne +164 -> 427
    //   266: ldc 176
    //   268: astore 9
    //   270: iload_2
    //   271: istore_1
    //   272: iconst_1
    //   273: istore_2
    //   274: aload 9
    //   276: astore 11
    //   278: iload_1
    //   279: istore 4
    //   281: iload_2
    //   282: istore_3
    //   283: aload 12
    //   285: ifnull +1591 -> 1876
    //   288: aload 12
    //   290: invokevirtual 179	java/io/BufferedInputStream:close	()V
    //   293: iload_1
    //   294: istore_3
    //   295: iload_2
    //   296: istore_1
    //   297: iload_3
    //   298: istore_2
    //   299: invokestatic 157	android/os/SystemClock:uptimeMillis	()J
    //   302: lload 6
    //   304: lsub
    //   305: lstore 6
    //   307: getstatic 140	com/tencent/image/JpegExifReader:jpegExifReaderInterface	Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;
    //   310: ifnull +21 -> 331
    //   313: getstatic 140	com/tencent/image/JpegExifReader:jpegExifReaderInterface	Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;
    //   316: aconst_null
    //   317: ldc 34
    //   319: iconst_1
    //   320: lload 6
    //   322: iload_2
    //   323: i2l
    //   324: aconst_null
    //   325: aconst_null
    //   326: invokeinterface 300 10 0
    //   331: iload_1
    //   332: istore_3
    //   333: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   336: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   339: invokeinterface 108 1 0
    //   344: ifeq -291 -> 53
    //   347: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   350: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   353: ldc 41
    //   355: iconst_2
    //   356: new 110	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   363: ldc_w 302
    //   366: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: iload_1
    //   370: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   373: ldc 186
    //   375: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: iload_2
    //   379: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   382: ldc 188
    //   384: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: lload 6
    //   389: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   392: ldc 193
    //   394: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload_0
    //   398: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: ldc_w 304
    //   404: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload 9
    //   409: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokeinterface 198 4 0
    //   420: iload_1
    //   421: ireturn
    //   422: iconst_0
    //   423: istore_2
    //   424: goto -230 -> 194
    //   427: iload_2
    //   428: iconst_1
    //   429: iadd
    //   430: istore_2
    //   431: aload 9
    //   433: astore 11
    //   435: iload_2
    //   436: istore_1
    //   437: aload 12
    //   439: aload 14
    //   441: iconst_0
    //   442: iconst_2
    //   443: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   446: iconst_2
    //   447: if_icmpeq +14 -> 461
    //   450: ldc 200
    //   452: astore 9
    //   454: iload_2
    //   455: istore_1
    //   456: iconst_1
    //   457: istore_2
    //   458: goto -184 -> 274
    //   461: iload_2
    //   462: iconst_2
    //   463: iadd
    //   464: istore_2
    //   465: aload 14
    //   467: iconst_0
    //   468: baload
    //   469: bipush 8
    //   471: ishl
    //   472: ldc 68
    //   474: iand
    //   475: aload 14
    //   477: iconst_1
    //   478: baload
    //   479: sipush 255
    //   482: iand
    //   483: ior
    //   484: iconst_2
    //   485: isub
    //   486: istore 5
    //   488: iload_3
    //   489: iconst_m1
    //   490: if_icmpne +39 -> 529
    //   493: iload 4
    //   495: bipush 224
    //   497: if_icmpne +32 -> 529
    //   500: aload 9
    //   502: astore 11
    //   504: iload_2
    //   505: istore_1
    //   506: aload 12
    //   508: iload 5
    //   510: i2l
    //   511: invokestatic 204	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   514: iload 5
    //   516: i2l
    //   517: lcmp
    //   518: ifne +1391 -> 1909
    //   521: iload_2
    //   522: iload 5
    //   524: iadd
    //   525: istore_2
    //   526: goto -306 -> 220
    //   529: iload_3
    //   530: iconst_m1
    //   531: if_icmpne +1390 -> 1921
    //   534: iload 4
    //   536: bipush 225
    //   538: if_icmpeq +1383 -> 1921
    //   541: iload 4
    //   543: bipush 225
    //   545: if_icmple +121 -> 666
    //   548: iload 4
    //   550: bipush 239
    //   552: if_icmpge +114 -> 666
    //   555: aload 9
    //   557: astore 11
    //   559: iload_2
    //   560: istore_1
    //   561: aload 12
    //   563: iload 5
    //   565: i2l
    //   566: invokestatic 204	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   569: iload 5
    //   571: i2l
    //   572: lcmp
    //   573: ifne +51 -> 624
    //   576: aload 9
    //   578: astore 11
    //   580: iload_2
    //   581: istore_1
    //   582: new 110	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   589: aload 9
    //   591: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: ldc_w 306
    //   597: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: iload 4
    //   602: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   605: ldc_w 308
    //   608: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: astore 9
    //   616: iload_2
    //   617: iload 5
    //   619: iadd
    //   620: istore_2
    //   621: goto -401 -> 220
    //   624: aload 9
    //   626: astore 11
    //   628: iload_2
    //   629: istore_1
    //   630: new 110	java/lang/StringBuilder
    //   633: dup
    //   634: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   637: ldc_w 306
    //   640: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: iload 4
    //   645: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   648: ldc_w 310
    //   651: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   657: astore 9
    //   659: iload_2
    //   660: istore_1
    //   661: iconst_1
    //   662: istore_2
    //   663: goto -389 -> 274
    //   666: aload 9
    //   668: astore 11
    //   670: iload_2
    //   671: istore_1
    //   672: new 110	java/lang/StringBuilder
    //   675: dup
    //   676: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   679: ldc_w 312
    //   682: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: iload 4
    //   687: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   690: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: astore 9
    //   695: iload_2
    //   696: istore_1
    //   697: iconst_1
    //   698: istore_2
    //   699: goto -425 -> 274
    //   702: aload 9
    //   704: astore 11
    //   706: iload_2
    //   707: istore_1
    //   708: aload 12
    //   710: aload 13
    //   712: iconst_0
    //   713: iconst_4
    //   714: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   717: iconst_4
    //   718: if_icmpeq +14 -> 732
    //   721: ldc 206
    //   723: astore 9
    //   725: iload_2
    //   726: istore_1
    //   727: iconst_1
    //   728: istore_2
    //   729: goto -455 -> 274
    //   732: aload 9
    //   734: astore 11
    //   736: iload_2
    //   737: istore_1
    //   738: ldc 22
    //   740: new 208	java/lang/String
    //   743: dup
    //   744: aload 13
    //   746: invokespecial 211	java/lang/String:<init>	([B)V
    //   749: invokevirtual 214	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   752: ifne +14 -> 766
    //   755: ldc 216
    //   757: astore 9
    //   759: iload_2
    //   760: istore_1
    //   761: iconst_1
    //   762: istore_2
    //   763: goto -489 -> 274
    //   766: aload 9
    //   768: astore 11
    //   770: iload_2
    //   771: istore_1
    //   772: aload 12
    //   774: ldc2_w 217
    //   777: invokevirtual 221	java/io/BufferedInputStream:skip	(J)J
    //   780: ldc2_w 217
    //   783: lcmp
    //   784: ifeq +14 -> 798
    //   787: ldc 223
    //   789: astore 9
    //   791: iload_2
    //   792: istore_1
    //   793: iconst_1
    //   794: istore_2
    //   795: goto -521 -> 274
    //   798: iload_2
    //   799: iconst_2
    //   800: iadd
    //   801: istore_2
    //   802: aload 9
    //   804: astore 11
    //   806: iload_2
    //   807: istore_1
    //   808: aload 12
    //   810: aload 14
    //   812: iconst_0
    //   813: iconst_2
    //   814: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   817: iconst_2
    //   818: if_icmpeq +14 -> 832
    //   821: ldc 225
    //   823: astore 9
    //   825: iload_2
    //   826: istore_1
    //   827: iconst_1
    //   828: istore_2
    //   829: goto -555 -> 274
    //   832: iload_2
    //   833: iconst_2
    //   834: iadd
    //   835: istore_2
    //   836: aload 9
    //   838: astore 11
    //   840: iload_2
    //   841: istore_1
    //   842: new 208	java/lang/String
    //   845: dup
    //   846: aload 14
    //   848: invokespecial 211	java/lang/String:<init>	([B)V
    //   851: astore 10
    //   853: aload 9
    //   855: astore 11
    //   857: iload_2
    //   858: istore_1
    //   859: ldc 8
    //   861: aload 10
    //   863: invokevirtual 214	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   866: ifeq +38 -> 904
    //   869: iconst_1
    //   870: istore 8
    //   872: aload 9
    //   874: astore 11
    //   876: iload_2
    //   877: istore_1
    //   878: aload 12
    //   880: ldc2_w 217
    //   883: invokestatic 204	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   886: ldc2_w 217
    //   889: lcmp
    //   890: ifeq +76 -> 966
    //   893: ldc 227
    //   895: astore 9
    //   897: iload_2
    //   898: istore_1
    //   899: iconst_1
    //   900: istore_2
    //   901: goto -627 -> 274
    //   904: aload 9
    //   906: astore 11
    //   908: iload_2
    //   909: istore_1
    //   910: ldc 29
    //   912: aload 10
    //   914: invokevirtual 214	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   917: ifeq +9 -> 926
    //   920: iconst_0
    //   921: istore 8
    //   923: goto -51 -> 872
    //   926: aload 9
    //   928: astore 11
    //   930: iload_2
    //   931: istore_1
    //   932: new 110	java/lang/StringBuilder
    //   935: dup
    //   936: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   939: ldc 229
    //   941: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: aload 10
    //   946: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: ldc 231
    //   951: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   957: astore 9
    //   959: iload_2
    //   960: istore_1
    //   961: iconst_1
    //   962: istore_2
    //   963: goto -689 -> 274
    //   966: aload 9
    //   968: astore 11
    //   970: iload_2
    //   971: istore_1
    //   972: aload 12
    //   974: aload 13
    //   976: iconst_0
    //   977: iconst_4
    //   978: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   981: iconst_4
    //   982: if_icmpeq +14 -> 996
    //   985: ldc 233
    //   987: astore 9
    //   989: iload_2
    //   990: istore_1
    //   991: iconst_1
    //   992: istore_2
    //   993: goto -719 -> 274
    //   996: iload_2
    //   997: bipush 6
    //   999: iadd
    //   1000: istore_2
    //   1001: aload 9
    //   1003: astore 11
    //   1005: iload_2
    //   1006: istore_1
    //   1007: iload 8
    //   1009: aload 13
    //   1011: invokestatic 136	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   1014: bipush 8
    //   1016: isub
    //   1017: istore_3
    //   1018: iload_3
    //   1019: ifle +33 -> 1052
    //   1022: aload 9
    //   1024: astore 11
    //   1026: iload_2
    //   1027: istore_1
    //   1028: aload 12
    //   1030: iload_3
    //   1031: i2l
    //   1032: invokestatic 204	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1035: iload_3
    //   1036: i2l
    //   1037: lcmp
    //   1038: ifeq +14 -> 1052
    //   1041: ldc 235
    //   1043: astore 9
    //   1045: iload_2
    //   1046: istore_1
    //   1047: iconst_1
    //   1048: istore_2
    //   1049: goto -775 -> 274
    //   1052: aload 9
    //   1054: astore 11
    //   1056: iload_2
    //   1057: istore_1
    //   1058: aload 12
    //   1060: aload 14
    //   1062: iconst_0
    //   1063: iconst_2
    //   1064: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   1067: iconst_2
    //   1068: if_icmpeq +14 -> 1082
    //   1071: ldc 237
    //   1073: astore 9
    //   1075: iload_2
    //   1076: istore_1
    //   1077: iconst_1
    //   1078: istore_2
    //   1079: goto -805 -> 274
    //   1082: iload_2
    //   1083: iload_3
    //   1084: iconst_2
    //   1085: iadd
    //   1086: iadd
    //   1087: istore_2
    //   1088: aload 9
    //   1090: astore 11
    //   1092: iload_2
    //   1093: istore_1
    //   1094: iload 8
    //   1096: aload 14
    //   1098: invokestatic 130	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1101: istore 5
    //   1103: iconst_0
    //   1104: istore 4
    //   1106: aload 9
    //   1108: astore 10
    //   1110: iload_2
    //   1111: istore_3
    //   1112: iload 4
    //   1114: iload 5
    //   1116: if_icmpge +206 -> 1322
    //   1119: aload 9
    //   1121: astore 11
    //   1123: iload_2
    //   1124: istore_1
    //   1125: aload 12
    //   1127: aload 14
    //   1129: iconst_0
    //   1130: iconst_2
    //   1131: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   1134: iconst_2
    //   1135: if_icmpeq +15 -> 1150
    //   1138: ldc_w 314
    //   1141: astore 9
    //   1143: iload_2
    //   1144: istore_1
    //   1145: iconst_1
    //   1146: istore_2
    //   1147: goto -873 -> 274
    //   1150: iload_2
    //   1151: iconst_2
    //   1152: iadd
    //   1153: istore_2
    //   1154: aload 9
    //   1156: astore 11
    //   1158: iload_2
    //   1159: istore_1
    //   1160: iload 8
    //   1162: aload 14
    //   1164: invokestatic 130	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1167: sipush 274
    //   1170: if_icmpne +409 -> 1579
    //   1173: aload 9
    //   1175: astore 11
    //   1177: iload_2
    //   1178: istore_1
    //   1179: aload 12
    //   1181: aload 14
    //   1183: iconst_0
    //   1184: iconst_2
    //   1185: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   1188: iconst_2
    //   1189: if_icmpeq +15 -> 1204
    //   1192: ldc_w 316
    //   1195: astore 9
    //   1197: iload_2
    //   1198: istore_1
    //   1199: iconst_1
    //   1200: istore_2
    //   1201: goto -927 -> 274
    //   1204: iload_2
    //   1205: iconst_2
    //   1206: iadd
    //   1207: istore_2
    //   1208: aload 9
    //   1210: astore 11
    //   1212: iload_2
    //   1213: istore_1
    //   1214: iload 8
    //   1216: aload 14
    //   1218: invokestatic 130	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1221: istore 4
    //   1223: aload 9
    //   1225: astore 11
    //   1227: iload_2
    //   1228: istore_1
    //   1229: aload 12
    //   1231: aload 13
    //   1233: iconst_0
    //   1234: iconst_4
    //   1235: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   1238: iconst_4
    //   1239: if_icmpeq +14 -> 1253
    //   1242: ldc 243
    //   1244: astore 9
    //   1246: iload_2
    //   1247: istore_1
    //   1248: iconst_1
    //   1249: istore_2
    //   1250: goto -976 -> 274
    //   1253: iload_2
    //   1254: iconst_4
    //   1255: iadd
    //   1256: istore_3
    //   1257: aload 9
    //   1259: astore 11
    //   1261: iload_3
    //   1262: istore_1
    //   1263: iload 8
    //   1265: aload 13
    //   1267: invokestatic 136	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   1270: getstatic 57	com/tencent/image/JpegExifReader:BYTES_PER_FORMAT	[B
    //   1273: iload 4
    //   1275: baload
    //   1276: imul
    //   1277: istore_2
    //   1278: iload_2
    //   1279: iconst_4
    //   1280: if_icmple +103 -> 1383
    //   1283: aload 9
    //   1285: astore 11
    //   1287: iload_3
    //   1288: istore_1
    //   1289: new 110	java/lang/StringBuilder
    //   1292: dup
    //   1293: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1296: ldc_w 318
    //   1299: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: iload 4
    //   1304: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1307: ldc_w 320
    //   1310: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: iload_2
    //   1314: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1317: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1320: astore 10
    //   1322: aload 10
    //   1324: astore 11
    //   1326: iload_3
    //   1327: istore_1
    //   1328: aload 10
    //   1330: astore 13
    //   1332: iload_3
    //   1333: istore 4
    //   1335: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1338: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1341: invokeinterface 108 1 0
    //   1346: ifeq +542 -> 1888
    //   1349: aload 10
    //   1351: astore 11
    //   1353: iload_3
    //   1354: istore_1
    //   1355: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1358: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1361: ldc 41
    //   1363: iconst_2
    //   1364: ldc_w 273
    //   1367: invokeinterface 198 4 0
    //   1372: aload 10
    //   1374: astore 9
    //   1376: iload_3
    //   1377: istore_1
    //   1378: iconst_1
    //   1379: istore_2
    //   1380: goto -1106 -> 274
    //   1383: aload 9
    //   1385: astore 11
    //   1387: iload_3
    //   1388: istore_1
    //   1389: aload 12
    //   1391: aload 13
    //   1393: iconst_0
    //   1394: iconst_4
    //   1395: invokevirtual 171	java/io/BufferedInputStream:read	([BII)I
    //   1398: iconst_4
    //   1399: if_icmpeq +546 -> 1945
    //   1402: ldc_w 322
    //   1405: astore 9
    //   1407: iload_3
    //   1408: istore_1
    //   1409: iconst_1
    //   1410: istore_2
    //   1411: goto -1137 -> 274
    //   1414: aload 9
    //   1416: astore 11
    //   1418: iload_2
    //   1419: istore_1
    //   1420: new 110	java/lang/StringBuilder
    //   1423: dup
    //   1424: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1427: ldc_w 324
    //   1430: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1433: iload 4
    //   1435: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1438: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1441: astore 9
    //   1443: iconst_1
    //   1444: istore_1
    //   1445: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1448: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1451: invokeinterface 108 1 0
    //   1456: ifeq +444 -> 1900
    //   1459: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1462: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1465: ldc 41
    //   1467: iconst_2
    //   1468: new 110	java/lang/StringBuilder
    //   1471: dup
    //   1472: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1475: ldc_w 326
    //   1478: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1481: iload_1
    //   1482: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1485: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1488: invokeinterface 198 4 0
    //   1493: iload_1
    //   1494: istore_3
    //   1495: iload_2
    //   1496: istore_1
    //   1497: iload_3
    //   1498: istore_2
    //   1499: goto -1225 -> 274
    //   1502: aload 9
    //   1504: astore 11
    //   1506: iload_2
    //   1507: istore_1
    //   1508: iload 8
    //   1510: aload 13
    //   1512: invokestatic 130	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1515: istore_3
    //   1516: iload_3
    //   1517: istore_1
    //   1518: goto -73 -> 1445
    //   1521: aload 9
    //   1523: astore 11
    //   1525: iload_2
    //   1526: istore_1
    //   1527: iload 8
    //   1529: aload 13
    //   1531: invokestatic 132	com/tencent/image/JpegExifReader:getUnsignedInt32	(Z[B)J
    //   1534: l2i
    //   1535: istore_3
    //   1536: iload_3
    //   1537: istore_1
    //   1538: goto -93 -> 1445
    //   1541: aload 9
    //   1543: astore 11
    //   1545: iload_2
    //   1546: istore_1
    //   1547: iload 8
    //   1549: aload 13
    //   1551: invokestatic 134	com/tencent/image/JpegExifReader:getInt16	(Z[B)S
    //   1554: istore_3
    //   1555: iload_3
    //   1556: istore_1
    //   1557: goto -112 -> 1445
    //   1560: aload 9
    //   1562: astore 11
    //   1564: iload_2
    //   1565: istore_1
    //   1566: iload 8
    //   1568: aload 13
    //   1570: invokestatic 136	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   1573: istore_3
    //   1574: iload_3
    //   1575: istore_1
    //   1576: goto -131 -> 1445
    //   1579: aload 9
    //   1581: astore 11
    //   1583: iload_2
    //   1584: istore_1
    //   1585: aload 12
    //   1587: ldc2_w 266
    //   1590: invokestatic 204	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1593: ldc2_w 266
    //   1596: lcmp
    //   1597: ifeq +15 -> 1612
    //   1600: ldc_w 269
    //   1603: astore 9
    //   1605: iload_2
    //   1606: istore_1
    //   1607: iconst_1
    //   1608: istore_2
    //   1609: goto -1335 -> 274
    //   1612: iload_2
    //   1613: bipush 10
    //   1615: iadd
    //   1616: istore_2
    //   1617: iload 4
    //   1619: iconst_1
    //   1620: iadd
    //   1621: istore 4
    //   1623: goto -517 -> 1106
    //   1626: astore 10
    //   1628: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1631: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1634: invokeinterface 108 1 0
    //   1639: ifeq +22 -> 1661
    //   1642: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1645: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1648: ldc 41
    //   1650: iconst_2
    //   1651: ldc_w 265
    //   1654: aload 10
    //   1656: invokeinterface 276 5 0
    //   1661: iload_2
    //   1662: istore_3
    //   1663: iload_1
    //   1664: istore_2
    //   1665: iload_3
    //   1666: istore_1
    //   1667: goto -1368 -> 299
    //   1670: astore 11
    //   1672: ldc_w 265
    //   1675: astore 9
    //   1677: iconst_0
    //   1678: istore_2
    //   1679: iconst_1
    //   1680: istore_1
    //   1681: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1684: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1687: invokeinterface 108 1 0
    //   1692: ifeq +22 -> 1714
    //   1695: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1698: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1701: ldc 41
    //   1703: iconst_2
    //   1704: ldc_w 265
    //   1707: aload 11
    //   1709: invokeinterface 276 5 0
    //   1714: aload 9
    //   1716: astore 11
    //   1718: iload_2
    //   1719: istore 4
    //   1721: iload_1
    //   1722: istore_3
    //   1723: aload 10
    //   1725: ifnull +151 -> 1876
    //   1728: aload 10
    //   1730: invokevirtual 179	java/io/BufferedInputStream:close	()V
    //   1733: goto -1434 -> 299
    //   1736: astore 10
    //   1738: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1741: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1744: invokeinterface 108 1 0
    //   1749: ifeq +22 -> 1771
    //   1752: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1755: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1758: ldc 41
    //   1760: iconst_2
    //   1761: ldc_w 265
    //   1764: aload 10
    //   1766: invokeinterface 276 5 0
    //   1771: goto -1472 -> 299
    //   1774: astore_0
    //   1775: aconst_null
    //   1776: astore 12
    //   1778: aload 12
    //   1780: ifnull +8 -> 1788
    //   1783: aload 12
    //   1785: invokevirtual 179	java/io/BufferedInputStream:close	()V
    //   1788: aload_0
    //   1789: athrow
    //   1790: astore 9
    //   1792: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1795: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1798: invokeinterface 108 1 0
    //   1803: ifeq -15 -> 1788
    //   1806: getstatic 96	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1809: getfield 102	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1812: ldc 41
    //   1814: iconst_2
    //   1815: ldc_w 265
    //   1818: aload 9
    //   1820: invokeinterface 276 5 0
    //   1825: goto -37 -> 1788
    //   1828: astore_0
    //   1829: goto -51 -> 1778
    //   1832: astore_0
    //   1833: aload 10
    //   1835: astore 12
    //   1837: goto -59 -> 1778
    //   1840: astore 9
    //   1842: aload 12
    //   1844: astore 10
    //   1846: aload 9
    //   1848: astore 12
    //   1850: aload 11
    //   1852: astore 9
    //   1854: iconst_1
    //   1855: istore_3
    //   1856: iload_1
    //   1857: istore_2
    //   1858: iload_3
    //   1859: istore_1
    //   1860: aload 12
    //   1862: astore 11
    //   1864: goto -183 -> 1681
    //   1867: astore 11
    //   1869: aload 12
    //   1871: astore 10
    //   1873: goto -192 -> 1681
    //   1876: aload 11
    //   1878: astore 9
    //   1880: iload 4
    //   1882: istore_2
    //   1883: iload_3
    //   1884: istore_1
    //   1885: goto -1586 -> 299
    //   1888: aload 13
    //   1890: astore 9
    //   1892: iload 4
    //   1894: istore_1
    //   1895: iconst_1
    //   1896: istore_2
    //   1897: goto -1623 -> 274
    //   1900: iload_1
    //   1901: istore_3
    //   1902: iload_2
    //   1903: istore_1
    //   1904: iload_3
    //   1905: istore_2
    //   1906: goto -1632 -> 274
    //   1909: ldc_w 278
    //   1912: astore 9
    //   1914: iload_2
    //   1915: istore_1
    //   1916: iconst_1
    //   1917: istore_2
    //   1918: goto -1644 -> 274
    //   1921: iload_3
    //   1922: iconst_m1
    //   1923: if_icmpne +10 -> 1933
    //   1926: iload 4
    //   1928: bipush 225
    //   1930: if_icmpeq -1228 -> 702
    //   1933: ldc_w 280
    //   1936: astore 9
    //   1938: iload_2
    //   1939: istore_1
    //   1940: iconst_1
    //   1941: istore_2
    //   1942: goto -1668 -> 274
    //   1945: iload_3
    //   1946: iconst_4
    //   1947: iadd
    //   1948: istore_2
    //   1949: iload 4
    //   1951: tableswitch	default:+41 -> 1992, 3:+-449->1502, 4:+-430->1521, 5:+-537->1414, 6:+44->1995, 7:+-537->1414, 8:+-410->1541, 9:+-391->1560
    //   1993: <illegal opcode>
    //   1994: arraylength
    //   1995: aload 13
    //   1997: iconst_0
    //   1998: baload
    //   1999: istore_1
    //   2000: goto -555 -> 1445
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2003	0	paramString	String
    //   139	1861	1	i	int
    //   133	1816	2	j	int
    //   52	1896	3	k	int
    //   201	1749	4	m	int
    //   486	631	5	n	int
    //   3	385	6	l	long
    //   870	697	8	bool	boolean
    //   110	1605	9	localObject1	Object
    //   1790	29	9	localIOException1	IOException
    //   1840	7	9	localThrowable1	java.lang.Throwable
    //   1852	85	9	localObject2	Object
    //   103	1270	10	localObject3	Object
    //   1626	103	10	localIOException2	IOException
    //   1736	98	10	localIOException3	IOException
    //   1844	28	10	localObject4	Object
    //   136	1446	11	localObject5	Object
    //   1670	38	11	localThrowable2	java.lang.Throwable
    //   1716	147	11	localObject6	Object
    //   1867	10	11	localThrowable3	java.lang.Throwable
    //   130	1740	12	localObject7	Object
    //   198	1798	13	localObject8	Object
    //   143	1074	14	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   38	47	55	java/io/IOException
    //   288	293	1626	java/io/IOException
    //   112	132	1670	java/lang/Throwable
    //   1728	1733	1736	java/io/IOException
    //   112	132	1774	finally
    //   1783	1788	1790	java/io/IOException
    //   140	145	1828	finally
    //   151	164	1828	finally
    //   213	218	1828	finally
    //   226	237	1828	finally
    //   247	259	1828	finally
    //   437	450	1828	finally
    //   506	521	1828	finally
    //   561	576	1828	finally
    //   582	616	1828	finally
    //   630	659	1828	finally
    //   672	695	1828	finally
    //   708	721	1828	finally
    //   738	755	1828	finally
    //   772	787	1828	finally
    //   808	821	1828	finally
    //   842	853	1828	finally
    //   859	869	1828	finally
    //   878	893	1828	finally
    //   910	920	1828	finally
    //   932	959	1828	finally
    //   972	985	1828	finally
    //   1007	1018	1828	finally
    //   1028	1041	1828	finally
    //   1058	1071	1828	finally
    //   1094	1103	1828	finally
    //   1125	1138	1828	finally
    //   1160	1173	1828	finally
    //   1179	1192	1828	finally
    //   1214	1223	1828	finally
    //   1229	1242	1828	finally
    //   1263	1278	1828	finally
    //   1289	1322	1828	finally
    //   1335	1349	1828	finally
    //   1355	1372	1828	finally
    //   1389	1402	1828	finally
    //   1420	1443	1828	finally
    //   1445	1493	1828	finally
    //   1508	1516	1828	finally
    //   1527	1536	1828	finally
    //   1547	1555	1828	finally
    //   1566	1574	1828	finally
    //   1585	1600	1828	finally
    //   1681	1714	1832	finally
    //   140	145	1840	java/lang/Throwable
    //   151	164	1840	java/lang/Throwable
    //   213	218	1840	java/lang/Throwable
    //   226	237	1840	java/lang/Throwable
    //   247	259	1840	java/lang/Throwable
    //   437	450	1840	java/lang/Throwable
    //   506	521	1840	java/lang/Throwable
    //   561	576	1840	java/lang/Throwable
    //   582	616	1840	java/lang/Throwable
    //   630	659	1840	java/lang/Throwable
    //   672	695	1840	java/lang/Throwable
    //   708	721	1840	java/lang/Throwable
    //   738	755	1840	java/lang/Throwable
    //   772	787	1840	java/lang/Throwable
    //   808	821	1840	java/lang/Throwable
    //   842	853	1840	java/lang/Throwable
    //   859	869	1840	java/lang/Throwable
    //   878	893	1840	java/lang/Throwable
    //   910	920	1840	java/lang/Throwable
    //   932	959	1840	java/lang/Throwable
    //   972	985	1840	java/lang/Throwable
    //   1007	1018	1840	java/lang/Throwable
    //   1028	1041	1840	java/lang/Throwable
    //   1058	1071	1840	java/lang/Throwable
    //   1094	1103	1840	java/lang/Throwable
    //   1125	1138	1840	java/lang/Throwable
    //   1160	1173	1840	java/lang/Throwable
    //   1179	1192	1840	java/lang/Throwable
    //   1214	1223	1840	java/lang/Throwable
    //   1229	1242	1840	java/lang/Throwable
    //   1263	1278	1840	java/lang/Throwable
    //   1289	1322	1840	java/lang/Throwable
    //   1335	1349	1840	java/lang/Throwable
    //   1355	1372	1840	java/lang/Throwable
    //   1389	1402	1840	java/lang/Throwable
    //   1420	1443	1840	java/lang/Throwable
    //   1508	1516	1840	java/lang/Throwable
    //   1527	1536	1840	java/lang/Throwable
    //   1547	1555	1840	java/lang/Throwable
    //   1566	1574	1840	java/lang/Throwable
    //   1585	1600	1840	java/lang/Throwable
    //   1445	1493	1867	java/lang/Throwable
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