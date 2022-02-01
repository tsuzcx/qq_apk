package com.tencent.mobileqq.apollo.persistence.api.impl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.debug.utils.ApolloDebugUtils;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.listener.IApolloTagActionDataListener;
import com.tencent.mobileqq.apollo.listener.IApolloTagDataListener;
import com.tencent.mobileqq.apollo.model.AioPushData;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.model.ApolloActionPackageData;
import com.tencent.mobileqq.apollo.model.ApolloActionPush;
import com.tencent.mobileqq.apollo.model.ApolloActionRecentData;
import com.tencent.mobileqq.apollo.model.ApolloActionTag;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloBattleGameInfo;
import com.tencent.mobileqq.apollo.model.ApolloCommConfigKvData;
import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.apollo.model.ApolloFavActionData;
import com.tencent.mobileqq.apollo.model.ApolloGameData;
import com.tencent.mobileqq.apollo.model.ApolloObtainedActionData;
import com.tencent.mobileqq.apollo.model.ApolloPandora;
import com.tencent.mobileqq.apollo.model.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.model.ApolloRecommendAction;
import com.tencent.mobileqq.apollo.model.ApolloRelationTag;
import com.tencent.mobileqq.apollo.model.ApolloWhiteFaceID;
import com.tencent.mobileqq.apollo.model.CmBattleGameInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.utils.ApolloHardWareTester;
import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import mqq.util.LogUtil;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloDaoManagerServiceImpl
  implements IApolloDaoManagerService, Manager
{
  public static final String TAG = "[cmshow]ApolloDaoManager";
  public List<ApolloActionData> actionList = Collections.synchronizedList(new ArrayList());
  public List<ApolloActionPackageData> actionPackageList = Collections.synchronizedList(new ArrayList());
  public List<ApolloActionPush> actionPushList = Collections.synchronizedList(new ArrayList());
  private ConcurrentHashMap<String, ApolloPandora> apolloPandoraCache = new ConcurrentHashMap();
  private Runnable asyncInitDataRunnable = new ApolloDaoManagerServiceImpl.3(this);
  private EntityManager em;
  public List<ApolloFavActionData> favActionList = Collections.synchronizedList(new ArrayList());
  @Deprecated
  public List<ApolloGameData> gameList = Collections.synchronizedList(new ArrayList());
  private volatile boolean isApolloBaseInfoCacheInited;
  public List<ApolloObtainedActionData> mActionObtainedList = Collections.synchronizedList(new ArrayList());
  public List<ApolloActionTag> mActionTagList = Collections.synchronizedList(new ArrayList());
  private List<AioPushData> mAioPushDataList = Collections.synchronizedList(new ArrayList());
  private QQLruCache<String, ApolloBaseInfo> mApolloBaseInfoCache = new ApolloDaoManagerServiceImpl.1(this, 2009, 1024, ApolloBaseInfo.calcSelfMemorySize());
  private ConcurrentHashMap<Integer, String> mApolloGameVer = new ConcurrentHashMap();
  private AppInterface mApp;
  public final List<ApolloBattleGameInfo> mBattleGameList = Collections.synchronizedList(new ArrayList());
  private final Set<CmBattleGameInfo> mCmBattleGameInfoSet = Collections.synchronizedSet(new HashSet());
  public List<ApolloCommConfigKvData> mCommConfigKvLists = Collections.synchronizedList(new ArrayList());
  private List<DrawerPushItem> mDrawerPushItems = new ArrayList();
  private ConcurrentHashMap<String, Integer> mKeywordsActionMap = new ConcurrentHashMap();
  public ConcurrentHashMap<Integer, ApolloActionData> mLimitFreeActionMap = new ConcurrentHashMap();
  private volatile int mMaxKeywordsLength = 1;
  public ConcurrentHashMap<Integer, ApolloActionData> mObtainedActiveActionMap = new ConcurrentHashMap();
  public ConcurrentHashMap<String, ApolloPreDownloadData> mPreDownloadMap = new ConcurrentHashMap();
  Comparator<DrawerPushItem> mPushItemComparator = new ApolloDaoManagerServiceImpl.15(this);
  private final Object mPushLock = new Object();
  private Runnable mReadApolloActionListRunnable = new ApolloDaoManagerServiceImpl.2(this);
  public List<ApolloRecommendAction> mRecommendActionList = Collections.synchronizedList(new ArrayList());
  public final List<ApolloRelationTag> mRelationTagList = Collections.synchronizedList(new ArrayList());
  private ApolloBaseInfo mSelfApolloBaseInfo;
  private boolean mShouldCheckAction = true;
  private HashSet<Long> mUnCacheUinSets = new HashSet();
  public ConcurrentHashMap<Integer, ApolloWhiteFaceID> mWhiteFaceIdMapping = new ConcurrentHashMap();
  public List<ApolloActionPackage> packageList = Collections.synchronizedList(new ArrayList());
  
  private boolean alreadyContainsItem(DrawerPushItem paramDrawerPushItem)
  {
    Object localObject = this.mDrawerPushItems;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return false;
      }
      localObject = this.mDrawerPushItems.iterator();
      while (((Iterator)localObject).hasNext())
      {
        DrawerPushItem localDrawerPushItem = (DrawerPushItem)((Iterator)localObject).next();
        if ((localDrawerPushItem.msg_id != null) && (localDrawerPushItem.msg_id.equals(paramDrawerPushItem.msg_id))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private AppInterface getApp()
  {
    return this.mApp;
  }
  
  private List<ApolloGameData> getGameList()
  {
    if (this.mApp == null) {
      return null;
    }
    if (this.gameList.size() > 0) {
      synchronized (this.gameList)
      {
        ArrayList localArrayList = new ArrayList(this.gameList.size());
        localArrayList.addAll(this.gameList);
        return localArrayList;
      }
    }
    return this.mApp.getEntityManagerFactory().createEntityManager().query(ApolloGameData.class);
  }
  
  public static List<ApolloActionRecentData> getRecentData(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = new ArrayList();
    if (paramQQAppInterface == null) {
      return localObject;
    }
    localObject = paramQQAppInterface.getCurrentUin();
    return paramQQAppInterface.getEntityManagerFactory().createEntityManager().query(ApolloActionRecentData.class, false, "uin=? and sessionType=?", new String[] { localObject, paramString }, null, null, null, null);
  }
  
  private void initApolloBaseInfoCache()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloDaoManager", 2, "initApolloBaseInfoCache begin");
    }
    AppInterface localAppInterface = getApp();
    boolean bool = this.isApolloBaseInfoCacheInited;
    int m = 0;
    String str;
    if (!bool)
    {
      if (this.isApolloBaseInfoCacheInited) {
        return;
      }
      if (localAppInterface != null) {
        str = localAppInterface.getCurrentAccountUin();
      } else {
        str = "";
      }
    }
    for (;;)
    {
      int k;
      int j;
      try
      {
        long l = NetConnInfoCenter.getServerTime();
        Object localObject4 = (ArrayList)this.em.query(ApolloBaseInfo.class);
        if (localObject4 == null) {
          break label651;
        }
        k = ((ArrayList)localObject4).size();
        j = k;
        try
        {
          Object localObject6 = ((ArrayList)localObject4).iterator();
          i = k;
          j = k;
          if (((Iterator)localObject6).hasNext())
          {
            j = k;
            ApolloBaseInfo localApolloBaseInfo = (ApolloBaseInfo)((Iterator)localObject6).next();
            if (localApolloBaseInfo == null) {
              continue;
            }
            j = k;
            if (TextUtils.isEmpty(localApolloBaseInfo.uin)) {
              continue;
            }
            j = k;
            if (l > localApolloBaseInfo.apolloSignValidTS)
            {
              j = k;
              localApolloBaseInfo.apolloLocalSignTs = localApolloBaseInfo.apolloSignValidTS;
              j = k;
              localApolloBaseInfo.apolloSignStr = null;
            }
            j = k;
            localObject4 = this.mApolloBaseInfoCache;
            j = k;
            try
            {
              this.mApolloBaseInfoCache.put(localApolloBaseInfo.uin, localApolloBaseInfo);
              j = k;
              if (!localApolloBaseInfo.uin.equals(str)) {
                continue;
              }
              j = k;
              this.mSelfApolloBaseInfo = localApolloBaseInfo;
              j = k;
              ((IApolloManagerService)localAppInterface.getRuntimeService(IApolloManagerService.class, "all")).updateUserFlag(this.mSelfApolloBaseInfo.apolloAISwitch, 0);
              continue;
            }
            finally
            {
              j = k;
            }
          }
          j = i;
          localObject4 = (ArrayList)this.em.query(DrawerPushItem.class);
          if (localObject4 != null)
          {
            j = i;
            Object localObject2 = this.mPushLock;
            j = i;
            try
            {
              this.mDrawerPushItems.clear();
              l = System.currentTimeMillis() / 1000L;
              localObject4 = ((List)localObject4).iterator();
              if (((Iterator)localObject4).hasNext())
              {
                localObject6 = (DrawerPushItem)((Iterator)localObject4).next();
                if ((((DrawerPushItem)localObject6).end_ts > l) && (!alreadyContainsItem((DrawerPushItem)localObject6)))
                {
                  this.mDrawerPushItems.add(localObject6);
                  continue;
                }
                this.em.remove((Entity)localObject6);
                continue;
              }
            }
            finally
            {
              j = i;
            }
          }
          j = i;
          if ((this.mSelfApolloBaseInfo == null) && (localAppInterface != null))
          {
            j = i;
            ((ApolloExtensionHandler)localAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).b(localAppInterface.getCurrentUin());
          }
          j = i;
          this.isApolloBaseInfoCacheInited = true;
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          i = j;
        }
        QLog.e("[cmshow]ApolloDaoManager", 1, "initApolloBaseInfoCache oom", localOutOfMemoryError2);
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        i = 0;
      }
      break label500;
      int i = 0;
      label500:
      if ((QLog.isColorLevel()) && (localAppInterface != null))
      {
        Object localObject3 = (ApolloBaseInfo)this.mApolloBaseInfoCache.get(localAppInterface.getCurrentAccountUin());
        j = m;
        if (localObject3 != null) {
          j = ((ApolloBaseInfo)localObject3).apolloStatus;
        }
        if (localObject3 != null) {
          k = ((ApolloBaseInfo)localObject3).cmshow3dFlag & 0x1;
        } else {
          k = -1;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("initApolloBaseInfoCache end size: ");
        ((StringBuilder)localObject3).append(this.mApolloBaseInfoCache.size());
        ((StringBuilder)localObject3).append(" dbCount:");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append(", apollo status: ");
        ((StringBuilder)localObject3).append(j);
        ((StringBuilder)localObject3).append(", cmshow3d: ");
        ((StringBuilder)localObject3).append(k);
        QLog.d("[cmshow]ApolloDaoManager", 2, ((StringBuilder)localObject3).toString());
      }
      return;
      label651:
      i = 0;
    }
  }
  
  private void initApolloPandoraCache()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloDaoManager", 2, "initApolloPandoraCache begin...");
    }
    try
    {
      ??? = (ArrayList)this.em.query(ApolloPandora.class);
      if (??? == null) {
        return;
      }
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
      StringBuilder localStringBuilder;
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("[cmshow]ApolloDaoManager", 1, "initApolloPandoraCache oom", localOutOfMemoryError);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("initApolloPandoraCache end size:");
        localStringBuilder.append(this.apolloPandoraCache.size());
        QLog.d("[cmshow]ApolloDaoManager", 2, localStringBuilder.toString());
      }
    }
  }
  
  public static void insertAndDeleteData(QQAppInterface paramQQAppInterface, ApolloActionRecentData paramApolloActionRecentData1, ApolloActionRecentData paramApolloActionRecentData2)
  {
    if ((paramQQAppInterface != null) && (paramApolloActionRecentData1 != null))
    {
      if (paramApolloActionRecentData2 == null) {
        return;
      }
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      paramQQAppInterface.remove(paramApolloActionRecentData2);
      paramQQAppInterface.persist(paramApolloActionRecentData1);
    }
  }
  
  public static void insertRecentData(QQAppInterface paramQQAppInterface, ApolloActionRecentData paramApolloActionRecentData)
  {
    if (paramQQAppInterface != null)
    {
      if (paramApolloActionRecentData == null) {
        return;
      }
      paramQQAppInterface.getEntityManagerFactory().createEntityManager().persist(paramApolloActionRecentData);
    }
  }
  
  private void removeInvalidAioPushData()
  {
    List localList = this.mAioPushDataList;
    if (localList != null) {
      try
      {
        int i = (int)(System.currentTimeMillis() / 1000L);
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.mAioPushDataList.iterator();
        while (localIterator.hasNext())
        {
          AioPushData localAioPushData = (AioPushData)localIterator.next();
          if ((localAioPushData != null) && ((localAioPushData.endTs <= i) || (localAioPushData.begTs >= localAioPushData.endTs))) {
            localArrayList.add(localAioPushData);
          }
        }
        if (localArrayList.size() > 0)
        {
          localIterator = localArrayList.iterator();
          while (localIterator.hasNext()) {
            realDelAioPushData((AioPushData)localIterator.next());
          }
          this.mAioPushDataList.removeAll(localArrayList);
        }
        return;
      }
      finally {}
    }
  }
  
  private void safeClearList(List paramList)
  {
    if (paramList != null) {
      try
      {
        paramList.clear();
        return;
      }
      finally {}
    }
  }
  
  private void safeClearMap(Map paramMap)
  {
    if (paramMap != null) {
      try
      {
        paramMap.clear();
        return;
      }
      finally {}
    }
  }
  
  private void saveActionKeywordsMap(ApolloActionData paramApolloActionData)
  {
    Object localObject = paramApolloActionData.keywords;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (!ApolloUtilImpl.verifyActionVersion(paramApolloActionData, "8.8.17")) {
      return;
    }
    localObject = ((String)localObject).split(",");
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      CharSequence localCharSequence = localObject[i];
      if (!TextUtils.isEmpty(localCharSequence))
      {
        this.mKeywordsActionMap.put(localCharSequence, Integer.valueOf(paramApolloActionData.actionId));
        if (localCharSequence.length() > this.mMaxKeywordsLength) {
          this.mMaxKeywordsLength = localCharSequence.length();
        }
      }
      i += 1;
    }
  }
  
  /* Error */
  private void saveApolloObtainedActionList(List<ApolloObtainedActionData> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +284 -> 285
    //   4: aload_1
    //   5: invokeinterface 266 1 0
    //   10: ifeq +275 -> 285
    //   13: aload_0
    //   14: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   17: astore_2
    //   18: aload_2
    //   19: ifnonnull +4 -> 23
    //   22: return
    //   23: aload_2
    //   24: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   27: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   30: astore_3
    //   31: aload_3
    //   32: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   35: astore_2
    //   36: aload_2
    //   37: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   40: new 444	java/lang/StringBuilder
    //   43: dup
    //   44: sipush 500
    //   47: invokespecial 550	java/lang/StringBuilder:<init>	(I)V
    //   50: astore 4
    //   52: aload 4
    //   54: ldc_w 552
    //   57: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_1
    //   62: invokeinterface 239 1 0
    //   67: astore 5
    //   69: aload 5
    //   71: invokeinterface 244 1 0
    //   76: ifeq +86 -> 162
    //   79: aload 5
    //   81: invokeinterface 248 1 0
    //   86: checkcast 554	com/tencent/mobileqq/apollo/model/ApolloObtainedActionData
    //   89: astore 6
    //   91: aload_0
    //   92: aload_3
    //   93: aload 6
    //   95: invokevirtual 558	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   98: pop
    //   99: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq -33 -> 69
    //   105: aload 4
    //   107: ldc_w 560
    //   110: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 4
    //   116: aload 6
    //   118: getfield 563	com/tencent/mobileqq/apollo/model/ApolloObtainedActionData:id	I
    //   121: invokevirtual 455	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload 4
    //   127: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   130: sipush 500
    //   133: if_icmplt -64 -> 69
    //   136: ldc 12
    //   138: iconst_2
    //   139: aload 4
    //   141: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: aload 4
    //   149: iconst_0
    //   150: aload 4
    //   152: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   155: invokevirtual 568	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: goto -90 -> 69
    //   162: aload 4
    //   164: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   167: sipush 500
    //   170: if_icmpge +34 -> 204
    //   173: aload 4
    //   175: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   178: ifle +26 -> 204
    //   181: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq +20 -> 204
    //   187: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +14 -> 204
    //   193: ldc 12
    //   195: iconst_2
    //   196: aload 4
    //   198: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload_2
    //   205: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   208: goto +18 -> 226
    //   211: astore_1
    //   212: goto +67 -> 279
    //   215: astore_3
    //   216: ldc 12
    //   218: iconst_2
    //   219: ldc_w 573
    //   222: aload_3
    //   223: invokestatic 432	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   226: aload_2
    //   227: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   230: aload_0
    //   231: getfield 127	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mActionObtainedList	Ljava/util/List;
    //   234: astore_2
    //   235: aload_2
    //   236: monitorenter
    //   237: aload_0
    //   238: getfield 127	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mActionObtainedList	Ljava/util/List;
    //   241: invokeinterface 391 1 0
    //   246: aload_0
    //   247: getfield 127	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mActionObtainedList	Ljava/util/List;
    //   250: aload_1
    //   251: invokeinterface 273 2 0
    //   256: pop
    //   257: aload_2
    //   258: monitorexit
    //   259: aload_0
    //   260: getfield 131	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mLimitFreeActionMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   263: invokevirtual 577	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   266: aload_0
    //   267: getfield 129	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mObtainedActiveActionMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   270: invokevirtual 577	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   273: return
    //   274: astore_1
    //   275: aload_2
    //   276: monitorexit
    //   277: aload_1
    //   278: athrow
    //   279: aload_2
    //   280: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   283: aload_1
    //   284: athrow
    //   285: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	ApolloDaoManagerServiceImpl
    //   0	286	1	paramList	List<ApolloObtainedActionData>
    //   17	263	2	localObject	Object
    //   30	63	3	localEntityManager	EntityManager
    //   215	8	3	localException	Exception
    //   50	147	4	localStringBuilder	StringBuilder
    //   67	13	5	localIterator	Iterator
    //   89	28	6	localApolloObtainedActionData	ApolloObtainedActionData
    // Exception table:
    //   from	to	target	type
    //   40	69	211	finally
    //   69	159	211	finally
    //   162	204	211	finally
    //   204	208	211	finally
    //   216	226	211	finally
    //   40	69	215	java/lang/Exception
    //   69	159	215	java/lang/Exception
    //   162	204	215	java/lang/Exception
    //   204	208	215	java/lang/Exception
    //   237	259	274	finally
    //   275	277	274	finally
  }
  
  private boolean updateEntity(Entity paramEntity)
  {
    boolean bool2 = this.em.isOpen();
    boolean bool1 = false;
    if (bool2)
    {
      if (paramEntity.getStatus() == 1000)
      {
        this.em.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
        return bool1;
      }
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.em.update(paramEntity);
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateEntity em closed e=");
      localStringBuilder.append(paramEntity.getTableName());
      QLog.e("[cmshow]ApolloDaoManager", 2, localStringBuilder.toString());
    }
    return false;
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
        if (paramBoolean) {
          this.em.persist(paramDrawerPushItem);
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("add red push item:");
          localStringBuilder.append(paramDrawerPushItem);
          QLog.i("ApolloPushBubble", 2, localStringBuilder.toString());
        }
      }
      return;
    }
  }
  
  public void asyncQuerySelfApolloBaseInfo()
  {
    ThreadManager.getSubThreadHandler().post(new ApolloDaoManagerServiceImpl.12(this));
  }
  
  /* Error */
  public void bulkSaveOrUpdateApolloActionData(List<ApolloActionData> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   4: ifnull +234 -> 238
    //   7: aload_1
    //   8: ifnonnull +4 -> 12
    //   11: return
    //   12: aload_1
    //   13: ifnull +116 -> 129
    //   16: aload_0
    //   17: getfield 99	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:actionList	Ljava/util/List;
    //   20: astore 4
    //   22: aload 4
    //   24: monitorenter
    //   25: aload_0
    //   26: getfield 99	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:actionList	Ljava/util/List;
    //   29: invokeinterface 266 1 0
    //   34: iconst_1
    //   35: isub
    //   36: istore_2
    //   37: iload_2
    //   38: iflt +79 -> 117
    //   41: aload_1
    //   42: invokeinterface 266 1 0
    //   47: iconst_1
    //   48: isub
    //   49: istore_3
    //   50: iload_3
    //   51: ifle +195 -> 246
    //   54: aload_1
    //   55: iload_3
    //   56: invokeinterface 632 2 0
    //   61: checkcast 508	com/tencent/mobileqq/apollo/model/ApolloActionData
    //   64: getfield 528	com/tencent/mobileqq/apollo/model/ApolloActionData:actionId	I
    //   67: aload_0
    //   68: getfield 99	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:actionList	Ljava/util/List;
    //   71: iload_2
    //   72: invokeinterface 632 2 0
    //   77: checkcast 508	com/tencent/mobileqq/apollo/model/ApolloActionData
    //   80: getfield 528	com/tencent/mobileqq/apollo/model/ApolloActionData:actionId	I
    //   83: if_icmpne +156 -> 239
    //   86: aload_0
    //   87: getfield 99	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:actionList	Ljava/util/List;
    //   90: iload_2
    //   91: invokeinterface 634 2 0
    //   96: pop
    //   97: aload_0
    //   98: getfield 99	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:actionList	Ljava/util/List;
    //   101: iload_2
    //   102: aload_1
    //   103: iload_3
    //   104: invokeinterface 632 2 0
    //   109: invokeinterface 637 3 0
    //   114: goto +125 -> 239
    //   117: aload 4
    //   119: monitorexit
    //   120: goto +9 -> 129
    //   123: astore_1
    //   124: aload 4
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    //   129: aload_0
    //   130: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   133: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   136: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   139: astore 5
    //   141: aload 5
    //   143: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   146: astore 4
    //   148: aload 4
    //   150: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   153: iconst_0
    //   154: istore_2
    //   155: iload_2
    //   156: aload_1
    //   157: invokeinterface 266 1 0
    //   162: if_icmpge +27 -> 189
    //   165: aload_0
    //   166: aload 5
    //   168: aload_1
    //   169: iload_2
    //   170: invokeinterface 632 2 0
    //   175: checkcast 349	com/tencent/mobileqq/persistence/Entity
    //   178: invokevirtual 558	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   181: pop
    //   182: iload_2
    //   183: iconst_1
    //   184: iadd
    //   185: istore_2
    //   186: goto -31 -> 155
    //   189: aload 4
    //   191: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   194: aload 4
    //   196: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   199: return
    //   200: astore_1
    //   201: goto +30 -> 231
    //   204: astore_1
    //   205: ldc 12
    //   207: iconst_1
    //   208: iconst_2
    //   209: anewarray 4	java/lang/Object
    //   212: dup
    //   213: iconst_0
    //   214: ldc_w 639
    //   217: aastore
    //   218: dup
    //   219: iconst_1
    //   220: aload_1
    //   221: invokevirtual 642	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   224: aastore
    //   225: invokestatic 645	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   228: goto -34 -> 194
    //   231: aload 4
    //   233: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   236: aload_1
    //   237: athrow
    //   238: return
    //   239: iload_3
    //   240: iconst_1
    //   241: isub
    //   242: istore_3
    //   243: goto -193 -> 50
    //   246: iload_2
    //   247: iconst_1
    //   248: isub
    //   249: istore_2
    //   250: goto -213 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	ApolloDaoManagerServiceImpl
    //   0	253	1	paramList	List<ApolloActionData>
    //   36	214	2	i	int
    //   49	194	3	j	int
    //   20	212	4	localObject	Object
    //   139	28	5	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   25	37	123	finally
    //   41	50	123	finally
    //   54	114	123	finally
    //   117	120	123	finally
    //   124	127	123	finally
    //   148	153	200	finally
    //   155	182	200	finally
    //   189	194	200	finally
    //   205	228	200	finally
    //   148	153	204	java/lang/Exception
    //   155	182	204	java/lang/Exception
    //   189	194	204	java/lang/Exception
  }
  
  /* Error */
  public void bulkSaveOrUpdateApolloBaseInfos(List<ApolloBaseInfo> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +427 -> 428
    //   4: aload_1
    //   5: invokeinterface 266 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokeinterface 266 1 0
    //   20: iconst_1
    //   21: if_icmpne +18 -> 39
    //   24: aload_0
    //   25: aload_1
    //   26: iconst_0
    //   27: invokeinterface 632 2 0
    //   32: checkcast 161	com/tencent/mobileqq/apollo/model/ApolloBaseInfo
    //   35: invokevirtual 651	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:saveOrUpdateApolloBaseInfo	(Lcom/tencent/mobileqq/apollo/model/ApolloBaseInfo;)V
    //   38: return
    //   39: aload_1
    //   40: invokeinterface 239 1 0
    //   45: astore_2
    //   46: aload_2
    //   47: invokeinterface 244 1 0
    //   52: ifeq +88 -> 140
    //   55: aload_2
    //   56: invokeinterface 248 1 0
    //   61: checkcast 161	com/tencent/mobileqq/apollo/model/ApolloBaseInfo
    //   64: astore_3
    //   65: aload_3
    //   66: getfield 352	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:uin	Ljava/lang/String;
    //   69: invokestatic 357	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   72: ifne -26 -> 46
    //   75: aload_0
    //   76: invokespecial 332	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:getApp	()Lcom/tencent/common/app/AppInterface;
    //   79: astore 4
    //   81: aload 4
    //   83: ifnull +23 -> 106
    //   86: aload_3
    //   87: getfield 352	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:uin	Ljava/lang/String;
    //   90: aload 4
    //   92: invokevirtual 654	mqq/app/AppRuntime:getCurrentAccountUin	()Ljava/lang/String;
    //   95: invokevirtual 259	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   98: ifeq +8 -> 106
    //   101: aload_0
    //   102: aload_3
    //   103: putfield 218	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mSelfApolloBaseInfo	Lcom/tencent/mobileqq/apollo/model/ApolloBaseInfo;
    //   106: aload_0
    //   107: getfield 170	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApolloBaseInfoCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   110: astore 4
    //   112: aload 4
    //   114: monitorenter
    //   115: aload_0
    //   116: getfield 170	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApolloBaseInfoCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   119: aload_3
    //   120: getfield 352	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:uin	Ljava/lang/String;
    //   123: aload_3
    //   124: invokevirtual 373	com/tencent/commonsdk/cache/QQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: pop
    //   128: aload 4
    //   130: monitorexit
    //   131: goto -85 -> 46
    //   134: astore_1
    //   135: aload 4
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    //   140: aload_0
    //   141: getfield 227	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   144: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   147: astore_2
    //   148: aload_2
    //   149: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   152: aload_1
    //   153: invokeinterface 239 1 0
    //   158: astore_3
    //   159: aload_3
    //   160: invokeinterface 244 1 0
    //   165: ifeq +35 -> 200
    //   168: aload_3
    //   169: invokeinterface 248 1 0
    //   174: checkcast 161	com/tencent/mobileqq/apollo/model/ApolloBaseInfo
    //   177: astore 4
    //   179: aload 4
    //   181: getfield 352	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:uin	Ljava/lang/String;
    //   184: invokestatic 357	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   187: ifne -28 -> 159
    //   190: aload_0
    //   191: aload 4
    //   193: invokespecial 656	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   196: pop
    //   197: goto -38 -> 159
    //   200: aload_2
    //   201: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   204: aload_2
    //   205: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   208: goto +50 -> 258
    //   211: astore_1
    //   212: goto +210 -> 422
    //   215: astore_3
    //   216: new 444	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   223: astore 4
    //   225: aload 4
    //   227: ldc_w 658
    //   230: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 4
    //   236: aload_3
    //   237: invokevirtual 642	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   240: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: ldc 12
    //   246: iconst_1
    //   247: aload 4
    //   249: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: goto -51 -> 204
    //   258: aload_0
    //   259: invokespecial 332	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:getApp	()Lcom/tencent/common/app/AppInterface;
    //   262: astore_2
    //   263: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   266: ifeq +155 -> 421
    //   269: aload_2
    //   270: ifnull +151 -> 421
    //   273: aload_1
    //   274: aload_2
    //   275: invokevirtual 659	mqq/app/AppRuntime:getCurrentUin	()Ljava/lang/String;
    //   278: invokeinterface 662 2 0
    //   283: ifeq +138 -> 421
    //   286: aload_0
    //   287: getfield 170	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApolloBaseInfoCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   290: aload_2
    //   291: invokevirtual 659	mqq/app/AppRuntime:getCurrentUin	()Ljava/lang/String;
    //   294: invokevirtual 436	com/tencent/commonsdk/cache/QQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   297: checkcast 161	com/tencent/mobileqq/apollo/model/ApolloBaseInfo
    //   300: astore_1
    //   301: new 444	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   308: astore_2
    //   309: aload_2
    //   310: ldc_w 664
    //   313: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload_2
    //   318: aload_1
    //   319: getfield 667	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:apolloVipFlag	I
    //   322: invokevirtual 455	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_2
    //   327: ldc_w 669
    //   330: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload_2
    //   335: aload_1
    //   336: getfield 667	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:apolloVipFlag	I
    //   339: invokevirtual 455	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload_2
    //   344: ldc_w 459
    //   347: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload_2
    //   352: aload_1
    //   353: getfield 439	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:apolloStatus	I
    //   356: invokevirtual 455	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload_2
    //   361: ldc_w 671
    //   364: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload_2
    //   369: aload_1
    //   370: getfield 674	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:apolloLocalTS	J
    //   373: invokevirtual 677	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload_2
    //   378: ldc_w 679
    //   381: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload_2
    //   386: aload_1
    //   387: getfield 682	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:apolloServerTS	J
    //   390: invokevirtual 677	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload_2
    //   395: ldc_w 684
    //   398: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload_2
    //   403: aload_1
    //   404: getfield 687	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:apolloUpdateTime	J
    //   407: invokevirtual 677	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: ldc 12
    //   413: iconst_1
    //   414: aload_2
    //   415: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: return
    //   422: aload_2
    //   423: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   426: aload_1
    //   427: athrow
    //   428: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	this	ApolloDaoManagerServiceImpl
    //   0	429	1	paramList	List<ApolloBaseInfo>
    //   45	378	2	localObject1	Object
    //   64	105	3	localObject2	Object
    //   215	22	3	localException	Exception
    //   79	169	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   115	131	134	finally
    //   135	138	134	finally
    //   152	159	211	finally
    //   159	197	211	finally
    //   200	204	211	finally
    //   216	255	211	finally
    //   152	159	215	java/lang/Exception
    //   159	197	215	java/lang/Exception
    //   200	204	215	java/lang/Exception
  }
  
  public void changeActionStatus(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData != null) {
      if (this.mApp == null) {
        return;
      }
    }
    for (;;)
    {
      int i;
      synchronized (this.actionList)
      {
        i = this.actionList.size() - 1;
        if (i >= 0)
        {
          if ((this.actionList == null) || (this.actionList.get(i) == null) || (((ApolloActionData)this.actionList.get(i)).actionId != paramApolloActionData.actionId)) {
            break label127;
          }
          this.actionList.remove(i);
          this.actionList.add(i, paramApolloActionData);
        }
        this.mApp.getEntityManagerFactory().createEntityManager().update(paramApolloActionData);
        return;
      }
      return;
      label127:
      i -= 1;
    }
  }
  
  public void clearBubble(String paramString)
  {
    synchronized (this.mPushLock)
    {
      if ((this.mDrawerPushItems != null) && (!this.mDrawerPushItems.isEmpty()))
      {
        Iterator localIterator = this.mDrawerPushItems.iterator();
        Object localObject2;
        while (localIterator.hasNext())
        {
          localObject2 = (DrawerPushItem)localIterator.next();
          if ((((DrawerPushItem)localObject2).msg_id != null) && (((DrawerPushItem)localObject2).msg_id.equals(paramString)))
          {
            ((DrawerPushItem)localObject2).show_sum = ((DrawerPushItem)localObject2).show_counts;
            this.mDrawerPushItems.remove(localObject2);
            this.em.remove((Entity)localObject2);
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("remove bubble:");
              paramString.append(((DrawerPushItem)localObject2).msg_id);
              QLog.i("[cmshow]ApolloDaoManager", 2, paramString.toString());
            }
            return;
          }
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("remove bubble failed:");
          ((StringBuilder)localObject2).append(paramString);
          QLog.i("[cmshow]ApolloDaoManager", 2, ((StringBuilder)localObject2).toString());
        }
        return;
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void delFavAction(ApolloFavActionData paramApolloFavActionData)
  {
    if (paramApolloFavActionData == null) {
      return;
    }
    int i;
    label149:
    synchronized (this.favActionList)
    {
      i = this.favActionList.size() - 1;
      if (i >= 0)
      {
        if (((ApolloFavActionData)this.favActionList.get(i)).favId != paramApolloFavActionData.favId) {
          break label149;
        }
        this.favActionList.remove(i);
      }
      ??? = this.mApp;
      if (??? == null) {
        return;
      }
      ??? = ((AppInterface)???).getEntityManagerFactory().createEntityManager();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("insert ApolloFavActionData id=");
        localStringBuilder.append(paramApolloFavActionData.toString());
        QLog.d("[cmshow]ApolloDaoManager", 2, localStringBuilder.toString());
      }
      ((EntityManager)???).remove(paramApolloFavActionData);
      return;
    }
  }
  
  /* Error */
  public void delFavActionList(List<ApolloFavActionData> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: getfield 105	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:favActionList	Ljava/util/List;
    //   9: astore 5
    //   11: aload 5
    //   13: monitorenter
    //   14: iconst_0
    //   15: istore 4
    //   17: iconst_0
    //   18: istore_2
    //   19: iload_2
    //   20: aload_1
    //   21: invokeinterface 266 1 0
    //   26: if_icmpge +66 -> 92
    //   29: aload_0
    //   30: getfield 105	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:favActionList	Ljava/util/List;
    //   33: invokeinterface 266 1 0
    //   38: iconst_1
    //   39: isub
    //   40: istore_3
    //   41: iload_3
    //   42: iflt +172 -> 214
    //   45: aload_0
    //   46: getfield 105	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:favActionList	Ljava/util/List;
    //   49: iload_3
    //   50: invokeinterface 632 2 0
    //   55: checkcast 706	com/tencent/mobileqq/apollo/model/ApolloFavActionData
    //   58: getfield 709	com/tencent/mobileqq/apollo/model/ApolloFavActionData:favId	J
    //   61: aload_1
    //   62: iload_2
    //   63: invokeinterface 632 2 0
    //   68: checkcast 706	com/tencent/mobileqq/apollo/model/ApolloFavActionData
    //   71: getfield 709	com/tencent/mobileqq/apollo/model/ApolloFavActionData:favId	J
    //   74: lcmp
    //   75: ifne +132 -> 207
    //   78: aload_0
    //   79: getfield 105	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:favActionList	Ljava/util/List;
    //   82: iload_3
    //   83: invokeinterface 634 2 0
    //   88: pop
    //   89: goto +118 -> 207
    //   92: aload 5
    //   94: monitorexit
    //   95: aload_0
    //   96: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   99: astore 5
    //   101: aload 5
    //   103: ifnonnull +4 -> 107
    //   106: return
    //   107: aload 5
    //   109: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   112: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   115: astore 6
    //   117: aload 6
    //   119: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   122: astore 5
    //   124: aload 5
    //   126: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   129: iload 4
    //   131: istore_2
    //   132: iload_2
    //   133: aload_1
    //   134: invokeinterface 266 1 0
    //   139: if_icmpge +26 -> 165
    //   142: aload 6
    //   144: aload_1
    //   145: iload_2
    //   146: invokeinterface 632 2 0
    //   151: checkcast 349	com/tencent/mobileqq/persistence/Entity
    //   154: invokevirtual 410	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   157: pop
    //   158: iload_2
    //   159: iconst_1
    //   160: iadd
    //   161: istore_2
    //   162: goto -30 -> 132
    //   165: aload 5
    //   167: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   170: goto +12 -> 182
    //   173: astore_1
    //   174: goto +14 -> 188
    //   177: astore_1
    //   178: aload_1
    //   179: invokevirtual 716	java/lang/Exception:printStackTrace	()V
    //   182: aload 5
    //   184: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   187: return
    //   188: aload 5
    //   190: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   193: aload_1
    //   194: athrow
    //   195: astore_1
    //   196: aload 5
    //   198: monitorexit
    //   199: goto +5 -> 204
    //   202: aload_1
    //   203: athrow
    //   204: goto -2 -> 202
    //   207: iload_3
    //   208: iconst_1
    //   209: isub
    //   210: istore_3
    //   211: goto -170 -> 41
    //   214: iload_2
    //   215: iconst_1
    //   216: iadd
    //   217: istore_2
    //   218: goto -199 -> 19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	ApolloDaoManagerServiceImpl
    //   0	221	1	paramList	List<ApolloFavActionData>
    //   18	200	2	i	int
    //   40	171	3	j	int
    //   15	115	4	k	int
    //   9	188	5	localObject	Object
    //   115	28	6	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   124	129	173	finally
    //   132	158	173	finally
    //   165	170	173	finally
    //   178	182	173	finally
    //   124	129	177	java/lang/Exception
    //   132	158	177	java/lang/Exception
    //   165	170	177	java/lang/Exception
    //   19	41	195	finally
    //   45	89	195	finally
    //   92	95	195	finally
    //   196	199	195	finally
  }
  
  public ApolloActionData findActionById(int paramInt)
  {
    if (this.mApp == null) {
      return null;
    }
    Object localObject = findActionInCache(paramInt);
    if (localObject != null) {
      return localObject;
    }
    localObject = this.mApp.getEntityManagerFactory().createEntityManager();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localObject = (ApolloActionData)((EntityManager)localObject).find(ApolloActionData.class, localStringBuilder.toString());
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloDaoManager", 2, new Object[] { "findActionById from db:", Integer.valueOf(paramInt) });
    }
    return localObject;
  }
  
  public ApolloActionData findActionInCache(int paramInt)
  {
    if (this.mApp == null) {
      return null;
    }
    if (this.actionList.size() == 0)
    {
      QLog.e("[cmshow]ApolloDaoManager", 2, new Object[] { "[findActionInCache] actionList no action:", Integer.valueOf(paramInt) });
      return null;
    }
    int i;
    synchronized (this.actionList)
    {
      i = this.actionList.size() - 1;
      if (i >= 0)
      {
        ApolloActionData localApolloActionData = (ApolloActionData)this.actionList.get(i);
        if ((localApolloActionData != null) && (localApolloActionData.actionId == paramInt)) {
          return localApolloActionData;
        }
      }
      else
      {
        return null;
      }
    }
  }
  
  public ApolloFavActionData findFavActionById(long paramLong)
  {
    Object localObject1 = this.favActionList;
    int i = 0;
    for (;;)
    {
      try
      {
        Object localObject2;
        if (i < this.favActionList.size())
        {
          if (((ApolloFavActionData)this.favActionList.get(i)).favId == paramLong)
          {
            localObject2 = (ApolloFavActionData)this.favActionList.get(i);
            return localObject2;
          }
        }
        else
        {
          localObject1 = this.mApp;
          if (localObject1 == null) {
            return null;
          }
          localObject1 = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("find ApolloFavActionData favid=");
            ((StringBuilder)localObject2).append(paramLong);
            QLog.d("[cmshow]ApolloDaoManager", 2, ((StringBuilder)localObject2).toString());
          }
          return (ApolloFavActionData)((EntityManager)localObject1).find(ApolloFavActionData.class, paramLong);
        }
      }
      finally
      {
        continue;
        throw localObject3;
        continue;
        i += 1;
      }
    }
  }
  
  public ApolloGameData findGameById(int paramInt)
  {
    if (paramInt <= 0) {
      return null;
    }
    Object localObject1 = this.gameList;
    int i = 0;
    for (;;)
    {
      try
      {
        Object localObject2;
        if (i < this.gameList.size())
        {
          if (((ApolloGameData)this.gameList.get(i)).gameId == paramInt)
          {
            localObject2 = (ApolloGameData)this.gameList.get(i);
            return localObject2;
          }
        }
        else
        {
          localObject1 = this.mApp;
          if (localObject1 == null) {
            return null;
          }
          localObject1 = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append("");
          localObject1 = (ApolloGameData)((EntityManager)localObject1).find(ApolloGameData.class, ((StringBuilder)localObject2).toString());
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloDaoManager", 2, "findGameById from db");
          }
          return localObject1;
        }
      }
      finally
      {
        continue;
        throw localObject3;
        continue;
        i += 1;
      }
    }
  }
  
  public ApolloActionPackage findPackageById(int paramInt)
  {
    if (this.mApp == null) {
      return null;
    }
    int i;
    synchronized (this.packageList)
    {
      i = this.packageList.size() - 1;
      Object localObject2;
      if (i >= 0)
      {
        if (((ApolloActionPackage)this.packageList.get(i)).packageId == paramInt)
        {
          localObject2 = (ApolloActionPackage)this.packageList.get(i);
          return localObject2;
        }
      }
      else
      {
        ??? = this.mApp.getEntityManagerFactory().createEntityManager();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append("");
        return (ApolloActionPackage)((EntityManager)???).find(ApolloActionPackage.class, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  @NonNull
  public List<ApolloActionData> getActionByPackageId(int paramInt)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    int i;
    if (this.actionPackageList.size() > 0)
    {
      ??? = this.actionPackageList;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.actionPackageList.size())
        {
          if (((ApolloActionPackageData)this.actionPackageList.get(i)).packageId != paramInt) {
            break label457;
          }
          localArrayList1.add(this.actionPackageList.get(i));
          break label457;
        }
      }
      finally {}
      Object localObject2 = this.mApp;
      if (localObject2 == null) {
        return localArrayList2;
      }
      localObject2 = ((AppInterface)localObject2).getEntityManagerFactory().createEntityManager();
      ??? = new StringBuilder();
      ((StringBuilder)???).append(paramInt);
      ((StringBuilder)???).append("");
      ??? = ((EntityManager)localObject2).query(ApolloActionPackageData.class, false, "packageId=?", new String[] { ((StringBuilder)???).toString() }, null, null, null, null);
      localObject2 = ???;
      if (QLog.isColorLevel())
      {
        if (??? == null) {
          localObject2 = null;
        } else {
          localObject2 = Integer.valueOf(((List)???).size());
        }
        QLog.d("[cmshow]ApolloDaoManager", 2, new Object[] { "getActionByPackageId from db, size:", localObject2 });
        localObject2 = ???;
      }
      if (localObject2 == null) {
        return localArrayList2;
      }
      paramInt = 0;
      i = 1;
      while (paramInt < ((List)localObject2).size())
      {
        ??? = findActionById(((ApolloActionPackageData)((List)localObject2).get(paramInt)).acitonId);
        if (??? != null)
        {
          localArrayList2.add(???);
        }
        else
        {
          if (this.actionPackageList.size() > 0) {
            synchronized (this.actionPackageList)
            {
              this.actionPackageList.remove(((List)localObject2).get(paramInt));
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("remove paciton id=");
                localStringBuilder.append(((ApolloActionPackageData)((List)localObject2).get(paramInt)).acitonId);
                QLog.d("[cmshow]ApolloDaoManager", 2, localStringBuilder.toString());
              }
            }
          }
          i = 0;
        }
        paramInt += 1;
      }
      if (i == 0)
      {
        QLog.e("[cmshow]ApolloDaoManager", 1, "[getActionByPackageId] has some action not exit and check action json");
        if ((this.mApp != null) && (this.mShouldCheckAction))
        {
          this.mShouldCheckAction = false;
          ApolloResManagerFacade.a.a(Scene.AIO).a(false, "getActionByPackageId action not exit", 1);
        }
      }
      return localArrayList2;
      label457:
      i += 1;
    }
  }
  
  public void getActionIdListByPkgIdAndTagName(int paramInt, String paramString, IApolloTagActionDataListener paramIApolloTagActionDataListener)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (this.mActionTagList.isEmpty())
    {
      localObject = this.mApp.getEntityManagerFactory().createEntityManager().query(ApolloActionTag.class);
      if (localObject != null) {
        synchronized (this.mActionTagList)
        {
          this.mActionTagList = ((List)localObject);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloDaoManager", 2, new Object[] { "[getActionTagList] db list size:", Integer.valueOf(this.mActionTagList.size()) });
      }
    }
    if (this.mActionTagList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloDaoManager", 2, "ActionTagList is null");
      }
      paramIApolloTagActionDataListener.a();
      return;
    }
    synchronized (this.mActionTagList)
    {
      localObject = this.mActionTagList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ApolloActionTag localApolloActionTag = (ApolloActionTag)((Iterator)localObject).next();
        if ((localApolloActionTag.packageId == paramInt) && (paramString.equals(localApolloActionTag.tagName))) {
          localArrayList.add(Integer.valueOf(localApolloActionTag.actionId));
        }
      }
      paramIApolloTagActionDataListener.a(localArrayList);
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public ApolloActionData getActionInfoById(int paramInt)
  {
    if (this.mApp == null) {
      return null;
    }
    if (this.actionList.size() > 0) {
      synchronized (this.actionList)
      {
        Iterator localIterator = this.actionList.iterator();
        while (localIterator.hasNext())
        {
          ApolloActionData localApolloActionData = (ApolloActionData)localIterator.next();
          if (localApolloActionData.actionId == paramInt) {
            return localApolloActionData;
          }
        }
      }
    }
    ??? = this.mApp.getEntityManagerFactory().createEntityManager().query(ApolloActionData.class, false, "actionId=?", new String[] { String.valueOf(paramInt) }, null, null, null, null);
    if ((??? != null) && (???.size() > 0)) {
      return (ApolloActionData)???.get(0);
    }
    return null;
  }
  
  public ApolloActionData getActionInfoByIdFromCache(int paramInt)
  {
    if (this.mApp == null) {
      return null;
    }
    if (this.actionList.size() > 0) {
      synchronized (this.actionList)
      {
        Iterator localIterator = this.actionList.iterator();
        while (localIterator.hasNext())
        {
          ApolloActionData localApolloActionData = (ApolloActionData)localIterator.next();
          if (localApolloActionData.actionId == paramInt) {
            return localApolloActionData;
          }
        }
        return null;
      }
    }
    return null;
  }
  
  public HashMap<String, Integer> getActionKeywordsMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.mKeywordsActionMap);
    return localHashMap;
  }
  
  public List<ApolloActionData> getActionList()
  {
    Object localObject = this.mApp;
    Integer localInteger = null;
    if (localObject == null) {
      return null;
    }
    if (this.actionList.size() > 0) {
      return this.actionList;
    }
    localObject = this.mApp.getEntityManagerFactory().createEntityManager().query(ApolloActionData.class);
    if (QLog.isColorLevel())
    {
      if (localObject != null) {
        localInteger = Integer.valueOf(((List)localObject).size());
      }
      QLog.d("[cmshow]ApolloDaoManager", 2, new Object[] { "[getActionList] db list size:", localInteger });
    }
    return localObject;
  }
  
  public int getActionPkgId(int paramInt)
  {
    synchronized (this.actionPackageList)
    {
      Iterator localIterator = this.actionPackageList.iterator();
      while (localIterator.hasNext())
      {
        ApolloActionPackageData localApolloActionPackageData = (ApolloActionPackageData)localIterator.next();
        if (localApolloActionPackageData.acitonId == paramInt)
        {
          paramInt = localApolloActionPackageData.packageId;
          return paramInt;
        }
      }
      return -1;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public List<ApolloActionPush> getActionPushData()
  {
    if (this.actionPushList.size() > 0) {
      synchronized (this.actionPushList)
      {
        ArrayList localArrayList = new ArrayList(this.actionPushList.size());
        localArrayList.addAll(this.actionPushList);
        return localArrayList;
      }
    }
    ??? = this.mApp;
    if (??? == null) {
      return null;
    }
    List localList = ((AppInterface)???).getEntityManagerFactory().createEntityManager().query(ApolloActionPush.class);
    if ((localList != null) && (localList.size() > 0)) {
      synchronized (this.actionPushList)
      {
        this.actionPushList.addAll(localList);
        return localList;
      }
    }
    return localList1;
  }
  
  public ApolloActionPush getActionPushDataByAIO(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return null;
    }
    Object localObject = getActionPushData();
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return null;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ApolloActionPush localApolloActionPush = (ApolloActionPush)((Iterator)localObject).next();
        if ((localApolloActionPush != null) && (localApolloActionPush.mAioType == paramSessionInfo.a) && (!TextUtils.isEmpty(paramSessionInfo.b)))
        {
          String str = paramSessionInfo.b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localApolloActionPush.mSessionId);
          localStringBuilder.append("");
          if (str.equals(localStringBuilder.toString())) {
            return localApolloActionPush;
          }
        }
      }
    }
    return null;
  }
  
  public List<ApolloActionTag> getActionTagList()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mActionTagList)
    {
      Iterator localIterator = this.mActionTagList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((ApolloActionTag)localIterator.next());
      }
      return localArrayList;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public ApolloBaseInfo getApolloBaseInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ??? = this.mApp;
    int i;
    if ((??? != null) && (paramString.equals(((AppRuntime)???).getCurrentAccountUin()))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      ??? = this.mSelfApolloBaseInfo;
      if (??? != null)
      {
        ApolloDebugUtils.a(paramString, (AppRuntime)???, (ApolloBaseInfo)???);
        return this.mSelfApolloBaseInfo;
      }
    }
    label475:
    Object localObject3;
    synchronized (this.mApolloBaseInfoCache)
    {
      if (this.mApolloBaseInfoCache.containsKey(paramString))
      {
        paramString = (ApolloBaseInfo)this.mApolloBaseInfoCache.get(paramString);
        return paramString;
      }
      if (!this.isApolloBaseInfoCacheInited)
      {
        ??? = this.em;
        if (??? == null)
        {
          QLog.e("[cmshow]ApolloDaoManager", 1, "[getApolloBaseInfo] from database error, em is null!");
          return null;
        }
        ??? = (ApolloBaseInfo)((EntityManager)???).find(ApolloBaseInfo.class, paramString);
        if (i != 0)
        {
          ApolloDebugUtils.a(paramString, (AppRuntime)???, (ApolloBaseInfo)???);
          this.mSelfApolloBaseInfo = ((ApolloBaseInfo)???);
        }
        ??? = ???;
        if (??? != null) {
          synchronized (this.mApolloBaseInfoCache)
          {
            this.mApolloBaseInfoCache.put(paramString, ???);
            ??? = new StringBuilder();
            ((StringBuilder)???).append("unInit mApolloBaseInfoCache, find from db uin: ");
            ((StringBuilder)???).append(LogUtil.wrapLogUin(paramString));
            ((StringBuilder)???).append(", apollo status: ");
            ((StringBuilder)???).append(((ApolloBaseInfo)???).apolloStatus);
            ((StringBuilder)???).append(";apolloBaseInfo : ");
            ((StringBuilder)???).append(((ApolloBaseInfo)???).toString());
            QLog.d("[cmshow]ApolloDaoManager", 1, ((StringBuilder)???).toString());
            return ???;
          }
        }
      }
      else
      {
        ??? = null;
      }
      synchronized (this.mApolloBaseInfoCache)
      {
        if (this.mApolloBaseInfoCache.containsKey(paramString))
        {
          ??? = (ApolloBaseInfo)this.mApolloBaseInfoCache.get(paramString);
        }
        else
        {
          if (this.em == null)
          {
            QLog.e("[cmshow]ApolloDaoManager", 2, "[getApolloBaseInfo] from database error, em is null!");
            return null;
          }
          try
          {
            if (this.mUnCacheUinSets.contains(Long.valueOf(Long.parseLong(paramString))))
            {
              ??? = (ApolloBaseInfo)this.em.find(ApolloBaseInfo.class, paramString);
              ??? = ???;
              if (??? == null) {
                break label475;
              }
              try
              {
                this.mApolloBaseInfoCache.put(paramString, ???);
                ??? = ???;
                if (QLog.isColorLevel())
                {
                  ??? = new StringBuilder();
                  ((StringBuilder)???).append("mApolloBaseInfoCache unCache, mUnCacheUinSets contains, find from db uin: ");
                  ((StringBuilder)???).append(LogUtil.wrapLogUin(paramString));
                  ((StringBuilder)???).append(", apollo status: ");
                  ((StringBuilder)???).append(((ApolloBaseInfo)???).apolloStatus);
                  QLog.d("[cmshow]ApolloDaoManager", 2, ((StringBuilder)???).toString());
                  ??? = ???;
                }
              }
              catch (NumberFormatException localNumberFormatException2)
              {
                ??? = ???;
                ??? = localNumberFormatException2;
              }
            }
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            QLog.e("[cmshow]ApolloDaoManager", 1, localNumberFormatException1, new Object[0]);
          }
        }
        localObject3 = ???;
        if (??? == null)
        {
          localObject3 = new ApolloBaseInfo();
          ((ApolloBaseInfo)localObject3).uin = paramString;
          QLog.d("[cmshow]ApolloDaoManager", 2, "apolloBaseInfo is null, make default.");
        }
        paramString = new StringBuilder();
        paramString.append("apolloBaseInfo : ");
        paramString.append(((ApolloBaseInfo)localObject3).toString());
        QLog.d("[cmshow]ApolloDaoManager", 2, paramString.toString());
        return localObject3;
      }
    }
  }
  
  public ApolloBaseInfo getApolloBaseInfoFromCache(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = this.mApp;
    if ((localObject != null) && (paramString.equals(((AppRuntime)localObject).getCurrentAccountUin())) && (this.mSelfApolloBaseInfo != null))
    {
      paramString = new StringBuilder();
      paramString.append("getApolloBaseInfoFromCache mSelfApolloBaseInfo : ");
      paramString.append(this.mSelfApolloBaseInfo);
      QLog.d("[cmshow]ApolloDaoManager", 1, paramString.toString());
      return this.mSelfApolloBaseInfo;
    }
    if (this.mApolloBaseInfoCache.containsKey(paramString))
    {
      paramString = (ApolloBaseInfo)this.mApolloBaseInfoCache.get(paramString);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getApolloBaseInfoFromCache mApolloBaseInfoCache : ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("[cmshow]ApolloDaoManager", 1, ((StringBuilder)localObject).toString());
      return paramString;
    }
    ThreadManager.getSubThreadHandler().post(new ApolloDaoManagerServiceImpl.11(this, paramString));
    return null;
  }
  
  public ConcurrentHashMap<Integer, String> getApolloGameVer()
  {
    return this.mApolloGameVer;
  }
  
  public ApolloPandora getApolloPandora(String paramString, boolean paramBoolean)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    ??? = null;
    if (bool) {
      return null;
    }
    if (this.apolloPandoraCache.contains(paramString)) {
      return (ApolloPandora)this.apolloPandoraCache.get(paramString);
    }
    if (paramBoolean)
    {
      ApolloPandora localApolloPandora = (ApolloPandora)this.em.find(ApolloPandora.class, paramString);
      ??? = localApolloPandora;
      if (localApolloPandora != null) {
        synchronized (this.apolloPandoraCache)
        {
          this.apolloPandoraCache.put(paramString, localApolloPandora);
          return localApolloPandora;
        }
      }
    }
    return ???;
  }
  
  public List<ApolloBattleGameInfo> getBattleGameList(int paramInt)
  {
    if (this.mApp == null) {
      return null;
    }
    Object localObject2 = this.mBattleGameList;
    if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
      synchronized (this.mBattleGameList)
      {
        ArrayList localArrayList = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ApolloBattleGameInfo localApolloBattleGameInfo = (ApolloBattleGameInfo)((Iterator)localObject2).next();
          if (localApolloBattleGameInfo.sceneId == paramInt) {
            localArrayList.add(localApolloBattleGameInfo);
          }
        }
        return localArrayList;
      }
    }
    List localList2 = this.mApp.getEntityManagerFactory().createEntityManager().query(ApolloBattleGameInfo.class);
    if (localList2 != null) {}
    for (;;)
    {
      int i;
      synchronized (this.mBattleGameList)
      {
        i = this.mBattleGameList.size() - 1;
        if (i >= 0)
        {
          if (((ApolloBattleGameInfo)this.mBattleGameList.get(i)).sceneId != paramInt) {
            break label218;
          }
          this.mBattleGameList.remove(i);
          break label218;
        }
        this.mBattleGameList.addAll(localList2);
        return localList2;
      }
      return localList;
      label218:
      i -= 1;
    }
  }
  
  public List<CmBattleGameInfo> getCmBattleGameInfoList()
  {
    if (this.mApp == null) {
      return null;
    }
    ??? = this.mCmBattleGameInfoSet;
    if ((??? != null) && (???.size() > 0)) {
      synchronized (this.mCmBattleGameInfoSet)
      {
        ArrayList localArrayList = new ArrayList(this.mCmBattleGameInfoSet);
        return localArrayList;
      }
    }
    Object localObject2 = this.mApp.getEntityManagerFactory().createEntityManager().query(CmBattleGameInfo.class);
    if (localObject2 != null) {
      synchronized (this.mCmBattleGameInfoSet)
      {
        this.mCmBattleGameInfoSet.addAll((Collection)localObject2);
        localObject2 = new ArrayList((Collection)localObject2);
        return localObject2;
      }
    }
    return null;
  }
  
  public List<ApolloCommConfigKvData> getCommConfigKvLists()
  {
    if (this.mCommConfigKvLists.isEmpty())
    {
      List localList2 = this.mApp.getEntityManagerFactory().createEntityManager().query(ApolloCommConfigKvData.class);
      if (localList2 != null) {
        synchronized (this.mCommConfigKvLists)
        {
          this.mCommConfigKvLists = localList2;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloDaoManager", 2, new Object[] { "[getmCommConfigKvLists] db list size:", Integer.valueOf(this.mCommConfigKvLists.size()) });
      }
    }
    return this.mCommConfigKvLists;
  }
  
  public String getCommConfigValueByCache(String paramString)
  {
    new ArrayList();
    Iterator localIterator = this.mCommConfigKvLists.iterator();
    while (localIterator.hasNext())
    {
      ApolloCommConfigKvData localApolloCommConfigKvData = (ApolloCommConfigKvData)localIterator.next();
      if (localApolloCommConfigKvData.key.equals(paramString)) {
        return localApolloCommConfigKvData.value;
      }
    }
    return "";
  }
  
  public DrawerPushItem getCurrentPushItemByMsgId(String paramString)
  {
    synchronized (this.mPushLock)
    {
      if ((this.mDrawerPushItems != null) && (!this.mDrawerPushItems.isEmpty()))
      {
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
        return null;
      }
      return null;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public DrawerPushItem getCurrentPushItemByUserStatus(int paramInt1, int paramInt2)
  {
    label456:
    synchronized (this.mPushLock)
    {
      if ((this.mDrawerPushItems != null) && (!this.mDrawerPushItems.isEmpty()))
      {
        Collections.sort(this.mDrawerPushItems, this.mPushItemComparator);
        long l = System.currentTimeMillis() / 1000L;
        Object localObject2;
        Object localObject4;
        if (paramInt1 == 0)
        {
          localObject2 = new ArrayList();
          localObject4 = new ArrayList();
          Iterator localIterator = this.mDrawerPushItems.iterator();
          while (localIterator.hasNext())
          {
            DrawerPushItem localDrawerPushItem = (DrawerPushItem)localIterator.next();
            if ((localDrawerPushItem.msg_type == paramInt1) && (localDrawerPushItem.start_ts < l) && (localDrawerPushItem.end_ts > l))
            {
              if (localDrawerPushItem.show_sum < localDrawerPushItem.show_counts) {
                break label456;
              }
              if ((goto 83) && ((localDrawerPushItem.target_model == 0) || (localDrawerPushItem.target_model == 2) || (localDrawerPushItem.target_model == paramInt2))) {
                if (localDrawerPushItem.fromTianshu) {
                  ((List)localObject2).add(localDrawerPushItem);
                } else {
                  ((List)localObject4).add(localDrawerPushItem);
                }
              }
            }
          }
          QLog.d("[cmshow]ApolloDaoManager", 1, new Object[] { "getCurrentPushItemByUserStatus, tianshuDrawerList=", localObject2, ", reddotDrawerList=", localObject4 });
          if (((List)localObject2).size() > 0)
          {
            localObject2 = (DrawerPushItem)((List)localObject2).get(0);
            return localObject2;
          }
          if (((List)localObject4).size() > 0)
          {
            localObject2 = (DrawerPushItem)((List)localObject4).get(0);
            return localObject2;
          }
        }
        else
        {
          localObject2 = this.mDrawerPushItems.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (DrawerPushItem)((Iterator)localObject2).next();
            if ((((DrawerPushItem)localObject4).msg_type == paramInt1) && (((DrawerPushItem)localObject4).start_ts < l) && (((DrawerPushItem)localObject4).end_ts > l) && (((DrawerPushItem)localObject4).show_sum < ((DrawerPushItem)localObject4).show_counts)) {
              if (((paramInt2 != 0) && (paramInt2 != 2)) || ((((DrawerPushItem)localObject4).target_model != 0) && (((DrawerPushItem)localObject4).target_model != 2)))
              {
                if (((DrawerPushItem)localObject4).target_model == paramInt2) {
                  return localObject4;
                }
              }
              else {
                return localObject4;
              }
            }
          }
        }
        return null;
      }
      return null;
    }
  }
  
  public List<ApolloActionData> getFavActionList()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = this.favActionList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.favActionList.size())
        {
          ApolloActionData localApolloActionData = findActionById(((ApolloFavActionData)this.favActionList.get(i)).actionId);
          if (localApolloActionData != null) {
            localArrayList.add(localApolloActionData);
          }
        }
        else
        {
          return localArrayList;
        }
      }
      finally
      {
        continue;
        throw localObject;
        continue;
        i += 1;
      }
    }
  }
  
  public List<ApolloActionData> getFavNeedDownloadAction()
  {
    try
    {
      localObject1 = this.mApp;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = (List)getFavPanelActionPairInfo().second;
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label107;
      }
      localArrayList = new ArrayList();
      i = 0;
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        ArrayList localArrayList;
        int i;
        for (;;)
        {
          label107:
          throw localObject2;
        }
        i += 1;
      }
    }
    if (i < ((List)localObject1).size())
    {
      if (((ApolloActionData)((List)localObject1).get(i)).status == 0) {
        localArrayList.add(((List)localObject1).get(i));
      }
    }
    else
    {
      i = localArrayList.size();
      if (i > 0) {
        return localArrayList;
      }
      return null;
    }
  }
  
  public List<ApolloFavActionData> getFavPackageActionList()
  {
    if (this.favActionList.size() > 0) {
      return this.favActionList;
    }
    ??? = this.mApp;
    if (??? == null) {
      return this.favActionList;
    }
    List localList = ((AppInterface)???).getEntityManagerFactory().createEntityManager().query(ApolloFavActionData.class);
    if (localList == null) {
      return this.favActionList;
    }
    synchronized (this.favActionList)
    {
      this.favActionList = localList;
      return this.favActionList;
    }
  }
  
  public Pair<List<ApolloFavActionData>, List<ApolloActionData>> getFavPanelActionPairInfo()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloDaoManager", 2, "getFavPanelActionPairInfo");
    }
    List localList = getFavPackageActionList();
    Collections.sort(localList, new ApolloDaoManagerServiceImpl.4(this));
    ArrayList localArrayList = new ArrayList(localList.size());
    int m = localList.size();
    int i = 0;
    int k;
    for (int j = 1; i < m; j = k)
    {
      Object localObject = (ApolloFavActionData)localList.get(i);
      k = j;
      if (localObject != null)
      {
        localObject = findActionById(((ApolloFavActionData)localObject).actionId);
        if (localObject != null)
        {
          localArrayList.add(localObject);
          k = j;
        }
        else
        {
          k = 0;
        }
      }
      i += 1;
    }
    if (j == 0)
    {
      QLog.e("[cmshow]ApolloDaoManager", 1, "[getFavPanelActionPairInfo] has some action not exit and check action json");
      if ((this.mApp != null) && (this.mShouldCheckAction))
      {
        this.mShouldCheckAction = false;
        ApolloResManagerFacade.a.a(Scene.AIO).a(false, "getFavPanelActionPairInfo action not exit", 1);
      }
    }
    return new Pair(localList, localArrayList);
  }
  
  public List<ApolloActionData> getHideActionList()
  {
    if (this.mApp == null) {
      return null;
    }
    if (this.actionList.size() > 0) {}
    for (;;)
    {
      int i;
      synchronized (this.actionList)
      {
        ArrayList localArrayList = new ArrayList();
        i = 0;
        if (i < this.actionList.size())
        {
          if (((ApolloActionData)this.actionList.get(i)).isShow != 0) {
            break label149;
          }
          localArrayList.add(this.actionList.get(i));
          break label149;
        }
        if (localArrayList.size() > 0) {
          return localArrayList;
        }
      }
      return this.mApp.getEntityManagerFactory().createEntityManager().query(ApolloActionData.class, false, "isShow=?", new String[] { String.valueOf(0) }, null, null, null, null);
      label149:
      i += 1;
    }
  }
  
  public ConcurrentHashMap<Integer, ApolloActionData> getLimitFreeActionMap()
  {
    if (this.mLimitFreeActionMap.size() > 0) {
      return this.mLimitFreeActionMap;
    }
    Object localObject = getObtainedActionListByType(6);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ApolloObtainedActionData localApolloObtainedActionData = (ApolloObtainedActionData)((Iterator)localObject).next();
        if ((!isObtainActionById(localApolloObtainedActionData.id)) && (localApolloObtainedActionData.endts >= NetConnInfoCenter.getServerTime()))
        {
          ApolloActionData localApolloActionData = new ApolloActionData();
          localApolloActionData.actionId = localApolloObtainedActionData.id;
          localApolloActionData.limitStart = localApolloObtainedActionData.beginTs;
          localApolloActionData.limitEnd = localApolloObtainedActionData.endts;
          this.mLimitFreeActionMap.put(Integer.valueOf(localApolloActionData.actionId), localApolloActionData);
        }
      }
    }
    return this.mLimitFreeActionMap;
  }
  
  public int getMaxKeywordsLength()
  {
    return this.mMaxKeywordsLength;
  }
  
  public List<ApolloActionData> getNeedDownloadAction(int paramInt)
  {
    if (this.mApp == null) {
      return null;
    }
    List localList = getActionByPackageId(paramInt);
    if ((localList != null) && (localList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramInt = 0;
      while (paramInt < localList.size())
      {
        if ((((ApolloActionData)localList.get(paramInt)).status == 0) && (((ApolloActionData)localList.get(paramInt)).isShow == 1)) {
          localArrayList.add(localList.get(paramInt));
        }
        paramInt += 1;
      }
      if (localArrayList.size() > 0) {
        return localArrayList;
      }
    }
    return null;
  }
  
  public List<ApolloActionData> getNotFeeTypeActionList(int paramInt)
  {
    if (this.mApp == null) {
      return null;
    }
    if (this.actionList.size() > 0) {}
    for (;;)
    {
      int i;
      synchronized (this.actionList)
      {
        ArrayList localArrayList = new ArrayList();
        i = 0;
        if (i < this.actionList.size())
        {
          if (((ApolloActionData)this.actionList.get(i)).feeType == paramInt) {
            break label156;
          }
          localArrayList.add(this.actionList.get(i));
          break label156;
        }
        if (localArrayList.size() > 0) {
          return localArrayList;
        }
      }
      return this.mApp.getEntityManagerFactory().createEntityManager().query(ApolloActionData.class, false, "feeType!=?", new String[] { String.valueOf(paramInt) }, null, null, null, null);
      label156:
      i += 1;
    }
  }
  
  public List<ApolloObtainedActionData> getObtainedActionListByType(int paramInt)
  {
    if (this.mApp == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    List localList1 = this.mActionObtainedList;
    int i;
    if ((localList1 != null) && (localList1.size() > 0))
    {
      localList1 = this.mActionObtainedList;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.mActionObtainedList.size())
        {
          if (((ApolloObtainedActionData)this.mActionObtainedList.get(i)).type != paramInt) {
            break label115;
          }
          localArrayList.add(this.mActionObtainedList.get(i));
          break label115;
        }
        return localArrayList;
      }
      finally {}
      return localList;
      label115:
      i += 1;
    }
  }
  
  public ConcurrentHashMap<Integer, ApolloActionData> getObtainedActiveActionMap()
  {
    if (this.mObtainedActiveActionMap.size() > 0) {
      return this.mObtainedActiveActionMap;
    }
    Object localObject = getObtainedActionListByType(0);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ApolloObtainedActionData localApolloObtainedActionData = (ApolloObtainedActionData)((Iterator)localObject).next();
        ApolloActionData localApolloActionData = new ApolloActionData();
        localApolloActionData.actionId = localApolloObtainedActionData.id;
        localApolloActionData.obtainedTime = localApolloObtainedActionData.beginTs;
        this.mObtainedActiveActionMap.put(Integer.valueOf(localApolloActionData.actionId), localApolloActionData);
      }
    }
    return this.mObtainedActiveActionMap;
  }
  
  public List<ApolloActionPackageData> getPackageActionDataById(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    int i;
    if (this.actionPackageList.size() > 0)
    {
      localObject2 = this.actionPackageList;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.actionPackageList.size())
        {
          if (((ApolloActionPackageData)this.actionPackageList.get(i)).packageId != paramInt) {
            break label255;
          }
          localArrayList.add(this.actionPackageList.get(i));
          break label255;
        }
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloDaoManager", 2, new Object[] { "return getPackageActionDataById from cache, size:", Integer.valueOf(localArrayList.size()) });
        }
        return localArrayList;
      }
      finally {}
      localObject2 = this.mApp;
      if (localObject2 == null) {
        return localList;
      }
      Object localObject1 = ((AppInterface)localObject2).getEntityManagerFactory().createEntityManager();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("");
      localObject2 = ((EntityManager)localObject1).query(ApolloActionPackageData.class, false, "packageId=?", new String[] { ((StringBuilder)localObject2).toString() }, null, null, null, null);
      if (QLog.isColorLevel())
      {
        if (localObject2 == null) {
          localObject1 = null;
        } else {
          localObject1 = Integer.valueOf(((List)localObject2).size());
        }
        QLog.d("[cmshow]ApolloDaoManager", 2, new Object[] { "return getPackageActionDataById from db, size:", localObject1 });
      }
      return localObject2;
      label255:
      i += 1;
    }
  }
  
  public List<ApolloActionPackageData> getPackageDataByActionId(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    List localList;
    int i;
    if (this.actionPackageList.size() > 0)
    {
      localList = this.actionPackageList;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.actionPackageList.size())
        {
          ApolloActionPackageData localApolloActionPackageData = (ApolloActionPackageData)this.actionPackageList.get(i);
          if (localApolloActionPackageData.acitonId != paramInt) {
            break label95;
          }
          localArrayList.add(localApolloActionPackageData);
          break label95;
        }
        return localArrayList;
      }
      finally {}
      return localList1;
      label95:
      i += 1;
    }
  }
  
  public List<ApolloActionPackage> getPackageInfoBySession(int paramInt)
  {
    if (this.mApp == null) {
      return null;
    }
    if (CmShowAioMatcherImpl.judgeSupported(paramInt, 1))
    {
      localObject = String.valueOf(0);
    }
    else
    {
      if (!CmShowAioMatcherImpl.judgeSupported(paramInt, 2)) {
        break label204;
      }
      localObject = String.valueOf(1);
    }
    if (this.packageList.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      paramInt = 0;
      while (paramInt < this.packageList.size())
      {
        if ((((ApolloActionPackage)this.packageList.get(paramInt)).sessionType == Integer.parseInt((String)localObject)) || (((ApolloActionPackage)this.packageList.get(paramInt)).sessionType == 0)) {
          localArrayList.add(this.packageList.get(paramInt));
        }
        paramInt += 1;
      }
      if (localArrayList.size() > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloDaoManager", 2, "return packageInfoBySession from cache");
        }
        return localArrayList;
      }
    }
    return this.mApp.getEntityManagerFactory().createEntityManager().query(ApolloActionPackage.class, false, "sessionType=? or sessionType=?", new String[] { "0", localObject }, null, null, null, null);
    label204:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[getPackageInfoBySession], error type:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.e("[cmshow]ApolloDaoManager", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  /* Error */
  public Map<String, ApolloPreDownloadData> getPreDownloadRes()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   4: ifnonnull +11 -> 15
    //   7: new 826	java/util/HashMap
    //   10: dup
    //   11: invokespecial 827	java/util/HashMap:<init>	()V
    //   14: areturn
    //   15: aload_0
    //   16: getfield 137	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mPreDownloadMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   19: invokevirtual 475	java/util/concurrent/ConcurrentHashMap:size	()I
    //   22: ifle +8 -> 30
    //   25: aload_0
    //   26: getfield 137	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mPreDownloadMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   29: areturn
    //   30: aload_0
    //   31: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   34: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   37: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   40: astore_1
    //   41: new 90	java/util/ArrayList
    //   44: dup
    //   45: invokespecial 91	java/util/ArrayList:<init>	()V
    //   48: astore_2
    //   49: aload_1
    //   50: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   53: astore 4
    //   55: aload 4
    //   57: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   60: aload_1
    //   61: ldc_w 1087
    //   64: invokevirtual 293	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   67: checkcast 90	java/util/ArrayList
    //   70: astore_1
    //   71: aload 4
    //   73: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   76: aload 4
    //   78: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   81: goto +31 -> 112
    //   84: astore_2
    //   85: goto +12 -> 97
    //   88: astore_1
    //   89: goto +83 -> 172
    //   92: astore_3
    //   93: aload_2
    //   94: astore_1
    //   95: aload_3
    //   96: astore_2
    //   97: ldc 12
    //   99: iconst_1
    //   100: ldc_w 1089
    //   103: aload_2
    //   104: invokestatic 432	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload 4
    //   109: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   112: aload_1
    //   113: ifnull +54 -> 167
    //   116: aload_1
    //   117: invokeinterface 266 1 0
    //   122: ifle +45 -> 167
    //   125: aload_1
    //   126: invokeinterface 239 1 0
    //   131: astore_1
    //   132: aload_1
    //   133: invokeinterface 244 1 0
    //   138: ifeq +29 -> 167
    //   141: aload_1
    //   142: invokeinterface 248 1 0
    //   147: checkcast 1087	com/tencent/mobileqq/apollo/model/ApolloPreDownloadData
    //   150: astore_2
    //   151: aload_0
    //   152: getfield 137	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mPreDownloadMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   155: aload_2
    //   156: getfield 1092	com/tencent/mobileqq/apollo/model/ApolloPreDownloadData:resId	Ljava/lang/String;
    //   159: aload_2
    //   160: invokevirtual 470	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   163: pop
    //   164: goto -32 -> 132
    //   167: aload_0
    //   168: getfield 137	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mPreDownloadMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   171: areturn
    //   172: aload 4
    //   174: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   177: goto +5 -> 182
    //   180: aload_1
    //   181: athrow
    //   182: goto -2 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	ApolloDaoManagerServiceImpl
    //   40	31	1	localObject1	Object
    //   88	1	1	localObject2	Object
    //   94	87	1	localObject3	Object
    //   48	1	2	localArrayList	ArrayList
    //   84	10	2	localException1	Exception
    //   96	64	2	localObject4	Object
    //   92	4	3	localException2	Exception
    //   53	120	4	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    // Exception table:
    //   from	to	target	type
    //   71	76	84	java/lang/Exception
    //   60	71	88	finally
    //   71	76	88	finally
    //   97	107	88	finally
    //   60	71	92	java/lang/Exception
  }
  
  public List<ApolloActionData> getRecommendActionDataList()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mRecommendActionList)
    {
      Iterator localIterator = this.mRecommendActionList.iterator();
      while (localIterator.hasNext())
      {
        ApolloActionData localApolloActionData = getActionInfoByIdFromCache(((ApolloRecommendAction)localIterator.next()).id);
        if (localApolloActionData != null) {
          localArrayList.add(localApolloActionData);
        }
      }
      return localArrayList;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public Pair<List<ApolloActionPackageData>, List<ApolloActionData>> getRecommendActionList()
  {
    QLog.d("[cmshow]ApolloDaoManager", 1, "getRecommendActionList");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ApolloActionData localApolloActionData;
    label312:
    String str;
    label328:
    synchronized (this.mRecommendActionList)
    {
      Iterator localIterator = this.mRecommendActionList.iterator();
      while (localIterator.hasNext())
      {
        ApolloRecommendAction localApolloRecommendAction = (ApolloRecommendAction)localIterator.next();
        localApolloActionData = getActionInfoByIdFromCache(localApolloRecommendAction.id);
        List localList2 = getPackageDataByActionId(localApolloRecommendAction.id);
        if ((localApolloActionData == null) || (localList2 == null) || (localList2.size() <= 0)) {
          break label312;
        }
        localArrayList2.add(localApolloActionData);
        localArrayList1.add(localList2.get(0));
        continue;
        if ((localList2 == null) || (localList2.size() == 0)) {
          break label328;
        }
        QLog.d("[cmshow]ApolloDaoManager", 1, new Object[] { "getRecommendActionList, invalid, actionId=", Integer.valueOf(localApolloRecommendAction.id), ", reason=", localStringBuilder });
      }
      StringBuilder localStringBuilder = new StringBuilder();
      int j = localArrayList2.size();
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(((ApolloActionData)localArrayList2.get(i)).actionId);
        if (i != j - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
      QLog.d("[cmshow]ApolloDaoManager", 1, new Object[] { "getRecommendActionList, actionIdList=", localStringBuilder.toString() });
      return new Pair(localArrayList1, localArrayList2);
    }
  }
  
  public List<ApolloRecommendAction> getRecommendList()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mRecommendActionList)
    {
      Iterator localIterator = this.mRecommendActionList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((ApolloRecommendAction)localIterator.next());
      }
      return localArrayList;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public List<ApolloRelationTag> getRelationTagList()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.mRelationTagList.size() > 0) {
      synchronized (this.mRelationTagList)
      {
        localArrayList.addAll(this.mRelationTagList);
        return localArrayList;
      }
    }
    try
    {
      List localList2 = this.mApp.getEntityManagerFactory().createEntityManager().query(ApolloRelationTag.class);
      if (localList2 != null) {
        synchronized (this.mRelationTagList)
        {
          this.mRelationTagList.addAll(localList2);
          localList.addAll(this.mRelationTagList);
          return localList;
        }
      }
      return localList;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]ApolloDaoManager", 1, "getRelationTagList error: ", localThrowable);
    }
  }
  
  public ApolloBaseInfo getSelfApolloBaseInfo()
  {
    return this.mSelfApolloBaseInfo;
  }
  
  public void getTagListByPkgId(int paramInt, IApolloTagDataListener paramIApolloTagDataListener)
  {
    ArrayList localArrayList = new ArrayList();
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Object localObject;
    if (this.mActionTagList.isEmpty())
    {
      localObject = this.mApp.getEntityManagerFactory().createEntityManager().query(ApolloActionTag.class);
      if (localObject != null) {
        synchronized (this.mActionTagList)
        {
          this.mActionTagList = ((List)localObject);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloDaoManager", 2, new Object[] { "[getActionTagList] db list size:", Integer.valueOf(this.mActionTagList.size()) });
      }
    }
    if (this.mActionTagList.isEmpty())
    {
      QLog.d("[cmshow]ApolloDaoManager", 2, "ActionTagList is null");
      paramIApolloTagDataListener.a();
      return;
    }
    synchronized (this.mActionTagList)
    {
      localObject = this.mActionTagList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ApolloActionTag localApolloActionTag = (ApolloActionTag)((Iterator)localObject).next();
        if ((paramInt == localApolloActionTag.packageId) && (localLinkedHashSet.add(localApolloActionTag.tagName))) {
          localArrayList.add(localApolloActionTag.tagName);
        }
      }
      paramIApolloTagDataListener.a(localArrayList);
      return;
    }
    for (;;)
    {
      throw paramIApolloTagDataListener;
    }
  }
  
  public int getWhiteFaceIdMapping(int paramInt1, int paramInt2)
  {
    ApolloWhiteFaceID localApolloWhiteFaceID = (ApolloWhiteFaceID)this.mWhiteFaceIdMapping.get(Integer.valueOf(paramInt1));
    if (localApolloWhiteFaceID != null)
    {
      if (paramInt2 == 1) {
        return localApolloWhiteFaceID.action2d;
      }
      return localApolloWhiteFaceID.action3d;
    }
    return 0;
  }
  
  public boolean hasAioPushData(AioPushData paramAioPushData)
  {
    boolean bool = false;
    if (paramAioPushData != null)
    {
      List localList = this.mAioPushDataList;
      if (localList != null) {
        try
        {
          if (this.mAioPushDataList.indexOf(paramAioPushData) >= 0) {
            bool = true;
          }
          return bool;
        }
        finally {}
      }
    }
    return false;
  }
  
  public void insertFavActionPackageData(ApolloFavActionData paramApolloFavActionData)
  {
    if (paramApolloFavActionData == null) {
      return;
    }
    synchronized (this.favActionList)
    {
      this.favActionList.add(paramApolloFavActionData);
      ??? = this.mApp;
      if (??? == null) {
        return;
      }
      ??? = ((AppInterface)???).getEntityManagerFactory().createEntityManager();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("insert ApolloFavActionData id=");
        localStringBuilder.append(paramApolloFavActionData.actionId);
        localStringBuilder.append(" text=");
        localStringBuilder.append(paramApolloFavActionData.text);
        QLog.d("[cmshow]ApolloDaoManager", 2, localStringBuilder.toString());
      }
      ((EntityManager)???).persist(paramApolloFavActionData);
      return;
    }
  }
  
  public void insertObtainedActionData(ApolloObtainedActionData paramApolloObtainedActionData)
  {
    if (paramApolloObtainedActionData == null) {
      return;
    }
    synchronized (this.mActionObtainedList)
    {
      this.mActionObtainedList.add(paramApolloObtainedActionData);
      this.mObtainedActiveActionMap.clear();
      ??? = this.mApp;
      if (??? == null) {
        return;
      }
      ??? = ((AppInterface)???).getEntityManagerFactory().createEntityManager();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("insert ApolloObtainedActionData:");
        localStringBuilder.append(paramApolloObtainedActionData.toString());
        QLog.d("[cmshow]ApolloDaoManager", 2, localStringBuilder.toString());
      }
      ((EntityManager)???).persist(paramApolloObtainedActionData);
      return;
    }
  }
  
  public boolean isLimitFreeActionById(int paramInt)
  {
    ConcurrentHashMap localConcurrentHashMap = getLimitFreeActionMap();
    if (localConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      if (((ApolloActionData)localConcurrentHashMap.get(Integer.valueOf(paramInt))).limitEnd >= NetConnInfoCenter.getServerTime()) {
        return true;
      }
      localConcurrentHashMap.remove(Integer.valueOf(paramInt));
      ThreadManager.post(new ApolloDaoManagerServiceImpl.5(this, paramInt), 5, null, true);
    }
    return false;
  }
  
  public boolean isObtainActionById(int paramInt)
  {
    return getObtainedActiveActionMap().containsKey(Integer.valueOf(paramInt));
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof AppInterface))
    {
      QLog.e("[cmshow]ApolloDaoManager", 2, "[onCreate] error: not init in AppInterface!");
      return;
    }
    this.mApp = ((AppInterface)paramAppRuntime);
    this.em = this.mApp.getEntityManagerFactory().createEntityManager();
    if (!ApolloHardWareTester.a(this.mApp.getApp())) {
      ThreadManager.getSubThreadHandler().post(this.asyncInitDataRunnable);
    }
    ThreadManager.getFileThreadHandler().post(this.mReadApolloActionListRunnable);
  }
  
  public void onDestroy()
  {
    safeClearList(this.actionList);
    safeClearList(this.packageList);
    safeClearList(this.actionPackageList);
    safeClearList(this.favActionList);
    safeClearList(this.gameList);
    safeClearList(this.actionPushList);
    safeClearList(this.mActionObtainedList);
    safeClearList(this.mActionTagList);
    safeClearList(this.mRelationTagList);
    safeClearMap(this.mObtainedActiveActionMap);
    safeClearMap(this.mLimitFreeActionMap);
    safeClearMap(this.mKeywordsActionMap);
    safeClearMap(this.mPreDownloadMap);
    safeClearMap(this.mWhiteFaceIdMapping);
    safeClearMap(this.apolloPandoraCache);
    try
    {
      synchronized (this.mApolloBaseInfoCache)
      {
        this.mApolloBaseInfoCache.evictAll();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]ApolloDaoManager", 1, "[onDestroy] error, ", localException);
      ApolloGameUtil.a();
    }
  }
  
  public void readApolloGameVerFromFile()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloDaoManager", 2, "[readApolloGameVerFromFile]");
    }
    Object localObject1 = getGameList();
    if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder2 = new StringBuilder();
        localStringBuilder1.append("readGameVersion:");
        localStringBuilder2.append("\nerrInfo(config.json not exists):");
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ApolloGameData localApolloGameData = (ApolloGameData)((Iterator)localObject1).next();
          Object localObject2 = new StringBuilder(100);
          ((StringBuilder)localObject2).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
          ((StringBuilder)localObject2).append(localApolloGameData.gameId);
          ((StringBuilder)localObject2).append(File.separator);
          ((StringBuilder)localObject2).append("config.json");
          localObject2 = new File(((StringBuilder)localObject2).toString());
          if (!((File)localObject2).exists())
          {
            localStringBuilder2.append(localApolloGameData.gameId);
            localStringBuilder2.append(", ");
          }
          else
          {
            localObject2 = new JSONObject(FileUtils.readFileToString((File)localObject2)).optString("version");
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              this.mApolloGameVer.put(Integer.valueOf(localApolloGameData.gameId), localObject2);
            }
            localStringBuilder1.append("gId:");
            localStringBuilder1.append(localApolloGameData.gameId);
            localStringBuilder1.append(",ver:");
            localStringBuilder1.append((String)localObject2);
            localStringBuilder1.append("|");
          }
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(localStringBuilder1.toString());
        ((StringBuilder)localObject1).append(localStringBuilder2.toString());
        QLog.i("[cmshow]ApolloDaoManager", 1, ((StringBuilder)localObject1).toString());
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("catch errInfo:");
        localStringBuilder2.append(localException.getMessage());
        QLog.e("[cmshow]ApolloDaoManager", 1, localStringBuilder2.toString());
        return;
      }
    }
    QLog.i("[cmshow]ApolloDaoManager", 1, "errInfo->gameList is null.");
  }
  
  @Deprecated
  public void readApolloGameVerFromFile(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloDaoManager", 2, "[readApolloGameVerFromFile]");
    }
    Object localObject1 = getGameList();
    if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ApolloGameData localApolloGameData = (ApolloGameData)((Iterator)localObject1).next();
          if (paramInt == localApolloGameData.gameId)
          {
            Object localObject2 = new StringBuilder(100);
            ((StringBuilder)localObject2).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
            ((StringBuilder)localObject2).append(localApolloGameData.gameId);
            ((StringBuilder)localObject2).append(File.separator);
            ((StringBuilder)localObject2).append("config.json");
            localObject2 = new File(((StringBuilder)localObject2).toString());
            if (!((File)localObject2).exists())
            {
              localStringBuilder.append("errInfo->game version file not exists, gameId: ");
              localStringBuilder.append(localApolloGameData.gameId);
            }
            else
            {
              localObject2 = new JSONObject(FileUtils.readFileToString((File)localObject2)).optString("version");
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                this.mApolloGameVer.put(Integer.valueOf(localApolloGameData.gameId), localObject2);
              }
              localStringBuilder.append("gId:");
              localStringBuilder.append(localApolloGameData.gameId);
              localStringBuilder.append(",ver: ");
              localStringBuilder.append((String)localObject2);
              localStringBuilder.append("===");
            }
          }
        }
        QLog.i("[cmshow]ApolloDaoManager", 1, localStringBuilder.toString());
        return;
      }
      catch (Exception localException)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("catch errInfo:");
        ((StringBuilder)localObject1).append(localException.getMessage());
        QLog.e("[cmshow]ApolloDaoManager", 1, ((StringBuilder)localObject1).toString());
        return;
      }
    }
    QLog.i("[cmshow]ApolloDaoManager", 1, "errInfo->gameList is null.");
  }
  
  /* Error */
  public void realDelAioPushData(AioPushData paramAioPushData)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: getfield 133	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mAioPushDataList	Ljava/util/List;
    //   9: astore_3
    //   10: aload_3
    //   11: ifnull +71 -> 82
    //   14: aload_3
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 133	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mAioPushDataList	Ljava/util/List;
    //   20: aload_1
    //   21: invokeinterface 698 2 0
    //   26: istore_2
    //   27: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +42 -> 72
    //   33: new 444	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   40: astore 4
    //   42: aload 4
    //   44: ldc_w 1265
    //   47: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 4
    //   53: iload_2
    //   54: invokestatic 1268	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   57: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: ldc 12
    //   63: iconst_2
    //   64: aload 4
    //   66: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_3
    //   73: monitorexit
    //   74: goto +8 -> 82
    //   77: astore_1
    //   78: aload_3
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    //   82: aload_0
    //   83: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   86: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   89: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   92: astore 4
    //   94: aload 4
    //   96: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   99: astore_3
    //   100: aload_3
    //   101: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   104: aload 4
    //   106: aload_1
    //   107: invokevirtual 410	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   110: istore_2
    //   111: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +38 -> 152
    //   117: new 444	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   124: astore_1
    //   125: aload_1
    //   126: ldc_w 1270
    //   129: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_1
    //   134: iload_2
    //   135: invokestatic 1268	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   138: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: ldc 12
    //   144: iconst_2
    //   145: aload_1
    //   146: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload_3
    //   153: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   156: aload_3
    //   157: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   160: return
    //   161: astore_1
    //   162: goto +46 -> 208
    //   165: astore_1
    //   166: new 444	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   173: astore 4
    //   175: aload 4
    //   177: ldc_w 1272
    //   180: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 4
    //   186: aload_1
    //   187: invokevirtual 642	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   190: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: ldc 12
    //   196: iconst_1
    //   197: aload 4
    //   199: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 597	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: goto -49 -> 156
    //   208: aload_3
    //   209: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   212: goto +5 -> 217
    //   215: aload_1
    //   216: athrow
    //   217: goto -2 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	ApolloDaoManagerServiceImpl
    //   0	220	1	paramAioPushData	AioPushData
    //   26	109	2	bool	boolean
    //   9	200	3	localObject1	Object
    //   40	158	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   16	72	77	finally
    //   72	74	77	finally
    //   78	80	77	finally
    //   104	152	161	finally
    //   152	156	161	finally
    //   166	205	161	finally
    //   104	152	165	java/lang/Exception
    //   152	156	165	java/lang/Exception
  }
  
  public void rearrangeEnhanceAction(BaseChatPie paramBaseChatPie, List<ApolloActionData> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0) && (paramBaseChatPie != null))
    {
      if (paramBaseChatPie.i() == null) {
        return;
      }
      Object localObject = (ApolloManagerServiceImpl)paramBaseChatPie.i().getRuntimeService(IApolloManagerService.class, "all");
      boolean bool = ((ApolloManagerServiceImpl)localObject).getAVIPStatus(paramBaseChatPie.i().getCurrentAccountUin());
      int j = ((ApolloManagerServiceImpl)localObject).getAVIPLevel(paramBaseChatPie.i().getCurrentAccountUin());
      paramBaseChatPie = new ArrayList();
      localObject = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        ApolloActionData localApolloActionData = (ApolloActionData)paramList.get(i);
        if (isLimitFreeActionById(localApolloActionData.actionId)) {
          paramBaseChatPie.add(localApolloActionData);
        } else if (!TextUtils.isEmpty(localApolloActionData.iconUrl)) {
          localArrayList1.add(localApolloActionData);
        } else if (isObtainActionById(localApolloActionData.actionId)) {
          ((List)localObject).add(localApolloActionData);
        } else if (localApolloActionData.feeType == 1) {
          localArrayList2.add(localApolloActionData);
        } else if (localApolloActionData.feeType == 9)
        {
          if ((bool) && (localApolloActionData.vipLevel <= j))
          {
            localApolloActionData.obtainedTime = (localApolloActionData.version / 1000L);
            ((List)localObject).add(localApolloActionData);
          }
          else
          {
            localArrayList3.add(localApolloActionData);
          }
        }
        else {
          localArrayList3.add(localApolloActionData);
        }
        i += 1;
      }
      Collections.sort(paramBaseChatPie, new ApolloDaoManagerServiceImpl.6(this));
      Collections.sort(localArrayList1, new ApolloDaoManagerServiceImpl.7(this));
      Collections.sort((List)localObject, new ApolloDaoManagerServiceImpl.8(this));
      Collections.sort(localArrayList2, new ApolloDaoManagerServiceImpl.9(this));
      Collections.sort(localArrayList3, new ApolloDaoManagerServiceImpl.10(this));
      paramList.clear();
      paramList.addAll(paramBaseChatPie);
      paramList.addAll(localArrayList1);
      paramList.addAll((Collection)localObject);
      paramList.addAll(localArrayList2);
      paramList.addAll(localArrayList3);
    }
  }
  
  /* Error */
  public void removeActionPushDataById(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 125	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:actionPushList	Ljava/util/List;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 125	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:actionPushList	Ljava/util/List;
    //   11: invokeinterface 239 1 0
    //   16: astore 4
    //   18: aload 4
    //   20: invokeinterface 244 1 0
    //   25: ifeq +42 -> 67
    //   28: aload 4
    //   30: invokeinterface 248 1 0
    //   35: checkcast 840	com/tencent/mobileqq/apollo/model/ApolloActionPush
    //   38: astore 5
    //   40: aload 5
    //   42: ifnull -24 -> 18
    //   45: aload 5
    //   47: getfield 1321	com/tencent/mobileqq/apollo/model/ApolloActionPush:mId	J
    //   50: lload_1
    //   51: lcmp
    //   52: ifne -34 -> 18
    //   55: aload_0
    //   56: getfield 125	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:actionPushList	Ljava/util/List;
    //   59: aload 5
    //   61: invokeinterface 698 2 0
    //   66: pop
    //   67: aload_3
    //   68: monitorexit
    //   69: aload_0
    //   70: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   73: astore_3
    //   74: aload_3
    //   75: ifnonnull +4 -> 79
    //   78: return
    //   79: aload_3
    //   80: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   83: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   86: astore 4
    //   88: aload 4
    //   90: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   93: astore_3
    //   94: aload_3
    //   95: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   98: new 444	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   105: astore 5
    //   107: aload 5
    //   109: ldc_w 1323
    //   112: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 5
    //   118: lload_1
    //   119: invokevirtual 677	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 4
    //   125: aload 5
    //   127: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokevirtual 1326	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   133: pop
    //   134: aload_3
    //   135: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   138: aload_3
    //   139: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   142: return
    //   143: astore 4
    //   145: goto +48 -> 193
    //   148: astore 4
    //   150: new 444	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   157: astore 5
    //   159: aload 5
    //   161: ldc_w 1328
    //   164: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 5
    //   170: aload 4
    //   172: invokevirtual 642	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   175: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: ldc 12
    //   181: iconst_1
    //   182: aload 5
    //   184: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 597	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: goto -52 -> 138
    //   193: aload_3
    //   194: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   197: aload 4
    //   199: athrow
    //   200: astore 4
    //   202: aload_3
    //   203: monitorexit
    //   204: goto +6 -> 210
    //   207: aload 4
    //   209: athrow
    //   210: goto -3 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	ApolloDaoManagerServiceImpl
    //   0	213	1	paramLong	long
    //   4	199	3	localObject1	Object
    //   16	108	4	localObject2	Object
    //   143	1	4	localObject3	Object
    //   148	50	4	localException	Exception
    //   200	8	4	localObject4	Object
    //   38	145	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   94	138	143	finally
    //   150	190	143	finally
    //   94	138	148	java/lang/Exception
    //   7	18	200	finally
    //   18	40	200	finally
    //   45	67	200	finally
    //   67	69	200	finally
    //   202	204	200	finally
  }
  
  /* Error */
  public void removeAllAction()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: ldc 12
    //   10: iconst_1
    //   11: ldc_w 1330
    //   14: invokestatic 612	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 99	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:actionList	Ljava/util/List;
    //   21: astore_2
    //   22: aload_2
    //   23: monitorenter
    //   24: aload_0
    //   25: getfield 99	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:actionList	Ljava/util/List;
    //   28: invokeinterface 391 1 0
    //   33: aload_2
    //   34: monitorexit
    //   35: aload_0
    //   36: getfield 135	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mKeywordsActionMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   39: invokevirtual 577	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   42: aload_0
    //   43: iconst_1
    //   44: putfield 149	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mMaxKeywordsLength	I
    //   47: aload_0
    //   48: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   51: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   54: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   57: astore_3
    //   58: aload_3
    //   59: ldc_w 508
    //   62: invokevirtual 293	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   65: astore 4
    //   67: aload 4
    //   69: ifnonnull +4 -> 73
    //   72: return
    //   73: aload_3
    //   74: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   77: astore_2
    //   78: aload_2
    //   79: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   82: iconst_0
    //   83: istore_1
    //   84: iload_1
    //   85: aload 4
    //   87: invokeinterface 266 1 0
    //   92: if_icmpge +31 -> 123
    //   95: aload 4
    //   97: iload_1
    //   98: invokeinterface 632 2 0
    //   103: checkcast 508	com/tencent/mobileqq/apollo/model/ApolloActionData
    //   106: astore 5
    //   108: aload 5
    //   110: ifnull +51 -> 161
    //   113: aload_3
    //   114: aload 5
    //   116: invokevirtual 410	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   119: pop
    //   120: goto +41 -> 161
    //   123: aload_2
    //   124: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   127: goto +12 -> 139
    //   130: astore_3
    //   131: goto +13 -> 144
    //   134: astore_3
    //   135: aload_3
    //   136: invokevirtual 716	java/lang/Exception:printStackTrace	()V
    //   139: aload_2
    //   140: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   143: return
    //   144: aload_2
    //   145: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   148: aload_3
    //   149: athrow
    //   150: astore_3
    //   151: aload_2
    //   152: monitorexit
    //   153: goto +5 -> 158
    //   156: aload_3
    //   157: athrow
    //   158: goto -2 -> 156
    //   161: iload_1
    //   162: iconst_1
    //   163: iadd
    //   164: istore_1
    //   165: goto -81 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	ApolloDaoManagerServiceImpl
    //   83	82	1	i	int
    //   21	131	2	localObject1	Object
    //   57	57	3	localEntityManager	EntityManager
    //   130	1	3	localObject2	Object
    //   134	15	3	localException	Exception
    //   150	7	3	localObject3	Object
    //   65	31	4	localList	List
    //   106	9	5	localApolloActionData	ApolloActionData
    // Exception table:
    //   from	to	target	type
    //   78	82	130	finally
    //   84	108	130	finally
    //   113	120	130	finally
    //   123	127	130	finally
    //   135	139	130	finally
    //   78	82	134	java/lang/Exception
    //   84	108	134	java/lang/Exception
    //   113	120	134	java/lang/Exception
    //   123	127	134	java/lang/Exception
    //   24	35	150	finally
    //   151	153	150	finally
  }
  
  /* Error */
  public void removeAllActionTag()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 143	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mActionTagList	Ljava/util/List;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 143	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mActionTagList	Ljava/util/List;
    //   11: invokeinterface 391 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: aload_0
    //   19: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   22: astore_1
    //   23: aload_1
    //   24: ifnonnull +4 -> 28
    //   27: return
    //   28: aload_1
    //   29: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   32: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   35: astore_2
    //   36: aload_2
    //   37: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   40: astore_1
    //   41: aload_1
    //   42: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   45: aload_2
    //   46: ldc_w 1333
    //   49: invokevirtual 1326	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   52: pop
    //   53: aload_1
    //   54: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   57: aload_1
    //   58: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   61: return
    //   62: astore_2
    //   63: goto +17 -> 80
    //   66: astore_2
    //   67: ldc 12
    //   69: iconst_2
    //   70: ldc_w 1335
    //   73: aload_2
    //   74: invokestatic 1337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   77: goto -20 -> 57
    //   80: aload_1
    //   81: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   84: aload_2
    //   85: athrow
    //   86: astore_2
    //   87: aload_1
    //   88: monitorexit
    //   89: goto +5 -> 94
    //   92: aload_2
    //   93: athrow
    //   94: goto -2 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	ApolloDaoManagerServiceImpl
    //   4	84	1	localObject1	Object
    //   35	11	2	localEntityManager	EntityManager
    //   62	1	2	localObject2	Object
    //   66	19	2	localException	Exception
    //   86	7	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   41	57	62	finally
    //   67	77	62	finally
    //   41	57	66	java/lang/Exception
    //   7	18	86	finally
    //   87	89	86	finally
  }
  
  /* Error */
  public void removeAllObtainedAction()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 127	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mActionObtainedList	Ljava/util/List;
    //   12: astore_2
    //   13: aload_2
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 127	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mActionObtainedList	Ljava/util/List;
    //   19: invokeinterface 391 1 0
    //   24: aload_2
    //   25: monitorexit
    //   26: aload_0
    //   27: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   30: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   33: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   36: astore_3
    //   37: aload_3
    //   38: ldc_w 554
    //   41: invokevirtual 293	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   44: astore 4
    //   46: aload 4
    //   48: ifnonnull +4 -> 52
    //   51: return
    //   52: aload_3
    //   53: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   56: astore_2
    //   57: aload_2
    //   58: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   61: iconst_0
    //   62: istore_1
    //   63: iload_1
    //   64: aload 4
    //   66: invokeinterface 266 1 0
    //   71: if_icmpge +31 -> 102
    //   74: aload 4
    //   76: iload_1
    //   77: invokeinterface 632 2 0
    //   82: checkcast 554	com/tencent/mobileqq/apollo/model/ApolloObtainedActionData
    //   85: astore 5
    //   87: aload 5
    //   89: ifnull +57 -> 146
    //   92: aload_3
    //   93: aload 5
    //   95: invokevirtual 410	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   98: pop
    //   99: goto +47 -> 146
    //   102: aload_2
    //   103: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   106: goto +18 -> 124
    //   109: astore_3
    //   110: goto +19 -> 129
    //   113: astore_3
    //   114: ldc 12
    //   116: iconst_1
    //   117: ldc_w 1340
    //   120: aload_3
    //   121: invokestatic 432	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   124: aload_2
    //   125: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   128: return
    //   129: aload_2
    //   130: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   133: aload_3
    //   134: athrow
    //   135: astore_3
    //   136: aload_2
    //   137: monitorexit
    //   138: goto +5 -> 143
    //   141: aload_3
    //   142: athrow
    //   143: goto -2 -> 141
    //   146: iload_1
    //   147: iconst_1
    //   148: iadd
    //   149: istore_1
    //   150: goto -87 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	ApolloDaoManagerServiceImpl
    //   62	88	1	i	int
    //   12	125	2	localObject1	Object
    //   36	57	3	localEntityManager	EntityManager
    //   109	1	3	localObject2	Object
    //   113	21	3	localException	Exception
    //   135	7	3	localObject3	Object
    //   44	31	4	localList	List
    //   85	9	5	localApolloObtainedActionData	ApolloObtainedActionData
    // Exception table:
    //   from	to	target	type
    //   57	61	109	finally
    //   63	87	109	finally
    //   92	99	109	finally
    //   102	106	109	finally
    //   114	124	109	finally
    //   57	61	113	java/lang/Exception
    //   63	87	113	java/lang/Exception
    //   92	99	113	java/lang/Exception
    //   102	106	113	java/lang/Exception
    //   15	26	135	finally
    //   136	138	135	finally
  }
  
  /* Error */
  public void removeAllPackageData()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 103	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:actionPackageList	Ljava/util/List;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 103	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:actionPackageList	Ljava/util/List;
    //   11: invokeinterface 391 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: aload_0
    //   19: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   22: astore_1
    //   23: aload_1
    //   24: ifnonnull +4 -> 28
    //   27: return
    //   28: aload_1
    //   29: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   32: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   35: astore_2
    //   36: aload_2
    //   37: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   40: astore_1
    //   41: aload_1
    //   42: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   45: aload_2
    //   46: ldc_w 1343
    //   49: invokevirtual 1326	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   52: pop
    //   53: aload_1
    //   54: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   57: goto +12 -> 69
    //   60: astore_2
    //   61: goto +13 -> 74
    //   64: astore_2
    //   65: aload_2
    //   66: invokevirtual 716	java/lang/Exception:printStackTrace	()V
    //   69: aload_1
    //   70: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   73: return
    //   74: aload_1
    //   75: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   78: aload_2
    //   79: athrow
    //   80: astore_2
    //   81: aload_1
    //   82: monitorexit
    //   83: aload_2
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	ApolloDaoManagerServiceImpl
    //   4	78	1	localObject1	Object
    //   35	11	2	localEntityManager	EntityManager
    //   60	1	2	localObject2	Object
    //   64	15	2	localException	Exception
    //   80	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   41	57	60	finally
    //   65	69	60	finally
    //   41	57	64	java/lang/Exception
    //   7	18	80	finally
    //   81	83	80	finally
  }
  
  /* Error */
  public void removeAllRecommendActionList()
  {
    // Byte code:
    //   0: ldc 12
    //   2: iconst_1
    //   3: ldc_w 1345
    //   6: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_0
    //   10: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   13: ifnonnull +4 -> 17
    //   16: return
    //   17: aload_0
    //   18: getfield 141	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mRecommendActionList	Ljava/util/List;
    //   21: astore_1
    //   22: aload_1
    //   23: monitorenter
    //   24: aload_0
    //   25: getfield 141	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mRecommendActionList	Ljava/util/List;
    //   28: invokeinterface 391 1 0
    //   33: aload_1
    //   34: monitorexit
    //   35: aload_0
    //   36: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   39: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   42: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   45: astore_2
    //   46: aload_2
    //   47: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   55: aload_2
    //   56: ldc_w 1347
    //   59: invokevirtual 1326	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   62: pop
    //   63: aload_1
    //   64: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   67: aload_1
    //   68: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   71: return
    //   72: astore_2
    //   73: goto +17 -> 90
    //   76: astore_2
    //   77: ldc 12
    //   79: iconst_1
    //   80: ldc_w 1349
    //   83: aload_2
    //   84: invokestatic 432	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   87: goto -20 -> 67
    //   90: aload_1
    //   91: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   94: aload_2
    //   95: athrow
    //   96: astore_2
    //   97: aload_1
    //   98: monitorexit
    //   99: goto +5 -> 104
    //   102: aload_2
    //   103: athrow
    //   104: goto -2 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	ApolloDaoManagerServiceImpl
    //   21	77	1	localObject1	Object
    //   45	11	2	localEntityManager	EntityManager
    //   72	1	2	localObject2	Object
    //   76	19	2	localException	Exception
    //   96	7	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   55	67	72	finally
    //   77	87	72	finally
    //   55	67	76	java/lang/Exception
    //   24	35	96	finally
    //   97	99	96	finally
  }
  
  /* Error */
  public void removeAllRelationTag()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 145	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mRelationTagList	Ljava/util/List;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 145	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mRelationTagList	Ljava/util/List;
    //   11: invokeinterface 391 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: aload_0
    //   19: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   22: astore_1
    //   23: aload_1
    //   24: ifnonnull +4 -> 28
    //   27: return
    //   28: aload_1
    //   29: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   32: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   35: astore_2
    //   36: aload_2
    //   37: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   40: astore_1
    //   41: aload_1
    //   42: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   45: aload_2
    //   46: ldc_w 1352
    //   49: invokevirtual 1326	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   52: pop
    //   53: aload_1
    //   54: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   57: aload_1
    //   58: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   61: return
    //   62: astore_2
    //   63: goto +17 -> 80
    //   66: astore_2
    //   67: ldc 12
    //   69: iconst_2
    //   70: ldc_w 1354
    //   73: aload_2
    //   74: invokestatic 1337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   77: goto -20 -> 57
    //   80: aload_1
    //   81: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   84: aload_2
    //   85: athrow
    //   86: astore_2
    //   87: aload_1
    //   88: monitorexit
    //   89: goto +5 -> 94
    //   92: aload_2
    //   93: athrow
    //   94: goto -2 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	ApolloDaoManagerServiceImpl
    //   4	84	1	localObject1	Object
    //   35	11	2	localEntityManager	EntityManager
    //   62	1	2	localObject2	Object
    //   66	19	2	localException	Exception
    //   86	7	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   41	57	62	finally
    //   67	77	62	finally
    //   41	57	66	java/lang/Exception
    //   7	18	86	finally
    //   87	89	86	finally
  }
  
  public void removeAllS2CPushItem()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloDaoManager", 2, "[removeAllS2CPushItem]");
    }
    ThreadManager.post(new ApolloDaoManagerServiceImpl.14(this), 5, null, true);
  }
  
  /* Error */
  public void removePackageInfo(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 101	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:packageList	Ljava/util/List;
    //   12: astore_2
    //   13: aload_2
    //   14: monitorenter
    //   15: iconst_1
    //   16: iload_1
    //   17: if_icmpne +12 -> 29
    //   20: aload_0
    //   21: getfield 101	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:packageList	Ljava/util/List;
    //   24: invokeinterface 391 1 0
    //   29: aload_2
    //   30: monitorexit
    //   31: aload_0
    //   32: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   35: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   38: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   41: astore_3
    //   42: aload_3
    //   43: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   46: astore_2
    //   47: aload_2
    //   48: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   51: iconst_1
    //   52: iload_1
    //   53: if_icmpne +11 -> 64
    //   56: aload_3
    //   57: ldc_w 1363
    //   60: invokevirtual 1326	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   63: pop
    //   64: aload_2
    //   65: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   68: aload_2
    //   69: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   72: return
    //   73: astore_3
    //   74: goto +17 -> 91
    //   77: astore_3
    //   78: ldc 12
    //   80: iconst_1
    //   81: ldc_w 1365
    //   84: aload_3
    //   85: invokestatic 432	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   88: goto -20 -> 68
    //   91: aload_2
    //   92: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   95: aload_3
    //   96: athrow
    //   97: astore_3
    //   98: aload_2
    //   99: monitorexit
    //   100: goto +5 -> 105
    //   103: aload_3
    //   104: athrow
    //   105: goto -2 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	ApolloDaoManagerServiceImpl
    //   0	108	1	paramInt	int
    //   12	87	2	localObject1	Object
    //   41	16	3	localEntityManager	EntityManager
    //   73	1	3	localObject2	Object
    //   77	19	3	localException	Exception
    //   97	7	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   47	51	73	finally
    //   56	64	73	finally
    //   64	68	73	finally
    //   78	88	73	finally
    //   47	51	77	java/lang/Exception
    //   56	64	77	java/lang/Exception
    //   64	68	77	java/lang/Exception
    //   20	29	97	finally
    //   29	31	97	finally
    //   98	100	97	finally
  }
  
  public void removePushItem(DrawerPushItem paramDrawerPushItem)
  {
    ThreadManager.post(new ApolloDaoManagerServiceImpl.13(this, paramDrawerPushItem), 5, null, true);
  }
  
  /* Error */
  public void saveAction(List<ApolloActionData> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +252 -> 253
    //   4: aload_1
    //   5: invokeinterface 266 1 0
    //   10: ifeq +243 -> 253
    //   13: aload_0
    //   14: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   17: astore_2
    //   18: aload_2
    //   19: ifnonnull +4 -> 23
    //   22: return
    //   23: aload_2
    //   24: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   27: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   30: astore_3
    //   31: aload_3
    //   32: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   35: astore_2
    //   36: aload_2
    //   37: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   40: new 444	java/lang/StringBuilder
    //   43: dup
    //   44: sipush 500
    //   47: invokespecial 550	java/lang/StringBuilder:<init>	(I)V
    //   50: astore 4
    //   52: aload_1
    //   53: invokeinterface 239 1 0
    //   58: astore 5
    //   60: aload 5
    //   62: invokeinterface 244 1 0
    //   67: ifeq +92 -> 159
    //   70: aload 5
    //   72: invokeinterface 248 1 0
    //   77: checkcast 508	com/tencent/mobileqq/apollo/model/ApolloActionData
    //   80: astore 6
    //   82: aload_0
    //   83: aload 6
    //   85: invokespecial 202	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:saveActionKeywordsMap	(Lcom/tencent/mobileqq/apollo/model/ApolloActionData;)V
    //   88: aload_0
    //   89: aload_3
    //   90: aload 6
    //   92: invokevirtual 558	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   95: pop
    //   96: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq -39 -> 60
    //   102: aload 4
    //   104: ldc_w 560
    //   107: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 4
    //   113: aload 6
    //   115: getfield 528	com/tencent/mobileqq/apollo/model/ApolloActionData:actionId	I
    //   118: invokevirtual 455	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 4
    //   124: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   127: sipush 500
    //   130: if_icmplt -70 -> 60
    //   133: ldc 12
    //   135: iconst_2
    //   136: aload 4
    //   138: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload 4
    //   146: iconst_0
    //   147: aload 4
    //   149: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   152: invokevirtual 568	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: goto -96 -> 60
    //   159: aload 4
    //   161: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   164: sipush 500
    //   167: if_icmpge +28 -> 195
    //   170: aload 4
    //   172: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   175: ifle +20 -> 195
    //   178: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   181: ifeq +14 -> 195
    //   184: ldc 12
    //   186: iconst_2
    //   187: aload 4
    //   189: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: aload_2
    //   196: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   199: goto +18 -> 217
    //   202: astore_1
    //   203: goto +44 -> 247
    //   206: astore_3
    //   207: ldc 12
    //   209: iconst_1
    //   210: ldc_w 1365
    //   213: aload_3
    //   214: invokestatic 1337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   217: aload_2
    //   218: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   221: aload_0
    //   222: getfield 99	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:actionList	Ljava/util/List;
    //   225: astore_2
    //   226: aload_2
    //   227: monitorenter
    //   228: aload_0
    //   229: getfield 99	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:actionList	Ljava/util/List;
    //   232: aload_1
    //   233: invokeinterface 273 2 0
    //   238: pop
    //   239: aload_2
    //   240: monitorexit
    //   241: return
    //   242: astore_1
    //   243: aload_2
    //   244: monitorexit
    //   245: aload_1
    //   246: athrow
    //   247: aload_2
    //   248: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   251: aload_1
    //   252: athrow
    //   253: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	ApolloDaoManagerServiceImpl
    //   0	254	1	paramList	List<ApolloActionData>
    //   17	231	2	localObject	Object
    //   30	60	3	localEntityManager	EntityManager
    //   206	8	3	localException	Exception
    //   50	138	4	localStringBuilder	StringBuilder
    //   58	13	5	localIterator	Iterator
    //   80	34	6	localApolloActionData	ApolloActionData
    // Exception table:
    //   from	to	target	type
    //   40	60	202	finally
    //   60	156	202	finally
    //   159	195	202	finally
    //   195	199	202	finally
    //   207	217	202	finally
    //   40	60	206	java/lang/Exception
    //   60	156	206	java/lang/Exception
    //   159	195	206	java/lang/Exception
    //   195	199	206	java/lang/Exception
    //   228	241	242	finally
    //   243	245	242	finally
  }
  
  /* Error */
  public void saveActionPackageInfo(List<ApolloActionPackageData> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +242 -> 243
    //   4: aload_1
    //   5: invokeinterface 266 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 103	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:actionPackageList	Ljava/util/List;
    //   18: astore_2
    //   19: aload_2
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 103	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:actionPackageList	Ljava/util/List;
    //   25: aload_1
    //   26: invokeinterface 273 2 0
    //   31: pop
    //   32: aload_2
    //   33: monitorexit
    //   34: aload_0
    //   35: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnonnull +4 -> 44
    //   43: return
    //   44: aload_2
    //   45: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   48: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   51: astore_3
    //   52: aload_3
    //   53: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   56: astore_2
    //   57: aload_2
    //   58: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   61: new 444	java/lang/StringBuilder
    //   64: dup
    //   65: sipush 500
    //   68: invokespecial 550	java/lang/StringBuilder:<init>	(I)V
    //   71: astore 4
    //   73: aload_1
    //   74: invokeinterface 239 1 0
    //   79: astore_1
    //   80: aload_1
    //   81: invokeinterface 244 1 0
    //   86: ifeq +91 -> 177
    //   89: aload_1
    //   90: invokeinterface 248 1 0
    //   95: checkcast 758	com/tencent/mobileqq/apollo/model/ApolloActionPackageData
    //   98: astore 5
    //   100: aload_0
    //   101: aload_3
    //   102: aload 5
    //   104: invokevirtual 558	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   107: pop
    //   108: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +23 -> 134
    //   114: aload 4
    //   116: ldc_w 1375
    //   119: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 4
    //   125: aload 5
    //   127: getfield 766	com/tencent/mobileqq/apollo/model/ApolloActionPackageData:acitonId	I
    //   130: invokevirtual 455	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 4
    //   136: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   139: sipush 500
    //   142: if_icmplt -62 -> 80
    //   145: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq -68 -> 80
    //   151: ldc 12
    //   153: iconst_2
    //   154: aload 4
    //   156: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload 4
    //   164: iconst_0
    //   165: aload 4
    //   167: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   170: invokevirtual 568	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: goto -94 -> 80
    //   177: aload 4
    //   179: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   182: sipush 500
    //   185: if_icmpge +20 -> 205
    //   188: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq +14 -> 205
    //   194: ldc 12
    //   196: iconst_2
    //   197: aload 4
    //   199: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload_2
    //   206: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   209: goto +18 -> 227
    //   212: astore_1
    //   213: goto +19 -> 232
    //   216: astore_1
    //   217: ldc 12
    //   219: iconst_1
    //   220: ldc_w 1365
    //   223: aload_1
    //   224: invokestatic 432	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   227: aload_2
    //   228: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   231: return
    //   232: aload_2
    //   233: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   236: aload_1
    //   237: athrow
    //   238: astore_1
    //   239: aload_2
    //   240: monitorexit
    //   241: aload_1
    //   242: athrow
    //   243: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	ApolloDaoManagerServiceImpl
    //   0	244	1	paramList	List<ApolloActionPackageData>
    //   18	222	2	localObject	Object
    //   51	51	3	localEntityManager	EntityManager
    //   71	127	4	localStringBuilder	StringBuilder
    //   98	28	5	localApolloActionPackageData	ApolloActionPackageData
    // Exception table:
    //   from	to	target	type
    //   61	80	212	finally
    //   80	134	212	finally
    //   134	174	212	finally
    //   177	205	212	finally
    //   205	209	212	finally
    //   217	227	212	finally
    //   61	80	216	java/lang/Exception
    //   80	134	216	java/lang/Exception
    //   134	174	216	java/lang/Exception
    //   177	205	216	java/lang/Exception
    //   205	209	216	java/lang/Exception
    //   21	34	238	finally
    //   239	241	238	finally
  }
  
  /* Error */
  public void saveActionPushData(ApolloActionPush paramApolloActionPush)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +262 -> 263
    //   4: aload_0
    //   5: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   8: ifnonnull +4 -> 12
    //   11: return
    //   12: aload_0
    //   13: getfield 125	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:actionPushList	Ljava/util/List;
    //   16: astore_3
    //   17: aload_3
    //   18: monitorenter
    //   19: aload_0
    //   20: getfield 125	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:actionPushList	Ljava/util/List;
    //   23: invokeinterface 266 1 0
    //   28: iconst_1
    //   29: isub
    //   30: istore_2
    //   31: iload_2
    //   32: iflt +63 -> 95
    //   35: aload_0
    //   36: getfield 125	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:actionPushList	Ljava/util/List;
    //   39: iload_2
    //   40: invokeinterface 632 2 0
    //   45: checkcast 840	com/tencent/mobileqq/apollo/model/ApolloActionPush
    //   48: astore 4
    //   50: aload 4
    //   52: ifnull +212 -> 264
    //   55: aload 4
    //   57: getfield 848	com/tencent/mobileqq/apollo/model/ApolloActionPush:mAioType	I
    //   60: aload_1
    //   61: getfield 848	com/tencent/mobileqq/apollo/model/ApolloActionPush:mAioType	I
    //   64: if_icmpne +200 -> 264
    //   67: aload 4
    //   69: getfield 857	com/tencent/mobileqq/apollo/model/ApolloActionPush:mSessionId	J
    //   72: aload_1
    //   73: getfield 857	com/tencent/mobileqq/apollo/model/ApolloActionPush:mSessionId	J
    //   76: lcmp
    //   77: ifne +187 -> 264
    //   80: aload_0
    //   81: getfield 125	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:actionPushList	Ljava/util/List;
    //   84: aload 4
    //   86: invokeinterface 698 2 0
    //   91: pop
    //   92: goto +172 -> 264
    //   95: aload_0
    //   96: getfield 125	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:actionPushList	Ljava/util/List;
    //   99: aload_1
    //   100: invokeinterface 406 2 0
    //   105: pop
    //   106: aload_3
    //   107: monitorexit
    //   108: aload_0
    //   109: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   112: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   115: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   118: astore 4
    //   120: aload 4
    //   122: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   125: astore_3
    //   126: aload_3
    //   127: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   130: new 444	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   137: astore 5
    //   139: aload 5
    //   141: ldc_w 1380
    //   144: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 5
    //   150: aload_1
    //   151: getfield 848	com/tencent/mobileqq/apollo/model/ApolloActionPush:mAioType	I
    //   154: invokevirtual 455	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload 5
    //   160: ldc_w 1382
    //   163: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 5
    //   169: aload_1
    //   170: getfield 857	com/tencent/mobileqq/apollo/model/ApolloActionPush:mSessionId	J
    //   173: invokevirtual 677	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 4
    //   179: aload 5
    //   181: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokevirtual 1326	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   187: pop
    //   188: aload_0
    //   189: aload 4
    //   191: aload_1
    //   192: invokevirtual 558	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   195: pop
    //   196: aload_3
    //   197: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   200: goto +47 -> 247
    //   203: astore_1
    //   204: goto +48 -> 252
    //   207: astore_1
    //   208: new 444	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   215: astore 4
    //   217: aload 4
    //   219: ldc_w 1384
    //   222: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 4
    //   228: aload_1
    //   229: invokevirtual 642	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   232: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: ldc 12
    //   238: iconst_1
    //   239: aload 4
    //   241: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 597	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: aload_3
    //   248: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   251: return
    //   252: aload_3
    //   253: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   256: aload_1
    //   257: athrow
    //   258: astore_1
    //   259: aload_3
    //   260: monitorexit
    //   261: aload_1
    //   262: athrow
    //   263: return
    //   264: iload_2
    //   265: iconst_1
    //   266: isub
    //   267: istore_2
    //   268: goto -237 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	ApolloDaoManagerServiceImpl
    //   0	271	1	paramApolloActionPush	ApolloActionPush
    //   30	238	2	i	int
    //   16	244	3	localObject1	Object
    //   48	192	4	localObject2	Object
    //   137	43	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   130	200	203	finally
    //   208	247	203	finally
    //   130	200	207	java/lang/Exception
    //   19	31	258	finally
    //   35	50	258	finally
    //   55	92	258	finally
    //   95	108	258	finally
    //   259	261	258	finally
  }
  
  /* Error */
  public void saveActionTag(List<ApolloActionTag> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +242 -> 243
    //   4: aload_1
    //   5: invokeinterface 266 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 143	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mActionTagList	Ljava/util/List;
    //   18: astore_2
    //   19: aload_2
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 143	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mActionTagList	Ljava/util/List;
    //   25: aload_1
    //   26: invokeinterface 273 2 0
    //   31: pop
    //   32: aload_2
    //   33: monitorexit
    //   34: aload_0
    //   35: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnonnull +4 -> 44
    //   43: return
    //   44: aload_2
    //   45: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   48: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   51: astore_3
    //   52: aload_3
    //   53: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   56: astore_2
    //   57: aload_2
    //   58: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   61: new 444	java/lang/StringBuilder
    //   64: dup
    //   65: sipush 500
    //   68: invokespecial 550	java/lang/StringBuilder:<init>	(I)V
    //   71: astore 4
    //   73: aload_1
    //   74: invokeinterface 239 1 0
    //   79: astore_1
    //   80: aload_1
    //   81: invokeinterface 244 1 0
    //   86: ifeq +91 -> 177
    //   89: aload_1
    //   90: invokeinterface 248 1 0
    //   95: checkcast 800	com/tencent/mobileqq/apollo/model/ApolloActionTag
    //   98: astore 5
    //   100: aload_0
    //   101: aload_3
    //   102: aload 5
    //   104: invokevirtual 558	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   107: pop
    //   108: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +23 -> 134
    //   114: aload 4
    //   116: ldc_w 1387
    //   119: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 4
    //   125: aload 5
    //   127: getfield 813	com/tencent/mobileqq/apollo/model/ApolloActionTag:actionId	I
    //   130: invokevirtual 455	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 4
    //   136: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   139: sipush 500
    //   142: if_icmplt -62 -> 80
    //   145: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq -68 -> 80
    //   151: ldc 12
    //   153: iconst_2
    //   154: aload 4
    //   156: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload 4
    //   164: iconst_0
    //   165: aload 4
    //   167: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   170: invokevirtual 568	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: goto -94 -> 80
    //   177: aload 4
    //   179: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   182: sipush 500
    //   185: if_icmpge +20 -> 205
    //   188: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq +14 -> 205
    //   194: ldc 12
    //   196: iconst_2
    //   197: aload 4
    //   199: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload_2
    //   206: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   209: goto +18 -> 227
    //   212: astore_1
    //   213: goto +19 -> 232
    //   216: astore_1
    //   217: ldc 12
    //   219: iconst_1
    //   220: ldc_w 1389
    //   223: aload_1
    //   224: invokestatic 432	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   227: aload_2
    //   228: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   231: return
    //   232: aload_2
    //   233: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   236: aload_1
    //   237: athrow
    //   238: astore_1
    //   239: aload_2
    //   240: monitorexit
    //   241: aload_1
    //   242: athrow
    //   243: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	ApolloDaoManagerServiceImpl
    //   0	244	1	paramList	List<ApolloActionTag>
    //   18	222	2	localObject	Object
    //   51	51	3	localEntityManager	EntityManager
    //   71	127	4	localStringBuilder	StringBuilder
    //   98	28	5	localApolloActionTag	ApolloActionTag
    // Exception table:
    //   from	to	target	type
    //   61	80	212	finally
    //   80	134	212	finally
    //   134	174	212	finally
    //   177	205	212	finally
    //   205	209	212	finally
    //   217	227	212	finally
    //   61	80	216	java/lang/Exception
    //   80	134	216	java/lang/Exception
    //   134	174	216	java/lang/Exception
    //   177	205	216	java/lang/Exception
    //   205	209	216	java/lang/Exception
    //   21	34	238	finally
    //   239	241	238	finally
  }
  
  /* Error */
  public void saveAioPushData(List<AioPushData> paramList, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +468 -> 469
    //   4: aload_1
    //   5: invokeinterface 266 1 0
    //   10: ifeq +459 -> 469
    //   13: aload_0
    //   14: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: new 90	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 91	java/util/ArrayList:<init>	()V
    //   28: astore 5
    //   30: aload_0
    //   31: getfield 133	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mAioPushDataList	Ljava/util/List;
    //   34: astore 6
    //   36: aload 6
    //   38: ifnull +281 -> 319
    //   41: aload 6
    //   43: monitorenter
    //   44: aload_1
    //   45: invokestatic 1394	java/util/Collections:sort	(Ljava/util/List;)V
    //   48: invokestatic 396	java/lang/System:currentTimeMillis	()J
    //   51: ldc2_w 397
    //   54: ldiv
    //   55: l2i
    //   56: istore_3
    //   57: aload_1
    //   58: invokeinterface 239 1 0
    //   63: astore 7
    //   65: aload 7
    //   67: invokeinterface 244 1 0
    //   72: ifeq +235 -> 307
    //   75: aload 7
    //   77: invokeinterface 248 1 0
    //   82: checkcast 486	com/tencent/mobileqq/apollo/model/AioPushData
    //   85: astore 8
    //   87: aload 8
    //   89: ifnull -24 -> 65
    //   92: aload 8
    //   94: getfield 492	com/tencent/mobileqq/apollo/model/AioPushData:begTs	I
    //   97: aload 8
    //   99: getfield 489	com/tencent/mobileqq/apollo/model/AioPushData:endTs	I
    //   102: if_icmpgt -37 -> 65
    //   105: aload 8
    //   107: getfield 489	com/tencent/mobileqq/apollo/model/AioPushData:endTs	I
    //   110: iload_3
    //   111: if_icmple -46 -> 65
    //   114: aload 8
    //   116: getfield 1396	com/tencent/mobileqq/apollo/model/AioPushData:isShow	Z
    //   119: ifne -54 -> 65
    //   122: aload_0
    //   123: getfield 133	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mAioPushDataList	Ljava/util/List;
    //   126: aload 8
    //   128: invokeinterface 1152 2 0
    //   133: istore 4
    //   135: iload 4
    //   137: iflt +60 -> 197
    //   140: aload_0
    //   141: getfield 133	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mAioPushDataList	Ljava/util/List;
    //   144: iload 4
    //   146: invokeinterface 632 2 0
    //   151: checkcast 486	com/tencent/mobileqq/apollo/model/AioPushData
    //   154: astore 9
    //   156: aload 9
    //   158: ifnull +26 -> 184
    //   161: aload 9
    //   163: getfield 1396	com/tencent/mobileqq/apollo/model/AioPushData:isShow	Z
    //   166: ifeq +18 -> 184
    //   169: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq +12 -> 184
    //   175: ldc 12
    //   177: iconst_2
    //   178: ldc_w 1398
    //   181: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload 5
    //   186: aload 8
    //   188: invokeinterface 406 2 0
    //   193: pop
    //   194: goto -129 -> 65
    //   197: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +40 -> 240
    //   203: new 444	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   210: astore 9
    //   212: aload 9
    //   214: ldc_w 1400
    //   217: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 9
    //   223: aload 8
    //   225: invokevirtual 607	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: ldc 12
    //   231: iconst_2
    //   232: aload 9
    //   234: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: iload_2
    //   241: iconst_1
    //   242: if_icmpne +50 -> 292
    //   245: aload_0
    //   246: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   249: getstatic 1405	com/tencent/mobileqq/app/QQManagerFactory:HOTCHAT_CENTER_MANAGER	I
    //   252: invokevirtual 1409	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   255: checkcast 1411	com/tencent/mobileqq/app/HotChatCenterManager
    //   258: astore 9
    //   260: aload 9
    //   262: ifnull +21 -> 283
    //   265: aload 9
    //   267: aload 8
    //   269: getfield 1414	com/tencent/mobileqq/apollo/model/AioPushData:them	Ljava/lang/String;
    //   272: aload 8
    //   274: getfield 1417	com/tencent/mobileqq/apollo/model/AioPushData:wording	Ljava/lang/String;
    //   277: invokevirtual 1420	com/tencent/mobileqq/app/HotChatCenterManager:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: goto +12 -> 292
    //   283: ldc 12
    //   285: iconst_1
    //   286: ldc_w 1422
    //   289: invokestatic 597	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: aload_0
    //   293: getfield 133	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mAioPushDataList	Ljava/util/List;
    //   296: aload 8
    //   298: invokeinterface 406 2 0
    //   303: pop
    //   304: goto -239 -> 65
    //   307: aload 6
    //   309: monitorexit
    //   310: goto +9 -> 319
    //   313: astore_1
    //   314: aload 6
    //   316: monitorexit
    //   317: aload_1
    //   318: athrow
    //   319: aload_0
    //   320: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   323: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   326: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   329: astore 7
    //   331: aload 7
    //   333: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   336: astore 6
    //   338: aload 6
    //   340: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   343: aload 5
    //   345: invokeinterface 266 1 0
    //   350: ifle +12 -> 362
    //   353: aload_1
    //   354: aload 5
    //   356: invokeinterface 499 2 0
    //   361: pop
    //   362: aload_1
    //   363: invokeinterface 239 1 0
    //   368: astore_1
    //   369: aload_1
    //   370: invokeinterface 244 1 0
    //   375: ifeq +22 -> 397
    //   378: aload_0
    //   379: aload 7
    //   381: aload_1
    //   382: invokeinterface 248 1 0
    //   387: checkcast 486	com/tencent/mobileqq/apollo/model/AioPushData
    //   390: invokevirtual 558	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   393: pop
    //   394: goto -25 -> 369
    //   397: aload 6
    //   399: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   402: aload 6
    //   404: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   407: goto +50 -> 457
    //   410: astore_1
    //   411: goto +51 -> 462
    //   414: astore_1
    //   415: new 444	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   422: astore 5
    //   424: aload 5
    //   426: ldc_w 1424
    //   429: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload 5
    //   435: aload_1
    //   436: invokevirtual 642	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   439: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: ldc 12
    //   445: iconst_1
    //   446: aload 5
    //   448: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 597	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   454: goto -52 -> 402
    //   457: aload_0
    //   458: invokespecial 1426	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:removeInvalidAioPushData	()V
    //   461: return
    //   462: aload 6
    //   464: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   467: aload_1
    //   468: athrow
    //   469: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	this	ApolloDaoManagerServiceImpl
    //   0	470	1	paramList	List<AioPushData>
    //   0	470	2	paramInt	int
    //   56	56	3	i	int
    //   133	12	4	j	int
    //   28	419	5	localObject1	Object
    //   34	429	6	localObject2	Object
    //   63	317	7	localObject3	Object
    //   85	212	8	localAioPushData	AioPushData
    //   154	112	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   44	65	313	finally
    //   65	87	313	finally
    //   92	135	313	finally
    //   140	156	313	finally
    //   161	184	313	finally
    //   184	194	313	finally
    //   197	240	313	finally
    //   245	260	313	finally
    //   265	280	313	finally
    //   283	292	313	finally
    //   292	304	313	finally
    //   307	310	313	finally
    //   314	317	313	finally
    //   343	362	410	finally
    //   362	369	410	finally
    //   369	394	410	finally
    //   397	402	410	finally
    //   415	454	410	finally
    //   343	362	414	java/lang/Exception
    //   362	369	414	java/lang/Exception
    //   369	394	414	java/lang/Exception
    //   397	402	414	java/lang/Exception
  }
  
  /* Error */
  public void saveBubblePushData(int paramInt, List<tencent.im.s2c.msgtype0x210.submsgtype0xdc.submsgtype0xdc.MsgContent> paramList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +462 -> 463
    //   4: aload_2
    //   5: invokeinterface 266 1 0
    //   10: ifne +6 -> 16
    //   13: goto +450 -> 463
    //   16: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +26 -> 45
    //   22: ldc 12
    //   24: iconst_2
    //   25: iconst_2
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: ldc_w 1431
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: iload_1
    //   38: invokestatic 534	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   41: aastore
    //   42: invokestatic 730	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   45: aload_0
    //   46: getfield 227	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   49: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   52: astore_3
    //   53: aload_3
    //   54: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   57: aload_0
    //   58: getfield 153	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mPushLock	Ljava/lang/Object;
    //   61: astore 4
    //   63: aload 4
    //   65: monitorenter
    //   66: aload_2
    //   67: invokeinterface 239 1 0
    //   72: astore_2
    //   73: aload_2
    //   74: invokeinterface 244 1 0
    //   79: ifeq +313 -> 392
    //   82: aload_2
    //   83: invokeinterface 248 1 0
    //   88: checkcast 1433	tencent/im/s2c/msgtype0x210/submsgtype0xdc/submsgtype0xdc$MsgContent
    //   91: astore 5
    //   93: new 250	com/tencent/mobileqq/DrawerPushItem
    //   96: dup
    //   97: invokespecial 1434	com/tencent/mobileqq/DrawerPushItem:<init>	()V
    //   100: astore 6
    //   102: aload 6
    //   104: iload_1
    //   105: putfield 966	com/tencent/mobileqq/DrawerPushItem:msg_type	I
    //   108: aload 6
    //   110: aload 5
    //   112: getfield 1438	tencent/im/s2c/msgtype0x210/submsgtype0xdc/submsgtype0xdc$MsgContent:uint64_msg_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   115: invokevirtual 1442	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   118: invokestatic 1445	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   121: putfield 253	com/tencent/mobileqq/DrawerPushItem:msg_id	Ljava/lang/String;
    //   124: aload 6
    //   126: aload 5
    //   128: getfield 1448	tencent/im/s2c/msgtype0x210/submsgtype0xdc/submsgtype0xdc$MsgContent:uint64_master_pri	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   131: invokevirtual 1442	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   134: l2i
    //   135: putfield 1451	com/tencent/mobileqq/DrawerPushItem:priority	I
    //   138: aload 6
    //   140: aload 5
    //   142: getfield 1454	tencent/im/s2c/msgtype0x210/submsgtype0xdc/submsgtype0xdc$MsgContent:uint64_sub_pri	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   145: invokevirtual 1442	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   148: l2i
    //   149: putfield 1457	com/tencent/mobileqq/DrawerPushItem:sub_priority	I
    //   152: aload 6
    //   154: aload 5
    //   156: getfield 1460	tencent/im/s2c/msgtype0x210/submsgtype0xdc/submsgtype0xdc$MsgContent:uint64_show_beg_ts	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   159: invokevirtual 1442	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   162: l2i
    //   163: putfield 961	com/tencent/mobileqq/DrawerPushItem:start_ts	I
    //   166: aload 6
    //   168: aload 5
    //   170: getfield 1463	tencent/im/s2c/msgtype0x210/submsgtype0xdc/submsgtype0xdc$MsgContent:uint64_exp_ts	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   173: invokevirtual 1442	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   176: l2i
    //   177: putfield 401	com/tencent/mobileqq/DrawerPushItem:end_ts	I
    //   180: aload 6
    //   182: aload 5
    //   184: getfield 1466	tencent/im/s2c/msgtype0x210/submsgtype0xdc/submsgtype0xdc$MsgContent:uint64_msg_sent_ts	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   187: invokevirtual 1442	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   190: l2i
    //   191: putfield 1469	com/tencent/mobileqq/DrawerPushItem:send_time	I
    //   194: aload 6
    //   196: aload 5
    //   198: getfield 1472	tencent/im/s2c/msgtype0x210/submsgtype0xdc/submsgtype0xdc$MsgContent:uint64_action_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   201: invokevirtual 1442	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   204: l2i
    //   205: putfield 1475	com/tencent/mobileqq/DrawerPushItem:action_id	I
    //   208: aload 6
    //   210: aload 5
    //   212: getfield 1478	tencent/im/s2c/msgtype0x210/submsgtype0xdc/submsgtype0xdc$MsgContent:uint64_wording_color	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   215: invokevirtual 1442	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   218: l2i
    //   219: putfield 1481	com/tencent/mobileqq/DrawerPushItem:color	I
    //   222: aload 6
    //   224: aload 5
    //   226: getfield 1485	tencent/im/s2c/msgtype0x210/submsgtype0xdc/submsgtype0xdc$MsgContent:str_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   229: invokevirtual 1489	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   232: putfield 1492	com/tencent/mobileqq/DrawerPushItem:content	Ljava/lang/String;
    //   235: aload 6
    //   237: aload 5
    //   239: getfield 1495	tencent/im/s2c/msgtype0x210/submsgtype0xdc/submsgtype0xdc$MsgContent:str_scheme	Lcom/tencent/mobileqq/pb/PBStringField;
    //   242: invokevirtual 1489	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   245: putfield 1498	com/tencent/mobileqq/DrawerPushItem:scheme	Ljava/lang/String;
    //   248: aload 6
    //   250: aload 5
    //   252: getfield 1501	tencent/im/s2c/msgtype0x210/submsgtype0xdc/submsgtype0xdc$MsgContent:str_region_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   255: invokevirtual 1489	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   258: putfield 1504	com/tencent/mobileqq/DrawerPushItem:ext_url	Ljava/lang/String;
    //   261: aload 6
    //   263: aload 5
    //   265: getfield 1507	tencent/im/s2c/msgtype0x210/submsgtype0xdc/submsgtype0xdc$MsgContent:uint64_bubble_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   268: invokevirtual 1442	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   271: l2i
    //   272: putfield 1510	com/tencent/mobileqq/DrawerPushItem:bubble_res_id	I
    //   275: aload 6
    //   277: iconst_0
    //   278: putfield 1513	com/tencent/mobileqq/DrawerPushItem:is_reddot	I
    //   281: aload 6
    //   283: aload 5
    //   285: getfield 1516	tencent/im/s2c/msgtype0x210/submsgtype0xdc/submsgtype0xdc$MsgContent:str_tips	Lcom/tencent/mobileqq/pb/PBStringField;
    //   288: invokevirtual 1489	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   291: putfield 1519	com/tencent/mobileqq/DrawerPushItem:tips_str	Ljava/lang/String;
    //   294: aload 6
    //   296: aload 5
    //   298: getfield 1522	tencent/im/s2c/msgtype0x210/submsgtype0xdc/submsgtype0xdc$MsgContent:uint64_show_times	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   301: invokevirtual 1442	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   304: l2i
    //   305: putfield 693	com/tencent/mobileqq/DrawerPushItem:show_counts	I
    //   308: aload 6
    //   310: aload 5
    //   312: getfield 1525	tencent/im/s2c/msgtype0x210/submsgtype0xdc/submsgtype0xdc$MsgContent:uint64_game_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   315: invokevirtual 1442	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   318: l2i
    //   319: putfield 1528	com/tencent/mobileqq/DrawerPushItem:reddotGameId	I
    //   322: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   325: ifeq +27 -> 352
    //   328: ldc 12
    //   330: iconst_2
    //   331: iconst_2
    //   332: anewarray 4	java/lang/Object
    //   335: dup
    //   336: iconst_0
    //   337: ldc_w 1530
    //   340: aastore
    //   341: dup
    //   342: iconst_1
    //   343: aload 6
    //   345: invokevirtual 1531	com/tencent/mobileqq/DrawerPushItem:toString	()Ljava/lang/String;
    //   348: aastore
    //   349: invokestatic 730	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   352: aload_0
    //   353: getfield 155	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mDrawerPushItems	Ljava/util/List;
    //   356: ifnull +24 -> 380
    //   359: aload_0
    //   360: aload 6
    //   362: invokespecial 403	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:alreadyContainsItem	(Lcom/tencent/mobileqq/DrawerPushItem;)Z
    //   365: ifne +15 -> 380
    //   368: aload_0
    //   369: getfield 155	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mDrawerPushItems	Ljava/util/List;
    //   372: aload 6
    //   374: invokeinterface 406 2 0
    //   379: pop
    //   380: aload_0
    //   381: getfield 227	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   384: aload 6
    //   386: invokevirtual 481	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   389: goto -316 -> 73
    //   392: aload 4
    //   394: monitorexit
    //   395: aload_3
    //   396: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   399: aload_3
    //   400: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   403: return
    //   404: astore_2
    //   405: aload 4
    //   407: monitorexit
    //   408: aload_2
    //   409: athrow
    //   410: astore_2
    //   411: goto +46 -> 457
    //   414: astore_2
    //   415: new 444	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   422: astore 4
    //   424: aload 4
    //   426: ldc_w 1533
    //   429: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload 4
    //   435: aload_2
    //   436: invokevirtual 642	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   439: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: ldc 12
    //   445: iconst_1
    //   446: aload 4
    //   448: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 597	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   454: goto -55 -> 399
    //   457: aload_3
    //   458: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   461: aload_2
    //   462: athrow
    //   463: ldc 12
    //   465: iconst_1
    //   466: ldc_w 1535
    //   469: invokestatic 597	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   472: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	473	0	this	ApolloDaoManagerServiceImpl
    //   0	473	1	paramInt	int
    //   0	473	2	paramList	List<tencent.im.s2c.msgtype0x210.submsgtype0xdc.submsgtype0xdc.MsgContent>
    //   52	406	3	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   91	220	5	localMsgContent	tencent.im.s2c.msgtype0x210.submsgtype0xdc.submsgtype0xdc.MsgContent
    //   100	285	6	localDrawerPushItem	DrawerPushItem
    // Exception table:
    //   from	to	target	type
    //   66	73	404	finally
    //   73	352	404	finally
    //   352	380	404	finally
    //   380	389	404	finally
    //   392	395	404	finally
    //   405	408	404	finally
    //   53	66	410	finally
    //   395	399	410	finally
    //   408	410	410	finally
    //   415	454	410	finally
    //   53	66	414	java/lang/Exception
    //   395	399	414	java/lang/Exception
    //   408	410	414	java/lang/Exception
  }
  
  /* Error */
  public void saveCommConfigTableKvMap(List<ApolloCommConfigKvData> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +271 -> 272
    //   4: aload_1
    //   5: invokeinterface 266 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 147	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mCommConfigKvLists	Ljava/util/List;
    //   18: astore_2
    //   19: aload_2
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 147	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mCommConfigKvLists	Ljava/util/List;
    //   25: invokeinterface 391 1 0
    //   30: aload_0
    //   31: getfield 147	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mCommConfigKvLists	Ljava/util/List;
    //   34: aload_1
    //   35: invokeinterface 273 2 0
    //   40: pop
    //   41: aload_2
    //   42: monitorexit
    //   43: aload_0
    //   44: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   47: astore_2
    //   48: aload_2
    //   49: ifnonnull +4 -> 53
    //   52: return
    //   53: aload_2
    //   54: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   57: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   60: astore_3
    //   61: aload_3
    //   62: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   65: astore_2
    //   66: aload_2
    //   67: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   70: new 444	java/lang/StringBuilder
    //   73: dup
    //   74: sipush 500
    //   77: invokespecial 550	java/lang/StringBuilder:<init>	(I)V
    //   80: astore 4
    //   82: aload_1
    //   83: invokeinterface 239 1 0
    //   88: astore_1
    //   89: aload_1
    //   90: invokeinterface 244 1 0
    //   95: ifeq +111 -> 206
    //   98: aload_1
    //   99: invokeinterface 248 1 0
    //   104: checkcast 942	com/tencent/mobileqq/apollo/model/ApolloCommConfigKvData
    //   107: astore 5
    //   109: aload_0
    //   110: aload_3
    //   111: aload 5
    //   113: invokevirtual 558	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   116: pop
    //   117: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +43 -> 163
    //   123: aload 4
    //   125: ldc_w 1539
    //   128: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 4
    //   134: aload 5
    //   136: getfield 949	com/tencent/mobileqq/apollo/model/ApolloCommConfigKvData:key	Ljava/lang/String;
    //   139: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 4
    //   145: ldc_w 1541
    //   148: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 4
    //   154: aload 5
    //   156: getfield 952	com/tencent/mobileqq/apollo/model/ApolloCommConfigKvData:value	Ljava/lang/String;
    //   159: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload 4
    //   165: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   168: sipush 500
    //   171: if_icmplt -82 -> 89
    //   174: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq -88 -> 89
    //   180: ldc 12
    //   182: iconst_2
    //   183: aload 4
    //   185: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: aload 4
    //   193: iconst_0
    //   194: aload 4
    //   196: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   199: invokevirtual 568	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: goto -114 -> 89
    //   206: aload 4
    //   208: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   211: sipush 500
    //   214: if_icmpge +20 -> 234
    //   217: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   220: ifeq +14 -> 234
    //   223: ldc 12
    //   225: iconst_2
    //   226: aload 4
    //   228: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aload_2
    //   235: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   238: goto +18 -> 256
    //   241: astore_1
    //   242: goto +19 -> 261
    //   245: astore_1
    //   246: ldc 12
    //   248: iconst_1
    //   249: ldc_w 1543
    //   252: aload_1
    //   253: invokestatic 432	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   256: aload_2
    //   257: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   260: return
    //   261: aload_2
    //   262: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   265: aload_1
    //   266: athrow
    //   267: astore_1
    //   268: aload_2
    //   269: monitorexit
    //   270: aload_1
    //   271: athrow
    //   272: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	ApolloDaoManagerServiceImpl
    //   0	273	1	paramList	List<ApolloCommConfigKvData>
    //   18	251	2	localObject	Object
    //   60	51	3	localEntityManager	EntityManager
    //   80	147	4	localStringBuilder	StringBuilder
    //   107	48	5	localApolloCommConfigKvData	ApolloCommConfigKvData
    // Exception table:
    //   from	to	target	type
    //   70	89	241	finally
    //   89	163	241	finally
    //   163	203	241	finally
    //   206	234	241	finally
    //   234	238	241	finally
    //   246	256	241	finally
    //   70	89	245	java/lang/Exception
    //   89	163	245	java/lang/Exception
    //   163	203	245	java/lang/Exception
    //   206	234	245	java/lang/Exception
    //   234	238	245	java/lang/Exception
    //   21	43	267	finally
    //   268	270	267	finally
  }
  
  public void saveObtainedActionList(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramJSONArray.length())
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          if (localJSONObject != null)
          {
            ApolloObtainedActionData localApolloObtainedActionData = new ApolloObtainedActionData();
            localApolloObtainedActionData.id = localJSONObject.optInt("id");
            localApolloObtainedActionData.beginTs = localJSONObject.optLong("beginTs");
            localApolloObtainedActionData.endts = localJSONObject.optLong("endts");
            localApolloObtainedActionData.way = localJSONObject.optInt("way");
            localApolloObtainedActionData.type = localJSONObject.optInt("type");
            localArrayList.add(localApolloObtainedActionData);
          }
        }
        else
        {
          removeAllObtainedAction();
          saveApolloObtainedActionList(localArrayList);
          return;
        }
      }
      catch (Exception paramJSONArray)
      {
        QLog.e("[cmshow]ApolloDaoManager", 1, "[saveApolloObtainedActionList] Exception =", paramJSONArray);
        return;
      }
      i += 1;
    }
  }
  
  public void saveOrUpdateApolloBaseInfo(ApolloBaseInfo paramApolloBaseInfo)
  {
    if (paramApolloBaseInfo != null)
    {
      if (TextUtils.isEmpty(paramApolloBaseInfo.uin)) {
        return;
      }
      Object localObject1 = getApp();
      if ((localObject1 != null) && (paramApolloBaseInfo.uin.equals(((AppRuntime)localObject1).getCurrentAccountUin())))
      {
        this.mSelfApolloBaseInfo = paramApolloBaseInfo;
        ??? = (ApolloManagerServiceImpl)((AppRuntime)localObject1).getRuntimeService(IApolloManagerService.class, "all");
        int i;
        if ((paramApolloBaseInfo.cmshow3dFlag & 0x2) == 2) {
          i = 1;
        } else {
          i = 0;
        }
        ((ApolloManagerServiceImpl)???).update3dWhiteList(i);
      }
      synchronized (this.mApolloBaseInfoCache)
      {
        this.mApolloBaseInfoCache.put(paramApolloBaseInfo.uin, paramApolloBaseInfo);
        updateEntity(paramApolloBaseInfo);
        if ((localObject1 != null) && (paramApolloBaseInfo.uin.equals(((AppRuntime)localObject1).getCurrentUin())))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("save apollo info : ");
          ((StringBuilder)localObject1).append(paramApolloBaseInfo.toString());
          QLog.d("[cmshow]ApolloDaoManager", 1, ((StringBuilder)localObject1).toString());
        }
        return;
      }
    }
  }
  
  public void saveOrUpdateApolloPandora(ApolloPandora paramApolloPandora)
  {
    if (paramApolloPandora != null)
    {
      if (TextUtils.isEmpty(paramApolloPandora.uin)) {
        return;
      }
      synchronized (this.apolloPandoraCache)
      {
        this.apolloPandoraCache.put(paramApolloPandora.uin, paramApolloPandora);
        updateEntity(paramApolloPandora);
        return;
      }
    }
  }
  
  /* Error */
  public void savePackageInfo(List<ApolloActionPackage> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +371 -> 372
    //   4: aload_1
    //   5: invokeinterface 266 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 101	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:packageList	Ljava/util/List;
    //   18: astore_3
    //   19: aload_3
    //   20: monitorenter
    //   21: aload_1
    //   22: invokeinterface 266 1 0
    //   27: iconst_1
    //   28: if_icmpne +125 -> 153
    //   31: aload_1
    //   32: iconst_0
    //   33: invokeinterface 632 2 0
    //   38: ifnull +115 -> 153
    //   41: aload_1
    //   42: iconst_0
    //   43: invokeinterface 632 2 0
    //   48: checkcast 750	com/tencent/mobileqq/apollo/model/ApolloActionPackage
    //   51: getfield 753	com/tencent/mobileqq/apollo/model/ApolloActionPackage:packageId	I
    //   54: bipush 100
    //   56: if_icmpne +97 -> 153
    //   59: iconst_0
    //   60: istore_2
    //   61: iload_2
    //   62: aload_0
    //   63: getfield 101	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:packageList	Ljava/util/List;
    //   66: invokeinterface 266 1 0
    //   71: if_icmpge +47 -> 118
    //   74: aload_0
    //   75: getfield 101	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:packageList	Ljava/util/List;
    //   78: iload_2
    //   79: invokeinterface 632 2 0
    //   84: checkcast 750	com/tencent/mobileqq/apollo/model/ApolloActionPackage
    //   87: getfield 753	com/tencent/mobileqq/apollo/model/ApolloActionPackage:packageId	I
    //   90: bipush 100
    //   92: if_icmpne +281 -> 373
    //   95: aload_0
    //   96: getfield 101	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:packageList	Ljava/util/List;
    //   99: iload_2
    //   100: invokeinterface 634 2 0
    //   105: pop
    //   106: ldc 12
    //   108: iconst_1
    //   109: ldc_w 1585
    //   112: invokestatic 612	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: goto +3 -> 118
    //   118: aload_0
    //   119: getfield 101	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:packageList	Ljava/util/List;
    //   122: iconst_0
    //   123: aload_1
    //   124: iconst_0
    //   125: invokeinterface 632 2 0
    //   130: invokeinterface 637 3 0
    //   135: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +26 -> 164
    //   141: ldc 12
    //   143: iconst_2
    //   144: ldc_w 1587
    //   147: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: goto +14 -> 164
    //   153: aload_0
    //   154: getfield 101	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:packageList	Ljava/util/List;
    //   157: aload_1
    //   158: invokeinterface 273 2 0
    //   163: pop
    //   164: aload_3
    //   165: monitorexit
    //   166: aload_0
    //   167: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   170: astore_3
    //   171: aload_3
    //   172: ifnonnull +4 -> 176
    //   175: return
    //   176: aload_3
    //   177: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   180: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   183: astore 4
    //   185: aload 4
    //   187: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   190: astore_3
    //   191: aload_3
    //   192: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   195: new 444	java/lang/StringBuilder
    //   198: dup
    //   199: sipush 200
    //   202: invokespecial 550	java/lang/StringBuilder:<init>	(I)V
    //   205: astore 5
    //   207: aload_1
    //   208: invokeinterface 239 1 0
    //   213: astore_1
    //   214: aload_1
    //   215: invokeinterface 244 1 0
    //   220: ifeq +86 -> 306
    //   223: aload_1
    //   224: invokeinterface 248 1 0
    //   229: checkcast 750	com/tencent/mobileqq/apollo/model/ApolloActionPackage
    //   232: astore 6
    //   234: aload_0
    //   235: aload 4
    //   237: aload 6
    //   239: invokevirtual 558	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   242: pop
    //   243: aload 5
    //   245: ldc_w 1589
    //   248: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload 5
    //   254: aload 6
    //   256: getfield 753	com/tencent/mobileqq/apollo/model/ApolloActionPackage:packageId	I
    //   259: invokevirtual 455	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 5
    //   265: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   268: sipush 200
    //   271: if_icmplt -57 -> 214
    //   274: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq +14 -> 291
    //   280: ldc 12
    //   282: iconst_2
    //   283: aload 5
    //   285: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: aload 5
    //   293: iconst_0
    //   294: aload 5
    //   296: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   299: invokevirtual 568	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: goto -89 -> 214
    //   306: aload 5
    //   308: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   311: sipush 200
    //   314: if_icmpge +20 -> 334
    //   317: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq +14 -> 334
    //   323: ldc 12
    //   325: iconst_2
    //   326: aload 5
    //   328: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   334: aload_3
    //   335: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   338: goto +18 -> 356
    //   341: astore_1
    //   342: goto +19 -> 361
    //   345: astore_1
    //   346: ldc 12
    //   348: iconst_1
    //   349: ldc_w 1365
    //   352: aload_1
    //   353: invokestatic 432	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   356: aload_3
    //   357: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   360: return
    //   361: aload_3
    //   362: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   365: aload_1
    //   366: athrow
    //   367: astore_1
    //   368: aload_3
    //   369: monitorexit
    //   370: aload_1
    //   371: athrow
    //   372: return
    //   373: iload_2
    //   374: iconst_1
    //   375: iadd
    //   376: istore_2
    //   377: goto -316 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	this	ApolloDaoManagerServiceImpl
    //   0	380	1	paramList	List<ApolloActionPackage>
    //   60	317	2	i	int
    //   18	351	3	localObject	Object
    //   183	53	4	localEntityManager	EntityManager
    //   205	122	5	localStringBuilder	StringBuilder
    //   232	23	6	localApolloActionPackage	ApolloActionPackage
    // Exception table:
    //   from	to	target	type
    //   195	214	341	finally
    //   214	291	341	finally
    //   291	303	341	finally
    //   306	334	341	finally
    //   334	338	341	finally
    //   346	356	341	finally
    //   195	214	345	java/lang/Exception
    //   214	291	345	java/lang/Exception
    //   291	303	345	java/lang/Exception
    //   306	334	345	java/lang/Exception
    //   334	338	345	java/lang/Exception
    //   21	59	367	finally
    //   61	115	367	finally
    //   118	150	367	finally
    //   153	164	367	finally
    //   164	166	367	finally
    //   368	370	367	finally
  }
  
  /* Error */
  public void savePreDownloadRes(Map<String, ApolloPreDownloadData> paramMap, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifeq +10 -> 11
    //   4: aload_0
    //   5: getfield 137	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mPreDownloadMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   8: invokevirtual 577	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   11: aload_0
    //   12: getfield 137	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mPreDownloadMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   15: aload_1
    //   16: invokevirtual 1593	java/util/concurrent/ConcurrentHashMap:putAll	(Ljava/util/Map;)V
    //   19: aload_0
    //   20: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   23: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   26: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   29: astore 4
    //   31: aload 4
    //   33: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   36: astore_3
    //   37: aload_3
    //   38: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   41: iload_2
    //   42: ifeq +12 -> 54
    //   45: aload 4
    //   47: ldc_w 1595
    //   50: invokevirtual 1326	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   53: pop
    //   54: aload_1
    //   55: invokeinterface 1599 1 0
    //   60: invokeinterface 1602 1 0
    //   65: astore_1
    //   66: aload_1
    //   67: invokeinterface 244 1 0
    //   72: ifeq +20 -> 92
    //   75: aload 4
    //   77: aload_1
    //   78: invokeinterface 248 1 0
    //   83: checkcast 1087	com/tencent/mobileqq/apollo/model/ApolloPreDownloadData
    //   86: invokevirtual 481	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   89: goto -23 -> 66
    //   92: aload_3
    //   93: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   96: goto +18 -> 114
    //   99: astore_1
    //   100: goto +19 -> 119
    //   103: astore_1
    //   104: ldc 12
    //   106: iconst_1
    //   107: ldc_w 1604
    //   110: aload_1
    //   111: invokestatic 432	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   114: aload_3
    //   115: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   118: return
    //   119: aload_3
    //   120: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   123: goto +5 -> 128
    //   126: aload_1
    //   127: athrow
    //   128: goto -2 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	ApolloDaoManagerServiceImpl
    //   0	131	1	paramMap	Map<String, ApolloPreDownloadData>
    //   0	131	2	paramBoolean	boolean
    //   36	84	3	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   29	47	4	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   45	54	99	finally
    //   54	66	99	finally
    //   66	89	99	finally
    //   92	96	99	finally
    //   104	114	99	finally
    //   45	54	103	java/lang/Exception
    //   54	66	103	java/lang/Exception
    //   66	89	103	java/lang/Exception
    //   92	96	103	java/lang/Exception
  }
  
  /* Error */
  public void saveRecommendActionList(List<ApolloRecommendAction> paramList)
  {
    // Byte code:
    //   0: ldc 12
    //   2: iconst_1
    //   3: ldc_w 1607
    //   6: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_0
    //   10: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   13: ifnull +138 -> 151
    //   16: aload_1
    //   17: ifnull +134 -> 151
    //   20: aload_1
    //   21: invokeinterface 266 1 0
    //   26: ifne +4 -> 30
    //   29: return
    //   30: aload_0
    //   31: getfield 141	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mRecommendActionList	Ljava/util/List;
    //   34: astore_2
    //   35: aload_2
    //   36: monitorenter
    //   37: aload_0
    //   38: getfield 141	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mRecommendActionList	Ljava/util/List;
    //   41: invokeinterface 391 1 0
    //   46: aload_0
    //   47: getfield 141	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mRecommendActionList	Ljava/util/List;
    //   50: aload_1
    //   51: invokeinterface 273 2 0
    //   56: pop
    //   57: aload_2
    //   58: monitorexit
    //   59: aload_0
    //   60: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   63: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   66: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   69: astore_3
    //   70: aload_3
    //   71: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   79: aload_1
    //   80: invokeinterface 239 1 0
    //   85: astore_1
    //   86: aload_1
    //   87: invokeinterface 244 1 0
    //   92: ifeq +21 -> 113
    //   95: aload_0
    //   96: aload_3
    //   97: aload_1
    //   98: invokeinterface 248 1 0
    //   103: checkcast 1096	com/tencent/mobileqq/apollo/model/ApolloRecommendAction
    //   106: invokevirtual 558	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   109: pop
    //   110: goto -24 -> 86
    //   113: aload_2
    //   114: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   117: goto +18 -> 135
    //   120: astore_1
    //   121: goto +19 -> 140
    //   124: astore_1
    //   125: ldc 12
    //   127: iconst_1
    //   128: ldc_w 1609
    //   131: aload_1
    //   132: invokestatic 432	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   135: aload_2
    //   136: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   139: return
    //   140: aload_2
    //   141: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   144: aload_1
    //   145: athrow
    //   146: astore_1
    //   147: aload_2
    //   148: monitorexit
    //   149: aload_1
    //   150: athrow
    //   151: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	ApolloDaoManagerServiceImpl
    //   0	152	1	paramList	List<ApolloRecommendAction>
    //   34	114	2	localObject	Object
    //   69	28	3	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   79	86	120	finally
    //   86	110	120	finally
    //   113	117	120	finally
    //   125	135	120	finally
    //   79	86	124	java/lang/Exception
    //   86	110	124	java/lang/Exception
    //   113	117	124	java/lang/Exception
    //   37	59	146	finally
    //   147	149	146	finally
  }
  
  /* Error */
  public void saveRelationTag(List<ApolloRelationTag> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +242 -> 243
    //   4: aload_1
    //   5: invokeinterface 266 1 0
    //   10: ifeq +233 -> 243
    //   13: aload_0
    //   14: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: aload_0
    //   22: getfield 145	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mRelationTagList	Ljava/util/List;
    //   25: astore_2
    //   26: aload_2
    //   27: monitorenter
    //   28: aload_0
    //   29: getfield 145	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mRelationTagList	Ljava/util/List;
    //   32: aload_1
    //   33: invokeinterface 273 2 0
    //   38: pop
    //   39: aload_2
    //   40: monitorexit
    //   41: aload_0
    //   42: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   45: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   48: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   51: astore_3
    //   52: aload_3
    //   53: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   56: astore_2
    //   57: aload_2
    //   58: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   61: new 444	java/lang/StringBuilder
    //   64: dup
    //   65: sipush 500
    //   68: invokespecial 550	java/lang/StringBuilder:<init>	(I)V
    //   71: astore 4
    //   73: aload_1
    //   74: invokeinterface 239 1 0
    //   79: astore_1
    //   80: aload_1
    //   81: invokeinterface 244 1 0
    //   86: ifeq +91 -> 177
    //   89: aload_1
    //   90: invokeinterface 248 1 0
    //   95: checkcast 1121	com/tencent/mobileqq/apollo/model/ApolloRelationTag
    //   98: astore 5
    //   100: aload_0
    //   101: aload_3
    //   102: aload 5
    //   104: invokevirtual 558	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   107: pop
    //   108: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +23 -> 134
    //   114: aload 4
    //   116: ldc_w 1613
    //   119: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 4
    //   125: aload 5
    //   127: getfield 1614	com/tencent/mobileqq/apollo/model/ApolloRelationTag:type	I
    //   130: invokevirtual 455	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 4
    //   136: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   139: sipush 500
    //   142: if_icmplt -62 -> 80
    //   145: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq -68 -> 80
    //   151: ldc 12
    //   153: iconst_2
    //   154: aload 4
    //   156: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload 4
    //   164: iconst_0
    //   165: aload 4
    //   167: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   170: invokevirtual 568	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: goto -94 -> 80
    //   177: aload 4
    //   179: invokevirtual 564	java/lang/StringBuilder:length	()I
    //   182: sipush 500
    //   185: if_icmpge +20 -> 205
    //   188: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq +14 -> 205
    //   194: ldc 12
    //   196: iconst_2
    //   197: aload 4
    //   199: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload_2
    //   206: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   209: goto +18 -> 227
    //   212: astore_1
    //   213: goto +19 -> 232
    //   216: astore_1
    //   217: ldc 12
    //   219: iconst_1
    //   220: ldc_w 1616
    //   223: aload_1
    //   224: invokestatic 432	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   227: aload_2
    //   228: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   231: return
    //   232: aload_2
    //   233: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   236: aload_1
    //   237: athrow
    //   238: astore_1
    //   239: aload_2
    //   240: monitorexit
    //   241: aload_1
    //   242: athrow
    //   243: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	ApolloDaoManagerServiceImpl
    //   0	244	1	paramList	List<ApolloRelationTag>
    //   25	215	2	localObject	Object
    //   51	51	3	localEntityManager	EntityManager
    //   71	127	4	localStringBuilder	StringBuilder
    //   98	28	5	localApolloRelationTag	ApolloRelationTag
    // Exception table:
    //   from	to	target	type
    //   61	80	212	finally
    //   80	134	212	finally
    //   134	174	212	finally
    //   177	205	212	finally
    //   205	209	212	finally
    //   217	227	212	finally
    //   61	80	216	java/lang/Exception
    //   80	134	216	java/lang/Exception
    //   134	174	216	java/lang/Exception
    //   177	205	216	java/lang/Exception
    //   205	209	216	java/lang/Exception
    //   28	41	238	finally
    //   239	241	238	finally
  }
  
  public void saveSelfApolloDress(AppRuntime paramAppRuntime, String paramString)
  {
    Object localObject2;
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      try
      {
        long l = new JSONObject(paramString).optLong("ts");
        localObject1 = getApolloBaseInfo(paramAppRuntime.getCurrentAccountUin());
        paramAppRuntime = ((ApolloBaseInfo)localObject1).getApolloDress();
        ((ApolloBaseInfo)localObject1).setApolloDress(l, paramString);
        localObject2 = ((ApolloBaseInfo)localObject1).getApolloDress();
        paramString = "";
        if (paramAppRuntime == null) {
          paramAppRuntime = "";
        } else {
          paramAppRuntime = paramAppRuntime.encode();
        }
      }
      catch (Exception paramAppRuntime)
      {
        Object localObject1;
        QLog.e("ApolloBaseInfo", 2, paramAppRuntime.getMessage());
      }
      paramString = ((ApolloDress)localObject2).encode();
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.equals(paramAppRuntime, paramString))) {
        ((ApolloBaseInfo)localObject1).apolloHistoryDress = paramAppRuntime;
      }
      ((ApolloBaseInfo)localObject1).appearAction = null;
      ((IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class)).delAllGifCache();
      saveOrUpdateApolloBaseInfo((ApolloBaseInfo)localObject1);
      localObject2 = new ArrayList(1);
      ((List)localObject2).add(localObject1);
      ApolloResManagerFacade.a.a((List)localObject2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("save history self dress: ");
        ((StringBuilder)localObject1).append(paramAppRuntime);
        ((StringBuilder)localObject1).append(", new dres: ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("ApolloBaseInfo", 2, ((StringBuilder)localObject1).toString());
        return;
      }
      return;
      if (localObject2 != null) {
        break;
      }
    }
  }
  
  /* Error */
  public void saveWhiteFaceIdMapping(boolean paramBoolean, List<ApolloWhiteFaceID> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aload_3
    //   11: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   14: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   24: astore_3
    //   25: aload_3
    //   26: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   29: iload_1
    //   30: ifeq +98 -> 128
    //   33: aload 4
    //   35: ldc_w 1140
    //   38: invokevirtual 293	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   41: astore_2
    //   42: aload_2
    //   43: ifnull +194 -> 237
    //   46: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +31 -> 80
    //   52: ldc 12
    //   54: iconst_2
    //   55: iconst_2
    //   56: anewarray 4	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: ldc_w 1667
    //   64: aastore
    //   65: dup
    //   66: iconst_1
    //   67: aload_2
    //   68: invokeinterface 266 1 0
    //   73: invokestatic 534	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   76: aastore
    //   77: invokestatic 730	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   80: aload_2
    //   81: invokeinterface 239 1 0
    //   86: astore_2
    //   87: aload_2
    //   88: invokeinterface 244 1 0
    //   93: ifeq +144 -> 237
    //   96: aload_2
    //   97: invokeinterface 248 1 0
    //   102: checkcast 1140	com/tencent/mobileqq/apollo/model/ApolloWhiteFaceID
    //   105: astore 4
    //   107: aload_0
    //   108: getfield 139	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mWhiteFaceIdMapping	Ljava/util/concurrent/ConcurrentHashMap;
    //   111: aload 4
    //   113: getfield 1670	com/tencent/mobileqq/apollo/model/ApolloWhiteFaceID:terminalId	I
    //   116: invokestatic 534	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: aload 4
    //   121: invokevirtual 470	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   124: pop
    //   125: goto -38 -> 87
    //   128: aload_2
    //   129: ifnull +108 -> 237
    //   132: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +31 -> 166
    //   138: ldc 12
    //   140: iconst_2
    //   141: iconst_2
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: ldc_w 1672
    //   150: aastore
    //   151: dup
    //   152: iconst_1
    //   153: aload_2
    //   154: invokeinterface 266 1 0
    //   159: invokestatic 534	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: aastore
    //   163: invokestatic 730	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   166: aload 4
    //   168: ldc_w 1674
    //   171: invokevirtual 1326	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   174: pop
    //   175: aload_0
    //   176: getfield 139	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mWhiteFaceIdMapping	Ljava/util/concurrent/ConcurrentHashMap;
    //   179: invokevirtual 577	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   182: aload_2
    //   183: invokeinterface 239 1 0
    //   188: astore_2
    //   189: aload_2
    //   190: invokeinterface 244 1 0
    //   195: ifeq +42 -> 237
    //   198: aload_2
    //   199: invokeinterface 248 1 0
    //   204: checkcast 1140	com/tencent/mobileqq/apollo/model/ApolloWhiteFaceID
    //   207: astore 5
    //   209: aload_0
    //   210: getfield 139	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mWhiteFaceIdMapping	Ljava/util/concurrent/ConcurrentHashMap;
    //   213: aload 5
    //   215: getfield 1670	com/tencent/mobileqq/apollo/model/ApolloWhiteFaceID:terminalId	I
    //   218: invokestatic 534	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   221: aload 5
    //   223: invokevirtual 470	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   226: pop
    //   227: aload 4
    //   229: aload 5
    //   231: invokevirtual 481	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   234: goto -45 -> 189
    //   237: aload_3
    //   238: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   241: aload_3
    //   242: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   245: return
    //   246: ldc 12
    //   248: iconst_1
    //   249: ldc_w 1676
    //   252: aload_2
    //   253: invokestatic 432	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   256: goto -15 -> 241
    //   259: aload_3
    //   260: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   263: goto +5 -> 268
    //   266: aload_2
    //   267: athrow
    //   268: goto -2 -> 266
    //   271: astore_2
    //   272: goto -13 -> 259
    //   275: astore_2
    //   276: goto -30 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	ApolloDaoManagerServiceImpl
    //   0	279	1	paramBoolean	boolean
    //   0	279	2	paramList	List<ApolloWhiteFaceID>
    //   4	256	3	localObject1	Object
    //   17	211	4	localObject2	Object
    //   207	23	5	localApolloWhiteFaceID	ApolloWhiteFaceID
    // Exception table:
    //   from	to	target	type
    //   33	42	271	finally
    //   46	80	271	finally
    //   80	87	271	finally
    //   87	125	271	finally
    //   132	166	271	finally
    //   166	189	271	finally
    //   189	234	271	finally
    //   237	241	271	finally
    //   246	256	271	finally
    //   33	42	275	java/lang/Exception
    //   46	80	275	java/lang/Exception
    //   80	87	275	java/lang/Exception
    //   87	125	275	java/lang/Exception
    //   132	166	275	java/lang/Exception
    //   166	189	275	java/lang/Exception
    //   189	234	275	java/lang/Exception
    //   237	241	275	java/lang/Exception
  }
  
  public void updateAction(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData != null) {
      if (this.mApp == null) {
        return;
      }
    }
    for (;;)
    {
      int i;
      synchronized (this.actionList)
      {
        i = this.actionList.size() - 1;
        if (i >= 0)
        {
          if ((this.actionList.get(i) == null) || (((ApolloActionData)this.actionList.get(i)).actionId != paramApolloActionData.actionId)) {
            break label127;
          }
          this.actionList.remove(i);
          this.actionList.add(i, paramApolloActionData);
        }
        ??? = this.mApp;
        if (??? == null) {
          return;
        }
        ((AppInterface)???).getEntityManagerFactory().createEntityManager().update(paramApolloActionData);
        return;
      }
      return;
      label127:
      i -= 1;
    }
  }
  
  /* Error */
  public void updateBattleGameInfo(int paramInt, List<ApolloBattleGameInfo> paramList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +13 -> 14
    //   4: ldc 12
    //   6: iconst_1
    //   7: ldc_w 1681
    //   10: invokestatic 597	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13: return
    //   14: aload_0
    //   15: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   18: ifnonnull +13 -> 31
    //   21: ldc 12
    //   23: iconst_1
    //   24: ldc_w 1683
    //   27: invokestatic 597	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: return
    //   31: aload_0
    //   32: getfield 109	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mBattleGameList	Ljava/util/List;
    //   35: astore 4
    //   37: aload 4
    //   39: monitorenter
    //   40: aload_0
    //   41: getfield 109	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mBattleGameList	Ljava/util/List;
    //   44: invokeinterface 266 1 0
    //   49: iconst_1
    //   50: isub
    //   51: istore_3
    //   52: iload_3
    //   53: iflt +37 -> 90
    //   56: aload_0
    //   57: getfield 109	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mBattleGameList	Ljava/util/List;
    //   60: iload_3
    //   61: invokeinterface 632 2 0
    //   66: checkcast 924	com/tencent/mobileqq/apollo/model/ApolloBattleGameInfo
    //   69: getfield 927	com/tencent/mobileqq/apollo/model/ApolloBattleGameInfo:sceneId	I
    //   72: iload_1
    //   73: if_icmpne +212 -> 285
    //   76: aload_0
    //   77: getfield 109	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mBattleGameList	Ljava/util/List;
    //   80: iload_3
    //   81: invokeinterface 634 2 0
    //   86: pop
    //   87: goto +198 -> 285
    //   90: aload_0
    //   91: getfield 109	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mBattleGameList	Ljava/util/List;
    //   94: aload_2
    //   95: invokeinterface 273 2 0
    //   100: pop
    //   101: aload 4
    //   103: monitorexit
    //   104: aload_0
    //   105: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   108: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   111: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   114: astore 5
    //   116: aload 5
    //   118: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   121: astore 4
    //   123: aload 4
    //   125: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   128: new 444	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   135: astore 6
    //   137: aload 6
    //   139: ldc_w 1685
    //   142: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 6
    //   148: iload_1
    //   149: invokevirtual 455	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 5
    //   155: aload 6
    //   157: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokevirtual 1326	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   163: pop
    //   164: aload_2
    //   165: invokeinterface 239 1 0
    //   170: astore_2
    //   171: aload_2
    //   172: invokeinterface 244 1 0
    //   177: ifeq +22 -> 199
    //   180: aload_0
    //   181: aload 5
    //   183: aload_2
    //   184: invokeinterface 248 1 0
    //   189: checkcast 924	com/tencent/mobileqq/apollo/model/ApolloBattleGameInfo
    //   192: invokevirtual 558	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   195: pop
    //   196: goto -25 -> 171
    //   199: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +35 -> 237
    //   205: new 444	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   212: astore_2
    //   213: aload_2
    //   214: ldc_w 1687
    //   217: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload_2
    //   222: iload_1
    //   223: invokevirtual 455	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: ldc 12
    //   229: iconst_1
    //   230: aload_2
    //   231: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 597	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: aload 4
    //   239: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   242: goto +18 -> 260
    //   245: astore_2
    //   246: goto +20 -> 266
    //   249: astore_2
    //   250: ldc 12
    //   252: iconst_1
    //   253: ldc_w 1689
    //   256: aload_2
    //   257: invokestatic 432	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   260: aload 4
    //   262: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   265: return
    //   266: aload 4
    //   268: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   271: aload_2
    //   272: athrow
    //   273: astore_2
    //   274: aload 4
    //   276: monitorexit
    //   277: goto +5 -> 282
    //   280: aload_2
    //   281: athrow
    //   282: goto -2 -> 280
    //   285: iload_3
    //   286: iconst_1
    //   287: isub
    //   288: istore_3
    //   289: goto -237 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	ApolloDaoManagerServiceImpl
    //   0	292	1	paramInt	int
    //   0	292	2	paramList	List<ApolloBattleGameInfo>
    //   51	238	3	i	int
    //   35	240	4	localObject	Object
    //   114	68	5	localEntityManager	EntityManager
    //   135	21	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   128	171	245	finally
    //   171	196	245	finally
    //   199	237	245	finally
    //   237	242	245	finally
    //   250	260	245	finally
    //   128	171	249	java/lang/Exception
    //   171	196	249	java/lang/Exception
    //   199	237	249	java/lang/Exception
    //   237	242	249	java/lang/Exception
    //   40	52	273	finally
    //   56	87	273	finally
    //   90	104	273	finally
    //   274	277	273	finally
  }
  
  /* Error */
  public void updateCmBattleGameInfo(List<CmBattleGameInfo> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: ldc 12
    //   6: iconst_1
    //   7: ldc_w 1693
    //   10: invokestatic 597	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13: return
    //   14: aload_0
    //   15: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   18: ifnonnull +13 -> 31
    //   21: ldc 12
    //   23: iconst_1
    //   24: ldc_w 1683
    //   27: invokestatic 597	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: return
    //   31: aload_0
    //   32: getfield 118	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mCmBattleGameInfoSet	Ljava/util/Set;
    //   35: astore_2
    //   36: aload_2
    //   37: monitorenter
    //   38: aload_0
    //   39: getfield 118	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mCmBattleGameInfoSet	Ljava/util/Set;
    //   42: aload_1
    //   43: invokeinterface 938 2 0
    //   48: pop
    //   49: aload_2
    //   50: monitorexit
    //   51: aload_0
    //   52: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   55: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   58: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   61: astore_3
    //   62: aload_3
    //   63: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   66: astore_2
    //   67: aload_2
    //   68: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   71: aload_1
    //   72: invokeinterface 239 1 0
    //   77: astore_1
    //   78: aload_1
    //   79: invokeinterface 244 1 0
    //   84: ifeq +21 -> 105
    //   87: aload_0
    //   88: aload_3
    //   89: aload_1
    //   90: invokeinterface 248 1 0
    //   95: checkcast 937	com/tencent/mobileqq/apollo/model/CmBattleGameInfo
    //   98: invokevirtual 558	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   101: pop
    //   102: goto -24 -> 78
    //   105: aload_2
    //   106: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   109: goto +18 -> 127
    //   112: astore_1
    //   113: goto +19 -> 132
    //   116: astore_1
    //   117: ldc 12
    //   119: iconst_1
    //   120: ldc_w 1695
    //   123: aload_1
    //   124: invokestatic 432	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   127: aload_2
    //   128: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   131: return
    //   132: aload_2
    //   133: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   136: aload_1
    //   137: athrow
    //   138: astore_1
    //   139: aload_2
    //   140: monitorexit
    //   141: goto +5 -> 146
    //   144: aload_1
    //   145: athrow
    //   146: goto -2 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	ApolloDaoManagerServiceImpl
    //   0	149	1	paramList	List<CmBattleGameInfo>
    //   35	105	2	localObject	Object
    //   61	28	3	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   71	78	112	finally
    //   78	102	112	finally
    //   105	109	112	finally
    //   117	127	112	finally
    //   71	78	116	java/lang/Exception
    //   78	102	116	java/lang/Exception
    //   105	109	116	java/lang/Exception
    //   38	51	138	finally
    //   139	141	138	finally
  }
  
  public boolean updateEntity(EntityManager paramEntityManager, Entity paramEntity)
  {
    try
    {
      boolean bool2 = paramEntityManager.isOpen();
      boolean bool1 = false;
      if (bool2)
      {
        if (paramEntity.getStatus() == 1000)
        {
          paramEntityManager.persistOrReplace(paramEntity);
          int i = paramEntity.getStatus();
          if (i == 1001) {
            bool1 = true;
          }
          return bool1;
        }
        if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002))
        {
          bool1 = paramEntityManager.update(paramEntity);
          return bool1;
        }
      }
      if (QLog.isColorLevel())
      {
        paramEntityManager = new StringBuilder();
        paramEntityManager.append("updateEntity em closed e=");
        paramEntityManager.append(paramEntity.getTableName());
        QLog.d("[cmshow]ApolloDaoManager", 2, paramEntityManager.toString());
      }
      return false;
    }
    finally {}
  }
  
  /* Error */
  @Deprecated
  public void updateGameInfoList(List<ApolloGameData> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +618 -> 619
    //   4: aload_1
    //   5: invokeinterface 266 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: new 444	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   21: astore 6
    //   23: new 444	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   30: astore 7
    //   32: new 90	java/util/ArrayList
    //   35: dup
    //   36: invokespecial 91	java/util/ArrayList:<init>	()V
    //   39: astore 8
    //   41: aload_0
    //   42: getfield 107	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:gameList	Ljava/util/List;
    //   45: astore 5
    //   47: aload 5
    //   49: monitorenter
    //   50: aload_0
    //   51: getfield 107	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:gameList	Ljava/util/List;
    //   54: invokeinterface 266 1 0
    //   59: ifne +26 -> 85
    //   62: aload_0
    //   63: getfield 107	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:gameList	Ljava/util/List;
    //   66: aload_1
    //   67: invokeinterface 273 2 0
    //   72: pop
    //   73: aload 6
    //   75: ldc_w 1699
    //   78: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: goto +204 -> 286
    //   85: aload 6
    //   87: ldc_w 1701
    //   90: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: iconst_0
    //   95: istore_2
    //   96: iload_2
    //   97: aload_1
    //   98: invokeinterface 266 1 0
    //   103: if_icmpge +183 -> 286
    //   106: iconst_0
    //   107: istore_3
    //   108: iconst_0
    //   109: istore 4
    //   111: iload_3
    //   112: aload_0
    //   113: getfield 107	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:gameList	Ljava/util/List;
    //   116: invokeinterface 266 1 0
    //   121: if_icmpge +112 -> 233
    //   124: aload_1
    //   125: iload_2
    //   126: invokeinterface 632 2 0
    //   131: checkcast 287	com/tencent/mobileqq/apollo/model/ApolloGameData
    //   134: getfield 744	com/tencent/mobileqq/apollo/model/ApolloGameData:gameId	I
    //   137: aload_0
    //   138: getfield 107	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:gameList	Ljava/util/List;
    //   141: iload_3
    //   142: invokeinterface 632 2 0
    //   147: checkcast 287	com/tencent/mobileqq/apollo/model/ApolloGameData
    //   150: getfield 744	com/tencent/mobileqq/apollo/model/ApolloGameData:gameId	I
    //   153: if_icmpne +467 -> 620
    //   156: aload 8
    //   158: aload_1
    //   159: iload_2
    //   160: invokeinterface 632 2 0
    //   165: invokeinterface 406 2 0
    //   170: pop
    //   171: aload_0
    //   172: getfield 107	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:gameList	Ljava/util/List;
    //   175: iload_3
    //   176: invokeinterface 634 2 0
    //   181: pop
    //   182: aload_0
    //   183: getfield 107	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:gameList	Ljava/util/List;
    //   186: iload_3
    //   187: aload_1
    //   188: iload_2
    //   189: invokeinterface 632 2 0
    //   194: invokeinterface 637 3 0
    //   199: aload 6
    //   201: aload_1
    //   202: iload_2
    //   203: invokeinterface 632 2 0
    //   208: checkcast 287	com/tencent/mobileqq/apollo/model/ApolloGameData
    //   211: getfield 744	com/tencent/mobileqq/apollo/model/ApolloGameData:gameId	I
    //   214: invokevirtual 455	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 6
    //   220: ldc_w 521
    //   223: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: iconst_1
    //   228: istore 4
    //   230: goto +390 -> 620
    //   233: iload 4
    //   235: ifne +392 -> 627
    //   238: aload_0
    //   239: getfield 107	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:gameList	Ljava/util/List;
    //   242: aload_1
    //   243: iload_2
    //   244: invokeinterface 632 2 0
    //   249: invokeinterface 406 2 0
    //   254: pop
    //   255: aload 7
    //   257: aload_1
    //   258: iload_2
    //   259: invokeinterface 632 2 0
    //   264: checkcast 287	com/tencent/mobileqq/apollo/model/ApolloGameData
    //   267: getfield 744	com/tencent/mobileqq/apollo/model/ApolloGameData:gameId	I
    //   270: invokevirtual 455	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 7
    //   276: ldc_w 521
    //   279: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: goto +344 -> 627
    //   286: aload 5
    //   288: monitorexit
    //   289: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq +41 -> 333
    //   295: ldc 12
    //   297: iconst_2
    //   298: iconst_4
    //   299: anewarray 4	java/lang/Object
    //   302: dup
    //   303: iconst_0
    //   304: ldc_w 1703
    //   307: aastore
    //   308: dup
    //   309: iconst_1
    //   310: aload 6
    //   312: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: aastore
    //   316: dup
    //   317: iconst_2
    //   318: ldc_w 1705
    //   321: aastore
    //   322: dup
    //   323: iconst_3
    //   324: aload 7
    //   326: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: aastore
    //   330: invokestatic 730	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   333: aload_0
    //   334: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   337: astore 5
    //   339: aload 5
    //   341: ifnonnull +4 -> 345
    //   344: return
    //   345: aload 5
    //   347: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   350: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   353: astore 6
    //   355: aload 6
    //   357: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   360: astore 5
    //   362: aload 5
    //   364: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   367: new 444	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   374: astore 7
    //   376: aload 7
    //   378: ldc_w 1707
    //   381: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload 8
    //   387: invokeinterface 239 1 0
    //   392: astore 8
    //   394: aload 8
    //   396: invokeinterface 244 1 0
    //   401: ifeq +78 -> 479
    //   404: aload 8
    //   406: invokeinterface 248 1 0
    //   411: checkcast 287	com/tencent/mobileqq/apollo/model/ApolloGameData
    //   414: astore 9
    //   416: new 444	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   423: astore 10
    //   425: aload 10
    //   427: ldc_w 1709
    //   430: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: aload 10
    //   436: aload 9
    //   438: getfield 744	com/tencent/mobileqq/apollo/model/ApolloGameData:gameId	I
    //   441: invokevirtual 455	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload 6
    //   447: aload 10
    //   449: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokevirtual 1326	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   455: pop
    //   456: aload 7
    //   458: aload 9
    //   460: getfield 744	com/tencent/mobileqq/apollo/model/ApolloGameData:gameId	I
    //   463: invokevirtual 455	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload 7
    //   469: ldc_w 521
    //   472: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: goto -82 -> 394
    //   479: aload 7
    //   481: ldc_w 1711
    //   484: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload_1
    //   489: invokeinterface 239 1 0
    //   494: astore_1
    //   495: aload_1
    //   496: invokeinterface 244 1 0
    //   501: ifeq +46 -> 547
    //   504: aload_1
    //   505: invokeinterface 248 1 0
    //   510: checkcast 287	com/tencent/mobileqq/apollo/model/ApolloGameData
    //   513: astore 8
    //   515: aload_0
    //   516: aload 6
    //   518: aload 8
    //   520: invokevirtual 558	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   523: pop
    //   524: aload 7
    //   526: aload 8
    //   528: getfield 744	com/tencent/mobileqq/apollo/model/ApolloGameData:gameId	I
    //   531: invokevirtual 455	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload 7
    //   537: ldc_w 521
    //   540: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: goto -49 -> 495
    //   547: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   550: ifeq +27 -> 577
    //   553: ldc 12
    //   555: iconst_2
    //   556: iconst_2
    //   557: anewarray 4	java/lang/Object
    //   560: dup
    //   561: iconst_0
    //   562: ldc_w 1713
    //   565: aastore
    //   566: dup
    //   567: iconst_1
    //   568: aload 7
    //   570: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: aastore
    //   574: invokestatic 730	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   577: aload 5
    //   579: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   582: goto +18 -> 600
    //   585: astore_1
    //   586: goto +20 -> 606
    //   589: astore_1
    //   590: ldc 12
    //   592: iconst_1
    //   593: ldc_w 1715
    //   596: aload_1
    //   597: invokestatic 432	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   600: aload 5
    //   602: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   605: return
    //   606: aload 5
    //   608: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   611: aload_1
    //   612: athrow
    //   613: astore_1
    //   614: aload 5
    //   616: monitorexit
    //   617: aload_1
    //   618: athrow
    //   619: return
    //   620: iload_3
    //   621: iconst_1
    //   622: iadd
    //   623: istore_3
    //   624: goto -513 -> 111
    //   627: iload_2
    //   628: iconst_1
    //   629: iadd
    //   630: istore_2
    //   631: goto -535 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	634	0	this	ApolloDaoManagerServiceImpl
    //   0	634	1	paramList	List<ApolloGameData>
    //   95	536	2	i	int
    //   107	517	3	j	int
    //   109	125	4	k	int
    //   45	570	5	localObject1	Object
    //   21	496	6	localObject2	Object
    //   30	539	7	localStringBuilder1	StringBuilder
    //   39	488	8	localObject3	Object
    //   414	45	9	localApolloGameData	ApolloGameData
    //   423	25	10	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   367	394	585	finally
    //   394	476	585	finally
    //   479	495	585	finally
    //   495	544	585	finally
    //   547	577	585	finally
    //   577	582	585	finally
    //   590	600	585	finally
    //   367	394	589	java/lang/Exception
    //   394	476	589	java/lang/Exception
    //   479	495	589	java/lang/Exception
    //   495	544	589	java/lang/Exception
    //   547	577	589	java/lang/Exception
    //   577	582	589	java/lang/Exception
    //   50	82	613	finally
    //   85	94	613	finally
    //   96	106	613	finally
    //   111	124	613	finally
    //   124	227	613	finally
    //   238	283	613	finally
    //   286	289	613	finally
    //   614	617	613	finally
  }
  
  public void updatePackage(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage != null) {
      if (this.mApp == null) {
        return;
      }
    }
    for (;;)
    {
      int i;
      synchronized (this.packageList)
      {
        i = this.packageList.size() - 1;
        if (i >= 0)
        {
          if ((this.packageList.get(i) == null) || (((ApolloActionPackage)this.packageList.get(i)).packageId != paramApolloActionPackage.packageId)) {
            break label127;
          }
          this.packageList.remove(i);
          this.packageList.add(i, paramApolloActionPackage);
        }
        ??? = this.mApp;
        if (??? == null) {
          return;
        }
        ((AppInterface)???).getEntityManagerFactory().createEntityManager().update(paramApolloActionPackage);
        return;
      }
      return;
      label127:
      i -= 1;
    }
  }
  
  /* Error */
  public void updatePreDownloadRes(ApolloPreDownloadData paramApolloPreDownloadData)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 137	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mPreDownloadMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   4: aload_1
    //   5: getfield 1092	com/tencent/mobileqq/apollo/model/ApolloPreDownloadData:resId	Ljava/lang/String;
    //   8: invokevirtual 1169	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11: pop
    //   12: aload_0
    //   13: getfield 137	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mPreDownloadMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   16: aload_1
    //   17: getfield 1092	com/tencent/mobileqq/apollo/model/ApolloPreDownloadData:resId	Ljava/lang/String;
    //   20: aload_1
    //   21: invokevirtual 470	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   24: pop
    //   25: aload_0
    //   26: getfield 196	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   29: invokevirtual 279	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   32: invokevirtual 285	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   35: astore_3
    //   36: aload_3
    //   37: invokevirtual 544	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   40: astore_2
    //   41: aload_2
    //   42: invokevirtual 549	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   45: aload_3
    //   46: aload_1
    //   47: invokevirtual 590	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   50: pop
    //   51: aload_2
    //   52: invokevirtual 571	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   55: aload_2
    //   56: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   59: return
    //   60: astore_1
    //   61: goto +17 -> 78
    //   64: astore_1
    //   65: ldc 12
    //   67: iconst_1
    //   68: ldc_w 1722
    //   71: aload_1
    //   72: invokestatic 432	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   75: goto -20 -> 55
    //   78: aload_2
    //   79: invokevirtual 576	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   82: goto +5 -> 87
    //   85: aload_1
    //   86: athrow
    //   87: goto -2 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	ApolloDaoManagerServiceImpl
    //   0	90	1	paramApolloPreDownloadData	ApolloPreDownloadData
    //   40	39	2	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   35	11	3	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   45	55	60	finally
    //   65	75	60	finally
    //   45	55	64	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */