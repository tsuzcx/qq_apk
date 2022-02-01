package com.tencent.mobileqq.apollo.api.impl;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.BaseChatPanelBarConfProcessor.C2CChatPanelBarConfProcessor;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.BaseChatPanelBarConfProcessor.GroupChatPanelBarConfProcessor;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.ChatPanelBarConfBean;
import com.tencent.mobileqq.apollo.CmShowLauncher;
import com.tencent.mobileqq.apollo.aio.ApolloIntimateActionPlayController;
import com.tencent.mobileqq.apollo.aio.ApolloMsgPlayController;
import com.tencent.mobileqq.apollo.aio.BubbleProducer;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelManager;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.config.ApolloConfProcessor;
import com.tencent.mobileqq.apollo.config.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.config.ApolloGrayConfProcessor;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.game.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLifeCycleMgr;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.handler.ApolloRequest;
import com.tencent.mobileqq.apollo.listener.ApolloInitCallback;
import com.tencent.mobileqq.apollo.listener.ApolloStatusUpdateListener;
import com.tencent.mobileqq.apollo.meme.GetFrameCallback;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.meme.manager.MemeBornPlayerManager;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.model.App3DConfig;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloResHelperImpl;
import com.tencent.mobileqq.apollo.statistics.product.ApolloConfigDataReport;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceReportInstance;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.apollo.utils.ApolloActionUsedManager;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloHardWareTester;
import com.tencent.mobileqq.apollo.utils.RSAVerify;
import com.tencent.mobileqq.apollo.utils.VersionUtil;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.view.ApolloMainInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.util.URLUtil;
import cooperation.vip.manager.QZoneVipInfoManager;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import cooperation.vip.tianshu.TianShuManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xdc.submsgtype0xdc.MsgBody;

public class ApolloManagerServiceImpl
  implements IApolloManagerService
{
  public static final String KEY_PET_CONFIG = "pet_config";
  public static final String TAG = "[cmshow]ApolloManager";
  private static HashMap<MemeAction, GetFrameCallback> mCallbackMap = new HashMap();
  private static int s3dWhiteUserStatus = -1;
  private static String sApolloDpcInfo;
  private static boolean sApolloSwitch = true;
  public static volatile String sBasicScript;
  public static Vector<String> sBulkApolloInfoList = new Vector();
  public static Vector<String> sBulkPullDressList;
  private static boolean sCmShow3dDPCSwitch = true;
  public static volatile String sEngineScript;
  public static boolean sFirstOpenPanel = true;
  public static boolean sInitDone = false;
  private static int sWhiteUserStatus = -1;
  private Runnable asyncInitDataRunnable = new ApolloManagerServiceImpl.2(this);
  private float cmsPanelGetCoverFrameTime = CmShowWnsUtils.j();
  private final HashSet<Integer> mActionDownloadList = new HashSet(16);
  private final ArrayList<Long> mActionPlayList = new ArrayList(16);
  ApolloPanelManager mApolloPanelManager;
  private AppInterface mAppInterface;
  private Handler mAsyncSubThreadHandler = new ApolloManagerServiceImpl.6(this, ThreadManager.getSubThreadLooper());
  private ApolloManagerServiceImpl.ApolloManagerReceiver mBroadcastReceiver;
  private BubbleProducer mBubbleProducer;
  private HashSet<Integer> mCMSFrameCache = new HashSet();
  private AtomicBoolean mConfigInitDone = new AtomicBoolean(false);
  private boolean mDisableCreateRenderThread;
  public Timer mGlobalTimer;
  private List<ApolloInitCallback> mInitCallbackList;
  public boolean mIsBubbleTab = false;
  private volatile boolean mIsInitConfig = false;
  public boolean mIsNewStoreUser = true;
  public boolean mIsPlusWhiteList;
  public boolean mIsShowedNewPopView;
  public String mLastShopTab;
  private MessageObserver mMessageObserver;
  public String mPetConfig;
  private Map<String, Long> mPullStandActionMap = new HashMap();
  private List<WeakReference<ApolloStatusUpdateListener>> mStatusUpdateListeners = new ArrayList();
  private TianShuGetAdvCallback mTianshuCallback = new ApolloManagerServiceImpl.7(this);
  private String mUinForReload;
  private boolean mUseTextureViewConfig;
  public HashMap<Integer, Bundle> mUserActionId;
  public int openType = 0;
  private boolean sApolloEngineLockEnable;
  
  static
  {
    sBulkPullDressList = new Vector();
  }
  
  private String add3DInteractParams(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramAppRuntime != null)
    {
      str = paramString1;
      if (!TextUtils.isEmpty(paramString1))
      {
        if (!paramString1.contains("3d_interact")) {
          return paramString1;
        }
        str = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          str = paramAppRuntime.getCurrentAccountUin();
        }
        paramAppRuntime = getApolloBaseInfoFromCache(str);
        if (paramAppRuntime == null) {
          return paramString1;
        }
        paramString2 = paramAppRuntime.getApolloDress3D();
        str = paramString1;
        if (paramString2 != null)
        {
          paramAppRuntime = paramString1;
          if (paramString2.faceData != null) {
            paramAppRuntime = URLUtil.a(paramString1, "facedata", paramString2.faceData);
          }
          paramString1 = paramAppRuntime;
          if (paramString2.getDressIds() != null) {
            paramString1 = URLUtil.a(paramAppRuntime, "dressids", Arrays.toString(paramString2.getDressIds()).replaceAll(" ", ""));
          }
          str = URLUtil.a(paramString1, "roleid", String.valueOf(paramString2.roleId));
        }
      }
    }
    return str;
  }
  
  private void apolloMsgDtReport(boolean paramBoolean, String paramString, long paramLong)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void checkDpcSwitch()
  {
    if (CmShowWnsUtils.t())
    {
      this.mAsyncSubThreadHandler.removeMessages(4098);
      this.mAsyncSubThreadHandler.sendEmptyMessage(4098);
      return;
    }
    doCheckDpcSwitch();
  }
  
  private void doAfterOpenAIOStep1(SessionInfo paramSessionInfo)
  {
    try
    {
      int i = paramSessionInfo.a;
      int k = 0;
      int j = 0;
      if (i == 0)
      {
        i = j;
        if (BaseChatPanelBarConfProcessor.C2CChatPanelBarConfProcessor.a().a())
        {
          i = j;
          if (!StudyModeManager.h()) {
            i = 1;
          }
        }
        if (i != 0) {
          ApolloRequest.a(getApp(), 4018);
        }
      }
      else if (paramSessionInfo.a == 1)
      {
        i = k;
        if (BaseChatPanelBarConfProcessor.GroupChatPanelBarConfProcessor.b().a())
        {
          i = k;
          if (!StudyModeManager.h()) {
            i = 1;
          }
        }
        if (i != 0)
        {
          ApolloRequest.a(getApp(), 4019);
          return;
        }
      }
    }
    catch (Throwable paramSessionInfo)
    {
      QLog.d("[cmshow]ApolloManager", 1, "[doAfterOpenAIO]  getBattleGameList error! exception = ", paramSessionInfo);
    }
  }
  
  private void doAfterOpenAIOStep2()
  {
    try
    {
      Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("aio_used_action_sp", 0);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sp_key_apollo_panel_action_used_last_request_time");
      ((StringBuilder)localObject2).append(getApp().getCurrentAccountUin());
      long l = ((SharedPreferences)localObject1).getLong(((StringBuilder)localObject2).toString(), 0L);
      boolean bool = CmShowWnsUtils.ad();
      localObject2 = ApolloActionUsedManager.a(getApp());
      if (((System.currentTimeMillis() - l > 43200000L) || (System.currentTimeMillis() - l < 0L) || (((ApolloActionUsedManager)localObject2).a())) && (bool))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloManager", 2, "getApolloActionUsedListReqFromNetwork send req");
        }
        ((ApolloActionUsedManager)localObject2).b(-1);
        localObject1 = ((SharedPreferences)localObject1).edit();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sp_key_apollo_panel_action_used_last_request_time");
        ((StringBuilder)localObject2).append(getApp().getCurrentAccountUin());
        ((SharedPreferences.Editor)localObject1).putLong(((StringBuilder)localObject2).toString(), System.currentTimeMillis()).commit();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d("[cmshow]ApolloManager", 1, "[doAfterOpenAIO]  getBattleGameList error! exception = ", localThrowable);
    }
  }
  
  private void doAfterOpenAIOStep3(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    try
    {
      AppInterface localAppInterface = getApp();
      if (localAppInterface == null) {
        return;
      }
      if (CmShowAioMatcherImpl.judgeSupported(paramSessionInfo.a, 1))
      {
        ApolloResManagerFacade.a.a(Scene.AIO).a(localAppInterface, paramSessionInfo.b, "C2CAIO");
        if ((CmShowWnsUtils.m()) && (!StudyModeManager.h())) {
          ApolloRequest.a(localAppInterface, 4021);
        }
      }
      else if (CmShowAioMatcherImpl.judgeSupported(paramSessionInfo.a, 2))
      {
        bulkUpdateUserDress();
        if ((CmShowWnsUtils.n()) && (!StudyModeManager.h())) {
          ApolloRequest.a(localAppInterface, 4022);
        }
      }
      ApolloMsgPlayController.a().a(paramQQAppInterface, paramSessionInfo);
      ApolloIntimateActionPlayController.a().a(paramQQAppInterface, paramSessionInfo);
      return;
    }
    catch (Exception paramSessionInfo)
    {
      QLog.e("[cmshow]ApolloManager", 1, "doAfterOpenAIO error", paramSessionInfo);
    }
  }
  
  private void doCheckDpcSwitch()
  {
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.apollo_info.name(), "");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    if (str.equals(sApolloDpcInfo)) {
      return;
    }
    sApolloDpcInfo = str;
    String[] arrayOfString = str.split("\\|");
    if (arrayOfString.length > 0) {
      sApolloSwitch = "1".equals(arrayOfString[0]);
    }
    if (arrayOfString.length > 2) {
      sCmShow3dDPCSwitch = "1".equals(arrayOfString[2]);
    }
    QLog.d("[cmshow]ApolloManager", 1, new Object[] { "doCheckDpcSwitch, apolloInfo=", str, ", sApolloSwitch=", Boolean.valueOf(sApolloSwitch), ", sCmShow3dDPCSwitch=", Boolean.valueOf(sCmShow3dDPCSwitch) });
  }
  
  public static int get3dWhiteListStatus(AppRuntime paramAppRuntime)
  {
    try
    {
      if (s3dWhiteUserStatus == -1)
      {
        s3dWhiteUserStatus = 0;
        if (paramAppRuntime != null)
        {
          int i = SharedPreUtils.z(paramAppRuntime.getApplication());
          QLog.d("[cmshow]ApolloManager", 1, new Object[] { "[get3dWhiteListStatus] global=", Integer.valueOf(i) });
          if (i == 0)
          {
            SharedPreferences localSharedPreferences = paramAppRuntime.getApplication().getSharedPreferences("apollo_sp", 0);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
            localStringBuilder.append("_3dwhiteList");
            s3dWhiteUserStatus = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
          }
          else if (1 == i)
          {
            s3dWhiteUserStatus = 1;
          }
          QLog.d("[cmshow]ApolloManager", 1, new Object[] { "[get3dWhiteListStatus] global=", Integer.valueOf(i), ", s3dWhiteUserStatus=", Integer.valueOf(s3dWhiteUserStatus) });
        }
      }
    }
    catch (Throwable paramAppRuntime)
    {
      QLog.e("[cmshow]ApolloManager", 1, "[get3dWhiteListStatus] exception=", paramAppRuntime);
    }
    return s3dWhiteUserStatus;
  }
  
  private ApolloBaseInfo getApolloBaseInfoFromCache(String paramString)
  {
    AppInterface localAppInterface = getApp();
    if (localAppInterface != null) {
      return ((IApolloDaoManagerService)localAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfoFromCache(paramString);
    }
    return null;
  }
  
  private AppInterface getApp()
  {
    return this.mAppInterface;
  }
  
  private void handleAio2dBubbleAdv(TianShuAccess.RspEntry paramRspEntry)
  {
    QLog.d("[cmshow]ApolloManager", 1, "handleAio2dBubbleAdv");
    HashMap localHashMap;
    String str;
    int j;
    int i;
    Object localObject1;
    int k;
    Object localObject2;
    if ((paramRspEntry != null) && (paramRspEntry.value != null) && (paramRspEntry.value.lst != null) && (paramRspEntry.value.lst.size() != 0))
    {
      int n = paramRspEntry.value.lst.size();
      QLog.d("[cmshow]ApolloManager", 1, new Object[] { "handleAio2dBubbleAdv, size=", Integer.valueOf(n) });
      localHashMap = new HashMap();
      str = "";
      j = 0;
      i = 0;
      while (j < n)
      {
        localObject1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).argList.get();
        int m = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).iAdId.get();
        QLog.d("[cmshow]ApolloManager", 1, new Object[] { "handleAio2dBubbleAdv, adId=", Integer.valueOf(m), ", i=", Integer.valueOf(j) });
        if (j == n - 1) {
          k = 1;
        } else {
          k = 0;
        }
        if (k != 0)
        {
          str = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).traceinfo.get();
          i = m;
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject3 = (TianShuAccess.MapEntry)((Iterator)localObject1).next();
          localObject2 = ((TianShuAccess.MapEntry)localObject3).key.get();
          localObject3 = ((TianShuAccess.MapEntry)localObject3).value.get();
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloManager", 2, new Object[] { "handleAio2dBubbleAdv keyStr:", localObject2, ", valueStr=", localObject3 });
          }
          if ((k != 0) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
            localHashMap.put(localObject2, localObject3);
          }
        }
        j += 1;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = getApp();
        if (localObject1 != null)
        {
          paramRspEntry = ((AppRuntime)localObject1).getApp();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("apollo_sp");
          ((StringBuilder)localObject2).append(((AppRuntime)localObject1).getCurrentUin());
          paramRspEntry = paramRspEntry.getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
        }
        else
        {
          paramRspEntry = null;
        }
        if (paramRspEntry == null) {
          break label845;
        }
        j = paramRspEntry.getInt("key_2d_bubble_ad_id", 0);
        QLog.d("[cmshow]ApolloManager", 1, new Object[] { "handleAio2dBubbleAdv oldAdId:", Integer.valueOf(j), ", newAdId=", Integer.valueOf(i) });
        if (j == i) {
          return;
        }
        localObject2 = new DrawerPushItem();
        ((DrawerPushItem)localObject2).is_reddot = 0;
        ((DrawerPushItem)localObject2).msg_id = "aio_panel_bubble_push";
        ((DrawerPushItem)localObject2).msg_type = 7;
        ((DrawerPushItem)localObject2).priority = 1000;
        k = (int)Long.parseLong((String)localHashMap.get("startTime")) / 1000;
        ((DrawerPushItem)localObject2).start_ts = k;
        ((DrawerPushItem)localObject2).end_ts = ((int)NetConnInfoCenter.getServerTime() + ((int)Long.parseLong((String)localHashMap.get("endTime")) / 1000 - k));
        ((DrawerPushItem)localObject2).send_time = k;
        ((DrawerPushItem)localObject2).content = ((String)localHashMap.get("bubbleText"));
        ((DrawerPushItem)localObject2).show_counts = Integer.parseInt((String)localHashMap.get("showCount"));
        ((DrawerPushItem)localObject2).tianshuAdId = i;
        ((DrawerPushItem)localObject2).tianshuTraceInfo = str;
        if (((DrawerPushItem)localObject2).show_counts == 0) {
          ((DrawerPushItem)localObject2).show_counts = 1;
        }
        str = (String)localHashMap.get("packageId");
        if (TextUtils.isEmpty(str)) {
          break label850;
        }
        i = Integer.parseInt(str);
        if (!ApolloActionPackage.is3DPackage(i)) {
          break label855;
        }
        j = 3;
        ((DrawerPushItem)localObject2).target_model = j;
        ((ApolloDaoManagerServiceImpl)((AppRuntime)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all")).addPushItem((DrawerPushItem)localObject2);
        paramRspEntry = paramRspEntry.edit();
        paramRspEntry.putInt("key_2d_bubble_ad_id", k);
        if (i >= 0) {
          paramRspEntry.putInt("key_panel_bubble_tab", i);
        }
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloManager", 2, new Object[] { "handleAio2dBubbleAdv", " push bubble:", ((DrawerPushItem)localObject2).toString(), " ,packageId:", Integer.valueOf(i) });
        }
        paramRspEntry.commit();
        return;
      }
      catch (Throwable paramRspEntry)
      {
        QLog.e("[cmshow]ApolloManager", 1, "handleAio2dBubbleAdv Exception:", paramRspEntry);
        return;
      }
      QLog.e("[cmshow]ApolloManager", 1, "handleAio2dBubbleAdv, data empty");
      return;
      label845:
      j = 0;
      continue;
      label850:
      i = 0;
      continue;
      label855:
      j = 2;
    }
  }
  
  private void handleAio2dNewActionTipsAdv(TianShuAccess.RspEntry paramRspEntry)
  {
    String str2 = "startTime";
    QLog.d("[cmshow]ApolloManager", 1, "handleAio2dNewActionTipsAdv");
    int n;
    Object localObject1;
    String str1;
    int j;
    int i;
    Object localObject2;
    int m;
    int k;
    Object localObject4;
    Object localObject3;
    if ((paramRspEntry != null) && (paramRspEntry.value != null) && (paramRspEntry.value.lst != null) && (paramRspEntry.value.lst.size() != 0))
    {
      n = paramRspEntry.value.lst.size();
      QLog.d("[cmshow]ApolloManager", 1, new Object[] { "handleAio2dNewActionTipsAdv, size=", Integer.valueOf(n) });
      localObject1 = new HashMap();
      str1 = "";
      j = 0;
      i = -1;
      while (j < n)
      {
        localObject2 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).argList.get();
        m = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).iAdId.get();
        QLog.d("[cmshow]ApolloManager", 1, new Object[] { "handleAio2dNewActionTipsAdv, adId=", Integer.valueOf(m), ", i=", Integer.valueOf(j) });
        if (j == n - 1) {
          k = 1;
        } else {
          k = 0;
        }
        if (k != 0)
        {
          str1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).traceinfo.get();
          i = m;
        }
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (TianShuAccess.MapEntry)((Iterator)localObject2).next();
          localObject3 = ((TianShuAccess.MapEntry)localObject4).key.get();
          localObject4 = ((TianShuAccess.MapEntry)localObject4).value.get();
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloManager", 2, new Object[] { "handleAio2dNewActionTipsAdv keyStr:", localObject3, ", valueStr=", localObject4 });
          }
          if ((k != 0) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject4))) {
            ((Map)localObject1).put(localObject3, localObject4);
          }
        }
        j += 1;
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = getApp();
        if (localObject3 != null)
        {
          paramRspEntry = ((AppRuntime)localObject3).getApp();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("apollo_sp");
          ((StringBuilder)localObject2).append(((AppRuntime)localObject3).getCurrentUin());
          paramRspEntry = paramRspEntry.getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
        }
        else
        {
          paramRspEntry = null;
        }
        if (paramRspEntry == null) {
          break label979;
        }
        j = paramRspEntry.getInt("key_new_2d_action_adid", 0);
        QLog.d("[cmshow]ApolloManager", 1, new Object[] { "handleAio2dNewActionTipsAdv, oldAdId=", Integer.valueOf(j), ", newAdId=", Integer.valueOf(i) });
        if (j == i) {
          return;
        }
        localObject4 = (String)((Map)localObject1).get("packageIdList");
        if (TextUtils.isEmpty((CharSequence)localObject4))
        {
          QLog.e("[cmshow]ApolloManager", 1, "handleAio2dNewActionTipsAdv, packageIdListStr null");
          return;
        }
        m = Integer.parseInt((String)((Map)localObject1).get("actionId"));
        long l1 = Long.parseLong((String)((Map)localObject1).get("startTime"));
        long l2 = Long.parseLong((String)((Map)localObject1).get("endTime"));
        localObject2 = paramRspEntry;
        l2 -= l1;
        localObject4 = ((String)localObject4).split(";");
        Object localObject5;
        if ((localObject4 != null) && (localObject4.length != 0))
        {
          if (localObject3 == null) {
            break label984;
          }
          paramRspEntry = (ApolloDaoManagerServiceImpl)((AppRuntime)localObject3).getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
          if (paramRspEntry == null) {
            break label989;
          }
          localObject1 = paramRspEntry.findActionById(m);
          j = localObject4.length;
          k = 0;
          localObject3 = localObject2;
          localObject2 = str2;
          if (k < j)
          {
            str2 = localObject4[k];
            if (TextUtils.isEmpty(str2)) {
              break label998;
            }
            n = Integer.parseInt(str2);
            QLog.d("[cmshow]ApolloManager", 1, new Object[] { "handleAio2dNewActionTipsAdv, pkgId=", Integer.valueOf(n) });
            if (localObject1 == null) {
              break label995;
            }
            localObject5 = paramRspEntry.findPackageById(n);
            if (localObject5 == null) {
              break label995;
            }
            ((ApolloActionPackage)localObject5).isUpdate = true;
            ((ApolloActionPackage)localObject5).redFlowId = m;
            ((ApolloActionPackage)localObject5).redStartTime = l1;
            ((ApolloActionPackage)localObject5).redInterval = l2;
            paramRspEntry.updatePackage((ApolloActionPackage)localObject5);
          }
        }
        try
        {
          saveRedAppearTime(n);
          QLog.d("[cmshow]ApolloManager", 1, new Object[] { "handleAio2dNewActionTipsAdv, update red info to db, pkgId=", Integer.valueOf(n), ", actionId=", Integer.valueOf(m) });
          localObject5 = new JSONObject();
          ((JSONObject)localObject5).put("actionId", m);
          ((JSONObject)localObject5).put((String)localObject2, l1);
          ((JSONObject)localObject5).put("interval", l2);
          ((JSONObject)localObject5).put("adId", i);
          ((JSONObject)localObject5).put("traceInfo", str1);
          ((SharedPreferences)localObject3).edit().putString(String.format("key_new_action_info_%s", new Object[] { str2 }), ((JSONObject)localObject5).toString()).commit();
        }
        catch (Throwable paramRspEntry)
        {
          break label958;
        }
        ((SharedPreferences)localObject3).edit().putInt("key_new_2d_action_adid", i).commit();
        return;
        QLog.e("[cmshow]ApolloManager", 1, "handleAio2dNewActionTipsAdv, pkgIdList null");
        return;
      }
      catch (Throwable paramRspEntry) {}
      label958:
      QLog.e("[cmshow]ApolloManager", 1, "handleAio2dNewActionTipsAdv Exception:", paramRspEntry);
      return;
      QLog.e("[cmshow]ApolloManager", 1, "handleAio2dNewActionTipsAdv, data empty");
      return;
      label979:
      j = 0;
      continue;
      label984:
      paramRspEntry = null;
      continue;
      label989:
      localObject1 = null;
      continue;
      label995:
      continue;
      label998:
      k += 1;
    }
  }
  
  private void handleAio3dBubbleAdv(TianShuAccess.RspEntry paramRspEntry)
  {
    QLog.d("[cmshow]ApolloManager", 1, "handleAio3dBubbleAdv");
    if ((paramRspEntry != null) && (paramRspEntry.value != null) && (paramRspEntry.value.lst != null) && (paramRspEntry.value.lst.size() != 0))
    {
      int n = paramRspEntry.value.lst.size();
      QLog.d("[cmshow]ApolloManager", 1, new Object[] { "handleAio3dBubbleAdv, size=", Integer.valueOf(n) });
      HashMap localHashMap = new HashMap();
      String str1 = "";
      int i = 0;
      int j = 0;
      while (i < n)
      {
        Object localObject1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(i)).argList.get();
        int m = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(i)).iAdId.get();
        QLog.d("[cmshow]ApolloManager", 1, new Object[] { "handleAio3dBubbleAdv, adId=", Integer.valueOf(m), ", i=", Integer.valueOf(i) });
        int k;
        if (i == n - 1) {
          k = 1;
        } else {
          k = 0;
        }
        if (k != 0)
        {
          str1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(i)).traceinfo.get();
          j = m;
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (TianShuAccess.MapEntry)((Iterator)localObject1).next();
          String str2 = ((TianShuAccess.MapEntry)localObject2).key.get();
          localObject2 = ((TianShuAccess.MapEntry)localObject2).value.get();
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloManager", 2, new Object[] { "handleAio3dBubbleAdv keyStr:", str2, ", valueStr=", localObject2 });
          }
          if ((k != 0) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
            localHashMap.put(str2, localObject2);
          }
        }
        i += 1;
      }
      getBubbleProducer().a(localHashMap, j, str1);
      return;
    }
    QLog.e("[cmshow]ApolloManager", 1, "handleAio3dBubbleAdv, data empty");
  }
  
  private void handleAio3dNewActionTipsAdv(TianShuAccess.RspEntry paramRspEntry)
  {
    String str2 = "startTime";
    QLog.d("[cmshow]ApolloManager", 1, "handleAio3dNewActionTipsAdv");
    int n;
    Object localObject1;
    String str1;
    int j;
    int i;
    Object localObject2;
    int m;
    int k;
    Object localObject4;
    Object localObject3;
    if ((paramRspEntry != null) && (paramRspEntry.value != null) && (paramRspEntry.value.lst != null) && (paramRspEntry.value.lst.size() != 0))
    {
      n = paramRspEntry.value.lst.size();
      QLog.d("[cmshow]ApolloManager", 1, new Object[] { "handleAio3dNewActionTipsAdv, size=", Integer.valueOf(n) });
      localObject1 = new HashMap();
      str1 = "";
      j = 0;
      i = -1;
      while (j < n)
      {
        localObject2 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).argList.get();
        m = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).iAdId.get();
        QLog.d("[cmshow]ApolloManager", 1, new Object[] { "handleAio3dNewActionTipsAdv, adId=", Integer.valueOf(m), ", i=", Integer.valueOf(j) });
        if (j == n - 1) {
          k = 1;
        } else {
          k = 0;
        }
        if (k != 0)
        {
          str1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).traceinfo.get();
          i = m;
        }
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (TianShuAccess.MapEntry)((Iterator)localObject2).next();
          localObject3 = ((TianShuAccess.MapEntry)localObject4).key.get();
          localObject4 = ((TianShuAccess.MapEntry)localObject4).value.get();
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloManager", 2, new Object[] { "handleAio3dNewActionTipsAdv keyStr:", localObject3, ", valueStr=", localObject4 });
          }
          if ((k != 0) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject4))) {
            ((Map)localObject1).put(localObject3, localObject4);
          }
        }
        j += 1;
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = getApp();
        if (localObject3 != null)
        {
          paramRspEntry = ((AppRuntime)localObject3).getApp();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("apollo_sp");
          ((StringBuilder)localObject2).append(((AppRuntime)localObject3).getCurrentUin());
          paramRspEntry = paramRspEntry.getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
        }
        else
        {
          paramRspEntry = null;
        }
        if (paramRspEntry == null) {
          break label979;
        }
        j = paramRspEntry.getInt("key_new_3d_action_adid", 0);
        QLog.d("[cmshow]ApolloManager", 1, new Object[] { "handleAio3dNewActionTipsAdv, oldAdId=", Integer.valueOf(j), ", newAdId=", Integer.valueOf(i) });
        if (j == i) {
          return;
        }
        localObject4 = (String)((Map)localObject1).get("packageIdList");
        if (TextUtils.isEmpty((CharSequence)localObject4))
        {
          QLog.e("[cmshow]ApolloManager", 1, "handleAio3dNewActionTipsAdv, packageIdListStr null");
          return;
        }
        m = Integer.parseInt((String)((Map)localObject1).get("actionId"));
        long l1 = Long.parseLong((String)((Map)localObject1).get("startTime"));
        long l2 = Long.parseLong((String)((Map)localObject1).get("endTime"));
        localObject2 = paramRspEntry;
        l2 -= l1;
        localObject4 = ((String)localObject4).split(";");
        Object localObject5;
        if ((localObject4 != null) && (localObject4.length != 0))
        {
          if (localObject3 == null) {
            break label984;
          }
          paramRspEntry = (ApolloDaoManagerServiceImpl)((AppRuntime)localObject3).getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
          if (paramRspEntry == null) {
            break label989;
          }
          localObject1 = paramRspEntry.findActionById(m);
          j = localObject4.length;
          k = 0;
          localObject3 = localObject2;
          localObject2 = str2;
          if (k < j)
          {
            str2 = localObject4[k];
            if (TextUtils.isEmpty(str2)) {
              break label998;
            }
            n = Integer.parseInt(str2);
            QLog.d("[cmshow]ApolloManager", 1, new Object[] { "handleAio3dNewActionTipsAdv, pkgId=", Integer.valueOf(n) });
            if (localObject1 == null) {
              break label995;
            }
            localObject5 = paramRspEntry.findPackageById(n);
            if (localObject5 == null) {
              break label995;
            }
            ((ApolloActionPackage)localObject5).isUpdate = true;
            ((ApolloActionPackage)localObject5).redFlowId = m;
            ((ApolloActionPackage)localObject5).redStartTime = l1;
            ((ApolloActionPackage)localObject5).redInterval = l2;
            paramRspEntry.updatePackage((ApolloActionPackage)localObject5);
          }
        }
        try
        {
          saveRedAppearTime(n);
          QLog.d("[cmshow]ApolloManager", 1, new Object[] { "handleAio3dNewActionTipsAdv, update red info to db, pkgId=", Integer.valueOf(n), ", actionId=", Integer.valueOf(m) });
          localObject5 = new JSONObject();
          ((JSONObject)localObject5).put("actionId", m);
          ((JSONObject)localObject5).put((String)localObject2, l1);
          ((JSONObject)localObject5).put("interval", l2);
          ((JSONObject)localObject5).put("adId", i);
          ((JSONObject)localObject5).put("traceInfo", str1);
          ((SharedPreferences)localObject3).edit().putString(String.format("key_new_action_info_%s", new Object[] { str2 }), ((JSONObject)localObject5).toString()).commit();
        }
        catch (Throwable paramRspEntry)
        {
          break label958;
        }
        ((SharedPreferences)localObject3).edit().putInt("key_new_3d_action_adid", i).commit();
        return;
        QLog.e("[cmshow]ApolloManager", 1, "handleAio3dNewActionTipsAdv, pkgIdList null");
        return;
      }
      catch (Throwable paramRspEntry) {}
      label958:
      QLog.e("[cmshow]ApolloManager", 1, "handleAio3dNewActionTipsAdv Exception:", paramRspEntry);
      return;
      QLog.e("[cmshow]ApolloManager", 1, "handleAio3dNewActionTipsAdv, data empty");
      return;
      label979:
      j = 0;
      continue;
      label984:
      paramRspEntry = null;
      continue;
      label989:
      localObject1 = null;
      continue;
      label995:
      continue;
      label998:
      k += 1;
    }
  }
  
  private void handleDrawerBubbleAdv(TianShuAccess.RspEntry paramRspEntry, boolean paramBoolean)
  {
    int i = 2;
    QLog.d("[cmshow]ApolloManager", 1, new Object[] { "handleDrawerBubbleAdv, is2d=", Boolean.valueOf(paramBoolean) });
    int k;
    Object localObject2;
    int i1;
    Object localObject3;
    Object localObject1;
    int m;
    int j;
    if ((paramRspEntry != null) && (paramRspEntry.value != null) && (paramRspEntry.value.lst != null) && (paramRspEntry.value.lst.size() != 0))
    {
      int n = paramRspEntry.value.lst.size();
      QLog.d("[cmshow]ApolloManager", 1, new Object[] { "handleDrawerBubbleAdv, size=", Integer.valueOf(n) });
      k = 0;
      if (k < n)
      {
        localObject2 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(k)).argList.get();
        i1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(k)).iAdId.get();
        localObject3 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(k)).traceinfo.get();
        localObject1 = new Object[4];
        localObject1[0] = "handleDrawerBubbleAdv, adId=";
        localObject1[1] = Integer.valueOf(i1);
        localObject1[i] = ", i=";
        localObject1[3] = Integer.valueOf(k);
        QLog.d("[cmshow]ApolloManager", 1, (Object[])localObject1);
        if (k == n - 1) {
          m = 1;
        } else {
          m = 0;
        }
        localObject1 = null;
        if (m != 0) {
          j = i;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        j = i;
        ((JSONObject)localObject1).put("adId", i1);
        j = i;
        ((JSONObject)localObject1).put("traceInfo", localObject3);
        j = i;
        localObject2 = ((List)localObject2).iterator();
        j = i;
        Object localObject4;
        if (((Iterator)localObject2).hasNext())
        {
          j = i;
          localObject4 = (TianShuAccess.MapEntry)((Iterator)localObject2).next();
          j = i;
          localObject3 = ((TianShuAccess.MapEntry)localObject4).key.get();
          j = i;
          localObject4 = ((TianShuAccess.MapEntry)localObject4).value.get();
          j = i;
          boolean bool = QLog.isColorLevel();
          if (!bool) {}
        }
        try
        {
          QLog.d("[cmshow]ApolloManager", 2, new Object[] { "handleDrawerBubbleAdv keyStr:", localObject3, ", valueStr=", localObject4 });
          if ((m == 0) || (TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject4))) {
            break label957;
          }
          ((JSONObject)localObject1).put((String)localObject3, localObject4);
        }
        catch (Throwable localThrowable1)
        {
          i = 2;
          continue;
        }
        if (m != 0)
        {
          localObject2 = new DrawerPushItem();
          ((DrawerPushItem)localObject2).fromTianshu = true;
          ((DrawerPushItem)localObject2).msg_type = 0;
          ((DrawerPushItem)localObject2).is_reddot = 1;
          ((DrawerPushItem)localObject2).msg_id = String.valueOf(i1);
          ((DrawerPushItem)localObject2).tips_str = ((JSONObject)localObject1).optString("content");
          ((DrawerPushItem)localObject2).act_id = ((JSONObject)localObject1).optString("id");
          ((DrawerPushItem)localObject2).priority = ((JSONObject)localObject1).optInt("mainPriority");
          ((DrawerPushItem)localObject2).sub_priority = ((JSONObject)localObject1).optInt("subPriority");
          ((DrawerPushItem)localObject2).start_ts = ((JSONObject)localObject1).optInt("showTime");
          ((DrawerPushItem)localObject2).end_ts = ((JSONObject)localObject1).optInt("expireTime");
          if (((DrawerPushItem)localObject2).start_ts == 0)
          {
            ((DrawerPushItem)localObject2).start_ts = ((int)(System.currentTimeMillis() / 1000L));
            localObject3 = Calendar.getInstance();
            ((Calendar)localObject3).set(11, ((Calendar)localObject3).getActualMaximum(11));
            ((Calendar)localObject3).set(12, ((Calendar)localObject3).getActualMaximum(12));
            ((Calendar)localObject3).set(13, ((Calendar)localObject3).getActualMaximum(13));
            ((DrawerPushItem)localObject2).end_ts = ((int)(((Calendar)localObject3).getTimeInMillis() / 1000L));
          }
          ((DrawerPushItem)localObject2).send_time = ((JSONObject)localObject1).optInt("time");
          ((DrawerPushItem)localObject2).action_id = ((JSONObject)localObject1).optInt("actionId");
          ((DrawerPushItem)localObject2).content = ((JSONObject)localObject1).optString("bubbleText");
          ((DrawerPushItem)localObject2).bubble_res_id = ((JSONObject)localObject1).optInt("bubbleID");
          if (!paramBoolean) {
            break label962;
          }
          i = 2;
          ((DrawerPushItem)localObject2).target_model = i;
          i = ((JSONObject)localObject1).optInt("type");
          ((DrawerPushItem)localObject2).scheme = ((JSONObject)localObject1).optString("scheme");
          if (i == 0) {
            ((DrawerPushItem)localObject2).ext_url = ((JSONObject)localObject1).optString("url");
          } else if (i == 1) {
            ((DrawerPushItem)localObject2).ext_url = ApolloConstant.t;
          } else if (i == 2) {
            ((DrawerPushItem)localObject2).ext_url = ((JSONObject)localObject1).optString("url");
          }
          ((DrawerPushItem)localObject2).show_counts = ((JSONObject)localObject1).optInt("showCounts");
          if (((DrawerPushItem)localObject2).show_counts <= 0) {
            ((DrawerPushItem)localObject2).show_counts = 3;
          }
          ((DrawerPushItem)localObject2).tianshuAdId = ((JSONObject)localObject1).optInt("adId");
          ((DrawerPushItem)localObject2).tianshuTraceInfo = ((JSONObject)localObject1).optString("traceInfo");
          m = 2;
          j = m;
          QLog.d("[cmshow]ApolloManager", 1, new Object[] { "handleDrawerBubbleAdv addPushItem=", localObject2 });
          j = m;
          localObject1 = getApp();
          i = m;
          if (localObject1 != null)
          {
            j = m;
            ((ApolloDaoManagerServiceImpl)((AppRuntime)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all")).addPushItem((DrawerPushItem)localObject2, false);
            i = m;
          }
        }
        else
        {
          i = 2;
        }
      }
      catch (Throwable localThrowable2)
      {
        i = j;
        QLog.e("[cmshow]ApolloManager", 1, "handleDrawerBubbleAdv, parse exception=", localThrowable2);
      }
      k += 1;
      break;
      return;
      QLog.e("[cmshow]ApolloManager", 1, "handleDrawerBubbleAdv, data empty");
      return;
      label957:
      i = 2;
      continue;
      label962:
      i = 3;
    }
  }
  
  private void handleKapuDownloadAdv(TianShuAccess.RspEntry paramRspEntry)
  {
    QLog.d("[cmshow]ApolloManager", 1, "handleKapuDownloadAdv");
    if ((paramRspEntry != null) && (paramRspEntry.value != null) && (paramRspEntry.value.lst != null) && (paramRspEntry.value.lst.size() != 0))
    {
      int n = paramRspEntry.value.lst.size();
      QLog.d("[cmshow]ApolloManager", 1, new Object[] { "handleKapuDownloadAdv, size=", Integer.valueOf(n) });
      HashMap localHashMap = new HashMap();
      String str1 = "";
      int i = 0;
      int j = -1;
      while (i < n)
      {
        Object localObject1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(i)).argList.get();
        int m = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(i)).iAdId.get();
        QLog.d("[cmshow]ApolloManager", 1, new Object[] { "handleKapuDownloadAdv, adId=", Integer.valueOf(m), ", i=", Integer.valueOf(i) });
        int k;
        if (i == n - 1) {
          k = 1;
        } else {
          k = 0;
        }
        if (k != 0)
        {
          str1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(i)).traceinfo.get();
          j = m;
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (TianShuAccess.MapEntry)((Iterator)localObject1).next();
          String str2 = ((TianShuAccess.MapEntry)localObject2).key.get();
          localObject2 = ((TianShuAccess.MapEntry)localObject2).value.get();
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloManager", 2, new Object[] { "handleKapuDownloadAdv keyStr:", str2, ", valueStr=", localObject2 });
          }
          if ((k != 0) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
            localHashMap.put(str2, localObject2);
          }
        }
        i += 1;
      }
      App3DConfig.parse(localHashMap, j, str1);
      return;
    }
    QLog.e("[cmshow]ApolloManager", 1, "handleKapuDownloadAdv, data empty");
  }
  
  private void initApolloMsgObserver()
  {
    if (this.mMessageObserver != null) {
      return;
    }
    this.mMessageObserver = new ApolloManagerServiceImpl.1(this);
    AppInterface localAppInterface = getApp();
    if (localAppInterface != null)
    {
      MessageObserver localMessageObserver = this.mMessageObserver;
      if (localMessageObserver != null) {
        localAppInterface.addDefaultObservers(localMessageObserver);
      }
    }
  }
  
  private void initApolloStoreBroadcastReceiver()
  {
    this.mBroadcastReceiver = new ApolloManagerServiceImpl.ApolloManagerReceiver(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_APOLLO_STORE_CRASH_EVENT");
    try
    {
      BaseApplicationImpl.getContext().registerReceiver(this.mBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]ApolloManager", 1, "registerReceiver failed. ", localException);
    }
  }
  
  private static boolean initBasicScript()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(ApolloConstant.V);
        ((StringBuilder)localObject1).append("cmshow_script_0.js");
        Object localObject2 = ((StringBuilder)localObject1).toString();
        localObject1 = new File((String)localObject2);
        boolean bool3 = ((File)localObject1).exists();
        boolean bool2 = false;
        bool1 = bool2;
        if (bool3)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(".sig");
          if (new RSAVerify(localStringBuilder.toString(), (String)localObject2).a(1)) {
            break label222;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("verify fails, path:");
          localStringBuilder.append((String)localObject2);
          QLog.w("[cmshow]ApolloManager", 1, localStringBuilder.toString());
          bool1 = bool2;
        }
        if (bool1)
        {
          sBasicScript = FileUtils.readFileToString((File)localObject1);
          return bool1;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Fail to read script file. ");
        ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
        QLog.w("[cmshow]ApolloManager", 1, ((StringBuilder)localObject2).toString());
        return bool1;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[cmshow]ApolloManager", 1, "[loadScript],", localThrowable);
        return true;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("[cmshow]ApolloManager", 1, "[loadScript],OOM:", localOutOfMemoryError);
        return true;
      }
      label222:
      boolean bool1 = true;
    }
  }
  
  public static boolean initEngineScript()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(ApolloConstant.V);
        ((StringBuilder)localObject1).append("cmshow_script_engine.js");
        Object localObject2 = ((StringBuilder)localObject1).toString();
        localObject1 = new File((String)localObject2);
        boolean bool3 = ((File)localObject1).exists();
        boolean bool2 = false;
        bool1 = bool2;
        if (bool3)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(".sig");
          if (new RSAVerify(localStringBuilder.toString(), (String)localObject2).a(1)) {
            break label222;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("verify fails, path:");
          localStringBuilder.append((String)localObject2);
          QLog.w("[cmshow]ApolloManager", 1, localStringBuilder.toString());
          bool1 = bool2;
        }
        if (bool1)
        {
          sEngineScript = FileUtils.readFileToString((File)localObject1);
          return bool1;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Fail to initEngineScript ");
        ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
        QLog.w("[cmshow]ApolloManager", 1, ((StringBuilder)localObject2).toString());
        return bool1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("[cmshow]ApolloManager", 1, "initEngineScript:", localOutOfMemoryError);
        return true;
      }
      catch (Exception localException)
      {
        QLog.e("[cmshow]ApolloManager", 1, "initEngineScript:", localException);
        return true;
      }
      label222:
      boolean bool1 = true;
    }
  }
  
  private void initLastShopTabFromSP()
  {
    Object localObject = getApp();
    if (localObject == null) {
      return;
    }
    try
    {
      localObject = ((AppInterface)localObject).getCurrentAccountUin();
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("_");
      localStringBuilder.append("sp_key_last_shop_tab");
      this.mLastShopTab = localSharedPreferences.getString(localStringBuilder.toString(), "");
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      this.mLastShopTab = "";
      QLog.e("[cmshow]ApolloManager", 1, "initLastShopTabFromSP, get last shop tab exception:", localIllegalStateException);
    }
  }
  
  private void notifyApolloInitDone()
  {
    ??? = this.mInitCallbackList;
    if (??? != null)
    {
      if (???.size() == 0) {
        return;
      }
      synchronized (this.mInitCallbackList)
      {
        Iterator localIterator = this.mInitCallbackList.iterator();
        while (localIterator.hasNext()) {
          ((ApolloInitCallback)localIterator.next()).a();
        }
        return;
      }
    }
  }
  
  public static void notifyWebEngineReady()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject == null) {
      return;
    }
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    if ((localObject instanceof ToolAppRuntime))
    {
      localObject = ((AppRuntime)localObject).getAppRuntime("modular_web");
      if (!(localObject instanceof AppInterface)) {
        return;
      }
      localObject = ((AppInterface)localObject).getHandler(ApolloStoreActivity.class);
      if (localObject == null) {
        return;
      }
      ((MqqHandler)localObject).sendEmptyMessage(258);
      QLog.i("ApolloStoreActivity", 1, "send refresh apollo view msg");
    }
  }
  
  private void removeAllApolloInitCallback()
  {
    List localList = this.mInitCallbackList;
    if (localList != null)
    {
      if (localList.size() == 0) {
        return;
      }
      this.mInitCallbackList.clear();
      this.mInitCallbackList = null;
    }
  }
  
  public void addApolloStatusUpdateListener(ApolloStatusUpdateListener paramApolloStatusUpdateListener)
  {
    if (paramApolloStatusUpdateListener == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloManager", 2, new Object[] { "[setApolloStatusUpdateListener] listener=", paramApolloStatusUpdateListener });
    }
    this.mStatusUpdateListeners.add(new WeakReference(paramApolloStatusUpdateListener));
  }
  
  public boolean addToActionDownloadList(int paramInt)
  {
    return this.mActionDownloadList.add(Integer.valueOf(paramInt));
  }
  
  public boolean addToActionPlayList(long paramLong)
  {
    return this.mActionPlayList.add(Long.valueOf(paramLong));
  }
  
  public void addToBulkPullMap(String paramString, int paramInt)
  {
    Message localMessage = this.mAsyncSubThreadHandler.obtainMessage();
    localMessage.what = 4097;
    localMessage.arg1 = paramInt;
    localMessage.obj = paramString;
    this.mAsyncSubThreadHandler.sendMessage(localMessage);
  }
  
  public void bulkUpdateUserDress()
  {
    this.mAsyncSubThreadHandler.removeMessages(4096);
    this.mAsyncSubThreadHandler.sendEmptyMessage(4096);
  }
  
  public void checkActionJsonInterval()
  {
    AppInterface localAppInterface = getApp();
    if (localAppInterface != null)
    {
      if (localAppInterface.getApp() == null) {
        return;
      }
      long l = NetConnInfoCenter.getServerTime();
      Object localObject = localAppInterface.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("apollo_sp");
      localStringBuilder.append(localAppInterface.getCurrentUin());
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
      if (l - ((SharedPreferences)localObject).getLong("sp_key_apollo_check_action_time", 0L) > 300L)
      {
        ApolloContentUpdateHandler.a(localAppInterface, 1);
        ((SharedPreferences)localObject).edit().putLong("sp_key_apollo_check_action_time", l).commit();
      }
    }
  }
  
  public void clickPushItem(DrawerPushItem paramDrawerPushItem, QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if ((paramDrawerPushItem != null) && (paramQQAppInterface != null))
    {
      if (paramContext == null) {
        return;
      }
      CmShowLauncher.a(paramQQAppInterface, paramContext, paramDrawerPushItem.scheme, paramDrawerPushItem.ext_url, paramString);
    }
  }
  
  public void decodeApolloBubblePushData(byte[] paramArrayOfByte)
  {
    Object localObject = new submsgtype0xdc.MsgBody();
    for (;;)
    {
      try
      {
        ((submsgtype0xdc.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        if (((submsgtype0xdc.MsgBody)localObject).uint32_msg_type.has())
        {
          i = ((submsgtype0xdc.MsgBody)localObject).uint32_msg_type.get();
          if (((submsgtype0xdc.MsgBody)localObject).minQqVer.has())
          {
            paramArrayOfByte = ((submsgtype0xdc.MsgBody)localObject).minQqVer.get();
            if ((!TextUtils.isEmpty(paramArrayOfByte)) && (VersionUtil.a("8.8.17", paramArrayOfByte) < 0))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("decodeApolloBubblePushData push but cur version not support:");
              ((StringBuilder)localObject).append(paramArrayOfByte);
              QLog.i("[cmshow]ApolloManager", 1, ((StringBuilder)localObject).toString());
              return;
            }
          }
          paramArrayOfByte = getApp();
          if (paramArrayOfByte == null) {
            return;
          }
          paramArrayOfByte = (ApolloDaoManagerServiceImpl)paramArrayOfByte.getRuntimeService(IApolloDaoManagerService.class, "all");
          if ((i == 2) && (((submsgtype0xdc.MsgBody)localObject).rpt_msg_list_0x02.has()))
          {
            localObject = ((submsgtype0xdc.MsgBody)localObject).rpt_msg_list_0x02.get();
            if ((localObject != null) && (((List)localObject).size() > 0)) {
              paramArrayOfByte.saveBubblePushData(i, (List)localObject);
            }
          }
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("[decodeApolloBubblePushData], decode complete msgType:");
          paramArrayOfByte.append(i);
          QLog.i("[cmshow]ApolloManager", 1, paramArrayOfByte.toString());
          return;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        QLog.e("[cmshow]ApolloManager", 1, new Object[] { "[decodeApolloBubblePushData], errInfo->", paramArrayOfByte.getMessage() });
        return;
      }
      int i = 0;
    }
  }
  
  public void deleteCMSLocalPath(IApolloResManager paramIApolloResManager)
  {
    Object localObject1 = getMemeActionList();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ApolloActionData)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          this.mCMSFrameCache.remove(Integer.valueOf(((ApolloActionData)localObject2).actionId));
          localObject2 = paramIApolloResManager.a((ApolloActionData)localObject2, 10);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            Object localObject3 = new File((String)localObject2);
            if (((File)localObject3).exists())
            {
              FileUtils.deleteFile((File)localObject3);
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("deleteCMSLocalPath : ");
              ((StringBuilder)localObject3).append((String)localObject2);
              QLog.d("[cmshow]ApolloManager", 1, ((StringBuilder)localObject3).toString());
            }
          }
        }
      }
    }
  }
  
  public void doAfterOpenAIO(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    ThreadManagerV2.executeOnSubThread(new ApolloManagerServiceImpl.3(this, paramSessionInfo));
    ThreadManagerV2.executeOnSubThread(new ApolloManagerServiceImpl.4(this));
    AppInterface localAppInterface = getApp();
    if ((!CmShowAioMatcherImpl.judgeSupported(paramSessionInfo.a)) && (localAppInterface != null) && (NetworkUtil.isNetworkAvailable(localAppInterface.getApp()))) {
      return;
    }
    this.mActionPlayList.clear();
    if ((paramSessionInfo.a == 1) && (localAppInterface != null) && (((HotChatManager)localAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(paramSessionInfo.b) != null)) {
      return;
    }
    if ((localAppInterface != null) && (1 != getApolloStatus(localAppInterface.getCurrentUin())))
    {
      if (QLog.isColorLevel())
      {
        paramSessionInfo = new StringBuilder();
        paramSessionInfo.append("doAfterOpenAIO: apollo function is not opened status: ");
        paramSessionInfo.append(getApolloStatus(localAppInterface.getCurrentUin()));
        QLog.d("[cmshow]ApolloManager", 2, paramSessionInfo.toString());
      }
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ApolloManagerServiceImpl.5(this, paramSessionInfo, paramQQAppInterface));
  }
  
  public int getAVIPLevel(String paramString)
  {
    paramString = getApolloBaseInfo(paramString);
    int i = 1;
    if (paramString != null)
    {
      if (paramString.apolloVipLevel < 1) {
        return 1;
      }
      i = paramString.apolloVipLevel;
    }
    return i;
  }
  
  public boolean getAVIPStatus(String paramString)
  {
    paramString = getApolloBaseInfo(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.apolloVipFlag == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String getApolloAppearAction(QQAppInterface paramQQAppInterface, String paramString)
  {
    ApolloBaseInfo localApolloBaseInfo = getApolloBaseInfo(paramString);
    if (localApolloBaseInfo == null) {
      return null;
    }
    try
    {
      long l;
      if (this.mPullStandActionMap.get(paramString) == null) {
        l = 0L;
      } else {
        l = ((Long)this.mPullStandActionMap.get(paramString)).longValue();
      }
      if ((localApolloBaseInfo.appearAction == null) && (NetConnInfoCenter.getServerTime() - l > 180L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloManager", 2, new Object[] { "getApolloAppearAction request appear action uin:", paramString.substring(0, 4) });
        }
        ((ApolloExtensionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(new long[] { Long.parseLong(paramString) });
        this.mPullStandActionMap.put(paramString, Long.valueOf(NetConnInfoCenter.getServerTime()));
        return null;
      }
      if (localApolloBaseInfo.appearAction == null)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("[cmshow]ApolloManager", 2, "getApolloAppearAction request appear action is null and last request is near");
          return null;
        }
      }
      else
      {
        paramQQAppInterface = new JSONObject(localApolloBaseInfo.appearAction).optJSONArray("action").toString();
        return paramQQAppInterface;
      }
    }
    catch (JSONException paramQQAppInterface)
    {
      QLog.e("[cmshow]ApolloManager", 1, "getApolloAppearAction e:", paramQQAppInterface);
      return null;
    }
    return null;
  }
  
  @Deprecated
  public ApolloBaseInfo getApolloBaseInfo(String paramString)
  {
    AppInterface localAppInterface = getApp();
    if (localAppInterface != null) {
      return ((IApolloDaoManagerService)localAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(paramString);
    }
    return null;
  }
  
  public ApolloPanelManager getApolloPanelManager()
  {
    if (this.mApolloPanelManager == null)
    {
      AppInterface localAppInterface = getApp();
      if (localAppInterface != null) {
        this.mApolloPanelManager = new ApolloPanelManager(localAppInterface);
      }
    }
    return this.mApolloPanelManager;
  }
  
  public int getApolloStatus(String paramString)
  {
    paramString = getApolloBaseInfo(paramString);
    if (paramString != null) {
      return paramString.apolloStatus;
    }
    return 0;
  }
  
  public int getApolloUserStatus()
  {
    Object localObject2 = getApp();
    int k = 0;
    if (localObject2 == null)
    {
      QLog.e("[cmshow]ApolloManager", 1, "getApolloUserStatus app is null, return default 0");
      return 0;
    }
    if (!isHardwareSupport(BaseApplicationImpl.getContext()))
    {
      QLog.e("[cmshow]ApolloManager", 1, "getApolloUserStatus !isHardwareSupport, return default 0");
      return 0;
    }
    checkDpcSwitch();
    if ((!sApolloSwitch) && (!sCmShow3dDPCSwitch))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getApolloUserStatus sApolloSwitch : ");
      ((StringBuilder)localObject1).append(sApolloSwitch);
      ((StringBuilder)localObject1).append("; sCmShow3dDPCSwitch : ");
      ((StringBuilder)localObject1).append(sCmShow3dDPCSwitch);
      QLog.e("[cmshow]ApolloManager", 1, ((StringBuilder)localObject1).toString());
      return 0;
    }
    Object localObject1 = getApolloBaseInfoFromCache(((AppRuntime)localObject2).getCurrentUin());
    int j = k;
    if (localObject1 != null)
    {
      j = k;
      if (((ApolloBaseInfo)localObject1).apolloStatus == 1)
      {
        boolean bool;
        if ((sCmShow3dDPCSwitch) && (get3dWhiteListStatus((AppRuntime)localObject2) == 1)) {
          bool = true;
        } else {
          bool = false;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("is3dAvailable ");
        ((StringBuilder)localObject2).append(bool);
        QLog.d("[cmshow]ApolloManager", 1, ((StringBuilder)localObject2).toString());
        if ((bool) && ((((ApolloBaseInfo)localObject1).cmshow3dFlag & 0x1) == 1)) {
          return 2;
        }
        int i;
        if ((sApolloSwitch) && (getWhiteListStatus() == 1)) {
          i = 1;
        } else {
          i = 0;
        }
        j = k;
        if (i != 0) {
          j = 1;
        }
      }
    }
    return j;
  }
  
  public BubbleProducer getBubbleProducer()
  {
    if (this.mBubbleProducer == null) {
      try
      {
        if (this.mBubbleProducer == null) {
          this.mBubbleProducer = new BubbleProducer(this, getApp());
        }
      }
      finally {}
    }
    return this.mBubbleProducer;
  }
  
  public int getCmShowStatus(String paramString)
  {
    return getCmShowStatus(paramString, true);
  }
  
  public int getCmShowStatus(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloManager", 2, new Object[] { "[getCmShowStatus] withStrictCheck=", Boolean.valueOf(paramBoolean) });
    }
    AppInterface localAppInterface = getApp();
    if (localAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return 0;
      }
      paramString = getApolloBaseInfoFromCache(paramString);
      if (paramString == null) {
        return 0;
      }
      if (paramBoolean)
      {
        if (!isHardwareSupport(BaseApplicationImpl.getContext())) {
          return 0;
        }
        checkDpcSwitch();
        if ((!sApolloSwitch) && (!sCmShow3dDPCSwitch)) {
          return 0;
        }
        ApolloBaseInfo localApolloBaseInfo = getApolloBaseInfoFromCache(localAppInterface.getCurrentUin());
        if (localApolloBaseInfo != null)
        {
          if (localApolloBaseInfo.apolloStatus != 1) {
            return 0;
          }
          if (paramString.apolloStatus != 1) {
            return 0;
          }
          if ((sCmShow3dDPCSwitch) && (get3dWhiteListStatus(localAppInterface) == 1) && ((paramString.cmshow3dFlag & 0x2) == 2) && ((paramString.cmshow3dFlag & 0x1) == 1)) {
            return 2;
          }
          if ((!sApolloSwitch) || (getWhiteListStatus() != 1) || ((paramString.cmshow3dFlag & 0x1) != 0)) {
            return 0;
          }
        }
        else
        {
          return 0;
        }
      }
      else
      {
        if (paramString.apolloStatus != 1) {
          return 0;
        }
        if (((paramString.cmshow3dFlag & 0x2) == 2) && ((paramString.cmshow3dFlag & 0x1) == 1)) {
          return 2;
        }
      }
      return 1;
    }
    return 0;
  }
  
  public int getCmShowStatusNoCareSelfStatus(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloManager", 2, new Object[] { "[getCmShowStatus] withStrictCheck=", Boolean.valueOf(paramBoolean) });
    }
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return 0;
      }
      paramAppRuntime = getApolloBaseInfoFromCache(paramString);
      if (paramAppRuntime == null) {
        return 0;
      }
      if (paramBoolean)
      {
        if (!isHardwareSupport(BaseApplicationImpl.getContext())) {
          return 0;
        }
        checkDpcSwitch();
        if ((!sApolloSwitch) && (!sCmShow3dDPCSwitch)) {
          return 0;
        }
        if (paramAppRuntime.apolloStatus != 1) {
          return 0;
        }
        if ((sCmShow3dDPCSwitch) && ((paramAppRuntime.cmshow3dFlag & 0x2) == 2) && ((paramAppRuntime.cmshow3dFlag & 0x1) == 1)) {
          return 2;
        }
        if ((!sApolloSwitch) || ((paramAppRuntime.cmshow3dFlag & 0x1) != 0)) {
          return 0;
        }
      }
      else if (((paramAppRuntime.cmshow3dFlag & 0x2) == 2) && ((paramAppRuntime.cmshow3dFlag & 0x1) == 1))
      {
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  public boolean getConfigInitDone()
  {
    return this.mConfigInitDone.get();
  }
  
  public DrawerPushItem getCurrentPushItem(int paramInt)
  {
    AppInterface localAppInterface = getApp();
    if (localAppInterface == null) {
      return null;
    }
    int j = ApolloUtilImpl.getApolloUserStatus(getApp());
    int i = 2;
    if (j != 1) {
      if (j != 2) {
        i = 0;
      } else {
        i = 3;
      }
    }
    return ((ApolloDaoManagerServiceImpl)localAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getCurrentPushItemByUserStatus(paramInt, i);
  }
  
  public int getDrawerStatus(QQAppInterface paramQQAppInterface)
  {
    int j = -1;
    if (paramQQAppInterface == null) {
      return -1;
    }
    boolean bool1 = isApolloSupport(paramQQAppInterface.getApplication());
    if (bool1) {
      j = 0;
    }
    boolean bool2 = CMShowPlatform.a.a(Scene.DRAWER);
    int m = getApolloUserStatus();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getDrawerStatus isEngineReady : ");
    ((StringBuilder)localObject).append(bool2);
    ((StringBuilder)localObject).append("; apolloStatus : ");
    ((StringBuilder)localObject).append(m);
    ((StringBuilder)localObject).append("; isApolloOpen : ");
    ((StringBuilder)localObject).append(bool1);
    QLog.d("[cmshow]ApolloManager", 1, ((StringBuilder)localObject).toString());
    if (m > 0) {
      k = 1;
    } else {
      k = 0;
    }
    int i = j;
    if (bool2)
    {
      i = j;
      if (k != 0) {
        if (m == 1) {
          i = 1;
        } else {
          i = 6;
        }
      }
    }
    localObject = getApolloBaseInfo(paramQQAppInterface.getCurrentAccountUin());
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get_user_apollo_info_drawer_dress_sp");
    localStringBuilder.append(paramQQAppInterface.getCurrentUin());
    int k = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).getInt("model", 0);
    j = i;
    if (bool2)
    {
      j = i;
      if (m == 0)
      {
        j = i;
        if (((ApolloBaseInfo)localObject).apolloDrawerStatus == 1)
        {
          if (k == 1) {
            return 6;
          }
          j = 1;
        }
      }
    }
    return j;
  }
  
  public String getGuestUrl(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return ApolloConstant.I;
    }
    return add3DInteractParams(getApp(), ApolloConstant.O, paramString);
  }
  
  public String getLastTabUrl(int paramInt, String paramString)
  {
    int j = getApolloUserStatus();
    boolean bool = is3dAvailable();
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("3d"))) {
      paramInt = 2;
    } else {
      paramInt = 1;
    }
    int i;
    if ((!bool) && (j == paramInt))
    {
      str = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getStoreTabUrl(paramString, true);
      i = 1;
    }
    else
    {
      str = "";
      i = 0;
    }
    if ((TextUtils.isEmpty(str)) || (i == 0)) {
      if (j == 2) {
        str = ApolloConstant.O;
      } else if (bool) {
        str = ApolloConstant.Q;
      } else {
        str = ApolloConstant.I;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getLastTabUrl userStatus:");
    localStringBuilder.append(j);
    localStringBuilder.append(",tabStatus:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",tabScheme:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",is3DAvailable:");
    localStringBuilder.append(bool);
    localStringBuilder.append(",url:");
    localStringBuilder.append(str);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloManager", 2, localStringBuilder.toString());
    }
    paramString = str;
    if (!TextUtils.isEmpty(ApolloConstant.O))
    {
      paramString = str;
      if (ApolloConstant.O.equals(str)) {
        paramString = add3DInteractParams(getApp(), str, null);
      }
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      str = ApolloConstant.I;
      QLog.d("[cmshow]ApolloManager", 1, new Object[] { "url is empty", localStringBuilder.toString() });
    }
    return str;
  }
  
  public List<ApolloActionData> getMemeActionList()
  {
    Object localObject = getApp();
    if (localObject == null) {
      return null;
    }
    localObject = (ApolloDaoManagerServiceImpl)((AppRuntime)localObject).getRuntimeService(IApolloDaoManagerService.class, "all");
    if (localObject != null) {
      return ((ApolloDaoManagerServiceImpl)localObject).getActionByPackageId(9);
    }
    return null;
  }
  
  public int getOpenType()
  {
    return this.openType;
  }
  
  public String getPetBrandClickActionUrl(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    return paramJSONObject.optString("petBrandClickActionUrl");
  }
  
  public int getPetCategory(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return 0;
    }
    paramJSONObject = paramJSONObject.optString("petCategory");
    if (!TextUtils.isEmpty(paramJSONObject)) {
      try
      {
        int i = Integer.parseInt(paramJSONObject);
        return i;
      }
      catch (NumberFormatException paramJSONObject)
      {
        QLog.e("[cmshow]ApolloPet", 1, "getPetCategory error:", paramJSONObject);
      }
    }
    return 0;
  }
  
  public String getPetClickActionUrl(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    return paramJSONObject.optString("petClickActionUrl");
  }
  
  public String getPetId(String paramString)
  {
    try
    {
      paramString = getApolloBaseInfo(paramString);
      if (paramString == null) {
        return "";
      }
      paramString = paramString.getApolloPetDress();
      if (paramString == null) {
        return "";
      }
      int i = paramString.roleId;
      return String.valueOf(i);
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public JSONObject getPetInfo(int paramInt)
  {
    Object localObject = this.mPetConfig;
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = new JSONArray((String)localObject);
      int j = ((JSONArray)localObject).length();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        int k = localJSONObject.optInt("roleId");
        if (k == paramInt) {
          return localJSONObject;
        }
        i += 1;
      }
      return null;
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]ApolloPet", 1, "getPetInfo error:", localException);
    }
  }
  
  public int getPetRandomAction(int paramInt)
  {
    try
    {
      if (this.mPetConfig == null) {
        return -1;
      }
      JSONArray localJSONArray = new JSONArray(this.mPetConfig);
      int j = localJSONArray.length();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        if (localJSONObject.getInt("roleId") == paramInt)
        {
          localJSONArray = localJSONObject.getJSONArray("petStateMapping").getJSONObject(0).getJSONArray("actionSet");
          paramInt = localJSONArray.length();
          paramInt = ((Integer)localJSONArray.get(new Random().nextInt(paramInt))).intValue();
          return paramInt;
        }
        i += 1;
      }
      return -1;
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]ApolloPet", 1, "getPetRandomAction error:", localException);
    }
  }
  
  public ApolloActionData getRandomAppearAction(IApolloResManager paramIApolloResManager, QQAppInterface paramQQAppInterface, String paramString, int... paramVarArgs)
  {
    Object localObject;
    HashSet localHashSet;
    int j;
    int i;
    if ((paramQQAppInterface != null) && (paramString != null) && (paramVarArgs != null))
    {
      if (paramIApolloResManager == null) {
        return null;
      }
      localObject = getApolloBaseInfo(paramString);
      if (localObject == null) {
        return null;
      }
      localHashSet = new HashSet();
      j = paramVarArgs.length;
      i = 0;
      while (i < j)
      {
        int k = paramVarArgs[i];
        if ((k != 4) || (((ApolloBaseInfo)localObject).hasPet)) {
          localHashSet.add(Integer.valueOf(k));
        }
        i += 1;
      }
    }
    for (;;)
    {
      try
      {
        paramString = getApolloAppearAction(paramQQAppInterface, paramString);
        if (paramString == null) {
          return null;
        }
        paramString = new JSONArray(paramString);
        j = paramString.length();
        paramVarArgs = new ArrayList();
        i = 0;
        if (i < j)
        {
          localObject = paramString.getJSONObject(i);
          if ((localObject == null) || (!localHashSet.contains(Integer.valueOf(((JSONObject)localObject).getInt("type"))))) {
            break label486;
          }
          paramVarArgs.add(localObject);
          break label486;
        }
        if (paramVarArgs.size() != 0)
        {
          paramString = (JSONObject)paramVarArgs.get(ApolloUtilImpl.getPositiveRandomInteger(paramVarArgs.size()));
          if (paramString != null)
          {
            i = paramString.getInt("id");
            j = paramString.getInt("type");
          }
          else
          {
            QLog.e("[cmshow]ApolloManager", 1, "[getRandomAppearAction] found empty json obj");
            break label495;
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label495;
          }
          QLog.d("[cmshow]ApolloManager", 2, "[getRandomAppearAction]found empty json arr ");
          break label495;
        }
        if (i > 0)
        {
          if (paramIApolloResManager.c(i, 0))
          {
            paramIApolloResManager = new ApolloActionData();
            paramIApolloResManager.actionId = i;
            if (j == 4) {
              paramIApolloResManager.actionType = 7;
            }
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]ApolloManager", 2, new Object[] { "getRandomAppearAction actionId:", Integer.valueOf(i), ",type:", Integer.valueOf(j) });
            }
            return paramIApolloResManager;
          }
          paramVarArgs = new ApolloActionData();
          paramVarArgs.actionId = i;
          paramString = paramIApolloResManager.a(paramVarArgs, 5);
          paramVarArgs = paramIApolloResManager.a(paramVarArgs, 4);
          paramIApolloResManager.a().a(paramQQAppInterface, paramVarArgs, paramString);
          paramIApolloResManager = new StringBuilder();
          paramIApolloResManager.append("getRandomAppearAction action resource not ready,actionId:");
          paramIApolloResManager.append(i);
          QLog.w("[cmshow]ApolloManager", 2, paramIApolloResManager.toString());
        }
        return null;
      }
      catch (Throwable paramIApolloResManager)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("[getRandomAppearAction]:");
        paramQQAppInterface.append(paramIApolloResManager);
        QLog.e("[cmshow]ApolloManager", 1, paramQQAppInterface.toString());
      }
      return null;
      label486:
      i += 1;
      continue;
      label495:
      j = 0;
      i = 0;
    }
  }
  
  public SharedPreferences getStandUpSp()
  {
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "noLogin";
    }
    localObject2 = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_stand_up");
    localStringBuilder.append((String)localObject1);
    return ((BaseApplicationImpl)localObject2).getSharedPreferences(localStringBuilder.toString(), 4);
  }
  
  public String getTabActionAvatar()
  {
    if (!CmShowWnsUtils.X()) {
      return "";
    }
    Object localObject1 = getApp();
    if (localObject1 != null)
    {
      String str = ((AppInterface)localObject1).getCurrentAccountUin();
      Object localObject2 = (ApolloDaoManagerServiceImpl)((AppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all");
      int j = 0;
      int k = 0;
      int i = 0;
      try
      {
        if (getCmShowStatus(str) == 2)
        {
          str = ((ApolloDaoManagerServiceImpl)localObject2).getCommConfigValueByCache("gif_tab_action_3d");
          if (!TextUtils.isEmpty(str)) {
            i = Integer.parseInt(str);
          }
          QLog.e("[cmshow]ApolloManager", 1, "getUserAvatar : APOLLO_USER_3D");
        }
        else
        {
          i = k;
          if (getCmShowStatus(str) == 1)
          {
            str = ((ApolloDaoManagerServiceImpl)localObject2).getCommConfigValueByCache("gif_tab_action_2d");
            i = j;
            if (!TextUtils.isEmpty(str)) {
              i = Integer.parseInt(str);
            }
            QLog.e("[cmshow]ApolloManager", 1, "getUserAvatar : APOLLO_USER_2D");
          }
        }
        if (i == 0)
        {
          ((ApolloDaoManagerServiceImpl)localObject2).getCommConfigKvLists();
          return "";
        }
        localObject1 = (IApolloDaoManagerService)((AppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all");
        if (localObject1 == null) {
          return "";
        }
        localObject1 = ((IApolloDaoManagerService)localObject1).findActionById(i);
        if (localObject1 == null) {
          return "";
        }
        localObject2 = ApolloResManagerFacade.a.a(Scene.AIO);
        if (localObject2 == null) {
          return "";
        }
        str = ((IApolloResManager)localObject2).a((ApolloActionData)localObject1, 10);
        if ((!TextUtils.isEmpty(str)) && (new File(str).exists())) {
          return str;
        }
        handleMemeGetFrame("apolloPanel", (ApolloActionData)localObject1, null, (IApolloResManager)localObject2);
        return "";
      }
      catch (Exception localException)
      {
        QLog.e("[cmshow]ApolloManager", 1, "getUserAvatar : failed", localException);
      }
    }
    return "";
  }
  
  public String getUinForReload()
  {
    return this.mUinForReload;
  }
  
  public HashMap<Integer, Bundle> getUserActionId()
  {
    return this.mUserActionId;
  }
  
  public int getWhiteListStatus()
  {
    try
    {
      if (sWhiteUserStatus == -1)
      {
        sWhiteUserStatus = 0;
        Object localObject1 = getApp();
        if (localObject1 != null)
        {
          int i = SharedPreUtils.y(((AppRuntime)localObject1).getApplication());
          if (i == 0)
          {
            localObject2 = ((AppRuntime)localObject1).getApplication().getSharedPreferences("apollo_sp", 0);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(((AppRuntime)localObject1).getAccount());
            localStringBuilder.append("_whiteList");
            sWhiteUserStatus = ((SharedPreferences)localObject2).getInt(localStringBuilder.toString(), 0);
          }
          else if (1 == i)
          {
            sWhiteUserStatus = 1;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("white list global: ");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(", mWhiteUserStatus: ");
          ((StringBuilder)localObject1).append(sWhiteUserStatus);
          QLog.d("[cmshow]ApolloManager", 1, ((StringBuilder)localObject1).toString());
        }
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getWhiteListStatus error = ");
      ((StringBuilder)localObject2).append(localThrowable.toString());
      QLog.d("[cmshow]ApolloManager", 1, ((StringBuilder)localObject2).toString());
    }
    return sWhiteUserStatus;
  }
  
  public void handleMemeGetFrame(String paramString, ApolloActionData paramApolloActionData, GetFrameCallback paramGetFrameCallback, IApolloResManager paramIApolloResManager)
  {
    ThreadManager.getSubThreadHandler().post(new ApolloManagerServiceImpl.8(this, paramApolloActionData, paramIApolloResManager, paramGetFrameCallback));
  }
  
  public void initApolloConfig()
  {
    if (this.mIsInitConfig) {
      return;
    }
    this.mIsInitConfig = true;
    ApolloConfProcessor.a();
    ApolloGrayConfProcessor.a();
  }
  
  public void initCmShowBaseScript(boolean paramBoolean)
  {
    boolean bool = initEngineScript();
    initBasicScript();
    if (!bool)
    {
      if (TextUtils.isEmpty(ApolloConstant.U))
      {
        ApolloConfProcessor.b();
        return;
      }
      if (!paramBoolean) {
        ApolloContentUpdateHandler.a(getApp());
      }
    }
  }
  
  public void initDataAfterConfig()
  {
    Object localObject = getApp();
    if (localObject == null) {
      return;
    }
    localObject = (ApolloContentUpdateHandler)((AppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.APOLLO_CONTENT_UPDATE_HANDLER);
    if ((localObject != null) && (((ApolloContentUpdateHandler)localObject).c.get()))
    {
      QLog.w("[cmshow]ApolloManager", 1, "config is done, then request update");
      ArrayList localArrayList = new ArrayList();
      ((ApolloContentUpdateHandler)localObject).b(localArrayList);
      ((ApolloContentUpdateHandler)localObject).a(localArrayList);
      ((ApolloContentUpdateHandler)localObject).c.set(false);
    }
  }
  
  public void initTextureViewConfig(JSONObject paramJSONObject)
  {
    int j = Build.VERSION.SDK_INT;
    boolean bool2 = true;
    if (paramJSONObject != null)
    {
      Object localObject;
      if (paramJSONObject.optInt("all") == 1)
      {
        this.mUseTextureViewConfig = true;
      }
      else
      {
        localObject = paramJSONObject.optJSONArray("sdkIntArray");
        int k;
        int i;
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          k = ((JSONArray)localObject).length();
          i = 0;
        }
        while (i < k) {
          if (((JSONArray)localObject).optInt(i) == j)
          {
            this.mUseTextureViewConfig = true;
          }
          else
          {
            this.mUseTextureViewConfig = false;
            i += 1;
            continue;
            this.mUseTextureViewConfig = false;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initTextureViewConfig jsonObject:");
        ((StringBuilder)localObject).append(paramJSONObject);
        QLog.i("[cmshow]ApolloManager", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      boolean bool1 = bool2;
      if (j != 19) {
        if (j == 23) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      this.mUseTextureViewConfig = bool1;
    }
    if (Build.MODEL.contains("MI 4")) {
      this.mUseTextureViewConfig = false;
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("initTextureViewConfig mUseTextureViewConfig:");
    paramJSONObject.append(this.mUseTextureViewConfig);
    QLog.i("[cmshow]ApolloManager", 2, paramJSONObject.toString());
  }
  
  public boolean is3dAvailable()
  {
    AppInterface localAppInterface = getApp();
    if (localAppInterface == null) {
      return false;
    }
    if (!isHardwareSupport(BaseApplicationImpl.getContext()))
    {
      QLog.w("[cmshow]ApolloManager", 1, "[is3dAvailable] isHardwareSupport false");
      return false;
    }
    checkDpcSwitch();
    if (!sCmShow3dDPCSwitch)
    {
      QLog.w("[cmshow]ApolloManager", 1, "[is3dAvailable] dpc switch off");
      return false;
    }
    ApolloBaseInfo localApolloBaseInfo = getApolloBaseInfoFromCache(localAppInterface.getCurrentUin());
    if (localApolloBaseInfo == null)
    {
      QLog.w("[cmshow]ApolloManager", 1, "[is3dAvailable] no baseInfo");
      return false;
    }
    boolean bool;
    if ((localApolloBaseInfo.apolloStatus == 1) && (get3dWhiteListStatus(localAppInterface) == 1)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloManager", 2, new Object[] { "[is3dAvailable] is3dAvailable=", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public boolean isApolloBackgroundActionSwitchOpen()
  {
    return queryApolloSwitchSet("eggSwitch") == 1;
  }
  
  public boolean isApolloEngineLockEnable()
  {
    return this.sApolloEngineLockEnable;
  }
  
  public boolean isApolloSupport(Context paramContext)
  {
    return isApolloSupport(paramContext, Boolean.valueOf(true));
  }
  
  public boolean isApolloSupport(Context paramContext, Boolean paramBoolean)
  {
    if (!isHardwareSupport(paramContext)) {
      return false;
    }
    checkDpcSwitch();
    if ((!sApolloSwitch) && (!sCmShow3dDPCSwitch)) {
      return false;
    }
    if (paramBoolean.booleanValue())
    {
      if ((sApolloSwitch) && (getWhiteListStatus() == 1)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (sCmShow3dDPCSwitch) {
          if (get3dWhiteListStatus(CmGameUtil.b()) == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          }
        }
      }
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = DeviceInfoUtils.isLowPerfDevice() ^ true;
      }
      return bool2;
    }
    return true;
  }
  
  public boolean isDisableCreateRenderThread()
  {
    return this.mDisableCreateRenderThread;
  }
  
  public boolean isHardwareSupport(Context paramContext)
  {
    return ApolloHardWareTester.a(paramContext);
  }
  
  public boolean isInActionDownloadList(int paramInt)
  {
    return this.mActionDownloadList.contains(Integer.valueOf(paramInt));
  }
  
  public boolean isInActionPlayList(long paramLong)
  {
    return this.mActionPlayList.contains(Long.valueOf(paramLong));
  }
  
  public boolean isInitDone()
  {
    return sInitDone;
  }
  
  public boolean isSuperYellow(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      AppInterface localAppInterface = getApp();
      if ((localAppInterface != null) && (paramString.equals(localAppInterface.getCurrentAccountUin()))) {
        return QZoneVipInfoManager.a().c();
      }
      paramString = getApolloBaseInfo(paramString);
      return (paramString != null) && (paramString.superYellowDiamondFlag == 1);
    }
    return false;
  }
  
  public boolean isUseTextureViewConfig()
  {
    return this.mUseTextureViewConfig;
  }
  
  public void notify3dFlagUpdate(int paramInt1, int paramInt2)
  {
    QLog.d("[cmshow]ApolloManager", 1, new Object[] { "[notify3dFlagUpdate] previous3dFlag=", Integer.valueOf(paramInt1), ", new3dFlag=", Integer.valueOf(paramInt2) });
    if (((paramInt1 & 0x1) != (paramInt2 & 0x1)) || ((paramInt1 & 0x2) != (paramInt2 & 0x2)))
    {
      paramInt1 = ApolloUtilImpl.getApolloUserStatus(getApp());
      boolean bool = is3dAvailable();
      QLog.d("[cmshow]ApolloManager", 1, new Object[] { "[notify3dFlagUpdate] currentStatus=", Integer.valueOf(paramInt1), ", is3dAvailable=", Boolean.valueOf(bool) });
      Object localObject = this.mStatusUpdateListeners;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ApolloStatusUpdateListener localApolloStatusUpdateListener = (ApolloStatusUpdateListener)((WeakReference)((Iterator)localObject).next()).get();
          if (localApolloStatusUpdateListener != null) {
            localApolloStatusUpdateListener.a(paramInt1, bool);
          }
        }
      }
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    QLog.e("[cmshow]ApolloManager", 1, "[onCreate] init success!");
    if ((paramAppRuntime instanceof AppInterface))
    {
      this.mAppInterface = ((AppInterface)paramAppRuntime);
      sWhiteUserStatus = -1;
      s3dWhiteUserStatus = -1;
      sBulkPullDressList.clear();
      sBulkApolloInfoList.clear();
      if (isHardwareSupport(paramAppRuntime.getApp()))
      {
        CmGameServerQIPCModule.c();
        ThreadManager.getSubThreadHandler().post(this.asyncInitDataRunnable);
      }
      initApolloStoreBroadcastReceiver();
      initApolloMsgObserver();
      ApolloResManagerFacade.a.a(paramAppRuntime);
      return;
    }
    QLog.e("[cmshow]ApolloManager", 2, "[onCreate] error: not init in AppInterface!");
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloManager", 2, "onDestroy.");
    }
    if (this.mBroadcastReceiver != null) {
      try
      {
        BaseApplicationImpl.getContext().unregisterReceiver(this.mBroadcastReceiver);
        this.mBroadcastReceiver = null;
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloManager", 2, "onDestroy. unregisterReceiver mBroadcastReceiver success");
        }
      }
      catch (Exception localException)
      {
        QLog.e("[cmshow]ApolloManager", 1, localException, new Object[0]);
      }
    }
    this.mIsInitConfig = false;
    ApolloUtilImpl.clearFlag();
    sWhiteUserStatus = -1;
    s3dWhiteUserStatus = -1;
    ApolloResHelperImpl.sRoleDefaultDress.clear();
    this.mActionDownloadList.clear();
    this.mAsyncSubThreadHandler.removeCallbacksAndMessages(null);
    sInitDone = false;
    com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.a = 0;
    this.mConfigInitDone.set(false);
    Object localObject = this.mApolloPanelManager;
    if (localObject != null)
    {
      ((ApolloPanelManager)localObject).e();
      this.mApolloPanelManager = null;
    }
    ApolloGameStateMachine.f();
    ApolloGameUtil.a();
    ApolloConfigDataReport.c();
    removeAllApolloInitCallback();
    localObject = CmGameServerQIPCModule.b().a();
    if (localObject != null) {
      ((CmGameLifeCycleMgr)localObject).a();
    }
    TraceReportInstance.a().c();
    sBasicScript = null;
    localObject = this.mGlobalTimer;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.mGlobalTimer.purge();
      this.mGlobalTimer = null;
    }
    mCallbackMap.clear();
    localObject = getApp();
    if (localObject != null)
    {
      MessageObserver localMessageObserver = this.mMessageObserver;
      if (localMessageObserver != null) {
        ((AppInterface)localObject).removeObserver(localMessageObserver);
      }
    }
    MemeBornPlayerManager.a.a();
    ApolloResManagerFacade.a.b();
  }
  
  public DrawerPushItem parseApolloRedTouchContent(String paramString1, String paramString2, JSONObject paramJSONObject, boolean paramBoolean, int paramInt)
  {
    Object localObject2 = getApp();
    if (paramJSONObject != null)
    {
      if (localObject2 == null) {
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloManager", 2, new Object[] { "parseShopRedTouchManager:", paramJSONObject, ", isNewRed：", Boolean.valueOf(paramBoolean), ",msgType：", Integer.valueOf(paramInt) });
      }
      try
      {
        int i = paramJSONObject.optInt("time");
        Object localObject1 = ((AppRuntime)localObject2).getApp();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("apollo_sp");
        ((StringBuilder)localObject3).append(((AppRuntime)localObject2).getCurrentUin());
        localObject1 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject3).toString(), 0);
        int j = ((SharedPreferences)localObject1).getInt(paramString1, 0);
        localObject2 = (ApolloDaoManagerServiceImpl)((AppRuntime)localObject2).getRuntimeService(IApolloDaoManagerService.class, "all");
        if (i == j)
        {
          paramString1 = ((ApolloDaoManagerServiceImpl)localObject2).getCurrentPushItemByMsgId(paramString2);
          if (paramBoolean) {
            return paramString1;
          }
          if (paramString1 == null) {
            break label565;
          }
          ((ApolloDaoManagerServiceImpl)localObject2).clearBubble(paramString2);
          return null;
        }
        paramJSONObject = paramJSONObject.optString("content");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          paramJSONObject = new JSONObject(paramJSONObject);
          localObject3 = new DrawerPushItem();
          ((DrawerPushItem)localObject3).is_reddot = 1;
          ((DrawerPushItem)localObject3).msg_id = paramString2;
          ((DrawerPushItem)localObject3).msg_type = paramInt;
          if (!paramJSONObject.has("mainPriority")) {
            return null;
          }
          ((DrawerPushItem)localObject3).priority = paramJSONObject.optInt("mainPriority");
          ((DrawerPushItem)localObject3).sub_priority = paramJSONObject.optInt("subPriority");
          ((DrawerPushItem)localObject3).start_ts = paramJSONObject.optInt("showTime");
          ((DrawerPushItem)localObject3).end_ts = paramJSONObject.optInt("expireTime");
          ((DrawerPushItem)localObject3).send_time = i;
          ((DrawerPushItem)localObject3).action_id = paramJSONObject.optInt("actionId");
          ((DrawerPushItem)localObject3).color = paramJSONObject.optInt("fontColor");
          ((DrawerPushItem)localObject3).content = paramJSONObject.optString("bubbleText");
          ((DrawerPushItem)localObject3).bubble_res_id = paramJSONObject.optInt("bubbleID");
          ((DrawerPushItem)localObject3).icon_url = paramJSONObject.optString("iconUrl");
          ((DrawerPushItem)localObject3).life_Time = paramJSONObject.optInt("tipsDuration");
          paramInt = paramJSONObject.optInt("type");
          if (paramInt == 0) {
            ((DrawerPushItem)localObject3).scheme = paramJSONObject.optString("scheme");
          } else if (paramInt == 1) {
            ((DrawerPushItem)localObject3).ext_url = ApolloConstant.t;
          } else if (paramInt == 2) {
            ((DrawerPushItem)localObject3).ext_url = paramJSONObject.optString("url");
          }
          ((DrawerPushItem)localObject3).show_counts = paramJSONObject.optInt("showCounts");
          long l = NetConnInfoCenter.getServerTime();
          if ((paramBoolean) && (((DrawerPushItem)localObject3).start_ts < l) && (((DrawerPushItem)localObject3).end_ts > l))
          {
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]ApolloManager", 2, new Object[] { "parseShopRedTouchManager addPushItem:", ((DrawerPushItem)localObject3).toString() });
            }
            ((ApolloDaoManagerServiceImpl)localObject2).addPushItem((DrawerPushItem)localObject3);
            ((SharedPreferences)localObject1).edit().putInt(paramString1, i).commit();
            return localObject3;
          }
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("[cmshow]ApolloManager", 2, "parseApolloRedTouchContent Exception:", paramString1);
      }
    }
    else
    {
      return null;
    }
    label565:
    return null;
  }
  
  public int queryApolloSwitchSet(String paramString)
  {
    if (ApolloConfigUtils.b == null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryApolloSwitchSet key:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" sSwitchSet = null");
        QLog.d("[cmshow]ApolloManager", 2, localStringBuilder.toString());
      }
      return 0;
    }
    return ApolloConfigUtils.b.optInt(paramString);
  }
  
  public int queryStatusInConfig(String paramString1, String paramString2)
  {
    AppInterface localAppInterface = getApp();
    int j = -1;
    int k = j;
    if (localAppInterface != null)
    {
      k = j;
      if (isHardwareSupport(localAppInterface.getApplication()))
      {
        k = j;
        if (!TextUtils.isEmpty(paramString1))
        {
          if (ApolloConfigUtils.a == null) {
            return -1;
          }
          Object localObject = paramString2;
          if (TextUtils.isEmpty(paramString2))
          {
            localObject = paramString2;
            if (!TextUtils.isEmpty(localAppInterface.getCurrentAccountUin()))
            {
              paramString2 = (ApolloDaoManagerServiceImpl)localAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
              localObject = paramString2.getSelfApolloBaseInfo();
              if (localObject != null)
              {
                i = ((ApolloBaseInfo)localObject).apolloStatus;
                k = getWhiteListStatus();
                paramString2 = new StringBuilder();
                paramString2.append(k);
                paramString2.append("x");
                paramString2.append(i);
                localObject = paramString2.toString();
              }
              else
              {
                paramString2.asyncQuerySelfApolloBaseInfo();
                if (QLog.isColorLevel()) {
                  QLog.d("[cmshow]ApolloManager", 2, "queryStatusInConfig but apollomanager dont init done");
                }
                return -1;
              }
            }
          }
          int i = j;
          if (ApolloConfigUtils.a != null)
          {
            i = j;
            if (localObject != null)
            {
              paramString2 = ApolloConfigUtils.a.optJSONObject((String)localObject);
              i = j;
              if (paramString2 != null) {
                i = paramString2.optInt(paramString1);
              }
            }
          }
          k = i;
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("queryStatusInConfig ruleKey: ");
            paramString2.append((String)localObject);
            paramString2.append(", entry = ");
            paramString2.append(paramString1);
            paramString2.append(", value=");
            paramString2.append(i);
            QLog.d("[cmshow]ApolloManager", 2, paramString2.toString());
            k = i;
          }
        }
      }
    }
    return k;
  }
  
  public boolean removeFromActionDownloadList(int paramInt)
  {
    return this.mActionDownloadList.remove(Integer.valueOf(paramInt));
  }
  
  public boolean removeFromActionPlayList(long paramLong)
  {
    return this.mActionPlayList.remove(Long.valueOf(paramLong));
  }
  
  public void requestTianshuAdv()
  {
    ArrayList localArrayList = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.a = 364;
    localTianShuAdPosItemData.b = 1;
    localArrayList.add(localTianShuAdPosItemData);
    localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.a = 365;
    localTianShuAdPosItemData.b = 1;
    localArrayList.add(localTianShuAdPosItemData);
    localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.a = 366;
    localTianShuAdPosItemData.b = 1;
    localArrayList.add(localTianShuAdPosItemData);
    localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.a = 367;
    localTianShuAdPosItemData.b = 1;
    localArrayList.add(localTianShuAdPosItemData);
    localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.a = 393;
    localTianShuAdPosItemData.b = 1;
    localArrayList.add(localTianShuAdPosItemData);
    localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.a = 433;
    localTianShuAdPosItemData.b = 20;
    localArrayList.add(localTianShuAdPosItemData);
    localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.a = 501;
    localTianShuAdPosItemData.b = 1;
    localArrayList.add(localTianShuAdPosItemData);
    localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.a = 502;
    localTianShuAdPosItemData.b = 1;
    localArrayList.add(localTianShuAdPosItemData);
    TianShuManager.getInstance().requestAdv(localArrayList, this.mTianshuCallback);
  }
  
  @Deprecated
  public void saveOrUpdateApolloBaseInfo(ApolloBaseInfo paramApolloBaseInfo)
  {
    AppInterface localAppInterface = getApp();
    if (localAppInterface != null) {
      ((IApolloDaoManagerService)localAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).saveOrUpdateApolloBaseInfo(paramApolloBaseInfo);
    }
  }
  
  public void saveRedAppearTime(int paramInt)
  {
    AppInterface localAppInterface = getApp();
    if (localAppInterface == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("action_red_tab_update_");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    BaseApplication localBaseApplication = localAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_sp");
    localStringBuilder.append(localAppInterface.getCurrentUin());
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putLong((String)localObject, NetConnInfoCenter.getServerTimeMillis()).commit();
  }
  
  public void sendActionMessage(@NotNull BaseAIOContext paramBaseAIOContext, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
  {
    AppInterface localAppInterface = getApp();
    if (localAppInterface == null)
    {
      QLog.e("[cmshow]ApolloManager", 1, "[sendActionMessage] error, app is null!");
      return;
    }
    ApolloActionData localApolloActionData = ((ApolloDaoManagerServiceImpl)localAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramInt1);
    if (localApolloActionData == null) {
      return;
    }
    localApolloActionData.peerUin = paramString;
    localApolloActionData.isForPlayerAction = 1;
    paramString = new ApolloMainInfo(localAppInterface.getCurrentUin());
    paramString.mAction = localApolloActionData;
    paramString.mAction.personNum = paramInt3;
    paramString.mTextType = paramInt2;
    paramString.mSendSrc = paramInt4;
    paramString.mPackageId = 9;
    getApolloPanelManager().a(paramBaseAIOContext, paramString);
  }
  
  public void setActionDownloadList(Collection<Integer> paramCollection)
  {
    this.mActionDownloadList.clear();
    if (paramCollection != null) {
      this.mActionDownloadList.addAll(paramCollection);
    }
  }
  
  public void setActionPlayList(Collection<Long> paramCollection)
  {
    this.mActionPlayList.clear();
    if (paramCollection != null) {
      this.mActionPlayList.addAll(paramCollection);
    }
  }
  
  public void setApolloEngineLockEnable(boolean paramBoolean)
  {
    this.sApolloEngineLockEnable = paramBoolean;
  }
  
  public void setConfigInitDone(boolean paramBoolean)
  {
    this.mConfigInitDone.set(paramBoolean);
  }
  
  public void setDisableCreateRenderThread(boolean paramBoolean)
  {
    this.mDisableCreateRenderThread = paramBoolean;
  }
  
  public void setOpenType(int paramInt)
  {
    this.openType = paramInt;
  }
  
  public void setUinForReload(String paramString)
  {
    this.mUinForReload = paramString;
  }
  
  public void setUserActionId(HashMap<Integer, Bundle> paramHashMap)
  {
    this.mUserActionId = paramHashMap;
  }
  
  public void setsUseTextureViewConfig(boolean paramBoolean)
  {
    this.mUseTextureViewConfig = paramBoolean;
  }
  
  public void update3dWhiteList(int paramInt)
  {
    AppInterface localAppInterface = getApp();
    if (localAppInterface == null) {
      return;
    }
    SharedPreferences.Editor localEditor = localAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localAppInterface.getCurrentAccountUin());
    localStringBuilder.append("_3dwhiteList");
    localEditor.putInt(localStringBuilder.toString(), paramInt).commit();
    int i = SharedPreUtils.z(localAppInterface.getApplication());
    if (i == 0) {
      s3dWhiteUserStatus = paramInt;
    } else if (1 == i) {
      s3dWhiteUserStatus = 1;
    } else {
      s3dWhiteUserStatus = 0;
    }
    QLog.d("[cmshow]ApolloManager", 1, new Object[] { "[update3dWhiteList] global=", Integer.valueOf(i), ", s3dWhiteUserStatus=", Integer.valueOf(s3dWhiteUserStatus), ", status=", Integer.valueOf(paramInt) });
  }
  
  public void updateDrawerItem(DrawerPushItem paramDrawerPushItem)
  {
    AppInterface localAppInterface = getApp();
    if (localAppInterface == null) {
      return;
    }
    ((ProxyManager)localAppInterface.getManager(QQManagerFactory.PROXY_MANAGER)).addMsgQueue(localAppInterface.getAccount(), 0, paramDrawerPushItem.getTableName(), paramDrawerPushItem, 4, null);
  }
  
  public void updateLastShopTabInfo(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloManager", 2, new Object[] { "[updateLastShopTabInfo] tab=", paramString });
    }
    Object localObject = getApp();
    if (localObject == null) {
      return;
    }
    this.mLastShopTab = paramString;
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((AppRuntime)localObject).getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append("sp_key_last_shop_tab");
    localObject = localStringBuilder.toString();
    if (!TextUtils.isEmpty(paramString)) {
      localEditor.putString((String)localObject, this.mLastShopTab);
    } else {
      localEditor.remove((String)localObject);
    }
    localEditor.commit();
  }
  
  public void updateUserFlag(int paramInt1, int paramInt2) {}
  
  public void updateWhiteList(int paramInt)
  {
    Object localObject = getApp();
    if (localObject != null)
    {
      SharedPreferences.Editor localEditor = ((AppRuntime)localObject).getApplication().getSharedPreferences("apollo_sp", 0).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((AppRuntime)localObject).getCurrentAccountUin());
      localStringBuilder.append("_whiteList");
      localEditor.putInt(localStringBuilder.toString(), paramInt).commit();
      int i = SharedPreUtils.y(((AppRuntime)localObject).getApplication());
      if (i == 0) {
        sWhiteUserStatus = paramInt;
      } else if (1 == i) {
        sWhiteUserStatus = 1;
      } else {
        sWhiteUserStatus = 0;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("update white list ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", mWhiteUserStatus: ");
        ((StringBuilder)localObject).append(sWhiteUserStatus);
        ((StringBuilder)localObject).append(", status: ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("[cmshow]ApolloManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */