package com.tencent.mobileqq.app;

import GROUP.MessageRemindRsp;
import ahpd;
import ahqs;
import ampx;
import amsw;
import amtj;
import anca;
import anco;
import ancq;
import ancr;
import ancs;
import anct;
import ancu;
import ancv;
import ancw;
import ancx;
import ancy;
import ancz;
import anda;
import andb;
import andc;
import andd;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.util.ArraySet;
import android.support.v4.util.LruCache;
import android.text.SpannableString;
import android.text.TextUtils;
import anuz;
import anvg;
import aptd;
import apte;
import aptf;
import aqgn;
import aqgr;
import aqhm;
import aucf;
import aucg;
import auso;
import avnu;
import awas;
import awhn;
import aync;
import azwi;
import bbgg;
import bbli;
import bcef;
import beir;
import beky;
import bfbz;
import bfcx;
import bfda;
import bfdg;
import bftd;
import bfuc;
import bfun;
import bgdk;
import bjun;
import com.qq.taf.jce.JceInputStream;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.HWTroopMemberCard;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.utils.TroopNameHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.utils.Utils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import nmb;
import nmf;
import org.json.JSONArray;
import org.json.JSONException;
import tencent.im.oidb.cmd0x6ef.oidb_cmd0x6ef.ReqBody;
import tencent.im.oidb.cmd0x787.oidb_0x787.Filter;
import tencent.im.oidb.cmd0x787.oidb_0x787.ReqBody;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.RspBody;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.ToastInfo;
import tencent.im.troop.honor.troop_honor.HonorChangeGrayTipsReserved;
import tencent.im.troop.honor.troop_honor.UserHonor;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import yos;
import yps;
import zsi;

public class TroopManager
  implements aptf, Manager
{
  public static String b;
  public static String c;
  public static ArrayList<String> c;
  public static String d;
  public static ArrayList<String> d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static String j;
  public static String k;
  public static String l;
  private int jdField_a_of_type_Int;
  amsw jdField_a_of_type_Amsw;
  private ancw jdField_a_of_type_Ancw;
  private andd jdField_a_of_type_Andd = new anco(this);
  protected LruCache<String, LruCache<String, TroopMemberInfo>> a;
  private azwi jdField_a_of_type_Azwi;
  public final beir a;
  public final beky a;
  public QQAppInterface a;
  TroopManager.SaveTroopMemberTask jdField_a_of_type_ComTencentMobileqqAppTroopManager$SaveTroopMemberTask;
  protected EntityManager a;
  TroopNameHelper jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper;
  private Runnable jdField_a_of_type_JavaLangRunnable = new TroopManager.1(this);
  public String a;
  ArrayList<Entity> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<String> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  protected Map<String, oidb_cmd0xb36.RspBody> a;
  Queue<Integer> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  protected Set<String> a;
  protected ConcurrentHashMap<String, Entity> a;
  ConcurrentLinkedQueue<TroopManager.SaveTroopMemberTask> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  public zsi a;
  protected boolean a;
  protected LruCache<String, TroopMemberCard> b;
  protected ArrayList<String> b;
  protected Map<String, List<WeakReference<ancx>>> b;
  protected Set<String> b;
  public ConcurrentHashMap<String, Entity> b;
  ConcurrentLinkedQueue<TroopManager.SaveTroopMemberTask> b;
  protected boolean b;
  protected LruCache<String, HWTroopMemberCard> c;
  protected Map<String, Long> c;
  protected ConcurrentHashMap<String, Entity> c;
  protected boolean c;
  LruCache<andb, Drawable> d;
  protected Map<String, Long> d;
  protected ConcurrentHashMap<String, String> d;
  public boolean d;
  private ArrayList<TroopInfo> jdField_e_of_type_JavaUtilArrayList;
  Map<String, Long> jdField_e_of_type_JavaUtilMap;
  protected ConcurrentHashMap<String, String> e;
  private ArrayList<andc> f;
  protected ConcurrentHashMap<String, Integer> f;
  
  static
  {
    jdField_b_of_type_JavaLangString = "next_get_expire_time";
    jdField_c_of_type_JavaLangString = "big_troop_expired_info";
    jdField_d_of_type_JavaLangString = "troop_expired_notify_tips_count";
    jdField_e_of_type_JavaLangString = "troop_expired_notify_tips_last_time";
    jdField_f_of_type_JavaLangString = "troop_expired_notify_tips_one_day_count";
    g = "troop_expired_notify_tips_close_count";
    h = "troop_expired_notify_count";
    i = "troop_expired_notify_dialog_last_time";
    j = "troop_expired_notify_dialog_is_show";
    k = "troop_expired_notify_dialog_one_day_count";
    l = "troop_expired_notify_dialog_last_day";
    jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  @Deprecated
  public TroopManager()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new QQConcurrentHashMap(1013, 1350);
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(12);
    this.jdField_b_of_type_JavaUtilMap = new HashMap(5);
    this.jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
    this.jdField_c_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_d_of_type_AndroidSupportV4UtilLruCache = new LruCache(10);
    this.jdField_f_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Beir = null;
    this.jdField_a_of_type_Beky = null;
  }
  
  public TroopManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new QQConcurrentHashMap(1013, 1350);
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(12);
    this.jdField_b_of_type_JavaUtilMap = new HashMap(5);
    this.jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
    this.jdField_c_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_d_of_type_AndroidSupportV4UtilLruCache = new LruCache(10);
    this.jdField_f_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_Amsw = ((amsw)paramQQAppInterface.getManager(51));
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Andd, true);
    bfcx.a();
    this.jdField_a_of_type_Beir = new beir(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_Beky = new beky(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_Zsi = new zsi(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    this.jdField_d_of_type_Boolean = f();
    paramQQAppInterface.getConfigProcess().a("batch_add_friend_for_troop_config", this);
  }
  
  protected static int a(TroopManager.ExpiredType paramExpiredType, MessageRemindRsp paramMessageRemindRsp)
  {
    switch (ancp.a[paramExpiredType.ordinal()])
    {
    default: 
      return (int)paramMessageRemindRsp.iSVIPExpiredTime;
    case 2: 
      return (int)paramMessageRemindRsp.iGroupExpiredTime;
    }
    return paramMessageRemindRsp.iLhGroupExpiredTime;
  }
  
  public static MessageRemindRsp a(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = paramSharedPreferences.getString(jdField_c_of_type_JavaLangString, "");
    if (!TextUtils.isEmpty(paramSharedPreferences))
    {
      paramString = new MessageRemindRsp();
      paramString.readFrom(new JceInputStream(Utils.hexStr2Bytes(paramSharedPreferences)));
      return paramString;
    }
    return null;
  }
  
  private bbgg a(TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    SearchConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    bbgg localbbgg = null;
    Object localObject1 = null;
    Object localObject2 = localbbgg;
    if (SearchConfigManager.troopMemberUpdateConfigs != null)
    {
      localObject2 = localbbgg;
      if (!SearchConfigManager.troopMemberUpdateConfigs.isEmpty())
      {
        Iterator localIterator = SearchConfigManager.troopMemberUpdateConfigs.iterator();
        localObject2 = localObject1;
        if (localIterator.hasNext())
        {
          localbbgg = (bbgg)localIterator.next();
          if (paramBoolean)
          {
            localObject2 = localbbgg;
            if (localObject1 != null) {
              if (localObject1.b <= localbbgg.b) {
                break label133;
              }
            }
          }
        }
      }
    }
    label133:
    for (localObject2 = localbbgg;; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      break;
      if ((paramTroopInfo.wMemberNum > localbbgg.jdField_a_of_type_Int) && (paramTroopInfo.wMemberNum < localbbgg.b))
      {
        localObject2 = localbbgg;
        return localObject2;
      }
    }
  }
  
  protected static TroopManager.ExpiredType a(MessageRemindRsp paramMessageRemindRsp)
  {
    Object localObject2 = TroopManager.ExpiredType.SVIP;
    Object localObject1 = localObject2;
    if (paramMessageRemindRsp.iGroupExpiredTime != 0L)
    {
      localObject1 = localObject2;
      if (paramMessageRemindRsp.iGroupExpiredTime < paramMessageRemindRsp.iSVIPExpiredTime) {
        localObject1 = TroopManager.ExpiredType.GROUP;
      }
    }
    localObject2 = localObject1;
    if (paramMessageRemindRsp.iLhGroupExpiredTime != 0) {
      if (paramMessageRemindRsp.iGroupExpiredTime != 0L)
      {
        localObject2 = localObject1;
        if (paramMessageRemindRsp.iLhGroupExpiredTime >= paramMessageRemindRsp.iGroupExpiredTime) {}
      }
      else if (paramMessageRemindRsp.iSVIPExpiredTime != 0L)
      {
        localObject2 = localObject1;
        if (paramMessageRemindRsp.iLhGroupExpiredTime >= paramMessageRemindRsp.iSVIPExpiredTime) {}
      }
      else
      {
        localObject2 = TroopManager.ExpiredType.LIANG;
      }
    }
    return localObject2;
  }
  
  private String a(HotChatManager paramHotChatManager, TroopManager paramTroopManager, QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramHotChatManager == null) || (paramTroopManager == null)) {}
    do
    {
      return paramString;
      paramHotChatManager = paramHotChatManager.a(paramString);
      if (paramHotChatManager != null) {
        return paramHotChatManager.name + amtj.a(2131701728);
      }
      paramHotChatManager = paramTroopManager.b(paramString);
    } while ((paramHotChatManager == null) || (paramHotChatManager.getTroopName() == null));
    return paramHotChatManager.getTroopName();
  }
  
  private ConcurrentHashMap<String, Entity> a()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null)
        {
          localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(CommonlyUsedTroop.class, false, null, null, null, null, null, null);
          if (localObject1 == null) {
            break label179;
          }
          m = ((ArrayList)localObject1).size();
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new QQConcurrentHashMap(1014, m, 25);
          int n = 0;
          if (n < m)
          {
            CommonlyUsedTroop localCommonlyUsedTroop = (CommonlyUsedTroop)((ArrayList)localObject1).get(n);
            if (QLog.isColorLevel()) {
              QLog.d("OpenTroopDebug", 2, "init load groupcode = " + localCommonlyUsedTroop.troopUin);
            }
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localCommonlyUsedTroop.troopUin, localCommonlyUsedTroop);
            n += 1;
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CommonlyUsedTroop", 2, "load CommonlyUsedTroop info: size = " + m);
          }
        }
        Object localObject1 = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
        return localObject1;
      }
      finally {}
      label179:
      int m = 0;
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    switch (paramInt1)
    {
    }
    Object localObject;
    do
    {
      return;
      f(paramString);
      try
      {
        if (this.jdField_e_of_type_JavaUtilArrayList != null)
        {
          localObject = this.jdField_e_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject).hasNext()) {
            if (((TroopInfo)((Iterator)localObject).next()).troopuin.equals(paramString)) {
              ((Iterator)localObject).remove();
            }
          }
        }
        return;
      }
      finally {}
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramString);
      b((ArrayList)localObject);
      return;
      localObject = b(paramString);
    } while ((localObject == null) || (!a((TroopInfo)localObject, true)));
    anca localanca = (anca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20);
    for (;;)
    {
      try
      {
        if (this.jdField_e_of_type_JavaUtilArrayList == null)
        {
          this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
          this.jdField_e_of_type_JavaUtilArrayList.add(localObject);
          localanca.a(true, paramString, ((TroopInfo)localObject).troopcode, 9);
          return;
        }
      }
      finally {}
      this.jdField_e_of_type_JavaUtilArrayList.add(localObject);
    }
  }
  
  public static void a(MessageRemindRsp paramMessageRemindRsp, QQAppInterface paramQQAppInterface, String paramString, Context paramContext, TroopChatPie paramTroopChatPie, ahqs paramahqs)
  {
    if (paramMessageRemindRsp == null) {}
    QVipBigTroopExpiredConfig localQVipBigTroopExpiredConfig;
    int m;
    TroopManager.ExpiredType localExpiredType;
    do
    {
      do
      {
        return;
        localQVipBigTroopExpiredConfig = aqgr.c();
      } while (!localQVipBigTroopExpiredConfig.mIsEnable);
      m = (int)(System.currentTimeMillis() / 1000L);
      localExpiredType = a(paramMessageRemindRsp);
      if (paramMessageRemindRsp.isFreezed)
      {
        a(paramQQAppInterface, paramString, m, localQVipBigTroopExpiredConfig, paramMessageRemindRsp, paramContext, localExpiredType, paramTroopChatPie, paramahqs);
        return;
      }
    } while ((paramMessageRemindRsp.eRemindLevel < 3) || (ancy.a(paramMessageRemindRsp.iGroupType)));
    int n = a(localExpiredType, paramMessageRemindRsp);
    if (VipUtils.a(m, n) > localQVipBigTroopExpiredConfig.mNotifyTipsMaxDay)
    {
      ((TroopManager)paramQQAppInterface.getManager(52)).l(paramString);
      return;
    }
    a(paramQQAppInterface, paramString, m, localQVipBigTroopExpiredConfig, n, paramMessageRemindRsp, paramContext, localExpiredType, paramTroopChatPie, paramahqs);
  }
  
  private static void a(Context paramContext, TroopManager paramTroopManager, String paramString, MessageRemindRsp paramMessageRemindRsp, int paramInt1, QVipBigTroopExpiredConfig paramQVipBigTroopExpiredConfig, int paramInt2, int paramInt3, TroopManager.ExpiredType paramExpiredType)
  {
    switch (ancp.a[paramExpiredType.ordinal()])
    {
    }
    int m;
    do
    {
      do
      {
        return;
        m = VipUtils.a(paramInt1, (int)paramMessageRemindRsp.iSVIPExpiredTime);
      } while (((m > paramQVipBigTroopExpiredConfig.mNotifyDialogMaxDay) || (m < paramQVipBigTroopExpiredConfig.mNotifyDialogMinDay)) && (m != 0));
      VipUtils.a(paramContext, paramString, VipUtils.a((int)paramMessageRemindRsp.iSVIPExpiredTime, 5).toString(), amtj.a(2131714526), new anct(), "0X8009E36", 1);
      paramTroopManager.h(paramString, paramInt2 + 1);
      paramTroopManager.i(paramString, paramInt1);
      paramTroopManager.j(paramString, paramInt3 + 1);
      bcef.b(null, "dc00898", "", "", "qq_vip", "0X8009E35", 1, 0, "", "", "", "");
      return;
      m = VipUtils.a(paramInt1, (int)paramMessageRemindRsp.iGroupExpiredTime);
    } while (((m > paramQVipBigTroopExpiredConfig.mNotifyDialogMaxDay) || (m < paramQVipBigTroopExpiredConfig.mNotifyDialogMinDay)) && (m != 0));
    VipUtils.a(paramContext, paramString, VipUtils.a((int)paramMessageRemindRsp.iGroupExpiredTime, 4).toString(), amtj.a(2131714532), new ancu(), "0X8009E36", 1);
    paramTroopManager.h(paramString, paramInt2 + 1);
    paramTroopManager.i(paramString, paramInt1);
    paramTroopManager.j(paramString, paramInt3 + 1);
    bcef.b(null, "dc00898", "", "", "qq_vip", "0X8009E35", 1, 0, "", "", "", "");
  }
  
  private void a(anuz paramanuz, CommonlyUsedTroop paramCommonlyUsedTroop, boolean paramBoolean)
  {
    RecentUser localRecentUser = (RecentUser)paramanuz.findRecentUser(paramCommonlyUsedTroop.troopUin, 1);
    if (localRecentUser != null)
    {
      localRecentUser.showUpTime = paramCommonlyUsedTroop.addedTimestamp;
      localRecentUser.opTime = Math.max(localRecentUser.opTime, paramCommonlyUsedTroop.addedTimestamp);
      paramanuz.saveRecentUser(localRecentUser);
    }
    while ((paramCommonlyUsedTroop.addedTimestamp <= 0L) || (paramCommonlyUsedTroop.addedTimestamp <= 1558281600L) || (!paramBoolean)) {
      return;
    }
    localRecentUser = new RecentUser(paramCommonlyUsedTroop.troopUin, 1);
    localRecentUser.showUpTime = paramCommonlyUsedTroop.addedTimestamp;
    localRecentUser.opTime = paramCommonlyUsedTroop.addedTimestamp;
    paramanuz.saveRecentUser(localRecentUser);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    jdField_c_of_type_JavaUtilArrayList.clear();
    jdField_d_of_type_JavaUtilArrayList.clear();
    a(paramQQAppInterface, jdField_c_of_type_JavaUtilArrayList, jdField_d_of_type_JavaUtilArrayList);
    if (jdField_c_of_type_JavaUtilArrayList.isEmpty()) {
      jdField_c_of_type_JavaUtilArrayList.addAll(Arrays.asList(new String[] { amtj.a(2131714553), amtj.a(2131714539), amtj.a(2131714535), amtj.a(2131714546), amtj.a(2131714518), amtj.a(2131714524), amtj.a(2131714543) }));
    }
    if (jdField_d_of_type_JavaUtilArrayList.isEmpty()) {
      jdField_d_of_type_JavaUtilArrayList.addAll(Arrays.asList(new String[] { amtj.a(2131714555), amtj.a(2131714528), amtj.a(2131714554), amtj.a(2131714540), amtj.a(2131714556), amtj.a(2131714545), amtj.a(2131714509), amtj.a(2131714505), amtj.a(2131714522) }));
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, TroopChatPie paramTroopChatPie, ahqs paramahqs, Context paramContext, TroopManager paramTroopManager, String paramString, MessageRemindRsp paramMessageRemindRsp, int paramInt1, QVipBigTroopExpiredConfig paramQVipBigTroopExpiredConfig, int paramInt2, int paramInt3, TroopManager.ExpiredType paramExpiredType)
  {
    switch (ancp.a[paramExpiredType.ordinal()])
    {
    }
    int m;
    do
    {
      do
      {
        do
        {
          return;
          m = VipUtils.a(paramInt1, (int)paramMessageRemindRsp.iSVIPExpiredTime);
        } while ((m > paramQVipBigTroopExpiredConfig.mNotifyTipsMaxDay) || (m < paramQVipBigTroopExpiredConfig.mNotifyTipsMinDay));
        if (paramTroopChatPie.a == null)
        {
          paramTroopChatPie.a = new ahpd(paramQQAppInterface, paramContext, paramahqs);
          paramahqs.a(paramTroopChatPie.a);
        }
        paramTroopChatPie.a.a(paramString, VipUtils.a((int)paramMessageRemindRsp.iSVIPExpiredTime, 1), 0, 2);
        paramahqs.a(paramTroopChatPie.a, new Object[0]);
        paramTroopManager.d(paramString, paramInt2 + 1);
        paramTroopManager.e(paramString, paramInt1);
        paramTroopManager.f(paramString, paramInt3 + 1);
        bcef.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009E33", 2, 0, "", "", "", "");
        return;
        m = VipUtils.a(paramInt1, (int)paramMessageRemindRsp.iGroupExpiredTime);
      } while ((m > paramQVipBigTroopExpiredConfig.mNotifyTipsMaxDay) || (m < paramQVipBigTroopExpiredConfig.mNotifyTipsMinDay));
      if (paramTroopChatPie.a == null)
      {
        paramTroopChatPie.a = new ahpd(paramQQAppInterface, paramContext, paramahqs);
        paramahqs.a(paramTroopChatPie.a);
      }
      paramTroopChatPie.a.a(paramString, VipUtils.a((int)paramMessageRemindRsp.iGroupExpiredTime, 0), 0, 1);
      paramahqs.a(paramTroopChatPie.a, new Object[0]);
      paramTroopManager.d(paramString, paramInt2 + 1);
      paramTroopManager.e(paramString, paramInt1);
      paramTroopManager.f(paramString, paramInt3 + 1);
      bcef.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009E33", 1, 0, "", "", "", "");
      return;
      m = VipUtils.a(paramInt1, paramMessageRemindRsp.iLhGroupExpiredTime);
    } while ((m > paramQVipBigTroopExpiredConfig.mNotifyTipsMaxDay) || (m < paramQVipBigTroopExpiredConfig.mNotifyTipsMinDay));
    if (paramTroopChatPie.a == null)
    {
      paramTroopChatPie.a = new ahpd(paramQQAppInterface, paramContext, paramahqs);
      paramahqs.a(paramTroopChatPie.a);
    }
    paramTroopChatPie.a.a(paramString, VipUtils.a(paramMessageRemindRsp.iLhGroupExpiredTime, 10), 0, 3);
    paramahqs.a(paramTroopChatPie.a, new Object[0]);
    paramTroopManager.d(paramString, paramInt2 + 1);
    paramTroopManager.e(paramString, paramInt1);
    paramTroopManager.f(paramString, paramInt3 + 1);
    bcef.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A579", 0, 0, "", "", "", "");
  }
  
  protected static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, QVipBigTroopExpiredConfig paramQVipBigTroopExpiredConfig, int paramInt2, MessageRemindRsp paramMessageRemindRsp, Context paramContext, TroopManager.ExpiredType paramExpiredType, TroopChatPie paramTroopChatPie, ahqs paramahqs)
  {
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
    int m = localTroopManager.c(paramString);
    int n;
    if (m < paramQVipBigTroopExpiredConfig.mNotifyTipsMaxCount)
    {
      if (!VipUtils.a(localTroopManager.d(paramString), paramInt1)) {
        a(paramQQAppInterface, paramTroopChatPie, paramahqs, paramContext, localTroopManager, paramString, paramMessageRemindRsp, paramInt1, paramQVipBigTroopExpiredConfig, m, 0, paramExpiredType);
      }
    }
    else
    {
      m = localTroopManager.g(paramString);
      n = localTroopManager.h(paramString);
      if ((!VipUtils.a(paramInt1, paramInt2)) || (VipUtils.a(n, paramInt1))) {
        break label158;
      }
      a(paramContext, localTroopManager, paramString, paramMessageRemindRsp, paramInt1, paramQVipBigTroopExpiredConfig, m, 0, paramExpiredType);
    }
    label158:
    do
    {
      do
      {
        return;
        n = localTroopManager.e(paramString);
        if (n >= paramQVipBigTroopExpiredConfig.mNotifyTipsPerDay) {
          break;
        }
        a(paramQQAppInterface, paramTroopChatPie, paramahqs, paramContext, localTroopManager, paramString, paramMessageRemindRsp, paramInt1, paramQVipBigTroopExpiredConfig, m, n, paramExpiredType);
        break;
      } while (m >= paramQVipBigTroopExpiredConfig.mNotifyDialogMaxCount);
      if (!VipUtils.a(n, paramInt1))
      {
        a(paramContext, localTroopManager, paramString, paramMessageRemindRsp, paramInt1, paramQVipBigTroopExpiredConfig, m, 0, paramExpiredType);
        return;
      }
      paramInt2 = localTroopManager.i(paramString);
    } while (paramInt2 >= paramQVipBigTroopExpiredConfig.mNotifyDialogPerDay);
    a(paramContext, localTroopManager, paramString, paramMessageRemindRsp, paramInt1, paramQVipBigTroopExpiredConfig, m, paramInt2, paramExpiredType);
  }
  
  protected static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, QVipBigTroopExpiredConfig paramQVipBigTroopExpiredConfig, MessageRemindRsp paramMessageRemindRsp, Context paramContext, TroopManager.ExpiredType paramExpiredType, TroopChatPie paramTroopChatPie, ahqs paramahqs)
  {
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
    if (VipUtils.a(localTroopManager.d(paramString), paramInt)) {}
    for (;;)
    {
      if ((localTroopManager.j(paramString)) && (VipUtils.a(localTroopManager.j(paramString), paramInt) >= paramQVipBigTroopExpiredConfig.mNotifyDialogExpiredIntervalDay))
      {
        a(paramExpiredType, paramQQAppInterface, paramContext, paramString, paramMessageRemindRsp);
        localTroopManager.k(paramString, paramInt);
      }
      return;
      if (localTroopManager.f(paramString) < paramQVipBigTroopExpiredConfig.mNotifyTipsMaxCloseCount)
      {
        if (paramTroopChatPie.a == null)
        {
          paramTroopChatPie.a = new ahpd(paramQQAppInterface, paramContext, paramahqs);
          paramahqs.a(paramTroopChatPie.a);
        }
        a(paramExpiredType, paramQQAppInterface, paramString, paramTroopChatPie, paramMessageRemindRsp, paramahqs);
        localTroopManager.e(paramString, paramInt);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2, nmf paramnmf)
  {
    oidb_0x787.Filter localFilter = new oidb_0x787.Filter();
    localFilter.uint32_special_title.set(0);
    localFilter.uint32_nick_name.set(0);
    localFilter.uint32_member_level_info_name.set(0);
    localFilter.uint32_member_level_info_uin.set(0);
    oidb_0x787.ReqBody localReqBody = new oidb_0x787.ReqBody();
    localReqBody.uint64_group_code.set(Long.parseLong(paramString));
    localReqBody.uint64_begin_uin.set(paramLong1);
    localReqBody.uint64_data_time.set(paramLong2);
    localReqBody.opt_filter.set(localFilter);
    nmb.b(paramQQAppInterface, paramnmf, localReqBody.toByteArray(), "OidbSvc.0x787_1", 1927, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    if ((paramJSONArray1 == null) || (paramJSONArray2 == null)) {
      return;
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp()).edit();
    localEditor.putString("troop_pobing_config_left_wording_" + paramString, paramJSONArray1.toString());
    localEditor.putString("troop_pobing_config_right_wording_" + paramString, paramJSONArray2.toString());
    localEditor.commit();
    a(paramQQAppInterface);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, List<String> paramList1, List<String> paramList2)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
    paramQQAppInterface = paramQQAppInterface.getCurrentUin();
    String str = ((SharedPreferences)localObject).getString("troop_pobing_config_left_wording_" + paramQQAppInterface, "");
    paramQQAppInterface = ((SharedPreferences)localObject).getString("troop_pobing_config_right_wording_" + paramQQAppInterface, "");
    int m;
    if (!TextUtils.isEmpty(str)) {
      try
      {
        localObject = new JSONArray(str);
        m = 0;
        while (m < ((JSONArray)localObject).length())
        {
          str = ((JSONArray)localObject).optString(m);
          if (!TextUtils.isEmpty(str)) {
            paramList1.add(str);
          }
          m += 1;
        }
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          return;
        }
      }
      catch (JSONException paramList1)
      {
        paramList1.printStackTrace();
      }
    } else {
      try
      {
        paramQQAppInterface = new JSONArray(paramQQAppInterface);
        m = 0;
        while (m < paramQQAppInterface.length())
        {
          paramList1 = paramQQAppInterface.optString(m);
          if (!TextUtils.isEmpty(paramList1)) {
            paramList2.add(paramList1);
          }
          m += 1;
        }
        return;
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  protected static void a(TroopManager.ExpiredType paramExpiredType, QQAppInterface paramQQAppInterface, Context paramContext, String paramString, MessageRemindRsp paramMessageRemindRsp)
  {
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
    switch (ancp.a[paramExpiredType.ordinal()])
    {
    default: 
      return;
    case 1: 
      VipUtils.a(paramContext, paramString, VipUtils.a((int)paramMessageRemindRsp.iSVIPExpiredTime, 7).toString(), amtj.a(2131714515), new ancq(localTroopManager, paramString), "0X8009E36", 2);
      bcef.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009E35", 2, 0, "", "", "", "");
      return;
    case 2: 
      VipUtils.a(paramContext, paramString, VipUtils.a((int)paramMessageRemindRsp.iGroupExpiredTime, 6).toString(), amtj.a(2131714552), new ancr(localTroopManager, paramString), "0X8009E36", 1);
      bcef.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009E35", 1, 0, "", "", "", "");
      return;
    }
    if (ancy.b(paramMessageRemindRsp.iGroupType)) {}
    for (int m = 13;; m = 14)
    {
      VipUtils.a(paramContext, paramString, VipUtils.a(0, m).toString(), amtj.a(2131714498), new ancs(localTroopManager, paramString, paramQQAppInterface), "0X800A57E", 1, true);
      bcef.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A57D", 0, 0, "", "", "", "");
      return;
    }
  }
  
  protected static void a(TroopManager.ExpiredType paramExpiredType, QQAppInterface paramQQAppInterface, String paramString, TroopChatPie paramTroopChatPie, MessageRemindRsp paramMessageRemindRsp, ahqs paramahqs)
  {
    switch (ancp.a[paramExpiredType.ordinal()])
    {
    default: 
      return;
    case 1: 
      paramTroopChatPie.a.a(paramString, VipUtils.a((int)paramMessageRemindRsp.iSVIPExpiredTime, 3), 1, 2);
      paramahqs.a(paramTroopChatPie.a, new Object[0]);
      bcef.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009E33", 2, 0, "", "", "", "");
      return;
    case 2: 
      paramTroopChatPie.a.a(paramString, VipUtils.a((int)paramMessageRemindRsp.iGroupExpiredTime, 2), 1, 1);
      paramahqs.a(paramTroopChatPie.a, new Object[0]);
      bcef.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009E33", 1, 0, "", "", "", "");
      return;
    }
    paramExpiredType = paramTroopChatPie.a;
    int n = paramMessageRemindRsp.iLhGroupExpiredTime;
    if (ancy.b(paramMessageRemindRsp.iGroupType)) {}
    for (int m = 11;; m = 12)
    {
      paramExpiredType.a(paramString, VipUtils.a(n, m), 1, 4);
      paramahqs.a(paramTroopChatPie.a, new Object[0]);
      bcef.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A57B", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void a(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder().append("onUpdateTroopGetMemberList(memberLimit), troopUin:").append(paramString).append(", mGetTroopMemberListTroops == null:");
      if (this.jdField_e_of_type_JavaUtilArrayList == null)
      {
        bool = true;
        QLog.i("Q.contacttab.troop", 2, bool);
      }
    }
    else
    {
      paramList = new ArrayList();
      paramList.add(paramString);
      if (this.jdField_e_of_type_JavaUtilArrayList != null) {
        break label89;
      }
      b(paramList);
    }
    label89:
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        do
        {
          return;
          bool = false;
          break;
        } while (this.jdField_e_of_type_JavaUtilArrayList.size() <= 0);
        localTroopInfo = (TroopInfo)this.jdField_e_of_type_JavaUtilArrayList.get(0);
      } while (!localTroopInfo.troopuin.equals(paramString));
      anca localanca = (anca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20);
      if (paramBoolean) {
        break label273;
      }
      paramInt1 = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (paramInt1 + 1);
      if (paramInt1 >= 3) {
        break label230;
      }
      localanca.a(true, localTroopInfo.troopuin, localTroopInfo.troopcode, 4);
    } while (!QLog.isColorLevel());
    QLog.w("Q.contacttab.troop", 2, "getTroopsMemberList(memberLimit), failed, retry mRetryGetTroopMemberListCount:" + this.jdField_a_of_type_Int + ", troopUin" + localTroopInfo.troopuin);
    return;
    label230:
    g(paramString);
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.contacttab.troop", 2, "notifyTroopMembersUpdate, troopUin:" + paramString);
      }
      j();
      return;
      label273:
      b(paramList);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong, nmf paramnmf)
  {
    oidb_cmd0x6ef.ReqBody localReqBody = new oidb_cmd0x6ef.ReqBody();
    localReqBody.gc.set(Long.parseLong(paramString1));
    localReqBody.event_id.set(paramString2);
    localReqBody.seq.set(paramLong);
    nmb.b(paramQQAppInterface, paramnmf, localReqBody.toByteArray(), "OidbSvc.0x6ef_0", 1775, 0);
    return false;
  }
  
  private boolean a(TroopInfo paramTroopInfo)
  {
    boolean bool1 = true;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("is_first_upgrade_to_500", 0);
    boolean bool2;
    bbgg localbbgg;
    if (i1 == 0)
    {
      bool2 = true;
      localbbgg = a(paramTroopInfo, bool2);
      if (localbbgg == null) {
        bool1 = false;
      }
      if ((!bool2) || (localbbgg == null)) {
        break label385;
      }
      if ((paramTroopInfo.wMemberNum <= localbbgg.jdField_a_of_type_Int) || (paramTroopInfo.wMemberNum >= localbbgg.b)) {
        break label307;
      }
      bool1 = true;
    }
    label385:
    for (;;)
    {
      label94:
      int n = 0;
      long l1 = anvg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopInfo.troopuin);
      bool2 = bool1;
      int m = n;
      if (bool1)
      {
        l1 = Math.abs(System.currentTimeMillis() - l1);
        if (!NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
          break label313;
        }
        if (l1 >= localbbgg.c * 3600000L) {
          break label382;
        }
        bool1 = false;
      }
      label163:
      label307:
      label313:
      label382:
      for (;;)
      {
        if ((bool1) && (l1 > localbbgg.c * 3600000L * 2L) && (l1 > 3600000L * localbbgg.d))
        {
          m = 1;
          bool2 = bool1;
        }
        for (;;)
        {
          bool1 = bool2;
          if (i1 == 2)
          {
            bool1 = bool2;
            if (bool2)
            {
              bool1 = bool2;
              if (m != 0) {}
            }
          }
          try
          {
            l1 = Long.valueOf(paramTroopInfo.troopuin).longValue();
            m = Calendar.getInstance().get(5);
            n = localbbgg.c / 24;
            bool1 = bool2;
            if (n != 0)
            {
              long l2 = n;
              bool1 = bool2;
              if (l1 % l2 != m % n) {
                bool1 = false;
              }
            }
          }
          catch (Exception paramTroopInfo)
          {
            do
            {
              bool1 = bool2;
            } while (!QLog.isColorLevel());
            QLog.w("Q.contacttab.troop", 2, String.format("needGetMemberListForFTS, except: %s", new Object[] { paramTroopInfo.getMessage() }));
            return bool2;
          }
          return bool1;
          bool2 = false;
          break;
          bool1 = false;
          break label94;
          if (l1 >= localbbgg.d * 3600000L) {
            break label382;
          }
          bool1 = false;
          break label163;
          bool2 = bool1;
          m = n;
        }
      }
    }
  }
  
  private boolean a(TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = a(paramTroopInfo);; paramBoolean = true)
    {
      if ((paramBoolean) && ((!QLog.isColorLevel()) || ((paramTroopInfo.mMemberNumSeq != paramTroopInfo.mOldMemberNumSeq) || (paramTroopInfo.mMemberNumSeq == -1L) || (paramTroopInfo.mMemberCardSeq != paramTroopInfo.mOldMemberCardSeq) || (paramTroopInfo.mMemberCardSeq == -1L))))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.contacttab.troop", 2, String.format("needGetMemberListForFTS, get troop: %s, wMemberNum: %d, mMemberNumSeq: %d mOldMemberNumSeq: %d, mMemberCardSeq: %d, mOldMemberCardSeq:%d", new Object[] { paramTroopInfo.troopuin, Integer.valueOf(paramTroopInfo.wMemberNum), Long.valueOf(paramTroopInfo.mMemberNumSeq), Long.valueOf(paramTroopInfo.mOldMemberNumSeq), Long.valueOf(paramTroopInfo.mMemberCardSeq), Long.valueOf(paramTroopInfo.mOldMemberCardSeq) }));
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.contacttab.troop", 2, String.format("needGetMemberListForFTS, ignore troop: %s, wMemberNum: %d, mMemberNumSeq: %d mOldMemberNumSeq: %d, mMemberCardSeq: %d, mOldMemberCardSeq:%d, overtime: %s", new Object[] { paramTroopInfo.troopuin, Integer.valueOf(paramTroopInfo.wMemberNum), Long.valueOf(paramTroopInfo.mMemberNumSeq), Long.valueOf(paramTroopInfo.mOldMemberNumSeq), Long.valueOf(paramTroopInfo.mMemberCardSeq), Long.valueOf(paramTroopInfo.mOldMemberCardSeq), Boolean.valueOf(paramBoolean) }));
      }
      return false;
    }
  }
  
  private ConcurrentHashMap<String, Entity> b()
  {
    int n = 0;
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(ShowExternalTroop.class, false, null, null, null, null, null, null);
      if (localArrayList != null) {}
      for (int m = localArrayList.size();; m = 0)
      {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new QQConcurrentHashMap(1015, m, 70);
        while (n < m)
        {
          ShowExternalTroop localShowExternalTroop = (ShowExternalTroop)localArrayList.get(n);
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(localShowExternalTroop.troopUin, localShowExternalTroop);
          n += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, "load mShowExternalTroopCache info: size = " + m);
      }
    }
    return this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  private void c(ArrayList<TroopInfo> paramArrayList)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      if (paramArrayList == null) {
        break label33;
      }
    }
    label33:
    for (int m = paramArrayList.size();; m = 0)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(m);
      if (paramArrayList != null) {
        break;
      }
      return;
    }
    HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
    for (;;)
    {
      try
      {
        localEntityTransaction.begin();
        m = 0;
        if (m < paramArrayList.size())
        {
          TroopInfo localTroopInfo = (TroopInfo)paramArrayList.get(m);
          if ((localTroopInfo == null) || (localHotChatManager.b(localTroopInfo.troopuin)) || ((localTroopInfo != null) && (localTroopInfo.troopuin == null) && (localTroopInfo.troopcode == null))) {
            break label270;
          }
          if ((localTroopInfo.troopcode == null) || (localTroopInfo.troopcode.length() <= 1))
          {
            Object localObject = (Entity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localTroopInfo.troopuin);
            if ((localObject != null) && ((localObject instanceof TroopInfo)))
            {
              localObject = (TroopInfo)localObject;
              if ((((TroopInfo)localObject).troopcode != null) && (((TroopInfo)localObject).troopcode.length() > 1)) {
                localTroopInfo.troopcode = ((TroopInfo)localObject).troopcode;
              }
            }
          }
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localTroopInfo.troopuin, localTroopInfo);
          a(localTroopInfo);
        }
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
        localEntityTransaction.end();
        i();
        return;
        localEntityTransaction.commit();
        localEntityTransaction.end();
        continue;
      }
      finally
      {
        localEntityTransaction.end();
      }
      label270:
      m += 1;
    }
  }
  
  private void d(List<TroopInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TroopInfo localTroopInfo = (TroopInfo)paramList.next();
        if ((localTroopInfo != null) && (!TextUtils.isEmpty(localTroopInfo.troopuin)) && (!"0".equals(localTroopInfo.troopuin)))
        {
          ProxyManager localProxyManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager();
          RecentUser localRecentUser = (RecentUser)localProxyManager.a().findRecentUserByUin(localTroopInfo.troopuin, 1);
          localRecentUser.displayName = localTroopInfo.getTroopName();
          if (localRecentUser.getStatus() == 1001) {
            localProxyManager.a().saveRecentUser(localRecentUser);
          }
        }
      }
    }
  }
  
  private void e(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      paramString1 = (LruCache)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString1);
    } while (paramString1 == null);
    paramString1.remove(paramString2);
  }
  
  private void h()
  {
    int n = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.troop", 2, "initTroopListCache begin");
    }
    localObject2 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(TroopInfo.class, false, null, null, null, null, null, null);
    if (localObject2 != null) {}
    ConcurrentHashMap localConcurrentHashMap;
    ArrayList localArrayList;
    for (int m = ((ArrayList)localObject2).size();; m = 0)
    {
      localConcurrentHashMap = new ConcurrentHashMap(m);
      if (localObject2 == null) {
        break label232;
      }
      localArrayList = new ArrayList();
      m = 0;
      while (m < ((ArrayList)localObject2).size())
      {
        TroopInfo localTroopInfo = (TroopInfo)((ArrayList)localObject2).get(m);
        if ((localTroopInfo.mCompareSpell == null) || (localTroopInfo.mCompareSpell.length() == 0))
        {
          ampx.a(localTroopInfo);
          localArrayList.add(localTroopInfo);
        }
        if (!TextUtils.isEmpty(localTroopInfo.troopuin)) {
          localConcurrentHashMap.put(localTroopInfo.troopuin, localTroopInfo);
        }
        m += 1;
      }
    }
    if (localArrayList.size() > 0) {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
    }
    try
    {
      ((EntityTransaction)localObject2).begin();
      m = n;
      while (m < localArrayList.size())
      {
        a((Entity)localArrayList.get(m));
        m += 1;
      }
      ((EntityTransaction)localObject2).commit();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ((EntityTransaction)localObject2).end();
      }
    }
    finally
    {
      ((EntityTransaction)localObject2).end();
    }
    localArrayList.clear();
    label232:
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(localConcurrentHashMap);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.troop", 2, "initTroopListCache end: " + localConcurrentHashMap.size());
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.troop", 2, "buildTroopUI begin: ");
    }
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      int m = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
      if (m > 0)
      {
        localArrayList.ensureCapacity(m);
        anca localanca = (anca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20);
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        while (localIterator.hasNext())
        {
          TroopInfo localTroopInfo = (TroopInfo)localIterator.next();
          if (localTroopInfo.eliminated != 1)
          {
            if ((localTroopInfo.mCompareSpell == null) || (localTroopInfo.mCompareSpell.length() == 0)) {
              ampx.a(localTroopInfo);
            }
            if (!localTroopInfo.isExited()) {
              localArrayList.add(localTroopInfo);
            }
            for (;;)
            {
              synchronized (this.jdField_a_of_type_JavaUtilList)
              {
                if ((localTroopInfo.isNewTroop()) && (!localTroopInfo.hasSetTroopHead()) && (!this.jdField_a_of_type_JavaUtilList.contains(localTroopInfo.troopuin)))
                {
                  localanca.g(localTroopInfo.troopuin, false);
                  this.jdField_a_of_type_JavaUtilList.add(localTroopInfo.troopuin);
                }
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.contacttab.", 2, String.format("buildTroopUI filter troop: %s, exitReason: %s", new Object[] { localTroopInfo.troopuin, Integer.valueOf(localTroopInfo.exitTroopReason) }));
              }
            }
          }
        }
        if (m > 1) {
          Collections.sort(localList2, ampx.a);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = localList2;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.troop", 2, "buildTroopUI end: " + localList2.size());
    }
  }
  
  private void j()
  {
    try
    {
      this.jdField_e_of_type_JavaUtilArrayList.remove(0);
      if (this.jdField_e_of_type_JavaUtilArrayList.size() > 0)
      {
        TroopInfo localTroopInfo = (TroopInfo)this.jdField_e_of_type_JavaUtilArrayList.get(0);
        this.jdField_a_of_type_Int = 0;
        ((anca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20)).a(true, localTroopInfo.troopuin, localTroopInfo.troopcode, 4);
        return;
      }
    }
    finally {}
    try
    {
      this.jdField_e_of_type_JavaUtilArrayList = null;
      return;
    }
    finally {}
  }
  
  private boolean m(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString));
  }
  
  private void o(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(paramString);
  }
  
  private void p(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
    i();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "deleteTroopWithoutDB tm->deleteTroop-->delete troop");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      for (;;)
      {
        return;
        bfdg.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        avnu.a().b(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().clearHistory(paramString, 1);
        b(paramString, true);
        ((anca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20)).notifyUI(63, true, paramString);
        f(paramString);
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().c(Long.parseLong(paramString)))
          {
            BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
            return;
          }
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.contacttab.", 2, "tm->deleteTroop-->NumberFormatException, troopUin:" + paramString);
  }
  
  public double a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.troopMemberDistance", 2, "getTroopMemberDiatanceToSelf, uin is null");
      }
    }
    do
    {
      return -100.0D;
      paramString1 = b(paramString1, paramString2);
    } while (paramString1 == null);
    return paramString1.distanceToSelf;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_troopManager", 0).getInt("uniqueTitleNewFlag", 0);
  }
  
  public int a(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    return localSharedPreferences.getInt("modify_troop_class_info_" + str + "_" + paramString, 0);
  }
  
  public long a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getLong("oldestUniqueTitleExpireTime", 0L);
  }
  
  public MessageRemindRsp a(String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 4).getString(jdField_c_of_type_JavaLangString, "");
    if (!TextUtils.isEmpty(paramString))
    {
      MessageRemindRsp localMessageRemindRsp = new MessageRemindRsp();
      localMessageRemindRsp.readFrom(new JceInputStream(Utils.hexStr2Bytes(paramString)));
      return localMessageRemindRsp;
    }
    return null;
  }
  
  public ancw a()
  {
    if (this.jdField_a_of_type_Ancw == null) {
      this.jdField_a_of_type_Ancw = new ancw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_Ancw;
  }
  
  public ancz a(String paramString1, String paramString2)
  {
    paramString1 = b(paramString1, paramString2);
    long l1 = 0L;
    if (paramString1 != null) {
      l1 = paramString1.gagTimeStamp;
    }
    return new ancz(this, paramString2, l1);
  }
  
  public Drawable a(int paramInt, String paramString)
  {
    andb localandb = new andb(this);
    localandb.jdField_a_of_type_Int = paramInt;
    localandb.jdField_a_of_type_JavaLangString = paramString;
    return (Drawable)this.jdField_d_of_type_AndroidSupportV4UtilLruCache.get(localandb);
  }
  
  public azwi a()
  {
    if (this.jdField_a_of_type_Azwi == null) {
      this.jdField_a_of_type_Azwi = new azwi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_Azwi;
  }
  
  public CommonlyUsedTroop a(String paramString)
  {
    return (CommonlyUsedTroop)a().get(paramString);
  }
  
  public HWTroopMemberCard a(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + "_" + paramString2;
    return (HWTroopMemberCard)this.jdField_c_of_type_AndroidSupportV4UtilLruCache.get(paramString1);
  }
  
  public MessageRecord a(String paramString1, String paramString2)
  {
    if (aync.a != null)
    {
      int n = aync.a.length;
      if (n > 0)
      {
        localObject = new StringBuilder();
        int m = 0;
        while (m < n)
        {
          ((StringBuilder)localObject).append(aync.a[m]);
          if (m < n - 1) {
            ((StringBuilder)localObject).append(" , ");
          }
          m += 1;
        }
      }
    }
    for (Object localObject = ((StringBuilder)localObject).toString();; localObject = null)
    {
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      paramString1 = localEntityManager.query(MessageRecord.class, MessageRecord.getTableName(paramString1, 1), false, String.format("shmsgseq < %d and senderuin = ? and extLong & 3 <> 3 and msgtype in (%s)", new Object[] { Long.valueOf(9223372036854775807L), localObject }), new String[] { paramString2 }, null, null, "shmsgseq DESC", String.valueOf(1));
      localEntityManager.close();
      if ((paramString1 == null) || (paramString1.isEmpty())) {
        return null;
      }
      return (MessageRecord)paramString1.get(0);
    }
  }
  
  public TroopMemberCard a(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + "_" + paramString2;
    return (TroopMemberCard)this.jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramString1);
  }
  
  public TroopInfo a(String paramString)
  {
    return a(paramString, false, false);
  }
  
  protected TroopInfo a(String paramString1, String paramString2)
  {
    TroopInfo localTroopInfo2 = b(paramString1);
    TroopInfo localTroopInfo1 = localTroopInfo2;
    if (localTroopInfo2 == null)
    {
      localTroopInfo1 = new TroopInfo();
      localTroopInfo1.troopuin = paramString1;
    }
    localTroopInfo1.troopname = paramString2;
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localTroopInfo1.troopuin))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localTroopInfo1.troopuin, localTroopInfo1);
    }
    ampx.a(localTroopInfo1);
    i();
    return localTroopInfo1;
  }
  
  public TroopInfo a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, true);
  }
  
  public TroopInfo a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "findTroopInfo, troopUin isEmpty:" + paramString);
      }
      localObject1 = null;
    }
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        localObject2 = (TroopInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Boolean)
          {
            localObject1 = localObject2;
            if (paramBoolean2)
            {
              localObject2 = (TroopInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(TroopInfo.class, paramString);
              localObject1 = localObject2;
              if (localObject2 != null)
              {
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject2);
                localObject1 = localObject2;
              }
            }
          }
        }
        localObject2 = localObject1;
        if (!paramBoolean1)
        {
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (((TroopInfo)localObject1).isExited()) {
              localObject2 = null;
            }
          }
        }
        localObject1 = localObject2;
      } while (localObject2 != null);
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("Q.contacttab.", 2, String.format("findTroopInfo is null , troopUin: %s, containExited: %s, findDB: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    return localObject2;
  }
  
  public TroopMemberInfo a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    paramString1 = (LruCache)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString1);
    if (paramString1 == null) {
      return null;
    }
    return (TroopMemberInfo)paramString1.get(paramString2);
  }
  
  public EntityTransaction a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
  }
  
  public TroopNameHelper a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper = new TroopNameHelper();
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper;
  }
  
  public String a(TroopMemberInfo paramTroopMemberInfo)
  {
    if (paramTroopMemberInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "getTroopMemberName tmi == null");
      }
      localObject1 = "";
      return localObject1;
    }
    Object localObject1 = ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(paramTroopMemberInfo.memberuin);
    if ((localObject1 != null) && (((Friends)localObject1).isFriend()) && (!TextUtils.isEmpty(((Friends)localObject1).remark))) {
      localObject1 = ((Friends)localObject1).remark;
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramTroopMemberInfo.memberuin;
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        break;
      }
      localObject1 = localObject2;
      if (!((String)localObject2).equals(paramTroopMemberInfo.memberuin)) {
        break;
      }
      paramTroopMemberInfo = b(paramTroopMemberInfo.troopuin);
      localObject1 = localObject2;
      if (paramTroopMemberInfo == null) {
        break;
      }
      localObject1 = localObject2;
      if (!paramTroopMemberInfo.isQidianPrivateTroop()) {
        break;
      }
      return TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
      if (!TextUtils.isEmpty(paramTroopMemberInfo.troopnick)) {
        localObject1 = paramTroopMemberInfo.troopnick;
      } else if ((localObject1 != null) && (((Friends)localObject1).isFriend())) {
        localObject1 = ((Friends)localObject1).name;
      } else if (!TextUtils.isEmpty(paramTroopMemberInfo.autoremark)) {
        localObject1 = paramTroopMemberInfo.autoremark;
      } else {
        localObject1 = paramTroopMemberInfo.friendnick;
      }
    }
  }
  
  public String a(String paramString)
  {
    TroopInfo localTroopInfo = b(paramString);
    String str = paramString;
    if (localTroopInfo != null)
    {
      str = paramString;
      if (localTroopInfo.getTroopName() != null) {
        str = localTroopInfo.getTroopName();
      }
    }
    return str;
  }
  
  public String a(String paramString1, String paramString2)
  {
    return ContactUtils.getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
  }
  
  public ArrayList<Entity> a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Entity localEntity = (Entity)localIterator.next();
        if (!((TroopInfo)localEntity).isTroopBlocked) {
          localArrayList.add(localEntity);
        }
      }
    }
    return localArrayList;
  }
  
  public ArrayList<TroopMemberInfo> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    paramString = (LruCache)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.snapshot();
      if (paramString != null)
      {
        paramString = paramString.values().iterator();
        while (paramString.hasNext())
        {
          TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramString.next();
          if ((localTroopMemberInfo != null) && (!TextUtils.isEmpty(localTroopMemberInfo.memberuin))) {
            localArrayList.add(localTroopMemberInfo);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public List<CommonlyUsedTroop> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a().values().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((CommonlyUsedTroop)localIterator.next());
    }
    return localArrayList;
  }
  
  public List<TroopNotificationCache> a(String paramString)
  {
    if ((paramString == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    ArrayList localArrayList;
    do
    {
      return null;
      localArrayList = new ArrayList();
      paramString = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(TroopNotificationCache.class, true, "troopUin=? and read=? and currentUin=?", new String[] { paramString, "0", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }, null, null, "time ASC", null);
    } while (paramString == null);
    HashMap localHashMap = new HashMap();
    int m = 0;
    if (m < paramString.size())
    {
      TroopNotificationCache localTroopNotificationCache = (TroopNotificationCache)paramString.get(m);
      if (localHashMap.containsKey(localTroopNotificationCache.feedsId)) {}
      for (;;)
      {
        m += 1;
        break;
        localArrayList.add(localTroopNotificationCache);
        localHashMap.put(localTroopNotificationCache.feedsId, Integer.valueOf(1));
      }
    }
    return localArrayList;
  }
  
  public List<TroopMemberInfo> a(String paramString, List<TroopMemberInfo> paramList)
  {
    int i1 = 0;
    Object localObject1;
    int m;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("enhanceTroopMemberList before troopUin = ").append(paramString).append("  memberList.size:");
      if (paramList != null)
      {
        m = paramList.size();
        QLog.d("Q.contacttab.", 2, m);
      }
    }
    else
    {
      if (paramList != null)
      {
        localObject2 = paramList;
        if (paramList.size() >= 6) {
          break label238;
        }
      }
      ArrayList localArrayList = a(paramString);
      localObject2 = paramList;
      if (localArrayList.isEmpty()) {
        break label238;
      }
      localObject1 = paramList;
      if (paramList == null) {
        localObject1 = new ArrayList();
      }
      m = 0;
      label117:
      localObject2 = localObject1;
      if (m >= localArrayList.size()) {
        break label238;
      }
      localObject2 = localObject1;
      if (m >= 6) {
        break label238;
      }
      paramList = (TroopMemberInfo)localArrayList.get(m);
      localObject2 = ((List)localObject1).iterator();
      TroopMemberInfo localTroopMemberInfo;
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localTroopMemberInfo = (TroopMemberInfo)((Iterator)localObject2).next();
      } while ((localTroopMemberInfo == null) || (paramList == null) || (!TextUtils.equals(localTroopMemberInfo.memberuin, paramList.memberuin)));
    }
    for (int n = 1;; n = 0)
    {
      if (n == 0) {
        ((List)localObject1).add(paramList);
      }
      m += 1;
      break label117;
      m = 0;
      break;
      label238:
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("enhanceTroopMemberList after troopUin = ").append(paramString).append("  memberList.size:");
        m = i1;
        if (localObject2 != null) {
          m = ((List)localObject2).size();
        }
        QLog.d("Q.contacttab.", 2, m);
      }
      return localObject2;
    }
  }
  
  public oidb_cmd0xb36.ToastInfo a(String paramString)
  {
    yos.a(paramString);
    if (paramString == null) {
      return null;
    }
    paramString = (oidb_cmd0xb36.RspBody)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((paramString != null) && (paramString.toast.has())) {
      return paramString.toast;
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.survey", 2, "[TroopManager]scheduleFetchExpiredSurveyList()");
    }
    int m = (int)NetConnInfoCenter.getServerTime();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    long l1;
    for (long l2 = 2147483647L; localIterator.hasNext(); l2 = l1)
    {
      oidb_cmd0xb36.RspBody localRspBody = (oidb_cmd0xb36.RspBody)localIterator.next();
      l1 = l2;
      if (localRspBody.toast.has())
      {
        l1 = l2;
        if (localRspBody.toast.expired.has())
        {
          int n = localRspBody.toast.expired.get();
          l1 = l2;
          if (n > m)
          {
            l2 = Math.max(60L, Math.min(l2, n - m));
            l1 = l2;
            if (QLog.isColorLevel())
            {
              QLog.d(".troop.survey", 2, new Object[] { "survey id=", Long.valueOf(localRspBody.toast.id.get()), " not expired, will schedule request in ", Long.valueOf(l2), " seconds" });
              l1 = l2;
            }
          }
        }
      }
    }
    if (l2 != 2147483647L)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.survey", 2, new Object[] { "Will request survey toast info in ", Long.valueOf(l2), " seconds!" });
      }
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, Math.min(l2 * 1000L, 2147483647L));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(".troop.survey", 2, String.valueOf(this.jdField_a_of_type_JavaUtilMap.size()) + " surveys, all of them expired");
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_troopManager", 0).edit().putInt("uniqueTitleNewFlag", paramInt).commit();
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilQueue.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramInt == ((Integer)((Iterator)localObject).next()).intValue())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.contacttab.", 4, String.format("Discard message", new Object[0]));
        }
        return;
      }
    }
    if (this.jdField_a_of_type_JavaUtilQueue.size() > 30) {
      this.jdField_a_of_type_JavaUtilQueue.poll();
    }
    this.jdField_a_of_type_JavaUtilQueue.offer(Integer.valueOf(paramInt));
    String str = String.valueOf(paramLong1);
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    TroopInfo localTroopInfo = localTroopManager.b(String.valueOf(paramLong1));
    localObject = localTroopInfo;
    if (localTroopInfo == null)
    {
      localObject = new TroopInfo();
      ((TroopInfo)localObject).troopuin = str;
    }
    if ((((TroopInfo)localObject).troopPrivilegeFlag & paramLong3) != (paramLong4 & paramLong3)) {
      if ((paramLong4 & paramLong3) != paramLong3) {
        break label220;
      }
    }
    label220:
    for (((TroopInfo)localObject).troopPrivilegeFlag &= paramLong3;; ((TroopInfo)localObject).troopPrivilegeFlag &= (0xFFFFFFFF ^ paramLong3))
    {
      localTroopManager.b((TroopInfo)localObject);
      a(str, paramLong2, paramInt, paramLong3, paramLong4, paramString);
      return;
    }
  }
  
  public void a(int paramInt, String paramString, Drawable paramDrawable)
  {
    andb localandb = new andb(this);
    localandb.jdField_a_of_type_Int = paramInt;
    localandb.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_d_of_type_AndroidSupportV4UtilLruCache.put(localandb, paramDrawable);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "markGroupSystemMsgProcessed troopCode:" + paramLong1 + " msgTime:" + paramLong2);
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {
      return;
    }
    n(String.format("%s_%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
  }
  
  public void a(andc paramandc)
  {
    try
    {
      this.jdField_f_of_type_JavaUtilArrayList.add(paramandc);
      return;
    }
    finally
    {
      paramandc = finally;
      throw paramandc;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, apte paramapte)
  {
    if ((paramapte != null) && ("batch_add_friend_for_troop_config".equals(paramString))) {
      a().a(paramapte.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(TroopManager.SaveTroopMemberTask paramSaveTroopMemberTask)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramSaveTroopMemberTask);
    c();
  }
  
  public void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {
      return;
    }
    k(paramTroopInfo.troopuin);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramTroopInfo.troopuin))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramTroopInfo.troopuin, paramTroopInfo);
    }
    a(paramTroopInfo);
    i();
  }
  
  public void a(TroopInfo paramTroopInfo, long paramLong)
  {
    if (paramTroopInfo == null) {}
    ProxyManager localProxyManager;
    RecentUser localRecentUser;
    do
    {
      return;
      localProxyManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager();
      localRecentUser = (RecentUser)localProxyManager.a().findRecentUserByUin(paramTroopInfo.troopuin, 1);
      localRecentUser.displayName = paramTroopInfo.getTroopName();
    } while (localRecentUser.getStatus() != 1000);
    localRecentUser.lastmsgtime = paramLong;
    awhn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser);
    localProxyManager.a().saveRecentUser(localRecentUser);
    ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(0)).notifyUI(6003, true, new String[] { paramTroopInfo.troopuin, "0" });
  }
  
  public void a(TroopMemberInfo paramTroopMemberInfo, boolean paramBoolean)
  {
    if (paramTroopMemberInfo.getStatus() == 1000) {
      a(paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin, paramTroopMemberInfo);
    }
    a(new TroopManager.SaveTroopMemberTask(this, paramTroopMemberInfo, paramBoolean));
  }
  
  public void a(String paramString)
  {
    a(paramString, false);
  }
  
  public void a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    paramString = "modify_troop_class_info_" + str + "_" + paramString;
    localSharedPreferences.edit().putInt(paramString, paramInt).apply();
  }
  
  public void a(String paramString, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putLong("oldestUniqueTitleExpireTime", paramLong).commit();
  }
  
  public void a(String paramString1, long paramLong1, int paramInt, long paramLong2, long paramLong3, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "----------addTroopPrivilegeTipsMr troopUin: " + paramString1);
    }
    if (TextUtils.isEmpty(paramString2)) {
      if ((1L & paramLong2) == 1L) {
        if ((1L & paramLong3) == 1L) {
          paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131697140);
        }
      }
    }
    for (;;)
    {
      MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)bbli.a(-1013);
      localMessageForGrayTips.frienduin = paramString1;
      localMessageForGrayTips.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1, paramString1, paramString2, paramLong1, -1013, 1, paramInt);
      localMessageForGrayTips.isread = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage(localMessageForGrayTips, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131697141);
      continue;
      if ((0x2 & paramLong2) == 2L) {
        if ((0x2 & paramLong3) == 2L) {
          paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131697138);
        } else {
          paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131697139);
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    String str = "";
    if (paramInt == 131081) {
      str = amtj.a(2131714514);
    }
    long l1;
    do
    {
      while (TextUtils.isEmpty(str))
      {
        return;
        if (paramInt == 131080) {
          str = amtj.a(2131714531);
        }
      }
      Object localObject = new aucf(paramString, paramString, str, 1, -5040, paramInt, paramLong1);
      MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
      localMessageForUniteGrayTip.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (aucf)localObject);
      localMessageForUniteGrayTip.isread = true;
      l1 = paramLong2;
      if (paramLong2 == 0L)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(paramString, 1);
        if (localObject != null) {
          paramLong2 = ((QQMessageFacade.Message)localObject).shmsgseq;
        }
        l1 = paramLong2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.contacttab.", 2, String.format("addAIOGrayTips, shmsgseq: %s, msgseq: %s", new Object[] { Long.valueOf(((QQMessageFacade.Message)localObject).shmsgseq), Long.valueOf(((QQMessageFacade.Message)localObject).msgseq) }));
          l1 = paramLong2;
        }
      }
      localMessageForUniteGrayTip.shmsgseq = l1;
      aucg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForUniteGrayTip);
    } while (!QLog.isColorLevel());
    QLog.d("Q.contacttab.", 2, String.format("addAIOGrayTips, troopUin: %s, msgTime: %s, wording: %s, msgSeq: %s", new Object[] { paramString, Long.valueOf(paramLong1), str, Long.valueOf(l1) }));
  }
  
  public void a(String paramString, MessageRemindRsp paramMessageRemindRsp)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0);
    c(paramString, (int)paramMessageRemindRsp.iNextReqTime);
    localSharedPreferences.edit().putString(jdField_c_of_type_JavaLangString, Utils.bytes2HexStr(paramMessageRemindRsp.toByteArray())).commit();
  }
  
  public void a(String paramString, ancv paramancv)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramancv == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "getTroopCodeByTroopUinAsync, param is empty");
      }
      return;
    }
    ThreadManager.post(new TroopManager.12(this, paramString, paramancv), 8, null, false);
  }
  
  public void a(String paramString, Boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putBoolean(j, paramBoolean.booleanValue()).commit();
  }
  
  public void a(String paramString1, String paramString2)
  {
    int m = 0;
    while (m < this.jdField_f_of_type_JavaUtilArrayList.size())
    {
      ((andc)this.jdField_f_of_type_JavaUtilArrayList.get(m)).b(paramString1, paramString2);
      m += 1;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      QLog.e("Q.contacttab.", 1, "handleMemberExitTroop, troopUin or memberUin is empty");
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, String.format("handleMemberExitTroop, troopUin: %s, memberUin: %s, type: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
      }
      if (((paramInt == 1) || (paramInt == 3)) && (paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        a(paramString1, paramString2, false);
      }
      while (paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        ((bfbz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(paramString1);
        return;
        a(paramString1, paramString2, true);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    ProxyManager localProxyManager;
    RecentUser localRecentUser;
    do
    {
      return;
      localProxyManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager();
      localRecentUser = (RecentUser)localProxyManager.a().findRecentUserByUin(paramString1, 1);
      localRecentUser.displayName = paramString2;
    } while (localRecentUser.getStatus() != 1000);
    localRecentUser.lastmsgtime = paramLong;
    awhn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser);
    localProxyManager.a().saveRecentUser(localRecentUser);
    ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(0)).notifyUI(6003, true, new String[] { paramString1, "0" });
  }
  
  public void a(String paramString1, String paramString2, ancx paramancx)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      if (paramancx != null)
      {
        localObject = a(paramString1, paramString2);
        if (localObject == null) {
          break label35;
        }
        paramancx.a((TroopMemberInfo)localObject);
      }
    }
    label35:
    do
    {
      return;
      paramancx.a(c(paramString1, paramString2));
      return;
      List localList = (List)this.jdField_b_of_type_JavaUtilMap.get(paramString1 + "_" + paramString2);
      localObject = localList;
      if (localList != null) {
        break label166;
      }
      localObject = a(paramString1, paramString2);
      if (localObject == null) {
        break;
      }
    } while (paramancx == null);
    paramancx.a((TroopMemberInfo)localObject);
    return;
    Object localObject = new ArrayList();
    this.jdField_b_of_type_JavaUtilMap.put(paramString1 + "_" + paramString2, localObject);
    label166:
    if (((List)localObject).isEmpty())
    {
      ((List)localObject).add(new WeakReference(paramancx));
      bfda.a(new TroopManager.10(this, paramString1, paramString2));
      return;
    }
    ((List)localObject).add(new WeakReference(paramancx));
  }
  
  public void a(String paramString1, String paramString2, HWTroopMemberCard paramHWTroopMemberCard)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramHWTroopMemberCard != null))
    {
      paramString1 = paramString1 + "_" + paramString2;
      this.jdField_c_of_type_AndroidSupportV4UtilLruCache.put(paramString1, paramHWTroopMemberCard);
    }
  }
  
  public void a(String paramString1, String paramString2, TroopMemberInfo paramTroopMemberInfo)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    LruCache localLruCache2 = (LruCache)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString1);
    LruCache localLruCache1 = localLruCache2;
    if (localLruCache2 == null) {
      localLruCache1 = new LruCache(48);
    }
    localLruCache1.put(paramString2, paramTroopMemberInfo);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString1, localLruCache1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    ThreadManager.post(new TroopManager.13(this, paramString1, paramString2, paramString3), 8, null, true);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    TroopMemberInfo localTroopMemberInfo2 = b(paramString1, paramString2);
    TroopMemberInfo localTroopMemberInfo1 = localTroopMemberInfo2;
    if (localTroopMemberInfo2 == null)
    {
      localTroopMemberInfo1 = new TroopMemberInfo();
      localTroopMemberInfo1.memberuin = paramString2;
      localTroopMemberInfo1.troopuin = paramString1;
    }
    localTroopMemberInfo1.mUniqueTitle = paramString3;
    localTroopMemberInfo1.mUniqueTitleExpire = paramInt;
    paramString3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (localTroopMemberInfo1.getStatus() == 1000)
    {
      a(paramString1, paramString2, localTroopMemberInfo1);
      paramString3.persistOrReplace(localTroopMemberInfo1);
    }
    for (;;)
    {
      paramString3.close();
      a(paramString1, paramString2, false);
      return;
      paramString3.update(localTroopMemberInfo1);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    int i1 = 1;
    TroopMemberInfo localTroopMemberInfo = b(paramString1, paramString2);
    if (localTroopMemberInfo == null)
    {
      localTroopMemberInfo = new TroopMemberInfo();
      localTroopMemberInfo.memberuin = paramString2;
      localTroopMemberInfo.troopuin = paramString1;
    }
    for (;;)
    {
      int n = 0;
      int m = n;
      if (paramString3 != null)
      {
        m = n;
        if (!TextUtils.equals(paramString3, localTroopMemberInfo.mUniqueTitle))
        {
          localTroopMemberInfo.mUniqueTitle = paramString3;
          m = 1;
        }
      }
      n = m;
      if (paramInt1 != 0)
      {
        n = m;
        if (localTroopMemberInfo.realLevel != paramInt1)
        {
          localTroopMemberInfo.realLevel = paramInt1;
          n = 1;
        }
      }
      if (localTroopMemberInfo.newRealLevel != paramInt2) {
        localTroopMemberInfo.newRealLevel = paramInt2;
      }
      for (paramInt1 = i1;; paramInt1 = n)
      {
        if (paramInt1 != 0)
        {
          if (localTroopMemberInfo.getStatus() == 1000) {
            a(paramString1, paramString2, localTroopMemberInfo);
          }
          b(paramString1, paramString2, localTroopMemberInfo);
        }
        return;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    int n = 1;
    TroopMemberInfo localTroopMemberInfo = b(paramString1, paramString2);
    if (localTroopMemberInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "saveHomeworkTroopMemberIdentity , info is null ... ");
      }
    }
    for (;;)
    {
      return;
      TroopMemberCardInfo localTroopMemberCardInfo = bfun.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
      int m = 0;
      int i1 = 0;
      if (paramInt != -100)
      {
        m = i1;
        if (paramInt != localTroopMemberInfo.hwIdentity)
        {
          localTroopMemberInfo.hwIdentity = paramInt;
          m = 1;
        }
        if (paramInt != localTroopMemberInfo.level)
        {
          localTroopMemberInfo.level = paramInt;
          if ((localTroopMemberCardInfo != null) && (!TextUtils.equals(String.valueOf(paramInt), localTroopMemberCardInfo.level))) {
            localTroopMemberCardInfo.level = String.valueOf(paramInt);
          }
          m = 1;
        }
      }
      paramInt = m;
      if (!TextUtils.isEmpty(paramString4))
      {
        paramInt = m;
        if (!paramString4.equals(localTroopMemberInfo.hwCourse))
        {
          localTroopMemberInfo.hwCourse = paramString4;
          paramInt = 1;
        }
      }
      m = paramInt;
      if (!TextUtils.isEmpty(paramString5))
      {
        m = paramInt;
        if (!paramString5.equals(localTroopMemberInfo.hwName))
        {
          localTroopMemberInfo.hwName = paramString5;
          m = 1;
        }
      }
      if ((paramString3 != null) && (!paramString3.equals(localTroopMemberInfo.troopnick)))
      {
        localTroopMemberInfo.troopnick = paramString3;
        paramInt = n;
        if (localTroopMemberCardInfo != null)
        {
          paramInt = n;
          if (!TextUtils.equals(paramString3, localTroopMemberCardInfo.name)) {
            localTroopMemberCardInfo.name = paramString3;
          }
        }
      }
      for (paramInt = n; paramInt != 0; paramInt = m)
      {
        if (localTroopMemberInfo.getStatus() == 1000) {
          a(paramString1, paramString2, localTroopMemberInfo);
        }
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localTroopMemberInfo.getStatus() == 1000)
        {
          paramString1.persistOrReplace(localTroopMemberInfo);
          if (localTroopMemberCardInfo != null) {
            paramString1.persistOrReplace(localTroopMemberCardInfo);
          }
        }
        for (;;)
        {
          paramString1.close();
          return;
          paramString1.update(localTroopMemberInfo);
          if (localTroopMemberCardInfo != null) {
            paramString1.update(localTroopMemberCardInfo);
          }
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString1, 0).edit().putBoolean(paramString2, paramBoolean).commit();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    TroopInfo localTroopInfo = a(paramString, paramBoolean);
    if (localTroopInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, "deleteTroop  troopinfo is null,troopUin = " + paramString);
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, String.format("deleteTroop, troopUin: %s, exitTroopReason: %s, isDelExit: %s", new Object[] { paramString, Integer.valueOf(localTroopInfo.exitTroopReason), Boolean.valueOf(paramBoolean) }));
      }
      a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localTroopInfo);
      p(paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
      try
      {
        ((awas)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(329)).a(Long.parseLong(paramString), null);
        if (!QLog.isDebugVersion()) {
          continue;
        }
        QLog.d("Q.contacttab.", 2, "deleteTroop", new Throwable("debug"));
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isDebugVersion()) {
            QLog.d("Q.contacttab.", 2, new Object[] { "deleteTroopRecommendUinList ", paramString.toString() });
          }
        }
      }
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putString("troop_app_list_data", bfuc.encodeToString(paramArrayOfByte, 2)).commit();
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject1 = new troop_honor.HonorChangeGrayTipsReserved();
        ((troop_honor.HonorChangeGrayTipsReserved)localObject1).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((troop_honor.HonorChangeGrayTipsReserved)localObject1).user_honor.get();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
          continue;
        }
        paramArrayOfByte = paramArrayOfByte.iterator();
        while (paramArrayOfByte.hasNext())
        {
          Object localObject2 = (troop_honor.UserHonor)paramArrayOfByte.next();
          if ((((troop_honor.UserHonor)localObject2).uin.has()) && (((troop_honor.UserHonor)localObject2).level.has()))
          {
            localObject1 = String.valueOf(((troop_honor.UserHonor)localObject2).uin.get());
            int m = ((troop_honor.UserHonor)localObject2).level.get();
            localObject2 = new anda(this, null);
            ((anda)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
            ((anda)localObject2).jdField_b_of_type_JavaLangString = paramString;
            ((anda)localObject2).jdField_a_of_type_Int = m;
            a(paramString, (String)localObject1, (ancx)localObject2);
            if (QLog.isColorLevel()) {
              QLog.d("Q.contacttab.", 2, String.format("handleTroopMemberNewLevelChange, pushType: %s, troopUin: %s, memberUin: %s, newRealLevel: %s", new Object[] { Integer.valueOf(paramInt), paramString, localObject1, Integer.valueOf(m) }));
            }
          }
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramString)
      {
        paramString.printStackTrace();
        QLog.d("Q.contacttab.", 1, "handleTroopMemberNewLevelChange", paramString);
      }
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    bjun.a("queryTroops_" + paramArrayList.size());
    if (paramArrayList.size() > 0)
    {
      Object localObject = new StringBuilder("troopuin=? ");
      int m = 1;
      while (m < paramArrayList.size())
      {
        ((StringBuilder)localObject).append("or troopuin=? ");
        m += 1;
      }
      paramArrayList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(TroopInfo.class, true, ((StringBuilder)localObject).toString(), (String[])paramArrayList.toArray(new String[paramArrayList.size()]), null, null, null, null);
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localObject = (TroopInfo)paramArrayList.next();
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((TroopInfo)localObject).troopuin, localObject);
        }
      }
    }
    bjun.a();
  }
  
  public void a(ArrayList<TroopInfo> paramArrayList, long paramLong)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    c(paramArrayList);
    i();
  }
  
  public void a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, "deleteTroopList, uins is empty");
      }
      return;
    }
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localEntityTransaction.begin();
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        Iterator localIterator = paramList.iterator();
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        if (localIterator.hasNext())
        {
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          str = (String)localIterator.next();
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          TroopInfo localTroopInfo = b(str);
          if (localTroopInfo != null)
          {
            localObject1 = localEntityTransaction;
            localObject2 = localEntityTransaction;
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localTroopInfo);
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        String str;
        localObject2 = localObject1;
        localException.printStackTrace();
        localObject2 = localObject1;
        QLog.e("Q.contacttab.", 1, "deleteTroopList exception: " + localException.getMessage());
        if (localObject1 != null) {
          ((EntityTransaction)localObject1).end();
        }
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        localObject1 = (String)paramList.next();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        p((String)localObject1);
        continue;
        localObject1 = localException;
        localObject2 = localException;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject1 = localException;
        localObject2 = localException;
        QLog.d("Q.contacttab.", 2, String.format("deleteTroopList, troopUin: %s, troopInfo is empty", new Object[] { str }));
        continue;
      }
      finally
      {
        if (localObject2 != null) {
          localObject2.end();
        }
      }
      localObject1 = localException;
      localObject2 = localException;
      localException.commit();
      if (localException != null) {
        localException.end();
      }
    }
  }
  
  public void a(Map<String, Long> paramMap)
  {
    this.jdField_c_of_type_JavaUtilMap = paramMap;
  }
  
  public void a(oidb_cmd0xb36.RspBody paramRspBody)
  {
    if ((paramRspBody == null) || (!paramRspBody.group_id.has())) {
      if (paramRspBody == null) {
        QLog.e(".troop.survey", 1, "[TroopManager]updateTroopSurveyList() body is null!");
      }
    }
    for (;;)
    {
      a();
      return;
      QLog.e(".troop.survey", 1, new Object[] { "[TroopManager]updateTroopSurveyList() IllegaleArgument! body is :", yps.a(paramRspBody) });
      continue;
      if (QLog.isColorLevel()) {
        QLog.d(".troop.survey", 2, new Object[] { "[TroopManager]updateTroopSurveyList() body ready!", yps.a(paramRspBody) });
      }
      this.jdField_a_of_type_JavaUtilMap.put(String.valueOf(paramRspBody.group_id.get()), paramRspBody);
    }
  }
  
  public void a(structmsg.StructMsg paramStructMsg)
  {
    if (paramStructMsg == null) {
      QLog.e("Q.contacttab.", 1, "handlePassiveExitTroop groupMsg == null");
    }
    String str;
    int n;
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        return;
        str = String.valueOf(paramStructMsg.msg.group_code.get());
        n = paramStructMsg.msg.group_msg_type.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.", 2, String.format("handlePassiveExitTroop, troopUin: %s, msgType: %s", new Object[] { str, Integer.valueOf(n) }));
        }
      } while (TextUtils.isEmpty(str));
      localTroopInfo = a(str, true);
      if (localTroopInfo == null)
      {
        QLog.e("Q.contacttab.", 1, "handlePassiveExitTroop, troopInfo == null");
        return;
      }
      if (!localTroopInfo.isExited()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.contacttab.", 2, "handlePassiveExitTroop, exitReason is no default ");
    return;
    long l1 = localTroopInfo.dwCmdUinJoinTime;
    long l2 = paramStructMsg.msg_time.get();
    int m;
    if (l1 < l2)
    {
      m = -1;
      a(str);
      bfun.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      bfdg.a(str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      i();
      ((awas)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(329)).a(paramStructMsg.msg.group_code.get(), null);
      if (n != 8) {
        break label416;
      }
      localTroopInfo.exitTroopReason = 2;
      b(localTroopInfo);
      a(str, paramStructMsg.msg_time.get(), 0L, 131081);
      m = 2;
    }
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().c(Long.parseLong(str));
        if (bool) {
          BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.", 2, "handlePassiveExitTroop, hasTroopVideo: " + bool);
        }
      }
      catch (Exception paramStructMsg)
      {
        label416:
        QLog.e("Q.contacttab.", 2, "handlePassiveExitTroop, excption:" + paramStructMsg.getMessage());
        continue;
      }
      ((anca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20)).notifyUI(126, true, new Object[] { str, Integer.valueOf(m) });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.contacttab.", 2, String.format("handlePassiveExit push joinTime: %s, msgTime: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
      return;
      if (n == 7)
      {
        localTroopInfo.exitTroopReason = 1;
        b(localTroopInfo);
        a(str, paramStructMsg.msg_time.get(), 0L, 131080);
        m = 1;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, "setTroopConfessPanelOpen flag: " + paramBoolean);
      }
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)) {}
    ArrayList localArrayList;
    do
    {
      return false;
      localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(TroopInfo.class, false, null, null, null, null, null, String.valueOf("1"));
    } while ((localArrayList != null) && (localArrayList.size() > 0));
    return true;
  }
  
  protected boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 != -100)
    {
      bool1 = bool2;
      if (paramInt1 != paramTroopMemberInfo.mBigClubVipType)
      {
        paramTroopMemberInfo.mBigClubVipType = paramInt1;
        bool1 = true;
      }
    }
    bool2 = bool1;
    if (paramInt2 != -100)
    {
      bool2 = bool1;
      if (paramInt2 != paramTroopMemberInfo.mBigClubVipLevel)
      {
        paramTroopMemberInfo.mBigClubVipLevel = paramInt2;
        bool2 = true;
      }
    }
    bool1 = bool2;
    if (paramInt3 != -100)
    {
      bool1 = bool2;
      if (paramInt3 != paramTroopMemberInfo.mBigClubTemplateId)
      {
        paramTroopMemberInfo.mBigClubTemplateId = paramInt3;
        bool1 = true;
      }
    }
    if ((paramInt4 != -100) && (paramInt4 != paramTroopMemberInfo.mIsHideBigClub))
    {
      paramTroopMemberInfo.mIsHideBigClub = paramInt4;
      return true;
    }
    return bool1;
  }
  
  protected boolean a(int paramInt1, int paramInt2, TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 != -100)
    {
      bool1 = bool2;
      if (paramInt1 != paramTroopMemberInfo.mVipType)
      {
        paramTroopMemberInfo.mVipType = paramInt1;
        bool1 = true;
      }
    }
    if ((paramInt2 != -100) && (paramInt2 != paramTroopMemberInfo.mVipLevel))
    {
      paramTroopMemberInfo.mVipLevel = paramInt2;
      return true;
    }
    return bool1;
  }
  
  protected boolean a(long paramLong, int paramInt1, int paramInt2, int paramInt3, TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool2 = false;
    if (paramLong != -100L) {
      paramTroopMemberInfo.msgseq = paramLong;
    }
    boolean bool1 = bool2;
    if (paramInt1 != -100)
    {
      bool1 = bool2;
      if (paramInt1 != paramTroopMemberInfo.age)
      {
        paramTroopMemberInfo.age = ((byte)paramInt1);
        bool1 = true;
      }
    }
    bool2 = bool1;
    if (paramInt2 != -100)
    {
      bool2 = bool1;
      if (paramInt2 != paramTroopMemberInfo.sex)
      {
        paramTroopMemberInfo.sex = ((byte)paramInt2);
        bool2 = true;
      }
    }
    if ((paramInt3 != -100) && (paramInt3 != paramTroopMemberInfo.distance))
    {
      paramTroopMemberInfo.distance = paramInt3;
      return true;
    }
    return bool2;
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "hasGroupSystemMsgProcessed troopCode:" + paramLong1 + " msgTime:" + paramLong2);
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {
      return false;
    }
    return l(String.format("%s_%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
  }
  
  public boolean a(Entity paramEntity)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen()) {}
    do
    {
      do
      {
        return false;
        if (paramEntity.getStatus() != 1000) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramEntity);
      } while (paramEntity.getStatus() != 1001);
      return true;
    } while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002));
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramEntity);
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: aload_0
    //   12: getfield 204	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15: invokevirtual 210	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   18: invokevirtual 216	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   21: astore 5
    //   23: aload 5
    //   25: invokevirtual 1045	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   28: astore 4
    //   30: aload 4
    //   32: astore_3
    //   33: aload_3
    //   34: invokevirtual 1050	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   37: aload 5
    //   39: ldc_w 1235
    //   42: iconst_0
    //   43: ldc_w 1920
    //   46: iconst_1
    //   47: anewarray 463	java/lang/String
    //   50: dup
    //   51: iconst_0
    //   52: aload_1
    //   53: aastore
    //   54: aconst_null
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: invokevirtual 414	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   61: astore 4
    //   63: aload 4
    //   65: ifnull +15 -> 80
    //   68: aload 4
    //   70: invokeinterface 1322 1 0
    //   75: istore_2
    //   76: iload_2
    //   77: ifeq +13 -> 90
    //   80: aload_3
    //   81: ifnull +7 -> 88
    //   84: aload_3
    //   85: invokevirtual 1065	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   88: iconst_0
    //   89: ireturn
    //   90: aload 4
    //   92: invokeinterface 1073 1 0
    //   97: astore 4
    //   99: aload 4
    //   101: invokeinterface 344 1 0
    //   106: ifeq +56 -> 162
    //   109: aload 5
    //   111: aload 4
    //   113: invokeinterface 348 1 0
    //   118: checkcast 1235	com/tencent/mobileqq/data/troop/TroopMemberInfo
    //   121: invokevirtual 1840	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   124: pop
    //   125: goto -26 -> 99
    //   128: astore 4
    //   130: ldc_w 1038
    //   133: iconst_2
    //   134: ldc_w 2059
    //   137: aload 4
    //   139: invokestatic 2061	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   142: aload_3
    //   143: ifnull +7 -> 150
    //   146: aload_3
    //   147: invokevirtual 1065	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   150: aload 5
    //   152: invokevirtual 1321	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   155: aload_0
    //   156: aload_1
    //   157: invokespecial 2063	com/tencent/mobileqq/app/TroopManager:o	(Ljava/lang/String;)V
    //   160: iconst_1
    //   161: ireturn
    //   162: aload_3
    //   163: invokevirtual 1069	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   166: aload_3
    //   167: ifnull -17 -> 150
    //   170: aload_3
    //   171: invokevirtual 1065	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   174: goto -24 -> 150
    //   177: astore_1
    //   178: aconst_null
    //   179: astore_3
    //   180: aload_3
    //   181: ifnull +7 -> 188
    //   184: aload_3
    //   185: invokevirtual 1065	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   188: aload_1
    //   189: athrow
    //   190: astore_1
    //   191: goto -11 -> 180
    //   194: astore_1
    //   195: goto -15 -> 180
    //   198: astore 4
    //   200: goto -70 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	TroopManager
    //   0	203	1	paramString	String
    //   75	2	2	bool	boolean
    //   1	184	3	localObject1	Object
    //   28	84	4	localObject2	Object
    //   128	10	4	localException1	Exception
    //   198	1	4	localException2	Exception
    //   21	130	5	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   33	63	128	java/lang/Exception
    //   68	76	128	java/lang/Exception
    //   90	99	128	java/lang/Exception
    //   99	125	128	java/lang/Exception
    //   162	166	128	java/lang/Exception
    //   23	30	177	finally
    //   33	63	190	finally
    //   68	76	190	finally
    //   90	99	190	finally
    //   99	125	190	finally
    //   162	166	190	finally
    //   130	142	194	finally
    //   23	30	198	java/lang/Exception
  }
  
  protected boolean a(String paramString, int paramInt, long paramLong1, long paramLong2, TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (!paramString.equals(paramTroopMemberInfo.mUniqueTitle))
      {
        paramTroopMemberInfo.mUniqueTitle = paramString;
        bool1 = true;
      }
    }
    bool2 = bool1;
    if (paramInt != -100)
    {
      bool2 = bool1;
      if (paramInt != paramTroopMemberInfo.realLevel)
      {
        paramTroopMemberInfo.realLevel = paramInt;
        bool2 = true;
      }
    }
    bool1 = bool2;
    if (paramLong1 != -100L)
    {
      bool1 = bool2;
      if (paramLong1 != paramTroopMemberInfo.join_time)
      {
        paramTroopMemberInfo.join_time = paramLong1;
        bool1 = true;
      }
    }
    if ((paramLong2 != -100L) && (paramLong2 != paramTroopMemberInfo.last_active_time))
    {
      paramTroopMemberInfo.last_active_time = paramLong2;
      return true;
    }
    return bool1;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "addCommonlyUsedTroop, troopUin is null");
      }
      return false;
    }
    ConcurrentHashMap localConcurrentHashMap = a();
    CommonlyUsedTroop localCommonlyUsedTroop = (CommonlyUsedTroop)localConcurrentHashMap.get(paramString);
    anuz localanuz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 4, " addCommonlyUsedTroop troopUin=" + paramString + " troop.addedTimestamp" + paramLong);
    }
    if (localCommonlyUsedTroop == null)
    {
      localCommonlyUsedTroop = new CommonlyUsedTroop();
      localCommonlyUsedTroop.troopUin = paramString;
      localCommonlyUsedTroop.addedTimestamp = paramLong;
      localConcurrentHashMap.put(paramString, localCommonlyUsedTroop);
      a(localanuz, localCommonlyUsedTroop, true);
      a(localCommonlyUsedTroop);
      return true;
    }
    if (localCommonlyUsedTroop.addedTimestamp != paramLong)
    {
      localCommonlyUsedTroop.addedTimestamp = paramLong;
      a(localanuz, localCommonlyUsedTroop, true);
      a(localCommonlyUsedTroop);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return false;
      paramString1 = (LruCache)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString1);
    } while (paramString1 == null);
    if (paramString1.get(paramString2) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean a(String paramString1, String paramString2, byte paramByte)
  {
    TroopMemberInfo localTroopMemberInfo = b(paramString1, paramString2);
    if (localTroopMemberInfo == null) {}
    label123:
    for (;;)
    {
      return false;
      if (paramByte != -100)
      {
        localTroopMemberInfo.isTroopFollowed = false;
        localTroopMemberInfo.mIsShielded = false;
        if (paramByte == 1) {
          localTroopMemberInfo.isTroopFollowed = true;
        }
      }
      for (paramByte = 1;; paramByte = 0)
      {
        if (paramByte == 0) {
          break label123;
        }
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localTroopMemberInfo.getStatus() == 1000)
        {
          a(paramString1, paramString2, localTroopMemberInfo);
          localEntityManager.persistOrReplace(localTroopMemberInfo);
        }
        for (;;)
        {
          localEntityManager.close();
          return true;
          if (paramByte != 2) {
            break;
          }
          localTroopMemberInfo.mIsShielded = true;
          break;
          localEntityManager.update(localTroopMemberInfo);
        }
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    TroopMemberInfo localTroopMemberInfo = b(paramString1, paramString2);
    if (localTroopMemberInfo == null)
    {
      localTroopMemberInfo = new TroopMemberInfo();
      localTroopMemberInfo.troopuin = paramString1;
      localTroopMemberInfo.memberuin = paramString2;
      localTroopMemberInfo.isTroopFollowed = false;
    }
    for (int m = 1;; m = 0)
    {
      int n = m;
      if (paramInt > 0)
      {
        n = m;
        if (paramInt != localTroopMemberInfo.mGlamourLevel)
        {
          localTroopMemberInfo.mGlamourLevel = paramInt;
          n = 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab..troop.memberCard", 2, "saveTroopMemberEx ," + localTroopMemberInfo.toString());
      }
      if (n != 0)
      {
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localTroopMemberInfo.getStatus() == 1000)
        {
          a(paramString1, paramString2, localTroopMemberInfo);
          localEntityManager.persistOrReplace(localTroopMemberInfo);
        }
        for (;;)
        {
          localEntityManager.close();
          b(paramString1, paramString2);
          return true;
          localEntityManager.update(localTroopMemberInfo);
        }
      }
      return false;
    }
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    TroopMemberInfo localTroopMemberInfo = b(paramString1, paramString2);
    if (localTroopMemberInfo == null)
    {
      localTroopMemberInfo = new TroopMemberInfo();
      localTroopMemberInfo.troopuin = paramString1;
      localTroopMemberInfo.memberuin = paramString2;
      localTroopMemberInfo.isTroopFollowed = false;
    }
    for (int n = 1;; n = 0)
    {
      int m = n;
      if (paramInt1 >= 0)
      {
        m = n;
        if (paramInt1 != localTroopMemberInfo.hotChatGlamourLevel)
        {
          localTroopMemberInfo.hotChatGlamourLevel = paramInt1;
          m = 1;
        }
      }
      paramInt1 = m;
      if (paramInt2 >= 0)
      {
        paramInt1 = m;
        if (paramInt2 != localTroopMemberInfo.globalTroopLevel)
        {
          localTroopMemberInfo.globalTroopLevel = paramInt2;
          paramInt1 = 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab..troop.memberCard", 2, "saveTroopMemberHotChatGlamourLevel ," + localTroopMemberInfo.toString());
      }
      if (paramInt1 != 0)
      {
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localTroopMemberInfo.getStatus() == 1000)
        {
          a(paramString1, paramString2, localTroopMemberInfo);
          localEntityManager.persistOrReplace(localTroopMemberInfo);
        }
        for (;;)
        {
          localEntityManager.close();
          b(paramString1, paramString2);
          return true;
          localEntityManager.update(localTroopMemberInfo);
        }
      }
      return false;
    }
  }
  
  protected boolean a(String paramString1, String paramString2, int paramInt, long paramLong, byte paramByte, double paramDouble, TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool3 = false;
    if ((paramInt > 0) && (paramInt != paramTroopMemberInfo.level))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRankConfig", 2, "saveTroopMemberEx: troopUin=" + paramString1 + ", memberUin=" + paramString2 + ", newTitleId=" + paramInt + ", oldTitleId=" + paramTroopMemberInfo.level);
      }
      paramTroopMemberInfo.level = paramInt;
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool1 = bool2;
      if (paramLong != -100L)
      {
        bool1 = bool2;
        if (paramLong != paramTroopMemberInfo.gagTimeStamp)
        {
          paramTroopMemberInfo.gagTimeStamp = paramLong;
          bool1 = true;
        }
      }
      bool2 = bool3;
      if (paramByte == 1) {
        bool2 = true;
      }
      bool3 = bool1;
      if (paramByte != -100)
      {
        bool3 = bool1;
        if (paramTroopMemberInfo.isTroopFollowed != bool2)
        {
          paramTroopMemberInfo.isTroopFollowed = bool2;
          bool3 = true;
        }
      }
      if ((paramDouble != -100.0D) && (paramDouble != paramTroopMemberInfo.distanceToSelf))
      {
        paramTroopMemberInfo.distanceToSelf = paramDouble;
        paramTroopMemberInfo.distanceToSelfUpdateTimeStamp = System.currentTimeMillis();
        return true;
      }
      return bool3;
    }
  }
  
  protected boolean a(String paramString1, String paramString2, TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool2 = false;
    if (paramString1 == null) {}
    for (String str = null;; str = bgdk.b(paramString1))
    {
      boolean bool1 = bool2;
      if (paramString1 != null)
      {
        bool1 = bool2;
        if (!paramString1.equals(paramTroopMemberInfo.troopColorNick))
        {
          paramTroopMemberInfo.troopColorNick = paramString1;
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (str != null)
      {
        bool2 = bool1;
        if (!str.equals(paramTroopMemberInfo.troopnick))
        {
          paramTroopMemberInfo.troopnick = str;
          bool2 = true;
        }
      }
      if ((paramString2 == null) || (paramString2.equals(paramTroopMemberInfo.friendnick))) {
        break;
      }
      paramTroopMemberInfo.friendnick = paramString2;
      return true;
    }
    return bool2;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, byte paramByte, long paramLong2, double paramDouble)
  {
    return a(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, paramByte, paramLong2, paramDouble, null, -100, -100, -100, -100L, -100L);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, byte paramByte, long paramLong2, double paramDouble, long paramLong3, long paramLong4)
  {
    return a(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, paramByte, paramLong2, paramDouble, null, -100, -100, -100, paramLong3, paramLong4);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, byte paramByte, long paramLong2, double paramDouble, String paramString6, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11)
  {
    return a(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, paramByte, paramLong2, paramDouble, paramString6, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, -100L, -100L);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, byte paramByte, long paramLong2, double paramDouble, String paramString6, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, long paramLong3, long paramLong4)
  {
    TroopMemberInfo localTroopMemberInfo = b(paramString1, paramString2);
    boolean bool = false;
    paramString5 = localTroopMemberInfo;
    if (localTroopMemberInfo == null)
    {
      paramString5 = new TroopMemberInfo();
      paramString5.troopuin = paramString1;
      paramString5.memberuin = paramString2;
      paramString5.isTroopFollowed = false;
      bool = true;
    }
    if (a(paramString3, paramString4, paramString5)) {
      bool = true;
    }
    if (a(paramInt6, paramInt7, paramString5)) {
      bool = true;
    }
    for (;;)
    {
      if (a(paramInt8, paramInt9, paramInt10, paramInt11, paramString5)) {
        bool = true;
      }
      for (;;)
      {
        if (a(paramString1, paramString2, paramInt1, paramLong2, paramByte, paramDouble, paramString5)) {}
        for (int m = 1;; m = bool)
        {
          if (a(paramString6, paramInt5, paramLong3, paramLong4, paramString5)) {
            m = 1;
          }
          if ((paramLong1 != -100L) && (paramLong1 < paramString5.msgseq)) {}
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.contacttab..troop.memberCard", 2, "saveTroopMemberEx ," + paramString5.toString());
            }
            if (m == 0) {
              break;
            }
            if (paramString5.getStatus() == 1000) {
              a(paramString1, paramString2, paramString5);
            }
            a(new TroopManager.SaveTroopMemberTask(this, paramString5, bool));
            return true;
            if (a(paramLong1, paramInt2, paramInt3, paramInt4, paramString5)) {
              m = 1;
            }
          }
          return false;
        }
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, byte paramByte, long paramLong2, double paramDouble, String paramString6, int paramInt5, int paramInt6, int paramInt7, long paramLong3, long paramLong4)
  {
    return a(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, paramByte, paramLong2, paramDouble, null, -100, -100, -100, -100, -100, -100, -100, paramLong3, paramLong4);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    return a(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, (byte)-100, paramLong2, -100.0D, -100L, -100L);
  }
  
  public boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "deleteTroopMember, troopUin=" + paramString1 + ",memberUin=" + paramString2 + ",updateHeadAndName=" + paramBoolean);
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if ((localEntityManager == null) || (localTroopManager == null)) {
      return false;
    }
    TroopInfo localTroopInfo = localTroopManager.b(paramString1);
    if (localTroopInfo == null) {
      return false;
    }
    TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)localEntityManager.find(TroopMemberInfo.class, "troopuin=? and memberuin=?", new String[] { paramString1, paramString2 });
    if (localTroopMemberInfo != null)
    {
      localEntityManager.remove(localTroopMemberInfo);
      if (localTroopInfo.wMemberNum > 0) {
        localTroopInfo.wMemberNum -= 1;
      }
      if ((localTroopInfo.Administrator != null) && (localTroopInfo.Administrator.contains(paramString2))) {
        localTroopInfo.Administrator.replace(paramString2, "");
      }
    }
    localTroopManager.b(localTroopInfo);
    localEntityManager.close();
    e(paramString1, paramString2);
    a(paramString1, paramString2);
    if (paramBoolean) {
      ((anca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20)).c(paramString1, paramString2);
    }
    return true;
  }
  
  /* Error */
  public boolean a(List<TroopMemberInfo> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 1322 1 0
    //   10: ifeq +7 -> 17
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ireturn
    //   17: new 2182	java/util/HashSet
    //   20: dup
    //   21: invokespecial 2183	java/util/HashSet:<init>	()V
    //   24: astore 7
    //   26: iconst_0
    //   27: istore_3
    //   28: iconst_0
    //   29: istore 4
    //   31: iconst_0
    //   32: istore_2
    //   33: aconst_null
    //   34: astore 5
    //   36: aload_0
    //   37: getfield 218	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   40: invokevirtual 1045	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   43: astore 6
    //   45: aload 6
    //   47: astore 5
    //   49: iload 4
    //   51: istore_3
    //   52: aload 5
    //   54: invokevirtual 1050	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   57: iload 4
    //   59: istore_3
    //   60: aload_1
    //   61: invokeinterface 1073 1 0
    //   66: astore_1
    //   67: iload_2
    //   68: istore_3
    //   69: aload_1
    //   70: invokeinterface 344 1 0
    //   75: ifeq +155 -> 230
    //   78: iload_2
    //   79: istore_3
    //   80: aload_1
    //   81: invokeinterface 348 1 0
    //   86: checkcast 1235	com/tencent/mobileqq/data/troop/TroopMemberInfo
    //   89: astore 6
    //   91: iload_2
    //   92: istore_3
    //   93: new 378	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 379	java/lang/StringBuilder:<init>	()V
    //   100: aload 6
    //   102: getfield 1372	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopuin	Ljava/lang/String;
    //   105: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc_w 1251
    //   111: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload 6
    //   116: getfield 1360	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   119: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 397	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore 8
    //   127: iload_2
    //   128: istore_3
    //   129: aload 6
    //   131: getfield 1360	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   134: ldc_w 2185
    //   137: invokevirtual 467	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   140: ifne -73 -> 67
    //   143: iload_2
    //   144: istore_3
    //   145: aload 7
    //   147: aload 8
    //   149: invokevirtual 2186	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   152: ifne +199 -> 351
    //   155: iload_2
    //   156: istore_3
    //   157: aload_0
    //   158: aload 6
    //   160: getfield 1372	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopuin	Ljava/lang/String;
    //   163: aload 6
    //   165: getfield 1360	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   168: aload 6
    //   170: getfield 2125	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopColorNick	Ljava/lang/String;
    //   173: aload 6
    //   175: getfield 1819	com/tencent/mobileqq/data/troop/TroopMemberInfo:level	I
    //   178: aload 6
    //   180: getfield 1388	com/tencent/mobileqq/data/troop/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   183: aconst_null
    //   184: aload 6
    //   186: getfield 2042	com/tencent/mobileqq/data/troop/TroopMemberInfo:age	B
    //   189: aload 6
    //   191: getfield 2045	com/tencent/mobileqq/data/troop/TroopMemberInfo:sex	B
    //   194: aload 6
    //   196: getfield 2048	com/tencent/mobileqq/data/troop/TroopMemberInfo:distance	I
    //   199: aload 6
    //   201: getfield 2038	com/tencent/mobileqq/data/troop/TroopMemberInfo:msgseq	J
    //   204: aload 6
    //   206: getfield 1269	com/tencent/mobileqq/data/troop/TroopMemberInfo:gagTimeStamp	J
    //   209: invokevirtual 2188	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIIJJ)Z
    //   212: istore 4
    //   214: iload 4
    //   216: iload_2
    //   217: ior
    //   218: istore_2
    //   219: aload 7
    //   221: aload 8
    //   223: invokevirtual 2189	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   226: pop
    //   227: goto -160 -> 67
    //   230: iload_2
    //   231: istore_3
    //   232: aload 5
    //   234: invokevirtual 1069	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   237: iload_2
    //   238: istore_3
    //   239: aload 5
    //   241: ifnull -226 -> 15
    //   244: aload 5
    //   246: invokevirtual 1065	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   249: iload_2
    //   250: ireturn
    //   251: astore 6
    //   253: iload_3
    //   254: istore_2
    //   255: aload 5
    //   257: astore_1
    //   258: aload 6
    //   260: astore 5
    //   262: invokestatic 429	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   265: ifeq +15 -> 280
    //   268: ldc_w 892
    //   271: iconst_2
    //   272: aload 5
    //   274: invokestatic 2193	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   277: invokestatic 1342	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: iload_2
    //   281: istore_3
    //   282: aload_1
    //   283: ifnull -268 -> 15
    //   286: aload_1
    //   287: invokevirtual 1065	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   290: iload_2
    //   291: ireturn
    //   292: astore_1
    //   293: aconst_null
    //   294: astore 5
    //   296: aload 5
    //   298: ifnull +8 -> 306
    //   301: aload 5
    //   303: invokevirtual 1065	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   306: aload_1
    //   307: athrow
    //   308: astore_1
    //   309: goto -13 -> 296
    //   312: astore 6
    //   314: aload_1
    //   315: astore 5
    //   317: aload 6
    //   319: astore_1
    //   320: goto -24 -> 296
    //   323: astore 6
    //   325: aload 5
    //   327: astore_1
    //   328: aload 6
    //   330: astore 5
    //   332: iload_3
    //   333: istore_2
    //   334: goto -72 -> 262
    //   337: astore_1
    //   338: aload 5
    //   340: astore 6
    //   342: aload_1
    //   343: astore 5
    //   345: aload 6
    //   347: astore_1
    //   348: goto -86 -> 262
    //   351: goto -124 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	this	TroopManager
    //   0	354	1	paramList	List<TroopMemberInfo>
    //   32	302	2	bool1	boolean
    //   14	319	3	bool2	boolean
    //   29	189	4	bool3	boolean
    //   34	310	5	localObject1	Object
    //   43	162	6	localObject2	Object
    //   251	8	6	localThrowable1	Throwable
    //   312	6	6	localObject3	Object
    //   323	6	6	localThrowable2	Throwable
    //   340	6	6	localObject4	Object
    //   24	196	7	localHashSet	java.util.HashSet
    //   125	97	8	str	String
    // Exception table:
    //   from	to	target	type
    //   36	45	251	java/lang/Throwable
    //   36	45	292	finally
    //   52	57	308	finally
    //   60	67	308	finally
    //   69	78	308	finally
    //   80	91	308	finally
    //   93	127	308	finally
    //   129	143	308	finally
    //   145	155	308	finally
    //   157	214	308	finally
    //   219	227	308	finally
    //   232	237	308	finally
    //   262	280	312	finally
    //   52	57	323	java/lang/Throwable
    //   60	67	323	java/lang/Throwable
    //   69	78	323	java/lang/Throwable
    //   80	91	323	java/lang/Throwable
    //   93	127	323	java/lang/Throwable
    //   129	143	323	java/lang/Throwable
    //   145	155	323	java/lang/Throwable
    //   157	214	323	java/lang/Throwable
    //   232	237	323	java/lang/Throwable
    //   219	227	337	java/lang/Throwable
  }
  
  public byte[] a(String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getString("troop_app_list_data", null);
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = bfuc.decode(paramString, 0);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public int b()
  {
    try
    {
      int m = this.jdField_a_of_type_JavaUtilHashMap.size();
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab..troopgroup_vedio.invite", 2, "hasGroupInviting  : " + m);
      }
      return m;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int b(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    return localSharedPreferences.getInt("upgrade_troop_notify_" + str + "_" + paramString, 0);
  }
  
  public long b(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    return localSharedPreferences.getLong("line_" + str + "_" + paramString, -1L);
  }
  
  public TroopInfo b(String paramString)
  {
    return a(paramString, false, true);
  }
  
  public TroopMemberInfo b(String paramString1, String paramString2)
  {
    TroopMemberInfo localTroopMemberInfo2 = a(paramString1, paramString2);
    TroopMemberInfo localTroopMemberInfo1 = localTroopMemberInfo2;
    if (localTroopMemberInfo2 == null) {
      localTroopMemberInfo1 = c(paramString1, paramString2);
    }
    return localTroopMemberInfo1;
  }
  
  public String b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    if (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return (String)this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (TroopInfo)((Map.Entry)localIterator.next()).getValue();
        if ((localObject != null) && (((TroopInfo)localObject).troopcode != null) && (((TroopInfo)localObject).troopcode.equals(paramString)))
        {
          localObject = ((TroopInfo)localObject).troopuin;
          if ((localObject != null) && (((String)localObject).length() > 0))
          {
            this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
            return localObject;
          }
        }
      }
    }
    return null;
  }
  
  public String b(String paramString1, String paramString2)
  {
    return ContactUtils.getTroopMemberNameFromCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, false);
  }
  
  public ArrayList<Entity> b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public ArrayList<String> b(String paramString)
  {
    Object localObject = c(paramString);
    paramString = new ArrayList();
    if ((localObject != null) && (((TroopInfo)localObject).mHeaderUinsNew != null))
    {
      if (((TroopInfo)localObject).mHeaderUinsNew == " ") {
        return paramString;
      }
      localObject = ((TroopInfo)localObject).mHeaderUinsNew.split(";");
      int n = localObject.length;
      int m = 0;
      while (m < n)
      {
        CharSequence localCharSequence = localObject[m];
        if (!TextUtils.isEmpty(localCharSequence)) {
          paramString.add(localCharSequence);
        }
        m += 1;
      }
    }
    TroopUtils.removeRobotUin(paramString);
    return paramString;
  }
  
  public List<ShowExternalTroop> b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = b().values().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((ShowExternalTroop)localIterator.next());
    }
    return localArrayList;
  }
  
  public List<TroopMemberInfo> b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(TroopMemberInfo.class, false, "troopuin=?", new String[] { paramString }, null, null, null, null);
  }
  
  public void b()
  {
    h();
    i();
  }
  
  public void b(andc paramandc)
  {
    try
    {
      this.jdField_f_of_type_JavaUtilArrayList.remove(paramandc);
      return;
    }
    finally
    {
      paramandc = finally;
      throw paramandc;
    }
  }
  
  public void b(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (TextUtils.isEmpty(paramTroopInfo.troopuin)) || ("0".equals(paramTroopInfo.troopuin))) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    ampx.a(paramTroopInfo);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramTroopInfo.troopuin, paramTroopInfo);
    }
    if ((!a(paramTroopInfo)) && (QLog.isColorLevel())) {
      QLog.d("Q.contacttab.troop", 2, "saveTroopInfo failed.");
    }
    ProxyManager localProxyManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager();
    RecentUser localRecentUser = (RecentUser)localProxyManager.a().findRecentUserByUin(paramTroopInfo.troopuin, 1);
    localRecentUser.displayName = paramTroopInfo.getTroopName();
    if (localRecentUser.getStatus() == 1001) {
      localProxyManager.a().saveRecentUser(localRecentUser);
    }
    i();
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = (LruCache)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
    } while (paramString == null);
    paramString.evictAll();
  }
  
  public void b(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    paramString = "upgrade_troop_notify_" + str + "_" + paramString;
    localSharedPreferences.edit().putInt(paramString, paramInt).commit();
  }
  
  public void b(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    paramString = "line_" + str + "_" + paramString;
    if (paramLong < 0L)
    {
      localSharedPreferences.edit().remove(paramString);
      return;
    }
    localSharedPreferences.edit().putLong(paramString, paramLong).commit();
  }
  
  public void b(String paramString1, String paramString2)
  {
    int m = 0;
    while (m < this.jdField_f_of_type_JavaUtilArrayList.size())
    {
      ((andc)this.jdField_f_of_type_JavaUtilArrayList.get(m)).a(paramString1, paramString2);
      m += 1;
    }
  }
  
  public void b(String paramString1, String paramString2, long paramLong)
  {
    TroopMemberInfo localTroopMemberInfo = b(paramString1, paramString2);
    if (localTroopMemberInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "saveAndUpdateTroopMemberGagStatus , info is null ... ");
      }
      return;
    }
    if ((paramLong != -100L) && (paramLong != localTroopMemberInfo.gagTimeStamp)) {
      localTroopMemberInfo.gagTimeStamp = paramLong;
    }
    if (localTroopMemberInfo.getStatus() == 1000) {
      a(paramString1, paramString2, localTroopMemberInfo);
    }
    ThreadManager.post(new TroopManager.8(this, localTroopMemberInfo, paramString1), 8, null, false);
  }
  
  public void b(String paramString1, String paramString2, TroopMemberInfo paramTroopMemberInfo)
  {
    if (paramTroopMemberInfo == null) {
      return;
    }
    ThreadManager.post(new TroopManager.9(this, paramTroopMemberInfo, new Handler(Looper.getMainLooper()), paramString1, paramString2), 8, null, false);
  }
  
  public void b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    TroopMemberInfo localTroopMemberInfo2 = b(paramString1, paramString2);
    TroopMemberInfo localTroopMemberInfo1 = localTroopMemberInfo2;
    if (localTroopMemberInfo2 == null)
    {
      localTroopMemberInfo1 = new TroopMemberInfo();
      localTroopMemberInfo1.memberuin = paramString2;
      localTroopMemberInfo1.troopuin = paramString1;
    }
    if ((paramString3 != null) && (!TextUtils.equals(paramString3, localTroopMemberInfo1.mUniqueTitle)))
    {
      localTroopMemberInfo1.mUniqueTitle = paramString3;
      localTroopMemberInfo1.mUniqueTitleExpire = paramInt;
      if (localTroopMemberInfo1.getStatus() == 1000) {
        a(paramString1, paramString2, localTroopMemberInfo1);
      }
      b(paramString1, paramString2, localTroopMemberInfo1);
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    ThreadManager.post(new TroopManager.7(this, paramString1, paramString2, paramString3, paramInt, paramString4, paramString5), 8, null, false);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    if (paramBoolean)
    {
      ThreadManager.post(new TroopManager.11(this, paramString), 8, null, true);
      return;
    }
    b(paramString, -1L);
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    int m = 0;
    while (m < this.jdField_f_of_type_JavaUtilArrayList.size())
    {
      ((andc)this.jdField_f_of_type_JavaUtilArrayList.get(m)).a(paramArrayList);
      m += 1;
    }
  }
  
  public void b(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    EntityTransaction localEntityTransaction;
    for (;;)
    {
      return;
      QLog.i("troop_ext", 1, "setTroopEliminated list is: " + paramList.toString());
      localObject = null;
      try
      {
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
        localObject = localEntityTransaction;
        localEntityTransaction.begin();
        localObject = localEntityTransaction;
        paramList = paramList.iterator();
        for (;;)
        {
          localObject = localEntityTransaction;
          if (!paramList.hasNext()) {
            break;
          }
          localObject = localEntityTransaction;
          TroopInfo localTroopInfo = b((String)paramList.next());
          if (localTroopInfo != null)
          {
            localObject = localEntityTransaction;
            localTroopInfo.eliminated = 1;
            localObject = localEntityTransaction;
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(localTroopInfo);
          }
        }
        if (localObject == null) {}
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        QLog.e("Q.contacttab.", 1, "troop_ext " + paramList.getMessage());
      }
    }
    localObject.end();
    return;
    Object localObject = localEntityTransaction;
    localEntityTransaction.commit();
    localObject = localEntityTransaction;
    localEntityTransaction.end();
  }
  
  public void b(Map<String, Long> paramMap)
  {
    this.jdField_d_of_type_JavaUtilMap = paramMap;
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, "setTroopAIOOpen flag: " + paramBoolean);
      }
      this.jdField_c_of_type_Boolean = paramBoolean;
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b(String paramString)
  {
    return a().get(paramString) != null;
  }
  
  public boolean b(String paramString, long paramLong)
  {
    ConcurrentHashMap localConcurrentHashMap = b();
    ShowExternalTroop localShowExternalTroop = (ShowExternalTroop)localConcurrentHashMap.get(paramString);
    if (localShowExternalTroop == null)
    {
      localShowExternalTroop = ShowExternalTroop.createShowExternalTroop(paramString, ContactUtils.getTroopNameByID(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString), paramLong);
      localConcurrentHashMap.put(paramString, localShowExternalTroop);
      a(localShowExternalTroop);
      return true;
    }
    if (localShowExternalTroop.addedTimestamp != paramLong)
    {
      localShowExternalTroop.addedTimestamp = paramLong;
      a(localShowExternalTroop);
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString1, 0).getBoolean(paramString2, false);
  }
  
  public int c(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getInt(jdField_d_of_type_JavaLangString, 0);
  }
  
  public TroopInfo c(String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (TextUtils.isEmpty(paramString))
    {
      localObject1 = new TroopInfo();
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.e("Q.contacttab.", 2, "getTroopInfo, troopUin isEmpty:" + paramString);
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, StringUtil.makeLogMsg(new Object[] { "TroopManger getTroopInfo()", paramString, Long.valueOf(((TroopInfo)localObject2).dwGroupFlagExt) }));
      }
      return localObject2;
      localObject2 = b(paramString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TroopInfo();
        ((TroopInfo)localObject1).troopname = bftd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramString);
        ((TroopInfo)localObject1).dwGroupFlagExt = bftd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramString);
      }
      localObject2 = localObject1;
      if (!m(((TroopInfo)localObject1).troopname))
      {
        ((TroopInfo)localObject1).troopname = paramString;
        localObject2 = localObject1;
      }
    }
  }
  
  public TroopMemberInfo c(String paramString1, String paramString2)
  {
    long l1;
    if (StatisticCollector.getSqliteSwitchBySample(12))
    {
      l1 = SystemClock.uptimeMillis();
      auso.a();
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      List localList = ((EntityManager)localObject).query(TroopMemberInfo.class, false, "troopuin=? AND memberuin=?", new String[] { paramString1, paramString2 }, null, null, null, null);
      ((EntityManager)localObject).close();
      HashMap localHashMap;
      if (l1 != 0L)
      {
        l1 = SystemClock.uptimeMillis() - l1;
        localHashMap = new HashMap(10);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break label233;
        }
      }
      label233:
      for (localObject = "1";; localObject = "0")
      {
        localHashMap.put("param_IsMainThread", localObject);
        localHashMap.put("param_OptType", "query");
        localHashMap.put("param_bustag", "Troop");
        localHashMap.put("param_intrans", "0");
        localHashMap.put("param_OptTotalCost", String.valueOf(l1));
        localHashMap.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(null, "actFriendSqliteOpt", true, l1, 0L, localHashMap, null, false);
        if ((localList == null) || (localList.size() <= 0)) {
          break;
        }
        localObject = (TroopMemberInfo)localList.get(0);
        a(paramString1, paramString2, (TroopMemberInfo)localObject);
        return localObject;
      }
      return null;
      l1 = 0L;
    }
  }
  
  public String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      TroopInfo localTroopInfo = (TroopInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(TroopInfo.class, "troopcode=?", new String[] { paramString });
      if (localTroopInfo == null) {
        return null;
      }
      if ((localTroopInfo.troopcode == null) || (localTroopInfo.troopuin == null)) {
        return null;
      }
      this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(localTroopInfo.troopcode, localTroopInfo.troopuin);
    }
    return (String)this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public String c(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.troop", 2, "getTroopMemberNick uin is null");
      }
      localObject = "";
      return localObject;
    }
    String str = "";
    Object localObject = b(paramString1, paramString2);
    if (localObject != null)
    {
      if (TextUtils.isEmpty(((TroopMemberInfo)localObject).troopnick)) {
        break label117;
      }
      str = ((TroopMemberInfo)localObject).troopnick;
    }
    for (;;)
    {
      localObject = str;
      if (str == null) {
        break;
      }
      localObject = str;
      if (!str.equals(paramString2)) {
        break;
      }
      paramString1 = b(paramString1);
      localObject = str;
      if (paramString1 == null) {
        break;
      }
      localObject = str;
      if (!paramString1.isQidianPrivateTroop()) {
        break;
      }
      return TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
      label117:
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject).friendnick)) {
        str = ((TroopMemberInfo)localObject).friendnick;
      } else {
        str = paramString2;
      }
    }
  }
  
  /* Error */
  public ArrayList<ancz> c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 111	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 114	java/util/ArrayList:<init>	()V
    //   10: astore 6
    //   12: aload_0
    //   13: getfield 218	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   16: invokevirtual 1045	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   19: astore 5
    //   21: aload 5
    //   23: astore 4
    //   25: aload 4
    //   27: ifnull +139 -> 166
    //   30: aload 4
    //   32: invokevirtual 1050	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   35: invokestatic 1465	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   38: lstore_2
    //   39: aload_0
    //   40: getfield 218	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   43: ldc_w 1235
    //   46: iconst_0
    //   47: ldc_w 1920
    //   50: iconst_1
    //   51: anewarray 463	java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: aload_1
    //   57: aastore
    //   58: aconst_null
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokevirtual 414	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   65: astore_1
    //   66: aload_1
    //   67: ifnull +99 -> 166
    //   70: aload_1
    //   71: invokeinterface 1073 1 0
    //   76: astore_1
    //   77: aload_1
    //   78: invokeinterface 344 1 0
    //   83: ifeq +83 -> 166
    //   86: aload_1
    //   87: invokeinterface 348 1 0
    //   92: checkcast 1235	com/tencent/mobileqq/data/troop/TroopMemberInfo
    //   95: astore 5
    //   97: aload 5
    //   99: invokestatic 2398	com/tencent/mobileqq/activity/ChatActivityUtils:a	(Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;)Z
    //   102: ifeq -25 -> 77
    //   105: aload 5
    //   107: getfield 1269	com/tencent/mobileqq/data/troop/TroopMemberInfo:gagTimeStamp	J
    //   110: lconst_0
    //   111: lcmp
    //   112: ifeq -35 -> 77
    //   115: aload 5
    //   117: getfield 1269	com/tencent/mobileqq/data/troop/TroopMemberInfo:gagTimeStamp	J
    //   120: lload_2
    //   121: lcmp
    //   122: ifle -45 -> 77
    //   125: aload 6
    //   127: new 1271	ancz
    //   130: dup
    //   131: aload_0
    //   132: aload 5
    //   134: getfield 1360	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   137: aload 5
    //   139: getfield 1269	com/tencent/mobileqq/data/troop/TroopMemberInfo:gagTimeStamp	J
    //   142: invokespecial 1274	ancz:<init>	(Lcom/tencent/mobileqq/app/TroopManager;Ljava/lang/String;J)V
    //   145: invokevirtual 473	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   148: pop
    //   149: goto -72 -> 77
    //   152: astore_1
    //   153: aload 4
    //   155: ifnull +8 -> 163
    //   158: aload 4
    //   160: invokevirtual 1065	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   163: aload 6
    //   165: areturn
    //   166: aload 4
    //   168: ifnull -5 -> 163
    //   171: aload 4
    //   173: invokevirtual 1065	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   176: aload 6
    //   178: areturn
    //   179: astore_1
    //   180: aconst_null
    //   181: astore 4
    //   183: aload 4
    //   185: ifnull +8 -> 193
    //   188: aload 4
    //   190: invokevirtual 1065	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   193: aload_1
    //   194: athrow
    //   195: astore_1
    //   196: goto -13 -> 183
    //   199: astore_1
    //   200: goto -47 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	TroopManager
    //   0	203	1	paramString	String
    //   38	83	2	l1	long
    //   1	188	4	localObject1	Object
    //   19	119	5	localObject2	Object
    //   10	167	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   30	66	152	java/lang/Throwable
    //   70	77	152	java/lang/Throwable
    //   77	149	152	java/lang/Throwable
    //   12	21	179	finally
    //   30	66	195	finally
    //   70	77	195	finally
    //   77	149	195	finally
    //   12	21	199	java/lang/Throwable
  }
  
  public List<Long> c()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = b();
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Entity)((Iterator)localObject1).next();
        if ((localObject2 instanceof TroopInfo))
        {
          localObject2 = (TroopInfo)localObject2;
          try
          {
            localArrayList.add(Long.valueOf(((TroopInfo)localObject2).troopuin));
          }
          catch (NumberFormatException localNumberFormatException)
          {
            QLog.d("Q.contacttab.", 1, "convert uin exception", localNumberFormatException);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() >= 3) {}
    TroopManager.SaveTroopMemberTask localSaveTroopMemberTask;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty());
      localSaveTroopMemberTask = (TroopManager.SaveTroopMemberTask)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    } while (localSaveTroopMemberTask == null);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager$SaveTroopMemberTask = localSaveTroopMemberTask;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(localSaveTroopMemberTask);
    ThreadManager.excute(localSaveTroopMemberTask, 32, null, false);
  }
  
  public void c(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (TextUtils.isEmpty(paramTroopInfo.troopuin)) || ("0".equals(paramTroopInfo.troopuin))) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      ampx.a(paramTroopInfo);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramTroopInfo.troopuin, paramTroopInfo);
      }
    } while ((a(paramTroopInfo)) || (!QLog.isColorLevel()));
    QLog.d("Q.contacttab.troop", 2, "saveTroopInfoOnlyCacheAndDB failed.");
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.execSQL("update TroopNotificationCache set read=1 where troopUin=" + paramString);
  }
  
  public void c(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putInt(jdField_b_of_type_JavaLangString, paramInt).commit();
  }
  
  public void c(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString1 + paramString2, paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab..troopgroup_vedio.invite", 2, new Object[] { "addGroupInviteStatus groupUin : " + paramString1, ", inviterUin:" + paramString2 });
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void c(List<TroopInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Iterator localIterator;
    TroopInfo localTroopInfo;
    try
    {
      localIterator = paramList.iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = localObject2;
        localTroopInfo = (TroopInfo)localIterator.next();
        if (localTroopInfo != null)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(localTroopInfo.troopuin))
          {
            localObject1 = localObject2;
            if (!"0".equals(localTroopInfo.troopuin))
            {
              localObject1 = localObject2;
              k(localTroopInfo.troopuin);
            }
          }
        }
      }
      d(paramList);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.troop", 2, QLog.getStackTraceString(localException));
      }
      if (localObject1 != null) {
        ((EntityTransaction)localObject1).end();
      }
    }
    for (;;)
    {
      i();
      return;
      localObject1 = localException;
      EntityTransaction localEntityTransaction = a();
      localObject1 = localEntityTransaction;
      localEntityTransaction.begin();
      localObject1 = localEntityTransaction;
      localIterator = paramList.iterator();
      for (;;)
      {
        localObject1 = localEntityTransaction;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = localEntityTransaction;
        localTroopInfo = (TroopInfo)localIterator.next();
        if (localTroopInfo != null)
        {
          localObject1 = localEntityTransaction;
          if (!TextUtils.isEmpty(localTroopInfo.troopuin))
          {
            localObject1 = localEntityTransaction;
            if (!"0".equals(localTroopInfo.troopuin))
            {
              localObject1 = localEntityTransaction;
              if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
              {
                localObject1 = localEntityTransaction;
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
              }
              localObject1 = localEntityTransaction;
              if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
              {
                localObject1 = localEntityTransaction;
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localTroopInfo.troopuin, localTroopInfo);
              }
              localObject1 = localEntityTransaction;
              if (!a(localTroopInfo))
              {
                localObject1 = localEntityTransaction;
                if (QLog.isColorLevel())
                {
                  localObject1 = localEntityTransaction;
                  QLog.d("Q.contacttab.troop", 2, "saveTroopInfo failed.");
                }
              }
            }
          }
        }
      }
      localObject1 = localEntityTransaction;
      localEntityTransaction.commit();
      localObject1 = localEntityTransaction;
      localEntityTransaction.end();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("show_troop_big_club", paramBoolean).commit();
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    return localSharedPreferences.getBoolean("show_new_create_big_troop2_" + str, false);
  }
  
  public boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "removeCommonlyUsedTroop, troopUin is null");
      }
      return false;
    }
    CommonlyUsedTroop localCommonlyUsedTroop = (CommonlyUsedTroop)a().remove(paramString);
    if (localCommonlyUsedTroop != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "removeCommonlyUsedTroop, troopUin=" + paramString);
      }
      localCommonlyUsedTroop.addedTimestamp = 0L;
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a(), localCommonlyUsedTroop, false);
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localCommonlyUsedTroop);
      return true;
    }
    return false;
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, true);
  }
  
  public int d(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getInt(jdField_e_of_type_JavaLangString, 0);
  }
  
  public TroopInfo d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      TroopInfo localTroopInfo = new TroopInfo();
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "getTroopInfoFromCache, troopUin isEmpty:" + paramString);
      }
      return localTroopInfo;
    }
    return (TroopInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public String d(String paramString)
  {
    Object localObject1 = null;
    Iterator localIterator = null;
    if (TextUtils.isEmpty(paramString)) {
      localObject2 = localIterator;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return localObject2;
              if (this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.containsValue(paramString)) {
                break;
              }
              localObject3 = a(paramString, true);
              localObject2 = localIterator;
            } while (localObject3 == null);
            localObject2 = localIterator;
          } while (((TroopInfo)localObject3).troopcode == null);
          localObject2 = localIterator;
        } while (((TroopInfo)localObject3).troopuin == null);
        this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(((TroopInfo)localObject3).troopcode, ((TroopInfo)localObject3).troopuin);
        localIterator = this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
        localObject2 = localObject1;
      } while (localIterator == null);
      localObject2 = localObject1;
    } while (!localIterator.hasNext());
    Object localObject2 = (String)localIterator.next();
    Object localObject3 = (String)this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject2);
    if ((localObject3 != null) && (((String)localObject3).equals(paramString))) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      break;
    }
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokespecial 1292	com/tencent/mobileqq/app/TroopManager:a	()Ljava/util/concurrent/ConcurrentHashMap;
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 218	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: invokevirtual 1045	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   16: astore 5
    //   18: aload 5
    //   20: astore 4
    //   22: aload 4
    //   24: ifnull +562 -> 586
    //   27: aload 4
    //   29: invokevirtual 1050	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   32: aload_0
    //   33: getfield 1945	com/tencent/mobileqq/app/TroopManager:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   36: ifnonnull +14 -> 50
    //   39: aload_0
    //   40: new 153	java/util/HashMap
    //   43: dup
    //   44: invokespecial 194	java/util/HashMap:<init>	()V
    //   47: putfield 1945	com/tencent/mobileqq/app/TroopManager:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   50: aload 6
    //   52: invokevirtual 2446	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   55: invokeinterface 2216 1 0
    //   60: astore 5
    //   62: aload 5
    //   64: invokeinterface 344 1 0
    //   69: ifeq +154 -> 223
    //   72: aload 5
    //   74: invokeinterface 348 1 0
    //   79: checkcast 463	java/lang/String
    //   82: astore 7
    //   84: aload_0
    //   85: getfield 204	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   88: invokevirtual 1619	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   91: invokevirtual 2450	mqq/app/MobileQQ:getBaseContext	()Landroid/content/Context;
    //   94: aload_0
    //   95: getfield 204	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   98: invokevirtual 245	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   101: invokestatic 2455	bfyz:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/List;
    //   104: aload 7
    //   106: invokeinterface 1144 2 0
    //   111: ifeq -49 -> 62
    //   114: aload 6
    //   116: aload 7
    //   118: invokevirtual 1056	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   121: checkcast 408	com/tencent/mobileqq/data/CommonlyUsedTroop
    //   124: getfield 600	com/tencent/mobileqq/data/CommonlyUsedTroop:addedTimestamp	J
    //   127: lstore_2
    //   128: aload_0
    //   129: getfield 1945	com/tencent/mobileqq/app/TroopManager:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   132: aload 7
    //   134: lload_2
    //   135: invokestatic 1024	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   138: invokeinterface 1425 3 0
    //   143: pop
    //   144: invokestatic 429	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq -85 -> 62
    //   150: ldc_w 892
    //   153: iconst_4
    //   154: new 378	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 379	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 2457
    //   164: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 7
    //   169: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc_w 2459
    //   175: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: lload_2
    //   179: invokevirtual 1557	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   182: invokevirtual 397	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 439	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: goto -126 -> 62
    //   191: astore 5
    //   193: invokestatic 429	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq +16 -> 212
    //   199: ldc_w 892
    //   202: iconst_4
    //   203: aload 5
    //   205: iconst_0
    //   206: anewarray 4	java/lang/Object
    //   209: invokestatic 2462	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   212: aload 4
    //   214: ifnull +8 -> 222
    //   217: aload 4
    //   219: invokevirtual 1065	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   222: return
    //   223: aload_0
    //   224: getfield 204	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   227: invokevirtual 1079	com/tencent/mobileqq/app/QQAppInterface:getProxyManager	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   230: invokevirtual 1084	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lanuz;
    //   233: astore 5
    //   235: aload 6
    //   237: invokevirtual 2446	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   240: invokeinterface 2216 1 0
    //   245: astore 7
    //   247: aload 7
    //   249: invokeinterface 344 1 0
    //   254: ifeq +64 -> 318
    //   257: aload 6
    //   259: aload 7
    //   261: invokeinterface 348 1 0
    //   266: checkcast 463	java/lang/String
    //   269: invokevirtual 1056	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   272: checkcast 408	com/tencent/mobileqq/data/CommonlyUsedTroop
    //   275: astore 8
    //   277: aload 8
    //   279: lconst_0
    //   280: putfield 600	com/tencent/mobileqq/data/CommonlyUsedTroop:addedTimestamp	J
    //   283: aload_0
    //   284: aload 5
    //   286: aload 8
    //   288: iconst_0
    //   289: invokespecial 2080	com/tencent/mobileqq/app/TroopManager:a	(Lanuz;Lcom/tencent/mobileqq/data/CommonlyUsedTroop;Z)V
    //   292: goto -45 -> 247
    //   295: astore 6
    //   297: aload 4
    //   299: astore 5
    //   301: aload 6
    //   303: astore 4
    //   305: aload 5
    //   307: ifnull +8 -> 315
    //   310: aload 5
    //   312: invokevirtual 1065	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   315: aload 4
    //   317: athrow
    //   318: aload_0
    //   319: getfield 218	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   322: ldc_w 408
    //   325: invokevirtual 2466	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   328: pop
    //   329: new 130	java/util/concurrent/ConcurrentHashMap
    //   332: dup
    //   333: aload 6
    //   335: invokespecial 2468	java/util/concurrent/ConcurrentHashMap:<init>	(Ljava/util/Map;)V
    //   338: astore 7
    //   340: aload 6
    //   342: invokevirtual 2469	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   345: aload_0
    //   346: getfield 1945	com/tencent/mobileqq/app/TroopManager:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   349: ifnull +232 -> 581
    //   352: aload_0
    //   353: getfield 1945	com/tencent/mobileqq/app/TroopManager:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   356: invokeinterface 2470 1 0
    //   361: invokeinterface 2216 1 0
    //   366: astore 8
    //   368: aload 8
    //   370: invokeinterface 344 1 0
    //   375: ifeq +206 -> 581
    //   378: aload 8
    //   380: invokeinterface 348 1 0
    //   385: checkcast 463	java/lang/String
    //   388: astore 9
    //   390: invokestatic 429	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   393: ifeq +51 -> 444
    //   396: ldc_w 892
    //   399: iconst_4
    //   400: new 378	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 379	java/lang/StringBuilder:<init>	()V
    //   407: ldc_w 2472
    //   410: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload 9
    //   415: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: ldc_w 2474
    //   421: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_0
    //   425: getfield 1945	com/tencent/mobileqq/app/TroopManager:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   428: aload 9
    //   430: invokeinterface 1445 2 0
    //   435: invokevirtual 2477	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 397	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokestatic 439	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   444: new 408	com/tencent/mobileqq/data/CommonlyUsedTroop
    //   447: dup
    //   448: invokespecial 2078	com/tencent/mobileqq/data/CommonlyUsedTroop:<init>	()V
    //   451: astore 10
    //   453: aload 10
    //   455: aload 9
    //   457: putfield 436	com/tencent/mobileqq/data/CommonlyUsedTroop:troopUin	Ljava/lang/String;
    //   460: aload 10
    //   462: aload_0
    //   463: getfield 1945	com/tencent/mobileqq/app/TroopManager:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   466: aload 9
    //   468: invokeinterface 1445 2 0
    //   473: checkcast 771	java/lang/Long
    //   476: invokevirtual 980	java/lang/Long:longValue	()J
    //   479: putfield 600	com/tencent/mobileqq/data/CommonlyUsedTroop:addedTimestamp	J
    //   482: aload 6
    //   484: aload 9
    //   486: aload 10
    //   488: invokevirtual 443	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   491: pop
    //   492: aload 7
    //   494: invokevirtual 2446	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   497: invokeinterface 2216 1 0
    //   502: astore 11
    //   504: aload 11
    //   506: invokeinterface 344 1 0
    //   511: ifeq +112 -> 623
    //   514: aload 11
    //   516: invokeinterface 348 1 0
    //   521: checkcast 463	java/lang/String
    //   524: astore 12
    //   526: aload 12
    //   528: aload 9
    //   530: invokevirtual 467	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   533: ifeq -29 -> 504
    //   536: aload 7
    //   538: aload 12
    //   540: invokevirtual 1169	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   543: pop
    //   544: iconst_1
    //   545: istore_1
    //   546: iload_1
    //   547: ifeq +22 -> 569
    //   550: aload_0
    //   551: aload 5
    //   553: aload 10
    //   555: iconst_0
    //   556: invokespecial 2080	com/tencent/mobileqq/app/TroopManager:a	(Lanuz;Lcom/tencent/mobileqq/data/CommonlyUsedTroop;Z)V
    //   559: aload_0
    //   560: aload 10
    //   562: invokevirtual 1061	com/tencent/mobileqq/app/TroopManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   565: pop
    //   566: goto -198 -> 368
    //   569: aload_0
    //   570: aload 5
    //   572: aload 10
    //   574: iconst_1
    //   575: invokespecial 2080	com/tencent/mobileqq/app/TroopManager:a	(Lanuz;Lcom/tencent/mobileqq/data/CommonlyUsedTroop;Z)V
    //   578: goto -19 -> 559
    //   581: aload 4
    //   583: invokevirtual 1069	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   586: aload 4
    //   588: ifnull -366 -> 222
    //   591: aload 4
    //   593: invokevirtual 1065	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   596: return
    //   597: astore 4
    //   599: aconst_null
    //   600: astore 5
    //   602: goto -297 -> 305
    //   605: astore 6
    //   607: aload 4
    //   609: astore 5
    //   611: aload 6
    //   613: astore 4
    //   615: goto -310 -> 305
    //   618: astore 5
    //   620: goto -427 -> 193
    //   623: iconst_0
    //   624: istore_1
    //   625: goto -79 -> 546
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	628	0	this	TroopManager
    //   545	80	1	m	int
    //   127	52	2	l1	long
    //   1	591	4	localObject1	Object
    //   597	11	4	localObject2	Object
    //   613	1	4	localObject3	Object
    //   16	57	5	localObject4	Object
    //   191	13	5	localThrowable1	Throwable
    //   233	377	5	localObject5	Object
    //   618	1	5	localThrowable2	Throwable
    //   7	251	6	localConcurrentHashMap	ConcurrentHashMap
    //   295	188	6	localMap	Map
    //   605	7	6	localObject6	Object
    //   82	455	7	localObject7	Object
    //   275	104	8	localObject8	Object
    //   388	141	9	str1	String
    //   451	122	10	localCommonlyUsedTroop	CommonlyUsedTroop
    //   502	13	11	localIterator	Iterator
    //   524	15	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   27	50	191	java/lang/Throwable
    //   50	62	191	java/lang/Throwable
    //   62	188	191	java/lang/Throwable
    //   223	247	191	java/lang/Throwable
    //   247	292	191	java/lang/Throwable
    //   318	368	191	java/lang/Throwable
    //   368	444	191	java/lang/Throwable
    //   444	504	191	java/lang/Throwable
    //   504	544	191	java/lang/Throwable
    //   550	559	191	java/lang/Throwable
    //   559	566	191	java/lang/Throwable
    //   569	578	191	java/lang/Throwable
    //   581	586	191	java/lang/Throwable
    //   27	50	295	finally
    //   50	62	295	finally
    //   62	188	295	finally
    //   223	247	295	finally
    //   247	292	295	finally
    //   318	368	295	finally
    //   368	444	295	finally
    //   444	504	295	finally
    //   504	544	295	finally
    //   550	559	295	finally
    //   559	566	295	finally
    //   569	578	295	finally
    //   581	586	295	finally
    //   9	18	597	finally
    //   193	212	605	finally
    //   9	18	618	java/lang/Throwable
  }
  
  public void d(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {
      return;
    }
    k(paramTroopInfo.troopuin);
    b(paramTroopInfo);
    i();
  }
  
  public void d(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void d(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putInt(jdField_d_of_type_JavaLangString, paramInt).commit();
  }
  
  public void d(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1 + paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab..troopgroup_vedio.invite", 2, "removeGroupInviteStatus groupUin : " + paramString1);
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public boolean d()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, "isTroopConfessPanelOpen isConfessPanelOpen: " + this.jdField_b_of_type_Boolean);
      }
      boolean bool = this.jdField_b_of_type_Boolean;
      return bool;
    }
    finally {}
  }
  
  public boolean d(String paramString)
  {
    return b().get(paramString) != null;
  }
  
  public boolean d(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1 + paramString2);
      if ((QLog.isColorLevel()) && (QLog.isColorLevel())) {
        QLog.d("Q.contacttab..troopgroup_vedio.invite", 2, new Object[] { "isTheSameInviterInviting re:" + bool + ", troopUin : " + paramString1, ", inviterUin:" + paramString2 });
      }
      return bool;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public int e(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getInt(jdField_f_of_type_JavaLangString, 0);
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 204	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: bipush 60
    //   6: invokevirtual 222	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9: checkcast 373	com/tencent/mobileqq/app/HotChatManager
    //   12: astore_2
    //   13: aload_0
    //   14: getfield 204	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17: bipush 52
    //   19: invokevirtual 222	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   22: checkcast 2	com/tencent/mobileqq/app/TroopManager
    //   25: astore_3
    //   26: aload_0
    //   27: invokespecial 2246	com/tencent/mobileqq/app/TroopManager:b	()Ljava/util/concurrent/ConcurrentHashMap;
    //   30: astore 4
    //   32: aload_0
    //   33: getfield 218	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   36: invokevirtual 1045	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +138 -> 179
    //   44: aload_1
    //   45: invokevirtual 1050	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   48: aload_0
    //   49: getfield 218	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   52: ldc_w 1035
    //   55: invokevirtual 2466	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   58: pop
    //   59: aload 4
    //   61: invokevirtual 2469	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   64: aload_0
    //   65: getfield 2301	com/tencent/mobileqq/app/TroopManager:jdField_d_of_type_JavaUtilMap	Ljava/util/Map;
    //   68: ifnull +107 -> 175
    //   71: aload_0
    //   72: getfield 2301	com/tencent/mobileqq/app/TroopManager:jdField_d_of_type_JavaUtilMap	Ljava/util/Map;
    //   75: invokeinterface 2470 1 0
    //   80: invokeinterface 2216 1 0
    //   85: astore 5
    //   87: aload 5
    //   89: invokeinterface 344 1 0
    //   94: ifeq +81 -> 175
    //   97: aload 5
    //   99: invokeinterface 348 1 0
    //   104: checkcast 463	java/lang/String
    //   107: astore 6
    //   109: aload 6
    //   111: aload_0
    //   112: aload_2
    //   113: aload_3
    //   114: aload_0
    //   115: getfield 204	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   118: aload 6
    //   120: invokespecial 2490	com/tencent/mobileqq/app/TroopManager:a	(Lcom/tencent/mobileqq/app/HotChatManager;Lcom/tencent/mobileqq/app/TroopManager;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   123: aload_0
    //   124: getfield 2301	com/tencent/mobileqq/app/TroopManager:jdField_d_of_type_JavaUtilMap	Ljava/util/Map;
    //   127: aload 6
    //   129: invokeinterface 1445 2 0
    //   134: checkcast 771	java/lang/Long
    //   137: invokevirtual 980	java/lang/Long:longValue	()J
    //   140: invokestatic 2313	com/tencent/mobileqq/data/ShowExternalTroop:createShowExternalTroop	(Ljava/lang/String;Ljava/lang/String;J)Lcom/tencent/mobileqq/data/ShowExternalTroop;
    //   143: astore 7
    //   145: aload 4
    //   147: aload 6
    //   149: aload 7
    //   151: invokevirtual 443	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   154: pop
    //   155: aload_0
    //   156: aload 7
    //   158: invokevirtual 1061	com/tencent/mobileqq/app/TroopManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   161: pop
    //   162: goto -75 -> 87
    //   165: astore_2
    //   166: aload_1
    //   167: ifnull +7 -> 174
    //   170: aload_1
    //   171: invokevirtual 1065	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   174: return
    //   175: aload_1
    //   176: invokevirtual 1069	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   179: aload_1
    //   180: ifnull -6 -> 174
    //   183: aload_1
    //   184: invokevirtual 1065	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   187: return
    //   188: astore_2
    //   189: aconst_null
    //   190: astore_1
    //   191: aload_1
    //   192: ifnull +7 -> 199
    //   195: aload_1
    //   196: invokevirtual 1065	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   199: aload_2
    //   200: athrow
    //   201: astore_2
    //   202: goto -11 -> 191
    //   205: astore_1
    //   206: aconst_null
    //   207: astore_1
    //   208: goto -42 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	TroopManager
    //   39	157	1	localEntityTransaction	EntityTransaction
    //   205	1	1	localThrowable1	Throwable
    //   207	1	1	localObject1	Object
    //   12	101	2	localHotChatManager	HotChatManager
    //   165	1	2	localThrowable2	Throwable
    //   188	12	2	localObject2	Object
    //   201	1	2	localObject3	Object
    //   25	89	3	localTroopManager	TroopManager
    //   30	116	4	localConcurrentHashMap	ConcurrentHashMap
    //   85	13	5	localIterator	Iterator
    //   107	41	6	str	String
    //   143	14	7	localShowExternalTroop	ShowExternalTroop
    // Exception table:
    //   from	to	target	type
    //   44	87	165	java/lang/Throwable
    //   87	162	165	java/lang/Throwable
    //   175	179	165	java/lang/Throwable
    //   32	40	188	finally
    //   44	87	201	finally
    //   87	162	201	finally
    //   175	179	201	finally
    //   32	40	205	java/lang/Throwable
  }
  
  public void e(TroopInfo paramTroopInfo)
  {
    a(paramTroopInfo, NetConnInfoCenter.getServerTime());
  }
  
  public void e(String paramString)
  {
    TroopInfo localTroopInfo = b(paramString);
    if ((localTroopInfo == null) || (localTroopInfo.eliminated != 1))
    {
      QLog.i("troop_ext", 1, "onTroopReceiveOrSendMsg troopInfo is null or not eliminated. troopUin: " + paramString);
      return;
    }
    long l1 = NetConnInfoCenter.getServerTime();
    if ((this.jdField_e_of_type_JavaUtilMap != null) && (this.jdField_e_of_type_JavaUtilMap.containsKey(paramString)))
    {
      if (l1 - ((Long)this.jdField_e_of_type_JavaUtilMap.get(paramString)).longValue() < 60L) {
        QLog.i("troop_ext", 1, "onTroopReceiveOrSendMsg current time - time < 60s.");
      }
    }
    else
    {
      if (this.jdField_e_of_type_JavaUtilMap == null) {
        this.jdField_e_of_type_JavaUtilMap = new ConcurrentHashMap();
      }
      this.jdField_e_of_type_JavaUtilMap.put(paramString, Long.valueOf(l1));
    }
    ((anca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20)).y(paramString);
  }
  
  public void e(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putInt(jdField_e_of_type_JavaLangString, paramInt).commit();
  }
  
  public boolean e()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, "isTroopAIOOpen : " + this.jdField_c_of_type_Boolean);
      }
      boolean bool = this.jdField_c_of_type_Boolean;
      return bool;
    }
    finally {}
  }
  
  public boolean e(String paramString)
  {
    paramString = (ShowExternalTroop)b().remove(paramString);
    if (paramString != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(paramString);
      return true;
    }
    return false;
  }
  
  public int f(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getInt(g, 0);
  }
  
  public void f()
  {
    if (this.jdField_e_of_type_JavaUtilArrayList != null) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.contacttab.troop", 2, "getTroopsMemberList(memberLimit), last getTroopsMemberList(int memberLimit) is not finished.");
      }
    }
    Object localObject2;
    do
    {
      return;
      localObject2 = b();
      if (localObject2 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.contacttab.troop", 2, "getTroopsMemberList(memberLimit), troopList is null");
    return;
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    anca localanca = (anca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20);
    int i1;
    int m;
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      i1 = 0;
      m = 0;
    }
    int i3;
    for (int n = 0;; n = i3)
    {
      int i2;
      if (i1 < ((ArrayList)localObject2).size())
      {
        TroopInfo localTroopInfo = (TroopInfo)((ArrayList)localObject2).get(i1);
        i2 = m;
        i3 = n;
        if (a(localTroopInfo, false)) {
          try
          {
            this.jdField_e_of_type_JavaUtilArrayList.add(localTroopInfo);
            i3 = n + 1;
            i2 = m + localTroopInfo.wMemberNum;
          }
          finally {}
        }
      }
      else
      {
        if (this.jdField_e_of_type_JavaUtilArrayList.size() > 0)
        {
          localObject2 = (TroopInfo)this.jdField_e_of_type_JavaUtilArrayList.get(0);
          localObject1.a(true, ((TroopInfo)localObject2).troopuin, ((TroopInfo)localObject2).troopcode, 4);
        }
        while (n > 0)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("reqUin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          localHashMap.put("tpNum", String.valueOf(n));
          localHashMap.put("tpMemNum", String.valueOf(m));
          localHashMap.put("isFirst", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("is_first_upgrade_to_500", 0)));
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "tMSearchUpdateReq", false, 0L, 0L, localHashMap, "");
          return;
          this.jdField_e_of_type_JavaUtilArrayList = null;
          continue;
          this.jdField_e_of_type_JavaUtilArrayList = null;
          m = 0;
          n = 0;
        }
        break;
      }
      i1 += 1;
      m = i2;
    }
  }
  
  public void f(String paramString)
  {
    int m = 0;
    while (m < this.jdField_f_of_type_JavaUtilArrayList.size())
    {
      ((andc)this.jdField_f_of_type_JavaUtilArrayList.get(m)).b(paramString);
      m += 1;
    }
  }
  
  public void f(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putInt(jdField_f_of_type_JavaLangString, paramInt).commit();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("show_troop_big_club", true);
  }
  
  public boolean f(String paramString)
  {
    try
    {
      boolean bool = TextUtils.equals(paramString, this.jdField_a_of_type_JavaLangString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public int g(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getInt(h, 0);
  }
  
  public void g()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    str = "show_new_create_big_troop2_" + str;
    localSharedPreferences.edit().putBoolean(str, true).commit();
  }
  
  public void g(String paramString)
  {
    int m = 0;
    while (m < this.jdField_f_of_type_JavaUtilArrayList.size())
    {
      ((andc)this.jdField_f_of_type_JavaUtilArrayList.get(m)).a(paramString);
      m += 1;
    }
  }
  
  public void g(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putInt(g, paramInt).commit();
  }
  
  /* Error */
  public boolean g(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +22 -> 28
    //   9: aload_0
    //   10: getfield 193	com/tencent/mobileqq/app/TroopManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   13: aload_1
    //   14: invokevirtual 2525	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   17: istore_2
    //   18: iload_2
    //   19: ifeq +9 -> 28
    //   22: iconst_1
    //   23: istore_2
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_2
    //   27: ireturn
    //   28: iconst_0
    //   29: istore_2
    //   30: goto -6 -> 24
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	TroopManager
    //   0	38	1	paramString	String
    //   17	13	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	33	finally
  }
  
  public int h(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getInt(i, 0);
  }
  
  /* Error */
  public void h(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +19 -> 25
    //   9: aload_0
    //   10: getfield 193	com/tencent/mobileqq/app/TroopManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   13: aload_1
    //   14: invokevirtual 2525	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   17: istore_2
    //   18: iload_2
    //   19: ifeq +6 -> 25
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 193	com/tencent/mobileqq/app/TroopManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   29: aload_1
    //   30: invokevirtual 473	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   33: pop
    //   34: goto -12 -> 22
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	TroopManager
    //   0	42	1	paramString	String
    //   17	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	37	finally
    //   25	34	37	finally
  }
  
  public void h(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putInt(h, paramInt).commit();
  }
  
  public boolean h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("Q.contacttab.", 1, "isPassiveExit, troopUin is empty");
    }
    do
    {
      return false;
      paramString = a(paramString, true);
    } while ((paramString == null) || ((!paramString.isKicked()) && (!paramString.isDisband())));
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, String.format("isPassiveExit reason: %s", new Object[] { Integer.valueOf(paramString.exitTroopReason) }));
    }
    return true;
  }
  
  public int i(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getInt(k, 0);
  }
  
  /* Error */
  public void i(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 193	com/tencent/mobileqq/app/TroopManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   18: aload_1
    //   19: invokevirtual 2254	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   22: pop
    //   23: goto -12 -> 11
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	TroopManager
    //   0	31	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
    //   14	23	26	finally
  }
  
  public void i(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putInt(i, paramInt).commit();
  }
  
  public boolean i(String paramString)
  {
    if (!aqgn.c().jdField_a_of_type_Boolean)
    {
      TroopInfo localTroopInfo = b(paramString);
      if ((localTroopInfo != null) && (localTroopInfo.checkFlagExt4(3))) {
        if (QLog.isColorLevel()) {
          QLog.d("vip_pretty.Q.contacttab.", 1, "troop " + paramString + " is pretty so req group care");
        }
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getInt(jdField_b_of_type_JavaLangString, 0) < System.currentTimeMillis() / 1000L) {
      return true;
    }
    return false;
  }
  
  public int j(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getInt(l, 0);
  }
  
  public void j(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("Q.contacttab.", 1, "addPassiveExitGrayTips, troopUin is empty");
    }
    paramString = a(paramString, true);
    if (paramString == null)
    {
      QLog.e("Q.contacttab.", 1, "addPassiveExitGrayTips, troopInfo == null");
      return;
    }
    switch (paramString.exitTroopReason)
    {
    default: 
      return;
    case 1: 
      a(paramString.troopuin, NetConnInfoCenter.getServerTime(), 0L, 131080);
      return;
    }
    a(paramString.troopuin, NetConnInfoCenter.getServerTime(), 0L, 131081);
  }
  
  public void j(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putInt(k, paramInt).commit();
  }
  
  public boolean j(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getBoolean(j, true);
  }
  
  public int k(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (!this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      return 0;
    }
    return ((Integer)this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).intValue();
  }
  
  public void k(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.d("Q.contacttab.", 1, "clearPassiveExitTroopInfo, troopUin is empty!");
    }
    do
    {
      TroopInfo localTroopInfo;
      do
      {
        return;
        localTroopInfo = a(paramString, true);
      } while ((localTroopInfo == null) || (!localTroopInfo.isExited()));
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, String.format("clearPassiveExitTroopInfo, troopUin: %s, exit reason: %s", new Object[] { paramString, Integer.valueOf(localTroopInfo.exitTroopReason) }));
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localTroopInfo);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      }
      avnu.a().b(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().clearHistory(paramString, 1);
      b(paramString, true);
    } while (!QLog.isColorLevel());
    QLog.d("Q.contacttab.", 2, new Throwable("clearPassiveExitTroopInfo.debug"), new Object[0]);
  }
  
  public void k(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putInt(l, paramInt).commit();
  }
  
  public boolean k(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new ArraySet();
      Set localSet = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getStringSet("group_invite_accept_handle_set", null);
      if (localSet != null) {
        this.jdField_a_of_type_JavaUtilSet.addAll(localSet);
      }
    }
    boolean bool = this.jdField_a_of_type_JavaUtilSet.contains(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "hasHandleGroupInviteAccept key:" + paramString + " res:" + bool);
    }
    return bool;
  }
  
  public void l(String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0);
    if ((paramString.contains(jdField_d_of_type_JavaLangString)) || (paramString.contains(h))) {
      paramString.edit().remove(jdField_d_of_type_JavaLangString).remove(jdField_f_of_type_JavaLangString).remove(g).remove(h).remove(j).remove(k).remove(l).commit();
    }
  }
  
  public void l(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  public boolean l(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new ArraySet();
      Set localSet = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_group_sysmsg", 0).getStringSet("processed_cache", null);
      if (localSet != null) {
        this.jdField_b_of_type_JavaUtilSet.addAll(localSet);
      }
    }
    boolean bool = this.jdField_b_of_type_JavaUtilSet.contains(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "hasGroupSystemMsgProcessed key:" + paramString + " res:" + bool);
    }
    return bool;
  }
  
  public void m(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "markHasHandleGroupInviteAccept key:" + paramString);
    }
    if (this.jdField_a_of_type_JavaUtilSet == null) {
      this.jdField_a_of_type_JavaUtilSet = new ArraySet();
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramString);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit().putStringSet("group_invite_accept_handle_set", this.jdField_a_of_type_JavaUtilSet).apply();
  }
  
  public void n(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "markGroupSystemMsgProcessed key:" + paramString);
    }
    if (this.jdField_b_of_type_JavaUtilSet == null) {
      this.jdField_b_of_type_JavaUtilSet = new ArraySet();
    }
    this.jdField_b_of_type_JavaUtilSet.add(paramString);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_group_sysmsg", 0).edit().putStringSet("processed_cache", this.jdField_b_of_type_JavaUtilSet).apply();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConfigProcess().a(this);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    this.jdField_a_of_type_JavaUtilMap.clear();
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager
 * JD-Core Version:    0.7.0.1
 */