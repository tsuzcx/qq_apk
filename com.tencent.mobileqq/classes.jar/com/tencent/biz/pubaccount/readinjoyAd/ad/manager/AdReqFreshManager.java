package com.tencent.biz.pubaccount.readinjoyAd.ad.manager;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AdReqFreshManager
{
  private static final Map<String, Map<Long, Long>> a = new ConcurrentHashMap();
  private static AdReqFreshManager b;
  private Map<Long, Long> c = new ConcurrentHashMap();
  private long d;
  private int e;
  private int f;
  
  private AdReqFreshManager()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(373);
    this.d = (localAladdinConfig.getIntegerFromString("over_time", 300) * 1000L);
    this.e = localAladdinConfig.getIntegerFromString("max_size", 5);
    this.f = localAladdinConfig.getIntegerFromString("expose_rate", 20);
  }
  
  public static AdReqFreshManager a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new AdReqFreshManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  private static String a(Set<Long> paramSet)
  {
    if ((paramSet != null) && (paramSet.size() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        localStringBuilder.append((Long)paramSet.next());
        localStringBuilder.append(",");
      }
      return localStringBuilder.deleteCharAt(localStringBuilder.length() - 1).toString();
    }
    return "";
  }
  
  private static Map<Long, Long> b(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "DEFAULT_EMPTY";
    }
    Map localMap = (Map)a.get(str);
    paramString = localMap;
    if (localMap == null) {
      paramString = new ConcurrentHashMap();
    }
    a.put(str, paramString);
    return paramString;
  }
  
  private void e()
  {
    if (this.c.isEmpty()) {
      return;
    }
    long l = System.currentTimeMillis();
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (l > ((Long)localEntry.getValue()).longValue() + this.d)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeExpiredAd,adId:");
        localStringBuilder.append(localEntry.getKey());
        QLog.i("AdFreshManager", 3, localStringBuilder.toString());
        localIterator.remove();
      }
    }
  }
  
  private void f()
  {
    if (this.c.isEmpty()) {
      return;
    }
    Iterator localIterator = this.c.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = a.values().iterator();
      if (((Iterator)localObject).hasNext())
      {
        Map localMap = (Map)((Iterator)localObject).next();
        if ((localMap == null) || (!localMap.containsKey(localEntry.getKey()))) {
          break;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("removeRepeatAd,adId:");
        ((StringBuilder)localObject).append(localEntry.getKey());
        QLog.i("AdFreshManager", 3, ((StringBuilder)localObject).toString());
        localIterator.remove();
      }
    }
  }
  
  private void g()
  {
    if (this.c.size() <= this.e) {
      return;
    }
    ArrayList localArrayList = new ArrayList(this.c.entrySet());
    Collections.sort(localArrayList, new AdReqFreshManager.1(this));
    int i = this.e;
    while (i < localArrayList.size())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeRedundantAd,adId:");
      localStringBuilder.append(((Map.Entry)localArrayList.get(i)).getKey());
      QLog.i("AdFreshManager", 3, localStringBuilder.toString());
      this.c.remove(((Map.Entry)localArrayList.get(i)).getKey());
      i += 1;
    }
  }
  
  public void a(Long paramLong)
  {
    if (paramLong.longValue() == 0L) {
      return;
    }
    Object localObject = a.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map localMap = (Map)((Iterator)localObject).next();
      if (localMap != null) {
        localMap.remove(paramLong);
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("removeAdFromAllScene,adId:");
    ((StringBuilder)localObject).append(paramLong);
    QLog.i("AdFreshManager", 3, ((StringBuilder)localObject).toString());
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.c.putAll(b(paramString));
    b(paramString).clear();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("flushSceneAds,scene:");
    localStringBuilder.append(paramString);
    QLog.i("AdFreshManager", 3, localStringBuilder.toString());
  }
  
  public void a(String paramString, Long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    b(paramString).put(paramLong, Long.valueOf(System.currentTimeMillis()));
    paramString = new StringBuilder();
    paramString.append("addAdId,adId:");
    paramString.append(paramLong);
    QLog.i("AdFreshManager", 3, paramString.toString());
  }
  
  public void a(String paramString, Set<Long> paramSet)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramSet != null))
    {
      if (paramSet.isEmpty()) {
        return;
      }
      long l = System.currentTimeMillis();
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        Long localLong = (Long)paramSet.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addAdIds,scene:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(",adId:");
        localStringBuilder.append(localLong);
        QLog.i("AdFreshManager", 3, localStringBuilder.toString());
        b(paramString).put(localLong, Long.valueOf(l));
      }
    }
  }
  
  public int b()
  {
    return this.f;
  }
  
  public Set<Long> c()
  {
    try
    {
      e();
      f();
      g();
    }
    catch (Exception localException)
    {
      QLog.e("AdFreshManager", 0, "getRequestAdIds,", localException);
    }
    Set localSet = this.c.keySet();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getRequestAdIds,result:");
    localStringBuilder.append(a(localSet));
    QLog.i("AdFreshManager", 3, localStringBuilder.toString());
    return localSet;
  }
  
  public String d()
  {
    return a(c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdReqFreshManager
 * JD-Core Version:    0.7.0.1
 */