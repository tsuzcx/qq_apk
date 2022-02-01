package com.tencent.mobileqq.apollo.api.impl;

import android.app.ActivityManager;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ConfigurationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloPanelManager;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.game.ApolloGameConst;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.impl.aio.BubbleProducer;
import com.tencent.mobileqq.apollo.api.impl.listener.ApolloInitCallback;
import com.tencent.mobileqq.apollo.api.impl.listener.ApolloStatusUpdateListener;
import com.tencent.mobileqq.apollo.api.impl.listener.Download403Callback;
import com.tencent.mobileqq.apollo.api.impl.model.App3DConfig;
import com.tencent.mobileqq.apollo.api.listener.Save3DFaceListener;
import com.tencent.mobileqq.apollo.api.model.Apollo3DMessage;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPackageData;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloDress;
import com.tencent.mobileqq.apollo.api.model.ApolloKapuEntranceTips;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.ApolloPandora;
import com.tencent.mobileqq.apollo.api.model.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.api.model.ApolloWhiteFaceID;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloResDownloaderImpl;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGamePushManager;
import com.tencent.mobileqq.apollo.config.ApolloConfProcessor;
import com.tencent.mobileqq.apollo.config.ApolloGrayConfProcessor;
import com.tencent.mobileqq.apollo.game.ApolloGameConfig;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.game.ApolloGameTool;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.apollo.lightGame.CmGameAudioManager;
import com.tencent.mobileqq.apollo.lightGame.CmGameConnManager;
import com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler;
import com.tencent.mobileqq.apollo.player.CMSPlayer;
import com.tencent.mobileqq.apollo.player.GetFrameCallback;
import com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLifeCycleMgr;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceReportInstance;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.apollo.utils.ApolloConfigDataReport;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloListenerManager;
import com.tencent.mobileqq.apollo.utils.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.utils.IResDownloadListener;
import com.tencent.mobileqq.apollo.utils.RSAVerify;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ApolloActionTag;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import com.tencent.util.URLUtil;
import cooperation.qzone.QZoneVipInfoManager;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import cooperation.vip.tianshu.TianShuManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xdc.submsgtype0xdc.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xdc.submsgtype0xdc.MsgContent;

public class ApolloManagerServiceImpl
  implements IApolloManagerService
{
  private static final String APOLLO_RES_ACTION = "action_version";
  private static final String APOLLO_RES_DRESS = "dress_version";
  private static final String APOLLO_RES_GAME = "game_version";
  private static final String APOLLO_RES_ROLE = "role_version";
  private static final String APOLLO_RES_VERSION_INFO = "apollo_res_version_info.json";
  private static final String CMSHOW_3D_FACE_FILE_SUFFIX = ".zip";
  private static final String KEY_PET_CONFIG = "pet_config";
  private static final int SAVE_RES_DATA_DELAY = 6000;
  public static final String TAG = "ApolloManager";
  public static final String TAG_PET = "ApolloPet";
  private static HashSet<Integer> mCMSFrameCache;
  private static HashMap<CMSAction, GetFrameCallback> mCallbackMap;
  private static int s3dWhiteUserStatus;
  private static String sApolloDpcInfo;
  public static String sApolloGameSt;
  public static String sApolloGameStkey;
  private static boolean sApolloSwitch = true;
  public static volatile String sBasicScript;
  public static Vector<String> sBulkApolloInfoList = new Vector();
  public static Vector<String> sBulkPullDressList;
  private static boolean sCmGameDPCSwitch = true;
  private static boolean sCmShow3dDPCSwitch = true;
  public static volatile String sEngineScript;
  public static boolean sFristOpenPanel;
  private static int sGameOidbStatus;
  private static boolean sHardWareGL3Support;
  private static boolean sHardWareSupportApollo;
  private static boolean sHardWareTested;
  public static boolean sInitedDone;
  private static AtomicBoolean sIsChecking;
  public static String sJmumpMallUrl;
  public static String sJumpMoreUrl;
  public static Map<String, String> sScriptLibs;
  public static String[] sScriptNames;
  private static int sWhiteUserStatus = -1;
  private ConcurrentHashMap<String, ApolloPandora> apolloPandoraCache = new ConcurrentHashMap();
  private Runnable asyncInitDataRunnable = new ApolloManagerServiceImpl.3(this);
  private float cmsPanelGetCoverFrameTime = CmShowWnsUtils.b();
  private volatile boolean isApolloBaseInfoCacheInited;
  DownloadListener jsonListener = new ApolloManagerServiceImpl.7(this);
  private DownloadListener listener = new ApolloManagerServiceImpl.8(this);
  private final HashSet<Integer> mActionDownloadList = new HashSet(16);
  private final ArrayList<Long> mActionPlayList = new ArrayList(16);
  private QQLruCache<String, ApolloBaseInfo> mApolloBaseInfoCache = new ApolloManagerServiceImpl.1(this, 2009, 1024, ApolloBaseInfo.calcSelfMemorySize());
  private WeakReference<BaseChatPie> mApolloGameChatPieRef;
  ApolloPanelManager mApolloPanelManager;
  IApolloResDownloader.OnApolloDownLoadListener mApolloResReadListener;
  JSONObject mApolloResVersionInfo = new JSONObject();
  private WeakReference<QQAppInterface> mAppRef;
  Handler mAsyncSubThreadHandler = new ApolloManagerServiceImpl.15(this, ThreadManager.getSubThreadLooper());
  public WeakReference<BaseChatPie> mBaseChatPieRef;
  private ApolloManagerServiceImpl.ApolloManagerReceiver mBroadcastReceiver;
  private BubbleProducer mBubbleProducer;
  private CMSPlayer mCMSPlayer;
  private CmGameAudioManager mCmGameAudioManager;
  private CmGameConnManager mCmGameConnManager;
  private CmGamePushManager mCmGamePushManager = new CmGamePushManager();
  private AtomicBoolean mConfigInitDone = new AtomicBoolean(false);
  private boolean mDisableCreateRenderThread;
  private List<DrawerPushItem> mDrawerPushItems = new ArrayList();
  private EntityManager mEntityManager;
  private ITransFileController mFileController;
  public boolean mFristOpenGamePanel = true;
  public long mGameStartT = -1L;
  private CmGameTempSessionHandler mGameTempMsgHandler;
  public Timer mGlobalTimer;
  private List<ApolloInitCallback> mInitCallbackList;
  public boolean mIs780GuideShowed;
  public boolean mIsBubbleTab = false;
  private boolean mIsClickIgnore;
  public volatile boolean mIsDrawerGameBoxUser;
  public boolean mIsGetPlusStatus;
  private volatile boolean mIsInitConfig = false;
  private AtomicBoolean mIsJsonParsing = new AtomicBoolean(false);
  public boolean mIsMiniAppPlayed;
  public boolean mIsNewStoreUser = true;
  public boolean mIsPlayedGame;
  public boolean mIsPlusNewShowed;
  public boolean mIsPlusWhiteList;
  public boolean mIsShowedNewPopView;
  public String mLastShopTab;
  ApolloListenerManager mListenerManager;
  private MessageObserver mMessageObserver;
  public boolean mNeedShowPlusGuide;
  public boolean mNeedShowWorldCup;
  public String mPetConfig;
  private Map<String, Long> mPullStandActionMap = new HashMap();
  Comparator<DrawerPushItem> mPushItemComparator = new ApolloManagerServiceImpl.21(this);
  private final Object mPushLock = new Object();
  private Runnable mReadApolloResVersionRunable = new ApolloManagerServiceImpl.5(this);
  private WeakReference<Save3DFaceListener> mSave3DFaceListenerRef;
  private Runnable mSaveApolloResVersionRunnable = new ApolloManagerServiceImpl.6(this);
  private ApolloBaseInfo mSelfApolloBaseInfo;
  private List<WeakReference<ApolloStatusUpdateListener>> mStatusUpdateListeners = new ArrayList();
  TianShuGetAdvCallback mTianshuCallback = new ApolloManagerServiceImpl.24(this);
  private String mUinForReload;
  private HashSet<Long> mUnCacheUinSets = new HashSet();
  private boolean mUseTextureViewConfig;
  public HashMap<Integer, Bundle> mUserActionId;
  public int openType = 0;
  private DownloadListener preDownloadListener = new ApolloManagerServiceImpl.22(this);
  private boolean sApolloEngineLockEnable;
  
  static
  {
    s3dWhiteUserStatus = -1;
    sGameOidbStatus = -1;
    mCMSFrameCache = new HashSet();
    mCallbackMap = new HashMap();
    sFristOpenPanel = true;
    sInitedDone = false;
    sScriptNames = new String[] { "ticker.js", "brick.js", "scene.js", "game.js" };
    sScriptLibs = new LinkedHashMap();
    sIsChecking = new AtomicBoolean(false);
    sBulkPullDressList = new Vector();
  }
  
  private String add3DInteractParams(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (!paramString1.contains("3d_interact"))) {}
    do
    {
      do
      {
        return paramString1;
        String str = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          str = paramQQAppInterface.getCurrentAccountUin();
        }
        paramQQAppInterface = getApolloBaseInfoFromCache(str);
      } while (paramQQAppInterface == null);
      paramString2 = paramQQAppInterface.getApolloDress3D();
    } while (paramString2 == null);
    paramQQAppInterface = paramString1;
    if (paramString2.faceData != null) {
      paramQQAppInterface = URLUtil.a(paramString1, "facedata", paramString2.faceData);
    }
    paramString1 = paramQQAppInterface;
    if (paramString2.getDressIds() != null) {
      paramString1 = URLUtil.a(paramQQAppInterface, "dressids", Arrays.toString(paramString2.getDressIds()).replaceAll(" ", ""));
    }
    return URLUtil.a(paramString1, "roleid", String.valueOf(paramString2.roleId));
  }
  
  private void addApolloActionTask(List<String> paramList, Map<String, File> paramMap, List<ApolloActionData> paramList1, Bundle paramBundle)
  {
    if ((paramList1 == null) || (paramList1.size() <= 0) || (paramList == null) || (paramMap == null)) {
      return;
    }
    int i = 0;
    label25:
    ApolloActionData localApolloActionData;
    String str1;
    Object localObject;
    String str2;
    String str3;
    if (i < paramList1.size())
    {
      localApolloActionData = (ApolloActionData)paramList1.get(i);
      str1 = ApolloUtilImpl.getApolloResPath(localApolloActionData, 1);
      localObject = ApolloUtilImpl.getApolloResPath(localApolloActionData, 0);
      str2 = ApolloUtilImpl.getApolloResPath(localApolloActionData, 5);
      str3 = ApolloUtilImpl.getApolloResPath(localApolloActionData, 4);
      if (!FileUtil.a((String)localObject)) {
        break label216;
      }
      localObject = new DownloadTask(str1, new File((String)localObject));
      Bundle localBundle = new Bundle();
      localBundle.putSerializable(str1, localApolloActionData);
      ((DownloadTask)localObject).c = str1;
      ((DownloadTask)localObject).a(localBundle);
      this.listener.onDoneFile((DownloadTask)localObject);
    }
    for (;;)
    {
      if (!ApolloUtilImpl.isActionResDone(localApolloActionData.actionId, localApolloActionData.personNum))
      {
        paramList.add(str2);
        paramMap.put(str2, new File(str3));
        if (paramBundle != null) {
          paramBundle.putSerializable(str2, localApolloActionData);
        }
      }
      i += 1;
      break label25;
      break;
      label216:
      paramList.add(str1);
      paramMap.put(str1, new File((String)localObject));
      if (paramBundle != null) {
        paramBundle.putSerializable(str1, localApolloActionData);
      }
    }
  }
  
  private boolean alreadyContainsItem(DrawerPushItem paramDrawerPushItem)
  {
    if ((this.mDrawerPushItems == null) || (this.mDrawerPushItems.isEmpty())) {
      return false;
    }
    Iterator localIterator = this.mDrawerPushItems.iterator();
    while (localIterator.hasNext())
    {
      DrawerPushItem localDrawerPushItem = (DrawerPushItem)localIterator.next();
      if ((localDrawerPushItem.msg_id != null) && (localDrawerPushItem.msg_id.equals(paramDrawerPushItem.msg_id))) {
        return true;
      }
    }
    return false;
  }
  
  private void apolloMsgDtReport(boolean paramBoolean, String paramString, long paramLong)
  {
    int k = 1;
    Object localObject = getApp();
    if (localObject == null) {}
    MessageRecord localMessageRecord;
    do
    {
      return;
      localMessageRecord = ((QQAppInterface)localObject).getMessageFacade().a(paramString, ApolloDtReportUtil.a(), paramLong);
    } while (!(localMessageRecord instanceof MessageForApollo));
    int m = getApolloStatus(((QQAppInterface)localObject).getCurrentUin());
    int i;
    if (((MessageForApollo)localMessageRecord).is3dAction())
    {
      i = ((MessageForApollo)localMessageRecord).mApollo3DMessage.actionID_3D;
      if (!paramBoolean) {
        break label255;
      }
      paramString = "send_success";
      label81:
      localObject = new ApolloDtReportUtil.DtReportParamsBuilder();
      if (!((MessageForApollo)localMessageRecord).is3dAction()) {
        break label262;
      }
      j = 1;
      label104:
      localObject = ((ApolloDtReportUtil.DtReportParamsBuilder)localObject).a(j).b(ApolloDtReportUtil.a(ApolloDtReportUtil.a()));
      if (!((MessageForApollo)localMessageRecord).isNewAnimation()) {
        break label268;
      }
      j = 1;
      label136:
      localObject = ((ApolloDtReportUtil.DtReportParamsBuilder)localObject).c(j).c(String.valueOf(i));
      if (!localMessageRecord.isSend()) {
        break label274;
      }
      j = 0;
      label164:
      localObject = ((ApolloDtReportUtil.DtReportParamsBuilder)localObject).d(j);
      if (!((MessageForApollo)localMessageRecord).isDoubleAction()) {
        break label280;
      }
    }
    label262:
    label268:
    label274:
    label280:
    for (int j = k;; j = 0)
    {
      ApolloDtReportUtil.a("aio_bubble", "apollo_msg", paramString, ((ApolloDtReportUtil.DtReportParamsBuilder)localObject).e(ApolloDtReportUtil.a(j, ((MessageForApollo)localMessageRecord).actionType)).f(m).b(ApolloDtReportUtil.a()).g(ApolloDtReportUtil.b(i)).a());
      return;
      i = ((MessageForApollo)localMessageRecord).mApolloMessage.id;
      break;
      label255:
      paramString = "send_fail";
      break label81;
      j = 0;
      break label104;
      j = 0;
      break label136;
      j = 1;
      break label164;
    }
  }
  
  private void changeNewRole(String paramString, QQAppInterface paramQQAppInterface, ApolloBaseInfo paramApolloBaseInfo) {}
  
  private void checkActionVersion(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData != null)
    {
      Object localObject = new File(ApolloUtilImpl.getApolloResPath(paramApolloActionData, 7));
      if (((File)localObject).exists()) {
        try
        {
          localObject = FileUtils.a((File)localObject);
          if (new JSONObject((String)localObject).optLong("version") < paramApolloActionData.version)
          {
            boolean bool = FileUtil.c(ApolloUtilImpl.getApolloResPath(paramApolloActionData, 6));
            URLDrawable.removeMemoryCacheByUrl(new URL("apollo_pic", null, paramApolloActionData.actionId + "_" + paramApolloActionData.actionName).toString());
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "del old action res id:" + paramApolloActionData.actionId + ", ret: " + bool);
            }
          }
          else
          {
            optActionConfigJson((String)localObject, paramApolloActionData);
            return;
          }
        }
        catch (Exception paramApolloActionData)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ApolloManager", 2, "checkActionVersion failed " + paramApolloActionData.toString());
          }
        }
      }
    }
  }
  
  private void checkDefaultRes()
  {
    ApolloManagerServiceImpl.4 local4 = new ApolloManagerServiceImpl.4(this);
    if (!sIsChecking.getAndSet(true)) {
      ThreadManager.post(local4, 8, null, false);
    }
  }
  
  private void checkDpcSwitch()
  {
    if (CmShowWnsUtils.n())
    {
      this.mAsyncSubThreadHandler.removeMessages(4098);
      this.mAsyncSubThreadHandler.sendEmptyMessage(4098);
      return;
    }
    doCheckDpcSwitch();
  }
  
  private boolean checkPackageAction(int paramInt, List<ApolloActionData> paramList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (paramList != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramList.size())
      {
        if (((ApolloActionData)paramList.get(i)).actionId == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void checkPackageBubbleInfo(JSONObject paramJSONObject)
  {
    int i = 3;
    Object localObject = getApp();
    if ((paramJSONObject == null) || (localObject == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        int j = (int)(paramJSONObject.optLong("startTime") / 1000L);
        SharedPreferences localSharedPreferences = ((QQAppInterface)localObject).getApp().getSharedPreferences("apollo_sp" + ((QQAppInterface)localObject).getCurrentUin(), 0);
        if (j == localSharedPreferences.getInt("key_panel_bubble_start_time", 0)) {
          break;
        }
        localObject = new DrawerPushItem();
        ((DrawerPushItem)localObject).is_reddot = 0;
        ((DrawerPushItem)localObject).msg_id = "aio_panel_bubble_push";
        ((DrawerPushItem)localObject).msg_type = 7;
        ((DrawerPushItem)localObject).priority = 1000;
        ((DrawerPushItem)localObject).start_ts = j;
        ((DrawerPushItem)localObject).end_ts = ((int)NetConnInfoCenter.getServerTime() + (int)(paramJSONObject.optLong("interval") / 1000L));
        ((DrawerPushItem)localObject).send_time = j;
        ((DrawerPushItem)localObject).content = paramJSONObject.optString("bubbleText");
        ((DrawerPushItem)localObject).show_counts = paramJSONObject.optInt("showCount");
        if (((DrawerPushItem)localObject).show_counts == 0) {
          ((DrawerPushItem)localObject).show_counts = 1;
        }
        int k = paramJSONObject.optInt("packageId");
        if (ApolloActionPackage.is3DPackage(k))
        {
          ((DrawerPushItem)localObject).target_model = i;
          addPushItem((DrawerPushItem)localObject);
          paramJSONObject = localSharedPreferences.edit();
          paramJSONObject.putInt("key_panel_bubble_start_time", j);
          if (k >= 0) {
            paramJSONObject.putInt("key_panel_bubble_tab", k);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, new Object[] { "checkPackageBubbleInfo", " push bubble:", ((DrawerPushItem)localObject).toString(), " ,packageId", Integer.valueOf(k) });
          }
          paramJSONObject.commit();
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("ApolloManager", 1, "checkPackageBubbleInfo Exception:", paramJSONObject);
        return;
      }
      i = 2;
    }
  }
  
  private void checkPackageRedDots(ApolloActionPackage paramApolloActionPackage, List<ApolloActionData> paramList)
  {
    Object localObject = getApp();
    if ((paramApolloActionPackage == null) || (localObject == null)) {
      break label15;
    }
    label15:
    String str;
    for (;;)
    {
      return;
      if (paramList != null) {
        try
        {
          if (paramList.size() != 0)
          {
            str = ((QQAppInterface)localObject).getApp().getSharedPreferences("apollo_sp" + ((QQAppInterface)localObject).getCurrentUin(), 0).getString(String.format("key_new_action_info_%s", new Object[] { String.valueOf(paramApolloActionPackage.packageId) }), "");
            if (TextUtils.isEmpty(str))
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("ApolloManager", 2, "checkPackageRedDots, no new action info");
            }
          }
        }
        catch (Exception paramApolloActionPackage)
        {
          QLog.e("ApolloManager", 1, "checkPackageRedDots Exception:", paramApolloActionPackage);
          return;
        }
      }
    }
    JSONObject localJSONObject = new JSONObject(str);
    int j = localJSONObject.getInt("actionId");
    paramList = paramList.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
    } while (((ApolloActionData)paramList.next()).actionId != j);
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        QLog.d("ApolloManager", 1, new Object[] { "checkPackageRedDots, new action, pkdId=", Integer.valueOf(paramApolloActionPackage.packageId), ", actionId=", Integer.valueOf(j) });
        return;
      }
      long l1 = localJSONObject.getLong("startTime");
      long l2 = localJSONObject.getLong("interval");
      paramList = ((ApolloDaoManagerServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloDaoManagerService.class, "all")).findPackageById(paramApolloActionPackage.packageId);
      if ((paramList != null) && (l1 == paramList.redStartTime))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, new Object[] { "checkPackageRedDots", " have not new red push" });
        }
        paramApolloActionPackage.isUpdate = paramList.isUpdate;
        paramApolloActionPackage.redFlowId = paramList.redFlowId;
        paramApolloActionPackage.redStartTime = paramList.redStartTime;
        paramApolloActionPackage.redInterval = paramList.redInterval;
        return;
      }
      paramApolloActionPackage.isUpdate = true;
      paramApolloActionPackage.redFlowId = j;
      paramApolloActionPackage.redStartTime = l1;
      paramApolloActionPackage.redInterval = l2;
      saveRedAppearTime(paramApolloActionPackage.packageId);
      paramList = new ArrayList();
      localObject = new ApolloActionData();
      ((ApolloActionData)localObject).actionId = j;
      paramList.add(localObject);
      downloadResAndPanel(paramList, "apollo_key");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloManager", 2, new Object[] { "checkPackageRedDots", " push red:", Integer.valueOf(paramApolloActionPackage.packageId), " newActionInfoStr:", str });
      return;
    }
  }
  
  /* Error */
  private void copyFilesFassets(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: invokestatic 826	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +39 -> 48
    //   12: ldc 34
    //   14: iconst_2
    //   15: new 797	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 798	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 1067
    //   25: invokevirtual 807	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_2
    //   29: invokevirtual 807	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc_w 1069
    //   35: invokevirtual 807	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_3
    //   39: invokevirtual 807	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 812	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 836	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: new 588	java/io/File
    //   51: dup
    //   52: ldc_w 1071
    //   55: invokespecial 591	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: invokevirtual 1074	java/io/File:mkdirs	()Z
    //   61: pop
    //   62: aload_1
    //   63: invokevirtual 1080	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   66: aload_2
    //   67: invokevirtual 1086	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   70: astore_1
    //   71: new 1088	java/io/FileOutputStream
    //   74: dup
    //   75: new 588	java/io/File
    //   78: dup
    //   79: aload_3
    //   80: invokespecial 591	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: invokespecial 1091	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   86: astore_2
    //   87: sipush 4096
    //   90: newarray byte
    //   92: astore_3
    //   93: aload_1
    //   94: aload_3
    //   95: invokevirtual 1097	java/io/InputStream:read	([B)I
    //   98: istore 4
    //   100: iload 4
    //   102: iconst_m1
    //   103: if_icmpeq +77 -> 180
    //   106: aload_2
    //   107: aload_3
    //   108: iconst_0
    //   109: iload 4
    //   111: invokevirtual 1101	java/io/FileOutputStream:write	([BII)V
    //   114: goto -21 -> 93
    //   117: astore 5
    //   119: aload_1
    //   120: astore_3
    //   121: aload 5
    //   123: astore_1
    //   124: aload_1
    //   125: invokevirtual 1104	java/lang/Exception:printStackTrace	()V
    //   128: invokestatic 826	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +32 -> 163
    //   134: ldc 34
    //   136: iconst_2
    //   137: new 797	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 798	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 1106
    //   147: invokevirtual 807	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_1
    //   151: invokevirtual 1109	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   154: invokevirtual 807	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 812	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 836	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: aload_3
    //   164: ifnull +7 -> 171
    //   167: aload_3
    //   168: invokevirtual 1112	java/io/InputStream:close	()V
    //   171: aload_2
    //   172: ifnull +7 -> 179
    //   175: aload_2
    //   176: invokevirtual 1113	java/io/FileOutputStream:close	()V
    //   179: return
    //   180: aload_2
    //   181: invokevirtual 1116	java/io/FileOutputStream:flush	()V
    //   184: aload_1
    //   185: ifnull +7 -> 192
    //   188: aload_1
    //   189: invokevirtual 1112	java/io/InputStream:close	()V
    //   192: aload_2
    //   193: ifnull -14 -> 179
    //   196: aload_2
    //   197: invokevirtual 1113	java/io/FileOutputStream:close	()V
    //   200: return
    //   201: astore_1
    //   202: return
    //   203: astore_1
    //   204: aconst_null
    //   205: astore_2
    //   206: aload 6
    //   208: astore_3
    //   209: aload_3
    //   210: ifnull +7 -> 217
    //   213: aload_3
    //   214: invokevirtual 1112	java/io/InputStream:close	()V
    //   217: aload_2
    //   218: ifnull +7 -> 225
    //   221: aload_2
    //   222: invokevirtual 1113	java/io/FileOutputStream:close	()V
    //   225: aload_1
    //   226: athrow
    //   227: astore_2
    //   228: goto -3 -> 225
    //   231: astore 5
    //   233: aconst_null
    //   234: astore_2
    //   235: aload_1
    //   236: astore_3
    //   237: aload 5
    //   239: astore_1
    //   240: goto -31 -> 209
    //   243: astore 5
    //   245: aload_1
    //   246: astore_3
    //   247: aload 5
    //   249: astore_1
    //   250: goto -41 -> 209
    //   253: astore_1
    //   254: goto -45 -> 209
    //   257: astore_1
    //   258: return
    //   259: astore_1
    //   260: aconst_null
    //   261: astore_2
    //   262: aload 5
    //   264: astore_3
    //   265: goto -141 -> 124
    //   268: astore 5
    //   270: aconst_null
    //   271: astore_2
    //   272: aload_1
    //   273: astore_3
    //   274: aload 5
    //   276: astore_1
    //   277: goto -153 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	ApolloManagerServiceImpl
    //   0	280	1	paramContext	Context
    //   0	280	2	paramString1	String
    //   0	280	3	paramString2	String
    //   98	12	4	i	int
    //   4	1	5	localObject1	Object
    //   117	5	5	localException1	Exception
    //   231	7	5	localObject2	Object
    //   243	20	5	localObject3	Object
    //   268	7	5	localException2	Exception
    //   1	206	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   87	93	117	java/lang/Exception
    //   93	100	117	java/lang/Exception
    //   106	114	117	java/lang/Exception
    //   180	184	117	java/lang/Exception
    //   188	192	201	java/lang/Exception
    //   196	200	201	java/lang/Exception
    //   48	71	203	finally
    //   213	217	227	java/lang/Exception
    //   221	225	227	java/lang/Exception
    //   71	87	231	finally
    //   87	93	243	finally
    //   93	100	243	finally
    //   106	114	243	finally
    //   180	184	243	finally
    //   124	163	253	finally
    //   167	171	257	java/lang/Exception
    //   175	179	257	java/lang/Exception
    //   48	71	259	java/lang/Exception
    //   71	87	268	java/lang/Exception
  }
  
  private void doCheckDpcSwitch()
  {
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.apollo_info.name(), "");
    if ((!TextUtils.isEmpty(str)) && (!str.equals(sApolloDpcInfo)))
    {
      sApolloDpcInfo = str;
      String[] arrayOfString = str.split("\\|");
      if (arrayOfString.length > 0) {
        sApolloSwitch = "1".equals(arrayOfString[0]);
      }
      if (arrayOfString.length > 1) {
        sCmGameDPCSwitch = "1".equals(arrayOfString[1]);
      }
      if (arrayOfString.length > 2) {
        sCmShow3dDPCSwitch = "1".equals(arrayOfString[2]);
      }
      QLog.d("ApolloManager", 1, new Object[] { "doCheckDpcSwitch, apolloInfo=", str, ", sApolloSwitch=", Boolean.valueOf(sApolloSwitch), ", sCmGameDPCSwitch=", Boolean.valueOf(sCmGameDPCSwitch), ", sCmShow3dDPCSwitch=", Boolean.valueOf(sCmShow3dDPCSwitch) });
    }
  }
  
  private void doPreDownloadResDone(ApolloPreDownloadData paramApolloPreDownloadData, String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = getApp();
    if ((localQQAppInterface == null) || (paramApolloPreDownloadData == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      QLog.e("ApolloManager", 1, "preDownloadListener err param");
    }
    File localFile;
    for (;;)
    {
      return;
      try
      {
        localFile = new File(paramString1);
        if (localFile.exists())
        {
          String str = MD5FileUtil.a(localFile);
          if ((str != null) && (!str.equalsIgnoreCase(paramApolloPreDownloadData.md5)))
          {
            QLog.e("ApolloManager", 1, "preDownloadListener md5 not match!");
            localFile.delete();
            return;
          }
        }
      }
      catch (Exception paramApolloPreDownloadData)
      {
        QLog.e("ApolloManager", 1, "preDownloadListener fail zip file: " + paramString1, paramApolloPreDownloadData);
        return;
      }
    }
    FileUtils.a(paramString1, paramString2, false);
    if (TextUtils.isEmpty(paramApolloPreDownloadData.zipDir)) {
      localFile.delete();
    }
    paramString2 = (ApolloDaoManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    paramApolloPreDownloadData.status = 1;
    paramString2.updatePreDownloadRes(paramApolloPreDownloadData);
    VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "pre_download_res", 0, 0, new String[] { paramApolloPreDownloadData.reportId });
  }
  
  private void downloadActionIfNotExist(int paramInt1, int paramInt2)
  {
    QQAppInterface localQQAppInterface = getApp();
    if ((!ApolloUtilImpl.isActionResDone(paramInt1, paramInt2)) && (localQQAppInterface != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ApolloPet", 2, "start download action:" + paramInt1);
      }
      Object localObject = new ApolloActionData();
      ((ApolloActionData)localObject).actionId = paramInt1;
      String str = ApolloUtilImpl.getApolloResPath((ApolloActionData)localObject, 5);
      localObject = ApolloUtilImpl.getApolloResPath((ApolloActionData)localObject, 4);
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadSpecialAction(localQQAppInterface, (String)localObject, str);
    }
  }
  
  public static int get3dWhiteListStatus(AppRuntime paramAppRuntime)
  {
    for (;;)
    {
      try
      {
        if (s3dWhiteUserStatus == -1)
        {
          s3dWhiteUserStatus = 0;
          if (paramAppRuntime != null)
          {
            i = SharedPreUtils.r(paramAppRuntime.getApplication());
            QLog.d("ApolloManager", 1, new Object[] { "[get3dWhiteListStatus] global=", Integer.valueOf(i) });
            if (i != 0) {
              continue;
            }
            s3dWhiteUserStatus = paramAppRuntime.getApplication().getSharedPreferences("apollo_sp", 0).getInt(paramAppRuntime.getCurrentAccountUin() + "_3dwhiteList", 0);
            QLog.d("ApolloManager", 1, new Object[] { "[get3dWhiteListStatus] global=", Integer.valueOf(i), ", s3dWhiteUserStatus=", Integer.valueOf(s3dWhiteUserStatus) });
          }
        }
      }
      catch (Throwable paramAppRuntime)
      {
        int i;
        QLog.e("ApolloManager", 1, "[get3dWhiteListStatus] exception=", paramAppRuntime);
        continue;
      }
      return s3dWhiteUserStatus;
      if (1 == i) {
        s3dWhiteUserStatus = 1;
      }
    }
  }
  
  private QQAppInterface getApp()
  {
    if (this.mAppRef == null)
    {
      try
      {
        Object localObject = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject instanceof QQAppInterface))
        {
          this.mAppRef = new WeakReference((QQAppInterface)localObject);
          localObject = (QQAppInterface)this.mAppRef.get();
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ApolloManager", 2, "[getApp] error! not run in QQAppInterface! ", localThrowable);
      }
      return null;
    }
    return (QQAppInterface)this.mAppRef.get();
  }
  
  private DrawerPushItem getCurrentPushItemByMsgId(String paramString)
  {
    synchronized (this.mPushLock)
    {
      if ((this.mDrawerPushItems == null) || (this.mDrawerPushItems.isEmpty())) {
        return null;
      }
      Collections.sort(this.mDrawerPushItems, this.mPushItemComparator);
      long l = System.currentTimeMillis() / 1000L;
      Iterator localIterator = this.mDrawerPushItems.iterator();
      while (localIterator.hasNext())
      {
        DrawerPushItem localDrawerPushItem = (DrawerPushItem)localIterator.next();
        if ((localDrawerPushItem.msg_id.equals(paramString)) && (localDrawerPushItem.start_ts < l) && (localDrawerPushItem.end_ts > l)) {
          return localDrawerPushItem;
        }
      }
    }
    return null;
  }
  
  private DownloaderInterface getDownloader()
  {
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      return null;
    }
    return ((DownloaderFactory)localQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(3);
  }
  
  private EntityManager getEntityManager()
  {
    if (this.mEntityManager != null) {
      return this.mEntityManager;
    }
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof AppInterface)) {
        this.mEntityManager = ((AppInterface)localAppRuntime).getEntityManagerFactory().createEntityManager();
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("ApolloManager", 2, "[getEntityManager] error! not run in AppInterface! ", localThrowable);
      }
    }
  }
  
  public static int getOpenGLVersion()
  {
    if ((sHardWareGL3Support) && (ApolloConfigUtils.e)) {
      return 3;
    }
    return 2;
  }
  
  private void handleAio2dBubbleAdv(TianShuAccess.RspEntry paramRspEntry)
  {
    QLog.d("ApolloManager", 1, "handleAio2dBubbleAdv");
    if ((paramRspEntry == null) || (paramRspEntry.value == null) || (paramRspEntry.value.lst == null) || (paramRspEntry.value.lst.size() == 0))
    {
      QLog.e("ApolloManager", 1, "handleAio2dBubbleAdv, data empty");
      return;
    }
    int n = paramRspEntry.value.lst.size();
    QLog.d("ApolloManager", 1, new Object[] { "handleAio2dBubbleAdv, size=", Integer.valueOf(n) });
    HashMap localHashMap = new HashMap();
    int i = 0;
    String str1 = "";
    int j = 0;
    label107:
    Object localObject1;
    int k;
    if (j < n)
    {
      localObject1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).argList.get();
      int m = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).iAdId.get();
      QLog.d("ApolloManager", 1, new Object[] { "handleAio2dBubbleAdv, adId=", Integer.valueOf(m), ", i=", Integer.valueOf(j) });
      if (j == n - 1)
      {
        k = 1;
        if (k == 0) {
          break label817;
        }
        str1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).traceinfo.get();
        i = m;
      }
    }
    label807:
    label812:
    label817:
    for (;;)
    {
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (TianShuAccess.MapEntry)((Iterator)localObject1).next();
          String str2 = ((TianShuAccess.MapEntry)localObject2).key.get();
          localObject2 = ((TianShuAccess.MapEntry)localObject2).value.get();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, new Object[] { "handleAio2dBubbleAdv keyStr:", str2, ", valueStr=", localObject2 });
          }
          if ((k != 0) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
          {
            localHashMap.put(str2, localObject2);
            continue;
            k = 0;
            break;
          }
        }
      }
      j += 1;
      break label107;
      for (;;)
      {
        try
        {
          paramRspEntry = getApp();
          if (paramRspEntry != null)
          {
            paramRspEntry = paramRspEntry.getApp().getSharedPreferences("apollo_sp" + paramRspEntry.getCurrentUin(), 0);
            if (paramRspEntry == null) {
              break label807;
            }
            j = paramRspEntry.getInt("key_2d_bubble_ad_id", 0);
            QLog.d("ApolloManager", 1, new Object[] { "handleAio2dBubbleAdv oldAdId:", Integer.valueOf(j), ", newAdId=", Integer.valueOf(i) });
            if (j == i) {
              break;
            }
            localObject1 = new DrawerPushItem();
            ((DrawerPushItem)localObject1).is_reddot = 0;
            ((DrawerPushItem)localObject1).msg_id = "aio_panel_bubble_push";
            ((DrawerPushItem)localObject1).msg_type = 7;
            ((DrawerPushItem)localObject1).priority = 1000;
            k = (int)Long.parseLong((String)localHashMap.get("startTime")) / 1000;
            ((DrawerPushItem)localObject1).start_ts = k;
            j = (int)NetConnInfoCenter.getServerTime();
            ((DrawerPushItem)localObject1).end_ts = ((int)Long.parseLong((String)localHashMap.get("endTime")) / 1000 - k + j);
            ((DrawerPushItem)localObject1).send_time = k;
            ((DrawerPushItem)localObject1).content = ((String)localHashMap.get("bubbleText"));
            ((DrawerPushItem)localObject1).show_counts = Integer.parseInt((String)localHashMap.get("showCount"));
            ((DrawerPushItem)localObject1).tianshuAdId = i;
            ((DrawerPushItem)localObject1).tianshuTraceInfo = str1;
            if (((DrawerPushItem)localObject1).show_counts == 0) {
              ((DrawerPushItem)localObject1).show_counts = 1;
            }
            str1 = (String)localHashMap.get("packageId");
            i = 0;
            if (!TextUtils.isEmpty(str1)) {
              i = Integer.parseInt(str1);
            }
            if (!ApolloActionPackage.is3DPackage(i)) {
              break label812;
            }
            j = 3;
            ((DrawerPushItem)localObject1).target_model = j;
            addPushItem((DrawerPushItem)localObject1);
            paramRspEntry = paramRspEntry.edit();
            paramRspEntry.putInt("key_2d_bubble_ad_id", k);
            if (i >= 0) {
              paramRspEntry.putInt("key_panel_bubble_tab", i);
            }
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, new Object[] { "handleAio2dBubbleAdv", " push bubble:", ((DrawerPushItem)localObject1).toString(), " ,packageId:", Integer.valueOf(i) });
            }
            paramRspEntry.commit();
            return;
          }
        }
        catch (Throwable paramRspEntry)
        {
          QLog.e("ApolloManager", 1, "handleAio2dBubbleAdv Exception:", paramRspEntry);
          return;
        }
        paramRspEntry = null;
        continue;
        j = 0;
        continue;
        j = 2;
      }
    }
  }
  
  private void handleAio2dNewActionTipsAdv(TianShuAccess.RspEntry paramRspEntry)
  {
    QLog.d("ApolloManager", 1, "handleAio2dNewActionTipsAdv");
    if ((paramRspEntry == null) || (paramRspEntry.value == null) || (paramRspEntry.value.lst == null) || (paramRspEntry.value.lst.size() == 0))
    {
      QLog.e("ApolloManager", 1, "handleAio2dNewActionTipsAdv, data empty");
      return;
    }
    int n = paramRspEntry.value.lst.size();
    QLog.d("ApolloManager", 1, new Object[] { "handleAio2dNewActionTipsAdv, size=", Integer.valueOf(n) });
    Object localObject1 = new HashMap();
    int i = -1;
    String str = "";
    int j = 0;
    int m;
    Object localObject4;
    while (j < n)
    {
      localObject2 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).argList.get();
      m = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).iAdId.get();
      QLog.d("ApolloManager", 1, new Object[] { "handleAio2dNewActionTipsAdv, adId=", Integer.valueOf(m), ", i=", Integer.valueOf(j) });
      if (j == n - 1) {}
      for (k = 1;; k = 0)
      {
        if (k == 0) {
          break label932;
        }
        str = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).traceinfo.get();
        i = m;
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (TianShuAccess.MapEntry)((Iterator)localObject2).next();
          localObject3 = ((TianShuAccess.MapEntry)localObject4).key.get();
          localObject4 = ((TianShuAccess.MapEntry)localObject4).value.get();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, new Object[] { "handleAio2dNewActionTipsAdv keyStr:", localObject3, ", valueStr=", localObject4 });
          }
          if ((k != 0) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject4))) {
            ((Map)localObject1).put(localObject3, localObject4);
          }
        }
      }
      j += 1;
    }
    for (;;)
    {
      try
      {
        localObject2 = getApp();
        if (localObject2 != null)
        {
          paramRspEntry = ((QQAppInterface)localObject2).getApp().getSharedPreferences("apollo_sp" + ((QQAppInterface)localObject2).getCurrentUin(), 0);
          if (paramRspEntry == null) {
            break label524;
          }
          j = paramRspEntry.getInt("key_new_2d_action_adid", 0);
          QLog.d("ApolloManager", 1, new Object[] { "handleAio2dNewActionTipsAdv, oldAdId=", Integer.valueOf(j), ", newAdId=", Integer.valueOf(i) });
          if (j == i) {
            break;
          }
          localObject3 = (String)((Map)localObject1).get("packageIdList");
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            break label529;
          }
          QLog.e("ApolloManager", 1, "handleAio2dNewActionTipsAdv, packageIdListStr null");
          return;
        }
      }
      catch (Throwable paramRspEntry)
      {
        QLog.e("ApolloManager", 1, "handleAio2dNewActionTipsAdv Exception:", paramRspEntry);
        return;
      }
      paramRspEntry = null;
      continue;
      label524:
      j = 0;
    }
    label529:
    int k = Integer.parseInt((String)((Map)localObject1).get("actionId"));
    long l1 = Long.parseLong((String)((Map)localObject1).get("startTime"));
    long l2 = Long.parseLong((String)((Map)localObject1).get("endTime")) - l1;
    Object localObject3 = ((String)localObject3).split(";");
    if ((localObject3 == null) || (localObject3.length == 0))
    {
      QLog.e("ApolloManager", 1, "handleAio2dNewActionTipsAdv, pkgIdList null");
      return;
    }
    if (localObject2 != null)
    {
      localObject1 = (ApolloDaoManagerServiceImpl)((QQAppInterface)localObject2).getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
      label635:
      if (localObject1 == null) {
        break label948;
      }
    }
    label932:
    label948:
    for (Object localObject2 = ((ApolloDaoManagerServiceImpl)localObject1).findActionById(k);; localObject2 = null)
    {
      m = localObject3.length;
      j = 0;
      for (;;)
      {
        if (j < m)
        {
          localObject4 = localObject3[j];
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            n = Integer.parseInt((String)localObject4);
            QLog.d("ApolloManager", 1, new Object[] { "handleAio2dNewActionTipsAdv, pkgId=", Integer.valueOf(n) });
            if (localObject2 != null)
            {
              localObject5 = ((ApolloDaoManagerServiceImpl)localObject1).findPackageById(n);
              if (localObject5 != null)
              {
                ((ApolloActionPackage)localObject5).isUpdate = true;
                ((ApolloActionPackage)localObject5).redFlowId = k;
                ((ApolloActionPackage)localObject5).redStartTime = l1;
                ((ApolloActionPackage)localObject5).redInterval = l2;
                ((ApolloDaoManagerServiceImpl)localObject1).updatePackage((ApolloActionPackage)localObject5);
                saveRedAppearTime(n);
                QLog.d("ApolloManager", 1, new Object[] { "handleAio2dNewActionTipsAdv, update red info to db, pkgId=", Integer.valueOf(n), ", actionId=", Integer.valueOf(k) });
              }
            }
            Object localObject5 = new JSONObject();
            ((JSONObject)localObject5).put("actionId", k);
            ((JSONObject)localObject5).put("startTime", l1);
            ((JSONObject)localObject5).put("interval", l2);
            ((JSONObject)localObject5).put("adId", i);
            ((JSONObject)localObject5).put("traceInfo", str);
            paramRspEntry.edit().putString(String.format("key_new_action_info_%s", new Object[] { localObject4 }), ((JSONObject)localObject5).toString()).commit();
          }
        }
        else
        {
          paramRspEntry.edit().putInt("key_new_2d_action_adid", i).commit();
          return;
          break;
        }
        j += 1;
      }
      localObject1 = null;
      break label635;
    }
  }
  
  private void handleAio3dBubbleAdv(TianShuAccess.RspEntry paramRspEntry)
  {
    QLog.d("ApolloManager", 1, "handleAio3dBubbleAdv");
    if ((paramRspEntry == null) || (paramRspEntry.value == null) || (paramRspEntry.value.lst == null) || (paramRspEntry.value.lst.size() == 0))
    {
      QLog.e("ApolloManager", 1, "handleAio3dBubbleAdv, data empty");
      return;
    }
    int i = 0;
    String str1 = "";
    int n = paramRspEntry.value.lst.size();
    QLog.d("ApolloManager", 1, new Object[] { "handleAio3dBubbleAdv, size=", Integer.valueOf(n) });
    HashMap localHashMap = new HashMap();
    int j = 0;
    Object localObject1;
    int k;
    if (j < n)
    {
      localObject1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).argList.get();
      int m = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).iAdId.get();
      QLog.d("ApolloManager", 1, new Object[] { "handleAio3dBubbleAdv, adId=", Integer.valueOf(m), ", i=", Integer.valueOf(j) });
      if (j == n - 1)
      {
        k = 1;
        if (k == 0) {
          break label401;
        }
        str1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).traceinfo.get();
        i = m;
      }
    }
    label401:
    for (;;)
    {
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (TianShuAccess.MapEntry)((Iterator)localObject1).next();
          String str2 = ((TianShuAccess.MapEntry)localObject2).key.get();
          localObject2 = ((TianShuAccess.MapEntry)localObject2).value.get();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, new Object[] { "handleAio3dBubbleAdv keyStr:", str2, ", valueStr=", localObject2 });
          }
          if ((k != 0) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
          {
            localHashMap.put(str2, localObject2);
            continue;
            k = 0;
            break;
          }
        }
      }
      j += 1;
      break;
      if (localHashMap == null)
      {
        QLog.e("ApolloManager", 1, "handleAio3dBubbleAdv map null");
        return;
      }
      getBubbleProducer().a(localHashMap, i, str1);
      return;
    }
  }
  
  private void handleAio3dNewActionTipsAdv(TianShuAccess.RspEntry paramRspEntry)
  {
    QLog.d("ApolloManager", 1, "handleAio3dNewActionTipsAdv");
    if ((paramRspEntry == null) || (paramRspEntry.value == null) || (paramRspEntry.value.lst == null) || (paramRspEntry.value.lst.size() == 0))
    {
      QLog.e("ApolloManager", 1, "handleAio3dNewActionTipsAdv, data empty");
      return;
    }
    int n = paramRspEntry.value.lst.size();
    QLog.d("ApolloManager", 1, new Object[] { "handleAio3dNewActionTipsAdv, size=", Integer.valueOf(n) });
    Object localObject1 = new HashMap();
    int i = -1;
    String str = "";
    int j = 0;
    int m;
    Object localObject4;
    while (j < n)
    {
      localObject2 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).argList.get();
      m = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).iAdId.get();
      QLog.d("ApolloManager", 1, new Object[] { "handleAio3dNewActionTipsAdv, adId=", Integer.valueOf(m), ", i=", Integer.valueOf(j) });
      if (j == n - 1) {}
      for (k = 1;; k = 0)
      {
        if (k == 0) {
          break label932;
        }
        str = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).traceinfo.get();
        i = m;
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (TianShuAccess.MapEntry)((Iterator)localObject2).next();
          localObject3 = ((TianShuAccess.MapEntry)localObject4).key.get();
          localObject4 = ((TianShuAccess.MapEntry)localObject4).value.get();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, new Object[] { "handleAio3dNewActionTipsAdv keyStr:", localObject3, ", valueStr=", localObject4 });
          }
          if ((k != 0) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject4))) {
            ((Map)localObject1).put(localObject3, localObject4);
          }
        }
      }
      j += 1;
    }
    for (;;)
    {
      try
      {
        localObject2 = getApp();
        if (localObject2 != null)
        {
          paramRspEntry = ((QQAppInterface)localObject2).getApp().getSharedPreferences("apollo_sp" + ((QQAppInterface)localObject2).getCurrentUin(), 0);
          if (paramRspEntry == null) {
            break label524;
          }
          j = paramRspEntry.getInt("key_new_3d_action_adid", 0);
          QLog.d("ApolloManager", 1, new Object[] { "handleAio3dNewActionTipsAdv, oldAdId=", Integer.valueOf(j), ", newAdId=", Integer.valueOf(i) });
          if (j == i) {
            break;
          }
          localObject3 = (String)((Map)localObject1).get("packageIdList");
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            break label529;
          }
          QLog.e("ApolloManager", 1, "handleAio3dNewActionTipsAdv, packageIdListStr null");
          return;
        }
      }
      catch (Throwable paramRspEntry)
      {
        QLog.e("ApolloManager", 1, "handleAio3dNewActionTipsAdv Exception:", paramRspEntry);
        return;
      }
      paramRspEntry = null;
      continue;
      label524:
      j = 0;
    }
    label529:
    int k = Integer.parseInt((String)((Map)localObject1).get("actionId"));
    long l1 = Long.parseLong((String)((Map)localObject1).get("startTime"));
    long l2 = Long.parseLong((String)((Map)localObject1).get("endTime")) - l1;
    Object localObject3 = ((String)localObject3).split(";");
    if ((localObject3 == null) || (localObject3.length == 0))
    {
      QLog.e("ApolloManager", 1, "handleAio3dNewActionTipsAdv, pkgIdList null");
      return;
    }
    if (localObject2 != null)
    {
      localObject1 = (ApolloDaoManagerServiceImpl)((QQAppInterface)localObject2).getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
      label635:
      if (localObject1 == null) {
        break label948;
      }
    }
    label932:
    label948:
    for (Object localObject2 = ((ApolloDaoManagerServiceImpl)localObject1).findActionById(k);; localObject2 = null)
    {
      m = localObject3.length;
      j = 0;
      for (;;)
      {
        if (j < m)
        {
          localObject4 = localObject3[j];
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            n = Integer.parseInt((String)localObject4);
            QLog.d("ApolloManager", 1, new Object[] { "handleAio3dNewActionTipsAdv, pkgId=", Integer.valueOf(n) });
            if (localObject2 != null)
            {
              localObject5 = ((ApolloDaoManagerServiceImpl)localObject1).findPackageById(n);
              if (localObject5 != null)
              {
                ((ApolloActionPackage)localObject5).isUpdate = true;
                ((ApolloActionPackage)localObject5).redFlowId = k;
                ((ApolloActionPackage)localObject5).redStartTime = l1;
                ((ApolloActionPackage)localObject5).redInterval = l2;
                ((ApolloDaoManagerServiceImpl)localObject1).updatePackage((ApolloActionPackage)localObject5);
                saveRedAppearTime(n);
                QLog.d("ApolloManager", 1, new Object[] { "handleAio3dNewActionTipsAdv, update red info to db, pkgId=", Integer.valueOf(n), ", actionId=", Integer.valueOf(k) });
              }
            }
            Object localObject5 = new JSONObject();
            ((JSONObject)localObject5).put("actionId", k);
            ((JSONObject)localObject5).put("startTime", l1);
            ((JSONObject)localObject5).put("interval", l2);
            ((JSONObject)localObject5).put("adId", i);
            ((JSONObject)localObject5).put("traceInfo", str);
            paramRspEntry.edit().putString(String.format("key_new_action_info_%s", new Object[] { localObject4 }), ((JSONObject)localObject5).toString()).commit();
          }
        }
        else
        {
          paramRspEntry.edit().putInt("key_new_3d_action_adid", i).commit();
          return;
          break;
        }
        j += 1;
      }
      localObject1 = null;
      break label635;
    }
  }
  
  private void handleAioKapuEntranceTipsAdv(TianShuAccess.RspEntry paramRspEntry)
  {
    QLog.d("ApolloManager", 1, "handleAioKapuEntranceTipsAdv");
    if ((paramRspEntry == null) || (paramRspEntry.value == null) || (paramRspEntry.value.lst == null) || (paramRspEntry.value.lst.size() == 0))
    {
      QLog.e("ApolloManager", 1, "handleAioKapuEntranceTipsAdv, data empty");
      return;
    }
    int j = paramRspEntry.value.lst.size();
    QLog.d("ApolloManager", 1, new Object[] { "handleAioKapuEntranceTipsAdv, size=", Integer.valueOf(j) });
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < j)
    {
      Object localObject1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(i)).argList.get();
      int k = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(i)).iAdId.get();
      String str = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(i)).traceinfo.get();
      QLog.d("ApolloManager", 1, new Object[] { "handleAioKapuEntranceTipsAdv, adId=", Integer.valueOf(k), ", i=", Integer.valueOf(i) });
      ApolloKapuEntranceTips localApolloKapuEntranceTips = new ApolloKapuEntranceTips();
      localApolloKapuEntranceTips.adId = k;
      localApolloKapuEntranceTips.traceInfo = str;
      label238:
      Object localObject2;
      label360:
      label367:
      label508:
      do
      {
        for (;;)
        {
          try
          {
            localObject1 = ((List)localObject1).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break label541;
            }
            localObject2 = (TianShuAccess.MapEntry)((Iterator)localObject1).next();
            str = ((TianShuAccess.MapEntry)localObject2).key.get();
            localObject2 = ((TianShuAccess.MapEntry)localObject2).value.get();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, new Object[] { "handleAioKapuEntranceTipsAdv keyStr:", str, ", valueStr=", localObject2 });
            }
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              continue;
            }
            if (!"bubbleText".equals(str)) {
              break label367;
            }
            localApolloKapuEntranceTips.text = ((String)localObject2);
            continue;
            i += 1;
          }
          catch (Throwable localThrowable)
          {
            QLog.e("ApolloManager", 1, "handleAioKapuEntranceTipsAdv, parse exception=", localThrowable);
          }
          break;
          if ("startTime".equals(str))
          {
            localThrowable.startTime = Long.parseLong((String)localObject2);
          }
          else if ("endTime".equals(str))
          {
            localThrowable.endTime = Long.parseLong((String)localObject2);
          }
          else if ("showCount".equals(str))
          {
            localThrowable.showCount = Integer.parseInt((String)localObject2);
          }
          else if ("duration".equals(str))
          {
            localThrowable.duration = Long.parseLong((String)localObject2);
          }
          else if ("jumpUrl".equals(str))
          {
            localThrowable.activityUrl = ((String)localObject2);
          }
          else
          {
            if (!"priority".equals(str)) {
              break label508;
            }
            localThrowable.priority = Integer.parseInt((String)localObject2);
          }
        }
      } while (!"isInstall".equals(str));
      if (Integer.parseInt((String)localObject2) != 1) {
        break label582;
      }
    }
    label541:
    label582:
    for (boolean bool = true;; bool = false)
    {
      localThrowable.isInstall = bool;
      break label238;
      localArrayList.add(localThrowable);
      break label360;
      paramRspEntry = getApp();
      if (paramRspEntry == null) {
        break;
      }
      ((ApolloDaoManagerServiceImpl)paramRspEntry.getRuntimeService(IApolloDaoManagerService.class, "all")).updateAllKapuTipsFromTianshu(localArrayList);
      return;
    }
  }
  
  private void handleDrawerBubbleAdv(TianShuAccess.RspEntry paramRspEntry, boolean paramBoolean)
  {
    QLog.d("ApolloManager", 1, new Object[] { "handleDrawerBubbleAdv, is2d=", Boolean.valueOf(paramBoolean) });
    if ((paramRspEntry == null) || (paramRspEntry.value == null) || (paramRspEntry.value.lst == null) || (paramRspEntry.value.lst.size() == 0))
    {
      QLog.e("ApolloManager", 1, "handleDrawerBubbleAdv, data empty");
      return;
    }
    int k = paramRspEntry.value.lst.size();
    QLog.d("ApolloManager", 1, new Object[] { "handleDrawerBubbleAdv, size=", Integer.valueOf(k) });
    new ArrayList();
    int i = 0;
    label113:
    int m;
    Object localObject3;
    if (i < k)
    {
      localObject2 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(i)).argList.get();
      m = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(i)).iAdId.get();
      localObject3 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(i)).traceinfo.get();
      QLog.d("ApolloManager", 1, new Object[] { "handleDrawerBubbleAdv, adId=", Integer.valueOf(m), ", i=", Integer.valueOf(i) });
      if (i != k - 1) {
        break label412;
      }
      j = 1;
      label233:
      if (j == 0) {
        break label851;
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("adId", m);
        localJSONObject.put("traceInfo", localObject3);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject4 = (TianShuAccess.MapEntry)((Iterator)localObject2).next();
          localObject3 = ((TianShuAccess.MapEntry)localObject4).key.get();
          localObject4 = ((TianShuAccess.MapEntry)localObject4).value.get();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, new Object[] { "handleDrawerBubbleAdv keyStr:", localObject3, ", valueStr=", localObject4 });
          }
          if ((j != 0) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject4)))
          {
            localJSONObject.put((String)localObject3, localObject4);
            continue;
            i += 1;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ApolloManager", 1, "handleDrawerBubbleAdv, parse exception=", localThrowable);
      }
    }
    label412:
    while (j == 0)
    {
      break label113;
      break;
      j = 0;
      break label233;
    }
    Object localObject2 = new DrawerPushItem();
    ((DrawerPushItem)localObject2).fromTianshu = true;
    ((DrawerPushItem)localObject2).msg_type = 0;
    ((DrawerPushItem)localObject2).is_reddot = 1;
    ((DrawerPushItem)localObject2).msg_id = String.valueOf(m);
    ((DrawerPushItem)localObject2).tips_str = localThrowable.optString("content");
    ((DrawerPushItem)localObject2).act_id = localThrowable.optString("id");
    ((DrawerPushItem)localObject2).priority = localThrowable.optInt("mainPriority");
    ((DrawerPushItem)localObject2).sub_priority = localThrowable.optInt("subPriority");
    ((DrawerPushItem)localObject2).start_ts = localThrowable.optInt("showTime");
    ((DrawerPushItem)localObject2).end_ts = localThrowable.optInt("expireTime");
    if (((DrawerPushItem)localObject2).start_ts == 0)
    {
      ((DrawerPushItem)localObject2).start_ts = ((int)(System.currentTimeMillis() / 1000L));
      localObject3 = Calendar.getInstance();
      ((Calendar)localObject3).set(11, ((Calendar)localObject3).getActualMaximum(11));
      ((Calendar)localObject3).set(12, ((Calendar)localObject3).getActualMaximum(12));
      ((Calendar)localObject3).set(13, ((Calendar)localObject3).getActualMaximum(13));
      ((DrawerPushItem)localObject2).end_ts = ((int)(((Calendar)localObject3).getTimeInMillis() / 1000L));
    }
    ((DrawerPushItem)localObject2).send_time = localThrowable.optInt("time");
    ((DrawerPushItem)localObject2).action_id = localThrowable.optInt("actionId");
    ((DrawerPushItem)localObject2).content = localThrowable.optString("bubbleText");
    ((DrawerPushItem)localObject2).bubble_res_id = localThrowable.optInt("bubbleID");
    if (paramBoolean) {}
    for (int j = 2;; j = 3)
    {
      ((DrawerPushItem)localObject2).target_model = j;
      j = localThrowable.optInt("type");
      ((DrawerPushItem)localObject2).scheme = localThrowable.optString("scheme");
      if (j == 0) {
        ((DrawerPushItem)localObject2).ext_url = localThrowable.optString("url");
      }
      for (;;)
      {
        ((DrawerPushItem)localObject2).show_counts = localThrowable.optInt("showCounts");
        if (((DrawerPushItem)localObject2).show_counts <= 0) {
          ((DrawerPushItem)localObject2).show_counts = 3;
        }
        ((DrawerPushItem)localObject2).tianshuAdId = localThrowable.optInt("adId");
        ((DrawerPushItem)localObject2).tianshuTraceInfo = localThrowable.optString("traceInfo");
        QLog.d("ApolloManager", 1, new Object[] { "handleDrawerBubbleAdv addPushItem=", localObject2 });
        addPushItem((DrawerPushItem)localObject2, false);
        break;
        if (j == 1) {
          ((DrawerPushItem)localObject2).ext_url = ApolloConstant.g;
        } else if (j == 2) {
          ((DrawerPushItem)localObject2).ext_url = localThrowable.optString("url");
        }
      }
      label851:
      Object localObject1 = null;
      break;
    }
  }
  
  private void handleKapuDownloadAdv(TianShuAccess.RspEntry paramRspEntry)
  {
    QLog.d("ApolloManager", 1, "handleKapuDownloadAdv");
    if ((paramRspEntry == null) || (paramRspEntry.value == null) || (paramRspEntry.value.lst == null) || (paramRspEntry.value.lst.size() == 0))
    {
      QLog.e("ApolloManager", 1, "handleKapuDownloadAdv, data empty");
      return;
    }
    int n = paramRspEntry.value.lst.size();
    QLog.d("ApolloManager", 1, new Object[] { "handleKapuDownloadAdv, size=", Integer.valueOf(n) });
    int i = -1;
    String str1 = "";
    HashMap localHashMap = new HashMap();
    int j = 0;
    Object localObject1;
    int k;
    if (j < n)
    {
      localObject1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).argList.get();
      int m = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).iAdId.get();
      QLog.d("ApolloManager", 1, new Object[] { "handleKapuDownloadAdv, adId=", Integer.valueOf(m), ", i=", Integer.valueOf(j) });
      if (j == n - 1)
      {
        k = 1;
        if (k == 0) {
          break label397;
        }
        str1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(j)).traceinfo.get();
        i = m;
      }
    }
    label397:
    for (;;)
    {
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (TianShuAccess.MapEntry)((Iterator)localObject1).next();
          String str2 = ((TianShuAccess.MapEntry)localObject2).key.get();
          localObject2 = ((TianShuAccess.MapEntry)localObject2).value.get();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, new Object[] { "handleKapuDownloadAdv keyStr:", str2, ", valueStr=", localObject2 });
          }
          if ((k != 0) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
          {
            localHashMap.put(str2, localObject2);
            continue;
            k = 0;
            break;
          }
        }
      }
      j += 1;
      break;
      if (localHashMap == null)
      {
        QLog.e("ApolloManager", 1, "handleKapuDownloadAdv map null");
        return;
      }
      App3DConfig.a(localHashMap, i, str1);
      return;
    }
  }
  
  /* Error */
  private void initApolloBaseInfoCache()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: invokestatic 826	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 34
    //   10: iconst_2
    //   11: ldc_w 1653
    //   14: invokestatic 836	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: invokespecial 465	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:getApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: astore 7
    //   23: aload_0
    //   24: getfield 1655	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:isApolloBaseInfoCacheInited	Z
    //   27: ifne +605 -> 632
    //   30: aload_0
    //   31: getfield 1655	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:isApolloBaseInfoCacheInited	Z
    //   34: ifeq +4 -> 38
    //   37: return
    //   38: aload 7
    //   40: ifnull +320 -> 360
    //   43: aload 7
    //   45: invokevirtual 510	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   48: astore 6
    //   50: invokestatic 919	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   53: lstore 4
    //   55: aload_0
    //   56: invokespecial 397	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:getEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   59: astore 8
    //   61: aload 8
    //   63: ifnull -26 -> 37
    //   66: aload 8
    //   68: ldc_w 275
    //   71: invokevirtual 1661	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   74: checkcast 249	java/util/ArrayList
    //   77: astore 9
    //   79: aload 9
    //   81: ifnull +546 -> 627
    //   84: aload 9
    //   86: invokevirtual 1662	java/util/ArrayList:size	()I
    //   89: istore_1
    //   90: aload 9
    //   92: invokevirtual 1663	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   95: astore 10
    //   97: aload 10
    //   99: invokeinterface 648 1 0
    //   104: ifeq +272 -> 376
    //   107: aload 10
    //   109: invokeinterface 652 1 0
    //   114: checkcast 1665	com/tencent/mobileqq/persistence/Entity
    //   117: checkcast 275	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo
    //   120: astore 11
    //   122: aload 11
    //   124: ifnull -27 -> 97
    //   127: aload 11
    //   129: getfield 1668	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:uin	Ljava/lang/String;
    //   132: invokestatic 499	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   135: ifne -38 -> 97
    //   138: lload 4
    //   140: aload 11
    //   142: getfield 1671	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:apolloSignValidTS	J
    //   145: lcmp
    //   146: ifle +19 -> 165
    //   149: aload 11
    //   151: aload 11
    //   153: getfield 1671	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:apolloSignValidTS	J
    //   156: putfield 1674	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:apolloLocalSignTs	J
    //   159: aload 11
    //   161: aconst_null
    //   162: putfield 1677	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:apolloSignStr	Ljava/lang/String;
    //   165: aload_0
    //   166: getfield 284	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mApolloBaseInfoCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   169: astore 9
    //   171: aload 9
    //   173: monitorenter
    //   174: aload_0
    //   175: getfield 284	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mApolloBaseInfoCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   178: aload 11
    //   180: getfield 1668	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:uin	Ljava/lang/String;
    //   183: aload 11
    //   185: invokevirtual 1680	com/tencent/commonsdk/cache/QQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   188: pop
    //   189: aload 9
    //   191: monitorexit
    //   192: aload 11
    //   194: getfield 1668	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:uin	Ljava/lang/String;
    //   197: aload 6
    //   199: invokevirtual 660	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   202: ifeq -105 -> 97
    //   205: aload_0
    //   206: aload 11
    //   208: putfield 381	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mSelfApolloBaseInfo	Lcom/tencent/mobileqq/apollo/api/model/ApolloBaseInfo;
    //   211: aload_0
    //   212: aload_0
    //   213: getfield 381	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mSelfApolloBaseInfo	Lcom/tencent/mobileqq/apollo/api/model/ApolloBaseInfo;
    //   216: getfield 1683	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:apolloAISwitch	I
    //   219: iconst_0
    //   220: invokevirtual 1686	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:updateUserFlag	(II)V
    //   223: goto -126 -> 97
    //   226: astore 6
    //   228: invokestatic 826	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq +14 -> 245
    //   234: ldc 34
    //   236: iconst_2
    //   237: ldc_w 1688
    //   240: aload 6
    //   242: invokestatic 992	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   245: invokestatic 826	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq -211 -> 37
    //   251: aload 7
    //   253: ifnull -216 -> 37
    //   256: aload_0
    //   257: getfield 284	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mApolloBaseInfoCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   260: aload 7
    //   262: invokevirtual 510	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   265: invokevirtual 1689	com/tencent/commonsdk/cache/QQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   268: checkcast 275	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo
    //   271: astore 6
    //   273: aload 6
    //   275: ifnull +9 -> 284
    //   278: aload 6
    //   280: getfield 1692	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:apolloStatus	I
    //   283: istore_2
    //   284: aload 6
    //   286: ifnull +329 -> 615
    //   289: aload 6
    //   291: getfield 1695	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:cmshow3dFlag	I
    //   294: iconst_1
    //   295: iand
    //   296: istore_3
    //   297: ldc 34
    //   299: iconst_2
    //   300: new 797	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 798	java/lang/StringBuilder:<init>	()V
    //   307: ldc_w 1697
    //   310: invokevirtual 807	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload_0
    //   314: getfield 284	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mApolloBaseInfoCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   317: invokevirtual 1698	com/tencent/commonsdk/cache/QQLruCache:size	()I
    //   320: invokevirtual 802	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   323: ldc_w 1700
    //   326: invokevirtual 807	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: iload_1
    //   330: invokevirtual 802	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   333: ldc_w 1702
    //   336: invokevirtual 807	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: iload_2
    //   340: invokevirtual 802	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   343: ldc_w 1704
    //   346: invokevirtual 807	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: iload_3
    //   350: invokevirtual 802	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   353: invokevirtual 812	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 836	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   359: return
    //   360: ldc_w 547
    //   363: astore 6
    //   365: goto -315 -> 50
    //   368: astore 6
    //   370: aload 9
    //   372: monitorexit
    //   373: aload 6
    //   375: athrow
    //   376: aload 8
    //   378: ldc_w 654
    //   381: invokevirtual 1661	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   384: checkcast 249	java/util/ArrayList
    //   387: astore 9
    //   389: aload 9
    //   391: ifnull +124 -> 515
    //   394: aload_0
    //   395: getfield 247	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mPushLock	Ljava/lang/Object;
    //   398: astore 6
    //   400: aload 6
    //   402: monitorenter
    //   403: aload_0
    //   404: getfield 252	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mDrawerPushItems	Ljava/util/List;
    //   407: invokeinterface 1707 1 0
    //   412: invokestatic 1280	java/lang/System:currentTimeMillis	()J
    //   415: ldc2_w 878
    //   418: ldiv
    //   419: lstore 4
    //   421: aload 9
    //   423: invokeinterface 643 1 0
    //   428: astore 9
    //   430: aload 9
    //   432: invokeinterface 648 1 0
    //   437: ifeq +75 -> 512
    //   440: aload 9
    //   442: invokeinterface 652 1 0
    //   447: checkcast 654	com/tencent/mobileqq/DrawerPushItem
    //   450: astore 10
    //   452: aload 10
    //   454: getfield 924	com/tencent/mobileqq/DrawerPushItem:end_ts	I
    //   457: i2l
    //   458: lload 4
    //   460: lcmp
    //   461: ifle +40 -> 501
    //   464: aload_0
    //   465: aload 10
    //   467: invokespecial 1709	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:alreadyContainsItem	(Lcom/tencent/mobileqq/DrawerPushItem;)Z
    //   470: ifne +31 -> 501
    //   473: aload_0
    //   474: getfield 252	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mDrawerPushItems	Ljava/util/List;
    //   477: aload 10
    //   479: invokeinterface 627 2 0
    //   484: pop
    //   485: goto -55 -> 430
    //   488: astore 8
    //   490: aload 6
    //   492: monitorexit
    //   493: aload 8
    //   495: athrow
    //   496: astore 6
    //   498: goto -270 -> 228
    //   501: aload 8
    //   503: aload 10
    //   505: invokevirtual 1713	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   508: pop
    //   509: goto -79 -> 430
    //   512: aload 6
    //   514: monitorexit
    //   515: aload 7
    //   517: ifnull +59 -> 576
    //   520: aload 7
    //   522: invokevirtual 510	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   525: astore 6
    //   527: aload_0
    //   528: invokestatic 1254	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   531: ldc_w 1715
    //   534: iconst_4
    //   535: invokevirtual 1716	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   538: new 797	java/lang/StringBuilder
    //   541: dup
    //   542: invokespecial 798	java/lang/StringBuilder:<init>	()V
    //   545: aload 6
    //   547: invokevirtual 807	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: ldc_w 804
    //   553: invokevirtual 807	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: ldc_w 1718
    //   559: invokevirtual 807	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: invokevirtual 812	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: ldc_w 547
    //   568: invokeinterface 1005 3 0
    //   573: putfield 1720	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mLastShopTab	Ljava/lang/String;
    //   576: aload_0
    //   577: getfield 381	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mSelfApolloBaseInfo	Lcom/tencent/mobileqq/apollo/api/model/ApolloBaseInfo;
    //   580: ifnonnull +27 -> 607
    //   583: aload 7
    //   585: ifnull +22 -> 607
    //   588: aload 7
    //   590: getstatic 1725	com/tencent/mobileqq/app/BusinessHandlerFactory:APOLLO_EXTENSION_HANDLER	Ljava/lang/String;
    //   593: invokevirtual 1729	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   596: checkcast 1731	com/tencent/mobileqq/apollo/api/handler/impl/ApolloExtensionHandlerImpl
    //   599: aload 7
    //   601: invokevirtual 678	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   604: invokevirtual 1733	com/tencent/mobileqq/apollo/api/handler/impl/ApolloExtensionHandlerImpl:b	(Ljava/lang/String;)V
    //   607: aload_0
    //   608: iconst_1
    //   609: putfield 1655	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:isApolloBaseInfoCacheInited	Z
    //   612: goto -367 -> 245
    //   615: iconst_m1
    //   616: istore_3
    //   617: goto -320 -> 297
    //   620: astore 6
    //   622: iconst_0
    //   623: istore_1
    //   624: goto -396 -> 228
    //   627: iconst_0
    //   628: istore_1
    //   629: goto -253 -> 376
    //   632: iconst_0
    //   633: istore_1
    //   634: goto -389 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	637	0	this	ApolloManagerServiceImpl
    //   89	545	1	i	int
    //   1	339	2	j	int
    //   296	321	3	k	int
    //   53	406	4	l	long
    //   48	150	6	str1	String
    //   226	15	6	localOutOfMemoryError1	OutOfMemoryError
    //   271	93	6	localObject1	Object
    //   368	6	6	localObject2	Object
    //   496	17	6	localOutOfMemoryError2	OutOfMemoryError
    //   525	21	6	str2	String
    //   620	1	6	localOutOfMemoryError3	OutOfMemoryError
    //   21	579	7	localQQAppInterface	QQAppInterface
    //   59	318	8	localEntityManager	EntityManager
    //   488	14	8	localObject4	Object
    //   95	409	10	localObject6	Object
    //   120	87	11	localApolloBaseInfo	ApolloBaseInfo
    // Exception table:
    //   from	to	target	type
    //   90	97	226	java/lang/OutOfMemoryError
    //   97	122	226	java/lang/OutOfMemoryError
    //   127	165	226	java/lang/OutOfMemoryError
    //   165	174	226	java/lang/OutOfMemoryError
    //   192	223	226	java/lang/OutOfMemoryError
    //   373	376	226	java/lang/OutOfMemoryError
    //   174	192	368	finally
    //   370	373	368	finally
    //   403	430	488	finally
    //   430	485	488	finally
    //   490	493	488	finally
    //   501	509	488	finally
    //   512	515	488	finally
    //   376	389	496	java/lang/OutOfMemoryError
    //   394	403	496	java/lang/OutOfMemoryError
    //   493	496	496	java/lang/OutOfMemoryError
    //   520	576	496	java/lang/OutOfMemoryError
    //   576	583	496	java/lang/OutOfMemoryError
    //   588	607	496	java/lang/OutOfMemoryError
    //   607	612	496	java/lang/OutOfMemoryError
    //   50	61	620	java/lang/OutOfMemoryError
    //   66	79	620	java/lang/OutOfMemoryError
    //   84	90	620	java/lang/OutOfMemoryError
  }
  
  private void initApolloMsgObserver()
  {
    if (this.mMessageObserver != null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      this.mMessageObserver = new ApolloManagerServiceImpl.2(this);
      localQQAppInterface = getApp();
    } while ((localQQAppInterface == null) || (this.mMessageObserver == null));
    localQQAppInterface.addDefaultObservers(this.mMessageObserver);
  }
  
  private void initApolloPandoraCache()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "initApolloPandoraCache begin...");
    }
    try
    {
      ??? = getEntityManager();
      if (??? == null) {
        return;
      }
      ??? = (ArrayList)((EntityManager)???).query(ApolloPandora.class);
      if (??? != null)
      {
        Iterator localIterator = ((ArrayList)???).iterator();
        while (localIterator.hasNext())
        {
          ApolloPandora localApolloPandora = (ApolloPandora)localIterator.next();
          if ((localApolloPandora != null) && (localApolloPandora.uin != null)) {
            synchronized (this.apolloPandoraCache)
            {
              this.apolloPandoraCache.put(localApolloPandora.uin, localApolloPandora);
            }
          }
        }
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ApolloManager", 2, "initApolloPandoraCache oom", localOutOfMemoryError);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "initApolloPandoraCache end size:" + this.apolloPandoraCache.size());
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
      QLog.e("ApolloManager", 1, "registerReceiver failed. ", localException);
    }
  }
  
  private static boolean initBasicScript()
  {
    boolean bool2 = false;
    try
    {
      String str = ApolloConstant.I + "cmshow_script_0.js";
      localFile = new File(str);
      bool1 = bool2;
      if (localFile.exists())
      {
        if (new RSAVerify(str + ".sig", str).a(1)) {
          break label177;
        }
        QLog.w("ApolloManager", 1, "verify fails, path:" + str);
        bool1 = bool2;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      File localFile;
      QLog.e("ApolloManager", 1, "[loadScript],OOM:", localOutOfMemoryError);
      return true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("ApolloManager", 1, "[loadScript],", localThrowable);
        continue;
        boolean bool1 = true;
      }
    }
    if (bool1)
    {
      sBasicScript = FileUtils.b(localFile);
      return bool1;
    }
    QLog.w("ApolloManager", 1, "Fail to read script file. " + localFile.getAbsolutePath());
    return bool1;
  }
  
  public static boolean initEngineScript()
  {
    boolean bool2 = false;
    try
    {
      String str = ApolloConstant.I + "cmshow_script_engine.js";
      localFile = new File(str);
      bool1 = bool2;
      if (localFile.exists())
      {
        if (new RSAVerify(str + ".sig", str).a(1)) {
          break label177;
        }
        QLog.w("ApolloManager", 1, "verify fails, path:" + str);
        bool1 = bool2;
      }
    }
    catch (Exception localException)
    {
      File localFile;
      QLog.e("ApolloManager", 1, "initEngineScript:", localException);
      return true;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.e("ApolloManager", 1, "initEngineScript:", localOutOfMemoryError);
        continue;
        boolean bool1 = true;
      }
    }
    if (bool1)
    {
      sEngineScript = FileUtils.b(localFile);
      return bool1;
    }
    QLog.w("ApolloManager", 1, "Fail to initEngineScript " + localFile.getAbsolutePath());
    return bool1;
  }
  
  public static boolean isApolloGameFuncOpen(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return ApolloGameConst.c == ApolloGameConfig.a("CMGamePlusPanel");
  }
  
  private static boolean isOpenglSupport(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo();
        if (paramContext != null)
        {
          QLog.i("ApolloManager", 1, "isOpenglSupport reqGlEsVersion:" + paramContext.reqGlEsVersion);
          if (paramContext.reqGlEsVersion >= 196608)
          {
            bool = true;
            sHardWareGL3Support = bool;
            int i = paramContext.reqGlEsVersion;
            if (i < 131072) {
              break label90;
            }
          }
          label90:
          for (boolean bool = true;; bool = false)
          {
            return bool;
            bool = false;
            break;
          }
          if (!QLog.isColorLevel()) {}
        }
      }
      catch (Throwable paramContext) {}
    }
    QLog.e("ApolloManager", 2, "isOpenglSupport:" + paramContext.getMessage());
    return false;
  }
  
  private boolean isTest3DAction()
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("apollo_test", 0);
    return false;
  }
  
  private void notifyApolloInitDone()
  {
    if ((this.mInitCallbackList == null) || (this.mInitCallbackList.size() == 0)) {
      return;
    }
    synchronized (this.mInitCallbackList)
    {
      Iterator localIterator = this.mInitCallbackList.iterator();
      if (localIterator.hasNext()) {
        ((ApolloInitCallback)localIterator.next()).a();
      }
    }
  }
  
  public static void notifyWebEngineReady()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof ToolAppRuntime))
      {
        localObject = ((AppRuntime)localObject).getAppRuntime("modular_web");
        if ((localObject instanceof AppInterface))
        {
          localObject = ((AppInterface)localObject).getHandler(ApolloStoreActivity.class);
          if (localObject != null)
          {
            ((MqqHandler)localObject).sendEmptyMessage(258);
            QLog.i("ApolloStoreActivity", 1, "send refresh apollo view msg");
          }
        }
      }
    }
  }
  
  private boolean optActionConfigJson(String paramString, ApolloActionData paramApolloActionData)
  {
    int j = 0;
    if ((paramString == null) || (paramApolloActionData == null)) {
      bool2 = false;
    }
    do
    {
      for (;;)
      {
        return bool2;
        for (;;)
        {
          try
          {
            paramString = new JSONObject(paramString);
            bool1 = paramString.has("audio");
            if (!bool1) {
              continue;
            }
          }
          catch (Exception paramString)
          {
            Object localObject;
            int i;
            boolean bool3;
            boolean bool1 = false;
            continue;
            bool2 = false;
            continue;
            i += 1;
            continue;
            i += 1;
            continue;
          }
          try
          {
            paramApolloActionData.hasSound = paramString.optJSONObject("audio").optBoolean("hasSound");
            bool2 = true;
            bool1 = bool2;
          }
          catch (Exception paramString)
          {
            bool1 = true;
            continue;
          }
          try
          {
            if (paramString.has("vibrate")) {
              bool1 = true;
            }
            bool2 = bool1;
            localObject = paramString.optJSONArray("vibrate");
            if (localObject != null)
            {
              bool2 = bool1;
              StringBuilder localStringBuilder = new StringBuilder(50);
              i = 0;
              bool2 = bool1;
              if (i < ((JSONArray)localObject).length())
              {
                bool2 = bool1;
                JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
                if (localJSONObject == null) {
                  continue;
                }
                bool2 = bool1;
                int k = localJSONObject.optInt("time");
                bool2 = bool1;
                int m = localJSONObject.optInt("duration");
                bool2 = bool1;
                localStringBuilder.append(k).append(",").append(m);
                bool2 = bool1;
                if (i >= ((JSONArray)localObject).length() - 1) {
                  continue;
                }
                bool2 = bool1;
                localStringBuilder.append(",");
                continue;
              }
              bool2 = bool1;
              paramApolloActionData.vibrate = localStringBuilder.toString();
            }
            bool2 = bool1;
            bool3 = paramString.has("bubbleText");
            if (!bool3) {
              continue;
            }
            bool1 = true;
          }
          catch (Exception paramString)
          {
            bool1 = bool2;
            continue;
            continue;
          }
          try
          {
            paramString = paramString.optJSONArray("bubbleText");
            if (paramString != null)
            {
              localObject = new StringBuilder(50);
              i = j;
              if (i < paramString.length())
              {
                ((StringBuilder)localObject).append(paramString.getString(i));
                if (i >= paramString.length() - 1) {
                  continue;
                }
                ((StringBuilder)localObject).append("@$");
                continue;
              }
              paramApolloActionData.bubbleText = ((StringBuilder)localObject).toString();
            }
            bool2 = bool1;
            if (!QLog.isColorLevel()) {
              break;
            }
            if ((!paramApolloActionData.hasSound) && (TextUtils.isEmpty(paramApolloActionData.vibrate)))
            {
              bool2 = bool1;
              if (TextUtils.isEmpty(paramApolloActionData.bubbleText)) {
                break;
              }
            }
            QLog.d("ApolloManager", 2, "action id " + paramApolloActionData.actionId + ", name: " + paramApolloActionData.actionName + ", hasSound: " + paramApolloActionData.hasSound + ", vibrate=" + paramApolloActionData.vibrate + ", bubbleText =" + paramApolloActionData.bubbleText);
            return bool1;
          }
          catch (Exception paramString)
          {
            bool2 = bool1;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("ApolloManager", 2, "parse action config.json error", paramString);
    return bool1;
  }
  
  private void parseActionConfigJson(ApolloActionData paramApolloActionData)
  {
    if ((paramApolloActionData == null) && (!FileUtils.a(ApolloUtilImpl.getApolloResPath(paramApolloActionData, 7)))) {}
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
      } while (!optActionConfigJson(FileUtils.a(new File(ApolloUtilImpl.getApolloResPath(paramApolloActionData, 7))), paramApolloActionData));
      localQQAppInterface = getApp();
    } while (localQQAppInterface == null);
    ((ApolloDaoManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).updateAction(paramApolloActionData);
  }
  
  private void parseActionInfo(List<ApolloActionData> paramList, List<ApolloActionPackage> paramList1, List<ApolloActionPackageData> paramList2, List<ApolloActionTag> paramList3, JSONObject paramJSONObject)
  {
    Object localObject1;
    int k;
    int i;
    Object localObject2;
    Object localObject5;
    Object localObject4;
    Object localObject6;
    int j;
    try
    {
      localObject1 = new ArrayList();
      if ((paramJSONObject != null) && (paramJSONObject.has("data")))
      {
        localJSONArray = paramJSONObject.getJSONArray("data");
        if (localJSONArray != null)
        {
          k = localJSONArray.length();
          i = 0;
          if (i < k)
          {
            localObject3 = localJSONArray.getJSONObject(i);
            if (localObject3 == null) {
              break label1988;
            }
            localObject2 = new ApolloActionData();
            ((ApolloActionData)localObject2).actionId = ((JSONObject)localObject3).getInt("id");
            ((ApolloActionData)localObject2).sessionType = ((JSONObject)localObject3).optInt("use");
            ((ApolloActionData)localObject2).actionName = ((JSONObject)localObject3).getString("name");
            ((ApolloActionData)localObject2).vipLevel = ((JSONObject)localObject3).optInt("vipLevel");
            ((ApolloActionData)localObject2).feeType = ((JSONObject)localObject3).optInt("feeType", 1);
            if (((JSONObject)localObject3).has("icon")) {
              ((ApolloActionData)localObject2).icon = ((JSONObject)localObject3).getInt("icon");
            }
            ((ApolloActionData)localObject2).iconUrl = ((JSONObject)localObject3).optString("iconUrl");
            ((ApolloActionData)localObject2).personNum = ((JSONObject)localObject3).getInt("type");
            ((ApolloActionData)localObject2).anmiName = ((JSONObject)localObject3).optString("animationName");
            ((ApolloActionData)localObject2).isShow = ((JSONObject)localObject3).optInt("isShow");
            ((ApolloActionData)localObject2).isForPlayerAction = ((JSONObject)localObject3).optInt("isForPlayerAction");
            ((ApolloActionData)localObject2).textImg = ((JSONObject)localObject3).optString("textImg");
            if (((JSONObject)localObject3).has("limitFree"))
            {
              ((ApolloActionData)localObject2).limitFree = ((JSONObject)localObject3).getInt("limitFree");
              ((ApolloActionData)localObject2).limitStart = ((JSONObject)localObject3).getLong("begin");
              ((ApolloActionData)localObject2).limitEnd = ((JSONObject)localObject3).getLong("end");
            }
            ((ApolloActionData)localObject2).startTime = ((JSONObject)localObject3).optLong("startTime");
            ((ApolloActionData)localObject2).endTime = ((JSONObject)localObject3).optLong("endTime");
            ((ApolloActionData)localObject2).url = ((JSONObject)localObject3).optString("activeUrl");
            ((ApolloActionData)localObject2).version = ((JSONObject)localObject3).getLong("version");
            ((ApolloActionData)localObject2).actionMoveDis = ((float)((JSONObject)localObject3).optDouble("actionDis", 0.0D));
            ((ApolloActionData)localObject2).peerMoveDis = ((float)((JSONObject)localObject3).optDouble("actionPeerDis", 0.0D));
            ((ApolloActionData)localObject2).compoundType = ((JSONObject)localObject3).optInt("actionSubType");
            ((ApolloActionData)localObject2).playArea = ((JSONObject)localObject3).optInt("posType");
            ((ApolloActionData)localObject2).actionType = ((JSONObject)localObject3).optInt("actionType");
            ((ApolloActionData)localObject2).slaveActionId = ((JSONObject)localObject3).optInt("slaveActionId");
            ((ApolloActionData)localObject2).currencyType = ((JSONObject)localObject3).optInt("currencyType");
            ((ApolloActionData)localObject2).currencyNum = ((JSONObject)localObject3).optInt("currencyNum");
            ((ApolloActionData)localObject2).description = ((JSONObject)localObject3).optString("description");
            ((ApolloActionData)localObject2).extraWording = ((JSONObject)localObject3).optString("extraWording");
            ((ApolloActionData)localObject2).minVer = ((JSONObject)localObject3).optString("minVer");
            ((ApolloActionData)localObject2).maxVer = ((JSONObject)localObject3).optString("maxVer");
            ((ApolloActionData)localObject2).gameId = ((JSONObject)localObject3).optInt("gameId");
            ((ApolloActionData)localObject2).gameName = ((JSONObject)localObject3).optString("gameName");
            ((ApolloActionData)localObject2).activeValue = ((JSONObject)localObject3).optInt("activeValue");
            ((ApolloActionData)localObject2).soundURL = ((JSONObject)localObject3).optString("soundURL");
            ((ApolloActionData)localObject2).soundType = ((JSONObject)localObject3).optInt("soundType");
            localObject5 = ((JSONObject)localObject3).optJSONArray("pkIds");
            localObject4 = ((JSONObject)localObject3).optJSONArray("pk3DIds");
            int m;
            if (localObject5 != null)
            {
              m = ((JSONArray)localObject5).length();
              localObject6 = new StringBuilder();
              j = 0;
              label619:
              if (j < m)
              {
                ((StringBuilder)localObject6).append(String.valueOf(((JSONArray)localObject5).get(j)));
                if (j == m - 1) {
                  break label1961;
                }
                ((StringBuilder)localObject6).append(",");
                break label1961;
              }
              ((ApolloActionData)localObject2).pkIds = ((StringBuilder)localObject6).toString();
            }
            if (localObject4 != null)
            {
              m = ((JSONArray)localObject4).length();
              localObject5 = new StringBuilder();
              j = 0;
              label697:
              if (j < m)
              {
                ((StringBuilder)localObject5).append(String.valueOf(((JSONArray)localObject4).get(j)));
                if (j == m - 1) {
                  break label1970;
                }
                ((StringBuilder)localObject5).append(",");
                break label1970;
              }
              ((ApolloActionData)localObject2).pk3DIds = ((StringBuilder)localObject5).toString();
            }
            localObject3 = ((JSONObject)localObject3).optJSONArray("keywords");
            if (localObject3 != null)
            {
              m = ((JSONArray)localObject3).length();
              localObject4 = new StringBuilder();
              j = 0;
              label785:
              if (j < m)
              {
                ((StringBuilder)localObject4).append(String.valueOf(((JSONArray)localObject3).get(j)));
                if (j == m - 1) {
                  break label1979;
                }
                ((StringBuilder)localObject4).append(",");
                break label1979;
              }
              ((ApolloActionData)localObject2).keywords = ((StringBuilder)localObject4).toString();
            }
            if ((this.mUserActionId != null) && (this.mUserActionId.containsKey(Integer.valueOf(((ApolloActionData)localObject2).actionId))))
            {
              if (((ApolloActionData)localObject2).isShow == 0) {
                ((ApolloActionData)localObject2).isShow = 1;
              }
              ApolloUtilImpl.updateObtainedAction((ApolloActionData)localObject2, (Bundle)this.mUserActionId.get(Integer.valueOf(((ApolloActionData)localObject2).actionId)));
            }
            checkActionVersion((ApolloActionData)localObject2);
            paramList.add(localObject2);
            if (((ApolloActionData)localObject2).feeType != 6) {
              break label1988;
            }
            ((List)localObject1).add(localObject2);
            break label1988;
          }
        }
      }
      localObject1 = getApp();
      if (localObject1 == null) {
        return;
      }
      localObject1 = (ApolloDaoManagerServiceImpl)((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all");
      localObject1 = new ArrayList();
      if ((paramJSONObject == null) || (!paramJSONObject.has("packageInfo"))) {
        break label1670;
      }
      JSONArray localJSONArray = paramJSONObject.getJSONArray("packageInfo");
      if (localJSONArray == null) {
        break label1670;
      }
      i = 0;
      label1010:
      if (i >= localJSONArray.length()) {
        break label1670;
      }
      localObject3 = localJSONArray.getJSONObject(i);
      if (localObject3 == null) {
        break label1998;
      }
      localObject2 = new ApolloActionPackage();
      ((ApolloActionPackage)localObject2).packageId = ((JSONObject)localObject3).getInt("packageId");
      ((ApolloActionPackage)localObject2).version = ((JSONObject)localObject3).optInt("version");
      ((ApolloActionPackage)localObject2).startVersion = ((JSONObject)localObject3).optString("startVersion");
      ((ApolloActionPackage)localObject2).endVersion = ((JSONObject)localObject3).optString("endVersion");
      ((ApolloActionPackage)localObject2).type = ((JSONObject)localObject3).optInt("type");
      ((ApolloActionPackage)localObject2).sessionType = ((JSONObject)localObject3).optInt("use");
      ((ApolloActionPackage)localObject2).name = ((JSONObject)localObject3).optString("name");
      ((ApolloActionPackage)localObject2).mIconUnselectedUrl = ((JSONObject)localObject3).optString("apImg");
      ((ApolloActionPackage)localObject2).mIconSelectedUrl = ((JSONObject)localObject3).optString("apcImg");
      if (!((ApolloActionPackage)localObject2).verifyVersion("8.5.5")) {
        QLog.w("ApolloManager", 1, "version not correct packageId=" + ((ApolloActionPackage)localObject2).packageId);
      }
    }
    catch (Exception paramList)
    {
      QLog.e("ApolloManager", 1, "parse ActionInfo error:" + paramList);
      return;
    }
    checkPackageRedDots((ApolloActionPackage)localObject2, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "ActionPackage pid = " + ((ApolloActionPackage)localObject2).packageId + " actionPackage.isUpdate = " + ((ApolloActionPackage)localObject2).isUpdate);
    }
    paramList1.add(localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "add actionPackage pid=" + ((ApolloActionPackage)localObject2).packageId);
    }
    Object localObject3 = ((JSONObject)localObject3).optJSONArray("actionSet");
    if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
    {
      localObject4 = new StringBuilder();
      j = 0;
      if (j < ((JSONArray)localObject3).length())
      {
        localObject5 = ((JSONArray)localObject3).getJSONObject(j);
        localObject6 = new ApolloActionPackageData();
        ((ApolloActionPackageData)localObject6).packageId = ((ApolloActionPackage)localObject2).packageId;
        ((ApolloActionPackageData)localObject6).acitonId = ((JSONObject)localObject5).optInt("actionId");
        ((ApolloActionPackageData)localObject6).text = ((JSONObject)localObject5).optString("text");
        ((ApolloActionPackageData)localObject6).textType = ((JSONObject)localObject5).optInt("textType");
        if (checkPackageAction(((ApolloActionPackageData)localObject6).acitonId, paramList))
        {
          paramList2.add(localObject6);
          if (((ApolloActionPackageData)localObject6).packageId == 5) {
            ((List)localObject1).add(Integer.valueOf(((ApolloActionPackageData)localObject6).acitonId));
          }
        }
        for (;;)
        {
          ((StringBuilder)localObject4).append(((ApolloActionPackageData)localObject6).acitonId).append(" ");
          j += 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, "action list has not packageAction id=" + ((ApolloActionPackageData)localObject6).acitonId);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "addActionPackageData packageId=", Integer.valueOf(((ApolloActionPackage)localObject2).packageId), " actionId=[", ((StringBuilder)localObject4).toString(), "]" });
      }
    }
    else if ((((ApolloActionPackage)localObject2).type != 2) && (((ApolloActionPackage)localObject2).packageId != 8) && (((ApolloActionPackage)localObject2).packageId != 10) && (((ApolloActionPackage)localObject2).packageId != 302))
    {
      paramList1.remove(localObject2);
      break label1998;
      label1670:
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "[parseActionInfo] world action list=", localObject1 });
      }
      if ((localObject1 != null) && (((List)localObject1).size() > 0) && (paramList != null) && (paramList.size() > 0))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          paramList1 = (ApolloActionData)paramList.next();
          if (((List)localObject1).contains(Integer.valueOf(paramList1.actionId))) {
            paramList1.hasExtraAction = true;
          } else {
            paramList1.hasExtraAction = false;
          }
        }
      }
      if ((paramJSONObject != null) && (paramJSONObject.has("actionTag")))
      {
        paramList = paramJSONObject.getJSONArray("actionTag");
        if (paramList != null) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (i < paramList.length())
      {
        paramJSONObject = paramList.getJSONObject(i);
        if (paramJSONObject != null)
        {
          paramList1 = paramJSONObject.optJSONArray("actionList");
          paramList2 = paramJSONObject.getString("tagName");
          k = paramJSONObject.getInt("packageId");
          j = 0;
          while (j < paramList1.length())
          {
            paramJSONObject = new ApolloActionTag();
            paramJSONObject.tagName = paramList2;
            paramJSONObject.packageId = k;
            paramJSONObject.actionId = paramList1.getInt(j);
            paramList3.add(paramJSONObject);
            j += 1;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          QLog.d("ApolloManager", 2, new Object[] { "[parseActionInfo] apolloActionTagList = ", paramList3 });
          return;
          label1961:
          j += 1;
          break label619;
          label1970:
          j += 1;
          break label697;
          label1979:
          j += 1;
          break label785;
          label1988:
          i += 1;
          break;
        }
        return;
        label1998:
        i += 1;
        break label1010;
      }
      i += 1;
    }
  }
  
  private void parseWhiteFaceIdMapping(JSONObject paramJSONObject, List<ApolloWhiteFaceID> paramList)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      try
      {
        paramJSONObject = paramJSONObject.optJSONArray("IDMap");
        if (paramJSONObject == null) {
          continue;
        }
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
          if (localJSONObject != null)
          {
            ApolloWhiteFaceID localApolloWhiteFaceID = new ApolloWhiteFaceID();
            localApolloWhiteFaceID.terminalId = localJSONObject.optInt("terminalID");
            localApolloWhiteFaceID.action2d = localJSONObject.optInt("action2D");
            localApolloWhiteFaceID.action3d = localJSONObject.optInt("action3D");
            paramList.add(localApolloWhiteFaceID);
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("ApolloManager", 1, "parseWhiteFaceIdMapping:", paramJSONObject);
      }
    }
  }
  
  private void removeAllApolloInitCallback()
  {
    if ((this.mInitCallbackList == null) || (this.mInitCallbackList.size() == 0)) {
      return;
    }
    this.mInitCallbackList.clear();
    this.mInitCallbackList = null;
  }
  
  private void saveBubblePushData(int paramInt, List<submsgtype0xdc.MsgContent> paramList)
  {
    EntityManager localEntityManager = getEntityManager();
    if ((paramList == null) || (paramList.size() == 0) || (localEntityManager == null)) {
      QLog.e("ApolloManager", 1, "[saveBubblePushData], null param");
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "[saveBubblePushData] msgType:", Integer.valueOf(paramInt) });
      }
      EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
      try
      {
        localEntityTransaction.begin();
        synchronized (this.mPushLock)
        {
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            submsgtype0xdc.MsgContent localMsgContent = (submsgtype0xdc.MsgContent)paramList.next();
            localDrawerPushItem = new DrawerPushItem();
            localDrawerPushItem.msg_type = paramInt;
            localDrawerPushItem.msg_id = String.valueOf(localMsgContent.uint64_msg_id.get());
            localDrawerPushItem.priority = ((int)localMsgContent.uint64_master_pri.get());
            localDrawerPushItem.sub_priority = ((int)localMsgContent.uint64_sub_pri.get());
            localDrawerPushItem.start_ts = ((int)localMsgContent.uint64_show_beg_ts.get());
            localDrawerPushItem.end_ts = ((int)localMsgContent.uint64_exp_ts.get());
            localDrawerPushItem.send_time = ((int)localMsgContent.uint64_msg_sent_ts.get());
            localDrawerPushItem.action_id = ((int)localMsgContent.uint64_action_id.get());
            localDrawerPushItem.color = ((int)localMsgContent.uint64_wording_color.get());
            localDrawerPushItem.content = localMsgContent.str_wording.get();
            localDrawerPushItem.scheme = localMsgContent.str_scheme.get();
            localDrawerPushItem.ext_url = localMsgContent.str_region_url.get();
            localDrawerPushItem.bubble_res_id = ((int)localMsgContent.uint64_bubble_id.get());
            localDrawerPushItem.is_reddot = 0;
            localDrawerPushItem.tips_str = localMsgContent.str_tips.get();
            localDrawerPushItem.show_counts = ((int)localMsgContent.uint64_show_times.get());
            localDrawerPushItem.reddotGameId = ((int)localMsgContent.uint64_game_id.get());
            if ((localDrawerPushItem.reddotGameId > 0) && (!ApolloGameUtil.a(getApp(), localDrawerPushItem.reddotGameId))) {
              QLog.i("ApolloManager", 1, "saveBubblePushData push game not exit,gameId:" + localDrawerPushItem.reddotGameId);
            }
          }
        }
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          DrawerPushItem localDrawerPushItem;
          QLog.e("ApolloManager", 1, "[saveBubblePushData], Apollo Push Bubble Error:" + paramList.getMessage());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, new Object[] { "saveBubblePushData receive item:", localDrawerPushItem.toString() });
          }
          if ((this.mDrawerPushItems != null) && (!alreadyContainsItem(localDrawerPushItem))) {
            this.mDrawerPushItems.add(localDrawerPushItem);
          }
          localEntityManager.persist(localDrawerPushItem);
        }
        localEntityTransaction.commit();
        return;
      }
      finally
      {
        if (localEntityTransaction != null) {
          localEntityTransaction.end();
        }
      }
    }
  }
  
  private void saveRedAppearTime(int paramInt)
  {
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      return;
    }
    String str = "action_red_tab_update_" + paramInt;
    localQQAppInterface.getApp().getSharedPreferences("apollo_sp" + localQQAppInterface.getCurrentUin(), 0).edit().putLong(str, NetConnInfoCenter.getServerTimeMillis()).commit();
  }
  
  private void setGameBoxUserStatus(int paramInt)
  {
    boolean bool = true;
    if (1 == (paramInt >> 10 & 0x1)) {}
    for (;;)
    {
      updateGameBoxUserStatus(bool);
      return;
      bool = false;
    }
  }
  
  public static void setsGameOidbStatus(int paramInt)
  {
    QLog.i("ApolloManager", 1, "setsGameOidbStatus:" + paramInt);
    sGameOidbStatus = paramInt >> 3 & 0x1;
  }
  
  private boolean unzipInnerRsc()
  {
    boolean bool1 = false;
    l1 = System.currentTimeMillis();
    FileUtils.a(new File(ApolloConstant.jdField_a_of_type_JavaLangString, "/def/basic").getAbsolutePath());
    do
    {
      try
      {
        long l2 = System.currentTimeMillis();
        copyFilesFassets(BaseApplicationImpl.getApplication().getApplicationContext(), "apollo_def_rsc", "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/apollo_def_rsc");
        long l3 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "copy file to sdcard cost:" + (l3 - l2));
        }
        new File(ApolloConstant.jdField_a_of_type_JavaLangString, "def").mkdirs();
        int i = LzmaUtils.a(BaseApplicationImpl.getApplication().getApplicationContext(), "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/apollo_def_rsc", ApolloConstant.jdField_a_of_type_JavaLangString + "/def/");
        FileUtils.e("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/apollo_def_rsc");
        if (i != 0) {
          continue;
        }
        boolean bool2 = true;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("ApolloManager", 2, "unzip cost: " + (System.currentTimeMillis() - l1) + " ms");
          bool1 = bool2;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloManager", 2, "errorInfo->" + localException.getMessage());
        return false;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          break label375;
        }
        QLog.d("ApolloManager", 2, "unzip cost: " + (System.currentTimeMillis() - l1) + " ms");
      }
      return bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloManager", 2, "unzip cost: " + (System.currentTimeMillis() - l1) + " ms");
    return false;
  }
  
  private void update3dWhiteList(int paramInt)
  {
    QQAppInterface localQQAppInterface = getApp();
    int i;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).edit().putInt(localQQAppInterface.getCurrentAccountUin() + "_3dwhiteList", paramInt).commit();
      i = SharedPreUtils.r(localQQAppInterface.getApplication());
      if (i != 0) {
        break label129;
      }
      s3dWhiteUserStatus = paramInt;
    }
    for (;;)
    {
      QLog.d("ApolloManager", 1, new Object[] { "[update3dWhiteList] global=", Integer.valueOf(i), ", s3dWhiteUserStatus=", Integer.valueOf(s3dWhiteUserStatus), ", status=", Integer.valueOf(paramInt) });
      return;
      label129:
      if (1 == i) {
        s3dWhiteUserStatus = 1;
      } else {
        s3dWhiteUserStatus = 0;
      }
    }
  }
  
  private boolean updateEntity(Entity paramEntity)
  {
    EntityManager localEntityManager = getEntityManager();
    if (localEntityManager == null) {}
    label71:
    do
    {
      do
      {
        return false;
        if (!localEntityManager.isOpen()) {
          break label71;
        }
        if (paramEntity.getStatus() != 1000) {
          break;
        }
        localEntityManager.persistOrReplace(paramEntity);
      } while (paramEntity.getStatus() != 1001);
      return true;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return localEntityManager.update(paramEntity);
      }
    } while (!QLog.isColorLevel());
    QLog.e("ApolloManager", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  private void updateGameBoxUserStatus(boolean paramBoolean)
  {
    int i = queryApolloSwitchSet("gameBoxGrayStatus");
    if (i == 1) {
      this.mIsDrawerGameBoxUser = paramBoolean;
    }
    for (;;)
    {
      QLog.d("ApolloManager", 1, "upDateGameBoxUserStatus switch: " + i + ", oidb Status: " + paramBoolean);
      return;
      if (i == 2) {
        this.mIsDrawerGameBoxUser = true;
      } else {
        this.mIsDrawerGameBoxUser = false;
      }
    }
  }
  
  /* Error */
  public void addApolloInitCallback(ApolloInitCallback paramApolloInitCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 1865	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mInitCallbackList	Ljava/util/List;
    //   6: ifnonnull +17 -> 23
    //   9: aload_0
    //   10: new 249	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 250	java/util/ArrayList:<init>	()V
    //   17: invokestatic 2437	java/util/Collections:synchronizedList	(Ljava/util/List;)Ljava/util/List;
    //   20: putfield 1865	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mInitCallbackList	Ljava/util/List;
    //   23: aload_0
    //   24: getfield 1865	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mInitCallbackList	Ljava/util/List;
    //   27: astore_2
    //   28: aload_2
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 1865	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mInitCallbackList	Ljava/util/List;
    //   34: aload_1
    //   35: invokeinterface 627 2 0
    //   40: pop
    //   41: aload_2
    //   42: monitorexit
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_1
    //   47: aload_2
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	ApolloManagerServiceImpl
    //   0	56	1	paramApolloInitCallback	ApolloInitCallback
    // Exception table:
    //   from	to	target	type
    //   30	43	46	finally
    //   47	49	46	finally
    //   2	23	51	finally
    //   23	30	51	finally
    //   49	51	51	finally
  }
  
  public void addApolloStatusUpdateListener(ApolloStatusUpdateListener paramApolloStatusUpdateListener)
  {
    if (paramApolloStatusUpdateListener == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "[setApolloStatusUpdateListener] listener=", paramApolloStatusUpdateListener });
    }
    this.mStatusUpdateListeners.add(new WeakReference(paramApolloStatusUpdateListener));
  }
  
  public void addDownLoadListener(IResDownloadListener paramIResDownloadListener)
  {
    if (paramIResDownloadListener != null) {}
    try
    {
      if (this.mListenerManager != null) {
        this.mListenerManager.a(paramIResDownloadListener);
      }
      return;
    }
    finally
    {
      paramIResDownloadListener = finally;
      throw paramIResDownloadListener;
    }
  }
  
  public void addPushItem(DrawerPushItem paramDrawerPushItem)
  {
    addPushItem(paramDrawerPushItem, true);
  }
  
  public void addPushItem(DrawerPushItem paramDrawerPushItem, boolean paramBoolean)
  {
    synchronized (this.mPushLock)
    {
      if ((this.mDrawerPushItems != null) && (!alreadyContainsItem(paramDrawerPushItem)))
      {
        this.mDrawerPushItems.add(paramDrawerPushItem);
        EntityManager localEntityManager = getEntityManager();
        if ((localEntityManager != null) && (paramBoolean)) {
          localEntityManager.persist(paramDrawerPushItem);
        }
        if (QLog.isColorLevel()) {
          QLog.i("ApolloPushBubble", 2, "add red push item:" + paramDrawerPushItem);
        }
      }
      return;
    }
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
  
  public void bulkSaveOrUpdateApolloBaseInfos(List<ApolloBaseInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      if (paramList.size() == 1)
      {
        saveOrUpdateApolloBaseInfo((ApolloBaseInfo)paramList.get(0));
        return;
      }
      Object localObject1 = paramList.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ApolloBaseInfo)((Iterator)localObject1).next();
        if (!TextUtils.isEmpty(((ApolloBaseInfo)localObject2).uin))
        {
          ??? = getApp();
          if ((??? != null) && (((ApolloBaseInfo)localObject2).uin.equals(((QQAppInterface)???).getCurrentAccountUin()))) {
            this.mSelfApolloBaseInfo = ((ApolloBaseInfo)localObject2);
          }
          synchronized (this.mApolloBaseInfoCache)
          {
            this.mApolloBaseInfoCache.put(((ApolloBaseInfo)localObject2).uin, localObject2);
          }
        }
      }
      localObject1 = getEntityManager();
      if (localObject1 == null) {
        continue;
      }
      localObject1 = ((EntityManager)localObject1).getTransaction();
      ((EntityTransaction)localObject1).begin();
      try
      {
        localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ??? = (ApolloBaseInfo)((Iterator)localObject2).next();
          if (!TextUtils.isEmpty(((ApolloBaseInfo)???).uin)) {
            updateEntity((Entity)???);
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "bulk insert exception: " + localException.getMessage());
        }
        ((EntityTransaction)localObject1).end();
        for (;;)
        {
          localObject1 = getApp();
          if ((!QLog.isColorLevel()) || (localObject1 == null) || (!paramList.contains(((QQAppInterface)localObject1).getCurrentUin()))) {
            break;
          }
          paramList = (ApolloBaseInfo)this.mApolloBaseInfoCache.get(((QQAppInterface)localObject1).getCurrentUin());
          QLog.d("ApolloManager", 1, "save apollo info vip flag: " + paramList.apolloVipFlag + ", level: " + paramList.apolloVipFlag + ", apollo status: " + paramList.apolloStatus + ", apollo local TS: " + paramList.apolloLocalTS + ", apollo svr TS:" + paramList.apolloServerTS + ", apollo upt TS:" + paramList.apolloUpdateTime);
          return;
          ((EntityTransaction)localObject1).commit();
          ((EntityTransaction)localObject1).end();
        }
      }
      finally
      {
        ((EntityTransaction)localObject1).end();
      }
    }
  }
  
  public void bulkUpdateUserDress()
  {
    this.mAsyncSubThreadHandler.removeMessages(4096);
    this.mAsyncSubThreadHandler.sendEmptyMessage(4096);
  }
  
  public void checkActionJsonInterval()
  {
    QQAppInterface localQQAppInterface = getApp();
    if ((localQQAppInterface == null) || (localQQAppInterface.getApp() == null)) {}
    long l;
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      l = NetConnInfoCenter.getServerTime();
      localSharedPreferences = localQQAppInterface.getApp().getSharedPreferences("apollo_sp" + localQQAppInterface.getCurrentUin(), 0);
    } while (l - localSharedPreferences.getLong("sp_key_apollo_check_action_time", 0L) <= 300L);
    ApolloContentUpdateHandler.a(localQQAppInterface, 1);
    localSharedPreferences.edit().putLong("sp_key_apollo_check_action_time", l).commit();
  }
  
  public void checkApolloPanelJsonCfg(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "checkApolloPanelJsonCfg begin..." + paramString + ",task:" + paramInt);
    }
    if ((paramBoolean) || (((paramInt & 0x1) == 1) && (!FileUtil.a("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json"))))
    {
      downloadJson(paramInt);
      QLog.d("ApolloManager", 1, "checkApolloPanelJsonCfg download json  forceDownload is: " + paramBoolean);
      return;
    }
    ApolloUtilImpl.checkJsonParse(getApp());
  }
  
  public void checkCompat2DActionRsc()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[checkCompat2DActionRsc]");
    }
    Object localObject = getApp();
    if (localObject != null)
    {
      localObject = (ApolloDaoManagerServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloDaoManagerService.class, "all");
      ApolloActionData localApolloActionData = ((ApolloDaoManagerServiceImpl)localObject).findActionById(1450);
      if (localApolloActionData != null) {
        downloadActionIfNotExist(localApolloActionData.actionId, localApolloActionData.personNum);
      }
      localObject = ((ApolloDaoManagerServiceImpl)localObject).findActionById(1454);
      if (localObject != null) {
        downloadActionIfNotExist(((ApolloActionData)localObject).actionId, ((ApolloActionData)localObject).personNum);
      }
    }
  }
  
  public void checkPanelActionRes(int paramInt, boolean paramBoolean)
  {
    ThreadManager.post(new ApolloManagerServiceImpl.9(this, paramBoolean, paramInt), 5, null, false);
  }
  
  public void checkResForGuidePanel()
  {
    Object localObject1 = getApp();
    if (localObject1 != null)
    {
      Object localObject2 = (ApolloDaoManagerServiceImpl)((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all");
      localObject1 = ((ApolloDaoManagerServiceImpl)localObject2).getActionByPackageId(400);
      if (((ApolloDaoManagerServiceImpl)localObject2).getActionInfoById(3000059) == null) {
        break label101;
      }
      if (localObject1 != null) {
        break label98;
      }
      localObject1 = new ArrayList();
      localObject2 = new ApolloActionData();
      ((ApolloActionData)localObject2).actionId = 3000059;
      ((List)localObject1).add(localObject2);
    }
    label98:
    label101:
    for (;;)
    {
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        downloadResAndPanel((List)localObject1, "apollo_key");
      }
      return;
      break;
    }
  }
  
  public void checkUserDress(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    ApolloExtensionHandlerImpl localApolloExtensionHandlerImpl = (ApolloExtensionHandlerImpl)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    ApolloBaseInfo localApolloBaseInfo1 = getApolloBaseInfo(paramString1 + "");
    if ((localApolloBaseInfo1 == null) || (localApolloBaseInfo1.apolloUpdateTime == 0L))
    {
      localApolloExtensionHandlerImpl.b(paramString1 + "");
      if (QLog.isColorLevel()) {
        if (paramString1.length() < 4) {
          break label434;
        }
      }
    }
    label434:
    for (paramAppInterface = paramString1.substring(0, 4);; paramAppInterface = paramString1)
    {
      QLog.d("ApolloManager", 2, "checkUserDress---> getApolloBaseInfo uin: " + paramAppInterface);
      do
      {
        do
        {
          if ((QLog.isColorLevel()) && (localApolloBaseInfo1 != null) && (!localApolloBaseInfo1.isApolloStatusOpen())) {
            QLog.d("ApolloManager", 2, "checkUserDress---> user apollo status is not open uin: " + paramString1 + ", status: " + localApolloBaseInfo1.apolloStatus);
          }
          if ((localApolloBaseInfo1 == null) || (!localApolloBaseInfo1.isApolloStatusOpen()) || (0L == localApolloBaseInfo1.apolloSignValidTS) || (NetConnInfoCenter.getServerTime() >= localApolloBaseInfo1.apolloSignValidTS) || (localApolloBaseInfo1.apolloSignValidTS == localApolloBaseInfo1.apolloLocalSignTs)) {
            break;
          }
          localApolloExtensionHandlerImpl.b(paramString1, "AIO");
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloManager", 2, "getUserSignStr...");
          return;
        } while ((!localApolloBaseInfo1.isApolloStatusOpen()) || (localApolloBaseInfo1.apolloServerTS == localApolloBaseInfo1.apolloLocalTS));
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(Long.valueOf(Long.parseLong(paramString1)));
        ApolloBaseInfo localApolloBaseInfo2 = getApolloBaseInfo(paramAppInterface.getCurrentUin());
        if ((localApolloBaseInfo2 != null) && (localApolloBaseInfo2.apolloLocalTS != localApolloBaseInfo2.apolloServerTS)) {
          localArrayList.add(Long.valueOf(paramAppInterface.getLongAccountUin()));
        }
        localApolloExtensionHandlerImpl.a(localArrayList, paramString2);
      } while (!QLog.isColorLevel());
      if (paramString1.length() >= 4) {}
      for (paramAppInterface = paramString1.substring(0, 4);; paramAppInterface = paramString1)
      {
        QLog.d("ApolloManager", 2, "checkUserDress---> getGetUserApolloDress uin: " + paramAppInterface + ", old dress: " + localApolloBaseInfo1.getApolloDress());
        break;
      }
    }
  }
  
  public void clearBubble(String paramString)
  {
    DrawerPushItem localDrawerPushItem;
    synchronized (this.mPushLock)
    {
      if ((this.mDrawerPushItems == null) || (this.mDrawerPushItems.isEmpty())) {
        return;
      }
      Iterator localIterator = this.mDrawerPushItems.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localDrawerPushItem = (DrawerPushItem)localIterator.next();
      } while ((localDrawerPushItem.msg_id == null) || (!localDrawerPushItem.msg_id.equals(paramString)));
      localDrawerPushItem.show_sum = localDrawerPushItem.show_counts;
      this.mDrawerPushItems.remove(localDrawerPushItem);
      paramString = getEntityManager();
      if (paramString == null) {
        return;
      }
    }
    paramString.remove(localDrawerPushItem);
    if (QLog.isColorLevel()) {
      QLog.i("ApolloManager", 2, "remove bubble:" + localDrawerPushItem.msg_id);
    }
    return;
    if (QLog.isColorLevel()) {
      QLog.i("ApolloManager", 2, "remove bubble failed:" + paramString);
    }
  }
  
  public void clickPushItem(DrawerPushItem paramDrawerPushItem, QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if ((paramDrawerPushItem == null) || (paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    ApolloUtilImpl.openStoreByTabScheme(paramQQAppInterface, paramContext, paramDrawerPushItem.scheme, paramDrawerPushItem.ext_url, paramString);
  }
  
  public void decodeApolloBubblePushData(byte[] paramArrayOfByte)
  {
    submsgtype0xdc.MsgBody localMsgBody = new submsgtype0xdc.MsgBody();
    for (;;)
    {
      int i;
      try
      {
        localMsgBody.mergeFrom(paramArrayOfByte);
        if (!localMsgBody.uint32_msg_type.has()) {
          break label326;
        }
        i = localMsgBody.uint32_msg_type.get();
        if (!localMsgBody.minQqVer.has()) {
          break label331;
        }
        paramArrayOfByte = localMsgBody.minQqVer.get();
        if ((TextUtils.isEmpty(paramArrayOfByte)) || (ApolloConfigUtils.a("8.5.5", paramArrayOfByte) >= 0)) {
          break label331;
        }
        QLog.i("ApolloManager", 1, "decodeApolloBubblePushData push but cur version not support:" + paramArrayOfByte);
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        label94:
        paramArrayOfByte.printStackTrace();
        label131:
        QLog.e("ApolloManager", 1, new Object[] { "[decodeApolloBubblePushData], errInfo->", paramArrayOfByte.getMessage() });
        return;
      }
      if (localMsgBody.rpt_msg_list.has())
      {
        paramArrayOfByte = localMsgBody.rpt_msg_list.get();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0)) {
          saveBubblePushData(i, paramArrayOfByte);
        }
        QLog.i("ApolloManager", 1, "[decodeApolloBubblePushData], decode complete msgType:" + i);
        return;
      }
      label326:
      label331:
      do
      {
        if ((i == 2) && (localMsgBody.rpt_msg_list_0x02.has()))
        {
          paramArrayOfByte = localMsgBody.rpt_msg_list_0x02.get();
          if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
            break label131;
          }
          saveBubblePushData(i, paramArrayOfByte);
          break label131;
        }
        if ((i == 3) && (localMsgBody.rpt_msg_list.has()))
        {
          paramArrayOfByte = localMsgBody.rpt_msg_list.get();
          if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
            break label131;
          }
          saveBubblePushData(8, paramArrayOfByte);
          break label131;
        }
        if ((i != 201) || (!localMsgBody.rpt_msg_list_0x02.has())) {
          break label131;
        }
        paramArrayOfByte = localMsgBody.rpt_msg_list_0x02.get();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
          break label131;
        }
        saveBubblePushData(9, paramArrayOfByte);
        break label131;
        i = 0;
        break;
        if (i == 0) {
          break label94;
        }
      } while (i != 1);
    }
  }
  
  public void deleteCMSLocalPath()
  {
    Object localObject1 = getCMSActionList();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ApolloActionData)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          mCMSFrameCache.remove(Integer.valueOf(((ApolloActionData)localObject2).actionId));
          localObject2 = ApolloUtilImpl.getApolloResPath((ApolloActionData)localObject2, 10);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            File localFile = new File((String)localObject2);
            if (localFile.exists())
            {
              FileUtils.a(localFile);
              QLog.d("ApolloManager", 1, "deleteCMSLocalPath : " + (String)localObject2);
            }
          }
        }
      }
    }
  }
  
  public void doAfterOpenAIO(SessionInfo paramSessionInfo, Context paramContext)
  {
    ThreadManagerV2.executeOnSubThread(new ApolloManagerServiceImpl.10(this, paramSessionInfo));
    ThreadManagerV2.executeOnSubThread(new ApolloManagerServiceImpl.11(this));
    paramContext = getApp();
    if ((!CmShowAioMatcher.a(paramSessionInfo.jdField_a_of_type_Int)) && (paramContext != null) && (NetworkUtil.g(paramContext.getApp()))) {}
    do
    {
      do
      {
        return;
        this.mActionPlayList.clear();
      } while ((paramSessionInfo.jdField_a_of_type_Int == 1) && (paramContext != null) && (((HotChatManager)paramContext.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramSessionInfo.jdField_a_of_type_JavaLangString) != null));
      if ((paramContext == null) || (1 == getApolloStatus(paramContext.getCurrentUin()))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloManager", 2, "doAfterOpenAIO: apollo function is not opened status: " + getApolloStatus(paramContext.getCurrentUin()));
    return;
    ThreadManager.getSubThreadHandler().post(new ApolloManagerServiceImpl.12(this, paramSessionInfo));
  }
  
  public boolean downloadActionPackageTab(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {}
    label96:
    int i;
    do
    {
      do
      {
        do
        {
          return false;
          if (!Utils.a()) {
            break;
          }
          if (Utils.b() >= 1048576L) {
            break label96;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ApolloManager", 2, "2sdcardcheck,sdcard full .return. aid=" + paramApolloActionPackage.packageId);
        return false;
      } while (!QLog.isColorLevel());
      QLog.e("ApolloManager", 2, "2sdcardcheck,has sdcard FALSE .return. aid=" + paramApolloActionPackage.packageId);
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "start download actionPackage tab pid=" + paramApolloActionPackage.packageId);
      }
      paramApolloActionPackage = new DownloadTask(ApolloUtilImpl.getAPolloTabUrl(paramApolloActionPackage), new File(ApolloUtilImpl.getApolloTabResPath(paramApolloActionPackage)));
      paramApolloActionPackage.n = true;
      paramApolloActionPackage.f = "apollo_res";
      paramApolloActionPackage.b = 1;
      paramApolloActionPackage.q = true;
      paramApolloActionPackage.r = true;
      i = DownloaderFactory.a(paramApolloActionPackage, getApp());
    } while (i != 0);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "ret:" + i);
    }
    return true;
  }
  
  public boolean downloadApolloRes(ApolloActionData paramApolloActionData, int paramInt, IResDownloadListener paramIResDownloadListener)
  {
    if (paramApolloActionData == null) {}
    for (;;)
    {
      return false;
      if (Utils.a())
      {
        if (Utils.b() < 1048576L)
        {
          QLog.e("ApolloManager", 1, "1sdcardcheck,sdcard full .return. aid=" + paramApolloActionData.actionId);
          return false;
        }
      }
      else
      {
        QLog.e("ApolloManager", 1, "1sdcardcheck,has sdcard FALSE .return. aid=" + paramApolloActionData.actionId);
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "start download action res aid=" + paramApolloActionData.actionId);
      }
      Object localObject1;
      Object localObject2;
      int i;
      if ((paramInt & 0x1) == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "start download action panelpic aid=" + paramApolloActionData.actionId);
        }
        localObject1 = ApolloUtilImpl.getApolloResPath(paramApolloActionData, 1);
        localObject2 = ApolloUtilImpl.getApolloResPath(paramApolloActionData, 0);
        if (!FileUtils.a((String)localObject2))
        {
          localObject1 = new DownloadTask((String)localObject1, new File((String)localObject2));
          ((DownloadTask)localObject1).f = "apollo_res";
          ((DownloadTask)localObject1).b = 1;
          ((DownloadTask)localObject1).n = true;
          ((DownloadTask)localObject1).q = true;
          ((DownloadTask)localObject1).r = true;
          i = DownloaderFactory.a((DownloadTask)localObject1, getApp());
          if (i != 0) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, "ret:" + i);
          }
        }
      }
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "start download action gif aid=" + paramApolloActionData.actionId);
        }
        localObject1 = ApolloUtilImpl.getApolloResPath(paramApolloActionData, 3);
        localObject2 = ApolloUtilImpl.getApolloResPath(paramApolloActionData, 2);
        if (!FileUtils.a((String)localObject2))
        {
          localObject1 = new DownloadTask((String)localObject1, new File((String)localObject2));
          ((DownloadTask)localObject1).f = "apollo_res";
          ((DownloadTask)localObject1).n = true;
          i = DownloaderFactory.a((DownloadTask)localObject1, getApp());
          if (i != 0) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, "ret:" + i);
          }
        }
      }
      if ((paramInt & 0x4) == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "start download action zip aid=" + paramApolloActionData.actionId);
        }
        localObject2 = ApolloUtilImpl.getApolloResPath(paramApolloActionData, 5);
        localObject1 = ApolloUtilImpl.getApolloResPath(paramApolloActionData, 4);
        boolean bool2 = ApolloUtilImpl.isActionResDone(paramApolloActionData.actionId, paramApolloActionData.personNum);
        boolean bool1 = bool2;
        if (paramApolloActionData.isForPlayerAction == 1) {
          bool1 = bool2 & ApolloUtilImpl.isActionPanelFrameResDone(paramApolloActionData.actionId, paramApolloActionData.personNum);
        }
        if (!bool1)
        {
          localObject2 = new DownloadTask((String)localObject2, new File((String)localObject1));
          ((DownloadTask)localObject2).f = "apollo_res";
          ((DownloadTask)localObject2).b = 1;
          ((DownloadTask)localObject2).n = true;
          ((DownloadTask)localObject2).q = true;
          ((DownloadTask)localObject2).r = true;
          paramInt = DownloaderFactory.a((DownloadTask)localObject2, getApp());
          if (paramInt != 0) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, "ret:" + paramInt);
          }
        }
      }
      try
      {
        FileUtils.a((String)localObject1, ApolloUtilImpl.getApolloResPath(paramApolloActionData, 6), false);
        FileUtils.e((String)localObject1);
        parseActionConfigJson(paramApolloActionData);
        if (paramIResDownloadListener != null) {
          if (!ApolloUtilImpl.isActionResDone(paramApolloActionData.actionId, paramApolloActionData.personNum))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("ApolloManager", 2, "download finished, but rsc NOT complete.");
            return false;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ApolloManager", 2, "uncompresszip error" + localException.toString());
          }
        }
        paramIResDownloadListener.b(paramApolloActionData);
      }
    }
    return true;
  }
  
  public void downloadFileBy304(String paramString1, String paramString2, Download403Callback paramDownload403Callback)
  {
    QQAppInterface localQQAppInterface = getApp();
    if ((localQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    DownloaderInterface localDownloaderInterface;
    do
    {
      return;
      localDownloaderInterface = getDownloader();
    } while ((localDownloaderInterface == null) || (localDownloaderInterface.a(paramString1) != null));
    File localFile = new File(paramString2);
    paramString2 = new DownloadTask(paramString1, localFile);
    if (localFile.exists())
    {
      SharedPreferences localSharedPreferences = localQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
      paramString2.i = localSharedPreferences.getLong(paramString1 + "_lastModifiedTime", 0L);
      long l = localSharedPreferences.getLong(paramString1, 0L);
      if (localFile.lastModified() != l) {
        paramString2.m = true;
      }
    }
    paramString2.p = true;
    paramString2.j = true;
    paramString2.n = true;
    paramString2.s = false;
    paramString2.f = "apollo_res";
    paramString2.r = true;
    paramString2.q = true;
    paramString1 = new Bundle();
    localDownloaderInterface.a(paramString2, new ApolloManagerServiceImpl.Download403Listener(localQQAppInterface, paramDownload403Callback), paramString1);
  }
  
  public void downloadJson(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[downloadJson], task:" + paramInt);
    }
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Bundle localBundle = new Bundle();
    if ((paramInt & 0x1) == 1)
    {
      ((List)localObject).add("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipList_apollo_data/tab_list_android_v730.json");
      localArrayList.add("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json");
      localHashMap.put("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipList_apollo_data/tab_list_android_v730.json", new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json"));
      localBundle.putInt("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipList_apollo_data/tab_list_android_v730.json", 1);
    }
    if (getDownloader() != null)
    {
      localObject = new DownloadTask((List)localObject, localHashMap, "apollo_json_task" + System.currentTimeMillis());
      ((DownloadTask)localObject).p = true;
      ((DownloadTask)localObject).j = false;
      ((DownloadTask)localObject).n = true;
      ((DownloadTask)localObject).s = false;
      ((DownloadTask)localObject).f = "apollo_res";
      ((DownloadTask)localObject).r = true;
      ((DownloadTask)localObject).q = true;
      getDownloader().a((DownloadTask)localObject, this.jsonListener, localBundle);
      if ((paramInt & 0x1) == 1) {
        VipUtils.a(getApp(), "cmshow", "Apollo", "json_download_begin", 0, 0, new String[0]);
      }
      if ((paramInt & 0x2) == 2) {
        VipUtils.a(getApp(), "cmshow", "Apollo", "json_download_begin", 1, 0, new String[0]);
      }
    }
  }
  
  public void downloadResAndPanel(List<ApolloActionData> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Bundle localBundle;
    ArrayList localArrayList;
    do
    {
      HashMap localHashMap;
      do
      {
        return;
        localBundle = new Bundle();
        localArrayList = new ArrayList();
        localHashMap = new HashMap();
        addApolloActionTask(localArrayList, localHashMap, paramList, localBundle);
      } while (localBundle.size() == 0);
      paramList = new DownloadTask(localArrayList, localHashMap, paramString);
      paramList.n = true;
      paramList.f = "apollo_res";
      paramList.p = true;
      paramList.s = false;
      paramList.r = true;
      paramList.q = true;
    } while ((localArrayList.size() == 0) || (getDownloader() == null));
    VipUtils.a(getApp(), "cmshow", "Apollo", "action_download_begin", 0, 0, new String[0]);
    getDownloader().a(paramList, this.listener, localBundle);
  }
  
  public int getAVIPLevel(String paramString)
  {
    paramString = getApolloBaseInfo(paramString);
    if ((paramString == null) || (paramString.apolloVipLevel < 1)) {
      return 1;
    }
    return paramString.apolloVipLevel;
  }
  
  public boolean getAVIPStatus(String paramString)
  {
    paramString = getApolloBaseInfo(paramString);
    if (paramString != null) {
      return paramString.apolloVipFlag == 1;
    }
    return false;
  }
  
  public String getApolloAppearAction(QQAppInterface paramQQAppInterface, String paramString)
  {
    ApolloBaseInfo localApolloBaseInfo = getApolloBaseInfo(paramString);
    if (localApolloBaseInfo == null) {
      return null;
    }
    try
    {
      if (this.mPullStandActionMap.get(paramString) == null) {}
      for (long l = 0L; (localApolloBaseInfo.appearAction == null) && (NetConnInfoCenter.getServerTime() - l > 180L); l = ((Long)this.mPullStandActionMap.get(paramString)).longValue())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, new Object[] { "getApolloAppearAction request appear action uin:", paramString.substring(0, 4) });
        }
        ((ApolloExtensionHandlerImpl)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(new long[] { Long.parseLong(paramString) });
        this.mPullStandActionMap.put(paramString, Long.valueOf(NetConnInfoCenter.getServerTime()));
        return null;
      }
      if (localApolloBaseInfo.appearAction == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "getApolloAppearAction request appear action is null and last request is near");
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
      QLog.e("ApolloManager", 1, "getApolloAppearAction e:", paramQQAppInterface);
      return null;
    }
    return null;
  }
  
  public ApolloBaseInfo getApolloBaseInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    QQAppInterface localQQAppInterface = getApp();
    if ((localQQAppInterface != null) && (paramString.equals(localQQAppInterface.getCurrentAccountUin()))) {}
    for (int i = 1; (i != 0) && (this.mSelfApolloBaseInfo != null); i = 0)
    {
      changeNewRole(paramString, localQQAppInterface, this.mSelfApolloBaseInfo);
      return this.mSelfApolloBaseInfo;
    }
    synchronized (this.mApolloBaseInfoCache)
    {
      if (this.mApolloBaseInfoCache.containsKey(paramString))
      {
        paramString = (ApolloBaseInfo)this.mApolloBaseInfoCache.get(paramString);
        return paramString;
      }
      ??? = getEntityManager();
      if ((0 != 0) || (this.isApolloBaseInfoCacheInited)) {
        break label545;
      }
      if (??? == null)
      {
        QLog.e("ApolloManager", 1, "[getApolloBaseInfo] from database error, em is null!");
        return null;
      }
    }
    ??? = (ApolloBaseInfo)((EntityManager)???).find(ApolloBaseInfo.class, paramString);
    if (i != 0)
    {
      changeNewRole(paramString, localQQAppInterface, (ApolloBaseInfo)???);
      this.mSelfApolloBaseInfo = ((ApolloBaseInfo)???);
    }
    if (??? != null) {
      synchronized (this.mApolloBaseInfoCache)
      {
        this.mApolloBaseInfoCache.put(paramString, ???);
        QLog.d("ApolloManager", 1, "unInit mApolloBaseInfoCache, find from db uin: " + ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString) + ", apollo status: " + ((ApolloBaseInfo)???).apolloStatus + ";apolloBaseInfo : " + ((ApolloBaseInfo)???).toString());
        return ???;
      }
    }
    for (;;)
    {
      synchronized (this.mApolloBaseInfoCache)
      {
        if (this.mApolloBaseInfoCache.containsKey(paramString))
        {
          ??? = (ApolloBaseInfo)this.mApolloBaseInfoCache.get(paramString);
          ??? = ???;
          if (??? == null)
          {
            ??? = new ApolloBaseInfo();
            ((ApolloBaseInfo)???).uin = paramString;
            QLog.d("ApolloManager", 1, "apolloBaseInfo is null, make default.");
          }
          QLog.d("ApolloManager", 1, "apolloBaseInfo : " + ((ApolloBaseInfo)???).toString());
          return ???;
        }
        if (??? == null)
        {
          QLog.e("ApolloManager", 2, "[getApolloBaseInfo] from database error, em is null!");
          return null;
        }
      }
      label542:
      for (;;)
      {
        try
        {
          if (!this.mUnCacheUinSets.contains(Long.valueOf(Long.parseLong(paramString)))) {
            break label542;
          }
          ??? = (ApolloBaseInfo)((EntityManager)???).find(ApolloBaseInfo.class, paramString);
          ??? = ???;
          if (??? == null) {}
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          try
          {
            this.mApolloBaseInfoCache.put(paramString, ???);
            ??? = ???;
            if (QLog.isColorLevel())
            {
              QLog.d("ApolloManager", 2, "mApolloBaseInfoCache unCache, mUnCacheUinSets contains, find from db uin: " + ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString) + ", apollo status: " + ((ApolloBaseInfo)???).apolloStatus);
              ??? = ???;
            }
          }
          catch (NumberFormatException localNumberFormatException3)
          {
            ??? = localNumberFormatException1;
            NumberFormatException localNumberFormatException2 = localNumberFormatException3;
            continue;
          }
          localNumberFormatException1 = localNumberFormatException1;
          QLog.e("ApolloManager", 1, localNumberFormatException1, new Object[0]);
        }
        break;
      }
      label545:
      ??? = null;
    }
  }
  
  public ApolloBaseInfo getApolloBaseInfoFromCache(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return null;
    }
    QQAppInterface localQQAppInterface = getApp();
    if ((localQQAppInterface != null) && (paramString.equals(localQQAppInterface.getCurrentAccountUin())) && (this.mSelfApolloBaseInfo != null))
    {
      QLog.d("ApolloManager", 1, "getApolloBaseInfoFromCache mSelfApolloBaseInfo : " + this.mSelfApolloBaseInfo);
      return this.mSelfApolloBaseInfo;
    }
    if (this.mApolloBaseInfoCache.containsKey(paramString))
    {
      paramString = (ApolloBaseInfo)this.mApolloBaseInfoCache.get(paramString);
      QLog.d("ApolloManager", 1, "getApolloBaseInfoFromCache mApolloBaseInfoCache : " + paramString);
      return paramString;
    }
    ThreadManager.getSubThreadHandler().post(new ApolloManagerServiceImpl.17(this, paramString));
    return null;
  }
  
  public String getApolloGameLocalVersion(int paramInt)
  {
    if (!new File(ApolloUtilImpl.getApolloGameLuaPath(paramInt)).exists())
    {
      QLog.i("ApolloManager", 1, "[getApolloGameLocalVersion], errInfo->game main.lua file not exists, gameId:" + paramInt);
      localObject2 = "0.0";
      return localObject2;
    }
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      return "0.0";
    }
    Object localObject1 = (ApolloDaoManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    Object localObject2 = ((ApolloDaoManagerServiceImpl)localObject1).getApolloGameVer();
    if (((ConcurrentHashMap)localObject2).size() == 0) {
      ((ApolloDaoManagerServiceImpl)localObject1).readApolloGameVerFromFile();
    }
    for (;;)
    {
      localObject2 = (String)((ConcurrentHashMap)localObject2).get(Integer.valueOf(paramInt));
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).getString("apollo_game_ver_" + paramInt, "0.0");
        QLog.i("ApolloManager", 1, "read game ver from sp");
      }
      localObject2 = localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloManager", 2, "gameVer:" + (String)localObject1 + ",id:" + paramInt);
      return localObject1;
      if (TextUtils.isEmpty((CharSequence)((ConcurrentHashMap)localObject2).get(Integer.valueOf(paramInt)))) {
        ((ApolloDaoManagerServiceImpl)localObject1).readApolloGameVerFromFile(paramInt);
      }
    }
  }
  
  public ApolloPandora getApolloPandora(String paramString, boolean paramBoolean)
  {
    ApolloPandora localApolloPandora = null;
    if (TextUtils.isEmpty(paramString)) {
      ??? = localApolloPandora;
    }
    do
    {
      EntityManager localEntityManager;
      do
      {
        do
        {
          return ???;
          if (this.apolloPandoraCache.contains(paramString)) {
            return (ApolloPandora)this.apolloPandoraCache.get(paramString);
          }
          ??? = localApolloPandora;
        } while (!paramBoolean);
        localEntityManager = getEntityManager();
        ??? = localApolloPandora;
      } while (localEntityManager == null);
      localApolloPandora = (ApolloPandora)localEntityManager.find(ApolloPandora.class, paramString);
      ??? = localApolloPandora;
    } while (localApolloPandora == null);
    synchronized (this.apolloPandoraCache)
    {
      this.apolloPandoraCache.put(paramString, localApolloPandora);
      return localApolloPandora;
    }
  }
  
  public ApolloPanelManager getApolloPanelManager()
  {
    if (this.mApolloPanelManager == null)
    {
      QQAppInterface localQQAppInterface = getApp();
      if (localQQAppInterface != null) {
        this.mApolloPanelManager = new ApolloPanelManager(localQQAppInterface);
      }
    }
    return this.mApolloPanelManager;
  }
  
  public long getApolloResLocalTimestamp(int paramInt1, int paramInt2)
  {
    if (this.mApolloResVersionInfo == null) {}
    for (;;)
    {
      return 0L;
      JSONObject localJSONObject = null;
      if (paramInt1 == 3) {
        localJSONObject = this.mApolloResVersionInfo.optJSONObject("action_version");
      }
      while (localJSONObject != null)
      {
        return localJSONObject.optLong(String.valueOf(paramInt2));
        if (paramInt1 == 2) {
          localJSONObject = this.mApolloResVersionInfo.optJSONObject("dress_version");
        } else if (paramInt1 == 1) {
          localJSONObject = this.mApolloResVersionInfo.optJSONObject("role_version");
        }
      }
    }
  }
  
  public int getApolloStatus(String paramString)
  {
    paramString = getApolloBaseInfo(paramString);
    if (paramString != null) {
      return paramString.apolloStatus;
    }
    return 0;
  }
  
  public int getApolloUserStatus(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      QLog.e("ApolloManager", 1, "getApolloUserStatus app is null, return default 0");
    }
    for (;;)
    {
      return 0;
      if (!isHardwareSupport(BaseApplicationImpl.getContext()))
      {
        QLog.e("ApolloManager", 1, "getApolloUserStatus !isHardwareSupport, return default 0");
        return 0;
      }
      checkDpcSwitch();
      if ((!sApolloSwitch) && (!sCmShow3dDPCSwitch))
      {
        QLog.e("ApolloManager", 1, "getApolloUserStatus sApolloSwitch : " + sApolloSwitch + "; sCmShow3dDPCSwitch : " + sCmShow3dDPCSwitch);
        return 0;
      }
      ApolloBaseInfo localApolloBaseInfo = getApolloBaseInfoFromCache(paramAppRuntime.getCurrentUin());
      if ((localApolloBaseInfo != null) && (localApolloBaseInfo.apolloStatus == 1))
      {
        if ((sCmShow3dDPCSwitch) && (get3dWhiteListStatus(paramAppRuntime) == 1)) {}
        for (boolean bool = true;; bool = false)
        {
          QLog.d("ApolloManager", 1, "is3dAvailable " + bool);
          if ((!bool) || ((localApolloBaseInfo.cmshow3dFlag & 0x1) != 1)) {
            break;
          }
          return 2;
        }
        if ((sApolloSwitch) && (getWhiteListStatus(paramAppRuntime) == 1)) {}
        for (int i = 1; i != 0; i = 0) {
          return 1;
        }
      }
    }
  }
  
  public BubbleProducer getBubbleProducer()
  {
    if (this.mBubbleProducer == null) {}
    try
    {
      if (this.mBubbleProducer == null) {
        this.mBubbleProducer = new BubbleProducer(this, getApp());
      }
      return this.mBubbleProducer;
    }
    finally {}
  }
  
  public List<ApolloActionData> getCMSActionList()
  {
    Object localObject = getApp();
    if (localObject == null) {
      return null;
    }
    localObject = (ApolloDaoManagerServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloDaoManagerService.class, "all");
    if (localObject != null) {
      return ((ApolloDaoManagerServiceImpl)localObject).getActionByPackageId(9);
    }
    return null;
  }
  
  public CmGameAudioManager getCmGameAudioManager()
  {
    try
    {
      if (this.mCmGameAudioManager == null) {
        this.mCmGameAudioManager = new CmGameAudioManager(getApp());
      }
      CmGameAudioManager localCmGameAudioManager = this.mCmGameAudioManager;
      return localCmGameAudioManager;
    }
    finally {}
  }
  
  public CmGameConnManager getCmGameConnManager()
  {
    try
    {
      if (this.mCmGameConnManager == null) {
        this.mCmGameConnManager = new CmGameConnManager(getApp());
      }
      CmGameConnManager localCmGameConnManager = this.mCmGameConnManager;
      return localCmGameConnManager;
    }
    finally {}
  }
  
  public CmGamePushManager getCmGamePushManager()
  {
    return this.mCmGamePushManager;
  }
  
  public int getCmShowStatus(QQAppInterface paramQQAppInterface, String paramString)
  {
    return getCmShowStatus(paramQQAppInterface, paramString, true);
  }
  
  public int getCmShowStatus(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "[getCmShowStatus] withStrictCheck=", Boolean.valueOf(paramBoolean) });
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    ApolloBaseInfo localApolloBaseInfo;
    do
    {
      do
      {
        do
        {
          do
          {
            return 0;
            paramString = getApolloBaseInfoFromCache(paramString);
          } while (paramString == null);
          if (!paramBoolean) {
            break;
          }
        } while (!isHardwareSupport(BaseApplicationImpl.getContext()));
        checkDpcSwitch();
      } while ((!sApolloSwitch) && (!sCmShow3dDPCSwitch));
      localApolloBaseInfo = getApolloBaseInfoFromCache(paramQQAppInterface.getCurrentUin());
    } while ((localApolloBaseInfo == null) || (localApolloBaseInfo.apolloStatus != 1) || (paramString.apolloStatus != 1));
    if ((sCmShow3dDPCSwitch) && (get3dWhiteListStatus(paramQQAppInterface) == 1) && ((paramString.cmshow3dFlag & 0x2) == 2) && ((paramString.cmshow3dFlag & 0x1) == 1)) {}
    for (;;)
    {
      return i;
      if ((sApolloSwitch) && (getWhiteListStatus(paramQQAppInterface) == 1) && ((paramString.cmshow3dFlag & 0x1) == 0))
      {
        i = 1;
      }
      else
      {
        i = 0;
        continue;
        if (paramString.apolloStatus != 1) {
          break;
        }
        if (((paramString.cmshow3dFlag & 0x2) != 2) || ((paramString.cmshow3dFlag & 0x1) != 1)) {
          i = 1;
        }
      }
    }
  }
  
  public int getCmShowStatusNoCareSelfStatus(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "[getCmShowStatus] withStrictCheck=", Boolean.valueOf(paramBoolean) });
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        do
        {
          return 0;
          paramQQAppInterface = getApolloBaseInfoFromCache(paramString);
        } while (paramQQAppInterface == null);
        if (!paramBoolean) {
          break;
        }
      } while (!isHardwareSupport(BaseApplicationImpl.getContext()));
      checkDpcSwitch();
    } while (((!sApolloSwitch) && (!sCmShow3dDPCSwitch)) || (paramQQAppInterface.apolloStatus != 1));
    if ((sCmShow3dDPCSwitch) && ((paramQQAppInterface.cmshow3dFlag & 0x2) == 2) && ((paramQQAppInterface.cmshow3dFlag & 0x1) == 1)) {}
    for (;;)
    {
      return i;
      if ((sApolloSwitch) && ((paramQQAppInterface.cmshow3dFlag & 0x1) == 0))
      {
        i = 1;
      }
      else
      {
        i = 0;
        continue;
        if (((paramQQAppInterface.cmshow3dFlag & 0x2) != 2) || ((paramQQAppInterface.cmshow3dFlag & 0x1) != 1)) {
          i = 1;
        }
      }
    }
  }
  
  public boolean getConfigInitDone()
  {
    return this.mConfigInitDone.get();
  }
  
  public DrawerPushItem getCurrentPushItem(int paramInt)
  {
    int i;
    switch (ApolloGameUtil.a(getApp()))
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      return getCurrentPushItemByUserStatus(paramInt, i);
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public DrawerPushItem getCurrentPushItemByUserStatus(int paramInt1, int paramInt2)
  {
    long l;
    Object localObject4;
    for (;;)
    {
      DrawerPushItem localDrawerPushItem;
      synchronized (this.mPushLock)
      {
        if ((this.mDrawerPushItems == null) || (this.mDrawerPushItems.isEmpty())) {
          return null;
        }
        Collections.sort(this.mDrawerPushItems, this.mPushItemComparator);
        l = System.currentTimeMillis() / 1000L;
        if (paramInt1 != 0) {
          break label318;
        }
        ArrayList localArrayList = new ArrayList();
        localObject4 = new ArrayList();
        Iterator localIterator = this.mDrawerPushItems.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localDrawerPushItem = (DrawerPushItem)localIterator.next();
        if ((localDrawerPushItem.msg_type != paramInt1) || (localDrawerPushItem.start_ts >= l) || (localDrawerPushItem.end_ts <= l) || (localDrawerPushItem.show_sum >= localDrawerPushItem.show_counts) || (((paramInt2 == 0) || (paramInt2 == 2)) && ((localDrawerPushItem.target_model != 0) && (localDrawerPushItem.target_model != 2) && (localDrawerPushItem.target_model != paramInt2)))) {
          continue;
        }
        if (localDrawerPushItem.fromTianshu) {
          localArrayList.add(localDrawerPushItem);
        }
      }
      ((List)localObject4).add(localDrawerPushItem);
    }
    QLog.d("ApolloManager", 1, new Object[] { "getCurrentPushItemByUserStatus, tianshuDrawerList=", localObject2, ", reddotDrawerList=", localObject4 });
    Object localObject3;
    if (localObject2.size() > 0)
    {
      localObject3 = (DrawerPushItem)localObject2.get(0);
      return localObject3;
    }
    if (((List)localObject4).size() > 0)
    {
      localObject3 = (DrawerPushItem)((List)localObject4).get(0);
      return localObject3;
      label318:
      localObject3 = this.mDrawerPushItems.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (DrawerPushItem)((Iterator)localObject3).next();
        if ((((DrawerPushItem)localObject4).msg_type == paramInt1) && (((DrawerPushItem)localObject4).start_ts < l) && (((DrawerPushItem)localObject4).end_ts > l) && (((DrawerPushItem)localObject4).show_sum < ((DrawerPushItem)localObject4).show_counts))
        {
          if (((paramInt2 == 0) || (paramInt2 == 2)) && ((((DrawerPushItem)localObject4).target_model == 0) || (((DrawerPushItem)localObject4).target_model == 2))) {
            return localObject4;
          }
          if (((DrawerPushItem)localObject4).target_model == paramInt2) {
            return localObject4;
          }
        }
      }
    }
    return null;
  }
  
  public int getDrawerStatus(QQAppInterface paramQQAppInterface)
  {
    int k = 0;
    int i = -1;
    int j;
    if (paramQQAppInterface == null) {
      j = i;
    }
    int m;
    do
    {
      boolean bool2;
      do
      {
        return j;
        boolean bool1 = isApolloFuncOpen(paramQQAppInterface.getApplication());
        if (bool1) {
          i = 0;
        }
        bool2 = ApolloEngine.a();
        m = getApolloUserStatus(paramQQAppInterface);
        QLog.d("ApolloManager", 1, "getDrawerStatus isEngineReady : " + bool2 + "; apolloStatus : " + m + "; isApolloOpen : " + bool1);
        if (m > 0) {
          k = 1;
        }
        j = i;
      } while (!bool2);
      j = i;
    } while (k == 0);
    if (m == 1) {
      return 1;
    }
    return 6;
  }
  
  public WeakReference<BaseChatPie> getGameChatPieRef()
  {
    return this.mApolloGameChatPieRef;
  }
  
  public CmGameTempSessionHandler getGameTempMsgHandler()
  {
    if (this.mGameTempMsgHandler == null) {
      this.mGameTempMsgHandler = new CmGameTempSessionHandler(getApp());
    }
    return this.mGameTempMsgHandler;
  }
  
  public String getGuestUrl(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return ApolloConstant.v;
    }
    return add3DInteractParams(getApp(), ApolloConstant.B, paramString);
  }
  
  public String getLastTabUrl(int paramInt, String paramString)
  {
    int j = getApolloUserStatus(getApp());
    boolean bool = is3dAvailable(getApp());
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("3d"))) {}
    for (paramInt = 2;; paramInt = 1)
    {
      Object localObject1 = "";
      int i;
      if ((!bool) && (j == paramInt))
      {
        localObject1 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getStoreTabUrl(paramString, true);
        i = 1;
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (i == 0))
        {
          if (j != 2) {
            break label404;
          }
          localObject1 = ApolloConstant.B;
        }
      }
      for (;;)
      {
        Object localObject2 = localObject1;
        if (bool)
        {
          localObject2 = localObject1;
          if (j == 1)
          {
            localObject2 = localObject1;
            if (getApp() != null)
            {
              SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0);
              localObject3 = getApp().getCurrentAccountUin() + "_" + "sp_key_first_3d_tab";
              localObject2 = localObject1;
              if (!localSharedPreferences.getBoolean((String)localObject3, false))
              {
                localObject2 = localObject1;
                if (!TextUtils.isEmpty(ApolloConstant.B))
                {
                  localObject2 = ApolloConstant.B;
                  localObject1 = localSharedPreferences.edit();
                  ((SharedPreferences.Editor)localObject1).putBoolean((String)localObject3, true);
                  ((SharedPreferences.Editor)localObject1).commit();
                }
              }
            }
          }
        }
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getLastTabUrl userStatus:").append(j).append(",tabStatus:").append(paramInt).append(",tabScheme:").append(paramString).append(",is3DAvailable:").append(bool).append(",url:").append((String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, ((StringBuilder)localObject3).toString());
        }
        paramString = (String)localObject2;
        if (!TextUtils.isEmpty(ApolloConstant.B))
        {
          paramString = (String)localObject2;
          if (ApolloConstant.B.equals(localObject2)) {
            paramString = add3DInteractParams(getApp(), (String)localObject2, null);
          }
        }
        localObject1 = paramString;
        if (TextUtils.isEmpty(paramString))
        {
          localObject1 = ApolloConstant.v;
          QLog.d("ApolloManager", 1, new Object[] { "url is empty", ((StringBuilder)localObject3).toString() });
        }
        return localObject1;
        i = 0;
        break;
        label404:
        if (bool) {
          localObject1 = ApolloConstant.D;
        } else {
          localObject1 = ApolloConstant.v;
        }
      }
    }
  }
  
  public int getOpenType()
  {
    return this.openType;
  }
  
  public String getPanelPicPath(ApolloActionData paramApolloActionData)
  {
    if (isPlayerAction(paramApolloActionData))
    {
      String str = ApolloUtilImpl.getApolloResPath(paramApolloActionData, 10);
      if (new File(str).exists()) {
        return str;
      }
    }
    return ApolloUtilImpl.getApolloResPath(paramApolloActionData, 0);
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
    if (paramJSONObject == null) {}
    do
    {
      return 0;
      paramJSONObject = paramJSONObject.optString("petCategory");
    } while (TextUtils.isEmpty(paramJSONObject));
    try
    {
      int i = Integer.parseInt(paramJSONObject);
      return i;
    }
    catch (NumberFormatException paramJSONObject)
    {
      QLog.e("ApolloPet", 1, "getPetCategory error:", paramJSONObject);
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
    if (this.mPetConfig == null) {}
    for (;;)
    {
      return null;
      try
      {
        JSONArray localJSONArray = new JSONArray(this.mPetConfig);
        int j = localJSONArray.length();
        int i = 0;
        while (i < j)
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
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
        QLog.e("ApolloPet", 1, "getPetInfo error:", localException);
      }
    }
  }
  
  public int getPetRandomAction(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (this.mPetConfig == null) {
          return -1;
        }
        JSONArray localJSONArray = new JSONArray(this.mPetConfig);
        int j = localJSONArray.length();
        if (i >= j) {
          continue;
        }
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        if (localJSONObject.getInt("roleId") != paramInt) {
          continue;
        }
        localJSONArray = localJSONObject.getJSONArray("petStateMapping").getJSONObject(0).getJSONArray("actionSet");
        paramInt = localJSONArray.length();
        paramInt = ((Integer)localJSONArray.get(new Random().nextInt(paramInt))).intValue();
      }
      catch (Exception localException)
      {
        QLog.e("ApolloPet", 1, "getPetRandomAction error:", localException);
        paramInt = -1;
        continue;
      }
      return paramInt;
      i += 1;
    }
  }
  
  public String getPlusTipsStr()
  {
    if ((!this.mIsPlayedGame) && (!this.mIsMiniAppPlayed)) {
      return HardCodeUtil.a(2131700544);
    }
    return HardCodeUtil.a(2131700541);
  }
  
  public ApolloActionData getRandomAppearAction(QQAppInterface paramQQAppInterface, String paramString, int... paramVarArgs)
  {
    if ((paramQQAppInterface == null) || (paramString == null) || (paramVarArgs == null)) {
      return null;
    }
    Object localObject = getApolloBaseInfo(paramString);
    if (localObject == null) {
      return null;
    }
    HashSet localHashSet = new HashSet();
    int j = paramVarArgs.length;
    int i = 0;
    if (i < j)
    {
      int k = paramVarArgs[i];
      if ((k == 4) && (!((ApolloBaseInfo)localObject).hasPet)) {}
      for (;;)
      {
        i += 1;
        break;
        localHashSet.add(Integer.valueOf(k));
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
            break label447;
          }
          paramVarArgs.add(localObject);
          break label447;
        }
        if (paramVarArgs.size() != 0)
        {
          paramString = (JSONObject)paramVarArgs.get(ApolloUtilImpl.getPositiveRandomInteger(paramVarArgs.size()));
          if (paramString != null)
          {
            j = paramString.getInt("id");
            i = paramString.getInt("type");
            if (j <= 0) {
              break label445;
            }
            if (ApolloUtilImpl.isActionResDone(j, 0))
            {
              paramQQAppInterface = new ApolloActionData();
              paramQQAppInterface.actionId = j;
              if (i == 4) {
                paramQQAppInterface.actionType = 7;
              }
              if (QLog.isColorLevel()) {
                QLog.d("ApolloManager", 2, new Object[] { "getRandomAppearAction actionId:", Integer.valueOf(j), ",type:", Integer.valueOf(i) });
              }
              return paramQQAppInterface;
            }
          }
          else
          {
            QLog.e("ApolloManager", 1, "[getRandomAppearAction] found empty json obj");
            break label456;
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label456;
          }
          QLog.d("ApolloManager", 2, "[getRandomAppearAction]found empty json arr ");
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("ApolloManager", 1, "[getRandomAppearAction]:" + paramQQAppInterface);
        return null;
      }
      paramVarArgs = new ApolloActionData();
      paramVarArgs.actionId = j;
      paramString = ApolloUtilImpl.getApolloResPath(paramVarArgs, 5);
      paramVarArgs = ApolloUtilImpl.getApolloResPath(paramVarArgs, 4);
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadSpecialAction(paramQQAppInterface, paramVarArgs, paramString);
      QLog.w("ApolloManager", 2, "getRandomAppearAction action resource not ready,actionId:" + j);
      label445:
      return null;
      label447:
      i += 1;
      continue;
      label456:
      i = 0;
      j = 0;
    }
  }
  
  public IApolloResDownloader.OnApolloDownLoadListener getResDownloadListener()
  {
    if (this.mApolloResReadListener == null) {
      this.mApolloResReadListener = new ApolloManagerServiceImpl.13(this);
    }
    return this.mApolloResReadListener;
  }
  
  public File getResFile(ApolloActionData paramApolloActionData, int paramInt)
  {
    if (paramApolloActionData == null) {
      return null;
    }
    String str = "";
    if ((paramInt & 0x1) == 1) {
      str = getPanelPicPath(paramApolloActionData);
    }
    for (;;)
    {
      return new File(str);
      if ((paramInt & 0x2) == 2) {
        str = ApolloUtilImpl.getApolloResPath(paramApolloActionData, 2);
      }
    }
  }
  
  public SharedPreferences getStandUpSp()
  {
    String str2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "noLogin";
    }
    return BaseApplicationImpl.getApplication().getSharedPreferences("apollo_stand_up" + str1, 4);
  }
  
  public File getTabFile(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {
      return null;
    }
    return new File(ApolloUtilImpl.getApolloTabResPath(paramApolloActionPackage));
  }
  
  public String getUinForReload()
  {
    return this.mUinForReload;
  }
  
  public HashMap<Integer, Bundle> getUserActionId()
  {
    return this.mUserActionId;
  }
  
  public int getWhiteListStatus(AppRuntime paramAppRuntime)
  {
    for (;;)
    {
      try
      {
        if (sWhiteUserStatus == -1)
        {
          sWhiteUserStatus = 0;
          if (paramAppRuntime != null)
          {
            i = SharedPreUtils.q(paramAppRuntime.getApplication());
            if (i != 0) {
              continue;
            }
            sWhiteUserStatus = paramAppRuntime.getApplication().getSharedPreferences("apollo_sp", 0).getInt(paramAppRuntime.getAccount() + "_whiteList", 0);
            QLog.d("ApolloManager", 1, "white list global: " + i + ", mWhiteUserStatus: " + sWhiteUserStatus);
          }
        }
      }
      catch (Throwable paramAppRuntime)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloManager", 2, "getWhiteListStatus error = " + paramAppRuntime.toString());
        continue;
      }
      return sWhiteUserStatus;
      if (1 == i) {
        sWhiteUserStatus = 1;
      }
    }
  }
  
  public void handleCMSPlayerGetFrame(String paramString, ApolloActionData paramApolloActionData, GetFrameCallback paramGetFrameCallback)
  {
    ThreadManager.getSubThreadHandler().post(new ApolloManagerServiceImpl.25(this, paramApolloActionData, paramGetFrameCallback));
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
      if (!TextUtils.isEmpty(ApolloConstant.H)) {
        break label25;
      }
      ApolloConfProcessor.b();
    }
    label25:
    while (paramBoolean) {
      return;
    }
    ApolloContentUpdateHandler.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public void initDataAfterConfig()
  {
    Object localObject = getApp();
    if (localObject == null) {}
    do
    {
      return;
      localObject = (ApolloContentUpdateHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.APOLLO_CONTENT_UPDATE_HANDLER);
    } while ((localObject == null) || (!((ApolloContentUpdateHandler)localObject).a.get()));
    QLog.w("ApolloManager", 1, "config is done, then request update");
    ArrayList localArrayList = new ArrayList();
    ((ApolloContentUpdateHandler)localObject).b(localArrayList);
    ((ApolloContentUpdateHandler)localObject).a(localArrayList);
    ((ApolloContentUpdateHandler)localObject).a.set(false);
  }
  
  public void initTextureViewConfig(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    int j = Build.VERSION.SDK_INT;
    if (paramJSONObject != null)
    {
      if (paramJSONObject.optInt("all") == 1) {
        this.mUseTextureViewConfig = true;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ApolloManager", 2, "initTextureViewConfig jsonObject:" + paramJSONObject);
        }
        if (Build.MODEL.contains("MI 4")) {
          this.mUseTextureViewConfig = false;
        }
        QLog.i("ApolloManager", 2, "initTextureViewConfig mUseTextureViewConfig:" + this.mUseTextureViewConfig);
        return;
        JSONArray localJSONArray = paramJSONObject.optJSONArray("sdkIntArray");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          int k = localJSONArray.length();
          int i = 0;
          for (;;)
          {
            if (i >= k) {
              break label171;
            }
            if (localJSONArray.optInt(i) == j)
            {
              this.mUseTextureViewConfig = true;
              break;
            }
            this.mUseTextureViewConfig = false;
            i += 1;
          }
        }
        else
        {
          label171:
          this.mUseTextureViewConfig = false;
        }
      }
    }
    boolean bool1 = bool2;
    if (j != 19) {
      if (j != 23) {
        break label210;
      }
    }
    label210:
    for (bool1 = bool2;; bool1 = false)
    {
      this.mUseTextureViewConfig = bool1;
      break;
    }
  }
  
  public boolean is3dAvailable(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    if (!isHardwareSupport(BaseApplicationImpl.getContext()))
    {
      QLog.w("ApolloManager", 1, "[is3dAvailable] isHardwareSupport false");
      return false;
    }
    checkDpcSwitch();
    if (!sCmShow3dDPCSwitch)
    {
      QLog.w("ApolloManager", 1, "[is3dAvailable] dpc switch off");
      return false;
    }
    ApolloBaseInfo localApolloBaseInfo = getApolloBaseInfoFromCache(paramQQAppInterface.getCurrentUin());
    if (localApolloBaseInfo == null)
    {
      QLog.w("ApolloManager", 1, "[is3dAvailable] no baseInfo");
      return false;
    }
    if ((localApolloBaseInfo.apolloStatus == 1) && (get3dWhiteListStatus(paramQQAppInterface) == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "[is3dAvailable] is3dAvailable=", Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public boolean is765GuideShowed()
  {
    boolean bool = false;
    if ((BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getBoolean("is_new_user_bar_showed" + CmGameUtil.a().getCurrentAccountUin(), false)) || (this.mIsShowedNewPopView)) {
      bool = true;
    }
    return bool;
  }
  
  public boolean is780GuideShowed()
  {
    boolean bool = false;
    if ((BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getBoolean("is_780_guide_showed" + CmGameUtil.a().getCurrentAccountUin(), false)) || (this.mIs780GuideShowed)) {
      bool = true;
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
  
  public boolean isApolloFuncOpen(Context paramContext)
  {
    return isApolloFuncOpen(paramContext, Boolean.valueOf(true));
  }
  
  public boolean isApolloFuncOpen(Context paramContext, Boolean paramBoolean)
  {
    boolean bool2 = true;
    if (!isHardwareSupport(paramContext)) {}
    do
    {
      return false;
      checkDpcSwitch();
    } while ((!sApolloSwitch) && (!sCmShow3dDPCSwitch));
    boolean bool1;
    if (paramBoolean.booleanValue())
    {
      if (!sApolloSwitch) {
        break label95;
      }
      if (getWhiteListStatus(CmGameUtil.a()) == 1) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((!bool1) && (sCmShow3dDPCSwitch)) {
        if (get3dWhiteListStatus(CmGameUtil.a()) == 1) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        return bool1;
        bool1 = false;
        break;
        bool1 = false;
        continue;
        return true;
      }
      label95:
      bool1 = false;
    }
  }
  
  public boolean isApolloGameWhiteUser(String paramString)
  {
    paramString = getApolloBaseInfo(paramString);
    if (paramString != null) {
      return paramString.isApolloGameWhiteUser();
    }
    return false;
  }
  
  public boolean isApolloSupport(Context paramContext)
  {
    boolean bool3 = true;
    if (!isHardwareSupport(paramContext)) {}
    do
    {
      return false;
      checkDpcSwitch();
    } while ((!sApolloSwitch) && (!sCmShow3dDPCSwitch));
    boolean bool1;
    if (sApolloSwitch) {
      if (getWhiteListStatus(CmGameUtil.a()) == 1) {
        bool1 = true;
      }
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (sCmShow3dDPCSwitch)
        {
          if (get3dWhiteListStatus(CmGameUtil.a()) != 1) {
            break label94;
          }
          bool2 = true;
        }
      }
      label74:
      if (!bool2) {
        if (!DeviceInfoUtils.b()) {
          bool1 = bool3;
        }
      }
      for (;;)
      {
        return bool1;
        bool1 = false;
        break;
        label94:
        bool2 = false;
        break label74;
        bool1 = false;
        continue;
        bool1 = bool2;
      }
      bool1 = false;
    }
  }
  
  public boolean isCMSPanelPicExists(ApolloActionData paramApolloActionData)
  {
    return (isPlayerAction(paramApolloActionData)) && (new File(ApolloUtilImpl.getApolloResPath(paramApolloActionData, 10)).exists());
  }
  
  public boolean isClickIgnore()
  {
    return this.mIsClickIgnore;
  }
  
  public boolean isDisableCreateRenderThread()
  {
    return this.mDisableCreateRenderThread;
  }
  
  public boolean isGameAudioManagerCreated()
  {
    return this.mCmGameAudioManager != null;
  }
  
  public boolean isGetPlusStatus()
  {
    return this.mIsGetPlusStatus;
  }
  
  public boolean isHardwareSupport(Context paramContext)
  {
    boolean bool = false;
    if (ApolloGameUtil.a()) {
      return false;
    }
    if (sHardWareTested) {
      return sHardWareSupportApollo;
    }
    if (Build.VERSION.SDK_INT >= 14) {
      bool = true;
    }
    sHardWareSupportApollo = bool;
    if (!sHardWareSupportApollo)
    {
      sHardWareTested = true;
      return sHardWareSupportApollo;
    }
    if (paramContext != null)
    {
      sHardWareSupportApollo = isOpenglSupport(paramContext);
      sHardWareTested = true;
    }
    return sHardWareSupportApollo;
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
    return sInitedDone;
  }
  
  public boolean isMiniAppPlayed()
  {
    return this.mIsMiniAppPlayed;
  }
  
  public boolean isNeedShowWorldCup()
  {
    return this.mNeedShowWorldCup;
  }
  
  public boolean isPlayerAction(ApolloActionData paramApolloActionData)
  {
    return (paramApolloActionData != null) && (paramApolloActionData.isForPlayerAction == 1);
  }
  
  public boolean isPlusBTest()
  {
    return false;
  }
  
  public boolean isPlusWhiteList()
  {
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {}
    do
    {
      return false;
      if ((BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getBoolean("is_white" + localQQAppInterface.getCurrentAccountUin(), false)) || (this.mIsPlusWhiteList)) {
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloManager", 2, "isPlusWhiteList false");
    return false;
  }
  
  public boolean isSuperYellow(String paramString)
  {
    boolean bool = true;
    if (!TextUtils.isEmpty(paramString))
    {
      QQAppInterface localQQAppInterface = getApp();
      if ((localQQAppInterface != null) && (paramString.equals(localQQAppInterface.getCurrentAccountUin()))) {
        bool = QZoneVipInfoManager.getInstance().isSuperYellow();
      }
      do
      {
        return bool;
        paramString = getApolloBaseInfo(paramString);
      } while ((paramString != null) && (paramString.superYellowDiamondFlag == 1));
      return false;
    }
    return false;
  }
  
  public boolean isUseTextureViewConfig()
  {
    return this.mUseTextureViewConfig;
  }
  
  public void notify3dFlagUpdate(int paramInt1, int paramInt2)
  {
    QLog.d("ApolloManager", 1, new Object[] { "[notify3dFlagUpdate] previous3dFlag=", Integer.valueOf(paramInt1), ", new3dFlag=", Integer.valueOf(paramInt2) });
    if (((paramInt1 & 0x1) != (paramInt2 & 0x1)) || ((paramInt1 & 0x2) != (paramInt2 & 0x2)))
    {
      paramInt1 = ApolloGameUtil.a(getApp());
      boolean bool = is3dAvailable(getApp());
      QLog.d("ApolloManager", 1, new Object[] { "[notify3dFlagUpdate] currentStatus=", Integer.valueOf(paramInt1), ", is3dAvailable=", Boolean.valueOf(bool) });
      if (this.mStatusUpdateListeners != null)
      {
        Iterator localIterator = this.mStatusUpdateListeners.iterator();
        while (localIterator.hasNext())
        {
          ApolloStatusUpdateListener localApolloStatusUpdateListener = (ApolloStatusUpdateListener)((WeakReference)localIterator.next()).get();
          if (localApolloStatusUpdateListener != null) {
            localApolloStatusUpdateListener.a(paramInt1, bool);
          }
        }
      }
    }
  }
  
  public void onAddOrDelGame()
  {
    if (this.mListenerManager != null) {
      this.mListenerManager.a(Boolean.valueOf(true));
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      this.mAppRef = new WeakReference((QQAppInterface)paramAppRuntime);
    }
    QLog.e("ApolloManager", 1, "[onCreate] init success!");
    sWhiteUserStatus = -1;
    s3dWhiteUserStatus = -1;
    sBulkPullDressList.clear();
    sBulkApolloInfoList.clear();
    if ((paramAppRuntime instanceof AppInterface)) {
      this.mEntityManager = ((AppInterface)paramAppRuntime).getEntityManagerFactory().createEntityManager();
    }
    if (isHardwareSupport(paramAppRuntime.getApp()))
    {
      this.mListenerManager = new ApolloListenerManager();
      checkDefaultRes();
      CmGameServerQIPCModule.b();
      ThreadManager.getSubThreadHandler().post(this.asyncInitDataRunnable);
      ThreadManager.getFileThreadHandler().post(this.mReadApolloResVersionRunable);
    }
    this.mCMSPlayer = new CMSPlayer(ApolloConstant.jdField_a_of_type_Int, ApolloConstant.jdField_a_of_type_Int);
    initApolloStoreBroadcastReceiver();
    initApolloMsgObserver();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "onDestroy.");
    }
    if (this.mBroadcastReceiver != null) {}
    try
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.mBroadcastReceiver);
      this.mBroadcastReceiver = null;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "onDestroy. unregisterReceiver mBroadcastReceiver success");
      }
      this.mIsInitConfig = false;
      ApolloUtilImpl.clearFlag();
      sWhiteUserStatus = -1;
      s3dWhiteUserStatus = -1;
      if (this.mEntityManager != null) {
        this.mEntityManager.close();
      }
      ApolloResDownloaderImpl.sRoleDefaultDress.clear();
      this.mActionDownloadList.clear();
      this.mAsyncSubThreadHandler.removeCallbacksAndMessages(null);
      sInitedDone = false;
      com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.jdField_a_of_type_Int = 0;
      if (this.apolloPandoraCache != null) {
        this.apolloPandoraCache.clear();
      }
      if (this.mApolloBaseInfoCache == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.mApolloBaseInfoCache.evictAll();
        label139:
        sIsChecking.set(false);
        this.mConfigInitDone.set(false);
        if (this.mApolloPanelManager != null)
        {
          this.mApolloPanelManager.d();
          this.mApolloPanelManager = null;
        }
        ApolloGameStateMachine.d();
        ApolloGameUtil.a();
        ApolloGameTool.a();
        ApolloConfigDataReport.a();
        if (this.mGameTempMsgHandler != null) {
          this.mGameTempMsgHandler.b();
        }
        if (this.mCmGameConnManager != null)
        {
          this.mCmGameConnManager.e();
          this.mCmGameConnManager = null;
        }
        if (this.mCmGameAudioManager != null)
        {
          this.mCmGameAudioManager.b();
          this.mCmGameAudioManager = null;
        }
        removeAllApolloInitCallback();
        CmGameServerQIPCModule.a().a();
        Object localObject = CmGameServerQIPCModule.a().a();
        if (localObject != null) {
          ((CmGameLifeCycleMgr)localObject).a();
        }
        TraceReportInstance.a().a();
        sBasicScript = null;
        if (this.mGlobalTimer != null)
        {
          this.mGlobalTimer.cancel();
          this.mGlobalTimer.purge();
          this.mGlobalTimer = null;
        }
        mCallbackMap.clear();
        localObject = getApp();
        if ((localObject != null) && (this.mMessageObserver != null)) {
          ((QQAppInterface)localObject).removeObserver(this.mMessageObserver);
        }
        return;
        localException1 = localException1;
        QLog.e("ApolloManager", 1, localException1, new Object[0]);
      }
      catch (Exception localException2)
      {
        break label139;
      }
    }
  }
  
  public void onGetGameList()
  {
    if (this.mListenerManager != null) {
      this.mListenerManager.a(Boolean.valueOf(true));
    }
  }
  
  public boolean parseActionPanelJSon()
  {
    if (this.mIsJsonParsing.get() == true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "apollo json is parsing,return.");
      }
      return true;
    }
    this.mIsJsonParsing.set(true);
    Object localObject3 = null;
    Object localObject4 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    Object localObject1;
    int i;
    label224:
    long l;
    try
    {
      localObject1 = FileUtils.b(new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json"));
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("parseActionPanelJSon start file size:");
        if (localObject1 == null)
        {
          i = 0;
          QLog.d("ApolloManager", 2, i + " byte");
        }
      }
      else
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label224;
        }
        this.mIsJsonParsing.set(false);
        return false;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.e("ApolloManager", 2, "read json fail e =" + localThrowable1.toString());
          localObject1 = localObject3;
          continue;
          i = ((String)localObject1).length();
        }
      }
      l = System.currentTimeMillis();
    }
    for (;;)
    {
      int j;
      try
      {
        if ((this.mUserActionId == null) || (this.mUserActionId.size() <= 0)) {
          break label1581;
        }
        i = 1;
        localObject1 = new JSONObject((String)localObject1);
        localObject3 = ((JSONObject)localObject1).getJSONArray("tabList");
        j = 0;
        if (j < ((JSONArray)localObject3).length())
        {
          localObject5 = ((JSONArray)localObject3).getString(j);
          localObject6 = ((JSONObject)localObject1).optJSONObject((String)localObject5);
          if ("actionInfo".equals(localObject5))
          {
            parseActionInfo((List)localObject4, localArrayList1, localArrayList2, localArrayList4, (JSONObject)localObject6);
            if (!QLog.isColorLevel()) {
              break label1574;
            }
            QLog.d("ApolloManager", 2, "apollo json tablist :" + (String)localObject5);
            break label1574;
          }
          if (!"gameInfo".equals(localObject5)) {
            continue;
          }
          continue;
        }
        ((JSONObject)localObject1).optJSONObject("bubbleInfo");
        if (((JSONObject)localObject1).has("Info3D"))
        {
          QLog.d("ApolloManager", 1, "parseActionPanelJSon parse info3d");
          localObject3 = ((JSONObject)localObject1).optJSONObject("Info3D");
          boolean bool = ((JSONObject)localObject3).has("actionInfo");
          if (!bool) {}
        }
      }
      catch (Exception localException)
      {
        Object localObject5;
        Object localObject6;
        int k;
        int m;
        QLog.e("ApolloManager", 1, "parseActionPanelJSon failed", localException);
        this.mIsJsonParsing.set(false);
        QLog.d("ApolloManager", 1, "parseActionPanelJSon end cost: " + (System.currentTimeMillis() - l) + "ms");
        continue;
      }
      finally
      {
        this.mIsJsonParsing.set(false);
        QLog.d("ApolloManager", 1, "parseActionPanelJSon end cost: " + (System.currentTimeMillis() - l) + "ms");
      }
      try
      {
        if (isTest3DAction())
        {
          localObject5 = ((JSONObject)localObject3).optJSONObject("actionInfo");
          if ((localObject5 != null) && (((JSONObject)localObject5).has("data")) && (((JSONObject)localObject5).has("packageInfo")))
          {
            localObject6 = ((JSONObject)localObject5).optJSONArray("data");
            JSONObject localJSONObject1 = new JSONObject();
            localJSONObject1.put("id", 3000338);
            localJSONObject1.put("type", 0);
            localJSONObject1.put("name", "好");
            localJSONObject1.put("isForPlayerAction", 1);
            localJSONObject1.put("isShow", 1);
            localJSONObject1.put("version", 1596202218552L);
            localJSONObject1.put("minVer", "0.0.0");
            localJSONObject1.put("maxVer", "999.9.9");
            localJSONObject1.put("description", "");
            localJSONObject1.put("activeValue", 0);
            ((JSONArray)localObject6).put(localJSONObject1);
            localObject6 = ((JSONObject)localObject5).optJSONArray("packageInfo");
            localJSONObject1 = new JSONObject();
            localJSONObject1.put("name", "GIF");
            localJSONObject1.put("type", 0);
            localJSONObject1.put("apImg", "http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_common_data/6930e33d363536801fd1f4be1070a07f.png");
            localJSONObject1.put("apcImg", "http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_common_data/897874c735693cefce34efa37b13ec10.png");
            localJSONObject1.put("startVersion", "0.0.0");
            localJSONObject1.put("endVersion", "999.9.9");
            localJSONObject1.put("packageId", 309);
            JSONArray localJSONArray = new JSONArray();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("actionId", 3000338);
            localJSONObject2.put("textType", 0);
            localJSONArray.put(localJSONObject2);
            localJSONObject1.put("actionSet", localJSONArray);
            ((JSONArray)localObject6).put(localJSONObject1);
          }
          QLog.d("ApolloManager", 4, "3d actionInfo " + ((JSONObject)localObject5).toString());
        }
      }
      catch (Throwable localThrowable2)
      {
        continue;
      }
      parseActionInfo((List)localObject4, localArrayList1, localArrayList2, localArrayList4, ((JSONObject)localObject3).optJSONObject("actionInfo"));
      if ((!((JSONObject)localObject3).has("appConfig")) || (((JSONObject)localObject3).has("bubbleInfo"))) {
        ((JSONObject)localObject3).optJSONObject("bubbleInfo");
      }
      if (((JSONObject)localObject1).has("whiteFace")) {
        parseWhiteFaceIdMapping(((JSONObject)localObject1).optJSONObject("whiteFace"), localArrayList3);
      }
      localObject3 = getApp();
      if (localObject3 != null)
      {
        localObject5 = (ApolloDaoManagerServiceImpl)((QQAppInterface)localObject3).getRuntimeService(IApolloDaoManagerService.class, "all");
        ((ApolloDaoManagerServiceImpl)localObject5).saveWhiteFaceIdMapping(false, localArrayList3);
        ((ApolloDaoManagerServiceImpl)localObject5).removeAllAction();
        ((ApolloDaoManagerServiceImpl)localObject5).saveAction((List)localObject4);
        ((ApolloDaoManagerServiceImpl)localObject5).removePackageInfo(1);
        ((ApolloDaoManagerServiceImpl)localObject5).savePackageInfo(localArrayList1);
        ((ApolloDaoManagerServiceImpl)localObject5).removeAllPackageData();
        ((ApolloDaoManagerServiceImpl)localObject5).saveActionPackageInfo(localArrayList2);
        ((ApolloDaoManagerServiceImpl)localObject5).removeAllActionTag();
        ((ApolloDaoManagerServiceImpl)localObject5).saveActionTag(localArrayList4);
        if ((i == 0) && (!sFristOpenPanel))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ApolloManager", 1, "parseActionPanelJSon request getUserApolloInfo~");
          }
          ((ApolloExtensionHandlerImpl)((QQAppInterface)localObject3).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(((QQAppInterface)localObject3).getCurrentUin(), 128, "refreshAction");
        }
        this.mListenerManager.a(Boolean.valueOf(true));
        checkResForGuidePanel();
      }
      if (localObject3 != null)
      {
        ((QQAppInterface)localObject3).getApplication().getSharedPreferences(((QQAppInterface)localObject3).getCurrentAccountUin(), 0).edit().putBoolean("chat_tool_apollo_" + ((QQAppInterface)localObject3).getCurrentAccountUin(), true).commit();
        localObject4 = ((QQAppInterface)localObject3).getApplication().getSharedPreferences("apollo_sp", 0);
        if (!((SharedPreferences)localObject4).getBoolean("8.5.5" + ((QQAppInterface)localObject3).getCurrentAccountUin(), false)) {
          ((SharedPreferences)localObject4).edit().putBoolean("8.5.5" + ((QQAppInterface)localObject3).getCurrentAccountUin(), true).commit();
        }
        if (localObject1 != null)
        {
          i = (int)(((JSONObject)localObject1).optLong("timeStamp") / 1000L);
          ((SharedPreferences)localObject4).edit().putInt("apollo_json_version" + ((QQAppInterface)localObject3).getCurrentAccountUin(), i).commit();
          ((SharedPreferences)localObject4).edit().putInt("apollo_json_version", i).commit();
        }
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("petConfig");
      if ((localObject1 != null) && (localObject3 != null))
      {
        ((QQAppInterface)localObject3).getApplication().getSharedPreferences("apollo_pet_sp", 0).edit().putString("pet_config", ((JSONArray)localObject1).toString()).commit();
        this.mPetConfig = ((JSONArray)localObject1).toString();
        j = ((JSONArray)localObject1).length();
        i = 0;
        if (i < j)
        {
          localObject4 = ((JSONArray)localObject1).getJSONObject(i);
          k = ((JSONObject)localObject4).optInt("standUpAction", 0);
          m = ((JSONObject)localObject4).optInt("getDownAction", 0);
          downloadActionIfNotExist(k, 0);
          downloadActionIfNotExist(m, 0);
          i += 1;
          continue;
        }
      }
      if (localObject3 != null) {
        checkCompat2DActionRsc();
      }
      this.mIsJsonParsing.set(false);
      QLog.d("ApolloManager", 1, "parseActionPanelJSon end cost: " + (System.currentTimeMillis() - l) + "ms");
      this.mIsJsonParsing.set(false);
      return true;
      label1574:
      j += 1;
      continue;
      label1581:
      i = 0;
    }
  }
  
  public DrawerPushItem parseApolloRedTouchContent(String paramString1, String paramString2, JSONObject paramJSONObject, boolean paramBoolean, int paramInt)
  {
    Object localObject = getApp();
    if ((paramJSONObject == null) || (localObject == null))
    {
      paramString1 = null;
      return paramString1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "parseShopRedTouchManager:", paramJSONObject, ", isNewRed：", Boolean.valueOf(paramBoolean), ",msgType：", Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      DrawerPushItem localDrawerPushItem;
      try
      {
        int i = paramJSONObject.optInt("time");
        localObject = ((QQAppInterface)localObject).getApp().getSharedPreferences("apollo_sp" + ((QQAppInterface)localObject).getCurrentUin(), 0);
        if (i == ((SharedPreferences)localObject).getInt(paramString1, 0))
        {
          paramJSONObject = getCurrentPushItemByMsgId(paramString2);
          paramString1 = paramJSONObject;
          if (paramBoolean) {
            break;
          }
          if (paramJSONObject == null) {
            break label531;
          }
          clearBubble(paramString2);
          break label531;
        }
        paramJSONObject = paramJSONObject.optString("content");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          paramJSONObject = new JSONObject(paramJSONObject);
          localDrawerPushItem = new DrawerPushItem();
          localDrawerPushItem.is_reddot = 1;
          localDrawerPushItem.msg_id = paramString2;
          localDrawerPushItem.msg_type = paramInt;
          if (!paramJSONObject.has("mainPriority")) {
            return null;
          }
          localDrawerPushItem.priority = paramJSONObject.optInt("mainPriority");
          localDrawerPushItem.sub_priority = paramJSONObject.optInt("subPriority");
          localDrawerPushItem.start_ts = paramJSONObject.optInt("showTime");
          localDrawerPushItem.end_ts = paramJSONObject.optInt("expireTime");
          localDrawerPushItem.send_time = i;
          localDrawerPushItem.action_id = paramJSONObject.optInt("actionId");
          localDrawerPushItem.color = paramJSONObject.optInt("fontColor");
          localDrawerPushItem.content = paramJSONObject.optString("bubbleText");
          localDrawerPushItem.bubble_res_id = paramJSONObject.optInt("bubbleID");
          localDrawerPushItem.icon_url = paramJSONObject.optString("iconUrl");
          localDrawerPushItem.life_Time = paramJSONObject.optInt("tipsDuration");
          paramInt = paramJSONObject.optInt("type");
          if (paramInt != 0) {
            break label493;
          }
          localDrawerPushItem.scheme = paramJSONObject.optString("scheme");
          localDrawerPushItem.show_counts = paramJSONObject.optInt("showCounts");
          long l = NetConnInfoCenter.getServerTime();
          if ((paramBoolean) && (localDrawerPushItem.start_ts < l) && (localDrawerPushItem.end_ts > l))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, new Object[] { "parseShopRedTouchManager addPushItem:", localDrawerPushItem.toString() });
            }
            addPushItem(localDrawerPushItem);
            ((SharedPreferences)localObject).edit().putInt(paramString1, i).commit();
            return localDrawerPushItem;
          }
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("ApolloManager", 2, "parseApolloRedTouchContent Exception:", paramString1);
      }
      return null;
      label493:
      if (paramInt == 1) {
        localDrawerPushItem.ext_url = ApolloConstant.g;
      } else if (paramInt == 2) {
        localDrawerPushItem.ext_url = paramJSONObject.optString("url");
      }
    }
    label531:
    return null;
  }
  
  public void predownloadForGameCenter(String paramString)
  {
    QLog.d("ApolloManager", 1, new Object[] { "[predownloadForGameCenter] predownloadStr=", paramString });
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      QLog.e("ApolloManager", 1, "[predownloadForGameCenter] app null");
    }
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      int i;
      int m;
      int n;
      long l1;
      long l2;
      int k;
      long l3;
      int j;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("predownloadList");
        if ((paramString == null) || (paramString.length() <= 0)) {
          break;
        }
        i = 0;
        if (i >= paramString.length()) {
          break;
        }
        localObject1 = paramString.getJSONObject(i);
        m = ((JSONObject)localObject1).optInt("platform");
        n = ((JSONObject)localObject1).optInt("netType");
        l1 = ((JSONObject)localObject1).optLong("beginTime");
        l2 = ((JSONObject)localObject1).optLong("endTime");
        str1 = ((JSONObject)localObject1).optString("minQQVer");
        localObject2 = ((JSONObject)localObject1).optString("maxQQVer");
        k = HttpUtil.getNetWorkType();
        l3 = NetConnInfoCenter.getServerTime();
        j = k;
        if (k != 1) {
          break label512;
        }
        j = 10;
      }
      catch (Exception paramString)
      {
        Object localObject1;
        String str1;
        Object localObject2;
        String str2;
        QLog.e("ApolloManager", 1, "[predownloadForGameCenter] exception=", paramString);
        return;
      }
      if (ApolloConfigUtils.a("8.5.5", str1, (String)localObject2))
      {
        j = ((JSONObject)localObject1).optInt("type");
        str1 = ((JSONObject)localObject1).optString("downloadInfo");
        if (!TextUtils.isEmpty(str1))
        {
          localObject2 = localQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
          str2 = "sp_key_game_center_predownload_res_" + str1;
          k = ((SharedPreferences)localObject2).getInt(str2, -1);
          m = ((JSONObject)localObject1).optInt("configVer");
          boolean bool1;
          boolean bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloManager", 1, new Object[] { "[predownloadForGameCenter] downloadInfo=", str1, ", downloadedVersion=", Integer.valueOf(k), ", configVersion=", Integer.valueOf(m) });
            break label549;
            QLog.d("ApolloManager", 1, new Object[] { "[predownloadForGameCenter] shouldDownload=", Boolean.valueOf(bool1), ", bid=", str1 });
            if (!bool1) {
              break label569;
            }
            ThreadManager.executeOnFileThread(new ApolloManagerServiceImpl.23(this, str1, localQQAppInterface, (SharedPreferences)localObject2, str2, m));
            break label569;
            localObject1 = OfflineEnvHelper.a(str1);
            bool1 = bool2;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              continue;
            }
            localObject1 = new File((String)localObject1 + str1 + "/b.zip");
            bool1 = bool2;
            if (localObject1 == null) {
              continue;
            }
            bool1 = bool2;
            if (((File)localObject1).exists()) {
              continue;
            }
            QLog.d("ApolloManager", 1, new Object[] { "[predownloadForGameCenter] no zip file for bid:", str1 });
            bool1 = true;
            continue;
            label512:
            if ((j < n) || (l3 < l1) || (l1 > l2)) {
              break label569;
            }
            if (m == 0) {
              continue;
            }
            if (m != 109) {
              break label569;
            }
            continue;
          }
          label549:
          if (j == 0)
          {
            bool2 = false;
            if (m <= k) {
              continue;
            }
            bool1 = true;
            continue;
          }
        }
      }
      label569:
      i += 1;
    }
  }
  
  public void pushApolloPanelGame(int paramInt) {}
  
  public int queryApolloSwitchSet(String paramString)
  {
    int j = 0;
    int i;
    if (ApolloConfigUtils.b == null)
    {
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("ApolloManager", 2, "queryApolloSwitchSet key:" + paramString + " sSwitchSet = null");
        i = j;
      }
    }
    do
    {
      do
      {
        return i;
        if (!"gameSwitch".equals(paramString)) {
          break;
        }
        i = j;
      } while (!sCmGameDPCSwitch);
      j = ApolloConfigUtils.b.optInt(paramString);
      i = j;
    } while (j != 2);
    return sGameOidbStatus;
    return ApolloConfigUtils.b.optInt(paramString);
  }
  
  public int queryStatusInConfig(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    int j = -1;
    int k = j;
    if (paramQQAppInterface != null)
    {
      k = j;
      if (isHardwareSupport(paramQQAppInterface.getApplication()))
      {
        k = j;
        if (!TextUtils.isEmpty(paramString1))
        {
          if (ApolloConfigUtils.a != null) {
            break label50;
          }
          k = j;
        }
      }
    }
    label50:
    do
    {
      String str;
      int i;
      do
      {
        return k;
        str = paramString2;
        if (TextUtils.isEmpty(paramString2))
        {
          str = paramString2;
          if (!TextUtils.isEmpty(paramQQAppInterface.getCurrentAccountUin()))
          {
            if (this.mSelfApolloBaseInfo == null) {
              break;
            }
            i = this.mSelfApolloBaseInfo.apolloStatus;
            k = getWhiteListStatus(paramQQAppInterface);
            str = k + "x" + i;
          }
        }
        i = j;
        if (ApolloConfigUtils.a != null)
        {
          i = j;
          if (str != null)
          {
            paramQQAppInterface = ApolloConfigUtils.a.optJSONObject(str);
            i = j;
            if (paramQQAppInterface != null) {
              i = paramQQAppInterface.optInt(paramString1);
            }
          }
        }
        k = i;
      } while (!QLog.isColorLevel());
      QLog.d("ApolloManager", 2, "queryStatusInConfig ruleKey: " + str + ", entry = " + paramString1 + ", value=" + i);
      return i;
      ThreadManager.getSubThreadHandler().post(new ApolloManagerServiceImpl.16(this, paramQQAppInterface));
      k = j;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloManager", 2, "queryStatusInConfig but apollomanager dont init done");
    return -1;
  }
  
  public void removeAllListener()
  {
    if (this.mListenerManager != null) {
      this.mListenerManager.a();
    }
  }
  
  public void removeAllS2CPushItem()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[removeAllS2CPushItem]");
    }
    ThreadManager.post(new ApolloManagerServiceImpl.19(this), 5, null, true);
  }
  
  public void removeDownLoadListener(IResDownloadListener paramIResDownloadListener)
  {
    if ((paramIResDownloadListener != null) && (this.mListenerManager != null)) {
      this.mListenerManager.b(paramIResDownloadListener);
    }
  }
  
  public boolean removeFromActionDownloadList(int paramInt)
  {
    return this.mActionDownloadList.remove(Integer.valueOf(paramInt));
  }
  
  public boolean removeFromActionPlayList(long paramLong)
  {
    return this.mActionPlayList.remove(Long.valueOf(paramLong));
  }
  
  public void removePushItem(DrawerPushItem paramDrawerPushItem)
  {
    ThreadManager.post(new ApolloManagerServiceImpl.18(this, paramDrawerPushItem), 5, null, true);
  }
  
  public void requestTianshuAdv()
  {
    ArrayList localArrayList = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.jdField_a_of_type_Int = 364;
    localTianShuAdPosItemData.b = 1;
    localArrayList.add(localTianShuAdPosItemData);
    localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.jdField_a_of_type_Int = 365;
    localTianShuAdPosItemData.b = 1;
    localArrayList.add(localTianShuAdPosItemData);
    localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.jdField_a_of_type_Int = 366;
    localTianShuAdPosItemData.b = 1;
    localArrayList.add(localTianShuAdPosItemData);
    localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.jdField_a_of_type_Int = 367;
    localTianShuAdPosItemData.b = 1;
    localArrayList.add(localTianShuAdPosItemData);
    localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.jdField_a_of_type_Int = 393;
    localTianShuAdPosItemData.b = 1;
    localArrayList.add(localTianShuAdPosItemData);
    localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.jdField_a_of_type_Int = 433;
    localTianShuAdPosItemData.b = 20;
    localArrayList.add(localTianShuAdPosItemData);
    localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.jdField_a_of_type_Int = 501;
    localTianShuAdPosItemData.b = 1;
    localArrayList.add(localTianShuAdPosItemData);
    localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.jdField_a_of_type_Int = 502;
    localTianShuAdPosItemData.b = 1;
    localArrayList.add(localTianShuAdPosItemData);
    TianShuManager.getInstance().requestAdv(localArrayList, this.mTianshuCallback);
  }
  
  public void save3DFace(String paramString, Save3DFaceListener paramSave3DFaceListener)
  {
    QQAppInterface localQQAppInterface = getApp();
    if ((paramString != null) && (localQQAppInterface != null))
    {
      FileUtils.a("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/face3d/json/face.json", paramString);
      FileUtils.f("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/face3d/json/", "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/face3d/face3d.zip");
      this.mFileController = ((ITransFileController)localQQAppInterface.getRuntimeService(ITransFileController.class));
      paramString = new ApolloManagerServiceImpl.26(this, ThreadManager.getSubThreadLooper());
      paramString.addFilter(new Class[] { BDHCommonUploadProcessor.class });
      this.mFileController.addHandle(paramString);
      this.mSave3DFaceListenerRef = new WeakReference(paramSave3DFaceListener);
      paramString = new TransferRequest();
      paramString.mFileType = 24;
      paramString.mCommandId = 79;
      paramString.mSelfUin = localQQAppInterface.getCurrentUin();
      paramString.mPeerUin = "0";
      paramString.mUniseq = ((Math.random() * 1000000.0D));
      paramString.mIsUp = true;
      paramString.mRequestLength = ((int)new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/face3d/face3d.zip").length());
      paramString.mLocalPath = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/face3d/face3d.zip";
      paramString.mRichTag = "cmshow3DFace";
      paramSave3DFaceListener = new Bdh_extinfo.CommFileExtReq();
      paramSave3DFaceListener.uint32_action_type.set(0);
      paramSave3DFaceListener.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString() + ".zip"));
      paramString.mExtentionInfo = paramSave3DFaceListener.toByteArray();
      this.mFileController.transferAsync(paramString);
    }
  }
  
  public void saveApolloResLocalTimestamp(int paramInt1, int paramInt2, long paramLong)
  {
    long l2 = 0L;
    if (this.mApolloResVersionInfo == null) {
      this.mApolloResVersionInfo = new JSONObject();
    }
    String str;
    JSONObject localJSONObject1;
    if (paramInt1 == 3)
    {
      str = "action_version";
      if (str != null)
      {
        ??? = this.mApolloResVersionInfo.optJSONObject(str);
        localJSONObject1 = ???;
        if (??? == null) {
          localJSONObject1 = new JSONObject();
        }
      }
    }
    for (;;)
    {
      synchronized (this.mApolloResVersionInfo)
      {
        try
        {
          l1 = localJSONObject1.optLong(String.valueOf(paramInt2), 0L);
          l2 = l1;
          if (l1 == paramLong) {
            break label280;
          }
          l2 = l1;
          localJSONObject1.put(String.valueOf(paramInt2), paramLong);
          l2 = l1;
          this.mApolloResVersionInfo.put(str, localJSONObject1);
          i = 1;
          if (i != 0)
          {
            ThreadManager.getFileThreadHandler().removeCallbacks(this.mSaveApolloResVersionRunnable);
            ThreadManager.getFileThreadHandler().postDelayed(this.mSaveApolloResVersionRunnable, 6000L);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "saveLocalTS id: " + paramInt2 + ", old TS: " + l1 + ", new TS: " + paramLong + ", type: " + paramInt1);
            }
          }
          return;
        }
        catch (Exception localException)
        {
          QLog.d("ApolloManager", 2, localException.getMessage());
        }
        if (paramInt1 == 2)
        {
          str = "dress_version";
          break;
        }
        if (paramInt1 == 1) {
          str = "role_version";
        }
      }
      Object localObject2 = null;
      break;
      label280:
      int i = 0;
      long l1 = l2;
    }
  }
  
  public void saveOrUpdateApolloBaseInfo(ApolloBaseInfo paramApolloBaseInfo)
  {
    if ((paramApolloBaseInfo == null) || (TextUtils.isEmpty(paramApolloBaseInfo.uin))) {}
    for (;;)
    {
      return;
      QQAppInterface localQQAppInterface = getApp();
      int i;
      if ((localQQAppInterface != null) && (paramApolloBaseInfo.uin.equals(localQQAppInterface.getCurrentAccountUin())))
      {
        this.mSelfApolloBaseInfo = paramApolloBaseInfo;
        if ((paramApolloBaseInfo.cmshow3dFlag & 0x2) != 2) {
          break label219;
        }
        i = 1;
        update3dWhiteList(i);
      }
      synchronized (this.mApolloBaseInfoCache)
      {
        this.mApolloBaseInfoCache.put(paramApolloBaseInfo.uin, paramApolloBaseInfo);
        updateEntity(paramApolloBaseInfo);
        if ((localQQAppInterface == null) || (!paramApolloBaseInfo.uin.equals(localQQAppInterface.getCurrentUin()))) {
          continue;
        }
        QLog.d("ApolloManager", 1, "save apollo info vip status: " + paramApolloBaseInfo.apolloVipFlag + ", vip lev: " + paramApolloBaseInfo.apolloVipFlag + ", apollo status: " + paramApolloBaseInfo.apolloStatus + ", apollo local TS: " + paramApolloBaseInfo.apolloLocalTS + ", apollo svr TS:" + paramApolloBaseInfo.apolloServerTS + ", apollo upt TS:" + paramApolloBaseInfo.apolloUpdateTime + ", apollo AISwitch: " + paramApolloBaseInfo.apolloAISwitch);
        return;
        label219:
        i = 0;
      }
    }
  }
  
  public void saveOrUpdateApolloPandora(ApolloPandora paramApolloPandora)
  {
    if ((paramApolloPandora == null) || (TextUtils.isEmpty(paramApolloPandora.uin))) {
      return;
    }
    synchronized (this.apolloPandoraCache)
    {
      this.apolloPandoraCache.put(paramApolloPandora.uin, paramApolloPandora);
      updateEntity(paramApolloPandora);
      return;
    }
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
  
  public void setApolloGameChatPie(WeakReference<BaseChatPie> paramWeakReference)
  {
    this.mApolloGameChatPieRef = paramWeakReference;
    BubbleProducer localBubbleProducer = getBubbleProducer();
    if (paramWeakReference != null) {}
    for (boolean bool = true;; bool = false)
    {
      localBubbleProducer.c(bool);
      return;
    }
  }
  
  public void setCapsuleHadStolenAsync(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.executeOnSubThread(new ApolloManagerServiceImpl.20(this, paramString));
  }
  
  public void setClickIgnore(boolean paramBoolean)
  {
    this.mIsClickIgnore = paramBoolean;
  }
  
  public void setConfigInitDone(boolean paramBoolean)
  {
    this.mConfigInitDone.set(paramBoolean);
  }
  
  public void setDisableCreateRenderThread(boolean paramBoolean)
  {
    this.mDisableCreateRenderThread = paramBoolean;
  }
  
  public void setGetPlusStatus(boolean paramBoolean)
  {
    this.mIsGetPlusStatus = paramBoolean;
  }
  
  public void setMiniAppPlayed(boolean paramBoolean)
  {
    this.mIsMiniAppPlayed = paramBoolean;
  }
  
  public void setNeedShowWorldCup(boolean paramBoolean)
  {
    this.mNeedShowWorldCup = paramBoolean;
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
  
  public void updateAndDownloadPreRes(Map<String, ApolloPreDownloadData> paramMap)
  {
    Object localObject = getApp();
    if ((localObject == null) || (paramMap == null) || (paramMap.size() == 0)) {}
    Bundle localBundle;
    do
    {
      ArrayList localArrayList;
      HashMap localHashMap;
      do
      {
        return;
        StringBuilder localStringBuilder1;
        StringBuilder localStringBuilder2;
        ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl;
        for (;;)
        {
          ApolloPreDownloadData localApolloPreDownloadData;
          try
          {
            localArrayList = new ArrayList();
            localHashMap = new HashMap();
            localBundle = new Bundle();
            localStringBuilder1 = new StringBuilder();
            localStringBuilder2 = new StringBuilder();
            localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloDaoManagerService.class, "all");
            Map localMap = localApolloDaoManagerServiceImpl.getPreDownloadRes();
            Iterator localIterator = paramMap.values().iterator();
            if (!localIterator.hasNext()) {
              break;
            }
            localApolloPreDownloadData = (ApolloPreDownloadData)localIterator.next();
            if ((TextUtils.isEmpty(localApolloPreDownloadData.resId)) || (TextUtils.isEmpty(localApolloPreDownloadData.dir)) || (TextUtils.isEmpty(localApolloPreDownloadData.md5)) || ((localApolloPreDownloadData.endTime > 0L) && (localApolloPreDownloadData.endTime < NetConnInfoCenter.getServerTime())))
            {
              localStringBuilder1.append(localApolloPreDownloadData.reportId).append(",");
              continue;
            }
            localObject = (ApolloPreDownloadData)localMap.get(localApolloPreDownloadData.resId);
          }
          catch (Exception paramMap)
          {
            QLog.e("ApolloManager", 1, "updateAndDownloadPreRes e:", paramMap);
            return;
          }
          if ((localObject == null) || (((ApolloPreDownloadData)localObject).status == 0) || (localApolloPreDownloadData.version > ((ApolloPreDownloadData)localObject).version))
          {
            localStringBuilder2.append(localApolloPreDownloadData.reportId).append(",ver:").append(localApolloPreDownloadData.version).append(" | ");
            localArrayList.add(localApolloPreDownloadData.url);
            if (!TextUtils.isEmpty(localApolloPreDownloadData.zipDir)) {}
            for (localObject = ApolloUtilImpl.getApolloFileDir(localApolloPreDownloadData.dirType) + localApolloPreDownloadData.zipDir;; localObject = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/pre_download/" + localApolloPreDownloadData.resId + ".zip")
            {
              localHashMap.put(localApolloPreDownloadData.url, new File((String)localObject));
              localBundle.putSerializable(localApolloPreDownloadData.url, localApolloPreDownloadData);
              break;
            }
          }
          localApolloPreDownloadData.status = 1;
        }
        localApolloDaoManagerServiceImpl.savePreDownloadRes(paramMap, true);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, new Object[] { "updateAndDownloadPreRes valid download:", localStringBuilder2.toString(), "\ninvalid config:", localStringBuilder1.toString() });
        }
      } while (localArrayList.size() <= 0);
      paramMap = new DownloadTask(localArrayList, localHashMap, "apollo_preDownload");
      paramMap.n = true;
      paramMap.f = "apollo_res";
      paramMap.p = true;
      paramMap.s = false;
      paramMap.r = true;
      paramMap.q = true;
      paramMap.b = 0;
    } while (getDownloader() == null);
    getDownloader().a(paramMap, this.preDownloadListener, localBundle);
  }
  
  public void updateDrawerItem(DrawerPushItem paramDrawerPushItem)
  {
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      return;
    }
    ((ProxyManager)localQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER)).addMsgQueue(localQQAppInterface.getAccount(), 0, paramDrawerPushItem.getTableName(), paramDrawerPushItem, 4, null);
  }
  
  public void updateLastShopTabInfo(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "[updateLastShopTabInfo] tab=", paramString });
    }
    Object localObject = getApp();
    if (localObject == null) {
      return;
    }
    this.mLastShopTab = paramString;
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0).edit();
    localObject = ((QQAppInterface)localObject).getCurrentAccountUin() + "_" + "sp_key_last_shop_tab";
    if (!TextUtils.isEmpty(paramString)) {
      localEditor.putString((String)localObject, this.mLastShopTab);
    }
    for (;;)
    {
      localEditor.commit();
      return;
      localEditor.remove((String)localObject);
    }
  }
  
  public void updateUserDress(List<ApolloBaseInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ApolloManagerServiceImpl.14(this, paramList));
  }
  
  public void updateUserFlag(int paramInt1, int paramInt2)
  {
    setsGameOidbStatus(paramInt1);
    setGameBoxUserStatus(paramInt1);
  }
  
  public void updateWhiteList(int paramInt)
  {
    QQAppInterface localQQAppInterface = getApp();
    int i;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).edit().putInt(localQQAppInterface.getCurrentAccountUin() + "_whiteList", paramInt).commit();
      i = SharedPreUtils.q(localQQAppInterface.getApplication());
      if (i != 0) {
        break label131;
      }
      sWhiteUserStatus = paramInt;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "update white list " + i + ", mWhiteUserStatus: " + sWhiteUserStatus + ", status: " + paramInt);
      }
      return;
      label131:
      if (1 == i) {
        sWhiteUserStatus = 1;
      } else {
        sWhiteUserStatus = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */