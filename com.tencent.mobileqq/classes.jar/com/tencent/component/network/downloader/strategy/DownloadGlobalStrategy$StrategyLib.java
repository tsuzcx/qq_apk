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
    ArrayList localArrayList = this.mStrategyList;
    if (localArrayList != null)
    {
      if (paramList == null) {
        return;
      }
      localArrayList.addAll(paramList);
    }
  }
  
  public void copyStrageList()
  {
    ArrayList localArrayList = this.mStrategyList;
    if (localArrayList == null)
    {
      this.mStrategyList = new ArrayList();
      return;
    }
    this.mStrategyList = new ArrayList(localArrayList);
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
    DownloadGlobalStrategy.StrategyInfo localStrategyInfo = this.mBestStrategyInfo;
    if (localStrategyInfo != null) {
      return localStrategyInfo.id;
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
    int k = paramInt;
    if (paramInt < 0) {
      k = 0;
    }
    Object localObject1 = null;
    Object localObject2 = this.mBestStrategyInfo;
    if (localObject2 == null)
    {
      localObject1 = this.mStrategyList;
      localObject1 = (DownloadGlobalStrategy.StrategyInfo)((ArrayList)localObject1).get(k % ((ArrayList)localObject1).size());
    }
    else if (k <= 0)
    {
      localObject1 = localObject2;
    }
    else
    {
      paramInt = ((DownloadGlobalStrategy.StrategyInfo)localObject2).id;
      int i = DownloadGlobalStrategy.Strategy_DomainDirect.id;
      int j = -1;
      if ((paramInt != i) && (this.mBestStrategyInfo.id != DownloadGlobalStrategy.Strategy_BACKUPIP.id) && (this.mBestStrategyInfo.id != DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id))
      {
        if (k == 1) {
          updateStrategyLists();
        }
        paramInt = 0;
        while (paramInt < this.mStrategyList.size())
        {
          if (((DownloadGlobalStrategy.StrategyInfo)this.mStrategyList.get(paramInt)).id == this.mBestStrategyInfo.id) {
            break label174;
          }
          paramInt += 1;
        }
        paramInt = -1;
        label174:
        if ((k > 0) && (k <= paramInt))
        {
          localObject1 = (DownloadGlobalStrategy.StrategyInfo)this.mStrategyList.get(k - 1);
        }
        else
        {
          localObject1 = this.mStrategyList;
          localObject1 = (DownloadGlobalStrategy.StrategyInfo)((ArrayList)localObject1).get(k % ((ArrayList)localObject1).size());
        }
      }
      else
      {
        if (k == 1)
        {
          updateStrategyLists();
          return this.mBestStrategyInfo;
        }
        paramInt = 0;
        i = -1;
        while (paramInt < this.mStrategyList.size())
        {
          int m = i;
          int n = j;
          if (((DownloadGlobalStrategy.StrategyInfo)this.mStrategyList.get(paramInt)).id == this.mBestStrategyInfo.id)
          {
            j = i;
            if (i < 0) {
              j = paramInt;
            }
            n = paramInt;
            m = j;
          }
          paramInt += 1;
          i = m;
          j = n;
        }
        if ((k > 1) && (k <= j))
        {
          localObject1 = (DownloadGlobalStrategy.StrategyInfo)this.mStrategyList.get(k - 2);
        }
        else if (k > j)
        {
          localObject1 = this.mStrategyList;
          localObject1 = (DownloadGlobalStrategy.StrategyInfo)((ArrayList)localObject1).get(k % ((ArrayList)localObject1).size());
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      if (NetworkManager.isWap()) {
        localObject1 = DownloadGlobalStrategy.access$200();
      } else {
        localObject1 = DownloadGlobalStrategy.access$100();
      }
      localObject2 = (DownloadGlobalStrategy.StrategyInfo)((ArrayList)localObject1).get(0);
    }
    return localObject2;
  }
  
  public List<DownloadGlobalStrategy.StrategyInfo> getStrategyList()
  {
    return this.mStrategyList;
  }
  
  public int getSuggestMaxTimes()
  {
    ArrayList localArrayList = this.mStrategyList;
    if (localArrayList != null) {
      return localArrayList.size();
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