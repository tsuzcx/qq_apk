package com.tencent.component.network.downloader.strategy;

import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.module.statistics.ProxyStatistics;
import java.util.ArrayList;
import java.util.List;

public class DownloadGlobalStrategy$StrategyLib
{
  private String mBackupIp;
  private DownloadGlobalStrategy.StrategyInfo mBestStrategyInfo;
  private String mDirectIp;
  private String mDnsIP;
  private DownloadGlobalStrategy.StrategyInfo mOldStrategyInfo;
  private int mPort;
  private ArrayList<DownloadGlobalStrategy.StrategyInfo> mStrategyList;
  private boolean updateEnable = true;
  
  public DownloadGlobalStrategy$StrategyLib(DownloadGlobalStrategy paramDownloadGlobalStrategy)
  {
    ensureData();
    this.mPort = 80;
  }
  
  private void ensureData()
  {
    if (this.mStrategyList != null) {
      return;
    }
    if (!NetworkManager.isWap())
    {
      this.mStrategyList = DownloadGlobalStrategy.access$100();
      return;
    }
    this.mStrategyList = DownloadGlobalStrategy.access$200();
  }
  
  private void updateStrategyLists()
  {
    if (!this.updateEnable) {
      return;
    }
    boolean bool1 = ProxyStatistics.getInstance().getAllowProxy();
    boolean bool2 = ProxyStatistics.getInstance().getAPNProxy();
    if (!bool1)
    {
      this.mStrategyList = DownloadGlobalStrategy.access$100();
      return;
    }
    if (bool2)
    {
      this.mStrategyList = DownloadGlobalStrategy.access$200();
      return;
    }
    this.mStrategyList = DownloadGlobalStrategy.access$300();
  }
  
  public void addStrategy(List<DownloadGlobalStrategy.StrategyInfo> paramList)
  {
    if ((this.mStrategyList == null) || (paramList == null)) {
      return;
    }
    this.mStrategyList.addAll(paramList);
  }
  
  public void copyStrageList()
  {
    if (this.mStrategyList == null)
    {
      this.mStrategyList = new ArrayList();
      return;
    }
    this.mStrategyList = new ArrayList(this.mStrategyList);
  }
  
  public void enableUpdate(boolean paramBoolean)
  {
    this.updateEnable = paramBoolean;
  }
  
  public String getBackupIP()
  {
    return this.mBackupIp;
  }
  
  public int getBestId()
  {
    if (this.mBestStrategyInfo != null) {
      return this.mBestStrategyInfo.id;
    }
    return 0;
  }
  
  public DownloadGlobalStrategy.StrategyInfo getBestStrategy()
  {
    return this.mBestStrategyInfo;
  }
  
  public String getDirectIP()
  {
    return this.mDirectIp;
  }
  
  public String getDnsIP()
  {
    return this.mDnsIP;
  }
  
  public DownloadGlobalStrategy.StrategyInfo getOldStrategyInfo()
  {
    return this.mOldStrategyInfo;
  }
  
  public int getPort()
  {
    return this.mPort;
  }
  
  public DownloadGlobalStrategy.StrategyInfo getStrategyInfo(int paramInt)
  {
    int m = -1;
    int k = paramInt;
    if (paramInt < 0) {
      k = 0;
    }
    if (this.mBestStrategyInfo == null) {}
    for (DownloadGlobalStrategy.StrategyInfo localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.mStrategyList.get(k % this.mStrategyList.size());; localStrategyInfo1 = this.mBestStrategyInfo)
    {
      DownloadGlobalStrategy.StrategyInfo localStrategyInfo2 = localStrategyInfo1;
      if (localStrategyInfo1 == null)
      {
        if (!NetworkManager.isWap()) {
          break label383;
        }
        localStrategyInfo2 = (DownloadGlobalStrategy.StrategyInfo)DownloadGlobalStrategy.access$200().get(0);
      }
      return localStrategyInfo2;
      if (k > 0) {
        break;
      }
    }
    if ((this.mBestStrategyInfo.id != DownloadGlobalStrategy.Strategy_DomainDirect.id) && (this.mBestStrategyInfo.id != DownloadGlobalStrategy.Strategy_BACKUPIP.id) && (this.mBestStrategyInfo.id != DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id))
    {
      if (k == 1) {
        updateStrategyLists();
      }
      paramInt = 0;
      label146:
      if (paramInt >= this.mStrategyList.size()) {
        break label400;
      }
      if (((DownloadGlobalStrategy.StrategyInfo)this.mStrategyList.get(paramInt)).id != this.mBestStrategyInfo.id) {}
    }
    for (;;)
    {
      if ((k > 0) && (k <= paramInt))
      {
        localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.mStrategyList.get(k - 1);
        break;
        paramInt += 1;
        break label146;
      }
      localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.mStrategyList.get(k % this.mStrategyList.size());
      break;
      if (k == 1)
      {
        updateStrategyLists();
        return this.mBestStrategyInfo;
      }
      paramInt = 0;
      int j;
      for (int i = -1; paramInt < this.mStrategyList.size(); i = j)
      {
        j = i;
        if (((DownloadGlobalStrategy.StrategyInfo)this.mStrategyList.get(paramInt)).id == this.mBestStrategyInfo.id)
        {
          j = i;
          if (i < 0) {
            j = paramInt;
          }
          m = paramInt;
        }
        paramInt += 1;
      }
      if ((k > 1) && (k <= m))
      {
        localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.mStrategyList.get(k - 2);
        break;
      }
      if (k > m)
      {
        localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.mStrategyList.get(k % this.mStrategyList.size());
        break;
        label383:
        return (DownloadGlobalStrategy.StrategyInfo)DownloadGlobalStrategy.access$100().get(0);
      }
      localStrategyInfo1 = null;
      break;
      label400:
      paramInt = -1;
    }
  }
  
  public List<DownloadGlobalStrategy.StrategyInfo> getStrategyList()
  {
    return this.mStrategyList;
  }
  
  public int getSuggestMaxTimes()
  {
    if (this.mStrategyList != null) {
      return this.mStrategyList.size();
    }
    return 0;
  }
  
  public void setBackupIP(String paramString)
  {
    this.mBackupIp = paramString;
  }
  
  public void setDirectIP(String paramString)
  {
    this.mDirectIp = paramString;
  }
  
  public void setDnsIP(String paramString)
  {
    this.mDnsIP = paramString;
  }
  
  public void setOldStrategyInfo(DownloadGlobalStrategy.StrategyInfo paramStrategyInfo)
  {
    this.mOldStrategyInfo = paramStrategyInfo;
  }
  
  public void setPort(int paramInt)
  {
    this.mPort = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyLib
 * JD-Core Version:    0.7.0.1
 */