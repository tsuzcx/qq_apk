package com.tencent.map.sdk.a;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public final class om
{
  public static File a;
  private static final oy b = new oy();
  
  public static File a(File paramFile, String paramString)
  {
    if ((paramFile != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramFile = new File(paramFile, paramString);
      paramFile.mkdirs();
      return paramFile;
    }
    return null;
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    try
    {
      String str = paramContext.getPackageName();
      if (str != null)
      {
        if (str.length() == 0) {
          return "";
        }
        paramContext = str;
        if (str.length() > 255) {
          paramContext = str.substring(0, 254);
        }
        return paramContext;
      }
      return "";
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  /* Error */
  public static String a(File paramFile, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnull +124 -> 128
    //   7: aload_0
    //   8: invokevirtual 66	java/io/File:exists	()Z
    //   11: ifeq +117 -> 128
    //   14: iload_1
    //   15: iconst_m1
    //   16: if_icmpne +5 -> 21
    //   19: aconst_null
    //   20: areturn
    //   21: new 68	java/io/BufferedReader
    //   24: dup
    //   25: new 70	java/io/FileReader
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 73	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   33: invokespecial 76	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   36: astore_3
    //   37: iconst_0
    //   38: istore_2
    //   39: aload_3
    //   40: astore_0
    //   41: aload_3
    //   42: invokevirtual 79	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   45: astore 4
    //   47: aload_3
    //   48: astore_0
    //   49: aload 4
    //   51: ifnull +64 -> 115
    //   54: iload_2
    //   55: iload_1
    //   56: if_icmpne +10 -> 66
    //   59: aload_3
    //   60: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   63: aload 4
    //   65: areturn
    //   66: iload_2
    //   67: iconst_1
    //   68: iadd
    //   69: istore_2
    //   70: goto -31 -> 39
    //   73: astore 4
    //   75: goto +19 -> 94
    //   78: astore 4
    //   80: goto +26 -> 106
    //   83: astore_3
    //   84: aload 4
    //   86: astore_0
    //   87: goto +35 -> 122
    //   90: astore 4
    //   92: aconst_null
    //   93: astore_3
    //   94: aload_3
    //   95: astore_0
    //   96: aload 4
    //   98: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   101: aload_3
    //   102: astore_0
    //   103: goto +12 -> 115
    //   106: aload_3
    //   107: astore_0
    //   108: aload 4
    //   110: invokevirtual 86	java/io/FileNotFoundException:printStackTrace	()V
    //   113: aload_3
    //   114: astore_0
    //   115: aload_0
    //   116: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   119: aconst_null
    //   120: areturn
    //   121: astore_3
    //   122: aload_0
    //   123: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   126: aload_3
    //   127: athrow
    //   128: aconst_null
    //   129: areturn
    //   130: astore 4
    //   132: aconst_null
    //   133: astore_3
    //   134: goto -28 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramFile	File
    //   0	137	1	paramInt	int
    //   38	32	2	i	int
    //   36	24	3	localBufferedReader	java.io.BufferedReader
    //   83	1	3	localObject1	Object
    //   93	21	3	localObject2	Object
    //   121	6	3	localObject3	Object
    //   133	1	3	localObject4	Object
    //   1	63	4	str	String
    //   73	1	4	localIOException1	IOException
    //   78	7	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   90	19	4	localIOException2	IOException
    //   130	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   41	47	73	java/io/IOException
    //   41	47	78	java/io/FileNotFoundException
    //   21	37	83	finally
    //   21	37	90	java/io/IOException
    //   41	47	121	finally
    //   96	101	121	finally
    //   108	113	121	finally
    //   21	37	130	java/io/FileNotFoundException
  }
  
  /* Error */
  public static void a(File paramFile, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +516 -> 517
    //   4: aload_0
    //   5: invokevirtual 66	java/io/File:exists	()Z
    //   8: ifeq +509 -> 517
    //   11: iload_1
    //   12: iconst_m1
    //   13: if_icmpne +4 -> 17
    //   16: return
    //   17: aconst_null
    //   18: astore 10
    //   20: aconst_null
    //   21: astore 8
    //   23: new 89	java/io/RandomAccessFile
    //   26: dup
    //   27: aload_0
    //   28: ldc 91
    //   30: invokespecial 92	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   33: astore 9
    //   35: aload_0
    //   36: ifnull +122 -> 158
    //   39: aload_0
    //   40: invokevirtual 96	java/io/File:getParentFile	()Ljava/io/File;
    //   43: astore_0
    //   44: new 98	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   51: astore 8
    //   53: getstatic 17	com/tencent/map/sdk/a/om:b	Lcom/tencent/map/sdk/a/oy;
    //   56: astore 10
    //   58: new 98	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   65: astore 11
    //   67: aload 11
    //   69: invokestatic 105	java/lang/System:currentTimeMillis	()J
    //   72: invokevirtual 109	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 8
    //   78: aload 10
    //   80: aload 11
    //   82: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokevirtual 115	com/tencent/map/sdk/a/oy:a	(Ljava/lang/String;)Ljava/lang/String;
    //   88: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 8
    //   94: ldc 120
    //   96: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_0
    //   101: aload 8
    //   103: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 122	com/tencent/map/sdk/a/om:b	(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   109: astore_0
    //   110: goto +50 -> 160
    //   113: astore_0
    //   114: aconst_null
    //   115: astore 8
    //   117: aload 8
    //   119: astore_2
    //   120: goto +380 -> 500
    //   123: astore 8
    //   125: aconst_null
    //   126: astore 10
    //   128: aload 10
    //   130: astore_2
    //   131: aload 9
    //   133: astore_0
    //   134: aload 10
    //   136: astore 9
    //   138: aload 8
    //   140: astore 12
    //   142: goto +286 -> 428
    //   145: astore 8
    //   147: aconst_null
    //   148: astore_0
    //   149: aload_0
    //   150: astore_2
    //   151: aload 8
    //   153: astore 12
    //   155: goto +312 -> 467
    //   158: aconst_null
    //   159: astore_0
    //   160: new 89	java/io/RandomAccessFile
    //   163: dup
    //   164: aload_0
    //   165: ldc 91
    //   167: invokespecial 92	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   170: astore 8
    //   172: lconst_0
    //   173: lstore 4
    //   175: iconst_0
    //   176: istore_3
    //   177: aload 9
    //   179: invokevirtual 123	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   182: astore 10
    //   184: aload 10
    //   186: ifnull +54 -> 240
    //   189: iload_3
    //   190: iload_1
    //   191: if_icmpne +21 -> 212
    //   194: aload 9
    //   196: invokevirtual 126	java/io/RandomAccessFile:getFilePointer	()J
    //   199: ldc 128
    //   201: invokevirtual 132	java/lang/String:getBytes	()[B
    //   204: arraylength
    //   205: i2l
    //   206: lsub
    //   207: lstore 6
    //   209: goto +309 -> 518
    //   212: lload 4
    //   214: lstore 6
    //   216: iload_3
    //   217: iload_1
    //   218: if_icmple +300 -> 518
    //   221: aload 8
    //   223: aload 10
    //   225: ldc 134
    //   227: invokevirtual 137	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   230: invokevirtual 141	java/io/RandomAccessFile:write	([B)V
    //   233: lload 4
    //   235: lstore 6
    //   237: goto +281 -> 518
    //   240: aload 9
    //   242: lload 4
    //   244: invokevirtual 145	java/io/RandomAccessFile:seek	(J)V
    //   247: new 98	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   254: astore 10
    //   256: aload 10
    //   258: aload_2
    //   259: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 10
    //   265: ldc 128
    //   267: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 9
    //   273: aload 10
    //   275: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokevirtual 132	java/lang/String:getBytes	()[B
    //   281: invokevirtual 141	java/io/RandomAccessFile:write	([B)V
    //   284: aload 8
    //   286: lconst_0
    //   287: invokevirtual 145	java/io/RandomAccessFile:seek	(J)V
    //   290: aload 8
    //   292: invokevirtual 123	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   295: astore_2
    //   296: aload_2
    //   297: ifnull +17 -> 314
    //   300: aload 9
    //   302: aload_2
    //   303: ldc 134
    //   305: invokevirtual 137	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   308: invokevirtual 141	java/io/RandomAccessFile:write	([B)V
    //   311: goto -21 -> 290
    //   314: aload 9
    //   316: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   319: aload 8
    //   321: astore_2
    //   322: aload_2
    //   323: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   326: aload_0
    //   327: invokestatic 148	com/tencent/map/sdk/a/om:b	(Ljava/io/File;)Z
    //   330: pop
    //   331: return
    //   332: astore 10
    //   334: aload 8
    //   336: astore_2
    //   337: aload_0
    //   338: astore 8
    //   340: aload 10
    //   342: astore_0
    //   343: goto +157 -> 500
    //   346: astore 11
    //   348: aload 8
    //   350: astore_2
    //   351: aload_0
    //   352: astore 10
    //   354: aload 11
    //   356: astore 8
    //   358: goto -227 -> 131
    //   361: astore 10
    //   363: aload 8
    //   365: astore_2
    //   366: aload 10
    //   368: astore 8
    //   370: goto -219 -> 151
    //   373: astore 10
    //   375: aconst_null
    //   376: astore_2
    //   377: aload_0
    //   378: astore 8
    //   380: aload 10
    //   382: astore_0
    //   383: goto +117 -> 500
    //   386: astore 8
    //   388: aconst_null
    //   389: astore_2
    //   390: aload_0
    //   391: astore 10
    //   393: goto -262 -> 131
    //   396: astore 8
    //   398: aconst_null
    //   399: astore_2
    //   400: goto -249 -> 151
    //   403: astore_0
    //   404: aconst_null
    //   405: astore 8
    //   407: aload 8
    //   409: astore 9
    //   411: aload 9
    //   413: astore_2
    //   414: goto +86 -> 500
    //   417: astore 12
    //   419: aconst_null
    //   420: astore 9
    //   422: aload 9
    //   424: astore_2
    //   425: aload 8
    //   427: astore_0
    //   428: aload_0
    //   429: astore 11
    //   431: aload_2
    //   432: astore 10
    //   434: aload 9
    //   436: astore 8
    //   438: aload 12
    //   440: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   443: aload_0
    //   444: astore 8
    //   446: aload 8
    //   448: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   451: aload 9
    //   453: astore_0
    //   454: goto -132 -> 322
    //   457: astore 12
    //   459: aconst_null
    //   460: astore_0
    //   461: aload_0
    //   462: astore_2
    //   463: aload 10
    //   465: astore 9
    //   467: aload 9
    //   469: astore 11
    //   471: aload_2
    //   472: astore 10
    //   474: aload_0
    //   475: astore 8
    //   477: aload 12
    //   479: invokevirtual 86	java/io/FileNotFoundException:printStackTrace	()V
    //   482: aload 9
    //   484: astore 8
    //   486: aload_0
    //   487: astore 9
    //   489: goto -43 -> 446
    //   492: astore_0
    //   493: aload 11
    //   495: astore 9
    //   497: aload 10
    //   499: astore_2
    //   500: aload 9
    //   502: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   505: aload_2
    //   506: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   509: aload 8
    //   511: invokestatic 148	com/tencent/map/sdk/a/om:b	(Ljava/io/File;)Z
    //   514: pop
    //   515: aload_0
    //   516: athrow
    //   517: return
    //   518: iload_3
    //   519: iconst_1
    //   520: iadd
    //   521: istore_3
    //   522: lload 6
    //   524: lstore 4
    //   526: goto -349 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	529	0	paramFile	File
    //   0	529	1	paramInt	int
    //   0	529	2	paramString	String
    //   176	346	3	i	int
    //   173	352	4	l1	long
    //   207	316	6	l2	long
    //   21	97	8	localStringBuilder1	StringBuilder
    //   123	16	8	localIOException1	IOException
    //   145	7	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   170	209	8	localObject1	Object
    //   386	1	8	localIOException2	IOException
    //   396	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   405	105	8	localObject2	Object
    //   33	468	9	localObject3	Object
    //   18	256	10	localObject4	Object
    //   332	9	10	localObject5	Object
    //   352	1	10	localFile	File
    //   361	6	10	localFileNotFoundException3	java.io.FileNotFoundException
    //   373	8	10	localObject6	Object
    //   391	107	10	localObject7	Object
    //   65	16	11	localStringBuilder2	StringBuilder
    //   346	9	11	localIOException3	IOException
    //   429	65	11	localObject8	Object
    //   140	14	12	localObject9	Object
    //   417	22	12	localIOException4	IOException
    //   457	21	12	localFileNotFoundException4	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   39	110	113	finally
    //   39	110	123	java/io/IOException
    //   39	110	145	java/io/FileNotFoundException
    //   177	184	332	finally
    //   194	209	332	finally
    //   221	233	332	finally
    //   240	290	332	finally
    //   290	296	332	finally
    //   300	311	332	finally
    //   177	184	346	java/io/IOException
    //   194	209	346	java/io/IOException
    //   221	233	346	java/io/IOException
    //   240	290	346	java/io/IOException
    //   290	296	346	java/io/IOException
    //   300	311	346	java/io/IOException
    //   177	184	361	java/io/FileNotFoundException
    //   194	209	361	java/io/FileNotFoundException
    //   221	233	361	java/io/FileNotFoundException
    //   240	290	361	java/io/FileNotFoundException
    //   290	296	361	java/io/FileNotFoundException
    //   300	311	361	java/io/FileNotFoundException
    //   160	172	373	finally
    //   160	172	386	java/io/IOException
    //   160	172	396	java/io/FileNotFoundException
    //   23	35	403	finally
    //   23	35	417	java/io/IOException
    //   23	35	457	java/io/FileNotFoundException
    //   438	443	492	finally
    //   477	482	492	finally
  }
  
  public static boolean a(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    if (paramFile.exists()) {
      return true;
    }
    File localFile = paramFile.getParentFile();
    if (localFile == null) {
      return false;
    }
    if ((!localFile.exists()) && (!localFile.mkdirs())) {
      return false;
    }
    try
    {
      boolean bool = paramFile.createNewFile();
      return bool;
    }
    catch (IOException paramFile)
    {
      paramFile.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  public static boolean a(File paramFile, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: ifnonnull +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: invokestatic 154	com/tencent/map/sdk/a/om:a	(Ljava/io/File;)Z
    //   12: ifne +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: aconst_null
    //   18: astore 4
    //   20: aconst_null
    //   21: astore 5
    //   23: aconst_null
    //   24: astore_3
    //   25: new 156	java/io/FileOutputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 157	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   33: astore_0
    //   34: aload_0
    //   35: aload_1
    //   36: invokevirtual 158	java/io/FileOutputStream:write	([B)V
    //   39: iconst_1
    //   40: istore_2
    //   41: aload_0
    //   42: invokevirtual 161	java/io/FileOutputStream:close	()V
    //   45: iconst_1
    //   46: ireturn
    //   47: astore_0
    //   48: aload_0
    //   49: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   52: iload_2
    //   53: ireturn
    //   54: astore_1
    //   55: aload_0
    //   56: astore_3
    //   57: aload_1
    //   58: astore_0
    //   59: goto +55 -> 114
    //   62: astore_1
    //   63: goto +15 -> 78
    //   66: astore_1
    //   67: goto +31 -> 98
    //   70: astore_0
    //   71: goto +43 -> 114
    //   74: astore_1
    //   75: aload 4
    //   77: astore_0
    //   78: aload_0
    //   79: astore_3
    //   80: aload_1
    //   81: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   84: aload_0
    //   85: ifnull +27 -> 112
    //   88: aload_0
    //   89: invokevirtual 161	java/io/FileOutputStream:close	()V
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_1
    //   95: aload 5
    //   97: astore_0
    //   98: aload_0
    //   99: astore_3
    //   100: aload_1
    //   101: invokevirtual 86	java/io/FileNotFoundException:printStackTrace	()V
    //   104: aload_0
    //   105: ifnull +7 -> 112
    //   108: aload_0
    //   109: invokevirtual 161	java/io/FileOutputStream:close	()V
    //   112: iconst_0
    //   113: ireturn
    //   114: aload_3
    //   115: ifnull +15 -> 130
    //   118: aload_3
    //   119: invokevirtual 161	java/io/FileOutputStream:close	()V
    //   122: goto +8 -> 130
    //   125: astore_1
    //   126: aload_1
    //   127: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   130: aload_0
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramFile	File
    //   0	132	1	paramArrayOfByte	byte[]
    //   1	52	2	bool	boolean
    //   24	95	3	localFile	File
    //   18	58	4	localObject1	Object
    //   21	75	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   41	45	47	java/io/IOException
    //   88	92	47	java/io/IOException
    //   108	112	47	java/io/IOException
    //   34	39	54	finally
    //   34	39	62	java/io/IOException
    //   34	39	66	java/io/FileNotFoundException
    //   25	34	70	finally
    //   80	84	70	finally
    //   100	104	70	finally
    //   25	34	74	java/io/IOException
    //   25	34	94	java/io/FileNotFoundException
    //   118	122	125	java/io/IOException
  }
  
  public static boolean a(String paramString)
  {
    return a(new File(paramString));
  }
  
  public static File b(File paramFile, String paramString)
  {
    File localFile = null;
    if (paramFile != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      int i = paramString.lastIndexOf(File.separator);
      localFile = paramFile;
      String str = paramString;
      if (i != -1)
      {
        str = paramString.substring(i + 1);
        localFile = new File(paramFile, paramString.substring(0, i));
      }
      if ((!localFile.exists()) && (!localFile.mkdirs()))
      {
        paramFile = new StringBuilder("FileUtil create file failed with mkdirs failed:");
        paramFile.append(localFile.getAbsolutePath());
        or.b(paramFile.toString());
        return null;
      }
      paramFile = new File(localFile, str);
      localFile = paramFile;
      try
      {
        if (!paramFile.exists())
        {
          localFile = paramFile;
          if (!paramFile.createNewFile())
          {
            paramString = new StringBuilder("FileUtil create file failed:");
            paramString.append(paramFile.getAbsolutePath());
            or.b(paramString.toString());
            return paramFile;
          }
        }
      }
      catch (IOException paramString)
      {
        or.b("FileUtil create file failed.", paramString);
        localFile = paramFile;
      }
    }
    return localFile;
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    String str = paramString.trim();
    paramString = str;
    if (str.contains("../")) {}
    for (paramString = str.replaceAll("\\.\\./", "");; paramString = paramString.substring(1))
    {
      str = paramString;
      if (!paramString.startsWith(File.separator)) {
        break;
      }
    }
    while (str.endsWith(File.separator)) {
      str = str.substring(0, str.length() - 1);
    }
    return str;
  }
  
  public static boolean b(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      Stack localStack = new Stack();
      localStack.push(paramFile);
      boolean bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (localStack.isEmpty()) {
          break;
        }
        paramFile = (File)localStack.peek();
        if (paramFile.isFile())
        {
          bool1 = paramFile.delete();
          localStack.pop();
        }
        else if (paramFile.isDirectory())
        {
          File[] arrayOfFile = paramFile.listFiles();
          if (arrayOfFile.length == 0)
          {
            bool1 = paramFile.delete();
            localStack.pop();
          }
          else
          {
            int j = arrayOfFile.length;
            int i = 0;
            while (i < j)
            {
              localStack.push(arrayOfFile[i]);
              i += 1;
            }
          }
        }
      }
    }
    boolean bool2 = false;
    return bool2;
  }
  
  /* Error */
  public static void c(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +127 -> 128
    //   4: aload_0
    //   5: invokevirtual 66	java/io/File:exists	()Z
    //   8: ifne +4 -> 12
    //   11: return
    //   12: aconst_null
    //   13: astore_3
    //   14: aconst_null
    //   15: astore 4
    //   17: aconst_null
    //   18: astore_2
    //   19: new 89	java/io/RandomAccessFile
    //   22: dup
    //   23: aload_0
    //   24: ldc 91
    //   26: invokespecial 92	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   29: astore_0
    //   30: aload_0
    //   31: aload_0
    //   32: invokevirtual 245	java/io/RandomAccessFile:length	()J
    //   35: invokevirtual 145	java/io/RandomAccessFile:seek	(J)V
    //   38: new 98	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   45: astore_2
    //   46: aload_2
    //   47: aload_1
    //   48: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_2
    //   53: ldc 128
    //   55: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_0
    //   60: aload_2
    //   61: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokevirtual 132	java/lang/String:getBytes	()[B
    //   67: invokevirtual 141	java/io/RandomAccessFile:write	([B)V
    //   70: aload_0
    //   71: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   74: return
    //   75: astore_1
    //   76: goto +46 -> 122
    //   79: astore_1
    //   80: goto +16 -> 96
    //   83: astore_1
    //   84: goto +27 -> 111
    //   87: astore_1
    //   88: aload_2
    //   89: astore_0
    //   90: goto +32 -> 122
    //   93: astore_1
    //   94: aload_3
    //   95: astore_0
    //   96: aload_0
    //   97: astore_2
    //   98: aload_1
    //   99: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   102: aload_0
    //   103: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   106: return
    //   107: astore_1
    //   108: aload 4
    //   110: astore_0
    //   111: aload_0
    //   112: astore_2
    //   113: aload_1
    //   114: invokevirtual 86	java/io/FileNotFoundException:printStackTrace	()V
    //   117: aload_0
    //   118: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   121: return
    //   122: aload_0
    //   123: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   126: aload_1
    //   127: athrow
    //   128: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramFile	File
    //   0	129	1	paramString	String
    //   18	95	2	localObject1	Object
    //   13	82	3	localObject2	Object
    //   15	94	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   30	70	75	finally
    //   30	70	79	java/io/IOException
    //   30	70	83	java/io/FileNotFoundException
    //   19	30	87	finally
    //   98	102	87	finally
    //   113	117	87	finally
    //   19	30	93	java/io/IOException
    //   19	30	107	java/io/FileNotFoundException
  }
  
  /* Error */
  public static byte[] c(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +331 -> 332
    //   4: aload_0
    //   5: invokevirtual 66	java/io/File:exists	()Z
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 248	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 249	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: astore_0
    //   22: new 251	java/io/ByteArrayOutputStream
    //   25: dup
    //   26: invokespecial 252	java/io/ByteArrayOutputStream:<init>	()V
    //   29: astore 4
    //   31: aload_0
    //   32: astore_2
    //   33: aload 4
    //   35: astore_3
    //   36: sipush 1024
    //   39: newarray byte
    //   41: astore 5
    //   43: aload_0
    //   44: astore_2
    //   45: aload 4
    //   47: astore_3
    //   48: aload_0
    //   49: aload 5
    //   51: invokevirtual 256	java/io/FileInputStream:read	([B)I
    //   54: istore_1
    //   55: iload_1
    //   56: iconst_m1
    //   57: if_icmpeq +20 -> 77
    //   60: aload_0
    //   61: astore_2
    //   62: aload 4
    //   64: astore_3
    //   65: aload 4
    //   67: aload 5
    //   69: iconst_0
    //   70: iload_1
    //   71: invokevirtual 259	java/io/ByteArrayOutputStream:write	([BII)V
    //   74: goto -31 -> 43
    //   77: aload_0
    //   78: astore_2
    //   79: aload 4
    //   81: astore_3
    //   82: aload 4
    //   84: invokevirtual 262	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   87: astore 5
    //   89: aload 4
    //   91: invokevirtual 265	java/io/ByteArrayOutputStream:flush	()V
    //   94: aload 4
    //   96: invokevirtual 266	java/io/ByteArrayOutputStream:close	()V
    //   99: goto +8 -> 107
    //   102: astore_2
    //   103: aload_2
    //   104: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   107: aload_0
    //   108: invokevirtual 267	java/io/FileInputStream:close	()V
    //   111: aload 5
    //   113: areturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   119: aload 5
    //   121: areturn
    //   122: astore 6
    //   124: aload_0
    //   125: astore 5
    //   127: aload 4
    //   129: astore_0
    //   130: goto +59 -> 189
    //   133: astore 6
    //   135: aload_0
    //   136: astore 5
    //   138: aload 4
    //   140: astore_0
    //   141: goto +97 -> 238
    //   144: astore_2
    //   145: aconst_null
    //   146: astore_3
    //   147: goto +147 -> 294
    //   150: astore 6
    //   152: aconst_null
    //   153: astore_2
    //   154: aload_0
    //   155: astore 5
    //   157: aload_2
    //   158: astore_0
    //   159: goto +30 -> 189
    //   162: astore 6
    //   164: aconst_null
    //   165: astore_2
    //   166: aload_0
    //   167: astore 5
    //   169: aload_2
    //   170: astore_0
    //   171: goto +67 -> 238
    //   174: astore_2
    //   175: aconst_null
    //   176: astore_0
    //   177: aload_0
    //   178: astore_3
    //   179: goto +115 -> 294
    //   182: astore 6
    //   184: aconst_null
    //   185: astore_0
    //   186: aload_0
    //   187: astore 5
    //   189: aload 5
    //   191: astore_2
    //   192: aload_0
    //   193: astore_3
    //   194: aload 6
    //   196: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   199: aload_0
    //   200: ifnull +19 -> 219
    //   203: aload_0
    //   204: invokevirtual 265	java/io/ByteArrayOutputStream:flush	()V
    //   207: aload_0
    //   208: invokevirtual 266	java/io/ByteArrayOutputStream:close	()V
    //   211: goto +8 -> 219
    //   214: astore_0
    //   215: aload_0
    //   216: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   219: aload 5
    //   221: ifnull +64 -> 285
    //   224: aload 5
    //   226: invokevirtual 267	java/io/FileInputStream:close	()V
    //   229: aconst_null
    //   230: areturn
    //   231: astore 6
    //   233: aconst_null
    //   234: astore_0
    //   235: aload_0
    //   236: astore 5
    //   238: aload 5
    //   240: astore_2
    //   241: aload_0
    //   242: astore_3
    //   243: aload 6
    //   245: invokevirtual 86	java/io/FileNotFoundException:printStackTrace	()V
    //   248: aload_0
    //   249: ifnull +19 -> 268
    //   252: aload_0
    //   253: invokevirtual 265	java/io/ByteArrayOutputStream:flush	()V
    //   256: aload_0
    //   257: invokevirtual 266	java/io/ByteArrayOutputStream:close	()V
    //   260: goto +8 -> 268
    //   263: astore_0
    //   264: aload_0
    //   265: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   268: aload 5
    //   270: ifnull +15 -> 285
    //   273: aload 5
    //   275: invokevirtual 267	java/io/FileInputStream:close	()V
    //   278: aconst_null
    //   279: areturn
    //   280: astore_0
    //   281: aload_0
    //   282: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   285: aconst_null
    //   286: areturn
    //   287: astore 4
    //   289: aload_2
    //   290: astore_0
    //   291: aload 4
    //   293: astore_2
    //   294: aload_3
    //   295: ifnull +19 -> 314
    //   298: aload_3
    //   299: invokevirtual 265	java/io/ByteArrayOutputStream:flush	()V
    //   302: aload_3
    //   303: invokevirtual 266	java/io/ByteArrayOutputStream:close	()V
    //   306: goto +8 -> 314
    //   309: astore_3
    //   310: aload_3
    //   311: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   314: aload_0
    //   315: ifnull +15 -> 330
    //   318: aload_0
    //   319: invokevirtual 267	java/io/FileInputStream:close	()V
    //   322: goto +8 -> 330
    //   325: astore_0
    //   326: aload_0
    //   327: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   330: aload_2
    //   331: athrow
    //   332: aconst_null
    //   333: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	paramFile	File
    //   54	17	1	i	int
    //   32	47	2	localFile	File
    //   102	2	2	localIOException1	IOException
    //   144	1	2	localObject1	Object
    //   153	17	2	localObject2	Object
    //   174	1	2	localObject3	Object
    //   191	140	2	localObject4	Object
    //   35	268	3	localObject5	Object
    //   309	2	3	localIOException2	IOException
    //   29	110	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   287	5	4	localObject6	Object
    //   41	233	5	localObject7	Object
    //   122	1	6	localIOException3	IOException
    //   133	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   150	1	6	localIOException4	IOException
    //   162	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   182	13	6	localIOException5	IOException
    //   231	13	6	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   89	99	102	java/io/IOException
    //   107	111	114	java/io/IOException
    //   36	43	122	java/io/IOException
    //   48	55	122	java/io/IOException
    //   65	74	122	java/io/IOException
    //   82	89	122	java/io/IOException
    //   36	43	133	java/io/FileNotFoundException
    //   48	55	133	java/io/FileNotFoundException
    //   65	74	133	java/io/FileNotFoundException
    //   82	89	133	java/io/FileNotFoundException
    //   22	31	144	finally
    //   22	31	150	java/io/IOException
    //   22	31	162	java/io/FileNotFoundException
    //   13	22	174	finally
    //   13	22	182	java/io/IOException
    //   203	211	214	java/io/IOException
    //   13	22	231	java/io/FileNotFoundException
    //   252	260	263	java/io/IOException
    //   224	229	280	java/io/IOException
    //   273	278	280	java/io/IOException
    //   36	43	287	finally
    //   48	55	287	finally
    //   65	74	287	finally
    //   82	89	287	finally
    //   194	199	287	finally
    //   243	248	287	finally
    //   298	306	309	java/io/IOException
    //   318	322	325	java/io/IOException
  }
  
  /* Error */
  public static int d(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +135 -> 136
    //   4: aload_0
    //   5: invokevirtual 66	java/io/File:exists	()Z
    //   8: ifne +5 -> 13
    //   11: iconst_m1
    //   12: ireturn
    //   13: aconst_null
    //   14: astore 5
    //   16: aconst_null
    //   17: astore 6
    //   19: aconst_null
    //   20: astore 4
    //   22: new 68	java/io/BufferedReader
    //   25: dup
    //   26: new 70	java/io/FileReader
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 73	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   34: invokespecial 76	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore_0
    //   38: iconst_0
    //   39: istore_2
    //   40: aload_0
    //   41: invokevirtual 79	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore 4
    //   46: aload 4
    //   48: ifnull +27 -> 75
    //   51: aload 4
    //   53: aload_1
    //   54: invokevirtual 210	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   57: istore_3
    //   58: iload_3
    //   59: ifeq +9 -> 68
    //   62: aload_0
    //   63: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   66: iload_2
    //   67: ireturn
    //   68: iload_2
    //   69: iconst_1
    //   70: iadd
    //   71: istore_2
    //   72: goto -32 -> 40
    //   75: aload_0
    //   76: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   79: iconst_m1
    //   80: ireturn
    //   81: astore_1
    //   82: aload_0
    //   83: astore 4
    //   85: aload_1
    //   86: astore_0
    //   87: goto +42 -> 129
    //   90: astore_1
    //   91: goto +15 -> 106
    //   94: astore_1
    //   95: goto +21 -> 116
    //   98: astore_0
    //   99: goto +30 -> 129
    //   102: astore_1
    //   103: aload 5
    //   105: astore_0
    //   106: aload_0
    //   107: astore 4
    //   109: aload_1
    //   110: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   113: goto +10 -> 123
    //   116: aload_0
    //   117: astore 4
    //   119: aload_1
    //   120: invokevirtual 86	java/io/FileNotFoundException:printStackTrace	()V
    //   123: aload_0
    //   124: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   127: iconst_m1
    //   128: ireturn
    //   129: aload 4
    //   131: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   134: aload_0
    //   135: athrow
    //   136: iconst_m1
    //   137: ireturn
    //   138: astore_1
    //   139: aload 6
    //   141: astore_0
    //   142: goto -26 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramFile	File
    //   0	145	1	paramString	String
    //   39	33	2	i	int
    //   57	2	3	bool	boolean
    //   20	110	4	localObject1	Object
    //   14	90	5	localObject2	Object
    //   17	123	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   40	46	81	finally
    //   51	58	81	finally
    //   40	46	90	java/io/IOException
    //   51	58	90	java/io/IOException
    //   40	46	94	java/io/FileNotFoundException
    //   51	58	94	java/io/FileNotFoundException
    //   22	38	98	finally
    //   109	113	98	finally
    //   119	123	98	finally
    //   22	38	102	java/io/IOException
    //   22	38	138	java/io/FileNotFoundException
  }
  
  /* Error */
  public static java.util.List<String> d(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +113 -> 114
    //   4: aload_0
    //   5: invokevirtual 66	java/io/File:exists	()Z
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 68	java/io/BufferedReader
    //   16: dup
    //   17: new 70	java/io/FileReader
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 73	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   25: invokespecial 76	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore_1
    //   29: aload_1
    //   30: astore_0
    //   31: new 272	java/util/ArrayList
    //   34: dup
    //   35: invokespecial 273	java/util/ArrayList:<init>	()V
    //   38: astore_2
    //   39: aload_1
    //   40: astore_0
    //   41: aload_1
    //   42: invokevirtual 79	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   45: astore_3
    //   46: aload_3
    //   47: ifnull +16 -> 63
    //   50: aload_1
    //   51: astore_0
    //   52: aload_2
    //   53: aload_3
    //   54: invokeinterface 279 2 0
    //   59: pop
    //   60: goto -21 -> 39
    //   63: aload_1
    //   64: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   67: aload_2
    //   68: areturn
    //   69: astore_2
    //   70: goto +16 -> 86
    //   73: astore_2
    //   74: goto +21 -> 95
    //   77: astore_1
    //   78: aconst_null
    //   79: astore_0
    //   80: goto +28 -> 108
    //   83: astore_2
    //   84: aconst_null
    //   85: astore_1
    //   86: aload_1
    //   87: astore_0
    //   88: aload_2
    //   89: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   92: goto +9 -> 101
    //   95: aload_1
    //   96: astore_0
    //   97: aload_2
    //   98: invokevirtual 86	java/io/FileNotFoundException:printStackTrace	()V
    //   101: aload_1
    //   102: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   105: aconst_null
    //   106: areturn
    //   107: astore_1
    //   108: aload_0
    //   109: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   112: aload_1
    //   113: athrow
    //   114: aconst_null
    //   115: areturn
    //   116: astore_2
    //   117: aconst_null
    //   118: astore_1
    //   119: goto -24 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramFile	File
    //   28	36	1	localBufferedReader	java.io.BufferedReader
    //   77	1	1	localObject1	Object
    //   85	17	1	localCloseable	java.io.Closeable
    //   107	6	1	localObject2	Object
    //   118	1	1	localObject3	Object
    //   38	30	2	localArrayList	java.util.ArrayList
    //   69	1	2	localIOException1	IOException
    //   73	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   83	15	2	localIOException2	IOException
    //   116	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   45	9	3	str	String
    // Exception table:
    //   from	to	target	type
    //   31	39	69	java/io/IOException
    //   41	46	69	java/io/IOException
    //   52	60	69	java/io/IOException
    //   31	39	73	java/io/FileNotFoundException
    //   41	46	73	java/io/FileNotFoundException
    //   52	60	73	java/io/FileNotFoundException
    //   13	29	77	finally
    //   13	29	83	java/io/IOException
    //   31	39	107	finally
    //   41	46	107	finally
    //   52	60	107	finally
    //   88	92	107	finally
    //   97	101	107	finally
    //   13	29	116	java/io/FileNotFoundException
  }
  
  public static long e(File paramFile)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return 0L;
      }
      if (paramFile.isDirectory())
      {
        localObject = paramFile.listFiles();
        l1 = l2;
        if (localObject != null)
        {
          int j = localObject.length;
          int i = 0;
          for (;;)
          {
            l1 = l2;
            if (i >= j) {
              break;
            }
            l2 += e(localObject[i]);
            i += 1;
          }
        }
      }
      else
      {
        l1 = paramFile.length();
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFile.getAbsolutePath());
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      localObject = new File(((StringBuilder)localObject).toString());
      paramFile.renameTo((File)localObject);
      ((File)localObject).delete();
    }
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.om
 * JD-Core Version:    0.7.0.1
 */