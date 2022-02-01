package com.tencent.mobileqq.app.asyncdb.cache;

import com.tencent.mobileqq.persistence.Entity;
import java.util.concurrent.ConcurrentHashMap;

class BaseRecentUserCache$CacheMap
  extends ConcurrentHashMap<String, Entity>
{
  private BaseRecentUserCache$CacheMap(BaseRecentUserCache paramBaseRecentUserCache) {}
  
  public void clear()
  {
    this.this$0.a.clear();
    super.clear();
  }
  
  public Entity put(String paramString, Entity paramEntity)
  {
    Object localObject1 = paramString.split("&");
    if (localObject1.length >= 2)
    {
      Object localObject2 = localObject1[0];
      Object localObject3 = localObject1[1];
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.this$0.a.get(localObject2);
      localObject1 = localConcurrentHashMap;
      if (localConcurrentHashMap == null)
      {
        localObject1 = new ConcurrentHashMap();
        this.this$0.a.put(localObject2, localObject1);
      }
      ((ConcurrentHashMap)localObject1).put(localObject3, paramEntity);
    }
    return (Entity)super.put(paramString, paramEntity);
  }
  
  public Entity remove(Object paramObject)
  {
    Object localObject2 = ((String)paramObject).split("&");
    if (localObject2.length >= 2)
    {
      Object localObject1 = localObject2[0];
      localObject2 = localObject2[1];
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.this$0.a.get(localObject1);
      if (localConcurrentHashMap != null)
      {
        localConcurrentHashMap.remove(localObject2);
        if (localConcurrentHashMap.isEmpty()) {
          this.this$0.a.remove(localObject1);
        }
      }
    }
    return (Entity)super.remove(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.BaseRecentUserCache.CacheMap
 * JD-Core Version:    0.7.0.1
 */