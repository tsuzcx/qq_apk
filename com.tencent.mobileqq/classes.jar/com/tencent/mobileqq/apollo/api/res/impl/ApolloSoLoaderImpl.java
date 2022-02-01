package com.tencent.mobileqq.apollo.api.res.impl;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.res.IApolloSoLoader;
import com.tencent.mobileqq.apollo.api.res.IApolloSoLoader.OnCmSoLoadCompleteCallback;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.soload.SoLoadManager;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.startup.step.UpdateArkSo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.SOPreLoader;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ApolloSoLoaderImpl
  implements IApolloSoLoader
{
  public static final String APNG_SO = "apng_encoder";
  public static final String BRICK_SO = "sava";
  public static final String[] LIBS_4_CORE = { "tinyskia", "sava" };
  public static final String LIBS_4_JSC = "jsc";
  public static final int LIB_TYPE_JSC = 0;
  public static final int LIB_TYPE_SAVA = 1;
  private static final String LOCAL_SO_DIR = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/soTest/";
  public static final String TAG = "ApolloSoLoader";
  private static final Object lock = new Object();
  public static CopyOnWriteArrayList<WeakReference<IApolloSoLoader.OnCmSoLoadCompleteCallback>> mCallbacks = new CopyOnWriteArrayList();
  public static boolean sIsBeginTrace;
  private static boolean sIsMainProcess;
  private static boolean sIsReportTrace;
  private static AtomicBoolean sIsTaskRunning = new AtomicBoolean(false);
  public static StringBuilder sLibNameFromLocal;
  private static boolean sLoadEngineLibDone = false;
  private static Runnable sLoadJob = new ApolloSoLoaderImpl.1();
  private static boolean sPredownloaded;
  private static String sScriptRootPath;
  
  static
  {
    sIsMainProcess = true;
    sIsReportTrace = false;
    sIsBeginTrace = true;
    sLibNameFromLocal = new StringBuilder(100);
  }
  
  public static void addLoadCallback(IApolloSoLoader.OnCmSoLoadCompleteCallback paramOnCmSoLoadCompleteCallback)
  {
    if (paramOnCmSoLoadCompleteCallback == null) {}
    for (;;)
    {
      return;
      try
      {
        Iterator localIterator = mCallbacks.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (paramOnCmSoLoadCompleteCallback == localWeakReference.get()))
            {
              QLog.i("ApolloSoLoader", 1, "already add, cb:" + paramOnCmSoLoadCompleteCallback);
              break;
            }
          }
        }
      }
      finally {}
      mCallbacks.add(new WeakReference(paramOnCmSoLoadCompleteCallback));
    }
  }
  
  private static void doOtherThings()
  {
    ApolloUtilImpl.getCmdChannel().checkSetNative();
    ApolloManagerServiceImpl.notifyWebEngineReady();
  }
  
  private static String getBasicJsHomePath(String paramString)
  {
    return sScriptRootPath;
  }
  
  private static boolean initScriptLib()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      String[] arrayOfString = ApolloManagerServiceImpl.sScriptNames;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str1 = arrayOfString[i];
        String str2 = FileUtils.b(new File(getBasicJsHomePath(str1), str1));
        ApolloManagerServiceImpl.sScriptLibs.put(str1, str2);
        i += 1;
      }
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "[initScriptLib]," + localThrowable);
      if (sIsReportTrace) {
        TraceReportUtil.a(10, 100, new Object[] { "[initScriptLib], th:", localThrowable });
      }
      return false;
    }
    finally
    {
      long l2 = System.currentTimeMillis();
      QLog.i("ApolloSoLoader", 1, "[initScriptLib], costT:" + (l2 - l1));
    }
  }
  
  public static boolean isLibReady()
  {
    return sLoadEngineLibDone;
  }
  
  public static boolean isSoExistInSdcard(String paramString)
  {
    return false;
  }
  
  private static boolean loadAllSo()
  {
    boolean bool2 = false;
    boolean bool1;
    try
    {
      if (ApolloGameUtil.a())
      {
        QLog.i("ApolloSoLoader", 1, "[loadAllSo], Aborting! arch=x86");
        bool1 = bool2;
        if (sIsReportTrace)
        {
          TraceReportUtil.a(10, 300, 1002, new Object[] { "arch=x86" });
          return false;
        }
      }
      else if (!UpdateArkSo.a(BaseApplicationImpl.getContext(), UpdateArkSo.a()))
      {
        bool1 = bool2;
        if (!sIsReportTrace) {
          return bool1;
        }
        TraceReportUtil.a(10, 300, 1003, new Object[] { "png-armeabi-v7a load failed" });
        sIsBeginTrace = true;
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "[loadAllSo], Something unexpected happened." + localThrowable);
      bool1 = bool2;
      if (sIsReportTrace)
      {
        TraceReportUtil.a(10, 300, 1004, new Object[] { "[loadAllSo], Something unexpected happened.", localThrowable });
        sIsBeginTrace = true;
        return false;
        if (sIsReportTrace) {
          TraceReportUtil.a(10, 300, new Object[] { "" });
        }
        Object localObject;
        if (!sPredownloaded)
        {
          QLog.i("ApolloSoLoader", 1, "[loadAllSo] predownload so");
          localObject = LIBS_4_CORE[0];
          String str = LIBS_4_CORE[1];
          SoLoadManager localSoLoadManager = SoLoadManager.a();
          ApolloSoLoaderImpl.2 local2 = new ApolloSoLoaderImpl.2();
          localSoLoadManager.b(new String[] { "jsc", localObject, str, "apng_encoder" }, local2);
          sPredownloaded = true;
        }
        if ((BaseApplicationImpl.sProcessId == 2) || (BaseApplicationImpl.sProcessId == 8))
        {
          bool1 = bool2;
          if (!loadNativeLibrary("jsc")) {}
        }
        else
        {
          for (;;)
          {
            localObject = LIBS_4_CORE;
            int j = localObject.length;
            int i = 0;
            while (i < j)
            {
              bool1 = bool2;
              if (!loadNativeLibrary(localObject[i])) {
                return bool1;
              }
              i += 1;
            }
            bool1 = bool2;
            if (!loadNativeLibrary("jsc")) {
              return bool1;
            }
            TraceReportUtil.a(10, 299);
            if (!AVSoUtils.a())
            {
              QLog.e("ApolloSoLoader", 1, "[loadAllSo] sharpp load error");
              TraceReportUtil.a(10, 299, 1005, new Object[] { "sharpp load fail" });
              return false;
            }
            TraceReportUtil.a(10, 299, 0, new Object[0]);
          }
          localObject = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject != null) && ((localObject instanceof QQAppInterface)))
          {
            ArkAppCenter.a().postToMainThread(new ApolloSoLoaderImpl.3());
            QLog.e("ApolloSoLoader", 1, "[loadAllSo], Notify ark jsc has loaded.");
          }
          if (sIsReportTrace) {
            TraceReportUtil.a(10, 300, 0, new Object[] { "loadAllSo success" });
          }
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static boolean loadFromLocalIfAsanTest(String paramString)
  {
    if (!AppSetting.h) {}
    while (!"sava".equals(paramString)) {
      return false;
    }
    System.loadLibrary("sava");
    QLog.i("ApolloSoLoader", 1, "sava is loaded for asan test.");
    return true;
  }
  
  private static boolean loadNativeLibrary(String paramString)
  {
    for (;;)
    {
      synchronized (lock)
      {
        if (loadFromLocalIfAsanTest(paramString)) {
          return true;
        }
        localObject2 = "lib" + paramString + ".so";
        str1 = SOPreLoader.a();
        if (!isSoExistInSdcard((String)localObject2)) {
          break;
        }
        str1 = str1 + "/test";
        localObject2 = new File(str1, (String)localObject2);
        l = System.currentTimeMillis();
        if ("sava".equals(paramString))
        {
          sScriptRootPath = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/soTest/";
          System.load(((File)localObject2).getAbsolutePath());
          QLog.i("ApolloSoLoader", 1, "load test [" + ((File)localObject2).getAbsolutePath() + "],[size]:" + ((File)localObject2).length() + ",[duration]:" + (System.currentTimeMillis() - l));
          return true;
        }
      }
      if ("jsc".equals(paramString)) {
        SOPreLoader.a(str1);
      }
    }
    long l = System.currentTimeMillis();
    Object localObject2 = SoLoadManager.a().a(paramString);
    if (localObject2 == null)
    {
      QLog.i("ApolloSoLoader", 1, "load failed [" + paramString + "], result null");
      return false;
    }
    boolean bool = ((LoadExtResult)localObject2).isSucc();
    String str1 = ((LoadExtResult)localObject2).getVer();
    if (!bool)
    {
      int i = ((LoadExtResult)localObject2).getResultCode();
      QLog.i("ApolloSoLoader", 1, "load failed [" + paramString + "],[resultCode]:" + i + ", version=" + str1);
      return false;
    }
    String str2 = ((LoadExtResult)localObject2).getSoLoadPath(paramString);
    File localFile = new File(str2);
    if ("sava".equals(paramString)) {
      sScriptRootPath = ((LoadExtResult)localObject2).getRelatedFilesFolder("sava");
    }
    for (;;)
    {
      if (sIsReportTrace) {
        TraceReportUtil.a(10, 300, new Object[] { "load [" + localFile.getAbsolutePath() + "]" });
      }
      QLog.i("ApolloSoLoader", 1, "load success [" + str2 + "],[size]:" + localFile.length() + ",[duration]:" + (System.currentTimeMillis() - l) + ", version=" + str1);
      return true;
      if ("jsc".equals(paramString)) {
        SOPreLoader.a(localFile.getParent());
      }
    }
  }
  
  public static void loadSo(String paramString)
  {
    for (;;)
    {
      try
      {
        QLog.i("ApolloSoLoader", 1, "[loadSo], from:" + paramString + ",sLoadEngineLibDone:" + sLoadEngineLibDone + ",sIsTaskRunning:" + sIsTaskRunning.get());
        boolean bool = sIsTaskRunning.getAndSet(true);
        if (bool) {
          return;
        }
        if (sLoadEngineLibDone)
        {
          notifyResult(0);
          sIsTaskRunning.set(false);
          continue;
        }
        ThreadManager.removeJobFromThreadPool(sLoadJob, 192);
      }
      finally {}
      ThreadManager.excute(sLoadJob, 192, null, true);
    }
  }
  
  public static void notifyResult(int paramInt)
  {
    try
    {
      Iterator localIterator = mCallbacks.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = (IApolloSoLoader.OnCmSoLoadCompleteCallback)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            ((IApolloSoLoader.OnCmSoLoadCompleteCallback)localObject2).a(paramInt);
          }
        }
      }
    }
    finally {}
  }
  
  public static void removeFileObserver() {}
  
  /* Error */
  public static void removeLoadCallback(IApolloSoLoader.OnCmSoLoadCompleteCallback paramOnCmSoLoadCompleteCallback)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +14 -> 18
    //   7: getstatic 80	com/tencent/mobileqq/apollo/api/res/impl/ApolloSoLoaderImpl:mCallbacks	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   10: invokevirtual 458	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   13: istore_1
    //   14: iload_1
    //   15: ifne +7 -> 22
    //   18: ldc 2
    //   20: monitorexit
    //   21: return
    //   22: getstatic 80	com/tencent/mobileqq/apollo/api/res/impl/ApolloSoLoaderImpl:mCallbacks	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   25: invokevirtual 125	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   28: astore_2
    //   29: aload_2
    //   30: invokeinterface 130 1 0
    //   35: ifeq -17 -> 18
    //   38: aload_2
    //   39: invokeinterface 134 1 0
    //   44: checkcast 136	java/lang/ref/WeakReference
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull -20 -> 29
    //   52: aload_0
    //   53: aload_3
    //   54: invokevirtual 139	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   57: if_acmpne -28 -> 29
    //   60: getstatic 80	com/tencent/mobileqq/apollo/api/res/impl/ApolloSoLoaderImpl:mCallbacks	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   63: aload_3
    //   64: invokevirtual 461	java/util/concurrent/CopyOnWriteArrayList:remove	(Ljava/lang/Object;)Z
    //   67: pop
    //   68: invokestatic 464	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq -53 -> 18
    //   74: ldc 29
    //   76: iconst_2
    //   77: iconst_2
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: ldc_w 466
    //   86: aastore
    //   87: dup
    //   88: iconst_1
    //   89: aload_0
    //   90: aastore
    //   91: invokestatic 470	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   94: goto -76 -> 18
    //   97: astore_0
    //   98: ldc 2
    //   100: monitorexit
    //   101: aload_0
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramOnCmSoLoadCompleteCallback	IApolloSoLoader.OnCmSoLoadCompleteCallback
    //   13	2	1	i	int
    //   28	11	2	localIterator	Iterator
    //   47	17	3	localWeakReference	WeakReference
    // Exception table:
    //   from	to	target	type
    //   7	14	97	finally
    //   22	29	97	finally
    //   29	48	97	finally
    //   52	94	97	finally
  }
  
  private static void showToast() {}
  
  public boolean apiIsLibReady()
  {
    return isLibReady();
  }
  
  public void apiLoadSo(String paramString)
  {
    loadSo(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.ApolloSoLoaderImpl
 * JD-Core Version:    0.7.0.1
 */