package com.tencent.mobileqq.app;

import abgm;
import absz;
import acmw;
import acnf;
import acng;
import acxz;
import aczy;
import afno;
import aiyq;
import aizi;
import aizx;
import akes;
import akrl;
import aktz;
import algs;
import alht;
import alik;
import ames;
import ampa;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.v4.util.MQLruCache;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.accessibility.AccessibilityManager;
import anri;
import anrt;
import anru;
import ansg;
import antc;
import antk;
import antl;
import anvi;
import anvk;
import anvx;
import anxi;
import anxl;
import anyb;
import anyx;
import anyy;
import anzg;
import anzh;
import aobd;
import aobt;
import aocj;
import aoep;
import aogp;
import aogq;
import aohe;
import aohg;
import aohp;
import aoke;
import aoks;
import aomr;
import aonm;
import aooe;
import aooh;
import aooy;
import aopp;
import aoqy;
import aosm;
import aoxv;
import aoxx;
import aoxz;
import apgm;
import aqrl;
import aqte;
import aqwe;
import aqwg;
import aqwk;
import aqxe;
import argg;
import arpb;
import aryo;
import asbi;
import asli;
import asmi;
import asmj;
import asqt;
import athn;
import atht;
import atlf;
import atlh;
import atlj;
import atni;
import atpt;
import atrv;
import auht;
import aukm;
import aukt;
import avdu;
import avdz;
import avlf;
import avqs;
import avrf;
import avxi;
import awfq;
import awth;
import awtk;
import awtm;
import awto;
import awtz;
import awui;
import awxj;
import awzb;
import axin;
import axnt;
import axpp;
import azbj;
import azbv;
import azco;
import azff;
import azir;
import azjg;
import banp;
import bapk;
import baql;
import bazf;
import bbbq;
import bbxu;
import bcpt;
import bcqt;
import bcrg;
import bcvb;
import bcvc;
import bcvo;
import bcwe;
import bcxj;
import bdaa;
import bdgt;
import bdkc;
import bdkh;
import bdla;
import bdll;
import bdlr;
import bdmd;
import bdmg;
import bdmh;
import bdms;
import bdxj;
import bdxr;
import bdxs;
import bdzx;
import bdzy;
import bfmz;
import bfny;
import bfoh;
import bgkc;
import bgvx;
import bgyo;
import bgyp;
import bgzh;
import bgzw;
import bhbd;
import bhbx;
import bhcl;
import bheg;
import bhgy;
import bhhi;
import bhhr;
import bhpw;
import bkxs;
import bkyh;
import bkyu;
import bkyy;
import blfz;
import blwy;
import blyb;
import blyp;
import blys;
import bmaf;
import bmhv;
import bmqk;
import bmrn;
import bogd;
import com.dataline.activities.LiteActivity;
import com.tencent.ark.ArkStateCenter;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyLockScreenJumpDelegate;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.DialogActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.recent.config.RecentConfig;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.RegisterProxy;
import com.tencent.mobileqq.app.face.FaceConstant.HeadConfig;
import com.tencent.mobileqq.app.face.FaceDecodeTask;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.utils.HeavyTaskExecutor;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.confess.ConfessMsgListFragment;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.data.SigInfo;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager;
import com.tencent.mobileqq.mini.report.MiniAppReportManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.pluginsdk.PluginManageHandler;
import com.tencent.mobileqq.pluginsdk.PluginManageHandler.IPluginManagerProvider;
import com.tencent.mobileqq.pluginsdk.RemotePluginManager.Stub;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.mobileqq.statistics.ReportControllerImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securemodule.impl.SecureModuleService;
import com.tencent.securemodule.service.CloudScanListener;
import com.tencent.securemodule.service.ISecureModuleService;
import com.tencent.securemodule.service.ProductInfo;
import com.tencent.theme.TextHook;
import com.tencent.util.MsgAutoMonitorUtil;
import cooperation.qqcircle.eevee.QCircleEeveeMananger;
import cooperation.qqcircle.proxy.QCircleInvokeProxy;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.whitelist.QCirclePreLoadManager;
import cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qzone.report.lp.LpReportManager;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import lbd;
import ldh;
import lmt;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.WtloginManagerImpl;
import mqq.manager.Manager;
import mqq.manager.PushManager;
import mqq.manager.ServerConfigManager;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;
import mtj;
import ncz;
import nqf;
import ntq;
import nyv;
import nza;
import oez;
import oli;
import onx;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import osg;
import pkh;
import pkj;
import pwb;
import sgy;
import tlx;
import tmz;
import usu;
import uuc;
import weg;
import wyw;
import ykv;

public class QQAppInterface
  extends AppInterface
  implements PluginManageHandler.IPluginManagerProvider
{
  public static volatile boolean AIO_HAD_OPEN = false;
  public static final String AUTHORIZATION_NAME = "B1_QQ_Neighbor_android";
  public static final String AUTHORIZATION_PASSWORD = "NzVK_qGE";
  public static final int AUTO_CHECK_UPGRADE = 0;
  public static final String BROADCAST_NEW_MESSAGE_NOFITY = "com.tencent.msg.newmessage";
  private static final String BROADCAST_QZONE_CLEAR_COUNT = "com.tencent.qzone.cleanunreadcount";
  private static long CHECK_FACE_UPDATE_PERIOD = 0L;
  static final String DATANAME_QZONE_CLEAR_COUNT = "clean_unread_feed_type";
  private static final int FACE_TYPE_OHTER_SYSTEM = -55;
  private static final int FACE_TYPE_TROOP_SYSTEM = -56;
  private static final long FIVE_SECOND = 5000L;
  private static final int[] IMPORTANT_MANAGERS;
  public static final int MANUAL_CHECK_UPGRADE = 1;
  private static final int MAX_CHECKTIME = 168;
  public static final int MAX_RUNNING_TASK = 2;
  private static final int MAX_TRY_COUNT = 3;
  public static final int MAX_TRY_TIME = 3;
  private static final int MIN_CHECKTIME = 1;
  private static final int MSG_GET_ONLINE_FRIENDS = 0;
  public static final int MSG_X_2_MOBILE = 1;
  public static final int MSG_X_2_NONE = 3;
  public static final int MSG_X_2_WIFI = 2;
  public static final String QQ_ACTION_LOGOUT = "com.tencent.mobileqq.intent.logout";
  private static final String QQ_HEAD_BROADCAST = "Q.qqhead.broadcast";
  public static final String QQ_HEAD_QAIF = "Q.qqhead.qaif";
  public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1;
  public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3;
  public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2;
  public static final String ROUND_IMAGE = "round";
  private static final long SERVER_CONFIG_TIMEOUT = 7200000L;
  static final String TAG = "QQAppInterface";
  private static final String TAG_NOTIFY = "notification";
  static final String TAG_SECURITY_SCAN = "security_scan";
  static final long TIME_SPACE = 2000L;
  public static final int VIBRATE_TYPE_COMMON = 1;
  public static final int VIBRATE_TYPE_SHAKE = 2;
  public static final int VIBRATE_TYPE_SPECIAL_FRIEND = 3;
  public static final long[] VIBRATOR_PATTERN;
  public static final long[] VIBRATOR_PATTERN_SHAKE;
  public static final long[] VIBRATOR_TIME_SELECTOR;
  private static final String VIDEO_PROCESS_NAME = "com.tencent.mobileqq:video";
  public static int curBrowserFontSizeIndex;
  public static int sGetOnlineFriendDelay;
  public static int sNextGetOnlineFriendDelay;
  private static TextToSpeech sTts;
  public aqwe aboutConfig;
  private long accountStartTime;
  private BusinessHandler[] allHandler = new BusinessHandler[BusinessHandlerFactory.COUNT_HANDLER];
  private volatile long[] areMessageRefreshUI = new long[2];
  public boolean bFirstPacket = true;
  public boolean bReceiveMsgOnExit;
  QQAppInterface.RefreshBadgeHelper badgeHelper = new QQAppInterface.RefreshBadgeHelper(this);
  List<BusinessObserver> bgObservers = new Vector();
  private aohg cacheManager;
  private anrt checkPttListener;
  private anru checkPtvListener;
  private aqwk config;
  volatile acmw convsFacade;
  List<BusinessObserver> defaultObservers = new Vector();
  private EntityManager em;
  private QQEntityManagerFactory emFactory;
  private Object faceDecodeFailMapLock = new Object();
  private MQLruCache<String, Object> faceIconCache = BaseApplicationImpl.sImageCache;
  private QQLruCache<String, Setting> faceSettingCache;
  private ConcurrentHashMap<String, Long> faceTimestamps = new ConcurrentHashMap(4);
  private atht fileTransferHandler;
  Set<String> friendInfoQueue = new HashSet();
  private anvi friendListObserver = new QQAppInterface.9(this);
  private aoxx ftDBbManager;
  private Hashtable<String, Long> headQQHeadBroadcastTable = new Hashtable();
  @Deprecated
  public boolean isCallTabShow;
  public boolean isConversationTabShow = true;
  public boolean isExitTaskUnfinished;
  private boolean isFaceSettingCached;
  public boolean isFinished;
  public boolean isInCallList;
  public boolean isKandianTabShow;
  public boolean isMSFConnect;
  public boolean isMsfPullFilterConfigInited;
  private boolean isRealSwitchToBackground;
  public volatile boolean isReleased;
  public boolean isStartSyncOnlineFriend;
  private Handler lockDetectHandler;
  private HandlerThread lockDetectThread;
  private AVNotifyCenter mAVNotifyCenter;
  public Automator mAutomator;
  private ldh mAvAddFriendService;
  private BatteryBroadcastReceiver mBatteryBroadcastReceiver;
  volatile bapk mCallFacade;
  @Deprecated
  public int mCallTabShowState = -1;
  private final aqwg mConfigProcess = new aqwg();
  private HashMap<String, Integer> mFaceDecodeFailMap;
  private atlf mFileManagerDataCenter;
  private athn mFileManagerEngine;
  private atlh mFileManagerNotifyCenter;
  private atlj mFileManagerRSCenter;
  public boolean mFirstGetSubAccountName = true;
  private aobd mGAudioHandler;
  private HotChatManager mHCMng;
  ConcurrentLinkedQueue<Intent> mHeadGetIntents = new ConcurrentLinkedQueue();
  @Deprecated
  public boolean mIsShowNewLeba;
  public anxl mLebaHelper;
  private CloudScanListener mListener;
  public long mLoginTime;
  private anzg mMsgTabUnreadListener;
  private anzh mMultiAIOUnreadListener;
  private axin mMultiMsgController;
  private NetEngineFactory mNetEngineFactory;
  private atni mOnlineFileSessionCenter;
  private volatile aopp mParcelHooker;
  private long mPreShowKickedNTs;
  private aukm mPrivacyInfoUtil;
  private blyb mQQProxyForQlink;
  public WeakReference<QQServiceForAV> mQQServiceRef;
  private blys mQlinkServiceManager;
  private aoxz mRecentUserProxy;
  public long mRegisterPushTime;
  private bdla mReportController;
  private Object mReportControllerLock = new Object();
  AtomicInteger mRunningTaskNum = new AtomicInteger(0);
  private ISecureModuleService mSecureService;
  private Intent mSecurityDetectBannerIntent;
  private ShortVideoResourceManager mShortVideoResourceMgr;
  private SigInfo mSig;
  private Object mSystemMsgInitLock = new Object();
  private avdz mTinyIdCache;
  public int mTryTimeForNear;
  public int mTryTimeForStatus;
  public volatile boolean mainActivityIsForeground;
  private Manager[] managers = new Manager[QQManagerFactory.COUNT_MANAGER];
  public anyx messageNotifiableChecker;
  anyy messageNotificationGenerator;
  private ThreadLocal<Integer> mgrCallingDepthThreadLocal = new ThreadLocal();
  private ThreadLocal<StringBuilder> mgrCallingStackThreadLocal = new ThreadLocal();
  private final Object[] mgrLockArray = new Object[QQManagerFactory.COUNT_MANAGER];
  public bcpt mqqService;
  public boolean msfPullFilterSwitch = true;
  private bcrg msgCache;
  volatile QQMessageFacade msgFacade;
  private MessageHandler msgHandler;
  private final int msgSendDisQQheadBroadcast = 993;
  private final int msgSendNewgroupQQheadBroadcast = 992;
  private final int msgSendQQheadBroadcast = 990;
  private final int msgSendTroopQQheadBroadcast = 991;
  public boolean needReuploadQfav;
  private volatile byte[] needSoundAndVibrations = new byte[2];
  QQAppInterface.MyNetInfoHandler netHandler = null;
  private PicPreDownloader picPreDownloader;
  private ProxyManager proxyManager;
  private BroadcastReceiver qqAccountReceiver = new QQAppInterface.8(this);
  private Handler qqHeadBroadcastHandler = new QQAppInterface.6(this, ThreadManager.getSubThreadLooper());
  private BroadcastReceiver qqHeadBroadcastReceiver = new QQAppInterface.5(this);
  private BroadcastReceiver qzoneBrocastReceiver = new QQAppInterface.18(this);
  protected Handler sGetOnlineFriendHandler = new QQAppInterface.15(this, Looper.getMainLooper());
  public long sLastGetOnlineFriendTime;
  private bbxu scribbleDownloader;
  private ArrayList<String> sendDisUinList = new ArrayList();
  private ArrayList<String> sendNewTroopUinList = new ArrayList();
  private ArrayList<String> sendTroopUinList = new ArrayList();
  private ArrayList<String> sendUinList = new ArrayList();
  private Hashtable<ServerConfigManager.ConfigType, HashMap<String, String>> serverConfig = new Hashtable();
  private HashMap<ServerConfigManager.ConfigType, Long> serverConfigTimeOut = new HashMap();
  private bcxj shortVideoPreDownloader;
  private QvipSpecialSoundManager soundManager;
  SharedPreferences sp = null;
  public int tagMaxNum;
  private long time = -1L;
  private TransFileController transFileController;
  List<BusinessObserver> uiObservers = new Vector();
  public Intent upgradeData;
  public int userActiveStatus;
  public List<aogp> vibrateListenerList = new ArrayList();
  aogq vibrateSoundHelper;
  
  static
  {
    if (!"Success".equals(BaseApplicationImpl.sInjectResult))
    {
      String str = "sInjectResult:" + BaseApplicationImpl.sInjectResult;
      try
      {
        throw new IllegalAccessError("QQAppInterface escapes!");
      }
      catch (Throwable localThrowable)
      {
        BaseApplicationImpl.sQQAppInterfaceEscapedMsg = str + "\n" + QLog.getStackTraceString(localThrowable);
        QLog.e("DexLoad", 1, "QQAppInterface escapes!");
      }
    }
    for (;;)
    {
      CHECK_FACE_UPDATE_PERIOD = 86400000L;
      VIBRATOR_PATTERN = new long[] { 100L, 200L, 200L, 100L };
      VIBRATOR_PATTERN_SHAKE = new long[] { 100L, 400L, 100L, 400L, 100L, 400L };
      VIBRATOR_TIME_SELECTOR = new long[] { 10L, 50L };
      curBrowserFontSizeIndex = 1;
      IMPORTANT_MANAGERS = new int[] { QQManagerFactory.PROXY_MANAGER, QQManagerFactory.CACHE_MANAGER, QQManagerFactory.MGR_MSG_FACADE, QQManagerFactory.CONVS_FACADE, QQManagerFactory.MGR_SUB_ACNT, QQManagerFactory.MGR_PLUGIN, QQManagerFactory.TROOP_GAG_MANAGER, QQManagerFactory.BEANCURD_MANAGER, QQManagerFactory.EXTEND_FRIEND_MANAGER };
      sNextGetOnlineFriendDelay = 300000;
      sGetOnlineFriendDelay = 30000;
      return;
      BaseApplicationImpl.sQQAppInterfaceEscapedMsg = "";
    }
  }
  
  public QQAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  private void addHeadGetTask(Intent paramIntent)
  {
    this.mHeadGetIntents.offer(paramIntent);
    runNext();
  }
  
  private void avGameOnEnterForeground()
  {
    ncz localncz = (ncz)getManager(QQManagerFactory.AV_GAME_MANAGER);
    if (localncz != null) {
      localncz.b();
    }
  }
  
  private void checkAndCreateFaceSettingCache()
  {
    if (this.faceSettingCache == null) {
      this.faceSettingCache = new QQLruCache(2001, 4000, 60);
    }
  }
  
  @TargetApi(23)
  private void checkBackgroundRestricWhilteList()
  {
    QLog.d("QQAppInterface", 1, "checkBackgroundRestricWhilteList ENTER " + System.currentTimeMillis());
    localObject = new int[] { 0, 0 };
    arrayOfInt1 = new int[] { 1, 3 };
    arrayOfInt2 = new int[] { 3, 7 };
    arrayOfInt3 = new int[] { 5, 14 };
    localBaseApplication = BaseApplicationImpl.getContext();
    ConnectivityManager localConnectivityManager = (ConnectivityManager)localBaseApplication.getSystemService("connectivity");
    try
    {
      bool2 = localConnectivityManager.isActiveNetworkMetered();
      int j;
      if (bool2) {
        j = -1;
      }
      try
      {
        Method localMethod = localConnectivityManager.getClass().getMethod("getRestrictBackgroundStatus", new Class[0]);
        localMethod.setAccessible(true);
        i = ((Integer)localMethod.invoke(localConnectivityManager, new Object[0])).intValue();
        j = i;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          int i;
          boolean bool1;
          localException1.printStackTrace();
          continue;
          SharedPreferences localSharedPreferences = localBaseApplication.getSharedPreferences("qq_background_restric_whitelist_cfg", 0);
          int k = localSharedPreferences.getInt("tips_index", 0);
          long l = localSharedPreferences.getLong("tips_last_time", 0L);
          if (k == 0)
          {
            localObject = localSharedPreferences.edit();
            i = k + 1;
            ((SharedPreferences.Editor)localObject).putInt("tips_index", i).putLong("tips_last_time", System.currentTimeMillis()).commit();
            bool1 = true;
          }
          else
          {
            if (k >= 0)
            {
              i = k;
              if (k <= 5) {}
            }
            else
            {
              i = 5;
            }
            if (System.currentTimeMillis() >= new int[][] { localObject, arrayOfInt1, { 2, 3 }, arrayOfInt2, { 4, 7 }, arrayOfInt3 }[i][1] * 86400000L + l)
            {
              localObject = localSharedPreferences.edit();
              i += 1;
              ((SharedPreferences.Editor)localObject).putInt("tips_index", i).putLong("tips_last_time", System.currentTimeMillis()).commit();
              bool1 = true;
              continue;
              localBaseApplication.getSharedPreferences("qq_background_restric_whitelist_cfg", 0).edit().putInt("tips_index", 0).putLong("tips_last_time", 0L).commit();
              i = -1;
              bool1 = false;
              l = 0L;
            }
            else
            {
              bool1 = false;
            }
          }
        }
      }
      switch (j)
      {
      default: 
        i = -1;
        bool1 = false;
        l = 0L;
        localObject = new StringBuilder("checkBackgroundRestricWhilteList");
        ((StringBuilder)localObject).append(" isActiveNetworkMetered=").append(bool2).append(" restrictStatus=").append(j).append(" tipsIdx=").append(i).append(" tipsTime=").append(l).append(" notice=").append(bool1);
        QLog.d("QQAppInterface", 1, ((StringBuilder)localObject).toString());
        if (bool1)
        {
          localObject = new Intent(localBaseApplication, DialogActivity.class);
          ((Intent)localObject).addFlags(268435456);
          ((Intent)localObject).addFlags(536870912);
          ((Intent)localObject).addFlags(67108864);
          ((Intent)localObject).addFlags(131072);
          ((Intent)localObject).putExtra("key_dialog_type", DialogActivity.b);
          localBaseApplication.startActivity((Intent)localObject);
        }
        QLog.d("QQAppInterface", 1, "checkBackgroundRestricWhilteList END");
        return;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQAppInterface", 2, "checkBackgroundRestricWhilteList: failed. ", localException2);
        }
        boolean bool2 = false;
      }
    }
  }
  
  private void checkDialogOnBackground()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      try
      {
        BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
        List localList = ((ActivityManager)localBaseApplication.getSystemService("activity")).getRunningTasks(1);
        if ((localList != null) && (localList.size() > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQAppInterface", 2, "checkBackgroundRestricWhilteList onRunningBackground topActivity packageName: " + ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity.getPackageName());
          }
          if (localBaseApplication.getPackageName().equals(((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity.getPackageName()))
          {
            this.isRealSwitchToBackground = false;
            return;
          }
          this.isRealSwitchToBackground = true;
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("QQAppInterface", 1, "checkBackgroundRestricWhilteList, ", localException);
      }
    }
  }
  
  private void checkGetManagerCallingDepthEnd() {}
  
  private void checkGetManagerCallingDepthForMGRNotNull(int paramInt)
  {
    if (this.mgrCallingDepthThreadLocal.get() == null) {}
    for (int i = 0;; i = ((Integer)this.mgrCallingDepthThreadLocal.get()).intValue())
    {
      if (i > 0)
      {
        StringBuilder localStringBuilder = (StringBuilder)this.mgrCallingStackThreadLocal.get();
        this.mgrCallingDepthThreadLocal.set(Integer.valueOf(i + 1));
        localStringBuilder.append(",").append(paramInt);
      }
      return;
    }
  }
  
  private void checkGetManagerCallingDepthStart(int paramInt) {}
  
  private void checkRamForAvideo()
  {
    boolean bool = mtj.e(getApp());
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "checkRamForAvideo isSelfCalling = " + bool);
    }
    if (bool) {}
    long l;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("checkRamForAvideo getAVNotifyCenter().isBeInvitingOnDoubleVideo() = ");
          getAVNotifyCenter();
          QLog.d("QQAppInterface", 2, AVNotifyCenter.d());
          QLog.d("QQAppInterface", 2, "checkRamForAvideo getAVNotifyCenter().isAvChating() = " + getAVNotifyCenter().b());
        }
        getAVNotifyCenter();
      } while ((AVNotifyCenter.d()) && (!getAVNotifyCenter().b()));
      l = DeviceInfoUtil.getSystemTotalMemory() / 1024L / 1024L;
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "checkRamForAvideo memoryTotal = " + l);
      }
    } while ((!isVideoChatting()) || (l == 0L) || (l > 2048L));
    ThreadManager.getUIHandler().post(new QQAppInterface.22(this));
  }
  
  private void checkWtSig()
  {
    if ((((WtloginManagerImpl)getManager(1)).getLocalSig(getCurrentAccountUin(), 16L) == null) && (isLogin())) {
      StatisticCollector.getInstance(this.app).collectPerformance(null, "kWtSigAllClear", true, 0L, 0L, null, null);
    }
  }
  
  private BusinessHandler createHandler(int paramInt)
  {
    BusinessHandler localBusinessHandler = BusinessHandlerFactory.createHandler(paramInt, this);
    if ((BusinessHandlerFactory.MESSAGE_HANDLER == paramInt) && ((localBusinessHandler instanceof MessageHandler))) {
      this.msgHandler = ((MessageHandler)localBusinessHandler);
    }
    return localBusinessHandler;
  }
  
  private void freePartBitmapCache()
  {
    if (BaseApplicationImpl.sImageCache != null)
    {
      int i = BaseApplicationImpl.sImageCache.size() * 3 / 4;
      BaseApplicationImpl.sImageCache.trimToSize(i);
    }
  }
  
  public static Bitmap genFaceBmpByShape(byte paramByte, Bitmap paramBitmap, String paramString, int paramInt)
  {
    if (paramBitmap == null) {
      return paramBitmap;
    }
    switch (paramByte)
    {
    case 5: 
    case 8: 
    case 2: 
    default: 
      return getRoundFaceBitmap(paramBitmap);
    case 1: 
      return getShapeRoundFaceBitmap(paramBitmap, bheg.a(paramBitmap.getWidth()), 50, 50);
    case 3: 
    case 4: 
      return getCircleFaceBitmap(paramBitmap, 50, 50);
    case 7: 
      return asmj.b(paramBitmap, paramString, paramInt);
    }
    return asmj.a(paramBitmap, paramString, paramInt);
  }
  
  public static bdmg getBatteryStats()
  {
    return bdmh.a();
  }
  
  private void getBitmapFromNet(int paramInt1, String paramString, byte paramByte, boolean paramBoolean1, int paramInt2, Bitmap paramBitmap, boolean paramBoolean2, boolean paramBoolean3, int paramInt3)
  {
    if (((paramBitmap == null) && (paramBoolean1) && (!paramBoolean3)) || (paramBoolean2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.", 2, "getFaceBitmap needUpdate, faceType=" + paramInt1 + ", uin=" + paramString + ", shape=" + paramByte);
      }
      if (!paramBoolean3) {
        break label153;
      }
    }
    label153:
    for (byte b = 1;; b = 2)
    {
      paramBitmap = (FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      switch (paramInt1)
      {
      default: 
        return;
      }
    }
    paramBitmap.getMobileQQHead(paramString, b);
    return;
    paramBitmap.getTroopHead(paramString, b);
    return;
    paramBitmap.getCustomHead(paramString, (byte)0, b);
    return;
    paramBitmap.getStrangerHead(paramString, paramInt2, (byte)1, b);
    return;
    paramBitmap.getQCallHead(paramString, paramInt2, (byte)1, b);
    return;
    paramBitmap.getApolloHead(paramString, (byte)1, b, paramInt3);
  }
  
  public static String getBuddyFaceFilePath(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    if (SystemUtil.isExistSDCard()) {
      localStringBuilder.append(AppConstants.PATH_HEAD_HD);
    }
    for (;;)
    {
      String str = MD5.toMD5(paramString);
      str = MD5.toMD5(str + paramString);
      localStringBuilder.append(MD5.toMD5(str + paramString));
      localStringBuilder.append(".png");
      return localStringBuilder.toString();
      localStringBuilder.append("/data/data/com.tencent.mobileqq/files/head/_hd/");
    }
  }
  
  public static Bitmap getCircleFaceBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return getShapeRoundFaceBitmap(paramBitmap, -1, paramInt1, paramInt2);
  }
  
  private String getCurrentProcess()
  {
    try
    {
      int i = Process.myPid();
      Object localObject = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo.pid == i)
        {
          localObject = localRunningAppProcessInfo.processName;
          return localObject;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.d("QQAppInterface", 1, "failed to get current process name");
    }
    return null;
  }
  
  public static String getCurrentThemeId()
  {
    return ThemeUtil.getCurrentThemeId();
  }
  
  @NotNull
  private Intent getDefaultIntentByUin(Context paramContext, int paramInt, String paramString)
  {
    paramContext = new Intent(paramContext, SplashActivity.class);
    paramContext.putExtra("uin", paramString);
    paramContext.putExtra("uintype", paramInt);
    paramContext = AIOUtils.setOpenAIOIntent(paramContext, new int[] { 2 });
    paramContext.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
    return paramContext;
  }
  
  @NotNull
  public static String getFaceDownKey(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    String str = paramInt1 + "_" + paramString;
    if (paramInt1 == 32) {
      str = "stranger_" + String.valueOf(paramInt2) + "_" + paramString;
    }
    do
    {
      return str;
      if (paramInt1 == 16) {
        return "qcall_" + String.valueOf(paramInt2) + "_" + paramString;
      }
    } while (paramInt1 != 116);
    return "apollo_" + String.valueOf(paramInt3) + "_" + paramString;
  }
  
  private String getFaceFilePathPrefix(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 32) {
      if (SystemUtil.isExistSDCard()) {
        localStringBuilder.append(AppConstants.PATH_HEAD_STRANGER);
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("/data/data/com.tencent.mobileqq/files/head/_stranger/");
      continue;
      if (paramInt == 116)
      {
        if (SystemUtil.isExistSDCard()) {
          localStringBuilder.append(AppConstants.PATH_HEAD_APOLLO);
        } else {
          localStringBuilder.append("/data/data/com.tencent.mobileqq/files/head/_apollo/");
        }
      }
      else if (SystemUtil.isExistSDCard()) {
        localStringBuilder.append(AppConstants.PATH_HEAD_HD);
      } else {
        localStringBuilder.append("/data/data/com.tencent.mobileqq/files/head/_hd/");
      }
    }
  }
  
  @NotNull
  public static String getFaceSettingKey(int paramInt1, String paramString, int paramInt2)
  {
    String str;
    if (paramInt1 == 4) {
      str = "troop_" + paramString;
    }
    do
    {
      return str;
      if (paramInt1 == 32) {
        return "stranger_" + String.valueOf(paramInt2) + "_" + paramString;
      }
      if (paramInt1 == 16) {
        return "qcall_" + String.valueOf(paramInt2) + "_" + paramString;
      }
      str = paramString;
    } while (paramInt1 != 116);
    return "apollo_" + String.valueOf(paramInt2) + "_" + paramString;
  }
  
  private Intent getIntentByUin(Context paramContext, QQMessageFacade.Message paramMessage, int paramInt)
  {
    Object localObject2 = paramMessage.frienduin;
    Object localObject1 = null;
    int i = paramInt;
    if (paramInt == 1026) {
      i = 1;
    }
    if (String.valueOf(AppConstants.LBS_HELLO_UIN).equals(localObject2))
    {
      localObject2 = paramContext.getString(2131698656);
      localObject1 = new Intent(paramContext, MsgBoxListActivity.class);
      paramContext = AppConstants.LBS_HELLO_UIN;
      if (!aryo.a(paramMessage, this)) {
        paramContext = AppConstants.NEARBY_LBS_HELLO_UIN;
      }
      ((Intent)localObject1).putExtra("uin", paramContext);
      ((Intent)localObject1).putExtra("uintype", 1001);
      paramContext = (Context)localObject2;
    }
    Intent localIntent1;
    for (;;)
    {
      ((Intent)localObject1).putExtra("uinname", paramContext);
      return localObject1;
      if ((String.valueOf(AppConstants.FRIEND_SYSTEM_MSG_UIN).equals(localObject2)) || (AppConstants.MAYKNOW_RECOMMEND_UIN.equals(localObject2)) || (AppConstants.FRIEND_ANNIVER_UIN.equals(localObject2)))
      {
        localObject1 = paramContext.getString(2131694274);
        localIntent1 = new Intent(paramContext, NewFriendActivity.class);
        if (AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(localObject2))
        {
          localIntent1.putExtra("from", "from_notification");
          paramInt = aizx.a(paramMessage);
          localIntent1.putExtra("fromSubType", paramInt);
          if (paramInt != 6) {
            break label241;
          }
          NewFriendActivity.a(this, "0X800A181");
        }
        for (;;)
        {
          localIntent1.putExtra("EntranceId", 1);
          paramContext = (Context)localObject1;
          localObject1 = localIntent1;
          break;
          label241:
          if ((paramInt == 9) || (paramInt == 10) || (paramInt == 1)) {
            NewFriendActivity.a(this, "0X8009CBA");
          }
        }
      }
      if (String.valueOf(AppConstants.TROOP_SYSTEM_MSG_UIN).equals(localObject2))
      {
        paramMessage = paramContext.getString(2131719141);
        localObject1 = new Intent(paramContext, TroopActivity.class);
        ((Intent)localObject1).putExtra("_key_mode", 1);
        ((Intent)localObject1).putExtra("key_tab_mode", 2);
        paramContext = paramMessage;
      }
      else if (String.valueOf(AppConstants.QQBROADCAST_MSG_UIN).equals(localObject2))
      {
        localObject1 = new Intent(paramContext, QQBroadcastActivity.class);
        paramContext = paramContext.getString(2131719140);
      }
      else if (String.valueOf(AppConstants.VOTE_MSG_UIN).equals(localObject2))
      {
        paramMessage = paramContext.getString(2131719141);
        localObject1 = new Intent(paramContext, VisitorsActivity.class);
        ((Intent)localObject1).putExtra("votersOnly", true);
        ((Intent)localObject1).putExtra("toUin", Long.valueOf(getCurrentAccountUin()));
        paramContext = paramMessage;
      }
      else if (String.valueOf(AppConstants.DATALINE_PC_UIN).equals(localObject2))
      {
        localObject1 = new Intent(paramContext, LiteActivity.class);
        ((Intent)localObject1).putExtra("targetUin", AppConstants.DATALINE_PC_UIN);
        paramContext = paramContext.getString(2131693667);
      }
      else if (String.valueOf(AppConstants.DATALINE_IPAD_UIN).equals(localObject2))
      {
        localObject1 = new Intent(paramContext, LiteActivity.class);
        ((Intent)localObject1).putExtra("targetUin", AppConstants.DATALINE_IPAD_UIN);
        paramContext = paramContext.getString(2131693668);
      }
      else
      {
        if (!String.valueOf(9973L).equals(localObject2)) {
          break;
        }
        localObject1 = new Intent(paramContext, ActivateFriendActivity.class);
        paramContext = paramContext.getString(2131689531);
        ((Intent)localObject1).setFlags(67108864);
        ((Intent)localObject1).putExtra("af_key_from", 4);
      }
    }
    if (AppConstants.KANDIAN_LOCKSCREEN_INTERACT_MSG_UIN.equals(localObject2))
    {
      localObject2 = BaseApplicationImpl.getContext().getString(2131694997);
      if (bmhv.n()) {}
      for (localObject1 = osg.a(paramContext, 19);; localObject1 = new Intent(paramContext, ReadInJoyNewFeedsActivity.class))
      {
        paramContext = "";
        try
        {
          paramMessage = new JSONObject(paramMessage.extStr).optString("msg_id");
          paramContext = paramMessage;
        }
        catch (JSONException paramMessage)
        {
          for (;;)
          {
            QLog.i("QQAppInterface", 1, "getIntentByUin, get readinjoy messageId exception, e=" + paramMessage.toString());
          }
        }
        ((Intent)localObject1).putExtra("notification_message_id", paramContext);
        ((Intent)localObject1).putExtra("uintype", 7225);
        paramContext = (Context)localObject2;
        break;
      }
    }
    if (i == 7000)
    {
      paramMessage = paramContext.getString(2131719045);
      localObject1 = new Intent(paramContext, AssociatedAccountActivity.class);
      ((Intent)localObject1).putExtra("subAccount", (String)localObject2);
      paramContext = (bdxs)getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
      if (paramContext == null) {
        break label2015;
      }
    }
    label1346:
    label1620:
    label2009:
    label2015:
    for (paramContext = paramContext.b((String)localObject2);; paramContext = (Context)localObject2)
    {
      ((Intent)localObject1).putExtra("subAccountLatestNick", paramContext);
      ((Intent)localObject1).putExtra("finishAIO", true);
      ((Intent)localObject1).putExtra("uin", (String)localObject2);
      ((Intent)localObject1).putExtra("uintype", i);
      paramContext = paramMessage;
      break;
      if ((i == 1001) || (i == 1010))
      {
        localObject2 = paramContext.getString(2131698656);
        localObject1 = new Intent(paramContext, MsgBoxListActivity.class);
        paramContext = AppConstants.LBS_HELLO_UIN;
        if (!aryo.a(paramMessage, this)) {
          paramContext = AppConstants.NEARBY_LBS_HELLO_UIN;
        }
        ((Intent)localObject1).putExtra("uin", paramContext);
        ((Intent)localObject1).putExtra("uintype", i);
        paramContext = (Context)localObject2;
        break;
      }
      if (i == 1032)
      {
        paramMessage = paramContext.getString(2131698360);
        localObject1 = new Intent(paramContext, PublicFragmentActivity.class);
        ((Intent)localObject1).putExtra("uintype", 1032);
        ((Intent)localObject1).putExtra("uin", AppConstants.CONFESS_UIN);
        ((Intent)localObject1).putExtra("public_fragment_class", ConfessMsgListFragment.class.getName());
        ((Intent)localObject1).addFlags(335544320);
        paramContext = paramMessage;
        break;
      }
      if (i == 1037)
      {
        localObject1 = new Intent("android.intent.action.MAIN");
        ((Intent)localObject1).addCategory("android.intent.category.LAUNCHER");
        ((Intent)localObject1).putExtra("uintype", 1037);
        paramMessage = (asqt)getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
        if ((paramMessage != null) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(paramMessage.a())) && (!TextUtils.isEmpty(paramMessage.a))) {}
        for (paramMessage = paramMessage.a;; paramMessage = anvx.a(2131709576))
        {
          ((Intent)localObject1).setClass(paramContext, SplashActivity.class);
          ((Intent)localObject1).addFlags(268435456);
          paramContext = paramMessage;
          break;
        }
      }
      if ((i == 1044) || (i == 1045))
      {
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
        for (localObject1 = ContactUtils.getBuddyName(this, (String)localObject2, false);; localObject1 = anvx.a(2131709576))
        {
          localObject2 = awui.a(paramContext);
          ((Intent)localObject2).putExtra("key_matchchat_from_notification", true);
          ((Intent)localObject2).putExtra("key_matchchat_from_notification_uin", paramMessage.frienduin);
          ((Intent)localObject2).putExtra("key_matchchat_from_notification_type", i);
          paramContext = (Context)localObject1;
          localObject1 = localObject2;
          break;
        }
      }
      if (AppConstants.KANDIAN_DAILY_UIN.equals(localObject2))
      {
        paramMessage = BaseApplicationImpl.getContext().getString(2131694997);
        localObject1 = ReadInJoyLockScreenJumpDelegate.a(paramContext, 6, ((KandianDailyManager)getManager(QQManagerFactory.KANDIAN_DAILY_MANAGER)).a());
        ((Intent)localObject1).putExtra("uin", (String)localObject2);
        ((Intent)localObject1).putExtra("uintype", i);
        paramContext = paramMessage;
        break;
      }
      if (i == 10007)
      {
        localObject1 = avdu.a(paramContext, paramMessage, this);
        paramContext = (Context)localObject2;
        break;
      }
      if (i == 7220)
      {
        localObject2 = usu.c(this, paramContext);
        paramInt = 6;
        paramMessage = (KandianMergeManager)getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
        if (paramMessage != null)
        {
          paramMessage = paramMessage.b();
          if (!pkh.a(paramMessage)) {
            paramInt = 5;
          }
          if (!bmhv.n()) {
            break label1415;
          }
        }
        for (localObject1 = osg.a(paramContext, paramInt);; localObject1 = paramContext)
        {
          ((Intent)localObject1).putExtra("uin", AppConstants.KANDIAN_MERGE_UIN);
          ((Intent)localObject1).putExtra("uintype", i);
          if (paramInt != 6) {
            break label2009;
          }
          paramContext = BaseApplicationImpl.getContext().getString(2131694997);
          break;
          paramMessage = null;
          break label1346;
          paramContext = osg.b(paramContext, paramInt);
          if (!bmhv.a(this)) {
            break label1465;
          }
          paramContext.putExtra("readinjoy_show_tab", 0);
          paramContext.putExtra("tab_tab_index", 0);
          paramContext.putExtra("launch_from", paramInt);
          pkj.a(paramContext);
        }
        localObject1 = new ArrayList();
        paramMessage = ((KandianMergeManager)getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b();
        if ((paramMessage != null) && ((paramMessage instanceof MessageForStructing)) && (paramMessage.extInt == 1))
        {
          paramMessage = (MessageForStructing)paramMessage;
          if (paramMessage.structingMsg == null) {
            paramMessage.parse();
          }
          if ((paramMessage.structingMsg != null) && (!TextUtils.isEmpty(paramMessage.structingMsg.mArticleIds)))
          {
            paramMessage = paramMessage.structingMsg.mArticleIds.split("\\|");
            int k = paramMessage.length;
            int j = 0;
            for (;;)
            {
              if (j < k)
              {
                localIntent1 = paramMessage[j];
                try
                {
                  ((ArrayList)localObject1).add(Long.valueOf(Long.parseLong(localIntent1)));
                  j += 1;
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    localException.printStackTrace();
                  }
                }
              }
            }
          }
        }
        if (((ArrayList)localObject1).isEmpty())
        {
          paramMessage = null;
          paramContext.putExtra("subscription_all_article_id", paramMessage);
          if (!((ArrayList)localObject1).isEmpty()) {
            break label1673;
          }
        }
        for (long l = -1L;; l = ((Long)((ArrayList)localObject1).get(0)).longValue())
        {
          paramContext.putExtra("subscription_click_article_id", l);
          paramContext.putExtra("launch_from", paramInt);
          localObject1 = paramContext;
          break;
          paramMessage = (QQMessageFacade.Message)localObject1;
          break label1620;
        }
      }
      Intent localIntent2;
      if (i == 0)
      {
        localIntent2 = getDefaultIntentByUin(paramContext, i, (String)localObject2);
        localObject2 = ContactUtils.getNickName(this, (String)localObject2, i);
        localObject1 = localIntent2;
        paramContext = (Context)localObject2;
        if (paramMessage.msgtype != -5008) {
          break;
        }
        awfq.a(this, paramMessage, localIntent2);
        localObject1 = localIntent2;
        paramContext = (Context)localObject2;
        break;
      }
      if (i == 1)
      {
        localIntent2 = getDefaultIntentByUin(paramContext, i, (String)localObject2);
        localObject2 = ContactUtils.getNickName(this, (String)localObject2, i);
        localObject1 = localIntent2;
        paramContext = (Context)localObject2;
        if (paramMessage.msgtype != -5008) {
          break;
        }
        awfq.a(this, paramMessage, localIntent2);
        localObject1 = localIntent2;
        paramContext = (Context)localObject2;
        break;
      }
      if (paramMessage.msgtype == -5008) {
        localObject1 = nqf.a(this, paramMessage);
      }
      paramMessage = (QQMessageFacade.Message)localObject1;
      if (localObject1 == null)
      {
        localObject1 = getDefaultIntentByUin(paramContext, i, (String)localObject2);
        paramMessage = (QQMessageFacade.Message)localObject1;
        if (i == 1024)
        {
          ((Intent)localObject1).putExtra("chat_subType", 1);
          paramMessage = (QQMessageFacade.Message)localObject1;
        }
      }
      if (i == 1009)
      {
        paramContext = paramContext.getString(2131718143);
        localObject1 = paramMessage;
        break;
      }
      if (String.valueOf(1787740092L).equals(localObject2))
      {
        paramContext = paramContext.getString(2131690114);
        localObject1 = paramMessage;
        break;
      }
      if (i == 1024)
      {
        paramContext = ContactUtils.getNickName(this, (String)localObject2, i);
        localObject1 = paramMessage;
        break;
      }
      if (i == 9501)
      {
        localObject1 = ((abgm)getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong((String)localObject2));
        paramContext = (Context)localObject2;
        if (localObject1 != null) {
          paramContext = absz.a((DeviceInfo)localObject1);
        }
        localObject1 = paramMessage;
        break;
      }
      paramContext = ContactUtils.getNickName(this, (String)localObject2, i);
      localObject1 = paramMessage;
      break;
      paramContext = (Context)localObject2;
      break;
    }
  }
  
  private Intent getIntentForTroopStranger(Context paramContext, QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    paramContext = new Intent(paramContext, SplashActivity.class);
    paramContext.putExtra("uin", paramMessage.frienduin);
    paramContext.putExtra("troop_uin", paramMessage.senderuin);
    paramContext.putExtra("uintype", paramMessage.istroop);
    paramContext.putExtra("uinname", getTroopDisscussMemberNick(paramMessage, paramBoolean));
    paramContext = AIOUtils.setOpenAIOIntent(paramContext, new int[] { 2 });
    paramContext.setAction("com.tencent.mobileqq.action.CHAT");
    return paramContext;
  }
  
  private void getManagerCompatibleWithOldLogic(int paramInt, Manager paramManager)
  {
    if (paramInt == QQManagerFactory.PROXY_MANAGER) {
      this.proxyManager = ((ProxyManager)paramManager);
    }
    do
    {
      return;
      if (paramInt == QQManagerFactory.CACHE_MANAGER)
      {
        this.cacheManager = ((aohg)paramManager);
        return;
      }
      if (paramInt == QQManagerFactory.MGR_MSG_FACADE)
      {
        this.msgFacade = ((QQMessageFacade)paramManager);
        onCreateQQMessageFacade(this.msgFacade);
        return;
      }
      if (paramInt == QQManagerFactory.MGR_NET_ENGINE)
      {
        this.mNetEngineFactory = ((NetEngineFactory)paramManager);
        return;
      }
      if (paramInt == QQManagerFactory.CONVS_FACADE)
      {
        this.convsFacade = ((acmw)paramManager);
        return;
      }
      if (paramInt == QQManagerFactory.HOT_CHAT_MANAGER)
      {
        this.mHCMng = ((HotChatManager)paramManager);
        return;
      }
    } while (paramInt != QQManagerFactory.FTSDB_MANAGER);
    this.ftDBbManager = ((aoxx)paramManager);
  }
  
  public static boolean getMsfPullFilterSwitch(QQAppInterface paramQQAppInterface)
  {
    if (!paramQQAppInterface.isMsfPullFilterConfigInited)
    {
      String str = paramQQAppInterface.getAccount();
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      if (localSharedPreferences.contains(str + "_" + "long_text_msg_config_version")) {
        paramQQAppInterface.msfPullFilterSwitch = localSharedPreferences.getBoolean(str + "_msfpull_filter_switch", true);
      }
    }
    paramQQAppInterface.isMsfPullFilterConfigInited = true;
    return paramQQAppInterface.msfPullFilterSwitch;
  }
  
  private Object[] getNewFaceTypeBySetting(Setting paramSetting, String paramString, int paramInt)
  {
    String str = paramString;
    int i = paramInt;
    if (paramSetting != null)
    {
      str = paramString;
      i = paramInt;
      if (paramInt != 101)
      {
        str = paramString;
        i = paramInt;
        if (paramInt != 1001)
        {
          str = paramString;
          i = paramInt;
          if (paramInt != 116)
          {
            str = paramString;
            i = paramInt;
            if (paramString != null)
            {
              str = paramString;
              i = paramInt;
              if (paramSetting.bHeadType == 0)
              {
                str = String.valueOf(paramSetting.systemHeadID);
                if (paramInt != 4) {
                  break label106;
                }
                i = -56;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      return new Object[] { Integer.valueOf(i), str };
      label106:
      if (paramInt == 16) {
        i = 16;
      } else {
        i = -55;
      }
    }
  }
  
  private SharedPreferences getPref()
  {
    if (this.sp == null) {
      this.sp = PreferenceManager.getDefaultSharedPreferences(getApp());
    }
    return this.sp;
  }
  
  public static Bitmap getRoundFaceBitmap(Bitmap paramBitmap)
  {
    return bheg.c(paramBitmap, 50, 50);
  }
  
  private SQLiteOpenHelper getSQLiteOpenHelper()
  {
    if (!getCurrentAccountUin().equals("0")) {
      return getEntityManagerFactory().build(getCurrentAccountUin());
    }
    return null;
  }
  
  private SQLiteOpenHelper getSQLiteOpenHelper(String paramString)
  {
    return getEntityManagerFactory(paramString).build(paramString);
  }
  
  public static Bitmap getShapeRoundFaceBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    float f = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
    int i = paramBitmap.getWidth();
    if ((i > 0) && (i < paramInt2 * f)) {
      f = i / paramInt2;
    }
    for (;;)
    {
      paramInt2 = (int)(paramInt2 * f);
      paramInt3 = (int)(f * paramInt3);
      if (paramInt1 > 0) {}
      for (boolean bool = true;; bool = false)
      {
        if (!bool) {
          paramInt1 = paramInt2;
        }
        return bheg.a(paramBitmap, paramInt1, bool, paramInt2, paramInt3);
      }
    }
  }
  
  private String getTroopDisscussMemberNick(QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    Object localObject2;
    if ((paramMessage.istroop == 1000) || (paramMessage.istroop == 1020))
    {
      localObject1 = ContactUtils.getTroopMemberNickByTroopCode(this, paramMessage.frienduin, paramMessage.senderuin);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (!((String)localObject1).equals(paramMessage.frienduin)) {}
      }
      else
      {
        localObject2 = ((anvk)getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramMessage.frienduin);
        if (localObject2 != null) {
          if (TextUtils.isEmpty(((Friends)localObject2).remark)) {
            break label246;
          }
        }
      }
    }
    label246:
    for (Object localObject1 = ((Friends)localObject2).remark;; localObject1 = ((Friends)localObject2).name)
    {
      localObject2 = localObject1;
      if (paramBoolean) {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = localObject1;
          if (!((String)localObject1).equals(paramMessage.frienduin)) {}
        }
        else
        {
          localObject2 = localObject1;
          if (!this.friendInfoQueue.contains(paramMessage.frienduin))
          {
            this.friendInfoQueue.add(paramMessage.frienduin);
            localObject2 = (FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
            addObserver(this.friendListObserver);
            if (QLog.isColorLevel()) {
              QLog.d("QQAppInterface_friendListObserver", 2, "addObserver");
            }
            ((FriendListHandler)localObject2).getFriendInfo(paramMessage.frienduin);
            localObject2 = localObject1;
          }
        }
      }
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!"".equals(localObject2)) {}
      }
      else
      {
        localObject1 = paramMessage.frienduin;
      }
      return localObject1;
      localObject1 = ContactUtils.getDiscussionMemberShowName(this, paramMessage.senderuin, paramMessage.frienduin);
      break;
    }
  }
  
  private ArrayList<String> getTroopUinList(Cursor paramCursor)
  {
    ArrayList localArrayList = null;
    Object localObject = localArrayList;
    if (paramCursor != null)
    {
      localObject = localArrayList;
      if (paramCursor.getCount() > 0)
      {
        int i = paramCursor.getColumnIndex("troopuin");
        localArrayList = new ArrayList();
        for (;;)
        {
          localObject = localArrayList;
          if (!paramCursor.moveToNext()) {
            break;
          }
          localObject = paramCursor.getString(i);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
    }
    return localObject;
  }
  
  /* Error */
  private String getVersionName()
  {
    // Byte code:
    //   0: ldc_w 1822
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 634	com/tencent/mobileqq/app/QQAppInterface:app	Lcom/tencent/common/app/BaseApplicationImpl;
    //   9: invokevirtual 1826	com/tencent/common/app/BaseApplicationImpl:getPackageManager	()Landroid/content/pm/PackageManager;
    //   12: astore_3
    //   13: aload 4
    //   15: astore_2
    //   16: aload_3
    //   17: aload_0
    //   18: getfield 634	com/tencent/mobileqq/app/QQAppInterface:app	Lcom/tencent/common/app/BaseApplicationImpl;
    //   21: invokevirtual 1827	com/tencent/common/app/BaseApplicationImpl:getPackageName	()Ljava/lang/String;
    //   24: iconst_0
    //   25: invokevirtual 1833	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   28: astore 5
    //   30: aload 4
    //   32: astore_3
    //   33: aload 5
    //   35: ifnull +99 -> 134
    //   38: aload 4
    //   40: astore_2
    //   41: aload 4
    //   43: astore_3
    //   44: aload 5
    //   46: getfield 1838	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   49: ifnull +85 -> 134
    //   52: aload 4
    //   54: astore_2
    //   55: aload 5
    //   57: getfield 1838	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   60: astore 4
    //   62: aload 4
    //   64: astore_3
    //   65: aload 4
    //   67: ifnull +67 -> 134
    //   70: aload 4
    //   72: astore_2
    //   73: aload 4
    //   75: ldc_w 1840
    //   78: invokevirtual 1559	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   81: astore 5
    //   83: iconst_3
    //   84: istore_1
    //   85: aload 4
    //   87: astore_2
    //   88: aload 4
    //   90: astore_3
    //   91: iload_1
    //   92: aload 5
    //   94: arraylength
    //   95: if_icmple +39 -> 134
    //   98: aload 4
    //   100: astore_2
    //   101: new 339	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   108: aload 4
    //   110: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 1842
    //   116: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 352	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: astore 4
    //   124: iload_1
    //   125: iconst_1
    //   126: isub
    //   127: istore_1
    //   128: goto -43 -> 85
    //   131: astore_3
    //   132: aload_2
    //   133: astore_3
    //   134: aload_3
    //   135: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	QQAppInterface
    //   84	44	1	i	int
    //   15	118	2	str1	String
    //   12	79	3	localObject1	Object
    //   131	1	3	localException	Exception
    //   133	2	3	localObject2	Object
    //   3	120	4	str2	String
    //   28	65	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   16	30	131	java/lang/Exception
    //   44	52	131	java/lang/Exception
    //   55	62	131	java/lang/Exception
    //   73	83	131	java/lang/Exception
    //   91	98	131	java/lang/Exception
    //   101	124	131	java/lang/Exception
  }
  
  private void headQQHeadBroadcast(Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getExtras() == null)) {}
    long l1;
    ArrayList localArrayList;
    label169:
    label206:
    label211:
    long l2;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      int k = paramIntent.getExtras().getInt("faceType", 1);
      Object localObject2 = paramIntent.getExtras().getStringArrayList("uinList");
      paramIntent = new ArrayList();
      ??? = new ArrayList();
      localArrayList = new ArrayList();
      if (QLog.isColorLevel()) {
        bhgy.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, receive uinList: ", (ArrayList)localObject2);
      }
      int i;
      String str;
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        i = 0;
        if (i < ((ArrayList)localObject2).size())
        {
          str = (String)((ArrayList)localObject2).get(i);
          int j;
          if ((str != null) && (str.length() > 0))
          {
            Object localObject3 = new File(getCustomFaceFilePath(k, str, 0));
            if ((!((File)localObject3).exists()) || (!((File)localObject3).isFile())) {
              break label206;
            }
            j = 1;
            if (j == 0) {
              break label211;
            }
            localObject3 = getCustomFaceFilePath(k, str, 0);
            paramIntent.add(str);
            ((ArrayList)???).add(localObject3);
          }
          for (;;)
          {
            i += 1;
            break;
            j = 0;
            break label169;
            localArrayList.add(str);
          }
        }
      }
      try
      {
        if (paramIntent.size() > 0)
        {
          localObject2 = new Intent("com.tencent.qqhead.getheadresp");
          ((Intent)localObject2).putExtra("faceType", k);
          ((Intent)localObject2).putStringArrayListExtra("uinList", paramIntent);
          ((Intent)localObject2).putStringArrayListExtra("headPathList", (ArrayList)???);
          getApp().sendBroadcast((Intent)localObject2, "com.tencent.qqhead.permission.getheadresp");
        }
        if (localArrayList.size() > 0)
        {
          l2 = System.currentTimeMillis();
          localObject2 = (FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
          i = 0;
          if (i < localArrayList.size())
          {
            str = (String)localArrayList.get(i);
            if (k == 1) {
              ((FriendListHandler)localObject2).getCustomHead(str, (byte)0, (byte)2);
            }
          }
        }
      }
      catch (Exception localException)
      {
        synchronized (this.headQQHeadBroadcastTable)
        {
          do
          {
            for (;;)
            {
              this.headQQHeadBroadcastTable.put(str, Long.valueOf(l2));
              i += 1;
              continue;
              localException = localException;
              QLog.e("Q.qqhead.broadcast", 2, "headQQHeadBroadcast error", localException);
              continue;
              if (k == 4)
              {
                ((FriendListHandler)localObject2).getTroopHead(str);
              }
              else
              {
                if (k != 113) {
                  break;
                }
                ((aoep)getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).g(str, true);
              }
            }
          } while (k != 101);
          ((antl)getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(str, true);
        }
      }
      l2 = System.currentTimeMillis();
    } while (!QLog.isColorLevel());
    bhgy.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, response uinList: ", paramIntent);
    bhgy.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, getQQHead uinList: ", localArrayList);
    QLog.i("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, cost=" + (l2 - l1));
  }
  
  private void initAbout()
  {
    if (this.aboutConfig == null)
    {
      this.aboutConfig = new aqwe(this);
      this.aboutConfig.a();
    }
  }
  
  @Deprecated
  private void initCallTabShowState()
  {
    if (this.mCallTabShowState != -1) {}
    String str;
    do
    {
      return;
      str = SettingCloneUtil.readValue(getApplication(), getCurrentAccountUin(), null, "qqsetting_calltab_show_key", "0111100");
      if ((str != null) && (str.length() <= "0111100".length())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QQAppInterface", 2, "isCallTabShow fullVal is null");
    return;
    Object localObject = str;
    if (str.length() < "0111100".length()) {
      localObject = str + "0111100".substring(str.length());
    }
    int i = localObject.toCharArray()[6];
    localObject = new StringBuilder((String)localObject);
    if (48 != i) {
      ((StringBuilder)localObject).setCharAt(6, '0');
    }
    for (i = 1;; i = 0)
    {
      this.mCallTabShowState = 0;
      this.isCallTabShow = false;
      if (i == 0) {
        break;
      }
      ThreadManager.post(new QQAppInterface.20(this, (StringBuilder)localObject), 8, null, false);
      return;
    }
  }
  
  public static void initHeadCfg()
  {
    int k = 0;
    j = 0;
    i = k;
    try
    {
      Object localObject = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.headCfg.name(), "24|3500|1|0");
      i = k;
      if (QLog.isColorLevel())
      {
        i = k;
        QLog.i("QQAppInterface", 2, "initHeadCfg, " + (String)localObject);
      }
      i = k;
      localObject = ((String)localObject).split("\\|");
      i = k;
      if (localObject.length > 0)
      {
        i = k;
        k = Integer.parseInt(localObject[0]);
        j = k;
        if (k >= 1)
        {
          j = k;
          if (k <= 168)
          {
            i = k;
            CHECK_FACE_UPDATE_PERIOD = k * 60 * 60 * 1000;
            j = k;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        CHECK_FACE_UPDATE_PERIOD = 86400000L;
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.e("QQAppInterface", 2, "initHeadCfg error", localException);
          j = i;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQAppInterface", 2, "initHeadCfg," + j + "," + CHECK_FACE_UPDATE_PERIOD);
    }
  }
  
  private boolean isGetFaceBitmapParamInValid(int paramInt, String paramString)
  {
    return ((paramInt == 11) && (!StringUtil.isValidMobileNumForHead(paramString))) || (TextUtils.isEmpty(paramString));
  }
  
  private boolean isSpecialFaceType(int paramInt, String paramString)
  {
    return (paramInt == 1) && (paramString != null) && ((paramString.equals(AppConstants.QQBROADCAST_MSG_UIN)) || (paramString.equals(AppConstants.LBS_HELLO_UIN)) || (paramString.equals(AppConstants.VOTE_MSG_UIN)) || (paramString.equals(AppConstants.SYSTEM_MSG_UIN)));
  }
  
  private boolean isTimeIntervalLimited(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    boolean bool = true;
    unitTestLog("vibratorAndAudio_check_time_start", new Object[0]);
    if (this.time == -1L)
    {
      unitTestLog("vibratorAndAudio_check_time_not_valid", new Object[0]);
      this.time = System.currentTimeMillis();
      unitTestLog("vibratorAndAudio_check_time_end", new Object[0]);
      bool = false;
    }
    label112:
    do
    {
      do
      {
        do
        {
          return bool;
          if (Math.abs(System.currentTimeMillis() - this.time) > 2000L) {
            break;
          }
          unitTestLog("vibratorAndAudio_check_time_in_time_space", new Object[0]);
          if (paramMessageRecord != null) {
            break label112;
          }
        } while (!QLog.isColorLevel());
        QLog.e("SpecialCare", 2, "message = null");
        return true;
        if (paramMessageRecord.msgtype == -2020) {
          break label140;
        }
      } while (!QLog.isColorLevel());
      QLog.e("SpecialCare", 2, "message.msgtype != MessageRecord.MSG_TYPE_SHAKE_WINDOW");
      return true;
      if ((paramBoolean) && (getOnlineStauts() == 11L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    label140:
    QLog.e("SpecialCare", 2, "isOnline = " + paramBoolean + " getOnlineStatus = " + getOnlineStauts());
    return true;
  }
  
  private void notifyMessageReceived(QQMessageFacade.Message paramMessage, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "notifyMessageReceived: entryA message.frienduin=" + paramMessage.frienduin + ", message.senderuin=" + paramMessage.senderuin + ", needSoundVibrationsTip " + paramBoolean1 + " , isOnline " + paramBoolean2);
    }
    if (!((bkyu)getBusinessHandler(BusinessHandlerFactory.NOTIFICATION_CONTROLLER_HANDLER)).a(paramMessage.frienduin, paramMessage.istroop)) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        if (!isShowMsgContent()) {
          break label132;
        }
        showMessageNotificationWithPreview(paramMessage, true);
      }
      for (;;)
      {
        if (aogq.a(this.userActiveStatus, paramMessage, paramBoolean1)) {
          vibratorAndAudioForMsg(paramMessage, paramBoolean2);
        }
        return;
        label132:
        showMessageNotificationNoPreview(paramMessage, true);
      }
    }
  }
  
  private void onLineStatusOnAppForeground()
  {
    azbv localazbv = (azbv)getManager(QQManagerFactory.ONLINE_STATUS_MANAGER);
    if (localazbv != null) {
      localazbv.a().c("QQAppInterface");
    }
  }
  
  private void onRunningBackgroundDoReportForReadInJoy()
  {
    if (tlx.a())
    {
      tlx.a().a();
      tlx.a().b();
      tlx.a().a(1);
    }
  }
  
  private Bitmap putSdcardBitmapToCache(int paramInt1, String paramString1, byte paramByte, String paramString2, Bitmap paramBitmap, String paramString3, bgyp parambgyp, int paramInt2)
  {
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap != null)
    {
      paramBitmap = genFaceBmpByShape(paramByte, paramBitmap, paramString1, paramInt2);
      if (paramBitmap == null) {
        break label130;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.", 2, "getFaceBitmap decode success, faceType=" + paramInt1 + ", uin=" + paramString1 + ", shape=" + paramByte + ", headType=" + paramInt2 + ", path=" + paramString3 + ", bmp=" + paramBitmap);
      }
      putBitmapToCache(paramString2, paramBitmap, aoke.a(paramInt1));
      localBitmap = paramBitmap;
    }
    label130:
    do
    {
      do
      {
        return localBitmap;
        localBitmap = paramBitmap;
      } while (!QLog.isColorLevel());
      localBitmap = paramBitmap;
    } while (parambgyp.jdField_a_of_type_Int != 0);
    QLog.i("Q.qqhead.qaif", 2, "getFaceBitmap decode shape fail, faceType=" + paramInt1 + ", uin=" + paramString1 + ", shape=" + paramByte + ", headType=" + paramInt2);
    return paramBitmap;
  }
  
  private void putTroopTable(int paramInt, HashMap<Integer, String[]> paramHashMap, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3)
  {
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0) && ((paramInt == -1) || (paramInt == 1))) {
      paramHashMap.put(Integer.valueOf(1), (String[])paramArrayList1.toArray(new String[paramArrayList1.size()]));
    }
    if ((paramArrayList2 != null) && (paramArrayList2.size() > 0) && ((paramInt == -1) || (paramInt == 2))) {
      paramHashMap.put(Integer.valueOf(2), (String[])paramArrayList2.toArray(new String[paramArrayList2.size()]));
    }
    if ((paramArrayList3 != null) && (paramArrayList3.size() > 0) && ((paramInt == -1) || (paramInt == 4))) {
      paramHashMap.put(Integer.valueOf(4), (String[])paramArrayList3.toArray(new String[paramArrayList3.size()]));
    }
  }
  
  private Bitmap realGetFaceBitmap(int paramInt1, String paramString, byte paramByte1, int paramInt2, boolean paramBoolean, byte paramByte2, int paramInt3)
  {
    String str1 = getFaceBitmapCacheKey(paramInt1, paramString, paramByte1, paramInt3, paramInt2, false);
    Object localObject1 = getBitmapFromCache(str1);
    paramByte2 = 0;
    boolean bool1;
    String str2;
    bgyp localbgyp;
    boolean bool2;
    label202:
    Bitmap localBitmap;
    if (localObject1 == null) {
      if ((paramBoolean) || (paramInt1 == 116))
      {
        localObject1 = getQQHeadSetting(paramInt1, paramString, paramInt3);
        bool1 = ((Boolean)((Pair)localObject1).first).booleanValue();
        if (((Pair)localObject1).second != null)
        {
          paramByte2 = ((Setting)((Pair)localObject1).second).bHeadType;
          str2 = getCustomFaceFilePath(paramInt1, paramString, paramInt3, paramInt2);
          localbgyp = decodeFace(str2);
          if (localbgyp.jdField_a_of_type_Int != 0) {
            QLog.i("Q.qqhead.qaif", 2, "getFaceBitmap decodeFile fail, faceType=" + paramInt1 + ", uin=" + paramString + ", result=" + localbgyp.jdField_a_of_type_Int + ", facePath=" + str2);
          }
          if ((!bool1) && (localbgyp.jdField_a_of_type_Int == 1)) {
            return null;
          }
          if (localbgyp.jdField_a_of_type_Int != 2)
          {
            bool2 = true;
            localBitmap = localbgyp.jdField_a_of_type_AndroidGraphicsBitmap;
            if ((localBitmap == null) && (localbgyp.jdField_a_of_type_Int != 1) && (bool2))
            {
              if (paramInt1 != 4) {
                break label479;
              }
              localObject1 = "troop_" + paramString;
            }
          }
        }
      }
    }
    for (;;)
    {
      synchronized (this.faceDecodeFailMapLock)
      {
        if (this.mFaceDecodeFailMap == null) {
          this.mFaceDecodeFailMap = new HashMap();
        }
        Integer localInteger = (Integer)this.mFaceDecodeFailMap.get(localObject1);
        if (localInteger == null)
        {
          i = 0;
          QLog.i("Q.qqhead.qaif", 1, "getFaceBitmap|file is damaged, key = " + (String)localObject1 + ", nDecodeFailCount = " + i);
          if (i < 3)
          {
            i += 1;
            this.mFaceDecodeFailMap.put(localObject1, Integer.valueOf(i));
            FileUtils.deleteFile(str2);
            QLog.i("Q.qqhead.qaif", 1, "getFaceBitmap|file is damaged, key = " + (String)localObject1 + ", del the damaged file,nDecodeFailCount=" + i);
          }
          localObject1 = putSdcardBitmapToCache(paramInt1, paramString, paramByte1, str1, localBitmap, str2, localbgyp, paramByte2);
          getBitmapFromNet(paramInt1, paramString, paramByte1, paramBoolean, paramInt3, (Bitmap)localObject1, bool1, bool2, paramInt2);
          return localObject1;
          bool2 = false;
          break label202;
        }
        int i = localInteger.intValue();
      }
      label479:
      localObject1 = paramString;
      continue;
      break;
      bool1 = false;
      break;
      bool2 = false;
      bool1 = false;
    }
  }
  
  private void registerAccountReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.EXIT_" + BaseApplicationImpl.getApplication().getPackageName());
    localIntentFilter.addAction("com.tencent.mobileqq.kickedLogin.otherDevice");
    this.app.registerReceiver(this.qqAccountReceiver, localIntentFilter);
  }
  
  private void release()
  {
    if (this.isReleased) {
      return;
    }
    QLog.d("QQAppInterface", 1, "release");
    this.isReleased = true;
    bhkf.jdField_a_of_type_Boolean = false;
    if (GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager != null) {
      GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(false, BaseApplicationImpl.processName);
    }
    asbi.b();
    synchronized (this.uiObservers)
    {
      this.uiObservers.clear();
      synchronized (this.bgObservers)
      {
        this.bgObservers.clear();
        synchronized (this.defaultObservers)
        {
          this.defaultObservers.clear();
          this.mAutomator.onDestroy();
          HeavyTaskExecutor.a(new QQAppInterface.11(this));
        }
      }
    }
    synchronized (this.allHandler)
    {
      BusinessHandler[] arrayOfBusinessHandler = this.allHandler;
      int j = arrayOfBusinessHandler.length;
      int i = 0;
      while (i < j)
      {
        BusinessHandler localBusinessHandler = arrayOfBusinessHandler[i];
        if (localBusinessHandler != null) {
          localBusinessHandler.onDestroy();
        }
        i += 1;
        continue;
        localObject2 = finally;
        throw localObject2;
        localObject3 = finally;
        throw localObject3;
        localObject4 = finally;
        throw localObject4;
      }
      if (this.mListener != null) {
        getSecureModuleService().unregisterCloudScanListener(this.app.getBaseContext(), this.mListener);
      }
      VideoBroadcastReceiver.a();
      alht.a();
      FaceDecodeTask.closeFaceDecodeThread();
      this.qqHeadBroadcastHandler.removeCallbacksAndMessages(null);
      if (this.mFileManagerEngine != null) {
        this.mFileManagerEngine.d();
      }
      if (this.mRecentUserProxy != null) {
        this.mRecentUserProxy.b();
      }
      if (this.mTinyIdCache != null) {
        this.mTinyIdCache.a();
      }
      bmrn.b();
      TdsReaderGlobal.b();
      SosoInterface.onDestroy();
      LbsManagerService.onDestroy();
      asli.a();
      PluginManageHandler.getInstance().setPluginManagerProvider(null, false);
      SessionInfo.clearOldSession();
      uuc.b();
      usu.a(getCurrentUin());
      oli.a().a();
      QQIndividualityPluginProxyService.a();
      bbzh.jdField_a_of_type_Boolean = false;
      wyw.a().a(BaseApplication.getContext());
      apgm.a();
      aiyq.a();
      aomr.a().c();
      HeavyTaskExecutor.a(new QQAppInterface.12(this));
      bfoh.a().b();
      bfmz.a().b();
      bfny.a().b();
      bgkc.a(this);
      QWalletHelper.release();
      QWalletHelper.clearInstance(this);
      bmqk.b();
      atrv.a().a();
      avxi.a();
      QCircleInvokeProxy.invoke(2, 2, new Object[0]);
      return;
    }
  }
  
  private void runNext()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.broadcast", 2, "runNext," + this.mRunningTaskNum.get() + "," + this.mHeadGetIntents.size());
    }
    if ((this.mRunningTaskNum.get() < 2) && (!this.mHeadGetIntents.isEmpty()))
    {
      Intent localIntent = (Intent)this.mHeadGetIntents.poll();
      if (localIntent != null)
      {
        this.mRunningTaskNum.incrementAndGet();
        ThreadManager.excute(new QQAppInterface.21(this, System.currentTimeMillis(), localIntent), 32, null, true);
      }
    }
  }
  
  private void sendBindUinOffline()
  {
    Object localObject = (bdxs)getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    if (localObject != null) {}
    for (localObject = ((bdxs)localObject).a();; localObject = null)
    {
      if ((localObject == null) || (((ArrayList)localObject).size() == 0)) {
        return;
      }
      bdxj.a(this, (byte)0, (ArrayList)localObject);
      return;
    }
  }
  
  private void sendHeadPathBroadcase(int paramInt, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    try
    {
      Intent localIntent = new Intent("com.tencent.qqhead.getheadresp");
      localIntent.setPackage(this.app.getPackageName());
      localIntent.putExtra("faceType", paramInt);
      localIntent.putStringArrayListExtra("uinList", paramArrayList1);
      localIntent.putStringArrayListExtra("headPathList", paramArrayList2);
      getApp().sendBroadcast(localIntent, "com.tencent.qqhead.permission.getheadresp");
      return;
    }
    catch (Exception paramArrayList1)
    {
      QLog.e("Q.qqhead.broadcast", 2, "headQQHeadBroadcast error", paramArrayList1);
    }
  }
  
  private void showKickedNotification(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("title");
    String str2 = paramIntent.getStringExtra("msg");
    if (SystemClock.elapsedRealtime() - this.mPreShowKickedNTs > 5000L)
    {
      paramIntent.putExtra("entrance", 6);
      paramIntent.putExtra("key_notification_click_action", true);
      showNotificationWithoutMessage(new aosm(paramIntent, str2, str1, str2, null), "CMD_SHOW_NOTIFIYCATION");
      this.mPreShowKickedNTs = SystemClock.elapsedRealtime();
    }
  }
  
  private void showMessageNotificationNoPreview(QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    if ((this.isFinished) || (!bgzw.a(this.app.getApplicationContext(), this)) || (bgzw.b(this.app.getApplicationContext(), this)) || (!awxj.a(this).a(paramMessage))) {
      return;
    }
    label114:
    Intent localIntent;
    StringBuffer localStringBuffer;
    int i;
    if ((this.msgFacade.msgNotifyManager.b() == 1) || (paramMessage.istroop == 1037) || (paramMessage.istroop == 1044) || (paramMessage.istroop == 1045))
    {
      localObject = getIntentByMessage(getApp(), paramMessage, false);
      ((Intent)localObject).putExtra("entrance", 6);
      localIntent = this.messageNotifiableChecker.a(paramMessage, (Intent)localObject);
      localIntent.putExtra("key_notification_click_action", true);
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(getApp().getString(2131694354));
      if (paramMessage.istroop == 1037) {
        this.msgFacade.msgNotifyManager.a(1037);
      }
      if ((paramMessage.istroop != 1044) && (paramMessage.istroop != 1045)) {
        break label384;
      }
      i = this.msgFacade.msgNotifyManager.a(1044) + this.msgFacade.msgNotifyManager.a(1045);
      label233:
      if (i == 0) {
        break label396;
      }
      if (i <= 1000) {
        break label398;
      }
      localStringBuffer.append(getApp().getString(2131694338));
      label260:
      if (!paramBoolean) {
        break label439;
      }
    }
    label384:
    label396:
    label398:
    label439:
    for (Object localObject = localStringBuffer.toString();; localObject = null)
    {
      if ((paramMessage.istroop == 1037) || (paramMessage.istroop == 1045) || (paramMessage.istroop == 1044)) {}
      for (String str = getApp().getResources().getString(2131698473);; str = getApp().getResources().getString(2131694350))
      {
        anyy.a(this, paramMessage, new aosm(localIntent, (String)localObject, str, localStringBuffer.toString(), null), "CMD_SHOW_NOTIFIYCATION");
        return;
        localObject = new Intent(getApp(), SplashActivity.class);
        ((Intent)localObject).addFlags(335544320);
        ((Intent)localObject).putExtra("tab_index", MainFragment.b);
        break label114;
        i = this.msgFacade.msgNotifyManager.a();
        break label233;
        break;
        localStringBuffer.append(i).append(getApp().getString(2131694276));
        break label260;
      }
    }
  }
  
  private void showMessageNotificationWithPreview(QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    this.messageNotificationGenerator = new anyy(this);
    if (anyx.a(this, paramMessage)) {
      this.messageNotificationGenerator.a(this, paramMessage, paramBoolean);
    }
  }
  
  private boolean soundVibrateWhenNoNotification(boolean paramBoolean1, boolean paramBoolean2, QQMessageFacade.Message paramMessage)
  {
    if (this.messageNotifiableChecker.e(paramMessage)) {
      return true;
    }
    if ((paramMessage.istroop == 1008) && (AppConstants.REMINDER_UIN.equals(paramMessage.senderuin))) {}
    for (int i = 1; i != 0; i = 0)
    {
      vibratorAndAudioForMsg(paramMessage, paramBoolean2);
      return true;
    }
    if (paramBoolean1)
    {
      boolean bool = this.messageNotifiableChecker.i(paramMessage);
      if ((this.userActiveStatus == 0) || (bool))
      {
        if (this.mainActivityIsForeground) {
          break label122;
        }
        vibratorAndAudioForMsg(paramMessage, paramBoolean2);
      }
    }
    if ((paramBoolean1) && (this.messageNotifiableChecker.f(paramMessage))) {
      this.messageNotifiableChecker.a(paramMessage);
    }
    return false;
    label122:
    if ((this.areMessageRefreshUI[0] == paramMessage.uniseq) && (this.areMessageRefreshUI[1] == 1L)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label170;
      }
      vibratorAndAudioForMsg(paramMessage, paramBoolean2);
      break;
    }
    label170:
    this.needSoundAndVibrations[0] = 1;
    byte[] arrayOfByte = this.needSoundAndVibrations;
    if (paramBoolean2) {}
    for (i = 1;; i = 0)
    {
      arrayOfByte[1] = ((byte)i);
      break;
    }
  }
  
  public static void speak(String paramString)
  {
    TextToSpeech localTextToSpeech = sTts;
    if ((localTextToSpeech != null) && (!TextUtils.isEmpty(paramString))) {
      localTextToSpeech.speak(paramString, 1, null);
    }
  }
  
  private void startActivitySafe(Context paramContext, Intent paramIntent, String paramString)
  {
    try
    {
      paramContext.startActivity(paramIntent);
      return;
    }
    catch (ActivityNotFoundException paramIntent)
    {
      do
      {
        QQToast.a(paramContext, paramString, 1).a();
      } while (!QLog.isColorLevel());
      QLog.e("QQAppInterface", 1, "startActivitySafe fail", paramIntent);
    }
  }
  
  private boolean systemSound(String paramString)
  {
    return (String.valueOf(AppConstants.SYSTEM_MSG_UIN).equals(paramString)) || (String.valueOf(AppConstants.QQBROADCAST_MSG_UIN).equals(paramString)) || (String.valueOf(AppConstants.LBS_HELLO_UIN).equals(paramString));
  }
  
  public void addAboutListener(ResourcePluginListener paramResourcePluginListener)
  {
    initAbout();
    this.aboutConfig.a(paramResourcePluginListener);
  }
  
  public void addDefaultObservers(BusinessObserver paramBusinessObserver)
  {
    synchronized (this.defaultObservers)
    {
      if (!this.defaultObservers.contains(paramBusinessObserver)) {
        this.defaultObservers.add(paramBusinessObserver);
      }
      return;
    }
  }
  
  public void addLebaListener(ResourcePluginListener paramResourcePluginListener)
  {
    initLebaHelper();
    this.mLebaHelper.a(paramResourcePluginListener);
  }
  
  public void addManager(int paramInt, Manager paramManager)
  {
    if (this.managers[paramInt] != null) {
      return;
    }
    this.managers[paramInt] = paramManager;
  }
  
  public void addManager(boolean paramBoolean)
  {
    addManager(paramBoolean, 0L);
  }
  
  public void addManager(boolean paramBoolean, long paramLong)
  {
    int i = 0;
    if (paramBoolean)
    {
      int[] arrayOfInt = IMPORTANT_MANAGERS;
      int j = arrayOfInt.length;
      i = 0;
      if (i < j)
      {
        int k = arrayOfInt[i];
        if (k == QQManagerFactory.MGR_PLUGIN)
        {
          QLog.d("QQInitHandler", 2, new Object[] { "pluginManageDelayTime=", Long.valueOf(paramLong) });
          if (paramLong > 0L) {
            ThreadManager.getSubThreadHandler().postDelayed(new QQAppInterface.3(this), paramLong);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (paramLong == 0L)
          {
            getManager(QQManagerFactory.MGR_PLUGIN);
            continue;
            getManager(k);
          }
        }
      }
    }
    else
    {
      while (i < QQManagerFactory.COUNT_MANAGER)
      {
        if ((i != QQManagerFactory.MGR_MEDIA_PLAYER) && (i != QQManagerFactory.BUSINESS_WORD_MATCH_MANAGER)) {
          getManager(i);
        }
        i += 1;
      }
    }
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver)
  {
    addObserver(paramBusinessObserver, false);
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (paramBusinessObserver == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.bgObservers)
      {
        if (!this.bgObservers.contains(paramBusinessObserver)) {
          this.bgObservers.add(paramBusinessObserver);
        }
        return;
      }
    }
    synchronized (this.uiObservers)
    {
      if (!this.uiObservers.contains(paramBusinessObserver)) {
        this.uiObservers.add(paramBusinessObserver);
      }
      return;
    }
  }
  
  public void addVibrateListener(aogp paramaogp)
  {
    if (paramaogp == null) {}
    while (this.vibrateListenerList.indexOf(paramaogp) >= 0) {
      return;
    }
    this.vibrateListenerList.add(paramaogp);
  }
  
  public boolean canPlaySound()
  {
    return getALLGeneralSettingRing() != 0;
  }
  
  boolean canPlayThemeSound()
  {
    if (canPlaySound())
    {
      Object localObject = ThemeUtil.getUserCurrentThemeId(this);
      if ((localObject != null) && (!((String)localObject).equals("1000")))
      {
        localObject = ThemeUtil.getThemeInfo(getApplication(), (String)localObject);
        if ((localObject != null) && (((ThemeUtil.ThemeInfo)localObject).isVoiceTheme)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean canVibrator()
  {
    return getALLGeneralSettingVibrate() != 0;
  }
  
  public void cancelNotification()
  {
    try
    {
      QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
      localQQNotificationManager.cancel("QQAppInterface_cancelNotification", 265);
      localQQNotificationManager.cancel("QQAppInterface_cancelNotification", 275);
      localQQNotificationManager.cancel("QQAppInterface_cancelNotification", 527);
      label34:
      showIdleNotification(getApp(), null);
      return;
    }
    catch (Exception localException)
    {
      break label34;
    }
  }
  
  public void cancelSyncOnlineFriend(long paramLong)
  {
    if (paramLong >= 0L) {
      this.sLastGetOnlineFriendTime = paramLong;
    }
    this.sGetOnlineFriendHandler.removeMessages(0);
  }
  
  public boolean checkAndGetSelfNickName()
  {
    boolean bool2 = false;
    String str1 = getCurrentAccountUin();
    String str2 = ContactUtils.getAccountNickName(this, str1);
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str1))
    {
      bool1 = bool2;
      if (str1.equals(str2))
      {
        localObject = (anvk)getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (localObject != null) {
          break label144;
        }
      }
    }
    label144:
    for (Object localObject = null;; localObject = ((anvk)localObject).e(str1))
    {
      if (localObject != null)
      {
        bool1 = bool2;
        if (((Friends)localObject).name != null) {}
      }
      else
      {
        localObject = (FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = true;
          ((FriendListHandler)localObject).getFriendInfo(str1);
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("QQAppInterface", 4, "checkAndGetSelfNickName, [" + str2 + "," + bool1 + "]");
      }
      return bool1;
    }
  }
  
  public void checkBatteryStatus()
  {
    int i = getBatteryCapacity();
    int j = getPowerConnect();
    if ((i == 0) || (j == -1))
    {
      i = azbj.a();
      j = azbj.b();
      setBatteryCapacity(i);
      setPowerConnect(j);
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, String.format("checkBatteryStatus, curBattery: %s, powerConnect:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
      }
    }
  }
  
  public void clearGroupSuspiciousMsg()
  {
    synchronized (this.mSystemMsgInitLock)
    {
      getMessageFacade().clearHistory(AppConstants.TROOP_SUSPICIOUS_MSG_UIN, 0);
      getMsgHandler().a().d();
      return;
    }
  }
  
  public void clearGroupSystemMsg()
  {
    synchronized (this.mSystemMsgInitLock)
    {
      getMessageFacade().clearHistory(AppConstants.TROOP_SYSTEM_MSG_UIN, 0);
      getMsgHandler().a().e();
      return;
    }
  }
  
  public void clearGroupSystemMsgHistory()
  {
    synchronized (this.mSystemMsgInitLock)
    {
      getMessageFacade().clearHistory(AppConstants.TROOP_SYSTEM_MSG_UIN, 0);
      return;
    }
  }
  
  public void clearLebaResourceInfoList()
  {
    if (this.mLebaHelper != null) {
      this.mLebaHelper.d();
    }
  }
  
  public void clearMsgCounter()
  {
    if (this.msgFacade != null) {
      this.msgFacade.msgNotifyManager.b();
    }
    Object localObject = (bdxs)getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    if (localObject != null) {
      ((bdxs)localObject).b();
    }
    localObject = (aohe)getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
    if (localObject != null) {
      ((aohe)localObject).d();
    }
  }
  
  @NonNull
  public bgyp decodeFace(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = FaceConstant.HeadConfig.FACE_BITMAP_CONFIG;
    bgyp localbgyp = new bgyp();
    int i = 0;
    do
    {
      bgyo.a(paramString, localOptions, localbgyp);
      if (localbgyp.jdField_a_of_type_Int == 1) {
        freePartBitmapCache();
      }
      i += 1;
    } while ((i < 2) && (localbgyp.jdField_a_of_type_Int == 1));
    return localbgyp;
  }
  
  public void deleteQCallFace(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.qaif", 2, "deleteQCallFace id=" + paramString + ", idtype =" + paramInt);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while ((paramInt != 200) && (paramInt != 204) && (paramInt != 202));
      removeFaceIconCache(16, paramString, paramInt);
      paramString = new File(getCustomFaceFilePath(16, paramString, paramInt));
    } while ((paramString == null) || (!paramString.exists()));
    paramString.delete();
  }
  
  public void deleteStrangerFace(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.", 2, "deleteStrangerFace.id=" + paramString + ",idType=" + paramInt);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while ((paramInt != 200) && (paramInt != 204) && (paramInt != 202));
      removeFaceIconCache(32, paramString, paramInt);
      bgzh localbgzh = getNearbyProxy().a(false);
      if (localbgzh != null) {
        localbgzh.a(32, paramString, paramInt);
      }
      paramString = new File(getCustomFaceFilePath(32, paramString, paramInt));
    } while ((paramString == null) || (!paramString.exists()));
    paramString.delete();
  }
  
  public void endGetAllGeneralSettings(boolean paramBoolean1, boolean paramBoolean2)
  {
    bhhi localbhhi = (bhhi)getManager(QQManagerFactory.MGR_TROOP_FILTER);
    if (localbhhi != null) {
      localbhhi.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    ThreadManager.executeOnNetWorkThread(paramRunnable);
  }
  
  public void exit(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.d("exit", 2, getCurrentAccountUin() + " qq start to exit ");
    }
    this.isExitTaskUnfinished = true;
    sendBindUinOffline();
    bdlr.a().d(getCurrentAccountUin());
    avlf.a();
    release();
    MobileQQ localMobileQQ;
    if (isLogin())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "bReceiveMsgOnExit = " + this.bReceiveMsgOnExit + ", needPCActive = " + paramBoolean);
      }
      if (this.bReceiveMsgOnExit)
      {
        sendOnlineStatus(AppRuntime.Status.receiveofflinemsg, false, 0L, false);
        ((PushManager)getManager(5)).unregistProxyMessagePush(getAppid(), this.app.getPackageName() + ":video");
      }
    }
    else
    {
      if (GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager != null) {
        GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a();
      }
      if (!paramBoolean) {
        break label274;
      }
      localMobileQQ = getApplication();
      paramBoolean = bool1;
      if (!isLogin()) {
        paramBoolean = true;
      }
      localMobileQQ.qqProcessExit(paramBoolean);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "QQAppInterface exit removeNotification");
      }
      removeNotification();
      HeavyTaskExecutor.a();
      GuardManager.a(true);
      return;
      if (paramBoolean)
      {
        sendOnlineStatus(AppRuntime.Status.offline, false, 0L, false);
        break;
      }
      sendOnlineStatus(AppRuntime.Status.offline, true, 0L, false);
      break;
      label274:
      localMobileQQ = getApplication();
      paramBoolean = bool2;
      if (!this.bReceiveMsgOnExit) {
        paramBoolean = true;
      }
      localMobileQQ.qqProcessExit(paramBoolean);
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    QQEntityManagerFactory localQQEntityManagerFactory = this.emFactory;
    if (localQQEntityManagerFactory != null) {
      localQQEntityManagerFactory.close();
    }
  }
  
  public int getALLGeneralSettingRing()
  {
    bhhi localbhhi = (bhhi)getManager(QQManagerFactory.MGR_TROOP_FILTER);
    if (localbhhi != null) {
      return localbhhi.b("message.ring.switch", 1);
    }
    return 1;
  }
  
  public int getALLGeneralSettingVibrate()
  {
    bhhi localbhhi = (bhhi)getManager(QQManagerFactory.MGR_TROOP_FILTER);
    if (localbhhi != null) {
      return localbhhi.b("message.vibrate.switch", 1);
    }
    return 1;
  }
  
  public AVNotifyCenter getAVNotifyCenter()
  {
    if (this.mAVNotifyCenter == null) {
      this.mAVNotifyCenter = new AVNotifyCenter(this);
    }
    return this.mAVNotifyCenter;
  }
  
  public aqwe getAboutConfig()
  {
    initAbout();
    return this.aboutConfig;
  }
  
  public boolean getAllGeneralSettings(boolean paramBoolean)
  {
    bhhi localbhhi = (bhhi)getManager(QQManagerFactory.MGR_TROOP_FILTER);
    if (localbhhi != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "getAllGeneralSettings , needTroopSettings=" + paramBoolean);
      }
      localbhhi.a(paramBoolean, null);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "getAllGeneralSettings roamSettingController is null ");
    }
    return false;
  }
  
  public int getAndroidInternalId(String paramString)
  {
    int k = 0;
    try
    {
      Class[] arrayOfClass = Class.forName("com.android.internal.R").getDeclaredClasses();
      int m = arrayOfClass.length;
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < m)
        {
          Class localClass = arrayOfClass[i];
          if ("id".equals(localClass.getSimpleName())) {
            j = localClass.getDeclaredField(paramString).getInt(null);
          }
        }
        else
        {
          return j;
        }
        i += 1;
      }
      return 0;
    }
    catch (Exception paramString) {}
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppBadgeCount()
  {
    int i = 0;
    int j = 0;
    QQMessageFacade localQQMessageFacade = getMessageFacade();
    if (localQQMessageFacade != null)
    {
      bapk localbapk = getCallFacade();
      i = j;
      if (localbapk != null)
      {
        i = j;
        if (!getAVNotifyCenter().j())
        {
          j = localbapk.a();
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("QQAppInterface", 2, "callUnread: " + j);
            i = j;
          }
        }
      }
      j = localQQMessageFacade.getUnreadMsgsNum();
      i = ((aizi)getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).d() + (j + i);
    }
    return i;
  }
  
  public int getAppid()
  {
    return AppSetting.a();
  }
  
  public ldh getAvAddFriendService()
  {
    if (this.mAvAddFriendService == null) {
      this.mAvAddFriendService = new ldh(this);
    }
    return this.mAvAddFriendService;
  }
  
  public Bitmap getBitmapFromCache(String paramString)
  {
    if (this.faceIconCache != null)
    {
      Bitmap localBitmap2 = (Bitmap)this.faceIconCache.get(paramString);
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (this.faceTimestamps != null)
        {
          localBitmap1 = localBitmap2;
          if (this.faceTimestamps.containsKey(paramString))
          {
            long l = ((Long)this.faceTimestamps.get(paramString)).longValue();
            localBitmap1 = localBitmap2;
            if (System.currentTimeMillis() - l > CHECK_FACE_UPDATE_PERIOD)
            {
              this.faceTimestamps.remove(paramString);
              this.faceIconCache.remove(paramString);
              localBitmap1 = null;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.", 2, "getFaceBitmap from cache, key: " + paramString + " value: " + localBitmap1);
      }
      return localBitmap1;
    }
    return null;
  }
  
  public void getBrowserFontSetting()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + getCurrentAccountUin(), 0);
    if (localSharedPreferences != null) {
      curBrowserFontSizeIndex = localSharedPreferences.getInt("browser_font_size_index", 1);
    }
  }
  
  public BusinessHandler getBusinessHandler(int paramInt)
  {
    Object localObject1 = this.allHandler[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.allHandler)
    {
      BusinessHandler localBusinessHandler = this.allHandler[paramInt];
      localObject1 = localBusinessHandler;
      if (localBusinessHandler == null)
      {
        localBusinessHandler = createHandler(paramInt);
        localObject1 = localBusinessHandler;
        if (localBusinessHandler != null)
        {
          this.allHandler[paramInt] = localBusinessHandler;
          localObject1 = localBusinessHandler;
        }
      }
      return localObject1;
    }
  }
  
  public List<BusinessObserver> getBusinessObserver(int paramInt)
  {
    if (paramInt == 1) {
      return this.uiObservers;
    }
    if (paramInt == 2) {
      return this.bgObservers;
    }
    if (paramInt == 0) {
      return this.defaultObservers;
    }
    return this.defaultObservers;
  }
  
  public int getC2CRoamingSetting()
  {
    bhhi localbhhi = (bhhi)getManager(QQManagerFactory.MGR_TROOP_FILTER);
    if (localbhhi != null) {
      return localbhhi.b("sync.c2c_message", 1);
    }
    return 1;
  }
  
  public aohg getCacheManager()
  {
    if (this.cacheManager == null) {
      this.cacheManager = ((aohg)getManager(QQManagerFactory.CACHE_MANAGER));
    }
    return this.cacheManager;
  }
  
  public bapk getCallFacade()
  {
    if (this.mCallFacade == null) {
      this.mCallFacade = ((bapk)getManager(QQManagerFactory.RECENT_CALL_FACADE));
    }
    return this.mCallFacade;
  }
  
  public anrt getCheckPttListener()
  {
    return this.checkPttListener;
  }
  
  public anru getCheckPtvListener()
  {
    return this.checkPtvListener;
  }
  
  public aqwk getConfig(String paramString, boolean paramBoolean)
  {
    if ((this.config == null) && (paramBoolean)) {
      initConfig(paramString);
    }
    return this.config;
  }
  
  public aqwg getConfigProcess()
  {
    return this.mConfigProcess;
  }
  
  public bazf getContactsFeedManager()
  {
    return (bazf)getManager(QQManagerFactory.QZONE_CONTACTS_FEED_MANAGER);
  }
  
  public acmw getConversationFacade()
  {
    if (this.convsFacade == null) {
      this.convsFacade = ((acmw)getManager(QQManagerFactory.CONVS_FACADE));
    }
    return this.convsFacade;
  }
  
  public boolean getCurLoginStatus()
  {
    boolean bool = true;
    if (!SettingCloneUtil.readValue(getApp(), getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", true)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "kickPC get value........... kickpc = " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public String getCurrentNickname()
  {
    return ContactUtils.getFriendDisplayName(this, getCurrentAccountUin());
  }
  
  public String getCurrentUin()
  {
    String str = "";
    if (!"0".equals(getCurrentAccountUin())) {
      str = getCurrentAccountUin();
    }
    return str;
  }
  
  public String getCustomFaceFilePath(int paramInt1, String paramString, int paramInt2)
  {
    return getCustomFaceFilePath(null, paramInt1, paramString, paramInt2, 0);
  }
  
  public String getCustomFaceFilePath(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    return getCustomFaceFilePath(null, paramInt1, paramString, paramInt2, paramInt3);
  }
  
  public String getCustomFaceFilePath(Setting paramSetting, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Object localObject = paramSetting;
    if (paramSetting == null)
    {
      localObject = paramSetting;
      if (paramString != null)
      {
        localObject = paramSetting;
        if (paramInt1 != 101)
        {
          localObject = paramSetting;
          if (paramInt1 != 1001)
          {
            localObject = paramSetting;
            if (paramInt1 != 116) {
              localObject = (Setting)getQQHeadSetting(paramInt1, paramString, paramInt2).second;
            }
          }
        }
      }
    }
    paramSetting = new StringBuilder(256);
    paramSetting.append(getFaceFilePathPrefix(paramInt1));
    localObject = getNewFaceTypeBySetting((Setting)localObject, paramString, paramInt1);
    switch (((Integer)localObject[0]).intValue())
    {
    }
    for (;;)
    {
      localObject = MD5.toMD5(paramString);
      localObject = MD5.toMD5((String)localObject + paramString);
      paramSetting.append(MD5.toMD5((String)localObject + paramString));
      paramSetting.append(".jpg_");
      return paramSetting.toString();
      paramSetting.append("troop_sys_b_");
      paramString = (String)localObject[1];
      continue;
      paramSetting.append("sys_");
      paramString = (String)localObject[1];
      continue;
      paramSetting.append("dis_g_");
      paramString = getCurrentAccountUin() + paramString;
      continue;
      paramSetting.append("dis_pstn_g_");
      paramString = getCurrentAccountUin() + paramString;
      continue;
      paramSetting.append("troop_");
      continue;
      paramSetting.append("new_troop_b_");
      continue;
      paramSetting.append("stranger_").append(Integer.toString(paramInt2)).append("_");
      continue;
      paramSetting.append("qcall_").append(Integer.toString(paramInt2)).append("_");
      continue;
      paramSetting.append("apollo_").append(paramInt3).append("_");
    }
  }
  
  public String getCustomFaceFilePath(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return getCustomFaceFilePath(null, 4, paramString, 0, 0);
    }
    return getCustomFaceFilePath(null, 1, paramString, 0, 0);
  }
  
  public String getCustomFaceFilePathBySetting(Setting paramSetting, int paramInt1, int paramInt2)
  {
    if (paramSetting == null) {
      return "";
    }
    int i = paramSetting.bUsrType;
    String str = bhbx.c(paramSetting.uin);
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    return getCustomFaceFilePath(paramSetting, i, str, paramInt1, paramInt2);
  }
  
  public aoxv getDataLineMsgProxy(int paramInt)
  {
    return getProxyManager().a(paramInt);
  }
  
  public QQEntityManagerFactory getEntityManagerFactory()
  {
    String str = getAccount();
    if (str == null) {
      throw new IllegalStateException("WTF");
    }
    if (this.emFactory != null) {
      return this.emFactory;
    }
    try
    {
      if (this.emFactory == null)
      {
        this.emFactory = new QQEntityManagerFactory(str);
        ThreadManager.getSubThreadHandler().postDelayed(new QQAppInterface.7(this), 3000L);
      }
      return this.emFactory;
    }
    finally {}
  }
  
  @Deprecated
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (!paramString.equals(getAccount())) {
      throw new IllegalStateException(paramString + "!=" + getAccount());
    }
    return getEntityManagerFactory();
  }
  
  public ExtensionInfo getExtensionInfo(String paramString, boolean paramBoolean)
  {
    anvk localanvk = (anvk)getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((localanvk != null) && (this.em != null))
    {
      ExtensionInfo localExtensionInfo2 = localanvk.a(paramString, false);
      ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
      if (localExtensionInfo2 == null)
      {
        localExtensionInfo1 = localExtensionInfo2;
        if (paramBoolean)
        {
          localExtensionInfo1 = (ExtensionInfo)this.em.find(ExtensionInfo.class, paramString);
          localanvk.a(localExtensionInfo1);
        }
      }
      return localExtensionInfo1;
    }
    return null;
  }
  
  public aoxx getFTSDBManager()
  {
    if (this.ftDBbManager == null) {
      this.ftDBbManager = ((aoxx)getManager(QQManagerFactory.FTSDB_MANAGER));
    }
    return this.ftDBbManager;
  }
  
  public Bitmap getFaceBitmap(int paramInt1, String paramString, byte paramByte1, int paramInt2, boolean paramBoolean, byte paramByte2, int paramInt3)
  {
    byte b = 3;
    if (isSpecialFaceType(paramInt1, paramString)) {
      return bheg.i();
    }
    if ((paramInt1 == 32) && (AppConstants.LBS_HELLO_UIN.equals(paramString))) {
      return bhbd.a(BaseApplicationImpl.getContext().getResources().getDrawable(2130840438));
    }
    if (isGetFaceBitmapParamInValid(paramInt1, paramString)) {
      return null;
    }
    if ((paramInt1 == 101) || (paramInt1 == 1001)) {
      paramByte1 = 3;
    }
    for (;;)
    {
      if ((paramInt1 == 4) && (!TroopUtils.hasSetTroopHead(paramString))) {
        paramInt1 = 113;
      }
      for (;;)
      {
        if (paramInt1 == 113) {
          paramByte1 = b;
        }
        for (;;)
        {
          return realGetFaceBitmap(paramInt1, paramString, aoke.a(paramByte1), paramInt2, paramBoolean, paramByte2, paramInt3);
        }
      }
    }
  }
  
  public Bitmap getFaceBitmap(int paramInt1, String paramString, byte paramByte1, boolean paramBoolean, byte paramByte2, int paramInt2)
  {
    return getFaceBitmap(paramInt1, paramString, paramByte1, 100, paramBoolean, paramByte2, paramInt2);
  }
  
  public Bitmap getFaceBitmap(int paramInt1, String paramString, byte paramByte, boolean paramBoolean, int paramInt2)
  {
    return getFaceBitmap(paramInt1, paramString, paramByte, paramBoolean, (byte)1, paramInt2);
  }
  
  public Bitmap getFaceBitmap(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    return getFaceBitmap(paramInt1, paramString, (byte)3, paramBoolean, paramInt2);
  }
  
  public Bitmap getFaceBitmap(String paramString, byte paramByte, boolean paramBoolean)
  {
    return getFaceBitmap(1, paramString, paramByte, paramBoolean, 0);
  }
  
  public Bitmap getFaceBitmap(String paramString, boolean paramBoolean)
  {
    return getFaceBitmap(1, paramString, (byte)3, paramBoolean, 0);
  }
  
  public String getFaceBitmapCacheKey(int paramInt1, String paramString, byte paramByte, int paramInt2)
  {
    return getFaceBitmapCacheKey(paramInt1, paramString, paramByte, paramInt2, 100, false);
  }
  
  public String getFaceBitmapCacheKey(int paramInt1, String paramString, byte paramByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder(16);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt1 != 101)
    {
      localObject1 = localObject2;
      if (paramInt1 != 1001)
      {
        localObject1 = localObject2;
        if (paramString != null)
        {
          if (!paramBoolean) {
            break label202;
          }
          localObject1 = getFaceSetting(getFaceSettingKey(paramInt1, paramString, paramInt2));
        }
      }
    }
    localObject1 = getNewFaceTypeBySetting((Setting)localObject1, paramString, paramInt1);
    switch (((Integer)localObject1[0]).intValue())
    {
    }
    for (;;)
    {
      localStringBuilder.append(paramString);
      if (paramByte > 0) {
        localStringBuilder.append("_").append(paramByte);
      }
      return localStringBuilder.toString();
      label202:
      localObject1 = (Setting)getQQHeadSetting(paramInt1, paramString, paramInt2).second;
      break;
      localStringBuilder.append("troop_sys_b_");
      paramString = (String)localObject1[1];
      continue;
      localStringBuilder.append("sys_");
      paramString = (String)localObject1[1];
      continue;
      localStringBuilder.append("dis_g_");
      continue;
      localStringBuilder.append("dis_pstn_g_");
      continue;
      localStringBuilder.append("troop_");
      continue;
      localStringBuilder.append("sub_");
      continue;
      localStringBuilder.append("stranger_").append(Integer.toString(paramInt2)).append("_");
      continue;
      localStringBuilder.append("qcall_").append(Integer.toString(paramInt2)).append("_");
      continue;
      localStringBuilder.append("new_troop_b_");
      continue;
      localStringBuilder.append("apollo_").append(paramInt3).append("_");
    }
  }
  
  @Deprecated
  public Drawable getFaceDrawable(String paramString)
  {
    return getFaceDrawable(paramString, false, (byte)3);
  }
  
  public Drawable getFaceDrawable(String paramString, boolean paramBoolean, byte paramByte)
  {
    Object localObject = getFaceBitmap(1, paramString, paramByte, true, 0);
    if ((localObject != null) && (paramBoolean)) {
      localObject = bheg.a((Bitmap)localObject);
    }
    for (;;)
    {
      paramString = null;
      if (localObject != null) {
        paramString = new BitmapDrawable((Bitmap)localObject);
      }
      localObject = paramString;
      if (paramString == null) {
        localObject = bheg.b();
      }
      return localObject;
    }
  }
  
  public Setting getFaceSetting(String paramString)
  {
    if (this.faceSettingCache == null) {
      return null;
    }
    return (Setting)this.faceSettingCache.get(paramString);
  }
  
  public atlf getFileManagerDataCenter()
  {
    if (this.mFileManagerDataCenter == null) {
      this.mFileManagerDataCenter = new atlf(this);
    }
    return this.mFileManagerDataCenter;
  }
  
  public athn getFileManagerEngine()
  {
    if (this.mFileManagerEngine == null) {}
    try
    {
      if (this.mFileManagerEngine == null) {
        this.mFileManagerEngine = new athn(this);
      }
      return this.mFileManagerEngine;
    }
    finally {}
  }
  
  public atlh getFileManagerNotifyCenter()
  {
    if (this.mFileManagerNotifyCenter == null) {
      this.mFileManagerNotifyCenter = new atlh(this);
    }
    return this.mFileManagerNotifyCenter;
  }
  
  public atpt getFileManagerProxy()
  {
    ProxyManager localProxyManager = getProxyManager();
    if (localProxyManager != null) {
      return localProxyManager.a();
    }
    return null;
  }
  
  public atlj getFileManagerRSCenter()
  {
    if (this.mFileManagerRSCenter == null) {
      this.mFileManagerRSCenter = new atlj(this);
    }
    return this.mFileManagerRSCenter;
  }
  
  public atht getFileTransferHandler()
  {
    if (this.fileTransferHandler == null) {
      this.fileTransferHandler = new atht(this);
    }
    return this.fileTransferHandler;
  }
  
  public aobd getGAudioHandler()
  {
    if (this.mGAudioHandler == null) {
      this.mGAudioHandler = new aobd(this);
    }
    return this.mGAudioHandler;
  }
  
  public HotChatManager getHotChatMng(boolean paramBoolean)
  {
    if ((this.mHCMng == null) && (paramBoolean)) {
      this.mHCMng = ((HotChatManager)getManager(QQManagerFactory.HOT_CHAT_MANAGER));
    }
    return this.mHCMng;
  }
  
  public Intent getIntentByMessage(Context paramContext, QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    if ((paramMessage.istroop == 1000) || (paramMessage.istroop == 1020) || (paramMessage.istroop == 1004))
    {
      if (alik.a(this, paramMessage.frienduin)) {
        return getIntentByUin(getApp(), paramMessage, 0);
      }
      return getIntentForTroopStranger(paramContext, paramMessage, paramBoolean);
    }
    return getIntentByUin(getApp(), paramMessage, paramMessage.istroop);
  }
  
  public MsgBoxInterFollowManager getInterFollowMgr()
  {
    return (MsgBoxInterFollowManager)getManager(QQManagerFactory.MSG_BOX_INTERACT_MANAGER);
  }
  
  public anxl getLebaHelper()
  {
    initLebaHelper();
    return this.mLebaHelper;
  }
  
  public List<LebaPluginInfo> getLebaResourceInfoList()
  {
    if (this.mLebaHelper != null) {
      return this.mLebaHelper.a();
    }
    return null;
  }
  
  public boolean getLocVisibilityForStatus()
  {
    return getPref().getBoolean(getApp().getString(2131694746) + getCurrentAccountUin(), false);
  }
  
  public boolean getLocZanAllowedForPeople()
  {
    return ((axnt)getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER)).b();
  }
  
  public boolean getLocZanAllowedForStatus()
  {
    return getPref().getBoolean(getApp().getString(2131694745) + getCurrentAccountUin(), false);
  }
  
  public boolean getLoudSpeakerState()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getBoolean(BaseApplication.getContext().getString(2131694754) + getCurrentAccountUin(), true);
  }
  
  public Manager getManager(int paramInt)
  {
    Manager localManager1 = this.managers[paramInt];
    ??? = localManager1;
    if (localManager1 == null)
    {
      if (this.mgrLockArray[(this.mgrLockArray.length - 1)] == null) {}
      synchronized (this.mgrLockArray)
      {
        if (this.mgrLockArray[(this.mgrLockArray.length - 1)] == null)
        {
          int i = 0;
          while (i < this.mgrLockArray.length)
          {
            this.mgrLockArray[i] = new Object();
            i += 1;
          }
        }
        if (!AppSetting.b) {}
      }
    }
    synchronized (this.mgrLockArray[paramInt])
    {
      for (;;)
      {
        localManager1 = this.managers[paramInt];
        if ((localManager1 == null) && ((getAccount() != null) || (paramInt <= 8) || (paramInt == QQManagerFactory.MGR_PLUGIN))) {
          break;
        }
        return localManager1;
        localObject2 = finally;
        throw localObject2;
        ??? = this.managers;
      }
      blfz.a("getManager_" + paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "getManager begin" + paramInt);
      }
      checkGetManagerCallingDepthStart(paramInt);
      Manager localManager2 = QQManagerFactory.createManager(paramInt, this);
      getManagerCompatibleWithOldLogic(paramInt, localManager2);
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "getManager end" + paramInt);
      }
      blfz.a();
      if (localManager2 != null) {
        addManager(paramInt, localManager2);
      }
      ??? = localManager2;
      checkGetManagerCallingDepthEnd();
      return ???;
    }
  }
  
  public QQMessageFacade getMessageFacade()
  {
    if (this.msgFacade == null) {
      this.msgFacade = ((QQMessageFacade)getManager(QQManagerFactory.MGR_MSG_FACADE));
    }
    return this.msgFacade;
  }
  
  public acnf getMessageProxy(int paramInt)
  {
    ProxyManager localProxyManager = getProxyManager();
    if (localProxyManager != null)
    {
      if (10007 == paramInt) {
        return localProxyManager.a();
      }
      return localProxyManager.a().a(paramInt);
    }
    return null;
  }
  
  public String[] getMessagePushSSOCommands()
  {
    return new String[] { "OnlinePush.ReqPush", "MessageSvc.PushGroupMsg", "MessageSvc.PushForceOffline", "MessageSvc.PushNotify", "MessageSvc.PushForceOffline", "MessageSvc.RequestPushStatus", "RegPrxySvc.PullDisGroupSeq", "MessageSvc.RequestBatchPushFStatus", "MessageSvc.PushFStatus", "AccostSvc.SvrMsg", "ADMsgSvc.PushMsg", "StreamSvr.PushStreamMsg", "friendlist.getOnlineFriend", "MessageSvc.WNSQzone", "RegPrxySvc.PbGetMsg", "RegPrxySvc.getOffMsg", "RegPrxySvc.PbGetGroupMsg", "RegPrxySvc.PullDisMsgSeq", "RegPrxySvc.infoNew", "RegPrxySvc.PullDisMsgProxy", "RegPrxySvc.PbGetDiscussMsg", "RegPrxySvc.PullGroupMsgProxy", "RegPrxySvc.GetMsgV2", "RegPrxySvc.PullGroupMsgSeq", "RegPrxySvc.NoticeEnd", "RegPrxySvc.PbSyncMsg", "RegPrxySvc.GetBoxFilter", "account.ResponseNotifyForRecommendUpdate", "MessageSvc.PushReaded", "RegPrxySvc.infoLogin", "baseSdk.Msf.NotifyResp", "RegPrxySvc.PushParam", "OnlinePush.PbPushGroupMsg", "OnlinePush.PbPushBindUinGroupMsg", "OnlinePush.PbPushTransMsg", "OnlinePush.PbPushDisMsg", "OnlinePush.PbC2CMsgSync", "OnlinePush.PbPushC2CMsg", "cmd_connAllFailed", "cmd_recvFirstResp", "MultiVideo.s2c", "MultiVideo.c2sack", "NearFieldTranFileSvr.NotifyList", "ProfileService.CheckUpdateReq", "NearFieldDiscussSvr.NotifyList", "RegPrxySvc.QueryIpwdStat", "StatSvc.SvcReqMSFLoginNotify", "ConfigPushSvc.PushDomain", "ImStatus.ReqPushStatus" };
  }
  
  public Class<? extends MSFServlet>[] getMessagePushServlets()
  {
    return new Class[] { aqte.class, bcvb.class, azir.class };
  }
  
  @Deprecated
  public Drawable getMobileFaceDrawable(String paramString, byte paramByte)
  {
    Bitmap localBitmap = getFaceBitmap(11, paramString, paramByte, true, 0);
    paramString = localBitmap;
    if (localBitmap == null) {
      paramString = bheg.a();
    }
    return new BitmapDrawable(paramString);
  }
  
  public bcrg getMsgCache()
  {
    if (this.msgCache == null) {}
    synchronized (this.allHandler)
    {
      if (this.msgCache == null) {
        this.msgCache = new bcrg(this);
      }
      return this.msgCache;
    }
  }
  
  public MessageHandler getMsgHandler()
  {
    if (this.msgHandler == null) {
      this.msgHandler = ((MessageHandler)getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER));
    }
    return this.msgHandler;
  }
  
  public aooh getMultiMessageProxy()
  {
    if (getProxyManager() != null) {
      return getProxyManager().a();
    }
    return null;
  }
  
  public axin getMultiMsgController()
  {
    if (this.mMultiMsgController == null) {}
    try
    {
      if (this.mMultiMsgController == null) {
        this.mMultiMsgController = new axin(this);
      }
      return this.mMultiMsgController;
    }
    finally {}
  }
  
  public String getNamePostfix(QQMessageFacade.Message paramMessage)
  {
    switch (paramMessage.bizType)
    {
    default: 
      return "";
    case 17: 
      if (paramMessage.msgtype == -2025)
      {
        if (MessageForQQWalletMsg.isRedPacketMsg(getMessageFacade().queryMsgItemByUniseq(paramMessage.frienduin, 1, paramMessage.uniseq))) {
          return getApp().getString(2131692812);
        }
        return "";
      }
      return "";
    case 10: 
      return getApp().getString(2131699025);
    case 24: 
      return getApp().getString(2131696977);
    case 13: 
      return getApp().getString(2131696975);
    case 5: 
      return getApp().getString(2131697174);
    case 22: 
      return getApp().getString(2131697437);
    case 4: 
      return getApp().getString(2131697192);
    }
    return getApp().getString(2131698221);
  }
  
  public axpp getNearbyProxy()
  {
    return (axpp)getManager(QQManagerFactory.NEARBY_PROXY_MANAGER);
  }
  
  public INetEngine getNetEngine(int paramInt)
  {
    if (this.mNetEngineFactory == null) {
      this.mNetEngineFactory = ((NetEngineFactory)getManager(QQManagerFactory.MGR_NET_ENGINE));
    }
    if (this.mNetEngineFactory == null) {
      return null;
    }
    return this.mNetEngineFactory.getEngineInstance(this, paramInt);
  }
  
  public String[] getNewAllowedTroopListUin()
  {
    Object localObject = getTroopListUin(-1);
    String[] arrayOfString1 = (String[])((HashMap)localObject).get(Integer.valueOf(1));
    String[] arrayOfString2 = (String[])((HashMap)localObject).get(Integer.valueOf(4));
    localObject = (String[])((HashMap)localObject).get(Integer.valueOf(2));
    if (arrayOfString1 != null) {}
    for (int j = arrayOfString1.length + 0;; j = 0)
    {
      int i = j;
      if (arrayOfString2 != null) {
        i = j + arrayOfString2.length;
      }
      j = i;
      if (localObject != null) {
        j = i + localObject.length;
      }
      String[] arrayOfString3;
      if (j > 0)
      {
        arrayOfString3 = new String[j];
        if (arrayOfString1 == null) {
          break label153;
        }
        System.arraycopy(arrayOfString1, 0, arrayOfString3, 0, arrayOfString1.length);
      }
      label153:
      for (i = arrayOfString1.length;; i = 0)
      {
        if (arrayOfString2 != null)
        {
          System.arraycopy(arrayOfString2, 0, arrayOfString3, 0, arrayOfString2.length);
          i = arrayOfString2.length;
        }
        if (localObject != null) {
          System.arraycopy(localObject, 0, arrayOfString3, i, localObject.length);
        }
        return arrayOfString3;
        return null;
      }
    }
  }
  
  public String[] getNewTroopListUin(int paramInt)
  {
    return (String[])getTroopListUin(paramInt).get(Integer.valueOf(paramInt));
  }
  
  public boolean getNotAllowedSeeMyDongtai(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getDongtaiPermission(getCurrentAccountUin(), 1);
    }
    return getPref().getBoolean(getApp().getString(2131694319) + getCurrentAccountUin(), false);
  }
  
  public nyv getNowLiveManager()
  {
    return (nyv)getManager(QQManagerFactory.NOW_LIVE_MANAGER);
  }
  
  public String getOldCustomFaceFilePath(int paramInt, String paramString)
  {
    Object localObject = MD5.toMD5(paramString);
    localObject = MD5.toMD5((String)localObject + paramString);
    paramString = MD5.toMD5((String)localObject + paramString);
    localObject = new StringBuilder(256);
    if (paramInt == 4) {
      if (SystemUtil.isExistSDCard()) {
        ((StringBuilder)localObject).append(AppConstants.PATH_HEAD_THD);
      }
    }
    for (;;)
    {
      if (paramInt == 101) {
        ((StringBuilder)localObject).append("discussion_");
      }
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(".png");
      return ((StringBuilder)localObject).toString();
      ((StringBuilder)localObject).append("/data/data/com.tencent.mobileqq/files/head/_thd/");
      continue;
      if (SystemUtil.isExistSDCard()) {
        ((StringBuilder)localObject).append(AppConstants.PATH_HEAD_HD);
      } else {
        ((StringBuilder)localObject).append("/data/data/com.tencent.mobileqq/files/head/_hd/");
      }
    }
  }
  
  public atni getOnlineFileSessionCenter()
  {
    if (this.mOnlineFileSessionCenter == null) {
      this.mOnlineFileSessionCenter = new atni(this);
    }
    return this.mOnlineFileSessionCenter;
  }
  
  public long getOnlineStauts()
  {
    if (isAccLoginSuccess()) {
      return getOnlineStatus().getValue();
    }
    return AppRuntime.Status.offline.getValue();
  }
  
  public Drawable getOrgFace(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return null;
  }
  
  public aopp getParcelHooker()
  {
    if (this.mParcelHooker == null) {}
    try
    {
      if (this.mParcelHooker == null) {
        this.mParcelHooker = new aopp();
      }
      return this.mParcelHooker;
    }
    finally {}
  }
  
  public PicPreDownloader getPicPreDownloader()
  {
    if (this.picPreDownloader == null) {
      this.picPreDownloader = ((PicPreDownloader)getManager(QQManagerFactory.MGR_PIC_PREDOWNLOAD));
    }
    return this.picPreDownloader;
  }
  
  public void getPreloadSwitch()
  {
    try
    {
      ((ansg)getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public aukm getPrivacyInfoUtil()
  {
    if (this.mPrivacyInfoUtil == null) {
      this.mPrivacyInfoUtil = new aukm();
    }
    return this.mPrivacyInfoUtil;
  }
  
  public ProxyManager getProxyManager()
  {
    if (this.proxyManager == null) {
      this.proxyManager = ((ProxyManager)getManager(QQManagerFactory.PROXY_MANAGER));
    }
    return this.proxyManager;
  }
  
  public Bitmap getQCallFaceBitmap(String paramString, int paramInt)
  {
    return getFaceBitmap(16, paramString, true, paramInt);
  }
  
  public Pair<Boolean, Setting> getQQHeadSetting(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject2 = null;
    String str = getFaceSettingKey(paramInt1, paramString, paramInt2);
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(str))
    {
      localObject1 = localObject2;
      if (this.faceSettingCache != null) {
        localObject1 = (Setting)this.faceSettingCache.get(str);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = localObject1;
        if (this.em != null)
        {
          checkAndCreateFaceSettingCache();
          localObject1 = (Setting)this.em.find(Setting.class, str);
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            this.faceSettingCache.put(str, localObject1);
            localObject2 = localObject1;
          }
        }
      }
    }
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.qaif", 2, "getQQHeadSetting. qqset is null, | uin=" + paramString);
      }
      return new Pair(Boolean.valueOf(true), localObject2);
    }
    boolean bool;
    switch (paramInt1)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      if ((QLog.isColorLevel()) && (bool)) {
        QLog.i("Q.qqhead.qaif", 2, "getQQHeadSetting. | uin=" + paramString + ", isNeedCheckQQHead=" + bool + ", accountStartTime=" + this.accountStartTime + ", updateTimestamp=" + localObject2.updateTimestamp + ", headImgTimestamp=" + localObject2.headImgTimestamp + ", status=" + localObject2.getStatus() + ", id=" + localObject2.getId() + ", currentTimeMillis=" + System.currentTimeMillis());
      }
      return new Pair(Boolean.valueOf(bool), localObject2);
      if ((localObject2 == null) || (System.currentTimeMillis() - localObject2.updateTimestamp > CHECK_FACE_UPDATE_PERIOD)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  /* Error */
  public Setting getQQHeadSettingFromDB(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1727	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   4: invokevirtual 3627	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   7: astore_3
    //   8: aload_3
    //   9: astore_2
    //   10: aload_3
    //   11: ldc_w 1707
    //   14: aload_1
    //   15: invokevirtual 3148	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   18: checkcast 1707	com/tencent/mobileqq/data/Setting
    //   21: astore_1
    //   22: aload_3
    //   23: ifnull +7 -> 30
    //   26: aload_3
    //   27: invokevirtual 3628	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   30: aload_1
    //   31: areturn
    //   32: astore_1
    //   33: aconst_null
    //   34: astore_3
    //   35: aload_3
    //   36: astore_2
    //   37: aload_1
    //   38: invokevirtual 850	java/lang/Exception:printStackTrace	()V
    //   41: aload_3
    //   42: ifnull +30 -> 72
    //   45: aload_3
    //   46: invokevirtual 3628	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   49: aconst_null
    //   50: areturn
    //   51: astore_1
    //   52: aconst_null
    //   53: astore_2
    //   54: aload_2
    //   55: ifnull +7 -> 62
    //   58: aload_2
    //   59: invokevirtual 3628	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   62: aload_1
    //   63: athrow
    //   64: astore_1
    //   65: goto -11 -> 54
    //   68: astore_1
    //   69: goto -34 -> 35
    //   72: aconst_null
    //   73: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	QQAppInterface
    //   0	74	1	paramString	String
    //   9	50	2	localEntityManager1	EntityManager
    //   7	39	3	localEntityManager2	EntityManager
    // Exception table:
    //   from	to	target	type
    //   0	8	32	java/lang/Exception
    //   0	8	51	finally
    //   10	22	64	finally
    //   37	41	64	finally
    //   10	22	68	java/lang/Exception
  }
  
  public blyb getQQProxyForQlink()
  {
    if (this.mQQProxyForQlink == null) {
      this.mQQProxyForQlink = new blyb(this);
    }
    return this.mQQProxyForQlink;
  }
  
  public blys getQlinkServiceMgr()
  {
    if (this.mQlinkServiceManager == null) {
      this.mQlinkServiceManager = new blys(this);
    }
    return this.mQlinkServiceManager;
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    SQLiteOpenHelper localSQLiteOpenHelper = getSQLiteOpenHelper();
    if (localSQLiteOpenHelper != null) {
      return localSQLiteOpenHelper.getReadableDatabase();
    }
    return null;
  }
  
  public SQLiteDatabase getReadableDatabase(String paramString)
  {
    paramString = getSQLiteOpenHelper(paramString);
    if (paramString != null) {
      return paramString.getReadableDatabase();
    }
    return null;
  }
  
  public RecentConfig getRecentConfig()
  {
    return algs.a().a();
  }
  
  public aoxz getRecentUserProxy()
  {
    if (this.mRecentUserProxy == null) {}
    try
    {
      if (this.mRecentUserProxy == null) {
        this.mRecentUserProxy = new aoxz(this, getCacheManager().getDBDelayManager());
      }
      return this.mRecentUserProxy;
    }
    finally {}
  }
  
  public Drawable getRectFaceDrawable(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return null;
  }
  
  public bdla getReportController()
  {
    if (this.mReportController == null) {}
    synchronized (this.mReportControllerLock)
    {
      if (this.mReportController == null) {
        this.mReportController = ReportControllerImpl.a(this);
      }
      return this.mReportController;
    }
  }
  
  public Drawable getRoundFaceDrawable(Bitmap paramBitmap)
  {
    return new BitmapDrawable(getRoundFaceBitmap(paramBitmap));
  }
  
  public Pair<Boolean, Bitmap> getScaledFaceBitmap(String paramString, byte paramByte, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    paramString = getFaceBitmap(1, paramString, paramByte, true, 0);
    if (paramString == null) {
      paramString = bheg.a();
    }
    for (;;)
    {
      return Pair.create(Boolean.valueOf(bool), paramString);
      bool = true;
    }
  }
  
  public bbxu getScribbleDownloader()
  {
    if (this.scribbleDownloader == null) {
      this.scribbleDownloader = ((bbxu)getManager(QQManagerFactory.SCRIBBLE_DOWNLOAD_MANAGER));
    }
    return this.scribbleDownloader;
  }
  
  public Intent getSecDetBannerIntent()
  {
    return this.mSecurityDetectBannerIntent;
  }
  
  public ISecureModuleService getSecureModuleService()
  {
    if (this.mSecureService == null) {
      this.mSecureService = SecureModuleService.getInstance(this.app);
    }
    return this.mSecureService;
  }
  
  public String getServerAddress()
  {
    Object localObject3 = null;
    Object localObject1 = this.app.getSharedPreferences("mobileQQ", 0);
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {}
    for (Object localObject2 = ((SharedPreferences)localObject1).getString("serverlist_wifi", null);; localObject2 = ((SharedPreferences)localObject1).getString("serverlist_2g3g", null))
    {
      localObject1 = localObject3;
      if (localObject2 != null)
      {
        localObject2 = ((String)localObject2).split(",");
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = localObject2[((int)(Math.random() * localObject2.length))];
        }
      }
      return localObject1;
    }
  }
  
  public String getServerConfigValue(ServerConfigManager.ConfigType paramConfigType, String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(32);
      localStringBuilder.append("getServerConfigValue type=").append(paramConfigType).append(", key=").append(paramString).append(", value=");
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      if ((this.serverConfig.containsKey(paramConfigType)) && (this.serverConfigTimeOut.containsKey(paramConfigType)) && (l - ((Long)this.serverConfigTimeOut.get(paramConfigType)).longValue() < 7200000L))
      {
        paramConfigType = (HashMap)this.serverConfig.get(paramConfigType);
        if (paramConfigType.containsKey(paramString))
        {
          if (localStringBuilder != null)
          {
            localStringBuilder.append((String)paramConfigType.get(paramString));
            QLog.d("QQAppInterface", 2, localStringBuilder.toString());
          }
          return (String)paramConfigType.get(paramString);
        }
        if (localStringBuilder != null)
        {
          localStringBuilder.append("null");
          QLog.d("QQAppInterface", 2, localStringBuilder.toString());
        }
        return null;
      }
      if (getAccount() == null) {}
      for (Object localObject = "0";; localObject = getAccount())
      {
        localObject = ((ServerConfigManager)getManager(4)).getServerConfig((String)localObject, paramConfigType);
        if ((localObject != null) && (((String)localObject).length() != 0)) {
          break;
        }
        if (localStringBuilder != null)
        {
          localStringBuilder.append("null, configText is null");
          QLog.d("QQAppInterface", 2, localStringBuilder.toString());
        }
        return null;
      }
      try
      {
        localObject = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<ServerConfig>" + (String)localObject + "</ServerConfig>";
        XMLReader localXMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        QQAppInterface.ServerConfigXMLHandler localServerConfigXMLHandler = new QQAppInterface.ServerConfigXMLHandler(this);
        localXMLReader.setContentHandler(localServerConfigXMLHandler);
        localXMLReader.parse(new InputSource(new ByteArrayInputStream(((String)localObject).getBytes("UTF-8"))));
        localObject = localServerConfigXMLHandler.getElements();
        this.serverConfig.put(paramConfigType, localObject);
        this.serverConfigTimeOut.put(paramConfigType, Long.valueOf(l));
        l = System.currentTimeMillis() - l;
        if (localStringBuilder != null)
        {
          localStringBuilder.append((String)((HashMap)localObject).get(paramString));
          localStringBuilder.append(",cost:").append(l);
          QLog.d("QQAppInterface", 2, localStringBuilder.toString());
        }
        if (l > 2000L) {
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(getCurrentAccountUin(), "getConfigLongCost", true, l, 0L, null, null);
        }
        paramConfigType = (String)((HashMap)localObject).get(paramString);
        return paramConfigType;
      }
      catch (Exception paramConfigType)
      {
        if (localStringBuilder != null) {
          QLog.e("QQAppInterface", 2, localStringBuilder.toString(), paramConfigType);
        }
        return null;
      }
      localStringBuilder = null;
    }
  }
  
  public byte[] getSessionKey()
  {
    if ((getAccount() != null) && (isLogin()) && (this.mSig != null)) {
      return this.mSig.sessionKey;
    }
    return null;
  }
  
  public Setting getSettingFromDb(String paramString)
  {
    return (Setting)this.em.find(Setting.class, paramString);
  }
  
  public boolean getShieldHisDongtai(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getDongtaiPermission(getCurrentAccountUin(), 2);
    }
    return getPref().getBoolean(getApp().getString(2131718806) + getCurrentAccountUin(), false);
  }
  
  public bcxj getShortVideoPredownloer()
  {
    if (this.shortVideoPreDownloader == null) {
      this.shortVideoPreDownloader = ((bcxj)getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER));
    }
    return this.shortVideoPreDownloader;
  }
  
  public ShortVideoResourceManager getShortVideoResourceManager()
  {
    if (this.mShortVideoResourceMgr == null) {
      this.mShortVideoResourceMgr = ((ShortVideoResourceManager)getManager(QQManagerFactory.SHORT_VIDEO_RESOURCE_MANAGER));
    }
    return this.mShortVideoResourceMgr;
  }
  
  public void getSignInInfo(int paramInt)
  {
    try
    {
      ((anri)getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).b(paramInt);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  @Deprecated
  public boolean getSingleTroopReceiveStatus(String paramString)
  {
    boolean bool = false;
    if (this.app.getSharedPreferences(getCurrentAccountUin(), 0).getLong(getCurrentAccountUin() + paramString, 1L) == 1L) {
      bool = true;
    }
    return bool;
  }
  
  public Bitmap getStrangerFaceBitmap(String paramString, int paramInt)
  {
    return getFaceBitmap(32, paramString, true, paramInt);
  }
  
  public avdz getTinyIdCache()
  {
    if (this.mTinyIdCache == null) {}
    try
    {
      if (this.mTinyIdCache == null) {
        this.mTinyIdCache = new avdz(this, getCacheManager().getDBDelayManager());
      }
      return this.mTinyIdCache;
    }
    finally {}
  }
  
  public TransFileController getTransFileController()
  {
    if (this.transFileController == null) {}
    try
    {
      if (this.transFileController == null) {
        this.transFileController = new TransFileController(this);
      }
      return this.transFileController;
    }
    finally {}
  }
  
  public String getTroopDisscussMemberNick(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if ((paramInt == 1000) || (paramInt == 1020))
    {
      paramString2 = ContactUtils.getTroopMemberNickByTroopCode(this, paramString1, paramString2);
      if (!TextUtils.isEmpty(paramString2))
      {
        localObject = paramString2;
        if (!paramString2.equals(paramString1)) {}
      }
      else
      {
        localObject = ((anvk)getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString1);
        if (localObject != null) {
          if (TextUtils.isEmpty(((Friends)localObject).remark)) {
            break label203;
          }
        }
      }
    }
    label203:
    for (paramString2 = ((Friends)localObject).remark;; paramString2 = ((Friends)localObject).name)
    {
      localObject = paramString2;
      if (paramBoolean) {
        if (!TextUtils.isEmpty(paramString2))
        {
          localObject = paramString2;
          if (!paramString2.equals(paramString1)) {}
        }
        else
        {
          localObject = paramString2;
          if (!this.friendInfoQueue.contains(paramString1))
          {
            this.friendInfoQueue.add(paramString1);
            localObject = (FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
            addObserver(this.friendListObserver);
            if (QLog.isColorLevel()) {
              QLog.d("QQAppInterface_friendListObserver", 2, "addObserver");
            }
            ((FriendListHandler)localObject).getFriendInfo(paramString1);
            localObject = paramString2;
          }
        }
      }
      if ((localObject != null) && (!"".equals(localObject))) {
        break label212;
      }
      return paramString1;
      paramString2 = ContactUtils.getDiscussionMemberShowName(this, paramString2, paramString1);
      break;
    }
    label212:
    return localObject;
  }
  
  public Bitmap getTroopFaceBitmap(String paramString, byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = getFaceBitmap(4, paramString, paramByte, true, 0);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = bheg.f();
    }
    localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramBoolean1) {
        localObject = bheg.a(paramString);
      }
    }
    paramString = (String)localObject;
    if (localObject != null)
    {
      paramString = (String)localObject;
      if (paramBoolean2) {
        paramString = shield((Bitmap)localObject);
      }
    }
    return paramString;
  }
  
  public Drawable getTroopFaceDrawable(String paramString)
  {
    return getTroopFaceDrawable(paramString, (byte)3, false, false);
  }
  
  public Drawable getTroopFaceDrawable(String paramString, byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = getTroopFaceBitmap(paramString, paramByte, paramBoolean1, paramBoolean2);
    paramString = null;
    if (localObject != null) {
      paramString = new BitmapDrawable((Bitmap)localObject);
    }
    localObject = paramString;
    if (paramString == null) {
      localObject = bheg.c();
    }
    return localObject;
  }
  
  public int getTroopGeneralSettingRing()
  {
    bhhi localbhhi = (bhhi)getManager(QQManagerFactory.MGR_TROOP_FILTER);
    if (localbhhi != null) {
      return localbhhi.b("message.group.ring", 0);
    }
    return 0;
  }
  
  public int getTroopGeneralSettingVibrate()
  {
    bhhi localbhhi = (bhhi)getManager(QQManagerFactory.MGR_TROOP_FILTER);
    if (localbhhi != null) {
      return localbhhi.b("message.group.vibrate", 0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SoundSetting", 2, "rsController is null!");
    }
    return 0;
  }
  
  /* Error */
  public HashMap<Integer, String[]> getTroopListUin(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 598	java/util/HashMap
    //   6: dup
    //   7: invokespecial 599	java/util/HashMap:<init>	()V
    //   10: astore 7
    //   12: aload_0
    //   13: getfield 634	com/tencent/mobileqq/app/QQAppInterface:app	Lcom/tencent/common/app/BaseApplicationImpl;
    //   16: invokevirtual 3890	com/tencent/common/app/BaseApplicationImpl:getContentResolver	()Landroid/content/ContentResolver;
    //   19: new 339	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   26: ldc_w 3892
    //   29: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: invokevirtual 1003	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   36: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 352	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 3897	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   45: iconst_1
    //   46: anewarray 333	java/lang/String
    //   49: dup
    //   50: iconst_0
    //   51: ldc_w 1809
    //   54: aastore
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: invokevirtual 3903	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   61: astore_3
    //   62: aload_3
    //   63: astore 4
    //   65: aload_0
    //   66: aload 4
    //   68: invokespecial 3905	com/tencent/mobileqq/app/QQAppInterface:getTroopUinList	(Landroid/database/Cursor;)Ljava/util/ArrayList;
    //   71: astore 5
    //   73: aload 5
    //   75: astore_3
    //   76: aload 4
    //   78: ifnull +13 -> 91
    //   81: aload 4
    //   83: invokeinterface 3906 1 0
    //   88: aload 5
    //   90: astore_3
    //   91: iload_1
    //   92: bipush 254
    //   94: if_icmpne +78 -> 172
    //   97: aload_3
    //   98: ifnull +35 -> 133
    //   101: aload_3
    //   102: invokevirtual 1865	java/util/ArrayList:size	()I
    //   105: ifle +28 -> 133
    //   108: aload 7
    //   110: bipush 254
    //   112: invokestatic 939	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: aload_3
    //   116: aload_3
    //   117: invokevirtual 1865	java/util/ArrayList:size	()I
    //   120: anewarray 333	java/lang/String
    //   123: invokevirtual 2141	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   126: checkcast 2143	[Ljava/lang/String;
    //   129: invokevirtual 2144	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   132: pop
    //   133: aload 7
    //   135: areturn
    //   136: astore_3
    //   137: aconst_null
    //   138: astore 4
    //   140: aload 4
    //   142: ifnull +254 -> 396
    //   145: aload 4
    //   147: invokeinterface 3906 1 0
    //   152: aconst_null
    //   153: astore_3
    //   154: goto -63 -> 91
    //   157: astore_3
    //   158: aload 4
    //   160: ifnull +10 -> 170
    //   163: aload 4
    //   165: invokeinterface 3906 1 0
    //   170: aload_3
    //   171: athrow
    //   172: aload_3
    //   173: ifnull +212 -> 385
    //   176: aload_0
    //   177: aload_3
    //   178: invokevirtual 3910	com/tencent/mobileqq/app/QQAppInterface:getTroopMsgFilter	(Ljava/util/List;)Ljava/util/Map;
    //   181: astore 8
    //   183: aload 8
    //   185: ifnull +183 -> 368
    //   188: new 483	java/util/ArrayList
    //   191: dup
    //   192: invokespecial 484	java/util/ArrayList:<init>	()V
    //   195: astore 6
    //   197: new 483	java/util/ArrayList
    //   200: dup
    //   201: invokespecial 484	java/util/ArrayList:<init>	()V
    //   204: astore 4
    //   206: new 483	java/util/ArrayList
    //   209: dup
    //   210: invokespecial 484	java/util/ArrayList:<init>	()V
    //   213: astore 5
    //   215: iconst_0
    //   216: istore_2
    //   217: iload_2
    //   218: aload_3
    //   219: invokevirtual 1865	java/util/ArrayList:size	()I
    //   222: if_icmpge +128 -> 350
    //   225: aload_3
    //   226: iload_2
    //   227: invokevirtual 1579	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   230: checkcast 333	java/lang/String
    //   233: astore 9
    //   235: aload 8
    //   237: aload 9
    //   239: invokeinterface 3913 2 0
    //   244: checkcast 789	java/lang/Integer
    //   247: invokevirtual 793	java/lang/Integer:intValue	()I
    //   250: tableswitch	default:+30 -> 280, 1:+37->287, 2:+58->308, 3:+30->280, 4:+79->329
    //   281: iconst_1
    //   282: iadd
    //   283: istore_2
    //   284: goto -67 -> 217
    //   287: iload_1
    //   288: iconst_m1
    //   289: if_icmpeq +8 -> 297
    //   292: iload_1
    //   293: iconst_1
    //   294: if_icmpne -14 -> 280
    //   297: aload 6
    //   299: aload 9
    //   301: invokevirtual 1569	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   304: pop
    //   305: goto -25 -> 280
    //   308: iload_1
    //   309: iconst_m1
    //   310: if_icmpeq +8 -> 318
    //   313: iload_1
    //   314: iconst_2
    //   315: if_icmpne -35 -> 280
    //   318: aload 4
    //   320: aload 9
    //   322: invokevirtual 1569	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   325: pop
    //   326: goto -46 -> 280
    //   329: iload_1
    //   330: iconst_m1
    //   331: if_icmpeq +8 -> 339
    //   334: iload_1
    //   335: iconst_4
    //   336: if_icmpne -56 -> 280
    //   339: aload 5
    //   341: aload 9
    //   343: invokevirtual 1569	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   346: pop
    //   347: goto -67 -> 280
    //   350: aload 6
    //   352: astore_3
    //   353: aload_0
    //   354: iload_1
    //   355: aload 7
    //   357: aload_3
    //   358: aload 4
    //   360: aload 5
    //   362: invokespecial 3915	com/tencent/mobileqq/app/QQAppInterface:putTroopTable	(ILjava/util/HashMap;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    //   365: aload 7
    //   367: areturn
    //   368: aconst_null
    //   369: astore 5
    //   371: aconst_null
    //   372: astore 4
    //   374: goto -21 -> 353
    //   377: astore_3
    //   378: goto -220 -> 158
    //   381: astore_3
    //   382: goto -242 -> 140
    //   385: aconst_null
    //   386: astore 5
    //   388: aconst_null
    //   389: astore 4
    //   391: aconst_null
    //   392: astore_3
    //   393: goto -40 -> 353
    //   396: aconst_null
    //   397: astore_3
    //   398: goto -307 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	401	0	this	QQAppInterface
    //   0	401	1	paramInt	int
    //   216	68	2	i	int
    //   61	56	3	localObject1	Object
    //   136	1	3	localException1	Exception
    //   153	1	3	localObject2	Object
    //   157	69	3	localList	List
    //   352	6	3	localObject3	Object
    //   377	1	3	localObject4	Object
    //   381	1	3	localException2	Exception
    //   392	6	3	localObject5	Object
    //   1	389	4	localObject6	Object
    //   71	316	5	localArrayList1	ArrayList
    //   195	156	6	localArrayList2	ArrayList
    //   10	356	7	localHashMap	HashMap
    //   181	55	8	localMap	Map
    //   233	109	9	str	String
    // Exception table:
    //   from	to	target	type
    //   12	62	136	java/lang/Exception
    //   12	62	157	finally
    //   65	73	377	finally
    //   65	73	381	java/lang/Exception
  }
  
  public int getTroopMask(String paramString)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramString);
    localObject = getTroopMsgFilter((List)localObject);
    if (localObject != null)
    {
      paramString = (Integer)((Map)localObject).get(paramString);
      if (paramString != null) {
        return paramString.intValue();
      }
    }
    return 1;
  }
  
  public Map<String, Integer> getTroopMsgFilter(List<String> paramList)
  {
    bhhi localbhhi = (bhhi)getManager(QQManagerFactory.MGR_TROOP_FILTER);
    if (localbhhi != null) {
      return localbhhi.a(paramList, 1);
    }
    return null;
  }
  
  public aukt getUDLBPTransProxy()
  {
    ProxyManager localProxyManager = getProxyManager();
    if (localProxyManager != null) {
      return localProxyManager.a();
    }
    return null;
  }
  
  public String getUinDisplayNameBeforeLogin(String paramString)
  {
    String str = getApplication().getProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramString);
    if ((str == null) || (str.length() == 0)) {
      return paramString;
    }
    return str;
  }
  
  public void getVideoConfigUpdate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "getVideoConfigUpdate");
    }
    NewIntent localNewIntent = new NewIntent(this.app, bcwe.class);
    localNewIntent.putExtra("reqType", 11);
    startServlet(localNewIntent);
  }
  
  public final boolean getVisibilityForInputStatus(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((avrf)getBusinessHandler(BusinessHandlerFactory.INPUT_STATUS_HANDLER)).a();
    }
    return getPref().getBoolean(getApp().getString(2131718888) + getCurrentAccountUin(), false);
  }
  
  public final boolean getVisibilityForNetWorkStatus(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getVisibilityForNetWorkStatus();
    }
    return getPref().getBoolean(getApp().getString(2131718889) + getCurrentAccountUin(), true);
  }
  
  public void getVisibilitySwitches()
  {
    ((anxi)getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).a();
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    SQLiteOpenHelper localSQLiteOpenHelper = getSQLiteOpenHelper();
    if (localSQLiteOpenHelper != null) {
      return localSQLiteOpenHelper.getWritableDatabase();
    }
    return null;
  }
  
  public SQLiteDatabase getWritableDatabase(String paramString)
  {
    paramString = getSQLiteOpenHelper(paramString);
    if (paramString != null) {
      return paramString.getWritableDatabase();
    }
    return null;
  }
  
  public void getZanSwitches()
  {
    ((anri)getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a();
  }
  
  public String getvKeyHexStr()
  {
    String str = getvKeyStr();
    if (str != null) {
      try
      {
        str = HexUtil.bytes2HexStr(str.getBytes("utf-8"));
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    return null;
  }
  
  @Deprecated
  public String getvKeyStr()
  {
    return null;
  }
  
  public void handleReceivedMessage(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.messageNotifiableChecker = new anyx(this, paramInt, paramBoolean1, paramBoolean2);
    QQMessageFacade localQQMessageFacade = this.messageNotifiableChecker.a();
    if (localQQMessageFacade == null) {}
    QQMessageFacade.Message localMessage;
    do
    {
      do
      {
        return;
        localMessage = localQQMessageFacade.getIncomingMsg();
      } while (this.messageNotifiableChecker.a(localQQMessageFacade, localMessage));
      this.messageNotifiableChecker.a();
      if (!this.messageNotifiableChecker.a(localMessage)) {
        break;
      }
    } while (this.messageNotifiableChecker.d(localMessage));
    bkyh.a(this, localMessage.istroop, localMessage.msgUid);
    unitTestLog("reportEvent", new Object[] { this, Integer.valueOf(localMessage.istroop), Long.valueOf(localMessage.msgUid) });
    OpenApiManager.getInstance().onReceiveNewMsg(localMessage);
    unitTestLog("onReceiveNewMsg", new Object[] { localMessage });
    localQQMessageFacade.msgNotifyManager.b(localMessage);
    notifyMessageReceived(localMessage, paramBoolean1, paramBoolean2);
    unitTestLog("notifyMessageReceived", new Object[] { localMessage, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    while (!soundVibrateWhenNoNotification(paramBoolean1, paramBoolean2, localMessage))
    {
      ((akes)getBusinessHandler(BusinessHandlerFactory.MINIMSG_HANDLER)).a(localMessage.frienduin, localMessage.istroop, localMessage.msgtype);
      unitTestLog("notifyUnreadState", new Object[] { localMessage.frienduin, Integer.valueOf(localMessage.istroop), Integer.valueOf(localMessage.msgtype) });
      refreshAppBadge();
      return;
    }
  }
  
  public aqwk initConfig(String paramString)
  {
    try
    {
      if (this.config == null) {
        this.config = new aqwk(this, paramString);
      }
      paramString = this.config;
      return paramString;
    }
    finally {}
  }
  
  public void initFaceSettingCache()
  {
    int k = 0;
    int i1 = 0;
    checkAndCreateFaceSettingCache();
    this.faceSettingCache.evictAll();
    Object localObject2 = this.em.query(Setting.class, new Setting().getTableName(), false, null, null, null, null, "updateTimestamp desc", null);
    Object localObject1;
    int j;
    int i;
    int n;
    if (localObject2 != null)
    {
      k = ((List)localObject2).size();
      if (k > 0)
      {
        localObject1 = new ArrayList();
        int m = 0;
        j = 0;
        i = 0;
        if (m < k)
        {
          Setting localSetting = (Setting)((List)localObject2).get(m);
          if ((localSetting != null) && (!TextUtils.isEmpty(localSetting.uin)))
          {
            if (i >= 4000)
            {
              n = j;
              j = i;
              i = n;
            }
            for (;;)
            {
              n = m + 1;
              m = j;
              j = i;
              i = m;
              m = n;
              break;
              localSetting.url = null;
              if (((localSetting.bSourceType == 1) || (localSetting.bUsrType == 32)) && (j <= 100))
              {
                ((List)localObject1).add(localSetting);
                n = j + 1;
                j = i;
                i = n;
              }
              else
              {
                this.faceSettingCache.put(localSetting.uin, localSetting);
                n = i + 1;
                i = j;
                j = n;
              }
            }
          }
        }
        else
        {
          n = Math.min(100, Math.min(4000 - i, ((List)localObject1).size()));
          if (n > 0)
          {
            m = i1;
            if (m < n)
            {
              localObject2 = (Setting)((List)localObject1).get(m);
              if ((localObject2 == null) || (TextUtils.isEmpty(((Setting)localObject2).uin))) {}
              for (;;)
              {
                m += 1;
                break;
                this.faceSettingCache.put(((Setting)localObject2).uin, localObject2);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      QLog.d("QQAppInterface", 1, "initFaceSettingCache," + k + "," + i + "," + j);
      this.isFaceSettingCached = true;
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("com.tencent.qqhead.getheadreq");
      ((IntentFilter)localObject1).addAction("com.tencent.qqhead.refreshheadreq");
      getApp().registerReceiver(this.qqHeadBroadcastReceiver, (IntentFilter)localObject1);
      return;
      n = i;
      i = j;
      j = n;
      break;
      j = 0;
      i = 0;
      continue;
      j = 0;
      i = 0;
    }
  }
  
  public void initLebaHelper()
  {
    if (this.mLebaHelper == null)
    {
      this.mLebaHelper = new anxl(this);
      this.mLebaHelper.a();
    }
  }
  
  public void initSecureFileFramework()
  {
    getSecurityUINRootFile();
    SharedPreferences localSharedPreferences = this.app.getSharedPreferences("SecurityFileFrameworkManagerImpl", 4);
    Object localObject = localSharedPreferences.getString("SP_KEY_UPDATE_SECURE_FILE_STRATEGY_REPORT", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecurityFileFramework", 2, new Object[] { "report=", localObject });
      }
      localObject = ((String)localObject).split("\\|");
      int j = localObject.length;
      int i = 0;
      if (i < j)
      {
        CharSequence localCharSequence = localObject[i];
        String[] arrayOfString;
        HashMap localHashMap;
        if (!TextUtils.isEmpty(localCharSequence))
        {
          arrayOfString = localCharSequence.split("#");
          localHashMap = new HashMap();
          switch (arrayOfString.length)
          {
          }
        }
        for (;;)
        {
          i += 1;
          break;
          localHashMap.put("BusinessName", arrayOfString[0]);
          localHashMap.put("needMigrate", "false");
          localHashMap.put("doMigrate", "null");
          localHashMap.put("fileSize", "-1");
          localHashMap.put("fileAmount", "-1");
          StatisticCollector.getInstance(getApp()).collectPerformance(getCurrentUin(), "SecureFileStep", true, 0L, 0L, localHashMap, "");
          continue;
          localHashMap.put("BusinessName", arrayOfString[0]);
          localHashMap.put("needMigrate", "true");
          localHashMap.put("doMigrate", arrayOfString[4]);
          localHashMap.put("fileSize", arrayOfString[2]);
          localHashMap.put("fileAmount", arrayOfString[3]);
          try
          {
            StatisticCollector.getInstance(getApp()).collectPerformance(getCurrentUin(), "SecureFileStep", true, 0L, 0L, localHashMap, "");
          }
          catch (NumberFormatException localNumberFormatException) {}
          if (QLog.isColorLevel()) {
            QLog.d("QQAppInterface", 2, new Object[] { "SecureFile Report Error, NumberFormatException", localCharSequence });
          }
        }
      }
      localSharedPreferences.edit().putString("SP_KEY_UPDATE_SECURE_FILE_STRATEGY_REPORT", "").apply();
    }
  }
  
  public boolean isAccLoginSuccess()
  {
    return (getAccount() != null) && (isLogin());
  }
  
  @TargetApi(14)
  public boolean isAccessibilityEnabled()
  {
    try
    {
      boolean bool = ((AccessibilityManager)this.app.getSystemService("accessibility")).isEnabled();
      if (QLog.isColorLevel()) {
        QLog.i("QQAppInterface", 2, "isAccessibilityEnabled()  isAccessibilityEnabled=" + bool);
      }
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public boolean isCallIdle()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)getApp().getSystemService("phone");
    return (localTelephonyManager != null) && (localTelephonyManager.getCallState() == 0);
  }
  
  public boolean isCreateManager(int paramInt)
  {
    return this.managers[paramInt] != null;
  }
  
  public boolean isFaceFileExist(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    if (paramInt1 == 101) {}
    String str = getFaceBitmapCacheKey(paramInt1, paramString, (byte)3, paramInt2, paramInt3, false);
    if ((this.faceIconCache != null) && (this.faceIconCache.get(str) != null)) {
      return true;
    }
    paramString = new File(getCustomFaceFilePath(paramInt1, paramString, paramInt2, paramInt3));
    boolean bool1 = bool2;
    if (paramString.exists())
    {
      bool1 = bool2;
      if (paramString.isFile()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isLBSFriendNewClient(String paramString)
  {
    boolean bool2 = false;
    paramString = getMsgCache().n(paramString);
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isNeedSecurityScan()
  {
    boolean bool2 = false;
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.app);
    boolean bool3 = SettingCloneUtil.readValue(this.app, null, "security_scan_key", "qqsetting_security_scan_key", false);
    boolean bool4 = ((SharedPreferences)localObject).getBoolean("security_scan_last_result", false);
    long l = ((SharedPreferences)localObject).getLong("security_scan_last_time", 0L);
    localObject = new Date(l);
    Date localDate = new Date();
    ((Date)localObject).setHours(0);
    ((Date)localObject).setMinutes(0);
    ((Date)localObject).setSeconds(0);
    boolean bool1 = bool2;
    if (bool3) {
      if ((l != 0L) && (localDate.getTime() - ((Date)localObject).getTime() <= 604800000L))
      {
        bool1 = bool2;
        if (!bool4) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isOpenNoClearNotification()
  {
    boolean bool = false;
    try
    {
      String str = getApp().getString(2131718598);
      if (str != null) {
        bool = SettingCloneUtil.readValue(getApp(), null, str, "qqsetting_notify_icon_key", false);
      }
      if (QLog.isColorLevel()) {
        QLog.i("MobileQQService", 2, "isOpenNoClearNotification" + bool);
      }
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public final boolean isPhoneNumSearchable(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((anri)getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).b();
    }
    return getPref().getBoolean(getApp().getString(2131694744) + getCurrentAccountUin(), true);
  }
  
  public boolean isPttRecordingOrPlaying()
  {
    return (this.checkPttListener != null) && (this.checkPttListener.isRecordingOrPlaying());
  }
  
  public boolean isRingEqualsZero()
  {
    AudioManager localAudioManager = (AudioManager)getApp().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getStreamVolume(2) == 0);
  }
  
  public boolean isRingerNormal()
  {
    AudioManager localAudioManager = (AudioManager)getApp().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getRingerMode() == 2);
  }
  
  public boolean isRingerNormalVibrate()
  {
    String str = Build.MANUFACTURER + Build.MODEL;
    if ((!TextUtils.isEmpty(str)) && (str.toLowerCase().contains("xiaomi"))) {
      if (Settings.System.getInt(getApp().getContentResolver(), "vibrate_in_normal", -1) != 1) {}
    }
    do
    {
      do
      {
        do
        {
          return true;
          return false;
          if (Build.VERSION.SDK_INT >= 11) {
            break;
          }
        } while (Settings.System.getInt(getApp().getContentResolver(), "vibrate_on", -1) > 4);
        return false;
        if (Build.VERSION.SDK_INT >= 16) {
          break;
        }
      } while (Settings.System.getInt(getApp().getContentResolver(), "vibrate_on", -1) == 5);
      return false;
    } while (Settings.System.getInt(getApp().getContentResolver(), "vibrate_when_ringing", -1) == 1);
    return false;
  }
  
  public boolean isRingerSilent()
  {
    AudioManager localAudioManager = (AudioManager)getApp().getSystemService("audio");
    if (localAudioManager != null) {}
    for (;;)
    {
      try
      {
        i = localAudioManager.getRingerMode();
        if (i == 0) {
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        i = 2;
        continue;
      }
      return false;
      int i = 2;
    }
  }
  
  public boolean isRingerVibrate()
  {
    try
    {
      AudioManager localAudioManager = (AudioManager)getApp().getSystemService("audio");
      if (localAudioManager != null)
      {
        int i = localAudioManager.getRingerMode();
        if (i == 1) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("QQAppInterface", 1, "isRingerVibrate error: " + localThrowable.getMessage());
    }
    return false;
  }
  
  public boolean isSelfNetworkStatusVisible(Friends paramFriends)
  {
    boolean bool = true;
    String str = getApp().getString(2131718889) + getCurrentAccountUin();
    if (getPref().contains(str)) {
      bool = getPref().getBoolean(str, true);
    }
    while (!ContactUtils.isInvisibleFriendNetworkStatus(paramFriends)) {
      return bool;
    }
    return false;
  }
  
  public boolean isShowMsgContent()
  {
    return SettingCloneUtil.readValue(getApp(), getCurrentAccountUin(), getApp().getString(2131718178), "qqsetting_notify_showcontent_key", true);
  }
  
  public boolean isTransFileControllerNotNull()
  {
    return this.transFileController != null;
  }
  
  public boolean isTroopMark(QQMessageFacade.Message paramMessage)
  {
    return isTroopMark(paramMessage.frienduin, paramMessage.istroop);
  }
  
  public boolean isTroopMark(String paramString, int paramInt)
  {
    if (paramInt == 1)
    {
      paramInt = getTroopMask(paramString);
      if ((paramInt == 3) || (paramInt == 2) || (paramInt == 4)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isUsingCameraOnVideo()
  {
    if ((this.mQQServiceRef != null) && (this.mQQServiceRef.get() != null) && (isVideoChatting()))
    {
      Object localObject = ((QQServiceForAV)this.mQQServiceRef.get()).a(1, 0, null);
      if (localObject != null)
      {
        localObject = ((Bundle)localObject).getString("camera_used_desc", null);
        QLog.w("QQAppInterface", 1, "isUsingCameraOnVideo, result[" + (String)localObject + "]");
        return localObject != null;
      }
    }
    return false;
  }
  
  public boolean isVideoChatting()
  {
    if (AVNotifyCenter.d())
    {
      lbd.f("QQAppInterface", "VideoProcessAlive isBeInvitingOnDoubleVideo");
      return true;
    }
    if ((!getAVNotifyCenter().b()) && (getAVNotifyCenter().b() == 0)) {
      return false;
    }
    if (QQServiceForAV.a()) {
      return true;
    }
    try
    {
      Object localObject = ((ActivityManager)getApp().getSystemService("activity")).getRunningAppProcesses();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName.equals("com.tencent.mobileqq:video"))
          {
            lbd.f("QQAppInterface", "VideoProcessAlive VIDEO_PROCESS_NAME");
            return true;
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public void logout(boolean paramBoolean)
  {
    if (paramBoolean) {
      sendBindUinOffline();
    }
    ((PushManager)getManager(5)).unregistProxyMessagePush(getAppid(), this.app.getPackageName() + ":video");
    awth.a().a();
    release();
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "kickPC in app  do logout");
    }
    String str = getCurrentAccountUin();
    if (str != null) {}
    try
    {
      bmrn.a(getApp(), Long.parseLong(str));
      TextHook.getInstance().switchDefault();
      super.logout(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public anyx messageNotifiableChecker()
  {
    return this.messageNotifiableChecker;
  }
  
  public void notifyFriendListSynced()
  {
    this.sLastGetOnlineFriendTime = SystemClock.uptimeMillis();
  }
  
  public void onConnAllFailed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onConnAllFailed");
    }
    awth.a().a(4);
    MqqHandler localMqqHandler = getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(1134013, null).sendToTarget();
    }
  }
  
  public void onConnClose()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onConnClose");
    }
    this.isMSFConnect = false;
    awth.a().a(1);
    MqqHandler localMqqHandler = getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(1134014, null).sendToTarget();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    startServlet(new NewIntent(getApplication(), bcvo.class));
    this.mqqService = new bcpt(this);
    this.mqqService.c();
    this.mAutomator = new Automator(this);
    if (isAccLoginSuccess())
    {
      bapk.a(this, System.currentTimeMillis());
      this.em = getEntityManagerFactory().createEntityManager();
      this.accountStartTime = System.currentTimeMillis();
      if (StartService.jdField_a_of_type_Boolean) {
        this.mAutomator.a(aohp.a(this.mAutomator, "{85,{4,3,5,6},[11,12,14],17,20,21,59,60,22,113,108,44,45,114,[100,65,25,10,26,27,28,29,30,32,34,35,39,40,41,42,43,47,48,50,55,107,69,93,70,71,72,73,{91},53,54,61,104,63,77,81,67,80,74,36,37,38,87,88,78,82,84,98,86,102,103,109,110,111,112],57,95,105}"));
      }
      if (StartService.jdField_a_of_type_Boolean) {
        ThemeUtil.initTheme(this);
      }
      initCallTabShowState();
    }
    try
    {
      MagnifierSDK.a(Long.parseLong(getAccount()));
      ThreadManager.getSubThreadHandler().post(new QQAppInterface.1(this));
      if (StartService.jdField_a_of_type_Boolean) {
        aoks.a();
      }
      if (GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager != null) {
        GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(this);
      }
      if (isLogin())
      {
        asbi.a(2);
        asbi.c();
        if (GuardManager.jdField_a_of_type_Boolean) {
          asbi.jdField_a_of_type_Boolean = true;
        }
      }
      this.mFirstGetSubAccountName = true;
      getQlinkServiceMgr().a();
      getFileManagerDataCenter().d();
      auht.a().a(this);
      getQQProxyForQlink().a();
      PluginManageHandler.getInstance().setPluginManagerProvider(this, false);
      onCreateDebug();
      bfoh.a().a();
      bfmz.a().a();
      bfny.a().a();
      atrv.a().a(this);
      weg.a(this);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.e("QQAppInterface", 4, paramBundle.toString());
      }
    }
  }
  
  public void onCreateDebug() {}
  
  protected void onCreateQQMessageFacade(QQMessageFacade paramQQMessageFacade)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onCreateQQMessageFacade() called with: msgFacade = [" + paramQQMessageFacade + "]");
    }
    new aobt(paramQQMessageFacade).a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mConfigProcess.a();
    BaseApplicationImpl.sShowTime = 0L;
    BaseApplicationImpl.sLaunchTime = 0L;
    BaseApplicationImpl.appStartTime = 0L;
    FMTSrvAddrProvider.destroy();
    release();
    ThemeUiPlugin.destroy(this);
    ChatBackgroundManager.b();
    AppNetConnInfo.unregisterNetInfoHandler(this.netHandler);
    if (this.sGetOnlineFriendHandler != null) {
      this.sGetOnlineFriendHandler.removeCallbacksAndMessages(null);
    }
    ThreadManager.getSubThreadHandler().post(new QQAppInterface.16(this));
    ThreadManager.excute(new QQAppInterface.17(this), 80, null, false);
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "QQAppInterface onDestroy removeNotification");
    }
    removeNotification();
    if (QLog.isColorLevel()) {
      QLog.d("security_scan", 2, "Unregist Cloud Scan Listener");
    }
    if (this.mAVNotifyCenter != null) {
      this.mAVNotifyCenter.a();
    }
    auht.a().a();
    if (this.transFileController != null) {
      getTransFileController().destroy();
    }
    if (this.mMultiMsgController != null)
    {
      this.mMultiMsgController.a();
      this.mMultiMsgController = null;
    }
    aqwk.a();
    OpenApiManager.getInstance().onRuntimeDestroy(this);
    bcqt.a();
    QWalletHelper.clearInstance(this);
    if (this.mOnlineFileSessionCenter != null) {
      this.mOnlineFileSessionCenter.e();
    }
    if (this.mHwEngine != null) {
      this.mHwEngine.closeEngine();
    }
    if (!TextUtils.isEmpty(getCurrentAccountUin())) {
      arpb.b();
    }
    if (this.mFileManagerDataCenter != null) {
      getFileManagerDataCenter().e();
    }
    if (this.mQQProxyForQlink != null) {
      getQQProxyForQlink().c();
    }
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
    if (localPresendPicMgr != null) {
      localPresendPicMgr.b();
    }
    if (InnerDns.mInstance != null) {
      InnerDns.getInstance().onAppDestroy();
    }
    if (this.lockDetectHandler != null) {
      this.lockDetectHandler.removeCallbacksAndMessages(null);
    }
    bogd.a().a();
    this.mHeadGetIntents.clear();
  }
  
  public RemotePluginManager.Stub onGetPluginManager()
  {
    return (blwy)getManager(QQManagerFactory.MGR_PLUGIN);
  }
  
  public void onMessageConnect()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onMessageConnect...");
    }
    if ((this.mAutomator == null) || (!isAccLoginSuccess())) {
      return;
    }
    if (this.mAutomator != null)
    {
      if (this.msgCache != null) {
        this.msgCache.f();
      }
      this.mAutomator.b();
    }
    setLoadingState();
    getPicPreDownloader().a();
    getShortVideoPredownloer().a();
    getScribbleDownloader().b();
    for (;;)
    {
      Object localObject4;
      HashMap localHashMap;
      try
      {
        Object localObject2 = getCurrentProcess();
        Object localObject3 = BaseApplication.getContext().getSharedPreferences("pull_msf" + (String)localObject2, 0);
        String str = ((SharedPreferences)localObject3).getString("uin", " ");
        localObject4 = ((SharedPreferences)localObject3).getString("time", "0");
        boolean bool1 = ((SharedPreferences)localObject3).getBoolean("proxy", false);
        boolean bool2 = ((SharedPreferences)localObject3).getBoolean("vivo", false);
        int i = ((SharedPreferences)localObject3).getInt("param_FailCode", 0);
        boolean bool3 = ((SharedPreferences)localObject3).getBoolean("mainProcess", false);
        Object localObject1 = ((SharedPreferences)localObject3).getString("sdkver", " ");
        if ((!str.equals(" ")) && (!((String)localObject4).equals("0")))
        {
          if ((BaseApplicationImpl.sLaunchTime < 0L) && (BaseApplicationImpl.sShowTime < 0L)) {
            RegisterProxy.d |= 0x4;
          }
          localHashMap = new HashMap();
          localHashMap.put("uin", str);
          localHashMap.put("time", localObject4);
          localHashMap.put("process", ((SharedPreferences)localObject3).getString("process", ""));
          localHashMap.put("availMem", ((SharedPreferences)localObject3).getString("availMem", ""));
          localHashMap.put("lowMem", ((SharedPreferences)localObject3).getString("lowMem", ""));
          localHashMap.put("state", ((SharedPreferences)localObject3).getString("state", ""));
          localHashMap.put("version", "150806");
          localHashMap.put("build", "4875");
          localHashMap.put("proxy", String.valueOf(bool1));
          localHashMap.put("vivo", String.valueOf(bool2));
          localHashMap.put("param_FailCode", String.valueOf(i));
          localHashMap.put("mainProcess", String.valueOf(bool3));
          localHashMap.put("sdkver", String.valueOf(localObject1));
          if (Build.VERSION.SDK_INT >= 21)
          {
            StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(getCurrentAccountUin(), "pullMsfReport_V3", false, 0L, 0L, localHashMap, "");
            localObject3 = ((SharedPreferences)localObject3).edit();
            ((SharedPreferences.Editor)localObject3).clear();
            ((SharedPreferences.Editor)localObject3).commit();
          }
        }
        else
        {
          localObject2 = BaseApplication.getContext().getSharedPreferences("pull_msf_succ" + (String)localObject2, 0);
          localObject3 = ((SharedPreferences)localObject2).getString("uin", " ");
          str = ((SharedPreferences)localObject2).getString("time", "0");
          if ((((String)localObject3).equals(" ")) || (str.equals("0"))) {
            break;
          }
          if ((getMsfPullFilterSwitch(this)) && (BaseApplicationImpl.sLaunchTime < 0L) && (BaseApplicationImpl.sShowTime < 0L)) {
            RegisterProxy.d |= 0x2;
          }
          localObject4 = new HashMap();
          ((HashMap)localObject4).put("uin", localObject3);
          ((HashMap)localObject4).put("time", str);
          ((HashMap)localObject4).put("process", ((SharedPreferences)localObject2).getString("process", ""));
          ((HashMap)localObject4).put("availMem", ((SharedPreferences)localObject2).getString("availMem", ""));
          ((HashMap)localObject4).put("lowMem", ((SharedPreferences)localObject2).getString("lowMem", ""));
          ((HashMap)localObject4).put("state", ((SharedPreferences)localObject2).getString("state", ""));
          ((HashMap)localObject4).put("version", "150806");
          ((HashMap)localObject4).put("build", "4875");
          ((HashMap)localObject4).put("proxy", String.valueOf(bool1));
          ((HashMap)localObject4).put("vivo", String.valueOf(bool2));
          ((HashMap)localObject4).put("param_FailCode", String.valueOf(i));
          ((HashMap)localObject4).put("mainProcess", String.valueOf(bool3));
          ((HashMap)localObject4).put("sdkver", String.valueOf(localObject1));
          if (Build.VERSION.SDK_INT < 21) {
            break label946;
          }
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(getCurrentAccountUin(), "pullMsfReport_succ_V2", false, 0L, 0L, (HashMap)localObject4, "");
          localObject1 = ((SharedPreferences)localObject2).edit();
          ((SharedPreferences.Editor)localObject1).clear();
          ((SharedPreferences.Editor)localObject1).commit();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("QQAppInterface", 1, "Failed to report pull Msf Event");
        return;
      }
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(getCurrentAccountUin(), "pullMsfReportOther_V3", false, 0L, 0L, localHashMap, "");
      continue;
      label946:
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(getCurrentAccountUin(), "pullMsfReport_succOther_V2", false, 0L, 0L, (HashMap)localObject4, "");
    }
  }
  
  public void onNetNeedSignon(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "checkIfNeedSignonNet onNetNeedSignon() called url:" + paramString);
    }
    MqqHandler localMqqHandler = getHandler(Conversation.class);
    if (localMqqHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.obj = paramString;
      localMessage.arg1 = 2;
      localMessage.what = 1134024;
      localMqqHandler.sendMessage(localMessage);
    }
  }
  
  public void onProcPause()
  {
    super.onProcPause();
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onProcPause");
    }
    refreshAppBadge();
  }
  
  public void onProcResume()
  {
    super.onProcResume();
  }
  
  public void onProxyIpChanged() {}
  
  public boolean onReceiveUnhandledKickedMsg(String paramString, Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!GuardManager.jdField_a_of_type_Boolean)
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT > 28)
      {
        bool1 = bool2;
        if ("mqq.intent.action.ACCOUNT_KICKED".equals(paramString))
        {
          bool1 = true;
          setKickIntent(paramIntent);
          showKickedNotification(paramIntent);
        }
      }
    }
    return bool1;
  }
  
  public void onRecvFistResp()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onRecvFistResp");
    }
    this.isMSFConnect = true;
    MqqHandler localMqqHandler = getHandler(Conversation.class);
    if (!awth.a().c())
    {
      awth.a().a(2);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(1134012, null).sendToTarget();
      }
    }
    for (;;)
    {
      if (localMqqHandler != null)
      {
        Message localMessage = Message.obtain();
        localMessage.arg1 = 0;
        localMessage.what = 1134024;
        localMqqHandler.sendMessage(localMessage);
      }
      return;
      if ((awth.a().a()) && (localMqqHandler != null)) {
        localMqqHandler.obtainMessage(1134015, null).sendToTarget();
      }
    }
  }
  
  public void onRunningBackground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onRunningBackground");
    }
    super.onRunningBackground();
    if (banp.a().a()) {
      banp.a().b("main process onRunningBackground");
    }
    onRunningBackgroundDoReportForReadInJoy();
    refreshAppBadge();
    if (this.proxyManager != null) {
      this.proxyManager.saveNotify();
    }
    bdla.a(this);
    getFileTransferHandler().b();
    Object localObject = (baql)getManager(QQManagerFactory.QZONE_ALBUM_RED_TOUCH);
    if (localObject != null) {
      ((baql)localObject).c();
    }
    localObject = (MediaPlayerManager)this.managers[QQManagerFactory.MGR_MEDIA_PLAYER];
    if ((localObject != null) && (((MediaPlayerManager)localObject).a())) {
      ((MediaPlayerManager)localObject).a(false);
    }
    cancelSyncOnlineFriend(-1L);
    checkDialogOnBackground();
    antk.a(BaseApplicationImpl.getContext());
    antc.a(BaseApplicationImpl.getContext());
    bdll.a(BaseApplicationImpl.getContext());
    LpReportManager.getInstance().startReportImediately(2);
    oez.a().a();
    avqs.a().b();
    bdaa.a(this);
    lmt.a(this);
    aooe.a();
    azjg.b();
    JobReporter.reportThreadPeakCount(getCurrentAccountUin());
    pwb.i();
    try
    {
      aonm.a().a();
      bdkc.a().b();
      UserguideActivity.a();
      aczy.a().a(this);
      ArkStateCenter.getInstance().setForeground(false);
      localObject = (awtm)getManager(QQManagerFactory.PUSH_NOTICE_MANAGER);
      if (localObject != null) {
        ((awtm)localObject).a();
      }
      long l = bhhr.e();
      if (System.currentTimeMillis() - l > 14400000L)
      {
        localObject = (WebProcessManager)getManager(QQManagerFactory.WEBPROCESS_MANAGER);
        if (localObject != null)
        {
          ((WebProcessManager)localObject).a(204);
          bhhr.c(System.currentTimeMillis());
          if (QLog.isColorLevel()) {
            QLog.d("QQAppInterface", 2, "check update x5");
          }
        }
      }
      sgy.a();
      checkRamForAvideo();
      tmz.a(true);
      MiniAppReportManager.onEnterBackground();
      bdms.a();
      bdmd.a(this);
      localObject = (anyb)getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      if (localObject != null) {
        ((anyb)localObject).j();
      }
      localObject = (ncz)getManager(QQManagerFactory.AV_GAME_MANAGER);
      if (localObject != null) {
        ((ncz)localObject).a();
      }
      bdkh.b();
      QCircleReportHelper.getInstance().onEnterBackground();
      localObject = (PhoneContactManagerImp)getManager(QQManagerFactory.CONTACT_MANAGER);
      if (localObject != null) {
        ((PhoneContactManagerImp)localObject).d();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onRunningForeground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onRunningForeground");
    }
    super.onRunningForeground();
    if (banp.a().a()) {
      banp.a().a("main process onRunningForeground");
    }
    bdla.b(this, "CliOper", "", "", "0X8004014", "0X8004014", 0, 0, "", "", "", "");
    Object localObject = getMessageFacade();
    if ((localObject != null) && (((QQMessageFacade)localObject).getUnreadMsgsNum() > 1)) {
      bdla.b(this, "CliOper", "", "", "0X8004015", "0X8004015", 0, 0, "", "", "", "");
    }
    if (tlx.a())
    {
      tlx.a().a(this, NetConnInfoCenter.getServerTimeMillis());
      tlx.a().a(2);
    }
    bdla.a(this, false);
    blyp.a();
    localObject = new Intent("com.tencent.intent.QZONE_PRE_DOWNLOAD_CANCEL");
    BaseApplication.getContext().sendBroadcast((Intent)localObject);
    localObject = (PhoneContactManagerImp)getManager(QQManagerFactory.CONTACT_MANAGER);
    if (localObject != null) {
      ((PhoneContactManagerImp)localObject).c();
    }
    localObject = (bcvc)getManager(QQManagerFactory.GAMECENTER_MANAGER);
    if (localObject != null)
    {
      ((bcvc)localObject).b();
      if (isLogin())
      {
        ((bbbq)getManager(QQManagerFactory.MGR_RED_TOUCH)).a();
        ((aocj)getBusinessHandler(BusinessHandlerFactory.REDPOINT_HANDER)).a(false, true, 2);
      }
    }
    localObject = (ArkAppCenter)getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
    if (localObject != null) {
      ((ArkAppCenter)localObject).a();
    }
    localObject = (awzb)getManager(QQManagerFactory.QZONE_MANAGER);
    if (localObject != null)
    {
      if (((awzb)localObject).a() > 0) {
        ((awzb)localObject).a(((awzb)localObject).a());
      }
      ((awzb)localObject).a(2);
    }
    QCircleEeveeMananger.getInstance().onSend(2, null, null);
    QCirclePreLoadManager.getInstance().requestWhiteList(getCurrentUin());
    startAllSubMessageAccountMsg(false);
    localObject = (bdxj)getManager(QQManagerFactory.SUB_ACCOUNT_CONTROLL);
    if ((localObject != null) && (((bdxj)localObject).jdField_a_of_type_Boolean))
    {
      bdxj.a(this, true);
      ((bdxj)localObject).jdField_a_of_type_Boolean = false;
    }
    akrl.a(this, false);
    bhgy.a(getApp().getBaseContext());
    localObject = (aohe)getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
    afno localafno = (afno)getManager(QQManagerFactory.QQ_NOTIFY_MANAGER);
    if (localObject != null)
    {
      ((aohe)localObject).a();
      localafno.a();
    }
    StatisticCollector.getInstance(BaseApplicationImpl.sApplication).reportDailyUser(this);
    syncOnlineFriend();
    QQToast.a(true);
    QWalletHelper.getPayCode(this);
    localObject = (aktz)getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
    if (localObject != null) {
      ((aktz)localObject).a(4);
    }
    if ((isLogin()) && (Build.VERSION.SDK_INT >= 23) && (this.isRealSwitchToBackground)) {
      checkBackgroundRestricWhilteList();
    }
    localObject = getNowLiveManager();
    if ((localObject != null) && (((nyv)localObject).jdField_a_of_type_Boolean) && ((BaseActivity.sTopActivity instanceof SplashActivity)) && (SplashActivity.jdField_a_of_type_Int == 1)) {
      ykv.a("story_tab", "exp", 0, ((ntq)getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).b(), new String[] { "", "", "", "" });
    }
    pwb.f();
    bhpw.a();
    ((onx)getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER)).a();
    ThreadManager.executeOnFileThread(new QQAppInterface.19(this));
    QLog.d("QQAppInterface", 2, "**davorteng**onRunningForeground...");
    localObject = (abgm)getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    if (localObject != null) {
      ((abgm)localObject).c();
    }
    ampa.a().a(this);
    sgy.b();
    ArkStateCenter.getInstance().setForeground(true);
    MiniAppReportManager.onEnterForeground();
    AppBrandLaunchManager.g().onEnterForeground();
    QCircleReportHelper.getInstance().onEnterForeground();
    avGameOnEnterForeground();
    onLineStatusOnAppForeground();
    ames.a(2);
  }
  
  public void onUploadRomingSettingsFinish(boolean paramBoolean1, boolean paramBoolean2)
  {
    bhhi localbhhi = (bhhi)getManager(QQManagerFactory.MGR_TROOP_FILTER);
    if (localbhhi != null) {
      localbhhi.b(paramBoolean1, paramBoolean2);
    }
  }
  
  public void onWeakNet() {}
  
  public void onWeakNet(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onWeakNet message: " + paramString);
    }
  }
  
  public void onX2Mobile()
  {
    int i = 2131691226;
    if ((this.app != null) && (isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "onX2Mobile ");
      }
      localObject1 = getTransFileController();
      bool1 = ((TransFileController)localObject1).pauseAllRawSend();
      bool2 = ((TransFileController)localObject1).pauseAllShortVideoSend();
      bool3 = ((TransFileController)localObject1).pauseAllShortVideoReceive();
      localObject2 = BaseActivity.sTopActivity;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.app;
      }
      if ((bool1) || (bool2) || (bool3))
      {
        localObject2 = new Intent((Context)localObject1, DialogActivity.class);
        ((Intent)localObject2).addFlags(268435456);
        ((Intent)localObject2).addFlags(536870912);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).addFlags(131072);
        if (!bool2) {
          break label303;
        }
        if (!bool3) {
          break label292;
        }
      }
    }
    label292:
    label303:
    while (!QLog.isColorLevel())
    {
      Object localObject1;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      Object localObject2;
      i = 2131691227;
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("QQAppInterface", 2, "onX2Mobile==============pauseAllRawSendC2C:" + bool1);
          QLog.d("QQAppInterface", 2, "onX2Mobile==============pauseAllShortVideoSend:" + bool2);
          QLog.d("QQAppInterface", 2, "onX2Mobile==============pauseAllShortVideoReceive:" + bool3);
          QLog.d("QQAppInterface", 2, "onX2Mobile==============dialog message:" + ((Context)localObject1).getResources().getString(i));
        }
        ((Intent)localObject2).putExtra("key_dialog_msg_id", i);
        ((Context)localObject1).startActivity((Intent)localObject2);
        return;
        if (!bool1)
        {
          i = 2131691224;
          continue;
          if (bool3)
          {
            if (!bool1) {
              i = 2131691222;
            }
          }
          else {
            i = 2131691225;
          }
        }
      }
    }
    QLog.d("QQAppInterface", 2, "onX2Mobile app = null,maybe not QQ process");
  }
  
  public void onX2Wifi()
  {
    if (this.app != null) {
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "onX2Wifi ");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QQAppInterface", 2, "onX2Wifi app = null,maybe not QQ process");
  }
  
  public void oneWayMessageNotifyVibert(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    String str1;
    String str2;
    Bitmap localBitmap;
    QQMessageFacade.Message localMessage;
    Intent localIntent;
    int i;
    if ((1010 == paramMessageRecord.istroop) || (1001 == paramMessageRecord.istroop) || (10002 == paramMessageRecord.istroop))
    {
      boolean bool = ((KeyguardManager)this.app.getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
      String str3 = "";
      str1 = "";
      str2 = "";
      localBitmap = null;
      localMessage = new QQMessageFacade.Message();
      MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
      if ((!this.isBackgroundPause) && (!this.isBackgroundStop) && (!bool)) {
        break label703;
      }
      localIntent = new Intent(getApp(), MsgBoxListActivity.class);
      localIntent.addFlags(335544320);
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "OneWayMessageNotifyVibert mr.frienduin" + paramMessageRecord.frienduin + ", mr.istroop" + paramMessageRecord.istroop);
      }
      if (1010 != paramMessageRecord.istroop) {
        break label577;
      }
      localIntent.putExtra("uin", AppConstants.DATE_UIN);
      localIntent.putExtra("uintype", paramMessageRecord.istroop);
      localIntent.setAction("com.tencent.mobileqq.action.CHAT");
      localIntent.putExtra("uinname", "");
      localIntent.putExtra("entrance", 6);
      localIntent.putExtra("key_notification_click_action", true);
      if (paramMessageRecord.istroop != 1001)
      {
        localObject = str3;
        if (paramMessageRecord.istroop != 10002) {}
      }
      else
      {
        localBitmap = bhbd.a(getApp().getResources().getDrawable(2130840438));
        localObject = BaseApplicationImpl.getApplication();
        if (paramMessageRecord.istroop != 1001) {
          break label641;
        }
        i = 2131693466;
        label314:
        str1 = ((BaseApplicationImpl)localObject).getString(i);
        localObject = BaseApplicationImpl.getApplication();
        if (paramMessageRecord.istroop != 1001) {
          break label648;
        }
        i = 2131693465;
        label341:
        str2 = ((BaseApplicationImpl)localObject).getString(i);
        localIntent.putExtra("key_notifycation_oneway_message", true);
        localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayLBSFriendMsgNotifyCfg.name());
        if (((String)localObject).length() <= 0) {
          break label723;
        }
        localObject = ((String)localObject).split("\\|");
        if (localObject.length < 6) {
          break label723;
        }
        str1 = localObject[4];
        str2 = localObject[5];
      }
    }
    label562:
    label577:
    label723:
    for (Object localObject = str2;; localObject = str2)
    {
      anyy.a(this, paramMessageRecord, new aosm(localIntent, (String)localObject, str1, str2, localBitmap), "CMD_SHOW_NOTIFIYCATION");
      if (bhgy.a(getApp()))
      {
        paramMessageRecord = (awto)getManager(QQManagerFactory.QQLS_DATA_MANAGER);
        if (SettingCloneUtil.readValue(getApp(), getCurrentAccountUin(), getApp().getString(2131693714), "qqsetting_lock_screen_whenexit_key", true))
        {
          if (1001 != localMessage.istroop) {
            break label655;
          }
          paramMessageRecord.a(this, AppConstants.LOCK_SCREEN_LBS_HELLO_UIN, localMessage.istroop, false, awtk.a(localMessage.frienduin, localMessage.istroop, localIntent));
          bdla.b(this, "dc00899", "grp_lbs", "", "msg_box", "notice_msg", 0, 0, "", "", "", "");
        }
      }
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        vibratorAndAudio(localMessage, paramBoolean, true);
        return;
        if ((1001 != paramMessageRecord.istroop) && (10002 != paramMessageRecord.istroop)) {
          break;
        }
        localObject = AppConstants.LBS_HELLO_UIN;
        if (!aryo.b(paramMessageRecord)) {
          localObject = AppConstants.NEARBY_LBS_HELLO_UIN;
        }
        localIntent.putExtra("uin", (String)localObject);
        localIntent.putExtra("uintype", paramMessageRecord.istroop);
        break;
        i = 2131719461;
        break label314;
        i = 2131719460;
        break label341;
        if (1010 != localMessage.istroop) {
          break label562;
        }
        paramMessageRecord.a(this, AppConstants.LOCK_SCREEN_DATE_UIN, localMessage.istroop, false, awtk.a(localMessage.frienduin, localMessage.istroop, localIntent));
        break label562;
      }
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        vibratorAndAudio(localMessage, paramBoolean, true);
        return;
      }
    }
  }
  
  public void playThemeVoice(int paramInt)
  {
    execute(new QQAppInterface.13(this, paramInt));
  }
  
  public void putBitmapToCache(String paramString, Bitmap paramBitmap, byte paramByte)
  {
    if (this.faceIconCache != null)
    {
      this.faceIconCache.put(paramString, paramBitmap, paramByte);
      if (this.faceTimestamps != null) {
        this.faceTimestamps.put(paramString, Long.valueOf(System.currentTimeMillis()));
      }
    }
  }
  
  public Setting queryFromCache(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!this.isFaceSettingCached) {
      return null;
    }
    return (Setting)this.faceSettingCache.get(paramString);
  }
  
  public int readCallTabStateVal(int paramInt)
  {
    int j = -1;
    int i;
    if ((this.app == null) || (paramInt < 0) || (paramInt >= 7))
    {
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.e("QQAppInterface", 2, "readCallTabStateVal wrong index," + paramInt);
        i = j;
      }
    }
    do
    {
      String str;
      do
      {
        return i;
        str = SettingCloneUtil.readValue(getApplication(), getCurrentAccountUin(), null, "qqsetting_calltab_show_key", "0111100");
        if ((str != null) && (str.length() == 7)) {
          break;
        }
        i = j;
      } while (!QLog.isColorLevel());
      QLog.e("QQAppInterface", 2, "readCallTabStateVal val is null");
      return -1;
      j = str.charAt(paramInt) - '0';
      i = j;
    } while (!QLog.isColorLevel());
    QLog.i("QQAppInterface", 2, "uin:" + getCurrentAccountUin() + ",readCallTabStateVal index=" + paramInt + ", resut=" + j);
    return j;
  }
  
  public void receiveToService(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    aopp localaopp;
    if (this.mqqService != null)
    {
      this.mqqService.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
      if (AppSetting.c()) {
        localaopp = getParcelHooker();
      }
    }
    try
    {
      localaopp.a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    catch (Throwable paramToServiceMsg)
    {
      QLog.e("QQAppInterface", 1, "receiveToService: ", paramToServiceMsg);
    }
  }
  
  public boolean recordingPttStopped()
  {
    return (this.checkPttListener == null) || (!this.checkPttListener.isRecordingOrPlaying());
  }
  
  public void refreshApolloFaceWithTimeStamp(String paramString, int paramInt, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L)) {}
    long l;
    do
    {
      do
      {
        do
        {
          return;
          localObject = getQQHeadSetting(116, paramString, 200);
        } while ((localObject == null) || (((Pair)localObject).second == null));
        l = ((Setting)((Pair)localObject).second).headImgTimestamp;
      } while (l == paramLong);
      Object localObject = (FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      if (localObject != null) {
        ((FriendListHandler)localObject).getApolloHead(paramString, (byte)1, (byte)0, paramInt);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqhead.qaif", 2, "refreshApolloFaceWithTimeStamp id=" + paramString + ", sizeType =" + paramInt + ", timestamp=" + paramLong + ",headImgTimestamp=" + l);
  }
  
  public void refreshAppBadge()
  {
    if (((this.isBackgroundPause) || (this.isBackgroundStop)) && (bkxs.a(this.app.getApplicationContext())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "refreshAppBadge");
      }
      this.badgeHelper.refreshAppBadge();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QQAppInterface", 2, "refreshAppBadge fail cause isBackground_Pause = " + this.isBackgroundPause + ", isBackground_Stop = " + this.isBackgroundStop + ", isSupportBadge + " + bkxs.a(this.app.getApplicationContext()));
  }
  
  public void refreshFace(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    FriendListHandler localFriendListHandler;
    do
    {
      return;
      localFriendListHandler = (FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    } while (localFriendListHandler == null);
    if (paramString.startsWith("+"))
    {
      localFriendListHandler.getMobileQQHead(paramString);
      return;
    }
    localFriendListHandler.getCustomHead(paramString);
  }
  
  public void refreshMsgTabUnreadNum(boolean paramBoolean, int paramInt)
  {
    if (this.mMsgTabUnreadListener != null) {
      this.mMsgTabUnreadListener.a(paramBoolean, paramInt);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("QQAppInterface", 2, String.format(Locale.getDefault(), "refreshMsgTabUnreadNum mMsgTabUnreadListener is null, [%b, %d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
  }
  
  public void refreshMultiAIOUnreadNum(String paramString, int paramInt)
  {
    if (this.mMultiAIOUnreadListener != null) {
      this.mMultiAIOUnreadListener.a(paramString, paramInt);
    }
  }
  
  public void refreshQCallFace(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.qaif", 2, "refreshQCallFace id=" + paramString + ", idtype =" + paramInt + ", delLocalCache =" + paramBoolean);
    }
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((paramInt != 200) && (paramInt != 204) && (paramInt != 202));
      if (paramBoolean)
      {
        removeFaceIconCache(16, paramString, paramInt);
        localObject = new File(getCustomFaceFilePath(16, paramString, paramInt));
        if ((localObject != null) && (((File)localObject).exists())) {
          ((File)localObject).delete();
        }
      }
      localObject = (FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    } while (localObject == null);
    ((FriendListHandler)localObject).getQCallHead(paramString, paramInt, (byte)1, (byte)0);
  }
  
  public void refreshQCallFaceWithTimeStamp(String paramString, int paramInt, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L)) {}
    label13:
    long l;
    do
    {
      do
      {
        do
        {
          break label13;
          do
          {
            return;
          } while ((paramInt != 200) && (paramInt != 204) && (paramInt != 202));
          localObject = getQQHeadSetting(16, paramString, paramInt);
        } while ((localObject == null) || (((Pair)localObject).second == null));
        l = ((Setting)((Pair)localObject).second).headImgTimestamp;
      } while (l == paramLong);
      Object localObject = (FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      if (localObject != null) {
        ((FriendListHandler)localObject).getStrangerHead(paramString, paramInt, (byte)1, (byte)0);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqhead.qaif", 2, "refreshQCallFaceWithTimeStamp id=" + paramString + ", idtype =" + paramInt + ", timestamp=" + paramLong + ",headImgTimestamp=" + l);
  }
  
  public void refreshStrangerFace(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.", 2, "refreshStrangerFace.id=" + paramString + ",idType=" + paramInt + ",delLocalCache=" + paramBoolean);
    }
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((paramInt != 200) && (paramInt != 204) && (paramInt != 202));
      if (paramBoolean)
      {
        removeFaceIconCache(32, paramString, paramInt);
        localObject = new File(getCustomFaceFilePath(32, paramString, paramInt));
        if ((localObject != null) && (((File)localObject).exists())) {
          ((File)localObject).delete();
        }
      }
      localObject = (FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    } while (localObject == null);
    ((FriendListHandler)localObject).getStrangerHead(paramString, paramInt, (byte)1, (byte)0);
  }
  
  public void refreshStrangerFaceWithTimeStamp(String paramString, int paramInt, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L)) {}
    label13:
    long l;
    do
    {
      do
      {
        do
        {
          break label13;
          do
          {
            return;
          } while ((paramInt != 200) && (paramInt != 204) && (paramInt != 202));
          localObject = getQQHeadSetting(32, paramString, paramInt);
        } while ((localObject == null) || (((Pair)localObject).second == null));
        l = ((Setting)((Pair)localObject).second).headImgTimestamp;
      } while (l == paramLong);
      Object localObject = (FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      if (localObject != null) {
        ((FriendListHandler)localObject).getStrangerHead(paramString, paramInt, (byte)1, (byte)0);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqhead.qaif", 2, "refreshStrangerFaceWithTimeStamp id=" + paramString + ", idtype =" + paramInt + ", timestamp=" + paramLong + ",headImgTimestamp=" + l);
  }
  
  public void refreshTroopFace(String paramString)
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (localFriendListHandler != null) {
      localFriendListHandler.getTroopHead(paramString);
    }
  }
  
  public void registerBatteryBroadcastReceiver()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "registerBatteryBroadcastReceiver start");
    }
    try
    {
      if ((this.mBatteryBroadcastReceiver == null) && (getOnlineStatusNonSync() == AppRuntime.Status.online) && (getExtOnlineStatus() == 1000L))
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        this.mBatteryBroadcastReceiver = new BatteryBroadcastReceiver(this);
        BaseApplicationImpl.getContext().registerReceiver(this.mBatteryBroadcastReceiver, localIntentFilter);
        if (QLog.isColorLevel()) {
          QLog.d("QQAppInterface", 2, "registerBatteryBroadcastReceiver success");
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQAppInterface", 1, localThrowable, new Object[] { "registerBatteryBroadcastReceiver fail" });
    }
  }
  
  public void releaseAvAddFriendService()
  {
    if (this.mAvAddFriendService != null)
    {
      this.mAvAddFriendService.a();
      this.mAvAddFriendService = null;
    }
  }
  
  public void removeAboutListener(ResourcePluginListener paramResourcePluginListener)
  {
    if (this.aboutConfig != null) {
      this.aboutConfig.b(paramResourcePluginListener);
    }
  }
  
  public void removeBitmapFromCache(String paramString)
  {
    if (this.faceIconCache != null) {
      this.faceIconCache.remove(paramString);
    }
    if (this.faceTimestamps != null) {
      this.faceTimestamps.remove(paramString);
    }
  }
  
  public void removeFaceIconCache(int paramInt1, String paramString, int paramInt2)
  {
    int i = 0;
    paramString = getFaceBitmapCacheKey(paramInt1, paramString, (byte)0, paramInt2);
    paramInt1 = i;
    while (paramInt1 <= 5)
    {
      String str = paramString + "_" + paramInt1;
      this.faceIconCache.remove(str);
      paramInt1 += 1;
    }
  }
  
  public void removeFaceIconCacheApollo(int paramInt1, String paramString, int paramInt2)
  {
    int[] arrayOfInt1 = asmi.c;
    int j = arrayOfInt1.length;
    paramInt2 = 0;
    while (paramInt2 < j)
    {
      int k = arrayOfInt1[paramInt2];
      int[] arrayOfInt2 = asmi.d;
      int m = arrayOfInt2.length;
      int i = 0;
      while (i < m)
      {
        String str = getFaceBitmapCacheKey(paramInt1, paramString, (byte)arrayOfInt2[i], 200, k, false);
        this.faceIconCache.remove(str);
        i += 1;
      }
      paramInt2 += 1;
    }
  }
  
  public void removeLebaListener(ResourcePluginListener paramResourcePluginListener)
  {
    if (this.mLebaHelper != null) {
      this.mLebaHelper.b(paramResourcePluginListener);
    }
  }
  
  public void removeNotification()
  {
    ThreadManager.post(new QQAppInterface.10(this), 10, null, true);
    try
    {
      sendToService(new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "CMD_STOP_NOTIFIYCATION"));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void removeObserver(BusinessObserver paramBusinessObserver)
  {
    synchronized (this.uiObservers)
    {
      this.uiObservers.remove(paramBusinessObserver);
      synchronized (this.bgObservers)
      {
        this.bgObservers.remove(paramBusinessObserver);
      }
    }
    synchronized (this.defaultObservers)
    {
      this.defaultObservers.remove(paramBusinessObserver);
      return;
      paramBusinessObserver = finally;
      throw paramBusinessObserver;
      paramBusinessObserver = finally;
      throw paramBusinessObserver;
    }
  }
  
  public void removeVibrateListener(aogp paramaogp)
  {
    if (paramaogp == null) {
      return;
    }
    this.vibrateListenerList.remove(paramaogp);
  }
  
  public void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    bdla.b(this, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void reportClickEventRuntime(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    bdla.a(this, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void sendOnlineStatus(AppRuntime.Status paramStatus, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    super.sendOnlineStatus(paramStatus, paramBoolean1, paramLong, paramBoolean2);
  }
  
  public void sendOnlineStatusWithExt(AppRuntime.Status paramStatus, boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2)
  {
    super.sendOnlineStatusWithExt(paramStatus, paramBoolean1, paramLong1, paramBoolean2, paramLong2);
  }
  
  public void sendQQHeadBroadcast(int paramInt1, String arg2, int paramInt2, String arg4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.broadcast", 2, "sendQQHeadBroadcast.type=" + paramInt1 + ",uin=" + ??? + ",idType=" + paramInt2 + ",path=" + ???);
    }
    if (!this.headQQHeadBroadcastTable.containsKey(???)) {
      return;
    }
    synchronized (this.headQQHeadBroadcastTable)
    {
      this.headQQHeadBroadcastTable.remove(???);
      if (paramInt1 != 1) {}
    }
    Object localObject;
    for (;;)
    {
      synchronized (this.sendUinList)
      {
        this.sendUinList.add(???);
        ??? = this.qqHeadBroadcastHandler.obtainMessage();
        ???.what = 990;
        this.qqHeadBroadcastHandler.sendMessageDelayed(???, 500L);
        if (this.headQQHeadBroadcastTable.size() <= 50) {
          break;
        }
        synchronized (this.headQQHeadBroadcastTable)
        {
          long l = System.currentTimeMillis();
          ??? = new ArrayList();
          localObject = this.headQQHeadBroadcastTable.keys();
          if (!((Enumeration)localObject).hasMoreElements()) {
            break label459;
          }
          String str = (String)((Enumeration)localObject).nextElement();
          if (Math.abs(l - ((Long)this.headQQHeadBroadcastTable.get(str)).longValue()) <= 180000L) {
            continue;
          }
          ???.add(str);
        }
        ??? = finally;
        throw ???;
      }
      if (paramInt1 == 4) {
        synchronized (this.sendTroopUinList)
        {
          this.sendTroopUinList.add(???);
          ??? = this.qqHeadBroadcastHandler.obtainMessage();
          ???.what = 991;
          this.qqHeadBroadcastHandler.sendMessageDelayed(???, 500L);
        }
      }
      if (paramInt1 == 101) {
        synchronized (this.sendDisUinList)
        {
          this.sendDisUinList.add(???);
          ??? = this.qqHeadBroadcastHandler.obtainMessage();
          ???.what = 993;
          this.qqHeadBroadcastHandler.sendMessageDelayed(???, 500L);
        }
      }
      if (paramInt1 == 113) {
        synchronized (this.sendNewTroopUinList)
        {
          this.sendNewTroopUinList.add(???);
          ??? = this.qqHeadBroadcastHandler.obtainMessage();
          ???.what = 992;
          this.qqHeadBroadcastHandler.sendMessageDelayed(???, 500L);
        }
      }
    }
    label459:
    paramInt1 = 0;
    while (paramInt1 < ???.size())
    {
      localObject = (String)???.get(paramInt1);
      this.headQQHeadBroadcastTable.remove(localObject);
      paramInt1 += 1;
    }
  }
  
  public void sendRegisterPush()
  {
    boolean bool;
    long l3;
    AppRuntime.Status localStatus1;
    long l2;
    if (isAccLoginSuccess())
    {
      ((PushManager)getManager(5)).registProxyMessagePush(getAppid(), this.app.getPackageName() + ":video", "com.tencent.av.ui.VChatActivity", new String[] { "VideoSvc.Send", "VideoCCSvc.Adaptation", "SharpSvr.c2sack", "SharpSvr.s2c" });
      ((PushManager)getManager(5)).registProxyMessagePush(getAppid(), this.app.getPackageName() + ":nearby_video", "", new String[] { "VideoSvc.Send", "VideoCCSvc.Adaptation", "SharpSvr.c2sack", "SharpSvr.s2c" });
      bool = getCurLoginStatus();
      l3 = this.app.getSharedPreferences(getAccount(), 0).getInt("GetFrdListReq_seq", 0);
      AppRuntime.Status localStatus2 = getOnlineStatus();
      SharedPreferences localSharedPreferences = getApp().getSharedPreferences("acc_info" + getAccount(), 0);
      if ((localStatus2 != null) && (localStatus2 != AppRuntime.Status.offline))
      {
        localStatus1 = localStatus2;
        if (localStatus2 != AppRuntime.Status.receiveofflinemsg) {}
      }
      else
      {
        localStatus2 = AppRuntime.Status.build(localSharedPreferences.getInt("getProfileStatusNew", AppRuntime.Status.online.getValue()));
        if ((localStatus2 != null) && (localStatus2 != AppRuntime.Status.offline))
        {
          localStatus1 = localStatus2;
          if (localStatus2 != AppRuntime.Status.receiveofflinemsg) {}
        }
        else
        {
          localStatus1 = AppRuntime.Status.online;
          QLog.d("QQAppInterface", 1, "sendRegisterPush, change to online, status: " + localStatus1);
        }
      }
      if (localStatus1 != AppRuntime.Status.online) {
        break label484;
      }
      l2 = getExtOnlineStatus();
      l1 = l2;
      if (l2 == -1L)
      {
        l2 = localSharedPreferences.getLong("getOnlineStatusExt", -1L);
        l1 = l2;
        if (l2 == -1L) {
          QLog.d("QQAppInterface", 1, "sendRegisterPush, change to online, ext_status: " + l2);
        }
      }
    }
    label484:
    for (long l1 = l2;; l1 = -1L)
    {
      checkBatteryStatus();
      sendOnlineStatusWithExt(localStatus1, bool, l3, false, l1);
      this.mRegisterPushTime = NetConnInfoCenter.getServerTime();
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 4, String.format("sendRegisterPush onlineStatus: %s, isKickPC: %s, largeSeq: %s, mRegisterPushTime: %s", new Object[] { localStatus1, Boolean.valueOf(bool), Long.valueOf(l3), Long.valueOf(this.mRegisterPushTime) }));
      }
      return;
    }
  }
  
  public void sendSelfQQHeadBroadcast(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.broadcast", 2, "sendSelfQQHeadBroadcast.type=" + paramInt1 + ",uin=" + paramString1 + ",idType=" + paramInt2 + ",path=" + paramString2);
    }
    if (paramInt1 == 1) {}
    try
    {
      Intent localIntent = new Intent("com.tencent.qqhead.selfupdate");
      localIntent.putExtra("faceType", 1);
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("headPath", paramString2);
      getApp().sendBroadcast(localIntent, "com.tencent.qqhead.permission.getheadresp");
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("Q.qqhead.broadcast", 2, "sendSelfQQHeadBroadcast error", paramString1);
    }
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    if (this.mqqService != null) {
      this.mqqService.b(paramToServiceMsg);
    }
  }
  
  public void setALLGeneralSettingRing(int paramInt)
  {
    bhhi localbhhi = (bhhi)getManager(QQManagerFactory.MGR_TROOP_FILTER);
    if (localbhhi != null) {
      localbhhi.a("message.ring.switch", Integer.valueOf(paramInt));
    }
  }
  
  public void setALLGeneralSettingVibrate(int paramInt)
  {
    bhhi localbhhi = (bhhi)getManager(QQManagerFactory.MGR_TROOP_FILTER);
    if (localbhhi != null) {
      localbhhi.a("message.vibrate.switch", Integer.valueOf(paramInt));
    }
  }
  
  public void setAllTroopsReceiveStatus(boolean paramBoolean) {}
  
  public void setAutoLogin(boolean paramBoolean)
  {
    String str = "";
    if (!getCurrentAccountUin().equals("0")) {
      str = getCurrentAccountUin();
    }
    bhhr.a(getApplication().getApplicationContext(), str, paramBoolean);
  }
  
  public void setBatteryCapacity(int paramInt)
  {
    super.setBatteryCapacity(paramInt);
    if (paramInt != 0)
    {
      bhhr.v(this.app.getApplicationContext(), paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, new Object[] { "setBatteryCapacity, capacity:", Integer.valueOf(paramInt) });
      }
    }
  }
  
  public void setC2CRoamingSetting(int paramInt)
  {
    bhhi localbhhi = (bhhi)getManager(QQManagerFactory.MGR_TROOP_FILTER);
    if (localbhhi != null) {
      localbhhi.a("sync.c2c_message", Integer.valueOf(paramInt));
    }
  }
  
  public void setCheckPttListener(anrt paramanrt)
  {
    this.checkPttListener = paramanrt;
  }
  
  public void setCheckPtvListener(anru paramanru)
  {
    this.checkPtvListener = paramanru;
  }
  
  public void setExtOnlineStatus(long paramLong)
  {
    super.setExtOnlineStatus(paramLong);
    if (paramLong != -1L) {
      getApp().getSharedPreferences("acc_info" + getAccount(), 0).edit().putLong("getOnlineStatusExt", paramLong).apply();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, String.format("setExtOnlineStatus, status: %s", new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public void setLoadingState()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onConnOpenAndStartGetMsg");
    }
    awth.a().a(1);
    MqqHandler localMqqHandler = getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(1134014, null).sendToTarget();
    }
  }
  
  public void setLoudSpeakerState(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putBoolean(BaseApplication.getContext().getString(2131694754) + getCurrentAccountUin(), paramBoolean);
    localEditor.commit();
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "setLoudSpeakerState:" + paramBoolean);
    }
  }
  
  public void setMainActivityState(boolean paramBoolean)
  {
    this.mainActivityIsForeground = paramBoolean;
  }
  
  public void setMsgTabUnreadListener(anzg paramanzg)
  {
    this.mMsgTabUnreadListener = paramanzg;
    if (QLog.isColorLevel()) {
      QLog.i("QQAppInterface", 2, "setMsgTabUnreadListener lis: " + paramanzg);
    }
  }
  
  public void setMultiAIOUnreadListener(anzh paramanzh)
  {
    this.mMultiAIOUnreadListener = paramanzh;
  }
  
  public void setNotAllowedSeeMyDongtai(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).setDongtaiPermission(paramBoolean1, getCurrentAccountUin(), 1);
      return;
    }
    getPref().edit().putBoolean(getApp().getString(2131694319) + getCurrentAccountUin(), paramBoolean1).commit();
  }
  
  public void setOnlineStatus(AppRuntime.Status paramStatus)
  {
    try
    {
      super.setOnlineStatus(paramStatus);
      if ((paramStatus != null) && (paramStatus != AppRuntime.Status.offline) && (paramStatus != AppRuntime.Status.receiveofflinemsg)) {
        getApp().getSharedPreferences("acc_info" + getAccount(), 0).edit().putInt("getProfileStatusNew", paramStatus.getValue()).apply();
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, String.format("setOnlineStatus, status: %s", new Object[] { paramStatus }));
      }
      return;
    }
    finally {}
  }
  
  public void setPhoneNumSearchable(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((anri)getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(paramBoolean1);
      return;
    }
    getPref().edit().putBoolean(getApp().getString(2131694744) + getCurrentAccountUin(), paramBoolean1).commit();
  }
  
  public void setPowerConnect(int paramInt)
  {
    super.setPowerConnect(paramInt);
    if (paramInt != -1)
    {
      bhhr.w(this.app.getApplicationContext(), paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, new Object[] { "setPowerConnect, powerConnect: %s", Integer.valueOf(paramInt) });
      }
    }
  }
  
  public void setSecDetBannerIntent(Intent paramIntent)
  {
    this.mSecurityDetectBannerIntent = paramIntent;
  }
  
  public void setShieldHisDongtai(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).setDongtaiPermission(paramBoolean1, getCurrentAccountUin(), 2);
      return;
    }
    getPref().edit().putBoolean(getApp().getString(2131718806) + getCurrentAccountUin(), paramBoolean1).commit();
  }
  
  public void setSig(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (this.mSig == null) {
      this.mSig = new SigInfo();
    }
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      this.mSig.sessionKey = new byte[paramArrayOfByte1.length];
      System.arraycopy(paramArrayOfByte1, 0, this.mSig.sessionKey, 0, paramArrayOfByte1.length);
      this.mSig.signature = new byte[paramArrayOfByte2.length];
      System.arraycopy(paramArrayOfByte2, 0, this.mSig.signature, 0, paramArrayOfByte2.length);
      this.mSig.wSignatureLen = ((short)this.mSig.signature.length);
    }
  }
  
  @TargetApi(14)
  public void setTalkbackSwitch()
  {
    try
    {
      Object localObject = (AccessibilityManager)this.app.getSystemService("accessibility");
      bool1 = ((AccessibilityManager)localObject).isEnabled();
      boolean bool2 = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
      if ((!bool1) || (!bool2)) {
        break label187;
      }
      bool1 = true;
      AppSetting.c = bool1;
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "set talkback enable: " + AppSetting.c);
      }
      if (AppSetting.c)
      {
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences("Talkback", 0);
        long l = ((SharedPreferences)localObject).getLong("LastTime", 0L);
        if (System.currentTimeMillis() - l > 86400000L)
        {
          StatisticCollector.getInstance(this.app).collectPerformance(null, "enableTalkback", true, 0L, 0L, null, null);
          ((SharedPreferences)localObject).edit().putLong("LastTime", System.currentTimeMillis()).commit();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      boolean bool1;
      label160:
      label187:
      break label160;
    }
    if (AppSetting.c) {
      if (sTts == null) {
        sTts = new TextToSpeech(BaseApplicationImpl.sApplication, null);
      }
    }
    while (sTts == null)
    {
      return;
      bool1 = false;
      break;
    }
    sTts.stop();
    sTts = null;
  }
  
  public void setTroopGeneralSettingRing(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoundSetting", 2, "setTroopGeneralSettingRing :" + paramInt);
    }
    bhhi localbhhi = (bhhi)getManager(QQManagerFactory.MGR_TROOP_FILTER);
    if (localbhhi != null) {
      localbhhi.a("message.group.ring", Integer.valueOf(paramInt));
    }
  }
  
  public void setTroopGeneralSettingVibrate(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoundSetting", 2, "setTroopGeneralSettingVibrate :" + paramInt);
    }
    bhhi localbhhi = (bhhi)getManager(QQManagerFactory.MGR_TROOP_FILTER);
    if (localbhhi != null) {
      localbhhi.a("message.group.vibrate", Integer.valueOf(paramInt));
    }
  }
  
  public void setTroopMsgFilterToServer(String paramString, Integer paramInteger)
  {
    bhhi localbhhi = (bhhi)getManager(QQManagerFactory.MGR_TROOP_FILTER);
    if (localbhhi != null)
    {
      String str = bhhi.a(paramString, 1);
      if (QLog.isColorLevel()) {
        QLog.d("RoamSetting", 2, "setTroopMsgFilterToServer, path=" + str + " value=" + paramInteger);
      }
      localbhhi.a(str, paramInteger);
      awtz.a().c(this, paramString);
    }
  }
  
  public void setVisibilityForInputStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((avrf)getBusinessHandler(BusinessHandlerFactory.INPUT_STATUS_HANDLER)).a(paramBoolean1);
      return;
    }
    getPref().edit().putBoolean(getApp().getString(2131718888) + getCurrentAccountUin(), paramBoolean1).apply();
  }
  
  public void setVisibilityForNetWorkStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).setVisibilityForNetWorkStatus(paramBoolean1);
      return;
    }
    getPref().edit().putBoolean(getApp().getString(2131718889) + getCurrentAccountUin(), paramBoolean1).commit();
  }
  
  public void setVisibilityForStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      getPref().edit().putBoolean(getApp().getString(2131694746) + getCurrentAccountUin(), paramBoolean1).commit();
      return;
    }
    ((anxi)getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).a(paramBoolean1);
  }
  
  public void setZanAllowed(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.mTryTimeForNear = 1;
    }
    for (;;)
    {
      ((anri)getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(paramBoolean1, paramBoolean2);
      return;
      this.mTryTimeForStatus = 1;
    }
  }
  
  public Bitmap shield(Bitmap paramBitmap)
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(this.app.getResources(), 2130850473);
      if (localBitmap != null) {
        new Canvas(paramBitmap).drawBitmap(localBitmap, paramBitmap.getWidth() - localBitmap.getWidth() - 1, paramBitmap.getHeight() - localBitmap.getHeight() - 1, new Paint());
      }
      return paramBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
        Object localObject1 = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject2 = null;
      }
    }
  }
  
  public void showIdleNotification(Context paramContext, Class<?> paramClass)
  {
    if (!isOpenNoClearNotification()) {}
    do
    {
      do
      {
        return;
      } while (paramContext == null);
      if (paramClass != null) {
        break label246;
      }
      if (!(paramContext instanceof Activity)) {
        break;
      }
      paramClass = new Intent(this.app.getApplicationContext(), paramContext.getClass());
      paramContext = ((Activity)paramContext).getIntent().getExtras();
      if (paramContext != null)
      {
        paramContext.remove("single");
        paramContext.remove("selfuin");
        paramClass.putExtras(paramContext);
      }
      paramClass.putExtra("fromNotification", true);
      paramClass.addFlags(536870912).addFlags(67108864);
    } while (!isAccLoginSuccess());
    Object localObject1 = getCurrentAccountUin();
    Object localObject2 = null;
    Friends localFriends = ((anvk)getManager(QQManagerFactory.FRIENDS_MANAGER)).e((String)localObject1);
    if (localFriends != null)
    {
      localObject2 = getFaceBitmap(1, localFriends.uin, (byte)3, true, 0);
      paramContext = (Context)localObject2;
      if (localObject2 == null) {
        paramContext = bheg.a();
      }
      if ((localFriends.name != null) && (localFriends.name.length() > 0))
      {
        localObject2 = localFriends.name;
        localObject1 = paramContext;
        paramContext = (Context)localObject2;
      }
    }
    for (;;)
    {
      showNotificationWithoutMessage(new aosm(paramClass, "", paramContext, this.app.getString(2131718140), (Bitmap)localObject1), "CMD_IDLE_NOTIFIYCATION");
      return;
      paramClass = new Intent(this.app.getApplicationContext(), SplashActivity.class);
      break;
      label246:
      paramClass = new Intent(this.app.getApplicationContext(), paramClass);
      break;
      localObject2 = paramContext;
      paramContext = (Context)localObject1;
      localObject1 = localObject2;
      continue;
      paramContext = (Context)localObject1;
      localObject1 = localObject2;
    }
  }
  
  void showNotificationWithoutMessage(aosm paramaosm, String paramString)
  {
    String str1 = paramaosm.b();
    Bitmap localBitmap = paramaosm.a();
    String str2 = paramaosm.c();
    String str3 = paramaosm.d();
    Intent localIntent = paramaosm.a();
    if (QLog.isColorLevel()) {
      QLog.d("[NotificationRebuild] notification", 2, "showNotificationWithoutMessage. cmd=" + paramString + ", ticker=" + bhbx.a(str1) + ",msgShow:" + bhbx.a(str3) + ", bitmap=" + localBitmap);
    }
    paramaosm = localBitmap;
    if (localBitmap == null) {
      paramaosm = bgyo.a(this.app.getResources(), 2130840422);
    }
    if (paramaosm != null)
    {
      paramString = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), paramString);
      paramString.extraData.putStringArray("cmds", new String[] { str1, str2, str3 });
      localIntent.putExtra("param_notifyid", 275);
      paramString.extraData.putParcelable("intent", localIntent);
      paramString.extraData.putParcelable("bitmap", paramaosm);
      sendToService(paramString);
    }
  }
  
  public void showReadedMsgNotification(QQMessageFacade.Message paramMessage1, QQMessageFacade.Message paramMessage2)
  {
    int i = this.msgFacade.msgNotifyManager.a().size();
    int j = this.msgFacade.msgNotifyManager.a();
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "showReadedMsgNotification, Messages size:" + i + ", counter:" + j);
    }
    bkyy localbkyy = bkyy.a(this);
    if ((paramMessage1 == null) || (i == 0) || (j == 0)) {
      cancelNotification();
    }
    for (;;)
    {
      if (isShowMsgContent()) {
        localbkyy.a(paramMessage2);
      }
      return;
      if (isShowMsgContent())
      {
        if ((paramMessage2 != null) && (bkyy.a(paramMessage2)))
        {
          if ((localbkyy != null) && (localbkyy.d(paramMessage2))) {
            showMessageNotificationWithPreview(paramMessage2, false);
          }
        }
        else {
          showMessageNotificationWithPreview(paramMessage1, false);
        }
      }
      else {
        showMessageNotificationNoPreview(paramMessage1, false);
      }
    }
  }
  
  public void start(boolean paramBoolean)
  {
    if ((paramBoolean) && (BaseApplicationImpl.sDirector != null)) {
      return;
    }
    this.netHandler = new QQAppInterface.MyNetInfoHandler(this);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.netHandler);
    super.start(paramBoolean);
  }
  
  public boolean startAllSubMessageAccountMsg(boolean paramBoolean)
  {
    return startAllSubMessageAccountMsg(paramBoolean, 0);
  }
  
  public boolean startAllSubMessageAccountMsg(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() isFromPush=" + paramBoolean + " fetchMsgType=" + paramInt);
    }
    Object localObject = (bdxs)getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    if (localObject != null) {}
    for (localObject = ((bdxs)localObject).a();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        boolean bool1 = false;
        for (;;)
        {
          bool2 = bool1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          String str = (String)((Iterator)localObject).next();
          if ((str != null) && (str.length() > 4))
          {
            if (paramInt != 2) {
              bdxj.a(this, str, paramBoolean);
            }
            if (paramInt != 1)
            {
              argg localargg = (argg)aqxe.a().a(607);
              if ((localargg != null) && (!localargg.jdField_a_of_type_Boolean)) {
                bdxr.a(this, str);
              }
            }
            bool1 = true;
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() continue, subUin=" + str);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() listSubUin==null");
      }
      boolean bool2 = false;
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() result=" + bool2 + " forground=" + BaseActivity.mAppForground);
      }
      localObject = (bdxj)getManager(QQManagerFactory.SUB_ACCOUNT_CONTROLL);
      if (localObject != null)
      {
        if (!bool2) {
          break label317;
        }
        if (BaseActivity.mAppForground) {
          ((bdxj)localObject).b(this, paramInt);
        }
      }
      return bool2;
      label317:
      ((bdxj)localObject).c(this, 0);
      return bool2;
    }
  }
  
  public void startInspect()
  {
    MagnifierSDK.a().a().a(this, String.format("%d", new Object[] { Long.valueOf(getLongAccountUin()) }));
  }
  
  public void startSecurityScan()
  {
    ISecureModuleService localISecureModuleService = getSecureModuleService();
    if (localISecureModuleService.register(new ProductInfo(6, getVersionName(), Integer.parseInt("4875"), 201, null, getAccount())) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("security_scan", 2, "Start Security Scan");
      }
      if (this.mListener == null) {
        this.mListener = new QQAppInterface.14(this);
      }
      localISecureModuleService.registerCloudScanListener(getApp(), this.mListener);
      localISecureModuleService.cloudScan();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("security_scan", 2, "regist security service error");
  }
  
  public void syncOnlineFriend()
  {
    long l2 = 0L;
    long l1;
    if ((!this.sGetOnlineFriendHandler.hasMessages(0)) && (this.isStartSyncOnlineFriend))
    {
      l1 = l2;
      if (this.sLastGetOnlineFriendTime != 0L)
      {
        l1 = sNextGetOnlineFriendDelay - (SystemClock.uptimeMillis() - this.sLastGetOnlineFriendTime);
        if (l1 >= 0L) {
          break label115;
        }
        l1 = l2;
      }
    }
    label115:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "onResume send msg " + l1);
      }
      Message localMessage = this.sGetOnlineFriendHandler.obtainMessage(0, new WeakReference(this));
      this.sGetOnlineFriendHandler.sendMessageDelayed(localMessage, l1);
      return;
    }
  }
  
  public boolean troopCanPlaySound()
  {
    return getTroopGeneralSettingRing() != 0;
  }
  
  public boolean troopCanVibrator()
  {
    return getTroopGeneralSettingVibrate() != 0;
  }
  
  protected void tryReuploadQfavItems()
  {
    if (!this.needReuploadQfav) {
      this.needReuploadQfav = true;
    }
    while ((!isLogin()) || (!this.needReuploadQfav)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqfav", 2, "Wifi, tryReuploadQfavItems");
    }
    bmaf.a(this);
  }
  
  public boolean trySetCardSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramBoolean1)
    {
      i = this.mTryTimeForNear;
      this.mTryTimeForNear = (i + 1);
      if (i < 3) {}
    }
    do
    {
      return false;
      i = this.mTryTimeForStatus;
      this.mTryTimeForStatus = (i + 1);
    } while (i >= 3);
    ((anri)getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(paramBoolean1, paramBoolean2);
    return true;
  }
  
  public void trySoundAndVibrate()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "trySoundAndVibrate is called,needSoundAndVibrations is:" + Arrays.toString(this.needSoundAndVibrations));
    }
    Object localObject = getMessageFacade();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
        localObject = ((QQMessageFacade)localObject).getIncomingMsg();
      } while (localObject == null);
      this.areMessageRefreshUI[0] = ((QQMessageFacade.Message)localObject).uniseq;
      this.areMessageRefreshUI[1] = 1L;
    } while (this.needSoundAndVibrations[0] != 1);
    if (this.needSoundAndVibrations[1] == 1) {}
    for (;;)
    {
      vibratorAndAudioForMsg((MessageRecord)localObject, bool);
      this.needSoundAndVibrations[0] = 0;
      return;
      bool = false;
    }
  }
  
  public void unRegisterBatteryBroadcastReceiver()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "unRegisterBatteryBroadcastReceiver start");
    }
    try
    {
      if (this.mBatteryBroadcastReceiver != null)
      {
        BaseApplicationImpl.getContext().unregisterReceiver(this.mBatteryBroadcastReceiver);
        this.mBatteryBroadcastReceiver = null;
        if (QLog.isColorLevel()) {
          QLog.d("QQAppInterface", 2, "unRegisterBatteryBroadcastReceiver success");
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQAppInterface", 1, localThrowable, new Object[] { "unRegisterBatteryBroadcastReceiver fail" });
    }
  }
  
  public Object[] unitTestLog(String paramString, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, new Object[] { "unitTestLog: invoked. ", " methodName: ", paramString, paramVarArgs });
    }
    return paramVarArgs;
  }
  
  public void updateOnlineStatus(AppRuntime.Status paramStatus, long paramLong)
  {
    updateOnlineStatus(paramStatus, paramLong, false);
  }
  
  public void updateOnlineStatus(AppRuntime.Status paramStatus, long paramLong, boolean paramBoolean)
  {
    if (isAccLoginSuccess())
    {
      long l = this.app.getSharedPreferences(getAccount(), 0).getInt("GetFrdListReq_seq", 0);
      ((azff)getBusinessHandler(BusinessHandlerFactory.ONLINE_STATUS_HANDLER)).a(this, paramStatus, paramLong, l, paramBoolean);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 1, new Object[] { String.format("updateOnlineStatus, status: %s", new Object[] { paramStatus.name() }), " ext:", Long.valueOf(paramLong) });
      }
      return;
      QLog.d("QQAppInterface", 1, String.format("updateOnlineStatus not login!", new Object[0]));
    }
  }
  
  public void updateSettingTableCache(Setting paramSetting)
  {
    if (paramSetting != null)
    {
      paramSetting = paramSetting.clone();
      if (paramSetting != null)
      {
        paramSetting.url = null;
        if (!TextUtils.isEmpty(paramSetting.uin))
        {
          checkAndCreateFaceSettingCache();
          this.faceSettingCache.put(paramSetting.uin, paramSetting);
        }
      }
    }
  }
  
  public void userLogoutReleaseData()
  {
    sendBindUinOffline();
    bgvx.a().a(true);
    bdzx.a().a();
    bdzy.a().a();
    MsgAutoMonitorUtil.getInstance().release();
    ChatActivityUtils.c();
    bkxs.a(this.app, 0);
    SharedPreferences.Editor localEditor = this.app.getSharedPreferences("unreadcount", 4).edit();
    localEditor.putInt("unread", 0);
    localEditor.commit();
    if (this.transFileController != null)
    {
      this.transFileController.pauseAllShortVideoReceive();
      this.transFileController.pauseAllShortVideoSend();
    }
    OpenApiManager.getInstance().onUserLogout(this);
    this.mAutomator.onDestroy();
    nza.a().c();
    bdgt.a(BaseApplicationImpl.getContext());
    MiniAppUtils.updateMiniAppList(100);
    aqrl.b(getApp());
  }
  
  public void vibratorAndAudio()
  {
    vibratorAndAudio(null, false, true);
  }
  
  public void vibratorAndAudio(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.vibrateSoundHelper = new aogq(this, paramMessageRecord);
    this.vibrateSoundHelper.b(paramMessageRecord, paramBoolean1);
    QLog.d("QQAppInterface", 1, "previous vibrate time is:" + this.time + ",curr time is:" + System.currentTimeMillis());
    if (this.vibrateSoundHelper.a(paramMessageRecord)) {}
    do
    {
      do
      {
        return;
      } while (isTimeIntervalLimited(paramMessageRecord, paramBoolean1));
      if (this.vibrateSoundHelper.c(paramMessageRecord))
      {
        this.vibrateSoundHelper.a(paramBoolean2);
        return;
      }
      unitTestLog("vibratorAndAudio_check_public_account_end", new Object[0]);
    } while (!this.vibrateSoundHelper.a());
    this.vibrateSoundHelper.b(paramMessageRecord, paramBoolean1, paramBoolean2);
  }
  
  public void vibratorAndAudioForMsg(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT > 28) {
      bool = false;
    }
    vibratorAndAudio(paramMessageRecord, paramBoolean, bool);
  }
  
  public void vibratorAndAudioForShake(String paramString, boolean paramBoolean)
  {
    this.time = System.currentTimeMillis();
    boolean bool1 = isRingerSilent();
    boolean bool2 = bgzw.a(this.app.getApplicationContext(), this);
    boolean bool3 = bgzw.b(this.app.getApplicationContext(), this);
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, new Object[] { "isRingerSilent is:" + bool1 + ",canDisturb is:" + bool2, " isMute:", Boolean.valueOf(bool3) });
    }
    if ((!bool1) && (bool2) && (!bool3))
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApp());
      Vibrator localVibrator = (Vibrator)getApp().getSystemService("vibrator");
      bool1 = isVideoChatting();
      bool2 = canPlaySound();
      bool3 = canVibrator();
      boolean bool4 = isCallIdle();
      boolean bool5 = recordingPttStopped();
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "canVibrator is:" + bool3 + ",isVideoing is:" + bool1 + ",isCallIdle is:" + bool4 + ",notRecordingPtt is:" + bool5);
      }
      if ((bool3) && (bool4) && (!bool1) && (bool5)) {
        localVibrator.vibrate(VIBRATOR_PATTERN_SHAKE, -1);
      }
      if ((paramBoolean) && (bool2) && (!bool1) && (!isRingerVibrate()) && (!isRingEqualsZero()) && (isCallIdle()) && (recordingPttStopped()))
      {
        int i = localSharedPreferences.getInt("sound_type" + getCurrentAccountUin(), 2131230721);
        if (systemSound(paramString)) {
          i = 2131230759;
        }
        bhcl.b(i, false);
      }
    }
  }
  
  public void writeCallTabStateVal(Integer[] paramArrayOfInteger)
  {
    writeCallTabStateVal(paramArrayOfInteger, true);
  }
  
  public void writeCallTabStateVal(Integer[] paramArrayOfInteger, boolean paramBoolean)
  {
    Object localObject2 = SettingCloneUtil.readValue(getApplication(), getCurrentAccountUin(), null, "qqsetting_calltab_show_key", "0111100");
    if ((localObject2 == null) || (((String)localObject2).length() > "0111100".length()) || (paramArrayOfInteger == null) || (paramArrayOfInteger.length != 7)) {
      if (QLog.isColorLevel()) {
        QLog.e("QQAppInterface", 2, "writeCallTabStateVal valid val," + (String)localObject2 + "," + paramArrayOfInteger);
      }
    }
    Object localObject1;
    int i;
    label156:
    do
    {
      return;
      localObject1 = localObject2;
      if (((String)localObject2).length() < "0111100".length()) {
        localObject1 = (String)localObject2 + "0111100".substring(((String)localObject2).length());
      }
      localObject1 = new StringBuilder((String)localObject1);
      i = 0;
      if (i < paramArrayOfInteger.length)
      {
        localObject2 = paramArrayOfInteger[i];
        if (localObject2 == null) {}
        for (;;)
        {
          i += 1;
          break label156;
          if ((((Integer)localObject2).intValue() < 0) || (((Integer)localObject2).intValue() > 9))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("QQAppInterface", 2, "writeCallTabStateVal wrong index,," + localObject2);
            return;
          }
          ((StringBuilder)localObject1).setCharAt(i, (char)(((Integer)localObject2).intValue() + 48));
        }
      }
      if (paramArrayOfInteger[0] != null)
      {
        this.mCallTabShowState = 0;
        this.isCallTabShow = false;
        if ((this.isCallTabShow) && ((getNowLiveManager().jdField_a_of_type_Char == '2') || (getNowLiveManager().jdField_a_of_type_Char == '3')))
        {
          localObject2 = new Integer[5];
          localObject2[0] = Integer.valueOf(1);
          localObject2[3] = Integer.valueOf(0);
          getNowLiveManager().a((Integer[])localObject2, false);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQAppInterface", 2, "uin:" + getCurrentAccountUin() + ",writeCallTabStateVal vals=" + paramArrayOfInteger + ",mIsCallTabShow=" + this.mCallTabShowState + ",isCallTabShow=" + this.isCallTabShow);
      }
      SettingCloneUtil.writeValue(getApplication(), getCurrentAccountUin(), null, "qqsetting_calltab_show_key", ((StringBuilder)localObject1).toString());
      localObject1 = getNowLiveManager().a();
      i = ((String)localObject1).charAt(2);
    } while ((!paramBoolean) || (((String)localObject1).charAt(0) != '0') || (paramArrayOfInteger[0] == null) || ((i != 50) && (i != 51)));
    paramArrayOfInteger = new Integer[5];
    paramArrayOfInteger[0] = Integer.valueOf(1);
    getNowLiveManager().a(paramArrayOfInteger, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface
 * JD-Core Version:    0.7.0.1
 */