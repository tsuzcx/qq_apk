import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.app.AppRuntime;

public class bjeo
{
  private static boolean a;
  private static boolean b;
  private static boolean c;
  private static boolean d;
  
  public static com.tencent.mobileqq.mini.apkg.ExtConfigInfo a(com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo paramExtConfigInfo)
  {
    if (paramExtConfigInfo == null) {
      return null;
    }
    com.tencent.mobileqq.mini.apkg.ExtConfigInfo localExtConfigInfo = new com.tencent.mobileqq.mini.apkg.ExtConfigInfo();
    localExtConfigInfo.configKey = paramExtConfigInfo.configKey;
    localExtConfigInfo.configVersion = paramExtConfigInfo.configVersion;
    Object localObject1;
    Object localObject2;
    if (paramExtConfigInfo.userAuthScopes != null)
    {
      localExtConfigInfo.userAuthScopes = new ArrayList();
      localObject1 = paramExtConfigInfo.userAuthScopes.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.qqmini.sdk.launcher.model.UserAuthScope)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          com.tencent.mobileqq.mini.apkg.UserAuthScope localUserAuthScope = new com.tencent.mobileqq.mini.apkg.UserAuthScope();
          localExtConfigInfo.userAuthScopes.add(localUserAuthScope);
          localUserAuthScope.scope = ((com.tencent.qqmini.sdk.launcher.model.UserAuthScope)localObject2).scope;
          localUserAuthScope.authType = ((com.tencent.qqmini.sdk.launcher.model.UserAuthScope)localObject2).authType;
          localUserAuthScope.desc = ((com.tencent.qqmini.sdk.launcher.model.UserAuthScope)localObject2).desc;
          localUserAuthScope.settingPageTitle = ((com.tencent.qqmini.sdk.launcher.model.UserAuthScope)localObject2).settingPageTitle;
        }
      }
    }
    if (paramExtConfigInfo.apiScopeEntries != null)
    {
      localExtConfigInfo.apiScopeEntries = new ArrayList();
      paramExtConfigInfo = paramExtConfigInfo.apiScopeEntries.iterator();
      while (paramExtConfigInfo.hasNext())
      {
        localObject1 = (com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry)paramExtConfigInfo.next();
        if (localObject1 != null)
        {
          localObject2 = new com.tencent.mobileqq.mini.apkg.ApiScopeEntry();
          localExtConfigInfo.apiScopeEntries.add(localObject2);
          ((com.tencent.mobileqq.mini.apkg.ApiScopeEntry)localObject2).scope = ((com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry)localObject1).scope;
          ((com.tencent.mobileqq.mini.apkg.ApiScopeEntry)localObject2).eventName = ((com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry)localObject1).eventName;
          ((com.tencent.mobileqq.mini.apkg.ApiScopeEntry)localObject2).apiName = ((com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry)localObject1).apiName;
        }
      }
    }
    return localExtConfigInfo;
  }
  
  public static MiniAppConfig a(com.tencent.qqmini.sdk.launcher.model.MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    MiniAppConfig localMiniAppConfig = new MiniAppConfig(a(paramMiniAppInfo));
    localMiniAppConfig.entryPath = paramMiniAppInfo.launchParam.entryPath;
    localMiniAppConfig.linkType = paramMiniAppInfo.linkType;
    localMiniAppConfig.link = paramMiniAppInfo.link;
    localMiniAppConfig.isFromShowInfo = false;
    localMiniAppConfig.forceReroad = paramMiniAppInfo.forceReroad;
    localMiniAppConfig.launchParam = a(paramMiniAppInfo.launchParam);
    if (paramMiniAppInfo.baseLibInfo != null) {
      localMiniAppConfig.baseLibInfo = new com.tencent.mobileqq.mini.sdk.BaseLibInfo(paramMiniAppInfo.baseLibInfo.baseLibUrl, paramMiniAppInfo.baseLibInfo.baseLibKey, paramMiniAppInfo.baseLibInfo.baseLibVersion, paramMiniAppInfo.baseLibInfo.baseLibDesc, paramMiniAppInfo.baseLibInfo.baseLibType);
    }
    return localMiniAppConfig;
  }
  
  public static com.tencent.mobileqq.mini.apkg.MiniAppInfo a(com.tencent.qqmini.sdk.launcher.model.MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    com.tencent.mobileqq.mini.apkg.MiniAppInfo localMiniAppInfo = new com.tencent.mobileqq.mini.apkg.MiniAppInfo();
    localMiniAppInfo.topType = paramMiniAppInfo.topType;
    localMiniAppInfo.extraData = paramMiniAppInfo.extraData;
    localMiniAppInfo.recommend = paramMiniAppInfo.recommend;
    localMiniAppInfo.isSupportOffline = paramMiniAppInfo.isSupportOffline;
    localMiniAppInfo.openId = paramMiniAppInfo.openId;
    localMiniAppInfo.tinyId = paramMiniAppInfo.tinyId;
    localMiniAppInfo.position = paramMiniAppInfo.position;
    localMiniAppInfo.isSupportBlueBar = paramMiniAppInfo.isSupportBlueBar;
    localMiniAppInfo.recommendAppIconUrl = paramMiniAppInfo.recommendAppIconUrl;
    localMiniAppInfo.extendData = paramMiniAppInfo.extendData;
    localMiniAppInfo.clearAuths = paramMiniAppInfo.clearAuths;
    localMiniAppInfo.appStoreAnimPicUrl = paramMiniAppInfo.appStoreAnimPicUrl;
    localMiniAppInfo.setEngineType(paramMiniAppInfo.getEngineType());
    localMiniAppInfo.setReportType(paramMiniAppInfo.getReportType());
    if (paramMiniAppInfo.commonExt != null)
    {
      localMiniAppInfo.commonExt = new byte[paramMiniAppInfo.commonExt.length];
      System.arraycopy(paramMiniAppInfo.commonExt, 0, localMiniAppInfo.commonExt, 0, paramMiniAppInfo.commonExt.length);
    }
    Object localObject1;
    Object localObject2;
    if (paramMiniAppInfo.motionPics != null)
    {
      localMiniAppInfo.motionPics = new ArrayList();
      localObject1 = paramMiniAppInfo.motionPics.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localMiniAppInfo.motionPics.add(localObject2);
      }
    }
    if (paramMiniAppInfo.extConfigInfoList != null)
    {
      localMiniAppInfo.extConfigInfoList = new ArrayList();
      localObject1 = paramMiniAppInfo.extConfigInfoList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo)((Iterator)localObject1).next();
        localMiniAppInfo.extConfigInfoList.add(a((com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo)localObject2));
      }
    }
    if (paramMiniAppInfo.preCacheList != null)
    {
      localMiniAppInfo.preCacheList = new ArrayList();
      localObject1 = paramMiniAppInfo.preCacheList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)((Iterator)localObject1).next();
        localObject2 = new com.tencent.mobileqq.mini.apkg.PreCacheInfo(((com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)localObject2).getDataUrl, ((com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)localObject2).preCacheKey, ((com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)localObject2).expireTime, 0, 0);
        localMiniAppInfo.preCacheList.add(localObject2);
      }
    }
    localMiniAppInfo.appId = paramMiniAppInfo.appId;
    localMiniAppInfo.name = paramMiniAppInfo.name;
    localMiniAppInfo.iconUrl = paramMiniAppInfo.iconUrl;
    localMiniAppInfo.downloadUrl = paramMiniAppInfo.downloadUrl;
    localMiniAppInfo.version = paramMiniAppInfo.version;
    localMiniAppInfo.versionId = paramMiniAppInfo.versionId;
    localMiniAppInfo.desc = paramMiniAppInfo.desc;
    localMiniAppInfo.verType = paramMiniAppInfo.verType;
    localMiniAppInfo.timestamp = paramMiniAppInfo.timestamp;
    localMiniAppInfo.baselibMiniVersion = paramMiniAppInfo.baselibMiniVersion;
    localMiniAppInfo.fileSize = paramMiniAppInfo.fileSize;
    localMiniAppInfo.developerDesc = paramMiniAppInfo.developerDesc;
    localMiniAppInfo.skipDomainCheck = paramMiniAppInfo.skipDomainCheck;
    localMiniAppInfo.usrFileSizeLimit = paramMiniAppInfo.usrFileSizeLimit;
    localMiniAppInfo.noNeedRealRecommend = paramMiniAppInfo.noNeedRealRecommend;
    localMiniAppInfo.versionUpdateTime = paramMiniAppInfo.versionUpdateTime;
    localMiniAppInfo.engineType = paramMiniAppInfo.engineType;
    localMiniAppInfo.shareId = paramMiniAppInfo.shareId;
    localMiniAppInfo.via = paramMiniAppInfo.via;
    if (paramMiniAppInfo.whiteList != null)
    {
      localMiniAppInfo.whiteList = new ArrayList();
      localMiniAppInfo.whiteList.addAll(paramMiniAppInfo.whiteList);
    }
    if (paramMiniAppInfo.blackList != null)
    {
      localMiniAppInfo.blackList = new ArrayList();
      localMiniAppInfo.blackList.addAll(paramMiniAppInfo.blackList);
    }
    if (paramMiniAppInfo.requestDomainList != null)
    {
      localMiniAppInfo.requestDomainList = new ArrayList();
      localMiniAppInfo.requestDomainList.addAll(paramMiniAppInfo.requestDomainList);
    }
    if (paramMiniAppInfo.socketDomainList != null)
    {
      localMiniAppInfo.socketDomainList = new ArrayList();
      localMiniAppInfo.socketDomainList.addAll(paramMiniAppInfo.socketDomainList);
    }
    if (paramMiniAppInfo.uploadFileDomainList != null)
    {
      localMiniAppInfo.uploadFileDomainList = new ArrayList();
      localMiniAppInfo.uploadFileDomainList.addAll(paramMiniAppInfo.uploadFileDomainList);
    }
    if (paramMiniAppInfo.downloadFileDomainList != null)
    {
      localMiniAppInfo.downloadFileDomainList = new ArrayList();
      localMiniAppInfo.downloadFileDomainList.addAll(paramMiniAppInfo.downloadFileDomainList);
    }
    if (paramMiniAppInfo.businessDomainList != null)
    {
      localMiniAppInfo.businessDomainList = new ArrayList();
      localMiniAppInfo.businessDomainList.addAll(paramMiniAppInfo.businessDomainList);
    }
    if (paramMiniAppInfo.udpIpList != null) {
      localMiniAppInfo.udpIpList.addAll(paramMiniAppInfo.udpIpList);
    }
    if (paramMiniAppInfo.debugInfo != null)
    {
      localMiniAppInfo.debugInfo = new com.tencent.mobileqq.mini.apkg.DebugInfo();
      localMiniAppInfo.debugInfo.roomId = paramMiniAppInfo.debugInfo.roomId;
      localMiniAppInfo.debugInfo.wsUrl = paramMiniAppInfo.debugInfo.wsUrl;
    }
    if (paramMiniAppInfo.subpkgs != null)
    {
      localMiniAppInfo.subpkgs = new ArrayList();
      paramMiniAppInfo = paramMiniAppInfo.subpkgs.iterator();
      while (paramMiniAppInfo.hasNext())
      {
        localObject1 = (com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)paramMiniAppInfo.next();
        localObject2 = new com.tencent.mobileqq.mini.apkg.SubPkgInfo();
        ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject2).downloadUrl = ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject1).downloadUrl;
        ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject2).fileSize = ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject1).fileSize;
        ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject2).independent = ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject1).independent;
        ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject2).subPkgName = ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject1).subPkgName;
        localMiniAppInfo.subpkgs.add(localObject2);
      }
    }
    return localMiniAppInfo;
  }
  
  public static com.tencent.mobileqq.mini.sdk.EntryModel a(com.tencent.qqmini.sdk.launcher.model.EntryModel paramEntryModel)
  {
    if (paramEntryModel == null) {
      return null;
    }
    com.tencent.mobileqq.mini.sdk.EntryModel localEntryModel = new com.tencent.mobileqq.mini.sdk.EntryModel(paramEntryModel.type, paramEntryModel.uin, paramEntryModel.name, paramEntryModel.isAdmin);
    localEntryModel.reportData = paramEntryModel.reportData;
    localEntryModel.dwGroupClassExt = paramEntryModel.dwGroupClassExt;
    return localEntryModel;
  }
  
  public static com.tencent.mobileqq.mini.sdk.LaunchParam a(com.tencent.qqmini.sdk.launcher.model.LaunchParam paramLaunchParam)
  {
    if (paramLaunchParam == null) {
      return null;
    }
    com.tencent.mobileqq.mini.sdk.LaunchParam localLaunchParam = new com.tencent.mobileqq.mini.sdk.LaunchParam();
    localLaunchParam.scene = paramLaunchParam.scene;
    localLaunchParam.miniAppId = paramLaunchParam.miniAppId;
    localLaunchParam.extraKey = paramLaunchParam.extraKey;
    localLaunchParam.entryPath = paramLaunchParam.entryPath;
    localLaunchParam.navigateExtData = paramLaunchParam.navigateExtData;
    localLaunchParam.fromMiniAppId = paramLaunchParam.fromMiniAppId;
    localLaunchParam.launchClickTimeMillis = paramLaunchParam.launchClickTimeMillis;
    localLaunchParam.tempState = paramLaunchParam.tempState;
    localLaunchParam.timestamp = paramLaunchParam.timestamp;
    localLaunchParam.shareTicket = paramLaunchParam.shareTicket;
    localLaunchParam.envVersion = paramLaunchParam.envVersion;
    localLaunchParam.reportData = paramLaunchParam.reportData;
    localLaunchParam.extendData = paramLaunchParam.extendData;
    localLaunchParam.entryModel = a(paramLaunchParam.entryModel);
    localLaunchParam.fromBackToMiniApp = paramLaunchParam.fromBackToMiniApp;
    return localLaunchParam;
  }
  
  public static ArrayList<com.tencent.mobileqq.mini.apkg.ExtConfigInfo> a(ArrayList<com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(a((com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo)paramArrayList.next()));
    }
    return localArrayList;
  }
  
  /* Error */
  public static void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 522
    //   6: iconst_1
    //   7: new 524	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   14: ldc_w 527
    //   17: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: iload_0
    //   21: invokevirtual 534	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   24: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 544	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: iload_0
    //   31: ifeq +62 -> 93
    //   34: invokestatic 550	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   37: new 524	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   44: invokestatic 550	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   47: invokevirtual 554	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   50: invokevirtual 559	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   53: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 561
    //   59: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: iconst_4
    //   66: invokevirtual 565	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   69: invokeinterface 571 1 0
    //   74: ldc_w 573
    //   77: iconst_1
    //   78: invokeinterface 579 3 0
    //   83: invokeinterface 582 1 0
    //   88: pop
    //   89: ldc 2
    //   91: monitorexit
    //   92: return
    //   93: invokestatic 550	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   96: new 524	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   103: invokestatic 550	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   106: invokevirtual 554	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   109: invokevirtual 559	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   112: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc_w 561
    //   118: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: iconst_4
    //   125: invokevirtual 565	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   128: invokeinterface 571 1 0
    //   133: ldc_w 573
    //   136: iconst_0
    //   137: invokeinterface 579 3 0
    //   142: invokeinterface 582 1 0
    //   147: pop
    //   148: goto -59 -> 89
    //   151: astore_1
    //   152: ldc 2
    //   154: monitorexit
    //   155: aload_1
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramBoolean	boolean
    //   151	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	30	151	finally
    //   34	89	151	finally
    //   93	148	151	finally
  }
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 550	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   8: new 524	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   15: invokestatic 550	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   18: invokevirtual 554	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   21: invokevirtual 559	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   24: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc_w 561
    //   30: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: iconst_4
    //   37: invokevirtual 565	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   40: ldc_w 573
    //   43: iconst_m1
    //   44: invokeinterface 586 3 0
    //   49: istore_0
    //   50: iload_0
    //   51: iconst_1
    //   52: if_icmpne +8 -> 60
    //   55: ldc 2
    //   57: monitorexit
    //   58: iload_1
    //   59: ireturn
    //   60: iconst_0
    //   61: istore_1
    //   62: goto -7 -> 55
    //   65: astore_2
    //   66: ldc 2
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   49	4	0	i	int
    //   1	61	1	bool	boolean
    //   65	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	50	65	finally
  }
  
  private static boolean a(Context paramContext)
  {
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        String str = ((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName;
        if ((!"com.tencent.mobileqq:mini3".equals(str)) && (!"com.tencent.mobileqq:mini4".equals(str)))
        {
          boolean bool = "com.tencent.mobileqq:mini5".equals(str);
          if (!bool) {
            break;
          }
        }
        else
        {
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("MiniSdkUtil", 1, "getProcessInfos fail ", paramContext);
    }
    return false;
  }
  
  public static boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBoolean = d();
        return paramBoolean;
      }
      finally {}
      paramBoolean = c();
    }
  }
  
  public static boolean b()
  {
    if (BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_user_sdk_minigame_", 4).getBoolean("_minigame_enable_jank_canary_brief", false)) {
      return true;
    }
    int i = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_jank_trace_sampling_rate", 100);
    if (new Random().nextInt(10000) < i) {}
    for (i = 1; i != 0; i = 0)
    {
      QLog.i("MiniSdkUtil", 1, "sampled for JankCanary Trace Info");
      return true;
    }
    return false;
  }
  
  private static boolean c()
  {
    try
    {
      boolean bool = f();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private static boolean d()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 666	bjeo:a	Z
    //   6: ifeq +41 -> 47
    //   9: ldc_w 522
    //   12: iconst_1
    //   13: new 524	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 668
    //   23: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: getstatic 670	bjeo:c	Z
    //   29: invokevirtual 534	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   32: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 544	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: getstatic 670	bjeo:c	Z
    //   41: istore_0
    //   42: ldc 2
    //   44: monitorexit
    //   45: iload_0
    //   46: ireturn
    //   47: iconst_1
    //   48: putstatic 666	bjeo:a	Z
    //   51: invokestatic 672	bjeo:a	()Z
    //   54: ifeq +24 -> 78
    //   57: iconst_0
    //   58: putstatic 670	bjeo:c	Z
    //   61: ldc_w 522
    //   64: iconst_1
    //   65: ldc_w 674
    //   68: invokestatic 544	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: getstatic 670	bjeo:c	Z
    //   74: istore_0
    //   75: goto -33 -> 42
    //   78: invokestatic 676	bjeo:e	()Z
    //   81: istore_0
    //   82: goto -40 -> 42
    //   85: astore_1
    //   86: ldc 2
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   41	41	0	bool	boolean
    //   85	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	42	85	finally
    //   47	75	85	finally
    //   78	82	85	finally
  }
  
  private static boolean e()
  {
    try
    {
      if (apyt.a("newappsdkenable", 1) > 0) {}
      for (boolean bool = true;; bool = false)
      {
        c = bool;
        QLog.e("MiniSdkUtil", 1, "needJumpToMiniApp getConfig isOn = " + bool);
        return bool;
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniSdkUtil", 1, "needJumpToMiniApp ", localThrowable);
      c = false;
    }
  }
  
  private static boolean f()
  {
    if (b)
    {
      QLog.e("MiniSdkUtil", 1, "needJumpToMiniSDK hasMiniGameDecide lastMiniGameDecide = " + d);
      return d;
    }
    b = true;
    for (;;)
    {
      try
      {
        if (a(BaseApplicationImpl.getContext()))
        {
          int i = BaseApplicationImpl.getContext().getSharedPreferences("sdk_conf", 4).getInt("usersdk", 1);
          if (i != 1) {
            break label182;
          }
          bool = true;
          d = bool;
          QLog.e("MiniSdkUtil", 1, "needJumpToMiniSDK isMiniProcessLive useSDK = " + i);
          return c;
        }
        if (apyt.a("newsdkenable", 1) > 0)
        {
          bool = true;
          d = bool;
          QLog.e("MiniSdkUtil", 1, "needJumpToMiniGame getConfig isOn = " + bool);
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniSdkUtil", 1, "needJumpToMiniGame ", localThrowable);
        d = false;
        return false;
      }
      boolean bool = false;
      continue;
      label182:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjeo
 * JD-Core Version:    0.7.0.1
 */