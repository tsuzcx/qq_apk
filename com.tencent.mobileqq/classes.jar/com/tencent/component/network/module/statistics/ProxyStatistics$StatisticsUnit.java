package com.tencent.component.network.module.statistics;

import com.tencent.component.network.NetworkManager;

class ProxyStatistics$StatisticsUnit
{
  public boolean allowProxy = false;
  public boolean apnProxy = false;
  
  public ProxyStatistics$StatisticsUnit()
  {
    if (NetworkManager.isWap())
    {
      this.allowProxy = true;
      this.apnProxy = true;
      return;
    }
    this.allowProxy = false;
    this.apnProxy = false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof StatisticsUnit))) {
        return false;
      }
      paramObject = (StatisticsUnit)paramObject;
    } while ((this.allowProxy == paramObject.allowProxy) && (this.apnProxy) && (paramObject.apnProxy));
    return false;
  }
  
  public int hashCode()
  {
    int j = 1;
    int i;
    if (this.allowProxy)
    {
      i = 1;
      if (!this.apnProxy) {
        break label34;
      }
    }
    for (;;)
    {
      return (i + 527) * 31 + j;
      i = 0;
      break;
      label34:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.module.statistics.ProxyStatistics.StatisticsUnit
 * JD-Core Version:    0.7.0.1
 */