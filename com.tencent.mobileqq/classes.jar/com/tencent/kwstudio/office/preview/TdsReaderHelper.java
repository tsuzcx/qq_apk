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
    //   0: iconst_0
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 65	com/tencent/kwstudio/office/preview/TdsReaderView:sHostInterface	Lcom/tencent/kwstudio/office/preview/IHostInterface;
    //   8: ldc 67
    //   10: invokeinterface 73 2 0
    //   15: astore_1
    //   16: aload_1
    //   17: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +15 -> 35
    //   23: ldc 10
    //   25: ldc 81
    //   27: invokestatic 87	com/tencent/kwstudio/office/base/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: ldc 2
    //   32: monitorexit
    //   33: iload_0
    //   34: ireturn
    //   35: getstatic 65	com/tencent/kwstudio/office/preview/TdsReaderView:sHostInterface	Lcom/tencent/kwstudio/office/preview/IHostInterface;
    //   38: ldc 89
    //   40: invokeinterface 73 2 0
    //   45: astore 4
    //   47: new 91	java/io/File
    //   50: dup
    //   51: ldc 17
    //   53: invokestatic 95	com/tencent/kwstudio/office/base/Global:getPluginDir	(Ljava/lang/String;)Ljava/io/File;
    //   56: aload_1
    //   57: invokespecial 98	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   60: astore_2
    //   61: aload_2
    //   62: invokevirtual 101	java/io/File:exists	()Z
    //   65: ifeq +12 -> 77
    //   68: aload_2
    //   69: aload 4
    //   71: invokestatic 105	com/tencent/kwstudio/office/preview/TdsReaderHelper:doVerify	(Ljava/io/File;Ljava/lang/String;)Z
    //   74: ifne +149 -> 223
    //   77: aload_2
    //   78: iconst_0
    //   79: invokestatic 109	com/tencent/kwstudio/office/preview/TdsReaderHelper:deleteFile	(Ljava/io/File;Z)V
    //   82: new 111	java/util/concurrent/atomic/AtomicBoolean
    //   85: dup
    //   86: iconst_1
    //   87: invokespecial 114	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   90: astore_3
    //   91: ldc 10
    //   93: new 116	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   100: ldc 119
    //   102: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_1
    //   106: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 125
    //   111: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 132	com/tencent/kwstudio/office/base/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: getstatic 65	com/tencent/kwstudio/office/preview/TdsReaderView:sHostInterface	Lcom/tencent/kwstudio/office/preview/IHostInterface;
    //   123: aload_1
    //   124: getstatic 65	com/tencent/kwstudio/office/preview/TdsReaderView:sHostInterface	Lcom/tencent/kwstudio/office/preview/IHostInterface;
    //   127: ldc 134
    //   129: invokeinterface 73 2 0
    //   134: aload_2
    //   135: invokevirtual 137	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   138: new 139	com/tencent/kwstudio/office/preview/TdsReaderHelper$1
    //   141: dup
    //   142: aload_1
    //   143: aload_3
    //   144: invokespecial 142	com/tencent/kwstudio/office/preview/TdsReaderHelper$1:<init>	(Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    //   147: invokeinterface 146 5 0
    //   152: aload_3
    //   153: invokevirtual 149	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   156: ifeq +18 -> 174
    //   159: aload_3
    //   160: monitorenter
    //   161: aload_3
    //   162: invokevirtual 149	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   165: ifeq +7 -> 172
    //   168: aload_3
    //   169: invokevirtual 152	java/lang/Object:wait	()V
    //   172: aload_3
    //   173: monitorexit
    //   174: aload_2
    //   175: invokevirtual 101	java/io/File:exists	()Z
    //   178: ifeq +12 -> 190
    //   181: aload_2
    //   182: aload 4
    //   184: invokestatic 105	com/tencent/kwstudio/office/preview/TdsReaderHelper:doVerify	(Ljava/io/File;Ljava/lang/String;)Z
    //   187: ifne +36 -> 223
    //   190: aload_2
    //   191: iconst_0
    //   192: invokestatic 109	com/tencent/kwstudio/office/preview/TdsReaderHelper:deleteFile	(Ljava/io/File;Z)V
    //   195: goto -165 -> 30
    //   198: astore_1
    //   199: ldc 2
    //   201: monitorexit
    //   202: aload_1
    //   203: athrow
    //   204: astore 5
    //   206: ldc 10
    //   208: ldc 154
    //   210: aload 5
    //   212: invokestatic 157	com/tencent/kwstudio/office/base/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   215: goto -43 -> 172
    //   218: astore_1
    //   219: aload_3
    //   220: monitorexit
    //   221: aload_1
    //   222: athrow
    //   223: aload_1
    //   224: getstatic 159	com/tencent/kwstudio/office/preview/TdsReaderHelper:sLoadedPluginName	Ljava/lang/String;
    //   227: invokestatic 163	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   230: ifeq +16 -> 246
    //   233: getstatic 165	com/tencent/kwstudio/office/preview/TdsReaderHelper:sDexClassLoader	Ljava/lang/ClassLoader;
    //   236: astore_3
    //   237: aload_3
    //   238: ifnull +8 -> 246
    //   241: iconst_1
    //   242: istore_0
    //   243: goto -213 -> 30
    //   246: new 167	dalvik/system/DexClassLoader
    //   249: dup
    //   250: aload_2
    //   251: invokevirtual 137	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   254: ldc 17
    //   256: invokestatic 170	com/tencent/kwstudio/office/base/Global:getDexDir	(Ljava/lang/String;)Ljava/io/File;
    //   259: invokevirtual 137	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   262: ldc 17
    //   264: invokestatic 173	com/tencent/kwstudio/office/base/Global:getNativeDir	(Ljava/lang/String;)Ljava/io/File;
    //   267: invokevirtual 137	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   270: invokestatic 177	com/tencent/kwstudio/office/base/Global:getApplicationContext	()Landroid/content/Context;
    //   273: invokevirtual 183	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   276: invokespecial 186	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   279: putstatic 165	com/tencent/kwstudio/office/preview/TdsReaderHelper:sDexClassLoader	Ljava/lang/ClassLoader;
    //   282: aload_1
    //   283: putstatic 159	com/tencent/kwstudio/office/preview/TdsReaderHelper:sLoadedPluginName	Ljava/lang/String;
    //   286: ldc 10
    //   288: new 116	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   295: ldc 188
    //   297: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload_1
    //   301: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: ldc 190
    //   306: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 193	com/tencent/kwstudio/office/base/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: invokestatic 196	com/tencent/kwstudio/office/preview/TdsReaderHelper:deleteOldPluginAsync	()V
    //   318: invokestatic 199	com/tencent/kwstudio/office/preview/TdsReaderView:preActivePlugin	()V
    //   321: iconst_1
    //   322: istore_0
    //   323: goto -293 -> 30
    //   326: astore_1
    //   327: ldc 10
    //   329: ldc 201
    //   331: aload_1
    //   332: invokestatic 157	com/tencent/kwstudio/office/base/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   335: goto -20 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	322	0	bool	boolean
    //   15	128	1	str1	String
    //   198	5	1	localObject1	Object
    //   218	83	1	localCharSequence	java.lang.CharSequence
    //   326	6	1	localException	java.lang.Exception
    //   60	191	2	localFile	File
    //   90	148	3	localObject2	Object
    //   45	138	4	str2	String
    //   204	7	5	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   5	30	198	finally
    //   35	77	198	finally
    //   77	161	198	finally
    //   174	190	198	finally
    //   190	195	198	finally
    //   221	223	198	finally
    //   223	237	198	finally
    //   246	315	198	finally
    //   315	321	198	finally
    //   327	335	198	finally
    //   161	172	204	java/lang/InterruptedException
    //   161	172	218	finally
    //   172	174	218	finally
    //   206	215	218	finally
    //   219	221	218	finally
    //   246	315	326	java/lang/Exception
  }
  
  private static void deleteFile(File paramFile, boolean paramBoolean)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    do
    {
      do
      {
        return;
        if (!paramFile.isDirectory())
        {
          localObject = new File(paramFile.getAbsolutePath() + System.currentTimeMillis());
          paramFile.renameTo((File)localObject);
          ((File)localObject).delete();
          return;
        }
        localObject = paramFile.listFiles();
      } while (localObject == null);
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        deleteFile(localObject[i], paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    Object localObject = new File(paramFile.getAbsolutePath() + System.currentTimeMillis());
    paramFile.renameTo((File)localObject);
    ((File)localObject).delete();
  }
  
  private static void deleteOldPluginAsync()
  {
    Global.getExecutor().execute(new TdsReaderHelper.RunnableImpl(2, null));
  }
  
  private static void deleteOldPluginSync()
  {
    int i = 0;
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
            while (i < j)
            {
              File localFile = localObject2[i];
              String str3 = localFile.getName();
              if ((str3.startsWith(str1)) && (!str3.equals(str2)))
              {
                deleteFile(localFile, false);
                Log.d("TdsReaderHelper", "Delete plugin[" + str3 + "].");
              }
              i += 1;
            }
          }
        }
      }
      return;
    }
    finally {}
  }
  
  private static boolean doVerify(File paramFile, String paramString)
  {
    boolean bool1;
    if (TextUtils.isEmpty(paramString)) {
      bool1 = true;
    }
    String str;
    boolean bool2;
    do
    {
      return bool1;
      if (paramFile == null) {
        return false;
      }
      str = getFileMd5(paramFile);
      bool2 = paramString.equalsIgnoreCase(str);
      bool1 = bool2;
    } while (bool2);
    Log.e("TdsReaderHelper", "doVerify, md5 not match: filePath=" + paramFile.getAbsolutePath() + ", expectMd5=" + paramString + ", realMd5=" + str);
    return bool2;
  }
  
  /* Error */
  private static String getFileMd5(File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 262	java/io/BufferedInputStream
    //   5: dup
    //   6: new 264	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 267	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: invokespecial 270	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore 5
    //   19: aload 5
    //   21: astore 4
    //   23: sipush 8192
    //   26: newarray byte
    //   28: astore 6
    //   30: aload 5
    //   32: astore 4
    //   34: ldc_w 272
    //   37: invokestatic 278	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   40: astore 7
    //   42: iconst_0
    //   43: istore_1
    //   44: iload_1
    //   45: iconst_m1
    //   46: if_icmpeq +98 -> 144
    //   49: aload 5
    //   51: astore 4
    //   53: aload 5
    //   55: aload 6
    //   57: invokevirtual 284	java/io/InputStream:read	([B)I
    //   60: istore_3
    //   61: iload_3
    //   62: istore_1
    //   63: iload_3
    //   64: ifle -20 -> 44
    //   67: aload 5
    //   69: astore 4
    //   71: aload 7
    //   73: aload 6
    //   75: iconst_0
    //   76: iload_3
    //   77: invokevirtual 288	java/security/MessageDigest:update	([BII)V
    //   80: iload_3
    //   81: istore_1
    //   82: goto -38 -> 44
    //   85: astore 6
    //   87: aload 5
    //   89: astore 4
    //   91: ldc 10
    //   93: new 116	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   100: ldc_w 290
    //   103: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_0
    //   107: invokevirtual 137	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   110: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: aload 6
    //   118: invokestatic 157	com/tencent/kwstudio/office/base/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   121: ldc_w 292
    //   124: astore 4
    //   126: aload 4
    //   128: astore_0
    //   129: aload 5
    //   131: ifnull +11 -> 142
    //   134: aload 5
    //   136: invokevirtual 295	java/io/InputStream:close	()V
    //   139: aload 4
    //   141: astore_0
    //   142: aload_0
    //   143: areturn
    //   144: aload 5
    //   146: astore 4
    //   148: aload 7
    //   150: invokevirtual 299	java/security/MessageDigest:digest	()[B
    //   153: astore 6
    //   155: aload 6
    //   157: ifnull +13 -> 170
    //   160: aload 5
    //   162: astore 4
    //   164: aload 6
    //   166: arraylength
    //   167: ifgt +26 -> 193
    //   170: ldc_w 292
    //   173: astore_0
    //   174: aload 5
    //   176: ifnull -34 -> 142
    //   179: aload 5
    //   181: invokevirtual 295	java/io/InputStream:close	()V
    //   184: ldc_w 292
    //   187: areturn
    //   188: astore_0
    //   189: ldc_w 292
    //   192: areturn
    //   193: aload 5
    //   195: astore 4
    //   197: new 116	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   204: astore 7
    //   206: aload 5
    //   208: astore 4
    //   210: aload 6
    //   212: arraylength
    //   213: istore_3
    //   214: iload_2
    //   215: istore_1
    //   216: iload_1
    //   217: iload_3
    //   218: if_icmpge +40 -> 258
    //   221: aload 5
    //   223: astore 4
    //   225: aload 7
    //   227: ldc_w 301
    //   230: iconst_1
    //   231: anewarray 4	java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: aload 6
    //   238: iload_1
    //   239: baload
    //   240: invokestatic 307	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   243: aastore
    //   244: invokestatic 311	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   247: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: iload_1
    //   252: iconst_1
    //   253: iadd
    //   254: istore_1
    //   255: goto -39 -> 216
    //   258: aload 5
    //   260: astore 4
    //   262: aload 7
    //   264: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokevirtual 314	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   270: astore 6
    //   272: aload 6
    //   274: astore 4
    //   276: aload 4
    //   278: astore_0
    //   279: aload 5
    //   281: ifnull -139 -> 142
    //   284: aload 5
    //   286: invokevirtual 295	java/io/InputStream:close	()V
    //   289: aload 4
    //   291: areturn
    //   292: astore_0
    //   293: aload 4
    //   295: areturn
    //   296: astore_0
    //   297: aconst_null
    //   298: astore 4
    //   300: aload 4
    //   302: ifnull +8 -> 310
    //   305: aload 4
    //   307: invokevirtual 295	java/io/InputStream:close	()V
    //   310: aload_0
    //   311: athrow
    //   312: astore_0
    //   313: ldc_w 292
    //   316: areturn
    //   317: astore 4
    //   319: goto -9 -> 310
    //   322: astore_0
    //   323: goto -23 -> 300
    //   326: astore 6
    //   328: aconst_null
    //   329: astore 5
    //   331: goto -244 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	paramFile	File
    //   43	212	1	i	int
    //   1	214	2	j	int
    //   60	159	3	k	int
    //   21	285	4	localObject1	Object
    //   317	1	4	localThrowable1	java.lang.Throwable
    //   17	313	5	localBufferedInputStream	java.io.BufferedInputStream
    //   28	46	6	arrayOfByte	byte[]
    //   85	32	6	localThrowable2	java.lang.Throwable
    //   153	120	6	localObject2	Object
    //   326	1	6	localThrowable3	java.lang.Throwable
    //   40	223	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   23	30	85	java/lang/Throwable
    //   34	42	85	java/lang/Throwable
    //   53	61	85	java/lang/Throwable
    //   71	80	85	java/lang/Throwable
    //   148	155	85	java/lang/Throwable
    //   164	170	85	java/lang/Throwable
    //   197	206	85	java/lang/Throwable
    //   210	214	85	java/lang/Throwable
    //   225	251	85	java/lang/Throwable
    //   262	272	85	java/lang/Throwable
    //   179	184	188	java/lang/Throwable
    //   284	289	292	java/lang/Throwable
    //   2	19	296	finally
    //   134	139	312	java/lang/Throwable
    //   305	310	317	java/lang/Throwable
    //   23	30	322	finally
    //   34	42	322	finally
    //   53	61	322	finally
    //   71	80	322	finally
    //   91	121	322	finally
    //   148	155	322	finally
    //   164	170	322	finally
    //   197	206	322	finally
    //   210	214	322	finally
    //   225	251	322	finally
    //   262	272	322	finally
    //   2	19	326	java/lang/Throwable
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