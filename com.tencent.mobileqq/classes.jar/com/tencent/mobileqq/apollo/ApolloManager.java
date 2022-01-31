package com.tencent.mobileqq.apollo;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ConfigurationInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ai.ApolloAIMessage;
import com.tencent.mobileqq.apollo.ai.IApolloAIListener;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.game.ApolloGameConfig;
import com.tencent.mobileqq.apollo.game.ApolloGameConst;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloListenerManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.utils.IResDownloadListener;
import com.tencent.mobileqq.apollo.view.ApolloGameHotChatController;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.ApolloContentUpdateHandler;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.data.ApolloActionPackageData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ApolloGameModeData;
import com.tencent.mobileqq.data.ApolloPandora;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xca.submsgtype0xca.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xca.submsgtype0xca.MsgContent;
import tencent.im.s2c.msgtype0x210.submsgtype0xdc.submsgtype0xdc.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xdc.submsgtype0xdc.MsgContent;
import yjz;
import yka;
import ykb;
import ykc;
import ykd;
import yke;
import ykf;
import ykg;
import ykh;
import yki;
import ykj;
import ykk;
import ykl;
import ykm;
import ykn;
import yko;
import ykp;
import ykq;
import ykr;
import yks;

public class ApolloManager
  implements Manager
{
  public static int a;
  public static String a;
  public static ArrayList a;
  public static HashSet a;
  public static Vector a;
  public static boolean a;
  public static int b;
  public static String b;
  public static Vector b;
  public static boolean b;
  private static int jdField_c_of_type_Int;
  public static String c;
  private static AtomicBoolean jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private static int d;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  private static boolean g;
  public static String h;
  private static boolean h;
  public static String i;
  private static boolean i = true;
  public static String j;
  private static boolean j = true;
  private static String m;
  public long a;
  public Handler a;
  private QQLruCache jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new yjz(this, 2009, 1024, ApolloBaseInfo.calcSelfMemorySize());
  private ApolloGameNormalStartHandler jdField_a_of_type_ComTencentMobileqqApolloApolloGameNormalStartHandler;
  ApolloPanelManager jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager;
  IApolloAIListener jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIListener;
  ApolloResDownloader.OnApolloDownLoadListener jdField_a_of_type_ComTencentMobileqqApolloStoreApolloResDownloader$OnApolloDownLoadListener;
  public ApolloListenerManager a;
  private ApolloGameHotChatController jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameHotChatController;
  public QQAppInterface a;
  private ApolloBaseInfo jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new yko(this);
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = new ykk(this);
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  Comparator jdField_a_of_type_JavaUtilComparator = new ykj(this);
  public HashMap a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public JSONObject a;
  private yks jdField_a_of_type_Yks;
  public DownloadListener b;
  private Runnable jdField_b_of_type_JavaLangRunnable = new ykm(this);
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  private HashSet jdField_b_of_type_JavaUtilHashSet = new HashSet();
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private Runnable jdField_c_of_type_JavaLangRunnable = new ykn(this);
  private WeakReference jdField_c_of_type_JavaLangRefWeakReference;
  public boolean c;
  public boolean d;
  public volatile boolean e;
  public boolean f;
  public String k;
  private volatile boolean k;
  public String l;
  
  static
  {
    jdField_c_of_type_Int = -1;
    jdField_d_of_type_Int = -1;
    jdField_a_of_type_JavaUtilHashSet = new HashSet(16);
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(16);
    jdField_a_of_type_Boolean = true;
    f = "{}";
    jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_JavaUtilVector = new Vector();
    jdField_b_of_type_JavaUtilVector = new Vector();
    jdField_a_of_type_Int = 4096;
    jdField_b_of_type_Int = 4097;
  }
  
  public ApolloManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_ComTencentMobileqqVipDownloadListener = new ykp(this);
    this.jdField_a_of_type_AndroidOsHandler = new ykc(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_c_of_type_Int = -1;
    jdField_a_of_type_JavaUtilVector.clear();
    jdField_b_of_type_JavaUtilVector.clear();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (b(paramQQAppInterface.getApp()))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager = new ApolloListenerManager();
      i();
      ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
      ThreadManager.getFileThreadHandler().post(this.jdField_b_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager = new ApolloPanelManager(paramQQAppInterface);
    this.jdField_a_of_type_Yks = new yks(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ApolloGameStateMachine.a().deleteObserver(this.jdField_a_of_type_Yks);
    ApolloGameStateMachine.a().addObserver(this.jdField_a_of_type_Yks);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloGameNormalStartHandler = new ApolloGameNormalStartHandler(paramQQAppInterface);
  }
  
  public static int a(AppInterface paramAppInterface)
  {
    for (;;)
    {
      try
      {
        if (jdField_c_of_type_Int == -1)
        {
          jdField_c_of_type_Int = 0;
          if (paramAppInterface != null)
          {
            n = SharedPreUtils.s(paramAppInterface.getApplication());
            if (n != 0) {
              continue;
            }
            jdField_c_of_type_Int = paramAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).getInt(paramAppInterface.getCurrentAccountUin() + "_whiteList", 0);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "white list global: " + n + ", mWhiteUserStatus: " + jdField_c_of_type_Int);
            }
          }
        }
      }
      catch (Throwable paramAppInterface)
      {
        int n;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloManager", 2, "getWhiteListStatus error = " + paramAppInterface.toString());
        continue;
      }
      return jdField_c_of_type_Int;
      if (1 == n) {
        jdField_c_of_type_Int = 1;
      }
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (!b(paramQQAppInterface.getApplication())) || (TextUtils.isEmpty(paramString1)) || (ApolloConfigUtils.jdField_a_of_type_OrgJsonJSONObject == null)) {
      return -1;
    }
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      str = paramString2;
      if (!TextUtils.isEmpty(paramQQAppInterface.getCurrentAccountUin()))
      {
        paramString2 = (ApolloManager)paramQQAppInterface.getManager(152);
        if (paramString2.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo == null) {
          break label192;
        }
        n = paramString2.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloStatus;
        int i1 = a(paramQQAppInterface);
        str = i1 + "x" + n;
      }
    }
    if (ApolloConfigUtils.jdField_a_of_type_OrgJsonJSONObject != null)
    {
      paramQQAppInterface = ApolloConfigUtils.jdField_a_of_type_OrgJsonJSONObject.optJSONObject(str);
      if (paramQQAppInterface == null) {}
    }
    for (int n = paramQQAppInterface.optInt(paramString1);; n = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "queryStatusInConfig ruleKey: " + str + ", entry = " + paramString1 + ", value=" + n);
      }
      return n;
      label192:
      ThreadManager.getSubThreadHandler().post(new yke(paramString2, paramQQAppInterface));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloManager", 2, "queryStatusInConfig but apollomanager dont init done");
      return -1;
    }
  }
  
  public static SharedPreferences a()
  {
    String str2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "noLogin";
    }
    return BaseApplicationImpl.getApplication().getSharedPreferences("apollo_stand_up" + str1, 4);
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (b(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "user is in game white list.");
        }
        return String.format("http://open.hudong.qq.com/aio/aio_game?uin=%1$s&platform=%2$s", new Object[] { str, "android" });
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "user is NOT in game white list.");
    }
    return "http://i.hudongcdn.com/game_config.json";
  }
  
  public static List a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localArrayList;
      try
      {
        paramString = new JSONArray(paramString);
        int n = 0;
        if (n < paramString.length())
        {
          JSONObject localJSONObject = paramString.getJSONObject(n);
          ApolloAIMessage localApolloAIMessage = new ApolloAIMessage();
          localApolloAIMessage.jdField_a_of_type_Int = localJSONObject.optInt("msgType");
          if (localApolloAIMessage.jdField_a_of_type_Int == 0) {
            localApolloAIMessage.jdField_a_of_type_JavaLangString = localJSONObject.optString("msgContent");
          }
          for (;;)
          {
            localApolloAIMessage.jdField_b_of_type_Int = localJSONObject.optInt("actionId");
            localApolloAIMessage.jdField_e_of_type_Int = localJSONObject.optInt("expts");
            localApolloAIMessage.f = localJSONObject.optInt("showType");
            localApolloAIMessage.c = localJSONObject.optString("url");
            localArrayList.add(localApolloAIMessage);
            n += 1;
            break;
            if (localApolloAIMessage.jdField_a_of_type_Int == 1) {
              localApolloAIMessage.jdField_b_of_type_JavaLangString = localJSONObject.optString("msgContent");
            }
          }
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ApolloManager", 2, "apollo AI getTopicError e:" + paramString.toString());
        }
      }
    }
    QLog.d("ApolloManager", 2, "get AIPush message from sp:" + localArrayList.toString());
    return localArrayList;
  }
  
  public static void a()
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
            ((MqqHandler)localObject).sendEmptyMessage(357);
            QLog.i("ApolloStoreActivity", 1, "send refresh apollo view msg");
          }
        }
      }
    }
  }
  
  public static void a(int paramInt, String paramString, Activity paramActivity)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("CMShow.GameId", String.valueOf(paramInt));
      localJSONObject2.put("extraInfo", paramString);
      localJSONObject1.put("CMShow.Game", localJSONObject2);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "[launchGameDetailView] mate:" + localJSONObject1.toString());
      }
      ArkFullScreenAppActivity.a(paramActivity, "com.tencent.cmgame.intent", "GameCard", localJSONObject1.toString());
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("ApolloManager", 1, "[launchGameDetailView] error:", paramString);
      }
    }
  }
  
  private void a(int paramInt, List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null)) {
      QLog.e("ApolloManager", 1, "[saveBubblePushData], null param");
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "[saveBubblePushData] msgType:", Integer.valueOf(paramInt) });
      }
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      try
      {
        localEntityTransaction.a();
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            submsgtype0xdc.MsgContent localMsgContent = (submsgtype0xdc.MsgContent)paramList.next();
            DrawerPushItem localDrawerPushItem = new DrawerPushItem();
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
            if ((this.jdField_a_of_type_JavaUtilList != null) && (!a(localDrawerPushItem))) {
              this.jdField_a_of_type_JavaUtilList.add(localDrawerPushItem);
            }
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localDrawerPushItem);
          }
        }
      }
      catch (Exception paramList)
      {
        QLog.e("ApolloManager", 1, "[saveBubblePushData], Apollo Push Bubble Error:" + paramList.getMessage());
        return;
        localEntityTransaction.c();
        return;
      }
      finally
      {
        if (localEntityTransaction != null) {
          localEntityTransaction.b();
        }
      }
    }
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +40 -> 49
    //   12: ldc_w 325
    //   15: iconst_2
    //   16: new 297	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 712
    //   26: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 714
    //   36: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_2
    //   40: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: new 716	java/io/File
    //   52: dup
    //   53: getstatic 719	com/tencent/mobileqq/apollo/utils/ApolloConstant:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   56: invokespecial 720	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: invokevirtual 723	java/io/File:mkdirs	()Z
    //   62: pop
    //   63: aload_0
    //   64: invokevirtual 729	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   67: aload_1
    //   68: invokevirtual 735	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   71: astore_0
    //   72: new 737	java/io/FileOutputStream
    //   75: dup
    //   76: new 716	java/io/File
    //   79: dup
    //   80: aload_2
    //   81: invokespecial 720	java/io/File:<init>	(Ljava/lang/String;)V
    //   84: invokespecial 740	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   87: astore_1
    //   88: sipush 4096
    //   91: newarray byte
    //   93: astore_2
    //   94: aload_0
    //   95: aload_2
    //   96: invokevirtual 746	java/io/InputStream:read	([B)I
    //   99: istore_3
    //   100: iload_3
    //   101: iconst_m1
    //   102: if_icmpeq +77 -> 179
    //   105: aload_1
    //   106: aload_2
    //   107: iconst_0
    //   108: iload_3
    //   109: invokevirtual 750	java/io/FileOutputStream:write	([BII)V
    //   112: goto -18 -> 94
    //   115: astore 4
    //   117: aload_0
    //   118: astore_2
    //   119: aload 4
    //   121: astore_0
    //   122: aload_0
    //   123: invokevirtual 753	java/lang/Exception:printStackTrace	()V
    //   126: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +33 -> 162
    //   132: ldc_w 325
    //   135: iconst_2
    //   136: new 297	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 755
    //   146: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_0
    //   150: invokevirtual 705	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   153: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_2
    //   163: ifnull +7 -> 170
    //   166: aload_2
    //   167: invokevirtual 758	java/io/InputStream:close	()V
    //   170: aload_1
    //   171: ifnull +7 -> 178
    //   174: aload_1
    //   175: invokevirtual 759	java/io/FileOutputStream:close	()V
    //   178: return
    //   179: aload_1
    //   180: invokevirtual 762	java/io/FileOutputStream:flush	()V
    //   183: aload_0
    //   184: ifnull +7 -> 191
    //   187: aload_0
    //   188: invokevirtual 758	java/io/InputStream:close	()V
    //   191: aload_1
    //   192: ifnull -14 -> 178
    //   195: aload_1
    //   196: invokevirtual 759	java/io/FileOutputStream:close	()V
    //   199: return
    //   200: astore_0
    //   201: return
    //   202: astore_0
    //   203: aconst_null
    //   204: astore_1
    //   205: aload 5
    //   207: astore_2
    //   208: aload_2
    //   209: ifnull +7 -> 216
    //   212: aload_2
    //   213: invokevirtual 758	java/io/InputStream:close	()V
    //   216: aload_1
    //   217: ifnull +7 -> 224
    //   220: aload_1
    //   221: invokevirtual 759	java/io/FileOutputStream:close	()V
    //   224: aload_0
    //   225: athrow
    //   226: astore_1
    //   227: goto -3 -> 224
    //   230: astore 4
    //   232: aconst_null
    //   233: astore_1
    //   234: aload_0
    //   235: astore_2
    //   236: aload 4
    //   238: astore_0
    //   239: goto -31 -> 208
    //   242: astore 4
    //   244: aload_0
    //   245: astore_2
    //   246: aload 4
    //   248: astore_0
    //   249: goto -41 -> 208
    //   252: astore_0
    //   253: goto -45 -> 208
    //   256: astore_0
    //   257: return
    //   258: astore_0
    //   259: aconst_null
    //   260: astore_1
    //   261: aload 4
    //   263: astore_2
    //   264: goto -142 -> 122
    //   267: astore 4
    //   269: aconst_null
    //   270: astore_1
    //   271: aload_0
    //   272: astore_2
    //   273: aload 4
    //   275: astore_0
    //   276: goto -154 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	paramContext	Context
    //   0	279	1	paramString1	String
    //   0	279	2	paramString2	String
    //   99	10	3	n	int
    //   4	1	4	localObject1	Object
    //   115	5	4	localException1	Exception
    //   230	7	4	localObject2	Object
    //   242	20	4	localObject3	Object
    //   267	7	4	localException2	Exception
    //   1	205	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   88	94	115	java/lang/Exception
    //   94	100	115	java/lang/Exception
    //   105	112	115	java/lang/Exception
    //   179	183	115	java/lang/Exception
    //   187	191	200	java/lang/Exception
    //   195	199	200	java/lang/Exception
    //   49	72	202	finally
    //   212	216	226	java/lang/Exception
    //   220	224	226	java/lang/Exception
    //   72	88	230	finally
    //   88	94	242	finally
    //   94	100	242	finally
    //   105	112	242	finally
    //   179	183	242	finally
    //   122	162	252	finally
    //   166	170	256	java/lang/Exception
    //   174	178	256	java/lang/Exception
    //   49	72	258	java/lang/Exception
    //   72	88	267	java/lang/Exception
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    ThreadManager.getFileThreadHandler().post(new ykd(paramAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).edit().putString("apollo_ai_news_sp" + paramQQAppInterface.c(), "").commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Object localObject = (ApolloManager)paramQQAppInterface.getManager(152);
    VasExtensionHandler localVasExtensionHandler = (VasExtensionHandler)paramQQAppInterface.a(71);
    ApolloBaseInfo localApolloBaseInfo = ((ApolloManager)localObject).b(paramString1 + "");
    if ((localApolloBaseInfo == null) || (localApolloBaseInfo.apolloUpdateTime == 0L))
    {
      localVasExtensionHandler.b(paramString1 + "");
      if (QLog.isColorLevel()) {
        if (paramString1.length() < 4) {
          break label450;
        }
      }
    }
    label450:
    for (paramQQAppInterface = paramString1.substring(0, 4);; paramQQAppInterface = paramString1)
    {
      QLog.d("ApolloManager", 2, "checkUserDress---> getApolloBaseInfo uin: " + paramQQAppInterface);
      do
      {
        do
        {
          if ((QLog.isColorLevel()) && (localApolloBaseInfo != null) && (localApolloBaseInfo.apolloStatus != 1)) {
            QLog.d("ApolloManager", 2, "checkUserDress---> user apollo status is not open uin: " + paramString1 + ", status: " + localApolloBaseInfo.apolloStatus);
          }
          if ((localApolloBaseInfo == null) || (localApolloBaseInfo.apolloStatus != 1) || (0L == localApolloBaseInfo.apolloSignValidTS) || (NetConnInfoCenter.getServerTime() >= localApolloBaseInfo.apolloSignValidTS) || (localApolloBaseInfo.apolloSignValidTS == localApolloBaseInfo.apolloLocalSignTs)) {
            break;
          }
          localVasExtensionHandler.b(paramString1, "AIO");
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloManager", 2, "getUserSignStr...");
          return;
        } while ((localApolloBaseInfo.apolloStatus != 1) || (localApolloBaseInfo.apolloServerTS == localApolloBaseInfo.apolloLocalTS));
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(Long.valueOf(Long.parseLong(paramString1)));
        localObject = ((ApolloManager)localObject).b(paramQQAppInterface.c());
        if ((localObject != null) && (((ApolloBaseInfo)localObject).apolloLocalTS != ((ApolloBaseInfo)localObject).apolloServerTS)) {
          localArrayList.add(Long.valueOf(paramQQAppInterface.getLongAccountUin()));
        }
        localVasExtensionHandler.a(localArrayList, paramString2);
      } while (!QLog.isColorLevel());
      if (paramString1.length() >= 4) {}
      for (paramQQAppInterface = paramString1.substring(0, 4);; paramQQAppInterface = paramString1)
      {
        QLog.d("ApolloManager", 2, "checkUserDress---> getGetUserApolloDress uin: " + paramQQAppInterface + ", old dress: " + localApolloBaseInfo.getApolloDress());
        break;
      }
    }
  }
  
  private void a(ApolloActionPackage paramApolloActionPackage, JSONObject paramJSONObject)
  {
    if ((paramApolloActionPackage == null) || (paramJSONObject == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      return;
      long l1;
      long l2;
      int n;
      SharedPreferences localSharedPreferences;
      try
      {
        l1 = paramJSONObject.optLong("startTime");
        l2 = paramJSONObject.optLong("interval");
        n = paramJSONObject.optInt("actionId");
        ApolloActionPackage localApolloActionPackage = ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154)).a(paramApolloActionPackage.packageId);
        localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
        long l3 = localSharedPreferences.getLong("key_panel_red_dots_start_time", 0L);
        if ((localApolloActionPackage != null) && (l1 == l3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, new Object[] { "checkPackageRedDots", " have not new red push" });
          }
          paramApolloActionPackage.isUpdate = localApolloActionPackage.isUpdate;
          paramApolloActionPackage.redFlowId = localApolloActionPackage.redFlowId;
          paramApolloActionPackage.redStartTime = localApolloActionPackage.redStartTime;
          paramApolloActionPackage.redInterval = localApolloActionPackage.redInterval;
          return;
        }
      }
      catch (Exception paramApolloActionPackage)
      {
        QLog.e("ApolloManager", 1, "checkPackageRedDots Exception:", paramApolloActionPackage);
        return;
      }
      localSharedPreferences.edit().putLong("key_panel_red_dots_start_time", l1).commit();
      paramApolloActionPackage.isUpdate = true;
      paramApolloActionPackage.redFlowId = n;
      paramApolloActionPackage.redStartTime = l1;
      paramApolloActionPackage.redInterval = l2;
      e(paramApolloActionPackage.packageId);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloManager", 2, new Object[] { "checkPackageRedDots", " push red:", Integer.valueOf(paramApolloActionPackage.packageId), " dots:", paramJSONObject });
  }
  
  private void a(List paramList1, List paramList2, List paramList3, JSONObject paramJSONObject)
  {
    for (;;)
    {
      ArrayList localArrayList;
      int n;
      Object localObject2;
      Object localObject4;
      int i1;
      try
      {
        localArrayList = new ArrayList();
        Object localObject5;
        if ((paramJSONObject != null) && (paramJSONObject.has("data")))
        {
          localObject1 = paramJSONObject.getJSONArray("data");
          if (localObject1 != null)
          {
            int i2 = ((JSONArray)localObject1).length();
            n = 0;
            if (n < i2)
            {
              localObject3 = ((JSONArray)localObject1).getJSONObject(n);
              if (localObject3 == null) {
                break label1581;
              }
              localObject2 = new ApolloActionData();
              ((ApolloActionData)localObject2).actionId = ((JSONObject)localObject3).getInt("id");
              ((ApolloActionData)localObject2).sessionType = ((JSONObject)localObject3).getInt("use");
              ((ApolloActionData)localObject2).actionName = ((JSONObject)localObject3).getString("name");
              ((ApolloActionData)localObject2).vipLevel = ((JSONObject)localObject3).getInt("vipLevel");
              ((ApolloActionData)localObject2).feeType = ((JSONObject)localObject3).getInt("feeType");
              if (((JSONObject)localObject3).has("icon")) {
                ((ApolloActionData)localObject2).icon = ((JSONObject)localObject3).getInt("icon");
              }
              ((ApolloActionData)localObject2).iconUrl = ((JSONObject)localObject3).optString("iconUrl");
              ((ApolloActionData)localObject2).personNum = ((JSONObject)localObject3).getInt("type");
              ((ApolloActionData)localObject2).anmiName = ((JSONObject)localObject3).optString("animationName");
              ((ApolloActionData)localObject2).isShow = ((JSONObject)localObject3).optInt("isShow");
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
              ((ApolloActionData)localObject2).actionMoveDis = ((float)((JSONObject)localObject3).optDouble("actionDis"));
              ((ApolloActionData)localObject2).peerMoveDis = ((float)((JSONObject)localObject3).optDouble("actionPeerDis"));
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
              localObject4 = ((JSONObject)localObject3).optJSONArray("pkIds");
              int i3;
              if (localObject4 != null)
              {
                i3 = ((JSONArray)localObject4).length();
                localObject5 = new StringBuilder();
                i1 = 0;
                label528:
                if (i1 < i3)
                {
                  ((StringBuilder)localObject5).append(String.valueOf(((JSONArray)localObject4).get(i1)));
                  if (i1 == i3 - 1) {
                    break label1563;
                  }
                  ((StringBuilder)localObject5).append(",");
                  break label1563;
                }
                ((ApolloActionData)localObject2).pkIds = ((StringBuilder)localObject5).toString();
              }
              localObject3 = ((JSONObject)localObject3).optJSONArray("keywords");
              if (localObject3 != null)
              {
                i3 = ((JSONArray)localObject3).length();
                localObject4 = new StringBuilder();
                i1 = 0;
                label616:
                if (i1 < i3)
                {
                  ((StringBuilder)localObject4).append(String.valueOf(((JSONArray)localObject3).get(i1)));
                  if (i1 == i3 - 1) {
                    break label1572;
                  }
                  ((StringBuilder)localObject4).append(",");
                  break label1572;
                }
                ((ApolloActionData)localObject2).keywords = ((StringBuilder)localObject4).toString();
              }
              if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(((ApolloActionData)localObject2).actionId))))
              {
                if (((ApolloActionData)localObject2).isShow == 0) {
                  ((ApolloActionData)localObject2).isShow = 1;
                }
                a((ApolloActionData)localObject2, (Bundle)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(((ApolloActionData)localObject2).actionId)));
              }
              b((ApolloActionData)localObject2);
              paramList1.add(localObject2);
              if (((ApolloActionData)localObject2).feeType != 6) {
                break label1581;
              }
              localArrayList.add(localObject2);
              break label1581;
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          return;
        }
        Object localObject1 = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
        localArrayList = new ArrayList();
        if ((paramJSONObject == null) || (!paramJSONObject.has("packageInfo"))) {
          break label1448;
        }
        paramJSONObject = paramJSONObject.getJSONArray("packageInfo");
        if (paramJSONObject == null) {
          break label1448;
        }
        n = 0;
        if (n >= paramJSONObject.length()) {
          break label1448;
        }
        Object localObject3 = paramJSONObject.getJSONObject(n);
        if (localObject3 == null) {
          break label1591;
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
        a((ApolloActionPackage)localObject2, ((JSONObject)localObject3).optJSONObject("reddots"));
        ((ApolloDaoManager)localObject1).a(((ApolloActionPackage)localObject2).packageId);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "ActionPackage pid = " + ((ApolloActionPackage)localObject2).packageId + " actionPackage.isUpdate = " + ((ApolloActionPackage)localObject2).isUpdate);
        }
        paramList2.add(localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "add actionPackage pid=" + ((ApolloActionPackage)localObject2).packageId);
        }
        localObject3 = ((JSONObject)localObject3).optJSONArray("actionSet");
        if ((localObject3 == null) || (((JSONArray)localObject3).length() <= 0)) {
          break label1427;
        }
        localObject4 = new StringBuilder();
        i1 = 0;
        if (i1 < ((JSONArray)localObject3).length())
        {
          localObject5 = ((JSONArray)localObject3).getJSONObject(i1);
          ApolloActionPackageData localApolloActionPackageData = new ApolloActionPackageData();
          localApolloActionPackageData.packageId = ((ApolloActionPackage)localObject2).packageId;
          localApolloActionPackageData.acitonId = ((JSONObject)localObject5).optInt("actionId");
          localApolloActionPackageData.text = ((JSONObject)localObject5).optString("text");
          localApolloActionPackageData.textType = ((JSONObject)localObject5).optInt("textType");
          if (a(localApolloActionPackageData.acitonId, paramList1))
          {
            paramList3.add(localApolloActionPackageData);
            if (localApolloActionPackageData.packageId == 5) {
              localArrayList.add(Integer.valueOf(localApolloActionPackageData.acitonId));
            }
            ((StringBuilder)localObject4).append(localApolloActionPackageData.acitonId).append(" ");
            i1 += 1;
            continue;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ApolloManager", 2, "action list has not packageAction id=" + localApolloActionPackageData.acitonId);
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label1591;
        }
      }
      catch (JSONException paramList1)
      {
        QLog.e("ApolloManager", 2, "parse ActionInfo error:" + paramList1.toString());
        return;
      }
      QLog.d("ApolloManager", 2, new Object[] { "addActionPackageData packageId=", Integer.valueOf(((ApolloActionPackage)localObject2).packageId), " actionId=[", ((StringBuilder)localObject4).toString(), "]" });
      break label1591;
      label1427:
      if (((ApolloActionPackage)localObject2).type != 2)
      {
        paramList2.remove(localObject2);
        break label1591;
        label1448:
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, new Object[] { "[parseActionInfo] world action list=", localArrayList });
        }
        if ((localArrayList != null) && (localArrayList.size() > 0) && (paramList1 != null) && (paramList1.size() > 0))
        {
          paramList1 = paramList1.iterator();
          for (;;)
          {
            if (paramList1.hasNext())
            {
              paramList2 = (ApolloActionData)paramList1.next();
              if (localArrayList.contains(Integer.valueOf(paramList2.actionId)))
              {
                paramList2.hasExtraAction = true;
              }
              else
              {
                paramList2.hasExtraAction = false;
                continue;
                label1563:
                i1 += 1;
                break label528;
                label1572:
                i1 += 1;
                break label616;
                label1581:
                n += 1;
                break;
              }
            }
          }
        }
        return;
      }
      label1591:
      n += 1;
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      try
      {
        int n = (int)(paramJSONObject.optLong("startTime") / 1000L);
        SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
        if (n != localSharedPreferences.getInt("key_panel_bubble_start_time", 0))
        {
          DrawerPushItem localDrawerPushItem = new DrawerPushItem();
          localDrawerPushItem.is_reddot = 0;
          localDrawerPushItem.msg_id = "aio_panel_bubble_push";
          localDrawerPushItem.msg_type = 7;
          localDrawerPushItem.priority = 1000;
          localDrawerPushItem.start_ts = n;
          localDrawerPushItem.end_ts = ((int)NetConnInfoCenter.getServerTime() + (int)(paramJSONObject.optLong("interval") / 1000L));
          localDrawerPushItem.send_time = n;
          localDrawerPushItem.content = paramJSONObject.optString("bubbleText");
          localDrawerPushItem.show_counts = paramJSONObject.optInt("showCount");
          if (localDrawerPushItem.show_counts == 0) {
            localDrawerPushItem.show_counts = 1;
          }
          int i1 = paramJSONObject.optInt("packageId");
          c(localDrawerPushItem);
          paramJSONObject = localSharedPreferences.edit();
          paramJSONObject.putInt("key_panel_bubble_start_time", n);
          if (i1 >= 0) {
            paramJSONObject.putInt("key_panel_bubble_tab", i1);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, new Object[] { "checkPackageBubbleInfo", " push bubble:", localDrawerPushItem.toString(), " ,packageId", Integer.valueOf(i1) });
          }
          paramJSONObject.commit();
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("ApolloManager", 1, "checkPackageBubbleInfo Exception:", paramJSONObject);
      }
    }
  }
  
  public static boolean a()
  {
    boolean bool1 = false;
    l1 = System.currentTimeMillis();
    FileUtils.a(new File(ApolloConstant.jdField_b_of_type_JavaLangString, "/def/basic").getAbsolutePath());
    do
    {
      try
      {
        long l2 = System.currentTimeMillis();
        a(BaseApplicationImpl.getApplication().getApplicationContext(), "apollo_def_rsc", ApolloConstant.jdField_a_of_type_JavaLangString + "/apollo_def_rsc");
        long l3 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "copy file to sdcard cost:" + (l3 - l2));
        }
        new File(ApolloConstant.jdField_b_of_type_JavaLangString, "def").mkdirs();
        int n = LzmaUtils.a(BaseApplicationImpl.getApplication().getApplicationContext(), ApolloConstant.jdField_a_of_type_JavaLangString + "/apollo_def_rsc", ApolloConstant.jdField_b_of_type_JavaLangString + "/def/");
        FileUtils.d(ApolloConstant.jdField_a_of_type_JavaLangString + "/apollo_def_rsc");
        if (n != 0) {
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
          break label432;
        }
        QLog.d("ApolloManager", 2, "unzip cost: " + (System.currentTimeMillis() - l1) + " ms");
      }
      return bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloManager", 2, "unzip cost: " + (System.currentTimeMillis() - l1) + " ms");
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    return a(paramContext, Boolean.valueOf(true));
  }
  
  public static boolean a(Context paramContext, Boolean paramBoolean)
  {
    if (!b(paramContext)) {}
    while ((paramBoolean.booleanValue()) && (1 != a(CmGameUtil.a()))) {
      return false;
    }
    paramContext = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.apollo_info.name(), "");
    if ((!TextUtils.isEmpty(paramContext)) && (!paramContext.equals(m)))
    {
      m = paramContext;
      paramBoolean = paramContext.split("\\|");
      if (paramBoolean.length > 0) {
        i = "1".equals(paramBoolean[0]);
      }
      if (paramBoolean.length > 1) {
        j = "1".equals(paramBoolean[1]);
      }
    }
    if ((!i) || (!j)) {
      QLog.i("ApolloManager", 1, "apollo dpc cfg: " + paramContext);
    }
    return i;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return ApolloGameConst.jdField_c_of_type_Int == ApolloGameConfig.a("CMGamePlusPanel");
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    String str = ApolloConstant.n + paramString1 + ".zip";
    localObject1 = ApolloConstant.n + paramString1 + ".patch";
    localObject2 = ApolloConstant.n + paramString1 + ".patched";
    paramString1 = new File(str);
    localObject1 = new File((String)localObject1);
    localObject2 = new File((String)localObject2);
    label250:
    do
    {
      try
      {
        if (((File)localObject2).exists()) {
          ((File)localObject2).delete();
        }
        ((File)localObject2).createNewFile();
        if ((!paramString1.exists()) || (!paramString1.isFile()) || (!((File)localObject1).exists()) || (!((File)localObject1).isFile()) || (!BspatchUtil.a(paramString1.getAbsolutePath(), ((File)localObject1).getAbsolutePath(), ((File)localObject2).getAbsolutePath()))) {
          break label286;
        }
        ((File)localObject1).delete();
        paramString1.delete();
        ((File)localObject2).renameTo(paramString1);
        str = MD5FileUtil.a(paramString1);
        if ((str == null) || (str.equals(paramString2))) {
          break label250;
        }
        QLog.e("ApolloManager", 1, "md5 not match!");
        paramString1.delete();
      }
      catch (Exception paramString2)
      {
        QLog.e("ApolloManager", 1, "[patchGameRes] Exception:", paramString2);
        if (!paramString1.exists()) {
          break;
        }
        paramString1.delete();
        return false;
      }
      finally
      {
        if (!((File)localObject2).exists()) {
          break label397;
        }
        ((File)localObject2).delete();
        if (!((File)localObject1).exists()) {
          break label409;
        }
        ((File)localObject1).delete();
      }
      return false;
      QLog.i("ApolloManager", 1, "patch files succeed.");
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      if (((File)localObject1).exists()) {
        ((File)localObject1).delete();
      }
      return true;
      QLog.e("ApolloManager", 1, "patch game res error.");
      if (paramString1.exists()) {
        paramString1.delete();
      }
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
    } while (!((File)localObject1).exists());
    label286:
    ((File)localObject1).delete();
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    if (g) {
      return h;
    }
    if (Build.VERSION.SDK_INT >= 14) {}
    for (boolean bool = true;; bool = false)
    {
      h = bool;
      if (h) {
        break;
      }
      g = true;
      return h;
    }
    if (paramContext != null)
    {
      h = c(paramContext);
      g = true;
    }
    return h;
  }
  
  public static int c(String paramString)
  {
    int i1 = 0;
    int n;
    if (ApolloConfigUtils.b == null)
    {
      n = i1;
      if (QLog.isColorLevel())
      {
        QLog.d("ApolloManager", 2, "queryApolloSwitchSet key:" + paramString + " sSwitchSet = null");
        n = i1;
      }
    }
    do
    {
      do
      {
        return n;
        if (!"gameSwitch".equals(paramString)) {
          break;
        }
        n = i1;
      } while (!j);
      i1 = ApolloConfigUtils.b.optInt(paramString);
      n = i1;
    } while (i1 != 2);
    return jdField_d_of_type_Int;
    return ApolloConfigUtils.b.optInt(paramString);
  }
  
  public static void c(int paramInt)
  {
    QLog.i("ApolloManager", 1, "setsGameOidbStatus:" + paramInt);
    jdField_d_of_type_Int = paramInt >> 3 & 0x1;
  }
  
  private static boolean c(Context paramContext)
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
          int n = paramContext.reqGlEsVersion;
          if (n >= 131072) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
          if (!QLog.isColorLevel()) {}
        }
      }
      catch (Throwable paramContext) {}
    }
    QLog.e("ApolloManager", 2, "isOpenglSupport:" + paramContext.getMessage());
    return false;
  }
  
  public static boolean d()
  {
    if (ApolloConfigUtils.b == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "queryApolloSwitchSet sSwitchSet = null");
      }
    }
    do
    {
      do
      {
        return false;
        if (!ApolloConfigUtils.b.has("autoOpenBox")) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, new Object[] { "openBoxByH5 autoOpenBox:", Integer.valueOf(ApolloConfigUtils.b.optInt("autoOpenBox")) });
        }
      } while (ApolloConfigUtils.b.optInt("autoOpenBox") != 0);
      return true;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloManager", 2, "openBoxByH5 not autoOpenBox");
    return false;
  }
  
  private void e(int paramInt)
  {
    String str = "action_red_tab_update_" + paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).edit().putLong(str, NetConnInfoCenter.getServerTimeMillis()).commit();
  }
  
  public static boolean e()
  {
    return c("eggSwitch") == 1;
  }
  
  private static void i()
  {
    ykl localykl = new ykl();
    if (!jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)) {
      ThreadManager.post(localykl, 8, null, false);
    }
  }
  
  /* Error */
  private void j()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +13 -> 18
    //   8: ldc_w 325
    //   11: iconst_2
    //   12: ldc_w 1449
    //   15: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aload_0
    //   19: getfield 1451	com/tencent/mobileqq/apollo/ApolloManager:jdField_k_of_type_Boolean	Z
    //   22: ifne +548 -> 570
    //   25: aload_0
    //   26: getfield 1451	com/tencent/mobileqq/apollo/ApolloManager:jdField_k_of_type_Boolean	Z
    //   29: ifeq +4 -> 33
    //   32: return
    //   33: aload_0
    //   34: getfield 193	com/tencent/mobileqq/apollo/ApolloManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: ifnull +291 -> 328
    //   40: aload_0
    //   41: getfield 193	com/tencent/mobileqq/apollo/ApolloManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   44: invokevirtual 350	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   47: astore 5
    //   49: invokestatic 827	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   52: lstore_3
    //   53: aload_0
    //   54: getfield 210	com/tencent/mobileqq/apollo/ApolloManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   57: ldc 116
    //   59: invokevirtual 1454	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   62: checkcast 69	java/util/ArrayList
    //   65: astore 6
    //   67: aload 6
    //   69: ifnull +496 -> 565
    //   72: aload 6
    //   74: invokevirtual 1455	java/util/ArrayList:size	()I
    //   77: istore_1
    //   78: aload 6
    //   80: invokevirtual 1456	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   83: astore 7
    //   85: aload 7
    //   87: invokeinterface 580 1 0
    //   92: ifeq +252 -> 344
    //   95: aload 7
    //   97: invokeinterface 584 1 0
    //   102: checkcast 1458	com/tencent/mobileqq/persistence/Entity
    //   105: checkcast 116	com/tencent/mobileqq/data/ApolloBaseInfo
    //   108: astore 8
    //   110: aload 8
    //   112: ifnull -27 -> 85
    //   115: aload 8
    //   117: getfield 1461	com/tencent/mobileqq/data/ApolloBaseInfo:uin	Ljava/lang/String;
    //   120: invokestatic 346	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: ifne -38 -> 85
    //   126: lload_3
    //   127: aload 8
    //   129: getfield 822	com/tencent/mobileqq/data/ApolloBaseInfo:apolloSignValidTS	J
    //   132: lcmp
    //   133: ifle +19 -> 152
    //   136: aload 8
    //   138: aload 8
    //   140: getfield 822	com/tencent/mobileqq/data/ApolloBaseInfo:apolloSignValidTS	J
    //   143: putfield 830	com/tencent/mobileqq/data/ApolloBaseInfo:apolloLocalSignTs	J
    //   146: aload 8
    //   148: aconst_null
    //   149: putfield 1464	com/tencent/mobileqq/data/ApolloBaseInfo:apolloSignStr	Ljava/lang/String;
    //   152: aload_0
    //   153: getfield 125	com/tencent/mobileqq/apollo/ApolloManager:jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   156: astore 6
    //   158: aload 6
    //   160: monitorenter
    //   161: aload_0
    //   162: getfield 125	com/tencent/mobileqq/apollo/ApolloManager:jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   165: aload 8
    //   167: getfield 1461	com/tencent/mobileqq/data/ApolloBaseInfo:uin	Ljava/lang/String;
    //   170: aload 8
    //   172: invokevirtual 1469	com/tencent/commonsdk/cache/QQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: pop
    //   176: aload 6
    //   178: monitorexit
    //   179: aload 8
    //   181: getfield 1461	com/tencent/mobileqq/data/ApolloBaseInfo:uin	Ljava/lang/String;
    //   184: aload 5
    //   186: invokevirtual 1310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   189: ifeq -104 -> 85
    //   192: aload_0
    //   193: aload 8
    //   195: putfield 356	com/tencent/mobileqq/apollo/ApolloManager:jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo	Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   198: aload_0
    //   199: getfield 356	com/tencent/mobileqq/apollo/ApolloManager:jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo	Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   202: getfield 1472	com/tencent/mobileqq/data/ApolloBaseInfo:apolloAISwitch	I
    //   205: invokestatic 1474	com/tencent/mobileqq/apollo/ApolloManager:c	(I)V
    //   208: goto -123 -> 85
    //   211: astore 5
    //   213: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq +15 -> 231
    //   219: ldc_w 325
    //   222: iconst_2
    //   223: ldc_w 1476
    //   226: aload 5
    //   228: invokestatic 546	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   231: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   234: ifeq -202 -> 32
    //   237: aload_0
    //   238: getfield 193	com/tencent/mobileqq/apollo/ApolloManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   241: ifnull -209 -> 32
    //   244: aload_0
    //   245: getfield 125	com/tencent/mobileqq/apollo/ApolloManager:jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   248: aload_0
    //   249: getfield 193	com/tencent/mobileqq/apollo/ApolloManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   252: invokevirtual 350	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   255: invokevirtual 1477	com/tencent/commonsdk/cache/QQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   258: checkcast 116	com/tencent/mobileqq/data/ApolloBaseInfo
    //   261: astore 5
    //   263: aload 5
    //   265: ifnull +9 -> 274
    //   268: aload 5
    //   270: getfield 359	com/tencent/mobileqq/data/ApolloBaseInfo:apolloStatus	I
    //   273: istore_2
    //   274: ldc_w 325
    //   277: iconst_2
    //   278: new 297	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   285: ldc_w 1479
    //   288: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload_0
    //   292: getfield 125	com/tencent/mobileqq/apollo/ApolloManager:jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   295: invokevirtual 1480	com/tencent/commonsdk/cache/QQLruCache:size	()I
    //   298: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   301: ldc_w 1482
    //   304: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: iload_1
    //   308: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   311: ldc_w 1484
    //   314: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: iload_2
    //   318: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   321: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   327: return
    //   328: ldc_w 785
    //   331: astore 5
    //   333: goto -284 -> 49
    //   336: astore 5
    //   338: aload 6
    //   340: monitorexit
    //   341: aload 5
    //   343: athrow
    //   344: aload_0
    //   345: getfield 210	com/tencent/mobileqq/apollo/ApolloManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   348: ldc_w 588
    //   351: invokevirtual 1454	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   354: checkcast 69	java/util/ArrayList
    //   357: astore 6
    //   359: aload 6
    //   361: ifnull +124 -> 485
    //   364: aload_0
    //   365: getfield 102	com/tencent/mobileqq/apollo/ApolloManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   368: astore 5
    //   370: aload 5
    //   372: monitorenter
    //   373: aload_0
    //   374: getfield 105	com/tencent/mobileqq/apollo/ApolloManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   377: invokeinterface 1485 1 0
    //   382: invokestatic 1231	java/lang/System:currentTimeMillis	()J
    //   385: ldc2_w 1199
    //   388: ldiv
    //   389: lstore_3
    //   390: aload 6
    //   392: invokeinterface 575 1 0
    //   397: astore 6
    //   399: aload 6
    //   401: invokeinterface 580 1 0
    //   406: ifeq +76 -> 482
    //   409: aload 6
    //   411: invokeinterface 584 1 0
    //   416: checkcast 588	com/tencent/mobileqq/DrawerPushItem
    //   419: astore 7
    //   421: aload 7
    //   423: getfield 632	com/tencent/mobileqq/DrawerPushItem:end_ts	I
    //   426: i2l
    //   427: lload_3
    //   428: lcmp
    //   429: ifle +40 -> 469
    //   432: aload_0
    //   433: aload 7
    //   435: invokevirtual 697	com/tencent/mobileqq/apollo/ApolloManager:a	(Lcom/tencent/mobileqq/DrawerPushItem;)Z
    //   438: ifne +31 -> 469
    //   441: aload_0
    //   442: getfield 105	com/tencent/mobileqq/apollo/ApolloManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   445: aload 7
    //   447: invokeinterface 479 2 0
    //   452: pop
    //   453: goto -54 -> 399
    //   456: astore 6
    //   458: aload 5
    //   460: monitorexit
    //   461: aload 6
    //   463: athrow
    //   464: astore 5
    //   466: goto -253 -> 213
    //   469: aload_0
    //   470: getfield 210	com/tencent/mobileqq/apollo/ApolloManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   473: aload 7
    //   475: invokevirtual 1488	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   478: pop
    //   479: goto -80 -> 399
    //   482: aload 5
    //   484: monitorexit
    //   485: aload_0
    //   486: getfield 193	com/tencent/mobileqq/apollo/ApolloManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   489: ifnull +61 -> 550
    //   492: aload_0
    //   493: getfield 193	com/tencent/mobileqq/apollo/ApolloManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   496: invokevirtual 350	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   499: astore 5
    //   501: aload_0
    //   502: invokestatic 390	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   505: ldc_w 1490
    //   508: iconst_4
    //   509: invokevirtual 404	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   512: new 297	java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   519: aload 5
    //   521: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: ldc_w 1492
    //   527: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: ldc_w 1494
    //   533: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: ldc_w 785
    //   542: invokeinterface 1496 3 0
    //   547: putfield 1498	com/tencent/mobileqq/apollo/ApolloManager:l	Ljava/lang/String;
    //   550: aload_0
    //   551: iconst_1
    //   552: putfield 1451	com/tencent/mobileqq/apollo/ApolloManager:jdField_k_of_type_Boolean	Z
    //   555: goto -324 -> 231
    //   558: astore 5
    //   560: iconst_0
    //   561: istore_1
    //   562: goto -349 -> 213
    //   565: iconst_0
    //   566: istore_1
    //   567: goto -223 -> 344
    //   570: iconst_0
    //   571: istore_1
    //   572: goto -341 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	575	0	this	ApolloManager
    //   77	495	1	n	int
    //   1	317	2	i1	int
    //   52	376	3	l1	long
    //   47	138	5	str1	String
    //   211	16	5	localOutOfMemoryError1	OutOfMemoryError
    //   261	71	5	localObject1	Object
    //   336	6	5	localObject2	Object
    //   464	19	5	localOutOfMemoryError2	OutOfMemoryError
    //   499	21	5	str2	String
    //   558	1	5	localOutOfMemoryError3	OutOfMemoryError
    //   456	6	6	localObject5	Object
    //   83	391	7	localObject6	Object
    //   108	86	8	localApolloBaseInfo	ApolloBaseInfo
    // Exception table:
    //   from	to	target	type
    //   78	85	211	java/lang/OutOfMemoryError
    //   85	110	211	java/lang/OutOfMemoryError
    //   115	152	211	java/lang/OutOfMemoryError
    //   152	161	211	java/lang/OutOfMemoryError
    //   179	208	211	java/lang/OutOfMemoryError
    //   341	344	211	java/lang/OutOfMemoryError
    //   161	179	336	finally
    //   338	341	336	finally
    //   373	399	456	finally
    //   399	453	456	finally
    //   458	461	456	finally
    //   469	479	456	finally
    //   482	485	456	finally
    //   344	359	464	java/lang/OutOfMemoryError
    //   364	373	464	java/lang/OutOfMemoryError
    //   461	464	464	java/lang/OutOfMemoryError
    //   485	550	464	java/lang/OutOfMemoryError
    //   550	555	464	java/lang/OutOfMemoryError
    //   49	67	558	java/lang/OutOfMemoryError
    //   72	78	558	java/lang/OutOfMemoryError
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "initApolloPandoraCache begin...");
    }
    try
    {
      ??? = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ApolloPandora.class);
      if (??? != null)
      {
        Iterator localIterator = ((ArrayList)???).iterator();
        while (localIterator.hasNext())
        {
          ApolloPandora localApolloPandora = (ApolloPandora)localIterator.next();
          if ((localApolloPandora != null) && (localApolloPandora.uin != null)) {
            synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
            {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localApolloPandora.uin, localApolloPandora);
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
        QLog.d("ApolloManager", 2, "initApolloPandoraCache end size:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      }
    }
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "[resetStoreUrl] mIsNewStoreUser=", Boolean.valueOf(this.jdField_d_of_type_Boolean) });
    }
    if (this.jdField_d_of_type_Boolean)
    {
      if (!TextUtils.isEmpty(ApolloConstant.Z))
      {
        ApolloConstant.X = ApolloConstant.Z;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, new Object[] { "[resetStoreUrl] sApolloStoreMallUrl=", ApolloConstant.X });
        }
      }
      if (!TextUtils.isEmpty(ApolloConstant.ab))
      {
        ApolloConstant.Y = ApolloConstant.ab;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, new Object[] { "[resetStoreUrl] sApolloStoreInteractUrl=", ApolloConstant.Y });
        }
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return 0;
      if ((ApolloEngine.a()) && (ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (this.e)) {
        return 3;
      }
      if ((ApolloEngine.a()) && (ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        return 1;
      }
    } while (!this.e);
    return 2;
  }
  
  public int a(int paramInt)
  {
    int n = 0;
    for (;;)
    {
      try
      {
        if (this.jdField_k_of_type_JavaLangString == null) {
          return -1;
        }
        JSONArray localJSONArray = new JSONArray(this.jdField_k_of_type_JavaLangString);
        int i1 = localJSONArray.length();
        if (n >= i1) {
          continue;
        }
        JSONObject localJSONObject = localJSONArray.getJSONObject(n);
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
      n += 1;
    }
  }
  
  public int a(String paramString)
  {
    paramString = b(paramString);
    if ((paramString == null) || (paramString.apolloVipLevel < 1)) {
      return 1;
    }
    return paramString.apolloVipLevel;
  }
  
  public long a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject == null) {}
    for (;;)
    {
      return 0L;
      JSONObject localJSONObject = null;
      if (paramInt1 == 3) {
        localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject("action_version");
      }
      while (localJSONObject != null)
      {
        return localJSONObject.optLong(String.valueOf(paramInt2));
        if (paramInt1 == 2) {
          localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject("dress_version");
        } else if (paramInt1 == 1) {
          localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject("role_version");
        }
      }
    }
  }
  
  public DrawerPushItem a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        return null;
      }
      Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
      long l1 = System.currentTimeMillis() / 1000L;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        DrawerPushItem localDrawerPushItem = (DrawerPushItem)localIterator.next();
        if ((localDrawerPushItem.msg_type == paramInt) && (localDrawerPushItem.start_ts < l1) && (localDrawerPushItem.end_ts > l1) && (localDrawerPushItem.show_sum < localDrawerPushItem.show_counts)) {
          return localDrawerPushItem;
        }
      }
    }
    return null;
  }
  
  public DrawerPushItem a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        return null;
      }
      Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
      long l1 = System.currentTimeMillis() / 1000L;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        DrawerPushItem localDrawerPushItem = (DrawerPushItem)localIterator.next();
        if ((localDrawerPushItem.msg_id.equals(paramString)) && (localDrawerPushItem.start_ts < l1) && (localDrawerPushItem.end_ts > l1)) {
          return localDrawerPushItem;
        }
      }
    }
    return null;
  }
  
  public DrawerPushItem a(String paramString1, String paramString2, JSONObject paramJSONObject, boolean paramBoolean, int paramInt)
  {
    if ((paramJSONObject == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
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
        int n = paramJSONObject.optInt("time");
        SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
        if (n == localSharedPreferences.getInt(paramString1, 0))
        {
          paramJSONObject = a(paramString2);
          paramString1 = paramJSONObject;
          if (paramBoolean) {
            break;
          }
          if (paramJSONObject == null) {
            break label534;
          }
          b(paramString2);
          break label534;
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
          localDrawerPushItem.send_time = n;
          localDrawerPushItem.action_id = paramJSONObject.optInt("actionId");
          localDrawerPushItem.color = paramJSONObject.optInt("fontColor");
          localDrawerPushItem.content = paramJSONObject.optString("bubbleText");
          localDrawerPushItem.bubble_res_id = paramJSONObject.optInt("bubbleID");
          localDrawerPushItem.icon_url = paramJSONObject.optString("iconUrl");
          localDrawerPushItem.life_Time = paramJSONObject.optInt("tipsDuration");
          paramInt = paramJSONObject.optInt("type");
          if (paramInt != 0) {
            break label496;
          }
          localDrawerPushItem.scheme = paramJSONObject.optString("scheme");
          localDrawerPushItem.show_counts = paramJSONObject.optInt("showCounts");
          long l1 = NetConnInfoCenter.getServerTime();
          if ((paramBoolean) && (localDrawerPushItem.start_ts < l1) && (localDrawerPushItem.end_ts > l1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, new Object[] { "parseShopRedTouchManager addPushItem:", localDrawerPushItem.toString() });
            }
            c(localDrawerPushItem);
            localSharedPreferences.edit().putInt(paramString1, n).commit();
            return localDrawerPushItem;
          }
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("ApolloManager", 2, "parseApolloRedTouchContent Exception:", paramString1);
      }
      return null;
      label496:
      if (paramInt == 1) {
        localDrawerPushItem.ext_url = ApolloConstant.J;
      } else if (paramInt == 2) {
        localDrawerPushItem.ext_url = paramJSONObject.optString("url");
      }
    }
    label534:
    return null;
  }
  
  public ApolloGameNormalStartHandler a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloGameNormalStartHandler;
  }
  
  public ApolloPanelManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager;
  }
  
  public ApolloResDownloader.OnApolloDownLoadListener a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloResDownloader$OnApolloDownLoadListener == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloResDownloader$OnApolloDownLoadListener = new yka(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloResDownloader$OnApolloDownLoadListener;
  }
  
  public ApolloGameHotChatController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameHotChatController == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameHotChatController = new ApolloGameHotChatController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameHotChatController;
  }
  
  public QQAppInterface a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public ApolloActionData a(QQAppInterface paramQQAppInterface, String paramString, int... paramVarArgs)
  {
    if ((paramQQAppInterface == null) || (paramString == null) || (paramVarArgs == null)) {
      return null;
    }
    Object localObject = b(paramString);
    if (localObject == null) {
      return null;
    }
    HashSet localHashSet = new HashSet();
    int i1 = paramVarArgs.length;
    int n = 0;
    if (n < i1)
    {
      int i2 = paramVarArgs[n];
      if ((i2 == 4) && (!((ApolloBaseInfo)localObject).hasPet)) {}
      for (;;)
      {
        n += 1;
        break;
        localHashSet.add(Integer.valueOf(i2));
      }
    }
    for (;;)
    {
      try
      {
        paramString = a(paramQQAppInterface, paramString);
        if (paramString == null) {
          return null;
        }
        paramString = new JSONArray(paramString);
        i1 = paramString.length();
        paramVarArgs = new ArrayList();
        n = 0;
        if (n < i1)
        {
          localObject = paramString.getJSONObject(n);
          if ((localObject == null) || (!localHashSet.contains(Integer.valueOf(((JSONObject)localObject).getInt("type"))))) {
            break label439;
          }
          paramVarArgs.add(localObject);
          break label439;
        }
        if (paramVarArgs.size() != 0)
        {
          paramString = (JSONObject)paramVarArgs.get(ApolloUtil.d(paramVarArgs.size()));
          if (paramString != null)
          {
            i1 = paramString.getInt("id");
            n = paramString.getInt("type");
            if (i1 <= 0) {
              break label437;
            }
            if (ApolloUtil.a(i1, 0))
            {
              paramQQAppInterface = new ApolloActionData();
              paramQQAppInterface.actionId = i1;
              if (n == 4) {
                paramQQAppInterface.actionType = 7;
              }
              if (QLog.isColorLevel()) {
                QLog.d("ApolloManager", 2, new Object[] { "getRandomAppearAction actionId:", Integer.valueOf(i1), ",type:", Integer.valueOf(n) });
              }
              return paramQQAppInterface;
            }
          }
          else
          {
            QLog.e("ApolloManager", 1, "[getRandomAppearAction] found empty json obj");
            break label448;
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label448;
          }
          QLog.d("ApolloManager", 2, "[getRandomAppearAction]found empty json arr ");
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("ApolloManager", 1, "[getRandomAppearAction]:" + paramQQAppInterface);
        return null;
      }
      paramString = new ApolloActionData();
      paramString.actionId = i1;
      paramVarArgs = ApolloUtil.a(paramString, 5);
      ApolloResDownloader.a(paramQQAppInterface, ApolloUtil.a(paramString, 4), paramVarArgs);
      QLog.w("ApolloManager", 2, "getRandomAppearAction action resource not ready,actionId:" + i1);
      label437:
      return null;
      label439:
      n += 1;
      continue;
      label448:
      n = 0;
      i1 = 0;
    }
  }
  
  public ApolloBaseInfo a(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return null;
    }
    if ((paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (this.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo;
    }
    if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.containsKey(paramString)) {
      return (ApolloBaseInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
    }
    ThreadManager.getSubThreadHandler().post(new ykf(this, paramString));
    return null;
  }
  
  public ApolloPandora a(String paramString, boolean paramBoolean)
  {
    ??? = null;
    if (TextUtils.isEmpty(paramString)) {}
    ApolloPandora localApolloPandora;
    do
    {
      do
      {
        return ???;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(paramString)) {
          return (ApolloPandora)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        }
      } while (!paramBoolean);
      localApolloPandora = (ApolloPandora)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ApolloPandora.class, paramString);
      ??? = localApolloPandora;
    } while (localApolloPandora == null);
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localApolloPandora);
      return localApolloPandora;
    }
  }
  
  public DownloaderInterface a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    return ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1);
  }
  
  public File a(ApolloActionData paramApolloActionData, int paramInt)
  {
    if (paramApolloActionData == null) {
      return null;
    }
    String str = "";
    if ((paramInt & 0x1) == 1) {
      str = ApolloUtil.a(paramApolloActionData, 0);
    }
    for (;;)
    {
      return new File(str);
      if ((paramInt & 0x2) == 2) {
        str = ApolloUtil.a(paramApolloActionData, 2);
      }
    }
  }
  
  public File a(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {
      return null;
    }
    return new File(ApolloUtil.a(paramApolloActionPackage));
  }
  
  public String a(int paramInt)
  {
    Object localObject2;
    if (!new File(ApolloUtil.a(paramInt)).exists())
    {
      QLog.i("ApolloManager", 1, "[getApolloGameLocalVersion], errInfo->game main.lua file not exists, gameId:" + paramInt);
      localObject2 = "0.0";
      return localObject2;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return "0.0";
    }
    Object localObject1 = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
    if (((ApolloDaoManager)localObject1).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) {
      ((ApolloDaoManager)localObject1).a();
    }
    for (;;)
    {
      localObject2 = (String)((ApolloDaoManager)localObject1).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).getString("apollo_game_ver_" + paramInt, "0.0");
        QLog.i("ApolloManager", 1, "read game ver from sp");
      }
      localObject2 = localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloManager", 2, "gameVer:" + (String)localObject1 + ",id:" + paramInt);
      return localObject1;
      if (TextUtils.isEmpty((CharSequence)((ApolloDaoManager)localObject1).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt)))) {
        ((ApolloDaoManager)localObject1).a(paramInt);
      }
    }
  }
  
  public String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ApolloBaseInfo localApolloBaseInfo = b(paramString);
    if (localApolloBaseInfo == null) {
      return null;
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap.get(paramString) == null) {}
      for (long l1 = 0L; (localApolloBaseInfo.appearAction == null) && (NetConnInfoCenter.getServerTime() - l1 > 180L); l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get(paramString)).longValue())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, new Object[] { "getApolloAppearAction request appear action uin:", paramString.substring(0, 4) });
        }
        ((VasExtensionHandler)paramQQAppInterface.a(71)).a(new long[] { Long.parseLong(paramString) });
        this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(NetConnInfoCenter.getServerTime()));
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
  
  public String a(String paramString)
  {
    try
    {
      int n = b(paramString).getApolloPetDress().jdField_a_of_type_Int;
      return String.valueOf(n);
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public WeakReference a()
  {
    return this.jdField_c_of_type_JavaLangRefWeakReference;
  }
  
  public void a(int paramInt)
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
      ((List)localObject).add("http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipList_apollo_data/tab_list_android_v730.json");
      localArrayList.add(ApolloUtil.jdField_a_of_type_JavaLangString);
      localHashMap.put("http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipList_apollo_data/tab_list_android_v730.json", new File(ApolloUtil.jdField_a_of_type_JavaLangString));
      localBundle.putInt("http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipList_apollo_data/tab_list_android_v730.json", 1);
    }
    if ((paramInt & 0x2) == 2)
    {
      String str = a();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "gameJson:", str });
      }
      ((List)localObject).add(str);
      localArrayList.add(ApolloUtil.jdField_b_of_type_JavaLangString);
      localHashMap.put(str, new File(ApolloUtil.jdField_b_of_type_JavaLangString));
      localBundle.putInt(str, 2);
    }
    if (a() != null)
    {
      localObject = new DownloadTask((List)localObject, localHashMap, "apollo_json_task" + System.currentTimeMillis());
      ((DownloadTask)localObject).n = false;
      ((DownloadTask)localObject).h = false;
      ((DownloadTask)localObject).l = true;
      ((DownloadTask)localObject).q = false;
      ((DownloadTask)localObject).f = "apollo_res";
      ((DownloadTask)localObject).p = true;
      ((DownloadTask)localObject).o = true;
      a().a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
      if ((paramInt & 0x1) == 1) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "json_download_begin", 0, 0, new String[0]);
      }
      if ((paramInt & 0x2) == 2) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "json_download_begin", 1, 0, new String[0]);
      }
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if ((!ApolloUtil.a(paramInt1, paramInt2)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ApolloPet", 2, "start download action:" + paramInt1);
      }
      Object localObject = new ApolloActionData();
      ((ApolloActionData)localObject).actionId = paramInt1;
      String str = ApolloUtil.a((ApolloActionData)localObject, 5);
      localObject = ApolloUtil.a((ApolloActionData)localObject, 4);
      ApolloResDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, str);
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    long l2 = 0L;
    if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
    }
    if (paramInt1 == 3) {}
    Object localObject2;
    for (String str = "action_version";; localObject2 = null) {
      for (;;)
      {
        JSONObject localJSONObject1;
        if (str != null)
        {
          ??? = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject(str);
          localJSONObject1 = ???;
          if (??? == null) {
            localJSONObject1 = new JSONObject();
          }
        }
        synchronized (this.jdField_a_of_type_OrgJsonJSONObject)
        {
          try
          {
            l1 = localJSONObject1.optLong(String.valueOf(paramInt2), 0L);
            if (l1 < paramLong)
            {
              l2 = l1;
              localJSONObject1.put(String.valueOf(paramInt2), paramLong);
              l2 = l1;
              this.jdField_a_of_type_OrgJsonJSONObject.put(str, localJSONObject1);
              n = 1;
              if (n != 0)
              {
                ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
                ThreadManager.getFileThreadHandler().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 6000L);
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloManager", 2, "saveLocalTS id: " + paramInt2 + ", old TS: " + l1 + ", new TS: " + paramLong + ", type: " + paramInt1);
                }
              }
              return;
              if (paramInt1 == 2)
              {
                str = "dress_version";
                continue;
              }
              if (paramInt1 != 1) {
                break;
              }
              str = "role_version";
              continue;
            }
            l2 = l1;
            if (l1 > paramLong)
            {
              l2 = l1;
              QLog.e("ApolloManager", 2, "saveLocalTS err id: " + paramInt2 + ", old TS: " + l1 + ", new TS: " + paramLong + ", type: " + paramInt1);
              l2 = l1;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              long l1;
              int n;
              QLog.d("ApolloManager", 2, localException.getMessage());
            }
          }
          n = 0;
          l1 = l2;
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    ApolloDaoManager localApolloDaoManager = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
    if (localApolloDaoManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      localApolloDaoManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).edit().putString("apollo_game_ver_" + paramInt, paramString).commit();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ThreadManager.post(new ykq(this, paramBoolean, paramInt), 5, null, false);
  }
  
  public void a(Context paramContext)
  {
    Object localObject = new File(ApolloConstant.jdField_a_of_type_JavaLangString + "/apolloConfig.json");
    if ((!((File)localObject).exists()) || (((File)localObject).length() <= 0L))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        SharedPreUtils.p(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
      }
      QLog.i("ApolloManager", 1, "apollo config file not exists");
    }
    label180:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (ApolloConfigUtils.jdField_a_of_type_OrgJsonJSONObject != null) {
              break label180;
            }
            localObject = FileUtils.a(ApolloConstant.jdField_a_of_type_JavaLangString + "/apolloConfig.json");
            if (localObject != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("ApolloManager", 2, "read apollo config file failed");
          return;
          localObject = new String((byte[])localObject);
          ApolloConfigUtils.a((String)localObject, paramContext);
          if ((localObject == null) && (QLog.isColorLevel())) {
            QLog.e("ApolloManager", 1, "apollo config json is null" + (String)localObject);
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
        if (ApolloConfigUtils.c == null)
        {
          paramContext = FileUtils.a(ApolloConstant.jdField_a_of_type_JavaLangString + "/apolloStepConfig" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + ".json");
          if (paramContext != null)
          {
            paramContext = new String(paramContext);
            ApolloConfigUtils.a(paramContext);
            if ((paramContext == null) && (QLog.isColorLevel())) {
              QLog.e("ApolloManager", 2, "apollo stepconfig json is null" + paramContext);
            }
          }
        }
        paramContext = FileUtils.a(ApolloConstant.jdField_a_of_type_JavaLangString + "/apolloWeatherConfig" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + ".json");
      } while (paramContext == null);
      paramContext = new String(paramContext);
      ApolloConfigUtils.b(paramContext);
    } while ((paramContext != null) || (!QLog.isColorLevel()));
    QLog.e("ApolloManager", 2, "apollo weaconfig json is null" + paramContext);
  }
  
  public void a(DrawerPushItem paramDrawerPushItem)
  {
    ThreadManager.post(new ykg(this, paramDrawerPushItem), 5, null, true);
  }
  
  public void a(DrawerPushItem paramDrawerPushItem, QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if ((paramDrawerPushItem == null) || (paramQQAppInterface == null) || (paramContext == null)) {}
    do
    {
      Intent localIntent;
      do
      {
        return;
        if (TextUtils.isEmpty(paramDrawerPushItem.scheme)) {
          break;
        }
        localIntent = new Intent();
        if (paramDrawerPushItem.scheme.trim().equals("mall"))
        {
          ApolloUtil.a(paramContext, null, paramString, ApolloConstant.X, null);
          return;
        }
      } while (!paramDrawerPushItem.scheme.trim().equals("interact"));
      localIntent.putExtra("extra_key_url_append", "&tab=interactive&suin=" + paramQQAppInterface.getCurrentAccountUin());
      ApolloUtil.a(paramContext, localIntent, paramString, ApolloConstant.Y, null);
      return;
    } while (TextUtils.isEmpty(paramDrawerPushItem.ext_url));
    paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
    paramQQAppInterface.putExtra("url", paramDrawerPushItem.ext_url);
    paramQQAppInterface.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramContext.startActivity(paramQQAppInterface);
  }
  
  public void a(DrawerPushItem paramDrawerPushItem, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!a(paramDrawerPushItem)))
      {
        this.jdField_a_of_type_JavaUtilList.add(paramDrawerPushItem);
        if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (paramBoolean)) {
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramDrawerPushItem);
        }
        if (QLog.isColorLevel()) {
          QLog.i("ApolloPushBubble", 2, "add red push item:" + paramDrawerPushItem);
        }
      }
      return;
    }
  }
  
  public void a(SessionInfo paramSessionInfo, Context paramContext)
  {
    if ((paramSessionInfo.jdField_a_of_type_Int != 0) && (paramSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))) {}
    do
    {
      do
      {
        return;
        jdField_a_of_type_JavaUtilArrayList.clear();
      } while ((paramSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(paramSessionInfo.jdField_a_of_type_JavaLangString) != null));
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (1 == b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloManager", 2, "doAfterOpenAIO: apollo function is not opened status: " + b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
    return;
    ThreadManager.getSubThreadHandler().post(new ykr(this, paramSessionInfo));
  }
  
  public void a(ApolloManager.IDrawerGameBoxStatus paramIDrawerGameBoxStatus)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramIDrawerGameBoxStatus);
  }
  
  public void a(IApolloAIListener paramIApolloAIListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIListener = paramIApolloAIListener;
  }
  
  public void a(IResDownloadListener paramIResDownloadListener)
  {
    if (paramIResDownloadListener != null) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager.a(paramIResDownloadListener);
      }
      return;
    }
    finally
    {
      paramIResDownloadListener = finally;
      throw paramIResDownloadListener;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "[handleApolloNewStoreConfig] app=", paramQQAppInterface, ", config=", paramConfig });
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      QLog.e("ApolloManager", 1, "[handleApolloNewStoreConfig] param error");
    }
    label375:
    for (;;)
    {
      return;
      int n = SharedPreUtils.a(paramQQAppInterface.getApp(), "apollo_new_store_config_version", paramString);
      if (paramConfig != null)
      {
        int i1 = paramConfig.version.get();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, new Object[] { "[handleApolloNewStoreConfig] reqVersion=", Integer.valueOf(n), ", version=", Integer.valueOf(i1) });
        }
        if (n != i1)
        {
          paramConfig = ConfigServlet.a(paramConfig);
          if ((paramConfig != null) && (paramConfig.size() > 0))
          {
            paramConfig = paramConfig.iterator();
            while (paramConfig.hasNext())
            {
              String str = (String)paramConfig.next();
              if (QLog.isColorLevel()) {
                QLog.d("ApolloManager", 2, new Object[] { "[handleApolloNewStoreConfig] configStr=", str });
              }
            }
            this.jdField_d_of_type_Boolean = true;
            QLog.d("ApolloManager", 1, new Object[] { "[handleApolloNewStoreConfig] mIsNewStoreUser=", Boolean.valueOf(this.jdField_d_of_type_Boolean) });
            BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4).edit().putBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + "sp_key_new_store_whitelist", this.jdField_d_of_type_Boolean).commit();
            SharedPreUtils.a(paramQQAppInterface.getApp(), "apollo_new_store_config_version", paramString, i1);
            l();
          }
        }
      }
      for (n = 1;; n = 0)
      {
        if (n != 0) {
          break label375;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "[handleApolloNewStoreConfig] initLocalNewStoreConfig");
        }
        h();
        return;
        QLog.w("ApolloManager", 1, "[handleApolloNewStoreConfig] config list null");
        this.jdField_d_of_type_Boolean = false;
        break;
      }
    }
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    if ((paramApolloActionData == null) && (!FileUtils.a(ApolloUtil.a(paramApolloActionData, 7)))) {}
    while ((!a(FileUtils.a(new File(ApolloUtil.a(paramApolloActionData, 7))), paramApolloActionData)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154)).a(paramApolloActionData);
  }
  
  public void a(ApolloActionData paramApolloActionData, Bundle paramBundle)
  {
    int n = paramBundle.getInt("way");
    if (n == 1) {
      paramApolloActionData.feeType = 6;
    }
    while (n == 6)
    {
      paramApolloActionData.limitFree = 1;
      paramApolloActionData.limitStart = paramBundle.getLong("beginTs");
      paramApolloActionData.limitEnd = paramBundle.getLong("endts");
      return;
      if (n == 2) {
        paramApolloActionData.feeType = 7;
      } else if (n == 4) {
        paramApolloActionData.feeType = 2;
      }
    }
    paramApolloActionData.limitFree = 0;
    paramApolloActionData.obtainedTime = paramBundle.getLong("beginTs");
  }
  
  public void a(ApolloBaseInfo paramApolloBaseInfo)
  {
    if ((paramApolloBaseInfo == null) || (TextUtils.isEmpty(paramApolloBaseInfo.uin))) {}
    for (;;)
    {
      return;
      if (paramApolloBaseInfo.uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        this.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo = paramApolloBaseInfo;
      }
      synchronized (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache)
      {
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramApolloBaseInfo.uin, paramApolloBaseInfo);
        a(paramApolloBaseInfo);
        if ((!QLog.isColorLevel()) || (!paramApolloBaseInfo.uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))) {
          continue;
        }
        QLog.d("ApolloManager", 2, "save apollo info vip status: " + paramApolloBaseInfo.apolloVipFlag + ", vip lev: " + paramApolloBaseInfo.apolloVipFlag + ", apollo status: " + paramApolloBaseInfo.apolloStatus + ", apollo local TS: " + paramApolloBaseInfo.apolloLocalTS + ", apollo svr TS:" + paramApolloBaseInfo.apolloServerTS + ", apollo upt TS:" + paramApolloBaseInfo.apolloUpdateTime + ", apollo AISwitch: " + paramApolloBaseInfo.apolloAISwitch);
        return;
      }
    }
  }
  
  public void a(ApolloPandora paramApolloPandora)
  {
    if ((paramApolloPandora == null) || (TextUtils.isEmpty(paramApolloPandora.uin))) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramApolloPandora.uin, paramApolloPandora);
      a(paramApolloPandora);
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.executeOnSubThread(new yki(this, paramString));
  }
  
  public void a(String paramString, int paramInt)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = jdField_b_of_type_Int;
    localMessage.arg1 = paramInt;
    localMessage.obj = paramString;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(WeakReference paramWeakReference)
  {
    this.jdField_c_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ykb(this, paramList));
  }
  
  public void a(List paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Bundle localBundle;
    ArrayList localArrayList;
    do
    {
      return;
      localBundle = new Bundle();
      localArrayList = new ArrayList();
      HashMap localHashMap = new HashMap();
      a(localArrayList, localHashMap, paramList, localBundle);
      paramList = new DownloadTask(localArrayList, localHashMap, paramString);
      paramList.l = true;
      paramList.f = "apollo_res";
      paramList.n = false;
      paramList.q = false;
      paramList.p = true;
      paramList.o = true;
    } while ((localArrayList.size() == 0) || (a() == null));
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_download_begin", 0, 0, new String[0]);
    a().a(paramList, this.jdField_b_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
  }
  
  public void a(List paramList1, Map paramMap, List paramList2, Bundle paramBundle)
  {
    if ((paramList2 == null) || (paramList2.size() <= 0) || (paramList1 == null) || (paramMap == null)) {
      return;
    }
    int n = 0;
    label25:
    ApolloActionData localApolloActionData;
    String str1;
    Object localObject;
    String str2;
    String str3;
    if (n < paramList2.size())
    {
      localApolloActionData = (ApolloActionData)paramList2.get(n);
      str1 = ApolloUtil.a(localApolloActionData, 1);
      localObject = ApolloUtil.a(localApolloActionData, 0);
      str2 = ApolloUtil.a(localApolloActionData, 5);
      str3 = ApolloUtil.a(localApolloActionData, 4);
      if (!FileUtil.a((String)localObject)) {
        break label216;
      }
      localObject = new DownloadTask(str1, new File((String)localObject));
      Bundle localBundle = new Bundle();
      localBundle.putSerializable(str1, localApolloActionData);
      ((DownloadTask)localObject).c = str1;
      ((DownloadTask)localObject).a(localBundle);
      this.jdField_b_of_type_ComTencentMobileqqVipDownloadListener.onDoneFile((DownloadTask)localObject);
    }
    for (;;)
    {
      if (!ApolloUtil.a(localApolloActionData.actionId, localApolloActionData.personNum))
      {
        paramList1.add(str2);
        paramMap.put(str2, new File(str3));
        if (paramBundle != null) {
          paramBundle.putSerializable(str2, localApolloActionData);
        }
      }
      n += 1;
      break label25;
      break;
      label216:
      paramList1.add(str1);
      paramMap.put(str1, new File((String)localObject));
      if (paramBundle != null) {
        paramBundle.putSerializable(str1, localApolloActionData);
      }
    }
  }
  
  public void a(submsgtype0xca.MsgBody paramMsgBody, String paramString)
  {
    if ((paramMsgBody == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    Object localObject1 = paramMsgBody.rpt_msg_list.get();
    paramMsgBody = new JSONArray();
    int i1 = 0;
    int n = 0;
    int i3 = 0;
    for (;;)
    {
      if (i3 < ((List)localObject1).size())
      {
        submsgtype0xca.MsgContent localMsgContent = (submsgtype0xca.MsgContent)((List)localObject1).get(i3);
        long l1 = localMsgContent.uint64_tag.get();
        Object localObject2;
        if (l1 == 0L)
        {
          i1 += 1;
          int i6;
          try
          {
            i2 = (int)localMsgContent.uint64_msg_type.get();
            localObject2 = localMsgContent.str_content.get();
            int i4 = (int)localMsgContent.uint64_action_id.get();
            int i5 = (int)localMsgContent.uint64_expts.get();
            i6 = (int)localMsgContent.uint64_show_space.get();
            if (this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIListener != null)
            {
              ApolloAIMessage localApolloAIMessage = new ApolloAIMessage();
              localApolloAIMessage.jdField_a_of_type_Int = i2;
              localApolloAIMessage.jdField_a_of_type_Long = l1;
              localApolloAIMessage.jdField_e_of_type_Int = i5;
              if (i2 == 0) {
                localApolloAIMessage.jdField_a_of_type_JavaLangString = ((String)localObject2);
              }
              for (;;)
              {
                localApolloAIMessage.jdField_b_of_type_Int = i4;
                localApolloAIMessage.f = i6;
                localApolloAIMessage.c = localMsgContent.str_region_url.get();
                this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIListener.a(localApolloAIMessage);
                i2 = n;
                n = i1;
                i1 = i2;
                break;
                if (i2 == 1) {
                  localApolloAIMessage.jdField_b_of_type_JavaLangString = ((String)localObject2);
                }
              }
            }
            localObject2 = new JSONObject();
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.e("ApolloManager", 2, "parse AI News Exception e:" + localException.toString());
            }
            i2 = n;
            n = i1;
            i1 = i2;
          }
          ((JSONObject)localObject2).put("msgType", localException.uint64_msg_type.get());
          ((JSONObject)localObject2).put("msgContent", localException.str_content.get());
          ((JSONObject)localObject2).put("actionId", localException.uint64_action_id.get());
          ((JSONObject)localObject2).put("expts", localException.uint64_expts.get());
          ((JSONObject)localObject2).put("url", localException.str_region_url.get());
          ((JSONObject)localObject2).put("showType", i6);
          paramMsgBody.put(localObject2);
          i2 = n;
          n = i1;
          i1 = i2;
        }
        else
        {
          i2 = n;
          if (l1 == 1L)
          {
            n += 1;
            localObject2 = new ApolloAIMessage();
            ((ApolloAIMessage)localObject2).jdField_a_of_type_Long = l1;
            ((ApolloAIMessage)localObject2).jdField_a_of_type_Int = ((int)localException.uint64_msg_type.get());
            if (((ApolloAIMessage)localObject2).jdField_a_of_type_Int != 0) {
              break label619;
            }
            ((ApolloAIMessage)localObject2).jdField_a_of_type_JavaLangString = localException.str_content.get();
          }
          for (;;)
          {
            ((ApolloAIMessage)localObject2).jdField_b_of_type_Int = ((int)localException.uint64_action_id.get());
            ((ApolloAIMessage)localObject2).jdField_e_of_type_JavaLangString = localException.str_error_msg.get();
            ((ApolloAIMessage)localObject2).c = localException.str_region_url.get();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "AIMessage push " + ((ApolloAIMessage)localObject2).toString() + " from:" + paramString);
            }
            i2 = n;
            if (this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIListener != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIListener.a((ApolloAIMessage)localObject2);
              i2 = n;
            }
            n = i1;
            i1 = i2;
            break;
            label619:
            if (((ApolloAIMessage)localObject2).jdField_a_of_type_Int == 1) {
              ((ApolloAIMessage)localObject2).jdField_b_of_type_JavaLangString = localException.str_content.get();
            }
          }
        }
      }
      else
      {
        if ((paramMsgBody != null) && (paramMsgBody.length() > 0))
        {
          localObject1 = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0);
          String str = ((SharedPreferences)localObject1).getString("apollo_ai_news_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "");
          ((SharedPreferences)localObject1).edit().putString("apollo_ai_news_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramMsgBody.toString()).commit();
          ((SharedPreferences)localObject1).edit().putString("sp_key_apollo_ai_flag", "").commit();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, "AI put push topic array:" + paramMsgBody.toString() + " from:" + paramString);
          }
          if (!TextUtils.isEmpty(str)) {
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "pro_disappear", 0, 1, new String[0]);
          }
        }
        if (n > 0) {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "rev_chat", 0, 0, new String[] { n + "" });
        }
        if (i1 <= 0) {
          break;
        }
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "rev_pro", 0, 0, new String[] { i1 + "" });
        return;
      }
      i3 += 1;
      int i2 = i1;
      i1 = n;
      n = i2;
    }
  }
  
  void a(boolean paramBoolean)
  {
    int n = c("gameBoxGrayStatus");
    if (n == 1) {
      this.e = paramBoolean;
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)) {
        ((ApolloManager.IDrawerGameBoxStatus)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a(this.e);
      }
      QLog.d("ApolloManager", 1, "upDateGameBoxUserStatus switch: " + n + ", oidb Status: " + paramBoolean);
      return;
      if (n == 2) {
        this.e = true;
      } else {
        this.e = false;
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "checkApolloPanelJsonCfg begin..." + paramString + ",task:" + paramInt);
    }
    if ((paramBoolean) || (((paramInt & 0x1) == 1) && (!FileUtil.a(ApolloUtil.jdField_a_of_type_JavaLangString))) || (((paramInt & 0x2) == 2) && (!FileUtil.a(ApolloUtil.jdField_b_of_type_JavaLangString))))
    {
      a(paramInt);
      QLog.d("ApolloManager", 1, "checkApolloPanelJsonCfg download json  forceDownload is: " + paramBoolean);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    submsgtype0xdc.MsgBody localMsgBody = new submsgtype0xdc.MsgBody();
    for (;;)
    {
      int n;
      try
      {
        localMsgBody.mergeFrom(paramArrayOfByte);
        if (!localMsgBody.uint32_msg_type.has()) {
          break label227;
        }
        n = localMsgBody.uint32_msg_type.get();
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        QLog.e("ApolloManager", 1, new Object[] { "[decodeApolloBubblePushData], errInfo->", paramArrayOfByte.getMessage() });
        return;
      }
      if (localMsgBody.rpt_msg_list.has())
      {
        paramArrayOfByte = localMsgBody.rpt_msg_list.get();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0)) {
          a(n, paramArrayOfByte);
        }
        QLog.i("ApolloManager", 1, "[decodeApolloBubblePushData], decode complete:" + this.jdField_a_of_type_JavaUtilList.toString());
        return;
      }
      if ((n == 2) && (localMsgBody.rpt_msg_list_0x02.has()))
      {
        paramArrayOfByte = localMsgBody.rpt_msg_list_0x02.get();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0)) {
          a(n, paramArrayOfByte);
        }
      }
      else if ((n == 3) && (localMsgBody.rpt_msg_list.has()))
      {
        paramArrayOfByte = localMsgBody.rpt_msg_list.get();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
        {
          a(8, paramArrayOfByte);
          continue;
          label227:
          n = 0;
          if (n != 0) {
            if (n != 1) {}
          }
        }
      }
    }
  }
  
  public boolean a(int paramInt, List paramList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int n;
    if (paramList != null) {
      n = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (n < paramList.size())
      {
        if (((ApolloActionData)paramList.get(n)).actionId == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      n += 1;
    }
  }
  
  boolean a(DrawerPushItem paramDrawerPushItem)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      DrawerPushItem localDrawerPushItem = (DrawerPushItem)localIterator.next();
      if ((localDrawerPushItem.msg_id != null) && (localDrawerPushItem.msg_id.equals(paramDrawerPushItem.msg_id))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(ApolloActionData paramApolloActionData, int paramInt)
  {
    return a(paramApolloActionData, paramInt, null);
  }
  
  public boolean a(ApolloActionData paramApolloActionData, int paramInt, IResDownloadListener paramIResDownloadListener)
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
      int n;
      if ((paramInt & 0x1) == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "start download action panelpic aid=" + paramApolloActionData.actionId);
        }
        localObject1 = ApolloUtil.a(paramApolloActionData, 1);
        localObject2 = ApolloUtil.a(paramApolloActionData, 0);
        if (!FileUtils.a((String)localObject2))
        {
          localObject1 = new DownloadTask((String)localObject1, new File((String)localObject2));
          ((DownloadTask)localObject1).f = "apollo_res";
          ((DownloadTask)localObject1).jdField_b_of_type_Int = 1;
          ((DownloadTask)localObject1).l = true;
          ((DownloadTask)localObject1).o = true;
          ((DownloadTask)localObject1).p = true;
          n = DownloaderFactory.a((DownloadTask)localObject1, a());
          if (n != 0) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, "ret:" + n);
          }
        }
      }
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "start download action gif aid=" + paramApolloActionData.actionId);
        }
        localObject1 = ApolloUtil.a(paramApolloActionData, 3);
        localObject2 = ApolloUtil.a(paramApolloActionData, 2);
        if (!FileUtils.a((String)localObject2))
        {
          localObject1 = new DownloadTask((String)localObject1, new File((String)localObject2));
          ((DownloadTask)localObject1).f = "apollo_res";
          ((DownloadTask)localObject1).l = true;
          n = DownloaderFactory.a((DownloadTask)localObject1, a());
          if (n != 0) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, "ret:" + n);
          }
        }
      }
      if ((paramInt & 0x4) == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "start download action zip aid=" + paramApolloActionData.actionId);
        }
        localObject2 = ApolloUtil.a(paramApolloActionData, 5);
        localObject1 = ApolloUtil.a(paramApolloActionData, 4);
        if (!ApolloUtil.a(paramApolloActionData.actionId, paramApolloActionData.personNum))
        {
          localObject2 = new DownloadTask((String)localObject2, new File((String)localObject1));
          ((DownloadTask)localObject2).f = "apollo_res";
          ((DownloadTask)localObject2).jdField_b_of_type_Int = 1;
          ((DownloadTask)localObject2).l = true;
          ((DownloadTask)localObject2).o = true;
          ((DownloadTask)localObject2).p = true;
          paramInt = DownloaderFactory.a((DownloadTask)localObject2, a());
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
        FileUtils.a((String)localObject1, ApolloUtil.a(paramApolloActionData, 6), false);
        FileUtils.d((String)localObject1);
        a(paramApolloActionData);
        if (paramIResDownloadListener != null) {
          if (!ApolloUtil.a(paramApolloActionData.actionId, paramApolloActionData.personNum))
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
  
  public boolean a(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {}
    label98:
    int n;
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
            break label98;
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
      paramApolloActionPackage = new DownloadTask(ApolloUtil.b(paramApolloActionPackage), new File(ApolloUtil.a(paramApolloActionPackage)));
      paramApolloActionPackage.l = true;
      paramApolloActionPackage.f = "apollo_res";
      paramApolloActionPackage.jdField_b_of_type_Int = 1;
      paramApolloActionPackage.o = true;
      paramApolloActionPackage.p = true;
      n = DownloaderFactory.a(paramApolloActionPackage, a());
    } while (n != 0);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "ret:" + n);
    }
    return true;
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {
      if (paramEntity.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
      }
    }
    QLog.e("ApolloManager", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public boolean a(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      return paramString.apolloVipFlag == 1;
    }
    return false;
  }
  
  public boolean a(String paramString, ApolloActionData paramApolloActionData)
  {
    int i1 = 0;
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
            int n;
            boolean bool3;
            boolean bool1 = false;
            continue;
            bool2 = false;
            continue;
            n += 1;
            continue;
            n += 1;
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
              n = 0;
              bool2 = bool1;
              if (n < ((JSONArray)localObject).length())
              {
                bool2 = bool1;
                JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(n);
                if (localJSONObject == null) {
                  continue;
                }
                bool2 = bool1;
                int i2 = localJSONObject.optInt("time");
                bool2 = bool1;
                int i3 = localJSONObject.optInt("duration");
                bool2 = bool1;
                localStringBuilder.append(i2).append(",").append(i3);
                bool2 = bool1;
                if (n >= ((JSONArray)localObject).length() - 1) {
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
              n = i1;
              if (n < paramString.length())
              {
                ((StringBuilder)localObject).append(paramString.getString(n));
                if (n >= paramString.length() - 1) {
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
  
  public int b(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      return paramString.apolloStatus;
    }
    return 0;
  }
  
  public ApolloBaseInfo b(String paramString)
  {
    Object localObject2 = null;
    ??? = null;
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return ???;
      boolean bool = paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo != null)) {
        return this.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo;
      }
      synchronized (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache)
      {
        if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.containsKey(paramString))
        {
          paramString = (ApolloBaseInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
          return paramString;
        }
      }
      ??? = localObject2;
      if (0 == 0)
      {
        ??? = localObject2;
        if (!this.jdField_k_of_type_Boolean)
        {
          localObject2 = (ApolloBaseInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ApolloBaseInfo.class, paramString);
          if (bool) {
            this.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo = ((ApolloBaseInfo)localObject2);
          }
          ??? = localObject2;
          if (localObject2 != null) {
            synchronized (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache)
            {
              this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramString, localObject2);
              ??? = localObject2;
              if (QLog.isColorLevel())
              {
                QLog.d("ApolloManager", 2, "unInit mApolloBaseInfoCache, find from db uin: " + ApolloUtil.d(paramString) + ", apollo status: " + ((ApolloBaseInfo)localObject2).apolloStatus);
                return localObject2;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache)
      {
        if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.containsKey(paramString))
        {
          ??? = (ApolloBaseInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
          localObject2 = ???;
          if (??? == null)
          {
            localObject2 = new ApolloBaseInfo();
            ((ApolloBaseInfo)localObject2).uin = paramString;
          }
          return localObject2;
        }
      }
      if (this.jdField_b_of_type_JavaUtilHashSet.contains(paramString))
      {
        localObject2 = (ApolloBaseInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ApolloBaseInfo.class, paramString);
        ??? = localObject2;
        if (localObject2 != null)
        {
          this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramString, localObject2);
          ??? = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloManager", 2, "mApolloBaseInfoCache unCache, mUnCacheUinSets contains, find from db uin: " + ApolloUtil.d(paramString) + ", apollo status: " + ((ApolloBaseInfo)localObject2).apolloStatus);
            ??? = localObject2;
          }
        }
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager.a();
    }
  }
  
  public void b(int paramInt)
  {
    int n;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).edit().putInt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_whiteList", paramInt).commit();
      n = SharedPreUtils.s(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
      if (n != 0) {
        break label139;
      }
      jdField_c_of_type_Int = paramInt;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "update white list " + n + ", mWhiteUserStatus: " + jdField_c_of_type_Int + ", status: " + paramInt);
      }
      return;
      label139:
      if (1 == n) {
        jdField_c_of_type_Int = 1;
      } else {
        jdField_c_of_type_Int = 0;
      }
    }
  }
  
  public void b(DrawerPushItem paramDrawerPushItem)
  {
    ((ProxyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, paramDrawerPushItem.getTableName(), paramDrawerPushItem, 4, null);
  }
  
  public void b(IResDownloadListener paramIResDownloadListener)
  {
    if ((paramIResDownloadListener != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager.b(paramIResDownloadListener);
    }
  }
  
  public void b(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData != null)
    {
      Object localObject = new File(ApolloUtil.a(paramApolloActionData, 7));
      if (((File)localObject).exists()) {
        try
        {
          localObject = FileUtils.a((File)localObject);
          if (new JSONObject((String)localObject).optLong("version") < paramApolloActionData.version)
          {
            boolean bool = FileUtil.c(ApolloUtil.a(paramApolloActionData, 6));
            URLDrawable.removeMemoryCacheByUrl(new URL("apollo_pic", null, paramApolloActionData.actionId + "_" + paramApolloActionData.actionName).toString());
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "del old action res id:" + paramApolloActionData.actionId + ", ret: " + bool);
            }
          }
          else
          {
            a((String)localObject, paramApolloActionData);
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
  
  public void b(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        DrawerPushItem localDrawerPushItem = (DrawerPushItem)localIterator.next();
        if ((localDrawerPushItem.msg_id != null) && (localDrawerPushItem.msg_id.equals(paramString)))
        {
          localDrawerPushItem.show_sum = localDrawerPushItem.show_counts;
          this.jdField_a_of_type_JavaUtilList.remove(localDrawerPushItem);
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localDrawerPushItem);
          if (QLog.isColorLevel()) {
            QLog.i("ApolloManager", 2, "remove bubble:" + localDrawerPushItem.msg_id);
          }
          return;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ApolloManager", 2, "remove bubble failed:" + paramString);
    }
  }
  
  public void b(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      if (paramList.size() == 1)
      {
        a((ApolloBaseInfo)paramList.get(0));
        return;
      }
      Iterator localIterator = paramList.iterator();
      ApolloBaseInfo localApolloBaseInfo;
      while (localIterator.hasNext())
      {
        localApolloBaseInfo = (ApolloBaseInfo)localIterator.next();
        if (!TextUtils.isEmpty(localApolloBaseInfo.uin))
        {
          if (localApolloBaseInfo.uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
            this.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo = localApolloBaseInfo;
          }
          synchronized (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache)
          {
            this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(localApolloBaseInfo.uin, localApolloBaseInfo);
          }
        }
      }
      ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      ((EntityTransaction)???).a();
      try
      {
        localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          localApolloBaseInfo = (ApolloBaseInfo)localIterator.next();
          if (!TextUtils.isEmpty(localApolloBaseInfo.uin)) {
            a(localApolloBaseInfo);
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "bulk insert exception: " + localException.getMessage());
        }
        ((EntityTransaction)???).b();
        while ((QLog.isColorLevel()) && (paramList.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())))
        {
          paramList = (ApolloBaseInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          QLog.d("ApolloManager", 2, "save apollo info vip flag: " + paramList.apolloVipFlag + ", level: " + paramList.apolloVipFlag + ", apollo status: " + paramList.apolloStatus + ", apollo local TS: " + paramList.apolloLocalTS + ", apollo svr TS:" + paramList.apolloServerTS + ", apollo upt TS:" + paramList.apolloUpdateTime);
          return;
          ((EntityTransaction)???).c();
          ((EntityTransaction)???).b();
        }
      }
      finally
      {
        ((EntityTransaction)???).b();
      }
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() == true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "apollo json is parsing,return.");
      }
      return true;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    Object localObject3 = null;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Object localObject1;
    int n;
    label209:
    long l1;
    try
    {
      localObject1 = FileUtils.b(new File(ApolloUtil.jdField_a_of_type_JavaLangString));
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("parseActionPanelJSon start file size:");
        if (localObject1 == null)
        {
          n = 0;
          QLog.d("ApolloManager", 2, n + " byte");
        }
      }
      else
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label209;
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.e("ApolloManager", 2, "read json fail e =" + localThrowable.toString());
          localObject1 = localObject3;
          continue;
          n = ((String)localObject1).length();
        }
      }
      l1 = System.currentTimeMillis();
    }
    for (;;)
    {
      int i1;
      try
      {
        if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() <= 0)) {
          break label1034;
        }
        n = 1;
        localObject1 = new JSONObject((String)localObject1);
        localObject3 = ((JSONObject)localObject1).getJSONArray("tabList");
        i1 = 0;
        if (i1 < ((JSONArray)localObject3).length())
        {
          String str = ((JSONArray)localObject3).getString(i1);
          JSONObject localJSONObject = ((JSONObject)localObject1).optJSONObject(str);
          if ("actionInfo".equals(str))
          {
            a(localArrayList1, localArrayList2, localArrayList3, localJSONObject);
            if (!QLog.isColorLevel()) {
              break label1027;
            }
            QLog.d("ApolloManager", 2, "apollo json tablist :" + str);
            break label1027;
          }
          if (!"gameInfo".equals(str)) {
            continue;
          }
          continue;
        }
        a(((JSONObject)localObject1).optJSONObject("bubbleInfo"));
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          localObject3 = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
          ((ApolloDaoManager)localObject3).c();
          ((ApolloDaoManager)localObject3).a(localArrayList1);
          ((ApolloDaoManager)localObject3).b(1);
          ((ApolloDaoManager)localObject3).c(localArrayList2);
          ((ApolloDaoManager)localObject3).f();
          ((ApolloDaoManager)localObject3).e(localArrayList3);
          if ((n == 0) && (!jdField_a_of_type_Boolean))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ApolloManager", 1, "parseActionPanelJSon request getUserApolloInfo~");
            }
            ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 128, "refreshAction");
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager.a(Boolean.valueOf(true));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("chat_tool_apollo_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true).commit();
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
          if (!((SharedPreferences)localObject3).getBoolean("7.6.3" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false)) {
            ((SharedPreferences)localObject3).edit().putBoolean("7.6.3" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true).commit();
          }
          if (localObject1 != null) {
            ((SharedPreferences)localObject3).edit().putInt("apollo_json_version" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (int)(((JSONObject)localObject1).optLong("timeStamp") / 1000L)).commit();
          }
        }
        localObject1 = ((JSONObject)localObject1).optJSONArray("petConfig");
        if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_pet_sp", 0).edit().putString("pet_config", ((JSONArray)localObject1).toString()).commit();
          this.jdField_k_of_type_JavaLangString = ((JSONArray)localObject1).toString();
          i1 = ((JSONArray)localObject1).length();
          n = 0;
          if (n < i1)
          {
            localObject3 = ((JSONArray)localObject1).getJSONObject(n);
            int i2 = ((JSONObject)localObject3).optInt("standUpAction", 0);
            int i3 = ((JSONObject)localObject3).optInt("getDownAction", 0);
            a(i2, 0);
            a(i3, 0);
            n += 1;
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ApolloManager", 2, "parseActionPanelJSon failed", localException);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        QLog.d("ApolloManager", 1, "parseActionPanelJSon end cost: " + (System.currentTimeMillis() - l1) + "ms");
        continue;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        QLog.d("ApolloManager", 1, "parseActionPanelJSon end cost: " + (System.currentTimeMillis() - l1) + "ms");
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return true;
      label1027:
      i1 += 1;
      continue;
      label1034:
      n = 0;
    }
  }
  
  public boolean b(ApolloActionData paramApolloActionData, int paramInt)
  {
    if (paramApolloActionData == null) {
      return false;
    }
    String str = "";
    if ((paramInt & 0x1) == 1) {
      str = ApolloUtil.a(paramApolloActionData, 0);
    }
    for (;;)
    {
      return FileUtil.a(str);
      if ((paramInt & 0x2) == 2) {
        str = ApolloUtil.a(paramApolloActionData, 2);
      }
    }
  }
  
  public boolean b(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {
      return false;
    }
    return FileUtil.a(ApolloUtil.a(paramApolloActionPackage));
  }
  
  public boolean b(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      return paramString.isApolloGameWhiteUser();
    }
    return false;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() == null)) {}
    long l1;
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      l1 = NetConnInfoCenter.getServerTime();
      localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
    } while (l1 - localSharedPreferences.getLong("sp_key_apollo_check_action_time", 0L) <= 300L);
    ApolloContentUpdateHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    localSharedPreferences.edit().putLong("sp_key_apollo_check_action_time", l1).commit();
  }
  
  public void c(DrawerPushItem paramDrawerPushItem)
  {
    a(paramDrawerPushItem, true);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "[updateLastShopTabInfo] tab=", paramString });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.l = paramString;
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0).edit();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + "sp_key_last_shop_tab";
    if (!TextUtils.isEmpty(paramString)) {
      localEditor.putString(str, this.l);
    }
    for (;;)
    {
      localEditor.commit();
      return;
      localEditor.remove(str);
    }
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[parseGameJson]");
    }
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      int n;
      try
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localObject1 == null) {
          return false;
        }
        if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, "game json is parsing,return.");
          }
          return true;
        }
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        localObject1 = FileUtils.b(new File(ApolloUtil.jdField_b_of_type_JavaLangString));
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder().append("parseGameJson start file size:");
          if (localObject1 == null)
          {
            n = 0;
            QLog.d("ApolloManager", 2, n + " byte");
          }
        }
        else
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            continue;
          }
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          return false;
        }
        n = ((String)localObject1).length();
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, (String)localObject1);
        }
        JSONObject localJSONObject = new JSONObject((String)localObject1);
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        ApolloActionPackage localApolloActionPackage = new ApolloActionPackage();
        localApolloActionPackage.packageId = 100;
        localApolloActionPackage.version = localJSONObject.optLong("timeStamp");
        localApolloActionPackage.type = 100;
        localObject1 = localJSONObject.optJSONObject("data");
        if (localObject1 == null)
        {
          QLog.d("ApolloManager", 1, "parse game json but data is null");
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          return false;
        }
        Object localObject3 = ((JSONObject)localObject1).optJSONArray("aioGameTab");
        if ((localObject3 == null) || (((JSONArray)localObject3).length() == 0))
        {
          QLog.d("ApolloManager", 1, "parse game json but aioGameTab is null");
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          return false;
        }
        localObject3 = ((JSONArray)localObject3).getJSONObject(0);
        localApolloActionPackage.mIconUnselectedUrl = ((JSONObject)localObject3).optString("apImg");
        localApolloActionPackage.mIconSelectedUrl = ((JSONObject)localObject3).optString("apcImg");
        ApolloDaoManager localApolloDaoManager = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
        localObject3 = ((JSONObject)localObject1).optJSONArray("aioGame735");
        if (localObject3 == null)
        {
          QLog.d("ApolloManager", 1, "parse game json but aioGame is null");
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          return false;
        }
        n = 0;
        Object localObject4;
        Object localObject5;
        if (n < ((JSONArray)localObject3).length())
        {
          localObject4 = new ApolloGameData();
          localObject5 = ((JSONArray)localObject3).getJSONObject(n);
          ((ApolloGameData)localObject4).minVer = ((JSONObject)localObject5).optString("gameStartVersion");
          ((ApolloGameData)localObject4).maxVer = ((JSONObject)localObject5).optString("gameEndVersion");
          if (TextUtils.isEmpty(((ApolloGameData)localObject4).maxVer)) {
            ((ApolloGameData)localObject4).maxVer = "100.100.100";
          }
          ((ApolloGameData)localObject4).isShow = ((JSONObject)localObject5).optInt("isShowOnPanel");
          ((ApolloGameData)localObject4).gameId = ((JSONObject)localObject5).optInt("gameId");
          ((ApolloGameData)localObject4).name = ((JSONObject)localObject5).optString("gameName");
          ((ApolloGameData)localObject4).screenMode = ((JSONObject)localObject5).optInt("screenMode");
          ((ApolloGameData)localObject4).gameBtns = ((JSONObject)localObject5).optString("gameBtn");
          ((ApolloGameData)localObject4).hotChatBtns = ((JSONObject)localObject5).optString("hotChatBtn");
          ((ApolloGameData)localObject4).actionId = ((JSONObject)localObject5).optInt("actionId");
          ((ApolloGameData)localObject4).toolUrl = ((JSONObject)localObject5).optString("toolUrl");
          ((ApolloGameData)localObject4).isSupportStandBy = ((JSONObject)localObject5).optInt("isSupportStandby");
          ((ApolloGameData)localObject4).viewMode = ((JSONObject)localObject5).optInt("viewMode");
          ((ApolloGameData)localObject4).listCoverUrl = ((JSONObject)localObject5).optString("listCoverUrl");
          ((ApolloGameData)localObject4).bigCoverUrl = ((JSONObject)localObject5).optString("bigCoverUrl");
          ((ApolloGameData)localObject4).bigCoverBgColor = ((JSONObject)localObject5).optString("bigCoverBgColor");
          ((ApolloGameData)localObject4).needOpenKey = ((JSONObject)localObject5).optInt("needOpenKey");
          ((ApolloGameData)localObject4).appId = ((JSONObject)localObject5).optLong("appId");
          ((ApolloGameData)localObject4).hotChatCode = ((JSONObject)localObject5).optString("hotChatCode");
          ((ApolloGameData)localObject4).homeButtonAction = ((JSONObject)localObject5).optString("homeButtonAction");
          ((ApolloGameData)localObject4).actUrl = ((JSONObject)localObject5).optString("activityUrl");
          ((ApolloGameData)localObject4).hasOwnArk = ((JSONObject)localObject5).optInt("hasOwnArk");
          ((ApolloGameData)localObject4).logoUrl = ((JSONObject)localObject5).optString("logoUrl");
          ((ApolloGameData)localObject4).developerName = ((JSONObject)localObject5).optString("epName");
          ((ApolloGameData)localObject4).developerUrl = ((JSONObject)localObject5).optString("developer_url");
          ((ApolloGameData)localObject4).officialAccountHead = ((JSONObject)localObject5).optString("official_account_head");
          ((ApolloGameData)localObject4).officialAccountUin = ((JSONObject)localObject5).optString("puin");
          if (((JSONObject)localObject5).optInt("isFeatured") != 1) {
            break label1789;
          }
          bool = true;
          ((ApolloGameData)localObject4).isFeatured = bool;
          localArrayList2.add(localObject4);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, new Object[] { "apollo game add:" + ((ApolloGameData)localObject4).gameId, "gameData.hotChatBtns：" + ((ApolloGameData)localObject4).hotChatBtns + ",gameData.hotChatCode:" + ((ApolloGameData)localObject4).hotChatCode });
          }
        }
        else
        {
          localObject3 = ((JSONObject)localObject1).optJSONArray("gameMode");
          n = 0;
          if (n < ((JSONArray)localObject3).length())
          {
            localObject4 = ((JSONArray)localObject3).getJSONObject(n);
            localObject5 = new ApolloGameModeData();
            ((ApolloGameModeData)localObject5).mGameMode = ((JSONObject)localObject4).optInt("mode");
            ((ApolloGameModeData)localObject5).mDisableSendMsg = ((JSONObject)localObject4).optInt("disableSendMsg");
            localArrayList3.add(localObject5);
            n += 1;
            continue;
          }
          localObject1 = ((JSONObject)localObject1).optJSONArray("gameConfig");
          if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0) && (((JSONArray)localObject1).length() < 0))
          {
            localObject4 = ((JSONArray)localObject1).getJSONObject(0);
            ApolloGameConfig.a("aio.enter.bg", ((JSONObject)localObject4).optString("entranceBkgUrl"));
            localObject3 = ((JSONObject)localObject4).optString("entranceUrl_Android");
            localObject1 = localObject3;
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              localObject1 = ((JSONObject)localObject4).optString("entranceUrl");
            }
            ApolloGameConfig.a("aio.enter", (String)localObject1);
            ApolloGameConfig.a("aio.enter.name", ((JSONObject)localObject4).optString("entranceName"));
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, "gameList.size = " + localArrayList2.size() + " actionPackage.isUpdate = " + localApolloActionPackage.isUpdate);
          }
          localArrayList1.add(localApolloActionPackage);
          if (localApolloDaoManager != null)
          {
            localApolloDaoManager.d();
            localApolloDaoManager.d(localArrayList3);
            localApolloDaoManager.b(2);
            localApolloDaoManager.c(localArrayList1);
            localApolloDaoManager.b();
            localApolloDaoManager.f(localArrayList2);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager.a(Boolean.valueOf(true));
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
          if (localJSONObject != null) {
            ((SharedPreferences)localObject1).edit().putInt("apollo_game_version" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (int)localJSONObject.optLong("timestamp")).commit();
          }
          ((SharedPreferences)localObject1).edit().putBoolean("force_parse_gamejson_once7.6.3", true).commit();
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ApolloManager", 1, "parseGameJson errInfo->" + localThrowable.getMessage());
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return false;
      }
      finally
      {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        QLog.i("ApolloManager", 1, "parseGameJson end cost: " + (System.currentTimeMillis() - l1) + "ms");
      }
      n += 1;
      continue;
      label1789:
      boolean bool = false;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager.a(Boolean.valueOf(true));
    }
  }
  
  public void d(int paramInt)
  {
    boolean bool = true;
    if (1 == (paramInt >> 10 & 0x1)) {}
    for (;;)
    {
      a(bool);
      return;
      bool = false;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager.a(Boolean.valueOf(true));
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(jdField_a_of_type_Int);
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[removeAllS2CPushItem]");
    }
    ThreadManager.post(new ykh(this), 5, null, true);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_d_of_type_Boolean = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4).getBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + "sp_key_new_store_whitelist", false);
    QLog.d("ApolloManager", 1, new Object[] { "[initLocalNewStoreConfig] mIsNewStoreUser=", Boolean.valueOf(this.jdField_d_of_type_Boolean) });
    l();
  }
  
  public void onDestroy()
  {
    jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    ApolloResDownloader.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    jdField_b_of_type_Boolean = false;
    com.tencent.mobileqq.apollo.view.ApolloPanel.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.evictAll();
      label67:
      com.tencent.mobileqq.apollo.view.ApolloMainInfo.a = null;
      com.tencent.mobileqq.apollo.view.ApolloMainInfo.b = null;
      jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      ApolloCmdChannel.checkNeedDestroy();
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameHotChatController != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameHotChatController.c();
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameHotChatController = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager.c();
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager = null;
      }
      if (this.jdField_a_of_type_Yks != null)
      {
        ApolloGameStateMachine.a().deleteObserver(this.jdField_a_of_type_Yks);
        this.jdField_a_of_type_Yks = null;
      }
      ApolloGameStateMachine.d();
      ApolloGameUtil.a();
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloGameNormalStartHandler.b();
      return;
    }
    catch (Exception localException)
    {
      break label67;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager
 * JD-Core Version:    0.7.0.1
 */