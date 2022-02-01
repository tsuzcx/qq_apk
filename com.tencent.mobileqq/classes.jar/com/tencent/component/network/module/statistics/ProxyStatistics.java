package com.tencent.component.network.module.statistics;

import android.content.Context;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.module.statistics.common.FixedLinkedList;
import com.tencent.component.network.utils.NetworkUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ProxyStatistics
{
  private final Map<String, ProxyStatistics.StatisticsUnit> mDominantUnitCache = new HashMap();
  private final Map<String, FixedLinkedList<ProxyStatistics.StatisticsUnit>> mStatisticsCache = new HashMap();
  
  public static ProxyStatistics getInstance()
  {
    return ProxyStatistics.InstanceHolder.INSTANCE;
  }
  
  private void updateStatistics(List<ProxyStatistics.StatisticsUnit> paramList, String paramString)
  {
    if (paramList == null) {
      return;
    }
    synchronized (this.mDominantUnitCache)
    {
      ProxyStatistics.StatisticsUnit localStatisticsUnit2 = (ProxyStatistics.StatisticsUnit)this.mDominantUnitCache.get(paramString);
      ProxyStatistics.StatisticsUnit localStatisticsUnit1 = localStatisticsUnit2;
      if (localStatisticsUnit2 == null)
      {
        localStatisticsUnit1 = new ProxyStatistics.StatisticsUnit();
        this.mDominantUnitCache.put(paramString, localStatisticsUnit1);
      }
      paramList = paramList.iterator();
      boolean bool2 = false;
      int k = 0;
      int j = 0;
      int i = 0;
      while (paramList.hasNext())
      {
        paramString = (ProxyStatistics.StatisticsUnit)paramList.next();
        if (paramString != null)
        {
          int n = k + 1;
          int m = j;
          if (paramString.allowProxy) {
            m = j + 1;
          }
          k = n;
          j = m;
          if (paramString.apnProxy)
          {
            i += 1;
            k = n;
            j = m;
          }
        }
      }
      if (k > 0)
      {
        float f1 = j;
        float f2 = k;
        if (f1 / f2 > 0.5F) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localStatisticsUnit1.allowProxy = bool1;
        boolean bool1 = bool2;
        if (i / f2 > 0.5F) {
          bool1 = true;
        }
        localStatisticsUnit1.apnProxy = bool1;
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public boolean getAPNProxy()
  {
    String str = NetworkManager.getApnValue();
    synchronized (this.mDominantUnitCache)
    {
      ProxyStatistics.StatisticsUnit localStatisticsUnit2 = (ProxyStatistics.StatisticsUnit)this.mDominantUnitCache.get(str);
      ProxyStatistics.StatisticsUnit localStatisticsUnit1 = localStatisticsUnit2;
      if (localStatisticsUnit2 == null)
      {
        localStatisticsUnit1 = new ProxyStatistics.StatisticsUnit();
        this.mDominantUnitCache.put(str, localStatisticsUnit1);
      }
      return localStatisticsUnit1.apnProxy;
    }
  }
  
  public boolean getAllowProxy()
  {
    String str = NetworkManager.getApnValue();
    synchronized (this.mDominantUnitCache)
    {
      ProxyStatistics.StatisticsUnit localStatisticsUnit2 = (ProxyStatistics.StatisticsUnit)this.mDominantUnitCache.get(str);
      ProxyStatistics.StatisticsUnit localStatisticsUnit1 = localStatisticsUnit2;
      if (localStatisticsUnit2 == null)
      {
        localStatisticsUnit1 = new ProxyStatistics.StatisticsUnit();
        this.mDominantUnitCache.put(str, localStatisticsUnit1);
      }
      return localStatisticsUnit1.allowProxy;
    }
  }
  
  public void report(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!NetworkUtils.isMobileConnected(paramContext)) {
      return;
    }
    ProxyStatistics.StatisticsUnit localStatisticsUnit = new ProxyStatistics.StatisticsUnit();
    localStatisticsUnit.allowProxy = paramBoolean1;
    localStatisticsUnit.apnProxy = paramBoolean2;
    synchronized (this.mStatisticsCache)
    {
      String str = NetworkManager.getApnValue();
      FixedLinkedList localFixedLinkedList = (FixedLinkedList)this.mStatisticsCache.get(str);
      paramContext = localFixedLinkedList;
      if (localFixedLinkedList == null)
      {
        paramContext = new FixedLinkedList(3, false);
        this.mStatisticsCache.put(str, paramContext);
      }
      paramContext.add(0, localStatisticsUnit);
      updateStatistics(paramContext, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.module.statistics.ProxyStatistics
 * JD-Core Version:    0.7.0.1
 */