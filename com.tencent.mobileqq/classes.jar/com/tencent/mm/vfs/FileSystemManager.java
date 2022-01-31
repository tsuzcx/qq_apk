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
  private static volatile Context sContext = null;
  private static volatile FileSystemManager.KeyGen sKeyGen = null;
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
    if (this.mContext == null) {
      throw new IllegalStateException("Call FileSystemManager.setContext(Context) before calling instance()");
    }
    File localFile2 = this.mContext.getFilesDir().getParentFile();
    File localFile1 = localFile2;
    if (localFile2 == null) {
      localFile1 = this.mContext.getCacheDir();
    }
    this.mVFSDir = new File(localFile1, ".vfs");
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
  }
  
  private void clearInvalidFiles(CancellationSignalCompat paramCancellationSignalCompat)
  {
    if (sStatisticsCallback != null) {
      sStatisticsCallback.deleteFiles(paramCancellationSignalCompat);
    }
  }
  
  private void doMaintenance(CancellationSignalCompat paramCancellationSignalCompat)
  {
    boolean bool2 = false;
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
    boolean bool3 = this.mMaintenanceUseWakeLock;
    boolean bool1 = bool3;
    if (bool3)
    {
      bool1 = bool2;
      if (this.mContext.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
        bool1 = true;
      }
    }
    if (bool1) {}
    for (localObject = ((PowerManager)this.mContext.getSystemService("power")).newWakeLock(1, "VFS:Maintenance");; localObject = null) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("VFS.FileSystemManager", 2, "Maintenance started. WakeLock: " + bool1);
        }
        if (localObject != null) {
          ((PowerManager.WakeLock)localObject).acquire(1200000L);
        }
        maintain(paramCancellationSignalCompat);
        clearInvalidFiles(paramCancellationSignalCompat);
        if (QLog.isColorLevel()) {
          QLog.d("VFS.FileSystemManager", 2, "Maintenance finished.");
        }
        return;
      }
      catch (OperationCanceledException paramCancellationSignalCompat)
      {
        QLog.e("VFS.FileSystemManager", 1, "Maintenance cancelled.");
        return;
      }
      catch (Exception paramCancellationSignalCompat)
      {
        QLog.e("VFS.FileSystemManager", 1, "Maintenance failed.");
        return;
      }
      finally
      {
        if ((localObject != null) && (((PowerManager.WakeLock)localObject).isHeld())) {
          ((PowerManager.WakeLock)localObject).release();
        }
      }
    }
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
    //   0: aconst_null
    //   1: astore 9
    //   3: iconst_0
    //   4: istore_1
    //   5: getstatic 68	com/tencent/mm/vfs/FileSystemManager:sLoadBroadcast	Z
    //   8: istore 4
    //   10: aconst_null
    //   11: ldc_w 370
    //   14: invokestatic 122	com/tencent/mm/vfs/VFSTrack:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 102	com/tencent/mm/vfs/FileSystemManager:mVFSDir	Ljava/io/File;
    //   21: invokevirtual 373	java/io/File:mkdir	()Z
    //   24: pop
    //   25: ldc 22
    //   27: iconst_1
    //   28: new 257	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 375
    //   38: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokestatic 381	android/os/Process:myPid	()I
    //   44: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: iload 4
    //   55: ifeq +84 -> 139
    //   58: invokestatic 390	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   61: astore 10
    //   63: new 91	java/io/File
    //   66: dup
    //   67: aload_0
    //   68: getfield 102	com/tencent/mm/vfs/FileSystemManager:mVFSDir	Ljava/io/File;
    //   71: ldc 13
    //   73: invokespecial 100	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   76: astore 7
    //   78: aload 7
    //   80: invokevirtual 393	java/io/File:length	()J
    //   83: lstore 5
    //   85: lload 5
    //   87: ldc2_w 394
    //   90: lcmp
    //   91: ifgt +12 -> 103
    //   94: lload 5
    //   96: ldc2_w 396
    //   99: lcmp
    //   100: ifgt +57 -> 157
    //   103: ldc 22
    //   105: iconst_1
    //   106: new 257	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 399
    //   116: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: lload 5
    //   121: invokevirtual 402	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   124: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aconst_null
    //   131: invokestatic 408	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   134: aload 10
    //   136: invokevirtual 411	android/os/Parcel:recycle	()V
    //   139: aload_0
    //   140: iload 4
    //   142: invokevirtual 415	com/tencent/mm/vfs/FileSystemManager:setBroadcastReceivingEnabled	(Z)V
    //   145: aload_0
    //   146: invokevirtual 418	com/tencent/mm/vfs/FileSystemManager:enableMaintenance	()V
    //   149: ldc_w 370
    //   152: aconst_null
    //   153: invokestatic 122	com/tencent/mm/vfs/VFSTrack:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: return
    //   157: lload 5
    //   159: l2i
    //   160: iconst_4
    //   161: isub
    //   162: istore_2
    //   163: iload_2
    //   164: newarray byte
    //   166: astore 11
    //   168: new 420	java/io/DataInputStream
    //   171: dup
    //   172: new 422	java/io/FileInputStream
    //   175: dup
    //   176: aload 7
    //   178: invokespecial 425	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   181: invokespecial 428	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   184: astore 8
    //   186: aload 8
    //   188: astore 7
    //   190: aload 8
    //   192: invokevirtual 431	java/io/DataInputStream:readInt	()I
    //   195: istore_3
    //   196: iload_3
    //   197: iconst_2
    //   198: if_icmpeq +69 -> 267
    //   201: aload 8
    //   203: astore 7
    //   205: new 367	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   208: dup
    //   209: ldc 2
    //   211: iload_3
    //   212: iconst_2
    //   213: invokespecial 434	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException:<init>	(Ljava/lang/Class;II)V
    //   216: athrow
    //   217: astore 9
    //   219: aload 8
    //   221: astore 7
    //   223: ldc 22
    //   225: iconst_1
    //   226: aload 9
    //   228: invokevirtual 437	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException:getMessage	()Ljava/lang/String;
    //   231: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aload 8
    //   236: astore 7
    //   238: aload_0
    //   239: new 369	java/lang/Throwable
    //   242: dup
    //   243: ldc_w 439
    //   246: aload 9
    //   248: invokespecial 442	java/lang/Throwable:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   251: invokespecial 446	com/tencent/mm/vfs/FileSystemManager:reportErrorInner	(Ljava/lang/Throwable;)V
    //   254: aload 8
    //   256: invokestatic 408	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   259: aload 10
    //   261: invokevirtual 411	android/os/Parcel:recycle	()V
    //   264: goto -125 -> 139
    //   267: iload_1
    //   268: iload_2
    //   269: if_icmpge +26 -> 295
    //   272: aload 8
    //   274: astore 7
    //   276: iload_1
    //   277: aload 8
    //   279: aload 11
    //   281: iload_1
    //   282: aload 11
    //   284: arraylength
    //   285: iload_1
    //   286: isub
    //   287: invokevirtual 450	java/io/DataInputStream:read	([BII)I
    //   290: iadd
    //   291: istore_1
    //   292: goto -25 -> 267
    //   295: aload 8
    //   297: astore 7
    //   299: aload 8
    //   301: invokevirtual 453	java/io/DataInputStream:close	()V
    //   304: aload 10
    //   306: aload 11
    //   308: iconst_0
    //   309: iload_1
    //   310: invokevirtual 457	android/os/Parcel:unmarshall	([BII)V
    //   313: aload 10
    //   315: iconst_0
    //   316: invokevirtual 461	android/os/Parcel:setDataPosition	(I)V
    //   319: aload_0
    //   320: aload 10
    //   322: ldc_w 463
    //   325: invokevirtual 469	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   328: invokevirtual 473	android/os/Parcel:readBundle	(Ljava/lang/ClassLoader;)Landroid/os/Bundle;
    //   331: invokespecial 477	com/tencent/mm/vfs/FileSystemManager:loadFromBundle	(Landroid/os/Bundle;)V
    //   334: goto -204 -> 130
    //   337: astore 9
    //   339: aconst_null
    //   340: astore 8
    //   342: goto -123 -> 219
    //   345: astore 9
    //   347: aconst_null
    //   348: astore 8
    //   350: aload 8
    //   352: astore 7
    //   354: aload_0
    //   355: aload 9
    //   357: invokespecial 446	com/tencent/mm/vfs/FileSystemManager:reportErrorInner	(Ljava/lang/Throwable;)V
    //   360: aload 8
    //   362: astore 7
    //   364: ldc 22
    //   366: iconst_1
    //   367: new 369	java/lang/Throwable
    //   370: dup
    //   371: ldc_w 439
    //   374: aload 9
    //   376: invokespecial 442	java/lang/Throwable:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   379: iconst_0
    //   380: anewarray 4	java/lang/Object
    //   383: invokestatic 480	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   386: aload 8
    //   388: invokestatic 408	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   391: aload 10
    //   393: invokevirtual 411	android/os/Parcel:recycle	()V
    //   396: goto -257 -> 139
    //   399: astore 7
    //   401: aload 9
    //   403: astore 8
    //   405: aload 8
    //   407: invokestatic 408	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   410: aload 10
    //   412: invokevirtual 411	android/os/Parcel:recycle	()V
    //   415: aload 7
    //   417: athrow
    //   418: astore 9
    //   420: aload 7
    //   422: astore 8
    //   424: aload 9
    //   426: astore 7
    //   428: goto -23 -> 405
    //   431: astore 9
    //   433: goto -83 -> 350
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	436	0	this	FileSystemManager
    //   4	306	1	i	int
    //   162	108	2	j	int
    //   195	17	3	k	int
    //   8	133	4	bool	boolean
    //   83	75	5	l	long
    //   76	287	7	localObject1	Object
    //   399	22	7	localObject2	Object
    //   426	1	7	localObject3	Object
    //   184	239	8	localObject4	Object
    //   1	1	9	localObject5	Object
    //   217	30	9	localFileSystemVersionException1	VFSUtils.FileSystemVersionException
    //   337	1	9	localFileSystemVersionException2	VFSUtils.FileSystemVersionException
    //   345	57	9	localThrowable1	Throwable
    //   418	7	9	localObject6	Object
    //   431	1	9	localThrowable2	Throwable
    //   61	350	10	localParcel	android.os.Parcel
    //   166	141	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   190	196	217	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   205	217	217	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   276	292	217	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   299	304	217	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   63	85	337	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   103	130	337	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   163	186	337	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   304	334	337	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   63	85	345	java/lang/Throwable
    //   103	130	345	java/lang/Throwable
    //   163	186	345	java/lang/Throwable
    //   304	334	345	java/lang/Throwable
    //   63	85	399	finally
    //   103	130	399	finally
    //   163	186	399	finally
    //   304	334	399	finally
    //   190	196	418	finally
    //   205	217	418	finally
    //   223	234	418	finally
    //   238	254	418	finally
    //   276	292	418	finally
    //   299	304	418	finally
    //   354	360	418	finally
    //   364	386	418	finally
    //   190	196	431	java/lang/Throwable
    //   205	217	431	java/lang/Throwable
    //   276	292	431	java/lang/Throwable
    //   299	304	431	java/lang/Throwable
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
    if (((Bundle)???).getInt("pid") == Process.myPid()) {
      if (QLog.isColorLevel()) {
        QLog.d("VFS.FileSystemManager", 2, "Ignore filesystem change broadcast from the same process.");
      }
    }
    do
    {
      return;
      paramBundle = ResolverState.loadFromBundle((Bundle)???);
      Map localMap = paramBundle.envVars();
      synchronized (this.mLock)
      {
        this.mState = paramBundle;
        this.mRevision += 1;
        this.mInvalidResolution = new FileSystemManager.Resolution(null, null, this.mRevision, null);
        VFSTrack.track(null, "migrate_configure_time_bundle");
        paramBundle.mRootFileSystem.configure(localMap);
        localIterator = paramBundle.mSchemeResolvers.values().iterator();
        if (localIterator.hasNext()) {
          ((SchemeResolver)localIterator.next()).configure(localMap);
        }
      }
      Iterator localIterator = paramBundle.mFileSystems.values().iterator();
      while (localIterator.hasNext()) {
        ((FileSystem)localIterator.next()).configure(localMap);
      }
      QLog.d("VFS.FileSystemManager", 1, "loadFromBundle. fileSystem size" + paramBundle.mFileSystems.size());
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
      ((StringBuilder)???).append("[Root]\n  ").append(paramBundle.mRootFileSystem.toString()).append('\n');
    } while (!QLog.isColorLevel());
    QLog.d("VFS.FileSystemManager", 2, "Loaded file system from bundle:\n" + ((StringBuilder)???).toString());
  }
  
  private static <K, V> void printChange(Map<K, V> paramMap, StringBuilder paramStringBuilder)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramStringBuilder.append("  ").append(localEntry.getKey());
      if (localEntry.getValue() == null) {
        paramStringBuilder.append(" (deleted)\n");
      } else {
        paramStringBuilder.append(" => ").append(localEntry.getValue().toString()).append('\n');
      }
    }
  }
  
  /* Error */
  private void publishFileSystems(ResolverState paramResolverState)
  {
    // Byte code:
    //   0: aconst_null
    //   1: ldc_w 610
    //   4: invokestatic 122	com/tencent/mm/vfs/VFSTrack:track	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   30: invokevirtual 411	android/os/Parcel:recycle	()V
    //   33: new 91	java/io/File
    //   36: dup
    //   37: aload_0
    //   38: getfield 102	com/tencent/mm/vfs/FileSystemManager:mVFSDir	Ljava/io/File;
    //   41: ldc 13
    //   43: invokespecial 100	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
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
    //   74: astore_3
    //   75: aload_3
    //   76: astore_2
    //   77: aload_3
    //   78: iconst_2
    //   79: invokevirtual 638	java/io/DataOutputStream:writeInt	(I)V
    //   82: aload_3
    //   83: astore_2
    //   84: aload_3
    //   85: aload 4
    //   87: invokevirtual 642	java/io/DataOutputStream:write	([B)V
    //   90: aload_3
    //   91: invokestatic 408	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   94: aload_0
    //   95: getfield 76	com/tencent/mm/vfs/FileSystemManager:mContext	Landroid/content/Context;
    //   98: invokevirtual 645	android/content/Context:getPackageName	()Ljava/lang/String;
    //   101: astore_2
    //   102: new 647	android/content/Intent
    //   105: dup
    //   106: new 257	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   113: aload_2
    //   114: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc_w 649
    //   120: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokespecial 650	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   129: astore_2
    //   130: aload_2
    //   131: aload 5
    //   133: invokevirtual 654	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   136: pop
    //   137: aload_2
    //   138: ldc_w 492
    //   141: invokestatic 381	android/os/Process:myPid	()I
    //   144: invokevirtual 658	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   147: pop
    //   148: aload_0
    //   149: getfield 76	com/tencent/mm/vfs/FileSystemManager:mContext	Landroid/content/Context;
    //   152: aload_2
    //   153: invokevirtual 662	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   156: new 257	java/lang/StringBuilder
    //   159: dup
    //   160: sipush 2048
    //   163: invokespecial 551	java/lang/StringBuilder:<init>	(I)V
    //   166: astore_2
    //   167: aload_2
    //   168: ldc_w 553
    //   171: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_1
    //   176: getfield 517	com/tencent/mm/vfs/ResolverState:mSchemeResolvers	Ljava/util/Map;
    //   179: aload_2
    //   180: invokestatic 557	com/tencent/mm/vfs/FileSystemManager:printChange	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   183: aload_2
    //   184: ldc_w 559
    //   187: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_1
    //   192: getfield 544	com/tencent/mm/vfs/ResolverState:mFileSystems	Ljava/util/Map;
    //   195: aload_2
    //   196: invokestatic 557	com/tencent/mm/vfs/FileSystemManager:printChange	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   199: aload_2
    //   200: ldc_w 561
    //   203: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload_1
    //   208: getfield 565	com/tencent/mm/vfs/ResolverState:mMountPoints	Ljava/util/SortedMap;
    //   211: aload_2
    //   212: invokestatic 557	com/tencent/mm/vfs/FileSystemManager:printChange	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   215: aload_2
    //   216: ldc_w 567
    //   219: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload_1
    //   224: getfield 570	com/tencent/mm/vfs/ResolverState:mEnvVars	Ljava/util/Map;
    //   227: aload_2
    //   228: invokestatic 557	com/tencent/mm/vfs/FileSystemManager:printChange	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   231: aload_2
    //   232: ldc_w 572
    //   235: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_1
    //   239: getfield 509	com/tencent/mm/vfs/ResolverState:mRootFileSystem	Lcom/tencent/mm/vfs/FileSystem;
    //   242: invokevirtual 573	java/lang/Object:toString	()Ljava/lang/String;
    //   245: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: bipush 10
    //   250: invokevirtual 576	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq +32 -> 289
    //   260: ldc 22
    //   262: iconst_2
    //   263: new 257	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   270: ldc_w 664
    //   273: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_2
    //   277: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: ldc_w 610
    //   292: aconst_null
    //   293: invokestatic 122	com/tencent/mm/vfs/VFSTrack:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: return
    //   297: astore 4
    //   299: aconst_null
    //   300: astore_3
    //   301: aload_3
    //   302: astore_2
    //   303: aload_0
    //   304: new 369	java/lang/Throwable
    //   307: dup
    //   308: ldc_w 439
    //   311: aload 4
    //   313: invokespecial 442	java/lang/Throwable:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   316: invokespecial 446	com/tencent/mm/vfs/FileSystemManager:reportErrorInner	(Ljava/lang/Throwable;)V
    //   319: aload_3
    //   320: astore_2
    //   321: ldc 22
    //   323: iconst_1
    //   324: new 257	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   331: ldc_w 666
    //   334: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload 4
    //   339: invokevirtual 667	java/io/IOException:getMessage	()Ljava/lang/String;
    //   342: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: aload_3
    //   352: invokestatic 408	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   355: goto -261 -> 94
    //   358: astore_1
    //   359: aconst_null
    //   360: astore_2
    //   361: aload_2
    //   362: invokestatic 408	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   365: aload_1
    //   366: athrow
    //   367: astore_1
    //   368: goto -7 -> 361
    //   371: astore 4
    //   373: goto -72 -> 301
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	this	FileSystemManager
    //   0	376	1	paramResolverState	ResolverState
    //   16	346	2	localObject	Object
    //   74	278	3	localDataOutputStream	java.io.DataOutputStream
    //   27	59	4	arrayOfByte	byte[]
    //   297	41	4	localIOException1	IOException
    //   371	1	4	localIOException2	IOException
    //   11	121	5	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   33	59	297	java/io/IOException
    //   59	75	297	java/io/IOException
    //   33	59	358	finally
    //   59	75	358	finally
    //   77	82	367	finally
    //   84	90	367	finally
    //   303	319	367	finally
    //   321	351	367	finally
    //   77	82	371	java/io/IOException
    //   84	90	371	java/io/IOException
  }
  
  private void reportErrorInner(Throwable paramThrowable)
  {
    if (sStatisticsCallback != null) {
      sStatisticsCallback.reportError(paramThrowable);
    }
  }
  
  public static void setContext(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    if (localContext == null) {}
    for (;;)
    {
      sContext = paramContext;
      return;
      paramContext = localContext;
    }
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
  
  /* Error */
  private void updateFileSystems(FileSystemManager.Editor paramEditor, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 689	com/tencent/mm/vfs/FileSystemManager$Editor:access$800	(Lcom/tencent/mm/vfs/FileSystemManager$Editor;)Ljava/util/HashMap;
    //   4: astore 6
    //   6: aload_1
    //   7: invokestatic 692	com/tencent/mm/vfs/FileSystemManager$Editor:access$900	(Lcom/tencent/mm/vfs/FileSystemManager$Editor;)Ljava/util/HashMap;
    //   10: astore 5
    //   12: aload_1
    //   13: invokestatic 696	com/tencent/mm/vfs/FileSystemManager$Editor:access$1000	(Lcom/tencent/mm/vfs/FileSystemManager$Editor;)Ljava/util/TreeMap;
    //   16: astore 7
    //   18: aload_1
    //   19: invokestatic 699	com/tencent/mm/vfs/FileSystemManager$Editor:access$1100	(Lcom/tencent/mm/vfs/FileSystemManager$Editor;)Ljava/util/HashMap;
    //   22: astore 8
    //   24: aload_1
    //   25: invokestatic 703	com/tencent/mm/vfs/FileSystemManager$Editor:access$1200	(Lcom/tencent/mm/vfs/FileSystemManager$Editor;)Lcom/tencent/mm/vfs/FileSystem;
    //   28: astore 9
    //   30: aload_1
    //   31: invokestatic 707	com/tencent/mm/vfs/FileSystemManager$Editor:access$1300	(Lcom/tencent/mm/vfs/FileSystemManager$Editor;)Z
    //   34: istore 4
    //   36: new 257	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   43: astore_1
    //   44: iload 4
    //   46: ifeq +11 -> 57
    //   49: aload_1
    //   50: ldc_w 709
    //   53: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 6
    //   59: invokeinterface 712 1 0
    //   64: ifne +17 -> 81
    //   67: aload_1
    //   68: ldc_w 714
    //   71: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 6
    //   77: aload_1
    //   78: invokestatic 557	com/tencent/mm/vfs/FileSystemManager:printChange	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   81: aload 5
    //   83: invokeinterface 712 1 0
    //   88: ifne +17 -> 105
    //   91: aload_1
    //   92: ldc_w 559
    //   95: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 5
    //   101: aload_1
    //   102: invokestatic 557	com/tencent/mm/vfs/FileSystemManager:printChange	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   105: aload 7
    //   107: invokeinterface 717 1 0
    //   112: ifne +17 -> 129
    //   115: aload_1
    //   116: ldc_w 561
    //   119: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 7
    //   125: aload_1
    //   126: invokestatic 557	com/tencent/mm/vfs/FileSystemManager:printChange	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   129: ldc 22
    //   131: iconst_1
    //   132: new 257	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 719
    //   142: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload 5
    //   147: invokeinterface 549 1 0
    //   152: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   155: ldc_w 721
    //   158: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 7
    //   163: invokeinterface 722 1 0
    //   168: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   171: ldc_w 724
    //   174: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: iload_2
    //   178: invokevirtual 267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   181: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aload 8
    //   189: invokeinterface 712 1 0
    //   194: ifne +17 -> 211
    //   197: aload_1
    //   198: ldc_w 567
    //   201: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 8
    //   207: aload_1
    //   208: invokestatic 557	com/tencent/mm/vfs/FileSystemManager:printChange	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   211: aload 9
    //   213: ifnull +21 -> 234
    //   216: aload_1
    //   217: ldc_w 572
    //   220: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload 9
    //   225: invokevirtual 595	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   228: bipush 10
    //   230: invokevirtual 576	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   237: ifeq +32 -> 269
    //   240: ldc 22
    //   242: iconst_2
    //   243: new 257	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   250: ldc_w 726
    //   253: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_1
    //   257: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: aload_0
    //   270: getfield 74	com/tencent/mm/vfs/FileSystemManager:mLock	Ljava/lang/Object;
    //   273: astore 10
    //   275: aload 10
    //   277: monitorenter
    //   278: iload 4
    //   280: ifeq +128 -> 408
    //   283: aload_0
    //   284: getfield 156	com/tencent/mm/vfs/FileSystemManager:mInitialState	Lcom/tencent/mm/vfs/ResolverState;
    //   287: astore_1
    //   288: aload_0
    //   289: getfield 160	com/tencent/mm/vfs/FileSystemManager:mRevision	I
    //   292: istore_3
    //   293: aload 10
    //   295: monitorexit
    //   296: aconst_null
    //   297: ldc_w 727
    //   300: invokestatic 122	com/tencent/mm/vfs/VFSTrack:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: aload_1
    //   304: aload 6
    //   306: aload 5
    //   308: aload 7
    //   310: aload 8
    //   312: aload 9
    //   314: invokevirtual 363	com/tencent/mm/vfs/ResolverState:update	(Ljava/util/Map;Ljava/util/Map;Ljava/util/SortedMap;Ljava/util/Map;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/ResolverState;
    //   317: astore_1
    //   318: ldc_w 727
    //   321: aconst_null
    //   322: invokestatic 122	com/tencent/mm/vfs/VFSTrack:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: aload_1
    //   326: invokevirtual 503	com/tencent/mm/vfs/ResolverState:envVars	()Ljava/util/Map;
    //   329: astore 11
    //   331: ldc 22
    //   333: iconst_1
    //   334: new 257	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   341: ldc_w 729
    //   344: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: iload_3
    //   348: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   351: ldc_w 731
    //   354: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload_0
    //   358: getfield 160	com/tencent/mm/vfs/FileSystemManager:mRevision	I
    //   361: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   364: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: aload_0
    //   371: getfield 74	com/tencent/mm/vfs/FileSystemManager:mLock	Ljava/lang/Object;
    //   374: astore 10
    //   376: aload 10
    //   378: monitorenter
    //   379: iload_3
    //   380: aload_0
    //   381: getfield 160	com/tencent/mm/vfs/FileSystemManager:mRevision	I
    //   384: if_icmpeq +46 -> 430
    //   387: iload 4
    //   389: ifeq +33 -> 422
    //   392: aload_0
    //   393: getfield 156	com/tencent/mm/vfs/FileSystemManager:mInitialState	Lcom/tencent/mm/vfs/ResolverState;
    //   396: astore_1
    //   397: aload_0
    //   398: getfield 160	com/tencent/mm/vfs/FileSystemManager:mRevision	I
    //   401: istore_3
    //   402: aload 10
    //   404: monitorexit
    //   405: goto -109 -> 296
    //   408: aload_0
    //   409: getfield 158	com/tencent/mm/vfs/FileSystemManager:mState	Lcom/tencent/mm/vfs/ResolverState;
    //   412: astore_1
    //   413: goto -125 -> 288
    //   416: astore_1
    //   417: aload 10
    //   419: monitorexit
    //   420: aload_1
    //   421: athrow
    //   422: aload_0
    //   423: getfield 158	com/tencent/mm/vfs/FileSystemManager:mState	Lcom/tencent/mm/vfs/ResolverState;
    //   426: astore_1
    //   427: goto -30 -> 397
    //   430: aload_0
    //   431: aload_1
    //   432: putfield 158	com/tencent/mm/vfs/FileSystemManager:mState	Lcom/tencent/mm/vfs/ResolverState;
    //   435: aload_0
    //   436: iload_3
    //   437: iconst_1
    //   438: iadd
    //   439: putfield 160	com/tencent/mm/vfs/FileSystemManager:mRevision	I
    //   442: aload_0
    //   443: new 162	com/tencent/mm/vfs/FileSystemManager$Resolution
    //   446: dup
    //   447: aconst_null
    //   448: aconst_null
    //   449: aload_0
    //   450: getfield 160	com/tencent/mm/vfs/FileSystemManager:mRevision	I
    //   453: aconst_null
    //   454: invokespecial 165	com/tencent/mm/vfs/FileSystemManager$Resolution:<init>	(Lcom/tencent/mm/vfs/FileSystem;Ljava/lang/String;ILcom/tencent/mm/vfs/FileSystemManager$1;)V
    //   457: putfield 167	com/tencent/mm/vfs/FileSystemManager:mInvalidResolution	Lcom/tencent/mm/vfs/FileSystemManager$Resolution;
    //   460: aconst_null
    //   461: ldc_w 733
    //   464: invokestatic 122	com/tencent/mm/vfs/VFSTrack:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   467: iload 4
    //   469: ifne +13 -> 482
    //   472: aload 8
    //   474: invokeinterface 712 1 0
    //   479: ifne +112 -> 591
    //   482: aload_1
    //   483: getfield 509	com/tencent/mm/vfs/ResolverState:mRootFileSystem	Lcom/tencent/mm/vfs/FileSystem;
    //   486: aload 11
    //   488: invokeinterface 513 2 0
    //   493: aload_1
    //   494: getfield 517	com/tencent/mm/vfs/ResolverState:mSchemeResolvers	Ljava/util/Map;
    //   497: invokeinterface 523 1 0
    //   502: invokeinterface 529 1 0
    //   507: astore 5
    //   509: aload 5
    //   511: invokeinterface 534 1 0
    //   516: ifeq +29 -> 545
    //   519: aload 5
    //   521: invokeinterface 538 1 0
    //   526: checkcast 540	com/tencent/mm/vfs/SchemeResolver
    //   529: aload 11
    //   531: invokeinterface 541 2 0
    //   536: goto -27 -> 509
    //   539: astore_1
    //   540: aload 10
    //   542: monitorexit
    //   543: aload_1
    //   544: athrow
    //   545: aload_1
    //   546: getfield 544	com/tencent/mm/vfs/ResolverState:mFileSystems	Ljava/util/Map;
    //   549: invokeinterface 523 1 0
    //   554: invokeinterface 529 1 0
    //   559: astore 5
    //   561: aload 5
    //   563: invokeinterface 534 1 0
    //   568: ifeq +145 -> 713
    //   571: aload 5
    //   573: invokeinterface 538 1 0
    //   578: checkcast 463	com/tencent/mm/vfs/FileSystem
    //   581: aload 11
    //   583: invokeinterface 513 2 0
    //   588: goto -27 -> 561
    //   591: aload 9
    //   593: ifnull +14 -> 607
    //   596: aload_1
    //   597: getfield 509	com/tencent/mm/vfs/ResolverState:mRootFileSystem	Lcom/tencent/mm/vfs/FileSystem;
    //   600: aload 11
    //   602: invokeinterface 513 2 0
    //   607: aload 6
    //   609: invokeinterface 523 1 0
    //   614: invokeinterface 529 1 0
    //   619: astore 6
    //   621: aload 6
    //   623: invokeinterface 534 1 0
    //   628: ifeq +32 -> 660
    //   631: aload 6
    //   633: invokeinterface 538 1 0
    //   638: checkcast 540	com/tencent/mm/vfs/SchemeResolver
    //   641: astore 7
    //   643: aload 7
    //   645: ifnull -24 -> 621
    //   648: aload 7
    //   650: aload 11
    //   652: invokeinterface 541 2 0
    //   657: goto -36 -> 621
    //   660: aload 5
    //   662: invokeinterface 523 1 0
    //   667: invokeinterface 529 1 0
    //   672: astore 5
    //   674: aload 5
    //   676: invokeinterface 534 1 0
    //   681: ifeq +32 -> 713
    //   684: aload 5
    //   686: invokeinterface 538 1 0
    //   691: checkcast 463	com/tencent/mm/vfs/FileSystem
    //   694: astore 6
    //   696: aload 6
    //   698: ifnull -24 -> 674
    //   701: aload 6
    //   703: aload 11
    //   705: invokeinterface 513 2 0
    //   710: goto -36 -> 674
    //   713: ldc_w 733
    //   716: aconst_null
    //   717: invokestatic 122	com/tencent/mm/vfs/VFSTrack:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   720: aload 10
    //   722: monitorexit
    //   723: iload_2
    //   724: ifeq +8 -> 732
    //   727: aload_0
    //   728: aload_1
    //   729: invokespecial 735	com/tencent/mm/vfs/FileSystemManager:publishFileSystems	(Lcom/tencent/mm/vfs/ResolverState;)V
    //   732: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	733	0	this	FileSystemManager
    //   0	733	1	paramEditor	FileSystemManager.Editor
    //   0	733	2	paramBoolean	boolean
    //   292	147	3	i	int
    //   34	434	4	bool	boolean
    //   10	675	5	localObject1	Object
    //   4	698	6	localObject2	Object
    //   16	633	7	localObject3	Object
    //   22	451	8	localHashMap	HashMap
    //   28	564	9	localFileSystem	FileSystem
    //   329	375	11	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   283	288	416	finally
    //   288	296	416	finally
    //   408	413	416	finally
    //   417	420	416	finally
    //   379	387	539	finally
    //   392	397	539	finally
    //   397	405	539	finally
    //   422	427	539	finally
    //   430	467	539	finally
    //   472	482	539	finally
    //   482	509	539	finally
    //   509	536	539	finally
    //   540	543	539	finally
    //   545	561	539	finally
    //   561	588	539	finally
    //   596	607	539	finally
    //   607	621	539	finally
    //   621	643	539	finally
    //   648	657	539	finally
    //   660	674	539	finally
    //   674	696	539	finally
    //   701	710	539	finally
    //   713	723	539	finally
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
    for (;;)
    {
      this.mMaintenanceWaitTime = paramLong1;
      this.mMaintenanceInterval = paramLong2;
      this.mMaintenanceUseWakeLock = paramBoolean;
      return;
      if ((paramLong1 < 0L) && (l >= 0L)) {
        this.mContext.unregisterReceiver(this.mMaintenanceReceiver);
      }
    }
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
    ResolverState localResolverState;
    synchronized (this.mLock)
    {
      localResolverState = this.mState;
      ??? = paramUri.getScheme();
      ??? = (SchemeResolver)localResolverState.mSchemeResolvers.get(???);
      if (??? == null) {
        return null;
      }
    }
    return ((SchemeResolver)???).exportUri(localResolverState, paramUri);
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
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
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
        for (;;)
        {
          QLog.e("VFS.FileSystemManager", 1, "Failed to refresh file system from broadcast.", paramMessage);
        }
      }
    }
    doMaintenance((CancellationSignalCompat)paramMessage.obj);
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
      if ((l > 1048576L) || (l <= 4L))
      {
        reportErrorInner(new Throwable("VFSSystemManager Invalid parcel file size: " + l));
        return false;
      }
      return true;
    }
    return false;
  }
  
  public void maintain(CancellationSignalCompat paramCancellationSignalCompat)
  {
    File localFile = new File(this.mVFSDir, "maintain.timestamp");
    Object localObject3;
    synchronized (this.mLock)
    {
      localObject1 = this.mState;
      ??? = ((ResolverState)localObject1).mSchemeResolvers.entrySet().iterator();
      if (((Iterator)???).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)???).next();
        SchemeResolver localSchemeResolver = (SchemeResolver)((Map.Entry)localObject3).getValue();
        if (QLog.isColorLevel()) {
          QLog.i("VFS.FileSystemManager", 2, "[Maintenance] " + (String)((Map.Entry)localObject3).getKey() + " => " + localSchemeResolver.toString());
        }
        localSchemeResolver.maintain(paramCancellationSignalCompat);
      }
    }
    Object localObject1 = ((ResolverState)localObject1).mFileSystems.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ??? = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (FileSystem)((Map.Entry)???).getValue();
      if (QLog.isColorLevel()) {
        QLog.i("VFS.FileSystemManager", 2, "[Maintenance] " + (String)((Map.Entry)???).getKey() + " => " + localObject3.toString());
      }
      ((FileSystem)localObject3).maintain(paramCancellationSignalCompat);
    }
    try
    {
      localFile.createNewFile();
      localFile.setLastModified(System.currentTimeMillis());
      return;
    }
    catch (IOException paramCancellationSignalCompat)
    {
      reportErrorInner(new Throwable("VFSSystemManager maintain error", paramCancellationSignalCompat));
      QLog.e("VFS.FileSystemManager", 1, "Unable to update maintenance timestamp: " + paramCancellationSignalCompat.getMessage());
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
    ResolverState localResolverState;
    int i;
    try
    {
      if (paramResolution.revision == this.mRevision) {
        return paramResolution;
      }
      localResolverState = this.mState;
      i = this.mRevision;
      paramResolution = this.mInvalidResolution;
      localObject = paramUri.getScheme();
      localObject = (SchemeResolver)localResolverState.mSchemeResolvers.get(localObject);
      if (localObject == null)
      {
        QLog.e("VFS.FileSystemManager", 1, "resolve is wrong! revoler is null,  resolvers size = " + localResolverState.mSchemeResolvers.size());
        return paramResolution;
      }
    }
    finally {}
    localObject = ((SchemeResolver)localObject).resolve(localResolverState, paramUri);
    paramUri = paramResolution;
    if (localObject != null) {
      paramUri = new FileSystemManager.Resolution((FileSystem)((Pair)localObject).first, (String)((Pair)localObject).second, i, null);
    }
    return paramUri;
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
      this.mContext.registerReceiver((BroadcastReceiver)localObject, new IntentFilter(str + ".REFRESH_VFS"), "com.tencent.mobileqq.permission.MM_MESSAGE", null);
      if (QLog.isColorLevel()) {
        QLog.d("VFS.FileSystemManager", 2, "Broadcast receiving enabled.");
      }
    }
    for (;;)
    {
      VFSTrack.track("setBroadcastReceivingEnabled", null);
      return;
      if ((localObject != null) && (!paramBoolean))
      {
        this.mContext.unregisterReceiver((BroadcastReceiver)localObject);
        this.mRefreshReceiver = null;
        if (QLog.isColorLevel()) {
          QLog.d("VFS.FileSystemManager", 2, "Broadcast receiving disabled.");
        }
      }
    }
  }
  
  Map<String, String> staticEnvironment()
  {
    return this.mInitialState.envVars();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystemManager
 * JD-Core Version:    0.7.0.1
 */