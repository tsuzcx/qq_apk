package com.tencent.mobileqq.apollo.screenshot;

import com.jakewharton.disklrucache.DiskLruCache;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/ApolloScreenshotController$INSTANCE;", "", "()V", "DISK_CACHE_MAX_SIZE", "", "TAG_PREFIX", "", "mAsyncThreadPool", "Ljava/util/concurrent/Executor;", "mDiskLruCache", "Lcom/jakewharton/disklrucache/DiskLruCache;", "getRecord", "Ljava/io/File;", "recordKey", "initDiskLruCache", "", "moveFileToDiskCache", "filePath", "key", "preloadSoIfNeed", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloScreenshotController$INSTANCE
{
  /* Error */
  private final void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 56	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore 4
    //   5: invokestatic 61	com/tencent/mobileqq/apollo/screenshot/ApolloScreenshotController:a	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   8: ifnull +445 -> 453
    //   11: aload_1
    //   12: checkcast 63	java/lang/CharSequence
    //   15: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifne +435 -> 453
    //   21: aload_2
    //   22: checkcast 63	java/lang/CharSequence
    //   25: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifeq +4 -> 32
    //   31: return
    //   32: aconst_null
    //   33: checkcast 71	java/io/FileInputStream
    //   36: astore 9
    //   38: aconst_null
    //   39: checkcast 73	java/io/BufferedOutputStream
    //   42: astore 10
    //   44: aconst_null
    //   45: checkcast 75	java/io/File
    //   48: astore 14
    //   50: aload 14
    //   52: astore 13
    //   54: aload 9
    //   56: astore 12
    //   58: aload 10
    //   60: astore 11
    //   62: new 75	java/io/File
    //   65: dup
    //   66: aload_1
    //   67: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   70: astore_1
    //   71: aload_1
    //   72: invokevirtual 82	java/io/File:exists	()Z
    //   75: istore 8
    //   77: iload 8
    //   79: ifne +9 -> 88
    //   82: aload_1
    //   83: invokevirtual 85	java/io/File:delete	()Z
    //   86: pop
    //   87: return
    //   88: invokestatic 61	com/tencent/mobileqq/apollo/screenshot/ApolloScreenshotController:a	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   91: astore 11
    //   93: aload 11
    //   95: ifnonnull +6 -> 101
    //   98: invokestatic 90	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   101: aload_2
    //   102: ifnonnull +6 -> 108
    //   105: invokestatic 90	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   108: invokestatic 96	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   111: astore 12
    //   113: aload 12
    //   115: ldc 98
    //   117: invokestatic 102	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   120: aload_2
    //   121: ifnull +169 -> 290
    //   124: aload_2
    //   125: aload 12
    //   127: invokevirtual 108	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   130: astore_2
    //   131: aload_2
    //   132: ldc 110
    //   134: invokestatic 102	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   137: aload 11
    //   139: aload_2
    //   140: invokevirtual 116	com/jakewharton/disklrucache/DiskLruCache:edit	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Editor;
    //   143: astore 11
    //   145: new 73	java/io/BufferedOutputStream
    //   148: dup
    //   149: aload 11
    //   151: iconst_0
    //   152: invokevirtual 122	com/jakewharton/disklrucache/DiskLruCache$Editor:newOutputStream	(I)Ljava/io/OutputStream;
    //   155: invokespecial 125	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   158: astore_2
    //   159: new 71	java/io/FileInputStream
    //   162: dup
    //   163: aload_1
    //   164: invokespecial 128	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   167: astore 10
    //   169: sipush 8192
    //   172: newarray byte
    //   174: astore 9
    //   176: aload 10
    //   178: aload 9
    //   180: invokevirtual 132	java/io/FileInputStream:read	([B)I
    //   183: istore_3
    //   184: iload_3
    //   185: ifle +14 -> 199
    //   188: aload_2
    //   189: aload 9
    //   191: iconst_0
    //   192: iload_3
    //   193: invokevirtual 136	java/io/BufferedOutputStream:write	([BII)V
    //   196: goto -20 -> 176
    //   199: aload_2
    //   200: invokevirtual 139	java/io/BufferedOutputStream:flush	()V
    //   203: aload 11
    //   205: invokevirtual 142	com/jakewharton/disklrucache/DiskLruCache$Editor:commit	()V
    //   208: invokestatic 61	com/tencent/mobileqq/apollo/screenshot/ApolloScreenshotController:a	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   211: astore 9
    //   213: aload 9
    //   215: ifnonnull +6 -> 221
    //   218: invokestatic 90	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   221: aload 9
    //   223: invokevirtual 143	com/jakewharton/disklrucache/DiskLruCache:flush	()V
    //   226: aload 10
    //   228: invokevirtual 146	java/io/FileInputStream:close	()V
    //   231: aload_2
    //   232: invokevirtual 147	java/io/BufferedOutputStream:close	()V
    //   235: aload_1
    //   236: invokevirtual 85	java/io/File:delete	()Z
    //   239: pop
    //   240: goto +140 -> 380
    //   243: astore 11
    //   245: aload 10
    //   247: astore 9
    //   249: aload 11
    //   251: astore 10
    //   253: goto +20 -> 273
    //   256: astore 11
    //   258: aload 10
    //   260: astore 9
    //   262: aload_2
    //   263: astore 10
    //   265: aload 11
    //   267: astore_2
    //   268: goto +63 -> 331
    //   271: astore 10
    //   273: aload_2
    //   274: astore 11
    //   276: goto +145 -> 421
    //   279: astore 11
    //   281: aload_2
    //   282: astore 10
    //   284: aload 11
    //   286: astore_2
    //   287: goto +25 -> 312
    //   290: new 149	kotlin/TypeCastException
    //   293: dup
    //   294: ldc 151
    //   296: invokespecial 152	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   299: athrow
    //   300: astore_2
    //   301: aload 10
    //   303: astore 11
    //   305: aload_2
    //   306: astore 10
    //   308: goto +113 -> 421
    //   311: astore_2
    //   312: goto +19 -> 331
    //   315: astore 10
    //   317: aload 13
    //   319: astore_1
    //   320: aload 12
    //   322: astore 9
    //   324: goto +97 -> 421
    //   327: astore_2
    //   328: aload 14
    //   330: astore_1
    //   331: aload_1
    //   332: astore 13
    //   334: aload 9
    //   336: astore 12
    //   338: aload 10
    //   340: astore 11
    //   342: ldc 154
    //   344: iconst_1
    //   345: ldc 156
    //   347: aload_2
    //   348: invokestatic 162	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   351: aload 9
    //   353: ifnull +8 -> 361
    //   356: aload 9
    //   358: invokevirtual 146	java/io/FileInputStream:close	()V
    //   361: aload 10
    //   363: ifnull +8 -> 371
    //   366: aload 10
    //   368: invokevirtual 147	java/io/BufferedOutputStream:close	()V
    //   371: aload_1
    //   372: ifnull +8 -> 380
    //   375: aload_1
    //   376: invokevirtual 85	java/io/File:delete	()Z
    //   379: pop
    //   380: invokestatic 56	android/os/SystemClock:elapsedRealtime	()J
    //   383: lstore 6
    //   385: new 164	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   392: astore_1
    //   393: aload_1
    //   394: ldc 167
    //   396: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload_1
    //   401: lload 6
    //   403: lload 4
    //   405: lsub
    //   406: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: ldc 154
    //   412: iconst_4
    //   413: aload_1
    //   414: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   420: return
    //   421: aload 9
    //   423: ifnull +8 -> 431
    //   426: aload 9
    //   428: invokevirtual 146	java/io/FileInputStream:close	()V
    //   431: aload 11
    //   433: ifnull +8 -> 441
    //   436: aload 11
    //   438: invokevirtual 147	java/io/BufferedOutputStream:close	()V
    //   441: aload_1
    //   442: ifnull +8 -> 450
    //   445: aload_1
    //   446: invokevirtual 85	java/io/File:delete	()Z
    //   449: pop
    //   450: aload 10
    //   452: athrow
    //   453: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	454	0	this	INSTANCE
    //   0	454	1	paramString1	String
    //   0	454	2	paramString2	String
    //   183	10	3	i	int
    //   3	401	4	l1	long
    //   383	19	6	l2	long
    //   75	3	8	bool	boolean
    //   36	391	9	localObject1	Object
    //   42	222	10	localObject2	Object
    //   271	1	10	localObject3	Object
    //   282	25	10	str1	String
    //   315	136	10	localObject4	Object
    //   60	144	11	localObject5	Object
    //   243	7	11	localObject6	Object
    //   256	10	11	localThrowable1	Throwable
    //   274	1	11	str2	String
    //   279	6	11	localThrowable2	Throwable
    //   303	134	11	localObject7	Object
    //   56	281	12	localObject8	Object
    //   52	281	13	localObject9	Object
    //   48	281	14	localFile	File
    // Exception table:
    //   from	to	target	type
    //   169	176	243	finally
    //   176	184	243	finally
    //   188	196	243	finally
    //   199	213	243	finally
    //   218	221	243	finally
    //   221	226	243	finally
    //   169	176	256	java/lang/Throwable
    //   176	184	256	java/lang/Throwable
    //   188	196	256	java/lang/Throwable
    //   199	213	256	java/lang/Throwable
    //   218	221	256	java/lang/Throwable
    //   221	226	256	java/lang/Throwable
    //   159	169	271	finally
    //   159	169	279	java/lang/Throwable
    //   71	77	300	finally
    //   88	93	300	finally
    //   98	101	300	finally
    //   105	108	300	finally
    //   108	120	300	finally
    //   124	159	300	finally
    //   290	300	300	finally
    //   71	77	311	java/lang/Throwable
    //   88	93	311	java/lang/Throwable
    //   98	101	311	java/lang/Throwable
    //   105	108	311	java/lang/Throwable
    //   108	120	311	java/lang/Throwable
    //   124	159	311	java/lang/Throwable
    //   290	300	311	java/lang/Throwable
    //   62	71	315	finally
    //   342	351	315	finally
    //   62	71	327	java/lang/Throwable
  }
  
  private final void b()
  {
    Object localObject;
    if (ApolloScreenshotController.a() != null)
    {
      localObject = ApolloScreenshotController.a();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if (!((DiskLruCache)localObject).isClosed()) {}
    }
    else
    {
      try
      {
        localObject = ApolloCoderResource.a.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initDiskLruCache ");
        localStringBuilder.append((String)localObject);
        QLog.i("[ApolloScrshot]", 1, localStringBuilder.toString());
        if (localObject == null) {
          return;
        }
        localObject = new File((String)localObject);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        ApolloScreenshotController.a(DiskLruCache.open((File)localObject, 1, 1, 52428800L));
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[ApolloScrshot]", 1, "initDiskLruCache", localThrowable);
      }
    }
  }
  
  @Nullable
  public final File a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "recordKey");
    try
    {
      if (ApolloScreenshotController.a() != null)
      {
        localObject = ApolloScreenshotController.a();
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        if (((DiskLruCache)localObject).get(paramString) == null) {
          break label160;
        }
      }
      Object localObject = new File(Intrinsics.stringPlus(ApolloCoderResource.a.a(paramString), ".0"));
      boolean bool = ((File)localObject).exists();
      if ((bool) && (((File)localObject).length() > 0L))
      {
        paramString = new StringBuilder();
        paramString.append("getRecord ");
        paramString.append(((File)localObject).getPath());
        QLog.d("[ApolloScrshot]", 4, paramString.toString());
        return localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getRecord ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" empty");
      QLog.d("[ApolloScrshot]", 4, ((StringBuilder)localObject).toString());
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("[ApolloScrshot]", 1, "getRecord error", paramString);
      return null;
    }
    label160:
    return null;
  }
  
  public final void a()
  {
    ApolloApngEncoder.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController.INSTANCE
 * JD-Core Version:    0.7.0.1
 */