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
    boolean bool2 = true;
    if (paramList == null) {
      return;
    }
    for (;;)
    {
      ProxyStatistics.StatisticsUnit localStatisticsUnit;
      int i;
      int k;
      int j;
      synchronized (this.mDominantUnitCache)
      {
        localStatisticsUnit = (ProxyStatistics.StatisticsUnit)this.mDominantUnitCache.get(paramString);
        if (localStatisticsUnit != null) {
          break label223;
        }
        localStatisticsUnit = new ProxyStatistics.StatisticsUnit();
        this.mDominantUnitCache.put(paramString, localStatisticsUnit);
        paramString = localStatisticsUnit;
        paramList = paramList.iterator();
        i = 0;
        k = 0;
        j = 0;
        if (paramList.hasNext())
        {
          localStatisticsUnit = (ProxyStatistics.StatisticsUnit)paramList.next();
          if (localStatisticsUnit == null) {
            continue;
          }
          int m = j + 1;
          j = k;
          if (localStatisticsUnit.allowProxy) {
            j = k + 1;
          }
          if (!localStatisticsUnit.apnProxy) {
            break label220;
          }
          i += 1;
          k = j;
          j = m;
        }
      }
      if (j <= 0) {
        break;
      }
      if (k / j > 0.5F)
      {
        bool1 = true;
        paramString.allowProxy = bool1;
        if (i / j <= 0.5F) {
          break label214;
        }
      }
      label214:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramString.apnProxy = bool1;
        return;
        bool1 = false;
        break;
      }
      label220:
      continue;
      label223:
      paramString = localStatisticsUnit;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.statistics.ProxyStatistics
 * JD-Core Version:    0.7.0.1
 */