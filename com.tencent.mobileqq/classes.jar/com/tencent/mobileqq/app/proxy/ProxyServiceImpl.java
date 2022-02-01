package com.tencent.mobileqq.app.proxy;

import android.util.SparseArray;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.StatisticCollector;
import mqq.app.AppRuntime;

public class ProxyServiceImpl
  implements IProxyService
{
  public SparseArray<BaseProxy> getBusinessProxy(AppRuntime paramAppRuntime, BaseProxyManager paramBaseProxyManager)
  {
    return new ProxyProvider(paramAppRuntime, paramBaseProxyManager).a();
  }
  
  public boolean getSQLiteSwitchBySample()
  {
    return StatisticCollector.getSqliteSwitchBySample(0);
  }
  
  public boolean isMessageRecord(Object paramObject)
  {
    return paramObject instanceof MessageRecord;
  }
  
  public boolean isSQLiteReportVersion()
  {
    return StatisticCollector.sqlite3Optimizereport();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.ProxyServiceImpl
 * JD-Core Version:    0.7.0.1
 */