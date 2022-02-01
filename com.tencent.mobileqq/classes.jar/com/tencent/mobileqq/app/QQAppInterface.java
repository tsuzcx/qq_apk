package com.tencent.mobileqq.app;

import abur;
import ache;
import adab;
import adai;
import adaj;
import adak;
import adkx;
import admw;
import agdj;
import agej;
import agkq;
import aguy;
import ajji;
import ajka;
import ajkp;
import aklf;
import akyb;
import alao;
import alni;
import alok;
import alpb;
import amlv;
import amvf;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
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
import android.graphics.Bitmap.Config;
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
import antf;
import anud;
import anue;
import anui;
import anum;
import anuy;
import anuz;
import anvl;
import anwf;
import anwn;
import anwo;
import anxg;
import anxm;
import anyu;
import anyw;
import anzj;
import aoat;
import aoaw;
import aobl;
import aocq;
import aocr;
import aoeo;
import aoep;
import aoeq;
import aoer;
import aoes;
import aoet;
import aoeu;
import aoev;
import aoew;
import aoex;
import aofj;
import aofo;
import aofy;
import aogf;
import aoip;
import aokn;
import aoko;
import aold;
import aolf;
import aolo;
import aope;
import aory;
import aosq;
import aost;
import aoti;
import aotx;
import aovf;
import apas;
import apau;
import apaw;
import apch;
import apjx;
import aqqr;
import aquy;
import aqwr;
import aqyt;
import aqzq;
import aqzs;
import aqzw;
import aran;
import arjg;
import arrs;
import asbc;
import asfa;
import asvc;
import atag;
import atqx;
import atrd;
import atup;
import atur;
import atut;
import atws;
import atzd;
import aubf;
import aure;
import auue;
import avlf;
import avlk;
import avsj;
import avxx;
import avyk;
import awen;
import awzv;
import awzy;
import axaa;
import axac;
import axan;
import axaw;
import axdx;
import axft;
import axpe;
import axtt;
import axuk;
import axwf;
import azhq;
import azic;
import aziu;
import azll;
import azox;
import azpm;
import baou;
import bapy;
import bayl;
import bbav;
import bbxk;
import bcpt;
import bcqt;
import bcrg;
import bcux;
import bcuy;
import bcvk;
import bcwa;
import bcxf;
import bdaa;
import bdhj;
import bdkn;
import bdks;
import bdll;
import bdlw;
import bdmc;
import bdml;
import bdmx;
import bdna;
import bdnb;
import bdnj;
import bdow;
import bdwt;
import bdxb;
import bdxc;
import bdzh;
import bdzi;
import begp;
import besx;
import beuo;
import bevk;
import beyb;
import bfwl;
import bfxk;
import bfxt;
import bgrf;
import bgrg;
import bgsi;
import bgty;
import bguq;
import bhdu;
import bhgm;
import bhgn;
import bhhg;
import bhhv;
import bhhz;
import bhjd;
import bhjr;
import bhjx;
import bhka;
import bhki;
import bhkm;
import bhlg;
import bhlo;
import bhmi;
import bhml;
import bhmq;
import bhrl;
import bhru;
import bhsi;
import bhsr;
import bhwz;
import bias;
import blgq;
import blhf;
import blhs;
import blhw;
import blqm;
import bmhk;
import bmim;
import bmja;
import bmjd;
import bmkq;
import bnrf;
import bnyp;
import bnzp;
import bplq;
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
import com.tencent.commonsdk.util.notification.SdkInfoUtil;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.DialogActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.recent.config.RecentConfig;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.RegisterProxy;
import com.tencent.mobileqq.app.face.FaceDecodeTask;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.app.utils.HeavyTaskExecutor;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessMsgListFragment;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.QCallRecent;
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
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securemodule.impl.SecureModuleService;
import com.tencent.securemodule.service.CloudScanListener;
import com.tencent.securemodule.service.ISecureModuleService;
import com.tencent.securemodule.service.ProductInfo;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.TextHook;
import com.tencent.util.MsgAutoMonitorUtil;
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
import lbj;
import ldi;
import lmo;
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
import mtd;
import mxc;
import nhs;
import nlb;
import nlj;
import nlk;
import nql;
import nqq;
import nwo;
import oce;
import oer;
import oix;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import ozs;
import pac;
import pfs;
import rnh;
import sup;
import svr;
import twk;
import tyi;
import tzq;
import uzg;
import vlc;
import vtt;
import wnu;
import xil;
import yup;

public class QQAppInterface
  extends AppInterface
  implements PluginManageHandler.IPluginManagerProvider
{
  private static final Bitmap.Config jdField_a_of_type_AndroidGraphicsBitmap$Config;
  private static TextToSpeech jdField_a_of_type_AndroidSpeechTtsTextToSpeech;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  public static final long[] a;
  public static int b;
  public static volatile boolean b;
  public static final long[] b;
  private static long jdField_d_of_type_Long;
  public static int e;
  public static int f;
  public int a;
  public long a;
  volatile adab jdField_a_of_type_Adab;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aoer(this);
  public Intent a;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  public Handler a;
  private MQLruCache<String, Object> jdField_a_of_type_AndroidSupportV4UtilMQLruCache = BaseApplicationImpl.sImageCache;
  private anuy jdField_a_of_type_Anuy;
  private anuz jdField_a_of_type_Anuz;
  private anyu jdField_a_of_type_Anyu = new aoeu(this);
  public aoaw a;
  private aocq jdField_a_of_type_Aocq;
  private aocr jdField_a_of_type_Aocr;
  aoev jdField_a_of_type_Aoev = null;
  private aoex jdField_a_of_type_Aoex;
  aofy jdField_a_of_type_Aofy;
  aoko jdField_a_of_type_Aoko;
  private aolf jdField_a_of_type_Aolf;
  private volatile aotx jdField_a_of_type_Aotx;
  private apau jdField_a_of_type_Apau;
  private apaw jdField_a_of_type_Apaw;
  public aqzq a;
  private final aqzs jdField_a_of_type_Aqzs = new aqzs();
  private aqzw jdField_a_of_type_Aqzw;
  private atqx jdField_a_of_type_Atqx;
  private atrd jdField_a_of_type_Atrd;
  private atup jdField_a_of_type_Atup;
  private atur jdField_a_of_type_Atur;
  private atut jdField_a_of_type_Atut;
  private atws jdField_a_of_type_Atws;
  private avlk jdField_a_of_type_Avlk;
  private axpe jdField_a_of_type_Axpe;
  volatile baou jdField_a_of_type_Baou;
  private bbxk jdField_a_of_type_Bbxk;
  public bcpt a;
  private bcrg jdField_a_of_type_Bcrg;
  private bcxf jdField_a_of_type_Bcxf;
  private bdll jdField_a_of_type_Bdll;
  private bevk jdField_a_of_type_Bevk;
  private beyb jdField_a_of_type_Beyb;
  private bmim jdField_a_of_type_Bmim;
  private bmjd jdField_a_of_type_Bmjd;
  private AVNotifyCenter jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter;
  private QQLruCache<String, Setting> jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache;
  public volatile QQMessageFacade a;
  private BatteryBroadcastReceiver jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver;
  private HotChatManager jdField_a_of_type_ComTencentMobileqqAppHotChatManager;
  private MessageHandler jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
  QQAppInterface.RefreshBadgeHelper jdField_a_of_type_ComTencentMobileqqAppQQAppInterface$RefreshBadgeHelper = new QQAppInterface.RefreshBadgeHelper(this);
  public Automator a;
  private ProxyManager jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager;
  private QQEntityManagerFactory jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory;
  private SigInfo jdField_a_of_type_ComTencentMobileqqDataSigInfo;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private PicPreDownloader jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader;
  private ShortVideoResourceManager jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager;
  private CloudScanListener jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener;
  private ISecureModuleService jdField_a_of_type_ComTencentSecuremoduleServiceISecureModuleService;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ThreadLocal<Integer> jdField_a_of_type_JavaLangThreadLocal = new ThreadLocal();
  public WeakReference<QQServiceForAV> a;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private Hashtable<String, Long> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  public List<aokn> a;
  public Set<String> a;
  private ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
  ConcurrentLinkedQueue<Intent> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private ldi jdField_a_of_type_Ldi;
  public boolean a;
  private volatile byte[] jdField_a_of_type_ArrayOfByte = new byte[2];
  private anud[] jdField_a_of_type_ArrayOfAnud = new anud['»'];
  private final Object[] jdField_a_of_type_ArrayOfJavaLangObject = new Object[382];
  private Manager[] jdField_a_of_type_ArrayOfMqqManagerManager = new Manager[382];
  public long b;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new aoet(this);
  private Intent jdField_b_of_type_AndroidContentIntent;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private ThreadLocal<StringBuilder> jdField_b_of_type_JavaLangThreadLocal = new ThreadLocal();
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<ServerConfigManager.ConfigType, Long> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private Hashtable<ServerConfigManager.ConfigType, HashMap<String, String>> jdField_b_of_type_JavaUtilHashtable = new Hashtable();
  List<anui> jdField_b_of_type_JavaUtilList = new Vector();
  public int c;
  public long c;
  private BroadcastReceiver jdField_c_of_type_AndroidContentBroadcastReceiver = new aoeq(this);
  private Handler jdField_c_of_type_AndroidOsHandler = new aoes(this, ThreadManager.getSubThreadLooper());
  private ArrayList<String> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  List<anui> jdField_c_of_type_JavaUtilList = new Vector();
  public boolean c;
  private volatile long[] jdField_c_of_type_ArrayOfLong = new long[2];
  public int d;
  private ArrayList<String> jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  List<anui> jdField_d_of_type_JavaUtilList = new Vector();
  public volatile boolean d;
  private long e;
  public boolean e;
  private long f;
  public boolean f;
  @Deprecated
  public int g;
  private long g;
  public boolean g;
  private final int h;
  public boolean h;
  private final int i;
  public boolean i;
  private final int jdField_j_of_type_Int = 992;
  boolean jdField_j_of_type_Boolean;
  private final int k;
  public boolean k;
  public volatile boolean l;
  public boolean m;
  @Deprecated
  public boolean n;
  public boolean o = true;
  public boolean p;
  @Deprecated
  public boolean q;
  private boolean r;
  private boolean s;
  
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
      jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
      jdField_d_of_type_Long = 86400000L;
      jdField_a_of_type_ArrayOfLong = new long[] { 100L, 200L, 200L, 100L };
      jdField_b_of_type_ArrayOfLong = new long[] { 100L, 400L, 100L, 400L, 100L, 400L };
      jdField_b_of_type_Int = 1;
      jdField_a_of_type_ArrayOfInt = new int[] { 18, 19, 20, 29, 28, 27, 48, 282, 264 };
      jdField_e_of_type_Int = 300000;
      jdField_f_of_type_Int = 30000;
      return;
      BaseApplicationImpl.sQQAppInterfaceEscapedMsg = "";
    }
  }
  
  public QQAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_e_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_i_of_type_Boolean = true;
    this.jdField_h_of_type_Int = 990;
    this.jdField_i_of_type_Int = 991;
    this.jdField_k_of_type_Int = 993;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_AndroidOsHandler = new aoep(this, Looper.getMainLooper());
    this.jdField_g_of_type_Int = -1;
  }
  
  public static void J()
  {
    int i3 = 0;
    i2 = 0;
    i1 = i3;
    try
    {
      Object localObject = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.headCfg.name(), "24|3500|1|0");
      i1 = i3;
      if (QLog.isColorLevel())
      {
        i1 = i3;
        QLog.i("QQAppInterface", 2, "initHeadCfg, " + (String)localObject);
      }
      i1 = i3;
      localObject = ((String)localObject).split("\\|");
      i1 = i3;
      if (localObject.length > 0)
      {
        i1 = i3;
        i3 = Integer.parseInt(localObject[0]);
        i2 = i3;
        if (i3 >= 1)
        {
          i2 = i3;
          if (i3 <= 168)
          {
            i1 = i3;
            jdField_d_of_type_Long = i3 * 60 * 60 * 1000;
            i2 = i3;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        jdField_d_of_type_Long = 86400000L;
        i2 = i1;
        if (QLog.isColorLevel())
        {
          QLog.e("QQAppInterface", 2, "initHeadCfg error", localException);
          i2 = i1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQAppInterface", 2, "initHeadCfg," + i2 + "," + jdField_d_of_type_Long);
    }
  }
  
  private void N()
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache == null) {
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(2001, 4000, 60);
    }
  }
  
  private void O() {}
  
  private void P()
  {
    if (BaseApplicationImpl.sImageCache != null)
    {
      int i1 = BaseApplicationImpl.sImageCache.size() * 3 / 4;
      BaseApplicationImpl.sImageCache.trimToSize(i1);
    }
  }
  
  private void Q()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.EXIT_" + BaseApplicationImpl.getApplication().getPackageName());
    localIntentFilter.addAction("com.tencent.mobileqq.kickedLogin.otherDevice");
    this.app.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void R()
  {
    if (this.l) {
      return;
    }
    QLog.d("QQAppInterface", 1, "release");
    this.l = true;
    bhut.jdField_a_of_type_Boolean = false;
    if (GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager != null) {
      GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(false);
    }
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      synchronized (this.jdField_c_of_type_JavaUtilList)
      {
        this.jdField_c_of_type_JavaUtilList.clear();
        synchronized (this.jdField_d_of_type_JavaUtilList)
        {
          this.jdField_d_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.onDestroy();
          HeavyTaskExecutor.a(new QQAppInterface.11(this));
        }
      }
    }
    synchronized (this.jdField_a_of_type_ArrayOfAnud)
    {
      anud[] arrayOfanud = this.jdField_a_of_type_ArrayOfAnud;
      int i2 = arrayOfanud.length;
      int i1 = 0;
      while (i1 < i2)
      {
        anud localanud = arrayOfanud[i1];
        if (localanud != null) {
          localanud.onDestroy();
        }
        i1 += 1;
        continue;
        localObject2 = finally;
        throw localObject2;
        localObject3 = finally;
        throw localObject3;
        localObject4 = finally;
        throw localObject4;
      }
      if (this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener != null) {
        a().unregisterCloudScanListener(this.app.getBaseContext(), this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener);
      }
      VideoBroadcastReceiver.a();
      alok.a();
      FaceDecodeTask.b();
      this.jdField_c_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      if (this.jdField_a_of_type_Atqx != null) {
        this.jdField_a_of_type_Atqx.d();
      }
      if (this.jdField_a_of_type_Apaw != null) {
        this.jdField_a_of_type_Apaw.b();
      }
      if (this.jdField_a_of_type_Avlk != null) {
        this.jdField_a_of_type_Avlk.a();
      }
      bnzp.b();
      TdsReaderGlobal.b();
      SosoInterface.a();
      apch.a();
      asvc.a();
      PluginManageHandler.getInstance().setPluginManagerProvider(null, false);
      SessionInfo.clearOldSession();
      tzq.b();
      tyi.a(c());
      oce.a().a();
      QQIndividualityPluginProxyService.a();
      bbzo.jdField_a_of_type_Boolean = false;
      xil.a().a(BaseApplication.getContext());
      apjx.a();
      ajji.a();
      HeavyTaskExecutor.a(new QQAppInterface.12(this));
      bfxt.a().b();
      bfwl.a().b();
      bfxk.a().b();
      bgsi.a(this);
      QWalletHelper.release();
      bnyp.b();
      aubf.a().a();
      awen.a();
      uzg.d();
      return;
    }
  }
  
  private void S()
  {
    Object localObject = (bdxc)getManager(61);
    if (localObject != null) {}
    for (localObject = ((bdxc)localObject).a();; localObject = null)
    {
      if ((localObject == null) || (((ArrayList)localObject).size() == 0)) {
        return;
      }
      bdwt.a(this, (byte)0, (ArrayList)localObject);
      return;
    }
  }
  
  private void T()
  {
    if (this.jdField_a_of_type_Aqzq == null)
    {
      this.jdField_a_of_type_Aqzq = new aqzq(this);
      this.jdField_a_of_type_Aqzq.a();
    }
  }
  
  private void U()
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
            this.s = false;
            return;
          }
          this.s = true;
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("QQAppInterface", 1, "checkBackgroundRestricWhilteList, ", localException);
      }
    }
  }
  
  private void V()
  {
    if (sup.a())
    {
      sup.a().a();
      sup.a().b();
      sup.a().a(1);
    }
  }
  
  private void W()
  {
    mxc localmxc = (mxc)getManager(373);
    if (localmxc != null) {
      localmxc.b();
    }
  }
  
  private void X()
  {
    azic localazic = (azic)getManager(369);
    if (localazic != null) {
      localazic.a().c("QQAppInterface");
    }
  }
  
  private void Y()
  {
    if ((((WtloginManagerImpl)getManager(1)).getLocalSig(getCurrentAccountUin(), 16L) == null) && (isLogin())) {
      bdmc.a(this.app).a(null, "kWtSigAllClear", true, 0L, 0L, null, null);
    }
  }
  
  @Deprecated
  private void Z()
  {
    if (this.jdField_g_of_type_Int != -1) {}
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
    int i1 = localObject.toCharArray()[6];
    localObject = new StringBuilder((String)localObject);
    if (48 != i1) {
      ((StringBuilder)localObject).setCharAt(6, '0');
    }
    for (i1 = 1;; i1 = 0)
    {
      this.jdField_g_of_type_Int = 0;
      this.n = false;
      if (i1 == 0) {
        break;
      }
      ThreadManager.post(new QQAppInterface.20(this, (StringBuilder)localObject), 8, null, false);
      return;
    }
  }
  
  private Intent a(Context paramContext, QQMessageFacade.Message paramMessage, int paramInt)
  {
    String str = paramMessage.frienduin;
    Object localObject = null;
    int i1 = paramInt;
    if (paramInt == 1026) {
      i1 = 1;
    }
    if (String.valueOf(antf.H).equals(str))
    {
      str = paramContext.getString(2131698195);
      localObject = new Intent(paramContext, MsgBoxListActivity.class);
      paramContext = antf.H;
      if (!asbc.a(paramMessage, this)) {
        paramContext = antf.I;
      }
      ((Intent)localObject).putExtra("uin", paramContext);
      ((Intent)localObject).putExtra("uintype", 1001);
      paramMessage = (QQMessageFacade.Message)localObject;
      paramContext = str;
    }
    Intent localIntent;
    for (;;)
    {
      paramMessage.putExtra("uinname", paramContext);
      return paramMessage;
      if ((String.valueOf(antf.M).equals(str)) || (antf.ax.equals(str)) || (antf.aE.equals(str)))
      {
        localObject = paramContext.getString(2131693984);
        localIntent = new Intent(paramContext, NewFriendActivity.class);
        if (antf.M.equals(str))
        {
          localIntent.putExtra("from", "from_notification");
          paramInt = ajkp.a(paramMessage);
          localIntent.putExtra("fromSubType", paramInt);
          if (paramInt != 6) {
            break label241;
          }
          NewFriendActivity.a(this, "0X800A181");
        }
        for (;;)
        {
          localIntent.putExtra("EntranceId", 1);
          paramContext = (Context)localObject;
          paramMessage = localIntent;
          break;
          label241:
          if ((paramInt == 9) || (paramInt == 10) || (paramInt == 1)) {
            NewFriendActivity.a(this, "0X8009CBA");
          }
        }
      }
      if (String.valueOf(antf.N).equals(str))
      {
        str = paramContext.getString(2131718503);
        paramMessage = new Intent(paramContext, TroopActivity.class);
        paramMessage.putExtra("_key_mode", 1);
        paramMessage.putExtra("key_tab_mode", 2);
        paramContext = str;
      }
      else if (String.valueOf(antf.J).equals(str))
      {
        paramMessage = new Intent(paramContext, QQBroadcastActivity.class);
        paramContext = paramContext.getString(2131718502);
      }
      else if (String.valueOf(antf.E).equals(str))
      {
        str = paramContext.getString(2131718503);
        paramMessage = new Intent(paramContext, VisitorsActivity.class);
        paramMessage.putExtra("votersOnly", true);
        paramMessage.putExtra("toUin", Long.valueOf(getCurrentAccountUin()));
        paramContext = str;
      }
      else if (String.valueOf(antf.z).equals(str))
      {
        paramMessage = new Intent(paramContext, LiteActivity.class);
        paramMessage.putExtra("targetUin", antf.z);
        paramContext = paramContext.getString(2131693391);
      }
      else if (String.valueOf(antf.A).equals(str))
      {
        paramMessage = new Intent(paramContext, LiteActivity.class);
        paramMessage.putExtra("targetUin", antf.A);
        paramContext = paramContext.getString(2131693392);
      }
      else if (String.valueOf(9973L).equals(str))
      {
        paramMessage = new Intent(paramContext, ActivateFriendActivity.class);
        paramContext = paramContext.getString(2131689532);
        paramMessage.setFlags(67108864);
        paramMessage.putExtra("af_key_from", 4);
      }
      else if (antf.Q.equals(str))
      {
        str = BaseApplicationImpl.getContext().getString(2131694673);
        if (bnrf.j())
        {
          paramContext = oix.a(paramContext, 6);
          localObject = "";
        }
        try
        {
          paramMessage = new JSONObject(paramMessage.extStr).optString("msg_id");
          paramContext.putExtra("notification_message_id", paramMessage);
          paramContext.putExtra("uintype", 7225);
          paramMessage = paramContext;
          paramContext = str;
          continue;
          paramContext = new Intent(paramContext, ReadInJoyNewFeedsActivity.class);
        }
        catch (JSONException paramMessage)
        {
          for (;;)
          {
            QLog.i("QQAppInterface", 1, "getIntentByUin, get readinjoy messageId exception, e=" + paramMessage.toString());
            paramMessage = (QQMessageFacade.Message)localObject;
          }
        }
      }
    }
    if (i1 == 7000)
    {
      localObject = paramContext.getString(2131718408);
      paramMessage = new Intent(paramContext, AssociatedAccountActivity.class);
      paramMessage.putExtra("subAccount", str);
      paramContext = (bdxc)getManager(61);
      if (paramContext == null) {
        break label1907;
      }
    }
    label1332:
    label1612:
    label1895:
    label1901:
    label1907:
    for (paramContext = paramContext.b(str);; paramContext = str)
    {
      paramMessage.putExtra("subAccountLatestNick", paramContext);
      paramMessage.putExtra("finishAIO", true);
      paramMessage.putExtra("uin", str);
      paramMessage.putExtra("uintype", i1);
      paramContext = (Context)localObject;
      break;
      if ((i1 == 1001) || (i1 == 1010))
      {
        str = paramContext.getString(2131698195);
        localObject = new Intent(paramContext, MsgBoxListActivity.class);
        paramContext = antf.H;
        if (!asbc.a(paramMessage, this)) {
          paramContext = antf.I;
        }
        ((Intent)localObject).putExtra("uin", paramContext);
        ((Intent)localObject).putExtra("uintype", i1);
        paramMessage = (QQMessageFacade.Message)localObject;
        paramContext = str;
        break;
      }
      if (i1 == 1032)
      {
        str = paramContext.getString(2131697917);
        paramMessage = new Intent(paramContext, PublicFragmentActivity.class);
        paramMessage.putExtra("uintype", 1032);
        paramMessage.putExtra("uin", antf.aM);
        paramMessage.putExtra("public_fragment_class", ConfessMsgListFragment.class.getName());
        paramMessage.addFlags(335544320);
        paramContext = str;
        break;
      }
      if (i1 == 1037)
      {
        localObject = new Intent("android.intent.action.MAIN");
        ((Intent)localObject).addCategory("android.intent.category.LAUNCHER");
        ((Intent)localObject).putExtra("uintype", 1037);
        paramMessage = (atag)getManager(292);
        if ((paramMessage != null) && (!TextUtils.isEmpty(str)) && (str.equals(paramMessage.a())) && (!TextUtils.isEmpty(paramMessage.a))) {}
        for (paramMessage = paramMessage.a;; paramMessage = anzj.a(2131708997))
        {
          ((Intent)localObject).setClass(paramContext, SplashActivity.class);
          ((Intent)localObject).addFlags(268435456);
          paramContext = paramMessage;
          paramMessage = (QQMessageFacade.Message)localObject;
          break;
        }
      }
      if ((i1 == 1044) || (i1 == 1045))
      {
        if (!TextUtils.isEmpty(str)) {}
        for (str = bhlg.b(this, str, false);; str = anzj.a(2131708997))
        {
          localObject = axaw.a(paramContext);
          ((Intent)localObject).putExtra("key_matchchat_from_notification", true);
          ((Intent)localObject).putExtra("key_matchchat_from_notification_uin", paramMessage.frienduin);
          ((Intent)localObject).putExtra("key_matchchat_from_notification_type", i1);
          paramContext = str;
          paramMessage = (QQMessageFacade.Message)localObject;
          break;
        }
      }
      if (antf.aR.equals(str))
      {
        paramMessage = BaseApplicationImpl.getContext().getString(2131694673);
        localObject = ReadInJoyLockScreenJumpDelegate.a(paramContext, 6, ((KandianDailyManager)getManager(296)).a());
        ((Intent)localObject).putExtra("uin", str);
        ((Intent)localObject).putExtra("uintype", i1);
        paramContext = paramMessage;
        paramMessage = (QQMessageFacade.Message)localObject;
        break;
      }
      if (i1 == 10007)
      {
        paramMessage = avlf.a(paramContext, paramMessage, this);
        paramContext = str;
        break;
      }
      if (i1 == 7220)
      {
        str = tyi.c(this, paramContext);
        paramMessage = (KandianMergeManager)getManager(162);
        if (paramMessage != null)
        {
          paramMessage = paramMessage.b();
          if (ozs.a(paramMessage)) {
            break label1901;
          }
        }
      }
      for (paramInt = 5;; paramInt = 6)
      {
        if (paramInt == 6) {
          ozs.a(true);
        }
        if (bnrf.j()) {}
        for (paramMessage = oix.a(paramContext, paramInt);; paramMessage = paramContext)
        {
          paramMessage.putExtra("uin", antf.aA);
          paramMessage.putExtra("uintype", i1);
          if (paramInt != 6) {
            break label1895;
          }
          paramContext = BaseApplicationImpl.getContext().getString(2131694673);
          break;
          paramMessage = null;
          break label1332;
          paramContext = oix.b(paramContext, paramInt);
          if (!bnrf.a(this)) {
            break label1457;
          }
          paramContext.putExtra("readinjoy_show_tab", 0);
          paramContext.putExtra("tab_tab_index", 0);
          paramContext.putExtra("launch_from", paramInt);
          pac.a(paramContext);
        }
        localObject = new ArrayList();
        paramMessage = ((KandianMergeManager)getManager(162)).b();
        if ((paramMessage != null) && ((paramMessage instanceof MessageForStructing)) && (paramMessage.extInt == 1))
        {
          paramMessage = (MessageForStructing)paramMessage;
          if (paramMessage.structingMsg == null) {
            paramMessage.parse();
          }
          if ((paramMessage.structingMsg != null) && (!TextUtils.isEmpty(paramMessage.structingMsg.mArticleIds)))
          {
            paramMessage = paramMessage.structingMsg.mArticleIds.split("\\|");
            int i3 = paramMessage.length;
            int i2 = 0;
            for (;;)
            {
              if (i2 < i3)
              {
                localIntent = paramMessage[i2];
                try
                {
                  ((ArrayList)localObject).add(Long.valueOf(Long.parseLong(localIntent)));
                  i2 += 1;
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
        if (((ArrayList)localObject).isEmpty())
        {
          paramMessage = null;
          paramContext.putExtra("subscription_all_article_id", paramMessage);
          if (!((ArrayList)localObject).isEmpty()) {
            break label1664;
          }
        }
        for (long l1 = -1L;; l1 = ((Long)((ArrayList)localObject).get(0)).longValue())
        {
          paramContext.putExtra("subscription_click_article_id", l1);
          paramContext.putExtra("launch_from", paramInt);
          paramMessage = paramContext;
          break;
          paramMessage = (QQMessageFacade.Message)localObject;
          break label1612;
        }
        if (paramMessage.msgtype == -5008) {
          localObject = nhs.a(this, paramMessage);
        }
        paramMessage = (QQMessageFacade.Message)localObject;
        if (localObject == null)
        {
          paramMessage = new Intent(paramContext, SplashActivity.class);
          if (i1 == 1024) {
            paramMessage.putExtra("chat_subType", 1);
          }
          paramMessage.putExtra("uin", str);
          paramMessage.putExtra("uintype", i1);
          paramMessage = agej.a(paramMessage, new int[] { 2 });
          paramMessage.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
        }
        if (i1 == 1009)
        {
          paramContext = paramContext.getString(2131717525);
          break;
        }
        if (String.valueOf(1787740092L).equals(str))
        {
          paramContext = paramContext.getString(2131690057);
          break;
        }
        if (i1 == 1024)
        {
          paramContext = bhlg.b(this, str, i1);
          break;
        }
        if (i1 == 9501)
        {
          localObject = ((abur)a(51)).a(Long.parseLong(str));
          paramContext = str;
          if (localObject != null) {
            paramContext = ache.a((DeviceInfo)localObject);
          }
          break;
        }
        paramContext = bhlg.b(this, str, i1);
        break;
        paramContext = str;
        break;
      }
    }
  }
  
  private Intent a(Context paramContext, String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    if (String.valueOf(antf.H).equals(paramString))
    {
      paramString = paramContext.getString(2131692872);
      localObject = new Intent(paramContext, MsgBoxListActivity.class);
      paramContext = antf.H;
      if (!asbc.b(paramMessageRecord)) {
        paramContext = antf.I;
      }
      ((Intent)localObject).putExtra("uin", paramContext);
      ((Intent)localObject).putExtra("uintype", 1001);
      paramContext = (Context)localObject;
      paramMessageRecord = paramString;
    }
    for (;;)
    {
      paramContext.putExtra("uinname", paramMessageRecord);
      return paramContext;
      if (String.valueOf(antf.M).equals(paramString))
      {
        paramMessageRecord = paramContext.getString(2131718503);
        paramContext = new Intent(paramContext, NewFriendActivity.class);
        paramContext.putExtra("from", "from_notification");
        paramContext.putExtra("EntranceId", 1);
      }
      else if (String.valueOf(antf.N).equals(paramString))
      {
        paramMessageRecord = paramContext.getString(2131718503);
        paramContext = new Intent(paramContext, TroopActivity.class);
        paramContext.putExtra("_key_mode", 1);
        paramContext.putExtra("key_tab_mode", 2);
      }
      else if (String.valueOf(antf.J).equals(paramString))
      {
        paramString = new Intent(paramContext, QQBroadcastActivity.class);
        paramMessageRecord = paramContext.getString(2131718502);
        paramContext = paramString;
      }
      else if (String.valueOf(antf.E).equals(paramString))
      {
        paramMessageRecord = paramContext.getString(2131718503);
        paramContext = new Intent(paramContext, VisitorsActivity.class);
        paramContext.putExtra("votersOnly", true);
        paramContext.putExtra("toUin", Long.valueOf(getCurrentAccountUin()));
      }
      else if (String.valueOf(antf.z).equals(paramString))
      {
        paramString = new Intent(paramContext, LiteActivity.class);
        paramString.putExtra("targetUin", antf.z);
        paramMessageRecord = paramContext.getString(2131693391);
        paramContext = paramString;
      }
      else
      {
        if (!String.valueOf(antf.A).equals(paramString)) {
          break;
        }
        paramString = new Intent(paramContext, LiteActivity.class);
        paramString.putExtra("targetUin", antf.A);
        paramMessageRecord = paramContext.getString(2131693392);
        paramContext = paramString;
      }
    }
    Object localObject = new Intent(getApp(), SplashActivity.class);
    ((Intent)localObject).putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
    ((Intent)localObject).putExtra("conversation_index", 1);
    ((Intent)localObject).setFlags(335544320);
    if (paramInt == 7000)
    {
      paramMessageRecord = paramContext.getString(2131718408);
      ((Intent)localObject).setClass(paramContext, AssociatedAccountActivity.class);
      ((Intent)localObject).putExtra("subAccount", paramString);
      paramContext = (bdxc)getManager(61);
      if (paramContext == null) {
        break label799;
      }
    }
    label799:
    for (paramContext = paramContext.b(paramString);; paramContext = paramString)
    {
      ((Intent)localObject).putExtra("subAccountLatestNick", paramContext);
      ((Intent)localObject).putExtra("finishAIO", true);
      paramContext = (Context)localObject;
      for (;;)
      {
        paramContext.putExtra("uin", paramString);
        paramContext.putExtra("uintype", paramInt);
        break;
        if (paramInt == 1009)
        {
          paramMessageRecord = paramContext.getString(2131717525);
          paramContext = (Context)localObject;
        }
        else if (String.valueOf(1787740092L).equals(paramString))
        {
          paramMessageRecord = paramContext.getString(2131690057);
          paramContext = (Context)localObject;
        }
        else if (paramInt == 1024)
        {
          ((Intent)localObject).setClass(paramContext, SplashActivity.class);
          paramContext = agej.a((Intent)localObject, null);
          paramContext.putExtra("chat_subType", 1);
          paramMessageRecord = bhlg.b(this, paramString, paramInt);
        }
        else if ((paramInt == 1001) || (paramInt == 1010) || (paramInt == 10002))
        {
          localObject = paramContext.getString(2131698195);
          Intent localIntent = new Intent(paramContext, MsgBoxListActivity.class);
          paramContext = antf.H;
          if (!asbc.b(paramMessageRecord)) {
            paramContext = antf.I;
          }
          localIntent.putExtra("uin", paramContext);
          localIntent.putExtra("uintype", paramInt);
          paramContext = localIntent;
          paramMessageRecord = (MessageRecord)localObject;
        }
        else if (paramInt == 1032)
        {
          paramMessageRecord = paramContext.getString(2131697917);
          paramContext = new Intent(paramContext, MsgBoxListActivity.class);
          paramString = antf.aM;
          paramContext.putExtra("uin", paramString);
          paramContext.putExtra("uintype", paramInt);
        }
        else
        {
          paramMessageRecord = bhlg.b(this, paramString, paramInt);
          paramContext = (Context)localObject;
        }
      }
    }
  }
  
  private SharedPreferences a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApp());
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  private Bitmap a(int paramInt, String paramString1, byte paramByte, String paramString2, Bitmap paramBitmap, String paramString3, bhgn parambhgn)
  {
    Object localObject = paramBitmap;
    Bitmap localBitmap;
    if (paramBitmap != null)
    {
      localBitmap = paramBitmap;
      switch (paramByte)
      {
      case 2: 
      default: 
        localBitmap = a(paramBitmap);
      case 5: 
        if (localBitmap != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.", 2, "getFaceBitmap decode success, faceType=" + paramInt + ", uin=" + paramString1 + ", shape=" + paramByte + ", path=" + paramString3 + ", bmp=" + localBitmap);
          }
          a(paramString2, localBitmap, aope.a(paramInt));
          localObject = localBitmap;
        }
        break;
      }
    }
    do
    {
      do
      {
        return localObject;
        localBitmap = a(paramBitmap, bhmq.a(paramBitmap.getWidth()), 50, 50);
        break;
        localBitmap = a(paramBitmap, 50, 50);
        break;
        localObject = localBitmap;
      } while (!QLog.isColorLevel());
      localObject = localBitmap;
    } while (parambhgn.jdField_a_of_type_Int != 0);
    QLog.i("Q.qqhead.qaif", 2, "getFaceBitmap decode shape fail, faceType=" + paramInt + ", uin=" + paramString1 + ", shape=" + paramByte);
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return a(paramBitmap, -1, paramInt1, paramInt2);
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
    int i1 = paramBitmap.getWidth();
    if ((i1 > 0) && (i1 < paramInt2 * f1)) {
      f1 = i1 / paramInt2;
    }
    for (;;)
    {
      paramInt2 = (int)(paramInt2 * f1);
      paramInt3 = (int)(f1 * paramInt3);
      if (paramInt1 > 0) {}
      for (boolean bool = true;; bool = false)
      {
        if (!bool) {
          paramInt1 = paramInt2;
        }
        return bhmq.a(paramBitmap, paramInt1, bool, paramInt2, paramInt3);
      }
    }
  }
  
  private aotx a()
  {
    if (this.jdField_a_of_type_Aotx == null) {}
    try
    {
      if (this.jdField_a_of_type_Aotx == null) {
        this.jdField_a_of_type_Aotx = new aotx();
      }
      return this.jdField_a_of_type_Aotx;
    }
    finally {}
  }
  
  public static bdna a()
  {
    return bdnb.a();
  }
  
  private SQLiteOpenHelper a()
  {
    if (!getCurrentAccountUin().equals("0")) {
      return a().build(getCurrentAccountUin());
    }
    return null;
  }
  
  private SQLiteOpenHelper a(String paramString)
  {
    return getEntityManagerFactory(paramString).build(paramString);
  }
  
  private String a(QQMessageFacade.Message paramMessage)
  {
    switch (paramMessage.bizType)
    {
    default: 
      return "";
    case 17: 
      if (paramMessage.msgtype == -2025)
      {
        if (MessageForQQWalletMsg.isRedPacketMsg(a().b(paramMessage.frienduin, 1, paramMessage.uniseq))) {
          return getApp().getString(2131692660);
        }
        return "";
      }
      return "";
    case 10: 
      return getApp().getString(2131698502);
    case 24: 
      return getApp().getString(2131696569);
    case 13: 
      return getApp().getString(2131696567);
    case 5: 
      return getApp().getString(2131696759);
    case 22: 
      return getApp().getString(2131697018);
    case 4: 
      return getApp().getString(2131696777);
    }
    return getApp().getString(2131697791);
  }
  
  private String a(QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    Object localObject2;
    if ((paramMessage.istroop == 1000) || (paramMessage.istroop == 1020))
    {
      localObject1 = bhlg.d(this, paramMessage.frienduin, paramMessage.senderuin);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (!((String)localObject1).equals(paramMessage.frienduin)) {}
      }
      else
      {
        localObject2 = ((anyw)getManager(51)).e(paramMessage.frienduin);
        if (localObject2 != null) {
          if (TextUtils.isEmpty(((Friends)localObject2).remark)) {
            break label242;
          }
        }
      }
    }
    label242:
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
          if (!this.jdField_a_of_type_JavaUtilSet.contains(paramMessage.frienduin))
          {
            this.jdField_a_of_type_JavaUtilSet.add(paramMessage.frienduin);
            localObject2 = (FriendListHandler)a(1);
            addObserver(this.jdField_a_of_type_Anyu);
            if (QLog.isColorLevel()) {
              QLog.d("QQAppInterface_friendListObserver", 2, "addObserver");
            }
            ((FriendListHandler)localObject2).b(paramMessage.frienduin);
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
      localObject1 = bhlg.c(this, paramMessage.senderuin, paramMessage.frienduin);
      break;
    }
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    if (bhjr.a()) {
      localStringBuilder.append(antf.bM);
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
  
  private String a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if ((paramInt == 1000) || (paramInt == 1020))
    {
      paramString2 = bhlg.d(this, paramString1, paramString2);
      if (!TextUtils.isEmpty(paramString2))
      {
        localObject = paramString2;
        if (!paramString2.equals(paramString1)) {}
      }
      else
      {
        localObject = ((anyw)getManager(51)).e(paramString1);
        if (localObject != null) {
          if (TextUtils.isEmpty(((Friends)localObject).remark)) {
            break label199;
          }
        }
      }
    }
    label199:
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
          if (!this.jdField_a_of_type_JavaUtilSet.contains(paramString1))
          {
            this.jdField_a_of_type_JavaUtilSet.add(paramString1);
            localObject = (FriendListHandler)a(1);
            addObserver(this.jdField_a_of_type_Anyu);
            if (QLog.isColorLevel()) {
              QLog.d("QQAppInterface_friendListObserver", 2, "addObserver");
            }
            ((FriendListHandler)localObject).b(paramString1);
            localObject = paramString2;
          }
        }
      }
      if ((localObject != null) && (!"".equals(localObject))) {
        break label208;
      }
      return paramString1;
      paramString2 = bhlg.c(this, paramString2, paramString1);
      break;
    }
    label208:
    return localObject;
  }
  
  private ArrayList<String> a(Cursor paramCursor)
  {
    ArrayList localArrayList = null;
    Object localObject = localArrayList;
    if (paramCursor != null)
    {
      localObject = localArrayList;
      if (paramCursor.getCount() > 0)
      {
        int i1 = paramCursor.getColumnIndex("troopuin");
        localArrayList = new ArrayList();
        for (;;)
        {
          localObject = localArrayList;
          if (!paramCursor.moveToNext()) {
            break;
          }
          localObject = paramCursor.getString(i1);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
    }
    return localObject;
  }
  
  private void a(int paramInt1, String paramString, byte paramByte, boolean paramBoolean1, int paramInt2, Bitmap paramBitmap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (((paramBitmap == null) && (paramBoolean1) && (!paramBoolean3)) || (paramBoolean2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.", 2, "getFaceBitmap needUpdate, faceType=" + paramInt1 + ", uin=" + paramString + ", shape=" + paramByte);
      }
      if (!paramBoolean3) {
        break label145;
      }
    }
    label145:
    for (byte b1 = 1;; b1 = 2)
    {
      paramBitmap = (FriendListHandler)a(1);
      switch (paramInt1)
      {
      default: 
        return;
      }
    }
    paramBitmap.b(paramString, b1);
    return;
    paramBitmap.a(paramString, b1);
    return;
    paramBitmap.a(paramString, (byte)0, b1);
    return;
    paramBitmap.a(paramString, paramInt2, (byte)1, b1);
    return;
    paramBitmap.b(paramString, paramInt2, (byte)1, b1);
  }
  
  private void a(int paramInt, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
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
  
  private void a(int paramInt, HashMap<Integer, String[]> paramHashMap, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3)
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
  
  private void a(int paramInt, Manager paramManager)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 18: 
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager = ((ProxyManager)paramManager);
      return;
    case 19: 
      this.jdField_a_of_type_Aolf = ((aolf)paramManager);
      return;
    case 20: 
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade = ((QQMessageFacade)paramManager);
      a(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade);
      return;
    case 21: 
      this.jdField_a_of_type_Bevk = ((bevk)paramManager);
      return;
    case 29: 
      this.jdField_a_of_type_Adab = ((adab)paramManager);
      return;
    case 60: 
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager = ((HotChatManager)paramManager);
      return;
    }
    this.jdField_a_of_type_Apau = ((apau)paramManager);
  }
  
  private void a(Intent paramIntent, MessageRecord paramMessageRecord, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "showNotification. cmd=" + paramString4 + ", ticker=" + bhjx.a(paramString1) + ",msgShow:" + bhjx.a(paramString3) + ", bitmap=" + paramBitmap);
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = bhgm.a(this.app.getResources(), 2130840347);
    }
    if (localBitmap != null)
    {
      paramBitmap = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), paramString4);
      paramBitmap.extraData.putStringArray("cmds", new String[] { paramString1, paramString2, paramString3 });
      if (paramMessageRecord == null) {
        break label278;
      }
      paramIntent.putExtra("param_fromuin", paramMessageRecord.senderuin);
      paramIntent.putExtra("KEY_FRIEND_UIN", paramMessageRecord.frienduin);
      paramIntent.putExtra("param_uinType", paramMessageRecord.istroop);
      int i2 = awzy.a(paramMessageRecord.senderuin, paramMessageRecord.istroop, paramIntent);
      int i1 = i2;
      if (i2 == 265)
      {
        paramString1 = blhw.a();
        i1 = i2;
        if (paramString1 != null) {
          i1 = paramString1.a(paramMessageRecord.frienduin);
        }
      }
      paramIntent.putExtra("param_notifyid", i1);
    }
    for (;;)
    {
      paramBitmap.extraData.putParcelable("intent", paramIntent);
      paramBitmap.extraData.putParcelable("bitmap", localBitmap);
      sendToService(paramBitmap);
      return;
      label278:
      paramIntent.putExtra("param_notifyid", 275);
    }
  }
  
  private void a(QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    a("showInComingMsg_invoked", new Object[0]);
    boolean bool1 = bhhv.a(this.app.getApplicationContext(), this);
    boolean bool2 = FriendsStatusUtil.a(paramMessage.frienduin, this);
    boolean bool3 = aguy.a(paramMessage.frienduin, paramMessage.istroop, this);
    boolean bool4 = axdx.a(this).a(paramMessage);
    boolean bool5 = bhhv.b(this.app.getApplicationContext(), this);
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "showInComingMsg ,isFinished=" + this.jdField_j_of_type_Boolean + ", isCanDisturb=" + bool1 + ", newMsgNotificationEnabled=" + bool4 + ", needTicker=" + paramBoolean + ", message=" + paramMessage);
    }
    if ((this.jdField_j_of_type_Boolean) || (!bool1) || (bool2) || (bool3) || (!bool4) || (bool5)) {}
    Object localObject1;
    do
    {
      return;
      a("showInComingMsg_not_shield_1", new Object[0]);
      if (!bhjx.b(paramMessage.frienduin)) {
        break;
      }
      localObject1 = BaseApplicationImpl.getContext();
      localObject3 = ((ActivityManager)((Context)localObject1).getSystemService("activity")).getRunningTasks(1);
      if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "BabyQ topActivity packageName: " + ((ActivityManager.RunningTaskInfo)((List)localObject3).get(0)).topActivity.getPackageName());
      }
    } while (((Context)localObject1).getPackageName().equals(((ActivityManager.RunningTaskInfo)((List)localObject3).get(0)).topActivity.getPackageName()));
    a("showInComingMsg_not_shield_2", new Object[0]);
    Object localObject3 = "";
    Object localObject5 = "";
    Object localObject7 = null;
    Object localObject9 = null;
    Object localObject4 = null;
    if (bhka.d(paramMessage.msgtype)) {
      localObject1 = asfa.a(getApp(), paramMessage);
    }
    for (;;)
    {
      label368:
      if (paramMessage.msgtype == -2051)
      {
        localObject3 = bgrf.a(paramMessage);
        if (localObject3 != null) {
          paramMessage.nickName = ((bgrg)localObject3).c;
        }
      }
      Object localObject8 = a(getApp(), paramMessage, true);
      ((Intent)localObject8).putExtra("entrance", 6);
      ((Intent)localObject8).putExtra("key_notification_click_action", true);
      Object localObject6 = ((Intent)localObject8).getStringExtra("uinname");
      label466:
      blhw localblhw;
      if ((localObject6 == null) || ("".equals(localObject6)))
      {
        localObject6 = ((Intent)localObject8).getStringExtra("uin");
        localblhw = blhw.a(this);
      }
      label660:
      label734:
      label878:
      label1143:
      Object localObject2;
      label4100:
      switch (paramMessage.istroop)
      {
      default: 
        localObject3 = localObject4;
        if (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.b() == 1)
        {
          if ((antf.M.equals(paramMessage.frienduin)) || (antf.ax.equals(paramMessage.frienduin)) || (antf.aE.equals(paramMessage.frienduin))) {
            localObject3 = a(paramMessage.senderuin, true);
          }
        }
        else
        {
          localObject5 = (String)localObject6 + ": ";
          localObject4 = localObject6;
          if (localblhw != null) {
            localObject4 = localblhw.a((String)localObject6, paramMessage);
          }
          localObject9 = aqqr.a(this).a((String)localObject1, paramMessage);
          localObject7 = localObject1;
          localObject1 = localObject3;
          localObject6 = localObject4;
          localObject4 = localObject9;
          localObject3 = localObject7;
          if (!bhka.a(paramMessage.msgtype)) {
            break label5083;
          }
          if ((paramMessage.actMsgContentValue == null) || ("".endsWith(paramMessage.actMsgContentValue))) {
            break label3703;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQAppInterface", 2, "isShareAppActionMsg+ actionDetailMsg=" + paramMessage.actMsgContentValue);
          }
          localObject3 = paramMessage.actMsgContentValue;
          localObject7 = localObject3;
          localObject4 = localObject3;
          if (paramMessage.istroop != 1008) {
            break label3809;
          }
          localObject3 = (String)localObject5 + (String)localObject4;
          if (paramMessage.msgtype != -2016) {
            break label5068;
          }
          localObject4 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.b(getApplication(), paramMessage, true);
          localObject3 = localObject4;
          localObject7 = localObject4;
          localObject5 = localObject6;
          if (paramMessage.counter > 1)
          {
            if (paramMessage.counter <= 100) {
              break label3907;
            }
            localObject5 = (String)localObject6 + " (" + getApp().getString(2131694041) + ")";
          }
          localObject5 = aqqr.a(this).b((String)localObject5, paramMessage);
          if (paramBoolean) {
            break label5065;
          }
          localObject4 = null;
          if (paramMessage.istroop != 1008) {
            break label4100;
          }
          if ((paramMessage.extStr == null) || (((paramMessage.extLong & 0x1) == 0) && (!paramMessage.extStr.contains("lockDisplay"))) || (paramMessage.extStr == null) || (((paramMessage.extLong & 0x1) == 1) && (!paramMessage.getExtInfoFromExtStr("lockDisplay").equals("true")))) {
            break;
          }
          ((Intent)localObject8).putExtra("need_report", true);
          ((Intent)localObject8).putExtra("incoming_msguid", paramMessage.msgUid);
          ((Intent)localObject8).putExtra("incoming_shmsgseq", paramMessage.shmsgseq);
          localObject6 = ((Intent)localObject8).getStringExtra("uin");
          if ((TextUtils.isEmpty((CharSequence)localObject5)) || (TextUtils.isEmpty((CharSequence)localObject6))) {
            break label5058;
          }
          localObject4 = ((String)localObject5).replace((CharSequence)localObject6, "");
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            break label3959;
          }
          if (!antf.u.equals(localObject6)) {
            break label3990;
          }
          localObject1 = a(paramMessage.frienduin, true);
          localObject4 = localObject3;
          localObject6 = localObject5;
          ozs.a(a(), paramMessage, (Intent)localObject8);
          localObject5 = localObject6;
          localObject6 = this.jdField_a_of_type_Aofy.a(paramMessage, (Intent)localObject8);
          if ((paramBoolean) && (paramMessage.istroop != 6000) && (paramMessage.istroop != 1009) && (!paramMessage.frienduin.equals(antf.D))) {
            break label4909;
          }
          localObject1 = aqqr.a(this).a((Bitmap)localObject1, paramMessage);
          a((Intent)localObject6, paramMessage, (String)localObject3, (String)localObject5, (String)localObject4, (Bitmap)localObject1, "CMD_SHOW_NOTIFIYCATION");
          a("showNotification_message", new Object[] { paramMessage });
          a("showNotification_ticker", new Object[] { localObject3 });
          a("showNotification_from", new Object[] { localObject5 });
          a("showNotification_msg", new Object[] { localObject4 });
          a("showNotification_bmp", new Object[] { localObject1 });
          return;
          if (paramMessage.msgtype == -2009)
          {
            localObject1 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.b(getApplication(), paramMessage, true);
            continue;
          }
          if (paramMessage.msgtype == -2040)
          {
            localObject1 = new MessageForApproval();
            ((MessageForApproval)localObject1).msgData = paramMessage.msgData;
            localObject1 = ((MessageForApproval)localObject1).getFullTitle();
            continue;
          }
          if (paramMessage.msgtype == -2041)
          {
            localObject1 = getApp().getString(2131690083);
            localObject3 = getApp().getString(2131690082);
            localObject1 = (String)localObject1 + " " + (String)localObject3;
            continue;
          }
          if (paramMessage.msgtype == -2011)
          {
            try
            {
              localObject1 = bdow.a(paramMessage.msgData);
              if (localObject1 == null)
              {
                localObject1 = localObject3;
                if (QLog.isColorLevel())
                {
                  QLog.d("StructMsg", 2, "showInComingMsg,getStructMsg is null");
                  localObject1 = localObject3;
                }
              }
              else if (((AbsStructMsg)localObject1).mMsgServiceID == 61)
              {
                localObject1 = this.app.getResources().getString(2131697959);
              }
              else if (((AbsStructMsg)localObject1).mMsgServiceID == 107)
              {
                localObject1 = this.app.getResources().getString(2131697791);
              }
              else
              {
                localObject1 = ((AbsStructMsg)localObject1).mMsgBrief;
              }
            }
            catch (Exception localException)
            {
              if (QLog.isColorLevel()) {
                QLog.d("StructMsg", 2, "showInComingMsg,getStructMsg error:" + localException.getMessage(), localException);
              }
              localObject2 = "";
            }
            continue;
          }
          if (anxg.a(paramMessage))
          {
            localObject2 = getApp().getString(2131691130);
            continue;
          }
          if (paramMessage.msgtype == -7001)
          {
            localObject2 = getApp().getString(2131693872);
            continue;
          }
          if (paramMessage.msgtype == -2052)
          {
            localObject2 = new MessageForQQStoryComment();
            ((MessageForQQStoryComment)localObject2).msgData = paramMessage.msgData;
            ((MessageForQQStoryComment)localObject2).parse();
            localObject2 = ((MessageForQQStoryComment)localObject2).getSummaryMsg();
            continue;
          }
          if (paramMessage.msgtype == -2057)
          {
            localObject2 = MessageForTroopStory.MSG_CONTENT;
            continue;
          }
          if (paramMessage.msgtype == -2059)
          {
            localObject2 = new MessageForTroopPobing();
            ((MessageForTroopPobing)localObject2).msgData = paramMessage.msgData;
            ((MessageForTroopPobing)localObject2).doParse();
            localObject2 = ((MessageForTroopPobing)localObject2).getSummaryMsg();
            continue;
          }
          localObject2 = paramMessage.getMessageText();
          if (bgty.b(paramMessage))
          {
            if (!bgty.d(paramMessage)) {
              bgty.a(paramMessage);
            }
            localObject3 = bgty.b(paramMessage);
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              break label5136;
            }
            localObject2 = localObject3;
          }
        }
      case 3000: 
      case 1: 
      case 7000: 
      case 6000: 
      case 1001: 
      case 1010: 
      case 10002: 
      case 1032: 
      case 1037: 
      case 1008: 
      case 9002: 
      case 9501: 
      case 10007: 
        label1157:
        label5136:
        for (;;)
        {
          label805:
          label813:
          label845:
          label1105:
          label1113:
          localObject3 = localObject2;
          label941:
          label960:
          if (localObject2 == null) {
            localObject3 = "";
          }
          label1206:
          if ((localObject3 instanceof begp))
          {
            localObject2 = ((begp)localObject3).a();
            break label368;
            if ((paramMessage.msgtype != -5040) || (!axtt.a(this, paramMessage))) {
              break label5136;
            }
            localObject2 = axtt.a(paramMessage.msg);
            continue;
          }
          localObject2 = new begp(((CharSequence)localObject3).toString(), 3).a();
          break label368;
          localObject3 = a(paramMessage);
          if ((paramMessage.nickName != null) && (!"".equals(paramMessage.nickName)))
          {
            localObject5 = (String)localObject3 + paramMessage.nickName + "(" + (String)localObject6 + "):";
            localObject3 = (String)localObject3 + paramMessage.nickName + ": " + (String)localObject2;
            label1999:
            if (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.b() != 1) {
              break label5118;
            }
            localObject4 = (anwo)a(6);
            if (localObject4 == null) {
              break label5112;
            }
          }
          label2320:
          label2403:
          label3703:
          label5112:
          for (localObject4 = ((anwo)localObject4).a(paramMessage.frienduin, true);; localObject4 = null)
          {
            localObject7 = localObject4;
            localObject4 = localObject3;
            localObject3 = localObject2;
            localObject2 = localObject7;
            break label734;
            localObject4 = bhlg.a(this, paramMessage.senderuin, 0);
            localObject5 = (String)localObject3 + (String)localObject4 + "(" + (String)localObject6 + "):";
            localObject3 = (String)localObject3 + (String)localObject4 + ": " + (String)localObject2;
            break label1999;
            if ((paramMessage.msgtype == -1013) || (paramMessage.msgtype == -2030) || (paramMessage.msgtype == -1047))
            {
              localObject5 = (String)localObject6 + ":";
              localObject3 = localObject2;
              localObject4 = localObject2;
              localObject2 = localObject7;
              break label734;
            }
            localObject3 = "";
            if (nlj.a(paramMessage))
            {
              localObject4 = nlj.a(paramMessage).b;
              new StringBuilder().append(getApp().getString(2131696557)).append((String)localObject4).append("(").append((String)localObject6).append("):").toString();
              new StringBuilder().append(getApp().getString(2131696557)).append((String)localObject4).append(": ").append((String)localObject2).toString();
              if (paramMessage.msgtype != -2035)
              {
                localObject4 = localObject2;
                if (paramMessage.msgtype != -2038) {}
              }
              else
              {
                localObject4 = MessageForGrayTips.getOrginMsg((String)localObject2);
              }
              localObject2 = localObject4;
              if (paramMessage.msgtype == -3006)
              {
                localObject2 = MessageForPubAccount.getMsgSummary(this, paramMessage, false);
                localObject3 = tyi.a(this, getApplication().getApplicationContext());
              }
              if (!adak.l(paramMessage.msgtype)) {
                break label2610;
              }
              localObject3 = a(paramMessage);
              localObject5 = (String)localObject3 + "(" + (String)localObject6 + "):";
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                break label2638;
              }
            }
            for (localObject3 = (String)localObject3 + ": " + (String)localObject2;; localObject3 = localObject2)
            {
              localObject4 = bhwz.b((String)localObject3);
              localObject7 = localObject9;
              if (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.b() == 1) {
                localObject7 = a(paramMessage.frienduin, (byte)3, false, false);
              }
              localObject3 = localObject4;
              if (localblhw != null) {
                localObject3 = localblhw.b((String)localObject4, paramMessage);
              }
              localObject4 = aqqr.a(this).a((String)localObject3, paramMessage);
              localObject3 = localObject2;
              localObject2 = localObject7;
              break;
              localObject3 = bgrf.a(paramMessage);
              if (localObject3 != null)
              {
                localObject3 = ((bgrg)localObject3).c;
                break label2320;
              }
              if (!TextUtils.isEmpty(paramMessage.nickName))
              {
                localObject3 = paramMessage.nickName;
                break label2320;
              }
              localObject3 = bhlg.h(this, paramMessage.frienduin, paramMessage.senderuin);
              break label2320;
              localObject3 = a(paramMessage) + (String)localObject3;
              break label2403;
            }
            localObject4 = ((Intent)localObject8).getStringExtra("subAccountLatestNick");
            if (localObject4 != null)
            {
              localObject3 = localObject4;
              if (((String)localObject4).length() != 0) {}
            }
            else
            {
              localObject3 = paramMessage.senderuin;
            }
            localObject5 = (String)localObject6 + "-" + (String)localObject3 + ":" + (String)localObject2;
            localObject4 = (String)localObject3 + ":" + (String)localObject2;
            localObject7 = null;
            localObject3 = localObject2;
            localObject2 = localObject7;
            break label734;
            localObject5 = (String)localObject6 + ": ";
            localObject3 = localObject2;
            localObject4 = localObject2;
            localObject2 = localObject7;
            break label734;
            if (String.valueOf(antf.H).equals(paramMessage.frienduin))
            {
              localObject4 = bhlg.q(this, paramMessage.senderuin);
              localObject3 = localObject4;
              if (TextUtils.isEmpty((CharSequence)localObject4)) {
                localObject3 = paramMessage.senderuin;
              }
              localObject5 = (String)localObject3 + "(" + (String)localObject6 + "):";
              if (paramMessage.msgtype != -2053) {
                break label2999;
              }
              localObject3 = paramMessage.nickName;
              localObject3 = getApp().getString(2131698194) + (String)localObject3 + (String)localObject2;
            }
            for (;;)
            {
              if (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.b() == 1)
              {
                localObject7 = a(paramMessage.frienduin, 200);
                localObject4 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject7;
                break;
                localObject4 = bhlg.q(this, paramMessage.frienduin);
                localObject3 = localObject4;
                if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                  break label2841;
                }
                localObject3 = paramMessage.frienduin;
                break label2841;
                if (paramMessage.msgtype == -2068)
                {
                  localObject3 = localObject2;
                }
                else
                {
                  localObject3 = a(paramMessage) + (String)localObject3 + ": " + (String)localObject2;
                  continue;
                  localObject7 = bhjd.a(getApp().getResources().getDrawable(2130845002));
                  localObject6 = getApp().getString(2131697917);
                  localObject3 = new ConfessInfo();
                  ((ConfessInfo)localObject3).parseFromJsonStr(paramMessage.getExtInfoFromExtStr("ext_key_confess_info"));
                  localObject3 = aqyt.a(this, (ConfessInfo)localObject3, paramMessage.senderuin);
                  localObject5 = (String)localObject3 + "(" + (String)localObject6 + "):" + (String)localObject2;
                  localObject4 = (String)localObject3 + ":" + (String)localObject2;
                  localObject3 = localObject2;
                  localObject2 = localObject7;
                  break;
                  localObject7 = a(paramMessage.frienduin, true);
                  localObject3 = getApp().getString(2131698023);
                  localObject5 = (String)localObject6 + "(" + (String)localObject3 + "): " + (String)localObject2;
                  localObject4 = (String)localObject6 + ": " + (String)localObject2;
                  localObject6 = localObject3;
                  localObject3 = localObject2;
                  localObject2 = localObject7;
                  break;
                  localObject7 = bhjd.a(getApp().getResources().getDrawable(2130840365));
                  localObject4 = agkq.a(paramMessage);
                  if ((localObject4 != null) && (!((PAMessage)localObject4).items.isEmpty()))
                  {
                    localObject3 = ((PAMessage.Item)((PAMessage)localObject4).items.get(0)).title;
                    if ((((PAMessage.Item)((PAMessage)localObject4).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList != null))
                    {
                      localObject4 = (String)((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList.get(0);
                      localObject6 = localObject3;
                      localObject3 = localObject4;
                    }
                  }
                  for (;;)
                  {
                    localObject4 = localObject3;
                    localObject3 = localObject2;
                    localObject2 = localObject7;
                    break label734;
                    continue;
                    localObject7 = bhjd.a(getApp().getResources().getDrawable(2130844746));
                    localObject5 = (String)localObject6 + ": ";
                    localObject3 = localObject2;
                    localObject4 = localObject2;
                    localObject2 = localObject7;
                    break label734;
                    if (("device_groupchat".equals(paramMessage.extStr)) && ((paramMessage.msgtype == -4501) || (paramMessage.msgtype == -4508)))
                    {
                      localObject4 = bhlg.b(this, paramMessage.senderuin, true);
                      localObject3 = localObject4;
                      if (!TextUtils.isEmpty(paramMessage.senderuin))
                      {
                        localObject3 = localObject4;
                        if (paramMessage.senderuin.equals(paramMessage.frienduin)) {
                          localObject3 = ache.a(((abur)a(51)).a(Long.parseLong(paramMessage.senderuin)));
                        }
                      }
                      localObject4 = localObject3;
                      if (localObject3 == null) {
                        localObject4 = "";
                      }
                      localObject4 = (String)localObject4 + ": " + (String)localObject2;
                      localObject3 = localObject2;
                      localObject2 = localObject7;
                      break label734;
                    }
                    localObject3 = localObject2;
                    localObject4 = localObject2;
                    localObject2 = localObject7;
                    break label734;
                    localObject4 = avlf.a(this, paramMessage, (CharSequence)localObject2);
                    localObject3 = localObject2;
                    localObject2 = localObject7;
                    break label734;
                    localObject3 = a(paramMessage.frienduin, true);
                    break label660;
                    localObject3 = a().a(bhki.a(paramMessage.shareAppID));
                    if ((localObject3 == null) || (((AppShareID)localObject3).messagetail == null) || ("".equals(((AppShareID)localObject3).messagetail)))
                    {
                      localObject3 = getApp().getString(2131690063);
                      break label805;
                    }
                    localObject3 = getApp().getString(2131690065) + ((AppShareID)localObject3).messagetail + this.app.getString(2131690066);
                    break label805;
                    localObject3 = localObject5;
                    if (paramMessage.istroop == 7000) {
                      break label845;
                    }
                    localObject3 = localObject5;
                    if (adak.a(paramMessage.istroop) == 1032) {
                      break label845;
                    }
                    localObject3 = localObject5;
                    if (paramMessage.istroop == 1037) {
                      break label845;
                    }
                    localObject3 = localObject5;
                    if (paramMessage.istroop == 1044) {
                      break label845;
                    }
                    localObject3 = localObject5;
                    if (paramMessage.istroop == 1045) {
                      break label845;
                    }
                    localObject3 = (String)localObject5 + (String)localObject7;
                    break label845;
                    localObject5 = (String)localObject6 + " (" + paramMessage.counter + getApp().getString(2131693986) + ")";
                    break label941;
                    localObject3 = (String)localObject4 + " : " + (String)localObject3;
                    break label1113;
                    if (antf.aR.equals(localObject6))
                    {
                      localObject9 = BaseApplicationImpl.getContext().getResources().getDrawable(2130842663);
                      if ((localObject9 instanceof BitmapDrawable))
                      {
                        localObject2 = ((BitmapDrawable)localObject9).getBitmap();
                        localObject4 = localObject7;
                        localObject6 = localObject5;
                        break label1143;
                      }
                      localObject4 = localObject7;
                      localObject6 = localObject5;
                      if (!(localObject9 instanceof SkinnableBitmapDrawable)) {
                        break label1143;
                      }
                      localObject2 = ((SkinnableBitmapDrawable)localObject9).getBitmap();
                      localObject4 = localObject7;
                      localObject6 = localObject5;
                      break label1143;
                    }
                    localObject6 = getApp().getString(2131689657);
                    localObject4 = localObject3;
                    break label1143;
                    if (paramMessage.istroop == 7220)
                    {
                      if (!ozs.a(this, paramMessage)) {
                        break;
                      }
                      ozs.a(a(), paramMessage, (Intent)localObject8);
                      localObject2 = bhmq.e();
                      localObject6 = BaseApplicationImpl.getContext().getResources().getDrawable(2130842663);
                      if ((localObject6 instanceof BitmapDrawable)) {
                        localObject2 = ((BitmapDrawable)localObject6).getBitmap();
                      }
                    }
                    for (;;)
                    {
                      localObject6 = localObject3;
                      localObject3 = localObject4;
                      localObject4 = localObject6;
                      break label1157;
                      if ((localObject6 instanceof SkinnableBitmapDrawable))
                      {
                        localObject2 = ((SkinnableBitmapDrawable)localObject6).getBitmap();
                        continue;
                        if (((paramMessage.istroop == 1001) || (paramMessage.istroop == 10002)) && (paramMessage.msgtype == -3001))
                        {
                          if (OpenAppClient.a(this.app.getApplicationContext(), paramMessage.action, paramMessage.frienduin, paramMessage.istroop) == null) {
                            break;
                          }
                          localObject6 = localObject3;
                          localObject3 = localObject4;
                          localObject4 = localObject6;
                          break label1157;
                        }
                        if (paramMessage.istroop == 1037)
                        {
                          localObject6 = localObject3;
                          localObject3 = localObject4;
                          localObject4 = localObject6;
                          break label1157;
                        }
                        if (paramMessage.istroop == 10007)
                        {
                          localObject2 = avlf.a(paramMessage, this);
                          localObject5 = avlf.a(paramMessage, this);
                          localObject6 = localObject3;
                          localObject3 = localObject4;
                          localObject4 = localObject6;
                          break label1157;
                        }
                        if (paramMessage.istroop == 7225)
                        {
                          localObject2 = bhmq.e();
                          localObject5 = BaseApplicationImpl.getContext().getResources().getDrawable(2130842663);
                          if ((localObject5 instanceof BitmapDrawable)) {
                            localObject2 = ((BitmapDrawable)localObject5).getBitmap();
                          }
                        }
                        for (;;)
                        {
                          localObject5 = ozs.d(BaseApplicationImpl.getContext());
                          localObject6 = localObject3;
                          localObject3 = localObject4;
                          localObject4 = localObject6;
                          break label1157;
                          if ((localObject5 instanceof SkinnableBitmapDrawable))
                          {
                            localObject2 = ((SkinnableBitmapDrawable)localObject5).getBitmap();
                            continue;
                            if (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.b() > 1)
                            {
                              if (!blhw.a(paramMessage))
                              {
                                int i1 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.a(true);
                                localObject7 = new StringBuffer();
                                int i2 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.b(true);
                                ((StringBuffer)localObject7).append(String.format(getApp().getString(2131694038), new Object[] { Integer.valueOf(i2) }));
                                if (i1 == 0) {
                                  break;
                                }
                                if (i1 > 1000)
                                {
                                  ((StringBuffer)localObject7).append(getApp().getString(2131694039));
                                  if (i2 <= 1) {
                                    break label4697;
                                  }
                                  localObject6 = new Intent(getApp(), SplashActivity.class);
                                  ((Intent)localObject6).addFlags(335544320);
                                  ((Intent)localObject6).putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
                                  localObject5 = getApp().getString(2131694050);
                                  localObject3 = ((StringBuffer)localObject7).toString();
                                  localObject2 = null;
                                }
                                for (;;)
                                {
                                  a("isSeparateSessionMessage_false_from", new Object[] { localObject5 });
                                  a("isSeparateSessionMessage_false_msg", new Object[] { localObject3 });
                                  a("isSeparateSessionMessage_false_bmp", new Object[] { localObject2 });
                                  localObject7 = localObject3;
                                  localObject3 = localObject4;
                                  localObject4 = localObject7;
                                  localObject8 = localObject6;
                                  break;
                                  ((StringBuffer)localObject7).append(i1).append(getApp().getString(2131693986));
                                  break label4539;
                                  QLog.d("QQAppInterface", 1, new Object[] { "[notification] showInComingMsg: invoked. 非独立会话数<=1，保持旧的跳转、图标、wording 已经从上面switch-case中获取 ", " conversationSizeNotSeparate: ", Integer.valueOf(i2) });
                                  localObject6 = localObject8;
                                }
                              }
                              ((Intent)localObject8).putExtra("KEY_FROM", "notifcation");
                              if (paramMessage.istroop == 0) {
                                localObject2 = a(paramMessage.frienduin, true);
                              }
                              for (;;)
                              {
                                a("isSeparateSessionMessage_true_bmp", new Object[] { localObject2 });
                                localObject6 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject6;
                                break;
                                if (paramMessage.istroop == 1) {
                                  localObject2 = a(paramMessage.frienduin, (byte)3, false, false);
                                }
                              }
                            }
                            if (paramMessage.istroop == 0)
                            {
                              ((Intent)localObject8).putExtra("need_report", true);
                              ((Intent)localObject8).putExtra("incoming_msguid", paramMessage.msgUid);
                              ((Intent)localObject8).putExtra("incoming_shmsgseq", paramMessage.shmsgseq);
                              ((Intent)localObject8).putExtra("KEY_FROM", "notifcation");
                              if (axtt.a(this, paramMessage)) {
                                ((Intent)localObject8).putExtra("key_reactive_push_tip", true);
                              }
                            }
                            localObject6 = localObject3;
                            localObject3 = localObject4;
                            localObject4 = localObject6;
                            break label1157;
                            if (bhrl.a(getApp()))
                            {
                              localObject7 = (axac)getManager(72);
                              if (NotifyPushSettingActivity.a()) {}
                              for (paramBoolean = false;; paramBoolean = SettingCloneUtil.readValue(getApp(), getCurrentAccountUin(), getApp().getString(2131693438), "qqsetting_lock_screen_whenexit_key", true))
                              {
                                bool1 = aqqr.a(this).a(paramMessage.frienduin, paramMessage.istroop);
                                if ((!paramBoolean) || (!bool1)) {
                                  break;
                                }
                                if (QLog.isColorLevel()) {
                                  QLog.d("QQLSActivity", 2, "videochatting start lsActivity from appinterface  showInComingMsg");
                                }
                                ((axac)localObject7).a(this, paramMessage, false, awzy.a(paramMessage.frienduin, paramMessage.istroop, (Intent)localObject6));
                                break;
                              }
                            }
                            if (!QLog.isColorLevel()) {
                              break label1206;
                            }
                            QLog.d("QQAppInterface", 2, "screen unlock");
                            break label1206;
                          }
                        }
                      }
                    }
                    localObject4 = localObject5;
                    break label1105;
                    break label960;
                    localObject5 = localObject4;
                    localObject4 = localObject3;
                    localObject3 = localObject5;
                    break label878;
                    localObject7 = localObject3;
                    break label813;
                    localObject3 = localObject2;
                  }
                }
              }
            }
            localObject4 = localObject3;
            localObject3 = localObject2;
            localObject2 = localObject7;
            break label734;
          }
          label2610:
          label2638:
          label3809:
          label3959:
          label5118:
          localObject4 = localObject3;
          label2841:
          label2999:
          label3907:
          label4697:
          label5083:
          localObject3 = localObject2;
          label3990:
          label4539:
          label5058:
          label5065:
          label5068:
          localObject2 = localObject7;
          label4909:
          break label734;
          break label466;
        }
      }
    }
  }
  
  private void a(QQMessageFacade.Message paramMessage, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i3 = 1;
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "showMsgNotification: entryA message.frienduin=" + paramMessage.frienduin + ", message.senderuin=" + paramMessage.senderuin + ", needSoundVibrationsTip " + paramBoolean1 + " , isOnline " + paramBoolean2);
    }
    if (!((blhs)a(146)).a(paramMessage.frienduin, paramMessage.istroop)) {}
    for (int i1 = 0;; i1 = 1)
    {
      if (i1 != 0)
      {
        if (!g()) {
          break label412;
        }
        a(paramMessage, true);
        if ((this.jdField_a_of_type_Int != 0) || (!paramBoolean1)) {
          break label428;
        }
      }
      label412:
      label428:
      for (int i2 = 1;; i2 = 0)
      {
        if (paramMessage.istroop != 1001)
        {
          i1 = i2;
          if (paramMessage.istroop != 10002) {}
        }
        else
        {
          i1 = i2;
          if (paramMessage.msgtype == -3001) {
            i1 = 1;
          }
        }
        i2 = i1;
        if (paramMessage.istroop == 1008) {
          if ((paramMessage.extStr == null) || ((paramMessage.extLong & 0x1) != 0) || (!paramMessage.extStr.contains("lockDisplay")))
          {
            i2 = i1;
            if (paramMessage.extStr != null)
            {
              i2 = i1;
              if ((paramMessage.extLong & 0x1) == 1)
              {
                i2 = i1;
                if (!paramMessage.getExtInfoFromExtStr("lockDisplay").equals("true")) {}
              }
            }
          }
          else
          {
            i2 = i1;
            if (paramBoolean1) {
              i2 = 1;
            }
          }
        }
        i1 = i2;
        if (paramMessage.istroop == 1008)
        {
          i1 = i2;
          if (antf.u.equals(paramMessage.senderuin)) {
            i1 = 1;
          }
        }
        if (paramMessage.istroop == 9002) {}
        for (i2 = i3;; i2 = i1)
        {
          i1 = i2;
          if (paramMessage.istroop == 1037)
          {
            i1 = i2;
            if (SdkInfoUtil.isOreo()) {
              i1 = 0;
            }
          }
          i2 = i1;
          if (paramMessage.istroop == 1044)
          {
            i2 = i1;
            if (SdkInfoUtil.isOreo()) {
              i2 = 0;
            }
          }
          i1 = i2;
          if (paramMessage.istroop == 1045)
          {
            i1 = i2;
            if (SdkInfoUtil.isOreo()) {
              i1 = 0;
            }
          }
          if (i1 != 0) {
            c(paramMessage, paramBoolean2);
          }
          return;
          b(paramMessage, true);
          break;
        }
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (g()) {
      b(paramMessageRecord, true);
    }
    for (;;)
    {
      int i2 = 0;
      int i1 = i2;
      if (this.jdField_a_of_type_Int == 0)
      {
        i1 = i2;
        if (paramBoolean1) {
          i1 = 1;
        }
      }
      if (paramMessageRecord.istroop != 1001)
      {
        i2 = i1;
        if (paramMessageRecord.istroop != 10002) {}
      }
      else
      {
        i2 = i1;
        if (paramMessageRecord.msgtype == -3001) {
          i2 = 1;
        }
      }
      i1 = i2;
      if (paramMessageRecord.istroop == 1008) {
        if ((paramMessageRecord.extStr == null) || ((paramMessageRecord.extLong & 0x1) != 0) || (!paramMessageRecord.extStr.contains("lockDisplay")))
        {
          i1 = i2;
          if (paramMessageRecord.extStr != null)
          {
            i1 = i2;
            if ((paramMessageRecord.extLong & 0x1) == 1)
            {
              i1 = i2;
              if (!paramMessageRecord.getExtInfoFromExtStr("lockDisplay").equals("true")) {}
            }
          }
        }
        else
        {
          i1 = i2;
          if (paramBoolean1) {
            i1 = 1;
          }
        }
      }
      i2 = i1;
      if (paramMessageRecord.istroop == 1008)
      {
        i2 = i1;
        if (antf.u.equals(paramMessageRecord.senderuin)) {
          i2 = 1;
        }
      }
      if (i2 != 0) {
        b(paramMessageRecord, paramBoolean2, true);
      }
      return;
      d(paramMessageRecord, true);
    }
  }
  
  private boolean a(int paramInt, String paramString)
  {
    return ((paramInt == 11) && (!bhsr.d(paramString))) || (TextUtils.isEmpty(paramString));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (!paramQQAppInterface.jdField_h_of_type_Boolean)
    {
      String str = paramQQAppInterface.getAccount();
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      if (localSharedPreferences.contains(str + "_" + "long_text_msg_config_version")) {
        paramQQAppInterface.jdField_i_of_type_Boolean = localSharedPreferences.getBoolean(str + "_msfpull_filter_switch", true);
      }
    }
    paramQQAppInterface.jdField_h_of_type_Boolean = true;
    return paramQQAppInterface.jdField_i_of_type_Boolean;
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    Object localObject = ((ActivityManager)BaseApplicationImpl.getApplication().getSystemService("activity")).getRunningTasks(1);
    int i1;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (ActivityManager.RunningTaskInfo)((List)localObject).get(0);
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "locking activity:" + ((ActivityManager.RunningTaskInfo)localObject).topActivity.getClassName());
      }
      localObject = ((ActivityManager.RunningTaskInfo)localObject).topActivity.getClassName();
      if ((((String)localObject).equals("com.tencent.av.ui.VideoInviteLock")) || (((String)localObject).equals("com.tencent.av.gaudio.GaInviteLockActivity")) || (((String)localObject).equals("com.tencent.av.ui.AVActivity"))) {
        i1 = 1;
      }
    }
    for (;;)
    {
      if ((paramMessageRecord.msgtype == -2016) && (paramMessageRecord.istroop == 3000)) {}
      for (int i2 = 1;; i2 = 0)
      {
        if ((i1 != 0) && (i2 != 0))
        {
          return true;
          i1 = 0;
          break;
        }
        return false;
      }
      i1 = 0;
    }
  }
  
  private boolean a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    boolean bool = true;
    a("vibratorAndAudio_check_time_start", new Object[0]);
    if (this.jdField_e_of_type_Long == -1L)
    {
      a("vibratorAndAudio_check_time_not_valid", new Object[0]);
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      a("vibratorAndAudio_check_time_end", new Object[0]);
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
          if (Math.abs(System.currentTimeMillis() - this.jdField_e_of_type_Long) > 2000L) {
            break;
          }
          a("vibratorAndAudio_check_time_in_time_space", new Object[0]);
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
      if ((paramBoolean) && (a() == 11L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    label140:
    QLog.e("SpecialCare", 2, "isOnline = " + paramBoolean + " getOnlineStatus = " + a());
    return true;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, QQMessageFacade.Message paramMessage)
  {
    if (this.jdField_a_of_type_Aofy.d(paramMessage)) {
      return true;
    }
    if ((paramMessage.istroop == 1008) && (antf.u.equals(paramMessage.senderuin))) {}
    for (int i1 = 1; i1 != 0; i1 = 0)
    {
      c(paramMessage, paramBoolean2);
      return true;
    }
    if (paramBoolean1)
    {
      boolean bool = this.jdField_a_of_type_Aofy.h(paramMessage);
      if ((this.jdField_a_of_type_Int == 0) || (bool))
      {
        if (this.jdField_d_of_type_Boolean) {
          break label122;
        }
        c(paramMessage, paramBoolean2);
      }
    }
    if ((paramBoolean1) && (this.jdField_a_of_type_Aofy.e(paramMessage))) {
      this.jdField_a_of_type_Aofy.a(paramMessage);
    }
    return false;
    label122:
    if ((this.jdField_c_of_type_ArrayOfLong[0] == paramMessage.uniseq) && (this.jdField_c_of_type_ArrayOfLong[1] == 1L)) {}
    for (i1 = 1;; i1 = 0)
    {
      if (i1 == 0) {
        break label170;
      }
      c(paramMessage, paramBoolean2);
      break;
    }
    label170:
    this.jdField_a_of_type_ArrayOfByte[0] = 1;
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if (paramBoolean2) {}
    for (i1 = 1;; i1 = 0)
    {
      arrayOfByte[1] = ((byte)i1);
      break;
    }
  }
  
  private Object[] a(Setting paramSetting, String paramString, int paramInt)
  {
    String str = paramString;
    int i1 = paramInt;
    if (paramSetting != null)
    {
      str = paramString;
      i1 = paramInt;
      if (paramInt != 101)
      {
        str = paramString;
        i1 = paramInt;
        if (paramInt != 1001)
        {
          str = paramString;
          i1 = paramInt;
          if (paramString != null)
          {
            str = paramString;
            i1 = paramInt;
            if (paramSetting.bHeadType == 0)
            {
              str = String.valueOf(paramSetting.systemHeadID);
              if (paramInt != 4) {
                break label94;
              }
              i1 = -56;
            }
          }
        }
      }
    }
    for (;;)
    {
      return new Object[] { Integer.valueOf(i1), str };
      label94:
      if (paramInt == 16) {
        i1 = 16;
      } else {
        i1 = -55;
      }
    }
  }
  
  @TargetApi(23)
  private void aa()
  {
    QLog.d("QQAppInterface", 1, "checkBackgroundRestricWhilteList ENTER " + System.currentTimeMillis());
    localBaseApplication = BaseApplicationImpl.getContext();
    Object localObject1 = (ConnectivityManager)localBaseApplication.getSystemService("connectivity");
    try
    {
      bool2 = ((ConnectivityManager)localObject1).isActiveNetworkMetered();
      int i2;
      if (bool2) {
        i2 = -1;
      }
      try
      {
        Method localMethod = localObject1.getClass().getMethod("getRestrictBackgroundStatus", new Class[0]);
        localMethod.setAccessible(true);
        i1 = ((Integer)localMethod.invoke(localObject1, new Object[0])).intValue();
        i2 = i1;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          int i1;
          boolean bool1;
          localException1.printStackTrace();
          continue;
          Object localObject2 = localBaseApplication.getSharedPreferences("qq_background_restric_whitelist_cfg", 0);
          int i3 = ((SharedPreferences)localObject2).getInt("tips_index", 0);
          long l1 = ((SharedPreferences)localObject2).getLong("tips_last_time", 0L);
          if (i3 == 0)
          {
            localObject2 = ((SharedPreferences)localObject2).edit();
            i1 = i3 + 1;
            ((SharedPreferences.Editor)localObject2).putInt("tips_index", i1).putLong("tips_last_time", System.currentTimeMillis()).commit();
            bool1 = true;
          }
          else
          {
            if (i3 >= 0)
            {
              i1 = i3;
              if (i3 <= 5) {}
            }
            else
            {
              i1 = 5;
            }
            if (System.currentTimeMillis() >= new int[][] { { 0, 0 }, { 1, 3 }, { 2, 3 }, { 3, 7 }, { 4, 7 }, { 5, 14 } }[i1][1] * 86400000L + l1)
            {
              localObject2 = ((SharedPreferences)localObject2).edit();
              i1 += 1;
              ((SharedPreferences.Editor)localObject2).putInt("tips_index", i1).putLong("tips_last_time", System.currentTimeMillis()).commit();
              bool1 = true;
              continue;
              localBaseApplication.getSharedPreferences("qq_background_restric_whitelist_cfg", 0).edit().putInt("tips_index", 0).putLong("tips_last_time", 0L).commit();
              i1 = -1;
              bool1 = false;
              l1 = 0L;
            }
            else
            {
              bool1 = false;
            }
          }
        }
      }
      switch (i2)
      {
      default: 
        i1 = -1;
        bool1 = false;
        l1 = 0L;
        localObject1 = new StringBuilder("checkBackgroundRestricWhilteList");
        ((StringBuilder)localObject1).append(" isActiveNetworkMetered=").append(bool2).append(" restrictStatus=").append(i2).append(" tipsIdx=").append(i1).append(" tipsTime=").append(l1).append(" notice=").append(bool1);
        QLog.d("QQAppInterface", 1, ((StringBuilder)localObject1).toString());
        if (bool1)
        {
          localObject1 = new Intent(localBaseApplication, DialogActivity.class);
          ((Intent)localObject1).addFlags(268435456);
          ((Intent)localObject1).addFlags(536870912);
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).addFlags(131072);
          ((Intent)localObject1).putExtra("key_dialog_type", DialogActivity.jdField_b_of_type_Int);
          localBaseApplication.startActivity((Intent)localObject1);
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
  
  private void ab()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.broadcast", 2, "runNext," + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + "," + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 2) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()))
    {
      Intent localIntent = (Intent)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      if (localIntent != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
        ThreadManager.excute(new QQAppInterface.21(this, System.currentTimeMillis(), localIntent), 32, null, true);
      }
    }
  }
  
  private void ac()
  {
    boolean bool = mtd.d(getApp());
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "checkRamForAvideo isSelfCalling = " + bool);
    }
    if (bool) {}
    long l1;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("checkRamForAvideo getAVNotifyCenter().isBeInvitingOnDoubleVideo() = ");
          a();
          QLog.d("QQAppInterface", 2, AVNotifyCenter.d());
          QLog.d("QQAppInterface", 2, "checkRamForAvideo getAVNotifyCenter().isAvChating() = " + a().b());
        }
        a();
      } while ((AVNotifyCenter.d()) && (!a().b()));
      l1 = bhlo.d() / 1024L / 1024L;
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "checkRamForAvideo memoryTotal = " + l1);
      }
    } while ((!d()) || (l1 == 0L) || (l1 > 2048L));
    ThreadManager.getUIHandler().post(new QQAppInterface.22(this));
  }
  
  private Intent b(Context paramContext, QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    paramContext = new Intent(paramContext, SplashActivity.class);
    paramContext.putExtra("uin", paramMessage.frienduin);
    paramContext.putExtra("troop_uin", paramMessage.senderuin);
    paramContext.putExtra("uintype", paramMessage.istroop);
    paramContext.putExtra("uinname", a(paramMessage, paramBoolean));
    paramContext = agej.a(paramContext, new int[] { 2 });
    paramContext.setAction("com.tencent.mobileqq.action.CHAT");
    return paramContext;
  }
  
  private Bitmap b(int paramInt1, String paramString, byte paramByte1, int paramInt2, boolean paramBoolean, byte paramByte2, int paramInt3)
  {
    String str1 = a(paramInt1, paramString, paramByte1, paramInt3, paramInt2, false);
    Object localObject1 = a(str1);
    boolean bool2 = false;
    boolean bool1;
    String str2;
    bhgn localbhgn;
    label179:
    Bitmap localBitmap;
    if (localObject1 == null) {
      if (paramBoolean)
      {
        localObject1 = a(paramInt1, paramString, paramInt3);
        if (localObject1 != null)
        {
          bool1 = ((Boolean)((Pair)localObject1).first).booleanValue();
          str2 = a(paramInt1, paramString, paramInt3);
          localbhgn = a(str2);
          if (localbhgn.jdField_a_of_type_Int != 0) {
            QLog.i("Q.qqhead.qaif", 2, "getFaceBitmap decodeFile fail, faceType=" + paramInt1 + ", uin=" + paramString + ", result=" + localbhgn.jdField_a_of_type_Int + ", facePath=" + str2);
          }
          if ((!bool1) && (localbhgn.jdField_a_of_type_Int == 1)) {
            return null;
          }
          if (localbhgn.jdField_a_of_type_Int != 2)
          {
            bool2 = true;
            localBitmap = localbhgn.jdField_a_of_type_AndroidGraphicsBitmap;
            if ((localBitmap == null) && (localbhgn.jdField_a_of_type_Int != 1) && (bool2))
            {
              if (paramInt1 != 4) {
                break label454;
              }
              localObject1 = "troop_" + paramString;
            }
          }
        }
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
        if (localInteger == null)
        {
          paramInt2 = 0;
          QLog.i("Q.qqhead.qaif", 1, "getFaceBitmap|file is damaged, key = " + (String)localObject1 + ", nDecodeFailCount = " + paramInt2);
          if (paramInt2 < 3)
          {
            paramInt2 += 1;
            this.jdField_a_of_type_JavaUtilHashMap.put(localObject1, Integer.valueOf(paramInt2));
            bhmi.d(str2);
            QLog.i("Q.qqhead.qaif", 1, "getFaceBitmap|file is damaged, key = " + (String)localObject1 + ", del the damaged file,nDecodeFailCount=" + paramInt2);
          }
          localObject1 = a(paramInt1, paramString, paramByte1, str1, localBitmap, str2, localbhgn);
          a(paramInt1, paramString, paramByte1, paramBoolean, paramInt3, (Bitmap)localObject1, bool1, bool2);
          return localObject1;
          bool2 = false;
          break label179;
        }
        paramInt2 = localInteger.intValue();
      }
      label454:
      localObject1 = paramString;
      continue;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  private anud b(int paramInt)
  {
    anud localanud = anue.a(paramInt, this);
    if ((paramInt == 0) && ((localanud instanceof MessageHandler))) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = ((MessageHandler)localanud);
    }
    return localanud;
  }
  
  public static String b(int paramInt1, String paramString, int paramInt2)
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
      str = paramString;
    } while (paramInt1 != 16);
    return "qcall_" + String.valueOf(paramInt2) + "_" + paramString;
  }
  
  private void b(Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getExtras() == null)) {}
    long l1;
    ArrayList localArrayList;
    label170:
    label207:
    label212:
    long l2;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      int i3 = paramIntent.getExtras().getInt("faceType", 1);
      Object localObject2 = paramIntent.getExtras().getStringArrayList("uinList");
      paramIntent = new ArrayList();
      ??? = new ArrayList();
      localArrayList = new ArrayList();
      if (QLog.isColorLevel()) {
        bhrl.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, receive uinList: ", (ArrayList)localObject2);
      }
      int i1;
      String str;
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        i1 = 0;
        if (i1 < ((ArrayList)localObject2).size())
        {
          str = (String)((ArrayList)localObject2).get(i1);
          int i2;
          if ((str != null) && (str.length() > 0))
          {
            Object localObject3 = new File(a(i3, str, 0));
            if ((!((File)localObject3).exists()) || (!((File)localObject3).isFile())) {
              break label207;
            }
            i2 = 1;
            if (i2 == 0) {
              break label212;
            }
            localObject3 = a(i3, str, 0);
            paramIntent.add(str);
            ((ArrayList)???).add(localObject3);
          }
          for (;;)
          {
            i1 += 1;
            break;
            i2 = 0;
            break label170;
            localArrayList.add(str);
          }
        }
      }
      try
      {
        if (paramIntent.size() > 0)
        {
          localObject2 = new Intent("com.tencent.qqhead.getheadresp");
          ((Intent)localObject2).putExtra("faceType", i3);
          ((Intent)localObject2).putStringArrayListExtra("uinList", paramIntent);
          ((Intent)localObject2).putStringArrayListExtra("headPathList", (ArrayList)???);
          getApp().sendBroadcast((Intent)localObject2, "com.tencent.qqhead.permission.getheadresp");
        }
        if (localArrayList.size() > 0)
        {
          l2 = System.currentTimeMillis();
          localObject2 = (FriendListHandler)a(1);
          i1 = 0;
          if (i1 < localArrayList.size())
          {
            str = (String)localArrayList.get(i1);
            if (i3 == 1) {
              ((FriendListHandler)localObject2).a(str, (byte)0, (byte)2);
            }
          }
        }
      }
      catch (Exception localException)
      {
        synchronized (this.jdField_a_of_type_JavaUtilHashtable)
        {
          do
          {
            for (;;)
            {
              this.jdField_a_of_type_JavaUtilHashtable.put(str, Long.valueOf(l2));
              i1 += 1;
              continue;
              localException = localException;
              QLog.e("Q.qqhead.broadcast", 2, "headQQHeadBroadcast error", localException);
              continue;
              if (i3 == 4)
              {
                ((FriendListHandler)localObject2).d(str);
              }
              else
              {
                if (i3 != 113) {
                  break;
                }
                ((aoip)a(20)).g(str, true);
              }
            }
          } while (i3 != 101);
          ((anwo)a(6)).a(str, true);
        }
      }
      l2 = System.currentTimeMillis();
    } while (!QLog.isColorLevel());
    bhrl.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, response uinList: ", paramIntent);
    bhrl.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, getQQHead uinList: ", localArrayList);
    QLog.i("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, cost=" + (l2 - l1));
  }
  
  private void b(QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    if ((this.jdField_j_of_type_Boolean) || (!bhhv.a(this.app.getApplicationContext(), this)) || (bhhv.b(this.app.getApplicationContext(), this)) || (!axdx.a(this).a(paramMessage))) {
      return;
    }
    label114:
    Intent localIntent;
    StringBuffer localStringBuffer;
    int i1;
    if ((this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.b() == 1) || (paramMessage.istroop == 1037) || (paramMessage.istroop == 1044) || (paramMessage.istroop == 1045))
    {
      localObject = a(getApp(), paramMessage, false);
      ((Intent)localObject).putExtra("entrance", 6);
      localIntent = this.jdField_a_of_type_Aofy.a(paramMessage, (Intent)localObject);
      localIntent.putExtra("key_notification_click_action", true);
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(getApp().getString(2131694054));
      if (paramMessage.istroop == 1037) {
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.a(1037);
      }
      if ((paramMessage.istroop != 1044) && (paramMessage.istroop != 1045)) {
        break label377;
      }
      i1 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.a(1044) + this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.a(1045);
      label233:
      if (i1 == 0) {
        break label389;
      }
      if (i1 <= 1000) {
        break label391;
      }
      localStringBuffer.append(getApp().getString(2131694039));
      label260:
      if (!paramBoolean) {
        break label432;
      }
    }
    label389:
    label391:
    label432:
    for (Object localObject = localStringBuffer.toString();; localObject = null)
    {
      if ((paramMessage.istroop == 1037) || (paramMessage.istroop == 1045) || (paramMessage.istroop == 1044)) {}
      for (String str = getApp().getResources().getString(2131698023);; str = getApp().getResources().getString(2131694050))
      {
        a(localIntent, paramMessage, (String)localObject, str, localStringBuffer.toString(), null, "CMD_SHOW_NOTIFIYCATION");
        return;
        localObject = new Intent(getApp(), SplashActivity.class);
        ((Intent)localObject).addFlags(335544320);
        ((Intent)localObject).putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
        break label114;
        label377:
        i1 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.a();
        break label233;
        break;
        localStringBuffer.append(i1).append(getApp().getString(2131693986));
        break label260;
      }
    }
  }
  
  private void b(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Aoko = new aoko(this, paramMessageRecord);
    this.jdField_a_of_type_Aoko.b(paramMessageRecord, paramBoolean1);
    QLog.d("QQAppInterface", 1, "previous vibrate time is:" + this.jdField_e_of_type_Long + ",curr time is:" + System.currentTimeMillis());
    if (this.jdField_a_of_type_Aoko.a(paramMessageRecord)) {}
    do
    {
      do
      {
        return;
      } while (a(paramMessageRecord, paramBoolean1));
      if (this.jdField_a_of_type_Aoko.c(paramMessageRecord))
      {
        this.jdField_a_of_type_Aoko.a(paramBoolean2);
        return;
      }
      a("vibratorAndAudio_check_public_account_end", new Object[0]);
    } while (!this.jdField_a_of_type_Aoko.a());
    this.jdField_a_of_type_Aoko.b(paramMessageRecord, paramBoolean1, paramBoolean2);
  }
  
  private boolean b(int paramInt, String paramString)
  {
    return (paramInt == 1) && (paramString != null) && ((paramString.equals(antf.J)) || (paramString.equals(antf.H)) || (paramString.equals(antf.E)) || (paramString.equals(antf.G)));
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    if ((String.valueOf(antf.az).equals(paramMessageRecord.frienduin)) && (1008 == paramMessageRecord.istroop)) {}
    while ((String.valueOf(antf.aA).equals(paramMessageRecord.frienduin)) && (7220 == paramMessageRecord.istroop) && (!ozs.a(this, paramMessageRecord))) {
      return true;
    }
    return false;
  }
  
  private boolean b(String paramString)
  {
    return (String.valueOf(antf.G).equals(paramString)) || (String.valueOf(antf.J).equals(paramString)) || (String.valueOf(antf.H).equals(paramString));
  }
  
  private void c(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("title");
    String str2 = paramIntent.getStringExtra("msg");
    if (SystemClock.elapsedRealtime() - this.jdField_g_of_type_Long > 5000L)
    {
      paramIntent.putExtra("entrance", 6);
      paramIntent.putExtra("key_notification_click_action", true);
      a(paramIntent, null, str2, str1, str2, null, "CMD_SHOW_NOTIFIYCATION");
      this.jdField_g_of_type_Long = SystemClock.elapsedRealtime();
    }
  }
  
  private boolean c(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.senderuin != null) && (1008 == paramMessageRecord.istroop) && (twk.a().a(this, paramMessageRecord.senderuin, paramMessageRecord.istroop))) {}
    while ((paramMessageRecord.istroop == 1008) && ((paramMessageRecord.extStr == null) || (((paramMessageRecord.extLong & 0x1) == 0) && (!paramMessageRecord.extStr.contains("lockDisplay"))) || (paramMessageRecord.extStr == null) || (((paramMessageRecord.extLong & 0x1) == 1) && (!paramMessageRecord.getExtInfoFromExtStr("lockDisplay").equals("true"))))) {
      return true;
    }
    return false;
  }
  
  public static String d()
  {
    return ThemeUtil.getCurrentThemeId();
  }
  
  private void d(Intent paramIntent)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramIntent);
    ab();
  }
  
  private void d(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if ((this.jdField_j_of_type_Boolean) || (!bhhv.a(this.app.getApplicationContext(), this))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("notification", 4, String.format("showNoMsgContetnNotifcationForQAV fail 1, message:%s", new Object[] { paramMessageRecord }));
      }
    }
    Object localObject;
    int i1;
    Intent localIntent;
    StringBuffer localStringBuffer;
    int i2;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (baou)getManager(38);
          if (localObject != null) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.d("notification", 4, String.format("showNoMsgContetnNotifcationForQAV fail 2, message:%s", new Object[] { paramMessageRecord }));
        return;
        i1 = ((baou)localObject).b();
      } while (i1 == 0);
      if (i1 != 1) {
        break label472;
      }
      if (((paramMessageRecord.msgtype != -2016) && (paramMessageRecord.msgtype != -4008)) || (paramMessageRecord.istroop != 3000)) {
        break;
      }
      localIntent = a(getApp(), paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord);
      localIntent.putExtra("key_notification_click_action", true);
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(getApp().getString(2131694054));
      i2 = ((baou)localObject).a();
    } while (i2 == 0);
    if (i2 > 1000)
    {
      localStringBuffer.append(getApp().getString(2131694040));
      label228:
      localObject = null;
      if (paramBoolean) {
        localObject = localStringBuffer.toString();
      }
      if (paramMessageRecord.msgtype != -2016) {
        break label546;
      }
      if (QLog.isColorLevel()) {
        QLog.e("notification", 2, "AVNotify:MSG_TYPE_MULTI_VIDEO, count:" + i1);
      }
      if (paramMessageRecord.istroop == 3000)
      {
        if (QLog.isColorLevel()) {
          QLog.e("notification", 2, "AVNotify:UIN_TYPE_DISCUSSION, count:" + i1);
        }
        localIntent.putExtra("qav_notify_flag", true);
      }
    }
    for (;;)
    {
      a(localIntent, paramMessageRecord, (String)localObject, getApp().getResources().getString(2131694050), localStringBuffer.toString(), null, "CMD_SHOW_NOTIFIYCATION");
      return;
      if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1020) || (paramMessageRecord.istroop == 1004))
      {
        localIntent = new Intent(getApp(), SplashActivity.class);
        localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
        localIntent.putExtra("conversation_index", 1);
        localIntent.setFlags(335544320);
        break;
      }
      localIntent = a(getApp(), paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord);
      break;
      label472:
      localIntent = new Intent(getApp(), SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
      localIntent.putExtra("conversation_index", 1);
      localIntent.setFlags(335544320);
      break;
      localStringBuffer.append(i2).append(getApp().getString(2131694043));
      break label228;
      label546:
      if (paramMessageRecord.msgtype == -2009)
      {
        if (QLog.isColorLevel()) {
          QLog.e("notification", 2, "AVNotify:MSG_TYPE_MEDIA_VIDEO, count:" + i1);
        }
        localIntent.putExtra("qav_notify_flag", true);
      }
    }
  }
  
  private boolean d(MessageRecord paramMessageRecord)
  {
    if ((1000 == paramMessageRecord.istroop) || (1020 == paramMessageRecord.istroop))
    {
      if ((paramMessageRecord.frienduin == null) || (!paramMessageRecord.frienduin.equalsIgnoreCase(getCurrentAccountUin()))) {
        break label108;
      }
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "receivedMsgNotification , stranger  self message");
      }
    }
    do
    {
      return true;
      if ((paramMessageRecord.senderuin == null) || (!paramMessageRecord.senderuin.equalsIgnoreCase(getCurrentAccountUin())) || (paramMessageRecord.msgtype == -4008)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("notification", 2, "receivedMsgNotification ,self message");
    return true;
    label108:
    return false;
  }
  
  private String e()
  {
    try
    {
      int i1 = Process.myPid();
      Object localObject = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo.pid == i1)
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
  
  /* Error */
  private String f()
  {
    // Byte code:
    //   0: ldc_w 2739
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 492	com/tencent/mobileqq/app/QQAppInterface:app	Lcom/tencent/common/app/BaseApplicationImpl;
    //   9: invokevirtual 2743	com/tencent/common/app/BaseApplicationImpl:getPackageManager	()Landroid/content/pm/PackageManager;
    //   12: astore_3
    //   13: aload 4
    //   15: astore_2
    //   16: aload_3
    //   17: aload_0
    //   18: getfield 492	com/tencent/mobileqq/app/QQAppInterface:app	Lcom/tencent/common/app/BaseApplicationImpl;
    //   21: invokevirtual 486	com/tencent/common/app/BaseApplicationImpl:getPackageName	()Ljava/lang/String;
    //   24: iconst_0
    //   25: invokevirtual 2749	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
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
    //   46: getfield 2754	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   49: ifnull +85 -> 134
    //   52: aload 4
    //   54: astore_2
    //   55: aload 5
    //   57: getfield 2754	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   60: astore 4
    //   62: aload 4
    //   64: astore_3
    //   65: aload 4
    //   67: ifnull +67 -> 134
    //   70: aload 4
    //   72: astore_2
    //   73: aload 4
    //   75: ldc_w 2756
    //   78: invokevirtual 420	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   101: new 141	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   108: aload 4
    //   110: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 2758
    //   116: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   84	44	1	i1	int
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
  
  public static void f(String paramString)
  {
    TextToSpeech localTextToSpeech = jdField_a_of_type_AndroidSpeechTtsTextToSpeech;
    if ((localTextToSpeech != null) && (!TextUtils.isEmpty(paramString))) {
      localTextToSpeech.speak(paramString, 1, null);
    }
  }
  
  private void h(int paramInt) {}
  
  public void A()
  {
    this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void B()
  {
    long l2 = 0L;
    long l1;
    if ((!this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) && (this.m))
    {
      l1 = l2;
      if (this.jdField_c_of_type_Long != 0L)
      {
        l1 = jdField_e_of_type_Int - (SystemClock.uptimeMillis() - this.jdField_c_of_type_Long);
        if (l1 >= 0L) {
          break label116;
        }
        l1 = l2;
      }
    }
    label116:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "onResume send msg " + l1);
      }
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, new WeakReference(this));
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, l1);
      return;
    }
  }
  
  public void C()
  {
    MagnifierSDK.a().a().a(this, String.format("%d", new Object[] { Long.valueOf(getLongAccountUin()) }));
  }
  
  public void D()
  {
    if (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade != null) {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.b();
    }
    Object localObject = (bdxc)getManager(61);
    if (localObject != null) {
      ((bdxc)localObject).b();
    }
    localObject = (aold)getManager(85);
    if (localObject != null) {
      ((aold)localObject).d();
    }
  }
  
  public void E()
  {
    if (((this.isBackgroundPause) || (this.isBackgroundStop)) && (blgq.a(this.app.getApplicationContext())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "refreshAppBadge");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface$RefreshBadgeHelper.a();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QQAppInterface", 2, "refreshAppBadge fail cause isBackground_Pause = " + this.isBackgroundPause + ", isBackground_Stop = " + this.isBackgroundStop + ", isSupportBadge + " + blgq.a(this.app.getApplicationContext()));
  }
  
  @TargetApi(14)
  public void F()
  {
    try
    {
      Object localObject = (AccessibilityManager)this.app.getSystemService("accessibility");
      bool1 = ((AccessibilityManager)localObject).isEnabled();
      boolean bool2 = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
      if ((!bool1) || (!bool2)) {
        break label188;
      }
      bool1 = true;
      AppSetting.jdField_c_of_type_Boolean = bool1;
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "set talkback enable: " + AppSetting.jdField_c_of_type_Boolean);
      }
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences("Talkback", 0);
        long l1 = ((SharedPreferences)localObject).getLong("LastTime", 0L);
        if (System.currentTimeMillis() - l1 > 86400000L)
        {
          bdmc.a(this.app).a(null, "enableTalkback", true, 0L, 0L, null, null);
          ((SharedPreferences)localObject).edit().putLong("LastTime", System.currentTimeMillis()).commit();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      boolean bool1;
      label161:
      label188:
      break label161;
    }
    if (AppSetting.jdField_c_of_type_Boolean) {
      if (jdField_a_of_type_AndroidSpeechTtsTextToSpeech == null) {
        jdField_a_of_type_AndroidSpeechTtsTextToSpeech = new TextToSpeech(BaseApplicationImpl.sApplication, null);
      }
    }
    while (jdField_a_of_type_AndroidSpeechTtsTextToSpeech == null)
    {
      return;
      bool1 = false;
      break;
    }
    jdField_a_of_type_AndroidSpeechTtsTextToSpeech.stop();
    jdField_a_of_type_AndroidSpeechTtsTextToSpeech = null;
  }
  
  public void G()
  {
    int i1 = 2131691101;
    if ((this.app != null) && (isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "onX2Mobile ");
      }
      localObject1 = a();
      bool1 = ((beyb)localObject1).c();
      bool2 = ((beyb)localObject1).a();
      bool3 = ((beyb)localObject1).b();
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
          break label307;
        }
        if (!bool3) {
          break label296;
        }
      }
    }
    label296:
    label307:
    while (!QLog.isColorLevel())
    {
      Object localObject1;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      Object localObject2;
      i1 = 2131691102;
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("QQAppInterface", 2, "onX2Mobile==============pauseAllRawSendC2C:" + bool1);
          QLog.d("QQAppInterface", 2, "onX2Mobile==============pauseAllShortVideoSend:" + bool2);
          QLog.d("QQAppInterface", 2, "onX2Mobile==============pauseAllShortVideoReceive:" + bool3);
          QLog.d("QQAppInterface", 2, "onX2Mobile==============dialog message:" + ((Context)localObject1).getResources().getString(i1));
        }
        ((Intent)localObject2).putExtra("key_dialog_msg_id", i1);
        ((Context)localObject1).startActivity((Intent)localObject2);
        return;
        if (!bool1)
        {
          i1 = 2131691099;
          continue;
          if (bool3)
          {
            if (!bool1) {
              i1 = 2131691097;
            }
          }
          else {
            i1 = 2131691100;
          }
        }
      }
    }
    QLog.d("QQAppInterface", 2, "onX2Mobile app = null,maybe not QQ process");
  }
  
  public void H()
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
  
  public void I()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + getCurrentAccountUin(), 0);
    if (localSharedPreferences != null) {
      jdField_b_of_type_Int = localSharedPreferences.getInt("browser_font_size_index", 1);
    }
  }
  
  public void K()
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
      int i2 = localObject.length;
      int i1 = 0;
      if (i1 < i2)
      {
        CharSequence localCharSequence = localObject[i1];
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
          i1 += 1;
          break;
          localHashMap.put("BusinessName", arrayOfString[0]);
          localHashMap.put("needMigrate", "false");
          localHashMap.put("doMigrate", "null");
          localHashMap.put("fileSize", "-1");
          localHashMap.put("fileAmount", "-1");
          bdmc.a(getApp()).a(c(), "SecureFileStep", true, 0L, 0L, localHashMap, "");
          continue;
          localHashMap.put("BusinessName", arrayOfString[0]);
          localHashMap.put("needMigrate", "true");
          localHashMap.put("doMigrate", arrayOfString[4]);
          localHashMap.put("fileSize", arrayOfString[2]);
          localHashMap.put("fileAmount", arrayOfString[3]);
          try
          {
            bdmc.a(getApp()).a(c(), "SecureFileStep", true, 0L, 0L, localHashMap, "");
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
  
  public void L()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "registerBatteryBroadcastReceiver start");
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver == null) && (getOnlineStatusNonSync() == AppRuntime.Status.online) && (getExtOnlineStatus() == 1000L))
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver = new BatteryBroadcastReceiver(this);
        BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver, localIntentFilter);
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
  
  public void M()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "unRegisterBatteryBroadcastReceiver start");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver != null)
      {
        BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver);
        this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver = null;
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
  
  public int a()
  {
    bhru localbhru = (bhru)getManager(31);
    if (localbhru != null) {
      return localbhru.b("message.group.ring", 0);
    }
    return 0;
  }
  
  public int a(int paramInt)
  {
    int i2 = -1;
    int i1;
    if ((this.app == null) || (paramInt < 0) || (paramInt >= 7))
    {
      i1 = i2;
      if (QLog.isColorLevel())
      {
        QLog.e("QQAppInterface", 2, "readCallTabStateVal wrong index," + paramInt);
        i1 = i2;
      }
    }
    do
    {
      String str;
      do
      {
        return i1;
        str = SettingCloneUtil.readValue(getApplication(), getCurrentAccountUin(), null, "qqsetting_calltab_show_key", "0111100");
        if ((str != null) && (str.length() == 7)) {
          break;
        }
        i1 = i2;
      } while (!QLog.isColorLevel());
      QLog.e("QQAppInterface", 2, "readCallTabStateVal val is null");
      return -1;
      i2 = str.charAt(paramInt) - '0';
      i1 = i2;
    } while (!QLog.isColorLevel());
    QLog.i("QQAppInterface", 2, "uin:" + getCurrentAccountUin() + ",readCallTabStateVal index=" + paramInt + ", resut=" + i2);
    return i2;
  }
  
  public int a(String paramString)
  {
    int i3 = 0;
    try
    {
      Class[] arrayOfClass = Class.forName("com.android.internal.R").getDeclaredClasses();
      int i4 = arrayOfClass.length;
      int i1 = 0;
      for (;;)
      {
        int i2 = i3;
        if (i1 < i4)
        {
          Class localClass = arrayOfClass[i1];
          if ("id".equals(localClass.getSimpleName())) {
            i2 = localClass.getDeclaredField(paramString).getInt(null);
          }
        }
        else
        {
          return i2;
        }
        i1 += 1;
      }
      return 0;
    }
    catch (Exception paramString) {}
  }
  
  public long a()
  {
    if (f()) {
      return getOnlineStatus().getValue();
    }
    return AppRuntime.Status.offline.getValue();
  }
  
  public adab a()
  {
    if (this.jdField_a_of_type_Adab == null) {
      this.jdField_a_of_type_Adab = ((adab)getManager(29));
    }
    return this.jdField_a_of_type_Adab;
  }
  
  public adai a(int paramInt)
  {
    ProxyManager localProxyManager = a();
    if (localProxyManager != null)
    {
      if (10007 == paramInt) {
        return localProxyManager.a();
      }
      return localProxyManager.a().a(paramInt);
    }
    return null;
  }
  
  public Intent a(Context paramContext, QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    if ((paramMessage.istroop == 1000) || (paramMessage.istroop == 1020) || (paramMessage.istroop == 1004))
    {
      if (alpb.a(this, paramMessage.frienduin)) {
        return a(getApp(), paramMessage, 0);
      }
      return b(paramContext, paramMessage, paramBoolean);
    }
    return a(getApp(), paramMessage, paramMessage.istroop);
  }
  
  public Bitmap a(int paramInt1, String paramString, byte paramByte1, int paramInt2, boolean paramBoolean, byte paramByte2, int paramInt3)
  {
    byte b1 = 3;
    if (b(paramInt1, paramString)) {
      return bhmq.i();
    }
    if ((paramInt1 == 32) && (antf.H.equals(paramString))) {
      return bhjd.a(BaseApplicationImpl.getContext().getResources().getDrawable(2130840363));
    }
    if (a(paramInt1, paramString)) {
      return null;
    }
    if ((paramInt1 == 101) || (paramInt1 == 1001)) {
      paramByte1 = 3;
    }
    for (;;)
    {
      if ((paramInt1 == 4) && (!bguq.a(paramString))) {
        paramInt1 = 113;
      }
      for (;;)
      {
        if (paramInt1 == 113) {
          paramByte1 = b1;
        }
        for (;;)
        {
          return b(paramInt1, paramString, aope.a(paramByte1), paramInt2, paramBoolean, paramByte2, paramInt3);
        }
      }
    }
  }
  
  public Bitmap a(int paramInt1, String paramString, byte paramByte1, boolean paramBoolean, byte paramByte2, int paramInt2)
  {
    return a(paramInt1, paramString, paramByte1, 100, paramBoolean, paramByte2, paramInt2);
  }
  
  public Bitmap a(int paramInt1, String paramString, byte paramByte, boolean paramBoolean, int paramInt2)
  {
    return a(paramInt1, paramString, paramByte, paramBoolean, (byte)1, paramInt2);
  }
  
  public Bitmap a(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    return a(paramInt1, paramString, (byte)3, paramBoolean, paramInt2);
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    return bhmq.c(paramBitmap, 50, 50);
  }
  
  public Bitmap a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
    {
      Bitmap localBitmap2 = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
        {
          localBitmap1 = localBitmap2;
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
          {
            long l1 = ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();
            localBitmap1 = localBitmap2;
            if (System.currentTimeMillis() - l1 > jdField_d_of_type_Long)
            {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
              this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(paramString);
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
  
  public Bitmap a(String paramString, byte paramByte, boolean paramBoolean)
  {
    return a(1, paramString, paramByte, paramBoolean, 0);
  }
  
  public Bitmap a(String paramString, byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(4, paramString, paramByte, true, 0);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = bhmq.f();
    }
    localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramBoolean1) {
        localObject = bhmq.a(paramString);
      }
    }
    paramString = (String)localObject;
    if (localObject != null)
    {
      paramString = (String)localObject;
      if (paramBoolean2) {
        paramString = b((Bitmap)localObject);
      }
    }
    return paramString;
  }
  
  public Bitmap a(String paramString, int paramInt)
  {
    return a(32, paramString, true, paramInt);
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    return a(1, paramString, (byte)3, paramBoolean, 0);
  }
  
  public Drawable a(String paramString)
  {
    return a(paramString, (byte)3, false, false);
  }
  
  public Drawable a(String paramString, byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(paramString, paramByte, paramBoolean1, paramBoolean2);
    paramString = null;
    if (localObject != null) {
      paramString = new BitmapDrawable((Bitmap)localObject);
    }
    localObject = paramString;
    if (paramString == null) {
      localObject = bhmq.c();
    }
    return localObject;
  }
  
  public Drawable a(String paramString, boolean paramBoolean, byte paramByte)
  {
    Object localObject = a(1, paramString, paramByte, true, 0);
    if ((localObject != null) && (paramBoolean)) {
      localObject = bhmq.a((Bitmap)localObject);
    }
    for (;;)
    {
      paramString = null;
      if (localObject != null) {
        paramString = new BitmapDrawable((Bitmap)localObject);
      }
      localObject = paramString;
      if (paramString == null) {
        localObject = bhmq.b();
      }
      return localObject;
    }
  }
  
  public Pair<Boolean, Setting> a(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject2 = null;
    String str = b(paramInt1, paramString, paramInt2);
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(str))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache != null) {
        localObject1 = (Setting)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(str);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null)
        {
          N();
          localObject1 = (Setting)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(Setting.class, str);
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(str, localObject1);
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
        QLog.i("Q.qqhead.qaif", 2, "getQQHeadSetting. | uin=" + paramString + ", isNeedCheckQQHead=" + bool + ", accountStartTime=" + this.jdField_f_of_type_Long + ", updateTimestamp=" + localObject2.updateTimestamp + ", headImgTimestamp=" + localObject2.headImgTimestamp + ", status=" + localObject2.getStatus() + ", id=" + localObject2.getId() + ", currentTimeMillis=" + System.currentTimeMillis());
      }
      return new Pair(Boolean.valueOf(bool), localObject2);
      if ((localObject2 == null) || (System.currentTimeMillis() - localObject2.updateTimestamp > jdField_d_of_type_Long)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public Pair<Boolean, Bitmap> a(String paramString, byte paramByte, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    paramString = a(1, paramString, paramByte, true, 0);
    if (paramString == null) {
      paramString = bhmq.a();
    }
    for (;;)
    {
      return Pair.create(Boolean.valueOf(bool), paramString);
      bool = true;
    }
  }
  
  public anud a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAnud[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_ArrayOfAnud)
    {
      anud localanud = this.jdField_a_of_type_ArrayOfAnud[paramInt];
      localObject1 = localanud;
      if (localanud == null)
      {
        localanud = b(paramInt);
        localObject1 = localanud;
        if (localanud != null)
        {
          this.jdField_a_of_type_ArrayOfAnud[paramInt] = localanud;
          localObject1 = localanud;
        }
      }
      return localObject1;
    }
  }
  
  public anuy a()
  {
    return this.jdField_a_of_type_Anuy;
  }
  
  public anuz a()
  {
    return this.jdField_a_of_type_Anuz;
  }
  
  public aoaw a()
  {
    n();
    return this.jdField_a_of_type_Aoaw;
  }
  
  public aoex a()
  {
    if (this.jdField_a_of_type_Aoex == null) {
      this.jdField_a_of_type_Aoex = new aoex(this);
    }
    return this.jdField_a_of_type_Aoex;
  }
  
  public aolf a()
  {
    if (this.jdField_a_of_type_Aolf == null) {
      this.jdField_a_of_type_Aolf = ((aolf)getManager(19));
    }
    return this.jdField_a_of_type_Aolf;
  }
  
  public aost a()
  {
    if (a() != null) {
      return a().a();
    }
    return null;
  }
  
  public apas a(int paramInt)
  {
    return a().a(paramInt);
  }
  
  public apau a()
  {
    if (this.jdField_a_of_type_Apau == null) {
      this.jdField_a_of_type_Apau = ((apau)getManager(130));
    }
    return this.jdField_a_of_type_Apau;
  }
  
  public apaw a()
  {
    if (this.jdField_a_of_type_Apaw == null) {}
    try
    {
      if (this.jdField_a_of_type_Apaw == null) {
        this.jdField_a_of_type_Apaw = new apaw(this, a().getDBDelayManager());
      }
      return this.jdField_a_of_type_Apaw;
    }
    finally {}
  }
  
  public aqzq a()
  {
    T();
    return this.jdField_a_of_type_Aqzq;
  }
  
  public aqzs a()
  {
    return this.jdField_a_of_type_Aqzs;
  }
  
  public aqzw a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Aqzw == null) {
        this.jdField_a_of_type_Aqzw = new aqzw(this, paramString);
      }
      paramString = this.jdField_a_of_type_Aqzw;
      return paramString;
    }
    finally {}
  }
  
  public aqzw a(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Aqzw == null) && (paramBoolean)) {
      a(paramString);
    }
    return this.jdField_a_of_type_Aqzw;
  }
  
  public atqx a()
  {
    if (this.jdField_a_of_type_Atqx == null) {}
    try
    {
      if (this.jdField_a_of_type_Atqx == null) {
        this.jdField_a_of_type_Atqx = new atqx(this);
      }
      return this.jdField_a_of_type_Atqx;
    }
    finally {}
  }
  
  public atrd a()
  {
    if (this.jdField_a_of_type_Atrd == null) {
      this.jdField_a_of_type_Atrd = new atrd(this);
    }
    return this.jdField_a_of_type_Atrd;
  }
  
  public atup a()
  {
    if (this.jdField_a_of_type_Atup == null) {
      this.jdField_a_of_type_Atup = new atup(this);
    }
    return this.jdField_a_of_type_Atup;
  }
  
  public atur a()
  {
    if (this.jdField_a_of_type_Atur == null) {
      this.jdField_a_of_type_Atur = new atur(this);
    }
    return this.jdField_a_of_type_Atur;
  }
  
  public atut a()
  {
    if (this.jdField_a_of_type_Atut == null) {
      this.jdField_a_of_type_Atut = new atut(this);
    }
    return this.jdField_a_of_type_Atut;
  }
  
  public atws a()
  {
    if (this.jdField_a_of_type_Atws == null) {
      this.jdField_a_of_type_Atws = new atws(this);
    }
    return this.jdField_a_of_type_Atws;
  }
  
  public atzd a()
  {
    ProxyManager localProxyManager = a();
    if (localProxyManager != null) {
      return localProxyManager.a();
    }
    return null;
  }
  
  public auue a()
  {
    ProxyManager localProxyManager = a();
    if (localProxyManager != null) {
      return localProxyManager.a();
    }
    return null;
  }
  
  public avlk a()
  {
    if (this.jdField_a_of_type_Avlk == null) {}
    try
    {
      if (this.jdField_a_of_type_Avlk == null) {
        this.jdField_a_of_type_Avlk = new avlk(this, a().getDBDelayManager());
      }
      return this.jdField_a_of_type_Avlk;
    }
    finally {}
  }
  
  public axpe a()
  {
    if (this.jdField_a_of_type_Axpe == null) {}
    try
    {
      if (this.jdField_a_of_type_Axpe == null) {
        this.jdField_a_of_type_Axpe = new axpe(this);
      }
      return this.jdField_a_of_type_Axpe;
    }
    finally {}
  }
  
  public axwf a()
  {
    return (axwf)getManager(116);
  }
  
  public baou a()
  {
    if (this.jdField_a_of_type_Baou == null) {
      this.jdField_a_of_type_Baou = ((baou)getManager(38));
    }
    return this.jdField_a_of_type_Baou;
  }
  
  public bayl a()
  {
    return (bayl)getManager(91);
  }
  
  public bbxk a()
  {
    if (this.jdField_a_of_type_Bbxk == null) {
      this.jdField_a_of_type_Bbxk = ((bbxk)getManager(136));
    }
    return this.jdField_a_of_type_Bbxk;
  }
  
  public bcrg a()
  {
    if (this.jdField_a_of_type_Bcrg == null) {}
    synchronized (this.jdField_a_of_type_ArrayOfAnud)
    {
      if (this.jdField_a_of_type_Bcrg == null) {
        this.jdField_a_of_type_Bcrg = new bcrg(this);
      }
      return this.jdField_a_of_type_Bcrg;
    }
  }
  
  public bcxf a()
  {
    if (this.jdField_a_of_type_Bcxf == null) {
      this.jdField_a_of_type_Bcxf = ((bcxf)getManager(95));
    }
    return this.jdField_a_of_type_Bcxf;
  }
  
  public bdll a()
  {
    if (this.jdField_a_of_type_Bdll == null) {}
    try
    {
      if (this.jdField_a_of_type_Bdll == null) {
        this.jdField_a_of_type_Bdll = ReportControllerImpl.a(this);
      }
      return this.jdField_a_of_type_Bdll;
    }
    finally {}
  }
  
  public beyb a()
  {
    if (this.jdField_a_of_type_Beyb == null) {}
    try
    {
      if (this.jdField_a_of_type_Beyb == null) {
        this.jdField_a_of_type_Beyb = new beyb(this);
      }
      return this.jdField_a_of_type_Beyb;
    }
    finally {}
  }
  
  @NonNull
  public bhgn a(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = jdField_a_of_type_AndroidGraphicsBitmap$Config;
    bhgn localbhgn = new bhgn();
    int i1 = 0;
    do
    {
      bhgm.a(paramString, localOptions, localbhgn);
      if (localbhgn.jdField_a_of_type_Int == 1) {
        P();
      }
      i1 += 1;
    } while ((i1 < 2) && (localbhgn.jdField_a_of_type_Int == 1));
    return localbhgn;
  }
  
  public bmim a()
  {
    if (this.jdField_a_of_type_Bmim == null) {
      this.jdField_a_of_type_Bmim = new bmim(this);
    }
    return this.jdField_a_of_type_Bmim;
  }
  
  public bmjd a()
  {
    if (this.jdField_a_of_type_Bmjd == null) {
      this.jdField_a_of_type_Bmjd = new bmjd(this);
    }
    return this.jdField_a_of_type_Bmjd;
  }
  
  public AVNotifyCenter a()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter == null) {
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter = new AVNotifyCenter(this);
    }
    return this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter;
  }
  
  public QQMessageFacade a()
  {
    if (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade == null) {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade = ((QQMessageFacade)getManager(20));
    }
    return this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
  }
  
  public HotChatManager a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager == null) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager = ((HotChatManager)getManager(60));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager;
  }
  
  public MessageHandler a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = ((MessageHandler)a(0));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
  }
  
  public SQLiteDatabase a()
  {
    SQLiteOpenHelper localSQLiteOpenHelper = a();
    if (localSQLiteOpenHelper != null) {
      return localSQLiteOpenHelper.getReadableDatabase();
    }
    return null;
  }
  
  public SQLiteDatabase a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.getWritableDatabase();
    }
    return null;
  }
  
  public ProxyManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager = ((ProxyManager)getManager(18));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager;
  }
  
  public ExtensionInfo a(String paramString, boolean paramBoolean)
  {
    anyw localanyw = (anyw)getManager(51);
    if ((localanyw != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null))
    {
      ExtensionInfo localExtensionInfo2 = localanyw.a(paramString, false);
      ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
      if (localExtensionInfo2 == null)
      {
        localExtensionInfo1 = localExtensionInfo2;
        if (paramBoolean)
        {
          localExtensionInfo1 = (ExtensionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(ExtensionInfo.class, paramString);
          localanyw.a(localExtensionInfo1);
        }
      }
      return localExtensionInfo1;
    }
    return null;
  }
  
  public MsgBoxInterFollowManager a()
  {
    return (MsgBoxInterFollowManager)getManager(202);
  }
  
  public QQEntityManagerFactory a()
  {
    String str = getAccount();
    if (str == null) {
      throw new IllegalStateException("WTF");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory != null) {
      return this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory = new QQEntityManagerFactory(str);
        ThreadManager.getSubThreadHandler().postDelayed(new QQAppInterface.7(this), 3000L);
      }
      return this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory;
    }
    finally {}
  }
  
  public Setting a(String paramString)
  {
    return (Setting)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(Setting.class, paramString);
  }
  
  public PicPreDownloader a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader == null) {
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader = ((PicPreDownloader)getManager(39));
    }
    return this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader;
  }
  
  public ShortVideoResourceManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager = ((ShortVideoResourceManager)getManager(229));
    }
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager;
  }
  
  public ISecureModuleService a()
  {
    if (this.jdField_a_of_type_ComTencentSecuremoduleServiceISecureModuleService == null) {
      this.jdField_a_of_type_ComTencentSecuremoduleServiceISecureModuleService = SecureModuleService.getInstance(this.app);
    }
    return this.jdField_a_of_type_ComTencentSecuremoduleServiceISecureModuleService;
  }
  
  @Deprecated
  public String a()
  {
    return null;
  }
  
  public String a(int paramInt, String paramString)
  {
    Object localObject = MD5.toMD5(paramString);
    localObject = MD5.toMD5((String)localObject + paramString);
    paramString = MD5.toMD5((String)localObject + paramString);
    localObject = new StringBuilder(256);
    if (paramInt == 4) {
      if (bhjr.a()) {
        ((StringBuilder)localObject).append(antf.bN);
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
      if (bhjr.a()) {
        ((StringBuilder)localObject).append(antf.bM);
      } else {
        ((StringBuilder)localObject).append("/data/data/com.tencent.mobileqq/files/head/_hd/");
      }
    }
  }
  
  public String a(int paramInt1, String paramString, byte paramByte, int paramInt2)
  {
    return a(paramInt1, paramString, paramByte, paramInt2, 100, false);
  }
  
  public String a(int paramInt1, String paramString, byte paramByte, int paramInt2, int paramInt3, boolean paramBoolean)
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
            break label194;
          }
          localObject1 = b(b(paramInt1, paramString, paramInt2));
        }
      }
    }
    localObject1 = a((Setting)localObject1, paramString, paramInt1);
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
      label194:
      localObject1 = (Setting)a(paramInt1, paramString, paramInt2).second;
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
    }
  }
  
  public String a(int paramInt1, String paramString, int paramInt2)
  {
    return a(null, paramInt1, paramString, paramInt2);
  }
  
  public String a(Setting paramSetting, int paramInt)
  {
    if (paramSetting == null) {
      return "";
    }
    int i1 = paramSetting.bUsrType;
    String str = bhjx.c(paramSetting.uin);
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    return a(paramSetting, i1, str, paramInt);
  }
  
  public String a(Setting paramSetting, int paramInt1, String paramString, int paramInt2)
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
          if (paramInt1 != 1001) {
            localObject = (Setting)a(paramInt1, paramString, paramInt2).second;
          }
        }
      }
    }
    paramSetting = new StringBuilder(256);
    if (paramInt1 == 32) {
      if (bhjr.a())
      {
        paramSetting.append(antf.bO);
        localObject = a((Setting)localObject, paramString, paramInt1);
        switch (((Integer)localObject[0]).intValue())
        {
        }
      }
    }
    for (;;)
    {
      localObject = MD5.toMD5(paramString);
      localObject = MD5.toMD5((String)localObject + paramString);
      paramSetting.append(MD5.toMD5((String)localObject + paramString));
      paramSetting.append(".jpg_");
      return paramSetting.toString();
      paramSetting.append("/data/data/com.tencent.mobileqq/files/head/_stranger/");
      break;
      if (bhjr.a())
      {
        paramSetting.append(antf.bM);
        break;
      }
      paramSetting.append("/data/data/com.tencent.mobileqq/files/head/_hd/");
      break;
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
    }
  }
  
  public String a(ServerConfigManager.ConfigType paramConfigType, String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(32);
      localStringBuilder.append("getServerConfigValue type=").append(paramConfigType).append(", key=").append(paramString).append(", value=");
    }
    for (;;)
    {
      long l1 = System.currentTimeMillis();
      if ((this.jdField_b_of_type_JavaUtilHashtable.containsKey(paramConfigType)) && (this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramConfigType)) && (l1 - ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramConfigType)).longValue() < 7200000L))
      {
        paramConfigType = (HashMap)this.jdField_b_of_type_JavaUtilHashtable.get(paramConfigType);
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
        aoew localaoew = new aoew(this);
        localXMLReader.setContentHandler(localaoew);
        localXMLReader.parse(new InputSource(new ByteArrayInputStream(((String)localObject).getBytes("UTF-8"))));
        localObject = localaoew.a();
        this.jdField_b_of_type_JavaUtilHashtable.put(paramConfigType, localObject);
        this.jdField_b_of_type_JavaUtilHashMap.put(paramConfigType, Long.valueOf(l1));
        l1 = System.currentTimeMillis() - l1;
        if (localStringBuilder != null)
        {
          localStringBuilder.append((String)((HashMap)localObject).get(paramString));
          localStringBuilder.append(",cost:").append(l1);
          QLog.d("QQAppInterface", 2, localStringBuilder.toString());
        }
        if (l1 > 2000L) {
          bdmc.a(BaseApplicationImpl.getContext()).a(getCurrentAccountUin(), "getConfigLongCost", true, l1, 0L, null, null);
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
  
  public String a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return a(null, 4, paramString, 0);
    }
    return a(null, 1, paramString, 0);
  }
  
  /* Error */
  public HashMap<Integer, String[]> a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 361	java/util/HashMap
    //   6: dup
    //   7: invokespecial 362	java/util/HashMap:<init>	()V
    //   10: astore 7
    //   12: aload_0
    //   13: getfield 492	com/tencent/mobileqq/app/QQAppInterface:app	Lcom/tencent/common/app/BaseApplicationImpl;
    //   16: invokevirtual 3554	com/tencent/common/app/BaseApplicationImpl:getContentResolver	()Landroid/content/ContentResolver;
    //   19: new 141	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   26: ldc_w 3556
    //   29: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: invokevirtual 796	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   36: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 3561	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   45: iconst_1
    //   46: anewarray 135	java/lang/String
    //   49: dup
    //   50: iconst_0
    //   51: ldc_w 1474
    //   54: aastore
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: invokevirtual 3567	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   61: astore_3
    //   62: aload_3
    //   63: astore 4
    //   65: aload_0
    //   66: aload 4
    //   68: invokespecial 3569	com/tencent/mobileqq/app/QQAppInterface:a	(Landroid/database/Cursor;)Ljava/util/ArrayList;
    //   71: astore 5
    //   73: aload 5
    //   75: astore_3
    //   76: aload 4
    //   78: ifnull +13 -> 91
    //   81: aload 4
    //   83: invokeinterface 3572 1 0
    //   88: aload 5
    //   90: astore_3
    //   91: iload_1
    //   92: bipush 254
    //   94: if_icmpne +78 -> 172
    //   97: aload_3
    //   98: ifnull +35 -> 133
    //   101: aload_3
    //   102: invokevirtual 710	java/util/ArrayList:size	()I
    //   105: ifle +28 -> 133
    //   108: aload 7
    //   110: bipush 254
    //   112: invokestatic 1531	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: aload_3
    //   116: aload_3
    //   117: invokevirtual 710	java/util/ArrayList:size	()I
    //   120: anewarray 135	java/lang/String
    //   123: invokevirtual 1535	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   126: checkcast 1537	[Ljava/lang/String;
    //   129: invokevirtual 1541	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   132: pop
    //   133: aload 7
    //   135: areturn
    //   136: astore_3
    //   137: aconst_null
    //   138: astore 4
    //   140: aload 4
    //   142: ifnull +254 -> 396
    //   145: aload 4
    //   147: invokeinterface 3572 1 0
    //   152: aconst_null
    //   153: astore_3
    //   154: goto -63 -> 91
    //   157: astore_3
    //   158: aload 4
    //   160: ifnull +10 -> 170
    //   163: aload 4
    //   165: invokeinterface 3572 1 0
    //   170: aload_3
    //   171: athrow
    //   172: aload_3
    //   173: ifnull +212 -> 385
    //   176: aload_0
    //   177: aload_3
    //   178: invokevirtual 3575	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/util/List;)Ljava/util/Map;
    //   181: astore 8
    //   183: aload 8
    //   185: ifnull +183 -> 368
    //   188: new 253	java/util/ArrayList
    //   191: dup
    //   192: invokespecial 254	java/util/ArrayList:<init>	()V
    //   195: astore 6
    //   197: new 253	java/util/ArrayList
    //   200: dup
    //   201: invokespecial 254	java/util/ArrayList:<init>	()V
    //   204: astore 4
    //   206: new 253	java/util/ArrayList
    //   209: dup
    //   210: invokespecial 254	java/util/ArrayList:<init>	()V
    //   213: astore 5
    //   215: iconst_0
    //   216: istore_2
    //   217: iload_2
    //   218: aload_3
    //   219: invokevirtual 710	java/util/ArrayList:size	()I
    //   222: if_icmpge +128 -> 350
    //   225: aload_3
    //   226: iload_2
    //   227: invokevirtual 1204	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   230: checkcast 135	java/lang/String
    //   233: astore 9
    //   235: aload 8
    //   237: aload 9
    //   239: invokeinterface 3578 2 0
    //   244: checkcast 422	java/lang/Integer
    //   247: invokevirtual 2371	java/lang/Integer:intValue	()I
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
    //   301: invokevirtual 1191	java/util/ArrayList:add	(Ljava/lang/Object;)Z
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
    //   322: invokevirtual 1191	java/util/ArrayList:add	(Ljava/lang/Object;)Z
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
    //   343: invokevirtual 1191	java/util/ArrayList:add	(Ljava/lang/Object;)Z
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
    //   362: invokespecial 3580	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/util/HashMap;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V
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
    //   216	68	2	i1	int
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
  
  public List<LebaPluginInfo> a()
  {
    if (this.jdField_a_of_type_Aoaw != null) {
      return this.jdField_a_of_type_Aoaw.a();
    }
    return null;
  }
  
  public Map<String, Integer> a(List<String> paramList)
  {
    bhru localbhru = (bhru)getManager(31);
    if (localbhru != null) {
      return localbhru.a(paramList, 1);
    }
    return null;
  }
  
  public ldi a()
  {
    if (this.jdField_a_of_type_Ldi == null) {
      this.jdField_a_of_type_Ldi = new ldi(this);
    }
    return this.jdField_a_of_type_Ldi;
  }
  
  public nql a()
  {
    return (nql)getManager(171);
  }
  
  public void a()
  {
    if (!this.jdField_f_of_type_Boolean) {
      this.jdField_f_of_type_Boolean = true;
    }
    while ((!isLogin()) || (!this.jdField_f_of_type_Boolean)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqfav", 2, "Wifi, tryReuploadQfavItems");
    }
    bmkq.a(this);
  }
  
  public void a(int paramInt)
  {
    try
    {
      ((anum)a(2)).b(paramInt);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    int i1 = 0;
    paramString = a(paramInt1, paramString, (byte)0, paramInt2);
    paramInt1 = i1;
    while (paramInt1 <= 3)
    {
      String str = paramString + "_" + paramInt1;
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(str);
      paramInt1 += 1;
    }
  }
  
  public void a(int paramInt1, String arg2, int paramInt2, String arg4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.broadcast", 2, "sendQQHeadBroadcast.type=" + paramInt1 + ",uin=" + ??? + ",idType=" + paramInt2 + ",path=" + ???);
    }
    if (!this.jdField_a_of_type_JavaUtilHashtable.containsKey(???)) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashtable)
    {
      this.jdField_a_of_type_JavaUtilHashtable.remove(???);
      if (paramInt1 != 1) {}
    }
    Object localObject;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(???);
        ??? = this.jdField_c_of_type_AndroidOsHandler.obtainMessage();
        ???.what = 990;
        this.jdField_c_of_type_AndroidOsHandler.sendMessageDelayed(???, 500L);
        if (this.jdField_a_of_type_JavaUtilHashtable.size() <= 50) {
          break;
        }
        synchronized (this.jdField_a_of_type_JavaUtilHashtable)
        {
          long l1 = System.currentTimeMillis();
          ??? = new ArrayList();
          localObject = this.jdField_a_of_type_JavaUtilHashtable.keys();
          if (!((Enumeration)localObject).hasMoreElements()) {
            break label460;
          }
          String str = (String)((Enumeration)localObject).nextElement();
          if (Math.abs(l1 - ((Long)this.jdField_a_of_type_JavaUtilHashtable.get(str)).longValue()) <= 180000L) {
            continue;
          }
          ???.add(str);
        }
        ??? = finally;
        throw ???;
      }
      if (paramInt1 == 4) {
        synchronized (this.jdField_b_of_type_JavaUtilArrayList)
        {
          this.jdField_b_of_type_JavaUtilArrayList.add(???);
          ??? = this.jdField_c_of_type_AndroidOsHandler.obtainMessage();
          ???.what = 991;
          this.jdField_c_of_type_AndroidOsHandler.sendMessageDelayed(???, 500L);
        }
      }
      if (paramInt1 == 101) {
        synchronized (this.jdField_d_of_type_JavaUtilArrayList)
        {
          this.jdField_d_of_type_JavaUtilArrayList.add(???);
          ??? = this.jdField_c_of_type_AndroidOsHandler.obtainMessage();
          ???.what = 993;
          this.jdField_c_of_type_AndroidOsHandler.sendMessageDelayed(???, 500L);
        }
      }
      if (paramInt1 == 113) {
        synchronized (this.jdField_c_of_type_JavaUtilArrayList)
        {
          this.jdField_c_of_type_JavaUtilArrayList.add(???);
          ??? = this.jdField_c_of_type_AndroidOsHandler.obtainMessage();
          ???.what = 992;
          this.jdField_c_of_type_AndroidOsHandler.sendMessageDelayed(???, 500L);
        }
      }
    }
    label460:
    paramInt1 = 0;
    while (paramInt1 < ???.size())
    {
      localObject = (String)???.get(paramInt1);
      this.jdField_a_of_type_JavaUtilHashtable.remove(localObject);
      paramInt1 += 1;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Aofy = new aofy(this, paramInt, paramBoolean1, paramBoolean2);
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_Aofy.a();
    if (localQQMessageFacade == null) {}
    QQMessageFacade.Message localMessage;
    boolean bool1;
    label139:
    label160:
    boolean bool2;
    label206:
    boolean bool3;
    label231:
    boolean bool4;
    label244:
    do
    {
      do
      {
        return;
        localMessage = localQQMessageFacade.a();
      } while (this.jdField_a_of_type_Aofy.a(localQQMessageFacade, localMessage));
      this.jdField_a_of_type_Aofy.a();
      bool1 = ((KeyguardManager)this.app.getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
      a("inKeyguardRestrictedInputMode", new Object[0]);
      if ((!antf.Q.equals(localMessage.frienduin)) || (!ozs.v())) {
        break;
      }
      paramInt = 1;
      if ((!this.isBackgroundPause) && (!this.isBackgroundStop) && (!bool1) && (paramInt == 0)) {
        break label576;
      }
      bool1 = true;
      anxm localanxm = anxm.a(this);
      if ((localanxm == null) || (!localanxm.a())) {
        break label582;
      }
      paramInt = 1;
      boolean bool5 = this.jdField_a_of_type_Aofy.f(localMessage);
      boolean bool6 = this.jdField_a_of_type_Aofy.i(localMessage);
      if ((!this.jdField_a_of_type_Aofy.g(localMessage)) || ((bool1) && (paramInt != 0))) {
        break label587;
      }
      bool2 = true;
      if ((!bool1) || ((this.jdField_a_of_type_Int != 0) && (!bool5)) || (!bool6)) {
        break label593;
      }
      bool3 = true;
      if ((!bool2) && (!bool3)) {
        break label599;
      }
      bool4 = true;
      QLog.d("QQAppInterface", 1, new Object[] { "[notification] [foreground] receivedMsgNotification: invoked. ", " mainProcessBackground: ", Boolean.valueOf(bool1), " needNotificationMessage: ", Boolean.valueOf(bool5), " foregroundMessagePushEnabled: ", Boolean.valueOf(bool2), " mainProcBackgroundPushEnabled: ", Boolean.valueOf(bool3), " subProcFgPushEnabled: ", Boolean.valueOf(bool6), " needNotification: ", Boolean.valueOf(bool4) });
      if (!bool4) {
        break label605;
      }
    } while (this.jdField_a_of_type_Aofy.c(localMessage));
    blhf.a(this, localMessage.istroop, localMessage.msgUid);
    a("reportEvent", new Object[] { this, Integer.valueOf(localMessage.istroop), Long.valueOf(localMessage.msgUid) });
    OpenApiManager.getInstance().onReceiveNewMsg(localMessage);
    a("onReceiveNewMsg", new Object[] { localMessage });
    localQQMessageFacade.a.b(localMessage);
    a(localMessage, paramBoolean1, paramBoolean2);
    a("showMsgNotification", new Object[] { localMessage, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    label576:
    label582:
    label587:
    label593:
    label599:
    label605:
    while (!a(paramBoolean1, paramBoolean2, localMessage))
    {
      ((aklf)a(147)).a(localMessage.frienduin, localMessage.istroop, localMessage.msgtype);
      a("notifyUnreadState", new Object[] { localMessage.frienduin, Integer.valueOf(localMessage.istroop), Integer.valueOf(localMessage.msgtype) });
      E();
      return;
      paramInt = 0;
      break;
      bool1 = false;
      break label139;
      paramInt = 0;
      break label160;
      bool2 = false;
      break label206;
      bool3 = false;
      break label231;
      bool4 = false;
      break label244;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "receivedMsgNotification , size is:" + paramInt + ",isOnline is:" + paramBoolean2);
    }
    if ((paramInt == 0) || (paramMessageRecord == null)) {}
    label52:
    boolean bool;
    do
    {
      do
      {
        do
        {
          break label52;
          do
          {
            return;
          } while ((d(paramMessageRecord)) || (c(paramMessageRecord)) || (b(paramMessageRecord)));
          if (!UserguideActivity.a(getApp(), getCurrentAccountUin())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("notification", 2, "receivedMsgNotification , showUserGuide");
        return;
        if (GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager != null) {
          GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b(0, null);
        }
        bool = ((KeyguardManager)this.app.getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
      } while (a(paramMessageRecord));
      if (QLog.isColorLevel())
      {
        QLog.d("notification", 2, "isBackground_Pause:" + this.isBackgroundPause);
        QLog.d("notification", 2, "isBackground_Stop:" + this.isBackgroundStop);
        QLog.d("notification", 2, "isScreenLocked:" + bool);
      }
    } while (((!this.isBackgroundPause) && (!this.isBackgroundStop) && (!bool)) || ((paramMessageRecord.istroop != 6000) && (this.jdField_a_of_type_Int != 0) && (((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002)) && ((paramMessageRecord.msgtype != -3001) && (paramMessageRecord.istroop != 1008)))));
    a(paramMessageRecord, paramBoolean1, paramBoolean2);
  }
  
  public void a(long paramLong)
  {
    if (paramLong >= 0L) {
      this.jdField_c_of_type_Long = paramLong;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
  }
  
  public void a(Context paramContext)
  {
    a(paramContext, null);
  }
  
  public void a(Context paramContext, Class<?> paramClass)
  {
    if (!b()) {}
    do
    {
      do
      {
        return;
      } while (paramContext == null);
      if (paramClass != null) {
        break label235;
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
    } while (!f());
    Object localObject1 = getCurrentAccountUin();
    Friends localFriends = ((anyw)getManager(51)).e((String)localObject1);
    Object localObject2;
    if (localFriends != null)
    {
      localObject2 = a(1, localFriends.uin, (byte)3, true, 0);
      paramContext = (Context)localObject2;
      if (localObject2 == null) {
        paramContext = bhmq.a();
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
      a(paramClass, null, "", paramContext, this.app.getString(2131717522), (Bitmap)localObject1, "CMD_IDLE_NOTIFIYCATION");
      return;
      paramClass = new Intent(this.app.getApplicationContext(), SplashActivity.class);
      break;
      label235:
      paramClass = new Intent(this.app.getApplicationContext(), paramClass);
      break;
      localObject2 = paramContext;
      paramContext = (Context)localObject1;
      localObject1 = localObject2;
      continue;
      paramContext = (Context)localObject1;
      localObject1 = null;
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_b_of_type_AndroidContentIntent = paramIntent;
  }
  
  public void a(anui paramanui)
  {
    synchronized (this.jdField_d_of_type_JavaUtilList)
    {
      if (!this.jdField_d_of_type_JavaUtilList.contains(paramanui)) {
        this.jdField_d_of_type_JavaUtilList.add(paramanui);
      }
      return;
    }
  }
  
  public void a(anuy paramanuy)
  {
    this.jdField_a_of_type_Anuy = paramanuy;
  }
  
  public void a(anuz paramanuz)
  {
    this.jdField_a_of_type_Anuz = paramanuz;
  }
  
  public void a(aocq paramaocq)
  {
    this.jdField_a_of_type_Aocq = paramaocq;
    if (QLog.isColorLevel()) {
      QLog.i("QQAppInterface", 2, "setMsgTabUnreadListener lis: " + paramaocq);
    }
  }
  
  public void a(aocr paramaocr)
  {
    this.jdField_a_of_type_Aocr = paramaocr;
  }
  
  public void a(aokn paramaokn)
  {
    if (paramaokn == null) {}
    while (this.jdField_a_of_type_JavaUtilList.indexOf(paramaokn) >= 0) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramaokn);
  }
  
  public void a(QQMessageFacade.Message paramMessage1, QQMessageFacade.Message paramMessage2)
  {
    int i1 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.a().size();
    int i2 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "showReadedMsgNotification, Messages size:" + i1 + ", counter:" + i2);
    }
    blhw localblhw = blhw.a(this);
    if ((paramMessage1 == null) || (i1 == 0) || (i2 == 0)) {
      k();
    }
    for (;;)
    {
      if (g()) {
        localblhw.a(paramMessage2);
      }
      return;
      if (g())
      {
        if ((paramMessage2 != null) && (blhw.a(paramMessage2)))
        {
          if ((localblhw != null) && (localblhw.d(paramMessage2))) {
            a(paramMessage2, false);
          }
        }
        else {
          a(paramMessage1, false);
        }
      }
      else {
        b(paramMessage1, false);
      }
    }
  }
  
  protected void a(QQMessageFacade paramQQMessageFacade)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onCreateQQMessageFacade() called with: msgFacade = [" + paramQQMessageFacade + "]");
    }
    new aofo(paramQQMessageFacade).a();
  }
  
  public void a(ResourcePluginListener paramResourcePluginListener)
  {
    n();
    this.jdField_a_of_type_Aoaw.a(paramResourcePluginListener);
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    String str1;
    String str2;
    Bitmap localBitmap;
    QQMessageFacade.Message localMessage;
    Intent localIntent;
    int i1;
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
        break label687;
      }
      localIntent = new Intent(getApp(), MsgBoxListActivity.class);
      localIntent.addFlags(335544320);
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "OneWayMessageNotifyVibert mr.frienduin" + paramMessageRecord.frienduin + ", mr.istroop" + paramMessageRecord.istroop);
      }
      if (1010 != paramMessageRecord.istroop) {
        break label561;
      }
      localIntent.putExtra("uin", antf.ab);
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
        localBitmap = bhjd.a(getApp().getResources().getDrawable(2130840363));
        localObject = BaseApplicationImpl.getApplication();
        if (paramMessageRecord.istroop != 1001) {
          break label625;
        }
        i1 = 2131693197;
        label311:
        str1 = ((BaseApplicationImpl)localObject).getString(i1);
        localObject = BaseApplicationImpl.getApplication();
        if (paramMessageRecord.istroop != 1001) {
          break label632;
        }
        i1 = 2131693196;
        label338:
        str2 = ((BaseApplicationImpl)localObject).getString(i1);
        localIntent.putExtra("key_notifycation_oneway_message", true);
        localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayLBSFriendMsgNotifyCfg.name());
        if (((String)localObject).length() <= 0) {
          break label707;
        }
        localObject = ((String)localObject).split("\\|");
        if (localObject.length < 6) {
          break label707;
        }
        str1 = localObject[4];
        str2 = localObject[5];
      }
    }
    label546:
    label561:
    label707:
    for (Object localObject = str2;; localObject = str2)
    {
      a(localIntent, paramMessageRecord, (String)localObject, str1, str2, localBitmap, "CMD_SHOW_NOTIFIYCATION");
      if (bhrl.a(getApp()))
      {
        paramMessageRecord = (axac)getManager(72);
        if (SettingCloneUtil.readValue(getApp(), getCurrentAccountUin(), getApp().getString(2131693438), "qqsetting_lock_screen_whenexit_key", true))
        {
          if (1001 != localMessage.istroop) {
            break label639;
          }
          paramMessageRecord.a(this, antf.ah, localMessage.istroop, false, awzy.a(localMessage.frienduin, localMessage.istroop, localIntent));
          bdll.b(this, "dc00899", "grp_lbs", "", "msg_box", "notice_msg", 0, 0, "", "", "", "");
        }
      }
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        b(localMessage, paramBoolean, true);
        return;
        if ((1001 != paramMessageRecord.istroop) && (10002 != paramMessageRecord.istroop)) {
          break;
        }
        localObject = antf.H;
        if (!asbc.b(paramMessageRecord)) {
          localObject = antf.I;
        }
        localIntent.putExtra("uin", (String)localObject);
        localIntent.putExtra("uintype", paramMessageRecord.istroop);
        break;
        label625:
        i1 = 2131718807;
        break label311;
        label632:
        i1 = 2131718806;
        break label338;
        label639:
        if (1010 != localMessage.istroop) {
          break label546;
        }
        paramMessageRecord.a(this, antf.ai, localMessage.istroop, false, awzy.a(localMessage.frienduin, localMessage.istroop, localIntent));
        break label546;
      }
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        b(localMessage, paramBoolean, true);
        return;
      }
    }
  }
  
  public void a(Setting paramSetting)
  {
    if (paramSetting != null)
    {
      paramSetting = paramSetting.clone();
      if (paramSetting != null)
      {
        paramSetting.url = null;
        if (!TextUtils.isEmpty(paramSetting.uin))
        {
          N();
          this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramSetting.uin, paramSetting);
        }
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    aotx localaotx;
    if (this.jdField_a_of_type_Bcpt != null)
    {
      this.jdField_a_of_type_Bcpt.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
      if (AppSetting.c()) {
        localaotx = a();
      }
    }
    try
    {
      localaotx.a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    catch (Throwable paramToServiceMsg)
    {
      QLog.e("QQAppInterface", 1, "receiveToService: ", paramToServiceMsg);
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    ThreadManager.executeOnNetWorkThread(paramRunnable);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(paramString);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
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
      a(32, paramString, paramInt);
      bhhg localbhhg = a().a(false);
      if (localbhhg != null) {
        localbhhg.a(32, paramString, paramInt);
      }
      paramString = new File(a(32, paramString, paramInt));
    } while ((paramString == null) || (!paramString.exists()));
    paramString.delete();
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L)) {}
    label13:
    long l1;
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
          localObject = a(32, paramString, paramInt);
        } while ((localObject == null) || (((Pair)localObject).second == null));
        l1 = ((Setting)((Pair)localObject).second).headImgTimestamp;
      } while (l1 == paramLong);
      Object localObject = (FriendListHandler)a(1);
      if (localObject != null) {
        ((FriendListHandler)localObject).a(paramString, paramInt, (byte)1, (byte)0);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqhead.qaif", 2, "refreshStrangerFaceWithTimeStamp id=" + paramString + ", idtype =" + paramInt + ", timestamp=" + paramLong + ",headImgTimestamp=" + l1);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
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
        a(32, paramString, paramInt);
        localObject = new File(a(32, paramString, paramInt));
        if ((localObject != null) && (((File)localObject).exists())) {
          ((File)localObject).delete();
        }
      }
      localObject = (FriendListHandler)a(1);
    } while (localObject == null);
    ((FriendListHandler)localObject).a(paramString, paramInt, (byte)1, (byte)0);
  }
  
  public void a(String paramString, Bitmap paramBitmap, byte paramByte)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, paramBitmap, paramByte);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
      }
    }
  }
  
  public void a(String paramString, Integer paramInteger)
  {
    bhru localbhru = (bhru)getManager(31);
    if (localbhru != null)
    {
      String str = bhru.a(paramString, 1);
      if (QLog.isColorLevel()) {
        QLog.d("RoamSetting", 2, "setTroopMsgFilterToServer, path=" + str + " value=" + paramInteger);
      }
      localbhru.a(str, paramInteger);
      axan.a().c(this, paramString);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    boolean bool1 = n();
    boolean bool2 = bhhv.a(this.app.getApplicationContext(), this);
    boolean bool3 = bhhv.b(this.app.getApplicationContext(), this);
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, new Object[] { "isRingerSilent is:" + bool1 + ",canDisturb is:" + bool2, " isMute:", Boolean.valueOf(bool3) });
    }
    if ((!bool1) && (bool2) && (!bool3))
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApp());
      Vibrator localVibrator = (Vibrator)getApp().getSystemService("vibrator");
      bool1 = d();
      bool2 = m();
      bool3 = l();
      boolean bool4 = s();
      boolean bool5 = i();
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "canVibrator is:" + bool3 + ",isVideoing is:" + bool1 + ",isCallIdle is:" + bool4 + ",notRecordingPtt is:" + bool5);
      }
      if ((bool3) && (bool4) && (!bool1) && (bool5)) {
        localVibrator.vibrate(jdField_b_of_type_ArrayOfLong, -1);
      }
      if ((paramBoolean) && (bool2) && (!bool1) && (!q()) && (!r()) && (s()) && (i()))
      {
        int i1 = localSharedPreferences.getInt("sound_type" + getCurrentAccountUin(), 2131230721);
        if (b(paramString)) {
          i1 = 2131230759;
        }
        bhkm.b(i1, false);
      }
    }
  }
  
  public void a(AppRuntime.Status paramStatus, long paramLong)
  {
    a(paramStatus, paramLong, false);
  }
  
  public void a(AppRuntime.Status paramStatus, long paramLong, boolean paramBoolean)
  {
    if (f())
    {
      long l1 = this.app.getSharedPreferences(getAccount(), 0).getInt("GetFrdListReq_seq", 0);
      ((azll)a(174)).a(this, paramStatus, paramLong, l1, paramBoolean);
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
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, 0L);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_Aocq != null) {
      this.jdField_a_of_type_Aocq.a(paramBoolean, paramInt);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("QQAppInterface", 2, String.format(Locale.getDefault(), "refreshMsgTabUnreadNum mMsgTabUnreadListener is null, [%b, %d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    int i1 = 0;
    if (paramBoolean)
    {
      int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
      int i2 = arrayOfInt.length;
      i1 = 0;
      if (i1 < i2)
      {
        int i3 = arrayOfInt[i1];
        if (i3 == 27)
        {
          QLog.d("QQInitHandler", 2, new Object[] { "pluginManageDelayTime=", Long.valueOf(paramLong) });
          if (paramLong > 0L) {
            ThreadManager.getSubThreadHandler().postDelayed(new QQAppInterface.3(this), paramLong);
          }
        }
        for (;;)
        {
          i1 += 1;
          break;
          if (paramLong == 0L)
          {
            getManager(27);
            continue;
            getManager(i3);
          }
        }
      }
    }
    else
    {
      while (i1 < 382)
      {
        if ((i1 != 24) && (i1 != 82)) {
          getManager(i1);
        }
        i1 += 1;
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((anum)a(2)).a(paramBoolean1);
      return;
    }
    a().edit().putBoolean(getApp().getString(2131694429) + getCurrentAccountUin(), paramBoolean1).commit();
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataSigInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataSigInfo = new SigInfo();
    }
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.sessionKey = new byte[paramArrayOfByte1.length];
      System.arraycopy(paramArrayOfByte1, 0, this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.sessionKey, 0, paramArrayOfByte1.length);
      this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.signature = new byte[paramArrayOfByte2.length];
      System.arraycopy(paramArrayOfByte2, 0, this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.signature, 0, paramArrayOfByte2.length);
      this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.wSignatureLen = ((short)this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.signature.length);
    }
  }
  
  public void a(Integer[] paramArrayOfInteger)
  {
    a(paramArrayOfInteger, true);
  }
  
  public void a(Integer[] paramArrayOfInteger, boolean paramBoolean)
  {
    Object localObject2 = SettingCloneUtil.readValue(getApplication(), getCurrentAccountUin(), null, "qqsetting_calltab_show_key", "0111100");
    if ((localObject2 == null) || (((String)localObject2).length() > "0111100".length()) || (paramArrayOfInteger == null) || (paramArrayOfInteger.length != 7)) {
      if (QLog.isColorLevel()) {
        QLog.e("QQAppInterface", 2, "writeCallTabStateVal valid val," + (String)localObject2 + "," + paramArrayOfInteger);
      }
    }
    Object localObject1;
    int i1;
    label157:
    do
    {
      return;
      localObject1 = localObject2;
      if (((String)localObject2).length() < "0111100".length()) {
        localObject1 = (String)localObject2 + "0111100".substring(((String)localObject2).length());
      }
      localObject1 = new StringBuilder((String)localObject1);
      i1 = 0;
      if (i1 < paramArrayOfInteger.length)
      {
        localObject2 = paramArrayOfInteger[i1];
        if (localObject2 == null) {}
        for (;;)
        {
          i1 += 1;
          break label157;
          if ((((Integer)localObject2).intValue() < 0) || (((Integer)localObject2).intValue() > 9))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("QQAppInterface", 2, "writeCallTabStateVal wrong index,," + localObject2);
            return;
          }
          ((StringBuilder)localObject1).setCharAt(i1, (char)(((Integer)localObject2).intValue() + 48));
        }
      }
      if (paramArrayOfInteger[0] != null)
      {
        this.jdField_g_of_type_Int = 0;
        this.n = false;
        if ((this.n) && ((a().jdField_a_of_type_Char == '2') || (a().jdField_a_of_type_Char == '3')))
        {
          localObject2 = new Integer[5];
          localObject2[0] = Integer.valueOf(1);
          localObject2[3] = Integer.valueOf(0);
          a().a((Integer[])localObject2, false);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQAppInterface", 2, "uin:" + getCurrentAccountUin() + ",writeCallTabStateVal vals=" + paramArrayOfInteger + ",mIsCallTabShow=" + this.jdField_g_of_type_Int + ",isCallTabShow=" + this.n);
      }
      SettingCloneUtil.writeValue(getApplication(), getCurrentAccountUin(), null, "qqsetting_calltab_show_key", ((StringBuilder)localObject1).toString());
      localObject1 = a().a();
      i1 = ((String)localObject1).charAt(2);
    } while ((!paramBoolean) || (((String)localObject1).charAt(0) != '0') || (paramArrayOfInteger[0] == null) || ((i1 != 50) && (i1 != 51)));
    paramArrayOfInteger = new Integer[5];
    paramArrayOfInteger[0] = Integer.valueOf(1);
    a().a(paramArrayOfInteger, false);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Beyb != null;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt] != null;
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2)
  {
    boolean bool2 = false;
    if (paramInt1 == 101) {}
    String str = a(paramInt1, paramString, (byte)3, paramInt2, 100, false);
    if ((this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) && (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(str) != null)) {
      return true;
    }
    paramString = new File(a(paramInt1, paramString, paramInt2));
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
  
  public boolean a(QQMessageFacade.Message paramMessage)
  {
    return a(paramMessage.frienduin, paramMessage.istroop);
  }
  
  public boolean a(Friends paramFriends)
  {
    boolean bool = true;
    String str = getApp().getString(2131718262) + getCurrentAccountUin();
    if (a().contains(str)) {
      bool = a().getBoolean(str, true);
    }
    while (!bhlg.a(paramFriends)) {
      return bool;
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    paramString = a().n(paramString);
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
  
  public boolean a(String paramString, int paramInt)
  {
    if (paramInt == 1)
    {
      paramInt = b(paramString);
      if ((paramInt == 3) || (paramInt == 2) || (paramInt == 4)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    bhru localbhru = (bhru)getManager(31);
    if (localbhru != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "getAllGeneralSettings , needTroopSettings=" + paramBoolean);
      }
      localbhru.a(paramBoolean, null);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "getAllGeneralSettings roamSettingController is null ");
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() isFromPush=" + paramBoolean + " fetchMsgType=" + paramInt);
    }
    Object localObject = (bdxc)getManager(61);
    if (localObject != null) {}
    for (localObject = ((bdxc)localObject).a();; localObject = null)
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
              bdwt.a(this, str, paramBoolean);
            }
            if (paramInt != 1)
            {
              arjg localarjg = (arjg)aran.a().a(607);
              if ((localarjg != null) && (!localarjg.jdField_a_of_type_Boolean)) {
                bdxb.a(this, str);
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
      localObject = (bdwt)getManager(62);
      if (localObject != null)
      {
        if (!bool2) {
          break label315;
        }
        if (BaseActivity.mAppForground) {
          ((bdwt)localObject).b(this, paramInt);
        }
      }
      return bool2;
      label315:
      ((bdwt)localObject).c(this, 0);
      return bool2;
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1;
    if (paramBoolean1)
    {
      i1 = this.jdField_c_of_type_Int;
      this.jdField_c_of_type_Int = (i1 + 1);
      if (i1 < 3) {}
    }
    do
    {
      return false;
      i1 = this.jdField_d_of_type_Int;
      this.jdField_d_of_type_Int = (i1 + 1);
    } while (i1 >= 3);
    ((anum)a(2)).a(paramBoolean1, paramBoolean2);
    return true;
  }
  
  public byte[] a()
  {
    if ((getAccount() != null) && (isLogin()) && (this.jdField_a_of_type_ComTencentMobileqqDataSigInfo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.sessionKey;
    }
    return null;
  }
  
  public Object[] a(String paramString, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, new Object[] { "unitTestLog: invoked. ", " methodName: ", paramString, paramVarArgs });
    }
    return paramVarArgs;
  }
  
  public String[] a(int paramInt)
  {
    return (String[])a(paramInt).get(Integer.valueOf(paramInt));
  }
  
  public void addManager(int paramInt, Manager paramManager)
  {
    if (this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt] != null) {
      return;
    }
    this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt] = paramManager;
  }
  
  public void addObserver(anui paramanui)
  {
    addObserver(paramanui, false);
  }
  
  public void addObserver(anui paramanui, boolean paramBoolean)
  {
    if (paramanui == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.jdField_c_of_type_JavaUtilList)
      {
        if (!this.jdField_c_of_type_JavaUtilList.contains(paramanui)) {
          this.jdField_c_of_type_JavaUtilList.add(paramanui);
        }
        return;
      }
    }
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      if (!this.jdField_b_of_type_JavaUtilList.contains(paramanui)) {
        this.jdField_b_of_type_JavaUtilList.add(paramanui);
      }
      return;
    }
  }
  
  public int b()
  {
    bhru localbhru = (bhru)getManager(31);
    if (localbhru != null) {
      return localbhru.b("message.group.vibrate", 0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SoundSetting", 2, "rsController is null!");
    }
    return 0;
  }
  
  public int b(String paramString)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramString);
    localObject = a((List)localObject);
    if (localObject != null)
    {
      paramString = (Integer)((Map)localObject).get(paramString);
      if (paramString != null) {
        return paramString.intValue();
      }
    }
    return 1;
  }
  
  public Bitmap b(Bitmap paramBitmap)
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(this.app.getResources(), 2130850442);
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
  
  @Deprecated
  public Drawable b(String paramString)
  {
    return a(paramString, false, (byte)3);
  }
  
  public SQLiteDatabase b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.getReadableDatabase();
    }
    return null;
  }
  
  public Setting b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache == null) {
      return null;
    }
    return (Setting)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
  }
  
  public String b()
  {
    String str = a();
    if (str != null) {
      try
      {
        str = bhml.a(str.getBytes("utf-8"));
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    return null;
  }
  
  public String b(String paramString)
  {
    String str = getApplication().getProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramString);
    if ((str == null) || (str.length() == 0)) {
      return paramString;
    }
    return str;
  }
  
  public void b()
  {
    int i3 = 0;
    int i6 = 0;
    N();
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.evictAll();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(Setting.class, new Setting().getTableName(), false, null, null, null, null, "updateTimestamp desc", null);
    Object localObject1;
    int i2;
    int i1;
    int i5;
    if (localObject2 != null)
    {
      i3 = ((List)localObject2).size();
      if (i3 > 0)
      {
        localObject1 = new ArrayList();
        int i4 = 0;
        i2 = 0;
        i1 = 0;
        if (i4 < i3)
        {
          Setting localSetting = (Setting)((List)localObject2).get(i4);
          if ((localSetting != null) && (!TextUtils.isEmpty(localSetting.uin)))
          {
            if (i1 >= 4000)
            {
              i5 = i2;
              i2 = i1;
              i1 = i5;
            }
            for (;;)
            {
              i5 = i4 + 1;
              i4 = i2;
              i2 = i1;
              i1 = i4;
              i4 = i5;
              break;
              localSetting.url = null;
              if (((localSetting.bSourceType == 1) || (localSetting.bUsrType == 32)) && (i2 <= 100))
              {
                ((List)localObject1).add(localSetting);
                i5 = i2 + 1;
                i2 = i1;
                i1 = i5;
              }
              else
              {
                this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(localSetting.uin, localSetting);
                i5 = i1 + 1;
                i1 = i2;
                i2 = i5;
              }
            }
          }
        }
        else
        {
          i5 = Math.min(100, Math.min(4000 - i1, ((List)localObject1).size()));
          if (i5 > 0)
          {
            i4 = i6;
            if (i4 < i5)
            {
              localObject2 = (Setting)((List)localObject1).get(i4);
              if ((localObject2 == null) || (TextUtils.isEmpty(((Setting)localObject2).uin))) {}
              for (;;)
              {
                i4 += 1;
                break;
                this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(((Setting)localObject2).uin, localObject2);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      QLog.d("QQAppInterface", 1, "initFaceSettingCache," + i3 + "," + i1 + "," + i2);
      this.r = true;
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("com.tencent.qqhead.getheadreq");
      ((IntentFilter)localObject1).addAction("com.tencent.qqhead.refreshheadreq");
      getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject1);
      return;
      i5 = i1;
      i1 = i2;
      i2 = i5;
      break;
      i2 = 0;
      i1 = 0;
      continue;
      i2 = 0;
      i1 = 0;
    }
  }
  
  public void b(int paramInt)
  {
    a(new QQAppInterface.13(this, paramInt));
  }
  
  public void b(int paramInt1, String paramString1, int paramInt2, String paramString2)
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
  
  public void b(aokn paramaokn)
  {
    if (paramaokn == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramaokn);
  }
  
  public void b(ResourcePluginListener paramResourcePluginListener)
  {
    T();
    this.jdField_a_of_type_Aqzq.a(paramResourcePluginListener);
  }
  
  public void b(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    boolean bool = bhhv.a(this.app.getApplicationContext(), this);
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "showInComingMsg ,isFinished=" + this.jdField_j_of_type_Boolean + ", isCanDisturb=" + bool + ", needTicker=" + paramBoolean + ", message=" + paramMessageRecord);
    }
    if ((this.jdField_j_of_type_Boolean) || (!bool)) {}
    baou localbaou;
    do
    {
      return;
      localbaou = (baou)getManager(38);
    } while (localbaou == null);
    bool = false;
    Object localObject3 = paramMessageRecord.senderuin;
    Object localObject1;
    if ((paramMessageRecord.msgtype == -2016) || (paramMessageRecord.msgtype == -4008))
    {
      localObject1 = localbaou.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if (localObject1 != null) {
        localObject3 = ((QCallRecent)localObject1).senderUin;
      }
    }
    label662:
    label1568:
    for (;;)
    {
      int i1 = localbaou.b();
      if (i1 == 0) {
        break;
      }
      Object localObject4;
      if (i1 == 1) {
        if (((paramMessageRecord.msgtype == -2016) || (paramMessageRecord.msgtype == -4008)) && (paramMessageRecord.istroop == 3000))
        {
          bool = true;
          localObject4 = a(getApp(), paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord);
          localObject1 = (anwo)a(6);
          if (localObject1 == null) {
            break label1847;
          }
        }
      }
      label553:
      label1834:
      label1847:
      for (localObject1 = ((anwo)localObject1).a(paramMessageRecord.frienduin, true);; localObject1 = null)
      {
        Object localObject2 = bhlg.a(this, (String)localObject3, 0);
        Object localObject5;
        Object localObject6;
        Object localObject7;
        label447:
        label479:
        label486:
        int i2;
        for (;;)
        {
          ((Intent)localObject4).putExtra("key_notification_click_action", true);
          localObject5 = ((Intent)localObject4).getStringExtra("uinname");
          if (localObject5 != null)
          {
            localObject6 = localObject5;
            if (!"".equals(localObject5)) {}
          }
          else
          {
            localObject6 = ((Intent)localObject4).getStringExtra("uin");
          }
          if (localObject2 != null)
          {
            localObject5 = localObject2;
            if (!"".equals(localObject2)) {}
          }
          else
          {
            localObject5 = localObject3;
          }
          localObject5 = localbaou.a((String)localObject5, bool);
          switch (paramMessageRecord.istroop)
          {
          default: 
            localObject7 = (String)localObject6 + ": ";
            localObject3 = localObject1;
            localObject2 = localObject5;
            localObject1 = localObject7;
            localObject7 = localObject6;
            if (paramMessageRecord.istroop != 1008) {
              break label1529;
            }
            localObject6 = (String)localObject1 + (String)localObject2;
            if (paramBoolean) {
              break label1812;
            }
            localObject5 = null;
            i2 = localbaou.a();
            if ((i2 <= 1) || (i1 != 1)) {
              break label1805;
            }
            if (i2 <= 100) {
              break label1568;
            }
            localObject1 = (String)localObject7 + " (" + getApp().getString(2131694042) + ")";
            if ((paramMessageRecord.msgtype != -2016) && (paramMessageRecord.msgtype != -4008)) {
              break label1618;
            }
            if (QLog.isColorLevel()) {
              QLog.e("QQAppInterface", 2, "AVNotify:MSG_TYPE_MULTI_VIDEO");
            }
            if (paramMessageRecord.istroop == 3000)
            {
              if (QLog.isColorLevel()) {
                QLog.e("QQAppInterface", 2, "AVNotify:UIN_TYPE_DISCUSSION");
              }
              ((Intent)localObject4).putExtra("qav_notify_flag", true);
            }
            label625:
            if ((paramBoolean) && (paramMessageRecord.istroop != 6000) && (paramMessageRecord.istroop != 1009) && (!paramMessageRecord.frienduin.equals(antf.D))) {
              break label1657;
            }
            a((Intent)localObject4, paramMessageRecord, (String)localObject5, (String)localObject1, (String)localObject2, (Bitmap)localObject3, "CMD_SHOW_NOTIFIYCATION");
            return;
            if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1020) || (paramMessageRecord.istroop == 1004))
            {
              localObject1 = new Intent(getApp(), SplashActivity.class);
              ((Intent)localObject1).putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
              ((Intent)localObject1).putExtra("conversation_index", 1);
              ((Intent)localObject1).setFlags(335544320);
              ((Intent)localObject1).putExtra("uinname", a(paramMessageRecord.frienduin, (String)localObject3, paramMessageRecord.istroop, true));
            }
            for (;;)
            {
              if (!antf.M.equals(paramMessageRecord.frienduin)) {
                break label841;
              }
              localObject2 = a((String)localObject3, true);
              localObject4 = localObject1;
              localObject1 = localObject2;
              localObject2 = "";
              break;
              localObject1 = a(getApp(), paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord);
            }
            label841:
            if ((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002) || (paramMessageRecord.istroop == 1010))
            {
              localObject2 = a(paramMessageRecord.frienduin, 200);
              localObject4 = localObject1;
              localObject1 = localObject2;
              localObject2 = "";
            }
            else
            {
              localObject2 = a(paramMessageRecord.frienduin, true);
              localObject4 = localObject1;
              localObject1 = localObject2;
              localObject2 = "";
            }
            break;
          }
        }
        if (((paramMessageRecord.msgtype == -2016) || (paramMessageRecord.msgtype == -4008)) && (paramMessageRecord.istroop == 3000)) {}
        for (bool = true;; bool = false)
        {
          localObject4 = new Intent(getApp(), SplashActivity.class);
          ((Intent)localObject4).putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
          ((Intent)localObject4).putExtra("conversation_index", 1);
          ((Intent)localObject4).setFlags(335544320);
          ((Intent)localObject4).putExtra("uinname", getApp().getString(2131694050));
          localObject1 = null;
          localObject2 = "";
          break;
          localObject2 = bhlg.a(this, (String)localObject3, 0);
          localObject7 = (String)localObject2 + "(" + (String)localObject6 + "):";
          localObject3 = localObject1;
          localObject2 = localObject5;
          localObject1 = localObject7;
          localObject7 = localObject6;
          break label447;
          localObject2 = ((Intent)localObject4).getStringExtra("subAccountLatestNick");
          localObject1 = localObject3;
          if (localObject2 != null) {
            if (((String)localObject2).length() != 0) {
              break label1834;
            }
          }
          for (localObject1 = localObject3;; localObject1 = localObject2)
          {
            localObject3 = (String)localObject6 + "-" + (String)localObject1 + ":" + (String)localObject5;
            localObject2 = (String)localObject1 + ":" + (String)localObject5;
            localObject1 = localObject3;
            localObject3 = null;
            localObject7 = localObject6;
            break;
            localObject7 = (String)localObject6 + ": ";
            localObject3 = localObject1;
            localObject2 = localObject5;
            localObject1 = localObject7;
            localObject7 = localObject6;
            break;
            if (i1 > 1)
            {
              localObject7 = (String)localObject6 + ": ";
              localObject3 = localObject1;
              localObject2 = localObject5;
              localObject1 = localObject7;
              localObject7 = localObject6;
              break;
            }
            localObject3 = bhlg.q(this, paramMessageRecord.frienduin);
            localObject2 = (String)localObject3 + "(" + (String)localObject6 + "):";
            String str = (String)localObject3 + ": " + (String)localObject5;
            localObject3 = localObject1;
            localObject1 = localObject2;
            localObject7 = localObject6;
            localObject2 = str;
            break;
            localObject3 = bhjd.a(getApp().getResources().getDrawable(2130840365));
            localObject2 = agkq.a(paramMessageRecord);
            if ((localObject2 != null) && (!((PAMessage)localObject2).items.isEmpty()))
            {
              localObject1 = ((PAMessage.Item)((PAMessage)localObject2).items.get(0)).title;
              if ((((PAMessage.Item)((PAMessage)localObject2).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject2).items.get(0)).digestList != null)) {
                localObject2 = (String)((PAMessage.Item)((PAMessage)localObject2).items.get(0)).digestList.get(0);
              }
              for (;;)
              {
                localObject7 = localObject1;
                localObject1 = "";
                break;
                localObject2 = localObject1;
                localObject1 = localObject6;
              }
              label1529:
              localObject6 = localObject1;
              if (paramMessageRecord.istroop == 7000) {
                break label479;
              }
              localObject6 = (String)localObject1 + (String)localObject5;
              break label479;
              localObject1 = (String)localObject7 + " (" + i2 + getApp().getString(2131693989) + ")";
              break label553;
              label1618:
              if (paramMessageRecord.msgtype != -2009) {
                break label625;
              }
              if (QLog.isColorLevel()) {
                QLog.e("QQAppInterface", 2, "AVNotify:MSG_TYPE_MEDIA_VIDEO");
              }
              ((Intent)localObject4).putExtra("qav_notify_flag", true);
              break label625;
              label1657:
              if (!bhrl.a(getApp())) {
                break label662;
              }
              localObject6 = (axac)getManager(72);
              paramBoolean = SettingCloneUtil.readValue(getApp(), getCurrentAccountUin(), getApp().getString(2131693438), "qqsetting_lock_screen_whenexit_key", true);
              if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, String.format("videochatting start lsActivity from appinterface  showInComingMsgForQAV, lockScreenMsgWhenExit[%s]", new Object[] { Boolean.valueOf(paramBoolean) }));
              }
              if (!paramBoolean) {
                break label662;
              }
              if (bool)
              {
                ((axac)localObject6).a(this, paramMessageRecord.frienduin, paramMessageRecord.istroop, true, awzy.a(paramMessageRecord.frienduin, paramMessageRecord.istroop, (Intent)localObject4));
                break label662;
              }
              ((axac)localObject6).a(this, paramMessageRecord.frienduin, paramMessageRecord.istroop, false, awzy.a(paramMessageRecord.frienduin, paramMessageRecord.istroop, (Intent)localObject4));
              break label662;
              localObject1 = localObject7;
              break label553;
              localObject5 = localObject6;
              break label486;
            }
            localObject2 = localObject5;
            localObject1 = "";
            localObject7 = localObject6;
            break;
          }
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onWeakNet message: " + paramString);
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Aocr != null) {
      this.jdField_a_of_type_Aocr.a(paramString, paramInt);
    }
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L)) {}
    label13:
    long l1;
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
          localObject = a(16, paramString, paramInt);
        } while ((localObject == null) || (((Pair)localObject).second == null));
        l1 = ((Setting)((Pair)localObject).second).headImgTimestamp;
      } while (l1 == paramLong);
      Object localObject = (FriendListHandler)a(1);
      if (localObject != null) {
        ((FriendListHandler)localObject).a(paramString, paramInt, (byte)1, (byte)0);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqhead.qaif", 2, "refreshQCallFaceWithTimeStamp id=" + paramString + ", idtype =" + paramInt + ", timestamp=" + paramLong + ",headImgTimestamp=" + l1);
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.d("exit", 2, getCurrentAccountUin() + " qq start to exit ");
    }
    this.jdField_g_of_type_Boolean = true;
    S();
    bdml.a().d(getCurrentAccountUin());
    avsj.a();
    R();
    MobileQQ localMobileQQ;
    if (isLogin())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "bReceiveMsgOnExit = " + this.jdField_a_of_type_Boolean + ", needPCActive = " + paramBoolean);
      }
      if (this.jdField_a_of_type_Boolean)
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
        break label276;
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
      j();
      HeavyTaskExecutor.a();
      GuardManager.b(true);
      return;
      if (paramBoolean)
      {
        sendOnlineStatus(AppRuntime.Status.offline, false, 0L, false);
        break;
      }
      sendOnlineStatus(AppRuntime.Status.offline, true, 0L, false);
      break;
      label276:
      localMobileQQ = getApplication();
      paramBoolean = bool2;
      if (!this.jdField_a_of_type_Boolean) {
        paramBoolean = true;
      }
      localMobileQQ.qqProcessExit(paramBoolean);
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      a().edit().putBoolean(getApp().getString(2131694431) + getCurrentAccountUin(), paramBoolean1).commit();
      return;
    }
    ((aoat)a(3)).a(paramBoolean1);
  }
  
  public boolean b()
  {
    boolean bool = false;
    try
    {
      String str = getApp().getString(2131717971);
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
  
  public final boolean b(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((anum)a(2)).b();
    }
    return a().getBoolean(getApp().getString(2131694429) + getCurrentAccountUin(), true);
  }
  
  public int c()
  {
    bhru localbhru = (bhru)getManager(31);
    if (localbhru != null) {
      return localbhru.b("message.ring.switch", 1);
    }
    return 1;
  }
  
  /* Error */
  public Setting c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1359	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   4: invokevirtual 4381	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   7: astore_3
    //   8: aload_3
    //   9: astore_2
    //   10: aload_3
    //   11: ldc_w 2326
    //   14: aload_1
    //   15: invokevirtual 3154	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   18: checkcast 2326	com/tencent/mobileqq/data/Setting
    //   21: astore_1
    //   22: aload_3
    //   23: ifnull +7 -> 30
    //   26: aload_3
    //   27: invokevirtual 4382	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   30: aload_1
    //   31: areturn
    //   32: astore_1
    //   33: aconst_null
    //   34: astore_3
    //   35: aload_3
    //   36: astore_2
    //   37: aload_1
    //   38: invokevirtual 1194	java/lang/Exception:printStackTrace	()V
    //   41: aload_3
    //   42: ifnull +30 -> 72
    //   45: aload_3
    //   46: invokevirtual 4382	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   49: aconst_null
    //   50: areturn
    //   51: astore_1
    //   52: aconst_null
    //   53: astore_2
    //   54: aload_2
    //   55: ifnull +7 -> 62
    //   58: aload_2
    //   59: invokevirtual 4382	com/tencent/mobileqq/persistence/EntityManager:close	()V
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
  
  public String c()
  {
    String str = "";
    if (!"0".equals(getCurrentAccountUin())) {
      str = getCurrentAccountUin();
    }
    return str;
  }
  
  public void c() {}
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoundSetting", 2, "setTroopGeneralSettingRing :" + paramInt);
    }
    bhru localbhru = (bhru)getManager(31);
    if (localbhru != null) {
      localbhru.a("message.group.ring", Integer.valueOf(paramInt));
    }
  }
  
  public void c(ResourcePluginListener paramResourcePluginListener)
  {
    if (this.jdField_a_of_type_Aoaw != null) {
      this.jdField_a_of_type_Aoaw.b(paramResourcePluginListener);
    }
  }
  
  public void c(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT > 28) {
      bool = false;
    }
    b(paramMessageRecord, paramBoolean, bool);
  }
  
  public void c(String paramString)
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
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((FriendListHandler)a(1)).b(paramBoolean1);
      return;
    }
    a().edit().putBoolean(getApp().getString(2131718262) + getCurrentAccountUin(), paramBoolean1).commit();
  }
  
  public boolean c()
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
  
  public final boolean c(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((FriendListHandler)a(1)).g();
    }
    return a().getBoolean(getApp().getString(2131718262) + getCurrentAccountUin(), true);
  }
  
  public int d()
  {
    bhru localbhru = (bhru)getManager(31);
    if (localbhru != null) {
      return localbhru.b("message.vibrate.switch", 1);
    }
    return 1;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onMessageConnect...");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator == null) || (!f())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null)
    {
      if (this.jdField_a_of_type_Bcrg != null) {
        this.jdField_a_of_type_Bcrg.f();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b();
    }
    e();
    a().a();
    a().a();
    a().b();
    for (;;)
    {
      Object localObject4;
      HashMap localHashMap;
      try
      {
        Object localObject2 = e();
        Object localObject3 = BaseApplication.getContext().getSharedPreferences("pull_msf" + (String)localObject2, 0);
        String str = ((SharedPreferences)localObject3).getString("uin", " ");
        localObject4 = ((SharedPreferences)localObject3).getString("time", "0");
        boolean bool1 = ((SharedPreferences)localObject3).getBoolean("proxy", false);
        boolean bool2 = ((SharedPreferences)localObject3).getBoolean("vivo", false);
        int i1 = ((SharedPreferences)localObject3).getInt("param_FailCode", 0);
        boolean bool3 = ((SharedPreferences)localObject3).getBoolean("mainProcess", false);
        Object localObject1 = ((SharedPreferences)localObject3).getString("sdkver", " ");
        if ((!str.equals(" ")) && (!((String)localObject4).equals("0")))
        {
          if ((BaseApplicationImpl.sLaunchTime < 0L) && (BaseApplicationImpl.sShowTime < 0L)) {
            RegisterProxy.jdField_d_of_type_Int |= 0x4;
          }
          localHashMap = new HashMap();
          localHashMap.put("uin", str);
          localHashMap.put("time", localObject4);
          localHashMap.put("process", ((SharedPreferences)localObject3).getString("process", ""));
          localHashMap.put("availMem", ((SharedPreferences)localObject3).getString("availMem", ""));
          localHashMap.put("lowMem", ((SharedPreferences)localObject3).getString("lowMem", ""));
          localHashMap.put("state", ((SharedPreferences)localObject3).getString("state", ""));
          localHashMap.put("version", "150806");
          localHashMap.put("build", "4745");
          localHashMap.put("proxy", String.valueOf(bool1));
          localHashMap.put("vivo", String.valueOf(bool2));
          localHashMap.put("param_FailCode", String.valueOf(i1));
          localHashMap.put("mainProcess", String.valueOf(bool3));
          localHashMap.put("sdkver", String.valueOf(localObject1));
          if (Build.VERSION.SDK_INT >= 21)
          {
            bdmc.a(BaseApplicationImpl.getContext()).a(getCurrentAccountUin(), "pullMsfReport_V3", false, 0L, 0L, localHashMap, "");
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
          if ((a(this)) && (BaseApplicationImpl.sLaunchTime < 0L) && (BaseApplicationImpl.sShowTime < 0L)) {
            RegisterProxy.jdField_d_of_type_Int |= 0x2;
          }
          localObject4 = new HashMap();
          ((HashMap)localObject4).put("uin", localObject3);
          ((HashMap)localObject4).put("time", str);
          ((HashMap)localObject4).put("process", ((SharedPreferences)localObject2).getString("process", ""));
          ((HashMap)localObject4).put("availMem", ((SharedPreferences)localObject2).getString("availMem", ""));
          ((HashMap)localObject4).put("lowMem", ((SharedPreferences)localObject2).getString("lowMem", ""));
          ((HashMap)localObject4).put("state", ((SharedPreferences)localObject2).getString("state", ""));
          ((HashMap)localObject4).put("version", "150806");
          ((HashMap)localObject4).put("build", "4745");
          ((HashMap)localObject4).put("proxy", String.valueOf(bool1));
          ((HashMap)localObject4).put("vivo", String.valueOf(bool2));
          ((HashMap)localObject4).put("param_FailCode", String.valueOf(i1));
          ((HashMap)localObject4).put("mainProcess", String.valueOf(bool3));
          ((HashMap)localObject4).put("sdkver", String.valueOf(localObject1));
          if (Build.VERSION.SDK_INT < 21) {
            break label937;
          }
          bdmc.a(BaseApplicationImpl.getContext()).a(getCurrentAccountUin(), "pullMsfReport_succ_V2", false, 0L, 0L, (HashMap)localObject4, "");
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
      bdmc.a(BaseApplicationImpl.getContext()).a(getCurrentAccountUin(), "pullMsfReportOther_V3", false, 0L, 0L, localHashMap, "");
      continue;
      label937:
      bdmc.a(BaseApplicationImpl.getContext()).a(getCurrentAccountUin(), "pullMsfReport_succOther_V2", false, 0L, 0L, (HashMap)localObject4, "");
    }
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoundSetting", 2, "setTroopGeneralSettingVibrate :" + paramInt);
    }
    bhru localbhru = (bhru)getManager(31);
    if (localbhru != null) {
      localbhru.a("message.group.vibrate", Integer.valueOf(paramInt));
    }
  }
  
  public void d(ResourcePluginListener paramResourcePluginListener)
  {
    if (this.jdField_a_of_type_Aqzq != null) {
      this.jdField_a_of_type_Aqzq.b(paramResourcePluginListener);
    }
  }
  
  public void d(String paramString)
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)a(1);
    if (localFriendListHandler != null) {
      localFriendListHandler.d(paramString);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putBoolean(BaseApplication.getContext().getString(2131694439) + getCurrentAccountUin(), paramBoolean);
    localEditor.commit();
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "setLoudSpeakerState:" + paramBoolean);
    }
  }
  
  public void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((avyk)a(150)).a(paramBoolean1);
      return;
    }
    a().edit().putBoolean(getApp().getString(2131718261) + getCurrentAccountUin(), paramBoolean1).apply();
  }
  
  public boolean d()
  {
    if (AVNotifyCenter.d())
    {
      lbj.c("QQAppInterface", "VideoProcessAlive isBeInvitingOnDoubleVideo");
      return true;
    }
    if ((!a().b()) && (a().b() == 0)) {
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
            lbj.c("QQAppInterface", "VideoProcessAlive VIDEO_PROCESS_NAME");
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
  
  public final boolean d(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((avyk)a(150)).a();
    }
    return a().getBoolean(getApp().getString(2131718261) + getCurrentAccountUin(), false);
  }
  
  public int e()
  {
    bhru localbhru = (bhru)getManager(31);
    if (localbhru != null) {
      return localbhru.b("sync.c2c_message", 1);
    }
    return 1;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onConnOpenAndStartGetMsg");
    }
    awzv.a().a(1);
    MqqHandler localMqqHandler = getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(1134014, null).sendToTarget();
    }
  }
  
  public void e(int paramInt)
  {
    bhru localbhru = (bhru)getManager(31);
    if (localbhru != null) {
      localbhru.a("message.ring.switch", Integer.valueOf(paramInt));
    }
  }
  
  public void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    FriendListHandler localFriendListHandler;
    do
    {
      return;
      localFriendListHandler = (FriendListHandler)a(1);
    } while (localFriendListHandler == null);
    if (paramString.startsWith("+"))
    {
      localFriendListHandler.e(paramString);
      return;
    }
    localFriendListHandler.c(paramString);
  }
  
  public void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.jdField_c_of_type_Int = 1;
    }
    for (;;)
    {
      ((anum)a(2)).a(paramBoolean1, paramBoolean2);
      return;
      this.jdField_d_of_type_Int = 1;
    }
  }
  
  public boolean e()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (d()))
    {
      Object localObject = ((QQServiceForAV)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(1, 0, null);
      if (localObject != null)
      {
        localObject = ((Bundle)localObject).getString("camera_used_desc", null);
        QLog.w("QQAppInterface", 1, "isUsingCameraOnVideo, result[" + (String)localObject + "]");
        return localObject != null;
      }
    }
    return false;
  }
  
  public boolean e(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((FriendListHandler)a(1)).a(getCurrentAccountUin(), 1);
    }
    return a().getBoolean(getApp().getString(2131694022) + getCurrentAccountUin(), false);
  }
  
  public int f()
  {
    int i1 = 0;
    int i2 = 0;
    QQMessageFacade localQQMessageFacade = a();
    if (localQQMessageFacade != null)
    {
      baou localbaou = a();
      i1 = i2;
      if (localbaou != null)
      {
        i1 = i2;
        if (!a().j())
        {
          i2 = localbaou.a();
          i1 = i2;
          if (QLog.isColorLevel())
          {
            QLog.d("QQAppInterface", 2, "callUnread: " + i2);
            i1 = i2;
          }
        }
      }
      i2 = localQQMessageFacade.b();
      i1 = ((ajka)getManager(34)).d() + (i2 + i1);
    }
    return i1;
  }
  
  public void f() {}
  
  public void f(int paramInt)
  {
    bhru localbhru = (bhru)getManager(31);
    if (localbhru != null) {
      localbhru.a("message.vibrate.switch", Integer.valueOf(paramInt));
    }
  }
  
  public void f(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((FriendListHandler)a(1)).a(paramBoolean1, getCurrentAccountUin(), 1);
      return;
    }
    a().edit().putBoolean(getApp().getString(2131694022) + getCurrentAccountUin(), paramBoolean1).commit();
  }
  
  public boolean f()
  {
    return (getAccount() != null) && (isLogin());
  }
  
  public boolean f(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((FriendListHandler)a(1)).a(getCurrentAccountUin(), 2);
    }
    return a().getBoolean(getApp().getString(2131718179) + getCurrentAccountUin(), false);
  }
  
  protected void finalize()
  {
    super.finalize();
    QQEntityManagerFactory localQQEntityManagerFactory = this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory;
    if (localQQEntityManagerFactory != null) {
      localQQEntityManagerFactory.close();
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onConnClose");
    }
    this.jdField_e_of_type_Boolean = false;
    awzv.a().a(1);
    MqqHandler localMqqHandler = getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(1134014, null).sendToTarget();
    }
  }
  
  public void g(int paramInt)
  {
    bhru localbhru = (bhru)getManager(31);
    if (localbhru != null) {
      localbhru.a("sync.c2c_message", Integer.valueOf(paramInt));
    }
  }
  
  public void g(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((FriendListHandler)a(1)).a(paramBoolean1, getCurrentAccountUin(), 2);
      return;
    }
    a().edit().putBoolean(getApp().getString(2131718179) + getCurrentAccountUin(), paramBoolean1).commit();
  }
  
  public boolean g()
  {
    return SettingCloneUtil.readValue(getApp(), getCurrentAccountUin(), getApp().getString(2131717560), "qqsetting_notify_showcontent_key", true);
  }
  
  public boolean g(boolean paramBoolean)
  {
    return a(paramBoolean, 0);
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a();
  }
  
  public List<anui> getBusinessObserver(int paramInt)
  {
    if (paramInt == 1) {
      return this.jdField_b_of_type_JavaUtilList;
    }
    if (paramInt == 2) {
      return this.jdField_c_of_type_JavaUtilList;
    }
    if (paramInt == 0) {
      return this.jdField_d_of_type_JavaUtilList;
    }
    return this.jdField_d_of_type_JavaUtilList;
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public String getCurrentNickname()
  {
    return bhlg.j(this, getCurrentAccountUin());
  }
  
  @Deprecated
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (!paramString.equals(getAccount())) {
      throw new IllegalStateException(paramString + "!=" + getAccount());
    }
    return a();
  }
  
  public Manager getManager(int paramInt)
  {
    Manager localManager1 = this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt];
    ??? = localManager1;
    if (localManager1 == null)
    {
      if (this.jdField_a_of_type_ArrayOfJavaLangObject[(this.jdField_a_of_type_ArrayOfJavaLangObject.length - 1)] == null) {}
      synchronized (this.jdField_a_of_type_ArrayOfJavaLangObject)
      {
        if (this.jdField_a_of_type_ArrayOfJavaLangObject[(this.jdField_a_of_type_ArrayOfJavaLangObject.length - 1)] == null)
        {
          int i1 = 0;
          while (i1 < this.jdField_a_of_type_ArrayOfJavaLangObject.length)
          {
            this.jdField_a_of_type_ArrayOfJavaLangObject[i1] = new Object();
            i1 += 1;
          }
        }
        if (!AppSetting.b) {}
      }
    }
    synchronized (this.jdField_a_of_type_ArrayOfJavaLangObject[paramInt])
    {
      for (;;)
      {
        localManager1 = this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt];
        if ((localManager1 == null) && ((getAccount() != null) || (paramInt <= 8) || (paramInt == 27))) {
          break;
        }
        return localManager1;
        localObject2 = finally;
        throw localObject2;
        ??? = this.jdField_a_of_type_ArrayOfMqqManagerManager;
      }
      blqm.a("getManager_" + paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "getManager begin" + paramInt);
      }
      h(paramInt);
      Manager localManager2 = aofj.a(paramInt, this);
      a(paramInt, localManager2);
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "getManager end" + paramInt);
      }
      blqm.a();
      if (localManager2 != null) {
        addManager(paramInt, localManager2);
      }
      ??? = localManager2;
      O();
      return ???;
    }
  }
  
  public String[] getMessagePushSSOCommands()
  {
    return new String[] { "OnlinePush.ReqPush", "MessageSvc.PushGroupMsg", "MessageSvc.PushForceOffline", "MessageSvc.PushNotify", "MessageSvc.PushForceOffline", "MessageSvc.RequestPushStatus", "RegPrxySvc.PullDisGroupSeq", "MessageSvc.RequestBatchPushFStatus", "MessageSvc.PushFStatus", "AccostSvc.SvrMsg", "ADMsgSvc.PushMsg", "StreamSvr.PushStreamMsg", "friendlist.getOnlineFriend", "MessageSvc.WNSQzone", "RegPrxySvc.PbGetMsg", "RegPrxySvc.getOffMsg", "RegPrxySvc.PbGetGroupMsg", "RegPrxySvc.PullDisMsgSeq", "RegPrxySvc.infoNew", "RegPrxySvc.PullDisMsgProxy", "RegPrxySvc.PbGetDiscussMsg", "RegPrxySvc.PullGroupMsgProxy", "RegPrxySvc.GetMsgV2", "RegPrxySvc.PullGroupMsgSeq", "RegPrxySvc.NoticeEnd", "RegPrxySvc.PbSyncMsg", "account.ResponseNotifyForRecommendUpdate", "MessageSvc.PushReaded", "RegPrxySvc.infoLogin", "baseSdk.Msf.NotifyResp", "RegPrxySvc.PushParam", "OnlinePush.PbPushGroupMsg", "OnlinePush.PbPushBindUinGroupMsg", "OnlinePush.PbPushTransMsg", "OnlinePush.PbPushDisMsg", "OnlinePush.PbC2CMsgSync", "OnlinePush.PbPushC2CMsg", "cmd_connAllFailed", "cmd_recvFirstResp", "MultiVideo.s2c", "MultiVideo.c2sack", "NearFieldTranFileSvr.NotifyList", "ProfileService.CheckUpdateReq", "NearFieldDiscussSvr.NotifyList", "RegPrxySvc.QueryIpwdStat", "StatSvc.SvcReqMSFLoginNotify", "ConfigPushSvc.PushDomain", "ImStatus.ReqPushStatus" };
  }
  
  public Class<? extends MSFServlet>[] getMessagePushServlets()
  {
    return new Class[] { aqwr.class, bcux.class, azox.class };
  }
  
  public beuo getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Bevk == null) {
      this.jdField_a_of_type_Bevk = ((bevk)getManager(21));
    }
    if (this.jdField_a_of_type_Bevk == null) {
      return null;
    }
    return this.jdField_a_of_type_Bevk.a(this, paramInt);
  }
  
  public RecentConfig getRecentConfig()
  {
    return alni.a().a();
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    SQLiteOpenHelper localSQLiteOpenHelper = a();
    if (localSQLiteOpenHelper != null) {
      return localSQLiteOpenHelper.getWritableDatabase();
    }
    return null;
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onRecvFistResp");
    }
    this.jdField_e_of_type_Boolean = true;
    MqqHandler localMqqHandler = getHandler(Conversation.class);
    if (!awzv.a().c())
    {
      awzv.a().a(2);
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
      if ((awzv.a().a()) && (localMqqHandler != null)) {
        localMqqHandler.obtainMessage(1134015, null).sendToTarget();
      }
    }
  }
  
  public void h(boolean paramBoolean1, boolean paramBoolean2)
  {
    bhru localbhru = (bhru)getManager(31);
    if (localbhru != null) {
      localbhru.a(paramBoolean1, paramBoolean2);
    }
  }
  
  boolean h()
  {
    if (m())
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
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onConnAllFailed");
    }
    awzv.a().a(4);
    MqqHandler localMqqHandler = getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(1134013, null).sendToTarget();
    }
  }
  
  public void i(boolean paramBoolean1, boolean paramBoolean2)
  {
    bhru localbhru = (bhru)getManager(31);
    if (localbhru != null) {
      localbhru.b(paramBoolean1, paramBoolean2);
    }
  }
  
  public boolean i()
  {
    return (this.jdField_a_of_type_Anuy == null) || (!this.jdField_a_of_type_Anuy.k());
  }
  
  public void j()
  {
    ThreadManager.post(new QQAppInterface.10(this), 10, null, true);
    try
    {
      sendToService(new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "CMD_STOP_NOTIFIYCATION"));
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean j()
  {
    return b() != 0;
  }
  
  public void k()
  {
    try
    {
      QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
      localQQNotificationManager.cancel("QQAppInterface_cancelNotification", 265);
      localQQNotificationManager.cancel("QQAppInterface_cancelNotification", 275);
      localQQNotificationManager.cancel("QQAppInterface_cancelNotification", 527);
      label34:
      a(getApp());
      return;
    }
    catch (Exception localException)
    {
      break label34;
    }
  }
  
  public boolean k()
  {
    return a() != 0;
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Ldi != null)
    {
      this.jdField_a_of_type_Ldi.a();
      this.jdField_a_of_type_Ldi = null;
    }
  }
  
  public boolean l()
  {
    return d() != 0;
  }
  
  public void logout(boolean paramBoolean)
  {
    if (paramBoolean) {
      S();
    }
    ((PushManager)getManager(5)).unregistProxyMessagePush(getAppid(), this.app.getPackageName() + ":video");
    awzv.a().a();
    R();
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "kickPC in app  do logout");
    }
    String str = getCurrentAccountUin();
    if (str != null) {}
    try
    {
      bnzp.a(getApp(), Long.parseLong(str));
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
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "getVideoConfigUpdate");
    }
    NewIntent localNewIntent = new NewIntent(this.app, bcwa.class);
    localNewIntent.putExtra("reqType", 11);
    startServlet(localNewIntent);
  }
  
  public boolean m()
  {
    return c() != 0;
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_Aoaw == null)
    {
      this.jdField_a_of_type_Aoaw = new aoaw(this);
      this.jdField_a_of_type_Aoaw.a();
    }
  }
  
  public boolean n()
  {
    AudioManager localAudioManager = (AudioManager)getApp().getSystemService("audio");
    if (localAudioManager != null) {}
    for (;;)
    {
      try
      {
        i1 = localAudioManager.getRingerMode();
        if (i1 == 0) {
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        i1 = 2;
        continue;
      }
      return false;
      int i1 = 2;
    }
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_Aoaw != null) {
      this.jdField_a_of_type_Aoaw.d();
    }
  }
  
  public boolean o()
  {
    AudioManager localAudioManager = (AudioManager)getApp().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getRingerMode() == 2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    startServlet(new NewIntent(getApplication(), bcvk.class));
    this.jdField_a_of_type_Bcpt = new bcpt(this);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator = new Automator(this);
    if (f())
    {
      baou.a(this, System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = a().createEntityManager();
      this.jdField_f_of_type_Long = System.currentTimeMillis();
      if (StartService.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(aolo.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator, "{85,{4,3,5,6},[11,12,14],17,20,21,59,60,22,113,108,44,45,114,[100,65,25,10,26,27,28,29,30,32,34,35,39,40,41,42,43,47,48,50,55,107,69,93,70,71,72,73,{91},53,54,61,104,63,77,81,67,80,74,36,37,38,87,88,78,82,84,98,86,102,103,109,110,111,112],57,95,105}"));
      }
      if (StartService.jdField_a_of_type_Boolean) {
        ThemeUtil.initTheme(this);
      }
      Z();
    }
    try
    {
      MagnifierSDK.a(Long.parseLong(getAccount()));
      ThreadManager.getSubThreadHandler().post(new QQAppInterface.1(this));
      if (StartService.jdField_a_of_type_Boolean) {
        bhhz.a();
      }
      if (GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager != null) {
        GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(this);
      }
      this.jdField_c_of_type_Boolean = true;
      a().a();
      a().d();
      aure.a().a(this);
      a().a();
      PluginManageHandler.getInstance().setPluginManagerProvider(this, false);
      c();
      bfxt.a().a();
      bfwl.a().a();
      bfxk.a().a();
      aubf.a().a(this);
      wnu.a(this);
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
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Aqzs.a();
    BaseApplicationImpl.sShowTime = 0L;
    BaseApplicationImpl.sLaunchTime = 0L;
    BaseApplicationImpl.appStartTime = 0L;
    besx.b();
    R();
    ThemeUiPlugin.destroy(this);
    ChatBackgroundManager.b();
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Aoev);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    ThreadManager.getSubThreadHandler().post(new QQAppInterface.16(this));
    ThreadManager.excute(new QQAppInterface.17(this), 80, null, false);
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "QQAppInterface onDestroy removeNotification");
    }
    j();
    if (QLog.isColorLevel()) {
      QLog.d("security_scan", 2, "Unregist Cloud Scan Listener");
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter != null) {
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a();
    }
    aure.a().a();
    if (this.jdField_a_of_type_Beyb != null) {
      a().b();
    }
    if (this.jdField_a_of_type_Axpe != null)
    {
      this.jdField_a_of_type_Axpe.a();
      this.jdField_a_of_type_Axpe = null;
    }
    aqzw.a();
    OpenApiManager.getInstance().onRuntimeDestroy(this);
    bcqt.a();
    QWalletHelper.clearInstance(this);
    if (this.jdField_a_of_type_Atws != null) {
      this.jdField_a_of_type_Atws.e();
    }
    if (this.mHwEngine != null) {
      this.mHwEngine.closeEngine();
    }
    if (!TextUtils.isEmpty(getCurrentAccountUin())) {
      arrs.b();
    }
    if (this.jdField_a_of_type_Atup != null) {
      a().e();
    }
    if (this.jdField_a_of_type_Bmim != null) {
      a().c();
    }
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
    if (localPresendPicMgr != null) {
      localPresendPicMgr.b();
    }
    if (InnerDns.mInstance != null) {
      InnerDns.getInstance().onAppDestroy();
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    bplq.a().a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
  }
  
  public RemotePluginManager.Stub onGetPluginManager()
  {
    return (bmhk)getManager(27);
  }
  
  public void onProcPause()
  {
    super.onProcPause();
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onProcPause");
    }
    E();
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
          c(paramIntent);
        }
      }
    }
    return bool1;
  }
  
  public void onRunningBackground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onRunningBackground");
    }
    super.onRunningBackground();
    V();
    E();
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.saveNotify();
    }
    bdll.a(this);
    a().b();
    Object localObject = (bapy)getManager(104);
    if (localObject != null) {
      ((bapy)localObject).c();
    }
    localObject = (MediaPlayerManager)this.jdField_a_of_type_ArrayOfMqqManagerManager[24];
    if ((localObject != null) && (((MediaPlayerManager)localObject).a())) {
      ((MediaPlayerManager)localObject).a(false);
    }
    a(-1L);
    U();
    anwn.a(BaseApplicationImpl.getContext());
    anwf.a(BaseApplicationImpl.getContext());
    bdlw.a(BaseApplicationImpl.getContext());
    LpReportManager.getInstance().startReportImediately(2);
    nwo.a().a();
    avxx.a().b();
    bdaa.a(this);
    lmo.a(this);
    aosq.a();
    azpm.b();
    JobReporter.reportThreadPeakCount(getCurrentAccountUin());
    pfs.i();
    try
    {
      aory.a().a();
      bdkn.a().b();
      UserguideActivity.a();
      admw.a().a(this);
      ArkStateCenter.getInstance().setForeground(false);
      localObject = (axaa)getManager(284);
      if (localObject != null) {
        ((axaa)localObject).a();
      }
      long l1 = bhsi.e();
      if (System.currentTimeMillis() - l1 > 14400000L)
      {
        localObject = (WebProcessManager)getManager(13);
        if (localObject != null)
        {
          ((WebProcessManager)localObject).a(204);
          bhsi.c(System.currentTimeMillis());
          if (QLog.isColorLevel()) {
            QLog.d("QQAppInterface", 2, "check update x5");
          }
        }
      }
      rnh.a();
      ac();
      svr.a(true);
      MiniAppReportManager.onEnterBackground();
      bdnj.a();
      bdmx.a(this);
      localObject = (aobl)getManager(159);
      if (localObject != null) {
        ((aobl)localObject).j();
      }
      localObject = (mxc)getManager(373);
      if (localObject != null) {
        ((mxc)localObject).a();
      }
      bdks.b();
      vtt.a().e();
      localObject = (PhoneContactManagerImp)getManager(11);
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
    bdll.b(this, "CliOper", "", "", "0X8004014", "0X8004014", 0, 0, "", "", "", "");
    Object localObject = a();
    if ((localObject != null) && (((QQMessageFacade)localObject).b() > 1)) {
      bdll.b(this, "CliOper", "", "", "0X8004015", "0X8004015", 0, 0, "", "", "", "");
    }
    if (sup.a())
    {
      sup.a().a(this, NetConnInfoCenter.getServerTimeMillis());
      sup.a().a(2);
    }
    bdll.a(this, false);
    bmja.a();
    localObject = new Intent("com.tencent.intent.QZONE_PRE_DOWNLOAD_CANCEL");
    BaseApplication.getContext().sendBroadcast((Intent)localObject);
    localObject = (PhoneContactManagerImp)getManager(11);
    if (localObject != null) {
      ((PhoneContactManagerImp)localObject).c();
    }
    localObject = (bcuy)getManager(12);
    if (localObject != null)
    {
      ((bcuy)localObject).b();
      if (isLogin())
      {
        ((bbav)getManager(36)).a();
        ((aogf)a(87)).a(false, true);
      }
    }
    localObject = (ArkAppCenter)getManager(121);
    if (localObject != null) {
      ((ArkAppCenter)localObject).a();
    }
    localObject = (axft)getManager(10);
    if (localObject != null)
    {
      if (((axft)localObject).a() > 0) {
        ((axft)localObject).a(((axft)localObject).a());
      }
      ((axft)localObject).a(2);
    }
    vlc.a().a(2, null, null);
    g(false);
    localObject = (bdwt)getManager(62);
    if ((localObject != null) && (((bdwt)localObject).jdField_a_of_type_Boolean))
    {
      bdwt.a(this, true);
      ((bdwt)localObject).jdField_a_of_type_Boolean = false;
    }
    akyb.a(this, false);
    bhrl.a(getApp().getBaseContext());
    localObject = (aold)getManager(85);
    agdj localagdj = (agdj)getManager(378);
    if (localObject != null)
    {
      ((aold)localObject).a();
      localagdj.a();
    }
    bdmc.a(BaseApplicationImpl.sApplication).a(this);
    B();
    QQToast.a(true);
    QWalletHelper.getPayCode(this);
    localObject = (alao)getManager(245);
    if (localObject != null) {
      ((alao)localObject).a(4);
    }
    if ((isLogin()) && (Build.VERSION.SDK_INT >= 23) && (this.s)) {
      aa();
    }
    localObject = a();
    if ((localObject != null) && (((nql)localObject).jdField_a_of_type_Boolean) && ((BaseActivity.sTopActivity instanceof SplashActivity)) && (SplashActivity.jdField_a_of_type_Int == 1)) {
      yup.a("story_tab", "exp", 0, ((nlb)getManager(70)).b(), new String[] { "", "", "", "" });
    }
    pfs.f();
    bias.a();
    ((oer)a(139)).a();
    ThreadManager.executeOnFileThread(new QQAppInterface.19(this));
    QLog.d("QQAppInterface", 2, "**davorteng**onRunningForeground...");
    localObject = (abur)a(51);
    if (localObject != null) {
      ((abur)localObject).c();
    }
    amvf.a().a(this);
    rnh.b();
    ArkStateCenter.getInstance().setForeground(true);
    MiniAppReportManager.onEnterForeground();
    AppBrandLaunchManager.g().onEnterForeground();
    vtt.a().d();
    W();
    X();
    amlv.a(2);
  }
  
  public void p()
  {
    try
    {
      ((anvl)a(4)).a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean p()
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
  
  public void q()
  {
    boolean bool;
    long l3;
    AppRuntime.Status localStatus1;
    long l2;
    if (f())
    {
      ((PushManager)getManager(5)).registProxyMessagePush(getAppid(), this.app.getPackageName() + ":video", "com.tencent.av.ui.VChatActivity", new String[] { "VideoSvc.Send", "VideoCCSvc.Adaptation", "SharpSvr.c2sack", "SharpSvr.s2c" });
      ((PushManager)getManager(5)).registProxyMessagePush(getAppid(), this.app.getPackageName() + ":nearby_video", "", new String[] { "VideoSvc.Send", "VideoCCSvc.Adaptation", "SharpSvr.c2sack", "SharpSvr.s2c" });
      bool = c();
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
        break label486;
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
    label486:
    for (long l1 = l2;; l1 = -1L)
    {
      r();
      sendOnlineStatusWithExt(localStatus1, bool, l3, false, l1);
      this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 4, String.format("sendRegisterPush onlineStatus: %s, isKickPC: %s, largeSeq: %s, mRegisterPushTime: %s", new Object[] { localStatus1, Boolean.valueOf(bool), Long.valueOf(l3), Long.valueOf(this.jdField_a_of_type_Long) }));
      }
      return;
    }
  }
  
  public boolean q()
  {
    try
    {
      AudioManager localAudioManager = (AudioManager)getApp().getSystemService("audio");
      if (localAudioManager != null)
      {
        int i1 = localAudioManager.getRingerMode();
        if (i1 == 1) {
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
  
  public void r()
  {
    int i1 = getBatteryCapacity();
    int i2 = getPowerConnect();
    if ((i1 == 0) || (i2 == -1))
    {
      i1 = azhq.a();
      i2 = azhq.b();
      setBatteryCapacity(i1);
      setPowerConnect(i2);
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, String.format("checkBatteryStatus, curBattery: %s, powerConnect:%s", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) }));
      }
    }
  }
  
  public boolean r()
  {
    AudioManager localAudioManager = (AudioManager)getApp().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getStreamVolume(2) == 0);
  }
  
  public void removeObserver(anui paramanui)
  {
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      this.jdField_b_of_type_JavaUtilList.remove(paramanui);
      synchronized (this.jdField_c_of_type_JavaUtilList)
      {
        this.jdField_c_of_type_JavaUtilList.remove(paramanui);
      }
    }
    synchronized (this.jdField_d_of_type_JavaUtilList)
    {
      this.jdField_d_of_type_JavaUtilList.remove(paramanui);
      return;
      paramanui = finally;
      throw paramanui;
      paramanui = finally;
      throw paramanui;
    }
  }
  
  public void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    bdll.b(this, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void reportClickEventRuntime(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    bdll.a(this, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void s()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "trySoundAndVibrate is called,needSoundAndVibrations is:" + Arrays.toString(this.jdField_a_of_type_ArrayOfByte));
    }
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
        localObject = ((QQMessageFacade)localObject).a();
      } while (localObject == null);
      this.jdField_c_of_type_ArrayOfLong[0] = ((QQMessageFacade.Message)localObject).uniseq;
      this.jdField_c_of_type_ArrayOfLong[1] = 1L;
    } while (this.jdField_a_of_type_ArrayOfByte[0] != 1);
    if (this.jdField_a_of_type_ArrayOfByte[1] == 1) {}
    for (;;)
    {
      c((MessageRecord)localObject, bool);
      this.jdField_a_of_type_ArrayOfByte[0] = 0;
      return;
      bool = false;
    }
  }
  
  public boolean s()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)getApp().getSystemService("phone");
    return (localTelephonyManager != null) && (localTelephonyManager.getCallState() == 0);
  }
  
  public void sendOnlineStatus(AppRuntime.Status paramStatus, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    super.sendOnlineStatus(paramStatus, paramBoolean1, paramLong, paramBoolean2);
  }
  
  public void sendOnlineStatusWithExt(AppRuntime.Status paramStatus, boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2)
  {
    super.sendOnlineStatusWithExt(paramStatus, paramBoolean1, paramLong1, paramBoolean2, paramLong2);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    if (this.jdField_a_of_type_Bcpt != null) {
      this.jdField_a_of_type_Bcpt.a(paramToServiceMsg);
    }
  }
  
  public void setAutoLogin(boolean paramBoolean)
  {
    String str = "";
    if (!getCurrentAccountUin().equals("0")) {
      str = getCurrentAccountUin();
    }
    bhsi.a(getApplication().getApplicationContext(), str, paramBoolean);
  }
  
  public void setBatteryCapacity(int paramInt)
  {
    super.setBatteryCapacity(paramInt);
    if (paramInt != 0)
    {
      bhsi.v(this.app.getApplicationContext(), paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, new Object[] { "setBatteryCapacity, capacity:", Integer.valueOf(paramInt) });
      }
    }
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
  
  public void setPowerConnect(int paramInt)
  {
    super.setPowerConnect(paramInt);
    if (paramInt != -1)
    {
      bhsi.w(this.app.getApplicationContext(), paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, new Object[] { "setPowerConnect, powerConnect: %s", Integer.valueOf(paramInt) });
      }
    }
  }
  
  public void start(boolean paramBoolean)
  {
    if ((paramBoolean) && (BaseApplicationImpl.sDirector != null)) {
      return;
    }
    this.jdField_a_of_type_Aoev = new aoev(this);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_Aoev);
    super.start(paramBoolean);
  }
  
  public void t()
  {
    b(null, false, true);
  }
  
  public boolean t()
  {
    return a().getBoolean(getApp().getString(2131694431) + getCurrentAccountUin(), false);
  }
  
  public void u()
  {
    ((aoat)a(3)).a();
  }
  
  public boolean u()
  {
    return ((axuk)getManager(161)).b();
  }
  
  public void userLogoutReleaseData()
  {
    S();
    bhdu.a().a(true);
    bdzh.a().a();
    bdzi.a().a();
    MsgAutoMonitorUtil.getInstance().release();
    ChatActivityUtils.c();
    blgq.a(this.app, 0);
    SharedPreferences.Editor localEditor = this.app.getSharedPreferences("unreadcount", 4).edit();
    localEditor.putInt("unread", 0);
    localEditor.commit();
    if (this.jdField_a_of_type_Beyb != null)
    {
      this.jdField_a_of_type_Beyb.b();
      this.jdField_a_of_type_Beyb.a();
    }
    OpenApiManager.getInstance().onUserLogout(this);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.onDestroy();
    nqq.a().c();
    bdhj.a(BaseApplicationImpl.getContext());
    MiniAppUtils.updateMiniAppList(100);
    aquy.b(getApp());
  }
  
  public void v()
  {
    ((anum)a(2)).a();
  }
  
  public boolean v()
  {
    return a().getBoolean(getApp().getString(2131694430) + getCurrentAccountUin(), false);
  }
  
  public void w()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      a().a(antf.N, 0);
      a().a().e();
      return;
    }
  }
  
  public boolean w()
  {
    return (this.jdField_a_of_type_Anuy != null) && (this.jdField_a_of_type_Anuy.k());
  }
  
  public void x()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      a().a(antf.O, 0);
      a().a().d();
      return;
    }
  }
  
  public boolean x()
  {
    boolean bool2 = false;
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.app);
    boolean bool3 = SettingCloneUtil.readValue(this.app, null, "security_scan_key", "qqsetting_security_scan_key", false);
    boolean bool4 = ((SharedPreferences)localObject).getBoolean("security_scan_last_result", false);
    long l1 = ((SharedPreferences)localObject).getLong("security_scan_last_time", 0L);
    localObject = new Date(l1);
    Date localDate = new Date();
    ((Date)localObject).setHours(0);
    ((Date)localObject).setMinutes(0);
    ((Date)localObject).setSeconds(0);
    boolean bool1 = bool2;
    if (bool3) {
      if ((l1 != 0L) && (localDate.getTime() - ((Date)localObject).getTime() <= 604800000L))
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
  
  public void y()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      a().a(antf.N, 0);
      return;
    }
  }
  
  public boolean y()
  {
    String str1 = getCurrentAccountUin();
    String str2 = bhlg.h(this, str1);
    Object localObject;
    if ((!TextUtils.isEmpty(str1)) && (str1.equals(str2)))
    {
      localObject = (anyw)getManager(51);
      if (localObject == null)
      {
        localObject = null;
        if ((localObject != null) && (((Friends)localObject).name != null)) {
          break label136;
        }
        localObject = (FriendListHandler)a(1);
        if (localObject == null) {
          break label136;
        }
        ((FriendListHandler)localObject).b(str1);
      }
    }
    label136:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("QQAppInterface", 4, "checkAndGetSelfNickName, [" + str2 + "," + bool + "]");
      }
      return bool;
      localObject = ((anyw)localObject).e(str1);
      break;
    }
  }
  
  public void z()
  {
    ISecureModuleService localISecureModuleService = a();
    if (localISecureModuleService.register(new ProductInfo(6, f(), Integer.parseInt("4745"), 201, null, getAccount())) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("security_scan", 2, "Start Security Scan");
      }
      if (this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener == null) {
        this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener = new aoeo(this);
      }
      localISecureModuleService.registerCloudScanListener(getApp(), this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener);
      localISecureModuleService.cloudScan();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("security_scan", 2, "regist security service error");
  }
  
  public boolean z()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getBoolean(BaseApplication.getContext().getString(2131694439) + getCurrentAccountUin(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface
 * JD-Core Version:    0.7.0.1
 */