import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.jakewharton.disklrucache.DiskLruCache;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.screenshot.ApolloApngEncoder;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController.onRecordFrame.1;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController.onRecordFrameEnd.1;
import com.tencent.mobileqq.apollo.screenshot.EncodeType;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/ApolloScreenshotController;", "", "()V", "DISK_CACHE_MAX_SIZE", "", "TAG", "", "mDiskLruCache", "Lcom/jakewharton/disklrucache/DiskLruCache;", "mRecordHandler", "Landroid/os/Handler;", "mRecordListenerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloActionRecordListener;", "mResourceMap", "Lcom/tencent/mobileqq/apollo/screenshot/ApolloCoderResource;", "getRecord", "Ljava/io/File;", "recordKey", "initDiskLruCache", "", "moveFileToDiskCache", "filePath", "key", "onRecordFrame", "", "director", "pixels", "", "width", "", "height", "apolloRender", "Lcom/tencent/mobileqq/apollo/ApolloRender;", "onRecordFrameEnd", "actionCompleted", "onRecordFrameStart", "frameTimeInSec", "", "preloadSoIfNeed", "setRecordListener", "listener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class anbo
{
  public static final anbo a;
  private static final Handler jdField_a_of_type_AndroidOsHandler;
  private static DiskLruCache jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache;
  private static final ConcurrentHashMap<Long, anbp> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static final ConcurrentHashMap<Long, anbi> b;
  
  static
  {
    anbo localanbo = new anbo();
    jdField_a_of_type_Anbo = localanbo;
    QLog.i("ApolloScrshot", 4, "ApolloScreenshotController");
    b = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    HandlerThread localHandlerThread = new HandlerThread("ApolloScrshot");
    localHandlerThread.start();
    jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
    a();
    localanbo.b();
  }
  
  @JvmStatic
  public static final void a()
  {
    ApolloApngEncoder.a.a();
  }
  
  /* Error */
  private final void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 126	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore 4
    //   5: getstatic 128	anbo:jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   8: ifnull +23 -> 31
    //   11: aload_1
    //   12: checkcast 130	java/lang/CharSequence
    //   15: invokestatic 136	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifne +13 -> 31
    //   21: aload_2
    //   22: checkcast 130	java/lang/CharSequence
    //   25: invokestatic 136	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifeq +4 -> 32
    //   31: return
    //   32: aconst_null
    //   33: checkcast 138	java/io/FileInputStream
    //   36: astore 9
    //   38: aconst_null
    //   39: checkcast 140	java/io/BufferedOutputStream
    //   42: astore 11
    //   44: aconst_null
    //   45: checkcast 142	java/io/File
    //   48: astore 12
    //   50: new 142	java/io/File
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 143	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore 10
    //   60: aload 10
    //   62: invokevirtual 147	java/io/File:exists	()Z
    //   65: istore 8
    //   67: iload 8
    //   69: ifne +10 -> 79
    //   72: aload 10
    //   74: invokevirtual 150	java/io/File:delete	()Z
    //   77: pop
    //   78: return
    //   79: getstatic 128	anbo:jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   82: astore_1
    //   83: aload_1
    //   84: ifnonnull +6 -> 90
    //   87: invokestatic 155	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   90: aload_2
    //   91: ifnonnull +6 -> 97
    //   94: invokestatic 155	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   97: invokestatic 161	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   100: astore 12
    //   102: aload 12
    //   104: ldc 163
    //   106: invokestatic 167	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   109: aload_2
    //   110: ifnonnull +101 -> 211
    //   113: new 169	kotlin/TypeCastException
    //   116: dup
    //   117: ldc 171
    //   119: invokespecial 172	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   122: athrow
    //   123: astore 12
    //   125: aload 10
    //   127: astore_1
    //   128: aload 9
    //   130: astore_2
    //   131: aload 12
    //   133: astore 10
    //   135: aload 11
    //   137: astore 9
    //   139: ldc 64
    //   141: iconst_1
    //   142: ldc 174
    //   144: aload 10
    //   146: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   149: aload_2
    //   150: ifnull +7 -> 157
    //   153: aload_2
    //   154: invokevirtual 181	java/io/FileInputStream:close	()V
    //   157: aload 9
    //   159: ifnull +8 -> 167
    //   162: aload 9
    //   164: invokevirtual 182	java/io/BufferedOutputStream:close	()V
    //   167: aload_1
    //   168: ifnull +8 -> 176
    //   171: aload_1
    //   172: invokevirtual 150	java/io/File:delete	()Z
    //   175: pop
    //   176: invokestatic 126	android/os/SystemClock:elapsedRealtime	()J
    //   179: lstore 6
    //   181: ldc 64
    //   183: iconst_4
    //   184: new 184	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   191: ldc 187
    //   193: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: lload 6
    //   198: lload 4
    //   200: lsub
    //   201: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   204: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   210: return
    //   211: aload_2
    //   212: aload 12
    //   214: invokevirtual 207	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   217: astore_2
    //   218: aload_2
    //   219: ldc 209
    //   221: invokestatic 167	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   224: aload_1
    //   225: aload_2
    //   226: invokevirtual 215	com/jakewharton/disklrucache/DiskLruCache:edit	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Editor;
    //   229: astore 12
    //   231: new 140	java/io/BufferedOutputStream
    //   234: dup
    //   235: aload 12
    //   237: iconst_0
    //   238: invokevirtual 221	com/jakewharton/disklrucache/DiskLruCache$Editor:newOutputStream	(I)Ljava/io/OutputStream;
    //   241: invokespecial 224	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   244: astore_1
    //   245: new 138	java/io/FileInputStream
    //   248: dup
    //   249: aload 10
    //   251: invokespecial 227	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   254: astore_2
    //   255: sipush 8192
    //   258: newarray byte
    //   260: astore 9
    //   262: aload_2
    //   263: aload 9
    //   265: invokevirtual 231	java/io/FileInputStream:read	([B)I
    //   268: istore_3
    //   269: iload_3
    //   270: ifle +14 -> 284
    //   273: aload_1
    //   274: aload 9
    //   276: iconst_0
    //   277: iload_3
    //   278: invokevirtual 235	java/io/BufferedOutputStream:write	([BII)V
    //   281: goto -19 -> 262
    //   284: aload 12
    //   286: invokevirtual 238	com/jakewharton/disklrucache/DiskLruCache$Editor:commit	()V
    //   289: getstatic 128	anbo:jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   292: astore 9
    //   294: aload 9
    //   296: ifnonnull +6 -> 302
    //   299: invokestatic 155	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   302: aload 9
    //   304: invokevirtual 241	com/jakewharton/disklrucache/DiskLruCache:flush	()V
    //   307: aload_2
    //   308: invokevirtual 181	java/io/FileInputStream:close	()V
    //   311: aload_1
    //   312: invokevirtual 182	java/io/BufferedOutputStream:close	()V
    //   315: aload 10
    //   317: invokevirtual 150	java/io/File:delete	()Z
    //   320: pop
    //   321: goto -145 -> 176
    //   324: astore_1
    //   325: aload 12
    //   327: astore 10
    //   329: aload 9
    //   331: astore_2
    //   332: aload 11
    //   334: astore 9
    //   336: aload_2
    //   337: ifnull +7 -> 344
    //   340: aload_2
    //   341: invokevirtual 181	java/io/FileInputStream:close	()V
    //   344: aload 9
    //   346: ifnull +8 -> 354
    //   349: aload 9
    //   351: invokevirtual 182	java/io/BufferedOutputStream:close	()V
    //   354: aload 10
    //   356: ifnull +9 -> 365
    //   359: aload 10
    //   361: invokevirtual 150	java/io/File:delete	()Z
    //   364: pop
    //   365: aload_1
    //   366: athrow
    //   367: astore_1
    //   368: aload 9
    //   370: astore_2
    //   371: aload 11
    //   373: astore 9
    //   375: goto -39 -> 336
    //   378: astore 12
    //   380: aload_1
    //   381: astore 11
    //   383: aload 9
    //   385: astore_2
    //   386: aload 12
    //   388: astore_1
    //   389: aload 11
    //   391: astore 9
    //   393: goto -57 -> 336
    //   396: astore 11
    //   398: aload_1
    //   399: astore 9
    //   401: aload 11
    //   403: astore_1
    //   404: goto -68 -> 336
    //   407: astore 11
    //   409: aload_1
    //   410: astore 10
    //   412: aload 11
    //   414: astore_1
    //   415: goto -79 -> 336
    //   418: astore 10
    //   420: aload 9
    //   422: astore_2
    //   423: aload 12
    //   425: astore_1
    //   426: aload 11
    //   428: astore 9
    //   430: goto -291 -> 139
    //   433: astore 12
    //   435: aload_1
    //   436: astore_2
    //   437: aload 9
    //   439: astore 11
    //   441: aload 12
    //   443: astore_1
    //   444: aload 10
    //   446: astore 9
    //   448: aload_1
    //   449: astore 10
    //   451: aload 9
    //   453: astore_1
    //   454: aload_2
    //   455: astore 9
    //   457: aload 11
    //   459: astore_2
    //   460: goto -321 -> 139
    //   463: astore 11
    //   465: aload_1
    //   466: astore 9
    //   468: aload 10
    //   470: astore_1
    //   471: aload 11
    //   473: astore 10
    //   475: goto -336 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	478	0	this	anbo
    //   0	478	1	paramString1	String
    //   0	478	2	paramString2	String
    //   268	10	3	i	int
    //   3	196	4	l1	long
    //   179	18	6	l2	long
    //   65	3	8	bool	boolean
    //   36	431	9	localObject1	Object
    //   58	353	10	localObject2	Object
    //   418	27	10	localThrowable1	Throwable
    //   449	25	10	localObject3	Object
    //   42	348	11	localObject4	Object
    //   396	6	11	localObject5	Object
    //   407	20	11	localObject6	Object
    //   439	19	11	localObject7	Object
    //   463	9	11	localThrowable2	Throwable
    //   48	55	12	localObject8	Object
    //   123	90	12	localThrowable3	Throwable
    //   229	97	12	localEditor	com.jakewharton.disklrucache.DiskLruCache.Editor
    //   378	46	12	localObject9	Object
    //   433	9	12	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   60	67	123	java/lang/Throwable
    //   79	83	123	java/lang/Throwable
    //   87	90	123	java/lang/Throwable
    //   94	97	123	java/lang/Throwable
    //   97	109	123	java/lang/Throwable
    //   113	123	123	java/lang/Throwable
    //   211	245	123	java/lang/Throwable
    //   50	60	324	finally
    //   60	67	367	finally
    //   79	83	367	finally
    //   87	90	367	finally
    //   94	97	367	finally
    //   97	109	367	finally
    //   113	123	367	finally
    //   211	245	367	finally
    //   245	255	378	finally
    //   255	262	396	finally
    //   262	269	396	finally
    //   273	281	396	finally
    //   284	294	396	finally
    //   299	302	396	finally
    //   302	307	396	finally
    //   139	149	407	finally
    //   50	60	418	java/lang/Throwable
    //   245	255	433	java/lang/Throwable
    //   255	262	463	java/lang/Throwable
    //   262	269	463	java/lang/Throwable
    //   273	281	463	java/lang/Throwable
    //   284	294	463	java/lang/Throwable
    //   299	302	463	java/lang/Throwable
    //   302	307	463	java/lang/Throwable
  }
  
  @JvmStatic
  public static final boolean a(long paramLong, float paramFloat)
  {
    if (!ApolloApngEncoder.a.b()) {
      QLog.d("ApolloScrshot", 4, "onRecordFrameStart so not preloaded");
    }
    anbp localanbp;
    String str;
    boolean bool;
    int i;
    do
    {
      return false;
      localanbp = (anbp)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if ((paramLong < 0L) || (paramFloat <= 0) || (localanbp == null))
      {
        QLog.d("ApolloScrshot", 4, "onRecordFrameStart false");
        return false;
      }
      str = localanbp.a();
      bool = localanbp.a();
      i = localanbp.a();
      QLog.d("ApolloScrshot", 4, "onRecordFrameStart director:" + paramLong + ", frameTimeInSec:" + paramFloat + ", taskId:" + i + ", uniKey:" + str + ", isFrameRecord:" + bool);
    } while (TextUtils.isEmpty((CharSequence)str));
    int j = (int)(1000 * paramFloat);
    if (bool) {}
    for (Object localObject = EncodeType.FRAME;; localObject = EncodeType.APNG)
    {
      localObject = new anbi(i, str, j, (EncodeType)localObject, 0, 16, null);
      ((Map)b).put(Long.valueOf(paramLong), localObject);
      localanbp.a(paramLong);
      return true;
    }
  }
  
  @JvmStatic
  public static final boolean a(long paramLong, boolean paramBoolean)
  {
    QLog.d("ApolloScrshot", 4, "onRecordFrameEnd director:" + paramLong + ", complete:" + paramBoolean);
    anbi localanbi = (anbi)b.remove(Long.valueOf(paramLong));
    anbp localanbp = (anbp)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
    jdField_a_of_type_AndroidOsHandler.post((Runnable)new ApolloScreenshotController.onRecordFrameEnd.1(localanbi, paramBoolean, localanbp, paramLong));
    return true;
  }
  
  @JvmStatic
  public static final boolean a(long paramLong, @Nullable byte[] paramArrayOfByte, int paramInt1, int paramInt2, @Nullable ApolloRender paramApolloRender)
  {
    if (paramArrayOfByte != null) {
      if (paramArrayOfByte.length != 0) {
        break label33;
      }
    }
    label33:
    for (int i = 1; (i != 0) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramApolloRender == null); i = 0) {
      return false;
    }
    anbi localanbi = (anbi)b.get(Long.valueOf(paramLong));
    if (localanbi != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localanbi, "mResourceMap[director] ?: return false");
      if (localanbi.a())
      {
        localanbi.a(-13408);
        QLog.e("ApolloScrshot", 1, "onRecordFrame forceStopRecord, key:" + localanbi.b() + " taskId:" + localanbi.c() + " director:" + paramLong + " currentFrameCount:" + localanbi.b());
        paramApolloRender.stopRecord(localanbi.c(), false);
        return false;
      }
    }
    else
    {
      return false;
    }
    localanbi.a();
    try
    {
      paramArrayOfByte = (byte[])paramArrayOfByte.clone();
      QLog.d("ApolloScrshot", 4, "onRecordFrame key:" + localanbi.b() + " taskId:" + localanbi.c() + " director:" + paramLong + ", pixelSize:" + paramArrayOfByte.length + ", width:" + paramInt1 + ", height:" + paramInt2);
      jdField_a_of_type_AndroidOsHandler.post((Runnable)new ApolloScreenshotController.onRecordFrame.1(paramInt1, paramInt2, localanbi, paramArrayOfByte));
      if (localanbi.a() == EncodeType.FRAME) {
        paramApolloRender.stopRecord(localanbi.c(), true);
      }
      return true;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      localanbi.a(-13409);
      QLog.e("ApolloScrshot", 1, "onRecordFrame OOM", (Throwable)paramArrayOfByte);
      System.gc();
      paramApolloRender.stopRecord(localanbi.c(), false);
    }
    return false;
  }
  
  private final void b()
  {
    Object localObject;
    if (jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache != null)
    {
      localObject = jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if (!((DiskLruCache)localObject).isClosed()) {
        break label90;
      }
    }
    try
    {
      localObject = anbi.a.a();
      QLog.d("ApolloScrshot", 4, "initDiskLruCache " + (String)localObject);
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache = DiskLruCache.open((File)localObject, 1, 1, 52428800L);
      label90:
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloScrshot", 1, "initDiskLruCache", localThrowable);
    }
  }
  
  @Nullable
  public final File a(@NotNull String paramString)
  {
    Object localObject = null;
    Intrinsics.checkParameterIsNotNull(paramString, "recordKey");
    if (jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache != null)
    {
      DiskLruCache localDiskLruCache = jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache;
      if (localDiskLruCache == null) {
        Intrinsics.throwNpe();
      }
      if (localDiskLruCache.get(paramString) == null) {}
    }
    else
    {
      localObject = new File(anbi.a.a(paramString) + ".0");
      if ((!((File)localObject).exists()) || (((File)localObject).length() <= 0L)) {
        break label119;
      }
      QLog.d("ApolloScrshot", 4, "getRecord " + ((File)localObject).getPath());
    }
    for (paramString = (String)localObject;; paramString = null)
    {
      localObject = paramString;
      return localObject;
      label119:
      QLog.d("ApolloScrshot", 4, "getRecord " + paramString + " empty");
    }
  }
  
  public final void a(long paramLong, @NotNull anbp paramanbp)
  {
    Intrinsics.checkParameterIsNotNull(paramanbp, "listener");
    QLog.d("ApolloScrshot", 4, "setRecordListener for director: " + paramLong + " to listener:" + paramanbp);
    ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Long.valueOf(paramLong), paramanbp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbo
 * JD-Core Version:    0.7.0.1
 */