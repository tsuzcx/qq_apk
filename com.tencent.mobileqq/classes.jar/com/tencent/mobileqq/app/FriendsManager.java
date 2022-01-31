package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.DateNickNameInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.KplCard;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.javahook.DetectContactDelete;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import friendlist.GetOnlineInfoResp;
import friendlist.SimpleOnlineFriendInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.RecommendReason;
import zld;
import zlf;
import zlg;
import zlh;

public class FriendsManager
  implements Manager
{
  public int a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private MQLruCache jdField_a_of_type_AndroidSupportV4UtilMQLruCache;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(6);
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new zld(this);
  public volatile boolean a;
  public int b;
  private MQLruCache jdField_b_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(500);
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  public boolean b;
  public int c;
  private final MQLruCache jdField_c_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(20);
  private ConcurrentHashMap jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(16);
  private boolean jdField_c_of_type_Boolean;
  public int d;
  private ConcurrentHashMap jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new QQConcurrentHashMap(1011, 0, 400);
  private volatile boolean jdField_d_of_type_Boolean;
  public int e;
  private ConcurrentHashMap jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new QQConcurrentHashMap(1012, 0, 400);
  private boolean jdField_e_of_type_Boolean;
  public int f;
  private ConcurrentHashMap jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_f_of_type_Boolean;
  public int g;
  private ConcurrentHashMap jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
  private boolean jdField_g_of_type_Boolean;
  public int h;
  private ConcurrentHashMap h;
  public int i;
  private ConcurrentHashMap i;
  public int j = 30;
  public int k = 5;
  public int l = -1;
  int m = 0;
  private int n;
  
  public FriendsManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Int = 3;
    this.jdField_b_of_type_Int = 30;
    this.jdField_c_of_type_Int = 7;
    this.jdField_d_of_type_Int = 30;
    this.jdField_e_of_type_Int = 3;
    this.jdField_f_of_type_Int = 30;
    this.jdField_g_of_type_Int = 3;
    this.jdField_h_of_type_Int = 30;
    this.jdField_i_of_type_Int = 3;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  private SharedPreferences a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "add_friend_request_sp", 0);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  private ConcurrentHashMap a(boolean paramBoolean)
  {
    label545:
    label548:
    label551:
    label554:
    for (;;)
    {
      ConcurrentHashMap localConcurrentHashMap;
      Object localObject4;
      int i1;
      Object localObject3;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.", 2, "buildNormalAndGatheredUiMaps begin :");
        }
        localConcurrentHashMap = new ConcurrentHashMap(6);
        localObject4 = new ConcurrentHashMap(4);
        Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        i1 = 0;
        if (localIterator.hasNext())
        {
          Friends localFriends = (Friends)((Map.Entry)localIterator.next()).getValue();
          if (localFriends.gathtertype != 1) {
            break label551;
          }
          i1 += 1;
          if (paramBoolean)
          {
            if (localFriends.gathtertype != 1) {}
          }
          else
          {
            if (localFriends.gathtertype == 0) {
              break label548;
            }
            if (localFriends.gathtertype == 2) {
              continue;
            }
          }
          if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0)) {
            ContactSorter.a(localFriends);
          }
          String str = localFriends.groupid + "";
          localObject3 = (ArrayList)localConcurrentHashMap.get(str);
          Object localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject1 = new ArrayList();
            localConcurrentHashMap.put(str, localObject1);
            if (this.jdField_a_of_type_JavaUtilArrayList == null) {
              break label545;
            }
            localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label545;
            }
            Groups localGroups = (Groups)((Iterator)localObject3).next();
            if (localGroups.group_id != localFriends.groupid) {
              continue;
            }
            ((ArrayList)localObject1).ensureCapacity(localGroups.group_friend_count);
          }
          ((ArrayList)localObject1).add(localFriends);
          if (!paramBoolean) {
            break label554;
          }
          int i2 = ContactUtils.a(localFriends);
          if ((i2 == 0) || (i2 == 6)) {
            break label554;
          }
          localObject1 = (Integer)((ConcurrentHashMap)localObject4).get(str);
          if (localObject1 == null) {
            ((ConcurrentHashMap)localObject4).put(str, Integer.valueOf(1));
          } else {
            ((ConcurrentHashMap)localObject4).put(str, Integer.valueOf(((Integer)localObject1).intValue() + 1));
          }
        }
      }
      finally {}
      if (paramBoolean) {
        this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap = ((ConcurrentHashMap)localObject4);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(300);
        localStringBuilder.append("buildNormalAndGatheredUiMaps end " + localConcurrentHashMap.size() + ": ");
        localObject3 = localConcurrentHashMap.keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localStringBuilder.append((String)localObject4).append(", ").append(((ArrayList)localConcurrentHashMap.get(localObject4)).size()).append("; ");
        }
        localStringBuilder.append(" gatherCount=").append(i1);
        QLog.d("Q.contacttab.friend", 2, localStringBuilder.toString());
      }
      this.n = i1;
      return localConcurrentHashMap;
      continue;
      continue;
    }
  }
  
  private void a(long paramLong, boolean paramBoolean, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap(10);
    String str;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      str = "1";
      localHashMap.put("param_IsMainThread", str);
      localHashMap.put("param_OptType", paramString1);
      localHashMap.put("param_bustag", paramString2);
      if (!paramBoolean) {
        break label135;
      }
    }
    label135:
    for (paramString1 = "1";; paramString1 = "0")
    {
      localHashMap.put("param_intrans", paramString1);
      localHashMap.put("param_OptTotalCost", String.valueOf(paramLong));
      localHashMap.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.a));
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(null, "actFriendSqliteOpt", true, paramLong, 0L, localHashMap, null, false);
      return;
      str = "0";
      break;
    }
  }
  
  private void a(Friends[] paramArrayOfFriends)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayOfFriends.length)
    {
      localArrayList.add(paramArrayOfFriends[i1].uin);
      i1 += 1;
    }
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), localArrayList);
  }
  
  private boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "isValidUin empty uin");
      }
    }
    for (;;)
    {
      return false;
      if (paramString.length() >= 4) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "isValidUin uin=" + paramString);
      }
    }
    return true;
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "init begin");
    }
    h();
    a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "init end");
    }
  }
  
  private void g()
  {
    ??? = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(NoC2CExtensionInfo.class);
    if (??? != null)
    {
      Iterator localIterator = ((ArrayList)???).iterator();
      while (localIterator.hasNext())
      {
        NoC2CExtensionInfo localNoC2CExtensionInfo = (NoC2CExtensionInfo)localIterator.next();
        if ((localNoC2CExtensionInfo != null) && (localNoC2CExtensionInfo.uin != null)) {
          synchronized (this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap)
          {
            String str = NoC2CExtensionInfo.getNoC2Ckey(localNoC2CExtensionInfo.type, localNoC2CExtensionInfo.uin);
            this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localNoC2CExtensionInfo);
          }
        }
      }
    }
  }
  
  private void h()
  {
    int i2 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initGroupList begin");
    }
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Groups.class, false, "group_id>=?", new String[] { "0" }, null, null, "seqid asc", null));
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = new ConcurrentHashMap(this.jdField_a_of_type_JavaUtilArrayList.size());
      i1 = 0;
      while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        ((ConcurrentHashMap)localObject).put(localGroups.group_id + "", localGroups);
        i1 += 1;
      }
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = ((ConcurrentHashMap)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("initGroupList end: ");
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        break label189;
      }
    }
    label189:
    for (int i1 = i2;; i1 = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size())
    {
      QLog.d("Q.contacttab.friend", 2, i1);
      return;
    }
  }
  
  public int a()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    int i1 = 0;
    if (localIterator.hasNext())
    {
      if (!((Friends)localIterator.next()).isFriend()) {
        break label51;
      }
      i1 += 1;
    }
    label51:
    for (;;)
    {
      break;
      return i1;
    }
  }
  
  public int a(String paramString)
  {
    paramString = a(paramString);
    if ((paramString == null) || (!paramString.isFriend())) {
      return 0;
    }
    return paramString.friendType;
  }
  
  public int a(String paramString, ExtensionInfo paramExtensionInfo, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    do
    {
      do
      {
        return 0;
        if (((paramInt != 0) || (this.jdField_e_of_type_Boolean)) && ((paramInt != 1) || (this.jdField_f_of_type_Boolean))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("HotFriend_Q.contacttab.", 2, "getChatDays|config close, type=" + paramInt);
      return 0;
    } while ((paramExtensionInfo == null) || (paramExtensionInfo.chatDays == 0));
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_Q.contacttab.", 2, "getChatDays|uin=" + paramString + ",days=" + paramExtensionInfo.chatDays);
    }
    return paramExtensionInfo.chatDays;
  }
  
  public int a(String paramString, ExtensionInfo paramExtensionInfo, boolean paramBoolean)
  {
    if (paramBoolean) {}
    while ((paramExtensionInfo == null) || (paramExtensionInfo.bestIntimacyType == 0)) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_Q.contacttab.", 2, "getBestIntimacyType|uin=" + paramString + ",type=" + paramExtensionInfo.bestIntimacyType);
    }
    return paramExtensionInfo.bestIntimacyType;
  }
  
  public Card a(String paramString)
  {
    return a(paramString, false);
  }
  
  public Card a(String paramString, boolean paramBoolean)
  {
    long l1;
    if (StatisticCollector.a(7))
    {
      l1 = SystemClock.uptimeMillis();
      DetectContactDelete.a();
    }
    for (;;)
    {
      ??? = null;
      if (!TextUtils.isEmpty(paramString)) {}
      synchronized (this.jdField_c_of_type_AndroidSupportV4UtilMQLruCache)
      {
        ??? = (Card)this.jdField_c_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
        ??? = ???;
        if (??? == null)
        {
          ??? = (Card)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Card.class, paramString);
          if ((??? == null) || (TextUtils.isEmpty(paramString))) {}
        }
        synchronized (this.jdField_c_of_type_AndroidSupportV4UtilMQLruCache)
        {
          this.jdField_c_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, ???);
          ??? = ???;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.contacttab.", 2, String.format(Locale.getDefault(), "findFriendCardByUin find from DB uin=%s card=%s", new Object[] { paramString, ??? }));
            ??? = ???;
          }
          if (l1 != 0L) {
            a(SystemClock.uptimeMillis() - l1, false, "query", "Card");
          }
          ??? = ???;
          if (??? == null)
          {
            ??? = ???;
            if (paramBoolean)
            {
              ??? = new Card();
              ((Card)???).uin = paramString;
              ((Card)???).shGender = -1;
              if (StatisticCollector.a(8)) {
                l1 = SystemClock.uptimeMillis();
              }
              if (TextUtils.isEmpty(paramString)) {}
            }
          }
        }
      }
      synchronized (this.jdField_c_of_type_AndroidSupportV4UtilMQLruCache)
      {
        this.jdField_c_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, ???);
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)???);
        if (l1 != 0L) {
          a(SystemClock.uptimeMillis() - l1, false, "insert", "Card");
        }
        ??? = ???;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.contacttab.", 2, String.format(Locale.getDefault(), "findFriendCardByUin new uin=%s card=%s", new Object[] { paramString, ??? }));
          ??? = ???;
        }
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder(200);
          ((StringBuilder)???).append("findFriendCardByUin  uin=").append(paramString).append(", card=").append(???);
          if (??? != null) {
            ((StringBuilder)???).append(", medalSwitchDisable=").append(((Card)???).medalSwitchDisable).append(", bSuperVipOpen=").append(((Card)???).bSuperVipOpen).append(", bQQVipOpen =").append(((Card)???).bQQVipOpen).append(", showOnlineFriends=").append(((Card)???).showOnlineFriends);
          }
          QLog.d("Q.contacttab.", 2, ((StringBuilder)???).toString());
        }
        return ???;
        paramString = finally;
        throw paramString;
        paramString = finally;
        throw paramString;
      }
      l1 = 0L;
    }
  }
  
  public ContactCard a(String paramString)
  {
    return (ContactCard)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ContactCard.class, paramString);
  }
  
  public DateNickNameInfo a(String paramString)
  {
    if (!Friends.isValidUin(paramString)) {
      return null;
    }
    if (!this.jdField_g_of_type_Boolean) {
      ThreadManager.postImmediately(new zlh(this), null, false);
    }
    return (DateNickNameInfo)this.jdField_b_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
  }
  
  public ExtensionInfo a(String paramString)
  {
    return a(paramString, true);
  }
  
  public ExtensionInfo a(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || ("".equals(paramString)))
    {
      ??? = null;
      return ???;
    }
    ExtensionInfo localExtensionInfo;
    if (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      synchronized (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        localExtensionInfo = (ExtensionInfo)this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      }
    }
    do
    {
      if ((Thread.currentThread() == Looper.getMainLooper().getThread()) && (QLog.isColorLevel())) {
        QLog.e("Q.contacttab.extension", 2, "getExtensionInfo, query db in main thread, abort!!!");
      }
      ??? = localExtensionInfo;
      if (localExtensionInfo != null) {
        break;
      }
      ??? = localExtensionInfo;
      if (this.jdField_d_of_type_Boolean) {
        break;
      }
      localExtensionInfo = (ExtensionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ExtensionInfo.class, paramString);
      ??? = localExtensionInfo;
      if (localExtensionInfo == null) {
        break;
      }
      synchronized (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localExtensionInfo);
        return localExtensionInfo;
      }
      localExtensionInfo = null;
      ??? = localExtensionInfo;
      if (localExtensionInfo != null) {
        break;
      }
    } while (paramBoolean);
    return null;
  }
  
  public Friends a(String paramString)
  {
    if (!e(paramString)) {
      localObject = null;
    }
    Friends localFriends;
    do
    {
      do
      {
        do
        {
          return localObject;
          localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          localObject = localFriends;
        } while (localFriends != null);
        localObject = localFriends;
      } while (this.jdField_c_of_type_Boolean);
      localFriends = (Friends)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, paramString);
      if (localFriends != null) {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(localFriends.uin, localFriends);
      }
      localObject = localFriends;
    } while (!QLog.isColorLevel());
    Object localObject = "findFriendEntifyFromCache from db uin = " + paramString + ",f=";
    if (localFriends == null) {}
    for (paramString = "null";; paramString = StringUtil.d(localFriends.uin))
    {
      QLog.d("Q.contacttab.", 2, new Object[] { localObject, paramString });
      return localFriends;
    }
  }
  
  public Friends a(String paramString1, String paramString2)
  {
    paramString1 = b(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1.name = paramString2;
      paramString1.datetime = System.currentTimeMillis();
      if (!this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1.uin)) {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1.uin, paramString1);
      }
      ContactSorter.a(paramString1);
    }
    return paramString1;
  }
  
  public Groups a(String paramString)
  {
    Object localObject;
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      localObject = null;
    }
    Groups localGroups;
    do
    {
      do
      {
        return localObject;
        localGroups = (Groups)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject = localGroups;
      } while (localGroups != null);
      localGroups = (Groups)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Groups.class, paramString);
      localObject = localGroups;
    } while (localGroups == null);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localGroups);
    this.jdField_a_of_type_JavaUtilArrayList = ContactSorter.a(this.jdField_a_of_type_JavaUtilArrayList, localGroups);
    return localGroups;
  }
  
  public KplCard a(String paramString)
  {
    long l1;
    if (StatisticCollector.a(7))
    {
      l1 = SystemClock.uptimeMillis();
      DetectContactDelete.a();
    }
    for (;;)
    {
      paramString = (KplCard)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(KplCard.class, paramString);
      if (l1 != 0L) {
        a(SystemClock.uptimeMillis() - l1, false, "query", "Card");
      }
      if (paramString != null) {
        paramString.transStringToList();
      }
      if ((QLog.isColorLevel()) && (paramString != null)) {
        QLog.d("Q.contacttab.", 2, "findFriendCardByUin qqNick=" + paramString.qqNick + ",gameNick=" + paramString.gameNick + ",uin = " + paramString.uin);
      }
      return paramString;
      l1 = 0L;
    }
  }
  
  public NoC2CExtensionInfo a(String paramString, int paramInt, boolean paramBoolean)
  {
    String str = NoC2CExtensionInfo.getNoC2Ckey(paramInt, paramString);
    NoC2CExtensionInfo localNoC2CExtensionInfo = (NoC2CExtensionInfo)this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
    ??? = localNoC2CExtensionInfo;
    if (localNoC2CExtensionInfo == null)
    {
      ??? = localNoC2CExtensionInfo;
      if (paramBoolean)
      {
        ??? = localNoC2CExtensionInfo;
        if (!this.jdField_d_of_type_Boolean)
        {
          paramString = (NoC2CExtensionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(NoC2CExtensionInfo.class, "type=? and uin=?", new String[] { String.valueOf(paramInt), paramString });
          ??? = paramString;
          if (paramString != null) {
            synchronized (this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap)
            {
              this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString);
              return paramString;
            }
          }
        }
      }
    }
    return ???;
  }
  
  public SpecialCareInfo a(String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    ??? = localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break label28;
      }
      ??? = localObject1;
    }
    for (;;)
    {
      return ???;
      label28:
      localObject1 = localObject3;
      if (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap != null) {}
      synchronized (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        localObject1 = (SpecialCareInfo)this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        ??? = localObject1;
        if (localObject1 == null) {
          continue;
        }
        return (SpecialCareInfo)((SpecialCareInfo)localObject1).clone();
      }
    }
  }
  
  public EntityTransaction a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
  
  public String a(int paramInt)
  {
    return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramInt));
  }
  
  public String a(String paramString)
  {
    Friends localFriends = c(paramString);
    String str = paramString;
    if (localFriends != null)
    {
      str = paramString;
      if (localFriends.alias != null)
      {
        str = paramString;
        if (localFriends.alias.length() > 0) {
          str = localFriends.alias;
        }
      }
    }
    return str;
  }
  
  @UiThread
  public ArrayList a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      ThreadManager.postImmediately(new zlf(this), null, false);
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public ArrayList a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (((Friends)localObject).groupid == paramInt) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  public ArrayList a(String paramString)
  {
    return (ArrayList)this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public List a()
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, "getSpecailCareInfos isSpecialCareInfoCacheInited is false or specailCareInfoCache is null");
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      Iterator localIterator = this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        SpecialCareInfo localSpecialCareInfo = (SpecialCareInfo)localIterator.next();
        if (localSpecialCareInfo.globalSwitch != 0) {
          localArrayList.add((SpecialCareInfo)localSpecialCareInfo.clone());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "getSpecailCareInfos: size=" + localList.size());
    }
    return localList;
  }
  
  public ConcurrentHashMap a()
  {
    return a(false);
  }
  
  public void a()
  {
    label518:
    for (;;)
    {
      ConcurrentHashMap localConcurrentHashMap;
      Object localObject5;
      Object localObject4;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.", 2, "buildUIMaps begin :");
        }
        localConcurrentHashMap = new ConcurrentHashMap(6);
        localObject5 = new ConcurrentHashMap(4);
        Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        if (!localIterator.hasNext()) {
          break label306;
        }
        Friends localFriends = (Friends)localIterator.next();
        if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0)) {
          ContactSorter.a(localFriends);
        }
        String str = localFriends.groupid + "";
        localObject4 = (ArrayList)localConcurrentHashMap.get(str);
        Object localObject1 = localObject4;
        if (localObject4 == null)
        {
          localObject1 = new ArrayList();
          localConcurrentHashMap.put(str, localObject1);
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            break label518;
          }
          localObject4 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label518;
          }
          Groups localGroups = (Groups)((Iterator)localObject4).next();
          if (localGroups.group_id != localFriends.groupid) {
            continue;
          }
          ((ArrayList)localObject1).ensureCapacity(localGroups.group_friend_count);
        }
        ((ArrayList)localObject1).add(localFriends);
        int i1 = ContactUtils.a(localFriends.detalStatusFlag, localFriends.iTermType);
        if ((i1 == 0) || (i1 == 6)) {
          continue;
        }
        localObject1 = (Integer)((ConcurrentHashMap)localObject5).get(str);
        if (localObject1 == null)
        {
          ((ConcurrentHashMap)localObject5).put(str, Integer.valueOf(1));
          continue;
        }
        ((ConcurrentHashMap)localObject5).put(str, Integer.valueOf(localObject2.intValue() + 1));
      }
      finally {}
      continue;
      label306:
      Object localObject3;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ArrayList)localConcurrentHashMap.get(String.valueOf(((Groups)((Iterator)localObject3).next()).group_id));
          if (localObject4 != null) {
            Collections.sort((List)localObject4, ContactSorter.a);
          }
        }
      }
      this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap = ((ConcurrentHashMap)localObject5);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder(300);
        ((StringBuilder)localObject3).append("buildUIMaps end " + localConcurrentHashMap.size() + ": ");
        localObject4 = localConcurrentHashMap.keySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          ((StringBuilder)localObject3).append((String)localObject5).append(", ").append(((ArrayList)localConcurrentHashMap.get(localObject5)).size()).append("; ");
        }
        QLog.d("Q.contacttab.friend", 2, ((StringBuilder)localObject3).toString());
      }
      this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap = localConcurrentHashMap;
      return;
    }
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 718	java/lang/StringBuffer
    //   5: dup
    //   6: invokespecial 719	java/lang/StringBuffer:<init>	()V
    //   9: astore 6
    //   11: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +19 -> 33
    //   17: aload 6
    //   19: ldc_w 721
    //   22: invokevirtual 724	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   25: pop
    //   26: aload 6
    //   28: iload_1
    //   29: invokevirtual 727	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   32: pop
    //   33: aload_0
    //   34: iload_1
    //   35: invokevirtual 729	com/tencent/mobileqq/app/FriendsManager:a	(I)Ljava/util/ArrayList;
    //   38: astore 5
    //   40: aconst_null
    //   41: astore_3
    //   42: aload_0
    //   43: getfield 130	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   46: invokevirtual 667	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   49: astore 4
    //   51: aload 4
    //   53: astore_3
    //   54: aload_3
    //   55: invokevirtual 732	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   58: aload 5
    //   60: invokevirtual 242	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   63: astore 4
    //   65: aload 4
    //   67: invokeinterface 190 1 0
    //   72: ifeq +115 -> 187
    //   75: aload 4
    //   77: invokeinterface 194 1 0
    //   82: checkcast 244	com/tencent/mobileqq/persistence/Entity
    //   85: checkcast 201	com/tencent/mobileqq/data/Friends
    //   88: astore 7
    //   90: aload 7
    //   92: iconst_0
    //   93: putfield 223	com/tencent/mobileqq/data/Friends:groupid	I
    //   96: aload_0
    //   97: aload 7
    //   99: invokevirtual 735	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   102: pop
    //   103: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq -41 -> 65
    //   109: aload 6
    //   111: ldc_w 737
    //   114: invokevirtual 724	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   117: pop
    //   118: aload 6
    //   120: aload 7
    //   122: getfield 358	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   125: iconst_0
    //   126: iconst_4
    //   127: invokevirtual 741	java/lang/String:substring	(II)Ljava/lang/String;
    //   130: invokevirtual 724	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   133: pop
    //   134: goto -69 -> 65
    //   137: astore 4
    //   139: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +32 -> 174
    //   145: ldc_w 743
    //   148: iconst_2
    //   149: new 140	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 745
    //   159: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: iload_1
    //   163: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: aload 4
    //   171: invokestatic 748	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   174: aload_3
    //   175: ifnull +7 -> 182
    //   178: aload_3
    //   179: invokevirtual 750	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   182: aload_0
    //   183: invokevirtual 386	com/tencent/mobileqq/app/FriendsManager:a	()V
    //   186: return
    //   187: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +15 -> 205
    //   193: ldc_w 743
    //   196: iconst_2
    //   197: aload 6
    //   199: invokevirtual 751	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   202: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload_0
    //   206: iconst_0
    //   207: invokestatic 653	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   210: invokevirtual 753	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   213: astore 4
    //   215: aload 4
    //   217: ifnull +26 -> 243
    //   220: aload 4
    //   222: aload 4
    //   224: getfield 252	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   227: aload 5
    //   229: invokevirtual 289	java/util/ArrayList:size	()I
    //   232: iadd
    //   233: putfield 252	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   236: aload_0
    //   237: aload 4
    //   239: invokevirtual 756	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   242: pop
    //   243: aload_0
    //   244: new 140	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   251: iload_1
    //   252: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   255: ldc 228
    //   257: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokevirtual 753	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   266: astore 4
    //   268: aload_0
    //   269: getfield 417	com/tencent/mobileqq/app/FriendsManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   272: ifnull +30 -> 302
    //   275: aload_0
    //   276: getfield 417	com/tencent/mobileqq/app/FriendsManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   279: new 140	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   286: iload_1
    //   287: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   290: ldc 228
    //   292: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokevirtual 759	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   301: pop
    //   302: aload_0
    //   303: getfield 241	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   306: invokevirtual 760	java/util/ArrayList:clone	()Ljava/lang/Object;
    //   309: checkcast 234	java/util/ArrayList
    //   312: astore 5
    //   314: iload_2
    //   315: aload 5
    //   317: invokevirtual 289	java/util/ArrayList:size	()I
    //   320: if_icmpge +26 -> 346
    //   323: iload_1
    //   324: aload 5
    //   326: iload_2
    //   327: invokevirtual 415	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   330: checkcast 246	com/tencent/mobileqq/data/Groups
    //   333: getfield 249	com/tencent/mobileqq/data/Groups:group_id	I
    //   336: if_icmpne +41 -> 377
    //   339: aload 5
    //   341: iload_2
    //   342: invokevirtual 762	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   345: pop
    //   346: aload_0
    //   347: aload 5
    //   349: putfield 241	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   352: aload_0
    //   353: getfield 130	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   356: aload 4
    //   358: invokevirtual 764	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   361: pop
    //   362: aload_3
    //   363: invokevirtual 766	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   366: aload_3
    //   367: ifnull -185 -> 182
    //   370: aload_3
    //   371: invokevirtual 750	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   374: goto -192 -> 182
    //   377: iload_2
    //   378: iconst_1
    //   379: iadd
    //   380: istore_2
    //   381: goto -67 -> 314
    //   384: astore 4
    //   386: aconst_null
    //   387: astore_3
    //   388: aload_3
    //   389: ifnull +7 -> 396
    //   392: aload_3
    //   393: invokevirtual 750	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   396: aload 4
    //   398: athrow
    //   399: astore 4
    //   401: goto -13 -> 388
    //   404: astore 4
    //   406: goto -18 -> 388
    //   409: astore 4
    //   411: goto -272 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	414	0	this	FriendsManager
    //   0	414	1	paramInt	int
    //   1	380	2	i1	int
    //   41	352	3	localObject1	Object
    //   49	27	4	localObject2	Object
    //   137	33	4	localException1	Exception
    //   213	144	4	localGroups	Groups
    //   384	13	4	localObject3	Object
    //   399	1	4	localObject4	Object
    //   404	1	4	localObject5	Object
    //   409	1	4	localException2	Exception
    //   38	310	5	localArrayList	ArrayList
    //   9	189	6	localStringBuffer	java.lang.StringBuffer
    //   88	33	7	localFriends	Friends
    // Exception table:
    //   from	to	target	type
    //   54	65	137	java/lang/Exception
    //   65	134	137	java/lang/Exception
    //   187	205	137	java/lang/Exception
    //   205	215	137	java/lang/Exception
    //   220	243	137	java/lang/Exception
    //   243	302	137	java/lang/Exception
    //   302	314	137	java/lang/Exception
    //   314	346	137	java/lang/Exception
    //   346	366	137	java/lang/Exception
    //   42	51	384	finally
    //   54	65	399	finally
    //   65	134	399	finally
    //   187	205	399	finally
    //   205	215	399	finally
    //   220	243	399	finally
    //   243	302	399	finally
    //   302	314	399	finally
    //   314	346	399	finally
    //   346	366	399	finally
    //   139	174	404	finally
    //   42	51	409	java/lang/Exception
  }
  
  public void a(long paramLong)
  {
    if (!Friends.isValidUin(paramLong)) {}
    Friends localFriends;
    int i1;
    do
    {
      do
      {
        return;
        localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramLong));
      } while (localFriends == null);
      i1 = ContactUtils.a(localFriends.detalStatusFlag, localFriends.iTermType);
    } while ((i1 != 0) && (i1 != 6));
    localFriends.detalStatusFlag = 10;
  }
  
  public void a(ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo == null) || (TextUtils.isEmpty(paramExtensionInfo.uin))) {}
    do
    {
      return;
      a(paramExtensionInfo);
    } while (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap == null);
    synchronized (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramExtensionInfo.uin, paramExtensionInfo);
      return;
    }
  }
  
  public void a(Friends paramFriends)
  {
    if (paramFriends != null)
    {
      ContactSorter.a(paramFriends);
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramFriends.uin, paramFriends);
      a(paramFriends);
    }
  }
  
  public void a(Groups paramGroups)
  {
    int i3 = 0;
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    int i1;
    if (paramGroups.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramGroups);
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramGroups.group_id + "", paramGroups);
      i1 = 0;
    }
    for (;;)
    {
      int i2 = i3;
      if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if (localGroups.group_id == paramGroups.group_id)
        {
          localGroups.datetime = paramGroups.datetime;
          localGroups.group_friend_count = paramGroups.group_friend_count;
          localGroups.group_id = paramGroups.group_id;
          localGroups.group_name = paramGroups.group_name;
          i2 = 1;
        }
      }
      else
      {
        if (i2 == 0) {
          this.jdField_a_of_type_JavaUtilArrayList = ContactSorter.a(this.jdField_a_of_type_JavaUtilArrayList, paramGroups);
        }
        a();
        return;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramGroups);
        break;
      }
      i1 += 1;
    }
  }
  
  /* Error */
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +34 -> 37
    //   6: aload_1
    //   7: getfield 785	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   10: invokestatic 374	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +24 -> 37
    //   16: aload_1
    //   17: getfield 788	com/tencent/mobileqq/data/NearbyPeopleCard:nickname	Ljava/lang/String;
    //   20: invokestatic 374	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifne +14 -> 37
    //   26: aload_1
    //   27: getfield 791	com/tencent/mobileqq/data/NearbyPeopleCard:lastUpdateNickTime	J
    //   30: lstore_2
    //   31: lload_2
    //   32: lconst_0
    //   33: lcmp
    //   34: ifgt +6 -> 40
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: new 566	com/tencent/mobileqq/data/DateNickNameInfo
    //   43: dup
    //   44: aload_1
    //   45: getfield 788	com/tencent/mobileqq/data/NearbyPeopleCard:nickname	Ljava/lang/String;
    //   48: aload_1
    //   49: getfield 791	com/tencent/mobileqq/data/NearbyPeopleCard:lastUpdateNickTime	J
    //   52: invokespecial 794	com/tencent/mobileqq/data/DateNickNameInfo:<init>	(Ljava/lang/String;J)V
    //   55: astore 4
    //   57: aload_0
    //   58: getfield 68	com/tencent/mobileqq/app/FriendsManager:jdField_b_of_type_AndroidSupportV4UtilMQLruCache	Landroid/support/v4/util/MQLruCache;
    //   61: aload_1
    //   62: getfield 785	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   65: aload 4
    //   67: invokevirtual 485	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   70: pop
    //   71: goto -34 -> 37
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	FriendsManager
    //   0	79	1	paramNearbyPeopleCard	NearbyPeopleCard
    //   30	2	2	l1	long
    //   55	11	4	localDateNickNameInfo	DateNickNameInfo
    // Exception table:
    //   from	to	target	type
    //   6	31	74	finally
    //   40	71	74	finally
  }
  
  public void a(NoC2CExtensionInfo paramNoC2CExtensionInfo, boolean paramBoolean)
  {
    if ((paramNoC2CExtensionInfo == null) || (paramNoC2CExtensionInfo.uin == null)) {}
    for (;;)
    {
      return;
      if (this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        continue;
      }
      synchronized (this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        String str = NoC2CExtensionInfo.getNoC2Ckey(paramNoC2CExtensionInfo.type, paramNoC2CExtensionInfo.uin);
        this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramNoC2CExtensionInfo);
        if (!paramBoolean) {
          continue;
        }
        a(paramNoC2CExtensionInfo);
        return;
      }
    }
  }
  
  public void a(SpecialCareInfo paramSpecialCareInfo)
  {
    if ((paramSpecialCareInfo == null) || (paramSpecialCareInfo.uin == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "saveOrUpdateSpecialCareInfo, specailCareInfo is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "saveOrUpdateSpecialCareInfo: " + paramSpecialCareInfo.toString());
    }
    if ((paramSpecialCareInfo.qzoneSwitch == 0) && (paramSpecialCareInfo.specialRingSwitch == 0))
    {
      e(paramSpecialCareInfo.uin);
      return;
    }
    if (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap != null) {}
    synchronized (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramSpecialCareInfo.uin, paramSpecialCareInfo);
      a(paramSpecialCareInfo);
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("hotDisableInteractive", 1) == 1) {
      this.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      String[] arrayOfString = paramString.split("\\|");
      if (arrayOfString.length >= 9) {}
      try
      {
        this.jdField_a_of_type_Int = Integer.valueOf(arrayOfString[0]).intValue();
        this.jdField_b_of_type_Int = Integer.valueOf(arrayOfString[1]).intValue();
        this.jdField_e_of_type_Int = Integer.valueOf(arrayOfString[2]).intValue();
        this.jdField_f_of_type_Int = Integer.valueOf(arrayOfString[3]).intValue();
        this.jdField_g_of_type_Int = Integer.valueOf(arrayOfString[4]).intValue();
        this.jdField_h_of_type_Int = Integer.valueOf(arrayOfString[5]).intValue();
        this.jdField_i_of_type_Int = Integer.valueOf(arrayOfString[6]).intValue();
        this.j = Integer.valueOf(arrayOfString[7]).intValue();
        this.k = Integer.valueOf(arrayOfString[8]).intValue();
        if (arrayOfString.length < 11) {}
      }
      catch (Exception localException2)
      {
        try
        {
          do
          {
            this.jdField_c_of_type_Int = Integer.valueOf(arrayOfString[9]).intValue();
            this.jdField_d_of_type_Int = Integer.valueOf(arrayOfString[10]).intValue();
            return;
            this.jdField_b_of_type_Boolean = false;
            break;
            localException2 = localException2;
          } while (!QLog.isColorLevel());
          QLog.e("Q.contacttab.", 2, paramString, localException2);
        }
        catch (Exception localException1)
        {
          while (!QLog.isColorLevel()) {}
          QLog.e("Q.contacttab.", 2, paramString, localException1);
        }
      }
    }
  }
  
  protected void a(String paramString, byte paramByte)
  {
    paramString = a(paramString, true);
    if (paramString != null)
    {
      paramString.bSingle = paramByte;
      a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Friends localFriends = c(paramString);
    int i1;
    Groups localGroups1;
    Groups localGroups2;
    if (localFriends != null)
    {
      i1 = localFriends.groupid;
      localGroups1 = a(String.valueOf(i1));
      if ((i1 >= 0) && (localGroups1 != null)) {
        localGroups1.group_friend_count -= 1;
      }
      localGroups2 = a(String.valueOf(paramInt));
      if (localGroups2 != null) {
        localGroups2.group_friend_count += 1;
      }
      localFriends.groupid = paramInt;
      localObject = null;
      paramString = null;
    }
    try
    {
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      paramString = localEntityTransaction;
      localObject = localEntityTransaction;
      localEntityTransaction.a();
      paramString = localEntityTransaction;
      localObject = localEntityTransaction;
      a(localFriends);
      if ((i1 >= 0) && (localGroups1 != null))
      {
        paramString = localEntityTransaction;
        localObject = localEntityTransaction;
        a(localGroups1);
      }
      if (localGroups2 != null)
      {
        paramString = localEntityTransaction;
        localObject = localEntityTransaction;
        a(localGroups2);
      }
      paramString = localEntityTransaction;
      localObject = localEntityTransaction;
      localEntityTransaction.c();
      if (localEntityTransaction != null) {
        localEntityTransaction.b();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = paramString;
        if (QLog.isColorLevel())
        {
          localObject = paramString;
          QLog.e("Q.contacttab.group", 2, "setFriendGroup ex=", localException);
        }
        if (paramString != null) {
          paramString.b();
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label239;
      }
      ((EntityTransaction)localObject).b();
    }
    a();
  }
  
  void a(String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (paramGetOnlineInfoResp != null)
    {
      paramString = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString != null) {}
    }
    else
    {
      return;
    }
    paramString.detalStatusFlag = ((byte)(int)paramGetOnlineInfoResp.dwStatus);
    paramString.iTermType = ((int)paramGetOnlineInfoResp.iTermType);
    paramString.abilityBits = paramGetOnlineInfoResp.uAbiFlag;
    paramString.eNetwork = paramGetOnlineInfoResp.eNetworkType;
    paramString.netTypeIconId = paramGetOnlineInfoResp.eIconType;
    paramString.strTermDesc = paramGetOnlineInfoResp.strTermDesc;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString1 == null)) {
      return;
    }
    Friends localFriends = b(paramString1);
    localFriends.alias = paramString2;
    localFriends.datetime = System.currentTimeMillis();
    if (paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramString1, paramString2);
    }
    a(localFriends);
  }
  
  public void a(String paramString1, String paramString2, byte paramByte)
  {
    NearbyPeopleCard localNearbyPeopleCard2 = (NearbyPeopleCard)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { paramString1 });
    NearbyPeopleCard localNearbyPeopleCard1 = localNearbyPeopleCard2;
    if (localNearbyPeopleCard2 == null)
    {
      localNearbyPeopleCard1 = new NearbyPeopleCard();
      localNearbyPeopleCard1.uin = paramString1;
    }
    localNearbyPeopleCard1.lastUpdateNickTime = System.currentTimeMillis();
    localNearbyPeopleCard1.nickname = paramString2;
    if (paramByte != -1) {
      localNearbyPeopleCard1.gender = paramByte;
    }
    a(localNearbyPeopleCard1);
    a(localNearbyPeopleCard1);
  }
  
  protected void a(String paramString1, String paramString2, byte paramByte1, short paramShort, byte paramByte2)
  {
    byte b1 = 1;
    if ((CrmUtils.a(paramByte1)) && (!QidianManager.b(paramByte1))) {
      return;
    }
    paramString1 = b(paramString1);
    paramString1.cSpecialFlag = paramByte1;
    if (QLog.isColorLevel()) {
      QLog.i("Q.contacttab.", 2, "saveFriendInfoByUin uin=" + paramString1.uin + ", cSpecialFlag=" + paramString1.cSpecialFlag);
    }
    paramString1.name = paramString2;
    if (paramShort == 0) {
      paramByte1 = b1;
    }
    for (;;)
    {
      paramString1.gender = paramByte1;
      paramString1.age = paramByte2;
      paramString1.datetime = System.currentTimeMillis();
      if (!this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1.uin)) {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1.uin, paramString1);
      }
      ContactSorter.a(paramString1);
      a(paramString1);
      return;
      if (paramShort == 1) {
        paramByte1 = 2;
      } else {
        paramByte1 = 0;
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    int i1 = 0;
    if (paramBoolean)
    {
      a().edit().putLong(paramString, System.currentTimeMillis()).commit();
      i1 = 1;
    }
    for (;;)
    {
      if (i1 != 0) {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(105, paramBoolean, paramString);
      }
      return;
      if (a().contains(paramString))
      {
        a().edit().remove(paramString).commit();
        i1 = 1;
      }
    }
  }
  
  void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      HashMap localHashMap = new HashMap(paramArrayList.size());
      paramArrayList = paramArrayList.iterator();
      Object localObject1;
      Object localObject2;
      while (paramArrayList.hasNext())
      {
        localObject1 = (SimpleOnlineFriendInfo)paramArrayList.next();
        localObject2 = String.valueOf(((SimpleOnlineFriendInfo)localObject1).friendUin);
        Friends localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject2);
        if (localFriends != null)
        {
          localFriends.detalStatusFlag = ((SimpleOnlineFriendInfo)localObject1).detalStatusFlag;
          localFriends.iTermType = ((SimpleOnlineFriendInfo)localObject1).iTermType;
          localFriends.abilityBits = ((SimpleOnlineFriendInfo)localObject1).uAbiFlag;
          localFriends.eNetwork = ((SimpleOnlineFriendInfo)localObject1).eNetworkType;
          localFriends.netTypeIconId = ((SimpleOnlineFriendInfo)localObject1).eIconType;
          localFriends.strTermDesc = ((SimpleOnlineFriendInfo)localObject1).strTermDesc;
          localHashMap.put(localObject2, Boolean.TRUE);
        }
      }
      paramArrayList = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (String)paramArrayList.next();
        localObject2 = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
        if (((Boolean)localHashMap.get(localObject1) == null) && (((Friends)localObject2).isFriend()))
        {
          ((Friends)localObject2).detalStatusFlag = 20;
          ((Friends)localObject2).abilityBits = 0L;
          ((Friends)localObject2).eNetwork = 0;
        }
      }
    }
  }
  
  public void a(@NonNull ArrayList paramArrayList, int paramInt)
  {
    Object localObject2;
    Friends localFriends;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(paramArrayList.size() * 12 + 48);
      ((StringBuilder)localObject1).append("saveGatherList size=").append(paramArrayList.size()).append(" startIndex=").append(paramInt).append(" uin=");
      localObject2 = paramArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localFriends = (Friends)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append(localFriends.uin + ",");
      }
      QLog.d("FriendListHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramArrayList.size() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("everHasGatheredContacts", true).commit();
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      ((EntityTransaction)localObject1).a();
      if (paramInt == 0)
      {
        localObject2 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localFriends = (Friends)((Iterator)localObject2).next();
          if (localFriends.gathtertype == 1)
          {
            localFriends.gathtertype = 0;
            a(localFriends);
          }
        }
      }
    }
    catch (Exception paramArrayList)
    {
      QLog.e("Q.contacttab.", 1, "saveGatherList", paramArrayList);
      return;
      this.n = 0;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = (Friends)paramArrayList.next();
        localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((Friends)localObject2).uin);
        if (localFriends != null)
        {
          localFriends.gathtertype = 1;
          localFriends.age = ((Friends)localObject2).age;
          localFriends.smartRemark = ((Friends)localObject2).smartRemark;
          localFriends.gender = ((Friends)localObject2).gender;
          localFriends.recommReason = ((Friends)localObject2).recommReason;
          a(localFriends);
          this.n += 1;
        }
      }
    }
    finally
    {
      ((EntityTransaction)localObject1).b();
    }
    ((EntityTransaction)localObject1).b();
  }
  
  public void a(List paramList)
  {
    TraceUtils.a("queryFriends_" + paramList.size());
    if (paramList.size() > 0)
    {
      Object localObject = new StringBuilder("uin=? ");
      int i1 = 1;
      while (i1 < paramList.size())
      {
        ((StringBuilder)localObject).append("or uin=? ");
        i1 += 1;
      }
      paramList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, true, ((StringBuilder)localObject).toString(), (String[])paramList.toArray(new String[paramList.size()]), null, null, null, null);
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (Friends)paramList.next();
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(((Friends)localObject).uin, localObject);
          QidianManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Friends)localObject);
        }
      }
    }
    TraceUtils.a();
  }
  
  public void a(List paramList, long paramLong, boolean paramBoolean)
  {
    int i3 = 0;
    if (paramList != null) {}
    for (int i1 = paramList.size();; i1 = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "syncSpecialCareInfos: " + i1 + ", " + paramLong + ", " + paramBoolean);
      }
      int i2;
      if (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap != null)
      {
        localObject = this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap;
        i2 = 0;
        for (;;)
        {
          if (i2 < i1) {}
          Iterator localIterator;
          try
          {
            this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.put(((SpecialCareInfo)paramList.get(i2)).uin, paramList.get(i2));
            i2 += 1;
          }
          finally {}
        }
        if (paramBoolean)
        {
          localIterator = this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
          while (localIterator.hasNext()) {
            if (((SpecialCareInfo)((Map.Entry)localIterator.next()).getValue()).dateTime < paramLong) {
              localIterator.remove();
            }
          }
        }
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      try
      {
        ((EntityTransaction)localObject).a();
        i2 = i3;
        while (i2 < i1)
        {
          a((Entity)paramList.get(i2));
          i2 += 1;
        }
        if (paramBoolean)
        {
          paramList = ((SpecialCareInfo)SpecialCareInfo.class.newInstance()).getTableName();
          i1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramList, "dateTime<" + paramLong, null);
          if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.", 2, "syncSpecialCareInfos delete from table " + paramList + " ret = " + i1);
          }
        }
        ((EntityTransaction)localObject).c();
        return;
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        return;
      }
      finally
      {
        ((EntityTransaction)localObject).b();
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    this.jdField_e_of_type_Boolean = paramBoolean1;
    this.jdField_f_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_e_of_type_Int = paramInt3;
    this.jdField_f_of_type_Int = paramInt4;
    this.jdField_g_of_type_Int = paramInt5;
    this.jdField_h_of_type_Int = paramInt6;
    this.jdField_i_of_type_Int = paramInt7;
    this.j = paramInt8;
    this.k = paramInt9;
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_1
    //   4: ifnull +278 -> 282
    //   7: aload_2
    //   8: ifnull +274 -> 282
    //   11: aconst_null
    //   12: astore 6
    //   14: aload_0
    //   15: getfield 130	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   18: invokevirtual 667	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   21: astore 7
    //   23: aload 7
    //   25: astore 6
    //   27: aload 6
    //   29: invokevirtual 732	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   32: new 718	java/lang/StringBuffer
    //   35: dup
    //   36: invokespecial 719	java/lang/StringBuffer:<init>	()V
    //   39: astore 7
    //   41: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +12 -> 56
    //   47: aload 7
    //   49: ldc_w 1054
    //   52: invokevirtual 724	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   55: pop
    //   56: iconst_0
    //   57: istore_3
    //   58: iload_3
    //   59: istore 4
    //   61: iload 5
    //   63: aload_1
    //   64: arraylength
    //   65: if_icmpge +218 -> 283
    //   68: iload_3
    //   69: istore 4
    //   71: aload_0
    //   72: aload_1
    //   73: iload 5
    //   75: baload
    //   76: invokestatic 653	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   79: invokevirtual 753	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   82: astore 8
    //   84: iload_3
    //   85: istore 4
    //   87: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +70 -> 160
    //   93: iload_3
    //   94: istore 4
    //   96: aload 7
    //   98: ldc_w 1056
    //   101: invokevirtual 724	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   104: pop
    //   105: iload_3
    //   106: istore 4
    //   108: aload 7
    //   110: aload_1
    //   111: iload 5
    //   113: baload
    //   114: invokevirtual 727	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   117: pop
    //   118: iload_3
    //   119: istore 4
    //   121: aload 7
    //   123: ldc_w 1058
    //   126: invokevirtual 724	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   129: pop
    //   130: iload_3
    //   131: istore 4
    //   133: aload 7
    //   135: aload_2
    //   136: iload 5
    //   138: baload
    //   139: invokevirtual 727	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   142: pop
    //   143: aload 8
    //   145: ifnonnull +15 -> 160
    //   148: iload_3
    //   149: istore 4
    //   151: aload 7
    //   153: ldc_w 1060
    //   156: invokevirtual 724	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   159: pop
    //   160: iload_3
    //   161: istore 4
    //   163: aload 8
    //   165: ifnull +222 -> 387
    //   168: iload_3
    //   169: istore 4
    //   171: aload 8
    //   173: getfield 1063	com/tencent/mobileqq/data/Groups:seqid	B
    //   176: aload_2
    //   177: iload 5
    //   179: baload
    //   180: if_icmpne +9 -> 189
    //   183: iload_3
    //   184: istore 4
    //   186: goto +201 -> 387
    //   189: iload_3
    //   190: istore 4
    //   192: aload 8
    //   194: aload_2
    //   195: iload 5
    //   197: baload
    //   198: putfield 1063	com/tencent/mobileqq/data/Groups:seqid	B
    //   201: iconst_1
    //   202: istore_3
    //   203: iconst_1
    //   204: istore 4
    //   206: aload_0
    //   207: aload 8
    //   209: invokevirtual 756	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   212: pop
    //   213: iload_3
    //   214: istore 4
    //   216: goto +171 -> 387
    //   219: astore_2
    //   220: aload 6
    //   222: astore_1
    //   223: iload 4
    //   225: istore_3
    //   226: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +33 -> 262
    //   232: ldc_w 743
    //   235: iconst_2
    //   236: new 140	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   243: ldc_w 1065
    //   246: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_2
    //   250: invokevirtual 1068	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   253: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: aload_1
    //   263: ifnull +118 -> 381
    //   266: aload_1
    //   267: invokevirtual 750	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   270: iload_3
    //   271: istore 4
    //   273: iload 4
    //   275: ifeq +7 -> 282
    //   278: aload_0
    //   279: invokevirtual 1070	com/tencent/mobileqq/app/FriendsManager:d	()V
    //   282: return
    //   283: iload_3
    //   284: istore 4
    //   286: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +18 -> 307
    //   292: iload_3
    //   293: istore 4
    //   295: ldc_w 743
    //   298: iconst_2
    //   299: aload 7
    //   301: invokevirtual 751	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   304: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: iload_3
    //   308: istore 4
    //   310: aload 6
    //   312: invokevirtual 766	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   315: iload_3
    //   316: istore 4
    //   318: aload 6
    //   320: ifnull -47 -> 273
    //   323: aload 6
    //   325: invokevirtual 750	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   328: iload_3
    //   329: istore 4
    //   331: goto -58 -> 273
    //   334: astore_1
    //   335: aconst_null
    //   336: astore 6
    //   338: aload 6
    //   340: ifnull +8 -> 348
    //   343: aload 6
    //   345: invokevirtual 750	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   348: aload_1
    //   349: athrow
    //   350: astore_1
    //   351: goto -13 -> 338
    //   354: astore_2
    //   355: aload_1
    //   356: astore 6
    //   358: aload_2
    //   359: astore_1
    //   360: goto -22 -> 338
    //   363: astore_2
    //   364: iconst_0
    //   365: istore_3
    //   366: aload 6
    //   368: astore_1
    //   369: goto -143 -> 226
    //   372: astore_2
    //   373: aload 6
    //   375: astore_1
    //   376: iconst_0
    //   377: istore_3
    //   378: goto -152 -> 226
    //   381: iload_3
    //   382: istore 4
    //   384: goto -111 -> 273
    //   387: iload 5
    //   389: iconst_1
    //   390: iadd
    //   391: istore 5
    //   393: iload 4
    //   395: istore_3
    //   396: goto -338 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	this	FriendsManager
    //   0	399	1	paramArrayOfByte1	byte[]
    //   0	399	2	paramArrayOfByte2	byte[]
    //   57	339	3	i1	int
    //   59	335	4	i2	int
    //   1	391	5	i3	int
    //   12	362	6	localObject1	Object
    //   21	279	7	localObject2	Object
    //   82	126	8	localGroups	Groups
    // Exception table:
    //   from	to	target	type
    //   61	68	219	java/lang/Exception
    //   71	84	219	java/lang/Exception
    //   87	93	219	java/lang/Exception
    //   96	105	219	java/lang/Exception
    //   108	118	219	java/lang/Exception
    //   121	130	219	java/lang/Exception
    //   133	143	219	java/lang/Exception
    //   151	160	219	java/lang/Exception
    //   171	183	219	java/lang/Exception
    //   192	201	219	java/lang/Exception
    //   206	213	219	java/lang/Exception
    //   286	292	219	java/lang/Exception
    //   295	307	219	java/lang/Exception
    //   310	315	219	java/lang/Exception
    //   14	23	334	finally
    //   27	56	350	finally
    //   61	68	350	finally
    //   71	84	350	finally
    //   87	93	350	finally
    //   96	105	350	finally
    //   108	118	350	finally
    //   121	130	350	finally
    //   133	143	350	finally
    //   151	160	350	finally
    //   171	183	350	finally
    //   192	201	350	finally
    //   206	213	350	finally
    //   286	292	350	finally
    //   295	307	350	finally
    //   310	315	350	finally
    //   226	262	354	finally
    //   14	23	363	java/lang/Exception
    //   27	56	372	java/lang/Exception
  }
  
  void a(Friends[] paramArrayOfFriends, long paramLong, boolean paramBoolean)
  {
    if (paramArrayOfFriends != null) {}
    for (int i1 = paramArrayOfFriends.length;; i1 = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "saveFriendsList: " + i1 + ", " + paramLong + ", " + paramBoolean);
      }
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      long l1 = 0L;
      for (;;)
      {
        int i2;
        try
        {
          if (StatisticCollector.a(11)) {
            l1 = SystemClock.uptimeMillis();
          }
          localEntityTransaction.a();
          if (l1 == 0L) {
            break label339;
          }
          a(SystemClock.uptimeMillis() - l1, false, "trans", "Friends");
        }
        catch (Exception localException)
        {
          Iterator localIterator;
          Friends localFriends;
          localException.printStackTrace();
          localEntityTransaction.b();
          if (i1 <= 0) {
            continue;
          }
          a(paramArrayOfFriends);
          return;
          localEntityTransaction.c();
          localEntityTransaction.b();
          continue;
        }
        finally
        {
          localEntityTransaction.b();
        }
        if (i2 < i1)
        {
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramArrayOfFriends[i2].uin, paramArrayOfFriends[i2]);
          a(paramArrayOfFriends[i2]);
          i2 += 1;
        }
        else
        {
          if (paramBoolean)
          {
            localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
            if (localIterator.hasNext())
            {
              localFriends = (Friends)((Map.Entry)localIterator.next()).getValue();
              if ((localFriends.datetime >= paramLong) || (!localFriends.isFriend())) {
                continue;
              }
              localIterator.remove();
              l1 = 0L;
              if (StatisticCollector.a(10)) {
                l1 = SystemClock.uptimeMillis();
              }
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localFriends);
              if (l1 == 0L) {
                continue;
              }
              a(SystemClock.uptimeMillis() - l1, true, "delete", "Friends");
              continue;
            }
          }
          label339:
          i2 = 0;
        }
      }
    }
  }
  
  /* Error */
  void a(Groups[] paramArrayOfGroups)
  {
    // Byte code:
    //   0: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: new 140	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 1084
    //   16: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: astore_3
    //   20: aload_1
    //   21: ifnull +31 -> 52
    //   24: aload_1
    //   25: arraylength
    //   26: istore_2
    //   27: ldc_w 295
    //   30: iconst_2
    //   31: aload_3
    //   32: iload_2
    //   33: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_1
    //   43: ifnull +8 -> 51
    //   46: aload_1
    //   47: arraylength
    //   48: ifne +9 -> 57
    //   51: return
    //   52: iconst_m1
    //   53: istore_2
    //   54: goto -27 -> 27
    //   57: new 234	java/util/ArrayList
    //   60: dup
    //   61: aload_1
    //   62: arraylength
    //   63: invokespecial 1085	java/util/ArrayList:<init>	(I)V
    //   66: astore 4
    //   68: new 38	java/util/concurrent/ConcurrentHashMap
    //   71: dup
    //   72: aload_1
    //   73: arraylength
    //   74: invokespecial 41	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   77: astore 5
    //   79: aload_0
    //   80: getfield 130	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   83: invokevirtual 667	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   86: astore_3
    //   87: aload_3
    //   88: invokevirtual 732	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   91: iconst_0
    //   92: istore_2
    //   93: iload_2
    //   94: aload_1
    //   95: arraylength
    //   96: if_icmpge +60 -> 156
    //   99: aload 5
    //   101: new 140	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   108: aload_1
    //   109: iload_2
    //   110: aaload
    //   111: getfield 249	com/tencent/mobileqq/data/Groups:group_id	I
    //   114: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: ldc 228
    //   119: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: aload_1
    //   126: iload_2
    //   127: aaload
    //   128: invokevirtual 239	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   131: pop
    //   132: aload 4
    //   134: aload_1
    //   135: iload_2
    //   136: aaload
    //   137: invokevirtual 259	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   140: pop
    //   141: aload_0
    //   142: aload_1
    //   143: iload_2
    //   144: aaload
    //   145: invokevirtual 756	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   148: pop
    //   149: iload_2
    //   150: iconst_1
    //   151: iadd
    //   152: istore_2
    //   153: goto -60 -> 93
    //   156: aload_1
    //   157: arraylength
    //   158: iconst_1
    //   159: if_icmple +11 -> 170
    //   162: aload 4
    //   164: getstatic 706	com/tencent/mobileqq/app/ContactSorter:a	Ljava/util/Comparator;
    //   167: invokestatic 712	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   170: aload_0
    //   171: getfield 417	com/tencent/mobileqq/app/FriendsManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   174: ifnull +114 -> 288
    //   177: aload_0
    //   178: getfield 417	com/tencent/mobileqq/app/FriendsManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   181: invokevirtual 179	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   184: invokeinterface 185 1 0
    //   189: astore_1
    //   190: aload_1
    //   191: invokeinterface 190 1 0
    //   196: ifeq +92 -> 288
    //   199: aload_1
    //   200: invokeinterface 194 1 0
    //   205: checkcast 196	java/util/Map$Entry
    //   208: astore 6
    //   210: aload 5
    //   212: aload 6
    //   214: invokeinterface 1088 1 0
    //   219: checkcast 211	java/lang/String
    //   222: invokevirtual 624	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   225: ifne -35 -> 190
    //   228: aload_0
    //   229: getfield 130	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   232: aload 6
    //   234: invokeinterface 199 1 0
    //   239: checkcast 244	com/tencent/mobileqq/persistence/Entity
    //   242: invokevirtual 764	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   245: pop
    //   246: goto -56 -> 190
    //   249: astore_1
    //   250: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq +14 -> 267
    //   256: ldc_w 743
    //   259: iconst_2
    //   260: ldc_w 1090
    //   263: aload_1
    //   264: invokestatic 748	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   267: aload_3
    //   268: invokevirtual 750	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   271: aload_0
    //   272: aload 4
    //   274: putfield 241	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   277: aload_0
    //   278: aload 5
    //   280: putfield 417	com/tencent/mobileqq/app/FriendsManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   283: aload_0
    //   284: invokevirtual 386	com/tencent/mobileqq/app/FriendsManager:a	()V
    //   287: return
    //   288: aload_3
    //   289: invokevirtual 766	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   292: aload_3
    //   293: invokevirtual 750	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   296: goto -25 -> 271
    //   299: astore_1
    //   300: aload_3
    //   301: invokevirtual 750	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   304: aload_1
    //   305: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	FriendsManager
    //   0	306	1	paramArrayOfGroups	Groups[]
    //   26	127	2	i1	int
    //   19	282	3	localObject	Object
    //   66	207	4	localArrayList	ArrayList
    //   77	202	5	localConcurrentHashMap	ConcurrentHashMap
    //   208	25	6	localEntry	Map.Entry
    // Exception table:
    //   from	to	target	type
    //   87	91	249	java/lang/Exception
    //   93	149	249	java/lang/Exception
    //   156	170	249	java/lang/Exception
    //   170	190	249	java/lang/Exception
    //   190	246	249	java/lang/Exception
    //   288	292	249	java/lang/Exception
    //   87	91	299	finally
    //   93	149	299	finally
    //   156	170	299	finally
    //   170	190	299	finally
    //   190	246	299	finally
    //   250	267	299	finally
    //   288	292	299	finally
  }
  
  public boolean a()
  {
    boolean bool = b();
    f();
    this.jdField_e_of_type_Boolean = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    this.jdField_f_of_type_Boolean = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1);
    a(SharedPreUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()));
    return bool;
  }
  
  public boolean a(Card paramCard)
  {
    if (paramCard == null) {
      return false;
    }
    if (QLog.isDevelopLevel()) {}
    for (;;)
    {
      synchronized (this.jdField_c_of_type_AndroidSupportV4UtilMQLruCache)
      {
        Card localCard = (Card)this.jdField_c_of_type_AndroidSupportV4UtilMQLruCache.get(paramCard.uin);
        if (localCard != paramCard) {
          QLog.i("Q.contacttab.", 4, String.format(Locale.getDefault(), "saveCard uin=%s cacheOne=%s card=%s", new Object[] { paramCard.uin, localCard, paramCard }));
        }
        if (StatisticCollector.a(9))
        {
          l1 = SystemClock.uptimeMillis();
          boolean bool = a(paramCard);
          if (l1 != 0L) {
            a(SystemClock.uptimeMillis() - l1, false, "update", "Card");
          }
          return bool;
        }
      }
      long l1 = 0L;
    }
  }
  
  public boolean a(ContactCard paramContactCard)
  {
    return a(paramContactCard);
  }
  
  protected boolean a(Friends paramFriends)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {
      if (paramFriends.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramFriends);
        if (paramFriends.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return bool;
      } while ((paramFriends.getStatus() != 1001) && (paramFriends.getStatus() != 1002));
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramFriends);
    }
    QLog.d("Q.contacttab.friend", 2, "updateFriendEntity em closed f=" + paramFriends.uin);
    return false;
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
    QLog.d("Q.contacttab.friend", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "initBlackList begin");
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Groups.class, false, "group_id=?", new String[] { "-1002" }, null, null, null, null);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Friends localFriends = (Friends)((Iterator)localObject).next();
          this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap.put(localFriends.uin, "");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "initBlackList end, size=" + this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      }
    }
    return this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
  }
  
  /* Error */
  protected boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +50 -> 56
    //   9: ldc_w 743
    //   12: iconst_2
    //   13: new 140	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 1133
    //   23: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc_w 288
    //   33: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: iload_2
    //   37: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: ldc_w 288
    //   43: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload_3
    //   47: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_0
    //   57: getfield 130	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   60: invokevirtual 667	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   63: astore 8
    //   65: aload 8
    //   67: astore 9
    //   69: aload 8
    //   71: invokevirtual 732	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   74: aload 8
    //   76: astore 9
    //   78: aload_0
    //   79: aload_1
    //   80: invokevirtual 609	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   83: astore 10
    //   85: aload 8
    //   87: astore 9
    //   89: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +48 -> 140
    //   95: aload 8
    //   97: astore 9
    //   99: ldc_w 979
    //   102: iconst_2
    //   103: new 140	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 1135
    //   113: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_1
    //   117: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc_w 1137
    //   123: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 10
    //   128: getfield 205	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   131: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   134: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload 8
    //   142: astore 9
    //   144: aload_0
    //   145: aload_1
    //   146: invokevirtual 1139	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Z
    //   149: ifeq +12 -> 161
    //   152: aload 8
    //   154: astore 9
    //   156: aload_0
    //   157: aload_1
    //   158: invokevirtual 1141	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)V
    //   161: aload 8
    //   163: astore 9
    //   165: aload 10
    //   167: getfield 223	com/tencent/mobileqq/data/Friends:groupid	I
    //   170: iconst_m1
    //   171: if_icmpne +271 -> 442
    //   174: aload 8
    //   176: astore 9
    //   178: aload 10
    //   180: iload_2
    //   181: putfield 223	com/tencent/mobileqq/data/Friends:groupid	I
    //   184: iconst_m1
    //   185: istore 5
    //   187: iconst_1
    //   188: istore 7
    //   190: aload 8
    //   192: astore 9
    //   194: aload 10
    //   196: invokestatic 617	java/lang/System:currentTimeMillis	()J
    //   199: putfield 621	com/tencent/mobileqq/data/Friends:datetime	J
    //   202: iload_3
    //   203: ifeq +95 -> 298
    //   206: aload 8
    //   208: astore 9
    //   210: aload 10
    //   212: iconst_1
    //   213: putfield 205	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   216: aload 8
    //   218: astore 9
    //   220: aload 10
    //   222: ldc_w 1143
    //   225: putfield 993	com/tencent/mobileqq/data/Friends:recommReason	Ljava/lang/String;
    //   228: aload 8
    //   230: astore 9
    //   232: aload_0
    //   233: aload_0
    //   234: getfield 297	com/tencent/mobileqq/app/FriendsManager:n	I
    //   237: iconst_1
    //   238: iadd
    //   239: putfield 297	com/tencent/mobileqq/app/FriendsManager:n	I
    //   242: aload 8
    //   244: astore 9
    //   246: aload_0
    //   247: aload 10
    //   249: getfield 358	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   252: invokevirtual 1145	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   255: astore_1
    //   256: aload_1
    //   257: ifnull +41 -> 298
    //   260: aload 8
    //   262: astore 9
    //   264: aload_1
    //   265: getfield 509	com/tencent/mobileqq/data/Card:shGender	S
    //   268: ifne +201 -> 469
    //   271: iconst_1
    //   272: istore 4
    //   274: aload 8
    //   276: astore 9
    //   278: aload 10
    //   280: iload 4
    //   282: putfield 915	com/tencent/mobileqq/data/Friends:gender	B
    //   285: aload 8
    //   287: astore 9
    //   289: aload 10
    //   291: aload_1
    //   292: getfield 1147	com/tencent/mobileqq/data/Card:age	B
    //   295: putfield 918	com/tencent/mobileqq/data/Friends:age	I
    //   298: aload 8
    //   300: astore 9
    //   302: aload_0
    //   303: aload 10
    //   305: invokevirtual 756	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   308: pop
    //   309: aload 8
    //   311: astore 9
    //   313: aload_0
    //   314: iload_2
    //   315: invokestatic 653	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   318: invokevirtual 753	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   321: astore_1
    //   322: aload_1
    //   323: ifnull +30 -> 353
    //   326: aload 8
    //   328: astore 9
    //   330: aload_1
    //   331: aload_1
    //   332: getfield 252	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   335: iconst_1
    //   336: iadd
    //   337: putfield 252	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   340: aload 8
    //   342: astore 9
    //   344: aload_0
    //   345: getfield 130	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   348: aload_1
    //   349: invokevirtual 781	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   352: pop
    //   353: iload 7
    //   355: ifne +56 -> 411
    //   358: iload 5
    //   360: iflt +51 -> 411
    //   363: iload 5
    //   365: iload_2
    //   366: if_icmpeq +45 -> 411
    //   369: aload 8
    //   371: astore 9
    //   373: aload_0
    //   374: iload 5
    //   376: invokestatic 653	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   379: invokevirtual 753	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   382: astore_1
    //   383: aload_1
    //   384: ifnull +27 -> 411
    //   387: aload 8
    //   389: astore 9
    //   391: aload_1
    //   392: aload_1
    //   393: getfield 252	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   396: iconst_1
    //   397: isub
    //   398: putfield 252	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   401: aload 8
    //   403: astore 9
    //   405: aload_0
    //   406: aload_1
    //   407: invokevirtual 756	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   410: pop
    //   411: aload 8
    //   413: astore 9
    //   415: aload 8
    //   417: invokevirtual 766	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   420: iload 7
    //   422: istore_3
    //   423: aload 8
    //   425: ifnull +11 -> 436
    //   428: aload 8
    //   430: invokevirtual 750	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   433: iload 7
    //   435: istore_3
    //   436: aload_0
    //   437: invokevirtual 386	com/tencent/mobileqq/app/FriendsManager:a	()V
    //   440: iload_3
    //   441: ireturn
    //   442: aload 8
    //   444: astore 9
    //   446: aload 10
    //   448: getfield 223	com/tencent/mobileqq/data/Friends:groupid	I
    //   451: istore 5
    //   453: aload 8
    //   455: astore 9
    //   457: aload 10
    //   459: iload_2
    //   460: putfield 223	com/tencent/mobileqq/data/Friends:groupid	I
    //   463: iconst_0
    //   464: istore 7
    //   466: goto -276 -> 190
    //   469: aload 8
    //   471: astore 9
    //   473: aload_1
    //   474: getfield 509	com/tencent/mobileqq/data/Card:shGender	S
    //   477: istore 6
    //   479: iload 6
    //   481: iconst_1
    //   482: if_icmpne -208 -> 274
    //   485: iconst_2
    //   486: istore 4
    //   488: goto -214 -> 274
    //   491: astore_1
    //   492: aconst_null
    //   493: astore 8
    //   495: iconst_0
    //   496: istore 7
    //   498: aload 8
    //   500: astore 9
    //   502: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   505: ifeq +18 -> 523
    //   508: aload 8
    //   510: astore 9
    //   512: ldc_w 743
    //   515: iconst_2
    //   516: ldc_w 1149
    //   519: aload_1
    //   520: invokestatic 748	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   523: iload 7
    //   525: istore_3
    //   526: aload 8
    //   528: ifnull -92 -> 436
    //   531: aload 8
    //   533: invokevirtual 750	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   536: iload 7
    //   538: istore_3
    //   539: goto -103 -> 436
    //   542: astore_1
    //   543: aconst_null
    //   544: astore 9
    //   546: aload 9
    //   548: ifnull +8 -> 556
    //   551: aload 9
    //   553: invokevirtual 750	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   556: aload_1
    //   557: athrow
    //   558: astore_1
    //   559: goto -13 -> 546
    //   562: astore_1
    //   563: iconst_0
    //   564: istore 7
    //   566: goto -68 -> 498
    //   569: astore_1
    //   570: goto -72 -> 498
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	573	0	this	FriendsManager
    //   0	573	1	paramString	String
    //   0	573	2	paramInt	int
    //   0	573	3	paramBoolean	boolean
    //   1	486	4	b1	byte
    //   185	267	5	i1	int
    //   477	6	6	i2	int
    //   188	377	7	bool	boolean
    //   63	469	8	localEntityTransaction1	EntityTransaction
    //   67	485	9	localEntityTransaction2	EntityTransaction
    //   83	375	10	localFriends	Friends
    // Exception table:
    //   from	to	target	type
    //   56	65	491	java/lang/Exception
    //   56	65	542	finally
    //   69	74	558	finally
    //   78	85	558	finally
    //   89	95	558	finally
    //   99	140	558	finally
    //   144	152	558	finally
    //   156	161	558	finally
    //   165	174	558	finally
    //   178	184	558	finally
    //   194	202	558	finally
    //   210	216	558	finally
    //   220	228	558	finally
    //   232	242	558	finally
    //   246	256	558	finally
    //   264	271	558	finally
    //   278	285	558	finally
    //   289	298	558	finally
    //   302	309	558	finally
    //   313	322	558	finally
    //   330	340	558	finally
    //   344	353	558	finally
    //   373	383	558	finally
    //   391	401	558	finally
    //   405	411	558	finally
    //   415	420	558	finally
    //   446	453	558	finally
    //   457	463	558	finally
    //   473	479	558	finally
    //   502	508	558	finally
    //   512	523	558	finally
    //   69	74	562	java/lang/Exception
    //   78	85	562	java/lang/Exception
    //   89	95	562	java/lang/Exception
    //   99	140	562	java/lang/Exception
    //   144	152	562	java/lang/Exception
    //   156	161	562	java/lang/Exception
    //   165	174	562	java/lang/Exception
    //   178	184	562	java/lang/Exception
    //   446	453	562	java/lang/Exception
    //   457	463	562	java/lang/Exception
    //   194	202	569	java/lang/Exception
    //   210	216	569	java/lang/Exception
    //   220	228	569	java/lang/Exception
    //   232	242	569	java/lang/Exception
    //   246	256	569	java/lang/Exception
    //   264	271	569	java/lang/Exception
    //   278	285	569	java/lang/Exception
    //   289	298	569	java/lang/Exception
    //   302	309	569	java/lang/Exception
    //   313	322	569	java/lang/Exception
    //   330	340	569	java/lang/Exception
    //   344	353	569	java/lang/Exception
    //   373	383	569	java/lang/Exception
    //   391	401	569	java/lang/Exception
    //   405	411	569	java/lang/Exception
    //   415	420	569	java/lang/Exception
    //   473	479	569	java/lang/Exception
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      l2 = a().getLong(paramString, 0L);
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (paramString.startsWith("+")) {
          l1 = a().getLong(paramString.replace("+", ""), 0L);
        }
      }
      l2 = l1;
      if (l1 == 0L)
      {
        l2 = l1;
        if (paramString.startsWith("+86")) {
          l2 = a().getLong(paramString.replace("+86", ""), 0L);
        }
      }
    } while (l2 == 0L);
    long l2 = System.currentTimeMillis() - l2;
    if (paramBoolean) {}
    for (long l1 = 259200000L; (l2 > 0L) && (l2 < l1); l1 = 500654080L) {
      return true;
    }
    a().edit().remove(paramString).commit();
    return false;
  }
  
  public boolean a(Friends[] paramArrayOfFriends, int paramInt)
  {
    if ((paramArrayOfFriends == null) || (paramArrayOfFriends.length == 0)) {
      return true;
    }
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      localEntityTransaction.a();
      int i1 = 0;
      while (i1 < paramInt)
      {
        ContactSorter.a(paramArrayOfFriends[i1]);
        a(paramArrayOfFriends[i1]);
        i1 += 1;
      }
      localEntityTransaction.c();
      return true;
    }
    catch (Exception paramArrayOfFriends)
    {
      paramArrayOfFriends.printStackTrace();
      return true;
    }
    finally
    {
      localEntityTransaction.b();
    }
  }
  
  public int b()
  {
    return this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() - this.n;
  }
  
  public int b(String paramString)
  {
    paramString = c(paramString);
    if (paramString != null) {
      return paramString.detalStatusFlag;
    }
    return 10;
  }
  
  public int b(String paramString, ExtensionInfo paramExtensionInfo, boolean paramBoolean)
  {
    if (paramBoolean) {}
    while ((paramExtensionInfo == null) || (paramExtensionInfo.chatHotLevel == 0)) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_Q.contacttab.", 2, "getInteractionType|uin=" + paramString + ",level=" + paramExtensionInfo.chatHotLevel + ",days=" + paramExtensionInfo.chatDays);
    }
    return paramExtensionInfo.chatHotLevel;
  }
  
  public Card b(String paramString)
  {
    return a(paramString, true);
  }
  
  public ContactCard b(String paramString)
  {
    ContactCard localContactCard2 = (ContactCard)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ContactCard.class, paramString);
    ContactCard localContactCard1 = localContactCard2;
    if (localContactCard2 == null)
    {
      localContactCard1 = new ContactCard();
      localContactCard1.mobileNo = paramString;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localContactCard1);
    }
    return localContactCard1;
  }
  
  public Friends b(String paramString)
  {
    Friends localFriends2 = c(paramString);
    Friends localFriends1 = localFriends2;
    if (localFriends2 == null)
    {
      localFriends1 = new Friends();
      localFriends1.uin = paramString;
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localFriends1);
      a(localFriends1);
    }
    return localFriends1;
  }
  
  public Friends b(String paramString1, String paramString2)
  {
    Friends localFriends = b(paramString1);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    if (!paramString1.equals(localFriends.remark))
    {
      localFriends.remark = paramString1;
      localFriends.datetime = System.currentTimeMillis();
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(localFriends.uin, localFriends);
      ContactSorter.a(localFriends);
      a(localFriends);
      a();
    }
    return localFriends;
  }
  
  public String b(String paramString)
  {
    String str = null;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
        str = (String)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
      }
      return str;
    }
  }
  
  public ArrayList b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      f();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public List b()
  {
    List localList = a();
    if (localList != null) {
      Collections.sort(localList, new zlg(this));
    }
    return localList;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initExtensionInfoCache begin");
    }
    Object localObject4;
    Object localObject2;
    if (!this.jdField_d_of_type_Boolean)
    {
      if (this.jdField_d_of_type_Boolean) {
        return;
      }
      if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() >= 100) {
        break label366;
      }
      localObject4 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      ??? = new StringBuilder(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() * 20);
      localObject2 = new ArrayList(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      while (((Iterator)localObject4).hasNext())
      {
        Friends localFriends = (Friends)((Map.Entry)((Iterator)localObject4).next()).getValue();
        if (localFriends.isFriend())
        {
          ((StringBuilder)???).append("uin=? or ");
          ((List)localObject2).add(localFriends.uin);
        }
      }
      if (((StringBuilder)???).length() <= 4) {
        break label363;
      }
      ??? = ((StringBuilder)???).delete(((StringBuilder)???).length() - 4, ((StringBuilder)???).length());
    }
    label171:
    label363:
    label366:
    for (??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ExtensionInfo.class, true, ((StringBuilder)???).toString(), (String[])((List)localObject2).toArray(new String[((List)localObject2).size()]), null, null, null, null);; ??? = null)
    {
      localObject2 = ???;
      if (??? == null) {
        localObject2 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ExtensionInfo.class);
      }
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (ExtensionInfo)((Iterator)localObject2).next();
          if ((localObject4 != null) && (((ExtensionInfo)localObject4).uin != null) && (b(((ExtensionInfo)localObject4).uin))) {
            synchronized (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap)
            {
              this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(((ExtensionInfo)localObject4).uin, localObject4);
            }
          }
        }
      }
      g();
      this.jdField_d_of_type_Boolean = true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.contacttab.friend", 2, "initExtensionInfoCache end: " + this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      return;
      break label171;
    }
  }
  
  public void b(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void b(Friends paramFriends)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "updateSingleFriend: " + paramFriends.uin);
    }
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramFriends.uin, paramFriends);
    a(paramFriends);
    a();
  }
  
  public void b(String paramString)
  {
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramString)) && (paramString.length() > 3)) {
      QLog.d("Q.contacttab.", 2, "add friend to black list " + paramString.substring(0, 2));
    }
    if (this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, "");
    }
    localObject2 = null;
    localObject1 = null;
    try
    {
      localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      localEntityTransaction.a();
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      paramString = b(paramString);
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      if (paramString.groupid >= 0)
      {
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        Groups localGroups = a(String.valueOf(paramString.groupid));
        if (localGroups != null)
        {
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localGroups.group_friend_count -= 1;
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          a(localGroups);
        }
      }
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      paramString.groupid = -1002;
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.uin);
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      a(paramString);
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      localEntityTransaction.c();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        EntityTransaction localEntityTransaction;
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject2 = localObject1;
          QLog.e("Q.contacttab.group", 2, "addFriendToBlackList ex", paramString);
        }
        if (localObject1 != null) {
          localObject1.b();
        }
      }
    }
    finally
    {
      if (localObject2 == null) {
        break label285;
      }
      localObject2.b();
    }
    a();
  }
  
  public void b(String paramString1, String paramString2)
  {
    paramString1 = b(paramString1);
    paramString1.name = paramString2;
    paramString1.datetime = System.currentTimeMillis();
    if (!this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1.uin)) {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1.uin, paramString1);
    }
    ContactSorter.a(paramString1);
    a(paramString1);
  }
  
  public void b(List arg1)
  {
    if ((??? == null) || (???.size() == 0)) {}
    for (;;)
    {
      return;
      if (???.size() == 1)
      {
        a((ExtensionInfo)???.get(0));
        return;
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      ((EntityTransaction)localObject1).a();
      try
      {
        Iterator localIterator = ???.iterator();
        while (localIterator.hasNext())
        {
          ExtensionInfo localExtensionInfo2 = (ExtensionInfo)localIterator.next();
          if (!TextUtils.isEmpty(localExtensionInfo2.uin)) {
            a(localExtensionInfo2);
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.extension", 2, "bulk insert exception: " + localException.getMessage());
        }
        ((EntityTransaction)localObject1).b();
        for (;;)
        {
          localObject1 = ???.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ExtensionInfo localExtensionInfo1 = (ExtensionInfo)((Iterator)localObject1).next();
            if ((!TextUtils.isEmpty(localExtensionInfo1.uin)) && (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
              synchronized (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap)
              {
                this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(localExtensionInfo1.uin, localExtensionInfo1);
              }
            }
          }
          localObject2.c();
          localObject2.b();
        }
      }
      finally
      {
        localObject2.b();
      }
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initFriendCache begin");
    }
    localObject2 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, false, "groupid>=?", new String[] { "0" }, null, null, null, null);
    int i1;
    ConcurrentHashMap localConcurrentHashMap;
    StringBuilder localStringBuilder;
    ArrayList localArrayList;
    label116:
    Friends localFriends;
    if (localObject2 != null)
    {
      i1 = ((ArrayList)localObject2).size();
      localConcurrentHashMap = new ConcurrentHashMap(i1);
      this.m = 0;
      localStringBuilder = new StringBuilder();
      new ArrayList();
      if ((localObject2 == null) || (((ArrayList)localObject2).size() == 0)) {
        break label350;
      }
      localArrayList = new ArrayList();
      i1 = 0;
      if (i1 >= ((ArrayList)localObject2).size()) {
        break label281;
      }
      localFriends = (Friends)((ArrayList)localObject2).get(i1);
      QidianManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFriends);
      if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0))
      {
        ContactSorter.a(localFriends);
        localArrayList.add(localFriends);
      }
      localConcurrentHashMap.put(localFriends.uin, localFriends);
      if (localFriends.gathtertype == 1) {
        localStringBuilder.append(localFriends.uin + ";");
      }
      if (localFriends.gathtertype != 2) {
        break label259;
      }
      this.m += 1;
    }
    for (;;)
    {
      i1 += 1;
      break label116;
      i1 = 0;
      break;
      label259:
      if (localFriends.gathtertype == 1) {
        this.n += 1;
      }
    }
    label281:
    if (localArrayList.size() > 0)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      ((EntityTransaction)localObject2).a();
      i1 = 0;
    }
    try
    {
      while (i1 < localArrayList.size())
      {
        a((Entity)localArrayList.get(i1));
        i1 += 1;
      }
      ((EntityTransaction)localObject2).c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label350:
        ((EntityTransaction)localObject2).b();
      }
    }
    finally
    {
      ((EntityTransaction)localObject2).b();
    }
    localArrayList.clear();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initFriendCache end: " + localConcurrentHashMap.size());
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "mRecomCount: " + this.m + " ; mGatheredCount = " + this.n + " ; initFriendCache gathered : " + localStringBuilder);
    }
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(localConcurrentHashMap);
    this.jdField_c_of_type_Boolean = true;
    if (localConcurrentHashMap.size() > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.isFriend();
    }
    return false;
  }
  
  public int c()
  {
    return this.n;
  }
  
  public int c(String paramString, ExtensionInfo paramExtensionInfo, boolean paramBoolean)
  {
    if (paramBoolean) {}
    while ((paramExtensionInfo == null) || (paramExtensionInfo.loverChatLevel == 0)) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_Q.contacttab.", 2, "getLoverInteractionType|uin=" + paramString + ",level=" + paramExtensionInfo.loverChatLevel + ",days=" + paramExtensionInfo.loverChatDays);
    }
    return paramExtensionInfo.loverChatLevel;
  }
  
  public Friends c(String paramString)
  {
    Object localObject2;
    if (!e(paramString)) {
      localObject2 = null;
    }
    Object localObject1;
    do
    {
      return localObject2;
      localObject2 = a(paramString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = (Friends)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, paramString);
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.contacttab.", 2, "findFriendEntityByUin from db isFriendCacheInited=" + this.jdField_c_of_type_Boolean + " f=" + localObject2 + " uin=" + paramString);
          localObject1 = localObject2;
        }
      }
      localObject2 = localObject1;
    } while (localObject1 == null);
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
    return localObject1;
  }
  
  public ArrayList c()
  {
    ArrayList localArrayList = new ArrayList(16);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Groups)localIterator.next();
        localObject = (List)this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(((Groups)localObject).group_id));
        if (localObject != null) {
          localArrayList.addAll((Collection)localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initSpecialCareInfoCache begin");
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      Object localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(SpecialCareInfo.class, false, "globalSwitch!=?", new String[] { "0" }, null, null, null, null);
      if (localObject1 != null) {
        synchronized (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap)
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            SpecialCareInfo localSpecialCareInfo = (SpecialCareInfo)((Iterator)localObject1).next();
            if ((localSpecialCareInfo != null) && (localSpecialCareInfo.uin != null)) {
              this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.put(localSpecialCareInfo.uin, localSpecialCareInfo);
            }
          }
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initSpecialCareInfoCache end: " + this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.size());
    }
  }
  
  public void c(String paramString)
  {
    if (this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
    paramString = b(paramString);
    paramString.groupid = -1;
    a(paramString);
  }
  
  public void c(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache == null) {
          this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(200);
        }
        this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramString1, paramString2);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.contacttab.", 2, String.format(Locale.getDefault(), "cacheCampusName uin: %s, name: %s", new Object[] { Utils.b(paramString1), Utils.b(paramString2) }));
        return;
      }
    }
  }
  
  /* Error */
  public void c(List paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 689 1 0
    //   10: ifne +20 -> 30
    //   13: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +13 -> 29
    //   19: ldc_w 295
    //   22: iconst_2
    //   23: ldc_w 1271
    //   26: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: return
    //   30: aload_1
    //   31: invokeinterface 689 1 0
    //   36: iconst_1
    //   37: if_icmpne +18 -> 55
    //   40: aload_0
    //   41: aload_1
    //   42: iconst_0
    //   43: invokeinterface 1025 2 0
    //   48: checkcast 661	com/tencent/mobileqq/data/SpecialCareInfo
    //   51: invokevirtual 1273	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/SpecialCareInfo;)V
    //   54: return
    //   55: aload_0
    //   56: getfield 71	com/tencent/mobileqq/app/FriendsManager:jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   59: ifnull +73 -> 132
    //   62: aload_0
    //   63: getfield 71	com/tencent/mobileqq/app/FriendsManager:jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   66: astore_2
    //   67: aload_2
    //   68: monitorenter
    //   69: aload_1
    //   70: invokeinterface 1014 1 0
    //   75: astore_3
    //   76: aload_3
    //   77: invokeinterface 190 1 0
    //   82: ifeq +48 -> 130
    //   85: aload_3
    //   86: invokeinterface 194 1 0
    //   91: checkcast 661	com/tencent/mobileqq/data/SpecialCareInfo
    //   94: astore 4
    //   96: aload 4
    //   98: getfield 797	com/tencent/mobileqq/data/SpecialCareInfo:uin	Ljava/lang/String;
    //   101: invokestatic 374	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   104: ifne -28 -> 76
    //   107: aload_0
    //   108: getfield 71	com/tencent/mobileqq/app/FriendsManager:jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   111: aload 4
    //   113: getfield 797	com/tencent/mobileqq/data/SpecialCareInfo:uin	Ljava/lang/String;
    //   116: aload 4
    //   118: invokevirtual 239	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   121: pop
    //   122: goto -46 -> 76
    //   125: astore_1
    //   126: aload_2
    //   127: monitorexit
    //   128: aload_1
    //   129: athrow
    //   130: aload_2
    //   131: monitorexit
    //   132: aload_0
    //   133: getfield 130	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   136: invokevirtual 667	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   139: astore_2
    //   140: aload_2
    //   141: invokevirtual 732	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   144: aload_1
    //   145: invokeinterface 1014 1 0
    //   150: astore_1
    //   151: aload_1
    //   152: invokeinterface 190 1 0
    //   157: ifeq +110 -> 267
    //   160: aload_1
    //   161: invokeinterface 194 1 0
    //   166: checkcast 661	com/tencent/mobileqq/data/SpecialCareInfo
    //   169: astore_3
    //   170: aload_3
    //   171: getfield 797	com/tencent/mobileqq/data/SpecialCareInfo:uin	Ljava/lang/String;
    //   174: invokestatic 374	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   177: ifne -26 -> 151
    //   180: aload_0
    //   181: aload_3
    //   182: invokevirtual 756	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   185: pop
    //   186: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq -38 -> 151
    //   192: ldc_w 295
    //   195: iconst_2
    //   196: new 140	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 1275
    //   206: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_3
    //   210: invokevirtual 802	com/tencent/mobileqq/data/SpecialCareInfo:toString	()Ljava/lang/String;
    //   213: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: goto -71 -> 151
    //   225: astore_1
    //   226: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +33 -> 262
    //   232: ldc_w 584
    //   235: iconst_2
    //   236: new 140	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   243: ldc_w 1277
    //   246: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_1
    //   250: invokevirtual 1068	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   253: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: aload_2
    //   263: invokevirtual 750	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   266: return
    //   267: aload_2
    //   268: invokevirtual 766	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   271: aload_2
    //   272: invokevirtual 750	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   275: return
    //   276: astore_1
    //   277: aload_2
    //   278: invokevirtual 750	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   281: aload_1
    //   282: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	FriendsManager
    //   0	283	1	paramList	List
    //   66	212	2	localObject1	Object
    //   75	135	3	localObject2	Object
    //   94	23	4	localSpecialCareInfo	SpecialCareInfo
    // Exception table:
    //   from	to	target	type
    //   69	76	125	finally
    //   76	122	125	finally
    //   126	128	125	finally
    //   130	132	125	finally
    //   144	151	225	java/lang/Exception
    //   151	222	225	java/lang/Exception
    //   267	271	225	java/lang/Exception
    //   144	151	276	finally
    //   151	222	276	finally
    //   226	262	276	finally
    //   267	271	276	finally
  }
  
  public boolean c()
  {
    if (this.l == -1) {}
    while (this.l == 1) {
      return true;
    }
    return false;
  }
  
  public boolean c(String paramString)
  {
    return a(paramString, false);
  }
  
  public int d(String paramString, ExtensionInfo paramExtensionInfo, boolean paramBoolean)
  {
    if (paramBoolean) {}
    while ((paramExtensionInfo == null) || (paramExtensionInfo.praiseHotLevel == 0)) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_Q.contacttab.", 2, "getmLikeType|uin=" + paramString + ",level=" + paramExtensionInfo.praiseHotLevel + ",days=" + paramExtensionInfo.praiseDays);
    }
    return paramExtensionInfo.praiseHotLevel;
  }
  
  public ArrayList d()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      h();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  void d()
  {
    h();
    a();
  }
  
  public void d(String paramString)
  {
    Object localObject4 = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (localObject4 != null)
    {
      if (((Friends)localObject4).gathtertype != 2) {
        break label297;
      }
      this.m -= 1;
    }
    for (;;)
    {
      localObject2 = null;
      localObject1 = null;
      try
      {
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localEntityTransaction.a();
        Object localObject3 = localObject4;
        if (localObject4 == null)
        {
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localObject3 = (Friends)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, paramString);
        }
        if (localObject3 != null)
        {
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localObject4 = a(String.valueOf(((Friends)localObject3).groupid));
          if (localObject4 != null)
          {
            localObject1 = localEntityTransaction;
            localObject2 = localEntityTransaction;
            ((Groups)localObject4).group_friend_count -= 1;
            localObject1 = localEntityTransaction;
            localObject2 = localEntityTransaction;
            a((Entity)localObject4);
          }
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject3);
        }
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localEntityTransaction.c();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          EntityTransaction localEntityTransaction;
          localObject2 = localObject1;
          QLog.e("Q.contacttab.", 1, "", localException);
          if (localObject1 != null) {
            localObject1.b();
          }
        }
      }
      finally
      {
        if (localObject2 == null) {
          break;
        }
        localObject2.b();
      }
      a();
      if (QvipSpecialCareManager.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        QvipSpecialCareManager.b(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if (QvipSpecialCareManager.b(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        QvipSpecialCareManager.c(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      e(paramString);
      paramString = a(paramString);
      if (paramString != null)
      {
        paramString.bestIntimacyType = 0;
        paramString.bestIntimacyDays = 0;
        paramString.praiseHotLevel = 0;
        paramString.chatHotLevel = 0;
        paramString.loverChatLevel = 0;
        paramString.loverTransFlag = false;
        paramString.qzoneVisitType = 0;
        paramString.qzoneHotDays = 0;
        paramString.lastQzoneVisitTime = 0L;
        a(paramString);
      }
      return;
      label297:
      if (((Friends)localObject4).gathtertype == 1) {
        this.n -= 1;
      }
    }
  }
  
  /* Error */
  public void d(List paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 689 1 0
    //   10: ifgt +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 130	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   18: invokevirtual 667	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   21: astore_2
    //   22: aload_2
    //   23: invokevirtual 732	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   26: aload_1
    //   27: invokeinterface 1014 1 0
    //   32: astore_1
    //   33: aload_1
    //   34: invokeinterface 190 1 0
    //   39: ifeq +67 -> 106
    //   42: aload_1
    //   43: invokeinterface 194 1 0
    //   48: checkcast 211	java/lang/String
    //   51: astore_3
    //   52: aload_0
    //   53: getfield 43	com/tencent/mobileqq/app/FriendsManager:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   56: aload_3
    //   57: invokevirtual 232	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   60: checkcast 201	com/tencent/mobileqq/data/Friends
    //   63: astore_3
    //   64: aload_3
    //   65: ifnull -32 -> 33
    //   68: aload_3
    //   69: iconst_0
    //   70: putfield 205	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   73: aload_0
    //   74: aload_3
    //   75: invokevirtual 735	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   78: pop
    //   79: aload_0
    //   80: aload_0
    //   81: getfield 297	com/tencent/mobileqq/app/FriendsManager:n	I
    //   84: iconst_1
    //   85: isub
    //   86: putfield 297	com/tencent/mobileqq/app/FriendsManager:n	I
    //   89: goto -56 -> 33
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 1050	java/lang/Exception:printStackTrace	()V
    //   97: aload_2
    //   98: invokevirtual 750	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   101: aload_0
    //   102: invokevirtual 386	com/tencent/mobileqq/app/FriendsManager:a	()V
    //   105: return
    //   106: aload_2
    //   107: invokevirtual 766	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   110: aload_2
    //   111: invokevirtual 750	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   114: goto -13 -> 101
    //   117: astore_1
    //   118: aload_2
    //   119: invokevirtual 750	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	FriendsManager
    //   0	124	1	paramList	List
    //   21	98	2	localEntityTransaction	EntityTransaction
    //   51	24	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   22	33	92	java/lang/Exception
    //   33	64	92	java/lang/Exception
    //   68	89	92	java/lang/Exception
    //   106	110	92	java/lang/Exception
    //   22	33	117	finally
    //   33	64	117	finally
    //   68	89	117	finally
    //   93	97	117	finally
    //   106	110	117	finally
  }
  
  public boolean d()
  {
    boolean bool1 = true;
    boolean bool2 = this.jdField_b_of_type_Boolean;
    if (this.l == -1)
    {
      ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).p();
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendReactive", 2, "getEnableReactive disableReactive" + bool1 + "IsDisableInteractive=" + this.l);
      }
      return bool1;
      if (this.l != 1) {
        bool1 = false;
      }
    }
  }
  
  public boolean d(String paramString)
  {
    paramString = c(paramString);
    if (paramString != null) {
      return paramString.isShield();
    }
    return false;
  }
  
  public int e(String paramString, ExtensionInfo paramExtensionInfo, boolean paramBoolean)
  {
    if (paramBoolean) {}
    while ((paramExtensionInfo == null) || (paramExtensionInfo.qzoneVisitType == 0)) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_Q.contacttab.", 2, "getQzoneVisitType|uin=" + paramString + ",level=" + paramExtensionInfo.qzoneVisitType + ",days=" + paramExtensionInfo.qzoneHotDays);
    }
    return paramExtensionInfo.qzoneVisitType;
  }
  
  public ArrayList e()
  {
    new ConcurrentHashMap(4);
    ConcurrentHashMap localConcurrentHashMap = a(true);
    ArrayList localArrayList = new ArrayList(16);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        List localList = (List)localConcurrentHashMap.get(String.valueOf(((Groups)localIterator.next()).group_id));
        if (localList != null) {
          localArrayList.addAll(localList);
        }
      }
    }
    return localArrayList;
  }
  
  public void e()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_g_of_type_Boolean;
        if (bool) {
          return;
        }
        long l1 = System.currentTimeMillis();
        try
        {
          ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(NearbyPeopleCard.class, false, "lastUpdateNickTime>?", new String[] { "0" }, null, null, "_id desc", String.valueOf(100));
          if (!QLog.isColorLevel()) {
            break label215;
          }
          if (localArrayList == null)
          {
            i1 = 0;
            QLog.d("Q.contacttab.", 2, "nearby people card count = " + i1);
            break label215;
            if (i1 >= localArrayList.size()) {
              continue;
            }
            NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localArrayList.get(i1);
            if (localNearbyPeopleCard == null) {
              break label225;
            }
            a(localNearbyPeopleCard);
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(NearbyPeopleCard.class.getSimpleName());
          Object localObject1 = null;
          continue;
          i1 = localObject1.size();
          continue;
          this.jdField_g_of_type_Boolean = true;
        }
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("Q.contacttab.", 4, "initDateNickNameCache cost time:" + (System.currentTimeMillis() - l1));
        continue;
        if (localObject2 == null) {
          continue;
        }
      }
      finally {}
      label215:
      int i1 = 0;
      continue;
      label225:
      i1 += 1;
    }
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "deleteSpecialCareInfo: uin=" + paramString);
    }
    SpecialCareInfo localSpecialCareInfo = null;
    if (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap != null) {}
    for (;;)
    {
      synchronized (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        localSpecialCareInfo = (SpecialCareInfo)this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        if (localSpecialCareInfo != null) {
          break label147;
        }
        paramString = (SpecialCareInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(SpecialCareInfo.class, paramString);
        if (paramString != null)
        {
          if (!StatisticCollector.a(10)) {
            break label142;
          }
          l1 = SystemClock.uptimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramString);
          if (l1 != 0L) {
            a(SystemClock.uptimeMillis() - l1, false, "delete", "SpecialCare");
          }
        }
        return;
      }
      label142:
      long l1 = 0L;
      continue;
      label147:
      paramString = localSpecialCareInfo;
    }
  }
  
  public void e(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    for (;;)
    {
      try
      {
        localEntityTransaction.a();
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          continue;
        }
        localObject = (String)paramList.next();
        localObject = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if (localObject == null) {
          continue;
        }
        if (((Friends)localObject).gathtertype == 2) {
          this.m -= 1;
        }
        if ((((Friends)localObject).gathtertype != 2) && (((Friends)localObject).gathtertype != 0)) {
          continue;
        }
        if (((Friends)localObject).gathtertype == 0) {
          ((Friends)localObject).recommReason = "手工设置";
        }
        ((Friends)localObject).gathtertype = 1;
        localCard = a(((Friends)localObject).uin);
        if (localCard == null) {
          continue;
        }
        if (localCard.shGender != 0) {
          continue;
        }
        b1 = 1;
      }
      catch (Exception paramList)
      {
        Object localObject;
        Card localCard;
        paramList.printStackTrace();
        localEntityTransaction.b();
        return;
        if (localCard.shGender != 1) {
          break label238;
        }
        b1 = 2;
        continue;
        localEntityTransaction.c();
        localEntityTransaction.b();
        continue;
      }
      finally
      {
        localEntityTransaction.b();
      }
      ((Friends)localObject).gender = b1;
      ((Friends)localObject).age = localCard.age;
      a((Friends)localObject);
      this.n += 1;
      continue;
      label238:
      byte b1 = 0;
    }
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList != null) && ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0) || (this.jdField_a_of_type_JavaUtilArrayList.size() > 0));
  }
  
  public void f(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (cmd0x7c4.RecommendReason)paramList.next();
        String str = String.valueOf(((cmd0x7c4.RecommendReason)localObject).uint32_reason_id.get());
        localObject = ((cmd0x7c4.RecommendReason)localObject).bytes_recommend_reason.get().toStringUtf8();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject);
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "key : " + str + " ; reason : " + (String)localObject);
        }
      }
    }
  }
  
  public boolean f()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "FriendsManager onDestory");
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendsManager
 * JD-Core Version:    0.7.0.1
 */