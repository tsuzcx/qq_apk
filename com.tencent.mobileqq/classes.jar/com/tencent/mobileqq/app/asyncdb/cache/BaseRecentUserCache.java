package com.tencent.mobileqq.app.asyncdb.cache;

import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.imcore.constants.AppSetting;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.ExceptionTracker;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseRecentUserCache<T extends BaseRecentUser, S extends IMCoreAppRuntime>
  extends FullCache
{
  private static final int RECENTALL_DATA_NUM;
  private static final String TAG = "Q.db.Cache.RecentUserCache";
  protected S app;
  protected Comparator<Entity> comparator = new BaseRecentUserCache.RecentComparator(true);
  Comparator<Entity> comparatorWithoutShowUp = new BaseRecentUserCache.RecentComparator(false);
  protected ConcurrentHashMap<String, ConcurrentHashMap<String, Entity>> uinMap = new ConcurrentHashMap(64);
  
  static
  {
    if (AppSetting.isPublicVersion) {}
    for (int i = 149;; i = 199)
    {
      RECENTALL_DATA_NUM = i;
      return;
    }
  }
  
  public BaseRecentUserCache(S paramS, DBDelayManager paramDBDelayManager, Class<? extends Entity> paramClass)
  {
    super(paramS, paramDBDelayManager, paramClass);
    this.app = paramS;
    this.cacheMap = new BaseRecentUserCache.CacheMap(this, null);
    doOnConstructor();
  }
  
  protected T checkRecentUserNull(T paramT)
  {
    if (paramT.uin == null) {
      paramT.uin = "";
    }
    if (paramT.troopUin == null) {
      paramT.troopUin = "";
    }
    if (paramT.displayName == null) {
      paramT.displayName = "";
    }
    return paramT;
  }
  
  public void clearRecentUser()
  {
    this.cacheMap.clear();
  }
  
  protected abstract T createRecentUserInstance(String paramString, int paramInt);
  
  public void delRecentUser(T paramT)
  {
    delRecentUser(paramT, true);
  }
  
  public void delRecentUser(T paramT, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "delRecentUser user: " + getShortUinStr(paramT.uin) + " type " + paramT.getType() + " msgType " + paramT.msgType + ",uin = " + paramT.uin);
    }
    if (paramBoolean) {
      setUnreadMark(paramT.uin, paramT.getType(), 0);
    }
    removeCache(paramT);
  }
  
  public void deleteRecentUserByType(int paramInt)
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
        if (((BaseRecentUser)((Map.Entry)localIterator.next()).getValue()).getType() == paramInt)
        {
          localIterator.remove();
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache.RecentUserCache", 2, "deleteRecentUserByType remove ru");
          }
        }
      }
    }
  }
  
  public void destroy() {}
  
  protected T doBeforeRealSaveRecentUser(T paramT, boolean paramBoolean)
  {
    return paramT;
  }
  
  protected void doOnConstructor()
  {
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    Object localObject1 = getRecentUserGenerifyClassType();
    Object localObject2 = Integer.toString(RECENTALL_DATA_NUM + 1);
    localObject2 = localEntityManager.query((Class)localObject1, false, "type!=?", new String[0], null, null, "showUpTime desc, lastmsgtime desc", (String)localObject2);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList(20);
    }
    localEntityManager.close();
    filterErrorData((List)localObject1);
    Collections.sort((List)localObject1, this.comparator);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (BaseRecentUser)((Iterator)localObject1).next();
      checkRecentUserNull((BaseRecentUser)localObject2);
      this.cacheMap.put(getKey((Entity)localObject2), localObject2);
    }
  }
  
  protected void filterErrorData(List<T> paramList) {}
  
  protected boolean filterRecentUserOnSave(T paramT)
  {
    return false;
  }
  
  public T findRecentUser(String paramString, int paramInt)
  {
    for (;;)
    {
      synchronized (this.cacheMap)
      {
        paramString = (BaseRecentUser)this.cacheMap.get(getKey(paramString, paramInt));
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
  
  public T findRecentUserByUin(String paramString, int paramInt)
  {
    if (((paramInt < 0) || (paramString == null) || (paramString.length() <= 2)) && ((!AppSetting.isPublicVersion) || (AppSetting.isGrayVersion))) {
      IMCoreProxyRoute.ExceptionTracker.trackException("Q.db.Cache.RecentUserCache", "Save RecentUser with error user: " + paramString + " type " + paramInt);
    }
    BaseRecentUser localBaseRecentUser = (BaseRecentUser)this.cacheMap.get(getKey(paramString, paramInt));
    if (localBaseRecentUser == null)
    {
      paramString = createRecentUserInstance(paramString, paramInt);
      paramString.displayName = paramString.uin;
      paramString.parse();
      checkRecentUserNull(paramString);
    }
    do
    {
      return paramString;
      paramString = localBaseRecentUser;
    } while (localBaseRecentUser.msg != null);
    if (localBaseRecentUser.mIsParsed)
    {
      localBaseRecentUser.reParse();
      return localBaseRecentUser;
    }
    localBaseRecentUser.parse();
    return localBaseRecentUser;
  }
  
  public final String getKey(Entity paramEntity)
  {
    paramEntity = (BaseRecentUser)paramEntity;
    return paramEntity.uin + "&" + paramEntity.getType();
  }
  
  protected final String getKey(String paramString, int paramInt)
  {
    return paramString + "&" + paramInt;
  }
  
  public List<T> getRecentList(boolean paramBoolean)
  {
    return getRecentList(paramBoolean, true);
  }
  
  public List<T> getRecentList(boolean paramBoolean1, boolean paramBoolean2)
  {
    return getRecentList(paramBoolean1, paramBoolean2, true);
  }
  
  public List<T> getRecentList(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.cacheMap.size());
      Iterator localIterator = this.cacheMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        BaseRecentUser localBaseRecentUser = (BaseRecentUser)((Map.Entry)localIterator.next()).getValue();
        localBaseRecentUser.parse();
        if (shouldAddInRecentList(localBaseRecentUser, paramBoolean2)) {
          localArrayList.add(localBaseRecentUser);
        }
      }
      if (!paramBoolean1) {
        break label132;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.db.Cache.RecentUserCache", 2, "getCacheList is error!", localException);
      }
      return new ArrayList();
    }
    if (paramBoolean3)
    {
      Collections.sort(localException, this.comparator);
      label132:
      if (!QLog.isColorLevel()) {
        break label197;
      }
      if (localException != null) {
        break label185;
      }
    }
    label185:
    for (int i = 0;; i = localException.size())
    {
      QLog.d("Q.db.Cache.RecentUserCache", 2, String.format("getRecentList, size = %s", new Object[] { Integer.valueOf(i) }));
      break label197;
      Collections.sort(localException, this.comparatorWithoutShowUp);
      break;
    }
    label197:
    return localException;
  }
  
  protected abstract Class getRecentUserGenerifyClassType();
  
  protected final String getShortUinStr(String paramString)
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
  
  public void init() {}
  
  public boolean isRecentUserInCache(String paramString, int paramInt)
  {
    synchronized (this.cacheMap)
    {
      return (BaseRecentUser)this.cacheMap.get(getKey(paramString, paramInt)) != null;
    }
  }
  
  public boolean isUinInRecent(String paramString)
  {
    paramString = (ConcurrentHashMap)this.uinMap.get(paramString);
    return (paramString != null) && (!paramString.isEmpty());
  }
  
  public void saveRecentUser(T paramT)
  {
    saveRecentUser(paramT, false);
  }
  
  public void saveRecentUser(T paramT, boolean paramBoolean)
  {
    if ((paramT == null) || (paramT.getType() < 0) || (paramT.uin == null) || (paramT.uin.length() <= 2))
    {
      if ((AppSetting.isPublicVersion) && (!AppSetting.isGrayVersion)) {
        break label193;
      }
      if (paramT != null) {
        break label138;
      }
      IMCoreProxyRoute.ExceptionTracker.trackException("Q.db.Cache.RecentUserCache", "Save RecentUser with error user: " + null);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "saveRecentUser user: " + paramT.uin + " type " + paramT.getType() + " msgType " + paramT.msgType);
      }
      if (!filterRecentUserOnSave(paramT)) {
        break;
      }
      return;
      label138:
      IMCoreProxyRoute.ExceptionTracker.trackException("Q.db.Cache.RecentUserCache", "Save RecentUser with error user: " + paramT.uin + " type " + paramT.getType() + " msgType " + paramT.msgType);
    }
    label193:
    checkRecentUserNull(paramT);
    return;
    paramT = doBeforeRealSaveRecentUser(paramT, paramBoolean);
    checkRecentUserNull(paramT);
    addCache(paramT);
  }
  
  protected abstract void setUnreadMark(String paramString, int paramInt1, int paramInt2);
  
  protected boolean shouldAddInRecentList(T paramT, boolean paramBoolean)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.BaseRecentUserCache
 * JD-Core Version:    0.7.0.1
 */