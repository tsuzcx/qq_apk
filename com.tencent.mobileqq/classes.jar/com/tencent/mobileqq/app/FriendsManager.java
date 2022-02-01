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
import com.tencent.mobileqq.activity.aio.intimate.IntimateUtil;
import com.tencent.mobileqq.activity.aio.tips.GatherContactsTipsHelper;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DateNickNameInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.KplCard;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.api.IFriendExtensionService;
import com.tencent.mobileqq.javahook.DetectContactDelete;
import com.tencent.mobileqq.mutualmark.info.ExtensionMutualMarkData;
import com.tencent.mobileqq.mutualmark.oldlogic.HotReactiveHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil;
import com.tencent.mobileqq.onlinestatus.music.OnlineMusicStatusManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.relationx.addFrd.AddFrdStateMng;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager.Utils;
import com.tencent.pb.onlinestatus.CustomOnlineStatusPb.CustomOnlineStatusMsg;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import friendlist.GetOnlineInfoResp;
import friendlist.SimpleOnlineFriendInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.RecommendReason;

public class FriendsManager
  implements Manager
{
  public int a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  private MQLruCache<String, DateNickNameInfo> jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(500);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IFriendDataService jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService;
  private IFriendExtensionService jdField_a_of_type_ComTencentMobileqqFriendApiIFriendExtensionService;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private final AddFrdStateMng jdField_a_of_type_ComTencentMobileqqRelationxAddFrdAddFrdStateMng = new AddFrdStateMng();
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(6);
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new FriendsManager.1(this);
  public volatile boolean a;
  public int b;
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<String, Entity> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new QQConcurrentHashMap(1012, 0, 400);
  public boolean b;
  public int c;
  private ConcurrentHashMap<String, SpecialCareInfo> c;
  public boolean c;
  public int d;
  private ConcurrentHashMap<String, String> jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  private volatile boolean jdField_d_of_type_Boolean = false;
  public int e;
  private boolean e;
  public int f;
  private boolean f;
  public int g;
  private boolean g;
  public int h = 30;
  public int i = 3;
  public int j = 30;
  public int k = 5;
  public int l = 7;
  public int m = 30;
  public int n = 7;
  public int o = 30;
  public int p = 6;
  public int q = -1;
  private int r = 0;
  
  @Deprecated
  public FriendsManager()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 3;
    this.jdField_b_of_type_Int = 30;
    this.jdField_c_of_type_Int = 7;
    this.jdField_d_of_type_Int = 30;
    this.jdField_e_of_type_Int = 3;
    this.jdField_f_of_type_Int = 30;
    this.jdField_g_of_type_Int = 3;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = false;
  }
  
  public FriendsManager(QQAppInterface paramQQAppInterface, EntityManager paramEntityManager)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 3;
    this.jdField_b_of_type_Int = 30;
    this.jdField_c_of_type_Int = 7;
    this.jdField_d_of_type_Int = 30;
    this.jdField_e_of_type_Int = 3;
    this.jdField_f_of_type_Int = 30;
    this.jdField_g_of_type_Int = 3;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
    g();
    this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService = ((IFriendDataService)paramQQAppInterface.getRuntimeService(IFriendDataService.class, ""));
    this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendExtensionService = ((IFriendExtensionService)paramQQAppInterface.getRuntimeService(IFriendExtensionService.class, ""));
  }
  
  private SharedPreferences a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "add_friend_request_sp", 0);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  private ConcurrentHashMap<String, ArrayList<Entity>> a(boolean paramBoolean)
  {
    label540:
    label543:
    label546:
    label549:
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
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getAllFriends();
        int i2 = ((List)localObject1).size();
        Iterator localIterator = ((List)localObject1).iterator();
        i1 = 0;
        if (localIterator.hasNext())
        {
          Friends localFriends = (Friends)localIterator.next();
          if (localFriends.gathtertype != 1) {
            break label546;
          }
          i1 += 1;
          if (paramBoolean)
          {
            if (localFriends.gathtertype != 1) {}
          }
          else
          {
            if (localFriends.gathtertype == 0) {
              break label543;
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
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject1 = new ArrayList();
            localConcurrentHashMap.put(str, localObject1);
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getGroupList().iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label540;
            }
            Groups localGroups = (Groups)((Iterator)localObject3).next();
            if (localGroups.group_id != localFriends.groupid) {
              continue;
            }
            ((ArrayList)localObject1).ensureCapacity(Math.min(i2, localGroups.group_friend_count));
          }
          ((ArrayList)localObject1).add(localFriends);
          if (!paramBoolean) {
            break label549;
          }
          int i3 = ContactUtils.a(localFriends);
          if ((i3 == 0) || (i3 == 6)) {
            break label549;
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
      localHashMap.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(null, "actFriendSqliteOpt", true, paramLong, 0L, localHashMap, null, false);
      return;
      str = "0";
      break;
    }
  }
  
  private boolean f(String paramString)
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
  
  private void g()
  {
    ThreadManager.executeOnSubThread(new FriendsManager.2(this));
  }
  
  private void h()
  {
    MessageNotificationSettingManager localMessageNotificationSettingManager = MessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool = localMessageNotificationSettingManager.a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, new Object[] { "doResetRingIdOfExtensionInfo: invoked. ", " hasResetGrayUserRingId: ", Boolean.valueOf(bool) });
    }
    if (!bool)
    {
      localMessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendExtensionService.getAllExtensionInfo());
      localMessageNotificationSettingManager.a();
    }
  }
  
  private void i()
  {
    ??? = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(NoC2CExtensionInfo.class);
    if (??? != null)
    {
      Iterator localIterator = ((ArrayList)???).iterator();
      while (localIterator.hasNext())
      {
        NoC2CExtensionInfo localNoC2CExtensionInfo = (NoC2CExtensionInfo)localIterator.next();
        if ((localNoC2CExtensionInfo != null) && (localNoC2CExtensionInfo.uin != null)) {
          synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
          {
            String str = NoC2CExtensionInfo.getNoC2Ckey(localNoC2CExtensionInfo.type, localNoC2CExtensionInfo.uin);
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localNoC2CExtensionInfo);
          }
        }
      }
    }
  }
  
  private void j()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getAllFriends();
    if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {}
    label256:
    label260:
    for (;;)
    {
      return;
      localObject1 = ((List)localObject1).iterator();
      int i1 = 0;
      Object localObject2;
      label91:
      int i2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Friends)((Iterator)localObject1).next();
        if (((Friends)localObject2).isFriend())
        {
          localObject2 = a(((Friends)localObject2).uin, false);
          if ((localObject2 == null) || (((ExtensionInfo)localObject2).hiddenChatSwitch != 1)) {
            break label256;
          }
          i1 += 1;
          i2 = i1;
          if (i1 < 50) {
            break label251;
          }
        }
      }
      for (;;)
      {
        if ((i1 < 50) || (SharedPreUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()) != 0)) {
          break label260;
        }
        localObject1 = new RuntimeException("isOverLoadExtensionDataError");
        ((RuntimeException)localObject1).fillInStackTrace();
        QLog.d("Q.contacttab.extension", 1, "isOverLoadExtensionDataError():overload 50 friend extensionInfo data error:", (Throwable)localObject1);
        localObject2 = new HashMap();
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))) {
          ((HashMap)localObject2).put("detailEventUin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        }
        ((HashMap)localObject2).put("detailEventDes", "isOverLoadExtensionDataError():overload 50 friend extensionInfo data error");
        ((HashMap)localObject2).put("stackInfo", QLog.getStackTraceString((Throwable)localObject1));
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "OVERLOAD_EXTENSION_INFO_DATA_ERROR", true, 0L, 0L, (HashMap)localObject2, "", false);
        SharedPreUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1);
        return;
        i2 = i1;
        label251:
        i1 = i2;
        break;
        break label91;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getFriendCount();
  }
  
  public int a(String paramString)
  {
    paramString = b(paramString);
    if ((paramString == null) || (!paramString.isFriend())) {
      return 0;
    }
    return paramString.friendType;
  }
  
  public Card a(String paramString)
  {
    return ((IProfileDataService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IProfileDataService.class, "all")).getProfileCard(paramString, false);
  }
  
  public Card a(String paramString, boolean paramBoolean)
  {
    return ((IProfileDataService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IProfileDataService.class, "all")).getProfileCard(paramString, paramBoolean);
  }
  
  public DateNickNameInfo a(String paramString)
  {
    if (!Friends.isValidUin(paramString)) {
      return null;
    }
    if (!this.jdField_g_of_type_Boolean) {
      ThreadManager.postImmediately(new FriendsManager.5(this), null, false);
    }
    return (DateNickNameInfo)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
  }
  
  public ExtensionInfo a(String paramString)
  {
    return a(paramString, true);
  }
  
  public ExtensionInfo a(String paramString, boolean paramBoolean)
  {
    return this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendExtensionService.getExtensionInfo(paramString, paramBoolean);
  }
  
  public Friends a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getFriend(paramString);
  }
  
  public Friends a(String paramString1, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getFriend(paramString1, true, true, true);
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1.name = paramString2;
      paramString1.datetime = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.saveFriendCache(paramString1);
    }
    return paramString1;
  }
  
  public Groups a(String paramString)
  {
    try
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getGroup(Integer.parseInt(paramString), true);
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public KplCard a(String paramString)
  {
    long l1;
    if (StatisticCollector.getSqliteSwitchBySample(7))
    {
      l1 = SystemClock.uptimeMillis();
      DetectContactDelete.a();
    }
    for (;;)
    {
      paramString = (KplCard)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(KplCard.class, paramString);
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
    NoC2CExtensionInfo localNoC2CExtensionInfo = (NoC2CExtensionInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
    ??? = localNoC2CExtensionInfo;
    if (localNoC2CExtensionInfo == null)
    {
      ??? = localNoC2CExtensionInfo;
      if (paramBoolean)
      {
        ??? = localNoC2CExtensionInfo;
        if (!this.jdField_d_of_type_Boolean)
        {
          paramString = (NoC2CExtensionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(NoC2CExtensionInfo.class, "type=? and uin=?", new String[] { String.valueOf(paramInt), paramString });
          ??? = paramString;
          if (paramString != null) {
            synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
            {
              this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString);
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
      if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) {}
      synchronized (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        localObject1 = (SpecialCareInfo)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
  }
  
  public AddFrdStateMng a()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqRelationxAddFrdAddFrdStateMng.jdField_a_of_type_Boolean) {
      ThreadManager.excute(new FriendsManager.6(this), 16, null, true);
    }
    return this.jdField_a_of_type_ComTencentMobileqqRelationxAddFrdAddFrdStateMng;
  }
  
  public String a(int paramInt)
  {
    return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramInt));
  }
  
  public String a(String paramString)
  {
    Friends localFriends = e(paramString);
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
  
  public ArrayList<Friends> a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getAllFriends();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      ArrayList localArrayList = new ArrayList(10);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Friends localFriends = (Friends)((Iterator)localObject).next();
        if (localFriends.isShield()) {
          localArrayList.add(localFriends);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public ArrayList<Friends> a(int paramInt)
  {
    return (ArrayList)this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getFriendList(paramInt);
  }
  
  public ArrayList<Friends> a(String paramString)
  {
    try
    {
      paramString = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getFriendList(Integer.parseInt(paramString));
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return new ArrayList();
  }
  
  @UiThread
  public List<Groups> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.asyncGetGroupList(new FriendsManager.3(this));
  }
  
  public ConcurrentHashMap<String, ArrayList<Entity>> a()
  {
    return a(false);
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "init begin");
    }
    c();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "init end");
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.moveGroup(paramInt, 0);
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
        localFriends = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getFriend(String.valueOf(paramLong));
      } while (localFriends == null);
      i1 = ContactUtils.a(localFriends.detalStatusFlag, localFriends.iTermType);
    } while ((i1 != 0) && (i1 != 6));
    localFriends.detalStatusFlag = 10;
  }
  
  public void a(ExtensionInfo paramExtensionInfo)
  {
    a(paramExtensionInfo);
    this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendExtensionService.saveExtensionInfo(paramExtensionInfo);
    j();
  }
  
  public void a(Friends paramFriends)
  {
    this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.saveFriend(paramFriends);
  }
  
  public void a(Groups paramGroups)
  {
    this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.saveGroup(paramGroups);
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    if (paramNearbyPeopleCard != null) {}
    for (;;)
    {
      try
      {
        if ((!TextUtils.isEmpty(paramNearbyPeopleCard.uin)) && (!TextUtils.isEmpty(paramNearbyPeopleCard.nickname)))
        {
          long l1 = paramNearbyPeopleCard.lastUpdateNickTime;
          if (l1 > 0L) {}
        }
        else
        {
          return;
        }
        DateNickNameInfo localDateNickNameInfo = new DateNickNameInfo(paramNearbyPeopleCard.nickname, paramNearbyPeopleCard.lastUpdateNickTime);
        if (paramNearbyPeopleCard.tinyId > 0L)
        {
          paramNearbyPeopleCard = String.valueOf(paramNearbyPeopleCard.tinyId);
          this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramNearbyPeopleCard, localDateNickNameInfo);
        }
        else
        {
          paramNearbyPeopleCard = paramNearbyPeopleCard.uin;
        }
      }
      finally {}
    }
  }
  
  public void a(NoC2CExtensionInfo paramNoC2CExtensionInfo, boolean paramBoolean)
  {
    if ((paramNoC2CExtensionInfo == null) || (paramNoC2CExtensionInfo.uin == null)) {}
    for (;;)
    {
      return;
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        continue;
      }
      synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        String str = NoC2CExtensionInfo.getNoC2Ckey(paramNoC2CExtensionInfo.type, paramNoC2CExtensionInfo.uin);
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramNoC2CExtensionInfo);
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
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) {}
    synchronized (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramSpecialCareInfo.uin, paramSpecialCareInfo);
      a(paramSpecialCareInfo);
      return;
    }
  }
  
  public void a(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (localSharedPreferences.getInt("hotDisableInteractive", 1) == 1) {
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
        this.h = Integer.valueOf(arrayOfString[5]).intValue();
        this.i = Integer.valueOf(arrayOfString[6]).intValue();
        this.j = Integer.valueOf(arrayOfString[7]).intValue();
        this.k = Integer.valueOf(arrayOfString[8]).intValue();
        if (arrayOfString.length < 11) {}
      }
      catch (Exception localException3)
      {
        try
        {
          this.jdField_c_of_type_Int = Integer.valueOf(arrayOfString[9]).intValue();
          this.jdField_d_of_type_Int = Integer.valueOf(arrayOfString[10]).intValue();
          if (arrayOfString.length < 13) {}
        }
        catch (Exception localException3)
        {
          try
          {
            do
            {
              for (;;)
              {
                this.l = Integer.valueOf(arrayOfString[11]).intValue();
                this.m = Integer.valueOf(arrayOfString[12]).intValue();
                HotReactiveHelper.a(localSharedPreferences, this);
                return;
                this.jdField_b_of_type_Boolean = false;
                break;
                localException2 = localException2;
                if (QLog.isColorLevel()) {
                  QLog.e("Q.contacttab.", 2, paramString, localException2);
                }
              }
              localException3 = localException3;
            } while (!QLog.isColorLevel());
            QLog.e("Q.contacttab.", 2, paramString, localException3);
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("Q.contacttab.", 2, paramString, localException1);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "setFriendGroup| uin: " + paramString + ", groupId: " + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.moveFriendToNewGroup(paramString, paramInt);
  }
  
  public void a(String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    Friends localFriends;
    if (paramGetOnlineInfoResp != null)
    {
      localFriends = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getFriend(paramString);
      if (localFriends != null) {
        break label20;
      }
    }
    label20:
    do
    {
      for (;;)
      {
        return;
        localFriends.detalStatusFlag = ((byte)(int)paramGetOnlineInfoResp.dwStatus);
        localFriends.iTermType = ((int)paramGetOnlineInfoResp.iTermType);
        localFriends.abilityBits = paramGetOnlineInfoResp.uAbiFlag;
        localFriends.eNetwork = paramGetOnlineInfoResp.eNetworkType;
        localFriends.netTypeIconId = paramGetOnlineInfoResp.eIconType;
        localFriends.strTermDesc = paramGetOnlineInfoResp.strTermDesc;
        localFriends.uExtOnlineStatus = paramGetOnlineInfoResp.uExtOnlineStatus;
        localFriends.iBatteryStatus = paramGetOnlineInfoResp.iBatteryStatus;
        OnlineMusicStatusManager.a(localFriends, paramGetOnlineInfoResp.vecMusicInfo, "AIO");
        OnlineStatusUtil.a(localFriends, paramGetOnlineInfoResp.vecExtOnlineBusinessInfo, "AIO");
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.", 2, new Object[] { "updateOnlineStatus uin:", paramString, " extOnline:", Long.valueOf(paramGetOnlineInfoResp.uExtOnlineStatus), " battery:", Integer.valueOf(paramGetOnlineInfoResp.iBatteryStatus) });
        }
        CustomOnlineStatusPb.CustomOnlineStatusMsg localCustomOnlineStatusMsg = new CustomOnlineStatusPb.CustomOnlineStatusMsg();
        try
        {
          CustomOnlineStatusManager.a().a(paramString);
          localCustomOnlineStatusMsg.mergeFrom(paramGetOnlineInfoResp.strCustomOnlineStatusDesc.getBytes());
          localFriends.customOnlineStatusType = CustomOnlineStatusManager.Utils.b(localCustomOnlineStatusMsg);
          localFriends.customOnlineStatus = CustomOnlineStatusManager.Utils.a(localCustomOnlineStatusMsg);
          localFriends.customModel = CustomOnlineStatusManager.Utils.b(localCustomOnlineStatusMsg);
          if (QLog.isDevelopLevel())
          {
            QLog.d("CustomOnlineStatusManager", 4, "updateOnlineStatus : customOnlineStatusType = " + localFriends.customOnlineStatusType + " customOnlineStatus = " + localFriends.customOnlineStatus);
            return;
          }
        }
        catch (Exception paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("CustomOnlineStatusManager", 2, paramString, new Object[0]);
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getFriend(paramString1, true, true, true);
    paramString1.name = paramString2;
    paramString1.datetime = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.saveFriend(paramString1);
  }
  
  public void a(String paramString1, String paramString2, byte paramByte)
  {
    NearbyPeopleCard localNearbyPeopleCard2 = (NearbyPeopleCard)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { paramString1 });
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
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getFriend(paramString1, true, true, true);
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
      this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.saveFriend(paramString1);
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
    int i1 = 1;
    if (paramBoolean) {
      a().edit().putLong(paramString, System.currentTimeMillis()).commit();
    }
    for (;;)
    {
      if (i1 != 0) {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(104, paramBoolean, paramString);
      }
      return;
      if (a().contains(paramString)) {
        a().edit().remove(paramString).commit();
      } else {
        i1 = 0;
      }
    }
  }
  
  public void a(ArrayList<SimpleOnlineFriendInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      Object localObject = new StringBuilder(100);
      ((StringBuilder)localObject).append("updateOnlineStatus size:").append(paramArrayList.size()).append("\n");
      HashMap localHashMap = new HashMap(paramArrayList.size());
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        SimpleOnlineFriendInfo localSimpleOnlineFriendInfo = (SimpleOnlineFriendInfo)paramArrayList.next();
        String str = String.valueOf(localSimpleOnlineFriendInfo.friendUin);
        Friends localFriends = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getFriend(str);
        if (localFriends != null)
        {
          localFriends.detalStatusFlag = localSimpleOnlineFriendInfo.detalStatusFlag;
          localFriends.iTermType = localSimpleOnlineFriendInfo.iTermType;
          localFriends.abilityBits = localSimpleOnlineFriendInfo.uAbiFlag;
          localFriends.eNetwork = localSimpleOnlineFriendInfo.eNetworkType;
          localFriends.netTypeIconId = localSimpleOnlineFriendInfo.eIconType;
          localFriends.strTermDesc = localSimpleOnlineFriendInfo.strTermDesc;
          localFriends.iBatteryStatus = localSimpleOnlineFriendInfo.iBatteryStatus;
          localFriends.uExtOnlineStatus = localSimpleOnlineFriendInfo.uExtOnlineStatus;
          ((StringBuilder)localObject).append("uin:").append(str).append(" battery:").append(localSimpleOnlineFriendInfo.iBatteryStatus).append(" extOnline:").append(localSimpleOnlineFriendInfo.uExtOnlineStatus).append("\n");
          OnlineMusicStatusManager.a(localFriends, localSimpleOnlineFriendInfo.vecMusicInfo, "SimpleOnlie");
          OnlineStatusUtil.a(localFriends, localSimpleOnlineFriendInfo.vecExtOnlineBusinessInfo, "SimpleOnlie");
          localHashMap.put(str, Boolean.TRUE);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, ((StringBuilder)localObject).toString());
      }
      paramArrayList = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getAllFriends();
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localObject = (Friends)paramArrayList.next();
          if (((Boolean)localHashMap.get(((Friends)localObject).uin) == null) && (((Friends)localObject).isFriend()))
          {
            ((Friends)localObject).detalStatusFlag = 20;
            ((Friends)localObject).abilityBits = 0L;
            ((Friends)localObject).eNetwork = 0;
          }
        }
      }
    }
  }
  
  public void a(@NonNull ArrayList<Friends> paramArrayList, int paramInt)
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
    try
    {
      ((EntityTransaction)localObject1).begin();
      if (paramInt == 0)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getAllFriends().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localFriends = (Friends)((Iterator)localObject2).next();
          if (localFriends.gathtertype == 1)
          {
            localFriends.gathtertype = 0;
            a(localFriends);
            if (this.jdField_a_of_type_JavaUtilArrayList == null) {
              this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            }
            this.jdField_a_of_type_JavaUtilArrayList.add(localFriends.uin);
          }
        }
      }
    }
    catch (Exception paramArrayList)
    {
      QLog.e("Q.contacttab.", 1, "saveGatherList", paramArrayList);
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = (Friends)paramArrayList.next();
        localFriends = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getFriend(((Friends)localObject2).uin);
        if (localFriends != null)
        {
          localFriends.gathtertype = 1;
          localFriends.age = ((Friends)localObject2).age;
          localFriends.smartRemark = ((Friends)localObject2).smartRemark;
          localFriends.gender = ((Friends)localObject2).gender;
          localFriends.recommReason = ((Friends)localObject2).recommReason;
          a(localFriends);
          if (this.jdField_b_of_type_JavaUtilArrayList == null) {
            this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
          }
          this.jdField_b_of_type_JavaUtilArrayList.add(localFriends.uin);
        }
      }
    }
    finally
    {
      ((EntityTransaction)localObject1).end();
    }
    ((EntityTransaction)localObject1).end();
  }
  
  public void a(List<String> paramList)
  {
    TraceUtils.traceBegin("queryFriends_" + paramList.size());
    paramList = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.preloadPartFriendCache(paramList);
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Friends localFriends = (Friends)paramList.next();
        QidianManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFriends);
      }
    }
    TraceUtils.traceEnd();
  }
  
  public void a(List<SpecialCareInfo> paramList, long paramLong, boolean paramBoolean)
  {
    int i3 = 0;
    if (paramList != null) {}
    for (int i1 = paramList.size();; i1 = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "syncSpecialCareInfos: " + i1 + ", " + paramLong + ", " + paramBoolean);
      }
      int i2;
      if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null)
      {
        localObject = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
        i2 = 0;
        for (;;)
        {
          if (i2 < i1) {}
          Iterator localIterator;
          try
          {
            this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(((SpecialCareInfo)paramList.get(i2)).uin, paramList.get(i2));
            i2 += 1;
          }
          finally {}
        }
        if (paramBoolean)
        {
          localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
          while (localIterator.hasNext()) {
            if (((SpecialCareInfo)((Map.Entry)localIterator.next()).getValue()).dateTime < paramLong) {
              localIterator.remove();
            }
          }
        }
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
      try
      {
        ((EntityTransaction)localObject).begin();
        i2 = i3;
        while (i2 < i1)
        {
          a((Entity)paramList.get(i2));
          i2 += 1;
        }
        if (paramBoolean)
        {
          paramList = ((SpecialCareInfo)SpecialCareInfo.class.newInstance()).getTableName();
          i1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.delete(paramList, "dateTime<" + paramLong, null);
          if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.", 2, "syncSpecialCareInfos delete from table " + paramList + " ret = " + i1);
          }
        }
        ((EntityTransaction)localObject).commit();
        return;
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        return;
      }
      finally
      {
        ((EntityTransaction)localObject).end();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("show_vip_red_name", paramBoolean).commit();
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11)
  {
    this.jdField_e_of_type_Boolean = paramBoolean1;
    this.jdField_f_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_e_of_type_Int = paramInt3;
    this.jdField_f_of_type_Int = paramInt4;
    this.jdField_g_of_type_Int = paramInt5;
    this.h = paramInt6;
    this.i = paramInt7;
    this.j = paramInt8;
    this.k = paramInt11;
    this.l = paramInt9;
    this.m = paramInt10;
  }
  
  public boolean a()
  {
    boolean bool = b();
    a();
    this.jdField_e_of_type_Boolean = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    this.jdField_f_of_type_Boolean = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1);
    a(SharedPreUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()));
    return bool;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramInt != 0) || (this.jdField_e_of_type_Boolean))
    {
      bool1 = bool2;
      if (paramInt == 1)
      {
        bool1 = bool2;
        if (this.jdField_f_of_type_Boolean) {}
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotFriend_Q.contacttab.", 2, "isEnableChatDays|config close, type=" + paramInt);
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public boolean a(Card paramCard)
  {
    return ((IProfileDataService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IProfileDataService.class, "all")).saveProfileCard(paramCard);
  }
  
  public boolean a(ExtensionInfo paramExtensionInfo)
  {
    if (paramExtensionInfo == null) {}
    ExtensionInfo localExtensionInfo;
    do
    {
      do
      {
        return false;
      } while (paramExtensionInfo.hiddenChatSwitch != 1);
      localExtensionInfo = a(paramExtensionInfo.uin, false);
    } while ((localExtensionInfo != null) && (paramExtensionInfo.hiddenChatSwitch == localExtensionInfo.hiddenChatSwitch));
    RuntimeException localRuntimeException = new RuntimeException("isMaybeSingleExtensionDataError");
    localRuntimeException.fillInStackTrace();
    StringBuilder localStringBuilder = new StringBuilder().append("uin:").append(MobileQQ.getShortUinStr(paramExtensionInfo.uin)).append("extensionInfo new.hiddenChatSwitch: ").append(paramExtensionInfo.hiddenChatSwitch).append(", old.hiddenChatSwitch: ");
    if (localExtensionInfo == null) {}
    for (paramExtensionInfo = "null";; paramExtensionInfo = Integer.valueOf(localExtensionInfo.hiddenChatSwitch))
    {
      QLog.d("Q.contacttab.extension", 1, paramExtensionInfo + ", isMaybeExtensionDataError():", localRuntimeException);
      return true;
    }
  }
  
  public boolean a(Friends paramFriends)
  {
    return this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.saveFriend(paramFriends);
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen()) {
      if (paramEntity.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramEntity);
      }
    }
    QLog.d("Q.contacttab.friend", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "initBlackList begin");
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(Groups.class, false, "group_id=?", new String[] { "-1002" }, null, null, null, null);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Friends localFriends = (Friends)((Iterator)localObject).next();
          this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(localFriends.uin, "");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "initBlackList end, size=" + this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      }
    }
    return this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
  }
  
  protected boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    i1 = 0;
    i2 = 0;
    int i4 = 0;
    byte b1 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.group", 2, "addFriendToFriendList" + paramString + ", " + paramInt + ", " + paramBoolean);
    }
    Object localObject2 = null;
    localObject4 = null;
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
        localObject4 = localObject1;
        localObject2 = localObject1;
        ((EntityTransaction)localObject1).begin();
        localObject4 = localObject1;
        localObject2 = localObject1;
        localFriends = d(paramString);
        localObject4 = localObject1;
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject4 = localObject1;
          localObject2 = localObject1;
          QLog.d("FriendListHandler", 2, "FriendsManager addFriendToFriendList f.uin = " + paramString + " ; gatherType = " + localFriends.gathtertype);
        }
        localObject4 = localObject1;
        localObject2 = localObject1;
        if (a(paramString))
        {
          localObject4 = localObject1;
          localObject2 = localObject1;
          c(paramString);
        }
        localObject4 = localObject1;
        localObject2 = localObject1;
        if (localFriends.groupid == -1)
        {
          localObject4 = localObject1;
          localObject2 = localObject1;
          localFriends.groupid = paramInt;
          i3 = -1;
          bool1 = true;
          localObject2 = localObject1;
          i2 = i4;
        }
      }
      catch (Exception localException1)
      {
        Friends localFriends;
        int i3;
        bool1 = false;
        paramInt = i2;
        Object localObject1 = localObject4;
        localObject4 = localException1;
        localObject3 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject3 = localObject1;
          QLog.e("Q.contacttab.group", 2, "addFriendToFriendList ex", (Throwable)localObject4);
        }
        if (localObject1 == null) {
          break label725;
        }
        ((EntityTransaction)localObject1).end();
        bool2 = bool1;
        continue;
      }
      finally
      {
        Object localObject3;
        if (localObject3 != null) {
          localObject3.end();
        }
      }
      try
      {
        localFriends.datetime = System.currentTimeMillis();
        if (paramBoolean)
        {
          localObject2 = localObject1;
          i2 = i4;
          i1 = localFriends.gathtertype;
          if (i1 == 1) {
            continue;
          }
          i1 = 1;
          localObject2 = localObject1;
        }
      }
      catch (Exception localException2)
      {
        paramInt = i2;
        continue;
      }
      try
      {
        localFriends.gathtertype = 1;
        localObject2 = localObject1;
        localFriends.recommReason = HardCodeUtil.a(2131704960);
        localObject2 = localObject1;
        localObject4 = a(localFriends.uin);
        if (localObject4 != null)
        {
          localObject2 = localObject1;
          if (((Card)localObject4).shGender != 0) {
            continue;
          }
          b1 = 1;
          localObject2 = localObject1;
          localFriends.gender = b1;
          localObject2 = localObject1;
          localFriends.age = ((Card)localObject4).age;
        }
        localObject2 = localObject1;
        i2 = i1;
        a(localFriends);
        localObject2 = localObject1;
        i2 = i1;
        localObject4 = a(String.valueOf(paramInt));
        if (localObject4 != null)
        {
          localObject2 = localObject1;
          i2 = i1;
          ((Groups)localObject4).group_friend_count += 1;
          localObject2 = localObject1;
          i2 = i1;
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update((Entity)localObject4);
        }
        if ((!bool1) && (i3 >= 0) && (i3 != paramInt))
        {
          localObject2 = localObject1;
          i2 = i1;
          localObject4 = a(String.valueOf(i3));
          if (localObject4 != null)
          {
            localObject2 = localObject1;
            i2 = i1;
            ((Groups)localObject4).group_friend_count -= 1;
            localObject2 = localObject1;
            i2 = i1;
            a((Entity)localObject4);
          }
        }
        localObject2 = localObject1;
        i2 = i1;
        ((EntityTransaction)localObject1).commit();
        paramInt = i1;
        bool2 = bool1;
        if (localObject1 != null)
        {
          ((EntityTransaction)localObject1).end();
          bool2 = bool1;
          paramInt = i1;
        }
      }
      catch (Exception localException3)
      {
        paramInt = i1;
        continue;
        bool2 = bool1;
        continue;
      }
      if ((paramBoolean) && (paramInt != 0)) {
        GatherContactsTipsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      }
      return bool2;
      localObject4 = localObject1;
      localObject2 = localObject1;
      i3 = localFriends.groupid;
      localObject4 = localObject1;
      localObject2 = localObject1;
      localFriends.groupid = paramInt;
      bool1 = false;
      continue;
      i1 = 0;
      continue;
      localObject2 = localObject1;
      i2 = ((Card)localObject4).shGender;
      if (i2 == 1) {
        b1 = 2;
      }
    }
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, false);
  }
  
  public boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
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
    if (paramBoolean1) {}
    for (long l1 = 259200000L;; l1 = 500654080L)
    {
      if (paramBoolean2) {
        l1 = 86400000L;
      }
      if ((l2 <= 0L) || (l2 >= l1)) {
        break;
      }
      return true;
    }
    a().edit().remove(paramString).commit();
    return false;
  }
  
  public boolean a(List<ExtensionInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return false;
    }
    RuntimeException localRuntimeException = new RuntimeException("isMaybeListExtensionDataError");
    localRuntimeException.fillInStackTrace();
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ExtensionInfo localExtensionInfo = (ExtensionInfo)((Iterator)localObject).next();
      if (localExtensionInfo.hiddenChatSwitch == 1)
      {
        paramList = a(localExtensionInfo.uin, false);
        if ((paramList == null) || (localExtensionInfo.hiddenChatSwitch != paramList.hiddenChatSwitch))
        {
          localObject = new StringBuilder().append("uin:").append(MobileQQ.getShortUinStr(localExtensionInfo.uin)).append("extensionInfo new.hiddenChatSwitch: ").append(localExtensionInfo.hiddenChatSwitch).append(", old.hiddenChatSwitch: ");
          if (paramList == null) {}
          for (paramList = "null";; paramList = Integer.valueOf(paramList.hiddenChatSwitch))
          {
            QLog.d("Q.contacttab.extension", 1, paramList + ", isMaybeListExtensionDataError():", localRuntimeException);
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = this.jdField_b_of_type_Boolean;
    if (this.q == -1)
    {
      if (!paramBoolean) {
        break label109;
      }
      TempGetProfileDetailProcessor localTempGetProfileDetailProcessor = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TempGetProfileDetailProcessor.class);
      if (localTempGetProfileDetailProcessor != null) {
        localTempGetProfileDetailProcessor.getCalReactiveSwitch();
      }
      paramBoolean = bool1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendReactive", 2, "getEnableReactive disableReactive" + paramBoolean + "IsDisableInteractive=" + this.q);
      }
      return paramBoolean;
      paramBoolean = bool2;
      if (this.q != 1)
      {
        paramBoolean = false;
        continue;
        label109:
        paramBoolean = bool1;
      }
    }
  }
  
  public boolean a(Friends[] paramArrayOfFriends, int paramInt)
  {
    if ((paramArrayOfFriends == null) || (paramArrayOfFriends.length == 0)) {
      return true;
    }
    paramArrayOfFriends = new ArrayList(Arrays.asList(paramArrayOfFriends));
    return this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.saveFriendList(paramArrayOfFriends);
  }
  
  public int b()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getAllFriends(true);
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int b(String paramString)
  {
    paramString = e(paramString);
    if (paramString != null) {
      return paramString.detalStatusFlag;
    }
    return 10;
  }
  
  public Card b(String paramString)
  {
    return ((IProfileDataService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IProfileDataService.class, "all")).getProfileCard(paramString, true);
  }
  
  public Friends b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getFriend(paramString, true);
  }
  
  public Friends b(String paramString1, String paramString2)
  {
    Friends localFriends = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getFriend(paramString1, true, true, true);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    if (!paramString1.equals(localFriends.remark))
    {
      localFriends.remark = paramString1;
      localFriends.datetime = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.saveFriend(localFriends);
    }
    return localFriends;
  }
  
  public ArrayList<Entity> b()
  {
    new ConcurrentHashMap(4);
    ConcurrentHashMap localConcurrentHashMap = a(true);
    ArrayList localArrayList = new ArrayList(16);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getGroupList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        List localList = (List)localConcurrentHashMap.get(String.valueOf(((Groups)((Iterator)localObject).next()).group_id));
        if (localList != null) {
          localArrayList.addAll(localList);
        }
      }
    }
    return localArrayList;
  }
  
  public List<Groups> b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getGroupList();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initExtensionInfoCache begin");
    }
    if ((this.jdField_d_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendExtensionService.initCache();
    i();
    try
    {
      h();
      label48:
      this.jdField_d_of_type_Boolean = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label48;
    }
  }
  
  public void b(String paramString)
  {
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramString)) && (paramString.length() > 3)) {
      QLog.d("Q.contacttab.", 2, "add friend to black list " + paramString.substring(0, 2));
    }
    if (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, "");
    }
    this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.moveFriendToNewGroup(paramString, -1002);
  }
  
  protected void b(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString1 == null)) {
      return;
    }
    Friends localFriends = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getFriend(paramString1, true, true, true);
    localFriends.alias = paramString2;
    localFriends.datetime = System.currentTimeMillis();
    if (paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramString1, paramString2);
    }
    this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.saveFriend(localFriends);
  }
  
  public void b(List<ExtensionInfo> paramList)
  {
    a(paramList);
    this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendExtensionService.saveExtensionInfoList(paramList);
    j();
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.initFriendCache();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getAllFriends();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Friends localFriends = (Friends)((Iterator)localObject).next();
        QidianManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFriends);
      }
    }
    return true;
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.isFriend(paramString);
  }
  
  public int c()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getAllFriends().iterator();
    int i1 = 0;
    if (localIterator.hasNext())
    {
      if (((Friends)localIterator.next()).gathtertype != 1) {
        break label83;
      }
      i1 += 1;
    }
    label83:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, "getGatheredFriendsCount| gatherFriendCount: " + i1);
      }
      return i1;
    }
  }
  
  public Card c(String paramString)
  {
    return ((IProfileDataService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IProfileDataService.class, "all")).getProfileCardFromCache(paramString);
  }
  
  public Friends c(String paramString)
  {
    return a(paramString);
  }
  
  public List<Friends> c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getAllFriends();
  }
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initGroupList begin");
    }
    this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.initGroupCache();
  }
  
  public void c(String paramString)
  {
    if (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.moveFriendToNewGroup(paramString, -1);
  }
  
  /* Error */
  public void c(List<SpecialCareInfo> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 224 1 0
    //   10: ifne +20 -> 30
    //   13: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +13 -> 29
    //   19: ldc_w 334
    //   22: iconst_2
    //   23: ldc_w 1376
    //   26: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: return
    //   30: aload_1
    //   31: invokeinterface 224 1 0
    //   36: iconst_1
    //   37: if_icmpne +18 -> 55
    //   40: aload_0
    //   41: aload_1
    //   42: iconst_0
    //   43: invokeinterface 1096 2 0
    //   48: checkcast 647	com/tencent/mobileqq/data/SpecialCareInfo
    //   51: invokevirtual 1378	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/SpecialCareInfo;)V
    //   54: return
    //   55: aload_0
    //   56: getfield 77	com/tencent/mobileqq/app/FriendsManager:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   59: ifnull +73 -> 132
    //   62: aload_0
    //   63: getfield 77	com/tencent/mobileqq/app/FriendsManager:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   66: astore_2
    //   67: aload_2
    //   68: monitorenter
    //   69: aload_1
    //   70: invokeinterface 228 1 0
    //   75: astore_3
    //   76: aload_3
    //   77: invokeinterface 233 1 0
    //   82: ifeq +48 -> 130
    //   85: aload_3
    //   86: invokeinterface 237 1 0
    //   91: checkcast 647	com/tencent/mobileqq/data/SpecialCareInfo
    //   94: astore 4
    //   96: aload 4
    //   98: getfield 762	com/tencent/mobileqq/data/SpecialCareInfo:uin	Ljava/lang/String;
    //   101: invokestatic 401	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   104: ifne -28 -> 76
    //   107: aload_0
    //   108: getfield 77	com/tencent/mobileqq/app/FriendsManager:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   111: aload 4
    //   113: getfield 762	com/tencent/mobileqq/data/SpecialCareInfo:uin	Ljava/lang/String;
    //   116: aload 4
    //   118: invokevirtual 274	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
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
    //   133: getfield 155	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   136: invokevirtual 654	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   139: astore_2
    //   140: aload_2
    //   141: invokevirtual 1048	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   144: aload_1
    //   145: invokeinterface 228 1 0
    //   150: astore_1
    //   151: aload_1
    //   152: invokeinterface 233 1 0
    //   157: ifeq +110 -> 267
    //   160: aload_1
    //   161: invokeinterface 237 1 0
    //   166: checkcast 647	com/tencent/mobileqq/data/SpecialCareInfo
    //   169: astore_3
    //   170: aload_3
    //   171: getfield 762	com/tencent/mobileqq/data/SpecialCareInfo:uin	Ljava/lang/String;
    //   174: invokestatic 401	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   177: ifne -26 -> 151
    //   180: aload_0
    //   181: aload_3
    //   182: invokevirtual 760	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   185: pop
    //   186: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq -38 -> 151
    //   192: ldc_w 334
    //   195: iconst_2
    //   196: new 178	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 1380
    //   206: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_3
    //   210: invokevirtual 767	com/tencent/mobileqq/data/SpecialCareInfo:toString	()Ljava/lang/String;
    //   213: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: goto -71 -> 151
    //   225: astore_1
    //   226: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +33 -> 262
    //   232: ldc_w 494
    //   235: iconst_2
    //   236: new 178	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   243: ldc_w 1382
    //   246: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_1
    //   250: invokevirtual 1385	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   253: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: aload_2
    //   263: invokevirtual 1057	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   266: return
    //   267: aload_2
    //   268: invokevirtual 1067	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   271: aload_2
    //   272: invokevirtual 1057	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   275: return
    //   276: astore_1
    //   277: aload_2
    //   278: invokevirtual 1057	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   281: aload_1
    //   282: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	FriendsManager
    //   0	283	1	paramList	List<SpecialCareInfo>
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
    boolean bool2 = false;
    List localList1 = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getAllFriends();
    List localList2 = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getGroupList();
    if (localList1 != null) {}
    for (int i1 = localList1.size();; i1 = 0)
    {
      boolean bool1 = bool2;
      if (localList2 != null) {
        if (i1 <= 0)
        {
          bool1 = bool2;
          if (localList2.size() <= 0) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  public boolean c(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.isFriend(paramString, false);
  }
  
  public int d()
  {
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).addAll(this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getAllFriends());
    StringBuilder localStringBuilder = new StringBuilder();
    localObject1 = ((ArrayList)localObject1).iterator();
    int i1;
    for (int i2 = 0; ((Iterator)localObject1).hasNext(); i2 = i1)
    {
      Object localObject2 = (Friends)((Iterator)localObject1).next();
      i1 = i2;
      if (((Friends)localObject2).isFriend())
      {
        localObject2 = a(((Friends)localObject2).uin);
        i1 = i2;
        if (localObject2 != null)
        {
          i1 = i2;
          if (IntimateUtil.a(((ExtensionInfo)localObject2).intimate_type))
          {
            i2 += 1;
            i1 = i2;
            if (QLog.isColorLevel())
            {
              localStringBuilder.append("\nuin:").append(((ExtensionInfo)localObject2).uin).append(" type:").append(((ExtensionInfo)localObject2).intimate_type).append(" level:").append(((ExtensionInfo)localObject2).intimate_level);
              i1 = i2;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("\ncount:").append(i2);
      QLog.d("Q.contacttab.", 2, "getBindIntimateRelationshipFriendCount " + localStringBuilder.toString());
    }
    return i2;
  }
  
  public Friends d(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getFriend(paramString, true, true, true);
  }
  
  public List<Groups> d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getGroupList();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initSpecialCareInfoCache begin");
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      Object localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(SpecialCareInfo.class, false, "globalSwitch!=?", new String[] { "0" }, null, null, null, null);
      if (localObject1 != null) {
        synchronized (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap)
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            SpecialCareInfo localSpecialCareInfo = (SpecialCareInfo)((Iterator)localObject1).next();
            if ((localSpecialCareInfo != null) && (localSpecialCareInfo.uin != null)) {
              this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(localSpecialCareInfo.uin, localSpecialCareInfo);
            }
          }
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initSpecialCareInfoCache end: " + this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size());
    }
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.deleteFriend(paramString);
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
      ExtensionMutualMarkData.c(paramString);
      a(paramString);
    }
  }
  
  /* Error */
  public void d(List<String> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 224 1 0
    //   10: ifgt +4 -> 14
    //   13: return
    //   14: new 269	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 270	java/util/ArrayList:<init>	()V
    //   21: astore_3
    //   22: aload_0
    //   23: getfield 155	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   26: invokevirtual 654	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 1048	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   34: aload_1
    //   35: invokeinterface 228 1 0
    //   40: astore_1
    //   41: aload_1
    //   42: invokeinterface 233 1 0
    //   47: ifeq +81 -> 128
    //   50: aload_1
    //   51: invokeinterface 237 1 0
    //   56: checkcast 249	java/lang/String
    //   59: astore 4
    //   61: aload_0
    //   62: getfield 167	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService	Lcom/tencent/mobileqq/friend/api/IFriendDataService;
    //   65: aload 4
    //   67: invokeinterface 560 2 0
    //   72: astore 5
    //   74: aload 5
    //   76: ifnull -35 -> 41
    //   79: aload 5
    //   81: getfield 243	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   84: ifeq +10 -> 94
    //   87: aload_3
    //   88: aload 4
    //   90: invokevirtual 298	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   93: pop
    //   94: aload 5
    //   96: iconst_0
    //   97: putfield 243	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   100: aload_0
    //   101: aload 5
    //   103: invokevirtual 1050	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   106: pop
    //   107: goto -66 -> 41
    //   110: astore_1
    //   111: aload_1
    //   112: invokevirtual 1128	java/lang/Exception:printStackTrace	()V
    //   115: aload_2
    //   116: invokevirtual 1057	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   119: aload_0
    //   120: getfield 147	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   123: aload_3
    //   124: invokestatic 1445	com/tencent/mobileqq/activity/aio/tips/GatherContactsTipsHelper:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;)V
    //   127: return
    //   128: aload_2
    //   129: invokevirtual 1067	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   132: aload_2
    //   133: invokevirtual 1057	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   136: goto -17 -> 119
    //   139: astore_1
    //   140: aload_2
    //   141: invokevirtual 1057	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	FriendsManager
    //   0	146	1	paramList	List<String>
    //   29	112	2	localEntityTransaction	EntityTransaction
    //   21	103	3	localArrayList	ArrayList
    //   59	30	4	str	String
    //   72	30	5	localFriends	Friends
    // Exception table:
    //   from	to	target	type
    //   30	41	110	java/lang/Exception
    //   41	74	110	java/lang/Exception
    //   79	94	110	java/lang/Exception
    //   94	107	110	java/lang/Exception
    //   128	132	110	java/lang/Exception
    //   30	41	139	finally
    //   41	74	139	finally
    //   79	94	139	finally
    //   94	107	139	finally
    //   111	115	139	finally
    //   128	132	139	finally
  }
  
  public boolean d()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean d(String paramString)
  {
    return a(paramString, false);
  }
  
  public Friends e(String paramString)
  {
    if (!f(paramString)) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getFriend(paramString, true, true);
  }
  
  public List<SpecialCareInfo> e()
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, "getSpecailCareInfos isSpecialCareInfoCacheInited is false or specailCareInfoCache is null");
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
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
          ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(NearbyPeopleCard.class, false, "lastUpdateNickTime>?", new String[] { "0" }, null, null, "_id desc", String.valueOf(100));
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
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.drop(NearbyPeopleCard.class.getSimpleName());
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
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) {}
    for (;;)
    {
      synchronized (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        localSpecialCareInfo = (SpecialCareInfo)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        if (localSpecialCareInfo != null) {
          break label147;
        }
        paramString = (SpecialCareInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(SpecialCareInfo.class, paramString);
        if (paramString != null)
        {
          if (!StatisticCollector.getSqliteSwitchBySample(10)) {
            break label142;
          }
          l1 = SystemClock.uptimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(paramString);
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
  
  public void e(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
    for (;;)
    {
      try
      {
        localEntityTransaction.begin();
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          continue;
        }
        localObject = (String)paramList.next();
        localFriends = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getFriend((String)localObject);
        if ((localFriends == null) || ((localFriends.gathtertype != 2) && (localFriends.gathtertype != 0))) {
          continue;
        }
        if (localFriends.gathtertype == 0) {
          localFriends.recommReason = HardCodeUtil.a(2131704959);
        }
        if (localFriends.gathtertype != 1) {
          localArrayList.add(localObject);
        }
        localFriends.gathtertype = 1;
        localObject = a(localFriends.uin);
        if (localObject == null) {
          continue;
        }
        if (((Card)localObject).shGender != 0) {
          continue;
        }
        b1 = 1;
      }
      catch (Exception paramList)
      {
        Object localObject;
        Friends localFriends;
        paramList.printStackTrace();
        localEntityTransaction.end();
        GatherContactsTipsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
        return;
        if (((Card)localObject).shGender != 1) {
          break label242;
        }
        b1 = 2;
        continue;
        localEntityTransaction.commit();
        localEntityTransaction.end();
        continue;
      }
      finally
      {
        localEntityTransaction.end();
      }
      localFriends.gender = b1;
      localFriends.age = ((Card)localObject).age;
      a(localFriends);
      continue;
      label242:
      byte b1 = 0;
    }
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean e(String paramString)
  {
    paramString = e(paramString);
    if (paramString != null) {
      return paramString.isShield();
    }
    return false;
  }
  
  public List<SpecialCareInfo> f()
  {
    List localList = e();
    if (localList != null) {
      Collections.sort(localList, new FriendsManager.4(this));
    }
    return localList;
  }
  
  public void f()
  {
    Iterator localIterator;
    String str;
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(str))) {
          this.jdField_a_of_type_JavaUtilArrayList.remove(str);
        } else {
          GatherContactsTipsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
        }
      }
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        GatherContactsTipsHelper.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_JavaUtilArrayList = null;
  }
  
  public void f(List<cmd0x7c4.RecommendReason> paramList)
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
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("show_vip_red_name", true);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "FriendsManager onDestory");
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendsManager
 * JD-Core Version:    0.7.0.1
 */