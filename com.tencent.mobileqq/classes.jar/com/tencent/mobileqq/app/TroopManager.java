package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.PBUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.proxy.fts.FTSTroopOperator;
import com.tencent.mobileqq.app.utils.BatchAddFriendForTroopConfig;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.HWTroopMemberCard;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.javahook.DetectContactDelete;
import com.tencent.mobileqq.lightReply.LightReplyMenuManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.profile.TroopMemberCardConstants;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.SearchConfigManager.TroopMemberSetting;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.homework.config.HomeworkConfig;
import com.tencent.mobileqq.troop.homework.recite.config.ReciteConfig;
import com.tencent.mobileqq.troop.utils.TroopLinkManager;
import com.tencent.mobileqq.troop.utils.TroopMemberThreadManager;
import com.tencent.mobileqq.troop.utils.TroopNameHelper;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.util.TroopSystemMsgUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
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
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6ef.oidb_cmd0x6ef.ReqBody;
import tencent.im.oidb.cmd0x787.oidb_0x787.Filter;
import tencent.im.oidb.cmd0x787.oidb_0x787.ReqBody;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.RspBody;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.ToastInfo;
import zuw;
import zux;
import zuy;
import zuz;
import zvb;
import zvd;
import zvf;
import zvh;
import zvi;
import zvk;

public class TroopManager
  implements Manager
{
  public static final TroopManager.DownloadFileConfig a;
  public int a;
  protected LruCache a;
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  public QQAppInterface a;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new zux(this);
  private BatchAddFriendForTroopConfig jdField_a_of_type_ComTencentMobileqqAppUtilsBatchAddFriendForTroopConfig;
  protected EntityManager a;
  public final HomeworkConfig a;
  public final ReciteConfig a;
  TroopNameHelper jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper;
  private Runnable jdField_a_of_type_JavaLangRunnable = new zuw(this);
  protected String a;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected HashMap a;
  public Map a;
  Queue jdField_a_of_type_JavaUtilQueue = new LinkedList();
  protected ConcurrentHashMap a;
  protected boolean a;
  private int jdField_b_of_type_Int;
  protected LruCache b;
  protected ArrayList b;
  HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  public Map b;
  public ConcurrentHashMap b;
  protected LruCache c;
  private ArrayList c;
  protected Map c;
  protected ConcurrentHashMap c;
  LruCache jdField_d_of_type_AndroidSupportV4UtilLruCache = new LruCache(10);
  private ArrayList jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  protected Map d;
  protected ConcurrentHashMap d;
  private Map e = new HashMap();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqAppTroopManager$DownloadFileConfig = new TroopManager.DownloadFileConfig();
  }
  
  public TroopManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new QQConcurrentHashMap(1013, 1350);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(12);
    this.jdField_b_of_type_JavaUtilMap = new HashMap(5);
    this.jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
    this.jdField_c_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(50));
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver, true);
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin() + "_troopManager", 0);
    this.jdField_a_of_type_Int = localSharedPreferences.getInt("troopfileConfigVersion", 0);
    h(localSharedPreferences.getString("troopfileConfig", "{}"));
    TroopLinkManager.a();
    LightReplyMenuManager.a().a(false);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkConfigHomeworkConfig = new HomeworkConfig(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteConfigReciteConfig = new ReciteConfig(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
  }
  
  private ConcurrentHashMap a()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null)
        {
          localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(CommonlyUsedTroop.class, false, null, null, null, null, null, null);
          if (localObject1 == null) {
            break label176;
          }
          i = ((ArrayList)localObject1).size();
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new QQConcurrentHashMap(1014, i, 25);
          int j = 0;
          if (j < i)
          {
            CommonlyUsedTroop localCommonlyUsedTroop = (CommonlyUsedTroop)((ArrayList)localObject1).get(j);
            if (QLog.isColorLevel()) {
              QLog.d("OpenTroopDebug", 2, "init load groupcode = " + localCommonlyUsedTroop.troopUin);
            }
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localCommonlyUsedTroop.troopUin, localCommonlyUsedTroop);
            j += 1;
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CommonlyUsedTroop", 2, "load CommonlyUsedTroop info: size = " + i);
          }
        }
        Object localObject1 = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
        return localObject1;
      }
      finally {}
      label176:
      int i = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
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
    ProtoUtils.b(paramQQAppInterface, paramTroopProtocolObserver, localReqBody.toByteArray(), "OidbSvc.0x787_1", 1927, 1);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    oidb_cmd0x6ef.ReqBody localReqBody = new oidb_cmd0x6ef.ReqBody();
    localReqBody.gc.set(Long.parseLong(paramString1));
    localReqBody.event_id.set(paramString2);
    localReqBody.seq.set(paramLong);
    ProtoUtils.b(paramQQAppInterface, paramTroopProtocolObserver, localReqBody.toByteArray(), "OidbSvc.0x6ef_0", 1775, 0);
    return false;
  }
  
  private boolean a(TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    Object localObject1;
    int i;
    Object localObject3;
    label165:
    boolean bool;
    label173:
    label214:
    int j;
    long l1;
    if (!paramBoolean)
    {
      SearchConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject1 = null;
      int k = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("is_first_upgrade_to_500", 0);
      if (k == 0) {
        i = 1;
      }
      for (;;)
      {
        if ((SearchConfigManager.troopMemberUpdateConfigs != null) && (!SearchConfigManager.troopMemberUpdateConfigs.isEmpty()))
        {
          Iterator localIterator = SearchConfigManager.troopMemberUpdateConfigs.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              SearchConfigManager.TroopMemberSetting localTroopMemberSetting = (SearchConfigManager.TroopMemberSetting)localIterator.next();
              if (i != 0)
              {
                localObject3 = localTroopMemberSetting;
                if (localObject1 != null)
                {
                  if (localObject1.jdField_b_of_type_Int <= localTroopMemberSetting.jdField_b_of_type_Int) {
                    break label729;
                  }
                  localObject3 = localTroopMemberSetting;
                }
                localObject1 = localObject3;
                continue;
                i = 0;
                break;
              }
              if ((paramTroopInfo.wMemberNum > localTroopMemberSetting.jdField_a_of_type_Int) && (paramTroopInfo.wMemberNum < localTroopMemberSetting.jdField_b_of_type_Int))
              {
                localObject1 = localTroopMemberSetting;
                if (localObject1 == null)
                {
                  bool = false;
                  paramBoolean = bool;
                  if (i != 0)
                  {
                    paramBoolean = bool;
                    if (localObject1 != null)
                    {
                      if ((paramTroopInfo.wMemberNum <= localObject1.jdField_a_of_type_Int) || (paramTroopInfo.wMemberNum >= localObject1.jdField_b_of_type_Int)) {
                        break label552;
                      }
                      paramBoolean = true;
                    }
                  }
                  j = 0;
                  l1 = FTSTroopOperator.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopInfo.troopuin);
                  bool = paramBoolean;
                  i = j;
                  if (paramBoolean)
                  {
                    l1 = Math.abs(System.currentTimeMillis() - l1);
                    if (NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
                    {
                      if (l1 >= localObject1.c * 3600000L) {
                        break label720;
                      }
                      paramBoolean = false;
                      label282:
                      if ((!paramBoolean) || (l1 <= localObject1.c * 3600000L * 2L) || (l1 <= 3600000L * localObject1.d)) {
                        break label711;
                      }
                      i = 1;
                      bool = paramBoolean;
                    }
                  }
                  else
                  {
                    label327:
                    paramBoolean = bool;
                    if (k == 2)
                    {
                      paramBoolean = bool;
                      if (bool)
                      {
                        paramBoolean = bool;
                        if (i != 0) {}
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        l1 = Long.valueOf(paramTroopInfo.troopuin).longValue();
        i = Calendar.getInstance().get(5);
        j = localObject1.c / 24;
        paramBoolean = bool;
        if (j != 0)
        {
          long l2 = j;
          paramBoolean = bool;
          if (l1 % l2 != i % j) {
            paramBoolean = false;
          }
        }
      }
      catch (Exception localException)
      {
        label552:
        paramBoolean = bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.contacttab.troop", 2, String.format("needGetMemberListForFTS, except: %s", new Object[] { localException.getMessage() }));
        paramBoolean = bool;
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.contacttab.troop", 2, String.format("needGetMemberListForFTS, ignore troop: %s, wMemberNum: %d, mMemberNumSeq: %d mOldMemberNumSeq: %d, mMemberCardSeq: %d, mOldMemberCardSeq:%d, overtime: %s", new Object[] { paramTroopInfo.troopuin, Integer.valueOf(paramTroopInfo.wMemberNum), Long.valueOf(paramTroopInfo.mMemberNumSeq), Long.valueOf(paramTroopInfo.mOldMemberNumSeq), Long.valueOf(paramTroopInfo.mMemberCardSeq), Long.valueOf(paramTroopInfo.mOldMemberCardSeq), Boolean.valueOf(paramBoolean) }));
        return false;
      }
      if ((paramBoolean) && ((!QLog.isColorLevel()) || ((paramTroopInfo.mMemberNumSeq != paramTroopInfo.mOldMemberNumSeq) || (paramTroopInfo.mMemberNumSeq == -1L) || (paramTroopInfo.mMemberCardSeq != paramTroopInfo.mOldMemberCardSeq) || (paramTroopInfo.mMemberCardSeq == -1L))))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.contacttab.troop", 2, String.format("needGetMemberListForFTS, get troop: %s, wMemberNum: %d, mMemberNumSeq: %d mOldMemberNumSeq: %d, mMemberCardSeq: %d, mOldMemberCardSeq:%d", new Object[] { paramTroopInfo.troopuin, Integer.valueOf(paramTroopInfo.wMemberNum), Long.valueOf(paramTroopInfo.mMemberNumSeq), Long.valueOf(paramTroopInfo.mOldMemberNumSeq), Long.valueOf(paramTroopInfo.mMemberCardSeq), Long.valueOf(paramTroopInfo.mOldMemberCardSeq) }));
        }
        return true;
        paramBoolean = false;
        break label214;
        if (l1 >= localObject1.d * 3600000L) {
          break label720;
        }
        paramBoolean = false;
        break label282;
      }
      label711:
      bool = paramBoolean;
      i = j;
      break label327;
      label720:
      break label282;
      bool = true;
      break label173;
      label729:
      localObject3 = localException;
      break;
      break label165;
      Object localObject2 = null;
      break label165;
      paramBoolean = true;
    }
  }
  
  private ConcurrentHashMap b()
  {
    int j = 0;
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ShowExternalTroop.class, false, null, null, null, null, null, null);
      if (localArrayList != null) {}
      for (int i = localArrayList.size();; i = 0)
      {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new QQConcurrentHashMap(1015, i, 70);
        while (j < i)
        {
          ShowExternalTroop localShowExternalTroop = (ShowExternalTroop)localArrayList.get(j);
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(localShowExternalTroop.troopUin, localShowExternalTroop);
          j += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, "load mShowExternalTroopCache info: size = " + i);
      }
    }
    return this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  private void b(String paramString1, String paramString2, TroopMemberInfo paramTroopMemberInfo)
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
  
  private void c(ArrayList paramArrayList)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      if (paramArrayList == null) {
        break label33;
      }
    }
    label33:
    for (int i = paramArrayList.size();; i = 0)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(i);
      if (paramArrayList != null) {
        break;
      }
      return;
    }
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    for (;;)
    {
      try
      {
        localEntityTransaction.a();
        i = 0;
        if (i < paramArrayList.size())
        {
          TroopInfo localTroopInfo = (TroopInfo)paramArrayList.get(i);
          Object localObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
          if ((localTroopInfo == null) || (((HotChatManager)localObject).b(localTroopInfo.troopuin)) || ((localTroopInfo != null) && (localTroopInfo.troopuin == null) && (localTroopInfo.troopcode == null))) {
            break label270;
          }
          if ((localTroopInfo.troopcode == null) || (localTroopInfo.troopcode.length() <= 1))
          {
            localObject = (Entity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localTroopInfo.troopuin);
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
        localEntityTransaction.b();
        g();
        return;
        localEntityTransaction.c();
        localEntityTransaction.b();
        continue;
      }
      finally
      {
        localEntityTransaction.b();
      }
      label270:
      i += 1;
    }
  }
  
  private void c(List paramList)
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
          ProxyManager localProxyManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          RecentUser localRecentUser = localProxyManager.a().a(localTroopInfo.troopuin, 1);
          localRecentUser.displayName = localTroopInfo.getTroopName();
          if (localRecentUser.getStatus() == 1001) {
            localProxyManager.a().a(localRecentUser);
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
  
  private void f()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.troop", 2, "initTroopListCache begin");
    }
    localObject2 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopInfo.class, false, null, null, null, null, null, null);
    if (localObject2 != null) {}
    ConcurrentHashMap localConcurrentHashMap;
    ArrayList localArrayList;
    for (int i = ((ArrayList)localObject2).size();; i = 0)
    {
      localConcurrentHashMap = new ConcurrentHashMap(i);
      if (localObject2 == null) {
        break label221;
      }
      localArrayList = new ArrayList();
      i = 0;
      while (i < ((ArrayList)localObject2).size())
      {
        TroopInfo localTroopInfo = (TroopInfo)((ArrayList)localObject2).get(i);
        if ((localTroopInfo.mCompareSpell == null) || (localTroopInfo.mCompareSpell.length() == 0))
        {
          ContactSorter.a(localTroopInfo);
          localArrayList.add(localTroopInfo);
        }
        localConcurrentHashMap.put(localTroopInfo.troopuin, localTroopInfo);
        i += 1;
      }
    }
    if (localArrayList.size() > 0) {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
    try
    {
      ((EntityTransaction)localObject2).a();
      i = j;
      while (i < localArrayList.size())
      {
        a((Entity)localArrayList.get(i));
        i += 1;
      }
      ((EntityTransaction)localObject2).c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ((EntityTransaction)localObject2).b();
      }
    }
    finally
    {
      ((EntityTransaction)localObject2).b();
    }
    localArrayList.clear();
    label221:
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(localConcurrentHashMap);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.troop", 2, "initTroopListCache end: " + localConcurrentHashMap.size());
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.troop", 2, "buildTroopUI begin: ");
    }
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      int i = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
      if (i > 0)
      {
        localArrayList.ensureCapacity(i);
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        while (localIterator.hasNext())
        {
          TroopInfo localTroopInfo = (TroopInfo)localIterator.next();
          if ((localTroopInfo.mCompareSpell == null) || (localTroopInfo.mCompareSpell.length() == 0)) {
            ContactSorter.a(localTroopInfo);
          }
          localArrayList.add(localTroopInfo);
        }
        if (i > 1) {
          Collections.sort(localArrayList, ContactSorter.a);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.troop", 2, "buildTroopUI end: " + localArrayList.size());
    }
  }
  
  private boolean h(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString));
  }
  
  private void k(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(paramString);
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
  
  public long a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getLong("oldestUniqueTitleExpireTime", 0L);
  }
  
  public long a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.troop", 2, "getIsTroopMemberFollowed uin is null");
      }
    }
    do
    {
      return 0L;
      paramString1 = b(paramString1, paramString2);
    } while (paramString1 == null);
    return paramString1.distanceToSelfUpdateTimeStamp;
  }
  
  public Drawable a(int paramInt, String paramString)
  {
    TroopManager.TroopMemberLevelValue localTroopMemberLevelValue = new TroopManager.TroopMemberLevelValue(this);
    localTroopMemberLevelValue.jdField_a_of_type_Int = paramInt;
    localTroopMemberLevelValue.jdField_a_of_type_JavaLangString = paramString;
    return (Drawable)this.jdField_d_of_type_AndroidSupportV4UtilLruCache.get(localTroopMemberLevelValue);
  }
  
  public TroopManager.DownloadFileConfig a(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      localObject = paramString.toLowerCase();
    }
    localObject = (TroopManager.DownloadFileConfig)this.e.get(localObject);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = (TroopManager.DownloadFileConfig)this.e.get("*");
    }
    localObject = paramString;
    if (paramString == null) {
      localObject = jdField_a_of_type_ComTencentMobileqqAppTroopManager$DownloadFileConfig;
    }
    return localObject;
  }
  
  public TroopManager.MemberGagInfo a(String paramString1, String paramString2)
  {
    paramString1 = b(paramString1, paramString2);
    long l = 0L;
    if (paramString1 != null) {
      l = paramString1.gagTimeStamp;
    }
    return new TroopManager.MemberGagInfo(this, paramString2, l);
  }
  
  public BatchAddFriendForTroopConfig a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppUtilsBatchAddFriendForTroopConfig == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsBatchAddFriendForTroopConfig = new BatchAddFriendForTroopConfig(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppUtilsBatchAddFriendForTroopConfig;
  }
  
  public HWTroopMemberCard a(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + "_" + paramString2;
    return (HWTroopMemberCard)this.jdField_c_of_type_AndroidSupportV4UtilLruCache.get(paramString1);
  }
  
  public MessageRecord a(String paramString1, String paramString2)
  {
    if (TroopMemberCardConstants.a != null)
    {
      int j = TroopMemberCardConstants.a.length;
      if (j > 0)
      {
        localObject = new StringBuilder();
        int i = 0;
        while (i < j)
        {
          ((StringBuilder)localObject).append(TroopMemberCardConstants.a[i]);
          if (i < j - 1) {
            ((StringBuilder)localObject).append(" , ");
          }
          i += 1;
        }
      }
    }
    for (Object localObject = ((StringBuilder)localObject).toString();; localObject = null)
    {
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      paramString1 = localEntityManager.a(MessageRecord.class, MessageRecord.getTableName(paramString1, 1), false, String.format("shmsgseq < %d and senderuin = ? and extLong & 3 <> 3 and msgtype in (%s)", new Object[] { Long.valueOf(9223372036854775807L), localObject }), new String[] { paramString2 }, null, null, "shmsgseq DESC", String.valueOf(1));
      localEntityManager.a();
      if ((paramString1 == null) || (paramString1.isEmpty())) {
        return null;
      }
      return (MessageRecord)paramString1.get(0);
    }
  }
  
  public TroopInfo a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "findTroopInfo, troopUin isEmpty:" + paramString);
      }
      localObject = null;
    }
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        do
        {
          return localObject;
          localTroopInfo = (TroopInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          localObject = localTroopInfo;
        } while (localTroopInfo != null);
        localObject = localTroopInfo;
      } while (this.jdField_a_of_type_Boolean);
      localTroopInfo = (TroopInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopInfo.class, paramString);
      localObject = localTroopInfo;
    } while (localTroopInfo == null);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localTroopInfo);
    return localTroopInfo;
  }
  
  protected TroopInfo a(String paramString1, String paramString2)
  {
    TroopInfo localTroopInfo2 = a(paramString1);
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
    ContactSorter.a(localTroopInfo1);
    g();
    return localTroopInfo1;
  }
  
  public TroopMemberCard a(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + "_" + paramString2;
    return (TroopMemberCard)this.jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramString1);
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
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
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
    Object localObject1 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(paramTroopMemberInfo.memberuin);
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
      paramTroopMemberInfo = a(paramTroopMemberInfo.troopuin);
      localObject1 = localObject2;
      if (paramTroopMemberInfo == null) {
        break;
      }
      localObject1 = localObject2;
      if (!paramTroopMemberInfo.isQidianPrivateTroop()) {
        break;
      }
      return "群成员";
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
    TroopInfo localTroopInfo = a(paramString);
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
    return ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
  }
  
  public ArrayList a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public ArrayList a(String paramString)
  {
    Object localObject = b(paramString);
    paramString = new ArrayList();
    if ((localObject == null) || (((TroopInfo)localObject).mHeaderUinsNew == null) || (((TroopInfo)localObject).mHeaderUinsNew == " ")) {}
    for (;;)
    {
      return paramString;
      localObject = ((TroopInfo)localObject).mHeaderUinsNew.split(";");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = localObject[i];
        if (!TextUtils.isEmpty(localCharSequence)) {
          paramString.add(localCharSequence);
        }
        i += 1;
      }
    }
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a().values().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((CommonlyUsedTroop)localIterator.next());
    }
    return localArrayList;
  }
  
  public List a(String paramString)
  {
    if ((paramString == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    ArrayList localArrayList;
    do
    {
      return null;
      localArrayList = new ArrayList();
      paramString = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopNotificationCache.class, true, "troopUin=? and read=? and currentUin=?", new String[] { paramString, "0", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }, null, null, "time ASC", null);
    } while (paramString == null);
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < paramString.size())
    {
      TroopNotificationCache localTroopNotificationCache = (TroopNotificationCache)paramString.get(i);
      if (localHashMap.containsKey(localTroopNotificationCache.feedsId)) {}
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localTroopNotificationCache);
        localHashMap.put(localTroopNotificationCache.feedsId, Integer.valueOf(1));
      }
    }
    return localArrayList;
  }
  
  public oidb_cmd0xb36.ToastInfo a(String paramString)
  {
    AssertUtils.a(paramString);
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
    int i = (int)NetConnInfoCenter.getServerTime();
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
          int j = localRspBody.toast.expired.get();
          l1 = l2;
          if (j > i)
          {
            l2 = Math.max(60L, Math.min(l2, j - i));
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
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    TroopInfo localTroopInfo = localTroopManager.a(String.valueOf(paramLong1));
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
    TroopManager.TroopMemberLevelValue localTroopMemberLevelValue = new TroopManager.TroopMemberLevelValue(this);
    localTroopMemberLevelValue.jdField_a_of_type_Int = paramInt;
    localTroopMemberLevelValue.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_d_of_type_AndroidSupportV4UtilLruCache.put(localTroopMemberLevelValue, paramDrawable);
  }
  
  public void a(TroopManager.TroopMemberUpdateObserver paramTroopMemberUpdateObserver)
  {
    try
    {
      this.jdField_d_of_type_JavaUtilArrayList.add(paramTroopMemberUpdateObserver);
      return;
    }
    finally
    {
      paramTroopMemberUpdateObserver = finally;
      throw paramTroopMemberUpdateObserver;
    }
  }
  
  public void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramTroopInfo.troopuin))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramTroopInfo.troopuin, paramTroopInfo);
    }
    a(paramTroopInfo);
    g();
  }
  
  public void a(TroopInfo paramTroopInfo, long paramLong)
  {
    if (paramTroopInfo == null) {}
    ProxyManager localProxyManager;
    RecentUser localRecentUser;
    do
    {
      return;
      localProxyManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localRecentUser = localProxyManager.a().a(paramTroopInfo.troopuin, 1);
      localRecentUser.displayName = paramTroopInfo.getTroopName();
    } while (localRecentUser.getStatus() != 1000);
    localRecentUser.lastmsgtime = paramLong;
    HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser);
    localProxyManager.a().a(localRecentUser);
    ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0)).a(6003, true, new String[] { paramTroopInfo.troopuin, "0" });
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
    g();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "tm->deleteTroop-->delete troop");
    }
    TroopNotificationHelper.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    TroopAssistantManager.a().b(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 1);
    a(paramString, true);
    ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(63, true, paramString);
    f(paramString);
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(Long.parseLong(paramString))) {
        BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.contacttab.", 2, "tm->deleteTroop-->NumberFormatException, troopUin:" + paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (!TextUtils.isEmpty(paramString))
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_troopManager", 0).edit();
      localEditor.putInt("troopfileConfigVersion", paramInt);
      localEditor.putString("troopfileConfig", paramString);
      localEditor.commit();
      h(paramString);
    }
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
          paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131429894);
        }
      }
    }
    for (;;)
    {
      MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(-1013);
      localMessageForGrayTips.frienduin = paramString1;
      localMessageForGrayTips.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1, paramString1, paramString2, paramLong1, -1013, 1, paramInt);
      localMessageForGrayTips.isread = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForGrayTips, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131429893);
      continue;
      if ((0x2 & paramLong2) == 2L) {
        if ((0x2 & paramLong3) == 2L) {
          paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131429892);
        } else {
          paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131429891);
        }
      }
    }
  }
  
  public void a(String paramString, TroopManager.callbackInMainThread paramcallbackInMainThread)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramcallbackInMainThread == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "getTroopCodeByTroopUinAsync, param is empty");
      }
      return;
    }
    ThreadManager.post(new zvi(this, paramString, paramcallbackInMainThread), 8, null, false);
  }
  
  public void a(String paramString1, String paramString2)
  {
    int i = 0;
    while (i < this.jdField_d_of_type_JavaUtilArrayList.size())
    {
      ((TroopManager.TroopMemberUpdateObserver)this.jdField_d_of_type_JavaUtilArrayList.get(i)).b(paramString1, paramString2);
      i += 1;
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
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
      b(paramString1, paramString2, localTroopMemberInfo);
    }
    ThreadManager.post(new zuz(this, localTroopMemberInfo, paramString1), 8, null, false);
  }
  
  public void a(String paramString1, String paramString2, TroopManager.ITroopMemberInfoCallBack paramITroopMemberInfoCallBack)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      if (paramITroopMemberInfoCallBack != null)
      {
        localObject = a(paramString1, paramString2);
        if (localObject == null) {
          break label35;
        }
        paramITroopMemberInfoCallBack.a((TroopMemberInfo)localObject);
      }
    }
    label35:
    do
    {
      return;
      paramITroopMemberInfoCallBack.a(c(paramString1, paramString2));
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
    } while (paramITroopMemberInfoCallBack == null);
    paramITroopMemberInfoCallBack.a((TroopMemberInfo)localObject);
    return;
    Object localObject = new ArrayList();
    this.jdField_b_of_type_JavaUtilMap.put(paramString1 + "_" + paramString2, localObject);
    label166:
    if (((List)localObject).isEmpty())
    {
      ((List)localObject).add(new WeakReference(paramITroopMemberInfoCallBack));
      TroopMemberThreadManager.a(new zvf(this, paramString1, paramString2));
      return;
    }
    ((List)localObject).add(new WeakReference(paramITroopMemberInfoCallBack));
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
    if (paramTroopMemberInfo == null) {
      return;
    }
    ThreadManager.post(new zvd(this, paramTroopMemberInfo, new Handler(Looper.getMainLooper()), paramString1, paramString2), 8, null, false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
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
      if (localTroopMemberInfo1.getStatus() == 1000) {
        b(paramString1, paramString2, localTroopMemberInfo1);
      }
      a(paramString1, paramString2, localTroopMemberInfo1);
    }
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
      b(paramString1, paramString2, localTroopMemberInfo1);
      paramString3.b(localTroopMemberInfo1);
    }
    for (;;)
    {
      paramString3.a();
      a(paramString1, paramString2, false);
      return;
      paramString3.a(localTroopMemberInfo1);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    int j = 1;
    TroopMemberInfo localTroopMemberInfo = b(paramString1, paramString2);
    if (localTroopMemberInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "saveHomeworkTroopMemberIdentity , info is null ... ");
      }
    }
    for (;;)
    {
      return;
      TroopMemberCardInfo localTroopMemberCardInfo = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
      int i = 0;
      int k = 0;
      if (paramInt != -100)
      {
        i = k;
        if (paramInt != localTroopMemberInfo.hwIdentity)
        {
          localTroopMemberInfo.hwIdentity = paramInt;
          i = 1;
        }
        if (paramInt != localTroopMemberInfo.level)
        {
          localTroopMemberInfo.level = paramInt;
          if ((localTroopMemberCardInfo != null) && (!TextUtils.equals(String.valueOf(paramInt), localTroopMemberCardInfo.level))) {
            localTroopMemberCardInfo.level = String.valueOf(paramInt);
          }
          i = 1;
        }
      }
      paramInt = i;
      if (!TextUtils.isEmpty(paramString4))
      {
        paramInt = i;
        if (!paramString4.equals(localTroopMemberInfo.hwCourse))
        {
          localTroopMemberInfo.hwCourse = paramString4;
          paramInt = 1;
        }
      }
      i = paramInt;
      if (!TextUtils.isEmpty(paramString5))
      {
        i = paramInt;
        if (!paramString5.equals(localTroopMemberInfo.hwName))
        {
          localTroopMemberInfo.hwName = paramString5;
          i = 1;
        }
      }
      if ((paramString3 != null) && (!paramString3.equals(localTroopMemberInfo.troopnick)))
      {
        localTroopMemberInfo.troopnick = paramString3;
        paramInt = j;
        if (localTroopMemberCardInfo != null)
        {
          paramInt = j;
          if (!TextUtils.equals(paramString3, localTroopMemberCardInfo.name)) {
            localTroopMemberCardInfo.name = paramString3;
          }
        }
      }
      for (paramInt = j; paramInt != 0; paramInt = i)
      {
        if (localTroopMemberInfo.getStatus() == 1000) {
          b(paramString1, paramString2, localTroopMemberInfo);
        }
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localTroopMemberInfo.getStatus() == 1000)
        {
          paramString1.b(localTroopMemberInfo);
          if (localTroopMemberCardInfo != null) {
            paramString1.b(localTroopMemberCardInfo);
          }
        }
        for (;;)
        {
          paramString1.a();
          return;
          paramString1.a(localTroopMemberInfo);
          if (localTroopMemberCardInfo != null) {
            paramString1.a(localTroopMemberCardInfo);
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
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    if (paramBoolean)
    {
      ThreadManager.post(new zvh(this, paramString), 8, null, true);
      return;
    }
    b(paramString, -1L);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putString("troop_app_list_data", Base64Util.encodeToString(paramArrayOfByte, 2)).commit();
  }
  
  public void a(ArrayList paramArrayList)
  {
    TraceUtils.a("queryTroops_" + paramArrayList.size());
    if (paramArrayList.size() > 0)
    {
      Object localObject = new StringBuilder("troopuin=? ");
      int i = 1;
      while (i < paramArrayList.size())
      {
        ((StringBuilder)localObject).append("or troopuin=? ");
        i += 1;
      }
      paramArrayList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopInfo.class, true, ((StringBuilder)localObject).toString(), (String[])paramArrayList.toArray(new String[paramArrayList.size()]), null, null, null, null);
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
    TraceUtils.a();
  }
  
  void a(ArrayList paramArrayList, long paramLong)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    c(paramArrayList);
    g();
  }
  
  public void a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopInfo localTroopInfo = a((String)paramList.next());
      if (localTroopInfo != null) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localTroopInfo);
      }
    }
  }
  
  public void a(Map paramMap)
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
      QLog.e(".troop.survey", 1, new Object[] { "[TroopManager]updateTroopSurveyList() IllegaleArgument! body is :", PBUtils.a(paramRspBody) });
      continue;
      if (QLog.isColorLevel()) {
        QLog.d(".troop.survey", 2, new Object[] { "[TroopManager]updateTroopSurveyList() body ready!", PBUtils.a(paramRspBody) });
      }
      this.jdField_a_of_type_JavaUtilMap.put(String.valueOf(paramRspBody.group_id.get()), paramRspBody);
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)) {}
    ArrayList localArrayList;
    do
    {
      return false;
      localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopInfo.class, false, null, null, null, null, null, String.valueOf("1"));
    } while ((localArrayList != null) && (localArrayList.size() > 0));
    return true;
  }
  
  public boolean a(Entity paramEntity)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {}
    do
    {
      do
      {
        return false;
        if (paramEntity.getStatus() != 1000) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
      } while (paramEntity.getStatus() != 1001);
      return true;
    } while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002));
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: invokestatic 499	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: aload_0
    //   12: getfield 107	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15: invokevirtual 113	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   18: invokevirtual 119	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   21: astore 5
    //   23: aload 5
    //   25: invokevirtual 508	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   28: astore 4
    //   30: aload 4
    //   32: astore_3
    //   33: aload_3
    //   34: invokevirtual 512	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   37: aload 5
    //   39: ldc_w 645
    //   42: iconst_0
    //   43: ldc_w 1226
    //   46: iconst_1
    //   47: anewarray 465	java/lang/String
    //   50: dup
    //   51: iconst_0
    //   52: aload_1
    //   53: aastore
    //   54: aconst_null
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: invokevirtual 224	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   61: astore 4
    //   63: aload 4
    //   65: ifnull +15 -> 80
    //   68: aload 4
    //   70: invokeinterface 730 1 0
    //   75: istore_2
    //   76: iload_2
    //   77: ifeq +13 -> 90
    //   80: aload_3
    //   81: ifnull +7 -> 88
    //   84: aload_3
    //   85: invokevirtual 534	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   88: iconst_0
    //   89: ireturn
    //   90: aload 4
    //   92: invokeinterface 544 1 0
    //   97: astore 4
    //   99: aload 4
    //   101: invokeinterface 374 1 0
    //   106: ifeq +56 -> 162
    //   109: aload 5
    //   111: aload 4
    //   113: invokeinterface 378 1 0
    //   118: checkcast 645	com/tencent/mobileqq/data/TroopMemberInfo
    //   121: invokevirtual 1241	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   124: pop
    //   125: goto -26 -> 99
    //   128: astore 4
    //   130: ldc_w 491
    //   133: iconst_2
    //   134: ldc_w 1272
    //   137: aload 4
    //   139: invokestatic 1275	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   142: aload_3
    //   143: ifnull +7 -> 150
    //   146: aload_3
    //   147: invokevirtual 534	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   150: aload 5
    //   152: invokevirtual 729	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   155: aload_0
    //   156: aload_1
    //   157: invokespecial 1277	com/tencent/mobileqq/app/TroopManager:k	(Ljava/lang/String;)V
    //   160: iconst_1
    //   161: ireturn
    //   162: aload_3
    //   163: invokevirtual 539	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   166: aload_3
    //   167: ifnull -17 -> 150
    //   170: aload_3
    //   171: invokevirtual 534	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   174: goto -24 -> 150
    //   177: astore_1
    //   178: aconst_null
    //   179: astore_3
    //   180: aload_3
    //   181: ifnull +7 -> 188
    //   184: aload_3
    //   185: invokevirtual 534	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
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
    if (localCommonlyUsedTroop == null)
    {
      localCommonlyUsedTroop = new CommonlyUsedTroop();
      localCommonlyUsedTroop.troopUin = paramString;
      localCommonlyUsedTroop.addedTimestamp = paramLong;
      localConcurrentHashMap.put(paramString, localCommonlyUsedTroop);
      a(localCommonlyUsedTroop);
      return true;
    }
    if (localCommonlyUsedTroop.addedTimestamp != paramLong)
    {
      localCommonlyUsedTroop.addedTimestamp = paramLong;
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
          b(paramString1, paramString2, localTroopMemberInfo);
          localEntityManager.b(localTroopMemberInfo);
        }
        for (;;)
        {
          localEntityManager.a();
          return true;
          if (paramByte != 2) {
            break;
          }
          localTroopMemberInfo.mIsShielded = true;
          break;
          localEntityManager.a(localTroopMemberInfo);
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
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (paramInt > 0)
      {
        j = i;
        if (paramInt != localTroopMemberInfo.mGlamourLevel)
        {
          localTroopMemberInfo.mGlamourLevel = paramInt;
          j = 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab..troop.memberCard", 2, "saveTroopMemberEx ," + localTroopMemberInfo.toString());
      }
      if (j != 0)
      {
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localTroopMemberInfo.getStatus() == 1000)
        {
          b(paramString1, paramString2, localTroopMemberInfo);
          localEntityManager.b(localTroopMemberInfo);
        }
        for (;;)
        {
          localEntityManager.a();
          b(paramString1, paramString2);
          return true;
          localEntityManager.a(localTroopMemberInfo);
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
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (paramInt1 >= 0)
      {
        i = j;
        if (paramInt1 != localTroopMemberInfo.hotChatGlamourLevel)
        {
          localTroopMemberInfo.hotChatGlamourLevel = paramInt1;
          i = 1;
        }
      }
      paramInt1 = i;
      if (paramInt2 >= 0)
      {
        paramInt1 = i;
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
          b(paramString1, paramString2, localTroopMemberInfo);
          localEntityManager.b(localTroopMemberInfo);
        }
        for (;;)
        {
          localEntityManager.a();
          b(paramString1, paramString2);
          return true;
          localEntityManager.a(localTroopMemberInfo);
        }
      }
      return false;
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, byte paramByte, long paramLong2, double paramDouble)
  {
    return a(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, paramByte, paramLong2, paramDouble, null, -100);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, byte paramByte, long paramLong2, double paramDouble, String paramString6, int paramInt5)
  {
    TroopMemberInfo localTroopMemberInfo = b(paramString1, paramString2);
    boolean bool2 = false;
    paramString5 = localTroopMemberInfo;
    if (localTroopMemberInfo == null)
    {
      paramString5 = new TroopMemberInfo();
      paramString5.troopuin = paramString1;
      paramString5.memberuin = paramString2;
      paramString5.isTroopFollowed = false;
      bool2 = true;
    }
    boolean bool1 = bool2;
    if (paramString3 != null)
    {
      bool1 = bool2;
      if (!paramString3.equals(paramString5.troopnick))
      {
        paramString5.troopnick = paramString3;
        bool1 = true;
      }
    }
    bool2 = bool1;
    if (paramString4 != null)
    {
      bool2 = bool1;
      if (!paramString4.equals(paramString5.friendnick))
      {
        paramString5.friendnick = paramString4;
        bool2 = true;
      }
    }
    if ((paramInt1 > 0) && (paramInt1 != paramString5.level))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRankConfig", 2, "saveTroopMemberEx: troopUin=" + paramString1 + ", memberUin=" + paramString2 + ", newTitleId=" + paramInt1 + ", oldTitleId=" + paramString5.level);
      }
      paramString5.level = paramInt1;
    }
    for (boolean bool3 = true;; bool3 = bool2)
    {
      bool1 = bool3;
      if (paramLong2 != -100L)
      {
        bool1 = bool3;
        if (paramLong2 != paramString5.gagTimeStamp)
        {
          paramString5.gagTimeStamp = paramLong2;
          bool1 = true;
        }
      }
      boolean bool4;
      if (paramByte == 1)
      {
        bool4 = true;
        bool3 = bool1;
        if (paramByte != -100)
        {
          bool3 = bool1;
          if (paramString5.isTroopFollowed != bool4)
          {
            paramString5.isTroopFollowed = bool4;
            bool3 = true;
          }
        }
        bool1 = bool3;
        if (paramDouble != -100.0D)
        {
          bool1 = bool3;
          if (paramDouble != paramString5.distanceToSelf)
          {
            paramString5.distanceToSelf = paramDouble;
            paramString5.distanceToSelfUpdateTimeStamp = System.currentTimeMillis();
            bool1 = true;
          }
        }
        bool3 = bool1;
        if (paramString6 != null)
        {
          bool3 = bool1;
          if (!paramString6.equals(paramString5.mUniqueTitle))
          {
            paramString5.mUniqueTitle = paramString6;
            bool3 = true;
          }
        }
        bool1 = bool3;
        if (paramInt5 != -100)
        {
          bool1 = bool3;
          if (paramInt5 != paramString5.realLevel)
          {
            paramString5.realLevel = paramInt5;
            bool1 = true;
          }
        }
        if ((paramLong1 == -100L) || (paramLong1 >= paramString5.msgseq)) {
          break label535;
        }
        bool3 = bool1;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab..troop.memberCard", 2, "saveTroopMemberEx ," + paramString5.toString());
        }
        if (!bool3) {
          break label661;
        }
        if (paramString5.getStatus() == 1000) {
          b(paramString1, paramString2, paramString5);
        }
        ThreadManager.post(new zvb(this, paramString5, new Handler(Looper.getMainLooper()), paramString1, paramString2, bool2), 8, null, false);
        return true;
        bool4 = false;
        break;
        label535:
        if (paramLong1 != -100L) {
          paramString5.msgseq = paramLong1;
        }
        bool3 = bool1;
        if (paramInt2 != -100)
        {
          bool3 = bool1;
          if (paramInt2 != paramString5.age)
          {
            paramString5.age = ((byte)paramInt2);
            bool3 = true;
          }
        }
        bool1 = bool3;
        if (paramInt3 != -100)
        {
          bool1 = bool3;
          if (paramInt3 != paramString5.sex)
          {
            paramString5.sex = ((byte)paramInt3);
            bool1 = true;
          }
        }
        bool3 = bool1;
        if (paramInt4 != -100)
        {
          bool3 = bool1;
          if (paramInt4 != paramString5.distance)
          {
            paramString5.distance = paramInt4;
            bool3 = true;
          }
        }
      }
      label661:
      return false;
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    return a(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, (byte)-100, paramLong2, -100.0D);
  }
  
  /* Error */
  public boolean a(List paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 730 1 0
    //   10: ifeq +7 -> 17
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ireturn
    //   17: new 1354	java/util/HashSet
    //   20: dup
    //   21: invokespecial 1355	java/util/HashSet:<init>	()V
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
    //   37: getfield 121	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   40: invokevirtual 508	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   43: astore 6
    //   45: aload 6
    //   47: astore 5
    //   49: iload 4
    //   51: istore_3
    //   52: aload 5
    //   54: invokevirtual 512	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   57: iload 4
    //   59: istore_3
    //   60: aload_1
    //   61: invokeinterface 544 1 0
    //   66: astore_1
    //   67: iload_2
    //   68: istore_3
    //   69: aload_1
    //   70: invokeinterface 374 1 0
    //   75: ifeq +155 -> 230
    //   78: iload_2
    //   79: istore_3
    //   80: aload_1
    //   81: invokeinterface 378 1 0
    //   86: checkcast 645	com/tencent/mobileqq/data/TroopMemberInfo
    //   89: astore 6
    //   91: iload_2
    //   92: istore_3
    //   93: new 139	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   100: aload 6
    //   102: getfield 776	com/tencent/mobileqq/data/TroopMemberInfo:troopuin	Ljava/lang/String;
    //   105: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc_w 653
    //   111: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload 6
    //   116: getfield 764	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   119: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore 8
    //   127: iload_2
    //   128: istore_3
    //   129: aload 6
    //   131: getfield 764	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   134: ldc_w 1357
    //   137: invokevirtual 550	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   140: ifne -73 -> 67
    //   143: iload_2
    //   144: istore_3
    //   145: aload 7
    //   147: aload 8
    //   149: invokevirtual 1360	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   152: ifne +199 -> 351
    //   155: iload_2
    //   156: istore_3
    //   157: aload_0
    //   158: aload 6
    //   160: getfield 776	com/tencent/mobileqq/data/TroopMemberInfo:troopuin	Ljava/lang/String;
    //   163: aload 6
    //   165: getfield 764	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   168: aload 6
    //   170: getfield 784	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   173: aload 6
    //   175: getfield 1187	com/tencent/mobileqq/data/TroopMemberInfo:level	I
    //   178: aload 6
    //   180: getfield 793	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   183: aconst_null
    //   184: aload 6
    //   186: getfield 1340	com/tencent/mobileqq/data/TroopMemberInfo:age	B
    //   189: aload 6
    //   191: getfield 1343	com/tencent/mobileqq/data/TroopMemberInfo:sex	B
    //   194: aload 6
    //   196: getfield 1346	com/tencent/mobileqq/data/TroopMemberInfo:distance	I
    //   199: aload 6
    //   201: getfield 1331	com/tencent/mobileqq/data/TroopMemberInfo:msgseq	J
    //   204: aload 6
    //   206: getfield 687	com/tencent/mobileqq/data/TroopMemberInfo:gagTimeStamp	J
    //   209: invokevirtual 1362	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIIJJ)Z
    //   212: istore 4
    //   214: iload 4
    //   216: iload_2
    //   217: ior
    //   218: istore_2
    //   219: aload 7
    //   221: aload 8
    //   223: invokevirtual 1363	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   226: pop
    //   227: goto -160 -> 67
    //   230: iload_2
    //   231: istore_3
    //   232: aload 5
    //   234: invokevirtual 539	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   237: iload_2
    //   238: istore_3
    //   239: aload 5
    //   241: ifnull -226 -> 15
    //   244: aload 5
    //   246: invokevirtual 534	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   249: iload_2
    //   250: ireturn
    //   251: astore 6
    //   253: iload_3
    //   254: istore_2
    //   255: aload 5
    //   257: astore_1
    //   258: aload 6
    //   260: astore 5
    //   262: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   265: ifeq +15 -> 280
    //   268: ldc_w 453
    //   271: iconst_2
    //   272: aload 5
    //   274: invokestatic 1367	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   277: invokestatic 736	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: iload_2
    //   281: istore_3
    //   282: aload_1
    //   283: ifnull -268 -> 15
    //   286: aload_1
    //   287: invokevirtual 534	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   290: iload_2
    //   291: ireturn
    //   292: astore_1
    //   293: aconst_null
    //   294: astore 5
    //   296: aload 5
    //   298: ifnull +8 -> 306
    //   301: aload 5
    //   303: invokevirtual 534	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
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
    //   0	354	1	paramList	List
    //   32	302	2	bool1	boolean
    //   14	319	3	bool2	boolean
    //   29	189	4	bool3	boolean
    //   34	310	5	localObject1	Object
    //   43	162	6	localObject2	Object
    //   251	8	6	localThrowable1	java.lang.Throwable
    //   312	6	6	localObject3	Object
    //   323	6	6	localThrowable2	java.lang.Throwable
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
      paramString = Base64Util.decode(paramString, 0);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public int b()
  {
    try
    {
      int i = this.jdField_b_of_type_JavaUtilHashMap.size();
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab..troopgroup_vedio.invite", 2, "hasGroupInviting  : " + i);
      }
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long b(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    return localSharedPreferences.getLong("line_" + str + "_" + paramString, -1L);
  }
  
  public TroopInfo b(String paramString)
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
        QLog.d("Q.contacttab.", 2, StringUtil.a(new Object[] { "getTroopInfo()", paramString, Long.valueOf(((TroopInfo)localObject2).dwGroupFlagExt) }));
      }
      return localObject2;
      localObject2 = a(paramString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TroopInfo();
        ((TroopInfo)localObject1).troopname = TroopSystemMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramString);
        ((TroopInfo)localObject1).dwGroupFlagExt = TroopSystemMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramString);
      }
      localObject2 = localObject1;
      if (!h(((TroopInfo)localObject1).troopname))
      {
        ((TroopInfo)localObject1).troopname = paramString;
        localObject2 = localObject1;
      }
    }
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
    return ContactUtils.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
  }
  
  /* Error */
  public ArrayList b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 82	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 83	java/util/ArrayList:<init>	()V
    //   10: astore 6
    //   12: aload_0
    //   13: getfield 121	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   16: invokevirtual 508	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   19: astore 5
    //   21: aload 5
    //   23: astore 4
    //   25: aload 4
    //   27: ifnull +139 -> 166
    //   30: aload 4
    //   32: invokevirtual 512	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   35: invokestatic 856	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   38: lstore_2
    //   39: aload_0
    //   40: getfield 121	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   43: ldc_w 645
    //   46: iconst_0
    //   47: ldc_w 1226
    //   50: iconst_1
    //   51: anewarray 465	java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: aload_1
    //   57: aastore
    //   58: aconst_null
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokevirtual 224	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   65: astore_1
    //   66: aload_1
    //   67: ifnull +99 -> 166
    //   70: aload_1
    //   71: invokeinterface 544 1 0
    //   76: astore_1
    //   77: aload_1
    //   78: invokeinterface 374 1 0
    //   83: ifeq +83 -> 166
    //   86: aload_1
    //   87: invokeinterface 378 1 0
    //   92: checkcast 645	com/tencent/mobileqq/data/TroopMemberInfo
    //   95: astore 5
    //   97: aload 5
    //   99: invokestatic 1426	com/tencent/mobileqq/activity/ChatActivityUtils:a	(Lcom/tencent/mobileqq/data/TroopMemberInfo;)Z
    //   102: ifeq -25 -> 77
    //   105: aload 5
    //   107: getfield 687	com/tencent/mobileqq/data/TroopMemberInfo:gagTimeStamp	J
    //   110: lconst_0
    //   111: lcmp
    //   112: ifeq -35 -> 77
    //   115: aload 5
    //   117: getfield 687	com/tencent/mobileqq/data/TroopMemberInfo:gagTimeStamp	J
    //   120: lload_2
    //   121: lcmp
    //   122: ifle -45 -> 77
    //   125: aload 6
    //   127: new 689	com/tencent/mobileqq/app/TroopManager$MemberGagInfo
    //   130: dup
    //   131: aload_0
    //   132: aload 5
    //   134: getfield 764	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   137: aload 5
    //   139: getfield 687	com/tencent/mobileqq/data/TroopMemberInfo:gagTimeStamp	J
    //   142: invokespecial 692	com/tencent/mobileqq/app/TroopManager$MemberGagInfo:<init>	(Lcom/tencent/mobileqq/app/TroopManager;Ljava/lang/String;J)V
    //   145: invokevirtual 595	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   148: pop
    //   149: goto -72 -> 77
    //   152: astore_1
    //   153: aload 4
    //   155: ifnull +8 -> 163
    //   158: aload 4
    //   160: invokevirtual 534	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   163: aload 6
    //   165: areturn
    //   166: aload 4
    //   168: ifnull -5 -> 163
    //   171: aload 4
    //   173: invokevirtual 534	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   176: aload 6
    //   178: areturn
    //   179: astore_1
    //   180: aconst_null
    //   181: astore 4
    //   183: aload 4
    //   185: ifnull +8 -> 193
    //   188: aload 4
    //   190: invokevirtual 534	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
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
    //   38	83	2	l	long
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
  
  public List b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = b().values().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((ShowExternalTroop)localIterator.next());
    }
    return localArrayList;
  }
  
  public List b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopMemberInfo.class, false, "troopuin=?", new String[] { paramString }, null, null, null, null);
  }
  
  public void b()
  {
    f();
    g();
  }
  
  public void b(TroopManager.TroopMemberUpdateObserver paramTroopMemberUpdateObserver)
  {
    try
    {
      this.jdField_d_of_type_JavaUtilArrayList.remove(paramTroopMemberUpdateObserver);
      return;
    }
    finally
    {
      paramTroopMemberUpdateObserver = finally;
      throw paramTroopMemberUpdateObserver;
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
    ContactSorter.a(paramTroopInfo);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramTroopInfo.troopuin, paramTroopInfo);
    }
    if ((!a(paramTroopInfo)) && (QLog.isColorLevel())) {
      QLog.d("Q.contacttab.troop", 2, "saveTroopInfo failed.");
    }
    ProxyManager localProxyManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    RecentUser localRecentUser = localProxyManager.a().a(paramTroopInfo.troopuin, 1);
    localRecentUser.displayName = paramTroopInfo.getTroopName();
    if (localRecentUser.getStatus() == 1001) {
      localProxyManager.a().a(localRecentUser);
    }
    g();
  }
  
  public void b(String paramString)
  {
    TroopInfo localTroopInfo = a(paramString);
    if (localTroopInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localTroopInfo);
    a(paramString);
    a(paramString);
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
    int i = 0;
    while (i < this.jdField_d_of_type_JavaUtilArrayList.size())
    {
      ((TroopManager.TroopMemberUpdateObserver)this.jdField_d_of_type_JavaUtilArrayList.get(i)).a(paramString1, paramString2);
      i += 1;
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    ThreadManager.post(new zvk(this, paramString1, paramString2, paramString3), 8, null, true);
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
        b(paramString1, paramString2, localTroopMemberInfo1);
      }
      a(paramString1, paramString2, localTroopMemberInfo1);
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    ThreadManager.post(new zuy(this, paramString1, paramString2, paramString3, paramInt, paramString4, paramString5), 8, null, false);
  }
  
  public void b(ArrayList paramArrayList)
  {
    int i = 0;
    while (i < this.jdField_d_of_type_JavaUtilArrayList.size())
    {
      ((TroopManager.TroopMemberUpdateObserver)this.jdField_d_of_type_JavaUtilArrayList.get(i)).a(paramArrayList);
      i += 1;
    }
  }
  
  public void b(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    Object localObject = null;
    try
    {
      EntityTransaction localEntityTransaction = a();
      localObject = localEntityTransaction;
      localEntityTransaction.a();
      localObject = localEntityTransaction;
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        localObject = localEntityTransaction;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = localEntityTransaction;
        TroopInfo localTroopInfo = (TroopInfo)localIterator.next();
        if (localTroopInfo != null)
        {
          localObject = localEntityTransaction;
          if (!TextUtils.isEmpty(localTroopInfo.troopuin))
          {
            localObject = localEntityTransaction;
            if (!"0".equals(localTroopInfo.troopuin))
            {
              localObject = localEntityTransaction;
              if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
              {
                localObject = localEntityTransaction;
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
              }
              localObject = localEntityTransaction;
              if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
              {
                localObject = localEntityTransaction;
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localTroopInfo.troopuin, localTroopInfo);
              }
              localObject = localEntityTransaction;
              if (!a(localTroopInfo))
              {
                localObject = localEntityTransaction;
                if (QLog.isColorLevel())
                {
                  localObject = localEntityTransaction;
                  QLog.d("Q.contacttab.troop", 2, "saveTroopInfo failed.");
                }
              }
            }
          }
        }
      }
      c(paramList);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.troop", 2, QLog.getStackTraceString(localException));
      }
      if (localObject != null) {
        localObject.b();
      }
    }
    for (;;)
    {
      g();
      return;
      localObject = localException;
      localException.c();
      localObject = localException;
      localException.b();
    }
  }
  
  public void b(Map paramMap)
  {
    this.jdField_d_of_type_JavaUtilMap = paramMap;
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
      localShowExternalTroop = ShowExternalTroop.createShowExternalTroop(paramString, ContactUtils.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString), paramLong);
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
  
  public TroopInfo c(String paramString)
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
  
  public TroopMemberInfo c(String paramString1, String paramString2)
  {
    long l;
    if (StatisticCollector.a(12))
    {
      l = SystemClock.uptimeMillis();
      DetectContactDelete.a();
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      List localList = ((EntityManager)localObject).a(TroopMemberInfo.class, false, "troopuin=? AND memberuin=?", new String[] { paramString1, paramString2 }, null, null, null, null);
      ((EntityManager)localObject).a();
      HashMap localHashMap;
      if (l != 0L)
      {
        l = SystemClock.uptimeMillis() - l;
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
        localHashMap.put("param_OptTotalCost", String.valueOf(l));
        localHashMap.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.jdField_a_of_type_Boolean));
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(null, "actFriendSqliteOpt", true, l, 0L, localHashMap, null, false);
        if ((localList == null) || (localList.size() <= 0)) {
          break;
        }
        localObject = (TroopMemberInfo)localList.get(0);
        b(paramString1, paramString2, (TroopMemberInfo)localObject);
        return localObject;
      }
      return null;
      l = 0L;
    }
  }
  
  public String c(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      TroopInfo localTroopInfo = (TroopInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopInfo.class, "troopcode=?", new String[] { paramString });
      if (localTroopInfo == null) {
        return null;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(localTroopInfo.troopcode, localTroopInfo.troopuin);
    }
    return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
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
      paramString1 = a(paramString1);
      localObject = str;
      if (paramString1 == null) {
        break;
      }
      localObject = str;
      if (!paramString1.isQidianPrivateTroop()) {
        break;
      }
      return "群成员";
      label117:
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject).friendnick)) {
        str = ((TroopMemberInfo)localObject).friendnick;
      } else {
        str = paramString2;
      }
    }
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokespecial 818	com/tencent/mobileqq/app/TroopManager:a	()Ljava/util/concurrent/ConcurrentHashMap;
    //   6: astore_3
    //   7: aload_0
    //   8: getfield 121	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   11: invokevirtual 508	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: astore_2
    //   15: aload_2
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +257 -> 275
    //   21: aload_1
    //   22: invokevirtual 512	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   25: aload_0
    //   26: getfield 1243	com/tencent/mobileqq/app/TroopManager:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   29: ifnonnull +14 -> 43
    //   32: aload_0
    //   33: new 51	java/util/HashMap
    //   36: dup
    //   37: invokespecial 52	java/util/HashMap:<init>	()V
    //   40: putfield 1243	com/tencent/mobileqq/app/TroopManager:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   43: aload_3
    //   44: invokevirtual 1534	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   47: invokeinterface 1414 1 0
    //   52: astore_2
    //   53: aload_2
    //   54: invokeinterface 374 1 0
    //   59: ifeq +84 -> 143
    //   62: aload_2
    //   63: invokeinterface 378 1 0
    //   68: checkcast 465	java/lang/String
    //   71: astore 4
    //   73: aload_0
    //   74: getfield 107	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   77: invokevirtual 1048	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   80: invokevirtual 1538	mqq/app/MobileQQ:getBaseContext	()Landroid/content/Context;
    //   83: aload_0
    //   84: getfield 107	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   87: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   90: invokestatic 1543	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/List;
    //   93: aload 4
    //   95: invokeinterface 1544 2 0
    //   100: ifeq -47 -> 53
    //   103: aload_0
    //   104: getfield 1243	com/tencent/mobileqq/app/TroopManager:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   107: aload 4
    //   109: aload_3
    //   110: aload 4
    //   112: invokevirtual 524	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   115: checkcast 219	com/tencent/mobileqq/data/CommonlyUsedTroop
    //   118: getfield 1284	com/tencent/mobileqq/data/CommonlyUsedTroop:addedTimestamp	J
    //   121: invokestatic 463	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   124: invokeinterface 831 3 0
    //   129: pop
    //   130: goto -77 -> 53
    //   133: astore_2
    //   134: aload_1
    //   135: ifnull +7 -> 142
    //   138: aload_1
    //   139: invokevirtual 534	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   142: return
    //   143: aload_0
    //   144: getfield 121	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   147: ldc 219
    //   149: invokevirtual 1547	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Z
    //   152: pop
    //   153: aload_3
    //   154: invokevirtual 1548	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   157: aload_0
    //   158: getfield 1243	com/tencent/mobileqq/app/TroopManager:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   161: ifnull +110 -> 271
    //   164: aload_0
    //   165: getfield 1243	com/tencent/mobileqq/app/TroopManager:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   168: invokeinterface 1549 1 0
    //   173: invokeinterface 1414 1 0
    //   178: astore_2
    //   179: aload_2
    //   180: invokeinterface 374 1 0
    //   185: ifeq +86 -> 271
    //   188: aload_2
    //   189: invokeinterface 378 1 0
    //   194: checkcast 465	java/lang/String
    //   197: astore 4
    //   199: new 219	com/tencent/mobileqq/data/CommonlyUsedTroop
    //   202: dup
    //   203: invokespecial 1281	com/tencent/mobileqq/data/CommonlyUsedTroop:<init>	()V
    //   206: astore 5
    //   208: aload 5
    //   210: aload 4
    //   212: putfield 248	com/tencent/mobileqq/data/CommonlyUsedTroop:troopUin	Ljava/lang/String;
    //   215: aload 5
    //   217: aload_0
    //   218: getfield 1243	com/tencent/mobileqq/app/TroopManager:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   221: aload 4
    //   223: invokeinterface 681 2 0
    //   228: checkcast 293	java/lang/Long
    //   231: invokevirtual 427	java/lang/Long:longValue	()J
    //   234: putfield 1284	com/tencent/mobileqq/data/CommonlyUsedTroop:addedTimestamp	J
    //   237: aload_3
    //   238: aload 4
    //   240: aload 5
    //   242: invokevirtual 255	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   245: pop
    //   246: aload_0
    //   247: aload 5
    //   249: invokevirtual 529	com/tencent/mobileqq/app/TroopManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   252: pop
    //   253: goto -74 -> 179
    //   256: astore_3
    //   257: aload_1
    //   258: astore_2
    //   259: aload_3
    //   260: astore_1
    //   261: aload_2
    //   262: ifnull +7 -> 269
    //   265: aload_2
    //   266: invokevirtual 534	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   269: aload_1
    //   270: athrow
    //   271: aload_1
    //   272: invokevirtual 539	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   275: aload_1
    //   276: ifnull -134 -> 142
    //   279: aload_1
    //   280: invokevirtual 534	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   283: return
    //   284: astore_1
    //   285: aconst_null
    //   286: astore_2
    //   287: goto -26 -> 261
    //   290: astore_2
    //   291: goto -157 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	TroopManager
    //   1	279	1	localObject1	Object
    //   284	1	1	localObject2	Object
    //   14	49	2	localObject3	Object
    //   133	1	2	localThrowable1	java.lang.Throwable
    //   178	109	2	localObject4	Object
    //   290	1	2	localThrowable2	java.lang.Throwable
    //   6	232	3	localConcurrentHashMap	ConcurrentHashMap
    //   256	4	3	localObject5	Object
    //   71	168	4	str	String
    //   206	42	5	localCommonlyUsedTroop	CommonlyUsedTroop
    // Exception table:
    //   from	to	target	type
    //   21	43	133	java/lang/Throwable
    //   43	53	133	java/lang/Throwable
    //   53	130	133	java/lang/Throwable
    //   143	179	133	java/lang/Throwable
    //   179	253	133	java/lang/Throwable
    //   271	275	133	java/lang/Throwable
    //   21	43	256	finally
    //   43	53	256	finally
    //   53	130	256	finally
    //   143	179	256	finally
    //   179	253	256	finally
    //   271	275	256	finally
    //   7	15	284	finally
    //   7	15	290	java/lang/Throwable
  }
  
  void c(TroopInfo paramTroopInfo)
  {
    b(paramTroopInfo);
    g();
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = (LruCache)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
    } while (paramString == null);
    paramString.evictAll();
  }
  
  public void c(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString1 + paramString2, paramString2);
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
  
  public boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "removeCommonlyUsedTroop, troopUin is null");
      }
      return false;
    }
    paramString = (CommonlyUsedTroop)a().remove(paramString);
    if (paramString != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramString);
      return true;
    }
    return false;
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if ((localEntityManager == null) || (localTroopManager == null)) {
      return false;
    }
    TroopInfo localTroopInfo = localTroopManager.a(paramString1);
    if (localTroopInfo == null) {
      return false;
    }
    TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)localEntityManager.a(TroopMemberInfo.class, "troopuin=? and memberuin=?", new String[] { paramString1, paramString2 });
    if (localTroopMemberInfo != null)
    {
      localEntityManager.b(localTroopMemberInfo);
      if (localTroopInfo.wMemberNum > 0) {
        localTroopInfo.wMemberNum -= 1;
      }
      if ((localTroopInfo.Administrator != null) && (localTroopInfo.Administrator.contains(paramString2))) {
        localTroopInfo.Administrator.replace(paramString2, "");
      }
    }
    localTroopManager.b(localTroopInfo);
    localEntityManager.a();
    e(paramString1, paramString2);
    a(paramString1, paramString2);
    ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).d(paramString1, paramString2);
    return true;
  }
  
  public String d(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3;
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsValue(paramString))
    {
      localObject3 = (TroopInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopInfo.class, "troopuin=?", new String[] { paramString });
      if (localObject3 != null) {}
    }
    do
    {
      do
      {
        return localObject2;
        this.jdField_a_of_type_JavaUtilHashMap.put(((TroopInfo)localObject3).troopcode, ((TroopInfo)localObject3).troopuin);
        localObject3 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        localObject2 = localObject1;
      } while (localObject3 == null);
      localObject2 = localObject1;
    } while (!((Iterator)localObject3).hasNext());
    localObject2 = (String)((Iterator)localObject3).next();
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
    if ((str != null) && (str.equals(paramString))) {
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
    //   1: astore_1
    //   2: aload_0
    //   3: invokespecial 1428	com/tencent/mobileqq/app/TroopManager:b	()Ljava/util/concurrent/ConcurrentHashMap;
    //   6: astore_3
    //   7: aload_0
    //   8: getfield 121	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   11: invokevirtual 508	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: astore_2
    //   15: aload_2
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +130 -> 148
    //   21: aload_1
    //   22: invokevirtual 512	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   25: aload_0
    //   26: getfield 121	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   29: ldc_w 488
    //   32: invokevirtual 1547	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Z
    //   35: pop
    //   36: aload_3
    //   37: invokevirtual 1548	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   40: aload_0
    //   41: getfield 1461	com/tencent/mobileqq/app/TroopManager:jdField_d_of_type_JavaUtilMap	Ljava/util/Map;
    //   44: ifnull +100 -> 144
    //   47: aload_0
    //   48: getfield 1461	com/tencent/mobileqq/app/TroopManager:jdField_d_of_type_JavaUtilMap	Ljava/util/Map;
    //   51: invokeinterface 1549 1 0
    //   56: invokeinterface 1414 1 0
    //   61: astore_2
    //   62: aload_2
    //   63: invokeinterface 374 1 0
    //   68: ifeq +76 -> 144
    //   71: aload_2
    //   72: invokeinterface 378 1 0
    //   77: checkcast 465	java/lang/String
    //   80: astore 4
    //   82: aload 4
    //   84: aload_0
    //   85: getfield 107	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   88: aload 4
    //   90: invokestatic 1465	com/tencent/mobileqq/utils/ContactUtils:i	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   93: aload_0
    //   94: getfield 1461	com/tencent/mobileqq/app/TroopManager:jdField_d_of_type_JavaUtilMap	Ljava/util/Map;
    //   97: aload 4
    //   99: invokeinterface 681 2 0
    //   104: checkcast 293	java/lang/Long
    //   107: invokevirtual 427	java/lang/Long:longValue	()J
    //   110: invokestatic 1469	com/tencent/mobileqq/data/ShowExternalTroop:createShowExternalTroop	(Ljava/lang/String;Ljava/lang/String;J)Lcom/tencent/mobileqq/data/ShowExternalTroop;
    //   113: astore 5
    //   115: aload_3
    //   116: aload 4
    //   118: aload 5
    //   120: invokevirtual 255	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   123: pop
    //   124: aload_0
    //   125: aload 5
    //   127: invokevirtual 529	com/tencent/mobileqq/app/TroopManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   130: pop
    //   131: goto -69 -> 62
    //   134: astore_2
    //   135: aload_1
    //   136: ifnull +7 -> 143
    //   139: aload_1
    //   140: invokevirtual 534	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   143: return
    //   144: aload_1
    //   145: invokevirtual 539	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   148: aload_1
    //   149: ifnull -6 -> 143
    //   152: aload_1
    //   153: invokevirtual 534	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   156: return
    //   157: astore_1
    //   158: aconst_null
    //   159: astore_3
    //   160: aload_1
    //   161: astore_2
    //   162: aload_3
    //   163: ifnull +7 -> 170
    //   166: aload_3
    //   167: invokevirtual 534	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   170: aload_2
    //   171: athrow
    //   172: astore_2
    //   173: aload_1
    //   174: astore_3
    //   175: goto -13 -> 162
    //   178: astore_2
    //   179: goto -44 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	TroopManager
    //   1	152	1	localObject1	Object
    //   157	17	1	localObject2	Object
    //   14	58	2	localObject3	Object
    //   134	1	2	localThrowable1	java.lang.Throwable
    //   161	10	2	localObject4	Object
    //   172	1	2	localObject5	Object
    //   178	1	2	localThrowable2	java.lang.Throwable
    //   6	169	3	localObject6	Object
    //   80	37	4	str	String
    //   113	13	5	localShowExternalTroop	ShowExternalTroop
    // Exception table:
    //   from	to	target	type
    //   21	62	134	java/lang/Throwable
    //   62	131	134	java/lang/Throwable
    //   144	148	134	java/lang/Throwable
    //   7	15	157	finally
    //   21	62	172	finally
    //   62	131	172	finally
    //   144	148	172	finally
    //   7	15	178	java/lang/Throwable
  }
  
  public void d(TroopInfo paramTroopInfo)
  {
    a(paramTroopInfo, NetConnInfoCenter.getServerTime());
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b("update TroopNotificationCache set read=1 where troopUin=" + paramString);
  }
  
  public void d(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_b_of_type_JavaUtilHashMap.remove(paramString1 + paramString2);
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
  
  public boolean d(String paramString)
  {
    return b().get(paramString) != null;
  }
  
  public boolean d(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString1 + paramString2);
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
  
  public void e()
  {
    if (this.jdField_c_of_type_JavaUtilArrayList != null) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.contacttab.troop", 2, "getTroopsMemberList(memberLimit), last getTroopsMemberList(int memberLimit) is not finished.");
      }
    }
    Object localObject2;
    do
    {
      return;
      localObject2 = a();
      if (localObject2 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.contacttab.troop", 2, "getTroopsMemberList(memberLimit), troopList is null");
    return;
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    int k;
    int i;
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      k = 0;
      i = 0;
    }
    int n;
    for (int j = 0;; j = n)
    {
      int m;
      if (k < ((ArrayList)localObject2).size())
      {
        TroopInfo localTroopInfo = (TroopInfo)((ArrayList)localObject2).get(k);
        m = i;
        n = j;
        if (a(localTroopInfo, false)) {
          try
          {
            this.jdField_c_of_type_JavaUtilArrayList.add(localTroopInfo);
            n = j + 1;
            m = i + localTroopInfo.wMemberNum;
          }
          finally {}
        }
      }
      else
      {
        if (this.jdField_c_of_type_JavaUtilArrayList.size() > 0)
        {
          localObject2 = (TroopInfo)this.jdField_c_of_type_JavaUtilArrayList.get(0);
          localObject1.a(true, ((TroopInfo)localObject2).troopuin, ((TroopInfo)localObject2).troopcode, 4);
        }
        while (j > 0)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("reqUin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          localHashMap.put("tpNum", String.valueOf(j));
          localHashMap.put("tpMemNum", String.valueOf(i));
          localHashMap.put("isFirst", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("is_first_upgrade_to_500", 0)));
          StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "tMSearchUpdateReq", false, 0L, 0L, localHashMap, "");
          return;
          this.jdField_c_of_type_JavaUtilArrayList = null;
          continue;
          this.jdField_c_of_type_JavaUtilArrayList = null;
          i = 0;
          j = 0;
        }
        break;
      }
      k += 1;
      i = m;
    }
  }
  
  public void e(String paramString)
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
  
  public boolean e(String paramString)
  {
    paramString = (ShowExternalTroop)b().remove(paramString);
    if (paramString != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramString);
      return true;
    }
    return false;
  }
  
  public void f(String paramString)
  {
    int i = 0;
    while (i < this.jdField_d_of_type_JavaUtilArrayList.size())
    {
      ((TroopManager.TroopMemberUpdateObserver)this.jdField_d_of_type_JavaUtilArrayList.get(i)).b(paramString);
      i += 1;
    }
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
  
  public void g(String paramString)
  {
    int i = 0;
    while (i < this.jdField_d_of_type_JavaUtilArrayList.size())
    {
      ((TroopManager.TroopMemberUpdateObserver)this.jdField_d_of_type_JavaUtilArrayList.get(i)).a(paramString);
      i += 1;
    }
  }
  
  /* Error */
  public boolean g(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 499	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +22 -> 28
    //   9: aload_0
    //   10: getfield 103	com/tencent/mobileqq/app/TroopManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   13: aload_1
    //   14: invokevirtual 1623	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
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
  
  public void h(String paramString)
  {
    this.e.clear();
    int i;
    Object localObject1;
    Object localObject2;
    TroopManager.DownloadFileConfig localDownloadFileConfig;
    label178:
    int j;
    if (!TextUtils.isEmpty(paramString))
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.length() == 0) {
          return;
        }
        JSONArray localJSONArray = paramString.names();
        i = 0;
        if (i >= localJSONArray.length()) {
          break label237;
        }
        localObject1 = localJSONArray.getString(i).trim().toLowerCase();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label238;
        }
        localObject2 = paramString.optJSONObject((String)localObject1);
        localDownloadFileConfig = new TroopManager.DownloadFileConfig();
        localDownloadFileConfig.c = ((JSONObject)localObject2).getInt("CellNetAutoDownloadSize");
        localDownloadFileConfig.jdField_b_of_type_Int = ((JSONObject)localObject2).getInt("CellNetWarningSize");
        localDownloadFileConfig.jdField_a_of_type_Int = ((JSONObject)localObject2).getInt("WiFiNetAutoDownloadSize");
        if (((String)localObject1).contains(",")) {
          break label178;
        }
        this.e.put(localObject1, localDownloadFileConfig);
      }
      catch (JSONException paramString)
      {
        if (!QLog.isColorLevel()) {
          break label237;
        }
      }
      QLog.d("Q.contacttab.", 2, QLog.getStackTraceString(paramString));
      return;
      localObject1 = ((String)localObject1).split(",");
      j = 0;
    }
    for (;;)
    {
      if (j < localObject1.length)
      {
        localObject2 = localObject1[j].trim().toLowerCase();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.e.put(localObject2, localDownloadFileConfig);
        }
      }
      else
      {
        label237:
        label238:
        i += 1;
        break;
      }
      j += 1;
    }
  }
  
  /* Error */
  public void i(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 499	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +19 -> 25
    //   9: aload_0
    //   10: getfield 103	com/tencent/mobileqq/app/TroopManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   13: aload_1
    //   14: invokevirtual 1623	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   17: istore_2
    //   18: iload_2
    //   19: ifeq +6 -> 25
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 103	com/tencent/mobileqq/app/TroopManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   29: aload_1
    //   30: invokevirtual 595	java/util/ArrayList:add	(Ljava/lang/Object;)Z
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
  
  /* Error */
  public void j(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 499	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 103	com/tencent/mobileqq/app/TroopManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   18: aload_1
    //   19: invokevirtual 1434	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
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
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    this.jdField_a_of_type_JavaUtilMap.clear();
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager
 * JD-Core Version:    0.7.0.1
 */