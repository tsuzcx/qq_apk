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
import com.tencent.mobileqq.app.ViewActionObserver;
import com.tencent.mobileqq.app.ViewActionObserver.Action;
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
  TroopManagerBizObserver A = new TroopMemberApiService.3(this);
  TroopModifyObserver B = new TroopMemberApiService.4(this);
  TroopObserver C = new TroopMemberApiService.5(this);
  TroopMngObserver D = new TroopMemberApiService.6(this);
  TroopAppObserver E = new TroopMemberApiService.7(this);
  TroopAssociationObserver F = new TroopMemberApiService.8(this);
  TroopEssenceMsgObserver G = new TroopMemberApiService.9(this);
  IPublicAccountH5Manager H;
  BizTroopObserver I = new TroopMemberApiService.10(this);
  public LBSObserver J = new TroopMemberApiService.11(this);
  public AvatarObserver K = new TroopMemberApiService.12(this);
  public NearbyCardObserver L = new TroopMemberApiService.14(this);
  public ReadInJoyObserver M = new TroopMemberApiService.15(this);
  TransProcessorHandler N = new TroopMemberApiService.16(this);
  private ViewActionObserver O = new ViewActionObserver();
  private ViewActionObserver.Action P = new TroopMemberApiService.13(this);
  final Messenger a = new Messenger(new TroopMemberApiService.IncomingHandler(this));
  Messenger b = null;
  ConcurrentHashMap<String, Messenger> c = new ConcurrentHashMap();
  QQMusicService d;
  WebPushService e;
  QQMapActivityProxy f;
  ConditionSearchManager g;
  String h;
  int i;
  int j = -1;
  String k;
  int l;
  int m;
  int n;
  int o;
  boolean p = false;
  ArrayList<Integer> q = new ArrayList();
  boolean r = false;
  String s;
  int t;
  DoraemonBridge u = null;
  String v;
  IHotChatSCHelper w = null;
  IReadInJoySkinHelper x = null;
  HotChatObserver y = new TroopMemberApiService.1(this);
  WebPushObserver z = new TroopMemberApiService.2(this);
  
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
    if (!FileUtil.d(paramHWTroopFileStatusInfo.LocalFile)) {
      TroopFileTransferManager.a(paramQQAppInterface, paramLong).o();
    }
    String str;
    if (!TextUtils.isEmpty(paramHWTroopFileStatusInfo.FileName)) {
      str = paramHWTroopFileStatusInfo.FileName;
    } else {
      str = "";
    }
    TroopFileManager.a(paramQQAppInterface, paramLong).b(paramHWTroopFileStatusInfo.Id);
    localFileInfo.d(str);
    localFileInfo.f(paramHWTroopFileStatusInfo.LocalFile);
    localFileInfo.a(paramHWTroopFileStatusInfo.ProgressTotal);
    paramQQAppInterface = new TroopFileStatusInfo();
    paramQQAppInterface.t = str;
    paramQQAppInterface.k = paramHWTroopFileStatusInfo.LocalFile;
    paramQQAppInterface.i = paramHWTroopFileStatusInfo.ProgressTotal;
    paramQQAppInterface.a = paramHWTroopFileStatusInfo.Id;
    paramQQAppInterface.d = paramLong;
    paramQQAppInterface.u = paramHWTroopFileStatusInfo.BusId;
    paramQQAppInterface.r = paramHWTroopFileStatusInfo.FilePath;
    paramQQAppInterface.s = paramHWTroopFileStatusInfo.sha1;
    paramQQAppInterface.l = paramHWTroopFileStatusInfo.ThumbnailFile_Small;
    paramQQAppInterface.m = paramHWTroopFileStatusInfo.ThumbnailFile_Large;
    paramQQAppInterface.e = paramHWTroopFileStatusInfo.Status;
    paramBundle.putLong("sessionId", FileManagerUtil.a(paramQQAppInterface).nSessionId);
    paramBundle.putInt("cloudType", 4);
    paramBundle.putInt("type", 10006);
    paramBundle.putString("filePath", localFileInfo.d());
    paramBundle.putString("fileName", localFileInfo.e());
    paramBundle.putLong("fileSize", localFileInfo.f());
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
      if (localLebaViewItem.b == null) {
        return false;
      }
      boolean bool;
      if (localLebaViewItem.f == 0) {
        bool = true;
      } else {
        bool = false;
      }
      if (paramBoolean == bool) {
        return false;
      }
      localLebaViewItem.f = (paramBoolean ^ true);
      if (!(this.app instanceof QQAppInterface)) {
        return false;
      }
      localILebaHelperService.updateAppSetting(this.app, localLebaViewItem.b.uiResId, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      paramLong = NetConnInfoCenter.getServerTimeMillis();
      localILebaHelperService.netSetPluginState(String.valueOf(localLebaViewItem.b.uiResId), paramBoolean, paramLong);
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
      int i1 = ((DisplayMetrics)localObject).widthPixels;
      int i2 = ((DisplayMetrics)localObject).heightPixels;
      localObject = new nearbybanner.ClientInfo();
      ((nearbybanner.ClientInfo)localObject).uint32_lcd_height.set(i2);
      ((nearbybanner.ClientInfo)localObject).uint32_lcd_width.set(i1);
      ((nearbybanner.ClientInfo)localObject).bytes_client_version.set(ByteStringMicro.copyFromUtf8("8.8.17.5770"));
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
        int i2 = 0;
        if (!bool) {
          break label107;
        }
        i1 = 1;
        localJSONObject.put("ugc_video_flag", i1);
        i1 = i2;
        if (paramBoolean) {
          i1 = 1;
        }
        localJSONObject.put("ugc_topic_video", i1);
        localJSONObject.put("publisher_type", 1);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AC6D", 5, localJSONObject.toString());
      return;
      label107:
      int i1 = 0;
    }
  }
  
  private void c()
  {
    this.O.a(0, this.P);
  }
  
  public QQMusicService a()
  {
    if (this.d == null) {
      this.d = new QQMusicService(this);
    }
    return this.d;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Object localObject = null;
    Message localMessage = Message.obtain(null, paramInt);
    Messenger localMessenger2 = this.b;
    if (paramBundle != null) {
      localObject = paramBundle.getString("processName");
    }
    Messenger localMessenger1 = localMessenger2;
    if (localObject != null)
    {
      ConcurrentHashMap localConcurrentHashMap = this.c;
      localMessenger1 = localMessenger2;
      if (localConcurrentHashMap != null)
      {
        localMessenger1 = localMessenger2;
        if (localConcurrentHashMap.get(localObject) != null) {
          localMessenger1 = (Messenger)this.c.get(localObject);
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
    int i1;
    if ((this.app instanceof QQAppInterface))
    {
      localObject1 = (QQAppInterface)this.app;
      Object localObject2 = (TroopRedTouchManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
      if (localObject2 != null)
      {
        localObject2 = ((TroopRedTouchManager)localObject2).e(7);
        if (localObject2 != null)
        {
          TroopRedTouchHandler.a((QQAppInterface)localObject1, (oidb_0x791.RedDotInfo)localObject2);
          localObject1 = (TroopRedTouchHandler)((QQAppInterface)this.app).getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER);
          if (localObject1 != null) {
            ((TroopRedTouchHandler)localObject1).notifyUI(105, true, null);
          }
        }
      }
      i1 = 0;
    }
    else
    {
      i1 = 1;
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
    paramBundle.append(i1);
    paramBundle.append("\"}");
    ((Bundle)localObject1).putString("data", paramBundle.toString());
    ((Bundle)localObject1).putString("method", "cleanDynamicRedPoint");
    a(15, (Bundle)localObject1);
  }
  
  public void a(String paramString1, String paramString2)
  {
    WtloginHelper localWtloginHelper = new WtloginHelper(this.app.getApplication().getApplicationContext());
    localWtloginHelper.SetListener(new TroopMemberApiService.17(this, localWtloginHelper));
    String str = this.app.getAccount();
    paramString1 = paramString1.getBytes();
    long l1 = Long.valueOf(paramString2).longValue();
    paramString2 = "5.2".getBytes();
    WUserSigInfo localWUserSigInfo = new WUserSigInfo();
    WFastLoginInfo localWFastLoginInfo = new WFastLoginInfo();
    if (localWtloginHelper.GetA1WithA1(str, 16L, 16L, paramString1, 1L, l1, 1L, paramString2, new byte[] { -51, 50, 114, -105, -54, -19, 112, -124, -125, -52, -72, -101, -27, 33, 65, -128 }, localWUserSigInfo, localWFastLoginInfo) != -1001) {
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
        long l1 = AnonymousChatHelper.f;
        if (l1 == -1L) {
          return;
        }
        paramString4 = new Bundle();
        paramString4.putLong("anonymousseq", l1);
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
  
  public WebPushService b()
  {
    if (this.e == null) {
      this.e = new WebPushService(this);
    }
    return this.e;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onBind");
    }
    return this.a.getBinder();
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onCreate");
    }
    super.onCreate();
    if ((this.app instanceof QQAppInterface))
    {
      ((QQAppInterface)this.app).addObserver(this.I, true);
      ((QQAppInterface)this.app).addObserver(this.J);
      ((QQAppInterface)this.app).addObserver(this.K);
      ((QQAppInterface)this.app).addObserver(this.E);
      ((QQAppInterface)this.app).addObserver(this.D);
      ((QQAppInterface)this.app).addObserver(this.C);
      ((QQAppInterface)this.app).addObserver(this.B);
      ((QQAppInterface)this.app).addObserver(this.A);
      ((QQAppInterface)this.app).addObserver(this.F);
      ((QQAppInterface)this.app).addObserver(this.G);
      ((QQAppInterface)this.app).addObserver(this.y);
      ((QQAppInterface)this.app).addObserver(this.L);
      c();
      this.app.registObserver(this.O);
      this.app.registObserver(this.z);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.M);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onDestroy");
    }
    super.onDestroy();
    if ((this.app instanceof QQAppInterface))
    {
      ((QQAppInterface)this.app).removeObserver(this.I);
      ((QQAppInterface)this.app).removeObserver(this.J);
      ((QQAppInterface)this.app).removeObserver(this.K);
      ((QQAppInterface)this.app).removeObserver(this.E);
      ((QQAppInterface)this.app).removeObserver(this.D);
      ((QQAppInterface)this.app).removeObserver(this.C);
      ((QQAppInterface)this.app).removeObserver(this.B);
      ((QQAppInterface)this.app).removeObserver(this.A);
      ((QQAppInterface)this.app).removeObserver(this.F);
      ((QQAppInterface)this.app).removeObserver(this.G);
      ((QQAppInterface)this.app).removeObserver(this.y);
      ((QQAppInterface)this.app).removeObserver(this.L);
      if (!TextUtils.isEmpty(this.app.getAccount())) {
        ((ITransFileController)((QQAppInterface)this.app).getRuntimeService(ITransFileController.class)).removeHandle(this.N);
      }
      this.app.unRegistObserver(this.z);
      this.app.unRegistObserver(this.O);
      this.O.a();
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(this.M);
    TextUtils.isEmpty(this.v);
    Object localObject = this.x;
    if (localObject != null) {
      ((IReadInJoySkinHelper)localObject).a();
    }
    this.app = null;
    this.b = null;
    localObject = this.c;
    if (localObject != null)
    {
      ((ConcurrentHashMap)localObject).clear();
      this.c = null;
    }
    localObject = this.g;
    if (localObject != null) {
      ((ConditionSearchManager)localObject).b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService
 * JD-Core Version:    0.7.0.1
 */