package com.tencent.mm.vfs;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public final class FileSystemManager
  implements Handler.Callback
{
  private static final int BROADCAST_FILE_VERSION = 2;
  private static final String FILE_BROADCAST = "fs.bin";
  private static final String FILE_MAINTENANCE_TIMESTAMP = "maintain.timestamp";
  private static final int MSG_MAINTENANCE = 2;
  private static final int MSG_REFRESH_VFS = 1;
  private static final String TAG = "VFS.FileSystemManager";
  private static final String VFS_DIR = ".vfs";
  @SuppressLint({"StaticFieldLeak"})
  private static volatile Context sContext;
  private static volatile FileSystemManager.KeyGen sKeyGen;
  private static volatile boolean sLoadBroadcast = true;
  private static StatisticsCallback sStatisticsCallback;
  private final Context mContext = sContext;
  private final ResolverState mInitialState;
  private FileSystemManager.Resolution mInvalidResolution;
  private final Object mLock = new Object();
  private final Handler mMaintenanceHandler;
  private volatile long mMaintenanceInterval;
  private final FileSystemManager.MaintenanceBroadcastReceiver mMaintenanceReceiver;
  private final HandlerThread mMaintenanceThread;
  private volatile boolean mMaintenanceUseWakeLock;
  private volatile long mMaintenanceWaitTime;
  private volatile boolean mPublishOnEditorCommit;
  private volatile BroadcastReceiver mRefreshReceiver;
  private int mRevision;
  private ResolverState mState;
  private final File mVFSDir;
  
  private FileSystemManager()
  {
    Object localObject = this.mContext;
    if (localObject != null)
    {
      File localFile = ((Context)localObject).getFilesDir().getParentFile();
      localObject = localFile;
      if (localFile == null) {
        localObject = this.mContext.getCacheDir();
      }
      this.mVFSDir = new File((File)localObject, ".vfs");
      this.mMaintenanceThread = new HandlerThread("VFS.Maintenance", 4);
      this.mMaintenanceThread.start();
      VFSTrack.track(null, "constructor_time");
      this.mMaintenanceHandler = new Handler(this.mMaintenanceThread.getLooper(), this);
      this.mMaintenanceReceiver = new FileSystemManager.MaintenanceBroadcastReceiver(this, null);
      this.mMaintenanceWaitTime = -1L;
      this.mMaintenanceInterval = 9223372036854775807L;
      this.mPublishOnEditorCommit = true;
      this.mInitialState = generateInitialState(this.mContext);
      this.mState = this.mInitialState;
      this.mRevision = 0;
      this.mInvalidResolution = new FileSystemManager.Resolution(null, null, this.mRevision, null);
      VFSTrack.track("constructor_time", null);
      return;
    }
    throw new IllegalStateException("Call FileSystemManager.setContext(Context) before calling instance()");
  }
  
  private void clearInvalidFiles(CancellationSignalCompat paramCancellationSignalCompat)
  {
    StatisticsCallback localStatisticsCallback = sStatisticsCallback;
    if (localStatisticsCallback != null) {
      localStatisticsCallback.deleteFiles(paramCancellationSignalCompat);
    }
  }
  
  private void doMaintenance(CancellationSignalCompat paramCancellationSignalCompat)
  {
    long l1 = this.mMaintenanceInterval;
    Object localObject = new File(this.mVFSDir, "maintain.timestamp");
    long l2 = System.currentTimeMillis();
    long l3 = ((File)localObject).lastModified();
    if (l2 - l3 < l1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VFS.FileSystemManager", 2, String.format("Maintenance interval not match, skip maintenance. ct=%d, ts=%d, int=%d", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1) }));
      }
      return;
    }
    boolean bool2 = this.mMaintenanceUseWakeLock;
    boolean bool1 = bool2;
    if (bool2) {
      if (this.mContext.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    localObject = null;
    if (bool1) {
      localObject = ((PowerManager)this.mContext.getSystemService("power")).newWakeLock(1, "VFS:Maintenance");
    }
    try
    {
      try
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Maintenance started. WakeLock: ");
          localStringBuilder.append(bool1);
          QLog.d("VFS.FileSystemManager", 2, localStringBuilder.toString());
        }
        if (localObject != null) {
          ((PowerManager.WakeLock)localObject).acquire(1200000L);
        }
        maintain(paramCancellationSignalCompat);
        clearInvalidFiles(paramCancellationSignalCompat);
        if (QLog.isColorLevel()) {
          QLog.d("VFS.FileSystemManager", 2, "Maintenance finished.");
        }
        if ((localObject == null) || (!((PowerManager.WakeLock)localObject).isHeld())) {
          break label304;
        }
      }
      finally
      {
        break label305;
      }
    }
    catch (OperationCanceledException paramCancellationSignalCompat)
    {
      break label277;
    }
    catch (Exception paramCancellationSignalCompat)
    {
      label252:
      break label252;
    }
    QLog.e("VFS.FileSystemManager", 1, "Maintenance failed.");
    if ((localObject != null) && (((PowerManager.WakeLock)localObject).isHeld()))
    {
      break label299;
      label277:
      QLog.e("VFS.FileSystemManager", 1, "Maintenance cancelled.");
      if ((localObject != null) && (((PowerManager.WakeLock)localObject).isHeld())) {
        label299:
        ((PowerManager.WakeLock)localObject).release();
      }
    }
    label304:
    return;
    label305:
    if ((localObject != null) && (((PowerManager.WakeLock)localObject).isHeld())) {
      ((PowerManager.WakeLock)localObject).release();
    }
    throw paramCancellationSignalCompat;
  }
  
  private static ResolverState generateInitialState(Context paramContext)
  {
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put(null, FileSchemeResolver.instance());
    localHashMap1.put("", FileSchemeResolver.instance());
    localHashMap1.put("file", FileSchemeResolver.instance());
    localHashMap1.put("wcf", WcfSchemeResolver.instance());
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("data", paramContext.getCacheDir().getParent());
    localHashMap2.put("dataCache", paramContext.getCacheDir().getPath());
    paramContext = paramContext.getExternalCacheDir();
    if (paramContext != null)
    {
      localHashMap2.put("extData", paramContext.getParent());
      localHashMap2.put("extCache", paramContext.getPath());
    }
    paramContext = Environment.getExternalStorageDirectory();
    if (paramContext != null) {
      localHashMap2.put("storage", paramContext.getPath());
    }
    return new ResolverState().update(localHashMap1, Collections.emptyMap(), new TreeMap(), localHashMap2, null);
  }
  
  static FileSystemManager.KeyGen getKeyGenerator()
  {
    return sKeyGen;
  }
  
  /* Error */
  private void initialize()
  {
    // Byte code:
    //   0: getstatic 369	com/tencent/mm/vfs/FileSystemManager:sLoadBroadcast	Z
    //   3: istore_3
    //   4: aconst_null
    //   5: astore 8
    //   7: aconst_null
    //   8: ldc_w 370
    //   11: invokestatic 111	com/tencent/mm/vfs/VFSTrack:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 91	com/tencent/mm/vfs/FileSystemManager:mVFSDir	Ljava/io/File;
    //   18: invokevirtual 373	java/io/File:mkdir	()Z
    //   21: pop
    //   22: new 253	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   29: astore 6
    //   31: aload 6
    //   33: ldc_w 375
    //   36: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 6
    //   42: invokestatic 381	android/os/Process:myPid	()I
    //   45: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: ldc 22
    //   51: iconst_1
    //   52: aload 6
    //   54: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 229	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: iload_3
    //   61: ifeq +351 -> 412
    //   64: invokestatic 390	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   67: astore 9
    //   69: new 80	java/io/File
    //   72: dup
    //   73: aload_0
    //   74: getfield 91	com/tencent/mm/vfs/FileSystemManager:mVFSDir	Ljava/io/File;
    //   77: ldc 13
    //   79: invokespecial 89	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   82: astore 6
    //   84: aload 6
    //   86: invokevirtual 393	java/io/File:length	()J
    //   89: lstore 4
    //   91: lload 4
    //   93: ldc2_w 394
    //   96: lcmp
    //   97: ifgt +157 -> 254
    //   100: lload 4
    //   102: ldc2_w 396
    //   105: lcmp
    //   106: ifgt +6 -> 112
    //   109: goto +145 -> 254
    //   112: lload 4
    //   114: l2i
    //   115: iconst_4
    //   116: isub
    //   117: istore_2
    //   118: iload_2
    //   119: newarray byte
    //   121: astore 10
    //   123: new 399	java/io/DataInputStream
    //   126: dup
    //   127: new 401	java/io/FileInputStream
    //   130: dup
    //   131: aload 6
    //   133: invokespecial 404	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   136: invokespecial 407	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   139: astore 7
    //   141: aload 7
    //   143: astore 6
    //   145: aload 7
    //   147: invokevirtual 410	java/io/DataInputStream:readInt	()I
    //   150: istore_1
    //   151: iload_1
    //   152: iconst_2
    //   153: if_icmpne +75 -> 228
    //   156: iconst_0
    //   157: istore_1
    //   158: iload_1
    //   159: iload_2
    //   160: if_icmpge +26 -> 186
    //   163: aload 7
    //   165: astore 6
    //   167: iload_1
    //   168: aload 7
    //   170: aload 10
    //   172: iload_1
    //   173: aload 10
    //   175: arraylength
    //   176: iload_1
    //   177: isub
    //   178: invokevirtual 414	java/io/DataInputStream:read	([BII)I
    //   181: iadd
    //   182: istore_1
    //   183: goto -25 -> 158
    //   186: aload 7
    //   188: astore 6
    //   190: aload 7
    //   192: invokevirtual 417	java/io/DataInputStream:close	()V
    //   195: aload 9
    //   197: aload 10
    //   199: iconst_0
    //   200: iload_1
    //   201: invokevirtual 421	android/os/Parcel:unmarshall	([BII)V
    //   204: aload 9
    //   206: iconst_0
    //   207: invokevirtual 425	android/os/Parcel:setDataPosition	(I)V
    //   210: aload_0
    //   211: aload 9
    //   213: ldc_w 427
    //   216: invokevirtual 433	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   219: invokevirtual 437	android/os/Parcel:readBundle	(Ljava/lang/ClassLoader;)Landroid/os/Bundle;
    //   222: invokespecial 441	com/tencent/mm/vfs/FileSystemManager:loadFromBundle	(Landroid/os/Bundle;)V
    //   225: goto +66 -> 291
    //   228: aload 7
    //   230: astore 6
    //   232: new 365	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   235: dup
    //   236: ldc 2
    //   238: iload_1
    //   239: iconst_2
    //   240: invokespecial 444	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException:<init>	(Ljava/lang/Class;II)V
    //   243: athrow
    //   244: astore 8
    //   246: goto +66 -> 312
    //   249: astore 8
    //   251: goto +100 -> 351
    //   254: new 253	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   261: astore 6
    //   263: aload 6
    //   265: ldc_w 446
    //   268: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload 6
    //   274: lload 4
    //   276: invokevirtual 449	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: ldc 22
    //   282: iconst_1
    //   283: aload 6
    //   285: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: aconst_null
    //   292: invokestatic 455	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   295: goto +96 -> 391
    //   298: astore 6
    //   300: aload 8
    //   302: astore 7
    //   304: goto +95 -> 399
    //   307: astore 8
    //   309: aconst_null
    //   310: astore 7
    //   312: aload 7
    //   314: astore 6
    //   316: aload_0
    //   317: aload 8
    //   319: invokespecial 459	com/tencent/mm/vfs/FileSystemManager:reportErrorInner	(Ljava/lang/Throwable;)V
    //   322: aload 7
    //   324: astore 6
    //   326: ldc 22
    //   328: iconst_1
    //   329: new 367	java/lang/Throwable
    //   332: dup
    //   333: ldc_w 461
    //   336: aload 8
    //   338: invokespecial 464	java/lang/Throwable:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   341: iconst_0
    //   342: anewarray 4	java/lang/Object
    //   345: invokestatic 467	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   348: goto +38 -> 386
    //   351: aload 7
    //   353: astore 6
    //   355: ldc 22
    //   357: iconst_1
    //   358: aload 8
    //   360: invokevirtual 470	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException:getMessage	()Ljava/lang/String;
    //   363: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   366: aload 7
    //   368: astore 6
    //   370: aload_0
    //   371: new 367	java/lang/Throwable
    //   374: dup
    //   375: ldc_w 461
    //   378: aload 8
    //   380: invokespecial 464	java/lang/Throwable:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   383: invokespecial 459	com/tencent/mm/vfs/FileSystemManager:reportErrorInner	(Ljava/lang/Throwable;)V
    //   386: aload 7
    //   388: invokestatic 455	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   391: aload 9
    //   393: invokevirtual 473	android/os/Parcel:recycle	()V
    //   396: goto +16 -> 412
    //   399: aload 7
    //   401: invokestatic 455	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   404: aload 9
    //   406: invokevirtual 473	android/os/Parcel:recycle	()V
    //   409: aload 6
    //   411: athrow
    //   412: aload_0
    //   413: iload_3
    //   414: invokevirtual 477	com/tencent/mm/vfs/FileSystemManager:setBroadcastReceivingEnabled	(Z)V
    //   417: aload_0
    //   418: invokevirtual 480	com/tencent/mm/vfs/FileSystemManager:enableMaintenance	()V
    //   421: ldc_w 370
    //   424: aconst_null
    //   425: invokestatic 111	com/tencent/mm/vfs/VFSTrack:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   428: return
    //   429: astore 8
    //   431: aload 6
    //   433: astore 7
    //   435: aload 8
    //   437: astore 6
    //   439: goto -40 -> 399
    //   442: astore 8
    //   444: aconst_null
    //   445: astore 7
    //   447: goto -96 -> 351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	450	0	this	FileSystemManager
    //   150	89	1	i	int
    //   117	44	2	j	int
    //   3	411	3	bool	boolean
    //   89	186	4	l	long
    //   29	255	6	localObject1	Object
    //   298	1	6	localObject2	Object
    //   314	124	6	localObject3	Object
    //   139	307	7	localObject4	Object
    //   5	1	8	localObject5	Object
    //   244	1	8	localThrowable1	Throwable
    //   249	52	8	localFileSystemVersionException1	VFSUtils.FileSystemVersionException
    //   307	72	8	localThrowable2	Throwable
    //   429	7	8	localObject6	Object
    //   442	1	8	localFileSystemVersionException2	VFSUtils.FileSystemVersionException
    //   67	338	9	localParcel	android.os.Parcel
    //   121	77	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   145	151	244	java/lang/Throwable
    //   167	183	244	java/lang/Throwable
    //   190	195	244	java/lang/Throwable
    //   232	244	244	java/lang/Throwable
    //   145	151	249	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   167	183	249	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   190	195	249	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   232	244	249	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   69	91	298	finally
    //   118	141	298	finally
    //   195	225	298	finally
    //   254	291	298	finally
    //   69	91	307	java/lang/Throwable
    //   118	141	307	java/lang/Throwable
    //   195	225	307	java/lang/Throwable
    //   254	291	307	java/lang/Throwable
    //   145	151	429	finally
    //   167	183	429	finally
    //   190	195	429	finally
    //   232	244	429	finally
    //   316	322	429	finally
    //   326	348	429	finally
    //   355	366	429	finally
    //   370	386	429	finally
    //   69	91	442	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   118	141	442	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   195	225	442	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   254	291	442	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
  }
  
  public static FileSystemManager instance()
  {
    return FileSystemManager.SingletonHolder.INSTANCE;
  }
  
  private void loadFromBundle(Bundle paramBundle)
  {
    ??? = paramBundle;
    if (paramBundle == null) {
      ??? = new Bundle();
    }
    if (((Bundle)???).getInt("pid") == Process.myPid())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VFS.FileSystemManager", 2, "Ignore filesystem change broadcast from the same process.");
      }
      return;
    }
    paramBundle = ResolverState.loadFromBundle((Bundle)???);
    Object localObject2 = paramBundle.envVars();
    synchronized (this.mLock)
    {
      this.mState = paramBundle;
      this.mRevision += 1;
      this.mInvalidResolution = new FileSystemManager.Resolution(null, null, this.mRevision, null);
      VFSTrack.track(null, "migrate_configure_time_bundle");
      paramBundle.mRootFileSystem.configure((Map)localObject2);
      Iterator localIterator = paramBundle.mSchemeResolvers.values().iterator();
      while (localIterator.hasNext()) {
        ((SchemeResolver)localIterator.next()).configure((Map)localObject2);
      }
      localIterator = paramBundle.mFileSystems.values().iterator();
      while (localIterator.hasNext()) {
        ((FileSystem)localIterator.next()).configure((Map)localObject2);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadFromBundle. fileSystem size");
      ((StringBuilder)localObject2).append(paramBundle.mFileSystems.size());
      QLog.d("VFS.FileSystemManager", 1, ((StringBuilder)localObject2).toString());
      VFSTrack.track("migrate_configure_time_bundle", null);
      ??? = new StringBuilder(2048);
      ((StringBuilder)???).append("[Schemes]\n");
      printChange(paramBundle.mSchemeResolvers, (StringBuilder)???);
      ((StringBuilder)???).append("[File systems]\n");
      printChange(paramBundle.mFileSystems, (StringBuilder)???);
      ((StringBuilder)???).append("[Mount points]\n");
      printChange(paramBundle.mMountPoints, (StringBuilder)???);
      ((StringBuilder)???).append("[Environment]\n");
      printChange(paramBundle.mEnvVars, (StringBuilder)???);
      ((StringBuilder)???).append("[Root]\n  ");
      ((StringBuilder)???).append(paramBundle.mRootFileSystem.toString());
      ((StringBuilder)???).append('\n');
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("Loaded file system from bundle:\n");
        paramBundle.append(((StringBuilder)???).toString());
        QLog.d("VFS.FileSystemManager", 2, paramBundle.toString());
      }
      return;
    }
    for (;;)
    {
      throw paramBundle;
    }
  }
  
  private static <K, V> void printChange(Map<K, V> paramMap, StringBuilder paramStringBuilder)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramStringBuilder.append("  ");
      paramStringBuilder.append(localEntry.getKey());
      if (localEntry.getValue() == null)
      {
        paramStringBuilder.append(" (deleted)\n");
      }
      else
      {
        paramStringBuilder.append(" => ");
        paramStringBuilder.append(localEntry.getValue().toString());
        paramStringBuilder.append('\n');
      }
    }
  }
  
  /* Error */
  private void publishFileSystems(ResolverState paramResolverState)
  {
    // Byte code:
    //   0: aconst_null
    //   1: ldc_w 610
    //   4: invokestatic 111	com/tencent/mm/vfs/VFSTrack:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_1
    //   8: invokevirtual 614	com/tencent/mm/vfs/ResolverState:writeToBundle	()Landroid/os/Bundle;
    //   11: astore 5
    //   13: invokestatic 390	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   16: astore_2
    //   17: aload_2
    //   18: aload 5
    //   20: invokevirtual 617	android/os/Parcel:writeBundle	(Landroid/os/Bundle;)V
    //   23: aload_2
    //   24: invokevirtual 621	android/os/Parcel:marshall	()[B
    //   27: astore 4
    //   29: aload_2
    //   30: invokevirtual 473	android/os/Parcel:recycle	()V
    //   33: new 80	java/io/File
    //   36: dup
    //   37: aload_0
    //   38: getfield 91	com/tencent/mm/vfs/FileSystemManager:mVFSDir	Ljava/io/File;
    //   41: ldc 13
    //   43: invokespecial 89	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   46: astore_2
    //   47: aload_2
    //   48: invokevirtual 624	java/io/File:exists	()Z
    //   51: ifne +8 -> 59
    //   54: aload_2
    //   55: invokevirtual 627	java/io/File:createNewFile	()Z
    //   58: pop
    //   59: new 629	java/io/DataOutputStream
    //   62: dup
    //   63: new 631	java/io/FileOutputStream
    //   66: dup
    //   67: aload_2
    //   68: invokespecial 632	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   71: invokespecial 635	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   74: astore_2
    //   75: aload_2
    //   76: astore_3
    //   77: aload_2
    //   78: iconst_2
    //   79: invokevirtual 638	java/io/DataOutputStream:writeInt	(I)V
    //   82: aload_2
    //   83: astore_3
    //   84: aload_2
    //   85: aload 4
    //   87: invokevirtual 642	java/io/DataOutputStream:write	([B)V
    //   90: aload_2
    //   91: invokestatic 455	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   94: goto +87 -> 181
    //   97: astore 4
    //   99: goto +13 -> 112
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_3
    //   105: goto +296 -> 401
    //   108: astore 4
    //   110: aconst_null
    //   111: astore_2
    //   112: aload_2
    //   113: astore_3
    //   114: aload_0
    //   115: new 367	java/lang/Throwable
    //   118: dup
    //   119: ldc_w 461
    //   122: aload 4
    //   124: invokespecial 464	java/lang/Throwable:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   127: invokespecial 459	com/tencent/mm/vfs/FileSystemManager:reportErrorInner	(Ljava/lang/Throwable;)V
    //   130: aload_2
    //   131: astore_3
    //   132: new 253	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   139: astore 6
    //   141: aload_2
    //   142: astore_3
    //   143: aload 6
    //   145: ldc_w 644
    //   148: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload_2
    //   153: astore_3
    //   154: aload 6
    //   156: aload 4
    //   158: invokevirtual 645	java/io/IOException:getMessage	()Ljava/lang/String;
    //   161: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_2
    //   166: astore_3
    //   167: ldc 22
    //   169: iconst_1
    //   170: aload 6
    //   172: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: goto -88 -> 90
    //   181: aload_0
    //   182: getfield 72	com/tencent/mm/vfs/FileSystemManager:mContext	Landroid/content/Context;
    //   185: invokevirtual 648	android/content/Context:getPackageName	()Ljava/lang/String;
    //   188: astore_2
    //   189: new 253	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   196: astore_3
    //   197: aload_3
    //   198: aload_2
    //   199: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload_3
    //   204: ldc_w 650
    //   207: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: new 652	android/content/Intent
    //   214: dup
    //   215: aload_3
    //   216: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokespecial 653	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   222: astore_2
    //   223: aload_2
    //   224: aload 5
    //   226: invokevirtual 657	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   229: pop
    //   230: aload_2
    //   231: ldc_w 492
    //   234: invokestatic 381	android/os/Process:myPid	()I
    //   237: invokevirtual 661	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   240: pop
    //   241: aload_0
    //   242: getfield 72	com/tencent/mm/vfs/FileSystemManager:mContext	Landroid/content/Context;
    //   245: aload_2
    //   246: invokevirtual 665	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   249: new 253	java/lang/StringBuilder
    //   252: dup
    //   253: sipush 2048
    //   256: invokespecial 551	java/lang/StringBuilder:<init>	(I)V
    //   259: astore_2
    //   260: aload_2
    //   261: ldc_w 553
    //   264: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload_1
    //   269: getfield 517	com/tencent/mm/vfs/ResolverState:mSchemeResolvers	Ljava/util/Map;
    //   272: aload_2
    //   273: invokestatic 557	com/tencent/mm/vfs/FileSystemManager:printChange	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   276: aload_2
    //   277: ldc_w 559
    //   280: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload_1
    //   285: getfield 544	com/tencent/mm/vfs/ResolverState:mFileSystems	Ljava/util/Map;
    //   288: aload_2
    //   289: invokestatic 557	com/tencent/mm/vfs/FileSystemManager:printChange	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   292: aload_2
    //   293: ldc_w 561
    //   296: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload_1
    //   301: getfield 565	com/tencent/mm/vfs/ResolverState:mMountPoints	Ljava/util/SortedMap;
    //   304: aload_2
    //   305: invokestatic 557	com/tencent/mm/vfs/FileSystemManager:printChange	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   308: aload_2
    //   309: ldc_w 567
    //   312: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_1
    //   317: getfield 570	com/tencent/mm/vfs/ResolverState:mEnvVars	Ljava/util/Map;
    //   320: aload_2
    //   321: invokestatic 557	com/tencent/mm/vfs/FileSystemManager:printChange	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   324: aload_2
    //   325: ldc_w 572
    //   328: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload_2
    //   333: aload_1
    //   334: getfield 509	com/tencent/mm/vfs/ResolverState:mRootFileSystem	Lcom/tencent/mm/vfs/FileSystem;
    //   337: invokevirtual 573	java/lang/Object:toString	()Ljava/lang/String;
    //   340: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload_2
    //   345: bipush 10
    //   347: invokevirtual 576	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   354: ifeq +38 -> 392
    //   357: new 253	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   364: astore_1
    //   365: aload_1
    //   366: ldc_w 667
    //   369: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload_1
    //   374: aload_2
    //   375: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: ldc 22
    //   384: iconst_2
    //   385: aload_1
    //   386: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 229	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   392: ldc_w 610
    //   395: aconst_null
    //   396: invokestatic 111	com/tencent/mm/vfs/VFSTrack:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   399: return
    //   400: astore_1
    //   401: aload_3
    //   402: invokestatic 455	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   405: goto +5 -> 410
    //   408: aload_1
    //   409: athrow
    //   410: goto -2 -> 408
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	this	FileSystemManager
    //   0	413	1	paramResolverState	ResolverState
    //   16	359	2	localObject1	Object
    //   76	326	3	localObject2	Object
    //   27	59	4	arrayOfByte	byte[]
    //   97	1	4	localIOException1	IOException
    //   108	49	4	localIOException2	IOException
    //   11	214	5	localBundle	Bundle
    //   139	32	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   77	82	97	java/io/IOException
    //   84	90	97	java/io/IOException
    //   33	59	102	finally
    //   59	75	102	finally
    //   33	59	108	java/io/IOException
    //   59	75	108	java/io/IOException
    //   77	82	400	finally
    //   84	90	400	finally
    //   114	130	400	finally
    //   132	141	400	finally
    //   143	152	400	finally
    //   154	165	400	finally
    //   167	178	400	finally
  }
  
  private void reportErrorInner(Throwable paramThrowable)
  {
    StatisticsCallback localStatisticsCallback = sStatisticsCallback;
    if (localStatisticsCallback != null) {
      localStatisticsCallback.reportError(paramThrowable);
    }
  }
  
  public static void setContext(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    if (localContext != null) {
      paramContext = localContext;
    }
    sContext = paramContext;
  }
  
  public static void setKeyGenerator(FileSystemManager.KeyGen paramKeyGen)
  {
    sKeyGen = paramKeyGen;
  }
  
  public static void setLoadBroadcast(boolean paramBoolean)
  {
    sLoadBroadcast = paramBoolean;
  }
  
  public static void setStatisticsCallback(StatisticsCallback paramStatisticsCallback)
  {
    sStatisticsCallback = paramStatisticsCallback;
  }
  
  public static StatisticsCallback statisticsCallback()
  {
    return sStatisticsCallback;
  }
  
  private void updateFileSystems(FileSystemManager.Editor paramEditor, boolean paramBoolean)
  {
    Object localObject2 = FileSystemManager.Editor.access$800(paramEditor);
    Object localObject1 = FileSystemManager.Editor.access$900(paramEditor);
    Object localObject3 = FileSystemManager.Editor.access$1000(paramEditor);
    HashMap localHashMap = FileSystemManager.Editor.access$1100(paramEditor);
    FileSystem localFileSystem = FileSystemManager.Editor.access$1200(paramEditor);
    boolean bool = FileSystemManager.Editor.access$1300(paramEditor);
    paramEditor = new StringBuilder();
    if (bool) {
      paramEditor.append("[CLEAN ALL]\n");
    }
    if (!((Map)localObject2).isEmpty())
    {
      paramEditor.append("[Scheme]\n");
      printChange((Map)localObject2, paramEditor);
    }
    if (!((Map)localObject1).isEmpty())
    {
      paramEditor.append("[File systems]\n");
      printChange((Map)localObject1, paramEditor);
    }
    if (!((SortedMap)localObject3).isEmpty())
    {
      paramEditor.append("[Mount points]\n");
      printChange((Map)localObject3, paramEditor);
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("updateFileSystems is called, fsChange size = ");
    ((StringBuilder)???).append(((Map)localObject1).size());
    ((StringBuilder)???).append(", mount change = ");
    ((StringBuilder)???).append(((SortedMap)localObject3).size());
    ((StringBuilder)???).append(", publish = ");
    ((StringBuilder)???).append(paramBoolean);
    QLog.d("VFS.FileSystemManager", 1, ((StringBuilder)???).toString());
    if (!localHashMap.isEmpty())
    {
      paramEditor.append("[Environment]\n");
      printChange(localHashMap, paramEditor);
    }
    if (localFileSystem != null)
    {
      paramEditor.append("[Root]\n  ");
      paramEditor.append(localFileSystem);
      paramEditor.append('\n');
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("File system configuration changed:\n");
      ((StringBuilder)???).append(paramEditor.toString());
      QLog.d("VFS.FileSystemManager", 2, ((StringBuilder)???).toString());
    }
    ??? = this.mLock;
    if (bool) {}
    try
    {
      paramEditor = this.mInitialState;
      break label332;
      paramEditor = this.mState;
      label332:
      int i = this.mRevision;
      for (;;)
      {
        VFSTrack.track(null, "update");
        paramEditor = paramEditor.update((Map)localObject2, (Map)localObject1, (SortedMap)localObject3, localHashMap, localFileSystem);
        VFSTrack.track("update", null);
        Map localMap = paramEditor.envVars();
        ??? = new StringBuilder();
        ((StringBuilder)???).append("updateFileSystems is called revision = ");
        ((StringBuilder)???).append(i);
        ((StringBuilder)???).append(", mRevision = ");
        ((StringBuilder)???).append(this.mRevision);
        QLog.d("VFS.FileSystemManager", 1, ((StringBuilder)???).toString());
        synchronized (this.mLock)
        {
          if (i != this.mRevision)
          {
            if (bool) {
              paramEditor = this.mInitialState;
            } else {
              paramEditor = this.mState;
            }
            i = this.mRevision;
          }
          else
          {
            this.mState = paramEditor;
            this.mRevision = (i + 1);
            this.mInvalidResolution = new FileSystemManager.Resolution(null, null, this.mRevision, null);
            VFSTrack.track(null, "migrate_configure_time_update");
            if ((!bool) && (localHashMap.isEmpty()))
            {
              if (localFileSystem != null) {
                paramEditor.mRootFileSystem.configure(localMap);
              }
              localObject2 = ((Map)localObject2).values().iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (SchemeResolver)((Iterator)localObject2).next();
                if (localObject3 != null) {
                  ((SchemeResolver)localObject3).configure(localMap);
                }
              }
              localObject1 = ((Map)localObject1).values().iterator();
            }
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (FileSystem)((Iterator)localObject1).next();
              if (localObject2 != null)
              {
                ((FileSystem)localObject2).configure(localMap);
                continue;
                paramEditor.mRootFileSystem.configure(localMap);
                localObject1 = paramEditor.mSchemeResolvers.values().iterator();
                while (((Iterator)localObject1).hasNext()) {
                  ((SchemeResolver)((Iterator)localObject1).next()).configure(localMap);
                }
                localObject1 = paramEditor.mFileSystems.values().iterator();
                while (((Iterator)localObject1).hasNext()) {
                  ((FileSystem)((Iterator)localObject1).next()).configure(localMap);
                }
              }
            }
            VFSTrack.track("migrate_configure_time_update", null);
            if (paramBoolean) {
              publishFileSystems(paramEditor);
            }
            return;
          }
        }
      }
      throw paramEditor;
    }
    finally {}
    for (;;) {}
  }
  
  public void disableMaintenance()
  {
    enableMaintenance(-1L, 9223372036854775807L, false);
  }
  
  public FileSystemManager.Editor edit()
  {
    return new FileSystemManager.Editor(this);
  }
  
  public void enableMaintenance()
  {
    VFSTrack.track(null, "enableMaintenance");
    enableMaintenance(420000L, 259200000L, true);
    VFSTrack.track("enableMaintenance", null);
  }
  
  public void enableMaintenance(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    long l = this.mMaintenanceWaitTime;
    if ((paramLong1 >= 0L) && (l < 0L))
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      this.mContext.registerReceiver(this.mMaintenanceReceiver, localIntentFilter);
      this.mMaintenanceReceiver.refreshIdleStatus(this.mContext);
    }
    else if ((paramLong1 < 0L) && (l >= 0L))
    {
      this.mContext.unregisterReceiver(this.mMaintenanceReceiver);
    }
    this.mMaintenanceWaitTime = paramLong1;
    this.mMaintenanceInterval = paramLong2;
    this.mMaintenanceUseWakeLock = paramBoolean;
  }
  
  public Map<String, String> environmentVariables()
  {
    synchronized (this.mLock)
    {
      Map localMap = this.mState.envVars();
      return localMap;
    }
  }
  
  Uri exportUri(Uri paramUri)
  {
    synchronized (this.mLock)
    {
      ResolverState localResolverState = this.mState;
      ??? = paramUri.getScheme();
      ??? = (SchemeResolver)localResolverState.mSchemeResolvers.get(???);
      if (??? == null) {
        return null;
      }
      return ((SchemeResolver)???).exportUri(localResolverState, paramUri);
    }
  }
  
  public Map<String, FileSystem> fileSystems()
  {
    synchronized (this.mLock)
    {
      Map localMap = this.mState.fileSystems();
      return localMap;
    }
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return false;
      }
      doMaintenance((CancellationSignalCompat)paramMessage.obj);
      return true;
    }
    paramMessage = (Intent)paramMessage.obj;
    paramMessage.setExtrasClassLoader(FileSystem.class.getClassLoader());
    if (QLog.isColorLevel()) {
      QLog.d("VFS.FileSystemManager", 2, "Refresh file system from broadcast.");
    }
    try
    {
      loadFromBundle(paramMessage.getExtras());
      return true;
    }
    catch (Throwable paramMessage)
    {
      QLog.e("VFS.FileSystemManager", 1, "Failed to refresh file system from broadcast.", paramMessage);
    }
    return true;
  }
  
  public boolean isValidConfigFile(Context paramContext)
  {
    if (paramContext != null)
    {
      File localFile2 = paramContext.getFilesDir().getParentFile();
      File localFile1 = localFile2;
      if (localFile2 == null) {
        localFile1 = paramContext.getCacheDir();
      }
      paramContext = new File(new File(localFile1, ".vfs"), "fs.bin");
      if (!paramContext.exists()) {
        reportErrorInner(new Throwable("VFSSystemManager isValidConfigFile broadcastFile not exist!"));
      }
      long l = paramContext.length();
      if ((l <= 1048576L) && (l > 4L)) {
        return true;
      }
      paramContext = new StringBuilder();
      paramContext.append("VFSSystemManager Invalid parcel file size: ");
      paramContext.append(l);
      reportErrorInner(new Throwable(paramContext.toString()));
    }
    return false;
  }
  
  public void maintain(CancellationSignalCompat paramCancellationSignalCompat)
  {
    Object localObject1 = new File(this.mVFSDir, "maintain.timestamp");
    synchronized (this.mLock)
    {
      Object localObject2 = this.mState;
      ??? = ((ResolverState)localObject2).mSchemeResolvers.entrySet().iterator();
      Object localObject4;
      Object localObject5;
      while (((Iterator)???).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)???).next();
        localObject5 = (SchemeResolver)((Map.Entry)localObject4).getValue();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[Maintenance] ");
          localStringBuilder.append((String)((Map.Entry)localObject4).getKey());
          localStringBuilder.append(" => ");
          localStringBuilder.append(localObject5.toString());
          QLog.i("VFS.FileSystemManager", 2, localStringBuilder.toString());
        }
        ((SchemeResolver)localObject5).maintain(paramCancellationSignalCompat);
      }
      localObject2 = ((ResolverState)localObject2).mFileSystems.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (Map.Entry)((Iterator)localObject2).next();
        localObject4 = (FileSystem)((Map.Entry)???).getValue();
        if (QLog.isColorLevel())
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("[Maintenance] ");
          ((StringBuilder)localObject5).append((String)((Map.Entry)???).getKey());
          ((StringBuilder)localObject5).append(" => ");
          ((StringBuilder)localObject5).append(localObject4.toString());
          QLog.i("VFS.FileSystemManager", 2, ((StringBuilder)localObject5).toString());
        }
        ((FileSystem)localObject4).maintain(paramCancellationSignalCompat);
      }
      try
      {
        ((File)localObject1).createNewFile();
        ((File)localObject1).setLastModified(System.currentTimeMillis());
        return;
      }
      catch (IOException paramCancellationSignalCompat)
      {
        reportErrorInner(new Throwable("VFSSystemManager maintain error", paramCancellationSignalCompat));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Unable to update maintenance timestamp: ");
        ((StringBuilder)localObject1).append(paramCancellationSignalCompat.getMessage());
        QLog.e("VFS.FileSystemManager", 1, ((StringBuilder)localObject1).toString());
        return;
      }
    }
    for (;;)
    {
      throw paramCancellationSignalCompat;
    }
  }
  
  Looper maintenanceLooper()
  {
    return this.mMaintenanceThread.getLooper();
  }
  
  public void publish()
  {
    synchronized (this.mLock)
    {
      ResolverState localResolverState = this.mState;
      publishFileSystems(localResolverState);
      return;
    }
  }
  
  public void publishOnEditorCommit(boolean paramBoolean)
  {
    this.mPublishOnEditorCommit = paramBoolean;
  }
  
  FileSystemManager.Resolution resolve(Uri paramUri)
  {
    return resolve(paramUri, null);
  }
  
  FileSystemManager.Resolution resolve(Uri paramUri, FileSystemManager.Resolution paramResolution)
  {
    Object localObject = this.mLock;
    if (paramResolution != null) {}
    try
    {
      if (paramResolution.revision == this.mRevision) {
        return paramResolution;
      }
      ResolverState localResolverState = this.mState;
      int i = this.mRevision;
      paramResolution = this.mInvalidResolution;
      localObject = paramUri.getScheme();
      localObject = (SchemeResolver)localResolverState.mSchemeResolvers.get(localObject);
      if (localObject == null)
      {
        paramUri = new StringBuilder();
        paramUri.append("resolve is wrong! revoler is null,  resolvers size = ");
        paramUri.append(localResolverState.mSchemeResolvers.size());
        QLog.e("VFS.FileSystemManager", 1, paramUri.toString());
        return paramResolution;
      }
      paramUri = ((SchemeResolver)localObject).resolve(localResolverState, paramUri);
      if (paramUri == null) {
        return paramResolution;
      }
      return new FileSystemManager.Resolution((FileSystem)paramUri.first, (String)paramUri.second, i, null);
    }
    finally {}
  }
  
  public void setBroadcastReceivingEnabled(boolean paramBoolean)
  {
    VFSTrack.track(null, "setBroadcastReceivingEnabled");
    Object localObject = this.mRefreshReceiver;
    if ((localObject == null) && (paramBoolean))
    {
      localObject = new FileSystemManager.1(this);
      this.mRefreshReceiver = ((BroadcastReceiver)localObject);
      String str = this.mContext.getPackageName();
      Context localContext = this.mContext;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(".REFRESH_VFS");
      localContext.registerReceiver((BroadcastReceiver)localObject, new IntentFilter(localStringBuilder.toString()), "com.tencent.mobileqq.permission.MM_MESSAGE", null);
      if (QLog.isColorLevel()) {
        QLog.d("VFS.FileSystemManager", 2, "Broadcast receiving enabled.");
      }
    }
    else if ((localObject != null) && (!paramBoolean))
    {
      this.mContext.unregisterReceiver((BroadcastReceiver)localObject);
      this.mRefreshReceiver = null;
      if (QLog.isColorLevel()) {
        QLog.d("VFS.FileSystemManager", 2, "Broadcast receiving disabled.");
      }
    }
    VFSTrack.track("setBroadcastReceivingEnabled", null);
  }
  
  Map<String, String> staticEnvironment()
  {
    return this.mInitialState.envVars();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystemManager
 * JD-Core Version:    0.7.0.1
 */