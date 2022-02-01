package com.tencent.mobileqq.apollo.res.api.impl;

import com.tencent.av.utils.AVSoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.res.api.IApolloSoLoader;
import com.tencent.mobileqq.apollo.res.api.IApolloSoLoader.OnCmSoLoadCompleteCallback;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.ApolloHardWareTester;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.api.INativeLibLoader;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.SOPreLoader;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
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
  private static final Object LOCK = new Object();
  public static final String TAG = "[cmshow]ApolloSoLoader";
  public static CopyOnWriteArrayList<WeakReference<IApolloSoLoader.OnCmSoLoadCompleteCallback>> mCallbacks = new CopyOnWriteArrayList();
  public static boolean sIsBeginTrace;
  private static boolean sIsMainProcess;
  private static boolean sIsReportTrace;
  private static AtomicBoolean sIsTaskRunning = new AtomicBoolean(false);
  public static StringBuilder sLibNameFromLocal;
  private static boolean sLoadEngineLibDone = false;
  private static Runnable sLoadJob = new ApolloSoLoaderImpl.1();
  private static boolean sPredownloaded;
  
  static
  {
    sIsMainProcess = true;
    sIsReportTrace = false;
    sIsBeginTrace = true;
    sLibNameFromLocal = new StringBuilder(100);
  }
  
  public static void addLoadCallback(IApolloSoLoader.OnCmSoLoadCompleteCallback paramOnCmSoLoadCompleteCallback)
  {
    if (paramOnCmSoLoadCompleteCallback == null) {
      return;
    }
    try
    {
      Object localObject = mCallbacks.iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
        if ((localWeakReference != null) && (paramOnCmSoLoadCompleteCallback == localWeakReference.get()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("already add, cb:");
          ((StringBuilder)localObject).append(paramOnCmSoLoadCompleteCallback);
          QLog.i("[cmshow]ApolloSoLoader", 1, ((StringBuilder)localObject).toString());
          return;
        }
      }
      mCallbacks.add(new WeakReference(paramOnCmSoLoadCompleteCallback));
      return;
    }
    finally {}
    for (;;)
    {
      throw paramOnCmSoLoadCompleteCallback;
    }
  }
  
  private static void doOtherThings()
  {
    ApolloCmdChannel.getInstance().checkSetNative();
    ApolloManagerServiceImpl.notifyWebEngineReady();
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
    for (;;)
    {
      int i;
      try
      {
        if (ApolloHardWareTester.a())
        {
          QLog.i("[cmshow]ApolloSoLoader", 1, "[loadAllSo], Aborting! arch=x86");
          if (sIsReportTrace)
          {
            TraceReportUtil.a(10, 300, 1002, new Object[] { "arch=x86" });
            return false;
          }
        }
        else
        {
          if (!((INativeLibLoader)QRoute.api(INativeLibLoader.class)).loadPNGLibrary(BaseApplicationImpl.getContext()))
          {
            if (!sIsReportTrace) {
              break label467;
            }
            TraceReportUtil.a(10, 300, 1003, new Object[] { "png-armeabi-v7a load failed" });
            sIsBeginTrace = true;
            return false;
          }
          if (sIsReportTrace) {
            TraceReportUtil.a(10, 300, new Object[] { "" });
          }
          boolean bool = sPredownloaded;
          if (!bool)
          {
            QLog.i("[cmshow]ApolloSoLoader", 1, "[loadAllSo] predownload so");
            localObject1 = LIBS_4_CORE[0];
            localObject2 = LIBS_4_CORE[1];
            SoLoadManager localSoLoadManager = SoLoadManager.getInstance();
            ApolloSoLoaderImpl.2 local2 = new ApolloSoLoaderImpl.2();
            localSoLoadManager.download(new String[] { "jsc", localObject1, localObject2, "apng_encoder" }, local2);
            sPredownloaded = true;
          }
          if ((BaseApplicationImpl.sProcessId != 2) && (BaseApplicationImpl.sProcessId != 8))
          {
            if (!loadNativeLibrary("jsc")) {
              return false;
            }
            TraceReportUtil.a(10, 299);
            if (!AVSoUtils.a())
            {
              QLog.e("[cmshow]ApolloSoLoader", 1, "[loadAllSo] sharpp load error");
              TraceReportUtil.a(10, 299, 1005, new Object[] { "sharpp load fail" });
              return false;
            }
            TraceReportUtil.a(10, 299, 0, new Object[0]);
          }
          else if (!loadNativeLibrary("jsc"))
          {
            return false;
          }
          Object localObject1 = LIBS_4_CORE;
          int j = localObject1.length;
          i = 0;
          if (i < j)
          {
            if (loadNativeLibrary(localObject1[i])) {
              break label469;
            }
            return false;
          }
          localObject1 = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface)))
          {
            ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToLogicThread(new ApolloSoLoaderImpl.3());
            QLog.e("[cmshow]ApolloSoLoader", 1, "[loadAllSo], Notify ark jsc has loaded.");
          }
          if (sIsReportTrace) {
            TraceReportUtil.a(10, 300, 0, new Object[] { "loadAllSo success" });
          }
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[loadAllSo], Something unexpected happened.");
        ((StringBuilder)localObject2).append(localThrowable);
        QLog.e("[cmshow]ApolloSoLoader", 1, ((StringBuilder)localObject2).toString());
        if (sIsReportTrace)
        {
          TraceReportUtil.a(10, 300, 1004, new Object[] { "[loadAllSo], Something unexpected happened.", localThrowable });
          sIsBeginTrace = true;
        }
        return false;
      }
      return false;
      label467:
      return false;
      label469:
      i += 1;
    }
  }
  
  private static boolean loadFromLocalIfAsanTest(String paramString)
  {
    if (!AppSetting.h) {
      return false;
    }
    if (!"sava".equals(paramString)) {
      return false;
    }
    System.loadLibrary("sava");
    QLog.i("[cmshow]ApolloSoLoader", 1, "sava is loaded for asan test.");
    return true;
  }
  
  private static boolean loadNativeLibrary(String paramString)
  {
    synchronized (LOCK)
    {
      if (loadFromLocalIfAsanTest(paramString)) {
        return true;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("lib");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(".so");
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = SOPreLoader.a();
      if (isSoExistInSdcard((String)localObject2))
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject3);
        ((StringBuilder)localObject4).append("/test");
        localObject3 = ((StringBuilder)localObject4).toString();
        localObject2 = new File((String)localObject3, (String)localObject2);
        l = System.currentTimeMillis();
        if ("jsc".equals(paramString)) {
          SOPreLoader.a((String)localObject3);
        }
        System.load(((File)localObject2).getAbsolutePath());
        paramString = new StringBuilder();
        paramString.append("load test [");
        paramString.append(((File)localObject2).getAbsolutePath());
        paramString.append("],[size]:");
        paramString.append(((File)localObject2).length());
        paramString.append(",[duration]:");
        paramString.append(System.currentTimeMillis() - l);
        QLog.i("[cmshow]ApolloSoLoader", 1, paramString.toString());
        return true;
      }
      long l = System.currentTimeMillis();
      localObject3 = SoLoadManager.getInstance().loadSync(paramString);
      if (localObject3 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("load failed [");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("], result null");
        QLog.i("[cmshow]ApolloSoLoader", 1, ((StringBuilder)localObject2).toString());
        return false;
      }
      boolean bool = ((LoadExtResult)localObject3).isSucc();
      localObject2 = ((LoadExtResult)localObject3).getVer();
      if (!bool)
      {
        int i = ((LoadExtResult)localObject3).getResultCode();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("load failed [");
        ((StringBuilder)localObject3).append(paramString);
        ((StringBuilder)localObject3).append("],[resultCode]:");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append(", version=");
        ((StringBuilder)localObject3).append((String)localObject2);
        QLog.i("[cmshow]ApolloSoLoader", 1, ((StringBuilder)localObject3).toString());
        return false;
      }
      localObject3 = ((LoadExtResult)localObject3).getSoLoadPath(paramString);
      Object localObject4 = new File((String)localObject3);
      if ("jsc".equals(paramString)) {
        SOPreLoader.a(((File)localObject4).getParent());
      }
      if (sIsReportTrace)
      {
        paramString = new StringBuilder();
        paramString.append("load [");
        paramString.append(((File)localObject4).getAbsolutePath());
        paramString.append("]");
        TraceReportUtil.a(10, 300, new Object[] { paramString.toString() });
      }
      paramString = new StringBuilder();
      paramString.append("load success [");
      paramString.append((String)localObject3);
      paramString.append("],[size]:");
      paramString.append(((File)localObject4).length());
      paramString.append(",[duration]:");
      paramString.append(System.currentTimeMillis() - l);
      paramString.append(", version=");
      paramString.append((String)localObject2);
      QLog.i("[cmshow]ApolloSoLoader", 1, paramString.toString());
      return true;
    }
  }
  
  public static void loadSo(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[loadSo], from:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",sLoadEngineLibDone:");
      localStringBuilder.append(sLoadEngineLibDone);
      localStringBuilder.append(",sIsTaskRunning:");
      localStringBuilder.append(sIsTaskRunning.get());
      QLog.i("[cmshow]ApolloSoLoader", 1, localStringBuilder.toString());
      boolean bool = sIsTaskRunning.getAndSet(true);
      if (bool) {
        return;
      }
      if (sLoadEngineLibDone)
      {
        notifyResult(0);
        sIsTaskRunning.set(false);
        return;
      }
      ThreadManager.removeJobFromThreadPool(sLoadJob, 192);
      ThreadManager.excute(sLoadJob, 192, null, true);
      return;
    }
    finally {}
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
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public static void removeLoadCallback(IApolloSoLoader.OnCmSoLoadCompleteCallback paramOnCmSoLoadCompleteCallback)
  {
    if (paramOnCmSoLoadCompleteCallback != null) {
      try
      {
        if (mCallbacks.size() != 0)
        {
          Iterator localIterator = mCallbacks.iterator();
          while (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (paramOnCmSoLoadCompleteCallback == localWeakReference.get()))
            {
              mCallbacks.remove(localWeakReference);
              if (QLog.isColorLevel()) {
                QLog.d("[cmshow]ApolloSoLoader", 2, new Object[] { "remove callback,cb:", paramOnCmSoLoadCompleteCallback });
              }
              return;
            }
          }
          return;
        }
      }
      finally {}
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloSoLoaderImpl
 * JD-Core Version:    0.7.0.1
 */