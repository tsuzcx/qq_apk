package com.tencent.ark.open;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.Logger;
import com.tencent.ark.StringUtil;
import com.tencent.ark.open.appmanage.AppManageInfoStorage;
import com.tencent.ark.open.appmanage.AppUpdateManager;
import com.tencent.ark.open.appmanage.AppUpdateTask;
import com.tencent.ark.open.appmanage.AppUpdateTask.UpdateApp;
import com.tencent.ark.open.appmanage.AppUpdateTask.UpdateTask;
import com.tencent.ark.open.appmanage.LocalAppManager;
import com.tencent.ark.open.appmanage.Utility;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.internal.ArkAppCGIMgr;
import com.tencent.ark.open.internal.WeakReferenceHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class ArkAppMgr
  implements Handler.Callback
{
  public static final boolean DEBUG = ArkEnvironmentManager.getInstance().getDebugFlag();
  protected static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
  private static final int MSG_NotifyGetAppPathByName = 1916;
  public static final String TAG = "ArkApp.ArkAppMgr";
  private final HashMap<String, ArkAppMgr.AppPathInfo> mAppPathCache = new HashMap();
  private final HashMap<String, ArkAppMgr.AppPathInfo> mDebugAppPathCache = new HashMap();
  private final WeakReferenceHandler mHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  
  public ArkAppMgr()
  {
    doInit();
  }
  
  private void doGetAppPathByName(ArkAppMgr.GetAppPathByNameTask paramGetAppPathByNameTask)
  {
    Object localObject = getAppInfoFromLocal(paramGetAppPathByNameTask.appName, paramGetAppPathByNameTask.minAppVersion);
    if (localObject != null)
    {
      paramGetAppPathByNameTask.appPathInfo = ((ArkAppMgr.AppPathInfo)localObject);
      asyncNotifyTaskResult(paramGetAppPathByNameTask, 0);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getAppPathByName, app not found at local, update app, app=");
    ((StringBuilder)localObject).append(paramGetAppPathByNameTask.appName);
    ((StringBuilder)localObject).append("min-ver=");
    ((StringBuilder)localObject).append(paramGetAppPathByNameTask.minAppVersion);
    Logger.logI("ArkApp.ArkAppMgr", ((StringBuilder)localObject).toString());
    localObject = new ArrayList();
    AppUpdateTask.UpdateApp localUpdateApp = new AppUpdateTask.UpdateApp();
    localUpdateApp.appName = paramGetAppPathByNameTask.appName;
    localUpdateApp.expectVersion = paramGetAppPathByNameTask.minAppVersion;
    ((ArrayList)localObject).add(localUpdateApp);
    AppUpdateTask.getInstance().updateApps((ArrayList)localObject, new ArkAppMgr.3(this, paramGetAppPathByNameTask));
  }
  
  private static Looper getCallbackLooper()
  {
    if (Looper.myLooper() != null) {
      return Looper.myLooper();
    }
    return Looper.getMainLooper();
  }
  
  public static ArkAppMgr getInstance()
  {
    return ArkAppMgr.Holder.gInstance;
  }
  
  private void notifyTaskResult(ArkAppMgr.GetAppPathByNameTask paramGetAppPathByNameTask)
  {
    if (paramGetAppPathByNameTask.retCode != 0) {
      paramGetAppPathByNameTask.appPathInfo = null;
    }
    if ((paramGetAppPathByNameTask.retCode == 0) && ((paramGetAppPathByNameTask.appPathInfo == null) || (paramGetAppPathByNameTask.appPathInfo.path == null)))
    {
      paramGetAppPathByNameTask.retCode = -1;
      Logger.logI("ArkApp.ArkAppMgr", StringUtil.format("notifyGetAppPathByNameTaskResult, retCode is success but task.appPathInfo.path==NULL, retCode=%d, app-name=%s", new Object[] { Integer.valueOf(paramGetAppPathByNameTask.retCode), paramGetAppPathByNameTask.appName }));
    }
    ArkAppMgr.IGetAppPathByNameCallback localIGetAppPathByNameCallback = paramGetAppPathByNameTask.callback;
    if (localIGetAppPathByNameCallback != null)
    {
      if ((paramGetAppPathByNameTask.errMsg == null) || (paramGetAppPathByNameTask.errMsg.length() == 0)) {
        paramGetAppPathByNameTask.errMsg = Utility.QueryAppRetCodeToString(paramGetAppPathByNameTask.retCode);
      }
      localIGetAppPathByNameCallback.onGetAppPathByName(paramGetAppPathByNameTask.retCode, paramGetAppPathByNameTask.errMsg, paramGetAppPathByNameTask.appPathInfo);
    }
  }
  
  private void preloadLocalApps()
  {
    String[] arrayOfString = LocalAppManager.enumInstalledAppName();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      getAppFromFile(arrayOfString[i]);
      i += 1;
    }
  }
  
  void asyncNotifyTaskResult(ArkAppMgr.GetAppPathByNameTask paramGetAppPathByNameTask, int paramInt)
  {
    paramGetAppPathByNameTask.retCode = paramInt;
    paramGetAppPathByNameTask.handler.obtainMessage(1916, paramGetAppPathByNameTask).sendToTarget();
  }
  
  boolean checkAppSignature(ArkAppMgr.AppPathInfo paramAppPathInfo)
  {
    if (paramAppPathInfo == null) {
      return false;
    }
    long l = System.currentTimeMillis();
    if ((!DEBUG) && (!ArkEnvironmentManager.getInstance().isTestEnv()))
    {
      String str1 = paramAppPathInfo.desc.name;
      String str2 = paramAppPathInfo.path;
      File localFile = new File(str2);
      if ((localFile.exists()) && (localFile.isFile()))
      {
        byte[] arrayOfByte = AppManageInfoStorage.loadAppSignature(str1);
        if ((arrayOfByte != null) && (arrayOfByte.length != 0))
        {
          if (!ArkAppCGIMgr.verifyAppPackage(localFile, arrayOfByte))
          {
            Logger.logI("ArkApp.ArkAppMgr", String.format("checkAppSignature, check fail, app=%s, path=%s", new Object[] { str1, str2 }));
            LocalAppManager.deleteAppByName(paramAppPathInfo.desc.name, true);
            return false;
          }
          Logger.logI("ArkApp.ArkAppMgr", String.format("checkAppSignature, success, app=%s, path=%s, time=%s", new Object[] { str1, str2, Long.valueOf(System.currentTimeMillis() - l) }));
          return true;
        }
        paramAppPathInfo = new StringBuilder();
        paramAppPathInfo.append("checkAppSignature, sign is empty, app=");
        paramAppPathInfo.append(str1);
        paramAppPathInfo.append(", path=");
        paramAppPathInfo.append(str2);
        Logger.logI("ArkApp.ArkAppMgr", paramAppPathInfo.toString());
        return true;
      }
      paramAppPathInfo = new StringBuilder();
      paramAppPathInfo.append("checkAppSignature, file not exist, app=");
      paramAppPathInfo.append(str1);
      paramAppPathInfo.append(", path=");
      paramAppPathInfo.append(str2);
      Logger.logI("ArkApp.ArkAppMgr", paramAppPathInfo.toString());
      return false;
    }
    Logger.logI("ArkApp.ArkAppMgr", "checkAppSignature, debug or test env, ignored");
    return true;
  }
  
  public void clearAppPathCache()
  {
    synchronized (this.mAppPathCache)
    {
      this.mAppPathCache.clear();
      return;
    }
  }
  
  public void clearDebugAppPathCache()
  {
    this.mDebugAppPathCache.clear();
  }
  
  protected void doInit()
  {
    ArkDispatchTask.getInstance().postToArkThread(new ArkAppMgr.1(this));
  }
  
  void doPreload()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      boolean bool = ArkDelegateManager.setupArkEnvironment(true);
      long l2 = System.currentTimeMillis();
      preloadLocalApps();
      AppManageInfoStorage.getUpdateTimeSP();
      AppManageInfoStorage.getAppDescSP();
      AppUpdateManager.getAppUpdatePeriodSP();
      AppUpdateManager.getAppUpdateRecordSP();
      Logger.logI("ArkApp.ArkAppMgr", String.format("ArkAppMgr.init, delegate-inited=%s, time1=%s, time2=%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l2 - l1), Long.valueOf(System.currentTimeMillis() - l2) }));
      return;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      Logger.logI("ArkApp.ArkAppMgr", localNoClassDefFoundError.toString());
    }
  }
  
  final ArkAppMgr.AppPathInfo getAppFromCache(String paramString)
  {
    ArkAppMgr.AppPathInfo localAppPathInfo = getDebuggingAppInfo(paramString);
    if (localAppPathInfo != null)
    {
      localAppPathInfo.from = 1;
      return localAppPathInfo;
    }
    paramString = getCachedAppInfo(paramString);
    if (paramString != null)
    {
      paramString.from = 1;
      return paramString;
    }
    return null;
  }
  
  final ArkAppMgr.AppPathInfo getAppFromFile(String arg1)
  {
    ArkAppMgr.AppPathInfo localAppPathInfo = LocalAppManager.getLocalAppPathByAppName(???);
    if (localAppPathInfo == null)
    {
      Logger.logI("ArkApp.ArkAppMgr", String.format("doGetAppFromLocal, not found at local, app=%s", new Object[] { ??? }));
      return null;
    }
    int i = ArkAppCacheMgr.checkAppVersion(localAppPathInfo.path);
    if (i != 1)
    {
      Logger.logI("ArkApp.ArkAppMgr", String.format("doGetAppFromLocal, not support version, ret=%s, app=%s, app-ver=%s", new Object[] { Integer.valueOf(i), ???, localAppPathInfo.desc.version }));
      LocalAppManager.deleteAppByName(???, false);
      return null;
    }
    if (!checkAppSignature(localAppPathInfo))
    {
      Logger.logI("ArkApp.ArkAppMgr", String.format("doGetAppFromLocal, signature failed, ret=%s, app=%s, app-ver=%s", new Object[] { Integer.valueOf(i), ???, localAppPathInfo.desc.version }));
      return null;
    }
    synchronized (this.mAppPathCache)
    {
      this.mAppPathCache.put(localAppPathInfo.desc.name, localAppPathInfo);
      localAppPathInfo.from = 2;
      return localAppPathInfo;
    }
  }
  
  public ArkAppMgr.AppPathInfo getAppInfoFromCache(String paramString1, String paramString2)
  {
    return getAppPathInfoByNameFromLocal(paramString1, paramString2, true);
  }
  
  public ArkAppMgr.AppPathInfo getAppInfoFromLocal(String paramString1, String paramString2)
  {
    return getAppPathInfoByNameFromLocal(paramString1, paramString2, false);
  }
  
  public void getAppPathByName(String paramString1, String paramString2, ArkAppMgr.IGetAppPathByNameCallback paramIGetAppPathByNameCallback)
  {
    paramString2 = new ArkAppMgr.GetAppPathByNameTask(paramString1, paramString2);
    paramString2.callback = paramIGetAppPathByNameCallback;
    paramString2.handler = new WeakReferenceHandler(getCallbackLooper(), this);
    if ((paramString1 != null) && (paramString1.length() != 0) && (ArkUtil.isDeviceSupportArkMsg()))
    {
      ArkDelegateManager.setupArkEnvironment(true);
      if (!ArkEnvironmentManager.getInstance().isLibraryLoad())
      {
        asyncNotifyTaskResult(paramString2, -6);
        return;
      }
      ArkDispatchTask.getInstance().postToArkThread(new ArkAppMgr.2(this, paramString2));
      return;
    }
    asyncNotifyTaskResult(paramString2, -1);
  }
  
  public String getAppPathFromCache(String paramString)
  {
    return getAppPathFromCache(paramString, "0.0.0.1");
  }
  
  public String getAppPathFromCache(String paramString1, String paramString2)
  {
    paramString1 = getAppInfoFromCache(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.path;
    }
    return null;
  }
  
  public String getAppPathFromLocal(String paramString)
  {
    return getAppPathFromLocal(paramString, "0.0.0.1");
  }
  
  public String getAppPathFromLocal(String paramString1, String paramString2)
  {
    paramString1 = getAppInfoFromLocal(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.path;
    }
    return null;
  }
  
  ArkAppMgr.AppPathInfo getAppPathInfoByNameFromLocal(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 != null) && (paramString1.length() != 0))
    {
      if (!ArkUtil.isDeviceSupportArkMsg()) {
        return null;
      }
      AppManageInfoStorage.updateAppLastUseTime(paramString1);
      ArkAppMgr.AppPathInfo localAppPathInfo2 = getAppFromCache(paramString1);
      ArkAppMgr.AppPathInfo localAppPathInfo1 = localAppPathInfo2;
      if (localAppPathInfo2 == null)
      {
        localAppPathInfo1 = localAppPathInfo2;
        if (!paramBoolean) {
          localAppPathInfo1 = getAppFromFile(paramString1);
        }
      }
      if (localAppPathInfo1 == null) {
        return null;
      }
      if (paramString2 != null)
      {
        if (Utility.compareVersionString(localAppPathInfo1.desc.version, paramString2) >= 0) {
          return localAppPathInfo1;
        }
        return null;
      }
      return localAppPathInfo1;
    }
    return null;
  }
  
  ArkAppMgr.AppPathInfo getCachedAppInfo(String paramString)
  {
    synchronized (this.mAppPathCache)
    {
      ArkAppMgr.AppPathInfo localAppPathInfo = (ArkAppMgr.AppPathInfo)this.mAppPathCache.get(paramString);
      if (localAppPathInfo == null) {
        return null;
      }
      if (localAppPathInfo.path == null)
      {
        this.mAppPathCache.remove(paramString);
        return null;
      }
      File localFile = new File(localAppPathInfo.path);
      if ((localFile.exists()) && (localFile.isFile())) {
        return localAppPathInfo;
      }
      this.mAppPathCache.remove(paramString);
      return null;
    }
  }
  
  ArkAppMgr.AppPathInfo getDebuggingAppInfo(String paramString)
  {
    synchronized (this.mDebugAppPathCache)
    {
      paramString = (ArkAppMgr.AppPathInfo)this.mDebugAppPathCache.get(paramString);
      if ((paramString != null) && (paramString.path != null))
      {
        File localFile = new File(paramString.path);
        if ((localFile.exists()) && (localFile.isFile())) {
          return paramString;
        }
        return null;
      }
      return null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1916)
    {
      notifyTaskResult((ArkAppMgr.GetAppPathByNameTask)paramMessage.obj);
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    Logger.logI("ArkApp.ArkAppMgr", "onDestroy");
    clearAppPathCache();
    clearDebugAppPathCache();
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  void onUpdateAppResult(AppUpdateTask.UpdateTask arg1, ArkAppMgr.GetAppPathByNameTask paramGetAppPathByNameTask)
  {
    int i = ???.retCode;
    String str1 = ???.errMsg;
    String str3 = ???.app.appName;
    if (i != 0)
    {
      String str2;
      if (str1 != null) {
        str2 = str1;
      } else {
        str2 = "unknown";
      }
      Logger.logI("ArkApp.ArkAppMgr", String.format("onUpdateAppResult fail, retCode=%s, app-name=%s, msg=%s", new Object[] { Integer.valueOf(i), str3, str2 }));
    }
    else if (Utility.compareVersionString(???.appPathInfo.desc.version, paramGetAppPathByNameTask.minAppVersion) >= 0)
    {
      Logger.logI("ArkApp.ArkAppMgr", String.format("onUpdateAppResult: success, result=%s, app-name=%s, expect-ver=%s, local-ver=%s", new Object[] { AppUpdateTask.resultValueToString(???.result), str3, paramGetAppPathByNameTask.minAppVersion, ???.appPathInfo.desc.version }));
    }
    else
    {
      i = 6;
      str1 = null;
      Logger.logI("ArkApp.ArkAppMgr", String.format("onUpdateAppResult fail, invalid app version, result=%s, app-name=%s, expect-ver=%s, local-ver=%s", new Object[] { AppUpdateTask.resultValueToString(???.result), str3, paramGetAppPathByNameTask.minAppVersion, ???.appPathInfo.desc.version }));
    }
    paramGetAppPathByNameTask.retCode = i;
    paramGetAppPathByNameTask.errMsg = str1;
    if (i == 0)
    {
      paramGetAppPathByNameTask.appPathInfo = ???.appPathInfo;
      synchronized (this.mAppPathCache)
      {
        this.mAppPathCache.put(paramGetAppPathByNameTask.appName, paramGetAppPathByNameTask.appPathInfo);
      }
    }
    notifyTaskResult(paramGetAppPathByNameTask);
  }
  
  public void setDebugAppPathCache(String paramString1, String arg2)
  {
    ArkAppMgr.AppPathInfo localAppPathInfo = new ArkAppMgr.AppPathInfo();
    localAppPathInfo.path = ???;
    localAppPathInfo.desc.name = paramString1;
    localAppPathInfo.desc.version = ArkAppCacheMgr.getApplicationVersion(???);
    synchronized (this.mDebugAppPathCache)
    {
      this.mDebugAppPathCache.put(paramString1, localAppPathInfo);
      return;
    }
  }
  
  public void updateInstalledApps()
  {
    AppUpdateManager.getInstance().updateInstalledApps(new ArkAppMgr.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr
 * JD-Core Version:    0.7.0.1
 */