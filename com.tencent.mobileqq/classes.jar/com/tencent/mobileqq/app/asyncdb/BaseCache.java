package com.tencent.mobileqq.app.asyncdb;

import com.tencent.mobileqq.persistence.Entity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseCache
{
  public ConcurrentHashMap<String, Entity> cacheMap;
  protected ArrayList<CacheObserver> cacheObserver;
  protected Class<? extends Entity> clazz;
  protected DBDelayManager proxyManager;
  
  public BaseCache(DBDelayManager paramDBDelayManager, Class<? extends Entity> paramClass)
  {
    this.proxyManager = paramDBDelayManager;
    this.clazz = paramClass;
    this.cacheMap = new ConcurrentHashMap();
    this.cacheObserver = new ArrayList();
  }
  
  public void addCache(Entity paramEntity)
  {
    addCache(paramEntity, 0, null);
  }
  
  public abstract void addCache(Entity paramEntity, int paramInt, ProxyListener paramProxyListener);
  
  public void addObserver(CacheObserver paramCacheObserver)
  {
    if (!this.cacheObserver.contains(paramCacheObserver)) {
      this.cacheObserver.add(paramCacheObserver);
    }
  }
  
  protected abstract void destroy();
  
  public Entity findCache(String paramString)
  {
    return (Entity)this.cacheMap.get(paramString);
  }
  
  protected String getKey(Entity paramEntity)
  {
    return Long.toString(paramEntity.getId());
  }
  
  protected abstract void init();
  
  public void notifyObserver(int paramInt)
  {
    Iterator localIterator = this.cacheObserver.iterator();
    while (localIterator.hasNext()) {
      ((CacheObserver)localIterator.next()).notifyEvent(paramInt);
    }
  }
  
  public void removeCache(Entity paramEntity)
  {
    removeCache(paramEntity, 0, null);
  }
  
  public void removeCache(Entity paramEntity, int paramInt, ProxyListener paramProxyListener)
  {
    String str = getKey(paramEntity);
    if (this.cacheMap.containsKey(str)) {
      this.cacheMap.remove(str);
    }
    this.proxyManager.addQueue(paramEntity, 2, paramInt, paramProxyListener);
  }
  
  public void removeObserver(CacheObserver paramCacheObserver)
  {
    if (this.cacheObserver.contains(paramCacheObserver)) {
      this.cacheObserver.remove(paramCacheObserver);
    }
  }
  
  public void updateCache(Entity paramEntity)
  {
    updateCache(paramEntity, 0, null);
  }
  
  public void updateCache(Entity paramEntity, int paramInt, ProxyListener paramProxyListener)
  {
    String str = getKey(paramEntity);
    this.cacheMap.put(str, paramEntity);
    if (paramEntity.getStatus() == 1000)
    {
      this.proxyManager.addQueue(paramEntity, 0, paramInt, paramProxyListener);
      return;
    }
    this.proxyManager.addQueue(paramEntity, 1, paramInt, paramProxyListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.BaseCache
 * JD-Core Version:    0.7.0.1
 */