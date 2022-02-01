package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipInputStream;

public class ZipUtil
{
  private static final int A = 4096;
  private static final String B = "../";
  private static final String C = "..\\";
  private static final String TAG = "ZipUtil";
  private static final int y = 104857600;
  private static final int z = 100;
  
  /* Error */
  @android.annotation.SuppressLint({"NewApi"})
  private static List<File> a(File paramFile1, File paramFile2, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: aconst_null
    //   4: astore 12
    //   6: aload_0
    //   7: ifnull +653 -> 660
    //   10: aload_1
    //   11: ifnonnull +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: iconst_1
    //   17: istore 6
    //   19: iconst_1
    //   20: istore 7
    //   22: iconst_1
    //   23: istore 5
    //   25: new 37	java/util/ArrayList
    //   28: dup
    //   29: invokespecial 38	java/util/ArrayList:<init>	()V
    //   32: astore 15
    //   34: new 40	java/util/zip/ZipFile
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 43	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   42: astore 11
    //   44: aload 11
    //   46: invokevirtual 47	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   49: astore 16
    //   51: iconst_0
    //   52: istore 8
    //   54: iload 5
    //   56: istore 6
    //   58: aload 16
    //   60: invokeinterface 53 1 0
    //   65: istore 10
    //   67: iload 5
    //   69: istore 6
    //   71: iload 10
    //   73: ifeq +465 -> 538
    //   76: iload 5
    //   78: istore 6
    //   80: aload 16
    //   82: invokeinterface 57 1 0
    //   87: checkcast 59	java/util/zip/ZipEntry
    //   90: astore_0
    //   91: iload 5
    //   93: istore 6
    //   95: aload_0
    //   96: invokevirtual 63	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   99: astore 13
    //   101: iload 5
    //   103: istore 6
    //   105: aload 13
    //   107: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifeq +6 -> 116
    //   113: goto -59 -> 54
    //   116: iload 5
    //   118: istore 6
    //   120: aload 13
    //   122: getstatic 75	java/text/Normalizer$Form:NFKC	Ljava/text/Normalizer$Form;
    //   125: invokestatic 81	java/text/Normalizer:normalize	(Ljava/lang/CharSequence;Ljava/text/Normalizer$Form;)Ljava/lang/String;
    //   128: astore 13
    //   130: iload 5
    //   132: istore 6
    //   134: aload 13
    //   136: invokestatic 85	com/huawei/secure/android/common/util/ZipUtil:h	(Ljava/lang/String;)Z
    //   139: ifeq +60 -> 199
    //   142: iload 5
    //   144: istore 6
    //   146: new 87	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   153: astore_0
    //   154: iload 5
    //   156: istore 6
    //   158: aload_0
    //   159: ldc 90
    //   161: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: iload 5
    //   167: istore 6
    //   169: aload_0
    //   170: aload 13
    //   172: invokestatic 98	com/huawei/secure/android/common/util/ZipUtil:d	(Ljava/lang/String;)Ljava/lang/String;
    //   175: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: iload 5
    //   181: istore 6
    //   183: ldc 17
    //   185: aload_0
    //   186: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 107	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   192: pop
    //   193: iconst_0
    //   194: istore 6
    //   196: goto +342 -> 538
    //   199: iload 5
    //   201: istore 6
    //   203: new 109	java/io/File
    //   206: dup
    //   207: aload_1
    //   208: aload 13
    //   210: ldc 111
    //   212: ldc 113
    //   214: invokevirtual 119	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   217: invokespecial 122	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   220: astore 14
    //   222: iload 4
    //   224: ifeq +36 -> 260
    //   227: iload 5
    //   229: istore 6
    //   231: aload 14
    //   233: invokevirtual 125	java/io/File:exists	()Z
    //   236: ifeq +24 -> 260
    //   239: iload 5
    //   241: istore 6
    //   243: aload 14
    //   245: invokevirtual 128	java/io/File:isFile	()Z
    //   248: ifeq +12 -> 260
    //   251: iload 5
    //   253: istore 6
    //   255: aload 14
    //   257: invokestatic 131	com/huawei/secure/android/common/util/ZipUtil:c	(Ljava/io/File;)V
    //   260: iload 5
    //   262: istore 6
    //   264: aload 15
    //   266: aload 14
    //   268: invokeinterface 137 2 0
    //   273: pop
    //   274: iload 5
    //   276: istore 6
    //   278: aload_0
    //   279: invokevirtual 140	java/util/zip/ZipEntry:isDirectory	()Z
    //   282: ifeq +32 -> 314
    //   285: iload 5
    //   287: istore 6
    //   289: aload 14
    //   291: invokestatic 144	com/huawei/secure/android/common/util/ZipUtil:b	(Ljava/io/File;)Z
    //   294: istore 10
    //   296: iload 10
    //   298: ifne -244 -> 54
    //   301: aload 11
    //   303: invokestatic 150	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/Closeable;)V
    //   306: aload 15
    //   308: invokestatic 153	com/huawei/secure/android/common/util/ZipUtil:a	(Ljava/util/List;)Z
    //   311: pop
    //   312: aconst_null
    //   313: areturn
    //   314: iload 5
    //   316: istore 6
    //   318: aload 14
    //   320: invokestatic 155	com/huawei/secure/android/common/util/ZipUtil:a	(Ljava/io/File;)Z
    //   323: istore 10
    //   325: iload 10
    //   327: ifne +16 -> 343
    //   330: aload 11
    //   332: invokestatic 150	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/Closeable;)V
    //   335: aload 15
    //   337: invokestatic 153	com/huawei/secure/android/common/util/ZipUtil:a	(Ljava/util/List;)Z
    //   340: pop
    //   341: aconst_null
    //   342: areturn
    //   343: new 157	java/io/BufferedInputStream
    //   346: dup
    //   347: aload 11
    //   349: aload_0
    //   350: invokevirtual 161	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   353: invokespecial 164	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   356: astore 13
    //   358: new 166	java/io/FileOutputStream
    //   361: dup
    //   362: aload 14
    //   364: invokespecial 167	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   367: astore 14
    //   369: new 169	java/io/BufferedOutputStream
    //   372: dup
    //   373: aload 14
    //   375: invokespecial 172	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   378: astore_0
    //   379: sipush 1024
    //   382: newarray byte
    //   384: astore 17
    //   386: iload 8
    //   388: istore 6
    //   390: aload 13
    //   392: aload 17
    //   394: invokevirtual 178	java/io/InputStream:read	([B)I
    //   397: istore 9
    //   399: iload 5
    //   401: istore 7
    //   403: iload 6
    //   405: istore 8
    //   407: iload 9
    //   409: iconst_m1
    //   410: if_icmpeq +48 -> 458
    //   413: iload 6
    //   415: iload 9
    //   417: iadd
    //   418: istore 6
    //   420: iload 6
    //   422: i2l
    //   423: lload_2
    //   424: lcmp
    //   425: ifle +21 -> 446
    //   428: ldc 17
    //   430: ldc 180
    //   432: invokestatic 107	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   435: pop
    //   436: iconst_0
    //   437: istore 7
    //   439: iload 6
    //   441: istore 8
    //   443: goto +15 -> 458
    //   446: aload_0
    //   447: aload 17
    //   449: iconst_0
    //   450: iload 9
    //   452: invokevirtual 186	java/io/OutputStream:write	([BII)V
    //   455: goto -65 -> 390
    //   458: iload 7
    //   460: istore 6
    //   462: aload 13
    //   464: invokestatic 188	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/InputStream;)V
    //   467: iload 7
    //   469: istore 6
    //   471: aload_0
    //   472: invokestatic 190	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/OutputStream;)V
    //   475: iload 7
    //   477: istore 6
    //   479: aload 14
    //   481: invokestatic 190	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/OutputStream;)V
    //   484: iload 7
    //   486: istore 5
    //   488: goto -434 -> 54
    //   491: iload 5
    //   493: istore 6
    //   495: aload 13
    //   497: invokestatic 188	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/InputStream;)V
    //   500: iload 5
    //   502: istore 6
    //   504: aload 12
    //   506: invokestatic 190	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/OutputStream;)V
    //   509: iload 5
    //   511: istore 6
    //   513: aload_1
    //   514: invokestatic 190	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/OutputStream;)V
    //   517: iload 5
    //   519: istore 6
    //   521: aload_0
    //   522: athrow
    //   523: iload 5
    //   525: istore 6
    //   527: ldc 17
    //   529: ldc 192
    //   531: invokestatic 107	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   534: pop
    //   535: goto -481 -> 54
    //   538: aload 11
    //   540: invokestatic 150	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/Closeable;)V
    //   543: iload 6
    //   545: ifne +85 -> 630
    //   548: aload 15
    //   550: invokestatic 153	com/huawei/secure/android/common/util/ZipUtil:a	(Ljava/util/List;)Z
    //   553: pop
    //   554: aload 15
    //   556: areturn
    //   557: astore_0
    //   558: aload 11
    //   560: astore_1
    //   561: goto +82 -> 643
    //   564: astore_1
    //   565: aload 11
    //   567: astore_0
    //   568: goto +17 -> 585
    //   571: astore_0
    //   572: aconst_null
    //   573: astore_1
    //   574: iload 7
    //   576: istore 6
    //   578: goto +65 -> 643
    //   581: astore_1
    //   582: aload 13
    //   584: astore_0
    //   585: new 87	java/lang/StringBuilder
    //   588: dup
    //   589: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   592: astore 11
    //   594: aload 11
    //   596: ldc 194
    //   598: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload 11
    //   604: aload_1
    //   605: invokevirtual 197	java/io/IOException:getMessage	()Ljava/lang/String;
    //   608: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: ldc 17
    //   614: aload 11
    //   616: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   619: invokestatic 107	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   622: pop
    //   623: aload_0
    //   624: invokestatic 150	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/Closeable;)V
    //   627: goto -79 -> 548
    //   630: aload 15
    //   632: areturn
    //   633: astore 11
    //   635: iconst_0
    //   636: istore 6
    //   638: aload_0
    //   639: astore_1
    //   640: aload 11
    //   642: astore_0
    //   643: aload_1
    //   644: invokestatic 150	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/Closeable;)V
    //   647: iload 6
    //   649: ifne +9 -> 658
    //   652: aload 15
    //   654: invokestatic 153	com/huawei/secure/android/common/util/ZipUtil:a	(Ljava/util/List;)Z
    //   657: pop
    //   658: aload_0
    //   659: athrow
    //   660: aconst_null
    //   661: areturn
    //   662: astore_0
    //   663: goto -140 -> 523
    //   666: astore_1
    //   667: aload_0
    //   668: astore 12
    //   670: aload_1
    //   671: astore_0
    //   672: aload 14
    //   674: astore_1
    //   675: goto -184 -> 491
    //   678: astore_0
    //   679: aload 14
    //   681: astore_1
    //   682: goto -191 -> 491
    //   685: astore_0
    //   686: aconst_null
    //   687: astore_1
    //   688: goto -197 -> 491
    //   691: astore_0
    //   692: aconst_null
    //   693: astore_1
    //   694: aload_1
    //   695: astore 13
    //   697: goto -206 -> 491
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	700	0	paramFile1	File
    //   0	700	1	paramFile2	File
    //   0	700	2	paramLong	long
    //   0	700	4	paramBoolean	boolean
    //   23	501	5	i	int
    //   17	631	6	j	int
    //   20	555	7	k	int
    //   52	390	8	m	int
    //   397	54	9	n	int
    //   65	261	10	bool	boolean
    //   42	573	11	localObject1	Object
    //   633	8	11	localObject2	Object
    //   4	665	12	localObject3	Object
    //   1	695	13	localObject4	Object
    //   220	460	14	localObject5	Object
    //   32	621	15	localArrayList	java.util.ArrayList
    //   49	32	16	localEnumeration	java.util.Enumeration
    //   384	64	17	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   44	51	557	finally
    //   58	67	557	finally
    //   80	91	557	finally
    //   95	101	557	finally
    //   105	113	557	finally
    //   120	130	557	finally
    //   134	142	557	finally
    //   146	154	557	finally
    //   158	165	557	finally
    //   169	179	557	finally
    //   183	193	557	finally
    //   203	222	557	finally
    //   231	239	557	finally
    //   243	251	557	finally
    //   255	260	557	finally
    //   264	274	557	finally
    //   278	285	557	finally
    //   289	296	557	finally
    //   318	325	557	finally
    //   462	467	557	finally
    //   471	475	557	finally
    //   479	484	557	finally
    //   495	500	557	finally
    //   504	509	557	finally
    //   513	517	557	finally
    //   521	523	557	finally
    //   527	535	557	finally
    //   44	51	564	java/io/IOException
    //   58	67	564	java/io/IOException
    //   80	91	564	java/io/IOException
    //   95	101	564	java/io/IOException
    //   105	113	564	java/io/IOException
    //   120	130	564	java/io/IOException
    //   134	142	564	java/io/IOException
    //   146	154	564	java/io/IOException
    //   158	165	564	java/io/IOException
    //   169	179	564	java/io/IOException
    //   183	193	564	java/io/IOException
    //   203	222	564	java/io/IOException
    //   231	239	564	java/io/IOException
    //   243	251	564	java/io/IOException
    //   255	260	564	java/io/IOException
    //   264	274	564	java/io/IOException
    //   278	285	564	java/io/IOException
    //   289	296	564	java/io/IOException
    //   318	325	564	java/io/IOException
    //   462	467	564	java/io/IOException
    //   471	475	564	java/io/IOException
    //   479	484	564	java/io/IOException
    //   495	500	564	java/io/IOException
    //   504	509	564	java/io/IOException
    //   513	517	564	java/io/IOException
    //   521	523	564	java/io/IOException
    //   527	535	564	java/io/IOException
    //   34	44	571	finally
    //   34	44	581	java/io/IOException
    //   585	623	633	finally
    //   80	91	662	java/lang/IllegalArgumentException
    //   379	386	666	finally
    //   390	399	666	finally
    //   428	436	666	finally
    //   446	455	666	finally
    //   369	379	678	finally
    //   358	369	685	finally
    //   343	358	691	finally
  }
  
  private static void a(FileInputStream paramFileInputStream, BufferedOutputStream paramBufferedOutputStream, ZipInputStream paramZipInputStream, FileOutputStream paramFileOutputStream)
  {
    IOUtil.closeSecure(paramFileInputStream);
    IOUtil.closeSecure(paramBufferedOutputStream);
    IOUtil.closeSecure(paramZipInputStream);
    IOUtil.closeSecure(paramFileOutputStream);
  }
  
  private static boolean a(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    if (paramFile.exists()) {
      return paramFile.isFile();
    }
    if (!b(paramFile.getParentFile())) {
      return false;
    }
    try
    {
      boolean bool = paramFile.createNewFile();
      return bool;
    }
    catch (IOException paramFile)
    {
      label37:
      break label37;
    }
    Log.e("ZipUtil", "createOrExistsFile IOException ");
    return false;
  }
  
  /* Error */
  private static boolean a(String paramString, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: iconst_0
    //   4: istore 7
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 9
    //   12: new 40	java/util/zip/ZipFile
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 214	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   20: astore_0
    //   21: aload_0
    //   22: invokevirtual 47	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   25: astore 9
    //   27: lconst_0
    //   28: lstore 5
    //   30: iconst_0
    //   31: istore 4
    //   33: aload 9
    //   35: invokeinterface 53 1 0
    //   40: ifeq +77 -> 117
    //   43: aload 9
    //   45: invokeinterface 57 1 0
    //   50: checkcast 59	java/util/zip/ZipEntry
    //   53: astore 10
    //   55: lload 5
    //   57: aload 10
    //   59: invokevirtual 218	java/util/zip/ZipEntry:getSize	()J
    //   62: ladd
    //   63: lstore 5
    //   65: iload 4
    //   67: iconst_1
    //   68: iadd
    //   69: istore 4
    //   71: aload 10
    //   73: invokevirtual 63	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   76: invokestatic 85	com/huawei/secure/android/common/util/ZipUtil:h	(Ljava/lang/String;)Z
    //   79: ifne +28 -> 107
    //   82: iload 4
    //   84: iload_3
    //   85: if_icmpge +22 -> 107
    //   88: lload 5
    //   90: lload_1
    //   91: lcmp
    //   92: ifgt +15 -> 107
    //   95: aload 10
    //   97: invokevirtual 218	java/util/zip/ZipEntry:getSize	()J
    //   100: ldc2_w 219
    //   103: lcmp
    //   104: ifne -71 -> 33
    //   107: ldc 17
    //   109: ldc 222
    //   111: invokestatic 227	com/huawei/secure/android/common/util/LogsUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: goto +6 -> 120
    //   117: iconst_1
    //   118: istore 7
    //   120: iload 7
    //   122: istore 8
    //   124: aload_0
    //   125: invokevirtual 230	java/util/zip/ZipFile:close	()V
    //   128: iload 7
    //   130: ireturn
    //   131: ldc 17
    //   133: ldc 232
    //   135: invokestatic 227	com/huawei/secure/android/common/util/LogsUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: iload 8
    //   140: ireturn
    //   141: astore 10
    //   143: aload_0
    //   144: astore 9
    //   146: aload 10
    //   148: astore_0
    //   149: goto +77 -> 226
    //   152: astore 10
    //   154: goto +12 -> 166
    //   157: astore_0
    //   158: goto +68 -> 226
    //   161: astore 10
    //   163: aload 11
    //   165: astore_0
    //   166: aload_0
    //   167: astore 9
    //   169: new 87	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   176: astore 11
    //   178: aload_0
    //   179: astore 9
    //   181: aload 11
    //   183: ldc 234
    //   185: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload_0
    //   190: astore 9
    //   192: aload 11
    //   194: aload 10
    //   196: invokevirtual 197	java/io/IOException:getMessage	()Ljava/lang/String;
    //   199: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload_0
    //   204: astore 9
    //   206: ldc 17
    //   208: aload 11
    //   210: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 227	com/huawei/secure/android/common/util/LogsUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload_0
    //   217: ifnull +7 -> 224
    //   220: aload_0
    //   221: invokevirtual 230	java/util/zip/ZipFile:close	()V
    //   224: iconst_0
    //   225: ireturn
    //   226: aload 9
    //   228: ifnull +18 -> 246
    //   231: aload 9
    //   233: invokevirtual 230	java/util/zip/ZipFile:close	()V
    //   236: goto +10 -> 246
    //   239: ldc 17
    //   241: ldc 232
    //   243: invokestatic 227	com/huawei/secure/android/common/util/LogsUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   246: goto +5 -> 251
    //   249: aload_0
    //   250: athrow
    //   251: goto -2 -> 249
    //   254: astore_0
    //   255: goto -124 -> 131
    //   258: astore 9
    //   260: goto -21 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramString	String
    //   0	263	1	paramLong	long
    //   0	263	3	paramInt	int
    //   31	55	4	i	int
    //   28	61	5	l	long
    //   4	125	7	bool1	boolean
    //   1	138	8	bool2	boolean
    //   10	222	9	localObject1	Object
    //   258	1	9	localIOException1	IOException
    //   53	43	10	localZipEntry	java.util.zip.ZipEntry
    //   141	6	10	localObject2	Object
    //   152	1	10	localIOException2	IOException
    //   161	34	10	localIOException3	IOException
    //   7	202	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   21	27	141	finally
    //   33	65	141	finally
    //   71	82	141	finally
    //   95	107	141	finally
    //   107	114	141	finally
    //   21	27	152	java/io/IOException
    //   33	65	152	java/io/IOException
    //   71	82	152	java/io/IOException
    //   95	107	152	java/io/IOException
    //   107	114	152	java/io/IOException
    //   12	21	157	finally
    //   169	178	157	finally
    //   181	189	157	finally
    //   192	203	157	finally
    //   206	216	157	finally
    //   12	21	161	java/io/IOException
    //   124	128	254	java/io/IOException
    //   220	224	254	java/io/IOException
    //   231	236	258	java/io/IOException
  }
  
  private static boolean a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!h(paramString1)))
    {
      if ((!TextUtils.isEmpty(paramString2)) && (!h(paramString2)))
      {
        if (a(paramString1, paramLong, paramInt)) {
          return true;
        }
        LogsUtil.e("ZipUtil", "zip file contains valid chars or too many files");
        throw new SecurityCommonException("unsecure zipfile!");
      }
      LogsUtil.e("ZipUtil", "target directory is not valid");
      return false;
    }
    LogsUtil.e("ZipUtil", "zip file is not valid");
    return false;
  }
  
  private static boolean a(List<File> paramList)
  {
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        c((File)paramList.next());
      }
      return true;
    }
    catch (Exception paramList)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unzip fail delete file failed");
      localStringBuilder.append(paramList.getMessage());
      LogsUtil.e("ZipUtil", localStringBuilder.toString());
    }
    return false;
  }
  
  private static boolean b(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists() ? paramFile.isDirectory() : paramFile.mkdirs());
  }
  
  private static void c(File paramFile)
  {
    if (paramFile == null) {
      return;
    }
    if (paramFile.isFile())
    {
      d(paramFile);
      return;
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length != 0))
      {
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          c(arrayOfFile[i]);
          i += 1;
        }
        d(paramFile);
        return;
      }
      d(paramFile);
    }
  }
  
  private static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    int i = paramString.lastIndexOf(File.separator);
    if (i == -1) {
      return paramString;
    }
    return paramString.substring(i + 1);
  }
  
  private static void d(File paramFile)
  {
    if (paramFile == null) {
      return;
    }
    if (!paramFile.delete()) {
      LogsUtil.e("ZipUtil", "delete file error");
    }
  }
  
  private static void e(File paramFile)
  {
    if (paramFile != null)
    {
      if (paramFile.exists()) {
        return;
      }
      if (!paramFile.mkdirs()) {
        LogsUtil.e("ZipUtil", "mkdirs error , files exists or IOException.");
      }
    }
  }
  
  private static void e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!h(paramString)) {
        return;
      }
      Log.e("ZipUtil", "IllegalArgumentException--path is not a standard path");
      throw new IllegalArgumentException("path is not a standard path");
    }
  }
  
  private static File f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return g(paramString);
  }
  
  private static File g(String paramString)
  {
    e(paramString);
    return new File(paramString);
  }
  
  private static boolean h(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = true;
    if (bool1)
    {
      Log.e("ZipUtil", "isContainInvalidStr: name is null");
      return true;
    }
    bool1 = bool2;
    if (!paramString.contains("../"))
    {
      bool1 = bool2;
      if (!paramString.contains("..\\"))
      {
        bool1 = bool2;
        if (!paramString.contains(".."))
        {
          bool1 = bool2;
          if (!paramString.contains("./"))
          {
            bool1 = bool2;
            if (!paramString.contains(".\\.\\"))
            {
              if (paramString.contains("%00")) {
                return true;
              }
              bool1 = false;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  /* Error */
  @Deprecated
  public static boolean unZip(String paramString1, String paramString2, long paramLong, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 11
    //   3: aload_0
    //   4: aload_1
    //   5: lload_2
    //   6: iload 4
    //   8: invokestatic 325	com/huawei/secure/android/common/util/ZipUtil:a	(Ljava/lang/String;Ljava/lang/String;JI)Z
    //   11: istore 9
    //   13: iconst_0
    //   14: istore 6
    //   16: iload 9
    //   18: ifne +5 -> 23
    //   21: iconst_0
    //   22: ireturn
    //   23: aload 11
    //   25: astore 17
    //   27: aload 11
    //   29: getstatic 279	java/io/File:separator	Ljava/lang/String;
    //   32: invokevirtual 328	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   35: ifeq +39 -> 74
    //   38: aload 11
    //   40: astore 17
    //   42: aload_1
    //   43: invokevirtual 332	java/lang/String:length	()I
    //   46: getstatic 279	java/io/File:separator	Ljava/lang/String;
    //   49: invokevirtual 332	java/lang/String:length	()I
    //   52: if_icmple +22 -> 74
    //   55: aload 11
    //   57: iconst_0
    //   58: aload_1
    //   59: invokevirtual 332	java/lang/String:length	()I
    //   62: getstatic 279	java/io/File:separator	Ljava/lang/String;
    //   65: invokevirtual 332	java/lang/String:length	()I
    //   68: isub
    //   69: invokevirtual 335	java/lang/String:substring	(II)Ljava/lang/String;
    //   72: astore 17
    //   74: sipush 4096
    //   77: newarray byte
    //   79: astore 19
    //   81: new 37	java/util/ArrayList
    //   84: dup
    //   85: invokespecial 38	java/util/ArrayList:<init>	()V
    //   88: astore 18
    //   90: aconst_null
    //   91: astore 13
    //   93: aconst_null
    //   94: astore 14
    //   96: aconst_null
    //   97: astore_1
    //   98: new 337	java/io/FileInputStream
    //   101: dup
    //   102: aload_0
    //   103: invokespecial 338	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   106: astore 11
    //   108: new 340	java/util/zip/ZipInputStream
    //   111: dup
    //   112: new 157	java/io/BufferedInputStream
    //   115: dup
    //   116: aload 11
    //   118: invokespecial 164	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   121: invokespecial 341	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   124: astore 12
    //   126: aconst_null
    //   127: astore_0
    //   128: iconst_1
    //   129: istore 9
    //   131: iconst_0
    //   132: istore 4
    //   134: aload_0
    //   135: astore 15
    //   137: aload_1
    //   138: astore 13
    //   140: aload_0
    //   141: astore 16
    //   143: aload_1
    //   144: astore 14
    //   146: aload 12
    //   148: invokevirtual 345	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   151: astore 21
    //   153: iload 9
    //   155: istore 10
    //   157: aload 21
    //   159: ifnull +550 -> 709
    //   162: aload_0
    //   163: astore 15
    //   165: aload_1
    //   166: astore 13
    //   168: aload_0
    //   169: astore 16
    //   171: aload_1
    //   172: astore 14
    //   174: aload 21
    //   176: invokevirtual 63	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   179: ldc 111
    //   181: ldc 113
    //   183: invokevirtual 119	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   186: astore 22
    //   188: aload_0
    //   189: astore 15
    //   191: aload_1
    //   192: astore 13
    //   194: aload_0
    //   195: astore 16
    //   197: aload_1
    //   198: astore 14
    //   200: new 109	java/io/File
    //   203: dup
    //   204: aload 17
    //   206: aload 22
    //   208: invokespecial 347	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: astore 20
    //   213: aload_0
    //   214: astore 15
    //   216: aload_1
    //   217: astore 13
    //   219: aload_0
    //   220: astore 16
    //   222: aload_1
    //   223: astore 14
    //   225: aload 22
    //   227: getstatic 75	java/text/Normalizer$Form:NFKC	Ljava/text/Normalizer$Form;
    //   230: invokestatic 81	java/text/Normalizer:normalize	(Ljava/lang/CharSequence;Ljava/text/Normalizer$Form;)Ljava/lang/String;
    //   233: astore 22
    //   235: aload_0
    //   236: astore 15
    //   238: aload_1
    //   239: astore 13
    //   241: aload_0
    //   242: astore 16
    //   244: aload_1
    //   245: astore 14
    //   247: aload 22
    //   249: invokestatic 85	com/huawei/secure/android/common/util/ZipUtil:h	(Ljava/lang/String;)Z
    //   252: ifeq +96 -> 348
    //   255: aload_0
    //   256: astore 15
    //   258: aload_1
    //   259: astore 13
    //   261: aload_0
    //   262: astore 16
    //   264: aload_1
    //   265: astore 14
    //   267: new 87	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   274: astore 17
    //   276: aload_0
    //   277: astore 15
    //   279: aload_1
    //   280: astore 13
    //   282: aload_0
    //   283: astore 16
    //   285: aload_1
    //   286: astore 14
    //   288: aload 17
    //   290: ldc 90
    //   292: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload_0
    //   297: astore 15
    //   299: aload_1
    //   300: astore 13
    //   302: aload_0
    //   303: astore 16
    //   305: aload_1
    //   306: astore 14
    //   308: aload 17
    //   310: aload 22
    //   312: invokestatic 98	com/huawei/secure/android/common/util/ZipUtil:d	(Ljava/lang/String;)Ljava/lang/String;
    //   315: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload_0
    //   320: astore 15
    //   322: aload_1
    //   323: astore 13
    //   325: aload_0
    //   326: astore 16
    //   328: aload_1
    //   329: astore 14
    //   331: ldc 17
    //   333: aload 17
    //   335: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 107	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   341: pop
    //   342: iconst_0
    //   343: istore 10
    //   345: goto +364 -> 709
    //   348: iload 5
    //   350: ifeq +60 -> 410
    //   353: aload_0
    //   354: astore 15
    //   356: aload_1
    //   357: astore 13
    //   359: aload_0
    //   360: astore 16
    //   362: aload_1
    //   363: astore 14
    //   365: aload 20
    //   367: invokevirtual 125	java/io/File:exists	()Z
    //   370: ifeq +40 -> 410
    //   373: aload_0
    //   374: astore 15
    //   376: aload_1
    //   377: astore 13
    //   379: aload_0
    //   380: astore 16
    //   382: aload_1
    //   383: astore 14
    //   385: aload 20
    //   387: invokevirtual 128	java/io/File:isFile	()Z
    //   390: ifeq +20 -> 410
    //   393: aload_0
    //   394: astore 15
    //   396: aload_1
    //   397: astore 13
    //   399: aload_0
    //   400: astore 16
    //   402: aload_1
    //   403: astore 14
    //   405: aload 20
    //   407: invokestatic 131	com/huawei/secure/android/common/util/ZipUtil:c	(Ljava/io/File;)V
    //   410: aload_0
    //   411: astore 15
    //   413: aload_1
    //   414: astore 13
    //   416: aload_0
    //   417: astore 16
    //   419: aload_1
    //   420: astore 14
    //   422: aload 21
    //   424: invokevirtual 140	java/util/zip/ZipEntry:isDirectory	()Z
    //   427: ifeq +45 -> 472
    //   430: aload_0
    //   431: astore 15
    //   433: aload_1
    //   434: astore 13
    //   436: aload_0
    //   437: astore 16
    //   439: aload_1
    //   440: astore 14
    //   442: aload 20
    //   444: invokestatic 349	com/huawei/secure/android/common/util/ZipUtil:e	(Ljava/io/File;)V
    //   447: aload_0
    //   448: astore 15
    //   450: aload_1
    //   451: astore 13
    //   453: aload_0
    //   454: astore 16
    //   456: aload_1
    //   457: astore 14
    //   459: aload 18
    //   461: aload 20
    //   463: invokeinterface 137 2 0
    //   468: pop
    //   469: goto +220 -> 689
    //   472: aload_0
    //   473: astore 15
    //   475: aload_1
    //   476: astore 13
    //   478: aload_0
    //   479: astore 16
    //   481: aload_1
    //   482: astore 14
    //   484: aload 20
    //   486: invokevirtual 205	java/io/File:getParentFile	()Ljava/io/File;
    //   489: astore 21
    //   491: aload 21
    //   493: ifnull +40 -> 533
    //   496: aload_0
    //   497: astore 15
    //   499: aload_1
    //   500: astore 13
    //   502: aload_0
    //   503: astore 16
    //   505: aload_1
    //   506: astore 14
    //   508: aload 21
    //   510: invokevirtual 125	java/io/File:exists	()Z
    //   513: ifne +20 -> 533
    //   516: aload_0
    //   517: astore 15
    //   519: aload_1
    //   520: astore 13
    //   522: aload_0
    //   523: astore 16
    //   525: aload_1
    //   526: astore 14
    //   528: aload 21
    //   530: invokestatic 349	com/huawei/secure/android/common/util/ZipUtil:e	(Ljava/io/File;)V
    //   533: aload_0
    //   534: astore 15
    //   536: aload_1
    //   537: astore 13
    //   539: aload_0
    //   540: astore 16
    //   542: aload_1
    //   543: astore 14
    //   545: new 166	java/io/FileOutputStream
    //   548: dup
    //   549: aload 20
    //   551: invokespecial 167	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   554: astore_0
    //   555: new 169	java/io/BufferedOutputStream
    //   558: dup
    //   559: aload_0
    //   560: invokespecial 172	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   563: astore 13
    //   565: aload 12
    //   567: aload 19
    //   569: iload 6
    //   571: sipush 4096
    //   574: invokevirtual 352	java/util/zip/ZipInputStream:read	([BII)I
    //   577: istore 8
    //   579: iload 9
    //   581: istore 10
    //   583: iload 4
    //   585: istore 7
    //   587: iload 8
    //   589: iconst_m1
    //   590: if_icmpeq +64 -> 654
    //   593: iload 4
    //   595: iload 8
    //   597: iadd
    //   598: istore 4
    //   600: iload 4
    //   602: i2l
    //   603: lload_2
    //   604: lcmp
    //   605: ifle +33 -> 638
    //   608: ldc 17
    //   610: ldc_w 354
    //   613: invokestatic 107	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   616: pop
    //   617: iconst_0
    //   618: istore 6
    //   620: iconst_0
    //   621: istore 10
    //   623: iload 4
    //   625: istore 7
    //   627: goto +27 -> 654
    //   630: astore 14
    //   632: aload 13
    //   634: astore_1
    //   635: goto +208 -> 843
    //   638: iconst_0
    //   639: istore 6
    //   641: aload 13
    //   643: aload 19
    //   645: iconst_0
    //   646: iload 8
    //   648: invokevirtual 355	java/io/BufferedOutputStream:write	([BII)V
    //   651: goto -86 -> 565
    //   654: aload 18
    //   656: aload 20
    //   658: invokeinterface 137 2 0
    //   663: pop
    //   664: aload 13
    //   666: invokevirtual 358	java/io/BufferedOutputStream:flush	()V
    //   669: aload 13
    //   671: invokestatic 190	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/OutputStream;)V
    //   674: aload_0
    //   675: invokestatic 190	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/OutputStream;)V
    //   678: aload 13
    //   680: astore_1
    //   681: iload 7
    //   683: istore 4
    //   685: iload 10
    //   687: istore 9
    //   689: aload_0
    //   690: astore 15
    //   692: aload_1
    //   693: astore 13
    //   695: aload_0
    //   696: astore 16
    //   698: aload_1
    //   699: astore 14
    //   701: aload 12
    //   703: invokevirtual 361	java/util/zip/ZipInputStream:closeEntry	()V
    //   706: goto -572 -> 134
    //   709: aload_0
    //   710: astore 15
    //   712: aload_1
    //   713: astore 13
    //   715: aload_0
    //   716: astore 16
    //   718: aload_1
    //   719: astore 14
    //   721: aload 12
    //   723: invokestatic 188	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/InputStream;)V
    //   726: aload_0
    //   727: astore 15
    //   729: aload_1
    //   730: astore 13
    //   732: aload_0
    //   733: astore 16
    //   735: aload_1
    //   736: astore 14
    //   738: aload 11
    //   740: invokestatic 188	com/huawei/secure/android/common/util/IOUtil:closeSecure	(Ljava/io/InputStream;)V
    //   743: aload 11
    //   745: aload_1
    //   746: aload 12
    //   748: aload_0
    //   749: invokestatic 363	com/huawei/secure/android/common/util/ZipUtil:a	(Ljava/io/FileInputStream;Ljava/io/BufferedOutputStream;Ljava/util/zip/ZipInputStream;Ljava/io/FileOutputStream;)V
    //   752: goto +142 -> 894
    //   755: astore_0
    //   756: aload 15
    //   758: astore_1
    //   759: aload 13
    //   761: astore 14
    //   763: goto +165 -> 928
    //   766: astore 13
    //   768: aload 16
    //   770: astore_0
    //   771: aload 14
    //   773: astore_1
    //   774: aload_1
    //   775: astore 14
    //   777: aload 13
    //   779: astore_1
    //   780: aload 14
    //   782: astore 13
    //   784: goto +23 -> 807
    //   787: astore_0
    //   788: aconst_null
    //   789: astore_1
    //   790: aload_1
    //   791: astore 12
    //   793: goto +135 -> 928
    //   796: astore_1
    //   797: aconst_null
    //   798: astore 13
    //   800: aload 13
    //   802: astore 12
    //   804: aload 12
    //   806: astore_0
    //   807: aload_1
    //   808: astore 14
    //   810: aload 13
    //   812: astore_1
    //   813: goto +30 -> 843
    //   816: astore_0
    //   817: aconst_null
    //   818: astore_1
    //   819: aload_1
    //   820: astore 11
    //   822: aload 11
    //   824: astore 12
    //   826: goto +102 -> 928
    //   829: astore 14
    //   831: aconst_null
    //   832: astore_1
    //   833: aload_1
    //   834: astore 12
    //   836: aload 12
    //   838: astore_0
    //   839: aload 13
    //   841: astore 11
    //   843: new 87	java/lang/StringBuilder
    //   846: dup
    //   847: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   850: astore 13
    //   852: aload 13
    //   854: ldc_w 365
    //   857: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: pop
    //   861: aload 13
    //   863: aload 14
    //   865: invokevirtual 197	java/io/IOException:getMessage	()Ljava/lang/String;
    //   868: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: pop
    //   872: ldc 17
    //   874: aload 13
    //   876: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   879: invokestatic 227	com/huawei/secure/android/common/util/LogsUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   882: aload 11
    //   884: aload_1
    //   885: aload 12
    //   887: aload_0
    //   888: invokestatic 363	com/huawei/secure/android/common/util/ZipUtil:a	(Ljava/io/FileInputStream;Ljava/io/BufferedOutputStream;Ljava/util/zip/ZipInputStream;Ljava/io/FileOutputStream;)V
    //   891: iconst_0
    //   892: istore 10
    //   894: iload 10
    //   896: ifne +9 -> 905
    //   899: aload 18
    //   901: invokestatic 153	com/huawei/secure/android/common/util/ZipUtil:a	(Ljava/util/List;)Z
    //   904: pop
    //   905: iload 10
    //   907: ireturn
    //   908: astore 14
    //   910: aload_1
    //   911: astore 13
    //   913: aload 14
    //   915: astore_1
    //   916: aload 13
    //   918: astore 14
    //   920: aload_1
    //   921: astore 13
    //   923: aload_0
    //   924: astore_1
    //   925: aload 13
    //   927: astore_0
    //   928: aload 11
    //   930: aload 14
    //   932: aload 12
    //   934: aload_1
    //   935: invokestatic 363	com/huawei/secure/android/common/util/ZipUtil:a	(Ljava/io/FileInputStream;Ljava/io/BufferedOutputStream;Ljava/util/zip/ZipInputStream;Ljava/io/FileOutputStream;)V
    //   938: goto +5 -> 943
    //   941: aload_0
    //   942: athrow
    //   943: goto -2 -> 941
    //   946: astore_1
    //   947: goto -31 -> 916
    //   950: astore_1
    //   951: goto -144 -> 807
    //   954: astore 13
    //   956: aload_1
    //   957: astore 14
    //   959: goto -36 -> 923
    //   962: astore 13
    //   964: goto -190 -> 774
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	967	0	paramString1	String
    //   0	967	1	paramString2	String
    //   0	967	2	paramLong	long
    //   0	967	4	paramInt	int
    //   0	967	5	paramBoolean	boolean
    //   14	626	6	i	int
    //   585	97	7	j	int
    //   577	70	8	k	int
    //   11	677	9	bool1	boolean
    //   155	751	10	bool2	boolean
    //   1	928	11	localObject1	Object
    //   124	809	12	localObject2	Object
    //   91	669	13	localObject3	Object
    //   766	12	13	localIOException1	IOException
    //   782	144	13	localObject4	Object
    //   954	1	13	localObject5	Object
    //   962	1	13	localIOException2	IOException
    //   94	450	14	str1	String
    //   630	1	14	localIOException3	IOException
    //   699	110	14	localObject6	Object
    //   829	35	14	localIOException4	IOException
    //   908	6	14	localObject7	Object
    //   918	40	14	localObject8	Object
    //   135	622	15	str2	String
    //   141	628	16	str3	String
    //   25	309	17	localObject9	Object
    //   88	812	18	localArrayList	java.util.ArrayList
    //   79	565	19	arrayOfByte	byte[]
    //   211	446	20	localFile	File
    //   151	378	21	localObject10	Object
    //   186	125	22	str4	String
    // Exception table:
    //   from	to	target	type
    //   608	617	630	java/io/IOException
    //   146	153	755	finally
    //   174	188	755	finally
    //   200	213	755	finally
    //   225	235	755	finally
    //   247	255	755	finally
    //   267	276	755	finally
    //   288	296	755	finally
    //   308	319	755	finally
    //   331	342	755	finally
    //   365	373	755	finally
    //   385	393	755	finally
    //   405	410	755	finally
    //   422	430	755	finally
    //   442	447	755	finally
    //   459	469	755	finally
    //   484	491	755	finally
    //   508	516	755	finally
    //   528	533	755	finally
    //   545	555	755	finally
    //   701	706	755	finally
    //   721	726	755	finally
    //   738	743	755	finally
    //   146	153	766	java/io/IOException
    //   174	188	766	java/io/IOException
    //   200	213	766	java/io/IOException
    //   225	235	766	java/io/IOException
    //   247	255	766	java/io/IOException
    //   267	276	766	java/io/IOException
    //   288	296	766	java/io/IOException
    //   308	319	766	java/io/IOException
    //   331	342	766	java/io/IOException
    //   365	373	766	java/io/IOException
    //   385	393	766	java/io/IOException
    //   405	410	766	java/io/IOException
    //   422	430	766	java/io/IOException
    //   442	447	766	java/io/IOException
    //   459	469	766	java/io/IOException
    //   484	491	766	java/io/IOException
    //   508	516	766	java/io/IOException
    //   528	533	766	java/io/IOException
    //   545	555	766	java/io/IOException
    //   701	706	766	java/io/IOException
    //   721	726	766	java/io/IOException
    //   738	743	766	java/io/IOException
    //   108	126	787	finally
    //   108	126	796	java/io/IOException
    //   98	108	816	finally
    //   98	108	829	java/io/IOException
    //   843	882	908	finally
    //   565	579	946	finally
    //   608	617	946	finally
    //   641	651	946	finally
    //   654	678	946	finally
    //   565	579	950	java/io/IOException
    //   641	651	950	java/io/IOException
    //   654	678	950	java/io/IOException
    //   555	565	954	finally
    //   555	565	962	java/io/IOException
  }
  
  @Deprecated
  public static boolean unZip(String paramString1, String paramString2, boolean paramBoolean)
  {
    return unZip(paramString1, paramString2, 104857600L, 100, paramBoolean);
  }
  
  public static List<File> unZipNew(String paramString1, String paramString2, long paramLong, int paramInt, boolean paramBoolean)
  {
    if (!a(paramString1, paramString2, paramLong, paramInt)) {
      return null;
    }
    String str = paramString2;
    if (paramString2.endsWith(File.separator))
    {
      str = paramString2;
      if (paramString2.length() > File.separator.length()) {
        str = paramString2.substring(0, paramString2.length() - File.separator.length());
      }
    }
    return a(f(paramString1), f(str), paramLong, paramBoolean);
  }
  
  public static List<File> unZipNew(String paramString1, String paramString2, boolean paramBoolean)
  {
    return unZipNew(paramString1, paramString2, 104857600L, 100, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.util.ZipUtil
 * JD-Core Version:    0.7.0.1
 */