package com.tencent.mobileqq.app.asyncdb;

import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class BaseCacheManager
  implements Manager
{
  private static final int COUNT_MANAGER = 4;
  public static final int RECENT_USER_CACHE = 1;
  public static final int ROAM_DATA_CACHE = 2;
  private static final String TAG = "Q.db.Cache";
  public static final int TROOP_STATISTICS_CACHE = 3;
  private AppRuntime app;
  int[] baseCache = new int[0];
  private BaseCache[] cacheArray = new BaseCache[4];
  protected DBDelayManager dbDelayManager;
  private boolean isInit = false;
  private boolean isLazyInit = false;
  int[] lazyBaseCache = new int[0];
  
  public BaseCacheManager(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
    this.dbDelayManager = new DBDelayManager(paramAppRuntime);
  }
  
  private void initCaches(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      long l = System.currentTimeMillis();
      BaseCache localBaseCache = getCache(k);
      if (localBaseCache != null)
      {
        localBaseCache.init();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("cacheManager init cache:");
          localStringBuilder.append(localBaseCache.getClass().getName());
          localStringBuilder.append(" cost=");
          localStringBuilder.append(System.currentTimeMillis() - l);
          QLog.d("Q.db.Cache", 2, localStringBuilder.toString());
        }
        localBaseCache.notifyObserver(0);
      }
      i += 1;
    }
  }
  
  protected BaseCache createCacheByName(int paramInt)
  {
    return null;
  }
  
  public BaseCache getCache(int paramInt)
  {
    BaseCache[] arrayOfBaseCache = this.cacheArray;
    BaseCache localBaseCache1 = arrayOfBaseCache[paramInt];
    if (localBaseCache1 == null) {
      try
      {
        localBaseCache1 = this.cacheArray[paramInt];
        if (localBaseCache1 != null) {
          return localBaseCache1;
        }
        long l = System.currentTimeMillis();
        localBaseCache1 = createCacheByName(paramInt);
        if ((localBaseCache1 != null) && (this.cacheArray[paramInt] == null)) {
          this.cacheArray[paramInt] = localBaseCache1;
        }
        if ((QLog.isColorLevel()) && (localBaseCache1 != null))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("get cache instance:");
          localStringBuilder.append(localBaseCache1.getClass().getName());
          localStringBuilder.append(" cost time =[");
          localStringBuilder.append(System.currentTimeMillis() - l);
          localStringBuilder.append("]");
          QLog.d("Q.db.Cache", 2, localStringBuilder.toString());
        }
        return localBaseCache1;
      }
      finally {}
    }
    return localBaseCache2;
  }
  
  public DBDelayManager getDBDelayManager()
  {
    return this.dbDelayManager;
  }
  
  public void init()
  {
    if (this.isInit) {
      return;
    }
    initCaches(this.baseCache);
    this.dbDelayManager.start();
    this.isInit = true;
  }
  
  public void initLazy()
  {
    if (this.isLazyInit) {
      return;
    }
    initCaches(this.lazyBaseCache);
    this.isLazyInit = true;
  }
  
  public void onDestroy()
  {
    int i;
    synchronized (this.cacheArray)
    {
      BaseCache[] arrayOfBaseCache2 = this.cacheArray;
      int j = arrayOfBaseCache2.length;
      i = 0;
      if (i < j)
      {
        BaseCache localBaseCache = arrayOfBaseCache2[i];
        if (localBaseCache != null) {
          localBaseCache.destroy();
        }
      }
      else
      {
        this.dbDelayManager.onDestroy();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.BaseCacheManager
 * JD-Core Version:    0.7.0.1
 */