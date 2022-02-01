package com.tencent.mobileqq.apollo.api.data.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPackageData;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPush;
import com.tencent.mobileqq.apollo.api.model.ApolloActionRecentData;
import com.tencent.mobileqq.apollo.api.model.ApolloBattleGameInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloFavActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.api.model.ApolloGameRankData;
import com.tencent.mobileqq.apollo.api.model.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.api.model.ApolloGameRoamData;
import com.tencent.mobileqq.apollo.api.model.ApolloGameScoreData;
import com.tencent.mobileqq.apollo.api.model.ApolloKapuEntranceTips;
import com.tencent.mobileqq.apollo.api.model.ApolloObtainedActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.api.model.ApolloRecommendAction;
import com.tencent.mobileqq.apollo.api.model.ApolloWhiteFaceID;
import com.tencent.mobileqq.apollo.api.player.action.CMSCommonAction;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloTagActionViewBinder.IApolloTagActionDataListener;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloTagActionViewBinder.IApolloTagDataListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ApolloActionTag;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloDaoManagerServiceImpl
  implements IApolloDaoManagerService, Manager
{
  public static final String TAG = "ApolloDaoManager";
  public List<ApolloActionData> actionList = Collections.synchronizedList(new ArrayList());
  public List<ApolloActionPackageData> actionPackageList = Collections.synchronizedList(new ArrayList());
  public List<ApolloActionPush> actionPushList = Collections.synchronizedList(new ArrayList());
  public List<ApolloFavActionData> favActionList = Collections.synchronizedList(new ArrayList());
  public List<ApolloGameData> gameList = Collections.synchronizedList(new ArrayList());
  public List<ApolloGameRoamData> gameRoamList = Collections.synchronizedList(new ArrayList());
  public List<ApolloObtainedActionData> mActionObtainedList = Collections.synchronizedList(new ArrayList());
  public List<ApolloActionTag> mActionTagList = Collections.synchronizedList(new ArrayList());
  private List<AioPushData> mAioPushDataList = Collections.synchronizedList(new ArrayList());
  private ConcurrentHashMap<Integer, String> mApolloGameVer = new ConcurrentHashMap();
  public AppInterface mApp;
  public final List<ApolloBattleGameInfo> mBattleGameList = Collections.synchronizedList(new ArrayList());
  private List<CMSCommonAction> mCMSCommonActionList = Collections.synchronizedList(new ArrayList());
  public List<ApolloGameRedDot> mGameRedDotList = Collections.synchronizedList(new ArrayList());
  private final Object mGameRedDotLock = new Object();
  private List<ApolloKapuEntranceTips> mInstalledKapuTipsList = Collections.synchronizedList(new ArrayList());
  public boolean mIsGameTabNotReady = false;
  private boolean mIsReqUserGameList = false;
  private ConcurrentHashMap<String, Integer> mKeywordsActionMap = new ConcurrentHashMap();
  public ConcurrentHashMap<Integer, ApolloActionData> mLimitFreeActionMap = new ConcurrentHashMap();
  private volatile int mMaxKeywordsLength = 1;
  private List<ApolloKapuEntranceTips> mNotInstalledKapuTipsList = Collections.synchronizedList(new ArrayList());
  public ConcurrentHashMap<Integer, ApolloActionData> mObtainedActiveActionMap = new ConcurrentHashMap();
  public ConcurrentHashMap<String, ApolloPreDownloadData> mPreDownloadMap = new ConcurrentHashMap();
  public List<ApolloGameRankData> mRankData = Collections.synchronizedList(new ArrayList());
  private Runnable mReadApolloActionListRunable = new ApolloDaoManagerServiceImpl.1(this);
  public List<ApolloRecommendAction> mRecommendActionList = Collections.synchronizedList(new ArrayList());
  public List<ApolloGameScoreData> mScoreData = Collections.synchronizedList(new ArrayList());
  private boolean mShouldCheckAction = true;
  public ConcurrentHashMap<Integer, ApolloGameRoamData> mTabGameRoamMap = new ConcurrentHashMap();
  public ConcurrentHashMap<Integer, ApolloWhiteFaceID> mWhiteFaceIdMapping = new ConcurrentHashMap();
  public List<ApolloActionPackage> packageList = Collections.synchronizedList(new ArrayList());
  
  private void addApolloGameRoamDataListFirst(List<ApolloGameRoamData> paramList1, List<ApolloGameRoamData> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      return;
    }
    Object localObject = paramList1.iterator();
    int i = 0;
    int j;
    if ((!((Iterator)localObject).hasNext()) || (TextUtils.isEmpty(((ApolloGameRoamData)((Iterator)localObject).next()).tagUrl)))
    {
      j = 0;
      label51:
      if (j >= paramList2.size()) {
        break label123;
      }
      localObject = (ApolloGameRoamData)paramList2.get(j);
      if (!TextUtils.isEmpty(((ApolloGameRoamData)localObject).tagUrl)) {
        break label111;
      }
      paramList1.add(i, localObject);
    }
    for (;;)
    {
      j += 1;
      break label51;
      i += 1;
      break;
      label111:
      paramList1.add(0, localObject);
    }
    label123:
    paramList1.addAll(i, paramList2);
  }
  
  public static List<ApolloActionRecentData> getRencentData(QQAppInterface paramQQAppInterface, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramQQAppInterface == null) {
      return localArrayList;
    }
    String str = paramQQAppInterface.getCurrentUin();
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = paramQQAppInterface.query(ApolloActionRecentData.class, false, "uin=? and sessionType=?", new String[] { str, paramString }, null, null, null, null);; paramQQAppInterface = localArrayList) {
      return paramQQAppInterface;
    }
  }
  
  public static void insertAndDeleteData(QQAppInterface paramQQAppInterface, ApolloActionRecentData paramApolloActionRecentData1, ApolloActionRecentData paramApolloActionRecentData2)
  {
    if ((paramQQAppInterface == null) || (paramApolloActionRecentData1 == null) || (paramApolloActionRecentData2 == null)) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.remove(paramApolloActionRecentData2);
    paramQQAppInterface.persist(paramApolloActionRecentData1);
  }
  
  public static void insertRencentData(QQAppInterface paramQQAppInterface, ApolloActionRecentData paramApolloActionRecentData)
  {
    if ((paramQQAppInterface == null) || (paramApolloActionRecentData == null)) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.persist(paramApolloActionRecentData);
  }
  
  private void makesureGameFirst(List<ApolloActionPackage> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      break label13;
    }
    label13:
    while ((paramList.get(0) == null) || (((ApolloActionPackage)paramList.get(0)).packageId == 100)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "[makesureGameFirst]");
    }
    Iterator localIterator = paramList.iterator();
    int i = -1;
    ApolloActionPackage localApolloActionPackage;
    while (localIterator.hasNext())
    {
      localApolloActionPackage = (ApolloActionPackage)localIterator.next();
      int j = i + 1;
      i = j;
      if (localApolloActionPackage.packageId == 100) {
        i = j;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDaoManager", 2, "index:" + i);
      }
      if ((i <= 0) || (localApolloActionPackage == null)) {
        break;
      }
      paramList.remove(i);
      paramList.add(0, localApolloActionPackage);
      return;
      localApolloActionPackage = null;
    }
  }
  
  private void removeInvalidAioPushData()
  {
    if (this.mAioPushDataList != null)
    {
      Iterator localIterator;
      synchronized (this.mAioPushDataList)
      {
        int i = (int)(System.currentTimeMillis() / 1000L);
        ArrayList localArrayList = new ArrayList();
        localIterator = this.mAioPushDataList.iterator();
        while (localIterator.hasNext())
        {
          AioPushData localAioPushData = (AioPushData)localIterator.next();
          if ((localAioPushData != null) && ((localAioPushData.endTs <= i) || (localAioPushData.begTs >= localAioPushData.endTs))) {
            localArrayList.add(localAioPushData);
          }
        }
      }
      if (localCollection.size() > 0)
      {
        localIterator = localCollection.iterator();
        while (localIterator.hasNext()) {
          realDelAioPushData((AioPushData)localIterator.next());
        }
        this.mAioPushDataList.removeAll(localCollection);
      }
    }
  }
  
  private void saveActionKeywordsMap(ApolloActionData paramApolloActionData)
  {
    Object localObject = paramApolloActionData.keywords;
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return;
      if (paramApolloActionData.verifyVersion("8.5.5"))
      {
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
    }
  }
  
  /* Error */
  private void saveApolloObtainedActionList(List<ApolloObtainedActionData> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +19 -> 20
    //   4: aload_1
    //   5: invokeinterface 203 1 0
    //   10: ifeq +10 -> 20
    //   13: aload_0
    //   14: getfield 362	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: aload_0
    //   22: getfield 362	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   25: invokevirtual 367	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   28: invokevirtual 370	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   31: astore_3
    //   32: aload_3
    //   33: ifnull +146 -> 179
    //   36: aload_3
    //   37: invokevirtual 374	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   40: astore_2
    //   41: aload_2
    //   42: invokevirtual 379	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   45: new 280	java/lang/StringBuilder
    //   48: dup
    //   49: sipush 500
    //   52: invokespecial 382	java/lang/StringBuilder:<init>	(I)V
    //   55: astore 4
    //   57: aload 4
    //   59: ldc_w 384
    //   62: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_1
    //   67: invokeinterface 178 1 0
    //   72: astore 5
    //   74: aload 5
    //   76: invokeinterface 184 1 0
    //   81: ifeq +163 -> 244
    //   84: aload 5
    //   86: invokeinterface 188 1 0
    //   91: checkcast 386	com/tencent/mobileqq/apollo/api/model/ApolloObtainedActionData
    //   94: astore 6
    //   96: aload_0
    //   97: aload_3
    //   98: aload 6
    //   100: invokevirtual 390	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   103: pop
    //   104: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq -33 -> 74
    //   110: aload 4
    //   112: ldc_w 392
    //   115: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload 6
    //   120: getfield 395	com/tencent/mobileqq/apollo/api/model/ApolloObtainedActionData:id	I
    //   123: invokevirtual 290	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 4
    //   129: invokevirtual 396	java/lang/StringBuilder:length	()I
    //   132: sipush 500
    //   135: if_icmplt -61 -> 74
    //   138: ldc 12
    //   140: iconst_2
    //   141: aload 4
    //   143: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aload 4
    //   151: iconst_0
    //   152: aload 4
    //   154: invokevirtual 396	java/lang/StringBuilder:length	()I
    //   157: invokevirtual 400	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: goto -87 -> 74
    //   164: astore_3
    //   165: ldc 12
    //   167: iconst_2
    //   168: ldc_w 402
    //   171: aload_3
    //   172: invokestatic 406	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   175: aload_2
    //   176: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   179: aload_0
    //   180: getfield 110	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mActionObtainedList	Ljava/util/List;
    //   183: ifnull +32 -> 215
    //   186: aload_0
    //   187: getfield 110	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mActionObtainedList	Ljava/util/List;
    //   190: astore_2
    //   191: aload_2
    //   192: monitorenter
    //   193: aload_0
    //   194: getfield 110	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mActionObtainedList	Ljava/util/List;
    //   197: invokeinterface 412 1 0
    //   202: aload_0
    //   203: getfield 110	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mActionObtainedList	Ljava/util/List;
    //   206: aload_1
    //   207: invokeinterface 414 2 0
    //   212: pop
    //   213: aload_2
    //   214: monitorexit
    //   215: aload_0
    //   216: getfield 114	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mLimitFreeActionMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   219: ifnull +10 -> 229
    //   222: aload_0
    //   223: getfield 114	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mLimitFreeActionMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   226: invokevirtual 415	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   229: aload_0
    //   230: getfield 112	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mObtainedActiveActionMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   233: ifnull -213 -> 20
    //   236: aload_0
    //   237: getfield 112	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mObtainedActiveActionMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   240: invokevirtual 415	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   243: return
    //   244: aload 4
    //   246: invokevirtual 396	java/lang/StringBuilder:length	()I
    //   249: sipush 500
    //   252: if_icmpge +34 -> 286
    //   255: aload 4
    //   257: invokevirtual 396	java/lang/StringBuilder:length	()I
    //   260: ifle +26 -> 286
    //   263: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   266: ifeq +20 -> 286
    //   269: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +14 -> 286
    //   275: ldc 12
    //   277: iconst_2
    //   278: aload 4
    //   280: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: aload_2
    //   287: invokevirtual 418	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   290: aload_2
    //   291: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   294: goto -115 -> 179
    //   297: astore_1
    //   298: aload_2
    //   299: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   302: aload_1
    //   303: athrow
    //   304: astore_1
    //   305: aload_2
    //   306: monitorexit
    //   307: aload_1
    //   308: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	ApolloDaoManagerServiceImpl
    //   0	309	1	paramList	List<ApolloObtainedActionData>
    //   31	67	3	localEntityManager	EntityManager
    //   164	8	3	localException	Exception
    //   55	224	4	localStringBuilder	StringBuilder
    //   72	13	5	localIterator	Iterator
    //   94	25	6	localApolloObtainedActionData	ApolloObtainedActionData
    // Exception table:
    //   from	to	target	type
    //   45	74	164	java/lang/Exception
    //   74	161	164	java/lang/Exception
    //   244	286	164	java/lang/Exception
    //   286	290	164	java/lang/Exception
    //   45	74	297	finally
    //   74	161	297	finally
    //   165	175	297	finally
    //   244	286	297	finally
    //   286	290	297	finally
    //   193	215	304	finally
    //   305	307	304	finally
  }
  
  public void bulkSaveOrUpdateApolloActionData(List<ApolloActionData> paramList)
  {
    if ((this.mApp == null) || (paramList == null)) {
      return;
    }
    if ((this.actionList != null) && (paramList != null)) {}
    for (;;)
    {
      int i;
      int j;
      EntityManager localEntityManager;
      synchronized (this.actionList)
      {
        i = this.actionList.size() - 1;
        if (i >= 0)
        {
          j = paramList.size() - 1;
          if (j <= 0) {
            break label230;
          }
          if (((ApolloActionData)paramList.get(j)).actionId != ((ApolloActionData)this.actionList.get(i)).actionId) {
            break label223;
          }
          this.actionList.remove(i);
          this.actionList.add(i, paramList.get(j));
          break label223;
        }
        localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
        ??? = localEntityManager.getTransaction();
      }
      try
      {
        ((EntityTransaction)???).begin();
        i = 0;
        while (i < paramList.size())
        {
          updateEntity(localEntityManager, (Entity)paramList.get(i));
          i += 1;
          continue;
          paramList = finally;
          throw paramList;
        }
        ((EntityTransaction)???).commit();
        return;
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        return;
      }
      finally
      {
        ((EntityTransaction)???).end();
      }
      label223:
      j -= 1;
      continue;
      label230:
      i -= 1;
    }
  }
  
  public void changeActionStatus(ApolloActionData paramApolloActionData)
  {
    if ((paramApolloActionData == null) || (this.mApp == null)) {}
    for (;;)
    {
      return;
      if (this.actionList != null) {}
      synchronized (this.actionList)
      {
        int i = this.actionList.size() - 1;
        if (i >= 0)
        {
          if ((this.actionList != null) && (this.actionList.get(i) != null) && (((ApolloActionData)this.actionList.get(i)).actionId == paramApolloActionData.actionId))
          {
            this.actionList.remove(i);
            this.actionList.add(i, paramApolloActionData);
          }
        }
        else
        {
          ??? = this.mApp.getEntityManagerFactory().createEntityManager();
          if (??? == null) {
            continue;
          }
          ((EntityManager)???).update(paramApolloActionData);
          return;
        }
        i -= 1;
      }
    }
  }
  
  public void delFavAction(ApolloFavActionData paramApolloFavActionData)
  {
    if (paramApolloFavActionData == null) {}
    for (;;)
    {
      return;
      if (this.favActionList != null) {}
      synchronized (this.favActionList)
      {
        int i = this.favActionList.size() - 1;
        if (i >= 0)
        {
          if (((ApolloFavActionData)this.favActionList.get(i)).favId == paramApolloFavActionData.favId) {
            this.favActionList.remove(i);
          }
        }
        else
        {
          if (this.mApp == null) {
            continue;
          }
          ??? = this.mApp.getEntityManagerFactory().createEntityManager();
          if (??? == null) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "insert ApolloFavActionData id=" + paramApolloFavActionData.toString());
          }
          ((EntityManager)???).remove(paramApolloFavActionData);
          return;
        }
        i -= 1;
      }
    }
  }
  
  /* Error */
  public void delFavActionList(List<ApolloFavActionData> paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_1
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 95	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:favActionList	Ljava/util/List;
    //   12: ifnull +90 -> 102
    //   15: aload_0
    //   16: getfield 95	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:favActionList	Ljava/util/List;
    //   19: astore 5
    //   21: aload 5
    //   23: monitorenter
    //   24: iconst_0
    //   25: istore_2
    //   26: iload_2
    //   27: aload_1
    //   28: invokeinterface 203 1 0
    //   33: if_icmpge +66 -> 99
    //   36: aload_0
    //   37: getfield 95	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:favActionList	Ljava/util/List;
    //   40: invokeinterface 203 1 0
    //   45: iconst_1
    //   46: isub
    //   47: istore_3
    //   48: iload_3
    //   49: iflt +163 -> 212
    //   52: aload_0
    //   53: getfield 95	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:favActionList	Ljava/util/List;
    //   56: iload_3
    //   57: invokeinterface 207 2 0
    //   62: checkcast 434	com/tencent/mobileqq/apollo/api/model/ApolloFavActionData
    //   65: getfield 438	com/tencent/mobileqq/apollo/api/model/ApolloFavActionData:favId	J
    //   68: aload_1
    //   69: iload_2
    //   70: invokeinterface 207 2 0
    //   75: checkcast 434	com/tencent/mobileqq/apollo/api/model/ApolloFavActionData
    //   78: getfield 438	com/tencent/mobileqq/apollo/api/model/ApolloFavActionData:favId	J
    //   81: lcmp
    //   82: ifne +123 -> 205
    //   85: aload_0
    //   86: getfield 95	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:favActionList	Ljava/util/List;
    //   89: iload_3
    //   90: invokeinterface 295 2 0
    //   95: pop
    //   96: goto +109 -> 205
    //   99: aload 5
    //   101: monitorexit
    //   102: aload_0
    //   103: getfield 362	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   106: ifnull -99 -> 7
    //   109: aload_0
    //   110: getfield 362	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   113: invokevirtual 367	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   116: invokevirtual 370	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   119: astore 6
    //   121: aload 6
    //   123: invokevirtual 374	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   126: astore 5
    //   128: aload 5
    //   130: invokevirtual 379	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   133: iload 4
    //   135: istore_2
    //   136: iload_2
    //   137: aload_1
    //   138: invokeinterface 203 1 0
    //   143: if_icmpge +32 -> 175
    //   146: aload 6
    //   148: aload_1
    //   149: iload_2
    //   150: invokeinterface 207 2 0
    //   155: checkcast 422	com/tencent/mobileqq/persistence/Entity
    //   158: invokevirtual 254	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   161: pop
    //   162: iload_2
    //   163: iconst_1
    //   164: iadd
    //   165: istore_2
    //   166: goto -30 -> 136
    //   169: astore_1
    //   170: aload 5
    //   172: monitorexit
    //   173: aload_1
    //   174: athrow
    //   175: aload 5
    //   177: invokevirtual 418	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   180: aload 5
    //   182: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   185: return
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 425	java/lang/Exception:printStackTrace	()V
    //   191: aload 5
    //   193: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   196: return
    //   197: astore_1
    //   198: aload 5
    //   200: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   203: aload_1
    //   204: athrow
    //   205: iload_3
    //   206: iconst_1
    //   207: isub
    //   208: istore_3
    //   209: goto -161 -> 48
    //   212: iload_2
    //   213: iconst_1
    //   214: iadd
    //   215: istore_2
    //   216: goto -190 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	ApolloDaoManagerServiceImpl
    //   0	219	1	paramList	List<ApolloFavActionData>
    //   25	191	2	i	int
    //   47	162	3	j	int
    //   1	133	4	k	int
    //   19	180	5	localObject	Object
    //   119	28	6	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   26	48	169	finally
    //   52	96	169	finally
    //   99	102	169	finally
    //   170	173	169	finally
    //   128	133	186	java/lang/Exception
    //   136	162	186	java/lang/Exception
    //   175	180	186	java/lang/Exception
    //   128	133	197	finally
    //   136	162	197	finally
    //   175	180	197	finally
    //   187	191	197	finally
  }
  
  public ApolloActionData findActionById(int paramInt)
  {
    Object localObject1 = null;
    if (this.mApp == null) {}
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        localObject2 = findActionInCache(paramInt);
        if (localObject2 != null) {
          return localObject2;
        }
        localObject2 = this.mApp.getEntityManagerFactory().createEntityManager();
      } while (localObject2 == null);
      localObject2 = (ApolloActionData)((EntityManager)localObject2).find(ApolloActionData.class, paramInt + "");
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloDaoManager", 2, new Object[] { "findActionById from db:", Integer.valueOf(paramInt) });
    return localObject2;
  }
  
  public ApolloActionData findActionInCache(int paramInt)
  {
    if (this.mApp == null) {
      return null;
    }
    if ((this.actionList != null) && (this.actionList.size() > 0)) {
      for (;;)
      {
        int i;
        synchronized (this.actionList)
        {
          i = this.actionList.size() - 1;
          if (i < 0) {
            break;
          }
          ApolloActionData localApolloActionData = (ApolloActionData)this.actionList.get(i);
          if ((localApolloActionData != null) && (localApolloActionData.actionId == paramInt)) {
            return localApolloActionData;
          }
        }
        i -= 1;
      }
    }
    for (;;)
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.e("ApolloDaoManager", 2, new Object[] { "[findActionInCache] actionList no action:", Integer.valueOf(paramInt) });
      }
    }
  }
  
  public ApolloFavActionData findFavActionById(long paramLong)
  {
    Object localObject4 = null;
    List localList;
    int i;
    if (this.favActionList != null)
    {
      localList = this.favActionList;
      i = 0;
    }
    for (;;)
    {
      Object localObject1 = localObject4;
      try
      {
        if (i < this.favActionList.size())
        {
          if (((ApolloFavActionData)this.favActionList.get(i)).favId != paramLong) {
            break label169;
          }
          localObject1 = (ApolloFavActionData)this.favActionList.get(i);
        }
        return localObject1;
      }
      finally {}
      if (this.mApp != null)
      {
        Object localObject3 = this.mApp.getEntityManagerFactory().createEntityManager();
        if (localObject3 != null) {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "find ApolloFavActionData favid=" + paramLong);
          }
        }
        for (localObject3 = (ApolloFavActionData)((EntityManager)localObject3).find(ApolloFavActionData.class, paramLong);; localObject3 = null) {
          return localObject3;
        }
      }
      return null;
      label169:
      i += 1;
    }
  }
  
  public ApolloGameData findGameById(int paramInt)
  {
    Object localObject1;
    if (paramInt <= 0) {
      localObject1 = null;
    }
    ApolloGameData localApolloGameData2;
    do
    {
      return localObject1;
      if (this.gameList != null)
      {
        localObject1 = this.gameList;
        int i = 0;
        for (;;)
        {
          try
          {
            if (i >= this.gameList.size()) {
              break;
            }
            if (((ApolloGameData)this.gameList.get(i)).gameId == paramInt)
            {
              ApolloGameData localApolloGameData1 = (ApolloGameData)this.gameList.get(i);
              return localApolloGameData1;
            }
          }
          finally {}
          i += 1;
        }
      }
      if (this.mApp == null) {
        return null;
      }
      localObject1 = this.mApp.getEntityManagerFactory().createEntityManager();
      if (localObject1 == null) {
        break;
      }
      localApolloGameData2 = (ApolloGameData)((EntityManager)localObject1).find(ApolloGameData.class, paramInt + "");
      localObject1 = localApolloGameData2;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloDaoManager", 2, "findGameById from db");
    return localApolloGameData2;
    return null;
  }
  
  public ApolloGameData findGameInCacheById(int paramInt)
  {
    if (paramInt <= 0) {
      return null;
    }
    List localList;
    if (this.gameList != null)
    {
      localList = this.gameList;
      int i = 0;
      for (;;)
      {
        try
        {
          if (i >= this.gameList.size()) {
            break;
          }
          if (((ApolloGameData)this.gameList.get(i)).gameId == paramInt)
          {
            ApolloGameData localApolloGameData = (ApolloGameData)this.gameList.get(i);
            return localApolloGameData;
          }
        }
        finally {}
        i += 1;
      }
    }
    return null;
  }
  
  public ApolloActionPackage findPackageById(int paramInt)
  {
    if (this.mApp == null) {
      return null;
    }
    if (this.packageList != null) {
      for (;;)
      {
        int i;
        synchronized (this.packageList)
        {
          i = this.packageList.size() - 1;
          if (i < 0) {
            break;
          }
          if (((ApolloActionPackage)this.packageList.get(i)).packageId == paramInt)
          {
            ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)this.packageList.get(i);
            return localApolloActionPackage;
          }
        }
        i -= 1;
      }
    }
    ??? = this.mApp.getEntityManagerFactory().createEntityManager();
    if (??? != null) {
      return (ApolloActionPackage)((EntityManager)???).find(ApolloActionPackage.class, paramInt + "");
    }
    return null;
  }
  
  public List<ApolloActionData> getActionByPackageId(int paramInt)
  {
    ??? = null;
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    int i;
    if ((this.actionPackageList != null) && (this.actionPackageList.size() > 0))
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
            break label461;
          }
          localArrayList1.add(this.actionPackageList.get(i));
          break label461;
        }
        if (localArrayList1 == null) {
          break label455;
        }
        paramInt = 0;
        i = 1;
        if (paramInt >= localArrayList1.size()) {
          break label397;
        }
        ??? = findActionById(((ApolloActionPackageData)localArrayList1.get(paramInt)).acitonId);
        if (??? == null) {
          break label296;
        }
        localArrayList2.add(???);
        paramInt += 1;
        continue;
        if (this.mApp != null) {
          break label180;
        }
      }
      finally {}
      return null;
      label180:
      Object localObject5 = this.mApp.getEntityManagerFactory().createEntityManager();
      if (localObject5 != null)
      {
        localObject5 = ((EntityManager)localObject5).query(ApolloActionPackageData.class, false, "packageId=?", new String[] { paramInt + "" }, null, null, null, null);
        if (QLog.isColorLevel()) {
          if (localObject5 != null) {
            break label282;
          }
        }
        label282:
        for (Object localObject2 = ???;; localObject2 = Integer.valueOf(((List)localObject5).size()))
        {
          QLog.d("ApolloDaoManager", 2, new Object[] { "getActionByPackageId from db, size:", localObject2 });
          localObject2 = localObject5;
          break;
        }
        label296:
        if ((this.actionPackageList != null) && (this.actionPackageList.size() > 0))
        {
          synchronized (this.actionPackageList)
          {
            this.actionPackageList.remove(((List)localObject2).get(paramInt));
            if (QLog.isColorLevel()) {
              QLog.d("ApolloDaoManager", 2, "remove paciton id=" + ((ApolloActionPackageData)((List)localObject2).get(paramInt)).acitonId);
            }
          }
          if (i == 0)
          {
            QLog.e("ApolloDaoManager", 1, "[getActionByPackageId] has some action not exit and check action json");
            if ((this.mApp != null) && (this.mShouldCheckAction))
            {
              this.mShouldCheckAction = false;
              ((IApolloManagerService)this.mApp.getRuntimeService(IApolloManagerService.class, "all")).checkApolloPanelJsonCfg(false, "getActionByPackageId action not exit", 1);
            }
          }
          label455:
          return localArrayList2;
        }
      }
      else
      {
        label397:
        continue;
        label461:
        i += 1;
        continue;
      }
      i = 0;
    }
  }
  
  public void getActionIdListByPkgIdAndTagName(int paramInt, String paramString, ApolloTagActionViewBinder.IApolloTagActionDataListener paramIApolloTagActionDataListener)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.mActionTagList == null) || (this.mActionTagList.size() < 1))
    {
      ??? = this.mApp.getEntityManagerFactory().createEntityManager();
      if (??? == null)
      {
        paramIApolloTagActionDataListener.a();
        return;
      }
      this.mActionTagList = ((EntityManager)???).query(ApolloActionTag.class);
      if (QLog.isColorLevel()) {
        if (this.mActionTagList != null) {
          break label209;
        }
      }
    }
    label209:
    for (??? = null;; ??? = Integer.valueOf(this.mActionTagList.size()))
    {
      QLog.d("ApolloDaoManager", 2, new Object[] { "[getActionTagList] db list size:", ??? });
      if ((this.mActionTagList == null) || (this.mActionTagList.size() <= 0)) {
        break label238;
      }
      synchronized (this.mActionTagList)
      {
        Iterator localIterator = this.mActionTagList.iterator();
        ApolloActionTag localApolloActionTag;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localApolloActionTag = (ApolloActionTag)localIterator.next();
        } while ((localApolloActionTag.packageId != paramInt) || (!paramString.equals(localApolloActionTag.tagName)));
        localArrayList.add(Integer.valueOf(localApolloActionTag.actionId));
      }
    }
    paramIApolloTagActionDataListener.a(localArrayList);
    return;
    label238:
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "ActionTagList is null");
    }
    paramIApolloTagActionDataListener.a();
  }
  
  public ApolloActionData getActionInfoById(int paramInt)
  {
    if (this.mApp == null) {}
    for (;;)
    {
      return null;
      if ((this.actionList != null) && (this.actionList.size() > 0)) {}
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
        ??? = this.mApp.getEntityManagerFactory().createEntityManager();
        if (??? == null) {
          continue;
        }
        ??? = ((EntityManager)???).query(ApolloActionData.class, false, "actionId=?", new String[] { String.valueOf(paramInt) }, null, null, null, null);
        if ((??? == null) || (((List)???).size() <= 0)) {
          continue;
        }
        return (ApolloActionData)((List)???).get(0);
      }
    }
  }
  
  public ApolloActionData getActionInfoByIdFromCache(int paramInt)
  {
    if (this.mApp == null) {
      return null;
    }
    if ((this.actionList != null) && (this.actionList.size() > 0)) {
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
    return null;
  }
  
  public HashMap<String, Integer> getActionKeywordsMap()
  {
    HashMap localHashMap = new HashMap();
    if (this.mKeywordsActionMap != null) {
      localHashMap.putAll(this.mKeywordsActionMap);
    }
    return localHashMap;
  }
  
  public List<ApolloActionData> getActionList()
  {
    Integer localInteger = null;
    if (this.mApp == null) {}
    do
    {
      return null;
      if ((this.actionList != null) && (this.actionList.size() > 0)) {
        return this.actionList;
      }
      localObject = this.mApp.getEntityManagerFactory().createEntityManager();
    } while (localObject == null);
    Object localObject = ((EntityManager)localObject).query(ApolloActionData.class);
    if (QLog.isColorLevel()) {
      if (localObject != null) {
        break label90;
      }
    }
    for (;;)
    {
      QLog.d("ApolloDaoManager", 2, new Object[] { "[getActionList] db list size:", localInteger });
      return localObject;
      label90:
      localInteger = Integer.valueOf(((List)localObject).size());
    }
  }
  
  public int getActionPkgId(int paramInt)
  {
    if (this.actionPackageList != null) {
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
      }
    }
    return -1;
  }
  
  public List<ApolloActionPush> getActionPushData()
  {
    ArrayList localArrayList = null;
    if ((this.actionPushList != null) && (this.actionPushList.size() > 0)) {
      synchronized (this.actionPushList)
      {
        localArrayList = new ArrayList(this.actionPushList.size());
        localArrayList.addAll(this.actionPushList);
        return localArrayList;
      }
    }
    ??? = localObject2;
    if (this.mApp != null)
    {
      EntityManager localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
      ??? = localObject2;
      if (localEntityManager != null)
      {
        List localList = localEntityManager.query(ApolloActionPush.class);
        ??? = localList;
        if (this.actionPushList != null)
        {
          ??? = localList;
          if (localList != null)
          {
            ??? = localList;
            if (localList.size() > 0) {
              synchronized (this.actionPushList)
              {
                this.actionPushList.addAll(localList);
                return localList;
              }
            }
          }
        }
      }
    }
    return ???;
  }
  
  public ApolloActionPush getActionPushDataByAIO(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return null;
    }
    Object localObject = getActionPushData();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return null;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ApolloActionPush localApolloActionPush = (ApolloActionPush)((Iterator)localObject).next();
      if ((localApolloActionPush != null) && (localApolloActionPush.mAioType == paramSessionInfo.jdField_a_of_type_Int) && (!TextUtils.isEmpty(paramSessionInfo.jdField_a_of_type_JavaLangString)) && (paramSessionInfo.jdField_a_of_type_JavaLangString.equals(localApolloActionPush.mSessionId + ""))) {
        return localApolloActionPush;
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
      if (localIterator.hasNext()) {
        localArrayList.add((ApolloActionTag)localIterator.next());
      }
    }
    return localList1;
  }
  
  public AioPushData getAioPushData(String paramString, int paramInt)
  {
    Object localObject1 = null;
    if ((!TextUtils.isEmpty(paramString)) && (paramInt > 0) && (this.mAioPushDataList != null))
    {
      Object localObject2;
      synchronized (this.mAioPushDataList)
      {
        int i = (int)(System.currentTimeMillis() / 1000L);
        Iterator localIterator = this.mAioPushDataList.iterator();
        if (localIterator.hasNext())
        {
          AioPushData localAioPushData = (AioPushData)localIterator.next();
          if ((localAioPushData == null) || (!localAioPushData.them.equals(paramString)) || (paramInt != localAioPushData.busId) || (localAioPushData.isShow) || (localAioPushData.endTs <= i)) {
            break label166;
          }
          if (localObject1 == null)
          {
            localObject2 = localAioPushData;
          }
          else
          {
            localObject2 = localAioPushData;
            if (localAioPushData.begTs <= ((AioPushData)localObject1).begTs) {
              break label166;
            }
          }
        }
        else
        {
          return localObject1;
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        break;
        label166:
        localObject2 = localObject1;
      }
    }
    return null;
  }
  
  public ConcurrentHashMap<Integer, String> getApolloGameVer()
  {
    return this.mApolloGameVer;
  }
  
  public List<ApolloBattleGameInfo> getBattleGameList(int paramInt)
  {
    if (this.mApp == null) {}
    do
    {
      return null;
      Object localObject2 = this.mBattleGameList;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
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
        }
        return localList1;
      }
      ??? = this.mApp.getEntityManagerFactory().createEntityManager();
    } while (??? == null);
    List localList = ((EntityManager)???).query(ApolloBattleGameInfo.class);
    if (localList != null) {
      for (;;)
      {
        int i;
        synchronized (this.mBattleGameList)
        {
          i = this.mBattleGameList.size() - 1;
          if (i >= 0)
          {
            if (((ApolloBattleGameInfo)this.mBattleGameList.get(i)).sceneId == paramInt) {
              this.mBattleGameList.remove(i);
            }
          }
          else {
            this.mBattleGameList.addAll(localList);
          }
        }
        i -= 1;
      }
    }
    return localList2;
  }
  
  public List<ApolloActionData> getFavActionList()
  {
    ArrayList localArrayList = new ArrayList();
    List localList;
    int i;
    if (this.favActionList != null)
    {
      localList = this.favActionList;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.favActionList.size())
        {
          ApolloActionData localApolloActionData = findActionById(((ApolloFavActionData)this.favActionList.get(i)).acitonId);
          if (localApolloActionData == null) {
            break label102;
          }
          localArrayList.add(localApolloActionData);
          break label102;
        }
        return localArrayList;
      }
      finally {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloDaoManager", 2, "favActionList is null");
      return localList1;
      label102:
      i += 1;
    }
    return localList1;
  }
  
  public List<ApolloActionData> getFavNeedDownloadAction()
  {
    label122:
    for (;;)
    {
      try
      {
        Object localObject1 = this.mApp;
        if (localObject1 == null)
        {
          localObject1 = null;
          return localObject1;
        }
        List localList = (List)getFavPanelActionPairInfo().second;
        int i;
        if ((localList != null) && (localList.size() > 0))
        {
          localObject1 = new ArrayList();
          i = 0;
          if (i < localList.size())
          {
            if (((ApolloActionData)localList.get(i)).status != 0) {
              break label122;
            }
            ((List)localObject1).add(localList.get(i));
            break label122;
          }
          if (localObject1 != null)
          {
            i = ((List)localObject1).size();
            if (i > 0) {
              continue;
            }
          }
        }
        localObject1 = null;
        continue;
        i += 1;
      }
      finally {}
    }
  }
  
  public List<ApolloFavActionData> getFavPackageActionList()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (this.favActionList != null) {
      localObject = this.favActionList;
    }
    EntityManager localEntityManager;
    do
    {
      do
      {
        return localObject;
        localObject = localArrayList;
      } while (this.mApp == null);
      localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
      localObject = localArrayList;
    } while (localEntityManager == null);
    return localEntityManager.query(ApolloFavActionData.class);
  }
  
  public Pair<List<ApolloFavActionData>, List<ApolloActionData>> getFavPanelActionPairInfo()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "getFavPanelActionPairInfo");
    }
    List localList = getFavPackageActionList();
    Collections.sort(localList, new ApolloDaoManagerServiceImpl.2(this));
    ArrayList localArrayList = new ArrayList(localList.size());
    int k = localList.size();
    int j = 0;
    int i = 1;
    if (j < k)
    {
      Object localObject = (ApolloFavActionData)localList.get(j);
      if (localObject == null) {
        break label193;
      }
      localObject = findActionById(((ApolloFavActionData)localObject).acitonId);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    label193:
    for (;;)
    {
      j += 1;
      break;
      i = 0;
      continue;
      if (i == 0)
      {
        QLog.e("ApolloDaoManager", 1, "[getFavPanelActionPairInfo] has some action not exit and check action json");
        if ((this.mApp != null) && (this.mShouldCheckAction))
        {
          this.mShouldCheckAction = false;
          ((IApolloManagerService)this.mApp.getRuntimeService(IApolloManagerService.class, "all")).checkApolloPanelJsonCfg(false, "getFavPanelActionPairInfo action not exit", 1);
        }
      }
      return new Pair(localList, localArrayList);
    }
  }
  
  public List<ApolloGameScoreData> getFriendScoreDataByUin(String arg1, String paramString2, int paramInt, List<ApolloGameData> paramList)
  {
    Object localObject1 = getScoreDataByUin(???, paramInt, paramList);
    paramList = new ArrayList();
    if ((localObject1 != null) && (this.mScoreData != null)) {}
    for (;;)
    {
      synchronized (this.mScoreData)
      {
        localObject1 = ((List)localObject1).iterator();
        i = paramInt;
        ApolloGameScoreData localApolloGameScoreData1;
        if (((Iterator)localObject1).hasNext())
        {
          localApolloGameScoreData1 = (ApolloGameScoreData)((Iterator)localObject1).next();
          if (i >= -1) {}
        }
        else
        {
          return paramList;
        }
        Object localObject2 = findGameById(localApolloGameScoreData1.mGameId);
        if ((localObject2 == null) || (((ApolloGameData)localObject2).isShow == 0)) {
          continue;
        }
        localObject2 = this.mScoreData.iterator();
        j = 0;
        paramInt = i;
        if (((Iterator)localObject2).hasNext())
        {
          ApolloGameScoreData localApolloGameScoreData2 = (ApolloGameScoreData)((Iterator)localObject2).next();
          if ((paramString2.equals(localApolloGameScoreData2.mUin)) && (localApolloGameScoreData1.mGameId == localApolloGameScoreData2.mGameId))
          {
            paramList.add(localApolloGameScoreData2);
            i = paramInt - 1;
            paramInt = 1;
            break label261;
          }
        }
        else
        {
          i = paramInt;
          if (j != 0) {
            continue;
          }
          localObject2 = new ApolloGameScoreData();
          ((ApolloGameScoreData)localObject2).mUin = paramString2;
          ((ApolloGameScoreData)localObject2).mGameId = localApolloGameScoreData1.mGameId;
          ((ApolloGameScoreData)localObject2).mFromDb = false;
          paramList.add(localObject2);
          i = paramInt - 1;
        }
      }
      int i = paramInt;
      paramInt = j;
      break label261;
      return paramList;
      label261:
      int j = paramInt;
      paramInt = i;
    }
  }
  
  public List<ApolloGameData> getGameList()
  {
    if (this.mApp == null) {}
    do
    {
      return null;
      if ((this.gameList != null) && (this.gameList.size() > 0)) {
        synchronized (this.gameList)
        {
          ArrayList localArrayList = new ArrayList(this.gameList.size());
          localArrayList.addAll(this.gameList);
          return localArrayList;
        }
      }
      ??? = this.mApp.getEntityManagerFactory().createEntityManager();
    } while (??? == null);
    return ((EntityManager)???).query(ApolloGameData.class);
  }
  
  public List<ApolloGameRoamData> getGameRoamData()
  {
    ??? = null;
    if (this.mApp == null) {}
    Object localObject3;
    do
    {
      do
      {
        do
        {
          return ???;
          if ((this.gameRoamList != null) && (this.gameRoamList.size() > 0)) {
            synchronized (this.gameRoamList)
            {
              ArrayList localArrayList = new ArrayList(this.gameRoamList.size());
              localArrayList.addAll(this.gameRoamList);
              return localArrayList;
            }
          }
          localObject3 = this.mApp.getEntityManagerFactory().createEntityManager();
        } while (localObject3 == null);
        localObject3 = ((EntityManager)localObject3).query(ApolloGameRoamData.class);
        ??? = localObject3;
      } while (this.gameRoamList == null);
      ??? = localObject3;
    } while (localObject3 == null);
    synchronized (this.gameRoamList)
    {
      this.gameRoamList.addAll((Collection)localObject3);
      return localObject3;
    }
  }
  
  public List<ApolloActionData> getHideActionList()
  {
    if (this.mApp == null) {
      return null;
    }
    if ((this.actionList != null) && (this.actionList.size() > 0)) {}
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
            break label171;
          }
          localArrayList.add(this.actionList.get(i));
          break label171;
        }
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          return localArrayList;
        }
        ??? = this.mApp.getEntityManagerFactory().createEntityManager();
        if (??? != null) {
          return ((EntityManager)???).query(ApolloActionData.class, false, "isShow=?", new String[] { String.valueOf(0) }, null, null, null, null);
        }
      }
      return new ArrayList();
      label171:
      i += 1;
    }
  }
  
  public ApolloKapuEntranceTips getKapuEntranceTips(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      int i;
      synchronized (this.mInstalledKapuTipsList)
      {
        if (this.mInstalledKapuTipsList.size() <= 0) {
          break label183;
        }
        i = this.mInstalledKapuTipsList.size() - 1;
        if (i < 0) {
          break label183;
        }
        ApolloKapuEntranceTips localApolloKapuEntranceTips1 = (ApolloKapuEntranceTips)this.mInstalledKapuTipsList.get(i);
        if (localApolloKapuEntranceTips1.isValid()) {
          return localApolloKapuEntranceTips1;
        }
        this.mInstalledKapuTipsList.remove(i);
        i -= 1;
      }
      for (;;)
      {
        synchronized (this.mNotInstalledKapuTipsList)
        {
          if (this.mNotInstalledKapuTipsList.size() <= 0) {
            break label178;
          }
          i = this.mNotInstalledKapuTipsList.size() - 1;
          if (i < 0) {
            break label178;
          }
          ApolloKapuEntranceTips localApolloKapuEntranceTips2 = (ApolloKapuEntranceTips)this.mNotInstalledKapuTipsList.get(i);
          if (localApolloKapuEntranceTips2.isValid()) {
            return localApolloKapuEntranceTips2;
          }
        }
        this.mNotInstalledKapuTipsList.remove(i);
        i -= 1;
        continue;
        label178:
        localObject3 = null;
      }
      label183:
      Object localObject3 = null;
    }
  }
  
  public ConcurrentHashMap<Integer, ApolloActionData> getLimitFreeActionMap()
  {
    if ((this.mLimitFreeActionMap != null) && (this.mLimitFreeActionMap.size() > 0)) {
      return this.mLimitFreeActionMap;
    }
    Object localObject = getObtainedActionListByType(6);
    if (this.mLimitFreeActionMap == null) {
      this.mLimitFreeActionMap = new ConcurrentHashMap();
    }
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
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
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
    if ((this.actionList != null) && (this.actionList.size() > 0)) {}
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
            break label179;
          }
          localArrayList.add(this.actionList.get(i));
          break label179;
        }
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          return localArrayList;
        }
        ??? = this.mApp.getEntityManagerFactory().createEntityManager();
        if (??? != null) {
          return ((EntityManager)???).query(ApolloActionData.class, false, "feeType!=?", new String[] { String.valueOf(paramInt) }, null, null, null, null);
        }
      }
      return new ArrayList();
      label179:
      i += 1;
    }
  }
  
  public List<ApolloObtainedActionData> getObtainedActionListByType(int paramInt)
  {
    if (this.mApp == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if ((this.mActionObtainedList != null) && (this.mActionObtainedList.size() > 0))
    {
      List localList = this.mActionObtainedList;
      int i = 0;
      for (;;)
      {
        try
        {
          if (i < this.mActionObtainedList.size())
          {
            if (((ApolloObtainedActionData)this.mActionObtainedList.get(i)).type != paramInt) {
              break label112;
            }
            localArrayList.add(this.mActionObtainedList.get(i));
          }
        }
        finally {}
        label112:
        i += 1;
      }
    }
    return localList1;
  }
  
  public ConcurrentHashMap<Integer, ApolloActionData> getObtainedActiveActionMap()
  {
    if ((this.mObtainedActiveActionMap != null) && (this.mObtainedActiveActionMap.size() > 0)) {
      return this.mObtainedActiveActionMap;
    }
    Object localObject = getObtainedActionListByType(0);
    if (this.mObtainedActiveActionMap == null) {
      this.mObtainedActiveActionMap = new ConcurrentHashMap();
    }
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
    ??? = null;
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    if ((this.actionPackageList != null) && (this.actionPackageList.size() > 0)) {}
    List localList;
    for (;;)
    {
      synchronized (this.actionPackageList)
      {
        if (i < this.actionPackageList.size())
        {
          if (((ApolloActionPackageData)this.actionPackageList.get(i)).packageId != paramInt) {
            break label257;
          }
          localArrayList.add(this.actionPackageList.get(i));
          break label257;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, new Object[] { "return getPackageActionDataById from cache, size:", Integer.valueOf(localArrayList.size()) });
        }
        return localArrayList;
      }
      if (this.mApp == null) {
        break;
      }
      EntityManager localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
      if (localEntityManager != null) {
        localList = localEntityManager.query(ApolloActionPackageData.class, false, "packageId=?", new String[] { paramInt + "" }, null, null, null, null);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          if (localList != null) {
            break label240;
          }
        }
        for (;;)
        {
          QLog.d("ApolloDaoManager", 2, new Object[] { "return getPackageActionDataById from db, size:", ??? });
          return localList;
          label240:
          ??? = Integer.valueOf(localList.size());
        }
      }
      label257:
      i += 1;
    }
    return localList;
  }
  
  public List<ApolloActionPackageData> getPackageDataByActionId(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.actionPackageList != null) && (this.actionPackageList.size() > 0))
    {
      List localList = this.actionPackageList;
      int i = 0;
      for (;;)
      {
        try
        {
          if (i < this.actionPackageList.size())
          {
            ApolloActionPackageData localApolloActionPackageData = (ApolloActionPackageData)this.actionPackageList.get(i);
            if (localApolloActionPackageData.acitonId == paramInt) {
              localArrayList.add(localApolloActionPackageData);
            }
          }
          else
          {
            return localArrayList;
          }
        }
        finally {}
        i += 1;
      }
    }
    return localList1;
  }
  
  public List<ApolloActionPackage> getPackageInfoBySession(int paramInt)
  {
    if (this.mApp == null) {}
    Object localObject2;
    do
    {
      return null;
      if (CmShowAioMatcher.a(paramInt, 1)) {
        localObject1 = String.valueOf(0);
      }
      while ((this.packageList != null) && (this.packageList.size() > 0))
      {
        localObject2 = new ArrayList();
        paramInt = 0;
        for (;;)
        {
          if (paramInt < this.packageList.size())
          {
            if ((((ApolloActionPackage)this.packageList.get(paramInt)).sessionType == Integer.parseInt((String)localObject1)) || (((ApolloActionPackage)this.packageList.get(paramInt)).sessionType == 0)) {
              ((List)localObject2).add(this.packageList.get(paramInt));
            }
            paramInt += 1;
            continue;
            if (CmShowAioMatcher.a(paramInt, 2))
            {
              localObject1 = String.valueOf(1);
              break;
            }
            QLog.e("ApolloDaoManager", 1, "[getPackageInfoBySession], error type:" + paramInt);
            return null;
          }
        }
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "return packageInfoBySession from cache");
          }
          makesureGameFirst((List)localObject2);
          return localObject2;
        }
      }
      localObject2 = this.mApp.getEntityManagerFactory().createEntityManager();
    } while (localObject2 == null);
    Object localObject1 = ((EntityManager)localObject2).query(ApolloActionPackage.class, false, "sessionType=? or sessionType=?", new String[] { "0", localObject1 }, null, null, null, null);
    makesureGameFirst((List)localObject1);
    return localObject1;
  }
  
  public List<ApolloActionPackage> getPackageInfoBySession(SessionInfo paramSessionInfo)
  {
    if ((this.mApp == null) || (paramSessionInfo == null)) {
      return null;
    }
    return getPackageInfoBySession(paramSessionInfo.jdField_a_of_type_Int);
  }
  
  public List<ApolloGameData> getPanelGameList()
  {
    List localList = getGameList();
    if (localList == null)
    {
      QLog.i("ApolloDaoManager", 1, "[getPanelGameList] no game data info");
      return null;
    }
    Object localObject = getGameRoamData();
    if (localObject == null)
    {
      QLog.i("ApolloDaoManager", 1, "[getPanelGameList] no user game list");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      ApolloGameRoamData localApolloGameRoamData = (ApolloGameRoamData)((Iterator)localObject).next();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ApolloGameData localApolloGameData = (ApolloGameData)localIterator.next();
        if ((localApolloGameData != null) && (localApolloGameRoamData != null) && (localApolloGameData.gameId == localApolloGameRoamData.gameId) && (localApolloGameData.isShow != 0) && (localApolloGameData.gameId != 1) && (localApolloGameData.gameId != 2) && (!localApolloGameData.isGameApp) && (ApolloConfigUtils.a("8.5.5", localApolloGameData.minVer, localApolloGameData.maxVer)))
        {
          localApolloGameData.type = localApolloGameRoamData.type;
          localApolloGameData.tagUrl = localApolloGameRoamData.tagUrl;
          localApolloGameData.tagType = localApolloGameRoamData.tagType;
          localArrayList.add(localApolloGameData);
        }
      }
      if ((localApolloGameRoamData == null) || (TextUtils.isEmpty(localApolloGameRoamData.tagUrl)) || (localApolloGameRoamData.tagEndTs >= NetConnInfoCenter.getServerTime())) {
        break label345;
      }
      i = 1;
    }
    label345:
    for (;;)
    {
      break;
      if ((this.mApp != null) && (i != 0) && (!this.mIsReqUserGameList))
      {
        QLog.w("ApolloDaoManager", 1, "getPanelGameList, tab game is out of data");
        ((ApolloGameManager)this.mApp.getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).e();
        this.mIsReqUserGameList = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDaoManager", 2, new Object[] { "[getPanelGameList] panelGameList size:", Integer.valueOf(localArrayList.size()) });
      }
      return localArrayList;
    }
  }
  
  public Map<String, ApolloPreDownloadData> getPreDownloadRes()
  {
    if (this.mApp == null) {
      return new HashMap();
    }
    if (this.mPreDownloadMap.size() > 0) {
      return this.mPreDownloadMap;
    }
    EntityManager localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
    Object localObject3 = new ArrayList();
    Object localObject1 = localObject3;
    EntityTransaction localEntityTransaction;
    if (localEntityManager != null)
    {
      localEntityTransaction = localEntityManager.getTransaction();
      localEntityTransaction.begin();
    }
    try
    {
      localObject1 = (ArrayList)localEntityManager.query(ApolloPreDownloadData.class);
      return this.mPreDownloadMap;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        QLog.e("ApolloDaoManager", 1, "getPreDownloadRes exception: ", (Throwable)localObject3);
        localEntityTransaction.end();
      }
    }
    finally
    {
      localEntityTransaction.end();
    }
  }
  
  public List<ApolloGameRankData> getRankData(int paramInt)
  {
    if ((this.mRankData != null) && (paramInt >= 0))
    {
      if (paramInt >= this.mRankData.size()) {
        return new ArrayList(this.mRankData);
      }
      return new ArrayList(this.mRankData.subList(0, paramInt));
    }
    return null;
  }
  
  public List<ApolloGameRankData> getRankData(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.mRankData != null) && (this.mRankData.size() > 0))
    {
      Object localObject = new ArrayList(this.mRankData);
      if ((paramInt > 0) && (!TextUtils.isEmpty(paramString)))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ApolloGameRankData localApolloGameRankData = (ApolloGameRankData)((Iterator)localObject).next();
          if ((localApolloGameRankData != null) && (paramInt >= 0) && (paramString.equals(localApolloGameRankData.mFriendUin)))
          {
            localArrayList.add(localApolloGameRankData);
            paramInt -= 1;
          }
        }
      }
    }
    return localArrayList;
  }
  
  public Pair<List<ApolloActionPackageData>, List<ApolloActionData>> getRecommendActionList()
  {
    QLog.d("ApolloDaoManager", 1, "getRecommendActionList");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ApolloRecommendAction localApolloRecommendAction;
    ApolloActionData localApolloActionData;
    List localList2;
    synchronized (this.mRecommendActionList)
    {
      Iterator localIterator = this.mRecommendActionList.iterator();
      if (!localIterator.hasNext()) {
        break label217;
      }
      localApolloRecommendAction = (ApolloRecommendAction)localIterator.next();
      localApolloActionData = getActionInfoByIdFromCache(localApolloRecommendAction.id);
      localList2 = getPackageDataByActionId(localApolloRecommendAction.id);
      if ((localApolloActionData != null) && (localList2 != null) && (localList2.size() > 0))
      {
        localArrayList2.add(localApolloActionData);
        localArrayList1.add(localList2.get(0));
      }
    }
    Object localObject2 = "";
    if (localApolloActionData == null) {
      localObject2 = " actionData null";
    }
    if ((localList2 != null) && (localList2.size() != 0)) {}
    for (;;)
    {
      QLog.d("ApolloDaoManager", 1, new Object[] { "getRecommendActionList, invalid, actionId=", Integer.valueOf(localApolloRecommendAction.id), ", reason=", localObject2 });
      break;
      label217:
      localObject2 = new StringBuilder();
      int j = localArrayList2.size();
      int i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject2).append(((ApolloActionData)localArrayList2.get(i)).actionId);
        if (i != j - 1) {
          ((StringBuilder)localObject2).append(",");
        }
        i += 1;
      }
      QLog.d("ApolloDaoManager", 1, new Object[] { "getRecommendActionList, actionIdList=", ((StringBuilder)localObject2).toString() });
      return new Pair(localArrayList1, localArrayList2);
      localObject2 = " no actionset data";
    }
  }
  
  public List<ApolloRecommendAction> getRecommendList()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mRecommendActionList)
    {
      Iterator localIterator = this.mRecommendActionList.iterator();
      if (localIterator.hasNext()) {
        localArrayList.add((ApolloRecommendAction)localIterator.next());
      }
    }
    return localList1;
  }
  
  public List<ApolloActionData> getRecommndActionDataList()
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
    }
    return localList1;
  }
  
  public List<ApolloGameScoreData> getScoreDataByUin(String paramString, int paramInt, List<ApolloGameData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.mScoreData != null) && (paramList != null) && (!TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      synchronized (this.mScoreData)
      {
        paramList = new ArrayList(paramList).iterator();
        i = paramInt;
        ApolloGameData localApolloGameData;
        if (paramList.hasNext())
        {
          localApolloGameData = (ApolloGameData)paramList.next();
          if (i >= -1) {}
        }
        else
        {
          return localArrayList;
        }
        Object localObject = findGameById(localApolloGameData.gameId);
        if ((localObject == null) || (((ApolloGameData)localObject).isShow == 0)) {
          continue;
        }
        Iterator localIterator = new ArrayList(this.mScoreData).iterator();
        j = 0;
        paramInt = i;
        if (localIterator.hasNext())
        {
          ApolloGameScoreData localApolloGameScoreData = (ApolloGameScoreData)localIterator.next();
          if ((paramString.equals(localApolloGameScoreData.mUin)) && (localApolloGameData.gameId == localApolloGameScoreData.mGameId))
          {
            localArrayList.add(localApolloGameScoreData);
            i = paramInt - 1;
            paramInt = 1;
            break label305;
          }
        }
        else
        {
          i = paramInt;
          if (j != 0) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "[getScoreDataByUin] append " + ((ApolloGameData)localObject).gameId);
          }
          localObject = new ApolloGameScoreData();
          ((ApolloGameScoreData)localObject).mUin = paramString;
          ((ApolloGameScoreData)localObject).mGameId = localApolloGameData.gameId;
          ((ApolloGameScoreData)localObject).mFromDb = false;
          localArrayList.add(localObject);
          i = paramInt - 1;
        }
      }
      int i = paramInt;
      paramInt = j;
      break label305;
      return localArrayList;
      label305:
      int j = paramInt;
      paramInt = i;
    }
  }
  
  public ConcurrentHashMap<Integer, ApolloGameRoamData> getTabGameRoamList()
  {
    if (this.mTabGameRoamMap == null) {
      return new ConcurrentHashMap();
    }
    return this.mTabGameRoamMap;
  }
  
  public void getTagListByPkgId(int paramInt, ApolloTagActionViewBinder.IApolloTagDataListener paramIApolloTagDataListener)
  {
    ArrayList localArrayList = new ArrayList();
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    if ((this.mActionTagList == null) || (this.mActionTagList.size() < 1))
    {
      ??? = this.mApp.getEntityManagerFactory().createEntityManager();
      if (??? == null)
      {
        paramIApolloTagDataListener.a();
        return;
      }
      this.mActionTagList = ((EntityManager)???).query(ApolloActionTag.class);
      if (QLog.isColorLevel()) {
        if (this.mActionTagList != null) {
          break label210;
        }
      }
    }
    label210:
    for (??? = null;; ??? = Integer.valueOf(this.mActionTagList.size()))
    {
      QLog.d("ApolloDaoManager", 2, new Object[] { "[getActionTagList] db list size:", ??? });
      if ((this.mActionTagList == null) || (this.mActionTagList.size() <= 0)) {
        break label237;
      }
      synchronized (this.mActionTagList)
      {
        Iterator localIterator = this.mActionTagList.iterator();
        ApolloActionTag localApolloActionTag;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localApolloActionTag = (ApolloActionTag)localIterator.next();
        } while ((paramInt != localApolloActionTag.packageId) || (!localLinkedHashSet.add(localApolloActionTag.tagName)));
        localArrayList.add(localApolloActionTag.tagName);
      }
    }
    paramIApolloTagDataListener.a(localArrayList);
    return;
    label237:
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "ActionTagList is null");
    }
    paramIApolloTagDataListener.a();
  }
  
  public int getWhiteFaceIdMapping(int paramInt1, int paramInt2)
  {
    if (this.mWhiteFaceIdMapping == null) {
      return 0;
    }
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
    if ((paramAioPushData != null) && (this.mAioPushDataList != null)) {
      synchronized (this.mAioPushDataList)
      {
        if (this.mAioPushDataList.indexOf(paramAioPushData) >= 0) {
          bool = true;
        }
        return bool;
      }
    }
    return false;
  }
  
  public void insertFavActionPackageData(ApolloFavActionData paramApolloFavActionData)
  {
    if (paramApolloFavActionData == null) {}
    for (;;)
    {
      return;
      if (this.favActionList != null) {}
      synchronized (this.favActionList)
      {
        this.favActionList.add(paramApolloFavActionData);
        if (this.mApp == null) {
          continue;
        }
        ??? = this.mApp.getEntityManagerFactory().createEntityManager();
        if (??? == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "insert ApolloFavActionData id=" + paramApolloFavActionData.acitonId + " text=" + paramApolloFavActionData.text);
        }
        ((EntityManager)???).persist(paramApolloFavActionData);
        return;
      }
    }
  }
  
  public void insertObtainedActionData(ApolloObtainedActionData paramApolloObtainedActionData)
  {
    if (paramApolloObtainedActionData == null) {}
    for (;;)
    {
      return;
      if (this.mActionObtainedList != null) {}
      synchronized (this.mActionObtainedList)
      {
        this.mActionObtainedList.add(paramApolloObtainedActionData);
        if (this.mObtainedActiveActionMap != null) {
          this.mObtainedActiveActionMap.clear();
        }
        if (this.mApp == null) {
          continue;
        }
        ??? = this.mApp.getEntityManagerFactory().createEntityManager();
        if (??? == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "insert ApolloObtainedActionData:" + paramApolloObtainedActionData.toString());
        }
        ((EntityManager)???).persist(paramApolloObtainedActionData);
        return;
      }
    }
  }
  
  public boolean isGameAtLocal(ApolloGameRoamData paramApolloGameRoamData)
  {
    if (paramApolloGameRoamData == null) {
      return false;
    }
    Object localObject = getGameList();
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ApolloGameData localApolloGameData = (ApolloGameData)((Iterator)localObject).next();
      if ((localApolloGameData != null) && (localApolloGameData.gameId == paramApolloGameRoamData.gameId)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isInUserGameList(int paramInt)
  {
    if (this.gameRoamList == null) {
      return false;
    }
    List localList = this.gameRoamList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.gameRoamList.size()) {
          break;
        }
        if (((ApolloGameRoamData)this.gameRoamList.get(i)).gameId == paramInt) {
          return true;
        }
      }
      finally {}
      i += 1;
    }
    return false;
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
      ThreadManager.post(new ApolloDaoManagerServiceImpl.3(this, paramInt), 5, null, true);
    }
    return false;
  }
  
  public boolean isObtainActionById(int paramInt)
  {
    return getObtainedActiveActionMap().containsKey(Integer.valueOf(paramInt));
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof AppInterface))
    {
      this.mApp = ((AppInterface)paramAppRuntime);
      ThreadManager.getFileThreadHandler().post(this.mReadApolloActionListRunable);
      return;
    }
    QLog.e("ApolloDaoManager", 2, "onCreate error! not run in AppInterface!");
  }
  
  public void onDestroy()
  {
    if (this.actionList != null)
    {
      this.actionList.clear();
      this.actionList = null;
    }
    if (this.packageList != null)
    {
      this.packageList.clear();
      this.packageList = null;
    }
    if (this.actionPackageList != null)
    {
      this.actionPackageList.clear();
      this.actionPackageList = null;
    }
    if (this.favActionList != null)
    {
      this.favActionList.clear();
      this.favActionList = null;
    }
    if (this.gameList != null)
    {
      this.gameList.clear();
      this.gameList = null;
    }
    if (this.actionPushList != null)
    {
      this.actionPushList.clear();
      this.actionPushList = null;
    }
    if (this.mActionObtainedList != null)
    {
      this.mActionObtainedList.clear();
      this.mActionObtainedList = null;
    }
    if (this.mObtainedActiveActionMap != null)
    {
      this.mObtainedActiveActionMap.clear();
      this.mObtainedActiveActionMap = null;
    }
    if (this.mLimitFreeActionMap != null)
    {
      this.mLimitFreeActionMap.clear();
      this.mLimitFreeActionMap = null;
    }
    if (this.mKeywordsActionMap != null)
    {
      this.mKeywordsActionMap.clear();
      this.mKeywordsActionMap = null;
    }
    if (this.mRankData != null)
    {
      this.mRankData.clear();
      this.mRankData = null;
    }
    if (this.mScoreData != null)
    {
      this.mScoreData.clear();
      this.mScoreData = null;
    }
    if (this.mPreDownloadMap != null) {
      this.mPreDownloadMap.clear();
    }
    if (this.mWhiteFaceIdMapping != null) {
      this.mWhiteFaceIdMapping.clear();
    }
    ApolloGameUtil.a();
  }
  
  public void readApolloGameVerFromFile()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "[readApolloGameVerFromFile]");
    }
    Object localObject1 = getGameList();
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      QLog.i("ApolloDaoManager", 1, "errInfo->gameList is null.");
      return;
    }
    StringBuilder localStringBuilder2;
    for (;;)
    {
      ApolloGameData localApolloGameData;
      Object localObject2;
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder2 = new StringBuilder();
        localStringBuilder1.append("readGameVersion:");
        localStringBuilder2.append("\nerrInfo(config.json not exists):");
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localApolloGameData = (ApolloGameData)((Iterator)localObject1).next();
        localObject2 = new StringBuilder(100);
        ((StringBuilder)localObject2).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/").append(localApolloGameData.gameId).append(File.separator).append("config.json");
        localObject2 = new File(((StringBuilder)localObject2).toString());
        if (!((File)localObject2).exists())
        {
          localStringBuilder2.append(localApolloGameData.gameId).append(", ");
          continue;
        }
        localObject2 = new JSONObject(FileUtils.b((File)localObject2)).optString("version");
      }
      catch (Exception localException)
      {
        QLog.e("ApolloDaoManager", 1, "catch errInfo:" + localException.getMessage());
        return;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        this.mApolloGameVer.put(Integer.valueOf(localApolloGameData.gameId), localObject2);
      }
      localException.append("gId:").append(localApolloGameData.gameId).append(",ver:").append((String)localObject2).append("|");
    }
    QLog.i("ApolloDaoManager", 1, localException.toString() + localStringBuilder2.toString());
  }
  
  public void readApolloGameVerFromFile(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "[readApolloGameVerFromFile]");
    }
    Object localObject1 = getGameList();
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      QLog.i("ApolloDaoManager", 1, "errInfo->gameList is null.");
      return;
    }
    for (;;)
    {
      ApolloGameData localApolloGameData;
      Object localObject2;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localApolloGameData = (ApolloGameData)((Iterator)localObject1).next();
        if (paramInt != localApolloGameData.gameId) {
          continue;
        }
        localObject2 = new StringBuilder(100);
        ((StringBuilder)localObject2).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/").append(localApolloGameData.gameId).append(File.separator).append("config.json");
        localObject2 = new File(((StringBuilder)localObject2).toString());
        if (!((File)localObject2).exists())
        {
          localStringBuilder.append("errInfo->game version file not exists, gameId: ").append(localApolloGameData.gameId);
          continue;
        }
        localObject2 = new JSONObject(FileUtils.b((File)localObject2)).optString("version");
      }
      catch (Exception localException)
      {
        QLog.e("ApolloDaoManager", 1, "catch errInfo:" + localException.getMessage());
        return;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        this.mApolloGameVer.put(Integer.valueOf(localApolloGameData.gameId), localObject2);
      }
      localException.append("gId:").append(localApolloGameData.gameId).append(",ver: ").append((String)localObject2).append("===");
    }
    QLog.i("ApolloDaoManager", 1, localException.toString());
  }
  
  public void realDelAioPushData(AioPushData paramAioPushData)
  {
    if (paramAioPushData == null) {}
    for (;;)
    {
      return;
      if (this.mAioPushDataList != null) {}
      boolean bool;
      EntityManager localEntityManager;
      synchronized (this.mAioPushDataList)
      {
        bool = this.mAioPushDataList.remove(paramAioPushData);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "[realDelAioPushData] from cache " + String.valueOf(bool));
        }
        localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
        if (localEntityManager == null) {
          continue;
        }
        ??? = localEntityManager.getTransaction();
        ((EntityTransaction)???).begin();
      }
    }
  }
  
  public void rearrangeEnhanceAction(BaseChatPie paramBaseChatPie, List<ApolloActionData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramBaseChatPie == null) || (paramBaseChatPie.a() == null)) {
      return;
    }
    Object localObject = (ApolloManagerServiceImpl)paramBaseChatPie.a().getRuntimeService(IApolloManagerService.class, "all");
    boolean bool = ((ApolloManagerServiceImpl)localObject).getAVIPStatus(paramBaseChatPie.a().getCurrentAccountUin());
    int j = ((ApolloManagerServiceImpl)localObject).getAVIPLevel(paramBaseChatPie.a().getCurrentAccountUin());
    paramBaseChatPie = new ArrayList();
    localObject = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      ApolloActionData localApolloActionData = (ApolloActionData)paramList.get(i);
      if (isLimitFreeActionById(localApolloActionData.actionId)) {
        paramBaseChatPie.add(localApolloActionData);
      }
      for (;;)
      {
        i += 1;
        break;
        if (!TextUtils.isEmpty(localApolloActionData.iconUrl)) {
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
      }
    }
    Collections.sort(paramBaseChatPie, new ApolloDaoManagerServiceImpl.4(this));
    Collections.sort(localArrayList1, new ApolloDaoManagerServiceImpl.5(this));
    Collections.sort((List)localObject, new ApolloDaoManagerServiceImpl.6(this));
    Collections.sort(localArrayList2, new ApolloDaoManagerServiceImpl.7(this));
    Collections.sort(localArrayList3, new ApolloDaoManagerServiceImpl.8(this));
    paramList.clear();
    paramList.addAll(paramBaseChatPie);
    paramList.addAll(localArrayList1);
    paramList.addAll((Collection)localObject);
    paramList.addAll(localArrayList2);
    paramList.addAll(localArrayList3);
  }
  
  public void removeActionPushDataById(long paramLong)
  {
    if (this.actionPushList != null) {}
    EntityManager localEntityManager;
    do
    {
      synchronized (this.actionPushList)
      {
        Iterator localIterator = this.actionPushList.iterator();
        while (localIterator.hasNext())
        {
          ApolloActionPush localApolloActionPush = (ApolloActionPush)localIterator.next();
          if ((localApolloActionPush != null) && (localApolloActionPush.mId == paramLong)) {
            this.actionPushList.remove(localApolloActionPush);
          }
        }
        if (this.mApp == null) {
          return;
        }
      }
      localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
    } while (localEntityManager == null);
    ??? = localEntityManager.getTransaction();
    try
    {
      ((EntityTransaction)???).begin();
      localEntityManager.execSQL(" DELETE FROM ApolloActionPush WHERE mId = " + paramLong);
      ((EntityTransaction)???).commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      ((EntityTransaction)???).end();
    }
  }
  
  public void removeAioPushData(AioPushData paramAioPushData)
  {
    if ((paramAioPushData == null) || (this.mApp == null)) {
      QLog.e("ApolloDaoManager", 1, "[removeAioPushData] app or data is null");
    }
    Object localObject2;
    do
    {
      return;
      if (this.mAioPushDataList != null) {
        synchronized (this.mAioPushDataList)
        {
          localObject2 = this.mAioPushDataList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            AioPushData localAioPushData = (AioPushData)((Iterator)localObject2).next();
            if (localAioPushData.equals(paramAioPushData)) {
              localAioPushData.isShow = true;
            }
          }
        }
      }
      localObject2 = this.mApp.getEntityManagerFactory().createEntityManager();
    } while (localObject2 == null);
    ??? = ((EntityManager)localObject2).getTransaction();
    ((EntityTransaction)???).begin();
    try
    {
      paramAioPushData.isShow = true;
      boolean bool = ((EntityManager)localObject2).update(paramAioPushData);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDaoManager", 2, "[removeAioPushData] " + String.valueOf(bool) + " # " + paramAioPushData);
      }
      ((EntityTransaction)???).commit();
      return;
    }
    catch (Exception paramAioPushData)
    {
      QLog.e("ApolloDaoManager", 1, "removeAioPushData errInfo-> " + paramAioPushData.getMessage());
      return;
    }
    finally
    {
      ((EntityTransaction)???).end();
    }
  }
  
  public void removeAllAction()
  {
    if (this.mApp == null) {}
    EntityManager localEntityManager;
    List localList;
    for (;;)
    {
      return;
      QLog.i("ApolloDaoManager", 1, "removeAllAction");
      if (this.actionList != null) {}
      synchronized (this.actionList)
      {
        this.actionList.clear();
        if (this.mKeywordsActionMap != null)
        {
          this.mKeywordsActionMap.clear();
          this.mMaxKeywordsLength = 1;
        }
        localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
        if (localEntityManager != null)
        {
          localList = localEntityManager.query(ApolloActionData.class);
          if (localList != null) {
            ??? = localEntityManager.getTransaction();
          }
        }
      }
    }
    try
    {
      ((EntityTransaction)???).begin();
      int i = 0;
      while (i < localList.size())
      {
        ApolloActionData localApolloActionData = (ApolloActionData)localList.get(i);
        if (localApolloActionData != null) {
          localEntityManager.remove(localApolloActionData);
        }
        i += 1;
        continue;
        localObject2 = finally;
        throw localObject2;
      }
      ((EntityTransaction)???).commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      ((EntityTransaction)???).end();
    }
  }
  
  public void removeAllActionTag()
  {
    if (this.mActionTagList != null) {}
    EntityManager localEntityManager;
    do
    {
      synchronized (this.mActionTagList)
      {
        this.mActionTagList.clear();
        if (this.mApp == null) {
          return;
        }
      }
      localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
    } while (localEntityManager == null);
    ??? = localEntityManager.getTransaction();
    try
    {
      ((EntityTransaction)???).begin();
      localEntityManager.execSQL(" DELETE FROM ApolloActionTag ");
      ((EntityTransaction)???).commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      ((EntityTransaction)???).end();
    }
  }
  
  public void removeAllGameRoamData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "[removeGameRoamData]");
    }
    if (this.mApp == null) {}
    for (;;)
    {
      return;
      if (this.gameRoamList != null) {}
      EntityManager localEntityManager;
      synchronized (this.gameRoamList)
      {
        this.gameRoamList.clear();
        if (this.mTabGameRoamMap != null) {
          this.mTabGameRoamMap.clear();
        }
        localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
        if (localEntityManager == null) {
          continue;
        }
        ??? = localEntityManager.getTransaction();
      }
    }
  }
  
  public void removeAllObtainedAction()
  {
    if (this.mApp == null) {}
    EntityManager localEntityManager;
    List localList;
    for (;;)
    {
      return;
      if (this.mActionObtainedList != null) {}
      synchronized (this.mActionObtainedList)
      {
        this.mActionObtainedList.clear();
        localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
        if (localEntityManager != null)
        {
          localList = localEntityManager.query(ApolloObtainedActionData.class);
          if (localList != null) {
            ??? = localEntityManager.getTransaction();
          }
        }
      }
    }
    try
    {
      ((EntityTransaction)???).begin();
      int i = 0;
      while (i < localList.size())
      {
        ApolloObtainedActionData localApolloObtainedActionData = (ApolloObtainedActionData)localList.get(i);
        if (localApolloObtainedActionData != null) {
          localEntityManager.remove(localApolloObtainedActionData);
        }
        i += 1;
        continue;
        localObject2 = finally;
        throw localObject2;
      }
      ((EntityTransaction)???).commit();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloDaoManager", 1, "[removeAllObtainedAction] exception: ", localException);
      return;
    }
    finally
    {
      ((EntityTransaction)???).end();
    }
  }
  
  public void removeAllPackageData()
  {
    if (this.actionPackageList != null) {}
    EntityManager localEntityManager;
    do
    {
      synchronized (this.actionPackageList)
      {
        this.actionPackageList.clear();
        if (this.mApp == null) {
          return;
        }
      }
      localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
    } while (localEntityManager == null);
    ??? = localEntityManager.getTransaction();
    try
    {
      ((EntityTransaction)???).begin();
      localEntityManager.execSQL(" DELETE FROM ApolloActionPackageData ");
      ((EntityTransaction)???).commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      ((EntityTransaction)???).end();
    }
  }
  
  public void removeAllRecommendActionList()
  {
    QLog.d("ApolloDaoManager", 1, "removeAllRecommendActionList");
    if (this.mApp == null) {}
    for (;;)
    {
      return;
      EntityManager localEntityManager;
      synchronized (this.mRecommendActionList)
      {
        this.mRecommendActionList.clear();
        localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
        if (localEntityManager == null) {
          continue;
        }
        ??? = localEntityManager.getTransaction();
        ((EntityTransaction)???).begin();
      }
    }
  }
  
  /* Error */
  public void removeGameRank(EntityManager paramEntityManager, List<ApolloGameRankData> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +122 -> 123
    //   4: aload_2
    //   5: ifnull +118 -> 123
    //   8: aload_2
    //   9: invokeinterface 203 1 0
    //   14: ifle +109 -> 123
    //   17: aload_0
    //   18: getfield 124	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mRankData	Ljava/util/List;
    //   21: ifnull +102 -> 123
    //   24: aload_0
    //   25: getfield 124	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mRankData	Ljava/util/List;
    //   28: astore_3
    //   29: aload_3
    //   30: monitorenter
    //   31: aload_0
    //   32: getfield 124	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mRankData	Ljava/util/List;
    //   35: aload_2
    //   36: invokeinterface 324 2 0
    //   41: pop
    //   42: aload_3
    //   43: monitorexit
    //   44: aload_2
    //   45: invokeinterface 178 1 0
    //   50: astore_2
    //   51: aload_2
    //   52: invokeinterface 184 1 0
    //   57: ifeq +66 -> 123
    //   60: aload_2
    //   61: invokeinterface 188 1 0
    //   66: checkcast 853	com/tencent/mobileqq/apollo/api/model/ApolloGameRankData
    //   69: astore_3
    //   70: aload_1
    //   71: aload_3
    //   72: invokevirtual 254	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   75: pop
    //   76: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq -28 -> 51
    //   82: ldc 12
    //   84: iconst_2
    //   85: iconst_2
    //   86: anewarray 4	java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: ldc_w 1131
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: aload_3
    //   98: aastore
    //   99: invokestatic 459	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   102: goto -51 -> 51
    //   105: astore_1
    //   106: ldc 12
    //   108: iconst_1
    //   109: aload_1
    //   110: iconst_1
    //   111: anewarray 4	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: ldc_w 1133
    //   119: aastore
    //   120: invokestatic 1136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   123: return
    //   124: astore_1
    //   125: aload_3
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	ApolloDaoManagerServiceImpl
    //   0	129	1	paramEntityManager	EntityManager
    //   0	129	2	paramList	List<ApolloGameRankData>
    // Exception table:
    //   from	to	target	type
    //   24	31	105	java/lang/Throwable
    //   44	51	105	java/lang/Throwable
    //   51	102	105	java/lang/Throwable
    //   127	129	105	java/lang/Throwable
    //   31	44	124	finally
    //   125	127	124	finally
  }
  
  /* Error */
  public void removePackageInfo(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 362	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 91	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:packageList	Ljava/util/List;
    //   12: ifnull +124 -> 136
    //   15: aload_0
    //   16: getfield 91	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:packageList	Ljava/util/List;
    //   19: astore 7
    //   21: aload 7
    //   23: monitorenter
    //   24: iconst_1
    //   25: iload_1
    //   26: if_icmpne +164 -> 190
    //   29: aload_0
    //   30: getfield 91	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:packageList	Ljava/util/List;
    //   33: invokeinterface 178 1 0
    //   38: astore 5
    //   40: aload 5
    //   42: invokeinterface 184 1 0
    //   47: ifeq +337 -> 384
    //   50: aload 5
    //   52: invokeinterface 188 1 0
    //   57: checkcast 264	com/tencent/mobileqq/apollo/api/model/ApolloActionPackage
    //   60: astore 6
    //   62: aload 6
    //   64: ifnull -24 -> 40
    //   67: aload 6
    //   69: getfield 267	com/tencent/mobileqq/apollo/api/model/ApolloActionPackage:packageId	I
    //   72: bipush 100
    //   74: if_icmpne -34 -> 40
    //   77: aload 6
    //   79: invokevirtual 1142	com/tencent/mobileqq/apollo/api/model/ApolloActionPackage:getCopy	()Lcom/tencent/mobileqq/apollo/api/model/ApolloActionPackage;
    //   82: astore 6
    //   84: aload 6
    //   86: astore 5
    //   88: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +16 -> 107
    //   94: ldc 12
    //   96: iconst_2
    //   97: ldc_w 1144
    //   100: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload 6
    //   105: astore 5
    //   107: aload_0
    //   108: getfield 91	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:packageList	Ljava/util/List;
    //   111: invokeinterface 412 1 0
    //   116: aload 5
    //   118: ifnull +15 -> 133
    //   121: aload_0
    //   122: getfield 91	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:packageList	Ljava/util/List;
    //   125: aload 5
    //   127: invokeinterface 316 2 0
    //   132: pop
    //   133: aload 7
    //   135: monitorexit
    //   136: aload_0
    //   137: getfield 362	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   140: invokevirtual 367	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   143: invokevirtual 370	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   146: astore 6
    //   148: aload 6
    //   150: ifnull -143 -> 7
    //   153: aload 6
    //   155: invokevirtual 374	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   158: astore 5
    //   160: aload 5
    //   162: invokevirtual 379	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   165: iconst_1
    //   166: iload_1
    //   167: if_icmpne +177 -> 344
    //   170: aload 6
    //   172: ldc_w 1146
    //   175: invokevirtual 1090	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   178: pop
    //   179: aload 5
    //   181: invokevirtual 418	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   184: aload 5
    //   186: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   189: return
    //   190: iconst_2
    //   191: iload_1
    //   192: if_icmpne -59 -> 133
    //   195: iconst_m1
    //   196: istore_2
    //   197: aload_0
    //   198: getfield 91	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:packageList	Ljava/util/List;
    //   201: invokeinterface 178 1 0
    //   206: astore 5
    //   208: iload_2
    //   209: istore 4
    //   211: aload 5
    //   213: invokeinterface 184 1 0
    //   218: ifeq +76 -> 294
    //   221: aload 5
    //   223: invokeinterface 188 1 0
    //   228: checkcast 264	com/tencent/mobileqq/apollo/api/model/ApolloActionPackage
    //   231: astore 6
    //   233: iload_2
    //   234: iconst_1
    //   235: iadd
    //   236: istore_3
    //   237: iload_3
    //   238: istore_2
    //   239: aload 6
    //   241: ifnull -33 -> 208
    //   244: iload_3
    //   245: istore_2
    //   246: aload 6
    //   248: getfield 267	com/tencent/mobileqq/apollo/api/model/ApolloActionPackage:packageId	I
    //   251: bipush 100
    //   253: if_icmpne -45 -> 208
    //   256: iload_3
    //   257: istore 4
    //   259: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq +32 -> 294
    //   265: ldc 12
    //   267: iconst_2
    //   268: new 280	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   275: ldc_w 1148
    //   278: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: iload_3
    //   282: invokevirtual 290	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   285: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: iload_3
    //   292: istore 4
    //   294: iload 4
    //   296: ifle -163 -> 133
    //   299: aload_0
    //   300: getfield 91	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:packageList	Ljava/util/List;
    //   303: iload 4
    //   305: invokeinterface 207 2 0
    //   310: checkcast 264	com/tencent/mobileqq/apollo/api/model/ApolloActionPackage
    //   313: getfield 267	com/tencent/mobileqq/apollo/api/model/ApolloActionPackage:packageId	I
    //   316: bipush 100
    //   318: if_icmpne -185 -> 133
    //   321: aload_0
    //   322: getfield 91	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:packageList	Ljava/util/List;
    //   325: iload 4
    //   327: invokeinterface 295 2 0
    //   332: pop
    //   333: goto -200 -> 133
    //   336: astore 5
    //   338: aload 7
    //   340: monitorexit
    //   341: aload 5
    //   343: athrow
    //   344: iconst_2
    //   345: iload_1
    //   346: if_icmpne -167 -> 179
    //   349: aload 6
    //   351: ldc_w 1150
    //   354: invokevirtual 1090	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   357: pop
    //   358: goto -179 -> 179
    //   361: astore 6
    //   363: aload 6
    //   365: invokevirtual 425	java/lang/Exception:printStackTrace	()V
    //   368: aload 5
    //   370: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   373: return
    //   374: astore 6
    //   376: aload 5
    //   378: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   381: aload 6
    //   383: athrow
    //   384: aconst_null
    //   385: astore 5
    //   387: goto -280 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	this	ApolloDaoManagerServiceImpl
    //   0	390	1	paramInt	int
    //   196	50	2	i	int
    //   236	56	3	j	int
    //   209	117	4	k	int
    //   38	184	5	localObject1	Object
    //   336	41	5	localObject2	Object
    //   385	1	5	localObject3	Object
    //   60	290	6	localObject4	Object
    //   361	3	6	localException	Exception
    //   374	8	6	localObject5	Object
    //   19	320	7	localList	List
    // Exception table:
    //   from	to	target	type
    //   29	40	336	finally
    //   40	62	336	finally
    //   67	84	336	finally
    //   88	103	336	finally
    //   107	116	336	finally
    //   121	133	336	finally
    //   133	136	336	finally
    //   197	208	336	finally
    //   211	233	336	finally
    //   246	256	336	finally
    //   259	291	336	finally
    //   299	333	336	finally
    //   338	341	336	finally
    //   160	165	361	java/lang/Exception
    //   170	179	361	java/lang/Exception
    //   179	184	361	java/lang/Exception
    //   349	358	361	java/lang/Exception
    //   160	165	374	finally
    //   170	179	374	finally
    //   179	184	374	finally
    //   349	358	374	finally
    //   363	368	374	finally
  }
  
  /* Error */
  public void removePatialGameRoamData(ArrayList<ApolloGameRoamData> paramArrayList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +17 -> 18
    //   4: aload_1
    //   5: invokevirtual 1153	java/util/ArrayList:size	()I
    //   8: ifeq +10 -> 18
    //   11: aload_0
    //   12: getfield 362	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   15: ifnonnull +4 -> 19
    //   18: return
    //   19: aload_0
    //   20: getfield 99	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:gameRoamList	Ljava/util/List;
    //   23: ifnull +130 -> 153
    //   26: aload_0
    //   27: getfield 99	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:gameRoamList	Ljava/util/List;
    //   30: astore_2
    //   31: aload_2
    //   32: monitorenter
    //   33: aload_1
    //   34: invokevirtual 851	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   37: astore_3
    //   38: aload_3
    //   39: invokeinterface 184 1 0
    //   44: ifeq +107 -> 151
    //   47: aload_3
    //   48: invokeinterface 188 1 0
    //   53: checkcast 190	com/tencent/mobileqq/apollo/api/model/ApolloGameRoamData
    //   56: astore 4
    //   58: aload_0
    //   59: getfield 99	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:gameRoamList	Ljava/util/List;
    //   62: invokeinterface 178 1 0
    //   67: astore 5
    //   69: aload 5
    //   71: invokeinterface 184 1 0
    //   76: ifeq -38 -> 38
    //   79: aload 5
    //   81: invokeinterface 188 1 0
    //   86: checkcast 190	com/tencent/mobileqq/apollo/api/model/ApolloGameRoamData
    //   89: astore 6
    //   91: aload 4
    //   93: ifnull -24 -> 69
    //   96: aload 6
    //   98: ifnull -29 -> 69
    //   101: aload 6
    //   103: getfield 786	com/tencent/mobileqq/apollo/api/model/ApolloGameRoamData:gameId	I
    //   106: aload 4
    //   108: getfield 786	com/tencent/mobileqq/apollo/api/model/ApolloGameRoamData:gameId	I
    //   111: if_icmpne -42 -> 69
    //   114: aload_0
    //   115: getfield 99	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:gameRoamList	Ljava/util/List;
    //   118: aload 6
    //   120: invokeinterface 501 2 0
    //   125: pop
    //   126: aload 6
    //   128: getfield 193	com/tencent/mobileqq/apollo/api/model/ApolloGameRoamData:tagUrl	Ljava/lang/String;
    //   131: invokestatic 199	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   134: ifeq -96 -> 38
    //   137: aload_0
    //   138: aload 6
    //   140: invokevirtual 1157	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:removeTabGameRoamData	(Lcom/tencent/mobileqq/apollo/api/model/ApolloGameRoamData;)V
    //   143: goto -105 -> 38
    //   146: astore_1
    //   147: aload_2
    //   148: monitorexit
    //   149: aload_1
    //   150: athrow
    //   151: aload_2
    //   152: monitorexit
    //   153: aload_0
    //   154: getfield 362	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   157: invokevirtual 367	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   160: invokevirtual 370	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   163: astore_3
    //   164: aload_3
    //   165: ifnull -147 -> 18
    //   168: aload_3
    //   169: invokevirtual 374	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   172: astore_2
    //   173: aload_2
    //   174: invokevirtual 379	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   177: aload_1
    //   178: invokevirtual 851	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   181: astore_1
    //   182: aload_1
    //   183: invokeinterface 184 1 0
    //   188: ifeq +61 -> 249
    //   191: aload_1
    //   192: invokeinterface 188 1 0
    //   197: checkcast 190	com/tencent/mobileqq/apollo/api/model/ApolloGameRoamData
    //   200: astore 4
    //   202: aload 4
    //   204: ifnull -22 -> 182
    //   207: aload_3
    //   208: new 280	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 1159
    //   218: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload 4
    //   223: getfield 786	com/tencent/mobileqq/apollo/api/model/ApolloGameRoamData:gameId	I
    //   226: invokevirtual 290	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   229: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokevirtual 1090	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   235: pop
    //   236: goto -54 -> 182
    //   239: astore_1
    //   240: aload_1
    //   241: invokevirtual 425	java/lang/Exception:printStackTrace	()V
    //   244: aload_2
    //   245: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   248: return
    //   249: aload_2
    //   250: invokevirtual 418	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   253: aload_2
    //   254: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   257: return
    //   258: astore_1
    //   259: aload_2
    //   260: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   263: aload_1
    //   264: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	ApolloDaoManagerServiceImpl
    //   0	265	1	paramArrayList	ArrayList<ApolloGameRoamData>
    //   30	230	2	localObject1	Object
    //   37	171	3	localObject2	Object
    //   56	166	4	localApolloGameRoamData1	ApolloGameRoamData
    //   67	13	5	localIterator	Iterator
    //   89	50	6	localApolloGameRoamData2	ApolloGameRoamData
    // Exception table:
    //   from	to	target	type
    //   33	38	146	finally
    //   38	69	146	finally
    //   69	91	146	finally
    //   101	143	146	finally
    //   147	149	146	finally
    //   151	153	146	finally
    //   173	182	239	java/lang/Exception
    //   182	202	239	java/lang/Exception
    //   207	236	239	java/lang/Exception
    //   249	253	239	java/lang/Exception
    //   173	182	258	finally
    //   182	202	258	finally
    //   207	236	258	finally
    //   240	244	258	finally
    //   249	253	258	finally
  }
  
  public void removeTabGameRoamData(ApolloGameRoamData paramApolloGameRoamData)
  {
    if (this.mTabGameRoamMap != null) {
      this.mTabGameRoamMap.remove(Integer.valueOf(paramApolloGameRoamData.gameId));
    }
  }
  
  public void saveAction(List<ApolloActionData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (this.mApp == null)) {}
    for (;;)
    {
      return;
      EntityManager localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
      if (localEntityManager != null)
      {
        ??? = localEntityManager.getTransaction();
        ((EntityTransaction)???).begin();
      }
      try
      {
        localStringBuilder = new StringBuilder(500);
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          ApolloActionData localApolloActionData = (ApolloActionData)localIterator.next();
          saveActionKeywordsMap(localApolloActionData);
          updateEntity(localEntityManager, localApolloActionData);
          if (QLog.isColorLevel())
          {
            localStringBuilder.append(" saveAction ID:").append(localApolloActionData.actionId);
            if (localStringBuilder.length() >= 500)
            {
              QLog.d("ApolloDaoManager", 2, localStringBuilder.toString());
              localStringBuilder.delete(0, localStringBuilder.length());
            }
          }
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "saveAction exception: ", localException);
        }
        ((EntityTransaction)???).end();
        while (this.actionList != null)
        {
          synchronized (this.actionList)
          {
            this.actionList.addAll(paramList);
            return;
          }
          if ((localStringBuilder.length() < 500) && (localStringBuilder.length() > 0) && (QLog.isColorLevel())) {
            QLog.d("ApolloDaoManager", 2, localStringBuilder.toString());
          }
          ((EntityTransaction)???).commit();
          ((EntityTransaction)???).end();
        }
      }
      finally
      {
        ((EntityTransaction)???).end();
      }
    }
  }
  
  /* Error */
  public void saveActionPackageInfo(List<ApolloActionPackageData> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 203 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 93	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:actionPackageList	Ljava/util/List;
    //   18: ifnull +23 -> 41
    //   21: aload_0
    //   22: getfield 93	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:actionPackageList	Ljava/util/List;
    //   25: astore_2
    //   26: aload_2
    //   27: monitorenter
    //   28: aload_0
    //   29: getfield 93	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:actionPackageList	Ljava/util/List;
    //   32: aload_1
    //   33: invokeinterface 414 2 0
    //   38: pop
    //   39: aload_2
    //   40: monitorexit
    //   41: aload_0
    //   42: getfield 362	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   45: ifnull -32 -> 13
    //   48: aload_0
    //   49: getfield 362	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   52: invokevirtual 367	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   55: invokevirtual 370	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   58: astore_3
    //   59: aload_3
    //   60: ifnull -47 -> 13
    //   63: aload_3
    //   64: invokevirtual 374	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 379	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   72: new 280	java/lang/StringBuilder
    //   75: dup
    //   76: sipush 500
    //   79: invokespecial 382	java/lang/StringBuilder:<init>	(I)V
    //   82: astore 4
    //   84: aload_1
    //   85: invokeinterface 178 1 0
    //   90: astore_1
    //   91: aload_1
    //   92: invokeinterface 184 1 0
    //   97: ifeq +115 -> 212
    //   100: aload_1
    //   101: invokeinterface 188 1 0
    //   106: checkcast 489	com/tencent/mobileqq/apollo/api/model/ApolloActionPackageData
    //   109: astore 5
    //   111: aload_0
    //   112: aload_3
    //   113: aload 5
    //   115: invokevirtual 390	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   118: pop
    //   119: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +20 -> 142
    //   125: aload 4
    //   127: ldc_w 1168
    //   130: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload 5
    //   135: getfield 493	com/tencent/mobileqq/apollo/api/model/ApolloActionPackageData:acitonId	I
    //   138: invokevirtual 290	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 4
    //   144: invokevirtual 396	java/lang/StringBuilder:length	()I
    //   147: sipush 500
    //   150: if_icmplt -59 -> 91
    //   153: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq -65 -> 91
    //   159: ldc 12
    //   161: iconst_2
    //   162: aload 4
    //   164: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload 4
    //   172: iconst_0
    //   173: aload 4
    //   175: invokevirtual 396	java/lang/StringBuilder:length	()I
    //   178: invokevirtual 400	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: goto -91 -> 91
    //   185: astore_1
    //   186: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +13 -> 202
    //   192: ldc 12
    //   194: iconst_2
    //   195: ldc_w 1163
    //   198: aload_1
    //   199: invokestatic 1165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   202: aload_2
    //   203: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   206: return
    //   207: astore_1
    //   208: aload_2
    //   209: monitorexit
    //   210: aload_1
    //   211: athrow
    //   212: aload 4
    //   214: invokevirtual 396	java/lang/StringBuilder:length	()I
    //   217: sipush 500
    //   220: if_icmpge +20 -> 240
    //   223: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   226: ifeq +14 -> 240
    //   229: ldc 12
    //   231: iconst_2
    //   232: aload 4
    //   234: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: aload_2
    //   241: invokevirtual 418	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   244: aload_2
    //   245: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   248: return
    //   249: astore_1
    //   250: aload_2
    //   251: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   254: aload_1
    //   255: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	ApolloDaoManagerServiceImpl
    //   0	256	1	paramList	List<ApolloActionPackageData>
    //   25	226	2	localObject	Object
    //   58	55	3	localEntityManager	EntityManager
    //   82	151	4	localStringBuilder	StringBuilder
    //   109	25	5	localApolloActionPackageData	ApolloActionPackageData
    // Exception table:
    //   from	to	target	type
    //   72	91	185	java/lang/Exception
    //   91	142	185	java/lang/Exception
    //   142	182	185	java/lang/Exception
    //   212	240	185	java/lang/Exception
    //   240	244	185	java/lang/Exception
    //   28	41	207	finally
    //   208	210	207	finally
    //   72	91	249	finally
    //   91	142	249	finally
    //   142	182	249	finally
    //   186	202	249	finally
    //   212	240	249	finally
    //   240	244	249	finally
  }
  
  public void saveActionPushData(ApolloActionPush paramApolloActionPush)
  {
    if ((paramApolloActionPush == null) || (this.mApp == null)) {
      return;
    }
    if (this.actionPushList != null) {}
    for (;;)
    {
      int i;
      Object localObject2;
      synchronized (this.actionPushList)
      {
        i = this.actionPushList.size() - 1;
        if (i >= 0)
        {
          localObject2 = (ApolloActionPush)this.actionPushList.get(i);
          if ((localObject2 != null) && (((ApolloActionPush)localObject2).mAioType == paramApolloActionPush.mAioType) && (((ApolloActionPush)localObject2).mSessionId == paramApolloActionPush.mSessionId)) {
            this.actionPushList.remove(localObject2);
          }
        }
        else
        {
          this.actionPushList.add(paramApolloActionPush);
          localObject2 = this.mApp.getEntityManagerFactory().createEntityManager();
          if (localObject2 == null) {
            break;
          }
          ??? = ((EntityManager)localObject2).getTransaction();
          ((EntityTransaction)???).begin();
        }
      }
      i -= 1;
    }
  }
  
  /* Error */
  public void saveActionTag(List<ApolloActionTag> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 203 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 134	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mActionTagList	Ljava/util/List;
    //   18: ifnull +23 -> 41
    //   21: aload_0
    //   22: getfield 134	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mActionTagList	Ljava/util/List;
    //   25: astore_2
    //   26: aload_2
    //   27: monitorenter
    //   28: aload_0
    //   29: getfield 134	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mActionTagList	Ljava/util/List;
    //   32: aload_1
    //   33: invokeinterface 414 2 0
    //   38: pop
    //   39: aload_2
    //   40: monitorexit
    //   41: aload_0
    //   42: getfield 362	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   45: ifnull -32 -> 13
    //   48: aload_0
    //   49: getfield 362	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   52: invokevirtual 367	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   55: invokevirtual 370	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   58: astore_3
    //   59: aload_3
    //   60: ifnull -47 -> 13
    //   63: aload_3
    //   64: invokevirtual 374	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 379	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   72: new 280	java/lang/StringBuilder
    //   75: dup
    //   76: sipush 500
    //   79: invokespecial 382	java/lang/StringBuilder:<init>	(I)V
    //   82: astore 4
    //   84: aload_1
    //   85: invokeinterface 178 1 0
    //   90: astore_1
    //   91: aload_1
    //   92: invokeinterface 184 1 0
    //   97: ifeq +115 -> 212
    //   100: aload_1
    //   101: invokeinterface 188 1 0
    //   106: checkcast 531	com/tencent/mobileqq/data/ApolloActionTag
    //   109: astore 5
    //   111: aload_0
    //   112: aload_3
    //   113: aload 5
    //   115: invokevirtual 390	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   118: pop
    //   119: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +20 -> 142
    //   125: aload 4
    //   127: ldc_w 1180
    //   130: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload 5
    //   135: getfield 544	com/tencent/mobileqq/data/ApolloActionTag:actionId	I
    //   138: invokevirtual 290	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 4
    //   144: invokevirtual 396	java/lang/StringBuilder:length	()I
    //   147: sipush 500
    //   150: if_icmplt -59 -> 91
    //   153: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq -65 -> 91
    //   159: ldc 12
    //   161: iconst_2
    //   162: aload 4
    //   164: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload 4
    //   172: iconst_0
    //   173: aload 4
    //   175: invokevirtual 396	java/lang/StringBuilder:length	()I
    //   178: invokevirtual 400	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: goto -91 -> 91
    //   185: astore_1
    //   186: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +13 -> 202
    //   192: ldc 12
    //   194: iconst_2
    //   195: ldc_w 1182
    //   198: aload_1
    //   199: invokestatic 1165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   202: aload_2
    //   203: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   206: return
    //   207: astore_1
    //   208: aload_2
    //   209: monitorexit
    //   210: aload_1
    //   211: athrow
    //   212: aload 4
    //   214: invokevirtual 396	java/lang/StringBuilder:length	()I
    //   217: sipush 500
    //   220: if_icmpge +20 -> 240
    //   223: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   226: ifeq +14 -> 240
    //   229: ldc 12
    //   231: iconst_2
    //   232: aload 4
    //   234: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: aload_2
    //   241: invokevirtual 418	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   244: aload_2
    //   245: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   248: return
    //   249: astore_1
    //   250: aload_2
    //   251: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   254: aload_1
    //   255: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	ApolloDaoManagerServiceImpl
    //   0	256	1	paramList	List<ApolloActionTag>
    //   25	226	2	localObject	Object
    //   58	55	3	localEntityManager	EntityManager
    //   82	151	4	localStringBuilder	StringBuilder
    //   109	25	5	localApolloActionTag	ApolloActionTag
    // Exception table:
    //   from	to	target	type
    //   72	91	185	java/lang/Exception
    //   91	142	185	java/lang/Exception
    //   142	182	185	java/lang/Exception
    //   212	240	185	java/lang/Exception
    //   240	244	185	java/lang/Exception
    //   28	41	207	finally
    //   208	210	207	finally
    //   72	91	249	finally
    //   91	142	249	finally
    //   142	182	249	finally
    //   186	202	249	finally
    //   212	240	249	finally
    //   240	244	249	finally
  }
  
  /* Error */
  public void saveAioPushData(List<AioPushData> paramList, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +19 -> 20
    //   4: aload_1
    //   5: invokeinterface 203 1 0
    //   10: ifeq +10 -> 20
    //   13: aload_0
    //   14: getfield 362	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: new 80	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 81	java/util/ArrayList:<init>	()V
    //   28: astore 5
    //   30: aload_0
    //   31: getfield 116	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mAioPushDataList	Ljava/util/List;
    //   34: ifnull +274 -> 308
    //   37: aload_0
    //   38: getfield 116	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mAioPushDataList	Ljava/util/List;
    //   41: astore 6
    //   43: aload 6
    //   45: monitorenter
    //   46: aload_1
    //   47: invokestatic 1187	java/util/Collections:sort	(Ljava/util/List;)V
    //   50: invokestatic 303	java/lang/System:currentTimeMillis	()J
    //   53: ldc2_w 304
    //   56: ldiv
    //   57: l2i
    //   58: istore_3
    //   59: aload_1
    //   60: invokeinterface 178 1 0
    //   65: astore 7
    //   67: aload 7
    //   69: invokeinterface 184 1 0
    //   74: ifeq +231 -> 305
    //   77: aload 7
    //   79: invokeinterface 188 1 0
    //   84: checkcast 307	com/tencent/mobileqq/data/AioPushData
    //   87: astore 8
    //   89: aload 8
    //   91: ifnull -24 -> 67
    //   94: aload 8
    //   96: getfield 313	com/tencent/mobileqq/data/AioPushData:begTs	I
    //   99: aload 8
    //   101: getfield 310	com/tencent/mobileqq/data/AioPushData:endTs	I
    //   104: if_icmpgt -37 -> 67
    //   107: aload 8
    //   109: getfield 310	com/tencent/mobileqq/data/AioPushData:endTs	I
    //   112: iload_3
    //   113: if_icmple -46 -> 67
    //   116: aload 8
    //   118: getfield 606	com/tencent/mobileqq/data/AioPushData:isShow	Z
    //   121: ifne -54 -> 67
    //   124: aload_0
    //   125: getfield 116	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mAioPushDataList	Ljava/util/List;
    //   128: aload 8
    //   130: invokeinterface 916 2 0
    //   135: istore 4
    //   137: iload 4
    //   139: iflt +66 -> 205
    //   142: aload_0
    //   143: getfield 116	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mAioPushDataList	Ljava/util/List;
    //   146: iload 4
    //   148: invokeinterface 207 2 0
    //   153: checkcast 307	com/tencent/mobileqq/data/AioPushData
    //   156: astore 9
    //   158: aload 9
    //   160: ifnull +26 -> 186
    //   163: aload 9
    //   165: getfield 606	com/tencent/mobileqq/data/AioPushData:isShow	Z
    //   168: ifeq +18 -> 186
    //   171: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +12 -> 186
    //   177: ldc 12
    //   179: iconst_2
    //   180: ldc_w 1189
    //   183: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: aload 5
    //   188: aload 8
    //   190: invokeinterface 316 2 0
    //   195: pop
    //   196: goto -129 -> 67
    //   199: astore_1
    //   200: aload 6
    //   202: monitorexit
    //   203: aload_1
    //   204: athrow
    //   205: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq +30 -> 238
    //   211: ldc 12
    //   213: iconst_2
    //   214: new 280	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   221: ldc_w 1191
    //   224: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload 8
    //   229: invokevirtual 1101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   238: iload_2
    //   239: iconst_1
    //   240: if_icmpne +38 -> 278
    //   243: aload_0
    //   244: getfield 362	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   247: getstatic 1194	com/tencent/mobileqq/app/QQManagerFactory:HOTCHAT_CENTER_MANAGER	I
    //   250: invokevirtual 824	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   253: checkcast 1196	com/tencent/mobileqq/app/HotChatCenterManager
    //   256: astore 9
    //   258: aload 9
    //   260: ifnull +33 -> 293
    //   263: aload 9
    //   265: aload 8
    //   267: getfield 600	com/tencent/mobileqq/data/AioPushData:them	Ljava/lang/String;
    //   270: aload 8
    //   272: getfield 1199	com/tencent/mobileqq/data/AioPushData:wording	Ljava/lang/String;
    //   275: invokevirtual 1202	com/tencent/mobileqq/app/HotChatCenterManager:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: aload_0
    //   279: getfield 116	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mAioPushDataList	Ljava/util/List;
    //   282: aload 8
    //   284: invokeinterface 316 2 0
    //   289: pop
    //   290: goto -223 -> 67
    //   293: ldc 12
    //   295: iconst_1
    //   296: ldc_w 1204
    //   299: invokestatic 507	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: goto -24 -> 278
    //   305: aload 6
    //   307: monitorexit
    //   308: aload_0
    //   309: getfield 362	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   312: invokevirtual 367	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   315: invokevirtual 370	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   318: astore 7
    //   320: aload 7
    //   322: ifnull +104 -> 426
    //   325: aload 7
    //   327: invokevirtual 374	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   330: astore 6
    //   332: aload 6
    //   334: invokevirtual 379	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   337: aload 5
    //   339: invokeinterface 203 1 0
    //   344: ifle +12 -> 356
    //   347: aload_1
    //   348: aload 5
    //   350: invokeinterface 324 2 0
    //   355: pop
    //   356: aload_1
    //   357: invokeinterface 178 1 0
    //   362: astore_1
    //   363: aload_1
    //   364: invokeinterface 184 1 0
    //   369: ifeq +62 -> 431
    //   372: aload_0
    //   373: aload 7
    //   375: aload_1
    //   376: invokeinterface 188 1 0
    //   381: checkcast 307	com/tencent/mobileqq/data/AioPushData
    //   384: invokevirtual 390	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   387: pop
    //   388: goto -25 -> 363
    //   391: astore_1
    //   392: ldc 12
    //   394: iconst_1
    //   395: new 280	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   402: ldc_w 1206
    //   405: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload_1
    //   409: invokevirtual 999	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   412: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 507	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: aload 6
    //   423: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   426: aload_0
    //   427: invokespecial 1208	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:removeInvalidAioPushData	()V
    //   430: return
    //   431: aload 6
    //   433: invokevirtual 418	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   436: aload 6
    //   438: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   441: goto -15 -> 426
    //   444: astore_1
    //   445: aload 6
    //   447: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   450: aload_1
    //   451: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	452	0	this	ApolloDaoManagerServiceImpl
    //   0	452	1	paramList	List<AioPushData>
    //   0	452	2	paramInt	int
    //   58	56	3	i	int
    //   135	12	4	j	int
    //   28	321	5	localArrayList	ArrayList
    //   41	405	6	localObject1	Object
    //   65	309	7	localObject2	Object
    //   87	196	8	localAioPushData	AioPushData
    //   156	108	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   46	67	199	finally
    //   67	89	199	finally
    //   94	137	199	finally
    //   142	158	199	finally
    //   163	186	199	finally
    //   186	196	199	finally
    //   200	203	199	finally
    //   205	238	199	finally
    //   243	258	199	finally
    //   263	278	199	finally
    //   278	290	199	finally
    //   293	302	199	finally
    //   305	308	199	finally
    //   337	356	391	java/lang/Exception
    //   356	363	391	java/lang/Exception
    //   363	388	391	java/lang/Exception
    //   431	436	391	java/lang/Exception
    //   337	356	444	finally
    //   356	363	444	finally
    //   363	388	444	finally
    //   392	421	444	finally
    //   431	436	444	finally
  }
  
  /* Error */
  public void saveGameRoamData(ArrayList<ApolloGameRoamData> paramArrayList)
  {
    // Byte code:
    //   0: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 12
    //   8: iconst_2
    //   9: ldc_w 1212
    //   12: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +10 -> 26
    //   19: aload_1
    //   20: invokevirtual 1153	java/util/ArrayList:size	()I
    //   23: ifne +13 -> 36
    //   26: ldc 12
    //   28: iconst_1
    //   29: ldc_w 1214
    //   32: invokestatic 815	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: return
    //   36: ldc 12
    //   38: iconst_1
    //   39: new 280	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   46: ldc_w 1216
    //   49: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_1
    //   53: invokevirtual 1153	java/util/ArrayList:size	()I
    //   56: invokevirtual 290	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 781	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: aload_0
    //   66: getfield 99	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:gameRoamList	Ljava/util/List;
    //   69: ifnull +29 -> 98
    //   72: aload_0
    //   73: getfield 99	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:gameRoamList	Ljava/util/List;
    //   76: astore_2
    //   77: aload_2
    //   78: monitorenter
    //   79: aload_0
    //   80: getfield 99	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:gameRoamList	Ljava/util/List;
    //   83: iconst_0
    //   84: aload_1
    //   85: invokeinterface 215 3 0
    //   90: pop
    //   91: aload_0
    //   92: aload_1
    //   93: invokevirtual 1219	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:saveTabGameRoamList	(Ljava/util/List;)V
    //   96: aload_2
    //   97: monitorexit
    //   98: aload_0
    //   99: getfield 362	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   102: ifnull -67 -> 35
    //   105: aload_0
    //   106: getfield 362	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   109: invokevirtual 367	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   112: invokevirtual 370	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   115: astore_3
    //   116: aload_3
    //   117: ifnull -82 -> 35
    //   120: aload_3
    //   121: invokevirtual 374	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   124: astore_2
    //   125: aload_2
    //   126: invokevirtual 379	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   129: new 280	java/lang/StringBuilder
    //   132: dup
    //   133: sipush 500
    //   136: invokespecial 382	java/lang/StringBuilder:<init>	(I)V
    //   139: astore 4
    //   141: aload_1
    //   142: invokevirtual 851	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   145: astore_1
    //   146: aload_1
    //   147: invokeinterface 184 1 0
    //   152: ifeq +75 -> 227
    //   155: aload_1
    //   156: invokeinterface 188 1 0
    //   161: checkcast 190	com/tencent/mobileqq/apollo/api/model/ApolloGameRoamData
    //   164: astore 5
    //   166: aload_0
    //   167: aload_3
    //   168: aload 5
    //   170: invokevirtual 390	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   173: pop
    //   174: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq -31 -> 146
    //   180: aload 4
    //   182: ldc_w 1221
    //   185: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload 5
    //   190: getfield 786	com/tencent/mobileqq/apollo/api/model/ApolloGameRoamData:gameId	I
    //   193: invokevirtual 290	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: goto -51 -> 146
    //   200: astore_1
    //   201: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq +13 -> 217
    //   207: ldc 12
    //   209: iconst_2
    //   210: ldc_w 1223
    //   213: aload_1
    //   214: invokestatic 1165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   217: aload_2
    //   218: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   221: return
    //   222: astore_1
    //   223: aload_2
    //   224: monitorexit
    //   225: aload_1
    //   226: athrow
    //   227: aload 4
    //   229: invokevirtual 396	java/lang/StringBuilder:length	()I
    //   232: sipush 500
    //   235: if_icmpge +20 -> 255
    //   238: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +14 -> 255
    //   244: ldc 12
    //   246: iconst_2
    //   247: aload 4
    //   249: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: aload_2
    //   256: invokevirtual 418	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   259: aload_2
    //   260: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   263: return
    //   264: astore_1
    //   265: aload_2
    //   266: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   269: aload_1
    //   270: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	ApolloDaoManagerServiceImpl
    //   0	271	1	paramArrayList	ArrayList<ApolloGameRoamData>
    //   76	190	2	localObject	Object
    //   115	53	3	localEntityManager	EntityManager
    //   139	109	4	localStringBuilder	StringBuilder
    //   164	25	5	localApolloGameRoamData	ApolloGameRoamData
    // Exception table:
    //   from	to	target	type
    //   129	146	200	java/lang/Exception
    //   146	197	200	java/lang/Exception
    //   227	255	200	java/lang/Exception
    //   255	259	200	java/lang/Exception
    //   79	98	222	finally
    //   223	225	222	finally
    //   129	146	264	finally
    //   146	197	264	finally
    //   201	217	264	finally
    //   227	255	264	finally
    //   255	259	264	finally
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
        QLog.e("ApolloDaoManager", 1, "[saveApolloObtainedActionList] Exception =", paramJSONArray);
        return;
      }
      i += 1;
    }
  }
  
  public void savePackageInfo(List<ApolloActionPackage> paramList)
  {
    int i = 0;
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    if (this.packageList != null) {}
    for (;;)
    {
      EntityManager localEntityManager;
      synchronized (this.packageList)
      {
        if ((paramList.size() == 1) && (paramList.get(0) != null) && (((ApolloActionPackage)paramList.get(0)).packageId == 100)) {
          if (i < this.packageList.size())
          {
            if (((ApolloActionPackage)this.packageList.get(i)).packageId == 100)
            {
              this.packageList.remove(i);
              QLog.i("ApolloDaoManager", 1, "repeat game package.");
            }
          }
          else
          {
            this.packageList.add(0, paramList.get(0));
            if (QLog.isColorLevel()) {
              QLog.d("ApolloDaoManager", 2, "add game package.");
            }
            if (this.mApp == null) {
              break;
            }
            localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
            if (localEntityManager == null) {
              break;
            }
            ??? = localEntityManager.getTransaction();
            ((EntityTransaction)???).begin();
          }
        }
      }
      try
      {
        localStringBuilder = new StringBuilder(200);
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)paramList.next();
          updateEntity(localEntityManager, localApolloActionPackage);
          localStringBuilder.append(" savePackage ID:").append(localApolloActionPackage.packageId);
          if (localStringBuilder.length() >= 200)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloDaoManager", 2, localStringBuilder.toString());
            }
            localStringBuilder.delete(0, localStringBuilder.length());
          }
        }
      }
      catch (Exception paramList)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "saveAction exception: ", paramList);
        }
        return;
        i += 1;
        continue;
        this.packageList.addAll(paramList);
        continue;
        paramList = finally;
        throw paramList;
        if ((localStringBuilder.length() < 200) && (QLog.isColorLevel())) {
          QLog.d("ApolloDaoManager", 2, localStringBuilder.toString());
        }
        ((EntityTransaction)???).commit();
        return;
      }
      finally
      {
        ((EntityTransaction)???).end();
      }
    }
  }
  
  /* Error */
  public void savePreDownloadRes(Map<String, ApolloPreDownloadData> paramMap, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifeq +10 -> 11
    //   4: aload_0
    //   5: getfield 128	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mPreDownloadMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   8: invokevirtual 415	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   11: aload_0
    //   12: getfield 128	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mPreDownloadMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   15: aload_1
    //   16: invokevirtual 1264	java/util/concurrent/ConcurrentHashMap:putAll	(Ljava/util/Map;)V
    //   19: aload_0
    //   20: getfield 362	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   23: invokevirtual 367	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   26: invokevirtual 370	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   29: astore 4
    //   31: aload 4
    //   33: ifnull +79 -> 112
    //   36: aload 4
    //   38: invokevirtual 374	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   41: astore_3
    //   42: aload_3
    //   43: invokevirtual 379	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   46: iload_2
    //   47: ifeq +12 -> 59
    //   50: aload 4
    //   52: ldc_w 1266
    //   55: invokevirtual 1090	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   58: pop
    //   59: aload_1
    //   60: invokeinterface 1272 1 0
    //   65: invokeinterface 1275 1 0
    //   70: astore_1
    //   71: aload_1
    //   72: invokeinterface 184 1 0
    //   77: ifeq +36 -> 113
    //   80: aload 4
    //   82: aload_1
    //   83: invokeinterface 188 1 0
    //   88: checkcast 834	com/tencent/mobileqq/apollo/api/model/ApolloPreDownloadData
    //   91: invokevirtual 258	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   94: goto -23 -> 71
    //   97: astore_1
    //   98: ldc 12
    //   100: iconst_1
    //   101: ldc_w 1277
    //   104: aload_1
    //   105: invokestatic 406	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   108: aload_3
    //   109: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   112: return
    //   113: aload_3
    //   114: invokevirtual 418	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   117: aload_3
    //   118: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   121: return
    //   122: astore_1
    //   123: aload_3
    //   124: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   127: aload_1
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	ApolloDaoManagerServiceImpl
    //   0	129	1	paramMap	Map<String, ApolloPreDownloadData>
    //   0	129	2	paramBoolean	boolean
    //   41	83	3	localEntityTransaction	EntityTransaction
    //   29	52	4	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   50	59	97	java/lang/Exception
    //   59	71	97	java/lang/Exception
    //   71	94	97	java/lang/Exception
    //   113	117	97	java/lang/Exception
    //   50	59	122	finally
    //   59	71	122	finally
    //   71	94	122	finally
    //   98	108	122	finally
    //   113	117	122	finally
  }
  
  /* Error */
  public void saveRecommendActionList(List<ApolloRecommendAction> paramList)
  {
    // Byte code:
    //   0: ldc 12
    //   2: iconst_1
    //   3: ldc_w 1280
    //   6: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_0
    //   10: getfield 362	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   13: ifnull +16 -> 29
    //   16: aload_1
    //   17: ifnull +12 -> 29
    //   20: aload_1
    //   21: invokeinterface 203 1 0
    //   26: ifne +4 -> 30
    //   29: return
    //   30: aload_0
    //   31: getfield 132	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mRecommendActionList	Ljava/util/List;
    //   34: astore_2
    //   35: aload_2
    //   36: monitorenter
    //   37: aload_0
    //   38: getfield 132	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mRecommendActionList	Ljava/util/List;
    //   41: invokeinterface 412 1 0
    //   46: aload_0
    //   47: getfield 132	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mRecommendActionList	Ljava/util/List;
    //   50: aload_1
    //   51: invokeinterface 414 2 0
    //   56: pop
    //   57: aload_2
    //   58: monitorexit
    //   59: aload_0
    //   60: getfield 362	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   63: invokevirtual 367	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   66: invokevirtual 370	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   69: astore_3
    //   70: aload_3
    //   71: ifnull -42 -> 29
    //   74: aload_3
    //   75: invokevirtual 374	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   78: astore_2
    //   79: aload_2
    //   80: invokevirtual 379	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   83: aload_1
    //   84: invokeinterface 178 1 0
    //   89: astore_1
    //   90: aload_1
    //   91: invokeinterface 184 1 0
    //   96: ifeq +42 -> 138
    //   99: aload_0
    //   100: aload_3
    //   101: aload_1
    //   102: invokeinterface 188 1 0
    //   107: checkcast 861	com/tencent/mobileqq/apollo/api/model/ApolloRecommendAction
    //   110: invokevirtual 390	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   113: pop
    //   114: goto -24 -> 90
    //   117: astore_1
    //   118: ldc 12
    //   120: iconst_1
    //   121: ldc_w 1282
    //   124: aload_1
    //   125: invokestatic 406	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_2
    //   129: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   132: return
    //   133: astore_1
    //   134: aload_2
    //   135: monitorexit
    //   136: aload_1
    //   137: athrow
    //   138: aload_2
    //   139: invokevirtual 418	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   142: aload_2
    //   143: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   146: return
    //   147: astore_1
    //   148: aload_2
    //   149: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   152: aload_1
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	ApolloDaoManagerServiceImpl
    //   0	154	1	paramList	List<ApolloRecommendAction>
    //   34	115	2	localObject	Object
    //   69	32	3	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   83	90	117	java/lang/Exception
    //   90	114	117	java/lang/Exception
    //   138	142	117	java/lang/Exception
    //   37	59	133	finally
    //   134	136	133	finally
    //   83	90	147	finally
    //   90	114	147	finally
    //   118	128	147	finally
    //   138	142	147	finally
  }
  
  public void saveTabGameRoamList(List<ApolloGameRoamData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ApolloGameRoamData localApolloGameRoamData = (ApolloGameRoamData)paramList.next();
        if ((!TextUtils.isEmpty(localApolloGameRoamData.tagUrl)) && (this.mTabGameRoamMap != null)) {
          this.mTabGameRoamMap.put(Integer.valueOf(localApolloGameRoamData.gameId), localApolloGameRoamData);
        }
      }
    }
  }
  
  public boolean saveUserPlayedGameRoamData(ArrayList<ApolloGameRoamData> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, new Object[] { "[saveUserPlayedGameRoamData] userPlayedList=", paramArrayList });
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0) || (this.mApp == null)) {
      return false;
    }
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      localObject1 = (ApolloGameRoamData)paramArrayList.get(i);
      ((ApolloGameRoamData)localObject1).type = 2;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDaoManager", 2, new Object[] { "[saveUserPlayedGameRoamData] userPlayedList[", Integer.valueOf(i), "], gameId=", Integer.valueOf(((ApolloGameRoamData)localObject1).gameId) });
      }
      i += 1;
    }
    ??? = new ArrayList();
    Object localObject1 = null;
    if (this.gameRoamList != null) {}
    label691:
    label749:
    label878:
    label887:
    for (;;)
    {
      Object localObject4;
      int k;
      ApolloGameRoamData localApolloGameRoamData1;
      synchronized (this.gameRoamList)
      {
        if (this.gameRoamList.size() > 0)
        {
          localObject1 = new ArrayList();
          int m = paramArrayList.size();
          j = 0;
          i = 0;
          if (j < m)
          {
            localObject4 = (ApolloGameRoamData)paramArrayList.get(j);
            int n = this.gameRoamList.size();
            k = 0;
            i = 0;
            if (k >= n) {
              break label871;
            }
            localApolloGameRoamData1 = (ApolloGameRoamData)this.gameRoamList.get(k);
            if (((ApolloGameRoamData)localObject4).gameId == localApolloGameRoamData1.gameId)
            {
              localApolloGameRoamData1.type = 2;
              ((ArrayList)???).add(localApolloGameRoamData1);
              break label871;
            }
            if (k == n - 1) {
              ((ArrayList)localObject1).add(localObject4);
            }
            if (TextUtils.isEmpty(localApolloGameRoamData1.tagUrl)) {
              break label862;
            }
            i += 1;
            break label878;
          }
          if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
            break label887;
          }
          k = ((ArrayList)localObject1).size();
          j = 0;
          if (j >= k) {
            break label887;
          }
          localObject4 = (ApolloGameRoamData)((ArrayList)localObject1).get(j);
          this.gameRoamList.add(j + i, localObject4);
          j += 1;
          continue;
          localObject4 = this.mApp.getEntityManagerFactory().createEntityManager();
          if (localObject4 == null) {
            break label691;
          }
          ??? = ((EntityManager)localObject4).getTransaction();
          ((EntityTransaction)???).begin();
          if (localObject1 == null) {
            break label749;
          }
        }
      }
      try
      {
        if (((ArrayList)localObject1).size() > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "[saveUserPlayedGameRoamData] clear and rewrite game list");
          }
          ((EntityManager)localObject4).execSQL(" DELETE FROM ApolloGameRoamData ");
          if (this.gameRoamList != null) {}
          synchronized (this.gameRoamList)
          {
            paramArrayList = new ArrayList(this.gameRoamList.size());
            paramArrayList.addAll(this.gameRoamList);
            ??? = new StringBuilder();
            j = paramArrayList.size();
            i = 0;
            for (;;)
            {
              if (i < j)
              {
                localApolloGameRoamData1 = (ApolloGameRoamData)paramArrayList.get(i);
                ApolloGameRoamData localApolloGameRoamData2 = new ApolloGameRoamData();
                localApolloGameRoamData2.gameId = localApolloGameRoamData1.gameId;
                localApolloGameRoamData2.type = localApolloGameRoamData1.type;
                localApolloGameRoamData2.tagUrl = localApolloGameRoamData1.tagUrl;
                localApolloGameRoamData2.tagType = localApolloGameRoamData1.tagType;
                localApolloGameRoamData2.tagBegTs = localApolloGameRoamData1.tagBegTs;
                localApolloGameRoamData2.tagEndTs = localApolloGameRoamData1.tagEndTs;
                updateEntity((EntityManager)localObject4, localApolloGameRoamData2);
                ((StringBuilder)???).append("gameId:").append(localApolloGameRoamData2.gameId).append(",type:").append(localApolloGameRoamData2.type).append(",");
                i += 1;
                continue;
                addApolloGameRoamDataListFirst(this.gameRoamList, paramArrayList);
                ((ArrayList)???).addAll(paramArrayList);
                saveTabGameRoamList(paramArrayList);
                break;
                paramArrayList = finally;
                throw paramArrayList;
              }
            }
          }
        }
        return false;
      }
      catch (Exception paramArrayList)
      {
        QLog.e("ApolloDaoManager", 1, "[saveUserPlayedGameRoamData] update db error=", paramArrayList);
        ((EntityTransaction)???).end();
        if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
        {
          return true;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, new Object[] { "[saveUserPlayedGameRoamData] add game ", ((StringBuilder)???).toString() });
          }
          for (;;)
          {
            ((EntityTransaction)???).commit();
            ((EntityTransaction)???).end();
            break;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloDaoManager", 2, "[saveUserPlayedGameRoamData] just update type");
            }
            paramArrayList = ((ArrayList)???).iterator();
            while (paramArrayList.hasNext())
            {
              ??? = (ApolloGameRoamData)paramArrayList.next();
              updateEntity((EntityManager)localObject4, (Entity)???);
              if (QLog.isColorLevel()) {
                QLog.d("ApolloDaoManager", 2, new Object[] { "[saveUserPlayedGameRoamData] update game, id=", Integer.valueOf(((ApolloGameRoamData)???).gameId), ", type=", Integer.valueOf(((ApolloGameRoamData)???).type) });
              }
            }
          }
        }
      }
      finally
      {
        ((EntityTransaction)???).end();
      }
      break label878;
      localObject1 = null;
      continue;
      j += 1;
      continue;
      k += 1;
    }
  }
  
  public void saveWhiteFaceIdMapping(boolean paramBoolean, List<ApolloWhiteFaceID> paramList)
  {
    if (this.mApp == null) {
      return;
    }
    Object localObject = this.mApp.getEntityManagerFactory().createEntityManager();
    if (localObject == null)
    {
      QLog.e("ApolloDaoManager", 1, "saveWhiteFaceIdMapping err em");
      return;
    }
    EntityTransaction localEntityTransaction = ((EntityManager)localObject).getTransaction();
    localEntityTransaction.begin();
    if (paramBoolean) {}
    try
    {
      paramList = ((EntityManager)localObject).query(ApolloWhiteFaceID.class);
      if (paramList != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, new Object[] { "saveWhiteFaceIdMapping init size:", Integer.valueOf(paramList.size()) });
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (ApolloWhiteFaceID)paramList.next();
          this.mWhiteFaceIdMapping.put(Integer.valueOf(((ApolloWhiteFaceID)localObject).terminalId), localObject);
        }
      }
    }
    catch (Exception paramList)
    {
      QLog.e("ApolloDaoManager", 1, "saveWhiteFaceIdMapping exception: ", paramList);
      return;
      if (paramList != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, new Object[] { "saveWhiteFaceIdMapping save size:", Integer.valueOf(paramList.size()) });
        }
        ((EntityManager)localObject).execSQL(" DELETE FROM ApolloWhiteFaceID ");
        this.mWhiteFaceIdMapping.clear();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          ApolloWhiteFaceID localApolloWhiteFaceID = (ApolloWhiteFaceID)paramList.next();
          this.mWhiteFaceIdMapping.put(Integer.valueOf(localApolloWhiteFaceID.terminalId), localApolloWhiteFaceID);
          ((EntityManager)localObject).persist(localApolloWhiteFaceID);
        }
      }
    }
    finally
    {
      localEntityTransaction.end();
    }
    localEntityTransaction.end();
  }
  
  public void updateAction(ApolloActionData paramApolloActionData)
  {
    if ((paramApolloActionData == null) || (this.mApp == null)) {}
    for (;;)
    {
      return;
      if (this.actionList != null) {}
      synchronized (this.actionList)
      {
        int i = this.actionList.size() - 1;
        if (i >= 0)
        {
          if ((this.actionList.get(i) != null) && (((ApolloActionData)this.actionList.get(i)).actionId == paramApolloActionData.actionId))
          {
            this.actionList.remove(i);
            this.actionList.add(i, paramApolloActionData);
          }
        }
        else
        {
          if (this.mApp == null) {
            continue;
          }
          ??? = this.mApp.getEntityManagerFactory().createEntityManager();
          if (??? == null) {
            continue;
          }
          ((EntityManager)???).update(paramApolloActionData);
          return;
        }
        i -= 1;
      }
    }
  }
  
  /* Error */
  public void updateAllKapuTipsFromTianshu(List<ApolloKapuEntranceTips> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 12
    //   10: iconst_2
    //   11: ldc_w 1336
    //   14: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 362	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   21: astore_3
    //   22: aload_3
    //   23: ifnonnull +6 -> 29
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 362	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   33: invokevirtual 367	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   36: invokevirtual 370	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   39: astore 4
    //   41: new 80	java/util/ArrayList
    //   44: dup
    //   45: invokespecial 81	java/util/ArrayList:<init>	()V
    //   48: astore_3
    //   49: aload 4
    //   51: ifnull +66 -> 117
    //   54: aload 4
    //   56: ldc_w 689
    //   59: invokevirtual 534	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   62: astore 5
    //   64: aload 5
    //   66: ifnull +51 -> 117
    //   69: aload 5
    //   71: invokeinterface 203 1 0
    //   76: ifle +41 -> 117
    //   79: ldc 12
    //   81: iconst_1
    //   82: iconst_2
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: ldc_w 1338
    //   91: aastore
    //   92: dup
    //   93: iconst_1
    //   94: aload 5
    //   96: invokeinterface 203 1 0
    //   101: invokestatic 350	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   104: aastore
    //   105: invokestatic 459	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   108: aload_3
    //   109: aload 5
    //   111: invokeinterface 414 2 0
    //   116: pop
    //   117: new 80	java/util/ArrayList
    //   120: dup
    //   121: invokespecial 81	java/util/ArrayList:<init>	()V
    //   124: astore 5
    //   126: aload_1
    //   127: ifnull +169 -> 296
    //   130: aload_1
    //   131: invokeinterface 203 1 0
    //   136: ifle +160 -> 296
    //   139: ldc 12
    //   141: iconst_1
    //   142: iconst_2
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: ldc_w 1340
    //   151: aastore
    //   152: dup
    //   153: iconst_1
    //   154: aload_1
    //   155: invokeinterface 203 1 0
    //   160: invokestatic 350	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: aastore
    //   164: invokestatic 459	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   167: aload_1
    //   168: invokeinterface 178 1 0
    //   173: astore_1
    //   174: aload_1
    //   175: invokeinterface 184 1 0
    //   180: ifeq +116 -> 296
    //   183: aload_1
    //   184: invokeinterface 188 1 0
    //   189: checkcast 689	com/tencent/mobileqq/apollo/api/model/ApolloKapuEntranceTips
    //   192: astore 6
    //   194: aload_3
    //   195: invokeinterface 178 1 0
    //   200: astore 7
    //   202: aload 7
    //   204: invokeinterface 184 1 0
    //   209: ifeq +358 -> 567
    //   212: aload 7
    //   214: invokeinterface 188 1 0
    //   219: checkcast 689	com/tencent/mobileqq/apollo/api/model/ApolloKapuEntranceTips
    //   222: astore 8
    //   224: aload 6
    //   226: getfield 1343	com/tencent/mobileqq/apollo/api/model/ApolloKapuEntranceTips:adId	I
    //   229: aload 8
    //   231: getfield 1343	com/tencent/mobileqq/apollo/api/model/ApolloKapuEntranceTips:adId	I
    //   234: if_icmpne -32 -> 202
    //   237: iconst_1
    //   238: istore_2
    //   239: iload_2
    //   240: ifne -66 -> 174
    //   243: aload 6
    //   245: invokevirtual 692	com/tencent/mobileqq/apollo/api/model/ApolloKapuEntranceTips:isValid	()Z
    //   248: ifeq -74 -> 174
    //   251: aload 5
    //   253: aload 6
    //   255: invokeinterface 316 2 0
    //   260: pop
    //   261: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq -90 -> 174
    //   267: ldc 12
    //   269: iconst_1
    //   270: iconst_2
    //   271: anewarray 4	java/lang/Object
    //   274: dup
    //   275: iconst_0
    //   276: ldc_w 1345
    //   279: aastore
    //   280: dup
    //   281: iconst_1
    //   282: aload 6
    //   284: aastore
    //   285: invokestatic 459	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   288: goto -114 -> 174
    //   291: astore_1
    //   292: aload_0
    //   293: monitorexit
    //   294: aload_1
    //   295: athrow
    //   296: ldc 12
    //   298: iconst_1
    //   299: iconst_2
    //   300: anewarray 4	java/lang/Object
    //   303: dup
    //   304: iconst_0
    //   305: ldc_w 1347
    //   308: aastore
    //   309: dup
    //   310: iconst_1
    //   311: aload 5
    //   313: invokeinterface 203 1 0
    //   318: invokestatic 350	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   321: aastore
    //   322: invokestatic 459	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   325: aload 5
    //   327: ifnull +90 -> 417
    //   330: aload 5
    //   332: invokeinterface 203 1 0
    //   337: ifle +80 -> 417
    //   340: aload 4
    //   342: invokevirtual 374	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   345: astore_1
    //   346: aload_1
    //   347: invokevirtual 379	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   350: aload 5
    //   352: invokeinterface 178 1 0
    //   357: astore 5
    //   359: aload 5
    //   361: invokeinterface 184 1 0
    //   366: ifeq +123 -> 489
    //   369: aload 5
    //   371: invokeinterface 188 1 0
    //   376: checkcast 689	com/tencent/mobileqq/apollo/api/model/ApolloKapuEntranceTips
    //   379: astore 6
    //   381: aload 4
    //   383: aload 6
    //   385: invokevirtual 1350	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   388: aload_3
    //   389: aload 6
    //   391: invokeinterface 316 2 0
    //   396: pop
    //   397: goto -38 -> 359
    //   400: astore 4
    //   402: ldc 12
    //   404: iconst_1
    //   405: ldc_w 1352
    //   408: aload 4
    //   410: invokestatic 406	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   413: aload_1
    //   414: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   417: aload_3
    //   418: invokeinterface 178 1 0
    //   423: astore_1
    //   424: aload_1
    //   425: invokeinterface 184 1 0
    //   430: ifeq +109 -> 539
    //   433: aload_1
    //   434: invokeinterface 188 1 0
    //   439: checkcast 689	com/tencent/mobileqq/apollo/api/model/ApolloKapuEntranceTips
    //   442: astore_3
    //   443: aload_3
    //   444: invokevirtual 692	com/tencent/mobileqq/apollo/api/model/ApolloKapuEntranceTips:isValid	()Z
    //   447: ifeq -23 -> 424
    //   450: aload_3
    //   451: getfield 1355	com/tencent/mobileqq/apollo/api/model/ApolloKapuEntranceTips:isInstall	Z
    //   454: ifeq +53 -> 507
    //   457: aload_0
    //   458: getfield 138	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mInstalledKapuTipsList	Ljava/util/List;
    //   461: astore 4
    //   463: aload 4
    //   465: monitorenter
    //   466: aload_0
    //   467: getfield 138	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mInstalledKapuTipsList	Ljava/util/List;
    //   470: aload_3
    //   471: invokeinterface 316 2 0
    //   476: pop
    //   477: aload 4
    //   479: monitorexit
    //   480: goto -56 -> 424
    //   483: astore_1
    //   484: aload 4
    //   486: monitorexit
    //   487: aload_1
    //   488: athrow
    //   489: aload_1
    //   490: invokevirtual 418	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   493: aload_1
    //   494: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   497: goto -80 -> 417
    //   500: astore_3
    //   501: aload_1
    //   502: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   505: aload_3
    //   506: athrow
    //   507: aload_0
    //   508: getfield 140	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mNotInstalledKapuTipsList	Ljava/util/List;
    //   511: astore 4
    //   513: aload 4
    //   515: monitorenter
    //   516: aload_0
    //   517: getfield 140	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mNotInstalledKapuTipsList	Ljava/util/List;
    //   520: aload_3
    //   521: invokeinterface 316 2 0
    //   526: pop
    //   527: aload 4
    //   529: monitorexit
    //   530: goto -106 -> 424
    //   533: astore_1
    //   534: aload 4
    //   536: monitorexit
    //   537: aload_1
    //   538: athrow
    //   539: new 1357	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$9
    //   542: dup
    //   543: aload_0
    //   544: invokespecial 1358	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$9:<init>	(Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;)V
    //   547: astore_1
    //   548: aload_0
    //   549: getfield 138	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mInstalledKapuTipsList	Ljava/util/List;
    //   552: aload_1
    //   553: invokestatic 645	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   556: aload_0
    //   557: getfield 140	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mNotInstalledKapuTipsList	Ljava/util/List;
    //   560: aload_1
    //   561: invokestatic 645	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   564: goto -538 -> 26
    //   567: iconst_0
    //   568: istore_2
    //   569: goto -330 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	572	0	this	ApolloDaoManagerServiceImpl
    //   0	572	1	paramList	List<ApolloKapuEntranceTips>
    //   238	331	2	i	int
    //   21	450	3	localObject1	Object
    //   500	21	3	localObject2	Object
    //   39	343	4	localEntityManager	EntityManager
    //   400	9	4	localException	Exception
    //   62	308	5	localObject3	Object
    //   192	198	6	localApolloKapuEntranceTips1	ApolloKapuEntranceTips
    //   200	13	7	localIterator	Iterator
    //   222	8	8	localApolloKapuEntranceTips2	ApolloKapuEntranceTips
    // Exception table:
    //   from	to	target	type
    //   2	17	291	finally
    //   17	22	291	finally
    //   29	49	291	finally
    //   54	64	291	finally
    //   69	117	291	finally
    //   117	126	291	finally
    //   130	174	291	finally
    //   174	202	291	finally
    //   202	237	291	finally
    //   243	288	291	finally
    //   296	325	291	finally
    //   330	346	291	finally
    //   413	417	291	finally
    //   417	424	291	finally
    //   424	466	291	finally
    //   487	489	291	finally
    //   493	497	291	finally
    //   501	507	291	finally
    //   507	516	291	finally
    //   537	539	291	finally
    //   539	564	291	finally
    //   346	359	400	java/lang/Exception
    //   359	397	400	java/lang/Exception
    //   489	493	400	java/lang/Exception
    //   466	480	483	finally
    //   484	487	483	finally
    //   346	359	500	finally
    //   359	397	500	finally
    //   402	413	500	finally
    //   489	493	500	finally
    //   516	530	533	finally
    //   534	537	533	finally
  }
  
  public void updateBattleGameInfo(int paramInt, List<ApolloBattleGameInfo> paramList)
  {
    if (paramList == null)
    {
      QLog.e("ApolloDaoManager", 1, "[updateBattleGameInfo] battleGameList is empty! ");
      return;
    }
    if (this.mApp == null)
    {
      QLog.e("ApolloDaoManager", 1, "[updateBattleGameInfo] mApp is null! ");
      return;
    }
    for (;;)
    {
      int i;
      EntityManager localEntityManager;
      synchronized (this.mBattleGameList)
      {
        i = this.mBattleGameList.size() - 1;
        if (i >= 0)
        {
          if (((ApolloBattleGameInfo)this.mBattleGameList.get(i)).sceneId != paramInt) {
            break label278;
          }
          this.mBattleGameList.remove(i);
          break label278;
        }
        this.mBattleGameList.addAll(paramList);
        localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
        if (localEntityManager == null) {
          break label268;
        }
        ??? = localEntityManager.getTransaction();
        ((EntityTransaction)???).begin();
      }
      try
      {
        localEntityManager.execSQL(" DELETE FROM ApolloBattleGameInfo WHERE sceneId = " + paramInt);
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          updateEntity(localEntityManager, (ApolloBattleGameInfo)paramList.next());
        }
        QLog.e("ApolloDaoManager", 1, "[updateBattleGameInfo] EntityManager is null! ");
      }
      catch (Exception paramList)
      {
        QLog.e("ApolloDaoManager", 1, "[updateBattleGameInfo] exception: ", paramList);
        return;
        paramList = finally;
        throw paramList;
        if (QLog.isColorLevel()) {
          QLog.e("ApolloDaoManager", 1, "[updateBattleGameInfo] success! sceneId: " + paramInt);
        }
        ((EntityTransaction)???).commit();
        return;
      }
      finally
      {
        ((EntityTransaction)???).end();
      }
      label268:
      return;
      label278:
      i -= 1;
    }
  }
  
  /* Error */
  public boolean updateEntity(EntityManager paramEntityManager, Entity paramEntity)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_1
    //   6: invokevirtual 1377	com/tencent/mobileqq/persistence/EntityManager:isOpen	()Z
    //   9: ifeq +72 -> 81
    //   12: aload_2
    //   13: invokevirtual 1380	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   16: sipush 1000
    //   19: if_icmpne +32 -> 51
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 1350	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   27: aload_2
    //   28: invokevirtual 1380	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   31: istore_3
    //   32: iload 5
    //   34: istore 4
    //   36: iload_3
    //   37: sipush 1001
    //   40: if_icmpne +6 -> 46
    //   43: iconst_1
    //   44: istore 4
    //   46: aload_0
    //   47: monitorexit
    //   48: iload 4
    //   50: ireturn
    //   51: aload_2
    //   52: invokevirtual 1380	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   55: sipush 1001
    //   58: if_icmpeq +13 -> 71
    //   61: aload_2
    //   62: invokevirtual 1380	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   65: sipush 1002
    //   68: if_icmpne +13 -> 81
    //   71: aload_1
    //   72: aload_2
    //   73: invokevirtual 430	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   76: istore 4
    //   78: goto -32 -> 46
    //   81: iload 5
    //   83: istore 4
    //   85: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq -42 -> 46
    //   91: ldc 12
    //   93: iconst_2
    //   94: new 280	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   101: ldc_w 1382
    //   104: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_2
    //   108: invokevirtual 1385	com/tencent/mobileqq/persistence/Entity:getTableName	()Ljava/lang/String;
    //   111: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: iload 5
    //   122: istore 4
    //   124: goto -78 -> 46
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	ApolloDaoManagerServiceImpl
    //   0	132	1	paramEntityManager	EntityManager
    //   0	132	2	paramEntity	Entity
    //   31	10	3	i	int
    //   34	89	4	bool1	boolean
    //   1	120	5	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   5	32	127	finally
    //   51	71	127	finally
    //   71	78	127	finally
    //   85	120	127	finally
  }
  
  public void updateGameInfoList(List<ApolloGameData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Object localObject2;
    StringBuilder localStringBuilder;
    Object localObject3;
    for (;;)
    {
      return;
      localObject2 = new StringBuilder();
      localStringBuilder = new StringBuilder();
      localObject3 = new ArrayList();
      if (this.gameList != null) {}
      synchronized (this.gameList)
      {
        if (this.gameList.size() == 0)
        {
          this.gameList.addAll(paramList);
          ((StringBuilder)localObject2).append("add All");
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, new Object[] { "updateGameInfoList cache:", ((StringBuilder)localObject2).toString(), ", insert:", localStringBuilder.toString() });
          }
          if (this.mApp == null) {
            continue;
          }
          localObject2 = this.mApp.getEntityManagerFactory().createEntityManager();
          if (localObject2 == null) {
            continue;
          }
          ??? = ((EntityManager)localObject2).getTransaction();
          ((EntityTransaction)???).begin();
        }
      }
    }
    for (;;)
    {
      int j;
      int k;
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("delete gameId:");
        localObject3 = ((List)localObject3).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          ApolloGameData localApolloGameData = (ApolloGameData)((Iterator)localObject3).next();
          ((EntityManager)localObject2).execSQL(" DELETE FROM ApolloGameData WHERE gameId = " + localApolloGameData.gameId);
          localStringBuilder.append(localApolloGameData.gameId).append(",");
          continue;
        }
      }
      catch (Exception paramList)
      {
        QLog.e("ApolloDaoManager", 1, "updateGameInfoList exception: ", paramList);
        return;
        ((StringBuilder)localObject2).append("repeat gameId:");
        j = 0;
        if (j >= paramList.size()) {
          break;
        }
        k = 0;
        int i = 0;
        if (k < this.gameList.size())
        {
          if (((ApolloGameData)paramList.get(j)).gameId != ((ApolloGameData)this.gameList.get(k)).gameId) {
            break label605;
          }
          ((List)localObject3).add(paramList.get(j));
          this.gameList.remove(k);
          this.gameList.add(k, paramList.get(j));
          ((StringBuilder)localObject2).append(((ApolloGameData)paramList.get(j)).gameId).append(",");
          i = 1;
          break label605;
        }
        if (i != 0) {
          break label614;
        }
        this.gameList.add(paramList.get(j));
        localStringBuilder.append(((ApolloGameData)paramList.get(j)).gameId).append(",");
        break label614;
        paramList = finally;
        throw paramList;
        localStringBuilder.append("; insert gameId:");
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          localObject3 = (ApolloGameData)paramList.next();
          updateEntity((EntityManager)localObject2, (Entity)localObject3);
          localStringBuilder.append(((ApolloGameData)localObject3).gameId).append(",");
          continue;
        }
      }
      finally
      {
        ((EntityTransaction)???).end();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDaoManager", 2, new Object[] { "updateGameInfoList db:", localStringBuilder.toString() });
      }
      ((EntityTransaction)???).commit();
      ((EntityTransaction)???).end();
      return;
      label605:
      k += 1;
      continue;
      label614:
      j += 1;
    }
  }
  
  public void updateGamePackageInfo(boolean paramBoolean)
  {
    ApolloActionPackage localApolloActionPackage = new ApolloActionPackage();
    localApolloActionPackage.packageId = 100;
    localApolloActionPackage.type = 100;
    localApolloActionPackage.isUpdate = paramBoolean;
    if (ApolloConfigUtils.c != null)
    {
      localApolloActionPackage.mIconUnselectedUrl = ApolloConfigUtils.c.optString("apImg");
      localApolloActionPackage.mIconSelectedUrl = ApolloConfigUtils.c.optString("apcImg");
      removePackageInfo(2);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localApolloActionPackage);
      savePackageInfo(localArrayList);
      return;
    }
    QLog.e("ApolloDaoManager", 1, "updateGamePackageInfo sAioGameTabContent is not ready");
    this.mIsGameTabNotReady = true;
  }
  
  /* Error */
  public void updateGameRank(EntityManager paramEntityManager, List<ApolloGameRankData> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +132 -> 133
    //   4: aload_2
    //   5: ifnull +128 -> 133
    //   8: aload_2
    //   9: invokeinterface 203 1 0
    //   14: ifle +119 -> 133
    //   17: aload_0
    //   18: getfield 124	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mRankData	Ljava/util/List;
    //   21: ifnull +112 -> 133
    //   24: aload_0
    //   25: getfield 124	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mRankData	Ljava/util/List;
    //   28: astore_3
    //   29: aload_3
    //   30: monitorenter
    //   31: aload_0
    //   32: getfield 124	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mRankData	Ljava/util/List;
    //   35: aload_2
    //   36: invokeinterface 324 2 0
    //   41: pop
    //   42: aload_0
    //   43: getfield 124	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mRankData	Ljava/util/List;
    //   46: aload_2
    //   47: invokeinterface 414 2 0
    //   52: pop
    //   53: aload_3
    //   54: monitorexit
    //   55: aload_2
    //   56: invokeinterface 178 1 0
    //   61: astore_2
    //   62: aload_2
    //   63: invokeinterface 184 1 0
    //   68: ifeq +65 -> 133
    //   71: aload_2
    //   72: invokeinterface 188 1 0
    //   77: checkcast 853	com/tencent/mobileqq/apollo/api/model/ApolloGameRankData
    //   80: astore_3
    //   81: aload_1
    //   82: aload_3
    //   83: invokevirtual 1350	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   86: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq -27 -> 62
    //   92: ldc 12
    //   94: iconst_2
    //   95: iconst_2
    //   96: anewarray 4	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: ldc_w 1131
    //   104: aastore
    //   105: dup
    //   106: iconst_1
    //   107: aload_3
    //   108: aastore
    //   109: invokestatic 459	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   112: goto -50 -> 62
    //   115: astore_1
    //   116: ldc 12
    //   118: iconst_1
    //   119: aload_1
    //   120: iconst_1
    //   121: anewarray 4	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: ldc_w 1435
    //   129: aastore
    //   130: invokestatic 1136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   133: return
    //   134: astore_1
    //   135: aload_3
    //   136: monitorexit
    //   137: aload_1
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	ApolloDaoManagerServiceImpl
    //   0	139	1	paramEntityManager	EntityManager
    //   0	139	2	paramList	List<ApolloGameRankData>
    // Exception table:
    //   from	to	target	type
    //   24	31	115	java/lang/Throwable
    //   55	62	115	java/lang/Throwable
    //   62	112	115	java/lang/Throwable
    //   137	139	115	java/lang/Throwable
    //   31	55	134	finally
    //   135	137	134	finally
  }
  
  public void updateGameScore(EntityManager paramEntityManager, List<ApolloGameScoreData> paramList)
  {
    if ((paramEntityManager != null) && (paramList != null) && (paramList.size() > 0))
    {
      if (this.mScoreData != null)
      {
        this.mScoreData.removeAll(paramList);
        this.mScoreData.addAll(paramList);
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ApolloGameScoreData localApolloGameScoreData = (ApolloGameScoreData)paramList.next();
        paramEntityManager.persistOrReplace(localApolloGameScoreData);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, new Object[] { "[updateGameScore] ", localApolloGameScoreData });
        }
      }
    }
  }
  
  public void updateKapuEntranceTips(ApolloKapuEntranceTips paramApolloKapuEntranceTips)
  {
    if ((paramApolloKapuEntranceTips == null) || (this.mApp == null)) {
      return;
    }
    QLog.d("ApolloDaoManager", 1, new Object[] { "updateKapuEntranceTips, tips=", paramApolloKapuEntranceTips });
    int i;
    if (paramApolloKapuEntranceTips.isInstall) {
      synchronized (this.mInstalledKapuTipsList)
      {
        if (paramApolloKapuEntranceTips.isValid())
        {
          i = this.mInstalledKapuTipsList.size() - 1;
          for (;;)
          {
            if (i >= 0)
            {
              if (((ApolloKapuEntranceTips)this.mInstalledKapuTipsList.get(i)).adId == paramApolloKapuEntranceTips.adId) {
                this.mInstalledKapuTipsList.set(i, paramApolloKapuEntranceTips);
              }
            }
            else
            {
              this.mApp.getEntityManagerFactory().createEntityManager().update(paramApolloKapuEntranceTips);
              return;
            }
            i -= 1;
          }
        }
        this.mInstalledKapuTipsList.remove(paramApolloKapuEntranceTips);
      }
    }
    for (;;)
    {
      synchronized (this.mNotInstalledKapuTipsList)
      {
        if (!paramApolloKapuEntranceTips.isValid()) {
          break label230;
        }
        i = this.mNotInstalledKapuTipsList.size() - 1;
        if (i >= 0)
        {
          if (((ApolloKapuEntranceTips)this.mNotInstalledKapuTipsList.get(i)).adId != paramApolloKapuEntranceTips.adId) {
            break label223;
          }
          this.mNotInstalledKapuTipsList.set(i, paramApolloKapuEntranceTips);
        }
      }
      label223:
      i -= 1;
      continue;
      label230:
      this.mNotInstalledKapuTipsList.remove(paramApolloKapuEntranceTips);
    }
  }
  
  public void updatePackage(ApolloActionPackage paramApolloActionPackage)
  {
    if ((paramApolloActionPackage == null) || (this.mApp == null)) {}
    for (;;)
    {
      return;
      if (this.packageList != null) {}
      synchronized (this.packageList)
      {
        int i = this.packageList.size() - 1;
        if (i >= 0)
        {
          if ((this.packageList.get(i) != null) && (((ApolloActionPackage)this.packageList.get(i)).packageId == paramApolloActionPackage.packageId))
          {
            this.packageList.remove(i);
            this.packageList.add(i, paramApolloActionPackage);
          }
        }
        else
        {
          if (this.mApp == null) {
            continue;
          }
          ??? = this.mApp.getEntityManagerFactory().createEntityManager();
          if (??? == null) {
            continue;
          }
          ((EntityManager)???).update(paramApolloActionPackage);
          return;
        }
        i -= 1;
      }
    }
  }
  
  public void updatePreDownloadRes(ApolloPreDownloadData paramApolloPreDownloadData)
  {
    this.mPreDownloadMap.remove(paramApolloPreDownloadData.resId);
    this.mPreDownloadMap.put(paramApolloPreDownloadData.resId, paramApolloPreDownloadData);
    EntityManager localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
    EntityTransaction localEntityTransaction;
    if (localEntityManager != null)
    {
      localEntityTransaction = localEntityManager.getTransaction();
      localEntityTransaction.begin();
    }
    try
    {
      localEntityManager.update(paramApolloPreDownloadData);
      localEntityTransaction.commit();
      return;
    }
    catch (Exception paramApolloPreDownloadData)
    {
      QLog.e("ApolloDaoManager", 1, "updatePreDownloadRes exception: ", paramApolloPreDownloadData);
      return;
    }
    finally
    {
      localEntityTransaction.end();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */