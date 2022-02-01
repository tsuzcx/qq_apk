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
  protected boolean a = true;
  protected String b;
  protected long c = 0L;
  protected int d = 0;
  protected long e = 0L;
  protected boolean f = false;
  public int g = 0;
  protected boolean h = false;
  protected boolean i = false;
  protected ConcurrentHashMap<String, Integer> j = new ConcurrentHashMap();
  protected Boolean k = Boolean.valueOf(false);
  protected List<TroopBarData> l;
  protected final Map<String, TroopBarData> m = new HashMap();
  protected final ConcurrentHashMap<String, PublicAccountInfo> n = new ConcurrentHashMap();
  protected Object o = new Object();
  Comparator<TroopBarData> p = new TroopBarAssistantManager.1(this);
  
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
  
  private TroopBarData a(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface);
    synchronized (this.m)
    {
      TroopBarData localTroopBarData = (TroopBarData)this.m.get(paramString);
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
  
  private void a(QQAppInterface paramQQAppInterface, EntityManager arg2, TroopBarData paramTroopBarData)
  {
    if (paramTroopBarData == null) {
      return;
    }
    Object localObject = (TroopBarData)this.m.get(paramTroopBarData.mUin);
    synchronized (this.m)
    {
      this.m.put(paramTroopBarData.mUin, paramTroopBarData);
      synchronized (this.o)
      {
        if (this.l != null)
        {
          if (localObject != null) {
            this.l.remove(localObject);
          }
          this.l.remove(paramTroopBarData);
          this.l.add(this.l.size(), paramTroopBarData);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("save TroopBarData ");
            ((StringBuilder)localObject).append(paramTroopBarData.mUin);
            ((StringBuilder)localObject).append(" to dataList");
            QLog.i("TroopBarAssistantManager", 2, ((StringBuilder)localObject).toString());
          }
        }
        b();
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
    u(paramQQAppInterface);
    if ((paramMessageRecord != null) && (!paramMessageRecord.isread))
    {
      if (this.j.containsKey(paramString))
      {
        paramMessageRecord = this.j;
        paramMessageRecord.put(paramString, Integer.valueOf(((Integer)paramMessageRecord.get(paramString)).intValue() + 1));
      }
      else
      {
        this.j.put(paramString, Integer.valueOf(1));
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
    s(paramQQAppInterface);
  }
  
  private boolean a(EntityManager paramEntityManager, String paramString)
  {
    synchronized (this.m)
    {
      TroopBarData localTroopBarData = (TroopBarData)this.m.remove(paramString);
      Object localObject2 = this.o;
      ??? = localTroopBarData;
      try
      {
        if (this.l != null)
        {
          ??? = localTroopBarData;
          if (localTroopBarData == null)
          {
            Iterator localIterator = this.l.iterator();
            do
            {
              ??? = localTroopBarData;
              if (!localIterator.hasNext()) {
                break;
              }
              ??? = (TroopBarData)localIterator.next();
            } while (!TextUtils.equals(((TroopBarData)???).mUin, paramString));
          }
          this.l.remove(???);
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
  
  private List<TroopBarData> b(QQAppInterface paramQQAppInterface, List<TroopBarData> paramList)
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
  
  /* Error */
  private void b(EntityManager arg1, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 105
    //   3: iconst_0
    //   4: aconst_null
    //   5: aconst_null
    //   6: aconst_null
    //   7: aconst_null
    //   8: ldc_w 296
    //   11: aconst_null
    //   12: invokevirtual 300	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   15: astore 6
    //   17: aload 6
    //   19: ifnull +22 -> 41
    //   22: aload 6
    //   24: invokeinterface 147 1 0
    //   29: ifle +12 -> 41
    //   32: aload 6
    //   34: aload_0
    //   35: getfield 77	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:p	Ljava/util/Comparator;
    //   38: invokestatic 306	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   41: aload_0
    //   42: getfield 70	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:o	Ljava/lang/Object;
    //   45: astore_1
    //   46: aload_1
    //   47: monitorenter
    //   48: aload_0
    //   49: aload 6
    //   51: putfield 137	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:l	Ljava/util/List;
    //   54: aload_0
    //   55: getfield 137	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:l	Ljava/util/List;
    //   58: ifnonnull +19 -> 77
    //   61: aload_0
    //   62: new 286	java/util/ArrayList
    //   65: dup
    //   66: bipush 15
    //   68: invokespecial 309	java/util/ArrayList:<init>	(I)V
    //   71: putfield 137	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:l	Ljava/util/List;
    //   74: goto +214 -> 288
    //   77: aload_0
    //   78: aload_2
    //   79: invokespecial 313	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:t	(Lcom/tencent/mobileqq/app/QQAppInterface;)J
    //   82: lstore 4
    //   84: iconst_0
    //   85: istore_3
    //   86: iload_3
    //   87: aload_0
    //   88: getfield 137	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:l	Ljava/util/List;
    //   91: invokeinterface 147 1 0
    //   96: if_icmpge +192 -> 288
    //   99: aload_0
    //   100: getfield 137	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:l	Ljava/util/List;
    //   103: iload_3
    //   104: invokeinterface 316 2 0
    //   109: checkcast 105	com/tencent/biz/pubaccount/troopbarassit/TroopBarData
    //   112: astore 6
    //   114: aload 6
    //   116: ifnonnull +32 -> 148
    //   119: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +12 -> 134
    //   125: ldc 170
    //   127: iconst_2
    //   128: ldc_w 318
    //   131: invokestatic 321	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload_0
    //   135: getfield 137	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:l	Ljava/util/List;
    //   138: iload_3
    //   139: invokeinterface 323 2 0
    //   144: pop
    //   145: goto +254 -> 399
    //   148: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +63 -> 214
    //   154: new 159	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   161: astore 7
    //   163: aload 7
    //   165: ldc_w 325
    //   168: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 7
    //   174: aload 6
    //   176: getfield 109	com/tencent/biz/pubaccount/troopbarassit/TroopBarData:mUin	Ljava/lang/String;
    //   179: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 7
    //   185: ldc_w 327
    //   188: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 7
    //   194: aload 6
    //   196: getfield 330	com/tencent/biz/pubaccount/troopbarassit/TroopBarData:mLastMsgTime	J
    //   199: invokevirtual 333	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: ldc 170
    //   205: iconst_2
    //   206: aload 7
    //   208: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload 6
    //   216: getfield 330	com/tencent/biz/pubaccount/troopbarassit/TroopBarData:mLastMsgTime	J
    //   219: lload 4
    //   221: lcmp
    //   222: ifge +17 -> 239
    //   225: aload_0
    //   226: getfield 137	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:l	Ljava/util/List;
    //   229: iload_3
    //   230: invokeinterface 323 2 0
    //   235: pop
    //   236: goto +163 -> 399
    //   239: aload_0
    //   240: getfield 137	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:l	Ljava/util/List;
    //   243: iload_3
    //   244: invokeinterface 316 2 0
    //   249: checkcast 105	com/tencent/biz/pubaccount/troopbarassit/TroopBarData
    //   252: getfield 109	com/tencent/biz/pubaccount/troopbarassit/TroopBarData:mUin	Ljava/lang/String;
    //   255: astore 6
    //   257: aload_0
    //   258: getfield 137	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:l	Ljava/util/List;
    //   261: iload_3
    //   262: invokeinterface 316 2 0
    //   267: checkcast 105	com/tencent/biz/pubaccount/troopbarassit/TroopBarData
    //   270: aload_2
    //   271: invokevirtual 115	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   274: aload 6
    //   276: sipush 1008
    //   279: invokevirtual 339	com/tencent/imcore/message/QQMessageFacade:r	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   282: putfield 343	com/tencent/biz/pubaccount/troopbarassit/TroopBarData:mLatestMessage	Lcom/tencent/mobileqq/data/MessageRecord;
    //   285: goto +114 -> 399
    //   288: aload_1
    //   289: monitorexit
    //   290: aload_0
    //   291: getfield 82	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:m	Ljava/util/Map;
    //   294: astore_1
    //   295: aload_1
    //   296: monitorenter
    //   297: aload_0
    //   298: getfield 82	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:m	Ljava/util/Map;
    //   301: invokeinterface 346 1 0
    //   306: aload_0
    //   307: getfield 137	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:l	Ljava/util/List;
    //   310: invokeinterface 257 1 0
    //   315: astore_2
    //   316: aload_2
    //   317: invokeinterface 262 1 0
    //   322: ifeq +34 -> 356
    //   325: aload_2
    //   326: invokeinterface 266 1 0
    //   331: checkcast 105	com/tencent/biz/pubaccount/troopbarassit/TroopBarData
    //   334: astore 6
    //   336: aload_0
    //   337: getfield 82	com/tencent/biz/pubaccount/troopbarassit/TroopBarAssistantManager:m	Ljava/util/Map;
    //   340: aload 6
    //   342: getfield 109	com/tencent/biz/pubaccount/troopbarassit/TroopBarData:mUin	Ljava/lang/String;
    //   345: aload 6
    //   347: invokeinterface 135 3 0
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
    //   374: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   377: ifeq +13 -> 390
    //   380: ldc 170
    //   382: iconst_2
    //   383: ldc_w 348
    //   386: aload_1
    //   387: invokestatic 351	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   85	318	3	i1	int
    //   82	138	4	l1	long
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
  
  private boolean b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    Object localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.getProxyManager().g();
    int i2 = 0;
    if (localObject == null) {
      return false;
    }
    int i1 = i2;
    if (this.a)
    {
      i1 = i2;
      if (!this.h) {
        i1 = 1;
      }
    }
    if (i1 != 0)
    {
      localObject = localRecentUserProxy.b(AppConstants.TROOP_BAR_ASSISTANT_UIN, 7210);
      if (((RecentUser)localObject).lastmsgtime < paramLong) {
        ((RecentUser)localObject).lastmsgtime = paramLong;
      }
      if (!o(paramQQAppInterface))
      {
        TroopBarData localTroopBarData = c(paramQQAppInterface);
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
      localObject = localRecentUserProxy.c(AppConstants.TROOP_BAR_ASSISTANT_UIN, 7210);
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
  
  public static void c()
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
  
  private TroopBarData d(QQAppInterface arg1, String paramString)
  {
    a(???);
    synchronized (this.m)
    {
      paramString = (TroopBarData)this.m.get(paramString);
      return paramString;
    }
  }
  
  private void e(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getProxyManager().g();
    paramString = paramQQAppInterface.c(paramString, 1008);
    if (paramString != null) {
      paramQQAppInterface.a(paramString);
    }
  }
  
  private void f(String paramString, QQAppInterface paramQQAppInterface)
  {
    a(paramString, paramQQAppInterface, false);
  }
  
  private void g(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (!ServiceAccountFolderManager.a(paramQQAppInterface, paramString)) {
      return;
    }
    u(paramQQAppInterface);
    if (paramQQAppInterface.getConversationFacade().a(paramString, 1008) > 0) {
      if (this.j.containsKey(paramString))
      {
        ConcurrentHashMap localConcurrentHashMap = this.j;
        localConcurrentHashMap.put(paramString, Integer.valueOf(((Integer)localConcurrentHashMap.get(paramString)).intValue() + 1));
      }
      else
      {
        this.j.put(paramString, Integer.valueOf(1));
      }
    }
    s(paramQQAppInterface);
  }
  
  private void r(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      if (!paramQQAppInterface.getAccount().equals(this.b)) {
        synchronized (this.k)
        {
          this.k = Boolean.valueOf(false);
        }
      }
      this.b = paramQQAppInterface.getAccount();
      ??? = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
      this.a = ((SharedPreferences)???).getBoolean("troopbar_assist_show_in_msg", true);
      this.c = ((SharedPreferences)???).getLong("troopbar_assist_last_read_time", 0L);
      this.h = ((SharedPreferences)???).getBoolean("troopbar_assist_deleted", false);
      synchronized (this.o)
      {
        this.l = null;
        u(paramQQAppInterface);
        this.f = false;
        return;
      }
    }
  }
  
  private void s(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new TroopBarAssistantManager.2(this, paramQQAppInterface));
  }
  
  private long t(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return 0L;
    }
    if (!this.f)
    {
      this.e = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getLong("troopbar_recent_item_last_del_time", 0L);
      this.f = true;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getTroopBarRecentItemLastDelTime, lastDelTime:");
      paramQQAppInterface.append(this.e);
      QLog.d("TroopBarAssistantManager", 2, paramQQAppInterface.toString());
    }
    return this.e;
  }
  
  private void u(QQAppInterface paramQQAppInterface)
  {
    if (this.k.booleanValue()) {
      return;
    }
    synchronized (this.k)
    {
      if (!this.k.booleanValue())
      {
        this.j.clear();
        Object localObject1 = paramQQAppInterface.getApp();
        Object localObject2 = paramQQAppInterface.getAccount();
        int i1 = 0;
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
          while (i1 < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).getJSONObject(i1);
            Iterator localIterator = ((JSONObject)localObject2).keys();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              if (ServiceAccountFolderManager.a(paramQQAppInterface, str)) {
                this.j.put(str, Integer.valueOf(((JSONObject)localObject2).getInt(str)));
              }
            }
            i1 += 1;
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
          this.k = Boolean.valueOf(true);
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
  
  public String a(String paramString)
  {
    ConcurrentHashMap localConcurrentHashMap = this.n;
    if (localConcurrentHashMap != null)
    {
      paramString = (PublicAccountInfo)localConcurrentHashMap.get(paramString);
      if (paramString != null) {
        return paramString.name;
      }
    }
    return "";
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    int i1;
    synchronized (this.o)
    {
      if (this.l == null)
      {
        i1 = 1;
        if (i1 != 0)
        {
          ??? = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
          b((EntityManager)???, paramQQAppInterface);
          ((EntityManager)???).close();
          paramQQAppInterface = (List)((IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).getPublicAccountEqqInfoList();
          if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
          {
            this.n.clear();
            paramQQAppInterface = paramQQAppInterface.iterator();
            while (paramQQAppInterface.hasNext())
            {
              ??? = (PublicAccountInfo)paramQQAppInterface.next();
              this.n.put(((PublicAccountInfo)???).getUin(), ???);
            }
          }
        }
        return;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (!paramQQAppInterface.getAccount().equals(this.b)) {
      r(paramQQAppInterface);
    }
    this.c = paramLong;
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putLong("troopbar_assist_last_read_time", paramLong).commit();
    RecentUser localRecentUser = paramQQAppInterface.getProxyManager().g().b(AppConstants.TROOP_BAR_ASSISTANT_UIN, 7210);
    if (localRecentUser != null) {
      localRecentUser.lastmsgtime = paramLong;
    }
    this.j.clear();
    if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isColorLevel()) {
      QLog.i("TroopBarAssistantManager", 2, "setLastReadTime, newMsgStr clear in memory");
    }
    s(paramQQAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface, List<PublicAccountInfo> paramList)
  {
    if (paramQQAppInterface != null)
    {
      if (!paramQQAppInterface.getAccount().equals(this.b)) {
        return;
      }
      if (!((IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).isCached())
      {
        if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isColorLevel()) {
          QLog.w("TroopBarAssistantManager", 2, "refreshSettings but padm not cached");
        }
        return;
      }
      this.i = true;
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.n.clear();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)paramList.next();
          this.n.put(localPublicAccountInfo.getUin(), localPublicAccountInfo);
        }
      }
      l(paramQQAppInterface);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troopbar_assist_deleted", paramBoolean).commit();
    this.h = paramBoolean;
  }
  
  public void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (o(paramQQAppInterface))
    {
      int i1;
      if ((this.a) && (!this.h)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        localObject = paramQQAppInterface.getProxyManager().g().b(AppConstants.TROOP_BAR_ASSISTANT_UIN, 7210);
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
      long l1 = localMessage.time;
      if (l1 > localTroopBarData.mLastMsgTime)
      {
        localTroopBarData.mLastMsgTime = l1;
        localTroopBarData.mLatestMessage = localMessage;
      }
    }
    a(paramQQAppInterface, paramEntityManager, localTroopBarData);
    a(paramMessageRecord, paramString, paramQQAppInterface);
    if (this.h) {
      a(paramQQAppInterface, false);
    }
    e(paramQQAppInterface, paramString);
    b(paramQQAppInterface, paramLong);
  }
  
  public void a(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    try
    {
      a(paramQQAppInterface);
      RecentUserProxy localRecentUserProxy = paramQQAppInterface.getProxyManager().g();
      Object localObject2 = localRecentUserProxy.a(false);
      long l1 = System.currentTimeMillis() / 1000L;
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
        l1 = ((RecentUser)((List)localObject1).get(0)).lastmsgtime;
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
          g(((TroopBarData)localObject3).mUin, paramQQAppInterface);
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
      f(paramString, paramQQAppInterface);
    }
    localEntityManager.close();
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface, Context paramContext, IPublicAccountObserver paramIPublicAccountObserver)
  {
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).unfollowUin(paramQQAppInterface, paramContext, paramString, true, paramIPublicAccountObserver);
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    u(paramQQAppInterface);
    if (((paramBoolean) || (paramQQAppInterface.getConversationFacade().a(paramString, 1008) > 0)) && (this.j.containsKey(paramString))) {
      this.j.remove(paramString);
    }
    s(paramQQAppInterface);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (this.l == null) {
        synchronized (this.n)
        {
          if (this.l == null)
          {
            EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
            b(localEntityManager, paramQQAppInterface);
            localEntityManager.close();
          }
        }
      }
      return this.n.containsKey(paramString);
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    return (paramInt == 1008) && (ServiceAccountFolderManager.a(paramQQAppInterface, paramString));
  }
  
  public int b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return 0;
      }
      paramQQAppInterface = this.j;
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.keySet().iterator();
        while (paramQQAppInterface.hasNext())
        {
          Object localObject = (String)paramQQAppInterface.next();
          if (paramString.equals(localObject))
          {
            localObject = (Integer)this.j.get(localObject);
            if (localObject != null) {
              return ((Integer)localObject).intValue();
            }
          }
        }
      }
    }
    return 0;
  }
  
  public void b()
  {
    synchronized (this.o)
    {
      if ((this.l != null) && (this.l.size() > 0)) {
        Collections.sort(this.l, this.p);
      }
      return;
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
    if (!paramQQAppInterface.getAccount().equals(this.b)) {
      r(paramQQAppInterface);
    }
    if (o(paramQQAppInterface))
    {
      c(paramQQAppInterface, false);
      b(paramQQAppInterface, false);
      b(paramQQAppInterface, NetConnInfoCenter.getServerTime());
      return;
    }
    TroopBarData localTroopBarData = c(paramQQAppInterface);
    if (localTroopBarData != null) {
      b(paramQQAppInterface, localTroopBarData.mLastMsgTime);
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("first_login", paramBoolean).commit();
  }
  
  public boolean b(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramString = d(paramQQAppInterface, paramString);
    if (paramString != null) {
      return paramString.mIsSticky;
    }
    return false;
  }
  
  public TroopBarData c(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    label212:
    synchronized (this.o)
    {
      if ((this.l != null) && (this.l.size() > 0))
      {
        long l1 = t(paramQQAppInterface);
        Iterator localIterator = this.l.iterator();
        while (localIterator.hasNext())
        {
          TroopBarData localTroopBarData = (TroopBarData)localIterator.next();
          if (localTroopBarData.mLastMsgTime < l1)
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
      b();
      paramQQAppInterface = b(paramQQAppInterface, this.l);
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
  
  public void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      u(paramQQAppInterface);
      ConcurrentHashMap localConcurrentHashMap = this.j;
      if ((localConcurrentHashMap != null) && (localConcurrentHashMap.keySet().contains(paramString))) {
        this.j.put(paramString, Integer.valueOf(0));
      }
      s(paramQQAppInterface);
      RecentUtil.b(paramQQAppInterface, paramString, ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType(paramQQAppInterface, paramString));
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("subscribe_setTop_flag", paramBoolean).commit();
  }
  
  public void c(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.m)
    {
      paramString = (TroopBarData)this.m.get(paramString);
      if (paramString == null) {
        return;
      }
      paramString.mIsSticky = true;
      paramString.mLastStickyTime = (System.currentTimeMillis() / 1000L);
      ((ProxyManager)paramQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER)).addMsgQueue(paramQQAppInterface.getAccount(), 0, paramString.getTableName(), paramString, 4, null);
      b();
      paramString = paramQQAppInterface.getHandler(Conversation.class);
      if (paramString != null) {
        paramString.sendEmptyMessage(1009);
      }
      return;
    }
  }
  
  public int d()
  {
    Object localObject = this.m;
    int i2 = 0;
    int i1 = 0;
    if (localObject != null)
    {
      localObject = ((Map)localObject).values().iterator();
      for (;;)
      {
        i2 = i1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        if (((TroopBarData)((Iterator)localObject).next()).mIsSticky) {
          i1 += 1;
        }
      }
    }
    return i2;
  }
  
  public void d(QQAppInterface paramQQAppInterface)
  {
    this.j.clear();
    if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isColorLevel()) {
      QLog.i("TroopBarAssistantManager", 2, "setFirstEnterFeeds, newMsgStr clear in memory");
    }
    s(paramQQAppInterface);
  }
  
  public void d(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("first_enter_subscribe", paramBoolean).commit();
  }
  
  public void d(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.m)
    {
      paramString = (TroopBarData)this.m.get(paramString);
      if (paramString == null) {
        return;
      }
      paramString.mIsSticky = false;
      paramString.mLastStickyTime = 0L;
      ((ProxyManager)paramQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER)).addMsgQueue(paramQQAppInterface.getAccount(), 0, paramString.getTableName(), paramString, 4, null);
      b();
      paramString = paramQQAppInterface.getHandler(Conversation.class);
      if (paramString != null) {
        paramString.sendEmptyMessage(1009);
      }
      return;
    }
  }
  
  public String e(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramString = ((IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).findAccountDetailInfo(paramString);
    if (paramString != null) {
      return paramString.getName();
    }
    return "";
  }
  
  public void e(QQAppInterface paramQQAppInterface)
  {
    TroopBarData localTroopBarData = c(paramQQAppInterface);
    long l1;
    if (localTroopBarData != null) {
      l1 = localTroopBarData.mLastMsgTime;
    } else {
      l1 = NetConnInfoCenter.getServerTime();
    }
    a(paramQQAppInterface, l1);
  }
  
  public void e(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("first_enter_subscribe_no_reset", paramBoolean).commit();
  }
  
  public int f(QQAppInterface arg1)
  {
    boolean bool = ???.getAccount().equals(this.b);
    int i2 = 0;
    int i1 = 0;
    if (!bool) {
      return 0;
    }
    synchronized (this.k)
    {
      if (this.k.booleanValue())
      {
        Iterator localIterator = this.j.values().iterator();
        for (;;)
        {
          i2 = i1;
          if (!localIterator.hasNext()) {
            break;
          }
          i1 += ((Integer)localIterator.next()).intValue();
        }
      }
      return i2;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public boolean g(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("init_troopbar_assist", true);
  }
  
  public List<TroopBarData> h(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramQQAppInterface);
    int i1;
    synchronized (this.o)
    {
      if (this.l != null)
      {
        int i2 = 0;
        long l1 = t(paramQQAppInterface);
        i1 = this.l.size() - 1;
        if (i1 >= 0)
        {
          TroopBarData localTroopBarData = (TroopBarData)this.l.get(i1);
          if (localTroopBarData == null)
          {
            this.l.remove(i1);
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
            if (localTroopBarData.mLastMsgTime < l1)
            {
              this.l.remove(i1);
            }
            else
            {
              localObject2 = paramQQAppInterface.getMessageFacade().r(localTroopBarData.mUin, 1008);
              if (localObject2 == null)
              {
                this.l.remove(i1);
              }
              else if (((MessageRecord)localObject2).time > localTroopBarData.mLastMsgTime)
              {
                ((TroopBarData)this.l.get(i1)).mLastMsgTime = ((MessageRecord)localObject2).time;
                i2 = 1;
              }
            }
          }
        }
        else
        {
          if (i2 != 0) {
            Collections.sort(this.l, this.p);
          }
          localArrayList.addAll(this.l);
        }
      }
      else
      {
        return localArrayList;
      }
    }
  }
  
  public List<SubscriptionFeed> i(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    Object localObject1 = new ArrayList();
    synchronized (this.o)
    {
      Object localObject3;
      if (this.l != null)
      {
        long l1 = t(paramQQAppInterface);
        localObject3 = this.l.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          TroopBarData localTroopBarData = (TroopBarData)((Iterator)localObject3).next();
          if (localTroopBarData == null)
          {
            ((Iterator)localObject3).remove();
          }
          else
          {
            Object localObject4 = paramQQAppInterface.getMessageFacade().r(localTroopBarData.mUin, 1008);
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
              if (localTroopBarData.mLastMsgTime < l1) {
                ((Iterator)localObject3).remove();
              }
            }
          }
        }
        b();
        ((List)localObject1).addAll(b(paramQQAppInterface, this.l));
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
  
  public List<PublicAccountInfo> j(QQAppInterface paramQQAppInterface)
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
  
  public void k(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnSubThread(new TroopBarAssistantManager.3(this, paramQQAppInterface));
  }
  
  public void l(QQAppInterface paramQQAppInterface)
  {
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.getProxyManager().g();
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
    synchronized (this.o)
    {
      Object localObject5;
      if ((this.l != null) && (this.l.size() > 0))
      {
        localObject4 = this.l.iterator();
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
        if (this.h) {
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
          g(((RecentUser)???).uin, paramQQAppInterface);
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject2 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ??? = (TroopBarData)((Iterator)localObject2).next();
          localObject4 = localRecentUserProxy.b(((TroopBarData)???).mUin, 1008);
          ((RecentUser)localObject4).uin = ((TroopBarData)???).mUin;
          ((RecentUser)localObject4).setType(1008);
          ((RecentUser)localObject4).lastmsgtime = ((TroopBarData)???).mLastMsgTime;
          ((RecentUser)localObject4).lastmsgdrafttime = ((TroopBarData)???).mLastDraftTime;
          if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isColorLevel())
          {
            localObject1 = (IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("uinConfigMap size: ");
            ((StringBuilder)localObject5).append(this.n.size());
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
            localObject1 = this.n;
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
            f(((TroopBarData)???).mUin, paramQQAppInterface);
          }
        }
      }
      localObject1 = c(paramQQAppInterface);
      if (localObject1 != null) {
        b(paramQQAppInterface, ((TroopBarData)localObject1).mLastMsgTime);
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
  
  public void m(QQAppInterface paramQQAppInterface)
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
  
  public void n(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit();
    this.e = NetConnInfoCenter.getServerTime();
    paramQQAppInterface.putLong("troopbar_recent_item_last_del_time", this.e);
    paramQQAppInterface.commit();
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("saveTroopBarRecentItemLastDelTime, lastDelTime:");
      paramQQAppInterface.append(this.e);
      QLog.d("TroopBarAssistantManager", 2, paramQQAppInterface.toString());
    }
  }
  
  public boolean o(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("subscribe_setTop_flag", false);
  }
  
  public boolean p(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("first_enter_subscribe_no_reset", true);
  }
  
  public void q(QQAppInterface paramQQAppInterface)
  {
    try
    {
      r(paramQQAppInterface);
      if (g(paramQQAppInterface) == true)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager
 * JD-Core Version:    0.7.0.1
 */