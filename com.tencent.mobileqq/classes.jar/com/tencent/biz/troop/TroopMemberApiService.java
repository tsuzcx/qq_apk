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
import com.tencent.biz.pubaccount.api.IPublicAccountH5Manager;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.Doraemon.DoraemonBridge;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.app.WebPushObserver;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotchat.api.IHotChatSCHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.skin.api.IReadInJoySkinHelper;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.association.api.TroopAssociationObserver;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.observer.TroopEssenceMsgObserver;
import com.tencent.mobileqq.troop.troopapps.api.TroopAppObserver;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.model.HWTroopFileStatusInfo;
import java.io.Serializable;
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
import org.json.JSONException;
import org.json.JSONObject;
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
  IPublicAccountH5Manager jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountH5Manager;
  DoraemonBridge jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonBridge = null;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new TroopMemberApiService.10(this);
  ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new TroopMemberApiService.1(this);
  public LBSObserver a;
  QQMapActivityProxy jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy;
  WebPushObserver jdField_a_of_type_ComTencentMobileqqAppWebPushObserver = new TroopMemberApiService.2(this);
  public AvatarObserver a;
  IHotChatSCHelper jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatSCHelper = null;
  IReadInJoySkinHelper jdField_a_of_type_ComTencentMobileqqKandianBizSkinApiIReadInJoySkinHelper = null;
  public ReadInJoyObserver a;
  public NearbyCardObserver a;
  TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new TroopMemberApiService.15(this);
  TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new TroopMemberApiService.6(this);
  TroopModifyObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopModifyObserver = new TroopMemberApiService.4(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopMemberApiService.5(this);
  TroopAssociationObserver jdField_a_of_type_ComTencentMobileqqTroopAssociationApiTroopAssociationObserver = new TroopMemberApiService.8(this);
  TroopEssenceMsgObserver jdField_a_of_type_ComTencentMobileqqTroopObserverTroopEssenceMsgObserver = new TroopMemberApiService.9(this);
  TroopAppObserver jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiTroopAppObserver = new TroopMemberApiService.7(this);
  TroopManagerBizObserver jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiTroopManagerBizObserver = new TroopMemberApiService.3(this);
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
    this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new TroopMemberApiService.11(this);
    this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new TroopMemberApiService.12(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver = new TroopMemberApiService.13(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new TroopMemberApiService.14(this);
  }
  
  private void a(int paramInt, boolean paramBoolean, Serializable paramSerializable, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", paramSerializable);
    localBundle.putString("observerClassName", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localBundle.putString("processName", paramString2);
    }
    a(3, localBundle);
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, HWTroopFileStatusInfo paramHWTroopFileStatusInfo, Bundle paramBundle)
  {
    if (paramHWTroopFileStatusInfo == null) {
      return;
    }
    FileInfo localFileInfo = new FileInfo();
    if (!FileUtil.b(paramHWTroopFileStatusInfo.LocalFile)) {
      TroopFileTransferManager.a(paramQQAppInterface, paramLong).b();
    }
    String str;
    if (!TextUtils.isEmpty(paramHWTroopFileStatusInfo.FileName)) {
      str = paramHWTroopFileStatusInfo.FileName;
    } else {
      str = "";
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
    if (!(this.app instanceof QQAppInterface)) {
      return false;
    }
    ILebaHelperService localILebaHelperService = (ILebaHelperService)this.app.getRuntimeService(ILebaHelperService.class, "multi");
    LebaViewItem localLebaViewItem = localILebaHelperService.getLebaViewItemById(paramLong);
    if (localLebaViewItem != null)
    {
      if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null) {
        return false;
      }
      boolean bool;
      if (localLebaViewItem.jdField_a_of_type_Byte == 0) {
        bool = true;
      } else {
        bool = false;
      }
      if (paramBoolean == bool) {
        return false;
      }
      localLebaViewItem.jdField_a_of_type_Byte = (paramBoolean ^ true);
      if (!(this.app instanceof QQAppInterface)) {
        return false;
      }
      localILebaHelperService.updateAppSetting(this.app, localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      paramLong = NetConnInfoCenter.getServerTimeMillis();
      localILebaHelperService.netSetPluginState(String.valueOf(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId), paramBoolean, paramLong);
      return true;
    }
    return false;
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
      ((nearbybanner.ClientInfo)localObject).bytes_client_version.set(ByteStringMicro.copyFromUtf8("8.7.0.5295"));
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
  
  private static void b(boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        boolean bool = ((IRIJUgcUtils)QRoute.api(IRIJUgcUtils.class)).needShowUploadVideoEntry();
        int j = 0;
        if (!bool) {
          break label139;
        }
        i = 1;
        localJSONObject.put("ugc_video_flag", i);
        if (!((IRIJUgcUtils)QRoute.api(IRIJUgcUtils.class)).needShowCreateColumnEntry()) {
          break label144;
        }
        i = 1;
        localJSONObject.put("ugc_column_flag", i);
        i = j;
        if (paramBoolean) {
          i = 1;
        }
        localJSONObject.put("ugc_topic_video", i);
        localJSONObject.put("publisher_type", 1);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AC6D", 5, localJSONObject.toString());
      return;
      label139:
      int i = 0;
      continue;
      label144:
      i = 0;
    }
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
    Object localObject = null;
    Message localMessage = Message.obtain(null, paramInt);
    Messenger localMessenger2 = this.jdField_b_of_type_AndroidOsMessenger;
    if (paramBundle != null) {
      localObject = paramBundle.getString("processName");
    }
    Messenger localMessenger1 = localMessenger2;
    if (localObject != null)
    {
      ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      localMessenger1 = localMessenger2;
      if (localConcurrentHashMap != null)
      {
        localMessenger1 = localMessenger2;
        if (localConcurrentHashMap.get(localObject) != null) {
          localMessenger1 = (Messenger)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        }
      }
    }
    localMessage.setData(paramBundle);
    if (localMessenger1 != null) {
      try
      {
        localMessenger1.send(localMessage);
        return;
      }
      catch (RemoteException paramBundle)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("messeage not sent:");
          ((StringBuilder)localObject).append(paramBundle.getMessage());
          QLog.e("com.tencent.biz.troop.TroopMemberApiService", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    int i;
    if ((this.app instanceof QQAppInterface))
    {
      localObject1 = (QQAppInterface)this.app;
      Object localObject2 = (TroopRedTouchManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
      if (localObject2 != null)
      {
        localObject2 = ((TroopRedTouchManager)localObject2).a(7);
        if (localObject2 != null)
        {
          TroopRedTouchHandler.a((QQAppInterface)localObject1, (oidb_0x791.RedDotInfo)localObject2);
          localObject1 = (TroopRedTouchHandler)((QQAppInterface)this.app).getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER);
          if (localObject1 != null) {
            ((TroopRedTouchHandler)localObject1).notifyUI(105, true, null);
          }
        }
      }
      i = 0;
    }
    else
    {
      i = 1;
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "tribe", "clearreddot", 0, 1, "", "", "", "");
    }
    Object localObject1 = new Bundle();
    if (paramBundle != null)
    {
      ((Bundle)localObject1).putInt("seq", paramBundle.getInt("seq", -1));
      if (!TextUtils.isEmpty(paramBundle.getString("callback"))) {
        ((Bundle)localObject1).putString("callback", paramBundle.getString("callback"));
      }
    }
    paramBundle = new StringBuilder();
    paramBundle.append("{code:\"");
    paramBundle.append(i);
    paramBundle.append("\"}");
    ((Bundle)localObject1).putString("data", paramBundle.toString());
    ((Bundle)localObject1).putString("method", "cleanDynamicRedPoint");
    a(15, (Bundle)localObject1);
  }
  
  public void a(String paramString1, String paramString2)
  {
    WtloginHelper localWtloginHelper = new WtloginHelper(this.app.getApplication().getApplicationContext());
    localWtloginHelper.SetListener(new TroopMemberApiService.16(this, localWtloginHelper));
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
    AppRuntime localAppRuntime = this.app;
    if (localAppRuntime != null)
    {
      if (!(localAppRuntime instanceof QQAppInterface)) {
        return;
      }
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4)))
      {
        long l = AnonymousChatHelper.a;
        if (l == -1L) {
          return;
        }
        paramString4 = new Bundle();
        paramString4.putLong("anonymousseq", l);
        if (QBaseActivity.sTopActivity != null) {
          NewReportPlugin.a(QBaseActivity.sTopActivity, paramString2, null, null, paramString1, paramString3, 25029, null, paramString4);
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "safetyReport param null");
      }
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
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiTroopAppObserver);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopModifyObserver);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiTroopManagerBizObserver);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopAssociationApiTroopAssociationObserver);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopEssenceMsgObserver);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqAppWebPushObserver);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
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
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiTroopAppObserver);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopModifyObserver);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiTroopManagerBizObserver);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopAssociationApiTroopAssociationObserver);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopEssenceMsgObserver);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
      if (!TextUtils.isEmpty(this.app.getAccount())) {
        ((ITransFileController)((QQAppInterface)this.app).getRuntimeService(ITransFileController.class)).removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      }
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqAppWebPushObserver);
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    TextUtils.isEmpty(this.d);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinApiIReadInJoySkinHelper;
    if (localObject != null) {
      ((IReadInJoySkinHelper)localObject).a();
    }
    this.app = null;
    this.jdField_b_of_type_AndroidOsMessenger = null;
    localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject != null)
    {
      ((ConcurrentHashMap)localObject).clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
    if (localObject != null) {
      ((ConditionSearchManager)localObject).b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService
 * JD-Core Version:    0.7.0.1
 */