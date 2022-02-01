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
import com.tencent.mobileqq.activity.weather.WeatherManager;
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
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatManager;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
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
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper.NewApkInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.JumpFilterHelper;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
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
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public ConfigHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler$InstallSuccessCallback = new ConfigHandler.InstallSuccessCallback(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    int i = paramQQAppInterface.getPreferences().getInt("UPGRADE_TIPS_SHOW_COUNT", 0);
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "ConfigHandler.getUpgradeTipsShowCount:" + i);
    }
    return i;
  }
  
  public static UpgradeDetailWrapper.NewApkInfo a(UpgradeInfo paramUpgradeInfo)
  {
    if ((paramUpgradeInfo != null) && (paramUpgradeInfo.strProgressName != null))
    {
      paramUpgradeInfo = paramUpgradeInfo.strProgressName;
      if (paramUpgradeInfo != null)
      {
        String[] arrayOfString = paramUpgradeInfo.split("\\|");
        try
        {
          paramUpgradeInfo = new UpgradeDetailWrapper.NewApkInfo();
          return null;
        }
        catch (Exception paramUpgradeInfo)
        {
          try
          {
            paramUpgradeInfo.jdField_a_of_type_JavaLangString = arrayOfString[2];
            paramUpgradeInfo.b = arrayOfString[1];
            paramUpgradeInfo.jdField_a_of_type_Long = Long.parseLong(arrayOfString[0]);
            paramUpgradeInfo.jdField_a_of_type_Int = Integer.parseInt(arrayOfString[3]);
            return paramUpgradeInfo;
          }
          catch (Exception localException)
          {
            return paramUpgradeInfo;
          }
          paramUpgradeInfo = paramUpgradeInfo;
          return null;
        }
      }
    }
  }
  
  private static String a()
  {
    Date localDate = new Date();
    int i = localDate.getYear();
    int j = localDate.getMonth();
    int k = localDate.getDay();
    return i + ":" + j + ":" + k;
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
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "ConfigHandler.getUpgradeTipsUrl:" + paramInt);
    }
    Object localObject = paramQQAppInterface.getPreferences();
    paramQQAppInterface = ((SharedPreferences)localObject).getString("UPGRADE_TIPS_URL", null);
    if (paramQQAppInterface == null) {}
    do
    {
      long l1;
      long l2;
      long l3;
      do
      {
        return null;
        localObject = ((SharedPreferences)localObject).getString("UPGRADE_TIPS_URL_MARK", null);
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeController", 2, "ConfigHandler.getUpgradeTipsUrl:" + (String)localObject);
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        localObject = ((String)localObject).split(":");
        l1 = Long.parseLong(localObject[0]);
        l2 = Long.parseLong(localObject[1]);
        l3 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeController", 2, "ConfigHandler.getUpgradeTipsUrl:" + l3);
        }
      } while ((l2 < l1) || (l3 <= l1));
      if (l3 > l2) {
        return paramQQAppInterface;
      }
    } while (paramInt > 0);
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
    paramQQAppInterface = l1 + ":" + (l2 + l1);
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
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "ConfigHandler.onReceiverPCUpgradeMessage: " + str);
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
    if (paramGetResourceRespInfo.iResult != 0) {
      notifyUI(5, false, null);
    }
    AppShareID localAppShareID;
    do
    {
      return;
      localAppShareID = AppShareIDUtil.a(paramGetResourceRespInfo);
    } while (localAppShareID == null);
    if (QLog.isColorLevel()) {
      QLog.d("share_appid", 2, "parser share appid from resp info, result:  " + localAppShareID);
    }
    paramGetResourceRespInfo = (AppShareID)paramEntityManager.find(AppShareID.class, "strPkgName=?", new String[] { paramGetResourceRespInfo.strPkgName });
    if (paramGetResourceRespInfo == null)
    {
      paramEntityManager.persist(localAppShareID);
      if (QLog.isColorLevel()) {
        QLog.d("share_appid", 2, "Persist DB appid = " + localAppShareID.strPkgName);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a.a(localAppShareID.strPkgName, localAppShareID);
      a(localAppShareID.strResURLBig, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFileStreamPath(localAppShareID.strPkgName));
      notifyUI(5, true, localAppShareID);
      return;
      if (localAppShareID.uiNewVer != paramGetResourceRespInfo.uiNewVer)
      {
        paramEntityManager.remove(paramGetResourceRespInfo);
        paramEntityManager.persist(localAppShareID);
        if (QLog.isColorLevel()) {
          QLog.d("share_appid", 2, "Update DB appid = " + localAppShareID.strPkgName);
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("share_appid", 2, "Not need update DB appid = " + localAppShareID.strPkgName);
      }
    }
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
    if (paramGetResourceRespInfo == null) {}
    long l2;
    do
    {
      return;
      long l1 = JumpFilterHelper.a().a();
      l2 = paramGetResourceRespInfo.uiNewVer;
      if (QLog.isColorLevel()) {
        QLog.d("JumpWhiteList", 2, "handleJumpWhiteList currentVersion: " + l1 + ", serverVersion: " + l2 + ",iResult: " + paramGetResourceRespInfo.iResult + ", bigUrl: " + paramGetResourceRespInfo.strResURL_big);
      }
      if (l2 == l1) {
        break;
      }
      paramGetResourceRespInfo = paramGetResourceRespInfo.strResURL_big;
    } while (TextUtils.isEmpty(paramGetResourceRespInfo));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new ConfigHandler.1(this, paramGetResourceRespInfo, l2));
    return;
    ThreadManager.getFileThreadHandler().post(new ConfigHandler.2(this));
  }
  
  private void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    notifyUI(4, paramBoolean, paramUpgradeDetailWrapper);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences();
    boolean bool2 = false;
    paramQQAppInterface = paramQQAppInterface.getString("UPGRADE_TIPS_DAILY_STR", null);
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (a().equals(paramQQAppInterface)) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "ConfigHandler.isDailyShowTips:" + bool1 + "--> " + paramQQAppInterface);
    }
    return bool1;
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
    if (paramString == null) {
      return true;
    }
    boolean bool;
    if (("eggs_android_CI_4.7.1".equals(paramString)) && (!((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.aio_eggs.name(), paramLong)))
    {
      FileUtils.e(new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir(), "eggs_config.zip").getAbsolutePath());
      FileUtils.e(AioAnimationConfigHelper.b);
      FileUtils.e(AioAnimationConfigHelper.c);
      bool = false;
      AioAnimationConfigHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("k_eggs_file_version", 0L).commit();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigHandler", 2, "str=" + paramString + ", isFeatureSupport=" + bool);
      }
      return bool;
      bool = true;
    }
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
    String str = paramQQAppInterface.getString("UPGRADE_BANNER_URL", null);
    if ((str != null) && (paramInt > 0) && (str.equals(paramString))) {
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
    str = l1 + ":" + (l2 + l1);
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putString("UPGRADE_BANNER_URL_MARK", str);
    paramQQAppInterface.putString("UPGRADE_BANNER_URL", paramString);
    paramQQAppInterface.commit();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putBoolean("AUTO_DOWNLOADED_IN_WIFI", paramBoolean);
    paramQQAppInterface.commit();
    if (QLog.isColorLevel()) {
      QLog.d("preLoad_configServlet", 2, "is auto download : " + paramBoolean);
    }
  }
  
  private void b(UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    if ((paramUpgradeDetailWrapper == null) || (paramUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null)) {}
    UpgradeInfo localUpgradeInfo;
    label37:
    label344:
    label352:
    do
    {
      Object localObject1;
      do
      {
        return;
        localUpgradeInfo = paramUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo;
        int i;
        Object localObject2;
        if ((localUpgradeInfo.iUpgradeType > 0) && (localUpgradeInfo.bNewSwitch == 1))
        {
          i = 1;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (i == 0) {
            break label344;
          }
        }
        for (localObject1 = "1";; localObject1 = "0")
        {
          ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8004DA5", "0X8004DA5", 0, 0, (String)localObject1, "", UpgradeController.a(), "");
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
          localObject2 = ((SharedPreferences)localObject1).edit();
          if (((SharedPreferences)localObject1).getInt("upgrade_timeStamp", 0) < localUpgradeInfo.iNewTimeStamp) {
            ((SharedPreferences.Editor)localObject2).putInt("upgrade_timeStamp", localUpgradeInfo.iNewTimeStamp);
          }
          ((SharedPreferences.Editor)localObject2).commit();
          a(true, paramUpgradeDetailWrapper);
          if (QLog.isColorLevel()) {
            QLog.d("UpgradeConfigManager", 2, String.format("showUpgradeIfNecessary iActionType=%s iUpgradeType=%s", new Object[] { Integer.valueOf(localUpgradeInfo.iActionType), Integer.valueOf(localUpgradeInfo.iUpgradeType) }));
          }
          if (localUpgradeInfo.iActionType != 0) {
            break;
          }
          if (localUpgradeInfo.iUpgradeType != 1) {
            d();
          }
          if (localUpgradeInfo.iUpgradeType != 2) {
            break label352;
          }
          localObject1 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
          if ((localObject1 == null) || (((String)localObject1).equals("com.tencent.mobileqq.activity.UserguideActivity"))) {
            break;
          }
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("reason_for_upgrade", true);
          ((Intent)localObject1).putExtra("StrTitle", HardCodeUtil.a(2131702478));
          ((Intent)localObject1).putExtra("StrUpgradeDesc", HardCodeUtil.a(2131702481));
          ((Intent)localObject1).putExtra("StrUrl", localUpgradeInfo.strNewSoftwareURL);
          ((Intent)localObject1).putExtra(paramUpgradeDetailWrapper.getClass().getSimpleName(), paramUpgradeDetailWrapper);
          a((Intent)localObject1);
          return;
          i = 0;
          break label37;
        }
        if (localUpgradeInfo.iUpgradeType != 1) {
          break;
        }
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
        if ((localUpgradeInfo.iTipsType == 0) || (localUpgradeInfo.iTipsType == 2))
        {
          ((UpgradeController)localObject1).d(true);
          return;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      } while (localObject1 == null);
      ((MqqHandler)localObject1).obtainMessage(1134020, paramUpgradeDetailWrapper).sendToTarget();
      return;
    } while (localUpgradeInfo.iUpgradeType != 3);
    c(paramUpgradeDetailWrapper);
  }
  
  private void b(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramGetResourceRespInfo == null) {}
    WeatherManager localWeatherManager;
    long l1;
    do
    {
      long l2;
      do
      {
        return;
        localWeatherManager = (WeatherManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.WEATHER_MANAGER);
        l1 = paramGetResourceRespInfo.uiNewVer;
        l2 = localWeatherManager.a();
        if (QLog.isColorLevel()) {
          QLog.d("weatherManager", 2, "handleWeatherResources currentVersion: " + l2 + ", serverVersion: " + l1 + ",iResult: " + paramGetResourceRespInfo.iResult + ", bigUrl: " + paramGetResourceRespInfo.strResURL_big);
        }
      } while (l1 == l2);
      paramGetResourceRespInfo = paramGetResourceRespInfo.strResURL_big;
    } while (TextUtils.isEmpty(paramGetResourceRespInfo));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new ConfigHandler.3(this, paramGetResourceRespInfo, localWeatherManager, l1));
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
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool9 = false;
    boolean bool10 = false;
    boolean bool11 = false;
    boolean bool8 = false;
    boolean bool1;
    boolean bool2;
    boolean bool7;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("ConfigHandler", 2, "handleGetPCActiveConfig success=" + bool1);
      }
      bool2 = bool1;
      bool7 = bool9;
      if (bool1)
      {
        bool3 = bool1;
        bool4 = bool10;
        bool5 = bool1;
        bool6 = bool11;
      }
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          continue;
        }
        bool3 = bool1;
        bool4 = bool10;
        bool5 = bool1;
        bool6 = bool11;
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool3 = bool1;
        bool4 = bool10;
        bool5 = bool1;
        bool6 = bool11;
        if (QLog.isColorLevel())
        {
          bool3 = bool1;
          bool4 = bool10;
          bool5 = bool1;
          bool6 = bool11;
          QLog.d("ConfigHandler", 2, "handleGetPCActiveConfig result=" + bool1);
        }
        bool2 = bool1;
        bool7 = bool9;
        if (bool1)
        {
          bool2 = bool1;
          bool7 = bool9;
          bool3 = bool1;
          bool4 = bool10;
          bool5 = bool1;
          bool6 = bool11;
          if (paramFromServiceMsg.bytes_bodybuffer.has())
          {
            bool2 = bool1;
            bool7 = bool9;
            bool3 = bool1;
            bool4 = bool10;
            bool5 = bool1;
            bool6 = bool11;
            if (paramFromServiceMsg.bytes_bodybuffer.get() != null)
            {
              bool3 = bool1;
              bool4 = bool10;
              bool5 = bool1;
              bool6 = bool11;
              paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
              bool3 = bool1;
              bool4 = bool10;
              bool5 = bool1;
              bool6 = bool11;
              int i = paramFromServiceMsg.getShort();
              bool3 = bool1;
              bool4 = bool10;
              bool5 = bool1;
              bool6 = bool11;
              int j = paramFromServiceMsg.getShort();
              bool2 = bool1;
              bool7 = bool9;
              if (i == 16)
              {
                bool3 = bool1;
                bool4 = bool10;
                bool5 = bool1;
                bool6 = bool11;
                paramObject = new byte[j];
                bool3 = bool1;
                bool4 = bool10;
                bool5 = bool1;
                bool6 = bool11;
                paramFromServiceMsg.get(paramObject);
                bool2 = bool8;
                if ((paramObject[16] & 0x1) > 0) {
                  bool2 = true;
                }
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), paramToServiceMsg.getUin(), null, "pcactive_config", bool2);
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.openMsfPCActive(paramToServiceMsg.getUin(), "config", bool2);
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                QLog.d("ConfigHandler", 1, "PCActive opened: " + bool2 + " by config");
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                paramFromServiceMsg = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive");
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                paramFromServiceMsg.putExtra("configPCActive", bool2);
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                paramFromServiceMsg.putExtra("uin", paramToServiceMsg.getUin());
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramFromServiceMsg);
                bool7 = bool2;
                bool2 = bool1;
              }
            }
          }
        }
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        bool5 = bool3;
        bool6 = bool4;
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool5 = bool3;
        bool6 = bool4;
        QLog.d("ConfigHandler", 2, "handleGetPCActiveConfig ex", paramToServiceMsg);
        return;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ConfigHandler", 2, "handleGetPCActiveConfig result=" + bool5 + ";allow=" + bool6);
      }
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  private void c(GetResourceRespInfo paramGetResourceRespInfo)
  {
    com.tencent.mobileqq.filemanager.data.FMConstants.jdField_a_of_type_Boolean = true;
    if (paramGetResourceRespInfo.iResult == -2) {}
    while (paramGetResourceRespInfo.iResult == 0)
    {
      String str = paramGetResourceRespInfo.strResURL_big;
      if ((str != null) && (str.length() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new ConfigHandler.4(this, str, paramGetResourceRespInfo));
      }
      return;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = false;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool4;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool4 = true;
      if (bool4) {
        break label209;
      }
      paramToServiceMsg = null;
      paramFromServiceMsg = null;
      paramObject = null;
    }
    boolean bool2;
    label45:
    Object localObject4;
    label209:
    AccessRsp localAccessRsp;
    for (;;)
    {
      if (!bool4)
      {
        bool2 = true;
        QLog.d("UpgradeController", 1, "handleCheckAuthCode:" + bool4 + ", valid:" + bool2);
        this.b = bool2;
        if (!bool2)
        {
          BaseApplicationImpl.sApplication.getResources();
          localObject4 = new Intent();
          ((Intent)localObject4).putExtra("reason_for_checkAuth", true);
          ((Intent)localObject4).putExtra("StrTitle", (String)localObject3);
          ((Intent)localObject4).putExtra("StrUpgradeDesc", (String)localObject2);
          ((Intent)localObject4).putExtra("StrButton", (String)localObject1);
          ((Intent)localObject4).putExtra("StrClientUrl", paramFromServiceMsg);
          ((Intent)localObject4).putExtra("StrH5Url", paramToServiceMsg);
          ((Intent)localObject4).putExtra("StrCode", paramObject);
          a((Intent)localObject4);
        }
        notifyUI(11, bool4, Boolean.valueOf(bool2));
        return;
        bool4 = false;
        break;
        localAccessRsp = (AccessRsp)paramObject;
        if (localAccessRsp.ret != 0)
        {
          bool1 = true;
          paramToServiceMsg = null;
          paramFromServiceMsg = null;
          paramObject = null;
        }
        else
        {
          if ((localAccessRsp.body == null) || (localAccessRsp.body.length <= 0)) {
            break label692;
          }
        }
      }
    }
    for (;;)
    {
      boolean bool3;
      try
      {
        paramFromServiceMsg = new JceInputStream(localAccessRsp.body);
        paramToServiceMsg = new CheckSinglePkgSigRsp();
      }
      catch (Exception paramToServiceMsg)
      {
        String str;
        int i;
        paramToServiceMsg = null;
      }
      try
      {
        paramToServiceMsg.readFrom(paramFromServiceMsg);
        if ((paramToServiceMsg == null) || (paramToServiceMsg.ret != 0)) {
          break label638;
        }
        if (paramToServiceMsg.vtMarket == null) {
          break label686;
        }
        paramFromServiceMsg = paramToServiceMsg.vtMarket.iterator();
        bool1 = false;
        bool3 = bool1;
        if (paramFromServiceMsg.hasNext())
        {
          paramObject = (NoCheckMarket)paramFromServiceMsg.next();
          bool3 = bool1;
          if (TextUtils.isEmpty(paramObject.pkgName)) {
            break label631;
          }
          bool2 = bool1;
          if (!bool1) {
            bool2 = Verify.a(BaseApplicationImpl.sApplication, paramObject.pkgName, paramObject.versionCode, paramObject.signatureMd5);
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("UpgradeController", 4, "handleCheckAuthCode NoCheckMarket:" + paramObject.pkgName + ", " + paramObject.versionCode);
          }
          bool3 = bool2;
          if (!bool2) {
            break label631;
          }
          bool3 = bool2;
          if (QLog.isDevelopLevel())
          {
            QLog.d("UpgradeController", 4, "handleCheckAuthCode NoCheckMarket:" + bool2);
            bool3 = bool2;
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        break label628;
        paramToServiceMsg = null;
        paramFromServiceMsg = null;
        paramObject = null;
        continue;
        bool3 = false;
        continue;
      }
      str = paramToServiceMsg.pkgSig;
      localObject4 = paramToServiceMsg.tmastUrl;
      paramFromServiceMsg = paramToServiceMsg.pageUrl;
      i = paramToServiceMsg.sigVersionCode;
      localObject2 = paramFromServiceMsg + "#versioncode=" + i;
      if (QLog.isDevelopLevel()) {
        QLog.d("UpgradeController", 4, "handleCheckAuthCode TargetCode:" + str + ", " + i);
      }
      if (localAccessRsp.tips != null)
      {
        paramObject = localAccessRsp.tips.title;
        paramFromServiceMsg = localAccessRsp.tips.content;
        paramToServiceMsg = localAccessRsp.tips.button;
        localObject1 = paramToServiceMsg;
        bool1 = bool3;
        paramToServiceMsg = (ToServiceMsg)localObject2;
        localObject2 = paramFromServiceMsg;
        localObject3 = paramObject;
        paramFromServiceMsg = (FromServiceMsg)localObject4;
        paramObject = str;
        break;
        label628:
        continue;
        label631:
        bool1 = bool3;
        continue;
        label638:
        bool1 = true;
        paramToServiceMsg = null;
        paramFromServiceMsg = null;
        paramObject = null;
        break;
        bool2 = bool1;
        if (!bool1) {
          break label45;
        }
        Verify.a(BaseApplicationImpl.sApplication);
        bool2 = bool1;
        break label45;
      }
      label686:
      label692:
      paramToServiceMsg = null;
    }
  }
  
  private void d(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramGetResourceRespInfo.iResult != 0) {
      notifyUI(1, false, paramGetResourceRespInfo);
    }
    String str;
    do
    {
      return;
      str = paramGetResourceRespInfo.strResURL_big;
    } while ((str == null) || (str.length() <= 0));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new ConfigHandler.5(this, str, paramGetResourceRespInfo));
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    String str2 = paramToServiceMsg.extraData.getString("rid");
    String str1 = "";
    int i;
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      if (i != 0) {
        break label136;
      }
      bool1 = bool2;
      paramToServiceMsg = str1;
    }
    label136:
    label178:
    do
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("UpgradeController", 4, "handleGetAuthCode:" + bool1 + ", " + str2 + ", code:" + paramToServiceMsg);
        }
        notifyUI(10, bool1, new Pair(paramToServiceMsg, str2));
        UpgradeController.a().a(bool1, str2, paramToServiceMsg);
        return;
        i = 0;
        break;
        paramFromServiceMsg = (AccessRsp)paramObject;
        i = paramFromServiceMsg.ret;
        if (i != 1) {
          break label178;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("UpgradeController", 4, "handleGetAuthCode not supported");
        }
        paramToServiceMsg = "";
        bool1 = true;
      }
      paramToServiceMsg = str1;
      bool1 = bool2;
    } while (i != 0);
    if ((paramFromServiceMsg.body != null) && (paramFromServiceMsg.body.length > 0)) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = new JceInputStream(paramFromServiceMsg.body);
        paramFromServiceMsg = new GetSinglePkgSigRsp();
      }
      catch (Exception paramToServiceMsg)
      {
        try
        {
          paramFromServiceMsg.readFrom(paramToServiceMsg);
          paramToServiceMsg = str1;
          bool1 = bool2;
          if (paramFromServiceMsg == null) {
            break;
          }
          paramToServiceMsg = str1;
          bool1 = bool2;
          if (paramFromServiceMsg.ret != 0) {
            break;
          }
          paramToServiceMsg = paramFromServiceMsg.pkgSig;
          bool1 = true;
          break;
          paramToServiceMsg = paramToServiceMsg;
          paramFromServiceMsg = null;
          continue;
        }
        catch (Exception paramToServiceMsg)
        {
          continue;
        }
      }
      paramFromServiceMsg = null;
    }
  }
  
  private void e(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "ConfigHandler.handleUpdateStatusActions, result is " + paramGetResourceRespInfo.iResult + ", server version:" + paramGetResourceRespInfo.uiNewVer);
    }
    if (paramGetResourceRespInfo.iResult == -2) {
      notifyUI(7, true, Integer.valueOf(100));
    }
    StatusManager localStatusManager;
    do
    {
      return;
      if (paramGetResourceRespInfo.iResult != 0)
      {
        notifyUI(7, false, Integer.valueOf(-1));
        return;
      }
      localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER);
    } while (localStatusManager == null);
    if (!localStatusManager.a(paramGetResourceRespInfo.uiNewVer))
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new ConfigHandler.6(this, str, localStatusManager, paramGetResourceRespInfo));
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg == null) || (paramObject == null)) {}
    for (;;)
    {
      return;
      int i = ((Integer)paramToServiceMsg.getAttribute("serviceType", Integer.valueOf(2))).intValue();
      paramToServiceMsg = new cmd0x9ae.RspBody();
      int j = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      boolean bool1;
      label68:
      boolean bool2;
      if (j == 0)
      {
        if (paramToServiceMsg.bool_has_been_authenticated.has())
        {
          bool1 = paramToServiceMsg.bool_has_been_authenticated.get();
          if (!paramToServiceMsg.bool_need_auth_tips.has()) {
            break label321;
          }
          bool2 = paramToServiceMsg.bool_need_auth_tips.get();
          label87:
          if (!paramToServiceMsg.msg_auth_tips.has()) {
            break label327;
          }
          paramObject = (cmd0x9ae.AuthTips)paramToServiceMsg.msg_auth_tips.get();
          label108:
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("has_auth_real_name", bool1).commit();
          if (i != 2) {
            break label438;
          }
          if (paramObject == null) {
            break label353;
          }
          if (!paramObject.string_tips_title.has()) {
            break label332;
          }
          paramToServiceMsg = paramObject.string_tips_title.get();
          label164:
          if (!paramObject.string_tips_context.has()) {
            break label339;
          }
          paramFromServiceMsg = paramObject.string_tips_context.get();
          label182:
          if (!paramObject.string_tips_action_url.has()) {
            break label346;
          }
        }
        label321:
        label327:
        label332:
        label339:
        label346:
        for (paramObject = paramObject.string_tips_action_url.get();; paramObject = "")
        {
          notifyUI(13, true, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramToServiceMsg, paramFromServiceMsg, paramObject });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("RealName", 2, "handleGetRealNameStatus value is: " + bool1 + "|" + bool2 + "|" + paramToServiceMsg + "|" + paramFromServiceMsg + "|" + paramObject);
          return;
          bool1 = true;
          break label68;
          bool2 = false;
          break label87;
          paramObject = null;
          break label108;
          paramToServiceMsg = "";
          break label164;
          paramFromServiceMsg = "";
          break label182;
        }
        label353:
        QLog.i("RealName", 2, "handleGetRealNameStatus, authTips is null " + bool1 + " " + bool2);
      }
      while (QLog.isColorLevel())
      {
        QLog.i("RealName", 2, "handleGetRealNameStatus, result is: " + j + " serviceType:" + i);
        return;
        label438:
        if (i == 10)
        {
          Object localObject = "";
          paramFromServiceMsg = "";
          paramToServiceMsg = "";
          if (paramObject != null)
          {
            if (!paramObject.string_tips_title.has()) {
              break label709;
            }
            paramFromServiceMsg = paramObject.string_tips_title.get();
            label480:
            if (!paramObject.string_tips_context.has()) {
              break label716;
            }
            paramToServiceMsg = paramObject.string_tips_context.get();
            label498:
            if (!paramObject.string_tips_action_url.has()) {
              break label723;
            }
          }
          label709:
          label716:
          label723:
          for (paramObject = paramObject.string_tips_action_url.get();; paramObject = "")
          {
            localObject = paramFromServiceMsg;
            paramFromServiceMsg = paramToServiceMsg;
            paramToServiceMsg = paramObject;
            paramObject = (ExtendFriendLimitChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
            paramObject.a(bool1);
            paramObject.a(bool2, (String)localObject, paramFromServiceMsg, paramToServiceMsg);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("has_auth_real_name_extendfriend", bool1).putBoolean("has_request_auth_real_name_extendfriend", true).commit();
            notifyUI(14, true, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), localObject, paramFromServiceMsg, paramToServiceMsg });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("RealName", 2, "handleGetRealNameStatus value is: " + bool1 + "|" + bool2 + "|" + (String)localObject + "|" + paramFromServiceMsg + "|" + paramToServiceMsg);
            break;
            paramFromServiceMsg = "";
            break label480;
            paramToServiceMsg = "";
            break label498;
          }
        }
        if (i == 12)
        {
          if (QLog.isColorLevel()) {
            QLog.i("RealName", 2, "handleGetRealNameStatus type=12, value is: " + bool1);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("has_auth_real_name_av", bool1).putBoolean("has_request_auth_real_name_av", true).commit();
          notifyUI(15, true, new Object[] { Boolean.valueOf(bool1) });
          continue;
          if (i == 10) {
            notifyUI(14, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false), "", "", "" });
          } else if (i == 12) {
            notifyUI(15, false, new Object[] { Boolean.valueOf(false) });
          }
        }
      }
    }
  }
  
  private void f(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramGetResourceRespInfo == null) {}
    long l2;
    String str;
    do
    {
      return;
      long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("k_eggs_file_version", 0L);
      l2 = paramGetResourceRespInfo.uiNewVer;
      if (QLog.isColorLevel()) {
        QLog.d("eggs", 2, "handleUpdateEggsActions currentVersion: " + l1 + ", serverVersion: " + l2 + ",iResult: " + paramGetResourceRespInfo.iResult + ", bigUrl: " + paramGetResourceRespInfo.strResURL_big);
      }
      if (l2 == l1) {
        break;
      }
      str = paramGetResourceRespInfo.strResURL_big;
    } while (TextUtils.isEmpty(str));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new ConfigHandler.7(this, paramGetResourceRespInfo, str, l2));
    return;
    ThreadManager.getFileThreadHandler().post(new ConfigHandler.8(this, paramGetResourceRespInfo));
  }
  
  public int a(ArrayList<GetResourceReqInfo> paramArrayList, GetResourceReqInfo... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(4);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      for (bool1 = false;; bool1 = bool2)
      {
        bool2 = bool1;
        if (!paramArrayList.hasNext()) {
          break;
        }
        GetResourceReqInfo localGetResourceReqInfo = (GetResourceReqInfo)paramArrayList.next();
        bool2 = bool1;
        if (localGetResourceReqInfo != null)
        {
          if (localGetResourceReqInfo.strPkgName.equals("QQAddFriend.AdministrateRegion")) {
            bool1 = true;
          }
          localArrayList.add(localGetResourceReqInfo);
          bool2 = bool1;
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
    if (QLog.isColorLevel()) {
      QLog.d("eggs", 2, "getEggsInfo curVersion: " + l);
    }
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = "eggs_android_CI_4.7.1";
    localGetResourceReqInfo.uiCurVer = l;
    localGetResourceReqInfo.sResType = 2;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    return localGetResourceReqInfo;
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
      while (!QLog.isColorLevel()) {}
      QLog.w("ConfigHandler", 2, "send_oidb_0x5eb_42073 error", localException);
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
  
  /* Error */
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_3
    //   1: checkcast 779	[B
    //   4: checkcast 779	[B
    //   7: astore 7
    //   9: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +56 -> 68
    //   15: new 64	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 1300
    //   25: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_2
    //   29: invokevirtual 772	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   32: invokevirtual 483	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   35: ldc_w 955
    //   38: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: astore_1
    //   42: aload 7
    //   44: ifnull +347 -> 391
    //   47: aload 7
    //   49: arraylength
    //   50: istore 4
    //   52: ldc_w 553
    //   55: iconst_2
    //   56: aload_1
    //   57: iload 4
    //   59: invokevirtual 74	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: invokestatic 673	com/tencent/mobileqq/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/upgrade/UpgradeController;
    //   71: astore_3
    //   72: aload_3
    //   73: invokevirtual 1303	com/tencent/mobileqq/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   76: astore_1
    //   77: aload_2
    //   78: ifnull +337 -> 415
    //   81: aload_2
    //   82: invokevirtual 772	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   85: ifeq +330 -> 415
    //   88: aload 7
    //   90: ifnull +325 -> 415
    //   93: new 776	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   96: dup
    //   97: invokespecial 777	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   100: astore_2
    //   101: aload_2
    //   102: aload 7
    //   104: invokevirtual 780	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   107: pop
    //   108: aload_2
    //   109: getfield 784	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   112: invokevirtual 1304	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   115: ifeq +300 -> 415
    //   118: aload_2
    //   119: getfield 784	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   122: invokevirtual 788	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   125: ifne +290 -> 415
    //   128: new 1306	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody
    //   131: dup
    //   132: invokespecial 1307	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:<init>	()V
    //   135: astore 7
    //   137: aload 7
    //   139: aload_2
    //   140: getfield 793	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   143: invokevirtual 331	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   146: invokevirtual 802	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   149: invokevirtual 1308	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   152: pop
    //   153: aload 7
    //   155: getfield 1312	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   158: invokevirtual 1315	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   161: ifle +254 -> 415
    //   164: aload 7
    //   166: getfield 1312	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   169: iconst_0
    //   170: invokevirtual 1318	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   173: checkcast 1320	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   176: getfield 1321	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_preload_disable_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   179: invokevirtual 788	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   182: istore 4
    //   184: aload_1
    //   185: monitorenter
    //   186: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +31 -> 220
    //   192: ldc_w 615
    //   195: iconst_2
    //   196: new 64	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 1323
    //   206: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: iload 4
    //   211: invokevirtual 74	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload_1
    //   221: iconst_1
    //   222: putfield 1324	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Boolean	Z
    //   225: iload 4
    //   227: iconst_1
    //   228: if_icmpne +193 -> 421
    //   231: iconst_1
    //   232: istore 5
    //   234: aload_1
    //   235: getfield 1326	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   238: ifnull +212 -> 450
    //   241: iload 4
    //   243: ifne +244 -> 487
    //   246: aload_1
    //   247: getfield 1327	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Int	I
    //   250: iconst_1
    //   251: if_icmpne +185 -> 436
    //   254: iconst_1
    //   255: istore 5
    //   257: iload 5
    //   259: istore 6
    //   261: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq +35 -> 299
    //   267: ldc_w 615
    //   270: iconst_2
    //   271: new 64	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   278: ldc_w 1329
    //   281: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: iload 5
    //   286: invokevirtual 483	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   289: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: iload 5
    //   297: istore 6
    //   299: aload_0
    //   300: getfield 39	com/tencent/mobileqq/app/ConfigHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   303: iload 6
    //   305: invokestatic 1331	com/tencent/mobileqq/app/ConfigHandler:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   308: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   311: ifeq +13 -> 324
    //   314: ldc_w 565
    //   317: iconst_2
    //   318: ldc_w 1333
    //   321: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: aload_1
    //   325: getfield 1326	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   328: ifnull +135 -> 463
    //   331: aload_1
    //   332: getfield 735	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig	Lcom/tencent/mobileqq/upgrade/NewUpgradeConfig;
    //   335: ifnull +128 -> 463
    //   338: aload_1
    //   339: getfield 1326	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   342: getfield 586	protocol/KQQConfig/UpgradeInfo:iUpgradeType	I
    //   345: ifeq +118 -> 463
    //   348: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   351: ifeq +13 -> 364
    //   354: ldc_w 565
    //   357: iconst_2
    //   358: ldc_w 1335
    //   361: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: aload_0
    //   365: getfield 39	com/tencent/mobileqq/app/ConfigHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   368: getstatic 1340	com/tencent/mobileqq/app/BusinessHandlerFactory:CONFIG_HANDLER	Ljava/lang/String;
    //   371: invokevirtual 1344	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   374: checkcast 2	com/tencent/mobileqq/app/ConfigHandler
    //   377: astore_2
    //   378: aload_3
    //   379: aload_1
    //   380: getfield 1326	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   383: aload_2
    //   384: invokevirtual 1347	com/tencent/mobileqq/upgrade/UpgradeController:a	(Lprotocol/KQQConfig/UpgradeInfo;Lcom/tencent/mobileqq/upgrade/UpgradeController$OnHandleUpgradeFinishListener;)Z
    //   387: pop
    //   388: aload_1
    //   389: monitorexit
    //   390: return
    //   391: iconst_m1
    //   392: istore 4
    //   394: goto -342 -> 52
    //   397: astore_2
    //   398: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   401: ifeq +14 -> 415
    //   404: ldc_w 553
    //   407: iconst_2
    //   408: ldc_w 596
    //   411: aload_2
    //   412: invokestatic 855	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   415: iconst_0
    //   416: istore 4
    //   418: goto -234 -> 184
    //   421: iload 4
    //   423: iconst_2
    //   424: if_icmpne +66 -> 490
    //   427: invokestatic 673	com/tencent/mobileqq/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/upgrade/UpgradeController;
    //   430: invokevirtual 1348	com/tencent/mobileqq/upgrade/UpgradeController:b	()V
    //   433: goto +57 -> 490
    //   436: aload_1
    //   437: getfield 1327	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Int	I
    //   440: iconst_2
    //   441: if_icmpne +46 -> 487
    //   444: iconst_0
    //   445: istore 5
    //   447: goto -190 -> 257
    //   450: aload_1
    //   451: iload 4
    //   453: putfield 1350	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_Int	I
    //   456: iload 5
    //   458: istore 6
    //   460: goto -161 -> 299
    //   463: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   466: ifeq -78 -> 388
    //   469: ldc_w 565
    //   472: iconst_2
    //   473: ldc_w 1352
    //   476: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   479: goto -91 -> 388
    //   482: astore_2
    //   483: aload_1
    //   484: monitorexit
    //   485: aload_2
    //   486: athrow
    //   487: goto -230 -> 257
    //   490: iconst_0
    //   491: istore 5
    //   493: goto -259 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	496	0	this	ConfigHandler
    //   0	496	1	paramToServiceMsg	ToServiceMsg
    //   0	496	2	paramFromServiceMsg	FromServiceMsg
    //   0	496	3	paramObject	Object
    //   50	402	4	i	int
    //   232	260	5	bool1	boolean
    //   259	200	6	bool2	boolean
    //   7	158	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   93	184	397	java/lang/Throwable
    //   186	220	482	finally
    //   220	225	482	finally
    //   234	241	482	finally
    //   246	254	482	finally
    //   261	295	482	finally
    //   299	324	482	finally
    //   324	364	482	finally
    //   364	388	482	finally
    //   388	390	482	finally
    //   427	433	482	finally
    //   436	444	482	finally
    //   450	456	482	finally
    //   463	479	482	finally
    //   483	485	482	finally
  }
  
  public void a(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    if (paramObject == null) {
      if (paramToServiceMsg.extraData.getBoolean("reqRegionConfig")) {
        ((ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).a(null);
      }
    }
    do
    {
      return;
      paramToServiceMsg = ((GetResourceResp)paramObject).vecResRespInfo;
    } while ((paramToServiceMsg == null) || (paramToServiceMsg.size() <= 0));
    int i = 0;
    label56:
    if (i < paramToServiceMsg.size())
    {
      paramObject = (GetResourceRespInfo)paramToServiceMsg.get(i);
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloadTrace", 2, String.format("onReceive_GetResourceRespInfo. \r\n%s", new Object[] { paramObject }));
      }
      if (paramObject.sResType != 3) {
        break label141;
      }
      if (!"FileOnlinePreviewConfigV2".equals(paramObject.strPkgName)) {
        break label133;
      }
      c(paramObject);
    }
    for (;;)
    {
      i += 1;
      break label56;
      break;
      label133:
      d(paramObject);
      continue;
      label141:
      if (paramObject.sResType == 0)
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
          else if ("eggs_android_CI_4.7.1".equals(paramObject.strPkgName))
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
          localObject = (EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
          if (localObject != null) {
            ((EarlyDownloadManager)localObject).a(paramObject);
          }
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt, ArrayList<QQOperationViopTipTask> paramArrayList)
  {
    if (QLog.isDevelopLevel())
    {
      QLog.d("QQOperateVoIP", 4, "receive task, uin =" + paramString + " uinType=" + paramInt);
      localObject1 = paramArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (QQOperationViopTipTask)((Iterator)localObject1).next();
        QLog.d("QQOperateVoIP", 4, "receive task, taskid=" + ((QQOperationViopTipTask)localObject2).taskid);
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
      QQOperationViopTipTask localQQOperationViopTipTask = ((QQOperateManager)localObject2).a(((QQOperationViopTipTask)paramArrayList.next()).taskid);
      if (localQQOperationViopTipTask == null)
      {
        ConfigServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      QQOperationVoipTipsTaskExcuteRecord localQQOperationVoipTipsTaskExcuteRecord = new QQOperationVoipTipsTaskExcuteRecord();
      localQQOperationVoipTipsTaskExcuteRecord.taskid = localQQOperationViopTipTask.taskid;
      localQQOperationVoipTipsTaskExcuteRecord.tipType = localQQOperationViopTipTask.tipType;
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
    for (;;)
    {
      try
      {
        Long.parseLong(paramString);
        MobileTips.MobileTipsPkg localMobileTipsPkg = new MobileTips.MobileTipsPkg();
        if (paramInt == 3000)
        {
          i = 2;
          localMobileTipsPkg.req.peer_type.set(i);
          localMobileTipsPkg.req.peer_uin.set(Long.parseLong(paramString));
          if (paramArrayList != null)
          {
            ArrayList localArrayList = new ArrayList();
            paramArrayList = paramArrayList.iterator();
            if (paramArrayList.hasNext())
            {
              QQOperationRequestTaskInfo localQQOperationRequestTaskInfo = (QQOperationRequestTaskInfo)paramArrayList.next();
              MobileTips.TaskInfo localTaskInfo = new MobileTips.TaskInfo();
              localTaskInfo.task_id.set(localQQOperationRequestTaskInfo.jdField_a_of_type_Int);
              localTaskInfo.msgcnt.set(localQQOperationRequestTaskInfo.jdField_b_of_type_Int);
              localTaskInfo.keywords.set(localQQOperationRequestTaskInfo.jdField_a_of_type_JavaUtilArrayList);
              localTaskInfo.setHasFlag(true);
              localArrayList.add(localTaskInfo);
              continue;
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
      }
      catch (NumberFormatException paramString)
      {
        return;
      }
      int i = 1;
    }
  }
  
  public void a(String paramString, File paramFile)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new ConfigHandler.9(this, paramString, paramFile));
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = ByteBuffer.allocate(13);
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (paramBoolean) {}
    for (short s = 1;; s = 2)
    {
      ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-23463).putShort((short)2).putShort(s);
      localObject = makeOIDBPkg("OidbSvc.0x4ff_42073", 1279, 9, ((ByteBuffer)localObject).array());
      ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
  }
  
  public boolean a()
  {
    boolean bool = Verify.b(BaseApplicationImpl.sApplication);
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeController", 4, "checkAuthIfNeccessary preCheck:" + bool);
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
      label71:
      break label71;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeController", 4, "checkAuthIfNeccessary forCode:" + localObject1);
    }
    localObject2 = createToServiceMsg("MAAControl.CheckSinglePkgSig");
    ((ToServiceMsg)localObject2).extraData.putString("ac", localObject1);
    ((ToServiceMsg)localObject2).extraData.putInt("mv", ApkUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()));
    ((ToServiceMsg)localObject2).extraData.putInt("sv", DeviceInfoUtil.a());
    send((ToServiceMsg)localObject2);
    return true;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("MAAControl.GetSinglePkgSig");
    localToServiceMsg.extraData.putString("pn", paramString1);
    localToServiceMsg.extraData.putInt("vc", paramInt);
    localToServiceMsg.extraData.putString("rid", paramString2);
    localToServiceMsg.extraData.putInt("mv", ApkUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()));
    localToServiceMsg.extraData.putInt("sv", DeviceInfoUtil.a());
    send(localToServiceMsg);
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeController", 4, "getAuthCode:" + paramString2 + ", forPkg:" + paramString1);
    }
    return true;
  }
  
  public GetResourceReqInfo b()
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("k_voice_notify2_file_version", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("VoiceNotify", 2, "updateVoiceNotifyConfig => curVersion: " + l);
    }
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = "QQVoiceNotifyConfig2_android_CI";
    localGetResourceReqInfo.uiCurVer = l;
    localGetResourceReqInfo.sResType = 2;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    return localGetResourceReqInfo;
  }
  
  public void b()
  {
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    if (localMqqHandler != null)
    {
      BannerManager.a().a(15, 0, null);
      localMqqHandler.sendEmptyMessage(1134019);
    }
    a(true, null);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg.extraData.getBoolean("switch", true);
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000)) {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg.printStackTrace();
        continue;
        int i = 1;
      }
    }
    if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
    {
      paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      if (4 > paramToServiceMsg.length) {
        break label169;
      }
      paramToServiceMsg = String.valueOf(PkgTools.getLongData(paramToServiceMsg, 0));
      if ((paramToServiceMsg != null) && (paramToServiceMsg.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))) {
        break label169;
      }
      i = 0;
      if ((i != 0) && (QLog.isDevelopLevel())) {
        QLog.d("ConfigHandler", 4, "toggle update value success");
      }
    }
  }
  
  public boolean b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    boolean bool1 = ((SharedPreferences)localObject).getBoolean("has_auth_real_name_extendfriend", false);
    boolean bool2 = ((SharedPreferences)localObject).getBoolean("has_request_auth_real_name_extendfriend", false);
    if (QLog.isColorLevel()) {
      QLog.i("RealName", 2, "hasAuthRealName " + bool1 + " " + bool2);
    }
    if (bool1) {}
    do
    {
      return true;
      localObject = makeOIDBPkg("OidbSvc.0x9ae_2", 2478, 10, new cmd0x9ae.ReqBody().toByteArray());
      ((ToServiceMsg)localObject).addAttribute("serviceType", Integer.valueOf(10));
      sendPbReq((ToServiceMsg)localObject);
    } while (!bool2);
    return false;
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
    if (QLog.isColorLevel()) {
      QLog.i("RealName", 2, "hasAuthRealNameForAv " + bool1 + " " + bool2);
    }
    if (bool1) {}
    do
    {
      return true;
      localObject = makeOIDBPkg("OidbSvc.0x9ae_2", 2478, 12, new cmd0x9ae.ReqBody().toByteArray());
      ((ToServiceMsg)localObject).addAttribute("serviceType", Integer.valueOf(12));
      sendPbReq((ToServiceMsg)localObject);
    } while (!bool2);
    return false;
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
      while (!QLog.isColorLevel()) {}
      QLog.d("ConfigHandler", 2, "getPCActiveConfig ex", localException);
    }
  }
  
  public GetResourceReqInfo f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("QlinkResistTerrorist", 0);
    long l1 = ((SharedPreferences)localObject).getLong("SettingQlinkResistTerroristLastTime", 0L);
    l1 = MessageCache.a() - l1;
    if (QLog.isColorLevel()) {
      QLog.i(((IFMConfig)QRoute.api(IFMConfig.class)).getTAG(), 2, "verifyResistTerrorist,qlinkdur[" + l1 + "]");
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (!((SharedPreferences)localObject).getString("SettingQlinkResistTerroristLastAccount", "0").equalsIgnoreCase(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i(((IFMConfig)QRoute.api(IFMConfig.class)).getTAG(), 2, "verifyResistTerrorist,change account!");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfigV2", 0);
      l1 = ((SharedPreferences)localObject).getLong("FMConfigUpdateLastTime", 0L);
      long l2 = MessageCache.a();
      if (QLog.isDevelopLevel()) {
        l1 = 0L;
      }
      l1 = l2 - l1;
      if (QLog.isColorLevel()) {
        QLog.i(((IFMConfig)QRoute.api(IFMConfig.class)).getTAG(), 2, "updateConfig,durtime[" + l1 + "]");
      }
      if (l1 <= 86400L) {
        break label421;
      }
      l1 = ((SharedPreferences)localObject).getLong("FileOnlinePreviewVersionKey", 0L);
      if (!QLog.isDevelopLevel()) {
        break label423;
      }
      l1 = 0L;
    }
    label421:
    label423:
    for (;;)
    {
      localObject = new GetResourceReqInfo();
      ((GetResourceReqInfo)localObject).uiResID = 0L;
      ((GetResourceReqInfo)localObject).strPkgName = "FileOnlinePreviewConfigV2";
      ((GetResourceReqInfo)localObject).uiCurVer = l1;
      ((GetResourceReqInfo)localObject).sResType = 3;
      ((GetResourceReqInfo)localObject).sLanType = 0;
      ((GetResourceReqInfo)localObject).sReqType = 1;
      if (QLog.isColorLevel()) {
        QLog.i(((IFMConfig)QRoute.api(IFMConfig.class)).getTAG(), 2, "updateConfig,durtime over one day!currentVersion[" + l1 + "]");
      }
      return localObject;
      if (l1 <= 86400L) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i(((IFMConfig)QRoute.api(IFMConfig.class)).getTAG(), 2, "verifyResistTerrorist,durtime over one day!");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a();
      break;
      return null;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("has_auth_real_name", false)) {
      if (QLog.isColorLevel()) {
        QLog.i("RealName", 2, "has auth real name.");
      }
    }
    do
    {
      do
      {
        return;
        if (EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getApplication()) != 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("RealName", 2, "devlock status is 0.");
      return;
      ToServiceMsg localToServiceMsg = makeOIDBPkg("OidbSvc.0x9ae_2", 2478, 2, new cmd0x9ae.ReqBody().toByteArray());
      localToServiceMsg.addAttribute("serviceType", Integer.valueOf(2));
      sendPbReq(localToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.i("RealName", 2, "queryRealNameStatus");
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return ConfigObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    String str;
    int i;
    if (QLog.isColorLevel())
    {
      str = paramFromServiceMsg.getServiceCmd();
      i = paramToServiceMsg.getAppSeq();
      if (paramObject == null) {
        break label86;
      }
    }
    label86:
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.d("ConfigHandler", 2, String.format("ConfigHandler serviceCmd[%s], appseq[%s], data[%s]", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool1) }));
      if (!"ResourceConfig.GetResourceReq".equals(paramFromServiceMsg.getServiceCmd())) {
        break;
      }
      a(paramToServiceMsg, paramObject);
      return;
    }
    if ("MobileTipsSvc.TipsReport".equals(paramFromServiceMsg.getServiceCmd()))
    {
      bool1 = paramFromServiceMsg.isSuccess();
      if (!bool1) {
        break label370;
      }
      paramToServiceMsg = new MobileTips.MobileTipsPkg();
    }
    label370:
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.rsp.result.get() == 0)
        {
          bool1 = bool2;
          if (QLog.isDevelopLevel()) {
            QLog.d("QQOperateVoIP", 4, "get voip_tips req ack rsp confighandler isSuccess " + bool1);
          }
          if (bool1) {
            break;
          }
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        continue;
        bool1 = false;
        continue;
      }
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
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.richstatus.xml", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler
 * JD-Core Version:    0.7.0.1
 */