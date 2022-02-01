package com.tencent.map.sdk.a;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

public final class gd
{
  public static String a;
  public static String b;
  
  public static final InputStream a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = paramContext.getAssets();
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = paramContext.open(paramString);
      return paramContext;
    }
    catch (IOException paramContext) {}
    return null;
  }
  
  public static final InputStream a(Context paramContext, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return a(paramContext, localStringBuilder.toString());
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 43	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: aload_2
    //   6: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: invokevirtual 50	java/io/File:exists	()Z
    //   12: ifne +441 -> 453
    //   15: aconst_null
    //   16: astore 9
    //   18: aconst_null
    //   19: astore 8
    //   21: new 26	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   28: astore 4
    //   30: aload 4
    //   32: aload_0
    //   33: invokestatic 56	com/tencent/tencentmap/io/QStorageManager:getInstance	(Landroid/content/Context;)Lcom/tencent/tencentmap/io/QStorageManager;
    //   36: aconst_null
    //   37: invokevirtual 60	com/tencent/tencentmap/io/QStorageManager:getAssetsLoadPath	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 4
    //   46: aload_3
    //   47: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 64	com/tencent/map/sdk/a/on:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   59: astore 7
    //   61: aload 7
    //   63: astore 4
    //   65: aload 7
    //   67: ifnonnull +176 -> 243
    //   70: aload 7
    //   72: astore 6
    //   74: aload 7
    //   76: astore 5
    //   78: getstatic 66	com/tencent/map/sdk/a/gd:a	Ljava/lang/String;
    //   81: ifnull +74 -> 155
    //   84: aload 7
    //   86: astore 6
    //   88: aload 7
    //   90: astore 5
    //   92: new 26	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   99: astore 4
    //   101: aload 7
    //   103: astore 6
    //   105: aload 7
    //   107: astore 5
    //   109: aload 4
    //   111: getstatic 66	com/tencent/map/sdk/a/gd:a	Ljava/lang/String;
    //   114: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload 7
    //   120: astore 6
    //   122: aload 7
    //   124: astore 5
    //   126: aload 4
    //   128: aload_3
    //   129: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 7
    //   135: astore 6
    //   137: aload 7
    //   139: astore 5
    //   141: aload_0
    //   142: aload 4
    //   144: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 40	com/tencent/map/sdk/a/gd:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   150: astore 4
    //   152: goto +91 -> 243
    //   155: aload 7
    //   157: astore 4
    //   159: aload 7
    //   161: astore 6
    //   163: aload 7
    //   165: astore 5
    //   167: getstatic 68	com/tencent/map/sdk/a/gd:b	Ljava/lang/String;
    //   170: ifnull +73 -> 243
    //   173: aload 7
    //   175: astore 6
    //   177: aload 7
    //   179: astore 5
    //   181: new 26	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   188: astore 4
    //   190: aload 7
    //   192: astore 6
    //   194: aload 7
    //   196: astore 5
    //   198: aload 4
    //   200: getstatic 68	com/tencent/map/sdk/a/gd:b	Ljava/lang/String;
    //   203: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload 7
    //   209: astore 6
    //   211: aload 7
    //   213: astore 5
    //   215: aload 4
    //   217: aload_3
    //   218: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload 7
    //   224: astore 6
    //   226: aload 7
    //   228: astore 5
    //   230: aload 4
    //   232: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 64	com/tencent/map/sdk/a/on:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   238: astore 4
    //   240: goto +3 -> 243
    //   243: aload 4
    //   245: astore 5
    //   247: aload 4
    //   249: ifnonnull +78 -> 327
    //   252: aload 4
    //   254: astore 6
    //   256: aload 4
    //   258: astore 5
    //   260: new 26	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   267: astore 7
    //   269: aload 4
    //   271: astore 6
    //   273: aload 4
    //   275: astore 5
    //   277: aload 7
    //   279: aload_0
    //   280: invokestatic 56	com/tencent/tencentmap/io/QStorageManager:getInstance	(Landroid/content/Context;)Lcom/tencent/tencentmap/io/QStorageManager;
    //   283: invokevirtual 71	com/tencent/tencentmap/io/QStorageManager:getAssetsDynamicPath	()Ljava/lang/String;
    //   286: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 4
    //   292: astore 6
    //   294: aload 4
    //   296: astore 5
    //   298: aload 7
    //   300: aload_3
    //   301: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 4
    //   307: astore 6
    //   309: aload 4
    //   311: astore 5
    //   313: aload 7
    //   315: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 64	com/tencent/map/sdk/a/on:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   321: astore 4
    //   323: aload 4
    //   325: astore 5
    //   327: aload 5
    //   329: ifnonnull +18 -> 347
    //   332: aload 5
    //   334: astore 6
    //   336: aload_0
    //   337: ldc 73
    //   339: aload_3
    //   340: invokestatic 75	com/tencent/map/sdk/a/gd:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   343: astore_0
    //   344: goto +6 -> 350
    //   347: aload 5
    //   349: astore_0
    //   350: new 77	java/io/FileOutputStream
    //   353: dup
    //   354: new 43	java/io/File
    //   357: dup
    //   358: aload_1
    //   359: aload_2
    //   360: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   366: astore_1
    //   367: aload_0
    //   368: aload_1
    //   369: invokestatic 83	com/tencent/map/sdk/a/on:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   372: pop2
    //   373: aload_1
    //   374: invokestatic 86	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   377: aload_0
    //   378: invokestatic 86	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   381: return
    //   382: astore_2
    //   383: aload_0
    //   384: astore 5
    //   386: aload_2
    //   387: astore_0
    //   388: goto +39 -> 427
    //   391: aload_0
    //   392: astore 6
    //   394: aload_1
    //   395: astore_0
    //   396: goto +48 -> 444
    //   399: astore_2
    //   400: aload 8
    //   402: astore_1
    //   403: aload_0
    //   404: astore 5
    //   406: aload_2
    //   407: astore_0
    //   408: goto +19 -> 427
    //   411: aload_0
    //   412: astore 6
    //   414: aload 9
    //   416: astore_0
    //   417: goto +27 -> 444
    //   420: astore_0
    //   421: aconst_null
    //   422: astore 5
    //   424: aload 8
    //   426: astore_1
    //   427: aload_1
    //   428: invokestatic 86	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   431: aload 5
    //   433: invokestatic 86	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   436: aload_0
    //   437: athrow
    //   438: aconst_null
    //   439: astore 6
    //   441: aload 9
    //   443: astore_0
    //   444: aload_0
    //   445: invokestatic 86	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   448: aload 6
    //   450: invokestatic 86	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   453: return
    //   454: astore_0
    //   455: goto -17 -> 438
    //   458: astore_0
    //   459: aload 9
    //   461: astore_0
    //   462: goto -18 -> 444
    //   465: astore_1
    //   466: goto -55 -> 411
    //   469: astore_2
    //   470: goto -79 -> 391
    //   473: astore_0
    //   474: aload 8
    //   476: astore_1
    //   477: goto -50 -> 427
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	480	0	paramContext	Context
    //   0	480	1	paramString1	String
    //   0	480	2	paramString2	String
    //   0	480	3	paramString3	String
    //   28	296	4	localObject1	Object
    //   76	356	5	localObject2	Object
    //   72	377	6	localObject3	Object
    //   59	255	7	localObject4	Object
    //   19	456	8	localObject5	Object
    //   16	444	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   367	373	382	finally
    //   350	367	399	finally
    //   21	61	420	finally
    //   21	61	454	java/io/IOException
    //   78	84	458	java/io/IOException
    //   92	101	458	java/io/IOException
    //   109	118	458	java/io/IOException
    //   126	133	458	java/io/IOException
    //   141	152	458	java/io/IOException
    //   167	173	458	java/io/IOException
    //   181	190	458	java/io/IOException
    //   198	207	458	java/io/IOException
    //   215	222	458	java/io/IOException
    //   230	240	458	java/io/IOException
    //   260	269	458	java/io/IOException
    //   277	290	458	java/io/IOException
    //   298	305	458	java/io/IOException
    //   313	323	458	java/io/IOException
    //   336	344	458	java/io/IOException
    //   350	367	465	java/io/IOException
    //   367	373	469	java/io/IOException
    //   78	84	473	finally
    //   92	101	473	finally
    //   109	118	473	finally
    //   126	133	473	finally
    //   141	152	473	finally
    //   167	173	473	finally
    //   181	190	473	finally
    //   198	207	473	finally
    //   215	222	473	finally
    //   230	240	473	finally
    //   260	269	473	finally
    //   277	290	473	finally
    //   298	305	473	finally
    //   313	323	473	finally
    //   336	344	473	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.gd
 * JD-Core Version:    0.7.0.1
 */