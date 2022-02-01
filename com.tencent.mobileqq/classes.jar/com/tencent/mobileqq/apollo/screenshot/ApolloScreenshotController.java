package com.tencent.mobileqq.apollo.screenshot;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.jakewharton.disklrucache.DiskLruCache;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.api.player.model.BusinessConfig;
import com.tencent.mobileqq.apollo.player.CMSHelper.TF;
import com.tencent.mobileqq.apollo.utils.CmShowWnsUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/ApolloScreenshotController;", "", "()V", "DISK_CACHE_MAX_SIZE", "", "TAG", "", "mAsyncThreadPool", "Ljava/util/concurrent/Executor;", "mDiskLruCache", "Lcom/jakewharton/disklrucache/DiskLruCache;", "mRecordHandler", "Landroid/os/Handler;", "mRecordListenerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloActionRecordListener;", "mResourceMap", "Lcom/tencent/mobileqq/apollo/screenshot/ApolloCoderResource;", "correctSizeIfNeed", "", "viewSize", "recordSize", "getRecord", "Ljava/io/File;", "recordKey", "initDiskLruCache", "", "initThreadPool", "moveFileToDiskCache", "filePath", "key", "onRecordFrame", "", "director", "pixels", "", "width", "height", "apolloRender", "Lcom/tencent/mobileqq/apollo/ApolloRender;", "onRecordFrameEnd", "actionCompleted", "onRecordFrameStart", "frameTimeInSec", "", "preloadSoIfNeed", "setRecordListener", "listener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ApolloScreenshotController
{
  private static final Handler jdField_a_of_type_AndroidOsHandler;
  private static DiskLruCache jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache;
  public static final ApolloScreenshotController a;
  private static final ConcurrentHashMap<Long, IApolloActionRecordListener> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  private static final ConcurrentHashMap<Long, ApolloCoderResource> b;
  
  static
  {
    ApolloScreenshotController localApolloScreenshotController = new ApolloScreenshotController();
    jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloScreenshotController = localApolloScreenshotController;
    QLog.i("ApolloScrshot", 4, "ApolloScreenshotController");
    b = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    HandlerThread localHandlerThread = new HandlerThread("ApolloScrshot");
    localHandlerThread.start();
    jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
    a();
    localApolloScreenshotController.b();
    localApolloScreenshotController.c();
  }
  
  private final int a(int paramInt1, int paramInt2)
  {
    int i;
    if ((!CmShowWnsUtils.m()) || (paramInt1 <= 0) || (paramInt1 == paramInt2)) {
      i = paramInt2;
    }
    do
    {
      return i;
      i = paramInt1;
    } while (!QLog.isColorLevel());
    QLog.w("ApolloScrshot", 1, "correctSize from recordSize:" + paramInt2 + " to viewSize:" + paramInt1);
    return paramInt1;
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
    //   0: invokestatic 177	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore 4
    //   5: getstatic 179	com/tencent/mobileqq/apollo/screenshot/ApolloScreenshotController:jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   8: ifnull +23 -> 31
    //   11: aload_1
    //   12: checkcast 181	java/lang/CharSequence
    //   15: invokestatic 187	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifne +13 -> 31
    //   21: aload_2
    //   22: checkcast 181	java/lang/CharSequence
    //   25: invokestatic 187	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifeq +4 -> 32
    //   31: return
    //   32: aconst_null
    //   33: checkcast 189	java/io/FileInputStream
    //   36: astore 9
    //   38: aconst_null
    //   39: checkcast 191	java/io/BufferedOutputStream
    //   42: astore 11
    //   44: aconst_null
    //   45: checkcast 193	java/io/File
    //   48: astore 12
    //   50: new 193	java/io/File
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore 10
    //   60: aload 10
    //   62: invokevirtual 197	java/io/File:exists	()Z
    //   65: istore 8
    //   67: iload 8
    //   69: ifne +10 -> 79
    //   72: aload 10
    //   74: invokevirtual 200	java/io/File:delete	()Z
    //   77: pop
    //   78: return
    //   79: getstatic 179	com/tencent/mobileqq/apollo/screenshot/ApolloScreenshotController:jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   82: astore_1
    //   83: aload_1
    //   84: ifnonnull +6 -> 90
    //   87: invokestatic 203	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   90: aload_2
    //   91: ifnonnull +6 -> 97
    //   94: invokestatic 203	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   97: invokestatic 209	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   100: astore 12
    //   102: aload 12
    //   104: ldc 211
    //   106: invokestatic 215	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   109: aload_2
    //   110: ifnonnull +101 -> 211
    //   113: new 217	kotlin/TypeCastException
    //   116: dup
    //   117: ldc 219
    //   119: invokespecial 220	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
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
    //   139: ldc 69
    //   141: iconst_1
    //   142: ldc 222
    //   144: aload 10
    //   146: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   149: aload_2
    //   150: ifnull +7 -> 157
    //   153: aload_2
    //   154: invokevirtual 229	java/io/FileInputStream:close	()V
    //   157: aload 9
    //   159: ifnull +8 -> 167
    //   162: aload 9
    //   164: invokevirtual 230	java/io/BufferedOutputStream:close	()V
    //   167: aload_1
    //   168: ifnull +8 -> 176
    //   171: aload_1
    //   172: invokevirtual 200	java/io/File:delete	()Z
    //   175: pop
    //   176: invokestatic 177	android/os/SystemClock:elapsedRealtime	()J
    //   179: lstore 6
    //   181: ldc 69
    //   183: iconst_4
    //   184: new 124	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   191: ldc 232
    //   193: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: lload 6
    //   198: lload 4
    //   200: lsub
    //   201: invokevirtual 235	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   204: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   210: return
    //   211: aload_2
    //   212: aload 12
    //   214: invokevirtual 244	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   217: astore_2
    //   218: aload_2
    //   219: ldc 246
    //   221: invokestatic 215	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   224: aload_1
    //   225: aload_2
    //   226: invokevirtual 252	com/jakewharton/disklrucache/DiskLruCache:edit	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Editor;
    //   229: astore 12
    //   231: new 191	java/io/BufferedOutputStream
    //   234: dup
    //   235: aload 12
    //   237: iconst_0
    //   238: invokevirtual 258	com/jakewharton/disklrucache/DiskLruCache$Editor:newOutputStream	(I)Ljava/io/OutputStream;
    //   241: invokespecial 261	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   244: astore_1
    //   245: new 189	java/io/FileInputStream
    //   248: dup
    //   249: aload 10
    //   251: invokespecial 264	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   254: astore_2
    //   255: sipush 8192
    //   258: newarray byte
    //   260: astore 9
    //   262: aload_2
    //   263: aload 9
    //   265: invokevirtual 268	java/io/FileInputStream:read	([B)I
    //   268: istore_3
    //   269: iload_3
    //   270: ifle +14 -> 284
    //   273: aload_1
    //   274: aload 9
    //   276: iconst_0
    //   277: iload_3
    //   278: invokevirtual 272	java/io/BufferedOutputStream:write	([BII)V
    //   281: goto -19 -> 262
    //   284: aload 12
    //   286: invokevirtual 275	com/jakewharton/disklrucache/DiskLruCache$Editor:commit	()V
    //   289: getstatic 179	com/tencent/mobileqq/apollo/screenshot/ApolloScreenshotController:jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   292: astore 9
    //   294: aload 9
    //   296: ifnonnull +6 -> 302
    //   299: invokestatic 203	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   302: aload 9
    //   304: invokevirtual 278	com/jakewharton/disklrucache/DiskLruCache:flush	()V
    //   307: aload_2
    //   308: invokevirtual 229	java/io/FileInputStream:close	()V
    //   311: aload_1
    //   312: invokevirtual 230	java/io/BufferedOutputStream:close	()V
    //   315: aload 10
    //   317: invokevirtual 200	java/io/File:delete	()Z
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
    //   341: invokevirtual 229	java/io/FileInputStream:close	()V
    //   344: aload 9
    //   346: ifnull +8 -> 354
    //   349: aload 9
    //   351: invokevirtual 230	java/io/BufferedOutputStream:close	()V
    //   354: aload 10
    //   356: ifnull +9 -> 365
    //   359: aload 10
    //   361: invokevirtual 200	java/io/File:delete	()Z
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
    //   0	478	0	this	ApolloScreenshotController
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
    IApolloActionRecordListener localIApolloActionRecordListener;
    String str;
    Object localObject;
    int i;
    BusinessConfig localBusinessConfig;
    do
    {
      return false;
      localIApolloActionRecordListener = (IApolloActionRecordListener)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if ((paramLong < 0L) || (paramFloat <= 0) || (localIApolloActionRecordListener == null))
      {
        QLog.d("ApolloScrshot", 4, "onRecordFrameStart false");
        return false;
      }
      str = localIApolloActionRecordListener.a();
      localObject = localIApolloActionRecordListener.a();
      i = localIApolloActionRecordListener.a();
      localBusinessConfig = localIApolloActionRecordListener.a();
      if (localBusinessConfig == null) {
        break;
      }
      QLog.d("ApolloScrshot", 4, "onRecordFrameStart director:" + paramLong + ", frameTimeInSec:" + paramFloat + ", taskId:" + i + ", uniKey:" + str + ", getRecordMode:" + localObject);
    } while (TextUtils.isEmpty((CharSequence)str));
    int j = (int)(1000 * paramFloat);
    switch (ApolloScreenshotController.WhenMappings.a[localObject.ordinal()])
    {
    default: 
      localObject = EncodeType.APNG;
    }
    for (;;)
    {
      localObject = new ApolloCoderResource(i, str, j, (EncodeType)localObject, localBusinessConfig, 0, 32, null);
      ((Map)b).put(Long.valueOf(paramLong), localObject);
      localIApolloActionRecordListener.a();
      return true;
      localBusinessConfig = new BusinessConfig();
      break;
      localObject = EncodeType.FRAME;
      continue;
      localObject = EncodeType.GIF;
    }
  }
  
  @JvmStatic
  public static final boolean a(long paramLong, boolean paramBoolean)
  {
    QLog.d("ApolloScrshot", 4, "onRecordFrameEnd director:" + paramLong + ", complete:" + paramBoolean);
    ApolloCoderResource localApolloCoderResource = (ApolloCoderResource)b.remove(Long.valueOf(paramLong));
    IApolloActionRecordListener localIApolloActionRecordListener = (IApolloActionRecordListener)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
    if ((localApolloCoderResource != null) && (localIApolloActionRecordListener != null)) {
      localIApolloActionRecordListener.a(localApolloCoderResource.a());
    }
    jdField_a_of_type_AndroidOsHandler.post((Runnable)new ApolloScreenshotController.onRecordFrameEnd.2(localApolloCoderResource, paramBoolean, localIApolloActionRecordListener, paramLong));
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
    ApolloCoderResource localApolloCoderResource = (ApolloCoderResource)b.get(Long.valueOf(paramLong));
    if (localApolloCoderResource != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localApolloCoderResource, "mResourceMap[director] ?: return false");
      if (localApolloCoderResource.a())
      {
        localApolloCoderResource.a(-13408);
        QLog.e("ApolloScrshot", 1, "onRecordFrame forceStopRecord, key:" + localApolloCoderResource.c() + " taskId:" + localApolloCoderResource.c() + " director:" + paramLong + " currentFrameCount:" + localApolloCoderResource.b());
        paramApolloRender.stopRecord(localApolloCoderResource.c(), false);
        return false;
      }
    }
    else
    {
      return false;
    }
    localApolloCoderResource.a();
    try
    {
      paramArrayOfByte = (byte[])paramArrayOfByte.clone();
      QLog.d("ApolloScrshot", 4, "onRecordFrame key:" + localApolloCoderResource.c() + " taskId:" + localApolloCoderResource.c() + " director:" + paramLong + ", pixelSize:" + paramArrayOfByte.length + ", width:" + paramInt1 + ", height:" + paramInt2);
      IApolloActionRecordListener localIApolloActionRecordListener = (IApolloActionRecordListener)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      jdField_a_of_type_AndroidOsHandler.post((Runnable)new ApolloScreenshotController.onRecordFrame.1(localIApolloActionRecordListener, paramInt1, paramInt2, paramArrayOfByte, localApolloCoderResource));
      if (localApolloCoderResource.a() == EncodeType.FRAME) {
        paramApolloRender.stopRecord(localApolloCoderResource.c(), true);
      }
      return true;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      localApolloCoderResource.a(-13409);
      QLog.e("ApolloScrshot", 1, "onRecordFrame OOM", (Throwable)paramArrayOfByte);
      System.gc();
      paramApolloRender.stopRecord(localApolloCoderResource.c(), false);
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
      if (!((DiskLruCache)localObject).isClosed()) {}
    }
    else
    {
      try
      {
        localObject = ApolloCoderResource.a.a();
        QLog.d("ApolloScrshot", 4, "initDiskLruCache " + (String)localObject);
        if (localObject == null) {
          return;
        }
        localObject = new File((String)localObject);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache = DiskLruCache.open((File)localObject, 1, 1, 52428800L);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ApolloScrshot", 1, "initDiskLruCache", localThrowable);
      }
    }
  }
  
  private final void c()
  {
    int i = CmShowWnsUtils.a();
    QLog.i("ApolloScrshot", 1, "initThreadPool size:" + i);
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(i, i, 1L, TimeUnit.MINUTES, (BlockingQueue)new LinkedBlockingQueue(), (ThreadFactory)new CMSHelper.TF("ApolloScrshot_AsyncThread", 9));
    localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    jdField_a_of_type_JavaUtilConcurrentExecutor = (Executor)localThreadPoolExecutor;
  }
  
  @Nullable
  public final File a(@NotNull String paramString)
  {
    Object localObject = null;
    Intrinsics.checkParameterIsNotNull(paramString, "recordKey");
    try
    {
      if (jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache != null)
      {
        DiskLruCache localDiskLruCache = jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache;
        if (localDiskLruCache == null) {
          Intrinsics.throwNpe();
        }
        if (localDiskLruCache.get(paramString) == null) {
          return localObject;
        }
      }
      localObject = new File(Intrinsics.stringPlus(ApolloCoderResource.a.a(paramString), ".0"));
      if ((((File)localObject).exists()) && (((File)localObject).length() > 0L))
      {
        QLog.d("ApolloScrshot", 4, "getRecord " + ((File)localObject).getPath());
        paramString = (String)localObject;
      }
      else
      {
        QLog.d("ApolloScrshot", 4, "getRecord " + paramString + " empty");
        paramString = null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("ApolloScrshot", 1, "getRecord error", paramString);
      paramString = null;
    }
    localObject = paramString;
    return localObject;
  }
  
  public final void a(long paramLong, @NotNull IApolloActionRecordListener paramIApolloActionRecordListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIApolloActionRecordListener, "listener");
    QLog.d("ApolloScrshot", 4, "setRecordListener for director: " + paramLong + " to listener:" + paramIApolloActionRecordListener);
    ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Long.valueOf(paramLong), paramIApolloActionRecordListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController
 * JD-Core Version:    0.7.0.1
 */