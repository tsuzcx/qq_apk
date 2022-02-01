package com.tencent.ilivesdk.pluginloaderservice.install;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class CopyBloc
{
  private static ConcurrentHashMap<String, Object> a = new ConcurrentHashMap();
  
  public static File a(File paramFile1, File paramFile2, String paramString)
  {
    String str = paramFile1.getAbsolutePath();
    Object localObject2 = a.get(str);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new Object();
      a.put(str, localObject1);
    }
    paramString = new File(paramFile2, paramString);
    try
    {
      if ((paramFile2.exists()) && (paramFile2.isFile()))
      {
        paramFile2 = new StringBuilder();
        paramFile2.append("soDir=");
        paramFile2.append(paramFile1.getAbsolutePath());
        paramFile2.append("已存在，但它是个文件，不敢贸然删除");
        throw new IOException(paramFile2.toString());
      }
      if (!paramFile2.exists()) {
        paramFile2.mkdirs();
      }
      if (paramString.exists()) {
        paramString.delete();
      }
      a(paramFile1, paramString);
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  private static void a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 73	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 76	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: invokevirtual 80	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   13: astore_0
    //   14: new 82	java/io/FileOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 83	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   22: invokevirtual 84	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   25: astore_2
    //   26: aload_2
    //   27: aload_0
    //   28: lconst_0
    //   29: aload_0
    //   30: invokevirtual 90	java/nio/channels/FileChannel:size	()J
    //   33: invokevirtual 94	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   36: pop2
    //   37: aload_0
    //   38: invokevirtual 97	java/nio/channels/FileChannel:close	()V
    //   41: aload_2
    //   42: invokevirtual 97	java/nio/channels/FileChannel:close	()V
    //   45: return
    //   46: astore_1
    //   47: goto +14 -> 61
    //   50: astore_1
    //   51: aconst_null
    //   52: astore_2
    //   53: goto +8 -> 61
    //   56: astore_1
    //   57: aconst_null
    //   58: astore_2
    //   59: aload_3
    //   60: astore_0
    //   61: aload_0
    //   62: invokevirtual 97	java/nio/channels/FileChannel:close	()V
    //   65: aload_2
    //   66: invokevirtual 97	java/nio/channels/FileChannel:close	()V
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramFile1	File
    //   0	71	1	paramFile2	File
    //   25	41	2	localFileChannel	java.nio.channels.FileChannel
    //   1	59	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	37	46	finally
    //   14	26	50	finally
    //   2	14	56	finally
  }
  
  /* Error */
  public static File b(File paramFile1, File paramFile2, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 25	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   4: astore 7
    //   6: getstatic 16	com/tencent/ilivesdk/pluginloaderservice/install/CopyBloc:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   9: aload 7
    //   11: invokevirtual 29	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: astore 5
    //   16: aload 5
    //   18: astore 6
    //   20: aload 5
    //   22: ifnonnull +23 -> 45
    //   25: new 4	java/lang/Object
    //   28: dup
    //   29: invokespecial 18	java/lang/Object:<init>	()V
    //   32: astore 6
    //   34: getstatic 16	com/tencent/ilivesdk/pluginloaderservice/install/CopyBloc:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   37: aload 7
    //   39: aload 6
    //   41: invokevirtual 33	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: pop
    //   45: aload 6
    //   47: monitorenter
    //   48: aload_2
    //   49: invokestatic 106	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifeq +19 -> 71
    //   55: ldc 108
    //   57: ldc 110
    //   59: iconst_0
    //   60: anewarray 4	java/lang/Object
    //   63: invokestatic 115	com/tencent/ilivesdk/pluginloaderservice/utils/LogUtil:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: aload 6
    //   68: monitorexit
    //   69: aload_1
    //   70: areturn
    //   71: aload_1
    //   72: invokevirtual 40	java/io/File:exists	()Z
    //   75: ifeq +56 -> 131
    //   78: aload_1
    //   79: invokevirtual 43	java/io/File:isFile	()Z
    //   82: ifne +6 -> 88
    //   85: goto +46 -> 131
    //   88: new 45	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   95: astore_0
    //   96: aload_0
    //   97: ldc 48
    //   99: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload_0
    //   104: aload_1
    //   105: invokevirtual 25	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   108: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_0
    //   113: ldc 117
    //   115: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: new 56	java/io/IOException
    //   122: dup
    //   123: aload_0
    //   124: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokespecial 62	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   130: athrow
    //   131: aload_1
    //   132: invokevirtual 65	java/io/File:mkdirs	()Z
    //   135: pop
    //   136: aconst_null
    //   137: astore 5
    //   139: aconst_null
    //   140: astore 9
    //   142: aconst_null
    //   143: astore 8
    //   145: new 119	com/tencent/ilivesdk/pluginloaderservice/install/SafeZipInputStream
    //   148: dup
    //   149: new 73	java/io/FileInputStream
    //   152: dup
    //   153: aload_0
    //   154: invokespecial 76	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   157: invokespecial 122	com/tencent/ilivesdk/pluginloaderservice/install/SafeZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   160: astore 7
    //   162: aload 7
    //   164: invokevirtual 126	com/tencent/ilivesdk/pluginloaderservice/install/SafeZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   167: astore 5
    //   169: aload 5
    //   171: ifnull +133 -> 304
    //   174: aload 5
    //   176: invokevirtual 131	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   179: aload_2
    //   180: invokevirtual 137	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   183: istore 4
    //   185: iload 4
    //   187: ifne +6 -> 193
    //   190: goto -28 -> 162
    //   193: new 139	java/io/BufferedOutputStream
    //   196: dup
    //   197: new 82	java/io/FileOutputStream
    //   200: dup
    //   201: new 21	java/io/File
    //   204: dup
    //   205: aload_1
    //   206: aload 5
    //   208: invokevirtual 131	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   211: aload_2
    //   212: invokevirtual 143	java/lang/String:length	()I
    //   215: invokevirtual 147	java/lang/String:substring	(I)Ljava/lang/String;
    //   218: invokespecial 36	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   221: invokespecial 83	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   224: invokespecial 150	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   227: astore 5
    //   229: new 152	java/io/BufferedInputStream
    //   232: dup
    //   233: aload 7
    //   235: invokespecial 153	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   238: astore 9
    //   240: sipush 8192
    //   243: newarray byte
    //   245: astore 10
    //   247: aload 9
    //   249: aload 10
    //   251: iconst_0
    //   252: sipush 8192
    //   255: invokevirtual 157	java/io/BufferedInputStream:read	([BII)I
    //   258: istore_3
    //   259: iload_3
    //   260: iflt +15 -> 275
    //   263: aload 5
    //   265: aload 10
    //   267: iconst_0
    //   268: iload_3
    //   269: invokevirtual 161	java/io/BufferedOutputStream:write	([BII)V
    //   272: goto -25 -> 247
    //   275: aload 7
    //   277: invokevirtual 164	com/tencent/ilivesdk/pluginloaderservice/install/SafeZipInputStream:closeEntry	()V
    //   280: aload 5
    //   282: invokevirtual 165	java/io/BufferedOutputStream:close	()V
    //   285: goto -123 -> 162
    //   288: aload 7
    //   290: invokevirtual 164	com/tencent/ilivesdk/pluginloaderservice/install/SafeZipInputStream:closeEntry	()V
    //   293: aload_1
    //   294: ifnull +7 -> 301
    //   297: aload_1
    //   298: invokevirtual 165	java/io/BufferedOutputStream:close	()V
    //   301: aload 5
    //   303: athrow
    //   304: aload 7
    //   306: invokevirtual 166	com/tencent/ilivesdk/pluginloaderservice/install/SafeZipInputStream:close	()V
    //   309: goto +41 -> 350
    //   312: astore_0
    //   313: new 45	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   320: astore_2
    //   321: aload_2
    //   322: ldc 168
    //   324: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload_2
    //   329: aload_0
    //   330: invokevirtual 171	java/io/IOException:getMessage	()Ljava/lang/String;
    //   333: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: ldc 108
    //   339: aload_2
    //   340: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: iconst_0
    //   344: anewarray 4	java/lang/Object
    //   347: invokestatic 115	com/tencent/ilivesdk/pluginloaderservice/utils/LogUtil:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   350: aload 6
    //   352: monitorexit
    //   353: aload_1
    //   354: areturn
    //   355: astore_0
    //   356: aload 7
    //   358: astore 5
    //   360: goto +99 -> 459
    //   363: astore 5
    //   365: aload 7
    //   367: astore_1
    //   368: aload 5
    //   370: astore 7
    //   372: goto +12 -> 384
    //   375: astore_0
    //   376: goto +83 -> 459
    //   379: astore 7
    //   381: aload 9
    //   383: astore_1
    //   384: aload_1
    //   385: astore 5
    //   387: new 45	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   394: astore 8
    //   396: aload_1
    //   397: astore 5
    //   399: aload 8
    //   401: ldc 173
    //   403: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload_1
    //   408: astore 5
    //   410: aload 8
    //   412: aload_0
    //   413: invokevirtual 25	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   416: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload_1
    //   421: astore 5
    //   423: aload 8
    //   425: ldc 175
    //   427: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload_1
    //   432: astore 5
    //   434: aload 8
    //   436: aload_2
    //   437: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload_1
    //   442: astore 5
    //   444: new 56	java/io/IOException
    //   447: dup
    //   448: aload 8
    //   450: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: aload 7
    //   455: invokespecial 178	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   458: athrow
    //   459: aload 5
    //   461: ifnull +49 -> 510
    //   464: aload 5
    //   466: invokevirtual 166	com/tencent/ilivesdk/pluginloaderservice/install/SafeZipInputStream:close	()V
    //   469: goto +41 -> 510
    //   472: astore_1
    //   473: new 45	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   480: astore_2
    //   481: aload_2
    //   482: ldc 168
    //   484: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload_2
    //   489: aload_1
    //   490: invokevirtual 171	java/io/IOException:getMessage	()Ljava/lang/String;
    //   493: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: ldc 108
    //   499: aload_2
    //   500: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: iconst_0
    //   504: anewarray 4	java/lang/Object
    //   507: invokestatic 115	com/tencent/ilivesdk/pluginloaderservice/utils/LogUtil:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   510: aload_0
    //   511: athrow
    //   512: astore_0
    //   513: aload 6
    //   515: monitorexit
    //   516: goto +5 -> 521
    //   519: aload_0
    //   520: athrow
    //   521: goto -2 -> 519
    //   524: astore 8
    //   526: aload 5
    //   528: astore_1
    //   529: aload 8
    //   531: astore 5
    //   533: goto -245 -> 288
    //   536: astore 5
    //   538: aload 8
    //   540: astore_1
    //   541: goto -253 -> 288
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	544	0	paramFile1	File
    //   0	544	1	paramFile2	File
    //   0	544	2	paramString	String
    //   258	11	3	i	int
    //   183	3	4	bool	boolean
    //   14	345	5	localObject1	Object
    //   363	6	5	localException1	java.lang.Exception
    //   385	147	5	localObject2	Object
    //   536	1	5	localObject3	Object
    //   18	496	6	localObject4	Object
    //   4	367	7	localObject5	Object
    //   379	75	7	localException2	java.lang.Exception
    //   143	306	8	localStringBuilder	StringBuilder
    //   524	15	8	localObject6	Object
    //   140	242	9	localBufferedInputStream	java.io.BufferedInputStream
    //   245	21	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   304	309	312	java/io/IOException
    //   162	169	355	finally
    //   174	185	355	finally
    //   275	285	355	finally
    //   288	293	355	finally
    //   297	301	355	finally
    //   301	304	355	finally
    //   162	169	363	java/lang/Exception
    //   174	185	363	java/lang/Exception
    //   275	285	363	java/lang/Exception
    //   288	293	363	java/lang/Exception
    //   297	301	363	java/lang/Exception
    //   301	304	363	java/lang/Exception
    //   145	162	375	finally
    //   387	396	375	finally
    //   399	407	375	finally
    //   410	420	375	finally
    //   423	431	375	finally
    //   434	441	375	finally
    //   444	459	375	finally
    //   145	162	379	java/lang/Exception
    //   464	469	472	java/io/IOException
    //   48	69	512	finally
    //   71	85	512	finally
    //   88	131	512	finally
    //   131	136	512	finally
    //   304	309	512	finally
    //   313	350	512	finally
    //   350	353	512	finally
    //   464	469	512	finally
    //   473	510	512	finally
    //   510	512	512	finally
    //   513	516	512	finally
    //   229	247	524	finally
    //   247	259	524	finally
    //   263	272	524	finally
    //   193	229	536	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.install.CopyBloc
 * JD-Core Version:    0.7.0.1
 */