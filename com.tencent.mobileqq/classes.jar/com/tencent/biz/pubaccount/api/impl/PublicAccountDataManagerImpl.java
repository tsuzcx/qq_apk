package com.tencent.biz.pubaccount.api.impl;

import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.PublicRecommendAccountInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.PAOfflineSearchManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class PublicAccountDataManagerImpl
  implements IPublicAccountDataManager, Manager
{
  private static final int GET_KANDIAN_SCENE_AFTER_MSG = 1;
  private static final int GET_KANDIAN_SCENE_AFTER_MSG_NOTIFY = 2;
  private static final int GET_KANDIAN_SCENE_PROTECT = 3;
  public static final String TAG = "Q.contacttab.pub";
  private static volatile boolean sAfterMsgSync = false;
  private static final LinkedList<PublicAccountDataManagerImpl.OnAfterMsgSyncListener> sAfterMsgSyncListeners = new LinkedList();
  QQAppInterface app;
  public boolean cached = false;
  private EntityManager em;
  private LruCache<String, PublicAccountDetailImpl> mAccountDetailCache;
  private volatile boolean mIsBuildingList;
  private PublicAccountDataManagerImpl.OnAfterMsgSyncListener mOnAfterMsgSyncListener;
  private ConcurrentHashMap<String, PublicAccountInfo> mPublicAccountCache;
  ArrayList<Entity> mPublicAccountList = new ArrayList();
  private int maxSize = 50;
  private HashMap<Long, Long> noCacheUin = new HashMap();
  ArrayList<Entity> publicAccountList = new ArrayList();
  ArrayList<PublicRecommendAccountInfo> publicRecommendAccountList = new ArrayList();
  
  private static void addOnAfterMsgSyncListener(PublicAccountDataManagerImpl.OnAfterMsgSyncListener paramOnAfterMsgSyncListener)
  {
    LinkedList localLinkedList = sAfterMsgSyncListeners;
    if (paramOnAfterMsgSyncListener != null) {}
    try
    {
      sAfterMsgSyncListeners.add(paramOnAfterMsgSyncListener);
      return;
    }
    finally {}
  }
  
  private boolean canUnfollow(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    PublicAccountDetailImpl localPublicAccountDetailImpl = (PublicAccountDetailImpl)findAccountDetailInfoCache(paramString);
    if ((localPublicAccountDetailImpl != null) && (!localPublicAccountDetailImpl.isShowFollowButton)) {
      return false;
    }
    return (localPublicAccountDetailImpl != null) || (!"1770946116".equals(paramString));
  }
  
  private void doGetKandianSubscribeAccountInfo(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doGetKandianSubscribeAccountInfo ");
    localStringBuilder.append(paramInt);
    QLog.d("Q.contacttab.pub", 2, localStringBuilder.toString());
    ThreadManager.executeOnSubThread(new PublicAccountDataManagerImpl.5(this));
  }
  
  private void getKandianSubscribeAccountInfo()
  {
    if (sAfterMsgSync)
    {
      doGetKandianSubscribeAccountInfo(1);
      return;
    }
    this.mOnAfterMsgSyncListener = new PublicAccountDataManagerImpl.3(this);
    addOnAfterMsgSyncListener(this.mOnAfterMsgSyncListener);
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountDataManagerImpl.4(this), 10000L);
  }
  
  private static void notifyOnAfterMsgSync()
  {
    ThreadManager.executeOnSubThread(new PublicAccountDataManagerImpl.2());
  }
  
  private static boolean removeOnAfterMsgSyncListener(PublicAccountDataManagerImpl.OnAfterMsgSyncListener paramOnAfterMsgSyncListener)
  {
    localLinkedList = sAfterMsgSyncListeners;
    if (paramOnAfterMsgSyncListener != null) {}
    try
    {
      boolean bool = sAfterMsgSyncListeners.remove(paramOnAfterMsgSyncListener);
      return bool;
    }
    finally {}
    return false;
  }
  
  public static void setAfterMsgSync()
  {
    if (!sAfterMsgSync) {
      notifyOnAfterMsgSync();
    }
    sAfterMsgSync = true;
  }
  
  public void buildPublicAccountUI()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.pub", 2, "buildPublicAccountUI begin");
      }
      this.mIsBuildingList = true;
      Object localObject1;
      if (this.mPublicAccountCache != null)
      {
        int i = this.mPublicAccountCache.size();
        localObject1 = new ArrayList(i);
        ArrayList localArrayList1 = new ArrayList(i);
        ArrayList localArrayList2 = new ArrayList(i);
        Iterator localIterator = this.mPublicAccountCache.values().iterator();
        while (localIterator.hasNext())
        {
          Entity localEntity = (Entity)localIterator.next();
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localEntity;
          if ((localPublicAccountInfo.mCompareSpell == null) || (localPublicAccountInfo.mCompareSpell.length() == 0)) {
            ContactSorter.a(localPublicAccountInfo);
          }
          if (localPublicAccountInfo.hasIvrAbility()) {
            localArrayList1.add(localEntity);
          } else {
            localArrayList2.add(localEntity);
          }
        }
        if (localArrayList1.size() > 0)
        {
          if (localArrayList1.size() > 1) {
            Collections.sort(localArrayList1, ContactSorter.a);
          }
          ((ArrayList)localObject1).addAll(localArrayList1);
        }
        if (localArrayList2.size() > 0)
        {
          if (localArrayList2.size() > 1) {
            Collections.sort(localArrayList2, ContactSorter.a);
          }
          ((ArrayList)localObject1).addAll(localArrayList2);
        }
        this.publicAccountList = ((ArrayList)localObject1);
        if (((ArrayList)localObject1).size() > 1) {
          Collections.sort((List)localObject1, ContactSorter.a);
        }
        this.mPublicAccountList = ((ArrayList)localObject1);
        PAOfflineSearchManager.a().a = true;
      }
      this.mIsBuildingList = false;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("buildPublicAccountUI end: ");
        ((StringBuilder)localObject1).append(this.publicAccountList.size());
        QLog.d("Q.contacttab.pub", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void decodeMessageRecord(ArrayList<MessageRecord> paramArrayList, AppInterface paramAppInterface)
  {
    Object localObject = new ArrayList();
    if (paramArrayList.size() > 0)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
        try
        {
          long l = Long.parseLong(localMessageRecord.senderuin);
          if (((l != 9954L) || (localMessageRecord.istroop != 7220)) && (localMessageRecord.istroop == 1008) && (!((ArrayList)localObject).contains(Long.valueOf(l)))) {
            ((ArrayList)localObject).add(Long.valueOf(l));
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          label111:
          break label111;
        }
      }
    }
    paramArrayList = ((ArrayList)localObject).iterator();
    while (paramArrayList.hasNext())
    {
      localObject = (Long)paramArrayList.next();
      if (((PublicAccountInfo)findPublicAccountInfo(((Long)localObject).toString()) == null) && ((PublicAccountDetailImpl)findAccountDetailInfo(((Long)localObject).toString()) == null) && ((this.noCacheUin.get(localObject) == null) || ((this.noCacheUin.get(localObject) != null) && (System.currentTimeMillis() - ((Long)this.noCacheUin.get(localObject)).longValue() > 120000L))))
      {
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getPublicAccountDetailRequest(paramAppInterface, BaseApplication.getContext(), null, ((Long)localObject).toString());
        this.noCacheUin.put(localObject, Long.valueOf(System.currentTimeMillis()));
      }
    }
  }
  
  public void delAccountDetailInfoCache(String paramString)
  {
    if (this.mAccountDetailCache == null) {
      this.mAccountDetailCache = new LruCache(this.maxSize);
    }
    PublicAccountDetailImpl localPublicAccountDetailImpl = (PublicAccountDetailImpl)findAccountDetailInfo(paramString);
    if (localPublicAccountDetailImpl != null)
    {
      this.mAccountDetailCache.remove(paramString);
      this.em.remove(localPublicAccountDetailImpl);
    }
  }
  
  public void delPublicAccountInfo(String paramString)
  {
    if (this.mPublicAccountCache == null) {
      this.mPublicAccountCache = new ConcurrentHashMap();
    }
    PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)findPublicAccountInfo(paramString);
    if (localPublicAccountInfo != null)
    {
      this.mPublicAccountCache.remove(paramString);
      this.em.remove(localPublicAccountInfo);
    }
    buildPublicAccountUI();
  }
  
  public void delPublicAccountInfoCache(String paramString)
  {
    if (this.mPublicAccountCache == null) {
      this.mPublicAccountCache = new ConcurrentHashMap();
    }
    if ((PublicAccountInfo)findPublicAccountInfo(paramString) != null)
    {
      this.mPublicAccountCache.remove(paramString);
      buildPublicAccountUI();
    }
  }
  
  public IPublicAccountDetail findAccountDetailInfo(String paramString)
  {
    Object localObject = this.mAccountDetailCache;
    if ((localObject != null) && (paramString != null))
    {
      PublicAccountDetailImpl localPublicAccountDetailImpl = (PublicAccountDetailImpl)((LruCache)localObject).get(paramString);
      localObject = localPublicAccountDetailImpl;
      if (localPublicAccountDetailImpl == null)
      {
        EntityManager localEntityManager = this.em;
        localObject = localPublicAccountDetailImpl;
        if (localEntityManager != null)
        {
          paramString = (PublicAccountDetailImpl)localEntityManager.find(PublicAccountDetailImpl.class, paramString);
          localObject = paramString;
          if (paramString != null)
          {
            this.mAccountDetailCache.put(paramString.uin, paramString);
            return paramString;
          }
        }
      }
    }
    else
    {
      localObject = null;
    }
    return localObject;
  }
  
  public IPublicAccountDetail findAccountDetailInfoCache(String paramString)
  {
    Object localObject = this.mAccountDetailCache;
    if ((localObject != null) && (paramString != null)) {
      localObject = (PublicAccountDetailImpl)((LruCache)localObject).get(paramString);
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ThreadManager.executeOnSubThread(new PublicAccountDataManagerImpl.7(this, paramString));
    }
    return localObject;
  }
  
  public Object findPublicAccountInfo(String paramString)
  {
    return findPublicAccountInfo(paramString, false);
  }
  
  public Object findPublicAccountInfo(String paramString, boolean paramBoolean)
  {
    Object localObject1 = this.mPublicAccountCache;
    if ((localObject1 != null) && (paramString != null))
    {
      Object localObject2 = (PublicAccountInfo)((ConcurrentHashMap)localObject1).get(paramString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        EntityManager localEntityManager = this.em;
        localObject1 = localObject2;
        if (localEntityManager != null)
        {
          paramString = (PublicAccountInfo)localEntityManager.find(PublicAccountInfo.class, paramString);
          localObject1 = paramString;
          if (paramString != null)
          {
            localObject2 = this.mPublicAccountCache;
            localObject1 = paramString;
            if (localObject2 != null)
            {
              ((ConcurrentHashMap)localObject2).put(paramString.getUin(), paramString);
              return paramString;
            }
          }
        }
      }
    }
    else
    {
      if ((this.mPublicAccountCache == null) && (paramBoolean)) {
        return (PublicAccountInfo)this.em.find(PublicAccountInfo.class, paramString);
      }
      localObject1 = null;
    }
    return localObject1;
  }
  
  public Object findPublicAccountInfoCache(String paramString)
  {
    ConcurrentHashMap localConcurrentHashMap = this.mPublicAccountCache;
    if ((localConcurrentHashMap != null) && (paramString != null)) {
      return (PublicAccountInfo)localConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public Object getAccountInfo(String paramString)
  {
    return this.mPublicAccountCache.get(paramString);
  }
  
  public Object getPublicAccountEqqInfoList()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.mPublicAccountCache;
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((ConcurrentHashMap)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add((PublicAccountInfo)((Map.Entry)((Iterator)localObject).next()).getValue());
    }
    return localArrayList;
  }
  
  public ArrayList<Entity> getPublicAccountList()
  {
    return this.publicAccountList;
  }
  
  public ArrayList<Entity> getPublicAccountListNotIVR()
  {
    return this.mPublicAccountList;
  }
  
  public Object getPublicAccountScriptList()
  {
    Object localObject = this.mPublicAccountCache;
    if (localObject != null)
    {
      localObject = new ArrayList(((ConcurrentHashMap)localObject).size());
      Iterator localIterator = this.mPublicAccountCache.values().iterator();
      while (localIterator.hasNext())
      {
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localIterator.next();
        if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isSubscript(localPublicAccountInfo.accountFlag, localPublicAccountInfo.accountFlag2)) {
          ((ArrayList)localObject).add(localPublicAccountInfo);
        }
      }
      return localObject;
    }
    return new ArrayList(0);
  }
  
  public Object getPublicRecommendAccountList()
  {
    return this.publicRecommendAccountList;
  }
  
  public void initAccountDetailCache()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.pub", 2, "initAccountDetailCache begin");
    }
    Object localObject = this.em.query(PublicAccountDetailImpl.class);
    this.mAccountDetailCache = new LruCache(this.maxSize);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PublicAccountDetailImpl localPublicAccountDetailImpl = (PublicAccountDetailImpl)((Iterator)localObject).next();
        if ((localPublicAccountDetailImpl != null) && (localPublicAccountDetailImpl.uin != null)) {
          this.mAccountDetailCache.put(localPublicAccountDetailImpl.uin, localPublicAccountDetailImpl);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initAccountDetailCache end: ");
      ((StringBuilder)localObject).append(this.mAccountDetailCache.size());
      QLog.d("Q.contacttab.pub", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void initPublicAccountCache()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.pub", 2, "initPublicAccountCache begin");
    }
    Object localObject1 = this.em;
    int j = 0;
    Object localObject3 = ((EntityManager)localObject1).query(PublicAccountInfo.class, false, "showFlag=?", new String[] { String.valueOf(1) }, null, null, null, null);
    int i;
    if (localObject3 != null) {
      i = ((List)localObject3).size();
    } else {
      i = 0;
    }
    this.mPublicAccountCache = new ConcurrentHashMap(i);
    if (localObject3 != null)
    {
      localObject1 = new ArrayList();
      long l = NetConnInfoCenter.getServerTimeMillis();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject3).next();
        if (localPublicAccountInfo.isNeedShow())
        {
          if ((!((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isDeleteOldKandian(this.app)) || (!TextUtils.equals(localPublicAccountInfo.getUin(), AppConstants.OLD_KANDIAN_UIN))) {
            this.mPublicAccountCache.put(localPublicAccountInfo.getUin(), localPublicAccountInfo);
          }
        }
        else
        {
          if ((localPublicAccountInfo.mCompareSpell == null) || (localPublicAccountInfo.mCompareSpell.length() == 0))
          {
            ContactSorter.a(localPublicAccountInfo);
            ((ArrayList)localObject1).add(localPublicAccountInfo);
          }
          if (localPublicAccountInfo.lastAIOReadTime <= 0L)
          {
            if (((ArrayList)localObject1).contains(localPublicAccountInfo)) {
              ((ArrayList)localObject1).remove(localPublicAccountInfo);
            }
            localPublicAccountInfo.lastAIOReadTime = l;
            ((ArrayList)localObject1).add(localPublicAccountInfo);
          }
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject3 = this.em.getTransaction();
        ((EntityTransaction)localObject3).begin();
        i = j;
      }
    }
    try
    {
      try
      {
        while (i < ((ArrayList)localObject1).size())
        {
          updateEntity((Entity)((ArrayList)localObject1).get(i));
          i += 1;
        }
      }
      finally
      {
        ((EntityTransaction)localObject3).end();
      }
    }
    catch (Exception localException)
    {
      label340:
      StringBuilder localStringBuilder;
      break label340;
    }
    ((EntityTransaction)localObject3).end();
    localObject2.clear();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initPublicAccountCache end: ");
      localStringBuilder.append(this.mPublicAccountCache.size());
      QLog.d("Q.contacttab.pub", 2, localStringBuilder.toString());
    }
  }
  
  public void initPublicAccountDataManager()
  {
    try
    {
      boolean bool = this.cached;
      if (bool) {
        return;
      }
      initPublicAccountCache();
      buildPublicAccountUI();
      initPublicRecommendAccountCache();
      initAccountDetailCache();
      this.cached = true;
      TroopBarAssistantManager.a().a(this.app, (List)getPublicAccountEqqInfoList());
      ServiceAccountFolderManager.a().b(this.app);
      EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)this.app.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      if (localEcShopAssistantManager != null) {
        localEcShopAssistantManager.a(null, "initPADataManager");
      }
      getKandianSubscribeAccountInfo();
      return;
    }
    finally {}
  }
  
  public void initPublicRecommendAccountCache()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.pub", 2, "initPublicRecommendAccountCache begin");
    }
    this.publicRecommendAccountList = ((ArrayList)this.em.query(PublicRecommendAccountInfo.class));
    if ((QLog.isColorLevel()) && (this.publicRecommendAccountList != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initPublicRecommendAccountCache end: ");
      localStringBuilder.append(this.publicRecommendAccountList.size());
      QLog.d("Q.contacttab.pub", 2, localStringBuilder.toString());
    }
  }
  
  public boolean isBuildingList()
  {
    return this.mIsBuildingList;
  }
  
  public boolean isCached()
  {
    return this.cached;
  }
  
  public boolean isCertifiedAccount(Object paramObject)
  {
    if (!(paramObject instanceof SessionInfo)) {
      return false;
    }
    paramObject = (PublicAccountInfo)findPublicAccountInfo(((SessionInfo)paramObject).a);
    return (paramObject != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType2(paramObject.accountFlag2) == -10L);
  }
  
  public boolean isFollowedUin(Long paramLong)
  {
    return isFollowedUin(paramLong, false);
  }
  
  public boolean isFollowedUin(Long paramLong, boolean paramBoolean)
  {
    List localList = (List)getPublicAccountEqqInfoList();
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      if (((PublicAccountInfo)localList.get(i)).uin == paramLong.longValue()) {
        return true;
      }
      i += 1;
    }
    if (paramBoolean) {
      paramLong = (PublicAccountDetailImpl)findAccountDetailInfoCache(String.valueOf(paramLong));
    } else {
      paramLong = (PublicAccountDetailImpl)findAccountDetailInfo(String.valueOf(paramLong));
    }
    return (paramLong != null) && (paramLong.followType == 1);
  }
  
  public boolean isSupportPay(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)findPublicAccountInfo(paramString);
      long l;
      if (localPublicAccountInfo != null)
      {
        l = localPublicAccountInfo.accountFlag2;
      }
      else
      {
        paramString = (PublicAccountDetailImpl)findAccountDetailInfo(paramString.toString());
        bool1 = bool2;
        if (paramString == null) {
          return bool1;
        }
        l = paramString.accountFlag2;
      }
      bool1 = bool2;
      if ((l & 0x100) != 0L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = ((QQAppInterface)paramAppRuntime);
    this.em = this.app.getEntityManagerFactory().createEntityManager();
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountDataManagerImpl.1(this), 10L);
  }
  
  public void onDestroy()
  {
    this.em.close();
    LruCache localLruCache = this.mAccountDetailCache;
    if (localLruCache != null) {
      localLruCache.evictAll();
    }
  }
  
  public void refreshPublicRecommendList(Object paramObject)
  {
    List localList = (List)paramObject;
    Object localObject1;
    if ((localList != null) && (localList.size() > 0))
    {
      paramObject = null;
      localObject1 = null;
    }
    try
    {
      try
      {
        EntityTransaction localEntityTransaction = this.em.getTransaction();
        localObject1 = localEntityTransaction;
        paramObject = localEntityTransaction;
        localEntityTransaction.begin();
        localObject1 = localEntityTransaction;
        paramObject = localEntityTransaction;
        Object localObject2 = this.em.query(PublicRecommendAccountInfo.class);
        PublicRecommendAccountInfo localPublicRecommendAccountInfo;
        if (localObject2 != null)
        {
          localObject1 = localEntityTransaction;
          paramObject = localEntityTransaction;
          localObject2 = ((List)localObject2).iterator();
          for (;;)
          {
            localObject1 = localEntityTransaction;
            paramObject = localEntityTransaction;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject1 = localEntityTransaction;
            paramObject = localEntityTransaction;
            localPublicRecommendAccountInfo = (PublicRecommendAccountInfo)((Iterator)localObject2).next();
            localObject1 = localEntityTransaction;
            paramObject = localEntityTransaction;
            this.em.remove(localPublicRecommendAccountInfo);
          }
        }
        localObject1 = localEntityTransaction;
        paramObject = localEntityTransaction;
        localObject2 = localList.iterator();
        for (;;)
        {
          localObject1 = localEntityTransaction;
          paramObject = localEntityTransaction;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = localEntityTransaction;
          paramObject = localEntityTransaction;
          localPublicRecommendAccountInfo = (PublicRecommendAccountInfo)((Iterator)localObject2).next();
          localObject1 = localEntityTransaction;
          paramObject = localEntityTransaction;
          this.em.persist(localPublicRecommendAccountInfo);
        }
        localObject1 = localEntityTransaction;
        paramObject = localEntityTransaction;
        localObject2 = this.publicRecommendAccountList;
        localObject1 = localEntityTransaction;
        paramObject = localEntityTransaction;
        this.publicRecommendAccountList = ((ArrayList)localList);
        localObject1 = localEntityTransaction;
        paramObject = localEntityTransaction;
        localEntityTransaction.commit();
        paramObject = localEntityTransaction;
      }
      finally
      {
        localObject1.end();
      }
    }
    catch (Exception localException)
    {
      label224:
      break label224;
    }
    paramObject.end();
  }
  
  public void saveAccountDetailInfoCache(Object paramObject)
  {
    if (!(paramObject instanceof PublicAccountDetailImpl)) {
      return;
    }
    paramObject = (PublicAccountDetailImpl)paramObject;
    if (this.mAccountDetailCache == null) {
      this.mAccountDetailCache = new LruCache(this.maxSize);
    }
    this.mAccountDetailCache.put(paramObject.uin, paramObject);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mAccountDetailCache size: ");
      localStringBuilder.append(this.mAccountDetailCache.size());
      localStringBuilder.append(" cacheCount()");
      localStringBuilder.append(this.mAccountDetailCache.cacheCount());
      localStringBuilder.append("  maxSize=");
      localStringBuilder.append(this.mAccountDetailCache.maxSize());
      localStringBuilder.append("  putCount:");
      localStringBuilder.append(this.mAccountDetailCache.putCount());
      localStringBuilder.append("  createCount:");
      localStringBuilder.append(this.mAccountDetailCache.createCount());
      localStringBuilder.append("  missed:");
      localStringBuilder.append(this.mAccountDetailCache.missCount());
      QLog.d("Q.contacttab.pub", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("save account detail info, puin : ");
      localStringBuilder.append(paramObject.uin);
      QLog.d("Q.contacttab.pub", 2, localStringBuilder.toString());
    }
  }
  
  public Object saveEqqAccountInfos(Object paramObject, long paramLong)
  {
    Object localObject2 = (List)paramObject;
    ArrayList localArrayList = new ArrayList();
    if (localObject2 == null) {
      return localArrayList;
    }
    if (this.mPublicAccountCache == null) {
      this.mPublicAccountCache = new ConcurrentHashMap();
    }
    paramObject = null;
    Object localObject1 = null;
    try
    {
      try
      {
        EntityTransaction localEntityTransaction = this.em.getTransaction();
        localObject1 = localEntityTransaction;
        paramObject = localEntityTransaction;
        localEntityTransaction.begin();
        PublicAccountInfo localPublicAccountInfo;
        if (localObject2 != null)
        {
          localObject1 = localEntityTransaction;
          paramObject = localEntityTransaction;
          if (((List)localObject2).size() > 0)
          {
            localObject1 = localEntityTransaction;
            paramObject = localEntityTransaction;
            localObject2 = ((List)localObject2).iterator();
            for (;;)
            {
              localObject1 = localEntityTransaction;
              paramObject = localEntityTransaction;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject1 = localEntityTransaction;
              paramObject = localEntityTransaction;
              localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject2).next();
              localObject1 = localEntityTransaction;
              paramObject = localEntityTransaction;
              updateEntity(localPublicAccountInfo);
              localObject1 = localEntityTransaction;
              paramObject = localEntityTransaction;
              this.mPublicAccountCache.put(localPublicAccountInfo.getUin(), localPublicAccountInfo);
            }
          }
        }
        localObject1 = localEntityTransaction;
        paramObject = localEntityTransaction;
        localObject2 = this.mPublicAccountCache.entrySet().iterator();
        for (;;)
        {
          localObject1 = localEntityTransaction;
          paramObject = localEntityTransaction;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = localEntityTransaction;
          paramObject = localEntityTransaction;
          localPublicAccountInfo = (PublicAccountInfo)((Map.Entry)((Iterator)localObject2).next()).getValue();
          localObject1 = localEntityTransaction;
          paramObject = localEntityTransaction;
          if (localPublicAccountInfo.extendType == 2)
          {
            localObject1 = localEntityTransaction;
            paramObject = localEntityTransaction;
            if (localPublicAccountInfo.dateTime < paramLong)
            {
              localObject1 = localEntityTransaction;
              paramObject = localEntityTransaction;
              ((Iterator)localObject2).remove();
              localObject1 = localEntityTransaction;
              paramObject = localEntityTransaction;
              this.em.remove(localPublicAccountInfo);
              localObject1 = localEntityTransaction;
              paramObject = localEntityTransaction;
              localArrayList.add(localPublicAccountInfo);
            }
          }
        }
        localObject1 = localEntityTransaction;
        paramObject = localEntityTransaction;
        localEntityTransaction.commit();
        paramObject = localEntityTransaction;
      }
      finally
      {
        localObject1.end();
      }
    }
    catch (Exception localException)
    {
      label355:
      break label355;
    }
    paramObject.end();
    buildPublicAccountUI();
    return localArrayList;
  }
  
  public void savePublicAccountInfo(Object paramObject)
  {
    if (!(paramObject instanceof PublicAccountInfo)) {
      return;
    }
    paramObject = (PublicAccountInfo)paramObject;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("save PublicAccountInfo, puin : ");
    localStringBuilder.append(paramObject.getUin());
    QLog.d("Q.contacttab.pub", 2, localStringBuilder.toString());
    if (this.mPublicAccountCache == null) {
      this.mPublicAccountCache = new ConcurrentHashMap();
    }
    ThreadManager.executeOnSubThread(new PublicAccountDataManagerImpl.6(this, paramObject));
    if (paramObject.isNeedShow()) {
      this.mPublicAccountCache.put(paramObject.getUin(), paramObject);
    } else {
      this.mPublicAccountCache.remove(paramObject.getUin(), paramObject);
    }
    buildPublicAccountUI();
  }
  
  public Object savePublicAccountInfos(Object paramObject, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = (List)paramObject;
    if (this.mPublicAccountCache == null)
    {
      int i;
      if (localObject2 != null) {
        i = ((List)localObject2).size();
      } else {
        i = 0;
      }
      this.mPublicAccountCache = new ConcurrentHashMap(i);
    }
    ArrayList localArrayList = new ArrayList();
    paramObject = null;
    Object localObject1 = null;
    try
    {
      try
      {
        EntityTransaction localEntityTransaction = this.em.getTransaction();
        localObject1 = localEntityTransaction;
        paramObject = localEntityTransaction;
        localEntityTransaction.begin();
        PublicAccountInfo localPublicAccountInfo;
        if (localObject2 != null)
        {
          localObject1 = localEntityTransaction;
          paramObject = localEntityTransaction;
          if (((List)localObject2).size() > 0)
          {
            localObject1 = localEntityTransaction;
            paramObject = localEntityTransaction;
            localObject2 = ((List)localObject2).iterator();
            for (;;)
            {
              localObject1 = localEntityTransaction;
              paramObject = localEntityTransaction;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject1 = localEntityTransaction;
              paramObject = localEntityTransaction;
              localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject2).next();
              localObject1 = localEntityTransaction;
              paramObject = localEntityTransaction;
              updateEntity(localPublicAccountInfo);
              localObject1 = localEntityTransaction;
              paramObject = localEntityTransaction;
              if (localPublicAccountInfo.isNeedShow())
              {
                localObject1 = localEntityTransaction;
                paramObject = localEntityTransaction;
                this.mPublicAccountCache.put(localPublicAccountInfo.getUin(), localPublicAccountInfo);
              }
              else
              {
                localObject1 = localEntityTransaction;
                paramObject = localEntityTransaction;
                this.mPublicAccountCache.remove(localPublicAccountInfo.getUin());
                localObject1 = localEntityTransaction;
                paramObject = localEntityTransaction;
                if (!localPublicAccountInfo.isVisible())
                {
                  localObject1 = localEntityTransaction;
                  paramObject = localEntityTransaction;
                  localArrayList.add(localPublicAccountInfo);
                }
              }
            }
          }
        }
        if ((!paramBoolean1) && (paramBoolean2))
        {
          localObject1 = localEntityTransaction;
          paramObject = localEntityTransaction;
          localObject2 = this.mPublicAccountCache.entrySet().iterator();
          for (;;)
          {
            localObject1 = localEntityTransaction;
            paramObject = localEntityTransaction;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject1 = localEntityTransaction;
            paramObject = localEntityTransaction;
            localPublicAccountInfo = (PublicAccountInfo)((Map.Entry)((Iterator)localObject2).next()).getValue();
            localObject1 = localEntityTransaction;
            paramObject = localEntityTransaction;
            if (localPublicAccountInfo.extendType == 0)
            {
              localObject1 = localEntityTransaction;
              paramObject = localEntityTransaction;
              if (localPublicAccountInfo.dateTime < paramLong)
              {
                localObject1 = localEntityTransaction;
                paramObject = localEntityTransaction;
                ((Iterator)localObject2).remove();
                localObject1 = localEntityTransaction;
                paramObject = localEntityTransaction;
                this.em.remove(localPublicAccountInfo);
                localObject1 = localEntityTransaction;
                paramObject = localEntityTransaction;
                localArrayList.add(localPublicAccountInfo);
              }
            }
          }
        }
        localObject1 = localEntityTransaction;
        paramObject = localEntityTransaction;
        localEntityTransaction.commit();
        paramObject = localEntityTransaction;
      }
      finally
      {
        localObject1.end();
      }
    }
    catch (Exception localException)
    {
      label448:
      break label448;
    }
    paramObject.end();
    buildPublicAccountUI();
    return localArrayList;
  }
  
  protected boolean updateEntity(Entity paramEntity)
  {
    int i = paramEntity.getStatus();
    boolean bool = false;
    if (i == 1000)
    {
      this.em.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
      return bool;
    }
    if ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return false;
    }
    return this.em.update(paramEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountDataManagerImpl
 * JD-Core Version:    0.7.0.1
 */