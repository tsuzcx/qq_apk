package com.tencent.ark.open.appmanage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.Logger;
import com.tencent.ark.StringUtil;
import com.tencent.ark.open.ArkAppInfo.AppDesc;
import com.tencent.ark.open.ArkAppInfo.AppDownloadInfo;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.delegate.IArkDelegateSetup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class AppUpdateManager
{
  private static final int APP_UPDATE_INTERVAL_BY_MINUTES = 180;
  private static final int CHECK_APP_UPDATE_INTERVAL;
  private static final String KEY_CHECK_APP_UPDATE_INTERVAL = "KEY_CHECK_APP_UPDATE_INTERVAL";
  private static final int MINUTE_TO_MICROSECOND = 60000;
  private static final String PREF_APP_UPDATE_PERIOD = "ArkAppUpdatePeriod";
  private static final String PREF_APP_UPDATE_RECORD = "ArkAppUpdateRecord";
  private static final String TAG = "ArkApp.ArkAppMgr";
  private static boolean appUpdateDebugMode = false;
  private long lastTimeCheckAppUpdate = 0L;
  
  static
  {
    int i;
    if (ArkAppMgr.DEBUG) {
      i = 4;
    } else {
      i = 300;
    }
    CHECK_APP_UPDATE_INTERVAL = i;
  }
  
  private void beginCheckNetwork(AppUpdateManager.ICheckNetworkCallback paramICheckNetworkCallback)
  {
    ArkDispatchTask.getInstance().postToArkThread(new AppUpdateManager.2(this, paramICheckNetworkCallback));
  }
  
  private static void deleteNotUsedApps()
  {
    String[] arrayOfString = LocalAppManager.enumInstalledAppName();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (AppManageInfoStorage.isAppNotRecentUse(str))
      {
        Logger.logI("ArkApp.ArkAppMgr", String.format("delete not used app, %s", new Object[] { str }));
        LocalAppManager.deleteAppByName(str, true);
        AppManageInfoStorage.updateAppLastUseTime(str);
      }
      i += 1;
    }
  }
  
  private void doUpdateInstalledApps(AppUpdateTask.IUpdateAppByNameCallback paramIUpdateAppByNameCallback)
  {
    if (!shouldUpdateApp()) {
      return;
    }
    deleteNotUsedApps();
    ArrayList localArrayList = getUpdateAppList();
    if (localArrayList.isEmpty())
    {
      Logger.logI("ArkApp.ArkAppMgr", "doUpdateInstalledApps, no app need update.");
      return;
    }
    logUpdateInfo(localArrayList);
    runUpdateAppTask(localArrayList, paramIUpdateAppByNameCallback);
  }
  
  public static SharedPreferences getAppUpdatePeriodSP()
  {
    return ArkEnvironmentManager.getSharedPreferences("ArkAppUpdatePeriod");
  }
  
  public static SharedPreferences getAppUpdateRecordSP()
  {
    return ArkEnvironmentManager.getSharedPreferences("ArkAppUpdateRecord");
  }
  
  private int getGlobalUpdatePeriod()
  {
    return AppManageInfoStorage.getUpdateTimeSP().getInt("KEY_CHECK_APP_UPDATE_INTERVAL", CHECK_APP_UPDATE_INTERVAL);
  }
  
  public static AppUpdateManager getInstance()
  {
    return AppUpdateManager.LazyHolder.instance;
  }
  
  private ArrayList<String> getUpdateAppList()
  {
    Object localObject = new ArrayList();
    Collections.addAll((Collection)localObject, LocalAppManager.enumInstalledAppName());
    ArrayList localArrayList = new ArrayList();
    addPredownloadAppToList(localArrayList);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (((isAppNeedUpdate(str)) || (appUpdateDebugMode)) && (!localArrayList.contains(str))) {
        localArrayList.add(str);
      }
    }
    return localArrayList;
  }
  
  private boolean isAppNeedUpdate(String paramString)
  {
    long l1 = getAppUpdateRecordSP().getLong(paramString, 0L);
    int i = getAppUpdatePeriodSP().getInt(paramString, 180);
    long l2 = AppManageInfoStorage.getAppLastUseTime(paramString);
    long l3 = Math.abs(System.currentTimeMillis() - l1) / 60000L;
    if (l3 > i)
    {
      Logger.logI("ArkApp.ArkAppMgr", String.format("isAppNeedUpdate, need-update=true, app=%s, last-update=%s, delta=%s, update-period=%s, last-use-time=%s", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l3), Integer.valueOf(i), Long.valueOf(l2) }));
      return true;
    }
    Logger.logI("ArkApp.ArkAppMgr", String.format("isAppNeedUpdate, need-update=false, app=%s, last-update=%s, delta=%s, update-period=%s, last-use-time=%s", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l3), Integer.valueOf(i), Long.valueOf(l2) }));
    return false;
  }
  
  public static boolean isAppUpdateBefore(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (getAppUpdateRecordSP().getLong(paramString, -1L) != -1L) {
      bool1 = true;
    }
    return bool1;
  }
  
  private void logAppUpdateResult(AppUpdateTask.UpdateTask paramUpdateTask)
  {
    if ((paramUpdateTask.result != 1) && (paramUpdateTask.result != 2))
    {
      Logger.logI("ArkApp.ArkAppMgr", String.format("runUpdateLocalAppTask, updateAppByName fail, result=%s, app-name=%s", new Object[] { AppUpdateTask.resultValueToString(paramUpdateTask.result), paramUpdateTask.app.appName }));
      return;
    }
    String str;
    if ((paramUpdateTask.appPathInfo != null) && (paramUpdateTask.appPathInfo.desc != null) && (!TextUtils.isEmpty(paramUpdateTask.appPathInfo.desc.version))) {
      str = paramUpdateTask.appPathInfo.desc.version;
    } else {
      str = "";
    }
    int i;
    if (paramUpdateTask.downloadInfo != null) {
      i = paramUpdateTask.downloadInfo.updatePeriodByMinutes;
    } else {
      i = 0;
    }
    Logger.logI("ArkApp.ArkAppMgr", StringUtil.format("runUpdateLocalAppTask, updateAppByName success, result=%s, app-name=%s, app-version=%s, update-period=%d", new Object[] { AppUpdateTask.resultValueToString(paramUpdateTask.result), paramUpdateTask.app.appName, str, Integer.valueOf(i) }));
  }
  
  private void logUpdateInfo(ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((String)localIterator.next());
      localStringBuilder.append(';');
    }
    Logger.logI("ArkApp.ArkAppMgr", String.format("doUpdateInstalledApps, start to update, last-time=%s, app-count=%s, app-name-list=%s.", new Object[] { Long.valueOf(this.lastTimeCheckAppUpdate), Integer.valueOf(paramArrayList.size()), localStringBuilder.toString() }));
  }
  
  static void putAppUpdatePeriod(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramInt == 0) {
        return;
      }
      paramInt = Math.max(10, paramInt);
      SharedPreferences.Editor localEditor = getAppUpdatePeriodSP().edit();
      localEditor.putInt(paramString, paramInt);
      localEditor.apply();
      Logger.logI("ArkApp.ArkAppMgr", new Object[] { "ArkSafe.putAppUpdatePeriod app=", paramString, ", updatePeriodByMinutes=", Integer.valueOf(paramInt) });
    }
  }
  
  public static void putAppUpdateTime(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    SharedPreferences.Editor localEditor = getAppUpdateRecordSP().edit();
    localEditor.putLong(paramString, paramLong);
    localEditor.apply();
    Logger.logI("ArkApp.ArkAppMgr", new Object[] { "ArkSafe.putAppUpdateTime app=", paramString, ", timeMillis=", Long.valueOf(paramLong) });
  }
  
  public static void putGlobalUpdatePeriod(int paramInt)
  {
    SharedPreferences.Editor localEditor = AppManageInfoStorage.getUpdateTimeSP().edit();
    localEditor.putInt("KEY_CHECK_APP_UPDATE_INTERVAL", paramInt);
    localEditor.apply();
    Logger.logI("ArkApp.ArkAppMgr", new Object[] { "ArkSafe.putGlobalUpdatePeriod updateInterval=", Integer.valueOf(paramInt) });
  }
  
  private void runUpdateAppTask(ArrayList<String> paramArrayList, AppUpdateTask.IUpdateAppByNameCallback paramIUpdateAppByNameCallback)
  {
    if (paramArrayList.isEmpty()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      AppUpdateTask.UpdateApp localUpdateApp = new AppUpdateTask.UpdateApp();
      localUpdateApp.appName = str;
      localArrayList.add(localUpdateApp);
    }
    AppUpdateTask.getInstance().updateApps(localArrayList, new AppUpdateManager.3(this, paramIUpdateAppByNameCallback));
  }
  
  private boolean shouldUpdateApp()
  {
    int i = getGlobalUpdatePeriod();
    long l = Math.abs(System.currentTimeMillis() - this.lastTimeCheckAppUpdate) / 1000L / 60L;
    if ((this.lastTimeCheckAppUpdate != 0L) && (l <= i) && (!appUpdateDebugMode))
    {
      Logger.logI("ArkApp.ArkAppMgr", String.format("doUpdateInstalledApps, not update time, delta=%s, interval=%s", new Object[] { Long.valueOf(l), Integer.valueOf(i) }));
      return false;
    }
    this.lastTimeCheckAppUpdate = System.currentTimeMillis();
    return true;
  }
  
  public static void updateAppUpdateTime(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      putAppUpdateTime(paramString, System.currentTimeMillis());
      if (paramInt != 0) {
        putAppUpdatePeriod(paramString, paramInt);
      }
    }
  }
  
  void addPredownloadAppToList(ArrayList<String> paramArrayList)
  {
    Object localObject = ArkDelegateManager.getInstance().getSetupDelegate();
    if (localObject != null) {
      localObject = ((IArkDelegateSetup)localObject).getPredownloadApp();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return;
    }
    Logger.logI("ArkApp.ArkAppMgr", String.format("addPredownloadAppToList, count=%s", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) }));
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if ((LocalAppManager.getLocalAppPathByAppName(str) == null) && (!paramArrayList.contains(str))) {
        paramArrayList.add(str);
      }
    }
  }
  
  public void clearGlobalUpdateTime()
  {
    this.lastTimeCheckAppUpdate = 0L;
    Logger.logI("ArkApp.ArkAppMgr", "ArkSafe.clearGlobalUpdateTime");
  }
  
  public void setDebugMode(boolean paramBoolean)
  {
    appUpdateDebugMode = paramBoolean;
  }
  
  public void updateInstalledApps(AppUpdateTask.IUpdateAppByNameCallback paramIUpdateAppByNameCallback)
  {
    beginCheckNetwork(new AppUpdateManager.1(this, paramIUpdateAppByNameCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.appmanage.AppUpdateManager
 * JD-Core Version:    0.7.0.1
 */