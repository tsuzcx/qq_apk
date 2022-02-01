package com.tencent.biz.pubaccount.troopbarassit;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.msg.RecentUserAppearLogic;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.repo.feeds.api.IRIJSubscriptionFeeds;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeed;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopBarAssistantManager
{
  protected int a;
  protected long a;
  protected Boolean a;
  protected Object a;
  protected String a;
  Comparator<TroopBarData> a;
  protected List<TroopBarData> a;
  protected final Map<String, TroopBarData> a;
  protected ConcurrentHashMap<String, Integer> a;
  protected boolean a;
  public int b;
  protected long b;
  protected final ConcurrentHashMap<String, PublicAccountInfo> b;
  protected boolean b;
  protected boolean c = false;
  protected boolean d = false;
  
  private TroopBarAssistantManager()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilComparator = new TroopBarAssistantManager.1(this);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private long a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return 0L;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Long = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getLong("troopbar_recent_item_last_del_time", 0L);
      this.jdField_b_of_type_Boolean = true;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getTroopBarRecentItemLastDelTime, lastDelTime:");
      paramQQAppInterface.append(this.jdField_b_of_type_Long);
      QLog.d("TroopBarAssistantManager", 2, paramQQAppInterface.toString());
    }
    return this.jdField_b_of_type_Long;
  }
  
  public static TroopBarAssistantManager a()
  {
    try
    {
      if (TroopBarAssistantManager.SingletonHolder.a == null) {
        TroopBarAssistantManager.SingletonHolder.a = new TroopBarAssistantManager();
      }
      TroopBarAssistantManager localTroopBarAssistantManager = TroopBarAssistantManager.SingletonHolder.a;
      return localTroopBarAssistantManager;
    }
    finally {}
  }
  
  private TroopBarData a(QQAppInterface arg1, String paramString)
  {
    a(???);
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (TroopBarData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
  }
  
  private TroopBarData a(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface);
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      TroopBarData localTroopBarData = (TroopBarData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      paramEntityManager = localTroopBarData;
      if (localTroopBarData == null)
      {
        localTroopBarData = new TroopBarData();
        localTroopBarData.mUin = paramString;
        paramQQAppInterface = paramQQAppInterface.getMessageFacade();
        paramEntityManager = localTroopBarData;
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(paramString, 1008);
          paramEntityManager = localTroopBarData;
          if (paramQQAppInterface != null)
          {
            localTroopBarData.mLastDraftTime = paramQQAppInterface.getTime();
            paramEntityManager = localTroopBarData;
          }
        }
      }
      return paramEntityManager;
    }
  }
  
  private List<TroopBarData> a(QQAppInterface paramQQAppInterface, List<TroopBarData> paramList)
  {
    if (paramList == null) {
      return null;
    }
    paramList = paramList.iterator();
    ArrayList localArrayList = new ArrayList();
    while (paramList.hasNext())
    {
      TroopBarData localTroopBarData = (TroopBarData)paramList.next();
      if (ServiceAccountFolderManager.a(paramQQAppInterface, localTroopBarData.mUin)) {
        localArrayList.add(localTroopBarData);
      }
    }
    return localArrayList;
  }
  
  private void a(QQAppInterface paramQQAppInterface, EntityManager arg2, TroopBarData paramTroopBarData)
  {
    if (paramTroopBarData == null) {
      return;
    }
    Object localObject = (TroopBarData)this.jdField_a_of_type_JavaUtilMap.get(paramTroopBarData.mUin);
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramTroopBarData.mUin, paramTroopBarData);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          if (localObject != null) {
            this.jdField_a_of_type_JavaUtilList.remove(localObject);
          }
          this.jdField_a_of_type_JavaUtilList.remove(paramTroopBarData);
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.size(), paramTroopBarData);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("save TroopBarData ");
            ((StringBuilder)localObject).append(paramTroopBarData.mUin);
            ((StringBuilder)localObject).append(" to dataList");
            QLog.i("TroopBarAssistantManager", 2, ((StringBuilder)localObject).toString());
          }
        }
        a();
        ??? = (ProxyManager)paramQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER);
        if (paramTroopBarData.getStatus() == 1000) {
          ???.addMsgQueue(paramQQAppInterface.getAccount(), 0, paramTroopBarData.getTableName(), paramTroopBarData, 3, null);
        } else {
          ???.addMsgQueue(paramQQAppInterface.getAccount(), 0, paramTroopBarData.getTableName(), paramTroopBarData, 4, null);
        }
        ((IKanDianMergeManager)paramQQAppInterface.getRuntimeService(IKanDianMergeManager.class)).notificationTabRedNumsChange();
        ((IKanDianMergeManager)paramQQAppInterface.getRuntimeService(IKanDianMergeManager.class)).onSubscribeMsgNotification(null);
        return;
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString, QQAppInterface paramQQAppInterface)
  {
    if (!ServiceAccountFolderManager.a(paramQQAppInterface, paramString)) {
      return;
    }
    l(paramQQAppInterface);
    if ((paramMessageRecord != null) && (!paramMessageRecord.isread))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
      {
        paramMessageRecord = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
        paramMessageRecord.put(paramString, Integer.valueOf(((Integer)paramMessageRecord.get(paramString)).intValue() + 1));
      }
      else
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(1));
      }
      if (QLog.isColorLevel())
      {
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("add uin ");
        paramMessageRecord.append(paramString);
        paramMessageRecord.append(" to newMsgMap");
        QLog.i("TroopBarAssistantManager", 2, paramMessageRecord.toString());
      }
    }
    k(paramQQAppInterface);
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    Object localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.getProxyManager().a();
    int j = 0;
    if (localObject == null) {
      return false;
    }
    int i = j;
    if (this.jdField_a_of_type_Boolean)
    {
      i = j;
      if (!this.c) {
        i = 1;
      }
    }
    if (i != 0)
    {
      localObject = localRecentUserProxy.a(AppConstants.TROOP_BAR_ASSISTANT_UIN, 7210);
      if (((RecentUser)localObject).lastmsgtime < paramLong) {
        ((RecentUser)localObject).lastmsgtime = paramLong;
      }
      if (!b(paramQQAppInterface))
      {
        TroopBarData localTroopBarData = a(paramQQAppInterface);
        if (localTroopBarData != null)
        {
          ((RecentUser)localObject).lastmsgtime = localTroopBarData.mLastMsgTime;
          ((RecentUser)localObject).lastmsgdrafttime = localTroopBarData.mLastDraftTime;
        }
      }
      localRecentUserProxy.b((RecentUser)localObject);
    }
    else
    {
      localObject = localRecentUserProxy.b(AppConstants.TROOP_BAR_ASSISTANT_UIN, 7210);
      if (localObject != null) {
        localRecentUserProxy.a((RecentUser)localObject);
      }
    }
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(1009);
    }
    return true;
  }
  
  private boolean a(EntityManager paramEntityManager, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      TroopBarData localTroopBarData = (TroopBarData)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      Object localObject2 = this.jdField_a_of_type_JavaLangObject;
      ??? = localTroopBarData;
      try
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          ??? = localTroopBarData;
          if (localTroopBarData == null)
          {
            Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
            do
            {
              ??? = localTroopBarData;
              if (!localIterator.hasNext()) {
                break;
              }
              ??? = (TroopBarData)localIterator.next();
            } while (!TextUtils.equals(((TroopBarData)???).mUin, paramString));
          }
          this.jdField_a_of_type_JavaUtilList.remove(???);
        }
        if (??? != null)
        {
          if (!paramEntityManager.remove((Entity)???))
          {
            if (QLog.isColorLevel())
            {
              paramEntityManager = new StringBuilder();
              paramEntityManager.append("remove TroopBarData ");
              paramEntityManager.append(((TroopBarData)???).mUin);
              paramEntityManager.append(" from em fail");
              QLog.i("TroopBarAssistantManager", 2, paramEntityManager.toString());
            }
          }
          else if (QLog.isColorLevel())
          {
            paramEntityManager = new StringBuilder();
            paramEntityManager.append("remove TroopBarData ");
            paramEntityManager.append(((TroopBarData)???).mUin);
            paramEntityManager.append(" from em success");
            QLog.i("TroopBarAssistantManager", 2, paramEntityManager.toString());
          }
          return true;
        }
        return false;
      }
      finally {}
    }
    for (;;)
    {
      throw paramEntityManager;
    }
  }
  
  public static void b()
  {
    try
    {
      TroopBarAssistantManager.SingletonHolder.a = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getProxyManager().a();
    paramString = paramQQAppInterface.b(paramString, 1008);
    if (paramString != null) {
      paramQQAppInterface.a(paramString);
    }
  }
  
  /* Error */
  private void b(EntityManager arg1, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 144
    //   3: iconst_0
    //   4: aconst_null
    //   5: aconst_null
    //   6: aconst_null
    //   7: aconst_null
    //   8: ldc_w 372
    //   11: aconst_null
    //   12: invokevirtual 376	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   15: astore 6
    //   17: aload 6
    //   19: ifnull +22 -> 41
    //   22: aload 6
    //   24: invokeinterface 212 1 0
    //   29: ifle +12 -> 41
    //   32: aload 6
    //   34: aload_0
    //   35: getfield 65	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:jdField_a_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   38: invokestatic 382	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   41: aload_0
    //   42: getfield 58	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   45: astore_1
    //   46: aload_1
    //   47: monitorenter
    //   48: aload_0
    //   49: aload 6
    //   51: putfield 205	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   54: aload_0
    //   55: getfield 205	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   58: ifnonnull +19 -> 77
    //   61: aload_0
    //   62: new 177	java/util/ArrayList
    //   65: dup
    //   66: bipush 15
    //   68: invokespecial 385	java/util/ArrayList:<init>	(I)V
    //   71: putfield 205	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   74: goto +214 -> 288
    //   77: aload_0
    //   78: aload_2
    //   79: invokespecial 387	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)J
    //   82: lstore 4
    //   84: iconst_0
    //   85: istore_3
    //   86: iload_3
    //   87: aload_0
    //   88: getfield 205	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   91: invokeinterface 212 1 0
    //   96: if_icmpge +192 -> 288
    //   99: aload_0
    //   100: getfield 205	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   103: iload_3
    //   104: invokeinterface 390 2 0
    //   109: checkcast 144	com/tencent/biz/pubaccount/troopbarassit/TroopBarData
    //   112: astore 6
    //   114: aload 6
    //   116: ifnonnull +32 -> 148
    //   119: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +12 -> 134
    //   125: ldc 120
    //   127: iconst_2
    //   128: ldc_w 392
    //   131: invokestatic 395	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload_0
    //   135: getfield 205	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   138: iload_3
    //   139: invokeinterface 397 2 0
    //   144: pop
    //   145: goto +254 -> 399
    //   148: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +63 -> 214
    //   154: new 108	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   161: astore 7
    //   163: aload 7
    //   165: ldc_w 399
    //   168: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 7
    //   174: aload 6
    //   176: getfield 149	com/tencent/biz/pubaccount/troopbarassit/TroopBarData:mUin	Ljava/lang/String;
    //   179: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 7
    //   185: ldc_w 401
    //   188: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 7
    //   194: aload 6
    //   196: getfield 324	com/tencent/biz/pubaccount/troopbarassit/TroopBarData:mLastMsgTime	J
    //   199: invokevirtual 118	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: ldc 120
    //   205: iconst_2
    //   206: aload 7
    //   208: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload 6
    //   216: getfield 324	com/tencent/biz/pubaccount/troopbarassit/TroopBarData:mLastMsgTime	J
    //   219: lload 4
    //   221: lcmp
    //   222: ifge +17 -> 239
    //   225: aload_0
    //   226: getfield 205	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   229: iload_3
    //   230: invokeinterface 397 2 0
    //   235: pop
    //   236: goto +163 -> 399
    //   239: aload_0
    //   240: getfield 205	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   243: iload_3
    //   244: invokeinterface 390 2 0
    //   249: checkcast 144	com/tencent/biz/pubaccount/troopbarassit/TroopBarData
    //   252: getfield 149	com/tencent/biz/pubaccount/troopbarassit/TroopBarData:mUin	Ljava/lang/String;
    //   255: astore 6
    //   257: aload_0
    //   258: getfield 205	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   261: iload_3
    //   262: invokeinterface 390 2 0
    //   267: checkcast 144	com/tencent/biz/pubaccount/troopbarassit/TroopBarData
    //   270: aload_2
    //   271: invokevirtual 153	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   274: aload 6
    //   276: sipush 1008
    //   279: invokevirtual 404	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   282: putfield 408	com/tencent/biz/pubaccount/troopbarassit/TroopBarData:mLatestMessage	Lcom/tencent/mobileqq/data/MessageRecord;
    //   285: goto +114 -> 399
    //   288: aload_1
    //   289: monitorexit
    //   290: aload_0
    //   291: getfield 70	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   294: astore_1
    //   295: aload_1
    //   296: monitorenter
    //   297: aload_0
    //   298: getfield 70	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   301: invokeinterface 411 1 0
    //   306: aload_0
    //   307: getfield 205	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   310: invokeinterface 175 1 0
    //   315: astore_2
    //   316: aload_2
    //   317: invokeinterface 183 1 0
    //   322: ifeq +34 -> 356
    //   325: aload_2
    //   326: invokeinterface 187 1 0
    //   331: checkcast 144	com/tencent/biz/pubaccount/troopbarassit/TroopBarData
    //   334: astore 6
    //   336: aload_0
    //   337: getfield 70	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   340: aload 6
    //   342: getfield 149	com/tencent/biz/pubaccount/troopbarassit/TroopBarData:mUin	Ljava/lang/String;
    //   345: aload 6
    //   347: invokeinterface 203 3 0
    //   352: pop
    //   353: goto -37 -> 316
    //   356: aload_1
    //   357: monitorexit
    //   358: return
    //   359: astore_2
    //   360: aload_1
    //   361: monitorexit
    //   362: aload_2
    //   363: athrow
    //   364: astore_2
    //   365: aload_1
    //   366: monitorexit
    //   367: aload_2
    //   368: athrow
    //   369: astore_1
    //   370: goto +21 -> 391
    //   373: astore_1
    //   374: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   377: ifeq +13 -> 390
    //   380: ldc 120
    //   382: iconst_2
    //   383: ldc_w 413
    //   386: aload_1
    //   387: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   390: return
    //   391: goto +5 -> 396
    //   394: aload_1
    //   395: athrow
    //   396: goto -2 -> 394
    //   399: iload_3
    //   400: iconst_1
    //   401: iadd
    //   402: istore_3
    //   403: goto -317 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	this	TroopBarAssistantManager
    //   0	406	2	paramQQAppInterface	QQAppInterface
    //   85	318	3	i	int
    //   82	138	4	l	long
    //   15	331	6	localObject	Object
    //   161	46	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   297	316	359	finally
    //   316	353	359	finally
    //   356	358	359	finally
    //   360	362	359	finally
    //   48	74	364	finally
    //   77	84	364	finally
    //   86	114	364	finally
    //   119	134	364	finally
    //   134	145	364	finally
    //   148	214	364	finally
    //   214	236	364	finally
    //   239	285	364	finally
    //   288	290	364	finally
    //   365	367	364	finally
    //   0	17	369	finally
    //   22	41	369	finally
    //   41	48	369	finally
    //   290	297	369	finally
    //   362	364	369	finally
    //   367	369	369	finally
    //   374	390	369	finally
    //   0	17	373	java/lang/Exception
    //   22	41	373	java/lang/Exception
    //   41	48	373	java/lang/Exception
    //   290	297	373	java/lang/Exception
    //   362	364	373	java/lang/Exception
    //   367	369	373	java/lang/Exception
  }
  
  private void d(String paramString, QQAppInterface paramQQAppInterface)
  {
    a(paramString, paramQQAppInterface, false);
  }
  
  private void e(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (!ServiceAccountFolderManager.a(paramQQAppInterface, paramString)) {
      return;
    }
    l(paramQQAppInterface);
    if (paramQQAppInterface.getConversationFacade().a(paramString, 1008) > 0) {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
      {
        ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
        localConcurrentHashMap.put(paramString, Integer.valueOf(((Integer)localConcurrentHashMap.get(paramString)).intValue() + 1));
      }
      else
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(1));
      }
    }
    k(paramQQAppInterface);
  }
  
  private void j(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      if (!paramQQAppInterface.getAccount().equals(this.jdField_a_of_type_JavaLangString)) {
        synchronized (this.jdField_a_of_type_JavaLangBoolean)
        {
          this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
        }
      }
      this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getAccount();
      ??? = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
      this.jdField_a_of_type_Boolean = ((SharedPreferences)???).getBoolean("troopbar_assist_show_in_msg", true);
      this.jdField_a_of_type_Long = ((SharedPreferences)???).getLong("troopbar_assist_last_read_time", 0L);
      this.c = ((SharedPreferences)???).getBoolean("troopbar_assist_deleted", false);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilList = null;
        l(paramQQAppInterface);
        this.jdField_b_of_type_Boolean = false;
        return;
      }
    }
  }
  
  private void k(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new TroopBarAssistantManager.2(this, paramQQAppInterface));
  }
  
  private void l(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangBoolean)
    {
      if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue())
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        Object localObject1 = paramQQAppInterface.getApp();
        Object localObject2 = paramQQAppInterface.getAccount();
        int i = 0;
        localObject1 = ((BaseApplication)localObject1).getSharedPreferences((String)localObject2, 0).getString("troopbar_assist_new_unread_list", "");
        if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("changeAccount, get newMsgStr from sp:");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.i("TroopBarAssistantManager", 2, ((StringBuilder)localObject2).toString());
        }
        try
        {
          localObject1 = new JSONArray((String)localObject1);
          while (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).getJSONObject(i);
            Iterator localIterator = ((JSONObject)localObject2).keys();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              if (ServiceAccountFolderManager.a(paramQQAppInterface, str)) {
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Integer.valueOf(((JSONObject)localObject2).getInt(str)));
              }
            }
            i += 1;
          }
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("initNewMsgMapIfNeeds:");
            ((StringBuilder)localObject1).append(paramQQAppInterface.toString());
            QLog.e("TroopBarAssistantManager", 2, ((StringBuilder)localObject1).toString());
          }
          this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
          if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isColorLevel()) {
            QLog.i("TroopBarAssistantManager", 2, "initNewMsgMapIfNeeds, succ");
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw paramQQAppInterface;
    }
  }
  
  public int a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    int j = 0;
    int i = 0;
    if (localObject != null)
    {
      localObject = ((Map)localObject).values().iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        if (((TroopBarData)((Iterator)localObject).next()).mIsSticky) {
          i += 1;
        }
      }
    }
    return j;
  }
  
  public int a(QQAppInterface arg1)
  {
    boolean bool = ???.getAccount().equals(this.jdField_a_of_type_JavaLangString);
    int j = 0;
    int i = 0;
    if (!bool) {
      return 0;
    }
    synchronized (this.jdField_a_of_type_JavaLangBoolean)
    {
      if (this.jdField_a_of_type_JavaLangBoolean.booleanValue())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        for (;;)
        {
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          i += ((Integer)localIterator.next()).intValue();
        }
      }
      return j;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return 0;
      }
      paramQQAppInterface = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.keySet().iterator();
        while (paramQQAppInterface.hasNext())
        {
          Object localObject = (String)paramQQAppInterface.next();
          if (paramString.equals(localObject))
          {
            localObject = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
            if (localObject != null) {
              return ((Integer)localObject).intValue();
            }
          }
        }
      }
    }
    return 0;
  }
  
  public TroopBarData a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    label212:
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        long l = a(paramQQAppInterface);
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          TroopBarData localTroopBarData = (TroopBarData)localIterator.next();
          if (localTroopBarData.mLastMsgTime < l)
          {
            localIterator.remove();
          }
          else
          {
            DraftSummaryInfo localDraftSummaryInfo = paramQQAppInterface.getMessageFacade().getDraftSummaryInfo(localTroopBarData.mUin, 1008);
            if (localDraftSummaryInfo != null) {
              localTroopBarData.mLastDraftTime = localDraftSummaryInfo.getTime();
            } else {
              localTroopBarData.mLastDraftTime = 0L;
            }
          }
        }
      }
      a();
      paramQQAppInterface = a(paramQQAppInterface, this.jdField_a_of_type_JavaUtilList);
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty()))
      {
        paramQQAppInterface = (TroopBarData)paramQQAppInterface.get(0);
      }
      else
      {
        if (!QLog.isColorLevel()) {
          break label212;
        }
        QLog.w("TroopBarAssistantManager", 2, "getFirstData return null");
        break label212;
      }
      return paramQQAppInterface;
    }
  }
  
  public String a(String paramString)
  {
    ConcurrentHashMap localConcurrentHashMap = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localConcurrentHashMap != null)
    {
      paramString = (PublicAccountInfo)localConcurrentHashMap.get(paramString);
      if (paramString != null) {
        return paramString.name;
      }
    }
    return "";
  }
  
  public String a(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramString = ((IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).findAccountDetailInfo(paramString);
    if (paramString != null) {
      return paramString.getName();
    }
    return "";
  }
  
  public List<TroopBarData> a(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramQQAppInterface);
    int i;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        int j = 0;
        long l = a(paramQQAppInterface);
        i = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (i >= 0)
        {
          TroopBarData localTroopBarData = (TroopBarData)this.jdField_a_of_type_JavaUtilList.get(i);
          if (localTroopBarData == null)
          {
            this.jdField_a_of_type_JavaUtilList.remove(i);
          }
          else
          {
            Object localObject2;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("getUseTroopBarAssistList==> uin:");
              ((StringBuilder)localObject2).append(localTroopBarData.mUin);
              ((StringBuilder)localObject2).append(", lastMsgTime:");
              ((StringBuilder)localObject2).append(localTroopBarData.mLastMsgTime);
              QLog.d("TroopBarAssistantManager", 2, ((StringBuilder)localObject2).toString());
            }
            if (localTroopBarData.mLastMsgTime < l)
            {
              this.jdField_a_of_type_JavaUtilList.remove(i);
            }
            else
            {
              localObject2 = paramQQAppInterface.getMessageFacade().b(localTroopBarData.mUin, 1008);
              if (localObject2 == null)
              {
                this.jdField_a_of_type_JavaUtilList.remove(i);
              }
              else if (((MessageRecord)localObject2).time > localTroopBarData.mLastMsgTime)
              {
                ((TroopBarData)this.jdField_a_of_type_JavaUtilList.get(i)).mLastMsgTime = ((MessageRecord)localObject2).time;
                j = 1;
              }
            }
          }
        }
        else
        {
          if (j != 0) {
            Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
          }
          localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
        }
      }
      else
      {
        return localArrayList;
      }
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
      }
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    int i;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        i = 1;
        if (i != 0)
        {
          ??? = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
          b((EntityManager)???, paramQQAppInterface);
          ((EntityManager)???).close();
          paramQQAppInterface = (List)((IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).getPublicAccountEqqInfoList();
          if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
          {
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
            paramQQAppInterface = paramQQAppInterface.iterator();
            while (paramQQAppInterface.hasNext())
            {
              ??? = (PublicAccountInfo)paramQQAppInterface.next();
              this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(((PublicAccountInfo)???).getUin(), ???);
            }
          }
        }
        return;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (!paramQQAppInterface.getAccount().equals(this.jdField_a_of_type_JavaLangString)) {
      j(paramQQAppInterface);
    }
    this.jdField_a_of_type_Long = paramLong;
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putLong("troopbar_assist_last_read_time", paramLong).commit();
    RecentUser localRecentUser = paramQQAppInterface.getProxyManager().a().a(AppConstants.TROOP_BAR_ASSISTANT_UIN, 7210);
    if (localRecentUser != null) {
      localRecentUser.lastmsgtime = paramLong;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isColorLevel()) {
      QLog.i("TroopBarAssistantManager", 2, "setLastReadTime, newMsgStr clear in memory");
    }
    k(paramQQAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      l(paramQQAppInterface);
      ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      if ((localConcurrentHashMap != null) && (localConcurrentHashMap.keySet().contains(paramString))) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(0));
      }
      k(paramQQAppInterface);
      RecentUtil.b(paramQQAppInterface, paramString, ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType(paramQQAppInterface, paramString));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, List<PublicAccountInfo> paramList)
  {
    if (paramQQAppInterface != null)
    {
      if (!paramQQAppInterface.getAccount().equals(this.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if (!((IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).isCached())
      {
        if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isColorLevel()) {
          QLog.w("TroopBarAssistantManager", 2, "refreshSettings but padm not cached");
        }
        return;
      }
      this.d = true;
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)paramList.next();
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPublicAccountInfo.getUin(), localPublicAccountInfo);
        }
      }
      f(paramQQAppInterface);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troopbar_assist_deleted", paramBoolean).commit();
    this.c = paramBoolean;
  }
  
  public void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (b(paramQQAppInterface))
    {
      int i;
      if ((this.jdField_a_of_type_Boolean) && (!this.c)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localObject = paramQQAppInterface.getProxyManager().a().a(AppConstants.TROOP_BAR_ASSISTANT_UIN, 7210);
        if (paramMessageRecord.time >= ((RecentUser)localObject).lastmsgtime) {
          c(paramQQAppInterface, false);
        }
      }
    }
    Object localObject = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    a(paramMessageRecord, paramMessageRecord.frienduin, paramMessageRecord.time, (EntityManager)localObject, paramQQAppInterface);
    ((EntityManager)localObject).close();
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString, long paramLong, EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    TroopBarData localTroopBarData = a(paramEntityManager, paramQQAppInterface, paramString);
    if ((paramMessageRecord != null) && (paramMessageRecord.time > paramLong))
    {
      localTroopBarData.mLastMsgTime = paramMessageRecord.time;
      localTroopBarData.mLatestMessage = paramMessageRecord;
    }
    else
    {
      localTroopBarData.mLastMsgTime = paramLong;
    }
    Message localMessage = paramQQAppInterface.getMessageFacade().getLastMessage(localTroopBarData.mUin, 1008);
    if (localMessage != null)
    {
      long l = localMessage.time;
      if (l > localTroopBarData.mLastMsgTime)
      {
        localTroopBarData.mLastMsgTime = l;
        localTroopBarData.mLatestMessage = localMessage;
      }
    }
    a(paramQQAppInterface, paramEntityManager, localTroopBarData);
    a(paramMessageRecord, paramString, paramQQAppInterface);
    if (this.c) {
      a(paramQQAppInterface, false);
    }
    b(paramQQAppInterface, paramString);
    a(paramQQAppInterface, paramLong);
  }
  
  public void a(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    try
    {
      a(paramQQAppInterface);
      RecentUserProxy localRecentUserProxy = paramQQAppInterface.getProxyManager().a();
      Object localObject2 = localRecentUserProxy.a(false);
      long l = System.currentTimeMillis() / 1000L;
      Object localObject1 = new ArrayList();
      Object localObject3;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (RecentUser)((Iterator)localObject2).next();
          if (((((RecentUser)localObject3).getType() == 1008) || (((RecentUser)localObject3).getType() == 1024)) && (a(paramQQAppInterface, ((RecentUser)localObject3).uin, ((RecentUser)localObject3).getType()))) {
            ((List)localObject1).add(localObject3);
          }
        }
      }
      if (((List)localObject1).size() > 0)
      {
        l = ((RecentUser)((List)localObject1).get(0)).lastmsgtime;
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          localObject3 = a(paramEntityManager, paramQQAppInterface, ((RecentUser)localObject2).uin);
          ((TroopBarData)localObject3).mLastDraftTime = ((RecentUser)localObject2).lastmsgdrafttime;
          if (((RecentUser)localObject2).lastmsgtime == 0L)
          {
            Message localMessage = paramQQAppInterface.getMessageFacade().getLastMessage(((TroopBarData)localObject3).mUin, 1008);
            if (localMessage != null) {
              ((TroopBarData)localObject3).mLastMsgTime = localMessage.time;
            }
          }
          else
          {
            ((TroopBarData)localObject3).mLastMsgTime = ((RecentUser)localObject2).lastmsgtime;
          }
          a(paramQQAppInterface, paramEntityManager, (TroopBarData)localObject3);
          localRecentUserProxy.a((RecentUser)localObject2);
          e(((TroopBarData)localObject3).mUin, paramQQAppInterface);
        }
      }
      ((IPublicAccountHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)).clearPublicAccountSeq();
      paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("init_troopbar_assist", false).commit();
      return;
    }
    catch (Exception paramEntityManager) {}
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (a(localEntityManager, paramString)) {
      d(paramString, paramQQAppInterface);
    }
    localEntityManager.close();
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface, Context paramContext, IPublicAccountObserver paramIPublicAccountObserver)
  {
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).unfollowUin(paramQQAppInterface, paramContext, paramString, true, paramIPublicAccountObserver);
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    l(paramQQAppInterface);
    if (((paramBoolean) || (paramQQAppInterface.getConversationFacade().a(paramString, 1008) > 0)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
    k(paramQQAppInterface);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("init_troopbar_assist", true);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
        {
          if (this.jdField_a_of_type_JavaUtilList == null)
          {
            EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
            b(localEntityManager, paramQQAppInterface);
            localEntityManager.close();
          }
        }
      }
      return this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    return (paramInt == 1008) && (ServiceAccountFolderManager.a(paramQQAppInterface, paramString));
  }
  
  public boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramString = a(paramQQAppInterface, paramString);
    if (paramString != null) {
      return paramString.mIsSticky;
    }
    return false;
  }
  
  public List<SubscriptionFeed> b(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    Object localObject1 = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject3;
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        long l = a(paramQQAppInterface);
        localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          TroopBarData localTroopBarData = (TroopBarData)((Iterator)localObject3).next();
          if (localTroopBarData == null)
          {
            ((Iterator)localObject3).remove();
          }
          else
          {
            Object localObject4 = paramQQAppInterface.getMessageFacade().b(localTroopBarData.mUin, 1008);
            if (localObject4 == null)
            {
              ((Iterator)localObject3).remove();
            }
            else
            {
              localTroopBarData.mLatestMessage = ((MessageRecord)localObject4);
              localTroopBarData.mLastMsgTime = ((MessageRecord)localObject4).time;
              localObject4 = paramQQAppInterface.getMessageFacade().getDraftSummaryInfo(localTroopBarData.mUin, 1008);
              if (localObject4 != null) {
                localTroopBarData.mLastDraftTime = ((DraftSummaryInfo)localObject4).getTime();
              } else {
                localTroopBarData.mLastDraftTime = 0L;
              }
              if (QLog.isColorLevel())
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("getUseTroopBarAssistList==> uin:");
                ((StringBuilder)localObject4).append(localTroopBarData.mUin);
                ((StringBuilder)localObject4).append(", lastMsgTime:");
                ((StringBuilder)localObject4).append(localTroopBarData.mLastMsgTime);
                ((StringBuilder)localObject4).append(", lastDraftTime: ");
                ((StringBuilder)localObject4).append(localTroopBarData.mLastDraftTime);
                QLog.d("TroopBarAssistantManager", 2, ((StringBuilder)localObject4).toString());
              }
              if (localTroopBarData.mLastMsgTime < l) {
                ((Iterator)localObject3).remove();
              }
            }
          }
        }
        a();
        ((List)localObject1).addAll(a(paramQQAppInterface, this.jdField_a_of_type_JavaUtilList));
      }
      ??? = new ArrayList(((List)localObject1).size());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (TroopBarData)((Iterator)localObject1).next();
        localObject3 = ((IRIJSubscriptionFeeds)QRoute.api(IRIJSubscriptionFeeds.class)).convertMsgToSubscriptionFeed(paramQQAppInterface.getApplicationContext(), ((TroopBarData)localObject3).mLatestMessage, ((TroopBarData)localObject3).mUin, ((TroopBarData)localObject3).mLastMsgTime, ((TroopBarData)localObject3).mLastDraftTime);
        if ((localObject3 != null) && (!((List)???).contains(localObject3))) {
          ((List)???).add(localObject3);
        }
      }
      return ???;
    }
    for (;;)
    {
      throw paramQQAppInterface;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopBarAssistManager", 2, "app == null; what happen.");
      }
      return;
    }
    if (!paramQQAppInterface.getAccount().equals(this.jdField_a_of_type_JavaLangString)) {
      j(paramQQAppInterface);
    }
    if (b(paramQQAppInterface))
    {
      c(paramQQAppInterface, false);
      b(paramQQAppInterface, false);
      a(paramQQAppInterface, NetConnInfoCenter.getServerTime());
      return;
    }
    TroopBarData localTroopBarData = a(paramQQAppInterface);
    if (localTroopBarData != null) {
      a(paramQQAppInterface, localTroopBarData.mLastMsgTime);
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("first_login", paramBoolean).commit();
  }
  
  public void b(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (TroopBarData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (paramString == null) {
        return;
      }
      paramString.mIsSticky = true;
      paramString.mLastStickyTime = (System.currentTimeMillis() / 1000L);
      ((ProxyManager)paramQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER)).addMsgQueue(paramQQAppInterface.getAccount(), 0, paramString.getTableName(), paramString, 4, null);
      a();
      paramString = paramQQAppInterface.getHandler(Conversation.class);
      if (paramString != null) {
        paramString.sendEmptyMessage(1009);
      }
      return;
    }
  }
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("subscribe_setTop_flag", false);
  }
  
  public List<PublicAccountInfo> c(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (List)((IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).getPublicAccountEqqInfoList();
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((List)localObject).iterator();
      for (;;)
      {
        localObject = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (PublicAccountInfo)localIterator.next();
        if (ServiceAccountFolderManager.a(paramQQAppInterface, ((PublicAccountInfo)localObject).getUin())) {
          localArrayList.add(localObject);
        }
      }
    }
    localObject = null;
    return localObject;
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isColorLevel()) {
      QLog.i("TroopBarAssistantManager", 2, "setFirstEnterFeeds, newMsgStr clear in memory");
    }
    k(paramQQAppInterface);
  }
  
  public void c(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("subscribe_setTop_flag", paramBoolean).commit();
  }
  
  public void c(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (TroopBarData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (paramString == null) {
        return;
      }
      paramString.mIsSticky = false;
      paramString.mLastStickyTime = 0L;
      ((ProxyManager)paramQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER)).addMsgQueue(paramQQAppInterface.getAccount(), 0, paramString.getTableName(), paramString, 4, null);
      a();
      paramString = paramQQAppInterface.getHandler(Conversation.class);
      if (paramString != null) {
        paramString.sendEmptyMessage(1009);
      }
      return;
    }
  }
  
  public boolean c(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("first_enter_subscribe_no_reset", true);
  }
  
  public void d(QQAppInterface paramQQAppInterface)
  {
    TroopBarData localTroopBarData = a(paramQQAppInterface);
    long l;
    if (localTroopBarData != null) {
      l = localTroopBarData.mLastMsgTime;
    } else {
      l = NetConnInfoCenter.getServerTime();
    }
    a(paramQQAppInterface, l);
  }
  
  public void d(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("first_enter_subscribe", paramBoolean).commit();
  }
  
  public void e(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnSubThread(new TroopBarAssistantManager.3(this, paramQQAppInterface));
  }
  
  public void e(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("first_enter_subscribe_no_reset", paramBoolean).commit();
  }
  
  public void f(QQAppInterface paramQQAppInterface)
  {
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.getProxyManager().a();
    EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    ??? = localRecentUserProxy.a(false);
    Object localObject4;
    if ((??? != null) && (((List)???).size() > 0))
    {
      ??? = ((List)???).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject4 = (RecentUser)((Iterator)???).next();
        if ((((RecentUser)localObject4).getType() == 1008) && (a(paramQQAppInterface, ((RecentUser)localObject4).uin, ((RecentUser)localObject4).getType())) && (!RecentUserAppearLogic.a(paramQQAppInterface, ((RecentUser)localObject4).msgType))) {
          ((ArrayList)localObject2).add(localObject4);
        }
      }
    }
    a(paramQQAppInterface);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject5;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject4 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (TroopBarData)((Iterator)localObject4).next();
          if (!a(paramQQAppInterface, ((TroopBarData)localObject5).mUin, 1008)) {
            ((ArrayList)localObject1).add(localObject5);
          }
        }
      }
      if (((ArrayList)localObject2).size() > 0)
      {
        if (this.c) {
          a(paramQQAppInterface, false);
        }
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ??? = (RecentUser)((Iterator)localObject2).next();
          localObject4 = a(localEntityManager, paramQQAppInterface, ((RecentUser)???).uin);
          if (((RecentUser)???).lastmsgtime == 0L)
          {
            localObject5 = paramQQAppInterface.getMessageFacade().getLastMessage(((TroopBarData)localObject4).mUin, 1008);
            if (localObject5 != null) {
              ((TroopBarData)localObject4).mLastMsgTime = ((Message)localObject5).time;
            }
          }
          else
          {
            ((TroopBarData)localObject4).mLastMsgTime = ((RecentUser)???).lastmsgtime;
          }
          a(paramQQAppInterface, localEntityManager, (TroopBarData)localObject4);
          localRecentUserProxy.a((RecentUser)???);
          e(((RecentUser)???).uin, paramQQAppInterface);
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject2 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ??? = (TroopBarData)((Iterator)localObject2).next();
          localObject4 = localRecentUserProxy.a(((TroopBarData)???).mUin, 1008);
          ((RecentUser)localObject4).uin = ((TroopBarData)???).mUin;
          ((RecentUser)localObject4).setType(1008);
          ((RecentUser)localObject4).lastmsgtime = ((TroopBarData)???).mLastMsgTime;
          ((RecentUser)localObject4).lastmsgdrafttime = ((TroopBarData)???).mLastDraftTime;
          if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isColorLevel())
          {
            localObject1 = (IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("uinConfigMap size: ");
            ((StringBuilder)localObject5).append(this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size());
            ((StringBuilder)localObject5).append(", pam cache: ");
            ((StringBuilder)localObject5).append(((IPublicAccountDataManager)localObject1).isCached());
            QLog.i("TroopBarAssistantManager", 2, ((StringBuilder)localObject5).toString());
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("to remove incognizance TroopBarData ");
            ((StringBuilder)localObject1).append(((TroopBarData)???).mUin);
            ((StringBuilder)localObject1).append(" from dataList");
            QLog.i("TroopBarAssistantManager", 2, ((StringBuilder)localObject1).toString());
          }
          if (a(localEntityManager, ((TroopBarData)???).mUin))
          {
            localObject1 = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
            if (localObject1 == null) {
              localObject1 = null;
            } else {
              localObject1 = (PublicAccountInfo)((ConcurrentHashMap)localObject1).get(((TroopBarData)???).mUin);
            }
            if (localObject1 != null) {
              localRecentUserProxy.b((RecentUser)localObject4);
            }
            if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("to remove incognizance uin ");
              ((StringBuilder)localObject1).append(((TroopBarData)???).mUin);
              ((StringBuilder)localObject1).append(" from newMsgSet");
              QLog.i("TroopBarAssistantManager", 2, ((StringBuilder)localObject1).toString());
            }
            d(((TroopBarData)???).mUin, paramQQAppInterface);
          }
        }
      }
      localObject1 = a(paramQQAppInterface);
      if (localObject1 != null) {
        a(paramQQAppInterface, ((TroopBarData)localObject1).mLastMsgTime);
      }
      if (localEntityManager != null) {
        localEntityManager.close();
      }
      return;
    }
    for (;;)
    {
      throw paramQQAppInterface;
    }
  }
  
  public void g(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getHandler(SubscriptFeedsActivity.class);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.removeMessages(1002);
      paramQQAppInterface.sendEmptyMessage(1002);
      paramQQAppInterface.removeMessages(1005);
      paramQQAppInterface.sendEmptyMessage(1005);
    }
  }
  
  public void h(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit();
    this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTime();
    paramQQAppInterface.putLong("troopbar_recent_item_last_del_time", this.jdField_b_of_type_Long);
    paramQQAppInterface.commit();
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("saveTroopBarRecentItemLastDelTime, lastDelTime:");
      paramQQAppInterface.append(this.jdField_b_of_type_Long);
      QLog.d("TroopBarAssistantManager", 2, paramQQAppInterface.toString());
    }
  }
  
  public void i(QQAppInterface paramQQAppInterface)
  {
    try
    {
      j(paramQQAppInterface);
      if (a(paramQQAppInterface) == true)
      {
        EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
        a(localEntityManager, paramQQAppInterface);
        localEntityManager.close();
      }
      b(paramQQAppInterface);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager
 * JD-Core Version:    0.7.0.1
 */