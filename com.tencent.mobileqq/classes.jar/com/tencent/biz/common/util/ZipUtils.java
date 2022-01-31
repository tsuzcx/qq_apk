package com.tencent.biz.common.util;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.RecycleableBufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipUtils
{
  /* Error */
  public static int a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 25	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +40 -> 43
    //   6: ldc 27
    //   8: iconst_4
    //   9: new 29	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   16: ldc 32
    //   18: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 42	java/lang/String:toString	()Ljava/lang/String;
    //   25: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 44
    //   30: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: new 51	java/io/File
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore 6
    //   53: aload 6
    //   55: invokevirtual 57	java/io/File:exists	()Z
    //   58: ifne +9 -> 67
    //   61: aload 6
    //   63: invokevirtual 60	java/io/File:mkdirs	()Z
    //   66: pop
    //   67: new 51	java/io/File
    //   70: dup
    //   71: aload_0
    //   72: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   75: astore_0
    //   76: new 62	java/util/zip/ZipFile
    //   79: dup
    //   80: aload_0
    //   81: invokespecial 65	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   84: astore 9
    //   86: iconst_0
    //   87: istore_3
    //   88: sipush 8192
    //   91: newarray byte
    //   93: astore 8
    //   95: new 29	java/lang/StringBuilder
    //   98: dup
    //   99: sipush 512
    //   102: invokespecial 68	java/lang/StringBuilder:<init>	(I)V
    //   105: astore 10
    //   107: aload 9
    //   109: invokevirtual 72	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   112: astore 11
    //   114: iload_3
    //   115: istore_2
    //   116: aload 11
    //   118: invokeinterface 77 1 0
    //   123: ifeq +593 -> 716
    //   126: aload 11
    //   128: invokeinterface 81 1 0
    //   133: checkcast 83	java/util/zip/ZipEntry
    //   136: astore 12
    //   138: aload 12
    //   140: invokevirtual 86	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   143: astore_0
    //   144: aload_0
    //   145: ldc 88
    //   147: invokevirtual 92	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   150: ifne -36 -> 114
    //   153: aload 10
    //   155: iconst_0
    //   156: aload 10
    //   158: invokevirtual 96	java/lang/StringBuilder:length	()I
    //   161: invokevirtual 100	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 10
    //   167: aload_1
    //   168: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: getstatic 104	java/io/File:separator	Ljava/lang/String;
    //   174: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 12
    //   184: invokevirtual 107	java/util/zip/ZipEntry:isDirectory	()Z
    //   187: ifeq +108 -> 295
    //   190: new 51	java/io/File
    //   193: dup
    //   194: aload 10
    //   196: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   202: astore_0
    //   203: aload_0
    //   204: invokevirtual 57	java/io/File:exists	()Z
    //   207: ifne -93 -> 114
    //   210: aload_0
    //   211: invokevirtual 60	java/io/File:mkdirs	()Z
    //   214: pop
    //   215: goto -101 -> 114
    //   218: astore_0
    //   219: aload_0
    //   220: invokevirtual 110	java/io/FileNotFoundException:printStackTrace	()V
    //   223: iconst_5
    //   224: istore_2
    //   225: aload 9
    //   227: invokevirtual 113	java/util/zip/ZipFile:close	()V
    //   230: iload_2
    //   231: ireturn
    //   232: astore_0
    //   233: aload_0
    //   234: invokevirtual 114	java/util/zip/ZipException:printStackTrace	()V
    //   237: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   240: ifeq +11 -> 251
    //   243: ldc 27
    //   245: iconst_2
    //   246: ldc 119
    //   248: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: iconst_1
    //   252: ireturn
    //   253: astore_0
    //   254: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq +11 -> 268
    //   260: ldc 27
    //   262: iconst_2
    //   263: ldc 121
    //   265: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: aload_0
    //   269: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   272: iconst_2
    //   273: ireturn
    //   274: astore_0
    //   275: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   278: ifeq +11 -> 289
    //   281: ldc 27
    //   283: iconst_2
    //   284: ldc 124
    //   286: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: aload_0
    //   290: invokevirtual 125	java/lang/Exception:printStackTrace	()V
    //   293: iconst_3
    //   294: ireturn
    //   295: aconst_null
    //   296: astore 7
    //   298: aload 9
    //   300: aload 12
    //   302: invokevirtual 129	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   305: astore_0
    //   306: new 131	java/util/zip/CheckedInputStream
    //   309: dup
    //   310: aload_0
    //   311: new 133	java/util/zip/CRC32
    //   314: dup
    //   315: invokespecial 134	java/util/zip/CRC32:<init>	()V
    //   318: invokespecial 137	java/util/zip/CheckedInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    //   321: astore 6
    //   323: new 51	java/io/File
    //   326: dup
    //   327: new 38	java/lang/String
    //   330: dup
    //   331: aload 10
    //   333: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: ldc 139
    //   338: invokevirtual 143	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   341: ldc 145
    //   343: invokespecial 148	java/lang/String:<init>	([BLjava/lang/String;)V
    //   346: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   349: astore 7
    //   351: aload 7
    //   353: invokevirtual 57	java/io/File:exists	()Z
    //   356: ifne +24 -> 380
    //   359: aload 7
    //   361: invokevirtual 152	java/io/File:getParentFile	()Ljava/io/File;
    //   364: astore 13
    //   366: aload 13
    //   368: invokevirtual 57	java/io/File:exists	()Z
    //   371: ifne +9 -> 380
    //   374: aload 13
    //   376: invokevirtual 60	java/io/File:mkdirs	()Z
    //   379: pop
    //   380: new 154	java/io/BufferedOutputStream
    //   383: dup
    //   384: new 156	java/io/FileOutputStream
    //   387: dup
    //   388: aload 7
    //   390: invokespecial 157	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   393: invokespecial 160	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   396: invokestatic 165	cooperation/qzone/util/RecycleableBufferedOutputStream:a	(Ljava/io/OutputStream;)Lcooperation/qzone/util/RecycleableBufferedOutputStream;
    //   399: astore 7
    //   401: aload 12
    //   403: invokevirtual 169	java/util/zip/ZipEntry:getSize	()J
    //   406: lstore 4
    //   408: lload 4
    //   410: lconst_0
    //   411: lcmp
    //   412: ifle +34 -> 446
    //   415: aload 6
    //   417: aload 8
    //   419: iconst_0
    //   420: sipush 8192
    //   423: invokevirtual 173	java/util/zip/CheckedInputStream:read	([BII)I
    //   426: istore_2
    //   427: aload 7
    //   429: aload 8
    //   431: iconst_0
    //   432: iload_2
    //   433: invokevirtual 179	java/io/OutputStream:write	([BII)V
    //   436: lload 4
    //   438: iload_2
    //   439: i2l
    //   440: lsub
    //   441: lstore 4
    //   443: goto -35 -> 408
    //   446: aload 12
    //   448: invokevirtual 182	java/util/zip/ZipEntry:getCrc	()J
    //   451: aload 6
    //   453: invokevirtual 186	java/util/zip/CheckedInputStream:getChecksum	()Ljava/util/zip/Checksum;
    //   456: invokeinterface 191 1 0
    //   461: lcmp
    //   462: ifeq +79 -> 541
    //   465: iconst_4
    //   466: istore_2
    //   467: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   470: ifeq +32 -> 502
    //   473: ldc 27
    //   475: iconst_2
    //   476: new 29	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   483: ldc 193
    //   485: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: aload 12
    //   490: invokevirtual 182	java/util/zip/ZipEntry:getCrc	()J
    //   493: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   496: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   502: aload 6
    //   504: ifnull +8 -> 512
    //   507: aload 6
    //   509: invokevirtual 197	java/util/zip/CheckedInputStream:close	()V
    //   512: aload_0
    //   513: ifnull +7 -> 520
    //   516: aload_0
    //   517: invokevirtual 200	java/io/InputStream:close	()V
    //   520: aload 7
    //   522: ifnull +194 -> 716
    //   525: aload 7
    //   527: invokevirtual 201	java/io/OutputStream:close	()V
    //   530: iconst_4
    //   531: istore_2
    //   532: goto -307 -> 225
    //   535: astore_0
    //   536: iconst_4
    //   537: istore_2
    //   538: goto -313 -> 225
    //   541: aload 6
    //   543: ifnull +8 -> 551
    //   546: aload 6
    //   548: invokevirtual 197	java/util/zip/CheckedInputStream:close	()V
    //   551: aload_0
    //   552: ifnull +7 -> 559
    //   555: aload_0
    //   556: invokevirtual 200	java/io/InputStream:close	()V
    //   559: aload 7
    //   561: ifnull -447 -> 114
    //   564: aload 7
    //   566: invokevirtual 201	java/io/OutputStream:close	()V
    //   569: goto -455 -> 114
    //   572: astore_0
    //   573: goto -459 -> 114
    //   576: astore_0
    //   577: aconst_null
    //   578: astore_1
    //   579: aconst_null
    //   580: astore 6
    //   582: aload 6
    //   584: ifnull +8 -> 592
    //   587: aload 6
    //   589: invokevirtual 197	java/util/zip/CheckedInputStream:close	()V
    //   592: aload 7
    //   594: ifnull +8 -> 602
    //   597: aload 7
    //   599: invokevirtual 200	java/io/InputStream:close	()V
    //   602: aload_1
    //   603: ifnull +7 -> 610
    //   606: aload_1
    //   607: invokevirtual 201	java/io/OutputStream:close	()V
    //   610: aload_0
    //   611: athrow
    //   612: astore_0
    //   613: aload_0
    //   614: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   617: bipush 6
    //   619: istore_2
    //   620: goto -395 -> 225
    //   623: astore_0
    //   624: aload_0
    //   625: invokevirtual 125	java/lang/Exception:printStackTrace	()V
    //   628: bipush 7
    //   630: istore_2
    //   631: goto -406 -> 225
    //   634: astore_0
    //   635: aload_0
    //   636: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   639: bipush 8
    //   641: ireturn
    //   642: astore_1
    //   643: goto -131 -> 512
    //   646: astore_0
    //   647: goto -127 -> 520
    //   650: astore 6
    //   652: goto -101 -> 551
    //   655: astore_0
    //   656: goto -97 -> 559
    //   659: astore 6
    //   661: goto -69 -> 592
    //   664: astore 6
    //   666: goto -64 -> 602
    //   669: astore_1
    //   670: goto -60 -> 610
    //   673: astore 8
    //   675: aconst_null
    //   676: astore_1
    //   677: aload_0
    //   678: astore 7
    //   680: aconst_null
    //   681: astore 6
    //   683: aload 8
    //   685: astore_0
    //   686: goto -104 -> 582
    //   689: astore 8
    //   691: aconst_null
    //   692: astore_1
    //   693: aload_0
    //   694: astore 7
    //   696: aload 8
    //   698: astore_0
    //   699: goto -117 -> 582
    //   702: astore 8
    //   704: aload 7
    //   706: astore_1
    //   707: aload_0
    //   708: astore 7
    //   710: aload 8
    //   712: astore_0
    //   713: goto -131 -> 582
    //   716: goto -491 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	719	0	paramString1	String
    //   0	719	1	paramString2	String
    //   115	516	2	i	int
    //   87	28	3	j	int
    //   406	36	4	l	long
    //   51	537	6	localObject1	Object
    //   650	1	6	localIOException1	IOException
    //   659	1	6	localIOException2	IOException
    //   664	1	6	localIOException3	IOException
    //   681	1	6	localObject2	Object
    //   296	413	7	localObject3	Object
    //   93	337	8	arrayOfByte	byte[]
    //   673	11	8	localObject4	Object
    //   689	8	8	localObject5	Object
    //   702	9	8	localObject6	Object
    //   84	215	9	localZipFile	ZipFile
    //   105	227	10	localStringBuilder	StringBuilder
    //   112	15	11	localEnumeration	Enumeration
    //   136	353	12	localZipEntry	ZipEntry
    //   364	11	13	localFile	File
    // Exception table:
    //   from	to	target	type
    //   88	114	218	java/io/FileNotFoundException
    //   116	215	218	java/io/FileNotFoundException
    //   507	512	218	java/io/FileNotFoundException
    //   516	520	218	java/io/FileNotFoundException
    //   525	530	218	java/io/FileNotFoundException
    //   546	551	218	java/io/FileNotFoundException
    //   555	559	218	java/io/FileNotFoundException
    //   564	569	218	java/io/FileNotFoundException
    //   587	592	218	java/io/FileNotFoundException
    //   597	602	218	java/io/FileNotFoundException
    //   606	610	218	java/io/FileNotFoundException
    //   610	612	218	java/io/FileNotFoundException
    //   76	86	232	java/util/zip/ZipException
    //   76	86	253	java/io/IOException
    //   76	86	274	java/lang/Exception
    //   525	530	535	java/io/IOException
    //   564	569	572	java/io/IOException
    //   298	306	576	finally
    //   88	114	612	java/io/IOException
    //   116	215	612	java/io/IOException
    //   610	612	612	java/io/IOException
    //   88	114	623	java/lang/Exception
    //   116	215	623	java/lang/Exception
    //   507	512	623	java/lang/Exception
    //   516	520	623	java/lang/Exception
    //   525	530	623	java/lang/Exception
    //   546	551	623	java/lang/Exception
    //   555	559	623	java/lang/Exception
    //   564	569	623	java/lang/Exception
    //   587	592	623	java/lang/Exception
    //   597	602	623	java/lang/Exception
    //   606	610	623	java/lang/Exception
    //   610	612	623	java/lang/Exception
    //   225	230	634	java/io/IOException
    //   507	512	642	java/io/IOException
    //   516	520	646	java/io/IOException
    //   546	551	650	java/io/IOException
    //   555	559	655	java/io/IOException
    //   587	592	659	java/io/IOException
    //   597	602	664	java/io/IOException
    //   606	610	669	java/io/IOException
    //   306	323	673	finally
    //   323	380	689	finally
    //   380	401	689	finally
    //   401	408	702	finally
    //   415	436	702	finally
    //   446	465	702	finally
    //   467	502	702	finally
  }
  
  public static String a(ZipEntry paramZipEntry)
  {
    return new String(paramZipEntry.getName().getBytes("GB2312"), "8859_1");
  }
  
  public static ArrayList a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = a(paramFile);
    while (paramFile.hasMoreElements()) {
      localArrayList.add(new String(a((ZipEntry)paramFile.nextElement()).getBytes("GB2312"), "8859_1"));
    }
    return localArrayList;
  }
  
  public static Enumeration a(File paramFile)
  {
    return new ZipFile(paramFile).entries();
  }
  
  /* Error */
  public static void a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 62	java/util/zip/ZipFile
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 65	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   10: astore 5
    //   12: aload 5
    //   14: invokevirtual 72	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   17: astore 6
    //   19: sipush 8192
    //   22: newarray byte
    //   24: astore 7
    //   26: aload 6
    //   28: invokeinterface 77 1 0
    //   33: ifeq +294 -> 327
    //   36: aload 6
    //   38: invokeinterface 81 1 0
    //   43: checkcast 83	java/util/zip/ZipEntry
    //   46: astore 4
    //   48: aload 4
    //   50: invokevirtual 86	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   53: ldc 88
    //   55: invokevirtual 92	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   58: ifne -32 -> 26
    //   61: aload 4
    //   63: invokevirtual 107	java/util/zip/ZipEntry:isDirectory	()Z
    //   66: ifeq +121 -> 187
    //   69: invokestatic 25	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   72: ifeq +32 -> 104
    //   75: ldc 27
    //   77: iconst_4
    //   78: new 29	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   85: ldc 218
    //   87: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 4
    //   92: invokevirtual 86	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   95: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: new 38	java/lang/String
    //   107: dup
    //   108: new 29	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   115: aload_1
    //   116: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 4
    //   121: invokevirtual 86	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   124: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: ldc 139
    //   132: invokevirtual 143	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   135: ldc 145
    //   137: invokespecial 148	java/lang/String:<init>	([BLjava/lang/String;)V
    //   140: astore_0
    //   141: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq +28 -> 172
    //   147: ldc 27
    //   149: iconst_2
    //   150: new 29	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   157: ldc 220
    //   159: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: new 51	java/io/File
    //   175: dup
    //   176: aload_0
    //   177: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   180: invokevirtual 223	java/io/File:mkdir	()Z
    //   183: pop
    //   184: goto -158 -> 26
    //   187: new 51	java/io/File
    //   190: dup
    //   191: new 29	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   198: aload_1
    //   199: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 4
    //   204: invokevirtual 86	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   207: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   216: astore_0
    //   217: aload_0
    //   218: invokevirtual 152	java/io/File:getParentFile	()Ljava/io/File;
    //   221: invokevirtual 60	java/io/File:mkdirs	()Z
    //   224: pop
    //   225: new 156	java/io/FileOutputStream
    //   228: dup
    //   229: aload_0
    //   230: invokespecial 157	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   233: invokestatic 165	cooperation/qzone/util/RecycleableBufferedOutputStream:a	(Ljava/io/OutputStream;)Lcooperation/qzone/util/RecycleableBufferedOutputStream;
    //   236: astore_0
    //   237: aload 5
    //   239: aload 4
    //   241: invokevirtual 129	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   244: astore 4
    //   246: aload 4
    //   248: aload 7
    //   250: iconst_0
    //   251: sipush 8192
    //   254: invokevirtual 224	java/io/InputStream:read	([BII)I
    //   257: istore_2
    //   258: iload_2
    //   259: iconst_m1
    //   260: if_icmpeq +42 -> 302
    //   263: aload_0
    //   264: aload 7
    //   266: iconst_0
    //   267: iload_2
    //   268: invokevirtual 179	java/io/OutputStream:write	([BII)V
    //   271: goto -25 -> 246
    //   274: astore 5
    //   276: aload_0
    //   277: astore_3
    //   278: aload 4
    //   280: astore_1
    //   281: aload 5
    //   283: astore_0
    //   284: aload_1
    //   285: ifnull +7 -> 292
    //   288: aload_1
    //   289: invokevirtual 200	java/io/InputStream:close	()V
    //   292: aload_3
    //   293: ifnull +7 -> 300
    //   296: aload_3
    //   297: invokevirtual 201	java/io/OutputStream:close	()V
    //   300: aload_0
    //   301: athrow
    //   302: aload 4
    //   304: ifnull +8 -> 312
    //   307: aload 4
    //   309: invokevirtual 200	java/io/InputStream:close	()V
    //   312: aload_0
    //   313: ifnull -287 -> 26
    //   316: aload_0
    //   317: invokevirtual 201	java/io/OutputStream:close	()V
    //   320: goto -294 -> 26
    //   323: astore_0
    //   324: goto -298 -> 26
    //   327: aload 5
    //   329: invokevirtual 113	java/util/zip/ZipFile:close	()V
    //   332: return
    //   333: astore 4
    //   335: goto -23 -> 312
    //   338: astore_1
    //   339: goto -47 -> 292
    //   342: astore_1
    //   343: goto -43 -> 300
    //   346: astore_0
    //   347: aconst_null
    //   348: astore_1
    //   349: goto -65 -> 284
    //   352: astore 4
    //   354: aconst_null
    //   355: astore_1
    //   356: aload_0
    //   357: astore_3
    //   358: aload 4
    //   360: astore_0
    //   361: goto -77 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	364	0	paramFile	File
    //   0	364	1	paramString	String
    //   257	11	2	i	int
    //   1	357	3	localFile	File
    //   46	262	4	localObject1	Object
    //   333	1	4	localIOException	IOException
    //   352	7	4	localObject2	Object
    //   10	228	5	localZipFile	ZipFile
    //   274	54	5	localObject3	Object
    //   17	20	6	localEnumeration	Enumeration
    //   24	241	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   246	258	274	finally
    //   263	271	274	finally
    //   316	320	323	java/io/IOException
    //   307	312	333	java/io/IOException
    //   288	292	338	java/io/IOException
    //   296	300	342	java/io/IOException
    //   225	237	346	finally
    //   237	246	352	finally
  }
  
  private static void a(ZipInputStream paramZipInputStream, File paramFile)
  {
    localObject = null;
    File localFile = null;
    byte[] arrayOfByte = new byte[8192];
    try
    {
      paramFile = RecycleableBufferedOutputStream.a(new FileOutputStream(paramFile));
      for (;;)
      {
        localFile = paramFile;
        localObject = paramFile;
        int i = paramZipInputStream.read(arrayOfByte, 0, arrayOfByte.length);
        if (i == -1) {
          break;
        }
        localFile = paramFile;
        localObject = paramFile;
        paramFile.write(arrayOfByte, 0, i);
      }
      try
      {
        ((OutputStream)localObject).close();
        throw paramZipInputStream;
      }
      catch (IOException paramFile)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramFile);
          }
        }
      }
    }
    catch (Exception paramZipInputStream)
    {
      localObject = localFile;
      if (QLog.isColorLevel())
      {
        localObject = localFile;
        QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramZipInputStream);
      }
      if (localFile != null) {}
      try
      {
        localFile.close();
        do
        {
          do
          {
            return;
          } while (paramFile == null);
          try
          {
            paramFile.close();
            return;
          }
          catch (IOException paramZipInputStream) {}
        } while (!QLog.isColorLevel());
        QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramZipInputStream);
        return;
      }
      catch (IOException paramZipInputStream)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramZipInputStream);
        return;
      }
    }
    finally
    {
      if (localObject == null) {}
    }
  }
  
  public static int b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ZipUtils", 2, "unZipFile2 参数错误：zipFilePath:" + paramString1 + ",folderPath:" + paramString2);
      }
      return -1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("ZipUtils", 4, "unZipFile2 new file:" + paramString1 + ", folderPath:" + paramString2);
    }
    paramString1 = new File(paramString1);
    if (!paramString1.exists())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("ZipUtils", 4, "unZipFile2  zipFilePath doesn't exist");
      }
      return -2;
    }
    Object localObject1 = new File(paramString2);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    int i;
    try
    {
      paramString1 = new ZipInputStream(new BufferedInputStream(new FileInputStream(paramString1)));
    }
    catch (Throwable paramString1)
    {
      try
      {
        localObject1 = new StringBuilder(512);
        for (;;)
        {
          localObject2 = paramString1.getNextEntry();
          if (localObject2 == null) {
            break label444;
          }
          ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
          localObject3 = ((ZipEntry)localObject2).getName();
          if (QLog.isDevelopLevel()) {
            QLog.d("ZipUtils", 4, "unZipFile2 folderPath:" + paramString2 + ",ZipEntry name: " + (String)localObject3);
          }
          ((StringBuilder)localObject1).append(paramString2).append(File.separator).append((String)localObject3);
          if (!((ZipEntry)localObject2).isDirectory()) {
            break;
          }
          localObject2 = new File(((StringBuilder)localObject1).toString());
          if (!((File)localObject2).exists()) {
            ((File)localObject2).mkdirs();
          }
        }
      }
      catch (FileNotFoundException paramString2)
      {
        for (;;)
        {
          Object localObject3;
          i = -3;
          if (QLog.isColorLevel()) {
            QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramString2);
          }
          if (paramString1 == null) {
            break label534;
          }
          try
          {
            paramString1.close();
            return -3;
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
            return -3;
          }
          paramString1 = paramString1;
          if (QLog.isColorLevel()) {
            QLog.e("ZipUtils", 2, " unZipFile2  解压错误：", paramString1);
          }
          paramString1 = null;
          continue;
          Object localObject2 = new File(((StringBuilder)localObject1).toString());
          if (!((File)localObject2).exists())
          {
            localObject3 = ((File)localObject2).getParentFile();
            if (!((File)localObject3).exists()) {
              ((File)localObject3).mkdirs();
            }
          }
          a(paramString1, (File)localObject2);
        }
      }
      catch (IOException paramString2)
      {
        i = -4;
        if (QLog.isColorLevel()) {
          QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramString2);
        }
        if (paramString1 != null)
        {
          try
          {
            paramString1.close();
            return -4;
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
            return -4;
          }
          if (paramString1 == null) {
            break label536;
          }
          try
          {
            paramString1.close();
            return 0;
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
            return 0;
          }
        }
      }
      catch (Exception paramString2)
      {
        label444:
        i = -5;
        if (QLog.isColorLevel()) {
          QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramString2);
        }
        if (paramString1 != null) {
          try
          {
            paramString1.close();
            return -5;
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
            return -5;
          }
        }
      }
      finally
      {
        if (paramString1 != null) {}
        try
        {
          paramString1.close();
          throw paramString2;
        }
        catch (IOException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
          }
        }
      }
    }
    label534:
    return i;
    label536:
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.common.util.ZipUtils
 * JD-Core Version:    0.7.0.1
 */