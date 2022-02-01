package com.tencent.mobileqq.app;

import MAAccessClient.AccessRsp;
import MAAccessClient.CheckSinglePkgSigRsp;
import MAAccessClient.GetSinglePkgSigRsp;
import MAAccessClient.NoCheckMarket;
import MAAccessClient.Tips;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationConfigHelper;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.bannerprocessor.UpgradeBannerProcessor;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.config.operation.QQOperationRequestTaskInfo;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.config.operation.QQOperationVoipTipsTaskExcuteRecord;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.OperateVoipTipsInfo;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qqexpand.manager.IExpandLimitChatManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig.Dialog;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.UpgradeController.OnHandleUpgradeFinishListener;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.JumpFilterHelper;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.weather.api.IWeatherRuntimeService;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.ApkExternalInfoTool;
import com.tencent.securitysdk.utils.Verify;
import com.tencent.util.Pair;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceResp;
import protocol.KQQConfig.GetResourceRespInfo;
import protocol.KQQConfig.UpgradeInfo;
import tencent.im.mobiletips.MobileTips.MobileTipsPkg;
import tencent.im.mobiletips.MobileTips.ReqBody;
import tencent.im.mobiletips.MobileTips.RspBody;
import tencent.im.mobiletips.MobileTips.TaskInfo;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.AuthTips;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.ReqBody;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.SubMsgType0x43.UpdateTips;

public class ConfigHandler
  extends BusinessHandler
  implements UpgradeController.OnHandleUpgradeFinishListener
{
  public static int a;
  public ConfigHandler.InstallSuccessCallback a;
  public QQAppInterface a;
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private volatile boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public ConfigHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler$InstallSuccessCallback = new ConfigHandler.InstallSuccessCallback(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    int i = paramQQAppInterface.getPreferences().getInt("UPGRADE_TIPS_SHOW_COUNT", 0);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("ConfigHandler.getUpgradeTipsShowCount:");
      paramQQAppInterface.append(i);
      QLog.d("UpgradeController", 2, paramQQAppInterface.toString());
    }
    return i;
  }
  
  /* Error */
  public static com.tencent.mobileqq.upgrade.UpgradeDetailWrapper.NewApkInfo a(UpgradeInfo paramUpgradeInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_2
    //   3: astore_1
    //   4: aload_0
    //   5: ifnull +72 -> 77
    //   8: aload_2
    //   9: astore_1
    //   10: aload_0
    //   11: getfield 89	protocol/KQQConfig/UpgradeInfo:strProgressName	Ljava/lang/String;
    //   14: ifnull +63 -> 77
    //   17: aload_0
    //   18: getfield 89	protocol/KQQConfig/UpgradeInfo:strProgressName	Ljava/lang/String;
    //   21: astore_0
    //   22: aload_2
    //   23: astore_1
    //   24: aload_0
    //   25: ifnull +52 -> 77
    //   28: aload_0
    //   29: ldc 91
    //   31: invokevirtual 97	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   34: astore_0
    //   35: new 99	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper$NewApkInfo
    //   38: dup
    //   39: invokespecial 100	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper$NewApkInfo:<init>	()V
    //   42: astore_1
    //   43: aload_1
    //   44: aload_0
    //   45: iconst_2
    //   46: aaload
    //   47: putfield 102	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper$NewApkInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   50: aload_1
    //   51: aload_0
    //   52: iconst_1
    //   53: aaload
    //   54: putfield 104	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper$NewApkInfo:b	Ljava/lang/String;
    //   57: aload_1
    //   58: aload_0
    //   59: iconst_0
    //   60: aaload
    //   61: invokestatic 110	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   64: putfield 113	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper$NewApkInfo:jdField_a_of_type_Long	J
    //   67: aload_1
    //   68: aload_0
    //   69: iconst_3
    //   70: aaload
    //   71: invokestatic 119	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   74: putfield 121	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper$NewApkInfo:jdField_a_of_type_Int	I
    //   77: aload_1
    //   78: areturn
    //   79: astore_0
    //   80: aconst_null
    //   81: areturn
    //   82: astore_0
    //   83: goto -6 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	paramUpgradeInfo	UpgradeInfo
    //   3	75	1	localObject1	Object
    //   1	22	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   35	43	79	java/lang/Exception
    //   43	77	82	java/lang/Exception
  }
  
  private static String a()
  {
    Object localObject = new Date();
    int i = ((Date)localObject).getYear();
    int j = ((Date)localObject).getMonth();
    int k = ((Date)localObject).getDay();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(k);
    return ((StringBuilder)localObject).toString();
  }
  
  public static String a(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((paramContext != null) && (paramContext.size() > 0) && (((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity != null)) {
      return ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getClassName();
    }
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ConfigHandler.getUpgradeTipsUrl:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("UpgradeController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramQQAppInterface.getPreferences();
    paramQQAppInterface = ((SharedPreferences)localObject).getString("UPGRADE_TIPS_URL", null);
    if (paramQQAppInterface == null) {
      return null;
    }
    localObject = ((SharedPreferences)localObject).getString("UPGRADE_TIPS_URL_MARK", null);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ConfigHandler.getUpgradeTipsUrl:");
      localStringBuilder.append((String)localObject);
      QLog.d("UpgradeController", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(":");
      long l1 = Long.parseLong(localObject[0]);
      long l2 = Long.parseLong(localObject[1]);
      long l3 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ConfigHandler.getUpgradeTipsUrl:");
        ((StringBuilder)localObject).append(l3);
        QLog.d("UpgradeController", 2, ((StringBuilder)localObject).toString());
      }
      if (l2 < l1) {
        return null;
      }
      if (l3 <= l1) {
        return null;
      }
      if ((l3 <= l2) && (paramInt > 0)) {
        return null;
      }
    }
    return paramQQAppInterface;
  }
  
  private void a(Intent paramIntent)
  {
    paramIntent.putExtra("logout_intent", true);
    ThemeUiPlugin.destroy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ChatBackgroundManager.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.logout(true);
    if (GlobalImageCache.a != null) {
      GlobalImageCache.a.evictAll();
    }
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    Object localObject = localBaseActivity;
    if (localBaseActivity == null)
    {
      localObject = BaseApplication.getContext();
      paramIntent.addFlags(268435456);
    }
    RouteUtils.a((Context)localObject, paramIntent, "/base/login");
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putString("UPGRADE_TIPS_DAILY_STR", a());
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putInt("NEW_ICON_TIMESTAMP", paramInt);
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject = paramQQAppInterface.getPreferences();
    String str = ((SharedPreferences)localObject).getString("UPGRADE_TIPS_URL", null);
    if ((str != null) && (paramInt >= 0))
    {
      if (str.equals(paramString)) {
        return;
      }
      b(paramQQAppInterface, 0);
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface = ((SharedPreferences)localObject).edit();
      paramQQAppInterface.remove("UPGRADE_TIPS_URL_MARK");
      paramQQAppInterface.putString("UPGRADE_TIPS_URL", paramString);
      paramQQAppInterface.commit();
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = paramInt * 24 * 60 * 60 * 1000;
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(l1);
    paramQQAppInterface.append(":");
    paramQQAppInterface.append(l2 + l1);
    paramQQAppInterface = paramQQAppInterface.toString();
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("UPGRADE_TIPS_URL_MARK", paramQQAppInterface);
    ((SharedPreferences.Editor)localObject).putString("UPGRADE_TIPS_URL", paramString);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    QLog.d("UpgradeController", 1, String.format("setUpgradeAutoDownloadInWifi isAuto=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putBoolean("UPGRADE_AUTO_DOWNLOAD_IN_WIFI", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "ConfigHandler.onReceiverPCUpgradeMessage");
    }
    paramQQAppInterface = new SubMsgType0x43.UpdateTips();
    try
    {
      String str = paramQQAppInterface.bytes_desc.get().toString();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ConfigHandler.onReceiverPCUpgradeMessage: ");
        localStringBuilder.append(str);
        QLog.d("UpgradeController", 2, localStringBuilder.toString());
      }
      paramQQAppInterface.mergeFrom(paramArrayOfByte);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramQQAppInterface) {}
  }
  
  private void a(EntityManager paramEntityManager, GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("share_appid", 2, "get share appid resp info");
    }
    if (paramGetResourceRespInfo.iResult != 0)
    {
      notifyUI(5, false, null);
      return;
    }
    AppShareID localAppShareID = AppShareIDUtil.a(paramGetResourceRespInfo);
    if (localAppShareID == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parser share appid from resp info, result:  ");
      localStringBuilder.append(localAppShareID);
      QLog.d("share_appid", 2, localStringBuilder.toString());
    }
    paramGetResourceRespInfo = (AppShareID)paramEntityManager.find(AppShareID.class, "strPkgName=?", new String[] { paramGetResourceRespInfo.strPkgName });
    if (paramGetResourceRespInfo == null)
    {
      paramEntityManager.persist(localAppShareID);
      if (QLog.isColorLevel())
      {
        paramEntityManager = new StringBuilder();
        paramEntityManager.append("Persist DB appid = ");
        paramEntityManager.append(localAppShareID.strPkgName);
        QLog.d("share_appid", 2, paramEntityManager.toString());
      }
    }
    else if (localAppShareID.uiNewVer != paramGetResourceRespInfo.uiNewVer)
    {
      paramEntityManager.remove(paramGetResourceRespInfo);
      paramEntityManager.persist(localAppShareID);
      if (QLog.isColorLevel())
      {
        paramEntityManager = new StringBuilder();
        paramEntityManager.append("Update DB appid = ");
        paramEntityManager.append(localAppShareID.strPkgName);
        QLog.d("share_appid", 2, paramEntityManager.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      paramEntityManager = new StringBuilder();
      paramEntityManager.append("Not need update DB appid = ");
      paramEntityManager.append(localAppShareID.strPkgName);
      QLog.d("share_appid", 2, paramEntityManager.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a.a(localAppShareID.strPkgName, localAppShareID);
    a(localAppShareID.strResURLBig, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFileStreamPath(localAppShareID.strPkgName));
    notifyUI(5, true, localAppShareID);
  }
  
  private void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashSet.remove(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void a(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramGetResourceRespInfo == null) {
      return;
    }
    long l1 = JumpFilterHelper.a().a();
    long l2 = paramGetResourceRespInfo.uiNewVer;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleJumpWhiteList currentVersion: ");
      localStringBuilder.append(l1);
      localStringBuilder.append(", serverVersion: ");
      localStringBuilder.append(l2);
      localStringBuilder.append(",iResult: ");
      localStringBuilder.append(paramGetResourceRespInfo.iResult);
      localStringBuilder.append(", bigUrl: ");
      localStringBuilder.append(paramGetResourceRespInfo.strResURL_big);
      QLog.d("JumpWhiteList", 2, localStringBuilder.toString());
    }
    if (l2 != l1)
    {
      paramGetResourceRespInfo = paramGetResourceRespInfo.strResURL_big;
      if (TextUtils.isEmpty(paramGetResourceRespInfo)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new ConfigHandler.1(this, paramGetResourceRespInfo, l2));
      return;
    }
    ThreadManager.getFileThreadHandler().post(new ConfigHandler.2(this));
  }
  
  private void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    notifyUI(4, paramBoolean, paramUpgradeDetailWrapper);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().getString("UPGRADE_TIPS_DAILY_STR", null);
    boolean bool;
    if ((paramQQAppInterface != null) && (a().equals(paramQQAppInterface))) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ConfigHandler.isDailyShowTips:");
      localStringBuilder.append(bool);
      localStringBuilder.append("--> ");
      localStringBuilder.append(paramQQAppInterface);
      QLog.d("UpgradeController", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return paramInt == paramQQAppInterface.getPreferences().getInt("NEW_ICON_TIMESTAMP", -1);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    return paramQQAppInterface.getPreferences().getBoolean("UPGRADE_AUTO_DOWNLOAD_IN_WIFI", paramBoolean);
  }
  
  private boolean a(String paramString, long paramLong)
  {
    boolean bool2 = true;
    if (paramString == null) {
      return true;
    }
    boolean bool1 = bool2;
    if ("eggs_android_CI_8.7.0".equals(paramString))
    {
      bool1 = bool2;
      if (!((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.aio_eggs.name(), paramLong))
      {
        FileUtils.deleteFile(new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir(), "eggs_config.zip").getAbsolutePath());
        FileUtils.deleteFile(AioAnimationConfigHelper.b);
        FileUtils.deleteFile(AioAnimationConfigHelper.c);
        bool1 = false;
        AioAnimationConfigHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("k_eggs_file_version", 0L).commit();
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("str=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", isFeatureSupport=");
      localStringBuilder.append(bool1);
      QLog.d("ConfigHandler", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putInt("UPGRADE_TIPS_SHOW_COUNT", paramInt);
    paramQQAppInterface.commit();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences();
    Object localObject = paramQQAppInterface.getString("UPGRADE_BANNER_URL", null);
    if ((localObject != null) && (paramInt > 0) && (((String)localObject).equals(paramString))) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.remove("UPGRADE_BANNER_URL_MARK");
      paramQQAppInterface.putString("UPGRADE_BANNER_URL", paramString);
      paramQQAppInterface.commit();
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = paramInt * 24 * 60 * 60 * 1000;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(l2 + l1);
    localObject = ((StringBuilder)localObject).toString();
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putString("UPGRADE_BANNER_URL_MARK", (String)localObject);
    paramQQAppInterface.putString("UPGRADE_BANNER_URL", paramString);
    paramQQAppInterface.commit();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putBoolean("AUTO_DOWNLOADED_IN_WIFI", paramBoolean);
    paramQQAppInterface.commit();
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuffer();
      paramQQAppInterface.append("is auto download : ");
      paramQQAppInterface.append(paramBoolean);
      QLog.d("preLoad_configServlet", 2, paramQQAppInterface.toString());
    }
  }
  
  private void b(UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    if (paramUpgradeDetailWrapper != null)
    {
      if (paramUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) {
        return;
      }
      UpgradeInfo localUpgradeInfo = paramUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo;
      int i;
      if ((localUpgradeInfo.iUpgradeType > 0) && (localUpgradeInfo.bNewSwitch == 1)) {
        i = 1;
      } else {
        i = 0;
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (i != 0) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8004DA5", "0X8004DA5", 0, 0, (String)localObject1, "", UpgradeController.a(), "");
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      localObject2 = ((SharedPreferences)localObject1).edit();
      if (((SharedPreferences)localObject1).getInt("upgrade_timeStamp", 0) < localUpgradeInfo.iNewTimeStamp) {
        ((SharedPreferences.Editor)localObject2).putInt("upgrade_timeStamp", localUpgradeInfo.iNewTimeStamp);
      }
      ((SharedPreferences.Editor)localObject2).commit();
      a(true, paramUpgradeDetailWrapper);
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeConfigManager", 2, String.format("showUpgradeIfNecessary iActionType=%s iUpgradeType=%s", new Object[] { Integer.valueOf(localUpgradeInfo.iActionType), Integer.valueOf(localUpgradeInfo.iUpgradeType) }));
      }
      if (localUpgradeInfo.iActionType == 0)
      {
        if (localUpgradeInfo.iUpgradeType != 1) {
          d();
        }
        if (localUpgradeInfo.iUpgradeType == 2)
        {
          localObject1 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
          if ((localObject1 != null) && (!((String)localObject1).equals("com.tencent.mobileqq.activity.UserguideActivity")))
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("reason_for_upgrade", true);
            ((Intent)localObject1).putExtra("StrTitle", HardCodeUtil.a(2131702610));
            ((Intent)localObject1).putExtra("StrUpgradeDesc", HardCodeUtil.a(2131702613));
            ((Intent)localObject1).putExtra("StrUrl", localUpgradeInfo.strNewSoftwareURL);
            ((Intent)localObject1).putExtra(paramUpgradeDetailWrapper.getClass().getSimpleName(), paramUpgradeDetailWrapper);
            a((Intent)localObject1);
          }
        }
        else if (localUpgradeInfo.iUpgradeType == 1)
        {
          if (UpgradeController.a().a() == 4)
          {
            if (QLog.isColorLevel()) {
              QLog.d("UpgradeConfigManager", 2, "showUpgradeIfNecessary apk has been download");
            }
            UpgradeController.a().d(true);
            return;
          }
          boolean bool1 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
          boolean bool2 = AppNetConnInfo.isWifiConn();
          if (QLog.isColorLevel()) {
            QLog.d("UpgradeConfigManager", 2, String.format("showUpgradeIfNecessary apk has not been download. autoDownloadInWifi=%s isWifiConn=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
          }
          localObject1 = UpgradeController.a();
          if (bool1)
          {
            if (bool2)
            {
              ((UpgradeController)localObject1).a();
              return;
            }
            ((UpgradeController)localObject1).d(true);
            return;
          }
          if ((localUpgradeInfo.iTipsType != 0) && (localUpgradeInfo.iTipsType != 2))
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
            if (localObject1 != null) {
              ((MqqHandler)localObject1).obtainMessage(1134020, paramUpgradeDetailWrapper).sendToTarget();
            }
          }
          else
          {
            ((UpgradeController)localObject1).d(true);
          }
        }
        else if (localUpgradeInfo.iUpgradeType == 3)
        {
          c(paramUpgradeDetailWrapper);
        }
      }
    }
  }
  
  private void b(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramGetResourceRespInfo == null) {
      return;
    }
    IWeatherRuntimeService localIWeatherRuntimeService = (IWeatherRuntimeService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IWeatherRuntimeService.class);
    long l1 = paramGetResourceRespInfo.uiNewVer;
    long l2 = localIWeatherRuntimeService.getConfigVersion();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleWeatherResources currentVersion: ");
      localStringBuilder.append(l2);
      localStringBuilder.append(", serverVersion: ");
      localStringBuilder.append(l1);
      localStringBuilder.append(",iResult: ");
      localStringBuilder.append(paramGetResourceRespInfo.iResult);
      localStringBuilder.append(", bigUrl: ");
      localStringBuilder.append(paramGetResourceRespInfo.strResURL_big);
      QLog.d("qq_weather", 2, localStringBuilder.toString());
    }
    if (l1 != l2)
    {
      paramGetResourceRespInfo = paramGetResourceRespInfo.strResURL_big;
      if (TextUtils.isEmpty(paramGetResourceRespInfo)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new ConfigHandler.3(this, paramGetResourceRespInfo, localIWeatherRuntimeService, l1));
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getPreferences().getBoolean("AUTO_DOWNLOADED_IN_WIFI", false);
  }
  
  private void c(UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    if (paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_Boolean)
    {
      MyAppApi.a().a(BaseActivity.sTopActivity, "biz_src_yyb");
      ThreadManager.getUIHandler().postDelayed(new ConfigHandler.11(this), 5000L);
    }
  }
  
  /* Error */
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 768	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: istore 6
    //   6: iconst_0
    //   7: istore 14
    //   9: iconst_0
    //   10: istore 15
    //   12: iconst_0
    //   13: istore 16
    //   15: iconst_0
    //   16: istore 13
    //   18: iload 6
    //   20: ifeq +13 -> 33
    //   23: aload_3
    //   24: ifnull +9 -> 33
    //   27: iconst_1
    //   28: istore 6
    //   30: goto +6 -> 36
    //   33: iconst_0
    //   34: istore 6
    //   36: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +37 -> 76
    //   42: new 60	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   49: astore_2
    //   50: aload_2
    //   51: ldc_w 770
    //   54: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_2
    //   59: iload 6
    //   61: invokevirtual 482	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: ldc_w 556
    //   68: iconst_2
    //   69: aload_2
    //   70: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: iload 16
    //   78: istore 7
    //   80: iload 6
    //   82: istore 12
    //   84: iload 6
    //   86: ifeq +846 -> 932
    //   89: iload 14
    //   91: istore 10
    //   93: iload 6
    //   95: istore 11
    //   97: iload 15
    //   99: istore 9
    //   101: iload 6
    //   103: istore 8
    //   105: new 772	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   108: dup
    //   109: invokespecial 773	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   112: aload_3
    //   113: checkcast 775	[B
    //   116: checkcast 775	[B
    //   119: invokevirtual 776	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   122: checkcast 772	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   125: astore_2
    //   126: aload_2
    //   127: ifnull +865 -> 992
    //   130: iload 14
    //   132: istore 10
    //   134: iload 6
    //   136: istore 11
    //   138: iload 15
    //   140: istore 9
    //   142: iload 6
    //   144: istore 8
    //   146: aload_2
    //   147: getfield 780	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   150: invokevirtual 784	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   153: ifne +839 -> 992
    //   156: iconst_1
    //   157: istore 6
    //   159: goto +3 -> 162
    //   162: iload 14
    //   164: istore 10
    //   166: iload 6
    //   168: istore 11
    //   170: iload 15
    //   172: istore 9
    //   174: iload 6
    //   176: istore 8
    //   178: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   181: ifeq +101 -> 282
    //   184: iload 14
    //   186: istore 10
    //   188: iload 6
    //   190: istore 11
    //   192: iload 15
    //   194: istore 9
    //   196: iload 6
    //   198: istore 8
    //   200: new 60	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   207: astore_3
    //   208: iload 14
    //   210: istore 10
    //   212: iload 6
    //   214: istore 11
    //   216: iload 15
    //   218: istore 9
    //   220: iload 6
    //   222: istore 8
    //   224: aload_3
    //   225: ldc_w 786
    //   228: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: iload 14
    //   234: istore 10
    //   236: iload 6
    //   238: istore 11
    //   240: iload 15
    //   242: istore 9
    //   244: iload 6
    //   246: istore 8
    //   248: aload_3
    //   249: iload 6
    //   251: invokevirtual 482	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: iload 14
    //   257: istore 10
    //   259: iload 6
    //   261: istore 11
    //   263: iload 15
    //   265: istore 9
    //   267: iload 6
    //   269: istore 8
    //   271: ldc_w 556
    //   274: iconst_2
    //   275: aload_3
    //   276: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: iload 16
    //   284: istore 7
    //   286: iload 6
    //   288: istore 12
    //   290: iload 6
    //   292: ifeq +640 -> 932
    //   295: iload 14
    //   297: istore 10
    //   299: iload 6
    //   301: istore 11
    //   303: iload 15
    //   305: istore 9
    //   307: iload 6
    //   309: istore 8
    //   311: iload 16
    //   313: istore 7
    //   315: iload 6
    //   317: istore 12
    //   319: aload_2
    //   320: getfield 789	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   323: invokevirtual 792	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   326: ifeq +606 -> 932
    //   329: iload 14
    //   331: istore 10
    //   333: iload 6
    //   335: istore 11
    //   337: iload 15
    //   339: istore 9
    //   341: iload 6
    //   343: istore 8
    //   345: iload 16
    //   347: istore 7
    //   349: iload 6
    //   351: istore 12
    //   353: aload_2
    //   354: getfield 789	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   357: invokevirtual 330	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   360: ifnull +572 -> 932
    //   363: iload 14
    //   365: istore 10
    //   367: iload 6
    //   369: istore 11
    //   371: iload 15
    //   373: istore 9
    //   375: iload 6
    //   377: istore 8
    //   379: aload_2
    //   380: getfield 789	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   383: invokevirtual 330	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   386: invokevirtual 798	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   389: invokestatic 804	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   392: astore_2
    //   393: iload 14
    //   395: istore 10
    //   397: iload 6
    //   399: istore 11
    //   401: iload 15
    //   403: istore 9
    //   405: iload 6
    //   407: istore 8
    //   409: aload_2
    //   410: invokevirtual 808	java/nio/ByteBuffer:getShort	()S
    //   413: istore 4
    //   415: iload 14
    //   417: istore 10
    //   419: iload 6
    //   421: istore 11
    //   423: iload 15
    //   425: istore 9
    //   427: iload 6
    //   429: istore 8
    //   431: aload_2
    //   432: invokevirtual 808	java/nio/ByteBuffer:getShort	()S
    //   435: istore 5
    //   437: iload 16
    //   439: istore 7
    //   441: iload 6
    //   443: istore 12
    //   445: iload 4
    //   447: bipush 16
    //   449: if_icmpne +483 -> 932
    //   452: iload 14
    //   454: istore 10
    //   456: iload 6
    //   458: istore 11
    //   460: iload 15
    //   462: istore 9
    //   464: iload 6
    //   466: istore 8
    //   468: iload 5
    //   470: newarray byte
    //   472: astore_3
    //   473: iload 14
    //   475: istore 10
    //   477: iload 6
    //   479: istore 11
    //   481: iload 15
    //   483: istore 9
    //   485: iload 6
    //   487: istore 8
    //   489: aload_2
    //   490: aload_3
    //   491: invokevirtual 810	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   494: pop
    //   495: iload 13
    //   497: istore 7
    //   499: aload_3
    //   500: bipush 16
    //   502: baload
    //   503: iconst_1
    //   504: iand
    //   505: ifle +6 -> 511
    //   508: iconst_1
    //   509: istore 7
    //   511: iload 7
    //   513: istore 10
    //   515: iload 6
    //   517: istore 11
    //   519: iload 7
    //   521: istore 9
    //   523: iload 6
    //   525: istore 8
    //   527: aload_0
    //   528: getfield 37	com/tencent/mobileqq/app/ConfigHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   531: invokevirtual 412	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   534: aload_1
    //   535: invokevirtual 815	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   538: aconst_null
    //   539: ldc_w 817
    //   542: iload 7
    //   544: invokestatic 823	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   547: iload 7
    //   549: istore 10
    //   551: iload 6
    //   553: istore 11
    //   555: iload 7
    //   557: istore 9
    //   559: iload 6
    //   561: istore 8
    //   563: aload_0
    //   564: getfield 37	com/tencent/mobileqq/app/ConfigHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   567: aload_1
    //   568: invokevirtual 815	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   571: ldc_w 825
    //   574: iload 7
    //   576: invokevirtual 829	com/tencent/mobileqq/app/QQAppInterface:openMsfPCActive	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   579: iload 7
    //   581: istore 10
    //   583: iload 6
    //   585: istore 11
    //   587: iload 7
    //   589: istore 9
    //   591: iload 6
    //   593: istore 8
    //   595: new 60	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   602: astore_2
    //   603: iload 7
    //   605: istore 10
    //   607: iload 6
    //   609: istore 11
    //   611: iload 7
    //   613: istore 9
    //   615: iload 6
    //   617: istore 8
    //   619: aload_2
    //   620: ldc_w 831
    //   623: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: pop
    //   627: iload 7
    //   629: istore 10
    //   631: iload 6
    //   633: istore 11
    //   635: iload 7
    //   637: istore 9
    //   639: iload 6
    //   641: istore 8
    //   643: aload_2
    //   644: iload 7
    //   646: invokevirtual 482	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: iload 7
    //   652: istore 10
    //   654: iload 6
    //   656: istore 11
    //   658: iload 7
    //   660: istore 9
    //   662: iload 6
    //   664: istore 8
    //   666: aload_2
    //   667: ldc_w 833
    //   670: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: pop
    //   674: iload 7
    //   676: istore 10
    //   678: iload 6
    //   680: istore 11
    //   682: iload 7
    //   684: istore 9
    //   686: iload 6
    //   688: istore 8
    //   690: ldc_w 556
    //   693: iconst_1
    //   694: aload_2
    //   695: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   698: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   701: iload 7
    //   703: istore 10
    //   705: iload 6
    //   707: istore 11
    //   709: iload 7
    //   711: istore 9
    //   713: iload 6
    //   715: istore 8
    //   717: new 202	android/content/Intent
    //   720: dup
    //   721: ldc_w 835
    //   724: invokespecial 837	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   727: astore_2
    //   728: iload 7
    //   730: istore 10
    //   732: iload 6
    //   734: istore 11
    //   736: iload 7
    //   738: istore 9
    //   740: iload 6
    //   742: istore 8
    //   744: aload_2
    //   745: ldc_w 839
    //   748: iload 7
    //   750: invokevirtual 206	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   753: pop
    //   754: iload 7
    //   756: istore 10
    //   758: iload 6
    //   760: istore 11
    //   762: iload 7
    //   764: istore 9
    //   766: iload 6
    //   768: istore 8
    //   770: aload_2
    //   771: ldc_w 841
    //   774: aload_1
    //   775: invokevirtual 815	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   778: invokevirtual 647	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   781: pop
    //   782: iload 7
    //   784: istore 10
    //   786: iload 6
    //   788: istore 11
    //   790: iload 7
    //   792: istore 9
    //   794: iload 6
    //   796: istore 8
    //   798: aload_0
    //   799: getfield 37	com/tencent/mobileqq/app/ConfigHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   802: invokevirtual 629	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   805: aload_2
    //   806: invokevirtual 844	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   809: iload 6
    //   811: istore 12
    //   813: goto +119 -> 932
    //   816: astore_1
    //   817: goto +58 -> 875
    //   820: astore_1
    //   821: iload 9
    //   823: istore 10
    //   825: iload 8
    //   827: istore 11
    //   829: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   832: ifeq +22 -> 854
    //   835: iload 9
    //   837: istore 10
    //   839: iload 8
    //   841: istore 11
    //   843: ldc_w 556
    //   846: iconst_2
    //   847: ldc_w 846
    //   850: aload_1
    //   851: invokestatic 849	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   854: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   857: ifeq +134 -> 991
    //   860: new 60	java/lang/StringBuilder
    //   863: dup
    //   864: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   867: astore_1
    //   868: iload 9
    //   870: istore 7
    //   872: goto +78 -> 950
    //   875: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   878: ifeq +52 -> 930
    //   881: new 60	java/lang/StringBuilder
    //   884: dup
    //   885: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   888: astore_2
    //   889: aload_2
    //   890: ldc_w 786
    //   893: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: aload_2
    //   898: iload 11
    //   900: invokevirtual 482	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   903: pop
    //   904: aload_2
    //   905: ldc_w 851
    //   908: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: pop
    //   912: aload_2
    //   913: iload 10
    //   915: invokevirtual 482	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   918: pop
    //   919: ldc_w 556
    //   922: iconst_2
    //   923: aload_2
    //   924: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   927: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   930: aload_1
    //   931: athrow
    //   932: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   935: ifeq +56 -> 991
    //   938: new 60	java/lang/StringBuilder
    //   941: dup
    //   942: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   945: astore_1
    //   946: iload 12
    //   948: istore 8
    //   950: aload_1
    //   951: ldc_w 786
    //   954: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: pop
    //   958: aload_1
    //   959: iload 8
    //   961: invokevirtual 482	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   964: pop
    //   965: aload_1
    //   966: ldc_w 851
    //   969: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: pop
    //   973: aload_1
    //   974: iload 7
    //   976: invokevirtual 482	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   979: pop
    //   980: ldc_w 556
    //   983: iconst_2
    //   984: aload_1
    //   985: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   988: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   991: return
    //   992: iconst_0
    //   993: istore 6
    //   995: goto -833 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	998	0	this	ConfigHandler
    //   0	998	1	paramToServiceMsg	ToServiceMsg
    //   0	998	2	paramFromServiceMsg	FromServiceMsg
    //   0	998	3	paramObject	Object
    //   413	37	4	i	int
    //   435	34	5	j	int
    //   4	990	6	bool1	boolean
    //   78	897	7	bool2	boolean
    //   103	857	8	bool3	boolean
    //   99	770	9	bool4	boolean
    //   91	823	10	bool5	boolean
    //   95	804	11	bool6	boolean
    //   82	865	12	bool7	boolean
    //   16	480	13	bool8	boolean
    //   7	467	14	bool9	boolean
    //   10	472	15	bool10	boolean
    //   13	425	16	bool11	boolean
    // Exception table:
    //   from	to	target	type
    //   105	126	816	finally
    //   146	156	816	finally
    //   178	184	816	finally
    //   200	208	816	finally
    //   224	232	816	finally
    //   248	255	816	finally
    //   271	282	816	finally
    //   319	329	816	finally
    //   353	363	816	finally
    //   379	393	816	finally
    //   409	415	816	finally
    //   431	437	816	finally
    //   468	473	816	finally
    //   489	495	816	finally
    //   527	547	816	finally
    //   563	579	816	finally
    //   595	603	816	finally
    //   619	627	816	finally
    //   643	650	816	finally
    //   666	674	816	finally
    //   690	701	816	finally
    //   717	728	816	finally
    //   744	754	816	finally
    //   770	782	816	finally
    //   798	809	816	finally
    //   829	835	816	finally
    //   843	854	816	finally
    //   105	126	820	java/lang/Exception
    //   146	156	820	java/lang/Exception
    //   178	184	820	java/lang/Exception
    //   200	208	820	java/lang/Exception
    //   224	232	820	java/lang/Exception
    //   248	255	820	java/lang/Exception
    //   271	282	820	java/lang/Exception
    //   319	329	820	java/lang/Exception
    //   353	363	820	java/lang/Exception
    //   379	393	820	java/lang/Exception
    //   409	415	820	java/lang/Exception
    //   431	437	820	java/lang/Exception
    //   468	473	820	java/lang/Exception
    //   489	495	820	java/lang/Exception
    //   527	547	820	java/lang/Exception
    //   563	579	820	java/lang/Exception
    //   595	603	820	java/lang/Exception
    //   619	627	820	java/lang/Exception
    //   643	650	820	java/lang/Exception
    //   666	674	820	java/lang/Exception
    //   690	701	820	java/lang/Exception
    //   717	728	820	java/lang/Exception
    //   744	754	820	java/lang/Exception
    //   770	782	820	java/lang/Exception
    //   798	809	820	java/lang/Exception
  }
  
  private void c(GetResourceRespInfo paramGetResourceRespInfo)
  {
    com.tencent.mobileqq.filemanager.data.FMConstants.jdField_a_of_type_Boolean = true;
    if ((paramGetResourceRespInfo.iResult != -2) && (paramGetResourceRespInfo.iResult != 0)) {
      return;
    }
    String str = paramGetResourceRespInfo.strResURL_big;
    if ((str != null) && (str.length() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new ConfigHandler.4(this, str, paramGetResourceRespInfo));
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool4 = paramFromServiceMsg.isSuccess();
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    if ((bool4) && (paramObject != null)) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    String str = null;
    Object localObject1;
    Object localObject2;
    if (!bool4)
    {
      paramFromServiceMsg = null;
      paramObject = paramFromServiceMsg;
      paramToServiceMsg = paramObject;
      localObject1 = paramToServiceMsg;
      localObject2 = localObject1;
      bool1 = bool3;
    }
    else
    {
      paramFromServiceMsg = (AccessRsp)paramObject;
      if (paramFromServiceMsg.ret != 0) {}
      label135:
      label138:
      do
      {
        paramFromServiceMsg = null;
        paramObject = paramFromServiceMsg;
        paramToServiceMsg = paramObject;
        localObject1 = paramToServiceMsg;
        localObject2 = localObject1;
        bool1 = true;
        break;
        if ((paramFromServiceMsg.body != null) && (paramFromServiceMsg.body.length > 0)) {}
        try
        {
          paramObject = new JceInputStream(paramFromServiceMsg.body);
          paramToServiceMsg = new CheckSinglePkgSigRsp();
        }
        catch (Exception paramToServiceMsg)
        {
          int i;
          Object localObject3;
          break label138;
        }
        try
        {
          paramToServiceMsg.readFrom(paramObject);
        }
        catch (Exception paramObject)
        {
          break label135;
        }
        continue;
        paramToServiceMsg = null;
      } while ((paramToServiceMsg == null) || (paramToServiceMsg.ret != 0));
      if (paramToServiceMsg.vtMarket != null)
      {
        paramObject = paramToServiceMsg.vtMarket.iterator();
        do
        {
          do
          {
            bool1 = bool2;
            if (!paramObject.hasNext()) {
              break;
            }
            localObject1 = (NoCheckMarket)paramObject.next();
          } while (TextUtils.isEmpty(((NoCheckMarket)localObject1).pkgName));
          bool3 = bool2;
          if (!bool2) {
            bool3 = Verify.a(BaseApplicationImpl.sApplication, ((NoCheckMarket)localObject1).pkgName, ((NoCheckMarket)localObject1).versionCode, ((NoCheckMarket)localObject1).signatureMd5);
          }
          if (QLog.isDevelopLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handleCheckAuthCode NoCheckMarket:");
            ((StringBuilder)localObject2).append(((NoCheckMarket)localObject1).pkgName);
            ((StringBuilder)localObject2).append(", ");
            ((StringBuilder)localObject2).append(((NoCheckMarket)localObject1).versionCode);
            QLog.d("UpgradeController", 4, ((StringBuilder)localObject2).toString());
          }
          bool2 = bool3;
        } while (!bool3);
        bool1 = bool3;
        if (QLog.isDevelopLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("handleCheckAuthCode NoCheckMarket:");
          paramObject.append(bool3);
          QLog.d("UpgradeController", 4, paramObject.toString());
          bool1 = bool3;
        }
      }
      paramObject = paramToServiceMsg.pkgSig;
      localObject1 = paramToServiceMsg.tmastUrl;
      localObject2 = paramToServiceMsg.pageUrl;
      i = paramToServiceMsg.sigVersionCode;
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append((String)localObject2);
      paramToServiceMsg.append("#versioncode=");
      paramToServiceMsg.append(i);
      localObject2 = paramToServiceMsg.toString();
      if (QLog.isDevelopLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleCheckAuthCode TargetCode:");
        paramToServiceMsg.append(paramObject);
        paramToServiceMsg.append(", ");
        paramToServiceMsg.append(i);
        QLog.d("UpgradeController", 4, paramToServiceMsg.toString());
      }
      if (paramFromServiceMsg.tips != null)
      {
        str = paramFromServiceMsg.tips.title;
        paramToServiceMsg = paramFromServiceMsg.tips.content;
        paramFromServiceMsg = paramFromServiceMsg.tips.button;
      }
      else
      {
        paramFromServiceMsg = null;
        paramToServiceMsg = paramFromServiceMsg;
      }
    }
    if (!bool4)
    {
      bool2 = true;
    }
    else
    {
      bool2 = bool1;
      if (bool1)
      {
        Verify.a(BaseApplicationImpl.sApplication);
        bool2 = bool1;
      }
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("handleCheckAuthCode:");
    ((StringBuilder)localObject3).append(bool4);
    ((StringBuilder)localObject3).append(", valid:");
    ((StringBuilder)localObject3).append(bool2);
    QLog.d("UpgradeController", 1, ((StringBuilder)localObject3).toString());
    this.b = bool2;
    if (!bool2)
    {
      BaseApplicationImpl.sApplication.getResources();
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("reason_for_checkAuth", true);
      ((Intent)localObject3).putExtra("StrTitle", str);
      ((Intent)localObject3).putExtra("StrUpgradeDesc", paramToServiceMsg);
      ((Intent)localObject3).putExtra("StrButton", paramFromServiceMsg);
      ((Intent)localObject3).putExtra("StrClientUrl", (String)localObject1);
      ((Intent)localObject3).putExtra("StrH5Url", (String)localObject2);
      ((Intent)localObject3).putExtra("StrCode", paramObject);
      a((Intent)localObject3);
    }
    notifyUI(11, bool4, Boolean.valueOf(bool2));
  }
  
  private void d(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramGetResourceRespInfo.iResult != 0)
    {
      notifyUI(1, false, paramGetResourceRespInfo);
      return;
    }
    String str = paramGetResourceRespInfo.strResURL_big;
    if ((str != null) && (str.length() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new ConfigHandler.5(this, str, paramGetResourceRespInfo));
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("rid");
    boolean bool1 = paramFromServiceMsg.isSuccess();
    boolean bool2 = false;
    int i;
    if ((bool1) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    paramFromServiceMsg = "";
    Object localObject;
    if (i == 0)
    {
      bool1 = bool2;
      paramObject = paramFromServiceMsg;
    }
    else
    {
      localObject = (AccessRsp)paramObject;
      i = ((AccessRsp)localObject).ret;
      if (i == 1)
      {
        paramToServiceMsg = paramFromServiceMsg;
        if (QLog.isDevelopLevel())
        {
          QLog.d("UpgradeController", 4, "handleGetAuthCode not supported");
          paramToServiceMsg = paramFromServiceMsg;
        }
      }
    }
    for (;;)
    {
      bool1 = true;
      paramObject = paramToServiceMsg;
      break label205;
      if (i != 0)
      {
        bool1 = bool2;
        paramObject = paramFromServiceMsg;
      }
      else
      {
        paramObject = null;
        paramToServiceMsg = paramObject;
        if (((AccessRsp)localObject).body != null)
        {
          paramToServiceMsg = paramObject;
          if (((AccessRsp)localObject).body.length <= 0) {}
        }
      }
      try
      {
        localObject = new JceInputStream(((AccessRsp)localObject).body);
        paramToServiceMsg = new GetSinglePkgSigRsp();
      }
      catch (Exception paramToServiceMsg)
      {
        try
        {
          paramToServiceMsg.readFrom((JceInputStream)localObject);
          for (;;)
          {
            label168:
            bool1 = bool2;
            paramObject = paramFromServiceMsg;
            if (paramToServiceMsg != null) {
              if (paramToServiceMsg.ret != 0)
              {
                bool1 = bool2;
                paramObject = paramFromServiceMsg;
              }
              else
              {
                paramToServiceMsg = paramToServiceMsg.pkgSig;
                break;
              }
            }
            label205:
            if (QLog.isDevelopLevel())
            {
              paramToServiceMsg = new StringBuilder();
              paramToServiceMsg.append("handleGetAuthCode:");
              paramToServiceMsg.append(bool1);
              paramToServiceMsg.append(", ");
              paramToServiceMsg.append(str);
              paramToServiceMsg.append(", code:");
              paramToServiceMsg.append(paramObject);
              QLog.d("UpgradeController", 4, paramToServiceMsg.toString());
            }
            notifyUI(10, bool1, new Pair(paramObject, str));
            UpgradeController.a().a(bool1, str, paramObject);
            return;
            paramToServiceMsg = paramToServiceMsg;
            paramToServiceMsg = paramObject;
          }
        }
        catch (Exception paramObject)
        {
          break label168;
        }
      }
    }
  }
  
  private void e(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ConfigHandler.handleUpdateStatusActions, result is ");
      ((StringBuilder)localObject).append(paramGetResourceRespInfo.iResult);
      ((StringBuilder)localObject).append(", server version:");
      ((StringBuilder)localObject).append(paramGetResourceRespInfo.uiNewVer);
      QLog.d("Q.richstatus.xml", 2, ((StringBuilder)localObject).toString());
    }
    if (paramGetResourceRespInfo.iResult == -2)
    {
      notifyUI(7, true, Integer.valueOf(100));
      return;
    }
    if (paramGetResourceRespInfo.iResult != 0)
    {
      notifyUI(7, false, Integer.valueOf(-1));
      return;
    }
    Object localObject = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER);
    if (localObject == null) {
      return;
    }
    if (!((StatusManager)localObject).a(paramGetResourceRespInfo.uiNewVer))
    {
      notifyUI(7, true, Integer.valueOf(100));
      return;
    }
    String str = paramGetResourceRespInfo.strResURL_big;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.richstatus.xml", 2, "url is empty");
      }
      notifyUI(7, false, Integer.valueOf(-1));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new ConfigHandler.6(this, str, (StatusManager)localObject, paramGetResourceRespInfo));
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg != null)
    {
      if (paramObject == null) {
        return;
      }
      int i = ((Integer)paramToServiceMsg.getAttribute("serviceType", Integer.valueOf(2))).intValue();
      Object localObject = new cmd0x9ae.RspBody();
      int j = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      paramToServiceMsg = "";
      if (j == 0)
      {
        boolean bool1;
        if (((cmd0x9ae.RspBody)localObject).bool_has_been_authenticated.has()) {
          bool1 = ((cmd0x9ae.RspBody)localObject).bool_has_been_authenticated.get();
        } else {
          bool1 = true;
        }
        boolean bool2;
        if (((cmd0x9ae.RspBody)localObject).bool_need_auth_tips.has()) {
          bool2 = ((cmd0x9ae.RspBody)localObject).bool_need_auth_tips.get();
        } else {
          bool2 = false;
        }
        if (((cmd0x9ae.RspBody)localObject).msg_auth_tips.has()) {
          localObject = (cmd0x9ae.AuthTips)((cmd0x9ae.RspBody)localObject).msg_auth_tips.get();
        } else {
          localObject = null;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("has_auth_real_name", bool1).commit();
        if (i == 2)
        {
          if (localObject != null)
          {
            if (((cmd0x9ae.AuthTips)localObject).string_tips_title.has()) {
              paramFromServiceMsg = ((cmd0x9ae.AuthTips)localObject).string_tips_title.get();
            } else {
              paramFromServiceMsg = "";
            }
            if (((cmd0x9ae.AuthTips)localObject).string_tips_context.has()) {
              paramObject = ((cmd0x9ae.AuthTips)localObject).string_tips_context.get();
            } else {
              paramObject = "";
            }
            if (((cmd0x9ae.AuthTips)localObject).string_tips_action_url.has()) {
              paramToServiceMsg = ((cmd0x9ae.AuthTips)localObject).string_tips_action_url.get();
            }
            notifyUI(13, true, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramFromServiceMsg, paramObject, paramToServiceMsg });
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("handleGetRealNameStatus value is: ");
              ((StringBuilder)localObject).append(bool1);
              ((StringBuilder)localObject).append("|");
              ((StringBuilder)localObject).append(bool2);
              ((StringBuilder)localObject).append("|");
              ((StringBuilder)localObject).append(paramFromServiceMsg);
              ((StringBuilder)localObject).append("|");
              ((StringBuilder)localObject).append(paramObject);
              ((StringBuilder)localObject).append("|");
              ((StringBuilder)localObject).append(paramToServiceMsg);
              QLog.i("RealName", 2, ((StringBuilder)localObject).toString());
            }
            return;
          }
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleGetRealNameStatus, authTips is null ");
          paramToServiceMsg.append(bool1);
          paramToServiceMsg.append(" ");
          paramToServiceMsg.append(bool2);
          QLog.i("RealName", 2, paramToServiceMsg.toString());
        }
        else if (i == 10)
        {
          if (localObject != null)
          {
            if (((cmd0x9ae.AuthTips)localObject).string_tips_title.has()) {
              paramFromServiceMsg = ((cmd0x9ae.AuthTips)localObject).string_tips_title.get();
            } else {
              paramFromServiceMsg = "";
            }
            if (((cmd0x9ae.AuthTips)localObject).string_tips_context.has()) {
              paramObject = ((cmd0x9ae.AuthTips)localObject).string_tips_context.get();
            } else {
              paramObject = "";
            }
            if (((cmd0x9ae.AuthTips)localObject).string_tips_action_url.has()) {
              paramToServiceMsg = ((cmd0x9ae.AuthTips)localObject).string_tips_action_url.get();
            }
          }
          else
          {
            localObject = "";
            paramObject = localObject;
            paramFromServiceMsg = paramToServiceMsg;
            paramToServiceMsg = (ToServiceMsg)localObject;
          }
          localObject = (IExpandLimitChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
          ((IExpandLimitChatManager)localObject).a(bool1);
          ((IExpandLimitChatManager)localObject).a(bool2, paramFromServiceMsg, paramObject, paramToServiceMsg);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("has_auth_real_name_extendfriend", bool1).putBoolean("has_request_auth_real_name_extendfriend", true).commit();
          notifyUI(14, true, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramFromServiceMsg, paramObject, paramToServiceMsg });
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("handleGetRealNameStatus value is: ");
            ((StringBuilder)localObject).append(bool1);
            ((StringBuilder)localObject).append("|");
            ((StringBuilder)localObject).append(bool2);
            ((StringBuilder)localObject).append("|");
            ((StringBuilder)localObject).append(paramFromServiceMsg);
            ((StringBuilder)localObject).append("|");
            ((StringBuilder)localObject).append(paramObject);
            ((StringBuilder)localObject).append("|");
            ((StringBuilder)localObject).append(paramToServiceMsg);
            QLog.i("RealName", 2, ((StringBuilder)localObject).toString());
          }
        }
        else if (i == 12)
        {
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("handleGetRealNameStatus type=12, value is: ");
            paramToServiceMsg.append(bool1);
            QLog.i("RealName", 2, paramToServiceMsg.toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("has_auth_real_name_av", bool1).putBoolean("has_request_auth_real_name_av", true).commit();
          notifyUI(15, true, new Object[] { Boolean.valueOf(bool1) });
        }
      }
      else if (i == 10)
      {
        notifyUI(14, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false), "", "", "" });
      }
      else if (i == 12)
      {
        notifyUI(15, false, new Object[] { Boolean.valueOf(false) });
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleGetRealNameStatus, result is: ");
        paramToServiceMsg.append(j);
        paramToServiceMsg.append(" serviceType:");
        paramToServiceMsg.append(i);
        QLog.i("RealName", 2, paramToServiceMsg.toString());
      }
    }
  }
  
  private void f(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramGetResourceRespInfo == null) {
      return;
    }
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("k_eggs_file_version", 0L);
    long l2 = paramGetResourceRespInfo.uiNewVer;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleUpdateEggsActions currentVersion: ");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(", serverVersion: ");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(",iResult: ");
      ((StringBuilder)localObject).append(paramGetResourceRespInfo.iResult);
      ((StringBuilder)localObject).append(", bigUrl: ");
      ((StringBuilder)localObject).append(paramGetResourceRespInfo.strResURL_big);
      QLog.d("eggs", 2, ((StringBuilder)localObject).toString());
    }
    if (l2 != l1)
    {
      localObject = paramGetResourceRespInfo.strResURL_big;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new ConfigHandler.7(this, paramGetResourceRespInfo, (String)localObject, l2));
      return;
    }
    ThreadManager.getFileThreadHandler().post(new ConfigHandler.8(this, paramGetResourceRespInfo));
  }
  
  public int a(ArrayList<GetResourceReqInfo> paramArrayList, GetResourceReqInfo... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(4);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (!paramArrayList.hasNext()) {
          break;
        }
        GetResourceReqInfo localGetResourceReqInfo = (GetResourceReqInfo)paramArrayList.next();
        if (localGetResourceReqInfo != null)
        {
          if (localGetResourceReqInfo.strPkgName.equals("QQAddFriend.AdministrateRegion")) {
            bool1 = true;
          }
          localArrayList.add(localGetResourceReqInfo);
        }
      }
    }
    boolean bool2 = false;
    int j = paramVarArgs.length;
    boolean bool1 = bool2;
    int i = 0;
    while (i < j)
    {
      paramArrayList = paramVarArgs[i];
      bool2 = bool1;
      if (paramArrayList != null)
      {
        if (paramArrayList.strPkgName.equals("QQAddFriend.AdministrateRegion")) {
          bool1 = true;
        }
        localArrayList.add(paramArrayList);
        bool2 = bool1;
      }
      i += 1;
      bool1 = bool2;
    }
    if (localArrayList.size() <= 0) {
      return -1;
    }
    paramArrayList = createToServiceMsg("ResourceConfig.GetResourceReq");
    paramArrayList.extraData.putSerializable("getResourceReqInfos", localArrayList);
    paramArrayList.extraData.putBoolean("reqRegionConfig", bool1);
    i = MobileQQServiceBase.seq;
    MobileQQServiceBase.seq = i + 1;
    paramArrayList.setAppSeq(i);
    if (QLog.isColorLevel()) {
      QLog.d("updateConfigs", 2, String.format("updateConfigs reqRegionConfig!, AppSeq[%s]", new Object[] { Integer.valueOf(paramArrayList.getAppSeq()) }));
    }
    send(paramArrayList);
    return paramArrayList.getAppSeq();
  }
  
  public GetResourceReqInfo a()
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("k_eggs_file_version", 0L);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getEggsInfo curVersion: ");
      ((StringBuilder)localObject).append(l);
      QLog.d("eggs", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new GetResourceReqInfo();
    ((GetResourceReqInfo)localObject).uiResID = 0L;
    ((GetResourceReqInfo)localObject).strPkgName = "eggs_android_CI_8.7.0";
    ((GetResourceReqInfo)localObject).uiCurVer = l;
    ((GetResourceReqInfo)localObject).sResType = 2;
    ((GetResourceReqInfo)localObject).sLanType = 0;
    ((GetResourceReqInfo)localObject).sReqType = 1;
    return localObject;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfigHandler", 2, "send_oidb_0x5eb_42073");
    }
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())));
      localReqBody.rpt_uint64_uins.set(localArrayList);
      localReqBody.uint32_preload_disable_flag.set(1);
      sendPbReq(makeOIDBPkg("OidbSvc.0x5eb_42073", 1515, 22, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ConfigHandler", 2, "send_oidb_0x5eb_42073 error", localException);
      }
    }
  }
  
  public void a(int paramInt, UpgradeDetailWrapper paramUpgradeDetailWrapper, UpgradeController paramUpgradeController)
  {
    paramUpgradeController = paramUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo;
    if ((paramInt == 0) && (paramUpgradeController != null))
    {
      BaseApplicationImpl.sApplication.getPackageName();
      a(paramUpgradeController);
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramUpgradeController.strNewTipsDescURL, paramUpgradeController.iTipsWaitDay);
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramUpgradeController.strBannerPicUrl, paramUpgradeController.iDisplayDay);
      b(paramUpgradeDetailWrapper);
      return;
    }
    a(true, paramUpgradeDetailWrapper);
  }
  
  public void a(UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    if (paramUpgradeDetailWrapper != null)
    {
      paramUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo = new UpgradeInfo();
      a(false, paramUpgradeDetailWrapper);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = (byte[])paramObject;
    int i;
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle_oidb_0x5eb_42073 ");
      paramToServiceMsg.append(paramFromServiceMsg.isSuccess());
      paramToServiceMsg.append(", ");
      if (localObject != null) {
        i = localObject.length;
      } else {
        i = -1;
      }
      paramToServiceMsg.append(i);
      QLog.d("ConfigHandler", 2, paramToServiceMsg.toString());
    }
    paramObject = UpgradeController.a();
    paramToServiceMsg = paramObject.a();
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (localObject != null)) {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])localObject);
        if ((paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0))
        {
          localObject = new oidb_0x5eb.RspBody();
          ((oidb_0x5eb.RspBody)localObject).mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (((oidb_0x5eb.RspBody)localObject).rpt_msg_uin_data.size() > 0) {
            i = ((oidb_0x5eb.UdcUinData)((oidb_0x5eb.RspBody)localObject).rpt_msg_uin_data.get(0)).uint32_preload_disable_flag.get();
          }
        }
      }
      catch (Throwable paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ConfigHandler", 2, "", paramFromServiceMsg);
        }
      }
    } else {
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("preDownload switch bit has been got. value=");
          paramFromServiceMsg.append(i);
          QLog.d("UpgradeConfigManager", 2, paramFromServiceMsg.toString());
        }
        paramToServiceMsg.jdField_a_of_type_Boolean = true;
        if (i == 1)
        {
          bool2 = true;
        }
        else
        {
          if (i != 2) {
            break label514;
          }
          UpgradeController.a().b();
          break label514;
        }
        if (paramToServiceMsg.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo != null)
        {
          boolean bool1 = bool2;
          if (i == 0) {
            if (paramToServiceMsg.jdField_a_of_type_Int == 1)
            {
              bool1 = true;
            }
            else
            {
              bool1 = bool2;
              if (paramToServiceMsg.jdField_a_of_type_Int == 2) {
                bool1 = false;
              }
            }
          }
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handle_oidb_0x5eb_42073.wifi_pre_download_switch=");
            paramFromServiceMsg.append(bool1);
            QLog.d("UpgradeConfigManager", 2, paramFromServiceMsg.toString());
            bool2 = bool1;
          }
        }
        else
        {
          paramToServiceMsg.jdField_b_of_type_Int = i;
        }
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool2);
        if (QLog.isColorLevel()) {
          QLog.d("preLoad_configServlet", 2, "begin synchronized --toggle bit");
        }
        if ((paramToServiceMsg.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo != null) && (paramToServiceMsg.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig != null) && (paramToServiceMsg.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType != 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("preLoad_configServlet", 2, "begin synchronized --toggle bit go on");
          }
          paramFromServiceMsg = (ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
          paramObject.a(paramToServiceMsg.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo, paramFromServiceMsg);
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("preLoad_configServlet", 2, "begin synchronized --toggle bit wait");
        }
        return;
      }
      finally {}
      label514:
      boolean bool2 = false;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      if (paramToServiceMsg.extraData.getBoolean("reqRegionConfig")) {
        ((ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).a(null);
      }
      return;
    }
    paramToServiceMsg = ((GetResourceResp)paramObject).vecResRespInfo;
    if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
    {
      int i = 0;
      while (i < paramToServiceMsg.size())
      {
        paramObject = (GetResourceRespInfo)paramToServiceMsg.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloadTrace", 2, String.format("onReceive_GetResourceRespInfo. \r\n%s", new Object[] { paramObject }));
        }
        if (paramObject.sResType == 3)
        {
          if ("FileOnlinePreviewConfigV2".equals(paramObject.strPkgName)) {
            c(paramObject);
          } else {
            d(paramObject);
          }
        }
        else if (paramObject.sResType == 0)
        {
          if ("com.tencent.weather_bg".equals(paramObject.strPkgName)) {
            b(paramObject);
          }
        }
        else
        {
          Object localObject;
          if (paramObject.sResType == 2)
          {
            if ("rich_status_android".equals(paramObject.strPkgName))
            {
              e(paramObject);
            }
            else if ("eggs_android_CI_8.7.0".equals(paramObject.strPkgName))
            {
              f(paramObject);
            }
            else if ("QQAddFriend.AdministrateRegion".equals(paramObject.strPkgName))
            {
              localObject = (ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
              if (localObject != null) {
                ((ConditionSearchManager)localObject).a(paramObject);
              }
            }
            else if ("com.tencent.jumpCI".equals(paramObject.strPkgName))
            {
              a(paramObject);
            }
          }
          else if (paramObject.sResType == 4)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
            a((EntityManager)localObject, paramObject);
            ((EntityManager)localObject).close();
          }
          else if (paramObject.sResType == 512)
          {
            localObject = (IEarlyDownloadService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEarlyDownloadService.class, "");
            if (localObject != null) {
              ((IEarlyDownloadService)localObject).onServerResp(paramObject);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public void a(String paramString, int paramInt, ArrayList<QQOperationViopTipTask> paramArrayList)
  {
    Object localObject3;
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("receive task, uin =");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" uinType=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("QQOperateVoIP", 4, ((StringBuilder)localObject1).toString());
      localObject1 = paramArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (QQOperationViopTipTask)((Iterator)localObject1).next();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("receive task, taskid=");
        ((StringBuilder)localObject3).append(((QQOperationViopTipTask)localObject2).taskid);
        QLog.d("QQOperateVoIP", 4, ((StringBuilder)localObject3).toString());
      }
    }
    Object localObject1 = new OperateVoipTipsInfo();
    ((OperateVoipTipsInfo)localObject1).uin = paramString;
    ((OperateVoipTipsInfo)localObject1).uinType = paramInt;
    ((OperateVoipTipsInfo)localObject1).taskList = paramArrayList;
    Object localObject2 = QQOperateManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localObject3 = ((QQOperateManager)localObject2).a(((QQOperationViopTipTask)paramArrayList.next()).taskid);
      if (localObject3 == null)
      {
        ConfigServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      QQOperationVoipTipsTaskExcuteRecord localQQOperationVoipTipsTaskExcuteRecord = new QQOperationVoipTipsTaskExcuteRecord();
      localQQOperationVoipTipsTaskExcuteRecord.taskid = ((QQOperationViopTipTask)localObject3).taskid;
      localQQOperationVoipTipsTaskExcuteRecord.tipType = ((QQOperationViopTipTask)localObject3).tipType;
      localQQOperationVoipTipsTaskExcuteRecord.uin = paramString;
      localQQOperationVoipTipsTaskExcuteRecord.uinType = paramInt;
      localQQOperationVoipTipsTaskExcuteRecord.count = 1;
      localQQOperationVoipTipsTaskExcuteRecord.time = System.currentTimeMillis();
      ((QQOperateManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localQQOperationVoipTipsTaskExcuteRecord);
    }
    notifyUI(8, true, localObject1);
  }
  
  public void a(String paramString, int paramInt, ArrayList<QQOperationRequestTaskInfo> paramArrayList, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      Long.parseLong(paramString);
      MobileTips.MobileTipsPkg localMobileTipsPkg = new MobileTips.MobileTipsPkg();
      int i;
      if (paramInt == 3000) {
        i = 2;
      } else {
        i = 1;
      }
      localMobileTipsPkg.req.peer_type.set(i);
      localMobileTipsPkg.req.peer_uin.set(Long.parseLong(paramString));
      if (paramArrayList != null)
      {
        ArrayList localArrayList = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          QQOperationRequestTaskInfo localQQOperationRequestTaskInfo = (QQOperationRequestTaskInfo)paramArrayList.next();
          MobileTips.TaskInfo localTaskInfo = new MobileTips.TaskInfo();
          localTaskInfo.task_id.set(localQQOperationRequestTaskInfo.jdField_a_of_type_Int);
          localTaskInfo.msgcnt.set(localQQOperationRequestTaskInfo.jdField_b_of_type_Int);
          localTaskInfo.keywords.set(localQQOperationRequestTaskInfo.jdField_a_of_type_JavaUtilArrayList);
          localTaskInfo.setHasFlag(true);
          localArrayList.add(localTaskInfo);
        }
        localMobileTipsPkg.req.task_list.set(localArrayList);
      }
      localMobileTipsPkg.req.setHasFlag(true);
      localMobileTipsPkg.rsp.setHasFlag(true);
      localMobileTipsPkg.setHasFlag(true);
      paramArrayList = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "MobileTipsSvc.TipsReport");
      paramArrayList.extraData.putBoolean("isRetry", paramBoolean);
      paramArrayList.extraData.putString("chatuin", paramString);
      paramArrayList.extraData.putInt("chattype", paramInt);
      paramArrayList.putWupBuffer(localMobileTipsPkg.toByteArray());
      sendPbReq(paramArrayList);
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public void a(String paramString, File paramFile)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new ConfigHandler.9(this, paramString, paramFile));
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = ByteBuffer.allocate(13);
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    short s;
    if (paramBoolean) {
      s = 1;
    } else {
      s = 2;
    }
    ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-23463).putShort((short)2).putShort(s);
    localObject = makeOIDBPkg("OidbSvc.0x4ff_42073", 1279, 9, ((ByteBuffer)localObject).array());
    ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public boolean a()
  {
    boolean bool = Verify.b(BaseApplicationImpl.sApplication);
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkAuthIfNeccessary preCheck:");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("UpgradeController", 4, ((StringBuilder)localObject1).toString());
    }
    this.b = bool;
    if (bool) {
      return false;
    }
    Object localObject1 = null;
    try
    {
      localObject2 = ApkExternalInfoTool.a(new File(BaseApplicationImpl.sApplication.getPackageResourcePath()));
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label77:
      break label77;
    }
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkAuthIfNeccessary forCode:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("UpgradeController", 4, ((StringBuilder)localObject2).toString());
    }
    localObject2 = createToServiceMsg("MAAControl.CheckSinglePkgSig");
    ((ToServiceMsg)localObject2).extraData.putString("ac", (String)localObject1);
    ((ToServiceMsg)localObject2).extraData.putInt("mv", ApkUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()));
    ((ToServiceMsg)localObject2).extraData.putInt("sv", DeviceInfoUtil.a());
    send((ToServiceMsg)localObject2);
    return true;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = createToServiceMsg("MAAControl.GetSinglePkgSig");
    ((ToServiceMsg)localObject).extraData.putString("pn", paramString1);
    ((ToServiceMsg)localObject).extraData.putInt("vc", paramInt);
    ((ToServiceMsg)localObject).extraData.putString("rid", paramString2);
    ((ToServiceMsg)localObject).extraData.putInt("mv", ApkUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()));
    ((ToServiceMsg)localObject).extraData.putInt("sv", DeviceInfoUtil.a());
    send((ToServiceMsg)localObject);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAuthCode:");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", forPkg:");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("UpgradeController", 4, ((StringBuilder)localObject).toString());
    }
    return true;
  }
  
  public GetResourceReqInfo b()
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("k_voice_notify2_file_version", 0L);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateVoiceNotifyConfig => curVersion: ");
      ((StringBuilder)localObject).append(l);
      QLog.d("VoiceNotify", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new GetResourceReqInfo();
    ((GetResourceReqInfo)localObject).uiResID = 0L;
    ((GetResourceReqInfo)localObject).strPkgName = "QQVoiceNotifyConfig2_android_CI";
    ((GetResourceReqInfo)localObject).uiCurVer = l;
    ((GetResourceReqInfo)localObject).sResType = 2;
    ((GetResourceReqInfo)localObject).sLanType = 0;
    ((GetResourceReqInfo)localObject).sReqType = 1;
    return localObject;
  }
  
  public void b()
  {
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    if (localMqqHandler != null)
    {
      BannerManager.a().a(UpgradeBannerProcessor.jdField_a_of_type_Int, 0, null);
      localMqqHandler.sendEmptyMessage(1134019);
    }
    a(true, null);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramToServiceMsg.extraData;
    int j = 1;
    paramToServiceMsg.getBoolean("switch", true);
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
      {
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        int i = j;
        if (4 <= paramToServiceMsg.length)
        {
          paramToServiceMsg = String.valueOf(PkgTools.getLongData(paramToServiceMsg, 0));
          if (paramToServiceMsg != null)
          {
            i = j;
            if (paramToServiceMsg.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {}
          }
          else
          {
            i = 0;
          }
        }
        if ((i != 0) && (QLog.isDevelopLevel())) {
          QLog.d("ConfigHandler", 4, "toggle update value success");
        }
      }
    }
  }
  
  public boolean b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    boolean bool1 = ((SharedPreferences)localObject).getBoolean("has_auth_real_name_extendfriend", false);
    boolean bool2 = ((SharedPreferences)localObject).getBoolean("has_request_auth_real_name_extendfriend", false);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hasAuthRealName ");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(bool2);
      QLog.i("RealName", 2, ((StringBuilder)localObject).toString());
    }
    if (bool1) {
      return true;
    }
    localObject = makeOIDBPkg("OidbSvc.0x9ae_2", 2478, 10, new cmd0x9ae.ReqBody().toByteArray());
    ((ToServiceMsg)localObject).addAttribute("serviceType", Integer.valueOf(10));
    sendPbReq((ToServiceMsg)localObject);
    return !bool2;
  }
  
  public GetResourceReqInfo c()
  {
    long l = BaseApplicationImpl.getApplication().getSharedPreferences("qq_safe_jump_whitelist", 0).getLong("key_jump_whitelist_version", 0L);
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = "com.tencent.jumpCI";
    localGetResourceReqInfo.uiCurVer = l;
    localGetResourceReqInfo.sResType = 2;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    return localGetResourceReqInfo;
  }
  
  public void c()
  {
    UpgradeController.a().a(false);
    a(false, null);
  }
  
  public boolean c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    boolean bool1 = ((SharedPreferences)localObject).getBoolean("has_auth_real_name_av", false);
    boolean bool2 = ((SharedPreferences)localObject).getBoolean("has_request_auth_real_name_av", false);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hasAuthRealNameForAv ");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(bool2);
      QLog.i("RealName", 2, ((StringBuilder)localObject).toString());
    }
    if (bool1) {
      return true;
    }
    localObject = makeOIDBPkg("OidbSvc.0x9ae_2", 2478, 12, new cmd0x9ae.ReqBody().toByteArray());
    ((ToServiceMsg)localObject).addAttribute("serviceType", Integer.valueOf(12));
    sendPbReq((ToServiceMsg)localObject);
    return !bool2;
  }
  
  public GetResourceReqInfo d()
  {
    Object localObject = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER);
    if (localObject == null) {
      return null;
    }
    long l = ((StatusManager)localObject).a();
    localObject = new GetResourceReqInfo();
    ((GetResourceReqInfo)localObject).uiResID = 0L;
    ((GetResourceReqInfo)localObject).strPkgName = "rich_status_android";
    ((GetResourceReqInfo)localObject).uiCurVer = l;
    ((GetResourceReqInfo)localObject).sResType = 2;
    ((GetResourceReqInfo)localObject).sLanType = 0;
    ((GetResourceReqInfo)localObject).sReqType = 1;
    return localObject;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("upgrade_tip_count", 0).putLong("YELLOW_BAR_LAST_SHOW", 0L).putBoolean("AUTO_DOWNLOADED_IN_WIFI", false).remove("APPID_SHOULD_DOWNLOAD").commit();
    b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
  }
  
  public GetResourceReqInfo e()
  {
    ConditionSearchManager localConditionSearchManager = (ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
    if (localConditionSearchManager == null) {
      return null;
    }
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = "QQAddFriend.AdministrateRegion";
    localGetResourceReqInfo.uiCurVer = localConditionSearchManager.a(true);
    localGetResourceReqInfo.sResType = 2;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    return localGetResourceReqInfo;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigHandler", 2, "getPCActiveConfig");
    }
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(2095);
      localOIDBSSOPkg.uint32_service_type.set(0);
      Object localObject = ByteBuffer.allocate(6);
      ((ByteBuffer)localObject).putInt(Utils.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))).putShort((short)16);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = createToServiceMsg("OidbSvc.0x82f_0");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigHandler", 2, "getPCActiveConfig ex", localException);
      }
    }
  }
  
  public GetResourceReqInfo f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("QlinkResistTerrorist", 0);
    long l1 = ((SharedPreferences)localObject).getLong("SettingQlinkResistTerroristLastTime", 0L);
    l1 = MessageCache.a() - l1;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = ((IFMConfig)QRoute.api(IFMConfig.class)).getTAG();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("verifyResistTerrorist,qlinkdur[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (!((SharedPreferences)localObject).getString("SettingQlinkResistTerroristLastAccount", "0").equalsIgnoreCase(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i(((IFMConfig)QRoute.api(IFMConfig.class)).getTAG(), 2, "verifyResistTerrorist,change account!");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a();
    }
    else if (l1 > 86400L)
    {
      if (QLog.isColorLevel()) {
        QLog.i(((IFMConfig)QRoute.api(IFMConfig.class)).getTAG(), 2, "verifyResistTerrorist,durtime over one day!");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfigV2", 0);
    l1 = ((SharedPreferences)localObject).getLong("FMConfigUpdateLastTime", 0L);
    long l2 = MessageCache.a();
    if (QLog.isDevelopLevel()) {
      l1 = 0L;
    }
    l1 = l2 - l1;
    if (QLog.isColorLevel())
    {
      str = ((IFMConfig)QRoute.api(IFMConfig.class)).getTAG();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateConfig,durtime[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (l1 > 86400L)
    {
      l1 = ((SharedPreferences)localObject).getLong("FileOnlinePreviewVersionKey", 0L);
      if (QLog.isDevelopLevel()) {
        l1 = 0L;
      }
      localObject = new GetResourceReqInfo();
      ((GetResourceReqInfo)localObject).uiResID = 0L;
      ((GetResourceReqInfo)localObject).strPkgName = "FileOnlinePreviewConfigV2";
      ((GetResourceReqInfo)localObject).uiCurVer = l1;
      ((GetResourceReqInfo)localObject).sResType = 3;
      ((GetResourceReqInfo)localObject).sLanType = 0;
      ((GetResourceReqInfo)localObject).sReqType = 1;
      if (QLog.isColorLevel())
      {
        str = ((IFMConfig)QRoute.api(IFMConfig.class)).getTAG();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateConfig,durtime over one day!currentVersion[");
        localStringBuilder.append(l1);
        localStringBuilder.append("]");
        QLog.i(str, 2, localStringBuilder.toString());
      }
      return localObject;
    }
    return null;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("has_auth_real_name", false))
    {
      if (QLog.isColorLevel()) {
        QLog.i("RealName", 2, "has auth real name.");
      }
      return;
    }
    if (EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getApplication()) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("RealName", 2, "devlock status is 0.");
      }
      return;
    }
    ToServiceMsg localToServiceMsg = makeOIDBPkg("OidbSvc.0x9ae_2", 2478, 2, new cmd0x9ae.ReqBody().toByteArray());
    localToServiceMsg.addAttribute("serviceType", Integer.valueOf(2));
    sendPbReq(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.i("RealName", 2, "queryRealNameStatus");
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return ConfigObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if (QLog.isColorLevel())
    {
      String str = paramFromServiceMsg.getServiceCmd();
      int i = paramToServiceMsg.getAppSeq();
      if (paramObject != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      QLog.d("ConfigHandler", 2, String.format("ConfigHandler serviceCmd[%s], appseq[%s], data[%s]", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool1) }));
    }
    if ("ResourceConfig.GetResourceReq".equals(paramFromServiceMsg.getServiceCmd()))
    {
      a(paramToServiceMsg, paramObject);
      return;
    }
    if ("MobileTipsSvc.TipsReport".equals(paramFromServiceMsg.getServiceCmd()))
    {
      boolean bool2 = paramFromServiceMsg.isSuccess();
      bool1 = bool2;
      if (bool2)
      {
        paramToServiceMsg = new MobileTips.MobileTipsPkg();
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
        }
        if (paramToServiceMsg.rsp.result.get() == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
      }
      if (QLog.isDevelopLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("get voip_tips req ack rsp confighandler isSuccess ");
        paramToServiceMsg.append(bool1);
        QLog.d("QQOperateVoIP", 4, paramToServiceMsg.toString());
      }
    }
    else
    {
      if ("OidbSvc.0x82f_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("MAAControl.CheckSinglePkgSig".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("MAAControl.GetSinglePkgSig".equals(paramFromServiceMsg.getServiceCmd()))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9ae_2".equals(paramFromServiceMsg.getServiceCmd()))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4ff_42073".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5eb_42073".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(paramFromServiceMsg.getServiceCmd());
        QLog.d("Q.richstatus.xml", 2, paramToServiceMsg.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler
 * JD-Core Version:    0.7.0.1
 */