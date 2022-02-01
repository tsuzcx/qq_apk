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
  private static AdReqFreshManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdManagerAdReqFreshManager;
  private static final Map<String, Map<Long, Long>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private int jdField_b_of_type_Int;
  private Map<Long, Long> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private AdReqFreshManager()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(373);
    this.jdField_a_of_type_Long = (localAladdinConfig.getIntegerFromString("over_time", 300) * 1000L);
    this.jdField_a_of_type_Int = localAladdinConfig.getIntegerFromString("max_size", 5);
    this.jdField_b_of_type_Int = localAladdinConfig.getIntegerFromString("expose_rate", 20);
  }
  
  public static AdReqFreshManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdManagerAdReqFreshManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdManagerAdReqFreshManager == null) {
          jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdManagerAdReqFreshManager = new AdReqFreshManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdManagerAdReqFreshManager;
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
  
  private static Map<Long, Long> a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "DEFAULT_EMPTY";
    }
    Map localMap = (Map)jdField_a_of_type_JavaUtilMap.get(str);
    paramString = localMap;
    if (localMap == null) {
      paramString = new ConcurrentHashMap();
    }
    jdField_a_of_type_JavaUtilMap.put(str, paramString);
    return paramString;
  }
  
  private void a()
  {
    if (this.jdField_b_of_type_JavaUtilMap.isEmpty()) {
      return;
    }
    long l = System.currentTimeMillis();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (l > ((Long)localEntry.getValue()).longValue() + this.jdField_a_of_type_Long)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeExpiredAd,adId:");
        localStringBuilder.append(localEntry.getKey());
        QLog.i("AdFreshManager", 3, localStringBuilder.toString());
        localIterator.remove();
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_JavaUtilMap.isEmpty()) {
      return;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = jdField_a_of_type_JavaUtilMap.values().iterator();
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
  
  private void c()
  {
    if (this.jdField_b_of_type_JavaUtilMap.size() <= this.jdField_a_of_type_Int) {
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_b_of_type_JavaUtilMap.entrySet());
    Collections.sort(localArrayList, new AdReqFreshManager.1(this));
    int i = this.jdField_a_of_type_Int;
    while (i < localArrayList.size())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeRedundantAd,adId:");
      localStringBuilder.append(((Map.Entry)localArrayList.get(i)).getKey());
      QLog.i("AdFreshManager", 3, localStringBuilder.toString());
      this.jdField_b_of_type_JavaUtilMap.remove(((Map.Entry)localArrayList.get(i)).getKey());
      i += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String a()
  {
    return a(a());
  }
  
  public Set<Long> a()
  {
    try
    {
      a();
      b();
      c();
    }
    catch (Exception localException)
    {
      QLog.e("AdFreshManager", 0, "getRequestAdIds,", localException);
    }
    Set localSet = this.jdField_b_of_type_JavaUtilMap.keySet();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getRequestAdIds,result:");
    localStringBuilder.append(a(localSet));
    QLog.i("AdFreshManager", 3, localStringBuilder.toString());
    return localSet;
  }
  
  public void a(Long paramLong)
  {
    if (paramLong.longValue() == 0L) {
      return;
    }
    Object localObject = jdField_a_of_type_JavaUtilMap.values().iterator();
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
    this.jdField_b_of_type_JavaUtilMap.putAll(a(paramString));
    a(paramString).clear();
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
    a(paramString).put(paramLong, Long.valueOf(System.currentTimeMillis()));
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
        a(paramString).put(localLong, Long.valueOf(l));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdReqFreshManager
 * JD-Core Version:    0.7.0.1
 */