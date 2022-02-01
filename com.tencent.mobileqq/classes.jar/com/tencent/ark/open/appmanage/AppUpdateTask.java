package com.tencent.ark.open.appmanage;

import android.annotation.SuppressLint;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.Logger;
import com.tencent.ark.StringUtil;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppInfo.AppConfig;
import com.tencent.ark.open.ArkAppInfo.AppDesc;
import com.tencent.ark.open.ArkAppInfo.AppDownloadInfo;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkUtil;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.delegate.IArkDelegateNet;
import com.tencent.ark.open.internal.ArkAppCGIMgr;
import com.tencent.ark.open.internal.ArkAppCGIMgr.AppNameVersion;
import com.tencent.ark.open.internal.ArkAppCGIMgr.QueryAppInfoByAppNameBatchResult;
import com.tencent.ark.open.internal.ArkAppCGIMgr.QueryAppInfoResult;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class AppUpdateTask
{
  public static final int MIN_APP_UPDATE_INTERVAL = 10;
  private static final String TAG = "ArkApp.ArkAppMgr";
  private final ArrayList<AppUpdateTask.UpdateTask> mUpdateAppTaskList = new ArrayList();
  
  private AppUpdateTask.UpdateTask buildTask(AppUpdateTask.UpdateApp paramUpdateApp, AppUpdateTask.IUpdateAppByNameCallback paramIUpdateAppByNameCallback)
  {
    AppUpdateTask.UpdateTask localUpdateTask = new AppUpdateTask.UpdateTask();
    localUpdateTask.app = paramUpdateApp;
    localUpdateTask.localAppPathInfo = LocalAppManager.getLocalAppPathByAppName(paramUpdateApp.appName);
    localUpdateTask.callback.add(paramIUpdateAppByNameCallback);
    return localUpdateTask;
  }
  
  /* Error */
  private String copyAppPackageToAppInstallDir(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: ifnull +261 -> 265
    //   7: aload_1
    //   8: invokevirtual 89	java/lang/String:length	()I
    //   11: ifeq +254 -> 265
    //   14: aload_2
    //   15: ifnull +250 -> 265
    //   18: aload_2
    //   19: invokevirtual 89	java/lang/String:length	()I
    //   22: ifeq +243 -> 265
    //   25: aload 4
    //   27: ifnull +238 -> 265
    //   30: aload 4
    //   32: arraylength
    //   33: ifne +5 -> 38
    //   36: aconst_null
    //   37: areturn
    //   38: new 91	java/io/File
    //   41: dup
    //   42: aload_1
    //   43: invokestatic 97	com/tencent/ark/open/appmanage/Utility:getAppDirByNameAndVersion	(Ljava/lang/String;)Ljava/lang/String;
    //   46: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore 6
    //   51: aload 6
    //   53: invokevirtual 104	java/io/File:exists	()Z
    //   56: ifne +18 -> 74
    //   59: aload 6
    //   61: invokevirtual 107	java/io/File:delete	()Z
    //   64: pop
    //   65: aload 6
    //   67: invokevirtual 110	java/io/File:mkdirs	()Z
    //   70: pop
    //   71: goto +23 -> 94
    //   74: aload 6
    //   76: invokevirtual 113	java/io/File:isFile	()Z
    //   79: ifeq +15 -> 94
    //   82: aload 6
    //   84: invokevirtual 107	java/io/File:delete	()Z
    //   87: pop
    //   88: aload 6
    //   90: invokevirtual 110	java/io/File:mkdirs	()Z
    //   93: pop
    //   94: aload_1
    //   95: aload_2
    //   96: aload_3
    //   97: invokestatic 117	com/tencent/ark/open/appmanage/Utility:getAppPathByNameAndVersion	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   100: astore_3
    //   101: new 119	java/io/FileOutputStream
    //   104: dup
    //   105: aload_3
    //   106: invokespecial 120	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   109: astore_2
    //   110: aload_2
    //   111: astore_1
    //   112: aload_2
    //   113: aload 4
    //   115: invokevirtual 124	java/io/FileOutputStream:write	([B)V
    //   118: aload_2
    //   119: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   122: aload_3
    //   123: areturn
    //   124: astore_1
    //   125: ldc 11
    //   127: iconst_2
    //   128: anewarray 4	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: ldc 129
    //   135: aastore
    //   136: dup
    //   137: iconst_1
    //   138: aload_1
    //   139: invokevirtual 133	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   142: aastore
    //   143: invokestatic 139	com/tencent/ark/Logger:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: aload_3
    //   147: areturn
    //   148: astore_3
    //   149: goto +13 -> 162
    //   152: astore_1
    //   153: aload 5
    //   155: astore_2
    //   156: goto +74 -> 230
    //   159: astore_3
    //   160: aconst_null
    //   161: astore_2
    //   162: aload_2
    //   163: astore_1
    //   164: aload_3
    //   165: invokevirtual 142	java/lang/Exception:printStackTrace	()V
    //   168: aload_2
    //   169: astore_1
    //   170: ldc 11
    //   172: iconst_2
    //   173: anewarray 4	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: ldc 129
    //   180: aastore
    //   181: dup
    //   182: iconst_1
    //   183: aload_3
    //   184: invokevirtual 133	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   187: aastore
    //   188: invokestatic 139	com/tencent/ark/Logger:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: aload_2
    //   192: ifnull +31 -> 223
    //   195: aload_2
    //   196: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   199: aconst_null
    //   200: areturn
    //   201: astore_1
    //   202: ldc 11
    //   204: iconst_2
    //   205: anewarray 4	java/lang/Object
    //   208: dup
    //   209: iconst_0
    //   210: ldc 129
    //   212: aastore
    //   213: dup
    //   214: iconst_1
    //   215: aload_1
    //   216: invokevirtual 133	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   219: aastore
    //   220: invokestatic 139	com/tencent/ark/Logger:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   223: aconst_null
    //   224: areturn
    //   225: astore_3
    //   226: aload_1
    //   227: astore_2
    //   228: aload_3
    //   229: astore_1
    //   230: aload_2
    //   231: ifnull +32 -> 263
    //   234: aload_2
    //   235: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   238: goto +25 -> 263
    //   241: astore_2
    //   242: ldc 11
    //   244: iconst_2
    //   245: anewarray 4	java/lang/Object
    //   248: dup
    //   249: iconst_0
    //   250: ldc 129
    //   252: aastore
    //   253: dup
    //   254: iconst_1
    //   255: aload_2
    //   256: invokevirtual 133	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   259: aastore
    //   260: invokestatic 139	com/tencent/ark/Logger:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: aload_1
    //   264: athrow
    //   265: aconst_null
    //   266: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	AppUpdateTask
    //   0	267	1	paramString1	String
    //   0	267	2	paramString2	String
    //   0	267	3	paramString3	String
    //   0	267	4	paramArrayOfByte	byte[]
    //   1	153	5	localObject	Object
    //   49	40	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   118	122	124	java/lang/Exception
    //   112	118	148	java/lang/Exception
    //   38	71	152	finally
    //   74	94	152	finally
    //   94	110	152	finally
    //   38	71	159	java/lang/Exception
    //   74	94	159	java/lang/Exception
    //   94	110	159	java/lang/Exception
    //   195	199	201	java/lang/Exception
    //   112	118	225	finally
    //   164	168	225	finally
    //   170	191	225	finally
    //   234	238	241	java/lang/Exception
  }
  
  private static void deleteOldAppWhenUpdateSuccess(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramString1 != null) {
      try
      {
        if ((paramString1.length() != 0) && (paramString2 != null) && (paramString2.length() != 0))
        {
          paramString1 = Utility.getAppDirByNameAndVersion(paramString1);
          if ((paramString1 != null) && (paramString1.length() != 0))
          {
            paramString1 = new File(paramString1);
            boolean bool = paramString1.isDirectory();
            if (!bool) {
              return;
            }
            bool = paramString1.exists();
            if (!bool) {
              return;
            }
            paramString1.listFiles(new AppUpdateTask.5(paramString2, paramBoolean));
            return;
          }
          return;
        }
      }
      finally {}
    }
  }
  
  private void flushAppUpdateTime(AppUpdateTask.UpdateTask paramUpdateTask)
  {
    int i;
    if (paramUpdateTask.downloadInfo != null) {
      i = randomize(paramUpdateTask.downloadInfo.updatePeriodByMinutes);
    } else {
      i = 0;
    }
    AppUpdateManager.updateAppUpdateTime(paramUpdateTask.app.appName, i);
  }
  
  public static AppUpdateTask getInstance()
  {
    return AppUpdateTask.Holder.instance;
  }
  
  private void handleAppConfigUpdate(String paramString, ArkAppCGIMgr.QueryAppInfoResult paramQueryAppInfoResult)
  {
    if ((paramQueryAppInfoResult.info != null) && (paramQueryAppInfoResult.info.config != null))
    {
      ArkAppConfigMgr.getInstance().saveAppConfig(paramString, paramQueryAppInfoResult.info.config);
      return;
    }
    paramQueryAppInfoResult = ArkAppConfigMgr.getInstance().getAppConfig(paramString);
    long l;
    if (paramQueryAppInfoResult != null) {
      l = paramQueryAppInfoResult.ver;
    } else {
      l = 0L;
    }
    Logger.logI("ArkApp.ArkAppMgr", String.format("handleAppConfig, config need not update, load local, app=%s, ver=%s", new Object[] { paramString, Long.valueOf(l) }));
  }
  
  private void handleAppUpdate(AppUpdateTask.UpdateTask paramUpdateTask, String paramString, ArkAppCGIMgr.QueryAppInfoResult paramQueryAppInfoResult)
  {
    if (paramQueryAppInfoResult == null)
    {
      Logger.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.onUpdateApp_QueryAppInfoByAppNameResult, info is null, app-name=%s", new Object[] { paramString }));
      notifyUpdateAppByNameResult(0, -2, null, paramUpdateTask);
      return;
    }
    handleAppConfigUpdate(paramString, paramQueryAppInfoResult);
    if (paramQueryAppInfoResult.retCode != 0)
    {
      Logger.logI("ArkApp.ArkAppMgr", StringUtil.format("handleAppUpdate, retCode is not SUCCESS, app%s, ret=%d", new Object[] { paramString, Integer.valueOf(paramQueryAppInfoResult.retCode) }));
      notifyUpdateAppByNameResult(0, paramQueryAppInfoResult.retCode, paramQueryAppInfoResult.msg, paramUpdateTask);
      return;
    }
    if (paramQueryAppInfoResult.state == 3)
    {
      Logger.logI("ArkApp.ArkAppMgr", String.format("handleAppUpdate, app offline, app=%s", new Object[] { paramString }));
      LocalAppManager.deleteAppByName(paramString, true);
      notifyUpdateAppByNameResult(0, -5, paramQueryAppInfoResult.msg, paramUpdateTask);
      return;
    }
    if (paramQueryAppInfoResult.state == 2)
    {
      if (paramUpdateTask.localAppPathInfo == null)
      {
        Logger.logI("ArkApp.ArkAppMgr", String.format("handleAppUpdate, no update, no local app, app=%s", new Object[] { paramString }));
        notifyUpdateAppByNameResult(0, -1, null, paramUpdateTask);
        return;
      }
      Logger.logI("ArkApp.ArkAppMgr", String.format("handleAppUpdate, no update, app-name=%s, local-ver=%s", new Object[] { paramString, paramUpdateTask.localAppPathInfo.desc.version }));
      paramUpdateTask.appPathInfo = paramUpdateTask.localAppPathInfo;
      notifyUpdateAppByNameResult(2, 0, null, paramUpdateTask);
      return;
    }
    if (paramQueryAppInfoResult.state == 1)
    {
      if (paramQueryAppInfoResult.info == null)
      {
        Logger.logI("ArkApp.ArkAppMgr", StringUtil.format("handleAppUpdate, appResult.info is NULL, app-name=%s, ret-code=%d", new Object[] { paramString, Integer.valueOf(paramQueryAppInfoResult.retCode) }));
        notifyUpdateAppByNameResult(0, -1, null, paramUpdateTask);
        return;
      }
      paramUpdateTask.downloadInfo = paramQueryAppInfoResult.info;
      paramUpdateTask.appPathInfo = new ArkAppMgr.AppPathInfo();
      paramUpdateTask.appPathInfo.desc = paramQueryAppInfoResult.info.desc;
      AppManageInfoStorage.saveAppSignature(paramString, paramQueryAppInfoResult.info.sign);
      ArkAppCGIMgr.getInstance().downloadAppPackage(paramQueryAppInfoResult.info.downloadUrl, paramQueryAppInfoResult.info.sign, paramUpdateTask, new AppUpdateTask.3(this));
      return;
    }
    Logger.logI("ArkApp.ArkAppMgr", StringUtil.format("handleAppUpdate, invalid app state, app=%s, state=%d", new Object[] { paramString, Integer.valueOf(paramQueryAppInfoResult.state) }));
    notifyUpdateAppByNameResult(0, -1, null, paramUpdateTask);
  }
  
  private boolean mergeTask(String paramString, AppUpdateTask.IUpdateAppByNameCallback paramIUpdateAppByNameCallback)
  {
    synchronized (this.mUpdateAppTaskList)
    {
      Iterator localIterator = this.mUpdateAppTaskList.iterator();
      while (localIterator.hasNext())
      {
        AppUpdateTask.UpdateTask localUpdateTask = (AppUpdateTask.UpdateTask)localIterator.next();
        if (localUpdateTask.app.appName.equalsIgnoreCase(paramString))
        {
          localUpdateTask.callback.add(paramIUpdateAppByNameCallback);
          Logger.logI("ArkApp.ArkAppMgr", StringUtil.format("updateApps, request merged, app=%s, time=%d", new Object[] { paramString, Long.valueOf(localUpdateTask.startTime) }));
          return true;
        }
      }
      return false;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void notifyUpdateAppByNameResult(int paramInt1, int paramInt2, String paramString, AppUpdateTask.UpdateTask paramUpdateTask)
  {
    synchronized (this.mUpdateAppTaskList)
    {
      this.mUpdateAppTaskList.remove(paramUpdateTask);
      paramUpdateTask.result = paramInt1;
      paramUpdateTask.retCode = paramInt2;
      paramUpdateTask.errMsg = paramString;
      if (paramUpdateTask.retCode != 0)
      {
        paramUpdateTask.appPathInfo = null;
      }
      else
      {
        boolean bool;
        if ((paramUpdateTask.appPathInfo != null) && (paramUpdateTask.appPathInfo.path != null)) {
          bool = true;
        } else {
          bool = false;
        }
        ArkUtil.assertTrue(bool);
        flushAppUpdateTime(paramUpdateTask);
      }
      report(paramUpdateTask);
      ArkDispatchTask.getInstance().postToMainThread(new AppUpdateTask.4(this, paramUpdateTask));
      return;
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  private void onDownloadAppPackageResult(boolean paramBoolean, byte[] paramArrayOfByte, AppUpdateTask.UpdateTask paramUpdateTask)
  {
    if ((paramBoolean) && (paramArrayOfByte.length != 0))
    {
      String str = paramUpdateTask.app.appName;
      paramArrayOfByte = copyAppPackageToAppInstallDir(paramUpdateTask.appPathInfo.desc.name, paramUpdateTask.appPathInfo.desc.version, getAppFileExtension(paramUpdateTask), paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        Logger.logI("ArkApp.ArkAppMgr", String.format("onDownloadAppPackageResult, copy file fail, app-name=%s, app-version=%s", new Object[] { paramUpdateTask.appPathInfo.desc.name, paramUpdateTask.appPathInfo.desc.version }));
        notifyUpdateAppByNameResult(0, -3, null, paramUpdateTask);
        return;
      }
      ArkAppCacheMgr.cacheManifestInfo(paramArrayOfByte, str);
      int i = ArkAppCacheMgr.checkAppVersion(paramArrayOfByte);
      if (i != 1)
      {
        Logger.logI("ArkApp.ArkAppMgr", String.format("onDownloadAppPackageResult, check version fail, ret=%d, app-name=%s, app-path=%s", new Object[] { Integer.valueOf(i), str, paramArrayOfByte }));
        LocalAppManager.deleteAppByName(str, false);
        notifyUpdateAppByNameResult(0, 7, null, paramUpdateTask);
        return;
      }
      AppManageInfoStorage.saveAppDesc(paramUpdateTask.appPathInfo.desc.name, ArkAppCacheMgr.getApplicationDesc(str));
      Logger.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.onUpdateApp_DownloadAppPackageResult, success, app-name=%s, app-version=%s, app-path=%s", new Object[] { paramUpdateTask.appPathInfo.desc.name, paramUpdateTask.appPathInfo.desc.version, paramArrayOfByte }));
      paramUpdateTask.appPathInfo.path = paramArrayOfByte;
      paramUpdateTask.appPathInfo.from = 0;
      deleteOldAppWhenUpdateSuccess(str, paramUpdateTask.appPathInfo.desc.version, true);
      notifyUpdateAppByNameResult(1, 0, null, paramUpdateTask);
      return;
    }
    Logger.logI("ArkApp.ArkAppMgr", String.format("onDownloadAppPackageResult fail, app=%s", new Object[] { paramUpdateTask.app.appName }));
    notifyUpdateAppByNameResult(0, -2, null, paramUpdateTask);
  }
  
  @SuppressLint({"DefaultLocale"})
  private void onQueryAppInfoByAppNameResult(ArkAppCGIMgr.QueryAppInfoByAppNameBatchResult paramQueryAppInfoByAppNameBatchResult, ArrayList<AppUpdateTask.UpdateTask> paramArrayList)
  {
    if (paramQueryAppInfoByAppNameBatchResult.updateInterval > 0) {
      AppUpdateManager.putGlobalUpdatePeriod(paramQueryAppInfoByAppNameBatchResult.updateInterval);
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      AppUpdateTask.UpdateTask localUpdateTask = (AppUpdateTask.UpdateTask)paramArrayList.next();
      handleAppUpdate(localUpdateTask, localUpdateTask.app.appName, (ArkAppCGIMgr.QueryAppInfoResult)paramQueryAppInfoByAppNameBatchResult.resultList.get(localUpdateTask.app.appName));
    }
  }
  
  private void report(AppUpdateTask.UpdateTask paramUpdateTask)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", paramUpdateTask.app.appName);
    localHashMap.put("result", String.valueOf(paramUpdateTask.result));
    localHashMap.put("errorCode", String.valueOf(paramUpdateTask.retCode));
    int i;
    if (paramUpdateTask.localAppPathInfo != null) {
      i = 0;
    } else {
      i = 1;
    }
    localHashMap.put("first", String.valueOf(i));
    localHashMap.put("netType", String.valueOf(getNetType()));
    ArkEnvironmentManager localArkEnvironmentManager = ArkEnvironmentManager.getInstance();
    String str = paramUpdateTask.app.appName;
    boolean bool;
    if (paramUpdateTask.retCode == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localArkEnvironmentManager.doDataReport(str, "ArkAppUpdateMonitor", bool, (int)(System.currentTimeMillis() - paramUpdateTask.startTime), localHashMap);
  }
  
  public static String resultValueToString(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return "Unknown";
        }
        return "NoUpdate";
      }
      return "Update";
    }
    return "Fail";
  }
  
  String getAppFileExtension(AppUpdateTask.UpdateTask paramUpdateTask)
  {
    if (paramUpdateTask.downloadInfo.downloadUrl != null)
    {
      int i = paramUpdateTask.downloadInfo.downloadUrl.lastIndexOf('.');
      if (i > 0) {
        return paramUpdateTask.downloadInfo.downloadUrl.substring(i + 1);
      }
    }
    return "ark";
  }
  
  protected int getNetType()
  {
    IArkDelegateNet localIArkDelegateNet = ArkDelegateManager.getInstance().getNetDelegate();
    if (localIArkDelegateNet != null) {
      return localIArkDelegateNet.getNetworkType();
    }
    return -1;
  }
  
  protected void queryAppInfo(ArrayList<AppUpdateTask.UpdateTask> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      AppUpdateTask.UpdateTask localUpdateTask = (AppUpdateTask.UpdateTask)localIterator.next();
      ArkAppCGIMgr.AppNameVersion localAppNameVersion = new ArkAppCGIMgr.AppNameVersion();
      localAppNameVersion.appName = localUpdateTask.app.appName;
      localAppNameVersion.appVersion = localUpdateTask.getAppVersion();
      localAppNameVersion.expectAppVersion = localUpdateTask.app.expectVersion;
      localArrayList.add(localAppNameVersion);
    }
    ArkAppCGIMgr.getInstance().queryAppInfoByAppName(localArrayList, new AppUpdateTask.2(this, paramArrayList));
  }
  
  int randomize(int paramInt)
  {
    double d1 = paramInt;
    double d2 = Math.random();
    Double.isNaN(d1);
    return (int)(d1 * (d2 * 0.4000000059604645D + 1.0D - 0.2000000029802322D));
  }
  
  public void updateApps(ArrayList<AppUpdateTask.UpdateApp> paramArrayList, AppUpdateTask.IUpdateAppByNameCallback paramIUpdateAppByNameCallback)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      ArkDispatchTask.getInstance().postToArkThread(new AppUpdateTask.1(this, paramArrayList, paramIUpdateAppByNameCallback));
      return;
    }
    Logger.logI("ArkApp.ArkAppMgr", "updateApps, appNameList=null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.appmanage.AppUpdateTask
 * JD-Core Version:    0.7.0.1
 */