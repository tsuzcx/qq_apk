import java.io.File;
import java.io.FileOutputStream;

public class bgoa
{
  private static void a(File paramFile, byte[] paramArrayOfByte)
  {
    if ((!paramFile.getParentFile().exists()) && (!paramFile.getParentFile().mkdirs())) {
      throw new RuntimeException("Create folder fail:" + paramFile.getParentFile().getAbsolutePath());
    }
    paramFile = new FileOutputStream(paramFile);
    try
    {
      paramFile.write(paramArrayOfByte);
      return;
    }
    finally
    {
      paramFile.close();
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = a(paramString1, paramString2, "");
      return bool;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      boolean bool = a(paramString1, paramString2, paramString3, false);
      return bool;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 71	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +14 -> 21
    //   10: aload_1
    //   11: invokestatic 71	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: istore 4
    //   16: iload 4
    //   18: ifeq +10 -> 28
    //   21: iconst_0
    //   22: istore_3
    //   23: ldc 2
    //   25: monitorexit
    //   26: iload_3
    //   27: ireturn
    //   28: new 8	java/io/File
    //   31: dup
    //   32: aload_1
    //   33: aload_2
    //   34: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: invokevirtual 16	java/io/File:exists	()Z
    //   40: ifeq +8 -> 48
    //   43: iconst_1
    //   44: istore_3
    //   45: goto -22 -> 23
    //   48: aload_0
    //   49: aload_1
    //   50: aload_2
    //   51: iload_3
    //   52: invokestatic 77	bgoa:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   55: istore_3
    //   56: goto -33 -> 23
    //   59: astore_0
    //   60: ldc 2
    //   62: monitorexit
    //   63: aload_0
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramString1	String
    //   0	65	1	paramString2	String
    //   0	65	2	paramString3	String
    //   0	65	3	paramBoolean	boolean
    //   14	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	16	59	finally
    //   28	43	59	finally
    //   48	56	59	finally
  }
  
  private static boolean b(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (!new File(paramString1).exists()) {}
    do
    {
      String str1;
      do
      {
        String str2;
        do
        {
          return false;
          str1 = new File(paramString2, paramString3).getAbsolutePath();
          str2 = str1 + "Tmp";
          bgpc.a(str2, false);
        } while (!c(paramString1, paramString2, paramString3, paramBoolean));
        paramString2 = new File(str2);
      } while (!paramString2.exists());
      paramString3 = new File(str1);
      bgpc.a(str1, false);
    } while ((!bgpc.a(paramString2, paramString3)) || (!paramString3.exists()));
    bgpc.a(paramString1, true);
    return true;
  }
  
  /* Error */
  private static boolean c(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 71	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +10 -> 14
    //   7: aload_1
    //   8: invokestatic 71	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_2
    //   17: invokestatic 71	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +80 -> 100
    //   23: new 23	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   30: new 8	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: invokevirtual 37	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   41: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 80
    //   46: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore_1
    //   53: aload_2
    //   54: astore 7
    //   56: aconst_null
    //   57: astore 8
    //   59: new 95	java/io/RandomAccessFile
    //   62: dup
    //   63: aload_0
    //   64: ldc 97
    //   66: invokespecial 98	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: astore_2
    //   70: aload_2
    //   71: invokevirtual 102	java/io/RandomAccessFile:readByte	()B
    //   74: bipush 190
    //   76: if_icmpeq +40 -> 116
    //   79: new 21	java/lang/RuntimeException
    //   82: dup
    //   83: ldc 104
    //   85: invokespecial 43	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   88: athrow
    //   89: astore_0
    //   90: aload_2
    //   91: ifnull +7 -> 98
    //   94: aload_2
    //   95: invokevirtual 105	java/io/RandomAccessFile:close	()V
    //   98: iconst_0
    //   99: ireturn
    //   100: new 8	java/io/File
    //   103: dup
    //   104: aload_2
    //   105: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: invokevirtual 37	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   111: astore 7
    //   113: goto -57 -> 56
    //   116: aload_2
    //   117: ldc2_w 106
    //   120: invokevirtual 111	java/io/RandomAccessFile:seek	(J)V
    //   123: aload_2
    //   124: invokevirtual 115	java/io/RandomAccessFile:readInt	()I
    //   127: istore 5
    //   129: new 117	java/util/ArrayList
    //   132: dup
    //   133: iload 5
    //   135: invokespecial 120	java/util/ArrayList:<init>	(I)V
    //   138: astore 9
    //   140: iconst_0
    //   141: istore 4
    //   143: iload 4
    //   145: iload 5
    //   147: if_icmpge +219 -> 366
    //   150: aload_2
    //   151: invokevirtual 115	java/io/RandomAccessFile:readInt	()I
    //   154: istore 6
    //   156: iload 6
    //   158: newarray byte
    //   160: astore_0
    //   161: aload_2
    //   162: aload_0
    //   163: iconst_0
    //   164: iload 6
    //   166: invokevirtual 124	java/io/RandomAccessFile:read	([BII)I
    //   169: pop
    //   170: new 8	java/io/File
    //   173: dup
    //   174: new 126	java/lang/String
    //   177: dup
    //   178: aload_0
    //   179: iconst_0
    //   180: iload 6
    //   182: invokespecial 129	java/lang/String:<init>	([BII)V
    //   185: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   188: invokevirtual 37	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   191: astore 8
    //   193: aload 8
    //   195: astore_0
    //   196: aload 7
    //   198: invokestatic 71	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   201: ifne +58 -> 259
    //   204: aload 8
    //   206: aload 7
    //   208: invokevirtual 133	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   211: ifne +124 -> 335
    //   214: iload_3
    //   215: ifeq +110 -> 325
    //   218: aload 7
    //   220: aload 8
    //   222: invokevirtual 133	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   225: ifne +13 -> 238
    //   228: aload 7
    //   230: aload 8
    //   232: invokevirtual 136	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   235: ifeq +55 -> 290
    //   238: new 23	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   245: aload 7
    //   247: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc 80
    //   252: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: astore_0
    //   259: aload 9
    //   261: new 138	bgob
    //   264: dup
    //   265: aload_0
    //   266: aload_2
    //   267: invokevirtual 115	java/io/RandomAccessFile:readInt	()I
    //   270: aload_2
    //   271: invokevirtual 115	java/io/RandomAccessFile:readInt	()I
    //   274: invokespecial 141	bgob:<init>	(Ljava/lang/String;II)V
    //   277: invokevirtual 145	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   280: pop
    //   281: iload 4
    //   283: iconst_1
    //   284: iadd
    //   285: istore 4
    //   287: goto -144 -> 143
    //   290: new 23	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   297: aload 7
    //   299: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: ldc 80
    //   304: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: getstatic 149	java/io/File:separator	Ljava/lang/String;
    //   310: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload 8
    //   315: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: astore_0
    //   322: goto -63 -> 259
    //   325: aload_2
    //   326: ifnull +7 -> 333
    //   329: aload_2
    //   330: invokevirtual 105	java/io/RandomAccessFile:close	()V
    //   333: iconst_0
    //   334: ireturn
    //   335: aload 8
    //   337: aload 7
    //   339: new 23	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   346: aload 7
    //   348: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: ldc 80
    //   353: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokevirtual 153	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   362: astore_0
    //   363: goto -104 -> 259
    //   366: aload 9
    //   368: invokevirtual 157	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   371: astore_0
    //   372: aload_0
    //   373: invokeinterface 162 1 0
    //   378: ifeq +82 -> 460
    //   381: aload_0
    //   382: invokeinterface 166 1 0
    //   387: checkcast 138	bgob
    //   390: astore 7
    //   392: new 8	java/io/File
    //   395: dup
    //   396: aload_1
    //   397: aload 7
    //   399: getfield 168	bgob:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   402: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   405: astore 8
    //   407: aload_2
    //   408: aload 7
    //   410: getfield 171	bgob:jdField_a_of_type_Int	I
    //   413: i2l
    //   414: invokevirtual 111	java/io/RandomAccessFile:seek	(J)V
    //   417: aload 7
    //   419: getfield 173	bgob:b	I
    //   422: newarray byte
    //   424: astore 9
    //   426: aload_2
    //   427: aload 9
    //   429: iconst_0
    //   430: aload 7
    //   432: getfield 173	bgob:b	I
    //   435: invokevirtual 124	java/io/RandomAccessFile:read	([BII)I
    //   438: pop
    //   439: aload 8
    //   441: aload 9
    //   443: invokestatic 175	bgoa:a	(Ljava/io/File;[B)V
    //   446: goto -74 -> 372
    //   449: astore_0
    //   450: aload_2
    //   451: ifnull +7 -> 458
    //   454: aload_2
    //   455: invokevirtual 105	java/io/RandomAccessFile:close	()V
    //   458: aload_0
    //   459: athrow
    //   460: aload_2
    //   461: ifnull +7 -> 468
    //   464: aload_2
    //   465: invokevirtual 105	java/io/RandomAccessFile:close	()V
    //   468: iconst_1
    //   469: ireturn
    //   470: astore_0
    //   471: goto -138 -> 333
    //   474: astore_0
    //   475: goto -7 -> 468
    //   478: astore_0
    //   479: goto -381 -> 98
    //   482: astore_1
    //   483: goto -25 -> 458
    //   486: astore_0
    //   487: aconst_null
    //   488: astore_2
    //   489: goto -39 -> 450
    //   492: astore_0
    //   493: aload 8
    //   495: astore_2
    //   496: goto -406 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	499	0	paramString1	String
    //   0	499	1	paramString2	String
    //   0	499	2	paramString3	String
    //   0	499	3	paramBoolean	boolean
    //   141	145	4	i	int
    //   127	21	5	j	int
    //   154	27	6	k	int
    //   54	377	7	localObject1	Object
    //   57	437	8	localObject2	Object
    //   138	304	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   70	89	89	java/lang/Exception
    //   116	140	89	java/lang/Exception
    //   150	193	89	java/lang/Exception
    //   196	214	89	java/lang/Exception
    //   218	238	89	java/lang/Exception
    //   238	259	89	java/lang/Exception
    //   259	281	89	java/lang/Exception
    //   290	322	89	java/lang/Exception
    //   335	363	89	java/lang/Exception
    //   366	372	89	java/lang/Exception
    //   372	446	89	java/lang/Exception
    //   70	89	449	finally
    //   116	140	449	finally
    //   150	193	449	finally
    //   196	214	449	finally
    //   218	238	449	finally
    //   238	259	449	finally
    //   259	281	449	finally
    //   290	322	449	finally
    //   335	363	449	finally
    //   366	372	449	finally
    //   372	446	449	finally
    //   329	333	470	java/lang/Exception
    //   464	468	474	java/lang/Exception
    //   94	98	478	java/lang/Exception
    //   454	458	482	java/lang/Exception
    //   59	70	486	finally
    //   59	70	492	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgoa
 * JD-Core Version:    0.7.0.1
 */