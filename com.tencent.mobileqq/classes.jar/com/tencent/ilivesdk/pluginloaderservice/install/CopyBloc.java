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
      if ((paramFile2.exists()) && (paramFile2.isFile())) {
        throw new IOException("soDir=" + paramFile1.getAbsolutePath() + "已存在，但它是个文件，不敢贸然删除");
      }
    }
    finally {}
    if (!paramFile2.exists()) {
      paramFile2.mkdirs();
    }
    if (paramString.exists()) {
      paramString.delete();
    }
    a(paramFile1, paramString);
    return paramString;
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
    //   13: astore_2
    //   14: new 82	java/io/FileOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 83	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   22: invokevirtual 84	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   25: astore_1
    //   26: aload_1
    //   27: aload_2
    //   28: lconst_0
    //   29: aload_2
    //   30: invokevirtual 90	java/nio/channels/FileChannel:size	()J
    //   33: invokevirtual 94	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   36: pop2
    //   37: aload_2
    //   38: invokevirtual 97	java/nio/channels/FileChannel:close	()V
    //   41: aload_1
    //   42: invokevirtual 97	java/nio/channels/FileChannel:close	()V
    //   45: return
    //   46: astore_0
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_3
    //   50: astore_2
    //   51: aload_2
    //   52: invokevirtual 97	java/nio/channels/FileChannel:close	()V
    //   55: aload_1
    //   56: invokevirtual 97	java/nio/channels/FileChannel:close	()V
    //   59: aload_0
    //   60: athrow
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_1
    //   64: goto -13 -> 51
    //   67: astore_0
    //   68: goto -17 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramFile1	File
    //   0	71	1	paramFile2	File
    //   13	39	2	localObject1	Object
    //   1	49	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	46	finally
    //   14	26	61	finally
    //   26	37	67	finally
  }
  
  /* Error */
  public static File b(File paramFile1, File paramFile2, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 8
    //   6: aload_0
    //   7: invokevirtual 25	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   10: astore 9
    //   12: getstatic 16	com/tencent/ilivesdk/pluginloaderservice/install/CopyBloc:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   15: aload 9
    //   17: invokevirtual 29	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: astore 7
    //   22: aload 7
    //   24: astore 6
    //   26: aload 7
    //   28: ifnonnull +23 -> 51
    //   31: new 4	java/lang/Object
    //   34: dup
    //   35: invokespecial 18	java/lang/Object:<init>	()V
    //   38: astore 6
    //   40: getstatic 16	com/tencent/ilivesdk/pluginloaderservice/install/CopyBloc:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   43: aload 9
    //   45: aload 6
    //   47: invokevirtual 33	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   50: pop
    //   51: aload 6
    //   53: monitorenter
    //   54: aload_2
    //   55: invokestatic 106	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifeq +19 -> 77
    //   61: ldc 108
    //   63: ldc 110
    //   65: iconst_0
    //   66: anewarray 4	java/lang/Object
    //   69: invokestatic 115	com/tencent/ilivesdk/pluginloaderservice/utils/LogUtil:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aload 6
    //   74: monitorexit
    //   75: aload_1
    //   76: areturn
    //   77: aload_1
    //   78: invokevirtual 40	java/io/File:exists	()Z
    //   81: ifeq +51 -> 132
    //   84: aload_1
    //   85: invokevirtual 43	java/io/File:isFile	()Z
    //   88: ifeq +44 -> 132
    //   91: new 45	java/io/IOException
    //   94: dup
    //   95: new 47	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   102: ldc 50
    //   104: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_1
    //   108: invokevirtual 25	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   111: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 117
    //   116: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokespecial 62	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   125: athrow
    //   126: astore_0
    //   127: aload 6
    //   129: monitorexit
    //   130: aload_0
    //   131: athrow
    //   132: aload_1
    //   133: invokevirtual 65	java/io/File:mkdirs	()Z
    //   136: pop
    //   137: new 119	com/tencent/ilivesdk/pluginloaderservice/install/SafeZipInputStream
    //   140: dup
    //   141: new 73	java/io/FileInputStream
    //   144: dup
    //   145: aload_0
    //   146: invokespecial 76	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   149: invokespecial 122	com/tencent/ilivesdk/pluginloaderservice/install/SafeZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   152: astore 7
    //   154: aload 7
    //   156: invokevirtual 126	com/tencent/ilivesdk/pluginloaderservice/install/SafeZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   159: astore 5
    //   161: aload 5
    //   163: ifnull +203 -> 366
    //   166: aload 5
    //   168: invokevirtual 131	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   171: aload_2
    //   172: invokevirtual 137	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   175: istore 4
    //   177: iload 4
    //   179: ifeq -25 -> 154
    //   182: new 139	java/io/BufferedOutputStream
    //   185: dup
    //   186: new 82	java/io/FileOutputStream
    //   189: dup
    //   190: new 21	java/io/File
    //   193: dup
    //   194: aload_1
    //   195: aload 5
    //   197: invokevirtual 131	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   200: aload_2
    //   201: invokevirtual 143	java/lang/String:length	()I
    //   204: invokevirtual 147	java/lang/String:substring	(I)Ljava/lang/String;
    //   207: invokespecial 36	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   210: invokespecial 83	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   213: invokespecial 150	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   216: astore 5
    //   218: new 152	java/io/BufferedInputStream
    //   221: dup
    //   222: aload 7
    //   224: invokespecial 153	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   227: astore 8
    //   229: sipush 8192
    //   232: newarray byte
    //   234: astore 9
    //   236: aload 8
    //   238: aload 9
    //   240: iconst_0
    //   241: sipush 8192
    //   244: invokevirtual 157	java/io/BufferedInputStream:read	([BII)I
    //   247: istore_3
    //   248: iload_3
    //   249: iflt +91 -> 340
    //   252: aload 5
    //   254: aload 9
    //   256: iconst_0
    //   257: iload_3
    //   258: invokevirtual 161	java/io/BufferedOutputStream:write	([BII)V
    //   261: goto -25 -> 236
    //   264: astore_1
    //   265: aload 7
    //   267: invokevirtual 164	com/tencent/ilivesdk/pluginloaderservice/install/SafeZipInputStream:closeEntry	()V
    //   270: aload 5
    //   272: ifnull +8 -> 280
    //   275: aload 5
    //   277: invokevirtual 165	java/io/BufferedOutputStream:close	()V
    //   280: aload_1
    //   281: athrow
    //   282: astore_1
    //   283: aload 7
    //   285: astore 5
    //   287: new 45	java/io/IOException
    //   290: dup
    //   291: new 47	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   298: ldc 167
    //   300: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload_0
    //   304: invokevirtual 25	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   307: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: ldc 169
    //   312: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_2
    //   316: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: aload_1
    //   323: invokespecial 172	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   326: athrow
    //   327: astore_0
    //   328: aload 5
    //   330: ifnull +8 -> 338
    //   333: aload 5
    //   335: invokevirtual 173	com/tencent/ilivesdk/pluginloaderservice/install/SafeZipInputStream:close	()V
    //   338: aload_0
    //   339: athrow
    //   340: aload 7
    //   342: invokevirtual 164	com/tencent/ilivesdk/pluginloaderservice/install/SafeZipInputStream:closeEntry	()V
    //   345: aload 5
    //   347: ifnull -193 -> 154
    //   350: aload 5
    //   352: invokevirtual 165	java/io/BufferedOutputStream:close	()V
    //   355: goto -201 -> 154
    //   358: astore_0
    //   359: aload 7
    //   361: astore 5
    //   363: goto -35 -> 328
    //   366: aload 7
    //   368: ifnull +8 -> 376
    //   371: aload 7
    //   373: invokevirtual 173	com/tencent/ilivesdk/pluginloaderservice/install/SafeZipInputStream:close	()V
    //   376: aload 6
    //   378: monitorexit
    //   379: aload_1
    //   380: areturn
    //   381: astore_0
    //   382: ldc 108
    //   384: new 47	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   391: ldc 175
    //   393: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload_0
    //   397: invokevirtual 178	java/io/IOException:getMessage	()Ljava/lang/String;
    //   400: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: iconst_0
    //   407: anewarray 4	java/lang/Object
    //   410: invokestatic 115	com/tencent/ilivesdk/pluginloaderservice/utils/LogUtil:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   413: goto -37 -> 376
    //   416: astore_1
    //   417: ldc 108
    //   419: new 47	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   426: ldc 175
    //   428: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: aload_1
    //   432: invokevirtual 178	java/io/IOException:getMessage	()Ljava/lang/String;
    //   435: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: iconst_0
    //   442: anewarray 4	java/lang/Object
    //   445: invokestatic 115	com/tencent/ilivesdk/pluginloaderservice/utils/LogUtil:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   448: goto -110 -> 338
    //   451: astore_1
    //   452: aload 8
    //   454: astore 5
    //   456: goto -169 -> 287
    //   459: astore_1
    //   460: aconst_null
    //   461: astore 5
    //   463: goto -198 -> 265
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	466	0	paramFile1	File
    //   0	466	1	paramFile2	File
    //   0	466	2	paramString	String
    //   247	11	3	i	int
    //   175	3	4	bool	boolean
    //   1	461	5	localObject1	Object
    //   24	353	6	localObject2	Object
    //   20	352	7	localObject3	Object
    //   4	449	8	localBufferedInputStream	java.io.BufferedInputStream
    //   10	245	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   54	75	126	finally
    //   77	126	126	finally
    //   127	130	126	finally
    //   132	137	126	finally
    //   333	338	126	finally
    //   338	340	126	finally
    //   371	376	126	finally
    //   376	379	126	finally
    //   382	413	126	finally
    //   417	448	126	finally
    //   218	236	264	finally
    //   236	248	264	finally
    //   252	261	264	finally
    //   154	161	282	java/lang/Exception
    //   166	177	282	java/lang/Exception
    //   265	270	282	java/lang/Exception
    //   275	280	282	java/lang/Exception
    //   280	282	282	java/lang/Exception
    //   340	345	282	java/lang/Exception
    //   350	355	282	java/lang/Exception
    //   137	154	327	finally
    //   287	327	327	finally
    //   154	161	358	finally
    //   166	177	358	finally
    //   265	270	358	finally
    //   275	280	358	finally
    //   280	282	358	finally
    //   340	345	358	finally
    //   350	355	358	finally
    //   371	376	381	java/io/IOException
    //   333	338	416	java/io/IOException
    //   137	154	451	java/lang/Exception
    //   182	218	459	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.install.CopyBloc
 * JD-Core Version:    0.7.0.1
 */