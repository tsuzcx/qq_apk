package com.tencent.feedback.eup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.crashreport.crash.d;
import com.tencent.bugly.crashreport.crash.f;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.t;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import com.tencent.feedback.eup.jni.NativeExceptionHandlerRqdImp;
import com.tencent.feedback.eup.jni.NativeExceptionUpload;
import com.tencent.feedback.upload.UploadHandleListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

public class CrashReport
  extends com.tencent.bugly.a
{
  public static final int MODULE_ID = 1003;
  private static boolean a = false;
  private static CrashStrategyBean b = null;
  private static f c = null;
  private static CrashHandleListener d = null;
  private static t e = null;
  private static CrashReport f = new CrashReport();
  private static boolean g = false;
  private static boolean h = false;
  private static boolean i = false;
  
  public static boolean addPlugin(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return com.tencent.bugly.crashreport.common.info.a.a(paramContext).a(paramString1, paramString2, paramString3);
  }
  
  public static void addSoFiles(Context paramContext, List<SoFile> paramList)
  {
    if (paramContext == null) {
      x.d("addSoFiles args context should not be null", new Object[0]);
    }
    while ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    paramContext = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
    HashMap localHashMap = new HashMap(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SoFile localSoFile = (SoFile)paramList.next();
      PlugInBean localPlugInBean = new PlugInBean(localSoFile.fileName, localSoFile.arch, localSoFile.sha1);
      localHashMap.put("sosha1_" + localSoFile.sha1, localPlugInBean);
    }
    paramContext.b(localHashMap);
  }
  
  public static void clearSDKTotalConsume(Context paramContext)
  {
    paramContext = u.a();
    if (paramContext != null)
    {
      paramContext.b();
      paramContext.c();
    }
  }
  
  public static int countExceptionDatas(Context paramContext)
  {
    paramContext = c.a();
    if (paramContext != null) {
      return paramContext.j();
    }
    return 0;
  }
  
  @Deprecated
  public static int countStoredRecord(Context paramContext)
  {
    return countExceptionDatas(paramContext);
  }
  
  public static boolean doUploadExceptionDatas()
  {
    c localc = c.a();
    if (localc != null)
    {
      localc.a(0L);
      return true;
    }
    return false;
  }
  
  public static void filterSysLog(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      NativeCrashHandler localNativeCrashHandler = NativeCrashHandler.getInstance();
      if (localNativeCrashHandler != null) {
        localNativeCrashHandler.filterSigabrtSysLog();
      }
    }
    c.m = paramBoolean2;
  }
  
  public static Set<String> getAllUserDataKeys(Context paramContext)
  {
    if (paramContext == null)
    {
      x.d("getAllUserDataKeys args context should not be null", new Object[0]);
      return null;
    }
    return com.tencent.bugly.crashreport.common.info.a.a(paramContext).D();
  }
  
  public static CrashHandleListener getCrashHandler()
  {
    return d;
  }
  
  public static CrashStrategyBean getCrashRuntimeStrategy()
  {
    return b;
  }
  
  public static byte[] getExceptionDatas(Context paramContext)
  {
    if (c.a() != null) {
      return c.a().i();
    }
    return null;
  }
  
  public static CrashReport getInstance()
  {
    return f;
  }
  
  public static long getSDKTotalConsume(Context paramContext, boolean paramBoolean)
  {
    paramContext = u.a();
    if (paramContext != null) {
      return paramContext.a(false);
    }
    return -1L;
  }
  
  public static String getUserData(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      x.d("getUserDataValue args context should not be null", new Object[0]);
    }
    while (z.a(paramString)) {
      return null;
    }
    return com.tencent.bugly.crashreport.common.info.a.a(paramContext).i(paramString);
  }
  
  public static int getUserDatasSize(Context paramContext)
  {
    if (paramContext == null)
    {
      x.d("getUserDatasSize args context should not be null", new Object[0]);
      return -1;
    }
    return com.tencent.bugly.crashreport.common.info.a.a(paramContext).C();
  }
  
  public static int getUserSceneTagId(Context paramContext)
  {
    if (paramContext == null)
    {
      x.d("getUserSceneTagId args context should not be null", new Object[0]);
      return -1;
    }
    return com.tencent.bugly.crashreport.common.info.a.a(paramContext).G();
  }
  
  public static boolean handleCatchException(Thread paramThread, Throwable paramThrowable, String paramString, byte[] paramArrayOfByte)
  {
    boolean bool = false;
    c localc = c.a();
    if (localc != null)
    {
      localc.a(paramThread, paramThrowable, false, paramString, paramArrayOfByte, false);
      bool = true;
    }
    return bool;
  }
  
  public static void initCrashReport(Context paramContext)
  {
    initCrashReport(paramContext, null, null, true, null);
  }
  
  public static void initCrashReport(Context paramContext, CrashHandleListener paramCrashHandleListener, UploadHandleListener paramUploadHandleListener, boolean paramBoolean, CrashStrategyBean paramCrashStrategyBean)
  {
    initCrashReport(paramContext, paramCrashHandleListener, paramUploadHandleListener, paramBoolean, paramCrashStrategyBean, 0L);
  }
  
  public static void initCrashReport(Context paramContext, CrashHandleListener paramCrashHandleListener, UploadHandleListener paramUploadHandleListener, boolean paramBoolean, CrashStrategyBean paramCrashStrategyBean, long paramLong)
  {
    if (paramContext == null) {}
    while (a) {
      return;
    }
    x.b = "eup";
    x.a = "eup";
    StrategyBean.a = "https://android.rqd.qq.com/analytics/hsync";
    if (!i)
    {
      StrategyBean.b = "https://android.rqd.qq.com/analytics/hsync";
      StrategyBean.c = "https://android.rqd.qq.com/analytics/hsync";
    }
    b = paramCrashStrategyBean;
    setCrashHandler(paramCrashHandleListener);
    if (paramUploadHandleListener != null)
    {
      e = new CrashReport.2(paramUploadHandleListener);
      paramCrashHandleListener = u.a();
      if (paramCrashHandleListener != null) {
        paramCrashHandleListener.a = e;
      }
    }
    c.c = 1;
    paramCrashHandleListener = new BuglyStrategy();
    if (paramCrashStrategyBean != null)
    {
      c.g = paramCrashStrategyBean.getRecordOverDays() * 24 * 3600 * 1000;
      c.h = paramCrashStrategyBean.getOnlyLogTag();
      c.i = paramCrashStrategyBean.isStoreCrashSdcard();
      c.j = paramCrashStrategyBean.getStoreDirectoryPath();
      c.k = paramCrashStrategyBean.getCrashSdcardMaxSize();
      c.e = paramCrashStrategyBean.getMaxLogLength();
      c.f = paramCrashStrategyBean.getMaxStackLength();
      c.d = paramCrashStrategyBean.isMerged();
      c.l = paramCrashStrategyBean.isUploadSpotCrash();
      paramCrashHandleListener.setEnableANRCrashMonitor(paramCrashStrategyBean.isOpenAnr());
    }
    paramCrashHandleListener.setAppReportDelay(paramLong);
    if (z.a(com.tencent.bugly.crashreport.common.info.a.a(paramContext).e)) {
      com.tencent.bugly.crashreport.common.info.a.a(paramContext).a(paramContext.getPackageName());
    }
    if (!h)
    {
      paramUploadHandleListener = com.tencent.bugly.crashreport.common.info.a.a(paramContext).m;
      if ((paramUploadHandleListener != null) && (!z.a(paramUploadHandleListener)))
      {
        paramCrashStrategyBean = paramUploadHandleListener.toCharArray();
        int j = 0;
        int m;
        for (int k = 0; j < paramCrashStrategyBean.length; k = m)
        {
          m = k;
          if (paramCrashStrategyBean[j] == '.') {
            m = k + 1;
          }
          j += 1;
        }
        if (k < 3)
        {
          paramUploadHandleListener = paramUploadHandleListener + "." + com.tencent.bugly.crashreport.common.info.a.a(paramContext).y;
          com.tencent.bugly.crashreport.common.info.a.a(paramContext).m = paramUploadHandleListener;
          x.a("rqdp{ RQD version: %s }", new Object[] { paramUploadHandleListener });
        }
      }
    }
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).f = paramBoolean;
    paramCrashHandleListener.setUploadProcess(paramBoolean);
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).E = true;
    c.b = true;
    com.tencent.bugly.crashreport.common.strategy.a.b = 21600000L;
    paramCrashHandleListener.setEnableUserInfo(g);
    com.tencent.bugly.b.a(getInstance());
    com.tencent.bugly.b.a(paramContext, paramContext.getPackageName(), false, paramCrashHandleListener);
    a = true;
  }
  
  public static void initCrashReport(Context paramContext, boolean paramBoolean)
  {
    initCrashReport(paramContext, null, null, paramBoolean, null, 0L);
  }
  
  public static void initNativeCrashReport(Context paramContext, String paramString, boolean paramBoolean)
  {
    initNativeCrashReport(paramContext, paramString, paramBoolean, null, null);
  }
  
  public static void initNativeCrashReport(Context paramContext, String paramString, boolean paramBoolean, List<File> paramList)
  {
    initNativeCrashReport(paramContext, paramString, paramBoolean, paramList, null, 0L);
  }
  
  @SuppressLint({"SdCardPath"})
  public static void initNativeCrashReport(Context paramContext, String paramString, boolean paramBoolean, List<File> paramList, File paramFile)
  {
    initNativeCrashReport(paramContext, paramString, paramBoolean, paramList, paramFile, 0L);
  }
  
  @SuppressLint({"SdCardPath"})
  public static void initNativeCrashReport(Context paramContext, String paramString, boolean paramBoolean, List<File> paramList, File paramFile, long paramLong)
  {
    if (!a) {}
    do
    {
      return;
      Object localObject = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
      if (paramFile != null)
      {
        String str = paramFile.getAbsolutePath();
        if (!z.a(str)) {
          ((com.tencent.bugly.crashreport.common.info.a)localObject).p = str;
        }
      }
      if (paramFile != null)
      {
        localObject = paramList;
        if (paramList == null) {
          localObject = new ArrayList();
        }
        ((List)localObject).add(paramFile);
      }
      paramList = NativeCrashHandler.getInstance();
      if ((paramList != null) && (!z.a(paramString))) {
        paramList.setDumpFilePath(paramString);
      }
      paramContext = NativeExceptionHandlerRqdImp.getInstance(paramContext);
      paramContext.setTombDir(paramString);
      NativeExceptionUpload.setmHandler(paramContext);
      paramContext = c.a();
    } while (paramContext == null);
    paramContext.e();
    paramContext.a(paramLong);
    paramContext.l();
  }
  
  public static boolean needUploadCrash(Context paramContext)
  {
    return countExceptionDatas(paramContext) > 0;
  }
  
  public static void postException(int paramInt, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    Thread localThread = Thread.currentThread();
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.b, "Can not post crash caught because bugly is disable.");
      return;
    }
    d.a(localThread, paramInt, paramString1, paramString2, paramString3, paramMap);
  }
  
  public static void postException(Thread paramThread, int paramInt, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.b, "Can not post crash caught because bugly is disable.");
      return;
    }
    d.a(paramThread, paramInt, paramString1, paramString2, paramString3, paramMap);
  }
  
  public static void putUploadRequestData(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null)
    {
      x.d("putUploadRequestData args context should not be null", new Object[0]);
      return;
    }
    if (z.a(paramString1))
    {
      x.d("putUploadRequestData args key should not be null", new Object[0]);
      return;
    }
    if (z.a(paramString2))
    {
      x.d("putUploadRequestData args value should not be null", new Object[0]);
      return;
    }
    if (!paramString1.matches("[a-zA-Z[0-9]]+"))
    {
      x.d("putUploadRequestData args key should match [a-zA-Z[0-9]_]+  {" + paramString1 + "}", new Object[0]);
      return;
    }
    String str = paramString2;
    if (paramString2.length() > 200)
    {
      x.d("upload request data value length over limit %d , has been cutted!", new Object[] { Integer.valueOf(200) });
      str = paramString2.substring(0, 200);
    }
    if (paramString1.length() > 50)
    {
      x.d("upload request data key length over limit %d , will drop this new key %s", new Object[] { Integer.valueOf(50), paramString1 });
      return;
    }
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).b(paramString1, str);
    x.b("[param] put upload request data: %s - %s", new Object[] { paramString1, str });
  }
  
  public static void putUserData(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null)
    {
      x.d("putUserData args context should not be null", new Object[0]);
      return;
    }
    if (z.a(paramString1))
    {
      x.d("putUserData args key should not be null", new Object[0]);
      return;
    }
    if (z.a(paramString2))
    {
      x.d("putUserData args value should not be null", new Object[0]);
      return;
    }
    if (!paramString1.matches("[a-zA-Z[0-9]_]+"))
    {
      x.d("putUserData args key should match [a-zA-Z[0-9]_]+  {" + paramString1 + "}", new Object[0]);
      return;
    }
    String str = paramString2;
    if (paramString2.length() > 200)
    {
      x.d("user data value length over limit %d , has been cutted!", new Object[] { Integer.valueOf(200) });
      str = paramString2.substring(0, 200);
    }
    paramString2 = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
    if (paramString2.D().contains(paramString1))
    {
      com.tencent.bugly.crashreport.common.info.a.a(paramContext).a(paramString1, str);
      x.c("replace KV %s %s", new Object[] { paramString1, str });
      return;
    }
    if (paramString2.C() >= 500)
    {
      x.d("user data size is over limit %d , will drop this new key %s", new Object[] { Integer.valueOf(50), paramString1 });
      return;
    }
    if (paramString1.length() > 50)
    {
      x.d("user data key length over limit %d , will drop this new key %s", new Object[] { Integer.valueOf(50), paramString1 });
      return;
    }
    paramString2 = NativeCrashHandler.getInstance();
    if (paramString2 != null) {
      paramString2.putKeyValueToNative(paramString1, str);
    }
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).a(paramString1, str);
    x.b("[param] set user data: %s - %s", new Object[] { paramString1, str });
  }
  
  public static void removePlugin(Context paramContext, String paramString)
  {
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).f(paramString);
  }
  
  public static String removeUserData(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      x.d("removeUserData args context should not be null", new Object[0]);
    }
    while (z.a(paramString)) {
      return null;
    }
    x.b("[param] remove user data: %s", new Object[] { paramString });
    return com.tencent.bugly.crashreport.common.info.a.a(paramContext).h(paramString);
  }
  
  public static void setAPKSHa1(Context paramContext, String paramString)
  {
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).k = paramString;
    x.c("set sha1 %s", new Object[] { paramString });
  }
  
  public static void setAppChannel(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      Log.w(x.b, "setAppChannel args context should not be null");
    }
    do
    {
      return;
      if (paramString == null)
      {
        Log.w(x.b, "App channel is null, will not set");
        return;
      }
      com.tencent.bugly.crashreport.common.info.a.a(paramContext).o = paramString;
      paramContext = NativeCrashHandler.getInstance();
    } while (paramContext == null);
    paramContext.setNativeAppChannel(paramString);
  }
  
  public static void setCountryName(Context paramContext, String paramString)
  {
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).g(paramString);
  }
  
  public static void setCrashHandler(CrashHandleListener paramCrashHandleListener)
  {
    if (paramCrashHandleListener == null) {}
    do
    {
      return;
      d = paramCrashHandleListener;
      c = new CrashReport.1(paramCrashHandleListener);
      paramCrashHandleListener = c.a();
    } while (paramCrashHandleListener == null);
    paramCrashHandleListener.a(c);
  }
  
  public static void setCrashReportAble(boolean paramBoolean)
  {
    c localc = c.a();
    if (localc != null)
    {
      if (paramBoolean) {
        localc.c();
      }
    }
    else {
      return;
    }
    localc.b();
  }
  
  public static void setDatabaseCloseAfterUse(boolean paramBoolean)
  {
    com.tencent.bugly.proguard.p.a = paramBoolean;
  }
  
  public static void setDengtaAppKey(Context paramContext, String paramString)
  {
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).e = paramString;
  }
  
  public static void setDeviceId(Context paramContext, String paramString)
  {
    if (paramString != null) {
      com.tencent.bugly.crashreport.common.info.a.a(paramContext).c(paramString);
    }
  }
  
  public static void setDeviceRooted(Context paramContext, boolean paramBoolean)
  {
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).a(Boolean.valueOf(paramBoolean));
  }
  
  public static void setIsDevelopmentDevice(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null)
    {
      x.d("Context should not be null.", new Object[0]);
      return;
    }
    if (paramBoolean) {
      x.c("This is a development device.", new Object[0]);
    }
    for (;;)
    {
      com.tencent.bugly.crashreport.common.info.a.a(paramContext).A = paramBoolean;
      return;
      x.c("This is not a development device.", new Object[0]);
    }
  }
  
  public static void setLogAble(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      x.b = "eup";
      x.a = "eup";
      x.c = true;
      com.tencent.bugly.b.c = true;
      x.d("'setLogAble(boolean)' is true , so running in debug model , close it when you release!", new Object[0]);
      return;
    }
    x.c = false;
  }
  
  public static void setNativeCrashReportAble(boolean paramBoolean)
  {
    c localc = c.a();
    if (localc != null)
    {
      if (paramBoolean) {
        localc.e();
      }
      localc.d();
    }
  }
  
  public static void setProductID(Context paramContext, String paramString)
  {
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).c = paramString;
  }
  
  public static void setProductVersion(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String str = paramString;
      if (paramString.length() > 100)
      {
        str = paramString.substring(0, 100);
        x.d("appVersion %s length is over limit %d substring to %s", new Object[] { paramString, Integer.valueOf(100), str });
      }
      h = true;
      com.tencent.bugly.crashreport.common.info.a.a(paramContext).m = str;
    }
  }
  
  public static void setRdmUuid(String paramString)
  {
    com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();
    if (locala == null)
    {
      x.d("Can not set RDM UUID if RQD has not been initialized.", new Object[0]);
      return;
    }
    locala.z = paramString;
  }
  
  public static void setSOFile(Context paramContext, List<SoFile> paramList)
  {
    if (paramContext == null) {
      x.d("setSOFile args context should not be null", new Object[0]);
    }
    while ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    paramContext = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
    HashMap localHashMap = new HashMap(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SoFile localSoFile = (SoFile)paramList.next();
      PlugInBean localPlugInBean = new PlugInBean(localSoFile.fileName, localSoFile.arch, localSoFile.sha1);
      localHashMap.put("sosha1_" + localSoFile.sha1, localPlugInBean);
    }
    paramContext.a(localHashMap);
  }
  
  public static void setServerUrl(String paramString)
  {
    if ((z.a(paramString)) || (!z.c(paramString)))
    {
      x.d("URL is invalid.", new Object[0]);
      return;
    }
    i = true;
    com.tencent.bugly.crashreport.common.strategy.a.a(paramString);
    StrategyBean.b = paramString;
    StrategyBean.c = paramString;
  }
  
  public static void setThreadPoolService(ScheduledExecutorService paramScheduledExecutorService)
  {
    if (paramScheduledExecutorService != null) {
      w.a().a(paramScheduledExecutorService);
    }
  }
  
  public static void setUserId(Context paramContext, String paramString)
  {
    if (paramString == null) {}
    do
    {
      String str;
      do
      {
        return;
        str = paramString;
        if (paramString.length() > 100)
        {
          str = paramString.substring(0, 100);
          x.d("userId %s length is over limit %d substring to %s", new Object[] { paramString, Integer.valueOf(100), str });
        }
      } while (str.equals(com.tencent.bugly.crashreport.common.info.a.a(paramContext).f()));
      com.tencent.bugly.crashreport.common.info.a.a(paramContext).b(str);
      x.b("[user] set userId : %s", new Object[] { str });
      paramContext = NativeCrashHandler.getInstance();
      if (paramContext != null) {
        paramContext.setNativeUserId(str);
      }
    } while (!com.tencent.bugly.crashreport.biz.b.a);
    com.tencent.bugly.crashreport.biz.b.a();
  }
  
  public static void setUserInfoEnable(boolean paramBoolean)
  {
    g = paramBoolean;
  }
  
  public static void setUserSceneTag(Context paramContext, int paramInt)
  {
    if (paramContext == null)
    {
      x.d("setTag args context should not be null", new Object[0]);
      return;
    }
    if (paramInt <= 0)
    {
      x.d("setTag args tagId should > 0", new Object[0]);
      return;
    }
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).a(paramInt);
    x.b("[param] set user scene tag: %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void testNativeCrash()
  {
    testNativeCrash(false, false, false);
  }
  
  public static void testNativeCrash(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!a)
    {
      Log.e(x.b, "NativeCrashReport has not been initialed! pls to call method 'initNativeCrashReport' first!");
      return;
    }
    x.a("start to create a native crash for test!", new Object[0]);
    c.a().a(paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public String[] getTables()
  {
    return new String[] { "t_cr" };
  }
  
  public void init(Context paramContext, boolean paramBoolean, BuglyStrategy paramBuglyStrategy)
  {
    c localc = c.a(1003, paramContext, com.tencent.bugly.b.c, null, c, null);
    localc.c();
    localc.a(true);
    if (b != null)
    {
      localc.a(b.getCallBackType());
      localc.a(b.getCloseErrorCallback());
    }
    if ((paramBuglyStrategy == null) || (paramBuglyStrategy.isEnableANRCrashMonitor())) {
      localc.f();
    }
    for (;;)
    {
      d.a(paramContext);
      u.a().a = e;
      return;
      x.a("[crash] Closed ANR monitor!", new Object[0]);
      localc.g();
    }
  }
  
  public void onServerStrategyChanged(StrategyBean paramStrategyBean)
  {
    if (paramStrategyBean == null) {}
    c localc;
    do
    {
      return;
      localc = c.a();
    } while (localc == null);
    localc.a(paramStrategyBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.CrashReport
 * JD-Core Version:    0.7.0.1
 */