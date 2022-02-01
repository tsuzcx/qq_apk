package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.UiThread;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.mobileqq.activity.aio.intimate.IntimateUtil;
import com.tencent.mobileqq.activity.aio.tips.GatherContactsTipsHelper;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareUtil;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
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
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.mutualmark.info.ExtensionMutualMarkData;
import com.tencent.mobileqq.mutualmark.oldlogic.HotReactiveHelper;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.addFrd.AddFrdStateMng;
import com.tencent.mobileqq.statistics.StatisticCollector;
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
  private MQLruCache<String, DateNickNameInfo> A = new MQLruCache(500);
  private ConcurrentHashMap<String, SpecialCareInfo> B = new ConcurrentHashMap();
  private final AddFrdStateMng C = new AddFrdStateMng();
  private boolean D = false;
  private boolean E = false;
  private IFriendDataService F;
  private IFriendExtensionService G;
  private AccountObserver H = new FriendsManager.1(this);
  private ConcurrentHashMap<String, String> I = null;
  private boolean J = false;
  private int K = 0;
  private ArrayList<String> L;
  private ArrayList<String> M;
  public volatile boolean a = false;
  public int b = 3;
  public int c = 30;
  public int d = 7;
  public int e = 30;
  public int f = 3;
  public int g = 30;
  public int h = 3;
  public int i = 30;
  public int j = 3;
  public int k = 30;
  public int l = 5;
  public int m = 7;
  public int n = 30;
  public int o = 7;
  public int p = 30;
  public int q = 6;
  public int r = -1;
  public boolean s = false;
  public boolean t = true;
  ConcurrentHashMap<String, String> u = new ConcurrentHashMap(6);
  private QQAppInterface v;
  private EntityManager w;
  private volatile boolean x = false;
  private AtomicBoolean y = new AtomicBoolean(false);
  private ConcurrentHashMap<String, Entity> z = new QQConcurrentHashMap(1012, 0, 400);
  
  @Deprecated
  public FriendsManager() {}
  
  public FriendsManager(QQAppInterface paramQQAppInterface, EntityManager paramEntityManager)
  {
    this.v = paramQQAppInterface;
    paramQQAppInterface.registObserver(this.H);
    this.w = paramEntityManager;
    B();
    this.F = ((IFriendDataService)paramQQAppInterface.getRuntimeService(IFriendDataService.class, ""));
    this.G = ((IFriendExtensionService)paramQQAppInterface.getRuntimeService(IFriendExtensionService.class, ""));
  }
  
  private void B()
  {
    ThreadManager.executeOnSubThread(new FriendsManager.2(this));
  }
  
  private boolean B(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "isValidUin empty uin");
      }
    }
    else
    {
      if (paramString.length() >= 4) {
        break label71;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isValidUin uin=");
        localStringBuilder.append(paramString);
        QLog.e("Q.contacttab.", 2, localStringBuilder.toString());
      }
    }
    return false;
    label71:
    return true;
  }
  
  private void C()
  {
    MessageNotificationSettingManager localMessageNotificationSettingManager = MessageNotificationSettingManager.a(this.v);
    boolean bool = localMessageNotificationSettingManager.d();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, new Object[] { "doResetRingIdOfExtensionInfo: invoked. ", " hasResetGrayUserRingId: ", Boolean.valueOf(bool) });
    }
    if (!bool)
    {
      localMessageNotificationSettingManager.a(this.G.getAllExtensionInfo());
      localMessageNotificationSettingManager.a();
    }
  }
  
  private void D()
  {
    ??? = (ArrayList)this.w.query(NoC2CExtensionInfo.class);
    if (??? != null)
    {
      Iterator localIterator = ((ArrayList)???).iterator();
      while (localIterator.hasNext())
      {
        NoC2CExtensionInfo localNoC2CExtensionInfo = (NoC2CExtensionInfo)localIterator.next();
        if ((localNoC2CExtensionInfo != null) && (localNoC2CExtensionInfo.uin != null)) {
          synchronized (this.z)
          {
            String str = NoC2CExtensionInfo.getNoC2Ckey(localNoC2CExtensionInfo.type, localNoC2CExtensionInfo.uin);
            this.z.put(str, localNoC2CExtensionInfo);
          }
        }
      }
    }
  }
  
  private void E()
  {
    Object localObject1 = this.F.getAllFriends();
    if (localObject1 != null)
    {
      if (((List)localObject1).size() <= 0) {
        return;
      }
      localObject1 = ((List)localObject1).iterator();
      int i1 = 0;
      int i2;
      Object localObject2;
      do
      {
        do
        {
          i2 = i1;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (Friends)((Iterator)localObject1).next();
        } while (!((Friends)localObject2).isFriend());
        localObject2 = d(((Friends)localObject2).uin, false);
        i2 = i1;
        if (localObject2 != null)
        {
          i2 = i1;
          if (((ExtensionInfo)localObject2).hiddenChatSwitch == 1) {
            i2 = i1 + 1;
          }
        }
        i1 = i2;
      } while (i2 < 50);
      if ((i2 >= 50) && (SharedPreUtils.f(this.v.getApp()) == 0))
      {
        localObject1 = new RuntimeException("isOverLoadExtensionDataError");
        ((RuntimeException)localObject1).fillInStackTrace();
        QLog.d("Q.contacttab.extension", 1, "isOverLoadExtensionDataError():overload 50 friend extensionInfo data error:", (Throwable)localObject1);
        localObject2 = new HashMap();
        if (!TextUtils.isEmpty(this.v.getCurrentUin())) {
          ((HashMap)localObject2).put("detailEventUin", this.v.getCurrentUin());
        }
        ((HashMap)localObject2).put("detailEventDes", "isOverLoadExtensionDataError():overload 50 friend extensionInfo data error");
        ((HashMap)localObject2).put("stackInfo", QLog.getStackTraceString((Throwable)localObject1));
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "OVERLOAD_EXTENSION_INFO_DATA_ERROR", true, 0L, 0L, (HashMap)localObject2, "", false);
        SharedPreUtils.c(this.v.getApp(), 1);
      }
    }
  }
  
  private void a(long paramLong, boolean paramBoolean, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap(10);
    Object localObject = Looper.myLooper();
    Looper localLooper = Looper.getMainLooper();
    String str = "1";
    if (localObject == localLooper) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localHashMap.put("param_IsMainThread", localObject);
    localHashMap.put("param_OptType", paramString1);
    localHashMap.put("param_bustag", paramString2);
    if (paramBoolean) {
      paramString1 = str;
    } else {
      paramString1 = "0";
    }
    localHashMap.put("param_intrans", paramString1);
    localHashMap.put("param_OptTotalCost", String.valueOf(paramLong));
    localHashMap.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(null, "actFriendSqliteOpt", true, paramLong, 0L, localHashMap, null, false);
  }
  
  private ConcurrentHashMap<String, ArrayList<Entity>> c(boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, "buildNormalAndGatheredUiMaps begin :");
      }
      int i1 = 0;
      ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap(6);
      Object localObject4 = new ConcurrentHashMap(4);
      Object localObject1 = this.F.getAllFriends();
      int i3 = ((List)localObject1).size();
      Iterator localIterator1 = ((List)localObject1).iterator();
      Object localObject3;
      while (localIterator1.hasNext())
      {
        Friends localFriends = (Friends)localIterator1.next();
        int i2 = i1;
        if (localFriends.gathtertype == 1) {
          i2 = i1 + 1;
        }
        if (paramBoolean)
        {
          if (localFriends.gathtertype == 1) {
            i1 = i2;
          }
        }
        else
        {
          i1 = i2;
          if (localFriends.gathtertype == 0) {
            continue;
          }
          if (localFriends.gathtertype == 2)
          {
            i1 = i2;
            continue;
          }
        }
        if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0)) {
          ContactSorter.a(localFriends);
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(localFriends.groupid);
        ((StringBuilder)localObject1).append("");
        String str = ((StringBuilder)localObject1).toString();
        localObject3 = (ArrayList)localConcurrentHashMap.get(str);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject3 = new ArrayList();
          localConcurrentHashMap.put(str, localObject3);
          Iterator localIterator2 = this.F.getGroupList().iterator();
          do
          {
            localObject1 = localObject3;
            if (!localIterator2.hasNext()) {
              break;
            }
            localObject1 = (Groups)localIterator2.next();
          } while (((Groups)localObject1).group_id != localFriends.groupid);
          ((ArrayList)localObject3).ensureCapacity(Math.min(i3, ((Groups)localObject1).group_friend_count));
          localObject1 = localObject3;
        }
        ((ArrayList)localObject1).add(localFriends);
        i1 = i2;
        if (paramBoolean)
        {
          int i4 = OnlineStatusUtils.a(localFriends);
          i1 = i2;
          if (i4 != 0)
          {
            i1 = i2;
            if (i4 != 6)
            {
              localObject1 = (Integer)((ConcurrentHashMap)localObject4).get(str);
              if (localObject1 == null)
              {
                ((ConcurrentHashMap)localObject4).put(str, Integer.valueOf(1));
                i1 = i2;
              }
              else
              {
                ((ConcurrentHashMap)localObject4).put(str, Integer.valueOf(((Integer)localObject1).intValue() + 1));
                i1 = i2;
              }
            }
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder(300);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("buildNormalAndGatheredUiMaps end ");
        ((StringBuilder)localObject3).append(localConcurrentHashMap.size());
        ((StringBuilder)localObject3).append(": ");
        ((StringBuilder)localObject1).append(((StringBuilder)localObject3).toString());
        localObject3 = localConcurrentHashMap.keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          ((StringBuilder)localObject1).append((String)localObject4);
          ((StringBuilder)localObject1).append(", ");
          ((StringBuilder)localObject1).append(((ArrayList)localConcurrentHashMap.get(localObject4)).size());
          ((StringBuilder)localObject1).append("; ");
        }
        ((StringBuilder)localObject1).append(" gatherCount=");
        ((StringBuilder)localObject1).append(i1);
        QLog.d("Q.contacttab.friend", 2, ((StringBuilder)localObject1).toString());
      }
      return localConcurrentHashMap;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public int A()
  {
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).addAll(this.F.getAllFriends());
    StringBuilder localStringBuilder = new StringBuilder();
    localObject1 = ((ArrayList)localObject1).iterator();
    int i1 = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Friends)((Iterator)localObject1).next();
      if (((Friends)localObject2).isFriend())
      {
        localObject2 = x(((Friends)localObject2).uin);
        if ((localObject2 != null) && (IntimateUtil.a(((ExtensionInfo)localObject2).intimate_type)))
        {
          int i2 = i1 + 1;
          i1 = i2;
          if (QLog.isColorLevel())
          {
            localStringBuilder.append("\nuin:");
            localStringBuilder.append(((ExtensionInfo)localObject2).uin);
            localStringBuilder.append(" type:");
            localStringBuilder.append(((ExtensionInfo)localObject2).intimate_type);
            localStringBuilder.append(" level:");
            localStringBuilder.append(((ExtensionInfo)localObject2).intimate_level);
            i1 = i2;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("\ncount:");
      localStringBuilder.append(i1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getBindIntimateRelationshipFriendCount ");
      ((StringBuilder)localObject1).append(localStringBuilder.toString());
      QLog.d("Q.contacttab.", 2, ((StringBuilder)localObject1).toString());
    }
    return i1;
  }
  
  public DateNickNameInfo A(String paramString)
  {
    if (!Friends.isValidUin(paramString)) {
      return null;
    }
    if (!this.J) {
      ThreadManager.postImmediately(new FriendsManager.5(this), null, false);
    }
    return (DateNickNameInfo)this.A.get(paramString);
  }
  
  public Card a(String paramString, boolean paramBoolean)
  {
    return ((IProfileDataService)this.v.getRuntimeService(IProfileDataService.class, "all")).getProfileCard(paramString, paramBoolean);
  }
  
  public void a(long paramLong)
  {
    if (!Friends.isValidUin(paramLong)) {
      return;
    }
    Friends localFriends = this.F.getFriend(String.valueOf(paramLong));
    if (localFriends != null)
    {
      int i1 = OnlineStatusUtils.a(localFriends.detalStatusFlag, localFriends.iTermType);
      if ((i1 == 0) || (i1 == 6)) {
        localFriends.detalStatusFlag = 10;
      }
    }
  }
  
  public void a(ExtensionInfo paramExtensionInfo)
  {
    b(paramExtensionInfo);
    this.G.saveExtensionInfo(paramExtensionInfo);
    E();
  }
  
  public void a(Groups paramGroups)
  {
    this.F.saveGroup(paramGroups);
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    if (paramNearbyPeopleCard != null) {
      try
      {
        if ((!TextUtils.isEmpty(paramNearbyPeopleCard.uin)) && (!TextUtils.isEmpty(paramNearbyPeopleCard.nickname)) && (paramNearbyPeopleCard.lastUpdateNickTime > 0L))
        {
          DateNickNameInfo localDateNickNameInfo = new DateNickNameInfo(paramNearbyPeopleCard.nickname, paramNearbyPeopleCard.lastUpdateNickTime);
          if (paramNearbyPeopleCard.tinyId > 0L) {
            paramNearbyPeopleCard = String.valueOf(paramNearbyPeopleCard.tinyId);
          } else {
            paramNearbyPeopleCard = paramNearbyPeopleCard.uin;
          }
          this.A.put(paramNearbyPeopleCard, localDateNickNameInfo);
          return;
        }
      }
      finally {}
    }
  }
  
  public void a(NoC2CExtensionInfo paramNoC2CExtensionInfo, boolean paramBoolean)
  {
    if (paramNoC2CExtensionInfo != null)
    {
      if (paramNoC2CExtensionInfo.uin == null) {
        return;
      }
      ConcurrentHashMap localConcurrentHashMap = this.z;
      if (localConcurrentHashMap != null) {
        try
        {
          String str = NoC2CExtensionInfo.getNoC2Ckey(paramNoC2CExtensionInfo.type, paramNoC2CExtensionInfo.uin);
          this.z.put(str, paramNoC2CExtensionInfo);
          if (paramBoolean)
          {
            a(paramNoC2CExtensionInfo);
            return;
          }
        }
        finally {}
      }
    }
  }
  
  public void a(SpecialCareInfo paramSpecialCareInfo)
  {
    if ((paramSpecialCareInfo != null) && (paramSpecialCareInfo.uin != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveOrUpdateSpecialCareInfo: ");
        ((StringBuilder)localObject).append(paramSpecialCareInfo.toString());
        QLog.d("Q.contacttab.friend", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.B;
      if (localObject != null) {
        try
        {
          this.B.put(paramSpecialCareInfo.uin, paramSpecialCareInfo);
        }
        finally {}
      }
      a(paramSpecialCareInfo);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "saveOrUpdateSpecialCareInfo, specailCareInfo is null");
    }
  }
  
  public void a(String paramString)
  {
    SharedPreferences localSharedPreferences = this.v.getApp().getSharedPreferences(this.v.getCurrentAccountUin(), 0);
    if (localSharedPreferences.getInt("hotDisableInteractive", 1) == 1) {
      this.s = true;
    } else {
      this.s = false;
    }
    String[] arrayOfString = paramString.split("\\|");
    if (arrayOfString.length >= 9) {
      try
      {
        this.b = Integer.valueOf(arrayOfString[0]).intValue();
        this.c = Integer.valueOf(arrayOfString[1]).intValue();
        this.f = Integer.valueOf(arrayOfString[2]).intValue();
        this.g = Integer.valueOf(arrayOfString[3]).intValue();
        this.h = Integer.valueOf(arrayOfString[4]).intValue();
        this.i = Integer.valueOf(arrayOfString[5]).intValue();
        this.j = Integer.valueOf(arrayOfString[6]).intValue();
        this.k = Integer.valueOf(arrayOfString[7]).intValue();
        this.l = Integer.valueOf(arrayOfString[8]).intValue();
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.contacttab.", 2, paramString, localException2);
        }
      }
    }
    if (arrayOfString.length >= 11) {
      try
      {
        this.d = Integer.valueOf(arrayOfString[9]).intValue();
        this.e = Integer.valueOf(arrayOfString[10]).intValue();
      }
      catch (Exception localException3)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.contacttab.", 2, paramString, localException3);
        }
      }
    }
    if (arrayOfString.length >= 13) {
      try
      {
        this.m = Integer.valueOf(arrayOfString[11]).intValue();
        this.n = Integer.valueOf(arrayOfString[12]).intValue();
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.contacttab.", 2, paramString, localException1);
        }
      }
    }
    HotReactiveHelper.a(localSharedPreferences, this);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFriendGroup| uin: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", groupId: ");
      localStringBuilder.append(paramInt);
      QLog.d("Q.contacttab.", 2, localStringBuilder.toString());
    }
    this.F.moveFriendToNewGroup(paramString, paramInt);
  }
  
  public void a(String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (paramGetOnlineInfoResp != null)
    {
      Friends localFriends = this.F.getFriend(paramString);
      if (localFriends == null) {
        return;
      }
      localFriends.detalStatusFlag = ((byte)(int)paramGetOnlineInfoResp.dwStatus);
      localFriends.iTermType = ((int)paramGetOnlineInfoResp.iTermType);
      localFriends.abilityBits = paramGetOnlineInfoResp.uAbiFlag;
      localFriends.eNetwork = paramGetOnlineInfoResp.eNetworkType;
      localFriends.netTypeIconId = paramGetOnlineInfoResp.eIconType;
      localFriends.strTermDesc = paramGetOnlineInfoResp.strTermDesc;
      localFriends.uExtOnlineStatus = paramGetOnlineInfoResp.uExtOnlineStatus;
      localFriends.iBatteryStatus = paramGetOnlineInfoResp.iBatteryStatus;
      ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).parseFriendMusicInfo(localFriends, paramGetOnlineInfoResp.vecMusicInfo, "AIO");
      ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).parseExtOnlineBusinessInfo(localFriends, paramGetOnlineInfoResp.vecExtOnlineBusinessInfo, "AIO");
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, new Object[] { "updateOnlineStatus uin:", paramString, " extOnline:", Long.valueOf(paramGetOnlineInfoResp.uExtOnlineStatus), " battery:", Integer.valueOf(paramGetOnlineInfoResp.iBatteryStatus) });
      }
      CustomOnlineStatusPb.CustomOnlineStatusMsg localCustomOnlineStatusMsg = new CustomOnlineStatusPb.CustomOnlineStatusMsg();
      try
      {
        CustomOnlineStatusManager.a().b(paramString);
        localCustomOnlineStatusMsg.mergeFrom(paramGetOnlineInfoResp.strCustomOnlineStatusDesc.getBytes());
        localFriends.customOnlineStatusType = CustomOnlineStatusManager.Utils.d(localCustomOnlineStatusMsg);
        localFriends.customOnlineStatus = CustomOnlineStatusManager.Utils.a(localCustomOnlineStatusMsg);
        localFriends.customModel = CustomOnlineStatusManager.Utils.b(localCustomOnlineStatusMsg);
        if (QLog.isDevelopLevel())
        {
          paramString = new StringBuilder();
          paramString.append("updateOnlineStatus : customOnlineStatusType = ");
          paramString.append(localFriends.customOnlineStatusType);
          paramString.append(" customOnlineStatus = ");
          paramString.append(localFriends.customOnlineStatus);
          QLog.d("CustomOnlineStatusManager", 4, paramString.toString());
          return;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CustomOnlineStatusManager", 2, paramString, new Object[0]);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = this.F.getFriend(paramString1, true, true, true);
    paramString1.name = paramString2;
    paramString1.datetime = System.currentTimeMillis();
    this.F.saveFriend(paramString1);
  }
  
  public void a(String paramString1, String paramString2, byte paramByte)
  {
    NearbyPeopleCard localNearbyPeopleCard2 = (NearbyPeopleCard)this.w.find(NearbyPeopleCard.class, "uin=?", new String[] { paramString1 });
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
    if ((CrmUtils.a(paramByte1)) && (!QidianManager.b(paramByte1))) {
      return;
    }
    Object localObject = this.F;
    byte b1 = 1;
    paramString1 = ((IFriendDataService)localObject).getFriend(paramString1, true, true, true);
    paramString1.cSpecialFlag = paramByte1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveFriendInfoByUin uin=");
      ((StringBuilder)localObject).append(paramString1.uin);
      ((StringBuilder)localObject).append(", cSpecialFlag=");
      ((StringBuilder)localObject).append(paramString1.cSpecialFlag);
      QLog.i("Q.contacttab.", 2, ((StringBuilder)localObject).toString());
    }
    paramString1.name = paramString2;
    if (paramShort == 0) {
      paramByte1 = b1;
    } else if (paramShort == 1) {
      paramByte1 = 2;
    } else {
      paramByte1 = 0;
    }
    paramString1.gender = paramByte1;
    paramString1.age = paramByte2;
    paramString1.datetime = System.currentTimeMillis();
    this.F.saveFriend(paramString1);
  }
  
  public void a(ArrayList<SimpleOnlineFriendInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      Object localObject = new StringBuilder(100);
      ((StringBuilder)localObject).append("updateOnlineStatus size:");
      ((StringBuilder)localObject).append(paramArrayList.size());
      ((StringBuilder)localObject).append("\n");
      HashMap localHashMap = new HashMap(paramArrayList.size());
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        SimpleOnlineFriendInfo localSimpleOnlineFriendInfo = (SimpleOnlineFriendInfo)paramArrayList.next();
        String str = String.valueOf(localSimpleOnlineFriendInfo.friendUin);
        Friends localFriends = this.F.getFriend(str);
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
          ((StringBuilder)localObject).append("uin:");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(" battery:");
          ((StringBuilder)localObject).append(localSimpleOnlineFriendInfo.iBatteryStatus);
          ((StringBuilder)localObject).append(" extOnline:");
          ((StringBuilder)localObject).append(localSimpleOnlineFriendInfo.uExtOnlineStatus);
          ((StringBuilder)localObject).append("\n");
          ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).parseFriendMusicInfo(localFriends, localSimpleOnlineFriendInfo.vecMusicInfo, "SimpleOnlie");
          ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).parseExtOnlineBusinessInfo(localFriends, localSimpleOnlineFriendInfo.vecExtOnlineBusinessInfo, "SimpleOnlie");
          localHashMap.put(str, Boolean.TRUE);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, ((StringBuilder)localObject).toString());
      }
      paramArrayList = this.F.getAllFriends();
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
  
  /* Error */
  public void a(@android.support.annotation.NonNull ArrayList<Friends> paramArrayList, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 210	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +141 -> 144
    //   6: new 225	java/lang/StringBuilder
    //   9: dup
    //   10: aload_1
    //   11: invokevirtual 516	java/util/ArrayList:size	()I
    //   14: bipush 12
    //   16: imul
    //   17: bipush 48
    //   19: iadd
    //   20: invokespecial 501	java/lang/StringBuilder:<init>	(I)V
    //   23: astore_3
    //   24: aload_3
    //   25: ldc_w 895
    //   28: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_3
    //   33: aload_1
    //   34: invokevirtual 516	java/util/ArrayList:size	()I
    //   37: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_3
    //   42: ldc_w 897
    //   45: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_3
    //   50: iload_2
    //   51: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_3
    //   56: ldc_w 899
    //   59: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_1
    //   64: invokevirtual 279	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   67: astore 4
    //   69: aload 4
    //   71: invokeinterface 284 1 0
    //   76: ifeq +57 -> 133
    //   79: aload 4
    //   81: invokeinterface 288 1 0
    //   86: checkcast 316	com/tencent/mobileqq/data/Friends
    //   89: astore 5
    //   91: new 225	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   98: astore 6
    //   100: aload 6
    //   102: aload 5
    //   104: getfield 320	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   107: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 6
    //   113: ldc_w 901
    //   116: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_3
    //   121: aload 6
    //   123: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: goto -61 -> 69
    //   133: ldc_w 903
    //   136: iconst_2
    //   137: aload_3
    //   138: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 441	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload_1
    //   145: invokevirtual 516	java/util/ArrayList:size	()I
    //   148: ifle +41 -> 189
    //   151: aload_0
    //   152: getfield 164	com/tencent/mobileqq/app/FriendsManager:v	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   155: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   158: aload_0
    //   159: getfield 164	com/tencent/mobileqq/app/FriendsManager:v	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   162: invokevirtual 906	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   165: iconst_0
    //   166: invokevirtual 645	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   169: invokeinterface 910 1 0
    //   174: ldc_w 912
    //   177: iconst_1
    //   178: invokeinterface 918 3 0
    //   183: invokeinterface 921 1 0
    //   188: pop
    //   189: aload_0
    //   190: getfield 172	com/tencent/mobileqq/app/FriendsManager:w	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   193: invokevirtual 925	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   196: astore_3
    //   197: aload_3
    //   198: invokevirtual 930	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   201: iload_2
    //   202: ifne +97 -> 299
    //   205: aload_0
    //   206: getfield 184	com/tencent/mobileqq/app/FriendsManager:F	Lcom/tencent/mobileqq/friend/api/IFriendDataService;
    //   209: invokeinterface 308 1 0
    //   214: invokeinterface 314 1 0
    //   219: astore 4
    //   221: aload 4
    //   223: invokeinterface 284 1 0
    //   228: ifeq +71 -> 299
    //   231: aload 4
    //   233: invokeinterface 288 1 0
    //   238: checkcast 316	com/tencent/mobileqq/data/Friends
    //   241: astore 5
    //   243: aload 5
    //   245: getfield 444	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   248: iconst_1
    //   249: if_icmpne -28 -> 221
    //   252: aload 5
    //   254: iconst_0
    //   255: putfield 444	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   258: aload_0
    //   259: aload 5
    //   261: invokevirtual 932	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   264: pop
    //   265: aload_0
    //   266: getfield 934	com/tencent/mobileqq/app/FriendsManager:L	Ljava/util/ArrayList;
    //   269: ifnonnull +14 -> 283
    //   272: aload_0
    //   273: new 275	java/util/ArrayList
    //   276: dup
    //   277: invokespecial 463	java/util/ArrayList:<init>	()V
    //   280: putfield 934	com/tencent/mobileqq/app/FriendsManager:L	Ljava/util/ArrayList;
    //   283: aload_0
    //   284: getfield 934	com/tencent/mobileqq/app/FriendsManager:L	Ljava/util/ArrayList;
    //   287: aload 5
    //   289: getfield 320	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   292: invokevirtual 487	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   295: pop
    //   296: goto -75 -> 221
    //   299: aload_1
    //   300: invokevirtual 279	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   303: astore_1
    //   304: aload_1
    //   305: invokeinterface 284 1 0
    //   310: ifeq +125 -> 435
    //   313: aload_1
    //   314: invokeinterface 288 1 0
    //   319: checkcast 316	com/tencent/mobileqq/data/Friends
    //   322: astore 4
    //   324: aload_0
    //   325: getfield 184	com/tencent/mobileqq/app/FriendsManager:F	Lcom/tencent/mobileqq/friend/api/IFriendDataService;
    //   328: aload 4
    //   330: getfield 320	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   333: invokeinterface 582 2 0
    //   338: astore 5
    //   340: aload 5
    //   342: ifnonnull +6 -> 348
    //   345: goto -41 -> 304
    //   348: aload 5
    //   350: iconst_1
    //   351: putfield 444	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   354: aload 5
    //   356: aload 4
    //   358: getfield 858	com/tencent/mobileqq/data/Friends:age	I
    //   361: putfield 858	com/tencent/mobileqq/data/Friends:age	I
    //   364: aload 5
    //   366: aload 4
    //   368: getfield 937	com/tencent/mobileqq/data/Friends:smartRemark	Ljava/lang/String;
    //   371: putfield 937	com/tencent/mobileqq/data/Friends:smartRemark	Ljava/lang/String;
    //   374: aload 5
    //   376: aload 4
    //   378: getfield 855	com/tencent/mobileqq/data/Friends:gender	B
    //   381: putfield 855	com/tencent/mobileqq/data/Friends:gender	B
    //   384: aload 5
    //   386: aload 4
    //   388: getfield 940	com/tencent/mobileqq/data/Friends:recommReason	Ljava/lang/String;
    //   391: putfield 940	com/tencent/mobileqq/data/Friends:recommReason	Ljava/lang/String;
    //   394: aload_0
    //   395: aload 5
    //   397: invokevirtual 932	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   400: pop
    //   401: aload_0
    //   402: getfield 942	com/tencent/mobileqq/app/FriendsManager:M	Ljava/util/ArrayList;
    //   405: ifnonnull +14 -> 419
    //   408: aload_0
    //   409: new 275	java/util/ArrayList
    //   412: dup
    //   413: invokespecial 463	java/util/ArrayList:<init>	()V
    //   416: putfield 942	com/tencent/mobileqq/app/FriendsManager:M	Ljava/util/ArrayList;
    //   419: aload_0
    //   420: getfield 942	com/tencent/mobileqq/app/FriendsManager:M	Ljava/util/ArrayList;
    //   423: aload 5
    //   425: getfield 320	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   428: invokevirtual 487	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   431: pop
    //   432: goto -128 -> 304
    //   435: aload_3
    //   436: invokevirtual 944	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   439: goto +18 -> 457
    //   442: astore_1
    //   443: goto +19 -> 462
    //   446: astore_1
    //   447: ldc 212
    //   449: iconst_1
    //   450: ldc_w 946
    //   453: aload_1
    //   454: invokestatic 664	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   457: aload_3
    //   458: invokevirtual 949	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   461: return
    //   462: aload_3
    //   463: invokevirtual 949	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   466: goto +5 -> 471
    //   469: aload_1
    //   470: athrow
    //   471: goto -2 -> 469
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	474	0	this	FriendsManager
    //   0	474	1	paramArrayList	ArrayList<Friends>
    //   0	474	2	paramInt	int
    //   23	440	3	localObject1	Object
    //   67	320	4	localObject2	Object
    //   89	335	5	localFriends	Friends
    //   98	24	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   197	201	442	finally
    //   205	221	442	finally
    //   221	283	442	finally
    //   283	296	442	finally
    //   299	304	442	finally
    //   304	340	442	finally
    //   348	419	442	finally
    //   419	432	442	finally
    //   435	439	442	finally
    //   447	457	442	finally
    //   197	201	446	java/lang/Exception
    //   205	221	446	java/lang/Exception
    //   221	283	446	java/lang/Exception
    //   283	296	446	java/lang/Exception
    //   299	304	446	java/lang/Exception
    //   304	340	446	java/lang/Exception
    //   348	419	446	java/lang/Exception
    //   419	432	446	java/lang/Exception
    //   435	439	446	java/lang/Exception
  }
  
  public void a(List<String> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("queryFriends_");
    ((StringBuilder)localObject).append(paramList.size());
    TraceUtils.traceBegin(((StringBuilder)localObject).toString());
    paramList = this.F.preloadPartFriendCache(paramList);
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (Friends)paramList.next();
        QidianManager.a(this.v, (Friends)localObject);
      }
    }
    TraceUtils.traceEnd();
  }
  
  /* Error */
  public void a(List<SpecialCareInfo> paramList, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: aload_1
    //   4: ifnull +14 -> 18
    //   7: aload_1
    //   8: invokeinterface 313 1 0
    //   13: istore 5
    //   15: goto +6 -> 21
    //   18: iconst_0
    //   19: istore 5
    //   21: invokestatic 210	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +74 -> 98
    //   27: new 225	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   34: astore 8
    //   36: aload 8
    //   38: ldc_w 972
    //   41: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 8
    //   47: iload 5
    //   49: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 8
    //   55: ldc_w 515
    //   58: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 8
    //   64: lload_2
    //   65: invokevirtual 881	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 8
    //   71: ldc_w 515
    //   74: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 8
    //   80: iload 4
    //   82: invokevirtual 975	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: ldc_w 522
    //   89: iconst_2
    //   90: aload 8
    //   92: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 441	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload_0
    //   99: getfield 96	com/tencent/mobileqq/app/FriendsManager:B	Ljava/util/concurrent/ConcurrentHashMap;
    //   102: astore 8
    //   104: aload 8
    //   106: ifnull +131 -> 237
    //   109: aload 8
    //   111: monitorenter
    //   112: iconst_0
    //   113: istore 6
    //   115: iload 6
    //   117: iload 5
    //   119: if_icmpge +42 -> 161
    //   122: aload_0
    //   123: getfield 96	com/tencent/mobileqq/app/FriendsManager:B	Ljava/util/concurrent/ConcurrentHashMap;
    //   126: aload_1
    //   127: iload 6
    //   129: invokeinterface 978 2 0
    //   134: checkcast 628	com/tencent/mobileqq/data/SpecialCareInfo
    //   137: getfield 629	com/tencent/mobileqq/data/SpecialCareInfo:uin	Ljava/lang/String;
    //   140: aload_1
    //   141: iload 6
    //   143: invokeinterface 978 2 0
    //   148: invokevirtual 305	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   151: pop
    //   152: iload 6
    //   154: iconst_1
    //   155: iadd
    //   156: istore 6
    //   158: goto -43 -> 115
    //   161: iload 4
    //   163: ifeq +63 -> 226
    //   166: aload_0
    //   167: getfield 96	com/tencent/mobileqq/app/FriendsManager:B	Ljava/util/concurrent/ConcurrentHashMap;
    //   170: invokevirtual 981	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   173: invokeinterface 513 1 0
    //   178: astore 9
    //   180: aload 9
    //   182: invokeinterface 284 1 0
    //   187: ifeq +39 -> 226
    //   190: aload 9
    //   192: invokeinterface 288 1 0
    //   197: checkcast 983	java/util/Map$Entry
    //   200: invokeinterface 986 1 0
    //   205: checkcast 628	com/tencent/mobileqq/data/SpecialCareInfo
    //   208: getfield 989	com/tencent/mobileqq/data/SpecialCareInfo:dateTime	J
    //   211: lload_2
    //   212: lcmp
    //   213: ifge -33 -> 180
    //   216: aload 9
    //   218: invokeinterface 992 1 0
    //   223: goto -43 -> 180
    //   226: aload 8
    //   228: monitorexit
    //   229: goto +8 -> 237
    //   232: aload 8
    //   234: monitorexit
    //   235: aload_1
    //   236: athrow
    //   237: aload_0
    //   238: getfield 172	com/tencent/mobileqq/app/FriendsManager:w	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   241: invokevirtual 925	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   244: astore 8
    //   246: aload 8
    //   248: invokevirtual 930	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   251: iload 7
    //   253: istore 6
    //   255: iload 6
    //   257: iload 5
    //   259: if_icmpge +28 -> 287
    //   262: aload_0
    //   263: aload_1
    //   264: iload 6
    //   266: invokeinterface 978 2 0
    //   271: checkcast 290	com/tencent/mobileqq/persistence/Entity
    //   274: invokevirtual 625	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   277: pop
    //   278: iload 6
    //   280: iconst_1
    //   281: iadd
    //   282: istore 6
    //   284: goto -29 -> 255
    //   287: iload 4
    //   289: ifeq +120 -> 409
    //   292: ldc_w 628
    //   295: invokevirtual 997	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   298: checkcast 628	com/tencent/mobileqq/data/SpecialCareInfo
    //   301: invokevirtual 1000	com/tencent/mobileqq/data/SpecialCareInfo:getTableName	()Ljava/lang/String;
    //   304: astore_1
    //   305: aload_0
    //   306: getfield 172	com/tencent/mobileqq/app/FriendsManager:w	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   309: astore 9
    //   311: new 225	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   318: astore 10
    //   320: aload 10
    //   322: ldc_w 1002
    //   325: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload 10
    //   331: lload_2
    //   332: invokevirtual 881	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 9
    //   338: aload_1
    //   339: aload 10
    //   341: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: aconst_null
    //   345: invokevirtual 1006	com/tencent/mobileqq/persistence/EntityManager:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   348: istore 5
    //   350: invokestatic 210	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   353: ifeq +56 -> 409
    //   356: new 225	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   363: astore 9
    //   365: aload 9
    //   367: ldc_w 1008
    //   370: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 9
    //   376: aload_1
    //   377: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload 9
    //   383: ldc_w 1010
    //   386: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 9
    //   392: iload 5
    //   394: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: ldc 212
    //   400: iconst_2
    //   401: aload 9
    //   403: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 441	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   409: aload 8
    //   411: invokevirtual 944	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   414: goto +12 -> 426
    //   417: astore_1
    //   418: goto +14 -> 432
    //   421: astore_1
    //   422: aload_1
    //   423: invokevirtual 1013	java/lang/Exception:printStackTrace	()V
    //   426: aload 8
    //   428: invokevirtual 949	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   431: return
    //   432: aload 8
    //   434: invokevirtual 949	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   437: goto +5 -> 442
    //   440: aload_1
    //   441: athrow
    //   442: goto -2 -> 440
    //   445: astore_1
    //   446: goto -214 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	449	0	this	FriendsManager
    //   0	449	1	paramList	List<SpecialCareInfo>
    //   0	449	2	paramLong	long
    //   0	449	4	paramBoolean	boolean
    //   13	380	5	i1	int
    //   113	170	6	i2	int
    //   1	251	7	i3	int
    //   34	399	8	localObject1	Object
    //   178	224	9	localObject2	Object
    //   318	22	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   246	251	417	finally
    //   262	278	417	finally
    //   292	409	417	finally
    //   409	414	417	finally
    //   422	426	417	finally
    //   246	251	421	java/lang/Exception
    //   262	278	421	java/lang/Exception
    //   292	409	421	java/lang/Exception
    //   409	414	421	java/lang/Exception
    //   122	152	445	finally
    //   166	180	445	finally
    //   180	223	445	finally
    //   226	229	445	finally
    //   232	235	445	finally
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11)
  {
    this.D = paramBoolean1;
    this.E = paramBoolean2;
    this.b = paramInt1;
    this.c = paramInt2;
    this.f = paramInt3;
    this.g = paramInt4;
    this.h = paramInt5;
    this.i = paramInt6;
    this.j = paramInt7;
    this.k = paramInt8;
    this.l = paramInt11;
    this.m = paramInt9;
    this.n = paramInt10;
  }
  
  public boolean a()
  {
    boolean bool = e();
    b();
    this.D = SharedPreUtils.q(this.v.getApp(), this.v.getCurrentAccountUin(), 0);
    this.E = SharedPreUtils.q(this.v.getApp(), this.v.getCurrentAccountUin(), 1);
    a(SharedPreUtils.N(this.v.getApp()));
    return bool;
  }
  
  public boolean a(int paramInt)
  {
    if (((paramInt == 0) && (!this.D)) || ((paramInt == 1) && (!this.E)))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isEnableChatDays|config close, type=");
        localStringBuilder.append(paramInt);
        QLog.d("HotFriend_Q.contacttab.", 2, localStringBuilder.toString());
      }
      return false;
    }
    return true;
  }
  
  public boolean a(Card paramCard)
  {
    return ((IProfileDataService)this.v.getRuntimeService(IProfileDataService.class, "all")).saveProfileCard(paramCard);
  }
  
  public boolean a(Friends paramFriends)
  {
    return this.F.saveFriend(paramFriends);
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool2 = this.w.isOpen();
    boolean bool1 = false;
    if (bool2)
    {
      if (paramEntity.getStatus() == 1000)
      {
        this.w.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
        return bool1;
      }
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.w.update(paramEntity);
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateEntity em closed e=");
      localStringBuilder.append(paramEntity.getTableName());
      QLog.d("Q.contacttab.friend", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  /* Error */
  protected boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 210	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +72 -> 75
    //   6: new 225	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   13: astore 12
    //   15: aload 12
    //   17: ldc_w 1055
    //   20: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 12
    //   26: aload_1
    //   27: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 12
    //   33: ldc_w 515
    //   36: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 12
    //   42: iload_2
    //   43: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 12
    //   49: ldc_w 515
    //   52: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 12
    //   58: iload_3
    //   59: invokevirtual 975	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: ldc_w 1057
    //   66: iconst_2
    //   67: aload 12
    //   69: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 441	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: aconst_null
    //   76: astore 14
    //   78: aconst_null
    //   79: astore 13
    //   81: iconst_0
    //   82: istore 5
    //   84: iconst_0
    //   85: istore 8
    //   87: iconst_0
    //   88: istore 6
    //   90: iconst_0
    //   91: istore 4
    //   93: aload_0
    //   94: getfield 172	com/tencent/mobileqq/app/FriendsManager:w	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   97: invokevirtual 925	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   100: astore 12
    //   102: aload 12
    //   104: astore 13
    //   106: aload 12
    //   108: astore 14
    //   110: aload 12
    //   112: invokevirtual 930	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   115: aload 12
    //   117: astore 13
    //   119: aload 12
    //   121: astore 14
    //   123: aload_0
    //   124: aload_1
    //   125: invokevirtual 1059	com/tencent/mobileqq/app/FriendsManager:e	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   128: astore 15
    //   130: aload 12
    //   132: astore 13
    //   134: aload 12
    //   136: astore 14
    //   138: invokestatic 210	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +108 -> 249
    //   144: aload 12
    //   146: astore 13
    //   148: aload 12
    //   150: astore 14
    //   152: new 225	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   159: astore 16
    //   161: aload 12
    //   163: astore 13
    //   165: aload 12
    //   167: astore 14
    //   169: aload 16
    //   171: ldc_w 1061
    //   174: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 12
    //   180: astore 13
    //   182: aload 12
    //   184: astore 14
    //   186: aload 16
    //   188: aload_1
    //   189: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 12
    //   195: astore 13
    //   197: aload 12
    //   199: astore 14
    //   201: aload 16
    //   203: ldc_w 1063
    //   206: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload 12
    //   212: astore 13
    //   214: aload 12
    //   216: astore 14
    //   218: aload 16
    //   220: aload 15
    //   222: getfield 444	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   225: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload 12
    //   231: astore 13
    //   233: aload 12
    //   235: astore 14
    //   237: ldc_w 903
    //   240: iconst_2
    //   241: aload 16
    //   243: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 441	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: aload 12
    //   251: astore 13
    //   253: aload 12
    //   255: astore 14
    //   257: aload_0
    //   258: aload_1
    //   259: invokevirtual 1065	com/tencent/mobileqq/app/FriendsManager:k	(Ljava/lang/String;)Z
    //   262: ifeq +16 -> 278
    //   265: aload 12
    //   267: astore 13
    //   269: aload 12
    //   271: astore 14
    //   273: aload_0
    //   274: aload_1
    //   275: invokevirtual 1067	com/tencent/mobileqq/app/FriendsManager:l	(Ljava/lang/String;)V
    //   278: aload 12
    //   280: astore 13
    //   282: aload 12
    //   284: astore 14
    //   286: aload 15
    //   288: getfield 455	com/tencent/mobileqq/data/Friends:groupid	I
    //   291: istore 9
    //   293: iconst_m1
    //   294: istore 7
    //   296: iload 9
    //   298: iconst_m1
    //   299: if_icmpne +23 -> 322
    //   302: aload 12
    //   304: astore 13
    //   306: aload 12
    //   308: astore 14
    //   310: aload 15
    //   312: iload_2
    //   313: putfield 455	com/tencent/mobileqq/data/Friends:groupid	I
    //   316: iconst_1
    //   317: istore 10
    //   319: goto +35 -> 354
    //   322: aload 12
    //   324: astore 13
    //   326: aload 12
    //   328: astore 14
    //   330: aload 15
    //   332: getfield 455	com/tencent/mobileqq/data/Friends:groupid	I
    //   335: istore 7
    //   337: aload 12
    //   339: astore 13
    //   341: aload 12
    //   343: astore 14
    //   345: aload 15
    //   347: iload_2
    //   348: putfield 455	com/tencent/mobileqq/data/Friends:groupid	I
    //   351: iconst_0
    //   352: istore 10
    //   354: iload 8
    //   356: istore 6
    //   358: aload 12
    //   360: astore 13
    //   362: aload 15
    //   364: invokestatic 815	java/lang/System:currentTimeMillis	()J
    //   367: putfield 818	com/tencent/mobileqq/data/Friends:datetime	J
    //   370: iload_3
    //   371: ifeq +148 -> 519
    //   374: iload 8
    //   376: istore 6
    //   378: aload 12
    //   380: astore 13
    //   382: aload 15
    //   384: getfield 444	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   387: istore 5
    //   389: iload 5
    //   391: iconst_1
    //   392: if_icmpeq +9 -> 401
    //   395: iconst_1
    //   396: istore 5
    //   398: goto +6 -> 404
    //   401: iconst_0
    //   402: istore 5
    //   404: aload 12
    //   406: astore 13
    //   408: aload 15
    //   410: iconst_1
    //   411: putfield 444	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   414: aload 12
    //   416: astore 13
    //   418: aload 15
    //   420: ldc_w 1068
    //   423: invokestatic 1073	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   426: putfield 940	com/tencent/mobileqq/data/Friends:recommReason	Ljava/lang/String;
    //   429: aload 12
    //   431: astore 13
    //   433: aload_0
    //   434: aload 15
    //   436: getfield 320	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   439: invokevirtual 1076	com/tencent/mobileqq/app/FriendsManager:f	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   442: astore 14
    //   444: aload 14
    //   446: ifnull +62 -> 508
    //   449: aload 12
    //   451: astore 13
    //   453: aload 14
    //   455: getfield 1082	com/tencent/mobileqq/data/Card:shGender	S
    //   458: ifne +9 -> 467
    //   461: iconst_1
    //   462: istore 4
    //   464: goto +19 -> 483
    //   467: aload 12
    //   469: astore 13
    //   471: aload 14
    //   473: getfield 1082	com/tencent/mobileqq/data/Card:shGender	S
    //   476: iconst_1
    //   477: if_icmpne +6 -> 483
    //   480: iconst_2
    //   481: istore 4
    //   483: aload 12
    //   485: astore 13
    //   487: aload 15
    //   489: iload 4
    //   491: putfield 855	com/tencent/mobileqq/data/Friends:gender	B
    //   494: aload 12
    //   496: astore 13
    //   498: aload 15
    //   500: aload 14
    //   502: getfield 1084	com/tencent/mobileqq/data/Card:age	B
    //   505: putfield 858	com/tencent/mobileqq/data/Friends:age	I
    //   508: goto +11 -> 519
    //   511: astore 15
    //   513: iload 5
    //   515: istore_2
    //   516: goto +222 -> 738
    //   519: iload 5
    //   521: istore 6
    //   523: aload 12
    //   525: astore 13
    //   527: aload_0
    //   528: aload 15
    //   530: invokevirtual 625	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   533: pop
    //   534: iload 5
    //   536: istore 6
    //   538: aload 12
    //   540: astore 13
    //   542: aload_0
    //   543: iload_2
    //   544: invokestatic 1086	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   547: invokevirtual 1089	com/tencent/mobileqq/app/FriendsManager:u	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   550: astore 14
    //   552: aload 14
    //   554: ifnull +41 -> 595
    //   557: iload 5
    //   559: istore 6
    //   561: aload 12
    //   563: astore 13
    //   565: aload 14
    //   567: aload 14
    //   569: getfield 474	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   572: iconst_1
    //   573: iadd
    //   574: putfield 474	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   577: iload 5
    //   579: istore 6
    //   581: aload 12
    //   583: astore 13
    //   585: aload_0
    //   586: getfield 172	com/tencent/mobileqq/app/FriendsManager:w	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   589: aload 14
    //   591: invokevirtual 1049	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   594: pop
    //   595: iload 10
    //   597: ifne +73 -> 670
    //   600: iload 7
    //   602: iflt +68 -> 670
    //   605: iload 7
    //   607: iload_2
    //   608: if_icmpeq +62 -> 670
    //   611: iload 5
    //   613: istore 6
    //   615: aload 12
    //   617: astore 13
    //   619: aload_0
    //   620: iload 7
    //   622: invokestatic 1086	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   625: invokevirtual 1089	com/tencent/mobileqq/app/FriendsManager:u	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   628: astore 14
    //   630: aload 14
    //   632: ifnull +38 -> 670
    //   635: iload 5
    //   637: istore 6
    //   639: aload 12
    //   641: astore 13
    //   643: aload 14
    //   645: aload 14
    //   647: getfield 474	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   650: iconst_1
    //   651: isub
    //   652: putfield 474	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   655: iload 5
    //   657: istore 6
    //   659: aload 12
    //   661: astore 13
    //   663: aload_0
    //   664: aload 14
    //   666: invokevirtual 625	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   669: pop
    //   670: iload 5
    //   672: istore 6
    //   674: aload 12
    //   676: astore 13
    //   678: aload 12
    //   680: invokevirtual 944	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   683: iload 5
    //   685: istore 6
    //   687: iload 10
    //   689: istore 11
    //   691: aload 12
    //   693: ifnull +86 -> 779
    //   696: iload 5
    //   698: istore_2
    //   699: aload 12
    //   701: invokevirtual 949	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   704: iload_2
    //   705: istore 6
    //   707: iload 10
    //   709: istore 11
    //   711: goto +68 -> 779
    //   714: astore 15
    //   716: iload 6
    //   718: istore_2
    //   719: goto +19 -> 738
    //   722: astore_1
    //   723: goto +76 -> 799
    //   726: astore 15
    //   728: iconst_0
    //   729: istore 10
    //   731: iload 6
    //   733: istore_2
    //   734: aload 14
    //   736: astore 12
    //   738: aload 12
    //   740: astore 13
    //   742: invokestatic 210	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   745: ifeq +19 -> 764
    //   748: aload 12
    //   750: astore 13
    //   752: ldc_w 1057
    //   755: iconst_2
    //   756: ldc_w 1091
    //   759: aload 15
    //   761: invokestatic 664	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   764: iload_2
    //   765: istore 6
    //   767: iload 10
    //   769: istore 11
    //   771: aload 12
    //   773: ifnull +6 -> 779
    //   776: goto -77 -> 699
    //   779: iload_3
    //   780: ifeq +16 -> 796
    //   783: iload 6
    //   785: ifeq +11 -> 796
    //   788: aload_0
    //   789: getfield 164	com/tencent/mobileqq/app/FriendsManager:v	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   792: aload_1
    //   793: invokestatic 1096	com/tencent/mobileqq/activity/aio/tips/GatherContactsTipsHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   796: iload 11
    //   798: ireturn
    //   799: aload 13
    //   801: ifnull +8 -> 809
    //   804: aload 13
    //   806: invokevirtual 949	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   809: goto +5 -> 814
    //   812: aload_1
    //   813: athrow
    //   814: goto -2 -> 812
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	817	0	this	FriendsManager
    //   0	817	1	paramString	String
    //   0	817	2	paramInt	int
    //   0	817	3	paramBoolean	boolean
    //   91	399	4	b1	byte
    //   82	615	5	i1	int
    //   88	696	6	i2	int
    //   294	327	7	i3	int
    //   85	290	8	i4	int
    //   291	9	9	i5	int
    //   317	451	10	bool1	boolean
    //   689	108	11	bool2	boolean
    //   13	759	12	localObject1	Object
    //   79	726	13	localObject2	Object
    //   76	659	14	localObject3	Object
    //   128	371	15	localFriends	Friends
    //   511	18	15	localException1	Exception
    //   714	1	15	localException2	Exception
    //   726	34	15	localException3	Exception
    //   159	83	16	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   408	414	511	java/lang/Exception
    //   418	429	511	java/lang/Exception
    //   433	444	511	java/lang/Exception
    //   453	461	511	java/lang/Exception
    //   471	480	511	java/lang/Exception
    //   487	494	511	java/lang/Exception
    //   498	508	511	java/lang/Exception
    //   362	370	714	java/lang/Exception
    //   382	389	714	java/lang/Exception
    //   527	534	714	java/lang/Exception
    //   542	552	714	java/lang/Exception
    //   565	577	714	java/lang/Exception
    //   585	595	714	java/lang/Exception
    //   619	630	714	java/lang/Exception
    //   643	655	714	java/lang/Exception
    //   663	670	714	java/lang/Exception
    //   678	683	714	java/lang/Exception
    //   93	102	722	finally
    //   110	115	722	finally
    //   123	130	722	finally
    //   138	144	722	finally
    //   152	161	722	finally
    //   169	178	722	finally
    //   186	193	722	finally
    //   201	210	722	finally
    //   218	229	722	finally
    //   237	249	722	finally
    //   257	265	722	finally
    //   273	278	722	finally
    //   286	293	722	finally
    //   310	316	722	finally
    //   330	337	722	finally
    //   345	351	722	finally
    //   362	370	722	finally
    //   382	389	722	finally
    //   408	414	722	finally
    //   418	429	722	finally
    //   433	444	722	finally
    //   453	461	722	finally
    //   471	480	722	finally
    //   487	494	722	finally
    //   498	508	722	finally
    //   527	534	722	finally
    //   542	552	722	finally
    //   565	577	722	finally
    //   585	595	722	finally
    //   619	630	722	finally
    //   643	655	722	finally
    //   663	670	722	finally
    //   678	683	722	finally
    //   742	748	722	finally
    //   752	764	722	finally
    //   93	102	726	java/lang/Exception
    //   110	115	726	java/lang/Exception
    //   123	130	726	java/lang/Exception
    //   138	144	726	java/lang/Exception
    //   152	161	726	java/lang/Exception
    //   169	178	726	java/lang/Exception
    //   186	193	726	java/lang/Exception
    //   201	210	726	java/lang/Exception
    //   218	229	726	java/lang/Exception
    //   237	249	726	java/lang/Exception
    //   257	265	726	java/lang/Exception
    //   273	278	726	java/lang/Exception
    //   286	293	726	java/lang/Exception
    //   310	316	726	java/lang/Exception
    //   330	337	726	java/lang/Exception
    //   345	351	726	java/lang/Exception
  }
  
  public boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return ((IAddFriendServiceApi)this.v.getRuntimeService(IAddFriendServiceApi.class)).hasSendAddFriendReq(paramString, paramBoolean1, paramBoolean2);
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool2 = this.s;
    int i1 = this.r;
    boolean bool1;
    Object localObject;
    if (i1 == -1)
    {
      bool1 = bool2;
      if (paramBoolean)
      {
        localObject = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.v, TempGetProfileDetailProcessor.class);
        bool1 = bool2;
        if (localObject != null)
        {
          ((TempGetProfileDetailProcessor)localObject).getCalReactiveSwitch();
          bool1 = bool2;
        }
      }
    }
    else if (i1 == 1)
    {
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getEnableReactive disableReactive");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append("IsDisableInteractive=");
      ((StringBuilder)localObject).append(this.r);
      QLog.d("FriendReactive", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  public boolean a(Friends[] paramArrayOfFriends, int paramInt)
  {
    if ((paramArrayOfFriends != null) && (paramArrayOfFriends.length != 0))
    {
      paramArrayOfFriends = new ArrayList(Arrays.asList(paramArrayOfFriends));
      return this.F.saveFriendList(paramArrayOfFriends);
    }
    return true;
  }
  
  public Friends b(String paramString)
  {
    return this.F.getFriend(paramString);
  }
  
  public NoC2CExtensionInfo b(String paramString, int paramInt, boolean paramBoolean)
  {
    String str = NoC2CExtensionInfo.getNoC2Ckey(paramInt, paramString);
    NoC2CExtensionInfo localNoC2CExtensionInfo = (NoC2CExtensionInfo)this.z.get(str);
    ??? = localNoC2CExtensionInfo;
    if (localNoC2CExtensionInfo == null)
    {
      ??? = localNoC2CExtensionInfo;
      if (paramBoolean)
      {
        ??? = localNoC2CExtensionInfo;
        if (!this.x)
        {
          paramString = (NoC2CExtensionInfo)this.w.find(NoC2CExtensionInfo.class, "type=? and uin=?", new String[] { String.valueOf(paramInt), paramString });
          ??? = paramString;
          if (paramString != null) {
            synchronized (this.z)
            {
              this.z.put(str, paramString);
              return paramString;
            }
          }
        }
      }
    }
    return ???;
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "init begin");
    }
    d();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "init end");
    }
  }
  
  public void b(int paramInt)
  {
    this.F.moveGroup(paramInt, 0);
  }
  
  public void b(Friends paramFriends)
  {
    this.F.saveFriend(paramFriends);
  }
  
  protected void b(String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      if (paramString1 == null) {
        return;
      }
      Friends localFriends = this.F.getFriend(paramString1, true, true, true);
      localFriends.alias = paramString2;
      localFriends.datetime = System.currentTimeMillis();
      if (paramString1.equals(this.v.getAccount()))
      {
        MobileQQ localMobileQQ = this.v.getApplication();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(Constants.PropertiesKey.uinDisplayName.toString());
        localStringBuilder.append(paramString1);
        localMobileQQ.setProperty(localStringBuilder.toString(), paramString2);
      }
      this.F.saveFriend(localFriends);
    }
  }
  
  public void b(List<ExtensionInfo> paramList)
  {
    c(paramList);
    this.G.saveExtensionInfoList(paramList);
    E();
  }
  
  public void b(boolean paramBoolean)
  {
    this.v.getApp().getSharedPreferences(this.v.getAccount(), 0).edit().putBoolean("show_vip_red_name", paramBoolean).commit();
    this.t = paramBoolean;
  }
  
  public boolean b(ExtensionInfo paramExtensionInfo)
  {
    if (paramExtensionInfo == null) {
      return false;
    }
    if (paramExtensionInfo.hiddenChatSwitch == 1)
    {
      ExtensionInfo localExtensionInfo = d(paramExtensionInfo.uin, false);
      if ((localExtensionInfo == null) || (paramExtensionInfo.hiddenChatSwitch != localExtensionInfo.hiddenChatSwitch))
      {
        RuntimeException localRuntimeException = new RuntimeException("isMaybeSingleExtensionDataError");
        localRuntimeException.fillInStackTrace();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("uin:");
        localStringBuilder.append(MobileQQ.getShortUinStr(paramExtensionInfo.uin));
        localStringBuilder.append("extensionInfo new.hiddenChatSwitch: ");
        localStringBuilder.append(paramExtensionInfo.hiddenChatSwitch);
        localStringBuilder.append(", old.hiddenChatSwitch: ");
        if (localExtensionInfo == null) {
          paramExtensionInfo = "null";
        } else {
          paramExtensionInfo = Integer.valueOf(localExtensionInfo.hiddenChatSwitch);
        }
        localStringBuilder.append(paramExtensionInfo);
        localStringBuilder.append(", isMaybeExtensionDataError():");
        QLog.d("Q.contacttab.extension", 1, localStringBuilder.toString(), localRuntimeException);
        return true;
      }
    }
    return false;
  }
  
  public boolean b(String paramString, boolean paramBoolean)
  {
    return ((IAddFriendServiceApi)this.v.getRuntimeService(IAddFriendServiceApi.class)).hasSendAddFriendReq(paramString, paramBoolean, false);
  }
  
  public Friends c(String paramString)
  {
    return this.F.getFriend(paramString, true);
  }
  
  public Friends c(String paramString1, String paramString2)
  {
    paramString1 = this.F.getFriend(paramString1, true, true, true);
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1.name = paramString2;
      paramString1.datetime = System.currentTimeMillis();
      this.F.saveFriendCache(paramString1);
    }
    return paramString1;
  }
  
  public String c(int paramInt)
  {
    return (String)this.u.get(String.valueOf(paramInt));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initExtensionInfoCache begin");
    }
    if (!this.x)
    {
      if (this.x) {
        return;
      }
      this.G.initCache();
      D();
    }
    try
    {
      C();
      label48:
      this.x = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label48;
    }
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    ((IAddFriendServiceApi)this.v.getRuntimeService(IAddFriendServiceApi.class)).setAddFriendReqStatus(paramString, paramBoolean);
  }
  
  public boolean c(List<ExtensionInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return false;
      }
      RuntimeException localRuntimeException = new RuntimeException("isMaybeListExtensionDataError");
      localRuntimeException.fillInStackTrace();
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramList = (ExtensionInfo)((Iterator)localObject).next();
        if (paramList.hiddenChatSwitch == 1)
        {
          ExtensionInfo localExtensionInfo = d(paramList.uin, false);
          if ((localExtensionInfo == null) || (paramList.hiddenChatSwitch != localExtensionInfo.hiddenChatSwitch))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("uin:");
            ((StringBuilder)localObject).append(MobileQQ.getShortUinStr(paramList.uin));
            ((StringBuilder)localObject).append("extensionInfo new.hiddenChatSwitch: ");
            ((StringBuilder)localObject).append(paramList.hiddenChatSwitch);
            ((StringBuilder)localObject).append(", old.hiddenChatSwitch: ");
            if (localExtensionInfo == null) {
              paramList = "null";
            } else {
              paramList = Integer.valueOf(localExtensionInfo.hiddenChatSwitch);
            }
            ((StringBuilder)localObject).append(paramList);
            ((StringBuilder)localObject).append(", isMaybeListExtensionDataError():");
            QLog.d("Q.contacttab.extension", 1, ((StringBuilder)localObject).toString(), localRuntimeException);
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public ExtensionInfo d(String paramString, boolean paramBoolean)
  {
    return this.G.getExtensionInfo(paramString, paramBoolean);
  }
  
  public Friends d(String paramString)
  {
    return b(paramString);
  }
  
  public Friends d(String paramString1, String paramString2)
  {
    Friends localFriends = this.F.getFriend(paramString1, true, true, true);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    if (!paramString1.equals(localFriends.remark))
    {
      localFriends.remark = paramString1;
      localFriends.datetime = System.currentTimeMillis();
      this.F.saveFriend(localFriends);
    }
    return localFriends;
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initGroupList begin");
    }
    this.F.initGroupCache();
  }
  
  /* Error */
  public void d(List<SpecialCareInfo> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +285 -> 286
    //   4: aload_1
    //   5: invokeinterface 313 1 0
    //   10: ifne +6 -> 16
    //   13: goto +273 -> 286
    //   16: aload_1
    //   17: invokeinterface 313 1 0
    //   22: iconst_1
    //   23: if_icmpne +18 -> 41
    //   26: aload_0
    //   27: aload_1
    //   28: iconst_0
    //   29: invokeinterface 978 2 0
    //   34: checkcast 628	com/tencent/mobileqq/data/SpecialCareInfo
    //   37: invokevirtual 1240	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/SpecialCareInfo;)V
    //   40: return
    //   41: aload_0
    //   42: getfield 96	com/tencent/mobileqq/app/FriendsManager:B	Ljava/util/concurrent/ConcurrentHashMap;
    //   45: astore_2
    //   46: aload_2
    //   47: ifnull +71 -> 118
    //   50: aload_2
    //   51: monitorenter
    //   52: aload_1
    //   53: invokeinterface 314 1 0
    //   58: astore_3
    //   59: aload_3
    //   60: invokeinterface 284 1 0
    //   65: ifeq +43 -> 108
    //   68: aload_3
    //   69: invokeinterface 288 1 0
    //   74: checkcast 628	com/tencent/mobileqq/data/SpecialCareInfo
    //   77: astore 4
    //   79: aload 4
    //   81: getfield 629	com/tencent/mobileqq/data/SpecialCareInfo:uin	Ljava/lang/String;
    //   84: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   87: ifne -28 -> 59
    //   90: aload_0
    //   91: getfield 96	com/tencent/mobileqq/app/FriendsManager:B	Ljava/util/concurrent/ConcurrentHashMap;
    //   94: aload 4
    //   96: getfield 629	com/tencent/mobileqq/data/SpecialCareInfo:uin	Ljava/lang/String;
    //   99: aload 4
    //   101: invokevirtual 305	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   104: pop
    //   105: goto -46 -> 59
    //   108: aload_2
    //   109: monitorexit
    //   110: goto +8 -> 118
    //   113: astore_1
    //   114: aload_2
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    //   118: aload_0
    //   119: getfield 172	com/tencent/mobileqq/app/FriendsManager:w	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   122: invokevirtual 925	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   125: astore_2
    //   126: aload_2
    //   127: invokevirtual 930	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   130: aload_1
    //   131: invokeinterface 314 1 0
    //   136: astore_1
    //   137: aload_1
    //   138: invokeinterface 284 1 0
    //   143: ifeq +78 -> 221
    //   146: aload_1
    //   147: invokeinterface 288 1 0
    //   152: checkcast 628	com/tencent/mobileqq/data/SpecialCareInfo
    //   155: astore_3
    //   156: aload_3
    //   157: getfield 629	com/tencent/mobileqq/data/SpecialCareInfo:uin	Ljava/lang/String;
    //   160: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   163: ifne -26 -> 137
    //   166: aload_0
    //   167: aload_3
    //   168: invokevirtual 625	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   171: pop
    //   172: invokestatic 210	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq -38 -> 137
    //   178: new 225	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   185: astore 4
    //   187: aload 4
    //   189: ldc_w 1242
    //   192: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 4
    //   198: aload_3
    //   199: invokevirtual 632	com/tencent/mobileqq/data/SpecialCareInfo:toString	()Ljava/lang/String;
    //   202: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: ldc_w 522
    //   209: iconst_2
    //   210: aload 4
    //   212: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 441	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: goto -81 -> 137
    //   221: aload_2
    //   222: invokevirtual 944	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   225: goto +50 -> 275
    //   228: astore_1
    //   229: goto +51 -> 280
    //   232: astore_1
    //   233: invokestatic 210	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   236: ifeq +39 -> 275
    //   239: new 225	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   246: astore_3
    //   247: aload_3
    //   248: ldc_w 1244
    //   251: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload_3
    //   256: aload_1
    //   257: invokevirtual 1247	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   260: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: ldc_w 350
    //   267: iconst_2
    //   268: aload_3
    //   269: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 441	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: aload_2
    //   276: invokevirtual 949	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   279: return
    //   280: aload_2
    //   281: invokevirtual 949	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   284: aload_1
    //   285: athrow
    //   286: invokestatic 210	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +13 -> 302
    //   292: ldc_w 522
    //   295: iconst_2
    //   296: ldc_w 1249
    //   299: invokestatic 441	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	FriendsManager
    //   0	303	1	paramList	List<SpecialCareInfo>
    //   45	236	2	localObject1	Object
    //   58	211	3	localObject2	Object
    //   77	134	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   52	59	113	finally
    //   59	105	113	finally
    //   108	110	113	finally
    //   114	116	113	finally
    //   130	137	228	finally
    //   137	218	228	finally
    //   221	225	228	finally
    //   233	275	228	finally
    //   130	137	232	java/lang/Exception
    //   137	218	232	java/lang/Exception
    //   221	225	232	java/lang/Exception
  }
  
  public Friends e(String paramString)
  {
    return this.F.getFriend(paramString, true, true, true);
  }
  
  /* Error */
  public void e(List<String> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +144 -> 145
    //   4: aload_1
    //   5: invokeinterface 313 1 0
    //   10: ifgt +4 -> 14
    //   13: return
    //   14: new 275	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 463	java/util/ArrayList:<init>	()V
    //   21: astore_3
    //   22: aload_0
    //   23: getfield 172	com/tencent/mobileqq/app/FriendsManager:w	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   26: invokevirtual 925	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 930	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   34: aload_1
    //   35: invokeinterface 314 1 0
    //   40: astore_1
    //   41: aload_1
    //   42: invokeinterface 284 1 0
    //   47: ifeq +63 -> 110
    //   50: aload_1
    //   51: invokeinterface 288 1 0
    //   56: checkcast 219	java/lang/String
    //   59: astore 4
    //   61: aload_0
    //   62: getfield 184	com/tencent/mobileqq/app/FriendsManager:F	Lcom/tencent/mobileqq/friend/api/IFriendDataService;
    //   65: aload 4
    //   67: invokeinterface 582 2 0
    //   72: astore 5
    //   74: aload 5
    //   76: ifnull -35 -> 41
    //   79: aload 5
    //   81: getfield 444	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   84: ifeq +10 -> 94
    //   87: aload_3
    //   88: aload 4
    //   90: invokevirtual 487	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   93: pop
    //   94: aload 5
    //   96: iconst_0
    //   97: putfield 444	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   100: aload_0
    //   101: aload 5
    //   103: invokevirtual 932	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   106: pop
    //   107: goto -66 -> 41
    //   110: aload_2
    //   111: invokevirtual 944	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   114: goto +12 -> 126
    //   117: astore_1
    //   118: goto +21 -> 139
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 1013	java/lang/Exception:printStackTrace	()V
    //   126: aload_2
    //   127: invokevirtual 949	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   130: aload_0
    //   131: getfield 164	com/tencent/mobileqq/app/FriendsManager:v	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   134: aload_3
    //   135: invokestatic 1253	com/tencent/mobileqq/activity/aio/tips/GatherContactsTipsHelper:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;)V
    //   138: return
    //   139: aload_2
    //   140: invokevirtual 949	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   143: aload_1
    //   144: athrow
    //   145: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	FriendsManager
    //   0	146	1	paramList	List<String>
    //   29	111	2	localEntityTransaction	EntityTransaction
    //   21	114	3	localArrayList	ArrayList
    //   59	30	4	str	String
    //   72	30	5	localFriends	Friends
    // Exception table:
    //   from	to	target	type
    //   30	41	117	finally
    //   41	74	117	finally
    //   79	94	117	finally
    //   94	107	117	finally
    //   110	114	117	finally
    //   122	126	117	finally
    //   30	41	121	java/lang/Exception
    //   41	74	121	java/lang/Exception
    //   79	94	121	java/lang/Exception
    //   94	107	121	java/lang/Exception
    //   110	114	121	java/lang/Exception
  }
  
  public boolean e()
  {
    this.F.initFriendCache();
    Object localObject = this.F.getAllFriends();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Friends localFriends = (Friends)((Iterator)localObject).next();
        QidianManager.a(this.v, localFriends);
      }
    }
    return true;
  }
  
  public Card f(String paramString)
  {
    return ((IProfileDataService)this.v.getRuntimeService(IProfileDataService.class, "all")).getProfileCard(paramString, false);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initSpecialCareInfoCache begin");
    }
    if (!this.y.get())
    {
      Object localObject2 = (ArrayList)this.w.query(SpecialCareInfo.class, false, "globalSwitch!=?", new String[] { "0" }, null, null, null, null);
      if (localObject2 != null) {
        synchronized (this.B)
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            SpecialCareInfo localSpecialCareInfo = (SpecialCareInfo)((Iterator)localObject2).next();
            if ((localSpecialCareInfo != null) && (localSpecialCareInfo.uin != null)) {
              this.B.put(localSpecialCareInfo.uin, localSpecialCareInfo);
            }
          }
        }
      }
      this.y.set(true);
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("initSpecialCareInfoCache end: ");
      ((StringBuilder)???).append(this.B.size());
      QLog.d("Q.contacttab.friend", 2, ((StringBuilder)???).toString());
    }
  }
  
  /* Error */
  public void f(List<String> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +253 -> 254
    //   4: aload_1
    //   5: invokeinterface 313 1 0
    //   10: ifgt +4 -> 14
    //   13: return
    //   14: new 275	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 463	java/util/ArrayList:<init>	()V
    //   21: astore 5
    //   23: aload_0
    //   24: getfield 172	com/tencent/mobileqq/app/FriendsManager:w	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   27: invokevirtual 925	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   30: astore 4
    //   32: aload 4
    //   34: invokevirtual 930	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   37: aload_1
    //   38: invokeinterface 314 1 0
    //   43: astore_1
    //   44: aload_1
    //   45: invokeinterface 284 1 0
    //   50: ifeq +165 -> 215
    //   53: aload_1
    //   54: invokeinterface 288 1 0
    //   59: checkcast 219	java/lang/String
    //   62: astore 7
    //   64: aload_0
    //   65: getfield 184	com/tencent/mobileqq/app/FriendsManager:F	Lcom/tencent/mobileqq/friend/api/IFriendDataService;
    //   68: aload 7
    //   70: invokeinterface 582 2 0
    //   75: astore 6
    //   77: aload 6
    //   79: ifnonnull +6 -> 85
    //   82: goto -38 -> 44
    //   85: aload 6
    //   87: getfield 444	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   90: istore_3
    //   91: iconst_2
    //   92: istore_2
    //   93: iload_3
    //   94: iconst_2
    //   95: if_icmpeq +11 -> 106
    //   98: aload 6
    //   100: getfield 444	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   103: ifne -59 -> 44
    //   106: aload 6
    //   108: getfield 444	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   111: ifne +14 -> 125
    //   114: aload 6
    //   116: ldc_w 1271
    //   119: invokestatic 1073	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   122: putfield 940	com/tencent/mobileqq/data/Friends:recommReason	Ljava/lang/String;
    //   125: aload 6
    //   127: getfield 444	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   130: iconst_1
    //   131: if_icmpeq +11 -> 142
    //   134: aload 5
    //   136: aload 7
    //   138: invokevirtual 487	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   141: pop
    //   142: aload 6
    //   144: iconst_1
    //   145: putfield 444	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   148: aload_0
    //   149: aload 6
    //   151: getfield 320	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   154: invokevirtual 1076	com/tencent/mobileqq/app/FriendsManager:f	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   157: astore 7
    //   159: aload 7
    //   161: ifnull +44 -> 205
    //   164: aload 7
    //   166: getfield 1082	com/tencent/mobileqq/data/Card:shGender	S
    //   169: ifne +8 -> 177
    //   172: iconst_1
    //   173: istore_2
    //   174: goto +15 -> 189
    //   177: aload 7
    //   179: getfield 1082	com/tencent/mobileqq/data/Card:shGender	S
    //   182: iconst_1
    //   183: if_icmpne +72 -> 255
    //   186: goto +3 -> 189
    //   189: aload 6
    //   191: iload_2
    //   192: putfield 855	com/tencent/mobileqq/data/Friends:gender	B
    //   195: aload 6
    //   197: aload 7
    //   199: getfield 1084	com/tencent/mobileqq/data/Card:age	B
    //   202: putfield 858	com/tencent/mobileqq/data/Friends:age	I
    //   205: aload_0
    //   206: aload 6
    //   208: invokevirtual 932	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   211: pop
    //   212: goto -168 -> 44
    //   215: aload 4
    //   217: invokevirtual 944	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   220: goto +12 -> 232
    //   223: astore_1
    //   224: goto +23 -> 247
    //   227: astore_1
    //   228: aload_1
    //   229: invokevirtual 1013	java/lang/Exception:printStackTrace	()V
    //   232: aload 4
    //   234: invokevirtual 949	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   237: aload_0
    //   238: getfield 164	com/tencent/mobileqq/app/FriendsManager:v	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   241: aload 5
    //   243: invokestatic 1273	com/tencent/mobileqq/activity/aio/tips/GatherContactsTipsHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;)V
    //   246: return
    //   247: aload 4
    //   249: invokevirtual 949	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   252: aload_1
    //   253: athrow
    //   254: return
    //   255: iconst_0
    //   256: istore_2
    //   257: goto -68 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	this	FriendsManager
    //   0	260	1	paramList	List<String>
    //   92	165	2	b1	byte
    //   90	6	3	i1	int
    //   30	218	4	localEntityTransaction	EntityTransaction
    //   21	221	5	localArrayList	ArrayList
    //   75	132	6	localFriends	Friends
    //   62	136	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   32	44	223	finally
    //   44	77	223	finally
    //   85	91	223	finally
    //   98	106	223	finally
    //   106	125	223	finally
    //   125	142	223	finally
    //   142	159	223	finally
    //   164	172	223	finally
    //   177	186	223	finally
    //   189	205	223	finally
    //   205	212	223	finally
    //   215	220	223	finally
    //   228	232	223	finally
    //   32	44	227	java/lang/Exception
    //   44	77	227	java/lang/Exception
    //   85	91	227	java/lang/Exception
    //   98	106	227	java/lang/Exception
    //   106	125	227	java/lang/Exception
    //   125	142	227	java/lang/Exception
    //   142	159	227	java/lang/Exception
    //   164	172	227	java/lang/Exception
    //   177	186	227	java/lang/Exception
    //   189	205	227	java/lang/Exception
    //   205	212	227	java/lang/Exception
    //   215	220	227	java/lang/Exception
  }
  
  public Card g(String paramString)
  {
    return ((IProfileDataService)this.v.getRuntimeService(IProfileDataService.class, "all")).getProfileCard(paramString, true);
  }
  
  public ArrayList<Friends> g()
  {
    Object localObject = this.F.getAllFriends();
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
  
  public void g(List<cmd0x7c4.RecommendReason> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (cmd0x7c4.RecommendReason)paramList.next();
        String str = String.valueOf(((cmd0x7c4.RecommendReason)localObject).uint32_reason_id.get());
        localObject = ((cmd0x7c4.RecommendReason)localObject).bytes_recommend_reason.get().toStringUtf8();
        this.u.put(str, localObject);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("key : ");
          localStringBuilder.append(str);
          localStringBuilder.append(" ; reason : ");
          localStringBuilder.append((String)localObject);
          QLog.i("FriendListHandler", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public Card h(String paramString)
  {
    return ((IProfileDataService)this.v.getRuntimeService(IProfileDataService.class, "all")).getProfileCardFromCache(paramString);
  }
  
  @UiThread
  public List<Groups> h()
  {
    return this.F.asyncGetGroupList(new FriendsManager.3(this));
  }
  
  public KplCard i(String paramString)
  {
    long l1;
    if (StatisticCollector.getSqliteSwitchBySample(7)) {
      l1 = SystemClock.uptimeMillis();
    } else {
      l1 = 0L;
    }
    paramString = (KplCard)this.w.find(KplCard.class, paramString);
    if (l1 != 0L) {
      a(SystemClock.uptimeMillis() - l1, false, "query", "Card");
    }
    if (paramString != null) {
      paramString.transStringToList();
    }
    if ((QLog.isColorLevel()) && (paramString != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("findFriendCardByUin qqNick=");
      localStringBuilder.append(paramString.qqNick);
      localStringBuilder.append(",gameNick=");
      localStringBuilder.append(paramString.gameNick);
      localStringBuilder.append(",uin = ");
      localStringBuilder.append(paramString.uin);
      QLog.d("Q.contacttab.", 2, localStringBuilder.toString());
    }
    return paramString;
  }
  
  public List<Groups> i()
  {
    return this.F.getGroupList();
  }
  
  public List<Friends> j()
  {
    return this.F.getAllFriends();
  }
  
  public void j(String paramString)
  {
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramString)) && (paramString.length() > 3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("add friend to black list ");
      ((StringBuilder)localObject).append(paramString.substring(0, 2));
      QLog.d("Q.contacttab.", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.I;
    if (localObject != null) {
      ((ConcurrentHashMap)localObject).put(paramString, "");
    }
    this.F.moveFriendToNewGroup(paramString, -1002);
  }
  
  public List<Groups> k()
  {
    return this.F.getGroupList();
  }
  
  public boolean k(String paramString)
  {
    if (this.I == null)
    {
      this.I = new ConcurrentHashMap();
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "initBlackList begin");
      }
      Object localObject = this.w.query(Groups.class, false, "group_id=?", new String[] { "-1002" }, null, null, null, null);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Friends localFriends = (Friends)((Iterator)localObject).next();
          this.I.put(localFriends.uin, "");
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initBlackList end, size=");
        ((StringBuilder)localObject).append(this.I.size());
        QLog.d("Q.contacttab.friend", 2, ((StringBuilder)localObject).toString());
      }
    }
    return this.I.containsKey(paramString);
  }
  
  public void l(String paramString)
  {
    ConcurrentHashMap localConcurrentHashMap = this.I;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.remove(paramString);
    }
    this.F.moveFriendToNewGroup(paramString, -1);
  }
  
  public boolean l()
  {
    List localList1 = this.F.getAllFriends();
    List localList2 = this.F.getGroupList();
    int i1;
    if (localList1 != null) {
      i1 = localList1.size();
    } else {
      i1 = 0;
    }
    return (localList2 != null) && ((i1 > 0) || (localList2.size() > 0));
  }
  
  public Friends m(String paramString)
  {
    if (!B(paramString)) {
      return null;
    }
    return this.F.getFriend(paramString, true, true);
  }
  
  public boolean m()
  {
    return this.x;
  }
  
  public List<SpecialCareInfo> n()
  {
    if ((this.y.get()) && (this.B != null))
    {
      ArrayList localArrayList = new ArrayList();
      synchronized (this.B)
      {
        Iterator localIterator = this.B.values().iterator();
        while (localIterator.hasNext())
        {
          SpecialCareInfo localSpecialCareInfo = (SpecialCareInfo)localIterator.next();
          if (localSpecialCareInfo.globalSwitch != 0) {
            localArrayList.add((SpecialCareInfo)localSpecialCareInfo.clone());
          }
        }
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("getSpecailCareInfos: size=");
          ((StringBuilder)???).append(localArrayList.size());
          QLog.d("Q.contacttab.friend", 2, ((StringBuilder)???).toString());
        }
        return localArrayList;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "getSpecailCareInfos isSpecialCareInfoCacheInited is false or specailCareInfoCache is null");
    }
    return null;
  }
  
  public boolean n(String paramString)
  {
    return this.F.isFriend(paramString);
  }
  
  public List<SpecialCareInfo> o()
  {
    List localList = n();
    if (localList != null) {
      Collections.sort(localList, new FriendsManager.4(this));
    }
    return localList;
  }
  
  public boolean o(String paramString)
  {
    return this.F.isFriend(paramString, false);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "FriendsManager onDestory");
    }
    this.w.close();
  }
  
  public int p(String paramString)
  {
    paramString = c(paramString);
    if ((paramString != null) && (paramString.isFriend())) {
      return paramString.friendType;
    }
    return 0;
  }
  
  public boolean p()
  {
    return this.y.get();
  }
  
  public String q(String paramString)
  {
    Friends localFriends = m(paramString);
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
  
  public void q()
  {
    try
    {
      boolean bool = this.J;
      if (bool) {
        return;
      }
      l1 = System.currentTimeMillis();
      localObject1 = null;
      i2 = 0;
    }
    finally
    {
      long l1;
      Object localObject1;
      int i2;
      Object localObject3;
      label152:
      for (;;)
      {
        label70:
        throw localObject2;
      }
    }
    try
    {
      localObject3 = (ArrayList)this.w.query(NearbyPeopleCard.class, false, "lastUpdateNickTime>?", new String[] { "0" }, null, null, "_id desc", String.valueOf(100));
      localObject1 = localObject3;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label70;
      i1 += 1;
      break label152;
    }
    this.w.drop(NearbyPeopleCard.class.getSimpleName());
    if (QLog.isColorLevel())
    {
      if (localObject1 == null) {
        i1 = 0;
      } else {
        i1 = ((ArrayList)localObject1).size();
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("nearby people card count = ");
      ((StringBuilder)localObject3).append(i1);
      QLog.d("Q.contacttab.", 2, ((StringBuilder)localObject3).toString());
    }
    i1 = i2;
    if (localObject1 == null) {
      return;
    }
    if (i1 < ((ArrayList)localObject1).size())
    {
      localObject3 = (NearbyPeopleCard)((ArrayList)localObject1).get(i1);
      if (localObject3 != null) {
        a((NearbyPeopleCard)localObject3);
      }
    }
    else
    {
      this.J = true;
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initDateNickNameCache cost time:");
        ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
        QLog.d("Q.contacttab.", 4, ((StringBuilder)localObject1).toString());
      }
      return;
    }
  }
  
  public int r(String paramString)
  {
    paramString = m(paramString);
    if (paramString != null) {
      return paramString.detalStatusFlag;
    }
    return 10;
  }
  
  public EntityTransaction r()
  {
    return this.w.getTransaction();
  }
  
  public void s()
  {
    Object localObject = this.M;
    String str;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        ArrayList localArrayList = this.L;
        if ((localArrayList != null) && (localArrayList.contains(str))) {
          this.L.remove(str);
        } else {
          GatherContactsTipsHelper.a(this.v, str);
        }
      }
    }
    localObject = this.L;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        GatherContactsTipsHelper.c(this.v, str);
      }
    }
    this.L = null;
    this.M = null;
  }
  
  public void s(String paramString)
  {
    this.F.deleteFriend(paramString);
    if (QvipSpecialCareUtil.d(paramString, this.v)) {
      QvipSpecialCareUtil.b(paramString, this.v);
    }
    if (QvipSpecialCareUtil.e(paramString, this.v)) {
      QvipSpecialCareUtil.c(paramString, this.v);
    }
    z(paramString);
    paramString = x(paramString);
    if (paramString != null)
    {
      ExtensionMutualMarkData.c(paramString);
      a(paramString);
    }
  }
  
  public ArrayList<Friends> t(String paramString)
  {
    try
    {
      paramString = (ArrayList)this.F.getFriendList(Integer.parseInt(paramString));
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return new ArrayList();
  }
  
  public ConcurrentHashMap<String, ArrayList<Entity>> t()
  {
    return c(false);
  }
  
  public int u()
  {
    return this.F.getFriendCount();
  }
  
  public Groups u(String paramString)
  {
    try
    {
      paramString = this.F.getGroup(Integer.parseInt(paramString), true);
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public int v()
  {
    List localList = this.F.getAllFriends(true);
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public boolean v(String paramString)
  {
    return ((IAddFriendServiceApi)this.v.getRuntimeService(IAddFriendServiceApi.class)).hasSendAddFriendReq(paramString, false);
  }
  
  public int w()
  {
    Object localObject = this.F.getAllFriends().iterator();
    int i1 = 0;
    while (((Iterator)localObject).hasNext()) {
      if (((Friends)((Iterator)localObject).next()).gathtertype == 1) {
        i1 += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getGatheredFriendsCount| gatherFriendCount: ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("Q.contacttab.", 2, ((StringBuilder)localObject).toString());
    }
    return i1;
  }
  
  public boolean w(String paramString)
  {
    paramString = m(paramString);
    if (paramString != null) {
      return paramString.isShield();
    }
    return false;
  }
  
  public ExtensionInfo x(String paramString)
  {
    return d(paramString, true);
  }
  
  public ArrayList<Entity> x()
  {
    new ConcurrentHashMap(4);
    ConcurrentHashMap localConcurrentHashMap = c(true);
    ArrayList localArrayList = new ArrayList(16);
    Object localObject = this.F.getGroupList();
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
  
  public SpecialCareInfo y(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject = null;
    SpecialCareInfo localSpecialCareInfo = null;
    if (!bool)
    {
      if (!this.y.get()) {
        return null;
      }
      localObject = this.B;
      if (localObject != null) {
        try
        {
          localSpecialCareInfo = (SpecialCareInfo)this.B.get(paramString);
        }
        finally {}
      }
      localObject = localSpecialCareInfo;
      if (localSpecialCareInfo != null) {
        return (SpecialCareInfo)localSpecialCareInfo.clone();
      }
    }
    return localObject;
  }
  
  public boolean y()
  {
    return this.v.getApp().getSharedPreferences(this.v.getAccount(), 0).getBoolean("show_vip_red_name", true);
  }
  
  public AddFrdStateMng z()
  {
    if (!this.C.c) {
      ThreadManager.excute(new FriendsManager.6(this), 16, null, true);
    }
    return this.C;
  }
  
  public void z(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("deleteSpecialCareInfo: uin=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("Q.contacttab.friend", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = null;
    Object localObject2 = this.B;
    if (localObject2 != null) {
      try
      {
        localObject1 = (SpecialCareInfo)this.B.remove(paramString);
      }
      finally {}
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = (SpecialCareInfo)this.w.find(SpecialCareInfo.class, paramString);
    }
    if (localObject2 != null)
    {
      long l1;
      if (StatisticCollector.getSqliteSwitchBySample(10)) {
        l1 = SystemClock.uptimeMillis();
      } else {
        l1 = 0L;
      }
      this.w.remove((Entity)localObject2);
      if (l1 != 0L) {
        a(SystemClock.uptimeMillis() - l1, false, "delete", "SpecialCare");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendsManager
 * JD-Core Version:    0.7.0.1
 */