import android.text.TextUtils;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class bemb
{
  /* Error */
  public static int a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_1
    //   6: invokestatic 20	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +38 -> 47
    //   12: ldc 22
    //   14: new 24	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   21: ldc 30
    //   23: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: invokevirtual 40	java/lang/String:toString	()Ljava/lang/String;
    //   30: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 42
    //   35: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 49	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: bipush 9
    //   46: ireturn
    //   47: new 51	java/io/File
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore 6
    //   57: aload 6
    //   59: invokevirtual 58	java/io/File:exists	()Z
    //   62: ifne +9 -> 71
    //   65: aload 6
    //   67: invokevirtual 61	java/io/File:mkdirs	()Z
    //   70: pop
    //   71: new 51	java/io/File
    //   74: dup
    //   75: aload_0
    //   76: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   79: astore_0
    //   80: new 63	belo
    //   83: dup
    //   84: aload_0
    //   85: invokespecial 66	belo:<init>	(Ljava/io/File;)V
    //   88: astore 9
    //   90: sipush 8192
    //   93: newarray byte
    //   95: astore 10
    //   97: new 24	java/lang/StringBuilder
    //   100: dup
    //   101: sipush 512
    //   104: invokespecial 69	java/lang/StringBuilder:<init>	(I)V
    //   107: astore 11
    //   109: aload 9
    //   111: invokevirtual 73	belo:entries	()Ljava/util/Enumeration;
    //   114: astore 12
    //   116: iload_3
    //   117: istore_2
    //   118: aload 12
    //   120: invokeinterface 78 1 0
    //   125: ifeq +563 -> 688
    //   128: aload 12
    //   130: invokeinterface 82 1 0
    //   135: checkcast 84	java/util/zip/ZipEntry
    //   138: astore 13
    //   140: aload 13
    //   142: invokevirtual 87	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   145: astore_0
    //   146: aload_0
    //   147: ldc 89
    //   149: invokevirtual 92	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   152: ifne -36 -> 116
    //   155: aload 11
    //   157: iconst_0
    //   158: aload 11
    //   160: invokevirtual 96	java/lang/StringBuilder:length	()I
    //   163: invokevirtual 100	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 11
    //   169: aload_1
    //   170: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: getstatic 104	java/io/File:separator	Ljava/lang/String;
    //   176: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_0
    //   180: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 13
    //   186: invokevirtual 107	java/util/zip/ZipEntry:isDirectory	()Z
    //   189: ifeq +83 -> 272
    //   192: new 51	java/io/File
    //   195: dup
    //   196: aload 11
    //   198: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   204: astore_0
    //   205: aload_0
    //   206: invokevirtual 58	java/io/File:exists	()Z
    //   209: ifne -93 -> 116
    //   212: aload_0
    //   213: invokevirtual 61	java/io/File:mkdirs	()Z
    //   216: pop
    //   217: goto -101 -> 116
    //   220: astore_0
    //   221: aload_0
    //   222: invokevirtual 110	java/io/FileNotFoundException:printStackTrace	()V
    //   225: iconst_5
    //   226: istore_2
    //   227: aload 9
    //   229: invokevirtual 113	belo:close	()V
    //   232: iload_2
    //   233: ireturn
    //   234: astore_0
    //   235: aload_0
    //   236: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   239: bipush 8
    //   241: ireturn
    //   242: astore_0
    //   243: ldc 22
    //   245: ldc 116
    //   247: invokestatic 118	betc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: iconst_1
    //   251: ireturn
    //   252: astore_0
    //   253: ldc 22
    //   255: ldc 120
    //   257: invokestatic 118	betc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: iconst_2
    //   261: ireturn
    //   262: astore_0
    //   263: ldc 22
    //   265: ldc 122
    //   267: invokestatic 118	betc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: iconst_3
    //   271: ireturn
    //   272: aload 9
    //   274: aload 13
    //   276: invokevirtual 126	belo:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   279: astore_0
    //   280: new 128	java/util/zip/CheckedInputStream
    //   283: dup
    //   284: aload_0
    //   285: new 130	java/util/zip/CRC32
    //   288: dup
    //   289: invokespecial 131	java/util/zip/CRC32:<init>	()V
    //   292: invokespecial 134	java/util/zip/CheckedInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    //   295: astore 6
    //   297: new 51	java/io/File
    //   300: dup
    //   301: new 36	java/lang/String
    //   304: dup
    //   305: aload 11
    //   307: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: ldc 136
    //   312: invokevirtual 140	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   315: ldc 142
    //   317: invokespecial 145	java/lang/String:<init>	([BLjava/lang/String;)V
    //   320: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   323: astore 8
    //   325: aload 8
    //   327: invokevirtual 58	java/io/File:exists	()Z
    //   330: ifne +24 -> 354
    //   333: aload 8
    //   335: invokevirtual 149	java/io/File:getParentFile	()Ljava/io/File;
    //   338: astore 14
    //   340: aload 14
    //   342: invokevirtual 58	java/io/File:exists	()Z
    //   345: ifne +9 -> 354
    //   348: aload 14
    //   350: invokevirtual 61	java/io/File:mkdirs	()Z
    //   353: pop
    //   354: new 151	java/io/BufferedOutputStream
    //   357: dup
    //   358: new 153	java/io/FileOutputStream
    //   361: dup
    //   362: aload 8
    //   364: invokespecial 154	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   367: invokespecial 157	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   370: invokestatic 162	belp:a	(Ljava/io/OutputStream;)Lbelp;
    //   373: astore 8
    //   375: aload 13
    //   377: invokevirtual 166	java/util/zip/ZipEntry:getSize	()J
    //   380: lstore 4
    //   382: lload 4
    //   384: lconst_0
    //   385: lcmp
    //   386: ifle +34 -> 420
    //   389: aload 6
    //   391: aload 10
    //   393: iconst_0
    //   394: sipush 8192
    //   397: invokevirtual 170	java/util/zip/CheckedInputStream:read	([BII)I
    //   400: istore_2
    //   401: aload 8
    //   403: aload 10
    //   405: iconst_0
    //   406: iload_2
    //   407: invokevirtual 176	java/io/OutputStream:write	([BII)V
    //   410: lload 4
    //   412: iload_2
    //   413: i2l
    //   414: lsub
    //   415: lstore 4
    //   417: goto -35 -> 382
    //   420: aload 13
    //   422: invokevirtual 179	java/util/zip/ZipEntry:getCrc	()J
    //   425: aload 6
    //   427: invokevirtual 183	java/util/zip/CheckedInputStream:getChecksum	()Ljava/util/zip/Checksum;
    //   430: invokeinterface 188 1 0
    //   435: lcmp
    //   436: ifeq +72 -> 508
    //   439: iconst_4
    //   440: istore_2
    //   441: ldc 22
    //   443: new 24	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   450: ldc 190
    //   452: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload 13
    //   457: invokevirtual 179	java/util/zip/ZipEntry:getCrc	()J
    //   460: invokevirtual 193	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   463: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 118	betc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: aload 6
    //   471: ifnull +8 -> 479
    //   474: aload 6
    //   476: invokevirtual 194	java/util/zip/CheckedInputStream:close	()V
    //   479: aload_0
    //   480: ifnull +7 -> 487
    //   483: aload_0
    //   484: invokevirtual 197	java/io/InputStream:close	()V
    //   487: aload 8
    //   489: ifnull +199 -> 688
    //   492: aload 8
    //   494: invokevirtual 198	java/io/OutputStream:close	()V
    //   497: iconst_4
    //   498: istore_2
    //   499: goto -272 -> 227
    //   502: astore_0
    //   503: iconst_4
    //   504: istore_2
    //   505: goto -278 -> 227
    //   508: aload 6
    //   510: ifnull +8 -> 518
    //   513: aload 6
    //   515: invokevirtual 194	java/util/zip/CheckedInputStream:close	()V
    //   518: aload_0
    //   519: ifnull +7 -> 526
    //   522: aload_0
    //   523: invokevirtual 197	java/io/InputStream:close	()V
    //   526: aload 8
    //   528: ifnull -412 -> 116
    //   531: aload 8
    //   533: invokevirtual 198	java/io/OutputStream:close	()V
    //   536: goto -420 -> 116
    //   539: astore_0
    //   540: goto -424 -> 116
    //   543: astore_0
    //   544: aconst_null
    //   545: astore_1
    //   546: aconst_null
    //   547: astore 6
    //   549: aload 7
    //   551: ifnull +8 -> 559
    //   554: aload 7
    //   556: invokevirtual 194	java/util/zip/CheckedInputStream:close	()V
    //   559: aload 6
    //   561: ifnull +8 -> 569
    //   564: aload 6
    //   566: invokevirtual 197	java/io/InputStream:close	()V
    //   569: aload_1
    //   570: ifnull +7 -> 577
    //   573: aload_1
    //   574: invokevirtual 198	java/io/OutputStream:close	()V
    //   577: aload_0
    //   578: athrow
    //   579: astore_0
    //   580: aload_0
    //   581: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   584: bipush 6
    //   586: istore_2
    //   587: goto -360 -> 227
    //   590: astore_0
    //   591: aload_0
    //   592: invokevirtual 199	java/lang/Exception:printStackTrace	()V
    //   595: bipush 7
    //   597: istore_2
    //   598: goto -371 -> 227
    //   601: astore_1
    //   602: goto -123 -> 479
    //   605: astore_0
    //   606: goto -119 -> 487
    //   609: astore 6
    //   611: goto -93 -> 518
    //   614: astore_0
    //   615: goto -89 -> 526
    //   618: astore 7
    //   620: goto -61 -> 559
    //   623: astore 6
    //   625: goto -56 -> 569
    //   628: astore_1
    //   629: goto -52 -> 577
    //   632: astore 8
    //   634: aconst_null
    //   635: astore_1
    //   636: aload_0
    //   637: astore 6
    //   639: aload 8
    //   641: astore_0
    //   642: goto -93 -> 549
    //   645: astore 7
    //   647: aconst_null
    //   648: astore_1
    //   649: aload_0
    //   650: astore 8
    //   652: aload 7
    //   654: astore_0
    //   655: aload 6
    //   657: astore 7
    //   659: aload 8
    //   661: astore 6
    //   663: goto -114 -> 549
    //   666: astore 7
    //   668: aload 8
    //   670: astore_1
    //   671: aload_0
    //   672: astore 8
    //   674: aload 7
    //   676: astore_0
    //   677: aload 6
    //   679: astore 7
    //   681: aload 8
    //   683: astore 6
    //   685: goto -136 -> 549
    //   688: goto -461 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	691	0	paramString1	String
    //   0	691	1	paramString2	String
    //   117	481	2	i	int
    //   4	113	3	j	int
    //   380	36	4	l	long
    //   55	510	6	localObject1	Object
    //   609	1	6	localIOException1	java.io.IOException
    //   623	1	6	localIOException2	java.io.IOException
    //   637	47	6	localObject2	Object
    //   1	554	7	localObject3	Object
    //   618	1	7	localIOException3	java.io.IOException
    //   645	8	7	localObject4	Object
    //   657	1	7	localObject5	Object
    //   666	9	7	localObject6	Object
    //   679	1	7	localObject7	Object
    //   323	209	8	localObject8	Object
    //   632	8	8	localObject9	Object
    //   650	32	8	str	String
    //   88	185	9	localbelo	belo
    //   95	309	10	arrayOfByte	byte[]
    //   107	199	11	localStringBuilder	java.lang.StringBuilder
    //   114	15	12	localEnumeration	Enumeration
    //   138	318	13	localZipEntry	ZipEntry
    //   338	11	14	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   90	116	220	java/io/FileNotFoundException
    //   118	217	220	java/io/FileNotFoundException
    //   474	479	220	java/io/FileNotFoundException
    //   483	487	220	java/io/FileNotFoundException
    //   492	497	220	java/io/FileNotFoundException
    //   513	518	220	java/io/FileNotFoundException
    //   522	526	220	java/io/FileNotFoundException
    //   531	536	220	java/io/FileNotFoundException
    //   554	559	220	java/io/FileNotFoundException
    //   564	569	220	java/io/FileNotFoundException
    //   573	577	220	java/io/FileNotFoundException
    //   577	579	220	java/io/FileNotFoundException
    //   227	232	234	java/io/IOException
    //   80	90	242	java/util/zip/ZipException
    //   80	90	252	java/io/IOException
    //   80	90	262	java/lang/Exception
    //   492	497	502	java/io/IOException
    //   531	536	539	java/io/IOException
    //   272	280	543	finally
    //   90	116	579	java/io/IOException
    //   118	217	579	java/io/IOException
    //   577	579	579	java/io/IOException
    //   90	116	590	java/lang/Exception
    //   118	217	590	java/lang/Exception
    //   474	479	590	java/lang/Exception
    //   483	487	590	java/lang/Exception
    //   492	497	590	java/lang/Exception
    //   513	518	590	java/lang/Exception
    //   522	526	590	java/lang/Exception
    //   531	536	590	java/lang/Exception
    //   554	559	590	java/lang/Exception
    //   564	569	590	java/lang/Exception
    //   573	577	590	java/lang/Exception
    //   577	579	590	java/lang/Exception
    //   474	479	601	java/io/IOException
    //   483	487	605	java/io/IOException
    //   513	518	609	java/io/IOException
    //   522	526	614	java/io/IOException
    //   554	559	618	java/io/IOException
    //   564	569	623	java/io/IOException
    //   573	577	628	java/io/IOException
    //   280	297	632	finally
    //   297	354	645	finally
    //   354	375	645	finally
    //   375	382	666	finally
    //   389	410	666	finally
    //   420	439	666	finally
    //   441	469	666	finally
  }
  
  public static long a(String paramString)
  {
    long l2;
    if (TextUtils.isEmpty(paramString)) {
      l2 = -1L;
    }
    for (;;)
    {
      return l2;
      try
      {
        paramString = new ZipFile(paramString).entries();
        long l1 = 0L;
        l2 = l1;
        if (!paramString.hasMoreElements()) {
          continue;
        }
        ZipEntry localZipEntry = (ZipEntry)paramString.nextElement();
        if (!localZipEntry.isDirectory())
        {
          l2 = localZipEntry.getSize();
          l1 = l2 + l1;
        }
        for (;;)
        {
          break;
        }
      }
      catch (Exception paramString)
      {
        return -1L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bemb
 * JD-Core Version:    0.7.0.1
 */