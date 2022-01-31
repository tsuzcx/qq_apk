package com.tencent.mobileqq.app.asyncdb.cache;

import atmo;
import java.util.concurrent.ConcurrentHashMap;

class RecentUserCache$CacheMap
  extends ConcurrentHashMap<String, atmo>
{
  private RecentUserCache$CacheMap(RecentUserCache paramRecentUserCache) {}
  
  public void clear()
  {
    this.this$0.b.clear();
    super.clear();
  }
  
  public atmo put(String paramString, atmo paramatmo)
  {
    Object localObject1 = paramString.split("&");
    if (localObject1.length >= 2)
    {
      Object localObject2 = localObject1[0];
      Object localObject3 = localObject1[1];
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.this$0.b.get(localObject2);
      localObject1 = localConcurrentHashMap;
      if (localConcurrentHashMap == null)
      {
        localObject1 = new ConcurrentHashMap();
        this.this$0.b.put(localObject2, localObject1);
      }
      ((ConcurrentHashMap)localObject1).put(localObject3, paramatmo);
    }
    return (atmo)super.put(paramString, paramatmo);
  }
  
  public atmo remove(Object paramObject)
  {
    Object localObject2 = ((String)paramObject).split("&");
    if (localObject2.length >= 2)
    {
      Object localObject1 = localObject2[0];
      localObject2 = localObject2[1];
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.this$0.b.get(localObject1);
      if (localConcurrentHashMap != null)
      {
        localConcurrentHashMap.remove(localObject2);
        if (localConcurrentHashMap.isEmpty()) {
          this.this$0.b.remove(localObject1);
        }
      }
    }
    return (atmo)super.remove(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache.CacheMap
 * JD-Core Version:    0.7.0.1
 */