package com.tencent.kwstudio.office.preview;

import android.text.TextUtils;
import com.tencent.kwstudio.office.base.Global;
import com.tencent.kwstudio.office.base.Log;
import com.tencent.kwstudio.office.debug.Debugger;
import com.tencent.kwstudio.office.debug.IDebugger;
import java.io.File;
import java.util.concurrent.Executor;

final class TdsReaderHelper
  implements IDebugger
{
  private static final String TAG = "TdsReaderHelper";
  static volatile ClassLoader sDexClassLoader;
  private static volatile String sLoadedPluginName;
  
  static
  {
    Debugger.setDebugger("11", 0, new TdsReaderHelper());
  }
  
  static void checkFacadePluginAsync()
  {
    Global.getExecutor().execute(new TdsReaderHelper.RunnableImpl(1, null));
  }
  
  /* Error */
  private static boolean checkFacadePluginSync()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 65	com/tencent/kwstudio/office/preview/TdsReaderView:sHostInterface	Lcom/tencent/kwstudio/office/preview/IHostInterface;
    //   6: ldc 67
    //   8: invokeinterface 73 2 0
    //   13: astore_0
    //   14: aload_0
    //   15: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +15 -> 33
    //   21: ldc 10
    //   23: ldc 81
    //   25: invokestatic 87	com/tencent/kwstudio/office/base/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: iconst_0
    //   32: ireturn
    //   33: getstatic 65	com/tencent/kwstudio/office/preview/TdsReaderView:sHostInterface	Lcom/tencent/kwstudio/office/preview/IHostInterface;
    //   36: ldc 89
    //   38: invokeinterface 73 2 0
    //   43: astore_3
    //   44: new 91	java/io/File
    //   47: dup
    //   48: ldc 17
    //   50: invokestatic 95	com/tencent/kwstudio/office/base/Global:getPluginDir	(Ljava/lang/String;)Ljava/io/File;
    //   53: aload_0
    //   54: invokespecial 98	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 101	java/io/File:exists	()Z
    //   62: ifeq +11 -> 73
    //   65: aload_1
    //   66: aload_3
    //   67: invokestatic 105	com/tencent/kwstudio/office/preview/TdsReaderHelper:doVerify	(Ljava/io/File;Ljava/lang/String;)Z
    //   70: ifne +156 -> 226
    //   73: aload_1
    //   74: iconst_0
    //   75: invokestatic 109	com/tencent/kwstudio/office/preview/TdsReaderHelper:deleteFile	(Ljava/io/File;Z)V
    //   78: new 111	java/util/concurrent/atomic/AtomicBoolean
    //   81: dup
    //   82: iconst_1
    //   83: invokespecial 114	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   86: astore_2
    //   87: new 116	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   94: astore 4
    //   96: aload 4
    //   98: ldc 119
    //   100: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 4
    //   106: aload_0
    //   107: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 4
    //   113: ldc 125
    //   115: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: ldc 10
    //   121: aload 4
    //   123: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 132	com/tencent/kwstudio/office/base/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: getstatic 65	com/tencent/kwstudio/office/preview/TdsReaderView:sHostInterface	Lcom/tencent/kwstudio/office/preview/IHostInterface;
    //   132: aload_0
    //   133: getstatic 65	com/tencent/kwstudio/office/preview/TdsReaderView:sHostInterface	Lcom/tencent/kwstudio/office/preview/IHostInterface;
    //   136: ldc 134
    //   138: invokeinterface 73 2 0
    //   143: aload_1
    //   144: invokevirtual 137	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   147: new 139	com/tencent/kwstudio/office/preview/TdsReaderHelper$1
    //   150: dup
    //   151: aload_0
    //   152: aload_2
    //   153: invokespecial 142	com/tencent/kwstudio/office/preview/TdsReaderHelper$1:<init>	(Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    //   156: invokeinterface 146 5 0
    //   161: aload_2
    //   162: invokevirtual 149	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   165: ifeq +43 -> 208
    //   168: aload_2
    //   169: monitorenter
    //   170: aload_2
    //   171: invokevirtual 149	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   174: ifeq +25 -> 199
    //   177: aload_2
    //   178: invokevirtual 152	java/lang/Object:wait	()V
    //   181: goto +18 -> 199
    //   184: astore_0
    //   185: goto +19 -> 204
    //   188: astore 4
    //   190: ldc 10
    //   192: ldc 154
    //   194: aload 4
    //   196: invokestatic 157	com/tencent/kwstudio/office/base/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   199: aload_2
    //   200: monitorexit
    //   201: goto +7 -> 208
    //   204: aload_2
    //   205: monitorexit
    //   206: aload_0
    //   207: athrow
    //   208: aload_1
    //   209: invokevirtual 101	java/io/File:exists	()Z
    //   212: ifeq +137 -> 349
    //   215: aload_1
    //   216: aload_3
    //   217: invokestatic 105	com/tencent/kwstudio/office/preview/TdsReaderHelper:doVerify	(Ljava/io/File;Ljava/lang/String;)Z
    //   220: ifne +6 -> 226
    //   223: goto +126 -> 349
    //   226: aload_0
    //   227: getstatic 159	com/tencent/kwstudio/office/preview/TdsReaderHelper:sLoadedPluginName	Ljava/lang/String;
    //   230: invokestatic 163	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   233: ifeq +16 -> 249
    //   236: getstatic 165	com/tencent/kwstudio/office/preview/TdsReaderHelper:sDexClassLoader	Ljava/lang/ClassLoader;
    //   239: astore_2
    //   240: aload_2
    //   241: ifnull +8 -> 249
    //   244: ldc 2
    //   246: monitorexit
    //   247: iconst_1
    //   248: ireturn
    //   249: new 167	dalvik/system/DexClassLoader
    //   252: dup
    //   253: aload_1
    //   254: invokevirtual 137	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   257: ldc 17
    //   259: invokestatic 170	com/tencent/kwstudio/office/base/Global:getDexDir	(Ljava/lang/String;)Ljava/io/File;
    //   262: invokevirtual 137	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   265: ldc 17
    //   267: invokestatic 173	com/tencent/kwstudio/office/base/Global:getNativeDir	(Ljava/lang/String;)Ljava/io/File;
    //   270: invokevirtual 137	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   273: invokestatic 177	com/tencent/kwstudio/office/base/Global:getApplicationContext	()Landroid/content/Context;
    //   276: invokevirtual 183	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   279: invokespecial 186	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   282: putstatic 165	com/tencent/kwstudio/office/preview/TdsReaderHelper:sDexClassLoader	Ljava/lang/ClassLoader;
    //   285: aload_0
    //   286: putstatic 159	com/tencent/kwstudio/office/preview/TdsReaderHelper:sLoadedPluginName	Ljava/lang/String;
    //   289: new 116	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   296: astore_1
    //   297: aload_1
    //   298: ldc 188
    //   300: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_1
    //   305: aload_0
    //   306: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload_1
    //   311: ldc 190
    //   313: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: ldc 10
    //   319: aload_1
    //   320: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 193	com/tencent/kwstudio/office/base/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: goto +12 -> 338
    //   329: astore_0
    //   330: ldc 10
    //   332: ldc 195
    //   334: aload_0
    //   335: invokestatic 157	com/tencent/kwstudio/office/base/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   338: invokestatic 198	com/tencent/kwstudio/office/preview/TdsReaderHelper:deleteOldPluginAsync	()V
    //   341: invokestatic 201	com/tencent/kwstudio/office/preview/TdsReaderView:preActivePlugin	()V
    //   344: ldc 2
    //   346: monitorexit
    //   347: iconst_1
    //   348: ireturn
    //   349: aload_1
    //   350: iconst_0
    //   351: invokestatic 109	com/tencent/kwstudio/office/preview/TdsReaderHelper:deleteFile	(Ljava/io/File;Z)V
    //   354: ldc 2
    //   356: monitorexit
    //   357: iconst_0
    //   358: ireturn
    //   359: astore_0
    //   360: ldc 2
    //   362: monitorexit
    //   363: aload_0
    //   364: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	139	0	str1	String
    //   184	122	0	localCharSequence	java.lang.CharSequence
    //   329	6	0	localException	java.lang.Exception
    //   359	5	0	localObject1	Object
    //   57	293	1	localObject2	Object
    //   86	155	2	localObject3	Object
    //   43	174	3	str2	String
    //   94	28	4	localStringBuilder	StringBuilder
    //   188	7	4	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   170	181	184	finally
    //   190	199	184	finally
    //   199	201	184	finally
    //   204	206	184	finally
    //   170	181	188	java/lang/InterruptedException
    //   249	326	329	java/lang/Exception
    //   3	28	359	finally
    //   33	73	359	finally
    //   73	170	359	finally
    //   206	208	359	finally
    //   208	223	359	finally
    //   226	240	359	finally
    //   249	326	359	finally
    //   330	338	359	finally
    //   338	344	359	finally
    //   349	354	359	finally
  }
  
  private static void deleteFile(File paramFile, boolean paramBoolean)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return;
      }
      if (!paramFile.isDirectory())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramFile.getAbsolutePath());
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        localObject = new File(((StringBuilder)localObject).toString());
        paramFile.renameTo((File)localObject);
        ((File)localObject).delete();
        return;
      }
      Object localObject = paramFile.listFiles();
      if (localObject == null) {
        return;
      }
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        deleteFile(localObject[i], paramBoolean);
        i += 1;
      }
      if (!paramBoolean)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramFile.getAbsolutePath());
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        localObject = new File(((StringBuilder)localObject).toString());
        paramFile.renameTo((File)localObject);
        ((File)localObject).delete();
      }
    }
  }
  
  private static void deleteOldPluginAsync()
  {
    Global.getExecutor().execute(new TdsReaderHelper.RunnableImpl(2, null));
  }
  
  private static void deleteOldPluginSync()
  {
    try
    {
      String str1 = TdsReaderView.sHostInterface.getConfig("facade_plugin_name_prefix");
      String str2 = TdsReaderView.sHostInterface.getConfig("facade_plugin_name");
      if (!TextUtils.isEmpty(str1))
      {
        Object localObject2 = Global.getPluginDir("11");
        if (((File)localObject2).exists())
        {
          localObject2 = ((File)localObject2).listFiles();
          if (localObject2 != null)
          {
            int j = localObject2.length;
            int i = 0;
            while (i < j)
            {
              Object localObject3 = localObject2[i];
              String str3 = ((File)localObject3).getName();
              if ((str3.startsWith(str1)) && (!str3.equals(str2)))
              {
                deleteFile((File)localObject3, false);
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("Delete plugin[");
                ((StringBuilder)localObject3).append(str3);
                ((StringBuilder)localObject3).append("].");
                Log.d("TdsReaderHelper", ((StringBuilder)localObject3).toString());
              }
              i += 1;
            }
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  private static boolean doVerify(File paramFile, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    if (paramFile == null) {
      return false;
    }
    String str = getFileMd5(paramFile);
    boolean bool = paramString.equalsIgnoreCase(str);
    if (!bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doVerify, md5 not match: filePath=");
      localStringBuilder.append(paramFile.getAbsolutePath());
      localStringBuilder.append(", expectMd5=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", realMd5=");
      localStringBuilder.append(str);
      Log.e("TdsReaderHelper", localStringBuilder.toString());
    }
    return bool;
  }
  
  /* Error */
  private static String getFileMd5(File paramFile)
  {
    // Byte code:
    //   0: new 262	java/io/BufferedInputStream
    //   3: dup
    //   4: new 264	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 267	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 270	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore 4
    //   17: aload 4
    //   19: astore_3
    //   20: sipush 8192
    //   23: newarray byte
    //   25: astore 5
    //   27: aload 4
    //   29: astore_3
    //   30: ldc_w 272
    //   33: invokestatic 278	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   36: astore 6
    //   38: iconst_0
    //   39: istore_1
    //   40: iload_1
    //   41: iconst_m1
    //   42: if_icmpeq +37 -> 79
    //   45: aload 4
    //   47: astore_3
    //   48: aload 4
    //   50: aload 5
    //   52: invokevirtual 284	java/io/InputStream:read	([B)I
    //   55: istore_2
    //   56: iload_2
    //   57: istore_1
    //   58: iload_2
    //   59: ifle -19 -> 40
    //   62: aload 4
    //   64: astore_3
    //   65: aload 6
    //   67: aload 5
    //   69: iconst_0
    //   70: iload_2
    //   71: invokevirtual 288	java/security/MessageDigest:update	([BII)V
    //   74: iload_2
    //   75: istore_1
    //   76: goto -36 -> 40
    //   79: aload 4
    //   81: astore_3
    //   82: aload 6
    //   84: invokevirtual 292	java/security/MessageDigest:digest	()[B
    //   87: astore 5
    //   89: aload 5
    //   91: ifnull +98 -> 189
    //   94: aload 4
    //   96: astore_3
    //   97: aload 5
    //   99: arraylength
    //   100: ifgt +6 -> 106
    //   103: goto +86 -> 189
    //   106: aload 4
    //   108: astore_3
    //   109: new 116	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   116: astore 6
    //   118: aload 4
    //   120: astore_3
    //   121: aload 5
    //   123: arraylength
    //   124: istore_2
    //   125: iconst_0
    //   126: istore_1
    //   127: iload_1
    //   128: iload_2
    //   129: if_icmpge +39 -> 168
    //   132: aload 4
    //   134: astore_3
    //   135: aload 6
    //   137: ldc_w 294
    //   140: iconst_1
    //   141: anewarray 4	java/lang/Object
    //   144: dup
    //   145: iconst_0
    //   146: aload 5
    //   148: iload_1
    //   149: baload
    //   150: invokestatic 300	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   153: aastore
    //   154: invokestatic 304	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   157: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: iload_1
    //   162: iconst_1
    //   163: iadd
    //   164: istore_1
    //   165: goto -38 -> 127
    //   168: aload 4
    //   170: astore_3
    //   171: aload 6
    //   173: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokevirtual 307	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   179: astore 5
    //   181: aload 4
    //   183: invokevirtual 310	java/io/InputStream:close	()V
    //   186: aload 5
    //   188: areturn
    //   189: aload 4
    //   191: invokevirtual 310	java/io/InputStream:close	()V
    //   194: ldc_w 312
    //   197: areturn
    //   198: astore 5
    //   200: goto +14 -> 214
    //   203: astore_0
    //   204: aconst_null
    //   205: astore_3
    //   206: goto +75 -> 281
    //   209: astore 5
    //   211: aconst_null
    //   212: astore 4
    //   214: aload 4
    //   216: astore_3
    //   217: new 116	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   224: astore 6
    //   226: aload 4
    //   228: astore_3
    //   229: aload 6
    //   231: ldc_w 314
    //   234: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 4
    //   240: astore_3
    //   241: aload 6
    //   243: aload_0
    //   244: invokevirtual 137	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   247: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 4
    //   253: astore_3
    //   254: ldc 10
    //   256: aload 6
    //   258: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: aload 5
    //   263: invokestatic 157	com/tencent/kwstudio/office/base/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   266: aload 4
    //   268: ifnull +8 -> 276
    //   271: aload 4
    //   273: invokevirtual 310	java/io/InputStream:close	()V
    //   276: ldc_w 312
    //   279: areturn
    //   280: astore_0
    //   281: aload_3
    //   282: ifnull +7 -> 289
    //   285: aload_3
    //   286: invokevirtual 310	java/io/InputStream:close	()V
    //   289: goto +5 -> 294
    //   292: aload_0
    //   293: athrow
    //   294: goto -2 -> 292
    //   297: astore_0
    //   298: aload 5
    //   300: areturn
    //   301: astore_0
    //   302: ldc_w 312
    //   305: areturn
    //   306: astore_0
    //   307: ldc_w 312
    //   310: areturn
    //   311: astore_3
    //   312: goto -23 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	paramFile	File
    //   39	126	1	i	int
    //   55	75	2	j	int
    //   19	267	3	localBufferedInputStream1	java.io.BufferedInputStream
    //   311	1	3	localThrowable1	java.lang.Throwable
    //   15	257	4	localBufferedInputStream2	java.io.BufferedInputStream
    //   25	162	5	localObject1	Object
    //   198	1	5	localThrowable2	java.lang.Throwable
    //   209	90	5	localThrowable3	java.lang.Throwable
    //   36	221	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   20	27	198	java/lang/Throwable
    //   30	38	198	java/lang/Throwable
    //   48	56	198	java/lang/Throwable
    //   65	74	198	java/lang/Throwable
    //   82	89	198	java/lang/Throwable
    //   97	103	198	java/lang/Throwable
    //   109	118	198	java/lang/Throwable
    //   121	125	198	java/lang/Throwable
    //   135	161	198	java/lang/Throwable
    //   171	181	198	java/lang/Throwable
    //   0	17	203	finally
    //   0	17	209	java/lang/Throwable
    //   20	27	280	finally
    //   30	38	280	finally
    //   48	56	280	finally
    //   65	74	280	finally
    //   82	89	280	finally
    //   97	103	280	finally
    //   109	118	280	finally
    //   121	125	280	finally
    //   135	161	280	finally
    //   171	181	280	finally
    //   217	226	280	finally
    //   229	238	280	finally
    //   241	251	280	finally
    //   254	266	280	finally
    //   181	186	297	java/lang/Throwable
    //   189	194	301	java/lang/Throwable
    //   271	276	306	java/lang/Throwable
    //   285	289	311	java/lang/Throwable
  }
  
  public boolean cleanCache(IHostInterface paramIHostInterface)
  {
    return true;
  }
  
  public boolean discardPlugin(IHostInterface paramIHostInterface)
  {
    paramIHostInterface = sLoadedPluginName;
    if (!TextUtils.isEmpty(paramIHostInterface)) {
      deleteFile(new File(Global.getPluginDir("11"), paramIHostInterface), true);
    }
    return true;
  }
  
  public boolean upgradePlugin(IHostInterface paramIHostInterface)
  {
    return checkFacadePluginSync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.kwstudio.office.preview.TdsReaderHelper
 * JD-Core Version:    0.7.0.1
 */