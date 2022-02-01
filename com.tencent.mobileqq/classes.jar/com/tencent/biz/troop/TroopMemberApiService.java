package com.tencent.biz.troop;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.apiproxy.QQMusicService;
import com.tencent.biz.apiproxy.WebPushService;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.plugin.ReadInJoySkinHelper;
import com.tencent.biz.pubaccount.util.PAH5Manager;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.Doraemon.DoraemonBridge;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.HotchatSCHelper;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.WebPushObserver;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.observer.TroopApiObserver;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.model.HWTroopFileStatusInfo;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import tencent.im.group.nearbybanner.nearbybanner.ClientInfo;
import tencent.im.group.nearbybanner.nearbybanner.ReqBody;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class TroopMemberApiService
  extends AppService
{
  int jdField_a_of_type_Int;
  final Messenger jdField_a_of_type_AndroidOsMessenger = new Messenger(new TroopMemberApiService.IncomingHandler(this));
  QQMusicService jdField_a_of_type_ComTencentBizApiproxyQQMusicService;
  WebPushService jdField_a_of_type_ComTencentBizApiproxyWebPushService;
  public ReadInJoyObserver a;
  ReadInJoySkinHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoySkinHelper = null;
  PAH5Manager jdField_a_of_type_ComTencentBizPubaccountUtilPAH5Manager;
  DoraemonBridge jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonBridge = null;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new TroopMemberApiService.6(this);
  ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new TroopMemberApiService.1(this);
  HotchatSCHelper jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper = null;
  public LBSObserver a;
  QQMapActivityProxy jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy;
  TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new TroopMemberApiService.4(this);
  WebPushObserver jdField_a_of_type_ComTencentMobileqqAppWebPushObserver = new TroopMemberApiService.2(this);
  public AvatarObserver a;
  public NearbyCardObserver a;
  TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new TroopMemberApiService.11(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopMemberApiService.3(this);
  TroopApiObserver jdField_a_of_type_ComTencentMobileqqTroopObserverTroopApiObserver = new TroopMemberApiService.5(this);
  String jdField_a_of_type_JavaLangString;
  ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  ConcurrentHashMap<String, Messenger> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = -1;
  Messenger jdField_b_of_type_AndroidOsMessenger = null;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  int e;
  int f;
  int g;
  
  public TroopMemberApiService()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new TroopMemberApiService.7(this);
    this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new TroopMemberApiService.8(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver = new TroopMemberApiService.9(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new TroopMemberApiService.10(this);
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, HWTroopFileStatusInfo paramHWTroopFileStatusInfo, Bundle paramBundle)
  {
    if (paramHWTroopFileStatusInfo == null) {
      return;
    }
    FileInfo localFileInfo = new FileInfo();
    if (!FileUtil.a(paramHWTroopFileStatusInfo.LocalFile)) {
      TroopFileTransferManager.a(paramQQAppInterface, paramLong).b();
    }
    String str = "";
    if (!TextUtils.isEmpty(paramHWTroopFileStatusInfo.FileName)) {
      str = paramHWTroopFileStatusInfo.FileName;
    }
    TroopFileManager.a(paramQQAppInterface, paramLong).a(paramHWTroopFileStatusInfo.Id);
    localFileInfo.d(str);
    localFileInfo.e(paramHWTroopFileStatusInfo.LocalFile);
    localFileInfo.a(paramHWTroopFileStatusInfo.ProgressTotal);
    paramQQAppInterface = new TroopFileStatusInfo();
    paramQQAppInterface.g = str;
    paramQQAppInterface.jdField_a_of_type_JavaLangString = paramHWTroopFileStatusInfo.LocalFile;
    paramQQAppInterface.jdField_c_of_type_Long = paramHWTroopFileStatusInfo.ProgressTotal;
    paramQQAppInterface.jdField_a_of_type_JavaUtilUUID = paramHWTroopFileStatusInfo.Id;
    paramQQAppInterface.jdField_b_of_type_Long = paramLong;
    paramQQAppInterface.h = paramHWTroopFileStatusInfo.BusId;
    paramQQAppInterface.e = paramHWTroopFileStatusInfo.FilePath;
    paramQQAppInterface.f = paramHWTroopFileStatusInfo.sha1;
    paramQQAppInterface.jdField_b_of_type_JavaLangString = paramHWTroopFileStatusInfo.ThumbnailFile_Small;
    paramQQAppInterface.jdField_c_of_type_JavaLangString = paramHWTroopFileStatusInfo.ThumbnailFile_Large;
    paramQQAppInterface.jdField_b_of_type_Int = paramHWTroopFileStatusInfo.Status;
    paramBundle.putLong("sessionId", FileManagerUtil.a(paramQQAppInterface).nSessionId);
    paramBundle.putInt("cloudType", 4);
    paramBundle.putInt("type", 10006);
    paramBundle.putString("filePath", localFileInfo.c());
    paramBundle.putString("fileName", localFileInfo.d());
    paramBundle.putLong("fileSize", localFileInfo.a());
    paramBundle.putLong("troopCode", paramLong);
    a(20, paramBundle);
  }
  
  private boolean a(long paramLong, boolean paramBoolean)
  {
    if (!(this.app instanceof QQAppInterface)) {}
    ILebaHelperService localILebaHelperService;
    LebaViewItem localLebaViewItem;
    do
    {
      return false;
      localILebaHelperService = (ILebaHelperService)this.app.getRuntimeService(ILebaHelperService.class, "multi");
      localLebaViewItem = localILebaHelperService.getLebaViewItemById(paramLong);
    } while ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null));
    boolean bool;
    if (localLebaViewItem.jdField_a_of_type_Byte == 0)
    {
      bool = true;
      label64:
      if (paramBoolean == bool) {
        break label150;
      }
      if (!paramBoolean) {
        break label152;
      }
    }
    label150:
    label152:
    for (byte b1 = 0;; b1 = 1)
    {
      localLebaViewItem.jdField_a_of_type_Byte = b1;
      if (!(this.app instanceof QQAppInterface)) {
        break;
      }
      localILebaHelperService.updateAppSetting(this.app, localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      paramLong = NetConnInfoCenter.getServerTimeMillis();
      localILebaHelperService.netSetPluginState(String.valueOf(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId), paramBoolean, paramLong);
      return true;
      bool = false;
      break label64;
      break;
    }
  }
  
  public static boolean a(AppRuntime paramAppRuntime, BusinessObserver paramBusinessObserver)
  {
    nearbybanner.ReqBody localReqBody = new nearbybanner.ReqBody();
    try
    {
      Object localObject = paramAppRuntime.getApplication().getResources().getDisplayMetrics();
      int i = ((DisplayMetrics)localObject).widthPixels;
      int j = ((DisplayMetrics)localObject).heightPixels;
      localObject = new nearbybanner.ClientInfo();
      ((nearbybanner.ClientInfo)localObject).uint32_lcd_height.set(j);
      ((nearbybanner.ClientInfo)localObject).uint32_lcd_width.set(i);
      ((nearbybanner.ClientInfo)localObject).bytes_client_version.set(ByteStringMicro.copyFromUtf8("8.5.5.5105"));
      ((nearbybanner.ClientInfo)localObject).uint32_os.set(0);
      localReqBody.msg_client_info.set((MessageMicro)localObject);
      localObject = new NewIntent(paramAppRuntime.getApplication(), ProtoServlet.class);
      ((NewIntent)localObject).putExtra("cmd", "nearby_group_banner.get_banner_info");
      ((NewIntent)localObject).putExtra("data", localReqBody.toByteArray());
      ((NewIntent)localObject).setObserver(paramBusinessObserver);
      paramAppRuntime.startServlet((NewIntent)localObject);
      return true;
    }
    catch (Exception paramAppRuntime) {}
    return false;
  }
  
  public QQMusicService a()
  {
    if (this.jdField_a_of_type_ComTencentBizApiproxyQQMusicService == null) {
      this.jdField_a_of_type_ComTencentBizApiproxyQQMusicService = new QQMusicService(this);
    }
    return this.jdField_a_of_type_ComTencentBizApiproxyQQMusicService;
  }
  
  public WebPushService a()
  {
    if (this.jdField_a_of_type_ComTencentBizApiproxyWebPushService == null) {
      this.jdField_a_of_type_ComTencentBizApiproxyWebPushService = new WebPushService(this);
    }
    return this.jdField_a_of_type_ComTencentBizApiproxyWebPushService;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    String str = null;
    Message localMessage = Message.obtain(null, paramInt);
    Messenger localMessenger2 = this.jdField_b_of_type_AndroidOsMessenger;
    if (paramBundle != null) {
      str = paramBundle.getString("processName");
    }
    Messenger localMessenger1 = localMessenger2;
    if (str != null)
    {
      localMessenger1 = localMessenger2;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
      {
        localMessenger1 = localMessenger2;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str) != null) {
          localMessenger1 = (Messenger)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        }
      }
    }
    localMessage.setData(paramBundle);
    if (localMessenger1 != null) {}
    try
    {
      localMessenger1.send(localMessage);
      return;
    }
    catch (RemoteException paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("com.tencent.biz.troop.TroopMemberApiService", 2, "messeage not sent:" + paramBundle.getMessage());
    }
  }
  
  public void a(Bundle paramBundle)
  {
    int j = 0;
    Object localObject1;
    if ((this.app instanceof QQAppInterface))
    {
      localObject1 = (QQAppInterface)this.app;
      Object localObject2 = (TroopRedTouchManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
      i = j;
      if (localObject2 != null)
      {
        localObject2 = ((TroopRedTouchManager)localObject2).a(7);
        i = j;
        if (localObject2 != null)
        {
          TroopRedTouchHandler.a((QQAppInterface)localObject1, (oidb_0x791.RedDotInfo)localObject2);
          localObject1 = (TroopRedTouchHandler)((QQAppInterface)this.app).getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER);
          i = j;
          if (localObject1 != null) {
            ((TroopRedTouchHandler)localObject1).notifyUI(105, true, null);
          }
        }
      }
    }
    for (int i = j;; i = 1)
    {
      localObject1 = new Bundle();
      if (paramBundle != null)
      {
        ((Bundle)localObject1).putInt("seq", paramBundle.getInt("seq", -1));
        if (!TextUtils.isEmpty(paramBundle.getString("callback"))) {
          ((Bundle)localObject1).putString("callback", paramBundle.getString("callback"));
        }
      }
      ((Bundle)localObject1).putString("data", "{code:\"" + i + "\"}");
      ((Bundle)localObject1).putString("method", "cleanDynamicRedPoint");
      a(15, (Bundle)localObject1);
      return;
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "tribe", "clearreddot", 0, 1, "", "", "", "");
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    WtloginHelper localWtloginHelper = new WtloginHelper(this.app.getApplication().getApplicationContext());
    localWtloginHelper.SetListener(new TroopMemberApiService.12(this, localWtloginHelper));
    String str = this.app.getAccount();
    paramString1 = paramString1.getBytes();
    long l = Long.valueOf(paramString2).longValue();
    paramString2 = "5.2".getBytes();
    WUserSigInfo localWUserSigInfo = new WUserSigInfo();
    WFastLoginInfo localWFastLoginInfo = new WFastLoginInfo();
    if (localWtloginHelper.GetA1WithA1(str, 16L, 16L, paramString1, 1L, l, 1L, paramString2, new byte[] { -51, 50, 114, -105, -54, -19, 112, -124, -125, -52, -72, -101, -27, 33, 65, -128 }, localWUserSigInfo, localWFastLoginInfo) != -1001) {
      a(61, null);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = this.app;
    if ((localObject == null) || (!(localObject instanceof QQAppInterface))) {}
    long l;
    do
    {
      do
      {
        return;
        if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "safetyReport param null");
      return;
      l = AnonymousChatHelper.a;
    } while (l == -1L);
    localObject = new Bundle();
    ((Bundle)localObject).putLong("anonymousseq", l);
    if (BaseActivity.sTopActivity != null) {}
    for (paramString4 = BaseActivity.sTopActivity;; paramString4 = getApplicationContext())
    {
      NewReportPlugin.a((BaseActivity)paramString4, paramString2, null, null, paramString1, paramString3, 25029, null, (Bundle)localObject);
      return;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onBind");
    }
    return this.jdField_a_of_type_AndroidOsMessenger.getBinder();
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onCreate");
    }
    super.onCreate();
    if ((this.app instanceof QQAppInterface))
    {
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver, true);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopApiObserver);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqAppWebPushObserver);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onDestroy");
    }
    super.onDestroy();
    if ((this.app instanceof QQAppInterface))
    {
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopApiObserver);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
      if (!TextUtils.isEmpty(this.app.getAccount())) {
        ((ITransFileController)((QQAppInterface)this.app).getRuntimeService(ITransFileController.class)).removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      }
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqAppWebPushObserver);
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    if ((TextUtils.isEmpty(this.d)) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoySkinHelper != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoySkinHelper.a();
    }
    this.app = null;
    this.jdField_b_of_type_AndroidOsMessenger = null;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService
 * JD-Core Version:    0.7.0.1
 */