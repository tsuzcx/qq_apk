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
import com.tencent.mobileqq.imcore.proxy.business.GameMsgBoxRuntimeServiceProxy;
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
  protected BaseQQAppInterface b;
  protected ConcurrentHashMap<String, ConcurrentHashMap<String, Entity>> c = new ConcurrentHashMap(64);
  Comparator<Entity> d = new BaseRecentUserCache.RecentComparator(true);
  Comparator<Entity> e = new BaseRecentUserCache.RecentComparator(false);
  private ConcurrentHashMap<String, Long> f = new ConcurrentHashMap(64);
  private Handler g = null;
  
  public BaseRecentUserCache(BaseQQAppInterface paramBaseQQAppInterface, DBDelayManager paramDBDelayManager)
  {
    super(paramBaseQQAppInterface, paramDBDelayManager, RecentUser.class);
    this.b = paramBaseQQAppInterface;
    this.cacheMap = new BaseRecentUserCache.CacheMap(this, null);
    RecentUserCacheConfig.a();
    f();
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    ConversationFacadeProxy.a(this.b, paramString, paramInt1, paramInt2);
  }
  
  private boolean c(RecentUser paramRecentUser, boolean paramBoolean)
  {
    return RecentUserCacheConfig.a(this.b, paramRecentUser, paramBoolean);
  }
  
  public static String d(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if (paramString.length() <= 4) {
      return paramString;
    }
    return paramString.substring(0, 4);
  }
  
  public static String d(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("&");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  private void d(RecentUser paramRecentUser)
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
  
  private void d(RecentUser paramRecentUser, boolean paramBoolean)
  {
    String str = RecentDataListManager.a(paramRecentUser.uin, paramRecentUser.getType());
    long l = Math.max(Math.max(paramRecentUser.opTime, paramRecentUser.showUpTime), Math.max(paramRecentUser.lastmsgtime, paramRecentUser.lastmsgdrafttime));
    if ((!paramBoolean) && (this.f.containsKey(str)) && (((Long)this.f.get(str)).longValue() >= l))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, new Object[] { "saveParcelDataToRecentData repeat， key=", str, " opTime=", Long.valueOf(paramRecentUser.opTime), " showUpTime=", Long.valueOf(paramRecentUser.showUpTime), " lastmsgtime=", Long.valueOf(paramRecentUser.lastmsgtime), " lastmsgdrafttime=", Long.valueOf(paramRecentUser.lastmsgdrafttime) });
      }
      return;
    }
    if (this.g == null) {
      this.g = new Handler(ThreadManagerV2.getRecentThreadLooper());
    }
    this.g.post(new BaseRecentUserCache.1(this, str, paramRecentUser, l));
  }
  
  @NonNull
  private List<RecentUser> e()
  {
    EntityManager localEntityManager = this.b.getEntityManagerFactory().createEntityManager();
    Object localObject1 = Integer.toString(150);
    List localList = localEntityManager.query(RecentUser.class, false, "type!=?", new String[] { String.valueOf(10007) }, null, null, "showUpTime desc, lastmsgtime desc", (String)localObject1);
    Object localObject2;
    if (localList == null)
    {
      localObject2 = new ArrayList(20);
    }
    else
    {
      localObject2 = localList;
      if (localList.size() > 149)
      {
        long l = System.currentTimeMillis();
        Object localObject3 = localList;
        try
        {
          localObject1 = (RecentUser)localList.get(140);
          localObject3 = localList;
          localObject2 = new StringBuilder();
          localObject3 = localList;
          ((StringBuilder)localObject2).append("delete from ");
          localObject3 = localList;
          ((StringBuilder)localObject2).append("recent");
          localObject3 = localList;
          ((StringBuilder)localObject2).append(" where showUpTime < ");
          localObject3 = localList;
          ((StringBuilder)localObject2).append(((RecentUser)localObject1).showUpTime);
          localObject3 = localList;
          ((StringBuilder)localObject2).append(" or showUpTime = ");
          localObject3 = localList;
          ((StringBuilder)localObject2).append(((RecentUser)localObject1).showUpTime);
          localObject3 = localList;
          ((StringBuilder)localObject2).append(" and max(lastmsgtime, lastmsgdrafttime) < ");
          localObject3 = localList;
          ((StringBuilder)localObject2).append(Math.max(((RecentUser)localObject1).lastmsgtime, ((RecentUser)localObject1).lastmsgdrafttime));
          localObject3 = localList;
          ((StringBuilder)localObject2).append("; ");
          localObject3 = localList;
          boolean bool = localEntityManager.execSQL(((StringBuilder)localObject2).toString());
          localObject1 = localList;
          if (bool)
          {
            localObject3 = localList;
            localObject1 = new ArrayList(localList.subList(0, 140));
          }
          localObject3 = localObject1;
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            localObject3 = localObject1;
            QLog.d("Q.db.Cache.RecentUserCache", 2, new Object[] { "doInit int recentUserProxy delete recent table >", Integer.valueOf(149), " isOk = ", Boolean.valueOf(bool), "; time = ", Long.valueOf(System.currentTimeMillis() - l) });
            localObject2 = localObject1;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          localObject2 = localObject3;
        }
      }
    }
    localEntityManager.close();
    return localObject2;
  }
  
  private void f()
  {
    Object localObject = e();
    QLog.d("Q.db.Cache.RecentUserCache", 2, new Object[] { "descRecentList before size=", Integer.valueOf(((List)localObject).size()) });
    RecentUserCacheConfig.a(this.b, (List)localObject);
    QLog.d("Q.db.Cache.RecentUserCache", 2, new Object[] { "descRecentList after size=", Integer.valueOf(((List)localObject).size()) });
    Collections.sort((List)localObject, this.d);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      RecentUser localRecentUser = (RecentUser)((Iterator)localObject).next();
      d(localRecentUser);
      this.cacheMap.put(getKey(localRecentUser), localRecentUser);
    }
  }
  
  public Entity a(@NonNull Object paramObject)
  {
    synchronized (this.cacheMap)
    {
      paramObject = (Entity)this.cacheMap.remove(paramObject);
      return paramObject;
    }
  }
  
  public List<RecentUser> a(boolean paramBoolean)
  {
    return a(paramBoolean, true);
  }
  
  public List<RecentUser> a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramBoolean1, paramBoolean2, true);
  }
  
  public List<RecentUser> a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.cacheMap.size());
      Iterator localIterator = this.cacheMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Map.Entry)localIterator.next()).getValue();
        localRecentUser.parse();
        if (c(localRecentUser, paramBoolean2)) {
          localArrayList.add(localRecentUser);
        } else {
          QLog.d("Q.db.Cache.RecentUserCache", 2, new Object[] { "getRecentList, filter =", localRecentUser.uin, "|", Integer.valueOf(localRecentUser.type) });
        }
      }
      if (paramBoolean1) {
        if (paramBoolean3) {
          Collections.sort(localArrayList, this.d);
        } else {
          Collections.sort(localArrayList, this.e);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, String.format("getRecentList, size = %s", new Object[] { Integer.valueOf(localArrayList.size()) }));
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.db.Cache.RecentUserCache", 2, "getCacheList is error!", localException);
      }
    }
    return new ArrayList();
  }
  
  public void a()
  {
    this.cacheMap.clear();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("deleteRecentUserByType, type:");
      ((StringBuilder)???).append(paramInt);
      QLog.d("Q.db.Cache.RecentUserCache", 2, ((StringBuilder)???).toString());
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
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(RecentUser paramRecentUser)
  {
    a(paramRecentUser, true);
  }
  
  public void a(RecentUser paramRecentUser, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("delRecentUser user: ");
      localStringBuilder.append(d(paramRecentUser.uin));
      localStringBuilder.append(" type ");
      localStringBuilder.append(paramRecentUser.getType());
      localStringBuilder.append(" msgType ");
      localStringBuilder.append(paramRecentUser.msgType);
      localStringBuilder.append(",uin = ");
      localStringBuilder.append(paramRecentUser.uin);
      QLog.d("Q.db.Cache.RecentUserCache", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      a(paramRecentUser.uin, paramRecentUser.getType(), 0);
    }
    removeCache(paramRecentUser);
    RecentUserCacheConfig.b(this.b, paramRecentUser, paramBoolean);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    int[] arrayOfInt = UinTypeUtil.d;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      Object localObject = d(paramString, k);
      if (this.cacheMap.containsKey(localObject))
      {
        localObject = (RecentUser)this.cacheMap.get(localObject);
        if (localObject == null) {
          return;
        }
        if (paramBoolean) {
          a(((RecentUser)localObject).uin, ((RecentUser)localObject).getType(), 0);
        }
        ((RecentUser)localObject).setType(k);
        removeCache((Entity)localObject);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("delRecentUser user: ");
          localStringBuilder.append(d(((RecentUser)localObject).uin));
          localStringBuilder.append(" type ");
          localStringBuilder.append(((RecentUser)localObject).getType());
          localStringBuilder.append(" msgType ");
          localStringBuilder.append(((RecentUser)localObject).msgType);
          QLog.d("Q.db.Cache.RecentUserCache", 2, localStringBuilder.toString());
        }
      }
      i += 1;
    }
  }
  
  public boolean a(String paramString)
  {
    paramString = (ConcurrentHashMap)this.c.get(paramString);
    return (paramString != null) && (!paramString.isEmpty());
  }
  
  public boolean a(String paramString, int paramInt)
  {
    synchronized (this.cacheMap)
    {
      return (RecentUser)this.cacheMap.get(d(paramString, paramInt)) != null;
    }
  }
  
  public RecentUser b(String paramString, int paramInt)
  {
    if ((paramInt >= 0) && (paramString != null)) {
      paramString.length();
    }
    RecentUser localRecentUser = (RecentUser)this.cacheMap.get(d(paramString, paramInt));
    if (localRecentUser == null)
    {
      paramString = new RecentUser(paramString, paramInt);
      paramString.displayName = paramString.uin;
      paramString.parse();
      d(paramString);
      return paramString;
    }
    if (localRecentUser.msg == null)
    {
      if (localRecentUser.mIsParsed)
      {
        localRecentUser.reParse();
        return localRecentUser;
      }
      localRecentUser.parse();
    }
    return localRecentUser;
  }
  
  public void b()
  {
    Handler localHandler = this.g;
    if (localHandler == null) {
      return;
    }
    localHandler.removeCallbacksAndMessages(null);
  }
  
  public void b(RecentUser paramRecentUser)
  {
    b(paramRecentUser, false);
  }
  
  public void b(RecentUser paramRecentUser, boolean paramBoolean)
  {
    if ((paramRecentUser != null) && (paramRecentUser.getType() >= 0) && (paramRecentUser.uin != null) && (paramRecentUser.uin.length() > 2))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveRecentUser user: ");
        localStringBuilder.append(paramRecentUser.uin);
        localStringBuilder.append(" type ");
        localStringBuilder.append(paramRecentUser.getType());
        localStringBuilder.append(" msgType ");
        localStringBuilder.append(paramRecentUser.msgType);
        QLog.d("Q.db.Cache.RecentUserCache", 2, localStringBuilder.toString());
      }
      paramRecentUser = RecentUserCacheConfig.c(this.b, paramRecentUser, paramBoolean);
      if (paramRecentUser == null) {
        return;
      }
      d(paramRecentUser);
      addCache(paramRecentUser);
      if ((paramRecentUser.isHiddenChat != 0) || (!RecentParcelUtil.a(this.b))) {}
    }
    try
    {
      d(paramRecentUser, paramBoolean);
      return;
    }
    catch (Throwable paramRecentUser) {}
    if (paramRecentUser != null) {
      d(paramRecentUser);
    }
    return;
  }
  
  public void b(String paramString)
  {
    Object localObject = (ConcurrentHashMap)this.c.get(paramString);
    if ((localObject != null) && (!((ConcurrentHashMap)localObject).isEmpty())) {
      localObject = ((ConcurrentHashMap)localObject).keySet().iterator();
    }
    for (;;)
    {
      String str;
      if (((Iterator)localObject).hasNext()) {
        str = (String)((Iterator)localObject).next();
      }
      try
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("findRecentUserByUin, uin:");
          localStringBuilder.append(paramString);
          localStringBuilder.append(",type:");
          localStringBuilder.append(str);
          QLog.d("Q.db.Cache.RecentUserCache", 2, localStringBuilder.toString());
        }
        int i = Integer.parseInt(str);
        if (i == 7000) {
          continue;
        }
        a(b(paramString, i));
      }
      catch (Exception localException) {}
      return;
    }
  }
  
  public RecentUser c(String paramString, int paramInt)
  {
    synchronized (this.cacheMap)
    {
      paramString = (RecentUser)this.cacheMap.get(d(paramString, paramInt));
      if (paramString == null) {
        return null;
      }
      if (paramString.msg == null) {
        if (paramString.mIsParsed) {
          paramString.reParse();
        } else {
          paramString.parse();
        }
      }
      return paramString;
    }
  }
  
  public List<RecentUser> c()
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
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, String.format("getHiddenRecentList, size = %s", new Object[] { Integer.valueOf(localArrayList.size()) }));
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.db.Cache.RecentUserCache", 2, "getHiddenCacheList is error!", localException);
      }
    }
    return new ArrayList();
  }
  
  public boolean c(@NonNull RecentUser paramRecentUser)
  {
    synchronized (this.cacheMap)
    {
      boolean bool = this.cacheMap.contains(paramRecentUser);
      return bool;
    }
  }
  
  public boolean c(@NonNull String paramString)
  {
    synchronized (this.cacheMap)
    {
      boolean bool = this.cacheMap.containsKey(paramString);
      return bool;
    }
  }
  
  public void d()
  {
    EntityManager localEntityManager = this.b.getEntityManagerFactory().createEntityManager();
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
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("preLoadTinyRecentUser is called. preCount = ");
      ((StringBuilder)???).append(i);
      ((StringBuilder)???).append(", afterCount = ");
      ((StringBuilder)???).append(this.cacheMap.size());
      QLog.d("Q.db.Cache.RecentUserCache", 2, ((StringBuilder)???).toString());
    }
    GameMsgBoxRuntimeServiceProxy.a(this.b);
    localObject1.close();
  }
  
  protected void destroy() {}
  
  public RecentConvInfo e(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        ArrayList localArrayList = new ArrayList(this.cacheMap.size());
        Object localObject = this.cacheMap.entrySet().iterator();
        if (((Iterator)localObject).hasNext())
        {
          RecentUser localRecentUser = (RecentUser)((Map.Entry)((Iterator)localObject).next()).getValue();
          localRecentUser.parse();
          localArrayList.add(localRecentUser);
          continue;
        }
        Collections.sort(localArrayList, this.d);
        paramString = (RecentUser)this.cacheMap.get(d(paramString, paramInt));
        if (paramString != null)
        {
          i = localArrayList.indexOf(paramString) + 1;
          long l = System.currentTimeMillis() / 1000L;
          paramString = localArrayList.iterator();
          if (!paramString.hasNext()) {
            break label262;
          }
          localObject = (RecentUser)paramString.next();
          if (l - ((RecentUser)localObject).lastmsgtime <= MessageCacheStub.a) {
            continue;
          }
          paramInt = localArrayList.indexOf(localObject) + 1;
          int j = paramInt;
          if (paramInt == -1) {
            j = localArrayList.size();
          }
          paramString = new RecentConvInfo();
          paramString.a = i;
          paramString.b = j;
          paramString.c = localArrayList.size();
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.db.Cache.RecentUserCache", 2, "getRecentConvInfo is error!", paramString);
        }
        return null;
      }
      int i = -1;
      continue;
      label262:
      paramInt = -1;
    }
  }
  
  public boolean e(String paramString)
  {
    boolean bool2 = false;
    if (paramString == null) {
      return false;
    }
    paramString = (ConcurrentHashMap)this.c.get(paramString);
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (!paramString.isEmpty()) {
        if (paramString.containsKey(String.valueOf(7000)))
        {
          bool1 = bool2;
          if (paramString.keySet().size() <= 1) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected final String getKey(Entity paramEntity)
  {
    paramEntity = (RecentUser)paramEntity;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramEntity.uin);
    localStringBuilder.append("&");
    localStringBuilder.append(paramEntity.getType());
    return localStringBuilder.toString();
  }
  
  protected void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.BaseRecentUserCache
 * JD-Core Version:    0.7.0.1
 */