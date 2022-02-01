package com.tencent.mobileqq.app.asyncdb.cache;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentParcelUtil;
import com.tencent.mobileqq.activity.recent.config.cache.RecentUserCacheConfig;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imcore.proxy.msg.ConversationFacadeProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCacheStub;
import com.tencent.mobileqq.service.message.RecentConvInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class BaseRecentUserCache
  extends FullCache
  implements RecentUserProxy
{
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  protected BaseQQAppInterface a;
  Comparator<Entity> jdField_a_of_type_JavaUtilComparator = new BaseRecentUserCache.RecentComparator(true);
  protected ConcurrentHashMap<String, ConcurrentHashMap<String, Entity>> a;
  Comparator<Entity> jdField_b_of_type_JavaUtilComparator = new BaseRecentUserCache.RecentComparator(false);
  private ConcurrentHashMap<String, Long> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(64);
  
  public BaseRecentUserCache(BaseQQAppInterface paramBaseQQAppInterface, DBDelayManager paramDBDelayManager)
  {
    super(paramBaseQQAppInterface, paramDBDelayManager, RecentUser.class);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(64);
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    this.cacheMap = new BaseRecentUserCache.CacheMap(this, null);
    RecentUserCacheConfig.a();
    d();
  }
  
  public static String a(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= 4);
    return paramString.substring(0, 4);
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramString + "&" + paramInt;
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    ConversationFacadeProxy.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramString, paramInt1, paramInt2);
  }
  
  private boolean a(RecentUser paramRecentUser, boolean paramBoolean)
  {
    return RecentUserCacheConfig.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramRecentUser, paramBoolean);
  }
  
  @NonNull
  private List<RecentUser> b()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject1 = Integer.toString(150);
    localObject1 = localEntityManager.query(RecentUser.class, false, "type!=?", new String[] { String.valueOf(10007) }, null, null, "showUpTime desc, lastmsgtime desc", (String)localObject1);
    Object localObject2;
    if (localObject1 == null) {
      localObject2 = new ArrayList(20);
    }
    for (;;)
    {
      localEntityManager.close();
      return localObject2;
      if (((List)localObject1).size() > 149)
      {
        long l = System.currentTimeMillis();
        try
        {
          localObject2 = (RecentUser)((List)localObject1).get(140);
          bool = localEntityManager.execSQL("delete from " + "recent" + " where showUpTime < " + ((RecentUser)localObject2).showUpTime + " or showUpTime = " + ((RecentUser)localObject2).showUpTime + " and max(lastmsgtime, lastmsgdrafttime) < " + Math.max(((RecentUser)localObject2).lastmsgtime, ((RecentUser)localObject2).lastmsgdrafttime) + "; ");
          if (!bool) {
            break label302;
          }
          localObject2 = new ArrayList(((List)localObject1).subList(0, 140));
          localObject1 = localObject2;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            boolean bool;
          }
        }
        localObject2 = localObject1;
        try
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.db.Cache.RecentUserCache", 2, new Object[] { "doInit int recentUserProxy delete recent table >", Integer.valueOf(149), " isOk = ", Boolean.valueOf(bool), "; time = ", Long.valueOf(System.currentTimeMillis() - l) });
          localObject2 = localObject1;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          Object localObject3 = localObject1;
        }
        continue;
      }
      label302:
      Object localObject4 = localObject1;
    }
  }
  
  private void c(RecentUser paramRecentUser)
  {
    if (paramRecentUser.uin == null) {
      paramRecentUser.uin = "";
    }
    if (paramRecentUser.troopUin == null) {
      paramRecentUser.troopUin = "";
    }
    if (paramRecentUser.displayName == null) {
      paramRecentUser.displayName = "";
    }
  }
  
  private void c(RecentUser paramRecentUser, boolean paramBoolean)
  {
    String str = RecentDataListManager.a(paramRecentUser.uin, paramRecentUser.getType());
    long l = Math.max(Math.max(paramRecentUser.opTime, paramRecentUser.showUpTime), Math.max(paramRecentUser.lastmsgtime, paramRecentUser.lastmsgdrafttime));
    if ((!paramBoolean) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) && (((Long)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).longValue() >= l))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, new Object[] { "saveParcelDataToRecentData repeat， key=", str, " opTime=", Long.valueOf(paramRecentUser.opTime), " showUpTime=", Long.valueOf(paramRecentUser.showUpTime), " lastmsgtime=", Long.valueOf(paramRecentUser.lastmsgtime), " lastmsgdrafttime=", Long.valueOf(paramRecentUser.lastmsgdrafttime) });
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getRecentThreadLooper());
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new BaseRecentUserCache.1(this, str, paramRecentUser, l));
  }
  
  private void d()
  {
    Object localObject = b();
    QLog.d("Q.db.Cache.RecentUserCache", 2, new Object[] { "descRecentList before size=", Integer.valueOf(((List)localObject).size()) });
    RecentUserCacheConfig.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, (List)localObject);
    QLog.d("Q.db.Cache.RecentUserCache", 2, new Object[] { "descRecentList after size=", Integer.valueOf(((List)localObject).size()) });
    Collections.sort((List)localObject, this.jdField_a_of_type_JavaUtilComparator);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      RecentUser localRecentUser = (RecentUser)((Iterator)localObject).next();
      c(localRecentUser);
      this.cacheMap.put(getKey(localRecentUser), localRecentUser);
    }
  }
  
  public RecentUser a(String paramString, int paramInt)
  {
    if ((paramInt >= 0) && (paramString != null) && (paramString.length() <= 2)) {}
    RecentUser localRecentUser = (RecentUser)this.cacheMap.get(a(paramString, paramInt));
    if (localRecentUser == null)
    {
      paramString = new RecentUser(paramString, paramInt);
      paramString.displayName = paramString.uin;
      paramString.parse();
      c(paramString);
    }
    do
    {
      return paramString;
      paramString = localRecentUser;
    } while (localRecentUser.msg != null);
    if (localRecentUser.mIsParsed)
    {
      localRecentUser.reParse();
      return localRecentUser;
    }
    localRecentUser.parse();
    return localRecentUser;
  }
  
  public Entity a(@NonNull Object paramObject)
  {
    synchronized (this.cacheMap)
    {
      paramObject = (Entity)this.cacheMap.remove(paramObject);
      return paramObject;
    }
  }
  
  public RecentConvInfo a(String paramString, int paramInt)
  {
    ArrayList localArrayList;
    Object localObject;
    try
    {
      localArrayList = new ArrayList(this.cacheMap.size());
      localObject = this.cacheMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Map.Entry)((Iterator)localObject).next()).getValue();
        localRecentUser.parse();
        localArrayList.add(localRecentUser);
      }
      Collections.sort(localArrayList, this.jdField_a_of_type_JavaUtilComparator);
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.db.Cache.RecentUserCache", 2, "getRecentConvInfo is error!", paramString);
      }
      return null;
    }
    paramString = (RecentUser)this.cacheMap.get(a(paramString, paramInt));
    int i;
    if (paramString != null)
    {
      i = localArrayList.indexOf(paramString) + 1;
      long l = System.currentTimeMillis() / 1000L;
      paramString = localArrayList.iterator();
      do
      {
        if (!paramString.hasNext()) {
          break;
        }
        localObject = (RecentUser)paramString.next();
      } while (l - ((RecentUser)localObject).lastmsgtime <= MessageCacheStub.a);
    }
    for (paramInt = localArrayList.indexOf(localObject) + 1;; paramInt = -1)
    {
      if (paramInt == -1) {
        paramInt = localArrayList.size();
      }
      for (;;)
      {
        paramString = new RecentConvInfo();
        paramString.a = i;
        paramString.b = paramInt;
        paramString.c = localArrayList.size();
        return paramString;
        i = -1;
        break;
      }
    }
  }
  
  public List<RecentUser> a()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.cacheMap.size());
      Iterator localIterator = this.cacheMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Map.Entry)localIterator.next()).getValue();
        localRecentUser.parse();
        if (localRecentUser.isHiddenChat == 1) {
          localArrayList.add(localRecentUser);
        }
      }
      if (!QLog.isColorLevel()) {
        return localException;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.db.Cache.RecentUserCache", 2, "getHiddenCacheList is error!", localException);
      }
      return new ArrayList();
    }
    if (localException == null) {}
    for (int i = 0;; i = localException.size())
    {
      QLog.d("Q.db.Cache.RecentUserCache", 2, String.format("getHiddenRecentList, size = %s", new Object[] { Integer.valueOf(i) }));
      break;
    }
    return localException;
  }
  
  public List<RecentUser> a(boolean paramBoolean)
  {
    return a(paramBoolean, true);
  }
  
  public List<RecentUser> a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramBoolean1, paramBoolean2, true);
  }
  
  /* Error */
  public List<RecentUser> a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    // Byte code:
    //   0: new 139	java/util/ArrayList
    //   3: dup
    //   4: aload_0
    //   5: getfield 52	com/tencent/mobileqq/app/asyncdb/cache/BaseRecentUserCache:cacheMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   8: invokevirtual 367	java/util/concurrent/ConcurrentHashMap:size	()I
    //   11: invokespecial 140	java/util/ArrayList:<init>	(I)V
    //   14: astore 5
    //   16: aload_0
    //   17: getfield 52	com/tencent/mobileqq/app/asyncdb/cache/BaseRecentUserCache:cacheMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   20: invokevirtual 371	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   23: invokeinterface 374 1 0
    //   28: astore 6
    //   30: aload 6
    //   32: invokeinterface 325 1 0
    //   37: ifeq +122 -> 159
    //   40: aload 6
    //   42: invokeinterface 329 1 0
    //   47: checkcast 376	java/util/Map$Entry
    //   50: invokeinterface 379 1 0
    //   55: checkcast 19	com/tencent/mobileqq/data/RecentUser
    //   58: astore 7
    //   60: aload 7
    //   62: invokevirtual 347	com/tencent/mobileqq/data/RecentUser:parse	()V
    //   65: aload_0
    //   66: aload 7
    //   68: iload_2
    //   69: invokespecial 433	com/tencent/mobileqq/app/asyncdb/cache/BaseRecentUserCache:a	(Lcom/tencent/mobileqq/data/RecentUser;Z)Z
    //   72: ifeq +43 -> 115
    //   75: aload 5
    //   77: aload 7
    //   79: invokeinterface 382 2 0
    //   84: pop
    //   85: goto -55 -> 30
    //   88: astore 5
    //   90: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq +14 -> 107
    //   96: ldc 208
    //   98: iconst_2
    //   99: ldc_w 435
    //   102: aload 5
    //   104: invokestatic 388	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: new 139	java/util/ArrayList
    //   110: dup
    //   111: invokespecial 413	java/util/ArrayList:<init>	()V
    //   114: areturn
    //   115: ldc 208
    //   117: iconst_2
    //   118: iconst_4
    //   119: anewarray 210	java/lang/Object
    //   122: dup
    //   123: iconst_0
    //   124: ldc_w 437
    //   127: aastore
    //   128: dup
    //   129: iconst_1
    //   130: aload 7
    //   132: getfield 244	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   135: aastore
    //   136: dup
    //   137: iconst_2
    //   138: ldc_w 439
    //   141: aastore
    //   142: dup
    //   143: iconst_3
    //   144: aload 7
    //   146: getfield 442	com/tencent/mobileqq/data/RecentUser:type	I
    //   149: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: aastore
    //   153: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   156: goto -126 -> 30
    //   159: iload_1
    //   160: ifeq +16 -> 176
    //   163: iload_3
    //   164: ifeq +53 -> 217
    //   167: aload 5
    //   169: aload_0
    //   170: getfield 36	com/tencent/mobileqq/app/asyncdb/cache/BaseRecentUserCache:jdField_a_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   173: invokestatic 316	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   176: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq +62 -> 241
    //   182: aload 5
    //   184: ifnonnull +45 -> 229
    //   187: iconst_0
    //   188: istore 4
    //   190: ldc 208
    //   192: iconst_2
    //   193: ldc_w 444
    //   196: iconst_1
    //   197: anewarray 210	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: iload 4
    //   204: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: aastore
    //   208: invokestatic 419	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   211: invokestatic 422	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: goto +27 -> 241
    //   217: aload 5
    //   219: aload_0
    //   220: getfield 38	com/tencent/mobileqq/app/asyncdb/cache/BaseRecentUserCache:jdField_b_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   223: invokestatic 316	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   226: goto -50 -> 176
    //   229: aload 5
    //   231: invokeinterface 148 1 0
    //   236: istore 4
    //   238: goto -48 -> 190
    //   241: aload 5
    //   243: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	BaseRecentUserCache
    //   0	244	1	paramBoolean1	boolean
    //   0	244	2	paramBoolean2	boolean
    //   0	244	3	paramBoolean3	boolean
    //   188	49	4	i	int
    //   14	62	5	localArrayList	ArrayList
    //   88	154	5	localException	Exception
    //   28	13	6	localIterator	Iterator
    //   58	87	7	localRecentUser	RecentUser
    // Exception table:
    //   from	to	target	type
    //   0	30	88	java/lang/Exception
    //   30	85	88	java/lang/Exception
    //   115	156	88	java/lang/Exception
    //   167	176	88	java/lang/Exception
    //   176	182	88	java/lang/Exception
    //   190	214	88	java/lang/Exception
    //   217	226	88	java/lang/Exception
    //   229	238	88	java/lang/Exception
  }
  
  public void a()
  {
    this.cacheMap.clear();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "deleteRecentUserByType, type:" + paramInt);
    }
    if (this.cacheMap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "deleteRecentUserByType cacheMap  is null");
      }
      return;
    }
    synchronized (this.cacheMap)
    {
      Iterator localIterator = this.cacheMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        if (((RecentUser)((Map.Entry)localIterator.next()).getValue()).getType() == paramInt)
        {
          localIterator.remove();
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache.RecentUserCache", 2, "deleteRecentUserByType remove ru");
          }
        }
      }
    }
  }
  
  public void a(RecentUser paramRecentUser)
  {
    a(paramRecentUser, true);
  }
  
  public void a(RecentUser paramRecentUser, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "delRecentUser user: " + a(paramRecentUser.uin) + " type " + paramRecentUser.getType() + " msgType " + paramRecentUser.msgType + ",uin = " + paramRecentUser.uin);
    }
    if (paramBoolean) {
      a(paramRecentUser.uin, paramRecentUser.getType(), 0);
    }
    removeCache(paramRecentUser);
    RecentUserCacheConfig.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramRecentUser, paramBoolean);
  }
  
  public void a(String paramString)
  {
    Object localObject = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((localObject != null) && (!((ConcurrentHashMap)localObject).isEmpty()))
    {
      localObject = ((ConcurrentHashMap)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache.RecentUserCache", 2, "findRecentUserByUin, uin:" + paramString + ",type:" + str);
          }
          int i = Integer.parseInt(str);
          if (i != 7000) {
            a(a(paramString, i));
          }
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    int[] arrayOfInt = UinTypeUtil.c;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      int k;
      Object localObject;
      if (i < j)
      {
        k = arrayOfInt[i];
        localObject = a(paramString, k);
        if (!this.cacheMap.containsKey(localObject)) {
          break label163;
        }
        localObject = (RecentUser)this.cacheMap.get(localObject);
        if (localObject != null) {}
      }
      else
      {
        return;
      }
      if (paramBoolean) {
        a(((RecentUser)localObject).uin, ((RecentUser)localObject).getType(), 0);
      }
      ((RecentUser)localObject).setType(k);
      removeCache((Entity)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "delRecentUser user: " + a(((RecentUser)localObject).uin) + " type " + ((RecentUser)localObject).getType() + " msgType " + ((RecentUser)localObject).msgType);
      }
      label163:
      i += 1;
    }
  }
  
  public boolean a(@NonNull RecentUser paramRecentUser)
  {
    synchronized (this.cacheMap)
    {
      boolean bool = this.cacheMap.contains(paramRecentUser);
      return bool;
    }
  }
  
  public boolean a(String paramString)
  {
    paramString = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    return (paramString != null) && (!paramString.isEmpty());
  }
  
  public boolean a(String paramString, int paramInt)
  {
    synchronized (this.cacheMap)
    {
      return (RecentUser)this.cacheMap.get(a(paramString, paramInt)) != null;
    }
  }
  
  public RecentUser b(String paramString, int paramInt)
  {
    for (;;)
    {
      synchronized (this.cacheMap)
      {
        paramString = (RecentUser)this.cacheMap.get(a(paramString, paramInt));
        if (paramString == null) {
          return null;
        }
        if (paramString.msg == null)
        {
          if (paramString.mIsParsed) {
            paramString.reParse();
          }
        }
        else {
          return paramString;
        }
      }
      paramString.parse();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void b(RecentUser paramRecentUser)
  {
    b(paramRecentUser, false);
  }
  
  public void b(RecentUser paramRecentUser, boolean paramBoolean)
  {
    if ((paramRecentUser == null) || (paramRecentUser.getType() < 0) || (paramRecentUser.uin == null) || (paramRecentUser.uin.length() <= 2)) {
      if (paramRecentUser != null) {
        c(paramRecentUser);
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, "saveRecentUser user: " + paramRecentUser.uin + " type " + paramRecentUser.getType() + " msgType " + paramRecentUser.msgType);
        }
        paramRecentUser = RecentUserCacheConfig.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramRecentUser, paramBoolean);
      } while (paramRecentUser == null);
      c(paramRecentUser);
      addCache(paramRecentUser);
    } while ((paramRecentUser.isHiddenChat != 0) || (!RecentParcelUtil.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface)));
    try
    {
      c(paramRecentUser, paramBoolean);
      return;
    }
    catch (Throwable paramRecentUser) {}
  }
  
  public boolean b(@NonNull String paramString)
  {
    synchronized (this.cacheMap)
    {
      boolean bool = this.cacheMap.containsKey(paramString);
      return bool;
    }
  }
  
  public void c()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getEntityManagerFactory().createEntityManager();
    ??? = Integer.toString(50);
    Object localObject3 = localEntityManager.query(RecentUser.class, false, "type=?", new String[] { String.valueOf(10007) }, null, null, "lastmsgtime desc", (String)???);
    int i = this.cacheMap.size();
    if (localObject3 != null) {
      synchronized (this.cacheMap)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          RecentUser localRecentUser = (RecentUser)((Iterator)localObject3).next();
          String str = getKey(localRecentUser);
          if (!this.cacheMap.containsKey(str)) {
            this.cacheMap.put(str, localRecentUser);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "preLoadTinyRecentUser is called. preCount = " + i + ", afterCount = " + this.cacheMap.size());
    }
    localObject1.close();
  }
  
  public boolean c(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((paramString != null) && (!paramString.isEmpty()) && ((!paramString.containsKey(String.valueOf(7000))) || (paramString.keySet().size() > 1))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void destroy() {}
  
  public final String getKey(Entity paramEntity)
  {
    paramEntity = (RecentUser)paramEntity;
    return paramEntity.uin + "&" + paramEntity.getType();
  }
  
  public void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.BaseRecentUserCache
 * JD-Core Version:    0.7.0.1
 */